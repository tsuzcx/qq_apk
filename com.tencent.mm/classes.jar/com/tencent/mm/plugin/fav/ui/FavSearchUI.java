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
import com.tencent.mm.protocal.protobuf.ahp;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
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
  private String cWE;
  private int iex;
  private ao mHandler;
  private long nfL;
  private ListView nwl;
  private o qLA;
  private com.tencent.mm.plugin.fav.ui.a.b qLB;
  private int qLY;
  private String qLZ;
  private Set<Integer> qMa;
  private com.tencent.mm.plugin.fav.a.w qMb;
  private View qMc;
  private Animation qMd;
  private Animation qMe;
  private List<Integer> qMf;
  private List<String> qMg;
  private List<String> qMh;
  private Set<String> qMi;
  private List<Long> qMj;
  a qMk;
  private com.tencent.mm.plugin.fav.ui.gallery.c qMl;
  private int[] qMm;
  private com.tencent.mm.plugin.fav.a.g qMn;
  private com.tencent.mm.plugin.fav.a.g qMo;
  private com.tencent.mm.plugin.fav.ui.widget.b qMp;
  private AdapterView.OnItemLongClickListener qMq;
  private com.tencent.mm.plugin.fav.ui.a.c qNo;
  private FavSearchActionView qNp;
  private ListView qNq;
  private FavCapacityPanel qNr;
  private View qNs;
  private ImageButton qNt;
  private MenuItem qNu;
  private ahp qNv;
  private String query;
  
  public FavSearchUI()
  {
    AppMethodBeat.i(106845);
    this.qLY = -1;
    this.qMi = new HashSet();
    this.qMj = new ArrayList();
    this.query = "";
    this.qMm = new int[2];
    this.qNv = new ahp();
    this.qMq = new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(106813);
        if (FavSearchUI.a(FavSearchUI.this) == 2)
        {
          ac.w("MicroMsg.FavSearchUI", "on edit mode long click, ignore");
          AppMethodBeat.o(106813);
          return true;
        }
        if (paramAnonymousInt < FavSearchUI.b(FavSearchUI.this).getHeaderViewsCount())
        {
          ac.w("MicroMsg.FavSearchUI", "on header view long click, ignore");
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
  
  private void aa(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(106854);
    this.qMk.actionType = paramInt1;
    if (this.qLB != null) {
      this.qMk.nLC = this.qLB.nLC;
    }
    switch (this.iex)
    {
    default: 
      this.qMk.scene = 0;
      this.qMk.position = paramInt2;
      this.qMk.qNI = ((int)(System.currentTimeMillis() - this.nfL) / 1000);
      this.qMk.query = this.query;
      this.qMk.qIs = paramInt3;
      if (this.qMf != null)
      {
        if (this.qMf.size() <= 0) {
          break label390;
        }
        switch (((Integer)this.qMf.get(0)).intValue())
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
          this.qMk.qNJ = 0;
        }
      }
      break;
    }
    for (;;)
    {
      this.qMk.report();
      AppMethodBeat.o(106854);
      return;
      this.qMk.scene = 1;
      break;
      this.qMk.scene = 2;
      break;
      this.qMk.scene = 3;
      break;
      this.qMk.qNJ = 1;
      continue;
      this.qMk.qNJ = 2;
      continue;
      this.qMk.qNJ = 3;
      continue;
      this.qMk.qNJ = 4;
      continue;
      this.qMk.qNJ = 5;
      continue;
      this.qMk.qNJ = 6;
      continue;
      this.qMk.qNJ = 7;
      continue;
      this.qMk.qNJ = 8;
      continue;
      label390:
      this.qMk.qNJ = 0;
    }
  }
  
  public static void an(Activity paramActivity)
  {
    AppMethodBeat.i(106852);
    f.a locala = new f.a(paramActivity);
    locala.aRQ(paramActivity.getString(2131758854));
    locala.aRU(paramActivity.getString(2131758851));
    locala.b(new f.c()
    {
      public final void d(boolean paramAnonymousBoolean, String paramAnonymousString) {}
    });
    locala.show();
    AppMethodBeat.o(106852);
  }
  
  private boolean cqA()
  {
    return this.qLY == 21;
  }
  
  private boolean cqB()
  {
    AppMethodBeat.i(106851);
    if (this.qLB.qPu)
    {
      cqC();
      AppMethodBeat.o(106851);
      return true;
    }
    if ((cqA()) && (this.qMl.crq()))
    {
      this.qMl.crs();
      AppMethodBeat.o(106851);
      return true;
    }
    AppMethodBeat.o(106851);
    return false;
  }
  
  private void cqC()
  {
    AppMethodBeat.i(106853);
    this.qLB.a(false, null);
    this.nwl.setOnItemLongClickListener(this.qMq);
    this.qMp.hide();
    if (cqA()) {
      this.qMl.crs();
    }
    AppMethodBeat.o(106853);
  }
  
  private void cqL()
  {
    AppMethodBeat.i(106850);
    if (this.qNp != null)
    {
      AppMethodBeat.o(106850);
      return;
    }
    this.qNp = ((FavSearchActionView)View.inflate(getContext(), 2131493975, null));
    this.qNs = this.qNp.findViewById(2131297690);
    this.qNs.setOnClickListener(new View.OnClickListener()
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
    this.qNt = ((ImageButton)this.qNp.findViewById(2131304401));
    this.qNt.setVisibility(8);
    this.qNp.setOnSearchChangedListener(new FavSearchActionView.a()
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
            ac.d("MicroMsg.FavSearchUI", "on text changed, types %s keys %s tags %s", new Object[] { paramAnonymousList, paramAnonymousList1, paramAnonymousList2 });
            FavSearchUI.b(FavSearchUI.this, paramAnonymousList1);
            FavSearchUI.c(FavSearchUI.this, paramAnonymousList2);
            FavSearchUI.d(FavSearchUI.this, paramAnonymousList);
            FavSearchUI.i(FavSearchUI.this).dr(paramAnonymousList2);
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
        ac.d("MicroMsg.FavSearchUI", "on search, types %s keys %s tags %s", new Object[] { paramAnonymousList, paramAnonymousList1, paramAnonymousList2 });
        FavSearchUI.b(FavSearchUI.this, paramAnonymousList1);
        FavSearchUI.c(FavSearchUI.this, paramAnonymousList2);
        FavSearchUI.d(FavSearchUI.this, paramAnonymousList);
        FavSearchUI.i(FavSearchUI.this).dr(paramAnonymousList2);
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
      
      public final void aPb()
      {
        AppMethodBeat.i(106838);
        ac.d("MicroMsg.FavSearchUI", "on enter search, show tag panel");
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
    ac.i("MicroMsg.FavSearchUI", "onActivityResult reqCode: %d, retCod: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
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
      cqB();
      AppMethodBeat.o(106858);
      return;
      if (paramInt2 != -1)
      {
        AppMethodBeat.o(106858);
        return;
      }
      Object localObject2 = this.qMl.qSp;
      if (bs.isNullOrNil(paramIntent))
      {
        AppMethodBeat.o(106858);
        return;
      }
      Object localObject1 = bs.S(paramIntent.split(","));
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = (d)((Iterator)localObject2).next();
        if (localObject3 == null)
        {
          ac.d("MicroMsg.FavSearchUI", "select %s, send item null, continute", new Object[] { paramIntent });
        }
        else
        {
          new k();
          if (k.v(((d)localObject3).oOo))
          {
            com.tencent.mm.ui.base.h.cg(getContext(), getString(2131755010));
            AppMethodBeat.o(106858);
            return;
          }
          ac.d("MicroMsg.FavSearchUI", "select %s for sending", new Object[] { paramIntent });
          Object localObject4;
          Object localObject5;
          if ((((d)localObject3).crt()) || (((d)localObject3).crv()))
          {
            localObject4 = new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(106831);
                this.qLa.dismiss();
                AppMethodBeat.o(106831);
              }
            };
            localObject5 = ((List)localObject1).iterator();
            while (((Iterator)localObject5).hasNext()) {
              l.a(this, (String)((Iterator)localObject5).next(), ((d)localObject3).dhz, (Runnable)localObject4);
            }
          }
          else
          {
            localObject4 = new ArrayList();
            ((ArrayList)localObject4).add(com.tencent.mm.plugin.fav.a.b.d(((d)localObject3).dhz));
            localObject3 = ((List)localObject1).iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject5 = (String)((Iterator)localObject3).next();
              com.tencent.mm.av.o.aFv().a(u.axw(), (String)localObject5, (ArrayList)localObject4);
            }
          }
        }
      }
      if (!bs.isNullOrNil(str))
      {
        paramIntent = ((List)localObject1).iterator();
        while (paramIntent.hasNext())
        {
          localObject1 = (String)paramIntent.next();
          j.dck().X((String)localObject1, str, com.tencent.mm.model.w.xt((String)localObject1));
        }
        ac.d("MicroMsg.FavSearchUI", "select %s for sending", new Object[] { paramIntent });
        localObject1 = new ArrayList();
        ((List)localObject1).add(this.qMo);
        p.a(getContext(), (List)localObject1, str, paramIntent, "MicroMsg.FavSearchUI");
        continue;
        ac.d("MicroMsg.FavSearchUI", "select %s for sending", new Object[] { paramIntent });
        p.a(getContext(), this.qLB.li(false), str, paramIntent, "MicroMsg.FavSearchUI");
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
    this.mHandler = new ao();
    setMMTitle("");
    setActionbarColor(getContext().getResources().getColor(2131100705));
    this.iex = getIntent().getIntExtra("key_search_type", 0);
    if (1 == this.iex)
    {
      this.cWE = getIntent().getStringExtra("key_to_user");
      this.qLZ = getIntent().getStringExtra("key_fav_item_id");
    }
    this.qLY = getIntent().getIntExtra("key_preset_search_type", -1);
    this.qNq = ((ListView)findViewById(2131305632));
    this.nwl = ((ListView)findViewById(2131304445));
    this.qMc = findViewById(2131304417);
    this.qMd = AnimationUtils.loadAnimation(getContext(), 2130772089);
    this.qMe = AnimationUtils.loadAnimation(getContext(), 2130772090);
    this.qMl = new com.tencent.mm.plugin.fav.ui.gallery.c(this, findViewById(2131299813));
    cqL();
    this.qNr = ((FavCapacityPanel)View.inflate(getContext(), 2131493939, null));
    this.qNr.qTZ = getIntent().getIntExtra("key_enter_fav_search_from", 0);
    this.qNo = new com.tencent.mm.plugin.fav.ui.a.c(getContext())
    {
      public final void acU(String paramAnonymousString)
      {
        AppMethodBeat.i(106841);
        FavSearchActionView localFavSearchActionView = FavSearchUI.d(FavSearchUI.this);
        localFavSearchActionView.qUy.add(paramAnonymousString);
        if (localFavSearchActionView.qOc == null)
        {
          AppMethodBeat.o(106841);
          return;
        }
        localFavSearchActionView.qOc.setEditHint("");
        localFavSearchActionView.qOc.cI(paramAnonymousString, true);
        if (localFavSearchActionView.qUA == null)
        {
          AppMethodBeat.o(106841);
          return;
        }
        localFavSearchActionView.adc(localFavSearchActionView.qOc.getEditText());
        localFavSearchActionView.qUA.a(localFavSearchActionView.qPw, localFavSearchActionView.qUz, localFavSearchActionView.qUy, false);
        com.tencent.mm.plugin.report.service.h.wUl.f(11126, new Object[] { Integer.valueOf(2) });
        AppMethodBeat.o(106841);
      }
      
      public final void acV(String paramAnonymousString)
      {
        AppMethodBeat.i(106842);
        FavSearchActionView localFavSearchActionView = FavSearchUI.d(FavSearchUI.this);
        localFavSearchActionView.qUy.remove(paramAnonymousString);
        if (localFavSearchActionView.qOc == null)
        {
          AppMethodBeat.o(106842);
          return;
        }
        if (localFavSearchActionView.qUy.isEmpty()) {
          localFavSearchActionView.qOc.setEditHint(localFavSearchActionView.getResources().getString(2131755882));
        }
        localFavSearchActionView.qOc.removeTag(paramAnonymousString);
        if (localFavSearchActionView.qUA == null)
        {
          AppMethodBeat.o(106842);
          return;
        }
        localFavSearchActionView.adc(localFavSearchActionView.qOc.getEditText());
        localFavSearchActionView.qUA.a(localFavSearchActionView.qPw, localFavSearchActionView.qUz, localFavSearchActionView.qUy, true);
        AppMethodBeat.o(106842);
      }
    };
    if (((af)com.tencent.mm.kernel.g.ad(af.class)).getFavTagSetMgr().cpv() > 0)
    {
      paramBundle = (TextView)View.inflate(getContext(), 2131493980, null);
      this.qNq.addHeaderView(paramBundle);
    }
    this.qNq.addFooterView(this.qNr);
    this.qNq.setAdapter(this.qNo);
    this.qNq.setOnTouchListener(new View.OnTouchListener()
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
    this.qLA = new o(getContext(), 16);
    getContext();
    this.qLB = new com.tencent.mm.plugin.fav.ui.a.b(this.qLA, false);
    this.qLB.qPB = this;
    this.qLB.scene = 2;
    this.qLB.qPE = this.nwl;
    if (1 == this.iex)
    {
      this.qMa = new HashSet();
      this.qMb = new k();
      if (!bs.isNullOrNil(this.qLZ))
      {
        paramBundle = this.qLZ.split(",");
        int j = paramBundle.length;
        int i = 0;
        while (i < j)
        {
          int k = bs.getInt(paramBundle[i], 2147483647);
          if (2147483647 != k) {
            this.qMa.add(Integer.valueOf(k));
          }
          i += 1;
        }
      }
      this.qLB.g(this.qMa);
      this.qLB.a(this.qMb);
    }
    this.nwl.setAdapter(this.qLB);
    this.nwl.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, final int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(106818);
        final b.b localb = (b.b)paramAnonymousView.getTag();
        if ((localb != null) && (localb.qJy != null))
        {
          FavSearchUI.this.qMk.qNK = true;
          FavSearchUI.a(FavSearchUI.this, paramAnonymousInt, localb.qJy.field_id);
        }
        if (1 == FavSearchUI.a(FavSearchUI.this))
        {
          if (localb == null)
          {
            ac.w("MicroMsg.FavSearchUI", "on item click, holder is null");
            AppMethodBeat.o(106818);
            return;
          }
          if (localb.qJy == null)
          {
            ac.w("MicroMsg.FavSearchUI", "on item click, info is null");
            AppMethodBeat.o(106818);
            return;
          }
          ((ab)com.tencent.mm.kernel.g.ab(ab.class)).a(FavSearchUI.this.getContext(), FavSearchUI.l(FavSearchUI.this), localb.qJy, false, new y.a()
          {
            public final void a(boolean paramAnonymous2Boolean, String paramAnonymous2String, int paramAnonymous2Int)
            {
              AppMethodBeat.i(106816);
              FavSearchUI.this.hideVKB();
              if (paramAnonymous2Boolean)
              {
                final com.tencent.mm.ui.base.p localp = com.tencent.mm.ui.base.h.b(FavSearchUI.this.getContext(), FavSearchUI.this.getString(2131758906), false, null);
                l.a(FavSearchUI.this.getContext(), FavSearchUI.l(FavSearchUI.this), paramAnonymous2String, localb.qJy, new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(106815);
                    if (localp != null) {
                      localp.dismiss();
                    }
                    com.tencent.mm.ui.widget.snackbar.b.n(FavSearchUI.this, FavSearchUI.this.getString(2131758834));
                    ap.n(new Runnable()
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
            ac.w("MicroMsg.FavSearchUI", "on item click, holder is null");
            AppMethodBeat.o(106818);
            return;
          }
          if (localb.qJy == null)
          {
            ac.w("MicroMsg.FavSearchUI", "on item click, info is null");
            AppMethodBeat.o(106818);
            return;
          }
          paramAnonymousAdapterView = new Intent();
          paramAnonymousAdapterView.putExtra("key_fav_result_local_id", localb.qJy.field_localId);
          paramAnonymousAdapterView.putExtra("key_fav_result_fake_local_id", localb.qJy.dhm);
          FavSearchUI.this.setResult(-1, paramAnonymousAdapterView);
          FavSearchUI.this.finish();
          AppMethodBeat.o(106818);
          return;
        }
        FavSearchUI.j(FavSearchUI.this).onItemClick(paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        if (localb.qJy != null) {
          com.tencent.mm.kernel.g.agU().az(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(106817);
              ac.d("MicroMsg.FavSearchUI", "type %s", new Object[] { Integer.valueOf(localb.qJy.field_type) });
              long l = localb.qJy.field_localId;
              if (FavSearchUI.m(FavSearchUI.this).size() == 0) {
                FavSearchUI.a(FavSearchUI.this, ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().cpP());
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
              Object localObject = com.tencent.mm.plugin.report.service.h.wUl;
              int j = localb.qJy.field_type;
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
    this.nwl.setOnItemLongClickListener(this.qMq);
    this.nwl.setOnTouchListener(new View.OnTouchListener()
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
    this.qMp = new com.tencent.mm.plugin.fav.ui.widget.b();
    this.qMp.dT(findViewById(2131299786));
    this.qMp.qUn = new b.a()
    {
      public final void cqD()
      {
        AppMethodBeat.i(106824);
        if (!FavoriteIndexUI.a(FavSearchUI.j(FavSearchUI.this).li(false), FavSearchUI.this, new DialogInterface.OnClickListener()
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
      
      public final void cqE() {}
      
      public final void cqv()
      {
        AppMethodBeat.i(106825);
        List localList = FavSearchUI.j(FavSearchUI.this).li(true);
        if (localList.size() == 0)
        {
          ac.e("MicroMsg.FavSearchUI", "FavEditFooter onDelRequest list == null");
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
          if (localg.qIl)
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
              public final void cqF()
              {
                AppMethodBeat.i(106822);
                if (FavSearchUI.j(FavSearchUI.this) != null)
                {
                  ac.v("MicroMsg.FavSearchUI", "do refresh job");
                  FavSearchUI.j(FavSearchUI.this).cqX();
                  ap.f(new Runnable()
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
    };
    ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavTagSetMgr().a(this.qNo);
    com.tencent.mm.kernel.g.agU().m(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106832);
        FavSearchUI.a(FavSearchUI.this, ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().cpP());
        AppMethodBeat.o(106832);
      }
    }, 1000L);
    this.qMk = new a();
    this.nfL = System.currentTimeMillis();
    if (cqA())
    {
      this.qNp.ac(this.qLY, false);
      this.nwl.setVisibility(8);
      this.qNq.setVisibility(8);
      this.qMl.setVisibility(0);
      this.qMl.aRI();
      AppMethodBeat.o(106846);
      return;
    }
    if (this.qLY > 0)
    {
      this.qNp.ac(this.qLY, true);
      this.qMl.setVisibility(8);
      this.nwl.setVisibility(0);
    }
    AppMethodBeat.o(106846);
  }
  
  @SuppressLint({"ResourceType"})
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(106849);
    ac.d("MicroMsg.FavSearchUI", "on create options menu");
    cqL();
    this.qNu = paramMenu.add(0, 2131302248, 0, 2131755726);
    this.qNu.setActionView(this.qNp);
    this.qNu.setShowAsAction(9);
    this.qNp.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106833);
        FavSearchActionView localFavSearchActionView = FavSearchUI.d(FavSearchUI.this);
        if (localFavSearchActionView.qOc != null) {
          localFavSearchActionView.qOc.fiL();
        }
        FavSearchUI.this.showVKB();
        AppMethodBeat.o(106833);
      }
    });
    android.support.v4.view.h.a(this.qNu, new h.a()
    {
      public final boolean fd()
      {
        return true;
      }
      
      public final boolean fe()
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
    if (!this.qMk.qNK)
    {
      if ((!this.qLB.isEmpty()) && (this.nwl.getVisibility() == 0)) {
        break label129;
      }
      aa(1, 0, 0);
    }
    for (;;)
    {
      this.qMl.onDestroy();
      super.onDestroy();
      this.qLA.destory();
      this.qLA = null;
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavTagSetMgr().a(this.qNo);
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavTagSetMgr().f(this.qMi);
      if (this.qLB != null) {
        this.qLB.finish();
      }
      AppMethodBeat.o(106848);
      return;
      label129:
      aa(2, 0, 0);
    }
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(106847);
    if ((4 == paramInt) && (this.qLB.qPu))
    {
      cqC();
      AppMethodBeat.o(106847);
      return true;
    }
    if ((4 == paramInt) && (cqA()) && (this.qMl.crq()))
    {
      this.qMl.crs();
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
    com.tencent.mm.plugin.fav.a.i.acA(getClass().getSimpleName());
    if (cqA()) {
      this.qMl.onPause();
    }
    super.onPause();
    AppMethodBeat.o(106856);
  }
  
  public void onResume()
  {
    long l = 0L;
    AppMethodBeat.i(106855);
    this.qLB.cqX();
    this.qLB.notifyDataSetChanged();
    FavCapacityPanel localFavCapacityPanel = this.qNr;
    if (localFavCapacityPanel.qTX != com.tencent.mm.plugin.fav.a.b.coY() / 1048576L)
    {
      localFavCapacityPanel.qTX = (com.tencent.mm.plugin.fav.a.b.coY() / 1048576L);
      TextView localTextView = localFavCapacityPanel.qTY;
      Context localContext = localFavCapacityPanel.qTY.getContext();
      if (localFavCapacityPanel.qUa - localFavCapacityPanel.qTX > 0L) {
        l = localFavCapacityPanel.qUa - localFavCapacityPanel.qTX;
      }
      localTextView.setText(localContext.getString(2131758820, new Object[] { Long.valueOf(l), Long.valueOf(localFavCapacityPanel.qTX) }));
    }
    com.tencent.mm.plugin.fav.a.i.acz(getClass().getSimpleName());
    if (cqA()) {
      this.qMl.onResume();
    }
    super.onResume();
    AppMethodBeat.o(106855);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void tL(long paramLong)
  {
    AppMethodBeat.i(106857);
    com.tencent.mm.plugin.fav.ui.widget.b localb;
    if (this.qLB.qPu)
    {
      localb = this.qMp;
      if (this.qLB.cra() <= 0) {
        break label47;
      }
    }
    label47:
    for (boolean bool = true;; bool = false)
    {
      localb.ln(bool);
      AppMethodBeat.o(106857);
      return;
    }
  }
  
  static final class a
  {
    int actionType;
    int nLC;
    int position;
    long qIs;
    int qNI;
    int qNJ;
    boolean qNK = false;
    String query;
    int scene;
    
    public final void report()
    {
      AppMethodBeat.i(106844);
      com.tencent.mm.plugin.report.service.h.wUl.f(15488, new Object[] { Integer.valueOf(this.actionType), Integer.valueOf(this.nLC), Integer.valueOf(this.scene), Integer.valueOf(this.position), Integer.valueOf(this.qNI), this.query, Long.valueOf(this.qIs), Integer.valueOf(this.qNJ) });
      AppMethodBeat.o(106844);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavSearchUI
 * JD-Core Version:    0.7.0.1
 */