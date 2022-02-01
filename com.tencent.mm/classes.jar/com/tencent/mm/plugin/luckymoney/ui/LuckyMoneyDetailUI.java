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
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.api.z.a;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.g.a.ja;
import com.tencent.mm.g.a.ja.b;
import com.tencent.mm.g.b.a.dw;
import com.tencent.mm.g.b.a.dx;
import com.tencent.mm.g.b.a.dy;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bj;
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
import com.tencent.mm.plugin.wallet_core.model.ae;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.pluginsdk.ui.chat.e.b;
import com.tencent.mm.protocal.protobuf.agb;
import com.tencent.mm.protocal.protobuf.bnu;
import com.tencent.mm.protocal.protobuf.bnv;
import com.tencent.mm.protocal.protobuf.cou;
import com.tencent.mm.protocal.protobuf.csj;
import com.tencent.mm.protocal.protobuf.jm;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.vending.g.d.a;
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
  private long fGN;
  private String fTa;
  private int fq;
  private TextView lDu;
  private boolean llo;
  private TextView mkS;
  private c.a pDW;
  private String pFW;
  private View pIC;
  private EmojiInfo pIn;
  private int pfz;
  private ImageView qll;
  private Dialog tipDialog;
  private TextView uGZ;
  private List<y> vjL;
  private boolean vjN;
  private int vjO;
  private TextView vjR;
  private ImageView vka;
  private TextView vkb;
  private ImageView vkc;
  private View vkd;
  private View vke;
  private SoundPool vle;
  private com.tencent.mm.particles.b vmI;
  private int vow;
  private String vsA;
  private String vsB;
  private String vuW;
  private RecyclerView vvO;
  private CdnImageView vvP;
  private View vvQ;
  private ImageView vvR;
  private ViewGroup vvS;
  private View vvT;
  private View vvU;
  private View vvV;
  private TextView vvW;
  private TextView vvX;
  private ViewGroup vvY;
  private RelativeLayout vvZ;
  private View vvd;
  private boolean vvf;
  private int vvg;
  private String vvh;
  private String vvi;
  private String vvj;
  private Map<String, Integer> vvl;
  private String vvn;
  private boolean vvo;
  private dw vwA;
  private dx vwB;
  private int vwC;
  private boolean vwD;
  private String vwE;
  private Bitmap vwF;
  private Bitmap vwG;
  private Bitmap vwH;
  private Bitmap vwI;
  private Bitmap vwJ;
  private Bitmap vwK;
  private Bitmap vwL;
  private Bitmap vwM;
  private boolean vwN;
  private WxRecyclerAdapter vwO;
  private int vwP;
  private String vwQ;
  private com.tencent.mm.plugin.luckymoney.model.l vwR;
  private long vwS;
  private View.OnClickListener vwT;
  private int vwU;
  private com.tencent.mm.al.f vwV;
  private int vwW;
  private int vwX;
  private final int vwY;
  private final int vwZ;
  private int[] vwa;
  private ViewGroup vwb;
  private RelativeLayout vwc;
  private BaseEmojiView vwd;
  private TextView vwe;
  private LinearLayout vwf;
  private ProgressBar vwg;
  private LinearLayout vwh;
  private LinearLayout vwi;
  private LinearLayout vwj;
  private BaseEmojiView vwk;
  private RelativeLayout vwl;
  private ImageView vwm;
  private a vwn;
  private View vwo;
  private ImageView vwp;
  private View vwq;
  private EnvelopeAppBarLayout vwr;
  private ArrayList<a> vws;
  private boolean vwt;
  private int vwu;
  private ChatFooterPanel vwv;
  private EmojiInfo vww;
  private ViewGroup vwx;
  public LuckyMoneyEmojiSwitch vwy;
  private dy vwz;
  
  public LuckyMoneyDetailUI()
  {
    AppMethodBeat.i(65556);
    this.fq = 0;
    this.vvf = true;
    this.llo = false;
    this.vow = -1;
    this.vjL = new LinkedList();
    this.vws = new ArrayList();
    this.vvl = new HashMap();
    this.vvn = "";
    this.vwt = false;
    this.vvo = false;
    this.vwC = 0;
    this.vwD = false;
    this.ans = new RecyclerView.m()
    {
      private boolean vkh = false;
      private boolean vki;
      
      public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(163711);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousRecyclerView);
        localb.mr(paramAnonymousInt1);
        localb.mr(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahq());
        if ((paramAnonymousRecyclerView.getAdapter().getItemCount() == 0) || (!this.vkh))
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
          if (this.vki != bool)
          {
            if (bool) {
              LuckyMoneyDetailUI.this.getResources().getDrawable(2131232950);
            }
            this.vki = bool;
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
        ((com.tencent.mm.hellhoundlib.b.b)localObject).mr(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        if (paramAnonymousRecyclerView.getAdapter().getItemCount() == 0)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
          AppMethodBeat.o(163710);
          return;
        }
        switch (paramAnonymousInt)
        {
        }
        for (this.vkh = true;; this.vkh = false)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
          AppMethodBeat.o(163710);
          return;
          localObject = (LinearLayoutManager)paramAnonymousRecyclerView.getLayoutManager();
          if ((((LinearLayoutManager)localObject).ko() == LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this).size()) || (((LinearLayoutManager)localObject).ko() == paramAnonymousRecyclerView.getAdapter().getItemCount() - 1))
          {
            if (!LuckyMoneyDetailUI.this.vuU.isProcessing()) {
              LuckyMoneyDetailUI.b(LuckyMoneyDetailUI.this);
            }
            if ((LuckyMoneyDetailUI.c(LuckyMoneyDetailUI.this)) && (!LuckyMoneyDetailUI.d(LuckyMoneyDetailUI.this))) {
              LuckyMoneyDetailUI.e(LuckyMoneyDetailUI.this);
            }
          }
        }
      }
    };
    this.vmI = new com.tencent.mm.particles.b()
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
    this.vwN = false;
    this.pDW = new c.a()
    {
      public final void a(final boolean paramAnonymousBoolean, final EmojiInfo paramAnonymousEmojiInfo)
      {
        AppMethodBeat.i(65541);
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(65540);
            if ((paramAnonymousEmojiInfo != null) && (LuckyMoneyDetailUI.n(LuckyMoneyDetailUI.this) != null) && (LuckyMoneyDetailUI.n(LuckyMoneyDetailUI.this).Lb().equals(paramAnonymousEmojiInfo.Lb())))
            {
              if (paramAnonymousBoolean)
              {
                ad.i("MicroMsg.LuckyMoneyDetailUI", "somethings success.");
                LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, k.getEmojiStorageMgr().ILn.aUK(LuckyMoneyDetailUI.n(LuckyMoneyDetailUI.this).Lb()));
                LuckyMoneyDetailUI.o(LuckyMoneyDetailUI.this).setVisibility(8);
                LuckyMoneyDetailUI.p(LuckyMoneyDetailUI.this).setVisibility(0);
                LuckyMoneyDetailUI.b(LuckyMoneyDetailUI.this, LuckyMoneyDetailUI.n(LuckyMoneyDetailUI.this));
                AppMethodBeat.o(65540);
                return;
              }
              ad.i("MicroMsg.LuckyMoneyDetailUI", "somethings error.");
              LuckyMoneyDetailUI.o(LuckyMoneyDetailUI.this).setVisibility(8);
              LuckyMoneyDetailUI.q(LuckyMoneyDetailUI.this).setVisibility(0);
            }
            AppMethodBeat.o(65540);
          }
        });
        AppMethodBeat.o(65541);
      }
    };
    this.vjN = false;
    this.vwS = 0L;
    this.vwT = new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(163720);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, new dw());
        if (bt.jx(paramAnonymousView.getId(), 2131301952))
        {
          LuckyMoneyDetailUI.w(LuckyMoneyDetailUI.this).ecM = 1L;
          LuckyMoneyDetailUI.w(LuckyMoneyDetailUI.this).aLk();
        }
        if ((bt.jx(LuckyMoneyDetailUI.this.vwy.voG, 0)) && (bt.K(paramAnonymousView.getTag(), "nodelete")))
        {
          LuckyMoneyDetailUI.B(LuckyMoneyDetailUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(163720);
          return;
        }
        localObject = new com.tencent.mm.ui.widget.a.e(LuckyMoneyDetailUI.this.getContext(), 1, false);
        ((com.tencent.mm.ui.widget.a.e)localObject).KJy = new n.d()
        {
          public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
          {
            AppMethodBeat.i(163718);
            String str = LuckyMoneyDetailUI.this.getString(2131760952);
            if (!bt.jx(LuckyMoneyDetailUI.this.vwy.voG, 0)) {
              paramAnonymous2l.jI(1, 2131760908);
            }
            for (;;)
            {
              paramAnonymous2l.c(2, str);
              if (!bt.K(paramAnonymousView.getTag(), "nodelete")) {
                paramAnonymous2l.a(3, LuckyMoneyDetailUI.this.getResources().getColor(2131100596), LuckyMoneyDetailUI.this.getContext().getString(2131760844));
              }
              AppMethodBeat.o(163718);
              return;
              str = LuckyMoneyDetailUI.this.getString(2131760858);
            }
          }
        };
        ((com.tencent.mm.ui.widget.a.e)localObject).KJz = new n.e()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(163719);
            ad.i("MicroMsg.LuckyMoneyDetailUI", "showLuckyHbDlg() onMMMenuItemSelected menuItemId:%s", new Object[] { Integer.valueOf(paramAnonymous2MenuItem.getItemId()) });
            switch (paramAnonymous2MenuItem.getItemId())
            {
            }
            for (;;)
            {
              AppMethodBeat.o(163719);
              return;
              com.tencent.mm.plugin.emojicapture.api.b.b(LuckyMoneyDetailUI.this, 5, LuckyMoneyDetailUI.v(LuckyMoneyDetailUI.this));
              LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, new dw());
              LuckyMoneyDetailUI.w(LuckyMoneyDetailUI.this).ecM = 4L;
              LuckyMoneyDetailUI.w(LuckyMoneyDetailUI.this).aLk();
              LuckyMoneyDetailUI.C(LuckyMoneyDetailUI.this);
              AppMethodBeat.o(163719);
              return;
              LuckyMoneyDetailUI.B(LuckyMoneyDetailUI.this);
              AppMethodBeat.o(163719);
              return;
              LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, null);
              LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, new dw());
              LuckyMoneyDetailUI.w(LuckyMoneyDetailUI.this).ecM = 8L;
              LuckyMoneyDetailUI.w(LuckyMoneyDetailUI.this).aLk();
              LuckyMoneyDetailUI.b(LuckyMoneyDetailUI.this, 1);
            }
          }
        };
        LuckyMoneyDetailUI.w(LuckyMoneyDetailUI.this).ecM = 2L;
        LuckyMoneyDetailUI.w(LuckyMoneyDetailUI.this).aLk();
        ((com.tencent.mm.ui.widget.a.e)localObject).cMW();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(163720);
      }
    };
    this.vwU = 3;
    this.vwV = new com.tencent.mm.al.f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(163722);
        if ((bt.jx(paramAnonymousn.getType(), 697)) && ((paramAnonymousn instanceof com.tencent.mm.plugin.emoji.f.e)))
        {
          paramAnonymousString = (com.tencent.mm.plugin.emoji.f.e)paramAnonymousn;
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            paramAnonymousString = paramAnonymousString.chb();
            if ((paramAnonymousString != null) && (paramAnonymousString.FCm != null) && (paramAnonymousString.FCm.size() > 0) && (bt.lQ(((agb)paramAnonymousString.FCm.get(0)).Md5, LuckyMoneyDetailUI.n(LuckyMoneyDetailUI.this).Lb()))) {
              LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, false);
            }
          }
        }
        AppMethodBeat.o(163722);
      }
    };
    this.vwW = 0;
    this.vwX = 0;
    this.vwY = 750;
    this.vwZ = 240;
    AppMethodBeat.o(65556);
  }
  
  private void A(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(65570);
    this.vwX = 3;
    this.vwd.setEmojiInfo(paramEmojiInfo);
    this.vwz = new dy();
    this.vwz.ecM = 11L;
    this.vwz.aLk();
    AppMethodBeat.o(65570);
  }
  
  private static int Jo(int paramInt)
  {
    if (paramInt == 2) {
      return 13;
    }
    return 7;
  }
  
  private void Jq(int paramInt)
  {
    AppMethodBeat.i(65574);
    bu(paramInt, "");
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
      if (djm())
      {
        if (!bool) {}
        if (!djm()) {
          break label1818;
        }
        this.vwc.setVisibility(0);
        nZ(true);
        if ((!bt.jx(this.vwy.voF, 0)) && (e(paraml)) && (this.vwD)) {
          break label1830;
        }
        Jq(0);
        if (paraml.voo != 1) {
          break label1941;
        }
        bool = true;
        this.vvf = bool;
        if (paraml != null)
        {
          if (((paraml.dNN != 3) && (paraml.dNN != 2)) || (paraml.von != 1) || (this.vvf) || (paraml.voq != 1)) {
            break label1947;
          }
          i = 1;
          if ((paraml.vor == null) || (paraml.vor.fYO != 1) || (bt.isNullOrNil(paraml.vor.vnM))) {
            break label1952;
          }
          j = 1;
          this.vvW = ((TextView)this.pIC.findViewById(2131301772));
          if ((i == 0) && (j == 0)) {
            break label1957;
          }
          this.vvW.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(163732);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$25", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
              com.tencent.mm.plugin.report.service.g.yhR.f(11701, new Object[] { Integer.valueOf(LuckyMoneyDetailUI.Jr(paraml.vow)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3) });
              z.a(LuckyMoneyDetailUI.this, 1, false);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$25", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(163732);
            }
          });
          if (j != 0)
          {
            this.vvj = paraml.vor.vnM;
            this.vvW.setText(paraml.vor.vnN);
          }
          com.tencent.mm.plugin.report.service.g.yhR.f(11701, new Object[] { Integer.valueOf(Jo(paraml.vow)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2) });
          this.vvW.setVisibility(0);
          this.vow = paraml.vow;
          this.vvX = ((TextView)this.pIC.findViewById(2131301769));
          this.vvX.setVisibility(8);
          if (!this.vvo)
          {
            this.vwO.aV(this.pIC, 3);
            this.vvo = true;
          }
        }
        if (this.fq == 0)
        {
          this.vvh = paraml.vol;
          localObject1 = this.vvh;
          if ((paraml == null) || (paraml.dNM != 0) || (paraml.vox == null) || (paraml.vox.size() <= 0) || (!((y)paraml.vox.get(0)).vol.equals(localObject1)) || (paraml.vom == 1)) {
            break label1969;
          }
          i = 1;
          if (i == 0) {
            break label1974;
          }
          this.vjN = false;
          this.vvS.setVisibility(8);
          this.vjO = paraml.vow;
          if (paraml != null)
          {
            localObject2 = getContext();
            if (paraml.vow != 2) {
              break label2045;
            }
            this.vka.setImageResource(2131232967);
            if (paraml.resourceId == 0) {
              break label2027;
            }
            ad.i("MicroMsg.LuckyMoneyDetailUI", "busi logo load from file:" + paraml.resourceId);
            localObject1 = new ja();
            ((ja)localObject1).dvK.dvM = paraml.resourceId;
            ((ja)localObject1).callback = new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(163726);
                if (this.vvq.dvL.dvN)
                {
                  ad.i("MicroMsg.LuckyMoneyDetailUI", "Get res Ok, path=" + this.vvq.dvL.dvO);
                  LuckyMoneyDetailUI.this.getContext();
                  z.p(LuckyMoneyDetailUI.K(LuckyMoneyDetailUI.this), this.vvq.dvL.dvO);
                  AppMethodBeat.o(163726);
                  return;
                }
                ad.i("MicroMsg.LuckyMoneyDetailUI", "Get res fail & load from url.");
                z.b(LuckyMoneyDetailUI.K(LuckyMoneyDetailUI.this), paraml.vof, paraml.voz);
                AppMethodBeat.o(163726);
              }
            };
            com.tencent.mm.sdk.b.a.IbL.a((com.tencent.mm.sdk.b.b)localObject1, Looper.myLooper());
            label599:
            if (!w.zy(this.fTa)) {
              break label2086;
            }
            localObject1 = paraml.voe;
            label615:
            i = ((WindowManager)getSystemService("window")).getDefaultDisplay().getWidth();
            j = BackwardSupportUtil.b.g(getContext(), 92.0F);
            this.vkb.setMaxWidth(i - j);
            z.a((Context)localObject2, this.vkb, (String)localObject1);
            z.a((Context)localObject2, this.uGZ, paraml.vjr);
            if (bt.isNullOrNil(paraml.vjr)) {
              break label2109;
            }
            this.uGZ.setVisibility(0);
            label697:
            if (paraml.dNM != 1) {
              break label2121;
            }
            this.vkc.setVisibility(0);
            this.vkc.setImageResource(2131690761);
            label723:
            if (bt.isNullOrNil(paraml.vov)) {
              break label2199;
            }
            ad.i("MicroMsg.LuckyMoneyDetailUI", "hy: has url : %s", new Object[] { paraml.vov });
            this.vvZ.setVisibility(4);
            z.l(this.qll, paraml.vov);
            aq.o(new Runnable()
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
            if ((paraml.dNO != 2) || (this.vvg == 3)) {
              break label2220;
            }
            this.vjR.setText(com.tencent.mm.wallet_core.ui.e.C(paraml.dOa / 100.0D));
            this.vkd.setVisibility(0);
            label829:
            if (bt.isNullOrNil(paraml.vlw)) {
              break label2332;
            }
            this.vke.setVisibility(0);
            this.mkS.setText(paraml.vlw);
            if (!w.zy(this.fTa)) {
              break label2232;
            }
            this.vvP.setVisibility(8);
            this.agn.findViewById(2131301786).setVisibility(8);
            label892:
            if (bt.isNullOrNil(paraml.vop)) {
              break label2353;
            }
            this.lDu.setText(paraml.vop);
            this.vvS.setVisibility(0);
            if ((g(paraml)) && (!e(paraml)))
            {
              this.vvT.setVisibility(8);
              this.vvU.setVisibility(8);
              this.vvV.setVisibility(8);
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
        localObject1 = paraml.vos;
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
            this.vvd.requestLayout();
            this.vvd.setVisibility(0);
          }
        }
        this.vvY = ((ViewGroup)this.pIC.findViewById(2131301756));
        localObject1 = new h.c();
        ((h.c)localObject1).textColor = getResources().getColor(2131099819);
        ((h.c)localObject1).textSize = getResources().getDimensionPixelSize(2131165466);
        h.a(this, this.vvY, paraml.vot, (h.c)localObject1);
        localObject1 = new h.c();
        ((h.c)localObject1).textColor = getResources().getColor(2131099769);
        ((h.c)localObject1).textSize = getResources().getDimensionPixelSize(2131165466);
        if ((paraml.voC != null) && (!w.zy(this.fTa)))
        {
          localObject2 = av.aoX(paraml.voC);
          if ((localObject2 != null) && (((av)localObject2).vqO != null))
          {
            ((h.c)localObject1).vzr = ((av)localObject2).vnI;
            if (((h.c)localObject1).vzr == null)
            {
              ((h.c)localObject1).vzr = new bnu();
              ((h.c)localObject1).vzr.GHY = this.vwE;
            }
            h.a(this, this.vvY, ((av)localObject2).vqO, (h.c)localObject1);
            localObject1 = "";
            if (((av)localObject2).vnI != null) {
              localObject1 = ((av)localObject2).vnI.Gat;
            }
            com.tencent.mm.plugin.report.service.g.yhR.f(16589, new Object[] { Integer.valueOf(1), ((av)localObject2).vqO.content, this.vwE, localObject1, Integer.valueOf(0), com.tencent.mm.plugin.luckymoney.a.c.openId });
          }
        }
      }
      com.tencent.mm.plugin.report.service.g.yhR.f(11701, new Object[] { Integer.valueOf(Jo(paraml.vow)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
      localObject1 = paraml.vox;
      if (localObject1 == null) {
        break label2404;
      }
      i = 0;
      while (i < ((List)localObject1).size())
      {
        localObject2 = (y)((List)localObject1).get(i);
        if (!this.vvl.containsKey(((y)localObject2).vol))
        {
          this.vjL.add(((List)localObject1).get(i));
          localObject3 = new a();
          ((a)localObject3).vxj = ((y)((List)localObject1).get(i));
          this.vws.add(localObject3);
          this.vvl.put(((y)localObject2).vol, Integer.valueOf(1));
        }
        i += 1;
      }
      if (bool) {
        break;
      }
      break;
      if (bool)
      {
        if (djm()) {
          break;
        }
        break;
      }
      djm();
      break;
      label1818:
      this.vwc.setVisibility(8);
      break label63;
      label1830:
      this.vwi.setOnClickListener(this.vwT);
      this.vwi.setTag("nodelete");
      this.vwm.setOnClickListener(this.vwT);
      this.vwp.setOnClickListener(this.vwT);
      this.vwl.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(163715);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, new dw());
          LuckyMoneyDetailUI.w(LuckyMoneyDetailUI.this).ecM = 7L;
          LuckyMoneyDetailUI.w(LuckyMoneyDetailUI.this).aLk();
          LuckyMoneyDetailUI.A(LuckyMoneyDetailUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(163715);
        }
      });
      this.vwk.setOnClickListener(this.vwT);
      localObject1 = (String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IxA, "");
      Jq(1);
      if (bt.isNullOrNil((String)localObject1)) {
        break label97;
      }
      bu(2, (String)localObject1);
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
      this.vvW.setVisibility(8);
      break label324;
      label1969:
      i = 0;
      break label464;
      label1974:
      this.vvS.setVisibility(0);
      if ((!g(paraml)) || (e(paraml))) {
        break label482;
      }
      this.vvT.setVisibility(8);
      this.vvU.setVisibility(8);
      this.vvV.setVisibility(8);
      break label482;
      label2027:
      z.b(this.vka, paraml.vof, paraml.voz);
      break label599;
      label2045:
      if (w.zy(this.fTa))
      {
        this.vka.setImageResource(2131233442);
        break label599;
      }
      z.b(this.vka, paraml.vof, paraml.voz);
      break label599;
      label2086:
      localObject1 = getString(2131760982, new Object[] { paraml.voe });
      break label615;
      label2109:
      this.uGZ.setVisibility(8);
      break label697;
      label2121:
      if (paraml.dNM == 2)
      {
        if (!w.zD(paraml.voz))
        {
          localObject1 = new com.tencent.mm.ak.i();
          ((com.tencent.mm.ak.i)localObject1).username = paraml.voz;
          com.tencent.mm.ak.p.aEx().b((com.tencent.mm.ak.i)localObject1);
        }
        this.vkc.setVisibility(0);
        this.vkc.setImageResource(2131690760);
        break label723;
      }
      this.vkc.setVisibility(8);
      break label723;
      label2199:
      ad.i("MicroMsg.LuckyMoneyDetailUI", "hy: no bg. set bg area to gone");
      this.vvZ.setVisibility(8);
      break label786;
      label2220:
      this.vkd.setVisibility(8);
      break label829;
      label2232:
      if (paraml.vlu == 1)
      {
        ad.i("MicroMsg.LuckyMoneyDetailUI", "changeIconUrl: %s", new Object[] { paraml.voB });
        if (!bt.isNullOrNil(paraml.voB))
        {
          this.vvP.setUrl(paraml.voB);
          this.vvP.setVisibility(0);
        }
        for (;;)
        {
          this.mkS.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(163728);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
              LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, paraml);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(163728);
            }
          });
          break;
          this.vvP.setVisibility(8);
        }
      }
      ad.e("MicroMsg.LuckyMoneyDetailUI", "detail.jumpChange is false");
      break label892;
      label2332:
      ad.e("MicroMsg.LuckyMoneyDetailUI", "detail.changeWording is empty");
      this.vke.setVisibility(8);
      break label892;
      label2353:
      this.lDu.setText(null);
      this.vvS.setVisibility(8);
    }
    this.fq += ((List)localObject1).size();
    this.llo = false;
    this.vwO.asY.notifyChanged();
    label2404:
    if ((paraml.dNM == 2) && (!bt.isNullOrNil(paraml.vod)))
    {
      this.vle = new SoundPool(2, 3, 0);
      this.vwa = new int[2];
    }
    try
    {
      this.vwa[0] = this.vle.load(getResources().getAssets().openFd("most_lucky.m4a"), 0);
      this.vwa[1] = this.vle.load(getResources().getAssets().openFd("whistle.m4a"), 0);
      this.vle.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener()
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
            if ((paramAnonymousInt1 == LuckyMoneyDetailUI.H(LuckyMoneyDetailUI.this)[1]) && (paraml.dOa >= 19000L)) {
              paramAnonymousSoundPool.play(paramAnonymousInt1, 1.0F, 1.0F, 0, 0, 1.0F);
            }
          }
          AppMethodBeat.o(163724);
        }
      });
      this.agn.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(163725);
          LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, (ViewGroup)LuckyMoneyDetailUI.this.findViewById(2131301813));
          Object localObject = LuckyMoneyDetailUI.I(LuckyMoneyDetailUI.this);
          com.tencent.mm.particles.b localb = LuckyMoneyDetailUI.J(LuckyMoneyDetailUI.this);
          com.tencent.mm.particles.a locala = new com.tencent.mm.particles.a((ViewGroup)localObject);
          localObject = new com.tencent.mm.particles.c(((ViewGroup)localObject).getContext(), localb, new com.tencent.mm.particles.d(-100, ((ViewGroup)localObject).getHeight() / 2), (ViewGroup)localObject).C(600.0F, 150.0F).D(-1000.0F, 250.0F).ap(-200.0F).aq(1500.0F);
          ((com.tencent.mm.particles.c)localObject).iJo = 600.0F;
          ((com.tencent.mm.particles.c)localObject).iJp = 300.0F;
          localObject = ((com.tencent.mm.particles.c)localObject).aPE();
          ((com.tencent.mm.particles.c)localObject).iIR = com.tencent.mm.particles.e.aPM();
          locala.gVB = ((com.tencent.mm.particles.c)localObject).aPF().aPG();
          locala.E(100, 400L);
          localObject = LuckyMoneyDetailUI.I(LuckyMoneyDetailUI.this);
          localb = LuckyMoneyDetailUI.J(LuckyMoneyDetailUI.this);
          locala = new com.tencent.mm.particles.a((ViewGroup)localObject);
          localObject = new com.tencent.mm.particles.c(((ViewGroup)localObject).getContext(), localb, new com.tencent.mm.particles.d(((ViewGroup)localObject).getWidth() + 100, ((ViewGroup)localObject).getHeight() / 2), (ViewGroup)localObject).C(-600.0F, 150.0F).D(-1000.0F, 250.0F).ap(200.0F).aq(1500.0F);
          ((com.tencent.mm.particles.c)localObject).iJo = 600.0F;
          ((com.tencent.mm.particles.c)localObject).iJp = 300.0F;
          localObject = ((com.tencent.mm.particles.c)localObject).aPE();
          ((com.tencent.mm.particles.c)localObject).iIR = com.tencent.mm.particles.e.aPM();
          locala.gVB = ((com.tencent.mm.particles.c)localObject).aPF().aPG();
          locala.E(100, 400L);
          AppMethodBeat.o(163725);
        }
      }, 300L);
      if (!w.zy(this.fTa))
      {
        localObject1 = new ae();
        ((ae)localObject1).field_mNativeUrl = this.vvi;
        ((ae)localObject1).field_hbType = paraml.dNM;
        ((ae)localObject1).field_receiveAmount = paraml.dOa;
        ((ae)localObject1).field_receiveTime = System.currentTimeMillis();
        ((ae)localObject1).field_hbStatus = paraml.dNN;
        ((ae)localObject1).field_receiveStatus = paraml.dNO;
        if (((ae)localObject1).field_receiveAmount > 0L) {
          t.eFu().a((ae)localObject1);
        }
      }
      djn();
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
        ad.e("MicroMsg.LuckyMoneyDetailUI", "load lucky money voice fail " + localIOException.getMessage());
      }
    }
  }
  
  private void b(csj paramcsj)
  {
    AppMethodBeat.i(163739);
    f(this.vwR);
    this.vwr.a(paramcsj, this.vwQ, this.vwE, this.pfz, w.zy(this.fTa));
    djn();
    AppMethodBeat.o(163739);
  }
  
  private void bu(int paramInt, String paramString)
  {
    AppMethodBeat.i(65575);
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (w.zy(this.fTa)) {
        this.vwh.setVisibility(8);
      }
      AppMethodBeat.o(65575);
      return;
      this.vwh.setVisibility(8);
      continue;
      this.vwh.setVisibility(0);
      this.vwi.setVisibility(0);
      this.vwj.setVisibility(8);
      com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IxA, "");
      continue;
      if (!bt.isNullOrNil(paramString))
      {
        paramString = k.getEmojiStorageMgr().ILn.aUK(paramString);
        if (paramString == null)
        {
          ad.i("MicroMsg.LuckyMoneyDetailUI", "exchangeThxEmojiState() temp == null");
          AppMethodBeat.o(65575);
          return;
        }
        this.vww = paramString;
        com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IxA, this.vww.Lb());
        this.vwk.setEmojiInfo(this.vww);
        this.vwh.setVisibility(0);
        this.vwi.setVisibility(8);
        this.vwj.setVisibility(0);
      }
    }
  }
  
  private void djl()
  {
    AppMethodBeat.i(65563);
    ((com.tencent.mm.pluginsdk.j)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.j.class)).a(this, this.fTa, this.vww.Lb(), getString(2131760956), new y.a()
    {
      public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(163714);
        LuckyMoneyDetailUI.this.hideVKB();
        LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, new dw());
        if (paramAnonymousBoolean)
        {
          LuckyMoneyDetailUI.w(LuckyMoneyDetailUI.this).ecM = 5L;
          LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, new dx());
          paramAnonymousInt = 0;
          if ((LuckyMoneyDetailUI.x(LuckyMoneyDetailUI.this) == 0) || (LuckyMoneyDetailUI.x(LuckyMoneyDetailUI.this) == 2)) {
            if (com.tencent.mm.plugin.emoji.h.b.y(LuckyMoneyDetailUI.y(LuckyMoneyDetailUI.this)))
            {
              paramAnonymousInt = 1;
              LuckyMoneyDetailUI.z(LuckyMoneyDetailUI.this).ehi = paramAnonymousInt;
              dx localdx = LuckyMoneyDetailUI.z(LuckyMoneyDetailUI.this);
              localdx.ehj = localdx.t("emoticonMd5", LuckyMoneyDetailUI.y(LuckyMoneyDetailUI.this).Lb(), true);
              if (!bt.isNullOrNil(paramAnonymousString)) {
                break label300;
              }
              LuckyMoneyDetailUI.z(LuckyMoneyDetailUI.this).ehk = 1L;
              label159:
              LuckyMoneyDetailUI.z(LuckyMoneyDetailUI.this).aLk();
              LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, LuckyMoneyDetailUI.v(LuckyMoneyDetailUI.this), paramAnonymousString, LuckyMoneyDetailUI.y(LuckyMoneyDetailUI.this).Lb());
              LuckyMoneyDetailUI.b(LuckyMoneyDetailUI.this, 3);
              s.a(LuckyMoneyDetailUI.this.getContext().getResources().getString(2131760233), LuckyMoneyDetailUI.this.getContext(), null);
              aq.o(new Runnable()
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
          LuckyMoneyDetailUI.w(LuckyMoneyDetailUI.this).aLk();
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
          LuckyMoneyDetailUI.z(LuckyMoneyDetailUI.this).ehk = 2L;
          break label159;
          LuckyMoneyDetailUI.w(LuckyMoneyDetailUI.this).ecM = 6L;
        }
      }
    });
    AppMethodBeat.o(65563);
  }
  
  private boolean djm()
  {
    AppMethodBeat.i(65572);
    if ((!bt.isNullOrNil(this.pFW)) && ((bt.jx(this.vwy.voD, 1)) || (bt.jx(this.vwy.voE, 1))))
    {
      AppMethodBeat.o(65572);
      return true;
    }
    AppMethodBeat.o(65572);
    return false;
  }
  
  private void djn()
  {
    AppMethodBeat.i(163741);
    ad.d("MicroMsg.LuckyMoneyDetailUI", "adjust footer");
    this.pIC.post(new Runnable()
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
          ad.d("MicroMsg.LuckyMoneyDetailUI", "winHeight:%s diff:%s recordHeight:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(j) });
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
    return (paraml.dNO == 2) && (this.vvg != 3);
  }
  
  private void f(com.tencent.mm.plugin.luckymoney.model.l paraml)
  {
    AppMethodBeat.i(163740);
    if (paraml.voC != null)
    {
      paraml = av.aoX(paraml.voC);
      if ((bt.isNullOrNil(this.vwQ)) && (paraml != null) && (paraml.vnI != null)) {
        this.vwQ = paraml.vnI.Gat;
      }
      this.vsA = getIntent().getStringExtra("key_detail_envelope_url");
      this.vsB = getIntent().getStringExtra("key_detail_envelope_md5");
      if ((bt.isNullOrNil(this.vsA)) && (paraml != null) && (paraml.vnI != null) && (paraml.vnI.GHZ != null))
      {
        this.vsA = paraml.vnI.GHZ.GIq;
        this.vsB = paraml.vnI.GHZ.GIt;
      }
      if ((!bt.isNullOrNil(this.vsA)) && (!bt.isNullOrNil(this.vsB)))
      {
        this.vwr.hL(this.vsA, this.vsB);
        if (!this.vwt)
        {
          this.vwt = true;
          com.tencent.mm.plugin.luckymoney.a.c.br(3, this.vsA);
        }
      }
    }
    AppMethodBeat.o(163740);
  }
  
  private static boolean g(com.tencent.mm.plugin.luckymoney.model.l paraml)
  {
    return paraml.von == 1;
  }
  
  private void nZ(boolean paramBoolean)
  {
    AppMethodBeat.i(65569);
    ad.i("MicroMsg.LuckyMoneyDetailUI", "showEmoji() circle:%s", new Object[] { Boolean.TRUE });
    this.vwe.setVisibility(8);
    this.vwX = 1;
    if (paramBoolean) {
      this.vwU = 3;
    }
    do
    {
      this.pIn = k.getEmojiStorageMgr().ILn.aUK(this.pFW);
      if (this.pIn == null) {
        break;
      }
      if ((com.tencent.mm.vfs.i.aYo(this.pIn.gzQ()) <= 0L) && (!this.pIn.Eb()) && (!this.pIn.fOy())) {
        break label218;
      }
      this.vwd.setVisibility(0);
      A(this.pIn);
      AppMethodBeat.o(65569);
      return;
      this.vwU -= 1;
    } while (this.vwU != 0);
    ad.i("MicroMsg.LuckyMoneyDetailUI", "showEmoji() circle fail!");
    this.vwf.setVisibility(8);
    this.vwe.setVisibility(0);
    this.vwX = 2;
    AppMethodBeat.o(65569);
    return;
    this.pIn = new EmojiInfo();
    this.pIn.field_md5 = this.pFW;
    this.pIn.field_type = this.vwu;
    label218:
    if (paramBoolean)
    {
      this.vwd.setVisibility(8);
      this.vwf.setVisibility(0);
      k.cgP().pDW = this.pDW;
    }
    k.cgP().u(this.pIn);
    com.tencent.mm.kernel.g.ajB().gAO.a(697, this.vwV);
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
          ad.i("MicroMsg.LuckyMoneyDetailUI", "RealnameGuideHelper dialog click cancel");
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
    this.vvO = ((RecyclerView)findViewById(2131301770));
    RecyclerView localRecyclerView = this.vvO;
    getContext();
    localRecyclerView.setLayoutManager(new LinearLayoutManager(1));
    this.agn = LayoutInflater.from(this).inflate(2131494635, this.vvO, false);
    this.pIC = LayoutInflater.from(this).inflate(2131494633, this.vvO, false);
    this.vwO = new WxRecyclerAdapter(new com.tencent.mm.view.recyclerview.c()
    {
      public final com.tencent.mm.view.recyclerview.b<?> AL(int paramAnonymousInt)
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
    }, this.vws, false);
    this.vwO.f(this.agn, 1, false);
    this.vvO.setAdapter(this.vwO);
    this.vvO.a(this.ans);
    this.vka = ((ImageView)this.agn.findViewById(2131301774));
    this.vkb = ((TextView)this.agn.findViewById(2131301789));
    this.vwq = this.agn.findViewById(2131301787);
    this.vkc = ((ImageView)this.agn.findViewById(2131301757));
    this.uGZ = ((TextView)this.agn.findViewById(2131301792));
    this.vwc = ((RelativeLayout)this.agn.findViewById(2131301797));
    this.vwd = ((BaseEmojiView)this.agn.findViewById(2131301793));
    this.vwe = ((TextView)this.agn.findViewById(2131301941));
    this.vwf = ((LinearLayout)this.agn.findViewById(2131301835));
    this.vwg = ((ProgressBar)this.agn.findViewById(2131299385));
    this.vkd = this.agn.findViewById(2131301742);
    this.vjR = ((TextView)this.agn.findViewById(2131301741));
    this.vke = this.agn.findViewById(2131301759);
    this.mkS = ((TextView)this.agn.findViewById(2131301785));
    this.vvP = ((CdnImageView)this.agn.findViewById(2131301758));
    this.lDu = ((TextView)this.agn.findViewById(2131301748));
    this.vvd = this.agn.findViewById(2131301768);
    this.vvQ = this.agn.findViewById(2131301746);
    this.vvR = ((ImageView)this.agn.findViewById(2131301745));
    this.vwh = ((LinearLayout)this.agn.findViewById(2131301948));
    this.vwi = ((LinearLayout)this.agn.findViewById(2131301952));
    this.vwj = ((LinearLayout)this.agn.findViewById(2131301955));
    this.vwk = ((BaseEmojiView)this.agn.findViewById(2131301949));
    this.vwl = ((RelativeLayout)this.agn.findViewById(2131301954));
    this.vwm = ((ImageView)this.agn.findViewById(2131301950));
    this.vvS = ((ViewGroup)this.agn.findViewById(2131301750));
    this.vvT = this.agn.findViewById(2131301749);
    this.vvU = this.agn.findViewById(2131301751);
    this.vvV = this.agn.findViewById(2131301752);
    this.vvZ = ((RelativeLayout)this.agn.findViewById(2131301746));
    this.qll = ((ImageView)this.agn.findViewById(2131301745));
    this.vwp = ((ImageView)this.agn.findViewById(2131301957));
    this.vwb = ((ViewGroup)findViewById(2131301813));
    this.vwe.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(163735);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, true);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(163735);
      }
    });
    this.vwn = new a(this);
    this.vwo = getLayoutInflater().inflate(2131494640, null);
    this.vwn.setContentView(this.vwo, new ViewGroup.LayoutParams(-1, -1));
    this.vwo.findViewById(2131301796).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(65547);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        LuckyMoneyDetailUI.s(LuckyMoneyDetailUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(65547);
      }
    });
    this.vwn.vum = new a.a()
    {
      public final void dja()
      {
        AppMethodBeat.i(163736);
        LuckyMoneyDetailUI.s(LuckyMoneyDetailUI.this);
        AppMethodBeat.o(163736);
      }
    };
    this.vwx = ((ViewGroup)this.vwo.findViewById(2131301798));
    if (com.tencent.mm.pluginsdk.ui.chat.e.FdJ == null)
    {
      ad.w("MicroMsg.LuckyMoneyDetailUI", "can't show correctly");
      finish();
      AppMethodBeat.o(65561);
      return;
    }
    this.vwv = com.tencent.mm.pluginsdk.ui.chat.e.FdJ.eA(getContext());
    this.vwv.setTalkerName(this.fTa);
    this.vwv.setShowSmiley(false);
    this.vvP.setUseSdcardCache(true);
    this.vwd.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(163712);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        ad.i("MicroMsg.LuckyMoneyDetailUI", "mEmoji click");
        com.tencent.mm.kernel.g.ajD();
        if (!com.tencent.mm.kernel.g.ajC().isSDCardAvailable())
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(163712);
          return;
        }
        if (bt.isNullOrNil(LuckyMoneyDetailUI.t(LuckyMoneyDetailUI.this)))
        {
          ad.e("MicroMsg.LuckyMoneyDetailUI", "mEmojiMd5 == null");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(163712);
          return;
        }
        paramAnonymousView = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().abr(LuckyMoneyDetailUI.t(LuckyMoneyDetailUI.this));
        bu localbu = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().xY(LuckyMoneyDetailUI.u(LuckyMoneyDetailUI.this));
        if ((paramAnonymousView == null) || (paramAnonymousView.Eb()))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(163712);
          return;
        }
        Intent localIntent = new Intent();
        localIntent.putExtra("custom_smiley_preview_md5", LuckyMoneyDetailUI.t(LuckyMoneyDetailUI.this));
        localIntent.putExtra("custom_to_talker_name", localbu.field_talker);
        if ((paramAnonymousView.field_catalog != EmojiGroupInfo.OeM) && (paramAnonymousView.field_catalog != EmojiGroupInfo.OeL) && (paramAnonymousView.field_catalog != EmojiGroupInfo.OeK)) {
          localIntent.putExtra("custom_smiley_preview_productid", paramAnonymousView.field_groupId);
        }
        localIntent.putExtra("msg_id", localbu.field_msgSvrId);
        localIntent.putExtra("msg_content", localbu.field_content);
        localObject = localbu.field_talker;
        paramAnonymousView = (View)localObject;
        if (w.vF((String)localObject))
        {
          paramAnonymousView = bj.Bk(localbu.field_content);
          localIntent.putExtra("room_id", LuckyMoneyDetailUI.v(LuckyMoneyDetailUI.this));
        }
        localIntent.putExtra("msg_sender", paramAnonymousView);
        localIntent.putExtra("scene", 30);
        com.tencent.mm.bs.d.b(LuckyMoneyDetailUI.this, "emoji", ".ui.CustomSmileyPreviewUI", localIntent, 1111);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(163712);
      }
    });
    this.vwr = ((EnvelopeAppBarLayout)findViewById(2131301805));
    this.vwr.setActivityLifeCycle(this);
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
          if ((this.vvj != null) && (this.vvj.startsWith("wxpay://c2cbizmessagehandler/hongbao/festivalhongbao")))
          {
            ad.i("MicroMsg.LuckyMoneyDetailUI", "Not expected branch since 2015 fesitval");
          }
          else
          {
            doSceneProgress(new at(str.replaceAll(",", "|"), this.vuW, "v1.0"));
            continue;
            if (paramInt2 == -1)
            {
              str = "";
              if (paramIntent != null) {
                str = paramIntent.getStringExtra("gif_md5");
              }
              if (!bt.isNullOrNil(str))
              {
                bu(2, str);
                djl();
              }
              else
              {
                ad.i("MicroMsg.LuckyMoneyDetailUI", "md5 == null go emoji capture failed!");
              }
            }
            else
            {
              ad.i("MicroMsg.LuckyMoneyDetailUI", "go emoji capture failed!");
              continue;
              com.tencent.mm.plugin.luckymoney.a.d.tQ(8);
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
    //   2: ldc_w 2023
    //   5: invokestatic 229	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: invokestatic 2028	com/tencent/mm/pluginsdk/h:q	(Lcom/tencent/mm/ui/MMActivity;)V
    //   12: aload_0
    //   13: iconst_1
    //   14: invokevirtual 2031	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:customfixStatusbar	(Z)V
    //   17: aload_0
    //   18: iconst_0
    //   19: putfield 2034	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vuV	Z
    //   22: aload_0
    //   23: invokevirtual 1661	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   26: ldc_w 2036
    //   29: iconst_0
    //   30: invokevirtual 2040	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   33: ifne +13 -> 46
    //   36: aload_0
    //   37: ldc_w 2041
    //   40: ldc_w 2042
    //   43: invokevirtual 1830	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:overridePendingTransition	(II)V
    //   46: aload_0
    //   47: aload_1
    //   48: invokespecial 2044	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBaseUI:onCreate	(Landroid/os/Bundle;)V
    //   51: aload_0
    //   52: invokevirtual 2048	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getWindow	()Landroid/view/Window;
    //   55: invokevirtual 2053	android/view/Window:getDecorView	()Landroid/view/View;
    //   58: sipush 1280
    //   61: invokevirtual 2056	android/view/View:setSystemUiVisibility	(I)V
    //   64: aload_0
    //   65: invokevirtual 2048	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getWindow	()Landroid/view/Window;
    //   68: ldc_w 2057
    //   71: invokevirtual 2060	android/view/Window:setBackgroundDrawableResource	(I)V
    //   74: aload_0
    //   75: aload_0
    //   76: invokevirtual 1661	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   79: ldc_w 2062
    //   82: invokevirtual 1666	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   85: putfield 939	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vwE	Ljava/lang/String;
    //   88: aload_0
    //   89: aload_0
    //   90: invokevirtual 1661	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   93: ldc_w 2064
    //   96: iconst_0
    //   97: invokevirtual 2068	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   100: putfield 1538	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:pfz	I
    //   103: aload_0
    //   104: invokevirtual 2072	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getController	()Lcom/tencent/mm/ui/s;
    //   107: iconst_0
    //   108: putfield 2077	com/tencent/mm/ui/s:Jbs	Z
    //   111: aload_0
    //   112: aload_0
    //   113: invokevirtual 431	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getResources	()Landroid/content/res/Resources;
    //   116: ldc_w 2078
    //   119: invokevirtual 882	android/content/res/Resources:getColor	(I)I
    //   122: invokevirtual 2081	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:setActionbarColor	(I)V
    //   125: aload_0
    //   126: invokevirtual 2084	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:hideActionbarLine	()V
    //   129: aload_0
    //   130: aload_0
    //   131: invokevirtual 1661	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   134: ldc_w 2086
    //   137: iconst_0
    //   138: invokevirtual 2040	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   141: putfield 264	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vwD	Z
    //   144: aload_0
    //   145: aload_0
    //   146: invokevirtual 1661	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   149: ldc_w 2088
    //   152: invokevirtual 1666	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   155: putfield 746	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:fTa	Ljava/lang/String;
    //   158: aload_0
    //   159: aload_0
    //   160: invokevirtual 1661	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   163: ldc_w 2090
    //   166: invokevirtual 1666	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   169: putfield 1634	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vuW	Ljava/lang/String;
    //   172: aload_0
    //   173: aload_0
    //   174: invokevirtual 1661	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   177: ldc_w 2092
    //   180: invokevirtual 1666	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   183: putfield 1129	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vvi	Ljava/lang/String;
    //   186: aload_0
    //   187: aload_0
    //   188: invokevirtual 1661	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   191: ldc_w 2094
    //   194: iconst_2
    //   195: invokevirtual 2068	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   198: putfield 820	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vvg	I
    //   201: aload_0
    //   202: aload_0
    //   203: invokevirtual 1661	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   206: ldc_w 2096
    //   209: invokevirtual 1666	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   212: putfield 256	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vvn	Ljava/lang/String;
    //   215: aload_0
    //   216: aload_0
    //   217: invokevirtual 1661	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   220: ldc_w 2098
    //   223: lconst_0
    //   224: invokevirtual 2101	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   227: putfield 1780	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:fGN	J
    //   230: aload_0
    //   231: aload_0
    //   232: invokevirtual 1661	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   235: ldc_w 2103
    //   238: invokevirtual 1666	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   241: putfield 1536	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vwQ	Ljava/lang/String;
    //   244: aload_0
    //   245: aload_0
    //   246: invokevirtual 1661	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   249: ldc_w 1663
    //   252: invokevirtual 1666	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   255: putfield 1668	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vsA	Ljava/lang/String;
    //   258: aload_0
    //   259: aload_0
    //   260: invokevirtual 1661	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   263: ldc_w 1670
    //   266: invokevirtual 1666	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   269: putfield 1672	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vsB	Ljava/lang/String;
    //   272: ldc_w 446
    //   275: new 694	java/lang/StringBuilder
    //   278: dup
    //   279: ldc_w 2105
    //   282: invokespecial 699	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   285: aload_0
    //   286: getfield 1634	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vuW	Ljava/lang/String;
    //   289: invokestatic 2108	com/tencent/mm/sdk/platformtools/bt:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   292: invokevirtual 1183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: ldc_w 2110
    //   298: invokevirtual 1183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: aload_0
    //   302: getfield 1129	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vvi	Ljava/lang/String;
    //   305: invokestatic 2108	com/tencent/mm/sdk/platformtools/bt:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   308: invokevirtual 1183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: ldc_w 2112
    //   314: invokevirtual 1183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: aload_0
    //   318: getfield 820	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vvg	I
    //   321: invokevirtual 703	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   324: ldc_w 2114
    //   327: invokevirtual 1183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: aload_0
    //   331: getfield 1536	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vwQ	Ljava/lang/String;
    //   334: invokevirtual 1183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: invokevirtual 707	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   340: invokestatic 710	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   343: aload_0
    //   344: getfield 1634	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vuW	Ljava/lang/String;
    //   347: invokestatic 596	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   350: ifeq +32 -> 382
    //   353: aload_0
    //   354: getfield 1129	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vvi	Ljava/lang/String;
    //   357: invokestatic 596	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   360: ifne +22 -> 382
    //   363: aload_0
    //   364: getfield 1129	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vvi	Ljava/lang/String;
    //   367: invokestatic 2120	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   370: astore_1
    //   371: aload_0
    //   372: aload_1
    //   373: ldc_w 2122
    //   376: invokevirtual 2125	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   379: putfield 1634	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vuW	Ljava/lang/String;
    //   382: aload_0
    //   383: aload_0
    //   384: invokevirtual 1661	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   387: ldc_w 2127
    //   390: invokevirtual 1666	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   393: putfield 1604	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:pFW	Ljava/lang/String;
    //   396: aload_0
    //   397: aload_0
    //   398: invokevirtual 1661	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   401: ldc_w 2129
    //   404: iconst_0
    //   405: invokevirtual 2068	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   408: putfield 1735	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vwu	I
    //   411: aload_0
    //   412: getfield 1604	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:pFW	Ljava/lang/String;
    //   415: invokestatic 596	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   418: ifne +32 -> 450
    //   421: aload_0
    //   422: new 317	com/tencent/mm/g/b/a/dy
    //   425: dup
    //   426: invokespecial 318	com/tencent/mm/g/b/a/dy:<init>	()V
    //   429: putfield 320	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vwz	Lcom/tencent/mm/g/b/a/dy;
    //   432: aload_0
    //   433: getfield 320	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vwz	Lcom/tencent/mm/g/b/a/dy;
    //   436: ldc2_w 2130
    //   439: putfield 325	com/tencent/mm/g/b/a/dy:ecM	J
    //   442: aload_0
    //   443: getfield 320	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vwz	Lcom/tencent/mm/g/b/a/dy;
    //   446: invokevirtual 329	com/tencent/mm/g/b/a/dy:aLk	()Z
    //   449: pop
    //   450: aload_0
    //   451: aload_0
    //   452: invokevirtual 1661	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   455: ldc_w 2133
    //   458: invokevirtual 1802	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   461: checkcast 351	com/tencent/mm/plugin/luckymoney/model/LuckyMoneyEmojiSwitch
    //   464: putfield 349	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vwy	Lcom/tencent/mm/plugin/luckymoney/model/LuckyMoneyEmojiSwitch;
    //   467: aload_0
    //   468: getfield 349	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vwy	Lcom/tencent/mm/plugin/luckymoney/model/LuckyMoneyEmojiSwitch;
    //   471: ifnonnull +14 -> 485
    //   474: aload_0
    //   475: new 351	com/tencent/mm/plugin/luckymoney/model/LuckyMoneyEmojiSwitch
    //   478: dup
    //   479: invokespecial 2134	com/tencent/mm/plugin/luckymoney/model/LuckyMoneyEmojiSwitch:<init>	()V
    //   482: putfield 349	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vwy	Lcom/tencent/mm/plugin/luckymoney/model/LuckyMoneyEmojiSwitch;
    //   485: aload_0
    //   486: getfield 1634	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vuW	Ljava/lang/String;
    //   489: invokestatic 2140	com/tencent/mm/plugin/luckymoney/a/b:aoP	(Ljava/lang/String;)Lcom/tencent/mm/plugin/luckymoney/model/l;
    //   492: astore_1
    //   493: aload_1
    //   494: ifnull +73 -> 567
    //   497: aload_0
    //   498: aload_1
    //   499: putfield 1530	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vwR	Lcom/tencent/mm/plugin/luckymoney/model/l;
    //   502: aload_0
    //   503: invokevirtual 2142	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:initView	()V
    //   506: aload_0
    //   507: getfield 1530	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vwR	Lcom/tencent/mm/plugin/luckymoney/model/l;
    //   510: ifnonnull +134 -> 644
    //   513: ldc_w 446
    //   516: ldc_w 2144
    //   519: invokestatic 1962	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   522: aload_0
    //   523: invokevirtual 1963	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:finish	()V
    //   526: ldc_w 2023
    //   529: invokestatic 300	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   532: return
    //   533: astore_1
    //   534: ldc_w 446
    //   537: aload_1
    //   538: ldc 254
    //   540: iconst_0
    //   541: anewarray 450	java/lang/Object
    //   544: invokestatic 1332	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   547: invokestatic 2149	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   550: ldc_w 2151
    //   553: iconst_0
    //   554: invokestatic 2157	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   557: invokevirtual 2158	android/widget/Toast:show	()V
    //   560: ldc_w 2023
    //   563: invokestatic 300	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   566: return
    //   567: aload_0
    //   568: invokevirtual 1661	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   571: ldc_w 2160
    //   574: invokevirtual 2164	android/content/Intent:getByteArrayExtra	(Ljava/lang/String;)[B
    //   577: astore_1
    //   578: aload_1
    //   579: ifnull +58 -> 637
    //   582: aload_0
    //   583: new 568	com/tencent/mm/plugin/luckymoney/model/l
    //   586: dup
    //   587: invokespecial 2165	com/tencent/mm/plugin/luckymoney/model/l:<init>	()V
    //   590: aload_1
    //   591: invokevirtual 2169	com/tencent/mm/plugin/luckymoney/model/l:parseFrom	([B)Lcom/tencent/mm/bx/a;
    //   594: checkcast 568	com/tencent/mm/plugin/luckymoney/model/l
    //   597: putfield 1530	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vwR	Lcom/tencent/mm/plugin/luckymoney/model/l;
    //   600: goto -98 -> 502
    //   603: astore_1
    //   604: ldc_w 446
    //   607: new 694	java/lang/StringBuilder
    //   610: dup
    //   611: ldc_w 2171
    //   614: invokespecial 699	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   617: aload_1
    //   618: invokevirtual 2174	java/lang/Exception:getLocalizedMessage	()Ljava/lang/String;
    //   621: invokevirtual 1183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   624: invokevirtual 707	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   627: invokestatic 1962	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   630: aload_0
    //   631: invokevirtual 1963	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:finish	()V
    //   634: goto -132 -> 502
    //   637: aload_0
    //   638: invokevirtual 1963	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:finish	()V
    //   641: goto -139 -> 502
    //   644: aload_0
    //   645: getfield 1530	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vwR	Lcom/tencent/mm/plugin/luckymoney/model/l;
    //   648: ifnull +67 -> 715
    //   651: aload_0
    //   652: getfield 1530	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vwR	Lcom/tencent/mm/plugin/luckymoney/model/l;
    //   655: getfield 918	com/tencent/mm/plugin/luckymoney/model/l:voC	Ljava/lang/String;
    //   658: invokestatic 924	com/tencent/mm/plugin/luckymoney/model/av:aoX	(Ljava/lang/String;)Lcom/tencent/mm/plugin/luckymoney/model/av;
    //   661: astore_1
    //   662: aload_1
    //   663: ifnull +52 -> 715
    //   666: aload_1
    //   667: getfield 931	com/tencent/mm/plugin/luckymoney/model/av:vnI	Lcom/tencent/mm/protocal/protobuf/bnu;
    //   670: ifnull +45 -> 715
    //   673: aload_0
    //   674: getfield 1536	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vwQ	Ljava/lang/String;
    //   677: invokestatic 596	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   680: ifeq +14 -> 694
    //   683: aload_0
    //   684: aload_1
    //   685: getfield 931	com/tencent/mm/plugin/luckymoney/model/av:vnI	Lcom/tencent/mm/protocal/protobuf/bnu;
    //   688: getfield 945	com/tencent/mm/protocal/protobuf/bnu:Gat	Ljava/lang/String;
    //   691: putfield 1536	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vwQ	Ljava/lang/String;
    //   694: aload_0
    //   695: getfield 939	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vwE	Ljava/lang/String;
    //   698: invokestatic 596	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   701: ifeq +14 -> 715
    //   704: aload_0
    //   705: aload_1
    //   706: getfield 931	com/tencent/mm/plugin/luckymoney/model/av:vnI	Lcom/tencent/mm/protocal/protobuf/bnu;
    //   709: getfield 942	com/tencent/mm/protocal/protobuf/bnu:GHY	Ljava/lang/String;
    //   712: putfield 939	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vwE	Ljava/lang/String;
    //   715: aload_0
    //   716: getfield 746	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:fTa	Ljava/lang/String;
    //   719: invokestatic 751	com/tencent/mm/model/w:zy	(Ljava/lang/String;)Z
    //   722: ifeq +230 -> 952
    //   725: ldc_w 446
    //   728: ldc_w 2176
    //   731: invokestatic 710	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   734: aload_0
    //   735: getfield 1780	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:fGN	J
    //   738: invokestatic 2181	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   741: invokestatic 2184	com/tencent/mm/plugin/luckymoney/a/b:e	(Ljava/lang/Long;)Lcom/tencent/mm/protocal/protobuf/csi;
    //   744: astore_1
    //   745: aload_1
    //   746: ifnull +11 -> 757
    //   749: aload_0
    //   750: aload_1
    //   751: getfield 2190	com/tencent/mm/protocal/protobuf/csi:GCV	Lcom/tencent/mm/protocal/protobuf/csj;
    //   754: invokespecial 2192	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:b	(Lcom/tencent/mm/protocal/protobuf/csj;)V
    //   757: aload_0
    //   758: aload_0
    //   759: getfield 1530	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vwR	Lcom/tencent/mm/plugin/luckymoney/model/l;
    //   762: invokespecial 2194	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:a	(Lcom/tencent/mm/plugin/luckymoney/model/l;)V
    //   765: aload_0
    //   766: invokevirtual 1661	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   769: ldc_w 2196
    //   772: iconst_0
    //   773: invokevirtual 2040	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   776: ifeq +10 -> 786
    //   779: aload_0
    //   780: getstatic 2202	com/tencent/mm/plugin/luckymoney/ui/k$a:vBz	Lcom/tencent/mm/plugin/luckymoney/ui/k$a;
    //   783: invokestatic 2207	com/tencent/mm/plugin/luckymoney/ui/k:a	(Landroid/content/Context;Lcom/tencent/mm/plugin/luckymoney/ui/k$a;)V
    //   786: aload_0
    //   787: getfield 746	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:fTa	Ljava/lang/String;
    //   790: invokestatic 751	com/tencent/mm/model/w:zy	(Ljava/lang/String;)Z
    //   793: ifne +19 -> 812
    //   796: aload_0
    //   797: iconst_0
    //   798: ldc_w 2208
    //   801: new 36	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$21
    //   804: dup
    //   805: aload_0
    //   806: invokespecial 2209	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$21:<init>	(Lcom/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI;)V
    //   809: invokevirtual 2213	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:addIconOptionMenu	(IILandroid/view/MenuItem$OnMenuItemClickListener;)V
    //   812: aload_0
    //   813: getfield 820	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vvg	I
    //   816: iconst_4
    //   817: if_icmpeq +11 -> 828
    //   820: aload_0
    //   821: getfield 820	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vvg	I
    //   824: iconst_2
    //   825: if_icmpne +195 -> 1020
    //   828: iconst_1
    //   829: istore_2
    //   830: aload_0
    //   831: getfield 746	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:fTa	Ljava/lang/String;
    //   834: astore_1
    //   835: new 2215	com/tencent/mm/plugin/luckymoney/story/b/e
    //   838: dup
    //   839: invokespecial 2216	com/tencent/mm/plugin/luckymoney/story/b/e:<init>	()V
    //   842: astore 5
    //   844: aload 5
    //   846: aload_0
    //   847: getfield 1634	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vuW	Ljava/lang/String;
    //   850: putfield 2219	com/tencent/mm/plugin/luckymoney/story/b/e:field_send_id	Ljava/lang/String;
    //   853: invokestatic 2225	com/tencent/mm/plugin/luckymoney/b/a:dhH	()Lcom/tencent/mm/plugin/luckymoney/b/a;
    //   856: invokevirtual 2229	com/tencent/mm/plugin/luckymoney/b/a:dhG	()Lcom/tencent/mm/plugin/luckymoney/story/b/f;
    //   859: aload 5
    //   861: iconst_0
    //   862: anewarray 667	java/lang/String
    //   865: invokevirtual 2234	com/tencent/mm/plugin/luckymoney/story/b/f:get	(Lcom/tencent/mm/sdk/e/c;[Ljava/lang/String;)Z
    //   868: istore 4
    //   870: ldc_w 446
    //   873: ldc_w 2236
    //   876: iconst_2
    //   877: anewarray 450	java/lang/Object
    //   880: dup
    //   881: iconst_0
    //   882: iload 4
    //   884: invokestatic 1473	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   887: aastore
    //   888: dup
    //   889: iconst_1
    //   890: aload_0
    //   891: getfield 1634	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vuW	Ljava/lang/String;
    //   894: aastore
    //   895: invokestatic 2238	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   923: invokestatic 2225	com/tencent/mm/plugin/luckymoney/b/a:dhH	()Lcom/tencent/mm/plugin/luckymoney/b/a;
    //   926: invokevirtual 2229	com/tencent/mm/plugin/luckymoney/b/a:dhG	()Lcom/tencent/mm/plugin/luckymoney/story/b/f;
    //   929: aload 5
    //   931: iconst_0
    //   932: anewarray 667	java/lang/String
    //   935: invokevirtual 2244	com/tencent/mm/plugin/luckymoney/story/b/f:update	(Lcom/tencent/mm/sdk/e/c;[Ljava/lang/String;)Z
    //   938: pop
    //   939: iload_2
    //   940: aload_1
    //   941: iload_3
    //   942: invokestatic 2249	com/tencent/mm/plugin/luckymoney/story/a:l	(ILjava/lang/String;I)V
    //   945: ldc_w 2023
    //   948: invokestatic 300	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   951: return
    //   952: aload_0
    //   953: getfield 1536	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vwQ	Ljava/lang/String;
    //   956: invokestatic 596	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   959: ifne +53 -> 1012
    //   962: aload_0
    //   963: getfield 1536	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vwQ	Ljava/lang/String;
    //   966: invokestatic 2253	com/tencent/mm/plugin/luckymoney/a/b:aoQ	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/csj;
    //   969: astore_1
    //   970: aload_1
    //   971: ifnull +35 -> 1006
    //   974: iconst_1
    //   975: istore 4
    //   977: ldc_w 446
    //   980: ldc_w 2255
    //   983: iconst_1
    //   984: anewarray 450	java/lang/Object
    //   987: dup
    //   988: iconst_0
    //   989: iload 4
    //   991: invokestatic 1473	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   994: aastore
    //   995: invokestatic 466	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   998: aload_0
    //   999: aload_1
    //   1000: invokespecial 2192	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:b	(Lcom/tencent/mm/protocal/protobuf/csj;)V
    //   1003: goto -246 -> 757
    //   1006: iconst_0
    //   1007: istore 4
    //   1009: goto -32 -> 977
    //   1012: aload_0
    //   1013: aconst_null
    //   1014: invokespecial 2192	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:b	(Lcom/tencent/mm/protocal/protobuf/csj;)V
    //   1017: goto -260 -> 757
    //   1020: aload_0
    //   1021: getfield 820	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vvg	I
    //   1024: iconst_1
    //   1025: if_icmpeq +11 -> 1036
    //   1028: aload_0
    //   1029: getfield 820	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:vvg	I
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
    if ((this.vwX == 1) || (this.vwX == 2))
    {
      this.vwz = new dy();
      this.vwz.ecM = 12L;
      this.vwz.aLk();
    }
    if (this.vle != null)
    {
      this.vle.release();
      int i = 0;
      while (i < this.vwa.length)
      {
        this.vle.unload(this.vwa[i]);
        i += 1;
      }
    }
    if (this.vwv != null)
    {
      ad.i("MicroMsg.LuckyMoneyDetailUI", "commentfooter release");
      this.vwv.onPause();
      this.vwv.fbE();
      this.vwv.destroy();
    }
    k.cgP().pDW = null;
    com.tencent.mm.plugin.luckymoney.a.b.clear();
    com.tencent.mm.plugin.luckymoney.a.c.openId = null;
    com.tencent.mm.plugin.luckymoney.a.c.gno = null;
    com.tencent.mm.plugin.luckymoney.a.c.viH = null;
    com.tencent.mm.plugin.luckymoney.a.c.hPO = null;
    com.tencent.mm.plugin.luckymoney.a.c.viJ = 0;
    com.tencent.mm.plugin.luckymoney.a.c.viI = 0;
    com.tencent.mm.plugin.luckymoney.story.a.tQ(1);
    com.tencent.mm.kernel.g.ajB().gAO.b(697, this.vwV);
    AppMethodBeat.o(65577);
  }
  
  public void onKeyboardStateChanged()
  {
    AppMethodBeat.i(65564);
    super.onKeyboardStateChanged();
    ad.d("MicroMsg.LuckyMoneyDetailUI", "keyboard changed: %s", new Object[] { Integer.valueOf(keyboardState()) });
    keyboardState();
    AppMethodBeat.o(65564);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(65560);
    super.onPause();
    com.tencent.mm.modelstat.d.m("LuckyMoneyDetailUI", this.vwS, bt.aQJ());
    AppMethodBeat.o(65560);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(65559);
    super.onResume();
    this.vwS = bt.aQJ();
    AppMethodBeat.o(65559);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(65566);
    ad.i("MicroMsg.LuckyMoneyDetailUI", "onSceneEnd() errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " netsceneType:" + paramn.getType());
    if ((paramn instanceof ah))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (ah)paramn;
        paramn = paramString.vpO;
        this.vvn = paramString.vqa;
        this.pFW = paramString.vqb;
        this.vwu = paramString.vqc;
        this.vwy = paramString.vqd;
        this.vwR = paramn;
        a(this.vwR);
        AppMethodBeat.o(65566);
        return true;
      }
      com.tencent.mm.ui.base.h.cl(this, paramString);
      AppMethodBeat.o(65566);
      return true;
    }
    if ((paramn instanceof ao))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.vjN = false;
        paramString = (ao)paramn;
        if (this.vjL != null) {
          paramInt1 = 0;
        }
        for (;;)
        {
          if (paramInt1 < this.vjL.size())
          {
            paramn = (y)this.vjL.get(paramInt1);
            if (paramn.vol.equalsIgnoreCase(paramString.vol))
            {
              paramn.vpC = paramString.vjr;
              this.vwO.asY.notifyChanged();
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
      com.tencent.mm.ui.base.h.cl(this, paramString);
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
      com.tencent.mm.ui.base.h.cl(this, paramString);
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
    public y vxj;
    
    a() {}
    
    public final int bYk()
    {
      return 2;
    }
    
    public final long lP()
    {
      AppMethodBeat.i(163737);
      long l = this.vxj.vol.hashCode();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI
 * JD-Core Version:    0.7.0.1
 */