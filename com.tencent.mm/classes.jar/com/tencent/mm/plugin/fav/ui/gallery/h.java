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
import android.support.v7.widget.RecyclerView.s;
import android.view.View;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.aa;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.protocal.protobuf.afy;
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
  ArrayList<f.c> hIH;
  List<Long> idList;
  Context mContext;
  private ap mHandler;
  private GridLayoutManager nMI;
  g.b qks;
  f qkt;
  boolean qku;
  int qkv;
  int qkw;
  
  public h(Context paramContext)
  {
    AppMethodBeat.i(107429);
    this.hIH = null;
    this.qku = false;
    this.mHandler = new ap(Looper.getMainLooper());
    this.qkv = 0;
    this.idList = new ArrayList();
    this.qkw = 0;
    this.mContext = paramContext;
    this.hIH = new ArrayList();
    AppMethodBeat.o(107429);
  }
  
  public final void Cu(int paramInt)
  {
    AppMethodBeat.i(107434);
    ad.i("MicroMsg.MediaHistoryGalleryPresenter", "[handleSelectedItem] type:%s", new Object[] { Integer.valueOf(paramInt) });
    ArrayList localArrayList = e.a.cjQ().qjT;
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
      this.qks.dr(localArrayList);
      this.qks.cjL();
      AppMethodBeat.o(107434);
      return;
      this.qks.ds(localArrayList);
      this.qks.cjL();
    }
  }
  
  public final void D(final boolean paramBoolean, final int paramInt)
  {
    AppMethodBeat.i(107439);
    this.qkt.nMw = true;
    this.qks.iP(paramBoolean);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afE().ax(new Runnable()
    {
      public final void run()
      {
        int j = 100;
        AppMethodBeat.i(107428);
        if (paramBoolean)
        {
          h.this.hIH.clear();
          h.this.qkw = 0;
          localObject1 = new ArrayList();
          ((List)localObject1).add(Integer.valueOf(21));
          h.this.idList = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavSearchStorage().b(null, null, (List)localObject1);
          h.this.qkv = h.this.idList.size();
        }
        final int i = j;
        if (paramInt >= 0)
        {
          i = j;
          if (h.this.qkv - paramInt > 100) {
            i = h.this.qkv - paramInt;
          }
        }
        ad.i("MicroMsg.MediaHistoryGalleryPresenter", "offset:%s limit:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
        Object localObject1 = new LinkedList();
        while ((((LinkedList)localObject1).size() < i) && (h.this.qkw < h.this.idList.size()))
        {
          int k = h.this.qkw;
          if (k + i > h.this.idList.size()) {}
          for (j = h.this.idList.size();; j = k + i)
          {
            Object localObject2 = h.dt(h.this.idList.subList(k, j));
            h.this.qkw = j;
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext()) {
              ((LinkedList)localObject1).addAll(h.I((com.tencent.mm.plugin.fav.a.g)((Iterator)localObject2).next()));
            }
          }
          ad.i("MicroMsg.MediaHistoryGalleryPresenter", "traverse until size ok. start:%s, end:%s, idListSize:%s, limit:%s, linklistSize:%s", new Object[] { Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(h.this.idList.size()), Integer.valueOf(i), Integer.valueOf(((LinkedList)localObject1).size()) });
        }
        i = ((LinkedList)localObject1).size();
        Collections.reverse((List)localObject1);
        h.this.hIH.addAll(0, (Collection)localObject1);
        ((LinkedList)localObject1).clear();
        ad.i("MicroMsg.MediaHistoryGalleryPresenter", "[loadData] %s", new Object[] { Integer.valueOf(h.this.hIH.size()) });
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(107427);
            h.this.qkt.nMw = false;
            if (h.this.qks != null) {
              h.this.qks.A(h.5.this.nMD, i);
            }
            AppMethodBeat.o(107427);
          }
        });
        AppMethodBeat.o(107428);
      }
    });
    AppMethodBeat.o(107439);
  }
  
  public final RecyclerView.a bNK()
  {
    AppMethodBeat.i(107433);
    this.qkt = new f(this.mContext, this.hIH, this.qks, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(107425);
        ad.i("MicroMsg.MediaHistoryGalleryPresenter", "uiCallback()");
        h.this.D(true, -1);
        AppMethodBeat.o(107425);
      }
    });
    this.qkt.qjY = new f.b()
    {
      public final void a(boolean paramAnonymousBoolean, f.c paramAnonymousc, int paramAnonymousInt)
      {
        AppMethodBeat.i(107426);
        ad.i("MicroMsg.MediaHistoryGalleryPresenter", "[onCheck] isChecked :%s pos:%s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf(paramAnonymousInt) });
        if ((paramAnonymousBoolean) && (e.a.cjQ().qjT.size() >= 9))
        {
          Toast.makeText(h.this.mContext, h.this.mContext.getResources().getString(2131758830, new Object[] { Integer.valueOf(9) }), 1).show();
          h.this.qkt.ck(paramAnonymousInt);
          AppMethodBeat.o(107426);
          return;
        }
        e locale;
        if (paramAnonymousBoolean)
        {
          locale = e.a.cjQ();
          paramAnonymousc = paramAnonymousc.qkb;
          if (paramAnonymousc != null)
          {
            ad.i("MicroMsg.ImageGallerySelectedHandle", "add : %s", new Object[] { paramAnonymousc });
            locale.qjT.remove(paramAnonymousc);
            locale.qjT.remove(locale.YF(paramAnonymousc.dke.dkb));
            locale.qjT.add(paramAnonymousc);
            locale.cjP();
          }
        }
        for (;;)
        {
          h.this.qks.Cs(e.a.cjQ().qjT.size());
          AppMethodBeat.o(107426);
          return;
          locale = e.a.cjQ();
          paramAnonymousc = paramAnonymousc.qkb;
          if (paramAnonymousc != null)
          {
            ad.i("MicroMsg.ImageGallerySelectedHandle", "remove : %s", new Object[] { paramAnonymousc.dke.dkb });
            locale.qjT.remove(paramAnonymousc);
            locale.qjT.remove(locale.YF(paramAnonymousc.dke.dkb));
            locale.cjP();
          }
        }
      }
    };
    f localf = this.qkt;
    AppMethodBeat.o(107433);
    return localf;
  }
  
  public final <T extends RecyclerView.i> T bNL()
  {
    AppMethodBeat.i(107431);
    if (this.nMI == null)
    {
      this.nMI = new GridLayoutManager(4);
      this.nMI.amS = new GridLayoutManager.b()
      {
        public final int bW(int paramAnonymousInt)
        {
          AppMethodBeat.i(107423);
          if (paramAnonymousInt >= h.this.hIH.size())
          {
            AppMethodBeat.o(107423);
            return 4;
          }
          if (((f.c)h.this.hIH.get(paramAnonymousInt)).type == 2147483647)
          {
            AppMethodBeat.o(107423);
            return 4;
          }
          AppMethodBeat.o(107423);
          return 1;
        }
      };
    }
    GridLayoutManager localGridLayoutManager = this.nMI;
    AppMethodBeat.o(107431);
    return localGridLayoutManager;
  }
  
  public final boolean cjJ()
  {
    AppMethodBeat.i(107437);
    boolean bool = e.a.cjQ().qjU;
    AppMethodBeat.o(107437);
    return bool;
  }
  
  public final void cjK()
  {
    AppMethodBeat.i(107435);
    this.qkt.qjZ = true;
    e.a.cjQ().qjU = true;
    GridLayoutManager localGridLayoutManager = (GridLayoutManager)bNL();
    int i = localGridLayoutManager.jO();
    int j = localGridLayoutManager.jQ();
    this.qkt.e(i, j - i + 1, Integer.valueOf(0));
    AppMethodBeat.o(107435);
  }
  
  public final void cjL()
  {
    AppMethodBeat.i(107436);
    this.qkt.qjZ = false;
    e.a.cjQ().clear();
    e.a.cjQ().qjU = false;
    this.qkt.aql.notifyChanged();
    AppMethodBeat.o(107436);
  }
  
  public final void cjR()
  {
    this.qku = true;
  }
  
  public final RecyclerView.h eC(final Context paramContext)
  {
    AppMethodBeat.i(107432);
    paramContext = new RecyclerView.h()
    {
      public final void a(Rect paramAnonymousRect, View paramAnonymousView, RecyclerView paramAnonymousRecyclerView, RecyclerView.s paramAnonymouss)
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
    if (this.qks != null)
    {
      this.qks.a(null);
      this.qks = null;
    }
    e locale = e.a.cjQ();
    locale.qjV.clear();
    locale.clear();
    locale.qjU = false;
    AppMethodBeat.o(107430);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(107438);
    if ((this.qku) && (e.a.cjQ().qjU))
    {
      this.qks.Cs(e.a.cjQ().qjT.size());
      this.qkt.aql.notifyChanged();
    }
    AppMethodBeat.o(107438);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.h
 * JD-Core Version:    0.7.0.1
 */