package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
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
import android.view.MenuItem.OnMenuItemClickListener;
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
import com.tencent.mm.aj.j;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.api.z.a;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.g.a.is;
import com.tencent.mm.g.a.is.b;
import com.tencent.mm.g.b.a.dd;
import com.tencent.mm.g.b.a.de;
import com.tencent.mm.g.b.a.df;
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
import com.tencent.mm.plugin.wallet_core.model.ad;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.pluginsdk.ui.chat.e.b;
import com.tencent.mm.protocal.protobuf.bjm;
import com.tencent.mm.protocal.protobuf.bjn;
import com.tencent.mm.protocal.protobuf.cju;
import com.tencent.mm.protocal.protobuf.cng;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.az;
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
  private int MW;
  private View aew;
  RecyclerView.m alB;
  private long foF;
  private String fzK;
  private boolean kOL;
  private TextView lLe;
  private TextView lgw;
  private int oCe;
  private ImageView pHG;
  private c.a pam;
  private String pcm;
  private EmojiInfo peL;
  private View pfa;
  private TextView tEq;
  private Dialog tipDialog;
  private List<y> uhb;
  private boolean uhd;
  private int uhe;
  private TextView uhh;
  private ImageView uhq;
  private TextView uhr;
  private ImageView uhs;
  private View uht;
  private View uhu;
  private SoundPool uiw;
  private com.tencent.mm.particles.b uka;
  private int ulQ;
  private String upW;
  private String upX;
  private View usA;
  private boolean usC;
  private int usD;
  private String usE;
  private String usF;
  private String usG;
  private Map<String, Integer> usI;
  private String usK;
  private boolean usL;
  private String ust;
  private BaseEmojiView utA;
  private TextView utB;
  private LinearLayout utC;
  private ProgressBar utD;
  private LinearLayout utE;
  private LinearLayout utF;
  private LinearLayout utG;
  private BaseEmojiView utH;
  private RelativeLayout utI;
  private ImageView utJ;
  private a utK;
  private View utL;
  private ImageView utM;
  private View utN;
  private EnvelopeAppBarLayout utO;
  private ArrayList<a> utP;
  private boolean utQ;
  private int utR;
  private ChatFooterPanel utS;
  private EmojiInfo utT;
  private ViewGroup utU;
  public LuckyMoneyEmojiSwitch utV;
  private df utW;
  private dd utX;
  private de utY;
  private int utZ;
  private RecyclerView utl;
  private CdnImageView utm;
  private View utn;
  private ImageView uto;
  private ViewGroup utp;
  private View utq;
  private View utr;
  private View uts;
  private TextView utt;
  private TextView utu;
  private ViewGroup utv;
  private RelativeLayout utw;
  private int[] utx;
  private ViewGroup uty;
  private RelativeLayout utz;
  private boolean uua;
  private String uub;
  private Bitmap uuc;
  private Bitmap uud;
  private Bitmap uue;
  private Bitmap uuf;
  private Bitmap uug;
  private Bitmap uuh;
  private Bitmap uui;
  private Bitmap uuj;
  private boolean uuk;
  private WxRecyclerAdapter uul;
  private int uum;
  private String uun;
  private com.tencent.mm.plugin.luckymoney.model.l uuo;
  private long uup;
  private View.OnClickListener uuq;
  private int uur;
  private com.tencent.mm.ak.g uus;
  private int uut;
  private int uuu;
  private final int uuv;
  private final int uuw;
  
  public LuckyMoneyDetailUI()
  {
    AppMethodBeat.i(65556);
    this.MW = 0;
    this.usC = true;
    this.kOL = false;
    this.ulQ = -1;
    this.uhb = new LinkedList();
    this.utP = new ArrayList();
    this.usI = new HashMap();
    this.usK = "";
    this.utQ = false;
    this.usL = false;
    this.utZ = 0;
    this.uua = false;
    this.alB = new RecyclerView.m()
    {
      private boolean uhx = false;
      private boolean uhy;
      
      public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(163711);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bb(paramAnonymousRecyclerView);
        localb.lS(paramAnonymousInt1);
        localb.lS(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.aeE());
        if ((paramAnonymousRecyclerView.getAdapter().getItemCount() == 0) || (!this.uhx))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
          AppMethodBeat.o(163711);
          return;
        }
        paramAnonymousRecyclerView = (LinearLayoutManager)paramAnonymousRecyclerView.getLayoutManager();
        boolean bool;
        if (paramAnonymousRecyclerView.jW() > 0)
        {
          bool = true;
          if (this.uhy != bool)
          {
            if (bool) {
              LuckyMoneyDetailUI.this.getResources().getDrawable(2131232950);
            }
            this.uhy = bool;
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
          AppMethodBeat.o(163711);
          return;
        }
        paramAnonymousRecyclerView = paramAnonymousRecyclerView.bY(paramAnonymousRecyclerView.jW());
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
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bb(paramAnonymousRecyclerView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).lS(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aeE());
        if (paramAnonymousRecyclerView.getAdapter().getItemCount() == 0)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
          AppMethodBeat.o(163710);
          return;
        }
        switch (paramAnonymousInt)
        {
        }
        for (this.uhx = true;; this.uhx = false)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
          AppMethodBeat.o(163710);
          return;
          localObject = (LinearLayoutManager)paramAnonymousRecyclerView.getLayoutManager();
          if ((((LinearLayoutManager)localObject).jY() == LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this).size()) || (((LinearLayoutManager)localObject).jY() == paramAnonymousRecyclerView.getAdapter().getItemCount() - 1))
          {
            if (!LuckyMoneyDetailUI.this.usr.isProcessing()) {
              LuckyMoneyDetailUI.b(LuckyMoneyDetailUI.this);
            }
            if ((LuckyMoneyDetailUI.c(LuckyMoneyDetailUI.this)) && (!LuckyMoneyDetailUI.d(LuckyMoneyDetailUI.this))) {
              LuckyMoneyDetailUI.e(LuckyMoneyDetailUI.this);
            }
          }
        }
      }
    };
    this.uka = new com.tencent.mm.particles.b()
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
    this.uuk = false;
    this.pam = new c.a()
    {
      public final void a(final boolean paramAnonymousBoolean, final EmojiInfo paramAnonymousEmojiInfo)
      {
        AppMethodBeat.i(65541);
        ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(65540);
            if ((paramAnonymousEmojiInfo != null) && (LuckyMoneyDetailUI.n(LuckyMoneyDetailUI.this) != null) && (LuckyMoneyDetailUI.n(LuckyMoneyDetailUI.this).JC().equals(paramAnonymousEmojiInfo.JC())))
            {
              if (paramAnonymousBoolean)
              {
                ac.i("MicroMsg.LuckyMoneyDetailUI", "somethings success.");
                LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, k.getEmojiStorageMgr().GXZ.aOT(LuckyMoneyDetailUI.n(LuckyMoneyDetailUI.this).JC()));
                LuckyMoneyDetailUI.o(LuckyMoneyDetailUI.this).setVisibility(8);
                LuckyMoneyDetailUI.p(LuckyMoneyDetailUI.this).setVisibility(0);
                LuckyMoneyDetailUI.b(LuckyMoneyDetailUI.this, LuckyMoneyDetailUI.n(LuckyMoneyDetailUI.this));
                AppMethodBeat.o(65540);
                return;
              }
              ac.i("MicroMsg.LuckyMoneyDetailUI", "somethings error.");
              LuckyMoneyDetailUI.o(LuckyMoneyDetailUI.this).setVisibility(8);
              LuckyMoneyDetailUI.q(LuckyMoneyDetailUI.this).setVisibility(0);
            }
            AppMethodBeat.o(65540);
          }
        });
        AppMethodBeat.o(65541);
      }
    };
    this.uhd = false;
    this.uup = 0L;
    this.uuq = new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(163720);
        LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, new dd());
        if (bs.jl(paramAnonymousView.getId(), 2131301952))
        {
          LuckyMoneyDetailUI.w(LuckyMoneyDetailUI.this).dNx = 1L;
          LuckyMoneyDetailUI.w(LuckyMoneyDetailUI.this).aHZ();
        }
        if ((bs.jl(LuckyMoneyDetailUI.this.utV.uma, 0)) && (bs.I(paramAnonymousView.getTag(), "nodelete")))
        {
          LuckyMoneyDetailUI.B(LuckyMoneyDetailUI.this);
          AppMethodBeat.o(163720);
          return;
        }
        com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(LuckyMoneyDetailUI.this.getContext(), 1, false);
        locale.ISu = new n.c()
        {
          public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
          {
            AppMethodBeat.i(163718);
            String str = LuckyMoneyDetailUI.this.getString(2131760952);
            if (!bs.jl(LuckyMoneyDetailUI.this.utV.uma, 0)) {
              paramAnonymous2l.jw(1, 2131760908);
            }
            for (;;)
            {
              paramAnonymous2l.c(2, str);
              if (!bs.I(paramAnonymousView.getTag(), "nodelete")) {
                paramAnonymous2l.a(3, LuckyMoneyDetailUI.this.getResources().getColor(2131100596), LuckyMoneyDetailUI.this.getContext().getString(2131760844));
              }
              AppMethodBeat.o(163718);
              return;
              str = LuckyMoneyDetailUI.this.getString(2131760858);
            }
          }
        };
        locale.ISv = new n.d()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(163719);
            ac.i("MicroMsg.LuckyMoneyDetailUI", "showLuckyHbDlg() onMMMenuItemSelected menuItemId:%s", new Object[] { Integer.valueOf(paramAnonymous2MenuItem.getItemId()) });
            switch (paramAnonymous2MenuItem.getItemId())
            {
            }
            for (;;)
            {
              AppMethodBeat.o(163719);
              return;
              com.tencent.mm.plugin.emojicapture.api.b.b(LuckyMoneyDetailUI.this, 5, LuckyMoneyDetailUI.v(LuckyMoneyDetailUI.this));
              LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, new dd());
              LuckyMoneyDetailUI.w(LuckyMoneyDetailUI.this).dNx = 4L;
              LuckyMoneyDetailUI.w(LuckyMoneyDetailUI.this).aHZ();
              LuckyMoneyDetailUI.C(LuckyMoneyDetailUI.this);
              AppMethodBeat.o(163719);
              return;
              LuckyMoneyDetailUI.B(LuckyMoneyDetailUI.this);
              AppMethodBeat.o(163719);
              return;
              LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, null);
              LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, new dd());
              LuckyMoneyDetailUI.w(LuckyMoneyDetailUI.this).dNx = 8L;
              LuckyMoneyDetailUI.w(LuckyMoneyDetailUI.this).aHZ();
              LuckyMoneyDetailUI.b(LuckyMoneyDetailUI.this, 1);
            }
          }
        };
        LuckyMoneyDetailUI.w(LuckyMoneyDetailUI.this).dNx = 2L;
        LuckyMoneyDetailUI.w(LuckyMoneyDetailUI.this).aHZ();
        locale.cED();
        AppMethodBeat.o(163720);
      }
    };
    this.uur = 3;
    this.uus = new LuckyMoneyDetailUI.8(this);
    this.uut = 0;
    this.uuu = 0;
    this.uuv = 750;
    this.uuw = 240;
    AppMethodBeat.o(65556);
  }
  
  private void A(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(65570);
    this.uuu = 3;
    this.utA.setEmojiInfo(paramEmojiInfo);
    this.utW = new df();
    this.utW.dNx = 11L;
    this.utW.aHZ();
    AppMethodBeat.o(65570);
  }
  
  private static int HS(int paramInt)
  {
    if (paramInt == 2) {
      return 13;
    }
    return 7;
  }
  
  private void HU(int paramInt)
  {
    AppMethodBeat.i(65574);
    bq(paramInt, "");
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
      if (cZZ())
      {
        if (!bool) {}
        if (!cZZ()) {
          break label1819;
        }
        this.utz.setVisibility(0);
        nF(true);
        if ((!bs.jl(this.utV.ulZ, 0)) && (e(paraml)) && (this.uua)) {
          break label1831;
        }
        HU(0);
        if (paraml.ulI != 1) {
          break label1942;
        }
        bool = true;
        this.usC = bool;
        if (paraml != null)
        {
          if (((paraml.dBA != 3) && (paraml.dBA != 2)) || (paraml.ulH != 1) || (this.usC) || (paraml.ulK != 1)) {
            break label1948;
          }
          i = 1;
          if ((paraml.ulL == null) || (paraml.ulL.fFp != 1) || (bs.isNullOrNil(paraml.ulL.ulg))) {
            break label1953;
          }
          j = 1;
          this.utt = ((TextView)this.pfa.findViewById(2131301772));
          if ((i == 0) && (j == 0)) {
            break label1958;
          }
          this.utt.setOnClickListener(new LuckyMoneyDetailUI.18(this, paraml));
          if (j != 0)
          {
            this.usG = paraml.ulL.ulg;
            this.utt.setText(paraml.ulL.ulh);
          }
          com.tencent.mm.plugin.report.service.h.wUl.f(11701, new Object[] { Integer.valueOf(HS(paraml.ulQ)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2) });
          this.utt.setVisibility(0);
          this.ulQ = paraml.ulQ;
          this.utu = ((TextView)this.pfa.findViewById(2131301769));
          this.utu.setVisibility(8);
          if (!this.usL)
          {
            this.uul.g(this.pfa, 3, false);
            this.usL = true;
          }
        }
        if (this.MW == 0)
        {
          this.usE = paraml.ulF;
          localObject1 = this.usE;
          if ((paraml == null) || (paraml.dBz != 0) || (paraml.ulR == null) || (paraml.ulR.size() <= 0) || (!((y)paraml.ulR.get(0)).ulF.equals(localObject1)) || (paraml.ulG == 1)) {
            break label1970;
          }
          i = 1;
          if (i == 0) {
            break label1975;
          }
          this.uhd = false;
          this.utp.setVisibility(8);
          this.uhe = paraml.ulQ;
          if (paraml != null)
          {
            localObject2 = getContext();
            if (paraml.ulQ != 2) {
              break label2046;
            }
            this.uhq.setImageResource(2131232967);
            if (paraml.resourceId == 0) {
              break label2028;
            }
            ac.i("MicroMsg.LuckyMoneyDetailUI", "busi logo load from file:" + paraml.resourceId);
            localObject1 = new is();
            ((is)localObject1).djX.djZ = paraml.resourceId;
            ((is)localObject1).callback = new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(163726);
                if (this.usN.djY.dka)
                {
                  ac.i("MicroMsg.LuckyMoneyDetailUI", "Get res Ok, path=" + this.usN.djY.dkb);
                  LuckyMoneyDetailUI.this.getContext();
                  z.p(LuckyMoneyDetailUI.K(LuckyMoneyDetailUI.this), this.usN.djY.dkb);
                  AppMethodBeat.o(163726);
                  return;
                }
                ac.i("MicroMsg.LuckyMoneyDetailUI", "Get res fail & load from url.");
                z.b(LuckyMoneyDetailUI.K(LuckyMoneyDetailUI.this), paraml.ulz, paraml.ulT);
                AppMethodBeat.o(163726);
              }
            };
            com.tencent.mm.sdk.b.a.GpY.a((com.tencent.mm.sdk.b.b)localObject1, Looper.myLooper());
            label600:
            if (!w.wC(this.fzK)) {
              break label2087;
            }
            localObject1 = paraml.uly;
            label616:
            i = ((WindowManager)getSystemService("window")).getDefaultDisplay().getWidth();
            j = BackwardSupportUtil.b.g(getContext(), 92.0F);
            this.uhr.setMaxWidth(i - j);
            z.a((Context)localObject2, this.uhr, (String)localObject1);
            z.a((Context)localObject2, this.tEq, paraml.ugH);
            if (bs.isNullOrNil(paraml.ugH)) {
              break label2110;
            }
            this.tEq.setVisibility(0);
            label698:
            if (paraml.dBz != 1) {
              break label2122;
            }
            this.uhs.setVisibility(0);
            this.uhs.setImageResource(2131690761);
            label724:
            if (bs.isNullOrNil(paraml.ulP)) {
              break label2200;
            }
            ac.i("MicroMsg.LuckyMoneyDetailUI", "hy: has url : %s", new Object[] { paraml.ulP });
            this.utw.setVisibility(4);
            z.l(this.pHG, paraml.ulP);
            ap.n(new Runnable()
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
            if ((paraml.dBB != 2) || (this.usD == 3)) {
              break label2221;
            }
            this.uhh.setText(com.tencent.mm.wallet_core.ui.e.C(paraml.dBN / 100.0D));
            this.uht.setVisibility(0);
            label830:
            if (bs.isNullOrNil(paraml.uiO)) {
              break label2333;
            }
            this.uhu.setVisibility(0);
            this.lLe.setText(paraml.uiO);
            if (!w.wC(this.fzK)) {
              break label2233;
            }
            this.utm.setVisibility(8);
            this.aew.findViewById(2131301786).setVisibility(8);
            label893:
            if (bs.isNullOrNil(paraml.ulJ)) {
              break label2354;
            }
            this.lgw.setText(paraml.ulJ);
            this.utp.setVisibility(0);
            if ((g(paraml)) && (!e(paraml)))
            {
              this.utq.setVisibility(8);
              this.utr.setVisibility(8);
              this.uts.setVisibility(8);
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
        localObject1 = paraml.ulM;
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          localObject2 = this.aew.findViewById(2131301765);
          localObject3 = this.aew.findViewById(2131301766);
          View localView1 = this.aew.findViewById(2131301767);
          ViewGroup localViewGroup1 = (ViewGroup)this.aew.findViewById(2131301762);
          ViewGroup localViewGroup2 = (ViewGroup)this.aew.findViewById(2131301763);
          ViewGroup localViewGroup3 = (ViewGroup)this.aew.findViewById(2131301764);
          View localView2 = this.aew.findViewById(2131301753);
          View localView3 = this.aew.findViewById(2131301754);
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
            this.usA.requestLayout();
            this.usA.setVisibility(0);
          }
        }
        this.utv = ((ViewGroup)this.pfa.findViewById(2131301756));
        localObject1 = new h.c();
        ((h.c)localObject1).textColor = getResources().getColor(2131099819);
        ((h.c)localObject1).textSize = getResources().getDimensionPixelSize(2131165466);
        h.a(this, this.utv, paraml.ulN, (h.c)localObject1);
        localObject1 = new h.c();
        ((h.c)localObject1).textColor = getResources().getColor(2131099769);
        ((h.c)localObject1).textSize = getResources().getDimensionPixelSize(2131165466);
        if ((paraml.ulW != null) && (!w.wC(this.fzK)))
        {
          localObject2 = av.akk(paraml.ulW);
          if ((localObject2 != null) && (((av)localObject2).uok != null))
          {
            ((h.c)localObject1).uwO = ((av)localObject2).ulc;
            if (((h.c)localObject1).uwO == null)
            {
              ((h.c)localObject1).uwO = new bjm();
              ((h.c)localObject1).uwO.EYC = this.uub;
            }
            h.a(this, this.utv, ((av)localObject2).uok, (h.c)localObject1);
            localObject1 = "";
            if (((av)localObject2).ulc != null) {
              localObject1 = ((av)localObject2).ulc.Etc;
            }
            com.tencent.mm.plugin.report.service.h.wUl.f(16589, new Object[] { Integer.valueOf(1), ((av)localObject2).uok.content, this.uub, localObject1, Integer.valueOf(0), com.tencent.mm.plugin.luckymoney.a.c.openId });
          }
        }
      }
      com.tencent.mm.plugin.report.service.h.wUl.f(11701, new Object[] { Integer.valueOf(HS(paraml.ulQ)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
      localObject1 = paraml.ulR;
      if (localObject1 == null) {
        break label2405;
      }
      i = 0;
      while (i < ((List)localObject1).size())
      {
        localObject2 = (y)((List)localObject1).get(i);
        if (!this.usI.containsKey(((y)localObject2).ulF))
        {
          this.uhb.add(((List)localObject1).get(i));
          localObject3 = new a();
          ((a)localObject3).uuG = ((y)((List)localObject1).get(i));
          this.utP.add(localObject3);
          this.usI.put(((y)localObject2).ulF, Integer.valueOf(1));
        }
        i += 1;
      }
      if (bool) {
        break;
      }
      break;
      if (bool)
      {
        if (cZZ()) {
          break;
        }
        break;
      }
      cZZ();
      break;
      label1819:
      this.utz.setVisibility(8);
      break label63;
      label1831:
      this.utF.setOnClickListener(this.uuq);
      this.utF.setTag("nodelete");
      this.utJ.setOnClickListener(this.uuq);
      this.utM.setOnClickListener(this.uuq);
      this.utI.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(163715);
          LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, new dd());
          LuckyMoneyDetailUI.w(LuckyMoneyDetailUI.this).dNx = 7L;
          LuckyMoneyDetailUI.w(LuckyMoneyDetailUI.this).aHZ();
          LuckyMoneyDetailUI.A(LuckyMoneyDetailUI.this);
          AppMethodBeat.o(163715);
        }
      });
      this.utH.setOnClickListener(this.uuq);
      localObject1 = (String)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GLi, "");
      HU(1);
      if (bs.isNullOrNil((String)localObject1)) {
        break label97;
      }
      bq(2, (String)localObject1);
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
      this.utt.setVisibility(8);
      break label324;
      label1970:
      i = 0;
      break label465;
      label1975:
      this.utp.setVisibility(0);
      if ((!g(paraml)) || (e(paraml))) {
        break label483;
      }
      this.utq.setVisibility(8);
      this.utr.setVisibility(8);
      this.uts.setVisibility(8);
      break label483;
      label2028:
      z.b(this.uhq, paraml.ulz, paraml.ulT);
      break label600;
      label2046:
      if (w.wC(this.fzK))
      {
        this.uhq.setImageResource(2131233442);
        break label600;
      }
      z.b(this.uhq, paraml.ulz, paraml.ulT);
      break label600;
      label2087:
      localObject1 = getString(2131760982, new Object[] { paraml.uly });
      break label616;
      label2110:
      this.tEq.setVisibility(8);
      break label698;
      label2122:
      if (paraml.dBz == 2)
      {
        if (!w.wG(paraml.ulT))
        {
          localObject1 = new com.tencent.mm.aj.i();
          ((com.tencent.mm.aj.i)localObject1).username = paraml.ulT;
          com.tencent.mm.aj.p.aBw().b((com.tencent.mm.aj.i)localObject1);
        }
        this.uhs.setVisibility(0);
        this.uhs.setImageResource(2131690760);
        break label724;
      }
      this.uhs.setVisibility(8);
      break label724;
      label2200:
      ac.i("MicroMsg.LuckyMoneyDetailUI", "hy: no bg. set bg area to gone");
      this.utw.setVisibility(8);
      break label787;
      label2221:
      this.uht.setVisibility(8);
      break label830;
      label2233:
      if (paraml.uiM == 1)
      {
        ac.i("MicroMsg.LuckyMoneyDetailUI", "changeIconUrl: %s", new Object[] { paraml.ulV });
        if (!bs.isNullOrNil(paraml.ulV))
        {
          this.utm.setUrl(paraml.ulV);
          this.utm.setVisibility(0);
        }
        for (;;)
        {
          this.lLe.setOnClickListener(new LuckyMoneyDetailUI.15(this, paraml));
          break;
          this.utm.setVisibility(8);
        }
      }
      ac.e("MicroMsg.LuckyMoneyDetailUI", "detail.jumpChange is false");
      break label893;
      label2333:
      ac.e("MicroMsg.LuckyMoneyDetailUI", "detail.changeWording is empty");
      this.uhu.setVisibility(8);
      break label893;
      label2354:
      this.lgw.setText(null);
      this.utp.setVisibility(8);
    }
    this.MW += ((List)localObject1).size();
    this.kOL = false;
    this.uul.arg.notifyChanged();
    label2405:
    if ((paraml.dBz == 2) && (!bs.isNullOrNil(paraml.ulx)))
    {
      this.uiw = new SoundPool(2, 3, 0);
      this.utx = new int[2];
    }
    try
    {
      this.utx[0] = this.uiw.load(getResources().getAssets().openFd("most_lucky.m4a"), 0);
      this.utx[1] = this.uiw.load(getResources().getAssets().openFd("whistle.m4a"), 0);
      this.uiw.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener()
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
            if ((paramAnonymousInt1 == LuckyMoneyDetailUI.H(LuckyMoneyDetailUI.this)[1]) && (paraml.dBN >= 19000L)) {
              paramAnonymousSoundPool.play(paramAnonymousInt1, 1.0F, 1.0F, 0, 0, 1.0F);
            }
          }
          AppMethodBeat.o(163724);
        }
      });
      this.aew.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(163725);
          LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, (ViewGroup)LuckyMoneyDetailUI.this.findViewById(2131301813));
          Object localObject = LuckyMoneyDetailUI.I(LuckyMoneyDetailUI.this);
          com.tencent.mm.particles.b localb = LuckyMoneyDetailUI.J(LuckyMoneyDetailUI.this);
          com.tencent.mm.particles.a locala = new com.tencent.mm.particles.a((ViewGroup)localObject);
          localObject = new com.tencent.mm.particles.c(((ViewGroup)localObject).getContext(), localb, new com.tencent.mm.particles.d(-100, ((ViewGroup)localObject).getHeight() / 2), (ViewGroup)localObject).B(600.0F, 150.0F).C(-1000.0F, 250.0F).am(-200.0F).an(1500.0F);
          ((com.tencent.mm.particles.c)localObject).ipR = 600.0F;
          ((com.tencent.mm.particles.c)localObject).ipS = 300.0F;
          localObject = ((com.tencent.mm.particles.c)localObject).aMr();
          ((com.tencent.mm.particles.c)localObject).ipu = com.tencent.mm.particles.e.aMz();
          locala.gBR = ((com.tencent.mm.particles.c)localObject).aMs().aMt();
          locala.C(100, 400L);
          localObject = LuckyMoneyDetailUI.I(LuckyMoneyDetailUI.this);
          localb = LuckyMoneyDetailUI.J(LuckyMoneyDetailUI.this);
          locala = new com.tencent.mm.particles.a((ViewGroup)localObject);
          localObject = new com.tencent.mm.particles.c(((ViewGroup)localObject).getContext(), localb, new com.tencent.mm.particles.d(((ViewGroup)localObject).getWidth() + 100, ((ViewGroup)localObject).getHeight() / 2), (ViewGroup)localObject).B(-600.0F, 150.0F).C(-1000.0F, 250.0F).am(200.0F).an(1500.0F);
          ((com.tencent.mm.particles.c)localObject).ipR = 600.0F;
          ((com.tencent.mm.particles.c)localObject).ipS = 300.0F;
          localObject = ((com.tencent.mm.particles.c)localObject).aMr();
          ((com.tencent.mm.particles.c)localObject).ipu = com.tencent.mm.particles.e.aMz();
          locala.gBR = ((com.tencent.mm.particles.c)localObject).aMs().aMt();
          locala.C(100, 400L);
          AppMethodBeat.o(163725);
        }
      }, 300L);
      if (!w.wC(this.fzK))
      {
        localObject1 = new ad();
        ((ad)localObject1).field_mNativeUrl = this.usF;
        ((ad)localObject1).field_hbType = paraml.dBz;
        ((ad)localObject1).field_receiveAmount = paraml.dBN;
        ((ad)localObject1).field_receiveTime = System.currentTimeMillis();
        ((ad)localObject1).field_hbStatus = paraml.dBA;
        ((ad)localObject1).field_receiveStatus = paraml.dBB;
        if (((ad)localObject1).field_receiveAmount > 0L) {
          com.tencent.mm.plugin.wallet_core.model.s.eru().a((ad)localObject1);
        }
      }
      daa();
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
        ac.e("MicroMsg.LuckyMoneyDetailUI", "load lucky money voice fail " + localIOException.getMessage());
      }
    }
  }
  
  private void b(cng paramcng)
  {
    AppMethodBeat.i(163739);
    f(this.uuo);
    this.utO.a(paramcng, this.uun, this.uub, this.oCe, w.wC(this.fzK));
    daa();
    AppMethodBeat.o(163739);
  }
  
  private void bq(int paramInt, String paramString)
  {
    AppMethodBeat.i(65575);
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (w.wC(this.fzK)) {
        this.utE.setVisibility(8);
      }
      AppMethodBeat.o(65575);
      return;
      this.utE.setVisibility(8);
      continue;
      this.utE.setVisibility(0);
      this.utF.setVisibility(0);
      this.utG.setVisibility(8);
      com.tencent.mm.kernel.g.agR().agA().set(ah.a.GLi, "");
      continue;
      if (!bs.isNullOrNil(paramString))
      {
        paramString = k.getEmojiStorageMgr().GXZ.aOT(paramString);
        if (paramString == null)
        {
          ac.i("MicroMsg.LuckyMoneyDetailUI", "exchangeThxEmojiState() temp == null");
          AppMethodBeat.o(65575);
          return;
        }
        this.utT = paramString;
        com.tencent.mm.kernel.g.agR().agA().set(ah.a.GLi, this.utT.JC());
        this.utH.setEmojiInfo(this.utT);
        this.utE.setVisibility(0);
        this.utF.setVisibility(8);
        this.utG.setVisibility(0);
      }
    }
  }
  
  private void cZY()
  {
    AppMethodBeat.i(65563);
    ((com.tencent.mm.pluginsdk.i)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.i.class)).a(this, this.fzK, this.utT.JC(), getString(2131760956), new y.a()
    {
      public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(163714);
        LuckyMoneyDetailUI.this.hideVKB();
        LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, new dd());
        if (paramAnonymousBoolean)
        {
          LuckyMoneyDetailUI.w(LuckyMoneyDetailUI.this).dNx = 5L;
          LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, new de());
          paramAnonymousInt = 0;
          if ((LuckyMoneyDetailUI.x(LuckyMoneyDetailUI.this) == 0) || (LuckyMoneyDetailUI.x(LuckyMoneyDetailUI.this) == 2)) {
            if (com.tencent.mm.plugin.emoji.h.b.y(LuckyMoneyDetailUI.y(LuckyMoneyDetailUI.this)))
            {
              paramAnonymousInt = 1;
              LuckyMoneyDetailUI.z(LuckyMoneyDetailUI.this).dRL = paramAnonymousInt;
              de localde = LuckyMoneyDetailUI.z(LuckyMoneyDetailUI.this);
              localde.dRM = localde.t("emoticonMd5", LuckyMoneyDetailUI.y(LuckyMoneyDetailUI.this).JC(), true);
              if (!bs.isNullOrNil(paramAnonymousString)) {
                break label300;
              }
              LuckyMoneyDetailUI.z(LuckyMoneyDetailUI.this).dRN = 1L;
              label159:
              LuckyMoneyDetailUI.z(LuckyMoneyDetailUI.this).aHZ();
              LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, LuckyMoneyDetailUI.v(LuckyMoneyDetailUI.this), paramAnonymousString, LuckyMoneyDetailUI.y(LuckyMoneyDetailUI.this).JC());
              LuckyMoneyDetailUI.b(LuckyMoneyDetailUI.this, 3);
              com.tencent.mm.ui.base.s.a(LuckyMoneyDetailUI.this.getContext().getResources().getString(2131760233), LuckyMoneyDetailUI.this.getContext(), null);
              ap.n(new Runnable()
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
          LuckyMoneyDetailUI.w(LuckyMoneyDetailUI.this).aHZ();
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
          LuckyMoneyDetailUI.z(LuckyMoneyDetailUI.this).dRN = 2L;
          break label159;
          LuckyMoneyDetailUI.w(LuckyMoneyDetailUI.this).dNx = 6L;
        }
      }
    });
    AppMethodBeat.o(65563);
  }
  
  private boolean cZZ()
  {
    AppMethodBeat.i(65572);
    if ((!bs.isNullOrNil(this.pcm)) && ((bs.jl(this.utV.ulX, 1)) || (bs.jl(this.utV.ulY, 1))))
    {
      AppMethodBeat.o(65572);
      return true;
    }
    AppMethodBeat.o(65572);
    return false;
  }
  
  private void daa()
  {
    AppMethodBeat.i(163741);
    ac.d("MicroMsg.LuckyMoneyDetailUI", "adjust footer");
    this.pfa.post(new Runnable()
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
          ac.d("MicroMsg.LuckyMoneyDetailUI", "winHeight:%s diff:%s recordHeight:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(j) });
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
    return (paraml.dBB == 2) && (this.usD != 3);
  }
  
  private void f(com.tencent.mm.plugin.luckymoney.model.l paraml)
  {
    AppMethodBeat.i(163740);
    if (paraml.ulW != null)
    {
      paraml = av.akk(paraml.ulW);
      if ((bs.isNullOrNil(this.uun)) && (paraml != null) && (paraml.ulc != null)) {
        this.uun = paraml.ulc.Etc;
      }
      this.upW = getIntent().getStringExtra("key_detail_envelope_url");
      this.upX = getIntent().getStringExtra("key_detail_envelope_md5");
      if ((bs.isNullOrNil(this.upW)) && (paraml != null) && (paraml.ulc != null) && (paraml.ulc.EYD != null))
      {
        this.upW = paraml.ulc.EYD.EYU;
        this.upX = paraml.ulc.EYD.EYX;
      }
      if ((!bs.isNullOrNil(this.upW)) && (!bs.isNullOrNil(this.upX)))
      {
        this.utO.hz(this.upW, this.upX);
        if (!this.utQ)
        {
          this.utQ = true;
          com.tencent.mm.plugin.luckymoney.a.c.bn(3, this.upW);
        }
      }
    }
    AppMethodBeat.o(163740);
  }
  
  private static boolean g(com.tencent.mm.plugin.luckymoney.model.l paraml)
  {
    return paraml.ulH == 1;
  }
  
  private void nF(boolean paramBoolean)
  {
    AppMethodBeat.i(65569);
    ac.i("MicroMsg.LuckyMoneyDetailUI", "showEmoji() circle:%s", new Object[] { Boolean.TRUE });
    this.utB.setVisibility(8);
    this.uuu = 1;
    if (paramBoolean) {
      this.uur = 3;
    }
    do
    {
      this.peL = k.getEmojiStorageMgr().GXZ.aOT(this.pcm);
      if (this.peL == null) {
        break;
      }
      if ((com.tencent.mm.vfs.i.aSp(this.peL.ghd()) <= 0L) && (!this.peL.CC()) && (!this.peL.fxI())) {
        break label218;
      }
      this.utA.setVisibility(0);
      A(this.peL);
      AppMethodBeat.o(65569);
      return;
      this.uur -= 1;
    } while (this.uur != 0);
    ac.i("MicroMsg.LuckyMoneyDetailUI", "showEmoji() circle fail!");
    this.utC.setVisibility(8);
    this.utB.setVisibility(0);
    this.uuu = 2;
    AppMethodBeat.o(65569);
    return;
    this.peL = new EmojiInfo();
    this.peL.field_md5 = this.pcm;
    this.peL.field_type = this.utR;
    label218:
    if (paramBoolean)
    {
      this.utA.setVisibility(8);
      this.utC.setVisibility(0);
      k.ccl().pam = this.pam;
    }
    k.ccl().u(this.peL);
    com.tencent.mm.kernel.g.agQ().ghe.a(697, this.uus);
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
      boolean bool = localRealnameGuideHelper.b(this, localBundle, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(163721);
          ac.i("MicroMsg.LuckyMoneyDetailUI", "RealnameGuideHelper dialog click cancel");
          LuckyMoneyDetailUI.D(LuckyMoneyDetailUI.this);
          AppMethodBeat.o(163721);
        }
      });
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
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(65551);
        LuckyMoneyDetailUI.this.finish();
        AppMethodBeat.o(65551);
        return true;
      }
    }, 2131232693);
    this.utl = ((RecyclerView)findViewById(2131301770));
    RecyclerView localRecyclerView = this.utl;
    getContext();
    localRecyclerView.setLayoutManager(new LinearLayoutManager(1));
    this.aew = LayoutInflater.from(this).inflate(2131494635, this.utl, false);
    this.pfa = LayoutInflater.from(this).inflate(2131494633, this.utl, false);
    this.uul = new WxRecyclerAdapter(new com.tencent.mm.view.recyclerview.c()
    {
      public final com.tencent.mm.view.recyclerview.b<?> Ac(int paramAnonymousInt)
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
    }, this.utP, false);
    this.uul.f(this.aew, 1, false);
    this.utl.setAdapter(this.uul);
    this.utl.a(this.alB);
    this.uhq = ((ImageView)this.aew.findViewById(2131301774));
    this.uhr = ((TextView)this.aew.findViewById(2131301789));
    this.utN = this.aew.findViewById(2131301787);
    this.uhs = ((ImageView)this.aew.findViewById(2131301757));
    this.tEq = ((TextView)this.aew.findViewById(2131301792));
    this.utz = ((RelativeLayout)this.aew.findViewById(2131301797));
    this.utA = ((BaseEmojiView)this.aew.findViewById(2131301793));
    this.utB = ((TextView)this.aew.findViewById(2131301941));
    this.utC = ((LinearLayout)this.aew.findViewById(2131301835));
    this.utD = ((ProgressBar)this.aew.findViewById(2131299385));
    this.uht = this.aew.findViewById(2131301742);
    this.uhh = ((TextView)this.aew.findViewById(2131301741));
    this.uhu = this.aew.findViewById(2131301759);
    this.lLe = ((TextView)this.aew.findViewById(2131301785));
    this.utm = ((CdnImageView)this.aew.findViewById(2131301758));
    this.lgw = ((TextView)this.aew.findViewById(2131301748));
    this.usA = this.aew.findViewById(2131301768);
    this.utn = this.aew.findViewById(2131301746);
    this.uto = ((ImageView)this.aew.findViewById(2131301745));
    this.utE = ((LinearLayout)this.aew.findViewById(2131301948));
    this.utF = ((LinearLayout)this.aew.findViewById(2131301952));
    this.utG = ((LinearLayout)this.aew.findViewById(2131301955));
    this.utH = ((BaseEmojiView)this.aew.findViewById(2131301949));
    this.utI = ((RelativeLayout)this.aew.findViewById(2131301954));
    this.utJ = ((ImageView)this.aew.findViewById(2131301950));
    this.utp = ((ViewGroup)this.aew.findViewById(2131301750));
    this.utq = this.aew.findViewById(2131301749);
    this.utr = this.aew.findViewById(2131301751);
    this.uts = this.aew.findViewById(2131301752);
    this.utw = ((RelativeLayout)this.aew.findViewById(2131301746));
    this.pHG = ((ImageView)this.aew.findViewById(2131301745));
    this.utM = ((ImageView)this.aew.findViewById(2131301957));
    this.uty = ((ViewGroup)findViewById(2131301813));
    this.utB.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(163735);
        LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, true);
        AppMethodBeat.o(163735);
      }
    });
    this.utK = new a(this);
    this.utL = getLayoutInflater().inflate(2131494640, null);
    this.utK.setContentView(this.utL, new ViewGroup.LayoutParams(-1, -1));
    this.utL.findViewById(2131301796).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(65547);
        LuckyMoneyDetailUI.s(LuckyMoneyDetailUI.this);
        AppMethodBeat.o(65547);
      }
    });
    this.utK.urJ = new a.a()
    {
      public final void cZN()
      {
        AppMethodBeat.i(163736);
        LuckyMoneyDetailUI.s(LuckyMoneyDetailUI.this);
        AppMethodBeat.o(163736);
      }
    };
    this.utU = ((ViewGroup)this.utL.findViewById(2131301798));
    if (com.tencent.mm.pluginsdk.ui.chat.e.DyA == null)
    {
      ac.w("MicroMsg.LuckyMoneyDetailUI", "can't show correctly");
      finish();
      AppMethodBeat.o(65561);
      return;
    }
    this.utS = com.tencent.mm.pluginsdk.ui.chat.e.DyA.eA(getContext());
    this.utS.setTalkerName(this.fzK);
    this.utS.setShowSmiley(false);
    this.utm.setUseSdcardCache(true);
    this.utA.setOnClickListener(new LuckyMoneyDetailUI.2(this));
    this.utO = ((EnvelopeAppBarLayout)findViewById(2131301805));
    this.utO.setActivityLifeCycle(this);
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
        if (!bs.isNullOrNil(str)) {
          if ((this.usG != null) && (this.usG.startsWith("wxpay://c2cbizmessagehandler/hongbao/festivalhongbao")))
          {
            ac.i("MicroMsg.LuckyMoneyDetailUI", "Not expected branch since 2015 fesitval");
          }
          else
          {
            doSceneProgress(new at(str.replaceAll(",", "|"), this.ust, "v1.0"));
            continue;
            if (paramInt2 == -1)
            {
              str = "";
              if (paramIntent != null) {
                str = paramIntent.getStringExtra("gif_md5");
              }
              if (!bs.isNullOrNil(str))
              {
                bq(2, str);
                cZY();
              }
              else
              {
                ac.i("MicroMsg.LuckyMoneyDetailUI", "md5 == null go emoji capture failed!");
              }
            }
            else
            {
              ac.i("MicroMsg.LuckyMoneyDetailUI", "go emoji capture failed!");
              continue;
              com.tencent.mm.plugin.luckymoney.a.d.tn(8);
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
    //   0: iconst_1
    //   1: istore_3
    //   2: ldc_w 2019
    //   5: invokestatic 217	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: invokestatic 2024	com/tencent/mm/pluginsdk/g:o	(Lcom/tencent/mm/ui/MMActivity;)V
    //   12: aload_0
    //   13: iconst_1
    //   14: invokevirtual 2027	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:customfixStatusbar	(Z)V
    //   17: aload_0
    //   18: iconst_0
    //   19: putfield 2030	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:uss	Z
    //   22: aload_0
    //   23: invokevirtual 1657	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   26: ldc_w 2032
    //   29: iconst_0
    //   30: invokevirtual 2036	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   33: ifne +13 -> 46
    //   36: aload_0
    //   37: ldc_w 2037
    //   40: ldc_w 2038
    //   43: invokevirtual 1825	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:overridePendingTransition	(II)V
    //   46: aload_0
    //   47: aload_1
    //   48: invokespecial 2040	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBaseUI:onCreate	(Landroid/os/Bundle;)V
    //   51: aload_0
    //   52: invokevirtual 2044	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getWindow	()Landroid/view/Window;
    //   55: invokevirtual 2049	android/view/Window:getDecorView	()Landroid/view/View;
    //   58: sipush 1280
    //   61: invokevirtual 2052	android/view/View:setSystemUiVisibility	(I)V
    //   64: aload_0
    //   65: invokevirtual 2044	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getWindow	()Landroid/view/Window;
    //   68: ldc_w 2053
    //   71: invokevirtual 2056	android/view/Window:setBackgroundDrawableResource	(I)V
    //   74: aload_0
    //   75: aload_0
    //   76: invokevirtual 1657	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   79: ldc_w 2058
    //   82: invokevirtual 1662	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   85: putfield 931	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:uub	Ljava/lang/String;
    //   88: aload_0
    //   89: aload_0
    //   90: invokevirtual 1657	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   93: ldc_w 2060
    //   96: iconst_0
    //   97: invokevirtual 2064	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   100: putfield 1534	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:oCe	I
    //   103: aload_0
    //   104: invokevirtual 2068	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getController	()Lcom/tencent/mm/ui/s;
    //   107: iconst_0
    //   108: putfield 2073	com/tencent/mm/ui/s:HnM	Z
    //   111: aload_0
    //   112: aload_0
    //   113: invokevirtual 421	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getResources	()Landroid/content/res/Resources;
    //   116: ldc_w 2074
    //   119: invokevirtual 874	android/content/res/Resources:getColor	(I)I
    //   122: invokevirtual 2077	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:setActionbarColor	(I)V
    //   125: aload_0
    //   126: invokevirtual 2080	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:hideActionbarLine	()V
    //   129: aload_0
    //   130: aload_0
    //   131: invokevirtual 1657	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   134: ldc_w 2082
    //   137: iconst_0
    //   138: invokevirtual 2036	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   141: putfield 252	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:uua	Z
    //   144: aload_0
    //   145: aload_0
    //   146: invokevirtual 1657	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   149: ldc_w 2084
    //   152: invokevirtual 1662	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   155: putfield 737	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:fzK	Ljava/lang/String;
    //   158: aload_0
    //   159: aload_0
    //   160: invokevirtual 1657	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   163: ldc_w 2086
    //   166: invokevirtual 1662	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   169: putfield 1630	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:ust	Ljava/lang/String;
    //   172: aload_0
    //   173: aload_0
    //   174: invokevirtual 1657	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   177: ldc_w 2088
    //   180: invokevirtual 1662	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   183: putfield 1123	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:usF	Ljava/lang/String;
    //   186: aload_0
    //   187: aload_0
    //   188: invokevirtual 1657	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   191: ldc_w 2090
    //   194: iconst_2
    //   195: invokevirtual 2064	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   198: putfield 812	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:usD	I
    //   201: aload_0
    //   202: aload_0
    //   203: invokevirtual 1657	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   206: ldc_w 2092
    //   209: invokevirtual 1662	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   212: putfield 244	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:usK	Ljava/lang/String;
    //   215: aload_0
    //   216: aload_0
    //   217: invokevirtual 1657	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   220: ldc_w 2094
    //   223: lconst_0
    //   224: invokevirtual 2097	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   227: putfield 1774	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:foF	J
    //   230: aload_0
    //   231: aload_0
    //   232: invokevirtual 1657	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   235: ldc_w 2099
    //   238: invokevirtual 1662	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   241: putfield 1532	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:uun	Ljava/lang/String;
    //   244: aload_0
    //   245: aload_0
    //   246: invokevirtual 1657	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   249: ldc_w 1659
    //   252: invokevirtual 1662	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   255: putfield 1664	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:upW	Ljava/lang/String;
    //   258: aload_0
    //   259: aload_0
    //   260: invokevirtual 1657	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   263: ldc_w 1666
    //   266: invokevirtual 1662	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   269: putfield 1668	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:upX	Ljava/lang/String;
    //   272: ldc_w 436
    //   275: new 685	java/lang/StringBuilder
    //   278: dup
    //   279: ldc_w 2101
    //   282: invokespecial 690	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   285: aload_0
    //   286: getfield 1630	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:ust	Ljava/lang/String;
    //   289: invokestatic 2104	com/tencent/mm/sdk/platformtools/bs:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   292: invokevirtual 1177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: ldc_w 2106
    //   298: invokevirtual 1177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: aload_0
    //   302: getfield 1123	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:usF	Ljava/lang/String;
    //   305: invokestatic 2104	com/tencent/mm/sdk/platformtools/bs:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   308: invokevirtual 1177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: ldc_w 2108
    //   314: invokevirtual 1177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: aload_0
    //   318: getfield 812	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:usD	I
    //   321: invokevirtual 694	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   324: ldc_w 2110
    //   327: invokevirtual 1177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: aload_0
    //   331: getfield 1532	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:uun	Ljava/lang/String;
    //   334: invokevirtual 1177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: invokevirtual 698	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   340: invokestatic 701	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   343: aload_0
    //   344: getfield 1630	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:ust	Ljava/lang/String;
    //   347: invokestatic 586	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
    //   350: ifeq +32 -> 382
    //   353: aload_0
    //   354: getfield 1123	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:usF	Ljava/lang/String;
    //   357: invokestatic 586	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
    //   360: ifne +22 -> 382
    //   363: aload_0
    //   364: getfield 1123	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:usF	Ljava/lang/String;
    //   367: invokestatic 2116	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   370: astore_1
    //   371: aload_0
    //   372: aload_1
    //   373: ldc_w 2118
    //   376: invokevirtual 2121	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   379: putfield 1630	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:ust	Ljava/lang/String;
    //   382: aload_0
    //   383: aload_0
    //   384: invokevirtual 1657	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   387: ldc_w 2123
    //   390: invokevirtual 1662	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   393: putfield 1597	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:pcm	Ljava/lang/String;
    //   396: aload_0
    //   397: aload_0
    //   398: invokevirtual 1657	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   401: ldc_w 2125
    //   404: iconst_0
    //   405: invokevirtual 2064	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   408: putfield 1730	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:utR	I
    //   411: aload_0
    //   412: getfield 1597	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:pcm	Ljava/lang/String;
    //   415: invokestatic 586	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
    //   418: ifne +32 -> 450
    //   421: aload_0
    //   422: new 307	com/tencent/mm/g/b/a/df
    //   425: dup
    //   426: invokespecial 308	com/tencent/mm/g/b/a/df:<init>	()V
    //   429: putfield 310	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:utW	Lcom/tencent/mm/g/b/a/df;
    //   432: aload_0
    //   433: getfield 310	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:utW	Lcom/tencent/mm/g/b/a/df;
    //   436: ldc2_w 2126
    //   439: putfield 315	com/tencent/mm/g/b/a/df:dNx	J
    //   442: aload_0
    //   443: getfield 310	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:utW	Lcom/tencent/mm/g/b/a/df;
    //   446: invokevirtual 319	com/tencent/mm/g/b/a/df:aHZ	()Z
    //   449: pop
    //   450: aload_0
    //   451: aload_0
    //   452: invokevirtual 1657	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   455: ldc_w 2129
    //   458: invokevirtual 1797	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   461: checkcast 341	com/tencent/mm/plugin/luckymoney/model/LuckyMoneyEmojiSwitch
    //   464: putfield 339	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:utV	Lcom/tencent/mm/plugin/luckymoney/model/LuckyMoneyEmojiSwitch;
    //   467: aload_0
    //   468: getfield 339	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:utV	Lcom/tencent/mm/plugin/luckymoney/model/LuckyMoneyEmojiSwitch;
    //   471: ifnonnull +14 -> 485
    //   474: aload_0
    //   475: new 341	com/tencent/mm/plugin/luckymoney/model/LuckyMoneyEmojiSwitch
    //   478: dup
    //   479: invokespecial 2130	com/tencent/mm/plugin/luckymoney/model/LuckyMoneyEmojiSwitch:<init>	()V
    //   482: putfield 339	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:utV	Lcom/tencent/mm/plugin/luckymoney/model/LuckyMoneyEmojiSwitch;
    //   485: aload_0
    //   486: getfield 1630	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:ust	Ljava/lang/String;
    //   489: invokestatic 2136	com/tencent/mm/plugin/luckymoney/a/b:akc	(Ljava/lang/String;)Lcom/tencent/mm/plugin/luckymoney/model/l;
    //   492: astore_1
    //   493: aload_1
    //   494: ifnull +73 -> 567
    //   497: aload_0
    //   498: aload_1
    //   499: putfield 1526	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:uuo	Lcom/tencent/mm/plugin/luckymoney/model/l;
    //   502: aload_0
    //   503: invokevirtual 2138	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:initView	()V
    //   506: aload_0
    //   507: getfield 1526	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:uuo	Lcom/tencent/mm/plugin/luckymoney/model/l;
    //   510: ifnonnull +134 -> 644
    //   513: ldc_w 436
    //   516: ldc_w 2140
    //   519: invokestatic 1956	com/tencent/mm/sdk/platformtools/ac:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   522: aload_0
    //   523: invokevirtual 1957	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:finish	()V
    //   526: ldc_w 2019
    //   529: invokestatic 290	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   532: return
    //   533: astore_1
    //   534: ldc_w 436
    //   537: aload_1
    //   538: ldc 242
    //   540: iconst_0
    //   541: anewarray 440	java/lang/Object
    //   544: invokestatic 1328	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   547: invokestatic 2145	com/tencent/mm/sdk/platformtools/ai:getContext	()Landroid/content/Context;
    //   550: ldc_w 2147
    //   553: iconst_0
    //   554: invokestatic 2153	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   557: invokevirtual 2154	android/widget/Toast:show	()V
    //   560: ldc_w 2019
    //   563: invokestatic 290	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   566: return
    //   567: aload_0
    //   568: invokevirtual 1657	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   571: ldc_w 2156
    //   574: invokevirtual 2160	android/content/Intent:getByteArrayExtra	(Ljava/lang/String;)[B
    //   577: astore_1
    //   578: aload_1
    //   579: ifnull +58 -> 637
    //   582: aload_0
    //   583: new 558	com/tencent/mm/plugin/luckymoney/model/l
    //   586: dup
    //   587: invokespecial 2161	com/tencent/mm/plugin/luckymoney/model/l:<init>	()V
    //   590: aload_1
    //   591: invokevirtual 2165	com/tencent/mm/plugin/luckymoney/model/l:parseFrom	([B)Lcom/tencent/mm/bw/a;
    //   594: checkcast 558	com/tencent/mm/plugin/luckymoney/model/l
    //   597: putfield 1526	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:uuo	Lcom/tencent/mm/plugin/luckymoney/model/l;
    //   600: goto -98 -> 502
    //   603: astore_1
    //   604: ldc_w 436
    //   607: new 685	java/lang/StringBuilder
    //   610: dup
    //   611: ldc_w 2167
    //   614: invokespecial 690	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   617: aload_1
    //   618: invokevirtual 2170	java/lang/Exception:getLocalizedMessage	()Ljava/lang/String;
    //   621: invokevirtual 1177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   624: invokevirtual 698	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   627: invokestatic 1956	com/tencent/mm/sdk/platformtools/ac:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   630: aload_0
    //   631: invokevirtual 1957	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:finish	()V
    //   634: goto -132 -> 502
    //   637: aload_0
    //   638: invokevirtual 1957	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:finish	()V
    //   641: goto -139 -> 502
    //   644: aload_0
    //   645: getfield 1526	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:uuo	Lcom/tencent/mm/plugin/luckymoney/model/l;
    //   648: ifnull +67 -> 715
    //   651: aload_0
    //   652: getfield 1526	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:uuo	Lcom/tencent/mm/plugin/luckymoney/model/l;
    //   655: getfield 910	com/tencent/mm/plugin/luckymoney/model/l:ulW	Ljava/lang/String;
    //   658: invokestatic 916	com/tencent/mm/plugin/luckymoney/model/av:akk	(Ljava/lang/String;)Lcom/tencent/mm/plugin/luckymoney/model/av;
    //   661: astore_1
    //   662: aload_1
    //   663: ifnull +52 -> 715
    //   666: aload_1
    //   667: getfield 923	com/tencent/mm/plugin/luckymoney/model/av:ulc	Lcom/tencent/mm/protocal/protobuf/bjm;
    //   670: ifnull +45 -> 715
    //   673: aload_0
    //   674: getfield 1532	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:uun	Ljava/lang/String;
    //   677: invokestatic 586	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
    //   680: ifeq +14 -> 694
    //   683: aload_0
    //   684: aload_1
    //   685: getfield 923	com/tencent/mm/plugin/luckymoney/model/av:ulc	Lcom/tencent/mm/protocal/protobuf/bjm;
    //   688: getfield 937	com/tencent/mm/protocal/protobuf/bjm:Etc	Ljava/lang/String;
    //   691: putfield 1532	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:uun	Ljava/lang/String;
    //   694: aload_0
    //   695: getfield 931	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:uub	Ljava/lang/String;
    //   698: invokestatic 586	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
    //   701: ifeq +14 -> 715
    //   704: aload_0
    //   705: aload_1
    //   706: getfield 923	com/tencent/mm/plugin/luckymoney/model/av:ulc	Lcom/tencent/mm/protocal/protobuf/bjm;
    //   709: getfield 934	com/tencent/mm/protocal/protobuf/bjm:EYC	Ljava/lang/String;
    //   712: putfield 931	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:uub	Ljava/lang/String;
    //   715: aload_0
    //   716: getfield 737	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:fzK	Ljava/lang/String;
    //   719: invokestatic 742	com/tencent/mm/model/w:wC	(Ljava/lang/String;)Z
    //   722: ifeq +230 -> 952
    //   725: ldc_w 436
    //   728: ldc_w 2172
    //   731: invokestatic 701	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   734: aload_0
    //   735: getfield 1774	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:foF	J
    //   738: invokestatic 2177	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   741: invokestatic 2180	com/tencent/mm/plugin/luckymoney/a/b:e	(Ljava/lang/Long;)Lcom/tencent/mm/protocal/protobuf/cnf;
    //   744: astore_1
    //   745: aload_1
    //   746: ifnull +11 -> 757
    //   749: aload_0
    //   750: aload_1
    //   751: getfield 2186	com/tencent/mm/protocal/protobuf/cnf:ETB	Lcom/tencent/mm/protocal/protobuf/cng;
    //   754: invokespecial 2188	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:b	(Lcom/tencent/mm/protocal/protobuf/cng;)V
    //   757: aload_0
    //   758: aload_0
    //   759: getfield 1526	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:uuo	Lcom/tencent/mm/plugin/luckymoney/model/l;
    //   762: invokespecial 2190	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:a	(Lcom/tencent/mm/plugin/luckymoney/model/l;)V
    //   765: aload_0
    //   766: invokevirtual 1657	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   769: ldc_w 2192
    //   772: iconst_0
    //   773: invokevirtual 2036	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   776: ifeq +10 -> 786
    //   779: aload_0
    //   780: getstatic 2198	com/tencent/mm/plugin/luckymoney/ui/k$a:uyW	Lcom/tencent/mm/plugin/luckymoney/ui/k$a;
    //   783: invokestatic 2203	com/tencent/mm/plugin/luckymoney/ui/k:a	(Landroid/content/Context;Lcom/tencent/mm/plugin/luckymoney/ui/k$a;)V
    //   786: aload_0
    //   787: getfield 737	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:fzK	Ljava/lang/String;
    //   790: invokestatic 742	com/tencent/mm/model/w:wC	(Ljava/lang/String;)Z
    //   793: ifne +19 -> 812
    //   796: aload_0
    //   797: iconst_0
    //   798: ldc_w 2204
    //   801: new 2206	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$21
    //   804: dup
    //   805: aload_0
    //   806: invokespecial 2207	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$21:<init>	(Lcom/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI;)V
    //   809: invokevirtual 2211	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:addIconOptionMenu	(IILandroid/view/MenuItem$OnMenuItemClickListener;)V
    //   812: aload_0
    //   813: getfield 812	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:usD	I
    //   816: iconst_4
    //   817: if_icmpeq +11 -> 828
    //   820: aload_0
    //   821: getfield 812	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:usD	I
    //   824: iconst_2
    //   825: if_icmpne +195 -> 1020
    //   828: iconst_1
    //   829: istore_2
    //   830: aload_0
    //   831: getfield 737	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:fzK	Ljava/lang/String;
    //   834: astore_1
    //   835: new 2213	com/tencent/mm/plugin/luckymoney/story/b/e
    //   838: dup
    //   839: invokespecial 2214	com/tencent/mm/plugin/luckymoney/story/b/e:<init>	()V
    //   842: astore 5
    //   844: aload 5
    //   846: aload_0
    //   847: getfield 1630	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:ust	Ljava/lang/String;
    //   850: putfield 2217	com/tencent/mm/plugin/luckymoney/story/b/e:field_send_id	Ljava/lang/String;
    //   853: invokestatic 2223	com/tencent/mm/plugin/luckymoney/b/a:cYv	()Lcom/tencent/mm/plugin/luckymoney/b/a;
    //   856: invokevirtual 2227	com/tencent/mm/plugin/luckymoney/b/a:cYu	()Lcom/tencent/mm/plugin/luckymoney/story/b/f;
    //   859: aload 5
    //   861: iconst_0
    //   862: anewarray 658	java/lang/String
    //   865: invokevirtual 2232	com/tencent/mm/plugin/luckymoney/story/b/f:get	(Lcom/tencent/mm/sdk/e/c;[Ljava/lang/String;)Z
    //   868: istore 4
    //   870: ldc_w 436
    //   873: ldc_w 2234
    //   876: iconst_2
    //   877: anewarray 440	java/lang/Object
    //   880: dup
    //   881: iconst_0
    //   882: iload 4
    //   884: invokestatic 1469	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   887: aastore
    //   888: dup
    //   889: iconst_1
    //   890: aload_0
    //   891: getfield 1630	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:ust	Ljava/lang/String;
    //   894: aastore
    //   895: invokestatic 2236	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   898: iload 4
    //   900: ifeq +146 -> 1046
    //   903: aload 5
    //   905: getfield 2239	com/tencent/mm/plugin/luckymoney/story/b/e:field_open_count	I
    //   908: ifgt +133 -> 1041
    //   911: aload 5
    //   913: aload 5
    //   915: getfield 2239	com/tencent/mm/plugin/luckymoney/story/b/e:field_open_count	I
    //   918: iconst_1
    //   919: iadd
    //   920: putfield 2239	com/tencent/mm/plugin/luckymoney/story/b/e:field_open_count	I
    //   923: invokestatic 2223	com/tencent/mm/plugin/luckymoney/b/a:cYv	()Lcom/tencent/mm/plugin/luckymoney/b/a;
    //   926: invokevirtual 2227	com/tencent/mm/plugin/luckymoney/b/a:cYu	()Lcom/tencent/mm/plugin/luckymoney/story/b/f;
    //   929: aload 5
    //   931: iconst_0
    //   932: anewarray 658	java/lang/String
    //   935: invokevirtual 2242	com/tencent/mm/plugin/luckymoney/story/b/f:update	(Lcom/tencent/mm/sdk/e/c;[Ljava/lang/String;)Z
    //   938: pop
    //   939: iload_2
    //   940: aload_1
    //   941: iload_3
    //   942: invokestatic 2247	com/tencent/mm/plugin/luckymoney/story/a:l	(ILjava/lang/String;I)V
    //   945: ldc_w 2019
    //   948: invokestatic 290	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   951: return
    //   952: aload_0
    //   953: getfield 1532	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:uun	Ljava/lang/String;
    //   956: invokestatic 586	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
    //   959: ifne +53 -> 1012
    //   962: aload_0
    //   963: getfield 1532	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:uun	Ljava/lang/String;
    //   966: invokestatic 2251	com/tencent/mm/plugin/luckymoney/a/b:akd	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/cng;
    //   969: astore_1
    //   970: aload_1
    //   971: ifnull +35 -> 1006
    //   974: iconst_1
    //   975: istore 4
    //   977: ldc_w 436
    //   980: ldc_w 2253
    //   983: iconst_1
    //   984: anewarray 440	java/lang/Object
    //   987: dup
    //   988: iconst_0
    //   989: iload 4
    //   991: invokestatic 1469	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   994: aastore
    //   995: invokestatic 456	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   998: aload_0
    //   999: aload_1
    //   1000: invokespecial 2188	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:b	(Lcom/tencent/mm/protocal/protobuf/cng;)V
    //   1003: goto -246 -> 757
    //   1006: iconst_0
    //   1007: istore 4
    //   1009: goto -32 -> 977
    //   1012: aload_0
    //   1013: aconst_null
    //   1014: invokespecial 2188	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:b	(Lcom/tencent/mm/protocal/protobuf/cng;)V
    //   1017: goto -260 -> 757
    //   1020: aload_0
    //   1021: getfield 812	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:usD	I
    //   1024: iconst_1
    //   1025: if_icmpeq +11 -> 1036
    //   1028: aload_0
    //   1029: getfield 812	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:usD	I
    //   1032: iconst_3
    //   1033: if_icmpne +22 -> 1055
    //   1036: iconst_2
    //   1037: istore_2
    //   1038: goto -208 -> 830
    //   1041: iconst_2
    //   1042: istore_3
    //   1043: goto -132 -> 911
    //   1046: iconst_2
    //   1047: istore_3
    //   1048: goto -109 -> 939
    //   1051: astore_1
    //   1052: goto -670 -> 382
    //   1055: iconst_0
    //   1056: istore_2
    //   1057: goto -227 -> 830
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1060	0	this	LuckyMoneyDetailUI
    //   0	1060	1	paramBundle	Bundle
    //   829	228	2	i	int
    //   1	1047	3	j	int
    //   868	140	4	bool	boolean
    //   842	88	5	locale	com.tencent.mm.plugin.luckymoney.story.b.e
    // Exception table:
    //   from	to	target	type
    //   46	51	533	java/lang/Exception
    //   382	450	603	java/lang/Exception
    //   450	485	603	java/lang/Exception
    //   485	493	603	java/lang/Exception
    //   497	502	603	java/lang/Exception
    //   567	578	603	java/lang/Exception
    //   582	600	603	java/lang/Exception
    //   637	641	603	java/lang/Exception
    //   371	382	1051	java/lang/Exception
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
    if ((this.uuu == 1) || (this.uuu == 2))
    {
      this.utW = new df();
      this.utW.dNx = 12L;
      this.utW.aHZ();
    }
    if (this.uiw != null)
    {
      this.uiw.release();
      int i = 0;
      while (i < this.utx.length)
      {
        this.uiw.unload(this.utx[i]);
        i += 1;
      }
    }
    if (this.utS != null)
    {
      ac.i("MicroMsg.LuckyMoneyDetailUI", "commentfooter release");
      this.utS.onPause();
      this.utS.eMG();
      this.utS.destroy();
    }
    k.ccl().pam = null;
    com.tencent.mm.plugin.luckymoney.a.b.clear();
    com.tencent.mm.plugin.luckymoney.a.c.openId = null;
    com.tencent.mm.plugin.luckymoney.a.c.fTK = null;
    com.tencent.mm.plugin.luckymoney.a.c.ufX = null;
    com.tencent.mm.plugin.luckymoney.a.c.hxt = null;
    com.tencent.mm.plugin.luckymoney.a.c.ufZ = 0;
    com.tencent.mm.plugin.luckymoney.a.c.ufY = 0;
    com.tencent.mm.plugin.luckymoney.story.a.tn(1);
    com.tencent.mm.kernel.g.agQ().ghe.b(697, this.uus);
    AppMethodBeat.o(65577);
  }
  
  public void onKeyboardStateChanged()
  {
    AppMethodBeat.i(65564);
    super.onKeyboardStateChanged();
    ac.d("MicroMsg.LuckyMoneyDetailUI", "keyboard changed: %s", new Object[] { Integer.valueOf(keyboardState()) });
    keyboardState();
    AppMethodBeat.o(65564);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(65560);
    super.onPause();
    com.tencent.mm.modelstat.d.m("LuckyMoneyDetailUI", this.uup, bs.aNx());
    AppMethodBeat.o(65560);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(65559);
    super.onResume();
    this.uup = bs.aNx();
    AppMethodBeat.o(65559);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(65566);
    ac.i("MicroMsg.LuckyMoneyDetailUI", "onSceneEnd() errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " netsceneType:" + paramn.getType());
    if ((paramn instanceof ah))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (ah)paramn;
        paramn = paramString.uni;
        this.usK = paramString.unu;
        this.pcm = paramString.unv;
        this.utR = paramString.unw;
        this.utV = paramString.unx;
        this.uuo = paramn;
        a(this.uuo);
        AppMethodBeat.o(65566);
        return true;
      }
      com.tencent.mm.ui.base.h.cg(this, paramString);
      AppMethodBeat.o(65566);
      return true;
    }
    if ((paramn instanceof ao))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.uhd = false;
        paramString = (ao)paramn;
        if (this.uhb != null) {
          paramInt1 = 0;
        }
        for (;;)
        {
          if (paramInt1 < this.uhb.size())
          {
            paramn = (y)this.uhb.get(paramInt1);
            if (paramn.ulF.equalsIgnoreCase(paramString.ulF))
            {
              paramn.umW = paramString.ugH;
              this.uul.arg.notifyChanged();
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
      com.tencent.mm.ui.base.h.cg(this, paramString);
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
      com.tencent.mm.ui.base.h.cg(this, paramString);
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
    public y uuG;
    
    a() {}
    
    public final int bTF()
    {
      return 2;
    }
    
    public final long lx()
    {
      AppMethodBeat.i(163737);
      long l = this.uuG.ulF.hashCode();
      AppMethodBeat.o(163737);
      return l;
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