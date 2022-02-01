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
import android.support.v7.widget.RecyclerView.l;
import android.text.SpannableStringBuilder;
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
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.p;
import com.tencent.mm.api.ac.a;
import com.tencent.mm.api.r;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.g.a.jq;
import com.tencent.mm.g.a.jq.b;
import com.tencent.mm.g.b.a.hd;
import com.tencent.mm.g.b.a.he;
import com.tencent.mm.g.b.a.hf;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.emoji.model.d.a;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.luckymoney.model.LuckyMoneyEmojiSwitch;
import com.tencent.mm.plugin.luckymoney.model.ad;
import com.tencent.mm.plugin.luckymoney.model.af;
import com.tencent.mm.plugin.luckymoney.model.ax;
import com.tencent.mm.plugin.luckymoney.model.bf;
import com.tencent.mm.plugin.luckymoney.model.bg;
import com.tencent.mm.plugin.luckymoney.model.bh;
import com.tencent.mm.plugin.luckymoney.model.z;
import com.tencent.mm.plugin.luckymoney.story.EnvelopeAppBarLayout;
import com.tencent.mm.plugin.wallet.balance.model.lqt.w;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.ae;
import com.tencent.mm.plugin.wallet_core.ui.q.a;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.pluginsdk.ui.chat.e.b;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.bfb;
import com.tencent.mm.protocal.protobuf.cbe;
import com.tencent.mm.protocal.protobuf.cbf;
import com.tencent.mm.protocal.protobuf.cfl;
import com.tencent.mm.protocal.protobuf.dhn;
import com.tencent.mm.protocal.protobuf.dlt;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.vfs.s;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

@com.tencent.mm.ui.base.a(35)
public class LuckyMoneyDetailUI
  extends LuckyMoneyBaseUI
{
  private View agA;
  RecyclerView.l anE;
  private int fs;
  private String gAn;
  private long gof;
  private TextView jVn;
  private boolean mwr;
  private TextView nAB;
  private int qBv;
  private ImageView rIY;
  private d.a rbg;
  private String rcU;
  private View rfF;
  private EmojiInfo rfq;
  private Dialog tipDialog;
  private List<ad> yQe;
  private boolean yQg;
  private int yQh;
  private TextView yQk;
  private ImageView yQt;
  private TextView yQu;
  private ImageView yQv;
  private View yQw;
  private View yQx;
  private SoundPool yRy;
  private com.tencent.mm.particles.b yTb;
  private String yUc;
  private RelativeLayout yUl;
  private BaseEmojiView yUm;
  private TextView yUn;
  private LinearLayout yUo;
  private ProgressBar yUp;
  private String yUq;
  private int yVv;
  private String yZG;
  private String yZH;
  private TextView yln;
  private int zbZ;
  private RecyclerView zcQ;
  private CdnImageView zcR;
  private View zcS;
  private ImageView zcT;
  private ViewGroup zcU;
  private View zcV;
  private View zcW;
  private View zcX;
  private TextView zcY;
  private TextView zcZ;
  private View zcg;
  private boolean zci;
  private int zcj;
  private String zck;
  private String zcl;
  private Map<String, Integer> zcn;
  private String zcp;
  private boolean zcq;
  private hd zdA;
  private he zdB;
  private int zdC;
  private boolean zdD;
  private String zdE;
  private int zdF;
  private com.tencent.mm.plugin.wallet_core.utils.b zdG;
  private com.tencent.mm.plugin.wallet_core.utils.c zdH;
  private Bitmap zdI;
  private Bitmap zdJ;
  private Bitmap zdK;
  private Bitmap zdL;
  private Bitmap zdM;
  private Bitmap zdN;
  private Bitmap zdO;
  private Bitmap zdP;
  private boolean zdQ;
  private WxRecyclerAdapter zdR;
  private int zdS;
  private String zdT;
  private com.tencent.mm.plugin.luckymoney.model.q zdU;
  private com.tencent.mm.plugin.luckymoney.hk.a.a zdV;
  private long zdW;
  private View.OnClickListener zdX;
  private int zdY;
  private com.tencent.mm.ak.i zdZ;
  private ViewGroup zda;
  private RelativeLayout zdb;
  private int[] zdc;
  private ViewGroup zdd;
  private LinearLayout zde;
  private LinearLayout zdf;
  private LinearLayout zdg;
  private BaseEmojiView zdh;
  private RelativeLayout zdi;
  private ImageView zdj;
  private a zdk;
  private View zdl;
  private ImageView zdm;
  private View zdn;
  private ViewGroup zdo;
  private TextView zdp;
  private ImageView zdq;
  private EnvelopeAppBarLayout zdr;
  private ArrayList<a> zds;
  private boolean zdt;
  private int zdu;
  private ChatFooterPanel zdv;
  private EmojiInfo zdw;
  private ViewGroup zdx;
  public LuckyMoneyEmojiSwitch zdy;
  private hf zdz;
  private int zea;
  private int zeb;
  private final int zec;
  private final int zed;
  
  public LuckyMoneyDetailUI()
  {
    AppMethodBeat.i(65556);
    this.fs = 0;
    this.zci = true;
    this.mwr = false;
    this.yVv = -1;
    this.yQe = new LinkedList();
    this.zds = new ArrayList();
    this.zcn = new HashMap();
    this.zcp = "";
    this.zdt = false;
    this.zcq = false;
    this.zdC = 0;
    this.zdD = false;
    this.anE = new RecyclerView.l()
    {
      private boolean yQA = false;
      private boolean yQB;
      
      public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(163710);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousRecyclerView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).pH(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        if (paramAnonymousRecyclerView.getAdapter().getItemCount() == 0)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
          AppMethodBeat.o(163710);
          return;
        }
        switch (paramAnonymousInt)
        {
        }
        for (this.yQA = true;; this.yQA = false)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
          AppMethodBeat.o(163710);
          return;
          localObject = (LinearLayoutManager)paramAnonymousRecyclerView.getLayoutManager();
          if ((((LinearLayoutManager)localObject).ku() == LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this).size()) || (((LinearLayoutManager)localObject).ku() == paramAnonymousRecyclerView.getAdapter().getItemCount() - 1))
          {
            if (!LuckyMoneyDetailUI.this.zbX.isProcessing()) {
              LuckyMoneyDetailUI.b(LuckyMoneyDetailUI.this);
            }
            if ((LuckyMoneyDetailUI.c(LuckyMoneyDetailUI.this)) && (!LuckyMoneyDetailUI.d(LuckyMoneyDetailUI.this))) {
              LuckyMoneyDetailUI.e(LuckyMoneyDetailUI.this);
            }
          }
        }
      }
      
      public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(163711);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousRecyclerView);
        localb.pH(paramAnonymousInt1);
        localb.pH(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.axR());
        if ((paramAnonymousRecyclerView.getAdapter().getItemCount() == 0) || (!this.yQA))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
          AppMethodBeat.o(163711);
          return;
        }
        paramAnonymousRecyclerView = (LinearLayoutManager)paramAnonymousRecyclerView.getLayoutManager();
        boolean bool;
        if (paramAnonymousRecyclerView.ks() > 0)
        {
          bool = true;
          if (this.yQB != bool)
          {
            if (bool) {
              LuckyMoneyDetailUI.this.getResources().getDrawable(2131233600);
            }
            this.yQB = bool;
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
          AppMethodBeat.o(163711);
          return;
        }
        paramAnonymousRecyclerView = paramAnonymousRecyclerView.findViewByPosition(paramAnonymousRecyclerView.ks());
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
    };
    this.yTb = new com.tencent.mm.particles.b()
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
            LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, 2131233660));
          }
          paramAnonymousRandom = new com.tencent.mm.particles.a.a(LuckyMoneyDetailUI.f(LuckyMoneyDetailUI.this));
          AppMethodBeat.o(65527);
          return paramAnonymousRandom;
        case 1: 
          if (LuckyMoneyDetailUI.g(LuckyMoneyDetailUI.this) == null) {
            LuckyMoneyDetailUI.b(LuckyMoneyDetailUI.this, LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, 2131233661));
          }
          paramAnonymousRandom = new com.tencent.mm.particles.a.a(LuckyMoneyDetailUI.g(LuckyMoneyDetailUI.this));
          AppMethodBeat.o(65527);
          return paramAnonymousRandom;
        case 2: 
          if (LuckyMoneyDetailUI.h(LuckyMoneyDetailUI.this) == null) {
            LuckyMoneyDetailUI.c(LuckyMoneyDetailUI.this, LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, 2131233662));
          }
          paramAnonymousRandom = new com.tencent.mm.particles.a.a(LuckyMoneyDetailUI.h(LuckyMoneyDetailUI.this));
          AppMethodBeat.o(65527);
          return paramAnonymousRandom;
        case 3: 
          if (LuckyMoneyDetailUI.i(LuckyMoneyDetailUI.this) == null) {
            LuckyMoneyDetailUI.d(LuckyMoneyDetailUI.this, LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, 2131233655));
          }
          paramAnonymousRandom = new com.tencent.mm.particles.a.a(LuckyMoneyDetailUI.i(LuckyMoneyDetailUI.this));
          AppMethodBeat.o(65527);
          return paramAnonymousRandom;
        case 4: 
          if (LuckyMoneyDetailUI.j(LuckyMoneyDetailUI.this) == null) {
            LuckyMoneyDetailUI.e(LuckyMoneyDetailUI.this, LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, 2131233656));
          }
          paramAnonymousRandom = new com.tencent.mm.particles.a.a(LuckyMoneyDetailUI.j(LuckyMoneyDetailUI.this));
          AppMethodBeat.o(65527);
          return paramAnonymousRandom;
        case 5: 
          if (LuckyMoneyDetailUI.k(LuckyMoneyDetailUI.this) == null) {
            LuckyMoneyDetailUI.f(LuckyMoneyDetailUI.this, LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, 2131233657));
          }
          paramAnonymousRandom = new com.tencent.mm.particles.a.a(LuckyMoneyDetailUI.k(LuckyMoneyDetailUI.this));
          AppMethodBeat.o(65527);
          return paramAnonymousRandom;
        case 6: 
          if (LuckyMoneyDetailUI.l(LuckyMoneyDetailUI.this) == null) {
            LuckyMoneyDetailUI.g(LuckyMoneyDetailUI.this, LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, 2131233658));
          }
          paramAnonymousRandom = new com.tencent.mm.particles.a.a(LuckyMoneyDetailUI.l(LuckyMoneyDetailUI.this));
          AppMethodBeat.o(65527);
          return paramAnonymousRandom;
        }
        if (LuckyMoneyDetailUI.m(LuckyMoneyDetailUI.this) == null) {
          LuckyMoneyDetailUI.h(LuckyMoneyDetailUI.this, LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, 2131233659));
        }
        paramAnonymousRandom = new com.tencent.mm.particles.a.a(LuckyMoneyDetailUI.m(LuckyMoneyDetailUI.this));
        AppMethodBeat.o(65527);
        return paramAnonymousRandom;
      }
    };
    this.zdQ = false;
    this.rbg = new d.a()
    {
      public final void a(final boolean paramAnonymousBoolean, final EmojiInfo paramAnonymousEmojiInfo)
      {
        AppMethodBeat.i(65541);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(65540);
            if ((paramAnonymousEmojiInfo != null) && (LuckyMoneyDetailUI.n(LuckyMoneyDetailUI.this) != null) && (LuckyMoneyDetailUI.n(LuckyMoneyDetailUI.this).getMd5().equals(paramAnonymousEmojiInfo.getMd5())))
            {
              if (paramAnonymousBoolean)
              {
                Log.i("MicroMsg.LuckyMoneyDetailUI", "somethings success.");
                LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, k.getEmojiStorageMgr().OpN.blk(LuckyMoneyDetailUI.n(LuckyMoneyDetailUI.this).getMd5()));
                LuckyMoneyDetailUI.o(LuckyMoneyDetailUI.this).setVisibility(8);
                LuckyMoneyDetailUI.p(LuckyMoneyDetailUI.this).setVisibility(0);
                LuckyMoneyDetailUI.b(LuckyMoneyDetailUI.this, LuckyMoneyDetailUI.n(LuckyMoneyDetailUI.this));
                AppMethodBeat.o(65540);
                return;
              }
              Log.i("MicroMsg.LuckyMoneyDetailUI", "somethings error.");
              LuckyMoneyDetailUI.o(LuckyMoneyDetailUI.this).setVisibility(8);
              LuckyMoneyDetailUI.q(LuckyMoneyDetailUI.this).setVisibility(0);
            }
            AppMethodBeat.o(65540);
          }
        });
        AppMethodBeat.o(65541);
      }
    };
    this.yQg = false;
    this.zdW = 0L;
    this.zdX = new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(65521);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, new hd());
        if (Util.isEqual(paramAnonymousView.getId(), 2131304277))
        {
          LuckyMoneyDetailUI.z(LuckyMoneyDetailUI.this).eEH = 1L;
          LuckyMoneyDetailUI.z(LuckyMoneyDetailUI.this).bfK();
        }
        if ((Util.isEqual(LuckyMoneyDetailUI.this.zdy.yVJ, 0)) && (Util.isEqual(paramAnonymousView.getTag(), "nodelete")))
        {
          LuckyMoneyDetailUI.E(LuckyMoneyDetailUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(65521);
          return;
        }
        localObject = new com.tencent.mm.ui.widget.a.e(LuckyMoneyDetailUI.this.getContext(), 1, false);
        ((com.tencent.mm.ui.widget.a.e)localObject).HLX = new o.f()
        {
          public final void onCreateMMMenu(m paramAnonymous2m)
          {
            AppMethodBeat.i(213361);
            String str = LuckyMoneyDetailUI.this.getString(2131762726);
            if (!Util.isEqual(LuckyMoneyDetailUI.this.zdy.yVJ, 0)) {
              paramAnonymous2m.kV(1, 2131762682);
            }
            for (;;)
            {
              paramAnonymous2m.d(2, str);
              if (!Util.isEqual(paramAnonymousView.getTag(), "nodelete")) {
                paramAnonymous2m.a(3, LuckyMoneyDetailUI.this.getResources().getColor(2131100764), LuckyMoneyDetailUI.this.getContext().getString(2131762601));
              }
              AppMethodBeat.o(213361);
              return;
              str = LuckyMoneyDetailUI.this.getString(2131762626);
            }
          }
        };
        ((com.tencent.mm.ui.widget.a.e)localObject).HLY = new o.g()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(213362);
            Log.i("MicroMsg.LuckyMoneyDetailUI", "showLuckyHbDlg() onMMMenuItemSelected menuItemId:%s", new Object[] { Integer.valueOf(paramAnonymous2MenuItem.getItemId()) });
            switch (paramAnonymous2MenuItem.getItemId())
            {
            }
            for (;;)
            {
              AppMethodBeat.o(213362);
              return;
              com.tencent.mm.plugin.emojicapture.api.b.b(LuckyMoneyDetailUI.this, 5, LuckyMoneyDetailUI.s(LuckyMoneyDetailUI.this));
              LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, new hd());
              LuckyMoneyDetailUI.z(LuckyMoneyDetailUI.this).eEH = 4L;
              LuckyMoneyDetailUI.z(LuckyMoneyDetailUI.this).bfK();
              LuckyMoneyDetailUI.F(LuckyMoneyDetailUI.this);
              AppMethodBeat.o(213362);
              return;
              LuckyMoneyDetailUI.E(LuckyMoneyDetailUI.this);
              AppMethodBeat.o(213362);
              return;
              LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, null);
              LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, new hd());
              LuckyMoneyDetailUI.z(LuckyMoneyDetailUI.this).eEH = 8L;
              LuckyMoneyDetailUI.z(LuckyMoneyDetailUI.this).bfK();
              LuckyMoneyDetailUI.b(LuckyMoneyDetailUI.this, 1);
            }
          }
        };
        LuckyMoneyDetailUI.z(LuckyMoneyDetailUI.this).eEH = 2L;
        LuckyMoneyDetailUI.z(LuckyMoneyDetailUI.this).bfK();
        ((com.tencent.mm.ui.widget.a.e)localObject).dGm();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(65521);
      }
    };
    this.zdY = 3;
    this.zdZ = new LuckyMoneyDetailUI.9(this);
    this.zea = 0;
    this.zeb = 0;
    this.zec = 750;
    this.zed = 240;
    AppMethodBeat.o(65556);
  }
  
  private void A(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(65570);
    this.zeb = 3;
    this.yUm.setEmojiInfo(paramEmojiInfo);
    this.zdz = new hf();
    this.zdz.eEH = 11L;
    this.zdz.bfK();
    AppMethodBeat.o(65570);
  }
  
  private static int PP(int paramInt)
  {
    if (paramInt == 2) {
      return 13;
    }
    return 7;
  }
  
  private void PR(int paramInt)
  {
    AppMethodBeat.i(65574);
    bF(paramInt, "");
    AppMethodBeat.o(65574);
  }
  
  private void a(final com.tencent.mm.plugin.luckymoney.model.q paramq)
  {
    AppMethodBeat.i(65573);
    if (paramq == null)
    {
      AppMethodBeat.o(65573);
      return;
    }
    boolean bool = e(paramq);
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
    label600:
    Object localObject3;
    if (g(paramq)) {
      if (egg())
      {
        if (!bool) {}
        if (!egg()) {
          break label2058;
        }
        this.yUl.setVisibility(0);
        qM(true);
        if ((!Util.isEqual(this.zdy.yVI, 0)) && (e(paramq)) && (this.zdD)) {
          break label2070;
        }
        PR(0);
        if (paramq.yVn != 1) {
          break label2181;
        }
        bool = true;
        this.zci = bool;
        if (paramq != null)
        {
          if (((paramq.egZ != 3) && (paramq.egZ != 2)) || (paramq.yVm != 1) || (this.zci) || (paramq.yVp != 1)) {
            break label2187;
          }
          i = 1;
          if ((paramq.yVq == null) || (paramq.yVq.gGn != 1) || (Util.isNullOrNil(paramq.yVq.yUG))) {
            break label2192;
          }
          j = 1;
          this.zcY = ((TextView)this.rfF.findViewById(2131304075));
          if ((i == 0) && (j == 0)) {
            break label2197;
          }
          this.zcY.setOnClickListener(new LuckyMoneyDetailUI.25(this, paramq));
          if (j != 0)
          {
            this.zcl = paramq.yVq.yUG;
            this.zcY.setText(paramq.yVq.yUH);
          }
          com.tencent.mm.plugin.report.service.h.CyF.a(11701, new Object[] { Integer.valueOf(PP(paramq.yVv)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2) });
          this.zcY.setVisibility(0);
          this.yVv = paramq.yVv;
          this.zcZ = ((TextView)this.rfF.findViewById(2131304072));
          this.zcZ.setVisibility(8);
          if (!this.zcq)
          {
            this.zdR.g(this.rfF, 3, false);
            this.zcq = true;
          }
        }
        if (this.fs == 0)
        {
          this.zck = paramq.yVk;
          localObject1 = this.zck;
          if ((paramq == null) || (paramq.egY != 0) || (paramq.yVw == null) || (paramq.yVw.size() <= 0) || (!((ad)paramq.yVw.get(0)).yVk.equals(localObject1)) || (paramq.yVl == 1)) {
            break label2209;
          }
          i = 1;
          if (i == 0) {
            break label2214;
          }
          this.yQg = false;
          this.zcU.setVisibility(8);
          this.yQh = paramq.yVv;
          if (paramq != null)
          {
            localObject2 = getContext();
            if (paramq.yVv != 2) {
              break label2285;
            }
            this.yQt.setImageResource(2131233617);
            if (paramq.resourceId == 0) {
              break label2267;
            }
            Log.i("MicroMsg.LuckyMoneyDetailUI", "busi logo load from file:" + paramq.resourceId);
            localObject1 = new jq();
            ((jq)localObject1).dOw.dOy = paramq.resourceId;
            ((jq)localObject1).callback = new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(213371);
                if (this.zcs.dOx.dOz)
                {
                  Log.i("MicroMsg.LuckyMoneyDetailUI", "Get res Ok, path=" + this.zcs.dOx.dOA);
                  LuckyMoneyDetailUI.this.getContext();
                  af.s(LuckyMoneyDetailUI.P(LuckyMoneyDetailUI.this), this.zcs.dOx.dOA);
                  AppMethodBeat.o(213371);
                  return;
                }
                Log.i("MicroMsg.LuckyMoneyDetailUI", "Get res fail & load from url.");
                af.a(LuckyMoneyDetailUI.P(LuckyMoneyDetailUI.this), paramq.yVe, paramq.yVy);
                AppMethodBeat.o(213371);
              }
            };
            EventCenter.instance.asyncPublish((IEvent)localObject1, Looper.myLooper());
            if (Util.isNullOrNil(paramq.yVF)) {
              break label2369;
            }
            Log.i("MicroMsg.LuckyMoneyDetailUI", "use union sendername");
            if (!ab.IN(this.gAn)) {
              break label2326;
            }
            localObject1 = paramq.yVd + paramq.yVF;
            label655:
            i = ((WindowManager)getSystemService("window")).getDefaultDisplay().getWidth();
            j = BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 92.0F);
            this.yQu.setMaxWidth(i - j);
            localObject3 = l.b(getContext(), (CharSequence)localObject1, this.yQu.getTextSize());
            l.b(getContext(), paramq.yVd, this.yQu.getTextSize());
            l.b(getContext(), paramq.yVF, this.yQu.getTextSize());
            localObject3 = new SpannableStringBuilder((CharSequence)localObject3);
            ((SpannableStringBuilder)localObject3).setSpan(new com.tencent.mm.plugin.wallet_core.ui.q("#FA9D3B", new LuckyMoneyDetailUI.18(this)), ((String)localObject1).lastIndexOf(paramq.yVF), ((String)localObject1).lastIndexOf(paramq.yVF) + paramq.yVF.length(), 18);
            this.yQu.setText((CharSequence)localObject3);
            af.a((Context)localObject2, this.yln, paramq.yPK);
            if (Util.isNullOrNil(paramq.yPK)) {
              break label2471;
            }
            this.yln.setVisibility(0);
            label853:
            if (paramq.egY != 1) {
              break label2483;
            }
            this.yQv.setVisibility(0);
            this.yQv.setImageResource(2131691045);
            label879:
            if (Util.isNullOrNil(paramq.yVu)) {
              break label2561;
            }
            Log.i("MicroMsg.LuckyMoneyDetailUI", "hy: has url : %s", new Object[] { paramq.yVu });
            this.zdb.setVisibility(4);
            af.o(this.rIY, paramq.yVu);
            MMHandlerThread.postToMainThreadDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(163733);
                LuckyMoneyDetailUI.Q(LuckyMoneyDetailUI.this);
                LuckyMoneyDetailUI.R(LuckyMoneyDetailUI.this).setVisibility(0);
                AppMethodBeat.o(163733);
              }
            }, 500L);
            label942:
            if ((paramq.eha != 2) || (this.zcj == 3)) {
              break label2582;
            }
            this.yQk.setText(com.tencent.mm.wallet_core.ui.f.formatMoney2f(paramq.eht / 100.0D));
            this.yQw.setVisibility(0);
            label985:
            if (Util.isNullOrNil(paramq.yVC)) {
              break label2594;
            }
            this.zdo.setVisibility(0);
            this.zdp.setText(paramq.yVC);
            this.zdq.setOnClickListener(new LuckyMoneyDetailUI.20(this));
            localObject1 = (ViewGroup.MarginLayoutParams)this.yQx.getLayoutParams();
            if (localObject1 != null)
            {
              ((ViewGroup.MarginLayoutParams)localObject1).topMargin = com.tencent.mm.cb.a.fromDPToPix(getContext(), 16);
              this.yQx.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            }
            label1069:
            if (Util.isNullOrNil(paramq.yRP)) {
              break label2706;
            }
            this.yQx.setVisibility(0);
            this.nAB.setText(paramq.yRP);
            if (!ab.IN(this.gAn)) {
              break label2606;
            }
            this.zcR.setVisibility(8);
            this.agA.findViewById(2131304091).setVisibility(8);
            label1132:
            if (Util.isNullOrNil(paramq.yVo)) {
              break label2727;
            }
            this.jVn.setText(paramq.yVo);
            this.zcU.setVisibility(0);
            if ((g(paramq)) && (!e(paramq)))
            {
              this.zcV.setVisibility(8);
              this.zcW.setVisibility(8);
              this.zcX.setVisibility(8);
            }
          }
        }
      }
    }
    for (;;)
    {
      if (paramq != null)
      {
        localObject1 = paramq.yVr;
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          localObject2 = this.agA.findViewById(2131304068);
          localObject3 = this.agA.findViewById(2131304069);
          View localView1 = this.agA.findViewById(2131304070);
          ViewGroup localViewGroup1 = (ViewGroup)this.agA.findViewById(2131304065);
          ViewGroup localViewGroup2 = (ViewGroup)this.agA.findViewById(2131304066);
          ViewGroup localViewGroup3 = (ViewGroup)this.agA.findViewById(2131304067);
          View localView2 = this.agA.findViewById(2131304056);
          View localView3 = this.agA.findViewById(2131304057);
          i.c localc = new i.c();
          localc.textColor = getResources().getColor(2131100747);
          if (((List)localObject1).size() > 0)
          {
            i.a(this, localViewGroup1, (bg)((List)localObject1).get(0), localc);
            ((View)localObject2).setVisibility(0);
          }
          if (((List)localObject1).size() > 1)
          {
            i.a(this, localViewGroup2, (bg)((List)localObject1).get(1), localc);
            ((View)localObject3).setVisibility(0);
          }
          if (((List)localObject1).size() > 2)
          {
            i.a(this, localViewGroup3, (bg)((List)localObject1).get(2), localc);
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
            this.zcg.requestLayout();
            this.zcg.setVisibility(0);
          }
        }
        this.zda = ((ViewGroup)this.rfF.findViewById(2131304059));
        localObject1 = new i.c();
        ((i.c)localObject1).textColor = getResources().getColor(2131099835);
        ((i.c)localObject1).textSize = getResources().getDimensionPixelSize(2131165482);
        i.a(this, this.zda, paramq.yVs, (i.c)localObject1);
        localObject1 = new i.c();
        ((i.c)localObject1).textColor = getResources().getColor(2131099783);
        ((i.c)localObject1).textSize = getResources().getDimensionPixelSize(2131165482);
        if ((paramq.yVB != null) && (!ab.IN(this.gAn)))
        {
          localObject2 = bh.aDy(paramq.yVB);
          if ((localObject2 != null) && (((bh)localObject2).yXV != null))
          {
            ((i.c)localObject1).zgz = ((bh)localObject2).yUC;
            if (((i.c)localObject1).zgz == null)
            {
              ((i.c)localObject1).zgz = new cbe();
              ((i.c)localObject1).zgz.MgB = this.zdE;
            }
            i.a(this, this.zda, ((bh)localObject2).yXV, (i.c)localObject1);
            localObject1 = "";
            if (((bh)localObject2).yUC != null) {
              localObject1 = ((bh)localObject2).yUC.Lot;
            }
            com.tencent.mm.plugin.report.service.h.CyF.a(16589, new Object[] { Integer.valueOf(1), ((bh)localObject2).yXV.content, this.zdE, localObject1, Integer.valueOf(0), com.tencent.mm.plugin.luckymoney.a.c.openId });
          }
        }
      }
      com.tencent.mm.plugin.report.service.h.CyF.a(11701, new Object[] { Integer.valueOf(PP(paramq.yVv)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
      localObject1 = paramq.yVw;
      if (localObject1 == null) {
        break label2778;
      }
      i = 0;
      while (i < ((List)localObject1).size())
      {
        localObject2 = (ad)((List)localObject1).get(i);
        if (!this.zcn.containsKey(((ad)localObject2).yVk))
        {
          this.yQe.add(((List)localObject1).get(i));
          localObject3 = new a();
          ((a)localObject3).zep = ((ad)((List)localObject1).get(i));
          this.zds.add(localObject3);
          this.zcn.put(((ad)localObject2).yVk, Integer.valueOf(1));
        }
        i += 1;
      }
      if (bool) {
        break;
      }
      break;
      if (bool)
      {
        if (egg()) {
          break;
        }
        break;
      }
      egg();
      break;
      label2058:
      this.yUl.setVisibility(8);
      break label63;
      label2070:
      this.zdf.setOnClickListener(this.zdX);
      this.zdf.setTag("nodelete");
      this.zdj.setOnClickListener(this.zdX);
      this.zdm.setOnClickListener(this.zdX);
      this.zdi.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(213358);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, new hd());
          LuckyMoneyDetailUI.z(LuckyMoneyDetailUI.this).eEH = 7L;
          LuckyMoneyDetailUI.z(LuckyMoneyDetailUI.this).bfK();
          LuckyMoneyDetailUI.D(LuckyMoneyDetailUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(213358);
        }
      });
      this.zdh.setOnClickListener(this.zdX);
      localObject1 = (String)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.Oaa, "");
      PR(1);
      if (Util.isNullOrNil((String)localObject1)) {
        break label97;
      }
      bF(2, (String)localObject1);
      break label97;
      label2181:
      bool = false;
      break label108;
      label2187:
      i = 0;
      break label159;
      label2192:
      j = 0;
      break label192;
      label2197:
      this.zcY.setVisibility(8);
      break label324;
      label2209:
      i = 0;
      break label465;
      label2214:
      this.zcU.setVisibility(0);
      if ((!g(paramq)) || (e(paramq))) {
        break label483;
      }
      this.zcV.setVisibility(8);
      this.zcW.setVisibility(8);
      this.zcX.setVisibility(8);
      break label483;
      label2267:
      af.a(this.yQt, paramq.yVe, paramq.yVy);
      break label600;
      label2285:
      if (ab.IN(this.gAn))
      {
        this.yQt.setImageResource(2131234245);
        break label600;
      }
      af.a(this.yQt, paramq.yVe, paramq.yVy);
      break label600;
      label2326:
      localObject1 = getString(2131762757, new Object[] { paramq.yVd + paramq.yVF });
      break label655;
      label2369:
      Log.i("MicroMsg.LuckyMoneyDetailUI", "use union normal name");
      if (ab.IN(this.gAn)) {}
      for (localObject1 = paramq.yVd;; localObject1 = getString(2131762757, new Object[] { paramq.yVd }))
      {
        i = ((WindowManager)getSystemService("window")).getDefaultDisplay().getWidth();
        j = BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 92.0F);
        this.yQu.setMaxWidth(i - j);
        af.a((Context)localObject2, this.yQu, (String)localObject1);
        break;
      }
      label2471:
      this.yln.setVisibility(8);
      break label853;
      label2483:
      if (paramq.egY == 2)
      {
        if (!ab.IS(paramq.yVy))
        {
          localObject1 = new com.tencent.mm.aj.i();
          ((com.tencent.mm.aj.i)localObject1).username = paramq.yVy;
          p.aYB().b((com.tencent.mm.aj.i)localObject1);
        }
        this.yQv.setVisibility(0);
        this.yQv.setImageResource(2131691044);
        break label879;
      }
      this.yQv.setVisibility(8);
      break label879;
      label2561:
      Log.i("MicroMsg.LuckyMoneyDetailUI", "hy: no bg. set bg area to gone");
      this.zdb.setVisibility(8);
      break label942;
      label2582:
      this.yQw.setVisibility(8);
      break label985;
      label2594:
      this.zdo.setVisibility(8);
      break label1069;
      label2606:
      if (paramq.yRN == 1)
      {
        Log.i("MicroMsg.LuckyMoneyDetailUI", "changeIconUrl: %s", new Object[] { paramq.yVA });
        if (!Util.isNullOrNil(paramq.yVA))
        {
          this.zcR.setUrl(paramq.yVA);
          this.zcR.setVisibility(0);
        }
        for (;;)
        {
          this.nAB.setOnClickListener(new LuckyMoneyDetailUI.21(this, paramq));
          break;
          this.zcR.setVisibility(8);
        }
      }
      Log.e("MicroMsg.LuckyMoneyDetailUI", "detail.jumpChange is false");
      break label1132;
      label2706:
      Log.e("MicroMsg.LuckyMoneyDetailUI", "detail.changeWording is empty");
      this.yQx.setVisibility(8);
      break label1132;
      label2727:
      this.jVn.setText(null);
      this.zcU.setVisibility(8);
    }
    this.fs += ((List)localObject1).size();
    this.mwr = false;
    this.zdR.atj.notifyChanged();
    label2778:
    if ((paramq.egY == 2) && (!Util.isNullOrNil(paramq.yVc)))
    {
      this.yRy = new SoundPool(2, 3, 0);
      this.zdc = new int[2];
    }
    try
    {
      this.zdc[0] = this.yRy.load(getResources().getAssets().openFd("most_lucky.m4a"), 0);
      this.zdc[1] = this.yRy.load(getResources().getAssets().openFd("whistle.m4a"), 0);
      this.yRy.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener()
      {
        public final void onLoadComplete(SoundPool paramAnonymousSoundPool, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(213369);
          if (paramAnonymousInt2 == 0)
          {
            if (paramAnonymousInt1 == LuckyMoneyDetailUI.M(LuckyMoneyDetailUI.this)[0])
            {
              paramAnonymousSoundPool.play(paramAnonymousInt1, 1.0F, 1.0F, 0, 0, 1.0F);
              AppMethodBeat.o(213369);
              return;
            }
            if ((paramAnonymousInt1 == LuckyMoneyDetailUI.M(LuckyMoneyDetailUI.this)[1]) && (paramq.eht >= 19000L)) {
              paramAnonymousSoundPool.play(paramAnonymousInt1, 1.0F, 1.0F, 0, 0, 1.0F);
            }
          }
          AppMethodBeat.o(213369);
        }
      });
      this.agA.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(213370);
          LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, (ViewGroup)LuckyMoneyDetailUI.this.findViewById(2131304124));
          Object localObject = LuckyMoneyDetailUI.N(LuckyMoneyDetailUI.this);
          com.tencent.mm.particles.b localb = LuckyMoneyDetailUI.O(LuckyMoneyDetailUI.this);
          com.tencent.mm.particles.a locala = new com.tencent.mm.particles.a((ViewGroup)localObject);
          localObject = new com.tencent.mm.particles.c(((ViewGroup)localObject).getContext(), localb, new com.tencent.mm.particles.d(-100, ((ViewGroup)localObject).getHeight() / 2), (ViewGroup)localObject).G(600.0F, 150.0F).H(-1000.0F, 250.0F).ay(-200.0F).az(1500.0F);
          ((com.tencent.mm.particles.c)localObject).jIV = 600.0F;
          ((com.tencent.mm.particles.c)localObject).jIW = 300.0F;
          localObject = ((com.tencent.mm.particles.c)localObject).bkG();
          ((com.tencent.mm.particles.c)localObject).jIy = com.tencent.mm.particles.e.bkO();
          locala.hRg = ((com.tencent.mm.particles.c)localObject).bkH().bkI();
          locala.G(100, 400L);
          localObject = LuckyMoneyDetailUI.N(LuckyMoneyDetailUI.this);
          localb = LuckyMoneyDetailUI.O(LuckyMoneyDetailUI.this);
          locala = new com.tencent.mm.particles.a((ViewGroup)localObject);
          localObject = new com.tencent.mm.particles.c(((ViewGroup)localObject).getContext(), localb, new com.tencent.mm.particles.d(((ViewGroup)localObject).getWidth() + 100, ((ViewGroup)localObject).getHeight() / 2), (ViewGroup)localObject).G(-600.0F, 150.0F).H(-1000.0F, 250.0F).ay(200.0F).az(1500.0F);
          ((com.tencent.mm.particles.c)localObject).jIV = 600.0F;
          ((com.tencent.mm.particles.c)localObject).jIW = 300.0F;
          localObject = ((com.tencent.mm.particles.c)localObject).bkG();
          ((com.tencent.mm.particles.c)localObject).jIy = com.tencent.mm.particles.e.bkO();
          locala.hRg = ((com.tencent.mm.particles.c)localObject).bkH().bkI();
          locala.G(100, 400L);
          AppMethodBeat.o(213370);
        }
      }, 300L);
      if (!ab.IN(this.gAn))
      {
        localObject2 = com.tencent.mm.plugin.wallet_core.model.t.fQE().aVA(this.yUq);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new ae();
        }
        ((ae)localObject1).field_mNativeUrl = this.yUq;
        ((ae)localObject1).field_hbType = paramq.egY;
        ((ae)localObject1).field_receiveAmount = paramq.eht;
        ((ae)localObject1).field_receiveTime = System.currentTimeMillis();
        ((ae)localObject1).field_hbStatus = paramq.egZ;
        ((ae)localObject1).field_receiveStatus = paramq.eha;
        ((ae)localObject1).field_sendId = this.yUc;
        ((ae)localObject1).field_sender = this.gAn;
        if (((ae)localObject1).field_receiveAmount > 0L)
        {
          com.tencent.mm.plugin.wallet_core.model.t.fQE().a((ae)localObject1);
          com.tencent.mm.plugin.luckymoney.b.a.eex().aDq(this.gAn);
        }
      }
      egh();
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
        Log.e("MicroMsg.LuckyMoneyDetailUI", "load lucky money voice fail " + localIOException.getMessage());
      }
    }
  }
  
  private void b(dlt paramdlt)
  {
    AppMethodBeat.i(163739);
    f(this.zdU);
    this.zdr.a(paramdlt, this.zdT, this.zdE, this.qBv, ab.IN(this.gAn));
    egh();
    AppMethodBeat.o(163739);
  }
  
  private void bF(int paramInt, String paramString)
  {
    AppMethodBeat.i(65575);
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (ab.IN(this.gAn)) {
        this.zde.setVisibility(8);
      }
      AppMethodBeat.o(65575);
      return;
      this.zde.setVisibility(8);
      continue;
      this.zde.setVisibility(0);
      this.zdf.setVisibility(0);
      this.zdg.setVisibility(8);
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Oaa, "");
      continue;
      if (!Util.isNullOrNil(paramString))
      {
        paramString = k.getEmojiStorageMgr().OpN.blk(paramString);
        if (paramString == null)
        {
          Log.i("MicroMsg.LuckyMoneyDetailUI", "exchangeThxEmojiState() temp == null");
          AppMethodBeat.o(65575);
          return;
        }
        this.zdw = paramString;
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Oaa, this.zdw.getMd5());
        this.zdh.setEmojiInfo(this.zdw);
        this.zde.setVisibility(0);
        this.zdf.setVisibility(8);
        this.zdg.setVisibility(0);
      }
    }
  }
  
  private boolean e(com.tencent.mm.plugin.luckymoney.model.q paramq)
  {
    return (paramq.eha == 2) && (this.zcj != 3);
  }
  
  private void egf()
  {
    AppMethodBeat.i(65563);
    ((com.tencent.mm.pluginsdk.j)com.tencent.mm.kernel.g.af(com.tencent.mm.pluginsdk.j.class)).a(this, this.gAn, this.zdw.getMd5(), getString(2131762730), new y.a()
    {
      public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
      {
        paramAnonymousInt = 2;
        AppMethodBeat.i(213357);
        LuckyMoneyDetailUI.this.hideVKB();
        LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, new hd());
        if (paramAnonymousBoolean)
        {
          LuckyMoneyDetailUI.z(LuckyMoneyDetailUI.this).eEH = 5L;
          LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, new he());
          if ((LuckyMoneyDetailUI.A(LuckyMoneyDetailUI.this) == 0) || (LuckyMoneyDetailUI.A(LuckyMoneyDetailUI.this) == 2)) {
            if (com.tencent.mm.plugin.emoji.h.b.y(LuckyMoneyDetailUI.B(LuckyMoneyDetailUI.this))) {
              paramAnonymousInt = 1;
            }
          }
        }
        for (;;)
        {
          LuckyMoneyDetailUI.C(LuckyMoneyDetailUI.this).eLv = paramAnonymousInt;
          he localhe = LuckyMoneyDetailUI.C(LuckyMoneyDetailUI.this);
          localhe.eLw = localhe.x("emoticonMd5", LuckyMoneyDetailUI.B(LuckyMoneyDetailUI.this).getMd5(), true);
          if (Util.isNullOrNil(paramAnonymousString))
          {
            LuckyMoneyDetailUI.C(LuckyMoneyDetailUI.this).eLx = 1L;
            label159:
            LuckyMoneyDetailUI.C(LuckyMoneyDetailUI.this).bfK();
            LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, LuckyMoneyDetailUI.s(LuckyMoneyDetailUI.this), paramAnonymousString, LuckyMoneyDetailUI.B(LuckyMoneyDetailUI.this).getMd5());
            LuckyMoneyDetailUI.b(LuckyMoneyDetailUI.this, 3);
            com.tencent.mm.ui.base.t.a(LuckyMoneyDetailUI.this.getContext().getResources().getString(2131761619), LuckyMoneyDetailUI.this.getContext(), 0, null);
            MMHandlerThread.postToMainThreadDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(213356);
                LuckyMoneyDetailUI.this.finish();
                AppMethodBeat.o(213356);
              }
            }, 500L);
          }
          for (;;)
          {
            LuckyMoneyDetailUI.z(LuckyMoneyDetailUI.this).bfK();
            AppMethodBeat.o(213357);
            return;
            if (!com.tencent.mm.plugin.emoji.h.b.w(LuckyMoneyDetailUI.B(LuckyMoneyDetailUI.this))) {
              break;
            }
            paramAnonymousInt = 3;
            break;
            if (LuckyMoneyDetailUI.A(LuckyMoneyDetailUI.this) != 1) {
              break label328;
            }
            paramAnonymousInt = 1;
            break;
            LuckyMoneyDetailUI.C(LuckyMoneyDetailUI.this).eLx = 2L;
            break label159;
            LuckyMoneyDetailUI.z(LuckyMoneyDetailUI.this).eEH = 6L;
          }
          label328:
          paramAnonymousInt = 0;
        }
      }
    });
    AppMethodBeat.o(65563);
  }
  
  private boolean egg()
  {
    AppMethodBeat.i(65572);
    if ((!Util.isNullOrNil(this.rcU)) && ((Util.isEqual(this.zdy.yVG, 1)) || (Util.isEqual(this.zdy.yVH, 1))))
    {
      AppMethodBeat.o(65572);
      return true;
    }
    AppMethodBeat.o(65572);
    return false;
  }
  
  private void egh()
  {
    AppMethodBeat.i(163741);
    Log.d("MicroMsg.LuckyMoneyDetailUI", "adjust footer");
    this.rfF.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(213378);
        if ((LuckyMoneyDetailUI.this.isFinishing()) || (LuckyMoneyDetailUI.this.isDestroyed()))
        {
          AppMethodBeat.o(213378);
          return;
        }
        if ((LuckyMoneyDetailUI.T(LuckyMoneyDetailUI.this).getVisibility() == 8) && (LuckyMoneyDetailUI.U(LuckyMoneyDetailUI.this).getVisibility() == 8) && (LuckyMoneyDetailUI.V(LuckyMoneyDetailUI.this).getVisibility() == 8))
        {
          AppMethodBeat.o(213378);
          return;
        }
        Object localObject = LuckyMoneyDetailUI.this.findViewById(2131304058);
        if ((LuckyMoneyDetailUI.W(LuckyMoneyDetailUI.this) == null) || (localObject == null))
        {
          AppMethodBeat.o(213378);
          return;
        }
        if (!LuckyMoneyDetailUI.X(LuckyMoneyDetailUI.this))
        {
          LuckyMoneyDetailUI.Y(LuckyMoneyDetailUI.this);
          LuckyMoneyDetailUI.c(LuckyMoneyDetailUI.this, LuckyMoneyDetailUI.W(LuckyMoneyDetailUI.this).getHeight());
        }
        int i = ((View)localObject).getHeight();
        localObject = new Rect();
        LuckyMoneyDetailUI.W(LuckyMoneyDetailUI.this).getGlobalVisibleRect((Rect)localObject);
        int j = LuckyMoneyDetailUI.W(LuckyMoneyDetailUI.this).getTop();
        int k = i - j;
        if (k > LuckyMoneyDetailUI.Z(LuckyMoneyDetailUI.this)) {
          LuckyMoneyDetailUI.W(LuckyMoneyDetailUI.this).setMinimumHeight(k);
        }
        for (;;)
        {
          Log.d("MicroMsg.LuckyMoneyDetailUI", "winHeight:%s diff:%s recordHeight:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(j) });
          AppMethodBeat.o(213378);
          return;
          LuckyMoneyDetailUI.W(LuckyMoneyDetailUI.this).setMinimumHeight(LuckyMoneyDetailUI.Z(LuckyMoneyDetailUI.this));
        }
      }
    });
    AppMethodBeat.o(163741);
  }
  
  private void f(com.tencent.mm.plugin.luckymoney.model.q paramq)
  {
    AppMethodBeat.i(163740);
    if (paramq.yVB != null)
    {
      paramq = bh.aDy(paramq.yVB);
      if ((Util.isNullOrNil(this.zdT)) && (paramq != null) && (paramq.yUC != null)) {
        this.zdT = paramq.yUC.Lot;
      }
      this.yZG = getIntent().getStringExtra("key_detail_envelope_url");
      this.yZH = getIntent().getStringExtra("key_detail_envelope_md5");
      if ((Util.isNullOrNil(this.yZG)) && (paramq != null) && (paramq.yUC != null) && (paramq.yUC.MgC != null))
      {
        this.yZG = paramq.yUC.MgC.MgV;
        this.yZH = paramq.yUC.MgC.MgY;
      }
      if ((!Util.isNullOrNil(this.yZG)) && (!Util.isNullOrNil(this.yZH)))
      {
        this.zdr.iC(this.yZG, this.yZH);
        if (!this.zdt)
        {
          this.zdt = true;
          com.tencent.mm.plugin.luckymoney.a.c.bC(3, this.yZG);
        }
      }
    }
    AppMethodBeat.o(163740);
  }
  
  private static boolean g(com.tencent.mm.plugin.luckymoney.model.q paramq)
  {
    return paramq.yVm == 1;
  }
  
  private void qM(boolean paramBoolean)
  {
    AppMethodBeat.i(65569);
    Log.i("MicroMsg.LuckyMoneyDetailUI", "showEmoji() circle:%s", new Object[] { Boolean.TRUE });
    this.yUn.setVisibility(8);
    this.zeb = 1;
    if (paramBoolean) {
      this.zdY = 3;
    }
    do
    {
      this.rfq = k.getEmojiStorageMgr().OpN.blk(this.rcU);
      if (this.rfq == null) {
        break;
      }
      if ((s.boW(this.rfq.hRM()) <= 0L) && (!this.rfq.NA()) && (!this.rfq.hRB())) {
        break label218;
      }
      this.yUm.setVisibility(0);
      A(this.rfq);
      AppMethodBeat.o(65569);
      return;
      this.zdY -= 1;
    } while (this.zdY != 0);
    Log.i("MicroMsg.LuckyMoneyDetailUI", "showEmoji() circle fail!");
    this.yUo.setVisibility(8);
    this.yUn.setVisibility(0);
    this.zeb = 2;
    AppMethodBeat.o(65569);
    return;
    this.rfq = new EmojiInfo();
    this.rfq.field_md5 = this.rcU;
    this.rfq.field_type = this.zdu;
    label218:
    if (paramBoolean)
    {
      this.yUm.setVisibility(8);
      this.yUo.setVisibility(0);
      k.cGd().rbg = this.rbg;
    }
    k.cGd().u(this.rfq);
    com.tencent.mm.kernel.g.aAg().hqi.a(697, this.zdZ);
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
          AppMethodBeat.i(213363);
          Log.i("MicroMsg.LuckyMoneyDetailUI", "RealnameGuideHelper dialog click cancel");
          LuckyMoneyDetailUI.G(LuckyMoneyDetailUI.this);
          AppMethodBeat.o(213363);
        }
      });
      getIntent().removeExtra("key_realname_guide_helper");
      if (!bool) {
        super.finish();
      }
    }
    for (;;)
    {
      overridePendingTransition(2130772165, 2130772170);
      AppMethodBeat.o(65568);
      return;
      super.finish();
    }
  }
  
  public int getLayoutId()
  {
    return 2131495358;
  }
  
  public void initView()
  {
    AppMethodBeat.i(65561);
    this.zdH = new com.tencent.mm.plugin.wallet_core.utils.c(this);
    setMMTitle("");
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(213381);
        if (LuckyMoneyDetailUI.t(LuckyMoneyDetailUI.this) == null)
        {
          LuckyMoneyDetailUI.this.finish();
          AppMethodBeat.o(213381);
          return false;
        }
        if (!com.tencent.mm.plugin.wallet_core.utils.c.a(LuckyMoneyDetailUI.t(LuckyMoneyDetailUI.this)))
        {
          LuckyMoneyDetailUI.this.finish();
          AppMethodBeat.o(213381);
          return false;
        }
        LuckyMoneyDetailUI.u(LuckyMoneyDetailUI.this).a(LuckyMoneyDetailUI.t(LuckyMoneyDetailUI.this), new com.tencent.mm.plugin.wallet_core.utils.c.a()
        {
          public final void a(cfl paramAnonymous2cfl)
          {
            AppMethodBeat.i(213380);
            if (paramAnonymous2cfl.action == 1)
            {
              LuckyMoneyDetailUI.this.finish();
              AppMethodBeat.o(213380);
              return;
            }
            AppMethodBeat.o(213380);
          }
        });
        LuckyMoneyDetailUI.v(LuckyMoneyDetailUI.this);
        AppMethodBeat.o(213381);
        return false;
      }
    }, 2131233104);
    this.zcQ = ((RecyclerView)findViewById(2131304073));
    RecyclerView localRecyclerView = this.zcQ;
    getContext();
    localRecyclerView.setLayoutManager(new LinearLayoutManager(1, false));
    this.agA = LayoutInflater.from(this).inflate(2131495357, this.zcQ, false);
    this.rfF = LayoutInflater.from(this).inflate(2131495355, this.zcQ, false);
    this.zdR = new WxRecyclerAdapter(new LuckyMoneyDetailUI.30(this), this.zds, false);
    this.zdR.f(this.agA, 1, false);
    this.zcQ.setAdapter(this.zdR);
    this.zcQ.a(this.anE);
    this.yQt = ((ImageView)this.agA.findViewById(2131304077));
    this.yQu = ((TextView)this.agA.findViewById(2131304094));
    this.zdn = this.agA.findViewById(2131304092);
    this.yQv = ((ImageView)this.agA.findViewById(2131304060));
    this.yln = ((TextView)this.agA.findViewById(2131304097));
    this.yUl = ((RelativeLayout)this.agA.findViewById(2131304102));
    this.yUm = ((BaseEmojiView)this.agA.findViewById(2131304098));
    this.yUn = ((TextView)this.agA.findViewById(2131304266));
    this.yUo = ((LinearLayout)this.agA.findViewById(2131304151));
    this.yUp = ((ProgressBar)this.agA.findViewById(2131299998));
    this.yQw = this.agA.findViewById(2131304045);
    this.yQk = ((TextView)this.agA.findViewById(2131304044));
    this.zdo = ((ViewGroup)this.agA.findViewById(2131304142));
    this.zdp = ((TextView)this.agA.findViewById(2131304143));
    this.zdq = ((ImageView)this.agA.findViewById(2131304141));
    this.yQx = this.agA.findViewById(2131304062);
    this.nAB = ((TextView)this.agA.findViewById(2131304090));
    this.zcR = ((CdnImageView)this.agA.findViewById(2131304061));
    this.jVn = ((TextView)this.agA.findViewById(2131304051));
    this.zcg = this.agA.findViewById(2131304071);
    this.zcS = this.agA.findViewById(2131304049);
    this.zcT = ((ImageView)this.agA.findViewById(2131304048));
    this.zde = ((LinearLayout)this.agA.findViewById(2131304273));
    this.zdf = ((LinearLayout)this.agA.findViewById(2131304277));
    this.zdg = ((LinearLayout)this.agA.findViewById(2131304280));
    this.zdh = ((BaseEmojiView)this.agA.findViewById(2131304274));
    this.zdi = ((RelativeLayout)this.agA.findViewById(2131304279));
    this.zdj = ((ImageView)this.agA.findViewById(2131304275));
    this.zcU = ((ViewGroup)this.agA.findViewById(2131304053));
    this.zcV = this.agA.findViewById(2131304052);
    this.zcW = this.agA.findViewById(2131304054);
    this.zcX = this.agA.findViewById(2131304055);
    this.zdb = ((RelativeLayout)this.agA.findViewById(2131304049));
    this.rIY = ((ImageView)this.agA.findViewById(2131304048));
    this.zdm = ((ImageView)this.agA.findViewById(2131304282));
    this.zdd = ((ViewGroup)findViewById(2131304124));
    this.yUn.setOnClickListener(new LuckyMoneyDetailUI.31(this));
    this.zdk = new a(this);
    this.zdl = getLayoutInflater().inflate(2131495362, null);
    this.zdk.setContentView(this.zdl, new ViewGroup.LayoutParams(-1, -1));
    this.zdl.findViewById(2131304101).setOnClickListener(new LuckyMoneyDetailUI.32(this));
    this.zdk.zbp = new LuckyMoneyDetailUI.2(this);
    this.zdx = ((ViewGroup)this.zdl.findViewById(2131304103));
    if (com.tencent.mm.pluginsdk.ui.chat.e.Knc == null)
    {
      Log.w("MicroMsg.LuckyMoneyDetailUI", "can't show correctly");
      finish();
      AppMethodBeat.o(65561);
      return;
    }
    this.zdv = com.tencent.mm.pluginsdk.ui.chat.e.Knc.eZ(getContext());
    this.zdv.setTalkerName(this.gAn);
    this.zdv.setShowSmiley(false);
    this.zcR.setUseSdcardCache(true);
    this.yUm.setOnClickListener(new LuckyMoneyDetailUI.3(this));
    this.zdr = ((EnvelopeAppBarLayout)findViewById(2131304110));
    this.zdr.setActivityLifeCycle(this);
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
        if (!Util.isNullOrNil(str)) {
          if ((this.zcl != null) && (this.zcl.startsWith("wxpay://c2cbizmessagehandler/hongbao/festivalhongbao")))
          {
            Log.i("MicroMsg.LuckyMoneyDetailUI", "Not expected branch since 2015 fesitval");
          }
          else
          {
            doSceneProgress(new bf(str.replaceAll(",", "|"), this.yUc, "v1.0"));
            continue;
            if (paramInt2 == -1)
            {
              str = "";
              if (paramIntent != null) {
                str = paramIntent.getStringExtra("gif_md5");
              }
              if (!Util.isNullOrNil(str))
              {
                bF(2, str);
                egf();
              }
              else
              {
                Log.i("MicroMsg.LuckyMoneyDetailUI", "md5 == null go emoji capture failed!");
              }
            }
            else
            {
              Log.i("MicroMsg.LuckyMoneyDetailUI", "go emoji capture failed!");
              continue;
              com.tencent.mm.plugin.luckymoney.a.d.xV(8);
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
    //   2: ldc_w 2289
    //   5: invokestatic 228	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: invokestatic 2293	com/tencent/mm/pluginsdk/h:q	(Lcom/tencent/mm/ui/MMActivity;)V
    //   12: aload_0
    //   13: iconst_1
    //   14: invokevirtual 2296	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:customfixStatusbar	(Z)V
    //   17: aload_0
    //   18: iconst_0
    //   19: putfield 2299	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:zbY	Z
    //   22: aload_0
    //   23: invokevirtual 1825	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   26: ldc_w 2301
    //   29: iconst_0
    //   30: invokevirtual 2305	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   33: ifne +13 -> 46
    //   36: aload_0
    //   37: ldc_w 2306
    //   40: ldc_w 2307
    //   43: invokevirtual 2091	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:overridePendingTransition	(II)V
    //   46: aload_0
    //   47: aload_1
    //   48: invokespecial 2309	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBaseUI:onCreate	(Landroid/os/Bundle;)V
    //   51: aload_0
    //   52: invokevirtual 2313	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getWindow	()Landroid/view/Window;
    //   55: invokevirtual 2318	android/view/Window:getDecorView	()Landroid/view/View;
    //   58: sipush 1280
    //   61: invokevirtual 2321	android/view/View:setSystemUiVisibility	(I)V
    //   64: aload_0
    //   65: invokevirtual 2313	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getWindow	()Landroid/view/Window;
    //   68: ldc_w 2322
    //   71: invokevirtual 2325	android/view/Window:setBackgroundDrawableResource	(I)V
    //   74: aload_0
    //   75: aload_0
    //   76: invokevirtual 1825	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   79: ldc_w 2327
    //   82: invokevirtual 1922	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   85: putfield 1153	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:zdE	Ljava/lang/String;
    //   88: aload_0
    //   89: aload_0
    //   90: invokevirtual 1825	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   93: ldc_w 2329
    //   96: iconst_0
    //   97: invokevirtual 1831	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   100: putfield 1616	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:qBv	I
    //   103: aload_0
    //   104: aload_0
    //   105: invokevirtual 1825	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   108: ldc_w 2331
    //   111: iconst_0
    //   112: invokevirtual 1831	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   115: putfield 1819	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:zdF	I
    //   118: aload_0
    //   119: invokevirtual 2335	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getController	()Lcom/tencent/mm/ui/t;
    //   122: iconst_0
    //   123: putfield 2340	com/tencent/mm/ui/t:OGt	Z
    //   126: aload_0
    //   127: aload_0
    //   128: invokevirtual 449	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getResources	()Landroid/content/res/Resources;
    //   131: ldc_w 2341
    //   134: invokevirtual 650	android/content/res/Resources:getColor	(I)I
    //   137: invokevirtual 2344	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:setActionbarColor	(I)V
    //   140: aload_0
    //   141: invokevirtual 2347	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:hideActionbarLine	()V
    //   144: aload_0
    //   145: aload_0
    //   146: invokevirtual 1825	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   149: ldc_w 2349
    //   152: iconst_0
    //   153: invokevirtual 2305	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   156: putfield 263	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:zdD	Z
    //   159: aload_0
    //   160: new 1758	org/json/JSONObject
    //   163: dup
    //   164: aload_0
    //   165: invokevirtual 1825	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   168: ldc_w 2351
    //   171: invokevirtual 1922	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   174: invokespecial 1759	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   177: invokestatic 2357	com/tencent/mm/plugin/wallet_core/utils/b:bV	(Lorg/json/JSONObject;)Lcom/tencent/mm/plugin/wallet_core/utils/b;
    //   180: putfield 2030	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:zdG	Lcom/tencent/mm/plugin/wallet_core/utils/b;
    //   183: aload_0
    //   184: aload_0
    //   185: invokevirtual 1825	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   188: ldc_w 2359
    //   191: invokevirtual 1922	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   194: putfield 923	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:gAn	Ljava/lang/String;
    //   197: aload_0
    //   198: aload_0
    //   199: invokevirtual 1825	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   202: ldc_w 2361
    //   205: sipush 1002
    //   208: invokevirtual 1831	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   211: putfield 1851	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:zbZ	I
    //   214: aload_0
    //   215: aload_0
    //   216: invokevirtual 1825	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   219: ldc_w 2363
    //   222: invokevirtual 1922	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   225: putfield 1381	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:yUc	Ljava/lang/String;
    //   228: aload_0
    //   229: aload_0
    //   230: invokevirtual 1825	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   233: ldc_w 2365
    //   236: invokevirtual 1922	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   239: putfield 1346	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:yUq	Ljava/lang/String;
    //   242: aload_0
    //   243: aload_0
    //   244: invokevirtual 1825	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   247: ldc_w 2367
    //   250: iconst_2
    //   251: invokevirtual 1831	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   254: putfield 1021	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:zcj	I
    //   257: aload_0
    //   258: aload_0
    //   259: invokevirtual 1825	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   262: ldc_w 2369
    //   265: invokevirtual 1922	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   268: putfield 255	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:zcp	Ljava/lang/String;
    //   271: aload_0
    //   272: aload_0
    //   273: invokevirtual 1825	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   276: ldc_w 2371
    //   279: lconst_0
    //   280: invokevirtual 2374	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   283: putfield 2045	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:gof	J
    //   286: aload_0
    //   287: aload_0
    //   288: invokevirtual 1825	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   291: ldc_w 2376
    //   294: invokevirtual 1922	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   297: putfield 1614	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:zdT	Ljava/lang/String;
    //   300: aload_0
    //   301: aload_0
    //   302: invokevirtual 1825	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   305: ldc_w 1919
    //   308: invokevirtual 1922	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   311: putfield 1924	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:yZG	Ljava/lang/String;
    //   314: aload_0
    //   315: aload_0
    //   316: invokevirtual 1825	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   319: ldc_w 1926
    //   322: invokevirtual 1922	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   325: putfield 1928	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:yZH	Ljava/lang/String;
    //   328: ldc_w 464
    //   331: new 865	java/lang/StringBuilder
    //   334: dup
    //   335: ldc_w 2378
    //   338: invokespecial 870	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   341: aload_0
    //   342: getfield 1381	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:yUc	Ljava/lang/String;
    //   345: invokestatic 2381	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   348: invokevirtual 935	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: ldc_w 2383
    //   354: invokevirtual 935	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: aload_0
    //   358: getfield 1346	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:yUq	Ljava/lang/String;
    //   361: invokestatic 2381	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   364: invokevirtual 935	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: ldc_w 2385
    //   370: invokevirtual 935	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: aload_0
    //   374: getfield 1021	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:zcj	I
    //   377: invokevirtual 874	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   380: ldc_w 2387
    //   383: invokevirtual 935	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: aload_0
    //   387: getfield 1614	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:zdT	Ljava/lang/String;
    //   390: invokevirtual 935	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: invokevirtual 878	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   396: invokestatic 881	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   399: aload_0
    //   400: getfield 1381	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:yUc	Ljava/lang/String;
    //   403: invokestatic 598	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   406: ifeq +32 -> 438
    //   409: aload_0
    //   410: getfield 1346	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:yUq	Ljava/lang/String;
    //   413: invokestatic 598	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   416: ifne +22 -> 438
    //   419: aload_0
    //   420: getfield 1346	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:yUq	Ljava/lang/String;
    //   423: invokestatic 2393	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   426: astore_1
    //   427: aload_0
    //   428: aload_1
    //   429: ldc_w 2395
    //   432: invokevirtual 2398	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   435: putfield 1381	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:yUc	Ljava/lang/String;
    //   438: aload_0
    //   439: aload_0
    //   440: invokevirtual 1825	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   443: ldc_w 2400
    //   446: invokevirtual 1922	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   449: putfield 1897	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:rcU	Ljava/lang/String;
    //   452: aload_0
    //   453: aload_0
    //   454: invokevirtual 1825	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   457: ldc_w 2402
    //   460: iconst_0
    //   461: invokevirtual 1831	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   464: putfield 1995	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:zdu	I
    //   467: aload_0
    //   468: getfield 1897	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:rcU	Ljava/lang/String;
    //   471: invokestatic 598	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   474: ifne +32 -> 506
    //   477: aload_0
    //   478: new 315	com/tencent/mm/g/b/a/hf
    //   481: dup
    //   482: invokespecial 316	com/tencent/mm/g/b/a/hf:<init>	()V
    //   485: putfield 318	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:zdz	Lcom/tencent/mm/g/b/a/hf;
    //   488: aload_0
    //   489: getfield 318	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:zdz	Lcom/tencent/mm/g/b/a/hf;
    //   492: ldc2_w 2403
    //   495: putfield 323	com/tencent/mm/g/b/a/hf:eEH	J
    //   498: aload_0
    //   499: getfield 318	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:zdz	Lcom/tencent/mm/g/b/a/hf;
    //   502: invokevirtual 327	com/tencent/mm/g/b/a/hf:bfK	()Z
    //   505: pop
    //   506: aload_0
    //   507: aload_0
    //   508: invokevirtual 1825	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   511: ldc_w 2406
    //   514: invokevirtual 2063	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   517: checkcast 362	com/tencent/mm/plugin/luckymoney/model/LuckyMoneyEmojiSwitch
    //   520: putfield 360	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:zdy	Lcom/tencent/mm/plugin/luckymoney/model/LuckyMoneyEmojiSwitch;
    //   523: aload_0
    //   524: getfield 360	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:zdy	Lcom/tencent/mm/plugin/luckymoney/model/LuckyMoneyEmojiSwitch;
    //   527: ifnonnull +14 -> 541
    //   530: aload_0
    //   531: new 362	com/tencent/mm/plugin/luckymoney/model/LuckyMoneyEmojiSwitch
    //   534: dup
    //   535: invokespecial 2407	com/tencent/mm/plugin/luckymoney/model/LuckyMoneyEmojiSwitch:<init>	()V
    //   538: putfield 360	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:zdy	Lcom/tencent/mm/plugin/luckymoney/model/LuckyMoneyEmojiSwitch;
    //   541: aload_0
    //   542: getfield 1381	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:yUc	Ljava/lang/String;
    //   545: invokestatic 2413	com/tencent/mm/plugin/luckymoney/a/b:aDn	(Ljava/lang/String;)Lcom/tencent/mm/plugin/luckymoney/model/q;
    //   548: astore_1
    //   549: aload_1
    //   550: ifnull +73 -> 623
    //   553: aload_0
    //   554: aload_1
    //   555: putfield 414	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:zdU	Lcom/tencent/mm/plugin/luckymoney/model/q;
    //   558: aload_0
    //   559: invokevirtual 2415	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:initView	()V
    //   562: aload_0
    //   563: getfield 414	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:zdU	Lcom/tencent/mm/plugin/luckymoney/model/q;
    //   566: ifnonnull +134 -> 700
    //   569: ldc_w 464
    //   572: ldc_w 2417
    //   575: invokestatic 2226	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   578: aload_0
    //   579: invokevirtual 2227	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:finish	()V
    //   582: ldc_w 2289
    //   585: invokestatic 301	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   588: return
    //   589: astore_1
    //   590: ldc_w 464
    //   593: aload_1
    //   594: ldc 253
    //   596: iconst_0
    //   597: anewarray 468	java/lang/Object
    //   600: invokestatic 1801	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   603: invokestatic 2422	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   606: ldc_w 2424
    //   609: iconst_0
    //   610: invokestatic 2430	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   613: invokevirtual 2431	android/widget/Toast:show	()V
    //   616: ldc_w 2289
    //   619: invokestatic 301	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   622: return
    //   623: aload_0
    //   624: invokevirtual 1825	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   627: ldc_w 2433
    //   630: invokevirtual 2437	android/content/Intent:getByteArrayExtra	(Ljava/lang/String;)[B
    //   633: astore_1
    //   634: aload_1
    //   635: ifnull +58 -> 693
    //   638: aload_0
    //   639: new 512	com/tencent/mm/plugin/luckymoney/model/q
    //   642: dup
    //   643: invokespecial 2438	com/tencent/mm/plugin/luckymoney/model/q:<init>	()V
    //   646: aload_1
    //   647: invokevirtual 2442	com/tencent/mm/plugin/luckymoney/model/q:parseFrom	([B)Lcom/tencent/mm/bw/a;
    //   650: checkcast 512	com/tencent/mm/plugin/luckymoney/model/q
    //   653: putfield 414	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:zdU	Lcom/tencent/mm/plugin/luckymoney/model/q;
    //   656: goto -98 -> 558
    //   659: astore_1
    //   660: ldc_w 464
    //   663: new 865	java/lang/StringBuilder
    //   666: dup
    //   667: ldc_w 2444
    //   670: invokespecial 870	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   673: aload_1
    //   674: invokevirtual 2447	java/lang/Exception:getLocalizedMessage	()Ljava/lang/String;
    //   677: invokevirtual 935	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   680: invokevirtual 878	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   683: invokestatic 2226	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   686: aload_0
    //   687: invokevirtual 2227	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:finish	()V
    //   690: goto -132 -> 558
    //   693: aload_0
    //   694: invokevirtual 2227	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:finish	()V
    //   697: goto -139 -> 558
    //   700: aload_0
    //   701: getfield 414	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:zdU	Lcom/tencent/mm/plugin/luckymoney/model/q;
    //   704: ifnull +67 -> 771
    //   707: aload_0
    //   708: getfield 414	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:zdU	Lcom/tencent/mm/plugin/luckymoney/model/q;
    //   711: getfield 1132	com/tencent/mm/plugin/luckymoney/model/q:yVB	Ljava/lang/String;
    //   714: invokestatic 1138	com/tencent/mm/plugin/luckymoney/model/bh:aDy	(Ljava/lang/String;)Lcom/tencent/mm/plugin/luckymoney/model/bh;
    //   717: astore_1
    //   718: aload_1
    //   719: ifnull +52 -> 771
    //   722: aload_1
    //   723: getfield 1145	com/tencent/mm/plugin/luckymoney/model/bh:yUC	Lcom/tencent/mm/protocal/protobuf/cbe;
    //   726: ifnull +45 -> 771
    //   729: aload_0
    //   730: getfield 1614	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:zdT	Ljava/lang/String;
    //   733: invokestatic 598	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   736: ifeq +14 -> 750
    //   739: aload_0
    //   740: aload_1
    //   741: getfield 1145	com/tencent/mm/plugin/luckymoney/model/bh:yUC	Lcom/tencent/mm/protocal/protobuf/cbe;
    //   744: getfield 1159	com/tencent/mm/protocal/protobuf/cbe:Lot	Ljava/lang/String;
    //   747: putfield 1614	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:zdT	Ljava/lang/String;
    //   750: aload_0
    //   751: getfield 1153	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:zdE	Ljava/lang/String;
    //   754: invokestatic 598	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   757: ifeq +14 -> 771
    //   760: aload_0
    //   761: aload_1
    //   762: getfield 1145	com/tencent/mm/plugin/luckymoney/model/bh:yUC	Lcom/tencent/mm/protocal/protobuf/cbe;
    //   765: getfield 1156	com/tencent/mm/protocal/protobuf/cbe:MgB	Ljava/lang/String;
    //   768: putfield 1153	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:zdE	Ljava/lang/String;
    //   771: aload_0
    //   772: getfield 923	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:gAn	Ljava/lang/String;
    //   775: invokestatic 928	com/tencent/mm/model/ab:IN	(Ljava/lang/String;)Z
    //   778: ifeq +242 -> 1020
    //   781: ldc_w 464
    //   784: ldc_w 2449
    //   787: invokestatic 881	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   790: aload_0
    //   791: getfield 2045	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:gof	J
    //   794: invokestatic 2454	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   797: invokestatic 2457	com/tencent/mm/plugin/luckymoney/a/b:j	(Ljava/lang/Long;)Lcom/tencent/mm/protocal/protobuf/dls;
    //   800: astore_1
    //   801: aload_1
    //   802: ifnull +11 -> 813
    //   805: aload_0
    //   806: aload_1
    //   807: getfield 2463	com/tencent/mm/protocal/protobuf/dls:MaT	Lcom/tencent/mm/protocal/protobuf/dlt;
    //   810: invokespecial 2465	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:b	(Lcom/tencent/mm/protocal/protobuf/dlt;)V
    //   813: aload_0
    //   814: aload_0
    //   815: getfield 414	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:zdU	Lcom/tencent/mm/plugin/luckymoney/model/q;
    //   818: invokespecial 1601	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:a	(Lcom/tencent/mm/plugin/luckymoney/model/q;)V
    //   821: aload_0
    //   822: invokevirtual 1825	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   825: ldc_w 2467
    //   828: iconst_0
    //   829: invokevirtual 2305	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   832: ifeq +10 -> 842
    //   835: aload_0
    //   836: getstatic 2473	com/tencent/mm/plugin/luckymoney/ui/l$a:zjb	Lcom/tencent/mm/plugin/luckymoney/ui/l$a;
    //   839: invokestatic 2478	com/tencent/mm/plugin/luckymoney/ui/l:a	(Landroid/content/Context;Lcom/tencent/mm/plugin/luckymoney/ui/l$a;)V
    //   842: aload_0
    //   843: invokevirtual 1825	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   846: ldc_w 2331
    //   849: iconst_0
    //   850: invokevirtual 1831	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   853: pop
    //   854: aload_0
    //   855: getfield 923	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:gAn	Ljava/lang/String;
    //   858: invokestatic 928	com/tencent/mm/model/ab:IN	(Ljava/lang/String;)Z
    //   861: ifne +19 -> 880
    //   864: aload_0
    //   865: iconst_0
    //   866: ldc_w 2479
    //   869: new 2481	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$27
    //   872: dup
    //   873: aload_0
    //   874: invokespecial 2482	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$27:<init>	(Lcom/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI;)V
    //   877: invokevirtual 2486	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:addIconOptionMenu	(IILandroid/view/MenuItem$OnMenuItemClickListener;)V
    //   880: aload_0
    //   881: getfield 1021	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:zcj	I
    //   884: iconst_4
    //   885: if_icmpeq +11 -> 896
    //   888: aload_0
    //   889: getfield 1021	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:zcj	I
    //   892: iconst_2
    //   893: if_icmpne +195 -> 1088
    //   896: iconst_1
    //   897: istore_2
    //   898: aload_0
    //   899: getfield 923	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:gAn	Ljava/lang/String;
    //   902: astore_1
    //   903: new 2488	com/tencent/mm/plugin/luckymoney/story/b/e
    //   906: dup
    //   907: invokespecial 2489	com/tencent/mm/plugin/luckymoney/story/b/e:<init>	()V
    //   910: astore 5
    //   912: aload 5
    //   914: aload_0
    //   915: getfield 1381	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:yUc	Ljava/lang/String;
    //   918: putfield 2492	com/tencent/mm/plugin/luckymoney/story/b/e:field_send_id	Ljava/lang/String;
    //   921: invokestatic 1396	com/tencent/mm/plugin/luckymoney/b/a:eex	()Lcom/tencent/mm/plugin/luckymoney/b/a;
    //   924: invokevirtual 2496	com/tencent/mm/plugin/luckymoney/b/a:eew	()Lcom/tencent/mm/plugin/luckymoney/story/b/f;
    //   927: aload 5
    //   929: iconst_0
    //   930: anewarray 610	java/lang/String
    //   933: invokevirtual 2501	com/tencent/mm/plugin/luckymoney/story/b/f:get	(Lcom/tencent/mm/sdk/storage/IAutoDBItem;[Ljava/lang/String;)Z
    //   936: istore 4
    //   938: ldc_w 464
    //   941: ldc_w 2503
    //   944: iconst_2
    //   945: anewarray 468	java/lang/Object
    //   948: dup
    //   949: iconst_0
    //   950: iload 4
    //   952: invokestatic 1539	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   955: aastore
    //   956: dup
    //   957: iconst_1
    //   958: aload_0
    //   959: getfield 1381	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:yUc	Ljava/lang/String;
    //   962: aastore
    //   963: invokestatic 2505	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   966: iload 4
    //   968: ifeq +146 -> 1114
    //   971: aload 5
    //   973: getfield 2508	com/tencent/mm/plugin/luckymoney/story/b/e:field_open_count	I
    //   976: ifgt +133 -> 1109
    //   979: aload 5
    //   981: aload 5
    //   983: getfield 2508	com/tencent/mm/plugin/luckymoney/story/b/e:field_open_count	I
    //   986: iconst_1
    //   987: iadd
    //   988: putfield 2508	com/tencent/mm/plugin/luckymoney/story/b/e:field_open_count	I
    //   991: invokestatic 1396	com/tencent/mm/plugin/luckymoney/b/a:eex	()Lcom/tencent/mm/plugin/luckymoney/b/a;
    //   994: invokevirtual 2496	com/tencent/mm/plugin/luckymoney/b/a:eew	()Lcom/tencent/mm/plugin/luckymoney/story/b/f;
    //   997: aload 5
    //   999: iconst_0
    //   1000: anewarray 610	java/lang/String
    //   1003: invokevirtual 2511	com/tencent/mm/plugin/luckymoney/story/b/f:update	(Lcom/tencent/mm/sdk/storage/IAutoDBItem;[Ljava/lang/String;)Z
    //   1006: pop
    //   1007: iload_2
    //   1008: aload_1
    //   1009: iload_3
    //   1010: invokestatic 2516	com/tencent/mm/plugin/luckymoney/story/a:m	(ILjava/lang/String;I)V
    //   1013: ldc_w 2289
    //   1016: invokestatic 301	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1019: return
    //   1020: aload_0
    //   1021: getfield 1614	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:zdT	Ljava/lang/String;
    //   1024: invokestatic 598	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   1027: ifne +53 -> 1080
    //   1030: aload_0
    //   1031: getfield 1614	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:zdT	Ljava/lang/String;
    //   1034: invokestatic 2520	com/tencent/mm/plugin/luckymoney/a/b:aDo	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/dlt;
    //   1037: astore_1
    //   1038: aload_1
    //   1039: ifnull +35 -> 1074
    //   1042: iconst_1
    //   1043: istore 4
    //   1045: ldc_w 464
    //   1048: ldc_w 2522
    //   1051: iconst_1
    //   1052: anewarray 468	java/lang/Object
    //   1055: dup
    //   1056: iconst_0
    //   1057: iload 4
    //   1059: invokestatic 1539	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1062: aastore
    //   1063: invokestatic 484	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1066: aload_0
    //   1067: aload_1
    //   1068: invokespecial 2465	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:b	(Lcom/tencent/mm/protocal/protobuf/dlt;)V
    //   1071: goto -258 -> 813
    //   1074: iconst_0
    //   1075: istore 4
    //   1077: goto -32 -> 1045
    //   1080: aload_0
    //   1081: aconst_null
    //   1082: invokespecial 2465	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:b	(Lcom/tencent/mm/protocal/protobuf/dlt;)V
    //   1085: goto -272 -> 813
    //   1088: aload_0
    //   1089: getfield 1021	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:zcj	I
    //   1092: iconst_1
    //   1093: if_icmpeq +11 -> 1104
    //   1096: aload_0
    //   1097: getfield 1021	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:zcj	I
    //   1100: iconst_3
    //   1101: if_icmpne +26 -> 1127
    //   1104: iconst_2
    //   1105: istore_2
    //   1106: goto -208 -> 898
    //   1109: iconst_2
    //   1110: istore_3
    //   1111: goto -132 -> 979
    //   1114: iconst_2
    //   1115: istore_3
    //   1116: goto -109 -> 1007
    //   1119: astore_1
    //   1120: goto -682 -> 438
    //   1123: astore_1
    //   1124: goto -941 -> 183
    //   1127: iconst_0
    //   1128: istore_2
    //   1129: goto -231 -> 898
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1132	0	this	LuckyMoneyDetailUI
    //   0	1132	1	paramBundle	Bundle
    //   897	232	2	i	int
    //   1	1115	3	j	int
    //   936	140	4	bool	boolean
    //   910	88	5	locale	com.tencent.mm.plugin.luckymoney.story.b.e
    // Exception table:
    //   from	to	target	type
    //   46	51	589	java/lang/Exception
    //   438	506	659	java/lang/Exception
    //   506	541	659	java/lang/Exception
    //   541	549	659	java/lang/Exception
    //   553	558	659	java/lang/Exception
    //   623	634	659	java/lang/Exception
    //   638	656	659	java/lang/Exception
    //   693	697	659	java/lang/Exception
    //   427	438	1119	java/lang/Exception
    //   159	183	1123	java/lang/Exception
  }
  
  public boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
  {
    AppMethodBeat.i(65558);
    boolean bool = super.onCreatePanelMenu(paramInt, paramMenu);
    paramMenu = (TextView)findViewById(2131296402);
    if (paramMenu != null) {
      paramMenu.setTextColor(getResources().getColor(2131100744));
    }
    AppMethodBeat.o(65558);
    return bool;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(65577);
    super.onDestroy();
    if ((this.zeb == 1) || (this.zeb == 2))
    {
      this.zdz = new hf();
      this.zdz.eEH = 12L;
      this.zdz.bfK();
    }
    if (this.yRy != null)
    {
      this.yRy.release();
      int i = 0;
      while (i < this.zdc.length)
      {
        this.yRy.unload(this.zdc[i]);
        i += 1;
      }
    }
    if (this.zdv != null)
    {
      Log.i("MicroMsg.LuckyMoneyDetailUI", "commentfooter release");
      this.zdv.onPause();
      this.zdv.goC();
      this.zdv.destroy();
    }
    k.cGd().rbg = null;
    com.tencent.mm.plugin.luckymoney.a.b.clear();
    com.tencent.mm.plugin.luckymoney.a.c.openId = null;
    com.tencent.mm.plugin.luckymoney.a.c.haD = null;
    com.tencent.mm.plugin.luckymoney.a.c.yOW = null;
    com.tencent.mm.plugin.luckymoney.a.c.iNV = null;
    com.tencent.mm.plugin.luckymoney.a.c.yOY = 0;
    com.tencent.mm.plugin.luckymoney.a.c.yOX = 0;
    com.tencent.mm.plugin.luckymoney.story.a.xV(1);
    com.tencent.mm.kernel.g.aAg().hqi.b(697, this.zdZ);
    AppMethodBeat.o(65577);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(213384);
    boolean bool;
    if (paramInt != 4)
    {
      bool = super.onKeyUp(paramInt, paramKeyEvent);
      AppMethodBeat.o(213384);
      return bool;
    }
    if (this.zdG == null)
    {
      bool = super.onKeyUp(paramInt, paramKeyEvent);
      AppMethodBeat.o(213384);
      return bool;
    }
    if (!com.tencent.mm.plugin.wallet_core.utils.c.a(this.zdG))
    {
      bool = super.onKeyUp(paramInt, paramKeyEvent);
      AppMethodBeat.o(213384);
      return bool;
    }
    this.zdH.a(this.zdG, new com.tencent.mm.plugin.wallet_core.utils.c.a()
    {
      public final void a(cfl paramAnonymouscfl)
      {
        AppMethodBeat.i(213379);
        if (paramAnonymouscfl.action == 1)
        {
          LuckyMoneyDetailUI.this.finish();
          AppMethodBeat.o(213379);
          return;
        }
        AppMethodBeat.o(213379);
      }
    });
    this.zdG = null;
    AppMethodBeat.o(213384);
    return true;
  }
  
  public void onKeyboardStateChanged()
  {
    AppMethodBeat.i(65564);
    super.onKeyboardStateChanged();
    Log.d("MicroMsg.LuckyMoneyDetailUI", "keyboard changed: %s", new Object[] { Integer.valueOf(keyboardState()) });
    keyboardState();
    AppMethodBeat.o(65564);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(65560);
    super.onPause();
    com.tencent.mm.modelstat.d.m("LuckyMoneyDetailUI", this.zdW, Util.nowSecond());
    AppMethodBeat.o(65560);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(65559);
    super.onResume();
    this.zdW = Util.nowSecond();
    AppMethodBeat.o(65559);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(65566);
    Log.i("MicroMsg.LuckyMoneyDetailUI", "onSceneEnd() errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " netsceneType:" + paramq.getType());
    if ((paramq instanceof com.tencent.mm.plugin.luckymoney.model.ao))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (com.tencent.mm.plugin.luckymoney.model.ao)paramq;
        paramq = paramString.yWT;
        this.zcp = paramString.yXg;
        this.rcU = paramString.yXh;
        this.zdu = paramString.yXi;
        this.zdy = paramString.yXj;
        this.zdU = paramq;
        a(this.zdU);
        AppMethodBeat.o(65566);
        return true;
      }
      com.tencent.mm.ui.base.h.cD(this, paramString);
      AppMethodBeat.o(65566);
      return true;
    }
    if ((paramq instanceof ax))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.yQg = false;
        paramString = (ax)paramq;
        if (this.yQe != null) {
          paramInt1 = 0;
        }
        for (;;)
        {
          if (paramInt1 < this.yQe.size())
          {
            paramq = (ad)this.yQe.get(paramInt1);
            if (paramq.yVk.equalsIgnoreCase(paramString.yVk))
            {
              paramq.yWF = paramString.yPK;
              this.zdR.atj.notifyChanged();
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
      com.tencent.mm.ui.base.h.cD(this, paramString);
      AppMethodBeat.o(65566);
      return true;
    }
    if ((paramq instanceof bf))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.ui.widget.snackbar.b.r(this, getString(2131761619));
        AppMethodBeat.o(65566);
        return true;
      }
      com.tencent.mm.ui.base.h.cD(this, paramString);
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
    public ad zep;
    
    a() {}
    
    public final int cxn()
    {
      return 2;
    }
    
    public final long lT()
    {
      AppMethodBeat.i(163737);
      long l = this.zep.yVk.hashCode();
      AppMethodBeat.o(163737);
      return l;
    }
  }
  
  final class b
    extends com.tencent.mm.view.recyclerview.e<LuckyMoneyDetailUI.a>
  {
    b() {}
    
    public final void a(RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.h paramh, int paramInt) {}
    
    public final int getLayoutId()
    {
      return 2131495383;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI
 * JD-Core Version:    0.7.0.1
 */