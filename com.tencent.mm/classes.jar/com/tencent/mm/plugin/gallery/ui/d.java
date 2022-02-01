package com.tencent.mm.plugin.gallery.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.davemorrissey.labs.subscaleview.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.t.a;
import com.tencent.mm.plugin.thumbplayer.view.ThumbPlayerVideoView;
import com.tencent.mm.sdk.platformtools.ForceGpuUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.WxImageView;
import com.tencent.mm.ui.base.x;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

public final class d
  extends x
{
  ArrayList<GalleryItem.MediaItem> BZG;
  ArrayList<String> CbT;
  boolean CbU;
  private HashSet<String> CbV;
  View CbW;
  boolean CbX;
  private boolean CbY;
  public f CbZ;
  public e Cca;
  int bPt;
  private final Handler cQo;
  int fYT;
  private Bitmap fcd;
  private Context mContext;
  private HashMap<String, WeakReference<b>> noN;
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(111516);
    this.CbT = new ArrayList();
    this.BZG = new ArrayList();
    this.CbV = new HashSet();
    this.fYT = -1;
    this.CbW = null;
    this.CbX = false;
    this.CbY = true;
    this.bPt = -1;
    this.cQo = new d.3(this, Looper.getMainLooper());
    this.fcd = null;
    this.noN = new HashMap();
    this.CbZ = new f(this);
    this.Cca = new e(this);
    this.mContext = paramContext;
    AppMethodBeat.o(111516);
  }
  
  private void a(b paramb)
  {
    AppMethodBeat.i(241000);
    paramb = this.cQo.obtainMessage(1, paramb);
    this.cQo.sendMessageDelayed(paramb, 500L);
    AppMethodBeat.o(241000);
  }
  
  @TargetApi(11)
  protected static void a(b paramb, Bitmap paramBitmap)
  {
    AppMethodBeat.i(111526);
    Log.i("MicroMsg.ImageAdapter", "showImage, trace: %s.", new Object[] { Util.getStack() });
    paramb.Cci.setVisibility(0);
    paramb.Ccj.setVisibility(4);
    paramb.Cci.setMaxZoomLimit(4.5F);
    paramb.Cci.setEnableHorLongBmpMode(false);
    ForceGpuUtil.decideLayerType(paramb.Cci, paramBitmap.getWidth(), paramBitmap.getHeight());
    paramb.Cci.di(paramBitmap.getWidth(), paramBitmap.getHeight());
    paramb.Cci.setImageBitmap(paramBitmap);
    paramb.Cci.requestLayout();
    AppMethodBeat.o(111526);
  }
  
  public static Bitmap aIz(String paramString)
  {
    AppMethodBeat.i(241003);
    long l = Util.currentTicks();
    Bitmap localBitmap = com.tencent.mm.plugin.sns.data.t.aZl(paramString);
    Log.v("MicroMsg.ImageAdapter", "test decode: %d filePath:%s", new Object[] { Long.valueOf(Util.ticksToNow(l)), paramString });
    AppMethodBeat.o(241003);
    return localBitmap;
  }
  
  private void b(b paramb)
  {
    AppMethodBeat.i(241002);
    paramb.Ccl.setVisibility(8);
    paramb.wSa.setVisibility(0);
    paramb.Ccj.setVisibility(0);
    paramb.Cci.setVisibility(0);
    this.cQo.removeMessages(1);
    AppMethodBeat.o(241002);
  }
  
  public final MultiTouchImageView Tf(int paramInt)
  {
    AppMethodBeat.i(111521);
    Object localObject = super.aiI(paramInt);
    if (localObject == null)
    {
      Log.e("MicroMsg.ImageAdapter", "position : %d getMultiTouchImageViewByPosition view is null.", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(111521);
      return null;
    }
    localObject = (b)((View)localObject).getTag();
    if (localObject == null)
    {
      Log.e("MicroMsg.ImageAdapter", "position : %d getMultiTouchImageViewByPosition holder is null.", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(111521);
      return null;
    }
    if (((b)localObject).Cci.getVisibility() == 8)
    {
      AppMethodBeat.o(111521);
      return null;
    }
    localObject = ((b)localObject).Cci;
    AppMethodBeat.o(111521);
    return localObject;
  }
  
  public final WxImageView Tg(int paramInt)
  {
    AppMethodBeat.i(111522);
    Object localObject = super.aiI(paramInt);
    if (localObject == null)
    {
      Log.e("MicroMsg.ImageAdapter", "position : %d getWxImageViewByPosition view is null.", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(111522);
      return null;
    }
    localObject = (b)((View)localObject).getTag();
    if (localObject == null)
    {
      Log.e("MicroMsg.ImageAdapter", "position : %d getWxImageViewByPosition holder is null.", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(111522);
      return null;
    }
    if (((b)localObject).Ccj.getVisibility() == 8)
    {
      AppMethodBeat.o(111522);
      return null;
    }
    localObject = ((b)localObject).Ccj;
    AppMethodBeat.o(111522);
    return localObject;
  }
  
  public final GalleryItem.MediaItem Th(int paramInt)
  {
    AppMethodBeat.i(111524);
    if (this.CbU)
    {
      if ((paramInt < 0) || (paramInt >= this.BZG.size()))
      {
        Log.w("MicroMsg.ImageAdapter", "error position %d mediaitems size", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.BZG.size()) });
        AppMethodBeat.o(111524);
        return null;
      }
      localObject = (GalleryItem.MediaItem)this.BZG.get(paramInt);
      AppMethodBeat.o(111524);
      return localObject;
    }
    if ((paramInt < 0) || (paramInt >= this.CbT.size()))
    {
      Log.w("MicroMsg.ImageAdapter", "error position %d, imagePaths size %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.CbT.size()) });
      AppMethodBeat.o(111524);
      return null;
    }
    Object localObject = (String)this.CbT.get(paramInt);
    GalleryItem.MediaItem localMediaItem2 = GalleryItem.MediaItem.a(0, 0L, (String)localObject, (String)localObject, "");
    if (com.tencent.mm.plugin.gallery.model.e.etn() != null)
    {
      paramInt = com.tencent.mm.plugin.gallery.model.e.etn().indexOf(localMediaItem2);
      if (paramInt < 0) {}
    }
    for (localObject = (GalleryItem.MediaItem)com.tencent.mm.plugin.gallery.model.e.etn().get(paramInt);; localObject = null)
    {
      if ((localObject == null) && (!com.tencent.mm.plugin.gallery.model.e.etq().isEmpty()))
      {
        Iterator localIterator = com.tencent.mm.plugin.gallery.model.e.etq().iterator();
        while (localIterator.hasNext())
        {
          GalleryItem.MediaItem localMediaItem1 = (GalleryItem.MediaItem)localIterator.next();
          if (localMediaItem1.equals(localMediaItem2)) {
            localObject = localMediaItem1;
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(111524);
        return localObject;
      }
    }
  }
  
  public final void a(MultiTouchImageView paramMultiTouchImageView, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(111525);
    Log.i("MicroMsg.ImageAdapter", "onImageGalleryLoaded, bigImgPath: %s, bitmap: %s.", new Object[] { paramString, paramBitmap });
    this.CbV.remove(paramString);
    if (paramMultiTouchImageView != null)
    {
      paramMultiTouchImageView = (b)paramMultiTouchImageView.getTag();
      if (paramMultiTouchImageView != null)
      {
        Log.i("MicroMsg.ImageAdapter", "onImageGalleryLoaded, viewHolder.isImg: %s.", new Object[] { Boolean.valueOf(paramMultiTouchImageView.Cch) });
        if (paramBitmap != null) {
          a(paramMultiTouchImageView, paramBitmap);
        }
      }
    }
    AppMethodBeat.o(111525);
  }
  
  public final void ay(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(111519);
    this.CbT.clear();
    this.CbT.addAll(paramArrayList);
    reset();
    notifyDataSetChanged();
    AppMethodBeat.o(111519);
  }
  
  public final void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(111518);
    if (!this.CbU)
    {
      if (paramObject == null)
      {
        Log.e("MicroMsg.ImageAdapter", "[destroyItem] position:%s", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(111518);
        return;
      }
      if (this.CbW != null) {
        Log.i("MicroMsg.ImageAdapter", "[destroyItem] position:%s object:%s lastVisibleView:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramObject.hashCode()), Integer.valueOf(this.CbW.hashCode()) });
      }
      if ((paramObject != this.CbW) || (!this.CbX))
      {
        super.destroyItem(paramViewGroup, paramInt, paramObject);
        paramViewGroup.removeView((View)paramObject);
        AppMethodBeat.o(111518);
        return;
      }
      Log.d("MicroMsg.ImageAdapter", "[isSwap-destroyItem]");
      AppMethodBeat.o(111518);
      return;
    }
    paramViewGroup.removeView((View)paramObject);
    super.destroyItem(paramViewGroup, paramInt, paramObject);
    AppMethodBeat.o(111518);
  }
  
  public final void detach()
  {
    AppMethodBeat.i(111528);
    stopAll();
    super.detach();
    this.Cca.detach();
    AppMethodBeat.o(111528);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(111520);
    if (this.CbU)
    {
      i = this.BZG.size();
      AppMethodBeat.o(111520);
      return i;
    }
    int i = this.CbT.size();
    AppMethodBeat.o(111520);
    return i;
  }
  
  public final String getItem(int paramInt)
  {
    AppMethodBeat.i(111523);
    if (this.CbU)
    {
      if ((paramInt < 0) || (paramInt >= this.BZG.size()))
      {
        Log.w("MicroMsg.ImageAdapter", "error position %d, mediaitems size %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.BZG.size()) });
        AppMethodBeat.o(111523);
        return "";
      }
      str = ((GalleryItem.MediaItem)this.BZG.get(paramInt)).AAz;
      AppMethodBeat.o(111523);
      return str;
    }
    if ((paramInt < 0) || (paramInt >= this.CbT.size()))
    {
      Log.w("MicroMsg.ImageAdapter", "error position %d, imagePaths size %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.CbT.size()) });
      AppMethodBeat.o(111523);
      return "";
    }
    String str = (String)this.CbT.get(paramInt);
    AppMethodBeat.o(111523);
    return str;
  }
  
  public final Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(111517);
    if (!this.CbU)
    {
      Log.i("MicroMsg.ImageAdapter", "[instantiateItem] position:%s %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.fYT) });
      if ((paramInt == this.fYT) && (this.CbX))
      {
        Log.d("MicroMsg.ImageAdapter", "[isSwap-instantiateItem]");
        this.WnM.put(this.CbW, Integer.valueOf(this.fYT));
        this.WnN.put(this.fYT, this.CbW);
        this.fYT = -1;
        this.CbX = false;
        paramViewGroup = this.CbW;
        AppMethodBeat.o(111517);
        return paramViewGroup;
      }
      paramViewGroup = super.instantiateItem(paramViewGroup, paramInt);
      AppMethodBeat.o(111517);
      return paramViewGroup;
    }
    paramViewGroup = super.instantiateItem(paramViewGroup, paramInt);
    AppMethodBeat.o(111517);
    return paramViewGroup;
  }
  
  public final void release()
  {
    AppMethodBeat.i(111527);
    detach();
    this.noN.clear();
    this.CbV.clear();
    AppMethodBeat.o(111527);
  }
  
  public final void stopAll()
  {
    AppMethodBeat.i(241006);
    Log.w("MicroMsg.ImageAdapter", "stop all video");
    SparseArray localSparseArray = this.WnN;
    int i = 0;
    while (i < localSparseArray.size())
    {
      Object localObject = localSparseArray.valueAt(i);
      if ((localObject instanceof View))
      {
        localObject = (b)((View)localObject).getTag();
        if (((b)localObject).Ccl.isInitialized())
        {
          ((b)localObject).Ccl.stop();
          b((b)localObject);
        }
      }
      i += 1;
    }
    this.cQo.removeMessages(1);
    AppMethodBeat.o(241006);
  }
  
  static final class b
  {
    boolean Cch = false;
    MultiTouchImageView Cci;
    WxImageView Ccj;
    TextView Cck;
    ThumbPlayerVideoView Ccl;
    ImageView wSa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.d
 * JD-Core Version:    0.7.0.1
 */