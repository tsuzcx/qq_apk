package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.api.ac.a;
import com.tencent.mm.api.r;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.g.a.pi;
import com.tencent.mm.g.a.ut;
import com.tencent.mm.g.b.a.hf;
import com.tencent.mm.g.b.a.hg;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.luckymoney.model.ae;
import com.tencent.mm.plugin.luckymoney.model.ah;
import com.tencent.mm.plugin.luckymoney.model.am;
import com.tencent.mm.plugin.luckymoney.model.an;
import com.tencent.mm.plugin.luckymoney.model.aq;
import com.tencent.mm.plugin.luckymoney.model.ar;
import com.tencent.mm.plugin.luckymoney.model.as;
import com.tencent.mm.plugin.luckymoney.model.aw;
import com.tencent.mm.plugin.luckymoney.model.ba;
import com.tencent.mm.plugin.luckymoney.model.bb;
import com.tencent.mm.plugin.luckymoney.model.bf;
import com.tencent.mm.plugin.luckymoney.model.bg;
import com.tencent.mm.plugin.luckymoney.model.o;
import com.tencent.mm.plugin.luckymoney.model.p;
import com.tencent.mm.plugin.luckymoney.model.w;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.chat.e.b;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.alq;
import com.tencent.mm.protocal.protobuf.bvi;
import com.tencent.mm.protocal.protobuf.cbe;
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
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.ui.x;
import com.tencent.mm.wallet_core.c.ag;
import com.tencent.mm.wallet_core.ui.MMScrollView;
import com.tenpay.android.wechat.MyKeyboardWindow;
import java.math.RoundingMode;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class LuckyMoneyPrepareUI
  extends LuckyMoneyBaseUI
  implements h
{
  private static final String yQK;
  private int dYe;
  private int gwE;
  private MTimerHandler klF;
  private int mChannel;
  protected View mKBLayout;
  protected MyKeyboardWindow mKeyboard;
  private boolean mKindaEnable;
  private IListener<pi> mPayLoopInterruptListener;
  private String mSessionId;
  private int mType;
  private TextView nAB;
  private TextView qAC;
  private EmojiInfo rfq;
  private Button rlN;
  public Dialog tipDialog;
  private o yPZ;
  private LuckyMoneyNumInputView yQL;
  private LuckyMoneyTextInputView yQN;
  private Button yQO;
  private MMScrollView yQR;
  private TextView yQS;
  private c yQU;
  private String yUc;
  private int yUr;
  private com.tencent.mm.plugin.luckymoney.model.h yVa;
  private int yXu;
  private LuckyMoneyMoneyInputView yYI;
  private View yYJ;
  private View yYK;
  private ViewGroup yYL;
  private String yYM;
  private int yYN;
  private boolean yYO;
  private String yYP;
  private int zdC;
  private a zdk;
  private View zdl;
  private ChatFooterPanel zdv;
  private ViewGroup zdx;
  private hf zdz;
  private int zfQ;
  private String zfX;
  private String zga;
  private Dialog zhA;
  private RelativeLayout zhB;
  private TextView zhC;
  private TextView zhD;
  private ImageView zhE;
  private ImageView zhF;
  private ImageView zhG;
  private TextView zhH;
  private ViewGroup zhI;
  private TextView zhJ;
  private ViewGroup zhK;
  private TextView zhL;
  private ImageView zhM;
  private TextView zhN;
  private ViewGroup zhO;
  private WeImageView zhP;
  private TextView zhQ;
  private int zhR;
  private String zhS;
  private String zhT;
  private RealnameGuideHelper zhU;
  private String zhV;
  private String zhW;
  private String zhX;
  private hg zhY;
  private int zhZ;
  private Dialog zhz;
  private String zia;
  private String zib;
  private boolean zic;
  private boolean zid;
  private int zie;
  private String zif;
  private int zig;
  private long zih;
  private long zii;
  private String zij;
  private com.tencent.mm.ui.widget.d zik;
  private boolean zil;
  private boolean zim;
  private boolean zin;
  private boolean zio;
  private IListener<ut> zip;
  
  static
  {
    AppMethodBeat.i(213535);
    yQK = "https://" + WeChatHosts.domainString(2131761715) + "/touch/scene_product.html?scene_id=kf7";
    AppMethodBeat.o(213535);
  }
  
  public LuckyMoneyPrepareUI()
  {
    AppMethodBeat.i(65882);
    this.yQL = null;
    this.yYI = null;
    this.yQN = null;
    this.qAC = null;
    this.yQO = null;
    this.rlN = null;
    this.tipDialog = null;
    this.zhz = null;
    this.zhA = null;
    this.yQU = new c();
    this.klF = null;
    this.zhR = 1;
    this.zhS = com.tencent.mm.wallet_core.ui.f.bpq("CNY");
    this.zhT = null;
    this.yUc = "";
    this.zfQ = 1;
    this.zdC = 0;
    this.zic = false;
    this.mPayLoopInterruptListener = new LuckyMoneyPrepareUI.1(this);
    this.zil = false;
    this.zim = false;
    this.zin = false;
    this.zio = false;
    this.zip = new IListener() {};
    this.dYe = 0;
    this.zga = "";
    AppMethodBeat.o(65882);
  }
  
  private void A(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(65897);
    this.yQN.A(paramEmojiInfo);
    if ((this.zdC == 0) || (this.zdC == 2)) {
      if (com.tencent.mm.plugin.emoji.h.b.y(paramEmojiInfo)) {
        this.zfQ = 2;
      }
    }
    for (;;)
    {
      this.zdz = new hf();
      this.zdz.eEH = 1L;
      this.zdz.bfK();
      AppMethodBeat.o(65897);
      return;
      if (com.tencent.mm.plugin.emoji.h.b.w(paramEmojiInfo))
      {
        this.zfQ = 4;
      }
      else
      {
        this.zfQ = 3;
        continue;
        if (this.zdC == 1) {
          this.zfQ = 2;
        }
      }
    }
  }
  
  private void Qa(int paramInt)
  {
    AppMethodBeat.i(213517);
    Log.i("MicroMsg.LuckyMoneyPrepareUI", "update view by mode: %s, %s", new Object[] { Integer.valueOf(this.mType), Integer.valueOf(paramInt) });
    if (paramInt == this.mType)
    {
      AppMethodBeat.o(213517);
      return;
    }
    double d;
    if (this.mType == 0)
    {
      this.zhJ.setText(2131762667);
      this.zhK.setVisibility(8);
      this.yQL.setVisibility(0);
      this.zhL.setVisibility(0);
      this.nAB.setVisibility(8);
      this.yQU.a(this.yQL);
      this.yQU.a(this.yYI);
      this.yQU.a(this.yQN);
      paramInt = this.yQL.getInput();
      d = this.yYI.getInput();
      this.yYI.setType(this.mType);
      this.yYI.setShowGroupIcon(false);
      this.yYI.setTitle(getString(2131762754));
      if ((d > 0.0D) && (paramInt > 0)) {
        this.yYI.setAmount(com.tencent.mm.wallet_core.ui.f.formatMoney2f(d / paramInt));
      }
      this.yYI.setMaxAmount(this.yPZ.yPw);
      AppMethodBeat.o(213517);
      return;
    }
    int i;
    if (this.mType == 1)
    {
      this.zhJ.setText(2131762666);
      this.zhK.setVisibility(8);
      this.yQL.setVisibility(0);
      this.zhL.setVisibility(0);
      this.nAB.setVisibility(8);
      this.yQU.a(this.yQL);
      this.yQU.a(this.yYI);
      this.yQU.a(this.yQN);
      i = this.yQL.getInput();
      d = this.yYI.getInput();
      this.yYI.setType(this.mType);
      this.yYI.setMaxAmount(this.yPZ.yPy);
      this.yYI.setTitle(getString(2131762753));
      this.yYI.setShowGroupIcon(true);
      if ((paramInt == 3) && (d > 0.0D))
      {
        this.yYI.setAmount(com.tencent.mm.wallet_core.ui.f.formatMoney2f(d));
        AppMethodBeat.o(213517);
        return;
      }
      if ((d > 0.0D) && (i > 0)) {
        this.yYI.setAmount(com.tencent.mm.wallet_core.ui.f.formatMoney2f(d * i));
      }
      AppMethodBeat.o(213517);
      return;
    }
    if (this.mType == 3)
    {
      this.zhJ.setText(2131762664);
      this.zhK.setVisibility(0);
      this.yQL.setVisibility(8);
      this.zhL.setVisibility(8);
      this.nAB.setVisibility(8);
      this.yQU.b(this.yQL);
      this.yQU.a(this.yYI);
      this.yQU.a(this.yQN);
      i = this.yQL.getInput();
      d = this.yYI.getInput();
      this.yYI.setType(this.mType);
      this.yYI.setShowGroupIcon(false);
      this.yYI.setTitle(getString(2131762751));
      if ((paramInt != 0) || (d <= 0.0D) || (i <= 0)) {
        break label655;
      }
      this.yYI.setAmount(com.tencent.mm.wallet_core.ui.f.formatMoney2f(d * i));
    }
    for (;;)
    {
      this.yYI.setMaxAmount(this.yPZ.yPw);
      if (!this.zid)
      {
        this.zhK.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(213475);
            TextView localTextView = (TextView)LuckyMoneyPrepareUI.this.findViewById(2131304120);
            ImageView localImageView = (ImageView)LuckyMoneyPrepareUI.this.findViewById(2131304117);
            int i = localTextView.getRight();
            int j = com.tencent.mm.cb.a.fromDPToPix(LuckyMoneyPrepareUI.this.getContext(), 52);
            i = localImageView.getLeft() - com.tencent.mm.cb.a.fromDPToPix(LuckyMoneyPrepareUI.this.getContext(), 8) - (i + j);
            if (i > 0)
            {
              Log.d("MicroMsg.LuckyMoneyPrepareUI", "usernametv maxwidth: %s", new Object[] { Integer.valueOf(i) });
              LuckyMoneyPrepareUI.p(LuckyMoneyPrepareUI.this).setMaxWidth(i);
            }
            AppMethodBeat.o(213475);
          }
        });
        this.zid = true;
      }
      AppMethodBeat.o(213517);
      return;
      label655:
      if (d > 0.0D) {
        this.yYI.setAmount(com.tencent.mm.wallet_core.ui.f.formatMoney2f(d));
      }
    }
  }
  
  private void Qb(int paramInt)
  {
    AppMethodBeat.i(213518);
    Log.i("MicroMsg.LuckyMoneyPrepareUI", "doPrePareBtnClick() userConfirmJump:%s", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.plugin.report.service.h.CyF.a(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(efB()), Integer.valueOf(4) });
    com.tencent.mm.plugin.report.service.h.CyF.a(15511, new Object[] { Integer.valueOf(this.zhR), Integer.valueOf(2) });
    if (this.yYI.eeH() != 0)
    {
      u.makeText(getContext(), 2131767474, 0).show();
      AppMethodBeat.o(213518);
      return;
    }
    int i = this.yQL.getInput();
    double d = this.yYI.getInput();
    long l2 = 0L;
    long l1;
    if (this.mType == 1)
    {
      l1 = com.tencent.mm.wallet_core.ui.f.E(d);
      g.aAi();
      g.aAh().azQ().set(356354, Integer.valueOf(i));
      str = this.yQN.getInput().replace("\r", "").replace("\n", "");
      localObject = str;
      if (Util.isNullOrNil(str)) {
        if (!Util.isNullOrNil(this.zhT)) {
          break label355;
        }
      }
    }
    label355:
    for (Object localObject = getString(2131762600);; localObject = this.zhT)
    {
      hideTenpayKB();
      if (this.gwE != 2) {
        break label364;
      }
      doSceneProgress(new com.tencent.mm.plugin.luckymoney.f2f.a.d(i, (int)l1, this.mType, (int)l2), false);
      egD();
      AppMethodBeat.o(213518);
      return;
      if (this.mType == 3)
      {
        l1 = com.tencent.mm.wallet_core.ui.f.E(d);
        break;
      }
      l1 = com.tencent.mm.wallet_core.ui.f.E(i * d);
      l2 = com.tencent.mm.wallet_core.ui.f.E(d);
      g.aAi();
      g.aAh().azQ().set(356353, Integer.valueOf(i));
      break;
    }
    label364:
    String str = getIntent().getStringExtra("key_username");
    if (this.zhR == 1)
    {
      Log.i("MicroMsg.LuckyMoneyPrepareUI", "doPrePareBtnClick() ifGetConfig=%s mUniqueId=%s waitingGetConfig=%s ifAutoRMBPrePareBtn=%s", new Object[] { Boolean.valueOf(this.zil), Util.nullAsNil(this.zfX), Boolean.valueOf(this.zim), Boolean.valueOf(this.zin) });
      if (this.zil)
      {
        a(paramInt, str, i, l1, l2, (String)localObject);
        AppMethodBeat.o(213518);
        return;
      }
      this.zin = true;
      this.zie = paramInt;
      this.zif = str;
      this.zig = i;
      this.zih = l1;
      this.zii = l2;
      this.zij = ((String)localObject);
      if (this.zhA != null) {
        this.zhA.show();
      }
      for (;;)
      {
        if (!this.zim) {
          qR(false);
        }
        AppMethodBeat.o(213518);
        return;
        this.zhA = com.tencent.mm.ui.base.h.a(this, 3, 2131821007, getString(2131762446), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(65830);
            Log.i("MicroMsg.LuckyMoneyPrepareUI", "coperationTipDialogNoTransparent onCancel()");
            LuckyMoneyPrepareUI.q(LuckyMoneyPrepareUI.this);
            LuckyMoneyPrepareUI.r(LuckyMoneyPrepareUI.this);
            if ((LuckyMoneyPrepareUI.s(LuckyMoneyPrepareUI.this) != null) && (LuckyMoneyPrepareUI.s(LuckyMoneyPrepareUI.this).isShowing())) {
              LuckyMoneyPrepareUI.s(LuckyMoneyPrepareUI.this).dismiss();
            }
            if ((LuckyMoneyPrepareUI.t(LuckyMoneyPrepareUI.this).getVisibility() == 8) || (LuckyMoneyPrepareUI.u(LuckyMoneyPrepareUI.this).getVisibility() == 4))
            {
              Log.i("MicroMsg.LuckyMoneyPrepareUI", "usr cancel, & visibility not visiable, so finish");
              LuckyMoneyPrepareUI.this.finish();
            }
            LuckyMoneyPrepareUI.this.zbX.forceCancel();
            AppMethodBeat.o(65830);
          }
        });
      }
    }
    Log.i("MicroMsg.LuckyMoneyPrepareUI", "currency=%s userConfiremJump:%s", new Object[] { Integer.valueOf(this.zhR), Integer.valueOf(paramInt) });
    addSceneEndListener(1647);
    if ((this.yYO) && (!Util.isNullOrNil(str))) {}
    for (localObject = new as(i, l1, l2, this.mType, (String)localObject, str, com.tencent.mm.plugin.luckymoney.model.af.efj(), com.tencent.mm.model.z.aTY(), this.zhR);; localObject = new as(i, l1, l2, this.mType, (String)localObject, null, com.tencent.mm.plugin.luckymoney.model.af.efj(), com.tencent.mm.model.z.aTY(), this.zhR))
    {
      doSceneProgress((com.tencent.mm.ak.q)localObject, false);
      break;
    }
  }
  
  private void a(int paramInt1, String paramString1, int paramInt2, long paramLong1, long paramLong2, String paramString2)
  {
    AppMethodBeat.i(213520);
    String str2 = "";
    int i = 0;
    if (this.rfq != null)
    {
      str2 = this.rfq.getMd5();
      i = this.rfq.field_type;
    }
    String str1 = "";
    if (this.yVa != null) {
      str1 = this.yVa.yUD;
    }
    Log.i("MicroMsg.LuckyMoneyPrepareUI", "currency is RMB. userConfirmJump:%s lastPayResult:%s mSendId:%s mUniqueId:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(this.dYe), this.yUc, this.zfX });
    if (com.tencent.mm.plugin.luckymoney.model.af.IA(getIntent().getStringExtra("key_username")))
    {
      Log.i("MicroMsg.LuckyMoneyPrepareUI", "doRMBPrePareBtnClick use rtx luckmoney");
      if ((this.yYO) && (!Util.isNullOrNil(paramString1))) {}
      for (paramString1 = new bb(paramInt2, paramLong1, paramLong2, this.mType, paramString2, com.tencent.mm.plugin.luckymoney.model.af.efj(), paramString1, com.tencent.mm.plugin.luckymoney.model.af.Ir(paramString1), com.tencent.mm.model.z.aTY(), com.tencent.mm.model.z.aUa(), this.yUr, str1, this.zfX, paramInt1, this.dYe, this.yUc, str2, i);; paramString1 = new bb(paramInt2, paramLong1, paramLong2, this.mType, paramString2, com.tencent.mm.plugin.luckymoney.model.af.efj(), null, null, com.tencent.mm.model.z.aTY(), com.tencent.mm.model.z.aUa(), this.yUr, str1, this.zfX, paramInt1, this.dYe, this.yUc, str2, i))
      {
        doSceneProgress(paramString1, false);
        if (!Util.isNullOrNil(str1)) {
          com.tencent.mm.plugin.report.service.h.CyF.dN(991, 11);
        }
        egD();
        AppMethodBeat.o(213520);
        return;
      }
    }
    Log.i("MicroMsg.LuckyMoneyPrepareUI", "doRMBPrePareBtnClick use normal luckmoney");
    if ((this.yYO) && (!Util.isNullOrNil(paramString1))) {}
    for (paramString1 = new ba(paramInt2, paramLong1, paramLong2, this.mType, paramString2, com.tencent.mm.plugin.luckymoney.model.af.efj(), paramString1, com.tencent.mm.plugin.luckymoney.model.af.Ir(paramString1), com.tencent.mm.model.z.aTY(), com.tencent.mm.model.z.aUa(), this.yUr, str1, this.zfX, paramInt1, this.dYe, this.yUc, str2, i, this.zhX);; paramString1 = new ba(paramInt2, paramLong1, paramLong2, this.mType, paramString2, com.tencent.mm.plugin.luckymoney.model.af.efj(), null, null, com.tencent.mm.model.z.aTY(), com.tencent.mm.model.z.aUa(), this.yUr, str1, this.zfX, paramInt1, this.dYe, this.yUc, str2, i, this.zhX))
    {
      doSceneProgress(paramString1, false);
      break;
    }
  }
  
  private void aDH(String paramString)
  {
    AppMethodBeat.i(65898);
    Log.i("MicroMsg.LuckyMoneyPrepareUI", "initH5LuckyMoneyView  currencyWording=".concat(String.valueOf(paramString)));
    TextView localTextView = (TextView)findViewById(2131304016);
    if (!Util.isNullOrNil(paramString))
    {
      localTextView.setText(paramString);
      AppMethodBeat.o(65898);
      return;
    }
    localTextView.setText(getString(2131762584));
    AppMethodBeat.o(65898);
  }
  
  private void aDI(String paramString)
  {
    AppMethodBeat.i(65911);
    Log.i("MicroMsg.LuckyMoneyPrepareUI", "do business callback");
    if (com.tencent.mm.plugin.luckymoney.model.af.IA(getIntent().getStringExtra("key_username")))
    {
      doSceneProgress(new an(this.yUc, paramString, this.zhV), false);
      AppMethodBeat.o(65911);
      return;
    }
    doSceneProgress(new am(this.yUc, paramString, this.zhV), false);
    AppMethodBeat.o(65911);
  }
  
  private void b(double paramDouble, String paramString)
  {
    AppMethodBeat.i(65908);
    if (Util.isNullOrNil(paramString))
    {
      this.qAC.setText(com.tencent.mm.wallet_core.ui.f.D(paramDouble));
      AppMethodBeat.o(65908);
      return;
    }
    this.qAC.setText(paramString + com.tencent.mm.wallet_core.ui.f.formatMoney2f(paramDouble));
    AppMethodBeat.o(65908);
  }
  
  private void b(cbe paramcbe)
  {
    AppMethodBeat.i(65892);
    Log.i("MicroMsg.LuckyMoneyPrepareUI", "update envelope");
    if ((this.yVa != null) && (paramcbe != null) && (this.gwE != 2))
    {
      this.zhB.setVisibility(0);
      boolean bool = com.tencent.mm.y.c.axV().a(ar.a.Ofj, ar.a.Ofl);
      Object localObject;
      if (!this.zic)
      {
        localObject = com.tencent.mm.plugin.report.service.h.CyF;
        if (!bool) {
          break label234;
        }
      }
      label234:
      for (int i = 2;; i = 1)
      {
        ((com.tencent.mm.plugin.report.service.h)localObject).a(18890, new Object[] { Integer.valueOf(1), Integer.valueOf(i), this.mSessionId });
        this.zic = true;
        if ((!this.yVa.yUE) || (Util.isNullOrNil(this.yVa.yUF))) {
          break label336;
        }
        localObject = Util.stringToList((String)g.aAh().azQ().get(ar.a.Ofo, ""), ",");
        Iterator localIterator = ((List)localObject).iterator();
        String str;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          str = (String)localIterator.next();
        } while (!str.equals(this.yVa.yUC.Lot));
        Log.d("MicroMsg.LuckyMoneyPrepareUI", "has alert illegal: %s", new Object[] { str });
        AppMethodBeat.o(65892);
        return;
      }
      ((List)localObject).add(this.yVa.yUC.Lot);
      g.aAh().azQ().set(ar.a.Ofo, Util.listToString((List)localObject, ","));
      Log.i("MicroMsg.LuckyMoneyPrepareUI", "show alert illegal: %s", new Object[] { this.yVa.yUC.Lot });
      com.tencent.mm.ui.base.h.a(getContext(), this.yVa.yUF, "", getString(2131768713), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      label336:
      if ((paramcbe == null) || (paramcbe.dfT != 1)) {
        break label450;
      }
      this.zhB.setEnabled(false);
      if (!Util.isNullOrNil(paramcbe.MgQ)) {
        this.zhC.setText(paramcbe.MgQ);
      }
      this.zhE.setImageBitmap(null);
      this.zhF.setVisibility(8);
      this.zhC.setTextColor(getResources().getColor(2131099662));
    }
    for (;;)
    {
      if ((paramcbe == null) || (paramcbe.iwy != 2)) {
        break label584;
      }
      this.zhD.setVisibility(0);
      AppMethodBeat.o(65892);
      return;
      this.zhB.setVisibility(8);
      break;
      label450:
      if ((paramcbe != null) && (!Util.isNullOrNil(paramcbe.MgB)))
      {
        this.zhB.setEnabled(true);
        this.zhC.setText(paramcbe.MgB);
        ((com.tencent.mm.plugin.luckymoney.a.a)g.af(com.tencent.mm.plugin.luckymoney.a.a.class)).a(this.zhE, paramcbe);
        this.zhF.setVisibility(0);
        this.zhC.setTextColor(getResources().getColor(2131100046));
      }
      else
      {
        this.zhB.setEnabled(true);
        this.zhE.setImageBitmap(null);
        this.zhC.setText("");
        this.zhF.setVisibility(0);
        this.zhC.setTextColor(getResources().getColor(2131100046));
      }
    }
    label584:
    this.zhD.setVisibility(8);
    AppMethodBeat.o(65892);
  }
  
  private int efB()
  {
    AppMethodBeat.i(65909);
    if (this.yYO)
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
  
  private void egC()
  {
    AppMethodBeat.i(213516);
    if ((this.yPZ == null) || (this.yPZ.yUZ == null) || (this.gwE == 2))
    {
      this.zhO.setVisibility(8);
      AppMethodBeat.o(213516);
      return;
    }
    if (!Util.isNullOrNil(this.yPZ.yUZ.dQx))
    {
      this.zhQ.setText(this.yPZ.yUZ.dQx);
      int i = com.tencent.mm.cb.a.jn(getContext()) - com.tencent.mm.cb.a.fromDPToPix(getContext(), 70);
      if (i > 0) {
        this.zhQ.setMaxWidth(i);
      }
      this.zhO.setVisibility(0);
      if (!Util.isNullOrNil(this.yPZ.yUZ.qGB))
      {
        Object localObject = new c.a();
        com.tencent.mm.plugin.luckymoney.b.a.eex();
        ((c.a)localObject).prefixPath = com.tencent.mm.plugin.luckymoney.b.a.eeA();
        com.tencent.mm.av.q.bcW();
        ((c.a)localObject).jbw = null;
        ((c.a)localObject).jbf = true;
        ((c.a)localObject).iaT = false;
        ((c.a)localObject).jbd = true;
        localObject = ((c.a)localObject).bdv();
        com.tencent.mm.av.q.bcV().a(this.yPZ.yUZ.qGB, this.zhP, (com.tencent.mm.av.a.a.c)localObject);
      }
      this.zhO.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(213512);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          Log.i("MicroMsg.LuckyMoneyPrepareUI", "jump to action type: %s", new Object[] { Integer.valueOf(LuckyMoneyPrepareUI.h(LuckyMoneyPrepareUI.this).yUZ.pTI) });
          switch (LuckyMoneyPrepareUI.h(LuckyMoneyPrepareUI.this).yUZ.pTI)
          {
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(213512);
            return;
            com.tencent.mm.wallet_core.ui.f.p(LuckyMoneyPrepareUI.this.getContext(), LuckyMoneyPrepareUI.h(LuckyMoneyPrepareUI.this).yUZ.yUK, false);
            continue;
            com.tencent.mm.wallet_core.ui.f.am(LuckyMoneyPrepareUI.this.getContext(), LuckyMoneyPrepareUI.h(LuckyMoneyPrepareUI.this).yUZ.yUL);
            continue;
            com.tencent.mm.wallet_core.ui.f.u(LuckyMoneyPrepareUI.h(LuckyMoneyPrepareUI.this).yUZ.yUL, LuckyMoneyPrepareUI.h(LuckyMoneyPrepareUI.this).yUZ.yUK, 0, 1100);
            continue;
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("finder_username", LuckyMoneyPrepareUI.h(LuckyMoneyPrepareUI.this).yUZ.yUL);
            ((aj)g.ah(aj.class)).enterFinderProfileUI(LuckyMoneyPrepareUI.this.getContext(), paramAnonymousView);
            continue;
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("extra_id", LuckyMoneyPrepareUI.h(LuckyMoneyPrepareUI.this).yUZ.yUL);
            paramAnonymousView.putExtra("preceding_scence", 21);
            com.tencent.mm.br.c.b(LuckyMoneyPrepareUI.this.getContext(), "emoji", ".ui.EmojiStoreDetailUI", paramAnonymousView);
          }
        }
      });
      AppMethodBeat.o(213516);
      return;
    }
    this.zhO.setVisibility(8);
    AppMethodBeat.o(213516);
  }
  
  private void egD()
  {
    AppMethodBeat.i(213519);
    if (this.tipDialog != null)
    {
      this.tipDialog.show();
      AppMethodBeat.o(213519);
      return;
    }
    this.tipDialog = com.tencent.mm.wallet_core.ui.h.a(getContext(), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(213476);
        if ((LuckyMoneyPrepareUI.v(LuckyMoneyPrepareUI.this) != null) && (LuckyMoneyPrepareUI.v(LuckyMoneyPrepareUI.this).isShowing())) {
          LuckyMoneyPrepareUI.v(LuckyMoneyPrepareUI.this).dismiss();
        }
        if ((LuckyMoneyPrepareUI.w(LuckyMoneyPrepareUI.this).getVisibility() == 8) || (LuckyMoneyPrepareUI.x(LuckyMoneyPrepareUI.this).getVisibility() == 4))
        {
          Log.i("MicroMsg.LuckyMoneyPrepareUI", "usr cancel, & visibility not visiable, so finish");
          LuckyMoneyPrepareUI.this.finish();
        }
        LuckyMoneyPrepareUI.this.zbX.forceCancel();
        AppMethodBeat.o(213476);
      }
    });
    this.tipDialog.setCancelable(false);
    AppMethodBeat.o(213519);
  }
  
  private boolean egE()
  {
    AppMethodBeat.i(65907);
    if ((this.yPZ != null) && (!Util.isNullOrNil(this.yPZ.yUV)))
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
    String str2 = com.tencent.mm.model.z.aTY();
    if (paramInt == -1)
    {
      Log.i("MicroMsg.LuckyMoneyPrepareUI", "onActivityResult() resultCode == RESULT_OK");
      this.dYe = 1;
      this.zga = "";
      paramIntent = new aw(this.yUc, this.zfX, 1, str2, Util.nullAsNil(str1));
      g.aAg().hqi.a(paramIntent, 0);
      AppMethodBeat.o(65899);
      return;
    }
    if (paramIntent != null) {}
    for (this.dYe = paramIntent.getIntExtra("key_pay_reslut_type", 3);; this.dYe = 3)
    {
      this.zga = this.yUc;
      Log.i("MicroMsg.LuckyMoneyPrepareUI", "onActivityResult() resultCode != RESULT_OK  payType:%s", new Object[] { Integer.valueOf(this.dYe) });
      paramIntent = new aw(this.yUc, this.zfX, this.dYe, str2, Util.nullAsNil(str1));
      break;
      Log.i("MicroMsg.LuckyMoneyPrepareUI", "doNetSceneLuckyMoneyReport() data == null");
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(65891);
    if (this.zhR == 1) {
      addIconOptionMenu(0, 2131690843, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(65832);
          LuckyMoneyPrepareUI.y(LuckyMoneyPrepareUI.this);
          AppMethodBeat.o(65832);
          return true;
        }
      });
    }
    for (;;)
    {
      egC();
      AppMethodBeat.o(65891);
      return;
      addIconOptionMenu(0, 2131233685, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(213477);
          if ((LuckyMoneyPrepareUI.h(LuckyMoneyPrepareUI.this) != null) && (!Util.isNullOrNil(LuckyMoneyPrepareUI.h(LuckyMoneyPrepareUI.this).yUU))) {
            com.tencent.mm.wallet_core.ui.f.p(LuckyMoneyPrepareUI.this.getContext(), LuckyMoneyPrepareUI.h(LuckyMoneyPrepareUI.this).yUU, false);
          }
          for (;;)
          {
            AppMethodBeat.o(213477);
            return true;
            com.tencent.mm.wallet_core.ui.f.p(LuckyMoneyPrepareUI.this.getContext(), "https://hkwallet.moneydata.hk/hybrid/www/weixin/hongbao_hk_v2/zh_hk/faq.shtml", false);
          }
        }
      });
    }
  }
  
  private void qR(boolean paramBoolean)
  {
    AppMethodBeat.i(65894);
    Log.i("MicroMsg.LuckyMoneyPrepareUI", "do get config");
    if (paramBoolean) {
      this.zhz = com.tencent.mm.plugin.luckymoney.model.af.gu(getContext());
    }
    this.zim = true;
    if (com.tencent.mm.plugin.luckymoney.model.af.IA(getIntent().getStringExtra("key_username")))
    {
      i = ((Integer)g.aAh().azQ().get(ar.a.Ofn, Integer.valueOf(0))).intValue();
      this.zhZ = i;
      doSceneProgress(new ar("v1.0", i), false);
      AppMethodBeat.o(65894);
      return;
    }
    int i = ((Integer)g.aAh().azQ().get(ar.a.Ofm, Integer.valueOf(0))).intValue();
    this.zhZ = i;
    doSceneProgress(new aq("v1.0", i, (byte)0), false);
    AppMethodBeat.o(65894);
  }
  
  protected final void ak(final View paramView, final int paramInt)
  {
    AppMethodBeat.i(65903);
    this.mKeyboard = ((MyKeyboardWindow)findViewById(2131308962));
    this.mKBLayout = findViewById(2131308960);
    View localView = findViewById(2131308963);
    final EditText localEditText = (EditText)paramView.findViewById(2131304116);
    if ((this.mKeyboard == null) || (localEditText == null) || (this.mKBLayout == null))
    {
      AppMethodBeat.o(65903);
      return;
    }
    com.tencent.mm.wallet_core.ui.f.setNoSystemInputOnEditText(localEditText);
    localEditText.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      boolean firstTime = true;
      
      public final void onFocusChange(final View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(213506);
        if ((paramAnonymousView.isFocused()) && (!this.val$isShowSysKB))
        {
          ((InputMethodManager)LuckyMoneyPrepareUI.this.getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramAnonymousView.getWindowToken(), 0);
          new MMHandler().postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(213504);
              if ((!LuckyMoneyPrepareUI.this.mKBLayout.isShown()) && (paramAnonymousView.isShown()))
              {
                LuckyMoneyPrepareUI.this.mKBLayout.setVisibility(0);
                LuckyMoneyPrepareUI.K(LuckyMoneyPrepareUI.this).setVisibility(8);
              }
              LuckyMoneyPrepareUI.d(LuckyMoneyPrepareUI.this, LuckyMoneyPrepareUI.38.this.val$editMode);
              LuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText)paramAnonymousView);
              ((InputMethodManager)LuckyMoneyPrepareUI.this.getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramAnonymousView.getWindowToken(), 0);
              AppMethodBeat.o(213504);
            }
          }, 300L);
          AppMethodBeat.o(213506);
          return;
        }
        new MMHandler().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(213505);
            LuckyMoneyPrepareUI.K(LuckyMoneyPrepareUI.this).setVisibility(0);
            LuckyMoneyPrepareUI.this.hideTenpayKB();
            ((InputMethodManager)LuckyMoneyPrepareUI.this.getContext().getSystemService("input_method")).showSoftInput(LuckyMoneyPrepareUI.38.this.val$hintTv, 0);
            AppMethodBeat.o(213505);
          }
        }, 200L);
        AppMethodBeat.o(213506);
      }
    });
    localEditText.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(65875);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$45", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
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
            LuckyMoneyPrepareUI.K(LuckyMoneyPrepareUI.this).setVisibility(0);
            ((InputMethodManager)LuckyMoneyPrepareUI.this.getContext().getSystemService("input_method")).showSoftInput(localEditText, 0);
          }
        }
      }
    });
    TextView localTextView = (TextView)paramView.findViewById(2131304016);
    if (localTextView != null) {
      localTextView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(65876);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$46", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
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
                  AppMethodBeat.i(213507);
                  LuckyMoneyPrepareUI.this.mKBLayout.setVisibility(0);
                  LuckyMoneyPrepareUI.40.this.val$parent.requestFocus();
                  if (LuckyMoneyPrepareUI.this.mKeyboard != null) {
                    LuckyMoneyPrepareUI.this.mKeyboard.setInputEditText(LuckyMoneyPrepareUI.40.this.val$hintTv);
                  }
                  LuckyMoneyPrepareUI.d(LuckyMoneyPrepareUI.this, LuckyMoneyPrepareUI.40.this.val$editMode);
                  AppMethodBeat.o(213507);
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
        AppMethodBeat.i(213508);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$47", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        LuckyMoneyPrepareUI.this.hideTenpayKB();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$47", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(213508);
      }
    });
    AppMethodBeat.o(65903);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(65895);
    if ((paramKeyEvent.getKeyCode() == 4) && (this.yYJ.getVisibility() == 0))
    {
      this.yYJ.setVisibility(8);
      efZ();
      AppMethodBeat.o(65895);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(65895);
    return bool;
  }
  
  public final void eeI()
  {
    AppMethodBeat.i(65906);
    double d1;
    double d3;
    double d2;
    if (com.tencent.mm.plugin.luckymoney.model.af.IA(getIntent().getStringExtra("key_username")))
    {
      com.tencent.mm.plugin.luckymoney.b.a.eex();
      this.yPZ = com.tencent.mm.plugin.luckymoney.b.a.eez().efe();
      if ((this.mType != 3) || (this.yYI.eeH() == 3)) {
        break label162;
      }
      d1 = this.yYI.getInput();
      if (!Util.isNullOrNil(this.zhX)) {
        break label149;
      }
      d3 = 0.0D;
      d2 = d1;
      d1 = d3;
    }
    for (;;)
    {
      if (this.yQU.egj())
      {
        Log.i("MicroMsg.LuckyMoneyPrepareUI", "has error");
        this.yQO.setClickable(false);
        this.yQO.setEnabled(false);
        b(d2, this.zhS);
        AppMethodBeat.o(65906);
        return;
        com.tencent.mm.plugin.luckymoney.b.a.eex();
        this.yPZ = com.tencent.mm.plugin.luckymoney.b.a.eey().efe();
        break;
        label149:
        d2 = d1;
        d3 = d1;
        d1 = d2;
        d2 = d3;
        continue;
        label162:
        if ((this.mType == 3) || (this.yYI.eeH() == 3) || (this.yQL.eeH() == 3)) {
          break label1196;
        }
        int i = this.yQL.getInput();
        d1 = this.yYI.getInput();
        if (this.mType == 0)
        {
          d3 = i;
          d2 = this.yYI.getInput();
          d3 = d1 * d3;
          d1 = d2;
          d2 = d3;
          continue;
        }
        if (i <= 0) {
          break label1185;
        }
        d3 = com.tencent.mm.wallet_core.ui.f.a(String.valueOf(d1), String.valueOf(i), String.valueOf(this.yPZ.yPv).length() + 2, RoundingMode.HALF_UP);
        d2 = d1;
        d1 = d3;
        continue;
      }
      boolean bool2;
      if ((d2 == 0.0D) || (d1 == 0.0D)) {
        bool2 = true;
      }
      for (;;)
      {
        label547:
        boolean bool1;
        if (bool2)
        {
          this.yQO.setClickable(false);
          this.yQO.setEnabled(false);
          break;
          if ((d2 > this.yPZ.yPy) && (this.yPZ.yPy > 0.0D))
          {
            this.yQU.aeu(getString(2131762752, new Object[] { Math.round(this.yPZ.yPy), Util.nullAs(this.yPZ.yPB, "") }));
            bool2 = true;
            continue;
          }
          if (d1 <= 0.0D) {
            break label1179;
          }
          Log.i("MicroMsg.LuckyMoneyPrepareUI", "perAmount ".concat(String.valueOf(d1)));
          if (this.mType == 0)
          {
            if ((d1 <= this.yPZ.yPw) || (this.yPZ.yPw <= 0.0D)) {
              break label1173;
            }
            if (egE())
            {
              this.yQU.aeu(getString(2131762697, new Object[] { this.yPZ.yUV, Math.round(this.yPZ.yPw), Util.nullAs(this.yPZ.yPB, "") }));
              bool1 = true;
            }
          }
        }
        for (;;)
        {
          Log.i("MicroMsg.LuckyMoneyPrepareUI", "furtherCheckHasErr:" + bool1 + " for max value");
          bool2 = bool1;
          if (!bool1)
          {
            if (this.mType != 0) {
              break label1022;
            }
            bool2 = bool1;
            if (d1 < this.yPZ.yPx)
            {
              if (!egE()) {
                break label972;
              }
              this.yQU.aeu(getString(2131762699, new Object[] { this.yPZ.yUV, com.tencent.mm.wallet_core.ui.f.formatMoney2f(this.yPZ.yPx), Util.nullAs(this.yPZ.yPB, "") }));
              label676:
              bool2 = true;
            }
          }
          label972:
          label1022:
          do
          {
            Log.i("MicroMsg.LuckyMoneyPrepareUI", "furtherCheckHasErr:" + bool2 + " for min value");
            break;
            this.yQU.aeu(getString(2131762696, new Object[] { Math.round(this.yPZ.yPw), Util.nullAs(this.yPZ.yPB, "") }));
            break label547;
            if ((d1 <= this.yPZ.yPz) || (this.yPZ.yPz <= 0.0D)) {
              break label1173;
            }
            if ((this.yPZ != null) && (!Util.isNullOrNil(this.yPZ.yUV))) {
              this.yQU.aeu(getString(2131762697, new Object[] { this.yPZ.yUV, Math.round(this.yPZ.yPz), Util.nullAs(this.yPZ.yPB, "") }));
            }
            for (;;)
            {
              this.yQL.onError();
              this.yYI.onError();
              bool1 = true;
              break;
              this.yQU.aeu(getString(2131762696, new Object[] { Math.round(this.yPZ.yPz), Util.nullAs(this.yPZ.yPB, "") }));
            }
            this.yQU.aeu(getString(2131762698, new Object[] { com.tencent.mm.wallet_core.ui.f.formatMoney2f(this.yPZ.yPx), Util.nullAs(this.yPZ.yPB, "") }));
            break label676;
            bool2 = bool1;
          } while (d1 >= 0.01D);
          if (egE()) {
            this.yQU.aeu(getString(2131762699, new Object[] { this.yPZ.yUV, "0.01", Util.nullAs(this.yPZ.yPB, "") }));
          }
          for (;;)
          {
            this.yQL.onError();
            this.yYI.onError();
            bool2 = true;
            break;
            this.yQU.aeu(getString(2131762698, new Object[] { "0.01", Util.nullAs(this.yPZ.yPB, "") }));
          }
          this.yQO.setClickable(true);
          this.yQO.setEnabled(true);
          break;
          label1173:
          bool1 = false;
        }
        label1179:
        bool2 = false;
      }
      label1185:
      d3 = 0.0D;
      d2 = d1;
      d1 = d3;
      continue;
      label1196:
      d1 = 0.0D;
      d2 = 0.0D;
    }
  }
  
  public void finish()
  {
    AppMethodBeat.i(65910);
    if (this.zhU != null)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("key_realname_guide_helper", this.zhU);
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
    AppMethodBeat.i(213521);
    if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.skx, 1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.LuckyMoneyPrepareUI", "is open: %s", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        break;
      }
      AppMethodBeat.o(213521);
      return 2131495381;
    }
    AppMethodBeat.o(213521);
    return 2131495380;
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
      aDI(str);
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
    this.yYJ = findViewById(2131304224);
    this.yYK = findViewById(2131304227);
    this.rlN = ((Button)findViewById(2131304226));
    this.yQN = ((LuckyMoneyTextInputView)findViewById(2131304284));
    this.yQN.setHintText(getString(2131762600));
    this.yQO = ((Button)findViewById(2131304215));
    this.mKeyboard = ((MyKeyboardWindow)findViewById(2131308962));
    this.mKBLayout = findViewById(2131308960);
    this.nAB = ((TextView)findViewById(2131304213));
    this.yQL = ((LuckyMoneyNumInputView)findViewById(2131304210));
    this.yYI = ((LuckyMoneyMoneyInputView)findViewById(2131304015));
    this.qAC = ((TextView)findViewById(2131304228));
    this.yYL = ((ViewGroup)findViewById(2131304222));
    this.yQR = ((MMScrollView)findViewById(2131304268));
    this.yQS = ((TextView)findViewById(2131304220));
    this.zhB = ((RelativeLayout)findViewById(2131304107));
    this.zhC = ((TextView)findViewById(2131304114));
    this.zhD = ((TextView)findViewById(2131304112));
    this.zhE = ((ImageView)findViewById(2131304106));
    this.zhF = ((ImageView)findViewById(2131304105));
    this.zhG = ((ImageView)findViewById(2131304108));
    this.zhH = ((TextView)findViewById(2131304109));
    this.zhI = ((ViewGroup)findViewById(2131304152));
    this.zhJ = ((TextView)findViewById(2131304153));
    this.zhK = ((ViewGroup)findViewById(2131304119));
    this.zhL = ((TextView)findViewById(2131304221));
    this.zhM = ((ImageView)findViewById(2131304118));
    this.zhN = ((TextView)findViewById(2131304121));
    this.zhO = ((ViewGroup)findViewById(2131304042));
    this.zhP = ((WeImageView)findViewById(2131304041));
    this.zhQ = ((TextView)findViewById(2131304043));
    this.zdk = new a(this);
    this.zdl = getLayoutInflater().inflate(2131495362, null);
    this.zdk.setContentView(this.zdl, new ViewGroup.LayoutParams(-1, -1));
    this.zdl.findViewById(2131304101).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(65851);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        LuckyMoneyPrepareUI.a(LuckyMoneyPrepareUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(65851);
      }
    });
    this.zdk.zbp = new a.a()
    {
      public final void efU()
      {
        AppMethodBeat.i(65865);
        LuckyMoneyPrepareUI.a(LuckyMoneyPrepareUI.this);
        AppMethodBeat.o(65865);
      }
    };
    this.zdx = ((ViewGroup)this.zdl.findViewById(2131304103));
    this.zdv = com.tencent.mm.pluginsdk.ui.chat.e.Knc.eZ(getContext());
    this.zhW = getIntent().getStringExtra("key_username");
    this.zdv.setTalkerName(this.zhW);
    this.zdv.setShowSmiley(false);
    label653:
    Object localObject1;
    Object localObject2;
    label715:
    int i;
    if (this.mType == 1)
    {
      setMMTitle(2131762648);
      this.yYI.setTitle(getString(2131762753));
      this.yYI.setShowGroupIcon(true);
      if (!com.tencent.mm.plugin.luckymoney.model.af.IA(getIntent().getStringExtra("key_username"))) {
        break label1587;
      }
      this.yYI.setRtxLuckyMoney(true);
      localObject1 = new LinearLayout.LayoutParams(-1, -1);
      localObject2 = new LinearLayout.LayoutParams(-1, com.tencent.mm.cb.a.aG(this, 2131166630));
      if (this.mType != 1) {
        break label1598;
      }
      ((LinearLayout.LayoutParams)localObject1).topMargin = com.tencent.mm.cb.a.fromDPToPix(getContext(), 13);
      ((LinearLayout.LayoutParams)localObject2).topMargin = com.tencent.mm.cb.a.fromDPToPix(getContext(), 13);
      this.yQN.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      this.zhB.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      this.yYI.setOnInputValidChangerListener(this);
      this.yYI.setHint(getString(2131762669));
      this.yQL.setOnInputValidChangerListener(this);
      this.yQL.setHint(getString(2131762685));
      if (!com.tencent.mm.plugin.luckymoney.model.af.IA(getIntent().getStringExtra("key_username"))) {
        break label1628;
      }
      this.yQL.setRtxLuckyMoney(true);
      label800:
      this.yQN.setOnInputValidChangerListener(this);
      if (!com.tencent.mm.ui.ao.isDarkMode()) {
        break label1639;
      }
      this.zhG.setImageResource(2131233761);
      label824:
      localObject1 = (EditText)this.yYI.findViewById(2131304116);
      localObject2 = (EditText)this.yQL.findViewById(2131304116);
      com.tencent.mm.wallet_core.ui.f.setNoSystemInputOnEditText((EditText)localObject1);
      ((InputMethodManager)getContext().getSystemService("input_method")).showSoftInput((View)localObject1, 0);
      ((EditText)localObject1).addTextChangedListener(new LuckyMoneyPrepareUI.13(this, (EditText)localObject1));
      ((EditText)localObject2).addTextChangedListener(new LuckyMoneyPrepareUI.14(this, (EditText)localObject2));
      ((EditText)localObject1).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(65841);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          this.val$hintTv.setOnClickListener(null);
          this.yQW.setOnClickListener(null);
          LuckyMoneyPrepareUI.this.ak(LuckyMoneyPrepareUI.d(LuckyMoneyPrepareUI.this), 2);
          LuckyMoneyPrepareUI.this.ak(LuckyMoneyPrepareUI.e(LuckyMoneyPrepareUI.this), 0);
          LuckyMoneyPrepareUI.this.mKeyboard.setXMode(2);
          LuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText)paramAnonymousView);
          LuckyMoneyPrepareUI.this.mKBLayout.setVisibility(0);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(65841);
        }
      });
      if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.skx, 1) != 1) {
        break label1652;
      }
      i = 1;
      label943:
      if (i == 0) {
        break label1666;
      }
      i = getIntent().getIntExtra("key_chatroom_num", 0);
      if ((!this.yYO) || (i != 0)) {
        break label1657;
      }
      ((EditText)localObject1).requestFocus();
      label975:
      TextView localTextView = (TextView)this.yYI.findViewById(2131304016);
      if (localTextView != null) {
        localTextView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(65842);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$23", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            this.val$hintTv.setOnClickListener(null);
            this.yQW.setOnClickListener(null);
            LuckyMoneyPrepareUI.this.ak(LuckyMoneyPrepareUI.d(LuckyMoneyPrepareUI.this), 2);
            LuckyMoneyPrepareUI.this.ak(LuckyMoneyPrepareUI.e(LuckyMoneyPrepareUI.this), 0);
            LuckyMoneyPrepareUI.this.mKeyboard.setXMode(2);
            LuckyMoneyPrepareUI.this.mKeyboard.setInputEditText(this.val$hintTv);
            LuckyMoneyPrepareUI.this.mKBLayout.setVisibility(0);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$23", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(65842);
          }
        });
      }
      com.tencent.mm.wallet_core.ui.f.setNoSystemInputOnEditText((EditText)localObject2);
      ((InputMethodManager)getContext().getSystemService("input_method")).showSoftInput((View)localObject2, 0);
      ((EditText)localObject2).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(213483);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$24", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          this.val$hintTv.setOnClickListener(null);
          this.yQW.setOnClickListener(null);
          LuckyMoneyPrepareUI.this.ak(LuckyMoneyPrepareUI.d(LuckyMoneyPrepareUI.this), 2);
          LuckyMoneyPrepareUI.this.ak(LuckyMoneyPrepareUI.e(LuckyMoneyPrepareUI.this), 0);
          LuckyMoneyPrepareUI.this.mKeyboard.setXMode(0);
          LuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText)paramAnonymousView);
          LuckyMoneyPrepareUI.this.mKBLayout.setVisibility(0);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$24", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(213483);
        }
      });
      ((MMEditText)this.yQN.findViewById(2131304269)).setOnFocusChangeListener(new View.OnFocusChangeListener()
      {
        public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(213484);
          this.val$hintTv.setOnClickListener(null);
          this.yQW.setOnClickListener(null);
          LuckyMoneyPrepareUI.this.ak(LuckyMoneyPrepareUI.d(LuckyMoneyPrepareUI.this), 2);
          LuckyMoneyPrepareUI.this.ak(LuckyMoneyPrepareUI.e(LuckyMoneyPrepareUI.this), 0);
          AppMethodBeat.o(213484);
        }
      });
      if (this.yPZ != null)
      {
        if (this.mType != 1) {
          break label1674;
        }
        this.yYI.setMaxAmount(this.yPZ.yPy);
        label1108:
        this.yYI.setMinAmount(this.yPZ.yPx);
        if (this.yPZ.qww != 1) {
          aDH(this.yPZ.yPB);
        }
      }
      if ((!this.yYO) || (getIntent().getIntExtra("key_chatroom_num", 0) > 1)) {
        break label1691;
      }
      this.yQL.setNum("1");
      label1176:
      this.yQL.setMaxNum(this.yPZ.yPv);
      this.yQL.setMinNum(1);
      Log.d("MicroMsg.LuckyMoneyPrepareUI", "init num=" + this.yQL.getInput());
      this.yYI.setMaxLen(12);
      if (egE()) {
        this.yQO.setText(getString(2131762709, new Object[] { this.yPZ.yUV }));
      }
      if ((!this.yYO) && (this.gwE != 2)) {
        break label1919;
      }
      if (!egE()) {
        break label1704;
      }
      setMMTitle(getString(2131762750, new Object[] { this.yPZ.yUV }));
      label1318:
      i = getIntent().getIntExtra("key_chatroom_num", 0);
      if ((!this.yYO) || (i != 0)) {
        break label1714;
      }
      Log.i("MicroMsg.LuckyMoneyPrepareUI", "single hb");
      this.yQL.setVisibility(8);
      this.zhI.setVisibility(8);
      this.zhK.setVisibility(8);
    }
    for (;;)
    {
      this.yQO.setOnClickListener(new x()
      {
        public final void czW()
        {
          AppMethodBeat.i(213509);
          LuckyMoneyPrepareUI.a(LuckyMoneyPrepareUI.this, new hf());
          LuckyMoneyPrepareUI.b(LuckyMoneyPrepareUI.this).eEH = 6L;
          LuckyMoneyPrepareUI.b(LuckyMoneyPrepareUI.this).bfK();
          if (!((com.tencent.mm.pluginsdk.wallet.a)g.af(com.tencent.mm.pluginsdk.wallet.a.class)).canOpenKindaCashier(LuckyMoneyPrepareUI.this))
          {
            Log.w("MicroMsg.LuckyMoneyPrepareUI", "can not request hb while authen");
            com.tencent.mm.plugin.report.service.h.CyF.dN(965, 55);
            AppMethodBeat.o(213509);
            return;
          }
          LuckyMoneyPrepareUI.c(LuckyMoneyPrepareUI.this);
          AppMethodBeat.o(213509);
        }
      });
      localObject1 = (TextView)findViewById(2131304217);
      this.yQU.t((TextView)localObject1);
      this.klF = new MTimerHandler(new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(213510);
          double d2;
          double d1;
          if ((LuckyMoneyPrepareUI.d(LuckyMoneyPrepareUI.this).eeH() != 3) && (LuckyMoneyPrepareUI.e(LuckyMoneyPrepareUI.this).eeH() != 3))
          {
            int i = LuckyMoneyPrepareUI.e(LuckyMoneyPrepareUI.this).getInput();
            d2 = LuckyMoneyPrepareUI.d(LuckyMoneyPrepareUI.this).getInput();
            if (LuckyMoneyPrepareUI.f(LuckyMoneyPrepareUI.this) == 0) {
              d1 = d2 * i;
            }
          }
          for (;;)
          {
            if ((d1 == 0.0D) || (d1 > LuckyMoneyPrepareUI.h(LuckyMoneyPrepareUI.this).yPy) || (LuckyMoneyPrepareUI.i(LuckyMoneyPrepareUI.this).egk()))
            {
              LuckyMoneyPrepareUI.j(LuckyMoneyPrepareUI.this).setClickable(false);
              LuckyMoneyPrepareUI.j(LuckyMoneyPrepareUI.this).setEnabled(false);
            }
            for (;;)
            {
              Log.i("MicroMsg.LuckyMoneyPrepareUI", "onTimeExpired & check: amount=" + d1 + ", hasErr=" + LuckyMoneyPrepareUI.i(LuckyMoneyPrepareUI.this).egk());
              LuckyMoneyPrepareUI.k(LuckyMoneyPrepareUI.this).stopped();
              AppMethodBeat.o(213510);
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
      if (this.yQR != null) {
        this.yQR.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(213511);
            if (paramAnonymousMotionEvent.getAction() == 0)
            {
              LuckyMoneyPrepareUI.this.hideTenpayKB();
              LuckyMoneyPrepareUI.this.hideVKB();
            }
            AppMethodBeat.o(213511);
            return false;
          }
        });
      }
      this.yYI.setType(this.mType);
      init();
      final boolean bool = com.tencent.mm.y.c.axV().a(ar.a.Ofj, ar.a.Ofl);
      this.zhB.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(final View paramAnonymousView)
        {
          AppMethodBeat.i(213479);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          Log.d("MicroMsg.LuckyMoneyPrepareUI", "click envelope layout: %s", new Object[] { Integer.valueOf(LuckyMoneyPrepareUI.z(LuckyMoneyPrepareUI.this)) });
          if (LuckyMoneyPrepareUI.z(LuckyMoneyPrepareUI.this) == 0)
          {
            LuckyMoneyPrepareUI.a(LuckyMoneyPrepareUI.this, null, false, bool);
            paramAnonymousView = com.tencent.mm.plugin.report.service.h.CyF;
            if (!bool) {
              break label212;
            }
          }
          label212:
          for (int i = 2;; i = 1)
          {
            paramAnonymousView.a(18890, new Object[] { Integer.valueOf(2), Integer.valueOf(i), LuckyMoneyPrepareUI.B(LuckyMoneyPrepareUI.this) });
            com.tencent.mm.plugin.report.service.h.CyF.a(16822, new Object[] { Integer.valueOf(1) });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(213479);
            return;
            paramAnonymousView = com.tencent.mm.plugin.luckymoney.model.af.gu(LuckyMoneyPrepareUI.this.getContext());
            localObject = com.tencent.mm.plugin.luckymoney.model.k.eeZ();
            ((com.tencent.mm.plugin.luckymoney.model.k)localObject).b(new com.tencent.mm.plugin.luckymoney.model.d(""));
            ((com.tencent.mm.wallet_core.c.a)localObject).a(new com.tencent.mm.wallet_core.c.a.a() {}, 0L);
            break;
          }
        }
      });
      if (bool) {
        this.zhH.setVisibility(0);
      }
      if (this.yVa != null) {
        b(this.yVa.yUC);
      }
      if (com.tencent.mm.plugin.luckymoney.model.af.IA(getIntent().getStringExtra("key_username"))) {
        b(null);
      }
      AppMethodBeat.o(65886);
      return;
      setMMTitle(2131762683);
      this.yYI.setTitle(getString(2131762754));
      this.yYI.setShowGroupIcon(false);
      break;
      label1587:
      this.yYI.setRtxLuckyMoney(false);
      break label653;
      label1598:
      ((LinearLayout.LayoutParams)localObject1).topMargin = com.tencent.mm.cb.a.fromDPToPix(getContext(), 16);
      ((LinearLayout.LayoutParams)localObject2).topMargin = com.tencent.mm.cb.a.fromDPToPix(getContext(), 16);
      break label715;
      label1628:
      this.yQL.setRtxLuckyMoney(false);
      break label800;
      label1639:
      this.zhG.setImageResource(2131233760);
      break label824;
      label1652:
      i = 0;
      break label943;
      label1657:
      ((EditText)localObject2).requestFocus();
      break label975;
      label1666:
      ((EditText)localObject1).requestFocus();
      break label975;
      label1674:
      this.yYI.setMaxAmount(this.yPZ.yPw);
      break label1108;
      label1691:
      this.yQL.setNum("");
      break label1176;
      label1704:
      setMMTitle(2131762749);
      break label1318;
      label1714:
      if ((getIntent().getIntExtra("key_chatroom_num", 0) <= 0) && (this.gwE != 2))
      {
        this.zhI.setVisibility(8);
        this.zhK.setVisibility(8);
        label1754:
        if ((!this.yYO) || (i <= 0)) {
          break label1890;
        }
        Log.i("MicroMsg.LuckyMoneyPrepareUI", "group hb,%d people", new Object[] { Integer.valueOf(i) });
        localObject1 = getString(2131762684, new Object[] { Integer.valueOf(getIntent().getIntExtra("key_chatroom_num", 8)) });
        this.zhL.setText((CharSequence)localObject1);
        this.zhL.setVisibility(0);
      }
      for (;;)
      {
        this.yYI.setGroupIconIv(2131233682);
        break;
        this.zhI.setVisibility(0);
        Qa(-1);
        this.zhI.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(213515);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            LuckyMoneyPrepareUI.this.hideTenpayKB();
            LuckyMoneyPrepareUI.this.hideVKB();
            paramAnonymousView = new com.tencent.mm.ui.widget.d(LuckyMoneyPrepareUI.this.getContext(), (byte)0);
            paramAnonymousView.HLX = new o.f()
            {
              public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramAnonymous2m)
              {
                AppMethodBeat.i(213513);
                paramAnonymous2m.d(1, LuckyMoneyPrepareUI.this.getString(2131762666));
                paramAnonymous2m.d(2, LuckyMoneyPrepareUI.this.getString(2131762667));
                ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.skw, 0);
                if ((LuckyMoneyPrepareUI.h(LuckyMoneyPrepareUI.this).yUY) && (LuckyMoneyPrepareUI.l(LuckyMoneyPrepareUI.this) == 1) && (!ab.Iz(LuckyMoneyPrepareUI.this.getIntent().getStringExtra("key_username"))) && (LuckyMoneyPrepareUI.m(LuckyMoneyPrepareUI.this) != 2)) {
                  paramAnonymous2m.d(3, LuckyMoneyPrepareUI.this.getString(2131762664));
                }
                AppMethodBeat.o(213513);
              }
            };
            paramAnonymousView.HLY = new o.g()
            {
              public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
              {
                AppMethodBeat.i(213514);
                paramAnonymous2Int = paramAnonymous2MenuItem.getItemId();
                int i = LuckyMoneyPrepareUI.f(LuckyMoneyPrepareUI.this);
                if (paramAnonymous2Int == 1)
                {
                  LuckyMoneyPrepareUI.a(LuckyMoneyPrepareUI.this, 1);
                  com.tencent.mm.plugin.report.service.h.CyF.a(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(LuckyMoneyPrepareUI.n(LuckyMoneyPrepareUI.this)), Integer.valueOf(2) });
                }
                for (;;)
                {
                  LuckyMoneyPrepareUI.b(LuckyMoneyPrepareUI.this, i);
                  AppMethodBeat.o(213514);
                  return;
                  if (paramAnonymous2Int == 2)
                  {
                    LuckyMoneyPrepareUI.a(LuckyMoneyPrepareUI.this, 0);
                    com.tencent.mm.plugin.report.service.h.CyF.a(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(LuckyMoneyPrepareUI.n(LuckyMoneyPrepareUI.this)), Integer.valueOf(3) });
                  }
                  else if (paramAnonymous2Int == 3)
                  {
                    LuckyMoneyPrepareUI.a(LuckyMoneyPrepareUI.this, 3);
                    com.tencent.mm.plugin.report.service.h.CyF.a(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(LuckyMoneyPrepareUI.n(LuckyMoneyPrepareUI.this)), Integer.valueOf(13) });
                  }
                }
              }
            };
            paramAnonymousView.dGm();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(213515);
          }
        });
        this.zhK.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(213474);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            LuckyMoneyPrepareUI.this.hideTenpayKB();
            LuckyMoneyPrepareUI.this.hideVKB();
            paramAnonymousView = new Intent(LuckyMoneyPrepareUI.this.getContext(), LuckyMoneyExclusiveSelectContactUI.class);
            paramAnonymousView.putExtra("chatroomName", LuckyMoneyPrepareUI.o(LuckyMoneyPrepareUI.this));
            LuckyMoneyPrepareUI.this.startActivityForResult(paramAnonymousView, 6);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(213474);
          }
        });
        break label1754;
        label1890:
        if (this.gwE == 2)
        {
          Log.i("MicroMsg.LuckyMoneyPrepareUI", "f2f hb");
          this.yQN.setVisibility(8);
        }
      }
      label1919:
      if (this.mType == 1)
      {
        this.nAB.setText(this.yPZ.yUR);
        this.nAB.setVisibility(0);
      }
      else if (this.mType == 0)
      {
        this.nAB.setText(this.yPZ.yUS);
        this.nAB.setVisibility(0);
      }
    }
  }
  
  public final void j(int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(65902);
    if (paramIntent.hasExtra("key_realname_guide_helper")) {
      this.zhU = ((RealnameGuideHelper)paramIntent.getParcelableExtra("key_realname_guide_helper"));
    }
    if (paramInt == -1)
    {
      com.tencent.mm.plugin.report.service.h.CyF.a(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(efB()), Integer.valueOf(5) });
      Object localObject1 = getIntent().getStringExtra("key_username");
      if ((this.yYO) && (!Util.isNullOrNil((String)localObject1)))
      {
        com.tencent.mm.ui.base.h.cD(this, getString(2131761619));
        Object localObject2 = XmlParser.parseXml(this.yYP, "msg", null);
        if (localObject2 == null)
        {
          Log.e("MicroMsg.LuckyMoneyPrepareUI", "luckymoneyPrepareUI onActivityResult values is null");
          finish();
          AppMethodBeat.o(65902);
          return;
        }
        localObject2 = (String)((Map)localObject2).get(".msg.appmsg.wcpayinfo.paymsgid");
        if (com.tencent.mm.plugin.luckymoney.b.a.eex().eeB().aDu((String)localObject2))
        {
          Log.i("MicroMsg.LuckyMoneyPrepareUI", "insert a local msg for luckymoney");
          if (!com.tencent.mm.plugin.luckymoney.model.af.ac(this.yYP, (String)localObject1, 1))
          {
            Log.e("MicroMsg.LuckyMoneyPrepareUI", "LuckyMoneyUtil.sendLocalMsg fail!");
            com.tencent.mm.plugin.luckymoney.b.a.eex().eeB().aDv((String)localObject2);
          }
          h(paramInt, paramIntent);
          localObject1 = new com.tencent.mm.plugin.luckymoney.story.b.e();
          ((com.tencent.mm.plugin.luckymoney.story.b.e)localObject1).field_send_id = ((String)localObject2);
          if (!com.tencent.mm.plugin.luckymoney.b.a.eex().eew().get((IAutoDBItem)localObject1, new String[0]))
          {
            ((com.tencent.mm.plugin.luckymoney.story.b.e)localObject1).field_open_count = 0;
            Log.d("MicroMsg.LuckyMoneyPrepareUI", "insert record: %s, %s", new Object[] { localObject2, Boolean.valueOf(com.tencent.mm.plugin.luckymoney.b.a.eex().eew().insert((IAutoDBItem)localObject1)) });
          }
          this.zhY = new hg();
          this.zhY.eLv = this.zfQ;
          if (this.rfq != null) {
            break label419;
          }
          localObject1 = "";
          label341:
          this.zhY.uV((String)localObject1);
          this.zhY.bfK();
          Log.i("MicroMsg.LuckyMoneyPrepareUI", "Report RedEnvSendWithEmoticonDataStruct, Scene: %d, md5: %s", new Object[] { Integer.valueOf(this.zfQ), localObject1 });
          finish();
        }
      }
      for (;;)
      {
        aDI(paramIntent.getStringExtra("key_trans_id"));
        AppMethodBeat.o(65902);
        return;
        Log.e("MicroMsg.LuckyMoneyPrepareUI", "it is a duplicate msg");
        break;
        label419:
        localObject1 = this.rfq.getMd5();
        break label341;
        ega();
        localObject1 = findViewById(2131304225);
        this.yYJ.setVisibility(0);
        com.tencent.mm.plugin.luckymoney.model.af.a((View)localObject1, null);
        this.rlN.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(65869);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$42", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            com.tencent.mm.plugin.report.service.h.CyF.a(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(LuckyMoneyPrepareUI.n(LuckyMoneyPrepareUI.this)), Integer.valueOf(6) });
            com.tencent.mm.plugin.luckymoney.model.af.a(LuckyMoneyPrepareUI.this, LuckyMoneyPrepareUI.f(LuckyMoneyPrepareUI.this), LuckyMoneyPrepareUI.I(LuckyMoneyPrepareUI.this), true);
            LuckyMoneyPrepareUI.J(LuckyMoneyPrepareUI.this).postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(213502);
                LuckyMoneyPrepareUI.J(LuckyMoneyPrepareUI.this).setVisibility(8);
                LuckyMoneyPrepareUI.this.efZ();
                AppMethodBeat.o(213502);
              }
            }, 100L);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$42", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(65869);
          }
        });
        ((ImageView)findViewById(2131304216)).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(213503);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$43", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            LuckyMoneyPrepareUI.J(LuckyMoneyPrepareUI.this).setVisibility(8);
            LuckyMoneyPrepareUI.this.efZ();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$43", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(213503);
          }
        });
        h(paramInt, paramIntent);
      }
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
        this.zhU = ((RealnameGuideHelper)paramIntent.getParcelableExtra("key_realname_guide_helper"));
      }
      Object localObject1;
      if (paramInt2 == -1)
      {
        com.tencent.mm.plugin.report.service.h.CyF.a(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(efB()), Integer.valueOf(5) });
        localObject1 = getIntent().getStringExtra("key_username");
        if ((this.yYO) && (!Util.isNullOrNil((String)localObject1)))
        {
          Object localObject2 = XmlParser.parseXml(this.yYP, "msg", null);
          if (localObject2 == null)
          {
            Log.e("MicroMsg.LuckyMoneyPrepareUI", "luckymoneyPrepareUI onActivityResult values is null");
            finish();
            AppMethodBeat.o(65900);
            return;
          }
          localObject2 = (String)((Map)localObject2).get(".msg.appmsg.wcpayinfo.paymsgid");
          if (com.tencent.mm.plugin.luckymoney.b.a.eex().eeB().aDu((String)localObject2))
          {
            Log.i("MicroMsg.LuckyMoneyPrepareUI", "insert a local msg for luckymoney");
            if (!com.tencent.mm.plugin.luckymoney.model.af.ac(this.yYP, (String)localObject1, 1))
            {
              Log.e("MicroMsg.LuckyMoneyPrepareUI", "LuckyMoneyUtil.sendLocalMsg fail!");
              com.tencent.mm.plugin.luckymoney.b.a.eex().eeB().aDv((String)localObject2);
            }
            label306:
            h(paramInt2, paramIntent);
            this.zhY = new hg();
            this.zhY.eLv = this.zfQ;
            if (this.rfq != null) {
              break label436;
            }
            localObject1 = "";
            label347:
            this.zhY.uV((String)localObject1);
            this.zhY.bfK();
            Log.i("MicroMsg.LuckyMoneyPrepareUI", "Report RedEnvSendWithEmoticonDataStruct, Scene: %d, md5: %s", new Object[] { Integer.valueOf(this.zfQ), localObject1 });
            finish();
          }
        }
        for (;;)
        {
          localObject1 = "";
          if (paramIntent != null) {
            localObject1 = paramIntent.getStringExtra("key_trans_id");
          }
          aDI((String)localObject1);
          break;
          Log.e("MicroMsg.LuckyMoneyPrepareUI", "it is a duplicate msg");
          break label306;
          label436:
          localObject1 = this.rfq.getMd5();
          break label347;
          ega();
          localObject1 = findViewById(2131304225);
          this.yYJ.setVisibility(0);
          com.tencent.mm.plugin.luckymoney.model.af.a((View)localObject1, null);
          this.rlN.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(65866);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bm(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$40", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
              com.tencent.mm.plugin.report.service.h.CyF.a(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(LuckyMoneyPrepareUI.n(LuckyMoneyPrepareUI.this)), Integer.valueOf(6) });
              com.tencent.mm.plugin.luckymoney.model.af.a(LuckyMoneyPrepareUI.this, LuckyMoneyPrepareUI.f(LuckyMoneyPrepareUI.this), LuckyMoneyPrepareUI.I(LuckyMoneyPrepareUI.this), true);
              LuckyMoneyPrepareUI.J(LuckyMoneyPrepareUI.this).postDelayed(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(213501);
                  LuckyMoneyPrepareUI.J(LuckyMoneyPrepareUI.this).setVisibility(8);
                  LuckyMoneyPrepareUI.this.efZ();
                  AppMethodBeat.o(213501);
                }
              }, 100L);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$40", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(65866);
            }
          });
          ((ImageView)findViewById(2131304216)).setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(65868);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bm(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$41", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
              LuckyMoneyPrepareUI.J(LuckyMoneyPrepareUI.this).setVisibility(8);
              LuckyMoneyPrepareUI.this.efZ();
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$41", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(65868);
            }
          });
          h(paramInt2, paramIntent);
        }
      }
      if (ag.bH(paramIntent))
      {
        finish();
        AppMethodBeat.o(65900);
        return;
      }
      if (ag.bI(paramIntent))
      {
        AppMethodBeat.o(65900);
        return;
      }
      h(paramInt2, paramIntent);
      continue;
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        localObject1 = paramIntent.getStringExtra("Select_Conv_User");
        com.tencent.mm.plugin.report.service.h.CyF.a(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(efB()), Integer.valueOf(7), localObject1 });
        if (!Util.isNullOrNil((String)localObject1)) {
          doSceneProgress(new bf(((String)localObject1).replaceAll(",", "|"), this.yYM, "v1.0"));
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
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject1);
        com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        continue;
        if ((paramIntent != null) && (paramIntent.hasExtra("result_data")))
        {
          localObject1 = paramIntent.getBundleExtra("result_data");
          if (localObject1 != null)
          {
            int i = Util.getInt(((Bundle)localObject1).getString("payState", "2"), 0);
            Log.e("MicroMsg.LuckyMoneyPrepareUI", "onActivityResult REQUEST_CODE_H5_PAY payState is " + i + ";STATE_H5_PAY_SUCC=0");
            if (i == 0) {
              finish();
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
              this.yYL.removeAllViews();
              qR(true);
            }
            else
            {
              qR(false);
              com.tencent.mm.plugin.report.service.h.CyF.a(16822, new Object[] { Integer.valueOf(2) });
              continue;
              if (paramInt2 == -1)
              {
                localObject1 = "";
                if (paramIntent != null) {
                  localObject1 = paramIntent.getStringExtra("gif_md5");
                }
                if (!Util.isNullOrNil((String)localObject1))
                {
                  this.rfq = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpN.blk((String)localObject1);
                  A(this.rfq);
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
                  this.zhX = paramIntent.getStringExtra("Select_Contact");
                  Log.i("MicroMsg.LuckyMoneyPrepareUI", "select user: %s", new Object[] { this.zhX });
                  if (!Util.isNullOrNil(this.zhX))
                  {
                    com.tencent.mm.ui.g.a.a.c(this.zhM, this.zhX);
                    localObject1 = com.tencent.mm.wallet_core.ui.f.ht(((com.tencent.mm.plugin.messenger.a.b)g.af(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(this.zhX, this.zhW), 8);
                    this.zhN.setText(com.tencent.mm.pluginsdk.ui.span.l.b(getContext(), (CharSequence)localObject1, this.zhN.getTextSize()));
                    this.zhM.setVisibility(0);
                    this.zhN.setVisibility(0);
                  }
                }
                eeI();
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
    setActionbarColor(getResources().getColor(2131100755));
    setActionbarElementColor(getResources().getColor(2131099746));
    hideActionbarLine();
    this.mType = getIntent().getIntExtra("key_type", 1);
    this.yUr = getIntent().getIntExtra("key_way", 3);
    this.gwE = getIntent().getIntExtra("key_from", 0);
    boolean bool;
    if (this.gwE == 1)
    {
      bool = true;
      this.yYO = bool;
      this.mChannel = getIntent().getIntExtra("pay_channel", -1);
      this.mSessionId = getIntent().getStringExtra("key_session_id");
      qR(false);
      if (!com.tencent.mm.plugin.luckymoney.model.af.IA(getIntent().getStringExtra("key_username"))) {
        break label390;
      }
      com.tencent.mm.plugin.luckymoney.b.a.eex();
      this.yPZ = com.tencent.mm.plugin.luckymoney.b.a.eez().efe();
      com.tencent.mm.plugin.luckymoney.b.a.eex();
    }
    for (this.yVa = com.tencent.mm.plugin.luckymoney.b.a.eez().eff();; this.yVa = com.tencent.mm.plugin.luckymoney.b.a.eey().eff())
    {
      Log.i("MicroMsg.LuckyMoneyPrepareUI", "mInWay:" + this.yUr + "mChannel:" + this.mChannel);
      Log.i("MicroMsg.LuckyMoneyPrepareUI", "type=" + this.mType + ", fromAppPanel=" + this.yYO + ", config " + this.yPZ);
      initView();
      EventCenter.instance.add(this.zip);
      this.mPayLoopInterruptListener.alive();
      com.tencent.mm.plugin.report.service.h.CyF.a(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(efB()), Integer.valueOf(1) });
      com.tencent.mm.wallet_core.b.hgC();
      this.mKindaEnable = com.tencent.mm.wallet_core.b.b(b.a.rWd, true);
      ((com.tencent.mm.plugin.wxpay.a.a)g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).triggerSoterReInit();
      com.tencent.soter.a.a.hlD();
      AppMethodBeat.o(65883);
      return;
      bool = false;
      break;
      label390:
      com.tencent.mm.plugin.luckymoney.b.a.eex();
      this.yPZ = com.tencent.mm.plugin.luckymoney.b.a.eey().efe();
      com.tencent.mm.plugin.luckymoney.b.a.eex();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(65893);
    super.onDestroy();
    this.yQU.clear();
    this.klF.stopped();
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    if (this.zdv != null)
    {
      Log.i("MicroMsg.LuckyMoneyPrepareUI", "commentfooter release");
      this.zdv.onPause();
      this.zdv.goC();
      this.zdv.destroy();
    }
    EventCenter.instance.removeListener(this.zip);
    this.mPayLoopInterruptListener.dead();
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
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, final com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(65896);
    Log.i("MicroMsg.LuckyMoneyPrepareUI", "errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scenetype:" + paramq.getType());
    boolean bool;
    if ((paramq instanceof ba))
    {
      Log.i("MicroMsg.LuckyMoneyPrepareUI", "onsceneEnd： scene instanceof NetScenePrepareLuckyMoney");
      if (this.zio)
      {
        Log.i("MicroMsg.LuckyMoneyPrepareUI", "has show alert return");
        AppMethodBeat.o(65896);
        return true;
      }
      ba localba = (ba)paramq;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        bool = this.mKindaEnable;
        if ((this.tipDialog != null) && (this.tipDialog.isShowing()) && (!bool)) {
          this.tipDialog.dismiss();
        }
        this.yYN = localba.qwe;
        this.yYM = localba.yQE;
        this.yYP = localba.yXH;
        this.yUc = localba.yQE;
        this.zhV = localba.yXL;
        if (((ba)paramq).isJumpRemind())
        {
          Log.i("MicroMsg.LuckyMoneyPrepareUI", "onSceneEnd() NetScenePrepareLuckyMoney show JumpRemind Alert");
          ((ba)paramq).jumpRemind.a(this, new com.tencent.mm.wallet_core.c.h()
          {
            public final void bG(int paramAnonymousInt, String paramAnonymousString)
            {
              AppMethodBeat.i(213490);
              Log.i("MicroMsg.LuckyMoneyPrepareUI", "onSceneEnd() scene:NetScenePrepareLuckyMoney JumpRemind:onNext()");
              if ((Util.isEqual(paramAnonymousInt, 2)) && (Util.isEqual(paramAnonymousString, "requestwxhb")))
              {
                LuckyMoneyPrepareUI.C(LuckyMoneyPrepareUI.this);
                AppMethodBeat.o(213490);
                return;
              }
              if (Util.isEqual(paramAnonymousInt, 1)) {
                com.tencent.mm.plugin.account.a.b.a.b(LuckyMoneyPrepareUI.this, paramAnonymousString, 0, true);
              }
              AppMethodBeat.o(213490);
            }
            
            public final void onCancel()
            {
              AppMethodBeat.i(213491);
              Log.i("MicroMsg.LuckyMoneyPrepareUI", "onSceneEnd() scene:NetScenePrepareLuckyMoney JumpRemind:onCancel()");
              AppMethodBeat.o(213491);
            }
          });
          AppMethodBeat.o(65896);
          return true;
        }
        paramString = new PayInfo();
        paramString.dDL = localba.wFL;
        paramString.dVv = 37;
        paramString.channel = this.mChannel;
        if (this.mKindaEnable) {
          ((com.tencent.mm.pluginsdk.wallet.a)g.af(com.tencent.mm.pluginsdk.wallet.a.class)).startSNSPay(this, paramString);
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
        this.yQO.setEnabled(false);
        this.yQO.setClickable(false);
        this.klF.startTimer(5000L);
        com.tencent.mm.ui.base.h.cD(this, paramString);
        AppMethodBeat.o(65896);
        return true;
      }
      if (paramInt2 == 268502454)
      {
        com.tencent.mm.ui.base.h.d(this, paramString, "", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(213492);
            if (ba.l(paramq))
            {
              LuckyMoneyPrepareUI.this.finish();
              AppMethodBeat.o(213492);
              return;
            }
            AppMethodBeat.o(213492);
          }
        });
        AppMethodBeat.o(65896);
        return true;
      }
      this.dYe = 2;
      paramq = paramString;
      if (TextUtils.isEmpty(paramString)) {
        paramq = getString(2131768354);
      }
      com.tencent.mm.ui.base.h.a(this, paramq, null, false, new LuckyMoneyPrepareUI.19(this));
      AppMethodBeat.o(65896);
      return true;
    }
    if ((paramq instanceof bf))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (this.yYO)
        {
          com.tencent.mm.ui.widget.snackbar.b.r(this, getString(2131761619));
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
          ega();
          this.yYK.setVisibility(0);
          this.yYK.postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(213493);
              Object localObject = new Intent();
              ((Intent)localObject).putExtra("key_username", LuckyMoneyPrepareUI.o(LuckyMoneyPrepareUI.this));
              ((Intent)localObject).setClass(LuckyMoneyPrepareUI.this.getContext(), LuckyMoneyIndexUI.class);
              ((Intent)localObject).addFlags(67108864);
              AppCompatActivity localAppCompatActivity = LuckyMoneyPrepareUI.this.getContext();
              localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(localAppCompatActivity, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$32", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              localAppCompatActivity.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
              com.tencent.mm.hellhoundlib.a.a.a(localAppCompatActivity, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$32", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              LuckyMoneyPrepareUI.this.finish();
              AppMethodBeat.o(213493);
            }
          }, 1000L);
        }
      }
      if (paramInt2 == 402)
      {
        com.tencent.mm.ui.base.h.c(getContext(), paramString, "", getString(2131762732), getString(2131755761), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(65844);
            Object localObject = new Intent();
            ((Intent)localObject).setClass(LuckyMoneyPrepareUI.this.getContext(), LuckyMoneyMyRecordUI.class);
            ((Intent)localObject).putExtra("key_type", 1);
            ((Intent)localObject).putExtra("key_username", LuckyMoneyPrepareUI.this.getIntent().getStringExtra("key_username"));
            paramAnonymousDialogInterface = LuckyMoneyPrepareUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$33", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$33", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
      if ((paramq instanceof aq))
      {
        Log.i("MicroMsg.LuckyMoneyPrepareUI", "NetSceneLuckyMoneyGetConfig resp,errType=" + paramInt1 + ";errCode=" + paramInt2 + ";errMsg=" + paramString);
        if ((this.zhz != null) && (this.zhz.isShowing())) {
          this.zhz.dismiss();
        }
        if ((this.zhA != null) && (this.zhA.isShowing())) {
          this.zhA.dismiss();
        }
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = (aq)paramq;
          this.zil = true;
          this.yXu = paramString.yXu;
          if (!Util.isEqual(paramString.yXv, 1))
          {
            this.yQN.qS(true);
            if (!com.tencent.mm.plugin.luckymoney.model.af.IA(getIntent().getStringExtra("key_username"))) {
              break label1485;
            }
            com.tencent.mm.plugin.luckymoney.b.a.eex();
            this.yPZ = com.tencent.mm.plugin.luckymoney.b.a.eez().efe();
            label796:
            Log.i("MicroMsg.LuckyMoneyPrepareUI", "update config:" + this.yPZ);
            if (this.mType != 1) {
              break label1502;
            }
            this.yYI.setMaxAmount(this.yPZ.yPy);
            label844:
            this.yYI.setMinAmount(this.yPZ.yPx);
            this.yQL.setMaxNum(this.yPZ.yPv);
            this.zhS = paramString.yPA;
            this.zhR = paramString.qww;
            this.zhT = paramString.yPK;
            if (Util.isNullOrNil(this.zfX)) {
              this.zfX = paramString.dUb;
            }
            if ((!Util.isNullOrNil(this.zhT)) && (this.yQN != null)) {
              MMHandlerThread.postToMainThread(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(213497);
                  LuckyMoneyPrepareUI.F(LuckyMoneyPrepareUI.this).setHintText(LuckyMoneyPrepareUI.G(LuckyMoneyPrepareUI.this));
                  AppMethodBeat.o(213497);
                }
              });
            }
            if ((paramString.yXl) && (this.yYO))
            {
              paramq = (TextView)findViewById(2131304218);
              paramq.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(65860);
                  Object localObject = new com.tencent.mm.hellhoundlib.b.b();
                  ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
                  com.tencent.mm.plugin.report.service.h.CyF.a(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(LuckyMoneyPrepareUI.n(LuckyMoneyPrepareUI.this)), Integer.valueOf(9) });
                  localObject = new Intent();
                  ((Intent)localObject).setClass(LuckyMoneyPrepareUI.this.getContext(), LuckyMoneyCanShareListUI.class);
                  paramAnonymousView = LuckyMoneyPrepareUI.this;
                  localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
                  com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$37", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
                  com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$37", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(65860);
                }
              });
              com.tencent.mm.plugin.report.service.h.CyF.a(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(efB()), Integer.valueOf(8) });
              paramq.setVisibility(8);
            }
            if (Util.isNullOrNil(paramString.jTx)) {
              break label1519;
            }
            Log.i("MicroMsg.LuckyMoneyPrepareUI", "Put notice :" + paramString.jTx);
            this.yQS.setText(paramString.jTx);
            if (!Util.isNullOrNil(paramString.yXn)) {
              this.yQS.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(213498);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bm(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$38", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
                  com.tencent.mm.wallet_core.ui.f.p(LuckyMoneyPrepareUI.this.getContext(), paramString.yXn, false);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$38", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(213498);
                }
              });
            }
            this.yQS.setVisibility(0);
            label1121:
            paramq = new i.c();
            if ((paramString.yXp == null) || (Util.isNullOrNil(paramString.yXp.content))) {
              break label1531;
            }
            paramq.textColor = getResources().getColor(2131101357);
            label1165:
            this.yYL.removeAllViews();
            i.a(this, this.yYL, paramString.yXp, paramq);
            aDH(paramString.yPB);
            if (this.zhR == 1) {
              break label1549;
            }
            b(this.yYI.getInput(), this.zhS);
            label1217:
            if (!com.tencent.mm.plugin.luckymoney.model.af.IA(getIntent().getStringExtra("key_username"))) {
              break label1601;
            }
            com.tencent.mm.plugin.luckymoney.b.a.eex();
            this.yVa = com.tencent.mm.plugin.luckymoney.b.a.eez().eff();
            label1247:
            init();
            if (this.yVa == null) {
              break label1618;
            }
            if (this.yVa.yUC != null)
            {
              this.zhZ = this.yVa.yUC.MgP;
              this.zia = this.yVa.yUC.MgN;
              this.zib = this.yVa.yUC.MgO;
            }
            b(this.yVa.yUC);
            com.tencent.mm.plugin.report.service.h.CyF.dN(991, 10);
            label1332:
            if (this.zin)
            {
              Log.i("MicroMsg.LuckyMoneyPrepareUI", "doRMBPrePareBtnClick()");
              a(this.zie, this.zif, this.zig, this.zih, this.zii, this.zij);
            }
          }
        }
        for (;;)
        {
          Log.i("MicroMsg.LuckyMoneyPrepareUI", "NetSceneLuckyMoneyGetConfig waitingGetConfig:%s ifAutoRMBPrePareBtn:%s", new Object[] { Boolean.valueOf(this.zim), Boolean.valueOf(this.zin) });
          this.zim = false;
          this.zin = false;
          AppMethodBeat.o(65896);
          return true;
          this.yQN.qS(false);
          if ((this.rfq != null) && (!Util.isNullOrNil(this.rfq.getMd5()))) {
            this.yQN.A(this.rfq);
          }
          this.yQN.setmOnEmojiSelectClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(213496);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bm(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$35", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
              LuckyMoneyPrepareUI.a(LuckyMoneyPrepareUI.this, new hf());
              LuckyMoneyPrepareUI.b(LuckyMoneyPrepareUI.this).eEH = 2L;
              LuckyMoneyPrepareUI.b(LuckyMoneyPrepareUI.this).bfK();
              final boolean bool = Util.isEqual(paramAnonymousView.getTag(), "delete");
              if ((!bool) && (!Util.isEqual(paramString.yXu, 1)))
              {
                LuckyMoneyPrepareUI.c(LuckyMoneyPrepareUI.this, 2);
                LuckyMoneyPrepareUI.D(LuckyMoneyPrepareUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$35", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(213496);
                return;
              }
              paramAnonymousView = new com.tencent.mm.ui.widget.d(LuckyMoneyPrepareUI.this.getContext());
              paramAnonymousView.HLX = new o.f()
              {
                public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramAnonymous2m)
                {
                  AppMethodBeat.i(213494);
                  if (!bool)
                  {
                    if (Util.isEqual(LuckyMoneyPrepareUI.28.this.yYR.yXu, 1)) {
                      paramAnonymous2m.kV(1, 2131762682);
                    }
                    paramAnonymous2m.kV(2, 2131762726);
                    AppMethodBeat.o(213494);
                    return;
                  }
                  paramAnonymous2m.a(3, LuckyMoneyPrepareUI.this.getResources().getColor(2131100764), LuckyMoneyPrepareUI.this.getContext().getString(2131762601));
                  AppMethodBeat.o(213494);
                }
              };
              paramAnonymousView.HLY = new o.g()
              {
                public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(213495);
                  Log.i("MicroMsg.LuckyMoneyPrepareUI", "showLuckyHbDlg() onMMMenuItemSelected menuItemId:%s", new Object[] { Integer.valueOf(paramAnonymous2MenuItem.getItemId()) });
                  switch (paramAnonymous2MenuItem.getItemId())
                  {
                  }
                  for (;;)
                  {
                    AppMethodBeat.o(213495);
                    return;
                    LuckyMoneyPrepareUI.c(LuckyMoneyPrepareUI.this, 1);
                    com.tencent.mm.plugin.emojicapture.api.b.b(LuckyMoneyPrepareUI.this, 4, LuckyMoneyPrepareUI.o(LuckyMoneyPrepareUI.this));
                    LuckyMoneyPrepareUI.a(LuckyMoneyPrepareUI.this, new hf());
                    LuckyMoneyPrepareUI.b(LuckyMoneyPrepareUI.this).eEH = 4L;
                    LuckyMoneyPrepareUI.b(LuckyMoneyPrepareUI.this).bfK();
                    AppMethodBeat.o(213495);
                    return;
                    LuckyMoneyPrepareUI.c(LuckyMoneyPrepareUI.this, 2);
                    LuckyMoneyPrepareUI.D(LuckyMoneyPrepareUI.this);
                    AppMethodBeat.o(213495);
                    return;
                    LuckyMoneyPrepareUI.E(LuckyMoneyPrepareUI.this);
                    paramAnonymous2MenuItem = LuckyMoneyPrepareUI.F(LuckyMoneyPrepareUI.this);
                    paramAnonymous2MenuItem.ziF.setTag("");
                    paramAnonymous2MenuItem.ziG.setVisibility(0);
                    paramAnonymous2MenuItem.ziH.setVisibility(8);
                    LuckyMoneyPrepareUI.a(LuckyMoneyPrepareUI.this, null);
                    LuckyMoneyPrepareUI.a(LuckyMoneyPrepareUI.this, new hf());
                    LuckyMoneyPrepareUI.b(LuckyMoneyPrepareUI.this).eEH = 5L;
                    LuckyMoneyPrepareUI.b(LuckyMoneyPrepareUI.this).bfK();
                  }
                }
              };
              paramAnonymousView.dGm();
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$35", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(213496);
            }
          });
          break;
          label1485:
          com.tencent.mm.plugin.luckymoney.b.a.eex();
          this.yPZ = com.tencent.mm.plugin.luckymoney.b.a.eey().efe();
          break label796;
          label1502:
          this.yYI.setMaxAmount(this.yPZ.yPw);
          break label844;
          label1519:
          this.yQS.setVisibility(8);
          break label1121;
          label1531:
          paramq.textColor = getResources().getColor(2131100584);
          break label1165;
          label1549:
          if (this.mType == 1)
          {
            b(this.yYI.getInput(), this.zhS);
            break label1217;
          }
          if (this.mType != 3) {
            break label1217;
          }
          b(this.yYI.getInput(), this.zhS);
          break label1217;
          label1601:
          com.tencent.mm.plugin.luckymoney.b.a.eex();
          this.yVa = com.tencent.mm.plugin.luckymoney.b.a.eey().eff();
          break label1247;
          label1618:
          b(null);
          break label1332;
          if (this.zin)
          {
            paramq = paramString;
            if (Util.isNullOrNil(paramString)) {
              paramq = getString(2131755804);
            }
            u.makeText(this, paramq, 0).show();
          }
        }
      }
      if ((paramq instanceof as))
      {
        removeSceneEndListener(1647);
        if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
          this.tipDialog.dismiss();
        }
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = ((as)paramq).qwI;
          if (!Util.isNullOrNil(paramString))
          {
            Log.i("MicroMsg.LuckyMoneyPrepareUI", "payUrl is not null");
            com.tencent.mm.wallet_core.ui.f.a(getContext(), paramString, false, 3);
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
            if (com.tencent.mm.plugin.wallet_core.utils.c.a(paramString.yRV.Lus))
            {
              if (this.tipDialog != null) {
                this.tipDialog.dismiss();
              }
              new com.tencent.mm.plugin.wallet_core.utils.c(this).b(paramString.yRV.Lus);
              AppMethodBeat.o(65896);
              return true;
            }
            this.yUc = ((com.tencent.mm.plugin.luckymoney.f2f.a.d)paramq).yQE;
            this.zhV = ((com.tencent.mm.plugin.luckymoney.f2f.a.d)paramq).yRW;
            paramString = new PayInfo();
            paramString.dDL = ((com.tencent.mm.plugin.luckymoney.f2f.a.d)paramq).dDL;
            paramString.dVv = 37;
            if (this.mKindaEnable)
            {
              if (paramString.iqp == null) {
                paramString.iqp = new Bundle();
              }
              paramString.iqp.putBoolean("isF2FHongBao", true);
              ((com.tencent.mm.pluginsdk.wallet.a)g.af(com.tencent.mm.pluginsdk.wallet.a.class)).startSNSPay(this, paramString);
            }
          }
          for (;;)
          {
            AppMethodBeat.o(65896);
            return true;
            com.tencent.mm.wallet_core.c.af.z(37, paramString.dDL, paramInt2);
            com.tencent.mm.pluginsdk.wallet.f.a(this, paramString, 4);
            continue;
            com.tencent.mm.wallet_core.c.af.z(37, "", paramInt2);
            if (!Util.isNullOrNil(paramString)) {
              com.tencent.mm.ui.base.h.c(this, paramString, getString(2131762586), true);
            }
            this.tipDialog.dismiss();
          }
        }
        if ((paramq instanceof aw))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI
 * JD-Core Version:    0.7.0.1
 */