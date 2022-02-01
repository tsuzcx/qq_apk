package com.tencent.mm.plugin.fav.ui;

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
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.plugin.fav.a.ah;
import com.tencent.mm.plugin.fav.a.an;
import com.tencent.mm.plugin.fav.a.d;
import com.tencent.mm.plugin.fav.a.d.a;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.d.b.c;
import com.tencent.mm.plugin.fav.ui.widget.a.a;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.base.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FavCleanUI
  extends MMActivity
  implements b.c
{
  private boolean AfD;
  protected boolean AfE;
  private long AfG;
  protected View AfI;
  private View AfJ;
  private Runnable AfQ;
  protected Runnable AfR;
  private FavoriteImageServer Aga;
  private com.tencent.mm.plugin.fav.ui.adapter.b Agb;
  private ListView Agc;
  private TextView Agd;
  private com.tencent.mm.plugin.fav.ui.widget.a Age;
  private boolean Agf;
  private int Agg;
  private d.a Agh;
  private com.tencent.mm.am.h Agi;
  protected MMHandler mRi;
  protected MMHandler workerHandler;
  
  public FavCleanUI()
  {
    AppMethodBeat.i(106647);
    this.AfD = false;
    this.mRi = new MMHandler(Looper.getMainLooper());
    this.Agf = false;
    this.Agg = 0;
    this.Agh = new d.a()
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
    this.Agi = new com.tencent.mm.am.h()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
      {
        AppMethodBeat.i(106644);
        Log.i("MicroMsg.FavCleanUI", "on getfavinfo scene end");
        if (FavCleanUI.f(FavCleanUI.this) != null) {
          FavCleanUI.f(FavCleanUI.this).Apm = com.tencent.mm.plugin.fav.a.b.dPY();
        }
        AppMethodBeat.o(106644);
      }
    };
    this.AfQ = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106645);
        if (FavCleanUI.e(FavCleanUI.this) != null) {
          FavCleanUI.e(FavCleanUI.this).bXB();
        }
        FavCleanUI.this.dRA();
        AppMethodBeat.o(106645);
      }
    };
    this.AfG = 0L;
    this.AfE = false;
    this.AfR = new Runnable()
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
          FavCleanUI.this.mRi.postDelayed(this, 500L);
          AppMethodBeat.o(106646);
          return;
        }
        FavCleanUI.i(FavCleanUI.this);
        FavCleanUI.a(FavCleanUI.this, SystemClock.elapsedRealtime());
        Log.v("MicroMsg.FavCleanUI", "do refresh job");
        FavCleanUI.d(FavCleanUI.this);
        if (FavCleanUI.this.AfE)
        {
          Log.v("MicroMsg.FavCleanUI", "do scroll to first");
          FavCleanUI.j(FavCleanUI.this).setSelection(0);
          FavCleanUI.this.AfE = false;
        }
        AppMethodBeat.o(106646);
      }
    };
    AppMethodBeat.o(106647);
  }
  
  private void po(boolean paramBoolean)
  {
    AppMethodBeat.i(106655);
    if (paramBoolean)
    {
      this.AfJ.setVisibility(8);
      this.Agd.setVisibility(0);
      this.Agc.removeFooterView(this.AfI);
      if (this.Age != null)
      {
        this.Age.hide();
        AppMethodBeat.o(106655);
      }
    }
    else
    {
      this.AfJ.setVisibility(8);
      this.Agd.setVisibility(8);
      this.Agc.removeFooterView(this.AfI);
      if (this.Age != null) {
        this.Age.show();
      }
    }
    AppMethodBeat.o(106655);
  }
  
  private void pp(boolean paramBoolean)
  {
    AppMethodBeat.i(106656);
    if (paramBoolean)
    {
      if (this.Agc.getFooterViewsCount() == 0)
      {
        this.Agc.addFooterView(this.AfI);
        AppMethodBeat.o(106656);
      }
    }
    else {
      this.Agc.removeFooterView(this.AfI);
    }
    AppMethodBeat.o(106656);
  }
  
  protected final void dRA()
  {
    AppMethodBeat.i(106654);
    Log.i("MicroMsg.FavCleanUI", "on storage change, try refresh job");
    this.mRi.removeCallbacks(this.AfR);
    this.mRi.post(this.AfR);
    AppMethodBeat.o(106654);
  }
  
  public int getLayoutId()
  {
    return q.f.fav_clean_ui;
  }
  
  public final void mO(long paramLong)
  {
    AppMethodBeat.i(106658);
    Object localObject = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().mK(paramLong);
    if ((localObject != null) && (((g)localObject).field_favProto != null) && (((g)localObject).field_favProto.vEn.size() != 0))
    {
      localObject = ((g)localObject).field_favProto.vEn.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((Iterator)localObject).next();
      }
    }
    if (this.Agb.Akm)
    {
      localObject = this.Age;
      if (this.Agb.dSm() > 0) {}
      for (boolean bool = true;; bool = false)
      {
        if (((com.tencent.mm.plugin.fav.ui.widget.a)localObject).Apo) {
          ((com.tencent.mm.plugin.fav.ui.widget.a)localObject).pYm.setEnabled(bool);
        }
        localObject = this.Age;
        List localList = this.Agb.ps(false);
        paramLong = this.Agb.dSn();
        if ((localList == null) || (localList.size() == 0) || (paramLong <= 0L)) {
          break;
        }
        ((com.tencent.mm.plugin.fav.ui.widget.a)localObject).wSG.setText(((com.tencent.mm.plugin.fav.ui.widget.a)localObject).wSG.getContext().getString(q.i.fav_clean_delete_info, new Object[] { com.tencent.mm.plugin.fav.a.b.mB(paramLong) }));
        ((com.tencent.mm.plugin.fav.ui.widget.a)localObject).pYm.setEnabled(true);
        AppMethodBeat.o(106658);
        return;
      }
      ((com.tencent.mm.plugin.fav.ui.widget.a)localObject).dSO();
    }
    AppMethodBeat.o(106658);
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
    this.Agg = getIntent().getIntExtra("key_enter_fav_cleanui_from", 0);
    this.workerHandler = new MMHandler(getClass().getName() + "_handlerThread_" + System.currentTimeMillis());
    this.Agc = ((ListView)findViewById(q.e.fav_clean_list));
    setMMTitle(q.i.fav_clean_title);
    this.Agf = true;
    paramBundle = new an();
    com.tencent.mm.kernel.h.aZW().a(paramBundle, 0);
    com.tencent.mm.kernel.h.aZW().a(438, this.Agi);
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
    paramBundle = (ViewStub)findViewById(q.e.empty_load_view_stub);
    if (paramBundle != null) {}
    for (this.AfJ = paramBundle.inflate();; this.AfJ = findViewById(q.e.favorite_loading))
    {
      this.Agd = ((TextView)findViewById(q.e.empty_fav_view));
      this.AfJ.setVisibility(0);
      this.Agd.setVisibility(8);
      this.Agc.removeFooterView(this.AfI);
      if (this.Age != null) {
        this.Age.hide();
      }
      this.AfI = af.mU(this).inflate(q.f.fav_loading_footer, null);
      this.Agc.setOnScrollListener(new AbsListView.OnScrollListener()
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
      if (this.Agf)
      {
        this.Age = new com.tencent.mm.plugin.fav.ui.widget.a();
        paramBundle = this.Age;
        View localView = findViewById(q.e.fav_clean_footer);
        paramBundle.Apo = false;
        paramBundle.App = localView;
        this.Age.Apq = new a.a()
        {
          public final void dRB()
          {
            AppMethodBeat.i(106643);
            k.a(FavCleanUI.this.getContext(), FavCleanUI.this.getString(q.i.fav_clean_delete_tips), "", new DialogInterface.OnClickListener()
            {
              public final void onClick(final DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(106642);
                long l = FavCleanUI.e(FavCleanUI.this).dSn();
                paramAnonymous2DialogInterface = FavCleanUI.e(FavCleanUI.this).ps(true);
                Object localObject = FavCleanUI.f(FavCleanUI.this);
                ((com.tencent.mm.plugin.fav.ui.widget.a)localObject).Apm += l;
                com.tencent.mm.plugin.fav.a.b.mt(com.tencent.mm.plugin.fav.a.b.dQa() - l);
                if ((paramAnonymous2DialogInterface == null) || (paramAnonymous2DialogInterface.isEmpty()))
                {
                  AppMethodBeat.o(106642);
                  return;
                }
                com.tencent.mm.plugin.report.service.h.OAn.b(14110, new Object[] { Integer.valueOf(FavCleanUI.g(FavCleanUI.this)), Integer.valueOf(paramAnonymous2DialogInterface.size()), Integer.valueOf((int)(l * 1.0D / 1024.0D)) });
                localObject = k.a(FavCleanUI.this.getContext(), FavCleanUI.this.getString(q.i.favorite_delete_tips), false, null);
                com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(106641);
                    com.tencent.mm.plugin.fav.a.b.fE(paramAnonymous2DialogInterface);
                    MMHandlerThread.postToMainThread(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(106639);
                        com.tencent.mm.plugin.fav.ui.adapter.b localb = FavCleanUI.e(FavCleanUI.this);
                        List localList = FavCleanUI.5.1.1.this.Agl;
                        ArrayList localArrayList;
                        Iterator localIterator1;
                        if (localb.Aka != null)
                        {
                          localArrayList = new ArrayList();
                          localIterator1 = localb.Aka.iterator();
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
                              localb.Aka = localArrayList;
                              localArrayList = new ArrayList();
                              localIterator1 = localb.Akd.iterator();
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
                                  localb.Akd = localArrayList;
                                  FavCleanUI.e(FavCleanUI.this).notifyDataSetChanged();
                                  FavCleanUI.f(FavCleanUI.this).dSO();
                                  FavCleanUI.5.1.1.this.Afz.dismiss();
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
                com.tencent.mm.plugin.report.service.h.OAn.b(11125, new Object[] { Integer.valueOf(paramAnonymous2DialogInterface.size()), Integer.valueOf(3) });
                AppMethodBeat.o(106642);
              }
            }, null);
            AppMethodBeat.o(106643);
          }
        };
        this.Agf = false;
      }
      d.dQj().a(this.Agh);
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
    d locald = d.dQj();
    d.a locala = this.Agh;
    if (locald.Acl.contains(locala)) {
      locald.Acl.remove(locala);
    }
    if (this.Aga != null)
    {
      this.Aga.destory();
      this.Aga = null;
    }
    this.workerHandler.quit();
    com.tencent.mm.kernel.h.aZW().b(438, this.Agi);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavCleanUI
 * JD-Core Version:    0.7.0.1
 */