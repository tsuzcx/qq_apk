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
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
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
  private aq mHandler;
  private GridLayoutManager oZF;
  f.b rKO;
  g.b rLi;
  f rLj;
  boolean rLk;
  int rLl;
  int rLm;
  
  public h(Context paramContext)
  {
    AppMethodBeat.i(107429);
    this.mDataList = null;
    this.rLk = false;
    this.mHandler = new aq(Looper.getMainLooper());
    this.rLl = 0;
    this.idList = new ArrayList();
    this.rLm = 0;
    this.mContext = paramContext;
    this.mDataList = new ArrayList();
    AppMethodBeat.o(107429);
  }
  
  public final void Ev(int paramInt)
  {
    AppMethodBeat.i(107434);
    ae.i("MicroMsg.MediaHistoryGalleryPresenter", "[handleSelectedItem] type:%s", new Object[] { Integer.valueOf(paramInt) });
    ArrayList localArrayList = e.a.cyK().rKI;
    if ((localArrayList == null) || (localArrayList.size() == 0))
    {
      ae.i("MicroMsg.MediaHistoryGalleryPresenter", "handleSelectedItem() list == null");
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
      this.rLi.dy(localArrayList);
      this.rLi.cyF();
      AppMethodBeat.o(107434);
      return;
      this.rLi.dz(localArrayList);
      this.rLi.cyF();
    }
  }
  
  public final void F(final boolean paramBoolean, final int paramInt)
  {
    AppMethodBeat.i(107439);
    this.rLj.oZt = true;
    this.rLi.jC(paramBoolean);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajU().aw(new Runnable()
    {
      public final void run()
      {
        int j = 100;
        AppMethodBeat.i(107428);
        if (paramBoolean)
        {
          h.this.mDataList.clear();
          h.this.rLm = 0;
          localObject1 = new ArrayList();
          ((List)localObject1).add(Integer.valueOf(21));
          h.this.idList = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavSearchStorage().b(null, null, (List)localObject1);
          h.this.rLl = h.this.idList.size();
        }
        final int i = j;
        if (paramInt >= 0)
        {
          i = j;
          if (h.this.rLl - paramInt > 100) {
            i = h.this.rLl - paramInt;
          }
        }
        ae.i("MicroMsg.MediaHistoryGalleryPresenter", "offset:%s limit:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
        Object localObject1 = new LinkedList();
        while ((((LinkedList)localObject1).size() < i) && (h.this.rLm < h.this.idList.size()))
        {
          int k = h.this.rLm;
          if (k + i > h.this.idList.size()) {}
          for (j = h.this.idList.size();; j = k + i)
          {
            Object localObject2 = h.dA(h.this.idList.subList(k, j));
            h.this.rLm = j;
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext()) {
              ((LinkedList)localObject1).addAll(h.I((com.tencent.mm.plugin.fav.a.g)((Iterator)localObject2).next()));
            }
          }
          ae.i("MicroMsg.MediaHistoryGalleryPresenter", "traverse until size ok. start:%s, end:%s, idListSize:%s, limit:%s, linklistSize:%s", new Object[] { Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(h.this.idList.size()), Integer.valueOf(i), Integer.valueOf(((LinkedList)localObject1).size()) });
        }
        i = ((LinkedList)localObject1).size();
        Collections.reverse((List)localObject1);
        h.this.mDataList.addAll(0, (Collection)localObject1);
        ((LinkedList)localObject1).clear();
        ae.i("MicroMsg.MediaHistoryGalleryPresenter", "[loadData] %s", new Object[] { Integer.valueOf(h.this.mDataList.size()) });
        ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(107427);
            h.this.rLj.oZt = false;
            if (h.this.rLi != null) {
              h.this.rLi.C(h.5.this.oZA, i);
            }
            AppMethodBeat.o(107427);
          }
        });
        AppMethodBeat.o(107428);
      }
    });
    AppMethodBeat.o(107439);
  }
  
  public final void a(f.b paramb)
  {
    this.rKO = paramb;
  }
  
  public final RecyclerView.a caP()
  {
    AppMethodBeat.i(107433);
    this.rLj = new f(this.mContext, this.mDataList, this.rLi, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(107425);
        ae.i("MicroMsg.MediaHistoryGalleryPresenter", "uiCallback()");
        h.this.F(true, -1);
        AppMethodBeat.o(107425);
      }
    });
    this.rLj.rKN = new f.c()
    {
      public final void a(boolean paramAnonymousBoolean, f.d paramAnonymousd, int paramAnonymousInt)
      {
        AppMethodBeat.i(107426);
        ae.i("MicroMsg.MediaHistoryGalleryPresenter", "[onCheck] isChecked :%s pos:%s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf(paramAnonymousInt) });
        if ((paramAnonymousBoolean) && (e.a.cyK().rKI.size() >= 9))
        {
          Toast.makeText(h.this.mContext, h.this.mContext.getResources().getString(2131758830, new Object[] { Integer.valueOf(9) }), 1).show();
          h.this.rLj.cj(paramAnonymousInt);
          AppMethodBeat.o(107426);
          return;
        }
        e locale;
        if (paramAnonymousBoolean)
        {
          locale = e.a.cyK();
          paramAnonymousd = paramAnonymousd.rKR;
          if (paramAnonymousd != null)
          {
            ae.i("MicroMsg.ImageGallerySelectedHandle", "add : %s", new Object[] { paramAnonymousd });
            locale.rKI.remove(paramAnonymousd);
            locale.rKI.remove(locale.ahN(paramAnonymousd.dud.dua));
            locale.rKI.add(paramAnonymousd);
            locale.cyJ();
          }
        }
        for (;;)
        {
          h.this.rLi.Et(e.a.cyK().rKI.size());
          AppMethodBeat.o(107426);
          return;
          locale = e.a.cyK();
          paramAnonymousd = paramAnonymousd.rKR;
          if (paramAnonymousd != null)
          {
            ae.i("MicroMsg.ImageGallerySelectedHandle", "remove : %s", new Object[] { paramAnonymousd.dud.dua });
            locale.rKI.remove(paramAnonymousd);
            locale.rKI.remove(locale.ahN(paramAnonymousd.dud.dua));
            locale.cyJ();
          }
        }
      }
    };
    this.rLj.rKO = this.rKO;
    f localf = this.rLj;
    AppMethodBeat.o(107433);
    return localf;
  }
  
  public final <T extends RecyclerView.i> T caQ()
  {
    AppMethodBeat.i(107431);
    if (this.oZF == null)
    {
      this.oZF = new GridLayoutManager(4);
      this.oZF.apF = new GridLayoutManager.b()
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
    GridLayoutManager localGridLayoutManager = this.oZF;
    AppMethodBeat.o(107431);
    return localGridLayoutManager;
  }
  
  public final boolean cyD()
  {
    AppMethodBeat.i(107437);
    boolean bool = e.a.cyK().rKJ;
    AppMethodBeat.o(107437);
    return bool;
  }
  
  public final void cyE()
  {
    AppMethodBeat.i(107435);
    this.rLj.rKP = true;
    e.a.cyK().rKJ = true;
    GridLayoutManager localGridLayoutManager = (GridLayoutManager)caQ();
    int i = localGridLayoutManager.km();
    int j = localGridLayoutManager.ko();
    this.rLj.e(i, j - i + 1, Integer.valueOf(0));
    AppMethodBeat.o(107435);
  }
  
  public final void cyF()
  {
    AppMethodBeat.i(107436);
    this.rLj.rKP = false;
    e.a.cyK().clear();
    e.a.cyK().rKJ = false;
    this.rLj.asY.notifyChanged();
    AppMethodBeat.o(107436);
  }
  
  public final void cyL()
  {
    this.rLk = true;
  }
  
  public final RecyclerView.h eO(final Context paramContext)
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
    if (this.rLi != null)
    {
      this.rLi.a(null);
      this.rLi = null;
    }
    e locale = e.a.cyK();
    locale.rKK.clear();
    locale.clear();
    locale.rKJ = false;
    AppMethodBeat.o(107430);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(107438);
    if ((this.rLk) && (e.a.cyK().rKJ))
    {
      this.rLi.Et(e.a.cyK().rKI.size());
      this.rLj.asY.notifyChanged();
    }
    AppMethodBeat.o(107438);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.h
 * JD-Core Version:    0.7.0.1
 */