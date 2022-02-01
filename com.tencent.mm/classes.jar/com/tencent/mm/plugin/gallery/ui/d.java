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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.p;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.WxImageView;
import com.tencent.mm.ui.base.u;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

public final class d
  extends u
{
  private Bitmap cLa;
  int cWU;
  int dBx;
  Context mContext;
  ArrayList<GalleryItem.MediaItem> rGU;
  ArrayList<String> rJb;
  boolean rJc;
  HashSet<String> rJd;
  View rJe;
  boolean rJf;
  private boolean rJg;
  private HashMap<String, WeakReference<b>> rJh;
  public f rJi;
  public e rJj;
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(111516);
    this.rJb = new ArrayList();
    this.rGU = new ArrayList();
    this.rJd = new HashSet();
    this.dBx = -1;
    this.rJe = null;
    this.rJf = false;
    this.rJg = true;
    this.cWU = -1;
    this.cLa = null;
    this.rJh = new HashMap();
    this.rJi = new f(this);
    this.rJj = new e(this);
    this.mContext = paramContext;
    AppMethodBeat.o(111516);
  }
  
  @TargetApi(11)
  protected static void a(b paramb, Bitmap paramBitmap)
  {
    AppMethodBeat.i(111526);
    ad.i("MicroMsg.ImageAdapter", "showImage, trace: %s.", new Object[] { bt.eGN() });
    paramb.rJq.setVisibility(0);
    paramb.rJr.setVisibility(4);
    paramb.rJq.setMaxZoomLimit(4.5F);
    paramb.rJq.setEnableHorLongBmpMode(false);
    p.z(paramb.rJq, paramBitmap.getWidth(), paramBitmap.getHeight());
    paramb.rJq.cH(paramBitmap.getWidth(), paramBitmap.getHeight());
    paramb.rJq.setImageBitmap(paramBitmap);
    paramb.rJq.requestLayout();
    AppMethodBeat.o(111526);
  }
  
  public final MultiTouchImageView Ef(int paramInt)
  {
    AppMethodBeat.i(111521);
    Object localObject = super.OT(paramInt);
    if (localObject == null)
    {
      ad.e("MicroMsg.ImageAdapter", "position : %d getMultiTouchImageViewByPosition view is null.", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(111521);
      return null;
    }
    localObject = (b)((View)localObject).getTag();
    if (localObject == null)
    {
      ad.e("MicroMsg.ImageAdapter", "position : %d getMultiTouchImageViewByPosition holder is null.", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(111521);
      return null;
    }
    if (((b)localObject).rJq.getVisibility() == 8)
    {
      AppMethodBeat.o(111521);
      return null;
    }
    localObject = ((b)localObject).rJq;
    AppMethodBeat.o(111521);
    return localObject;
  }
  
  public final WxImageView Eg(int paramInt)
  {
    AppMethodBeat.i(111522);
    Object localObject = super.OT(paramInt);
    if (localObject == null)
    {
      ad.e("MicroMsg.ImageAdapter", "position : %d getWxImageViewByPosition view is null.", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(111522);
      return null;
    }
    localObject = (b)((View)localObject).getTag();
    if (localObject == null)
    {
      ad.e("MicroMsg.ImageAdapter", "position : %d getWxImageViewByPosition holder is null.", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(111522);
      return null;
    }
    if (((b)localObject).rJr.getVisibility() == 8)
    {
      AppMethodBeat.o(111522);
      return null;
    }
    localObject = ((b)localObject).rJr;
    AppMethodBeat.o(111522);
    return localObject;
  }
  
  public final GalleryItem.MediaItem Eh(int paramInt)
  {
    AppMethodBeat.i(111524);
    if (this.rJc)
    {
      if ((paramInt < 0) || (paramInt >= this.rGU.size()))
      {
        ad.w("MicroMsg.ImageAdapter", "error position %d mediaitems size", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.rGU.size()) });
        AppMethodBeat.o(111524);
        return null;
      }
      localObject = (GalleryItem.MediaItem)this.rGU.get(paramInt);
      AppMethodBeat.o(111524);
      return localObject;
    }
    if ((paramInt < 0) || (paramInt >= this.rJb.size()))
    {
      ad.w("MicroMsg.ImageAdapter", "error position %d, imagePaths size %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.rJb.size()) });
      AppMethodBeat.o(111524);
      return null;
    }
    Object localObject = (String)this.rJb.get(paramInt);
    GalleryItem.MediaItem localMediaItem2 = GalleryItem.MediaItem.a(0, 0L, (String)localObject, (String)localObject, "");
    if (com.tencent.mm.plugin.gallery.model.e.czj() != null)
    {
      paramInt = com.tencent.mm.plugin.gallery.model.e.czj().indexOf(localMediaItem2);
      if (paramInt < 0) {}
    }
    for (localObject = (GalleryItem.MediaItem)com.tencent.mm.plugin.gallery.model.e.czj().get(paramInt);; localObject = null)
    {
      if ((localObject == null) && (!com.tencent.mm.plugin.gallery.model.e.czm().isEmpty()))
      {
        Iterator localIterator = com.tencent.mm.plugin.gallery.model.e.czm().iterator();
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
  
  public final void U(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(111519);
    this.rJb.clear();
    this.rJb.addAll(paramArrayList);
    reset();
    notifyDataSetChanged();
    AppMethodBeat.o(111519);
  }
  
  public final void a(MultiTouchImageView paramMultiTouchImageView, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(111525);
    this.rJd.remove(paramString);
    if (paramMultiTouchImageView != null)
    {
      paramMultiTouchImageView = (b)paramMultiTouchImageView.getTag();
      if (paramMultiTouchImageView != null) {
        if (paramBitmap != null)
        {
          a(paramMultiTouchImageView, paramBitmap);
          if (paramMultiTouchImageView.rJt != null)
          {
            paramMultiTouchImageView.rJt.setText("");
            paramMultiTouchImageView.rJt.setVisibility(8);
            AppMethodBeat.o(111525);
          }
        }
        else
        {
          if ((paramMultiTouchImageView.rJp) && (paramMultiTouchImageView.rJt != null))
          {
            paramMultiTouchImageView.rJt.setText(paramString);
            paramMultiTouchImageView.rJt.setVisibility(0);
            AppMethodBeat.o(111525);
            return;
          }
          if (paramMultiTouchImageView.rJt != null)
          {
            paramMultiTouchImageView.rJt.setText("");
            paramMultiTouchImageView.rJt.setVisibility(8);
          }
        }
      }
    }
    AppMethodBeat.o(111525);
  }
  
  public final void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(111518);
    if (!this.rJc)
    {
      if (paramObject == null)
      {
        ad.e("MicroMsg.ImageAdapter", "[destroyItem] position:%s", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(111518);
        return;
      }
      if (this.rJe != null) {
        ad.i("MicroMsg.ImageAdapter", "[destroyItem] position:%s object:%s lastVisibleView:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramObject.hashCode()), Integer.valueOf(this.rJe.hashCode()) });
      }
      if ((paramObject != this.rJe) || (!this.rJf))
      {
        super.destroyItem(paramViewGroup, paramInt, paramObject);
        paramViewGroup.removeView((View)paramObject);
        AppMethodBeat.o(111518);
        return;
      }
      ad.d("MicroMsg.ImageAdapter", "[isSwap-destroyItem]");
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
    this.rJj.detach();
    AppMethodBeat.o(111528);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(111520);
    if (this.rJc)
    {
      i = this.rGU.size();
      AppMethodBeat.o(111520);
      return i;
    }
    int i = this.rJb.size();
    AppMethodBeat.o(111520);
    return i;
  }
  
  public final String getItem(int paramInt)
  {
    AppMethodBeat.i(111523);
    if (this.rJc)
    {
      if ((paramInt < 0) || (paramInt >= this.rGU.size()))
      {
        ad.w("MicroMsg.ImageAdapter", "error position %d, mediaitems size %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.rGU.size()) });
        AppMethodBeat.o(111523);
        return "";
      }
      str = ((GalleryItem.MediaItem)this.rGU.get(paramInt)).rBp;
      AppMethodBeat.o(111523);
      return str;
    }
    if ((paramInt < 0) || (paramInt >= this.rJb.size()))
    {
      ad.w("MicroMsg.ImageAdapter", "error position %d, imagePaths size %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.rJb.size()) });
      AppMethodBeat.o(111523);
      return "";
    }
    String str = (String)this.rJb.get(paramInt);
    AppMethodBeat.o(111523);
    return str;
  }
  
  public final Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(111517);
    if (!this.rJc)
    {
      ad.i("MicroMsg.ImageAdapter", "[instantiateItem] position:%s %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.dBx) });
      if ((paramInt == this.dBx) && (this.rJf))
      {
        ad.d("MicroMsg.ImageAdapter", "[isSwap-instantiateItem]");
        this.Gbl.put(this.rJe, Integer.valueOf(this.dBx));
        this.Gbm.put(this.dBx, this.rJe);
        this.dBx = -1;
        this.rJf = false;
        paramViewGroup = this.rJe;
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
    this.rJh.clear();
    this.rJd.clear();
    AppMethodBeat.o(111527);
  }
  
  static final class b
  {
    ImageView qkZ;
    boolean rJp = false;
    MultiTouchImageView rJq;
    WxImageView rJr;
    TextView rJs;
    TextView rJt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.d
 * JD-Core Version:    0.7.0.1
 */