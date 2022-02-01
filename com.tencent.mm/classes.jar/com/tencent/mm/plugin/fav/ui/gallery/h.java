package com.tencent.mm.plugin.fav.ui.gallery;

import android.content.Context;
import android.content.res.Resources;
import android.os.Looper;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.b;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.h;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.aa;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
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
  private MMHandler mHandler;
  private GridLayoutManager qoD;
  g.b tkU;
  f tkV;
  boolean tkW;
  int tkX;
  int tkY;
  f.b tkz;
  
  public h(Context paramContext)
  {
    AppMethodBeat.i(107429);
    this.mDataList = null;
    this.tkW = false;
    this.mHandler = new MMHandler(Looper.getMainLooper());
    this.tkX = 0;
    this.idList = new ArrayList();
    this.tkY = 0;
    this.mContext = paramContext;
    this.mDataList = new ArrayList();
    AppMethodBeat.o(107429);
  }
  
  public final void G(final boolean paramBoolean, final int paramInt)
  {
    AppMethodBeat.i(107439);
    this.tkV.qor = true;
    this.tkU.kF(paramBoolean);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable()
    {
      public final void run()
      {
        int j = 100;
        AppMethodBeat.i(107428);
        if (paramBoolean)
        {
          h.this.mDataList.clear();
          h.this.tkY = 0;
          localObject1 = new ArrayList();
          ((List)localObject1).add(Integer.valueOf(21));
          h.this.idList = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavSearchStorage().b(null, null, (List)localObject1);
          h.this.tkX = h.this.idList.size();
        }
        final int i = j;
        if (paramInt >= 0)
        {
          i = j;
          if (h.this.tkX - paramInt > 100) {
            i = h.this.tkX - paramInt;
          }
        }
        Log.i("MicroMsg.MediaHistoryGalleryPresenter", "offset:%s limit:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
        Object localObject1 = new LinkedList();
        while ((((LinkedList)localObject1).size() < i) && (h.this.tkY < h.this.idList.size()))
        {
          int k = h.this.tkY;
          if (k + i > h.this.idList.size()) {}
          for (j = h.this.idList.size();; j = k + i)
          {
            Object localObject2 = h.dO(h.this.idList.subList(k, j));
            h.this.tkY = j;
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext()) {
              ((LinkedList)localObject1).addAll(h.I((com.tencent.mm.plugin.fav.a.g)((Iterator)localObject2).next()));
            }
          }
          Log.i("MicroMsg.MediaHistoryGalleryPresenter", "traverse until size ok. start:%s, end:%s, idListSize:%s, limit:%s, linklistSize:%s", new Object[] { Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(h.this.idList.size()), Integer.valueOf(i), Integer.valueOf(((LinkedList)localObject1).size()) });
        }
        i = ((LinkedList)localObject1).size();
        Collections.reverse((List)localObject1);
        h.this.mDataList.addAll(0, (Collection)localObject1);
        ((LinkedList)localObject1).clear();
        Log.i("MicroMsg.MediaHistoryGalleryPresenter", "[loadData] %s", new Object[] { Integer.valueOf(h.this.mDataList.size()) });
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(107427);
            h.this.tkV.qor = false;
            if (h.this.tkU != null) {
              h.this.tkU.D(h.5.this.qoy, i);
            }
            AppMethodBeat.o(107427);
          }
        });
        AppMethodBeat.o(107428);
      }
    });
    AppMethodBeat.o(107439);
  }
  
  public final void Ig(int paramInt)
  {
    AppMethodBeat.i(107434);
    Log.i("MicroMsg.MediaHistoryGalleryPresenter", "[handleSelectedItem] type:%s", new Object[] { Integer.valueOf(paramInt) });
    ArrayList localArrayList = e.a.cWN().tkt;
    if ((localArrayList == null) || (localArrayList.size() == 0))
    {
      Log.i("MicroMsg.MediaHistoryGalleryPresenter", "handleSelectedItem() list == null");
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
      this.tkU.dM(localArrayList);
      this.tkU.cWI();
      AppMethodBeat.o(107434);
      return;
      this.tkU.dN(localArrayList);
      this.tkU.cWI();
    }
  }
  
  public final void a(f.b paramb)
  {
    this.tkz = paramb;
  }
  
  public final boolean cWG()
  {
    AppMethodBeat.i(107437);
    boolean bool = e.a.cWN().tku;
    AppMethodBeat.o(107437);
    return bool;
  }
  
  public final void cWH()
  {
    AppMethodBeat.i(107435);
    this.tkV.tkA = true;
    e.a.cWN().tku = true;
    GridLayoutManager localGridLayoutManager = (GridLayoutManager)eS(this.mContext);
    int i = localGridLayoutManager.ks();
    int j = localGridLayoutManager.ku();
    this.tkV.e(i, j - i + 1, Integer.valueOf(0));
    AppMethodBeat.o(107435);
  }
  
  public final void cWI()
  {
    AppMethodBeat.i(107436);
    this.tkV.tkA = false;
    e.a.cWN().clear();
    e.a.cWN().tku = false;
    this.tkV.atj.notifyChanged();
    AppMethodBeat.o(107436);
  }
  
  public final void cWO()
  {
    this.tkW = true;
  }
  
  public final RecyclerView.a cyF()
  {
    AppMethodBeat.i(107433);
    this.tkV = new f(this.mContext, this.mDataList, this.tkU, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(107425);
        Log.i("MicroMsg.MediaHistoryGalleryPresenter", "uiCallback()");
        h.this.G(true, -1);
        AppMethodBeat.o(107425);
      }
    });
    this.tkV.tky = new f.c()
    {
      public final void a(boolean paramAnonymousBoolean, f.d paramAnonymousd, int paramAnonymousInt)
      {
        AppMethodBeat.i(107426);
        Log.i("MicroMsg.MediaHistoryGalleryPresenter", "[onCheck] isChecked :%s pos:%s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf(paramAnonymousInt) });
        if ((paramAnonymousBoolean) && (e.a.cWN().tkt.size() >= 9))
        {
          Toast.makeText(h.this.mContext, h.this.mContext.getResources().getString(2131759153, new Object[] { Integer.valueOf(9) }), 1).show();
          h.this.tkV.ci(paramAnonymousInt);
          AppMethodBeat.o(107426);
          return;
        }
        e locale;
        if (paramAnonymousBoolean)
        {
          locale = e.a.cWN();
          paramAnonymousd = paramAnonymousd.tkC;
          if (paramAnonymousd != null)
          {
            Log.i("MicroMsg.ImageGallerySelectedHandle", "add : %s", new Object[] { paramAnonymousd });
            locale.tkt.remove(paramAnonymousd);
            locale.tkt.remove(locale.asv(paramAnonymousd.dLo.dLl));
            locale.tkt.add(paramAnonymousd);
            locale.cWM();
          }
        }
        for (;;)
        {
          h.this.tkU.Ie(e.a.cWN().tkt.size());
          AppMethodBeat.o(107426);
          return;
          locale = e.a.cWN();
          paramAnonymousd = paramAnonymousd.tkC;
          if (paramAnonymousd != null)
          {
            Log.i("MicroMsg.ImageGallerySelectedHandle", "remove : %s", new Object[] { paramAnonymousd.dLo.dLl });
            locale.tkt.remove(paramAnonymousd);
            locale.tkt.remove(locale.asv(paramAnonymousd.dLo.dLl));
            locale.cWM();
          }
        }
      }
    };
    this.tkV.tkz = this.tkz;
    f localf = this.tkV;
    AppMethodBeat.o(107433);
    return localf;
  }
  
  public final <T extends RecyclerView.LayoutManager> T eS(Context paramContext)
  {
    AppMethodBeat.i(235374);
    if (this.qoD == null)
    {
      this.qoD = new GridLayoutManager(4);
      this.qoD.apR = new GridLayoutManager.b()
      {
        public final int bX(int paramAnonymousInt)
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
    paramContext = this.qoD;
    AppMethodBeat.o(235374);
    return paramContext;
  }
  
  public final RecyclerView.h fi(Context paramContext)
  {
    AppMethodBeat.i(107432);
    paramContext = new h.2(this, paramContext);
    AppMethodBeat.o(107432);
    return paramContext;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(107430);
    if (this.tkU != null)
    {
      this.tkU.a(null);
      this.tkU = null;
    }
    e locale = e.a.cWN();
    locale.tkv.clear();
    locale.clear();
    locale.tku = false;
    AppMethodBeat.o(107430);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(107438);
    if ((this.tkW) && (e.a.cWN().tku))
    {
      this.tkU.Ie(e.a.cWN().tkt.size());
      this.tkV.atj.notifyChanged();
    }
    AppMethodBeat.o(107438);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.h
 * JD-Core Version:    0.7.0.1
 */