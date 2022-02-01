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
import android.graphics.drawable.Drawable;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Looper;
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
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.k;
import com.tencent.mm.an.c.a;
import com.tencent.mm.an.t;
import com.tencent.mm.api.ac.a;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.f.a.kg;
import com.tencent.mm.f.a.kg.b;
import com.tencent.mm.f.b.a.ji;
import com.tencent.mm.f.b.a.jj;
import com.tencent.mm.f.b.a.jk;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.az.b.a;
import com.tencent.mm.plugin.emoji.model.i.a;
import com.tencent.mm.plugin.emoji.model.p;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.luckymoney.model.LuckyMoneyEmojiSwitch;
import com.tencent.mm.plugin.luckymoney.model.aa;
import com.tencent.mm.plugin.luckymoney.model.ae;
import com.tencent.mm.plugin.luckymoney.model.ag;
import com.tencent.mm.plugin.luckymoney.model.ap;
import com.tencent.mm.plugin.luckymoney.model.ay;
import com.tencent.mm.plugin.luckymoney.model.bg;
import com.tencent.mm.plugin.luckymoney.model.bh;
import com.tencent.mm.plugin.luckymoney.model.bi;
import com.tencent.mm.plugin.luckymoney.story.EnvelopeAppBarLayout;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.af;
import com.tencent.mm.plugin.wallet_core.ui.r.a;
import com.tencent.mm.plugin.wallet_core.utils.g.a;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.pluginsdk.ui.chat.e.b;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.bmf;
import com.tencent.mm.protocal.protobuf.cjf;
import com.tencent.mm.protocal.protobuf.cjg;
import com.tencent.mm.protocal.protobuf.cjh;
import com.tencent.mm.protocal.protobuf.cjj;
import com.tencent.mm.protocal.protobuf.coi;
import com.tencent.mm.protocal.protobuf.dvl;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.v;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

@com.tencent.mm.ui.base.a(35)
public class LuckyMoneyDetailUI
  extends LuckyMoneyBaseUI
{
  private TextView DLp;
  private String EDR;
  private String EDS;
  private int EGA;
  private View EGG;
  private boolean EGI;
  private int EGJ;
  private String EGK;
  private String EGL;
  private Map<String, Integer> EGN;
  private String EGP;
  private boolean EGQ;
  private int EGw;
  private String EGy;
  private String EGz;
  private ViewGroup EHA;
  private RelativeLayout EHB;
  private int[] EHC;
  private ViewGroup EHD;
  private LinearLayout EHE;
  private LinearLayout EHF;
  private LinearLayout EHG;
  private BaseEmojiView EHH;
  private RelativeLayout EHI;
  private ImageView EHJ;
  private a EHK;
  private View EHL;
  private ImageView EHM;
  private View EHN;
  private ViewGroup EHO;
  private TextView EHP;
  private ImageView EHQ;
  private EnvelopeAppBarLayout EHR;
  private ArrayList<a> EHS;
  private boolean EHT;
  private int EHU;
  private EmojiInfo EHV;
  private ViewGroup EHW;
  public LuckyMoneyEmojiSwitch EHX;
  private jk EHY;
  private ji EHZ;
  private RecyclerView EHq;
  private CdnImageView EHr;
  private View EHs;
  private ImageView EHt;
  private ViewGroup EHu;
  private View EHv;
  private View EHw;
  private View EHx;
  private TextView EHy;
  private TextView EHz;
  private com.tencent.mm.an.i EIA;
  private int EIB;
  private int EIC;
  private final int EID;
  private final int EIE;
  private jj EIa;
  private int EIb;
  private boolean EIc;
  private String EId;
  private int EIe;
  private com.tencent.mm.plugin.wallet_core.utils.b EIf;
  private com.tencent.mm.plugin.wallet_core.utils.g EIg;
  private int EIh;
  private Set<String> EIi;
  private Bitmap EIj;
  private Bitmap EIk;
  private Bitmap EIl;
  private Bitmap EIm;
  private Bitmap EIn;
  private Bitmap EIo;
  private Bitmap EIp;
  private Bitmap EIq;
  private boolean EIr;
  private WxRecyclerAdapter EIs;
  private int EIt;
  private String EIu;
  private com.tencent.mm.plugin.luckymoney.model.q EIv;
  private com.tencent.mm.plugin.luckymoney.hk.a.a EIw;
  private long EIx;
  private View.OnClickListener EIy;
  private int EIz;
  private List<ae> Eud;
  private boolean Euf;
  private int Eug;
  private TextView Euj;
  private ImageView Eus;
  private TextView Eut;
  private ImageView Euu;
  private View Euv;
  private View Euw;
  private SoundPool Evw;
  private com.tencent.mm.particles.b EwY;
  private String ExZ;
  private RelativeLayout Eyi;
  private BaseEmojiView Eyj;
  private TextView Eyk;
  private LinearLayout Eyl;
  private ProgressBar Eym;
  private String Eyn;
  private int Ezs;
  RecyclerView.l ahp;
  private long iSo;
  private int jaR;
  private String jkq;
  private View mL;
  private TextView mMA;
  private boolean puR;
  private TextView qCM;
  private ChatFooterPanel rzI;
  private Dialog tipDialog;
  private i.a uEk;
  private String uFZ;
  private View uIP;
  private EmojiInfo uIz;
  private int uav;
  private ImageView voG;
  private int zP;
  
  public LuckyMoneyDetailUI()
  {
    AppMethodBeat.i(65556);
    this.zP = 0;
    this.EGI = true;
    this.puR = false;
    this.Ezs = -1;
    this.Eud = new LinkedList();
    this.EHS = new ArrayList();
    this.EGN = new HashMap();
    this.EGP = "";
    this.EHT = false;
    this.EGQ = false;
    this.EIb = 0;
    this.EIc = false;
    this.EIi = new HashSet();
    this.ahp = new RecyclerView.l()
    {
      private boolean EuA;
      private boolean Euz = false;
      
      public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(275815);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousRecyclerView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).sg(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        if (paramAnonymousRecyclerView.getAdapter().getItemCount() == 0)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
          AppMethodBeat.o(275815);
          return;
        }
        switch (paramAnonymousInt)
        {
        }
        for (this.Euz = true;; this.Euz = false)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
          AppMethodBeat.o(275815);
          return;
          localObject = (LinearLayoutManager)paramAnonymousRecyclerView.getLayoutManager();
          if ((((LinearLayoutManager)localObject).kL() == LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this).size()) || (((LinearLayoutManager)localObject).kL() == paramAnonymousRecyclerView.getAdapter().getItemCount() - 1))
          {
            if (!LuckyMoneyDetailUI.this.EGu.isProcessing()) {
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
        AppMethodBeat.i(275818);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousRecyclerView);
        localb.sg(paramAnonymousInt1);
        localb.sg(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aFi());
        if ((paramAnonymousRecyclerView.getAdapter().getItemCount() == 0) || (!this.Euz))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
          AppMethodBeat.o(275818);
          return;
        }
        paramAnonymousRecyclerView = (LinearLayoutManager)paramAnonymousRecyclerView.getLayoutManager();
        boolean bool;
        if (paramAnonymousRecyclerView.kJ() > 0)
        {
          bool = true;
          if (this.EuA != bool)
          {
            if (bool) {
              LuckyMoneyDetailUI.this.getResources().getDrawable(a.e.lucky_money_actionbar_bg);
            }
            this.EuA = bool;
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
          AppMethodBeat.o(275818);
          return;
        }
        paramAnonymousRecyclerView = paramAnonymousRecyclerView.findViewByPosition(paramAnonymousRecyclerView.kJ());
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
    this.EwY = new com.tencent.mm.particles.b()
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
            LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, a.e.lucky_money_f2f_firework_ribbon_1));
          }
          paramAnonymousRandom = new com.tencent.mm.particles.a.a(LuckyMoneyDetailUI.f(LuckyMoneyDetailUI.this));
          AppMethodBeat.o(65527);
          return paramAnonymousRandom;
        case 1: 
          if (LuckyMoneyDetailUI.g(LuckyMoneyDetailUI.this) == null) {
            LuckyMoneyDetailUI.b(LuckyMoneyDetailUI.this, LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, a.e.lucky_money_f2f_firework_ribbon_2));
          }
          paramAnonymousRandom = new com.tencent.mm.particles.a.a(LuckyMoneyDetailUI.g(LuckyMoneyDetailUI.this));
          AppMethodBeat.o(65527);
          return paramAnonymousRandom;
        case 2: 
          if (LuckyMoneyDetailUI.h(LuckyMoneyDetailUI.this) == null) {
            LuckyMoneyDetailUI.c(LuckyMoneyDetailUI.this, LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, a.e.lucky_money_f2f_firework_ribbon_3));
          }
          paramAnonymousRandom = new com.tencent.mm.particles.a.a(LuckyMoneyDetailUI.h(LuckyMoneyDetailUI.this));
          AppMethodBeat.o(65527);
          return paramAnonymousRandom;
        case 3: 
          if (LuckyMoneyDetailUI.i(LuckyMoneyDetailUI.this) == null) {
            LuckyMoneyDetailUI.d(LuckyMoneyDetailUI.this, LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, a.e.lucky_money_f2f_firework_leaf_top_1));
          }
          paramAnonymousRandom = new com.tencent.mm.particles.a.a(LuckyMoneyDetailUI.i(LuckyMoneyDetailUI.this));
          AppMethodBeat.o(65527);
          return paramAnonymousRandom;
        case 4: 
          if (LuckyMoneyDetailUI.j(LuckyMoneyDetailUI.this) == null) {
            LuckyMoneyDetailUI.e(LuckyMoneyDetailUI.this, LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, a.e.lucky_money_f2f_firework_leaf_top_2));
          }
          paramAnonymousRandom = new com.tencent.mm.particles.a.a(LuckyMoneyDetailUI.j(LuckyMoneyDetailUI.this));
          AppMethodBeat.o(65527);
          return paramAnonymousRandom;
        case 5: 
          if (LuckyMoneyDetailUI.k(LuckyMoneyDetailUI.this) == null) {
            LuckyMoneyDetailUI.f(LuckyMoneyDetailUI.this, LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, a.e.lucky_money_f2f_firework_leaf_top_3));
          }
          paramAnonymousRandom = new com.tencent.mm.particles.a.a(LuckyMoneyDetailUI.k(LuckyMoneyDetailUI.this));
          AppMethodBeat.o(65527);
          return paramAnonymousRandom;
        case 6: 
          if (LuckyMoneyDetailUI.l(LuckyMoneyDetailUI.this) == null) {
            LuckyMoneyDetailUI.g(LuckyMoneyDetailUI.this, LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, a.e.lucky_money_f2f_firework_leaf_top_4));
          }
          paramAnonymousRandom = new com.tencent.mm.particles.a.a(LuckyMoneyDetailUI.l(LuckyMoneyDetailUI.this));
          AppMethodBeat.o(65527);
          return paramAnonymousRandom;
        }
        if (LuckyMoneyDetailUI.m(LuckyMoneyDetailUI.this) == null) {
          LuckyMoneyDetailUI.h(LuckyMoneyDetailUI.this, LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, a.e.lucky_money_f2f_firework_leaf_top_5));
        }
        paramAnonymousRandom = new com.tencent.mm.particles.a.a(LuckyMoneyDetailUI.m(LuckyMoneyDetailUI.this));
        AppMethodBeat.o(65527);
        return paramAnonymousRandom;
      }
    };
    this.EIr = false;
    this.uEk = new i.a()
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
                LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, p.getEmojiStorageMgr().VFH.bxK(LuckyMoneyDetailUI.n(LuckyMoneyDetailUI.this).getMd5()));
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
    this.Euf = false;
    this.EIx = 0L;
    this.EIy = new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(65522);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, new ji());
        if (Util.isEqual(paramAnonymousView.getId(), a.f.lucky_money_thx_select_emoji_ll))
        {
          LuckyMoneyDetailUI.y(LuckyMoneyDetailUI.this).gCd = 1L;
          LuckyMoneyDetailUI.y(LuckyMoneyDetailUI.this).bpa();
        }
        if ((Util.isEqual(LuckyMoneyDetailUI.this.EHX.EzJ, 0)) && (Util.isEqual(paramAnonymousView.getTag(), "nodelete")))
        {
          LuckyMoneyDetailUI.E(LuckyMoneyDetailUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(65522);
          return;
        }
        localObject = new com.tencent.mm.ui.widget.a.e(LuckyMoneyDetailUI.this.getContext(), 1, false);
        ((com.tencent.mm.ui.widget.a.e)localObject).ODT = new q.f()
        {
          public final void onCreateMMMenu(o paramAnonymous2o)
          {
            AppMethodBeat.i(273980);
            String str = LuckyMoneyDetailUI.this.getString(a.i.lucky_money_select_had_expression);
            if (!Util.isEqual(LuckyMoneyDetailUI.this.EHX.EzJ, 0)) {
              paramAnonymous2o.mn(1, a.i.lucky_money_newyear_shoot_expression);
            }
            for (;;)
            {
              paramAnonymous2o.d(2, str);
              if (!Util.isEqual(paramAnonymousView.getTag(), "nodelete")) {
                paramAnonymous2o.a(3, LuckyMoneyDetailUI.this.getResources().getColor(a.c.lucky_money_newyear_shoot_expression_color), LuckyMoneyDetailUI.this.getContext().getString(a.i.lucky_money_delete_emoji));
              }
              AppMethodBeat.o(273980);
              return;
              str = LuckyMoneyDetailUI.this.getString(a.i.lucky_money_exchange_one_expression);
            }
          }
        };
        ((com.tencent.mm.ui.widget.a.e)localObject).ODU = new q.g()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(271557);
            Log.i("MicroMsg.LuckyMoneyDetailUI", "showLuckyHbDlg() onMMMenuItemSelected menuItemId:%s", new Object[] { Integer.valueOf(paramAnonymous2MenuItem.getItemId()) });
            switch (paramAnonymous2MenuItem.getItemId())
            {
            }
            for (;;)
            {
              AppMethodBeat.o(271557);
              return;
              com.tencent.mm.plugin.emojicapture.api.b.b(LuckyMoneyDetailUI.this, 5, LuckyMoneyDetailUI.x(LuckyMoneyDetailUI.this));
              LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, new ji());
              LuckyMoneyDetailUI.y(LuckyMoneyDetailUI.this).gCd = 4L;
              LuckyMoneyDetailUI.y(LuckyMoneyDetailUI.this).bpa();
              LuckyMoneyDetailUI.F(LuckyMoneyDetailUI.this);
              AppMethodBeat.o(271557);
              return;
              LuckyMoneyDetailUI.E(LuckyMoneyDetailUI.this);
              AppMethodBeat.o(271557);
              return;
              LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, null);
              LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, new ji());
              LuckyMoneyDetailUI.y(LuckyMoneyDetailUI.this).gCd = 8L;
              LuckyMoneyDetailUI.y(LuckyMoneyDetailUI.this).bpa();
              LuckyMoneyDetailUI.b(LuckyMoneyDetailUI.this, 1);
            }
          }
        };
        LuckyMoneyDetailUI.y(LuckyMoneyDetailUI.this).gCd = 2L;
        LuckyMoneyDetailUI.y(LuckyMoneyDetailUI.this).bpa();
        ((com.tencent.mm.ui.widget.a.e)localObject).eik();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(65522);
      }
    };
    this.EIz = 3;
    this.EIA = new LuckyMoneyDetailUI.10(this);
    this.EIB = 0;
    this.EIC = 0;
    this.EID = 750;
    this.EIE = 240;
    AppMethodBeat.o(65556);
  }
  
  private void C(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(65570);
    this.EIC = 3;
    this.Eyj.setEmojiInfo(paramEmojiInfo);
    this.EHY = new jk();
    this.EHY.gCd = 11L;
    this.EHY.bpa();
    AppMethodBeat.o(65570);
  }
  
  private static int Wb(int paramInt)
  {
    if (paramInt == 2) {
      return 13;
    }
    return 7;
  }
  
  private void Wd(int paramInt)
  {
    AppMethodBeat.i(65574);
    bD(paramInt, "");
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
    label117:
    int i;
    label168:
    int j;
    label201:
    label333:
    Object localObject1;
    label474:
    label492:
    Object localObject2;
    label609:
    Object localObject3;
    if (g(paramq)) {
      if (ePG())
      {
        if (!bool) {}
        if (!ePG()) {
          break label2187;
        }
        this.Eyi.setVisibility(0);
        tO(true);
        if ((!Util.isEqual(this.EHX.EzI, 0)) && (e(paramq)) && (this.EIc) && (paramq.Ezs != 7)) {
          break label2199;
        }
        Wd(0);
        if (paramq.Ezk != 1) {
          break label2406;
        }
        bool = true;
        this.EGI = bool;
        if (paramq != null)
        {
          if (((paramq.gbp != 3) && (paramq.gbp != 2)) || (paramq.Ezj != 1) || (this.EGI) || (paramq.Ezm != 1)) {
            break label2412;
          }
          i = 1;
          if ((paramq.Ezn == null) || (paramq.Ezn.jqz != 1) || (Util.isNullOrNil(paramq.Ezn.EyD))) {
            break label2417;
          }
          j = 1;
          this.EHy = ((TextView)this.uIP.findViewById(a.f.lucky_money_detail_send_btn));
          if ((i == 0) && (j == 0)) {
            break label2422;
          }
          this.EHy.setOnClickListener(new LuckyMoneyDetailUI.27(this, paramq));
          if (j != 0)
          {
            this.EGL = paramq.Ezn.EyD;
            this.EHy.setText(paramq.Ezn.EyE);
          }
          com.tencent.mm.plugin.report.service.h.IzE.a(11701, new Object[] { Integer.valueOf(Wb(paramq.Ezs)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2) });
          this.EHy.setVisibility(0);
          this.Ezs = paramq.Ezs;
          this.EHz = ((TextView)this.uIP.findViewById(a.f.lucky_money_detail_record_link));
          this.EHz.setVisibility(8);
          if (!this.EGQ)
          {
            this.EIs.h(this.uIP, 3, false);
            this.EGQ = true;
          }
        }
        if (this.zP == 0)
        {
          this.EGK = paramq.Ezh;
          localObject1 = this.EGK;
          if ((paramq == null) || (paramq.gbo != 0) || (paramq.Ezu == null) || (paramq.Ezu.size() <= 0) || (!((ae)paramq.Ezu.get(0)).Ezh.equals(localObject1)) || (paramq.Ezi == 1)) {
            break label2434;
          }
          i = 1;
          if (i == 0) {
            break label2439;
          }
          this.Euf = false;
          this.EHu.setVisibility(8);
          this.Eug = paramq.Ezs;
          if (paramq != null)
          {
            localObject2 = getContext();
            if (paramq.Ezs != 2) {
              break label2510;
            }
            this.Eus.setImageResource(a.e.lucky_money_busi_default_avatar);
            if (paramq.Ezt == 0) {
              break label2492;
            }
            Log.i("MicroMsg.LuckyMoneyDetailUI", "busi logo load from file:" + paramq.Ezt);
            localObject1 = new kg();
            ((kg)localObject1).fHH.fHJ = paramq.Ezt;
            ((kg)localObject1).callback = new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(265611);
                if (this.EGS.fHI.fHK)
                {
                  Log.i("MicroMsg.LuckyMoneyDetailUI", "Get res Ok, path=" + this.EGS.fHI.fHL);
                  LuckyMoneyDetailUI.this.getContext();
                  ag.e(LuckyMoneyDetailUI.P(LuckyMoneyDetailUI.this), this.EGS.fHI.fHL, a.e.lucky_money_busi_default_avatar);
                  AppMethodBeat.o(265611);
                  return;
                }
                Log.i("MicroMsg.LuckyMoneyDetailUI", "Get res fail & load from url.");
                ag.a(LuckyMoneyDetailUI.P(LuckyMoneyDetailUI.this), paramq.Ezb, paramq.Ezw);
                AppMethodBeat.o(265611);
              }
            };
            EventCenter.instance.asyncPublish((IEvent)localObject1, Looper.myLooper());
            if (Util.isNullOrNil(paramq.EzD)) {
              break label2622;
            }
            Log.i("MicroMsg.LuckyMoneyDetailUI", "use union sendername");
            if (!ab.Qg(this.jkq)) {
              break label2579;
            }
            localObject1 = paramq.Eza + paramq.EzD;
            label664:
            i = ((WindowManager)getSystemService("window")).getDefaultDisplay().getWidth();
            j = BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 92.0F);
            this.Eut.setMaxWidth(i - j);
            localObject3 = l.b(getContext(), (CharSequence)localObject1, this.Eut.getTextSize());
            l.b(getContext(), paramq.Eza, this.Eut.getTextSize());
            l.b(getContext(), paramq.EzD, this.Eut.getTextSize());
            localObject3 = new SpannableStringBuilder((CharSequence)localObject3);
            ((SpannableStringBuilder)localObject3).setSpan(new com.tencent.mm.plugin.wallet_core.ui.r("#FA9D3B", new LuckyMoneyDetailUI.19(this)), ((String)localObject1).lastIndexOf(paramq.EzD), ((String)localObject1).lastIndexOf(paramq.EzD) + paramq.EzD.length(), 18);
            this.Eut.setText((CharSequence)localObject3);
            ag.a((Context)localObject2, this.DLp, paramq.EtJ);
            if (Util.isNullOrNil(paramq.EtJ)) {
              break label2890;
            }
            this.DLp.setVisibility(0);
            label862:
            if (paramq.gbo != 1) {
              break label2902;
            }
            this.Euu.setVisibility(0);
            this.Euu.setImageResource(a.h.lucky_money_group_icon_new);
            label888:
            if (Util.isNullOrNil(paramq.Ezr)) {
              break label2980;
            }
            Log.i("MicroMsg.LuckyMoneyDetailUI", "hy: has url : %s", new Object[] { paramq.Ezr });
            this.EHB.setVisibility(4);
            ag.o(this.voG, paramq.Ezr);
            MMHandlerThread.postToMainThreadDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(65538);
                LuckyMoneyDetailUI.S(LuckyMoneyDetailUI.this);
                LuckyMoneyDetailUI.T(LuckyMoneyDetailUI.this).setVisibility(0);
                AppMethodBeat.o(65538);
              }
            }, 500L);
            label951:
            if ((paramq.gbq != 2) || (this.EGJ == 3)) {
              break label3001;
            }
            this.Euj.setText(com.tencent.mm.wallet_core.ui.g.formatMoney2f(paramq.gbJ / 100.0D));
            this.Euv.setVisibility(0);
            label994:
            if (Util.isNullOrNil(paramq.EzA)) {
              break label3013;
            }
            this.EHO.setVisibility(0);
            this.EHP.setText(paramq.EzA);
            this.EHQ.setOnClickListener(new LuckyMoneyDetailUI.22(this));
            localObject1 = (ViewGroup.MarginLayoutParams)this.Euw.getLayoutParams();
            if (localObject1 != null)
            {
              ((ViewGroup.MarginLayoutParams)localObject1).topMargin = com.tencent.mm.ci.a.fromDPToPix(getContext(), 16);
              this.Euw.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            }
            label1078:
            if (Util.isNullOrNil(paramq.EvM)) {
              break label3125;
            }
            this.Euw.setVisibility(0);
            this.qCM.setText(paramq.EvM);
            if (!ab.Qg(this.jkq)) {
              break label3025;
            }
            this.EHr.setVisibility(8);
            this.mL.findViewById(a.f.lucky_money_detail_tips_arrow_iv).setVisibility(8);
            label1141:
            if (Util.isNullOrNil(paramq.Ezl)) {
              break label3146;
            }
            this.mMA.setText(paramq.Ezl);
            this.EHu.setVisibility(0);
            if ((g(paramq)) && (!e(paramq)))
            {
              this.EHv.setVisibility(8);
              this.EHw.setVisibility(8);
              this.EHx.setVisibility(8);
            }
          }
          label1212:
          if (paramq != null)
          {
            localObject1 = paramq.Ezo;
            Object localObject4;
            Object localObject5;
            if ((localObject1 != null) && (((List)localObject1).size() > 0))
            {
              localObject2 = this.mL.findViewById(a.f.lucky_money_detail_operation_container_1);
              localObject3 = this.mL.findViewById(a.f.lucky_money_detail_operation_container_2);
              localObject4 = this.mL.findViewById(a.f.lucky_money_detail_operation_container_3);
              localObject5 = (ViewGroup)this.mL.findViewById(a.f.lucky_money_detail_operation_1);
              ViewGroup localViewGroup1 = (ViewGroup)this.mL.findViewById(a.f.lucky_money_detail_operation_2);
              ViewGroup localViewGroup2 = (ViewGroup)this.mL.findViewById(a.f.lucky_money_detail_operation_3);
              View localView1 = this.mL.findViewById(a.f.lucky_money_detail_divider_operation_1);
              View localView2 = this.mL.findViewById(a.f.lucky_money_detail_divider_operation_2);
              i.c localc = new i.c();
              localc.textColor = getResources().getColor(a.c.lucky_money_goldstyle_grey_text_color);
              if (((List)localObject1).size() > 0)
              {
                i.a(this, (ViewGroup)localObject5, (bh)((List)localObject1).get(0), localc);
                ((View)localObject2).setVisibility(0);
              }
              if (((List)localObject1).size() > 1)
              {
                i.a(this, localViewGroup1, (bh)((List)localObject1).get(1), localc);
                ((View)localObject3).setVisibility(0);
              }
              if (((List)localObject1).size() > 2)
              {
                i.a(this, localViewGroup2, (bh)((List)localObject1).get(2), localc);
                ((View)localObject4).setVisibility(0);
              }
              if ((((View)localObject2).getVisibility() == 0) && ((((View)localObject3).getVisibility() == 0) || (((View)localObject4).getVisibility() == 0))) {
                localView1.setVisibility(0);
              }
              if ((((View)localObject3).getVisibility() == 0) && (((View)localObject4).getVisibility() == 0)) {
                localView2.setVisibility(0);
              }
              if ((((View)localObject2).getVisibility() == 0) || (((View)localObject3).getVisibility() == 0) || (((View)localObject4).getVisibility() == 0))
              {
                this.EGG.requestLayout();
                this.EGG.setVisibility(0);
              }
            }
            this.EHA = ((ViewGroup)this.uIP.findViewById(a.f.lucky_money_detail_footer_operation));
            localObject2 = (ViewGroup)this.uIP.findViewById(a.f.lucky_money_detail_footer_operation_ll);
            localObject1 = new i.c();
            ((i.c)localObject1).textColor = getResources().getColor(a.c.UN_BW_0_Alpha_0_5);
            ((i.c)localObject1).textSize = getResources().getDimensionPixelSize(a.d.HintTextSize);
            i.a(this, this.EHA, paramq.Ezp, (i.c)localObject1);
            localObject1 = new i.c();
            ((i.c)localObject1).textColor = getResources().getColor(a.c.Link);
            ((i.c)localObject1).textSize = getResources().getDimensionPixelSize(a.d.HintTextSize);
            if ((paramq.Ezz != null) && (!ab.Qg(this.jkq)))
            {
              localObject3 = bi.aNH(paramq.Ezz);
              if ((localObject3 != null) && (((bi)localObject3).ECa != null))
              {
                ((i.c)localObject1).ELG = ((bi)localObject3).Eyz;
                if (((i.c)localObject1).ELG == null)
                {
                  ((i.c)localObject1).ELG = new cjf();
                  ((i.c)localObject1).ELG.Tqn = this.EId;
                }
                i.a(this, this.EHA, ((bi)localObject3).ECa, (i.c)localObject1);
                localObject1 = this.uIP.findViewById(a.f.lucky_money_detail_footer_operation_line);
                localObject4 = (TextView)this.uIP.findViewById(a.f.lucky_money_detail_footer_operation_complaint);
                ((TextView)localObject4).setTextSize(0, getContext().getResources().getDimensionPixelSize(a.d.HintTextSize));
                localObject5 = (LinearLayout.LayoutParams)this.EHA.getLayoutParams();
                ((LinearLayout.LayoutParams)localObject5).width = -1;
                this.EHA.setLayoutParams((ViewGroup.LayoutParams)localObject5);
                ((View)localObject1).setVisibility(8);
                ((TextView)localObject4).setVisibility(8);
                localObject1 = "";
                if (((bi)localObject3).Eyz != null) {
                  localObject1 = ((bi)localObject3).Eyz.SpP;
                }
                com.tencent.mm.plugin.report.service.h.IzE.a(16589, new Object[] { Integer.valueOf(1), ((bi)localObject3).ECa.content, this.EId, localObject1, Integer.valueOf(0), com.tencent.mm.plugin.luckymoney.a.c.openId });
              }
            }
            if (this.EHA.getVisibility() != 0) {
              break label3166;
            }
            ((ViewGroup)localObject2).setVisibility(0);
          }
        }
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.IzE.a(11701, new Object[] { Integer.valueOf(Wb(paramq.Ezs)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
      localObject1 = paramq.Ezu;
      if (localObject1 == null) {
        break label3207;
      }
      i = 0;
      while (i < ((List)localObject1).size())
      {
        localObject2 = (ae)((List)localObject1).get(i);
        if (!this.EGN.containsKey(((ae)localObject2).Ezh))
        {
          this.Eud.add(((List)localObject1).get(i));
          localObject3 = new a();
          ((a)localObject3).EIU = ((ae)((List)localObject1).get(i));
          this.EHS.add(localObject3);
          this.EGN.put(((ae)localObject2).Ezh, Integer.valueOf(1));
        }
        i += 1;
      }
      if (bool) {
        break;
      }
      break;
      if (bool)
      {
        if (ePG()) {
          break;
        }
        break;
      }
      ePG();
      break;
      label2187:
      this.Eyi.setVisibility(8);
      break label63;
      label2199:
      this.EHF.setOnClickListener(this.EIy);
      this.EHF.setTag("nodelete");
      this.EHJ.setOnClickListener(this.EIy);
      this.EHM.setOnClickListener(this.EIy);
      this.EHI.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(274551);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, new ji());
          LuckyMoneyDetailUI.y(LuckyMoneyDetailUI.this).gCd = 7L;
          LuckyMoneyDetailUI.y(LuckyMoneyDetailUI.this).bpa();
          LuckyMoneyDetailUI.c(LuckyMoneyDetailUI.this, LuckyMoneyDetailUI.ePK());
          Log.i("MicroMsg.LuckyMoneyDetailUI", "click mEmojiUseType：%s", new Object[] { Integer.valueOf(LuckyMoneyDetailUI.C(LuckyMoneyDetailUI.this)) });
          switch (LuckyMoneyDetailUI.C(LuckyMoneyDetailUI.this))
          {
          default: 
            LuckyMoneyDetailUI.D(LuckyMoneyDetailUI.this);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(274551);
            return;
            paramAnonymousView = (String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vob, "");
            LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, paramAnonymousView);
          }
        }
      });
      this.EHH.setOnClickListener(this.EIy);
      this.EIh = ePJ();
      Log.i("MicroMsg.LuckyMoneyDetailUI", "init mEmojiUseType：%s", new Object[] { Integer.valueOf(this.EIh) });
      switch (this.EIh)
      {
      default: 
        localObject1 = (String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Voc, "");
        Wd(1);
        if (Util.isNullOrNil((String)localObject1)) {
          break;
        }
        bD(2, (String)localObject1);
        break;
      case 1: 
        localObject1 = (String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vob, "");
        Wd(1);
        if (Util.isNullOrNil((String)localObject1)) {
          break;
        }
        bD(2, (String)localObject1);
        break;
        label2406:
        bool = false;
        break label117;
        label2412:
        i = 0;
        break label168;
        label2417:
        j = 0;
        break label201;
        label2422:
        this.EHy.setVisibility(8);
        break label333;
        label2434:
        i = 0;
        break label474;
        label2439:
        this.EHu.setVisibility(0);
        if ((!g(paramq)) || (e(paramq))) {
          break label492;
        }
        this.EHv.setVisibility(8);
        this.EHw.setVisibility(8);
        this.EHx.setVisibility(8);
        break label492;
        label2492:
        ag.a(this.Eus, paramq.Ezb, paramq.Ezw);
        break label609;
        label2510:
        if (ab.Qg(this.jkq))
        {
          this.Eus.setImageResource(a.e.new_wechat_icon);
          break label609;
        }
        if ((this.jaR == 3) && (paramq.EzF == 1))
        {
          this.Eus.setVisibility(8);
          break label609;
        }
        ag.a(this.Eus, paramq.Ezb, paramq.Ezw);
        break label609;
        label2579:
        localObject1 = getString(a.i.lucky_money_whose, new Object[] { paramq.Eza + paramq.EzD });
        break label664;
        label2622:
        Log.i("MicroMsg.LuckyMoneyDetailUI", "use union normal name");
        if (ab.Qg(this.jkq)) {
          localObject1 = paramq.Eza;
        }
        for (;;)
        {
          i = ((WindowManager)getSystemService("window")).getDefaultDisplay().getWidth();
          j = BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 92.0F);
          this.Eut.setMaxWidth(i - j);
          ag.a((Context)localObject2, this.Eut, (String)localObject1);
          break;
          if (!paramq.EzE)
          {
            if ((this.jaR == 3) || (paramq.gbo == 2)) {
              localObject1 = paramq.Eza;
            } else {
              localObject1 = getString(a.i.lucky_money_whose, new Object[] { paramq.Eza });
            }
          }
          else
          {
            com.tencent.mm.kernel.h.aHH();
            localObject1 = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().bwh(paramq.Ezw);
            if ((localObject1 != null) && (!Util.isNullOrNil(((ax)localObject1).field_username)))
            {
              localObject1 = getString(a.i.lucky_money_whose, new Object[] { paramq.Eza });
            }
            else
            {
              Log.i("MicroMsg.LuckyMoneyDetailUI", "do get contact: %s", new Object[] { paramq.Ezw });
              this.EIi.add(paramq.Ezw);
              az.a.ltq.a(paramq.Ezw, "", new az.b.a()
              {
                public final void s(final String paramAnonymousString, boolean paramAnonymousBoolean)
                {
                  AppMethodBeat.i(223115);
                  Log.v("MicroMsg.LuckyMoneyParseHelper", "getContact suc, user: %s", new Object[] { paramAnonymousString });
                  if (paramAnonymousBoolean) {
                    com.tencent.e.h.ZvG.bd(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(263000);
                        LuckyMoneyDetailUI.Q(LuckyMoneyDetailUI.this).remove(paramAnonymousString);
                        LuckyMoneyDetailUI.20.this.EGT.Eza = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.a.b.class)).PJ(LuckyMoneyDetailUI.20.this.EGT.Ezw);
                        ag.a(LuckyMoneyDetailUI.this.getContext(), LuckyMoneyDetailUI.R(LuckyMoneyDetailUI.this), LuckyMoneyDetailUI.this.getString(a.i.lucky_money_whose, new Object[] { LuckyMoneyDetailUI.20.this.EGT.Eza }));
                        AppMethodBeat.o(263000);
                      }
                    });
                  }
                  AppMethodBeat.o(223115);
                }
              });
              localObject1 = "";
            }
          }
        }
        label2890:
        this.DLp.setVisibility(8);
        break label862;
        label2902:
        if (paramq.gbo == 2)
        {
          if (!ab.Ql(paramq.Ezw))
          {
            localObject1 = new com.tencent.mm.am.j();
            ((com.tencent.mm.am.j)localObject1).username = paramq.Ezw;
            com.tencent.mm.am.q.bhP().b((com.tencent.mm.am.j)localObject1);
          }
          this.Euu.setVisibility(0);
          this.Euu.setImageResource(a.h.lucky_money_f2f_record_icon);
          break label888;
        }
        this.Euu.setVisibility(8);
        break label888;
        label2980:
        Log.i("MicroMsg.LuckyMoneyDetailUI", "hy: no bg. set bg area to gone");
        this.EHB.setVisibility(8);
        break label951;
        label3001:
        this.Euv.setVisibility(8);
        break label994;
        label3013:
        this.EHO.setVisibility(8);
        break label1078;
        label3025:
        if (paramq.EvK == 1)
        {
          Log.i("MicroMsg.LuckyMoneyDetailUI", "changeIconUrl: %s", new Object[] { paramq.Ezy });
          if (!Util.isNullOrNil(paramq.Ezy))
          {
            this.EHr.setUrl(paramq.Ezy);
            this.EHr.setVisibility(0);
          }
          for (;;)
          {
            this.qCM.setOnClickListener(new LuckyMoneyDetailUI.24(this, paramq));
            break;
            this.EHr.setVisibility(8);
          }
        }
        Log.e("MicroMsg.LuckyMoneyDetailUI", "detail.jumpChange is false");
        break label1141;
        label3125:
        Log.e("MicroMsg.LuckyMoneyDetailUI", "detail.changeWording is empty");
        this.Euw.setVisibility(8);
        break label1141;
        label3146:
        this.mMA.setText(null);
        this.EHu.setVisibility(8);
        break label1212;
        label3166:
        ((ViewGroup)localObject2).setVisibility(8);
      }
    }
    this.zP += ((List)localObject1).size();
    this.puR = false;
    this.EIs.alc.notifyChanged();
    label3207:
    if ((paramq.gbo == 2) && (!Util.isNullOrNil(paramq.EyZ)))
    {
      this.Evw = new SoundPool(2, 3, 0);
      this.EHC = new int[2];
    }
    try
    {
      this.EHC[0] = this.Evw.load(getResources().getAssets().openFd("most_lucky.m4a"), 0);
      this.EHC[1] = this.Evw.load(getResources().getAssets().openFd("whistle.m4a"), 0);
      this.Evw.setOnLoadCompleteListener(new LuckyMoneyDetailUI.16(this, paramq));
      this.mL.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(278155);
          LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, (ViewGroup)LuckyMoneyDetailUI.this.findViewById(a.f.lucky_money_f2f_firework_recv_container));
          Object localObject = LuckyMoneyDetailUI.N(LuckyMoneyDetailUI.this);
          com.tencent.mm.particles.b localb = LuckyMoneyDetailUI.O(LuckyMoneyDetailUI.this);
          com.tencent.mm.particles.a locala = new com.tencent.mm.particles.a((ViewGroup)localObject);
          localObject = new com.tencent.mm.particles.c(((ViewGroup)localObject).getContext(), localb, new com.tencent.mm.particles.d(-100, ((ViewGroup)localObject).getHeight() / 2), (ViewGroup)localObject).H(600.0F, 150.0F).I(-1000.0F, 250.0F).ay(-200.0F).az(1500.0F);
          ((com.tencent.mm.particles.c)localObject).mAa = 600.0F;
          ((com.tencent.mm.particles.c)localObject).mAb = 300.0F;
          localObject = ((com.tencent.mm.particles.c)localObject).buu();
          ((com.tencent.mm.particles.c)localObject).mzD = com.tencent.mm.particles.e.buC();
          locala.kFD = ((com.tencent.mm.particles.c)localObject).buv().buw();
          locala.G(100, 400L);
          localObject = LuckyMoneyDetailUI.N(LuckyMoneyDetailUI.this);
          localb = LuckyMoneyDetailUI.O(LuckyMoneyDetailUI.this);
          locala = new com.tencent.mm.particles.a((ViewGroup)localObject);
          localObject = new com.tencent.mm.particles.c(((ViewGroup)localObject).getContext(), localb, new com.tencent.mm.particles.d(((ViewGroup)localObject).getWidth() + 100, ((ViewGroup)localObject).getHeight() / 2), (ViewGroup)localObject).H(-600.0F, 150.0F).I(-1000.0F, 250.0F).ay(200.0F).az(1500.0F);
          ((com.tencent.mm.particles.c)localObject).mAa = 600.0F;
          ((com.tencent.mm.particles.c)localObject).mAb = 300.0F;
          localObject = ((com.tencent.mm.particles.c)localObject).buu();
          ((com.tencent.mm.particles.c)localObject).mzD = com.tencent.mm.particles.e.buC();
          locala.kFD = ((com.tencent.mm.particles.c)localObject).buv().buw();
          locala.G(100, 400L);
          AppMethodBeat.o(278155);
        }
      }, 300L);
      if (!ab.Qg(this.jkq))
      {
        localObject2 = com.tencent.mm.plugin.wallet_core.model.u.gJk().bhj(this.Eyn);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new af();
        }
        ((af)localObject1).field_mNativeUrl = this.Eyn;
        ((af)localObject1).field_receiveAmount = paramq.gbJ;
        ((af)localObject1).field_receiveTime = System.currentTimeMillis();
        ((af)localObject1).field_hbStatus = paramq.gbp;
        ((af)localObject1).field_receiveStatus = paramq.gbq;
        ((af)localObject1).field_sendId = this.ExZ;
        ((af)localObject1).field_sender = this.jkq;
        if (((af)localObject1).field_receiveAmount > 0L) {
          com.tencent.mm.plugin.wallet_core.model.u.gJk().a((af)localObject1);
        }
      }
      ePI();
      if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
        this.tipDialog.dismiss();
      }
      if (!ab.Qg(this.jkq))
      {
        Log.i("MicroMsg.LuckyMoneyDetailUI", "addOptionsMenuIfNeed");
        addIconOptionMenu(0, a.h.icons_outlined_more, new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(187433);
            paramAnonymousMenuItem = new com.tencent.mm.ui.widget.a.e(LuckyMoneyDetailUI.this, 1, false);
            paramAnonymousMenuItem.ODT = new q.f()
            {
              public final void onCreateMMMenu(o paramAnonymous2o)
              {
                AppMethodBeat.i(236297);
                paramAnonymous2o.d(0, LuckyMoneyDetailUI.this.getString(a.i.lucky_money_check_mine_title_opt));
                Object localObject = LuckyMoneyDetailUI.ac(LuckyMoneyDetailUI.this);
                if ((!((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vCL, false)) || (localObject == null))
                {
                  Log.i("MicroMsg.LuckyMoneyDetailUI", "ComplaintEntrance is false || mTextInfoList == null || mTextInfoList.size() ==0");
                  AppMethodBeat.o(236297);
                  return;
                }
                localObject = ((ArrayList)localObject).iterator();
                int i = 1;
                while (((Iterator)localObject).hasNext())
                {
                  cjj localcjj = (cjj)((Iterator)localObject).next();
                  if ((!Util.isNullOrNil(localcjj.wording)) && (localcjj.TqN != null) && (localcjj.TqN.type != 0))
                  {
                    Log.i("MicroMsg.LuckyMoneyDetailUI", "add option:%s", new Object[] { localcjj.wording });
                    paramAnonymous2o.d(i, localcjj.wording);
                  }
                  i += 1;
                }
                AppMethodBeat.o(236297);
              }
            };
            paramAnonymousMenuItem.ODU = new q.g()
            {
              public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
              {
                AppMethodBeat.i(275766);
                if (paramAnonymous2MenuItem.getItemId() == 0)
                {
                  Log.i("MicroMsg.LuckyMoneyDetailUI", "click OPTIONS_MENU_ITEM_ID_LUCKY_MONEY_RECORD");
                  com.tencent.mm.plugin.report.service.h.IzE.a(11701, new Object[] { Integer.valueOf(LuckyMoneyDetailUI.We(LuckyMoneyDetailUI.ad(LuckyMoneyDetailUI.this))), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4) });
                  localObject = new Intent();
                  ((Intent)localObject).setClass(LuckyMoneyDetailUI.this.getContext(), LuckyMoneyMyRecordUI.class);
                  ((Intent)localObject).putExtra("key_type", 2);
                  ((Intent)localObject).putExtra("key_username", LuckyMoneyDetailUI.x(LuckyMoneyDetailUI.this));
                  paramAnonymous2MenuItem = LuckyMoneyDetailUI.this;
                  localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
                  com.tencent.mm.hellhoundlib.a.a.b(paramAnonymous2MenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$35$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  paramAnonymous2MenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
                  com.tencent.mm.hellhoundlib.a.a.c(paramAnonymous2MenuItem, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$35$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  AppMethodBeat.o(275766);
                  return;
                }
                Object localObject = LuckyMoneyDetailUI.ac(LuckyMoneyDetailUI.this);
                if (localObject == null)
                {
                  Log.i("MicroMsg.LuckyMoneyDetailUI", "mTextInfoList == null || mTextInfoList.size() ==0");
                  AppMethodBeat.o(275766);
                  return;
                }
                if (paramAnonymous2MenuItem.getItemId() - 1 > ((ArrayList)localObject).size() - 1)
                {
                  Log.i("MicroMsg.LuckyMoneyDetailUI", "menuItem.getItemId() > mTextInfoList.size() : %s , %s", new Object[] { Integer.valueOf(paramAnonymous2MenuItem.getItemId()), Integer.valueOf(((ArrayList)localObject).size()) });
                  AppMethodBeat.o(275766);
                  return;
                }
                paramAnonymous2MenuItem = (cjj)((ArrayList)localObject).get(paramAnonymous2MenuItem.getItemId() - 1);
                Log.i("MicroMsg.LuckyMoneyDetailUI", "click onMMMenuItemSelected : %s ,type:%s", new Object[] { paramAnonymous2MenuItem.wording, Integer.valueOf(paramAnonymous2MenuItem.TqN.type) });
                switch (paramAnonymous2MenuItem.TqN.type)
                {
                default: 
                  Log.e("MicroMsg.LuckyMoneyDetailUI", "unknow text info type");
                  AppMethodBeat.o(275766);
                  return;
                case 1: 
                  Log.i("MicroMsg.LuckyMoneyDetailUI", "textInfo.jumpInfo.url ：%s", new Object[] { paramAnonymous2MenuItem.TqN.url });
                  com.tencent.mm.wallet_core.ui.g.p(LuckyMoneyDetailUI.this.getContext(), paramAnonymous2MenuItem.TqN.url, false);
                  AppMethodBeat.o(275766);
                  return;
                case 2: 
                  Log.i("MicroMsg.LuckyMoneyDetailUI", "textInfo.jumpInfo.username ：%s", new Object[] { paramAnonymous2MenuItem.TqN.username });
                  com.tencent.mm.wallet_core.ui.g.v(paramAnonymous2MenuItem.TqN.username, paramAnonymous2MenuItem.TqN.InB, 0, 1000);
                  AppMethodBeat.o(275766);
                  return;
                }
                Log.e("MicroMsg.LuckyMoneyDetailUI", "text info type is OPTIONS_MENU_ITEM_JUMP_TYPE_NATIVE");
                AppMethodBeat.o(275766);
              }
            };
            paramAnonymousMenuItem.eik();
            AppMethodBeat.o(187433);
            return true;
          }
        });
        setActionbarElementColor(getResources().getColor(a.c.White));
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
  
  private void a(dvl paramdvl)
  {
    AppMethodBeat.i(163739);
    f(this.EIv);
    this.EHR.a(paramdvl, this.EIu, this.EId, this.uav, ab.Qg(this.jkq));
    ((com.tencent.mm.plugin.luckymoney.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.luckymoney.a.a.class)).a(paramdvl, true);
    ePH();
    ePI();
    AppMethodBeat.o(163739);
  }
  
  private void aNM(final String paramString)
  {
    AppMethodBeat.i(199950);
    Log.i("MicroMsg.LuckyMoneyDetailUI", "sendEmoji emojiType :%s", new Object[] { Integer.valueOf(this.EIh) });
    switch (this.EIh)
    {
    default: 
      ((com.tencent.mm.pluginsdk.j)com.tencent.mm.kernel.h.ae(com.tencent.mm.pluginsdk.j.class)).a(this, this.jkq, this.EHV.getMd5(), getString(a.i.lucky_money_send_emoji_to_chatting), new y.a()
      {
        public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
        {
          paramAnonymousInt = 1;
          AppMethodBeat.i(203519);
          LuckyMoneyDetailUI.this.hideVKB();
          LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, new ji());
          if (paramAnonymousBoolean)
          {
            LuckyMoneyDetailUI.y(LuckyMoneyDetailUI.this).gCd = 5L;
            LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, new jj());
            if ((LuckyMoneyDetailUI.z(LuckyMoneyDetailUI.this) == 0) || (LuckyMoneyDetailUI.z(LuckyMoneyDetailUI.this) == 2)) {
              if (com.tencent.mm.plugin.emoji.i.b.z(LuckyMoneyDetailUI.B(LuckyMoneyDetailUI.this)))
              {
                LuckyMoneyDetailUI.A(LuckyMoneyDetailUI.this).gKZ = paramAnonymousInt;
                LuckyMoneyDetailUI.A(LuckyMoneyDetailUI.this).As(LuckyMoneyDetailUI.B(LuckyMoneyDetailUI.this).getMd5());
                if (!Util.isNullOrNil(paramAnonymousString)) {
                  break label289;
                }
                LuckyMoneyDetailUI.A(LuckyMoneyDetailUI.this).gLb = 1L;
                label146:
                LuckyMoneyDetailUI.A(LuckyMoneyDetailUI.this).bpa();
                LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, LuckyMoneyDetailUI.x(LuckyMoneyDetailUI.this), paramAnonymousString, LuckyMoneyDetailUI.B(LuckyMoneyDetailUI.this).getMd5());
                LuckyMoneyDetailUI.b(LuckyMoneyDetailUI.this, 3);
                v.a(LuckyMoneyDetailUI.this.getContext().getResources().getString(a.i.has_send), LuckyMoneyDetailUI.this.getContext(), 0, null);
                MMHandlerThread.postToMainThreadDelayed(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(201182);
                    LuckyMoneyDetailUI.this.finish();
                    AppMethodBeat.o(201182);
                  }
                }, 500L);
              }
            }
          }
          for (;;)
          {
            LuckyMoneyDetailUI.y(LuckyMoneyDetailUI.this).bpa();
            AppMethodBeat.o(203519);
            return;
            if (com.tencent.mm.plugin.emoji.i.b.x(LuckyMoneyDetailUI.B(LuckyMoneyDetailUI.this)))
            {
              paramAnonymousInt = 3;
              break;
            }
            paramAnonymousInt = 2;
            break;
            if (LuckyMoneyDetailUI.z(LuckyMoneyDetailUI.this) == 1) {
              break;
            }
            paramAnonymousInt = 0;
            break;
            label289:
            LuckyMoneyDetailUI.A(LuckyMoneyDetailUI.this).gLb = 2L;
            break label146;
            LuckyMoneyDetailUI.y(LuckyMoneyDetailUI.this).gCd = 6L;
          }
        }
      });
      AppMethodBeat.o(199950);
      return;
    }
    ((com.tencent.mm.pluginsdk.j)com.tencent.mm.kernel.h.ae(com.tencent.mm.pluginsdk.j.class)).b(this, this.jkq, paramString, getString(a.i.lucky_money_send_emoji_to_chatting), new y.a()
    {
      public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
      {
        paramAnonymousInt = 1;
        AppMethodBeat.i(163714);
        LuckyMoneyDetailUI.this.hideVKB();
        LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, new ji());
        if (paramAnonymousBoolean)
        {
          LuckyMoneyDetailUI.y(LuckyMoneyDetailUI.this).gCd = 5L;
          LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, new jj());
          if ((LuckyMoneyDetailUI.z(LuckyMoneyDetailUI.this) == 0) || (LuckyMoneyDetailUI.z(LuckyMoneyDetailUI.this) == 2))
          {
            paramAnonymousInt = 2;
            LuckyMoneyDetailUI.A(LuckyMoneyDetailUI.this).gKZ = paramAnonymousInt;
            LuckyMoneyDetailUI.A(LuckyMoneyDetailUI.this).As(paramString);
            if (!Util.isNullOrNil(paramAnonymousString)) {
              break label243;
            }
            LuckyMoneyDetailUI.A(LuckyMoneyDetailUI.this).gLb = 1L;
            label129:
            LuckyMoneyDetailUI.A(LuckyMoneyDetailUI.this).bpa();
            LuckyMoneyDetailUI.at(LuckyMoneyDetailUI.x(LuckyMoneyDetailUI.this), paramAnonymousString, paramString);
            LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, 3, paramString);
            v.a(LuckyMoneyDetailUI.this.getContext().getResources().getString(a.i.has_send), LuckyMoneyDetailUI.this.getContext(), 0, null);
            MMHandlerThread.postToMainThreadDelayed(new Runnable()
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
        for (;;)
        {
          LuckyMoneyDetailUI.y(LuckyMoneyDetailUI.this).bpa();
          AppMethodBeat.o(163714);
          return;
          if (LuckyMoneyDetailUI.z(LuckyMoneyDetailUI.this) == 1) {
            break;
          }
          paramAnonymousInt = 0;
          break;
          label243:
          LuckyMoneyDetailUI.A(LuckyMoneyDetailUI.this).gLb = 2L;
          break label129;
          LuckyMoneyDetailUI.y(LuckyMoneyDetailUI.this).gCd = 6L;
        }
      }
    });
    AppMethodBeat.o(199950);
  }
  
  private void bD(int paramInt, String paramString)
  {
    AppMethodBeat.i(65575);
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (ab.Qg(this.jkq)) {
        this.EHE.setVisibility(8);
      }
      AppMethodBeat.o(65575);
      return;
      this.EHE.setVisibility(8);
      continue;
      this.EHE.setVisibility(0);
      this.EHF.setVisibility(0);
      this.EHG.setVisibility(8);
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Voc, "");
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vob, "");
      continue;
      Log.i("MicroMsg.LuckyMoneyDetailUI", "exchangeThxEmojiState emojiType :%s", new Object[] { Integer.valueOf(this.EIh) });
      switch (this.EIh)
      {
      default: 
        if (!Util.isNullOrNil(paramString))
        {
          paramString = p.getEmojiStorageMgr().VFH.bxK(paramString);
          if (paramString == null)
          {
            Log.i("MicroMsg.LuckyMoneyDetailUI", "exchangeThxEmojiState() temp == null");
            AppMethodBeat.o(65575);
            return;
          }
        }
        break;
      case 1: 
        Object localObject = com.tencent.mm.plugin.emoji.i.b.avf(paramString);
        if (localObject == null)
        {
          Log.i("MicroMsg.LuckyMoneyDetailUI", "exchangeThxEmojiState() emojiKey == null");
          AppMethodBeat.o(65575);
          return;
        }
        localObject = com.tencent.mm.plugin.emoji.i.b.avh((String)localObject);
        this.EHH.setImageDrawable((Drawable)localObject);
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vob, paramString);
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Voc, "");
        this.EHE.setVisibility(0);
        this.EHF.setVisibility(8);
        this.EHG.setVisibility(0);
        continue;
        this.EHV = paramString;
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Voc, this.EHV.getMd5());
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vob, "");
        this.EHH.setEmojiInfo(this.EHV);
        this.EHE.setVisibility(0);
        this.EHF.setVisibility(8);
        this.EHG.setVisibility(0);
      }
    }
  }
  
  private boolean e(com.tencent.mm.plugin.luckymoney.model.q paramq)
  {
    return (paramq.gbq == 2) && (this.EGJ != 3);
  }
  
  private boolean ePG()
  {
    AppMethodBeat.i(65572);
    if ((!Util.isNullOrNil(this.uFZ)) && ((Util.isEqual(this.EHX.EzG, 1)) || (Util.isEqual(this.EHX.EzH, 1))))
    {
      AppMethodBeat.o(65572);
      return true;
    }
    AppMethodBeat.o(65572);
    return false;
  }
  
  private void ePH()
  {
    AppMethodBeat.i(200005);
    if ((!Util.isNullOrNil(this.EIu)) && (this.EIu.startsWith("rpid_wxapp_")) && (this.uIP != null))
    {
      TextView localTextView = (TextView)this.uIP.findViewById(a.f.lucky_money_detail_personal_envelope_tips_tv);
      if (localTextView != null) {
        localTextView.setVisibility(0);
      }
    }
    AppMethodBeat.o(200005);
  }
  
  private void ePI()
  {
    AppMethodBeat.i(163741);
    Log.d("MicroMsg.LuckyMoneyDetailUI", "adjust footer");
    this.uIP.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(231843);
        if ((LuckyMoneyDetailUI.this.isFinishing()) || (LuckyMoneyDetailUI.this.isDestroyed()))
        {
          AppMethodBeat.o(231843);
          return;
        }
        Object localObject = (TextView)LuckyMoneyDetailUI.V(LuckyMoneyDetailUI.this).findViewById(a.f.lucky_money_detail_personal_envelope_tips_tv);
        if ((LuckyMoneyDetailUI.W(LuckyMoneyDetailUI.this).getVisibility() == 8) && (LuckyMoneyDetailUI.X(LuckyMoneyDetailUI.this).getVisibility() == 8) && (LuckyMoneyDetailUI.Y(LuckyMoneyDetailUI.this).getVisibility() == 8) && (((TextView)localObject).getVisibility() == 8))
        {
          AppMethodBeat.o(231843);
          return;
        }
        localObject = LuckyMoneyDetailUI.this.findViewById(a.f.lucky_money_detail_expand_white_cover);
        if ((LuckyMoneyDetailUI.V(LuckyMoneyDetailUI.this) == null) || (localObject == null))
        {
          AppMethodBeat.o(231843);
          return;
        }
        if (!LuckyMoneyDetailUI.Z(LuckyMoneyDetailUI.this))
        {
          LuckyMoneyDetailUI.aa(LuckyMoneyDetailUI.this);
          LuckyMoneyDetailUI.d(LuckyMoneyDetailUI.this, LuckyMoneyDetailUI.V(LuckyMoneyDetailUI.this).getHeight());
        }
        int i = ((View)localObject).getHeight();
        localObject = new Rect();
        LuckyMoneyDetailUI.V(LuckyMoneyDetailUI.this).getGlobalVisibleRect((Rect)localObject);
        int j = LuckyMoneyDetailUI.V(LuckyMoneyDetailUI.this).getTop();
        int k = i - j;
        if (k > LuckyMoneyDetailUI.ab(LuckyMoneyDetailUI.this)) {
          LuckyMoneyDetailUI.V(LuckyMoneyDetailUI.this).setMinimumHeight(k);
        }
        for (;;)
        {
          Log.d("MicroMsg.LuckyMoneyDetailUI", "winHeight:%s diff:%s recordHeight:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(j) });
          AppMethodBeat.o(231843);
          return;
          LuckyMoneyDetailUI.V(LuckyMoneyDetailUI.this).setMinimumHeight(LuckyMoneyDetailUI.ab(LuckyMoneyDetailUI.this));
        }
      }
    });
    AppMethodBeat.o(163741);
  }
  
  private static int ePJ()
  {
    AppMethodBeat.i(200012);
    String str1 = (String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Voc, "");
    String str2 = (String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vob, "");
    if (!Util.isNullOrNil(str1))
    {
      AppMethodBeat.o(200012);
      return 2;
    }
    if (!Util.isNullOrNil(str2))
    {
      AppMethodBeat.o(200012);
      return 1;
    }
    AppMethodBeat.o(200012);
    return 2;
  }
  
  private void ePv()
  {
    AppMethodBeat.i(199952);
    com.tencent.mm.plugin.luckymoney.ui.a.b.a(this, this.rzI);
    this.EHK.dismiss();
    AppMethodBeat.o(199952);
  }
  
  private void f(com.tencent.mm.plugin.luckymoney.model.q paramq)
  {
    AppMethodBeat.i(163740);
    if (paramq.Ezz != null)
    {
      paramq = bi.aNH(paramq.Ezz);
      if ((Util.isNullOrNil(this.EIu)) && (paramq != null) && (paramq.Eyz != null)) {
        this.EIu = paramq.Eyz.SpP;
      }
      this.EDR = getIntent().getStringExtra("key_detail_envelope_url");
      this.EDS = getIntent().getStringExtra("key_detail_envelope_md5");
      if ((Util.isNullOrNil(this.EDR)) && (paramq != null) && (paramq.Eyz != null) && (paramq.Eyz.Tqo != null))
      {
        this.EDR = paramq.Eyz.Tqo.TqI;
        this.EDS = paramq.Eyz.Tqo.TqL;
      }
      if (!Util.isNullOrNil(this.EDR))
      {
        int j = 0;
        int i = j;
        if (paramq != null)
        {
          i = j;
          if (paramq.Eyz != null) {
            i = paramq.Eyz.subType;
          }
        }
        this.EHR.ah(this.EDR, this.EDS, i);
        if (!this.EHT)
        {
          this.EHT = true;
          com.tencent.mm.plugin.luckymoney.a.c.bz(3, this.EDR);
        }
      }
    }
    AppMethodBeat.o(163740);
  }
  
  private static boolean g(com.tencent.mm.plugin.luckymoney.model.q paramq)
  {
    return paramq.Ezj == 1;
  }
  
  private void tO(boolean paramBoolean)
  {
    AppMethodBeat.i(65569);
    Log.i("MicroMsg.LuckyMoneyDetailUI", "showEmoji() circle:%s", new Object[] { Boolean.TRUE });
    this.Eyk.setVisibility(8);
    this.EIC = 1;
    if (paramBoolean) {
      this.EIz = 3;
    }
    do
    {
      this.uIz = p.getEmojiStorageMgr().VFH.bxK(this.uFZ);
      if (this.uIz == null) {
        break;
      }
      if ((com.tencent.mm.vfs.u.bBQ(this.uIz.ifh()) <= 0L) && (!this.uIz.Qv()) && (!this.uIz.hBu())) {
        break label218;
      }
      this.Eyj.setVisibility(0);
      C(this.uIz);
      AppMethodBeat.o(65569);
      return;
      this.EIz -= 1;
    } while (this.EIz != 0);
    Log.i("MicroMsg.LuckyMoneyDetailUI", "showEmoji() circle fail!");
    this.Eyl.setVisibility(8);
    this.Eyk.setVisibility(0);
    this.EIC = 2;
    AppMethodBeat.o(65569);
    return;
    this.uIz = new EmojiInfo();
    this.uIz.field_md5 = this.uFZ;
    this.uIz.field_type = this.EHU;
    label218:
    if (paramBoolean)
    {
      this.Eyj.setVisibility(8);
      this.Eyl.setVisibility(0);
      p.cUM().uEk = this.uEk;
    }
    p.cUM().u(this.uIz);
    com.tencent.mm.kernel.h.aHF().kcd.a(697, this.EIA);
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
          AppMethodBeat.i(195577);
          Log.i("MicroMsg.LuckyMoneyDetailUI", "RealnameGuideHelper dialog click cancel");
          LuckyMoneyDetailUI.G(LuckyMoneyDetailUI.this);
          AppMethodBeat.o(195577);
        }
      });
      getIntent().removeExtra("key_realname_guide_helper");
      if (!bool) {
        super.finish();
      }
    }
    for (;;)
    {
      overridePendingTransition(a.a.slide_left_in, a.a.slide_right_out);
      AppMethodBeat.o(65568);
      return;
      super.finish();
    }
  }
  
  public int getLayoutId()
  {
    return a.g.lucky_money_detail_new_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(65561);
    this.EIg = new com.tencent.mm.plugin.wallet_core.utils.g(this);
    setMMTitle("");
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(65551);
        if (LuckyMoneyDetailUI.r(LuckyMoneyDetailUI.this) == null)
        {
          LuckyMoneyDetailUI.this.finish();
          AppMethodBeat.o(65551);
          return false;
        }
        if (!com.tencent.mm.plugin.wallet_core.utils.g.a(LuckyMoneyDetailUI.r(LuckyMoneyDetailUI.this)))
        {
          LuckyMoneyDetailUI.this.finish();
          AppMethodBeat.o(65551);
          return false;
        }
        LuckyMoneyDetailUI.s(LuckyMoneyDetailUI.this).a(LuckyMoneyDetailUI.r(LuckyMoneyDetailUI.this), new g.a()
        {
          public final void a(coi paramAnonymous2coi)
          {
            AppMethodBeat.i(199372);
            if (paramAnonymous2coi.action == 1)
            {
              LuckyMoneyDetailUI.this.finish();
              AppMethodBeat.o(199372);
              return;
            }
            AppMethodBeat.o(199372);
          }
        });
        LuckyMoneyDetailUI.t(LuckyMoneyDetailUI.this);
        AppMethodBeat.o(65551);
        return false;
      }
    }, a.e.icon_back);
    this.EHq = ((RecyclerView)findViewById(a.f.lucky_money_detail_record_list));
    RecyclerView localRecyclerView = this.EHq;
    getContext();
    localRecyclerView.setLayoutManager(new LinearLayoutManager(1, false));
    this.mL = LayoutInflater.from(this).inflate(a.g.lucky_money_detail_new_header, this.EHq, false);
    this.uIP = LayoutInflater.from(this).inflate(a.g.lucky_money_detail_footer, this.EHq, false);
    this.EIs = new WxRecyclerAdapter(new LuckyMoneyDetailUI.32(this), this.EHS, false);
    this.EIs.g(this.mL, 1, false);
    this.EHq.setAdapter(this.EIs);
    this.EHq.a(this.ahp);
    this.Eus = ((ImageView)this.mL.findViewById(a.f.lucky_money_detail_sender_avatar));
    this.Eut = ((TextView)this.mL.findViewById(a.f.lucky_money_detail_whose));
    this.EHN = this.mL.findViewById(a.f.lucky_money_detail_top_area);
    this.Euu = ((ImageView)this.mL.findViewById(a.f.lucky_money_detail_group_icon));
    this.DLp = ((TextView)this.mL.findViewById(a.f.lucky_money_detail_wishing));
    this.Eyi = ((RelativeLayout)this.mL.findViewById(a.f.lucky_money_emoji_layout));
    this.Eyj = ((BaseEmojiView)this.mL.findViewById(a.f.lucky_money_emoji));
    this.Eyk = ((TextView)this.mL.findViewById(a.f.lucky_money_reload_emoji));
    this.Eyl = ((LinearLayout)this.mL.findViewById(a.f.lucky_money_loading_emoji_area));
    this.Eym = ((ProgressBar)this.mL.findViewById(a.f.emoji_loading_image));
    this.Euv = this.mL.findViewById(a.f.lucky_money_detail_amount_area);
    this.Euj = ((TextView)this.mL.findViewById(a.f.lucky_money_detail_amount));
    this.EHO = ((ViewGroup)this.mL.findViewById(a.f.lucky_money_hk_tips_layout));
    this.EHP = ((TextView)this.mL.findViewById(a.f.lucky_money_hk_tips_tv));
    this.EHQ = ((ImageView)this.mL.findViewById(a.f.lucky_money_hk_tips_iv));
    this.Euw = this.mL.findViewById(a.f.lucky_money_detail_layout);
    this.qCM = ((TextView)this.mL.findViewById(a.f.lucky_money_detail_tips));
    this.EHr = ((CdnImageView)this.mL.findViewById(a.f.lucky_money_detail_icon));
    this.mMA = ((TextView)this.mL.findViewById(a.f.lucky_money_detail_desc));
    this.EGG = this.mL.findViewById(a.f.lucky_money_detail_opertiaon_ll);
    this.EHs = this.mL.findViewById(a.f.lucky_money_detail_background_area);
    this.EHt = ((ImageView)this.mL.findViewById(a.f.lucky_money_detail_background));
    this.EHE = ((LinearLayout)this.mL.findViewById(a.f.lucky_money_thx_are));
    this.EHF = ((LinearLayout)this.mL.findViewById(a.f.lucky_money_thx_select_emoji_ll));
    this.EHG = ((LinearLayout)this.mL.findViewById(a.f.lucky_money_thx_show_emoji_ll));
    this.EHH = ((BaseEmojiView)this.mL.findViewById(a.f.lucky_money_thx_emoji));
    this.EHI = ((RelativeLayout)this.mL.findViewById(a.f.lucky_money_thx_send_emoji_btn));
    this.EHJ = ((ImageView)this.mL.findViewById(a.f.lucky_money_thx_exchange_emoji_bt));
    this.EHu = ((ViewGroup)this.mL.findViewById(a.f.lucky_money_detail_desc_layout));
    this.EHv = this.mL.findViewById(a.f.lucky_money_detail_desc_divider);
    this.EHw = this.mL.findViewById(a.f.lucky_money_detail_desc_line);
    this.EHx = this.mL.findViewById(a.f.lucky_money_detail_desc_line_two);
    this.EHB = ((RelativeLayout)this.mL.findViewById(a.f.lucky_money_detail_background_area));
    this.voG = ((ImageView)this.mL.findViewById(a.f.lucky_money_detail_background));
    this.EHM = ((ImageView)this.mL.findViewById(a.f.lucky_money_txh_emoji_click_area));
    this.EHD = ((ViewGroup)findViewById(a.f.lucky_money_f2f_firework_recv_container));
    this.Eyk.setOnClickListener(new LuckyMoneyDetailUI.33(this));
    this.EHK = new a(this);
    this.EHL = getLayoutInflater().inflate(a.g.lucky_money_emoji_dialog, null);
    this.EHK.setContentView(this.EHL, new ViewGroup.LayoutParams(-1, -1));
    this.EHL.findViewById(a.f.lucky_money_emoji_dismiss_area).setOnClickListener(new LuckyMoneyDetailUI.34(this));
    this.EHK.EFM = new LuckyMoneyDetailUI.35(this);
    this.EHW = ((ViewGroup)this.EHL.findViewById(a.f.lucky_money_emoji_root));
    if (com.tencent.mm.pluginsdk.ui.chat.e.RnO == null)
    {
      Log.w("MicroMsg.LuckyMoneyDetailUI", "can't show correctly");
      finish();
      AppMethodBeat.o(65561);
      return;
    }
    this.rzI = com.tencent.mm.pluginsdk.ui.chat.e.RnO.fd(getContext());
    this.rzI.setTalkerName(this.jkq);
    this.rzI.setShowSmiley(false);
    this.rzI.setShowSmiley(true);
    this.EHr.setUseSdcardCache(true);
    this.Eyj.setOnClickListener(new LuckyMoneyDetailUI.2(this));
    this.EHR = ((EnvelopeAppBarLayout)findViewById(a.f.lucky_money_envelope_story_layout));
    this.EHR.setActivityLifeCycle(this);
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
          if ((this.EGL != null) && (this.EGL.startsWith("wxpay://c2cbizmessagehandler/hongbao/festivalhongbao")))
          {
            Log.i("MicroMsg.LuckyMoneyDetailUI", "Not expected branch since 2015 fesitval");
          }
          else
          {
            doSceneProgress(new bg(str.replaceAll(",", "|"), this.ExZ, "v1.0"));
            continue;
            if (paramInt2 == -1)
            {
              str = "";
              if (paramIntent != null) {
                str = paramIntent.getStringExtra("gif_md5");
              }
              if (!Util.isNullOrNil(str))
              {
                this.EIh = 2;
                bD(2, str);
                aNM("");
                ePv();
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
              com.tencent.mm.plugin.luckymoney.a.d.Bv(8);
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
    //   2: ldc_w 2638
    //   5: invokestatic 250	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: invokestatic 2642	com/tencent/mm/pluginsdk/h:r	(Lcom/tencent/mm/ui/MMActivity;)V
    //   12: aload_0
    //   13: iconst_1
    //   14: invokevirtual 2645	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:customfixStatusbar	(Z)V
    //   17: aload_0
    //   18: iconst_0
    //   19: putfield 2648	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:EGv	Z
    //   22: aload_0
    //   23: invokevirtual 2066	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   26: ldc_w 2650
    //   29: iconst_0
    //   30: invokevirtual 2654	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   33: ifne +13 -> 46
    //   36: aload_0
    //   37: getstatic 2657	com/tencent/mm/plugin/wxpay/a$a:pop_in	I
    //   40: getstatic 2660	com/tencent/mm/plugin/wxpay/a$a:fast_faded_out	I
    //   43: invokevirtual 2355	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:overridePendingTransition	(II)V
    //   46: aload_0
    //   47: aload_1
    //   48: invokespecial 2662	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBaseUI:onCreate	(Landroid/os/Bundle;)V
    //   51: aload_0
    //   52: invokevirtual 2666	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getWindow	()Landroid/view/Window;
    //   55: invokevirtual 2671	android/view/Window:getDecorView	()Landroid/view/View;
    //   58: sipush 1280
    //   61: invokevirtual 2674	android/view/View:setSystemUiVisibility	(I)V
    //   64: aload_0
    //   65: invokevirtual 2666	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getWindow	()Landroid/view/Window;
    //   68: getstatic 1588	com/tencent/mm/plugin/wxpay/a$c:White	I
    //   71: invokevirtual 2677	android/view/Window:setBackgroundDrawableResource	(I)V
    //   74: aload_0
    //   75: aload_0
    //   76: invokevirtual 2066	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   79: ldc_w 2679
    //   82: invokevirtual 2180	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   85: putfield 1251	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:EId	Ljava/lang/String;
    //   88: aload_0
    //   89: aload_0
    //   90: invokevirtual 2066	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   93: ldc_w 2681
    //   96: iconst_0
    //   97: invokevirtual 2072	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   100: putfield 1788	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:uav	I
    //   103: aload_0
    //   104: aload_0
    //   105: invokevirtual 2066	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   108: ldc_w 2683
    //   111: iconst_0
    //   112: invokevirtual 2072	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   115: putfield 2060	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:EIe	I
    //   118: aload_0
    //   119: aload_0
    //   120: invokevirtual 2066	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   123: ldc_w 2685
    //   126: iconst_0
    //   127: invokevirtual 2072	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   130: putfield 1361	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:jaR	I
    //   133: aload_0
    //   134: aload_0
    //   135: invokevirtual 2066	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   138: ldc_w 2687
    //   141: invokevirtual 2180	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   144: putfield 2118	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:EGy	Ljava/lang/String;
    //   147: aload_0
    //   148: aload_0
    //   149: invokevirtual 2066	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   152: ldc_w 2689
    //   155: invokevirtual 2180	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   158: putfield 2120	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:EGz	Ljava/lang/String;
    //   161: aload_0
    //   162: aload_0
    //   163: invokevirtual 2066	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   166: ldc_w 2691
    //   169: iconst_0
    //   170: invokevirtual 2072	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   173: putfield 2122	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:EGA	I
    //   176: aload_0
    //   177: invokevirtual 2695	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getController	()Lcom/tencent/mm/ui/w;
    //   180: iconst_0
    //   181: putfield 2700	com/tencent/mm/ui/w:VZP	Z
    //   184: aload_0
    //   185: aload_0
    //   186: invokevirtual 478	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getResources	()Landroid/content/res/Resources;
    //   189: getstatic 2703	com/tencent/mm/plugin/wxpay/a$c:transparent	I
    //   192: invokevirtual 694	android/content/res/Resources:getColor	(I)I
    //   195: invokevirtual 2706	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:setActionbarColor	(I)V
    //   198: aload_0
    //   199: invokevirtual 2709	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:hideActionbarLine	()V
    //   202: aload_0
    //   203: aload_0
    //   204: invokevirtual 2066	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   207: ldc_w 2711
    //   210: iconst_0
    //   211: invokevirtual 2654	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   214: putfield 285	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:EIc	Z
    //   217: aload_0
    //   218: new 1998	org/json/JSONObject
    //   221: dup
    //   222: aload_0
    //   223: invokevirtual 2066	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   226: ldc_w 2713
    //   229: invokevirtual 2180	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   232: invokespecial 1999	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   235: invokestatic 2719	com/tencent/mm/plugin/wallet_core/utils/b:cg	(Lorg/json/JSONObject;)Lcom/tencent/mm/plugin/wallet_core/utils/b;
    //   238: putfield 2228	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:EIf	Lcom/tencent/mm/plugin/wallet_core/utils/b;
    //   241: aload_0
    //   242: aload_0
    //   243: invokevirtual 2066	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   246: ldc_w 2721
    //   249: invokevirtual 2180	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   252: putfield 986	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:jkq	Ljava/lang/String;
    //   255: aload_0
    //   256: aload_0
    //   257: invokevirtual 2066	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   260: ldc_w 2723
    //   263: sipush 1002
    //   266: invokevirtual 2072	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   269: putfield 2092	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:EGw	I
    //   272: aload_0
    //   273: aload_0
    //   274: invokevirtual 2066	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   277: ldc_w 2725
    //   280: invokevirtual 2180	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   283: putfield 1555	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:ExZ	Ljava/lang/String;
    //   286: aload_0
    //   287: aload_0
    //   288: invokevirtual 2066	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   291: ldc_w 2727
    //   294: invokevirtual 2180	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   297: putfield 1523	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:Eyn	Ljava/lang/String;
    //   300: aload_0
    //   301: aload_0
    //   302: invokevirtual 2066	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   305: ldc_w 2729
    //   308: iconst_2
    //   309: invokevirtual 2072	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   312: putfield 1086	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:EGJ	I
    //   315: aload_0
    //   316: aload_0
    //   317: invokevirtual 2066	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   320: ldc_w 2731
    //   323: invokevirtual 2180	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   326: putfield 277	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:EGP	Ljava/lang/String;
    //   329: aload_0
    //   330: aload_0
    //   331: invokevirtual 2066	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   334: ldc_w 2733
    //   337: lconst_0
    //   338: invokevirtual 2736	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   341: putfield 2302	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:iSo	J
    //   344: aload_0
    //   345: aload_0
    //   346: invokevirtual 2066	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   349: ldc_w 2738
    //   352: invokevirtual 2180	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   355: putfield 1786	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:EIu	Ljava/lang/String;
    //   358: aload_0
    //   359: aload_0
    //   360: invokevirtual 2066	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   363: ldc_w 2177
    //   366: invokevirtual 2180	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   369: putfield 2182	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:EDR	Ljava/lang/String;
    //   372: aload_0
    //   373: aload_0
    //   374: invokevirtual 2066	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   377: ldc_w 2184
    //   380: invokevirtual 2180	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   383: putfield 2186	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:EDS	Ljava/lang/String;
    //   386: ldc_w 493
    //   389: new 929	java/lang/StringBuilder
    //   392: dup
    //   393: ldc_w 2740
    //   396: invokespecial 933	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   399: aload_0
    //   400: getfield 1555	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:ExZ	Ljava/lang/String;
    //   403: invokestatic 2743	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   406: invokevirtual 998	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: ldc_w 2745
    //   412: invokevirtual 998	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: aload_0
    //   416: getfield 1523	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:Eyn	Ljava/lang/String;
    //   419: invokestatic 2743	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   422: invokevirtual 998	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: ldc_w 2747
    //   428: invokevirtual 998	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: aload_0
    //   432: getfield 1086	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:EGJ	I
    //   435: invokevirtual 937	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   438: ldc_w 2749
    //   441: invokevirtual 998	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: aload_0
    //   445: getfield 1786	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:EIu	Ljava/lang/String;
    //   448: invokevirtual 998	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: invokevirtual 941	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   454: invokestatic 944	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   457: aload_0
    //   458: getfield 1555	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:ExZ	Ljava/lang/String;
    //   461: invokestatic 637	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   464: ifeq +32 -> 496
    //   467: aload_0
    //   468: getfield 1523	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:Eyn	Ljava/lang/String;
    //   471: invokestatic 637	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   474: ifne +22 -> 496
    //   477: aload_0
    //   478: getfield 1523	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:Eyn	Ljava/lang/String;
    //   481: invokestatic 2755	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   484: astore_1
    //   485: aload_0
    //   486: aload_1
    //   487: ldc_w 2757
    //   490: invokevirtual 2760	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   493: putfield 1555	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:ExZ	Ljava/lang/String;
    //   496: aload_0
    //   497: aload_0
    //   498: invokevirtual 2066	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   501: ldc_w 2762
    //   504: invokevirtual 2180	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   507: putfield 2140	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:uFZ	Ljava/lang/String;
    //   510: aload_0
    //   511: aload_0
    //   512: invokevirtual 2066	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   515: ldc_w 2764
    //   518: iconst_0
    //   519: invokevirtual 2072	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   522: putfield 2264	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:EHU	I
    //   525: aload_0
    //   526: getfield 2140	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:uFZ	Ljava/lang/String;
    //   529: invokestatic 637	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   532: ifne +32 -> 564
    //   535: aload_0
    //   536: new 352	com/tencent/mm/f/b/a/jk
    //   539: dup
    //   540: invokespecial 353	com/tencent/mm/f/b/a/jk:<init>	()V
    //   543: putfield 355	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:EHY	Lcom/tencent/mm/f/b/a/jk;
    //   546: aload_0
    //   547: getfield 355	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:EHY	Lcom/tencent/mm/f/b/a/jk;
    //   550: ldc2_w 2765
    //   553: putfield 360	com/tencent/mm/f/b/a/jk:gCd	J
    //   556: aload_0
    //   557: getfield 355	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:EHY	Lcom/tencent/mm/f/b/a/jk;
    //   560: invokevirtual 364	com/tencent/mm/f/b/a/jk:bpa	()Z
    //   563: pop
    //   564: aload_0
    //   565: aload_0
    //   566: invokevirtual 2066	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   569: ldc_w 2768
    //   572: invokevirtual 2321	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   575: checkcast 392	com/tencent/mm/plugin/luckymoney/model/LuckyMoneyEmojiSwitch
    //   578: putfield 390	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:EHX	Lcom/tencent/mm/plugin/luckymoney/model/LuckyMoneyEmojiSwitch;
    //   581: aload_0
    //   582: getfield 390	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:EHX	Lcom/tencent/mm/plugin/luckymoney/model/LuckyMoneyEmojiSwitch;
    //   585: ifnonnull +14 -> 599
    //   588: aload_0
    //   589: new 392	com/tencent/mm/plugin/luckymoney/model/LuckyMoneyEmojiSwitch
    //   592: dup
    //   593: invokespecial 2769	com/tencent/mm/plugin/luckymoney/model/LuckyMoneyEmojiSwitch:<init>	()V
    //   596: putfield 390	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:EHX	Lcom/tencent/mm/plugin/luckymoney/model/LuckyMoneyEmojiSwitch;
    //   599: aload_0
    //   600: getfield 1555	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:ExZ	Ljava/lang/String;
    //   603: invokestatic 2775	com/tencent/mm/plugin/luckymoney/a/b:aNx	(Ljava/lang/String;)Lcom/tencent/mm/plugin/luckymoney/model/q;
    //   606: astore_1
    //   607: aload_1
    //   608: ifnull +74 -> 682
    //   611: aload_0
    //   612: aload_1
    //   613: putfield 449	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:EIv	Lcom/tencent/mm/plugin/luckymoney/model/q;
    //   616: aload_0
    //   617: invokevirtual 2777	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:initView	()V
    //   620: aload_0
    //   621: getfield 449	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:EIv	Lcom/tencent/mm/plugin/luckymoney/model/q;
    //   624: ifnonnull +135 -> 759
    //   627: ldc_w 493
    //   630: ldc_w 2779
    //   633: invokestatic 2574	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   636: aload_0
    //   637: invokevirtual 2575	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:finish	()V
    //   640: ldc_w 2638
    //   643: invokestatic 328	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   646: return
    //   647: astore_1
    //   648: ldc_w 493
    //   651: aload_1
    //   652: ldc_w 275
    //   655: iconst_0
    //   656: anewarray 497	java/lang/Object
    //   659: invokestatic 2041	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   662: invokestatic 2784	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   665: ldc_w 2786
    //   668: iconst_0
    //   669: invokestatic 2792	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   672: invokevirtual 2793	android/widget/Toast:show	()V
    //   675: ldc_w 2638
    //   678: invokestatic 328	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   681: return
    //   682: aload_0
    //   683: invokevirtual 2066	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   686: ldc_w 2795
    //   689: invokevirtual 2799	android/content/Intent:getByteArrayExtra	(Ljava/lang/String;)[B
    //   692: astore_1
    //   693: aload_1
    //   694: ifnull +58 -> 752
    //   697: aload_0
    //   698: new 541	com/tencent/mm/plugin/luckymoney/model/q
    //   701: dup
    //   702: invokespecial 2800	com/tencent/mm/plugin/luckymoney/model/q:<init>	()V
    //   705: aload_1
    //   706: invokevirtual 2804	com/tencent/mm/plugin/luckymoney/model/q:parseFrom	([B)Lcom/tencent/mm/cd/a;
    //   709: checkcast 541	com/tencent/mm/plugin/luckymoney/model/q
    //   712: putfield 449	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:EIv	Lcom/tencent/mm/plugin/luckymoney/model/q;
    //   715: goto -99 -> 616
    //   718: astore_1
    //   719: ldc_w 493
    //   722: new 929	java/lang/StringBuilder
    //   725: dup
    //   726: ldc_w 2806
    //   729: invokespecial 933	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   732: aload_1
    //   733: invokevirtual 2809	java/lang/Exception:getLocalizedMessage	()Ljava/lang/String;
    //   736: invokevirtual 998	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   739: invokevirtual 941	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   742: invokestatic 2574	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   745: aload_0
    //   746: invokevirtual 2575	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:finish	()V
    //   749: goto -133 -> 616
    //   752: aload_0
    //   753: invokevirtual 2575	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:finish	()V
    //   756: goto -140 -> 616
    //   759: aload_0
    //   760: getfield 449	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:EIv	Lcom/tencent/mm/plugin/luckymoney/model/q;
    //   763: ifnull +67 -> 830
    //   766: aload_0
    //   767: getfield 449	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:EIv	Lcom/tencent/mm/plugin/luckymoney/model/q;
    //   770: getfield 1230	com/tencent/mm/plugin/luckymoney/model/q:Ezz	Ljava/lang/String;
    //   773: invokestatic 1236	com/tencent/mm/plugin/luckymoney/model/bi:aNH	(Ljava/lang/String;)Lcom/tencent/mm/plugin/luckymoney/model/bi;
    //   776: astore_1
    //   777: aload_1
    //   778: ifnull +52 -> 830
    //   781: aload_1
    //   782: getfield 1243	com/tencent/mm/plugin/luckymoney/model/bi:Eyz	Lcom/tencent/mm/protocal/protobuf/cjf;
    //   785: ifnull +45 -> 830
    //   788: aload_0
    //   789: getfield 1786	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:EIu	Ljava/lang/String;
    //   792: invokestatic 637	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   795: ifeq +14 -> 809
    //   798: aload_0
    //   799: aload_1
    //   800: getfield 1243	com/tencent/mm/plugin/luckymoney/model/bi:Eyz	Lcom/tencent/mm/protocal/protobuf/cjf;
    //   803: getfield 1269	com/tencent/mm/protocal/protobuf/cjf:SpP	Ljava/lang/String;
    //   806: putfield 1786	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:EIu	Ljava/lang/String;
    //   809: aload_0
    //   810: getfield 1251	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:EId	Ljava/lang/String;
    //   813: invokestatic 637	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   816: ifeq +14 -> 830
    //   819: aload_0
    //   820: aload_1
    //   821: getfield 1243	com/tencent/mm/plugin/luckymoney/model/bi:Eyz	Lcom/tencent/mm/protocal/protobuf/cjf;
    //   824: getfield 1254	com/tencent/mm/protocal/protobuf/cjf:Tqn	Ljava/lang/String;
    //   827: putfield 1251	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:EId	Ljava/lang/String;
    //   830: aload_0
    //   831: getfield 986	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:jkq	Ljava/lang/String;
    //   834: invokestatic 991	com/tencent/mm/model/ab:Qg	(Ljava/lang/String;)Z
    //   837: ifeq +216 -> 1053
    //   840: ldc_w 493
    //   843: ldc_w 2811
    //   846: invokestatic 944	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   849: aload_0
    //   850: getfield 2302	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:iSo	J
    //   853: invokestatic 2816	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   856: invokestatic 2819	com/tencent/mm/plugin/luckymoney/a/b:k	(Ljava/lang/Long;)Lcom/tencent/mm/protocal/protobuf/dvk;
    //   859: astore_1
    //   860: aload_1
    //   861: ifnull +11 -> 872
    //   864: aload_0
    //   865: aload_1
    //   866: getfield 2825	com/tencent/mm/protocal/protobuf/dvk:Tkp	Lcom/tencent/mm/protocal/protobuf/dvl;
    //   869: invokespecial 2827	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:a	(Lcom/tencent/mm/protocal/protobuf/dvl;)V
    //   872: aload_0
    //   873: aload_0
    //   874: getfield 449	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:EIv	Lcom/tencent/mm/plugin/luckymoney/model/q;
    //   877: invokespecial 1844	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:a	(Lcom/tencent/mm/plugin/luckymoney/model/q;)V
    //   880: aload_0
    //   881: invokevirtual 2066	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   884: ldc_w 2829
    //   887: iconst_0
    //   888: invokevirtual 2654	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   891: ifeq +10 -> 901
    //   894: aload_0
    //   895: getstatic 2832	com/tencent/mm/plugin/wxpay/a$i:lucky_cashrecivedrevised	I
    //   898: invokestatic 2838	com/tencent/mm/plugin/luckymoney/ui/l:play	(Landroid/content/Context;I)V
    //   901: aload_0
    //   902: invokevirtual 2066	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:getIntent	()Landroid/content/Intent;
    //   905: ldc_w 2683
    //   908: iconst_0
    //   909: invokevirtual 2072	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   912: pop
    //   913: aload_0
    //   914: getfield 1086	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:EGJ	I
    //   917: iconst_4
    //   918: if_icmpeq +11 -> 929
    //   921: aload_0
    //   922: getfield 1086	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:EGJ	I
    //   925: iconst_2
    //   926: if_icmpne +195 -> 1121
    //   929: iconst_1
    //   930: istore_2
    //   931: aload_0
    //   932: getfield 986	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:jkq	Ljava/lang/String;
    //   935: astore_1
    //   936: new 2840	com/tencent/mm/plugin/luckymoney/story/b/e
    //   939: dup
    //   940: invokespecial 2841	com/tencent/mm/plugin/luckymoney/story/b/e:<init>	()V
    //   943: astore 5
    //   945: aload 5
    //   947: aload_0
    //   948: getfield 1555	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:ExZ	Ljava/lang/String;
    //   951: putfield 2844	com/tencent/mm/plugin/luckymoney/story/b/e:field_send_id	Ljava/lang/String;
    //   954: invokestatic 2850	com/tencent/mm/plugin/luckymoney/b/a:eNR	()Lcom/tencent/mm/plugin/luckymoney/b/a;
    //   957: invokevirtual 2854	com/tencent/mm/plugin/luckymoney/b/a:eNQ	()Lcom/tencent/mm/plugin/luckymoney/story/b/f;
    //   960: aload 5
    //   962: iconst_0
    //   963: anewarray 649	java/lang/String
    //   966: invokevirtual 2859	com/tencent/mm/plugin/luckymoney/story/b/f:get	(Lcom/tencent/mm/sdk/storage/IAutoDBItem;[Ljava/lang/String;)Z
    //   969: istore 4
    //   971: ldc_w 493
    //   974: ldc_w 2861
    //   977: iconst_2
    //   978: anewarray 497	java/lang/Object
    //   981: dup
    //   982: iconst_0
    //   983: iload 4
    //   985: invokestatic 1723	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   988: aastore
    //   989: dup
    //   990: iconst_1
    //   991: aload_0
    //   992: getfield 1555	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:ExZ	Ljava/lang/String;
    //   995: aastore
    //   996: invokestatic 2863	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   999: iload 4
    //   1001: ifeq +146 -> 1147
    //   1004: aload 5
    //   1006: getfield 2866	com/tencent/mm/plugin/luckymoney/story/b/e:field_open_count	I
    //   1009: ifgt +133 -> 1142
    //   1012: aload 5
    //   1014: aload 5
    //   1016: getfield 2866	com/tencent/mm/plugin/luckymoney/story/b/e:field_open_count	I
    //   1019: iconst_1
    //   1020: iadd
    //   1021: putfield 2866	com/tencent/mm/plugin/luckymoney/story/b/e:field_open_count	I
    //   1024: invokestatic 2850	com/tencent/mm/plugin/luckymoney/b/a:eNR	()Lcom/tencent/mm/plugin/luckymoney/b/a;
    //   1027: invokevirtual 2854	com/tencent/mm/plugin/luckymoney/b/a:eNQ	()Lcom/tencent/mm/plugin/luckymoney/story/b/f;
    //   1030: aload 5
    //   1032: iconst_0
    //   1033: anewarray 649	java/lang/String
    //   1036: invokevirtual 2869	com/tencent/mm/plugin/luckymoney/story/b/f:update	(Lcom/tencent/mm/sdk/storage/IAutoDBItem;[Ljava/lang/String;)Z
    //   1039: pop
    //   1040: iload_2
    //   1041: aload_1
    //   1042: iload_3
    //   1043: invokestatic 2874	com/tencent/mm/plugin/luckymoney/story/a:o	(ILjava/lang/String;I)V
    //   1046: ldc_w 2638
    //   1049: invokestatic 328	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1052: return
    //   1053: aload_0
    //   1054: getfield 1786	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:EIu	Ljava/lang/String;
    //   1057: invokestatic 637	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   1060: ifne +53 -> 1113
    //   1063: aload_0
    //   1064: getfield 1786	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:EIu	Ljava/lang/String;
    //   1067: invokestatic 2878	com/tencent/mm/plugin/luckymoney/a/b:aNy	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/dvl;
    //   1070: astore_1
    //   1071: aload_1
    //   1072: ifnull +35 -> 1107
    //   1075: iconst_1
    //   1076: istore 4
    //   1078: ldc_w 493
    //   1081: ldc_w 2880
    //   1084: iconst_1
    //   1085: anewarray 497	java/lang/Object
    //   1088: dup
    //   1089: iconst_0
    //   1090: iload 4
    //   1092: invokestatic 1723	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1095: aastore
    //   1096: invokestatic 513	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1099: aload_0
    //   1100: aload_1
    //   1101: invokespecial 2827	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:a	(Lcom/tencent/mm/protocal/protobuf/dvl;)V
    //   1104: goto -232 -> 872
    //   1107: iconst_0
    //   1108: istore 4
    //   1110: goto -32 -> 1078
    //   1113: aload_0
    //   1114: aconst_null
    //   1115: invokespecial 2827	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:a	(Lcom/tencent/mm/protocal/protobuf/dvl;)V
    //   1118: goto -246 -> 872
    //   1121: aload_0
    //   1122: getfield 1086	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:EGJ	I
    //   1125: iconst_1
    //   1126: if_icmpeq +11 -> 1137
    //   1129: aload_0
    //   1130: getfield 1086	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:EGJ	I
    //   1133: iconst_3
    //   1134: if_icmpne +26 -> 1160
    //   1137: iconst_2
    //   1138: istore_2
    //   1139: goto -208 -> 931
    //   1142: iconst_2
    //   1143: istore_3
    //   1144: goto -132 -> 1012
    //   1147: iconst_2
    //   1148: istore_3
    //   1149: goto -109 -> 1040
    //   1152: astore_1
    //   1153: goto -657 -> 496
    //   1156: astore_1
    //   1157: goto -916 -> 241
    //   1160: iconst_0
    //   1161: istore_2
    //   1162: goto -231 -> 931
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1165	0	this	LuckyMoneyDetailUI
    //   0	1165	1	paramBundle	Bundle
    //   930	232	2	i	int
    //   1	1148	3	j	int
    //   969	140	4	bool	boolean
    //   943	88	5	locale	com.tencent.mm.plugin.luckymoney.story.b.e
    // Exception table:
    //   from	to	target	type
    //   46	51	647	java/lang/Exception
    //   496	564	718	java/lang/Exception
    //   564	599	718	java/lang/Exception
    //   599	607	718	java/lang/Exception
    //   611	616	718	java/lang/Exception
    //   682	693	718	java/lang/Exception
    //   697	715	718	java/lang/Exception
    //   752	756	718	java/lang/Exception
    //   485	496	1152	java/lang/Exception
    //   217	241	1156	java/lang/Exception
  }
  
  public boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
  {
    AppMethodBeat.i(65558);
    boolean bool = super.onCreatePanelMenu(paramInt, paramMenu);
    paramMenu = (TextView)findViewById(a.f.action_option_text);
    if (paramMenu != null) {
      paramMenu.setTextColor(getResources().getColor(a.c.lucky_money_goldstyle_envelop_primary_text_color));
    }
    AppMethodBeat.o(65558);
    return bool;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(65577);
    super.onDestroy();
    if ((this.EIC == 1) || (this.EIC == 2))
    {
      this.EHY = new jk();
      this.EHY.gCd = 12L;
      this.EHY.bpa();
    }
    if (this.Evw != null)
    {
      this.Evw.release();
      int i = 0;
      while (i < this.EHC.length)
      {
        this.Evw.unload(this.EHC[i]);
        i += 1;
      }
    }
    if (this.rzI != null)
    {
      Log.i("MicroMsg.LuckyMoneyDetailUI", "commentfooter release");
      this.rzI.onPause();
      this.rzI.hjm();
      this.rzI.destroy();
    }
    p.cUM().uEk = null;
    com.tencent.mm.plugin.luckymoney.a.b.clear();
    com.tencent.mm.plugin.luckymoney.a.c.openId = null;
    com.tencent.mm.plugin.luckymoney.a.c.jLI = null;
    com.tencent.mm.plugin.luckymoney.a.c.EsU = null;
    com.tencent.mm.plugin.luckymoney.a.c.lEm = null;
    com.tencent.mm.plugin.luckymoney.a.c.EsW = 0;
    com.tencent.mm.plugin.luckymoney.a.c.EsV = 0;
    com.tencent.mm.plugin.luckymoney.story.a.Bv(1);
    com.tencent.mm.kernel.h.aHF().kcd.b(697, this.EIA);
    Iterator localIterator = this.EIi.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      az.a.ltq.Rr(str);
    }
    this.EIi.clear();
    AppMethodBeat.o(65577);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(199939);
    boolean bool;
    if (paramInt != 4)
    {
      bool = super.onKeyUp(paramInt, paramKeyEvent);
      AppMethodBeat.o(199939);
      return bool;
    }
    if (this.EIf == null)
    {
      bool = super.onKeyUp(paramInt, paramKeyEvent);
      AppMethodBeat.o(199939);
      return bool;
    }
    if (!com.tencent.mm.plugin.wallet_core.utils.g.a(this.EIf))
    {
      bool = super.onKeyUp(paramInt, paramKeyEvent);
      AppMethodBeat.o(199939);
      return bool;
    }
    this.EIg.a(this.EIf, new g.a()
    {
      public final void a(coi paramAnonymouscoi)
      {
        AppMethodBeat.i(264857);
        if (paramAnonymouscoi.action == 1)
        {
          LuckyMoneyDetailUI.this.finish();
          AppMethodBeat.o(264857);
          return;
        }
        AppMethodBeat.o(264857);
      }
    });
    this.EIf = null;
    AppMethodBeat.o(199939);
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
    com.tencent.mm.modelstat.d.l("LuckyMoneyDetailUI", this.EIx, Util.nowSecond());
    AppMethodBeat.o(65560);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(65559);
    super.onResume();
    this.EIx = Util.nowSecond();
    com.tencent.mm.ui.widget.pulldown.e locale = getBounceView();
    if (locale != null) {
      locale.HO(false);
    }
    AppMethodBeat.o(65559);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(65566);
    Log.i("MicroMsg.LuckyMoneyDetailUI", "onSceneEnd() errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " netsceneType:" + paramq.getType());
    if ((paramq instanceof ap))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (ap)paramq;
        paramq = paramString.EAX;
        this.EGP = paramString.EBl;
        this.uFZ = paramString.EBm;
        this.EHU = paramString.EBn;
        this.EHX = paramString.EBo;
        this.EIv = paramq;
        a(this.EIv);
        AppMethodBeat.o(65566);
        return true;
      }
      com.tencent.mm.ui.base.h.cO(this, paramString);
      AppMethodBeat.o(65566);
      return true;
    }
    if ((paramq instanceof ay))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.Euf = false;
        paramString = (ay)paramq;
        if (this.Eud != null) {
          paramInt1 = 0;
        }
        for (;;)
        {
          if (paramInt1 < this.Eud.size())
          {
            paramq = (ae)this.Eud.get(paramInt1);
            if (paramq.Ezh.equalsIgnoreCase(paramString.Ezh))
            {
              paramq.EAI = paramString.EtJ;
              this.EIs.alc.notifyChanged();
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
      com.tencent.mm.ui.base.h.cO(this, paramString);
      AppMethodBeat.o(65566);
      return true;
    }
    if ((paramq instanceof bg))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.ui.widget.snackbar.b.r(this, getString(a.i.has_send));
        AppMethodBeat.o(65566);
        return true;
      }
      com.tencent.mm.ui.base.h.cO(this, paramString);
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
    public ae EIU;
    
    a() {}
    
    public final int bAQ()
    {
      return 2;
    }
    
    public final long mf()
    {
      AppMethodBeat.i(163737);
      long l = this.EIU.Ezh.hashCode();
      AppMethodBeat.o(163737);
      return l;
    }
  }
  
  final class b
    extends com.tencent.mm.view.recyclerview.e<LuckyMoneyDetailUI.a>
  {
    b() {}
    
    public final void a(RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.i parami, int paramInt) {}
    
    public final int getLayoutId()
    {
      return a.g.lucky_money_record_item;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI
 * JD-Core Version:    0.7.0.1
 */