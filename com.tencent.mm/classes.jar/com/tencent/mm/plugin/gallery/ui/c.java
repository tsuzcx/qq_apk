package com.tencent.mm.plugin.gallery.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.n;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.WxImageView;
import com.tencent.mm.ui.base.u;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public final class c
  extends u
{
  private Bitmap bXF;
  Context mContext;
  ArrayList<GalleryItem.MediaItem> ndM;
  public d nfA;
  ArrayList<String> nfs;
  boolean nft;
  private HashSet<String> nfu;
  int nfv;
  View nfw;
  boolean nfx;
  private HashMap<String, WeakReference<c.b>> nfy;
  public e nfz;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(21459);
    this.nfs = new ArrayList();
    this.ndM = new ArrayList();
    this.nfu = new HashSet();
    this.nfv = -1;
    this.nfw = null;
    this.nfx = false;
    this.bXF = null;
    this.nfy = new HashMap();
    this.nfz = new e(this);
    this.nfA = new d(this);
    this.mContext = paramContext;
    AppMethodBeat.o(21459);
  }
  
  @TargetApi(11)
  private static void a(MultiTouchImageView paramMultiTouchImageView, Bitmap paramBitmap)
  {
    AppMethodBeat.i(21468);
    paramMultiTouchImageView.setMaxZoomLimit(4.5F);
    paramMultiTouchImageView.setEnableHorLongBmpMode(false);
    if (Build.VERSION.SDK_INT == 20) {
      paramMultiTouchImageView.setLayerType(1, null);
    }
    for (;;)
    {
      paramMultiTouchImageView.cb(paramBitmap.getWidth(), paramBitmap.getHeight());
      paramMultiTouchImageView.setImageBitmap(paramBitmap);
      paramMultiTouchImageView.requestLayout();
      AppMethodBeat.o(21468);
      return;
      n.x(paramMultiTouchImageView, paramBitmap.getWidth(), paramBitmap.getHeight());
    }
  }
  
  public final void E(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(21460);
    this.nfs.clear();
    this.nfs = new ArrayList();
    this.nfs.addAll(paramArrayList);
    reset();
    notifyDataSetChanged();
    AppMethodBeat.o(21460);
  }
  
  public final void a(MultiTouchImageView paramMultiTouchImageView, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(21467);
    this.nfu.remove(paramString);
    if (paramMultiTouchImageView != null)
    {
      c.b localb = (c.b)paramMultiTouchImageView.getTag();
      if (paramBitmap != null)
      {
        a(paramMultiTouchImageView, paramBitmap);
        if ((localb != null) && (localb.nfC) && (localb.nfF != null))
        {
          localb.nfF.setVisibility(8);
          AppMethodBeat.o(21467);
        }
      }
      else if ((localb != null) && (localb.nfC) && (localb.nfF != null))
      {
        localb.nfF.setText(paramString);
        localb.nfF.setVisibility(0);
      }
    }
    AppMethodBeat.o(21467);
  }
  
  public final void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(21462);
    if (!this.nft)
    {
      if (paramObject == null)
      {
        ab.e("MicroMsg.ImageAdapter", "[destroyItem] position:%s", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(21462);
        return;
      }
      if (this.nfw != null) {
        ab.i("MicroMsg.ImageAdapter", "[destroyItem] position:%s object:%s lastVisableView:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramObject.hashCode()), Integer.valueOf(this.nfw.hashCode()) });
      }
      if ((paramObject != this.nfw) || (!this.nfx))
      {
        super.destroyItem(paramViewGroup, paramInt, paramObject);
        paramViewGroup.removeView((View)paramObject);
        AppMethodBeat.o(21462);
        return;
      }
      ab.d("MicroMsg.ImageAdapter", "[isSwap-destroyItem]");
      AppMethodBeat.o(21462);
      return;
    }
    super.destroyItem(paramViewGroup, paramInt, paramObject);
    AppMethodBeat.o(21462);
  }
  
  public final void detach()
  {
    AppMethodBeat.i(21470);
    super.detach();
    this.nfA.detach();
    AppMethodBeat.o(21470);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(21463);
    if (this.nft)
    {
      i = this.ndM.size();
      AppMethodBeat.o(21463);
      return i;
    }
    int i = this.nfs.size();
    AppMethodBeat.o(21463);
    return i;
  }
  
  public final String getItem(int paramInt)
  {
    AppMethodBeat.i(21465);
    if (this.nft)
    {
      if ((paramInt < 0) || (paramInt >= this.ndM.size()))
      {
        ab.w("MicroMsg.ImageAdapter", "error position %d, mediaitems size %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.ndM.size()) });
        AppMethodBeat.o(21465);
        return "";
      }
      str = ((GalleryItem.MediaItem)this.ndM.get(paramInt)).fQn;
      AppMethodBeat.o(21465);
      return str;
    }
    if ((paramInt < 0) || (paramInt >= this.nfs.size()))
    {
      ab.w("MicroMsg.ImageAdapter", "error position %d, imagePaths size %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.nfs.size()) });
      AppMethodBeat.o(21465);
      return "";
    }
    String str = (String)this.nfs.get(paramInt);
    AppMethodBeat.o(21465);
    return str;
  }
  
  public final Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(21461);
    if (!this.nft)
    {
      ab.i("MicroMsg.ImageAdapter", "[instantiateItem] position:%s %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.nfv) });
      if ((paramInt == this.nfv) && (this.nfx))
      {
        ab.d("MicroMsg.ImageAdapter", "[isSwap-instantiateItem]");
        this.znM.put(this.nfw, Integer.valueOf(this.nfv));
        this.znN.put(this.nfv, this.nfw);
        this.nfv = -1;
        this.nfx = false;
        paramViewGroup = this.nfw;
        AppMethodBeat.o(21461);
        return paramViewGroup;
      }
      paramViewGroup = super.instantiateItem(paramViewGroup, paramInt);
      AppMethodBeat.o(21461);
      return paramViewGroup;
    }
    paramViewGroup = super.instantiateItem(paramViewGroup, paramInt);
    AppMethodBeat.o(21461);
    return paramViewGroup;
  }
  
  public final void release()
  {
    AppMethodBeat.i(21469);
    detach();
    this.nfy.clear();
    this.nfu.clear();
    AppMethodBeat.o(21469);
  }
  
  public final MultiTouchImageView wT(int paramInt)
  {
    AppMethodBeat.i(21464);
    Object localObject = super.Gm(paramInt);
    if (localObject == null)
    {
      ab.e("MicroMsg.ImageAdapter", "position : %s getMultiTouchImageViewByPosition is null", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(21464);
      return null;
    }
    if ((localObject == null) || (((View)localObject).getVisibility() == 8))
    {
      AppMethodBeat.o(21464);
      return null;
    }
    localObject = ((View)localObject).findViewById(2131820629);
    if (localObject == null)
    {
      AppMethodBeat.o(21464);
      return null;
    }
    localObject = (MultiTouchImageView)localObject;
    AppMethodBeat.o(21464);
    return localObject;
  }
  
  public final WxImageView wU(int paramInt)
  {
    return null;
  }
  
  public final GalleryItem.MediaItem wV(int paramInt)
  {
    Object localObject2 = null;
    AppMethodBeat.i(21466);
    if (this.nft)
    {
      if ((paramInt < 0) || (paramInt >= this.ndM.size()))
      {
        ab.w("MicroMsg.ImageAdapter", "error position %d mediaitems size", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.ndM.size()) });
        AppMethodBeat.o(21466);
        return null;
      }
      localObject1 = (GalleryItem.MediaItem)this.ndM.get(paramInt);
      AppMethodBeat.o(21466);
      return localObject1;
    }
    if ((paramInt < 0) || (paramInt >= this.nfs.size()))
    {
      ab.w("MicroMsg.ImageAdapter", "error position %d, imagePaths size %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.nfs.size()) });
      AppMethodBeat.o(21466);
      return null;
    }
    String str = (String)this.nfs.get(paramInt);
    Object localObject1 = localObject2;
    if (com.tencent.mm.plugin.gallery.model.e.bDS() != null)
    {
      localObject1 = GalleryItem.MediaItem.a(0, 0L, str, str, "");
      paramInt = com.tencent.mm.plugin.gallery.model.e.bDS().indexOf(localObject1);
      localObject1 = localObject2;
      if (paramInt >= 0) {
        localObject1 = (GalleryItem.MediaItem)com.tencent.mm.plugin.gallery.model.e.bDS().get(paramInt);
      }
    }
    AppMethodBeat.o(21466);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.c
 * JD-Core Version:    0.7.0.1
 */