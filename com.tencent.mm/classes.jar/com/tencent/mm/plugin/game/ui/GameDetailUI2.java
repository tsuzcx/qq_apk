package com.tencent.mm.plugin.game.ui;

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
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.game.report.g;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.game.h.e;
import com.tencent.mm.plugin.game.h.f;
import com.tencent.mm.plugin.game.h.h;
import com.tencent.mm.plugin.game.h.i;
import com.tencent.mm.plugin.game.model.aa;
import com.tencent.mm.plugin.game.model.am;
import com.tencent.mm.plugin.game.model.k.a;
import com.tencent.mm.plugin.game.model.w;
import com.tencent.mm.plugin.game.model.z;
import com.tencent.mm.plugin.game.model.z.a;
import com.tencent.mm.plugin.game.model.z.b;
import com.tencent.mm.plugin.game.protobuf.ag;
import com.tencent.mm.plugin.game.protobuf.bm;
import com.tencent.mm.plugin.game.protobuf.ce;
import com.tencent.mm.plugin.game.protobuf.cg;
import com.tencent.mm.plugin.game.protobuf.cj;
import com.tencent.mm.plugin.game.protobuf.ck;
import com.tencent.mm.plugin.game.protobuf.dw;
import com.tencent.mm.plugin.game.widget.TextProgressBar;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.ac;
import com.tencent.mm.pluginsdk.ui.applet.ac.a;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GameDetailUI2
  extends MMActivity
  implements com.tencent.mm.am.h
{
  private com.tencent.mm.plugin.game.model.c IDb;
  private int IFc;
  private ImageView IPA;
  private View IPB;
  private TextView IPC;
  private TextView IPD;
  private View IPE;
  private TextView IPF;
  private ImageView IPG;
  private TextView IPH;
  private TextView IPI;
  private LinearLayout IPJ;
  private GameMediaList IPK;
  private TextView IPL;
  private TextView IPM;
  private TextView IPN;
  private boolean IPO;
  private LinearLayout IPP;
  private TextView IPQ;
  private LinearLayout IPR;
  private TextView IPS;
  private dw IPT;
  private DialogInterface.OnClickListener IPU;
  private View.OnClickListener IPV;
  private View.OnClickListener IPW;
  private View.OnClickListener IPX;
  private View.OnClickListener IPY;
  private View.OnClickListener IPZ;
  private String IPc;
  private String IPd;
  private int IPf;
  private boolean IPg;
  private boolean IPh;
  private String IPi;
  private k.a IPj;
  private d IPk;
  private com.tencent.mm.plugin.game.model.l IPl;
  private ViewGroup IPm;
  private ImageView IPn;
  private ImageView IPo;
  private TextView IPp;
  private Button IPq;
  private TextProgressBar IPr;
  private TextView IPs;
  private LinearLayout IPt;
  private GameDetailAutoScrollView IPu;
  private LinearLayout IPv;
  private TextView IPw;
  private LinearLayout IPx;
  private TextView IPy;
  private LinearLayout IPz;
  private View.OnClickListener IQa;
  private String appId;
  private Dialog ysC;
  
  public GameDetailUI2()
  {
    AppMethodBeat.i(42029);
    this.appId = null;
    this.IDb = null;
    this.IPc = null;
    this.IPd = null;
    this.IPf = 18;
    this.IFc = 0;
    this.IPi = null;
    this.IPj = null;
    this.IPk = null;
    this.IPl = null;
    this.IPO = false;
    this.IPU = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(42026);
        GameDetailUI2.i(GameDetailUI2.this).dvo();
        GameDetailUI2.m(GameDetailUI2.this).a(GameDetailUI2.j(GameDetailUI2.this), GameDetailUI2.k(GameDetailUI2.this), GameDetailUI2.l(GameDetailUI2.this), GameDetailUI2.i(GameDetailUI2.this));
        AppMethodBeat.o(42026);
      }
    };
    this.IPV = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(42027);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/ui/GameDetailUI2$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (GameDetailUI2.l(GameDetailUI2.this) == null)
        {
          Log.e("MicroMsg.GameDetailUI2", "Null appInfo");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameDetailUI2$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(42027);
          return;
        }
        if (GameDetailUI2.i(GameDetailUI2.this) == null)
        {
          Log.e("MicroMsg.GameDetailUI2", "No DownloadInfo found");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameDetailUI2$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(42027);
          return;
        }
        GameDetailUI2.i(GameDetailUI2.this).hV(GameDetailUI2.this.getContext());
        GameDetailUI2.m(GameDetailUI2.this).a(GameDetailUI2.l(GameDetailUI2.this), GameDetailUI2.i(GameDetailUI2.this));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameDetailUI2$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(42027);
      }
    };
    this.IPW = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(42028);
        Object localObject = new b();
        ((b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/ui/GameDetailUI2$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
        if ((paramAnonymousView.getTag() instanceof String))
        {
          com.tencent.mm.plugin.game.d.c.b(paramAnonymousView, GameDetailUI2.this);
          g.a(GameDetailUI2.this.getContext(), 12, 1203, 999, 7, GameDetailUI2.f(GameDetailUI2.this), GameDetailUI2.g(GameDetailUI2.this), null);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameDetailUI2$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(42028);
          return;
          localObject = new GameDetailRankUI.a();
          ((GameDetailRankUI.a)localObject).IPc = GameDetailUI2.n(GameDetailUI2.this);
          ((GameDetailRankUI.a)localObject).IPd = GameDetailUI2.o(GameDetailUI2.this);
          ((GameDetailRankUI.a)localObject).IPe = GameDetailUI2.l(GameDetailUI2.this);
          paramAnonymousView = ad.Jo("rankData");
          ad.bCb().M(paramAnonymousView, true).q(GameDetailRankUI.IPa, localObject);
          localObject = new Intent(GameDetailUI2.this.getContext(), GameDetailRankUI.class);
          ((Intent)localObject).putExtra(GameDetailRankUI.IOZ, paramAnonymousView);
          paramAnonymousView = GameDetailUI2.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/game/ui/GameDetailUI2$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/game/ui/GameDetailUI2$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          g.a(GameDetailUI2.this.getContext(), 12, 1203, 999, 6, GameDetailUI2.f(GameDetailUI2.this), GameDetailUI2.g(GameDetailUI2.this), null);
        }
      }
    };
    this.IPX = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(42011);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/ui/GameDetailUI2$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        com.tencent.mm.plugin.game.d.c.b(paramAnonymousView, GameDetailUI2.this);
        g.a(GameDetailUI2.this.getContext(), 12, 1204, 999, 7, GameDetailUI2.f(GameDetailUI2.this), GameDetailUI2.g(GameDetailUI2.this), null);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameDetailUI2$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(42011);
      }
    };
    this.IPY = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(42012);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/ui/GameDetailUI2$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        com.tencent.mm.plugin.game.d.c.b(paramAnonymousView, GameDetailUI2.this);
        g.a(GameDetailUI2.this.getContext(), 12, 1205, 1, 7, GameDetailUI2.f(GameDetailUI2.this), GameDetailUI2.g(GameDetailUI2.this), null);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameDetailUI2$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(42012);
      }
    };
    this.IPZ = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(42013);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/ui/GameDetailUI2$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        com.tencent.mm.plugin.game.d.c.b(paramAnonymousView, GameDetailUI2.this);
        g.a(GameDetailUI2.this.getContext(), 12, 1205, 999, 7, GameDetailUI2.f(GameDetailUI2.this), GameDetailUI2.g(GameDetailUI2.this), null);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameDetailUI2$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(42013);
      }
    };
    this.IQa = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(42014);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/ui/GameDetailUI2$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        com.tencent.mm.plugin.game.d.c.b(paramAnonymousView, GameDetailUI2.this);
        g.a(GameDetailUI2.this.getContext(), 12, 1206, 1, 7, GameDetailUI2.f(GameDetailUI2.this), GameDetailUI2.g(GameDetailUI2.this), null);
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
    if ((paramz.IFk.IFl == null) || (paramz.IFk.IFl.size() == 0)) {
      localObject1 = paramz.IFi.IJL;
    }
    if ((localObject1 == null) || (((LinkedList)localObject1).size() == 0))
    {
      this.IPt.setVisibility(8);
      AppMethodBeat.o(42038);
      return;
    }
    this.IPt.setVisibility(0);
    this.IPt.removeAllViews();
    paramz = ((LinkedList)localObject1).iterator();
    if (paramz.hasNext())
    {
      localObject1 = (ag)paramz.next();
      View localView = LayoutInflater.from(getContext()).inflate(h.f.HZf, this.IPt, false);
      ImageView localImageView = (ImageView)localView.findViewById(h.e.HVj);
      TextView localTextView1 = (TextView)localView.findViewById(h.e.HVk);
      TextView localTextView2 = (TextView)localView.findViewById(h.e.HVi);
      if (!Util.isNullOrNil(((ag)localObject1).UserName)) {
        a.b.a(localImageView, ((ag)localObject1).UserName, 0.5F, false);
      }
      for (;;)
      {
        localTextView1.setText(((ag)localObject1).hAP);
        localTextView2.setText(((ag)localObject1).IIu);
        this.IPt.addView(localView);
        break;
        Object localObject2 = new c.a();
        ((c.a)localObject2).nrc = true;
        localObject2 = ((c.a)localObject2).bKx();
        r.bKe().a(((ag)localObject1).IGT, localImageView, (com.tencent.mm.modelimage.loader.a.c)localObject2);
      }
    }
    AppMethodBeat.o(42038);
  }
  
  private void b(aa paramaa)
  {
    int i = 0;
    AppMethodBeat.i(42037);
    List localList = paramaa.IFl;
    if ((localList == null) || (localList.size() == 0))
    {
      this.IPv.setVisibility(8);
      this.IPw.setVisibility(8);
      AppMethodBeat.o(42037);
      return;
    }
    this.IPv.setVisibility(0);
    if (localList.size() > 3) {
      this.IPw.setVisibility(0);
    }
    for (;;)
    {
      this.IPv.removeAllViews();
      i locali = new i(getContext());
      locali.bxp = h.f.HZc;
      locali.a(paramaa);
      locali.IFc = this.IFc;
      while ((i < localList.size()) && (i < 3))
      {
        paramaa = locali.getView(i, null, this.IPt);
        this.IPv.addView(paramaa);
        i += 1;
      }
      this.IPw.setVisibility(8);
    }
    AppMethodBeat.o(42037);
  }
  
  private void b(z paramz)
  {
    AppMethodBeat.i(42039);
    if ((paramz.fGJ() != null) && (!paramz.fGJ().isEmpty()))
    {
      this.IPx.setVisibility(0);
      int i;
      if (!Util.isNullOrNil(paramz.fGI()))
      {
        this.IPy.setVisibility(0);
        this.IPy.setText(paramz.fGI());
        this.IPz.removeAllViews();
        if (paramz.fGK() != 1) {
          break label271;
        }
        this.IPz.setOrientation(1);
        i = h.f.HYX;
        this.IPA.setVisibility(8);
      }
      Object localObject;
      for (;;)
      {
        localObject = paramz.fGJ();
        if (localObject == null) {
          break label294;
        }
        localObject = ((LinkedList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          z.b localb = (z.b)((Iterator)localObject).next();
          View localView = LayoutInflater.from(getContext()).inflate(i, this.IPz, false);
          ImageView localImageView = (ImageView)localView.findViewById(h.e.HUz);
          r.bKe().loadImage(localb.icon, localImageView);
          if (paramz.fGK() == 1) {
            ((TextView)localView.findViewById(h.e.HUA)).setText(localb.title);
          }
          ((TextView)localView.findViewById(h.e.HUy)).setText(localb.desc);
          if (paramz.fGK() == 1)
          {
            localView.setTag(localb.url);
            localView.setOnClickListener(this.IPX);
          }
          this.IPz.addView(localView);
        }
        this.IPy.setVisibility(8);
        break;
        label271:
        this.IPz.setOrientation(0);
        i = h.f.HYW;
        this.IPA.setVisibility(0);
      }
      label294:
      if (paramz.IFi.IJT != null)
      {
        localObject = new z.a();
        ((z.a)localObject).title = paramz.IFi.IJT.summary;
        ((z.a)localObject).desc = paramz.IFi.IJT.desc;
        ((z.a)localObject).url = paramz.IFi.IJT.url;
        paramz = (z)localObject;
        if (paramz == null) {
          break label537;
        }
        this.IPB.setVisibility(0);
        this.IPC.setText(paramz.title);
        if (Util.isNullOrNil(paramz.desc)) {
          break label525;
        }
        this.IPD.setVisibility(0);
        this.IPD.setText(paramz.desc);
      }
      for (;;)
      {
        this.IPB.setTag(paramz.url);
        this.IPB.setOnClickListener(this.IPX);
        AppMethodBeat.o(42039);
        return;
        if ((paramz.IFi.IJO != null) && (!Util.isNullOrNil(paramz.IFi.IJO.IKC)) && (!Util.isNullOrNil(paramz.IFi.IJO.IKD)))
        {
          localObject = new z.a();
          ((z.a)localObject).title = paramz.IFi.IJO.IKC;
          ((z.a)localObject).url = paramz.IFi.IJO.IKD;
          paramz = (z)localObject;
          break;
        }
        paramz = null;
        break;
        label525:
        this.IPD.setVisibility(8);
      }
      label537:
      this.IPB.setVisibility(8);
      AppMethodBeat.o(42039);
      return;
    }
    this.IPx.setVisibility(8);
    AppMethodBeat.o(42039);
  }
  
  private void c(z paramz)
  {
    AppMethodBeat.i(42040);
    if ((paramz.fGO() != null) && (!paramz.fGO().isEmpty()))
    {
      this.IPP.setVisibility(0);
      if (!Util.isNullOrNil(paramz.fGN()))
      {
        this.IPQ.setVisibility(0);
        this.IPQ.setText(paramz.fGN());
      }
      for (;;)
      {
        this.IPR.removeAllViews();
        this.IPR.setOnClickListener(null);
        Iterator localIterator = paramz.fGO().iterator();
        while (localIterator.hasNext())
        {
          ck localck = (ck)localIterator.next();
          View localView = LayoutInflater.from(getContext()).inflate(h.f.HYY, this.IPR, false);
          TextView localTextView1 = (TextView)localView.findViewById(h.e.HUM);
          TextView localTextView2 = (TextView)localView.findViewById(h.e.HUN);
          TextView localTextView3 = (TextView)localView.findViewById(h.e.HUK);
          ImageView localImageView = (ImageView)localView.findViewById(h.e.HUL);
          localTextView1.setText(localck.IKH);
          localTextView2.setText(localck.hAP);
          localTextView3.setText(localck.IIu);
          r.bKe().loadImage(localck.IKE, localImageView);
          localView.setTag(localck.IGL);
          localView.setOnClickListener(this.IPY);
          this.IPR.addView(localView);
        }
        this.IPQ.setVisibility(8);
      }
      if (paramz.IFi.IJO == null) {
        paramz = null;
      }
      while (paramz != null)
      {
        this.IPS.setVisibility(0);
        this.IPS.setText((CharSequence)paramz.first);
        this.IPS.setTag(paramz.second);
        this.IPS.setOnClickListener(this.IPZ);
        AppMethodBeat.o(42040);
        return;
        if ((Util.isNullOrNil(paramz.IFi.IJN.hAP)) || (Util.isNullOrNil(paramz.IFi.IJN.IKD))) {
          paramz = null;
        } else {
          paramz = new Pair(paramz.IFi.IJN.IKC, paramz.IFi.IJN.IKD);
        }
      }
      this.IPS.setVisibility(8);
      AppMethodBeat.o(42040);
      return;
    }
    this.IPP.setVisibility(8);
    AppMethodBeat.o(42040);
  }
  
  private void fHt()
  {
    AppMethodBeat.i(42035);
    Object localObject = getIntent().getStringExtra("jump_game_center");
    if ((!Util.isNullOrNil((String)localObject)) && (((String)localObject).equals("jump_game_center")))
    {
      localObject = new Intent(this, GameCenterUI.class);
      ((Intent)localObject).putExtra("jump_find_more_friends", "jump_find_more_friends");
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/game/ui/GameDetailUI2", "backToGameCenterUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/game/ui/GameDetailUI2", "backToGameCenterUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    AppMethodBeat.o(42035);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(42034);
    fHt();
    finish();
    AppMethodBeat.o(42034);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return h.f.HYU;
  }
  
  public void initView()
  {
    AppMethodBeat.i(42036);
    setMMTitle(h.i.IaU);
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
    this.IPm = ((ViewGroup)findViewById(h.e.HUk));
    this.IPn = ((ImageView)findViewById(h.e.HUl));
    this.IPo = ((ImageView)findViewById(h.e.HVB));
    this.IPp = ((TextView)findViewById(h.e.HWm));
    this.IPs = ((TextView)findViewById(h.e.HVE));
    this.IPq = ((Button)findViewById(h.e.HTT));
    this.IPr = ((TextProgressBar)findViewById(h.e.HWp));
    this.IPr.setTextSize(this.IPf);
    this.IPt = ((LinearLayout)findViewById(h.e.HVh));
    this.IPu = ((GameDetailAutoScrollView)findViewById(h.e.HVg));
    this.IPv = ((LinearLayout)findViewById(h.e.HUQ));
    this.IPw = ((TextView)findViewById(h.e.HUS));
    this.IPx = ((LinearLayout)findViewById(h.e.HUs));
    this.IPy = ((TextView)findViewById(h.e.HUB));
    this.IPz = ((LinearLayout)findViewById(h.e.HUt));
    this.IPA = ((ImageView)findViewById(h.e.HUu));
    this.IPB = findViewById(h.e.HUv);
    this.IPC = ((TextView)findViewById(h.e.HUx));
    this.IPD = ((TextView)findViewById(h.e.HUw));
    this.IPE = findViewById(h.e.HUC);
    this.IPF = ((TextView)findViewById(h.e.HUG));
    this.IPG = ((ImageView)findViewById(h.e.HUF));
    this.IPH = ((TextView)findViewById(h.e.HUD));
    this.IPI = ((TextView)findViewById(h.e.HUE));
    this.IPJ = ((LinearLayout)findViewById(h.e.HUo));
    this.IPK = ((GameMediaList)findViewById(h.e.HUP));
    GameMediaList localGameMediaList = this.IPK;
    String str = this.appId;
    int i = this.IFc;
    localGameMediaList.appId = str;
    localGameMediaList.ybL = 12;
    localGameMediaList.IRr = i;
    localGameMediaList.mContext = this;
    this.IPK.setItemLayout(h.f.HZT);
    this.IPL = ((TextView)findViewById(h.e.HUq));
    this.IPM = ((TextView)findViewById(h.e.HUp));
    this.IPM.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
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
    this.IPN = ((TextView)findViewById(h.e.HUr));
    this.IPN.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(42020);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/ui/GameDetailUI2$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (!GameDetailUI2.d(GameDetailUI2.this))
        {
          GameDetailUI2.b(GameDetailUI2.this).setMaxLines(100);
          GameDetailUI2.c(GameDetailUI2.this).setText(GameDetailUI2.this.getResources().getText(h.i.IaM));
          GameDetailUI2.a(GameDetailUI2.this, true);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameDetailUI2$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(42020);
          return;
          GameDetailUI2.b(GameDetailUI2.this).setMaxLines(3);
          GameDetailUI2.c(GameDetailUI2.this).setText(GameDetailUI2.this.getResources().getText(h.i.IaL));
          GameDetailUI2.a(GameDetailUI2.this, false);
        }
      }
    });
    this.IPP = ((LinearLayout)findViewById(h.e.HUH));
    this.IPQ = ((TextView)findViewById(h.e.HUO));
    this.IPR = ((LinearLayout)findViewById(h.e.HUI));
    this.IPS = ((TextView)findViewById(h.e.HUJ));
    AppMethodBeat.o(42036);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(42042);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Log.i("MicroMsg.GameDetailUI2", "requestCode = %d, resultCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    switch (paramInt1)
    {
    default: 
      Log.e("MicroMsg.GameDetailUI2", "error request code");
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
        if (this.IPl != null)
        {
          this.IPl.dvo();
          AppMethodBeat.o(42042);
          return;
        }
        break;
      case 2: 
        if ((this.IDb != null) && (this.IPl != null))
        {
          this.IPl.fGn();
          this.IPk.a(this.IDb, this.IPl);
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
        if (!Util.isNullOrNil(str2))
        {
          String str1 = this.IPT.IGT;
          paramIntent = str1;
          if (Util.isNullOrNil(str1)) {
            paramIntent = this.IDb.field_appIconUrl;
          }
          ac.a.Yde.a(this.mController, this.IPT.ILI, paramIntent, this.IPT.ILJ, true, getResources().getString(h.i.app_send), new y.a()
          {
            public final void onDialogClick(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
            {
              AppMethodBeat.i(42018);
              if (paramAnonymousBoolean)
              {
                GameDetailUI2.a(GameDetailUI2.this, str2, paramAnonymousString);
                com.tencent.mm.ui.base.k.cZ(GameDetailUI2.this, GameDetailUI2.this.getResources().getString(h.i.confirm_dialog_sent));
                g.a(GameDetailUI2.this.getContext(), 12, 1207, 2, 14, GameDetailUI2.f(GameDetailUI2.this), GameDetailUI2.g(GameDetailUI2.this), null);
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
        g.a(getContext(), 12, 1207, 2, 15, this.appId, this.IFc, null);
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
    if (!com.tencent.mm.kernel.h.baz())
    {
      Log.e("MicroMsg.GameDetailUI2", "account not ready");
      finish();
      AppMethodBeat.o(42030);
      return;
    }
    this.IPg = true;
    this.IPh = false;
    this.appId = getIntent().getStringExtra("game_app_id");
    if (Util.isNullOrNil(this.appId))
    {
      Log.e("MicroMsg.GameDetailUI2", "appid is null or nill");
      finish();
      initView();
      com.tencent.mm.kernel.h.aZW().a(1217, this);
      paramBundle = ((f)com.tencent.mm.kernel.h.ax(f.class)).fCi().aFI(this.appId);
      if ((paramBundle != null) && (paramBundle.length != 0)) {
        break label220;
      }
      Log.i("MicroMsg.GameDetailUI2", "No cache found");
    }
    for (int i = 0;; i = 1)
    {
      if (i == 0)
      {
        this.ysC = com.tencent.mm.plugin.game.d.c.hY(this);
        this.ysC.show();
      }
      paramBundle = LocaleUtil.getApplicationLanguage();
      boolean bool = com.tencent.mm.pluginsdk.model.app.h.y(this, this.appId);
      paramBundle = new am(paramBundle, this.appId, bool);
      com.tencent.mm.kernel.h.aZW().a(paramBundle, 0);
      AppMethodBeat.o(42030);
      return;
      this.IFc = getIntent().getIntExtra("game_report_from_scene", 0);
      break;
      label220:
      com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(42022);
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(42021);
              GameDetailUI2.a(GameDetailUI2.this, this.IQe);
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
    com.tencent.mm.kernel.h.aZW().b(1217, this);
    if (this.IPj != null) {
      com.tencent.mm.plugin.game.model.k.b(this.IPj);
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
    if ((this.IDb != null) && (this.IPl != null))
    {
      this.IPl.dvo();
      this.IPk.a(this.IPr, this.IPq, this.IDb, this.IPl);
    }
    if (!this.IPg)
    {
      b(new aa(this.appId));
      AppMethodBeat.o(42031);
      return;
    }
    this.IPg = false;
    AppMethodBeat.o(42031);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, p paramp)
  {
    AppMethodBeat.i(42041);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      if (!com.tencent.mm.plugin.game.a.a.pFo.a(this, paramInt1, paramInt2, paramString)) {
        Toast.makeText(this, getString(h.i.Ibn, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      }
      if (this.ysC != null) {
        this.ysC.cancel();
      }
      AppMethodBeat.o(42041);
      return;
    }
    switch (paramp.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(42041);
      return;
      paramString = c.c.b(((am)paramp).mtC.otC);
      com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(42025);
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(42024);
              GameDetailUI2.a(GameDetailUI2.this, this.IQe);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDetailUI2
 * JD-Core Version:    0.7.0.1
 */