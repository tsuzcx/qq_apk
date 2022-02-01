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
import com.tencent.mm.protocal.protobuf.ahp;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
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
  private String cWE;
  private int iex;
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
  FavSearchUI.a qMk;
  private c qMl;
  private int[] qMm;
  private com.tencent.mm.plugin.fav.a.g qMn;
  private com.tencent.mm.plugin.fav.a.g qMo;
  private com.tencent.mm.plugin.fav.ui.widget.b qMp;
  private AdapterView.OnItemLongClickListener qMq;
  private String query;
  
  public FavFilterUI()
  {
    AppMethodBeat.i(106713);
    this.qLY = -1;
    this.qMf = new LinkedList();
    this.qMg = new LinkedList();
    this.qMh = new LinkedList();
    this.qMi = new HashSet();
    this.qMj = new ArrayList();
    this.query = "";
    this.qMm = new int[2];
    this.qMq = new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(106691);
        if (FavFilterUI.a(FavFilterUI.this) == 2)
        {
          ac.w("MicroMsg.FavFilterUI", "on edit mode long click, ignore");
          AppMethodBeat.o(106691);
          return true;
        }
        if (paramAnonymousInt < FavFilterUI.b(FavFilterUI.this).getHeaderViewsCount())
        {
          ac.w("MicroMsg.FavFilterUI", "on header view long click, ignore");
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
  
  private void aa(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(106721);
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
          break label389;
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
      AppMethodBeat.o(106721);
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
      label389:
      this.qMk.qNJ = 0;
    }
  }
  
  private boolean cqA()
  {
    return this.qLY == 21;
  }
  
  private boolean cqB()
  {
    AppMethodBeat.i(106719);
    if (this.qLB.qPu)
    {
      cqC();
      AppMethodBeat.o(106719);
      return true;
    }
    if ((cqA()) && (this.qMl.crq()))
    {
      this.qMl.crs();
      AppMethodBeat.o(106719);
      return true;
    }
    AppMethodBeat.o(106719);
    return false;
  }
  
  private void cqC()
  {
    AppMethodBeat.i(106720);
    this.qLB.a(false, null);
    this.nwl.setOnItemLongClickListener(this.qMq);
    this.qMp.hide();
    if (cqA()) {
      this.qMl.crs();
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
    ac.i("MicroMsg.FavFilterUI", "onActivityResult reqCode: %d, retCod: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
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
        cqB();
        AppMethodBeat.o(106725);
        return;
        if (paramInt2 != -1)
        {
          AppMethodBeat.o(106725);
          return;
        }
        Object localObject1 = this.qMl.qSp;
        if (bs.isNullOrNil(str2))
        {
          AppMethodBeat.o(106725);
          return;
        }
        paramIntent = bs.S(str2.split(","));
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (d)((Iterator)localObject1).next();
          if (localObject2 == null)
          {
            ac.d("MicroMsg.FavFilterUI", "select %s, send item null, continute", new Object[] { str2 });
          }
          else
          {
            new k();
            if (k.v(((d)localObject2).oOo))
            {
              com.tencent.mm.ui.base.h.cg(getContext(), getString(2131755010));
              AppMethodBeat.o(106725);
              return;
            }
            ac.d("MicroMsg.FavFilterUI", "select %s for sending", new Object[] { str2 });
            Object localObject3;
            Object localObject4;
            if ((((d)localObject2).crt()) || (((d)localObject2).crv()))
            {
              localObject3 = new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(106696);
                  this.qLa.dismiss();
                  AppMethodBeat.o(106696);
                }
              };
              localObject4 = paramIntent.iterator();
              while (((Iterator)localObject4).hasNext()) {
                l.a(this, (String)((Iterator)localObject4).next(), ((d)localObject2).dhz, (Runnable)localObject3);
              }
            }
            else
            {
              localObject3 = new ArrayList();
              ((ArrayList)localObject3).add(com.tencent.mm.plugin.fav.a.b.d(((d)localObject2).dhz));
              localObject2 = paramIntent.iterator();
              while (((Iterator)localObject2).hasNext())
              {
                localObject4 = (String)((Iterator)localObject2).next();
                com.tencent.mm.av.o.aFv().a(u.axw(), (String)localObject4, (ArrayList)localObject3);
              }
            }
          }
        }
        if (!bs.isNullOrNil(str1))
        {
          paramIntent = paramIntent.iterator();
          while (paramIntent.hasNext())
          {
            str2 = (String)paramIntent.next();
            j.dck().X(str2, str1, com.tencent.mm.model.w.xt(str2));
          }
          ac.d("MicroMsg.FavFilterUI", "select %s for sending", new Object[] { str2 });
          paramIntent = new ArrayList();
          paramIntent.add(this.qMo);
          p.a(getContext(), paramIntent, str1, str2, "MicroMsg.FavFilterUI");
          continue;
          ac.d("MicroMsg.FavFilterUI", "select %s for sending", new Object[] { str2 });
          p.a(getContext(), this.qLB.li(false), str1, str2, "MicroMsg.FavFilterUI");
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
    paramInt1 = this.qLB.n(l, paramIntent);
    if (-1 == paramInt1)
    {
      AppMethodBeat.o(106725);
      return;
    }
    this.nwl.setSelection(paramInt1);
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
    this.qLY = getIntent().getIntExtra("key_preset_search_type", -1);
    setMMTitle(FavSearchActionView.T(getContext(), this.qLY));
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
    this.iex = getIntent().getIntExtra("key_search_type", 0);
    this.qMc = findViewById(2131304417);
    if (1 == this.iex)
    {
      this.cWE = getIntent().getStringExtra("key_to_user");
      this.qLZ = getIntent().getStringExtra("key_fav_item_id");
    }
    this.qMd = AnimationUtils.loadAnimation(getContext(), 2130772089);
    this.qMe = AnimationUtils.loadAnimation(getContext(), 2130772090);
    this.nwl = ((ListView)findViewById(2131304445));
    this.qMl = new c(this, findViewById(2131299813));
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
        AppMethodBeat.i(106703);
        final b.b localb = (b.b)paramAnonymousView.getTag();
        if ((localb != null) && (localb.qJy != null))
        {
          FavFilterUI.this.qMk.qNK = true;
          FavFilterUI.a(FavFilterUI.this, paramAnonymousInt, localb.qJy.field_id);
        }
        if (1 == FavFilterUI.a(FavFilterUI.this))
        {
          if (localb == null)
          {
            ac.w("MicroMsg.FavFilterUI", "on item click, holder is null");
            AppMethodBeat.o(106703);
            return;
          }
          if (localb.qJy == null)
          {
            ac.w("MicroMsg.FavFilterUI", "on item click, info is null");
            AppMethodBeat.o(106703);
            return;
          }
          ((ab)com.tencent.mm.kernel.g.ab(ab.class)).a(FavFilterUI.this.getContext(), FavFilterUI.e(FavFilterUI.this), localb.qJy, false, new y.a()
          {
            public final void a(boolean paramAnonymous2Boolean, String paramAnonymous2String, int paramAnonymous2Int)
            {
              AppMethodBeat.i(106701);
              FavFilterUI.this.hideVKB();
              if (paramAnonymous2Boolean)
              {
                final com.tencent.mm.ui.base.p localp = com.tencent.mm.ui.base.h.b(FavFilterUI.this.getContext(), FavFilterUI.this.getString(2131758906), false, null);
                l.a(FavFilterUI.this.getContext(), FavFilterUI.e(FavFilterUI.this), paramAnonymous2String, localb.qJy, new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(106700);
                    if (localp != null) {
                      localp.dismiss();
                    }
                    com.tencent.mm.ui.widget.snackbar.b.n(FavFilterUI.this, FavFilterUI.this.getString(2131758834));
                    ap.n(new Runnable()
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
            ac.w("MicroMsg.FavFilterUI", "on item click, holder is null");
            AppMethodBeat.o(106703);
            return;
          }
          if (localb.qJy == null)
          {
            ac.w("MicroMsg.FavFilterUI", "on item click, info is null");
            AppMethodBeat.o(106703);
            return;
          }
          paramAnonymousAdapterView = new Intent();
          paramAnonymousAdapterView.putExtra("key_fav_result_local_id", localb.qJy.field_localId);
          FavFilterUI.this.setResult(-1, paramAnonymousAdapterView);
          FavFilterUI.this.finish();
          AppMethodBeat.o(106703);
          return;
        }
        FavFilterUI.f(FavFilterUI.this).onItemClick(paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        if (localb.qJy != null) {
          com.tencent.mm.kernel.g.agU().az(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(106702);
              ac.d("MicroMsg.FavFilterUI", "type %s", new Object[] { Integer.valueOf(localb.qJy.field_type) });
              long l = localb.qJy.field_localId;
              if (FavFilterUI.g(FavFilterUI.this).size() == 0) {
                FavFilterUI.a(FavFilterUI.this, ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().cpP());
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
              Object localObject = com.tencent.mm.plugin.report.service.h.wUl;
              int j = localb.qJy.field_type;
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
    this.nwl.setOnItemLongClickListener(this.qMq);
    this.nwl.setOnTouchListener(new View.OnTouchListener()
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
    this.qMp = new com.tencent.mm.plugin.fav.ui.widget.b();
    this.qMp.dT(findViewById(2131299786));
    this.qMp.qUn = new b.a()
    {
      public final void cqD()
      {
        AppMethodBeat.i(106709);
        if (!FavoriteIndexUI.a(FavFilterUI.f(FavFilterUI.this).li(false), FavFilterUI.this, new DialogInterface.OnClickListener()
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
      
      public final void cqE() {}
      
      public final void cqv()
      {
        AppMethodBeat.i(106710);
        List localList = FavFilterUI.f(FavFilterUI.this).li(true);
        if (localList.size() == 0)
        {
          ac.e("MicroMsg.FavFilterUI", "FavEditFooter onDelRequest list == null");
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
              public final void cqF()
              {
                AppMethodBeat.i(106707);
                if (FavFilterUI.f(FavFilterUI.this) != null)
                {
                  ac.v("MicroMsg.FavFilterUI", "do refresh job");
                  FavFilterUI.f(FavFilterUI.this).cqX();
                  ap.f(new Runnable()
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
    };
    com.tencent.mm.kernel.g.agU().m(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106698);
        FavFilterUI.a(FavFilterUI.this, ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().cpP());
        AppMethodBeat.o(106698);
      }
    }, 1000L);
    this.qMk = new FavSearchUI.a();
    this.nfL = System.currentTimeMillis();
    if (cqA())
    {
      this.nwl.setVisibility(8);
      this.qMl.setVisibility(0);
      this.qMl.aRI();
      AppMethodBeat.o(106714);
      return;
    }
    if (this.qLY > 0)
    {
      this.qMf.clear();
      this.qMf.add(Integer.valueOf(this.qLY));
      this.qLB.c(this.qMf, this.qMg, this.qMh);
      this.qLB.notifyDataSetChanged();
      if (8 != this.qMl.fvu.getVisibility()) {
        this.qMl.setVisibility(8);
      }
      if (!this.qLB.isEmpty()) {
        break label785;
      }
      if (this.qMc.getVisibility() != 0)
      {
        this.qMc.setVisibility(0);
        this.qMc.startAnimation(this.qMd);
      }
      if (8 != this.nwl.getVisibility())
      {
        this.nwl.setVisibility(8);
        this.nwl.startAnimation(this.qMe);
      }
    }
    for (;;)
    {
      hideVKB();
      this.qMl.setVisibility(8);
      this.nwl.setVisibility(0);
      AppMethodBeat.o(106714);
      return;
      label785:
      if (8 != this.qMc.getVisibility())
      {
        this.qMc.setVisibility(8);
        this.qMc.startAnimation(this.qMe);
      }
      if (this.nwl.getVisibility() != 0)
      {
        this.nwl.setVisibility(0);
        this.nwl.startAnimation(this.qMd);
      }
    }
  }
  
  @SuppressLint({"ResourceType"})
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(106717);
    MenuItem localMenuItem = paramMenu.add(0, 10, 0, 2131764452);
    localMenuItem.setIcon(am.k(getContext(), 2131689494, getContext().getResources().getColor(2131099732)));
    localMenuItem.setShowAsAction(2);
    boolean bool = super.onCreateOptionsMenu(paramMenu);
    AppMethodBeat.o(106717);
    return bool;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(106716);
    if (!this.qMk.qNK)
    {
      if ((!this.qLB.isEmpty()) && (this.nwl.getVisibility() == 0)) {
        break label108;
      }
      aa(1, 0, 0);
    }
    for (;;)
    {
      this.qMl.onDestroy();
      super.onDestroy();
      this.qLA.destory();
      this.qLA = null;
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavTagSetMgr().f(this.qMi);
      if (this.qLB != null) {
        this.qLB.finish();
      }
      AppMethodBeat.o(106716);
      return;
      label108:
      aa(2, 0, 0);
    }
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(106715);
    if ((4 == paramInt) && (this.qLB.qPu))
    {
      cqC();
      AppMethodBeat.o(106715);
      return true;
    }
    if ((4 == paramInt) && (cqA()) && (this.qMl.crq()))
    {
      this.qMl.crs();
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
      paramMenuItem.putExtra("key_preset_search_type", this.qLY);
      p.a(getContext(), this.qLB.qPu, paramMenuItem);
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
    com.tencent.mm.plugin.fav.a.i.acA(getClass().getSimpleName());
    if (cqA()) {
      this.qMl.onPause();
    }
    super.onPause();
    AppMethodBeat.o(106723);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(106722);
    this.qLB.cqX();
    this.qLB.notifyDataSetChanged();
    com.tencent.mm.plugin.fav.a.i.acz(getClass().getSimpleName());
    if (cqA()) {
      this.qMl.onResume();
    }
    super.onResume();
    AppMethodBeat.o(106722);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void tL(long paramLong)
  {
    AppMethodBeat.i(106724);
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
      AppMethodBeat.o(106724);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavFilterUI
 * JD-Core Version:    0.7.0.1
 */