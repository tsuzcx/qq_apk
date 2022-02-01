package com.tencent.mm.plugin.fav.ui;

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
import com.tencent.mm.model.ab;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.fav.a.ad;
import com.tencent.mm.plugin.fav.a.ah;
import com.tencent.mm.plugin.fav.a.i;
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
import com.tencent.mm.protocal.protobuf.arx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.ui.widget.a.g.c;
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
  private String AgA;
  private Set<Integer> AgB;
  private x AgC;
  private View AgD;
  private Animation AgE;
  private Animation AgF;
  private List<Integer> AgG;
  private List<String> AgH;
  private List<String> AgI;
  private Set<String> AgJ;
  private List<Long> AgK;
  com.tencent.mm.plugin.fav.ui.f.a AgL;
  private com.tencent.mm.plugin.fav.ui.gallery.c AgM;
  private int[] AgN;
  private com.tencent.mm.plugin.fav.a.g AgO;
  private com.tencent.mm.plugin.fav.a.g AgP;
  private com.tencent.mm.plugin.fav.ui.widget.b AgQ;
  private AdapterView.OnItemLongClickListener AgR;
  private FavoriteImageServer Aga;
  private com.tencent.mm.plugin.fav.ui.adapter.b Agb;
  private int Agz;
  private com.tencent.mm.plugin.fav.ui.adapter.c AhT;
  private FavSearchActionView AhU;
  private ListView AhV;
  private FavCapacityPanel AhW;
  private View AhX;
  private ImageButton AhY;
  private MenuItem AhZ;
  private arx Aia;
  private String hxm;
  private MMHandler mHandler;
  private long owx;
  private int pfo;
  private String query;
  private ListView vCW;
  
  public FavSearchUI()
  {
    AppMethodBeat.i(106845);
    this.Agz = -1;
    this.AgJ = new HashSet();
    this.AgK = new ArrayList();
    this.query = "";
    this.AgN = new int[2];
    this.Aia = new arx();
    this.AgR = new AdapterView.OnItemLongClickListener()
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
  
  public static void au(Activity paramActivity)
  {
    AppMethodBeat.i(106852);
    g.a locala = new g.a(paramActivity);
    locala.bDE(paramActivity.getString(q.i.favorite_delete_selects_content_from_record_note));
    locala.bDI(paramActivity.getString(q.i.favorite_delete_confirm_btn));
    locala.b(new g.c()
    {
      public final void onDialogClick(boolean paramAnonymousBoolean, String paramAnonymousString) {}
    });
    locala.show();
    AppMethodBeat.o(106852);
  }
  
  private boolean dRG()
  {
    return this.Agz == 21;
  }
  
  private boolean dRH()
  {
    AppMethodBeat.i(106851);
    if (this.Agb.Ake)
    {
      dRI();
      AppMethodBeat.o(106851);
      return true;
    }
    if ((dRG()) && (this.AgM.dSE()))
    {
      this.AgM.dSG();
      AppMethodBeat.o(106851);
      return true;
    }
    AppMethodBeat.o(106851);
    return false;
  }
  
  private void dRI()
  {
    AppMethodBeat.i(106853);
    this.Agb.a(false, null);
    this.vCW.setOnItemLongClickListener(this.AgR);
    this.AgQ.hide();
    if (dRG()) {
      this.AgM.dSG();
    }
    AppMethodBeat.o(106853);
  }
  
  private void dRW()
  {
    AppMethodBeat.i(106850);
    if (this.AhU != null)
    {
      AppMethodBeat.o(106850);
      return;
    }
    this.AhU = ((FavSearchActionView)View.inflate(getContext(), q.f.fav_search_actionview, null));
    this.AhX = this.AhU.findViewById(q.e.cancel_btn);
    this.AhX.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(106836);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fav/ui/FavSearchUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
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
    this.AhY = ((ImageButton)this.AhU.findViewById(q.e.search_clear_button));
    this.AhY.setVisibility(8);
    this.AhU.setOnSearchChangedListener(new FavSearchActionView.a()
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
            FavSearchUI.i(FavSearchUI.this).fL(paramAnonymousList2);
            FavSearchUI.j(FavSearchUI.this).c(paramAnonymousList, paramAnonymousList1, paramAnonymousList2);
            FavSearchUI.b(FavSearchUI.this, false);
            AppMethodBeat.o(106837);
          }
        });
        if (paramAnonymousString != null)
        {
          FavSearchUI.a(FavSearchUI.this, paramAnonymousString);
          FavSearchUI.this.AgL.mpa = com.tencent.mm.plugin.fav.ui.f.a.getSearchId();
          FavSearchUI.this.AgL.Apf = System.currentTimeMillis();
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
        FavSearchUI.i(FavSearchUI.this).fL(paramAnonymousList2);
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
      
      public final void bWx()
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
  
  private void hm(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(274392);
    this.AgL.actionType = paramInt1;
    if (this.Agb != null) {
      this.AgL.AcJ = this.Agb.AcJ;
    }
    switch (this.pfo)
    {
    default: 
      this.AgL.scene = 0;
      this.AgL.AoY = ((int)(System.currentTimeMillis() - this.owx) / 1000);
      this.AgL.query = this.query;
      if (this.AgG != null)
      {
        if (this.AgG.size() <= 0) {
          break label437;
        }
        switch (((Integer)this.AgG.get(0)).intValue())
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
          this.AgL.idY = 0;
        }
      }
      break;
    }
    for (;;)
    {
      this.AgL.AoZ = ((int)(this.AgL.Apg - this.AgL.Apf));
      this.AgL.Apb = String.format("%d", new Object[] { Integer.valueOf(paramInt2) });
      this.AgL.Apd = (this.Agb.getCount() - 1);
      this.AgL.report();
      AppMethodBeat.o(274392);
      return;
      this.AgL.scene = 1;
      break;
      this.AgL.scene = 2;
      break;
      this.AgL.scene = 3;
      break;
      this.AgL.idY = 1;
      continue;
      this.AgL.idY = 2;
      continue;
      this.AgL.idY = 3;
      continue;
      this.AgL.idY = 4;
      continue;
      this.AgL.idY = 5;
      continue;
      this.AgL.idY = 6;
      continue;
      this.AgL.idY = 7;
      continue;
      this.AgL.idY = 8;
      continue;
      label437:
      this.AgL.idY = 0;
    }
  }
  
  public int getLayoutId()
  {
    return q.f.fav_search_ui;
  }
  
  public final void mO(long paramLong)
  {
    AppMethodBeat.i(106857);
    com.tencent.mm.plugin.fav.ui.widget.b localb;
    if (this.Agb.Ake)
    {
      localb = this.AgQ;
      if (this.Agb.dSm() <= 0) {
        break label47;
      }
    }
    label47:
    for (boolean bool = true;; bool = false)
    {
      localb.hH(bool);
      AppMethodBeat.o(106857);
      return;
    }
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
      dRH();
      AppMethodBeat.o(106858);
      return;
      if (paramInt2 != -1)
      {
        AppMethodBeat.o(106858);
        return;
      }
      Object localObject2 = this.AgM.Anh;
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
          if (com.tencent.mm.plugin.fav.a.k.v(((com.tencent.mm.plugin.fav.ui.gallery.d)localObject3).xvD))
          {
            com.tencent.mm.ui.base.k.cZ(getContext(), getString(q.i.Fav_NotDownload_CannotForward));
            AppMethodBeat.o(106858);
            return;
          }
          Log.d("MicroMsg.FavSearchUI", "select %s for sending", new Object[] { paramIntent });
          Object localObject4;
          Object localObject5;
          if ((((com.tencent.mm.plugin.fav.ui.gallery.d)localObject3).dSH()) || (((com.tencent.mm.plugin.fav.ui.gallery.d)localObject3).dSJ()))
          {
            localObject4 = new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(106831);
                this.Afz.dismiss();
                AppMethodBeat.o(106831);
              }
            };
            localObject5 = ((List)localObject1).iterator();
            while (((Iterator)localObject5).hasNext()) {
              l.a(this, (String)((Iterator)localObject5).next(), ((com.tencent.mm.plugin.fav.ui.gallery.d)localObject3).hIT, (Runnable)localObject4);
            }
          }
          else
          {
            localObject4 = new ArrayList();
            ((ArrayList)localObject4).add(com.tencent.mm.plugin.fav.a.b.d(((com.tencent.mm.plugin.fav.ui.gallery.d)localObject3).hIT));
            localObject3 = ((List)localObject1).iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject5 = (String)((Iterator)localObject3).next();
              r.bJY().a(com.tencent.mm.model.z.bAM(), (String)localObject5, (ArrayList)localObject4, q.d.chat_img_template);
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
          com.tencent.mm.plugin.messenger.a.g.gaI().ap((String)localObject1, str, ab.IX((String)localObject1));
        }
        Log.d("MicroMsg.FavSearchUI", "select %s for sending", new Object[] { paramIntent });
        localObject1 = new ArrayList();
        ((List)localObject1).add(this.AgP);
        o.a(getContext(), (List)localObject1, str, paramIntent, "MicroMsg.FavSearchUI");
        continue;
        Log.d("MicroMsg.FavSearchUI", "select %s for sending", new Object[] { paramIntent });
        o.a(getContext(), this.Agb.ps(false), str, paramIntent, "MicroMsg.FavSearchUI");
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
      paramBundle.excludeTarget(getWindow().getDecorView().findViewById(q.e.action_bar_container), true);
      paramBundle.excludeTarget(16908335, true);
      getWindow().setEnterTransition(paramBundle);
    }
    this.mHandler = new MMHandler();
    setMMTitle("");
    setActionbarColor(getContext().getResources().getColor(q.b.normal_actionbar_color));
    this.pfo = getIntent().getIntExtra("key_search_type", 0);
    if (1 == this.pfo)
    {
      this.hxm = getIntent().getStringExtra("key_to_user");
      this.AgA = getIntent().getStringExtra("key_fav_item_id");
    }
    this.Agz = getIntent().getIntExtra("key_preset_search_type", -1);
    this.AhV = ((ListView)findViewById(q.e.tag_panel_list));
    this.vCW = ((ListView)findViewById(q.e.search_result_list));
    this.AgD = findViewById(q.e.search_empty_tv);
    this.AgE = AnimationUtils.loadAnimation(getContext(), q.a.panel_fade_in);
    this.AgF = AnimationUtils.loadAnimation(getContext(), q.a.panel_fade_out);
    dRW();
    this.AhW = ((FavCapacityPanel)View.inflate(getContext(), q.f.fav_capacity_foot_panel, null));
    this.AhW.Apl = getIntent().getIntExtra("key_enter_fav_search_from", 0);
    this.AhT = new com.tencent.mm.plugin.fav.ui.adapter.c(getContext())
    {
      public final void auw(String paramAnonymousString)
      {
        AppMethodBeat.i(106841);
        FavSearchActionView localFavSearchActionView = FavSearchUI.d(FavSearchUI.this);
        localFavSearchActionView.ApJ.add(paramAnonymousString);
        if (localFavSearchActionView.AiE == null)
        {
          AppMethodBeat.o(106841);
          return;
        }
        localFavSearchActionView.AiE.setEditHint("");
        localFavSearchActionView.AiE.cm(paramAnonymousString, true);
        if (localFavSearchActionView.ApL == null)
        {
          AppMethodBeat.o(106841);
          return;
        }
        localFavSearchActionView.auH(localFavSearchActionView.AiE.getEditText());
        localFavSearchActionView.ApL.a(localFavSearchActionView.Akg, localFavSearchActionView.ApK, localFavSearchActionView.ApJ, false);
        com.tencent.mm.plugin.report.service.h.OAn.b(11126, new Object[] { Integer.valueOf(2) });
        AppMethodBeat.o(106841);
      }
      
      public final void aux(String paramAnonymousString)
      {
        AppMethodBeat.i(106842);
        FavSearchActionView localFavSearchActionView = FavSearchUI.d(FavSearchUI.this);
        localFavSearchActionView.ApJ.remove(paramAnonymousString);
        if (localFavSearchActionView.AiE == null)
        {
          AppMethodBeat.o(106842);
          return;
        }
        if (localFavSearchActionView.ApJ.isEmpty()) {
          localFavSearchActionView.AiE.setEditHint(localFavSearchActionView.getResources().getString(q.i.app_search));
        }
        localFavSearchActionView.AiE.aue(paramAnonymousString);
        if (localFavSearchActionView.ApL == null)
        {
          AppMethodBeat.o(106842);
          return;
        }
        localFavSearchActionView.auH(localFavSearchActionView.AiE.getEditText());
        localFavSearchActionView.ApL.a(localFavSearchActionView.Akg, localFavSearchActionView.ApK, localFavSearchActionView.ApJ, true);
        AppMethodBeat.o(106842);
      }
    };
    if (((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavTagSetMgr().dQx() > 0)
    {
      paramBundle = (TextView)View.inflate(getContext(), q.f.fav_tag_panel_headerview, null);
      this.AhV.addHeaderView(paramBundle);
    }
    this.AhV.addFooterView(this.AhW);
    this.AhV.setAdapter(this.AhT);
    this.AhV.setOnTouchListener(new View.OnTouchListener()
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
    this.Aga = new FavoriteImageServer(getContext(), 16);
    getContext();
    this.Agb = new com.tencent.mm.plugin.fav.ui.adapter.b(this.Aga, false);
    this.Agb.Akl = this;
    this.Agb.scene = 2;
    this.Agb.Ako = this.vCW;
    if (1 == this.pfo)
    {
      this.AgB = new HashSet();
      this.AgC = new com.tencent.mm.plugin.fav.a.k();
      if (!Util.isNullOrNil(this.AgA))
      {
        paramBundle = this.AgA.split(",");
        int j = paramBundle.length;
        int i = 0;
        while (i < j)
        {
          int k = Util.getInt(paramBundle[i], 2147483647);
          if (2147483647 != k) {
            this.AgB.add(Integer.valueOf(k));
          }
          i += 1;
        }
      }
      this.Agb.r(this.AgB);
      this.Agb.a(this.AgC);
    }
    this.vCW.setAdapter(this.Agb);
    this.vCW.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, final int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(106818);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).sc(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).hB(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fav/ui/FavSearchUI$10", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        localObject = (b.b)paramAnonymousView.getTag();
        if ((localObject != null) && (((b.b)localObject).AdF != null)) {
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
          if (((b.b)localObject).AdF == null)
          {
            Log.w("MicroMsg.FavSearchUI", "on item click, info is null");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavSearchUI$10", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(106818);
            return;
          }
          ((ad)com.tencent.mm.kernel.h.ax(ad.class)).a(FavSearchUI.this.getContext(), FavSearchUI.l(FavSearchUI.this), ((b.b)localObject).AdF, q.i.app_send, false, new y.a()
          {
            public final void onDialogClick(boolean paramAnonymous2Boolean, String paramAnonymous2String, int paramAnonymous2Int)
            {
              AppMethodBeat.i(106816);
              FavSearchUI.this.hideVKB();
              if (paramAnonymous2Boolean)
              {
                final w localw = com.tencent.mm.ui.base.k.a(FavSearchUI.this.getContext(), FavSearchUI.this.getString(q.i.favorite_forward_tips), false, null);
                l.a(FavSearchUI.this.getContext(), FavSearchUI.l(FavSearchUI.this), paramAnonymous2String, this.AgV.AdF, new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(106815);
                    if (localw != null) {
                      localw.dismiss();
                    }
                    com.tencent.mm.ui.widget.snackbar.b.u(FavSearchUI.this, FavSearchUI.this.getString(q.i.fav_finish_sent));
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
            if (((b.b)localObject).AdF == null)
            {
              Log.w("MicroMsg.FavSearchUI", "on item click, info is null");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavSearchUI$10", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(106818);
              return;
            }
            paramAnonymousAdapterView = new Intent();
            paramAnonymousAdapterView.putExtra("key_fav_result_local_id", ((b.b)localObject).AdF.field_localId);
            paramAnonymousAdapterView.putExtra("key_fav_result_fake_local_id", ((b.b)localObject).AdF.hIG);
            FavSearchUI.this.setResult(-1, paramAnonymousAdapterView);
            FavSearchUI.this.finish();
          }
          else
          {
            FavSearchUI.j(FavSearchUI.this).onItemClick(paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
            if (((b.b)localObject).AdF != null) {
              com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(106817);
                  Log.d("MicroMsg.FavSearchUI", "type %s", new Object[] { Integer.valueOf(this.AgV.AdF.field_type) });
                  long l = this.AgV.AdF.field_localId;
                  if (FavSearchUI.m(FavSearchUI.this).size() == 0) {
                    FavSearchUI.a(FavSearchUI.this, ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().dQP());
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
                  Object localObject = com.tencent.mm.plugin.report.service.h.OAn;
                  int j = this.AgV.AdF.field_type;
                  int k = FavSearchUI.n(FavSearchUI.this);
                  if (FavSearchUI.m(FavSearchUI.this).size() == 0) {
                    i = paramAnonymousInt;
                  }
                  ((com.tencent.mm.plugin.report.service.h)localObject).b(12746, new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i) });
                  AppMethodBeat.o(106817);
                }
              });
            }
          }
        }
      }
    });
    this.vCW.setOnItemLongClickListener(this.AgR);
    this.vCW.setOnTouchListener(new View.OnTouchListener()
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
    this.AgQ = new com.tencent.mm.plugin.fav.ui.widget.b();
    this.AgQ.fj(findViewById(q.e.fav_edit_footer));
    this.AgQ.Apz = new b.a()
    {
      public final void dRB()
      {
        AppMethodBeat.i(106825);
        List localList = FavSearchUI.j(FavSearchUI.this).ps(true);
        if ((localList == null) || (localList.size() == 0))
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
          if (localg.Acq)
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
            FavSearchUI.au(FavSearchUI.this.getContext());
            AppMethodBeat.o(106825);
            return;
          }
          FavSearchUI.a(FavSearchUI.this, null, 0, (com.tencent.mm.plugin.fav.a.g)localList.get(0));
          AppMethodBeat.o(106825);
          return;
        }
        com.tencent.mm.ui.base.k.a(FavSearchUI.this.getContext(), FavSearchUI.this.getString(q.i.favorite_delete_items_confirm), "", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(106823);
            o.a(FavSearchUI.this.getContext(), localArrayList, new o.a()
            {
              public final void dRQ()
              {
                AppMethodBeat.i(106822);
                if (FavSearchUI.j(FavSearchUI.this) != null)
                {
                  Log.v("MicroMsg.FavSearchUI", "do refresh job");
                  FavSearchUI.j(FavSearchUI.this).dSj();
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
              FavSearchUI.au(FavSearchUI.this.getContext());
            }
            AppMethodBeat.o(106823);
          }
        }, null);
        AppMethodBeat.o(106825);
      }
      
      public final void dRO()
      {
        AppMethodBeat.i(106824);
        if (!FavoriteIndexUI.a(FavSearchUI.j(FavSearchUI.this).ps(false), FavSearchUI.this, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(106820);
            o.b(FavSearchUI.this.getContext(), 4105, FavSearchUI.j(FavSearchUI.this), FavSearchUI.o(FavSearchUI.this));
            AppMethodBeat.o(106820);
          }
        }))
        {
          AppMethodBeat.o(106824);
          return;
        }
        o.b(FavSearchUI.this.getContext(), 4105, FavSearchUI.j(FavSearchUI.this), FavSearchUI.o(FavSearchUI.this));
        AppMethodBeat.o(106824);
      }
      
      public final void dRP() {}
    };
    this.AgM = new com.tencent.mm.plugin.fav.ui.gallery.c(this, findViewById(q.e.fav_media_history_gallery), this.Aga);
    ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavTagSetMgr().a(this.AhT);
    com.tencent.mm.kernel.h.baH().postToWorkerDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106832);
        FavSearchUI.a(FavSearchUI.this, ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().dQP());
        AppMethodBeat.o(106832);
      }
    }, 1000L);
    this.AgL = new com.tencent.mm.plugin.fav.ui.f.a();
    this.owx = System.currentTimeMillis();
    this.AgL.mpa = com.tencent.mm.plugin.fav.ui.f.a.getSearchId();
    this.AgL.Apf = this.owx;
    if (dRG())
    {
      this.AhU.aA(this.Agz, false);
      this.vCW.setVisibility(8);
      this.AhV.setVisibility(8);
      this.AgM.setVisibility(0);
      this.AgM.dSD();
      AppMethodBeat.o(106846);
      return;
    }
    if (this.Agz > 0)
    {
      this.AhU.aA(this.Agz, true);
      this.AgM.setVisibility(8);
      this.vCW.setVisibility(0);
    }
    AppMethodBeat.o(106846);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(106849);
    Log.d("MicroMsg.FavSearchUI", "on create options menu");
    dRW();
    this.AhZ = paramMenu.add(0, q.e.menu_search, 0, q.i.app_empty_string);
    this.AhZ.setActionView(this.AhU);
    this.AhZ.setShowAsAction(9);
    this.AhU.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106833);
        FavSearchActionView localFavSearchActionView = FavSearchUI.d(FavSearchUI.this);
        if (localFavSearchActionView.AiE != null) {
          localFavSearchActionView.AiE.iCG();
        }
        FavSearchUI.this.showVKB();
        AppMethodBeat.o(106833);
      }
    });
    this.AhZ.setOnActionExpandListener(new i.1(new i.a()
    {
      public final boolean Ed()
      {
        return true;
      }
      
      public final boolean Ee()
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
    com.tencent.mm.plugin.fav.ui.f.a locala = this.AgL;
    if ((this.AgL.actionType != 1) && (this.AgL.actionType != 9)) {}
    for (boolean bool = true;; bool = false)
    {
      locala.Aph = bool;
      if (!this.AgL.Aph) {
        hm(1, 0);
      }
      this.AgM.onDestroy();
      super.onDestroy();
      this.Aga.destory();
      this.Aga = null;
      ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavTagSetMgr().a(this.AhT);
      ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavTagSetMgr().q(this.AgJ);
      AppMethodBeat.o(106848);
      return;
    }
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(106847);
    if ((4 == paramInt) && (this.Agb.Ake))
    {
      dRI();
      AppMethodBeat.o(106847);
      return true;
    }
    if ((4 == paramInt) && (dRG()) && (this.AgM.dSE()))
    {
      this.AgM.dSG();
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
    i.aub(getClass().getSimpleName());
    if (dRG()) {
      this.AgM.onPause();
    }
    super.onPause();
    AppMethodBeat.o(106856);
  }
  
  public void onResume()
  {
    long l = 0L;
    AppMethodBeat.i(106855);
    this.Agb.dSj();
    this.Agb.notifyDataSetChanged();
    FavCapacityPanel localFavCapacityPanel = this.AhW;
    if (localFavCapacityPanel.Apj != com.tencent.mm.plugin.fav.a.b.dPY() / 1048576L)
    {
      localFavCapacityPanel.Apj = (com.tencent.mm.plugin.fav.a.b.dPY() / 1048576L);
      TextView localTextView = localFavCapacityPanel.Apk;
      Context localContext = localFavCapacityPanel.Apk.getContext();
      int i = q.i.fav_capacity_info;
      if (localFavCapacityPanel.Apm - localFavCapacityPanel.Apj > 0L) {
        l = localFavCapacityPanel.Apm - localFavCapacityPanel.Apj;
      }
      localTextView.setText(localContext.getString(i, new Object[] { Long.valueOf(l), Long.valueOf(localFavCapacityPanel.Apj) }));
    }
    i.aua(getClass().getSimpleName());
    if (dRG()) {
      this.AgM.onResume();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavSearchUI
 * JD-Core Version:    0.7.0.1
 */