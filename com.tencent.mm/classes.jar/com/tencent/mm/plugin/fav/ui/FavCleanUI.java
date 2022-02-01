package com.tencent.mm.plugin.fav.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewStub;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.plugin.fav.a.ag;
import com.tencent.mm.plugin.fav.a.am;
import com.tencent.mm.plugin.fav.a.d;
import com.tencent.mm.plugin.fav.a.d.a;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.e.b.c;
import com.tencent.mm.plugin.fav.ui.widget.a.a;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ad;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FavCleanUI
  extends MMActivity
  implements b.c
{
  protected MMHandler knk;
  private o wJE;
  private com.tencent.mm.plugin.fav.ui.a.b wJF;
  private ListView wJG;
  private TextView wJH;
  private com.tencent.mm.plugin.fav.ui.widget.a wJI;
  private boolean wJJ;
  private int wJK;
  private d.a wJL;
  private i wJM;
  private boolean wJi;
  protected boolean wJj;
  private long wJl;
  protected View wJn;
  private View wJo;
  private Runnable wJv;
  protected Runnable wJw;
  protected MMHandler workerHandler;
  
  public FavCleanUI()
  {
    AppMethodBeat.i(106647);
    this.wJi = false;
    this.knk = new MMHandler(Looper.getMainLooper());
    this.wJJ = false;
    this.wJK = 0;
    this.wJL = new d.a()
    {
      public final void onFinish()
      {
        AppMethodBeat.i(106637);
        Log.i("MicroMsg.FavCleanUI", "FavCleanFirstLoader onRefreshed()");
        FavCleanUI.c(FavCleanUI.this);
        FavCleanUI.d(FavCleanUI.this);
        AppMethodBeat.o(106637);
      }
    };
    this.wJM = new i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(106644);
        Log.i("MicroMsg.FavCleanUI", "on getfavinfo scene end");
        if (FavCleanUI.f(FavCleanUI.this) != null) {
          FavCleanUI.f(FavCleanUI.this).wSJ = com.tencent.mm.plugin.fav.a.b.djn();
        }
        AppMethodBeat.o(106644);
      }
    };
    this.wJv = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106645);
        if (FavCleanUI.e(FavCleanUI.this) != null) {
          FavCleanUI.e(FavCleanUI.this).byN();
        }
        FavCleanUI.this.dkK();
        AppMethodBeat.o(106645);
      }
    };
    this.wJl = 0L;
    this.wJj = false;
    this.wJw = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106646);
        if (FavCleanUI.e(FavCleanUI.this) == null)
        {
          AppMethodBeat.o(106646);
          return;
        }
        if ((!FavCleanUI.e(FavCleanUI.this).isEmpty()) && (SystemClock.elapsedRealtime() - FavCleanUI.h(FavCleanUI.this) < 1000L))
        {
          Log.d("MicroMsg.FavCleanUI", "try refresh, time limit, now %d last %d delay %d", new Object[] { Long.valueOf(SystemClock.elapsedRealtime()), Long.valueOf(FavCleanUI.h(FavCleanUI.this)), Integer.valueOf(1000) });
          FavCleanUI.this.knk.postDelayed(this, 500L);
          AppMethodBeat.o(106646);
          return;
        }
        FavCleanUI.i(FavCleanUI.this);
        FavCleanUI.a(FavCleanUI.this, SystemClock.elapsedRealtime());
        Log.v("MicroMsg.FavCleanUI", "do refresh job");
        FavCleanUI.d(FavCleanUI.this);
        if (FavCleanUI.this.wJj)
        {
          Log.v("MicroMsg.FavCleanUI", "do scroll to first");
          FavCleanUI.j(FavCleanUI.this).setSelection(0);
          FavCleanUI.this.wJj = false;
        }
        AppMethodBeat.o(106646);
      }
    };
    AppMethodBeat.o(106647);
  }
  
  private void nO(boolean paramBoolean)
  {
    AppMethodBeat.i(106655);
    if (paramBoolean)
    {
      this.wJo.setVisibility(8);
      this.wJH.setVisibility(0);
      this.wJG.removeFooterView(this.wJn);
      if (this.wJI != null)
      {
        this.wJI.hide();
        AppMethodBeat.o(106655);
      }
    }
    else
    {
      this.wJo.setVisibility(8);
      this.wJH.setVisibility(8);
      this.wJG.removeFooterView(this.wJn);
      if (this.wJI != null) {
        this.wJI.show();
      }
    }
    AppMethodBeat.o(106655);
  }
  
  private void nP(boolean paramBoolean)
  {
    AppMethodBeat.i(106656);
    if (paramBoolean)
    {
      if (this.wJG.getFooterViewsCount() == 0)
      {
        this.wJG.addFooterView(this.wJn);
        AppMethodBeat.o(106656);
      }
    }
    else {
      this.wJG.removeFooterView(this.wJn);
    }
    AppMethodBeat.o(106656);
  }
  
  public final void Kq(long paramLong)
  {
    AppMethodBeat.i(106658);
    Object localObject = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().Km(paramLong);
    if ((localObject != null) && (((g)localObject).field_favProto != null) && (((g)localObject).field_favProto.syG.size() != 0))
    {
      localObject = ((g)localObject).field_favProto.syG.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((Iterator)localObject).next();
      }
    }
    if (this.wJF.wNJ)
    {
      localObject = this.wJI;
      if (this.wJF.dlw() > 0) {}
      for (boolean bool = true;; bool = false)
      {
        if (((com.tencent.mm.plugin.fav.ui.widget.a)localObject).wSL) {
          ((com.tencent.mm.plugin.fav.ui.widget.a)localObject).nbe.setEnabled(bool);
        }
        localObject = this.wJI;
        List localList = this.wJF.nS(false);
        paramLong = this.wJF.dlx();
        if ((localList.size() == 0) || (paramLong <= 0L)) {
          break;
        }
        ((com.tencent.mm.plugin.fav.ui.widget.a)localObject).tPq.setText(((com.tencent.mm.plugin.fav.ui.widget.a)localObject).tPq.getContext().getString(s.i.fav_clean_delete_info, new Object[] { com.tencent.mm.plugin.fav.a.b.Kd(paramLong) }));
        ((com.tencent.mm.plugin.fav.ui.widget.a)localObject).nbe.setEnabled(true);
        AppMethodBeat.o(106658);
        return;
      }
      ((com.tencent.mm.plugin.fav.ui.widget.a)localObject).dlY();
    }
    AppMethodBeat.o(106658);
  }
  
  protected final void dkK()
  {
    AppMethodBeat.i(106654);
    Log.i("MicroMsg.FavCleanUI", "on storage change, try refresh job");
    this.knk.removeCallbacks(this.wJw);
    this.knk.post(this.wJw);
    AppMethodBeat.o(106654);
  }
  
  public int getLayoutId()
  {
    return s.f.fav_clean_ui;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(106653);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(106653);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(106657);
    finish();
    super.onBackPressed();
    AppMethodBeat.o(106657);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(106648);
    super.onCreate(paramBundle);
    this.wJK = getIntent().getIntExtra("key_enter_fav_cleanui_from", 0);
    this.workerHandler = new MMHandler(getClass().getName() + "_handlerThread_" + System.currentTimeMillis());
    this.wJG = ((ListView)findViewById(s.e.fav_clean_list));
    setMMTitle(s.i.fav_clean_title);
    this.wJJ = true;
    paramBundle = new am();
    com.tencent.mm.kernel.h.aGY().a(paramBundle, 0);
    com.tencent.mm.kernel.h.aGY().a(438, this.wJM);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(106635);
        FavCleanUI.this.finish();
        AppMethodBeat.o(106635);
        return true;
      }
    });
    paramBundle = (ViewStub)findViewById(s.e.empty_load_view_stub);
    if (paramBundle != null) {}
    for (this.wJo = paramBundle.inflate();; this.wJo = findViewById(s.e.favorite_loading))
    {
      this.wJH = ((TextView)findViewById(s.e.empty_fav_view));
      this.wJo.setVisibility(0);
      this.wJH.setVisibility(8);
      this.wJG.removeFooterView(this.wJn);
      if (this.wJI != null) {
        this.wJI.hide();
      }
      this.wJn = ad.kS(this).inflate(s.f.fav_loading_footer, null);
      this.wJG.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
        {
          AppMethodBeat.i(106636);
          if ((paramAnonymousInt == 0) && (FavCleanUI.a(FavCleanUI.this)))
          {
            Log.i("MicroMsg.FavCleanUI", "force bottom load data");
            FavCleanUI.b(FavCleanUI.this);
          }
          AppMethodBeat.o(106636);
        }
      });
      if (this.wJJ)
      {
        this.wJI = new com.tencent.mm.plugin.fav.ui.widget.a();
        paramBundle = this.wJI;
        View localView = findViewById(s.e.fav_clean_footer);
        paramBundle.wSL = false;
        paramBundle.wSM = localView;
        this.wJI.wSN = new a.a()
        {
          public final void dkL()
          {
            AppMethodBeat.i(106643);
            com.tencent.mm.ui.base.h.a(FavCleanUI.this.getContext(), FavCleanUI.this.getString(s.i.fav_clean_delete_tips), "", new DialogInterface.OnClickListener()
            {
              public final void onClick(final DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(106642);
                long l = FavCleanUI.e(FavCleanUI.this).dlx();
                paramAnonymous2DialogInterface = FavCleanUI.e(FavCleanUI.this).nS(true);
                Object localObject = FavCleanUI.f(FavCleanUI.this);
                ((com.tencent.mm.plugin.fav.ui.widget.a)localObject).wSJ += l;
                com.tencent.mm.plugin.fav.a.b.JV(com.tencent.mm.plugin.fav.a.b.djp() - l);
                if (paramAnonymous2DialogInterface.isEmpty())
                {
                  AppMethodBeat.o(106642);
                  return;
                }
                com.tencent.mm.plugin.report.service.h.IzE.a(14110, new Object[] { Integer.valueOf(FavCleanUI.g(FavCleanUI.this)), Integer.valueOf(paramAnonymous2DialogInterface.size()), Integer.valueOf((int)(l * 1.0D / 1024.0D)) });
                localObject = com.tencent.mm.ui.base.h.a(FavCleanUI.this.getContext(), FavCleanUI.this.getString(s.i.favorite_delete_tips), false, null);
                com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(106641);
                    com.tencent.mm.plugin.fav.a.b.dJ(paramAnonymous2DialogInterface);
                    MMHandlerThread.postToMainThread(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(106639);
                        com.tencent.mm.plugin.fav.ui.a.b localb = FavCleanUI.e(FavCleanUI.this);
                        List localList = FavCleanUI.5.1.1.this.wJP;
                        ArrayList localArrayList;
                        Iterator localIterator1;
                        if (localb.wNx != null)
                        {
                          localArrayList = new ArrayList();
                          localIterator1 = localb.wNx.iterator();
                        }
                        label333:
                        label338:
                        for (;;)
                        {
                          Object localObject;
                          Iterator localIterator2;
                          g localg;
                          if (localIterator1.hasNext())
                          {
                            localObject = (g)localIterator1.next();
                            if (localObject != null)
                            {
                              localIterator2 = localList.iterator();
                              do
                              {
                                if (!localIterator2.hasNext()) {
                                  break;
                                }
                                localg = (g)localIterator2.next();
                              } while ((localg == null) || (((g)localObject).field_localId != localg.field_localId));
                            }
                          }
                          else
                          {
                            for (int i = 1;; i = 0)
                            {
                              if (i != 0) {
                                break label338;
                              }
                              localArrayList.add(localObject);
                              break;
                              localb.wNx = localArrayList;
                              localArrayList = new ArrayList();
                              localIterator1 = localb.wNA.iterator();
                              for (;;)
                              {
                                if (localIterator1.hasNext())
                                {
                                  localObject = (Long)localIterator1.next();
                                  localIterator2 = localList.iterator();
                                  do
                                  {
                                    if (!localIterator2.hasNext()) {
                                      break;
                                    }
                                    localg = (g)localIterator2.next();
                                  } while ((localg == null) || (!((Long)localObject).equals(Long.valueOf(localg.field_localId))));
                                }
                                for (i = 1;; i = 0)
                                {
                                  if (i != 0) {
                                    break label333;
                                  }
                                  localArrayList.add(localObject);
                                  break;
                                  localb.wNA = localArrayList;
                                  FavCleanUI.e(FavCleanUI.this).notifyDataSetChanged();
                                  FavCleanUI.f(FavCleanUI.this).dlY();
                                  FavCleanUI.5.1.1.this.wJe.dismiss();
                                  AppMethodBeat.o(106639);
                                  return;
                                }
                              }
                            }
                          }
                        }
                      }
                      
                      public final String toString()
                      {
                        AppMethodBeat.i(106640);
                        String str = super.toString() + "|batchDelFavItems";
                        AppMethodBeat.o(106640);
                        return str;
                      }
                    });
                    AppMethodBeat.o(106641);
                  }
                });
                com.tencent.mm.plugin.report.service.h.IzE.a(11125, new Object[] { Integer.valueOf(paramAnonymous2DialogInterface.size()), Integer.valueOf(3) });
                AppMethodBeat.o(106642);
              }
            }, null);
            AppMethodBeat.o(106643);
          }
        };
        this.wJJ = false;
      }
      d.djy().a(this.wJL);
      AppMethodBeat.o(106648);
      return;
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(106650);
    Log.d("MicroMsg.FavCleanUI", "on create options menu");
    boolean bool = super.onCreateOptionsMenu(paramMenu);
    AppMethodBeat.o(106650);
    return bool;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(106649);
    super.onDestroy();
    d locald = d.djy();
    d.a locala = this.wJL;
    if (locald.wGc.contains(locala)) {
      locald.wGc.remove(locala);
    }
    if (this.wJE != null)
    {
      this.wJE.destory();
      this.wJE = null;
    }
    this.workerHandler.quit();
    com.tencent.mm.kernel.h.aGY().b(438, this.wJM);
    AppMethodBeat.o(106649);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(106651);
    boolean bool = super.onOptionsItemSelected(paramMenuItem);
    AppMethodBeat.o(106651);
    return bool;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(106652);
    super.onResume();
    AppMethodBeat.o(106652);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavCleanUI
 * JD-Core Version:    0.7.0.1
 */