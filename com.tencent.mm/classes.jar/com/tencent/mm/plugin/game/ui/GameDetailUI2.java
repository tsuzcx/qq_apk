package com.tencent.mm.plugin.game.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.d.bk;
import com.tencent.mm.plugin.game.d.cc;
import com.tencent.mm.plugin.game.d.ce;
import com.tencent.mm.plugin.game.d.ch;
import com.tencent.mm.plugin.game.d.ci;
import com.tencent.mm.plugin.game.d.dr;
import com.tencent.mm.plugin.game.model.aa;
import com.tencent.mm.plugin.game.model.am;
import com.tencent.mm.plugin.game.model.k;
import com.tencent.mm.plugin.game.model.k.a;
import com.tencent.mm.plugin.game.model.w;
import com.tencent.mm.plugin.game.model.z.a;
import com.tencent.mm.plugin.game.widget.TextProgressBar;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.ab;
import com.tencent.mm.pluginsdk.ui.applet.ab.a;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GameDetailUI2
  extends MMActivity
  implements com.tencent.mm.ak.f
{
  private String appId;
  private Dialog qka;
  private com.tencent.mm.plugin.game.model.c umx;
  private int uoy;
  private String uyB;
  private String uyC;
  private int uyE;
  private boolean uyF;
  private boolean uyG;
  private String uyH;
  private k.a uyI;
  private d uyJ;
  private com.tencent.mm.plugin.game.model.l uyK;
  private ViewGroup uyL;
  private ImageView uyM;
  private ImageView uyN;
  private TextView uyO;
  private Button uyP;
  private TextProgressBar uyQ;
  private TextView uyR;
  private LinearLayout uyS;
  private GameDetailAutoScrollView uyT;
  private LinearLayout uyU;
  private TextView uyV;
  private LinearLayout uyW;
  private TextView uyX;
  private LinearLayout uyY;
  private ImageView uyZ;
  private View uza;
  private TextView uzb;
  private TextView uzc;
  private View uzd;
  private TextView uze;
  private ImageView uzf;
  private TextView uzg;
  private TextView uzh;
  private LinearLayout uzi;
  private GameMediaList uzj;
  private TextView uzk;
  private TextView uzl;
  private TextView uzm;
  private boolean uzn;
  private LinearLayout uzo;
  private TextView uzp;
  private LinearLayout uzq;
  private TextView uzr;
  private dr uzs;
  private DialogInterface.OnClickListener uzt;
  private View.OnClickListener uzu;
  private View.OnClickListener uzv;
  private View.OnClickListener uzw;
  private View.OnClickListener uzx;
  private View.OnClickListener uzy;
  private View.OnClickListener uzz;
  
  public GameDetailUI2()
  {
    AppMethodBeat.i(42029);
    this.appId = null;
    this.umx = null;
    this.uyB = null;
    this.uyC = null;
    this.uyE = 18;
    this.uoy = 0;
    this.uyH = null;
    this.uyI = null;
    this.uyJ = null;
    this.uyK = null;
    this.uzn = false;
    this.uzt = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(42026);
        GameDetailUI2.i(GameDetailUI2.this).ceA();
        GameDetailUI2.m(GameDetailUI2.this).a(GameDetailUI2.j(GameDetailUI2.this), GameDetailUI2.k(GameDetailUI2.this), GameDetailUI2.l(GameDetailUI2.this), GameDetailUI2.i(GameDetailUI2.this));
        AppMethodBeat.o(42026);
      }
    };
    this.uzu = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(42027);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameDetailUI2$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (GameDetailUI2.l(GameDetailUI2.this) == null)
        {
          ae.e("MicroMsg.GameDetailUI2", "Null appInfo");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameDetailUI2$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(42027);
          return;
        }
        if (GameDetailUI2.i(GameDetailUI2.this) == null)
        {
          ae.e("MicroMsg.GameDetailUI2", "No DownloadInfo found");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameDetailUI2$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(42027);
          return;
        }
        GameDetailUI2.i(GameDetailUI2.this).fC(GameDetailUI2.this.getContext());
        GameDetailUI2.m(GameDetailUI2.this).a(GameDetailUI2.l(GameDetailUI2.this), GameDetailUI2.i(GameDetailUI2.this));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameDetailUI2$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(42027);
      }
    };
    this.uzv = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(42028);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameDetailUI2$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        if ((paramAnonymousView.getTag() instanceof String))
        {
          com.tencent.mm.plugin.game.f.c.a(paramAnonymousView, GameDetailUI2.this);
          com.tencent.mm.game.report.f.a(GameDetailUI2.this.getContext(), 12, 1203, 999, 7, GameDetailUI2.f(GameDetailUI2.this), GameDetailUI2.g(GameDetailUI2.this), null);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameDetailUI2$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(42028);
          return;
          localObject = new GameDetailRankUI.a();
          ((GameDetailRankUI.a)localObject).uyB = GameDetailUI2.n(GameDetailUI2.this);
          ((GameDetailRankUI.a)localObject).uyC = GameDetailUI2.o(GameDetailUI2.this);
          ((GameDetailRankUI.a)localObject).uyD = GameDetailUI2.l(GameDetailUI2.this);
          paramAnonymousView = com.tencent.mm.model.z.Br("rankData");
          com.tencent.mm.model.z.aBG().F(paramAnonymousView, true).k(GameDetailRankUI.uyz, localObject);
          localObject = new Intent(GameDetailUI2.this.getContext(), GameDetailRankUI.class);
          ((Intent)localObject).putExtra(GameDetailRankUI.EXTRA_SESSION_ID, paramAnonymousView);
          paramAnonymousView = GameDetailUI2.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/game/ui/GameDetailUI2$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/game/ui/GameDetailUI2$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.game.report.f.a(GameDetailUI2.this.getContext(), 12, 1203, 999, 6, GameDetailUI2.f(GameDetailUI2.this), GameDetailUI2.g(GameDetailUI2.this), null);
        }
      }
    };
    this.uzw = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(42011);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameDetailUI2$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        com.tencent.mm.plugin.game.f.c.a(paramAnonymousView, GameDetailUI2.this);
        com.tencent.mm.game.report.f.a(GameDetailUI2.this.getContext(), 12, 1204, 999, 7, GameDetailUI2.f(GameDetailUI2.this), GameDetailUI2.g(GameDetailUI2.this), null);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameDetailUI2$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(42011);
      }
    };
    this.uzx = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(42012);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameDetailUI2$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        com.tencent.mm.plugin.game.f.c.a(paramAnonymousView, GameDetailUI2.this);
        com.tencent.mm.game.report.f.a(GameDetailUI2.this.getContext(), 12, 1205, 1, 7, GameDetailUI2.f(GameDetailUI2.this), GameDetailUI2.g(GameDetailUI2.this), null);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameDetailUI2$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(42012);
      }
    };
    this.uzy = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(42013);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameDetailUI2$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        com.tencent.mm.plugin.game.f.c.a(paramAnonymousView, GameDetailUI2.this);
        com.tencent.mm.game.report.f.a(GameDetailUI2.this.getContext(), 12, 1205, 999, 7, GameDetailUI2.f(GameDetailUI2.this), GameDetailUI2.g(GameDetailUI2.this), null);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameDetailUI2$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(42013);
      }
    };
    this.uzz = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(42014);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameDetailUI2$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        com.tencent.mm.plugin.game.f.c.a(paramAnonymousView, GameDetailUI2.this);
        com.tencent.mm.game.report.f.a(GameDetailUI2.this.getContext(), 12, 1206, 1, 7, GameDetailUI2.f(GameDetailUI2.this), GameDetailUI2.g(GameDetailUI2.this), null);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameDetailUI2$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(42014);
      }
    };
    AppMethodBeat.o(42029);
  }
  
  private void a(com.tencent.mm.plugin.game.model.z paramz)
  {
    AppMethodBeat.i(42038);
    Object localObject1 = null;
    if ((paramz.uoG.uoH == null) || (paramz.uoG.uoH.size() == 0)) {
      localObject1 = paramz.uoE.utq;
    }
    if ((localObject1 == null) || (((LinkedList)localObject1).size() == 0))
    {
      this.uyS.setVisibility(8);
      AppMethodBeat.o(42038);
      return;
    }
    this.uyS.setVisibility(0);
    this.uyS.removeAllViews();
    paramz = ((LinkedList)localObject1).iterator();
    if (paramz.hasNext())
    {
      localObject1 = (com.tencent.mm.plugin.game.d.ad)paramz.next();
      View localView = LayoutInflater.from(getContext()).inflate(2131494290, this.uyS, false);
      ImageView localImageView = (ImageView)localView.findViewById(2131300428);
      TextView localTextView1 = (TextView)localView.findViewById(2131300429);
      TextView localTextView2 = (TextView)localView.findViewById(2131300427);
      if (!bu.isNullOrNil(((com.tencent.mm.plugin.game.d.ad)localObject1).nIJ)) {
        a.b.a(localImageView, ((com.tencent.mm.plugin.game.d.ad)localObject1).nIJ, 0.5F, false);
      }
      for (;;)
      {
        localTextView1.setText(((com.tencent.mm.plugin.game.d.ad)localObject1).Title);
        localTextView2.setText(((com.tencent.mm.plugin.game.d.ad)localObject1).urL);
        this.uyS.addView(localView);
        break;
        Object localObject2 = new c.a();
        ((c.a)localObject2).hhW = true;
        localObject2 = ((c.a)localObject2).aJu();
        com.tencent.mm.av.q.aJb().a(((com.tencent.mm.plugin.game.d.ad)localObject1).uqq, localImageView, (com.tencent.mm.av.a.a.c)localObject2);
      }
    }
    AppMethodBeat.o(42038);
  }
  
  private void b(aa paramaa)
  {
    int i = 0;
    AppMethodBeat.i(42037);
    List localList = paramaa.uoH;
    if ((localList == null) || (localList.size() == 0))
    {
      this.uyU.setVisibility(8);
      this.uyV.setVisibility(8);
      AppMethodBeat.o(42037);
      return;
    }
    this.uyU.setVisibility(0);
    if (localList.size() > 3) {
      this.uyV.setVisibility(0);
    }
    for (;;)
    {
      this.uyU.removeAllViews();
      i locali = new i(getContext());
      locali.UR = 2131494287;
      locali.a(paramaa);
      locali.uoy = this.uoy;
      while ((i < localList.size()) && (i < 3))
      {
        paramaa = locali.getView(i, null, this.uyS);
        this.uyU.addView(paramaa);
        i += 1;
      }
      this.uyV.setVisibility(8);
    }
    AppMethodBeat.o(42037);
  }
  
  private void b(com.tencent.mm.plugin.game.model.z paramz)
  {
    AppMethodBeat.i(42039);
    if ((paramz.dbY() != null) && (!paramz.dbY().isEmpty()))
    {
      this.uyW.setVisibility(0);
      if (!bu.isNullOrNil(paramz.dbX()))
      {
        this.uyX.setVisibility(0);
        this.uyX.setText(paramz.dbX());
        this.uyY.removeAllViews();
        if (paramz.dbZ() != 1) {
          break label271;
        }
        this.uyY.setOrientation(1);
        this.uyZ.setVisibility(8);
      }
      Object localObject;
      for (int i = 2131494282;; i = 2131494281)
      {
        localObject = paramz.dbY();
        if (localObject == null) {
          break label294;
        }
        localObject = ((LinkedList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          com.tencent.mm.plugin.game.model.z.b localb = (com.tencent.mm.plugin.game.model.z.b)((Iterator)localObject).next();
          View localView = LayoutInflater.from(getContext()).inflate(i, this.uyY, false);
          ImageView localImageView = (ImageView)localView.findViewById(2131300390);
          com.tencent.mm.av.q.aJb().loadImage(localb.dEM, localImageView);
          if (paramz.dbZ() == 1) {
            ((TextView)localView.findViewById(2131300391)).setText(localb.title);
          }
          ((TextView)localView.findViewById(2131300389)).setText(localb.desc);
          if (paramz.dbZ() == 1)
          {
            localView.setTag(localb.url);
            localView.setOnClickListener(this.uzw);
          }
          this.uyY.addView(localView);
        }
        this.uyX.setVisibility(8);
        break;
        label271:
        this.uyY.setOrientation(0);
        this.uyZ.setVisibility(0);
      }
      label294:
      if (paramz.uoE.uty != null)
      {
        localObject = new z.a();
        ((z.a)localObject).title = paramz.uoE.uty.summary;
        ((z.a)localObject).desc = paramz.uoE.uty.desc;
        ((z.a)localObject).url = paramz.uoE.uty.url;
        paramz = (com.tencent.mm.plugin.game.model.z)localObject;
        if (paramz == null) {
          break label537;
        }
        this.uza.setVisibility(0);
        this.uzb.setText(paramz.title);
        if (bu.isNullOrNil(paramz.desc)) {
          break label525;
        }
        this.uzc.setVisibility(0);
        this.uzc.setText(paramz.desc);
      }
      for (;;)
      {
        this.uza.setTag(paramz.url);
        this.uza.setOnClickListener(this.uzw);
        AppMethodBeat.o(42039);
        return;
        if ((paramz.uoE.utt != null) && (!bu.isNullOrNil(paramz.uoE.utt.uuh)) && (!bu.isNullOrNil(paramz.uoE.utt.uui)))
        {
          localObject = new z.a();
          ((z.a)localObject).title = paramz.uoE.utt.uuh;
          ((z.a)localObject).url = paramz.uoE.utt.uui;
          paramz = (com.tencent.mm.plugin.game.model.z)localObject;
          break;
        }
        paramz = null;
        break;
        label525:
        this.uzc.setVisibility(8);
      }
      label537:
      this.uza.setVisibility(8);
      AppMethodBeat.o(42039);
      return;
    }
    this.uyW.setVisibility(8);
    AppMethodBeat.o(42039);
  }
  
  private void c(com.tencent.mm.plugin.game.model.z paramz)
  {
    AppMethodBeat.i(42040);
    if ((paramz.dcd() != null) && (!paramz.dcd().isEmpty()))
    {
      this.uzo.setVisibility(0);
      if (!bu.isNullOrNil(paramz.dcc()))
      {
        this.uzp.setVisibility(0);
        this.uzp.setText(paramz.dcc());
      }
      for (;;)
      {
        this.uzq.removeAllViews();
        this.uzq.setOnClickListener(null);
        Iterator localIterator = paramz.dcd().iterator();
        while (localIterator.hasNext())
        {
          ci localci = (ci)localIterator.next();
          View localView = LayoutInflater.from(getContext()).inflate(2131494283, this.uzq, false);
          TextView localTextView1 = (TextView)localView.findViewById(2131300403);
          TextView localTextView2 = (TextView)localView.findViewById(2131300404);
          TextView localTextView3 = (TextView)localView.findViewById(2131300401);
          ImageView localImageView = (ImageView)localView.findViewById(2131300402);
          localTextView1.setText(localci.uum);
          localTextView2.setText(localci.Title);
          localTextView3.setText(localci.urL);
          com.tencent.mm.av.q.aJb().loadImage(localci.uuj, localImageView);
          localView.setTag(localci.uqi);
          localView.setOnClickListener(this.uzx);
          this.uzq.addView(localView);
        }
        this.uzp.setVisibility(8);
      }
      if (paramz.uoE.utt == null) {
        paramz = null;
      }
      while (paramz != null)
      {
        this.uzr.setVisibility(0);
        this.uzr.setText((CharSequence)paramz.first);
        this.uzr.setTag(paramz.second);
        this.uzr.setOnClickListener(this.uzy);
        AppMethodBeat.o(42040);
        return;
        if ((bu.isNullOrNil(paramz.uoE.uts.Title)) || (bu.isNullOrNil(paramz.uoE.uts.uui))) {
          paramz = null;
        } else {
          paramz = new Pair(paramz.uoE.uts.uuh, paramz.uoE.uts.uui);
        }
      }
      this.uzr.setVisibility(8);
      AppMethodBeat.o(42040);
      return;
    }
    this.uzo.setVisibility(8);
    AppMethodBeat.o(42040);
  }
  
  private void dcG()
  {
    AppMethodBeat.i(42035);
    Object localObject = getIntent().getStringExtra("jump_game_center");
    if ((!bu.isNullOrNil((String)localObject)) && (((String)localObject).equals("jump_game_center")))
    {
      localObject = new Intent(this, GameCenterUI.class);
      ((Intent)localObject).putExtra("jump_find_more_friends", "jump_find_more_friends");
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/game/ui/GameDetailUI2", "backToGameCenterUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameDetailUI2", "backToGameCenterUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    AppMethodBeat.o(42035);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(42034);
    dcG();
    finish();
    AppMethodBeat.o(42034);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131494279;
  }
  
  public void initView()
  {
    AppMethodBeat.i(42036);
    setMMTitle(2131759859);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(42010);
        GameDetailUI2.a(GameDetailUI2.this);
        AppMethodBeat.o(42010);
        return true;
      }
    });
    this.uyL = ((ViewGroup)findViewById(2131300374));
    this.uyM = ((ImageView)findViewById(2131300375));
    this.uyN = ((ImageView)findViewById(2131300462));
    this.uyO = ((TextView)findViewById(2131300524));
    this.uyR = ((TextView)findViewById(2131300469));
    this.uyP = ((Button)findViewById(2131300344));
    this.uyQ = ((TextProgressBar)findViewById(2131300538));
    this.uyQ.setTextSize(this.uyE);
    this.uyS = ((LinearLayout)findViewById(2131300426));
    this.uyT = ((GameDetailAutoScrollView)findViewById(2131300425));
    this.uyU = ((LinearLayout)findViewById(2131300407));
    this.uyV = ((TextView)findViewById(2131300409));
    this.uyW = ((LinearLayout)findViewById(2131300383));
    this.uyX = ((TextView)findViewById(2131300392));
    this.uyY = ((LinearLayout)findViewById(2131300384));
    this.uyZ = ((ImageView)findViewById(2131300385));
    this.uza = findViewById(2131300386);
    this.uzb = ((TextView)findViewById(2131300388));
    this.uzc = ((TextView)findViewById(2131300387));
    this.uzd = findViewById(2131300393);
    this.uze = ((TextView)findViewById(2131300397));
    this.uzf = ((ImageView)findViewById(2131300396));
    this.uzg = ((TextView)findViewById(2131300394));
    this.uzh = ((TextView)findViewById(2131300395));
    this.uzi = ((LinearLayout)findViewById(2131300378));
    this.uzj = ((GameMediaList)findViewById(2131300406));
    GameMediaList localGameMediaList = this.uzj;
    String str = this.appId;
    int i = this.uoy;
    localGameMediaList.appId = str;
    localGameMediaList.roH = 12;
    localGameMediaList.uAR = i;
    localGameMediaList.mContext = this;
    this.uzj.setItemLayout(2131494344);
    this.uzk = ((TextView)findViewById(2131300381));
    this.uzl = ((TextView)findViewById(2131300379));
    this.uzl.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(42019);
        if (GameDetailUI2.b(GameDetailUI2.this).getLineCount() > 3)
        {
          GameDetailUI2.c(GameDetailUI2.this).setVisibility(0);
          AppMethodBeat.o(42019);
          return;
        }
        GameDetailUI2.c(GameDetailUI2.this).setVisibility(8);
        AppMethodBeat.o(42019);
      }
    });
    this.uzm = ((TextView)findViewById(2131300382));
    this.uzm.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(42020);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameDetailUI2$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (!GameDetailUI2.d(GameDetailUI2.this))
        {
          GameDetailUI2.b(GameDetailUI2.this).setMaxLines(100);
          GameDetailUI2.c(GameDetailUI2.this).setText(GameDetailUI2.this.getResources().getText(2131759845));
          GameDetailUI2.a(GameDetailUI2.this, true);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameDetailUI2$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(42020);
          return;
          GameDetailUI2.b(GameDetailUI2.this).setMaxLines(3);
          GameDetailUI2.c(GameDetailUI2.this).setText(GameDetailUI2.this.getResources().getText(2131759844));
          GameDetailUI2.a(GameDetailUI2.this, false);
        }
      }
    });
    this.uzo = ((LinearLayout)findViewById(2131300398));
    this.uzp = ((TextView)findViewById(2131300405));
    this.uzq = ((LinearLayout)findViewById(2131300399));
    this.uzr = ((TextView)findViewById(2131300400));
    AppMethodBeat.o(42036);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(42042);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ae.i("MicroMsg.GameDetailUI2", "requestCode = %d, resultCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    switch (paramInt1)
    {
    default: 
      ae.e("MicroMsg.GameDetailUI2", "error request code");
      AppMethodBeat.o(42042);
      return;
    case 1: 
      switch (paramInt2)
      {
      case 1: 
      default: 
        AppMethodBeat.o(42042);
        return;
      case 3: 
        if (this.uyK != null)
        {
          this.uyK.ceA();
          AppMethodBeat.o(42042);
          return;
        }
        break;
      case 2: 
        if ((this.umx != null) && (this.uyK != null))
        {
          this.uyK.dbC();
          this.uyJ.a(this.umx, this.uyK);
          AppMethodBeat.o(42042);
          return;
        }
        break;
      case 0: 
        AppMethodBeat.o(42042);
        return;
      }
      break;
    case 2: 
      if (paramInt2 == -1)
      {
        final String str2 = paramIntent.getStringExtra("Select_Conv_User");
        if (!bu.isNullOrNil(str2))
        {
          String str1 = this.uzs.uqq;
          paramIntent = str1;
          if (bu.isNullOrNil(str1)) {
            paramIntent = this.umx.field_appIconUrl;
          }
          ab.a.Fpw.a(this.mController, this.uzs.uvh, paramIntent, this.uzs.uvi, true, getResources().getString(2131755884), new y.a()
          {
            public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
            {
              AppMethodBeat.i(42018);
              if (paramAnonymousBoolean)
              {
                GameDetailUI2.a(GameDetailUI2.this, str2, paramAnonymousString);
                com.tencent.mm.ui.base.h.cm(GameDetailUI2.this, GameDetailUI2.this.getResources().getString(2131757561));
                com.tencent.mm.game.report.f.a(GameDetailUI2.this.getContext(), 12, 1207, 2, 14, GameDetailUI2.f(GameDetailUI2.this), GameDetailUI2.g(GameDetailUI2.this), null);
                AppMethodBeat.o(42018);
                return;
              }
              AppMethodBeat.o(42018);
            }
          });
        }
        AppMethodBeat.o(42042);
        return;
      }
      break;
    case 3: 
      if (paramInt2 == -1)
      {
        com.tencent.mm.game.report.f.a(getContext(), 12, 1207, 2, 15, this.appId, this.uoy, null);
        AppMethodBeat.o(42042);
        return;
      }
      break;
    }
    AppMethodBeat.o(42042);
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(42030);
    super.onCreate(paramBundle);
    if (!g.ajM())
    {
      ae.e("MicroMsg.GameDetailUI2", "account not ready");
      finish();
      AppMethodBeat.o(42030);
      return;
    }
    this.uyF = true;
    this.uyG = false;
    this.appId = getIntent().getStringExtra("game_app_id");
    if (bu.isNullOrNil(this.appId))
    {
      ae.e("MicroMsg.GameDetailUI2", "appid is null or nill");
      finish();
      initView();
      g.ajj().a(1217, this);
      paramBundle = ((com.tencent.mm.plugin.game.api.f)g.ab(com.tencent.mm.plugin.game.api.f.class)).cZm().amj(this.appId);
      if ((paramBundle != null) && (paramBundle.length != 0)) {
        break label220;
      }
      ae.i("MicroMsg.GameDetailUI2", "No cache found");
    }
    for (int i = 0;; i = 1)
    {
      if (i == 0)
      {
        this.qka = com.tencent.mm.plugin.game.f.c.fF(this);
        this.qka.show();
      }
      paramBundle = com.tencent.mm.sdk.platformtools.ad.fom();
      boolean bool = com.tencent.mm.pluginsdk.model.app.h.s(this, this.appId);
      paramBundle = new am(paramBundle, this.appId, bool);
      g.ajj().a(paramBundle, 0);
      AppMethodBeat.o(42030);
      return;
      this.uoy = getIntent().getIntExtra("game_report_from_scene", 0);
      break;
      label220:
      g.ajU().aw(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(42022);
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(42021);
              GameDetailUI2.a(GameDetailUI2.this, this.uzD);
              AppMethodBeat.o(42021);
            }
          });
          AppMethodBeat.o(42022);
        }
      });
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(42032);
    super.onDestroy();
    g.ajj().b(1217, this);
    if (this.uyI != null) {
      k.b(this.uyI);
    }
    AppMethodBeat.o(42032);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(42033);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      goBack();
      AppMethodBeat.o(42033);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(42033);
    return bool;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(42031);
    super.onResume();
    if ((this.umx != null) && (this.uyK != null))
    {
      this.uyK.ceA();
      this.uyJ.a(this.uyQ, this.uyP, this.umx, this.uyK);
    }
    if (!this.uyF)
    {
      b(new aa(this.appId));
      AppMethodBeat.o(42031);
      return;
    }
    this.uyF = false;
    AppMethodBeat.o(42031);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, n paramn)
  {
    AppMethodBeat.i(42041);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      if (!com.tencent.mm.plugin.game.a.a.iUA.a(this, paramInt1, paramInt2, paramString)) {
        Toast.makeText(this, getString(2131759916, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      }
      if (this.qka != null) {
        this.qka.cancel();
      }
      AppMethodBeat.o(42041);
      return;
    }
    switch (paramn.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(42041);
      return;
      paramString = ((am)paramn).gux.hQE.hQJ;
      g.ajU().aw(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(42025);
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(42024);
              GameDetailUI2.a(GameDetailUI2.this, this.uzD);
              if (GameDetailUI2.h(GameDetailUI2.this) != null) {
                GameDetailUI2.h(GameDetailUI2.this).dismiss();
              }
              AppMethodBeat.o(42024);
            }
          });
          AppMethodBeat.o(42025);
        }
      });
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDetailUI2
 * JD-Core Version:    0.7.0.1
 */