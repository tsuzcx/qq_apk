package com.tencent.mm.plugin.fav.ui.gallery;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Looper;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.s;
import android.view.View;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fav.ui.n.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.List;

public final class h
  implements e.b, g.a
{
  ArrayList<f.c> hka = null;
  List<Long> idList = new ArrayList();
  g.b kid;
  f kie;
  private GridLayoutManager kif;
  boolean kig = false;
  int kih = 0;
  int kii = 0;
  Context mContext;
  private ah mHandler = new ah(Looper.getMainLooper());
  
  public h(Context paramContext)
  {
    this.mContext = paramContext;
    this.hka = new ArrayList();
  }
  
  public final void aRO()
  {
    this.kie.khJ = true;
    e.a.aRT().khC = true;
    GridLayoutManager localGridLayoutManager = (GridLayoutManager)aRV();
    int i = localGridLayoutManager.gY();
    int j = localGridLayoutManager.ha();
    this.kie.c(i, j - i + 1, Integer.valueOf(0));
  }
  
  public final void aRP()
  {
    this.kie.khJ = false;
    e.a.aRT().clear();
    e.a.aRT().khC = false;
    this.kie.agL.notifyChanged();
  }
  
  public final void aRU()
  {
    this.kig = true;
  }
  
  public final <T extends RecyclerView.i> T aRV()
  {
    if (this.kif == null)
    {
      this.kif = new GridLayoutManager(4);
      this.kif.adw = new h.1(this);
    }
    return this.kif;
  }
  
  public final RecyclerView.a aRW()
  {
    this.kie = new f(this.mContext, this.hka, this.kid);
    this.kie.khI = new h.3(this);
    return this.kie;
  }
  
  public final boolean aRY()
  {
    return e.a.aRT().khC;
  }
  
  public final RecyclerView.h df(final Context paramContext)
  {
    new RecyclerView.h()
    {
      public final void a(Rect paramAnonymousRect, View paramAnonymousView, RecyclerView paramAnonymousRecyclerView, RecyclerView.s paramAnonymouss)
      {
        int i = (int)paramContext.getResources().getDimension(n.c.OneDPPadding);
        paramAnonymousRect.bottom = i;
        paramAnonymousRect.top = i;
        paramAnonymousRect.left = i;
        paramAnonymousRect.right = i;
      }
    };
  }
  
  public final void l(boolean paramBoolean, int paramInt)
  {
    this.kie.khH = true;
    this.kid.ga(paramBoolean);
    g.DQ();
    g.DS().O(new h.4(this, paramBoolean, paramInt));
  }
  
  public final void onDetach()
  {
    if (this.kid != null)
    {
      this.kid.a(null);
      this.kid = null;
    }
    e locale = e.a.aRT();
    locale.khD.clear();
    locale.clear();
    locale.khC = false;
  }
  
  public final void onResume()
  {
    if ((this.kig) && (e.a.aRT().khC))
    {
      this.kid.re(e.a.aRT().khB.size());
      this.kie.agL.notifyChanged();
    }
  }
  
  public final void rg(int paramInt)
  {
    y.i("MicroMsg.MediaHistoryGalleryPresenter", "[handleSelectedItem] type:%s", new Object[] { Integer.valueOf(paramInt) });
    ArrayList localArrayList = e.a.aRT().khB;
    switch (paramInt)
    {
    default: 
      return;
    }
    this.kid.bv(localArrayList);
    this.kid.aRP();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.h
 * JD-Core Version:    0.7.0.1
 */