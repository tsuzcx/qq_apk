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
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.aw.o;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.plugin.game.d.ba;
import com.tencent.mm.plugin.game.d.br;
import com.tencent.mm.plugin.game.d.bs;
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
import com.tencent.mm.pluginsdk.ui.applet.ab;
import com.tencent.mm.pluginsdk.ui.applet.ab.a;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GameDetailUI2
  extends MMActivity
  implements com.tencent.mm.al.g
{
  private String appId;
  private Dialog oWF;
  private com.tencent.mm.plugin.game.model.c rVN;
  private int rXI;
  private String sgO;
  private String sgP;
  private int sgR;
  private boolean sgS;
  private boolean sgT;
  private String sgU;
  private k.a sgV;
  private d sgW;
  private com.tencent.mm.plugin.game.model.l sgX;
  private ViewGroup sgY;
  private ImageView sgZ;
  private boolean shA;
  private LinearLayout shB;
  private TextView shC;
  private LinearLayout shD;
  private TextView shE;
  private db shF;
  private DialogInterface.OnClickListener shG;
  private View.OnClickListener shH;
  private View.OnClickListener shI;
  private View.OnClickListener shJ;
  private View.OnClickListener shK;
  private View.OnClickListener shL;
  private View.OnClickListener shM;
  private ImageView sha;
  private TextView shb;
  private Button shc;
  private TextProgressBar shd;
  private TextView she;
  private LinearLayout shf;
  private GameDetailAutoScrollView shg;
  private LinearLayout shh;
  private TextView shi;
  private LinearLayout shj;
  private TextView shk;
  private LinearLayout shl;
  private ImageView shm;
  private View shn;
  private TextView sho;
  private TextView shp;
  private View shq;
  private TextView shr;
  private ImageView shs;
  private TextView sht;
  private TextView shu;
  private LinearLayout shv;
  private GameMediaList shw;
  private TextView shx;
  private TextView shy;
  private TextView shz;
  
  public GameDetailUI2()
  {
    AppMethodBeat.i(42029);
    this.appId = null;
    this.rVN = null;
    this.sgO = null;
    this.sgP = null;
    this.sgR = 18;
    this.rXI = 0;
    this.sgU = null;
    this.sgV = null;
    this.sgW = null;
    this.sgX = null;
    this.shA = false;
    this.shG = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(42026);
        GameDetailUI2.i(GameDetailUI2.this).bRs();
        GameDetailUI2.m(GameDetailUI2.this).a(GameDetailUI2.j(GameDetailUI2.this), GameDetailUI2.k(GameDetailUI2.this), GameDetailUI2.l(GameDetailUI2.this), GameDetailUI2.i(GameDetailUI2.this));
        AppMethodBeat.o(42026);
      }
    };
    this.shH = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(42027);
        if (GameDetailUI2.l(GameDetailUI2.this) == null)
        {
          ad.e("MicroMsg.GameDetailUI2", "Null appInfo");
          AppMethodBeat.o(42027);
          return;
        }
        if (GameDetailUI2.i(GameDetailUI2.this) == null)
        {
          ad.e("MicroMsg.GameDetailUI2", "No DownloadInfo found");
          AppMethodBeat.o(42027);
          return;
        }
        GameDetailUI2.i(GameDetailUI2.this).fh(GameDetailUI2.this.getContext());
        GameDetailUI2.m(GameDetailUI2.this).a(GameDetailUI2.l(GameDetailUI2.this), GameDetailUI2.i(GameDetailUI2.this));
        AppMethodBeat.o(42027);
      }
    };
    this.shI = new View.OnClickListener()
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
        ((GameDetailRankUI.a)localObject).sgO = GameDetailUI2.n(GameDetailUI2.this);
        ((GameDetailRankUI.a)localObject).sgP = GameDetailUI2.o(GameDetailUI2.this);
        ((GameDetailRankUI.a)localObject).sgQ = GameDetailUI2.l(GameDetailUI2.this);
        paramAnonymousView = y.tD("rankData");
        y.arz().E(paramAnonymousView, true).m(GameDetailRankUI.sgM, localObject);
        localObject = new Intent(GameDetailUI2.this.getContext(), GameDetailRankUI.class);
        ((Intent)localObject).putExtra(GameDetailRankUI.EXTRA_SESSION_ID, paramAnonymousView);
        paramAnonymousView = GameDetailUI2.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/game/ui/GameDetailUI2$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/game/ui/GameDetailUI2$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.game.report.e.a(GameDetailUI2.this.getContext(), 12, 1203, 999, 6, GameDetailUI2.f(GameDetailUI2.this), GameDetailUI2.g(GameDetailUI2.this), null);
        AppMethodBeat.o(42028);
      }
    };
    this.shJ = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(42011);
        com.tencent.mm.plugin.game.f.c.a(paramAnonymousView, GameDetailUI2.this);
        com.tencent.mm.game.report.e.a(GameDetailUI2.this.getContext(), 12, 1204, 999, 7, GameDetailUI2.f(GameDetailUI2.this), GameDetailUI2.g(GameDetailUI2.this), null);
        AppMethodBeat.o(42011);
      }
    };
    this.shK = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(42012);
        com.tencent.mm.plugin.game.f.c.a(paramAnonymousView, GameDetailUI2.this);
        com.tencent.mm.game.report.e.a(GameDetailUI2.this.getContext(), 12, 1205, 1, 7, GameDetailUI2.f(GameDetailUI2.this), GameDetailUI2.g(GameDetailUI2.this), null);
        AppMethodBeat.o(42012);
      }
    };
    this.shL = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(42013);
        com.tencent.mm.plugin.game.f.c.a(paramAnonymousView, GameDetailUI2.this);
        com.tencent.mm.game.report.e.a(GameDetailUI2.this.getContext(), 12, 1205, 999, 7, GameDetailUI2.f(GameDetailUI2.this), GameDetailUI2.g(GameDetailUI2.this), null);
        AppMethodBeat.o(42013);
      }
    };
    this.shM = new View.OnClickListener()
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
    if ((paramz.rXQ.rXR == null) || (paramz.rXQ.rXR.size() == 0)) {
      localObject1 = paramz.rXO.sbU;
    }
    if ((localObject1 == null) || (((LinkedList)localObject1).size() == 0))
    {
      this.shf.setVisibility(8);
      AppMethodBeat.o(42038);
      return;
    }
    this.shf.setVisibility(0);
    this.shf.removeAllViews();
    paramz = ((LinkedList)localObject1).iterator();
    if (paramz.hasNext())
    {
      localObject1 = (x)paramz.next();
      View localView = LayoutInflater.from(getContext()).inflate(2131494290, this.shf, false);
      ImageView localImageView = (ImageView)localView.findViewById(2131300428);
      TextView localTextView1 = (TextView)localView.findViewById(2131300429);
      TextView localTextView2 = (TextView)localView.findViewById(2131300427);
      if (!bt.isNullOrNil(((x)localObject1).mAQ)) {
        a.b.a(localImageView, ((x)localObject1).mAQ, 0.5F, false);
      }
      for (;;)
      {
        localTextView1.setText(((x)localObject1).Title);
        localTextView2.setText(((x)localObject1).saB);
        this.shf.addView(localView);
        break;
        Object localObject2 = new c.a();
        ((c.a)localObject2).gkG = true;
        localObject2 = ((c.a)localObject2).azc();
        o.ayJ().a(((x)localObject1).rZw, localImageView, (com.tencent.mm.aw.a.a.c)localObject2);
      }
    }
    AppMethodBeat.o(42038);
  }
  
  private void b(aa paramaa)
  {
    int i = 0;
    AppMethodBeat.i(42037);
    List localList = paramaa.rXR;
    if ((localList == null) || (localList.size() == 0))
    {
      this.shh.setVisibility(8);
      this.shi.setVisibility(8);
      AppMethodBeat.o(42037);
      return;
    }
    this.shh.setVisibility(0);
    if (localList.size() > 3) {
      this.shi.setVisibility(0);
    }
    for (;;)
    {
      this.shh.removeAllViews();
      i locali = new i(getContext());
      locali.Sg = 2131494287;
      locali.a(paramaa);
      locali.rXI = this.rXI;
      while ((i < localList.size()) && (i < 3))
      {
        paramaa = locali.getView(i, null, this.shf);
        this.shh.addView(paramaa);
        i += 1;
      }
      this.shi.setVisibility(8);
    }
    AppMethodBeat.o(42037);
  }
  
  private void b(z paramz)
  {
    AppMethodBeat.i(42039);
    if ((paramz.cDx() != null) && (!paramz.cDx().isEmpty()))
    {
      this.shj.setVisibility(0);
      if (!bt.isNullOrNil(paramz.cDw()))
      {
        this.shk.setVisibility(0);
        this.shk.setText(paramz.cDw());
        this.shl.removeAllViews();
        if (paramz.cDy() != 1) {
          break label271;
        }
        this.shl.setOrientation(1);
        this.shm.setVisibility(8);
      }
      Object localObject;
      for (int i = 2131494282;; i = 2131494281)
      {
        localObject = paramz.cDx();
        if (localObject == null) {
          break label294;
        }
        localObject = ((LinkedList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          z.b localb = (z.b)((Iterator)localObject).next();
          View localView = LayoutInflater.from(getContext()).inflate(i, this.shl, false);
          ImageView localImageView = (ImageView)localView.findViewById(2131300390);
          o.ayJ().loadImage(localb.dub, localImageView);
          if (paramz.cDy() == 1) {
            ((TextView)localView.findViewById(2131300391)).setText(localb.title);
          }
          ((TextView)localView.findViewById(2131300389)).setText(localb.desc);
          if (paramz.cDy() == 1)
          {
            localView.setTag(localb.url);
            localView.setOnClickListener(this.shJ);
          }
          this.shl.addView(localView);
        }
        this.shk.setVisibility(8);
        break;
        label271:
        this.shl.setOrientation(0);
        this.shm.setVisibility(0);
      }
      label294:
      if (paramz.rXO.scc != null)
      {
        localObject = new z.a();
        ((z.a)localObject).title = paramz.rXO.scc.summary;
        ((z.a)localObject).desc = paramz.rXO.scc.desc;
        ((z.a)localObject).url = paramz.rXO.scc.url;
        paramz = (z)localObject;
        if (paramz == null) {
          break label537;
        }
        this.shn.setVisibility(0);
        this.sho.setText(paramz.title);
        if (bt.isNullOrNil(paramz.desc)) {
          break label525;
        }
        this.shp.setVisibility(0);
        this.shp.setText(paramz.desc);
      }
      for (;;)
      {
        this.shn.setTag(paramz.url);
        this.shn.setOnClickListener(this.shJ);
        AppMethodBeat.o(42039);
        return;
        if ((paramz.rXO.sbX != null) && (!bt.isNullOrNil(paramz.rXO.sbX.scK)) && (!bt.isNullOrNil(paramz.rXO.sbX.scL)))
        {
          localObject = new z.a();
          ((z.a)localObject).title = paramz.rXO.sbX.scK;
          ((z.a)localObject).url = paramz.rXO.sbX.scL;
          paramz = (z)localObject;
          break;
        }
        paramz = null;
        break;
        label525:
        this.shp.setVisibility(8);
      }
      label537:
      this.shn.setVisibility(8);
      AppMethodBeat.o(42039);
      return;
    }
    this.shj.setVisibility(8);
    AppMethodBeat.o(42039);
  }
  
  private void c(z paramz)
  {
    AppMethodBeat.i(42040);
    if ((paramz.cDC() != null) && (!paramz.cDC().isEmpty()))
    {
      this.shB.setVisibility(0);
      if (!bt.isNullOrNil(paramz.cDB()))
      {
        this.shC.setVisibility(0);
        this.shC.setText(paramz.cDB());
      }
      for (;;)
      {
        this.shD.removeAllViews();
        this.shD.setOnClickListener(null);
        Iterator localIterator = paramz.cDC().iterator();
        while (localIterator.hasNext())
        {
          bw localbw = (bw)localIterator.next();
          View localView = LayoutInflater.from(getContext()).inflate(2131494283, this.shD, false);
          TextView localTextView1 = (TextView)localView.findViewById(2131300403);
          TextView localTextView2 = (TextView)localView.findViewById(2131300404);
          TextView localTextView3 = (TextView)localView.findViewById(2131300401);
          ImageView localImageView = (ImageView)localView.findViewById(2131300402);
          localTextView1.setText(localbw.scP);
          localTextView2.setText(localbw.Title);
          localTextView3.setText(localbw.saB);
          o.ayJ().loadImage(localbw.scM, localImageView);
          localView.setTag(localbw.rZr);
          localView.setOnClickListener(this.shK);
          this.shD.addView(localView);
        }
        this.shC.setVisibility(8);
      }
      if (paramz.rXO.sbX == null) {
        paramz = null;
      }
      while (paramz != null)
      {
        this.shE.setVisibility(0);
        this.shE.setText((CharSequence)paramz.first);
        this.shE.setTag(paramz.second);
        this.shE.setOnClickListener(this.shL);
        AppMethodBeat.o(42040);
        return;
        if ((bt.isNullOrNil(paramz.rXO.sbW.Title)) || (bt.isNullOrNil(paramz.rXO.sbW.scL))) {
          paramz = null;
        } else {
          paramz = new Pair(paramz.rXO.sbW.scK, paramz.rXO.sbW.scL);
        }
      }
      this.shE.setVisibility(8);
      AppMethodBeat.o(42040);
      return;
    }
    this.shB.setVisibility(8);
    AppMethodBeat.o(42040);
  }
  
  private void cEg()
  {
    AppMethodBeat.i(42035);
    Object localObject = getIntent().getStringExtra("jump_game_center");
    if ((!bt.isNullOrNil((String)localObject)) && (((String)localObject).equals("jump_game_center")))
    {
      localObject = new Intent(this, GameCenterUI.class);
      ((Intent)localObject).putExtra("jump_find_more_friends", "jump_find_more_friends");
      localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/game/ui/GameDetailUI2", "backToGameCenterUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameDetailUI2", "backToGameCenterUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    AppMethodBeat.o(42035);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(42034);
    cEg();
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
    this.sgY = ((ViewGroup)findViewById(2131300374));
    this.sgZ = ((ImageView)findViewById(2131300375));
    this.sha = ((ImageView)findViewById(2131300462));
    this.shb = ((TextView)findViewById(2131300524));
    this.she = ((TextView)findViewById(2131300469));
    this.shc = ((Button)findViewById(2131300344));
    this.shd = ((TextProgressBar)findViewById(2131300538));
    this.shd.setTextSize(this.sgR);
    this.shf = ((LinearLayout)findViewById(2131300426));
    this.shg = ((GameDetailAutoScrollView)findViewById(2131300425));
    this.shh = ((LinearLayout)findViewById(2131300407));
    this.shi = ((TextView)findViewById(2131300409));
    this.shj = ((LinearLayout)findViewById(2131300383));
    this.shk = ((TextView)findViewById(2131300392));
    this.shl = ((LinearLayout)findViewById(2131300384));
    this.shm = ((ImageView)findViewById(2131300385));
    this.shn = findViewById(2131300386);
    this.sho = ((TextView)findViewById(2131300388));
    this.shp = ((TextView)findViewById(2131300387));
    this.shq = findViewById(2131300393);
    this.shr = ((TextView)findViewById(2131300397));
    this.shs = ((ImageView)findViewById(2131300396));
    this.sht = ((TextView)findViewById(2131300394));
    this.shu = ((TextView)findViewById(2131300395));
    this.shv = ((LinearLayout)findViewById(2131300378));
    this.shw = ((GameMediaList)findViewById(2131300406));
    GameMediaList localGameMediaList = this.shw;
    String str = this.appId;
    int i = this.rXI;
    localGameMediaList.appId = str;
    localGameMediaList.pOf = 12;
    localGameMediaList.sjf = i;
    localGameMediaList.mContext = this;
    this.shw.setItemLayout(2131494344);
    this.shx = ((TextView)findViewById(2131300381));
    this.shy = ((TextView)findViewById(2131300379));
    this.shy.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
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
    this.shz = ((TextView)findViewById(2131300382));
    this.shz.setOnClickListener(new View.OnClickListener()
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
    this.shB = ((LinearLayout)findViewById(2131300398));
    this.shC = ((TextView)findViewById(2131300405));
    this.shD = ((LinearLayout)findViewById(2131300399));
    this.shE = ((TextView)findViewById(2131300400));
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
        if (this.sgX != null)
        {
          this.sgX.bRs();
          AppMethodBeat.o(42042);
          return;
        }
        break;
      case 2: 
        if ((this.rVN != null) && (this.sgX != null))
        {
          this.sgX.cDd();
          this.sgW.a(this.rVN, this.sgX);
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
          String str1 = this.shF.rZw;
          paramIntent = str1;
          if (bt.isNullOrNil(str1)) {
            paramIntent = this.rVN.field_appIconUrl;
          }
          ab.a.BZI.a(this.mController, this.shF.sdG, paramIntent, this.shF.sdH, true, getResources().getString(2131755884), new y.a()
          {
            public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
            {
              AppMethodBeat.i(42018);
              if (paramAnonymousBoolean)
              {
                GameDetailUI2.a(GameDetailUI2.this, str2, paramAnonymousString);
                com.tencent.mm.ui.base.h.cf(GameDetailUI2.this, GameDetailUI2.this.getResources().getString(2131757561));
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
        com.tencent.mm.game.report.e.a(getContext(), 12, 1207, 2, 15, this.appId, this.rXI, null);
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
    if (!com.tencent.mm.kernel.g.afw())
    {
      ad.e("MicroMsg.GameDetailUI2", "account not ready");
      finish();
      AppMethodBeat.o(42030);
      return;
    }
    this.sgS = true;
    this.sgT = false;
    this.appId = getIntent().getStringExtra("game_app_id");
    if (bt.isNullOrNil(this.appId))
    {
      ad.e("MicroMsg.GameDetailUI2", "appid is null or nill");
      finish();
      initView();
      com.tencent.mm.kernel.g.aeS().a(1217, this);
      paramBundle = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cBe().abW(this.appId);
      if ((paramBundle != null) && (paramBundle.length != 0)) {
        break label220;
      }
      ad.i("MicroMsg.GameDetailUI2", "No cache found");
    }
    for (int i = 0;; i = 1)
    {
      if (i == 0)
      {
        this.oWF = com.tencent.mm.plugin.game.f.c.fi(this);
        this.oWF.show();
      }
      paramBundle = ac.eFu();
      boolean bool = com.tencent.mm.pluginsdk.model.app.h.t(this, this.appId);
      paramBundle = new am(paramBundle, this.appId, bool);
      com.tencent.mm.kernel.g.aeS().a(paramBundle, 0);
      AppMethodBeat.o(42030);
      return;
      this.rXI = getIntent().getIntExtra("game_report_from_scene", 0);
      break;
      label220:
      com.tencent.mm.kernel.g.afE().ax(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(42022);
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(42021);
              GameDetailUI2.a(GameDetailUI2.this, this.shQ);
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
    com.tencent.mm.kernel.g.aeS().b(1217, this);
    if (this.sgV != null) {
      com.tencent.mm.plugin.game.model.k.b(this.sgV);
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
    if ((this.rVN != null) && (this.sgX != null))
    {
      this.sgX.bRs();
      this.sgW.a(this.shd, this.shc, this.rVN, this.sgX);
    }
    if (!this.sgS)
    {
      b(new aa(this.appId));
      AppMethodBeat.o(42031);
      return;
    }
    this.sgS = false;
    AppMethodBeat.o(42031);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, n paramn)
  {
    AppMethodBeat.i(42041);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      if (!com.tencent.mm.plugin.game.a.a.hYu.a(this, paramInt1, paramInt2, paramString)) {
        Toast.makeText(this, getString(2131759916, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      }
      if (this.oWF != null) {
        this.oWF.cancel();
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
      paramString = ((am)paramn).fUF.gUT.gUX;
      com.tencent.mm.kernel.g.afE().ax(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(42025);
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(42024);
              GameDetailUI2.a(GameDetailUI2.this, this.shQ);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDetailUI2
 * JD-Core Version:    0.7.0.1
 */