package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.api.ad.a;
import com.tencent.mm.api.t;
import com.tencent.mm.autogen.a.aeg;
import com.tencent.mm.autogen.b.bm;
import com.tencent.mm.autogen.mmdata.rpt.hv;
import com.tencent.mm.autogen.mmdata.rpt.ij;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.plugin.emoji.g.d;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.luckymoney.model.ac;
import com.tencent.mm.plugin.luckymoney.model.ad;
import com.tencent.mm.plugin.luckymoney.model.ah;
import com.tencent.mm.plugin.luckymoney.model.aj;
import com.tencent.mm.plugin.luckymoney.model.as;
import com.tencent.mm.plugin.luckymoney.model.au;
import com.tencent.mm.plugin.luckymoney.model.ay;
import com.tencent.mm.plugin.luckymoney.model.bc;
import com.tencent.mm.plugin.luckymoney.model.be;
import com.tencent.mm.plugin.luckymoney.model.w;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.chat.e.b;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.widget.RoundCornerRelativeLayout;
import com.tencent.mm.wallet_core.model.m;
import com.tencent.mm.wallet_core.ui.l;
import java.util.LinkedList;
import java.util.Map;
import org.libpag.PAGView;
import org.libpag.PAGView.PAGViewListener;

@com.tencent.mm.ui.base.a(3)
@com.tencent.mm.ui.widget.pulldown.c(0)
public class LuckyMoneyNewYearSendUIV2
  extends LuckyMoneyBaseUI
{
  private TextView JCr;
  private a KBb;
  private View KBc;
  private ViewGroup KBn;
  private int KBs;
  private LuckyMoneyAutoScrollView KDH;
  private TextView KDI;
  private ImageView KDV;
  private View KDW;
  private BaseEmojiView KDX;
  private View KEA;
  private View KEB;
  private TextView KEC;
  private ImageView KED;
  private TextView KEE;
  private ImageView KEF;
  private ImageView KEG;
  private TextView KEH;
  private LinearLayout KEI;
  private MMAnimateView KEJ;
  private LinearLayout KEK;
  private TextView KEL;
  private TextView KEM;
  private String KEN;
  private boolean KEO;
  private int KEP;
  private int KEQ;
  private EmojiInfo KER;
  private hv KES;
  private ij KET;
  private int KEU;
  private int KEV;
  private int KEW;
  private int KEX;
  private int KEZ;
  private View KEj;
  private PAGView KEk;
  private PAGView.PAGViewListener KEl;
  private PAGView.PAGViewListener KEm;
  private final IListener KEv;
  private int KFa;
  private long KFb;
  private boolean KFc;
  private String KFd;
  private int KFe;
  private com.tencent.mm.emoji.e.a KFf;
  private String KFg;
  private RoundCornerRelativeLayout KFj;
  private View KFk;
  private View KFl;
  private View KFm;
  private PAGView KFn;
  private View KFo;
  private String KFp;
  private String KFq;
  private String KFr;
  private int KFs;
  private String KqM;
  private int Krb;
  public String KuA;
  public String KuB;
  private String Kun;
  private int Kup;
  private int Kuw;
  private LinkedList<ad> Kuz;
  private String Kwb;
  private int hXQ;
  private int mChannel;
  private MMHandler mHandler;
  private View plc;
  private View.OnClickListener qjL;
  private Dialog tipDialog;
  private ChatFooterPanel uKY;
  private LinearLayout wzS;
  private EmojiInfo xRp;
  private Button xXJ;
  
  public LuckyMoneyNewYearSendUIV2()
  {
    AppMethodBeat.i(284177);
    this.tipDialog = null;
    this.KEO = true;
    this.KEP = 0;
    this.Kuw = 0;
    this.KEQ = -1;
    this.mHandler = new MMHandler();
    this.KEU = 1;
    this.KBs = 0;
    this.KEV = 0;
    this.KEW = 0;
    this.KEX = 0;
    this.KEZ = 0;
    this.KFa = 0;
    this.KFb = 0L;
    this.KFc = false;
    this.KqM = "";
    this.KFd = "";
    this.KEv = new IListener(com.tencent.mm.app.f.hfK) {};
    this.qjL = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(284328);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNewYearSendUIV2$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (paramAnonymousView.getId() == a.f.lucky_money_new_year_send_btn)
        {
          com.tencent.mm.plugin.report.service.h.OAn.b(13079, new Object[] { Integer.valueOf(5), Integer.valueOf(1) });
          Log.i("MicroMsg.LuckyMoneyNewYearSendUIV2", "mSendBtn click!");
          LuckyMoneyNewYearSendUIV2.c(LuckyMoneyNewYearSendUIV2.this);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNewYearSendUIV2$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(284328);
          return;
          if (paramAnonymousView.getId() == a.f.lucky_money_new_year_take_cancle_iv)
          {
            LuckyMoneyNewYearSendUIV2.this.finish();
            com.tencent.mm.plugin.report.service.h.OAn.b(13079, new Object[] { Integer.valueOf(6), Integer.valueOf(1) });
            LuckyMoneyNewYearSendUIV2.a(LuckyMoneyNewYearSendUIV2.this, new hv());
            LuckyMoneyNewYearSendUIV2.d(LuckyMoneyNewYearSendUIV2.this).iPe = 11L;
            LuckyMoneyNewYearSendUIV2.d(LuckyMoneyNewYearSendUIV2.this).bMH();
            LuckyMoneyNewYearSendUIV2.e(LuckyMoneyNewYearSendUIV2.this);
          }
          else if ((paramAnonymousView.getId() == a.f.lucky_money_new_year_expression_btn) || (paramAnonymousView.getId() == a.f.lucky_money_new_year_expression_tips) || (paramAnonymousView.getId() == a.f.lucky_money_new_year_pag_video_add_emoji_btn_ll))
          {
            LuckyMoneyNewYearSendUIV2.a(LuckyMoneyNewYearSendUIV2.this, new hv());
            LuckyMoneyNewYearSendUIV2.d(LuckyMoneyNewYearSendUIV2.this).iPe = 3L;
            LuckyMoneyNewYearSendUIV2.d(LuckyMoneyNewYearSendUIV2.this).bMH();
            LuckyMoneyNewYearSendUIV2.f(LuckyMoneyNewYearSendUIV2.this);
          }
          else if ((paramAnonymousView.getId() == a.f.lucky_money_new_year_expression_del_btn) || (paramAnonymousView.getId() == a.f.lucky_money_new_year_expression_del_btn_ll))
          {
            LuckyMoneyNewYearSendUIV2.g(LuckyMoneyNewYearSendUIV2.this);
            LuckyMoneyNewYearSendUIV2.a(LuckyMoneyNewYearSendUIV2.this, null);
            com.tencent.mm.kernel.h.baE().ban().set(at.a.acPz, "");
            LuckyMoneyNewYearSendUIV2.h(LuckyMoneyNewYearSendUIV2.this);
            com.tencent.mm.plugin.report.service.h.OAn.b(13079, new Object[] { Integer.valueOf(3), Integer.valueOf(1) });
            LuckyMoneyNewYearSendUIV2.a(LuckyMoneyNewYearSendUIV2.this, new hv());
            LuckyMoneyNewYearSendUIV2.d(LuckyMoneyNewYearSendUIV2.this).iPe = 5L;
            LuckyMoneyNewYearSendUIV2.d(LuckyMoneyNewYearSendUIV2.this).bMH();
          }
          else if ((paramAnonymousView.getId() == a.f.lucky_money_new_year_refresh_layout) || (paramAnonymousView.getId() == a.f.lucky_money_amount_container))
          {
            LuckyMoneyNewYearSendUIV2.i(LuckyMoneyNewYearSendUIV2.this).fYd();
            LuckyMoneyNewYearSendUIV2.j(LuckyMoneyNewYearSendUIV2.this);
            LuckyMoneyNewYearSendUIV2.h(LuckyMoneyNewYearSendUIV2.this);
            com.tencent.mm.plugin.report.service.h.OAn.b(13079, new Object[] { Integer.valueOf(4), Integer.valueOf(1) });
            LuckyMoneyNewYearSendUIV2.a(LuckyMoneyNewYearSendUIV2.this, new hv());
            LuckyMoneyNewYearSendUIV2.d(LuckyMoneyNewYearSendUIV2.this).iPe = 2L;
            LuckyMoneyNewYearSendUIV2.d(LuckyMoneyNewYearSendUIV2.this).bMH();
          }
          else if (paramAnonymousView.getId() == a.f.lucky_money_new_year_reload_btn)
          {
            paramAnonymousView = com.tencent.mm.emoji.e.h.mol;
            com.tencent.mm.emoji.e.h.hw(LuckyMoneyNewYearSendUIV2.k(LuckyMoneyNewYearSendUIV2.this));
            LuckyMoneyNewYearSendUIV2.a(LuckyMoneyNewYearSendUIV2.this, false);
            LuckyMoneyNewYearSendUIV2.a(LuckyMoneyNewYearSendUIV2.this, 3);
          }
          else if (paramAnonymousView.getId() == a.f.lucky_money_new_year_expression)
          {
            LuckyMoneyNewYearSendUIV2.f(LuckyMoneyNewYearSendUIV2.this);
          }
        }
      }
    };
    this.KFs = 0;
    this.KFe = 0;
    this.KFf = new com.tencent.mm.emoji.e.a()
    {
      public final void a(long paramAnonymousLong, boolean paramAnonymousBoolean, String paramAnonymousString)
      {
        AppMethodBeat.i(284117);
        Log.i("MicroMsg.LuckyMoneyNewYearSendUIV2", "onResult() mTimeEnter:%s  timeEnter:%s  success:%s  md5:%s", new Object[] { Long.valueOf(LuckyMoneyNewYearSendUIV2.k(LuckyMoneyNewYearSendUIV2.this)), Long.valueOf(paramAnonymousLong), Boolean.valueOf(paramAnonymousBoolean), paramAnonymousString });
        if (Util.isEqual(LuckyMoneyNewYearSendUIV2.k(LuckyMoneyNewYearSendUIV2.this), paramAnonymousLong))
        {
          if (!paramAnonymousBoolean) {
            break label111;
          }
          LuckyMoneyNewYearSendUIV2.b(LuckyMoneyNewYearSendUIV2.this, paramAnonymousString);
        }
        for (;;)
        {
          LuckyMoneyNewYearSendUIV2.a(LuckyMoneyNewYearSendUIV2.this, true);
          paramAnonymousString = com.tencent.mm.emoji.e.b.mnS;
          com.tencent.mm.emoji.e.b.b(LuckyMoneyNewYearSendUIV2.k(LuckyMoneyNewYearSendUIV2.this), LuckyMoneyNewYearSendUIV2.ab(LuckyMoneyNewYearSendUIV2.this));
          AppMethodBeat.o(284117);
          return;
          label111:
          if ((Util.isEqual(LuckyMoneyNewYearSendUIV2.Z(LuckyMoneyNewYearSendUIV2.this), 0)) && (d.lr(LuckyMoneyNewYearSendUIV2.k(LuckyMoneyNewYearSendUIV2.this))))
          {
            LuckyMoneyNewYearSendUIV2.aa(LuckyMoneyNewYearSendUIV2.this);
            LuckyMoneyNewYearSendUIV2.a(LuckyMoneyNewYearSendUIV2.this, 2);
            AppMethodBeat.o(284117);
            return;
          }
          LuckyMoneyNewYearSendUIV2.a(LuckyMoneyNewYearSendUIV2.this, 4);
        }
      }
    };
    this.hXQ = 0;
    this.KFg = "";
    AppMethodBeat.o(284177);
  }
  
  private void aKM(String paramString)
  {
    AppMethodBeat.i(284185);
    this.xRp = com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adju.bza(paramString);
    if (d.z(this.xRp)) {
      this.KDX.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }
    for (;;)
    {
      this.KDX.setEmojiInfo(this.xRp);
      aad(1);
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acPz, paramString);
      AppMethodBeat.o(284185);
      return;
      if (this.xRp.aqJ()) {
        this.KDX.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      } else {
        this.KDX.setScaleType(ImageView.ScaleType.FIT_CENTER);
      }
    }
  }
  
  private void aad(final int paramInt)
  {
    AppMethodBeat.i(284188);
    com.tencent.threadpool.h.ahAA.bk(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(284376);
        LuckyMoneyNewYearSendUIV2.b(LuckyMoneyNewYearSendUIV2.this, paramInt);
        if (Util.isEqual(LuckyMoneyNewYearSendUIV2.q(LuckyMoneyNewYearSendUIV2.this), 0))
        {
          LuckyMoneyNewYearSendUIV2.r(LuckyMoneyNewYearSendUIV2.this).setVisibility(0);
          LuckyMoneyNewYearSendUIV2.s(LuckyMoneyNewYearSendUIV2.this).setVisibility(8);
          LuckyMoneyNewYearSendUIV2.t(LuckyMoneyNewYearSendUIV2.this).setVisibility(8);
          LuckyMoneyNewYearSendUIV2.u(LuckyMoneyNewYearSendUIV2.this);
          AppMethodBeat.o(284376);
          return;
        }
        LuckyMoneyNewYearSendUIV2.r(LuckyMoneyNewYearSendUIV2.this).setVisibility(8);
        Log.i("MicroMsg.LuckyMoneyNewYearSendUIV2", "exchangeExpressionState() state:%s", new Object[] { Integer.valueOf(paramInt) });
        switch (paramInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(284376);
          return;
          LuckyMoneyNewYearSendUIV2.s(LuckyMoneyNewYearSendUIV2.this).setVisibility(0);
          LuckyMoneyNewYearSendUIV2.v(LuckyMoneyNewYearSendUIV2.this).setText("");
          LuckyMoneyNewYearSendUIV2.t(LuckyMoneyNewYearSendUIV2.this).setVisibility(8);
          LuckyMoneyNewYearSendUIV2.u(LuckyMoneyNewYearSendUIV2.this);
          AppMethodBeat.o(284376);
          return;
          if (LuckyMoneyNewYearSendUIV2.w(LuckyMoneyNewYearSendUIV2.this) != null)
          {
            LuckyMoneyNewYearSendUIV2.a(LuckyMoneyNewYearSendUIV2.this, new hv());
            LuckyMoneyNewYearSendUIV2.d(LuckyMoneyNewYearSendUIV2.this).iPe = 4L;
            LuckyMoneyNewYearSendUIV2.d(LuckyMoneyNewYearSendUIV2.this).bMH();
          }
          LuckyMoneyNewYearSendUIV2.a(LuckyMoneyNewYearSendUIV2.this, LuckyMoneyNewYearSendUIV2.x(LuckyMoneyNewYearSendUIV2.this));
          if (LuckyMoneyNewYearSendUIV2.y(LuckyMoneyNewYearSendUIV2.this) == 0) {
            if (d.z(LuckyMoneyNewYearSendUIV2.x(LuckyMoneyNewYearSendUIV2.this))) {
              LuckyMoneyNewYearSendUIV2.c(LuckyMoneyNewYearSendUIV2.this, 2);
            }
          }
          for (;;)
          {
            LuckyMoneyNewYearSendUIV2.u(LuckyMoneyNewYearSendUIV2.this);
            LuckyMoneyNewYearSendUIV2.s(LuckyMoneyNewYearSendUIV2.this).setVisibility(8);
            LuckyMoneyNewYearSendUIV2.t(LuckyMoneyNewYearSendUIV2.this).setVisibility(0);
            LuckyMoneyNewYearSendUIV2.D(LuckyMoneyNewYearSendUIV2.this).setVisibility(8);
            LuckyMoneyNewYearSendUIV2.E(LuckyMoneyNewYearSendUIV2.this).setVisibility(0);
            LuckyMoneyNewYearSendUIV2.F(LuckyMoneyNewYearSendUIV2.this).setVisibility(0);
            LuckyMoneyNewYearSendUIV2.G(LuckyMoneyNewYearSendUIV2.this).setVisibility(0);
            LuckyMoneyNewYearSendUIV2.H(LuckyMoneyNewYearSendUIV2.this).setVisibility(0);
            LuckyMoneyNewYearSendUIV2.I(LuckyMoneyNewYearSendUIV2.this).setVisibility(8);
            LuckyMoneyNewYearSendUIV2.J(LuckyMoneyNewYearSendUIV2.this).setVisibility(8);
            AppMethodBeat.o(284376);
            return;
            if (d.x(LuckyMoneyNewYearSendUIV2.x(LuckyMoneyNewYearSendUIV2.this)))
            {
              LuckyMoneyNewYearSendUIV2.c(LuckyMoneyNewYearSendUIV2.this, 4);
            }
            else
            {
              LuckyMoneyNewYearSendUIV2.c(LuckyMoneyNewYearSendUIV2.this, 3);
              continue;
              if (LuckyMoneyNewYearSendUIV2.y(LuckyMoneyNewYearSendUIV2.this) == 1)
              {
                LuckyMoneyNewYearSendUIV2.c(LuckyMoneyNewYearSendUIV2.this, 2);
                LuckyMoneyNewYearSendUIV2.z(LuckyMoneyNewYearSendUIV2.this);
              }
              else if (LuckyMoneyNewYearSendUIV2.y(LuckyMoneyNewYearSendUIV2.this) == 2)
              {
                if (d.z(LuckyMoneyNewYearSendUIV2.x(LuckyMoneyNewYearSendUIV2.this)))
                {
                  LuckyMoneyNewYearSendUIV2.c(LuckyMoneyNewYearSendUIV2.this, 2);
                  LuckyMoneyNewYearSendUIV2.A(LuckyMoneyNewYearSendUIV2.this);
                }
                else if (d.x(LuckyMoneyNewYearSendUIV2.x(LuckyMoneyNewYearSendUIV2.this)))
                {
                  LuckyMoneyNewYearSendUIV2.c(LuckyMoneyNewYearSendUIV2.this, 4);
                  LuckyMoneyNewYearSendUIV2.B(LuckyMoneyNewYearSendUIV2.this);
                }
                else
                {
                  LuckyMoneyNewYearSendUIV2.c(LuckyMoneyNewYearSendUIV2.this, 3);
                  LuckyMoneyNewYearSendUIV2.C(LuckyMoneyNewYearSendUIV2.this);
                }
              }
            }
          }
          LuckyMoneyNewYearSendUIV2.s(LuckyMoneyNewYearSendUIV2.this).setVisibility(8);
          LuckyMoneyNewYearSendUIV2.t(LuckyMoneyNewYearSendUIV2.this).setVisibility(0);
          LuckyMoneyNewYearSendUIV2.D(LuckyMoneyNewYearSendUIV2.this).setVisibility(8);
          LuckyMoneyNewYearSendUIV2.E(LuckyMoneyNewYearSendUIV2.this).setVisibility(8);
          LuckyMoneyNewYearSendUIV2.F(LuckyMoneyNewYearSendUIV2.this).setVisibility(8);
          LuckyMoneyNewYearSendUIV2.G(LuckyMoneyNewYearSendUIV2.this).setVisibility(8);
          LuckyMoneyNewYearSendUIV2.H(LuckyMoneyNewYearSendUIV2.this).setVisibility(8);
          LuckyMoneyNewYearSendUIV2.I(LuckyMoneyNewYearSendUIV2.this).setVisibility(0);
          LuckyMoneyNewYearSendUIV2.J(LuckyMoneyNewYearSendUIV2.this).setVisibility(8);
          LuckyMoneyNewYearSendUIV2.u(LuckyMoneyNewYearSendUIV2.this);
          AppMethodBeat.o(284376);
          return;
          LuckyMoneyNewYearSendUIV2.s(LuckyMoneyNewYearSendUIV2.this).setVisibility(8);
          LuckyMoneyNewYearSendUIV2.u(LuckyMoneyNewYearSendUIV2.this);
          LuckyMoneyNewYearSendUIV2.t(LuckyMoneyNewYearSendUIV2.this).setVisibility(0);
          LuckyMoneyNewYearSendUIV2.D(LuckyMoneyNewYearSendUIV2.this).setVisibility(8);
          LuckyMoneyNewYearSendUIV2.E(LuckyMoneyNewYearSendUIV2.this).setVisibility(8);
          LuckyMoneyNewYearSendUIV2.F(LuckyMoneyNewYearSendUIV2.this).setVisibility(8);
          LuckyMoneyNewYearSendUIV2.G(LuckyMoneyNewYearSendUIV2.this).setVisibility(8);
          LuckyMoneyNewYearSendUIV2.H(LuckyMoneyNewYearSendUIV2.this).setVisibility(8);
          LuckyMoneyNewYearSendUIV2.I(LuckyMoneyNewYearSendUIV2.this).setVisibility(8);
          LuckyMoneyNewYearSendUIV2.J(LuckyMoneyNewYearSendUIV2.this).setVisibility(0);
          LuckyMoneyNewYearSendUIV2.K(LuckyMoneyNewYearSendUIV2.this).setImageResource(a.h.lucky_money_newyear_creat_loading);
          AppMethodBeat.o(284376);
          return;
          LuckyMoneyNewYearSendUIV2.s(LuckyMoneyNewYearSendUIV2.this).setVisibility(0);
          LuckyMoneyNewYearSendUIV2.v(LuckyMoneyNewYearSendUIV2.this).setText(a.i.lucky_money_newyear_fail_and_again_add);
          LuckyMoneyNewYearSendUIV2.t(LuckyMoneyNewYearSendUIV2.this).setVisibility(8);
          LuckyMoneyNewYearSendUIV2.u(LuckyMoneyNewYearSendUIV2.this);
          AppMethodBeat.o(284376);
          return;
          LuckyMoneyNewYearSendUIV2.L(LuckyMoneyNewYearSendUIV2.this);
          AppMethodBeat.o(284376);
          return;
          LuckyMoneyNewYearSendUIV2.s(LuckyMoneyNewYearSendUIV2.this).setVisibility(8);
          LuckyMoneyNewYearSendUIV2.t(LuckyMoneyNewYearSendUIV2.this).setVisibility(0);
          LuckyMoneyNewYearSendUIV2.D(LuckyMoneyNewYearSendUIV2.this).setVisibility(8);
          LuckyMoneyNewYearSendUIV2.E(LuckyMoneyNewYearSendUIV2.this).setVisibility(8);
          LuckyMoneyNewYearSendUIV2.F(LuckyMoneyNewYearSendUIV2.this).setVisibility(8);
          LuckyMoneyNewYearSendUIV2.G(LuckyMoneyNewYearSendUIV2.this).setVisibility(8);
          LuckyMoneyNewYearSendUIV2.H(LuckyMoneyNewYearSendUIV2.this).setVisibility(8);
          LuckyMoneyNewYearSendUIV2.I(LuckyMoneyNewYearSendUIV2.this).setVisibility(8);
          LuckyMoneyNewYearSendUIV2.J(LuckyMoneyNewYearSendUIV2.this).setVisibility(0);
          LuckyMoneyNewYearSendUIV2.K(LuckyMoneyNewYearSendUIV2.this).setImageResource(a.e.lucky_money_newyear_loading_anim);
          RotateAnimation localRotateAnimation = new RotateAnimation(0.0F, 359.0F, 1, 0.5F, 1, 0.5F);
          localRotateAnimation.setDuration(1000L);
          localRotateAnimation.setRepeatCount(-1);
          localRotateAnimation.setInterpolator(new LinearInterpolator());
          LuckyMoneyNewYearSendUIV2.K(LuckyMoneyNewYearSendUIV2.this).startAnimation(localRotateAnimation);
          LuckyMoneyNewYearSendUIV2.a(LuckyMoneyNewYearSendUIV2.this).alive();
          ac.ka(LuckyMoneyNewYearSendUIV2.this.KuA, LuckyMoneyNewYearSendUIV2.this.KuB);
          LuckyMoneyNewYearSendUIV2.u(LuckyMoneyNewYearSendUIV2.this);
        }
      }
    });
    AppMethodBeat.o(284188);
  }
  
  private void aae(int paramInt)
  {
    AppMethodBeat.i(284179);
    this.KET = new ij();
    this.KET.ioV = paramInt;
    this.KET.iPW = this.KEU;
    this.KET.iPX = this.KEV;
    this.KET.iPY = this.KEW;
    this.KET.iPZ = this.KEX;
    this.KET.iQc = this.KEZ;
    this.KET.iQa = this.KFa;
    ij localij = this.KET;
    if (this.xRp == null) {}
    for (String str = "";; str = this.xRp.getMd5())
    {
      localij.rN(str);
      this.KET.bMH();
      AppMethodBeat.o(284179);
      return;
    }
  }
  
  private void aaf(int paramInt)
  {
    AppMethodBeat.i(284196);
    Log.i("MicroMsg.LuckyMoneyNewYearSendUIV2", "doSend()");
    com.tencent.mm.plugin.report.service.h.OAn.b(11701, new Object[] { Integer.valueOf(15), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(1) });
    if (this.tipDialog != null) {
      if (!this.tipDialog.isShowing()) {
        this.tipDialog.show();
      }
    }
    String str2;
    String str1;
    int i;
    for (;;)
    {
      str2 = com.tencent.mm.model.z.bAM();
      str1 = "";
      i = 0;
      if (this.xRp != null)
      {
        str1 = this.xRp.getMd5();
        i = this.xRp.field_type;
      }
      Log.i("MicroMsg.LuckyMoneyNewYearSendUIV2", "doSend() mUniqueId:%s userConfirmJump:%s lastPayResult:%s mSendId:%s", new Object[] { this.KFd, Integer.valueOf(paramInt), Integer.valueOf(this.hXQ), this.KqM });
      if (!this.KFc) {
        break;
      }
      doSceneProgress(new au(1, this.Kup, this.Kup, 3, this.Kun, this.KEN, ah.fXi(), com.tencent.mm.model.z.bAM(), 2), false);
      AppMethodBeat.o(284196);
      return;
      this.tipDialog = l.a(getContext(), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(284369);
          if ((LuckyMoneyNewYearSendUIV2.M(LuckyMoneyNewYearSendUIV2.this) != null) && (LuckyMoneyNewYearSendUIV2.M(LuckyMoneyNewYearSendUIV2.this).isShowing())) {
            LuckyMoneyNewYearSendUIV2.M(LuckyMoneyNewYearSendUIV2.this).dismiss();
          }
          if ((LuckyMoneyNewYearSendUIV2.N(LuckyMoneyNewYearSendUIV2.this).getVisibility() == 8) || (LuckyMoneyNewYearSendUIV2.O(LuckyMoneyNewYearSendUIV2.this).getVisibility() == 4))
          {
            Log.i("MicroMsg.LuckyMoneyNewYearSendUIV2", "usr cancel, & visibility not visiable, so finish");
            LuckyMoneyNewYearSendUIV2.this.finish();
          }
          LuckyMoneyNewYearSendUIV2.this.KzD.forceCancel();
          AppMethodBeat.o(284369);
        }
      });
    }
    doSceneProgress(new be(this.Kup, this.Kun, ah.aKC(str2), this.KEN, str2, com.tencent.mm.model.z.bAO(), this.Krb, str1, i, this.KFd, paramInt, this.hXQ, this.KqM), false);
    AppMethodBeat.o(284196);
  }
  
  private void fYA()
  {
    AppMethodBeat.i(284182);
    this.KES = new hv();
    this.KES.iPe = 10L;
    this.KES.bMH();
    this.KBs = 2;
    this.KBb.show();
    if (Util.isEqual(this.KEP, 1)) {}
    for (int i = ChatFooterPanel.XYu;; i = ChatFooterPanel.XYr)
    {
      com.tencent.mm.plugin.luckymoney.ui.a.b.a(this.KBn, this.uKY, i, new ad.a()
      {
        public final void a(t paramAnonymoust)
        {
          AppMethodBeat.i(284312);
          Log.i("MicroMsg.LuckyMoneyNewYearSendUIV2", "[onSelectedEmoji] emojiInfo:%s", new Object[] { paramAnonymoust });
          LuckyMoneyNewYearSendUIV2.a(LuckyMoneyNewYearSendUIV2.this, paramAnonymoust);
          LuckyMoneyNewYearSendUIV2.b(LuckyMoneyNewYearSendUIV2.this);
          AppMethodBeat.o(284312);
        }
        
        public final void onHide()
        {
          AppMethodBeat.i(369816);
          LuckyMoneyNewYearSendUIV2.b(LuckyMoneyNewYearSendUIV2.this);
          AppMethodBeat.o(369816);
        }
      });
      AppMethodBeat.o(284182);
      return;
    }
  }
  
  private void fYB()
  {
    AppMethodBeat.i(284202);
    this.KEV += 1;
    this.KEQ += 1;
    int i;
    if ((this.Kuz != null) && (this.Kuz.size() > 0)) {
      if (this.KEQ < this.Kuz.size()) {
        i = this.KEQ;
      }
    }
    for (;;)
    {
      this.KEQ = i;
      if ((this.KEQ >= 0) && (this.KEQ < this.Kuz.size()))
      {
        this.Kup = ((ad)this.Kuz.get(this.KEQ)).KtA;
        this.Kun = ((ad)this.Kuz.get(this.KEQ)).KtB;
        this.KFq = ((ad)this.Kuz.get(this.KEQ)).Kts;
        this.KFr = ((ad)this.Kuz.get(this.KEQ)).Ktt;
      }
      Log.i("MicroMsg.LuckyMoneyNewYearSendUIV2", "yearMessList.size():%s，mSelectIndex：%s, randomAmount:%s, randomWishing:%s, randomWishKeyWord:%s, randomPagName:%s", new Object[] { Integer.valueOf(this.Kuz.size()), Integer.valueOf(this.KEQ), Integer.valueOf(this.Kup), this.Kun, this.KFq, this.KFr });
      this.KDH.setFinalText(com.tencent.mm.wallet_core.ui.i.formatMoney2f(this.Kup / 100.0D));
      yg(false);
      this.KDH.setFocusable(false);
      this.KFm.setFocusable(false);
      this.KFm.setClickable(false);
      this.KEK.setFocusable(false);
      this.KEK.setClickable(false);
      this.KDH.setContentDescription("");
      if (!this.KEO) {
        break;
      }
      com.tencent.threadpool.h.ahAA.o(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(284126);
          ac.hY(LuckyMoneyNewYearSendUIV2.P(LuckyMoneyNewYearSendUIV2.this));
          LuckyMoneyNewYearSendUIV2.Q(LuckyMoneyNewYearSendUIV2.this).setVisibility(4);
          LuckyMoneyNewYearSendUIV2.R(LuckyMoneyNewYearSendUIV2.this).setVisibility(4);
          LuckyMoneyNewYearSendUIV2.S(LuckyMoneyNewYearSendUIV2.this);
          AppMethodBeat.o(284126);
        }
      }, 500L);
      AppMethodBeat.o(284202);
      return;
      i = 0;
      continue;
      Log.e("MicroMsg.LuckyMoneyNewYearSendUIV2", "genRandomAmountIndex yearMessList is empty!");
      i = -1;
    }
    ac.aH(this.JCr, 4);
    fYC();
    AppMethodBeat.o(284202);
  }
  
  private void fYC()
  {
    AppMethodBeat.i(284205);
    this.KDH.a(new LuckyMoneyAutoScrollView.a()
    {
      public final void fYe()
      {
        AppMethodBeat.i(284135);
        if (LuckyMoneyNewYearSendUIV2.T(LuckyMoneyNewYearSendUIV2.this))
        {
          ah.a(LuckyMoneyNewYearSendUIV2.this.getContext(), LuckyMoneyNewYearSendUIV2.Q(LuckyMoneyNewYearSendUIV2.this), LuckyMoneyNewYearSendUIV2.U(LuckyMoneyNewYearSendUIV2.this));
          ac.hY(LuckyMoneyNewYearSendUIV2.Q(LuckyMoneyNewYearSendUIV2.this));
          ac.hY(LuckyMoneyNewYearSendUIV2.R(LuckyMoneyNewYearSendUIV2.this));
          LuckyMoneyNewYearSendUIV2.V(LuckyMoneyNewYearSendUIV2.this);
        }
        for (;;)
        {
          LuckyMoneyNewYearSendUIV2.a(LuckyMoneyNewYearSendUIV2.this, true);
          LuckyMoneyNewYearSendUIV2.i(LuckyMoneyNewYearSendUIV2.this).setFocusable(true);
          com.tencent.threadpool.h.ahAA.o(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(284301);
              LuckyMoneyNewYearSendUIV2.P(LuckyMoneyNewYearSendUIV2.this).setFocusable(true);
              LuckyMoneyNewYearSendUIV2.P(LuckyMoneyNewYearSendUIV2.this).setClickable(true);
              LuckyMoneyNewYearSendUIV2.W(LuckyMoneyNewYearSendUIV2.this).setFocusable(true);
              LuckyMoneyNewYearSendUIV2.W(LuckyMoneyNewYearSendUIV2.this).setClickable(true);
              AppMethodBeat.o(284301);
            }
          }, 500L);
          LuckyMoneyNewYearSendUIV2.i(LuckyMoneyNewYearSendUIV2.this).setContentDescription(LuckyMoneyNewYearSendUIV2.X(LuckyMoneyNewYearSendUIV2.this) / 100.0D);
          AppMethodBeat.o(284135);
          return;
          ac.hY(LuckyMoneyNewYearSendUIV2.Q(LuckyMoneyNewYearSendUIV2.this));
          LuckyMoneyNewYearSendUIV2.R(LuckyMoneyNewYearSendUIV2.this).setVisibility(0);
          ah.a(LuckyMoneyNewYearSendUIV2.this.getContext(), LuckyMoneyNewYearSendUIV2.Q(LuckyMoneyNewYearSendUIV2.this), LuckyMoneyNewYearSendUIV2.U(LuckyMoneyNewYearSendUIV2.this));
          LuckyMoneyNewYearSendUIV2.Q(LuckyMoneyNewYearSendUIV2.this).invalidate();
        }
      }
    });
    AppMethodBeat.o(284205);
  }
  
  private void fYD()
  {
    AppMethodBeat.i(284209);
    String str = (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acPz, "");
    if ((!Util.isNullOrNil(str)) && (this.KFs != 5))
    {
      aKM(str);
      AppMethodBeat.o(284209);
      return;
    }
    if (ac.fXh())
    {
      this.KFp = "start";
      aad(5);
      AppMethodBeat.o(284209);
      return;
    }
    aad(6);
    AppMethodBeat.o(284209);
  }
  
  private void updateView()
  {
    AppMethodBeat.i(284191);
    Log.i("MicroMsg.LuckyMoneyNewYearSendUIV2", "ljd:updateView");
    if ((this.Kuz != null) && (this.Kuz.size() > 0))
    {
      Log.i("MicroMsg.LuckyMoneyNewYearSendUIV2", "ljd:year mess list is valid!");
      this.KEK.setVisibility(0);
    }
    for (;;)
    {
      this.JCr.getLayoutParams();
      this.JCr.setTextSize(1, 17.0F);
      this.KDI.setTextSize(1, 15.0F);
      this.KDH.jF(getResources().getDimensionPixelOffset(a.d.lucky_money_newyear_num_width), getResources().getDimensionPixelOffset(a.d.lucky_money_newyear_num_height));
      Object localObject = (LinearLayout.LayoutParams)this.KDH.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).topMargin = getResources().getDimensionPixelOffset(a.d.lucky_money_new_year_amount_top_margin_for_normal);
      this.KDH.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.KDH.invalidate();
      localObject = (RelativeLayout.LayoutParams)this.KEK.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).topMargin = getResources().getDimensionPixelOffset(a.d.lucky_money_new_year_refresh_layout_top_margin_for_normal_v2);
      this.KEK.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.KEK.invalidate();
      AppMethodBeat.o(284191);
      return;
      Log.i("MicroMsg.LuckyMoneyNewYearSendUIV2", "ljd:year mess list is not valid!");
      this.KEK.setVisibility(8);
    }
  }
  
  private void yg(boolean paramBoolean)
  {
    AppMethodBeat.i(284214);
    this.xXJ.setClickable(paramBoolean);
    if (paramBoolean)
    {
      if ((this.xXJ.getBackground() != null) && (this.xXJ.getBackground().mutate() != null)) {
        this.xXJ.getBackground().mutate().setAlpha(255);
      }
      this.xXJ.setTextColor(getResources().getColor(a.c.lucky_money_new_year_send_btn_text_color));
    }
    AppMethodBeat.o(284214);
  }
  
  public int getLayoutId()
  {
    return a.g.lucky_money_new_year_send_ui_v2;
  }
  
  public void initView()
  {
    AppMethodBeat.i(284391);
    setActionbarColor(-839716110);
    setContentViewVisibility(8);
    this.plc = findViewById(a.f.lucky_money_new_year_send_root);
    if (aw.isDarkMode())
    {
      this.plc.setBackgroundResource(a.c.BW_0_Alpha_0_8);
      setActionbarColor(getResources().getColor(a.c.BW_0_Alpha_0_8));
      setNavigationbarColor(getResources().getColor(a.c.BW_0_Alpha_0_8));
    }
    for (;;)
    {
      this.KEA = findViewById(a.f.lucky_money_newyear_send_ll);
      this.KDI = ((TextView)findViewById(a.f.lucky_money_amount_unit_title_tv));
      this.KDH = ((LuckyMoneyAutoScrollView)findViewById(a.f.lucky_money_new_year_amount));
      this.JCr = ((TextView)findViewById(a.f.lucky_money_new_year_wishing));
      this.xXJ = ((Button)findViewById(a.f.lucky_money_new_year_send_btn));
      this.xXJ.setOnClickListener(this.qjL);
      ((ImageView)findViewById(a.f.lucky_money_new_year_take_cancle_iv)).setOnClickListener(this.qjL);
      this.KDV = ((ImageView)findViewById(a.f.lucky_money_new_year_good));
      this.KEB = findViewById(a.f.lucky_money_new_year_expression_ll);
      this.KEC = ((TextView)findViewById(a.f.lucky_money_new_year_expression_tips));
      this.KED = ((ImageView)findViewById(a.f.lucky_money_new_year_expression_btn));
      this.KED.setOnClickListener(this.qjL);
      this.KEE = ((TextView)findViewById(a.f.lucky_money_new_year_expression_tips));
      this.KEE.setOnClickListener(this.qjL);
      this.KDW = findViewById(a.f.lucky_money_new_year_expression_layout);
      this.KDX = ((BaseEmojiView)findViewById(a.f.lucky_money_new_year_expression));
      this.KFj = ((RoundCornerRelativeLayout)findViewById(a.f.lucky_money_new_year_expression_container));
      this.KFj.setRadius(com.tencent.mm.cd.a.fromDPToPix(getContext(), 16));
      this.KFk = findViewById(a.f.lucky_money_new_year_expression_container_root);
      this.KDX.setOnClickListener(this.qjL);
      this.KEG = ((ImageView)findViewById(a.f.lucky_money_new_year_expression_del_btn));
      this.KFl = findViewById(a.f.lucky_money_new_year_expression_del_btn_ll);
      this.KFl.setOnClickListener(this.qjL);
      this.KEF = ((ImageView)findViewById(a.f.lucky_money_new_year_expression_default));
      this.KEH = ((TextView)findViewById(a.f.lucky_money_new_year_reload_btn));
      this.KEH.setOnClickListener(this.qjL);
      this.KEI = ((LinearLayout)findViewById(a.f.lucky_money_new_year_creating));
      this.KEJ = ((MMAnimateView)findViewById(a.f.loading_image));
      this.KEK = ((LinearLayout)findViewById(a.f.lucky_money_new_year_refresh_layout));
      this.KEK.setOnClickListener(this.qjL);
      this.KFm = findViewById(a.f.lucky_money_amount_container);
      this.KFm.setOnClickListener(this.qjL);
      this.KBb = new a(this);
      this.KBc = getLayoutInflater().inflate(a.g.lucky_money_emoji_dialog, null);
      this.KBb.setContentView(this.KBc, new ViewGroup.LayoutParams(-1, -1));
      this.KBc.findViewById(a.f.lucky_money_emoji_dismiss_area).setOnClickListener(new LuckyMoneyNewYearSendUIV2.12(this));
      this.KBb.KyS = new LuckyMoneyNewYearSendUIV2.13(this);
      this.KBn = ((ViewGroup)this.KBc.findViewById(a.f.lucky_money_emoji_root));
      this.uKY = com.tencent.mm.pluginsdk.ui.chat.e.Ykf.fZ(getContext());
      this.uKY.setTalkerName(this.KEN);
      this.uKY.setShowSmiley(false);
      this.wzS = ((LinearLayout)findViewById(a.f.lucky_money_new_year_header));
      this.KEL = ((TextView)findViewById(a.f.lucky_money_hk_amount_unit_title_tv));
      this.KEM = ((TextView)findViewById(a.f.lucky_money_hk_amount_holder));
      if (this.KFc)
      {
        this.wzS.setVisibility(4);
        this.KEA.setBackgroundResource(a.e.lucky_money_hk_newyear_new_bg);
        this.KEL.setVisibility(0);
        this.KEM.setVisibility(4);
        this.KDI.setVisibility(8);
      }
      this.KEj = findViewById(a.f.lucky_money_new_year_pag_video_layout);
      this.KFo = findViewById(a.f.lucky_money_new_year_pag_video_add_emoji_btn_ll);
      this.KFo.setOnClickListener(this.qjL);
      this.KEk = ((PAGView)findViewById(a.f.lucky_money_new_year_pag_video));
      this.KFn = ((PAGView)findViewById(a.f.lucky_money_new_year_pag_video_loop));
      this.KEl = new PAGView.PAGViewListener()
      {
        public final void onAnimationCancel(PAGView paramAnonymousPAGView) {}
        
        public final void onAnimationEnd(PAGView paramAnonymousPAGView)
        {
          AppMethodBeat.i(284111);
          if (LuckyMoneyNewYearSendUIV2.ac(LuckyMoneyNewYearSendUIV2.this) == 5)
          {
            LuckyMoneyNewYearSendUIV2.a(LuckyMoneyNewYearSendUIV2.this, "loop");
            LuckyMoneyNewYearSendUIV2.a(LuckyMoneyNewYearSendUIV2.this, 5);
          }
          AppMethodBeat.o(284111);
        }
        
        public final void onAnimationRepeat(PAGView paramAnonymousPAGView) {}
        
        public final void onAnimationStart(PAGView paramAnonymousPAGView) {}
      };
      this.KEm = new PAGView.PAGViewListener()
      {
        public final void onAnimationCancel(PAGView paramAnonymousPAGView) {}
        
        public final void onAnimationEnd(PAGView paramAnonymousPAGView) {}
        
        public final void onAnimationRepeat(PAGView paramAnonymousPAGView) {}
        
        public final void onAnimationStart(PAGView paramAnonymousPAGView) {}
      };
      this.KEk.addListener(this.KEl);
      this.KEk.setRepeatCount(1);
      this.KEk.setScaleMode(3);
      this.KFn.setRepeatCount(1);
      this.KFn.setScaleMode(3);
      Log.i("MicroMsg.LuckyMoneyNewYearSendUIV2", "setBackgroundContainerSize");
      Object localObject1 = bf.bf(getContext());
      int i = ((Point)localObject1).x;
      int j = ((Point)localObject1).y;
      int k = bf.getStatusBarHeight(getContext());
      int m = bf.bk(getContext());
      int n = com.tencent.mm.cd.a.fromDPToPix(getContext(), 320);
      int i1 = com.tencent.mm.cd.a.fromDPToPix(getContext(), 560);
      localObject1 = this.KEA.getLayoutParams();
      int i2 = com.tencent.mm.cd.a.fromDPToPix(getContext(), 48) + com.tencent.mm.cd.a.fromDPToPix(getContext(), 40);
      Log.i("MicroMsg.LuckyMoneyNewYearSendUIV2", "screenWidth：%s containerRealWidth:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(n) });
      if (i <= n)
      {
        Log.i("MicroMsg.LuckyMoneyNewYearSendUIV2", "need adjust width");
        ((ViewGroup.LayoutParams)localObject1).width = (i - com.tencent.mm.cd.a.fromDPToPix(getContext(), 48));
      }
      Log.i("MicroMsg.LuckyMoneyNewYearSendUIV2", "screenHeighh：%s  statusHeight:%s containerRealHeight + buttonHeight:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i1 + i2) });
      if (j - k - m < i1 + i2)
      {
        Log.i("MicroMsg.LuckyMoneyNewYearSendUIV2", "need adjust height");
        ((ViewGroup.LayoutParams)localObject1).height = (j - k - m - i2);
        Object localObject2 = (LinearLayout.LayoutParams)this.JCr.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject2).bottomMargin = com.tencent.mm.cd.a.fromDPToPix(getContext(), 0);
        ((LinearLayout.LayoutParams)localObject2).topMargin = com.tencent.mm.cd.a.fromDPToPix(getContext(), 8);
        this.JCr.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        localObject2 = (RelativeLayout.LayoutParams)this.xXJ.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject2).bottomMargin = com.tencent.mm.cd.a.fromDPToPix(getContext(), 16);
        this.xXJ.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        localObject2 = (LinearLayout.LayoutParams)((ImageView)findViewById(a.f.lucky_money_new_year_take_cancle_iv)).getLayoutParams();
        ((LinearLayout.LayoutParams)localObject2).topMargin = com.tencent.mm.cd.a.fromDPToPix(getContext(), 24);
        ((ImageView)findViewById(a.f.lucky_money_new_year_take_cancle_iv)).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      this.KEA.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      AppMethodBeat.o(284391);
      return;
      this.plc.setBackgroundColor(-839716110);
      setActionbarColor(-839716110);
      setNavigationbarColor(-839716110);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(284412);
    Object localObject1;
    switch (paramInt1)
    {
    default: 
      AppMethodBeat.o(284412);
      return;
    case 1: 
      if (paramInt2 == -1)
      {
        Log.i("MicroMsg.LuckyMoneyNewYearSendUIV2", "do pay success!");
        com.tencent.mm.plugin.report.service.h.OAn.b(11701, new Object[] { Integer.valueOf(15), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2) });
        if ((paramIntent == null) || (!paramIntent.hasExtra("key_realname_guide_helper"))) {
          break label983;
        }
        localObject1 = (RealnameGuideHelper)paramIntent.getParcelableExtra("key_realname_guide_helper");
        if (localObject1 == null) {
          break label983;
        }
        if (!((RealnameGuideHelper)localObject1).b(this, null, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(284113);
            LuckyMoneyNewYearSendUIV2.this.finish();
            AppMethodBeat.o(284113);
          }
        })) {
          paramInt1 = 1;
        }
      }
      break;
    }
    for (;;)
    {
      if (this.xRp == null)
      {
        Log.i("MicroMsg.LuckyMoneyNewYearSendUIV2", "dealXmlAddEmojiInfo() mEmojiInfo == null");
        localObject1 = XmlParser.parseXml(this.Kwb, "msg", null);
        if (localObject1 == null)
        {
          Log.e("MicroMsg.LuckyMoneyNewYearSendUIV2", "LuckyMoneyNewYearSendUIV2 onActivityResult values is null");
          finish();
          AppMethodBeat.o(284412);
          return;
          paramInt1 = 0;
        }
      }
      else
      {
        for (;;)
        {
          try
          {
            int i = this.Kwb.indexOf("<wcpayinfo>");
            if ((i > 0) && (i < this.Kwb.length()))
            {
              StringBuilder localStringBuilder = new StringBuilder();
              if (this.xRp != null) {
                break label375;
              }
              localObject1 = new EmojiInfo();
              com.tencent.mm.plugin.luckymoney.a.e.a(localStringBuilder, (bm)localObject1, 0);
              localObject1 = new StringBuilder(this.Kwb.substring(0, i));
              String str = this.Kwb.substring(i).trim();
              ((StringBuilder)localObject1).append(localStringBuilder).append(str);
              this.Kwb = ((StringBuilder)localObject1).toString();
            }
            Log.i("MicroMsg.LuckyMoneyNewYearSendUIV2", "dealXmlAddEmojiInfo() success");
          }
          catch (Exception localException)
          {
            Log.i("MicroMsg.LuckyMoneyNewYearSendUIV2", "dealXmlAddEmojiInfo() Exception:%s", new Object[] { localException.getMessage() });
          }
          break;
          label375:
          localObject2 = this.xRp;
        }
      }
      Object localObject2 = (String)((Map)localObject2).get(".msg.appmsg.wcpayinfo.paymsgid");
      if (com.tencent.mm.plugin.luckymoney.app.a.fWk().fWp().aKz((String)localObject2))
      {
        Log.i("MicroMsg.LuckyMoneyNewYearSendUIV2", "sendLocalMsg() for hb! mMsgXml:%s", new Object[] { this.Kwb });
        ah.an(this.Kwb, this.KEN, 3);
        if (paramInt1 == 0) {
          finish();
        }
        this.KES = new hv();
        if (this.KEU != 1) {
          break label583;
        }
        this.KES.iPe = 8L;
        label483:
        this.KES.bMH();
        aae(1);
      }
      for (;;)
      {
        localObject2 = com.tencent.mm.model.z.bAM();
        if (paramInt2 != -1) {
          break label658;
        }
        Log.i("MicroMsg.LuckyMoneyNewYearSendUIV2", "onActivityResult() resultCode == RESULT_OK");
        this.hXQ = 1;
        this.KFg = "";
        paramIntent = new ay(this.KqM, this.KFd, 1, (String)localObject2, Util.nullAsNil(this.KEN));
        com.tencent.mm.kernel.h.baD().mCm.a(paramIntent, 0);
        AppMethodBeat.o(284412);
        return;
        Log.e("MicroMsg.LuckyMoneyNewYearSendUIV2", "it is a duplicate msg");
        break;
        label583:
        if (this.KEU == 2)
        {
          this.KES.iPe = 6L;
          break label483;
        }
        if (this.KEU == 3)
        {
          this.KES.iPe = 7L;
          break label483;
        }
        if (this.KEU != 4) {
          break label483;
        }
        this.KES.iPe = 14L;
        break label483;
        Log.i("MicroMsg.LuckyMoneyNewYearSendUIV2", "do pay cancel or failed!");
      }
      label658:
      if (paramIntent != null) {}
      for (this.hXQ = paramIntent.getIntExtra("key_pay_reslut_type", 3);; this.hXQ = 3)
      {
        this.KFg = this.KqM;
        Log.i("MicroMsg.LuckyMoneyNewYearSendUIV2", "onActivityResult() resultCode != RESULT_OK  payType:%s", new Object[] { Integer.valueOf(this.hXQ) });
        paramIntent = new ay(this.KqM, this.KFd, this.hXQ, (String)localObject2, Util.nullAsNil(this.KEN));
        break;
        Log.i("MicroMsg.LuckyMoneyNewYearSendUIV2", "doNetSceneLuckyMoneyReport() data == null");
      }
      if (paramInt2 == -1)
      {
        if (paramIntent != null) {
          this.KFb = paramIntent.getLongExtra("key_enter_time", 0L);
        }
        if (!Util.isEqual(this.KFb, 0L))
        {
          aad(3);
          yg(false);
          paramIntent = com.tencent.mm.emoji.e.b.mnS;
          com.tencent.mm.emoji.e.b.a(this.KFb, this.KFf);
          AppMethodBeat.o(284412);
          return;
        }
        Log.i("MicroMsg.LuckyMoneyNewYearSendUIV2", "mTimeEnter == 0L go emoji capture failed!");
        AppMethodBeat.o(284412);
        return;
      }
      Log.i("MicroMsg.LuckyMoneyNewYearSendUIV2", "go emoji capture failed!");
      AppMethodBeat.o(284412);
      return;
      if ((paramIntent == null) || (!paramIntent.hasExtra("result_data"))) {
        break;
      }
      paramIntent = paramIntent.getBundleExtra("result_data");
      if (paramIntent != null)
      {
        paramInt1 = Util.getInt(paramIntent.getString("payState", "2"), 0);
        Log.e("MicroMsg.LuckyMoneyNewYearSendUIV2", "onActivityResult REQUEST_CODE_H5_PAY payState is ".concat(String.valueOf(paramInt1)));
        if (paramInt1 == 0)
        {
          com.tencent.mm.plugin.report.service.h.OAn.b(11701, new Object[] { Integer.valueOf(15), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2) });
          finish();
        }
        AppMethodBeat.o(284412);
        return;
      }
      Log.e("MicroMsg.LuckyMoneyNewYearSendUIV2", "onActivityResult REQUEST_CODE_H5_PAY bundle is null");
      break;
      label983:
      paramInt1 = 0;
    }
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(284394);
    aae(2);
    finish();
    AppMethodBeat.o(284394);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(284379);
    super.onCreate(paramBundle);
    Log.i("MicroMsg.LuckyMoneyNewYearSendUIV2", "lucky send ui create");
    this.KEN = getIntent().getStringExtra("key_username");
    this.Krb = getIntent().getIntExtra("key_way", 0);
    this.mChannel = getIntent().getIntExtra("pay_channel", -1);
    if (Util.isNullOrNil(this.KEN))
    {
      Log.w("MicroMsg.LuckyMoneyNewYearSendUIV2", "name null finish");
      finish();
    }
    this.KFc = ah.fXj();
    initView();
    if (this.KFc) {
      doSceneProgress(new com.tencent.mm.plugin.luckymoney.model.a.f());
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.OAn.b(13079, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
      AppMethodBeat.o(284379);
      return;
      doSceneProgress(new as(8, "v1.0", ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acVd, Integer.valueOf(0))).intValue()));
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(284381);
    super.onDestroy();
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    if (this.uKY != null)
    {
      Log.i("MicroMsg.LuckyMoneyNewYearSendUIV2", "commentfooter release");
      this.uKY.onPause();
      this.uKY.iKg();
      this.uKY.destroy();
    }
    if (this.KEJ != null)
    {
      this.KEJ.pause();
      this.KEJ.stop();
    }
    ac.a(this.KEk, this.KEl, this.KEm);
    ac.a(this.KFn, this.KEl, this.KEm);
    com.tencent.mm.emoji.e.b localb = com.tencent.mm.emoji.e.b.mnS;
    com.tencent.mm.emoji.e.b.b(this.KFb, this.KFf);
    this.KEv.dead();
    AppMethodBeat.o(284381);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, final p paramp)
  {
    AppMethodBeat.i(284403);
    Log.i("MicroMsg.LuckyMoneyNewYearSendUIV2", "onSceneEnd() errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " netsceneType:" + paramp.getType());
    if ((paramp instanceof as))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (as)paramp;
        this.Kup = paramString.Kup;
        this.Kun = paramString.Kun;
        this.KEP = paramString.Kuv;
        this.Kuw = paramString.Kuw;
        this.KFd = paramString.hTs;
        this.Kuz = paramString.Kuz;
        this.KuA = paramString.KuA;
        this.KuB = paramString.KuB;
        Log.i("MicroMsg.LuckyMoneyNewYearSendUIV2", "enableSelfIe is %s", new Object[] { Integer.valueOf(this.KEP) });
        fYB();
        updateView();
        fYD();
        setContentViewVisibility(0);
        ah.a(this.KEA, null);
        AppMethodBeat.o(284403);
        return true;
      }
      finish();
    }
    do
    {
      for (;;)
      {
        AppMethodBeat.o(284403);
        return false;
        if ((paramp instanceof com.tencent.mm.plugin.luckymoney.model.a.f))
        {
          if ((paramInt1 == 0) && (paramInt2 == 0))
          {
            paramString = (com.tencent.mm.plugin.luckymoney.model.a.f)paramp;
            if (paramString.Kvq == 1)
            {
              this.Kup = paramString.Kup;
              this.Kun = paramString.Kun;
              this.Kuz = paramString.Kuz;
              fYB();
              fYD();
              updateView();
              setContentViewVisibility(0);
              ah.a(this.KEA, null);
              AppMethodBeat.o(284403);
              return true;
            }
            Log.e("MicroMsg.LuckyMoneyNewYearSendUIV2", "hk sceneSwitch is %d", new Object[] { Integer.valueOf(paramString.Kvq) });
            finish();
          }
          else
          {
            finish();
          }
        }
        else if ((paramp instanceof au))
        {
          if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
            this.tipDialog.dismiss();
          }
          if ((paramInt1 == 0) && (paramInt2 == 0))
          {
            paramString = ((au)paramp).wZd;
            if (!Util.isNullOrNil(paramString))
            {
              Log.i("MicroMsg.LuckyMoneyNewYearSendUIV2", "payUrl is not null");
              com.tencent.mm.wallet_core.ui.i.a(getContext(), paramString, false, 5);
            }
            else
            {
              Log.e("MicroMsg.LuckyMoneyNewYearSendUIV2", "payUrl is null");
            }
          }
        }
        else
        {
          if (!(paramp instanceof bc)) {
            break;
          }
          if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
            this.tipDialog.dismiss();
          }
          if ((paramInt1 == 0) && (paramInt2 == 0))
          {
            Log.i("MicroMsg.LuckyMoneyNewYearSendUIV2", "send hb success!");
            paramString = (bc)paramp;
            this.Kwb = paramString.KuM;
            paramp = new PayInfo();
            paramp.hAT = paramString.Hgk;
            paramp.hUR = 37;
            paramp.channel = this.mChannel;
            com.tencent.mm.pluginsdk.wallet.f.a(getContext(), paramp, 1);
            AppMethodBeat.o(284403);
            return true;
          }
          Log.e("MicroMsg.LuckyMoneyNewYearSendUIV2", "send hb failed!");
        }
      }
      if ((paramp instanceof be))
      {
        if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
          this.tipDialog.dismiss();
        }
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          Log.i("MicroMsg.LuckyMoneyNewYearSendUIV2", "send hb success!");
          paramString = (be)paramp;
          this.Kwb = paramString.KuM;
          this.KqM = paramString.CAf;
          if (paramString.isJumpRemind())
          {
            Log.i("MicroMsg.LuckyMoneyNewYearSendUIV2", "onSceneEnd() NetScenePrepareNewYearLuckyMoney show JumpRemind Alert");
            paramString.jumpRemind.a(this, new com.tencent.mm.wallet_core.model.h()
            {
              public final void cm(int paramAnonymousInt, String paramAnonymousString)
              {
                AppMethodBeat.i(284136);
                Log.i("MicroMsg.LuckyMoneyNewYearSendUIV2", "onSceneEnd() scene:NetScenePrepareNewYearLuckyMoney JumpRemind:onNext()");
                if ((Util.isEqual(paramAnonymousInt, 2)) && (Util.isEqual(paramAnonymousString, "requestwxhb")))
                {
                  LuckyMoneyNewYearSendUIV2.Y(LuckyMoneyNewYearSendUIV2.this);
                  AppMethodBeat.o(284136);
                  return;
                }
                if (Util.isEqual(paramAnonymousInt, 1)) {
                  com.tencent.mm.plugin.account.sdk.c.a.b(LuckyMoneyNewYearSendUIV2.this.getContext(), paramAnonymousString, 0, true);
                }
                AppMethodBeat.o(284136);
              }
              
              public final void onCancel()
              {
                AppMethodBeat.i(284138);
                Log.i("MicroMsg.LuckyMoneyNewYearSendUIV2", "onSceneEnd() scene:NetScenePrepareNewYearLuckyMoney JumpRemind:onCancel()");
                AppMethodBeat.o(284138);
              }
            });
            AppMethodBeat.o(284403);
            return true;
          }
          paramp = new PayInfo();
          paramp.hAT = paramString.Hgk;
          paramp.hUR = 37;
          paramp.channel = this.mChannel;
          com.tencent.mm.pluginsdk.wallet.f.a(getContext(), paramp, 1);
          AppMethodBeat.o(284403);
          return true;
        }
        if (paramInt2 == 268502454)
        {
          k.d(this, paramString, "", new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(284132);
              if (bc.l(paramp))
              {
                LuckyMoneyNewYearSendUIV2.this.finish();
                AppMethodBeat.o(284132);
                return;
              }
              AppMethodBeat.o(284132);
            }
          });
          AppMethodBeat.o(284403);
          return true;
        }
        Log.e("MicroMsg.LuckyMoneyNewYearSendUIV2", "send hb failed!");
        this.hXQ = 2;
        paramp = paramString;
        if (TextUtils.isEmpty(paramString)) {
          paramp = getString(a.i.wallet_unknown_err);
        }
        setContentViewVisibility(4);
        k.a(this, paramp, null, false, new LuckyMoneyNewYearSendUIV2.6(this, this));
        AppMethodBeat.o(284403);
        return true;
      }
    } while (!(paramp instanceof ay));
    AppMethodBeat.o(284403);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearSendUIV2
 * JD-Core Version:    0.7.0.1
 */