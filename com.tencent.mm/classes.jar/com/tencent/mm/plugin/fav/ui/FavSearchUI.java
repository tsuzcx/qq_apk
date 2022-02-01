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
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
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
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.i;
import com.tencent.mm.plugin.fav.a.w;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.d.b.b;
import com.tencent.mm.plugin.fav.ui.d.b.c;
import com.tencent.mm.plugin.fav.ui.widget.FavCapacityPanel;
import com.tencent.mm.plugin.fav.ui.widget.FavSearchActionView;
import com.tencent.mm.plugin.fav.ui.widget.FavSearchActionView.a;
import com.tencent.mm.plugin.fav.ui.widget.FavTagPanel;
import com.tencent.mm.plugin.fav.ui.widget.b.a;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.protocal.protobuf.and;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o.g;
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
  private String dAi;
  private long iOB;
  private int jvZ;
  private MMHandler mHandler;
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
  private com.tencent.mm.plugin.fav.ui.gallery.c tee;
  private int[] tef;
  private com.tencent.mm.plugin.fav.a.g teg;
  private com.tencent.mm.plugin.fav.a.g teh;
  private com.tencent.mm.plugin.fav.ui.widget.b tei;
  private AdapterView.OnItemLongClickListener tej;
  private com.tencent.mm.plugin.fav.ui.a.c tfh;
  private FavSearchActionView tfi;
  private ListView tfj;
  private FavCapacityPanel tfk;
  private View tfl;
  private ImageButton tfm;
  private MenuItem tfn;
  private and tfo;
  
  public FavSearchUI()
  {
    AppMethodBeat.i(106845);
    this.tdR = -1;
    this.teb = new HashSet();
    this.tec = new ArrayList();
    this.query = "";
    this.tef = new int[2];
    this.tfo = new and();
    this.tej = new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(106813);
        if (FavSearchUI.a(FavSearchUI.this) == 2)
        {
          Log.w("MicroMsg.FavSearchUI", "on edit mode long click, ignore");
          AppMethodBeat.o(106813);
          return true;
        }
        if (paramAnonymousInt < FavSearchUI.b(FavSearchUI.this).getHeaderViewsCount())
        {
          Log.w("MicroMsg.FavSearchUI", "on header view long click, ignore");
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
  
  public static void ak(Activity paramActivity)
  {
    AppMethodBeat.i(106852);
    f.a locala = new f.a(paramActivity);
    locala.bow(paramActivity.getString(2131759177));
    locala.boA(paramActivity.getString(2131759174));
    locala.b(new FavSearchUI.5());
    locala.show();
    AppMethodBeat.o(106852);
  }
  
  private boolean cVK()
  {
    return this.tdR == 21;
  }
  
  private boolean cVL()
  {
    AppMethodBeat.i(106851);
    if (this.tdu.thl)
    {
      cVM();
      AppMethodBeat.o(106851);
      return true;
    }
    if ((cVK()) && (this.tee.cWG()))
    {
      this.tee.cWI();
      AppMethodBeat.o(106851);
      return true;
    }
    AppMethodBeat.o(106851);
    return false;
  }
  
  private void cVM()
  {
    AppMethodBeat.i(106853);
    this.tdu.a(false, null);
    this.pop.setOnItemLongClickListener(this.tej);
    this.tei.hide();
    if (cVK()) {
      this.tee.cWI();
    }
    AppMethodBeat.o(106853);
  }
  
  private void cWa()
  {
    AppMethodBeat.i(106850);
    if (this.tfi != null)
    {
      AppMethodBeat.o(106850);
      return;
    }
    this.tfi = ((FavSearchActionView)View.inflate(getContext(), 2131494145, null));
    this.tfl = this.tfi.findViewById(2131297963);
    this.tfl.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(106836);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/FavSearchUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
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
    this.tfm = ((ImageButton)this.tfi.findViewById(2131307366));
    this.tfm.setVisibility(8);
    this.tfi.setOnSearchChangedListener(new FavSearchActionView.a()
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
            Log.d("MicroMsg.FavSearchUI", "on text changed, types %s keys %s tags %s", new Object[] { paramAnonymousList, paramAnonymousList1, paramAnonymousList2 });
            FavSearchUI.b(FavSearchUI.this, paramAnonymousList1);
            FavSearchUI.c(FavSearchUI.this, paramAnonymousList2);
            FavSearchUI.d(FavSearchUI.this, paramAnonymousList);
            FavSearchUI.i(FavSearchUI.this).dK(paramAnonymousList2);
            FavSearchUI.j(FavSearchUI.this).c(paramAnonymousList, paramAnonymousList1, paramAnonymousList2);
            FavSearchUI.b(FavSearchUI.this, false);
            AppMethodBeat.o(106837);
          }
        });
        if (paramAnonymousString != null)
        {
          FavSearchUI.a(FavSearchUI.this, paramAnonymousString);
          FavSearchUI.this.ted.hes = com.tencent.mm.plugin.fav.ui.f.a.getSearchId();
          FavSearchUI.this.ted.tme = System.currentTimeMillis();
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
        Log.d("MicroMsg.FavSearchUI", "on search, types %s keys %s tags %s", new Object[] { paramAnonymousList, paramAnonymousList1, paramAnonymousList2 });
        FavSearchUI.b(FavSearchUI.this, paramAnonymousList1);
        FavSearchUI.c(FavSearchUI.this, paramAnonymousList2);
        FavSearchUI.d(FavSearchUI.this, paramAnonymousList);
        FavSearchUI.i(FavSearchUI.this).dK(paramAnonymousList2);
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
      
      public final void bnz()
      {
        AppMethodBeat.i(106838);
        Log.d("MicroMsg.FavSearchUI", "on enter search, show tag panel");
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
  
  private void fW(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(235318);
    this.ted.actionType = paramInt1;
    if (this.tdu != null) {
      this.ted.pHw = this.tdu.pHw;
    }
    switch (this.jvZ)
    {
    default: 
      this.ted.scene = 0;
      this.ted.tlX = ((int)(System.currentTimeMillis() - this.iOB) / 1000);
      this.ted.query = this.query;
      if (this.tdY != null)
      {
        if (this.tdY.size() <= 0) {
          break label437;
        }
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
          this.ted.ehn = 0;
        }
      }
      break;
    }
    for (;;)
    {
      this.ted.tlY = ((int)(this.ted.tmf - this.ted.tme));
      this.ted.tma = String.format("%d", new Object[] { Integer.valueOf(paramInt2) });
      this.ted.tmc = (this.tdu.getCount() - 1);
      this.ted.report();
      AppMethodBeat.o(235318);
      return;
      this.ted.scene = 1;
      break;
      this.ted.scene = 2;
      break;
      this.ted.scene = 3;
      break;
      this.ted.ehn = 1;
      continue;
      this.ted.ehn = 2;
      continue;
      this.ted.ehn = 3;
      continue;
      this.ted.ehn = 4;
      continue;
      this.ted.ehn = 5;
      continue;
      this.ted.ehn = 6;
      continue;
      this.ted.ehn = 7;
      continue;
      this.ted.ehn = 8;
      continue;
      label437:
      this.ted.ehn = 0;
    }
  }
  
  public final void Ec(long paramLong)
  {
    AppMethodBeat.i(106857);
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
      AppMethodBeat.o(106857);
      return;
    }
  }
  
  public int getLayoutId()
  {
    return 2131494146;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(106858);
    Log.i("MicroMsg.FavSearchUI", "onActivityResult reqCode: %d, retCod: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
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
      cVL();
      AppMethodBeat.o(106858);
      return;
      if (paramInt2 != -1)
      {
        AppMethodBeat.o(106858);
        return;
      }
      Object localObject2 = this.tee.tkn;
      if (Util.isNullOrNil(paramIntent))
      {
        AppMethodBeat.o(106858);
        return;
      }
      Object localObject1 = Util.stringsToList(paramIntent.split(","));
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = (com.tencent.mm.plugin.fav.ui.gallery.d)((Iterator)localObject2).next();
        if (localObject3 == null)
        {
          Log.d("MicroMsg.FavSearchUI", "select %s, send item null, continute", new Object[] { paramIntent });
        }
        else
        {
          new com.tencent.mm.plugin.fav.a.k();
          if (com.tencent.mm.plugin.fav.a.k.v(((com.tencent.mm.plugin.fav.ui.gallery.d)localObject3).qNT))
          {
            com.tencent.mm.ui.base.h.cD(getContext(), getString(2131755011));
            AppMethodBeat.o(106858);
            return;
          }
          Log.d("MicroMsg.FavSearchUI", "select %s for sending", new Object[] { paramIntent });
          Object localObject4;
          Object localObject5;
          if ((((com.tencent.mm.plugin.fav.ui.gallery.d)localObject3).cWJ()) || (((com.tencent.mm.plugin.fav.ui.gallery.d)localObject3).cWL()))
          {
            localObject4 = new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(106831);
                this.tcT.dismiss();
                AppMethodBeat.o(106831);
              }
            };
            localObject5 = ((List)localObject1).iterator();
            while (((Iterator)localObject5).hasNext()) {
              l.a(this, (String)((Iterator)localObject5).next(), ((com.tencent.mm.plugin.fav.ui.gallery.d)localObject3).dLo, (Runnable)localObject4);
            }
          }
          else
          {
            localObject4 = new ArrayList();
            ((ArrayList)localObject4).add(com.tencent.mm.plugin.fav.a.b.d(((com.tencent.mm.plugin.fav.ui.gallery.d)localObject3).dLo));
            localObject3 = ((List)localObject1).iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject5 = (String)((Iterator)localObject3).next();
              com.tencent.mm.av.q.bcP().a(z.aTY(), (String)localObject5, (ArrayList)localObject4);
            }
          }
        }
      }
      if (!Util.isNullOrNil(str))
      {
        paramIntent = ((List)localObject1).iterator();
        while (paramIntent.hasNext())
        {
          localObject1 = (String)paramIntent.next();
          com.tencent.mm.plugin.messenger.a.g.eir().ad((String)localObject1, str, com.tencent.mm.model.ab.JG((String)localObject1));
        }
        Log.d("MicroMsg.FavSearchUI", "select %s for sending", new Object[] { paramIntent });
        localObject1 = new ArrayList();
        ((List)localObject1).add(this.teh);
        p.a(getContext(), (List)localObject1, str, paramIntent, "MicroMsg.FavSearchUI");
        continue;
        Log.d("MicroMsg.FavSearchUI", "select %s for sending", new Object[] { paramIntent });
        p.a(getContext(), this.tdu.mE(false), str, paramIntent, "MicroMsg.FavSearchUI");
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
      paramBundle.excludeTarget(getWindow().getDecorView().findViewById(2131296366), true);
      paramBundle.excludeTarget(16908335, true);
      getWindow().setEnterTransition(paramBundle);
    }
    this.mHandler = new MMHandler();
    setMMTitle("");
    setActionbarColor(getContext().getResources().getColor(2131100898));
    this.jvZ = getIntent().getIntExtra("key_search_type", 0);
    if (1 == this.jvZ)
    {
      this.dAi = getIntent().getStringExtra("key_to_user");
      this.tdS = getIntent().getStringExtra("key_fav_item_id");
    }
    this.tdR = getIntent().getIntExtra("key_preset_search_type", -1);
    this.tfj = ((ListView)findViewById(2131308874));
    this.pop = ((ListView)findViewById(2131307421));
    this.tdV = findViewById(2131307384);
    this.tdW = AnimationUtils.loadAnimation(getContext(), 2130772111);
    this.tdX = AnimationUtils.loadAnimation(getContext(), 2130772112);
    this.tee = new com.tencent.mm.plugin.fav.ui.gallery.c(this, findViewById(2131300488));
    cWa();
    this.tfk = ((FavCapacityPanel)View.inflate(getContext(), 2131494107, null));
    this.tfk.tmk = getIntent().getIntExtra("key_enter_fav_search_from", 0);
    this.tfh = new com.tencent.mm.plugin.fav.ui.a.c(getContext())
    {
      public final void aso(String paramAnonymousString)
      {
        AppMethodBeat.i(106841);
        FavSearchActionView localFavSearchActionView = FavSearchUI.d(FavSearchUI.this);
        localFavSearchActionView.tmI.add(paramAnonymousString);
        if (localFavSearchActionView.tfS == null)
        {
          AppMethodBeat.o(106841);
          return;
        }
        localFavSearchActionView.tfS.setEditHint("");
        localFavSearchActionView.tfS.dm(paramAnonymousString, true);
        if (localFavSearchActionView.tmK == null)
        {
          AppMethodBeat.o(106841);
          return;
        }
        localFavSearchActionView.asw(localFavSearchActionView.tfS.getEditText());
        localFavSearchActionView.tmK.a(localFavSearchActionView.thn, localFavSearchActionView.tmJ, localFavSearchActionView.tmI, false);
        com.tencent.mm.plugin.report.service.h.CyF.a(11126, new Object[] { Integer.valueOf(2) });
        AppMethodBeat.o(106841);
      }
      
      public final void asp(String paramAnonymousString)
      {
        AppMethodBeat.i(106842);
        FavSearchActionView localFavSearchActionView = FavSearchUI.d(FavSearchUI.this);
        localFavSearchActionView.tmI.remove(paramAnonymousString);
        if (localFavSearchActionView.tfS == null)
        {
          AppMethodBeat.o(106842);
          return;
        }
        if (localFavSearchActionView.tmI.isEmpty()) {
          localFavSearchActionView.tfS.setEditHint(localFavSearchActionView.getResources().getString(2131755972));
        }
        localFavSearchActionView.tfS.removeTag(paramAnonymousString);
        if (localFavSearchActionView.tmK == null)
        {
          AppMethodBeat.o(106842);
          return;
        }
        localFavSearchActionView.asw(localFavSearchActionView.tfS.getEditText());
        localFavSearchActionView.tmK.a(localFavSearchActionView.thn, localFavSearchActionView.tmJ, localFavSearchActionView.tmI, true);
        AppMethodBeat.o(106842);
      }
    };
    if (((af)com.tencent.mm.kernel.g.ah(af.class)).getFavTagSetMgr().cUF() > 0)
    {
      paramBundle = (TextView)View.inflate(getContext(), 2131494150, null);
      this.tfj.addHeaderView(paramBundle);
    }
    this.tfj.addFooterView(this.tfk);
    this.tfj.setAdapter(this.tfh);
    this.tfj.setOnTouchListener(new View.OnTouchListener()
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
        AppMethodBeat.i(106818);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).pH(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).zo(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/FavSearchUI$10", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        localObject = (b.b)paramAnonymousView.getTag();
        if ((localObject != null) && (((b.b)localObject).tbr != null)) {
          FavSearchUI.a(FavSearchUI.this, 2, paramAnonymousInt);
        }
        if (1 == FavSearchUI.a(FavSearchUI.this))
        {
          if (localObject == null)
          {
            Log.w("MicroMsg.FavSearchUI", "on item click, holder is null");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavSearchUI$10", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(106818);
            return;
          }
          if (((b.b)localObject).tbr == null)
          {
            Log.w("MicroMsg.FavSearchUI", "on item click, info is null");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavSearchUI$10", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(106818);
            return;
          }
          ((com.tencent.mm.plugin.fav.a.ab)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.fav.a.ab.class)).a(FavSearchUI.this.getContext(), FavSearchUI.l(FavSearchUI.this), ((b.b)localObject).tbr, false, new y.a()
          {
            public final void a(boolean paramAnonymous2Boolean, String paramAnonymous2String, int paramAnonymous2Int)
            {
              AppMethodBeat.i(106816);
              FavSearchUI.this.hideVKB();
              if (paramAnonymous2Boolean)
              {
                final com.tencent.mm.ui.base.q localq = com.tencent.mm.ui.base.h.a(FavSearchUI.this.getContext(), FavSearchUI.this.getString(2131759230), false, null);
                l.a(FavSearchUI.this.getContext(), FavSearchUI.l(FavSearchUI.this), paramAnonymous2String, this.tem.tbr, new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(106815);
                    if (localq != null) {
                      localq.dismiss();
                    }
                    com.tencent.mm.ui.widget.snackbar.b.r(FavSearchUI.this, FavSearchUI.this.getString(2131759157));
                    MMHandlerThread.postToMainThreadDelayed(new Runnable()
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
              Log.w("MicroMsg.FavSearchUI", "on item click, holder is null");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavSearchUI$10", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(106818);
              return;
            }
            if (((b.b)localObject).tbr == null)
            {
              Log.w("MicroMsg.FavSearchUI", "on item click, info is null");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavSearchUI$10", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(106818);
              return;
            }
            paramAnonymousAdapterView = new Intent();
            paramAnonymousAdapterView.putExtra("key_fav_result_local_id", ((b.b)localObject).tbr.field_localId);
            paramAnonymousAdapterView.putExtra("key_fav_result_fake_local_id", ((b.b)localObject).tbr.dLb);
            FavSearchUI.this.setResult(-1, paramAnonymousAdapterView);
            FavSearchUI.this.finish();
          }
          else
          {
            FavSearchUI.j(FavSearchUI.this).onItemClick(paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
            if (((b.b)localObject).tbr != null) {
              com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(106817);
                  Log.d("MicroMsg.FavSearchUI", "type %s", new Object[] { Integer.valueOf(this.tem.tbr.field_type) });
                  long l = this.tem.tbr.field_localId;
                  if (FavSearchUI.m(FavSearchUI.this).size() == 0) {
                    FavSearchUI.a(FavSearchUI.this, ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().cUZ());
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
                  Object localObject = com.tencent.mm.plugin.report.service.h.CyF;
                  int j = this.tem.tbr.field_type;
                  int k = FavSearchUI.n(FavSearchUI.this);
                  if (FavSearchUI.m(FavSearchUI.this).size() == 0) {
                    i = paramAnonymousInt;
                  }
                  ((com.tencent.mm.plugin.report.service.h)localObject).a(12746, new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i) });
                  AppMethodBeat.o(106817);
                }
              });
            }
          }
        }
      }
    });
    this.pop.setOnItemLongClickListener(this.tej);
    this.pop.setOnTouchListener(new View.OnTouchListener()
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
    this.tei = new com.tencent.mm.plugin.fav.ui.widget.b();
    this.tei.dQ(findViewById(2131300459));
    this.tei.tmy = new b.a()
    {
      public final void cVF()
      {
        AppMethodBeat.i(106825);
        List localList = FavSearchUI.j(FavSearchUI.this).mE(true);
        if (localList.size() == 0)
        {
          Log.e("MicroMsg.FavSearchUI", "FavEditFooter onDelRequest list == null");
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
            FavSearchUI.ak(FavSearchUI.this.getContext());
            AppMethodBeat.o(106825);
            return;
          }
          FavSearchUI.a(FavSearchUI.this, null, 0, (com.tencent.mm.plugin.fav.a.g)localList.get(0));
          AppMethodBeat.o(106825);
          return;
        }
        com.tencent.mm.ui.base.h.a(FavSearchUI.this.getContext(), FavSearchUI.this.getString(2131759175), "", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(106823);
            p.a(FavSearchUI.this.getContext(), localArrayList, new p.a()
            {
              public final void cVU()
              {
                AppMethodBeat.i(106822);
                if (FavSearchUI.j(FavSearchUI.this) != null)
                {
                  Log.v("MicroMsg.FavSearchUI", "do refresh job");
                  FavSearchUI.j(FavSearchUI.this).cWm();
                  MMHandlerThread.postToMainThread(new Runnable()
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
              FavSearchUI.ak(FavSearchUI.this.getContext());
            }
            AppMethodBeat.o(106823);
          }
        }, null);
        AppMethodBeat.o(106825);
      }
      
      public final void cVS()
      {
        AppMethodBeat.i(106824);
        if (!FavoriteIndexUI.a(FavSearchUI.j(FavSearchUI.this).mE(false), FavSearchUI.this, new DialogInterface.OnClickListener()
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
      
      public final void cVT() {}
    };
    ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavTagSetMgr().a(this.tfh);
    com.tencent.mm.kernel.g.aAk().postToWorkerDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106832);
        FavSearchUI.a(FavSearchUI.this, ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().cUZ());
        AppMethodBeat.o(106832);
      }
    }, 1000L);
    this.ted = new com.tencent.mm.plugin.fav.ui.f.a();
    this.iOB = System.currentTimeMillis();
    this.ted.hes = com.tencent.mm.plugin.fav.ui.f.a.getSearchId();
    this.ted.tme = this.iOB;
    if (cVK())
    {
      this.tfi.aj(this.tdR, false);
      this.pop.setVisibility(8);
      this.tfj.setVisibility(8);
      this.tee.setVisibility(0);
      this.tee.bqe();
      AppMethodBeat.o(106846);
      return;
    }
    if (this.tdR > 0)
    {
      this.tfi.aj(this.tdR, true);
      this.tee.setVisibility(8);
      this.pop.setVisibility(0);
    }
    AppMethodBeat.o(106846);
  }
  
  @SuppressLint({"ResourceType"})
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(106849);
    Log.d("MicroMsg.FavSearchUI", "on create options menu");
    cWa();
    this.tfn = paramMenu.add(0, 2131304628, 0, 2131755797);
    this.tfn.setActionView(this.tfi);
    this.tfn.setShowAsAction(9);
    this.tfi.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106833);
        FavSearchActionView localFavSearchActionView = FavSearchUI.d(FavSearchUI.this);
        if (localFavSearchActionView.tfS != null) {
          localFavSearchActionView.tfS.gLd();
        }
        FavSearchUI.this.showVKB();
        AppMethodBeat.o(106833);
      }
    });
    android.support.v4.view.h.a(this.tfn, new h.a()
    {
      public final boolean fA()
      {
        return true;
      }
      
      public final boolean fB()
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
    com.tencent.mm.plugin.fav.ui.f.a locala = this.ted;
    if ((this.ted.actionType != 1) && (this.ted.actionType != 9)) {}
    for (boolean bool = true;; bool = false)
    {
      locala.tmg = bool;
      if (!this.ted.tmg) {
        fW(1, 0);
      }
      this.tee.onDestroy();
      super.onDestroy();
      this.tdt.destory();
      this.tdt = null;
      ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavTagSetMgr().a(this.tfh);
      ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavTagSetMgr().j(this.teb);
      if (this.tdu != null) {
        this.tdu.finish();
      }
      AppMethodBeat.o(106848);
      return;
    }
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(106847);
    if ((4 == paramInt) && (this.tdu.thl))
    {
      cVM();
      AppMethodBeat.o(106847);
      return true;
    }
    if ((4 == paramInt) && (cVK()) && (this.tee.cWG()))
    {
      this.tee.cWI();
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
    i.arU(getClass().getSimpleName());
    if (cVK()) {
      this.tee.onPause();
    }
    super.onPause();
    AppMethodBeat.o(106856);
  }
  
  public void onResume()
  {
    long l = 0L;
    AppMethodBeat.i(106855);
    this.tdu.cWm();
    this.tdu.notifyDataSetChanged();
    FavCapacityPanel localFavCapacityPanel = this.tfk;
    if (localFavCapacityPanel.tmi != com.tencent.mm.plugin.fav.a.b.cUh() / 1048576L)
    {
      localFavCapacityPanel.tmi = (com.tencent.mm.plugin.fav.a.b.cUh() / 1048576L);
      TextView localTextView = localFavCapacityPanel.tmj;
      Context localContext = localFavCapacityPanel.tmj.getContext();
      if (localFavCapacityPanel.tml - localFavCapacityPanel.tmi > 0L) {
        l = localFavCapacityPanel.tml - localFavCapacityPanel.tmi;
      }
      localTextView.setText(localContext.getString(2131759143, new Object[] { Long.valueOf(l), Long.valueOf(localFavCapacityPanel.tmi) }));
    }
    i.arT(getClass().getSimpleName());
    if (cVK()) {
      this.tee.onResume();
    }
    super.onResume();
    AppMethodBeat.o(106855);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavSearchUI
 * JD-Core Version:    0.7.0.1
 */