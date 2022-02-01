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
import android.support.v7.app.AppCompatActivity;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.q;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.fav.a.ab;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.i;
import com.tencent.mm.plugin.fav.a.w;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.e.b.b;
import com.tencent.mm.plugin.fav.ui.e.b.c;
import com.tencent.mm.plugin.fav.ui.gallery.c;
import com.tencent.mm.plugin.fav.ui.gallery.c.a;
import com.tencent.mm.plugin.fav.ui.widget.FavSearchActionView;
import com.tencent.mm.plugin.fav.ui.widget.b.a;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.protocal.protobuf.akp;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.e;
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
  private String diX;
  private int iAK;
  private long nLI;
  private ListView ods;
  private String query;
  private o rDO;
  private com.tencent.mm.plugin.fav.ui.a.b rDP;
  private int[] rEA;
  private com.tencent.mm.plugin.fav.a.g rEB;
  private com.tencent.mm.plugin.fav.a.g rEC;
  private com.tencent.mm.plugin.fav.ui.widget.b rED;
  private AdapterView.OnItemLongClickListener rEE;
  private int rEm;
  private String rEn;
  private Set<Integer> rEo;
  private w rEp;
  private View rEq;
  private Animation rEr;
  private Animation rEs;
  private List<Integer> rEt;
  private List<String> rEu;
  private List<String> rEv;
  private Set<String> rEw;
  private List<Long> rEx;
  com.tencent.mm.plugin.fav.ui.f.a rEy;
  private c rEz;
  
  public FavFilterUI()
  {
    AppMethodBeat.i(106713);
    this.rEm = -1;
    this.rEt = new LinkedList();
    this.rEu = new LinkedList();
    this.rEv = new LinkedList();
    this.rEw = new HashSet();
    this.rEx = new ArrayList();
    this.query = "";
    this.rEA = new int[2];
    this.rEE = new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(106691);
        if (FavFilterUI.a(FavFilterUI.this) == 2)
        {
          ae.w("MicroMsg.FavFilterUI", "on edit mode long click, ignore");
          AppMethodBeat.o(106691);
          return true;
        }
        if (paramAnonymousInt < FavFilterUI.b(FavFilterUI.this).getHeaderViewsCount())
        {
          ae.w("MicroMsg.FavFilterUI", "on header view long click, ignore");
          AppMethodBeat.o(106691);
          return true;
        }
        FavFilterUI.a(FavFilterUI.this, paramAnonymousView, paramAnonymousInt, paramAnonymousLong, FavFilterUI.c(FavFilterUI.this));
        AppMethodBeat.o(106691);
        return true;
      }
    };
    AppMethodBeat.o(106713);
  }
  
  private void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    AppMethodBeat.i(191049);
    int i;
    switch (this.iAK)
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      String str1 = this.query;
      String str2 = this.rEy.kid;
      int j = this.rEy.rMm;
      if (!paramBoolean) {
        j = (int)(this.rEy.rMt - this.rEy.rMs);
      }
      this.rEy.actionType = paramInt1;
      this.rEy.scene = i;
      this.rEy.otZ = paramInt4;
      this.rEy.rMl = paramInt3;
      this.rEy.rMk = ((int)(System.currentTimeMillis() - this.nLI) / 1000);
      this.rEy.query = str1;
      this.rEy.kid = str2;
      this.rEy.rMm = j;
      this.rEy.rMo = String.format("%d", new Object[] { Integer.valueOf(paramInt2) });
      this.rEy.rMq = paramInt5;
      this.rEy.report();
      AppMethodBeat.o(191049);
      return;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 3;
    }
  }
  
  private boolean cxG()
  {
    return this.rEm == 21;
  }
  
  private boolean cxH()
  {
    AppMethodBeat.i(106719);
    if (this.rDP.rHE)
    {
      cxI();
      AppMethodBeat.o(106719);
      return true;
    }
    if ((cxG()) && (this.rEz.cyD()))
    {
      this.rEz.cyF();
      AppMethodBeat.o(106719);
      return true;
    }
    AppMethodBeat.o(106719);
    return false;
  }
  
  private void cxI()
  {
    AppMethodBeat.i(106720);
    this.rDP.a(false, null);
    this.ods.setOnItemLongClickListener(this.rEE);
    this.rED.hide();
    if (cxG()) {
      this.rEz.cyF();
    }
    AppMethodBeat.o(106720);
  }
  
  private void fD(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(191050);
    if (this.rDP != null) {}
    for (int j = this.rDP.otZ;; j = 0)
    {
      int i;
      if (this.rEt != null) {
        if (this.rEt.size() > 0) {
          switch (((Integer)this.rEt.get(0)).intValue())
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
        b(paramInt1, paramInt2, i, j, this.rDP.getCount() - 1, false);
        AppMethodBeat.o(191050);
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
  
  public final void Ep(int paramInt)
  {
    AppMethodBeat.i(191052);
    b(3, 0, 1, 2, paramInt, true);
    AppMethodBeat.o(191052);
  }
  
  public final void cxJ()
  {
    AppMethodBeat.i(191053);
    b(2, 0, 1, 2, this.rEy.rMq, true);
    AppMethodBeat.o(191053);
  }
  
  public final void cxK()
  {
    AppMethodBeat.i(191054);
    b(6, 0, 1, 2, this.rEy.rMq, true);
    AppMethodBeat.o(191054);
  }
  
  public final void cxL()
  {
    AppMethodBeat.i(191055);
    b(5, 0, 1, 2, this.rEy.rMq, true);
    AppMethodBeat.o(191055);
  }
  
  public final void cxM()
  {
    AppMethodBeat.i(191056);
    b(8, 0, 1, 2, this.rEy.rMq, true);
    AppMethodBeat.o(191056);
  }
  
  public final void cxN()
  {
    AppMethodBeat.i(191057);
    b(4, 0, 1, 2, this.rEy.rMq, true);
    AppMethodBeat.o(191057);
  }
  
  public final void fE(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(191051);
    this.rEy.rMm = paramInt1;
    this.rEy.rMq = paramInt2;
    b(9, 0, 1, 2, paramInt2, true);
    AppMethodBeat.o(191051);
  }
  
  public int getLayoutId()
  {
    return 2131493948;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(106725);
    ae.i("MicroMsg.FavFilterUI", "onActivityResult reqCode: %d, retCod: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
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
        cxH();
        AppMethodBeat.o(106725);
        return;
        if (paramInt2 != -1)
        {
          AppMethodBeat.o(106725);
          return;
        }
        Object localObject1 = this.rEz.rKC;
        if (bu.isNullOrNil(str2))
        {
          AppMethodBeat.o(106725);
          return;
        }
        paramIntent = bu.U(str2.split(","));
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (com.tencent.mm.plugin.fav.ui.gallery.d)((Iterator)localObject1).next();
          if (localObject2 == null)
          {
            ae.d("MicroMsg.FavFilterUI", "select %s, send item null, continute", new Object[] { str2 });
          }
          else
          {
            new com.tencent.mm.plugin.fav.a.k();
            if (com.tencent.mm.plugin.fav.a.k.v(((com.tencent.mm.plugin.fav.ui.gallery.d)localObject2).pyC))
            {
              h.cm(getContext(), getString(2131755010));
              AppMethodBeat.o(106725);
              return;
            }
            ae.d("MicroMsg.FavFilterUI", "select %s for sending", new Object[] { str2 });
            Object localObject3;
            Object localObject4;
            if ((((com.tencent.mm.plugin.fav.ui.gallery.d)localObject2).cyG()) || (((com.tencent.mm.plugin.fav.ui.gallery.d)localObject2).cyI()))
            {
              localObject3 = new FavFilterUI.4(this, h.b(getContext(), getString(2131758906), false, null));
              localObject4 = paramIntent.iterator();
              while (((Iterator)localObject4).hasNext()) {
                l.a(this, (String)((Iterator)localObject4).next(), ((com.tencent.mm.plugin.fav.ui.gallery.d)localObject2).dud, (Runnable)localObject3);
              }
            }
            else
            {
              localObject3 = new ArrayList();
              ((ArrayList)localObject3).add(com.tencent.mm.plugin.fav.a.b.d(((com.tencent.mm.plugin.fav.ui.gallery.d)localObject2).dud));
              localObject2 = paramIntent.iterator();
              while (((Iterator)localObject2).hasNext())
              {
                localObject4 = (String)((Iterator)localObject2).next();
                q.aIV().a(v.aAC(), (String)localObject4, (ArrayList)localObject3);
              }
            }
          }
        }
        if (!bu.isNullOrNil(str1))
        {
          paramIntent = paramIntent.iterator();
          while (paramIntent.hasNext())
          {
            str2 = (String)paramIntent.next();
            com.tencent.mm.plugin.messenger.a.g.doC().aa(str2, str1, com.tencent.mm.model.x.Bb(str2));
          }
          ae.d("MicroMsg.FavFilterUI", "select %s for sending", new Object[] { str2 });
          paramIntent = new ArrayList();
          paramIntent.add(this.rEC);
          p.a(getContext(), paramIntent, str1, str2, "MicroMsg.FavFilterUI");
          continue;
          ae.d("MicroMsg.FavFilterUI", "select %s for sending", new Object[] { str2 });
          p.a(getContext(), this.rDP.lB(false), str1, str2, "MicroMsg.FavFilterUI");
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
    paramInt1 = this.rDP.o(l, paramIntent);
    if (-1 == paramInt1)
    {
      AppMethodBeat.o(106725);
      return;
    }
    this.ods.setSelection(paramInt1);
    AppMethodBeat.o(106725);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(106714);
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle = TransitionInflater.from(this).inflateTransition(17760258);
      paramBundle.excludeTarget(getWindow().getDecorView().findViewById(2131296345), true);
      paramBundle.excludeTarget(16908335, true);
      getWindow().setEnterTransition(paramBundle);
    }
    this.rEm = getIntent().getIntExtra("key_preset_search_type", -1);
    setMMTitle(FavSearchActionView.T(getContext(), this.rEm));
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(106697);
        if (FavFilterUI.d(FavFilterUI.this))
        {
          AppMethodBeat.o(106697);
          return true;
        }
        FavFilterUI.this.finish();
        AppMethodBeat.o(106697);
        return true;
      }
    });
    setActionbarColor(getContext().getResources().getColor(2131100705));
    this.iAK = getIntent().getIntExtra("key_search_type", 0);
    this.rEq = findViewById(2131304417);
    if (1 == this.iAK)
    {
      this.diX = getIntent().getStringExtra("key_to_user");
      this.rEn = getIntent().getStringExtra("key_fav_item_id");
    }
    this.rEr = AnimationUtils.loadAnimation(getContext(), 2130772089);
    this.rEs = AnimationUtils.loadAnimation(getContext(), 2130772090);
    this.ods = ((ListView)findViewById(2131304445));
    this.rEz = new c(this, findViewById(2131299813));
    this.rEz.rKx = this;
    this.rDO = new o(getContext(), 16);
    getContext();
    this.rDP = new com.tencent.mm.plugin.fav.ui.a.b(this.rDO, false);
    this.rDP.rHL = this;
    this.rDP.scene = 2;
    this.rDP.rHO = this.ods;
    if (1 == this.iAK)
    {
      this.rEo = new HashSet();
      this.rEp = new com.tencent.mm.plugin.fav.a.k();
      if (!bu.isNullOrNil(this.rEn))
      {
        paramBundle = this.rEn.split(",");
        int j = paramBundle.length;
        int i = 0;
        while (i < j)
        {
          int k = bu.getInt(paramBundle[i], 2147483647);
          if (2147483647 != k) {
            this.rEo.add(Integer.valueOf(k));
          }
          i += 1;
        }
      }
      this.rDP.k(this.rEo);
      this.rDP.a(this.rEp);
    }
    this.ods.setAdapter(this.rDP);
    this.ods.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, final int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(106703);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).mu(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).rl(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/FavFilterUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        localObject = (b.b)paramAnonymousView.getTag();
        if ((localObject != null) && (((b.b)localObject).rBM != null)) {
          FavFilterUI.a(FavFilterUI.this, 2, paramAnonymousInt);
        }
        if (1 == FavFilterUI.a(FavFilterUI.this))
        {
          if (localObject == null)
          {
            ae.w("MicroMsg.FavFilterUI", "on item click, holder is null");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavFilterUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(106703);
            return;
          }
          if (((b.b)localObject).rBM == null)
          {
            ae.w("MicroMsg.FavFilterUI", "on item click, info is null");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavFilterUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(106703);
            return;
          }
          ((ab)com.tencent.mm.kernel.g.ab(ab.class)).a(FavFilterUI.this.getContext(), FavFilterUI.e(FavFilterUI.this), ((b.b)localObject).rBM, false, new y.a()
          {
            public final void a(boolean paramAnonymous2Boolean, String paramAnonymous2String, int paramAnonymous2Int)
            {
              AppMethodBeat.i(106701);
              FavFilterUI.this.hideVKB();
              if (paramAnonymous2Boolean)
              {
                final com.tencent.mm.ui.base.p localp = h.b(FavFilterUI.this.getContext(), FavFilterUI.this.getString(2131758906), false, null);
                l.a(FavFilterUI.this.getContext(), FavFilterUI.e(FavFilterUI.this), paramAnonymous2String, this.rEH.rBM, new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(106700);
                    if (localp != null) {
                      localp.dismiss();
                    }
                    com.tencent.mm.ui.widget.snackbar.b.n(FavFilterUI.this, FavFilterUI.this.getString(2131758834));
                    ar.o(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(106699);
                        FavFilterUI.this.finish();
                        AppMethodBeat.o(106699);
                      }
                    }, 1800L);
                    AppMethodBeat.o(106700);
                  }
                });
              }
              AppMethodBeat.o(106701);
            }
          });
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavFilterUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(106703);
          return;
          if (2 == FavFilterUI.a(FavFilterUI.this))
          {
            if (localObject == null)
            {
              ae.w("MicroMsg.FavFilterUI", "on item click, holder is null");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavFilterUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(106703);
              return;
            }
            if (((b.b)localObject).rBM == null)
            {
              ae.w("MicroMsg.FavFilterUI", "on item click, info is null");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavFilterUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(106703);
              return;
            }
            paramAnonymousAdapterView = new Intent();
            paramAnonymousAdapterView.putExtra("key_fav_result_local_id", ((b.b)localObject).rBM.field_localId);
            FavFilterUI.this.setResult(-1, paramAnonymousAdapterView);
            FavFilterUI.this.finish();
          }
          else
          {
            FavFilterUI.f(FavFilterUI.this).onItemClick(paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
            if (((b.b)localObject).rBM != null) {
              com.tencent.mm.kernel.g.ajU().aw(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(106702);
                  ae.d("MicroMsg.FavFilterUI", "type %s", new Object[] { Integer.valueOf(this.rEH.rBM.field_type) });
                  long l = this.rEH.rBM.field_localId;
                  if (FavFilterUI.g(FavFilterUI.this).size() == 0) {
                    FavFilterUI.a(FavFilterUI.this, ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().cwV());
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
                  Object localObject = com.tencent.mm.plugin.report.service.g.yxI;
                  int j = this.rEH.rBM.field_type;
                  int k = FavFilterUI.h(FavFilterUI.this);
                  if (FavFilterUI.g(FavFilterUI.this).size() == 0) {
                    i = paramAnonymousInt;
                  }
                  ((com.tencent.mm.plugin.report.service.g)localObject).f(12746, new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i) });
                  AppMethodBeat.o(106702);
                }
              });
            }
          }
        }
      }
    });
    this.ods.setOnItemLongClickListener(this.rEE);
    this.ods.setOnTouchListener(new FavFilterUI.8(this));
    this.rED = new com.tencent.mm.plugin.fav.ui.widget.b();
    this.rED.dY(findViewById(2131299786));
    this.rED.rMM = new b.a()
    {
      public final void cxB()
      {
        AppMethodBeat.i(106710);
        List localList = FavFilterUI.f(FavFilterUI.this).lB(true);
        if (localList.size() == 0)
        {
          ae.e("MicroMsg.FavFilterUI", "FavEditFooter onDelRequest list == null");
          AppMethodBeat.o(106710);
          return;
        }
        final ArrayList localArrayList = new ArrayList();
        HashSet localHashSet = new HashSet();
        Iterator localIterator = localList.iterator();
        final boolean bool = false;
        while (localIterator.hasNext())
        {
          com.tencent.mm.plugin.fav.a.g localg = (com.tencent.mm.plugin.fav.a.g)localIterator.next();
          if (localg.rAz)
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
            AppMethodBeat.o(106710);
            return;
          }
          FavFilterUI.a(FavFilterUI.this, null, 0, (com.tencent.mm.plugin.fav.a.g)localList.get(0));
          AppMethodBeat.o(106710);
          return;
        }
        h.a(FavFilterUI.this.getContext(), FavFilterUI.this.getString(2131758852), "", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(106708);
            p.a(FavFilterUI.this.getContext(), localArrayList, new p.a()
            {
              public final void cxQ()
              {
                AppMethodBeat.i(106707);
                if (FavFilterUI.f(FavFilterUI.this) != null)
                {
                  ae.v("MicroMsg.FavFilterUI", "do refresh job");
                  FavFilterUI.f(FavFilterUI.this).cyi();
                  ar.f(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(106706);
                      FavFilterUI.f(FavFilterUI.this).notifyDataSetChanged();
                      AppMethodBeat.o(106706);
                    }
                  });
                  FavFilterUI.a(FavFilterUI.this, 6, 0);
                }
                AppMethodBeat.o(106707);
              }
            });
            FavFilterUI.d(FavFilterUI.this);
            if (bool) {
              FavFilterUI.j(FavFilterUI.this);
            }
            AppMethodBeat.o(106708);
          }
        }, null);
        AppMethodBeat.o(106710);
      }
      
      public final void cxO()
      {
        AppMethodBeat.i(106709);
        if (!FavoriteIndexUI.a(FavFilterUI.f(FavFilterUI.this).lB(false), FavFilterUI.this, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(106705);
            p.b(FavFilterUI.this.getContext(), 4105, FavFilterUI.f(FavFilterUI.this), FavFilterUI.i(FavFilterUI.this));
            FavFilterUI.a(FavFilterUI.this, 3, 0);
            AppMethodBeat.o(106705);
          }
        }))
        {
          AppMethodBeat.o(106709);
          return;
        }
        p.b(FavFilterUI.this.getContext(), 4105, FavFilterUI.f(FavFilterUI.this), FavFilterUI.i(FavFilterUI.this));
        FavFilterUI.a(FavFilterUI.this, 3, 0);
        AppMethodBeat.o(106709);
      }
      
      public final void cxP() {}
    };
    com.tencent.mm.kernel.g.ajU().n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106698);
        FavFilterUI.a(FavFilterUI.this, ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().cwV());
        AppMethodBeat.o(106698);
      }
    }, 1000L);
    this.rEy = new com.tencent.mm.plugin.fav.ui.f.a();
    this.nLI = System.currentTimeMillis();
    this.rEy.kid = com.tencent.mm.plugin.fav.ui.f.a.getSearchId();
    this.rEy.rMs = this.nLI;
    if (cxG())
    {
      this.ods.setVisibility(8);
      this.rEz.setVisibility(0);
      this.rEy.kid = com.tencent.mm.plugin.fav.ui.f.a.getSearchId();
      this.rEz.aVt();
      AppMethodBeat.o(106714);
      return;
    }
    if (this.rEm > 0)
    {
      this.rEt.clear();
      this.rEt.add(Integer.valueOf(this.rEm));
      this.rDP.c(this.rEt, this.rEu, this.rEv);
      this.rDP.notifyDataSetChanged();
      if (8 != this.rEz.fQH.getVisibility()) {
        this.rEz.setVisibility(8);
      }
      if (!this.rDP.isEmpty()) {
        break label841;
      }
      if (this.rEq.getVisibility() != 0)
      {
        this.rEq.setVisibility(0);
        this.rEq.startAnimation(this.rEr);
      }
      if (8 != this.ods.getVisibility())
      {
        this.ods.setVisibility(8);
        this.ods.startAnimation(this.rEs);
      }
    }
    for (;;)
    {
      this.rEy.rMt = System.currentTimeMillis();
      fD(9, 0);
      hideVKB();
      this.rEz.setVisibility(8);
      this.ods.setVisibility(0);
      AppMethodBeat.o(106714);
      return;
      label841:
      if (8 != this.rEq.getVisibility())
      {
        this.rEq.setVisibility(8);
        this.rEq.startAnimation(this.rEs);
      }
      if (this.ods.getVisibility() != 0)
      {
        this.ods.setVisibility(0);
        this.ods.startAnimation(this.rEr);
      }
    }
  }
  
  @SuppressLint({"ResourceType"})
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(106717);
    MenuItem localMenuItem = paramMenu.add(0, 10, 0, 2131764452);
    localMenuItem.setIcon(ao.k(getContext(), 2131689494, getContext().getResources().getColor(2131099732)));
    localMenuItem.setShowAsAction(2);
    boolean bool = super.onCreateOptionsMenu(paramMenu);
    AppMethodBeat.o(106717);
    return bool;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(106716);
    com.tencent.mm.plugin.fav.ui.f.a locala = this.rEy;
    if ((this.rEy.actionType != 1) && (this.rEy.actionType != 9)) {}
    for (boolean bool = true;; bool = false)
    {
      locala.rMu = bool;
      if (!this.rEy.rMu) {
        fD(1, 0);
      }
      this.rEz.onDestroy();
      super.onDestroy();
      this.rDO.destory();
      this.rDO = null;
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavTagSetMgr().j(this.rEw);
      if (this.rDP != null) {
        this.rDP.finish();
      }
      AppMethodBeat.o(106716);
      return;
    }
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(106715);
    if ((4 == paramInt) && (this.rDP.rHE))
    {
      cxI();
      AppMethodBeat.o(106715);
      return true;
    }
    if ((4 == paramInt) && (cxG()) && (this.rEz.cyD()))
    {
      this.rEz.cyF();
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
      paramMenuItem.putExtra("key_preset_search_type", this.rEm);
      p.a(getContext(), this.rDP.rHE, paramMenuItem);
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
    i.ahm(getClass().getSimpleName());
    if (cxG()) {
      this.rEz.onPause();
    }
    super.onPause();
    AppMethodBeat.o(106723);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(106722);
    this.rDP.cyi();
    this.rDP.notifyDataSetChanged();
    i.ahl(getClass().getSimpleName());
    if (cxG()) {
      this.rEz.onResume();
    }
    super.onResume();
    AppMethodBeat.o(106722);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void vY(long paramLong)
  {
    AppMethodBeat.i(106724);
    com.tencent.mm.plugin.fav.ui.widget.b localb;
    if (this.rDP.rHE)
    {
      localb = this.rED;
      if (this.rDP.cyl() <= 0) {
        break label47;
      }
    }
    label47:
    for (boolean bool = true;; bool = false)
    {
      localb.lG(bool);
      AppMethodBeat.o(106724);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavFilterUI
 * JD-Core Version:    0.7.0.1
 */