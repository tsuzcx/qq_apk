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
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.al;
import com.tencent.mm.plugin.fav.a.d;
import com.tencent.mm.plugin.fav.a.d.a;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.ui.e.b.c;
import com.tencent.mm.plugin.fav.ui.widget.a;
import com.tencent.mm.plugin.fav.ui.widget.a.a;
import com.tencent.mm.protocal.protobuf.ago;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FavCleanUI
  extends MMActivity
  implements b.c
{
  protected ap gAC;
  protected ap pXi;
  private long qcB;
  protected View qcE;
  private View qcF;
  private Runnable qcM;
  protected Runnable qcN;
  private o qcV;
  private com.tencent.mm.plugin.fav.ui.a.b qcW;
  private ListView qcX;
  private TextView qcY;
  private a qcZ;
  private boolean qcy;
  protected boolean qcz;
  private boolean qda;
  private int qdb;
  private d.a qdc;
  private com.tencent.mm.al.g qdd;
  
  public FavCleanUI()
  {
    AppMethodBeat.i(106647);
    this.qcy = false;
    this.gAC = new ap(Looper.getMainLooper());
    this.qda = false;
    this.qdb = 0;
    this.qdc = new d.a()
    {
      public final void onFinish()
      {
        AppMethodBeat.i(106637);
        ad.i("MicroMsg.FavCleanUI", "FavCleanFirstLoader onRefreshed()");
        FavCleanUI.c(FavCleanUI.this);
        FavCleanUI.d(FavCleanUI.this);
        AppMethodBeat.o(106637);
      }
    };
    this.qdd = new com.tencent.mm.al.g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(106644);
        ad.i("MicroMsg.FavCleanUI", "on getfavinfo scene end");
        if (FavCleanUI.f(FavCleanUI.this) != null) {
          FavCleanUI.f(FavCleanUI.this).qly = com.tencent.mm.plugin.fav.a.b.chr();
        }
        AppMethodBeat.o(106644);
      }
    };
    this.qcM = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106645);
        if (FavCleanUI.e(FavCleanUI.this) != null) {
          FavCleanUI.e(FavCleanUI.this).aJq();
        }
        FavCleanUI.this.ciN();
        AppMethodBeat.o(106645);
      }
    };
    this.qcB = 0L;
    this.qcz = false;
    this.qcN = new Runnable()
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
          ad.d("MicroMsg.FavCleanUI", "try refresh, time limit, now %d last %d delay %d", new Object[] { Long.valueOf(SystemClock.elapsedRealtime()), Long.valueOf(FavCleanUI.h(FavCleanUI.this)), Integer.valueOf(1000) });
          FavCleanUI.this.gAC.postDelayed(this, 500L);
          AppMethodBeat.o(106646);
          return;
        }
        FavCleanUI.i(FavCleanUI.this);
        FavCleanUI.a(FavCleanUI.this, SystemClock.elapsedRealtime());
        ad.v("MicroMsg.FavCleanUI", "do refresh job");
        FavCleanUI.d(FavCleanUI.this);
        if (FavCleanUI.this.qcz)
        {
          ad.v("MicroMsg.FavCleanUI", "do scroll to first");
          FavCleanUI.j(FavCleanUI.this).setSelection(0);
          FavCleanUI.this.qcz = false;
        }
        AppMethodBeat.o(106646);
      }
    };
    AppMethodBeat.o(106647);
  }
  
  private void hx(boolean paramBoolean)
  {
    AppMethodBeat.i(106655);
    if (paramBoolean)
    {
      this.qcF.setVisibility(8);
      this.qcY.setVisibility(0);
      this.qcX.removeFooterView(this.qcE);
      if (this.qcZ != null)
      {
        this.qcZ.hide();
        AppMethodBeat.o(106655);
      }
    }
    else
    {
      this.qcF.setVisibility(8);
      this.qcY.setVisibility(8);
      this.qcX.removeFooterView(this.qcE);
      if (this.qcZ != null) {
        this.qcZ.show();
      }
    }
    AppMethodBeat.o(106655);
  }
  
  private void kC(boolean paramBoolean)
  {
    AppMethodBeat.i(106656);
    if (paramBoolean)
    {
      if (this.qcX.getFooterViewsCount() == 0)
      {
        this.qcX.addFooterView(this.qcE);
        AppMethodBeat.o(106656);
      }
    }
    else {
      this.qcX.removeFooterView(this.qcE);
    }
    AppMethodBeat.o(106656);
  }
  
  protected final void ciN()
  {
    AppMethodBeat.i(106654);
    ad.i("MicroMsg.FavCleanUI", "on storage change, try refresh job");
    this.gAC.removeCallbacks(this.qcN);
    this.gAC.post(this.qcN);
    AppMethodBeat.o(106654);
  }
  
  public int getLayoutId()
  {
    return 2131493941;
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
    this.qdb = getIntent().getIntExtra("key_enter_fav_cleanui_from", 0);
    this.pXi = new ap(getClass().getName() + "_handlerThread_" + System.currentTimeMillis());
    this.qcX = ((ListView)findViewById(2131299775));
    setMMTitle(2131758827);
    this.qda = true;
    paramBundle = new al();
    com.tencent.mm.kernel.g.aeS().a(paramBundle, 0);
    com.tencent.mm.kernel.g.aeS().a(438, this.qdd);
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
    paramBundle = (ViewStub)findViewById(2131299466);
    if (paramBundle != null) {}
    for (this.qcF = paramBundle.inflate();; this.qcF = findViewById(2131299866))
    {
      this.qcY = ((TextView)findViewById(2131299464));
      this.qcF.setVisibility(0);
      this.qcY.setVisibility(8);
      this.qcX.removeFooterView(this.qcE);
      if (this.qcZ != null) {
        this.qcZ.hide();
      }
      this.qcE = y.js(this).inflate(2131493968, null);
      this.qcX.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
        {
          AppMethodBeat.i(106636);
          if ((paramAnonymousInt == 0) && (FavCleanUI.a(FavCleanUI.this)))
          {
            ad.i("MicroMsg.FavCleanUI", "force bottom load data");
            FavCleanUI.b(FavCleanUI.this);
          }
          AppMethodBeat.o(106636);
        }
      });
      if (this.qda)
      {
        this.qcZ = new a();
        paramBundle = this.qcZ;
        View localView = findViewById(2131299774);
        paramBundle.qlA = false;
        paramBundle.qlB = localView;
        this.qcZ.qlC = new a.a()
        {
          public final void ciO()
          {
            AppMethodBeat.i(106643);
            com.tencent.mm.ui.base.h.a(FavCleanUI.this.getContext(), FavCleanUI.this.getString(2131758823), "", new DialogInterface.OnClickListener()
            {
              public final void onClick(final DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(106642);
                long l = FavCleanUI.e(FavCleanUI.this).cju();
                paramAnonymous2DialogInterface = FavCleanUI.e(FavCleanUI.this).kE(true);
                Object localObject = FavCleanUI.f(FavCleanUI.this);
                ((a)localObject).qly += l;
                com.tencent.mm.plugin.fav.a.b.pB(com.tencent.mm.plugin.fav.a.b.cht() - l);
                if (paramAnonymous2DialogInterface.isEmpty())
                {
                  AppMethodBeat.o(106642);
                  return;
                }
                com.tencent.mm.plugin.report.service.h.vKh.f(14110, new Object[] { Integer.valueOf(FavCleanUI.g(FavCleanUI.this)), Integer.valueOf(paramAnonymous2DialogInterface.size()), Integer.valueOf((int)(l * 1.0D / 1024.0D)) });
                localObject = com.tencent.mm.ui.base.h.b(FavCleanUI.this.getContext(), FavCleanUI.this.getString(2131758855), false, null);
                com.tencent.mm.kernel.g.afE().ax(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(106641);
                    com.tencent.mm.plugin.fav.a.b.di(paramAnonymous2DialogInterface);
                    aq.f(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(106639);
                        com.tencent.mm.plugin.fav.ui.a.b localb = FavCleanUI.e(FavCleanUI.this);
                        List localList = FavCleanUI.5.1.1.this.qdg;
                        ArrayList localArrayList;
                        Iterator localIterator1;
                        if (localb.qgO != null)
                        {
                          localArrayList = new ArrayList();
                          localIterator1 = localb.qgO.iterator();
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
                              localb.qgO = localArrayList;
                              localArrayList = new ArrayList();
                              localIterator1 = localb.qgR.iterator();
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
                                  localb.qgR = localArrayList;
                                  FavCleanUI.e(FavCleanUI.this).notifyDataSetChanged();
                                  FavCleanUI.f(FavCleanUI.this).cjT();
                                  FavCleanUI.5.1.1.this.qcu.dismiss();
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
                com.tencent.mm.plugin.report.service.h.vKh.f(11125, new Object[] { Integer.valueOf(paramAnonymous2DialogInterface.size()), Integer.valueOf(3) });
                AppMethodBeat.o(106642);
              }
            }, null);
            AppMethodBeat.o(106643);
          }
        };
        this.qda = false;
      }
      d.chC().a(this.qdc);
      AppMethodBeat.o(106648);
      return;
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(106650);
    ad.d("MicroMsg.FavCleanUI", "on create options menu");
    boolean bool = super.onCreateOptionsMenu(paramMenu);
    AppMethodBeat.o(106650);
    return bool;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(106649);
    super.onDestroy();
    d locald = d.chC();
    d.a locala = this.qdc;
    if (locald.pZz.contains(locala)) {
      locald.pZz.remove(locala);
    }
    if (this.qcV != null)
    {
      this.qcV.destory();
      this.qcV = null;
    }
    if (this.qcW != null) {
      this.qcW.finish();
    }
    this.pXi.quit();
    com.tencent.mm.kernel.g.aeS().b(438, this.qdd);
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
  
  public final void pW(long paramLong)
  {
    AppMethodBeat.i(106658);
    Object localObject = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().pS(paramLong);
    if ((localObject != null) && (((com.tencent.mm.plugin.fav.a.g)localObject).field_favProto != null) && (((com.tencent.mm.plugin.fav.a.g)localObject).field_favProto.mVb.size() != 0))
    {
      localObject = ((com.tencent.mm.plugin.fav.a.g)localObject).field_favProto.mVb.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((Iterator)localObject).next();
      }
    }
    if (this.qcW.qha)
    {
      localObject = this.qcZ;
      if (this.qcW.cjt() > 0) {}
      for (boolean bool = true;; bool = false)
      {
        if (((a)localObject).qlA) {
          ((a)localObject).ipd.setEnabled(bool);
        }
        localObject = this.qcZ;
        List localList = this.qcW.kE(false);
        paramLong = this.qcW.cju();
        if ((localList.size() == 0) || (paramLong <= 0L)) {
          break;
        }
        ((a)localObject).nOI.setText(((a)localObject).nOI.getContext().getString(2131758822, new Object[] { com.tencent.mm.plugin.fav.a.b.pJ(paramLong) }));
        ((a)localObject).ipd.setEnabled(true);
        AppMethodBeat.o(106658);
        return;
      }
      ((a)localObject).cjT();
    }
    AppMethodBeat.o(106658);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavCleanUI
 * JD-Core Version:    0.7.0.1
 */