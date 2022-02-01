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
import com.tencent.mm.av.q;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.fav.a.ab;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.i;
import com.tencent.mm.plugin.fav.a.w;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.e.b.b;
import com.tencent.mm.plugin.fav.ui.e.b.c;
import com.tencent.mm.plugin.fav.ui.widget.FavCapacityPanel;
import com.tencent.mm.plugin.fav.ui.widget.FavSearchActionView;
import com.tencent.mm.plugin.fav.ui.widget.FavSearchActionView.a;
import com.tencent.mm.plugin.fav.ui.widget.FavTagPanel;
import com.tencent.mm.plugin.fav.ui.widget.b.a;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.protocal.protobuf.akp;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
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
  private String diX;
  private int iAK;
  private aq mHandler;
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
  private com.tencent.mm.plugin.fav.ui.gallery.c rEz;
  private com.tencent.mm.plugin.fav.ui.a.c rFB;
  private FavSearchActionView rFC;
  private ListView rFD;
  private FavCapacityPanel rFE;
  private View rFF;
  private ImageButton rFG;
  private MenuItem rFH;
  private akp rFI;
  
  public FavSearchUI()
  {
    AppMethodBeat.i(106845);
    this.rEm = -1;
    this.rEw = new HashSet();
    this.rEx = new ArrayList();
    this.query = "";
    this.rEA = new int[2];
    this.rFI = new akp();
    this.rEE = new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(106813);
        if (FavSearchUI.a(FavSearchUI.this) == 2)
        {
          ae.w("MicroMsg.FavSearchUI", "on edit mode long click, ignore");
          AppMethodBeat.o(106813);
          return true;
        }
        if (paramAnonymousInt < FavSearchUI.b(FavSearchUI.this).getHeaderViewsCount())
        {
          ae.w("MicroMsg.FavSearchUI", "on header view long click, ignore");
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
  
  public static void ao(Activity paramActivity)
  {
    AppMethodBeat.i(106852);
    f.a locala = new f.a(paramActivity);
    locala.aZq(paramActivity.getString(2131758854));
    locala.aZu(paramActivity.getString(2131758851));
    locala.b(new f.c()
    {
      public final void d(boolean paramAnonymousBoolean, String paramAnonymousString) {}
    });
    locala.show();
    AppMethodBeat.o(106852);
  }
  
  private boolean cxG()
  {
    return this.rEm == 21;
  }
  
  private boolean cxH()
  {
    AppMethodBeat.i(106851);
    if (this.rDP.rHE)
    {
      cxI();
      AppMethodBeat.o(106851);
      return true;
    }
    if ((cxG()) && (this.rEz.cyD()))
    {
      this.rEz.cyF();
      AppMethodBeat.o(106851);
      return true;
    }
    AppMethodBeat.o(106851);
    return false;
  }
  
  private void cxI()
  {
    AppMethodBeat.i(106853);
    this.rDP.a(false, null);
    this.ods.setOnItemLongClickListener(this.rEE);
    this.rED.hide();
    if (cxG()) {
      this.rEz.cyF();
    }
    AppMethodBeat.o(106853);
  }
  
  private void cxW()
  {
    AppMethodBeat.i(106850);
    if (this.rFC != null)
    {
      AppMethodBeat.o(106850);
      return;
    }
    this.rFC = ((FavSearchActionView)View.inflate(getContext(), 2131493975, null));
    this.rFF = this.rFC.findViewById(2131297690);
    this.rFF.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(106836);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/FavSearchUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
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
    this.rFG = ((ImageButton)this.rFC.findViewById(2131304401));
    this.rFG.setVisibility(8);
    this.rFC.setOnSearchChangedListener(new FavSearchActionView.a()
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
            ae.d("MicroMsg.FavSearchUI", "on text changed, types %s keys %s tags %s", new Object[] { paramAnonymousList, paramAnonymousList1, paramAnonymousList2 });
            FavSearchUI.b(FavSearchUI.this, paramAnonymousList1);
            FavSearchUI.c(FavSearchUI.this, paramAnonymousList2);
            FavSearchUI.d(FavSearchUI.this, paramAnonymousList);
            FavSearchUI.i(FavSearchUI.this).dw(paramAnonymousList2);
            FavSearchUI.j(FavSearchUI.this).c(paramAnonymousList, paramAnonymousList1, paramAnonymousList2);
            FavSearchUI.b(FavSearchUI.this, false);
            AppMethodBeat.o(106837);
          }
        });
        if (paramAnonymousString != null)
        {
          FavSearchUI.a(FavSearchUI.this, paramAnonymousString);
          FavSearchUI.this.rEy.kid = com.tencent.mm.plugin.fav.ui.f.a.getSearchId();
          FavSearchUI.this.rEy.rMs = System.currentTimeMillis();
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
        ae.d("MicroMsg.FavSearchUI", "on search, types %s keys %s tags %s", new Object[] { paramAnonymousList, paramAnonymousList1, paramAnonymousList2 });
        FavSearchUI.b(FavSearchUI.this, paramAnonymousList1);
        FavSearchUI.c(FavSearchUI.this, paramAnonymousList2);
        FavSearchUI.d(FavSearchUI.this, paramAnonymousList);
        FavSearchUI.i(FavSearchUI.this).dw(paramAnonymousList2);
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
      
      public final void aSM()
      {
        AppMethodBeat.i(106838);
        ae.d("MicroMsg.FavSearchUI", "on enter search, show tag panel");
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
  
  private void fF(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(191062);
    this.rEy.actionType = paramInt1;
    if (this.rDP != null) {
      this.rEy.otZ = this.rDP.otZ;
    }
    switch (this.iAK)
    {
    default: 
      this.rEy.scene = 0;
      this.rEy.rMk = ((int)(System.currentTimeMillis() - this.nLI) / 1000);
      this.rEy.query = this.query;
      if (this.rEt != null)
      {
        if (this.rEt.size() <= 0) {
          break label437;
        }
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
          this.rEy.rMl = 0;
        }
      }
      break;
    }
    for (;;)
    {
      this.rEy.rMm = ((int)(this.rEy.rMt - this.rEy.rMs));
      this.rEy.rMo = String.format("%d", new Object[] { Integer.valueOf(paramInt2) });
      this.rEy.rMq = (this.rDP.getCount() - 1);
      this.rEy.report();
      AppMethodBeat.o(191062);
      return;
      this.rEy.scene = 1;
      break;
      this.rEy.scene = 2;
      break;
      this.rEy.scene = 3;
      break;
      this.rEy.rMl = 1;
      continue;
      this.rEy.rMl = 2;
      continue;
      this.rEy.rMl = 3;
      continue;
      this.rEy.rMl = 4;
      continue;
      this.rEy.rMl = 5;
      continue;
      this.rEy.rMl = 6;
      continue;
      this.rEy.rMl = 7;
      continue;
      this.rEy.rMl = 8;
      continue;
      label437:
      this.rEy.rMl = 0;
    }
  }
  
  public int getLayoutId()
  {
    return 2131493976;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(106858);
    ae.i("MicroMsg.FavSearchUI", "onActivityResult reqCode: %d, retCod: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
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
      cxH();
      AppMethodBeat.o(106858);
      return;
      if (paramInt2 != -1)
      {
        AppMethodBeat.o(106858);
        return;
      }
      Object localObject2 = this.rEz.rKC;
      if (bu.isNullOrNil(paramIntent))
      {
        AppMethodBeat.o(106858);
        return;
      }
      Object localObject1 = bu.U(paramIntent.split(","));
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = (com.tencent.mm.plugin.fav.ui.gallery.d)((Iterator)localObject2).next();
        if (localObject3 == null)
        {
          ae.d("MicroMsg.FavSearchUI", "select %s, send item null, continute", new Object[] { paramIntent });
        }
        else
        {
          new com.tencent.mm.plugin.fav.a.k();
          if (com.tencent.mm.plugin.fav.a.k.v(((com.tencent.mm.plugin.fav.ui.gallery.d)localObject3).pyC))
          {
            com.tencent.mm.ui.base.h.cm(getContext(), getString(2131755010));
            AppMethodBeat.o(106858);
            return;
          }
          ae.d("MicroMsg.FavSearchUI", "select %s for sending", new Object[] { paramIntent });
          Object localObject4;
          Object localObject5;
          if ((((com.tencent.mm.plugin.fav.ui.gallery.d)localObject3).cyG()) || (((com.tencent.mm.plugin.fav.ui.gallery.d)localObject3).cyI()))
          {
            localObject4 = new FavSearchUI.10(this, com.tencent.mm.ui.base.h.b(getContext(), getString(2131758906), false, null));
            localObject5 = ((List)localObject1).iterator();
            while (((Iterator)localObject5).hasNext()) {
              l.a(this, (String)((Iterator)localObject5).next(), ((com.tencent.mm.plugin.fav.ui.gallery.d)localObject3).dud, (Runnable)localObject4);
            }
          }
          else
          {
            localObject4 = new ArrayList();
            ((ArrayList)localObject4).add(com.tencent.mm.plugin.fav.a.b.d(((com.tencent.mm.plugin.fav.ui.gallery.d)localObject3).dud));
            localObject3 = ((List)localObject1).iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject5 = (String)((Iterator)localObject3).next();
              q.aIV().a(v.aAC(), (String)localObject5, (ArrayList)localObject4);
            }
          }
        }
      }
      if (!bu.isNullOrNil(str))
      {
        paramIntent = ((List)localObject1).iterator();
        while (paramIntent.hasNext())
        {
          localObject1 = (String)paramIntent.next();
          com.tencent.mm.plugin.messenger.a.g.doC().aa((String)localObject1, str, com.tencent.mm.model.x.Bb((String)localObject1));
        }
        ae.d("MicroMsg.FavSearchUI", "select %s for sending", new Object[] { paramIntent });
        localObject1 = new ArrayList();
        ((List)localObject1).add(this.rEC);
        p.a(getContext(), (List)localObject1, str, paramIntent, "MicroMsg.FavSearchUI");
        continue;
        ae.d("MicroMsg.FavSearchUI", "select %s for sending", new Object[] { paramIntent });
        p.a(getContext(), this.rDP.lB(false), str, paramIntent, "MicroMsg.FavSearchUI");
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
    this.mHandler = new aq();
    setMMTitle("");
    setActionbarColor(getContext().getResources().getColor(2131100705));
    this.iAK = getIntent().getIntExtra("key_search_type", 0);
    if (1 == this.iAK)
    {
      this.diX = getIntent().getStringExtra("key_to_user");
      this.rEn = getIntent().getStringExtra("key_fav_item_id");
    }
    this.rEm = getIntent().getIntExtra("key_preset_search_type", -1);
    this.rFD = ((ListView)findViewById(2131305632));
    this.ods = ((ListView)findViewById(2131304445));
    this.rEq = findViewById(2131304417);
    this.rEr = AnimationUtils.loadAnimation(getContext(), 2130772089);
    this.rEs = AnimationUtils.loadAnimation(getContext(), 2130772090);
    this.rEz = new com.tencent.mm.plugin.fav.ui.gallery.c(this, findViewById(2131299813));
    cxW();
    this.rFE = ((FavCapacityPanel)View.inflate(getContext(), 2131493939, null));
    this.rFE.rMy = getIntent().getIntExtra("key_enter_fav_search_from", 0);
    this.rFB = new com.tencent.mm.plugin.fav.ui.a.c(getContext())
    {
      public final void ahG(String paramAnonymousString)
      {
        AppMethodBeat.i(106841);
        FavSearchActionView localFavSearchActionView = FavSearchUI.d(FavSearchUI.this);
        localFavSearchActionView.rMX.add(paramAnonymousString);
        if (localFavSearchActionView.rGm == null)
        {
          AppMethodBeat.o(106841);
          return;
        }
        localFavSearchActionView.rGm.setEditHint("");
        localFavSearchActionView.rGm.cR(paramAnonymousString, true);
        if (localFavSearchActionView.rMZ == null)
        {
          AppMethodBeat.o(106841);
          return;
        }
        localFavSearchActionView.ahO(localFavSearchActionView.rGm.getEditText());
        localFavSearchActionView.rMZ.a(localFavSearchActionView.rHG, localFavSearchActionView.rMY, localFavSearchActionView.rMX, false);
        com.tencent.mm.plugin.report.service.g.yxI.f(11126, new Object[] { Integer.valueOf(2) });
        AppMethodBeat.o(106841);
      }
      
      public final void ahH(String paramAnonymousString)
      {
        AppMethodBeat.i(106842);
        FavSearchActionView localFavSearchActionView = FavSearchUI.d(FavSearchUI.this);
        localFavSearchActionView.rMX.remove(paramAnonymousString);
        if (localFavSearchActionView.rGm == null)
        {
          AppMethodBeat.o(106842);
          return;
        }
        if (localFavSearchActionView.rMX.isEmpty()) {
          localFavSearchActionView.rGm.setEditHint(localFavSearchActionView.getResources().getString(2131755882));
        }
        localFavSearchActionView.rGm.removeTag(paramAnonymousString);
        if (localFavSearchActionView.rMZ == null)
        {
          AppMethodBeat.o(106842);
          return;
        }
        localFavSearchActionView.ahO(localFavSearchActionView.rGm.getEditText());
        localFavSearchActionView.rMZ.a(localFavSearchActionView.rHG, localFavSearchActionView.rMY, localFavSearchActionView.rMX, true);
        AppMethodBeat.o(106842);
      }
    };
    if (((af)com.tencent.mm.kernel.g.ad(af.class)).getFavTagSetMgr().cwB() > 0)
    {
      paramBundle = (TextView)View.inflate(getContext(), 2131493980, null);
      this.rFD.addHeaderView(paramBundle);
    }
    this.rFD.addFooterView(this.rFE);
    this.rFD.setAdapter(this.rFB);
    this.rFD.setOnTouchListener(new FavSearchUI.18(this));
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
        AppMethodBeat.i(106818);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).mu(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).rl(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/FavSearchUI$10", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        localObject = (b.b)paramAnonymousView.getTag();
        if ((localObject != null) && (((b.b)localObject).rBM != null)) {
          FavSearchUI.a(FavSearchUI.this, 2, paramAnonymousInt);
        }
        if (1 == FavSearchUI.a(FavSearchUI.this))
        {
          if (localObject == null)
          {
            ae.w("MicroMsg.FavSearchUI", "on item click, holder is null");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavSearchUI$10", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(106818);
            return;
          }
          if (((b.b)localObject).rBM == null)
          {
            ae.w("MicroMsg.FavSearchUI", "on item click, info is null");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavSearchUI$10", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(106818);
            return;
          }
          ((ab)com.tencent.mm.kernel.g.ab(ab.class)).a(FavSearchUI.this.getContext(), FavSearchUI.l(FavSearchUI.this), ((b.b)localObject).rBM, false, new y.a()
          {
            public final void a(boolean paramAnonymous2Boolean, String paramAnonymous2String, int paramAnonymous2Int)
            {
              AppMethodBeat.i(106816);
              FavSearchUI.this.hideVKB();
              if (paramAnonymous2Boolean)
              {
                final com.tencent.mm.ui.base.p localp = com.tencent.mm.ui.base.h.b(FavSearchUI.this.getContext(), FavSearchUI.this.getString(2131758906), false, null);
                l.a(FavSearchUI.this.getContext(), FavSearchUI.l(FavSearchUI.this), paramAnonymous2String, this.rEH.rBM, new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(106815);
                    if (localp != null) {
                      localp.dismiss();
                    }
                    com.tencent.mm.ui.widget.snackbar.b.n(FavSearchUI.this, FavSearchUI.this.getString(2131758834));
                    ar.o(new Runnable()
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
              ae.w("MicroMsg.FavSearchUI", "on item click, holder is null");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavSearchUI$10", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(106818);
              return;
            }
            if (((b.b)localObject).rBM == null)
            {
              ae.w("MicroMsg.FavSearchUI", "on item click, info is null");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavSearchUI$10", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(106818);
              return;
            }
            paramAnonymousAdapterView = new Intent();
            paramAnonymousAdapterView.putExtra("key_fav_result_local_id", ((b.b)localObject).rBM.field_localId);
            paramAnonymousAdapterView.putExtra("key_fav_result_fake_local_id", ((b.b)localObject).rBM.dtQ);
            FavSearchUI.this.setResult(-1, paramAnonymousAdapterView);
            FavSearchUI.this.finish();
          }
          else
          {
            FavSearchUI.j(FavSearchUI.this).onItemClick(paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
            if (((b.b)localObject).rBM != null) {
              com.tencent.mm.kernel.g.ajU().aw(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(106817);
                  ae.d("MicroMsg.FavSearchUI", "type %s", new Object[] { Integer.valueOf(this.rEH.rBM.field_type) });
                  long l = this.rEH.rBM.field_localId;
                  if (FavSearchUI.m(FavSearchUI.this).size() == 0) {
                    FavSearchUI.a(FavSearchUI.this, ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().cwV());
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
                  Object localObject = com.tencent.mm.plugin.report.service.g.yxI;
                  int j = this.rEH.rBM.field_type;
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
    this.ods.setOnItemLongClickListener(this.rEE);
    this.ods.setOnTouchListener(new FavSearchUI.3(this));
    this.rED = new com.tencent.mm.plugin.fav.ui.widget.b();
    this.rED.dY(findViewById(2131299786));
    this.rED.rMM = new b.a()
    {
      public final void cxB()
      {
        AppMethodBeat.i(106825);
        List localList = FavSearchUI.j(FavSearchUI.this).lB(true);
        if (localList.size() == 0)
        {
          ae.e("MicroMsg.FavSearchUI", "FavEditFooter onDelRequest list == null");
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
            FavSearchUI.ao(FavSearchUI.this.getContext());
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
              public final void cxQ()
              {
                AppMethodBeat.i(106822);
                if (FavSearchUI.j(FavSearchUI.this) != null)
                {
                  ae.v("MicroMsg.FavSearchUI", "do refresh job");
                  FavSearchUI.j(FavSearchUI.this).cyi();
                  ar.f(new Runnable()
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
              FavSearchUI.ao(FavSearchUI.this.getContext());
            }
            AppMethodBeat.o(106823);
          }
        }, null);
        AppMethodBeat.o(106825);
      }
      
      public final void cxO()
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
      
      public final void cxP() {}
    };
    ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavTagSetMgr().a(this.rFB);
    com.tencent.mm.kernel.g.ajU().n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106832);
        FavSearchUI.a(FavSearchUI.this, ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().cwV());
        AppMethodBeat.o(106832);
      }
    }, 1000L);
    this.rEy = new com.tencent.mm.plugin.fav.ui.f.a();
    this.nLI = System.currentTimeMillis();
    this.rEy.kid = com.tencent.mm.plugin.fav.ui.f.a.getSearchId();
    this.rEy.rMs = this.nLI;
    if (cxG())
    {
      this.rFC.ae(this.rEm, false);
      this.ods.setVisibility(8);
      this.rFD.setVisibility(8);
      this.rEz.setVisibility(0);
      this.rEz.aVt();
      AppMethodBeat.o(106846);
      return;
    }
    if (this.rEm > 0)
    {
      this.rFC.ae(this.rEm, true);
      this.rEz.setVisibility(8);
      this.ods.setVisibility(0);
    }
    AppMethodBeat.o(106846);
  }
  
  @SuppressLint({"ResourceType"})
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(106849);
    ae.d("MicroMsg.FavSearchUI", "on create options menu");
    cxW();
    this.rFH = paramMenu.add(0, 2131302248, 0, 2131755726);
    this.rFH.setActionView(this.rFC);
    this.rFH.setShowAsAction(9);
    this.rFC.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106833);
        FavSearchActionView localFavSearchActionView = FavSearchUI.d(FavSearchUI.this);
        if (localFavSearchActionView.rGm != null) {
          localFavSearchActionView.rGm.fDc();
        }
        FavSearchUI.this.showVKB();
        AppMethodBeat.o(106833);
      }
    });
    android.support.v4.view.h.a(this.rFH, new h.a()
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
    com.tencent.mm.plugin.fav.ui.f.a locala = this.rEy;
    if ((this.rEy.actionType != 1) && (this.rEy.actionType != 9)) {}
    for (boolean bool = true;; bool = false)
    {
      locala.rMu = bool;
      if (!this.rEy.rMu) {
        fF(1, 0);
      }
      this.rEz.onDestroy();
      super.onDestroy();
      this.rDO.destory();
      this.rDO = null;
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavTagSetMgr().a(this.rFB);
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavTagSetMgr().j(this.rEw);
      if (this.rDP != null) {
        this.rDP.finish();
      }
      AppMethodBeat.o(106848);
      return;
    }
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(106847);
    if ((4 == paramInt) && (this.rDP.rHE))
    {
      cxI();
      AppMethodBeat.o(106847);
      return true;
    }
    if ((4 == paramInt) && (cxG()) && (this.rEz.cyD()))
    {
      this.rEz.cyF();
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
    i.ahm(getClass().getSimpleName());
    if (cxG()) {
      this.rEz.onPause();
    }
    super.onPause();
    AppMethodBeat.o(106856);
  }
  
  public void onResume()
  {
    long l = 0L;
    AppMethodBeat.i(106855);
    this.rDP.cyi();
    this.rDP.notifyDataSetChanged();
    FavCapacityPanel localFavCapacityPanel = this.rFE;
    if (localFavCapacityPanel.rMw != com.tencent.mm.plugin.fav.a.b.cwe() / 1048576L)
    {
      localFavCapacityPanel.rMw = (com.tencent.mm.plugin.fav.a.b.cwe() / 1048576L);
      TextView localTextView = localFavCapacityPanel.rMx;
      Context localContext = localFavCapacityPanel.rMx.getContext();
      if (localFavCapacityPanel.rMz - localFavCapacityPanel.rMw > 0L) {
        l = localFavCapacityPanel.rMz - localFavCapacityPanel.rMw;
      }
      localTextView.setText(localContext.getString(2131758820, new Object[] { Long.valueOf(l), Long.valueOf(localFavCapacityPanel.rMw) }));
    }
    i.ahl(getClass().getSimpleName());
    if (cxG()) {
      this.rEz.onResume();
    }
    super.onResume();
    AppMethodBeat.o(106855);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void vY(long paramLong)
  {
    AppMethodBeat.i(106857);
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
      AppMethodBeat.o(106857);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavSearchUI
 * JD-Core Version:    0.7.0.1
 */