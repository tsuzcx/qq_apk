package com.tencent.mm.plugin.fav.ui.gallery;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Looper;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.b;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.t;
import android.view.View;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.aa;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class h
  implements e.b, g.a
{
  List<Long> idList;
  Context mContext;
  ArrayList<f.d> mDataList;
  private ap mHandler;
  private GridLayoutManager oTd;
  f.b rCD;
  g.b rCX;
  f rCY;
  boolean rCZ;
  int rDa;
  int rDb;
  
  public h(Context paramContext)
  {
    AppMethodBeat.i(107429);
    this.mDataList = null;
    this.rCZ = false;
    this.mHandler = new ap(Looper.getMainLooper());
    this.rDa = 0;
    this.idList = new ArrayList();
    this.rDb = 0;
    this.mContext = paramContext;
    this.mDataList = new ArrayList();
    AppMethodBeat.o(107429);
  }
  
  public final void E(final boolean paramBoolean, final int paramInt)
  {
    AppMethodBeat.i(107439);
    this.rCY.oSR = true;
    this.rCX.jD(paramBoolean);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajF().ay(new Runnable()
    {
      public final void run()
      {
        int j = 100;
        AppMethodBeat.i(107428);
        if (paramBoolean)
        {
          h.this.mDataList.clear();
          h.this.rDb = 0;
          localObject1 = new ArrayList();
          ((List)localObject1).add(Integer.valueOf(21));
          h.this.idList = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavSearchStorage().b(null, null, (List)localObject1);
          h.this.rDa = h.this.idList.size();
        }
        final int i = j;
        if (paramInt >= 0)
        {
          i = j;
          if (h.this.rDa - paramInt > 100) {
            i = h.this.rDa - paramInt;
          }
        }
        ad.i("MicroMsg.MediaHistoryGalleryPresenter", "offset:%s limit:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
        Object localObject1 = new LinkedList();
        while ((((LinkedList)localObject1).size() < i) && (h.this.rDb < h.this.idList.size()))
        {
          int k = h.this.rDb;
          if (k + i > h.this.idList.size()) {}
          for (j = h.this.idList.size();; j = k + i)
          {
            Object localObject2 = h.dx(h.this.idList.subList(k, j));
            h.this.rDb = j;
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext()) {
              ((LinkedList)localObject1).addAll(h.I((com.tencent.mm.plugin.fav.a.g)((Iterator)localObject2).next()));
            }
          }
          ad.i("MicroMsg.MediaHistoryGalleryPresenter", "traverse until size ok. start:%s, end:%s, idListSize:%s, limit:%s, linklistSize:%s", new Object[] { Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(h.this.idList.size()), Integer.valueOf(i), Integer.valueOf(((LinkedList)localObject1).size()) });
        }
        i = ((LinkedList)localObject1).size();
        Collections.reverse((List)localObject1);
        h.this.mDataList.addAll(0, (Collection)localObject1);
        ((LinkedList)localObject1).clear();
        ad.i("MicroMsg.MediaHistoryGalleryPresenter", "[loadData] %s", new Object[] { Integer.valueOf(h.this.mDataList.size()) });
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(107427);
            h.this.rCY.oSR = false;
            if (h.this.rCX != null) {
              h.this.rCX.B(h.5.this.oSY, i);
            }
            AppMethodBeat.o(107427);
          }
        });
        AppMethodBeat.o(107428);
      }
    });
    AppMethodBeat.o(107439);
  }
  
  public final void Ei(int paramInt)
  {
    AppMethodBeat.i(107434);
    ad.i("MicroMsg.MediaHistoryGalleryPresenter", "[handleSelectedItem] type:%s", new Object[] { Integer.valueOf(paramInt) });
    ArrayList localArrayList = e.a.cxj().rCx;
    if ((localArrayList == null) || (localArrayList.size() == 0))
    {
      ad.i("MicroMsg.MediaHistoryGalleryPresenter", "handleSelectedItem() list == null");
      AppMethodBeat.o(107434);
      return;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(107434);
      return;
      this.rCX.dv(localArrayList);
      this.rCX.cxe();
      AppMethodBeat.o(107434);
      return;
      this.rCX.dw(localArrayList);
      this.rCX.cxe();
    }
  }
  
  public final void a(f.b paramb)
  {
    this.rCD = paramb;
  }
  
  public final RecyclerView.a bZA()
  {
    AppMethodBeat.i(107433);
    this.rCY = new f(this.mContext, this.mDataList, this.rCX, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(107425);
        ad.i("MicroMsg.MediaHistoryGalleryPresenter", "uiCallback()");
        h.this.E(true, -1);
        AppMethodBeat.o(107425);
      }
    });
    this.rCY.rCC = new f.c()
    {
      public final void a(boolean paramAnonymousBoolean, f.d paramAnonymousd, int paramAnonymousInt)
      {
        AppMethodBeat.i(107426);
        ad.i("MicroMsg.MediaHistoryGalleryPresenter", "[onCheck] isChecked :%s pos:%s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf(paramAnonymousInt) });
        if ((paramAnonymousBoolean) && (e.a.cxj().rCx.size() >= 9))
        {
          Toast.makeText(h.this.mContext, h.this.mContext.getResources().getString(2131758830, new Object[] { Integer.valueOf(9) }), 1).show();
          h.this.rCY.cj(paramAnonymousInt);
          AppMethodBeat.o(107426);
          return;
        }
        e locale;
        if (paramAnonymousBoolean)
        {
          locale = e.a.cxj();
          paramAnonymousd = paramAnonymousd.rCG;
          if (paramAnonymousd != null)
          {
            ad.i("MicroMsg.ImageGallerySelectedHandle", "add : %s", new Object[] { paramAnonymousd });
            locale.rCx.remove(paramAnonymousd);
            locale.rCx.remove(locale.agQ(paramAnonymousd.dsX.dsU));
            locale.rCx.add(paramAnonymousd);
            locale.cxi();
          }
        }
        for (;;)
        {
          h.this.rCX.Eg(e.a.cxj().rCx.size());
          AppMethodBeat.o(107426);
          return;
          locale = e.a.cxj();
          paramAnonymousd = paramAnonymousd.rCG;
          if (paramAnonymousd != null)
          {
            ad.i("MicroMsg.ImageGallerySelectedHandle", "remove : %s", new Object[] { paramAnonymousd.dsX.dsU });
            locale.rCx.remove(paramAnonymousd);
            locale.rCx.remove(locale.agQ(paramAnonymousd.dsX.dsU));
            locale.cxi();
          }
        }
      }
    };
    this.rCY.rCD = this.rCD;
    f localf = this.rCY;
    AppMethodBeat.o(107433);
    return localf;
  }
  
  public final <T extends RecyclerView.i> T bZB()
  {
    AppMethodBeat.i(107431);
    if (this.oTd == null)
    {
      this.oTd = new GridLayoutManager(4);
      this.oTd.apF = new GridLayoutManager.b()
      {
        public final int bW(int paramAnonymousInt)
        {
          AppMethodBeat.i(107423);
          if (paramAnonymousInt >= h.this.mDataList.size())
          {
            AppMethodBeat.o(107423);
            return 4;
          }
          if (((f.d)h.this.mDataList.get(paramAnonymousInt)).type == 2147483647)
          {
            AppMethodBeat.o(107423);
            return 4;
          }
          AppMethodBeat.o(107423);
          return 1;
        }
      };
    }
    GridLayoutManager localGridLayoutManager = this.oTd;
    AppMethodBeat.o(107431);
    return localGridLayoutManager;
  }
  
  public final boolean cxc()
  {
    AppMethodBeat.i(107437);
    boolean bool = e.a.cxj().rCy;
    AppMethodBeat.o(107437);
    return bool;
  }
  
  public final void cxd()
  {
    AppMethodBeat.i(107435);
    this.rCY.rCE = true;
    e.a.cxj().rCy = true;
    GridLayoutManager localGridLayoutManager = (GridLayoutManager)bZB();
    int i = localGridLayoutManager.km();
    int j = localGridLayoutManager.ko();
    this.rCY.e(i, j - i + 1, Integer.valueOf(0));
    AppMethodBeat.o(107435);
  }
  
  public final void cxe()
  {
    AppMethodBeat.i(107436);
    this.rCY.rCE = false;
    e.a.cxj().clear();
    e.a.cxj().rCy = false;
    this.rCY.asY.notifyChanged();
    AppMethodBeat.o(107436);
  }
  
  public final void cxk()
  {
    this.rCZ = true;
  }
  
  public final RecyclerView.h eK(final Context paramContext)
  {
    AppMethodBeat.i(107432);
    paramContext = new RecyclerView.h()
    {
      public final void a(Rect paramAnonymousRect, View paramAnonymousView, RecyclerView paramAnonymousRecyclerView, RecyclerView.t paramAnonymoust)
      {
        AppMethodBeat.i(107424);
        int i = (int)paramContext.getResources().getDimension(2131165519);
        paramAnonymousRect.bottom = i;
        paramAnonymousRect.top = i;
        paramAnonymousRect.left = i;
        paramAnonymousRect.right = i;
        AppMethodBeat.o(107424);
      }
    };
    AppMethodBeat.o(107432);
    return paramContext;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(107430);
    if (this.rCX != null)
    {
      this.rCX.a(null);
      this.rCX = null;
    }
    e locale = e.a.cxj();
    locale.rCz.clear();
    locale.clear();
    locale.rCy = false;
    AppMethodBeat.o(107430);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(107438);
    if ((this.rCZ) && (e.a.cxj().rCy))
    {
      this.rCX.Eg(e.a.cxj().rCx.size());
      this.rCY.asY.notifyChanged();
    }
    AppMethodBeat.o(107438);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.h
 * JD-Core Version:    0.7.0.1
 */