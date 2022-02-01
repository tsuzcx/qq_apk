package com.tencent.mm.plugin.fav.ui.gallery;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Looper;
import android.view.View;
import android.widget.Toast;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.GridLayoutManager.b;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.ab;
import com.tencent.mm.plugin.fav.a.ag;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.r;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.plugin.fav.ui.s.c;
import com.tencent.mm.plugin.fav.ui.s.i;
import com.tencent.mm.protocal.protobuf.anm;
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
  private GridLayoutManager tNm;
  f.b wQQ;
  g.b wRs;
  f wRt;
  boolean wRu;
  int wRv;
  int wRw;
  
  public h(Context paramContext)
  {
    AppMethodBeat.i(107429);
    this.mDataList = null;
    this.wRu = false;
    this.mHandler = new MMHandler(Looper.getMainLooper());
    this.wRv = 0;
    this.idList = new ArrayList();
    this.wRw = 0;
    this.mContext = paramContext;
    this.mDataList = new ArrayList();
    AppMethodBeat.o(107429);
  }
  
  public final void K(final boolean paramBoolean, final int paramInt)
  {
    AppMethodBeat.i(107439);
    this.wRt.tMZ = true;
    this.wRs.lR(paramBoolean);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
    {
      public final void run()
      {
        int j = 100;
        AppMethodBeat.i(107428);
        if (paramBoolean)
        {
          h.this.mDataList.clear();
          h.this.wRw = 0;
          localObject1 = new ArrayList();
          ((List)localObject1).add(Integer.valueOf(21));
          h.this.idList = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavSearchStorage().b(null, null, (List)localObject1);
          h.this.wRv = h.this.idList.size();
        }
        final int i = j;
        if (paramInt >= 0)
        {
          i = j;
          if (h.this.wRv - paramInt > 100) {
            i = h.this.wRv - paramInt;
          }
        }
        Log.i("MicroMsg.MediaHistoryGalleryPresenter", "offset:%s limit:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
        Object localObject1 = new LinkedList();
        while ((((LinkedList)localObject1).size() < i) && (h.this.wRw < h.this.idList.size()))
        {
          int k = h.this.wRw;
          if (k + i > h.this.idList.size()) {}
          for (j = h.this.idList.size();; j = k + i)
          {
            Object localObject2 = h.dU(h.this.idList.subList(k, j));
            h.this.wRw = j;
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext()) {
              ((LinkedList)localObject1).addAll(h.I((g)((Iterator)localObject2).next()));
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
            h.this.wRt.tMZ = false;
            if (h.this.wRs != null) {
              h.this.wRs.H(h.5.this.tNh, i);
            }
            AppMethodBeat.o(107427);
          }
        });
        AppMethodBeat.o(107428);
      }
    });
    AppMethodBeat.o(107439);
  }
  
  public final void LQ(int paramInt)
  {
    AppMethodBeat.i(107434);
    Log.i("MicroMsg.MediaHistoryGalleryPresenter", "[handleSelectedItem] type:%s", new Object[] { Integer.valueOf(paramInt) });
    ArrayList localArrayList = e.a.dlV().wQK;
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
      this.wRs.dS(localArrayList);
      this.wRs.dlQ();
      AppMethodBeat.o(107434);
      return;
      this.wRs.dT(localArrayList);
      this.wRs.dlQ();
    }
  }
  
  public final void a(f.b paramb)
  {
    this.wQQ = paramb;
  }
  
  public final RecyclerView.a c(o paramo)
  {
    AppMethodBeat.i(230013);
    this.wRt = new f(this.mContext, this.mDataList, this.wRs, paramo, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(107425);
        Log.i("MicroMsg.MediaHistoryGalleryPresenter", "uiCallback()");
        h.this.K(true, -1);
        AppMethodBeat.o(107425);
      }
    });
    this.wRt.wQP = new f.c()
    {
      public final void a(boolean paramAnonymousBoolean, f.d paramAnonymousd, int paramAnonymousInt)
      {
        AppMethodBeat.i(107426);
        Log.i("MicroMsg.MediaHistoryGalleryPresenter", "[onCheck] isChecked :%s pos:%s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf(paramAnonymousInt) });
        if ((paramAnonymousBoolean) && (e.a.dlV().wQK.size() >= 9))
        {
          Toast.makeText(h.this.mContext, h.this.mContext.getResources().getString(s.i.fav_filter_gallery_select_limit, new Object[] { Integer.valueOf(9) }), 1).show();
          h.this.wRt.cL(paramAnonymousInt);
          AppMethodBeat.o(107426);
          return;
        }
        e locale;
        if (paramAnonymousBoolean)
        {
          locale = e.a.dlV();
          paramAnonymousd = paramAnonymousd.wRa;
          if (paramAnonymousd != null)
          {
            Log.i("MicroMsg.ImageGallerySelectedHandle", "add : %s", new Object[] { paramAnonymousd });
            locale.wQK.remove(paramAnonymousd);
            locale.wQK.remove(locale.aAy(paramAnonymousd.fEd.fEa));
            locale.wQK.add(paramAnonymousd);
            locale.dlU();
          }
        }
        for (;;)
        {
          h.this.wRs.LO(e.a.dlV().wQK.size());
          AppMethodBeat.o(107426);
          return;
          locale = e.a.dlV();
          paramAnonymousd = paramAnonymousd.wRa;
          if (paramAnonymousd != null)
          {
            Log.i("MicroMsg.ImageGallerySelectedHandle", "remove : %s", new Object[] { paramAnonymousd.fEd.fEa });
            locale.wQK.remove(paramAnonymousd);
            locale.wQK.remove(locale.aAy(paramAnonymousd.fEd.fEa));
            locale.dlU();
          }
        }
      }
    };
    this.wRt.wQQ = this.wQQ;
    ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnStorage().a(this.wRt.wQR);
    paramo = this.wRt;
    AppMethodBeat.o(230013);
    return paramo;
  }
  
  public final boolean dlO()
  {
    AppMethodBeat.i(107437);
    boolean bool = e.a.dlV().wQL;
    AppMethodBeat.o(107437);
    return bool;
  }
  
  public final void dlP()
  {
    AppMethodBeat.i(107435);
    this.wRt.wQS = true;
    e.a.dlV().wQL = true;
    GridLayoutManager localGridLayoutManager = (GridLayoutManager)eW(this.mContext);
    int i = localGridLayoutManager.kJ();
    int j = localGridLayoutManager.kL();
    this.wRt.e(i, j - i + 1, Integer.valueOf(0));
    AppMethodBeat.o(107435);
  }
  
  public final void dlQ()
  {
    AppMethodBeat.i(107436);
    this.wRt.wQS = false;
    e.a.dlV().clear();
    e.a.dlV().wQL = false;
    this.wRt.alc.notifyChanged();
    AppMethodBeat.o(107436);
  }
  
  public final void dlW()
  {
    this.wRu = true;
  }
  
  public final <T extends RecyclerView.LayoutManager> T eW(Context paramContext)
  {
    AppMethodBeat.i(230011);
    if (this.tNm == null)
    {
      this.tNm = new GridLayoutManager(4);
      this.tNm.ahK = new GridLayoutManager.b()
      {
        public final int cx(int paramAnonymousInt)
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
    paramContext = this.tNm;
    AppMethodBeat.o(230011);
    return paramContext;
  }
  
  public final RecyclerView.h fn(final Context paramContext)
  {
    AppMethodBeat.i(230012);
    paramContext = new RecyclerView.h()
    {
      public final void a(Rect paramAnonymousRect, View paramAnonymousView, RecyclerView paramAnonymousRecyclerView, RecyclerView.s paramAnonymouss)
      {
        AppMethodBeat.i(232210);
        int i = (int)paramContext.getResources().getDimension(s.c.OneDPPadding);
        paramAnonymousRect.bottom = i;
        paramAnonymousRect.top = i;
        paramAnonymousRect.left = i;
        paramAnonymousRect.right = i;
        AppMethodBeat.o(232210);
      }
    };
    AppMethodBeat.o(230012);
    return paramContext;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(107430);
    if (this.wRs != null)
    {
      this.wRs.a(null);
      this.wRs = null;
    }
    e locale = e.a.dlV();
    locale.wQM.clear();
    locale.clear();
    locale.wQL = false;
    ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnStorage().b(this.wRt.wQR);
    AppMethodBeat.o(107430);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(107438);
    if ((this.wRu) && (e.a.dlV().wQL))
    {
      this.wRs.LO(e.a.dlV().wQK.size());
      this.wRt.alc.notifyChanged();
    }
    AppMethodBeat.o(107438);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.h
 * JD-Core Version:    0.7.0.1
 */