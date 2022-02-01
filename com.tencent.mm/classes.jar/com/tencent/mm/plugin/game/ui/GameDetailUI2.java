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
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.t;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.game.report.g;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.g.f;
import com.tencent.mm.plugin.game.g.h;
import com.tencent.mm.plugin.game.g.i;
import com.tencent.mm.plugin.game.model.aa;
import com.tencent.mm.plugin.game.model.am;
import com.tencent.mm.plugin.game.model.k;
import com.tencent.mm.plugin.game.model.k.a;
import com.tencent.mm.plugin.game.model.w;
import com.tencent.mm.plugin.game.model.z;
import com.tencent.mm.plugin.game.model.z.a;
import com.tencent.mm.plugin.game.model.z.b;
import com.tencent.mm.plugin.game.protobuf.af;
import com.tencent.mm.plugin.game.protobuf.bl;
import com.tencent.mm.plugin.game.protobuf.cd;
import com.tencent.mm.plugin.game.protobuf.cf;
import com.tencent.mm.plugin.game.protobuf.ci;
import com.tencent.mm.plugin.game.protobuf.cj;
import com.tencent.mm.plugin.game.protobuf.ds;
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
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GameDetailUI2
  extends MMActivity
  implements com.tencent.mm.an.i
{
  private com.tencent.mm.plugin.game.model.c CIQ;
  private int CKU;
  private String CUK;
  private String CUL;
  private int CUN;
  private boolean CUO;
  private boolean CUP;
  private String CUQ;
  private k.a CUR;
  private d CUS;
  private com.tencent.mm.plugin.game.model.l CUT;
  private ViewGroup CUU;
  private ImageView CUV;
  private ImageView CUW;
  private TextView CUX;
  private Button CUY;
  private TextProgressBar CUZ;
  private TextView CVA;
  private ds CVB;
  private DialogInterface.OnClickListener CVC;
  private View.OnClickListener CVD;
  private View.OnClickListener CVE;
  private View.OnClickListener CVF;
  private View.OnClickListener CVG;
  private View.OnClickListener CVH;
  private View.OnClickListener CVI;
  private TextView CVa;
  private LinearLayout CVb;
  private GameDetailAutoScrollView CVc;
  private LinearLayout CVd;
  private TextView CVe;
  private LinearLayout CVf;
  private TextView CVg;
  private LinearLayout CVh;
  private ImageView CVi;
  private View CVj;
  private TextView CVk;
  private TextView CVl;
  private View CVm;
  private TextView CVn;
  private ImageView CVo;
  private TextView CVp;
  private TextView CVq;
  private LinearLayout CVr;
  private GameMediaList CVs;
  private TextView CVt;
  private TextView CVu;
  private TextView CVv;
  private boolean CVw;
  private LinearLayout CVx;
  private TextView CVy;
  private LinearLayout CVz;
  private String appId;
  private Dialog vgC;
  
  public GameDetailUI2()
  {
    AppMethodBeat.i(42029);
    this.appId = null;
    this.CIQ = null;
    this.CUK = null;
    this.CUL = null;
    this.CUN = 18;
    this.CKU = 0;
    this.CUQ = null;
    this.CUR = null;
    this.CUS = null;
    this.CUT = null;
    this.CVw = false;
    this.CVC = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(42026);
        GameDetailUI2.i(GameDetailUI2.this).cQV();
        GameDetailUI2.m(GameDetailUI2.this).a(GameDetailUI2.j(GameDetailUI2.this), GameDetailUI2.k(GameDetailUI2.this), GameDetailUI2.l(GameDetailUI2.this), GameDetailUI2.i(GameDetailUI2.this));
        AppMethodBeat.o(42026);
      }
    };
    this.CVD = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(42027);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/ui/GameDetailUI2$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
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
        GameDetailUI2.i(GameDetailUI2.this).gC(GameDetailUI2.this.getContext());
        GameDetailUI2.m(GameDetailUI2.this).a(GameDetailUI2.l(GameDetailUI2.this), GameDetailUI2.i(GameDetailUI2.this));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameDetailUI2$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(42027);
      }
    };
    this.CVE = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(42028);
        Object localObject = new b();
        ((b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/ui/GameDetailUI2$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
        if ((paramAnonymousView.getTag() instanceof String))
        {
          com.tencent.mm.plugin.game.d.c.a(paramAnonymousView, GameDetailUI2.this);
          g.a(GameDetailUI2.this.getContext(), 12, 1203, 999, 7, GameDetailUI2.f(GameDetailUI2.this), GameDetailUI2.g(GameDetailUI2.this), null);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameDetailUI2$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(42028);
          return;
          localObject = new GameDetailRankUI.a();
          ((GameDetailRankUI.a)localObject).CUK = GameDetailUI2.n(GameDetailUI2.this);
          ((GameDetailRankUI.a)localObject).CUL = GameDetailUI2.o(GameDetailUI2.this);
          ((GameDetailRankUI.a)localObject).CUM = GameDetailUI2.l(GameDetailUI2.this);
          paramAnonymousView = ad.Rp("rankData");
          ad.beh().I(paramAnonymousView, true).k(GameDetailRankUI.CUI, localObject);
          localObject = new Intent(GameDetailUI2.this.getContext(), GameDetailRankUI.class);
          ((Intent)localObject).putExtra(GameDetailRankUI.CUH, paramAnonymousView);
          paramAnonymousView = GameDetailUI2.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/game/ui/GameDetailUI2$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/game/ui/GameDetailUI2$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          g.a(GameDetailUI2.this.getContext(), 12, 1203, 999, 6, GameDetailUI2.f(GameDetailUI2.this), GameDetailUI2.g(GameDetailUI2.this), null);
        }
      }
    };
    this.CVF = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(42011);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/ui/GameDetailUI2$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        com.tencent.mm.plugin.game.d.c.a(paramAnonymousView, GameDetailUI2.this);
        g.a(GameDetailUI2.this.getContext(), 12, 1204, 999, 7, GameDetailUI2.f(GameDetailUI2.this), GameDetailUI2.g(GameDetailUI2.this), null);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameDetailUI2$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(42011);
      }
    };
    this.CVG = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(42012);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/ui/GameDetailUI2$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        com.tencent.mm.plugin.game.d.c.a(paramAnonymousView, GameDetailUI2.this);
        g.a(GameDetailUI2.this.getContext(), 12, 1205, 1, 7, GameDetailUI2.f(GameDetailUI2.this), GameDetailUI2.g(GameDetailUI2.this), null);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameDetailUI2$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(42012);
      }
    };
    this.CVH = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(42013);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/ui/GameDetailUI2$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        com.tencent.mm.plugin.game.d.c.a(paramAnonymousView, GameDetailUI2.this);
        g.a(GameDetailUI2.this.getContext(), 12, 1205, 999, 7, GameDetailUI2.f(GameDetailUI2.this), GameDetailUI2.g(GameDetailUI2.this), null);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameDetailUI2$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(42013);
      }
    };
    this.CVI = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(42014);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/ui/GameDetailUI2$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        com.tencent.mm.plugin.game.d.c.a(paramAnonymousView, GameDetailUI2.this);
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
    if ((paramz.CLc.CLd == null) || (paramz.CLc.CLd.size() == 0)) {
      localObject1 = paramz.CLa.CPB;
    }
    if ((localObject1 == null) || (((LinkedList)localObject1).size() == 0))
    {
      this.CVb.setVisibility(8);
      AppMethodBeat.o(42038);
      return;
    }
    this.CVb.setVisibility(0);
    this.CVb.removeAllViews();
    paramz = ((LinkedList)localObject1).iterator();
    if (paramz.hasNext())
    {
      localObject1 = (af)paramz.next();
      View localView = LayoutInflater.from(getContext()).inflate(g.f.CmX, this.CVb, false);
      ImageView localImageView = (ImageView)localView.findViewById(g.e.Cjb);
      TextView localTextView1 = (TextView)localView.findViewById(g.e.Cjc);
      TextView localTextView2 = (TextView)localView.findViewById(g.e.Cja);
      if (!Util.isNullOrNil(((af)localObject1).UserName)) {
        a.b.a(localImageView, ((af)localObject1).UserName, 0.5F, false);
      }
      for (;;)
      {
        localTextView1.setText(((af)localObject1).fwr);
        localTextView2.setText(((af)localObject1).COk);
        this.CVb.addView(localView);
        break;
        Object localObject2 = new c.a();
        ((c.a)localObject2).kPz = true;
        localObject2 = ((c.a)localObject2).bmL();
        com.tencent.mm.ay.q.bml().a(((af)localObject1).CMO, localImageView, (com.tencent.mm.ay.a.a.c)localObject2);
      }
    }
    AppMethodBeat.o(42038);
  }
  
  private void b(aa paramaa)
  {
    int i = 0;
    AppMethodBeat.i(42037);
    List localList = paramaa.CLd;
    if ((localList == null) || (localList.size() == 0))
    {
      this.CVd.setVisibility(8);
      this.CVe.setVisibility(8);
      AppMethodBeat.o(42037);
      return;
    }
    this.CVd.setVisibility(0);
    if (localList.size() > 3) {
      this.CVe.setVisibility(0);
    }
    for (;;)
    {
      this.CVd.removeAllViews();
      i locali = new i(getContext());
      locali.QY = g.f.CmU;
      locali.a(paramaa);
      locali.CKU = this.CKU;
      while ((i < localList.size()) && (i < 3))
      {
        paramaa = locali.getView(i, null, this.CVb);
        this.CVd.addView(paramaa);
        i += 1;
      }
      this.CVe.setVisibility(8);
    }
    AppMethodBeat.o(42037);
  }
  
  private void b(z paramz)
  {
    AppMethodBeat.i(42039);
    if ((paramz.eyN() != null) && (!paramz.eyN().isEmpty()))
    {
      this.CVf.setVisibility(0);
      int i;
      if (!Util.isNullOrNil(paramz.eyM()))
      {
        this.CVg.setVisibility(0);
        this.CVg.setText(paramz.eyM());
        this.CVh.removeAllViews();
        if (paramz.eyO() != 1) {
          break label271;
        }
        this.CVh.setOrientation(1);
        i = g.f.CmP;
        this.CVi.setVisibility(8);
      }
      Object localObject;
      for (;;)
      {
        localObject = paramz.eyN();
        if (localObject == null) {
          break label294;
        }
        localObject = ((LinkedList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          z.b localb = (z.b)((Iterator)localObject).next();
          View localView = LayoutInflater.from(getContext()).inflate(i, this.CVh, false);
          ImageView localImageView = (ImageView)localView.findViewById(g.e.Cir);
          com.tencent.mm.ay.q.bml().loadImage(localb.icon, localImageView);
          if (paramz.eyO() == 1) {
            ((TextView)localView.findViewById(g.e.Cis)).setText(localb.title);
          }
          ((TextView)localView.findViewById(g.e.Ciq)).setText(localb.desc);
          if (paramz.eyO() == 1)
          {
            localView.setTag(localb.url);
            localView.setOnClickListener(this.CVF);
          }
          this.CVh.addView(localView);
        }
        this.CVg.setVisibility(8);
        break;
        label271:
        this.CVh.setOrientation(0);
        i = g.f.CmO;
        this.CVi.setVisibility(0);
      }
      label294:
      if (paramz.CLa.CPJ != null)
      {
        localObject = new z.a();
        ((z.a)localObject).title = paramz.CLa.CPJ.summary;
        ((z.a)localObject).desc = paramz.CLa.CPJ.desc;
        ((z.a)localObject).url = paramz.CLa.CPJ.url;
        paramz = (z)localObject;
        if (paramz == null) {
          break label537;
        }
        this.CVj.setVisibility(0);
        this.CVk.setText(paramz.title);
        if (Util.isNullOrNil(paramz.desc)) {
          break label525;
        }
        this.CVl.setVisibility(0);
        this.CVl.setText(paramz.desc);
      }
      for (;;)
      {
        this.CVj.setTag(paramz.url);
        this.CVj.setOnClickListener(this.CVF);
        AppMethodBeat.o(42039);
        return;
        if ((paramz.CLa.CPE != null) && (!Util.isNullOrNil(paramz.CLa.CPE.CQs)) && (!Util.isNullOrNil(paramz.CLa.CPE.CQt)))
        {
          localObject = new z.a();
          ((z.a)localObject).title = paramz.CLa.CPE.CQs;
          ((z.a)localObject).url = paramz.CLa.CPE.CQt;
          paramz = (z)localObject;
          break;
        }
        paramz = null;
        break;
        label525:
        this.CVl.setVisibility(8);
      }
      label537:
      this.CVj.setVisibility(8);
      AppMethodBeat.o(42039);
      return;
    }
    this.CVf.setVisibility(8);
    AppMethodBeat.o(42039);
  }
  
  private void c(z paramz)
  {
    AppMethodBeat.i(42040);
    if ((paramz.eyS() != null) && (!paramz.eyS().isEmpty()))
    {
      this.CVx.setVisibility(0);
      if (!Util.isNullOrNil(paramz.eyR()))
      {
        this.CVy.setVisibility(0);
        this.CVy.setText(paramz.eyR());
      }
      for (;;)
      {
        this.CVz.removeAllViews();
        this.CVz.setOnClickListener(null);
        Iterator localIterator = paramz.eyS().iterator();
        while (localIterator.hasNext())
        {
          cj localcj = (cj)localIterator.next();
          View localView = LayoutInflater.from(getContext()).inflate(g.f.CmQ, this.CVz, false);
          TextView localTextView1 = (TextView)localView.findViewById(g.e.CiE);
          TextView localTextView2 = (TextView)localView.findViewById(g.e.CiF);
          TextView localTextView3 = (TextView)localView.findViewById(g.e.CiC);
          ImageView localImageView = (ImageView)localView.findViewById(g.e.CiD);
          localTextView1.setText(localcj.CQx);
          localTextView2.setText(localcj.fwr);
          localTextView3.setText(localcj.COk);
          com.tencent.mm.ay.q.bml().loadImage(localcj.CQu, localImageView);
          localView.setTag(localcj.CMG);
          localView.setOnClickListener(this.CVG);
          this.CVz.addView(localView);
        }
        this.CVy.setVisibility(8);
      }
      if (paramz.CLa.CPE == null) {
        paramz = null;
      }
      while (paramz != null)
      {
        this.CVA.setVisibility(0);
        this.CVA.setText((CharSequence)paramz.first);
        this.CVA.setTag(paramz.second);
        this.CVA.setOnClickListener(this.CVH);
        AppMethodBeat.o(42040);
        return;
        if ((Util.isNullOrNil(paramz.CLa.CPD.fwr)) || (Util.isNullOrNil(paramz.CLa.CPD.CQt))) {
          paramz = null;
        } else {
          paramz = new Pair(paramz.CLa.CPD.CQs, paramz.CLa.CPD.CQt);
        }
      }
      this.CVA.setVisibility(8);
      AppMethodBeat.o(42040);
      return;
    }
    this.CVx.setVisibility(8);
    AppMethodBeat.o(42040);
  }
  
  private void ezv()
  {
    AppMethodBeat.i(42035);
    Object localObject = getIntent().getStringExtra("jump_game_center");
    if ((!Util.isNullOrNil((String)localObject)) && (((String)localObject).equals("jump_game_center")))
    {
      localObject = new Intent(this, GameCenterUI.class);
      ((Intent)localObject).putExtra("jump_find_more_friends", "jump_find_more_friends");
      localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/game/ui/GameDetailUI2", "backToGameCenterUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/game/ui/GameDetailUI2", "backToGameCenterUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    AppMethodBeat.o(42035);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(42034);
    ezv();
    finish();
    AppMethodBeat.o(42034);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return g.f.CmM;
  }
  
  public void initView()
  {
    AppMethodBeat.i(42036);
    setMMTitle(g.i.CoM);
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
    this.CUU = ((ViewGroup)findViewById(g.e.Cic));
    this.CUV = ((ImageView)findViewById(g.e.Cid));
    this.CUW = ((ImageView)findViewById(g.e.Cjt));
    this.CUX = ((TextView)findViewById(g.e.Cke));
    this.CVa = ((TextView)findViewById(g.e.Cjw));
    this.CUY = ((Button)findViewById(g.e.ChL));
    this.CUZ = ((TextProgressBar)findViewById(g.e.Ckh));
    this.CUZ.setTextSize(this.CUN);
    this.CVb = ((LinearLayout)findViewById(g.e.CiZ));
    this.CVc = ((GameDetailAutoScrollView)findViewById(g.e.CiY));
    this.CVd = ((LinearLayout)findViewById(g.e.CiI));
    this.CVe = ((TextView)findViewById(g.e.CiK));
    this.CVf = ((LinearLayout)findViewById(g.e.Cik));
    this.CVg = ((TextView)findViewById(g.e.Cit));
    this.CVh = ((LinearLayout)findViewById(g.e.Cil));
    this.CVi = ((ImageView)findViewById(g.e.Cim));
    this.CVj = findViewById(g.e.Cin);
    this.CVk = ((TextView)findViewById(g.e.Cip));
    this.CVl = ((TextView)findViewById(g.e.Cio));
    this.CVm = findViewById(g.e.Ciu);
    this.CVn = ((TextView)findViewById(g.e.Ciy));
    this.CVo = ((ImageView)findViewById(g.e.Cix));
    this.CVp = ((TextView)findViewById(g.e.Civ));
    this.CVq = ((TextView)findViewById(g.e.Ciw));
    this.CVr = ((LinearLayout)findViewById(g.e.Cig));
    this.CVs = ((GameMediaList)findViewById(g.e.CiH));
    GameMediaList localGameMediaList = this.CVs;
    String str = this.appId;
    int i = this.CKU;
    localGameMediaList.appId = str;
    localGameMediaList.wwk = 12;
    localGameMediaList.CXa = i;
    localGameMediaList.mContext = this;
    this.CVs.setItemLayout(g.f.CnL);
    this.CVt = ((TextView)findViewById(g.e.Cii));
    this.CVu = ((TextView)findViewById(g.e.Cih));
    this.CVu.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
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
    this.CVv = ((TextView)findViewById(g.e.Cij));
    this.CVv.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(42020);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/ui/GameDetailUI2$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (!GameDetailUI2.d(GameDetailUI2.this))
        {
          GameDetailUI2.b(GameDetailUI2.this).setMaxLines(100);
          GameDetailUI2.c(GameDetailUI2.this).setText(GameDetailUI2.this.getResources().getText(g.i.CoE));
          GameDetailUI2.a(GameDetailUI2.this, true);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameDetailUI2$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(42020);
          return;
          GameDetailUI2.b(GameDetailUI2.this).setMaxLines(3);
          GameDetailUI2.c(GameDetailUI2.this).setText(GameDetailUI2.this.getResources().getText(g.i.CoD));
          GameDetailUI2.a(GameDetailUI2.this, false);
        }
      }
    });
    this.CVx = ((LinearLayout)findViewById(g.e.Ciz));
    this.CVy = ((TextView)findViewById(g.e.CiG));
    this.CVz = ((LinearLayout)findViewById(g.e.CiA));
    this.CVA = ((TextView)findViewById(g.e.CiB));
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
        if (this.CUT != null)
        {
          this.CUT.cQV();
          AppMethodBeat.o(42042);
          return;
        }
        break;
      case 2: 
        if ((this.CIQ != null) && (this.CUT != null))
        {
          this.CUT.eyr();
          this.CUS.a(this.CIQ, this.CUT);
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
          String str1 = this.CVB.CMO;
          paramIntent = str1;
          if (Util.isNullOrNil(str1)) {
            paramIntent = this.CIQ.field_appIconUrl;
          }
          ab.a.RgY.a(this.mController, this.CVB.CRs, paramIntent, this.CVB.CRt, true, getResources().getString(g.i.app_send), new y.a()
          {
            public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
            {
              AppMethodBeat.i(42018);
              if (paramAnonymousBoolean)
              {
                GameDetailUI2.a(GameDetailUI2.this, str2, paramAnonymousString);
                com.tencent.mm.ui.base.h.cO(GameDetailUI2.this, GameDetailUI2.this.getResources().getString(g.i.confirm_dialog_sent));
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
        g.a(getContext(), 12, 1207, 2, 15, this.appId, this.CKU, null);
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
    if (!com.tencent.mm.kernel.h.aHB())
    {
      Log.e("MicroMsg.GameDetailUI2", "account not ready");
      finish();
      AppMethodBeat.o(42030);
      return;
    }
    this.CUO = true;
    this.CUP = false;
    this.appId = getIntent().getStringExtra("game_app_id");
    if (Util.isNullOrNil(this.appId))
    {
      Log.e("MicroMsg.GameDetailUI2", "appid is null or nill");
      finish();
      initView();
      com.tencent.mm.kernel.h.aGY().a(1217, this);
      paramBundle = ((f)com.tencent.mm.kernel.h.ae(f.class)).evp().aIX(this.appId);
      if ((paramBundle != null) && (paramBundle.length != 0)) {
        break label220;
      }
      Log.i("MicroMsg.GameDetailUI2", "No cache found");
    }
    for (int i = 0;; i = 1)
    {
      if (i == 0)
      {
        this.vgC = com.tencent.mm.plugin.game.d.c.gF(this);
        this.vgC.show();
      }
      paramBundle = LocaleUtil.getApplicationLanguage();
      boolean bool = com.tencent.mm.pluginsdk.model.app.h.u(this, this.appId);
      paramBundle = new am(paramBundle, this.appId, bool);
      com.tencent.mm.kernel.h.aGY().a(paramBundle, 0);
      AppMethodBeat.o(42030);
      return;
      this.CKU = getIntent().getIntExtra("game_report_from_scene", 0);
      break;
      label220:
      com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(42022);
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(42021);
              GameDetailUI2.a(GameDetailUI2.this, this.CVM);
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
    com.tencent.mm.kernel.h.aGY().b(1217, this);
    if (this.CUR != null) {
      k.b(this.CUR);
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
    if ((this.CIQ != null) && (this.CUT != null))
    {
      this.CUT.cQV();
      this.CUS.a(this.CUZ, this.CUY, this.CIQ, this.CUT);
    }
    if (!this.CUO)
    {
      b(new aa(this.appId));
      AppMethodBeat.o(42031);
      return;
    }
    this.CUO = false;
    AppMethodBeat.o(42031);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(42041);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      if (!com.tencent.mm.plugin.game.a.a.mIH.a(this, paramInt1, paramInt2, paramString)) {
        Toast.makeText(this, getString(g.i.Cpf, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      }
      if (this.vgC != null) {
        this.vgC.cancel();
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
      paramString = d.c.b(((am)paramq).jTk.lBS);
      com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(42025);
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(42024);
              GameDetailUI2.a(GameDetailUI2.this, this.CVM);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDetailUI2
 * JD-Core Version:    0.7.0.1
 */