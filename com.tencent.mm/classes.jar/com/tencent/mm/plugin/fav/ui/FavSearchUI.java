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
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnTouchListener;
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
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.fav.a.ab;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.k;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.e.b.b;
import com.tencent.mm.plugin.fav.ui.e.b.c;
import com.tencent.mm.plugin.fav.ui.gallery.d;
import com.tencent.mm.plugin.fav.ui.widget.FavCapacityPanel;
import com.tencent.mm.plugin.fav.ui.widget.FavSearchActionView;
import com.tencent.mm.plugin.fav.ui.widget.FavSearchActionView.a;
import com.tencent.mm.plugin.fav.ui.widget.FavTagPanel;
import com.tencent.mm.plugin.fav.ui.widget.b.a;
import com.tencent.mm.plugin.messenger.a.e;
import com.tencent.mm.plugin.messenger.a.j;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.protocal.protobuf.agq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@a(3)
public class FavSearchUI
  extends MMActivity
  implements b.c
{
  private String cZi;
  private int hDV;
  private long mDF;
  private ap mHandler;
  private ListView mTT;
  private o qcV;
  private com.tencent.mm.plugin.fav.ui.a.b qcW;
  private Animation qdA;
  private Animation qdB;
  private List<Integer> qdC;
  private List<String> qdD;
  private List<String> qdE;
  private Set<String> qdF;
  private List<Long> qdG;
  a qdH;
  private com.tencent.mm.plugin.fav.ui.gallery.c qdI;
  private int[] qdJ;
  private com.tencent.mm.plugin.fav.a.g qdK;
  private com.tencent.mm.plugin.fav.a.g qdL;
  private com.tencent.mm.plugin.fav.ui.widget.b qdM;
  private AdapterView.OnItemLongClickListener qdN;
  private int qdv;
  private String qdw;
  private Set<Integer> qdx;
  private com.tencent.mm.plugin.fav.a.w qdy;
  private View qdz;
  private com.tencent.mm.plugin.fav.ui.a.c qeM;
  private FavSearchActionView qeN;
  private ListView qeO;
  private FavCapacityPanel qeP;
  private View qeQ;
  private ImageButton qeR;
  private MenuItem qeS;
  private agq qeT;
  private String query;
  
  public FavSearchUI()
  {
    AppMethodBeat.i(106845);
    this.qdv = -1;
    this.qdF = new HashSet();
    this.qdG = new ArrayList();
    this.query = "";
    this.qdJ = new int[2];
    this.qeT = new agq();
    this.qdN = new AdapterView.OnItemLongClickListener()
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
  
  private void Z(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(106854);
    this.qdH.actionType = paramInt1;
    if (this.qcW != null) {
      this.qdH.niJ = this.qcW.niJ;
    }
    switch (this.hDV)
    {
    default: 
      this.qdH.scene = 0;
      this.qdH.position = paramInt2;
      this.qdH.qfg = ((int)(System.currentTimeMillis() - this.mDF) / 1000);
      this.qdH.query = this.query;
      this.qdH.pZL = paramInt3;
      if (this.qdC != null)
      {
        if (this.qdC.size() <= 0) {
          break label389;
        }
        switch (((Integer)this.qdC.get(0)).intValue())
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
          this.qdH.qfh = 0;
        }
      }
      break;
    }
    for (;;)
    {
      this.qdH.report();
      AppMethodBeat.o(106854);
      return;
      this.qdH.scene = 1;
      break;
      this.qdH.scene = 2;
      break;
      this.qdH.scene = 3;
      break;
      this.qdH.qfh = 1;
      continue;
      this.qdH.qfh = 2;
      continue;
      this.qdH.qfh = 3;
      continue;
      this.qdH.qfh = 4;
      continue;
      this.qdH.qfh = 5;
      continue;
      this.qdH.qfh = 6;
      continue;
      this.qdH.qfh = 7;
      continue;
      this.qdH.qfh = 8;
      continue;
      label389:
      this.qdH.qfh = 0;
    }
  }
  
  public static void aj(Activity paramActivity)
  {
    AppMethodBeat.i(106852);
    f.a locala = new f.a(paramActivity);
    locala.aMo(paramActivity.getString(2131758854));
    locala.aMs(paramActivity.getString(2131758851));
    locala.b(new f.c()
    {
      public final void d(boolean paramAnonymousBoolean, String paramAnonymousString) {}
    });
    locala.show();
    AppMethodBeat.o(106852);
  }
  
  private boolean ciT()
  {
    return this.qdv == 21;
  }
  
  private boolean ciU()
  {
    AppMethodBeat.i(106851);
    if (this.qcW.qgS)
    {
      ciV();
      AppMethodBeat.o(106851);
      return true;
    }
    if ((ciT()) && (this.qdI.cjJ()))
    {
      this.qdI.cjL();
      AppMethodBeat.o(106851);
      return true;
    }
    AppMethodBeat.o(106851);
    return false;
  }
  
  private void ciV()
  {
    AppMethodBeat.i(106853);
    this.qcW.a(false, null);
    this.mTT.setOnItemLongClickListener(this.qdN);
    this.qdM.hide();
    if (ciT()) {
      this.qdI.cjL();
    }
    AppMethodBeat.o(106853);
  }
  
  private void cje()
  {
    AppMethodBeat.i(106850);
    if (this.qeN != null)
    {
      AppMethodBeat.o(106850);
      return;
    }
    this.qeN = ((FavSearchActionView)View.inflate(getContext(), 2131493975, null));
    this.qeQ = this.qeN.findViewById(2131297690);
    this.qeQ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(106836);
        if (FavSearchUI.e(FavSearchUI.this))
        {
          AppMethodBeat.o(106836);
          return;
        }
        FavSearchUI.this.finish();
        AppMethodBeat.o(106836);
      }
    });
    this.qeR = ((ImageButton)this.qeN.findViewById(2131304401));
    this.qeR.setVisibility(8);
    this.qeN.setOnSearchChangedListener(new FavSearchActionView.a()
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
            FavSearchUI.i(FavSearchUI.this).dp(paramAnonymousList2);
            FavSearchUI.j(FavSearchUI.this).c(paramAnonymousList, paramAnonymousList1, paramAnonymousList2);
            FavSearchUI.b(FavSearchUI.this, false);
            AppMethodBeat.o(106837);
          }
        });
        if (paramAnonymousString != null) {
          FavSearchUI.a(FavSearchUI.this, paramAnonymousString);
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
        FavSearchUI.i(FavSearchUI.this).dp(paramAnonymousList2);
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
      
      public final void aIk()
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
      ciU();
      AppMethodBeat.o(106858);
      return;
      if (paramInt2 != -1)
      {
        AppMethodBeat.o(106858);
        return;
      }
      Object localObject2 = this.qdI.qjN;
      if (bt.isNullOrNil(paramIntent))
      {
        AppMethodBeat.o(106858);
        return;
      }
      Object localObject1 = bt.S(paramIntent.split(","));
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = (d)((Iterator)localObject2).next();
        if (localObject3 == null)
        {
          ad.d("MicroMsg.FavSearchUI", "select %s, send item null, continute", new Object[] { paramIntent });
        }
        else
        {
          new k();
          if (k.v(((d)localObject3).okO))
          {
            com.tencent.mm.ui.base.h.cf(getContext(), getString(2131755010));
            AppMethodBeat.o(106858);
            return;
          }
          ad.d("MicroMsg.FavSearchUI", "select %s for sending", new Object[] { paramIntent });
          Object localObject4;
          Object localObject5;
          if ((((d)localObject3).cjM()) || (((d)localObject3).cjO()))
          {
            localObject4 = new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(106831);
                this.qcu.dismiss();
                AppMethodBeat.o(106831);
              }
            };
            localObject5 = ((List)localObject1).iterator();
            while (((Iterator)localObject5).hasNext()) {
              l.a(this, (String)((Iterator)localObject5).next(), ((d)localObject3).dke, (Runnable)localObject4);
            }
          }
          else
          {
            localObject4 = new ArrayList();
            ((ArrayList)localObject4).add(com.tencent.mm.plugin.fav.a.b.d(((d)localObject3).dke));
            localObject3 = ((List)localObject1).iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject5 = (String)((Iterator)localObject3).next();
              com.tencent.mm.aw.o.ayD().a(u.aqG(), (String)localObject5, (ArrayList)localObject4);
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
          j.cOB().W((String)localObject1, str, com.tencent.mm.model.w.tq((String)localObject1));
        }
        ad.d("MicroMsg.FavSearchUI", "select %s for sending", new Object[] { paramIntent });
        localObject1 = new ArrayList();
        ((List)localObject1).add(this.qdL);
        p.a(getContext(), (List)localObject1, str, paramIntent, "MicroMsg.FavSearchUI");
        continue;
        ad.d("MicroMsg.FavSearchUI", "select %s for sending", new Object[] { paramIntent });
        p.a(getContext(), this.qcW.kE(false), str, paramIntent, "MicroMsg.FavSearchUI");
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
    this.hDV = getIntent().getIntExtra("key_search_type", 0);
    if (1 == this.hDV)
    {
      this.cZi = getIntent().getStringExtra("key_to_user");
      this.qdw = getIntent().getStringExtra("key_fav_item_id");
    }
    this.qdv = getIntent().getIntExtra("key_preset_search_type", -1);
    this.qeO = ((ListView)findViewById(2131305632));
    this.mTT = ((ListView)findViewById(2131304445));
    this.qdz = findViewById(2131304417);
    this.qdA = AnimationUtils.loadAnimation(getContext(), 2130772089);
    this.qdB = AnimationUtils.loadAnimation(getContext(), 2130772090);
    this.qdI = new com.tencent.mm.plugin.fav.ui.gallery.c(this, findViewById(2131299813));
    cje();
    this.qeP = ((FavCapacityPanel)View.inflate(getContext(), 2131493939, null));
    this.qeP.qlx = getIntent().getIntExtra("key_enter_fav_search_from", 0);
    this.qeM = new com.tencent.mm.plugin.fav.ui.a.c(getContext())
    {
      public final void Yy(String paramAnonymousString)
      {
        AppMethodBeat.i(106841);
        FavSearchActionView localFavSearchActionView = FavSearchUI.d(FavSearchUI.this);
        localFavSearchActionView.qlW.add(paramAnonymousString);
        if (localFavSearchActionView.qfA == null)
        {
          AppMethodBeat.o(106841);
          return;
        }
        localFavSearchActionView.qfA.setEditHint("");
        localFavSearchActionView.qfA.cC(paramAnonymousString, true);
        if (localFavSearchActionView.qlY == null)
        {
          AppMethodBeat.o(106841);
          return;
        }
        localFavSearchActionView.YG(localFavSearchActionView.qfA.getEditText());
        localFavSearchActionView.qlY.a(localFavSearchActionView.qgU, localFavSearchActionView.qlX, localFavSearchActionView.qlW, false);
        com.tencent.mm.plugin.report.service.h.vKh.f(11126, new Object[] { Integer.valueOf(2) });
        AppMethodBeat.o(106841);
      }
      
      public final void Yz(String paramAnonymousString)
      {
        AppMethodBeat.i(106842);
        FavSearchActionView localFavSearchActionView = FavSearchUI.d(FavSearchUI.this);
        localFavSearchActionView.qlW.remove(paramAnonymousString);
        if (localFavSearchActionView.qfA == null)
        {
          AppMethodBeat.o(106842);
          return;
        }
        if (localFavSearchActionView.qlW.isEmpty()) {
          localFavSearchActionView.qfA.setEditHint(localFavSearchActionView.getResources().getString(2131755882));
        }
        localFavSearchActionView.qfA.removeTag(paramAnonymousString);
        if (localFavSearchActionView.qlY == null)
        {
          AppMethodBeat.o(106842);
          return;
        }
        localFavSearchActionView.YG(localFavSearchActionView.qfA.getEditText());
        localFavSearchActionView.qlY.a(localFavSearchActionView.qgU, localFavSearchActionView.qlX, localFavSearchActionView.qlW, true);
        AppMethodBeat.o(106842);
      }
    };
    if (((af)com.tencent.mm.kernel.g.ad(af.class)).getFavTagSetMgr().chO() > 0)
    {
      paramBundle = (TextView)View.inflate(getContext(), 2131493980, null);
      this.qeO.addHeaderView(paramBundle);
    }
    this.qeO.addFooterView(this.qeP);
    this.qeO.setAdapter(this.qeM);
    this.qeO.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(106843);
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(106843);
          return false;
          FavSearchUI.this.hideVKB();
        }
      }
    });
    this.qcV = new o(getContext(), 16);
    getContext();
    this.qcW = new com.tencent.mm.plugin.fav.ui.a.b(this.qcV, false);
    this.qcW.qgZ = this;
    this.qcW.scene = 2;
    this.qcW.qhc = this.mTT;
    if (1 == this.hDV)
    {
      this.qdx = new HashSet();
      this.qdy = new k();
      if (!bt.isNullOrNil(this.qdw))
      {
        paramBundle = this.qdw.split(",");
        int j = paramBundle.length;
        int i = 0;
        while (i < j)
        {
          int k = bt.getInt(paramBundle[i], 2147483647);
          if (2147483647 != k) {
            this.qdx.add(Integer.valueOf(k));
          }
          i += 1;
        }
      }
      this.qcW.f(this.qdx);
      this.qcW.a(this.qdy);
    }
    this.mTT.setAdapter(this.qcW);
    this.mTT.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, final int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(106818);
        final b.b localb = (b.b)paramAnonymousView.getTag();
        if ((localb != null) && (localb.qaS != null))
        {
          FavSearchUI.this.qdH.qfi = true;
          FavSearchUI.a(FavSearchUI.this, paramAnonymousInt, localb.qaS.field_id);
        }
        if (1 == FavSearchUI.a(FavSearchUI.this))
        {
          if (localb == null)
          {
            ad.w("MicroMsg.FavSearchUI", "on item click, holder is null");
            AppMethodBeat.o(106818);
            return;
          }
          if (localb.qaS == null)
          {
            ad.w("MicroMsg.FavSearchUI", "on item click, info is null");
            AppMethodBeat.o(106818);
            return;
          }
          ((ab)com.tencent.mm.kernel.g.ab(ab.class)).a(FavSearchUI.this.getContext(), FavSearchUI.l(FavSearchUI.this), localb.qaS, false, new y.a()
          {
            public final void a(boolean paramAnonymous2Boolean, String paramAnonymous2String, int paramAnonymous2Int)
            {
              AppMethodBeat.i(106816);
              FavSearchUI.this.hideVKB();
              if (paramAnonymous2Boolean)
              {
                final com.tencent.mm.ui.base.p localp = com.tencent.mm.ui.base.h.b(FavSearchUI.this.getContext(), FavSearchUI.this.getString(2131758906), false, null);
                l.a(FavSearchUI.this.getContext(), FavSearchUI.l(FavSearchUI.this), paramAnonymous2String, localb.qaS, new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(106815);
                    if (localp != null) {
                      localp.dismiss();
                    }
                    com.tencent.mm.ui.widget.snackbar.b.n(FavSearchUI.this, FavSearchUI.this.getString(2131758834));
                    aq.n(new Runnable()
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
          AppMethodBeat.o(106818);
          return;
        }
        if (2 == FavSearchUI.a(FavSearchUI.this))
        {
          if (localb == null)
          {
            ad.w("MicroMsg.FavSearchUI", "on item click, holder is null");
            AppMethodBeat.o(106818);
            return;
          }
          if (localb.qaS == null)
          {
            ad.w("MicroMsg.FavSearchUI", "on item click, info is null");
            AppMethodBeat.o(106818);
            return;
          }
          paramAnonymousAdapterView = new Intent();
          paramAnonymousAdapterView.putExtra("key_fav_result_local_id", localb.qaS.field_localId);
          paramAnonymousAdapterView.putExtra("key_fav_result_fake_local_id", localb.qaS.djR);
          FavSearchUI.this.setResult(-1, paramAnonymousAdapterView);
          FavSearchUI.this.finish();
          AppMethodBeat.o(106818);
          return;
        }
        FavSearchUI.j(FavSearchUI.this).onItemClick(paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        if (localb.qaS != null) {
          com.tencent.mm.kernel.g.afE().ax(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(106817);
              ad.d("MicroMsg.FavSearchUI", "type %s", new Object[] { Integer.valueOf(localb.qaS.field_type) });
              long l = localb.qaS.field_localId;
              if (FavSearchUI.m(FavSearchUI.this).size() == 0) {
                FavSearchUI.a(FavSearchUI.this, ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().cii());
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
              Object localObject = com.tencent.mm.plugin.report.service.h.vKh;
              int j = localb.qaS.field_type;
              int k = FavSearchUI.n(FavSearchUI.this);
              if (FavSearchUI.m(FavSearchUI.this).size() == 0) {
                i = paramAnonymousInt;
              }
              ((com.tencent.mm.plugin.report.service.h)localObject).f(12746, new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i) });
              AppMethodBeat.o(106817);
            }
          });
        }
        AppMethodBeat.o(106818);
      }
    });
    this.mTT.setOnItemLongClickListener(this.qdN);
    this.mTT.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(106819);
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(106819);
          return false;
          FavSearchUI.this.hideVKB();
          FavSearchUI.c(FavSearchUI.this)[0] = ((int)paramAnonymousMotionEvent.getRawX());
          FavSearchUI.c(FavSearchUI.this)[1] = ((int)paramAnonymousMotionEvent.getRawY());
        }
      }
    });
    this.qdM = new com.tencent.mm.plugin.fav.ui.widget.b();
    this.qdM.dP(findViewById(2131299786));
    this.qdM.qlL = new b.a()
    {
      public final void ciO()
      {
        AppMethodBeat.i(106825);
        List localList = FavSearchUI.j(FavSearchUI.this).kE(true);
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
          if (localg.pZE)
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
            FavSearchUI.aj(FavSearchUI.this.getContext());
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
              public final void ciY()
              {
                AppMethodBeat.i(106822);
                if (FavSearchUI.j(FavSearchUI.this) != null)
                {
                  ad.v("MicroMsg.FavSearchUI", "do refresh job");
                  FavSearchUI.j(FavSearchUI.this).cjq();
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
              FavSearchUI.aj(FavSearchUI.this.getContext());
            }
            AppMethodBeat.o(106823);
          }
        }, null);
        AppMethodBeat.o(106825);
      }
      
      public final void ciW()
      {
        AppMethodBeat.i(106824);
        if (!FavoriteIndexUI.a(FavSearchUI.j(FavSearchUI.this).kE(false), FavSearchUI.this, new DialogInterface.OnClickListener()
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
      
      public final void ciX() {}
    };
    ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavTagSetMgr().a(this.qeM);
    com.tencent.mm.kernel.g.afE().m(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106832);
        FavSearchUI.a(FavSearchUI.this, ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().cii());
        AppMethodBeat.o(106832);
      }
    }, 1000L);
    this.qdH = new a();
    this.mDF = System.currentTimeMillis();
    if (ciT())
    {
      this.qeN.ac(this.qdv, false);
      this.mTT.setVisibility(8);
      this.qeO.setVisibility(8);
      this.qdI.setVisibility(0);
      this.qdI.aKR();
      AppMethodBeat.o(106846);
      return;
    }
    if (this.qdv > 0)
    {
      this.qeN.ac(this.qdv, true);
      this.qdI.setVisibility(8);
      this.mTT.setVisibility(0);
    }
    AppMethodBeat.o(106846);
  }
  
  @SuppressLint({"ResourceType"})
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(106849);
    ad.d("MicroMsg.FavSearchUI", "on create options menu");
    cje();
    this.qeS = paramMenu.add(0, 2131302248, 0, 2131755726);
    this.qeS.setActionView(this.qeN);
    this.qeS.setShowAsAction(9);
    this.qeN.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106833);
        FavSearchActionView localFavSearchActionView = FavSearchUI.d(FavSearchUI.this);
        if (localFavSearchActionView.qfA != null) {
          localFavSearchActionView.qfA.eTb();
        }
        FavSearchUI.this.showVKB();
        AppMethodBeat.o(106833);
      }
    });
    android.support.v4.view.h.a(this.qeS, new h.a()
    {
      public final boolean eV()
      {
        return true;
      }
      
      public final boolean eW()
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
    if (!this.qdH.qfi)
    {
      if ((!this.qcW.isEmpty()) && (this.mTT.getVisibility() == 0)) {
        break label129;
      }
      Z(1, 0, 0);
    }
    for (;;)
    {
      this.qdI.onDestroy();
      super.onDestroy();
      this.qcV.destory();
      this.qcV = null;
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavTagSetMgr().a(this.qeM);
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavTagSetMgr().e(this.qdF);
      if (this.qcW != null) {
        this.qcW.finish();
      }
      AppMethodBeat.o(106848);
      return;
      label129:
      Z(2, 0, 0);
    }
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(106847);
    if ((4 == paramInt) && (this.qcW.qgS))
    {
      ciV();
      AppMethodBeat.o(106847);
      return true;
    }
    if ((4 == paramInt) && (ciT()) && (this.qdI.cjJ()))
    {
      this.qdI.cjL();
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
    com.tencent.mm.plugin.fav.a.i.Ye(getClass().getSimpleName());
    if (ciT()) {
      this.qdI.onPause();
    }
    super.onPause();
    AppMethodBeat.o(106856);
  }
  
  public void onResume()
  {
    long l = 0L;
    AppMethodBeat.i(106855);
    this.qcW.cjq();
    this.qcW.notifyDataSetChanged();
    FavCapacityPanel localFavCapacityPanel = this.qeP;
    if (localFavCapacityPanel.qlv != com.tencent.mm.plugin.fav.a.b.chr() / 1048576L)
    {
      localFavCapacityPanel.qlv = (com.tencent.mm.plugin.fav.a.b.chr() / 1048576L);
      TextView localTextView = localFavCapacityPanel.qlw;
      Context localContext = localFavCapacityPanel.qlw.getContext();
      if (localFavCapacityPanel.qly - localFavCapacityPanel.qlv > 0L) {
        l = localFavCapacityPanel.qly - localFavCapacityPanel.qlv;
      }
      localTextView.setText(localContext.getString(2131758820, new Object[] { Long.valueOf(l), Long.valueOf(localFavCapacityPanel.qlv) }));
    }
    com.tencent.mm.plugin.fav.a.i.Yd(getClass().getSimpleName());
    if (ciT()) {
      this.qdI.onResume();
    }
    super.onResume();
    AppMethodBeat.o(106855);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void pW(long paramLong)
  {
    AppMethodBeat.i(106857);
    com.tencent.mm.plugin.fav.ui.widget.b localb;
    if (this.qcW.qgS)
    {
      localb = this.qdM;
      if (this.qcW.cjt() <= 0) {
        break label47;
      }
    }
    label47:
    for (boolean bool = true;; bool = false)
    {
      localb.kJ(bool);
      AppMethodBeat.o(106857);
      return;
    }
  }
  
  static final class a
  {
    int actionType;
    int niJ;
    long pZL;
    int position;
    int qfg;
    int qfh;
    boolean qfi = false;
    String query;
    int scene;
    
    public final void report()
    {
      AppMethodBeat.i(106844);
      com.tencent.mm.plugin.report.service.h.vKh.f(15488, new Object[] { Integer.valueOf(this.actionType), Integer.valueOf(this.niJ), Integer.valueOf(this.scene), Integer.valueOf(this.position), Integer.valueOf(this.qfg), this.query, Long.valueOf(this.pZL), Integer.valueOf(this.qfh) });
      AppMethodBeat.o(106844);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavSearchUI
 * JD-Core Version:    0.7.0.1
 */