package com.tencent.mm.plugin.gallery.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.davemorrissey.labs.subscaleview.decoder.ImageDecodeResult;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.u;
import com.tencent.mm.plugin.gallery.model.u.a;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.thumbplayer.view.ThumbPlayerVideoView;
import com.tencent.mm.sdk.platformtools.ForceGpuUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.WxImageView;
import com.tencent.mm.ui.base.ab;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

public final class d
  extends ab
{
  ArrayList<GalleryItem.MediaItem> HLA;
  ArrayList<String> HNV;
  boolean HNW;
  private HashSet<String> HNX;
  View HNY;
  boolean HNZ;
  private boolean HOa;
  public f HOb;
  public e HOc;
  int dIY;
  private final Handler eLs;
  private Bitmap hfN;
  int ieV;
  private Context mContext;
  private HashMap<String, WeakReference<b>> qmf;
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(111516);
    this.HNV = new ArrayList();
    this.HLA = new ArrayList();
    this.HNX = new HashSet();
    this.ieV = -1;
    this.HNY = null;
    this.HNZ = false;
    this.HOa = true;
    this.dIY = -1;
    this.eLs = new Handler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(289529);
        super.handleMessage(paramAnonymousMessage);
        if (paramAnonymousMessage.what == 1)
        {
          paramAnonymousMessage = (d.b)paramAnonymousMessage.obj;
          d.c(d.this, paramAnonymousMessage);
        }
        AppMethodBeat.o(289529);
      }
    };
    this.hfN = null;
    this.qmf = new HashMap();
    this.HOb = new f(this);
    this.HOc = new e(this);
    this.mContext = paramContext;
    AppMethodBeat.o(111516);
  }
  
  private void a(b paramb)
  {
    AppMethodBeat.i(289507);
    paramb = this.eLs.obtainMessage(1, paramb);
    this.eLs.sendMessageDelayed(paramb, 500L);
    AppMethodBeat.o(289507);
  }
  
  protected static void a(b paramb, Bitmap paramBitmap)
  {
    AppMethodBeat.i(111526);
    Log.i("MicroMsg.ImageAdapter", "showImage, trace: %s.", new Object[] { Util.getStack() });
    paramb.HOk.setVisibility(0);
    paramb.HOl.setVisibility(4);
    paramb.HOk.setMaxZoomLimit(4.5F);
    paramb.HOk.setEnableHorLongBmpMode(false);
    ForceGpuUtil.decideLayerType(paramb.HOk, paramBitmap.getWidth(), paramBitmap.getHeight());
    paramb.HOk.dU(paramBitmap.getWidth(), paramBitmap.getHeight());
    paramb.HOk.setImageBitmap(paramBitmap);
    paramb.HOk.requestLayout();
    AppMethodBeat.o(111526);
  }
  
  public static Bitmap aEY(String paramString)
  {
    AppMethodBeat.i(289521);
    long l = Util.currentTicks();
    Bitmap localBitmap = t.aXw(paramString);
    Log.v("MicroMsg.ImageAdapter", "test decode: %d filePath:%s", new Object[] { Long.valueOf(Util.ticksToNow(l)), paramString });
    AppMethodBeat.o(289521);
    return localBitmap;
  }
  
  private void b(b paramb)
  {
    AppMethodBeat.i(289513);
    paramb.HOn.setVisibility(8);
    paramb.AoD.setVisibility(0);
    paramb.HOl.setVisibility(0);
    paramb.HOk.setVisibility(0);
    this.eLs.removeMessages(1);
    AppMethodBeat.o(289513);
  }
  
  public final MultiTouchImageView WN(int paramInt)
  {
    AppMethodBeat.i(111521);
    Object localObject = super.aAZ(paramInt);
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
    if (((b)localObject).HOk.getVisibility() == 8)
    {
      AppMethodBeat.o(111521);
      return null;
    }
    localObject = ((b)localObject).HOk;
    AppMethodBeat.o(111521);
    return localObject;
  }
  
  public final WxImageView WO(int paramInt)
  {
    AppMethodBeat.i(111522);
    Object localObject = super.aAZ(paramInt);
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
    if (((b)localObject).HOl.getVisibility() == 8)
    {
      AppMethodBeat.o(111522);
      return null;
    }
    localObject = ((b)localObject).HOl;
    AppMethodBeat.o(111522);
    return localObject;
  }
  
  public final GalleryItem.MediaItem WP(int paramInt)
  {
    AppMethodBeat.i(111524);
    if (this.HNW)
    {
      if ((paramInt < 0) || (paramInt >= this.HLA.size()))
      {
        Log.w("MicroMsg.ImageAdapter", "error position %d mediaitems size", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.HLA.size()) });
        AppMethodBeat.o(111524);
        return null;
      }
      localObject = (GalleryItem.MediaItem)this.HLA.get(paramInt);
      AppMethodBeat.o(111524);
      return localObject;
    }
    if ((paramInt < 0) || (paramInt >= this.HNV.size()))
    {
      Log.w("MicroMsg.ImageAdapter", "error position %d, imagePaths size %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.HNV.size()) });
      AppMethodBeat.o(111524);
      return null;
    }
    Object localObject = (String)this.HNV.get(paramInt);
    GalleryItem.MediaItem localMediaItem2 = GalleryItem.MediaItem.a(0, 0L, (String)localObject, (String)localObject, "");
    if (com.tencent.mm.plugin.gallery.model.e.fAp() != null)
    {
      paramInt = com.tencent.mm.plugin.gallery.model.e.fAp().indexOf(localMediaItem2);
      if (paramInt < 0) {}
    }
    for (localObject = (GalleryItem.MediaItem)com.tencent.mm.plugin.gallery.model.e.fAp().get(paramInt);; localObject = null)
    {
      if ((localObject == null) && (!com.tencent.mm.plugin.gallery.model.e.fAs().isEmpty()))
      {
        Iterator localIterator = com.tencent.mm.plugin.gallery.model.e.fAs().iterator();
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
    this.HNX.remove(paramString);
    if (paramMultiTouchImageView != null)
    {
      paramMultiTouchImageView = (b)paramMultiTouchImageView.getTag();
      if (paramMultiTouchImageView != null)
      {
        Log.i("MicroMsg.ImageAdapter", "onImageGalleryLoaded, viewHolder.isImg: %s.", new Object[] { Boolean.valueOf(paramMultiTouchImageView.HOj) });
        if (paramBitmap != null) {
          a(paramMultiTouchImageView, paramBitmap);
        }
      }
    }
    AppMethodBeat.o(111525);
  }
  
  public final void aM(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(111519);
    this.HNV.clear();
    this.HNV.addAll(paramArrayList);
    reset();
    notifyDataSetChanged();
    AppMethodBeat.o(111519);
  }
  
  public final void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(111518);
    if (!this.HNW)
    {
      if (paramObject == null)
      {
        Log.e("MicroMsg.ImageAdapter", "[destroyItem] position:%s", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(111518);
        return;
      }
      if (this.HNY != null) {
        Log.i("MicroMsg.ImageAdapter", "[destroyItem] position:%s object:%s lastVisibleView:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramObject.hashCode()), Integer.valueOf(this.HNY.hashCode()) });
      }
      if ((paramObject != this.HNY) || (!this.HNZ))
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
    this.HOc.detach();
    AppMethodBeat.o(111528);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(111520);
    if (this.HNW)
    {
      i = this.HLA.size();
      AppMethodBeat.o(111520);
      return i;
    }
    int i = this.HNV.size();
    AppMethodBeat.o(111520);
    return i;
  }
  
  public final String getItem(int paramInt)
  {
    AppMethodBeat.i(111523);
    if (this.HNW)
    {
      if ((paramInt < 0) || (paramInt >= this.HLA.size()))
      {
        Log.w("MicroMsg.ImageAdapter", "error position %d, mediaitems size %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.HLA.size()) });
        AppMethodBeat.o(111523);
        return "";
      }
      str = ((GalleryItem.MediaItem)this.HLA.get(paramInt)).Gcc;
      AppMethodBeat.o(111523);
      return str;
    }
    if ((paramInt < 0) || (paramInt >= this.HNV.size()))
    {
      Log.w("MicroMsg.ImageAdapter", "error position %d, imagePaths size %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.HNV.size()) });
      AppMethodBeat.o(111523);
      return "";
    }
    String str = (String)this.HNV.get(paramInt);
    AppMethodBeat.o(111523);
    return str;
  }
  
  public final Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(111517);
    if (!this.HNW)
    {
      Log.i("MicroMsg.ImageAdapter", "[instantiateItem] position:%s %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.ieV) });
      if ((paramInt == this.ieV) && (this.HNZ))
      {
        Log.d("MicroMsg.ImageAdapter", "[isSwap-instantiateItem]");
        this.adVb.put(this.HNY, Integer.valueOf(this.ieV));
        this.adVc.put(this.ieV, this.HNY);
        this.ieV = -1;
        this.HNZ = false;
        paramViewGroup = this.HNY;
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
    this.qmf.clear();
    this.HNX.clear();
    AppMethodBeat.o(111527);
  }
  
  public final void stopAll()
  {
    AppMethodBeat.i(289572);
    Log.w("MicroMsg.ImageAdapter", "stop all video");
    SparseArray localSparseArray = this.adVc;
    int i = 0;
    while (i < localSparseArray.size())
    {
      Object localObject = localSparseArray.valueAt(i);
      if ((localObject instanceof View))
      {
        localObject = (b)((View)localObject).getTag();
        if (((b)localObject).HOn.isInitialized())
        {
          ((b)localObject).HOn.stop();
          b((b)localObject);
        }
      }
      i += 1;
    }
    this.eLs.removeMessages(1);
    AppMethodBeat.o(289572);
  }
  
  static final class b
  {
    ImageView AoD;
    boolean HOj = false;
    MultiTouchImageView HOk;
    WxImageView HOl;
    TextView HOm;
    ThumbPlayerVideoView HOn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.d
 * JD-Core Version:    0.7.0.1
 */