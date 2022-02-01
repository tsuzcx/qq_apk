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
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.fav.a.ab;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.k;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.e.b.b;
import com.tencent.mm.plugin.fav.ui.e.b.c;
import com.tencent.mm.plugin.fav.ui.gallery.c;
import com.tencent.mm.plugin.fav.ui.gallery.d;
import com.tencent.mm.plugin.fav.ui.widget.FavSearchActionView;
import com.tencent.mm.plugin.fav.ui.widget.b.a;
import com.tencent.mm.plugin.messenger.a.e;
import com.tencent.mm.plugin.messenger.a.j;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.protocal.protobuf.agq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.a.f.c;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class FavFilterUI
  extends MMActivity
  implements b.c
{
  private String cZi;
  private int hDV;
  private long mDF;
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
  FavSearchUI.a qdH;
  private c qdI;
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
  private String query;
  
  public FavFilterUI()
  {
    AppMethodBeat.i(106713);
    this.qdv = -1;
    this.qdC = new LinkedList();
    this.qdD = new LinkedList();
    this.qdE = new LinkedList();
    this.qdF = new HashSet();
    this.qdG = new ArrayList();
    this.query = "";
    this.qdJ = new int[2];
    this.qdN = new AdapterView.OnItemLongClickListener()
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
  
  private void Z(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(106721);
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
      AppMethodBeat.o(106721);
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
  
  private boolean ciT()
  {
    return this.qdv == 21;
  }
  
  private boolean ciU()
  {
    AppMethodBeat.i(106719);
    if (this.qcW.qgS)
    {
      ciV();
      AppMethodBeat.o(106719);
      return true;
    }
    if ((ciT()) && (this.qdI.cjJ()))
    {
      this.qdI.cjL();
      AppMethodBeat.o(106719);
      return true;
    }
    AppMethodBeat.o(106719);
    return false;
  }
  
  private void ciV()
  {
    AppMethodBeat.i(106720);
    this.qcW.a(false, null);
    this.mTT.setOnItemLongClickListener(this.qdN);
    this.qdM.hide();
    if (ciT()) {
      this.qdI.cjL();
    }
    AppMethodBeat.o(106720);
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
        ciU();
        AppMethodBeat.o(106725);
        return;
        if (paramInt2 != -1)
        {
          AppMethodBeat.o(106725);
          return;
        }
        Object localObject1 = this.qdI.qjN;
        if (bt.isNullOrNil(str2))
        {
          AppMethodBeat.o(106725);
          return;
        }
        paramIntent = bt.S(str2.split(","));
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (d)((Iterator)localObject1).next();
          if (localObject2 == null)
          {
            ad.d("MicroMsg.FavFilterUI", "select %s, send item null, continute", new Object[] { str2 });
          }
          else
          {
            new k();
            if (k.v(((d)localObject2).okO))
            {
              com.tencent.mm.ui.base.h.cf(getContext(), getString(2131755010));
              AppMethodBeat.o(106725);
              return;
            }
            ad.d("MicroMsg.FavFilterUI", "select %s for sending", new Object[] { str2 });
            Object localObject3;
            Object localObject4;
            if ((((d)localObject2).cjM()) || (((d)localObject2).cjO()))
            {
              localObject3 = new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(106696);
                  this.qcu.dismiss();
                  AppMethodBeat.o(106696);
                }
              };
              localObject4 = paramIntent.iterator();
              while (((Iterator)localObject4).hasNext()) {
                l.a(this, (String)((Iterator)localObject4).next(), ((d)localObject2).dke, (Runnable)localObject3);
              }
            }
            else
            {
              localObject3 = new ArrayList();
              ((ArrayList)localObject3).add(com.tencent.mm.plugin.fav.a.b.d(((d)localObject2).dke));
              localObject2 = paramIntent.iterator();
              while (((Iterator)localObject2).hasNext())
              {
                localObject4 = (String)((Iterator)localObject2).next();
                com.tencent.mm.aw.o.ayD().a(u.aqG(), (String)localObject4, (ArrayList)localObject3);
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
            j.cOB().W(str2, str1, com.tencent.mm.model.w.tq(str2));
          }
          ad.d("MicroMsg.FavFilterUI", "select %s for sending", new Object[] { str2 });
          paramIntent = new ArrayList();
          paramIntent.add(this.qdL);
          p.a(getContext(), paramIntent, str1, str2, "MicroMsg.FavFilterUI");
          continue;
          ad.d("MicroMsg.FavFilterUI", "select %s for sending", new Object[] { str2 });
          p.a(getContext(), this.qcW.kE(false), str1, str2, "MicroMsg.FavFilterUI");
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
    paramInt1 = this.qcW.n(l, paramIntent);
    if (-1 == paramInt1)
    {
      AppMethodBeat.o(106725);
      return;
    }
    this.mTT.setSelection(paramInt1);
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
    this.qdv = getIntent().getIntExtra("key_preset_search_type", -1);
    setMMTitle(FavSearchActionView.P(getContext(), this.qdv));
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
    this.hDV = getIntent().getIntExtra("key_search_type", 0);
    this.qdz = findViewById(2131304417);
    if (1 == this.hDV)
    {
      this.cZi = getIntent().getStringExtra("key_to_user");
      this.qdw = getIntent().getStringExtra("key_fav_item_id");
    }
    this.qdA = AnimationUtils.loadAnimation(getContext(), 2130772089);
    this.qdB = AnimationUtils.loadAnimation(getContext(), 2130772090);
    this.mTT = ((ListView)findViewById(2131304445));
    this.qdI = new c(this, findViewById(2131299813));
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
        AppMethodBeat.i(106703);
        final b.b localb = (b.b)paramAnonymousView.getTag();
        if ((localb != null) && (localb.qaS != null))
        {
          FavFilterUI.this.qdH.qfi = true;
          FavFilterUI.a(FavFilterUI.this, paramAnonymousInt, localb.qaS.field_id);
        }
        if (1 == FavFilterUI.a(FavFilterUI.this))
        {
          if (localb == null)
          {
            ad.w("MicroMsg.FavFilterUI", "on item click, holder is null");
            AppMethodBeat.o(106703);
            return;
          }
          if (localb.qaS == null)
          {
            ad.w("MicroMsg.FavFilterUI", "on item click, info is null");
            AppMethodBeat.o(106703);
            return;
          }
          ((ab)com.tencent.mm.kernel.g.ab(ab.class)).a(FavFilterUI.this.getContext(), FavFilterUI.e(FavFilterUI.this), localb.qaS, false, new y.a()
          {
            public final void a(boolean paramAnonymous2Boolean, String paramAnonymous2String, int paramAnonymous2Int)
            {
              AppMethodBeat.i(106701);
              FavFilterUI.this.hideVKB();
              if (paramAnonymous2Boolean)
              {
                final com.tencent.mm.ui.base.p localp = com.tencent.mm.ui.base.h.b(FavFilterUI.this.getContext(), FavFilterUI.this.getString(2131758906), false, null);
                l.a(FavFilterUI.this.getContext(), FavFilterUI.e(FavFilterUI.this), paramAnonymous2String, localb.qaS, new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(106700);
                    if (localp != null) {
                      localp.dismiss();
                    }
                    com.tencent.mm.ui.widget.snackbar.b.n(FavFilterUI.this, FavFilterUI.this.getString(2131758834));
                    aq.n(new Runnable()
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
          AppMethodBeat.o(106703);
          return;
        }
        if (2 == FavFilterUI.a(FavFilterUI.this))
        {
          if (localb == null)
          {
            ad.w("MicroMsg.FavFilterUI", "on item click, holder is null");
            AppMethodBeat.o(106703);
            return;
          }
          if (localb.qaS == null)
          {
            ad.w("MicroMsg.FavFilterUI", "on item click, info is null");
            AppMethodBeat.o(106703);
            return;
          }
          paramAnonymousAdapterView = new Intent();
          paramAnonymousAdapterView.putExtra("key_fav_result_local_id", localb.qaS.field_localId);
          FavFilterUI.this.setResult(-1, paramAnonymousAdapterView);
          FavFilterUI.this.finish();
          AppMethodBeat.o(106703);
          return;
        }
        FavFilterUI.f(FavFilterUI.this).onItemClick(paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        if (localb.qaS != null) {
          com.tencent.mm.kernel.g.afE().ax(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(106702);
              ad.d("MicroMsg.FavFilterUI", "type %s", new Object[] { Integer.valueOf(localb.qaS.field_type) });
              long l = localb.qaS.field_localId;
              if (FavFilterUI.g(FavFilterUI.this).size() == 0) {
                FavFilterUI.a(FavFilterUI.this, ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().cii());
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
              Object localObject = com.tencent.mm.plugin.report.service.h.vKh;
              int j = localb.qaS.field_type;
              int k = FavFilterUI.h(FavFilterUI.this);
              if (FavFilterUI.g(FavFilterUI.this).size() == 0) {
                i = paramAnonymousInt;
              }
              ((com.tencent.mm.plugin.report.service.h)localObject).f(12746, new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i) });
              AppMethodBeat.o(106702);
            }
          });
        }
        AppMethodBeat.o(106703);
      }
    });
    this.mTT.setOnItemLongClickListener(this.qdN);
    this.mTT.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(106704);
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(106704);
          return false;
          FavFilterUI.this.hideVKB();
          FavFilterUI.c(FavFilterUI.this)[0] = ((int)paramAnonymousMotionEvent.getRawX());
          FavFilterUI.c(FavFilterUI.this)[1] = ((int)paramAnonymousMotionEvent.getRawY());
        }
      }
    });
    this.qdM = new com.tencent.mm.plugin.fav.ui.widget.b();
    this.qdM.dP(findViewById(2131299786));
    this.qdM.qlL = new b.a()
    {
      public final void ciO()
      {
        AppMethodBeat.i(106710);
        List localList = FavFilterUI.f(FavFilterUI.this).kE(true);
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
            FavFilterUI.j(FavFilterUI.this);
            AppMethodBeat.o(106710);
            return;
          }
          FavFilterUI.a(FavFilterUI.this, null, 0, (com.tencent.mm.plugin.fav.a.g)localList.get(0));
          AppMethodBeat.o(106710);
          return;
        }
        com.tencent.mm.ui.base.h.a(FavFilterUI.this.getContext(), FavFilterUI.this.getString(2131758852), "", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(106708);
            p.a(FavFilterUI.this.getContext(), localArrayList, new p.a()
            {
              public final void ciY()
              {
                AppMethodBeat.i(106707);
                if (FavFilterUI.f(FavFilterUI.this) != null)
                {
                  ad.v("MicroMsg.FavFilterUI", "do refresh job");
                  FavFilterUI.f(FavFilterUI.this).cjq();
                  aq.f(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(106706);
                      FavFilterUI.f(FavFilterUI.this).notifyDataSetChanged();
                      AppMethodBeat.o(106706);
                    }
                  });
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
      
      public final void ciW()
      {
        AppMethodBeat.i(106709);
        if (!FavoriteIndexUI.a(FavFilterUI.f(FavFilterUI.this).kE(false), FavFilterUI.this, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(106705);
            p.b(FavFilterUI.this.getContext(), 4105, FavFilterUI.f(FavFilterUI.this), FavFilterUI.i(FavFilterUI.this));
            AppMethodBeat.o(106705);
          }
        }))
        {
          AppMethodBeat.o(106709);
          return;
        }
        p.b(FavFilterUI.this.getContext(), 4105, FavFilterUI.f(FavFilterUI.this), FavFilterUI.i(FavFilterUI.this));
        AppMethodBeat.o(106709);
      }
      
      public final void ciX() {}
    };
    com.tencent.mm.kernel.g.afE().m(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106698);
        FavFilterUI.a(FavFilterUI.this, ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().cii());
        AppMethodBeat.o(106698);
      }
    }, 1000L);
    this.qdH = new FavSearchUI.a();
    this.mDF = System.currentTimeMillis();
    if (ciT())
    {
      this.mTT.setVisibility(8);
      this.qdI.setVisibility(0);
      this.qdI.aKR();
      AppMethodBeat.o(106714);
      return;
    }
    if (this.qdv > 0)
    {
      this.qdC.clear();
      this.qdC.add(Integer.valueOf(this.qdv));
      this.qcW.c(this.qdC, this.qdD, this.qdE);
      this.qcW.notifyDataSetChanged();
      if (8 != this.qdI.frN.getVisibility()) {
        this.qdI.setVisibility(8);
      }
      if (!this.qcW.isEmpty()) {
        break label785;
      }
      if (this.qdz.getVisibility() != 0)
      {
        this.qdz.setVisibility(0);
        this.qdz.startAnimation(this.qdA);
      }
      if (8 != this.mTT.getVisibility())
      {
        this.mTT.setVisibility(8);
        this.mTT.startAnimation(this.qdB);
      }
    }
    for (;;)
    {
      hideVKB();
      this.qdI.setVisibility(8);
      this.mTT.setVisibility(0);
      AppMethodBeat.o(106714);
      return;
      label785:
      if (8 != this.qdz.getVisibility())
      {
        this.qdz.setVisibility(8);
        this.qdz.startAnimation(this.qdB);
      }
      if (this.mTT.getVisibility() != 0)
      {
        this.mTT.setVisibility(0);
        this.mTT.startAnimation(this.qdA);
      }
    }
  }
  
  @SuppressLint({"ResourceType"})
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(106717);
    MenuItem localMenuItem = paramMenu.add(0, 10, 0, 2131764452);
    localMenuItem.setIcon(am.i(getContext(), 2131689494, getContext().getResources().getColor(2131099732)));
    localMenuItem.setShowAsAction(2);
    boolean bool = super.onCreateOptionsMenu(paramMenu);
    AppMethodBeat.o(106717);
    return bool;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(106716);
    if (!this.qdH.qfi)
    {
      if ((!this.qcW.isEmpty()) && (this.mTT.getVisibility() == 0)) {
        break label108;
      }
      Z(1, 0, 0);
    }
    for (;;)
    {
      this.qdI.onDestroy();
      super.onDestroy();
      this.qcV.destory();
      this.qcV = null;
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavTagSetMgr().e(this.qdF);
      if (this.qcW != null) {
        this.qcW.finish();
      }
      AppMethodBeat.o(106716);
      return;
      label108:
      Z(2, 0, 0);
    }
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(106715);
    if ((4 == paramInt) && (this.qcW.qgS))
    {
      ciV();
      AppMethodBeat.o(106715);
      return true;
    }
    if ((4 == paramInt) && (ciT()) && (this.qdI.cjJ()))
    {
      this.qdI.cjL();
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
      paramMenuItem.putExtra("key_preset_search_type", this.qdv);
      p.a(getContext(), this.qcW.qgS, paramMenuItem);
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
    com.tencent.mm.plugin.fav.a.i.Ye(getClass().getSimpleName());
    if (ciT()) {
      this.qdI.onPause();
    }
    super.onPause();
    AppMethodBeat.o(106723);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(106722);
    this.qcW.cjq();
    this.qcW.notifyDataSetChanged();
    com.tencent.mm.plugin.fav.a.i.Yd(getClass().getSimpleName());
    if (ciT()) {
      this.qdI.onResume();
    }
    super.onResume();
    AppMethodBeat.o(106722);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void pW(long paramLong)
  {
    AppMethodBeat.i(106724);
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
      AppMethodBeat.o(106724);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavFilterUI
 * JD-Core Version:    0.7.0.1
 */