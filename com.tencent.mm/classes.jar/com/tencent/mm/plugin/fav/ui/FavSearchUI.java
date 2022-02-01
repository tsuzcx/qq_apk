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
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar.LayoutParams;
import androidx.core.g.i.1;
import androidx.core.g.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.q;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.fav.a.ac;
import com.tencent.mm.plugin.fav.a.ag;
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
import com.tencent.mm.protocal.protobuf.aoe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.s;
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
  private String fsX;
  private long lER;
  private MMHandler mHandler;
  private int mlC;
  private String query;
  private ListView sxp;
  private o wJE;
  private com.tencent.mm.plugin.fav.ui.a.b wJF;
  private int wKc;
  private String wKd;
  private Set<Integer> wKe;
  private x wKf;
  private View wKg;
  private Animation wKh;
  private Animation wKi;
  private List<Integer> wKj;
  private List<String> wKk;
  private List<String> wKl;
  private Set<String> wKm;
  private List<Long> wKn;
  com.tencent.mm.plugin.fav.ui.g.a wKo;
  private com.tencent.mm.plugin.fav.ui.gallery.c wKp;
  private int[] wKq;
  private com.tencent.mm.plugin.fav.a.g wKr;
  private com.tencent.mm.plugin.fav.a.g wKs;
  private com.tencent.mm.plugin.fav.ui.widget.b wKt;
  private AdapterView.OnItemLongClickListener wKu;
  private ImageButton wLA;
  private MenuItem wLB;
  private aoe wLC;
  private com.tencent.mm.plugin.fav.ui.a.c wLv;
  private FavSearchActionView wLw;
  private ListView wLx;
  private FavCapacityPanel wLy;
  private View wLz;
  
  public FavSearchUI()
  {
    AppMethodBeat.i(106845);
    this.wKc = -1;
    this.wKm = new HashSet();
    this.wKn = new ArrayList();
    this.query = "";
    this.wKq = new int[2];
    this.wLC = new aoe();
    this.wKu = new AdapterView.OnItemLongClickListener()
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
  
  public static void al(Activity paramActivity)
  {
    AppMethodBeat.i(106852);
    f.a locala = new f.a(paramActivity);
    locala.bBl(paramActivity.getString(s.i.favorite_delete_selects_content_from_record_note));
    locala.bBp(paramActivity.getString(s.i.favorite_delete_confirm_btn));
    locala.b(new f.c()
    {
      public final void g(boolean paramAnonymousBoolean, String paramAnonymousString) {}
    });
    locala.show();
    AppMethodBeat.o(106852);
  }
  
  private boolean dkQ()
  {
    return this.wKc == 21;
  }
  
  private boolean dkR()
  {
    AppMethodBeat.i(106851);
    if (this.wJF.wNB)
    {
      dkS();
      AppMethodBeat.o(106851);
      return true;
    }
    if ((dkQ()) && (this.wKp.dlO()))
    {
      this.wKp.dlQ();
      AppMethodBeat.o(106851);
      return true;
    }
    AppMethodBeat.o(106851);
    return false;
  }
  
  private void dkS()
  {
    AppMethodBeat.i(106853);
    this.wJF.a(false, null);
    this.sxp.setOnItemLongClickListener(this.wKu);
    this.wKt.hide();
    if (dkQ()) {
      this.wKp.dlQ();
    }
    AppMethodBeat.o(106853);
  }
  
  private void dlg()
  {
    AppMethodBeat.i(106850);
    if (this.wLw != null)
    {
      AppMethodBeat.o(106850);
      return;
    }
    this.wLw = ((FavSearchActionView)View.inflate(getContext(), s.f.fav_search_actionview, null));
    this.wLz = this.wLw.findViewById(s.e.cancel_btn);
    this.wLz.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(106836);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fav/ui/FavSearchUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
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
    this.wLA = ((ImageButton)this.wLw.findViewById(s.e.search_clear_button));
    this.wLA.setVisibility(8);
    this.wLw.setOnSearchChangedListener(new FavSearchActionView.a()
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
            FavSearchUI.i(FavSearchUI.this).dQ(paramAnonymousList2);
            FavSearchUI.j(FavSearchUI.this).c(paramAnonymousList, paramAnonymousList1, paramAnonymousList2);
            FavSearchUI.b(FavSearchUI.this, false);
            AppMethodBeat.o(106837);
          }
        });
        if (paramAnonymousString != null)
        {
          FavSearchUI.a(FavSearchUI.this, paramAnonymousString);
          FavSearchUI.this.wKo.jQi = com.tencent.mm.plugin.fav.ui.g.a.getSearchId();
          FavSearchUI.this.wKo.wSC = System.currentTimeMillis();
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
        FavSearchUI.i(FavSearchUI.this).dQ(paramAnonymousList2);
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
      
      public final void bxI()
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
  
  private void gt(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(229299);
    this.wKo.actionType = paramInt1;
    if (this.wJF != null) {
      this.wKo.wGA = this.wJF.wGA;
    }
    switch (this.mlC)
    {
    default: 
      this.wKo.scene = 0;
      this.wKo.wSv = ((int)(System.currentTimeMillis() - this.lER) / 1000);
      this.wKo.query = this.query;
      if (this.wKj != null)
      {
        if (this.wKj.size() <= 0) {
          break label437;
        }
        switch (((Integer)this.wKj.get(0)).intValue())
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
          this.wKo.fXY = 0;
        }
      }
      break;
    }
    for (;;)
    {
      this.wKo.wSw = ((int)(this.wKo.wSD - this.wKo.wSC));
      this.wKo.wSy = String.format("%d", new Object[] { Integer.valueOf(paramInt2) });
      this.wKo.wSA = (this.wJF.getCount() - 1);
      this.wKo.report();
      AppMethodBeat.o(229299);
      return;
      this.wKo.scene = 1;
      break;
      this.wKo.scene = 2;
      break;
      this.wKo.scene = 3;
      break;
      this.wKo.fXY = 1;
      continue;
      this.wKo.fXY = 2;
      continue;
      this.wKo.fXY = 3;
      continue;
      this.wKo.fXY = 4;
      continue;
      this.wKo.fXY = 5;
      continue;
      this.wKo.fXY = 6;
      continue;
      this.wKo.fXY = 7;
      continue;
      this.wKo.fXY = 8;
      continue;
      label437:
      this.wKo.fXY = 0;
    }
  }
  
  public final void Kq(long paramLong)
  {
    AppMethodBeat.i(106857);
    com.tencent.mm.plugin.fav.ui.widget.b localb;
    if (this.wJF.wNB)
    {
      localb = this.wKt;
      if (this.wJF.dlw() <= 0) {
        break label47;
      }
    }
    label47:
    for (boolean bool = true;; bool = false)
    {
      localb.gR(bool);
      AppMethodBeat.o(106857);
      return;
    }
  }
  
  public int getLayoutId()
  {
    return s.f.fav_search_ui;
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
      dkR();
      AppMethodBeat.o(106858);
      return;
      if (paramInt2 != -1)
      {
        AppMethodBeat.o(106858);
        return;
      }
      Object localObject2 = this.wKp.wQE;
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
          if (com.tencent.mm.plugin.fav.a.k.v(((com.tencent.mm.plugin.fav.ui.gallery.d)localObject3).upg))
          {
            com.tencent.mm.ui.base.h.cO(getContext(), getString(s.i.Fav_NotDownload_CannotForward));
            AppMethodBeat.o(106858);
            return;
          }
          Log.d("MicroMsg.FavSearchUI", "select %s for sending", new Object[] { paramIntent });
          Object localObject4;
          Object localObject5;
          if ((((com.tencent.mm.plugin.fav.ui.gallery.d)localObject3).dlR()) || (((com.tencent.mm.plugin.fav.ui.gallery.d)localObject3).dlT()))
          {
            localObject4 = new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(106831);
                this.wJe.dismiss();
                AppMethodBeat.o(106831);
              }
            };
            localObject5 = ((List)localObject1).iterator();
            while (((Iterator)localObject5).hasNext()) {
              l.a(this, (String)((Iterator)localObject5).next(), ((com.tencent.mm.plugin.fav.ui.gallery.d)localObject3).fEd, (Runnable)localObject4);
            }
          }
          else
          {
            localObject4 = new ArrayList();
            ((ArrayList)localObject4).add(com.tencent.mm.plugin.fav.a.b.d(((com.tencent.mm.plugin.fav.ui.gallery.d)localObject3).fEd));
            localObject3 = ((List)localObject1).iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject5 = (String)((Iterator)localObject3).next();
              q.bmf().a(com.tencent.mm.model.z.bcZ(), (String)localObject5, (ArrayList)localObject4, s.d.chat_img_template);
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
          com.tencent.mm.plugin.messenger.a.g.eRW().ai((String)localObject1, str, ab.QZ((String)localObject1));
        }
        Log.d("MicroMsg.FavSearchUI", "select %s for sending", new Object[] { paramIntent });
        localObject1 = new ArrayList();
        ((List)localObject1).add(this.wKs);
        p.a(getContext(), (List)localObject1, str, paramIntent, "MicroMsg.FavSearchUI");
        continue;
        Log.d("MicroMsg.FavSearchUI", "select %s for sending", new Object[] { paramIntent });
        p.a(getContext(), this.wJF.nS(false), str, paramIntent, "MicroMsg.FavSearchUI");
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
      paramBundle.excludeTarget(getWindow().getDecorView().findViewById(s.e.action_bar_container), true);
      paramBundle.excludeTarget(16908335, true);
      getWindow().setEnterTransition(paramBundle);
    }
    this.mHandler = new MMHandler();
    setMMTitle("");
    setActionbarColor(getContext().getResources().getColor(s.b.normal_actionbar_color));
    this.mlC = getIntent().getIntExtra("key_search_type", 0);
    if (1 == this.mlC)
    {
      this.fsX = getIntent().getStringExtra("key_to_user");
      this.wKd = getIntent().getStringExtra("key_fav_item_id");
    }
    this.wKc = getIntent().getIntExtra("key_preset_search_type", -1);
    this.wLx = ((ListView)findViewById(s.e.tag_panel_list));
    this.sxp = ((ListView)findViewById(s.e.search_result_list));
    this.wKg = findViewById(s.e.search_empty_tv);
    this.wKh = AnimationUtils.loadAnimation(getContext(), s.a.panel_fade_in);
    this.wKi = AnimationUtils.loadAnimation(getContext(), s.a.panel_fade_out);
    dlg();
    this.wLy = ((FavCapacityPanel)View.inflate(getContext(), s.f.fav_capacity_foot_panel, null));
    this.wLy.wSI = getIntent().getIntExtra("key_enter_fav_search_from", 0);
    this.wLv = new com.tencent.mm.plugin.fav.ui.a.c(getContext())
    {
      public final void aAp(String paramAnonymousString)
      {
        AppMethodBeat.i(106841);
        FavSearchActionView localFavSearchActionView = FavSearchUI.d(FavSearchUI.this);
        localFavSearchActionView.wTg.add(paramAnonymousString);
        if (localFavSearchActionView.wMh == null)
        {
          AppMethodBeat.o(106841);
          return;
        }
        localFavSearchActionView.wMh.setEditHint("");
        localFavSearchActionView.wMh.bR(paramAnonymousString, true);
        if (localFavSearchActionView.wTi == null)
        {
          AppMethodBeat.o(106841);
          return;
        }
        localFavSearchActionView.aAz(localFavSearchActionView.wMh.getEditText());
        localFavSearchActionView.wTi.a(localFavSearchActionView.wND, localFavSearchActionView.wTh, localFavSearchActionView.wTg, false);
        com.tencent.mm.plugin.report.service.h.IzE.a(11126, new Object[] { Integer.valueOf(2) });
        AppMethodBeat.o(106841);
      }
      
      public final void aAq(String paramAnonymousString)
      {
        AppMethodBeat.i(106842);
        FavSearchActionView localFavSearchActionView = FavSearchUI.d(FavSearchUI.this);
        localFavSearchActionView.wTg.remove(paramAnonymousString);
        if (localFavSearchActionView.wMh == null)
        {
          AppMethodBeat.o(106842);
          return;
        }
        if (localFavSearchActionView.wTg.isEmpty()) {
          localFavSearchActionView.wMh.setEditHint(localFavSearchActionView.getResources().getString(s.i.app_search));
        }
        localFavSearchActionView.wMh.removeTag(paramAnonymousString);
        if (localFavSearchActionView.wTi == null)
        {
          AppMethodBeat.o(106842);
          return;
        }
        localFavSearchActionView.aAz(localFavSearchActionView.wMh.getEditText());
        localFavSearchActionView.wTi.a(localFavSearchActionView.wND, localFavSearchActionView.wTh, localFavSearchActionView.wTg, true);
        AppMethodBeat.o(106842);
      }
    };
    if (((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavTagSetMgr().djL() > 0)
    {
      paramBundle = (TextView)View.inflate(getContext(), s.f.fav_tag_panel_headerview, null);
      this.wLx.addHeaderView(paramBundle);
    }
    this.wLx.addFooterView(this.wLy);
    this.wLx.setAdapter(this.wLv);
    this.wLx.setOnTouchListener(new View.OnTouchListener()
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
    this.wJE = new o(getContext(), 16);
    getContext();
    this.wJF = new com.tencent.mm.plugin.fav.ui.a.b(this.wJE, false);
    this.wJF.wNI = this;
    this.wJF.scene = 2;
    this.wJF.wNL = this.sxp;
    if (1 == this.mlC)
    {
      this.wKe = new HashSet();
      this.wKf = new com.tencent.mm.plugin.fav.a.k();
      if (!Util.isNullOrNil(this.wKd))
      {
        paramBundle = this.wKd.split(",");
        int j = paramBundle.length;
        int i = 0;
        while (i < j)
        {
          int k = Util.getInt(paramBundle[i], 2147483647);
          if (2147483647 != k) {
            this.wKe.add(Integer.valueOf(k));
          }
          i += 1;
        }
      }
      this.wJF.k(this.wKe);
      this.wJF.a(this.wKf);
    }
    this.sxp.setAdapter(this.wJF);
    this.sxp.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, final int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(106818);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).sg(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).Fs(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fav/ui/FavSearchUI$10", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        localObject = (b.b)paramAnonymousView.getTag();
        if ((localObject != null) && (((b.b)localObject).wHw != null)) {
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
          if (((b.b)localObject).wHw == null)
          {
            Log.w("MicroMsg.FavSearchUI", "on item click, info is null");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavSearchUI$10", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(106818);
            return;
          }
          ((ac)com.tencent.mm.kernel.h.ae(ac.class)).a(FavSearchUI.this.getContext(), FavSearchUI.l(FavSearchUI.this), ((b.b)localObject).wHw, s.i.app_send, false, new y.a()
          {
            public final void a(boolean paramAnonymous2Boolean, String paramAnonymous2String, int paramAnonymous2Int)
            {
              AppMethodBeat.i(106816);
              FavSearchUI.this.hideVKB();
              if (paramAnonymous2Boolean)
              {
                final s locals = com.tencent.mm.ui.base.h.a(FavSearchUI.this.getContext(), FavSearchUI.this.getString(s.i.favorite_forward_tips), false, null);
                l.a(FavSearchUI.this.getContext(), FavSearchUI.l(FavSearchUI.this), paramAnonymous2String, this.wKy.wHw, new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(106815);
                    if (locals != null) {
                      locals.dismiss();
                    }
                    com.tencent.mm.ui.widget.snackbar.b.r(FavSearchUI.this, FavSearchUI.this.getString(s.i.fav_finish_sent));
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
            if (((b.b)localObject).wHw == null)
            {
              Log.w("MicroMsg.FavSearchUI", "on item click, info is null");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavSearchUI$10", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(106818);
              return;
            }
            paramAnonymousAdapterView = new Intent();
            paramAnonymousAdapterView.putExtra("key_fav_result_local_id", ((b.b)localObject).wHw.field_localId);
            paramAnonymousAdapterView.putExtra("key_fav_result_fake_local_id", ((b.b)localObject).wHw.fDQ);
            FavSearchUI.this.setResult(-1, paramAnonymousAdapterView);
            FavSearchUI.this.finish();
          }
          else
          {
            FavSearchUI.j(FavSearchUI.this).onItemClick(paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
            if (((b.b)localObject).wHw != null) {
              com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(106817);
                  Log.d("MicroMsg.FavSearchUI", "type %s", new Object[] { Integer.valueOf(this.wKy.wHw.field_type) });
                  long l = this.wKy.wHw.field_localId;
                  if (FavSearchUI.m(FavSearchUI.this).size() == 0) {
                    FavSearchUI.a(FavSearchUI.this, ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().dkf());
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
                  Object localObject = com.tencent.mm.plugin.report.service.h.IzE;
                  int j = this.wKy.wHw.field_type;
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
    this.sxp.setOnItemLongClickListener(this.wKu);
    this.sxp.setOnTouchListener(new View.OnTouchListener()
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
    this.wKt = new com.tencent.mm.plugin.fav.ui.widget.b();
    this.wKt.eo(findViewById(s.e.fav_edit_footer));
    this.wKt.wSW = new b.a()
    {
      public final void dkL()
      {
        AppMethodBeat.i(106825);
        List localList = FavSearchUI.j(FavSearchUI.this).nS(true);
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
          if (localg.wGh)
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
            FavSearchUI.al(FavSearchUI.this.getContext());
            AppMethodBeat.o(106825);
            return;
          }
          FavSearchUI.a(FavSearchUI.this, null, 0, (com.tencent.mm.plugin.fav.a.g)localList.get(0));
          AppMethodBeat.o(106825);
          return;
        }
        com.tencent.mm.ui.base.h.a(FavSearchUI.this.getContext(), FavSearchUI.this.getString(s.i.favorite_delete_items_confirm), "", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(106823);
            p.a(FavSearchUI.this.getContext(), localArrayList, new p.a()
            {
              public final void dla()
              {
                AppMethodBeat.i(106822);
                if (FavSearchUI.j(FavSearchUI.this) != null)
                {
                  Log.v("MicroMsg.FavSearchUI", "do refresh job");
                  FavSearchUI.j(FavSearchUI.this).dlt();
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
              FavSearchUI.al(FavSearchUI.this.getContext());
            }
            AppMethodBeat.o(106823);
          }
        }, null);
        AppMethodBeat.o(106825);
      }
      
      public final void dkY()
      {
        AppMethodBeat.i(106824);
        if (!FavoriteIndexUI.a(FavSearchUI.j(FavSearchUI.this).nS(false), FavSearchUI.this, new DialogInterface.OnClickListener()
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
      
      public final void dkZ() {}
    };
    this.wKp = new com.tencent.mm.plugin.fav.ui.gallery.c(this, findViewById(s.e.fav_media_history_gallery), this.wJE);
    ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavTagSetMgr().a(this.wLv);
    com.tencent.mm.kernel.h.aHJ().postToWorkerDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106832);
        FavSearchUI.a(FavSearchUI.this, ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().dkf());
        AppMethodBeat.o(106832);
      }
    }, 1000L);
    this.wKo = new com.tencent.mm.plugin.fav.ui.g.a();
    this.lER = System.currentTimeMillis();
    this.wKo.jQi = com.tencent.mm.plugin.fav.ui.g.a.getSearchId();
    this.wKo.wSC = this.lER;
    if (dkQ())
    {
      this.wLw.aj(this.wKc, false);
      this.sxp.setVisibility(8);
      this.wLx.setVisibility(8);
      this.wKp.setVisibility(0);
      this.wKp.dlN();
      AppMethodBeat.o(106846);
      return;
    }
    if (this.wKc > 0)
    {
      this.wLw.aj(this.wKc, true);
      this.wKp.setVisibility(8);
      this.sxp.setVisibility(0);
    }
    AppMethodBeat.o(106846);
  }
  
  @SuppressLint({"ResourceType"})
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(106849);
    Log.d("MicroMsg.FavSearchUI", "on create options menu");
    dlg();
    this.wLB = paramMenu.add(0, s.e.menu_search, 0, s.i.app_empty_string);
    this.wLB.setActionView(this.wLw);
    this.wLB.setShowAsAction(9);
    this.wLw.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106833);
        FavSearchActionView localFavSearchActionView = FavSearchUI.d(FavSearchUI.this);
        if (localFavSearchActionView.wMh != null) {
          localFavSearchActionView.wMh.hch();
        }
        FavSearchUI.this.showVKB();
        AppMethodBeat.o(106833);
      }
    });
    this.wLB.setOnActionExpandListener(new i.1(new i.a()
    {
      public final boolean gV()
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
    }));
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
    com.tencent.mm.plugin.fav.ui.g.a locala = this.wKo;
    if ((this.wKo.actionType != 1) && (this.wKo.actionType != 9)) {}
    for (boolean bool = true;; bool = false)
    {
      locala.wSE = bool;
      if (!this.wKo.wSE) {
        gt(1, 0);
      }
      this.wKp.onDestroy();
      super.onDestroy();
      this.wJE.destory();
      this.wJE = null;
      ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavTagSetMgr().a(this.wLv);
      ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavTagSetMgr().j(this.wKm);
      AppMethodBeat.o(106848);
      return;
    }
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(106847);
    if ((4 == paramInt) && (this.wJF.wNB))
    {
      dkS();
      AppMethodBeat.o(106847);
      return true;
    }
    if ((4 == paramInt) && (dkQ()) && (this.wKp.dlO()))
    {
      this.wKp.dlQ();
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
    i.azV(getClass().getSimpleName());
    if (dkQ()) {
      this.wKp.onPause();
    }
    super.onPause();
    AppMethodBeat.o(106856);
  }
  
  public void onResume()
  {
    long l = 0L;
    AppMethodBeat.i(106855);
    this.wJF.dlt();
    this.wJF.notifyDataSetChanged();
    FavCapacityPanel localFavCapacityPanel = this.wLy;
    if (localFavCapacityPanel.wSG != com.tencent.mm.plugin.fav.a.b.djn() / 1048576L)
    {
      localFavCapacityPanel.wSG = (com.tencent.mm.plugin.fav.a.b.djn() / 1048576L);
      TextView localTextView = localFavCapacityPanel.wSH;
      Context localContext = localFavCapacityPanel.wSH.getContext();
      int i = s.i.fav_capacity_info;
      if (localFavCapacityPanel.wSJ - localFavCapacityPanel.wSG > 0L) {
        l = localFavCapacityPanel.wSJ - localFavCapacityPanel.wSG;
      }
      localTextView.setText(localContext.getString(i, new Object[] { Long.valueOf(l), Long.valueOf(localFavCapacityPanel.wSG) }));
    }
    i.azU(getClass().getSimpleName());
    if (dkQ()) {
      this.wKp.onResume();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavSearchUI
 * JD-Core Version:    0.7.0.1
 */