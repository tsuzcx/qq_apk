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
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.al;
import com.tencent.mm.plugin.fav.a.d;
import com.tencent.mm.plugin.fav.a.d.a;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.ui.d.b.c;
import com.tencent.mm.plugin.fav.ui.widget.a.a;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FavCleanUI
  extends MMActivity
  implements b.c
{
  protected MMHandler hAk;
  private boolean tcX;
  protected boolean tcY;
  private d.a tdA;
  private i tdB;
  private long tda;
  protected View tdc;
  private View tdd;
  private Runnable tdk;
  protected Runnable tdl;
  private o tdt;
  private com.tencent.mm.plugin.fav.ui.a.b tdu;
  private ListView tdv;
  private TextView tdw;
  private com.tencent.mm.plugin.fav.ui.widget.a tdx;
  private boolean tdy;
  private int tdz;
  protected MMHandler workerHandler;
  
  public FavCleanUI()
  {
    AppMethodBeat.i(106647);
    this.tcX = false;
    this.hAk = new MMHandler(Looper.getMainLooper());
    this.tdy = false;
    this.tdz = 0;
    this.tdA = new d.a()
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
    this.tdB = new i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(106644);
        Log.i("MicroMsg.FavCleanUI", "on getfavinfo scene end");
        if (FavCleanUI.f(FavCleanUI.this) != null) {
          FavCleanUI.f(FavCleanUI.this).tml = com.tencent.mm.plugin.fav.a.b.cUh();
        }
        AppMethodBeat.o(106644);
      }
    };
    this.tdk = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106645);
        if (FavCleanUI.e(FavCleanUI.this) != null) {
          FavCleanUI.e(FavCleanUI.this).boE();
        }
        FavCleanUI.this.cVE();
        AppMethodBeat.o(106645);
      }
    };
    this.tda = 0L;
    this.tcY = false;
    this.tdl = new Runnable()
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
          FavCleanUI.this.hAk.postDelayed(this, 500L);
          AppMethodBeat.o(106646);
          return;
        }
        FavCleanUI.i(FavCleanUI.this);
        FavCleanUI.a(FavCleanUI.this, SystemClock.elapsedRealtime());
        Log.v("MicroMsg.FavCleanUI", "do refresh job");
        FavCleanUI.d(FavCleanUI.this);
        if (FavCleanUI.this.tcY)
        {
          Log.v("MicroMsg.FavCleanUI", "do scroll to first");
          FavCleanUI.j(FavCleanUI.this).setSelection(0);
          FavCleanUI.this.tcY = false;
        }
        AppMethodBeat.o(106646);
      }
    };
    AppMethodBeat.o(106647);
  }
  
  private void mB(boolean paramBoolean)
  {
    AppMethodBeat.i(106655);
    if (paramBoolean)
    {
      this.tdd.setVisibility(8);
      this.tdw.setVisibility(0);
      this.tdv.removeFooterView(this.tdc);
      if (this.tdx != null)
      {
        this.tdx.hide();
        AppMethodBeat.o(106655);
      }
    }
    else
    {
      this.tdd.setVisibility(8);
      this.tdw.setVisibility(8);
      this.tdv.removeFooterView(this.tdc);
      if (this.tdx != null) {
        this.tdx.show();
      }
    }
    AppMethodBeat.o(106655);
  }
  
  private void mC(boolean paramBoolean)
  {
    AppMethodBeat.i(106656);
    if (paramBoolean)
    {
      if (this.tdv.getFooterViewsCount() == 0)
      {
        this.tdv.addFooterView(this.tdc);
        AppMethodBeat.o(106656);
      }
    }
    else {
      this.tdv.removeFooterView(this.tdc);
    }
    AppMethodBeat.o(106656);
  }
  
  public final void Ec(long paramLong)
  {
    AppMethodBeat.i(106658);
    Object localObject = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(paramLong);
    if ((localObject != null) && (((com.tencent.mm.plugin.fav.a.g)localObject).field_favProto != null) && (((com.tencent.mm.plugin.fav.a.g)localObject).field_favProto.ppH.size() != 0))
    {
      localObject = ((com.tencent.mm.plugin.fav.a.g)localObject).field_favProto.ppH.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((Iterator)localObject).next();
      }
    }
    if (this.tdu.tht)
    {
      localObject = this.tdx;
      if (this.tdu.cWp() > 0) {}
      for (boolean bool = true;; bool = false)
      {
        if (((com.tencent.mm.plugin.fav.ui.widget.a)localObject).tmn) {
          ((com.tencent.mm.plugin.fav.ui.widget.a)localObject).kjo.setEnabled(bool);
        }
        localObject = this.tdx;
        List localList = this.tdu.mE(false);
        paramLong = this.tdu.cWq();
        if ((localList.size() == 0) || (paramLong <= 0L)) {
          break;
        }
        ((com.tencent.mm.plugin.fav.ui.widget.a)localObject).qqI.setText(((com.tencent.mm.plugin.fav.ui.widget.a)localObject).qqI.getContext().getString(2131759145, new Object[] { com.tencent.mm.plugin.fav.a.b.DP(paramLong) }));
        ((com.tencent.mm.plugin.fav.ui.widget.a)localObject).kjo.setEnabled(true);
        AppMethodBeat.o(106658);
        return;
      }
      ((com.tencent.mm.plugin.fav.ui.widget.a)localObject).cWQ();
    }
    AppMethodBeat.o(106658);
  }
  
  protected final void cVE()
  {
    AppMethodBeat.i(106654);
    Log.i("MicroMsg.FavCleanUI", "on storage change, try refresh job");
    this.hAk.removeCallbacks(this.tdl);
    this.hAk.post(this.tdl);
    AppMethodBeat.o(106654);
  }
  
  public int getLayoutId()
  {
    return 2131494109;
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
    this.tdz = getIntent().getIntExtra("key_enter_fav_cleanui_from", 0);
    this.workerHandler = new MMHandler(getClass().getName() + "_handlerThread_" + System.currentTimeMillis());
    this.tdv = ((ListView)findViewById(2131300446));
    setMMTitle(2131759150);
    this.tdy = true;
    paramBundle = new al();
    com.tencent.mm.kernel.g.azz().a(paramBundle, 0);
    com.tencent.mm.kernel.g.azz().a(438, this.tdB);
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
    paramBundle = (ViewStub)findViewById(2131300094);
    if (paramBundle != null) {}
    for (this.tdd = paramBundle.inflate();; this.tdd = findViewById(2131300546))
    {
      this.tdw = ((TextView)findViewById(2131300088));
      this.tdd.setVisibility(0);
      this.tdw.setVisibility(8);
      this.tdv.removeFooterView(this.tdc);
      if (this.tdx != null) {
        this.tdx.hide();
      }
      this.tdc = aa.jQ(this).inflate(2131494138, null);
      this.tdv.setOnScrollListener(new AbsListView.OnScrollListener()
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
      if (this.tdy)
      {
        this.tdx = new com.tencent.mm.plugin.fav.ui.widget.a();
        paramBundle = this.tdx;
        View localView = findViewById(2131300445);
        paramBundle.tmn = false;
        paramBundle.tmo = localView;
        this.tdx.tmp = new a.a()
        {
          public final void cVF()
          {
            AppMethodBeat.i(106643);
            com.tencent.mm.ui.base.h.a(FavCleanUI.this.getContext(), FavCleanUI.this.getString(2131759146), "", new DialogInterface.OnClickListener()
            {
              public final void onClick(final DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(106642);
                long l = FavCleanUI.e(FavCleanUI.this).cWq();
                paramAnonymous2DialogInterface = FavCleanUI.e(FavCleanUI.this).mE(true);
                Object localObject = FavCleanUI.f(FavCleanUI.this);
                ((com.tencent.mm.plugin.fav.ui.widget.a)localObject).tml += l;
                com.tencent.mm.plugin.fav.a.b.DH(com.tencent.mm.plugin.fav.a.b.cUj() - l);
                if (paramAnonymous2DialogInterface.isEmpty())
                {
                  AppMethodBeat.o(106642);
                  return;
                }
                com.tencent.mm.plugin.report.service.h.CyF.a(14110, new Object[] { Integer.valueOf(FavCleanUI.g(FavCleanUI.this)), Integer.valueOf(paramAnonymous2DialogInterface.size()), Integer.valueOf((int)(l * 1.0D / 1024.0D)) });
                localObject = com.tencent.mm.ui.base.h.a(FavCleanUI.this.getContext(), FavCleanUI.this.getString(2131759178), false, null);
                com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(106641);
                    com.tencent.mm.plugin.fav.a.b.dD(paramAnonymous2DialogInterface);
                    MMHandlerThread.postToMainThread(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(106639);
                        com.tencent.mm.plugin.fav.ui.a.b localb = FavCleanUI.e(FavCleanUI.this);
                        List localList = FavCleanUI.5.1.1.this.tdE;
                        ArrayList localArrayList;
                        Iterator localIterator1;
                        if (localb.thh != null)
                        {
                          localArrayList = new ArrayList();
                          localIterator1 = localb.thh.iterator();
                        }
                        label333:
                        label338:
                        for (;;)
                        {
                          Object localObject;
                          Iterator localIterator2;
                          com.tencent.mm.plugin.fav.a.g localg;
                          if (localIterator1.hasNext())
                          {
                            localObject = (com.tencent.mm.plugin.fav.a.g)localIterator1.next();
                            if (localObject != null)
                            {
                              localIterator2 = localList.iterator();
                              do
                              {
                                if (!localIterator2.hasNext()) {
                                  break;
                                }
                                localg = (com.tencent.mm.plugin.fav.a.g)localIterator2.next();
                              } while ((localg == null) || (((com.tencent.mm.plugin.fav.a.g)localObject).field_localId != localg.field_localId));
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
                              localb.thh = localArrayList;
                              localArrayList = new ArrayList();
                              localIterator1 = localb.thk.iterator();
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
                                    localg = (com.tencent.mm.plugin.fav.a.g)localIterator2.next();
                                  } while ((localg == null) || (!((Long)localObject).equals(Long.valueOf(localg.field_localId))));
                                }
                                for (i = 1;; i = 0)
                                {
                                  if (i != 0) {
                                    break label333;
                                  }
                                  localArrayList.add(localObject);
                                  break;
                                  localb.thk = localArrayList;
                                  FavCleanUI.e(FavCleanUI.this).notifyDataSetChanged();
                                  FavCleanUI.f(FavCleanUI.this).cWQ();
                                  FavCleanUI.5.1.1.this.tcT.dismiss();
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
                com.tencent.mm.plugin.report.service.h.CyF.a(11125, new Object[] { Integer.valueOf(paramAnonymous2DialogInterface.size()), Integer.valueOf(3) });
                AppMethodBeat.o(106642);
              }
            }, null);
            AppMethodBeat.o(106643);
          }
        };
        this.tdy = false;
      }
      d.cUs().a(this.tdA);
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
    d locald = d.cUs();
    d.a locala = this.tdA;
    if (locald.sZY.contains(locala)) {
      locald.sZY.remove(locala);
    }
    if (this.tdt != null)
    {
      this.tdt.destory();
      this.tdt = null;
    }
    if (this.tdu != null) {
      this.tdu.finish();
    }
    this.workerHandler.quit();
    com.tencent.mm.kernel.g.azz().b(438, this.tdB);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavCleanUI
 * JD-Core Version:    0.7.0.1
 */