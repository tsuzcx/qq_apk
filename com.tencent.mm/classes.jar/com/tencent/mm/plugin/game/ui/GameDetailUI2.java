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
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.o;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.plugin.game.d.ba;
import com.tencent.mm.plugin.game.d.br;
import com.tencent.mm.plugin.game.d.bv;
import com.tencent.mm.plugin.game.d.bw;
import com.tencent.mm.plugin.game.d.db;
import com.tencent.mm.plugin.game.d.x;
import com.tencent.mm.plugin.game.model.aa;
import com.tencent.mm.plugin.game.model.am;
import com.tencent.mm.plugin.game.model.k.a;
import com.tencent.mm.plugin.game.model.w;
import com.tencent.mm.plugin.game.model.z;
import com.tencent.mm.plugin.game.model.z.a;
import com.tencent.mm.plugin.game.model.z.b;
import com.tencent.mm.plugin.game.widget.TextProgressBar;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.ab.a;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GameDetailUI2
  extends MMActivity
  implements com.tencent.mm.ak.g
{
  private String appId;
  private Dialog pzQ;
  private com.tencent.mm.plugin.game.model.c tdF;
  private int tfA;
  private String toI;
  private String toJ;
  private int toL;
  private boolean toM;
  private boolean toN;
  private String toO;
  private k.a toP;
  private d toQ;
  private com.tencent.mm.plugin.game.model.l toR;
  private ViewGroup toS;
  private ImageView toT;
  private ImageView toU;
  private TextView toV;
  private Button toW;
  private TextProgressBar toX;
  private TextView toY;
  private LinearLayout toZ;
  private DialogInterface.OnClickListener tpA;
  private View.OnClickListener tpB;
  private View.OnClickListener tpC;
  private View.OnClickListener tpD;
  private View.OnClickListener tpE;
  private View.OnClickListener tpF;
  private View.OnClickListener tpG;
  private GameDetailAutoScrollView tpa;
  private LinearLayout tpb;
  private TextView tpc;
  private LinearLayout tpd;
  private TextView tpe;
  private LinearLayout tpf;
  private ImageView tpg;
  private View tph;
  private TextView tpi;
  private TextView tpj;
  private View tpk;
  private TextView tpl;
  private ImageView tpm;
  private TextView tpn;
  private TextView tpo;
  private LinearLayout tpp;
  private GameMediaList tpq;
  private TextView tpr;
  private TextView tps;
  private TextView tpt;
  private boolean tpu;
  private LinearLayout tpv;
  private TextView tpw;
  private LinearLayout tpx;
  private TextView tpy;
  private db tpz;
  
  public GameDetailUI2()
  {
    AppMethodBeat.i(42029);
    this.appId = null;
    this.tdF = null;
    this.toI = null;
    this.toJ = null;
    this.toL = 18;
    this.tfA = 0;
    this.toO = null;
    this.toP = null;
    this.toQ = null;
    this.toR = null;
    this.tpu = false;
    this.tpA = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(42026);
        GameDetailUI2.i(GameDetailUI2.this).bYH();
        GameDetailUI2.m(GameDetailUI2.this).a(GameDetailUI2.j(GameDetailUI2.this), GameDetailUI2.k(GameDetailUI2.this), GameDetailUI2.l(GameDetailUI2.this), GameDetailUI2.i(GameDetailUI2.this));
        AppMethodBeat.o(42026);
      }
    };
    this.tpB = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(42027);
        if (GameDetailUI2.l(GameDetailUI2.this) == null)
        {
          ac.e("MicroMsg.GameDetailUI2", "Null appInfo");
          AppMethodBeat.o(42027);
          return;
        }
        if (GameDetailUI2.i(GameDetailUI2.this) == null)
        {
          ac.e("MicroMsg.GameDetailUI2", "No DownloadInfo found");
          AppMethodBeat.o(42027);
          return;
        }
        GameDetailUI2.i(GameDetailUI2.this).fu(GameDetailUI2.this.getContext());
        GameDetailUI2.m(GameDetailUI2.this).a(GameDetailUI2.l(GameDetailUI2.this), GameDetailUI2.i(GameDetailUI2.this));
        AppMethodBeat.o(42027);
      }
    };
    this.tpC = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(42028);
        if ((paramAnonymousView.getTag() instanceof String))
        {
          com.tencent.mm.plugin.game.f.c.a(paramAnonymousView, GameDetailUI2.this);
          com.tencent.mm.game.report.e.a(GameDetailUI2.this.getContext(), 12, 1203, 999, 7, GameDetailUI2.f(GameDetailUI2.this), GameDetailUI2.g(GameDetailUI2.this), null);
          AppMethodBeat.o(42028);
          return;
        }
        Object localObject = new GameDetailRankUI.a();
        ((GameDetailRankUI.a)localObject).toI = GameDetailUI2.n(GameDetailUI2.this);
        ((GameDetailRankUI.a)localObject).toJ = GameDetailUI2.o(GameDetailUI2.this);
        ((GameDetailRankUI.a)localObject).toK = GameDetailUI2.l(GameDetailUI2.this);
        paramAnonymousView = y.xJ("rankData");
        y.ayq().F(paramAnonymousView, true).l(GameDetailRankUI.toG, localObject);
        localObject = new Intent(GameDetailUI2.this.getContext(), GameDetailRankUI.class);
        ((Intent)localObject).putExtra(GameDetailRankUI.EXTRA_SESSION_ID, paramAnonymousView);
        paramAnonymousView = GameDetailUI2.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/game/ui/GameDetailUI2$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/game/ui/GameDetailUI2$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.game.report.e.a(GameDetailUI2.this.getContext(), 12, 1203, 999, 6, GameDetailUI2.f(GameDetailUI2.this), GameDetailUI2.g(GameDetailUI2.this), null);
        AppMethodBeat.o(42028);
      }
    };
    this.tpD = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(42011);
        com.tencent.mm.plugin.game.f.c.a(paramAnonymousView, GameDetailUI2.this);
        com.tencent.mm.game.report.e.a(GameDetailUI2.this.getContext(), 12, 1204, 999, 7, GameDetailUI2.f(GameDetailUI2.this), GameDetailUI2.g(GameDetailUI2.this), null);
        AppMethodBeat.o(42011);
      }
    };
    this.tpE = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(42012);
        com.tencent.mm.plugin.game.f.c.a(paramAnonymousView, GameDetailUI2.this);
        com.tencent.mm.game.report.e.a(GameDetailUI2.this.getContext(), 12, 1205, 1, 7, GameDetailUI2.f(GameDetailUI2.this), GameDetailUI2.g(GameDetailUI2.this), null);
        AppMethodBeat.o(42012);
      }
    };
    this.tpF = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(42013);
        com.tencent.mm.plugin.game.f.c.a(paramAnonymousView, GameDetailUI2.this);
        com.tencent.mm.game.report.e.a(GameDetailUI2.this.getContext(), 12, 1205, 999, 7, GameDetailUI2.f(GameDetailUI2.this), GameDetailUI2.g(GameDetailUI2.this), null);
        AppMethodBeat.o(42013);
      }
    };
    this.tpG = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(42014);
        com.tencent.mm.plugin.game.f.c.a(paramAnonymousView, GameDetailUI2.this);
        com.tencent.mm.game.report.e.a(GameDetailUI2.this.getContext(), 12, 1206, 1, 7, GameDetailUI2.f(GameDetailUI2.this), GameDetailUI2.g(GameDetailUI2.this), null);
        AppMethodBeat.o(42014);
      }
    };
    AppMethodBeat.o(42029);
  }
  
  private void a(z paramz)
  {
    AppMethodBeat.i(42038);
    Object localObject1 = null;
    if ((paramz.tfI.tfJ == null) || (paramz.tfI.tfJ.size() == 0)) {
      localObject1 = paramz.tfG.tjO;
    }
    if ((localObject1 == null) || (((LinkedList)localObject1).size() == 0))
    {
      this.toZ.setVisibility(8);
      AppMethodBeat.o(42038);
      return;
    }
    this.toZ.setVisibility(0);
    this.toZ.removeAllViews();
    paramz = ((LinkedList)localObject1).iterator();
    if (paramz.hasNext())
    {
      localObject1 = (x)paramz.next();
      View localView = LayoutInflater.from(getContext()).inflate(2131494290, this.toZ, false);
      ImageView localImageView = (ImageView)localView.findViewById(2131300428);
      TextView localTextView1 = (TextView)localView.findViewById(2131300429);
      TextView localTextView2 = (TextView)localView.findViewById(2131300427);
      if (!com.tencent.mm.sdk.platformtools.bs.isNullOrNil(((x)localObject1).ncR)) {
        a.b.a(localImageView, ((x)localObject1).ncR, 0.5F, false);
      }
      for (;;)
      {
        localTextView1.setText(((x)localObject1).Title);
        localTextView2.setText(((x)localObject1).tiv);
        this.toZ.addView(localView);
        break;
        Object localObject2 = new c.a();
        ((c.a)localObject2).gLt = true;
        localObject2 = ((c.a)localObject2).aFT();
        o.aFB().a(((x)localObject1).thp, localImageView, (com.tencent.mm.av.a.a.c)localObject2);
      }
    }
    AppMethodBeat.o(42038);
  }
  
  private void b(aa paramaa)
  {
    int i = 0;
    AppMethodBeat.i(42037);
    List localList = paramaa.tfJ;
    if ((localList == null) || (localList.size() == 0))
    {
      this.tpb.setVisibility(8);
      this.tpc.setVisibility(8);
      AppMethodBeat.o(42037);
      return;
    }
    this.tpb.setVisibility(0);
    if (localList.size() > 3) {
      this.tpc.setVisibility(0);
    }
    for (;;)
    {
      this.tpb.removeAllViews();
      i locali = new i(getContext());
      locali.Tb = 2131494287;
      locali.a(paramaa);
      locali.tfA = this.tfA;
      while ((i < localList.size()) && (i < 3))
      {
        paramaa = locali.getView(i, null, this.toZ);
        this.tpb.addView(paramaa);
        i += 1;
      }
      this.tpc.setVisibility(8);
    }
    AppMethodBeat.o(42037);
  }
  
  private void b(z paramz)
  {
    AppMethodBeat.i(42039);
    if ((paramz.cQH() != null) && (!paramz.cQH().isEmpty()))
    {
      this.tpd.setVisibility(0);
      if (!com.tencent.mm.sdk.platformtools.bs.isNullOrNil(paramz.cQG()))
      {
        this.tpe.setVisibility(0);
        this.tpe.setText(paramz.cQG());
        this.tpf.removeAllViews();
        if (paramz.cQI() != 1) {
          break label271;
        }
        this.tpf.setOrientation(1);
        this.tpg.setVisibility(8);
      }
      Object localObject;
      for (int i = 2131494282;; i = 2131494281)
      {
        localObject = paramz.cQH();
        if (localObject == null) {
          break label294;
        }
        localObject = ((LinkedList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          z.b localb = (z.b)((Iterator)localObject).next();
          View localView = LayoutInflater.from(getContext()).inflate(i, this.tpf, false);
          ImageView localImageView = (ImageView)localView.findViewById(2131300390);
          o.aFB().loadImage(localb.drM, localImageView);
          if (paramz.cQI() == 1) {
            ((TextView)localView.findViewById(2131300391)).setText(localb.title);
          }
          ((TextView)localView.findViewById(2131300389)).setText(localb.desc);
          if (paramz.cQI() == 1)
          {
            localView.setTag(localb.url);
            localView.setOnClickListener(this.tpD);
          }
          this.tpf.addView(localView);
        }
        this.tpe.setVisibility(8);
        break;
        label271:
        this.tpf.setOrientation(0);
        this.tpg.setVisibility(0);
      }
      label294:
      if (paramz.tfG.tjW != null)
      {
        localObject = new z.a();
        ((z.a)localObject).title = paramz.tfG.tjW.summary;
        ((z.a)localObject).desc = paramz.tfG.tjW.desc;
        ((z.a)localObject).url = paramz.tfG.tjW.url;
        paramz = (z)localObject;
        if (paramz == null) {
          break label537;
        }
        this.tph.setVisibility(0);
        this.tpi.setText(paramz.title);
        if (com.tencent.mm.sdk.platformtools.bs.isNullOrNil(paramz.desc)) {
          break label525;
        }
        this.tpj.setVisibility(0);
        this.tpj.setText(paramz.desc);
      }
      for (;;)
      {
        this.tph.setTag(paramz.url);
        this.tph.setOnClickListener(this.tpD);
        AppMethodBeat.o(42039);
        return;
        if ((paramz.tfG.tjR != null) && (!com.tencent.mm.sdk.platformtools.bs.isNullOrNil(paramz.tfG.tjR.tkE)) && (!com.tencent.mm.sdk.platformtools.bs.isNullOrNil(paramz.tfG.tjR.tkF)))
        {
          localObject = new z.a();
          ((z.a)localObject).title = paramz.tfG.tjR.tkE;
          ((z.a)localObject).url = paramz.tfG.tjR.tkF;
          paramz = (z)localObject;
          break;
        }
        paramz = null;
        break;
        label525:
        this.tpj.setVisibility(8);
      }
      label537:
      this.tph.setVisibility(8);
      AppMethodBeat.o(42039);
      return;
    }
    this.tpd.setVisibility(8);
    AppMethodBeat.o(42039);
  }
  
  private void c(z paramz)
  {
    AppMethodBeat.i(42040);
    if ((paramz.cQM() != null) && (!paramz.cQM().isEmpty()))
    {
      this.tpv.setVisibility(0);
      if (!com.tencent.mm.sdk.platformtools.bs.isNullOrNil(paramz.cQL()))
      {
        this.tpw.setVisibility(0);
        this.tpw.setText(paramz.cQL());
      }
      for (;;)
      {
        this.tpx.removeAllViews();
        this.tpx.setOnClickListener(null);
        Iterator localIterator = paramz.cQM().iterator();
        while (localIterator.hasNext())
        {
          bw localbw = (bw)localIterator.next();
          View localView = LayoutInflater.from(getContext()).inflate(2131494283, this.tpx, false);
          TextView localTextView1 = (TextView)localView.findViewById(2131300403);
          TextView localTextView2 = (TextView)localView.findViewById(2131300404);
          TextView localTextView3 = (TextView)localView.findViewById(2131300401);
          ImageView localImageView = (ImageView)localView.findViewById(2131300402);
          localTextView1.setText(localbw.tkJ);
          localTextView2.setText(localbw.Title);
          localTextView3.setText(localbw.tiv);
          o.aFB().loadImage(localbw.tkG, localImageView);
          localView.setTag(localbw.thk);
          localView.setOnClickListener(this.tpE);
          this.tpx.addView(localView);
        }
        this.tpw.setVisibility(8);
      }
      if (paramz.tfG.tjR == null) {
        paramz = null;
      }
      while (paramz != null)
      {
        this.tpy.setVisibility(0);
        this.tpy.setText((CharSequence)paramz.first);
        this.tpy.setTag(paramz.second);
        this.tpy.setOnClickListener(this.tpF);
        AppMethodBeat.o(42040);
        return;
        if ((com.tencent.mm.sdk.platformtools.bs.isNullOrNil(paramz.tfG.tjQ.Title)) || (com.tencent.mm.sdk.platformtools.bs.isNullOrNil(paramz.tfG.tjQ.tkF))) {
          paramz = null;
        } else {
          paramz = new Pair(paramz.tfG.tjQ.tkE, paramz.tfG.tjQ.tkF);
        }
      }
      this.tpy.setVisibility(8);
      AppMethodBeat.o(42040);
      return;
    }
    this.tpv.setVisibility(8);
    AppMethodBeat.o(42040);
  }
  
  private void cRq()
  {
    AppMethodBeat.i(42035);
    Object localObject = getIntent().getStringExtra("jump_game_center");
    if ((!com.tencent.mm.sdk.platformtools.bs.isNullOrNil((String)localObject)) && (((String)localObject).equals("jump_game_center")))
    {
      localObject = new Intent(this, GameCenterUI.class);
      ((Intent)localObject).putExtra("jump_find_more_friends", "jump_find_more_friends");
      localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/game/ui/GameDetailUI2", "backToGameCenterUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameDetailUI2", "backToGameCenterUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    AppMethodBeat.o(42035);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(42034);
    cRq();
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
    this.toS = ((ViewGroup)findViewById(2131300374));
    this.toT = ((ImageView)findViewById(2131300375));
    this.toU = ((ImageView)findViewById(2131300462));
    this.toV = ((TextView)findViewById(2131300524));
    this.toY = ((TextView)findViewById(2131300469));
    this.toW = ((Button)findViewById(2131300344));
    this.toX = ((TextProgressBar)findViewById(2131300538));
    this.toX.setTextSize(this.toL);
    this.toZ = ((LinearLayout)findViewById(2131300426));
    this.tpa = ((GameDetailAutoScrollView)findViewById(2131300425));
    this.tpb = ((LinearLayout)findViewById(2131300407));
    this.tpc = ((TextView)findViewById(2131300409));
    this.tpd = ((LinearLayout)findViewById(2131300383));
    this.tpe = ((TextView)findViewById(2131300392));
    this.tpf = ((LinearLayout)findViewById(2131300384));
    this.tpg = ((ImageView)findViewById(2131300385));
    this.tph = findViewById(2131300386);
    this.tpi = ((TextView)findViewById(2131300388));
    this.tpj = ((TextView)findViewById(2131300387));
    this.tpk = findViewById(2131300393);
    this.tpl = ((TextView)findViewById(2131300397));
    this.tpm = ((ImageView)findViewById(2131300396));
    this.tpn = ((TextView)findViewById(2131300394));
    this.tpo = ((TextView)findViewById(2131300395));
    this.tpp = ((LinearLayout)findViewById(2131300378));
    this.tpq = ((GameMediaList)findViewById(2131300406));
    GameMediaList localGameMediaList = this.tpq;
    String str = this.appId;
    int i = this.tfA;
    localGameMediaList.appId = str;
    localGameMediaList.qwN = 12;
    localGameMediaList.tqY = i;
    localGameMediaList.mContext = this;
    this.tpq.setItemLayout(2131494344);
    this.tpr = ((TextView)findViewById(2131300381));
    this.tps = ((TextView)findViewById(2131300379));
    this.tps.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
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
    this.tpt = ((TextView)findViewById(2131300382));
    this.tpt.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(42020);
        if (!GameDetailUI2.d(GameDetailUI2.this))
        {
          GameDetailUI2.b(GameDetailUI2.this).setMaxLines(100);
          GameDetailUI2.c(GameDetailUI2.this).setText(GameDetailUI2.this.getResources().getText(2131759845));
          GameDetailUI2.a(GameDetailUI2.this, true);
          AppMethodBeat.o(42020);
          return;
        }
        GameDetailUI2.b(GameDetailUI2.this).setMaxLines(3);
        GameDetailUI2.c(GameDetailUI2.this).setText(GameDetailUI2.this.getResources().getText(2131759844));
        GameDetailUI2.a(GameDetailUI2.this, false);
        AppMethodBeat.o(42020);
      }
    });
    this.tpv = ((LinearLayout)findViewById(2131300398));
    this.tpw = ((TextView)findViewById(2131300405));
    this.tpx = ((LinearLayout)findViewById(2131300399));
    this.tpy = ((TextView)findViewById(2131300400));
    AppMethodBeat.o(42036);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(42042);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ac.i("MicroMsg.GameDetailUI2", "requestCode = %d, resultCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    switch (paramInt1)
    {
    default: 
      ac.e("MicroMsg.GameDetailUI2", "error request code");
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
        if (this.toR != null)
        {
          this.toR.bYH();
          AppMethodBeat.o(42042);
          return;
        }
        break;
      case 2: 
        if ((this.tdF != null) && (this.toR != null))
        {
          this.toR.cQn();
          this.toQ.a(this.tdF, this.toR);
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
        if (!com.tencent.mm.sdk.platformtools.bs.isNullOrNil(str2))
        {
          String str1 = this.tpz.thp;
          paramIntent = str1;
          if (com.tencent.mm.sdk.platformtools.bs.isNullOrNil(str1)) {
            paramIntent = this.tdF.field_appIconUrl;
          }
          ab.a.DrY.a(this.mController, this.tpz.tlA, paramIntent, this.tpz.tlB, true, getResources().getString(2131755884), new y.a()
          {
            public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
            {
              AppMethodBeat.i(42018);
              if (paramAnonymousBoolean)
              {
                GameDetailUI2.a(GameDetailUI2.this, str2, paramAnonymousString);
                com.tencent.mm.ui.base.h.cg(GameDetailUI2.this, GameDetailUI2.this.getResources().getString(2131757561));
                com.tencent.mm.game.report.e.a(GameDetailUI2.this.getContext(), 12, 1207, 2, 14, GameDetailUI2.f(GameDetailUI2.this), GameDetailUI2.g(GameDetailUI2.this), null);
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
        com.tencent.mm.game.report.e.a(getContext(), 12, 1207, 2, 15, this.appId, this.tfA, null);
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
    if (!com.tencent.mm.kernel.g.agM())
    {
      ac.e("MicroMsg.GameDetailUI2", "account not ready");
      finish();
      AppMethodBeat.o(42030);
      return;
    }
    this.toM = true;
    this.toN = false;
    this.appId = getIntent().getStringExtra("game_app_id");
    if (com.tencent.mm.sdk.platformtools.bs.isNullOrNil(this.appId))
    {
      ac.e("MicroMsg.GameDetailUI2", "appid is null or nill");
      finish();
      initView();
      com.tencent.mm.kernel.g.agi().a(1217, this);
      paramBundle = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cOn().agO(this.appId);
      if ((paramBundle != null) && (paramBundle.length != 0)) {
        break label220;
      }
      ac.i("MicroMsg.GameDetailUI2", "No cache found");
    }
    for (int i = 0;; i = 1)
    {
      if (i == 0)
      {
        this.pzQ = com.tencent.mm.plugin.game.f.c.fv(this);
        this.pzQ.show();
      }
      paramBundle = com.tencent.mm.sdk.platformtools.ab.eUO();
      boolean bool = com.tencent.mm.pluginsdk.model.app.h.t(this, this.appId);
      paramBundle = new am(paramBundle, this.appId, bool);
      com.tencent.mm.kernel.g.agi().a(paramBundle, 0);
      AppMethodBeat.o(42030);
      return;
      this.tfA = getIntent().getIntExtra("game_report_from_scene", 0);
      break;
      label220:
      com.tencent.mm.kernel.g.agU().az(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(42022);
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(42021);
              GameDetailUI2.a(GameDetailUI2.this, this.tpK);
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
    com.tencent.mm.kernel.g.agi().b(1217, this);
    if (this.toP != null) {
      com.tencent.mm.plugin.game.model.k.b(this.toP);
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
    if ((this.tdF != null) && (this.toR != null))
    {
      this.toR.bYH();
      this.toQ.a(this.toX, this.toW, this.tdF, this.toR);
    }
    if (!this.toM)
    {
      b(new aa(this.appId));
      AppMethodBeat.o(42031);
      return;
    }
    this.toM = false;
    AppMethodBeat.o(42031);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, n paramn)
  {
    AppMethodBeat.i(42041);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      if (!com.tencent.mm.plugin.game.a.a.iyy.a(this, paramInt1, paramInt2, paramString)) {
        Toast.makeText(this, getString(2131759916, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      }
      if (this.pzQ != null) {
        this.pzQ.cancel();
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
      paramString = ((am)paramn).fYA.hvs.hvw;
      com.tencent.mm.kernel.g.agU().az(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(42025);
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(42024);
              GameDetailUI2.a(GameDetailUI2.this, this.tpK);
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