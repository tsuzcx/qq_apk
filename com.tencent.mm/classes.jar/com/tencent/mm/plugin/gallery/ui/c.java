package com.tencent.mm.plugin.gallery.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.R.h;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.WxImageView;
import com.tencent.mm.ui.base.t;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public final class c
  extends t
{
  private Bitmap bwa = null;
  ArrayList<GalleryItem.MediaItem> kHC = new ArrayList();
  ArrayList<String> kIV = new ArrayList();
  boolean kIW;
  HashSet<String> kIX = new HashSet();
  int kIY = -1;
  View kIZ = null;
  boolean kJa = false;
  private HashMap<String, WeakReference<c.b>> kJb = new HashMap();
  public e kJc = new e(this);
  public d kJd = new d(this);
  Context mContext;
  
  public c(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  @TargetApi(11)
  static void a(MultiTouchImageView paramMultiTouchImageView, Bitmap paramBitmap)
  {
    paramMultiTouchImageView.setMaxZoomLimit(4.5F);
    paramMultiTouchImageView.setEnableHorLongBmpMode(false);
    if (Build.VERSION.SDK_INT == 20) {
      paramMultiTouchImageView.setLayerType(1, null);
    }
    for (;;)
    {
      paramMultiTouchImageView.fs(paramBitmap.getWidth(), paramBitmap.getHeight());
      paramMultiTouchImageView.setImageBitmap(paramBitmap);
      paramMultiTouchImageView.requestLayout();
      return;
      k.o(paramMultiTouchImageView, paramBitmap.getWidth(), paramBitmap.getHeight());
    }
  }
  
  public final void D(ArrayList<String> paramArrayList)
  {
    this.kIV.clear();
    this.kIV = new ArrayList();
    this.kIV.addAll(paramArrayList);
    reset();
    notifyDataSetChanged();
  }
  
  public final void a(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    if (!this.kIW)
    {
      if (paramObject == null)
      {
        y.e("MicroMsg.ImageAdapter", "[destroyItem] position:%s", new Object[] { Integer.valueOf(paramInt) });
        return;
      }
      if (this.kIZ != null) {
        y.i("MicroMsg.ImageAdapter", "[destroyItem] position:%s object:%s lastVisableView:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramObject.hashCode()), Integer.valueOf(this.kIZ.hashCode()) });
      }
      if ((paramObject != this.kIZ) || (!this.kJa))
      {
        super.a(paramViewGroup, paramInt, paramObject);
        paramViewGroup.removeView((View)paramObject);
        return;
      }
      y.d("MicroMsg.ImageAdapter", "[isSwap-destroyItem]");
      return;
    }
    super.a(paramViewGroup, paramInt, paramObject);
  }
  
  public final Object b(ViewGroup paramViewGroup, int paramInt)
  {
    if (!this.kIW)
    {
      y.i("MicroMsg.ImageAdapter", "[instantiateItem] position:%s %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.kIY) });
      if ((paramInt == this.kIY) && (this.kJa))
      {
        y.d("MicroMsg.ImageAdapter", "[isSwap-instantiateItem]");
        this.uZv.put(this.kIZ, Integer.valueOf(this.kIY));
        this.uZw.put(this.kIY, this.kIZ);
        this.kIY = -1;
        this.kJa = false;
        return this.kIZ;
      }
      return super.b(paramViewGroup, paramInt);
    }
    return super.b(paramViewGroup, paramInt);
  }
  
  public final void detach()
  {
    super.detach();
    d locald = this.kJd;
    locald.kJw = null;
    locald.kJp.clear();
    locald.kJs.clear();
    locald.kJr.clear();
    locald.kJq.clear();
    locald.aXQ();
  }
  
  public final int getCount()
  {
    if (this.kIW) {
      return this.kHC.size();
    }
    return this.kIV.size();
  }
  
  public final String ke(int paramInt)
  {
    if (this.kIW)
    {
      if ((paramInt < 0) || (paramInt >= this.kHC.size()))
      {
        y.w("MicroMsg.ImageAdapter", "error position %d, mediaitems size %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.kHC.size()) });
        return "";
      }
      return ((GalleryItem.MediaItem)this.kHC.get(paramInt)).eAu;
    }
    if ((paramInt < 0) || (paramInt >= this.kIV.size()))
    {
      y.w("MicroMsg.ImageAdapter", "error position %d, imagePaths size %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.kIV.size()) });
      return "";
    }
    return (String)this.kIV.get(paramInt);
  }
  
  public final MultiTouchImageView rX(int paramInt)
  {
    View localView = super.Gs(paramInt);
    if (localView == null)
    {
      y.e("MicroMsg.ImageAdapter", "position : %s getMultiTouchImageViewByPosition is null", new Object[] { Integer.valueOf(paramInt) });
      return null;
    }
    if ((localView == null) || (localView.getVisibility() == 8)) {
      return null;
    }
    localView = localView.findViewById(R.h.image);
    if (localView == null) {
      return null;
    }
    return (MultiTouchImageView)localView;
  }
  
  public final WxImageView rY(int paramInt)
  {
    return null;
  }
  
  public final GalleryItem.MediaItem rZ(int paramInt)
  {
    if (this.kIW) {
      if ((paramInt < 0) || (paramInt >= this.kHC.size())) {
        y.w("MicroMsg.ImageAdapter", "error position %d mediaitems size", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.kHC.size()) });
      }
    }
    do
    {
      do
      {
        return null;
        return (GalleryItem.MediaItem)this.kHC.get(paramInt);
        if ((paramInt < 0) || (paramInt >= this.kIV.size()))
        {
          y.w("MicroMsg.ImageAdapter", "error position %d, imagePaths size %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.kIV.size()) });
          return null;
        }
        localObject = (String)this.kIV.get(paramInt);
      } while (com.tencent.mm.plugin.gallery.model.c.aXd() == null);
      Object localObject = GalleryItem.MediaItem.a(0, 0L, (String)localObject, (String)localObject, "");
      paramInt = com.tencent.mm.plugin.gallery.model.c.aXd().indexOf(localObject);
    } while (paramInt < 0);
    return (GalleryItem.MediaItem)com.tencent.mm.plugin.gallery.model.c.aXd().get(paramInt);
  }
  
  public final void release()
  {
    detach();
    this.kJb.clear();
    this.kIX.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.c
 * JD-Core Version:    0.7.0.1
 */