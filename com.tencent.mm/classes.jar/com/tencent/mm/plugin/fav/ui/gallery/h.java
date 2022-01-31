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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import java.util.ArrayList;
import java.util.List;

public final class h
  implements e.b, g.a
{
  ArrayList<f.c> iVH;
  List<Long> idList;
  private GridLayoutManager kFI;
  g.b mCK;
  f mCL;
  boolean mCM;
  int mCN;
  int mCO;
  Context mContext;
  private ak mHandler;
  
  public h(Context paramContext)
  {
    AppMethodBeat.i(74595);
    this.iVH = null;
    this.mCM = false;
    this.mHandler = new ak(Looper.getMainLooper());
    this.mCN = 0;
    this.idList = new ArrayList();
    this.mCO = 0;
    this.mContext = paramContext;
    this.iVH = new ArrayList();
    AppMethodBeat.o(74595);
  }
  
  public final <T extends RecyclerView.i> T bgA()
  {
    AppMethodBeat.i(74597);
    if (this.kFI == null)
    {
      this.kFI = new GridLayoutManager(4);
      this.kFI.afL = new h.1(this);
    }
    GridLayoutManager localGridLayoutManager = this.kFI;
    AppMethodBeat.o(74597);
    return localGridLayoutManager;
  }
  
  public final RecyclerView.a bgz()
  {
    AppMethodBeat.i(74599);
    this.mCL = new f(this.mContext, this.iVH, this.mCK);
    this.mCL.mCq = new h.3(this);
    f localf = this.mCL;
    AppMethodBeat.o(74599);
    return localf;
  }
  
  public final void byh()
  {
    AppMethodBeat.i(74601);
    this.mCL.mCr = true;
    e.a.bym().mCm = true;
    GridLayoutManager localGridLayoutManager = (GridLayoutManager)bgA();
    int i = localGridLayoutManager.it();
    int j = localGridLayoutManager.iv();
    this.mCL.e(i, j - i + 1, Integer.valueOf(0));
    AppMethodBeat.o(74601);
  }
  
  public final void byi()
  {
    AppMethodBeat.i(74602);
    this.mCL.mCr = false;
    e.a.bym().clear();
    e.a.bym().mCm = false;
    this.mCL.ajb.notifyChanged();
    AppMethodBeat.o(74602);
  }
  
  public final void byn()
  {
    this.mCM = true;
  }
  
  public final boolean byp()
  {
    AppMethodBeat.i(74603);
    boolean bool = e.a.bym().mCm;
    AppMethodBeat.o(74603);
    return bool;
  }
  
  public final RecyclerView.h dR(final Context paramContext)
  {
    AppMethodBeat.i(74598);
    paramContext = new RecyclerView.h()
    {
      public final void a(Rect paramAnonymousRect, View paramAnonymousView, RecyclerView paramAnonymousRecyclerView, RecyclerView.s paramAnonymouss)
      {
        AppMethodBeat.i(74591);
        int i = (int)paramContext.getResources().getDimension(2131427811);
        paramAnonymousRect.bottom = i;
        paramAnonymousRect.top = i;
        paramAnonymousRect.left = i;
        paramAnonymousRect.right = i;
        AppMethodBeat.o(74591);
      }
    };
    AppMethodBeat.o(74598);
    return paramContext;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(74596);
    if (this.mCK != null)
    {
      this.mCK.a(null);
      this.mCK = null;
    }
    e locale = e.a.bym();
    locale.mCn.clear();
    locale.clear();
    locale.mCm = false;
    AppMethodBeat.o(74596);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(74604);
    if ((this.mCM) && (e.a.bym().mCm))
    {
      this.mCK.wa(e.a.bym().mCl.size());
      this.mCL.ajb.notifyChanged();
    }
    AppMethodBeat.o(74604);
  }
  
  public final void v(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(74605);
    this.mCL.kFv = true;
    this.mCK.gf(paramBoolean);
    g.RM();
    g.RO().ac(new h.4(this, paramBoolean, paramInt));
    AppMethodBeat.o(74605);
  }
  
  public final void wc(int paramInt)
  {
    AppMethodBeat.i(74600);
    ab.i("MicroMsg.MediaHistoryGalleryPresenter", "[handleSelectedItem] type:%s", new Object[] { Integer.valueOf(paramInt) });
    ArrayList localArrayList = e.a.bym().mCl;
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(74600);
      return;
      this.mCK.bP(localArrayList);
      this.mCK.byi();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.h
 * JD-Core Version:    0.7.0.1
 */