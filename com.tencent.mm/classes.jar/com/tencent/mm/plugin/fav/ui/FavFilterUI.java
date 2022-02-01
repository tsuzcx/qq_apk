package com.tencent.mm.plugin.fav.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.i;
import com.tencent.mm.plugin.fav.a.w;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.d.b.b;
import com.tencent.mm.plugin.fav.ui.d.b.c;
import com.tencent.mm.plugin.fav.ui.gallery.c;
import com.tencent.mm.plugin.fav.ui.gallery.c.a;
import com.tencent.mm.plugin.fav.ui.widget.FavSearchActionView;
import com.tencent.mm.plugin.fav.ui.widget.b.a;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.protocal.protobuf.and;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.widget.a.f.c;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class FavFilterUI
  extends MMActivity
  implements b.c, c.a
{
  private String dAi;
  private long iOB;
  private int jvZ;
  private ListView pop;
  private String query;
  private int tdR;
  private String tdS;
  private Set<Integer> tdT;
  private w tdU;
  private View tdV;
  private Animation tdW;
  private Animation tdX;
  private List<Integer> tdY;
  private List<String> tdZ;
  private o tdt;
  private com.tencent.mm.plugin.fav.ui.a.b tdu;
  private List<String> tea;
  private Set<String> teb;
  private List<Long> tec;
  com.tencent.mm.plugin.fav.ui.f.a ted;
  private c tee;
  private int[] tef;
  private com.tencent.mm.plugin.fav.a.g teg;
  private com.tencent.mm.plugin.fav.a.g teh;
  private com.tencent.mm.plugin.fav.ui.widget.b tei;
  private AdapterView.OnItemLongClickListener tej;
  
  public FavFilterUI()
  {
    AppMethodBeat.i(106713);
    this.tdR = -1;
    this.tdY = new LinkedList();
    this.tdZ = new LinkedList();
    this.tea = new LinkedList();
    this.teb = new HashSet();
    this.tec = new ArrayList();
    this.query = "";
    this.tef = new int[2];
    this.tej = new FavFilterUI.1(this);
    AppMethodBeat.o(106713);
  }
  
  private void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    AppMethodBeat.i(235303);
    int i;
    switch (this.jvZ)
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      String str1 = this.query;
      String str2 = this.ted.hes;
      int j = this.ted.tlY;
      if (!paramBoolean) {
        j = (int)(this.ted.tmf - this.ted.tme);
      }
      this.ted.actionType = paramInt1;
      this.ted.scene = i;
      this.ted.pHw = paramInt4;
      this.ted.ehn = paramInt3;
      this.ted.tlX = ((int)(System.currentTimeMillis() - this.iOB) / 1000);
      this.ted.query = str1;
      this.ted.hes = str2;
      this.ted.tlY = j;
      this.ted.tma = String.format("%d", new Object[] { Integer.valueOf(paramInt2) });
      this.ted.tmc = paramInt5;
      this.ted.report();
      AppMethodBeat.o(235303);
      return;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 3;
    }
  }
  
  private boolean cVK()
  {
    return this.tdR == 21;
  }
  
  private boolean cVL()
  {
    AppMethodBeat.i(106719);
    if (this.tdu.thl)
    {
      cVM();
      AppMethodBeat.o(106719);
      return true;
    }
    if ((cVK()) && (this.tee.cWG()))
    {
      this.tee.cWI();
      AppMethodBeat.o(106719);
      return true;
    }
    AppMethodBeat.o(106719);
    return false;
  }
  
  private void cVM()
  {
    AppMethodBeat.i(106720);
    this.tdu.a(false, null);
    this.pop.setOnItemLongClickListener(this.tej);
    this.tei.hide();
    if (cVK()) {
      this.tee.cWI();
    }
    AppMethodBeat.o(106720);
  }
  
  private void fU(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(235304);
    if (this.tdu != null) {}
    for (int j = this.tdu.pHw;; j = 0)
    {
      int i;
      if (this.tdY != null) {
        if (this.tdY.size() > 0) {
          switch (((Integer)this.tdY.get(0)).intValue())
          {
          case 4: 
          case 9: 
          case 10: 
          case 11: 
          case 12: 
          case 13: 
          case 14: 
          case 15: 
          case 16: 
          case 19: 
          case 20: 
          default: 
            i = 0;
          }
        }
      }
      for (;;)
      {
        b(paramInt1, paramInt2, i, j, this.tdu.getCount() - 1, false);
        AppMethodBeat.o(235304);
        return;
        i = 1;
        continue;
        i = 2;
        continue;
        i = 3;
        continue;
        i = 4;
        continue;
        i = 5;
        continue;
        i = 6;
        continue;
        i = 7;
        continue;
        i = 8;
        continue;
        i = 0;
        continue;
        i = 0;
      }
    }
  }
  
  public final void Ec(long paramLong)
  {
    AppMethodBeat.i(106724);
    com.tencent.mm.plugin.fav.ui.widget.b localb;
    if (this.tdu.thl)
    {
      localb = this.tei;
      if (this.tdu.cWp() <= 0) {
        break label47;
      }
    }
    label47:
    for (boolean bool = true;; bool = false)
    {
      localb.gf(bool);
      AppMethodBeat.o(106724);
      return;
    }
  }
  
  public final void Ia(int paramInt)
  {
    AppMethodBeat.i(235306);
    b(3, 0, 1, 2, paramInt, true);
    AppMethodBeat.o(235306);
  }
  
  public final void cVN()
  {
    AppMethodBeat.i(235307);
    b(2, 0, 1, 2, this.ted.tmc, true);
    AppMethodBeat.o(235307);
  }
  
  public final void cVO()
  {
    AppMethodBeat.i(235308);
    b(6, 0, 1, 2, this.ted.tmc, true);
    AppMethodBeat.o(235308);
  }
  
  public final void cVP()
  {
    AppMethodBeat.i(235309);
    b(5, 0, 1, 2, this.ted.tmc, true);
    AppMethodBeat.o(235309);
  }
  
  public final void cVQ()
  {
    AppMethodBeat.i(235310);
    b(8, 0, 1, 2, this.ted.tmc, true);
    AppMethodBeat.o(235310);
  }
  
  public final void cVR()
  {
    AppMethodBeat.i(235311);
    b(4, 0, 1, 2, this.ted.tmc, true);
    AppMethodBeat.o(235311);
  }
  
  public final void fV(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(235305);
    this.ted.tlY = paramInt1;
    this.ted.tmc = paramInt2;
    b(9, 0, 1, 2, paramInt2, true);
    AppMethodBeat.o(235305);
  }
  
  public int getLayoutId()
  {
    return 2131494116;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(106725);
    Log.i("MicroMsg.FavFilterUI", "onActivityResult reqCode: %d, retCod: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(106725);
      return;
    }
    String str1 = paramIntent.getStringExtra("custom_send_text");
    String str2 = paramIntent.getStringExtra("Select_Conv_User");
    switch (paramInt1)
    {
    default: 
    case 1: 
    case 4106: 
    case 4105: 
      for (;;)
      {
        cVL();
        AppMethodBeat.o(106725);
        return;
        if (paramInt2 != -1)
        {
          AppMethodBeat.o(106725);
          return;
        }
        Object localObject1 = this.tee.tkn;
        if (Util.isNullOrNil(str2))
        {
          AppMethodBeat.o(106725);
          return;
        }
        paramIntent = Util.stringsToList(str2.split(","));
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (com.tencent.mm.plugin.fav.ui.gallery.d)((Iterator)localObject1).next();
          if (localObject2 == null)
          {
            Log.d("MicroMsg.FavFilterUI", "select %s, send item null, continute", new Object[] { str2 });
          }
          else
          {
            new com.tencent.mm.plugin.fav.a.k();
            if (com.tencent.mm.plugin.fav.a.k.v(((com.tencent.mm.plugin.fav.ui.gallery.d)localObject2).qNT))
            {
              com.tencent.mm.ui.base.h.cD(getContext(), getString(2131755011));
              AppMethodBeat.o(106725);
              return;
            }
            Log.d("MicroMsg.FavFilterUI", "select %s for sending", new Object[] { str2 });
            Object localObject3;
            Object localObject4;
            if ((((com.tencent.mm.plugin.fav.ui.gallery.d)localObject2).cWJ()) || (((com.tencent.mm.plugin.fav.ui.gallery.d)localObject2).cWL()))
            {
              localObject3 = new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(235288);
                  this.tcT.dismiss();
                  AppMethodBeat.o(235288);
                }
              };
              localObject4 = paramIntent.iterator();
              while (((Iterator)localObject4).hasNext()) {
                l.a(this, (String)((Iterator)localObject4).next(), ((com.tencent.mm.plugin.fav.ui.gallery.d)localObject2).dLo, (Runnable)localObject3);
              }
            }
            else
            {
              localObject3 = new ArrayList();
              ((ArrayList)localObject3).add(com.tencent.mm.plugin.fav.a.b.d(((com.tencent.mm.plugin.fav.ui.gallery.d)localObject2).dLo));
              localObject2 = paramIntent.iterator();
              while (((Iterator)localObject2).hasNext())
              {
                localObject4 = (String)((Iterator)localObject2).next();
                com.tencent.mm.av.q.bcP().a(z.aTY(), (String)localObject4, (ArrayList)localObject3);
              }
            }
          }
        }
        if (!Util.isNullOrNil(str1))
        {
          paramIntent = paramIntent.iterator();
          while (paramIntent.hasNext())
          {
            str2 = (String)paramIntent.next();
            com.tencent.mm.plugin.messenger.a.g.eir().ad(str2, str1, com.tencent.mm.model.ab.JG(str2));
          }
          Log.d("MicroMsg.FavFilterUI", "select %s for sending", new Object[] { str2 });
          paramIntent = new ArrayList();
          paramIntent.add(this.teh);
          p.a(getContext(), paramIntent, str1, str2, "MicroMsg.FavFilterUI");
          continue;
          Log.d("MicroMsg.FavFilterUI", "select %s for sending", new Object[] { str2 });
          p.a(getContext(), this.tdu.mE(false), str1, str2, "MicroMsg.FavFilterUI");
        }
      }
    }
    long l = paramIntent.getLongExtra("key_fav_result_local_id", -1L);
    paramIntent = paramIntent.getStringExtra("key_fav_result_fake_local_id");
    if (-1L == l)
    {
      AppMethodBeat.o(106725);
      return;
    }
    paramInt1 = this.tdu.p(l, paramIntent);
    if (-1 == paramInt1)
    {
      AppMethodBeat.o(106725);
      return;
    }
    this.pop.setSelection(paramInt1);
    AppMethodBeat.o(106725);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(106714);
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle = TransitionInflater.from(this).inflateTransition(17760258);
      paramBundle.excludeTarget(getWindow().getDecorView().findViewById(2131296366), true);
      paramBundle.excludeTarget(16908335, true);
      getWindow().setEnterTransition(paramBundle);
    }
    if ((getSupportActionBar() != null) && (getSupportActionBar().getCustomView() != null)) {
      getSupportActionBar().getCustomView().post(new FavFilterUI.6(this));
    }
    this.tdR = getIntent().getIntExtra("key_preset_search_type", -1);
    setMMTitle(FavSearchActionView.Y(getContext(), this.tdR));
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(235290);
        if (FavFilterUI.d(FavFilterUI.this))
        {
          AppMethodBeat.o(235290);
          return true;
        }
        FavFilterUI.this.finish();
        AppMethodBeat.o(235290);
        return true;
      }
    });
    setActionbarColor(getContext().getResources().getColor(2131100898));
    this.jvZ = getIntent().getIntExtra("key_search_type", 0);
    this.tdV = findViewById(2131307384);
    if (1 == this.jvZ)
    {
      this.dAi = getIntent().getStringExtra("key_to_user");
      this.tdS = getIntent().getStringExtra("key_fav_item_id");
    }
    this.tdW = AnimationUtils.loadAnimation(getContext(), 2130772111);
    this.tdX = AnimationUtils.loadAnimation(getContext(), 2130772112);
    this.pop = ((ListView)findViewById(2131307421));
    this.tee = new c(this, findViewById(2131300488));
    this.tee.tki = this;
    this.tdt = new o(getContext(), 16);
    getContext();
    this.tdu = new com.tencent.mm.plugin.fav.ui.a.b(this.tdt, false);
    this.tdu.ths = this;
    this.tdu.scene = 2;
    this.tdu.thv = this.pop;
    if (1 == this.jvZ)
    {
      this.tdT = new HashSet();
      this.tdU = new com.tencent.mm.plugin.fav.a.k();
      if (!Util.isNullOrNil(this.tdS))
      {
        paramBundle = this.tdS.split(",");
        int j = paramBundle.length;
        int i = 0;
        while (i < j)
        {
          int k = Util.getInt(paramBundle[i], 2147483647);
          if (2147483647 != k) {
            this.tdT.add(Integer.valueOf(k));
          }
          i += 1;
        }
      }
      this.tdu.k(this.tdT);
      this.tdu.a(this.tdU);
    }
    this.pop.setAdapter(this.tdu);
    this.pop.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, final int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(235296);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).pH(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).zo(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/FavFilterUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        localObject = (b.b)paramAnonymousView.getTag();
        if ((localObject != null) && (((b.b)localObject).tbr != null)) {
          FavFilterUI.a(FavFilterUI.this, 2, paramAnonymousInt);
        }
        if (1 == FavFilterUI.a(FavFilterUI.this))
        {
          if (localObject == null)
          {
            Log.w("MicroMsg.FavFilterUI", "on item click, holder is null");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavFilterUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(235296);
            return;
          }
          if (((b.b)localObject).tbr == null)
          {
            Log.w("MicroMsg.FavFilterUI", "on item click, info is null");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavFilterUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(235296);
            return;
          }
          ((com.tencent.mm.plugin.fav.a.ab)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.fav.a.ab.class)).a(FavFilterUI.this.getContext(), FavFilterUI.e(FavFilterUI.this), ((b.b)localObject).tbr, false, new y.a()
          {
            public final void a(boolean paramAnonymous2Boolean, String paramAnonymous2String, int paramAnonymous2Int)
            {
              AppMethodBeat.i(235294);
              FavFilterUI.this.hideVKB();
              if (paramAnonymous2Boolean)
              {
                final com.tencent.mm.ui.base.q localq = com.tencent.mm.ui.base.h.a(FavFilterUI.this.getContext(), FavFilterUI.this.getString(2131759230), false, null);
                l.a(FavFilterUI.this.getContext(), FavFilterUI.e(FavFilterUI.this), paramAnonymous2String, this.tem.tbr, new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(235293);
                    if (localq != null) {
                      localq.dismiss();
                    }
                    com.tencent.mm.ui.widget.snackbar.b.r(FavFilterUI.this, FavFilterUI.this.getString(2131759157));
                    MMHandlerThread.postToMainThreadDelayed(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(235292);
                        FavFilterUI.this.finish();
                        AppMethodBeat.o(235292);
                      }
                    }, 1800L);
                    AppMethodBeat.o(235293);
                  }
                });
              }
              AppMethodBeat.o(235294);
            }
          });
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavFilterUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(235296);
          return;
          if (2 == FavFilterUI.a(FavFilterUI.this))
          {
            if (localObject == null)
            {
              Log.w("MicroMsg.FavFilterUI", "on item click, holder is null");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavFilterUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(235296);
              return;
            }
            if (((b.b)localObject).tbr == null)
            {
              Log.w("MicroMsg.FavFilterUI", "on item click, info is null");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavFilterUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(235296);
              return;
            }
            paramAnonymousAdapterView = new Intent();
            paramAnonymousAdapterView.putExtra("key_fav_result_local_id", ((b.b)localObject).tbr.field_localId);
            FavFilterUI.this.setResult(-1, paramAnonymousAdapterView);
            FavFilterUI.this.finish();
          }
          else
          {
            FavFilterUI.f(FavFilterUI.this).onItemClick(paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
            if (((b.b)localObject).tbr != null) {
              com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(235295);
                  Log.d("MicroMsg.FavFilterUI", "type %s", new Object[] { Integer.valueOf(this.tem.tbr.field_type) });
                  long l = this.tem.tbr.field_localId;
                  if (FavFilterUI.g(FavFilterUI.this).size() == 0) {
                    FavFilterUI.a(FavFilterUI.this, ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().cUZ());
                  }
                  if (FavFilterUI.g(FavFilterUI.this).size() != 0)
                  {
                    localObject = FavFilterUI.g(FavFilterUI.this).iterator();
                    j = 1;
                    for (;;)
                    {
                      i = j;
                      if (!((Iterator)localObject).hasNext()) {
                        break;
                      }
                      i = j;
                      if (((Long)((Iterator)localObject).next()).longValue() == l) {
                        break;
                      }
                      j += 1;
                    }
                  }
                  int i = 1;
                  Object localObject = com.tencent.mm.plugin.report.service.h.CyF;
                  int j = this.tem.tbr.field_type;
                  int k = FavFilterUI.h(FavFilterUI.this);
                  if (FavFilterUI.g(FavFilterUI.this).size() == 0) {
                    i = paramAnonymousInt;
                  }
                  ((com.tencent.mm.plugin.report.service.h)localObject).a(12746, new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i) });
                  AppMethodBeat.o(235295);
                }
              });
            }
          }
        }
      }
    });
    this.pop.setOnItemLongClickListener(this.tej);
    this.pop.setOnTouchListener(new FavFilterUI.10(this));
    this.tei = new com.tencent.mm.plugin.fav.ui.widget.b();
    this.tei.dQ(findViewById(2131300459));
    this.tei.tmy = new b.a()
    {
      public final void cVF()
      {
        AppMethodBeat.i(235302);
        List localList = FavFilterUI.f(FavFilterUI.this).mE(true);
        if (localList.size() == 0)
        {
          Log.e("MicroMsg.FavFilterUI", "FavEditFooter onDelRequest list == null");
          AppMethodBeat.o(235302);
          return;
        }
        final ArrayList localArrayList = new ArrayList();
        HashSet localHashSet = new HashSet();
        Iterator localIterator = localList.iterator();
        final boolean bool = false;
        while (localIterator.hasNext())
        {
          com.tencent.mm.plugin.fav.a.g localg = (com.tencent.mm.plugin.fav.a.g)localIterator.next();
          if (localg.tad)
          {
            localHashSet.add(Long.valueOf(localg.field_localId));
            bool = true;
          }
          else
          {
            localArrayList.add(localg);
          }
        }
        if (localArrayList.size() == 0)
        {
          if (localHashSet.size() >= 2)
          {
            FavFilterUI.j(FavFilterUI.this);
            AppMethodBeat.o(235302);
            return;
          }
          FavFilterUI.a(FavFilterUI.this, null, 0, (com.tencent.mm.plugin.fav.a.g)localList.get(0));
          AppMethodBeat.o(235302);
          return;
        }
        com.tencent.mm.ui.base.h.a(FavFilterUI.this.getContext(), FavFilterUI.this.getString(2131759175), "", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(106694);
            p.a(FavFilterUI.this.getContext(), localArrayList, new p.a()
            {
              public final void cVU()
              {
                AppMethodBeat.i(235300);
                if (FavFilterUI.f(FavFilterUI.this) != null)
                {
                  Log.v("MicroMsg.FavFilterUI", "do refresh job");
                  FavFilterUI.f(FavFilterUI.this).cWm();
                  MMHandlerThread.postToMainThread(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(235299);
                      FavFilterUI.f(FavFilterUI.this).notifyDataSetChanged();
                      AppMethodBeat.o(235299);
                    }
                  });
                  FavFilterUI.a(FavFilterUI.this, 6, 0);
                }
                AppMethodBeat.o(235300);
              }
            });
            FavFilterUI.d(FavFilterUI.this);
            if (bool) {
              FavFilterUI.j(FavFilterUI.this);
            }
            AppMethodBeat.o(106694);
          }
        }, null);
        AppMethodBeat.o(235302);
      }
      
      public final void cVS()
      {
        AppMethodBeat.i(235301);
        if (!FavoriteIndexUI.a(FavFilterUI.f(FavFilterUI.this).mE(false), FavFilterUI.this, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(235298);
            p.b(FavFilterUI.this.getContext(), 4105, FavFilterUI.f(FavFilterUI.this), FavFilterUI.i(FavFilterUI.this));
            FavFilterUI.a(FavFilterUI.this, 3, 0);
            AppMethodBeat.o(235298);
          }
        }))
        {
          AppMethodBeat.o(235301);
          return;
        }
        p.b(FavFilterUI.this.getContext(), 4105, FavFilterUI.f(FavFilterUI.this), FavFilterUI.i(FavFilterUI.this));
        FavFilterUI.a(FavFilterUI.this, 3, 0);
        AppMethodBeat.o(235301);
      }
      
      public final void cVT() {}
    };
    com.tencent.mm.kernel.g.aAk().postToWorkerDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(235291);
        FavFilterUI.a(FavFilterUI.this, ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().cUZ());
        AppMethodBeat.o(235291);
      }
    }, 1000L);
    this.ted = new com.tencent.mm.plugin.fav.ui.f.a();
    this.iOB = System.currentTimeMillis();
    this.ted.hes = com.tencent.mm.plugin.fav.ui.f.a.getSearchId();
    this.ted.tme = this.iOB;
    if (cVK())
    {
      this.pop.setVisibility(8);
      this.tee.setVisibility(0);
      this.ted.hes = com.tencent.mm.plugin.fav.ui.f.a.getSearchId();
      this.tee.bqe();
      AppMethodBeat.o(106714);
      return;
    }
    if (this.tdR > 0)
    {
      this.tdY.clear();
      this.tdY.add(Integer.valueOf(this.tdR));
      this.tdu.c(this.tdY, this.tdZ, this.tea);
      this.tdu.notifyDataSetChanged();
      if (8 != this.tee.gvQ.getVisibility()) {
        this.tee.setVisibility(8);
      }
      if (!this.tdu.isEmpty()) {
        break label877;
      }
      if (this.tdV.getVisibility() != 0)
      {
        this.tdV.setVisibility(0);
        this.tdV.startAnimation(this.tdW);
      }
      if (8 != this.pop.getVisibility())
      {
        this.pop.setVisibility(8);
        this.pop.startAnimation(this.tdX);
      }
    }
    for (;;)
    {
      this.ted.tmf = System.currentTimeMillis();
      fU(9, 0);
      hideVKB();
      this.tee.setVisibility(8);
      this.pop.setVisibility(0);
      AppMethodBeat.o(106714);
      return;
      label877:
      if (8 != this.tdV.getVisibility())
      {
        this.tdV.setVisibility(8);
        this.tdV.startAnimation(this.tdX);
      }
      if (this.pop.getVisibility() != 0)
      {
        this.pop.setVisibility(0);
        this.pop.startAnimation(this.tdW);
      }
    }
  }
  
  @SuppressLint({"ResourceType"})
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(106717);
    MenuItem localMenuItem = paramMenu.add(0, 10, 0, 2131766796);
    localMenuItem.setIcon(ar.m(getContext(), 2131689496, getContext().getResources().getColor(2131099746)));
    localMenuItem.setShowAsAction(2);
    boolean bool = super.onCreateOptionsMenu(paramMenu);
    AppMethodBeat.o(106717);
    return bool;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(106716);
    com.tencent.mm.plugin.fav.ui.f.a locala = this.ted;
    if ((this.ted.actionType != 1) && (this.ted.actionType != 9)) {}
    for (boolean bool = true;; bool = false)
    {
      locala.tmg = bool;
      if (!this.ted.tmg) {
        fU(1, 0);
      }
      this.tee.onDestroy();
      super.onDestroy();
      this.tdt.destory();
      this.tdt = null;
      ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavTagSetMgr().j(this.teb);
      if (this.tdu != null) {
        this.tdu.finish();
      }
      AppMethodBeat.o(106716);
      return;
    }
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(106715);
    if ((4 == paramInt) && (this.tdu.thl))
    {
      cVM();
      AppMethodBeat.o(106715);
      return true;
    }
    if ((4 == paramInt) && (cVK()) && (this.tee.cWG()))
    {
      this.tee.cWI();
      AppMethodBeat.o(106715);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(106715);
    return bool;
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(106718);
    if (paramMenuItem.getItemId() == 10)
    {
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("key_enter_fav_search_from", 0);
      paramMenuItem.putExtra("key_preset_search_type", this.tdR);
      p.a(getContext(), this.tdu.thl, paramMenuItem);
      AppMethodBeat.o(106718);
      return true;
    }
    boolean bool = super.onOptionsItemSelected(paramMenuItem);
    AppMethodBeat.o(106718);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(106723);
    i.arU(getClass().getSimpleName());
    if (cVK()) {
      this.tee.onPause();
    }
    super.onPause();
    AppMethodBeat.o(106723);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(106722);
    this.tdu.cWm();
    this.tdu.notifyDataSetChanged();
    i.arT(getClass().getSimpleName());
    if (cVK()) {
      this.tee.onResume();
    }
    super.onResume();
    AppMethodBeat.o(106722);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavFilterUI
 * JD-Core Version:    0.7.0.1
 */