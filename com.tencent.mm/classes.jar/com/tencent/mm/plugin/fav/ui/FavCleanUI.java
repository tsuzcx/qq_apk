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
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.al;
import com.tencent.mm.plugin.fav.a.d;
import com.tencent.mm.plugin.fav.a.d.a;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.ui.e.b.c;
import com.tencent.mm.plugin.fav.ui.widget.a.a;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FavCleanUI
  extends MMActivity
  implements b.c
{
  protected aq gKO;
  private Runnable rDF;
  protected Runnable rDG;
  private o rDO;
  private com.tencent.mm.plugin.fav.ui.a.b rDP;
  private ListView rDQ;
  private TextView rDR;
  private com.tencent.mm.plugin.fav.ui.widget.a rDS;
  private boolean rDT;
  private int rDU;
  private d.a rDV;
  private f rDW;
  private boolean rDs;
  protected boolean rDt;
  private long rDv;
  protected View rDx;
  private View rDy;
  protected aq rxJ;
  
  public FavCleanUI()
  {
    AppMethodBeat.i(106647);
    this.rDs = false;
    this.gKO = new aq(Looper.getMainLooper());
    this.rDT = false;
    this.rDU = 0;
    this.rDV = new d.a()
    {
      public final void onFinish()
      {
        AppMethodBeat.i(106637);
        ae.i("MicroMsg.FavCleanUI", "FavCleanFirstLoader onRefreshed()");
        FavCleanUI.c(FavCleanUI.this);
        FavCleanUI.d(FavCleanUI.this);
        AppMethodBeat.o(106637);
      }
    };
    this.rDW = new f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(106644);
        ae.i("MicroMsg.FavCleanUI", "on getfavinfo scene end");
        if (FavCleanUI.f(FavCleanUI.this) != null) {
          FavCleanUI.f(FavCleanUI.this).rMz = com.tencent.mm.plugin.fav.a.b.cwe();
        }
        AppMethodBeat.o(106644);
      }
    };
    this.rDF = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106645);
        if (FavCleanUI.e(FavCleanUI.this) != null) {
          FavCleanUI.e(FavCleanUI.this).aTS();
        }
        FavCleanUI.this.cxA();
        AppMethodBeat.o(106645);
      }
    };
    this.rDv = 0L;
    this.rDt = false;
    this.rDG = new Runnable()
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
          ae.d("MicroMsg.FavCleanUI", "try refresh, time limit, now %d last %d delay %d", new Object[] { Long.valueOf(SystemClock.elapsedRealtime()), Long.valueOf(FavCleanUI.h(FavCleanUI.this)), Integer.valueOf(1000) });
          FavCleanUI.this.gKO.postDelayed(this, 500L);
          AppMethodBeat.o(106646);
          return;
        }
        FavCleanUI.i(FavCleanUI.this);
        FavCleanUI.a(FavCleanUI.this, SystemClock.elapsedRealtime());
        ae.v("MicroMsg.FavCleanUI", "do refresh job");
        FavCleanUI.d(FavCleanUI.this);
        if (FavCleanUI.this.rDt)
        {
          ae.v("MicroMsg.FavCleanUI", "do scroll to first");
          FavCleanUI.j(FavCleanUI.this).setSelection(0);
          FavCleanUI.this.rDt = false;
        }
        AppMethodBeat.o(106646);
      }
    };
    AppMethodBeat.o(106647);
  }
  
  private void id(boolean paramBoolean)
  {
    AppMethodBeat.i(106655);
    if (paramBoolean)
    {
      this.rDy.setVisibility(8);
      this.rDR.setVisibility(0);
      this.rDQ.removeFooterView(this.rDx);
      if (this.rDS != null)
      {
        this.rDS.hide();
        AppMethodBeat.o(106655);
      }
    }
    else
    {
      this.rDy.setVisibility(8);
      this.rDR.setVisibility(8);
      this.rDQ.removeFooterView(this.rDx);
      if (this.rDS != null) {
        this.rDS.show();
      }
    }
    AppMethodBeat.o(106655);
  }
  
  private void lz(boolean paramBoolean)
  {
    AppMethodBeat.i(106656);
    if (paramBoolean)
    {
      if (this.rDQ.getFooterViewsCount() == 0)
      {
        this.rDQ.addFooterView(this.rDx);
        AppMethodBeat.o(106656);
      }
    }
    else {
      this.rDQ.removeFooterView(this.rDx);
    }
    AppMethodBeat.o(106656);
  }
  
  protected final void cxA()
  {
    AppMethodBeat.i(106654);
    ae.i("MicroMsg.FavCleanUI", "on storage change, try refresh job");
    this.gKO.removeCallbacks(this.rDG);
    this.gKO.post(this.rDG);
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
    this.rDU = getIntent().getIntExtra("key_enter_fav_cleanui_from", 0);
    this.rxJ = new aq(getClass().getName() + "_handlerThread_" + System.currentTimeMillis());
    this.rDQ = ((ListView)findViewById(2131299775));
    setMMTitle(2131758827);
    this.rDT = true;
    paramBundle = new al();
    com.tencent.mm.kernel.g.ajj().a(paramBundle, 0);
    com.tencent.mm.kernel.g.ajj().a(438, this.rDW);
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
    for (this.rDy = paramBundle.inflate();; this.rDy = findViewById(2131299866))
    {
      this.rDR = ((TextView)findViewById(2131299464));
      this.rDy.setVisibility(0);
      this.rDR.setVisibility(8);
      this.rDQ.removeFooterView(this.rDx);
      if (this.rDS != null) {
        this.rDS.hide();
      }
      this.rDx = z.jV(this).inflate(2131493968, null);
      this.rDQ.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
        {
          AppMethodBeat.i(106636);
          if ((paramAnonymousInt == 0) && (FavCleanUI.a(FavCleanUI.this)))
          {
            ae.i("MicroMsg.FavCleanUI", "force bottom load data");
            FavCleanUI.b(FavCleanUI.this);
          }
          AppMethodBeat.o(106636);
        }
      });
      if (this.rDT)
      {
        this.rDS = new com.tencent.mm.plugin.fav.ui.widget.a();
        paramBundle = this.rDS;
        View localView = findViewById(2131299774);
        paramBundle.rMB = false;
        paramBundle.rMC = localView;
        this.rDS.rMD = new a.a()
        {
          public final void cxB()
          {
            AppMethodBeat.i(106643);
            h.a(FavCleanUI.this.getContext(), FavCleanUI.this.getString(2131758823), "", new DialogInterface.OnClickListener()
            {
              public final void onClick(final DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(106642);
                long l = FavCleanUI.e(FavCleanUI.this).cym();
                paramAnonymous2DialogInterface = FavCleanUI.e(FavCleanUI.this).lB(true);
                Object localObject = FavCleanUI.f(FavCleanUI.this);
                ((com.tencent.mm.plugin.fav.ui.widget.a)localObject).rMz += l;
                com.tencent.mm.plugin.fav.a.b.vD(com.tencent.mm.plugin.fav.a.b.cwg() - l);
                if (paramAnonymous2DialogInterface.isEmpty())
                {
                  AppMethodBeat.o(106642);
                  return;
                }
                com.tencent.mm.plugin.report.service.g.yxI.f(14110, new Object[] { Integer.valueOf(FavCleanUI.g(FavCleanUI.this)), Integer.valueOf(paramAnonymous2DialogInterface.size()), Integer.valueOf((int)(l * 1.0D / 1024.0D)) });
                localObject = h.b(FavCleanUI.this.getContext(), FavCleanUI.this.getString(2131758855), false, null);
                com.tencent.mm.kernel.g.ajU().aw(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(106641);
                    com.tencent.mm.plugin.fav.a.b.dp(paramAnonymous2DialogInterface);
                    ar.f(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(106639);
                        com.tencent.mm.plugin.fav.ui.a.b localb = FavCleanUI.e(FavCleanUI.this);
                        List localList = FavCleanUI.5.1.1.this.rDZ;
                        ArrayList localArrayList;
                        Iterator localIterator1;
                        if (localb.rHA != null)
                        {
                          localArrayList = new ArrayList();
                          localIterator1 = localb.rHA.iterator();
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
                              localb.rHA = localArrayList;
                              localArrayList = new ArrayList();
                              localIterator1 = localb.rHD.iterator();
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
                                  localb.rHD = localArrayList;
                                  FavCleanUI.e(FavCleanUI.this).notifyDataSetChanged();
                                  FavCleanUI.f(FavCleanUI.this).cyN();
                                  FavCleanUI.5.1.1.this.rDo.dismiss();
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
                com.tencent.mm.plugin.report.service.g.yxI.f(11125, new Object[] { Integer.valueOf(paramAnonymous2DialogInterface.size()), Integer.valueOf(3) });
                AppMethodBeat.o(106642);
              }
            }, null);
            AppMethodBeat.o(106643);
          }
        };
        this.rDT = false;
      }
      d.cwp().a(this.rDV);
      AppMethodBeat.o(106648);
      return;
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(106650);
    ae.d("MicroMsg.FavCleanUI", "on create options menu");
    boolean bool = super.onCreateOptionsMenu(paramMenu);
    AppMethodBeat.o(106650);
    return bool;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(106649);
    super.onDestroy();
    d locald = d.cwp();
    d.a locala = this.rDV;
    if (locald.rAu.contains(locala)) {
      locald.rAu.remove(locala);
    }
    if (this.rDO != null)
    {
      this.rDO.destory();
      this.rDO = null;
    }
    if (this.rDP != null) {
      this.rDP.finish();
    }
    this.rxJ.quit();
    com.tencent.mm.kernel.g.ajj().b(438, this.rDW);
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
  
  public final void vY(long paramLong)
  {
    AppMethodBeat.i(106658);
    Object localObject = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vU(paramLong);
    if ((localObject != null) && (((com.tencent.mm.plugin.fav.a.g)localObject).field_favProto != null) && (((com.tencent.mm.plugin.fav.a.g)localObject).field_favProto.oeJ.size() != 0))
    {
      localObject = ((com.tencent.mm.plugin.fav.a.g)localObject).field_favProto.oeJ.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((Iterator)localObject).next();
      }
    }
    if (this.rDP.rHM)
    {
      localObject = this.rDS;
      if (this.rDP.cyl() > 0) {}
      for (boolean bool = true;; bool = false)
      {
        if (((com.tencent.mm.plugin.fav.ui.widget.a)localObject).rMB) {
          ((com.tencent.mm.plugin.fav.ui.widget.a)localObject).jll.setEnabled(bool);
        }
        localObject = this.rDS;
        List localList = this.rDP.lB(false);
        paramLong = this.rDP.cym();
        if ((localList.size() == 0) || (paramLong <= 0L)) {
          break;
        }
        ((com.tencent.mm.plugin.fav.ui.widget.a)localObject).pbJ.setText(((com.tencent.mm.plugin.fav.ui.widget.a)localObject).pbJ.getContext().getString(2131758822, new Object[] { com.tencent.mm.plugin.fav.a.b.vL(paramLong) }));
        ((com.tencent.mm.plugin.fav.ui.widget.a)localObject).jll.setEnabled(true);
        AppMethodBeat.o(106658);
        return;
      }
      ((com.tencent.mm.plugin.fav.ui.widget.a)localObject).cyN();
    }
    AppMethodBeat.o(106658);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavCleanUI
 * JD-Core Version:    0.7.0.1
 */