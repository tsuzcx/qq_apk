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
import com.tencent.mm.aj.i;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.api.z.a;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.g.a.jb;
import com.tencent.mm.g.a.jb.b;
import com.tencent.mm.g.b.a.dy;
import com.tencent.mm.g.b.a.dz;
import com.tencent.mm.g.b.a.ea;
import com.tencent.mm.model.x;
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
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.pluginsdk.ui.chat.e.b;
import com.tencent.mm.protocal.protobuf.agk;
import com.tencent.mm.protocal.protobuf.bom;
import com.tencent.mm.protocal.protobuf.bon;
import com.tencent.mm.protocal.protobuf.cpo;
import com.tencent.mm.protocal.protobuf.ctd;
import com.tencent.mm.protocal.protobuf.jm;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.vfs.o;
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
  private View agn;
  RecyclerView.m ans;
  private long fIR;
  private String fVg;
  private int fq;
  private TextView lHT;
  private boolean lpM;
  private TextView mpP;
  private c.a pKA;
  private String pMA;
  private EmojiInfo pOS;
  private View pPh;
  private int pmf;
  private ImageView qrQ;
  private Dialog tipDialog;
  private TextView uSM;
  private int vAB;
  private String vEF;
  private String vEG;
  private RecyclerView vHS;
  private CdnImageView vHT;
  private View vHU;
  private ImageView vHV;
  private ViewGroup vHW;
  private View vHX;
  private View vHY;
  private View vHZ;
  private String vHa;
  private View vHh;
  private boolean vHj;
  private int vHk;
  private String vHl;
  private String vHm;
  private String vHn;
  private Map<String, Integer> vHp;
  private String vHr;
  private boolean vHs;
  private EmojiInfo vIA;
  private ViewGroup vIB;
  public LuckyMoneyEmojiSwitch vIC;
  private ea vID;
  private dy vIE;
  private dz vIF;
  private int vIG;
  private boolean vIH;
  private String vII;
  private Bitmap vIJ;
  private Bitmap vIK;
  private Bitmap vIL;
  private Bitmap vIM;
  private Bitmap vIN;
  private Bitmap vIO;
  private Bitmap vIP;
  private Bitmap vIQ;
  private boolean vIR;
  private WxRecyclerAdapter vIS;
  private int vIT;
  private String vIU;
  private com.tencent.mm.plugin.luckymoney.model.l vIV;
  private long vIW;
  private View.OnClickListener vIX;
  private int vIY;
  private com.tencent.mm.ak.f vIZ;
  private TextView vIa;
  private TextView vIb;
  private ViewGroup vIc;
  private RelativeLayout vId;
  private int[] vIe;
  private ViewGroup vIf;
  private RelativeLayout vIg;
  private BaseEmojiView vIh;
  private TextView vIi;
  private LinearLayout vIj;
  private ProgressBar vIk;
  private LinearLayout vIl;
  private LinearLayout vIm;
  private LinearLayout vIn;
  private BaseEmojiView vIo;
  private RelativeLayout vIp;
  private ImageView vIq;
  private a vIr;
  private View vIs;
  private ImageView vIt;
  private View vIu;
  private EnvelopeAppBarLayout vIv;
  private ArrayList<a> vIw;
  private boolean vIx;
  private int vIy;
  private ChatFooterPanel vIz;
  private int vJa;
  private int vJb;
  private final int vJc;
  private final int vJd;
  private List<y> vvQ;
  private boolean vvS;
  private int vvT;
  private TextView vvW;
  private ImageView vwf;
  private TextView vwg;
  private ImageView vwh;
  private View vwi;
  private View vwj;
  private SoundPool vxj;
  private com.tencent.mm.particles.b vyN;
  
  public LuckyMoneyDetailUI()
  {
    AppMethodBeat.i(65556);
    this.fq = 0;
    this.vHj = true;
    this.lpM = false;
    this.vAB = -1;
    this.vvQ = new LinkedList();
    this.vIw = new ArrayList();
    this.vHp = new HashMap();
    this.vHr = "";
    this.vIx = false;
    this.vHs = false;
    this.vIG = 0;
    this.vIH = false;
    this.ans = new RecyclerView.m()
    {
      private boolean vwm = false;
      private boolean vwn;
      
      public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(163711);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousRecyclerView);
        localb.mu(paramAnonymousInt1);
        localb.mu(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahF());
        if ((paramAnonymousRecyclerView.getAdapter().getItemCount() == 0) || (!this.vwm))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
          AppMethodBeat.o(163711);
          return;
        }
        paramAnonymousRecyclerView = (LinearLayoutManager)paramAnonymousRecyclerView.getLayoutManager();
        boolean bool;
        if (paramAnonymousRecyclerView.km() > 0)
        {
          bool = true;
          if (this.vwn != bool)
          {
            if (bool) {
              LuckyMoneyDetailUI.this.getResources().getDrawable(2131232950);
            }
            this.vwn = bool;
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
          AppMethodBeat.o(163711);
          return;
        }
        paramAnonymousRecyclerView = paramAnonymousRecyclerView.bY(paramAnonymousRecyclerView.km());
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
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousRecyclerView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).mu(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        if (paramAnonymousRecyclerView.getAdapter().getItemCount() == 0)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
          AppMethodBeat.o(163710);
          return;
        }
        switch (paramAnonymousInt)
        {
        }
        for (this.vwm = true;; this.vwm = false)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
          AppMethodBeat.o(163710);
          return;
          localObject = (LinearLayoutManager)paramAnonymousRecyclerView.getLayoutManager();
          if ((((LinearLayoutManager)localObject).ko() == LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this).size()) || (((LinearLayoutManager)localObject).ko() == paramAnonymousRecyclerView.getAdapter().getItemCount() - 1))
          {
            if (!LuckyMoneyDetailUI.this.vGY.isProcessing()) {
              LuckyMoneyDetailUI.b(LuckyMoneyDetailUI.this);
            }
            if ((LuckyMoneyDetailUI.c(LuckyMoneyDetailUI.this)) && (!LuckyMoneyDetailUI.d(LuckyMoneyDetailUI.this))) {
              LuckyMoneyDetailUI.e(LuckyMoneyDetailUI.this);
            }
          }
        }
      }
    };
    this.vyN = new com.tencent.mm.particles.b()
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
    this.vIR = false;
    this.pKA = new c.a()
    {
      public final void a(final boolean paramAnonymousBoolean, final EmojiInfo paramAnonymousEmojiInfo)
      {
        AppMethodBeat.i(65541);
        ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(65540);
            if ((paramAnonymousEmojiInfo != null) && (LuckyMoneyDetailUI.n(LuckyMoneyDetailUI.this) != null) && (LuckyMoneyDetailUI.n(LuckyMoneyDetailUI.this).Lj().equals(paramAnonymousEmojiInfo.Lj())))
            {
              if (paramAnonymousBoolean)
              {
                com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LuckyMoneyDetailUI", "somethings success.");
                LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, k.getEmojiStorageMgr().JfU.aWl(LuckyMoneyDetailUI.n(LuckyMoneyDetailUI.this).Lj()));
                LuckyMoneyDetailUI.o(LuckyMoneyDetailUI.this).setVisibility(8);
                LuckyMoneyDetailUI.p(LuckyMoneyDetailUI.this).setVisibility(0);
                LuckyMoneyDetailUI.b(LuckyMoneyDetailUI.this, LuckyMoneyDetailUI.n(LuckyMoneyDetailUI.this));
                AppMethodBeat.o(65540);
                return;
              }
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LuckyMoneyDetailUI", "somethings error.");
              LuckyMoneyDetailUI.o(LuckyMoneyDetailUI.this).setVisibility(8);
              LuckyMoneyDetailUI.q(LuckyMoneyDetailUI.this).setVisibility(0);
            }
            AppMethodBeat.o(65540);
          }
        });
        AppMethodBeat.o(65541);
      }
    };
    this.vvS = false;
    this.vIW = 0L;
    this.vIX = new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(163720);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, new dy());
        if (bu.jB(paramAnonymousView.getId(), 2131301952))
        {
          LuckyMoneyDetailUI.w(LuckyMoneyDetailUI.this).eeh = 1L;
          LuckyMoneyDetailUI.w(LuckyMoneyDetailUI.this).aLH();
        }
        if ((bu.jB(LuckyMoneyDetailUI.this.vIC.vAL, 0)) && (bu.K(paramAnonymousView.getTag(), "nodelete")))
        {
          LuckyMoneyDetailUI.B(LuckyMoneyDetailUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(163720);
          return;
        }
        localObject = new com.tencent.mm.ui.widget.a.e(LuckyMoneyDetailUI.this.getContext(), 1, false);
        ((com.tencent.mm.ui.widget.a.e)localObject).LfS = new n.d()
        {
          public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
          {
            AppMethodBeat.i(163718);
            String str = LuckyMoneyDetailUI.this.getString(2131760952);
            if (!bu.jB(LuckyMoneyDetailUI.this.vIC.vAL, 0)) {
              paramAnonymous2l.jM(1, 2131760908);
            }
            for (;;)
            {
              paramAnonymous2l.d(2, str);
              if (!bu.K(paramAnonymousView.getTag(), "nodelete")) {
                paramAnonymous2l.a(3, LuckyMoneyDetailUI.this.getResources().getColor(2131100596), LuckyMoneyDetailUI.this.getContext().getString(2131760844));
              }
              AppMethodBeat.o(163718);
              return;
              str = LuckyMoneyDetailUI.this.getString(2131760858);
            }
          }
        };
        ((com.tencent.mm.ui.widget.a.e)localObject).LfT = new n.e()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(163719);
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LuckyMoneyDetailUI", "showLuckyHbDlg() onMMMenuItemSelected menuItemId:%s", new Object[] { Integer.valueOf(paramAnonymous2MenuItem.getItemId()) });
            switch (paramAnonymous2MenuItem.getItemId())
            {
            }
            for (;;)
            {
              AppMethodBeat.o(163719);
              return;
              com.tencent.mm.plugin.emojicapture.api.b.b(LuckyMoneyDetailUI.this, 5, LuckyMoneyDetailUI.v(LuckyMoneyDetailUI.this));
              LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, new dy());
              LuckyMoneyDetailUI.w(LuckyMoneyDetailUI.this).eeh = 4L;
              LuckyMoneyDetailUI.w(LuckyMoneyDetailUI.this).aLH();
              LuckyMoneyDetailUI.C(LuckyMoneyDetailUI.this);
              AppMethodBeat.o(163719);
              return;
              LuckyMoneyDetailUI.B(LuckyMoneyDetailUI.this);
              AppMethodBeat.o(163719);
              return;
              LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, null);
              LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, new dy());
              LuckyMoneyDetailUI.w(LuckyMoneyDetailUI.this).eeh = 8L;
              LuckyMoneyDetailUI.w(LuckyMoneyDetailUI.this).aLH();
              LuckyMoneyDetailUI.b(LuckyMoneyDetailUI.this, 1);
            }
          }
        };
        LuckyMoneyDetailUI.w(LuckyMoneyDetailUI.this).eeh = 2L;
        LuckyMoneyDetailUI.w(LuckyMoneyDetailUI.this).aLH();
        ((com.tencent.mm.ui.widget.a.e)localObject).cPF();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(163720);
      }
    };
    this.vIY = 3;
    this.vIZ = new com.tencent.mm.ak.f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(163722);
        if ((bu.jB(paramAnonymousn.getType(), 697)) && ((paramAnonymousn instanceof com.tencent.mm.plugin.emoji.f.e)))
        {
          paramAnonymousString = (com.tencent.mm.plugin.emoji.f.e)paramAnonymousn;
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            paramAnonymousString = paramAnonymousString.cir();
            if ((paramAnonymousString != null) && (paramAnonymousString.FUH != null) && (paramAnonymousString.FUH.size() > 0) && (bu.lX(((agk)paramAnonymousString.FUH.get(0)).Md5, LuckyMoneyDetailUI.n(LuckyMoneyDetailUI.this).Lj()))) {
              LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, false);
            }
          }
        }
        AppMethodBeat.o(163722);
      }
    };
    this.vJa = 0;
    this.vJb = 0;
    this.vJc = 750;
    this.vJd = 240;
    AppMethodBeat.o(65556);
  }
  
  private void B(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(65570);
    this.vJb = 3;
    this.vIh.setEmojiInfo(paramEmojiInfo);
    this.vID = new ea();
    this.vID.eeh = 11L;
    this.vID.aLH();
    AppMethodBeat.o(65570);
  }
  
  private static int JN(int paramInt)
  {
    if (paramInt == 2) {
      return 13;
    }
    return 7;
  }
  
  private void JP(int paramInt)
  {
    AppMethodBeat.i(65574);
    bt(paramInt, "");
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
    label464:
    label482:
    Object localObject2;
    if (g(paraml)) {
      if (dml())
      {
        if (!bool) {}
        if (!dml()) {
          break label1818;
        }
        this.vIg.setVisibility(0);
        oe(true);
        if ((!bu.jB(this.vIC.vAK, 0)) && (e(paraml)) && (this.vIH)) {
          break label1830;
        }
        JP(0);
        if (paraml.vAt != 1) {
          break label1941;
        }
        bool = true;
        this.vHj = bool;
        if (paraml != null)
        {
          if (((paraml.dPd != 3) && (paraml.dPd != 2)) || (paraml.vAs != 1) || (this.vHj) || (paraml.vAv != 1)) {
            break label1947;
          }
          i = 1;
          if ((paraml.vAw == null) || (paraml.vAw.gaV != 1) || (bu.isNullOrNil(paraml.vAw.vzR))) {
            break label1952;
          }
          j = 1;
          this.vIa = ((TextView)this.pPh.findViewById(2131301772));
          if ((i == 0) && (j == 0)) {
            break label1957;
          }
          this.vIa.setOnClickListener(new LuckyMoneyDetailUI.18(this, paraml));
          if (j != 0)
          {
            this.vHn = paraml.vAw.vzR;
            this.vIa.setText(paraml.vAw.vzS);
          }
          com.tencent.mm.plugin.report.service.g.yxI.f(11701, new Object[] { Integer.valueOf(JN(paraml.vAB)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2) });
          this.vIa.setVisibility(0);
          this.vAB = paraml.vAB;
          this.vIb = ((TextView)this.pPh.findViewById(2131301769));
          this.vIb.setVisibility(8);
          if (!this.vHs)
          {
            this.vIS.aV(this.pPh, 3);
            this.vHs = true;
          }
        }
        if (this.fq == 0)
        {
          this.vHl = paraml.vAq;
          localObject1 = this.vHl;
          if ((paraml == null) || (paraml.dPc != 0) || (paraml.vAC == null) || (paraml.vAC.size() <= 0) || (!((y)paraml.vAC.get(0)).vAq.equals(localObject1)) || (paraml.vAr == 1)) {
            break label1969;
          }
          i = 1;
          if (i == 0) {
            break label1974;
          }
          this.vvS = false;
          this.vHW.setVisibility(8);
          this.vvT = paraml.vAB;
          if (paraml != null)
          {
            localObject2 = getContext();
            if (paraml.vAB != 2) {
              break label2045;
            }
            this.vwf.setImageResource(2131232967);
            if (paraml.resourceId == 0) {
              break label2027;
            }
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LuckyMoneyDetailUI", "busi logo load from file:" + paraml.resourceId);
            localObject1 = new jb();
            ((jb)localObject1).dwP.dwR = paraml.resourceId;
            ((jb)localObject1).callback = new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(163726);
                if (this.vHu.dwQ.dwS)
                {
                  com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LuckyMoneyDetailUI", "Get res Ok, path=" + this.vHu.dwQ.dwT);
                  LuckyMoneyDetailUI.this.getContext();
                  z.p(LuckyMoneyDetailUI.K(LuckyMoneyDetailUI.this), this.vHu.dwQ.dwT);
                  AppMethodBeat.o(163726);
                  return;
                }
                com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LuckyMoneyDetailUI", "Get res fail & load from url.");
                z.b(LuckyMoneyDetailUI.K(LuckyMoneyDetailUI.this), paraml.vAk, paraml.vAE);
                AppMethodBeat.o(163726);
              }
            };
            com.tencent.mm.sdk.b.a.IvT.a((com.tencent.mm.sdk.b.b)localObject1, Looper.myLooper());
            label599:
            if (!x.Ai(this.fVg)) {
              break label2086;
            }
            localObject1 = paraml.vAj;
            label615:
            i = ((WindowManager)getSystemService("window")).getDefaultDisplay().getWidth();
            j = BackwardSupportUtil.b.h(getContext(), 92.0F);
            this.vwg.setMaxWidth(i - j);
            z.a((Context)localObject2, this.vwg, (String)localObject1);
            z.a((Context)localObject2, this.uSM, paraml.vvw);
            if (bu.isNullOrNil(paraml.vvw)) {
              break label2109;
            }
            this.uSM.setVisibility(0);
            label697:
            if (paraml.dPc != 1) {
              break label2121;
            }
            this.vwh.setVisibility(0);
            this.vwh.setImageResource(2131690761);
            label723:
            if (bu.isNullOrNil(paraml.vAA)) {
              break label2199;
            }
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LuckyMoneyDetailUI", "hy: has url : %s", new Object[] { paraml.vAA });
            this.vId.setVisibility(4);
            z.l(this.qrQ, paraml.vAA);
            ar.o(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(163727);
                LuckyMoneyDetailUI.L(LuckyMoneyDetailUI.this);
                LuckyMoneyDetailUI.M(LuckyMoneyDetailUI.this).setVisibility(0);
                AppMethodBeat.o(163727);
              }
            }, 500L);
            label786:
            if ((paraml.dPe != 2) || (this.vHk == 3)) {
              break label2220;
            }
            this.vvW.setText(com.tencent.mm.wallet_core.ui.f.C(paraml.dPq / 100.0D));
            this.vwi.setVisibility(0);
            label829:
            if (bu.isNullOrNil(paraml.vxB)) {
              break label2332;
            }
            this.vwj.setVisibility(0);
            this.mpP.setText(paraml.vxB);
            if (!x.Ai(this.fVg)) {
              break label2232;
            }
            this.vHT.setVisibility(8);
            this.agn.findViewById(2131301786).setVisibility(8);
            label892:
            if (bu.isNullOrNil(paraml.vAu)) {
              break label2353;
            }
            this.lHT.setText(paraml.vAu);
            this.vHW.setVisibility(0);
            if ((g(paraml)) && (!e(paraml)))
            {
              this.vHX.setVisibility(8);
              this.vHY.setVisibility(8);
              this.vHZ.setVisibility(8);
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
        localObject1 = paraml.vAx;
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          localObject2 = this.agn.findViewById(2131301765);
          localObject3 = this.agn.findViewById(2131301766);
          View localView1 = this.agn.findViewById(2131301767);
          ViewGroup localViewGroup1 = (ViewGroup)this.agn.findViewById(2131301762);
          ViewGroup localViewGroup2 = (ViewGroup)this.agn.findViewById(2131301763);
          ViewGroup localViewGroup3 = (ViewGroup)this.agn.findViewById(2131301764);
          View localView2 = this.agn.findViewById(2131301753);
          View localView3 = this.agn.findViewById(2131301754);
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
            this.vHh.requestLayout();
            this.vHh.setVisibility(0);
          }
        }
        this.vIc = ((ViewGroup)this.pPh.findViewById(2131301756));
        localObject1 = new h.c();
        ((h.c)localObject1).textColor = getResources().getColor(2131099819);
        ((h.c)localObject1).textSize = getResources().getDimensionPixelSize(2131165466);
        h.a(this, this.vIc, paraml.vAy, (h.c)localObject1);
        localObject1 = new h.c();
        ((h.c)localObject1).textColor = getResources().getColor(2131099769);
        ((h.c)localObject1).textSize = getResources().getDimensionPixelSize(2131165466);
        if ((paraml.vAH != null) && (!x.Ai(this.fVg)))
        {
          localObject2 = av.aqc(paraml.vAH);
          if ((localObject2 != null) && (((av)localObject2).vCT != null))
          {
            ((h.c)localObject1).vLv = ((av)localObject2).vzN;
            if (((h.c)localObject1).vLv == null)
            {
              ((h.c)localObject1).vLv = new bom();
              ((h.c)localObject1).vLv.HbA = this.vII;
            }
            h.a(this, this.vIc, ((av)localObject2).vCT, (h.c)localObject1);
            localObject1 = "";
            if (((av)localObject2).vzN != null) {
              localObject1 = ((av)localObject2).vzN.Gta;
            }
            com.tencent.mm.plugin.report.service.g.yxI.f(16589, new Object[] { Integer.valueOf(1), ((av)localObject2).vCT.content, this.vII, localObject1, Integer.valueOf(0), com.tencent.mm.plugin.luckymoney.a.c.openId });
          }
        }
      }
      com.tencent.mm.plugin.report.service.g.yxI.f(11701, new Object[] { Integer.valueOf(JN(paraml.vAB)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
      localObject1 = paraml.vAC;
      if (localObject1 == null) {
        break label2404;
      }
      i = 0;
      while (i < ((List)localObject1).size())
      {
        localObject2 = (y)((List)localObject1).get(i);
        if (!this.vHp.containsKey(((y)localObject2).vAq))
        {
          this.vvQ.add(((List)localObject1).get(i));
          localObject3 = new a();
          ((a)localObject3).vJn = ((y)((List)localObject1).get(i));
          this.vIw.add(localObject3);
          this.vHp.put(((y)localObject2).vAq, Integer.valueOf(1));
        }
        i += 1;
      }
      if (bool) {
        break;
      }
      break;
      if (bool)
      {
        if (dml()) {
          break;
        }
        break;
      }
      dml();
      break;
      label1818:
      this.vIg.setVisibility(8);
      break label63;
      label1830:
      this.vIm.setOnClickListener(this.vIX);
      this.vIm.setTag("nodelete");
      this.vIq.setOnClickListener(this.vIX);
      this.vIt.setOnClickListener(this.vIX);
      this.vIp.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(163715);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, new dy());
          LuckyMoneyDetailUI.w(LuckyMoneyDetailUI.this).eeh = 7L;
          LuckyMoneyDetailUI.w(LuckyMoneyDetailUI.this).aLH();
          LuckyMoneyDetailUI.A(LuckyMoneyDetailUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(163715);
        }
      });
      this.vIo.setOnClickListener(this.vIX);
      localObject1 = (String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IRY, "");
      JP(1);
      if (bu.isNullOrNil((String)localObject1)) {
        break label97;
      }
      bt(2, (String)localObject1);
      break label97;
      label1941:
      bool = false;
      break label108;
      label1947:
      i = 0;
      break label159;
      label1952:
      j = 0;
      break label192;
      label1957:
      this.vIa.setVisibility(8);
      break label324;
      label1969:
      i = 0;
      break label464;
      label1974:
      this.vHW.setVisibility(0);
      if ((!g(paraml)) || (e(paraml))) {
        break label482;
      }
      this.vHX.setVisibility(8);
      this.vHY.setVisibility(8);
      this.vHZ.setVisibility(8);
      break label482;
      label2027:
      z.b(this.vwf, paraml.vAk, paraml.vAE);
      break label599;
      label2045:
      if (x.Ai(this.fVg))
      {
        this.vwf.setImageResource(2131233442);
        break label599;
      }
      z.b(this.vwf, paraml.vAk, paraml.vAE);
      break label599;
      label2086:
      localObject1 = getString(2131760982, new Object[] { paraml.vAj });
      break label615;
      label2109:
      this.uSM.setVisibility(8);
      break label697;
      label2121:
      if (paraml.dPc == 2)
      {
        if (!x.An(paraml.vAE))
        {
          localObject1 = new i();
          ((i)localObject1).username = paraml.vAE;
          com.tencent.mm.aj.p.aEN().b((i)localObject1);
        }
        this.vwh.setVisibility(0);
        this.vwh.setImageResource(2131690760);
        break label723;
      }
      this.vwh.setVisibility(8);
      break label723;
      label2199:
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LuckyMoneyDetailUI", "hy: no bg. set bg area to gone");
      this.vId.setVisibility(8);
      break label786;
      label2220:
      this.vwi.setVisibility(8);
      break label829;
      label2232:
      if (paraml.vxz == 1)
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LuckyMoneyDetailUI", "changeIconUrl: %s", new Object[] { paraml.vAG });
        if (!bu.isNullOrNil(paraml.vAG))
        {
          this.vHT.setUrl(paraml.vAG);
          this.vHT.setVisibility(0);
        }
        for (;;)
        {
          this.mpP.setOnClickListener(new LuckyMoneyDetailUI.15(this, paraml));
          break;
          this.vHT.setVisibility(8);
        }
      }
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.LuckyMoneyDetailUI", "detail.jumpChange is false");
      break label892;
      label2332:
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.LuckyMoneyDetailUI", "detail.changeWording is empty");
      this.vwj.setVisibility(8);
      break label892;
      label2353:
      this.lHT.setText(null);
      this.vHW.setVisibility(8);
    }
    this.fq += ((List)localObject1).size();
    this.lpM = false;
    this.vIS.asY.notifyChanged();
    label2404:
    if ((paraml.dPc == 2) && (!bu.isNullOrNil(paraml.vAi)))
    {
      this.vxj = new SoundPool(2, 3, 0);
      this.vIe = new int[2];
    }
    try
    {
      this.vIe[0] = this.vxj.load(getResources().getAssets().openFd("most_lucky.m4a"), 0);
      this.vIe[1] = this.vxj.load(getResources().getAssets().openFd("whistle.m4a"), 0);
      this.vxj.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener()
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
            if ((paramAnonymousInt1 == LuckyMoneyDetailUI.H(LuckyMoneyDetailUI.this)[1]) && (paraml.dPq >= 19000L)) {
              paramAnonymousSoundPool.play(paramAnonymousInt1, 1.0F, 1.0F, 0, 0, 1.0F);
            }
          }
          AppMethodBeat.o(163724);
        }
      });
      this.agn.postDelayed(new LuckyMoneyDetailUI.11(this), 300L);
      if (!x.Ai(this.fVg))
      {
        localObject1 = new com.tencent.mm.plugin.wallet_core.model.ae();
        ((com.tencent.mm.plugin.wallet_core.model.ae)localObject1).field_mNativeUrl = this.vHm;
        ((com.tencent.mm.plugin.wallet_core.model.ae)localObject1).field_hbType = paraml.dPc;
        ((com.tencent.mm.plugin.wallet_core.model.ae)localObject1).field_receiveAmount = paraml.dPq;
        ((com.tencent.mm.plugin.wallet_core.model.ae)localObject1).field_receiveTime = System.currentTimeMillis();
        ((com.tencent.mm.plugin.wallet_core.model.ae)localObject1).field_hbStatus = paraml.dPd;
        ((com.tencent.mm.plugin.wallet_core.model.ae)localObject1).field_receiveStatus = paraml.dPe;
        if (((com.tencent.mm.plugin.wallet_core.model.ae)localObject1).field_receiveAmount > 0L) {
          t.eJb().a((com.tencent.mm.plugin.wallet_core.model.ae)localObject1);
        }
      }
      dmm();
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
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.LuckyMoneyDetailUI", "load lucky money voice fail " + localIOException.getMessage());
      }
    }
  }
  
  private void b(ctd paramctd)
  {
    AppMethodBeat.i(163739);
    f(this.vIV);
    this.vIv.a(paramctd, this.vIU, this.vII, this.pmf, x.Ai(this.fVg));
    dmm();
    AppMethodBeat.o(163739);
  }
  
  private void bt(int paramInt, String paramString)
  {
    AppMethodBeat.i(65575);
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (x.Ai(this.fVg)) {
        this.vIl.setVisibility(8);
      }
      AppMethodBeat.o(65575);
      return;
      this.vIl.setVisibility(8);
      continue;
      this.vIl.setVisibility(0);
      this.vIm.setVisibility(0);
      this.vIn.setVisibility(8);
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IRY, "");
      continue;
      if (!bu.isNullOrNil(paramString))
      {
        paramString = k.getEmojiStorageMgr().JfU.aWl(paramString);
        if (paramString == null)
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LuckyMoneyDetailUI", "exchangeThxEmojiState() temp == null");
          AppMethodBeat.o(65575);
          return;
        }
        this.vIA = paramString;
        com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IRY, this.vIA.Lj());
        this.vIo.setEmojiInfo(this.vIA);
        this.vIl.setVisibility(0);
        this.vIm.setVisibility(8);
        this.vIn.setVisibility(0);
      }
    }
  }
  
  private void dmk()
  {
    AppMethodBeat.i(65563);
    ((com.tencent.mm.pluginsdk.j)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.j.class)).a(this, this.fVg, this.vIA.Lj(), getString(2131760956), new y.a()
    {
      public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(163714);
        LuckyMoneyDetailUI.this.hideVKB();
        LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, new dy());
        if (paramAnonymousBoolean)
        {
          LuckyMoneyDetailUI.w(LuckyMoneyDetailUI.this).eeh = 5L;
          LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, new dz());
          paramAnonymousInt = 0;
          if ((LuckyMoneyDetailUI.x(LuckyMoneyDetailUI.this) == 0) || (LuckyMoneyDetailUI.x(LuckyMoneyDetailUI.this) == 2)) {
            if (com.tencent.mm.plugin.emoji.h.b.y(LuckyMoneyDetailUI.y(LuckyMoneyDetailUI.this)))
            {
              paramAnonymousInt = 1;
              LuckyMoneyDetailUI.z(LuckyMoneyDetailUI.this).eiS = paramAnonymousInt;
              dz localdz = LuckyMoneyDetailUI.z(LuckyMoneyDetailUI.this);
              localdz.eiT = localdz.t("emoticonMd5", LuckyMoneyDetailUI.y(LuckyMoneyDetailUI.this).Lj(), true);
              if (!bu.isNullOrNil(paramAnonymousString)) {
                break label299;
              }
              LuckyMoneyDetailUI.z(LuckyMoneyDetailUI.this).eiU = 1L;
              label159:
              LuckyMoneyDetailUI.z(LuckyMoneyDetailUI.this).aLH();
              LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, LuckyMoneyDetailUI.v(LuckyMoneyDetailUI.this), paramAnonymousString, LuckyMoneyDetailUI.y(LuckyMoneyDetailUI.this).Lj());
              LuckyMoneyDetailUI.b(LuckyMoneyDetailUI.this, 3);
              s.a(LuckyMoneyDetailUI.this.getContext().getResources().getString(2131760233), LuckyMoneyDetailUI.this.getContext());
              ar.o(new Runnable()
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
          LuckyMoneyDetailUI.w(LuckyMoneyDetailUI.this).aLH();
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
          label299:
          LuckyMoneyDetailUI.z(LuckyMoneyDetailUI.this).eiU = 2L;
          break label159;
          LuckyMoneyDetailUI.w(LuckyMoneyDetailUI.this).eeh = 6L;
        }
      }
    });
    AppMethodBeat.o(65563);
  }
  
  private boolean dml()
  {
    AppMethodBeat.i(65572);
    if ((!bu.isNullOrNil(this.pMA)) && ((bu.jB(this.vIC.vAI, 1)) || (bu.jB(this.vIC.vAJ, 1))))
    {
      AppMethodBeat.o(65572);
      return true;
    }
    AppMethodBeat.o(65572);
    return false;
  }
  
  private void dmm()
  {
    AppMethodBeat.i(163741);
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.LuckyMoneyDetailUI", "adjust footer");
    this.pPh.post(new Runnable()
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
          com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.LuckyMoneyDetailUI", "winHeight:%s diff:%s recordHeight:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(j) });
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
    return (paraml.dPe == 2) && (this.vHk != 3);
  }
  
  private void f(com.tencent.mm.plugin.luckymoney.model.l paraml)
  {
    AppMethodBeat.i(163740);
    if (paraml.vAH != null)
    {
      paraml = av.aqc(paraml.vAH);
      if ((bu.isNullOrNil(this.vIU)) && (paraml != null) && (paraml.vzN != null)) {
        this.vIU = paraml.vzN.Gta;
      }
      this.vEF = getIntent().getStringExtra("key_detail_envelope_url");
      this.vEG = getIntent().getStringExtra("key_detail_envelope_md5");
      if ((bu.isNullOrNil(this.vEF)) && (paraml != null) && (paraml.vzN != null) && (paraml.vzN.HbB != null))
      {
        this.vEF = paraml.vzN.HbB.HbS;
        this.vEG = paraml.vzN.HbB.HbV;
      }
      if ((!bu.isNullOrNil(this.vEF)) && (!bu.isNullOrNil(this.vEG)))
      {
        this.vIv.hS(this.vEF, this.vEG);
        if (!this.vIx)
        {
          this.vIx = true;
          com.tencent.mm.plugin.luckymoney.a.c.bq(3, this.vEF);
        }
      }
    }
    AppMethodBeat.o(163740);
  }
  
  private static boolean g(com.tencent.mm.plugin.luckymoney.model.l paraml)
  {
    return paraml.vAs == 1;
  }
  
  private void oe(boolean paramBoolean)
  {
    AppMethodBeat.i(65569);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LuckyMoneyDetailUI", "showEmoji() circle:%s", new Object[] { Boolean.TRUE });
    this.vIi.setVisibility(8);
    this.vJb = 1;
    if (paramBoolean) {
      this.vIY = 3;
    }
    do
    {
      this.pOS = k.getEmojiStorageMgr().JfU.aWl(this.pMA);
      if (this.pOS == null) {
        break;
      }
      if ((o.aZR(this.pOS.fSQ()) <= 0L) && (!this.pOS.Ee()) && (!this.pOS.fxr())) {
        break label218;
      }
      this.vIh.setVisibility(0);
      B(this.pOS);
      AppMethodBeat.o(65569);
      return;
      this.vIY -= 1;
    } while (this.vIY != 0);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LuckyMoneyDetailUI", "showEmoji() circle fail!");
    this.vIj.setVisibility(8);
    this.vIi.setVisibility(0);
    this.vJb = 2;
    AppMethodBeat.o(65569);
    return;
    this.pOS = new EmojiInfo();
    this.pOS.field_md5 = this.pMA;
    this.pOS.field_type = this.vIy;
    label218:
    if (paramBoolean)
    {
      this.vIh.setVisibility(8);
      this.vIj.setVisibility(0);
      k.cif().pKA = this.pKA;
    }
    k.cif().u(this.pOS);
    com.tencent.mm.kernel.g.ajQ().gDv.a(697, this.vIZ);
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
    this.vHS = ((RecyclerView)findViewById(2131301770));
    RecyclerView localRecyclerView = this.vHS;
    getContext();
    localRecyclerView.setLayoutManager(new LinearLayoutManager(1));
    this.agn = LayoutInflater.from(this).inflate(2131494635, this.vHS, false);
    this.pPh = LayoutInflater.from(this).inflate(2131494633, this.vHS, false);
    this.vIS = new WxRecyclerAdapter(new com.tencent.mm.view.recyclerview.c()
    {
      public final com.tencent.mm.view.recyclerview.b<?> AX(int paramAnonymousInt)
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
    }, this.vIw, false);
    this.vIS.f(this.agn, 1, false);
    this.vHS.setAdapter(this.vIS);
    this.vHS.a(this.ans);
    this.vwf = ((ImageView)this.agn.findViewById(2131301774));
    this.vwg = ((TextView)this.agn.findViewById(2131301789));
    this.vIu = this.agn.findViewById(2131301787);
    this.vwh = ((ImageView)this.agn.findViewById(2131301757));
    this.uSM = ((TextView)this.agn.findViewById(2131301792));
    this.vIg = ((RelativeLayout)this.agn.findViewById(2131301797));
    this.vIh = ((BaseEmojiView)this.agn.findViewById(2131301793));
    this.vIi = ((TextView)this.agn.findViewById(2131301941));
    this.vIj = ((LinearLayout)this.agn.findViewById(2131301835));
    this.vIk = ((ProgressBar)this.agn.findViewById(2131299385));
    this.vwi = this.agn.findViewById(2131301742);
    this.vvW = ((TextView)this.agn.findViewById(2131301741));
    this.vwj = this.agn.findViewById(2131301759);
    this.mpP = ((TextView)this.agn.findViewById(2131301785));
    this.vHT = ((CdnImageView)this.agn.findViewById(2131301758));
    this.lHT = ((TextView)this.agn.findViewById(2131301748));
    this.vHh = this.agn.findViewById(2131301768);
    this.vHU = this.agn.findViewById(2131301746);
    this.vHV = ((ImageView)this.agn.findViewById(2131301745));
    this.vIl = ((LinearLayout)this.agn.findViewById(2131301948));
    this.vIm = ((LinearLayout)this.agn.findViewById(2131301952));
    this.vIn = ((LinearLayout)this.agn.findViewById(2131301955));
    this.vIo = ((BaseEmojiView)this.agn.findViewById(2131301949));
    this.vIp = ((RelativeLayout)this.agn.findViewById(2131301954));
    this.vIq = ((ImageView)this.agn.findViewById(2131301950));
    this.vHW = ((ViewGroup)this.agn.findViewById(2131301750));
    this.vHX = this.agn.findViewById(2131301749);
    this.vHY = this.agn.findViewById(2131301751);
    this.vHZ = this.agn.findViewById(2131301752);
    this.vId = ((RelativeLayout)this.agn.findViewById(2131301746));
    this.qrQ = ((ImageView)this.agn.findViewById(2131301745));
    this.vIt = ((ImageView)this.agn.findViewById(2131301957));
    this.vIf = ((ViewGroup)findViewById(2131301813));
    this.vIi.setOnClickListener(new LuckyMoneyDetailUI.24(this));
    this.vIr = new a(this);
    this.vIs = getLayoutInflater().inflate(2131494640, null);
    this.vIr.setContentView(this.vIs, new ViewGroup.LayoutParams(-1, -1));
    this.vIs.findViewById(2131301796).setOnClickListener(new LuckyMoneyDetailUI.25(this));
    this.vIr.vGq = new LuckyMoneyDetailUI.26(this);
    this.vIB = ((ViewGroup)this.vIs.findViewById(2131301798));
    if (com.tencent.mm.pluginsdk.ui.chat.e.Fwh == null)
    {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.LuckyMoneyDetailUI", "can't show correctly");
      finish();
      AppMethodBeat.o(65561);
      return;
    }
    this.vIz = com.tencent.mm.pluginsdk.ui.chat.e.Fwh.eE(getContext());
    this.vIz.setTalkerName(this.fVg);
    this.vIz.setShowSmiley(false);
    this.vHT.setUseSdcardCache(true);
    this.vIh.setOnClickListener(new LuckyMoneyDetailUI.2(this));
    this.vIv = ((EnvelopeAppBarLayout)findViewById(2131301805));
    this.vIv.setActivityLifeCycle(this);
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
        if (!bu.isNullOrNil(str)) {
          if ((this.vHn != null) && (this.vHn.startsWith("wxpay://c2cbizmessagehandler/hongbao/festivalhongbao")))
          {
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LuckyMoneyDetailUI", "Not expected branch since 2015 fesitval");
          }
          else
          {
            doSceneProgress(new at(str.replaceAll(",", "|"), this.vHa, "v1.0"));
            continue;
            if (paramInt2 == -1)
            {
              str = "";
              if (paramIntent != null) {
                str = paramIntent.getStringExtra("gif_md5");
              }
              if (!bu.isNullOrNil(str))
              {
                bt(2, str);
                dmk();
              }
              else
              {
                com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LuckyMoneyDetailUI", "md5 == null go emoji capture failed!");
              }
            }
            else
            {
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LuckyMoneyDetailUI", "go emoji capture failed!");
              continue;
              com.tencent.mm.plugin.luckymoney.a.d.tW(8);
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
    //   2: ldc_w 2021
    //   5: invokestatic 207	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: invokestatic 2026	com/tencent/mm/pluginsdk/h:q	(Lcom/tencent/mm/ui/MMActivity;)V
    //   12: aload_0
    //   13: iconst_1
    //   14: invokevirtual 2029	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:customfixStatusbar	(Z)V
    //   17: aload_0
    //   18: iconst_0
    //   19: putfield 2032	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vGZ	Z
    //   22: aload_0
    //   23: invokevirtual 1648	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   26: ldc_w 2034
    //   29: iconst_0
    //   30: invokevirtual 2038	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   33: ifne +13 -> 46
    //   36: aload_0
    //   37: ldc_w 2039
    //   40: ldc_w 2040
    //   43: invokevirtual 1818	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:overridePendingTransition	(II)V
    //   46: aload_0
    //   47: aload_1
    //   48: invokespecial 2042	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBaseUI:onCreate	(Landroid/os/Bundle;)V
    //   51: aload_0
    //   52: invokevirtual 2046	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getWindow	()Landroid/view/Window;
    //   55: invokevirtual 2051	android/view/Window:getDecorView	()Landroid/view/View;
    //   58: sipush 1280
    //   61: invokevirtual 2054	android/view/View:setSystemUiVisibility	(I)V
    //   64: aload_0
    //   65: invokevirtual 2046	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getWindow	()Landroid/view/Window;
    //   68: ldc_w 2055
    //   71: invokevirtual 2058	android/view/Window:setBackgroundDrawableResource	(I)V
    //   74: aload_0
    //   75: aload_0
    //   76: invokevirtual 1648	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   79: ldc_w 2060
    //   82: invokevirtual 1653	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   85: putfield 920	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vII	Ljava/lang/String;
    //   88: aload_0
    //   89: aload_0
    //   90: invokevirtual 1648	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   93: ldc_w 2062
    //   96: iconst_0
    //   97: invokevirtual 2066	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   100: putfield 1525	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:pmf	I
    //   103: aload_0
    //   104: invokevirtual 2070	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getController	()Lcom/tencent/mm/ui/s;
    //   107: iconst_0
    //   108: putfield 2075	com/tencent/mm/ui/s:Jwa	Z
    //   111: aload_0
    //   112: aload_0
    //   113: invokevirtual 409	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getResources	()Landroid/content/res/Resources;
    //   116: ldc_w 2076
    //   119: invokevirtual 863	android/content/res/Resources:getColor	(I)I
    //   122: invokevirtual 2079	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:setActionbarColor	(I)V
    //   125: aload_0
    //   126: invokevirtual 2082	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:hideActionbarLine	()V
    //   129: aload_0
    //   130: aload_0
    //   131: invokevirtual 1648	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   134: ldc_w 2084
    //   137: iconst_0
    //   138: invokevirtual 2038	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   141: putfield 242	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vIH	Z
    //   144: aload_0
    //   145: aload_0
    //   146: invokevirtual 1648	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   149: ldc_w 2086
    //   152: invokevirtual 1653	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   155: putfield 726	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:fVg	Ljava/lang/String;
    //   158: aload_0
    //   159: aload_0
    //   160: invokevirtual 1648	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   163: ldc_w 2088
    //   166: invokevirtual 1653	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   169: putfield 1621	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vHa	Ljava/lang/String;
    //   172: aload_0
    //   173: aload_0
    //   174: invokevirtual 1648	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   177: ldc_w 2090
    //   180: invokevirtual 1653	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   183: putfield 1114	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vHm	Ljava/lang/String;
    //   186: aload_0
    //   187: aload_0
    //   188: invokevirtual 1648	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   191: ldc_w 2092
    //   194: iconst_2
    //   195: invokevirtual 2066	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   198: putfield 801	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vHk	I
    //   201: aload_0
    //   202: aload_0
    //   203: invokevirtual 1648	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   206: ldc_w 2094
    //   209: invokevirtual 1653	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   212: putfield 234	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vHr	Ljava/lang/String;
    //   215: aload_0
    //   216: aload_0
    //   217: invokevirtual 1648	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   220: ldc_w 2096
    //   223: lconst_0
    //   224: invokevirtual 2099	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   227: putfield 1766	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:fIR	J
    //   230: aload_0
    //   231: aload_0
    //   232: invokevirtual 1648	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   235: ldc_w 2101
    //   238: invokevirtual 1653	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   241: putfield 1523	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vIU	Ljava/lang/String;
    //   244: aload_0
    //   245: aload_0
    //   246: invokevirtual 1648	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   249: ldc_w 1650
    //   252: invokevirtual 1653	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   255: putfield 1655	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vEF	Ljava/lang/String;
    //   258: aload_0
    //   259: aload_0
    //   260: invokevirtual 1648	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   263: ldc_w 1657
    //   266: invokevirtual 1653	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   269: putfield 1659	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vEG	Ljava/lang/String;
    //   272: ldc_w 424
    //   275: new 674	java/lang/StringBuilder
    //   278: dup
    //   279: ldc_w 2103
    //   282: invokespecial 679	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   285: aload_0
    //   286: getfield 1621	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vHa	Ljava/lang/String;
    //   289: invokestatic 2106	com/tencent/mm/sdk/platformtools/bu:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   292: invokevirtual 1168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: ldc_w 2108
    //   298: invokevirtual 1168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: aload_0
    //   302: getfield 1114	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vHm	Ljava/lang/String;
    //   305: invokestatic 2106	com/tencent/mm/sdk/platformtools/bu:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   308: invokevirtual 1168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: ldc_w 2110
    //   314: invokevirtual 1168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: aload_0
    //   318: getfield 801	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vHk	I
    //   321: invokevirtual 683	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   324: ldc_w 2112
    //   327: invokevirtual 1168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: aload_0
    //   331: getfield 1523	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vIU	Ljava/lang/String;
    //   334: invokevirtual 1168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: invokevirtual 687	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   340: invokestatic 690	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   343: aload_0
    //   344: getfield 1621	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vHa	Ljava/lang/String;
    //   347: invokestatic 574	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
    //   350: ifeq +32 -> 382
    //   353: aload_0
    //   354: getfield 1114	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vHm	Ljava/lang/String;
    //   357: invokestatic 574	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
    //   360: ifne +22 -> 382
    //   363: aload_0
    //   364: getfield 1114	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vHm	Ljava/lang/String;
    //   367: invokestatic 2118	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   370: astore_1
    //   371: aload_0
    //   372: aload_1
    //   373: ldc_w 2120
    //   376: invokevirtual 2123	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   379: putfield 1621	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vHa	Ljava/lang/String;
    //   382: aload_0
    //   383: aload_0
    //   384: invokevirtual 1648	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   387: ldc_w 2125
    //   390: invokevirtual 1653	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   393: putfield 1591	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:pMA	Ljava/lang/String;
    //   396: aload_0
    //   397: aload_0
    //   398: invokevirtual 1648	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   401: ldc_w 2127
    //   404: iconst_0
    //   405: invokevirtual 2066	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   408: putfield 1722	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vIy	I
    //   411: aload_0
    //   412: getfield 1591	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:pMA	Ljava/lang/String;
    //   415: invokestatic 574	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
    //   418: ifne +32 -> 450
    //   421: aload_0
    //   422: new 349	com/tencent/mm/g/b/a/ea
    //   425: dup
    //   426: invokespecial 350	com/tencent/mm/g/b/a/ea:<init>	()V
    //   429: putfield 352	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vID	Lcom/tencent/mm/g/b/a/ea;
    //   432: aload_0
    //   433: getfield 352	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vID	Lcom/tencent/mm/g/b/a/ea;
    //   436: ldc2_w 2128
    //   439: putfield 355	com/tencent/mm/g/b/a/ea:eeh	J
    //   442: aload_0
    //   443: getfield 352	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vID	Lcom/tencent/mm/g/b/a/ea;
    //   446: invokevirtual 356	com/tencent/mm/g/b/a/ea:aLH	()Z
    //   449: pop
    //   450: aload_0
    //   451: aload_0
    //   452: invokevirtual 1648	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   455: ldc_w 2131
    //   458: invokevirtual 1788	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   461: checkcast 311	com/tencent/mm/plugin/luckymoney/model/LuckyMoneyEmojiSwitch
    //   464: putfield 309	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vIC	Lcom/tencent/mm/plugin/luckymoney/model/LuckyMoneyEmojiSwitch;
    //   467: aload_0
    //   468: getfield 309	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vIC	Lcom/tencent/mm/plugin/luckymoney/model/LuckyMoneyEmojiSwitch;
    //   471: ifnonnull +14 -> 485
    //   474: aload_0
    //   475: new 311	com/tencent/mm/plugin/luckymoney/model/LuckyMoneyEmojiSwitch
    //   478: dup
    //   479: invokespecial 2132	com/tencent/mm/plugin/luckymoney/model/LuckyMoneyEmojiSwitch:<init>	()V
    //   482: putfield 309	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vIC	Lcom/tencent/mm/plugin/luckymoney/model/LuckyMoneyEmojiSwitch;
    //   485: aload_0
    //   486: getfield 1621	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vHa	Ljava/lang/String;
    //   489: invokestatic 2138	com/tencent/mm/plugin/luckymoney/a/b:apU	(Ljava/lang/String;)Lcom/tencent/mm/plugin/luckymoney/model/l;
    //   492: astore_1
    //   493: aload_1
    //   494: ifnull +73 -> 567
    //   497: aload_0
    //   498: aload_1
    //   499: putfield 1517	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vIV	Lcom/tencent/mm/plugin/luckymoney/model/l;
    //   502: aload_0
    //   503: invokevirtual 2140	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:initView	()V
    //   506: aload_0
    //   507: getfield 1517	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vIV	Lcom/tencent/mm/plugin/luckymoney/model/l;
    //   510: ifnonnull +134 -> 644
    //   513: ldc_w 424
    //   516: ldc_w 2142
    //   519: invokestatic 1958	com/tencent/mm/sdk/platformtools/ae:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   522: aload_0
    //   523: invokevirtual 1959	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:finish	()V
    //   526: ldc_w 2021
    //   529: invokestatic 278	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   532: return
    //   533: astore_1
    //   534: ldc_w 424
    //   537: aload_1
    //   538: ldc 232
    //   540: iconst_0
    //   541: anewarray 428	java/lang/Object
    //   544: invokestatic 1319	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   547: invokestatic 2147	com/tencent/mm/sdk/platformtools/ak:getContext	()Landroid/content/Context;
    //   550: ldc_w 2149
    //   553: iconst_0
    //   554: invokestatic 2155	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   557: invokevirtual 2156	android/widget/Toast:show	()V
    //   560: ldc_w 2021
    //   563: invokestatic 278	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   566: return
    //   567: aload_0
    //   568: invokevirtual 1648	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   571: ldc_w 2158
    //   574: invokevirtual 2162	android/content/Intent:getByteArrayExtra	(Ljava/lang/String;)[B
    //   577: astore_1
    //   578: aload_1
    //   579: ifnull +58 -> 637
    //   582: aload_0
    //   583: new 546	com/tencent/mm/plugin/luckymoney/model/l
    //   586: dup
    //   587: invokespecial 2163	com/tencent/mm/plugin/luckymoney/model/l:<init>	()V
    //   590: aload_1
    //   591: invokevirtual 2167	com/tencent/mm/plugin/luckymoney/model/l:parseFrom	([B)Lcom/tencent/mm/bw/a;
    //   594: checkcast 546	com/tencent/mm/plugin/luckymoney/model/l
    //   597: putfield 1517	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vIV	Lcom/tencent/mm/plugin/luckymoney/model/l;
    //   600: goto -98 -> 502
    //   603: astore_1
    //   604: ldc_w 424
    //   607: new 674	java/lang/StringBuilder
    //   610: dup
    //   611: ldc_w 2169
    //   614: invokespecial 679	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   617: aload_1
    //   618: invokevirtual 2172	java/lang/Exception:getLocalizedMessage	()Ljava/lang/String;
    //   621: invokevirtual 1168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   624: invokevirtual 687	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   627: invokestatic 1958	com/tencent/mm/sdk/platformtools/ae:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   630: aload_0
    //   631: invokevirtual 1959	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:finish	()V
    //   634: goto -132 -> 502
    //   637: aload_0
    //   638: invokevirtual 1959	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:finish	()V
    //   641: goto -139 -> 502
    //   644: aload_0
    //   645: getfield 1517	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vIV	Lcom/tencent/mm/plugin/luckymoney/model/l;
    //   648: ifnull +67 -> 715
    //   651: aload_0
    //   652: getfield 1517	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vIV	Lcom/tencent/mm/plugin/luckymoney/model/l;
    //   655: getfield 899	com/tencent/mm/plugin/luckymoney/model/l:vAH	Ljava/lang/String;
    //   658: invokestatic 905	com/tencent/mm/plugin/luckymoney/model/av:aqc	(Ljava/lang/String;)Lcom/tencent/mm/plugin/luckymoney/model/av;
    //   661: astore_1
    //   662: aload_1
    //   663: ifnull +52 -> 715
    //   666: aload_1
    //   667: getfield 912	com/tencent/mm/plugin/luckymoney/model/av:vzN	Lcom/tencent/mm/protocal/protobuf/bom;
    //   670: ifnull +45 -> 715
    //   673: aload_0
    //   674: getfield 1523	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vIU	Ljava/lang/String;
    //   677: invokestatic 574	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
    //   680: ifeq +14 -> 694
    //   683: aload_0
    //   684: aload_1
    //   685: getfield 912	com/tencent/mm/plugin/luckymoney/model/av:vzN	Lcom/tencent/mm/protocal/protobuf/bom;
    //   688: getfield 926	com/tencent/mm/protocal/protobuf/bom:Gta	Ljava/lang/String;
    //   691: putfield 1523	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vIU	Ljava/lang/String;
    //   694: aload_0
    //   695: getfield 920	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vII	Ljava/lang/String;
    //   698: invokestatic 574	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
    //   701: ifeq +14 -> 715
    //   704: aload_0
    //   705: aload_1
    //   706: getfield 912	com/tencent/mm/plugin/luckymoney/model/av:vzN	Lcom/tencent/mm/protocal/protobuf/bom;
    //   709: getfield 923	com/tencent/mm/protocal/protobuf/bom:HbA	Ljava/lang/String;
    //   712: putfield 920	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vII	Ljava/lang/String;
    //   715: aload_0
    //   716: getfield 726	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:fVg	Ljava/lang/String;
    //   719: invokestatic 731	com/tencent/mm/model/x:Ai	(Ljava/lang/String;)Z
    //   722: ifeq +230 -> 952
    //   725: ldc_w 424
    //   728: ldc_w 2174
    //   731: invokestatic 690	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   734: aload_0
    //   735: getfield 1766	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:fIR	J
    //   738: invokestatic 2179	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   741: invokestatic 2182	com/tencent/mm/plugin/luckymoney/a/b:g	(Ljava/lang/Long;)Lcom/tencent/mm/protocal/protobuf/ctc;
    //   744: astore_1
    //   745: aload_1
    //   746: ifnull +11 -> 757
    //   749: aload_0
    //   750: aload_1
    //   751: getfield 2188	com/tencent/mm/protocal/protobuf/ctc:GWv	Lcom/tencent/mm/protocal/protobuf/ctd;
    //   754: invokespecial 2190	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:b	(Lcom/tencent/mm/protocal/protobuf/ctd;)V
    //   757: aload_0
    //   758: aload_0
    //   759: getfield 1517	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vIV	Lcom/tencent/mm/plugin/luckymoney/model/l;
    //   762: invokespecial 2192	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:a	(Lcom/tencent/mm/plugin/luckymoney/model/l;)V
    //   765: aload_0
    //   766: invokevirtual 1648	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   769: ldc_w 2194
    //   772: iconst_0
    //   773: invokevirtual 2038	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   776: ifeq +10 -> 786
    //   779: aload_0
    //   780: getstatic 2200	com/tencent/mm/plugin/luckymoney/ui/k$a:vND	Lcom/tencent/mm/plugin/luckymoney/ui/k$a;
    //   783: invokestatic 2205	com/tencent/mm/plugin/luckymoney/ui/k:a	(Landroid/content/Context;Lcom/tencent/mm/plugin/luckymoney/ui/k$a;)V
    //   786: aload_0
    //   787: getfield 726	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:fVg	Ljava/lang/String;
    //   790: invokestatic 731	com/tencent/mm/model/x:Ai	(Ljava/lang/String;)Z
    //   793: ifne +19 -> 812
    //   796: aload_0
    //   797: iconst_0
    //   798: ldc_w 2206
    //   801: new 2208	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$21
    //   804: dup
    //   805: aload_0
    //   806: invokespecial 2209	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$21:<init>	(Lcom/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI;)V
    //   809: invokevirtual 2213	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:addIconOptionMenu	(IILandroid/view/MenuItem$OnMenuItemClickListener;)V
    //   812: aload_0
    //   813: getfield 801	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vHk	I
    //   816: iconst_4
    //   817: if_icmpeq +11 -> 828
    //   820: aload_0
    //   821: getfield 801	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vHk	I
    //   824: iconst_2
    //   825: if_icmpne +195 -> 1020
    //   828: iconst_1
    //   829: istore_2
    //   830: aload_0
    //   831: getfield 726	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:fVg	Ljava/lang/String;
    //   834: astore_1
    //   835: new 2215	com/tencent/mm/plugin/luckymoney/story/b/e
    //   838: dup
    //   839: invokespecial 2216	com/tencent/mm/plugin/luckymoney/story/b/e:<init>	()V
    //   842: astore 5
    //   844: aload 5
    //   846: aload_0
    //   847: getfield 1621	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vHa	Ljava/lang/String;
    //   850: putfield 2219	com/tencent/mm/plugin/luckymoney/story/b/e:field_send_id	Ljava/lang/String;
    //   853: invokestatic 2225	com/tencent/mm/plugin/luckymoney/b/a:dkG	()Lcom/tencent/mm/plugin/luckymoney/b/a;
    //   856: invokevirtual 2229	com/tencent/mm/plugin/luckymoney/b/a:dkF	()Lcom/tencent/mm/plugin/luckymoney/story/b/f;
    //   859: aload 5
    //   861: iconst_0
    //   862: anewarray 647	java/lang/String
    //   865: invokevirtual 2234	com/tencent/mm/plugin/luckymoney/story/b/f:get	(Lcom/tencent/mm/sdk/e/c;[Ljava/lang/String;)Z
    //   868: istore 4
    //   870: ldc_w 424
    //   873: ldc_w 2236
    //   876: iconst_2
    //   877: anewarray 428	java/lang/Object
    //   880: dup
    //   881: iconst_0
    //   882: iload 4
    //   884: invokestatic 1460	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   887: aastore
    //   888: dup
    //   889: iconst_1
    //   890: aload_0
    //   891: getfield 1621	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vHa	Ljava/lang/String;
    //   894: aastore
    //   895: invokestatic 2238	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   898: iload 4
    //   900: ifeq +146 -> 1046
    //   903: aload 5
    //   905: getfield 2241	com/tencent/mm/plugin/luckymoney/story/b/e:field_open_count	I
    //   908: ifgt +133 -> 1041
    //   911: aload 5
    //   913: aload 5
    //   915: getfield 2241	com/tencent/mm/plugin/luckymoney/story/b/e:field_open_count	I
    //   918: iconst_1
    //   919: iadd
    //   920: putfield 2241	com/tencent/mm/plugin/luckymoney/story/b/e:field_open_count	I
    //   923: invokestatic 2225	com/tencent/mm/plugin/luckymoney/b/a:dkG	()Lcom/tencent/mm/plugin/luckymoney/b/a;
    //   926: invokevirtual 2229	com/tencent/mm/plugin/luckymoney/b/a:dkF	()Lcom/tencent/mm/plugin/luckymoney/story/b/f;
    //   929: aload 5
    //   931: iconst_0
    //   932: anewarray 647	java/lang/String
    //   935: invokevirtual 2244	com/tencent/mm/plugin/luckymoney/story/b/f:update	(Lcom/tencent/mm/sdk/e/c;[Ljava/lang/String;)Z
    //   938: pop
    //   939: iload_2
    //   940: aload_1
    //   941: iload_3
    //   942: invokestatic 2249	com/tencent/mm/plugin/luckymoney/story/a:l	(ILjava/lang/String;I)V
    //   945: ldc_w 2021
    //   948: invokestatic 278	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   951: return
    //   952: aload_0
    //   953: getfield 1523	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vIU	Ljava/lang/String;
    //   956: invokestatic 574	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
    //   959: ifne +53 -> 1012
    //   962: aload_0
    //   963: getfield 1523	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vIU	Ljava/lang/String;
    //   966: invokestatic 2253	com/tencent/mm/plugin/luckymoney/a/b:apV	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/ctd;
    //   969: astore_1
    //   970: aload_1
    //   971: ifnull +35 -> 1006
    //   974: iconst_1
    //   975: istore 4
    //   977: ldc_w 424
    //   980: ldc_w 2255
    //   983: iconst_1
    //   984: anewarray 428	java/lang/Object
    //   987: dup
    //   988: iconst_0
    //   989: iload 4
    //   991: invokestatic 1460	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   994: aastore
    //   995: invokestatic 444	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   998: aload_0
    //   999: aload_1
    //   1000: invokespecial 2190	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:b	(Lcom/tencent/mm/protocal/protobuf/ctd;)V
    //   1003: goto -246 -> 757
    //   1006: iconst_0
    //   1007: istore 4
    //   1009: goto -32 -> 977
    //   1012: aload_0
    //   1013: aconst_null
    //   1014: invokespecial 2190	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:b	(Lcom/tencent/mm/protocal/protobuf/ctd;)V
    //   1017: goto -260 -> 757
    //   1020: aload_0
    //   1021: getfield 801	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vHk	I
    //   1024: iconst_1
    //   1025: if_icmpeq +11 -> 1036
    //   1028: aload_0
    //   1029: getfield 801	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vHk	I
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
    if ((this.vJb == 1) || (this.vJb == 2))
    {
      this.vID = new ea();
      this.vID.eeh = 12L;
      this.vID.aLH();
    }
    if (this.vxj != null)
    {
      this.vxj.release();
      int i = 0;
      while (i < this.vIe.length)
      {
        this.vxj.unload(this.vIe[i]);
        i += 1;
      }
    }
    if (this.vIz != null)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LuckyMoneyDetailUI", "commentfooter release");
      this.vIz.onPause();
      this.vIz.ffs();
      this.vIz.destroy();
    }
    k.cif().pKA = null;
    com.tencent.mm.plugin.luckymoney.a.b.clear();
    com.tencent.mm.plugin.luckymoney.a.c.openId = null;
    com.tencent.mm.plugin.luckymoney.a.c.gpK = null;
    com.tencent.mm.plugin.luckymoney.a.c.vuM = null;
    com.tencent.mm.plugin.luckymoney.a.c.hSG = null;
    com.tencent.mm.plugin.luckymoney.a.c.vuO = 0;
    com.tencent.mm.plugin.luckymoney.a.c.vuN = 0;
    com.tencent.mm.plugin.luckymoney.story.a.tW(1);
    com.tencent.mm.kernel.g.ajQ().gDv.b(697, this.vIZ);
    AppMethodBeat.o(65577);
  }
  
  public void onKeyboardStateChanged()
  {
    AppMethodBeat.i(65564);
    super.onKeyboardStateChanged();
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.LuckyMoneyDetailUI", "keyboard changed: %s", new Object[] { Integer.valueOf(keyboardState()) });
    keyboardState();
    AppMethodBeat.o(65564);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(65560);
    super.onPause();
    com.tencent.mm.modelstat.d.m("LuckyMoneyDetailUI", this.vIW, bu.aRi());
    AppMethodBeat.o(65560);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(65559);
    super.onResume();
    this.vIW = bu.aRi();
    AppMethodBeat.o(65559);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(65566);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LuckyMoneyDetailUI", "onSceneEnd() errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " netsceneType:" + paramn.getType());
    if ((paramn instanceof ah))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (ah)paramn;
        paramn = paramString.vBT;
        this.vHr = paramString.vCf;
        this.pMA = paramString.vCg;
        this.vIy = paramString.vCh;
        this.vIC = paramString.vCi;
        this.vIV = paramn;
        a(this.vIV);
        AppMethodBeat.o(65566);
        return true;
      }
      com.tencent.mm.ui.base.h.cm(this, paramString);
      AppMethodBeat.o(65566);
      return true;
    }
    if ((paramn instanceof ao))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.vvS = false;
        paramString = (ao)paramn;
        if (this.vvQ != null) {
          paramInt1 = 0;
        }
        for (;;)
        {
          if (paramInt1 < this.vvQ.size())
          {
            paramn = (y)this.vvQ.get(paramInt1);
            if (paramn.vAq.equalsIgnoreCase(paramString.vAq))
            {
              paramn.vBH = paramString.vvw;
              this.vIS.asY.notifyChanged();
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
      com.tencent.mm.ui.base.h.cm(this, paramString);
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
      com.tencent.mm.ui.base.h.cm(this, paramString);
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
    public y vJn;
    
    a() {}
    
    public final int bZz()
    {
      return 2;
    }
    
    public final long lP()
    {
      AppMethodBeat.i(163737);
      long l = this.vJn.vAq.hashCode();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI
 * JD-Core Version:    0.7.0.1
 */