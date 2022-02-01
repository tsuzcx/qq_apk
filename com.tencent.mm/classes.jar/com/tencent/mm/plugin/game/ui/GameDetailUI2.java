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
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.y.b;
import com.tencent.mm.plugin.game.d.bd;
import com.tencent.mm.plugin.game.d.bv;
import com.tencent.mm.plugin.game.d.bx;
import com.tencent.mm.plugin.game.d.ca;
import com.tencent.mm.plugin.game.d.cb;
import com.tencent.mm.plugin.game.d.dj;
import com.tencent.mm.plugin.game.model.aa;
import com.tencent.mm.plugin.game.model.am;
import com.tencent.mm.plugin.game.model.k;
import com.tencent.mm.plugin.game.model.k.a;
import com.tencent.mm.plugin.game.model.w;
import com.tencent.mm.plugin.game.model.z;
import com.tencent.mm.plugin.game.model.z.a;
import com.tencent.mm.plugin.game.model.z.b;
import com.tencent.mm.plugin.game.widget.TextProgressBar;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.ab;
import com.tencent.mm.pluginsdk.ui.applet.ab.a;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GameDetailUI2
  extends MMActivity
  implements com.tencent.mm.al.f
{
  private String appId;
  private Dialog qdv;
  private com.tencent.mm.plugin.game.model.c ubv;
  private int udq;
  private LinearLayout unA;
  private TextView unB;
  private LinearLayout unC;
  private ImageView unD;
  private View unE;
  private TextView unF;
  private TextView unG;
  private View unH;
  private TextView unI;
  private ImageView unJ;
  private TextView unK;
  private TextView unL;
  private LinearLayout unM;
  private GameMediaList unN;
  private TextView unO;
  private TextView unP;
  private TextView unQ;
  private boolean unR;
  private LinearLayout unS;
  private TextView unT;
  private LinearLayout unU;
  private TextView unV;
  private dj unW;
  private DialogInterface.OnClickListener unX;
  private View.OnClickListener unY;
  private View.OnClickListener unZ;
  private String unf;
  private String ung;
  private int uni;
  private boolean unj;
  private boolean unk;
  private String unl;
  private k.a unm;
  private d unn;
  private com.tencent.mm.plugin.game.model.l uno;
  private ViewGroup unp;
  private ImageView unq;
  private ImageView unr;
  private TextView uns;
  private Button unt;
  private TextProgressBar unu;
  private TextView unv;
  private LinearLayout unw;
  private GameDetailAutoScrollView unx;
  private LinearLayout uny;
  private TextView unz;
  private View.OnClickListener uoa;
  private View.OnClickListener uob;
  private View.OnClickListener uoc;
  private View.OnClickListener uod;
  
  public GameDetailUI2()
  {
    AppMethodBeat.i(42029);
    this.appId = null;
    this.ubv = null;
    this.unf = null;
    this.ung = null;
    this.uni = 18;
    this.udq = 0;
    this.unl = null;
    this.unm = null;
    this.unn = null;
    this.uno = null;
    this.unR = false;
    this.unX = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(42026);
        GameDetailUI2.i(GameDetailUI2.this).cdl();
        GameDetailUI2.m(GameDetailUI2.this).a(GameDetailUI2.j(GameDetailUI2.this), GameDetailUI2.k(GameDetailUI2.this), GameDetailUI2.l(GameDetailUI2.this), GameDetailUI2.i(GameDetailUI2.this));
        AppMethodBeat.o(42026);
      }
    };
    this.unY = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(42027);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameDetailUI2$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (GameDetailUI2.l(GameDetailUI2.this) == null)
        {
          ad.e("MicroMsg.GameDetailUI2", "Null appInfo");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameDetailUI2$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(42027);
          return;
        }
        if (GameDetailUI2.i(GameDetailUI2.this) == null)
        {
          ad.e("MicroMsg.GameDetailUI2", "No DownloadInfo found");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameDetailUI2$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(42027);
          return;
        }
        GameDetailUI2.i(GameDetailUI2.this).fy(GameDetailUI2.this.getContext());
        GameDetailUI2.m(GameDetailUI2.this).a(GameDetailUI2.l(GameDetailUI2.this), GameDetailUI2.i(GameDetailUI2.this));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameDetailUI2$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(42027);
      }
    };
    this.unZ = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(42028);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameDetailUI2$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
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
          ((GameDetailRankUI.a)localObject).unf = GameDetailUI2.n(GameDetailUI2.this);
          ((GameDetailRankUI.a)localObject).ung = GameDetailUI2.o(GameDetailUI2.this);
          ((GameDetailRankUI.a)localObject).unh = GameDetailUI2.l(GameDetailUI2.this);
          paramAnonymousView = com.tencent.mm.model.y.AH("rankData");
          com.tencent.mm.model.y.aBq().F(paramAnonymousView, true).k(GameDetailRankUI.und, localObject);
          localObject = new Intent(GameDetailUI2.this.getContext(), GameDetailRankUI.class);
          ((Intent)localObject).putExtra(GameDetailRankUI.EXTRA_SESSION_ID, paramAnonymousView);
          paramAnonymousView = GameDetailUI2.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/game/ui/GameDetailUI2$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/game/ui/GameDetailUI2$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.game.report.f.a(GameDetailUI2.this.getContext(), 12, 1203, 999, 6, GameDetailUI2.f(GameDetailUI2.this), GameDetailUI2.g(GameDetailUI2.this), null);
        }
      }
    };
    this.uoa = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(42011);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameDetailUI2$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        com.tencent.mm.plugin.game.f.c.a(paramAnonymousView, GameDetailUI2.this);
        com.tencent.mm.game.report.f.a(GameDetailUI2.this.getContext(), 12, 1204, 999, 7, GameDetailUI2.f(GameDetailUI2.this), GameDetailUI2.g(GameDetailUI2.this), null);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameDetailUI2$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(42011);
      }
    };
    this.uob = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(42012);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameDetailUI2$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        com.tencent.mm.plugin.game.f.c.a(paramAnonymousView, GameDetailUI2.this);
        com.tencent.mm.game.report.f.a(GameDetailUI2.this.getContext(), 12, 1205, 1, 7, GameDetailUI2.f(GameDetailUI2.this), GameDetailUI2.g(GameDetailUI2.this), null);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameDetailUI2$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(42012);
      }
    };
    this.uoc = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(42013);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameDetailUI2$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        com.tencent.mm.plugin.game.f.c.a(paramAnonymousView, GameDetailUI2.this);
        com.tencent.mm.game.report.f.a(GameDetailUI2.this.getContext(), 12, 1205, 999, 7, GameDetailUI2.f(GameDetailUI2.this), GameDetailUI2.g(GameDetailUI2.this), null);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameDetailUI2$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(42013);
      }
    };
    this.uod = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(42014);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameDetailUI2$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        com.tencent.mm.plugin.game.f.c.a(paramAnonymousView, GameDetailUI2.this);
        com.tencent.mm.game.report.f.a(GameDetailUI2.this.getContext(), 12, 1206, 1, 7, GameDetailUI2.f(GameDetailUI2.this), GameDetailUI2.g(GameDetailUI2.this), null);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameDetailUI2$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(42014);
      }
    };
    AppMethodBeat.o(42029);
  }
  
  private void a(z paramz)
  {
    AppMethodBeat.i(42038);
    Object localObject1 = null;
    if ((paramz.udy.udz == null) || (paramz.udy.udz.size() == 0)) {
      localObject1 = paramz.udw.uhQ;
    }
    if ((localObject1 == null) || (((LinkedList)localObject1).size() == 0))
    {
      this.unw.setVisibility(8);
      AppMethodBeat.o(42038);
      return;
    }
    this.unw.setVisibility(0);
    this.unw.removeAllViews();
    paramz = ((LinkedList)localObject1).iterator();
    if (paramz.hasNext())
    {
      localObject1 = (com.tencent.mm.plugin.game.d.y)paramz.next();
      View localView = LayoutInflater.from(getContext()).inflate(2131494290, this.unw, false);
      ImageView localImageView = (ImageView)localView.findViewById(2131300428);
      TextView localTextView1 = (TextView)localView.findViewById(2131300429);
      TextView localTextView2 = (TextView)localView.findViewById(2131300427);
      if (!bt.isNullOrNil(((com.tencent.mm.plugin.game.d.y)localObject1).nDo)) {
        a.b.a(localImageView, ((com.tencent.mm.plugin.game.d.y)localObject1).nDo, 0.5F, false);
      }
      for (;;)
      {
        localTextView1.setText(((com.tencent.mm.plugin.game.d.y)localObject1).Title);
        localTextView2.setText(((com.tencent.mm.plugin.game.d.y)localObject1).ugo);
        this.unw.addView(localView);
        break;
        Object localObject2 = new c.a();
        ((c.a)localObject2).hfi = true;
        localObject2 = ((c.a)localObject2).aJc();
        com.tencent.mm.aw.q.aIJ().a(((com.tencent.mm.plugin.game.d.y)localObject1).ufg, localImageView, (com.tencent.mm.aw.a.a.c)localObject2);
      }
    }
    AppMethodBeat.o(42038);
  }
  
  private void b(aa paramaa)
  {
    int i = 0;
    AppMethodBeat.i(42037);
    List localList = paramaa.udz;
    if ((localList == null) || (localList.size() == 0))
    {
      this.uny.setVisibility(8);
      this.unz.setVisibility(8);
      AppMethodBeat.o(42037);
      return;
    }
    this.uny.setVisibility(0);
    if (localList.size() > 3) {
      this.unz.setVisibility(0);
    }
    for (;;)
    {
      this.uny.removeAllViews();
      i locali = new i(getContext());
      locali.UR = 2131494287;
      locali.a(paramaa);
      locali.udq = this.udq;
      while ((i < localList.size()) && (i < 3))
      {
        paramaa = locali.getView(i, null, this.unw);
        this.uny.addView(paramaa);
        i += 1;
      }
      this.unz.setVisibility(8);
    }
    AppMethodBeat.o(42037);
  }
  
  private void b(z paramz)
  {
    AppMethodBeat.i(42039);
    if ((paramz.cZn() != null) && (!paramz.cZn().isEmpty()))
    {
      this.unA.setVisibility(0);
      if (!bt.isNullOrNil(paramz.cZm()))
      {
        this.unB.setVisibility(0);
        this.unB.setText(paramz.cZm());
        this.unC.removeAllViews();
        if (paramz.cZo() != 1) {
          break label271;
        }
        this.unC.setOrientation(1);
        this.unD.setVisibility(8);
      }
      Object localObject;
      for (int i = 2131494282;; i = 2131494281)
      {
        localObject = paramz.cZn();
        if (localObject == null) {
          break label294;
        }
        localObject = ((LinkedList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          z.b localb = (z.b)((Iterator)localObject).next();
          View localView = LayoutInflater.from(getContext()).inflate(i, this.unC, false);
          ImageView localImageView = (ImageView)localView.findViewById(2131300390);
          com.tencent.mm.aw.q.aIJ().loadImage(localb.dDH, localImageView);
          if (paramz.cZo() == 1) {
            ((TextView)localView.findViewById(2131300391)).setText(localb.title);
          }
          ((TextView)localView.findViewById(2131300389)).setText(localb.desc);
          if (paramz.cZo() == 1)
          {
            localView.setTag(localb.url);
            localView.setOnClickListener(this.uoa);
          }
          this.unC.addView(localView);
        }
        this.unB.setVisibility(8);
        break;
        label271:
        this.unC.setOrientation(0);
        this.unD.setVisibility(0);
      }
      label294:
      if (paramz.udw.uhY != null)
      {
        localObject = new z.a();
        ((z.a)localObject).title = paramz.udw.uhY.summary;
        ((z.a)localObject).desc = paramz.udw.uhY.desc;
        ((z.a)localObject).url = paramz.udw.uhY.url;
        paramz = (z)localObject;
        if (paramz == null) {
          break label537;
        }
        this.unE.setVisibility(0);
        this.unF.setText(paramz.title);
        if (bt.isNullOrNil(paramz.desc)) {
          break label525;
        }
        this.unG.setVisibility(0);
        this.unG.setText(paramz.desc);
      }
      for (;;)
      {
        this.unE.setTag(paramz.url);
        this.unE.setOnClickListener(this.uoa);
        AppMethodBeat.o(42039);
        return;
        if ((paramz.udw.uhT != null) && (!bt.isNullOrNil(paramz.udw.uhT.uiK)) && (!bt.isNullOrNil(paramz.udw.uhT.uiL)))
        {
          localObject = new z.a();
          ((z.a)localObject).title = paramz.udw.uhT.uiK;
          ((z.a)localObject).url = paramz.udw.uhT.uiL;
          paramz = (z)localObject;
          break;
        }
        paramz = null;
        break;
        label525:
        this.unG.setVisibility(8);
      }
      label537:
      this.unE.setVisibility(8);
      AppMethodBeat.o(42039);
      return;
    }
    this.unA.setVisibility(8);
    AppMethodBeat.o(42039);
  }
  
  private void c(z paramz)
  {
    AppMethodBeat.i(42040);
    if ((paramz.cZs() != null) && (!paramz.cZs().isEmpty()))
    {
      this.unS.setVisibility(0);
      if (!bt.isNullOrNil(paramz.cZr()))
      {
        this.unT.setVisibility(0);
        this.unT.setText(paramz.cZr());
      }
      for (;;)
      {
        this.unU.removeAllViews();
        this.unU.setOnClickListener(null);
        Iterator localIterator = paramz.cZs().iterator();
        while (localIterator.hasNext())
        {
          cb localcb = (cb)localIterator.next();
          View localView = LayoutInflater.from(getContext()).inflate(2131494283, this.unU, false);
          TextView localTextView1 = (TextView)localView.findViewById(2131300403);
          TextView localTextView2 = (TextView)localView.findViewById(2131300404);
          TextView localTextView3 = (TextView)localView.findViewById(2131300401);
          ImageView localImageView = (ImageView)localView.findViewById(2131300402);
          localTextView1.setText(localcb.uiP);
          localTextView2.setText(localcb.Title);
          localTextView3.setText(localcb.ugo);
          com.tencent.mm.aw.q.aIJ().loadImage(localcb.uiM, localImageView);
          localView.setTag(localcb.ufb);
          localView.setOnClickListener(this.uob);
          this.unU.addView(localView);
        }
        this.unT.setVisibility(8);
      }
      if (paramz.udw.uhT == null) {
        paramz = null;
      }
      while (paramz != null)
      {
        this.unV.setVisibility(0);
        this.unV.setText((CharSequence)paramz.first);
        this.unV.setTag(paramz.second);
        this.unV.setOnClickListener(this.uoc);
        AppMethodBeat.o(42040);
        return;
        if ((bt.isNullOrNil(paramz.udw.uhS.Title)) || (bt.isNullOrNil(paramz.udw.uhS.uiL))) {
          paramz = null;
        } else {
          paramz = new Pair(paramz.udw.uhS.uiK, paramz.udw.uhS.uiL);
        }
      }
      this.unV.setVisibility(8);
      AppMethodBeat.o(42040);
      return;
    }
    this.unS.setVisibility(8);
    AppMethodBeat.o(42040);
  }
  
  private void cZV()
  {
    AppMethodBeat.i(42035);
    Object localObject = getIntent().getStringExtra("jump_game_center");
    if ((!bt.isNullOrNil((String)localObject)) && (((String)localObject).equals("jump_game_center")))
    {
      localObject = new Intent(this, GameCenterUI.class);
      ((Intent)localObject).putExtra("jump_find_more_friends", "jump_find_more_friends");
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/game/ui/GameDetailUI2", "backToGameCenterUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameDetailUI2", "backToGameCenterUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    AppMethodBeat.o(42035);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(42034);
    cZV();
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
    this.unp = ((ViewGroup)findViewById(2131300374));
    this.unq = ((ImageView)findViewById(2131300375));
    this.unr = ((ImageView)findViewById(2131300462));
    this.uns = ((TextView)findViewById(2131300524));
    this.unv = ((TextView)findViewById(2131300469));
    this.unt = ((Button)findViewById(2131300344));
    this.unu = ((TextProgressBar)findViewById(2131300538));
    this.unu.setTextSize(this.uni);
    this.unw = ((LinearLayout)findViewById(2131300426));
    this.unx = ((GameDetailAutoScrollView)findViewById(2131300425));
    this.uny = ((LinearLayout)findViewById(2131300407));
    this.unz = ((TextView)findViewById(2131300409));
    this.unA = ((LinearLayout)findViewById(2131300383));
    this.unB = ((TextView)findViewById(2131300392));
    this.unC = ((LinearLayout)findViewById(2131300384));
    this.unD = ((ImageView)findViewById(2131300385));
    this.unE = findViewById(2131300386);
    this.unF = ((TextView)findViewById(2131300388));
    this.unG = ((TextView)findViewById(2131300387));
    this.unH = findViewById(2131300393);
    this.unI = ((TextView)findViewById(2131300397));
    this.unJ = ((ImageView)findViewById(2131300396));
    this.unK = ((TextView)findViewById(2131300394));
    this.unL = ((TextView)findViewById(2131300395));
    this.unM = ((LinearLayout)findViewById(2131300378));
    this.unN = ((GameMediaList)findViewById(2131300406));
    GameMediaList localGameMediaList = this.unN;
    String str = this.appId;
    int i = this.udq;
    localGameMediaList.appId = str;
    localGameMediaList.rgD = 12;
    localGameMediaList.upv = i;
    localGameMediaList.mContext = this;
    this.unN.setItemLayout(2131494344);
    this.unO = ((TextView)findViewById(2131300381));
    this.unP = ((TextView)findViewById(2131300379));
    this.unP.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
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
    this.unQ = ((TextView)findViewById(2131300382));
    this.unQ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(42020);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameDetailUI2$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
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
    this.unS = ((LinearLayout)findViewById(2131300398));
    this.unT = ((TextView)findViewById(2131300405));
    this.unU = ((LinearLayout)findViewById(2131300399));
    this.unV = ((TextView)findViewById(2131300400));
    AppMethodBeat.o(42036);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(42042);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ad.i("MicroMsg.GameDetailUI2", "requestCode = %d, resultCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    switch (paramInt1)
    {
    default: 
      ad.e("MicroMsg.GameDetailUI2", "error request code");
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
        if (this.uno != null)
        {
          this.uno.cdl();
          AppMethodBeat.o(42042);
          return;
        }
        break;
      case 2: 
        if ((this.ubv != null) && (this.uno != null))
        {
          this.uno.cYS();
          this.unn.a(this.ubv, this.uno);
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
        if (!bt.isNullOrNil(str2))
        {
          String str1 = this.unW.ufg;
          paramIntent = str1;
          if (bt.isNullOrNil(str1)) {
            paramIntent = this.ubv.field_appIconUrl;
          }
          ab.a.EXc.a(this.mController, this.unW.ujJ, paramIntent, this.unW.ujK, true, getResources().getString(2131755884), new y.a()
          {
            public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
            {
              AppMethodBeat.i(42018);
              if (paramAnonymousBoolean)
              {
                GameDetailUI2.a(GameDetailUI2.this, str2, paramAnonymousString);
                com.tencent.mm.ui.base.h.cl(GameDetailUI2.this, GameDetailUI2.this.getResources().getString(2131757561));
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
        com.tencent.mm.game.report.f.a(getContext(), 12, 1207, 2, 15, this.appId, this.udq, null);
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
    if (!g.ajx())
    {
      ad.e("MicroMsg.GameDetailUI2", "account not ready");
      finish();
      AppMethodBeat.o(42030);
      return;
    }
    this.unj = true;
    this.unk = false;
    this.appId = getIntent().getStringExtra("game_app_id");
    if (bt.isNullOrNil(this.appId))
    {
      ad.e("MicroMsg.GameDetailUI2", "appid is null or nill");
      finish();
      initView();
      g.aiU().a(1217, this);
      paramBundle = ((com.tencent.mm.plugin.game.api.f)g.ab(com.tencent.mm.plugin.game.api.f.class)).cWI().all(this.appId);
      if ((paramBundle != null) && (paramBundle.length != 0)) {
        break label220;
      }
      ad.i("MicroMsg.GameDetailUI2", "No cache found");
    }
    for (int i = 0;; i = 1)
    {
      if (i == 0)
      {
        this.qdv = com.tencent.mm.plugin.game.f.c.fA(this);
        this.qdv.show();
      }
      paramBundle = ac.fks();
      boolean bool = com.tencent.mm.pluginsdk.model.app.h.s(this, this.appId);
      paramBundle = new am(paramBundle, this.appId, bool);
      g.aiU().a(paramBundle, 0);
      AppMethodBeat.o(42030);
      return;
      this.udq = getIntent().getIntExtra("game_report_from_scene", 0);
      break;
      label220:
      g.ajF().ay(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(42022);
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(42021);
              GameDetailUI2.a(GameDetailUI2.this, this.uoh);
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
    g.aiU().b(1217, this);
    if (this.unm != null) {
      k.b(this.unm);
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
    if ((this.ubv != null) && (this.uno != null))
    {
      this.uno.cdl();
      this.unn.a(this.unu, this.unt, this.ubv, this.uno);
    }
    if (!this.unj)
    {
      b(new aa(this.appId));
      AppMethodBeat.o(42031);
      return;
    }
    this.unj = false;
    AppMethodBeat.o(42031);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, n paramn)
  {
    AppMethodBeat.i(42041);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      if (!com.tencent.mm.plugin.game.a.a.iRH.a(this, paramInt1, paramInt2, paramString)) {
        Toast.makeText(this, getString(2131759916, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      }
      if (this.qdv != null) {
        this.qdv.cancel();
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
      paramString = ((am)paramn).grW.hNL.hNQ;
      g.ajF().ay(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(42025);
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(42024);
              GameDetailUI2.a(GameDetailUI2.this, this.uoh);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDetailUI2
 * JD-Core Version:    0.7.0.1
 */