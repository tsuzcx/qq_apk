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
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
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
  ArrayList<f.c> ijj;
  Context mContext;
  private ao mHandler;
  private GridLayoutManager opI;
  g.b qSU;
  f qSV;
  boolean qSW;
  int qSX;
  int qSY;
  
  public h(Context paramContext)
  {
    AppMethodBeat.i(107429);
    this.ijj = null;
    this.qSW = false;
    this.mHandler = new ao(Looper.getMainLooper());
    this.qSX = 0;
    this.idList = new ArrayList();
    this.qSY = 0;
    this.mContext = paramContext;
    this.ijj = new ArrayList();
    AppMethodBeat.o(107429);
  }
  
  public final void Dp(int paramInt)
  {
    AppMethodBeat.i(107434);
    ac.i("MicroMsg.MediaHistoryGalleryPresenter", "[handleSelectedItem] type:%s", new Object[] { Integer.valueOf(paramInt) });
    ArrayList localArrayList = e.a.crx().qSv;
    if ((localArrayList == null) || (localArrayList.size() == 0))
    {
      ac.i("MicroMsg.MediaHistoryGalleryPresenter", "handleSelectedItem() list == null");
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
      this.qSU.dt(localArrayList);
      this.qSU.crs();
      AppMethodBeat.o(107434);
      return;
      this.qSU.du(localArrayList);
      this.qSU.crs();
    }
  }
  
  public final void E(final boolean paramBoolean, final int paramInt)
  {
    AppMethodBeat.i(107439);
    this.qSV.opw = true;
    this.qSU.js(paramBoolean);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agU().az(new Runnable()
    {
      public final void run()
      {
        int j = 100;
        AppMethodBeat.i(107428);
        if (paramBoolean)
        {
          h.this.ijj.clear();
          h.this.qSY = 0;
          localObject1 = new ArrayList();
          ((List)localObject1).add(Integer.valueOf(21));
          h.this.idList = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavSearchStorage().b(null, null, (List)localObject1);
          h.this.qSX = h.this.idList.size();
        }
        final int i = j;
        if (paramInt >= 0)
        {
          i = j;
          if (h.this.qSX - paramInt > 100) {
            i = h.this.qSX - paramInt;
          }
        }
        ac.i("MicroMsg.MediaHistoryGalleryPresenter", "offset:%s limit:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
        Object localObject1 = new LinkedList();
        while ((((LinkedList)localObject1).size() < i) && (h.this.qSY < h.this.idList.size()))
        {
          int k = h.this.qSY;
          if (k + i > h.this.idList.size()) {}
          for (j = h.this.idList.size();; j = k + i)
          {
            Object localObject2 = h.dv(h.this.idList.subList(k, j));
            h.this.qSY = j;
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext()) {
              ((LinkedList)localObject1).addAll(h.I((com.tencent.mm.plugin.fav.a.g)((Iterator)localObject2).next()));
            }
          }
          ac.i("MicroMsg.MediaHistoryGalleryPresenter", "traverse until size ok. start:%s, end:%s, idListSize:%s, limit:%s, linklistSize:%s", new Object[] { Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(h.this.idList.size()), Integer.valueOf(i), Integer.valueOf(((LinkedList)localObject1).size()) });
        }
        i = ((LinkedList)localObject1).size();
        Collections.reverse((List)localObject1);
        h.this.ijj.addAll(0, (Collection)localObject1);
        ((LinkedList)localObject1).clear();
        ac.i("MicroMsg.MediaHistoryGalleryPresenter", "[loadData] %s", new Object[] { Integer.valueOf(h.this.ijj.size()) });
        ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(107427);
            h.this.qSV.opw = false;
            if (h.this.qSU != null) {
              h.this.qSU.B(h.5.this.opD, i);
            }
            AppMethodBeat.o(107427);
          }
        });
        AppMethodBeat.o(107428);
      }
    });
    AppMethodBeat.o(107439);
  }
  
  public final RecyclerView.a bUV()
  {
    AppMethodBeat.i(107433);
    this.qSV = new f(this.mContext, this.ijj, this.qSU, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(107425);
        ac.i("MicroMsg.MediaHistoryGalleryPresenter", "uiCallback()");
        h.this.E(true, -1);
        AppMethodBeat.o(107425);
      }
    });
    this.qSV.qSA = new f.b()
    {
      public final void a(boolean paramAnonymousBoolean, f.c paramAnonymousc, int paramAnonymousInt)
      {
        AppMethodBeat.i(107426);
        ac.i("MicroMsg.MediaHistoryGalleryPresenter", "[onCheck] isChecked :%s pos:%s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf(paramAnonymousInt) });
        if ((paramAnonymousBoolean) && (e.a.crx().qSv.size() >= 9))
        {
          Toast.makeText(h.this.mContext, h.this.mContext.getResources().getString(2131758830, new Object[] { Integer.valueOf(9) }), 1).show();
          h.this.qSV.cj(paramAnonymousInt);
          AppMethodBeat.o(107426);
          return;
        }
        e locale;
        if (paramAnonymousBoolean)
        {
          locale = e.a.crx();
          paramAnonymousc = paramAnonymousc.qSD;
          if (paramAnonymousc != null)
          {
            ac.i("MicroMsg.ImageGallerySelectedHandle", "add : %s", new Object[] { paramAnonymousc });
            locale.qSv.remove(paramAnonymousc);
            locale.qSv.remove(locale.adb(paramAnonymousc.dhz.dhw));
            locale.qSv.add(paramAnonymousc);
            locale.crw();
          }
        }
        for (;;)
        {
          h.this.qSU.Dn(e.a.crx().qSv.size());
          AppMethodBeat.o(107426);
          return;
          locale = e.a.crx();
          paramAnonymousc = paramAnonymousc.qSD;
          if (paramAnonymousc != null)
          {
            ac.i("MicroMsg.ImageGallerySelectedHandle", "remove : %s", new Object[] { paramAnonymousc.dhz.dhw });
            locale.qSv.remove(paramAnonymousc);
            locale.qSv.remove(locale.adb(paramAnonymousc.dhz.dhw));
            locale.crw();
          }
        }
      }
    };
    f localf = this.qSV;
    AppMethodBeat.o(107433);
    return localf;
  }
  
  public final <T extends RecyclerView.i> T bUW()
  {
    AppMethodBeat.i(107431);
    if (this.opI == null)
    {
      this.opI = new GridLayoutManager(4);
      this.opI.anN = new GridLayoutManager.b()
      {
        public final int bW(int paramAnonymousInt)
        {
          AppMethodBeat.i(107423);
          if (paramAnonymousInt >= h.this.ijj.size())
          {
            AppMethodBeat.o(107423);
            return 4;
          }
          if (((f.c)h.this.ijj.get(paramAnonymousInt)).type == 2147483647)
          {
            AppMethodBeat.o(107423);
            return 4;
          }
          AppMethodBeat.o(107423);
          return 1;
        }
      };
    }
    GridLayoutManager localGridLayoutManager = this.opI;
    AppMethodBeat.o(107431);
    return localGridLayoutManager;
  }
  
  public final boolean crq()
  {
    AppMethodBeat.i(107437);
    boolean bool = e.a.crx().qSw;
    AppMethodBeat.o(107437);
    return bool;
  }
  
  public final void crr()
  {
    AppMethodBeat.i(107435);
    this.qSV.qSB = true;
    e.a.crx().qSw = true;
    GridLayoutManager localGridLayoutManager = (GridLayoutManager)bUW();
    int i = localGridLayoutManager.jW();
    int j = localGridLayoutManager.jY();
    this.qSV.e(i, j - i + 1, Integer.valueOf(0));
    AppMethodBeat.o(107435);
  }
  
  public final void crs()
  {
    AppMethodBeat.i(107436);
    this.qSV.qSB = false;
    e.a.crx().clear();
    e.a.crx().qSw = false;
    this.qSV.arg.notifyChanged();
    AppMethodBeat.o(107436);
  }
  
  public final void cry()
  {
    this.qSW = true;
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
    if (this.qSU != null)
    {
      this.qSU.a(null);
      this.qSU = null;
    }
    e locale = e.a.crx();
    locale.qSx.clear();
    locale.clear();
    locale.qSw = false;
    AppMethodBeat.o(107430);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(107438);
    if ((this.qSW) && (e.a.crx().qSw))
    {
      this.qSU.Dn(e.a.crx().qSv.size());
      this.qSV.arg.notifyChanged();
    }
    AppMethodBeat.o(107438);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.h
 * JD-Core Version:    0.7.0.1
 */