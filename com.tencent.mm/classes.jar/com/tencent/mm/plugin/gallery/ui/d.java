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
import com.tencent.mm.sdk.platformtools.q;
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
  private Bitmap cTq;
  int dLx;
  int dfG;
  Context mContext;
  ArrayList<GalleryItem.MediaItem> tLn;
  private HashMap<String, WeakReference<b>> tNA;
  public f tNB;
  public e tNC;
  ArrayList<String> tNu;
  boolean tNv;
  HashSet<String> tNw;
  View tNx;
  boolean tNy;
  private boolean tNz;
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(111516);
    this.tNu = new ArrayList();
    this.tLn = new ArrayList();
    this.tNw = new HashSet();
    this.dLx = -1;
    this.tNx = null;
    this.tNy = false;
    this.tNz = true;
    this.dfG = -1;
    this.cTq = null;
    this.tNA = new HashMap();
    this.tNB = new f(this);
    this.tNC = new e(this);
    this.mContext = paramContext;
    AppMethodBeat.o(111516);
  }
  
  @TargetApi(11)
  protected static void a(b paramb, Bitmap paramBitmap)
  {
    AppMethodBeat.i(111526);
    ad.i("MicroMsg.ImageAdapter", "showImage, trace: %s.", new Object[] { bt.flS() });
    paramb.tNJ.setVisibility(0);
    paramb.tNK.setVisibility(4);
    paramb.tNJ.setMaxZoomLimit(4.5F);
    paramb.tNJ.setEnableHorLongBmpMode(false);
    q.A(paramb.tNJ, paramBitmap.getWidth(), paramBitmap.getHeight());
    paramb.tNJ.cH(paramBitmap.getWidth(), paramBitmap.getHeight());
    paramb.tNJ.setImageBitmap(paramBitmap);
    paramb.tNJ.requestLayout();
    AppMethodBeat.o(111526);
  }
  
  public final MultiTouchImageView Hq(int paramInt)
  {
    AppMethodBeat.i(111521);
    Object localObject = super.SJ(paramInt);
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
    if (((b)localObject).tNJ.getVisibility() == 8)
    {
      AppMethodBeat.o(111521);
      return null;
    }
    localObject = ((b)localObject).tNJ;
    AppMethodBeat.o(111521);
    return localObject;
  }
  
  public final WxImageView Hr(int paramInt)
  {
    AppMethodBeat.i(111522);
    Object localObject = super.SJ(paramInt);
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
    if (((b)localObject).tNK.getVisibility() == 8)
    {
      AppMethodBeat.o(111522);
      return null;
    }
    localObject = ((b)localObject).tNK;
    AppMethodBeat.o(111522);
    return localObject;
  }
  
  public final GalleryItem.MediaItem Hs(int paramInt)
  {
    AppMethodBeat.i(111524);
    if (this.tNv)
    {
      if ((paramInt < 0) || (paramInt >= this.tLn.size()))
      {
        ad.w("MicroMsg.ImageAdapter", "error position %d mediaitems size", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.tLn.size()) });
        AppMethodBeat.o(111524);
        return null;
      }
      localObject = (GalleryItem.MediaItem)this.tLn.get(paramInt);
      AppMethodBeat.o(111524);
      return localObject;
    }
    if ((paramInt < 0) || (paramInt >= this.tNu.size()))
    {
      ad.w("MicroMsg.ImageAdapter", "error position %d, imagePaths size %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.tNu.size()) });
      AppMethodBeat.o(111524);
      return null;
    }
    Object localObject = (String)this.tNu.get(paramInt);
    GalleryItem.MediaItem localMediaItem2 = GalleryItem.MediaItem.a(0, 0L, (String)localObject, (String)localObject, "");
    if (com.tencent.mm.plugin.gallery.model.e.cUO() != null)
    {
      paramInt = com.tencent.mm.plugin.gallery.model.e.cUO().indexOf(localMediaItem2);
      if (paramInt < 0) {}
    }
    for (localObject = (GalleryItem.MediaItem)com.tencent.mm.plugin.gallery.model.e.cUO().get(paramInt);; localObject = null)
    {
      if ((localObject == null) && (!com.tencent.mm.plugin.gallery.model.e.cUR().isEmpty()))
      {
        Iterator localIterator = com.tencent.mm.plugin.gallery.model.e.cUR().iterator();
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
    this.tNw.remove(paramString);
    if (paramMultiTouchImageView != null)
    {
      paramMultiTouchImageView = (b)paramMultiTouchImageView.getTag();
      if (paramMultiTouchImageView != null) {
        if (paramBitmap != null)
        {
          a(paramMultiTouchImageView, paramBitmap);
          if (paramMultiTouchImageView.tNM != null)
          {
            paramMultiTouchImageView.tNM.setText("");
            paramMultiTouchImageView.tNM.setVisibility(8);
            AppMethodBeat.o(111525);
          }
        }
        else
        {
          if ((paramMultiTouchImageView.tNI) && (paramMultiTouchImageView.tNM != null))
          {
            paramMultiTouchImageView.tNM.setText(paramString);
            paramMultiTouchImageView.tNM.setVisibility(0);
            AppMethodBeat.o(111525);
            return;
          }
          if (paramMultiTouchImageView.tNM != null)
          {
            paramMultiTouchImageView.tNM.setText("");
            paramMultiTouchImageView.tNM.setVisibility(8);
          }
        }
      }
    }
    AppMethodBeat.o(111525);
  }
  
  public final void ae(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(111519);
    this.tNu.clear();
    this.tNu.addAll(paramArrayList);
    reset();
    notifyDataSetChanged();
    AppMethodBeat.o(111519);
  }
  
  public final void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(111518);
    if (!this.tNv)
    {
      if (paramObject == null)
      {
        ad.e("MicroMsg.ImageAdapter", "[destroyItem] position:%s", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(111518);
        return;
      }
      if (this.tNx != null) {
        ad.i("MicroMsg.ImageAdapter", "[destroyItem] position:%s object:%s lastVisibleView:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramObject.hashCode()), Integer.valueOf(this.tNx.hashCode()) });
      }
      if ((paramObject != this.tNx) || (!this.tNy))
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
    this.tNC.detach();
    AppMethodBeat.o(111528);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(111520);
    if (this.tNv)
    {
      i = this.tLn.size();
      AppMethodBeat.o(111520);
      return i;
    }
    int i = this.tNu.size();
    AppMethodBeat.o(111520);
    return i;
  }
  
  public final String getItem(int paramInt)
  {
    AppMethodBeat.i(111523);
    if (this.tNv)
    {
      if ((paramInt < 0) || (paramInt >= this.tLn.size()))
      {
        ad.w("MicroMsg.ImageAdapter", "error position %d, mediaitems size %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.tLn.size()) });
        AppMethodBeat.o(111523);
        return "";
      }
      str = ((GalleryItem.MediaItem)this.tLn.get(paramInt)).tGS;
      AppMethodBeat.o(111523);
      return str;
    }
    if ((paramInt < 0) || (paramInt >= this.tNu.size()))
    {
      ad.w("MicroMsg.ImageAdapter", "error position %d, imagePaths size %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.tNu.size()) });
      AppMethodBeat.o(111523);
      return "";
    }
    String str = (String)this.tNu.get(paramInt);
    AppMethodBeat.o(111523);
    return str;
  }
  
  public final Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(111517);
    if (!this.tNv)
    {
      ad.i("MicroMsg.ImageAdapter", "[instantiateItem] position:%s %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.dLx) });
      if ((paramInt == this.dLx) && (this.tNy))
      {
        ad.d("MicroMsg.ImageAdapter", "[isSwap-instantiateItem]");
        this.JoR.put(this.tNx, Integer.valueOf(this.dLx));
        this.JoS.put(this.dLx, this.tNx);
        this.dLx = -1;
        this.tNy = false;
        paramViewGroup = this.tNx;
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
    this.tNA.clear();
    this.tNw.clear();
    AppMethodBeat.o(111527);
  }
  
  static final class b
  {
    ImageView rDE;
    boolean tNI = false;
    MultiTouchImageView tNJ;
    WxImageView tNK;
    TextView tNL;
    TextView tNM;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.d
 * JD-Core Version:    0.7.0.1
 */