package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Activity;
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
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.api.ac.a;
import com.tencent.mm.api.r;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.f.a.qg;
import com.tencent.mm.f.a.vw;
import com.tencent.mm.f.b.a.jk;
import com.tencent.mm.f.b.a.jl;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.luckymoney.model.ai;
import com.tencent.mm.plugin.luckymoney.model.an;
import com.tencent.mm.plugin.luckymoney.model.as;
import com.tencent.mm.plugin.luckymoney.model.at;
import com.tencent.mm.plugin.luckymoney.model.ax;
import com.tencent.mm.plugin.luckymoney.model.bb;
import com.tencent.mm.plugin.luckymoney.model.bc;
import com.tencent.mm.plugin.luckymoney.model.bg;
import com.tencent.mm.plugin.luckymoney.model.bh;
import com.tencent.mm.plugin.luckymoney.model.k;
import com.tencent.mm.plugin.luckymoney.model.x;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
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
import com.tencent.mm.protocal.protobuf.amr;
import com.tencent.mm.protocal.protobuf.cda;
import com.tencent.mm.protocal.protobuf.cjf;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.wallet_core.c.m;
import com.tencent.mm.wallet_core.ui.MMScrollView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tenpay.android.wechat.MyKeyboardWindow;
import java.math.RoundingMode;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class LuckyMoneyPrepareUI
  extends LuckyMoneyBaseUI
  implements h
{
  private static final String EuI;
  private int EBz;
  private LuckyMoneyMoneyInputView ECQ;
  private View ECR;
  private View ECS;
  private ViewGroup ECT;
  private String ECU;
  private int ECV;
  private boolean ECW;
  private String ECX;
  private a EHK;
  private View EHL;
  private ViewGroup EHW;
  private jk EHY;
  private int EIb;
  private int EKT;
  private String ELa;
  private String ELd;
  private Dialog EML;
  private Dialog EMM;
  private RelativeLayout EMN;
  private TextView EMO;
  private TextView EMP;
  private ImageView EMQ;
  private ImageView EMR;
  private ImageView EMS;
  private TextView EMT;
  private ViewGroup EMU;
  private TextView EMV;
  private ViewGroup EMW;
  private TextView EMX;
  private ImageView EMY;
  private TextView EMZ;
  private boolean ENA;
  private boolean ENB;
  private boolean ENC;
  private boolean ENE;
  private IListener<vw> ENF;
  private ViewGroup ENa;
  private WeImageView ENb;
  private TextView ENc;
  private int ENd;
  private String ENe;
  private String ENf;
  private RealnameGuideHelper ENg;
  private String ENh;
  private String ENi;
  private String ENj;
  private jl ENk;
  private int ENl;
  private String ENm;
  private String ENn;
  private boolean ENo;
  private boolean ENp;
  private boolean ENq;
  private boolean ENr;
  private boolean ENs;
  private int ENt;
  private String ENu;
  private int ENv;
  private long ENw;
  private long ENx;
  private String ENy;
  private com.tencent.mm.ui.widget.f ENz;
  private com.tencent.mm.plugin.luckymoney.model.o EtY;
  private LuckyMoneyNumInputView EuJ;
  private LuckyMoneyTextInputView EuL;
  private Button EuM;
  private MMScrollView EuP;
  private TextView EuQ;
  private c EuS;
  private String ExZ;
  private com.tencent.mm.plugin.luckymoney.model.h EyX;
  private int Eyo;
  private int fRV;
  private int jaR;
  private int mChannel;
  protected View mKBLayout;
  protected MyKeyboardWindow mKeyboard;
  private boolean mKindaEnable;
  private IListener<qg> mPayLoopInterruptListener;
  private String mSessionId;
  private int mType;
  private MTimerHandler ndv;
  private TextView qCM;
  private ChatFooterPanel rzI;
  private TextView tZC;
  public Dialog tipDialog;
  private EmojiInfo uIz;
  private Button uOZ;
  
  static
  {
    AppMethodBeat.i(270884);
    EuI = "https://" + WeChatHosts.domainString(a.i.host_kf_qq_com) + "/touch/scene_product.html?scene_id=kf7";
    AppMethodBeat.o(270884);
  }
  
  public LuckyMoneyPrepareUI()
  {
    AppMethodBeat.i(65882);
    this.EuJ = null;
    this.ECQ = null;
    this.EuL = null;
    this.tZC = null;
    this.EuM = null;
    this.uOZ = null;
    this.tipDialog = null;
    this.EML = null;
    this.EMM = null;
    this.EuS = new c();
    this.ndv = null;
    this.ENd = 1;
    this.ENe = com.tencent.mm.wallet_core.ui.g.bCn("CNY");
    this.ENf = null;
    this.ExZ = "";
    this.EKT = 1;
    this.EIb = 0;
    this.ENo = false;
    this.ENq = false;
    this.ENr = false;
    this.ENs = false;
    this.mPayLoopInterruptListener = new LuckyMoneyPrepareUI.1(this);
    this.ENA = false;
    this.ENB = false;
    this.ENC = false;
    this.ENE = false;
    this.ENF = new IListener() {};
    this.fRV = 0;
    this.ELd = "";
    AppMethodBeat.o(65882);
  }
  
  private void C(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(65897);
    this.EuL.C(paramEmojiInfo);
    if ((this.EIb == 0) || (this.EIb == 2)) {
      if (com.tencent.mm.plugin.emoji.i.b.z(paramEmojiInfo)) {
        this.EKT = 2;
      }
    }
    for (;;)
    {
      this.EHY = new jk();
      this.EHY.gCd = 1L;
      this.EHY.bpa();
      AppMethodBeat.o(65897);
      return;
      if (com.tencent.mm.plugin.emoji.i.b.x(paramEmojiInfo))
      {
        this.EKT = 4;
      }
      else
      {
        this.EKT = 3;
        continue;
        if (this.EIb == 1) {
          this.EKT = 2;
        }
      }
    }
  }
  
  private void Wm(int paramInt)
  {
    AppMethodBeat.i(270862);
    Log.i("MicroMsg.LuckyMoneyPrepareUI", "update view by mode: %s, %s", new Object[] { Integer.valueOf(this.mType), Integer.valueOf(paramInt) });
    if (paramInt == this.mType)
    {
      AppMethodBeat.o(270862);
      return;
    }
    double d;
    if (this.mType == 0)
    {
      this.EMV.setText(a.i.lucky_money_mode_normal_text);
      this.EMW.setVisibility(8);
      this.EuJ.setVisibility(0);
      this.EMX.setVisibility(0);
      this.qCM.setVisibility(8);
      this.EuS.a(this.EuJ);
      this.EuS.a(this.ECQ);
      this.EuS.a(this.EuL);
      paramInt = this.EuJ.getInput();
      d = this.ECQ.getInput();
      this.ECQ.setType(this.mType);
      this.ECQ.setShowGroupIcon(false);
      this.ECQ.setTitle(getString(a.i.lucky_money_unit_amount_title));
      if ((d > 0.0D) && (paramInt > 0)) {
        this.ECQ.setAmount(com.tencent.mm.wallet_core.ui.g.formatMoney2f(d / paramInt));
      }
      this.ECQ.setMaxAmount(this.EtY.Etv);
      AppMethodBeat.o(270862);
      return;
    }
    int i;
    if (this.mType == 1)
    {
      this.EMV.setText(a.i.lucky_money_mode_lucky_text);
      this.EMW.setVisibility(8);
      this.EuJ.setVisibility(0);
      this.EMX.setVisibility(0);
      this.qCM.setVisibility(8);
      this.EuS.a(this.EuJ);
      this.EuS.a(this.ECQ);
      this.EuS.a(this.EuL);
      i = this.EuJ.getInput();
      d = this.ECQ.getInput();
      this.ECQ.setType(this.mType);
      this.ECQ.setMaxAmount(this.EtY.Etx);
      this.ECQ.setTitle(getString(a.i.lucky_money_total_amount_title));
      this.ECQ.setShowGroupIcon(true);
      if ((paramInt == 3) && (d > 0.0D))
      {
        this.ECQ.setAmount(com.tencent.mm.wallet_core.ui.g.formatMoney2f(d));
        AppMethodBeat.o(270862);
        return;
      }
      if ((d > 0.0D) && (i > 0)) {
        this.ECQ.setAmount(com.tencent.mm.wallet_core.ui.g.formatMoney2f(d * i));
      }
      AppMethodBeat.o(270862);
      return;
    }
    if (this.mType == 3)
    {
      this.EMV.setText(a.i.lucky_money_mode_exclusive_text);
      this.EMW.setVisibility(0);
      this.EuJ.setVisibility(8);
      this.EMX.setVisibility(8);
      this.qCM.setVisibility(8);
      this.EuS.b(this.EuJ);
      this.EuS.a(this.ECQ);
      this.EuS.a(this.EuL);
      i = this.EuJ.getInput();
      d = this.ECQ.getInput();
      this.ECQ.setType(this.mType);
      this.ECQ.setShowGroupIcon(false);
      this.ECQ.setTitle(getString(a.i.lucky_money_total_amount_exclusive_title));
      if ((paramInt != 0) || (d <= 0.0D) || (i <= 0)) {
        break label655;
      }
      this.ECQ.setAmount(com.tencent.mm.wallet_core.ui.g.formatMoney2f(d * i));
    }
    for (;;)
    {
      this.ECQ.setMaxAmount(this.EtY.Etv);
      if (!this.ENp)
      {
        this.EMW.post(new LuckyMoneyPrepareUI.3(this));
        this.ENp = true;
      }
      AppMethodBeat.o(270862);
      return;
      label655:
      if (d > 0.0D) {
        this.ECQ.setAmount(com.tencent.mm.wallet_core.ui.g.formatMoney2f(d));
      }
    }
  }
  
  private void Wn(int paramInt)
  {
    AppMethodBeat.i(270863);
    Log.i("MicroMsg.LuckyMoneyPrepareUI", "doPrePareBtnClick() userConfirmJump:%s", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.plugin.report.service.h.IzE.a(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(eOZ()), Integer.valueOf(4) });
    com.tencent.mm.plugin.report.service.h.IzE.a(15511, new Object[] { Integer.valueOf(this.ENd), Integer.valueOf(2) });
    if (this.ECQ.eOc() != 0)
    {
      com.tencent.mm.ui.base.w.makeText(getContext(), a.i.wallet_balance_save_input_invalid, 0).show();
      AppMethodBeat.o(270863);
      return;
    }
    int i = this.EuJ.getInput();
    double d = this.ECQ.getInput();
    long l2 = 0L;
    long l1;
    if (this.mType == 1)
    {
      l1 = com.tencent.mm.wallet_core.ui.g.G(d);
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHG().aHp().i(356354, Integer.valueOf(i));
      str = this.EuL.getInput().replace("\r", "").replace("\n", "");
      localObject = str;
      if (Util.isNullOrNil(str)) {
        if (!Util.isNullOrNil(this.ENf)) {
          break label355;
        }
      }
    }
    label355:
    for (Object localObject = getString(a.i.lucky_money_default_wish);; localObject = this.ENf)
    {
      hideTenpayKB();
      if (this.jaR != 2) {
        break label364;
      }
      doSceneProgress(new com.tencent.mm.plugin.luckymoney.f2f.a.d(i, (int)l1, this.mType, (int)l2), false);
      eQj();
      AppMethodBeat.o(270863);
      return;
      if (this.mType == 3)
      {
        l1 = com.tencent.mm.wallet_core.ui.g.G(d);
        break;
      }
      l1 = com.tencent.mm.wallet_core.ui.g.G(i * d);
      l2 = com.tencent.mm.wallet_core.ui.g.G(d);
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHG().aHp().i(356353, Integer.valueOf(i));
      break;
    }
    label364:
    String str = getIntent().getStringExtra("key_username");
    if (this.ENd == 1)
    {
      Log.i("MicroMsg.LuckyMoneyPrepareUI", "doPrePareBtnClick() ifGetConfig=%s mUniqueId=%s waitingGetConfig=%s ifAutoRMBPrePareBtn=%s", new Object[] { Boolean.valueOf(this.ENA), Util.nullAsNil(this.ELa), Boolean.valueOf(this.ENB), Boolean.valueOf(this.ENC) });
      if (this.ENA)
      {
        a(paramInt, str, i, l1, l2, (String)localObject);
        AppMethodBeat.o(270863);
        return;
      }
      this.ENC = true;
      this.ENt = paramInt;
      this.ENu = str;
      this.ENv = i;
      this.ENw = l1;
      this.ENx = l2;
      this.ENy = ((String)localObject);
      if (this.EMM != null) {
        this.EMM.show();
      }
      for (;;)
      {
        if (!this.ENB) {
          tT(false);
        }
        AppMethodBeat.o(270863);
        return;
        this.EMM = com.tencent.mm.ui.base.h.a(this, 3, a.j.LuckyMoneyNoAnimDialog, getString(a.i.loading_tips), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(65830);
            Log.i("MicroMsg.LuckyMoneyPrepareUI", "coperationTipDialogNoTransparent onCancel()");
            LuckyMoneyPrepareUI.s(LuckyMoneyPrepareUI.this);
            LuckyMoneyPrepareUI.t(LuckyMoneyPrepareUI.this);
            if ((LuckyMoneyPrepareUI.u(LuckyMoneyPrepareUI.this) != null) && (LuckyMoneyPrepareUI.u(LuckyMoneyPrepareUI.this).isShowing())) {
              LuckyMoneyPrepareUI.u(LuckyMoneyPrepareUI.this).dismiss();
            }
            if ((LuckyMoneyPrepareUI.v(LuckyMoneyPrepareUI.this).getVisibility() == 8) || (LuckyMoneyPrepareUI.w(LuckyMoneyPrepareUI.this).getVisibility() == 4))
            {
              Log.i("MicroMsg.LuckyMoneyPrepareUI", "usr cancel, & visibility not visiable, so finish");
              LuckyMoneyPrepareUI.this.finish();
            }
            LuckyMoneyPrepareUI.this.EGu.forceCancel();
            AppMethodBeat.o(65830);
          }
        });
      }
    }
    Log.i("MicroMsg.LuckyMoneyPrepareUI", "currency=%s userConfiremJump:%s", new Object[] { Integer.valueOf(this.ENd), Integer.valueOf(paramInt) });
    addSceneEndListener(1647);
    if ((this.ECW) && (!Util.isNullOrNil(str))) {}
    for (localObject = new at(i, l1, l2, this.mType, (String)localObject, str, com.tencent.mm.plugin.luckymoney.model.ag.eOH(), z.bcZ(), this.ENd);; localObject = new at(i, l1, l2, this.mType, (String)localObject, null, com.tencent.mm.plugin.luckymoney.model.ag.eOH(), z.bcZ(), this.ENd))
    {
      doSceneProgress((com.tencent.mm.an.q)localObject, false);
      break;
    }
  }
  
  private static void a(int paramInt, double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(270869);
    if (paramBoolean)
    {
      Log.i("MicroMsg.LuckyMoneyPrepareUI", "has showing error tips, ignore repeat report");
      AppMethodBeat.o(270869);
      return;
    }
    int i = (int)paramDouble * 100;
    Log.i("MicroMsg.LuckyMoneyPrepareUI", "report scene = " + paramInt + " amount =" + i);
    com.tencent.mm.plugin.report.service.h.IzE.a(22775, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    AppMethodBeat.o(270869);
  }
  
  private void a(int paramInt1, String paramString1, int paramInt2, long paramLong1, long paramLong2, String paramString2)
  {
    AppMethodBeat.i(270866);
    String str2 = "";
    int i = 0;
    if (this.uIz != null)
    {
      str2 = this.uIz.getMd5();
      i = this.uIz.field_type;
    }
    String str1 = "";
    if (this.EyX != null) {
      str1 = this.EyX.EyA;
    }
    Log.i("MicroMsg.LuckyMoneyPrepareUI", "currency is RMB. userConfirmJump:%s lastPayResult:%s mSendId:%s mUniqueId:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(this.fRV), this.ExZ, this.ELa });
    if (com.tencent.mm.plugin.luckymoney.model.ag.PS(getIntent().getStringExtra("key_username")))
    {
      Log.i("MicroMsg.LuckyMoneyPrepareUI", "doRMBPrePareBtnClick use rtx luckmoney");
      if ((this.ECW) && (!Util.isNullOrNil(paramString1))) {}
      for (paramString1 = new bc(paramInt2, paramLong1, paramLong2, this.mType, paramString2, com.tencent.mm.plugin.luckymoney.model.ag.eOH(), paramString1, com.tencent.mm.plugin.luckymoney.model.ag.PI(paramString1), z.bcZ(), z.bdb(), this.Eyo, str1, this.ELa, paramInt1, this.fRV, this.ExZ, str2, i);; paramString1 = new bc(paramInt2, paramLong1, paramLong2, this.mType, paramString2, com.tencent.mm.plugin.luckymoney.model.ag.eOH(), null, null, z.bcZ(), z.bdb(), this.Eyo, str1, this.ELa, paramInt1, this.fRV, this.ExZ, str2, i))
      {
        doSceneProgress(paramString1, false);
        if (!Util.isNullOrNil(str1)) {
          com.tencent.mm.plugin.report.service.h.IzE.el(991, 11);
        }
        eQj();
        AppMethodBeat.o(270866);
        return;
      }
    }
    if (this.jaR == 3)
    {
      String str3 = getIntent().getStringExtra("key_live_id");
      String str4 = getIntent().getStringExtra("key_live_attach");
      int j = getIntent().getIntExtra("key_live_anchor_type", 0);
      paramString1 = new com.tencent.mm.plugin.luckymoney.model.a.c(paramInt2, paramLong1, paramLong2, this.mType, paramString2, com.tencent.mm.plugin.luckymoney.model.ag.eOH(), com.tencent.mm.plugin.luckymoney.model.ag.PI(paramString1), z.bcZ(), z.bdb(), this.Eyo, str1, this.ELa, paramInt1, this.fRV, this.ExZ, str2, i, this.ENj, str3, str4, j);
    }
    for (;;)
    {
      doSceneProgress(paramString1, false);
      break;
      Log.i("MicroMsg.LuckyMoneyPrepareUI", "doRMBPrePareBtnClick use normal luckmoney");
      if ((this.ECW) && (!Util.isNullOrNil(paramString1))) {
        paramString1 = new bb(paramInt2, paramLong1, paramLong2, this.mType, paramString2, com.tencent.mm.plugin.luckymoney.model.ag.eOH(), paramString1, com.tencent.mm.plugin.luckymoney.model.ag.PI(paramString1), z.bcZ(), z.bdb(), this.Eyo, str1, this.ELa, paramInt1, this.fRV, this.ExZ, str2, i, this.ENj);
      } else {
        paramString1 = new bb(paramInt2, paramLong1, paramLong2, this.mType, paramString2, com.tencent.mm.plugin.luckymoney.model.ag.eOH(), null, null, z.bcZ(), z.bdb(), this.Eyo, str1, this.ELa, paramInt1, this.fRV, this.ExZ, str2, i, this.ENj);
      }
    }
  }
  
  private void aNR(String paramString)
  {
    AppMethodBeat.i(65898);
    Log.i("MicroMsg.LuckyMoneyPrepareUI", "initH5LuckyMoneyView  currencyWording=".concat(String.valueOf(paramString)));
    TextView localTextView = (TextView)findViewById(a.f.lucky_money_amount_unit_title);
    if (!Util.isNullOrNil(paramString))
    {
      localTextView.setText(paramString);
      AppMethodBeat.o(65898);
      return;
    }
    localTextView.setText(getString(a.i.lucky_money_amount_unit_title));
    AppMethodBeat.o(65898);
  }
  
  private void aNS(String paramString)
  {
    AppMethodBeat.i(65911);
    Log.i("MicroMsg.LuckyMoneyPrepareUI", "do business callback");
    if (com.tencent.mm.plugin.luckymoney.model.ag.PS(getIntent().getStringExtra("key_username")))
    {
      doSceneProgress(new com.tencent.mm.plugin.luckymoney.model.ao(this.ExZ, paramString, this.ENh), false);
      AppMethodBeat.o(65911);
      return;
    }
    doSceneProgress(new an(this.ExZ, paramString, this.ENh), false);
    AppMethodBeat.o(65911);
  }
  
  private void b(double paramDouble, String paramString)
  {
    AppMethodBeat.i(65908);
    if (Util.isNullOrNil(paramString))
    {
      this.tZC.setText(com.tencent.mm.wallet_core.ui.g.F(paramDouble));
      AppMethodBeat.o(65908);
      return;
    }
    this.tZC.setText(paramString + com.tencent.mm.wallet_core.ui.g.formatMoney2f(paramDouble));
    AppMethodBeat.o(65908);
  }
  
  private void b(cjf paramcjf)
  {
    AppMethodBeat.i(65892);
    Log.i("MicroMsg.LuckyMoneyPrepareUI", "update envelope");
    if ((this.EyX != null) && (paramcjf != null) && (this.jaR != 2))
    {
      this.EMN.setVisibility(0);
      boolean bool = com.tencent.mm.aa.c.aFn().a(ar.a.Vtv, ar.a.Vtx);
      Object localObject;
      if (!this.ENo)
      {
        localObject = com.tencent.mm.plugin.report.service.h.IzE;
        if (!bool) {
          break label234;
        }
      }
      label234:
      for (int i = 2;; i = 1)
      {
        ((com.tencent.mm.plugin.report.service.h)localObject).a(18890, new Object[] { Integer.valueOf(1), Integer.valueOf(i), this.mSessionId });
        this.ENo = true;
        if ((!this.EyX.EyB) || (Util.isNullOrNil(this.EyX.EyC))) {
          break label336;
        }
        localObject = Util.stringToList((String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VtA, ""), ",");
        Iterator localIterator = ((List)localObject).iterator();
        String str;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          str = (String)localIterator.next();
        } while (!str.equals(this.EyX.Eyz.SpP));
        Log.d("MicroMsg.LuckyMoneyPrepareUI", "has alert illegal: %s", new Object[] { str });
        AppMethodBeat.o(65892);
        return;
      }
      ((List)localObject).add(this.EyX.Eyz.SpP);
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VtA, Util.listToString((List)localObject, ","));
      Log.i("MicroMsg.LuckyMoneyPrepareUI", "show alert illegal: %s", new Object[] { this.EyX.Eyz.SpP });
      com.tencent.mm.ui.base.h.a(getContext(), this.EyX.EyC, "", getString(a.i.welcome_i_know), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      label336:
      if ((paramcjf == null) || (paramcjf.TqC != 1)) {
        break label450;
      }
      this.EMN.setEnabled(false);
      if (!Util.isNullOrNil(paramcjf.TqD)) {
        this.EMO.setText(paramcjf.TqD);
      }
      this.EMQ.setImageBitmap(null);
      this.EMR.setVisibility(8);
      this.EMO.setTextColor(getResources().getColor(a.c.BW_0_Alpha_0_3));
    }
    for (;;)
    {
      if ((paramcjf == null) || (paramcjf.llL != 2)) {
        break label584;
      }
      this.EMP.setVisibility(0);
      AppMethodBeat.o(65892);
      return;
      this.EMN.setVisibility(8);
      break;
      label450:
      if ((paramcjf != null) && (!Util.isNullOrNil(paramcjf.Tqn)))
      {
        this.EMN.setEnabled(true);
        this.EMO.setText(paramcjf.Tqn);
        ((com.tencent.mm.plugin.luckymoney.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.luckymoney.a.a.class)).a(this.EMQ, paramcjf);
        this.EMR.setVisibility(0);
        this.EMO.setTextColor(getResources().getColor(a.c.black_per90));
      }
      else
      {
        this.EMN.setEnabled(true);
        this.EMQ.setImageBitmap(null);
        this.EMO.setText("");
        this.EMR.setVisibility(0);
        this.EMO.setTextColor(getResources().getColor(a.c.black_per90));
      }
    }
    label584:
    this.EMP.setVisibility(8);
    AppMethodBeat.o(65892);
  }
  
  private int eOZ()
  {
    AppMethodBeat.i(65909);
    if (this.ECW)
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
  
  private void eQi()
  {
    AppMethodBeat.i(270861);
    Log.i("MicroMsg.LuckyMoneyPrepareUI", "init custom envelope entrance: %s", new Object[] { Integer.valueOf(((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vtf, Integer.valueOf(0))).intValue()) });
    if ((this.EtY == null) || (this.EtY.EyW == null) || (this.jaR == 2))
    {
      this.ENa.setVisibility(8);
      AppMethodBeat.o(270861);
      return;
    }
    if (!Util.isNullOrNil(this.EtY.EyW.wording))
    {
      this.ENc.setText(this.EtY.EyW.wording);
      int i = com.tencent.mm.ci.a.kr(getContext()) - com.tencent.mm.ci.a.fromDPToPix(getContext(), 70);
      if (i > 0) {
        this.ENc.setMaxWidth(i);
      }
      this.ENa.setVisibility(0);
      this.ENs = true;
      if (!Util.isNullOrNil(this.EtY.EyW.ufC))
      {
        Object localObject = new c.a();
        com.tencent.mm.plugin.luckymoney.b.a.eNR();
        ((c.a)localObject).prefixPath = com.tencent.mm.plugin.luckymoney.b.a.eNV();
        com.tencent.mm.ay.q.bmm();
        ((c.a)localObject).lRV = null;
        ((c.a)localObject).lRD = true;
        ((c.a)localObject).kPz = false;
        ((c.a)localObject).lRB = true;
        localObject = ((c.a)localObject).bmL();
        com.tencent.mm.ay.q.bml().a(this.EtY.EyW.ufC, this.ENb, (com.tencent.mm.ay.a.a.c)localObject);
      }
      this.ENa.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(266874);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          Log.i("MicroMsg.LuckyMoneyPrepareUI", "jump to action type: %s", new Object[] { Integer.valueOf(LuckyMoneyPrepareUI.h(LuckyMoneyPrepareUI.this).EyW.tpK) });
          switch (LuckyMoneyPrepareUI.h(LuckyMoneyPrepareUI.this).EyW.tpK)
          {
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(266874);
            return;
            com.tencent.mm.wallet_core.ui.g.p(LuckyMoneyPrepareUI.this.getContext(), LuckyMoneyPrepareUI.h(LuckyMoneyPrepareUI.this).EyW.EyH, false);
            continue;
            com.tencent.mm.wallet_core.ui.g.am(LuckyMoneyPrepareUI.this.getContext(), LuckyMoneyPrepareUI.h(LuckyMoneyPrepareUI.this).EyW.EyI);
            continue;
            com.tencent.mm.wallet_core.ui.g.v(LuckyMoneyPrepareUI.h(LuckyMoneyPrepareUI.this).EyW.EyI, LuckyMoneyPrepareUI.h(LuckyMoneyPrepareUI.this).EyW.EyH, 0, 1100);
            continue;
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("finder_username", LuckyMoneyPrepareUI.h(LuckyMoneyPrepareUI.this).EyW.EyI);
            ((ak)com.tencent.mm.kernel.h.ag(ak.class)).enterFinderProfileUI(LuckyMoneyPrepareUI.this.getContext(), paramAnonymousView);
            continue;
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("extra_id", LuckyMoneyPrepareUI.h(LuckyMoneyPrepareUI.this).EyW.EyI);
            paramAnonymousView.putExtra("preceding_scence", 21);
            com.tencent.mm.by.c.b(LuckyMoneyPrepareUI.this.getContext(), "emoji", ".ui.EmojiStoreDetailUI", paramAnonymousView);
          }
        }
      });
      AppMethodBeat.o(270861);
      return;
    }
    this.ENa.setVisibility(8);
    AppMethodBeat.o(270861);
  }
  
  private void eQj()
  {
    AppMethodBeat.i(270864);
    if (this.tipDialog != null)
    {
      this.tipDialog.show();
      AppMethodBeat.o(270864);
      return;
    }
    this.tipDialog = com.tencent.mm.wallet_core.ui.i.a(getContext(), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(216628);
        if ((LuckyMoneyPrepareUI.x(LuckyMoneyPrepareUI.this) != null) && (LuckyMoneyPrepareUI.x(LuckyMoneyPrepareUI.this).isShowing())) {
          LuckyMoneyPrepareUI.x(LuckyMoneyPrepareUI.this).dismiss();
        }
        if ((LuckyMoneyPrepareUI.y(LuckyMoneyPrepareUI.this).getVisibility() == 8) || (LuckyMoneyPrepareUI.z(LuckyMoneyPrepareUI.this).getVisibility() == 4))
        {
          Log.i("MicroMsg.LuckyMoneyPrepareUI", "usr cancel, & visibility not visiable, so finish");
          LuckyMoneyPrepareUI.this.finish();
        }
        LuckyMoneyPrepareUI.this.EGu.forceCancel();
        AppMethodBeat.o(216628);
      }
    });
    this.tipDialog.setCancelable(false);
    AppMethodBeat.o(270864);
  }
  
  private boolean eQk()
  {
    AppMethodBeat.i(65907);
    if ((this.EtY != null) && (!Util.isNullOrNil(this.EtY.EyS)))
    {
      AppMethodBeat.o(65907);
      return true;
    }
    AppMethodBeat.o(65907);
    return false;
  }
  
  private void h(int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(65899);
    String str1 = getIntent().getStringExtra("key_username");
    String str2 = z.bcZ();
    if (paramInt == -1)
    {
      Log.i("MicroMsg.LuckyMoneyPrepareUI", "onActivityResult() resultCode == RESULT_OK");
      this.fRV = 1;
      this.ELd = "";
      paramIntent = new ax(this.ExZ, this.ELa, 1, str2, Util.nullAsNil(str1));
      com.tencent.mm.kernel.h.aHF().kcd.a(paramIntent, 0);
      AppMethodBeat.o(65899);
      return;
    }
    if (paramIntent != null) {}
    for (this.fRV = paramIntent.getIntExtra("key_pay_reslut_type", 3);; this.fRV = 3)
    {
      this.ELd = this.ExZ;
      Log.i("MicroMsg.LuckyMoneyPrepareUI", "onActivityResult() resultCode != RESULT_OK  payType:%s", new Object[] { Integer.valueOf(this.fRV) });
      paramIntent = new ax(this.ExZ, this.ELa, this.fRV, str2, Util.nullAsNil(str1));
      break;
      Log.i("MicroMsg.LuckyMoneyPrepareUI", "doNetSceneLuckyMoneyReport() data == null");
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(65891);
    if (this.ENd == 1) {
      addIconOptionMenu(0, a.i.app_more, a.h.icons_outlined_more, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(65832);
          LuckyMoneyPrepareUI.A(LuckyMoneyPrepareUI.this);
          AppMethodBeat.o(65832);
          return true;
        }
      });
    }
    for (;;)
    {
      eQi();
      AppMethodBeat.o(65891);
      return;
      addIconOptionMenu(0, a.i.wallet_index_ui_opt_common_questions, a.e.lucky_money_help_btn, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(272491);
          if ((LuckyMoneyPrepareUI.h(LuckyMoneyPrepareUI.this) != null) && (!Util.isNullOrNil(LuckyMoneyPrepareUI.h(LuckyMoneyPrepareUI.this).EyR))) {
            com.tencent.mm.wallet_core.ui.g.p(LuckyMoneyPrepareUI.this.getContext(), LuckyMoneyPrepareUI.h(LuckyMoneyPrepareUI.this).EyR, false);
          }
          for (;;)
          {
            AppMethodBeat.o(272491);
            return true;
            com.tencent.mm.wallet_core.ui.g.p(LuckyMoneyPrepareUI.this.getContext(), "https://hkwallet.moneydata.hk/hybrid/www/weixin/hongbao_hk_v2/zh_hk/faq.shtml", false);
          }
        }
      });
    }
  }
  
  private void tT(boolean paramBoolean)
  {
    AppMethodBeat.i(65894);
    Log.i("MicroMsg.LuckyMoneyPrepareUI", "do get config");
    if (paramBoolean) {
      this.EML = com.tencent.mm.plugin.luckymoney.model.ag.hs(getContext());
    }
    this.ENB = true;
    if (com.tencent.mm.plugin.luckymoney.model.ag.PS(getIntent().getStringExtra("key_username")))
    {
      i = ((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vtz, Integer.valueOf(0))).intValue();
      this.ENl = i;
      doSceneProgress(new as("v1.0", i), false);
      AppMethodBeat.o(65894);
      return;
    }
    if (this.jaR == 3)
    {
      i = ((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vty, Integer.valueOf(0))).intValue();
      this.ENl = i;
      doSceneProgress(new com.tencent.mm.plugin.luckymoney.model.a.a("v1.0", i), false);
      AppMethodBeat.o(65894);
      return;
    }
    int i = ((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vty, Integer.valueOf(0))).intValue();
    this.ENl = i;
    doSceneProgress(new com.tencent.mm.plugin.luckymoney.model.ar("v1.0", i), false);
    AppMethodBeat.o(65894);
  }
  
  protected final void ao(final View paramView, final int paramInt)
  {
    AppMethodBeat.i(65903);
    this.mKeyboard = ((MyKeyboardWindow)findViewById(a.f.tenpay_num_keyboard));
    this.mKBLayout = findViewById(a.f.tenpay_keyboard_layout);
    View localView = findViewById(a.f.tenpay_push_down);
    final EditText localEditText = (EditText)paramView.findViewById(a.f.lucky_money_et);
    if ((this.mKeyboard == null) || (localEditText == null) || (this.mKBLayout == null))
    {
      AppMethodBeat.o(65903);
      return;
    }
    com.tencent.mm.wallet_core.ui.g.setNoSystemInputOnEditText(localEditText);
    localEditText.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      boolean firstTime = true;
      
      public final void onFocusChange(final View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(200506);
        if ((paramAnonymousView.isFocused()) && (!this.val$isShowSysKB))
        {
          ((InputMethodManager)LuckyMoneyPrepareUI.this.getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramAnonymousView.getWindowToken(), 0);
          new MMHandler().postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(258436);
              if ((!LuckyMoneyPrepareUI.this.mKBLayout.isShown()) && (paramAnonymousView.isShown()))
              {
                LuckyMoneyPrepareUI.this.mKBLayout.setVisibility(0);
                LuckyMoneyPrepareUI.M(LuckyMoneyPrepareUI.this).setVisibility(8);
              }
              LuckyMoneyPrepareUI.d(LuckyMoneyPrepareUI.this, LuckyMoneyPrepareUI.38.this.val$editMode);
              LuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText)paramAnonymousView);
              ((InputMethodManager)LuckyMoneyPrepareUI.this.getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramAnonymousView.getWindowToken(), 0);
              AppMethodBeat.o(258436);
            }
          }, 300L);
          AppMethodBeat.o(200506);
          return;
        }
        new MMHandler().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(277139);
            LuckyMoneyPrepareUI.M(LuckyMoneyPrepareUI.this).setVisibility(0);
            LuckyMoneyPrepareUI.this.hideTenpayKB();
            ((InputMethodManager)LuckyMoneyPrepareUI.this.getContext().getSystemService("input_method")).showSoftInput(LuckyMoneyPrepareUI.38.this.val$hintTv, 0);
            AppMethodBeat.o(277139);
          }
        }, 200L);
        AppMethodBeat.o(200506);
      }
    });
    localEditText.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(65875);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$45", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if ((!LuckyMoneyPrepareUI.this.mKBLayout.isShown()) && (!this.val$isShowSysKB))
        {
          LuckyMoneyPrepareUI.this.mKBLayout.setVisibility(0);
          LuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText)paramAnonymousView);
          LuckyMoneyPrepareUI.d(LuckyMoneyPrepareUI.this, paramInt);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$45", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(65875);
          return;
          if (this.val$isShowSysKB)
          {
            LuckyMoneyPrepareUI.this.mKBLayout.setVisibility(8);
            LuckyMoneyPrepareUI.M(LuckyMoneyPrepareUI.this).setVisibility(0);
            ((InputMethodManager)LuckyMoneyPrepareUI.this.getContext().getSystemService("input_method")).showSoftInput(localEditText, 0);
          }
        }
      }
    });
    TextView localTextView = (TextView)paramView.findViewById(a.f.lucky_money_amount_unit_title);
    if (localTextView != null) {
      localTextView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(65876);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$46", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if ((LuckyMoneyPrepareUI.this.mKBLayout.isShown()) && (!this.val$isShowSysKB)) {
            if (LuckyMoneyPrepareUI.this.mKeyboard != null) {
              LuckyMoneyPrepareUI.this.mKeyboard.setInputEditText(localEditText);
            }
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$46", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(65876);
            return;
            if ((!LuckyMoneyPrepareUI.this.mKBLayout.isShown()) && (!this.val$isShowSysKB))
            {
              ((InputMethodManager)LuckyMoneyPrepareUI.this.getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramAnonymousView.getWindowToken(), 0);
              new MMHandler().postDelayed(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(269552);
                  LuckyMoneyPrepareUI.this.mKBLayout.setVisibility(0);
                  LuckyMoneyPrepareUI.40.this.val$parent.requestFocus();
                  if (LuckyMoneyPrepareUI.this.mKeyboard != null) {
                    LuckyMoneyPrepareUI.this.mKeyboard.setInputEditText(LuckyMoneyPrepareUI.40.this.val$hintTv);
                  }
                  LuckyMoneyPrepareUI.d(LuckyMoneyPrepareUI.this, LuckyMoneyPrepareUI.40.this.val$editMode);
                  AppMethodBeat.o(269552);
                }
              }, 200L);
            }
            else if (this.val$isShowSysKB)
            {
              LuckyMoneyPrepareUI.this.mKBLayout.setVisibility(8);
              ((InputMethodManager)LuckyMoneyPrepareUI.this.getContext().getSystemService("input_method")).showSoftInput(localEditText, 0);
            }
          }
        }
      });
    }
    localView.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(267963);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$47", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        LuckyMoneyPrepareUI.this.hideTenpayKB();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$47", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(267963);
      }
    });
    AppMethodBeat.o(65903);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(65895);
    if ((paramKeyEvent.getKeyCode() == 4) && (this.ECR.getVisibility() == 0))
    {
      this.ECR.setVisibility(8);
      ePA();
      AppMethodBeat.o(65895);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(65895);
    return bool;
  }
  
  public final void eOd()
  {
    AppMethodBeat.i(65906);
    double d2 = 0.0D;
    double d3 = 0.0D;
    double d1;
    if (com.tencent.mm.plugin.luckymoney.model.ag.PS(getIntent().getStringExtra("key_username")))
    {
      com.tencent.mm.plugin.luckymoney.b.a.eNR();
      this.EtY = com.tencent.mm.plugin.luckymoney.b.a.eNT().eOz();
      if ((this.mType != 3) || (this.ECQ.eOc() == 3)) {
        break label216;
      }
      d1 = this.ECQ.getInput();
      if (!Util.isNullOrNil(this.ENj)) {
        break label203;
      }
      d3 = 0.0D;
      d2 = d1;
      d1 = d3;
    }
    for (;;)
    {
      label86:
      boolean bool3 = this.EuS.EJD;
      if (this.EuS.ePM())
      {
        Log.i("MicroMsg.LuckyMoneyPrepareUI", "has error");
        this.EuM.setClickable(false);
        this.EuM.setEnabled(false);
        if (this.mType == 3) {
          a(1, d2, bool3);
        }
      }
      for (;;)
      {
        b(d2, this.ENe);
        AppMethodBeat.o(65906);
        return;
        if (this.jaR == 3)
        {
          com.tencent.mm.plugin.luckymoney.b.a.eNR();
          this.EtY = com.tencent.mm.plugin.luckymoney.b.a.eNU().eOz();
          break;
        }
        com.tencent.mm.plugin.luckymoney.b.a.eNR();
        this.EtY = com.tencent.mm.plugin.luckymoney.b.a.eNS().eOz();
        break;
        label203:
        d2 = d1;
        d3 = d1;
        d1 = d2;
        d2 = d3;
        break label86;
        label216:
        d1 = d2;
        if (this.mType == 3) {
          break label1297;
        }
        d1 = d2;
        if (this.ECQ.eOc() == 3) {
          break label1297;
        }
        d1 = d2;
        if (this.EuJ.eOc() == 3) {
          break label1297;
        }
        int i = this.EuJ.getInput();
        d2 = this.ECQ.getInput();
        if (this.mType == 0)
        {
          d3 = i;
          d1 = this.ECQ.getInput();
          d2 *= d3;
          break label86;
        }
        d1 = d2;
        if (i <= 0) {
          break label1297;
        }
        d1 = com.tencent.mm.wallet_core.ui.g.a(String.valueOf(d2), String.valueOf(i), String.valueOf(this.EtY.Etu).length() + 2, RoundingMode.HALF_UP);
        break label86;
        if (this.mType == 0)
        {
          a(1, d1, bool3);
        }
        else
        {
          a(2, d2, bool3);
          continue;
          boolean bool2 = false;
          boolean bool1 = false;
          if ((d2 == 0.0D) || (d1 == 0.0D)) {
            bool1 = true;
          }
          for (;;)
          {
            if (bool1)
            {
              this.EuM.setClickable(false);
              this.EuM.setEnabled(false);
              break;
              if ((d2 > this.EtY.Etx) && (this.EtY.Etx > 0.0D))
              {
                this.EuS.amo(getString(a.i.lucky_money_total_amount_max_limit_tips, new Object[] { Math.round(this.EtY.Etx), Util.nullAs(this.EtY.EtA, "") }));
                bool1 = true;
                a(2, d2, bool3);
              }
              else if (d1 > 0.0D)
              {
                Log.i("MicroMsg.LuckyMoneyPrepareUI", "perAmount ".concat(String.valueOf(d1)));
                if (this.mType == 0)
                {
                  bool1 = bool2;
                  if (d1 > this.EtY.Etv)
                  {
                    bool1 = bool2;
                    if (this.EtY.Etv > 0.0D)
                    {
                      if (!eQk()) {
                        break label821;
                      }
                      this.EuS.amo(getString(a.i.lucky_money_per_amount_max_limit_tips_format, new Object[] { this.EtY.EyS, Math.round(this.EtY.Etv), Util.nullAs(this.EtY.EtA, "") }));
                      label645:
                      bool1 = true;
                      a(1, d1, bool3);
                    }
                  }
                  label655:
                  Log.i("MicroMsg.LuckyMoneyPrepareUI", "furtherCheckHasErr:" + bool1 + " for max value");
                  bool2 = bool1;
                  if (!bool1)
                  {
                    if (this.mType != 0) {
                      break label1146;
                    }
                    bool2 = bool1;
                    if (d1 < this.EtY.Etw)
                    {
                      if (!eQk()) {
                        break label1096;
                      }
                      this.EuS.amo(getString(a.i.lucky_money_per_amount_min_limit_tips_format, new Object[] { this.EtY.EyS, com.tencent.mm.wallet_core.ui.g.formatMoney2f(this.EtY.Etw), Util.nullAs(this.EtY.EtA, "") }));
                      label781:
                      bool2 = true;
                    }
                  }
                }
                label821:
                label1096:
                label1146:
                do
                {
                  Log.i("MicroMsg.LuckyMoneyPrepareUI", "furtherCheckHasErr:" + bool2 + " for min value");
                  bool1 = bool2;
                  break;
                  this.EuS.amo(getString(a.i.lucky_money_per_amount_max_limit_tips, new Object[] { Math.round(this.EtY.Etv), Util.nullAs(this.EtY.EtA, "") }));
                  break label645;
                  bool1 = bool2;
                  if (d1 <= this.EtY.Ety) {
                    break label655;
                  }
                  bool1 = bool2;
                  if (this.EtY.Ety <= 0.0D) {
                    break label655;
                  }
                  if ((this.EtY != null) && (!Util.isNullOrNil(this.EtY.EyS))) {
                    this.EuS.amo(getString(a.i.lucky_money_per_amount_max_limit_tips_format, new Object[] { this.EtY.EyS, Math.round(this.EtY.Ety), Util.nullAs(this.EtY.EtA, "") }));
                  }
                  for (;;)
                  {
                    bool1 = true;
                    this.EuJ.onError();
                    this.ECQ.onError();
                    a(1, d1, bool3);
                    break;
                    this.EuS.amo(getString(a.i.lucky_money_per_amount_max_limit_tips, new Object[] { Math.round(this.EtY.Ety), Util.nullAs(this.EtY.EtA, "") }));
                  }
                  this.EuS.amo(getString(a.i.lucky_money_per_amount_min_limit_tips, new Object[] { com.tencent.mm.wallet_core.ui.g.formatMoney2f(this.EtY.Etw), Util.nullAs(this.EtY.EtA, "") }));
                  break label781;
                  bool2 = bool1;
                } while (d1 >= 0.01D);
                if (eQk()) {
                  this.EuS.amo(getString(a.i.lucky_money_per_amount_min_limit_tips_format, new Object[] { this.EtY.EyS, "0.01", Util.nullAs(this.EtY.EtA, "") }));
                }
                for (;;)
                {
                  bool2 = true;
                  this.EuJ.onError();
                  this.ECQ.onError();
                  break;
                  this.EuS.amo(getString(a.i.lucky_money_per_amount_min_limit_tips, new Object[] { "0.01", Util.nullAs(this.EtY.EtA, "") }));
                }
              }
            }
          }
          this.EuM.setClickable(true);
          this.EuM.setEnabled(true);
        }
      }
      label1297:
      d2 = d1;
      d1 = d3;
    }
  }
  
  public void finish()
  {
    AppMethodBeat.i(65910);
    if (this.ENg != null)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("key_realname_guide_helper", this.ENg);
      com.tencent.mm.by.c.b(this, "wallet_core", ".id_verify.RealnameDialogActivity", localIntent);
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
    AppMethodBeat.i(270867);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vUU, 1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.LuckyMoneyPrepareUI", "is open: %s", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        break;
      }
      i = a.g.lucky_money_prepare_ui_2;
      AppMethodBeat.o(270867);
      return i;
    }
    int i = a.g.lucky_money_prepare_ui;
    AppMethodBeat.o(270867);
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
  
  public final void i(int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(65901);
    if (paramInt == -1)
    {
      String str = "";
      if (paramIntent != null) {
        str = paramIntent.getStringExtra("key_trans_id");
      }
      aNS(str);
    }
    finish();
    AppMethodBeat.o(65901);
  }
  
  public void initView()
  {
    AppMethodBeat.i(65886);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(65838);
        LuckyMoneyPrepareUI.this.finish();
        AppMethodBeat.o(65838);
        return true;
      }
    });
    this.ECR = findViewById(a.f.lucky_money_prepare_ready_ll);
    this.ECS = findViewById(a.f.lucky_money_prepare_sent_area);
    this.uOZ = ((Button)findViewById(a.f.lucky_money_prepare_send_btn));
    this.EuL = ((LuckyMoneyTextInputView)findViewById(a.f.lucky_money_wish_et));
    this.EuL.setHintText(getString(a.i.lucky_money_default_wish));
    Object localObject1 = this.EuL;
    Object localObject2 = new com.tencent.mm.wallet_core.ui.e();
    Object localObject3 = ((LuckyMoneyTextInputView)localObject1).Evu.getFilters();
    InputFilter[] arrayOfInputFilter = new InputFilter[localObject3.length + 1];
    System.arraycopy(localObject3, 0, arrayOfInputFilter, 0, localObject3.length);
    arrayOfInputFilter[localObject3.length] = localObject2;
    ((LuckyMoneyTextInputView)localObject1).Evu.setFilters(arrayOfInputFilter);
    this.EuM = ((Button)findViewById(a.f.lucky_money_prepare_btn));
    this.mKeyboard = ((MyKeyboardWindow)findViewById(a.f.tenpay_num_keyboard));
    this.mKBLayout = findViewById(a.f.tenpay_keyboard_layout);
    this.qCM = ((TextView)findViewById(a.f.lucky_money_prepare_amount_tips));
    this.EuJ = ((LuckyMoneyNumInputView)findViewById(a.f.lucky_money_num_et));
    this.ECQ = ((LuckyMoneyMoneyInputView)findViewById(a.f.lucky_money_amount_et));
    this.tZC = ((TextView)findViewById(a.f.lucky_money_prepare_total_amount));
    this.ECT = ((ViewGroup)findViewById(a.f.lucky_money_prepare_opertaion));
    this.EuP = ((MMScrollView)findViewById(a.f.lucky_money_sv));
    this.EuQ = ((TextView)findViewById(a.f.lucky_money_prepare_notice_tips));
    this.EMN = ((RelativeLayout)findViewById(a.f.lucky_money_envelope_layout));
    this.EMO = ((TextView)findViewById(a.f.lucky_money_envelope_tv));
    this.EMP = ((TextView)findViewById(a.f.lucky_money_envelope_temp_label_tv));
    this.EMQ = ((ImageView)findViewById(a.f.lucky_money_envelope_iv));
    this.EMR = ((ImageView)findViewById(a.f.lucky_money_envelope_arrow_iv));
    this.EMS = ((ImageView)findViewById(a.f.lucky_money_envelope_mask_iv));
    this.EMT = ((TextView)findViewById(a.f.lucky_money_envelope_new_tv));
    this.EMU = ((ViewGroup)findViewById(a.f.lucky_money_mode_layout));
    this.EMV = ((TextView)findViewById(a.f.lucky_money_mode_title_tv));
    this.EMW = ((ViewGroup)findViewById(a.f.lucky_money_exclusive_layout));
    this.EMX = ((TextView)findViewById(a.f.lucky_money_prepare_num_tips));
    this.EMY = ((ImageView)findViewById(a.f.lucky_money_exclusive_avatar_iv));
    this.EMZ = ((TextView)findViewById(a.f.lucky_money_exclusive_username_tv));
    this.ENa = ((ViewGroup)findViewById(a.f.lucky_money_custom_envelope_entrance_layout));
    this.ENb = ((WeImageView)findViewById(a.f.lucky_money_custom_envelope_entrance_icon_iv));
    this.ENc = ((TextView)findViewById(a.f.lucky_money_custom_envelope_entrance_title_tv));
    this.EHK = new a(this);
    this.EHL = getLayoutInflater().inflate(a.g.lucky_money_emoji_dialog, null);
    this.EHK.setContentView(this.EHL, new ViewGroup.LayoutParams(-1, -1));
    this.EHL.findViewById(a.f.lucky_money_emoji_dismiss_area).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(65851);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        LuckyMoneyPrepareUI.a(LuckyMoneyPrepareUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(65851);
      }
    });
    this.EHK.EFM = new a.a()
    {
      public final void ePv()
      {
        AppMethodBeat.i(65865);
        LuckyMoneyPrepareUI.a(LuckyMoneyPrepareUI.this);
        AppMethodBeat.o(65865);
      }
    };
    this.EHW = ((ViewGroup)this.EHL.findViewById(a.f.lucky_money_emoji_root));
    this.rzI = com.tencent.mm.pluginsdk.ui.chat.e.RnO.fd(getContext());
    this.ENi = getIntent().getStringExtra("key_username");
    this.rzI.setTalkerName(this.ENi);
    this.rzI.setShowSmiley(false);
    label715:
    label862:
    label886:
    int i;
    if (this.mType == 1)
    {
      setMMTitle(a.i.lucky_money_group);
      this.ECQ.setTitle(getString(a.i.lucky_money_total_amount_title));
      this.ECQ.setShowGroupIcon(true);
      if (!com.tencent.mm.plugin.luckymoney.model.ag.PS(getIntent().getStringExtra("key_username"))) {
        break label1646;
      }
      this.ECQ.setRtxLuckyMoney(1);
      localObject1 = new LinearLayout.LayoutParams(-1, -1);
      localObject2 = new LinearLayout.LayoutParams(-1, com.tencent.mm.ci.a.aY(this, a.d.lucky_money_input_view_height));
      if (this.mType != 1) {
        break label1676;
      }
      ((LinearLayout.LayoutParams)localObject1).topMargin = com.tencent.mm.ci.a.fromDPToPix(getContext(), 13);
      ((LinearLayout.LayoutParams)localObject2).topMargin = com.tencent.mm.ci.a.fromDPToPix(getContext(), 13);
      label777:
      this.EuL.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      this.EMN.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      this.ECQ.setOnInputValidChangerListener(this);
      this.ECQ.setHint(getString(a.i.lucky_money_money_hint));
      this.EuJ.setOnInputValidChangerListener(this);
      this.EuJ.setHint(getString(a.i.lucky_money_num_hint));
      if (!com.tencent.mm.plugin.luckymoney.model.ag.PS(getIntent().getStringExtra("key_username"))) {
        break label1706;
      }
      this.EuJ.setRtxLuckyMoney(1);
      this.EuL.setOnInputValidChangerListener(this);
      if (!com.tencent.mm.ui.ar.isDarkMode()) {
        break label1736;
      }
      this.EMS.setImageResource(a.e.lucky_money_prepare_envelope_mask_dark_mode);
      localObject1 = (EditText)this.ECQ.findViewById(a.f.lucky_money_et);
      localObject2 = (EditText)this.EuJ.findViewById(a.f.lucky_money_et);
      com.tencent.mm.wallet_core.ui.g.setNoSystemInputOnEditText((EditText)localObject1);
      ((InputMethodManager)getContext().getSystemService("input_method")).showSoftInput((View)localObject1, 0);
      ((EditText)localObject1).addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(65839);
          String str = paramAnonymousEditable.toString();
          int i;
          int j;
          if (str.startsWith("."))
          {
            paramAnonymousEditable.insert(0, "0");
            str = paramAnonymousEditable.toString();
            i = str.indexOf(".");
            j = str.length();
            if ((i < 0) || (j - i <= 3)) {
              break label108;
            }
            paramAnonymousEditable.delete(i + 3, j);
          }
          for (;;)
          {
            this.val$hintTv.setContentDescription(paramAnonymousEditable.toString());
            AppMethodBeat.o(65839);
            return;
            if (!WalletFormView.a(str, this.val$hintTv)) {
              break;
            }
            AppMethodBeat.o(65839);
            return;
            label108:
            if (i > 6) {
              paramAnonymousEditable.delete(6, i);
            } else if ((i == -1) && (j > 6)) {
              paramAnonymousEditable.delete(6, j);
            }
          }
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      ((EditText)localObject2).addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(195930);
          this.EuU.setContentDescription(paramAnonymousEditable.toString());
          AppMethodBeat.o(195930);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      ((EditText)localObject1).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(65841);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          this.val$hintTv.setOnClickListener(null);
          this.EuU.setOnClickListener(null);
          LuckyMoneyPrepareUI.this.ao(LuckyMoneyPrepareUI.d(LuckyMoneyPrepareUI.this), 2);
          LuckyMoneyPrepareUI.this.ao(LuckyMoneyPrepareUI.e(LuckyMoneyPrepareUI.this), 0);
          LuckyMoneyPrepareUI.this.mKeyboard.setXMode(2);
          LuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText)paramAnonymousView);
          LuckyMoneyPrepareUI.this.mKBLayout.setVisibility(0);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(65841);
        }
      });
      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vUU, 1) != 1) {
        break label1749;
      }
      i = 1;
      label1005:
      if (i == 0) {
        break label1763;
      }
      i = getIntent().getIntExtra("key_chatroom_num", 0);
      if ((!this.ECW) || (i != 0)) {
        break label1754;
      }
      ((EditText)localObject1).requestFocus();
      label1037:
      localObject3 = (TextView)this.ECQ.findViewById(a.f.lucky_money_amount_unit_title);
      if (localObject3 != null) {
        ((TextView)localObject3).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(65842);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$23", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            this.val$hintTv.setOnClickListener(null);
            this.EuU.setOnClickListener(null);
            LuckyMoneyPrepareUI.this.ao(LuckyMoneyPrepareUI.d(LuckyMoneyPrepareUI.this), 2);
            LuckyMoneyPrepareUI.this.ao(LuckyMoneyPrepareUI.e(LuckyMoneyPrepareUI.this), 0);
            LuckyMoneyPrepareUI.this.mKeyboard.setXMode(2);
            LuckyMoneyPrepareUI.this.mKeyboard.setInputEditText(this.val$hintTv);
            LuckyMoneyPrepareUI.this.mKBLayout.setVisibility(0);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$23", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(65842);
          }
        });
      }
      com.tencent.mm.wallet_core.ui.g.setNoSystemInputOnEditText((EditText)localObject2);
      ((InputMethodManager)getContext().getSystemService("input_method")).showSoftInput((View)localObject2, 0);
      ((EditText)localObject2).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(270308);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$24", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          this.val$hintTv.setOnClickListener(null);
          this.EuU.setOnClickListener(null);
          LuckyMoneyPrepareUI.this.ao(LuckyMoneyPrepareUI.d(LuckyMoneyPrepareUI.this), 2);
          LuckyMoneyPrepareUI.this.ao(LuckyMoneyPrepareUI.e(LuckyMoneyPrepareUI.this), 0);
          LuckyMoneyPrepareUI.this.mKeyboard.setXMode(0);
          LuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText)paramAnonymousView);
          LuckyMoneyPrepareUI.this.mKBLayout.setVisibility(0);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$24", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(270308);
        }
      });
      ((MMEditText)this.EuL.findViewById(a.f.lucky_money_text)).setOnFocusChangeListener(new View.OnFocusChangeListener()
      {
        public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(275392);
          this.val$hintTv.setOnClickListener(null);
          this.EuU.setOnClickListener(null);
          LuckyMoneyPrepareUI.this.ao(LuckyMoneyPrepareUI.d(LuckyMoneyPrepareUI.this), 2);
          LuckyMoneyPrepareUI.this.ao(LuckyMoneyPrepareUI.e(LuckyMoneyPrepareUI.this), 0);
          AppMethodBeat.o(275392);
        }
      });
      if (this.EtY != null)
      {
        if (this.mType != 1) {
          break label1771;
        }
        this.ECQ.setMaxAmount(this.EtY.Etx);
        label1170:
        this.ECQ.setMinAmount(this.EtY.Etw);
        if (this.EtY.tVx != 1) {
          aNR(this.EtY.EtA);
        }
      }
      if ((!this.ECW) || (getIntent().getIntExtra("key_chatroom_num", 0) > 1)) {
        break label1788;
      }
      this.EuJ.setNum("1");
      label1238:
      this.EuJ.setMaxNum(this.EtY.Etu);
      this.EuJ.setMinNum(1);
      Log.d("MicroMsg.LuckyMoneyPrepareUI", "init num=" + this.EuJ.getInput());
      this.ECQ.setMaxLen(12);
      if (eQk()) {
        this.EuM.setText(getString(a.i.lucky_money_prepare_money_format, new Object[] { this.EtY.EyS }));
      }
      if ((!this.ECW) && (this.jaR != 2) && (this.jaR != 3)) {
        break label2007;
      }
      if (!eQk()) {
        break label1801;
      }
      setMMTitle(getString(a.i.lucky_money_to_send_title_format, new Object[] { this.EtY.EyS }));
      label1388:
      i = getIntent().getIntExtra("key_chatroom_num", 0);
      if ((!this.ECW) || (i != 0)) {
        break label1811;
      }
      Log.i("MicroMsg.LuckyMoneyPrepareUI", "single hb");
      this.EuJ.setVisibility(8);
      this.EMU.setVisibility(8);
      this.EMW.setVisibility(8);
    }
    for (;;)
    {
      this.EuM.setOnClickListener(new com.tencent.mm.ui.aa()
      {
        public final void cOw()
        {
          AppMethodBeat.i(277703);
          LuckyMoneyPrepareUI.a(LuckyMoneyPrepareUI.this, new jk());
          LuckyMoneyPrepareUI.b(LuckyMoneyPrepareUI.this).gCd = 6L;
          LuckyMoneyPrepareUI.b(LuckyMoneyPrepareUI.this).bpa();
          if (!((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.pluginsdk.wallet.a.class)).canOpenKindaCashier(LuckyMoneyPrepareUI.this))
          {
            Log.w("MicroMsg.LuckyMoneyPrepareUI", "can not request hb while authen");
            com.tencent.mm.plugin.report.service.h.IzE.el(965, 55);
            AppMethodBeat.o(277703);
            return;
          }
          LuckyMoneyPrepareUI.c(LuckyMoneyPrepareUI.this);
          AppMethodBeat.o(277703);
        }
      });
      localObject1 = (TextView)findViewById(a.f.lucky_money_prepare_error_tips);
      this.EuS.z((TextView)localObject1);
      this.ndv = new MTimerHandler(new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(265713);
          double d2;
          double d1;
          if ((LuckyMoneyPrepareUI.d(LuckyMoneyPrepareUI.this).eOc() != 3) && (LuckyMoneyPrepareUI.e(LuckyMoneyPrepareUI.this).eOc() != 3))
          {
            int i = LuckyMoneyPrepareUI.e(LuckyMoneyPrepareUI.this).getInput();
            d2 = LuckyMoneyPrepareUI.d(LuckyMoneyPrepareUI.this).getInput();
            if (LuckyMoneyPrepareUI.f(LuckyMoneyPrepareUI.this) == 0) {
              d1 = d2 * i;
            }
          }
          for (;;)
          {
            if ((d1 == 0.0D) || (d1 > LuckyMoneyPrepareUI.h(LuckyMoneyPrepareUI.this).Etx) || (LuckyMoneyPrepareUI.i(LuckyMoneyPrepareUI.this).ePN()))
            {
              LuckyMoneyPrepareUI.j(LuckyMoneyPrepareUI.this).setClickable(false);
              LuckyMoneyPrepareUI.j(LuckyMoneyPrepareUI.this).setEnabled(false);
            }
            for (;;)
            {
              Log.i("MicroMsg.LuckyMoneyPrepareUI", "onTimeExpired & check: amount=" + d1 + ", hasErr=" + LuckyMoneyPrepareUI.i(LuckyMoneyPrepareUI.this).ePN());
              LuckyMoneyPrepareUI.k(LuckyMoneyPrepareUI.this).stopped();
              AppMethodBeat.o(265713);
              return false;
              d1 = d2;
              if (LuckyMoneyPrepareUI.f(LuckyMoneyPrepareUI.this) != 3) {
                break;
              }
              d1 = d2;
              if (!Util.isNullOrNil(LuckyMoneyPrepareUI.g(LuckyMoneyPrepareUI.this))) {
                break;
              }
              d1 = 0.0D;
              break;
              LuckyMoneyPrepareUI.j(LuckyMoneyPrepareUI.this).setClickable(true);
              LuckyMoneyPrepareUI.j(LuckyMoneyPrepareUI.this).setEnabled(true);
            }
            d1 = 0.0D;
          }
        }
      }, false);
      if (this.EuP != null) {
        this.EuP.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(277809);
            if (paramAnonymousMotionEvent.getAction() == 0)
            {
              LuckyMoneyPrepareUI.this.hideTenpayKB();
              LuckyMoneyPrepareUI.this.hideVKB();
            }
            AppMethodBeat.o(277809);
            return false;
          }
        });
      }
      this.ECQ.setType(this.mType);
      init();
      final boolean bool = com.tencent.mm.aa.c.aFn().a(ar.a.Vtv, ar.a.Vtx);
      this.EMN.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(final View paramAnonymousView)
        {
          AppMethodBeat.i(213912);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          Log.d("MicroMsg.LuckyMoneyPrepareUI", "click envelope layout: %s", new Object[] { Integer.valueOf(LuckyMoneyPrepareUI.B(LuckyMoneyPrepareUI.this)) });
          if (LuckyMoneyPrepareUI.B(LuckyMoneyPrepareUI.this) == 0)
          {
            LuckyMoneyPrepareUI.a(LuckyMoneyPrepareUI.this, null, false, bool);
            paramAnonymousView = com.tencent.mm.plugin.report.service.h.IzE;
            if (!bool) {
              break label213;
            }
          }
          label213:
          for (int i = 2;; i = 1)
          {
            paramAnonymousView.a(18890, new Object[] { Integer.valueOf(2), Integer.valueOf(i), LuckyMoneyPrepareUI.D(LuckyMoneyPrepareUI.this) });
            com.tencent.mm.plugin.report.service.h.IzE.a(16822, new Object[] { Integer.valueOf(1) });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(213912);
            return;
            paramAnonymousView = com.tencent.mm.plugin.luckymoney.model.ag.hs(LuckyMoneyPrepareUI.this.getContext());
            localObject = k.eOu();
            ((k)localObject).d(new com.tencent.mm.plugin.luckymoney.model.d("", 1));
            ((com.tencent.mm.wallet_core.c.a)localObject).a(new com.tencent.mm.wallet_core.c.a.a() {}, 0L);
            break;
          }
        }
      });
      if (bool) {
        this.EMT.setVisibility(0);
      }
      if ((!com.tencent.mm.plugin.luckymoney.model.ag.PS(getIntent().getStringExtra("key_username"))) && (this.EyX != null)) {
        break label2072;
      }
      b(null);
      AppMethodBeat.o(65886);
      return;
      setMMTitle(a.i.lucky_money_normal);
      this.ECQ.setTitle(getString(a.i.lucky_money_unit_amount_title));
      this.ECQ.setShowGroupIcon(false);
      break;
      label1646:
      if (this.jaR == 3)
      {
        this.ECQ.setRtxLuckyMoney(2);
        break label715;
      }
      this.ECQ.setRtxLuckyMoney(0);
      break label715;
      label1676:
      ((LinearLayout.LayoutParams)localObject1).topMargin = com.tencent.mm.ci.a.fromDPToPix(getContext(), 16);
      ((LinearLayout.LayoutParams)localObject2).topMargin = com.tencent.mm.ci.a.fromDPToPix(getContext(), 16);
      break label777;
      label1706:
      if (this.jaR == 3)
      {
        this.EuJ.setRtxLuckyMoney(2);
        break label862;
      }
      this.EuJ.setRtxLuckyMoney(0);
      break label862;
      label1736:
      this.EMS.setImageResource(a.e.lucky_money_prepare_envelope_mask);
      break label886;
      label1749:
      i = 0;
      break label1005;
      label1754:
      ((EditText)localObject2).requestFocus();
      break label1037;
      label1763:
      ((EditText)localObject1).requestFocus();
      break label1037;
      label1771:
      this.ECQ.setMaxAmount(this.EtY.Etv);
      break label1170;
      label1788:
      this.EuJ.setNum("");
      break label1238;
      label1801:
      setMMTitle(a.i.lucky_money_to_send_title);
      break label1388;
      label1811:
      if ((getIntent().getIntExtra("key_chatroom_num", 0) <= 0) && (this.ECW))
      {
        this.EMU.setVisibility(8);
        this.EMW.setVisibility(8);
        label1850:
        if ((!this.ECW) || (i <= 0)) {
          break label1978;
        }
        Log.i("MicroMsg.LuckyMoneyPrepareUI", "group hb,%d people", new Object[] { Integer.valueOf(i) });
        localObject1 = getString(a.i.lucky_money_num_group_tips, new Object[] { Integer.valueOf(getIntent().getIntExtra("key_chatroom_num", 8)) });
        this.EMX.setText((CharSequence)localObject1);
      }
      for (;;)
      {
        this.ECQ.setGroupIconIv(a.e.lucky_money_group_icon_new_solid);
        break;
        this.EMU.setVisibility(0);
        Wm(-1);
        this.EMU.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(277976);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            LuckyMoneyPrepareUI.this.hideTenpayKB();
            LuckyMoneyPrepareUI.this.hideVKB();
            paramAnonymousView = new com.tencent.mm.ui.widget.f(LuckyMoneyPrepareUI.this.getContext(), (byte)0);
            paramAnonymousView.ODT = new q.f()
            {
              public final void onCreateMMMenu(com.tencent.mm.ui.base.o paramAnonymous2o)
              {
                AppMethodBeat.i(277446);
                paramAnonymous2o.d(1, LuckyMoneyPrepareUI.this.getString(a.i.lucky_money_mode_lucky_text));
                paramAnonymous2o.d(2, LuckyMoneyPrepareUI.this.getString(a.i.lucky_money_mode_normal_text));
                ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vUT, 0);
                int i = LuckyMoneyPrepareUI.this.getIntent().getIntExtra("key_chatroom_num", 0);
                if ((LuckyMoneyPrepareUI.h(LuckyMoneyPrepareUI.this).EyV) && (LuckyMoneyPrepareUI.l(LuckyMoneyPrepareUI.this) == 1) && (!ab.PR(LuckyMoneyPrepareUI.this.getIntent().getStringExtra("key_username"))) && (LuckyMoneyPrepareUI.m(LuckyMoneyPrepareUI.this) != 2) && (LuckyMoneyPrepareUI.m(LuckyMoneyPrepareUI.this) != 3) && (i > 1)) {
                  paramAnonymous2o.d(3, LuckyMoneyPrepareUI.this.getString(a.i.lucky_money_mode_exclusive_text));
                }
                AppMethodBeat.o(277446);
              }
            };
            paramAnonymousView.ODU = new q.g()
            {
              public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
              {
                AppMethodBeat.i(221284);
                paramAnonymous2Int = paramAnonymous2MenuItem.getItemId();
                int i = LuckyMoneyPrepareUI.f(LuckyMoneyPrepareUI.this);
                if (paramAnonymous2Int == 1)
                {
                  LuckyMoneyPrepareUI.a(LuckyMoneyPrepareUI.this, 1);
                  com.tencent.mm.plugin.report.service.h.IzE.a(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(LuckyMoneyPrepareUI.n(LuckyMoneyPrepareUI.this)), Integer.valueOf(2) });
                }
                for (;;)
                {
                  if ((LuckyMoneyPrepareUI.o(LuckyMoneyPrepareUI.this)) && (i != LuckyMoneyPrepareUI.f(LuckyMoneyPrepareUI.this)))
                  {
                    com.tencent.mm.plugin.report.service.h.IzE.a(22237, new Object[] { Integer.valueOf(2) });
                    LuckyMoneyPrepareUI.p(LuckyMoneyPrepareUI.this);
                  }
                  LuckyMoneyPrepareUI.b(LuckyMoneyPrepareUI.this, i);
                  AppMethodBeat.o(221284);
                  return;
                  if (paramAnonymous2Int == 2)
                  {
                    LuckyMoneyPrepareUI.a(LuckyMoneyPrepareUI.this, 0);
                    com.tencent.mm.plugin.report.service.h.IzE.a(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(LuckyMoneyPrepareUI.n(LuckyMoneyPrepareUI.this)), Integer.valueOf(3) });
                  }
                  else if (paramAnonymous2Int == 3)
                  {
                    LuckyMoneyPrepareUI.a(LuckyMoneyPrepareUI.this, 3);
                    com.tencent.mm.plugin.report.service.h.IzE.a(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(LuckyMoneyPrepareUI.n(LuckyMoneyPrepareUI.this)), Integer.valueOf(13) });
                  }
                }
              }
            };
            paramAnonymousView.eik();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(277976);
          }
        });
        this.EMW.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(271328);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            LuckyMoneyPrepareUI.this.hideTenpayKB();
            LuckyMoneyPrepareUI.this.hideVKB();
            paramAnonymousView = new Intent(LuckyMoneyPrepareUI.this.getContext(), LuckyMoneyExclusiveSelectContactUI.class);
            paramAnonymousView.putExtra("chatroomName", LuckyMoneyPrepareUI.q(LuckyMoneyPrepareUI.this));
            LuckyMoneyPrepareUI.this.startActivityForResult(paramAnonymousView, 6);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(271328);
          }
        });
        break label1850;
        label1978:
        if (this.jaR == 2)
        {
          Log.i("MicroMsg.LuckyMoneyPrepareUI", "f2f hb");
          this.EuL.setVisibility(8);
        }
      }
      label2007:
      if (this.mType == 1)
      {
        this.qCM.setText(this.EtY.EyO);
        this.qCM.setVisibility(0);
      }
      else if (this.mType == 0)
      {
        this.qCM.setText(this.EtY.EyP);
        this.qCM.setVisibility(0);
      }
    }
    label2072:
    if (this.EyX != null) {
      b(this.EyX.Eyz);
    }
    AppMethodBeat.o(65886);
  }
  
  public final void j(int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(65902);
    if ((this.EyX != null) && (this.EyX.Eyz != null)) {
      com.tencent.mm.plugin.report.service.h.IzE.kvStat(22296, this.EyX.Eyz.SpP);
    }
    if (paramIntent.hasExtra("key_realname_guide_helper")) {
      this.ENg = ((RealnameGuideHelper)paramIntent.getParcelableExtra("key_realname_guide_helper"));
    }
    if (paramInt == -1)
    {
      aNS(paramIntent.getStringExtra("key_trans_id"));
      com.tencent.mm.plugin.report.service.h.IzE.a(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(eOZ()), Integer.valueOf(5) });
      Object localObject1 = getIntent().getStringExtra("key_username");
      if (((this.ECW) && (!Util.isNullOrNil((String)localObject1))) || (this.jaR == 3))
      {
        com.tencent.mm.ui.base.h.cO(this, getString(a.i.has_send));
        Object localObject2 = XmlParser.parseXml(this.ECX, "msg", null);
        if (localObject2 == null)
        {
          Log.e("MicroMsg.LuckyMoneyPrepareUI", "luckymoneyPrepareUI onActivityResult values is null");
          finish();
          AppMethodBeat.o(65902);
          return;
        }
        localObject2 = (String)((Map)localObject2).get(".msg.appmsg.wcpayinfo.paymsgid");
        if (com.tencent.mm.plugin.luckymoney.b.a.eNR().eNW().aND((String)localObject2))
        {
          Log.i("MicroMsg.LuckyMoneyPrepareUI", "insert a local msg for luckymoney");
          if (!com.tencent.mm.plugin.luckymoney.model.ag.ag(this.ECX, (String)localObject1, 1))
          {
            Log.e("MicroMsg.LuckyMoneyPrepareUI", "LuckyMoneyUtil.sendLocalMsg fail!");
            com.tencent.mm.plugin.luckymoney.b.a.eNR().eNW().aNE((String)localObject2);
          }
          h(paramInt, paramIntent);
          paramIntent = new com.tencent.mm.plugin.luckymoney.story.b.e();
          paramIntent.field_send_id = ((String)localObject2);
          if (!com.tencent.mm.plugin.luckymoney.b.a.eNR().eNQ().get(paramIntent, new String[0]))
          {
            paramIntent.field_open_count = 0;
            Log.d("MicroMsg.LuckyMoneyPrepareUI", "insert record: %s, %s", new Object[] { localObject2, Boolean.valueOf(com.tencent.mm.plugin.luckymoney.b.a.eNR().eNQ().insert(paramIntent)) });
          }
          com.tencent.mm.plugin.luckymoney.b.a.Etd = this.mType;
          if (this.ENq)
          {
            if (!this.ENr) {
              break label504;
            }
            com.tencent.mm.plugin.report.service.h.IzE.a(22237, new Object[] { Integer.valueOf(4) });
          }
          label403:
          this.ENk = new jl();
          this.ENk.gKZ = this.EKT;
          if (this.uIz != null) {
            break label535;
          }
        }
        label535:
        for (paramIntent = "";; paramIntent = this.uIz.getMd5())
        {
          this.ENk.At(paramIntent);
          this.ENk.bpa();
          Log.i("MicroMsg.LuckyMoneyPrepareUI", "Report RedEnvSendWithEmoticonDataStruct, Scene: %d, md5: %s", new Object[] { Integer.valueOf(this.EKT), paramIntent });
          finish();
          AppMethodBeat.o(65902);
          return;
          Log.e("MicroMsg.LuckyMoneyPrepareUI", "it is a duplicate msg");
          break;
          label504:
          if (this.mType == 1) {
            break label403;
          }
          com.tencent.mm.plugin.report.service.h.IzE.a(22237, new Object[] { Integer.valueOf(3) });
          break label403;
        }
      }
      ePB();
      localObject1 = findViewById(a.f.lucky_money_prepare_ready_packet_ll);
      this.ECR.setVisibility(0);
      com.tencent.mm.plugin.luckymoney.model.ag.a((View)localObject1, null);
      this.uOZ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(65869);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$42", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          com.tencent.mm.plugin.report.service.h.IzE.a(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(LuckyMoneyPrepareUI.n(LuckyMoneyPrepareUI.this)), Integer.valueOf(6) });
          com.tencent.mm.plugin.luckymoney.model.ag.a(LuckyMoneyPrepareUI.this, LuckyMoneyPrepareUI.f(LuckyMoneyPrepareUI.this), LuckyMoneyPrepareUI.K(LuckyMoneyPrepareUI.this), true);
          LuckyMoneyPrepareUI.L(LuckyMoneyPrepareUI.this).postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(209196);
              LuckyMoneyPrepareUI.L(LuckyMoneyPrepareUI.this).setVisibility(8);
              LuckyMoneyPrepareUI.this.ePA();
              AppMethodBeat.o(209196);
            }
          }, 100L);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$42", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(65869);
        }
      });
      ((ImageView)findViewById(a.f.lucky_money_prepare_close_btn)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(274590);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$43", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          LuckyMoneyPrepareUI.L(LuckyMoneyPrepareUI.this).setVisibility(8);
          LuckyMoneyPrepareUI.this.ePA();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$43", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(274590);
        }
      });
      h(paramInt, paramIntent);
      AppMethodBeat.o(65902);
      return;
    }
    h(paramInt, paramIntent);
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
        this.ENg = ((RealnameGuideHelper)paramIntent.getParcelableExtra("key_realname_guide_helper"));
      }
      Object localObject1;
      if (paramInt2 == -1)
      {
        com.tencent.mm.plugin.report.service.h.IzE.a(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(eOZ()), Integer.valueOf(5) });
        localObject1 = getIntent().getStringExtra("key_username");
        if (((this.ECW) && (!Util.isNullOrNil((String)localObject1))) || (this.jaR == 3))
        {
          Object localObject2 = XmlParser.parseXml(this.ECX, "msg", null);
          if (localObject2 == null)
          {
            Log.e("MicroMsg.LuckyMoneyPrepareUI", "luckymoneyPrepareUI onActivityResult values is null");
            finish();
            AppMethodBeat.o(65900);
            return;
          }
          localObject2 = (String)((Map)localObject2).get(".msg.appmsg.wcpayinfo.paymsgid");
          if (com.tencent.mm.plugin.luckymoney.b.a.eNR().eNW().aND((String)localObject2))
          {
            Log.i("MicroMsg.LuckyMoneyPrepareUI", "insert a local msg for luckymoney");
            if (!com.tencent.mm.plugin.luckymoney.model.ag.ag(this.ECX, (String)localObject1, 1))
            {
              Log.e("MicroMsg.LuckyMoneyPrepareUI", "LuckyMoneyUtil.sendLocalMsg fail!");
              com.tencent.mm.plugin.luckymoney.b.a.eNR().eNW().aNE((String)localObject2);
            }
            label314:
            h(paramInt2, paramIntent);
            this.ENk = new jl();
            this.ENk.gKZ = this.EKT;
            if (this.uIz != null) {
              break label444;
            }
            localObject1 = "";
            label355:
            this.ENk.At((String)localObject1);
            this.ENk.bpa();
            Log.i("MicroMsg.LuckyMoneyPrepareUI", "Report RedEnvSendWithEmoticonDataStruct, Scene: %d, md5: %s", new Object[] { Integer.valueOf(this.EKT), localObject1 });
            finish();
          }
        }
        for (;;)
        {
          localObject1 = "";
          if (paramIntent != null) {
            localObject1 = paramIntent.getStringExtra("key_trans_id");
          }
          aNS((String)localObject1);
          break;
          Log.e("MicroMsg.LuckyMoneyPrepareUI", "it is a duplicate msg");
          break label314;
          label444:
          localObject1 = this.uIz.getMd5();
          break label355;
          ePB();
          localObject1 = findViewById(a.f.lucky_money_prepare_ready_packet_ll);
          this.ECR.setVisibility(0);
          com.tencent.mm.plugin.luckymoney.model.ag.a((View)localObject1, null);
          this.uOZ.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(65866);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bn(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$40", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
              com.tencent.mm.plugin.report.service.h.IzE.a(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(LuckyMoneyPrepareUI.n(LuckyMoneyPrepareUI.this)), Integer.valueOf(6) });
              com.tencent.mm.plugin.luckymoney.model.ag.a(LuckyMoneyPrepareUI.this, LuckyMoneyPrepareUI.f(LuckyMoneyPrepareUI.this), LuckyMoneyPrepareUI.K(LuckyMoneyPrepareUI.this), true);
              LuckyMoneyPrepareUI.L(LuckyMoneyPrepareUI.this).postDelayed(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(267415);
                  LuckyMoneyPrepareUI.L(LuckyMoneyPrepareUI.this).setVisibility(8);
                  LuckyMoneyPrepareUI.this.ePA();
                  AppMethodBeat.o(267415);
                }
              }, 100L);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$40", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(65866);
            }
          });
          ((ImageView)findViewById(a.f.lucky_money_prepare_close_btn)).setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(65868);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bn(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$41", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
              LuckyMoneyPrepareUI.L(LuckyMoneyPrepareUI.this).setVisibility(8);
              LuckyMoneyPrepareUI.this.ePA();
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$41", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(65868);
            }
          });
          h(paramInt2, paramIntent);
        }
      }
      if (com.tencent.mm.wallet_core.c.ag.bL(paramIntent))
      {
        finish();
        AppMethodBeat.o(65900);
        return;
      }
      if (com.tencent.mm.wallet_core.c.ag.bM(paramIntent))
      {
        AppMethodBeat.o(65900);
        return;
      }
      h(paramInt2, paramIntent);
      continue;
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        localObject1 = paramIntent.getStringExtra("Select_Conv_User");
        com.tencent.mm.plugin.report.service.h.IzE.a(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(eOZ()), Integer.valueOf(7), localObject1 });
        if (!Util.isNullOrNil((String)localObject1)) {
          doSceneProgress(new bg(((String)localObject1).replaceAll(",", "|"), this.ECU, "v1.0"));
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
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject1);
        com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0));
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
              com.tencent.mm.plugin.luckymoney.b.a.Etd = this.mType;
              if (this.ENq)
              {
                if (!this.ENr) {
                  break label954;
                }
                com.tencent.mm.plugin.report.service.h.IzE.a(22237, new Object[] { Integer.valueOf(4) });
              }
              for (;;)
              {
                finish();
                break;
                label954:
                if (this.mType != 1) {
                  com.tencent.mm.plugin.report.service.h.IzE.a(22237, new Object[] { Integer.valueOf(3) });
                }
              }
            }
          }
          else
          {
            Log.e("MicroMsg.LuckyMoneyPrepareUI", "onActivityResult REQUEST_CODE_H5_PAY bundle is null");
            continue;
            i(paramInt2, paramIntent);
            continue;
            if (paramInt2 == -1)
            {
              this.ECT.removeAllViews();
              tT(true);
            }
            else
            {
              tT(false);
              com.tencent.mm.plugin.report.service.h.IzE.a(16822, new Object[] { Integer.valueOf(2) });
              continue;
              if (paramInt2 == -1)
              {
                localObject1 = "";
                if (paramIntent != null) {
                  localObject1 = paramIntent.getStringExtra("gif_md5");
                }
                if (!Util.isNullOrNil((String)localObject1))
                {
                  this.uIz = com.tencent.mm.plugin.emoji.model.p.getEmojiStorageMgr().VFH.bxK((String)localObject1);
                  C(this.uIz);
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
                  this.ENj = paramIntent.getStringExtra("Select_Contact");
                  Log.i("MicroMsg.LuckyMoneyPrepareUI", "select user: %s", new Object[] { this.ENj });
                  if (!Util.isNullOrNil(this.ENj))
                  {
                    com.tencent.mm.ui.h.a.a.c(this.EMY, this.ENj);
                    localObject1 = com.tencent.mm.wallet_core.ui.g.id(((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.a.b.class)).aL(this.ENj, this.ENi), 8);
                    this.EMZ.setText(com.tencent.mm.pluginsdk.ui.span.l.b(getContext(), (CharSequence)localObject1, this.EMZ.getTextSize()));
                    this.EMY.setVisibility(0);
                    this.EMZ.setVisibility(0);
                  }
                }
                eOd();
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
    this.Eyo = getIntent().getIntExtra("key_way", 3);
    this.jaR = getIntent().getIntExtra("key_from", 0);
    boolean bool;
    int i;
    label163:
    int j;
    if (this.jaR == 1)
    {
      bool = true;
      this.ECW = bool;
      this.mChannel = getIntent().getIntExtra("pay_channel", -1);
      this.mSessionId = getIntent().getStringExtra("key_session_id");
      tT(false);
      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vUV, 1) != 1) {
        break label533;
      }
      i = 1;
      j = getIntent().getIntExtra("key_chatroom_num", 0);
      if ((!this.ECW) || (j <= 0)) {
        break label538;
      }
      j = 1;
      label188:
      if ((j != 0) && (com.tencent.mm.plugin.luckymoney.b.a.Etd >= 0) && (i != 0))
      {
        Log.i("MicroMsg.LuckyMoneyPrepareUI", "use cached hb type: %s", new Object[] { Integer.valueOf(com.tencent.mm.plugin.luckymoney.b.a.Etd) });
        this.mType = com.tencent.mm.plugin.luckymoney.b.a.Etd;
        this.ENq = true;
        if (this.mType != 1) {
          com.tencent.mm.plugin.report.service.h.IzE.a(22237, new Object[] { Integer.valueOf(1) });
        }
      }
      if (!com.tencent.mm.plugin.luckymoney.model.ag.PS(getIntent().getStringExtra("key_username"))) {
        break label543;
      }
      com.tencent.mm.plugin.luckymoney.b.a.eNR();
      this.EtY = com.tencent.mm.plugin.luckymoney.b.a.eNT().eOz();
      com.tencent.mm.plugin.luckymoney.b.a.eNR();
      this.EyX = com.tencent.mm.plugin.luckymoney.b.a.eNT().eOA();
    }
    for (;;)
    {
      if (this.jaR == 3) {
        setMMSubTitle(a.i.lucky_money_live_subtitle_text);
      }
      Log.i("MicroMsg.LuckyMoneyPrepareUI", "mInWay:" + this.Eyo + "mChannel:" + this.mChannel);
      Log.i("MicroMsg.LuckyMoneyPrepareUI", "type=" + this.mType + ", fromAppPanel=" + this.ECW + ", config " + this.EtY);
      initView();
      EventCenter.instance.add(this.ENF);
      this.mPayLoopInterruptListener.alive();
      com.tencent.mm.plugin.report.service.h.IzE.a(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(eOZ()), Integer.valueOf(1) });
      com.tencent.mm.wallet_core.b.iie();
      this.mKindaEnable = com.tencent.mm.wallet_core.b.b(b.a.vCG, true);
      ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.wxpay.a.a.class)).triggerSoterReInit();
      com.tencent.soter.a.a.ipc();
      AppMethodBeat.o(65883);
      return;
      bool = false;
      break;
      label533:
      i = 0;
      break label163;
      label538:
      j = 0;
      break label188;
      label543:
      if (this.jaR == 3)
      {
        com.tencent.mm.plugin.luckymoney.b.a.eNR();
        this.EtY = com.tencent.mm.plugin.luckymoney.b.a.eNU().eOz();
        com.tencent.mm.plugin.luckymoney.b.a.eNR();
        this.EyX = com.tencent.mm.plugin.luckymoney.b.a.eNU().eOA();
      }
      else
      {
        com.tencent.mm.plugin.luckymoney.b.a.eNR();
        this.EtY = com.tencent.mm.plugin.luckymoney.b.a.eNS().eOz();
        com.tencent.mm.plugin.luckymoney.b.a.eNR();
        this.EyX = com.tencent.mm.plugin.luckymoney.b.a.eNS().eOA();
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(65893);
    super.onDestroy();
    this.EuS.clear();
    this.ndv.stopped();
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    if (this.rzI != null)
    {
      Log.i("MicroMsg.LuckyMoneyPrepareUI", "commentfooter release");
      this.rzI.onPause();
      this.rzI.hjm();
      this.rzI.destroy();
    }
    EventCenter.instance.removeListener(this.ENF);
    this.mPayLoopInterruptListener.dead();
    if (this.ENs)
    {
      int i = ((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vtf, Integer.valueOf(0))).intValue();
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vtf, Integer.valueOf(i + 1));
    }
    AppMethodBeat.o(65893);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(65904);
    if ((paramInt == 4) && (this.mKBLayout != null) && (this.mKBLayout.isShown()))
    {
      this.mKBLayout.setVisibility(8);
      AppMethodBeat.o(65904);
      return true;
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
    AppMethodBeat.o(65884);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, final com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(65896);
    Log.i("MicroMsg.LuckyMoneyPrepareUI", "errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scenetype:" + paramq.getType());
    boolean bool;
    if ((paramq instanceof bb))
    {
      Log.i("MicroMsg.LuckyMoneyPrepareUI", "onsceneEnd： scene instanceof NetScenePrepareLuckyMoney");
      if (this.ENE)
      {
        Log.i("MicroMsg.LuckyMoneyPrepareUI", "has show alert return");
        AppMethodBeat.o(65896);
        return true;
      }
      bb localbb = (bb)paramq;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        bool = this.mKindaEnable;
        if ((this.tipDialog != null) && (this.tipDialog.isShowing()) && (!bool)) {
          this.tipDialog.dismiss();
        }
        this.ECV = localbb.tVd;
        this.ECU = localbb.ybP;
        this.ECX = localbb.EBL;
        this.ExZ = localbb.ybP;
        this.ENh = localbb.EBP;
        if (((bb)paramq).isJumpRemind())
        {
          Log.i("MicroMsg.LuckyMoneyPrepareUI", "onSceneEnd() NetScenePrepareLuckyMoney show JumpRemind Alert");
          ((bb)paramq).jumpRemind.a(this, new com.tencent.mm.wallet_core.c.h()
          {
            public final void bE(int paramAnonymousInt, String paramAnonymousString)
            {
              AppMethodBeat.i(269178);
              Log.i("MicroMsg.LuckyMoneyPrepareUI", "onSceneEnd() scene:NetScenePrepareLuckyMoney JumpRemind:onNext()");
              if ((Util.isEqual(paramAnonymousInt, 2)) && (Util.isEqual(paramAnonymousString, "requestwxhb")))
              {
                LuckyMoneyPrepareUI.E(LuckyMoneyPrepareUI.this);
                AppMethodBeat.o(269178);
                return;
              }
              if (Util.isEqual(paramAnonymousInt, 1)) {
                com.tencent.mm.plugin.account.sdk.b.a.b(LuckyMoneyPrepareUI.this, paramAnonymousString, 0, true);
              }
              AppMethodBeat.o(269178);
            }
            
            public final void onCancel()
            {
              AppMethodBeat.i(269180);
              Log.i("MicroMsg.LuckyMoneyPrepareUI", "onSceneEnd() scene:NetScenePrepareLuckyMoney JumpRemind:onCancel()");
              AppMethodBeat.o(269180);
            }
          });
          AppMethodBeat.o(65896);
          return true;
        }
        paramString = new PayInfo();
        paramString.fwv = localbb.ByI;
        paramString.fOY = 37;
        paramString.channel = this.mChannel;
        if (this.mKindaEnable) {
          ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.pluginsdk.wallet.a.class)).startSNSPay(this, paramString);
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
        this.EuM.setEnabled(false);
        this.EuM.setClickable(false);
        this.ndv.startTimer(5000L);
        com.tencent.mm.ui.base.h.cO(this, paramString);
        AppMethodBeat.o(65896);
        return true;
      }
      if (paramInt2 == 268502454)
      {
        com.tencent.mm.ui.base.h.d(this, paramString, "", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(278073);
            if (bb.l(paramq))
            {
              LuckyMoneyPrepareUI.this.finish();
              AppMethodBeat.o(278073);
              return;
            }
            AppMethodBeat.o(278073);
          }
        });
        AppMethodBeat.o(65896);
        return true;
      }
      this.fRV = 2;
      paramq = paramString;
      if (TextUtils.isEmpty(paramString)) {
        paramq = getString(a.i.wallet_unknown_err);
      }
      com.tencent.mm.ui.base.h.a(this, paramq, null, false, new LuckyMoneyPrepareUI.19(this));
      AppMethodBeat.o(65896);
      return true;
    }
    if ((paramq instanceof bg))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (this.ECW)
        {
          com.tencent.mm.ui.widget.snackbar.b.r(this, getString(a.i.has_send));
          MMHandlerThread.postToMainThreadDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(65853);
              LuckyMoneyPrepareUI.this.finish();
              AppMethodBeat.o(65853);
            }
          }, 1800L);
        }
        for (;;)
        {
          AppMethodBeat.o(65896);
          return true;
          ePB();
          this.ECS.setVisibility(0);
          this.ECS.postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(276943);
              Object localObject = new Intent();
              ((Intent)localObject).putExtra("key_username", LuckyMoneyPrepareUI.q(LuckyMoneyPrepareUI.this));
              ((Intent)localObject).setClass(LuckyMoneyPrepareUI.this.getContext(), LuckyMoneyIndexUI.class);
              ((Intent)localObject).addFlags(67108864);
              AppCompatActivity localAppCompatActivity = LuckyMoneyPrepareUI.this.getContext();
              localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
              com.tencent.mm.hellhoundlib.a.a.b(localAppCompatActivity, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$32", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              localAppCompatActivity.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
              com.tencent.mm.hellhoundlib.a.a.c(localAppCompatActivity, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$32", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              LuckyMoneyPrepareUI.this.finish();
              AppMethodBeat.o(276943);
            }
          }, 1000L);
        }
      }
      if (paramInt2 == 402)
      {
        com.tencent.mm.ui.base.h.c(getContext(), paramString, "", getString(a.i.lucky_money_send_list_title), getString(a.i.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(65844);
            Object localObject = new Intent();
            ((Intent)localObject).setClass(LuckyMoneyPrepareUI.this.getContext(), LuckyMoneyMyRecordUI.class);
            ((Intent)localObject).putExtra("key_type", 1);
            ((Intent)localObject).putExtra("key_username", LuckyMoneyPrepareUI.this.getIntent().getStringExtra("key_username"));
            paramAnonymousDialogInterface = LuckyMoneyPrepareUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
            com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$33", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousDialogInterface, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$33", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(65844);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(65896);
        return true;
      }
    }
    else
    {
      if ((paramq instanceof com.tencent.mm.plugin.luckymoney.model.ar))
      {
        Log.i("MicroMsg.LuckyMoneyPrepareUI", "NetSceneLuckyMoneyGetConfig resp,errType=" + paramInt1 + ";errCode=" + paramInt2 + ";errMsg=" + paramString);
        if ((this.EML != null) && (this.EML.isShowing())) {
          this.EML.dismiss();
        }
        if ((this.EMM != null) && (this.EMM.isShowing())) {
          this.EMM.dismiss();
        }
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = (com.tencent.mm.plugin.luckymoney.model.ar)paramq;
          this.ENA = true;
          this.EBz = paramString.EBz;
          if (!Util.isEqual(paramString.EBA, 1))
          {
            this.EuL.tU(true);
            if (!com.tencent.mm.plugin.luckymoney.model.ag.PS(getIntent().getStringExtra("key_username"))) {
              break label1485;
            }
            com.tencent.mm.plugin.luckymoney.b.a.eNR();
            this.EtY = com.tencent.mm.plugin.luckymoney.b.a.eNT().eOz();
            label796:
            Log.i("MicroMsg.LuckyMoneyPrepareUI", "update config:" + this.EtY);
            if (this.mType != 1) {
              break label1527;
            }
            this.ECQ.setMaxAmount(this.EtY.Etx);
            label844:
            this.ECQ.setMinAmount(this.EtY.Etw);
            this.EuJ.setMaxNum(this.EtY.Etu);
            this.ENe = paramString.Etz;
            this.ENd = paramString.tVx;
            this.ENf = paramString.EtJ;
            if (Util.isNullOrNil(this.ELa)) {
              this.ELa = paramString.fND;
            }
            if ((!Util.isNullOrNil(this.ENf)) && (this.EuL != null)) {
              MMHandlerThread.postToMainThread(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(275783);
                  LuckyMoneyPrepareUI.H(LuckyMoneyPrepareUI.this).setHintText(LuckyMoneyPrepareUI.I(LuckyMoneyPrepareUI.this));
                  AppMethodBeat.o(275783);
                }
              });
            }
            if ((paramString.EBq) && (this.ECW))
            {
              paramq = (TextView)findViewById(a.f.lucky_money_prepare_has_tips);
              paramq.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(65860);
                  Object localObject = new com.tencent.mm.hellhoundlib.b.b();
                  ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
                  com.tencent.mm.plugin.report.service.h.IzE.a(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(LuckyMoneyPrepareUI.n(LuckyMoneyPrepareUI.this)), Integer.valueOf(9) });
                  localObject = new Intent();
                  ((Intent)localObject).setClass(LuckyMoneyPrepareUI.this.getContext(), LuckyMoneyCanShareListUI.class);
                  paramAnonymousView = LuckyMoneyPrepareUI.this;
                  localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
                  com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$37", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
                  com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$37", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(65860);
                }
              });
              com.tencent.mm.plugin.report.service.h.IzE.a(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(eOZ()), Integer.valueOf(8) });
              paramq.setVisibility(8);
            }
            if (Util.isNullOrNil(paramString.mKL)) {
              break label1544;
            }
            Log.i("MicroMsg.LuckyMoneyPrepareUI", "Put notice :" + paramString.mKL);
            this.EuQ.setText(paramString.mKL);
            if (!Util.isNullOrNil(paramString.EBs)) {
              this.EuQ.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(267171);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bn(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$38", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
                  com.tencent.mm.wallet_core.ui.g.p(LuckyMoneyPrepareUI.this.getContext(), paramString.EBs, false);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$38", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(267171);
                }
              });
            }
            this.EuQ.setVisibility(0);
            label1121:
            paramq = new i.c();
            if ((paramString.EBu == null) || (Util.isNullOrNil(paramString.EBu.content))) {
              break label1556;
            }
            paramq.textColor = getResources().getColor(a.c.wallet_link_color);
            label1165:
            this.ECT.removeAllViews();
            i.a(this, this.ECT, paramString.EBu, paramq);
            aNR(paramString.EtA);
            if (this.ENd == 1) {
              break label1574;
            }
            b(this.ECQ.getInput(), this.ENe);
            label1217:
            if (!com.tencent.mm.plugin.luckymoney.model.ag.PS(getIntent().getStringExtra("key_username"))) {
              break label1626;
            }
            com.tencent.mm.plugin.luckymoney.b.a.eNR();
            this.EyX = com.tencent.mm.plugin.luckymoney.b.a.eNT().eOA();
            label1247:
            init();
            if (this.EyX == null) {
              break label1668;
            }
            if (this.EyX.Eyz != null)
            {
              this.ENl = this.EyX.Eyz.TqB;
              this.ENm = this.EyX.Eyz.Tqz;
              this.ENn = this.EyX.Eyz.TqA;
            }
            b(this.EyX.Eyz);
            com.tencent.mm.plugin.report.service.h.IzE.el(991, 10);
            label1332:
            if (this.ENC)
            {
              Log.i("MicroMsg.LuckyMoneyPrepareUI", "doRMBPrePareBtnClick()");
              a(this.ENt, this.ENu, this.ENv, this.ENw, this.ENx, this.ENy);
            }
          }
        }
        for (;;)
        {
          Log.i("MicroMsg.LuckyMoneyPrepareUI", "NetSceneLuckyMoneyGetConfig waitingGetConfig:%s ifAutoRMBPrePareBtn:%s", new Object[] { Boolean.valueOf(this.ENB), Boolean.valueOf(this.ENC) });
          this.ENB = false;
          this.ENC = false;
          AppMethodBeat.o(65896);
          return true;
          this.EuL.tU(false);
          if ((this.uIz != null) && (!Util.isNullOrNil(this.uIz.getMd5()))) {
            this.EuL.C(this.uIz);
          }
          this.EuL.setmOnEmojiSelectClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(265597);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bn(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$35", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
              LuckyMoneyPrepareUI.a(LuckyMoneyPrepareUI.this, new jk());
              LuckyMoneyPrepareUI.b(LuckyMoneyPrepareUI.this).gCd = 2L;
              LuckyMoneyPrepareUI.b(LuckyMoneyPrepareUI.this).bpa();
              final boolean bool = Util.isEqual(paramAnonymousView.getTag(), "delete");
              if ((!bool) && (!Util.isEqual(paramString.EBz, 1)))
              {
                LuckyMoneyPrepareUI.c(LuckyMoneyPrepareUI.this, 2);
                LuckyMoneyPrepareUI.F(LuckyMoneyPrepareUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$35", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(265597);
                return;
              }
              paramAnonymousView = new com.tencent.mm.ui.widget.f(LuckyMoneyPrepareUI.this.getContext());
              paramAnonymousView.ODT = new q.f()
              {
                public final void onCreateMMMenu(com.tencent.mm.ui.base.o paramAnonymous2o)
                {
                  AppMethodBeat.i(244356);
                  if (!bool)
                  {
                    if (Util.isEqual(LuckyMoneyPrepareUI.28.this.ECZ.EBz, 1)) {
                      paramAnonymous2o.mn(1, a.i.lucky_money_newyear_shoot_expression);
                    }
                    paramAnonymous2o.mn(2, a.i.lucky_money_select_had_expression);
                    AppMethodBeat.o(244356);
                    return;
                  }
                  paramAnonymous2o.a(3, LuckyMoneyPrepareUI.this.getResources().getColor(a.c.lucky_money_newyear_shoot_expression_color), LuckyMoneyPrepareUI.this.getContext().getString(a.i.lucky_money_delete_emoji));
                  AppMethodBeat.o(244356);
                }
              };
              paramAnonymousView.ODU = new q.g()
              {
                public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(186584);
                  Log.i("MicroMsg.LuckyMoneyPrepareUI", "showLuckyHbDlg() onMMMenuItemSelected menuItemId:%s", new Object[] { Integer.valueOf(paramAnonymous2MenuItem.getItemId()) });
                  switch (paramAnonymous2MenuItem.getItemId())
                  {
                  }
                  for (;;)
                  {
                    AppMethodBeat.o(186584);
                    return;
                    LuckyMoneyPrepareUI.c(LuckyMoneyPrepareUI.this, 1);
                    com.tencent.mm.plugin.emojicapture.api.b.b(LuckyMoneyPrepareUI.this, 4, LuckyMoneyPrepareUI.q(LuckyMoneyPrepareUI.this));
                    LuckyMoneyPrepareUI.a(LuckyMoneyPrepareUI.this, new jk());
                    LuckyMoneyPrepareUI.b(LuckyMoneyPrepareUI.this).gCd = 4L;
                    LuckyMoneyPrepareUI.b(LuckyMoneyPrepareUI.this).bpa();
                    AppMethodBeat.o(186584);
                    return;
                    LuckyMoneyPrepareUI.c(LuckyMoneyPrepareUI.this, 2);
                    LuckyMoneyPrepareUI.F(LuckyMoneyPrepareUI.this);
                    AppMethodBeat.o(186584);
                    return;
                    LuckyMoneyPrepareUI.G(LuckyMoneyPrepareUI.this);
                    paramAnonymous2MenuItem = LuckyMoneyPrepareUI.H(LuckyMoneyPrepareUI.this);
                    paramAnonymous2MenuItem.ENV.setTag("");
                    paramAnonymous2MenuItem.ENW.setVisibility(0);
                    paramAnonymous2MenuItem.ENX.setVisibility(8);
                    LuckyMoneyPrepareUI.a(LuckyMoneyPrepareUI.this, null);
                    LuckyMoneyPrepareUI.a(LuckyMoneyPrepareUI.this, new jk());
                    LuckyMoneyPrepareUI.b(LuckyMoneyPrepareUI.this).gCd = 5L;
                    LuckyMoneyPrepareUI.b(LuckyMoneyPrepareUI.this).bpa();
                  }
                }
              };
              paramAnonymousView.eik();
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$35", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(265597);
            }
          });
          break;
          label1485:
          if (this.jaR == 3)
          {
            com.tencent.mm.plugin.luckymoney.b.a.eNR();
            this.EtY = com.tencent.mm.plugin.luckymoney.b.a.eNU().eOz();
            break label796;
          }
          com.tencent.mm.plugin.luckymoney.b.a.eNR();
          this.EtY = com.tencent.mm.plugin.luckymoney.b.a.eNS().eOz();
          break label796;
          label1527:
          this.ECQ.setMaxAmount(this.EtY.Etv);
          break label844;
          label1544:
          this.EuQ.setVisibility(8);
          break label1121;
          label1556:
          paramq.textColor = getResources().getColor(a.c.half_alpha_black);
          break label1165;
          label1574:
          if (this.mType == 1)
          {
            b(this.ECQ.getInput(), this.ENe);
            break label1217;
          }
          if (this.mType != 3) {
            break label1217;
          }
          b(this.ECQ.getInput(), this.ENe);
          break label1217;
          label1626:
          if (this.jaR == 3)
          {
            com.tencent.mm.plugin.luckymoney.b.a.eNR();
            this.EyX = com.tencent.mm.plugin.luckymoney.b.a.eNU().eOA();
            break label1247;
          }
          com.tencent.mm.plugin.luckymoney.b.a.eNR();
          this.EyX = com.tencent.mm.plugin.luckymoney.b.a.eNS().eOA();
          break label1247;
          label1668:
          b(null);
          break label1332;
          if (this.ENC)
          {
            paramq = paramString;
            if (Util.isNullOrNil(paramString)) {
              paramq = getString(a.i.app_err_system_busy_tip);
            }
            com.tencent.mm.ui.base.w.makeText(this, paramq, 0).show();
          }
        }
      }
      if ((paramq instanceof at))
      {
        removeSceneEndListener(1647);
        if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
          this.tipDialog.dismiss();
        }
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = ((at)paramq).tVJ;
          if (!Util.isNullOrNil(paramString))
          {
            Log.i("MicroMsg.LuckyMoneyPrepareUI", "payUrl is not null");
            com.tencent.mm.wallet_core.ui.g.a(getContext(), paramString, false, 3);
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
        if ((paramq instanceof com.tencent.mm.plugin.luckymoney.f2f.a.d))
        {
          if ((paramInt1 == 0) && (paramInt2 == 0))
          {
            bool = this.mKindaEnable;
            if ((this.tipDialog != null) && (this.tipDialog.isShowing()) && (!bool)) {
              this.tipDialog.dismiss();
            }
            paramString = (com.tencent.mm.plugin.luckymoney.f2f.a.d)paramq;
            if (com.tencent.mm.plugin.wallet_core.utils.g.a(paramString.EvS.SwQ))
            {
              if (this.tipDialog != null) {
                this.tipDialog.dismiss();
              }
              new com.tencent.mm.plugin.wallet_core.utils.g(this).b(paramString.EvS.SwQ);
              AppMethodBeat.o(65896);
              return true;
            }
            this.ExZ = ((com.tencent.mm.plugin.luckymoney.f2f.a.d)paramq).ybP;
            this.ENh = ((com.tencent.mm.plugin.luckymoney.f2f.a.d)paramq).EvT;
            paramString = new PayInfo();
            paramString.fwv = ((com.tencent.mm.plugin.luckymoney.f2f.a.d)paramq).fwv;
            paramString.fOY = 37;
            if (this.mKindaEnable)
            {
              if (paramString.lfu == null) {
                paramString.lfu = new Bundle();
              }
              paramString.lfu.putBoolean("isF2FHongBao", true);
              ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.pluginsdk.wallet.a.class)).startSNSPay(this, paramString);
            }
          }
          for (;;)
          {
            AppMethodBeat.o(65896);
            return true;
            com.tencent.mm.wallet_core.c.af.B(37, paramString.fwv, paramInt2);
            com.tencent.mm.pluginsdk.wallet.f.a(this, paramString, 4);
            continue;
            com.tencent.mm.wallet_core.c.af.B(37, "", paramInt2);
            if (!Util.isNullOrNil(paramString)) {
              com.tencent.mm.ui.base.h.c(this, paramString, getString(a.i.lucky_money_app_tip), true);
            }
            this.tipDialog.dismiss();
          }
        }
        if ((paramq instanceof ax))
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI
 * JD-Core Version:    0.7.0.1
 */