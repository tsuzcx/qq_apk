package com.tencent.mm.plugin.gallery.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.a.b;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.t;
import com.tencent.mm.plugin.gallery.model.t.a;
import com.tencent.mm.sdk.platformtools.ForceGpuUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.WxImageView;
import com.tencent.mm.ui.base.v;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

public final class d
  extends v
{
  int bNu;
  private Bitmap dku;
  int eeE;
  private HashMap<String, WeakReference<b>> kwA;
  Context mContext;
  ArrayList<GalleryItem.MediaItem> xno;
  boolean xpA;
  HashSet<String> xpB;
  View xpC;
  boolean xpD;
  private boolean xpE;
  public f xpF;
  public e xpG;
  ArrayList<String> xpz;
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(111516);
    this.xpz = new ArrayList();
    this.xno = new ArrayList();
    this.xpB = new HashSet();
    this.eeE = -1;
    this.xpC = null;
    this.xpD = false;
    this.xpE = true;
    this.bNu = -1;
    this.dku = null;
    this.kwA = new HashMap();
    this.xpF = new f(this);
    this.xpG = new e(this);
    this.mContext = paramContext;
    AppMethodBeat.o(111516);
  }
  
  @TargetApi(11)
  protected static void a(b paramb, Bitmap paramBitmap)
  {
    AppMethodBeat.i(111526);
    Log.i("MicroMsg.ImageAdapter", "showImage, trace: %s.", new Object[] { Util.getStack() });
    paramb.xpN.setVisibility(0);
    paramb.xpO.setVisibility(4);
    paramb.xpN.setMaxZoomLimit(4.5F);
    paramb.xpN.setEnableHorLongBmpMode(false);
    ForceGpuUtil.decideLayerType(paramb.xpN, paramBitmap.getWidth(), paramBitmap.getHeight());
    paramb.xpN.cN(paramBitmap.getWidth(), paramBitmap.getHeight());
    paramb.xpN.setImageBitmap(paramBitmap);
    paramb.xpN.requestLayout();
    AppMethodBeat.o(111526);
  }
  
  public final MultiTouchImageView NQ(int paramInt)
  {
    AppMethodBeat.i(111521);
    Object localObject = super.abm(paramInt);
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
    if (((b)localObject).xpN.getVisibility() == 8)
    {
      AppMethodBeat.o(111521);
      return null;
    }
    localObject = ((b)localObject).xpN;
    AppMethodBeat.o(111521);
    return localObject;
  }
  
  public final WxImageView NR(int paramInt)
  {
    AppMethodBeat.i(111522);
    Object localObject = super.abm(paramInt);
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
    if (((b)localObject).xpO.getVisibility() == 8)
    {
      AppMethodBeat.o(111522);
      return null;
    }
    localObject = ((b)localObject).xpO;
    AppMethodBeat.o(111522);
    return localObject;
  }
  
  public final GalleryItem.MediaItem NS(int paramInt)
  {
    AppMethodBeat.i(111524);
    if (this.xpA)
    {
      if ((paramInt < 0) || (paramInt >= this.xno.size()))
      {
        Log.w("MicroMsg.ImageAdapter", "error position %d mediaitems size", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.xno.size()) });
        AppMethodBeat.o(111524);
        return null;
      }
      localObject = (GalleryItem.MediaItem)this.xno.get(paramInt);
      AppMethodBeat.o(111524);
      return localObject;
    }
    if ((paramInt < 0) || (paramInt >= this.xpz.size()))
    {
      Log.w("MicroMsg.ImageAdapter", "error position %d, imagePaths size %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.xpz.size()) });
      AppMethodBeat.o(111524);
      return null;
    }
    Object localObject = (String)this.xpz.get(paramInt);
    GalleryItem.MediaItem localMediaItem2 = GalleryItem.MediaItem.a(0, 0L, (String)localObject, (String)localObject, "");
    if (com.tencent.mm.plugin.gallery.model.e.dQM() != null)
    {
      paramInt = com.tencent.mm.plugin.gallery.model.e.dQM().indexOf(localMediaItem2);
      if (paramInt < 0) {}
    }
    for (localObject = (GalleryItem.MediaItem)com.tencent.mm.plugin.gallery.model.e.dQM().get(paramInt);; localObject = null)
    {
      if ((localObject == null) && (!com.tencent.mm.plugin.gallery.model.e.dQP().isEmpty()))
      {
        Iterator localIterator = com.tencent.mm.plugin.gallery.model.e.dQP().iterator();
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
    this.xpB.remove(paramString);
    if (paramMultiTouchImageView != null)
    {
      paramMultiTouchImageView = (b)paramMultiTouchImageView.getTag();
      if (paramMultiTouchImageView != null) {
        if (paramBitmap != null)
        {
          a(paramMultiTouchImageView, paramBitmap);
          if (paramMultiTouchImageView.xpQ != null)
          {
            paramMultiTouchImageView.xpQ.setText("");
            paramMultiTouchImageView.xpQ.setVisibility(8);
            AppMethodBeat.o(111525);
          }
        }
        else
        {
          if ((paramMultiTouchImageView.xpM) && (paramMultiTouchImageView.xpQ != null))
          {
            paramMultiTouchImageView.xpQ.setText(paramString);
            paramMultiTouchImageView.xpQ.setVisibility(0);
            AppMethodBeat.o(111525);
            return;
          }
          if (paramMultiTouchImageView.xpQ != null)
          {
            paramMultiTouchImageView.xpQ.setText("");
            paramMultiTouchImageView.xpQ.setVisibility(8);
          }
        }
      }
    }
    AppMethodBeat.o(111525);
  }
  
  public final void as(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(111519);
    this.xpz.clear();
    this.xpz.addAll(paramArrayList);
    reset();
    notifyDataSetChanged();
    AppMethodBeat.o(111519);
  }
  
  public final void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(111518);
    if (!this.xpA)
    {
      if (paramObject == null)
      {
        Log.e("MicroMsg.ImageAdapter", "[destroyItem] position:%s", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(111518);
        return;
      }
      if (this.xpC != null) {
        Log.i("MicroMsg.ImageAdapter", "[destroyItem] position:%s object:%s lastVisibleView:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramObject.hashCode()), Integer.valueOf(this.xpC.hashCode()) });
      }
      if ((paramObject != this.xpC) || (!this.xpD))
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
    super.detach();
    this.xpG.detach();
    AppMethodBeat.o(111528);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(111520);
    if (this.xpA)
    {
      i = this.xno.size();
      AppMethodBeat.o(111520);
      return i;
    }
    int i = this.xpz.size();
    AppMethodBeat.o(111520);
    return i;
  }
  
  public final String getItem(int paramInt)
  {
    AppMethodBeat.i(111523);
    if (this.xpA)
    {
      if ((paramInt < 0) || (paramInt >= this.xno.size()))
      {
        Log.w("MicroMsg.ImageAdapter", "error position %d, mediaitems size %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.xno.size()) });
        AppMethodBeat.o(111523);
        return "";
      }
      str = ((GalleryItem.MediaItem)this.xno.get(paramInt)).xiW;
      AppMethodBeat.o(111523);
      return str;
    }
    if ((paramInt < 0) || (paramInt >= this.xpz.size()))
    {
      Log.w("MicroMsg.ImageAdapter", "error position %d, imagePaths size %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.xpz.size()) });
      AppMethodBeat.o(111523);
      return "";
    }
    String str = (String)this.xpz.get(paramInt);
    AppMethodBeat.o(111523);
    return str;
  }
  
  public final Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(111517);
    if (!this.xpA)
    {
      Log.i("MicroMsg.ImageAdapter", "[instantiateItem] position:%s %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.eeE) });
      if ((paramInt == this.eeE) && (this.xpD))
      {
        Log.d("MicroMsg.ImageAdapter", "[isSwap-instantiateItem]");
        this.OUz.put(this.xpC, Integer.valueOf(this.eeE));
        this.OUA.put(this.eeE, this.xpC);
        this.eeE = -1;
        this.xpD = false;
        paramViewGroup = this.xpC;
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
    this.kwA.clear();
    this.xpB.clear();
    AppMethodBeat.o(111527);
  }
  
  static final class b
  {
    ImageView tlC;
    boolean xpM = false;
    MultiTouchImageView xpN;
    WxImageView xpO;
    TextView xpP;
    TextView xpQ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.d
 * JD-Core Version:    0.7.0.1
 */