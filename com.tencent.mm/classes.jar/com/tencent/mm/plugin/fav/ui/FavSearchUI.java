package com.tencent.mm.plugin.fav.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.h.a;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar.LayoutParams;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
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
import com.tencent.mm.plugin.fav.ui.widget.FavCapacityPanel;
import com.tencent.mm.plugin.fav.ui.widget.FavSearchActionView;
import com.tencent.mm.plugin.fav.ui.widget.FavSearchActionView.a;
import com.tencent.mm.plugin.fav.ui.widget.FavTagPanel;
import com.tencent.mm.plugin.fav.ui.widget.b.a;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.protocal.protobuf.akf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@com.tencent.mm.ui.base.a(3)
public class FavSearchUI
  extends MMActivity
  implements b.c
{
  private String dhU;
  private int ixR;
  private ap mHandler;
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
  private com.tencent.mm.plugin.fav.ui.gallery.c rwn;
  private int[] rwo;
  private com.tencent.mm.plugin.fav.a.g rwp;
  private com.tencent.mm.plugin.fav.a.g rwq;
  private com.tencent.mm.plugin.fav.ui.widget.b rwr;
  private AdapterView.OnItemLongClickListener rws;
  private com.tencent.mm.plugin.fav.ui.a.c rxq;
  private FavSearchActionView rxr;
  private ListView rxs;
  private FavCapacityPanel rxt;
  private View rxu;
  private ImageButton rxv;
  private MenuItem rxw;
  private akf rxx;
  
  public FavSearchUI()
  {
    AppMethodBeat.i(106845);
    this.rwa = -1;
    this.rwk = new HashSet();
    this.rwl = new ArrayList();
    this.query = "";
    this.rwo = new int[2];
    this.rxx = new akf();
    this.rws = new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(106813);
        if (FavSearchUI.a(FavSearchUI.this) == 2)
        {
          ad.w("MicroMsg.FavSearchUI", "on edit mode long click, ignore");
          AppMethodBeat.o(106813);
          return true;
        }
        if (paramAnonymousInt < FavSearchUI.b(FavSearchUI.this).getHeaderViewsCount())
        {
          ad.w("MicroMsg.FavSearchUI", "on header view long click, ignore");
          AppMethodBeat.o(106813);
          return true;
        }
        FavSearchUI.a(FavSearchUI.this, paramAnonymousView, paramAnonymousInt, paramAnonymousLong, FavSearchUI.c(FavSearchUI.this));
        AppMethodBeat.o(106813);
        return true;
      }
    };
    AppMethodBeat.o(106845);
  }
  
  public static void an(Activity paramActivity)
  {
    AppMethodBeat.i(106852);
    f.a locala = new f.a(paramActivity);
    locala.aXO(paramActivity.getString(2131758854));
    locala.aXS(paramActivity.getString(2131758851));
    locala.b(new f.c()
    {
      public final void d(boolean paramAnonymousBoolean, String paramAnonymousString) {}
    });
    locala.show();
    AppMethodBeat.o(106852);
  }
  
  private boolean cwf()
  {
    return this.rwa == 21;
  }
  
  private boolean cwg()
  {
    AppMethodBeat.i(106851);
    if (this.rvD.rzt)
    {
      cwh();
      AppMethodBeat.o(106851);
      return true;
    }
    if ((cwf()) && (this.rwn.cxc()))
    {
      this.rwn.cxe();
      AppMethodBeat.o(106851);
      return true;
    }
    AppMethodBeat.o(106851);
    return false;
  }
  
  private void cwh()
  {
    AppMethodBeat.i(106853);
    this.rvD.a(false, null);
    this.nXJ.setOnItemLongClickListener(this.rws);
    this.rwr.hide();
    if (cwf()) {
      this.rwn.cxe();
    }
    AppMethodBeat.o(106853);
  }
  
  private void cwv()
  {
    AppMethodBeat.i(106850);
    if (this.rxr != null)
    {
      AppMethodBeat.o(106850);
      return;
    }
    this.rxr = ((FavSearchActionView)View.inflate(getContext(), 2131493975, null));
    this.rxu = this.rxr.findViewById(2131297690);
    this.rxu.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(106836);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/FavSearchUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (FavSearchUI.e(FavSearchUI.this))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavSearchUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(106836);
          return;
        }
        FavSearchUI.this.finish();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavSearchUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(106836);
      }
    });
    this.rxv = ((ImageButton)this.rxr.findViewById(2131304401));
    this.rxv.setVisibility(8);
    this.rxr.setOnSearchChangedListener(new FavSearchActionView.a()
    {
      public final void a(String paramAnonymousString, final List<Integer> paramAnonymousList, final List<String> paramAnonymousList1, final List<String> paramAnonymousList2)
      {
        AppMethodBeat.i(106840);
        FavSearchUI.d(FavSearchUI.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(106837);
            if ((paramAnonymousList1.isEmpty()) && (paramAnonymousList2.isEmpty()) && (FavSearchUI.h(FavSearchUI.this)))
            {
              FavSearchUI.a(FavSearchUI.this, false);
              FavSearchUI.a(FavSearchUI.this, paramAnonymousList1, paramAnonymousList2);
              AppMethodBeat.o(106837);
              return;
            }
            FavSearchUI.a(FavSearchUI.this, paramAnonymousList1, paramAnonymousList2);
            ad.d("MicroMsg.FavSearchUI", "on text changed, types %s keys %s tags %s", new Object[] { paramAnonymousList, paramAnonymousList1, paramAnonymousList2 });
            FavSearchUI.b(FavSearchUI.this, paramAnonymousList1);
            FavSearchUI.c(FavSearchUI.this, paramAnonymousList2);
            FavSearchUI.d(FavSearchUI.this, paramAnonymousList);
            FavSearchUI.i(FavSearchUI.this).dt(paramAnonymousList2);
            FavSearchUI.j(FavSearchUI.this).c(paramAnonymousList, paramAnonymousList1, paramAnonymousList2);
            FavSearchUI.b(FavSearchUI.this, false);
            AppMethodBeat.o(106837);
          }
        });
        if (paramAnonymousString != null)
        {
          FavSearchUI.a(FavSearchUI.this, paramAnonymousString);
          FavSearchUI.this.rwm.keN = com.tencent.mm.plugin.fav.ui.f.a.getSearchId();
          FavSearchUI.this.rwm.rEh = System.currentTimeMillis();
        }
        while (FavSearchUI.j(FavSearchUI.this) != null)
        {
          paramAnonymousString = FavSearchUI.j(FavSearchUI.this);
          paramAnonymousList = FavSearchUI.k(FavSearchUI.this);
          if (paramAnonymousList != null)
          {
            paramAnonymousString.query = paramAnonymousList;
            AppMethodBeat.o(106840);
            return;
            FavSearchUI.a(FavSearchUI.this, "");
          }
          else
          {
            paramAnonymousString.query = "";
          }
        }
        AppMethodBeat.o(106840);
      }
      
      public final void a(List<Integer> paramAnonymousList, List<String> paramAnonymousList1, List<String> paramAnonymousList2, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(106839);
        if ((paramAnonymousList1.isEmpty()) && (paramAnonymousList2.isEmpty()) && (FavSearchUI.h(FavSearchUI.this)))
        {
          FavSearchUI.a(FavSearchUI.this, true);
          FavSearchUI.a(FavSearchUI.this, paramAnonymousList1, paramAnonymousList2);
          AppMethodBeat.o(106839);
          return;
        }
        ad.d("MicroMsg.FavSearchUI", "on search, types %s keys %s tags %s", new Object[] { paramAnonymousList, paramAnonymousList1, paramAnonymousList2 });
        FavSearchUI.b(FavSearchUI.this, paramAnonymousList1);
        FavSearchUI.c(FavSearchUI.this, paramAnonymousList2);
        FavSearchUI.d(FavSearchUI.this, paramAnonymousList);
        FavSearchUI.i(FavSearchUI.this).dt(paramAnonymousList2);
        if (paramAnonymousBoolean)
        {
          FavSearchUI.g(FavSearchUI.this);
          FavSearchUI.a(FavSearchUI.this, paramAnonymousList1, paramAnonymousList2);
          AppMethodBeat.o(106839);
          return;
        }
        FavSearchUI.j(FavSearchUI.this).c(paramAnonymousList, paramAnonymousList1, paramAnonymousList2);
        FavSearchUI.b(FavSearchUI.this, true);
        FavSearchUI.a(FavSearchUI.this, paramAnonymousList1, paramAnonymousList2);
        AppMethodBeat.o(106839);
      }
      
      public final void aSn()
      {
        AppMethodBeat.i(106838);
        ad.d("MicroMsg.FavSearchUI", "on enter search, show tag panel");
        if (FavSearchUI.e(FavSearchUI.this))
        {
          AppMethodBeat.o(106838);
          return;
        }
        FavSearchUI.g(FavSearchUI.this);
        AppMethodBeat.o(106838);
      }
    });
    AppMethodBeat.o(106850);
  }
  
  private void fH(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(218787);
    this.rwm.actionType = paramInt1;
    if (this.rvD != null) {
      this.rwm.ooi = this.rvD.ooi;
    }
    switch (this.ixR)
    {
    default: 
      this.rwm.scene = 0;
      this.rwm.rDZ = ((int)(System.currentTimeMillis() - this.nGh) / 1000);
      this.rwm.query = this.query;
      if (this.rwh != null)
      {
        if (this.rwh.size() <= 0) {
          break label437;
        }
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
          this.rwm.rEa = 0;
        }
      }
      break;
    }
    for (;;)
    {
      this.rwm.rEb = ((int)(this.rwm.rEi - this.rwm.rEh));
      this.rwm.rEd = String.format("%d", new Object[] { Integer.valueOf(paramInt2) });
      this.rwm.rEf = (this.rvD.getCount() - 1);
      this.rwm.report();
      AppMethodBeat.o(218787);
      return;
      this.rwm.scene = 1;
      break;
      this.rwm.scene = 2;
      break;
      this.rwm.scene = 3;
      break;
      this.rwm.rEa = 1;
      continue;
      this.rwm.rEa = 2;
      continue;
      this.rwm.rEa = 3;
      continue;
      this.rwm.rEa = 4;
      continue;
      this.rwm.rEa = 5;
      continue;
      this.rwm.rEa = 6;
      continue;
      this.rwm.rEa = 7;
      continue;
      this.rwm.rEa = 8;
      continue;
      label437:
      this.rwm.rEa = 0;
    }
  }
  
  public int getLayoutId()
  {
    return 2131493976;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(106858);
    ad.i("MicroMsg.FavSearchUI", "onActivityResult reqCode: %d, retCod: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(106858);
      return;
    }
    String str = paramIntent.getStringExtra("custom_send_text");
    paramIntent = paramIntent.getStringExtra("Select_Conv_User");
    switch (paramInt1)
    {
    }
    for (;;)
    {
      cwg();
      AppMethodBeat.o(106858);
      return;
      if (paramInt2 != -1)
      {
        AppMethodBeat.o(106858);
        return;
      }
      Object localObject2 = this.rwn.rCr;
      if (bt.isNullOrNil(paramIntent))
      {
        AppMethodBeat.o(106858);
        return;
      }
      Object localObject1 = bt.U(paramIntent.split(","));
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = (com.tencent.mm.plugin.fav.ui.gallery.d)((Iterator)localObject2).next();
        if (localObject3 == null)
        {
          ad.d("MicroMsg.FavSearchUI", "select %s, send item null, continute", new Object[] { paramIntent });
        }
        else
        {
          new com.tencent.mm.plugin.fav.a.k();
          if (com.tencent.mm.plugin.fav.a.k.v(((com.tencent.mm.plugin.fav.ui.gallery.d)localObject3).prW))
          {
            com.tencent.mm.ui.base.h.cl(getContext(), getString(2131755010));
            AppMethodBeat.o(106858);
            return;
          }
          ad.d("MicroMsg.FavSearchUI", "select %s for sending", new Object[] { paramIntent });
          Object localObject4;
          Object localObject5;
          if ((((com.tencent.mm.plugin.fav.ui.gallery.d)localObject3).cxf()) || (((com.tencent.mm.plugin.fav.ui.gallery.d)localObject3).cxh()))
          {
            localObject4 = new FavSearchUI.10(this, com.tencent.mm.ui.base.h.b(getContext(), getString(2131758906), false, null));
            localObject5 = ((List)localObject1).iterator();
            while (((Iterator)localObject5).hasNext()) {
              l.a(this, (String)((Iterator)localObject5).next(), ((com.tencent.mm.plugin.fav.ui.gallery.d)localObject3).dsX, (Runnable)localObject4);
            }
          }
          else
          {
            localObject4 = new ArrayList();
            ((ArrayList)localObject4).add(com.tencent.mm.plugin.fav.a.b.d(((com.tencent.mm.plugin.fav.ui.gallery.d)localObject3).dsX));
            localObject3 = ((List)localObject1).iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject5 = (String)((Iterator)localObject3).next();
              q.aID().a(u.aAm(), (String)localObject5, (ArrayList)localObject4);
            }
          }
        }
      }
      if (!bt.isNullOrNil(str))
      {
        paramIntent = ((List)localObject1).iterator();
        while (paramIntent.hasNext())
        {
          localObject1 = (String)paramIntent.next();
          com.tencent.mm.plugin.messenger.a.g.dlD().aa((String)localObject1, str, com.tencent.mm.model.w.Ar((String)localObject1));
        }
        ad.d("MicroMsg.FavSearchUI", "select %s for sending", new Object[] { paramIntent });
        localObject1 = new ArrayList();
        ((List)localObject1).add(this.rwq);
        p.a(getContext(), (List)localObject1, str, paramIntent, "MicroMsg.FavSearchUI");
        continue;
        ad.d("MicroMsg.FavSearchUI", "select %s for sending", new Object[] { paramIntent });
        p.a(getContext(), this.rvD.lB(false), str, paramIntent, "MicroMsg.FavSearchUI");
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(106846);
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle = TransitionInflater.from(this).inflateTransition(17760258);
      paramBundle.excludeTarget(getWindow().getDecorView().findViewById(2131296345), true);
      paramBundle.excludeTarget(16908335, true);
      getWindow().setEnterTransition(paramBundle);
    }
    this.mHandler = new ap();
    setMMTitle("");
    setActionbarColor(getContext().getResources().getColor(2131100705));
    this.ixR = getIntent().getIntExtra("key_search_type", 0);
    if (1 == this.ixR)
    {
      this.dhU = getIntent().getStringExtra("key_to_user");
      this.rwb = getIntent().getStringExtra("key_fav_item_id");
    }
    this.rwa = getIntent().getIntExtra("key_preset_search_type", -1);
    this.rxs = ((ListView)findViewById(2131305632));
    this.nXJ = ((ListView)findViewById(2131304445));
    this.rwe = findViewById(2131304417);
    this.rwf = AnimationUtils.loadAnimation(getContext(), 2130772089);
    this.rwg = AnimationUtils.loadAnimation(getContext(), 2130772090);
    this.rwn = new com.tencent.mm.plugin.fav.ui.gallery.c(this, findViewById(2131299813));
    cwv();
    this.rxt = ((FavCapacityPanel)View.inflate(getContext(), 2131493939, null));
    this.rxt.rEn = getIntent().getIntExtra("key_enter_fav_search_from", 0);
    this.rxq = new com.tencent.mm.plugin.fav.ui.a.c(getContext())
    {
      public final void agJ(String paramAnonymousString)
      {
        AppMethodBeat.i(106841);
        FavSearchActionView localFavSearchActionView = FavSearchUI.d(FavSearchUI.this);
        localFavSearchActionView.rEM.add(paramAnonymousString);
        if (localFavSearchActionView.ryb == null)
        {
          AppMethodBeat.o(106841);
          return;
        }
        localFavSearchActionView.ryb.setEditHint("");
        localFavSearchActionView.ryb.cN(paramAnonymousString, true);
        if (localFavSearchActionView.rEO == null)
        {
          AppMethodBeat.o(106841);
          return;
        }
        localFavSearchActionView.agR(localFavSearchActionView.ryb.getEditText());
        localFavSearchActionView.rEO.a(localFavSearchActionView.rzv, localFavSearchActionView.rEN, localFavSearchActionView.rEM, false);
        com.tencent.mm.plugin.report.service.g.yhR.f(11126, new Object[] { Integer.valueOf(2) });
        AppMethodBeat.o(106841);
      }
      
      public final void agK(String paramAnonymousString)
      {
        AppMethodBeat.i(106842);
        FavSearchActionView localFavSearchActionView = FavSearchUI.d(FavSearchUI.this);
        localFavSearchActionView.rEM.remove(paramAnonymousString);
        if (localFavSearchActionView.ryb == null)
        {
          AppMethodBeat.o(106842);
          return;
        }
        if (localFavSearchActionView.rEM.isEmpty()) {
          localFavSearchActionView.ryb.setEditHint(localFavSearchActionView.getResources().getString(2131755882));
        }
        localFavSearchActionView.ryb.removeTag(paramAnonymousString);
        if (localFavSearchActionView.rEO == null)
        {
          AppMethodBeat.o(106842);
          return;
        }
        localFavSearchActionView.agR(localFavSearchActionView.ryb.getEditText());
        localFavSearchActionView.rEO.a(localFavSearchActionView.rzv, localFavSearchActionView.rEN, localFavSearchActionView.rEM, true);
        AppMethodBeat.o(106842);
      }
    };
    if (((af)com.tencent.mm.kernel.g.ad(af.class)).getFavTagSetMgr().cva() > 0)
    {
      paramBundle = (TextView)View.inflate(getContext(), 2131493980, null);
      this.rxs.addHeaderView(paramBundle);
    }
    this.rxs.addFooterView(this.rxt);
    this.rxs.setAdapter(this.rxq);
    this.rxs.setOnTouchListener(new FavSearchUI.18(this));
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
        AppMethodBeat.i(106818);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).mr(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).qY(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/FavSearchUI$10", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        localObject = (b.b)paramAnonymousView.getTag();
        if ((localObject != null) && (((b.b)localObject).rtA != null)) {
          FavSearchUI.a(FavSearchUI.this, 2, paramAnonymousInt);
        }
        if (1 == FavSearchUI.a(FavSearchUI.this))
        {
          if (localObject == null)
          {
            ad.w("MicroMsg.FavSearchUI", "on item click, holder is null");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavSearchUI$10", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(106818);
            return;
          }
          if (((b.b)localObject).rtA == null)
          {
            ad.w("MicroMsg.FavSearchUI", "on item click, info is null");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavSearchUI$10", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(106818);
            return;
          }
          ((ab)com.tencent.mm.kernel.g.ab(ab.class)).a(FavSearchUI.this.getContext(), FavSearchUI.l(FavSearchUI.this), ((b.b)localObject).rtA, false, new y.a()
          {
            public final void a(boolean paramAnonymous2Boolean, String paramAnonymous2String, int paramAnonymous2Int)
            {
              AppMethodBeat.i(106816);
              FavSearchUI.this.hideVKB();
              if (paramAnonymous2Boolean)
              {
                final com.tencent.mm.ui.base.p localp = com.tencent.mm.ui.base.h.b(FavSearchUI.this.getContext(), FavSearchUI.this.getString(2131758906), false, null);
                l.a(FavSearchUI.this.getContext(), FavSearchUI.l(FavSearchUI.this), paramAnonymous2String, this.rwv.rtA, new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(106815);
                    if (localp != null) {
                      localp.dismiss();
                    }
                    com.tencent.mm.ui.widget.snackbar.b.n(FavSearchUI.this, FavSearchUI.this.getString(2131758834));
                    aq.o(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(106814);
                        FavSearchUI.this.finish();
                        AppMethodBeat.o(106814);
                      }
                    }, 1800L);
                    AppMethodBeat.o(106815);
                  }
                });
              }
              AppMethodBeat.o(106816);
            }
          });
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavSearchUI$10", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(106818);
          return;
          if (2 == FavSearchUI.a(FavSearchUI.this))
          {
            if (localObject == null)
            {
              ad.w("MicroMsg.FavSearchUI", "on item click, holder is null");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavSearchUI$10", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(106818);
              return;
            }
            if (((b.b)localObject).rtA == null)
            {
              ad.w("MicroMsg.FavSearchUI", "on item click, info is null");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavSearchUI$10", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(106818);
              return;
            }
            paramAnonymousAdapterView = new Intent();
            paramAnonymousAdapterView.putExtra("key_fav_result_local_id", ((b.b)localObject).rtA.field_localId);
            paramAnonymousAdapterView.putExtra("key_fav_result_fake_local_id", ((b.b)localObject).rtA.dsK);
            FavSearchUI.this.setResult(-1, paramAnonymousAdapterView);
            FavSearchUI.this.finish();
          }
          else
          {
            FavSearchUI.j(FavSearchUI.this).onItemClick(paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
            if (((b.b)localObject).rtA != null) {
              com.tencent.mm.kernel.g.ajF().ay(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(106817);
                  ad.d("MicroMsg.FavSearchUI", "type %s", new Object[] { Integer.valueOf(this.rwv.rtA.field_type) });
                  long l = this.rwv.rtA.field_localId;
                  if (FavSearchUI.m(FavSearchUI.this).size() == 0) {
                    FavSearchUI.a(FavSearchUI.this, ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().cvu());
                  }
                  if (FavSearchUI.m(FavSearchUI.this).size() != 0)
                  {
                    localObject = FavSearchUI.m(FavSearchUI.this).iterator();
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
                  int k = FavSearchUI.n(FavSearchUI.this);
                  if (FavSearchUI.m(FavSearchUI.this).size() == 0) {
                    i = paramAnonymousInt;
                  }
                  ((com.tencent.mm.plugin.report.service.g)localObject).f(12746, new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i) });
                  AppMethodBeat.o(106817);
                }
              });
            }
          }
        }
      }
    });
    this.nXJ.setOnItemLongClickListener(this.rws);
    this.nXJ.setOnTouchListener(new FavSearchUI.3(this));
    this.rwr = new com.tencent.mm.plugin.fav.ui.widget.b();
    this.rwr.dY(findViewById(2131299786));
    this.rwr.rEB = new b.a()
    {
      public final void cwa()
      {
        AppMethodBeat.i(106825);
        List localList = FavSearchUI.j(FavSearchUI.this).lB(true);
        if (localList.size() == 0)
        {
          ad.e("MicroMsg.FavSearchUI", "FavEditFooter onDelRequest list == null");
          AppMethodBeat.o(106825);
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
            FavSearchUI.an(FavSearchUI.this.getContext());
            AppMethodBeat.o(106825);
            return;
          }
          FavSearchUI.a(FavSearchUI.this, null, 0, (com.tencent.mm.plugin.fav.a.g)localList.get(0));
          AppMethodBeat.o(106825);
          return;
        }
        com.tencent.mm.ui.base.h.a(FavSearchUI.this.getContext(), FavSearchUI.this.getString(2131758852), "", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(106823);
            p.a(FavSearchUI.this.getContext(), localArrayList, new p.a()
            {
              public final void cwp()
              {
                AppMethodBeat.i(106822);
                if (FavSearchUI.j(FavSearchUI.this) != null)
                {
                  ad.v("MicroMsg.FavSearchUI", "do refresh job");
                  FavSearchUI.j(FavSearchUI.this).cwH();
                  aq.f(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(106821);
                      FavSearchUI.j(FavSearchUI.this).notifyDataSetChanged();
                      AppMethodBeat.o(106821);
                    }
                  });
                }
                AppMethodBeat.o(106822);
              }
            });
            FavSearchUI.e(FavSearchUI.this);
            if (bool) {
              FavSearchUI.an(FavSearchUI.this.getContext());
            }
            AppMethodBeat.o(106823);
          }
        }, null);
        AppMethodBeat.o(106825);
      }
      
      public final void cwn()
      {
        AppMethodBeat.i(106824);
        if (!FavoriteIndexUI.a(FavSearchUI.j(FavSearchUI.this).lB(false), FavSearchUI.this, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(106820);
            p.b(FavSearchUI.this.getContext(), 4105, FavSearchUI.j(FavSearchUI.this), FavSearchUI.o(FavSearchUI.this));
            AppMethodBeat.o(106820);
          }
        }))
        {
          AppMethodBeat.o(106824);
          return;
        }
        p.b(FavSearchUI.this.getContext(), 4105, FavSearchUI.j(FavSearchUI.this), FavSearchUI.o(FavSearchUI.this));
        AppMethodBeat.o(106824);
      }
      
      public final void cwo() {}
    };
    ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavTagSetMgr().a(this.rxq);
    com.tencent.mm.kernel.g.ajF().n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106832);
        FavSearchUI.a(FavSearchUI.this, ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().cvu());
        AppMethodBeat.o(106832);
      }
    }, 1000L);
    this.rwm = new com.tencent.mm.plugin.fav.ui.f.a();
    this.nGh = System.currentTimeMillis();
    this.rwm.keN = com.tencent.mm.plugin.fav.ui.f.a.getSearchId();
    this.rwm.rEh = this.nGh;
    if (cwf())
    {
      this.rxr.ac(this.rwa, false);
      this.nXJ.setVisibility(8);
      this.rxs.setVisibility(8);
      this.rwn.setVisibility(0);
      this.rwn.aUU();
      AppMethodBeat.o(106846);
      return;
    }
    if (this.rwa > 0)
    {
      this.rxr.ac(this.rwa, true);
      this.rwn.setVisibility(8);
      this.nXJ.setVisibility(0);
    }
    AppMethodBeat.o(106846);
  }
  
  @SuppressLint({"ResourceType"})
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(106849);
    ad.d("MicroMsg.FavSearchUI", "on create options menu");
    cwv();
    this.rxw = paramMenu.add(0, 2131302248, 0, 2131755726);
    this.rxw.setActionView(this.rxr);
    this.rxw.setShowAsAction(9);
    this.rxr.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106833);
        FavSearchActionView localFavSearchActionView = FavSearchUI.d(FavSearchUI.this);
        if (localFavSearchActionView.ryb != null) {
          localFavSearchActionView.ryb.fza();
        }
        FavSearchUI.this.showVKB();
        AppMethodBeat.o(106833);
      }
    });
    android.support.v4.view.h.a(this.rxw, new h.a()
    {
      public final boolean fu()
      {
        return true;
      }
      
      public final boolean fv()
      {
        AppMethodBeat.i(106834);
        if (FavSearchUI.e(FavSearchUI.this))
        {
          AppMethodBeat.o(106834);
          return false;
        }
        FavSearchUI.this.finish();
        AppMethodBeat.o(106834);
        return true;
      }
    });
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106835);
        if (FavSearchUI.f(FavSearchUI.this) != null)
        {
          FavSearchUI.f(FavSearchUI.this).expandActionView();
          Toolbar.LayoutParams localLayoutParams = (Toolbar.LayoutParams)FavSearchUI.d(FavSearchUI.this).getLayoutParams();
          if (localLayoutParams != null)
          {
            localLayoutParams.height = -1;
            localLayoutParams.width = -1;
          }
          FavSearchUI.d(FavSearchUI.this).setLayoutParams(localLayoutParams);
        }
        AppMethodBeat.o(106835);
      }
    });
    AppMethodBeat.o(106849);
    return true;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(106848);
    com.tencent.mm.plugin.fav.ui.f.a locala = this.rwm;
    if ((this.rwm.actionType != 1) && (this.rwm.actionType != 9)) {}
    for (boolean bool = true;; bool = false)
    {
      locala.rEj = bool;
      if (!this.rwm.rEj) {
        fH(1, 0);
      }
      this.rwn.onDestroy();
      super.onDestroy();
      this.rvC.destory();
      this.rvC = null;
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavTagSetMgr().a(this.rxq);
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavTagSetMgr().j(this.rwk);
      if (this.rvD != null) {
        this.rvD.finish();
      }
      AppMethodBeat.o(106848);
      return;
    }
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(106847);
    if ((4 == paramInt) && (this.rvD.rzt))
    {
      cwh();
      AppMethodBeat.o(106847);
      return true;
    }
    if ((4 == paramInt) && (cwf()) && (this.rwn.cxc()))
    {
      this.rwn.cxe();
      AppMethodBeat.o(106847);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(106847);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(106856);
    i.agp(getClass().getSimpleName());
    if (cwf()) {
      this.rwn.onPause();
    }
    super.onPause();
    AppMethodBeat.o(106856);
  }
  
  public void onResume()
  {
    long l = 0L;
    AppMethodBeat.i(106855);
    this.rvD.cwH();
    this.rvD.notifyDataSetChanged();
    FavCapacityPanel localFavCapacityPanel = this.rxt;
    if (localFavCapacityPanel.rEl != com.tencent.mm.plugin.fav.a.b.cuD() / 1048576L)
    {
      localFavCapacityPanel.rEl = (com.tencent.mm.plugin.fav.a.b.cuD() / 1048576L);
      TextView localTextView = localFavCapacityPanel.rEm;
      Context localContext = localFavCapacityPanel.rEm.getContext();
      if (localFavCapacityPanel.rEo - localFavCapacityPanel.rEl > 0L) {
        l = localFavCapacityPanel.rEo - localFavCapacityPanel.rEl;
      }
      localTextView.setText(localContext.getString(2131758820, new Object[] { Long.valueOf(l), Long.valueOf(localFavCapacityPanel.rEl) }));
    }
    i.ago(getClass().getSimpleName());
    if (cwf()) {
      this.rwn.onResume();
    }
    super.onResume();
    AppMethodBeat.o(106855);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void vI(long paramLong)
  {
    AppMethodBeat.i(106857);
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
      AppMethodBeat.o(106857);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavSearchUI
 * JD-Core Version:    0.7.0.1
 */