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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.r;
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
  private Bitmap cUb;
  int dMM;
  int dgI;
  Context mContext;
  ArrayList<GalleryItem.MediaItem> tWe;
  ArrayList<String> tYl;
  boolean tYm;
  HashSet<String> tYn;
  View tYo;
  boolean tYp;
  private boolean tYq;
  private HashMap<String, WeakReference<b>> tYr;
  public f tYs;
  public e tYt;
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(111516);
    this.tYl = new ArrayList();
    this.tWe = new ArrayList();
    this.tYn = new HashSet();
    this.dMM = -1;
    this.tYo = null;
    this.tYp = false;
    this.tYq = true;
    this.dgI = -1;
    this.cUb = null;
    this.tYr = new HashMap();
    this.tYs = new f(this);
    this.tYt = new e(this);
    this.mContext = paramContext;
    AppMethodBeat.o(111516);
  }
  
  @TargetApi(11)
  protected static void a(b paramb, Bitmap paramBitmap)
  {
    AppMethodBeat.i(111526);
    ae.i("MicroMsg.ImageAdapter", "showImage, trace: %s.", new Object[] { bu.fpN() });
    paramb.tYA.setVisibility(0);
    paramb.tYB.setVisibility(4);
    paramb.tYA.setMaxZoomLimit(4.5F);
    paramb.tYA.setEnableHorLongBmpMode(false);
    r.z(paramb.tYA, paramBitmap.getWidth(), paramBitmap.getHeight());
    paramb.tYA.cH(paramBitmap.getWidth(), paramBitmap.getHeight());
    paramb.tYA.setImageBitmap(paramBitmap);
    paramb.tYA.requestLayout();
    AppMethodBeat.o(111526);
  }
  
  public final MultiTouchImageView HN(int paramInt)
  {
    AppMethodBeat.i(111521);
    Object localObject = super.Tq(paramInt);
    if (localObject == null)
    {
      ae.e("MicroMsg.ImageAdapter", "position : %d getMultiTouchImageViewByPosition view is null.", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(111521);
      return null;
    }
    localObject = (b)((View)localObject).getTag();
    if (localObject == null)
    {
      ae.e("MicroMsg.ImageAdapter", "position : %d getMultiTouchImageViewByPosition holder is null.", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(111521);
      return null;
    }
    if (((b)localObject).tYA.getVisibility() == 8)
    {
      AppMethodBeat.o(111521);
      return null;
    }
    localObject = ((b)localObject).tYA;
    AppMethodBeat.o(111521);
    return localObject;
  }
  
  public final WxImageView HO(int paramInt)
  {
    AppMethodBeat.i(111522);
    Object localObject = super.Tq(paramInt);
    if (localObject == null)
    {
      ae.e("MicroMsg.ImageAdapter", "position : %d getWxImageViewByPosition view is null.", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(111522);
      return null;
    }
    localObject = (b)((View)localObject).getTag();
    if (localObject == null)
    {
      ae.e("MicroMsg.ImageAdapter", "position : %d getWxImageViewByPosition holder is null.", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(111522);
      return null;
    }
    if (((b)localObject).tYB.getVisibility() == 8)
    {
      AppMethodBeat.o(111522);
      return null;
    }
    localObject = ((b)localObject).tYB;
    AppMethodBeat.o(111522);
    return localObject;
  }
  
  public final GalleryItem.MediaItem HP(int paramInt)
  {
    AppMethodBeat.i(111524);
    if (this.tYm)
    {
      if ((paramInt < 0) || (paramInt >= this.tWe.size()))
      {
        ae.w("MicroMsg.ImageAdapter", "error position %d mediaitems size", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.tWe.size()) });
        AppMethodBeat.o(111524);
        return null;
      }
      localObject = (GalleryItem.MediaItem)this.tWe.get(paramInt);
      AppMethodBeat.o(111524);
      return localObject;
    }
    if ((paramInt < 0) || (paramInt >= this.tYl.size()))
    {
      ae.w("MicroMsg.ImageAdapter", "error position %d, imagePaths size %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.tYl.size()) });
      AppMethodBeat.o(111524);
      return null;
    }
    Object localObject = (String)this.tYl.get(paramInt);
    GalleryItem.MediaItem localMediaItem2 = GalleryItem.MediaItem.a(0, 0L, (String)localObject, (String)localObject, "");
    if (com.tencent.mm.plugin.gallery.model.e.cXt() != null)
    {
      paramInt = com.tencent.mm.plugin.gallery.model.e.cXt().indexOf(localMediaItem2);
      if (paramInt < 0) {}
    }
    for (localObject = (GalleryItem.MediaItem)com.tencent.mm.plugin.gallery.model.e.cXt().get(paramInt);; localObject = null)
    {
      if ((localObject == null) && (!com.tencent.mm.plugin.gallery.model.e.cXw().isEmpty()))
      {
        Iterator localIterator = com.tencent.mm.plugin.gallery.model.e.cXw().iterator();
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
    this.tYn.remove(paramString);
    if (paramMultiTouchImageView != null)
    {
      paramMultiTouchImageView = (b)paramMultiTouchImageView.getTag();
      if (paramMultiTouchImageView != null) {
        if (paramBitmap != null)
        {
          a(paramMultiTouchImageView, paramBitmap);
          if (paramMultiTouchImageView.tYD != null)
          {
            paramMultiTouchImageView.tYD.setText("");
            paramMultiTouchImageView.tYD.setVisibility(8);
            AppMethodBeat.o(111525);
          }
        }
        else
        {
          if ((paramMultiTouchImageView.tYz) && (paramMultiTouchImageView.tYD != null))
          {
            paramMultiTouchImageView.tYD.setText(paramString);
            paramMultiTouchImageView.tYD.setVisibility(0);
            AppMethodBeat.o(111525);
            return;
          }
          if (paramMultiTouchImageView.tYD != null)
          {
            paramMultiTouchImageView.tYD.setText("");
            paramMultiTouchImageView.tYD.setVisibility(8);
          }
        }
      }
    }
    AppMethodBeat.o(111525);
  }
  
  public final void ae(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(111519);
    this.tYl.clear();
    this.tYl.addAll(paramArrayList);
    reset();
    notifyDataSetChanged();
    AppMethodBeat.o(111519);
  }
  
  public final void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(111518);
    if (!this.tYm)
    {
      if (paramObject == null)
      {
        ae.e("MicroMsg.ImageAdapter", "[destroyItem] position:%s", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(111518);
        return;
      }
      if (this.tYo != null) {
        ae.i("MicroMsg.ImageAdapter", "[destroyItem] position:%s object:%s lastVisibleView:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramObject.hashCode()), Integer.valueOf(this.tYo.hashCode()) });
      }
      if ((paramObject != this.tYo) || (!this.tYp))
      {
        super.destroyItem(paramViewGroup, paramInt, paramObject);
        paramViewGroup.removeView((View)paramObject);
        AppMethodBeat.o(111518);
        return;
      }
      ae.d("MicroMsg.ImageAdapter", "[isSwap-destroyItem]");
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
    this.tYt.detach();
    AppMethodBeat.o(111528);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(111520);
    if (this.tYm)
    {
      i = this.tWe.size();
      AppMethodBeat.o(111520);
      return i;
    }
    int i = this.tYl.size();
    AppMethodBeat.o(111520);
    return i;
  }
  
  public final String getItem(int paramInt)
  {
    AppMethodBeat.i(111523);
    if (this.tYm)
    {
      if ((paramInt < 0) || (paramInt >= this.tWe.size()))
      {
        ae.w("MicroMsg.ImageAdapter", "error position %d, mediaitems size %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.tWe.size()) });
        AppMethodBeat.o(111523);
        return "";
      }
      str = ((GalleryItem.MediaItem)this.tWe.get(paramInt)).tRJ;
      AppMethodBeat.o(111523);
      return str;
    }
    if ((paramInt < 0) || (paramInt >= this.tYl.size()))
    {
      ae.w("MicroMsg.ImageAdapter", "error position %d, imagePaths size %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.tYl.size()) });
      AppMethodBeat.o(111523);
      return "";
    }
    String str = (String)this.tYl.get(paramInt);
    AppMethodBeat.o(111523);
    return str;
  }
  
  public final Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(111517);
    if (!this.tYm)
    {
      ae.i("MicroMsg.ImageAdapter", "[instantiateItem] position:%s %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.dMM) });
      if ((paramInt == this.dMM) && (this.tYp))
      {
        ae.d("MicroMsg.ImageAdapter", "[isSwap-instantiateItem]");
        this.JJG.put(this.tYo, Integer.valueOf(this.dMM));
        this.JJH.put(this.dMM, this.tYo);
        this.dMM = -1;
        this.tYp = false;
        paramViewGroup = this.tYo;
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
    this.tYr.clear();
    this.tYn.clear();
    AppMethodBeat.o(111527);
  }
  
  static final class b
  {
    ImageView rLP;
    MultiTouchImageView tYA;
    WxImageView tYB;
    TextView tYC;
    TextView tYD;
    boolean tYz = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.d
 * JD-Core Version:    0.7.0.1
 */