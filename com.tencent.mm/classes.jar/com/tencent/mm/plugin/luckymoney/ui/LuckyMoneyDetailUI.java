package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.m;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.p;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.g.a.il;
import com.tencent.mm.g.a.il.b;
import com.tencent.mm.g.b.a.bp;
import com.tencent.mm.g.b.a.bq;
import com.tencent.mm.g.b.a.br;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.emoji.model.c.a;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.luckymoney.model.LuckyMoneyEmojiSwitch;
import com.tencent.mm.plugin.luckymoney.model.ah;
import com.tencent.mm.plugin.luckymoney.model.ao;
import com.tencent.mm.plugin.luckymoney.model.at;
import com.tencent.mm.plugin.luckymoney.model.au;
import com.tencent.mm.plugin.luckymoney.model.av;
import com.tencent.mm.plugin.luckymoney.model.y;
import com.tencent.mm.plugin.luckymoney.model.z;
import com.tencent.mm.plugin.luckymoney.story.EnvelopeAppBarLayout;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.pluginsdk.ui.chat.e.b;
import com.tencent.mm.protocal.protobuf.bfu;
import com.tencent.mm.protocal.protobuf.bfv;
import com.tencent.mm.protocal.protobuf.cer;
import com.tencent.mm.protocal.protobuf.cic;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

@com.tencent.mm.ui.base.a(32)
public class LuckyMoneyDetailUI
  extends LuckyMoneyBaseUI
{
  private int LZ;
  private View adC;
  RecyclerView.m akH;
  private long fll;
  private String fwd;
  private TextView kFd;
  private boolean knt;
  private TextView lln;
  private int nYJ;
  private View oBA;
  private EmojiInfo oBl;
  private c.a owM;
  private String oyM;
  private ImageView pev;
  private List<y> sYN;
  private boolean sYP;
  private int sYQ;
  private TextView sYT;
  private ImageView sZc;
  private TextView sZd;
  private ImageView sZe;
  private View sZf;
  private View sZg;
  private TextView swB;
  private SoundPool tah;
  private com.tencent.mm.particles.b tbL;
  private int tdB;
  private String thG;
  private String thH;
  private Dialog tipDialog;
  private RecyclerView tkS;
  private CdnImageView tkT;
  private View tkU;
  private ImageView tkV;
  private ViewGroup tkW;
  private View tkX;
  private View tkY;
  private View tkZ;
  private String tka;
  private View tkh;
  private boolean tkj;
  private int tkk;
  private String tkl;
  private String tkm;
  private String tkn;
  private Map<String, Integer> tkp;
  private String tkr;
  private boolean tks;
  private EmojiInfo tlA;
  private ViewGroup tlB;
  public LuckyMoneyEmojiSwitch tlC;
  private br tlD;
  private bp tlE;
  private bq tlF;
  private int tlG;
  private boolean tlH;
  private String tlI;
  private Bitmap tlJ;
  private Bitmap tlK;
  private Bitmap tlL;
  private Bitmap tlM;
  private Bitmap tlN;
  private Bitmap tlO;
  private Bitmap tlP;
  private Bitmap tlQ;
  private boolean tlR;
  private WxRecyclerAdapter tlS;
  private int tlT;
  private String tlU;
  private com.tencent.mm.plugin.luckymoney.model.l tlV;
  private long tlW;
  private View.OnClickListener tlX;
  private int tlY;
  private com.tencent.mm.al.g tlZ;
  private TextView tla;
  private TextView tlb;
  private ViewGroup tlc;
  private RelativeLayout tld;
  private int[] tle;
  private ViewGroup tlf;
  private RelativeLayout tlg;
  private BaseEmojiView tlh;
  private TextView tli;
  private LinearLayout tlj;
  private ProgressBar tlk;
  private LinearLayout tll;
  private LinearLayout tlm;
  private LinearLayout tln;
  private BaseEmojiView tlo;
  private RelativeLayout tlp;
  private ImageView tlq;
  private a tlr;
  private View tls;
  private ImageView tlt;
  private View tlu;
  private EnvelopeAppBarLayout tlv;
  private ArrayList<a> tlw;
  private boolean tlx;
  private int tly;
  private ChatFooterPanel tlz;
  private int tma;
  private int tmb;
  private final int tmc;
  private final int tmd;
  
  public LuckyMoneyDetailUI()
  {
    AppMethodBeat.i(65556);
    this.LZ = 0;
    this.tkj = true;
    this.knt = false;
    this.tdB = -1;
    this.sYN = new LinkedList();
    this.tlw = new ArrayList();
    this.tkp = new HashMap();
    this.tkr = "";
    this.tlx = false;
    this.tks = false;
    this.tlG = 0;
    this.tlH = false;
    this.akH = new RecyclerView.m()
    {
      private boolean sZj = false;
      private boolean sZk;
      
      public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(163711);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.be(paramAnonymousRecyclerView);
        localb.lT(paramAnonymousInt1);
        localb.lT(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ado());
        if ((paramAnonymousRecyclerView.getAdapter().getItemCount() == 0) || (!this.sZj))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
          AppMethodBeat.o(163711);
          return;
        }
        paramAnonymousRecyclerView = (LinearLayoutManager)paramAnonymousRecyclerView.getLayoutManager();
        boolean bool;
        if (paramAnonymousRecyclerView.jO() > 0)
        {
          bool = true;
          if (this.sZk != bool)
          {
            if (bool) {
              LuckyMoneyDetailUI.this.getResources().getDrawable(2131232950);
            }
            this.sZk = bool;
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
          AppMethodBeat.o(163711);
          return;
        }
        paramAnonymousRecyclerView = paramAnonymousRecyclerView.bY(paramAnonymousRecyclerView.jO());
        if (paramAnonymousRecyclerView != null) {}
        for (paramAnonymousInt1 = 0 - paramAnonymousRecyclerView.getTop();; paramAnonymousInt1 = 0)
        {
          if (paramAnonymousInt1 > 100)
          {
            bool = true;
            break;
          }
          bool = false;
          break;
        }
      }
      
      public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(163710);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).be(paramAnonymousRecyclerView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).lT(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ado());
        if (paramAnonymousRecyclerView.getAdapter().getItemCount() == 0)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
          AppMethodBeat.o(163710);
          return;
        }
        switch (paramAnonymousInt)
        {
        }
        for (this.sZj = true;; this.sZj = false)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
          AppMethodBeat.o(163710);
          return;
          localObject = (LinearLayoutManager)paramAnonymousRecyclerView.getLayoutManager();
          if ((((LinearLayoutManager)localObject).jQ() == LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this).size()) || (((LinearLayoutManager)localObject).jQ() == paramAnonymousRecyclerView.getAdapter().getItemCount() - 1))
          {
            if (!LuckyMoneyDetailUI.this.tjY.isProcessing()) {
              LuckyMoneyDetailUI.b(LuckyMoneyDetailUI.this);
            }
            if ((LuckyMoneyDetailUI.c(LuckyMoneyDetailUI.this)) && (!LuckyMoneyDetailUI.d(LuckyMoneyDetailUI.this))) {
              LuckyMoneyDetailUI.e(LuckyMoneyDetailUI.this);
            }
          }
        }
      }
    };
    this.tbL = new com.tencent.mm.particles.b()
    {
      public final com.tencent.mm.particles.a.b a(Random paramAnonymousRandom)
      {
        AppMethodBeat.i(65527);
        switch (paramAnonymousRandom.nextInt(8))
        {
        default: 
          AppMethodBeat.o(65527);
          return null;
        case 0: 
          if (LuckyMoneyDetailUI.f(LuckyMoneyDetailUI.this) == null) {
            LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, 2131233007));
          }
          paramAnonymousRandom = new com.tencent.mm.particles.a.a(LuckyMoneyDetailUI.f(LuckyMoneyDetailUI.this));
          AppMethodBeat.o(65527);
          return paramAnonymousRandom;
        case 1: 
          if (LuckyMoneyDetailUI.g(LuckyMoneyDetailUI.this) == null) {
            LuckyMoneyDetailUI.b(LuckyMoneyDetailUI.this, LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, 2131233008));
          }
          paramAnonymousRandom = new com.tencent.mm.particles.a.a(LuckyMoneyDetailUI.g(LuckyMoneyDetailUI.this));
          AppMethodBeat.o(65527);
          return paramAnonymousRandom;
        case 2: 
          if (LuckyMoneyDetailUI.h(LuckyMoneyDetailUI.this) == null) {
            LuckyMoneyDetailUI.c(LuckyMoneyDetailUI.this, LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, 2131233009));
          }
          paramAnonymousRandom = new com.tencent.mm.particles.a.a(LuckyMoneyDetailUI.h(LuckyMoneyDetailUI.this));
          AppMethodBeat.o(65527);
          return paramAnonymousRandom;
        case 3: 
          if (LuckyMoneyDetailUI.i(LuckyMoneyDetailUI.this) == null) {
            LuckyMoneyDetailUI.d(LuckyMoneyDetailUI.this, LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, 2131233002));
          }
          paramAnonymousRandom = new com.tencent.mm.particles.a.a(LuckyMoneyDetailUI.i(LuckyMoneyDetailUI.this));
          AppMethodBeat.o(65527);
          return paramAnonymousRandom;
        case 4: 
          if (LuckyMoneyDetailUI.j(LuckyMoneyDetailUI.this) == null) {
            LuckyMoneyDetailUI.e(LuckyMoneyDetailUI.this, LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, 2131233003));
          }
          paramAnonymousRandom = new com.tencent.mm.particles.a.a(LuckyMoneyDetailUI.j(LuckyMoneyDetailUI.this));
          AppMethodBeat.o(65527);
          return paramAnonymousRandom;
        case 5: 
          if (LuckyMoneyDetailUI.k(LuckyMoneyDetailUI.this) == null) {
            LuckyMoneyDetailUI.f(LuckyMoneyDetailUI.this, LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, 2131233004));
          }
          paramAnonymousRandom = new com.tencent.mm.particles.a.a(LuckyMoneyDetailUI.k(LuckyMoneyDetailUI.this));
          AppMethodBeat.o(65527);
          return paramAnonymousRandom;
        case 6: 
          if (LuckyMoneyDetailUI.l(LuckyMoneyDetailUI.this) == null) {
            LuckyMoneyDetailUI.g(LuckyMoneyDetailUI.this, LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, 2131233005));
          }
          paramAnonymousRandom = new com.tencent.mm.particles.a.a(LuckyMoneyDetailUI.l(LuckyMoneyDetailUI.this));
          AppMethodBeat.o(65527);
          return paramAnonymousRandom;
        }
        if (LuckyMoneyDetailUI.m(LuckyMoneyDetailUI.this) == null) {
          LuckyMoneyDetailUI.h(LuckyMoneyDetailUI.this, LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, 2131233006));
        }
        paramAnonymousRandom = new com.tencent.mm.particles.a.a(LuckyMoneyDetailUI.m(LuckyMoneyDetailUI.this));
        AppMethodBeat.o(65527);
        return paramAnonymousRandom;
      }
    };
    this.tlR = false;
    this.owM = new c.a()
    {
      public final void a(final boolean paramAnonymousBoolean, final EmojiInfo paramAnonymousEmojiInfo)
      {
        AppMethodBeat.i(65541);
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(65540);
            if ((paramAnonymousEmojiInfo != null) && (LuckyMoneyDetailUI.n(LuckyMoneyDetailUI.this) != null) && (LuckyMoneyDetailUI.n(LuckyMoneyDetailUI.this).JS().equals(paramAnonymousEmojiInfo.JS())))
            {
              if (paramAnonymousBoolean)
              {
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LuckyMoneyDetailUI", "somethings success.");
                LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, k.getEmojiStorageMgr().FyY.aJx(LuckyMoneyDetailUI.n(LuckyMoneyDetailUI.this).JS()));
                LuckyMoneyDetailUI.o(LuckyMoneyDetailUI.this).setVisibility(8);
                LuckyMoneyDetailUI.p(LuckyMoneyDetailUI.this).setVisibility(0);
                LuckyMoneyDetailUI.b(LuckyMoneyDetailUI.this, LuckyMoneyDetailUI.n(LuckyMoneyDetailUI.this));
                AppMethodBeat.o(65540);
                return;
              }
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LuckyMoneyDetailUI", "somethings error.");
              LuckyMoneyDetailUI.o(LuckyMoneyDetailUI.this).setVisibility(8);
              LuckyMoneyDetailUI.q(LuckyMoneyDetailUI.this).setVisibility(0);
            }
            AppMethodBeat.o(65540);
          }
        });
        AppMethodBeat.o(65541);
      }
    };
    this.sYP = false;
    this.tlW = 0L;
    this.tlX = new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(163720);
        LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, new bp());
        if (bt.iY(paramAnonymousView.getId(), 2131301952))
        {
          LuckyMoneyDetailUI.w(LuckyMoneyDetailUI.this).dMW = 1L;
          LuckyMoneyDetailUI.w(LuckyMoneyDetailUI.this).aBj();
        }
        if ((bt.iY(LuckyMoneyDetailUI.this.tlC.tdL, 0)) && (bt.I(paramAnonymousView.getTag(), "nodelete")))
        {
          LuckyMoneyDetailUI.B(LuckyMoneyDetailUI.this);
          AppMethodBeat.o(163720);
          return;
        }
        com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(LuckyMoneyDetailUI.this.getContext(), 1, false);
        locale.HrX = new n.c()
        {
          public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
          {
            AppMethodBeat.i(163718);
            String str = LuckyMoneyDetailUI.this.getString(2131760952);
            if (!bt.iY(LuckyMoneyDetailUI.this.tlC.tdL, 0)) {
              paramAnonymous2l.jj(1, 2131760908);
            }
            for (;;)
            {
              paramAnonymous2l.c(2, str);
              if (!bt.I(paramAnonymousView.getTag(), "nodelete")) {
                paramAnonymous2l.a(3, LuckyMoneyDetailUI.this.getResources().getColor(2131100596), LuckyMoneyDetailUI.this.getContext().getString(2131760844));
              }
              AppMethodBeat.o(163718);
              return;
              str = LuckyMoneyDetailUI.this.getString(2131760858);
            }
          }
        };
        locale.HrY = new n.d()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(163719);
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LuckyMoneyDetailUI", "showLuckyHbDlg() onMMMenuItemSelected menuItemId:%s", new Object[] { Integer.valueOf(paramAnonymous2MenuItem.getItemId()) });
            switch (paramAnonymous2MenuItem.getItemId())
            {
            }
            for (;;)
            {
              AppMethodBeat.o(163719);
              return;
              com.tencent.mm.plugin.emojicapture.api.b.b(LuckyMoneyDetailUI.this, 5, LuckyMoneyDetailUI.v(LuckyMoneyDetailUI.this));
              LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, new bp());
              LuckyMoneyDetailUI.w(LuckyMoneyDetailUI.this).dMW = 4L;
              LuckyMoneyDetailUI.w(LuckyMoneyDetailUI.this).aBj();
              LuckyMoneyDetailUI.C(LuckyMoneyDetailUI.this);
              AppMethodBeat.o(163719);
              return;
              LuckyMoneyDetailUI.B(LuckyMoneyDetailUI.this);
              AppMethodBeat.o(163719);
              return;
              LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, null);
              LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, new bp());
              LuckyMoneyDetailUI.w(LuckyMoneyDetailUI.this).dMW = 8L;
              LuckyMoneyDetailUI.w(LuckyMoneyDetailUI.this).aBj();
              LuckyMoneyDetailUI.b(LuckyMoneyDetailUI.this, 1);
            }
          }
        };
        LuckyMoneyDetailUI.w(LuckyMoneyDetailUI.this).dMW = 2L;
        LuckyMoneyDetailUI.w(LuckyMoneyDetailUI.this).aBj();
        locale.csG();
        AppMethodBeat.o(163720);
      }
    };
    this.tlY = 3;
    this.tlZ = new LuckyMoneyDetailUI.8(this);
    this.tma = 0;
    this.tmb = 0;
    this.tmc = 750;
    this.tmd = 240;
    AppMethodBeat.o(65556);
  }
  
  private void A(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(65570);
    this.tmb = 3;
    this.tlh.setEmojiInfo(paramEmojiInfo);
    this.tlD = new br();
    this.tlD.dMW = 11L;
    this.tlD.aBj();
    AppMethodBeat.o(65570);
  }
  
  private static int FX(int paramInt)
  {
    if (paramInt == 2) {
      return 13;
    }
    return 7;
  }
  
  private void FZ(int paramInt)
  {
    AppMethodBeat.i(65574);
    bl(paramInt, "");
    AppMethodBeat.o(65574);
  }
  
  private void a(final com.tencent.mm.plugin.luckymoney.model.l paraml)
  {
    AppMethodBeat.i(65573);
    if (paraml == null)
    {
      AppMethodBeat.o(65573);
      return;
    }
    boolean bool = e(paraml);
    label63:
    label97:
    label108:
    int i;
    label159:
    int j;
    label192:
    label324:
    Object localObject1;
    label465:
    label483:
    Object localObject2;
    if (g(paraml)) {
      if (cMt())
      {
        if (!bool) {}
        if (!cMt()) {
          break label1819;
        }
        this.tlg.setVisibility(0);
        mN(true);
        if ((!bt.iY(this.tlC.tdK, 0)) && (e(paraml)) && (this.tlH)) {
          break label1831;
        }
        FZ(0);
        if (paraml.tdt != 1) {
          break label1942;
        }
        bool = true;
        this.tkj = bool;
        if (paraml != null)
        {
          if (((paraml.dDO != 3) && (paraml.dDO != 2)) || (paraml.tds != 1) || (this.tkj) || (paraml.tdv != 1)) {
            break label1948;
          }
          i = 1;
          if ((paraml.tdw == null) || (paraml.tdw.fBI != 1) || (bt.isNullOrNil(paraml.tdw.tcR))) {
            break label1953;
          }
          j = 1;
          this.tla = ((TextView)this.oBA.findViewById(2131301772));
          if ((i == 0) && (j == 0)) {
            break label1958;
          }
          this.tla.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(163732);
              com.tencent.mm.plugin.report.service.h.vKh.f(11701, new Object[] { Integer.valueOf(LuckyMoneyDetailUI.Ga(paraml.tdB)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3) });
              z.a(LuckyMoneyDetailUI.this, 1, false);
              AppMethodBeat.o(163732);
            }
          });
          if (j != 0)
          {
            this.tkn = paraml.tdw.tcR;
            this.tla.setText(paraml.tdw.tcS);
          }
          com.tencent.mm.plugin.report.service.h.vKh.f(11701, new Object[] { Integer.valueOf(FX(paraml.tdB)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2) });
          this.tla.setVisibility(0);
          this.tdB = paraml.tdB;
          this.tlb = ((TextView)this.oBA.findViewById(2131301769));
          this.tlb.setVisibility(8);
          if (!this.tks)
          {
            this.tlS.g(this.oBA, 3, false);
            this.tks = true;
          }
        }
        if (this.LZ == 0)
        {
          this.tkl = paraml.tdq;
          localObject1 = this.tkl;
          if ((paraml == null) || (paraml.dDN != 0) || (paraml.tdC == null) || (paraml.tdC.size() <= 0) || (!((y)paraml.tdC.get(0)).tdq.equals(localObject1)) || (paraml.tdr == 1)) {
            break label1970;
          }
          i = 1;
          if (i == 0) {
            break label1975;
          }
          this.sYP = false;
          this.tkW.setVisibility(8);
          this.sYQ = paraml.tdB;
          if (paraml != null)
          {
            localObject2 = getContext();
            if (paraml.tdB != 2) {
              break label2046;
            }
            this.sZc.setImageResource(2131232967);
            if (paraml.resourceId == 0) {
              break label2028;
            }
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LuckyMoneyDetailUI", "busi logo load from file:" + paraml.resourceId);
            localObject1 = new il();
            ((il)localObject1).dmp.dmr = paraml.resourceId;
            ((il)localObject1).callback = new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(163726);
                if (this.tku.dmq.dms)
                {
                  com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LuckyMoneyDetailUI", "Get res Ok, path=" + this.tku.dmq.dmt);
                  LuckyMoneyDetailUI.this.getContext();
                  z.p(LuckyMoneyDetailUI.K(LuckyMoneyDetailUI.this), this.tku.dmq.dmt);
                  AppMethodBeat.o(163726);
                  return;
                }
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LuckyMoneyDetailUI", "Get res fail & load from url.");
                z.b(LuckyMoneyDetailUI.K(LuckyMoneyDetailUI.this), paraml.tdk, paraml.tdE);
                AppMethodBeat.o(163726);
              }
            };
            com.tencent.mm.sdk.b.a.ESL.a((com.tencent.mm.sdk.b.b)localObject1, Looper.myLooper());
            label600:
            if (!w.sz(this.fwd)) {
              break label2087;
            }
            localObject1 = paraml.tdj;
            label616:
            i = ((WindowManager)getSystemService("window")).getDefaultDisplay().getWidth();
            j = BackwardSupportUtil.b.g(getContext(), 92.0F);
            this.sZd.setMaxWidth(i - j);
            z.a((Context)localObject2, this.sZd, (String)localObject1);
            z.a((Context)localObject2, this.swB, paraml.sYt);
            if (bt.isNullOrNil(paraml.sYt)) {
              break label2110;
            }
            this.swB.setVisibility(0);
            label698:
            if (paraml.dDN != 1) {
              break label2122;
            }
            this.sZe.setVisibility(0);
            this.sZe.setImageResource(2131690761);
            label724:
            if (bt.isNullOrNil(paraml.tdA)) {
              break label2200;
            }
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LuckyMoneyDetailUI", "hy: has url : %s", new Object[] { paraml.tdA });
            this.tld.setVisibility(4);
            z.l(this.pev, paraml.tdA);
            aq.n(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(163727);
                LuckyMoneyDetailUI.L(LuckyMoneyDetailUI.this);
                LuckyMoneyDetailUI.M(LuckyMoneyDetailUI.this).setVisibility(0);
                AppMethodBeat.o(163727);
              }
            }, 500L);
            label787:
            if ((paraml.dDP != 2) || (this.tkk == 3)) {
              break label2221;
            }
            this.sYT.setText(com.tencent.mm.wallet_core.ui.e.D(paraml.dEb / 100.0D));
            this.sZf.setVisibility(0);
            label830:
            if (bt.isNullOrNil(paraml.taz)) {
              break label2333;
            }
            this.sZg.setVisibility(0);
            this.lln.setText(paraml.taz);
            if (!w.sz(this.fwd)) {
              break label2233;
            }
            this.tkT.setVisibility(8);
            this.adC.findViewById(2131301786).setVisibility(8);
            label893:
            if (bt.isNullOrNil(paraml.tdu)) {
              break label2354;
            }
            this.kFd.setText(paraml.tdu);
            this.tkW.setVisibility(0);
            if ((g(paraml)) && (!e(paraml)))
            {
              this.tkX.setVisibility(8);
              this.tkY.setVisibility(8);
              this.tkZ.setVisibility(8);
            }
          }
        }
      }
    }
    for (;;)
    {
      Object localObject3;
      if (paraml != null)
      {
        localObject1 = paraml.tdx;
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          localObject2 = this.adC.findViewById(2131301765);
          localObject3 = this.adC.findViewById(2131301766);
          View localView1 = this.adC.findViewById(2131301767);
          ViewGroup localViewGroup1 = (ViewGroup)this.adC.findViewById(2131301762);
          ViewGroup localViewGroup2 = (ViewGroup)this.adC.findViewById(2131301763);
          ViewGroup localViewGroup3 = (ViewGroup)this.adC.findViewById(2131301764);
          View localView2 = this.adC.findViewById(2131301753);
          View localView3 = this.adC.findViewById(2131301754);
          h.c localc = new h.c();
          localc.textColor = getResources().getColor(2131100579);
          if (((List)localObject1).size() > 0)
          {
            h.a(this, localViewGroup1, (au)((List)localObject1).get(0), localc);
            ((View)localObject2).setVisibility(0);
          }
          if (((List)localObject1).size() > 1)
          {
            h.a(this, localViewGroup2, (au)((List)localObject1).get(1), localc);
            ((View)localObject3).setVisibility(0);
          }
          if (((List)localObject1).size() > 2)
          {
            h.a(this, localViewGroup3, (au)((List)localObject1).get(2), localc);
            localView1.setVisibility(0);
          }
          if ((((View)localObject2).getVisibility() == 0) && ((((View)localObject3).getVisibility() == 0) || (localView1.getVisibility() == 0))) {
            localView2.setVisibility(0);
          }
          if ((((View)localObject3).getVisibility() == 0) && (localView1.getVisibility() == 0)) {
            localView3.setVisibility(0);
          }
          if ((((View)localObject2).getVisibility() == 0) || (((View)localObject3).getVisibility() == 0) || (localView1.getVisibility() == 0))
          {
            this.tkh.requestLayout();
            this.tkh.setVisibility(0);
          }
        }
        this.tlc = ((ViewGroup)this.oBA.findViewById(2131301756));
        localObject1 = new h.c();
        ((h.c)localObject1).textColor = getResources().getColor(2131099819);
        ((h.c)localObject1).textSize = getResources().getDimensionPixelSize(2131165466);
        h.a(this, this.tlc, paraml.tdy, (h.c)localObject1);
        localObject1 = new h.c();
        ((h.c)localObject1).textColor = getResources().getColor(2131099769);
        ((h.c)localObject1).textSize = getResources().getDimensionPixelSize(2131165466);
        if ((paraml.tdH != null) && (!w.sz(this.fwd)))
        {
          localObject2 = av.afq(paraml.tdH);
          if ((localObject2 != null) && (((av)localObject2).tfV != null))
          {
            ((h.c)localObject1).tow = ((av)localObject2).tcN;
            if (((h.c)localObject1).tow == null)
            {
              ((h.c)localObject1).tow = new bfu();
              ((h.c)localObject1).tow.DDg = this.tlI;
            }
            h.a(this, this.tlc, ((av)localObject2).tfV, (h.c)localObject1);
            localObject1 = "";
            if (((av)localObject2).tcN != null) {
              localObject1 = ((av)localObject2).tcN.Daf;
            }
            com.tencent.mm.plugin.report.service.h.vKh.f(16589, new Object[] { Integer.valueOf(1), ((av)localObject2).tfV.content, this.tlI, localObject1, Integer.valueOf(0), com.tencent.mm.plugin.luckymoney.a.c.openId });
          }
        }
      }
      com.tencent.mm.plugin.report.service.h.vKh.f(11701, new Object[] { Integer.valueOf(FX(paraml.tdB)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
      localObject1 = paraml.tdC;
      if (localObject1 == null) {
        break label2405;
      }
      i = 0;
      while (i < ((List)localObject1).size())
      {
        localObject2 = (y)((List)localObject1).get(i);
        if (!this.tkp.containsKey(((y)localObject2).tdq))
        {
          this.sYN.add(((List)localObject1).get(i));
          localObject3 = new a();
          ((a)localObject3).tmn = ((y)((List)localObject1).get(i));
          this.tlw.add(localObject3);
          this.tkp.put(((y)localObject2).tdq, Integer.valueOf(1));
        }
        i += 1;
      }
      if (bool) {
        break;
      }
      break;
      if (bool)
      {
        if (cMt()) {
          break;
        }
        break;
      }
      cMt();
      break;
      label1819:
      this.tlg.setVisibility(8);
      break label63;
      label1831:
      this.tlm.setOnClickListener(this.tlX);
      this.tlm.setTag("nodelete");
      this.tlq.setOnClickListener(this.tlX);
      this.tlt.setOnClickListener(this.tlX);
      this.tlp.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(163715);
          LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, new bp());
          LuckyMoneyDetailUI.w(LuckyMoneyDetailUI.this).dMW = 7L;
          LuckyMoneyDetailUI.w(LuckyMoneyDetailUI.this).aBj();
          LuckyMoneyDetailUI.A(LuckyMoneyDetailUI.this);
          AppMethodBeat.o(163715);
        }
      });
      this.tlo.setOnClickListener(this.tlX);
      localObject1 = (String)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fnt, "");
      FZ(1);
      if (bt.isNullOrNil((String)localObject1)) {
        break label97;
      }
      bl(2, (String)localObject1);
      break label97;
      label1942:
      bool = false;
      break label108;
      label1948:
      i = 0;
      break label159;
      label1953:
      j = 0;
      break label192;
      label1958:
      this.tla.setVisibility(8);
      break label324;
      label1970:
      i = 0;
      break label465;
      label1975:
      this.tkW.setVisibility(0);
      if ((!g(paraml)) || (e(paraml))) {
        break label483;
      }
      this.tkX.setVisibility(8);
      this.tkY.setVisibility(8);
      this.tkZ.setVisibility(8);
      break label483;
      label2028:
      z.b(this.sZc, paraml.tdk, paraml.tdE);
      break label600;
      label2046:
      if (w.sz(this.fwd))
      {
        this.sZc.setImageResource(2131233442);
        break label600;
      }
      z.b(this.sZc, paraml.tdk, paraml.tdE);
      break label600;
      label2087:
      localObject1 = getString(2131760982, new Object[] { paraml.tdj });
      break label616;
      label2110:
      this.swB.setVisibility(8);
      break label698;
      label2122:
      if (paraml.dDN == 2)
      {
        if (!w.sD(paraml.tdE))
        {
          localObject1 = new com.tencent.mm.ak.i();
          ((com.tencent.mm.ak.i)localObject1).username = paraml.tdE;
          p.auF().b((com.tencent.mm.ak.i)localObject1);
        }
        this.sZe.setVisibility(0);
        this.sZe.setImageResource(2131690760);
        break label724;
      }
      this.sZe.setVisibility(8);
      break label724;
      label2200:
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LuckyMoneyDetailUI", "hy: no bg. set bg area to gone");
      this.tld.setVisibility(8);
      break label787;
      label2221:
      this.sZf.setVisibility(8);
      break label830;
      label2233:
      if (paraml.tax == 1)
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LuckyMoneyDetailUI", "changeIconUrl: %s", new Object[] { paraml.tdG });
        if (!bt.isNullOrNil(paraml.tdG))
        {
          this.tkT.setUrl(paraml.tdG);
          this.tkT.setVisibility(0);
        }
        for (;;)
        {
          this.lln.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(163728);
              LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, paraml);
              AppMethodBeat.o(163728);
            }
          });
          break;
          this.tkT.setVisibility(8);
        }
      }
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.LuckyMoneyDetailUI", "detail.jumpChange is false");
      break label893;
      label2333:
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.LuckyMoneyDetailUI", "detail.changeWording is empty");
      this.sZg.setVisibility(8);
      break label893;
      label2354:
      this.kFd.setText(null);
      this.tkW.setVisibility(8);
    }
    this.LZ += ((List)localObject1).size();
    this.knt = false;
    this.tlS.aql.notifyChanged();
    label2405:
    if ((paraml.dDN == 2) && (!bt.isNullOrNil(paraml.tdi)))
    {
      this.tah = new SoundPool(2, 3, 0);
      this.tle = new int[2];
    }
    try
    {
      this.tle[0] = this.tah.load(getResources().getAssets().openFd("most_lucky.m4a"), 0);
      this.tle[1] = this.tah.load(getResources().getAssets().openFd("whistle.m4a"), 0);
      this.tah.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener()
      {
        public final void onLoadComplete(SoundPool paramAnonymousSoundPool, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(163724);
          if (paramAnonymousInt2 == 0)
          {
            if (paramAnonymousInt1 == LuckyMoneyDetailUI.H(LuckyMoneyDetailUI.this)[0])
            {
              paramAnonymousSoundPool.play(paramAnonymousInt1, 1.0F, 1.0F, 0, 0, 1.0F);
              AppMethodBeat.o(163724);
              return;
            }
            if ((paramAnonymousInt1 == LuckyMoneyDetailUI.H(LuckyMoneyDetailUI.this)[1]) && (paraml.dEb >= 19000L)) {
              paramAnonymousSoundPool.play(paramAnonymousInt1, 1.0F, 1.0F, 0, 0, 1.0F);
            }
          }
          AppMethodBeat.o(163724);
        }
      });
      this.adC.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(163725);
          LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, (ViewGroup)LuckyMoneyDetailUI.this.findViewById(2131301813));
          Object localObject = LuckyMoneyDetailUI.I(LuckyMoneyDetailUI.this);
          com.tencent.mm.particles.b localb = LuckyMoneyDetailUI.J(LuckyMoneyDetailUI.this);
          com.tencent.mm.particles.a locala = new com.tencent.mm.particles.a((ViewGroup)localObject);
          localObject = new com.tencent.mm.particles.c(((ViewGroup)localObject).getContext(), localb, new com.tencent.mm.particles.d(-100, ((ViewGroup)localObject).getHeight() / 2), (ViewGroup)localObject).y(600.0F, 150.0F).z(-1000.0F, 250.0F).ai(-200.0F).aj(1500.0F);
          ((com.tencent.mm.particles.c)localObject).hPw = 600.0F;
          ((com.tencent.mm.particles.c)localObject).hPx = 300.0F;
          localObject = ((com.tencent.mm.particles.c)localObject).aFz();
          ((com.tencent.mm.particles.c)localObject).hOZ = com.tencent.mm.particles.e.aFI();
          locala.hON = ((com.tencent.mm.particles.c)localObject).aFA().aFB();
          locala.D(100, 400L);
          localObject = LuckyMoneyDetailUI.I(LuckyMoneyDetailUI.this);
          localb = LuckyMoneyDetailUI.J(LuckyMoneyDetailUI.this);
          locala = new com.tencent.mm.particles.a((ViewGroup)localObject);
          localObject = new com.tencent.mm.particles.c(((ViewGroup)localObject).getContext(), localb, new com.tencent.mm.particles.d(((ViewGroup)localObject).getWidth() + 100, ((ViewGroup)localObject).getHeight() / 2), (ViewGroup)localObject).y(-600.0F, 150.0F).z(-1000.0F, 250.0F).ai(200.0F).aj(1500.0F);
          ((com.tencent.mm.particles.c)localObject).hPw = 600.0F;
          ((com.tencent.mm.particles.c)localObject).hPx = 300.0F;
          localObject = ((com.tencent.mm.particles.c)localObject).aFz();
          ((com.tencent.mm.particles.c)localObject).hOZ = com.tencent.mm.particles.e.aFI();
          locala.hON = ((com.tencent.mm.particles.c)localObject).aFA().aFB();
          locala.D(100, 400L);
          AppMethodBeat.o(163725);
        }
      }, 300L);
      if (!w.sz(this.fwd))
      {
        localObject1 = new com.tencent.mm.plugin.wallet_core.model.ad();
        ((com.tencent.mm.plugin.wallet_core.model.ad)localObject1).field_mNativeUrl = this.tkm;
        ((com.tencent.mm.plugin.wallet_core.model.ad)localObject1).field_hbType = paraml.dDN;
        ((com.tencent.mm.plugin.wallet_core.model.ad)localObject1).field_receiveAmount = paraml.dEb;
        ((com.tencent.mm.plugin.wallet_core.model.ad)localObject1).field_receiveTime = System.currentTimeMillis();
        ((com.tencent.mm.plugin.wallet_core.model.ad)localObject1).field_hbStatus = paraml.dDO;
        ((com.tencent.mm.plugin.wallet_core.model.ad)localObject1).field_receiveStatus = paraml.dDP;
        if (((com.tencent.mm.plugin.wallet_core.model.ad)localObject1).field_receiveAmount > 0L) {
          com.tencent.mm.plugin.wallet_core.model.s.ebY().a((com.tencent.mm.plugin.wallet_core.model.ad)localObject1);
        }
      }
      cMu();
      if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
        this.tipDialog.dismiss();
      }
      AppMethodBeat.o(65573);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.LuckyMoneyDetailUI", "load lucky money voice fail " + localIOException.getMessage());
      }
    }
  }
  
  private void b(cic paramcic)
  {
    AppMethodBeat.i(163739);
    f(this.tlV);
    this.tlv.a(paramcic, this.tlU, this.tlI, this.nYJ, w.sz(this.fwd));
    cMu();
    AppMethodBeat.o(163739);
  }
  
  private void bl(int paramInt, String paramString)
  {
    AppMethodBeat.i(65575);
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (w.sz(this.fwd)) {
        this.tll.setVisibility(8);
      }
      AppMethodBeat.o(65575);
      return;
      this.tll.setVisibility(8);
      continue;
      this.tll.setVisibility(0);
      this.tlm.setVisibility(0);
      this.tln.setVisibility(8);
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fnt, "");
      continue;
      if (!bt.isNullOrNil(paramString))
      {
        paramString = k.getEmojiStorageMgr().FyY.aJx(paramString);
        if (paramString == null)
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LuckyMoneyDetailUI", "exchangeThxEmojiState() temp == null");
          AppMethodBeat.o(65575);
          return;
        }
        this.tlA = paramString;
        com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fnt, this.tlA.JS());
        this.tlo.setEmojiInfo(this.tlA);
        this.tll.setVisibility(0);
        this.tlm.setVisibility(8);
        this.tln.setVisibility(0);
      }
    }
  }
  
  private void cMs()
  {
    AppMethodBeat.i(65563);
    ((com.tencent.mm.pluginsdk.i)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.i.class)).a(this, this.fwd, this.tlA.JS(), getString(2131760956), new y.a()
    {
      public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(163714);
        LuckyMoneyDetailUI.this.hideVKB();
        LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, new bp());
        if (paramAnonymousBoolean)
        {
          LuckyMoneyDetailUI.w(LuckyMoneyDetailUI.this).dMW = 5L;
          LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, new bq());
          paramAnonymousInt = 0;
          if ((LuckyMoneyDetailUI.x(LuckyMoneyDetailUI.this) == 0) || (LuckyMoneyDetailUI.x(LuckyMoneyDetailUI.this) == 2)) {
            if (com.tencent.mm.plugin.emoji.h.b.y(LuckyMoneyDetailUI.y(LuckyMoneyDetailUI.this)))
            {
              paramAnonymousInt = 1;
              LuckyMoneyDetailUI.z(LuckyMoneyDetailUI.this).dPU = paramAnonymousInt;
              bq localbq = LuckyMoneyDetailUI.z(LuckyMoneyDetailUI.this);
              localbq.dPV = localbq.t("emoticonMd5", LuckyMoneyDetailUI.y(LuckyMoneyDetailUI.this).JS(), true);
              if (!bt.isNullOrNil(paramAnonymousString)) {
                break label300;
              }
              LuckyMoneyDetailUI.z(LuckyMoneyDetailUI.this).dPW = 1L;
              label159:
              LuckyMoneyDetailUI.z(LuckyMoneyDetailUI.this).aBj();
              LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, LuckyMoneyDetailUI.v(LuckyMoneyDetailUI.this), paramAnonymousString, LuckyMoneyDetailUI.y(LuckyMoneyDetailUI.this).JS());
              LuckyMoneyDetailUI.b(LuckyMoneyDetailUI.this, 3);
              com.tencent.mm.ui.base.s.a(LuckyMoneyDetailUI.this.getContext().getResources().getString(2131760233), LuckyMoneyDetailUI.this.getContext(), null);
              aq.n(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(163713);
                  LuckyMoneyDetailUI.this.finish();
                  AppMethodBeat.o(163713);
                }
              }, 500L);
            }
          }
        }
        for (;;)
        {
          LuckyMoneyDetailUI.w(LuckyMoneyDetailUI.this).aBj();
          AppMethodBeat.o(163714);
          return;
          if (com.tencent.mm.plugin.emoji.h.b.w(LuckyMoneyDetailUI.y(LuckyMoneyDetailUI.this)))
          {
            paramAnonymousInt = 3;
            break;
          }
          paramAnonymousInt = 2;
          break;
          if (LuckyMoneyDetailUI.x(LuckyMoneyDetailUI.this) != 1) {
            break;
          }
          paramAnonymousInt = 1;
          break;
          label300:
          LuckyMoneyDetailUI.z(LuckyMoneyDetailUI.this).dPW = 2L;
          break label159;
          LuckyMoneyDetailUI.w(LuckyMoneyDetailUI.this).dMW = 6L;
        }
      }
    });
    AppMethodBeat.o(65563);
  }
  
  private boolean cMt()
  {
    AppMethodBeat.i(65572);
    if ((!bt.isNullOrNil(this.oyM)) && ((bt.iY(this.tlC.tdI, 1)) || (bt.iY(this.tlC.tdJ, 1))))
    {
      AppMethodBeat.o(65572);
      return true;
    }
    AppMethodBeat.o(65572);
    return false;
  }
  
  private void cMu()
  {
    AppMethodBeat.i(163741);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.LuckyMoneyDetailUI", "adjust footer");
    this.oBA.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(163733);
        if ((LuckyMoneyDetailUI.this.isFinishing()) || (LuckyMoneyDetailUI.this.isDestroyed()))
        {
          AppMethodBeat.o(163733);
          return;
        }
        if ((LuckyMoneyDetailUI.N(LuckyMoneyDetailUI.this).getVisibility() == 8) && (LuckyMoneyDetailUI.O(LuckyMoneyDetailUI.this).getVisibility() == 8) && (LuckyMoneyDetailUI.P(LuckyMoneyDetailUI.this).getVisibility() == 8))
        {
          AppMethodBeat.o(163733);
          return;
        }
        Object localObject = LuckyMoneyDetailUI.this.findViewById(2131301755);
        if ((LuckyMoneyDetailUI.Q(LuckyMoneyDetailUI.this) == null) || (localObject == null))
        {
          AppMethodBeat.o(163733);
          return;
        }
        if (!LuckyMoneyDetailUI.R(LuckyMoneyDetailUI.this))
        {
          LuckyMoneyDetailUI.S(LuckyMoneyDetailUI.this);
          LuckyMoneyDetailUI.c(LuckyMoneyDetailUI.this, LuckyMoneyDetailUI.Q(LuckyMoneyDetailUI.this).getHeight());
        }
        int i = ((View)localObject).getHeight();
        localObject = new Rect();
        LuckyMoneyDetailUI.Q(LuckyMoneyDetailUI.this).getGlobalVisibleRect((Rect)localObject);
        int j = LuckyMoneyDetailUI.Q(LuckyMoneyDetailUI.this).getTop();
        int k = i - j;
        if (k > LuckyMoneyDetailUI.T(LuckyMoneyDetailUI.this)) {
          LuckyMoneyDetailUI.Q(LuckyMoneyDetailUI.this).setMinimumHeight(k);
        }
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.LuckyMoneyDetailUI", "winHeight:%s diff:%s recordHeight:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(j) });
          AppMethodBeat.o(163733);
          return;
          LuckyMoneyDetailUI.Q(LuckyMoneyDetailUI.this).setMinimumHeight(LuckyMoneyDetailUI.T(LuckyMoneyDetailUI.this));
        }
      }
    });
    AppMethodBeat.o(163741);
  }
  
  private boolean e(com.tencent.mm.plugin.luckymoney.model.l paraml)
  {
    return (paraml.dDP == 2) && (this.tkk != 3);
  }
  
  private void f(com.tencent.mm.plugin.luckymoney.model.l paraml)
  {
    AppMethodBeat.i(163740);
    if (paraml.tdH != null)
    {
      paraml = av.afq(paraml.tdH);
      if ((bt.isNullOrNil(this.tlU)) && (paraml != null) && (paraml.tcN != null)) {
        this.tlU = paraml.tcN.Daf;
      }
      this.thG = getIntent().getStringExtra("key_detail_envelope_url");
      this.thH = getIntent().getStringExtra("key_detail_envelope_md5");
      if ((bt.isNullOrNil(this.thG)) && (paraml != null) && (paraml.tcN != null) && (paraml.tcN.DDh != null))
      {
        this.thG = paraml.tcN.DDh.DDy;
        this.thH = paraml.tcN.DDh.DDB;
      }
      if ((!bt.isNullOrNil(this.thG)) && (!bt.isNullOrNil(this.thH)))
      {
        this.tlv.hg(this.thG, this.thH);
        if (!this.tlx)
        {
          this.tlx = true;
          com.tencent.mm.plugin.luckymoney.a.c.bi(3, this.thG);
        }
      }
    }
    AppMethodBeat.o(163740);
  }
  
  private static boolean g(com.tencent.mm.plugin.luckymoney.model.l paraml)
  {
    return paraml.tds == 1;
  }
  
  private void mN(boolean paramBoolean)
  {
    AppMethodBeat.i(65569);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LuckyMoneyDetailUI", "showEmoji() circle:%s", new Object[] { Boolean.TRUE });
    this.tli.setVisibility(8);
    this.tmb = 1;
    if (paramBoolean) {
      this.tlY = 3;
    }
    do
    {
      this.oBl = k.getEmojiStorageMgr().FyY.aJx(this.oyM);
      if (this.oBl == null) {
        break;
      }
      if ((com.tencent.mm.vfs.i.aMN(this.oBl.gaa()) <= 0L) && (!this.oBl.CZ()) && (!this.oBl.fZQ())) {
        break label218;
      }
      this.tlh.setVisibility(0);
      A(this.oBl);
      AppMethodBeat.o(65569);
      return;
      this.tlY -= 1;
    } while (this.tlY != 0);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LuckyMoneyDetailUI", "showEmoji() circle fail!");
    this.tlj.setVisibility(8);
    this.tli.setVisibility(0);
    this.tmb = 2;
    AppMethodBeat.o(65569);
    return;
    this.oBl = new EmojiInfo();
    this.oBl.field_md5 = this.oyM;
    this.oBl.field_type = this.tly;
    label218:
    if (paramBoolean)
    {
      this.tlh.setVisibility(8);
      this.tlj.setVisibility(0);
      k.bUY().owM = this.owM;
    }
    k.bUY().u(this.oBl);
    com.tencent.mm.kernel.g.afA().gcy.a(697, this.tlZ);
    AppMethodBeat.o(65569);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(65565);
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(65565);
    return bool;
  }
  
  public boolean enableActivityAnimation()
  {
    return false;
  }
  
  public void finish()
  {
    AppMethodBeat.i(65568);
    if (getIntent().hasExtra("key_realname_guide_helper"))
    {
      RealnameGuideHelper localRealnameGuideHelper = (RealnameGuideHelper)getIntent().getParcelableExtra("key_realname_guide_helper");
      Bundle localBundle = new Bundle();
      localBundle.putString("realname_verify_process_jump_activity", ".ui.LuckyMoneyDetailUI");
      localBundle.putString("realname_verify_process_jump_plugin", "luckymoney");
      boolean bool = localRealnameGuideHelper.b(this, localBundle, new LuckyMoneyDetailUI.7(this));
      getIntent().removeExtra("key_realname_guide_helper");
      if (!bool) {
        super.finish();
      }
    }
    for (;;)
    {
      overridePendingTransition(2130772140, 2130772145);
      AppMethodBeat.o(65568);
      return;
      super.finish();
    }
  }
  
  public int getLayoutId()
  {
    return 2131494636;
  }
  
  public void initView()
  {
    AppMethodBeat.i(65561);
    setMMTitle("");
    setBackBtn(new LuckyMoneyDetailUI.22(this), 2131232693);
    this.tkS = ((RecyclerView)findViewById(2131301770));
    RecyclerView localRecyclerView = this.tkS;
    getContext();
    localRecyclerView.setLayoutManager(new LinearLayoutManager(1));
    this.adC = LayoutInflater.from(this).inflate(2131494635, this.tkS, false);
    this.oBA = LayoutInflater.from(this).inflate(2131494633, this.tkS, false);
    this.tlS = new WxRecyclerAdapter(new com.tencent.mm.view.recyclerview.c()
    {
      public final com.tencent.mm.view.recyclerview.b<?> zm(int paramAnonymousInt)
      {
        AppMethodBeat.i(163734);
        if (paramAnonymousInt == 2)
        {
          LuckyMoneyDetailUI.b localb = new LuckyMoneyDetailUI.b(LuckyMoneyDetailUI.this);
          AppMethodBeat.o(163734);
          return localb;
        }
        AppMethodBeat.o(163734);
        return null;
      }
    }, this.tlw, false);
    this.tlS.f(this.adC, 1, false);
    this.tkS.setAdapter(this.tlS);
    this.tkS.a(this.akH);
    this.sZc = ((ImageView)this.adC.findViewById(2131301774));
    this.sZd = ((TextView)this.adC.findViewById(2131301789));
    this.tlu = this.adC.findViewById(2131301787);
    this.sZe = ((ImageView)this.adC.findViewById(2131301757));
    this.swB = ((TextView)this.adC.findViewById(2131301792));
    this.tlg = ((RelativeLayout)this.adC.findViewById(2131301797));
    this.tlh = ((BaseEmojiView)this.adC.findViewById(2131301793));
    this.tli = ((TextView)this.adC.findViewById(2131301941));
    this.tlj = ((LinearLayout)this.adC.findViewById(2131301835));
    this.tlk = ((ProgressBar)this.adC.findViewById(2131299385));
    this.sZf = this.adC.findViewById(2131301742);
    this.sYT = ((TextView)this.adC.findViewById(2131301741));
    this.sZg = this.adC.findViewById(2131301759);
    this.lln = ((TextView)this.adC.findViewById(2131301785));
    this.tkT = ((CdnImageView)this.adC.findViewById(2131301758));
    this.kFd = ((TextView)this.adC.findViewById(2131301748));
    this.tkh = this.adC.findViewById(2131301768);
    this.tkU = this.adC.findViewById(2131301746);
    this.tkV = ((ImageView)this.adC.findViewById(2131301745));
    this.tll = ((LinearLayout)this.adC.findViewById(2131301948));
    this.tlm = ((LinearLayout)this.adC.findViewById(2131301952));
    this.tln = ((LinearLayout)this.adC.findViewById(2131301955));
    this.tlo = ((BaseEmojiView)this.adC.findViewById(2131301949));
    this.tlp = ((RelativeLayout)this.adC.findViewById(2131301954));
    this.tlq = ((ImageView)this.adC.findViewById(2131301950));
    this.tkW = ((ViewGroup)this.adC.findViewById(2131301750));
    this.tkX = this.adC.findViewById(2131301749);
    this.tkY = this.adC.findViewById(2131301751);
    this.tkZ = this.adC.findViewById(2131301752);
    this.tld = ((RelativeLayout)this.adC.findViewById(2131301746));
    this.pev = ((ImageView)this.adC.findViewById(2131301745));
    this.tlt = ((ImageView)this.adC.findViewById(2131301957));
    this.tlf = ((ViewGroup)findViewById(2131301813));
    this.tli.setOnClickListener(new LuckyMoneyDetailUI.24(this));
    this.tlr = new a(this);
    this.tls = getLayoutInflater().inflate(2131494640, null);
    this.tlr.setContentView(this.tls, new ViewGroup.LayoutParams(-1, -1));
    this.tls.findViewById(2131301796).setOnClickListener(new LuckyMoneyDetailUI.25(this));
    this.tlr.tjq = new LuckyMoneyDetailUI.26(this);
    this.tlB = ((ViewGroup)this.tls.findViewById(2131301798));
    if (com.tencent.mm.pluginsdk.ui.chat.e.Cgj == null)
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.LuckyMoneyDetailUI", "can't show correctly");
      finish();
      AppMethodBeat.o(65561);
      return;
    }
    this.tlz = com.tencent.mm.pluginsdk.ui.chat.e.Cgj.es(getContext());
    this.tlz.setTalkerName(this.fwd);
    this.tlz.setShowSmiley(false);
    this.tkT.setUseSdcardCache(true);
    this.tlh.setOnClickListener(new LuckyMoneyDetailUI.2(this));
    this.tlv = ((EnvelopeAppBarLayout)findViewById(2131301805));
    this.tlv.setActivityLifeCycle(this);
    AppMethodBeat.o(65561);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(65567);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(65567);
      return;
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        String str = paramIntent.getStringExtra("Select_Conv_User");
        if (!bt.isNullOrNil(str)) {
          if ((this.tkn != null) && (this.tkn.startsWith("wxpay://c2cbizmessagehandler/hongbao/festivalhongbao")))
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LuckyMoneyDetailUI", "Not expected branch since 2015 fesitval");
          }
          else
          {
            doSceneProgress(new at(str.replaceAll(",", "|"), this.tka, "v1.0"));
            continue;
            if (paramInt2 == -1)
            {
              str = "";
              if (paramIntent != null) {
                str = paramIntent.getStringExtra("gif_md5");
              }
              if (!bt.isNullOrNil(str))
              {
                bl(2, str);
                cMs();
              }
              else
              {
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LuckyMoneyDetailUI", "md5 == null go emoji capture failed!");
              }
            }
            else
            {
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LuckyMoneyDetailUI", "go emoji capture failed!");
              continue;
              com.tencent.mm.plugin.luckymoney.a.d.sw(8);
            }
          }
        }
      }
    }
  }
  
  /* Error */
  public void onCreate(Bundle paramBundle)
  {
    // Byte code:
    //   0: ldc_w 2020
    //   3: invokestatic 209	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokestatic 2024	com/tencent/mm/pluginsdk/g:o	(Lcom/tencent/mm/ui/MMActivity;)V
    //   10: aload_0
    //   11: iconst_1
    //   12: invokevirtual 2027	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:customfixStatusbar	(Z)V
    //   15: aload_0
    //   16: iconst_0
    //   17: putfield 2030	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:tjZ	Z
    //   20: aload_0
    //   21: invokevirtual 1647	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   24: ldc_w 2032
    //   27: iconst_0
    //   28: invokevirtual 2036	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   31: ifne +13 -> 44
    //   34: aload_0
    //   35: ldc_w 2037
    //   38: ldc_w 2038
    //   41: invokevirtual 1817	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:overridePendingTransition	(II)V
    //   44: aload_0
    //   45: aload_1
    //   46: invokespecial 2040	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBaseUI:onCreate	(Landroid/os/Bundle;)V
    //   49: aload_0
    //   50: invokevirtual 2044	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getWindow	()Landroid/view/Window;
    //   53: invokevirtual 2049	android/view/Window:getDecorView	()Landroid/view/View;
    //   56: sipush 1280
    //   59: invokevirtual 2052	android/view/View:setSystemUiVisibility	(I)V
    //   62: aload_0
    //   63: invokevirtual 2044	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getWindow	()Landroid/view/Window;
    //   66: ldc_w 2053
    //   69: invokevirtual 2056	android/view/Window:setBackgroundDrawableResource	(I)V
    //   72: aload_0
    //   73: aload_0
    //   74: invokevirtual 1647	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   77: ldc_w 2058
    //   80: invokevirtual 1652	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   83: putfield 923	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:tlI	Ljava/lang/String;
    //   86: aload_0
    //   87: aload_0
    //   88: invokevirtual 1647	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   91: ldc_w 2060
    //   94: iconst_0
    //   95: invokevirtual 2064	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   98: putfield 1524	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:nYJ	I
    //   101: aload_0
    //   102: invokevirtual 2068	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getController	()Lcom/tencent/mm/ui/r;
    //   105: iconst_0
    //   106: putfield 2073	com/tencent/mm/ui/r:FOb	Z
    //   109: aload_0
    //   110: aload_0
    //   111: invokevirtual 415	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getResources	()Landroid/content/res/Resources;
    //   114: ldc_w 2074
    //   117: invokevirtual 866	android/content/res/Resources:getColor	(I)I
    //   120: invokevirtual 2077	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:setActionbarColor	(I)V
    //   123: aload_0
    //   124: invokevirtual 2080	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:hideActionbarLine	()V
    //   127: aload_0
    //   128: aload_0
    //   129: invokevirtual 1647	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   132: ldc_w 2082
    //   135: iconst_0
    //   136: invokevirtual 2036	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   139: putfield 244	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:tlH	Z
    //   142: aload_0
    //   143: aload_0
    //   144: invokevirtual 1647	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   147: ldc_w 2084
    //   150: invokevirtual 1652	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   153: putfield 729	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:fwd	Ljava/lang/String;
    //   156: aload_0
    //   157: aload_0
    //   158: invokevirtual 1647	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   161: ldc_w 2086
    //   164: invokevirtual 1652	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   167: putfield 1620	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:tka	Ljava/lang/String;
    //   170: aload_0
    //   171: aload_0
    //   172: invokevirtual 1647	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   175: ldc_w 2088
    //   178: invokevirtual 1652	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   181: putfield 1113	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:tkm	Ljava/lang/String;
    //   184: aload_0
    //   185: aload_0
    //   186: invokevirtual 1647	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   189: ldc_w 2090
    //   192: iconst_2
    //   193: invokevirtual 2064	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   196: putfield 804	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:tkk	I
    //   199: aload_0
    //   200: aload_0
    //   201: invokevirtual 1647	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   204: ldc_w 2092
    //   207: invokevirtual 1652	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   210: putfield 236	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:tkr	Ljava/lang/String;
    //   213: aload_0
    //   214: aload_0
    //   215: invokevirtual 1647	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   218: ldc_w 2094
    //   221: lconst_0
    //   222: invokevirtual 2097	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   225: putfield 1765	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:fll	J
    //   228: aload_0
    //   229: aload_0
    //   230: invokevirtual 1647	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   233: ldc_w 2099
    //   236: invokevirtual 1652	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   239: putfield 1522	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:tlU	Ljava/lang/String;
    //   242: aload_0
    //   243: aload_0
    //   244: invokevirtual 1647	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   247: ldc_w 1649
    //   250: invokevirtual 1652	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   253: putfield 1654	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:thG	Ljava/lang/String;
    //   256: aload_0
    //   257: aload_0
    //   258: invokevirtual 1647	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   261: ldc_w 1656
    //   264: invokevirtual 1652	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   267: putfield 1658	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:thH	Ljava/lang/String;
    //   270: ldc_w 430
    //   273: new 677	java/lang/StringBuilder
    //   276: dup
    //   277: ldc_w 2101
    //   280: invokespecial 682	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   283: aload_0
    //   284: getfield 1620	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:tka	Ljava/lang/String;
    //   287: invokestatic 2104	com/tencent/mm/sdk/platformtools/bt:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   290: invokevirtual 1167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: ldc_w 2106
    //   296: invokevirtual 1167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: aload_0
    //   300: getfield 1113	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:tkm	Ljava/lang/String;
    //   303: invokestatic 2104	com/tencent/mm/sdk/platformtools/bt:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   306: invokevirtual 1167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: ldc_w 2108
    //   312: invokevirtual 1167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: aload_0
    //   316: getfield 804	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:tkk	I
    //   319: invokevirtual 686	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   322: ldc_w 2110
    //   325: invokevirtual 1167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: aload_0
    //   329: getfield 1522	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:tlU	Ljava/lang/String;
    //   332: invokevirtual 1167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: invokevirtual 690	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   338: invokestatic 693	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   341: aload_0
    //   342: getfield 1620	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:tka	Ljava/lang/String;
    //   345: invokestatic 580	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   348: ifeq +32 -> 380
    //   351: aload_0
    //   352: getfield 1113	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:tkm	Ljava/lang/String;
    //   355: invokestatic 580	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   358: ifne +22 -> 380
    //   361: aload_0
    //   362: getfield 1113	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:tkm	Ljava/lang/String;
    //   365: invokestatic 2116	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   368: astore_1
    //   369: aload_0
    //   370: aload_1
    //   371: ldc_w 2118
    //   374: invokevirtual 2121	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   377: putfield 1620	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:tka	Ljava/lang/String;
    //   380: aload_0
    //   381: aload_0
    //   382: invokevirtual 1647	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   385: ldc_w 2123
    //   388: invokevirtual 1652	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   391: putfield 1587	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:oyM	Ljava/lang/String;
    //   394: aload_0
    //   395: aload_0
    //   396: invokevirtual 1647	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   399: ldc_w 2125
    //   402: iconst_0
    //   403: invokevirtual 2064	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   406: putfield 1719	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:tly	I
    //   409: aload_0
    //   410: getfield 1587	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:oyM	Ljava/lang/String;
    //   413: invokestatic 580	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   416: ifne +32 -> 448
    //   419: aload_0
    //   420: new 299	com/tencent/mm/g/b/a/br
    //   423: dup
    //   424: invokespecial 300	com/tencent/mm/g/b/a/br:<init>	()V
    //   427: putfield 302	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:tlD	Lcom/tencent/mm/g/b/a/br;
    //   430: aload_0
    //   431: getfield 302	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:tlD	Lcom/tencent/mm/g/b/a/br;
    //   434: ldc2_w 2126
    //   437: putfield 307	com/tencent/mm/g/b/a/br:dMW	J
    //   440: aload_0
    //   441: getfield 302	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:tlD	Lcom/tencent/mm/g/b/a/br;
    //   444: invokevirtual 311	com/tencent/mm/g/b/a/br:aBj	()Z
    //   447: pop
    //   448: aload_0
    //   449: aload_0
    //   450: invokevirtual 1647	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   453: ldc_w 2129
    //   456: invokevirtual 1787	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   459: checkcast 333	com/tencent/mm/plugin/luckymoney/model/LuckyMoneyEmojiSwitch
    //   462: putfield 331	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:tlC	Lcom/tencent/mm/plugin/luckymoney/model/LuckyMoneyEmojiSwitch;
    //   465: aload_0
    //   466: getfield 331	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:tlC	Lcom/tencent/mm/plugin/luckymoney/model/LuckyMoneyEmojiSwitch;
    //   469: ifnonnull +14 -> 483
    //   472: aload_0
    //   473: new 333	com/tencent/mm/plugin/luckymoney/model/LuckyMoneyEmojiSwitch
    //   476: dup
    //   477: invokespecial 2130	com/tencent/mm/plugin/luckymoney/model/LuckyMoneyEmojiSwitch:<init>	()V
    //   480: putfield 331	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:tlC	Lcom/tencent/mm/plugin/luckymoney/model/LuckyMoneyEmojiSwitch;
    //   483: aload_0
    //   484: getfield 1620	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:tka	Ljava/lang/String;
    //   487: invokestatic 2136	com/tencent/mm/plugin/luckymoney/a/b:afi	(Ljava/lang/String;)Lcom/tencent/mm/plugin/luckymoney/model/l;
    //   490: astore_1
    //   491: aload_1
    //   492: ifnull +73 -> 565
    //   495: aload_0
    //   496: aload_1
    //   497: putfield 1516	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:tlV	Lcom/tencent/mm/plugin/luckymoney/model/l;
    //   500: aload_0
    //   501: invokevirtual 2138	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:initView	()V
    //   504: aload_0
    //   505: getfield 1516	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:tlV	Lcom/tencent/mm/plugin/luckymoney/model/l;
    //   508: ifnonnull +134 -> 642
    //   511: ldc_w 430
    //   514: ldc_w 2140
    //   517: invokestatic 1956	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   520: aload_0
    //   521: invokevirtual 1957	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:finish	()V
    //   524: ldc_w 2020
    //   527: invokestatic 282	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   530: return
    //   531: astore_1
    //   532: ldc_w 430
    //   535: aload_1
    //   536: ldc 234
    //   538: iconst_0
    //   539: anewarray 434	java/lang/Object
    //   542: invokestatic 1318	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   545: invokestatic 2145	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   548: ldc_w 2147
    //   551: iconst_0
    //   552: invokestatic 2153	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   555: invokevirtual 2154	android/widget/Toast:show	()V
    //   558: ldc_w 2020
    //   561: invokestatic 282	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   564: return
    //   565: aload_0
    //   566: invokevirtual 1647	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   569: ldc_w 2156
    //   572: invokevirtual 2160	android/content/Intent:getByteArrayExtra	(Ljava/lang/String;)[B
    //   575: astore_1
    //   576: aload_1
    //   577: ifnull +58 -> 635
    //   580: aload_0
    //   581: new 552	com/tencent/mm/plugin/luckymoney/model/l
    //   584: dup
    //   585: invokespecial 2161	com/tencent/mm/plugin/luckymoney/model/l:<init>	()V
    //   588: aload_1
    //   589: invokevirtual 2165	com/tencent/mm/plugin/luckymoney/model/l:parseFrom	([B)Lcom/tencent/mm/bx/a;
    //   592: checkcast 552	com/tencent/mm/plugin/luckymoney/model/l
    //   595: putfield 1516	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:tlV	Lcom/tencent/mm/plugin/luckymoney/model/l;
    //   598: goto -98 -> 500
    //   601: astore_1
    //   602: ldc_w 430
    //   605: new 677	java/lang/StringBuilder
    //   608: dup
    //   609: ldc_w 2167
    //   612: invokespecial 682	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   615: aload_1
    //   616: invokevirtual 2170	java/lang/Exception:getLocalizedMessage	()Ljava/lang/String;
    //   619: invokevirtual 1167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   622: invokevirtual 690	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   625: invokestatic 1956	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   628: aload_0
    //   629: invokevirtual 1957	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:finish	()V
    //   632: goto -132 -> 500
    //   635: aload_0
    //   636: invokevirtual 1957	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:finish	()V
    //   639: goto -139 -> 500
    //   642: aload_0
    //   643: getfield 1516	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:tlV	Lcom/tencent/mm/plugin/luckymoney/model/l;
    //   646: ifnull +67 -> 713
    //   649: aload_0
    //   650: getfield 1516	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:tlV	Lcom/tencent/mm/plugin/luckymoney/model/l;
    //   653: getfield 902	com/tencent/mm/plugin/luckymoney/model/l:tdH	Ljava/lang/String;
    //   656: invokestatic 908	com/tencent/mm/plugin/luckymoney/model/av:afq	(Ljava/lang/String;)Lcom/tencent/mm/plugin/luckymoney/model/av;
    //   659: astore_1
    //   660: aload_1
    //   661: ifnull +52 -> 713
    //   664: aload_1
    //   665: getfield 915	com/tencent/mm/plugin/luckymoney/model/av:tcN	Lcom/tencent/mm/protocal/protobuf/bfu;
    //   668: ifnull +45 -> 713
    //   671: aload_0
    //   672: getfield 1522	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:tlU	Ljava/lang/String;
    //   675: invokestatic 580	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   678: ifeq +14 -> 692
    //   681: aload_0
    //   682: aload_1
    //   683: getfield 915	com/tencent/mm/plugin/luckymoney/model/av:tcN	Lcom/tencent/mm/protocal/protobuf/bfu;
    //   686: getfield 929	com/tencent/mm/protocal/protobuf/bfu:Daf	Ljava/lang/String;
    //   689: putfield 1522	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:tlU	Ljava/lang/String;
    //   692: aload_0
    //   693: getfield 923	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:tlI	Ljava/lang/String;
    //   696: invokestatic 580	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   699: ifeq +14 -> 713
    //   702: aload_0
    //   703: aload_1
    //   704: getfield 915	com/tencent/mm/plugin/luckymoney/model/av:tcN	Lcom/tencent/mm/protocal/protobuf/bfu;
    //   707: getfield 926	com/tencent/mm/protocal/protobuf/bfu:DDg	Ljava/lang/String;
    //   710: putfield 923	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:tlI	Ljava/lang/String;
    //   713: aload_0
    //   714: getfield 729	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:fwd	Ljava/lang/String;
    //   717: invokestatic 734	com/tencent/mm/model/w:sz	(Ljava/lang/String;)Z
    //   720: ifeq +97 -> 817
    //   723: ldc_w 430
    //   726: ldc_w 2172
    //   729: invokestatic 693	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   732: aload_0
    //   733: getfield 1765	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:fll	J
    //   736: invokestatic 2177	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   739: invokestatic 2180	com/tencent/mm/plugin/luckymoney/a/b:d	(Ljava/lang/Long;)Lcom/tencent/mm/protocal/protobuf/cib;
    //   742: astore_1
    //   743: aload_1
    //   744: ifnull +11 -> 755
    //   747: aload_0
    //   748: aload_1
    //   749: getfield 2186	com/tencent/mm/protocal/protobuf/cib:Dyf	Lcom/tencent/mm/protocal/protobuf/cic;
    //   752: invokespecial 2188	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:b	(Lcom/tencent/mm/protocal/protobuf/cic;)V
    //   755: aload_0
    //   756: aload_0
    //   757: getfield 1516	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:tlV	Lcom/tencent/mm/plugin/luckymoney/model/l;
    //   760: invokespecial 2190	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:a	(Lcom/tencent/mm/plugin/luckymoney/model/l;)V
    //   763: aload_0
    //   764: invokevirtual 1647	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   767: ldc_w 2192
    //   770: iconst_0
    //   771: invokevirtual 2036	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   774: ifeq +10 -> 784
    //   777: aload_0
    //   778: getstatic 2198	com/tencent/mm/plugin/luckymoney/ui/k$a:tqF	Lcom/tencent/mm/plugin/luckymoney/ui/k$a;
    //   781: invokestatic 2203	com/tencent/mm/plugin/luckymoney/ui/k:a	(Landroid/content/Context;Lcom/tencent/mm/plugin/luckymoney/ui/k$a;)V
    //   784: aload_0
    //   785: getfield 729	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:fwd	Ljava/lang/String;
    //   788: invokestatic 734	com/tencent/mm/model/w:sz	(Ljava/lang/String;)Z
    //   791: ifne +19 -> 810
    //   794: aload_0
    //   795: iconst_0
    //   796: ldc_w 2204
    //   799: new 2206	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$21
    //   802: dup
    //   803: aload_0
    //   804: invokespecial 2207	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$21:<init>	(Lcom/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI;)V
    //   807: invokevirtual 2211	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:addIconOptionMenu	(IILandroid/view/MenuItem$OnMenuItemClickListener;)V
    //   810: ldc_w 2020
    //   813: invokestatic 282	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   816: return
    //   817: aload_0
    //   818: getfield 1522	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:tlU	Ljava/lang/String;
    //   821: invokestatic 580	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   824: ifne +50 -> 874
    //   827: aload_0
    //   828: getfield 1522	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:tlU	Ljava/lang/String;
    //   831: invokestatic 2215	com/tencent/mm/plugin/luckymoney/a/b:afj	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/cic;
    //   834: astore_1
    //   835: aload_1
    //   836: ifnull +33 -> 869
    //   839: iconst_1
    //   840: istore_2
    //   841: ldc_w 430
    //   844: ldc_w 2217
    //   847: iconst_1
    //   848: anewarray 434	java/lang/Object
    //   851: dup
    //   852: iconst_0
    //   853: iload_2
    //   854: invokestatic 1459	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   857: aastore
    //   858: invokestatic 450	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   861: aload_0
    //   862: aload_1
    //   863: invokespecial 2188	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:b	(Lcom/tencent/mm/protocal/protobuf/cic;)V
    //   866: goto -111 -> 755
    //   869: iconst_0
    //   870: istore_2
    //   871: goto -30 -> 841
    //   874: aload_0
    //   875: aconst_null
    //   876: invokespecial 2188	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:b	(Lcom/tencent/mm/protocal/protobuf/cic;)V
    //   879: goto -124 -> 755
    //   882: astore_1
    //   883: goto -503 -> 380
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	886	0	this	LuckyMoneyDetailUI
    //   0	886	1	paramBundle	Bundle
    //   840	31	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   44	49	531	java/lang/Exception
    //   380	448	601	java/lang/Exception
    //   448	483	601	java/lang/Exception
    //   483	491	601	java/lang/Exception
    //   495	500	601	java/lang/Exception
    //   565	576	601	java/lang/Exception
    //   580	598	601	java/lang/Exception
    //   635	639	601	java/lang/Exception
    //   369	380	882	java/lang/Exception
  }
  
  public boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
  {
    AppMethodBeat.i(65558);
    boolean bool = super.onCreatePanelMenu(paramInt, paramMenu);
    paramMenu = (TextView)findViewById(2131296377);
    if (paramMenu != null) {
      paramMenu.setTextColor(getResources().getColor(2131100576));
    }
    AppMethodBeat.o(65558);
    return bool;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(65577);
    super.onDestroy();
    if ((this.tmb == 1) || (this.tmb == 2))
    {
      this.tlD = new br();
      this.tlD.dMW = 12L;
      this.tlD.aBj();
    }
    if (this.tah != null)
    {
      this.tah.release();
      int i = 0;
      while (i < this.tle.length)
      {
        this.tah.unload(this.tle[i]);
        i += 1;
      }
    }
    if (this.tlz != null)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LuckyMoneyDetailUI", "commentfooter release");
      this.tlz.onPause();
      this.tlz.exm();
      this.tlz.destroy();
    }
    k.bUY().owM = null;
    com.tencent.mm.plugin.luckymoney.a.b.clear();
    com.tencent.mm.plugin.luckymoney.a.c.openId = null;
    com.tencent.mm.plugin.luckymoney.a.c.fPP = null;
    com.tencent.mm.plugin.luckymoney.a.c.sXK = null;
    com.tencent.mm.plugin.luckymoney.a.c.gWU = null;
    com.tencent.mm.plugin.luckymoney.a.c.sXM = 0;
    com.tencent.mm.plugin.luckymoney.a.c.sXL = 0;
    com.tencent.mm.kernel.g.afA().gcy.b(697, this.tlZ);
    AppMethodBeat.o(65577);
  }
  
  public void onKeyboardStateChanged()
  {
    AppMethodBeat.i(65564);
    super.onKeyboardStateChanged();
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.LuckyMoneyDetailUI", "keyboard changed: %s", new Object[] { Integer.valueOf(keyboardState()) });
    keyboardState();
    AppMethodBeat.o(65564);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(65560);
    super.onPause();
    com.tencent.mm.modelstat.d.p("LuckyMoneyDetailUI", this.tlW, bt.aGK());
    AppMethodBeat.o(65560);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(65559);
    super.onResume();
    this.tlW = bt.aGK();
    AppMethodBeat.o(65559);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(65566);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LuckyMoneyDetailUI", "onSceneEnd() errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " netsceneType:" + paramn.getType());
    if ((paramn instanceof ah))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (ah)paramn;
        paramn = paramString.teT;
        this.tkr = paramString.tff;
        this.oyM = paramString.tfg;
        this.tly = paramString.tfh;
        this.tlC = paramString.tfi;
        this.tlV = paramn;
        a(this.tlV);
        AppMethodBeat.o(65566);
        return true;
      }
      com.tencent.mm.ui.base.h.cf(this, paramString);
      AppMethodBeat.o(65566);
      return true;
    }
    if ((paramn instanceof ao))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.sYP = false;
        paramString = (ao)paramn;
        if (this.sYN != null) {
          paramInt1 = 0;
        }
        for (;;)
        {
          if (paramInt1 < this.sYN.size())
          {
            paramn = (y)this.sYN.get(paramInt1);
            if (paramn.tdq.equalsIgnoreCase(paramString.tdq))
            {
              paramn.teH = paramString.sYt;
              this.tlS.aql.notifyChanged();
            }
          }
          else
          {
            AppMethodBeat.o(65566);
            return true;
          }
          paramInt1 += 1;
        }
      }
      com.tencent.mm.ui.base.h.cf(this, paramString);
      AppMethodBeat.o(65566);
      return true;
    }
    if ((paramn instanceof at))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.ui.widget.snackbar.b.n(this, getString(2131760233));
        AppMethodBeat.o(65566);
        return true;
      }
      com.tencent.mm.ui.base.h.cf(this, paramString);
      AppMethodBeat.o(65566);
      return true;
    }
    AppMethodBeat.o(65566);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    implements com.tencent.mm.view.recyclerview.a
  {
    public y tmn;
    
    a() {}
    
    public final long bMs()
    {
      AppMethodBeat.i(163737);
      long l = this.tmn.tdq.hashCode();
      AppMethodBeat.o(163737);
      return l;
    }
    
    public final int bMt()
    {
      return 2;
    }
  }
  
  final class b
    extends com.tencent.mm.view.recyclerview.b<LuckyMoneyDetailUI.a>
  {
    b() {}
    
    public final void a(RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.e parame, int paramInt) {}
    
    public final int getLayoutId()
    {
      return 2131494658;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI
 * JD-Core Version:    0.7.0.1
 */