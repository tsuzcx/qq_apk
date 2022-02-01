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
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.t;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.plugin.game.model.aa;
import com.tencent.mm.plugin.game.model.am;
import com.tencent.mm.plugin.game.model.k;
import com.tencent.mm.plugin.game.model.k.a;
import com.tencent.mm.plugin.game.model.w;
import com.tencent.mm.plugin.game.model.z;
import com.tencent.mm.plugin.game.model.z.a;
import com.tencent.mm.plugin.game.model.z.b;
import com.tencent.mm.plugin.game.protobuf.ae;
import com.tencent.mm.plugin.game.protobuf.bk;
import com.tencent.mm.plugin.game.protobuf.cc;
import com.tencent.mm.plugin.game.protobuf.ce;
import com.tencent.mm.plugin.game.protobuf.ch;
import com.tencent.mm.plugin.game.protobuf.ci;
import com.tencent.mm.plugin.game.protobuf.dr;
import com.tencent.mm.plugin.game.widget.TextProgressBar;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.ab;
import com.tencent.mm.pluginsdk.ui.applet.ab.a;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GameDetailUI2
  extends MMActivity
  implements com.tencent.mm.ak.i
{
  private String appId;
  private Dialog rAV;
  private com.tencent.mm.plugin.game.model.c xEP;
  private int xGR;
  private String xQA;
  private String xQB;
  private int xQD;
  private boolean xQE;
  private boolean xQF;
  private String xQG;
  private k.a xQH;
  private d xQI;
  private com.tencent.mm.plugin.game.model.l xQJ;
  private ViewGroup xQK;
  private ImageView xQL;
  private ImageView xQM;
  private TextView xQN;
  private Button xQO;
  private TextProgressBar xQP;
  private TextView xQQ;
  private LinearLayout xQR;
  private GameDetailAutoScrollView xQS;
  private LinearLayout xQT;
  private TextView xQU;
  private LinearLayout xQV;
  private TextView xQW;
  private LinearLayout xQX;
  private ImageView xQY;
  private View xQZ;
  private TextView xRa;
  private TextView xRb;
  private View xRc;
  private TextView xRd;
  private ImageView xRe;
  private TextView xRf;
  private TextView xRg;
  private LinearLayout xRh;
  private GameMediaList xRi;
  private TextView xRj;
  private TextView xRk;
  private TextView xRl;
  private boolean xRm;
  private LinearLayout xRn;
  private TextView xRo;
  private LinearLayout xRp;
  private TextView xRq;
  private dr xRr;
  private DialogInterface.OnClickListener xRs;
  private View.OnClickListener xRt;
  private View.OnClickListener xRu;
  private View.OnClickListener xRv;
  private View.OnClickListener xRw;
  private View.OnClickListener xRx;
  private View.OnClickListener xRy;
  
  public GameDetailUI2()
  {
    AppMethodBeat.i(42029);
    this.appId = null;
    this.xEP = null;
    this.xQA = null;
    this.xQB = null;
    this.xQD = 18;
    this.xGR = 0;
    this.xQG = null;
    this.xQH = null;
    this.xQI = null;
    this.xQJ = null;
    this.xRm = false;
    this.xRs = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(42026);
        GameDetailUI2.i(GameDetailUI2.this).cCq();
        GameDetailUI2.m(GameDetailUI2.this).a(GameDetailUI2.j(GameDetailUI2.this), GameDetailUI2.k(GameDetailUI2.this), GameDetailUI2.l(GameDetailUI2.this), GameDetailUI2.i(GameDetailUI2.this));
        AppMethodBeat.o(42026);
      }
    };
    this.xRt = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(42027);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameDetailUI2$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
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
        GameDetailUI2.i(GameDetailUI2.this).gi(GameDetailUI2.this.getContext());
        GameDetailUI2.m(GameDetailUI2.this).a(GameDetailUI2.l(GameDetailUI2.this), GameDetailUI2.i(GameDetailUI2.this));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameDetailUI2$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(42027);
      }
    };
    this.xRu = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(42028);
        Object localObject = new b();
        ((b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameDetailUI2$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
        if ((paramAnonymousView.getTag() instanceof String))
        {
          com.tencent.mm.plugin.game.e.c.a(paramAnonymousView, GameDetailUI2.this);
          com.tencent.mm.game.report.f.a(GameDetailUI2.this.getContext(), 12, 1203, 999, 7, GameDetailUI2.f(GameDetailUI2.this), GameDetailUI2.g(GameDetailUI2.this), null);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameDetailUI2$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(42028);
          return;
          localObject = new GameDetailRankUI.a();
          ((GameDetailRankUI.a)localObject).xQA = GameDetailUI2.n(GameDetailUI2.this);
          ((GameDetailRankUI.a)localObject).xQB = GameDetailUI2.o(GameDetailUI2.this);
          ((GameDetailRankUI.a)localObject).xQC = GameDetailUI2.l(GameDetailUI2.this);
          paramAnonymousView = ad.JX("rankData");
          ad.aVe().G(paramAnonymousView, true).l(GameDetailRankUI.xQy, localObject);
          localObject = new Intent(GameDetailUI2.this.getContext(), GameDetailRankUI.class);
          ((Intent)localObject).putExtra(GameDetailRankUI.EXTRA_SESSION_ID, paramAnonymousView);
          paramAnonymousView = GameDetailUI2.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/game/ui/GameDetailUI2$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/game/ui/GameDetailUI2$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.game.report.f.a(GameDetailUI2.this.getContext(), 12, 1203, 999, 6, GameDetailUI2.f(GameDetailUI2.this), GameDetailUI2.g(GameDetailUI2.this), null);
        }
      }
    };
    this.xRv = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(42011);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameDetailUI2$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        com.tencent.mm.plugin.game.e.c.a(paramAnonymousView, GameDetailUI2.this);
        com.tencent.mm.game.report.f.a(GameDetailUI2.this.getContext(), 12, 1204, 999, 7, GameDetailUI2.f(GameDetailUI2.this), GameDetailUI2.g(GameDetailUI2.this), null);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameDetailUI2$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(42011);
      }
    };
    this.xRw = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(42012);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameDetailUI2$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        com.tencent.mm.plugin.game.e.c.a(paramAnonymousView, GameDetailUI2.this);
        com.tencent.mm.game.report.f.a(GameDetailUI2.this.getContext(), 12, 1205, 1, 7, GameDetailUI2.f(GameDetailUI2.this), GameDetailUI2.g(GameDetailUI2.this), null);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameDetailUI2$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(42012);
      }
    };
    this.xRx = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(42013);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameDetailUI2$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        com.tencent.mm.plugin.game.e.c.a(paramAnonymousView, GameDetailUI2.this);
        com.tencent.mm.game.report.f.a(GameDetailUI2.this.getContext(), 12, 1205, 999, 7, GameDetailUI2.f(GameDetailUI2.this), GameDetailUI2.g(GameDetailUI2.this), null);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameDetailUI2$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(42013);
      }
    };
    this.xRy = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(42014);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameDetailUI2$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        com.tencent.mm.plugin.game.e.c.a(paramAnonymousView, GameDetailUI2.this);
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
    if ((paramz.xGZ.xHa == null) || (paramz.xGZ.xHa.size() == 0)) {
      localObject1 = paramz.xGX.xLs;
    }
    if ((localObject1 == null) || (((LinkedList)localObject1).size() == 0))
    {
      this.xQR.setVisibility(8);
      AppMethodBeat.o(42038);
      return;
    }
    this.xQR.setVisibility(0);
    this.xQR.removeAllViews();
    paramz = ((LinkedList)localObject1).iterator();
    if (paramz.hasNext())
    {
      localObject1 = (ae)paramz.next();
      View localView = LayoutInflater.from(getContext()).inflate(2131494852, this.xQR, false);
      ImageView localImageView = (ImageView)localView.findViewById(2131301951);
      TextView localTextView1 = (TextView)localView.findViewById(2131301952);
      TextView localTextView2 = (TextView)localView.findViewById(2131301950);
      if (!Util.isNullOrNil(((ae)localObject1).UserName)) {
        a.b.a(localImageView, ((ae)localObject1).UserName, 0.5F, false);
      }
      for (;;)
      {
        localTextView1.setText(((ae)localObject1).Title);
        localTextView2.setText(((ae)localObject1).xKd);
        this.xQR.addView(localView);
        break;
        Object localObject2 = new c.a();
        ((c.a)localObject2).iaT = true;
        localObject2 = ((c.a)localObject2).bdv();
        com.tencent.mm.av.q.bcV().a(((ae)localObject1).xIJ, localImageView, (com.tencent.mm.av.a.a.c)localObject2);
      }
    }
    AppMethodBeat.o(42038);
  }
  
  private void b(aa paramaa)
  {
    int i = 0;
    AppMethodBeat.i(42037);
    List localList = paramaa.xHa;
    if ((localList == null) || (localList.size() == 0))
    {
      this.xQT.setVisibility(8);
      this.xQU.setVisibility(8);
      AppMethodBeat.o(42037);
      return;
    }
    this.xQT.setVisibility(0);
    if (localList.size() > 3) {
      this.xQU.setVisibility(0);
    }
    for (;;)
    {
      this.xQT.removeAllViews();
      i locali = new i(getContext());
      locali.Ve = 2131494849;
      locali.a(paramaa);
      locali.xGR = this.xGR;
      while ((i < localList.size()) && (i < 3))
      {
        paramaa = locali.getView(i, null, this.xQR);
        this.xQT.addView(paramaa);
        i += 1;
      }
      this.xQU.setVisibility(8);
    }
    AppMethodBeat.o(42037);
  }
  
  private void b(z paramz)
  {
    AppMethodBeat.i(42039);
    if ((paramz.dVF() != null) && (!paramz.dVF().isEmpty()))
    {
      this.xQV.setVisibility(0);
      if (!Util.isNullOrNil(paramz.dVE()))
      {
        this.xQW.setVisibility(0);
        this.xQW.setText(paramz.dVE());
        this.xQX.removeAllViews();
        if (paramz.dVG() != 1) {
          break label271;
        }
        this.xQX.setOrientation(1);
        this.xQY.setVisibility(8);
      }
      Object localObject;
      for (int i = 2131494844;; i = 2131494843)
      {
        localObject = paramz.dVF();
        if (localObject == null) {
          break label294;
        }
        localObject = ((LinkedList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          z.b localb = (z.b)((Iterator)localObject).next();
          View localView = LayoutInflater.from(getContext()).inflate(i, this.xQX, false);
          ImageView localImageView = (ImageView)localView.findViewById(2131301913);
          com.tencent.mm.av.q.bcV().loadImage(localb.icon, localImageView);
          if (paramz.dVG() == 1) {
            ((TextView)localView.findViewById(2131301914)).setText(localb.title);
          }
          ((TextView)localView.findViewById(2131301912)).setText(localb.desc);
          if (paramz.dVG() == 1)
          {
            localView.setTag(localb.url);
            localView.setOnClickListener(this.xRv);
          }
          this.xQX.addView(localView);
        }
        this.xQW.setVisibility(8);
        break;
        label271:
        this.xQX.setOrientation(0);
        this.xQY.setVisibility(0);
      }
      label294:
      if (paramz.xGX.xLA != null)
      {
        localObject = new z.a();
        ((z.a)localObject).title = paramz.xGX.xLA.summary;
        ((z.a)localObject).desc = paramz.xGX.xLA.desc;
        ((z.a)localObject).url = paramz.xGX.xLA.url;
        paramz = (z)localObject;
        if (paramz == null) {
          break label537;
        }
        this.xQZ.setVisibility(0);
        this.xRa.setText(paramz.title);
        if (Util.isNullOrNil(paramz.desc)) {
          break label525;
        }
        this.xRb.setVisibility(0);
        this.xRb.setText(paramz.desc);
      }
      for (;;)
      {
        this.xQZ.setTag(paramz.url);
        this.xQZ.setOnClickListener(this.xRv);
        AppMethodBeat.o(42039);
        return;
        if ((paramz.xGX.xLv != null) && (!Util.isNullOrNil(paramz.xGX.xLv.xMj)) && (!Util.isNullOrNil(paramz.xGX.xLv.xMk)))
        {
          localObject = new z.a();
          ((z.a)localObject).title = paramz.xGX.xLv.xMj;
          ((z.a)localObject).url = paramz.xGX.xLv.xMk;
          paramz = (z)localObject;
          break;
        }
        paramz = null;
        break;
        label525:
        this.xRb.setVisibility(8);
      }
      label537:
      this.xQZ.setVisibility(8);
      AppMethodBeat.o(42039);
      return;
    }
    this.xQV.setVisibility(8);
    AppMethodBeat.o(42039);
  }
  
  private void c(z paramz)
  {
    AppMethodBeat.i(42040);
    if ((paramz.dVK() != null) && (!paramz.dVK().isEmpty()))
    {
      this.xRn.setVisibility(0);
      if (!Util.isNullOrNil(paramz.dVJ()))
      {
        this.xRo.setVisibility(0);
        this.xRo.setText(paramz.dVJ());
      }
      for (;;)
      {
        this.xRp.removeAllViews();
        this.xRp.setOnClickListener(null);
        Iterator localIterator = paramz.dVK().iterator();
        while (localIterator.hasNext())
        {
          ci localci = (ci)localIterator.next();
          View localView = LayoutInflater.from(getContext()).inflate(2131494845, this.xRp, false);
          TextView localTextView1 = (TextView)localView.findViewById(2131301926);
          TextView localTextView2 = (TextView)localView.findViewById(2131301927);
          TextView localTextView3 = (TextView)localView.findViewById(2131301924);
          ImageView localImageView = (ImageView)localView.findViewById(2131301925);
          localTextView1.setText(localci.xMo);
          localTextView2.setText(localci.Title);
          localTextView3.setText(localci.xKd);
          com.tencent.mm.av.q.bcV().loadImage(localci.xMl, localImageView);
          localView.setTag(localci.xIB);
          localView.setOnClickListener(this.xRw);
          this.xRp.addView(localView);
        }
        this.xRo.setVisibility(8);
      }
      if (paramz.xGX.xLv == null) {
        paramz = null;
      }
      while (paramz != null)
      {
        this.xRq.setVisibility(0);
        this.xRq.setText((CharSequence)paramz.first);
        this.xRq.setTag(paramz.second);
        this.xRq.setOnClickListener(this.xRx);
        AppMethodBeat.o(42040);
        return;
        if ((Util.isNullOrNil(paramz.xGX.xLu.Title)) || (Util.isNullOrNil(paramz.xGX.xLu.xMk))) {
          paramz = null;
        } else {
          paramz = new Pair(paramz.xGX.xLu.xMj, paramz.xGX.xLu.xMk);
        }
      }
      this.xRq.setVisibility(8);
      AppMethodBeat.o(42040);
      return;
    }
    this.xRn.setVisibility(8);
    AppMethodBeat.o(42040);
  }
  
  private void dWn()
  {
    AppMethodBeat.i(42035);
    Object localObject = getIntent().getStringExtra("jump_game_center");
    if ((!Util.isNullOrNil((String)localObject)) && (((String)localObject).equals("jump_game_center")))
    {
      localObject = new Intent(this, GameCenterUI.class);
      ((Intent)localObject).putExtra("jump_find_more_friends", "jump_find_more_friends");
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/game/ui/GameDetailUI2", "backToGameCenterUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameDetailUI2", "backToGameCenterUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    AppMethodBeat.o(42035);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(42034);
    dWn();
    finish();
    AppMethodBeat.o(42034);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131494841;
  }
  
  public void initView()
  {
    AppMethodBeat.i(42036);
    setMMTitle(2131761194);
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
    this.xQK = ((ViewGroup)findViewById(2131301897));
    this.xQL = ((ImageView)findViewById(2131301898));
    this.xQM = ((ImageView)findViewById(2131301985));
    this.xQN = ((TextView)findViewById(2131302051));
    this.xQQ = ((TextView)findViewById(2131301992));
    this.xQO = ((Button)findViewById(2131301866));
    this.xQP = ((TextProgressBar)findViewById(2131302070));
    this.xQP.setTextSize(this.xQD);
    this.xQR = ((LinearLayout)findViewById(2131301949));
    this.xQS = ((GameDetailAutoScrollView)findViewById(2131301948));
    this.xQT = ((LinearLayout)findViewById(2131301930));
    this.xQU = ((TextView)findViewById(2131301932));
    this.xQV = ((LinearLayout)findViewById(2131301906));
    this.xQW = ((TextView)findViewById(2131301915));
    this.xQX = ((LinearLayout)findViewById(2131301907));
    this.xQY = ((ImageView)findViewById(2131301908));
    this.xQZ = findViewById(2131301909);
    this.xRa = ((TextView)findViewById(2131301911));
    this.xRb = ((TextView)findViewById(2131301910));
    this.xRc = findViewById(2131301916);
    this.xRd = ((TextView)findViewById(2131301920));
    this.xRe = ((ImageView)findViewById(2131301919));
    this.xRf = ((TextView)findViewById(2131301917));
    this.xRg = ((TextView)findViewById(2131301918));
    this.xRh = ((LinearLayout)findViewById(2131301901));
    this.xRi = ((GameMediaList)findViewById(2131301929));
    GameMediaList localGameMediaList = this.xRi;
    String str = this.appId;
    int i = this.xGR;
    localGameMediaList.appId = str;
    localGameMediaList.sQn = 12;
    localGameMediaList.xSP = i;
    localGameMediaList.mContext = this;
    this.xRi.setItemLayout(2131494909);
    this.xRj = ((TextView)findViewById(2131301904));
    this.xRk = ((TextView)findViewById(2131301902));
    this.xRk.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
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
    this.xRl = ((TextView)findViewById(2131301905));
    this.xRl.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(42020);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameDetailUI2$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (!GameDetailUI2.d(GameDetailUI2.this))
        {
          GameDetailUI2.b(GameDetailUI2.this).setMaxLines(100);
          GameDetailUI2.c(GameDetailUI2.this).setText(GameDetailUI2.this.getResources().getText(2131761180));
          GameDetailUI2.a(GameDetailUI2.this, true);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameDetailUI2$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(42020);
          return;
          GameDetailUI2.b(GameDetailUI2.this).setMaxLines(3);
          GameDetailUI2.c(GameDetailUI2.this).setText(GameDetailUI2.this.getResources().getText(2131761179));
          GameDetailUI2.a(GameDetailUI2.this, false);
        }
      }
    });
    this.xRn = ((LinearLayout)findViewById(2131301921));
    this.xRo = ((TextView)findViewById(2131301928));
    this.xRp = ((LinearLayout)findViewById(2131301922));
    this.xRq = ((TextView)findViewById(2131301923));
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
        if (this.xQJ != null)
        {
          this.xQJ.cCq();
          AppMethodBeat.o(42042);
          return;
        }
        break;
      case 2: 
        if ((this.xEP != null) && (this.xQJ != null))
        {
          this.xQJ.dVj();
          this.xQI.a(this.xEP, this.xQJ);
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
          String str1 = this.xRr.xIJ;
          paramIntent = str1;
          if (Util.isNullOrNil(str1)) {
            paramIntent = this.xEP.field_appIconUrl;
          }
          ab.a.Kgn.a(this.mController, this.xRr.xNi, paramIntent, this.xRr.xNj, true, getResources().getString(2131755976), new y.a()
          {
            public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
            {
              AppMethodBeat.i(42018);
              if (paramAnonymousBoolean)
              {
                GameDetailUI2.a(GameDetailUI2.this, str2, paramAnonymousString);
                com.tencent.mm.ui.base.h.cD(GameDetailUI2.this, GameDetailUI2.this.getResources().getString(2131757788));
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
        com.tencent.mm.game.report.f.a(getContext(), 12, 1207, 2, 15, this.appId, this.xGR, null);
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
    if (!g.aAc())
    {
      Log.e("MicroMsg.GameDetailUI2", "account not ready");
      finish();
      AppMethodBeat.o(42030);
      return;
    }
    this.xQE = true;
    this.xQF = false;
    this.appId = getIntent().getStringExtra("game_app_id");
    if (Util.isNullOrNil(this.appId))
    {
      Log.e("MicroMsg.GameDetailUI2", "appid is null or nill");
      finish();
      initView();
      g.azz().a(1217, this);
      paramBundle = ((com.tencent.mm.plugin.game.api.f)g.af(com.tencent.mm.plugin.game.api.f.class)).dSL().azn(this.appId);
      if ((paramBundle != null) && (paramBundle.length != 0)) {
        break label220;
      }
      Log.i("MicroMsg.GameDetailUI2", "No cache found");
    }
    for (int i = 0;; i = 1)
    {
      if (i == 0)
      {
        this.rAV = com.tencent.mm.plugin.game.e.c.gl(this);
        this.rAV.show();
      }
      paramBundle = LocaleUtil.getApplicationLanguage();
      boolean bool = com.tencent.mm.pluginsdk.model.app.h.s(this, this.appId);
      paramBundle = new am(paramBundle, this.appId, bool);
      g.azz().a(paramBundle, 0);
      AppMethodBeat.o(42030);
      return;
      this.xGR = getIntent().getIntExtra("game_report_from_scene", 0);
      break;
      label220:
      g.aAk().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(42022);
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(42021);
              GameDetailUI2.a(GameDetailUI2.this, this.xRC);
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
    g.azz().b(1217, this);
    if (this.xQH != null) {
      k.b(this.xQH);
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
    if ((this.xEP != null) && (this.xQJ != null))
    {
      this.xQJ.cCq();
      this.xQI.a(this.xQP, this.xQO, this.xEP, this.xQJ);
    }
    if (!this.xQE)
    {
      b(new aa(this.appId));
      AppMethodBeat.o(42031);
      return;
    }
    this.xQE = false;
    AppMethodBeat.o(42031);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(42041);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      if (!com.tencent.mm.plugin.game.a.a.jRu.a(this, paramInt1, paramInt2, paramString)) {
        Toast.makeText(this, getString(2131761264, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      }
      if (this.rAV != null) {
        this.rAV.cancel();
      }
      AppMethodBeat.o(42041);
      return;
    }
    switch (paramq.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(42041);
      return;
      paramString = ((am)paramq).hhm.iLL.iLR;
      g.aAk().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(42025);
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(42024);
              GameDetailUI2.a(GameDetailUI2.this, this.xRC);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDetailUI2
 * JD-Core Version:    0.7.0.1
 */