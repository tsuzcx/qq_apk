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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
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
  private Bitmap cIi;
  int cUq;
  int dzl;
  Context mContext;
  ArrayList<GalleryItem.MediaItem> sOJ;
  ArrayList<String> sQQ;
  boolean sQR;
  HashSet<String> sQS;
  View sQT;
  boolean sQU;
  private boolean sQV;
  private HashMap<String, WeakReference<b>> sQW;
  public f sQX;
  public e sQY;
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(111516);
    this.sQQ = new ArrayList();
    this.sOJ = new ArrayList();
    this.sQS = new HashSet();
    this.dzl = -1;
    this.sQT = null;
    this.sQU = false;
    this.sQV = true;
    this.cUq = -1;
    this.cIi = null;
    this.sQW = new HashMap();
    this.sQX = new f(this);
    this.sQY = new e(this);
    this.mContext = paramContext;
    AppMethodBeat.o(111516);
  }
  
  @TargetApi(11)
  protected static void a(b paramb, Bitmap paramBitmap)
  {
    AppMethodBeat.i(111526);
    ac.i("MicroMsg.ImageAdapter", "showImage, trace: %s.", new Object[] { bs.eWi() });
    paramb.sRf.setVisibility(0);
    paramb.sRg.setVisibility(4);
    paramb.sRf.setMaxZoomLimit(4.5F);
    paramb.sRf.setEnableHorLongBmpMode(false);
    p.z(paramb.sRf, paramBitmap.getWidth(), paramBitmap.getHeight());
    paramb.sRf.cF(paramBitmap.getWidth(), paramBitmap.getHeight());
    paramb.sRf.setImageBitmap(paramBitmap);
    paramb.sRf.requestLayout();
    AppMethodBeat.o(111526);
  }
  
  public final MultiTouchImageView Gb(int paramInt)
  {
    AppMethodBeat.i(111521);
    Object localObject = super.QZ(paramInt);
    if (localObject == null)
    {
      ac.e("MicroMsg.ImageAdapter", "position : %d getMultiTouchImageViewByPosition view is null.", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(111521);
      return null;
    }
    localObject = (b)((View)localObject).getTag();
    if (localObject == null)
    {
      ac.e("MicroMsg.ImageAdapter", "position : %d getMultiTouchImageViewByPosition holder is null.", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(111521);
      return null;
    }
    if (((b)localObject).sRf.getVisibility() == 8)
    {
      AppMethodBeat.o(111521);
      return null;
    }
    localObject = ((b)localObject).sRf;
    AppMethodBeat.o(111521);
    return localObject;
  }
  
  public final WxImageView Gc(int paramInt)
  {
    AppMethodBeat.i(111522);
    Object localObject = super.QZ(paramInt);
    if (localObject == null)
    {
      ac.e("MicroMsg.ImageAdapter", "position : %d getWxImageViewByPosition view is null.", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(111522);
      return null;
    }
    localObject = (b)((View)localObject).getTag();
    if (localObject == null)
    {
      ac.e("MicroMsg.ImageAdapter", "position : %d getWxImageViewByPosition holder is null.", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(111522);
      return null;
    }
    if (((b)localObject).sRg.getVisibility() == 8)
    {
      AppMethodBeat.o(111522);
      return null;
    }
    localObject = ((b)localObject).sRg;
    AppMethodBeat.o(111522);
    return localObject;
  }
  
  public final GalleryItem.MediaItem Gd(int paramInt)
  {
    AppMethodBeat.i(111524);
    if (this.sQR)
    {
      if ((paramInt < 0) || (paramInt >= this.sOJ.size()))
      {
        ac.w("MicroMsg.ImageAdapter", "error position %d mediaitems size", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.sOJ.size()) });
        AppMethodBeat.o(111524);
        return null;
      }
      localObject = (GalleryItem.MediaItem)this.sOJ.get(paramInt);
      AppMethodBeat.o(111524);
      return localObject;
    }
    if ((paramInt < 0) || (paramInt >= this.sQQ.size()))
    {
      ac.w("MicroMsg.ImageAdapter", "error position %d, imagePaths size %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.sQQ.size()) });
      AppMethodBeat.o(111524);
      return null;
    }
    Object localObject = (String)this.sQQ.get(paramInt);
    GalleryItem.MediaItem localMediaItem2 = GalleryItem.MediaItem.a(0, 0L, (String)localObject, (String)localObject, "");
    if (com.tencent.mm.plugin.gallery.model.e.cMv() != null)
    {
      paramInt = com.tencent.mm.plugin.gallery.model.e.cMv().indexOf(localMediaItem2);
      if (paramInt < 0) {}
    }
    for (localObject = (GalleryItem.MediaItem)com.tencent.mm.plugin.gallery.model.e.cMv().get(paramInt);; localObject = null)
    {
      if ((localObject == null) && (!com.tencent.mm.plugin.gallery.model.e.cMy().isEmpty()))
      {
        Iterator localIterator = com.tencent.mm.plugin.gallery.model.e.cMy().iterator();
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
    this.sQS.remove(paramString);
    if (paramMultiTouchImageView != null)
    {
      paramMultiTouchImageView = (b)paramMultiTouchImageView.getTag();
      if (paramMultiTouchImageView != null) {
        if (paramBitmap != null)
        {
          a(paramMultiTouchImageView, paramBitmap);
          if (paramMultiTouchImageView.sRi != null)
          {
            paramMultiTouchImageView.sRi.setText("");
            paramMultiTouchImageView.sRi.setVisibility(8);
            AppMethodBeat.o(111525);
          }
        }
        else
        {
          if ((paramMultiTouchImageView.sRe) && (paramMultiTouchImageView.sRi != null))
          {
            paramMultiTouchImageView.sRi.setText(paramString);
            paramMultiTouchImageView.sRi.setVisibility(0);
            AppMethodBeat.o(111525);
            return;
          }
          if (paramMultiTouchImageView.sRi != null)
          {
            paramMultiTouchImageView.sRi.setText("");
            paramMultiTouchImageView.sRi.setVisibility(8);
          }
        }
      }
    }
    AppMethodBeat.o(111525);
  }
  
  public final void af(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(111519);
    this.sQQ.clear();
    this.sQQ.addAll(paramArrayList);
    reset();
    notifyDataSetChanged();
    AppMethodBeat.o(111519);
  }
  
  public final void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(111518);
    if (!this.sQR)
    {
      if (paramObject == null)
      {
        ac.e("MicroMsg.ImageAdapter", "[destroyItem] position:%s", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(111518);
        return;
      }
      if (this.sQT != null) {
        ac.i("MicroMsg.ImageAdapter", "[destroyItem] position:%s object:%s lastVisibleView:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramObject.hashCode()), Integer.valueOf(this.sQT.hashCode()) });
      }
      if ((paramObject != this.sQT) || (!this.sQU))
      {
        super.destroyItem(paramViewGroup, paramInt, paramObject);
        paramViewGroup.removeView((View)paramObject);
        AppMethodBeat.o(111518);
        return;
      }
      ac.d("MicroMsg.ImageAdapter", "[isSwap-destroyItem]");
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
    this.sQY.detach();
    AppMethodBeat.o(111528);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(111520);
    if (this.sQR)
    {
      i = this.sOJ.size();
      AppMethodBeat.o(111520);
      return i;
    }
    int i = this.sQQ.size();
    AppMethodBeat.o(111520);
    return i;
  }
  
  public final String getItem(int paramInt)
  {
    AppMethodBeat.i(111523);
    if (this.sQR)
    {
      if ((paramInt < 0) || (paramInt >= this.sOJ.size()))
      {
        ac.w("MicroMsg.ImageAdapter", "error position %d, mediaitems size %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.sOJ.size()) });
        AppMethodBeat.o(111523);
        return "";
      }
      str = ((GalleryItem.MediaItem)this.sOJ.get(paramInt)).sKh;
      AppMethodBeat.o(111523);
      return str;
    }
    if ((paramInt < 0) || (paramInt >= this.sQQ.size()))
    {
      ac.w("MicroMsg.ImageAdapter", "error position %d, imagePaths size %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.sQQ.size()) });
      AppMethodBeat.o(111523);
      return "";
    }
    String str = (String)this.sQQ.get(paramInt);
    AppMethodBeat.o(111523);
    return str;
  }
  
  public final Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(111517);
    if (!this.sQR)
    {
      ac.i("MicroMsg.ImageAdapter", "[instantiateItem] position:%s %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.dzl) });
      if ((paramInt == this.dzl) && (this.sQU))
      {
        ac.d("MicroMsg.ImageAdapter", "[isSwap-instantiateItem]");
        this.HBa.put(this.sQT, Integer.valueOf(this.dzl));
        this.HBb.put(this.dzl, this.sQT);
        this.dzl = -1;
        this.sQU = false;
        paramViewGroup = this.sQT;
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
    this.sQW.clear();
    this.sQS.clear();
    AppMethodBeat.o(111527);
  }
  
  static final class b
  {
    ImageView qTB;
    boolean sRe = false;
    MultiTouchImageView sRf;
    WxImageView sRg;
    TextView sRh;
    TextView sRi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.d
 * JD-Core Version:    0.7.0.1
 */