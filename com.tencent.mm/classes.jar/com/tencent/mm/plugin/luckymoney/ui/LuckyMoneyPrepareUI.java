package com.tencent.mm.plugin.luckymoney.ui;

import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.ad.a;
import com.tencent.mm.api.t;
import com.tencent.mm.autogen.a.rt;
import com.tencent.mm.autogen.a.xm;
import com.tencent.mm.autogen.mmdata.rpt.lv;
import com.tencent.mm.autogen.mmdata.rpt.lw;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.model.ab;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.luckymoney.model.aj;
import com.tencent.mm.plugin.luckymoney.model.ao;
import com.tencent.mm.plugin.luckymoney.model.ap;
import com.tencent.mm.plugin.luckymoney.model.as;
import com.tencent.mm.plugin.luckymoney.model.at;
import com.tencent.mm.plugin.luckymoney.model.au;
import com.tencent.mm.plugin.luckymoney.model.ay;
import com.tencent.mm.plugin.luckymoney.model.bc;
import com.tencent.mm.plugin.luckymoney.model.bd;
import com.tencent.mm.plugin.luckymoney.model.bh;
import com.tencent.mm.plugin.luckymoney.model.bi;
import com.tencent.mm.plugin.luckymoney.model.o;
import com.tencent.mm.plugin.luckymoney.model.v;
import com.tencent.mm.plugin.luckymoney.model.w;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.utils.j;
import com.tencent.mm.plugin.wallet_core.utils.j.5;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.j;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.chat.e.b;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.aqj;
import com.tencent.mm.protocal.protobuf.csm;
import com.tencent.mm.protocal.protobuf.czi;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ac;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard;
import com.tencent.mm.wallet_core.ui.MMScrollView;
import com.tencent.mm.wallet_core.ui.WcPayBannerView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tenpay.android.wechat.MyKeyboardWindow;
import java.math.RoundingMode;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LuckyMoneyPrepareUI
  extends LuckyMoneyBaseUI
  implements h
{
  private static final String Knp;
  private a KBb;
  private View KBc;
  private ViewGroup KBn;
  private lv KBp;
  private int KBs;
  private int KEU;
  private String KFd;
  private String KFg;
  private int KHA;
  private String KHB;
  private String KHC;
  private RealnameGuideHelper KHD;
  private String KHE;
  private String KHF;
  private String KHG;
  private lw KHH;
  private int KHI;
  private String KHJ;
  private String KHK;
  private boolean KHL;
  private boolean KHM;
  private boolean KHN;
  private boolean KHO;
  private boolean KHP;
  private int KHQ;
  private String KHR;
  private int KHS;
  private long KHT;
  private long KHU;
  private String KHV;
  private com.tencent.mm.ui.widget.f KHW;
  private boolean KHX;
  private boolean KHY;
  private boolean KHZ;
  private Dialog KHi;
  private Dialog KHj;
  private RelativeLayout KHk;
  private TextView KHl;
  private TextView KHm;
  private ImageView KHn;
  private ImageView KHo;
  private ImageView KHp;
  private TextView KHq;
  private ViewGroup KHr;
  private TextView KHs;
  private ViewGroup KHt;
  private TextView KHu;
  private ImageView KHv;
  private TextView KHw;
  private ViewGroup KHx;
  private WeImageView KHy;
  private TextView KHz;
  private boolean KIa;
  private IListener<xm> KIb;
  private o KmF;
  private LuckyMoneyNumInputView Knq;
  private LuckyMoneyTextInputView Kns;
  private Button Knt;
  private MMScrollView Knw;
  private TextView Knx;
  private c Knz;
  private String KqM;
  private com.tencent.mm.plugin.luckymoney.model.i KrK;
  private int Krb;
  private int Kux;
  private LuckyMoneyMoneyInputView KvU;
  private View KvV;
  private View KvW;
  private ViewGroup KvX;
  private String KvY;
  private int KvZ;
  private boolean Kwa;
  private String Kwb;
  private int hXQ;
  private int lCR;
  private int mChannel;
  protected View mKBLayout;
  protected MyKeyboardWindow mKeyboard;
  private boolean mKindaEnable;
  private IListener<rt> mPayLoopInterruptListener;
  private String mSessionId;
  private int mType;
  private WcPayKeyboard mWcKeyboard;
  private WcPayBannerView pLM;
  private MTimerHandler qaM;
  private TextView tHK;
  public Dialog tipDialog;
  private ChatFooterPanel uKY;
  private EmojiInfo xRp;
  private Button xXJ;
  private TextView xcT;
  
  static
  {
    AppMethodBeat.i(284505);
    Knp = "https://" + WeChatHosts.domainString(a.i.host_kf_qq_com) + "/touch/scene_product.html?scene_id=kf7";
    AppMethodBeat.o(284505);
  }
  
  public LuckyMoneyPrepareUI()
  {
    AppMethodBeat.i(65882);
    this.Knq = null;
    this.KvU = null;
    this.Kns = null;
    this.xcT = null;
    this.Knt = null;
    this.xXJ = null;
    this.tipDialog = null;
    this.KHi = null;
    this.KHj = null;
    this.Knz = new c();
    this.qaM = null;
    this.KHA = 1;
    this.KHB = com.tencent.mm.wallet_core.ui.i.bEL("CNY");
    this.KHC = null;
    this.KqM = "";
    this.KEU = 1;
    this.KBs = 0;
    this.KHL = false;
    this.KHN = false;
    this.KHO = false;
    this.KHP = false;
    this.mPayLoopInterruptListener = new IListener(com.tencent.mm.app.f.hfK) {};
    this.KHX = false;
    this.KHY = false;
    this.KHZ = false;
    this.KIa = false;
    this.KIb = new IListener(com.tencent.mm.app.f.hfK) {};
    this.hXQ = 0;
    this.KFg = "";
    AppMethodBeat.o(65882);
  }
  
  private void C(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(65897);
    this.Kns.C(paramEmojiInfo);
    if ((this.KBs == 0) || (this.KBs == 2)) {
      if (com.tencent.mm.plugin.emoji.g.d.z(paramEmojiInfo)) {
        this.KEU = 2;
      }
    }
    for (;;)
    {
      this.KBp = new lv();
      this.KBp.iPe = 1L;
      this.KBp.bMH();
      AppMethodBeat.o(65897);
      return;
      if (com.tencent.mm.plugin.emoji.g.d.x(paramEmojiInfo))
      {
        this.KEU = 4;
      }
      else
      {
        this.KEU = 3;
        continue;
        if (this.KBs == 1) {
          this.KEU = 2;
        }
      }
    }
  }
  
  private static void a(int paramInt, double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(284365);
    if (paramBoolean)
    {
      Log.i("MicroMsg.LuckyMoneyPrepareUI", "has showing error tips, ignore repeat report");
      AppMethodBeat.o(284365);
      return;
    }
    int i = (int)paramDouble * 100;
    Log.i("MicroMsg.LuckyMoneyPrepareUI", "report scene = " + paramInt + " amount =" + i);
    com.tencent.mm.plugin.report.service.h.OAn.b(22775, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    AppMethodBeat.o(284365);
  }
  
  private void a(int paramInt1, String paramString1, int paramInt2, long paramLong1, long paramLong2, String paramString2)
  {
    AppMethodBeat.i(284349);
    String str2 = "";
    int i = 0;
    if (this.xRp != null)
    {
      str2 = this.xRp.getMd5();
      i = this.xRp.field_type;
    }
    String str1 = "";
    if (this.KrK != null) {
      str1 = this.KrK.Krn;
    }
    Log.i("MicroMsg.LuckyMoneyPrepareUI", "currency is RMB. userConfirmJump:%s lastPayResult:%s mSendId:%s mUniqueId:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(this.hXQ), this.KqM, this.KFd });
    if (com.tencent.mm.plugin.luckymoney.model.ah.IH(getIntent().getStringExtra("key_username")))
    {
      Log.i("MicroMsg.LuckyMoneyPrepareUI", "doRMBPrePareBtnClick use rtx luckmoney");
      if ((this.Kwa) && (!Util.isNullOrNil(paramString1))) {}
      for (paramString1 = new bd(paramInt2, paramLong1, paramLong2, this.mType, paramString2, com.tencent.mm.plugin.luckymoney.model.ah.fXi(), paramString1, com.tencent.mm.plugin.luckymoney.model.ah.ID(paramString1), com.tencent.mm.model.z.bAM(), com.tencent.mm.model.z.bAO(), this.Krb, str1, this.KFd, paramInt1, this.hXQ, this.KqM, str2, i);; paramString1 = new bd(paramInt2, paramLong1, paramLong2, this.mType, paramString2, com.tencent.mm.plugin.luckymoney.model.ah.fXi(), null, null, com.tencent.mm.model.z.bAM(), com.tencent.mm.model.z.bAO(), this.Krb, str1, this.KFd, paramInt1, this.hXQ, this.KqM, str2, i))
      {
        doSceneProgress(paramString1, false);
        if (!Util.isNullOrNil(str1)) {
          com.tencent.mm.plugin.report.service.h.OAn.kJ(991, 11);
        }
        fYT();
        AppMethodBeat.o(284349);
        return;
      }
    }
    if (this.lCR == 3)
    {
      String str3 = getIntent().getStringExtra("key_live_id");
      String str4 = getIntent().getStringExtra("key_live_attach");
      int j = getIntent().getIntExtra("key_live_anchor_type", 0);
      paramString1 = new com.tencent.mm.plugin.luckymoney.model.a.c(paramInt2, paramLong1, paramLong2, this.mType, paramString2, com.tencent.mm.plugin.luckymoney.model.ah.fXi(), com.tencent.mm.plugin.luckymoney.model.ah.ID(paramString1), com.tencent.mm.model.z.bAM(), com.tencent.mm.model.z.bAO(), this.Krb, str1, this.KFd, paramInt1, this.hXQ, this.KqM, str2, i, this.KHG, str3, str4, j);
    }
    for (;;)
    {
      doSceneProgress(paramString1, false);
      break;
      Log.i("MicroMsg.LuckyMoneyPrepareUI", "doRMBPrePareBtnClick use normal luckmoney");
      if ((this.Kwa) && (!Util.isNullOrNil(paramString1))) {
        paramString1 = new bc(paramInt2, paramLong1, paramLong2, this.mType, paramString2, com.tencent.mm.plugin.luckymoney.model.ah.fXi(), paramString1, com.tencent.mm.plugin.luckymoney.model.ah.ID(paramString1), com.tencent.mm.model.z.bAM(), com.tencent.mm.model.z.bAO(), this.Krb, str1, this.KFd, paramInt1, this.hXQ, this.KqM, str2, i, this.KHG);
      } else {
        paramString1 = new bc(paramInt2, paramLong1, paramLong2, this.mType, paramString2, com.tencent.mm.plugin.luckymoney.model.ah.fXi(), null, null, com.tencent.mm.model.z.bAM(), com.tencent.mm.model.z.bAO(), this.Krb, str1, this.KFd, paramInt1, this.hXQ, this.KqM, str2, i, this.KHG);
      }
    }
  }
  
  private void a(final EditText paramEditText, final WcPayKeyboard paramWcPayKeyboard, final boolean paramBoolean)
  {
    AppMethodBeat.i(284372);
    if ((paramWcPayKeyboard == null) || (paramEditText == null))
    {
      AppMethodBeat.o(284372);
      return;
    }
    final View.OnFocusChangeListener localOnFocusChangeListener = paramEditText.getOnFocusChangeListener();
    com.tencent.mm.wallet_core.ui.i.setNoSystemInputOnEditText(paramEditText);
    paramEditText.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      private boolean firstTime = true;
      
      public void onFocusChange(final View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(284142);
        Log.d("MicroMsg.LuckyMoneyPrepareUI", "onFocusChange: %s %s", new Object[] { paramAnonymousView, Boolean.valueOf(paramAnonymousBoolean) });
        if (paramAnonymousBoolean)
        {
          ((InputMethodManager)LuckyMoneyPrepareUI.this.getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramAnonymousView.getWindowToken(), 0);
          new MMHandler().postDelayed(new Runnable()
          {
            public void run()
            {
              AppMethodBeat.i(65867);
              WcPayKeyboard localWcPayKeyboard = LuckyMoneyPrepareUI.41.this.KIm;
              if (localWcPayKeyboard.agRN != null) {
                localWcPayKeyboard.agRN.end();
              }
              if (localWcPayKeyboard.Jvf != null) {
                localWcPayKeyboard.Jvf.end();
              }
              if ((!LuckyMoneyPrepareUI.41.this.KIm.isShown()) && (paramAnonymousView.isShown()))
              {
                LuckyMoneyPrepareUI.41.this.KIm.setIsOnlySupportInteger(LuckyMoneyPrepareUI.41.this.KIn);
                LuckyMoneyPrepareUI.41.this.KIm.showNormalStWcKb();
              }
              LuckyMoneyPrepareUI.41.this.KIm.setInputEditText(LuckyMoneyPrepareUI.41.this.val$editText);
              ((InputMethodManager)LuckyMoneyPrepareUI.this.getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramAnonymousView.getWindowToken(), 0);
              AppMethodBeat.o(65867);
            }
          }, 300L);
        }
        for (;;)
        {
          if (localOnFocusChangeListener != null) {
            localOnFocusChangeListener.onFocusChange(paramAnonymousView, paramAnonymousBoolean);
          }
          AppMethodBeat.o(284142);
          return;
          new MMHandler().postDelayed(new Runnable()
          {
            public void run()
            {
              AppMethodBeat.i(284413);
              LuckyMoneyPrepareUI.41.this.KIm.hideWcKb();
              AppMethodBeat.o(284413);
            }
          }, 200L);
        }
      }
    });
    com.tencent.mm.compatible.util.d.rb(28);
    paramEditText.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(284143);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$43", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        paramWcPayKeyboard.setIsOnlySupportInteger(paramBoolean);
        paramWcPayKeyboard.showNormalStWcKb();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$43", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(284143);
      }
    });
    AppMethodBeat.o(284372);
  }
  
  private void aKP(String paramString)
  {
    AppMethodBeat.i(65911);
    Log.i("MicroMsg.LuckyMoneyPrepareUI", "do business callback");
    if (com.tencent.mm.plugin.luckymoney.model.ah.IH(getIntent().getStringExtra("key_username")))
    {
      doSceneProgress(new ap(this.KqM, paramString, this.KHE), false);
      AppMethodBeat.o(65911);
      return;
    }
    doSceneProgress(new ao(this.KqM, paramString, this.KHE), false);
    AppMethodBeat.o(65911);
  }
  
  private void aai(int paramInt)
  {
    AppMethodBeat.i(284330);
    Log.i("MicroMsg.LuckyMoneyPrepareUI", "update view by mode: %s, %s", new Object[] { Integer.valueOf(this.mType), Integer.valueOf(paramInt) });
    if (paramInt == this.mType)
    {
      AppMethodBeat.o(284330);
      return;
    }
    if (this.mType == 0)
    {
      this.KHs.setText(a.i.lucky_money_mode_normal_text);
      this.KHt.setVisibility(8);
      this.Knq.setVisibility(0);
      this.KHu.setVisibility(0);
      this.tHK.setVisibility(8);
      this.Knz.fYr();
      this.Knz.a(this.Knq);
      this.Knz.a(this.KvU);
      this.Knz.a(this.Kns);
      paramInt = this.Knq.getInput();
      d = this.KvU.getInput();
      this.KvU.setType(this.mType);
      this.KvU.setShowGroupIcon(false);
      this.KvU.setTitle(getString(a.i.lucky_money_unit_amount_title));
      if ((d > 0.0D) && (paramInt > 0)) {
        this.KvU.setAmount(com.tencent.mm.wallet_core.ui.i.formatMoney2f(d / paramInt));
      }
      this.KvU.setMaxAmount(this.KmF.Kmc);
    }
    do
    {
      for (;;)
      {
        fWx();
        AppMethodBeat.o(284330);
        return;
        if (this.mType != 1) {
          break;
        }
        this.KHs.setText(a.i.lucky_money_mode_lucky_text);
        this.KHt.setVisibility(8);
        this.Knq.setVisibility(0);
        this.KHu.setVisibility(0);
        this.tHK.setVisibility(8);
        this.Knz.fYr();
        this.Knz.a(this.Knq);
        this.Knz.a(this.KvU);
        this.Knz.a(this.Kns);
        i = this.Knq.getInput();
        d = this.KvU.getInput();
        this.KvU.setType(this.mType);
        this.KvU.setMaxAmount(this.KmF.Kme);
        this.KvU.setTitle(getString(a.i.lucky_money_total_amount_title));
        this.KvU.setShowGroupIcon(true);
        if ((paramInt == 3) && (d > 0.0D)) {
          this.KvU.setAmount(com.tencent.mm.wallet_core.ui.i.formatMoney2f(d));
        } else if ((d > 0.0D) && (i > 0)) {
          this.KvU.setAmount(com.tencent.mm.wallet_core.ui.i.formatMoney2f(d * i));
        }
      }
    } while (this.mType != 3);
    this.KHs.setText(a.i.lucky_money_mode_exclusive_text);
    this.KHt.setVisibility(0);
    this.Knq.setVisibility(8);
    this.KHu.setVisibility(8);
    this.tHK.setVisibility(8);
    this.Knz.fYr();
    this.Knz.a((d)this.KHt);
    this.Knz.a(this.KvU);
    this.Knz.a(this.Kns);
    int i = this.Knq.getInput();
    double d = this.KvU.getInput();
    this.KvU.setType(this.mType);
    this.KvU.setShowGroupIcon(false);
    this.KvU.setTitle(getString(a.i.lucky_money_total_amount_exclusive_title));
    if ((paramInt == 0) && (d > 0.0D) && (i > 0)) {
      this.KvU.setAmount(com.tencent.mm.wallet_core.ui.i.formatMoney2f(d * i));
    }
    for (;;)
    {
      this.KvU.setMaxAmount(this.KmF.Kmc);
      if (this.KHM) {
        break;
      }
      this.KHt.post(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(284173);
          TextView localTextView = (TextView)LuckyMoneyPrepareUI.this.findViewById(a.f.lucky_money_exclusive_title_tv);
          ImageView localImageView = (ImageView)LuckyMoneyPrepareUI.this.findViewById(a.f.lucky_money_exclusive_arrow_iv);
          int i = localTextView.getRight();
          int j = com.tencent.mm.cd.a.fromDPToPix(LuckyMoneyPrepareUI.this.getContext(), 52);
          i = localImageView.getLeft() - com.tencent.mm.cd.a.fromDPToPix(LuckyMoneyPrepareUI.this.getContext(), 8) - (i + j);
          if (i > 0)
          {
            Log.d("MicroMsg.LuckyMoneyPrepareUI", "usernametv maxwidth: %s", new Object[] { Integer.valueOf(i) });
            LuckyMoneyPrepareUI.t(LuckyMoneyPrepareUI.this).setMaxWidth(i);
          }
          AppMethodBeat.o(284173);
        }
      });
      this.KHM = true;
      break;
      if (d > 0.0D) {
        this.KvU.setAmount(com.tencent.mm.wallet_core.ui.i.formatMoney2f(d));
      }
    }
  }
  
  private void aaj(int paramInt)
  {
    AppMethodBeat.i(284341);
    Log.i("MicroMsg.LuckyMoneyPrepareUI", "doPrePareBtnClick() userConfirmJump:%s", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.plugin.report.service.h.OAn.b(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(fXD()), Integer.valueOf(4) });
    com.tencent.mm.plugin.report.service.h.OAn.b(15511, new Object[] { Integer.valueOf(this.KHA), Integer.valueOf(2) });
    if (this.KvU.fWv() != 0)
    {
      aa.makeText(getContext(), a.i.wallet_balance_save_input_invalid, 0).show();
      AppMethodBeat.o(284341);
      return;
    }
    int i = this.Knq.getInput();
    double d = this.KvU.getInput();
    long l2 = 0L;
    long l1;
    if (this.mType == 1)
    {
      l1 = com.tencent.mm.wallet_core.ui.i.Y(d);
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baE().ban().B(356354, Integer.valueOf(i));
      str = this.Kns.getInput().replace("\r", "").replace("\n", "");
      localObject = str;
      if (Util.isNullOrNil(str)) {
        if (!Util.isNullOrNil(this.KHC)) {
          break label355;
        }
      }
    }
    label355:
    for (Object localObject = getString(a.i.lucky_money_default_wish);; localObject = this.KHC)
    {
      hideTenpayKB();
      if (this.lCR != 2) {
        break label364;
      }
      doSceneProgress(new com.tencent.mm.plugin.luckymoney.f2f.a.d(i, (int)l1, this.mType, (int)l2), false);
      fYT();
      AppMethodBeat.o(284341);
      return;
      if (this.mType == 3)
      {
        l1 = com.tencent.mm.wallet_core.ui.i.Y(d);
        break;
      }
      l1 = com.tencent.mm.wallet_core.ui.i.Y(i * d);
      l2 = com.tencent.mm.wallet_core.ui.i.Y(d);
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baE().ban().B(356353, Integer.valueOf(i));
      break;
    }
    label364:
    String str = getIntent().getStringExtra("key_username");
    if (this.KHA == 1)
    {
      Log.i("MicroMsg.LuckyMoneyPrepareUI", "doPrePareBtnClick() ifGetConfig=%s mUniqueId=%s waitingGetConfig=%s ifAutoRMBPrePareBtn=%s", new Object[] { Boolean.valueOf(this.KHX), Util.nullAsNil(this.KFd), Boolean.valueOf(this.KHY), Boolean.valueOf(this.KHZ) });
      if (this.KHX)
      {
        a(paramInt, str, i, l1, l2, (String)localObject);
        AppMethodBeat.o(284341);
        return;
      }
      this.KHZ = true;
      this.KHQ = paramInt;
      this.KHR = str;
      this.KHS = i;
      this.KHT = l1;
      this.KHU = l2;
      this.KHV = ((String)localObject);
      if (this.KHj != null) {
        this.KHj.show();
      }
      for (;;)
      {
        if (!this.KHY) {
          yi(false);
        }
        AppMethodBeat.o(284341);
        return;
        this.KHj = com.tencent.mm.ui.base.k.a(this, 3, a.j.LuckyMoneyNoAnimDialog, getString(a.i.loading_tips), true, new DialogInterface.OnCancelListener()
        {
          public void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(65830);
            Log.i("MicroMsg.LuckyMoneyPrepareUI", "coperationTipDialogNoTransparent onCancel()");
            LuckyMoneyPrepareUI.u(LuckyMoneyPrepareUI.this);
            LuckyMoneyPrepareUI.v(LuckyMoneyPrepareUI.this);
            if ((LuckyMoneyPrepareUI.w(LuckyMoneyPrepareUI.this) != null) && (LuckyMoneyPrepareUI.w(LuckyMoneyPrepareUI.this).isShowing())) {
              LuckyMoneyPrepareUI.w(LuckyMoneyPrepareUI.this).dismiss();
            }
            if ((LuckyMoneyPrepareUI.x(LuckyMoneyPrepareUI.this).getVisibility() == 8) || (LuckyMoneyPrepareUI.y(LuckyMoneyPrepareUI.this).getVisibility() == 4))
            {
              Log.i("MicroMsg.LuckyMoneyPrepareUI", "usr cancel, & visibility not visiable, so finish");
              LuckyMoneyPrepareUI.this.finish();
            }
            LuckyMoneyPrepareUI.this.KzD.forceCancel();
            AppMethodBeat.o(65830);
          }
        });
      }
    }
    Log.i("MicroMsg.LuckyMoneyPrepareUI", "currency=%s userConfiremJump:%s", new Object[] { Integer.valueOf(this.KHA), Integer.valueOf(paramInt) });
    addSceneEndListener(1647);
    if ((this.Kwa) && (!Util.isNullOrNil(str))) {}
    for (localObject = new au(i, l1, l2, this.mType, (String)localObject, str, com.tencent.mm.plugin.luckymoney.model.ah.fXi(), com.tencent.mm.model.z.bAM(), this.KHA);; localObject = new au(i, l1, l2, this.mType, (String)localObject, null, com.tencent.mm.plugin.luckymoney.model.ah.fXi(), com.tencent.mm.model.z.bAM(), this.KHA))
    {
      doSceneProgress((com.tencent.mm.am.p)localObject, false);
      break;
    }
  }
  
  private void c(double paramDouble, String paramString)
  {
    AppMethodBeat.i(65908);
    if (Util.isNullOrNil(paramString))
    {
      this.xcT.setText(com.tencent.mm.wallet_core.ui.i.X(paramDouble));
      AppMethodBeat.o(65908);
      return;
    }
    this.xcT.setText(paramString + com.tencent.mm.wallet_core.ui.i.formatMoney2f(paramDouble));
    AppMethodBeat.o(65908);
  }
  
  private void c(czi paramczi)
  {
    AppMethodBeat.i(65892);
    Log.i("MicroMsg.LuckyMoneyPrepareUI", "update envelope");
    if ((this.KrK != null) && (paramczi != null) && (this.lCR != 2))
    {
      this.KHk.setVisibility(0);
      Object localObject = com.tencent.mm.plugin.wxpayreport.k.XJk;
      com.tencent.mm.plugin.wxpayreport.k.a(this.KHk, 0, 200L, com.tencent.mm.plugin.wxpayreport.a.c.a.XJD.name(), this, true, getResources().getColor(a.c.lucky_money_graystyle_bg), Integer.valueOf(0));
      boolean bool = com.tencent.mm.aa.c.aYo().a(at.a.acVa, at.a.acVc);
      if (!this.KHL)
      {
        localObject = com.tencent.mm.plugin.report.service.h.OAn;
        if (!bool) {
          break label273;
        }
      }
      label273:
      for (int i = 2;; i = 1)
      {
        ((com.tencent.mm.plugin.report.service.h)localObject).b(18890, new Object[] { Integer.valueOf(1), Integer.valueOf(i), this.mSessionId });
        this.KHL = true;
        if ((!this.KrK.Kro) || (Util.isNullOrNil(this.KrK.Krp))) {
          break label375;
        }
        localObject = Util.stringToList((String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acVf, ""), ",");
        Iterator localIterator = ((List)localObject).iterator();
        String str;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          str = (String)localIterator.next();
        } while (!str.equals(this.KrK.Krm.ZoK));
        Log.d("MicroMsg.LuckyMoneyPrepareUI", "has alert illegal: %s", new Object[] { str });
        AppMethodBeat.o(65892);
        return;
      }
      ((List)localObject).add(this.KrK.Krm.ZoK);
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acVf, Util.listToString((List)localObject, ","));
      Log.i("MicroMsg.LuckyMoneyPrepareUI", "show alert illegal: %s", new Object[] { this.KrK.Krm.ZoK });
      com.tencent.mm.ui.base.k.a(getContext(), this.KrK.Krp, "", getString(a.i.welcome_i_know), new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      label375:
      if ((paramczi == null) || (paramczi.aaEE != 1)) {
        break label506;
      }
      this.KHk.setEnabled(false);
      if (!Util.isNullOrNil(paramczi.aaEF)) {
        this.KHl.setText(paramczi.aaEF);
      }
      this.KHn.setImageBitmap(null);
      this.KHo.setVisibility(8);
      this.KHl.setTextColor(getResources().getColor(a.c.BW_0_Alpha_0_3));
      label450:
      if ((paramczi == null) || (paramczi.nQJ != 2)) {
        break label640;
      }
      this.KHm.setVisibility(0);
    }
    for (;;)
    {
      com.tencent.threadpool.h.ahAA.bk(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(284184);
          int i = LuckyMoneyPrepareUI.G(LuckyMoneyPrepareUI.this).getWidth();
          TextView localTextView = (TextView)LuckyMoneyPrepareUI.this.findViewById(a.f.lucky_money_envelope_title_tv);
          if (localTextView == null)
          {
            AppMethodBeat.o(284184);
            return;
          }
          i = i - localTextView.getWidth() - com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 66);
          if (i > 0) {
            LuckyMoneyPrepareUI.H(LuckyMoneyPrepareUI.this).setMaxWidth(i);
          }
          AppMethodBeat.o(284184);
        }
      });
      AppMethodBeat.o(65892);
      return;
      this.KHk.setVisibility(8);
      break;
      label506:
      if ((paramczi != null) && (!Util.isNullOrNil(paramczi.aaEp)))
      {
        this.KHk.setEnabled(true);
        this.KHl.setText(paramczi.aaEp);
        ((com.tencent.mm.plugin.luckymoney.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.luckymoney.a.a.class)).a(this.KHn, paramczi);
        this.KHo.setVisibility(0);
        this.KHl.setTextColor(getResources().getColor(a.c.black_per90));
        break label450;
      }
      this.KHk.setEnabled(true);
      this.KHn.setImageBitmap(null);
      this.KHl.setText("");
      this.KHo.setVisibility(0);
      this.KHl.setTextColor(getResources().getColor(a.c.black_per90));
      break label450;
      label640:
      this.KHm.setVisibility(8);
    }
  }
  
  private int fXD()
  {
    AppMethodBeat.i(65909);
    if (this.Kwa)
    {
      if (getIntent().getIntExtra("key_chatroom_num", 0) > 0)
      {
        AppMethodBeat.o(65909);
        return 2;
      }
      AppMethodBeat.o(65909);
      return 1;
    }
    AppMethodBeat.o(65909);
    return 3;
  }
  
  private void fYR()
  {
    AppMethodBeat.i(284317);
    if (this.KmF != null)
    {
      if (this.mType == 1) {
        this.KvU.setMaxAmount(this.KmF.Kme);
      }
      for (;;)
      {
        this.KvU.setMinAmount(this.KmF.Kmd);
        String str = this.KmF.Kmg;
        if ((str == null) || (str.length() <= 0)) {
          break;
        }
        this.KvU.setHint(str + getString(a.i.lucky_money_money_hint));
        this.KvU.setCurrencyUnitPrefix(str);
        AppMethodBeat.o(284317);
        return;
        this.KvU.setMaxAmount(this.KmF.Kmc);
      }
      this.KvU.setHint(getString(a.i.lucky_money_money_hint_cn));
      this.KvU.setCurrencyUnitPrefix(getString(a.i.wallet_rmb_symbol));
      AppMethodBeat.o(284317);
      return;
    }
    this.KvU.setHint(getString(a.i.lucky_money_money_hint_cn));
    this.KvU.setCurrencyUnitPrefix(getString(a.i.wallet_rmb_symbol));
    AppMethodBeat.o(284317);
  }
  
  private void fYS()
  {
    AppMethodBeat.i(284324);
    Log.i("MicroMsg.LuckyMoneyPrepareUI", "init custom envelope entrance: %s", new Object[] { Integer.valueOf(((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acUK, Integer.valueOf(0))).intValue()) });
    if ((this.KmF == null) || (this.KmF.KrJ == null) || (this.lCR == 2))
    {
      this.KHx.setVisibility(8);
      AppMethodBeat.o(284324);
      return;
    }
    if (!Util.isNullOrNil(this.KmF.KrJ.wording))
    {
      this.KHz.setText(this.KmF.KrJ.wording);
      int i = com.tencent.mm.cd.a.ms(getContext()) - com.tencent.mm.cd.a.fromDPToPix(getContext(), 70);
      if (i > 0) {
        this.KHz.setMaxWidth(i);
      }
      this.KHx.setVisibility(0);
      this.KHP = true;
      if (!Util.isNullOrNil(this.KmF.KrJ.icon_url))
      {
        Object localObject = new com.tencent.mm.modelimage.loader.a.c.a();
        com.tencent.mm.plugin.luckymoney.app.a.fWk();
        ((com.tencent.mm.modelimage.loader.a.c.a)localObject).prefixPath = com.tencent.mm.plugin.luckymoney.app.a.fWo();
        ((com.tencent.mm.modelimage.loader.a.c.a)localObject).oKH = r.bKf();
        ((com.tencent.mm.modelimage.loader.a.c.a)localObject).oKp = true;
        ((com.tencent.mm.modelimage.loader.a.c.a)localObject).nrc = false;
        ((com.tencent.mm.modelimage.loader.a.c.a)localObject).oKn = true;
        localObject = ((com.tencent.mm.modelimage.loader.a.c.a)localObject).bKx();
        r.bKe().a(this.KmF.KrJ.icon_url, this.KHy, (com.tencent.mm.modelimage.loader.a.c)localObject);
      }
      this.KHx.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
      {
        public final void dr(View paramAnonymousView)
        {
          AppMethodBeat.i(284289);
          Log.i("MicroMsg.LuckyMoneyPrepareUI", "jump to action type: %s", new Object[] { Integer.valueOf(LuckyMoneyPrepareUI.i(LuckyMoneyPrepareUI.this).KrJ.wuj) });
          switch (LuckyMoneyPrepareUI.i(LuckyMoneyPrepareUI.this).KrJ.wuj)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(284289);
            return;
            com.tencent.mm.wallet_core.ui.i.p(LuckyMoneyPrepareUI.this.getContext(), LuckyMoneyPrepareUI.i(LuckyMoneyPrepareUI.this).KrJ.Kru, false);
            AppMethodBeat.o(284289);
            return;
            com.tencent.mm.wallet_core.ui.i.an(LuckyMoneyPrepareUI.this.getContext(), LuckyMoneyPrepareUI.i(LuckyMoneyPrepareUI.this).KrJ.Krv);
            AppMethodBeat.o(284289);
            return;
            com.tencent.mm.wallet_core.ui.i.y(LuckyMoneyPrepareUI.i(LuckyMoneyPrepareUI.this).KrJ.Krv, LuckyMoneyPrepareUI.i(LuckyMoneyPrepareUI.this).KrJ.Kru, 0, 1100);
            AppMethodBeat.o(284289);
            return;
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("finder_username", LuckyMoneyPrepareUI.i(LuckyMoneyPrepareUI.this).KrJ.Krv);
            ((cn)com.tencent.mm.kernel.h.az(cn.class)).enterFinderProfileUI(LuckyMoneyPrepareUI.this.getContext(), paramAnonymousView);
            AppMethodBeat.o(284289);
            return;
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("extra_id", LuckyMoneyPrepareUI.i(LuckyMoneyPrepareUI.this).KrJ.Krv);
            paramAnonymousView.putExtra("preceding_scence", 21);
            com.tencent.mm.br.c.b(LuckyMoneyPrepareUI.this.getContext(), "emoji", ".ui.EmojiStoreDetailUI", paramAnonymousView);
          }
        }
      });
      AppMethodBeat.o(284324);
      return;
    }
    this.KHx.setVisibility(8);
    AppMethodBeat.o(284324);
  }
  
  private void fYT()
  {
    AppMethodBeat.i(284345);
    if (this.tipDialog != null)
    {
      this.tipDialog.show();
      AppMethodBeat.o(284345);
      return;
    }
    this.tipDialog = com.tencent.mm.wallet_core.ui.l.a(getContext(), true, new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(284176);
        if ((LuckyMoneyPrepareUI.z(LuckyMoneyPrepareUI.this) != null) && (LuckyMoneyPrepareUI.z(LuckyMoneyPrepareUI.this).isShowing())) {
          LuckyMoneyPrepareUI.z(LuckyMoneyPrepareUI.this).dismiss();
        }
        if ((LuckyMoneyPrepareUI.A(LuckyMoneyPrepareUI.this).getVisibility() == 8) || (LuckyMoneyPrepareUI.B(LuckyMoneyPrepareUI.this).getVisibility() == 4))
        {
          Log.i("MicroMsg.LuckyMoneyPrepareUI", "usr cancel, & visibility not visiable, so finish");
          LuckyMoneyPrepareUI.this.finish();
        }
        LuckyMoneyPrepareUI.this.KzD.forceCancel();
        AppMethodBeat.o(284176);
      }
    });
    this.tipDialog.setCancelable(false);
    AppMethodBeat.o(284345);
  }
  
  private boolean fYU()
  {
    AppMethodBeat.i(65907);
    if ((this.KmF != null) && (!Util.isNullOrNil(this.KmF.KrF)))
    {
      AppMethodBeat.o(65907);
      return true;
    }
    AppMethodBeat.o(65907);
    return false;
  }
  
  private void init()
  {
    AppMethodBeat.i(65891);
    if (this.KHA == 1) {
      addIconOptionMenu(0, a.i.app_more, a.h.icons_outlined_more, new MenuItem.OnMenuItemClickListener()
      {
        public boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(65832);
          LuckyMoneyPrepareUI.C(LuckyMoneyPrepareUI.this);
          AppMethodBeat.o(65832);
          return true;
        }
      });
    }
    for (;;)
    {
      fYS();
      AppMethodBeat.o(65891);
      return;
      addIconOptionMenu(0, a.i.wallet_index_ui_opt_common_questions, a.e.lucky_money_help_btn, new MenuItem.OnMenuItemClickListener()
      {
        public boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(284181);
          if ((LuckyMoneyPrepareUI.i(LuckyMoneyPrepareUI.this) != null) && (!Util.isNullOrNil(LuckyMoneyPrepareUI.i(LuckyMoneyPrepareUI.this).KrE))) {
            com.tencent.mm.wallet_core.ui.i.p(LuckyMoneyPrepareUI.this.getContext(), LuckyMoneyPrepareUI.i(LuckyMoneyPrepareUI.this).KrE, false);
          }
          for (;;)
          {
            AppMethodBeat.o(284181);
            return true;
            com.tencent.mm.wallet_core.ui.i.p(LuckyMoneyPrepareUI.this.getContext(), "https://hkwallet.moneydata.hk/hybrid/www/weixin/hongbao_hk_v2/zh_hk/faq.shtml", false);
          }
        }
      });
    }
  }
  
  private void k(int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(65899);
    String str1 = getIntent().getStringExtra("key_username");
    String str2 = com.tencent.mm.model.z.bAM();
    if (paramInt == -1)
    {
      Log.i("MicroMsg.LuckyMoneyPrepareUI", "onActivityResult() resultCode == RESULT_OK");
      this.hXQ = 1;
      this.KFg = "";
      paramIntent = new ay(this.KqM, this.KFd, 1, str2, Util.nullAsNil(str1));
      com.tencent.mm.kernel.h.baD().mCm.a(paramIntent, 0);
      AppMethodBeat.o(65899);
      return;
    }
    if (paramIntent != null) {}
    for (this.hXQ = paramIntent.getIntExtra("key_pay_reslut_type", 3);; this.hXQ = 3)
    {
      this.KFg = this.KqM;
      Log.i("MicroMsg.LuckyMoneyPrepareUI", "onActivityResult() resultCode != RESULT_OK  payType:%s", new Object[] { Integer.valueOf(this.hXQ) });
      paramIntent = new ay(this.KqM, this.KFd, this.hXQ, str2, Util.nullAsNil(str1));
      break;
      Log.i("MicroMsg.LuckyMoneyPrepareUI", "doNetSceneLuckyMoneyReport() data == null");
    }
  }
  
  private void yi(boolean paramBoolean)
  {
    AppMethodBeat.i(65894);
    Log.i("MicroMsg.LuckyMoneyPrepareUI", "do get config");
    if (paramBoolean) {
      this.KHi = com.tencent.mm.plugin.luckymoney.model.ah.iN(getContext());
    }
    this.KHY = true;
    if (com.tencent.mm.plugin.luckymoney.model.ah.IH(getIntent().getStringExtra("key_username")))
    {
      i = ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acVd, Integer.valueOf(0))).intValue();
      this.KHI = i;
      doSceneProgress(new at("v1.0", i), false);
      AppMethodBeat.o(65894);
      return;
    }
    if (this.lCR == 3)
    {
      i = ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acVd, Integer.valueOf(0))).intValue();
      this.KHI = i;
      doSceneProgress(new com.tencent.mm.plugin.luckymoney.model.a.a("v1.0", i), false);
      AppMethodBeat.o(65894);
      return;
    }
    int i = ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acVd, Integer.valueOf(0))).intValue();
    this.KHI = i;
    doSceneProgress(new as("v1.0", i), false);
    AppMethodBeat.o(65894);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(65895);
    if ((paramKeyEvent.getKeyCode() == 4) && (this.KvV.getVisibility() == 0))
    {
      this.KvV.setVisibility(8);
      showActionBar();
      AppMethodBeat.o(65895);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(65895);
    return bool;
  }
  
  public final void fWx()
  {
    AppMethodBeat.i(65906);
    double d2 = 0.0D;
    double d3 = 0.0D;
    double d1;
    if (com.tencent.mm.plugin.luckymoney.model.ah.IH(getIntent().getStringExtra("key_username")))
    {
      com.tencent.mm.plugin.luckymoney.app.a.fWk();
      this.KmF = com.tencent.mm.plugin.luckymoney.app.a.fWm().fWW();
      if ((this.mType != 3) || (this.KvU.fWv() == 3)) {
        break label200;
      }
      d1 = this.KvU.getInput();
      if (!Util.isNullOrNil(this.KHG)) {
        break label187;
      }
      d3 = 0.0D;
      d2 = d1;
      d1 = d3;
    }
    for (;;)
    {
      label86:
      boolean bool3 = this.Knz.KDj;
      if (this.Knz.fYs())
      {
        Log.i("MicroMsg.LuckyMoneyPrepareUI", "has error");
        if (this.mType == 3) {
          a(1, d2, bool3);
        }
        for (;;)
        {
          c(d2, this.KHB);
          AppMethodBeat.o(65906);
          return;
          if (this.lCR == 3)
          {
            com.tencent.mm.plugin.luckymoney.app.a.fWk();
            this.KmF = com.tencent.mm.plugin.luckymoney.app.a.fWn().fWW();
            break;
          }
          com.tencent.mm.plugin.luckymoney.app.a.fWk();
          this.KmF = com.tencent.mm.plugin.luckymoney.app.a.fWl().fWW();
          break;
          label187:
          d2 = d1;
          d3 = d1;
          d1 = d2;
          d2 = d3;
          break label86;
          label200:
          d1 = d2;
          if (this.mType == 3) {
            break label1262;
          }
          d1 = d2;
          if (this.KvU.fWv() == 3) {
            break label1262;
          }
          d1 = d2;
          if (this.Knq.fWv() == 3) {
            break label1262;
          }
          int i = this.Knq.getInput();
          d2 = this.KvU.getInput();
          if (this.mType == 0)
          {
            d3 = i;
            d1 = this.KvU.getInput();
            d2 *= d3;
            break label86;
          }
          d1 = d2;
          if (i <= 0) {
            break label1262;
          }
          d1 = com.tencent.mm.wallet_core.ui.i.a(String.valueOf(d2), String.valueOf(i), String.valueOf(this.KmF.Kmb).length() + 2, RoundingMode.HALF_UP);
          break label86;
          if (this.mType == 0) {
            a(1, d1, bool3);
          } else {
            a(2, d2, bool3);
          }
        }
      }
      boolean bool2 = false;
      boolean bool1 = false;
      if ((d2 == 0.0D) || (d1 == 0.0D)) {
        bool1 = true;
      }
      for (;;)
      {
        label370:
        if (!bool1)
        {
          this.Knt.setClickable(true);
          this.Knt.setEnabled(true);
          break;
          if ((d2 > this.KmF.Kme) && (this.KmF.Kme > 0.0D))
          {
            this.Knz.afy(getString(a.i.lucky_money_total_amount_max_limit_tips, new Object[] { Math.round(this.KmF.Kme), Util.nullAs(this.KmF.Kmh, "") }));
            bool1 = true;
            a(2, d2, bool3);
          }
          else if (d1 > 0.0D)
          {
            Log.i("MicroMsg.LuckyMoneyPrepareUI", "perAmount ".concat(String.valueOf(d1)));
            if (this.mType != 0) {
              break label868;
            }
            bool1 = bool2;
            if (d1 > this.KmF.Kmc)
            {
              bool1 = bool2;
              if (this.KmF.Kmc > 0.0D)
              {
                if (!fYU()) {
                  break label805;
                }
                this.Knz.afy(getString(a.i.lucky_money_per_amount_max_limit_tips_format, new Object[] { this.KmF.KrF, Math.round(this.KmF.Kmc), Util.nullAs(this.KmF.Kmh, "") }));
                label629:
                bool1 = true;
                a(1, d1, bool3);
              }
            }
            label639:
            Log.i("MicroMsg.LuckyMoneyPrepareUI", "furtherCheckHasErr:" + bool1 + " for max value");
            bool2 = bool1;
            if (!bool1)
            {
              if (this.mType != 0) {
                break label1130;
              }
              bool2 = bool1;
              if (d1 < this.KmF.Kmd)
              {
                if (!fYU()) {
                  break label1080;
                }
                this.Knz.afy(getString(a.i.lucky_money_per_amount_min_limit_tips_format, new Object[] { this.KmF.KrF, com.tencent.mm.wallet_core.ui.i.formatMoney2f(this.KmF.Kmd), Util.nullAs(this.KmF.Kmh, "") }));
                label765:
                bool2 = true;
              }
            }
          }
        }
      }
      label805:
      label868:
      label1130:
      do
      {
        Log.i("MicroMsg.LuckyMoneyPrepareUI", "furtherCheckHasErr:" + bool2 + " for min value");
        bool1 = bool2;
        break label370;
        break;
        this.Knz.afy(getString(a.i.lucky_money_per_amount_max_limit_tips, new Object[] { Math.round(this.KmF.Kmc), Util.nullAs(this.KmF.Kmh, "") }));
        break label629;
        bool1 = bool2;
        if (d1 <= this.KmF.Kmf) {
          break label639;
        }
        bool1 = bool2;
        if (this.KmF.Kmf <= 0.0D) {
          break label639;
        }
        if ((this.KmF != null) && (!Util.isNullOrNil(this.KmF.KrF))) {
          this.Knz.afy(getString(a.i.lucky_money_per_amount_max_limit_tips_format, new Object[] { this.KmF.KrF, Math.round(this.KmF.Kmf), Util.nullAs(this.KmF.Kmh, "") }));
        }
        for (;;)
        {
          bool1 = true;
          this.Knq.atR();
          this.KvU.atR();
          a(1, d1, bool3);
          break;
          this.Knz.afy(getString(a.i.lucky_money_per_amount_max_limit_tips, new Object[] { Math.round(this.KmF.Kmf), Util.nullAs(this.KmF.Kmh, "") }));
        }
        this.Knz.afy(getString(a.i.lucky_money_per_amount_min_limit_tips, new Object[] { com.tencent.mm.wallet_core.ui.i.formatMoney2f(this.KmF.Kmd), Util.nullAs(this.KmF.Kmh, "") }));
        break label765;
        bool2 = bool1;
      } while (d1 >= 0.01D);
      label1080:
      if (fYU()) {
        this.Knz.afy(getString(a.i.lucky_money_per_amount_min_limit_tips_format, new Object[] { this.KmF.KrF, "0.01", Util.nullAs(this.KmF.Kmh, "") }));
      }
      for (;;)
      {
        bool2 = true;
        this.Knq.atR();
        this.KvU.atR();
        break;
        this.Knz.afy(getString(a.i.lucky_money_per_amount_min_limit_tips, new Object[] { "0.01", Util.nullAs(this.KmF.Kmh, "") }));
      }
      label1262:
      d2 = d1;
      d1 = d3;
    }
  }
  
  public void finish()
  {
    AppMethodBeat.i(65910);
    if (this.KHD != null)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("key_realname_guide_helper", this.KHD);
      com.tencent.mm.br.c.b(this, "wallet_core", ".id_verify.RealnameDialogActivity", localIntent);
    }
    super.finish();
    AppMethodBeat.o(65910);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    AppMethodBeat.i(284560);
    if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zny, 1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.LuckyMoneyPrepareUI", "is open: %s", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        break;
      }
      i = a.g.lucky_money_prepare_ui_2;
      AppMethodBeat.o(284560);
      return i;
    }
    int i = a.g.lucky_money_prepare_ui;
    AppMethodBeat.o(284560);
    return i;
  }
  
  protected final void hideTenpayKB()
  {
    AppMethodBeat.i(65905);
    if ((this.mKBLayout != null) && (this.mKBLayout.isShown())) {
      this.mKBLayout.setVisibility(8);
    }
    AppMethodBeat.o(65905);
  }
  
  public void initView()
  {
    AppMethodBeat.i(65886);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(65838);
        LuckyMoneyPrepareUI.this.finish();
        AppMethodBeat.o(65838);
        return true;
      }
    });
    this.KvV = findViewById(a.f.lucky_money_prepare_ready_ll);
    this.KvW = findViewById(a.f.lucky_money_prepare_sent_area);
    this.xXJ = ((Button)findViewById(a.f.lucky_money_prepare_send_btn));
    this.Kns = ((LuckyMoneyTextInputView)findViewById(a.f.lucky_money_wish_et));
    this.Kns.setHintText(getString(a.i.lucky_money_default_wish));
    Object localObject1 = this.Kns;
    Object localObject2 = new com.tencent.mm.wallet_core.ui.e();
    InputFilter[] arrayOfInputFilter1 = ((LuckyMoneyTextInputView)localObject1).Koc.getFilters();
    InputFilter[] arrayOfInputFilter2 = new InputFilter[arrayOfInputFilter1.length + 1];
    System.arraycopy(arrayOfInputFilter1, 0, arrayOfInputFilter2, 0, arrayOfInputFilter1.length);
    arrayOfInputFilter2[arrayOfInputFilter1.length] = localObject2;
    ((LuckyMoneyTextInputView)localObject1).Koc.setFilters(arrayOfInputFilter2);
    this.Knt = ((Button)findViewById(a.f.lucky_money_prepare_btn));
    this.mKeyboard = ((MyKeyboardWindow)findViewById(a.f.tenpay_num_keyboard));
    this.mKBLayout = findViewById(a.f.tenpay_keyboard_layout);
    this.tHK = ((TextView)findViewById(a.f.lucky_money_prepare_amount_tips));
    this.Knq = ((LuckyMoneyNumInputView)findViewById(a.f.lucky_money_num_et));
    this.KvU = ((LuckyMoneyMoneyInputView)findViewById(a.f.lucky_money_amount_et));
    this.xcT = ((TextView)findViewById(a.f.lucky_money_prepare_total_amount));
    this.KvX = ((ViewGroup)findViewById(a.f.lucky_money_prepare_opertaion));
    this.Knw = ((MMScrollView)findViewById(a.f.lucky_money_sv));
    this.Knx = ((TextView)findViewById(a.f.lucky_money_prepare_notice_tips));
    this.KHk = ((RelativeLayout)findViewById(a.f.lucky_money_envelope_layout));
    this.KHl = ((TextView)findViewById(a.f.lucky_money_envelope_tv));
    this.KHm = ((TextView)findViewById(a.f.lucky_money_envelope_temp_label_tv));
    this.KHn = ((ImageView)findViewById(a.f.lucky_money_envelope_iv));
    this.KHo = ((ImageView)findViewById(a.f.lucky_money_envelope_arrow_iv));
    this.KHp = ((ImageView)findViewById(a.f.lucky_money_envelope_mask_iv));
    this.KHq = ((TextView)findViewById(a.f.lucky_money_envelope_new_tv));
    this.KHr = ((ViewGroup)findViewById(a.f.lucky_money_mode_layout));
    this.KHs = ((TextView)findViewById(a.f.lucky_money_mode_title_tv));
    this.KHt = ((ViewGroup)findViewById(a.f.lucky_money_exclusive_layout));
    this.KHu = ((TextView)findViewById(a.f.lucky_money_prepare_num_tips));
    this.KHv = ((ImageView)findViewById(a.f.lucky_money_exclusive_avatar_iv));
    this.KHw = ((TextView)findViewById(a.f.lucky_money_exclusive_username_tv));
    this.KHx = ((ViewGroup)findViewById(a.f.lucky_money_custom_envelope_entrance_layout));
    this.KHy = ((WeImageView)findViewById(a.f.lucky_money_custom_envelope_entrance_icon_iv));
    this.KHz = ((TextView)findViewById(a.f.lucky_money_custom_envelope_entrance_title_tv));
    this.pLM = ((WcPayBannerView)findViewById(a.f.wc_pay_banner_layout));
    this.pLM.jPz();
    this.KBb = new a(this);
    this.KBc = getLayoutInflater().inflate(a.g.lucky_money_emoji_dialog, null);
    this.KBb.setContentView(this.KBc, new ViewGroup.LayoutParams(-1, -1));
    this.KBc.findViewById(a.f.lucky_money_emoji_dismiss_area).setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
    {
      public final void dr(View paramAnonymousView)
      {
        AppMethodBeat.i(284159);
        LuckyMoneyPrepareUI.a(LuckyMoneyPrepareUI.this);
        AppMethodBeat.o(284159);
      }
    });
    this.KBb.KyS = new a.a()
    {
      public final void fXZ()
      {
        AppMethodBeat.i(65865);
        LuckyMoneyPrepareUI.a(LuckyMoneyPrepareUI.this);
        AppMethodBeat.o(65865);
      }
    };
    this.KBn = ((ViewGroup)this.KBc.findViewById(a.f.lucky_money_emoji_root));
    this.uKY = com.tencent.mm.pluginsdk.ui.chat.e.Ykf.fZ(getContext());
    this.KHF = getIntent().getStringExtra("key_username");
    this.uKY.setTalkerName(this.KHF);
    this.uKY.setShowSmiley(false);
    label736:
    label873:
    int i;
    if (this.mType == 1)
    {
      setMMTitle(a.i.lucky_money_group);
      this.KvU.setTitle(getString(a.i.lucky_money_total_amount_title));
      this.KvU.setShowGroupIcon(true);
      if (!com.tencent.mm.plugin.luckymoney.model.ah.IH(getIntent().getStringExtra("key_username"))) {
        break label1594;
      }
      this.KvU.setRtxLuckyMoney(1);
      localObject1 = new LinearLayout.LayoutParams(-1, -1);
      localObject2 = new LinearLayout.LayoutParams(-1, com.tencent.mm.cd.a.br(this, a.d.lucky_money_input_view_height));
      if (this.mType != 1) {
        break label1624;
      }
      ((LinearLayout.LayoutParams)localObject1).topMargin = com.tencent.mm.cd.a.fromDPToPix(getContext(), 13);
      ((LinearLayout.LayoutParams)localObject2).topMargin = com.tencent.mm.cd.a.fromDPToPix(getContext(), 13);
      label798:
      this.Kns.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      this.KHk.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      this.KvU.setOnInputValidChangerListener(this);
      fYR();
      this.Knq.setOnInputValidChangerListener(this);
      this.Knq.setHint(getString(a.i.lucky_money_num_hint));
      if (!com.tencent.mm.plugin.luckymoney.model.ah.IH(getIntent().getStringExtra("key_username"))) {
        break label1654;
      }
      this.Knq.setRtxLuckyMoney(1);
      this.Kns.setOnInputValidChangerListener(this);
      if (!aw.isDarkMode()) {
        break label1684;
      }
      this.KHp.setImageResource(a.e.lucky_money_prepare_envelope_mask_dark_mode);
      label897:
      if ((!this.Kwa) || (getIntent().getIntExtra("key_chatroom_num", 0) > 1)) {
        break label1697;
      }
      this.Knq.setNum("1");
      label929:
      this.Knq.setMaxNum(this.KmF.Kmb);
      this.Knq.setMinNum(1);
      Log.d("MicroMsg.LuckyMoneyPrepareUI", "init num=" + this.Knq.getInput());
      this.KvU.setMaxLen(12);
      if (fYU()) {
        this.Knt.setText(getString(a.i.lucky_money_prepare_money_format, new Object[] { this.KmF.KrF }));
      }
      if ((!this.Kwa) && (this.lCR != 2) && (this.lCR != 3)) {
        break label1916;
      }
      if (!fYU()) {
        break label1710;
      }
      setMMTitle(getString(a.i.lucky_money_to_send_title_format, new Object[] { this.KmF.KrF }));
      label1079:
      i = getIntent().getIntExtra("key_chatroom_num", 0);
      if ((!this.Kwa) || (i != 0)) {
        break label1720;
      }
      Log.i("MicroMsg.LuckyMoneyPrepareUI", "single hb");
      this.Knq.setVisibility(8);
      this.KHr.setVisibility(8);
      this.KHt.setVisibility(8);
      this.Knz.a(this.KvU);
      label1149:
      this.Knt.setOnClickListener(new ac()
      {
        public final void dsb()
        {
          AppMethodBeat.i(284170);
          LuckyMoneyPrepareUI.a(LuckyMoneyPrepareUI.this, new lv());
          LuckyMoneyPrepareUI.b(LuckyMoneyPrepareUI.this).iPe = 6L;
          LuckyMoneyPrepareUI.b(LuckyMoneyPrepareUI.this).bMH();
          if (!((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.pluginsdk.wallet.a.class)).canOpenKindaCashier(LuckyMoneyPrepareUI.this))
          {
            Log.w("MicroMsg.LuckyMoneyPrepareUI", "can not request hb while authen");
            com.tencent.mm.plugin.report.service.h.OAn.kJ(965, 55);
            AppMethodBeat.o(284170);
            return;
          }
          if (LuckyMoneyPrepareUI.c(LuckyMoneyPrepareUI.this)) {
            LuckyMoneyPrepareUI.d(LuckyMoneyPrepareUI.this);
          }
          AppMethodBeat.o(284170);
        }
      });
      localObject1 = (TextView)findViewById(a.f.lucky_money_prepare_error_tips);
      this.Knz.A((TextView)localObject1);
      this.qaM = new MTimerHandler(new MTimerHandler.CallBack()
      {
        public boolean onTimerExpired()
        {
          AppMethodBeat.i(284167);
          double d2;
          double d1;
          if ((LuckyMoneyPrepareUI.e(LuckyMoneyPrepareUI.this).fWv() != 3) && (LuckyMoneyPrepareUI.f(LuckyMoneyPrepareUI.this).fWv() != 3))
          {
            int i = LuckyMoneyPrepareUI.f(LuckyMoneyPrepareUI.this).getInput();
            d2 = LuckyMoneyPrepareUI.e(LuckyMoneyPrepareUI.this).getInput();
            if (LuckyMoneyPrepareUI.g(LuckyMoneyPrepareUI.this) == 0) {
              d1 = d2 * i;
            }
          }
          for (;;)
          {
            if ((d1 != 0.0D) && (d1 <= LuckyMoneyPrepareUI.i(LuckyMoneyPrepareUI.this).Kme) && (!LuckyMoneyPrepareUI.j(LuckyMoneyPrepareUI.this).fYt()))
            {
              LuckyMoneyPrepareUI.k(LuckyMoneyPrepareUI.this).setClickable(true);
              LuckyMoneyPrepareUI.k(LuckyMoneyPrepareUI.this).setEnabled(true);
            }
            Log.i("MicroMsg.LuckyMoneyPrepareUI", "onTimeExpired & check: amount=" + d1 + ", hasErr=" + LuckyMoneyPrepareUI.j(LuckyMoneyPrepareUI.this).fYt());
            LuckyMoneyPrepareUI.l(LuckyMoneyPrepareUI.this).stopped();
            AppMethodBeat.o(284167);
            return false;
            d1 = d2;
            if (LuckyMoneyPrepareUI.g(LuckyMoneyPrepareUI.this) == 3)
            {
              d1 = d2;
              if (Util.isNullOrNil(LuckyMoneyPrepareUI.h(LuckyMoneyPrepareUI.this)))
              {
                d1 = 0.0D;
                continue;
                d1 = 0.0D;
              }
            }
          }
        }
      }, false);
      if (this.Knw != null) {
        this.Knw.setOnTouchListener(new View.OnTouchListener()
        {
          public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(284164);
            if (paramAnonymousMotionEvent.getAction() == 0)
            {
              LuckyMoneyPrepareUI.this.hideTenpayKB();
              LuckyMoneyPrepareUI.this.hideVKB();
              LuckyMoneyPrepareUI.m(LuckyMoneyPrepareUI.this).hideWcKb();
            }
            AppMethodBeat.o(284164);
            return false;
          }
        });
      }
      this.KvU.setType(this.mType);
      init();
      final boolean bool = com.tencent.mm.aa.c.aYo().a(at.a.acVa, at.a.acVc);
      this.KHk.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
      {
        public final void dr(final View paramAnonymousView)
        {
          AppMethodBeat.i(284180);
          Log.d("MicroMsg.LuckyMoneyPrepareUI", "click envelope layout: %s", new Object[] { Integer.valueOf(LuckyMoneyPrepareUI.D(LuckyMoneyPrepareUI.this)) });
          if (LuckyMoneyPrepareUI.D(LuckyMoneyPrepareUI.this) == 0)
          {
            LuckyMoneyPrepareUI.a(LuckyMoneyPrepareUI.this, null, false, bool);
            paramAnonymousView = com.tencent.mm.plugin.report.service.h.OAn;
            if (!bool) {
              break label172;
            }
          }
          label172:
          for (int i = 2;; i = 1)
          {
            paramAnonymousView.b(18890, new Object[] { Integer.valueOf(2), Integer.valueOf(i), LuckyMoneyPrepareUI.F(LuckyMoneyPrepareUI.this) });
            com.tencent.mm.plugin.report.service.h.OAn.b(16822, new Object[] { Integer.valueOf(1) });
            AppMethodBeat.o(284180);
            return;
            paramAnonymousView = com.tencent.mm.plugin.luckymoney.model.ah.iN(LuckyMoneyPrepareUI.this.getContext());
            com.tencent.mm.plugin.luckymoney.model.l locall = com.tencent.mm.plugin.luckymoney.model.l.fWR();
            locall.d(new com.tencent.mm.plugin.luckymoney.model.e("", 1));
            locall.a(new com.tencent.mm.wallet_core.model.a.a() {}, 0L);
            break;
          }
        }
      });
      if (bool) {
        this.KHq.setVisibility(0);
      }
      if (this.KrK == null) {
        break label1981;
      }
      c(this.KrK.Krm);
    }
    for (;;)
    {
      this.mWcKeyboard = ((WcPayKeyboard)findViewById(a.f.wp_kb));
      this.mWcKeyboard.setActionText(getString(a.i.lucky_money_keyboard_confirm_btn_text));
      this.mWcKeyboard.setActionBtnColor(a.e.btn_solid_red);
      localObject1 = (RelativeLayout.LayoutParams)this.mWcKeyboard.getLayoutParams();
      if (localObject1 != null) {
        ((RelativeLayout.LayoutParams)localObject1).addRule(12);
      }
      this.KvU.getEditText().setOnEditorActionListener(new LuckyMoneyPrepareUI..ExternalSyntheticLambda1(this));
      this.Knq.getEditText().setOnEditorActionListener(new LuckyMoneyPrepareUI..ExternalSyntheticLambda0(this));
      a(this.KvU.getEditText(), this.mWcKeyboard, false);
      a(this.Knq.getEditText(), this.mWcKeyboard, true);
      localObject1 = (EditText)this.KvU.findViewById(a.f.lucky_money_et);
      localObject2 = (EditText)this.Knq.findViewById(a.f.lucky_money_et);
      com.tencent.mm.wallet_core.ui.i.setNoSystemInputOnEditText((EditText)localObject1);
      ((InputMethodManager)getContext().getSystemService("input_method")).showSoftInput((View)localObject1, 0);
      ((EditText)localObject1).addTextChangedListener(new TextWatcher()
      {
        public void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(284246);
          String str = paramAnonymousEditable.toString();
          Object localObject = Pattern.compile("(\\d+\\.?\\d{0,2})").matcher(str);
          if (((Matcher)localObject).find())
          {
            localObject = ((Matcher)localObject).group();
            if ((!((String)localObject).equals(str)) && (!str.startsWith(".")))
            {
              paramAnonymousEditable.replace(0, paramAnonymousEditable.length(), (CharSequence)localObject);
              AppMethodBeat.o(284246);
              return;
            }
          }
          int i;
          int j;
          if (str.startsWith("."))
          {
            paramAnonymousEditable.insert(0, "0");
            str = paramAnonymousEditable.toString();
            i = str.indexOf(".");
            j = str.length();
            if ((i < 0) || (j - i <= 3)) {
              break label177;
            }
            paramAnonymousEditable.delete(i + 3, j);
          }
          for (;;)
          {
            this.val$hintTv.setContentDescription(paramAnonymousEditable.toString());
            AppMethodBeat.o(284246);
            return;
            if (!WalletFormView.a(str, this.val$hintTv)) {
              break;
            }
            AppMethodBeat.o(284246);
            return;
            label177:
            if (i > 6) {
              paramAnonymousEditable.delete(6, i);
            } else if ((i == -1) && (j > 6)) {
              paramAnonymousEditable.delete(6, j);
            }
          }
        }
        
        public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      ((EditText)localObject2).addTextChangedListener(new TextWatcher()
      {
        public void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(284226);
          this.KnB.setContentDescription(paramAnonymousEditable.toString());
          AppMethodBeat.o(284226);
        }
        
        public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      com.tencent.mm.wallet_core.ui.i.setNoSystemInputOnEditText((EditText)localObject2);
      ((InputMethodManager)getContext().getSystemService("input_method")).showSoftInput((View)localObject2, 0);
      i = getIntent().getIntExtra("key_chatroom_num", 0);
      if (i > 0) {
        this.Knq.setGroupChatNumber(i);
      }
      AppMethodBeat.o(65886);
      return;
      setMMTitle(a.i.lucky_money_normal);
      this.KvU.setTitle(getString(a.i.lucky_money_unit_amount_title));
      this.KvU.setShowGroupIcon(false);
      break;
      label1594:
      if (this.lCR == 3)
      {
        this.KvU.setRtxLuckyMoney(2);
        break label736;
      }
      this.KvU.setRtxLuckyMoney(0);
      break label736;
      label1624:
      ((LinearLayout.LayoutParams)localObject1).topMargin = com.tencent.mm.cd.a.fromDPToPix(getContext(), 16);
      ((LinearLayout.LayoutParams)localObject2).topMargin = com.tencent.mm.cd.a.fromDPToPix(getContext(), 16);
      break label798;
      label1654:
      if (this.lCR == 3)
      {
        this.Knq.setRtxLuckyMoney(2);
        break label873;
      }
      this.Knq.setRtxLuckyMoney(0);
      break label873;
      label1684:
      this.KHp.setImageResource(a.e.lucky_money_prepare_envelope_mask);
      break label897;
      label1697:
      this.Knq.setNum("");
      break label929;
      label1710:
      setMMTitle(a.i.lucky_money_to_send_title);
      break label1079;
      label1720:
      if ((getIntent().getIntExtra("key_chatroom_num", 0) <= 0) && (this.Kwa))
      {
        this.KHr.setVisibility(8);
        this.KHt.setVisibility(8);
        label1759:
        if ((!this.Kwa) || (i <= 0)) {
          break label1887;
        }
        Log.i("MicroMsg.LuckyMoneyPrepareUI", "group hb,%d people", new Object[] { Integer.valueOf(i) });
        localObject1 = getString(a.i.lucky_money_num_group_tips, new Object[] { Integer.valueOf(getIntent().getIntExtra("key_chatroom_num", 8)) });
        this.KHu.setText((CharSequence)localObject1);
      }
      for (;;)
      {
        this.KvU.setGroupIconIv(a.e.lucky_money_group_icon_new_solid);
        break;
        this.KHr.setVisibility(0);
        aai(-1);
        this.KHr.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
        {
          public final void dr(View paramAnonymousView)
          {
            AppMethodBeat.i(284298);
            LuckyMoneyPrepareUI.this.hideTenpayKB();
            LuckyMoneyPrepareUI.this.hideVKB();
            LuckyMoneyPrepareUI.m(LuckyMoneyPrepareUI.this).hideWcKb();
            paramAnonymousView = new com.tencent.mm.ui.widget.f(LuckyMoneyPrepareUI.this.getContext(), (byte)0);
            paramAnonymousView.Vtg = new u.g()
            {
              public void onCreateMMMenu(com.tencent.mm.ui.base.s paramAnonymous2s)
              {
                AppMethodBeat.i(284217);
                paramAnonymous2s.c(1, LuckyMoneyPrepareUI.this.getString(a.i.lucky_money_mode_lucky_text));
                paramAnonymous2s.c(2, LuckyMoneyPrepareUI.this.getString(a.i.lucky_money_mode_normal_text));
                ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.znx, 0);
                int i = LuckyMoneyPrepareUI.this.getIntent().getIntExtra("key_chatroom_num", 0);
                if ((LuckyMoneyPrepareUI.i(LuckyMoneyPrepareUI.this).KrI) && (LuckyMoneyPrepareUI.n(LuckyMoneyPrepareUI.this) == 1) && (!ab.IG(LuckyMoneyPrepareUI.this.getIntent().getStringExtra("key_username"))) && (LuckyMoneyPrepareUI.o(LuckyMoneyPrepareUI.this) != 2) && (LuckyMoneyPrepareUI.o(LuckyMoneyPrepareUI.this) != 3) && (i > 1)) {
                  paramAnonymous2s.c(3, LuckyMoneyPrepareUI.this.getString(a.i.lucky_money_mode_exclusive_text));
                }
                AppMethodBeat.o(284217);
              }
            };
            paramAnonymousView.GAC = new u.i()
            {
              public void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
              {
                AppMethodBeat.i(284212);
                paramAnonymous2Int = paramAnonymous2MenuItem.getItemId();
                int i = LuckyMoneyPrepareUI.g(LuckyMoneyPrepareUI.this);
                if (paramAnonymous2Int == 1)
                {
                  LuckyMoneyPrepareUI.a(LuckyMoneyPrepareUI.this, 1);
                  com.tencent.mm.plugin.report.service.h.OAn.b(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(LuckyMoneyPrepareUI.p(LuckyMoneyPrepareUI.this)), Integer.valueOf(2) });
                }
                for (;;)
                {
                  if ((LuckyMoneyPrepareUI.q(LuckyMoneyPrepareUI.this)) && (i != LuckyMoneyPrepareUI.g(LuckyMoneyPrepareUI.this)))
                  {
                    com.tencent.mm.plugin.report.service.h.OAn.b(22237, new Object[] { Integer.valueOf(2) });
                    LuckyMoneyPrepareUI.r(LuckyMoneyPrepareUI.this);
                  }
                  LuckyMoneyPrepareUI.b(LuckyMoneyPrepareUI.this, i);
                  AppMethodBeat.o(284212);
                  return;
                  if (paramAnonymous2Int == 2)
                  {
                    LuckyMoneyPrepareUI.a(LuckyMoneyPrepareUI.this, 0);
                    com.tencent.mm.plugin.report.service.h.OAn.b(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(LuckyMoneyPrepareUI.p(LuckyMoneyPrepareUI.this)), Integer.valueOf(3) });
                  }
                  else if (paramAnonymous2Int == 3)
                  {
                    LuckyMoneyPrepareUI.a(LuckyMoneyPrepareUI.this, 3);
                    com.tencent.mm.plugin.report.service.h.OAn.b(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(LuckyMoneyPrepareUI.p(LuckyMoneyPrepareUI.this)), Integer.valueOf(13) });
                  }
                }
              }
            };
            paramAnonymousView.dDn();
            AppMethodBeat.o(284298);
          }
        });
        this.KHt.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
        {
          public final void dr(View paramAnonymousView)
          {
            AppMethodBeat.i(284175);
            LuckyMoneyPrepareUI.this.hideTenpayKB();
            LuckyMoneyPrepareUI.this.hideVKB();
            LuckyMoneyPrepareUI.m(LuckyMoneyPrepareUI.this).hideWcKb();
            paramAnonymousView = new Intent(LuckyMoneyPrepareUI.this.getContext(), LuckyMoneyExclusiveSelectContactUI.class);
            paramAnonymousView.putExtra("chatroomName", LuckyMoneyPrepareUI.s(LuckyMoneyPrepareUI.this));
            LuckyMoneyPrepareUI.this.startActivityForResult(paramAnonymousView, 6);
            AppMethodBeat.o(284175);
          }
        });
        break label1759;
        label1887:
        if (this.lCR == 2)
        {
          Log.i("MicroMsg.LuckyMoneyPrepareUI", "f2f hb");
          this.Kns.setVisibility(8);
        }
      }
      label1916:
      if (this.mType == 1)
      {
        this.tHK.setText(this.KmF.KrB);
        this.tHK.setVisibility(0);
        break label1149;
      }
      if (this.mType != 0) {
        break label1149;
      }
      this.tHK.setText(this.KmF.KrC);
      this.tHK.setVisibility(0);
      break label1149;
      label1981:
      Log.i("MicroMsg.LuckyMoneyPrepareUI", "do not has envelopSourceMac");
      c(null);
    }
  }
  
  public final void l(int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(65901);
    if (paramInt == -1)
    {
      String str = "";
      if (paramIntent != null) {
        str = paramIntent.getStringExtra("key_trans_id");
      }
      aKP(str);
    }
    finish();
    AppMethodBeat.o(65901);
  }
  
  public final void m(int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(65902);
    if ((this.KrK != null) && (this.KrK.Krm != null)) {
      com.tencent.mm.plugin.report.service.h.OAn.kvStat(22296, this.KrK.Krm.ZoK);
    }
    if (paramIntent.hasExtra("key_realname_guide_helper")) {
      this.KHD = ((RealnameGuideHelper)paramIntent.getParcelableExtra("key_realname_guide_helper"));
    }
    if (paramInt == -1)
    {
      aKP(paramIntent.getStringExtra("key_trans_id"));
      com.tencent.mm.plugin.report.service.h.OAn.b(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(fXD()), Integer.valueOf(5) });
      Object localObject1 = getIntent().getStringExtra("key_username");
      if (((this.Kwa) && (!Util.isNullOrNil((String)localObject1))) || (this.lCR == 3))
      {
        com.tencent.mm.ui.base.k.cZ(this, getString(a.i.has_send));
        Object localObject2 = XmlParser.parseXml(this.Kwb, "msg", null);
        if (localObject2 == null)
        {
          Log.e("MicroMsg.LuckyMoneyPrepareUI", "luckymoneyPrepareUI onActivityResult values is null");
          finish();
          AppMethodBeat.o(65902);
          return;
        }
        localObject2 = (String)((Map)localObject2).get(".msg.appmsg.wcpayinfo.paymsgid");
        if (com.tencent.mm.plugin.luckymoney.app.a.fWk().fWp().aKz((String)localObject2))
        {
          Log.i("MicroMsg.LuckyMoneyPrepareUI", "insert a local msg for luckymoney");
          if (!com.tencent.mm.plugin.luckymoney.model.ah.an(this.Kwb, (String)localObject1, 1))
          {
            Log.e("MicroMsg.LuckyMoneyPrepareUI", "LuckyMoneyUtil.sendLocalMsg fail!");
            com.tencent.mm.plugin.luckymoney.app.a.fWk().fWp().aKA((String)localObject2);
          }
          k(paramInt, paramIntent);
          paramIntent = new com.tencent.mm.plugin.luckymoney.story.b.e();
          paramIntent.field_send_id = ((String)localObject2);
          if (!com.tencent.mm.plugin.luckymoney.app.a.fWk().fWj().get(paramIntent, new String[0]))
          {
            paramIntent.field_open_count = 0;
            Log.d("MicroMsg.LuckyMoneyPrepareUI", "insert record: %s, %s", new Object[] { localObject2, Boolean.valueOf(com.tencent.mm.plugin.luckymoney.app.a.fWk().fWj().insert(paramIntent)) });
          }
          com.tencent.mm.plugin.luckymoney.app.a.KlK = this.mType;
          if (this.KHN)
          {
            if (!this.KHO) {
              break label504;
            }
            com.tencent.mm.plugin.report.service.h.OAn.b(22237, new Object[] { Integer.valueOf(4) });
          }
          label403:
          this.KHH = new lw();
          this.KHH.jau = this.KEU;
          if (this.xRp != null) {
            break label535;
          }
        }
        label535:
        for (paramIntent = "";; paramIntent = this.xRp.getMd5())
        {
          this.KHH.uz(paramIntent);
          this.KHH.bMH();
          Log.i("MicroMsg.LuckyMoneyPrepareUI", "Report RedEnvSendWithEmoticonDataStruct, Scene: %d, md5: %s", new Object[] { Integer.valueOf(this.KEU), paramIntent });
          finish();
          AppMethodBeat.o(65902);
          return;
          Log.e("MicroMsg.LuckyMoneyPrepareUI", "it is a duplicate msg");
          break;
          label504:
          if (this.mType == 1) {
            break label403;
          }
          com.tencent.mm.plugin.report.service.h.OAn.b(22237, new Object[] { Integer.valueOf(3) });
          break label403;
        }
      }
      hideActionBar();
      localObject1 = findViewById(a.f.lucky_money_prepare_ready_packet_ll);
      this.KvV.setVisibility(0);
      com.tencent.mm.plugin.luckymoney.model.ah.a((View)localObject1, null);
      this.xXJ.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
      {
        public final void dr(View paramAnonymousView)
        {
          AppMethodBeat.i(284105);
          com.tencent.mm.plugin.report.service.h.OAn.b(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(LuckyMoneyPrepareUI.p(LuckyMoneyPrepareUI.this)), Integer.valueOf(6) });
          com.tencent.mm.plugin.luckymoney.model.ah.a(LuckyMoneyPrepareUI.this, LuckyMoneyPrepareUI.g(LuckyMoneyPrepareUI.this), LuckyMoneyPrepareUI.O(LuckyMoneyPrepareUI.this), true);
          LuckyMoneyPrepareUI.P(LuckyMoneyPrepareUI.this).postDelayed(new Runnable()
          {
            public void run()
            {
              AppMethodBeat.i(65863);
              LuckyMoneyPrepareUI.P(LuckyMoneyPrepareUI.this).setVisibility(8);
              LuckyMoneyPrepareUI.this.showActionBar();
              AppMethodBeat.o(65863);
            }
          }, 100L);
          AppMethodBeat.o(284105);
        }
      });
      ((ImageView)findViewById(a.f.lucky_money_prepare_close_btn)).setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
      {
        public final void dr(View paramAnonymousView)
        {
          AppMethodBeat.i(284140);
          LuckyMoneyPrepareUI.P(LuckyMoneyPrepareUI.this).setVisibility(8);
          LuckyMoneyPrepareUI.this.showActionBar();
          AppMethodBeat.o(284140);
        }
      });
      k(paramInt, paramIntent);
      AppMethodBeat.o(65902);
      return;
    }
    k(paramInt, paramIntent);
    AppMethodBeat.o(65902);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(65900);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(65900);
      return;
      if ((paramIntent != null) && (paramIntent.hasExtra("key_realname_guide_helper"))) {
        this.KHD = ((RealnameGuideHelper)paramIntent.getParcelableExtra("key_realname_guide_helper"));
      }
      Object localObject1;
      if (paramInt2 == -1)
      {
        com.tencent.mm.plugin.report.service.h.OAn.b(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(fXD()), Integer.valueOf(5) });
        localObject1 = getIntent().getStringExtra("key_username");
        if (((this.Kwa) && (!Util.isNullOrNil((String)localObject1))) || (this.lCR == 3))
        {
          Object localObject2 = XmlParser.parseXml(this.Kwb, "msg", null);
          if (localObject2 == null)
          {
            Log.e("MicroMsg.LuckyMoneyPrepareUI", "luckymoneyPrepareUI onActivityResult values is null");
            finish();
            AppMethodBeat.o(65900);
            return;
          }
          localObject2 = (String)((Map)localObject2).get(".msg.appmsg.wcpayinfo.paymsgid");
          if (com.tencent.mm.plugin.luckymoney.app.a.fWk().fWp().aKz((String)localObject2))
          {
            Log.i("MicroMsg.LuckyMoneyPrepareUI", "insert a local msg for luckymoney");
            if (!com.tencent.mm.plugin.luckymoney.model.ah.an(this.Kwb, (String)localObject1, 1))
            {
              Log.e("MicroMsg.LuckyMoneyPrepareUI", "LuckyMoneyUtil.sendLocalMsg fail!");
              com.tencent.mm.plugin.luckymoney.app.a.fWk().fWp().aKA((String)localObject2);
            }
            label314:
            k(paramInt2, paramIntent);
            this.KHH = new lw();
            this.KHH.jau = this.KEU;
            if (this.xRp != null) {
              break label444;
            }
            localObject1 = "";
            label355:
            this.KHH.uz((String)localObject1);
            this.KHH.bMH();
            Log.i("MicroMsg.LuckyMoneyPrepareUI", "Report RedEnvSendWithEmoticonDataStruct, Scene: %d, md5: %s", new Object[] { Integer.valueOf(this.KEU), localObject1 });
            finish();
          }
        }
        for (;;)
        {
          localObject1 = "";
          if (paramIntent != null) {
            localObject1 = paramIntent.getStringExtra("key_trans_id");
          }
          aKP((String)localObject1);
          break;
          Log.e("MicroMsg.LuckyMoneyPrepareUI", "it is a duplicate msg");
          break label314;
          label444:
          localObject1 = this.xRp.getMd5();
          break label355;
          hideActionBar();
          localObject1 = findViewById(a.f.lucky_money_prepare_ready_packet_ll);
          this.KvV.setVisibility(0);
          com.tencent.mm.plugin.luckymoney.model.ah.a((View)localObject1, null);
          this.xXJ.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
          {
            public final void dr(View paramAnonymousView)
            {
              AppMethodBeat.i(284108);
              com.tencent.mm.plugin.report.service.h.OAn.b(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(LuckyMoneyPrepareUI.p(LuckyMoneyPrepareUI.this)), Integer.valueOf(6) });
              com.tencent.mm.plugin.luckymoney.model.ah.a(LuckyMoneyPrepareUI.this, LuckyMoneyPrepareUI.g(LuckyMoneyPrepareUI.this), LuckyMoneyPrepareUI.O(LuckyMoneyPrepareUI.this), true);
              LuckyMoneyPrepareUI.P(LuckyMoneyPrepareUI.this).postDelayed(new Runnable()
              {
                public void run()
                {
                  AppMethodBeat.i(284429);
                  LuckyMoneyPrepareUI.P(LuckyMoneyPrepareUI.this).setVisibility(8);
                  LuckyMoneyPrepareUI.this.showActionBar();
                  AppMethodBeat.o(284429);
                }
              }, 100L);
              AppMethodBeat.o(284108);
            }
          });
          ((ImageView)findViewById(a.f.lucky_money_prepare_close_btn)).setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
          {
            public final void dr(View paramAnonymousView)
            {
              AppMethodBeat.i(284101);
              LuckyMoneyPrepareUI.P(LuckyMoneyPrepareUI.this).setVisibility(8);
              LuckyMoneyPrepareUI.this.showActionBar();
              AppMethodBeat.o(284101);
            }
          });
          k(paramInt2, paramIntent);
        }
      }
      if (com.tencent.mm.wallet_core.model.ah.cq(paramIntent))
      {
        finish();
        AppMethodBeat.o(65900);
        return;
      }
      if (com.tencent.mm.wallet_core.model.ah.cr(paramIntent))
      {
        AppMethodBeat.o(65900);
        return;
      }
      k(paramInt2, paramIntent);
      continue;
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        localObject1 = paramIntent.getStringExtra("Select_Conv_User");
        com.tencent.mm.plugin.report.service.h.OAn.b(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(fXD()), Integer.valueOf(7), localObject1 });
        if (!Util.isNullOrNil((String)localObject1)) {
          doSceneProgress(new bh(((String)localObject1).replaceAll(",", "|"), this.KvY, "v1.0"));
        } else {
          finish();
        }
      }
      else if (paramInt2 == 0)
      {
        localObject1 = new Intent();
        ((Intent)localObject1).setClass(getContext(), LuckyMoneyMyRecordUI.class);
        ((Intent)localObject1).putExtra("key_username", getIntent().getStringExtra("key_username"));
        ((Intent)localObject1).putExtra("key_type", 1);
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject1);
        com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        continue;
        if ((paramIntent != null) && (paramIntent.hasExtra("result_data")))
        {
          localObject1 = paramIntent.getBundleExtra("result_data");
          if (localObject1 != null)
          {
            int i = Util.getInt(((Bundle)localObject1).getString("payState", "2"), 0);
            Log.e("MicroMsg.LuckyMoneyPrepareUI", "onActivityResult REQUEST_CODE_H5_PAY payState is " + i + ";STATE_H5_PAY_SUCC=0");
            if (i == 0)
            {
              com.tencent.mm.plugin.luckymoney.app.a.KlK = this.mType;
              if (this.KHN)
              {
                if (!this.KHO) {
                  break label954;
                }
                com.tencent.mm.plugin.report.service.h.OAn.b(22237, new Object[] { Integer.valueOf(4) });
              }
              for (;;)
              {
                finish();
                break;
                label954:
                if (this.mType != 1) {
                  com.tencent.mm.plugin.report.service.h.OAn.b(22237, new Object[] { Integer.valueOf(3) });
                }
              }
            }
          }
          else
          {
            Log.e("MicroMsg.LuckyMoneyPrepareUI", "onActivityResult REQUEST_CODE_H5_PAY bundle is null");
            continue;
            l(paramInt2, paramIntent);
            continue;
            if (paramInt2 == -1)
            {
              this.KvX.removeAllViews();
              yi(true);
            }
            else
            {
              yi(false);
              com.tencent.mm.plugin.report.service.h.OAn.b(16822, new Object[] { Integer.valueOf(2) });
              continue;
              if (paramInt2 == -1)
              {
                localObject1 = "";
                if (paramIntent != null) {
                  localObject1 = paramIntent.getStringExtra("gif_md5");
                }
                if (!Util.isNullOrNil((String)localObject1))
                {
                  this.xRp = com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adju.bza((String)localObject1);
                  C(this.xRp);
                }
                else
                {
                  Log.i("MicroMsg.LuckyMoneyPrepareUI", "md5 == null go emoji capture failed!");
                }
              }
              else
              {
                Log.i("MicroMsg.LuckyMoneyPrepareUI", "go emoji capture failed!");
                continue;
                if (paramInt2 == -1)
                {
                  this.KHG = paramIntent.getStringExtra("Select_Contact");
                  Log.i("MicroMsg.LuckyMoneyPrepareUI", "select user: %s", new Object[] { this.KHG });
                  if (!Util.isNullOrNil(this.KHG))
                  {
                    com.tencent.mm.ui.i.a.a.g(this.KHv, this.KHG);
                    localObject1 = com.tencent.mm.wallet_core.ui.i.jp(((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.a.b.class)).aV(this.KHG, this.KHF), 8);
                    this.KHw.setText(com.tencent.mm.pluginsdk.ui.span.p.b(getContext(), (CharSequence)localObject1, this.KHw.getTextSize()));
                    this.KHv.setVisibility(0);
                    this.KHw.setVisibility(0);
                  }
                }
                fWx();
              }
            }
          }
        }
      }
    }
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(65887);
    finish();
    AppMethodBeat.o(65887);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(65883);
    super.onCreate(paramBundle);
    setActionbarColor(getResources().getColor(a.c.lucky_money_graystyle_bg));
    setActionbarElementColor(getResources().getColor(a.c.FG_0));
    hideActionbarLine();
    this.mType = getIntent().getIntExtra("key_type", 1);
    this.Krb = getIntent().getIntExtra("key_way", 3);
    this.lCR = getIntent().getIntExtra("key_from", 0);
    boolean bool;
    int i;
    label163:
    int j;
    if (this.lCR == 1)
    {
      bool = true;
      this.Kwa = bool;
      this.mChannel = getIntent().getIntExtra("pay_channel", -1);
      this.mSessionId = getIntent().getStringExtra("key_session_id");
      yi(false);
      if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.znz, 1) != 1) {
        break label528;
      }
      i = 1;
      j = getIntent().getIntExtra("key_chatroom_num", 0);
      if ((!this.Kwa) || (j <= 0)) {
        break label533;
      }
      j = 1;
      label188:
      if ((j != 0) && (com.tencent.mm.plugin.luckymoney.app.a.KlK >= 0) && (i != 0))
      {
        Log.i("MicroMsg.LuckyMoneyPrepareUI", "use cached hb type: %s", new Object[] { Integer.valueOf(com.tencent.mm.plugin.luckymoney.app.a.KlK) });
        this.mType = com.tencent.mm.plugin.luckymoney.app.a.KlK;
        this.KHN = true;
        if (this.mType != 1) {
          com.tencent.mm.plugin.report.service.h.OAn.b(22237, new Object[] { Integer.valueOf(1) });
        }
      }
      if (!com.tencent.mm.plugin.luckymoney.model.ah.IH(getIntent().getStringExtra("key_username"))) {
        break label538;
      }
      com.tencent.mm.plugin.luckymoney.app.a.fWk();
      this.KmF = com.tencent.mm.plugin.luckymoney.app.a.fWm().fWW();
      com.tencent.mm.plugin.luckymoney.app.a.fWk();
      this.KrK = com.tencent.mm.plugin.luckymoney.app.a.fWm().fWX();
    }
    for (;;)
    {
      if (this.lCR == 3) {
        setMMSubTitle(a.i.lucky_money_live_subtitle_text);
      }
      Log.i("MicroMsg.LuckyMoneyPrepareUI", "mInWay:" + this.Krb + "mChannel:" + this.mChannel);
      Log.i("MicroMsg.LuckyMoneyPrepareUI", "type=" + this.mType + ", fromAppPanel=" + this.Kwa + ", config " + this.KmF);
      initView();
      this.KIb.alive();
      this.mPayLoopInterruptListener.alive();
      com.tencent.mm.plugin.report.service.h.OAn.b(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(fXD()), Integer.valueOf(1) });
      com.tencent.mm.wallet_core.b.jNX();
      this.mKindaEnable = com.tencent.mm.wallet_core.b.b(com.tencent.mm.plugin.expt.b.c.a.yRc, true);
      ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.wxpay.a.a.class)).triggerSoterReInit();
      com.tencent.soter.a.a.jYq();
      AppMethodBeat.o(65883);
      return;
      bool = false;
      break;
      label528:
      i = 0;
      break label163;
      label533:
      j = 0;
      break label188;
      label538:
      if (this.lCR == 3)
      {
        com.tencent.mm.plugin.luckymoney.app.a.fWk();
        this.KmF = com.tencent.mm.plugin.luckymoney.app.a.fWn().fWW();
        com.tencent.mm.plugin.luckymoney.app.a.fWk();
        this.KrK = com.tencent.mm.plugin.luckymoney.app.a.fWn().fWX();
      }
      else
      {
        com.tencent.mm.plugin.luckymoney.app.a.fWk();
        this.KmF = com.tencent.mm.plugin.luckymoney.app.a.fWl().fWW();
        com.tencent.mm.plugin.luckymoney.app.a.fWk();
        this.KrK = com.tencent.mm.plugin.luckymoney.app.a.fWl().fWX();
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(65893);
    super.onDestroy();
    this.Knz.clear();
    this.qaM.stopped();
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    if (this.uKY != null)
    {
      Log.i("MicroMsg.LuckyMoneyPrepareUI", "commentfooter release");
      this.uKY.onPause();
      this.uKY.iKg();
      this.uKY.destroy();
    }
    this.KIb.dead();
    this.mPayLoopInterruptListener.dead();
    if (this.KHP)
    {
      int i = ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acUK, Integer.valueOf(0))).intValue();
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acUK, Integer.valueOf(i + 1));
    }
    AppMethodBeat.o(65893);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(65904);
    if (paramInt == 4)
    {
      if ((this.mKBLayout != null) && (this.mKBLayout.isShown()))
      {
        this.mKBLayout.setVisibility(8);
        AppMethodBeat.o(65904);
        return true;
      }
      if ((this.mWcKeyboard != null) && (this.mWcKeyboard.isShown()))
      {
        this.mWcKeyboard.hideWcKb();
        AppMethodBeat.o(65904);
        return true;
      }
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(65904);
    return bool;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(65884);
    super.onResume();
    addSceneEndListener(1970);
    com.tencent.mm.plugin.wxpayreport.f localf = com.tencent.mm.plugin.wxpayreport.f.XIR;
    com.tencent.mm.plugin.wxpayreport.f.a(this.Knt, Integer.valueOf(0), com.tencent.mm.plugin.wxpayreport.a.c.a.XJC.name(), this, 300L);
    AppMethodBeat.o(65884);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, final com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(65896);
    Log.i("MicroMsg.LuckyMoneyPrepareUI", "errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scenetype:" + paramp.getType());
    boolean bool;
    if ((paramp instanceof bc))
    {
      Log.i("MicroMsg.LuckyMoneyPrepareUI", "onsceneEnd： scene instanceof NetScenePrepareLuckyMoney");
      if (this.KIa)
      {
        Log.i("MicroMsg.LuckyMoneyPrepareUI", "has show alert return");
        AppMethodBeat.o(65896);
        return true;
      }
      bc localbc = (bc)paramp;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        bool = this.mKindaEnable;
        if ((this.tipDialog != null) && (this.tipDialog.isShowing()) && (!bool)) {
          this.tipDialog.dismiss();
        }
        this.KvZ = localbc.wYz;
        this.KvY = localbc.CAf;
        this.Kwb = localbc.KuM;
        this.KqM = localbc.CAf;
        this.KHE = localbc.KuQ;
        if (((bc)paramp).isJumpRemind())
        {
          Log.i("MicroMsg.LuckyMoneyPrepareUI", "onSceneEnd() NetScenePrepareLuckyMoney show JumpRemind Alert");
          ((bc)paramp).jumpRemind.a(this, new com.tencent.mm.wallet_core.model.h()
          {
            public final void cm(int paramAnonymousInt, String paramAnonymousString)
            {
              AppMethodBeat.i(284243);
              Log.i("MicroMsg.LuckyMoneyPrepareUI", "onSceneEnd() scene:NetScenePrepareLuckyMoney JumpRemind:onNext()");
              if ((Util.isEqual(paramAnonymousInt, 2)) && (Util.isEqual(paramAnonymousString, "requestwxhb")))
              {
                LuckyMoneyPrepareUI.I(LuckyMoneyPrepareUI.this);
                AppMethodBeat.o(284243);
                return;
              }
              if (Util.isEqual(paramAnonymousInt, 1)) {
                com.tencent.mm.plugin.account.sdk.c.a.b(LuckyMoneyPrepareUI.this, paramAnonymousString, 0, true);
              }
              AppMethodBeat.o(284243);
            }
            
            public final void onCancel()
            {
              AppMethodBeat.i(284247);
              Log.i("MicroMsg.LuckyMoneyPrepareUI", "onSceneEnd() scene:NetScenePrepareLuckyMoney JumpRemind:onCancel()");
              AppMethodBeat.o(284247);
            }
          });
          AppMethodBeat.o(65896);
          return true;
        }
        paramString = new PayInfo();
        paramString.hAT = localbc.Hgk;
        paramString.hUR = 37;
        paramString.channel = this.mChannel;
        if (this.mKindaEnable) {
          ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.pluginsdk.wallet.a.class)).startSNSPay(this, paramString);
        }
        for (;;)
        {
          AppMethodBeat.o(65896);
          return true;
          com.tencent.mm.pluginsdk.wallet.f.a(this, paramString, 1);
        }
      }
      if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
        this.tipDialog.dismiss();
      }
      if (paramInt2 == 401)
      {
        this.Knt.setEnabled(false);
        this.Knt.setClickable(false);
        this.qaM.startTimer(5000L);
        com.tencent.mm.ui.base.k.cZ(this, paramString);
        AppMethodBeat.o(65896);
        return true;
      }
      if (paramInt2 == 268502454)
      {
        com.tencent.mm.ui.base.k.d(this, paramString, "", new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(284255);
            if (bc.l(paramp))
            {
              LuckyMoneyPrepareUI.this.finish();
              AppMethodBeat.o(284255);
              return;
            }
            AppMethodBeat.o(284255);
          }
        });
        AppMethodBeat.o(65896);
        return true;
      }
      this.hXQ = 2;
      paramp = paramString;
      if (TextUtils.isEmpty(paramString)) {
        paramp = getString(a.i.wallet_unknown_err);
      }
      com.tencent.mm.ui.base.k.a(this, paramp, null, false, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(284232);
          paramAnonymousDialogInterface.dismiss();
          AppMethodBeat.o(284232);
        }
      });
      AppMethodBeat.o(65896);
      return true;
    }
    if ((paramp instanceof bh))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (this.Kwa)
        {
          com.tencent.mm.ui.widget.snackbar.b.u(this, getString(a.i.has_send));
          MMHandlerThread.postToMainThreadDelayed(new Runnable()
          {
            public void run()
            {
              AppMethodBeat.i(284252);
              LuckyMoneyPrepareUI.this.finish();
              AppMethodBeat.o(284252);
            }
          }, 1800L);
        }
        for (;;)
        {
          AppMethodBeat.o(65896);
          return true;
          hideActionBar();
          this.KvW.setVisibility(0);
          this.KvW.postDelayed(new Runnable()
          {
            public void run()
            {
              AppMethodBeat.i(284266);
              Object localObject = new Intent();
              ((Intent)localObject).putExtra("key_username", LuckyMoneyPrepareUI.s(LuckyMoneyPrepareUI.this));
              ((Intent)localObject).setClass(LuckyMoneyPrepareUI.this.getContext(), LuckyMoneyIndexUI.class);
              ((Intent)localObject).addFlags(67108864);
              AppCompatActivity localAppCompatActivity = LuckyMoneyPrepareUI.this.getContext();
              localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
              com.tencent.mm.hellhoundlib.a.a.b(localAppCompatActivity, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$29", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              localAppCompatActivity.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
              com.tencent.mm.hellhoundlib.a.a.c(localAppCompatActivity, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$29", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              LuckyMoneyPrepareUI.this.finish();
              AppMethodBeat.o(284266);
            }
          }, 1000L);
        }
      }
      if (paramInt2 == 402)
      {
        com.tencent.mm.ui.base.k.b(getContext(), paramString, "", getString(a.i.lucky_money_send_list_title), getString(a.i.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(284088);
            Object localObject = new Intent();
            ((Intent)localObject).setClass(LuckyMoneyPrepareUI.this.getContext(), LuckyMoneyMyRecordUI.class);
            ((Intent)localObject).putExtra("key_type", 1);
            ((Intent)localObject).putExtra("key_username", LuckyMoneyPrepareUI.this.getIntent().getStringExtra("key_username"));
            paramAnonymousDialogInterface = LuckyMoneyPrepareUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
            com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$30", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousDialogInterface, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$30", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(284088);
          }
        }, new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(65896);
        return true;
      }
    }
    else
    {
      if ((paramp instanceof as))
      {
        Log.i("MicroMsg.LuckyMoneyPrepareUI", "NetSceneLuckyMoneyGetConfig resp,errType=" + paramInt1 + ";errCode=" + paramInt2 + ";errMsg=" + paramString);
        if ((this.KHi != null) && (this.KHi.isShowing())) {
          this.KHi.dismiss();
        }
        if ((this.KHj != null) && (this.KHj.isShowing())) {
          this.KHj.dismiss();
        }
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = (as)paramp;
          this.KHX = true;
          this.Kux = paramString.Kux;
          if (!Util.isEqual(paramString.Kuy, 1))
          {
            this.Kns.yj(true);
            if (!com.tencent.mm.plugin.luckymoney.model.ah.IH(getIntent().getStringExtra("key_username"))) {
              break label1418;
            }
            com.tencent.mm.plugin.luckymoney.app.a.fWk();
            this.KmF = com.tencent.mm.plugin.luckymoney.app.a.fWm().fWW();
            label796:
            Log.i("MicroMsg.LuckyMoneyPrepareUI", "update config:" + this.KmF);
            if (this.mType != 1) {
              break label1460;
            }
            this.KvU.setMaxAmount(this.KmF.Kme);
            label844:
            this.KvU.setMinAmount(this.KmF.Kmd);
            this.Knq.setMaxNum(this.KmF.Kmb);
            this.KHB = paramString.Kmg;
            this.KHA = paramString.wYR;
            this.KHC = paramString.Kmq;
            if (Util.isNullOrNil(this.KFd)) {
              this.KFd = paramString.hTs;
            }
            if ((!Util.isNullOrNil(this.KHC)) && (this.Kns != null)) {
              MMHandlerThread.postToMainThread(new Runnable()
              {
                public void run()
                {
                  AppMethodBeat.i(284089);
                  LuckyMoneyPrepareUI.L(LuckyMoneyPrepareUI.this).setHintText(LuckyMoneyPrepareUI.M(LuckyMoneyPrepareUI.this));
                  AppMethodBeat.o(284089);
                }
              });
            }
            if ((paramString.Kuo) && (this.Kwa))
            {
              paramp = (TextView)findViewById(a.f.lucky_money_prepare_has_tips);
              paramp.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
              {
                public final void dr(View paramAnonymousView)
                {
                  AppMethodBeat.i(284107);
                  com.tencent.mm.plugin.report.service.h.OAn.b(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(LuckyMoneyPrepareUI.p(LuckyMoneyPrepareUI.this)), Integer.valueOf(9) });
                  Object localObject = new Intent();
                  ((Intent)localObject).setClass(LuckyMoneyPrepareUI.this.getContext(), LuckyMoneyCanShareListUI.class);
                  paramAnonymousView = LuckyMoneyPrepareUI.this;
                  localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
                  com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$34", "onRealClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
                  com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$34", "onRealClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  AppMethodBeat.o(284107);
                }
              });
              com.tencent.mm.plugin.report.service.h.OAn.b(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(fXD()), Integer.valueOf(8) });
              paramp.setVisibility(8);
            }
            if (paramString.pGr == null) {
              break label1477;
            }
            this.pLM.setBannerData(paramString.pGr);
            label1058:
            paramp = new i.c();
            if ((paramString.Kus == null) || (Util.isNullOrNil(paramString.Kus.content))) {
              break label1573;
            }
            paramp.textColor = getResources().getColor(a.c.wallet_link_color);
            label1102:
            this.KvX.removeAllViews();
            i.a(this, this.KvX, paramString.Kus, paramp);
            if (this.KHA == 1) {
              break label1591;
            }
            c(this.KvU.getInput(), this.KHB);
            label1146:
            fYR();
            if (!com.tencent.mm.plugin.luckymoney.model.ah.IH(getIntent().getStringExtra("key_username"))) {
              break label1643;
            }
            com.tencent.mm.plugin.luckymoney.app.a.fWk();
            this.KrK = com.tencent.mm.plugin.luckymoney.app.a.fWm().fWX();
            label1180:
            init();
            if (this.KrK == null) {
              break label1685;
            }
            if (this.KrK.Krm != null)
            {
              this.KHI = this.KrK.Krm.aaED;
              this.KHJ = this.KrK.Krm.aaEB;
              this.KHK = this.KrK.Krm.aaEC;
            }
            c(this.KrK.Krm);
            com.tencent.mm.plugin.report.service.h.OAn.kJ(991, 10);
            label1265:
            if (this.KHZ)
            {
              Log.i("MicroMsg.LuckyMoneyPrepareUI", "doRMBPrePareBtnClick()");
              a(this.KHQ, this.KHR, this.KHS, this.KHT, this.KHU, this.KHV);
            }
          }
        }
        for (;;)
        {
          Log.i("MicroMsg.LuckyMoneyPrepareUI", "NetSceneLuckyMoneyGetConfig waitingGetConfig:%s ifAutoRMBPrePareBtn:%s", new Object[] { Boolean.valueOf(this.KHY), Boolean.valueOf(this.KHZ) });
          this.KHY = false;
          this.KHZ = false;
          AppMethodBeat.o(65896);
          return true;
          this.Kns.yj(false);
          if ((this.xRp != null) && (!Util.isNullOrNil(this.xRp.getMd5()))) {
            this.Kns.C(this.xRp);
          }
          this.Kns.setmOnEmojiSelectClickListener(new com.tencent.mm.wallet_core.ui.k()
          {
            public final void dr(View paramAnonymousView)
            {
              AppMethodBeat.i(284093);
              LuckyMoneyPrepareUI.a(LuckyMoneyPrepareUI.this, new lv());
              LuckyMoneyPrepareUI.b(LuckyMoneyPrepareUI.this).iPe = 2L;
              LuckyMoneyPrepareUI.b(LuckyMoneyPrepareUI.this).bMH();
              final boolean bool = Util.isEqual(paramAnonymousView.getTag(), "delete");
              if ((!bool) && (!Util.isEqual(paramString.Kux, 1)))
              {
                LuckyMoneyPrepareUI.c(LuckyMoneyPrepareUI.this, 2);
                LuckyMoneyPrepareUI.J(LuckyMoneyPrepareUI.this);
                AppMethodBeat.o(284093);
                return;
              }
              paramAnonymousView = new com.tencent.mm.ui.widget.f(LuckyMoneyPrepareUI.this.getContext());
              paramAnonymousView.Vtg = new u.g()
              {
                public void onCreateMMMenu(com.tencent.mm.ui.base.s paramAnonymous2s)
                {
                  AppMethodBeat.i(284271);
                  if (!bool)
                  {
                    if (Util.isEqual(LuckyMoneyPrepareUI.32.this.Kwd.Kux, 1)) {
                      paramAnonymous2s.oh(1, a.i.lucky_money_newyear_shoot_expression);
                    }
                    paramAnonymous2s.oh(2, a.i.lucky_money_select_had_expression);
                    AppMethodBeat.o(284271);
                    return;
                  }
                  paramAnonymous2s.a(3, LuckyMoneyPrepareUI.this.getResources().getColor(a.c.lucky_money_newyear_shoot_expression_color), LuckyMoneyPrepareUI.this.getContext().getString(a.i.lucky_money_delete_emoji));
                  AppMethodBeat.o(284271);
                }
              };
              paramAnonymousView.GAC = new u.i()
              {
                public void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(284278);
                  Log.i("MicroMsg.LuckyMoneyPrepareUI", "showLuckyHbDlg() onMMMenuItemSelected menuItemId:%s", new Object[] { Integer.valueOf(paramAnonymous2MenuItem.getItemId()) });
                  switch (paramAnonymous2MenuItem.getItemId())
                  {
                  }
                  for (;;)
                  {
                    AppMethodBeat.o(284278);
                    return;
                    LuckyMoneyPrepareUI.c(LuckyMoneyPrepareUI.this, 1);
                    com.tencent.mm.plugin.emojicapture.api.b.d(LuckyMoneyPrepareUI.this, 4, LuckyMoneyPrepareUI.s(LuckyMoneyPrepareUI.this));
                    LuckyMoneyPrepareUI.a(LuckyMoneyPrepareUI.this, new lv());
                    LuckyMoneyPrepareUI.b(LuckyMoneyPrepareUI.this).iPe = 4L;
                    LuckyMoneyPrepareUI.b(LuckyMoneyPrepareUI.this).bMH();
                    AppMethodBeat.o(284278);
                    return;
                    LuckyMoneyPrepareUI.c(LuckyMoneyPrepareUI.this, 2);
                    LuckyMoneyPrepareUI.J(LuckyMoneyPrepareUI.this);
                    AppMethodBeat.o(284278);
                    return;
                    LuckyMoneyPrepareUI.K(LuckyMoneyPrepareUI.this);
                    paramAnonymous2MenuItem = LuckyMoneyPrepareUI.L(LuckyMoneyPrepareUI.this);
                    paramAnonymous2MenuItem.KIu.setTag("");
                    paramAnonymous2MenuItem.KIv.setVisibility(0);
                    paramAnonymous2MenuItem.KIw.setVisibility(8);
                    LuckyMoneyPrepareUI.a(LuckyMoneyPrepareUI.this, null);
                    LuckyMoneyPrepareUI.a(LuckyMoneyPrepareUI.this, new lv());
                    LuckyMoneyPrepareUI.b(LuckyMoneyPrepareUI.this).iPe = 5L;
                    LuckyMoneyPrepareUI.b(LuckyMoneyPrepareUI.this).bMH();
                  }
                }
              };
              paramAnonymousView.dDn();
              AppMethodBeat.o(284093);
            }
          });
          break;
          label1418:
          if (this.lCR == 3)
          {
            com.tencent.mm.plugin.luckymoney.app.a.fWk();
            this.KmF = com.tencent.mm.plugin.luckymoney.app.a.fWn().fWW();
            break label796;
          }
          com.tencent.mm.plugin.luckymoney.app.a.fWk();
          this.KmF = com.tencent.mm.plugin.luckymoney.app.a.fWl().fWW();
          break label796;
          label1460:
          this.KvU.setMaxAmount(this.KmF.Kmc);
          break label844;
          label1477:
          if (!Util.isNullOrNil(paramString.pHt))
          {
            Log.i("MicroMsg.LuckyMoneyPrepareUI", "Put notice :" + paramString.pHt);
            this.Knx.setText(paramString.pHt);
            if (!Util.isNullOrNil(paramString.Kuq)) {
              this.Knx.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
              {
                public final void dr(View paramAnonymousView)
                {
                  AppMethodBeat.i(284095);
                  com.tencent.mm.wallet_core.ui.i.p(LuckyMoneyPrepareUI.this.getContext(), paramString.Kuq, false);
                  AppMethodBeat.o(284095);
                }
              });
            }
            this.Knx.setVisibility(0);
            break label1058;
          }
          this.Knx.setVisibility(8);
          break label1058;
          label1573:
          paramp.textColor = getResources().getColor(a.c.half_alpha_black);
          break label1102;
          label1591:
          if (this.mType == 1)
          {
            c(this.KvU.getInput(), this.KHB);
            break label1146;
          }
          if (this.mType != 3) {
            break label1146;
          }
          c(this.KvU.getInput(), this.KHB);
          break label1146;
          label1643:
          if (this.lCR == 3)
          {
            com.tencent.mm.plugin.luckymoney.app.a.fWk();
            this.KrK = com.tencent.mm.plugin.luckymoney.app.a.fWn().fWX();
            break label1180;
          }
          com.tencent.mm.plugin.luckymoney.app.a.fWk();
          this.KrK = com.tencent.mm.plugin.luckymoney.app.a.fWl().fWX();
          break label1180;
          label1685:
          c(null);
          break label1265;
          if (this.KHZ)
          {
            paramp = paramString;
            if (Util.isNullOrNil(paramString)) {
              paramp = getString(a.i.app_err_system_busy_tip);
            }
            aa.makeText(this, paramp, 0).show();
          }
        }
      }
      if ((paramp instanceof au))
      {
        removeSceneEndListener(1647);
        if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
          this.tipDialog.dismiss();
        }
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = ((au)paramp).wZd;
          if (!Util.isNullOrNil(paramString))
          {
            Log.i("MicroMsg.LuckyMoneyPrepareUI", "payUrl is not null");
            com.tencent.mm.wallet_core.ui.i.a(getContext(), paramString, false, 3);
          }
          for (;;)
          {
            AppMethodBeat.o(65896);
            return true;
            Log.e("MicroMsg.LuckyMoneyPrepareUI", "payUrl is null");
          }
        }
      }
      else
      {
        if ((paramp instanceof com.tencent.mm.plugin.luckymoney.f2f.a.d))
        {
          if ((paramInt1 == 0) && (paramInt2 == 0))
          {
            bool = this.mKindaEnable;
            if ((this.tipDialog != null) && (this.tipDialog.isShowing()) && (!bool)) {
              this.tipDialog.dismiss();
            }
            paramString = (com.tencent.mm.plugin.luckymoney.f2f.a.d)paramp;
            if (j.a(paramString.KoB.ZxA))
            {
              if (this.tipDialog != null) {
                this.tipDialog.dismiss();
              }
              paramp = new j(this);
              paramp.a(paramString.KoB.ZxA, new j.5(paramp));
              AppMethodBeat.o(65896);
              return true;
            }
            this.KqM = ((com.tencent.mm.plugin.luckymoney.f2f.a.d)paramp).CAf;
            this.KHE = ((com.tencent.mm.plugin.luckymoney.f2f.a.d)paramp).KoC;
            paramString = new PayInfo();
            paramString.hAT = ((com.tencent.mm.plugin.luckymoney.f2f.a.d)paramp).hAT;
            paramString.hUR = 37;
            if (this.mKindaEnable)
            {
              if (paramString.nKf == null) {
                paramString.nKf = new Bundle();
              }
              paramString.nKf.putBoolean("isF2FHongBao", true);
              ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.pluginsdk.wallet.a.class)).startSNSPay(this, paramString);
            }
          }
          for (;;)
          {
            AppMethodBeat.o(65896);
            return true;
            com.tencent.mm.wallet_core.model.ag.G(37, paramString.hAT, paramInt2);
            com.tencent.mm.pluginsdk.wallet.f.a(this, paramString, 4);
            continue;
            com.tencent.mm.wallet_core.model.ag.G(37, "", paramInt2);
            if (!Util.isNullOrNil(paramString)) {
              com.tencent.mm.ui.base.k.c(this, paramString, getString(a.i.lucky_money_app_tip), true);
            }
            this.tipDialog.dismiss();
          }
        }
        if ((paramp instanceof ay))
        {
          AppMethodBeat.o(65896);
          return true;
        }
      }
    }
    AppMethodBeat.o(65896);
    return false;
  }
  
  public void onStop()
  {
    AppMethodBeat.i(65885);
    super.onStop();
    removeSceneEndListener(1970);
    AppMethodBeat.o(65885);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(284591);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(LuckyMoneyPrepareUI.LuckyMoneyPrepareUIAccessibilityConfig.class);
    AppMethodBeat.o(284591);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI
 * JD-Core Version:    0.7.0.1
 */