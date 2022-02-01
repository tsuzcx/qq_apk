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
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.al;
import com.tencent.mm.plugin.fav.a.d;
import com.tencent.mm.plugin.fav.a.d.a;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.ui.e.b.c;
import com.tencent.mm.plugin.fav.ui.widget.a;
import com.tencent.mm.plugin.fav.ui.widget.a.a;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FavCleanUI
  extends MMActivity
  implements b.c
{
  protected ao gox;
  protected ao qFN;
  private o qLA;
  private com.tencent.mm.plugin.fav.ui.a.b qLB;
  private ListView qLC;
  private TextView qLD;
  private a qLE;
  private boolean qLF;
  private int qLG;
  private d.a qLH;
  private com.tencent.mm.ak.g qLI;
  private boolean qLe;
  protected boolean qLf;
  private long qLh;
  protected View qLj;
  private View qLk;
  private Runnable qLr;
  protected Runnable qLs;
  
  public FavCleanUI()
  {
    AppMethodBeat.i(106647);
    this.qLe = false;
    this.gox = new ao(Looper.getMainLooper());
    this.qLF = false;
    this.qLG = 0;
    this.qLH = new d.a()
    {
      public final void onFinish()
      {
        AppMethodBeat.i(106637);
        ac.i("MicroMsg.FavCleanUI", "FavCleanFirstLoader onRefreshed()");
        FavCleanUI.c(FavCleanUI.this);
        FavCleanUI.d(FavCleanUI.this);
        AppMethodBeat.o(106637);
      }
    };
    this.qLI = new com.tencent.mm.ak.g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(106644);
        ac.i("MicroMsg.FavCleanUI", "on getfavinfo scene end");
        if (FavCleanUI.f(FavCleanUI.this) != null) {
          FavCleanUI.f(FavCleanUI.this).qUa = com.tencent.mm.plugin.fav.a.b.coY();
        }
        AppMethodBeat.o(106644);
      }
    };
    this.qLr = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106645);
        if (FavCleanUI.e(FavCleanUI.this) != null) {
          FavCleanUI.e(FavCleanUI.this).aQh();
        }
        FavCleanUI.this.cqu();
        AppMethodBeat.o(106645);
      }
    };
    this.qLh = 0L;
    this.qLf = false;
    this.qLs = new Runnable()
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
          ac.d("MicroMsg.FavCleanUI", "try refresh, time limit, now %d last %d delay %d", new Object[] { Long.valueOf(SystemClock.elapsedRealtime()), Long.valueOf(FavCleanUI.h(FavCleanUI.this)), Integer.valueOf(1000) });
          FavCleanUI.this.gox.postDelayed(this, 500L);
          AppMethodBeat.o(106646);
          return;
        }
        FavCleanUI.i(FavCleanUI.this);
        FavCleanUI.a(FavCleanUI.this, SystemClock.elapsedRealtime());
        ac.v("MicroMsg.FavCleanUI", "do refresh job");
        FavCleanUI.d(FavCleanUI.this);
        if (FavCleanUI.this.qLf)
        {
          ac.v("MicroMsg.FavCleanUI", "do scroll to first");
          FavCleanUI.j(FavCleanUI.this).setSelection(0);
          FavCleanUI.this.qLf = false;
        }
        AppMethodBeat.o(106646);
      }
    };
    AppMethodBeat.o(106647);
  }
  
  private void hV(boolean paramBoolean)
  {
    AppMethodBeat.i(106655);
    if (paramBoolean)
    {
      this.qLk.setVisibility(8);
      this.qLD.setVisibility(0);
      this.qLC.removeFooterView(this.qLj);
      if (this.qLE != null)
      {
        this.qLE.hide();
        AppMethodBeat.o(106655);
      }
    }
    else
    {
      this.qLk.setVisibility(8);
      this.qLD.setVisibility(8);
      this.qLC.removeFooterView(this.qLj);
      if (this.qLE != null) {
        this.qLE.show();
      }
    }
    AppMethodBeat.o(106655);
  }
  
  private void lg(boolean paramBoolean)
  {
    AppMethodBeat.i(106656);
    if (paramBoolean)
    {
      if (this.qLC.getFooterViewsCount() == 0)
      {
        this.qLC.addFooterView(this.qLj);
        AppMethodBeat.o(106656);
      }
    }
    else {
      this.qLC.removeFooterView(this.qLj);
    }
    AppMethodBeat.o(106656);
  }
  
  protected final void cqu()
  {
    AppMethodBeat.i(106654);
    ac.i("MicroMsg.FavCleanUI", "on storage change, try refresh job");
    this.gox.removeCallbacks(this.qLs);
    this.gox.post(this.qLs);
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
    this.qLG = getIntent().getIntExtra("key_enter_fav_cleanui_from", 0);
    this.qFN = new ao(getClass().getName() + "_handlerThread_" + System.currentTimeMillis());
    this.qLC = ((ListView)findViewById(2131299775));
    setMMTitle(2131758827);
    this.qLF = true;
    paramBundle = new al();
    com.tencent.mm.kernel.g.agi().a(paramBundle, 0);
    com.tencent.mm.kernel.g.agi().a(438, this.qLI);
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
    for (this.qLk = paramBundle.inflate();; this.qLk = findViewById(2131299866))
    {
      this.qLD = ((TextView)findViewById(2131299464));
      this.qLk.setVisibility(0);
      this.qLD.setVisibility(8);
      this.qLC.removeFooterView(this.qLj);
      if (this.qLE != null) {
        this.qLE.hide();
      }
      this.qLj = z.jD(this).inflate(2131493968, null);
      this.qLC.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
        {
          AppMethodBeat.i(106636);
          if ((paramAnonymousInt == 0) && (FavCleanUI.a(FavCleanUI.this)))
          {
            ac.i("MicroMsg.FavCleanUI", "force bottom load data");
            FavCleanUI.b(FavCleanUI.this);
          }
          AppMethodBeat.o(106636);
        }
      });
      if (this.qLF)
      {
        this.qLE = new a();
        paramBundle = this.qLE;
        View localView = findViewById(2131299774);
        paramBundle.qUc = false;
        paramBundle.qUd = localView;
        this.qLE.qUe = new a.a()
        {
          public final void cqv()
          {
            AppMethodBeat.i(106643);
            com.tencent.mm.ui.base.h.a(FavCleanUI.this.getContext(), FavCleanUI.this.getString(2131758823), "", new DialogInterface.OnClickListener()
            {
              public final void onClick(final DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(106642);
                long l = FavCleanUI.e(FavCleanUI.this).crb();
                paramAnonymous2DialogInterface = FavCleanUI.e(FavCleanUI.this).li(true);
                Object localObject = FavCleanUI.f(FavCleanUI.this);
                ((a)localObject).qUa += l;
                com.tencent.mm.plugin.fav.a.b.tq(com.tencent.mm.plugin.fav.a.b.cpa() - l);
                if (paramAnonymous2DialogInterface.isEmpty())
                {
                  AppMethodBeat.o(106642);
                  return;
                }
                com.tencent.mm.plugin.report.service.h.wUl.f(14110, new Object[] { Integer.valueOf(FavCleanUI.g(FavCleanUI.this)), Integer.valueOf(paramAnonymous2DialogInterface.size()), Integer.valueOf((int)(l * 1.0D / 1024.0D)) });
                localObject = com.tencent.mm.ui.base.h.b(FavCleanUI.this.getContext(), FavCleanUI.this.getString(2131758855), false, null);
                com.tencent.mm.kernel.g.agU().az(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(106641);
                    com.tencent.mm.plugin.fav.a.b.dk(paramAnonymous2DialogInterface);
                    ap.f(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(106639);
                        com.tencent.mm.plugin.fav.ui.a.b localb = FavCleanUI.e(FavCleanUI.this);
                        List localList = FavCleanUI.5.1.1.this.qLL;
                        ArrayList localArrayList;
                        Iterator localIterator1;
                        if (localb.qPq != null)
                        {
                          localArrayList = new ArrayList();
                          localIterator1 = localb.qPq.iterator();
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
                              localb.qPq = localArrayList;
                              localArrayList = new ArrayList();
                              localIterator1 = localb.qPt.iterator();
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
                                  localb.qPt = localArrayList;
                                  FavCleanUI.e(FavCleanUI.this).notifyDataSetChanged();
                                  FavCleanUI.f(FavCleanUI.this).crA();
                                  FavCleanUI.5.1.1.this.qLa.dismiss();
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
                com.tencent.mm.plugin.report.service.h.wUl.f(11125, new Object[] { Integer.valueOf(paramAnonymous2DialogInterface.size()), Integer.valueOf(3) });
                AppMethodBeat.o(106642);
              }
            }, null);
            AppMethodBeat.o(106643);
          }
        };
        this.qLF = false;
      }
      d.cpj().a(this.qLH);
      AppMethodBeat.o(106648);
      return;
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(106650);
    ac.d("MicroMsg.FavCleanUI", "on create options menu");
    boolean bool = super.onCreateOptionsMenu(paramMenu);
    AppMethodBeat.o(106650);
    return bool;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(106649);
    super.onDestroy();
    d locald = d.cpj();
    d.a locala = this.qLH;
    if (locald.qIg.contains(locala)) {
      locald.qIg.remove(locala);
    }
    if (this.qLA != null)
    {
      this.qLA.destory();
      this.qLA = null;
    }
    if (this.qLB != null) {
      this.qLB.finish();
    }
    this.qFN.quit();
    com.tencent.mm.kernel.g.agi().b(438, this.qLI);
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
  
  public final void tL(long paramLong)
  {
    AppMethodBeat.i(106658);
    Object localObject = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().tH(paramLong);
    if ((localObject != null) && (((com.tencent.mm.plugin.fav.a.g)localObject).field_favProto != null) && (((com.tencent.mm.plugin.fav.a.g)localObject).field_favProto.nxC.size() != 0))
    {
      localObject = ((com.tencent.mm.plugin.fav.a.g)localObject).field_favProto.nxC.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((Iterator)localObject).next();
      }
    }
    if (this.qLB.qPC)
    {
      localObject = this.qLE;
      if (this.qLB.cra() > 0) {}
      for (boolean bool = true;; bool = false)
      {
        if (((a)localObject).qUc) {
          ((a)localObject).iPj.setEnabled(bool);
        }
        localObject = this.qLE;
        List localList = this.qLB.li(false);
        paramLong = this.qLB.crb();
        if ((localList.size() == 0) || (paramLong <= 0L)) {
          break;
        }
        ((a)localObject).orK.setText(((a)localObject).orK.getContext().getString(2131758822, new Object[] { com.tencent.mm.plugin.fav.a.b.ty(paramLong) }));
        ((a)localObject).iPj.setEnabled(true);
        AppMethodBeat.o(106658);
        return;
      }
      ((a)localObject).crA();
    }
    AppMethodBeat.o(106658);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavCleanUI
 * JD-Core Version:    0.7.0.1
 */