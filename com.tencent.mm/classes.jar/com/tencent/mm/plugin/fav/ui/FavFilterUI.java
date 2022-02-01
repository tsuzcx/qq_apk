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
import com.tencent.mm.aw.q;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.fav.a.ab;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.i;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.e.b.b;
import com.tencent.mm.plugin.fav.ui.e.b.c;
import com.tencent.mm.plugin.fav.ui.gallery.c;
import com.tencent.mm.plugin.fav.ui.gallery.c.a;
import com.tencent.mm.plugin.fav.ui.widget.FavSearchActionView;
import com.tencent.mm.plugin.fav.ui.widget.b.a;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.protocal.protobuf.akf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
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
  private String dhU;
  private int ixR;
  private long nGh;
  private ListView nXJ;
  private String query;
  private o rvC;
  private com.tencent.mm.plugin.fav.ui.a.b rvD;
  private int rwa;
  private String rwb;
  private Set<Integer> rwc;
  private com.tencent.mm.plugin.fav.a.w rwd;
  private View rwe;
  private Animation rwf;
  private Animation rwg;
  private List<Integer> rwh;
  private List<String> rwi;
  private List<String> rwj;
  private Set<String> rwk;
  private List<Long> rwl;
  com.tencent.mm.plugin.fav.ui.f.a rwm;
  private c rwn;
  private int[] rwo;
  private com.tencent.mm.plugin.fav.a.g rwp;
  private com.tencent.mm.plugin.fav.a.g rwq;
  private com.tencent.mm.plugin.fav.ui.widget.b rwr;
  private AdapterView.OnItemLongClickListener rws;
  
  public FavFilterUI()
  {
    AppMethodBeat.i(106713);
    this.rwa = -1;
    this.rwh = new LinkedList();
    this.rwi = new LinkedList();
    this.rwj = new LinkedList();
    this.rwk = new HashSet();
    this.rwl = new ArrayList();
    this.query = "";
    this.rwo = new int[2];
    this.rws = new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(106691);
        if (FavFilterUI.a(FavFilterUI.this) == 2)
        {
          ad.w("MicroMsg.FavFilterUI", "on edit mode long click, ignore");
          AppMethodBeat.o(106691);
          return true;
        }
        if (paramAnonymousInt < FavFilterUI.b(FavFilterUI.this).getHeaderViewsCount())
        {
          ad.w("MicroMsg.FavFilterUI", "on header view long click, ignore");
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
    AppMethodBeat.i(218774);
    int i;
    switch (this.ixR)
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      String str1 = this.query;
      String str2 = this.rwm.keN;
      int j = this.rwm.rEb;
      if (!paramBoolean) {
        j = (int)(this.rwm.rEi - this.rwm.rEh);
      }
      this.rwm.actionType = paramInt1;
      this.rwm.scene = i;
      this.rwm.ooi = paramInt4;
      this.rwm.rEa = paramInt3;
      this.rwm.rDZ = ((int)(System.currentTimeMillis() - this.nGh) / 1000);
      this.rwm.query = str1;
      this.rwm.keN = str2;
      this.rwm.rEb = j;
      this.rwm.rEd = String.format("%d", new Object[] { Integer.valueOf(paramInt2) });
      this.rwm.rEf = paramInt5;
      this.rwm.report();
      AppMethodBeat.o(218774);
      return;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 3;
    }
  }
  
  private boolean cwf()
  {
    return this.rwa == 21;
  }
  
  private boolean cwg()
  {
    AppMethodBeat.i(106719);
    if (this.rvD.rzt)
    {
      cwh();
      AppMethodBeat.o(106719);
      return true;
    }
    if ((cwf()) && (this.rwn.cxc()))
    {
      this.rwn.cxe();
      AppMethodBeat.o(106719);
      return true;
    }
    AppMethodBeat.o(106719);
    return false;
  }
  
  private void cwh()
  {
    AppMethodBeat.i(106720);
    this.rvD.a(false, null);
    this.nXJ.setOnItemLongClickListener(this.rws);
    this.rwr.hide();
    if (cwf()) {
      this.rwn.cxe();
    }
    AppMethodBeat.o(106720);
  }
  
  private void fF(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(218775);
    if (this.rvD != null) {}
    for (int j = this.rvD.ooi;; j = 0)
    {
      int i;
      if (this.rwh != null) {
        if (this.rwh.size() > 0) {
          switch (((Integer)this.rwh.get(0)).intValue())
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
        b(paramInt1, paramInt2, i, j, this.rvD.getCount() - 1, false);
        AppMethodBeat.o(218775);
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
  
  public final void Ec(int paramInt)
  {
    AppMethodBeat.i(218777);
    b(3, 0, 1, 2, paramInt, true);
    AppMethodBeat.o(218777);
  }
  
  public final void cwi()
  {
    AppMethodBeat.i(218778);
    b(2, 0, 1, 2, this.rwm.rEf, true);
    AppMethodBeat.o(218778);
  }
  
  public final void cwj()
  {
    AppMethodBeat.i(218779);
    b(6, 0, 1, 2, this.rwm.rEf, true);
    AppMethodBeat.o(218779);
  }
  
  public final void cwk()
  {
    AppMethodBeat.i(218780);
    b(5, 0, 1, 2, this.rwm.rEf, true);
    AppMethodBeat.o(218780);
  }
  
  public final void cwl()
  {
    AppMethodBeat.i(218781);
    b(8, 0, 1, 2, this.rwm.rEf, true);
    AppMethodBeat.o(218781);
  }
  
  public final void cwm()
  {
    AppMethodBeat.i(218782);
    b(4, 0, 1, 2, this.rwm.rEf, true);
    AppMethodBeat.o(218782);
  }
  
  public final void fG(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(218776);
    this.rwm.rEb = paramInt1;
    this.rwm.rEf = paramInt2;
    b(9, 0, 1, 2, paramInt2, true);
    AppMethodBeat.o(218776);
  }
  
  public int getLayoutId()
  {
    return 2131493948;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(106725);
    ad.i("MicroMsg.FavFilterUI", "onActivityResult reqCode: %d, retCod: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
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
        cwg();
        AppMethodBeat.o(106725);
        return;
        if (paramInt2 != -1)
        {
          AppMethodBeat.o(106725);
          return;
        }
        Object localObject1 = this.rwn.rCr;
        if (bt.isNullOrNil(str2))
        {
          AppMethodBeat.o(106725);
          return;
        }
        paramIntent = bt.U(str2.split(","));
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (com.tencent.mm.plugin.fav.ui.gallery.d)((Iterator)localObject1).next();
          if (localObject2 == null)
          {
            ad.d("MicroMsg.FavFilterUI", "select %s, send item null, continute", new Object[] { str2 });
          }
          else
          {
            new com.tencent.mm.plugin.fav.a.k();
            if (com.tencent.mm.plugin.fav.a.k.v(((com.tencent.mm.plugin.fav.ui.gallery.d)localObject2).prW))
            {
              h.cl(getContext(), getString(2131755010));
              AppMethodBeat.o(106725);
              return;
            }
            ad.d("MicroMsg.FavFilterUI", "select %s for sending", new Object[] { str2 });
            Object localObject3;
            Object localObject4;
            if ((((com.tencent.mm.plugin.fav.ui.gallery.d)localObject2).cxf()) || (((com.tencent.mm.plugin.fav.ui.gallery.d)localObject2).cxh()))
            {
              localObject3 = new FavFilterUI.4(this, h.b(getContext(), getString(2131758906), false, null));
              localObject4 = paramIntent.iterator();
              while (((Iterator)localObject4).hasNext()) {
                l.a(this, (String)((Iterator)localObject4).next(), ((com.tencent.mm.plugin.fav.ui.gallery.d)localObject2).dsX, (Runnable)localObject3);
              }
            }
            else
            {
              localObject3 = new ArrayList();
              ((ArrayList)localObject3).add(com.tencent.mm.plugin.fav.a.b.d(((com.tencent.mm.plugin.fav.ui.gallery.d)localObject2).dsX));
              localObject2 = paramIntent.iterator();
              while (((Iterator)localObject2).hasNext())
              {
                localObject4 = (String)((Iterator)localObject2).next();
                q.aID().a(u.aAm(), (String)localObject4, (ArrayList)localObject3);
              }
            }
          }
        }
        if (!bt.isNullOrNil(str1))
        {
          paramIntent = paramIntent.iterator();
          while (paramIntent.hasNext())
          {
            str2 = (String)paramIntent.next();
            com.tencent.mm.plugin.messenger.a.g.dlD().aa(str2, str1, com.tencent.mm.model.w.Ar(str2));
          }
          ad.d("MicroMsg.FavFilterUI", "select %s for sending", new Object[] { str2 });
          paramIntent = new ArrayList();
          paramIntent.add(this.rwq);
          p.a(getContext(), paramIntent, str1, str2, "MicroMsg.FavFilterUI");
          continue;
          ad.d("MicroMsg.FavFilterUI", "select %s for sending", new Object[] { str2 });
          p.a(getContext(), this.rvD.lB(false), str1, str2, "MicroMsg.FavFilterUI");
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
    paramInt1 = this.rvD.o(l, paramIntent);
    if (-1 == paramInt1)
    {
      AppMethodBeat.o(106725);
      return;
    }
    this.nXJ.setSelection(paramInt1);
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
    this.rwa = getIntent().getIntExtra("key_preset_search_type", -1);
    setMMTitle(FavSearchActionView.T(getContext(), this.rwa));
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
    this.ixR = getIntent().getIntExtra("key_search_type", 0);
    this.rwe = findViewById(2131304417);
    if (1 == this.ixR)
    {
      this.dhU = getIntent().getStringExtra("key_to_user");
      this.rwb = getIntent().getStringExtra("key_fav_item_id");
    }
    this.rwf = AnimationUtils.loadAnimation(getContext(), 2130772089);
    this.rwg = AnimationUtils.loadAnimation(getContext(), 2130772090);
    this.nXJ = ((ListView)findViewById(2131304445));
    this.rwn = new c(this, findViewById(2131299813));
    this.rwn.rCm = this;
    this.rvC = new o(getContext(), 16);
    getContext();
    this.rvD = new com.tencent.mm.plugin.fav.ui.a.b(this.rvC, false);
    this.rvD.rzA = this;
    this.rvD.scene = 2;
    this.rvD.rzD = this.nXJ;
    if (1 == this.ixR)
    {
      this.rwc = new HashSet();
      this.rwd = new com.tencent.mm.plugin.fav.a.k();
      if (!bt.isNullOrNil(this.rwb))
      {
        paramBundle = this.rwb.split(",");
        int j = paramBundle.length;
        int i = 0;
        while (i < j)
        {
          int k = bt.getInt(paramBundle[i], 2147483647);
          if (2147483647 != k) {
            this.rwc.add(Integer.valueOf(k));
          }
          i += 1;
        }
      }
      this.rvD.k(this.rwc);
      this.rvD.a(this.rwd);
    }
    this.nXJ.setAdapter(this.rvD);
    this.nXJ.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, final int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(106703);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).mr(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).qY(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/FavFilterUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        localObject = (b.b)paramAnonymousView.getTag();
        if ((localObject != null) && (((b.b)localObject).rtA != null)) {
          FavFilterUI.a(FavFilterUI.this, 2, paramAnonymousInt);
        }
        if (1 == FavFilterUI.a(FavFilterUI.this))
        {
          if (localObject == null)
          {
            ad.w("MicroMsg.FavFilterUI", "on item click, holder is null");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavFilterUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(106703);
            return;
          }
          if (((b.b)localObject).rtA == null)
          {
            ad.w("MicroMsg.FavFilterUI", "on item click, info is null");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavFilterUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(106703);
            return;
          }
          ((ab)com.tencent.mm.kernel.g.ab(ab.class)).a(FavFilterUI.this.getContext(), FavFilterUI.e(FavFilterUI.this), ((b.b)localObject).rtA, false, new y.a()
          {
            public final void a(boolean paramAnonymous2Boolean, String paramAnonymous2String, int paramAnonymous2Int)
            {
              AppMethodBeat.i(106701);
              FavFilterUI.this.hideVKB();
              if (paramAnonymous2Boolean)
              {
                final com.tencent.mm.ui.base.p localp = h.b(FavFilterUI.this.getContext(), FavFilterUI.this.getString(2131758906), false, null);
                l.a(FavFilterUI.this.getContext(), FavFilterUI.e(FavFilterUI.this), paramAnonymous2String, this.rwv.rtA, new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(106700);
                    if (localp != null) {
                      localp.dismiss();
                    }
                    com.tencent.mm.ui.widget.snackbar.b.n(FavFilterUI.this, FavFilterUI.this.getString(2131758834));
                    aq.o(new Runnable()
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
              ad.w("MicroMsg.FavFilterUI", "on item click, holder is null");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavFilterUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(106703);
              return;
            }
            if (((b.b)localObject).rtA == null)
            {
              ad.w("MicroMsg.FavFilterUI", "on item click, info is null");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavFilterUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(106703);
              return;
            }
            paramAnonymousAdapterView = new Intent();
            paramAnonymousAdapterView.putExtra("key_fav_result_local_id", ((b.b)localObject).rtA.field_localId);
            FavFilterUI.this.setResult(-1, paramAnonymousAdapterView);
            FavFilterUI.this.finish();
          }
          else
          {
            FavFilterUI.f(FavFilterUI.this).onItemClick(paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
            if (((b.b)localObject).rtA != null) {
              com.tencent.mm.kernel.g.ajF().ay(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(106702);
                  ad.d("MicroMsg.FavFilterUI", "type %s", new Object[] { Integer.valueOf(this.rwv.rtA.field_type) });
                  long l = this.rwv.rtA.field_localId;
                  if (FavFilterUI.g(FavFilterUI.this).size() == 0) {
                    FavFilterUI.a(FavFilterUI.this, ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().cvu());
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
                  Object localObject = com.tencent.mm.plugin.report.service.g.yhR;
                  int j = this.rwv.rtA.field_type;
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
    this.nXJ.setOnItemLongClickListener(this.rws);
    this.nXJ.setOnTouchListener(new FavFilterUI.8(this));
    this.rwr = new com.tencent.mm.plugin.fav.ui.widget.b();
    this.rwr.dY(findViewById(2131299786));
    this.rwr.rEB = new b.a()
    {
      public final void cwa()
      {
        AppMethodBeat.i(106710);
        List localList = FavFilterUI.f(FavFilterUI.this).lB(true);
        if (localList.size() == 0)
        {
          ad.e("MicroMsg.FavFilterUI", "FavEditFooter onDelRequest list == null");
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
          if (localg.rsm)
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
              public final void cwp()
              {
                AppMethodBeat.i(106707);
                if (FavFilterUI.f(FavFilterUI.this) != null)
                {
                  ad.v("MicroMsg.FavFilterUI", "do refresh job");
                  FavFilterUI.f(FavFilterUI.this).cwH();
                  aq.f(new Runnable()
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
      
      public final void cwn()
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
      
      public final void cwo() {}
    };
    com.tencent.mm.kernel.g.ajF().n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106698);
        FavFilterUI.a(FavFilterUI.this, ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().cvu());
        AppMethodBeat.o(106698);
      }
    }, 1000L);
    this.rwm = new com.tencent.mm.plugin.fav.ui.f.a();
    this.nGh = System.currentTimeMillis();
    this.rwm.keN = com.tencent.mm.plugin.fav.ui.f.a.getSearchId();
    this.rwm.rEh = this.nGh;
    if (cwf())
    {
      this.nXJ.setVisibility(8);
      this.rwn.setVisibility(0);
      this.rwm.keN = com.tencent.mm.plugin.fav.ui.f.a.getSearchId();
      this.rwn.aUU();
      AppMethodBeat.o(106714);
      return;
    }
    if (this.rwa > 0)
    {
      this.rwh.clear();
      this.rwh.add(Integer.valueOf(this.rwa));
      this.rvD.c(this.rwh, this.rwi, this.rwj);
      this.rvD.notifyDataSetChanged();
      if (8 != this.rwn.fOB.getVisibility()) {
        this.rwn.setVisibility(8);
      }
      if (!this.rvD.isEmpty()) {
        break label841;
      }
      if (this.rwe.getVisibility() != 0)
      {
        this.rwe.setVisibility(0);
        this.rwe.startAnimation(this.rwf);
      }
      if (8 != this.nXJ.getVisibility())
      {
        this.nXJ.setVisibility(8);
        this.nXJ.startAnimation(this.rwg);
      }
    }
    for (;;)
    {
      this.rwm.rEi = System.currentTimeMillis();
      fF(9, 0);
      hideVKB();
      this.rwn.setVisibility(8);
      this.nXJ.setVisibility(0);
      AppMethodBeat.o(106714);
      return;
      label841:
      if (8 != this.rwe.getVisibility())
      {
        this.rwe.setVisibility(8);
        this.rwe.startAnimation(this.rwg);
      }
      if (this.nXJ.getVisibility() != 0)
      {
        this.nXJ.setVisibility(0);
        this.nXJ.startAnimation(this.rwf);
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
    com.tencent.mm.plugin.fav.ui.f.a locala = this.rwm;
    if ((this.rwm.actionType != 1) && (this.rwm.actionType != 9)) {}
    for (boolean bool = true;; bool = false)
    {
      locala.rEj = bool;
      if (!this.rwm.rEj) {
        fF(1, 0);
      }
      this.rwn.onDestroy();
      super.onDestroy();
      this.rvC.destory();
      this.rvC = null;
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavTagSetMgr().j(this.rwk);
      if (this.rvD != null) {
        this.rvD.finish();
      }
      AppMethodBeat.o(106716);
      return;
    }
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(106715);
    if ((4 == paramInt) && (this.rvD.rzt))
    {
      cwh();
      AppMethodBeat.o(106715);
      return true;
    }
    if ((4 == paramInt) && (cwf()) && (this.rwn.cxc()))
    {
      this.rwn.cxe();
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
      paramMenuItem.putExtra("key_preset_search_type", this.rwa);
      p.a(getContext(), this.rvD.rzt, paramMenuItem);
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
    i.agp(getClass().getSimpleName());
    if (cwf()) {
      this.rwn.onPause();
    }
    super.onPause();
    AppMethodBeat.o(106723);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(106722);
    this.rvD.cwH();
    this.rvD.notifyDataSetChanged();
    i.ago(getClass().getSimpleName());
    if (cwf()) {
      this.rwn.onResume();
    }
    super.onResume();
    AppMethodBeat.o(106722);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void vI(long paramLong)
  {
    AppMethodBeat.i(106724);
    com.tencent.mm.plugin.fav.ui.widget.b localb;
    if (this.rvD.rzt)
    {
      localb = this.rwr;
      if (this.rvD.cwK() <= 0) {
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