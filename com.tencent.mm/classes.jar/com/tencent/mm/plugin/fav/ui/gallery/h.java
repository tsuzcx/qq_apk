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
import com.tencent.mm.plugin.fav.a.ac;
import com.tencent.mm.plugin.fav.a.ah;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.r;
import com.tencent.mm.plugin.fav.ui.FavoriteImageServer;
import com.tencent.mm.plugin.fav.ui.q.c;
import com.tencent.mm.plugin.fav.ui.q.i;
import com.tencent.mm.protocal.protobuf.arf;
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
  g.b AnV;
  f AnW;
  boolean AnX;
  int AnY;
  int AnZ;
  f.b Anu;
  List<Long> idList;
  Context mContext;
  ArrayList<f.d> mDataList;
  private MMHandler mHandler;
  private GridLayoutManager wQC;
  
  public h(Context paramContext)
  {
    AppMethodBeat.i(107429);
    this.mDataList = null;
    this.AnX = false;
    this.mHandler = new MMHandler(Looper.getMainLooper());
    this.AnY = 0;
    this.idList = new ArrayList();
    this.AnZ = 0;
    this.mContext = paramContext;
    this.mDataList = new ArrayList();
    AppMethodBeat.o(107429);
  }
  
  public final void I(final boolean paramBoolean, final int paramInt)
  {
    AppMethodBeat.i(107439);
    this.AnW.wQp = true;
    this.AnV.nm(paramBoolean);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
    {
      public final void run()
      {
        int j = 100;
        AppMethodBeat.i(107428);
        if (paramBoolean)
        {
          h.this.mDataList.clear();
          h.this.AnZ = 0;
          localObject1 = new ArrayList();
          ((List)localObject1).add(Integer.valueOf(21));
          h.this.idList = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavSearchStorage().b(null, null, (List)localObject1);
          h.this.AnY = h.this.idList.size();
        }
        final int i = j;
        if (paramInt >= 0)
        {
          i = j;
          if (h.this.AnY - paramInt > 100) {
            i = h.this.AnY - paramInt;
          }
        }
        Log.i("MicroMsg.MediaHistoryGalleryPresenter", "offset:%s limit:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
        Object localObject1 = new LinkedList();
        while ((((LinkedList)localObject1).size() < i) && (h.this.AnZ < h.this.idList.size()))
        {
          int k = h.this.AnZ;
          if (k + i > h.this.idList.size()) {}
          for (j = h.this.idList.size();; j = k + i)
          {
            Object localObject2 = h.fP(h.this.idList.subList(k, j));
            h.this.AnZ = j;
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
            h.this.AnW.wQp = false;
            if (h.this.AnV != null) {
              h.this.AnV.F(h.5.this.wQx, i);
            }
            AppMethodBeat.o(107427);
          }
        });
        AppMethodBeat.o(107428);
      }
    });
    AppMethodBeat.o(107439);
  }
  
  public final void MN(int paramInt)
  {
    AppMethodBeat.i(107434);
    Log.i("MicroMsg.MediaHistoryGalleryPresenter", "[handleSelectedItem] type:%s", new Object[] { Integer.valueOf(paramInt) });
    ArrayList localArrayList = e.a.dSL().Ann;
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
      this.AnV.fN(localArrayList);
      this.AnV.dSG();
      AppMethodBeat.o(107434);
      return;
      this.AnV.fO(localArrayList);
      this.AnV.dSG();
    }
  }
  
  public final void a(f.b paramb)
  {
    this.Anu = paramb;
  }
  
  public final RecyclerView.a c(FavoriteImageServer paramFavoriteImageServer)
  {
    AppMethodBeat.i(274521);
    this.AnW = new f(this.mContext, this.mDataList, this.AnV, paramFavoriteImageServer, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(107425);
        Log.i("MicroMsg.MediaHistoryGalleryPresenter", "uiCallback()");
        h.this.I(true, -1);
        AppMethodBeat.o(107425);
      }
    });
    this.AnW.Ant = new f.c()
    {
      public final void a(boolean paramAnonymousBoolean, f.d paramAnonymousd, int paramAnonymousInt)
      {
        AppMethodBeat.i(107426);
        Log.i("MicroMsg.MediaHistoryGalleryPresenter", "[onCheck] isChecked :%s pos:%s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf(paramAnonymousInt) });
        if ((paramAnonymousBoolean) && (e.a.dSL().Ann.size() >= 9))
        {
          Toast.makeText(h.this.mContext, h.this.mContext.getResources().getString(q.i.fav_filter_gallery_select_limit, new Object[] { Integer.valueOf(9) }), 1).show();
          h.this.AnW.fV(paramAnonymousInt);
          AppMethodBeat.o(107426);
          return;
        }
        e locale;
        if (paramAnonymousBoolean)
        {
          locale = e.a.dSL();
          paramAnonymousd = paramAnonymousd.AnE;
          if (paramAnonymousd != null)
          {
            Log.i("MicroMsg.ImageGallerySelectedHandle", "add : %s", new Object[] { paramAnonymousd });
            locale.Ann.remove(paramAnonymousd);
            locale.Ann.remove(locale.auG(paramAnonymousd.hIT.hIQ));
            locale.Ann.add(paramAnonymousd);
            locale.dSK();
          }
        }
        for (;;)
        {
          h.this.AnV.ML(e.a.dSL().Ann.size());
          AppMethodBeat.o(107426);
          return;
          locale = e.a.dSL();
          paramAnonymousd = paramAnonymousd.AnE;
          if (paramAnonymousd != null)
          {
            Log.i("MicroMsg.ImageGallerySelectedHandle", "remove : %s", new Object[] { paramAnonymousd.hIT.hIQ });
            locale.Ann.remove(paramAnonymousd);
            locale.Ann.remove(locale.auG(paramAnonymousd.hIT.hIQ));
            locale.dSK();
          }
        }
      }
    };
    this.AnW.Anu = this.Anu;
    ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnStorage().a(this.AnW.Anv);
    paramFavoriteImageServer = this.AnW;
    AppMethodBeat.o(274521);
    return paramFavoriteImageServer;
  }
  
  public final boolean dSE()
  {
    AppMethodBeat.i(107437);
    boolean bool = e.a.dSL().Ano;
    AppMethodBeat.o(107437);
    return bool;
  }
  
  public final void dSF()
  {
    AppMethodBeat.i(107435);
    this.AnW.Anw = true;
    e.a.dSL().Ano = true;
    GridLayoutManager localGridLayoutManager = (GridLayoutManager)fT(this.mContext);
    int i = localGridLayoutManager.Ju();
    int j = localGridLayoutManager.Jw();
    this.AnW.e(i, j - i + 1, Integer.valueOf(0));
    AppMethodBeat.o(107435);
  }
  
  public final void dSG()
  {
    AppMethodBeat.i(107436);
    this.AnW.Anw = false;
    e.a.dSL().clear();
    e.a.dSL().Ano = false;
    this.AnW.bZE.notifyChanged();
    AppMethodBeat.o(107436);
  }
  
  public final void dSM()
  {
    this.AnX = true;
  }
  
  public final <T extends RecyclerView.LayoutManager> T fT(Context paramContext)
  {
    AppMethodBeat.i(274517);
    if (this.wQC == null)
    {
      this.wQC = new GridLayoutManager(4);
      this.wQC.bWq = new GridLayoutManager.b()
      {
        public final int fJ(int paramAnonymousInt)
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
    paramContext = this.wQC;
    AppMethodBeat.o(274517);
    return paramContext;
  }
  
  public final RecyclerView.h gl(final Context paramContext)
  {
    AppMethodBeat.i(274519);
    paramContext = new RecyclerView.h()
    {
      public final void a(Rect paramAnonymousRect, View paramAnonymousView, RecyclerView paramAnonymousRecyclerView, RecyclerView.s paramAnonymouss)
      {
        AppMethodBeat.i(274508);
        int i = (int)paramContext.getResources().getDimension(q.c.OneDPPadding);
        paramAnonymousRect.bottom = i;
        paramAnonymousRect.top = i;
        paramAnonymousRect.left = i;
        paramAnonymousRect.right = i;
        AppMethodBeat.o(274508);
      }
    };
    AppMethodBeat.o(274519);
    return paramContext;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(107430);
    if (this.AnV != null)
    {
      this.AnV.a(null);
      this.AnV = null;
    }
    e locale = e.a.dSL();
    locale.Anp.clear();
    locale.clear();
    locale.Ano = false;
    ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnStorage().b(this.AnW.Anv);
    AppMethodBeat.o(107430);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(107438);
    if ((this.AnX) && (e.a.dSL().Ano))
    {
      this.AnV.ML(e.a.dSL().Ann.size());
      this.AnW.bZE.notifyChanged();
    }
    AppMethodBeat.o(107438);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.h
 * JD-Core Version:    0.7.0.1
 */