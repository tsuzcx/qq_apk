package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ah.m;
import com.tencent.mm.h.a.pt;
import com.tencent.mm.plugin.luckymoney.b.ae;
import com.tencent.mm.plugin.luckymoney.b.ah;
import com.tencent.mm.plugin.luckymoney.b.o;
import com.tencent.mm.plugin.luckymoney.b.v;
import com.tencent.mm.plugin.luckymoney.b.x;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.a.a.a;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.snackbar.b;
import com.tencent.mm.wallet_core.c.aa;
import com.tencent.mm.wallet_core.ui.MMScrollView;
import com.tenpay.android.wechat.MyKeyboardWindow;
import java.util.Map;

public class LuckyMoneyPrepareUI
  extends LuckyMoneyBaseUI
  implements f
{
  private int drX;
  private am fqP = null;
  private Dialog ftk = null;
  private TextView iKS = null;
  private TextView iKV;
  private Button jhV = null;
  private com.tencent.mm.plugin.luckymoney.b.d lLB;
  private LuckyMoneyNumInputView lMm = null;
  private LuckyMoneyTextInputView lMo = null;
  private Button lMp = null;
  protected View lMr;
  private MMScrollView lMt;
  private TextView lMu;
  private a lMw = new a();
  private ViewGroup lTA;
  private int lTB;
  private String lTC;
  private int lTD;
  private boolean lTE;
  private String lTF;
  private int lTG;
  private LuckyMoneyMoneyInputView lTx = null;
  private View lTy;
  private View lTz;
  private String lUy;
  private int lWY = 1;
  private String lWZ = com.tencent.mm.wallet_core.ui.e.afh("CNY");
  private String lXa = null;
  private RealnameGuideHelper lXb;
  private String lXc;
  private com.tencent.mm.ui.widget.c lXd;
  private boolean lXe = false;
  private com.tencent.mm.sdk.b.c<pt> lXf = new LuckyMoneyPrepareUI.12(this);
  protected MyKeyboardWindow mKeyboard;
  private int mType;
  
  private void GQ(String paramString)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.LuckyMoneyPrepareUI", "do business callback");
    b(new v(this.lUy, paramString, this.lXc), false);
  }
  
  private void b(double paramDouble, String paramString)
  {
    if (bk.bl(paramString))
    {
      this.iKS.setText(com.tencent.mm.wallet_core.ui.e.B(paramDouble));
      return;
    }
    this.iKS.setText(paramString + com.tencent.mm.wallet_core.ui.e.A(paramDouble));
  }
  
  private int bfV()
  {
    if (this.lTE)
    {
      if (getIntent().getIntExtra("key_chatroom_num", 0) > 0) {
        return 2;
      }
      return 1;
    }
    return 3;
  }
  
  private boolean bgq()
  {
    return (this.lLB != null) && (!bk.bl(this.lLB.lPQ));
  }
  
  private void dM(String paramString1, String paramString2)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.LuckyMoneyPrepareUI", "initH5LuckyMoneyView  currencyWording=" + paramString1);
    TextView localTextView = (TextView)findViewById(a.f.lucky_money_amount_unit_title);
    if (!bk.bl(paramString1)) {
      localTextView.setText(paramString1);
    }
    while (!bk.bl(paramString2))
    {
      b(0.0D, paramString2);
      return;
      localTextView.setText(getString(a.i.lucky_money_amount_unit_title));
    }
    b(0.0D, com.tencent.mm.wallet_core.ui.e.afh("CNY"));
  }
  
  private void init()
  {
    if (this.lWY == 1)
    {
      addIconOptionMenu(0, a.e.mm_title_btn_menu, new LuckyMoneyPrepareUI.31(this));
      return;
    }
    addIconOptionMenu(0, a.e.lucky_money_help_btn, new LuckyMoneyPrepareUI.32(this));
  }
  
  protected final void J(View paramView, int paramInt)
  {
    this.mKeyboard = ((MyKeyboardWindow)findViewById(a.f.tenpay_num_keyboard));
    this.lMr = findViewById(a.f.tenpay_keyboard_layout);
    View localView = findViewById(a.f.tenpay_push_down);
    EditText localEditText = (EditText)paramView.findViewById(a.f.lucky_money_et);
    if ((this.mKeyboard == null) || (localEditText == null) || (this.lMr == null)) {
      return;
    }
    com.tencent.mm.wallet_core.ui.e.setNoSystemInputOnEditText(localEditText);
    localEditText.setOnFocusChangeListener(new LuckyMoneyPrepareUI.23(this, paramInt, localEditText));
    localEditText.setOnClickListener(new LuckyMoneyPrepareUI.24(this, paramInt, localEditText));
    TextView localTextView = (TextView)paramView.findViewById(a.f.lucky_money_amount_unit_title);
    if (localTextView != null) {
      localTextView.setOnClickListener(new LuckyMoneyPrepareUI.25(this, localEditText, paramView, paramInt));
    }
    localView.setOnClickListener(new LuckyMoneyPrepareUI.26(this));
  }
  
  protected final void VH()
  {
    if ((this.lMr != null) && (this.lMr.isShown())) {
      this.lMr.setVisibility(8);
    }
  }
  
  public final void bfq()
  {
    com.tencent.mm.plugin.luckymoney.a.a.bfg();
    this.lLB = com.tencent.mm.plugin.luckymoney.a.a.bfh().bfG();
    int i;
    double d2;
    double d1;
    if ((this.lTx.bfp() != 3) && (this.lMm.bfp() != 3))
    {
      i = this.lMm.getInput();
      d2 = this.lTx.getInput();
      if (this.mType == 0)
      {
        d2 *= i;
        d1 = this.lTx.getInput();
      }
    }
    for (;;)
    {
      if (this.lMw.bgi())
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.LuckyMoneyPrepareUI", "has error");
        this.lMp.setClickable(false);
        this.lMp.setEnabled(false);
        b(d2, this.lWZ);
        return;
        if (i > 0) {
          d1 = this.lTx.getInput() / i;
        }
      }
      else
      {
        boolean bool2;
        if ((d2 == 0.0D) || (d1 == 0.0D)) {
          bool2 = true;
        }
        for (;;)
        {
          label403:
          boolean bool1;
          if (bool2)
          {
            this.lMp.setClickable(false);
            this.lMp.setEnabled(false);
            break;
            if ((d2 > this.lLB.lLa) && (this.lLB.lLa > 0.0D))
            {
              this.lMw.tR(getString(a.i.lucky_money_total_amount_max_limit_tips, new Object[] { Math.round(this.lLB.lLa), bk.aM(this.lLB.lLd, "") }));
              bool2 = true;
              continue;
            }
            if (d1 <= 0.0D) {
              break label1033;
            }
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.LuckyMoneyPrepareUI", "perAmount " + d1);
            if (this.mType == 0)
            {
              if ((d1 <= this.lLB.lKY) || (this.lLB.lKY <= 0.0D)) {
                break label1027;
              }
              if (bgq())
              {
                this.lMw.tR(getString(a.i.lucky_money_per_amount_max_limit_tips_format, new Object[] { this.lLB.lPQ, Math.round(this.lLB.lKY), bk.aM(this.lLB.lLd, "") }));
                bool1 = true;
              }
            }
          }
          for (;;)
          {
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.LuckyMoneyPrepareUI", "furtherCheckHasErr:" + bool1 + " for max value");
            bool2 = bool1;
            if (!bool1)
            {
              if (this.mType != 0) {
                break label876;
              }
              bool2 = bool1;
              if (d1 < this.lLB.lKZ)
              {
                if (!bgq()) {
                  break label826;
                }
                this.lMw.tR(getString(a.i.lucky_money_per_amount_min_limit_tips_format, new Object[] { this.lLB.lPQ, com.tencent.mm.wallet_core.ui.e.A(this.lLB.lKZ), bk.aM(this.lLB.lLd, "") }));
                label531:
                bool2 = true;
              }
            }
            label826:
            label876:
            do
            {
              com.tencent.mm.sdk.platformtools.y.i("MicroMsg.LuckyMoneyPrepareUI", "furtherCheckHasErr:" + bool2 + " for min value");
              break;
              this.lMw.tR(getString(a.i.lucky_money_per_amount_max_limit_tips, new Object[] { Math.round(this.lLB.lKY), bk.aM(this.lLB.lLd, "") }));
              break label403;
              if ((d1 <= this.lLB.lLb) || (this.lLB.lLb <= 0.0D)) {
                break label1027;
              }
              if ((this.lLB != null) && (!bk.bl(this.lLB.lPQ))) {
                this.lMw.tR(getString(a.i.lucky_money_per_amount_max_limit_tips_format, new Object[] { this.lLB.lPQ, Math.round(this.lLB.lLb), bk.aM(this.lLB.lLd, "") }));
              }
              for (;;)
              {
                this.lMm.onError();
                this.lTx.onError();
                bool1 = true;
                break;
                this.lMw.tR(getString(a.i.lucky_money_per_amount_max_limit_tips, new Object[] { Math.round(this.lLB.lLb), bk.aM(this.lLB.lLd, "") }));
              }
              this.lMw.tR(getString(a.i.lucky_money_per_amount_min_limit_tips, new Object[] { com.tencent.mm.wallet_core.ui.e.A(this.lLB.lKZ), bk.aM(this.lLB.lLd, "") }));
              break label531;
              bool2 = bool1;
            } while (d1 >= 0.01D);
            if (bgq()) {
              this.lMw.tR(getString(a.i.lucky_money_per_amount_min_limit_tips_format, new Object[] { this.lLB.lPQ, "0.01", bk.aM(this.lLB.lLd, "") }));
            }
            for (;;)
            {
              this.lMm.onError();
              this.lTx.onError();
              bool2 = true;
              break;
              this.lMw.tR(getString(a.i.lucky_money_per_amount_min_limit_tips, new Object[] { "0.01", bk.aM(this.lLB.lLd, "") }));
            }
            this.lMp.setClickable(true);
            this.lMp.setEnabled(true);
            break;
            label1027:
            bool1 = false;
          }
          label1033:
          bool2 = false;
        }
      }
      d1 = 0.0D;
      continue;
      d1 = 0.0D;
      d2 = 0.0D;
    }
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.LuckyMoneyPrepareUI", "errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scenetype:" + paramm.getType());
    if ((paramm instanceof ae))
    {
      if ((this.ftk != null) && (this.ftk.isShowing())) {
        this.ftk.dismiss();
      }
      if (this.lXe)
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.LuckyMoneyPrepareUI", "has show alert return");
        return true;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (ae)paramm;
        this.lTD = paramString.iHi;
        this.lTC = paramString.lMg;
        this.lTF = paramString.lRB;
        this.lUy = paramString.lMg;
        this.lXc = paramString.lRH;
        paramm = new PayInfo();
        paramm.bMX = paramString.lRA;
        paramm.bUV = 37;
        paramm.bUR = this.lTG;
        com.tencent.mm.pluginsdk.wallet.h.a(this, paramm, 1);
        return true;
      }
      if (paramInt2 == 401)
      {
        this.lMp.setEnabled(false);
        this.lMp.setClickable(false);
        this.fqP.S(5000L, 5000L);
        com.tencent.mm.ui.base.h.bC(this, paramString);
        return true;
      }
      paramm = paramString;
      if (TextUtils.isEmpty(paramString)) {
        paramm = getString(a.i.wallet_unknown_err);
      }
      com.tencent.mm.ui.base.h.a(this, paramm, null, false, new LuckyMoneyPrepareUI.10(this));
      return true;
    }
    if ((paramm instanceof ah))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (this.lTE)
        {
          b.h(this, getString(a.i.has_send));
          com.tencent.mm.sdk.platformtools.ai.l(new LuckyMoneyPrepareUI.13(this), 1800L);
        }
        for (;;)
        {
          return true;
          bgd();
          this.lTz.setVisibility(0);
          this.lTz.postDelayed(new LuckyMoneyPrepareUI.14(this), 1000L);
        }
      }
      if (paramInt2 == 402)
      {
        com.tencent.mm.ui.base.h.a(this.mController.uMN, paramString, "", getString(a.i.lucky_money_send_list_title), getString(a.i.app_cancel), new LuckyMoneyPrepareUI.15(this), new LuckyMoneyPrepareUI.16(this));
        return true;
      }
    }
    else
    {
      if ((paramm instanceof x))
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.LuckyMoneyPrepareUI", "NetSceneLuckyMoneyGetConfig resp,errType=" + paramInt1 + ";errCode=" + paramInt2 + ";errMsg=" + paramString);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = (x)paramm;
          com.tencent.mm.plugin.luckymoney.a.a.bfg();
          this.lLB = com.tencent.mm.plugin.luckymoney.a.a.bfh().bfG();
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.LuckyMoneyPrepareUI", "update config:" + this.lLB);
          if (this.mType != 1) {
            break label890;
          }
          this.lTx.setMaxAmount(this.lLB.lLa);
          this.lTx.setMinAmount(this.lLB.lKZ);
          this.lMm.setMaxNum(this.lLB.lKX);
          this.lWZ = paramString.lLc;
          this.lWY = paramString.iHA;
          this.lXa = paramString.lLm;
          if ((!bk.bl(this.lXa)) && (this.lMo != null)) {
            com.tencent.mm.sdk.platformtools.ai.d(new LuckyMoneyPrepareUI.17(this));
          }
          if ((paramString.lRn) && (this.lTE))
          {
            paramm = (TextView)findViewById(a.f.lucky_money_prepare_has_tips);
            paramm.setOnClickListener(new LuckyMoneyPrepareUI.18(this));
            com.tencent.mm.plugin.report.service.h.nFQ.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(bfV()), Integer.valueOf(8) });
            paramm.setVisibility(0);
          }
          if (bk.bl(paramString.iHC)) {
            break label907;
          }
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.LuckyMoneyPrepareUI", "Put notice :" + paramString.iHC);
          this.lMu.setText(paramString.iHC);
          if (!bk.bl(paramString.lRp)) {
            this.lMu.setOnClickListener(new LuckyMoneyPrepareUI.19(this, paramString));
          }
          this.lMu.setVisibility(0);
          label805:
          paramm = new g.c();
          if ((paramString.lRr == null) || (bk.bl(paramString.lRr.content))) {
            break label919;
          }
        }
        label907:
        label919:
        for (paramm.textColor = getResources().getColor(a.c.wallet_link_color);; paramm.textColor = getResources().getColor(a.c.hint_text_color))
        {
          g.a(this, this.lTA, paramString.lRr, paramm);
          dM(paramString.lLd, paramString.lLc);
          b(0.0D, this.lWZ);
          init();
          return true;
          label890:
          this.lTx.setMaxAmount(this.lLB.lKY);
          break;
          this.lMu.setVisibility(8);
          break label805;
        }
      }
      if ((paramm instanceof com.tencent.mm.plugin.luckymoney.b.y))
      {
        ki(1645);
        if ((this.ftk != null) && (this.ftk.isShowing())) {
          this.ftk.hide();
        }
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = ((com.tencent.mm.plugin.luckymoney.b.y)paramm).iHO;
          if (!bk.bl(paramString))
          {
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.LuckyMoneyPrepareUI", "payUrl is not null");
            paramm = new Intent();
            paramm.putExtra("rawUrl", paramString);
            paramm.putExtra("showShare", false);
            com.tencent.mm.br.d.b(this, "webview", ".ui.tools.WebViewUI", paramm, 3);
          }
          for (;;)
          {
            return true;
            com.tencent.mm.sdk.platformtools.y.e("MicroMsg.LuckyMoneyPrepareUI", "payUrl is null");
          }
        }
      }
      else if ((paramm instanceof com.tencent.mm.plugin.luckymoney.f2f.a.d))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          if (this.ftk != null) {
            this.ftk.dismiss();
          }
          this.lUy = ((com.tencent.mm.plugin.luckymoney.f2f.a.d)paramm).lMg;
          this.lXc = ((com.tencent.mm.plugin.luckymoney.f2f.a.d)paramm).lNw;
          paramString = new PayInfo();
          paramString.bMX = ((com.tencent.mm.plugin.luckymoney.f2f.a.d)paramm).bMX;
          paramString.bUV = 37;
          aa.l(37, paramString.bMX, paramInt2);
          com.tencent.mm.pluginsdk.wallet.h.a(this, paramString, 4);
        }
        for (;;)
        {
          return true;
          aa.l(37, "", paramInt2);
          if (!bk.bl(paramString)) {
            com.tencent.mm.ui.base.h.b(this, paramString, getString(a.i.lucky_money_app_tip), true);
          }
          this.ftk.dismiss();
        }
      }
    }
    return false;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (this.lTy.getVisibility() == 0))
    {
      this.lTy.setVisibility(8);
      bgc();
      return true;
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  public void finish()
  {
    if (this.lXb != null)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("key_realname_guide_helper", this.lXb);
      com.tencent.mm.br.d.b(this, "wallet_core", ".id_verify.RealnameDialogActivity", localIntent);
    }
    super.finish();
  }
  
  protected final int getLayoutId()
  {
    return a.g.lucky_money_prepare_ui;
  }
  
  protected final void initView()
  {
    setBackBtn(new LuckyMoneyPrepareUI.1(this));
    this.lTy = findViewById(a.f.lucky_money_prepare_ready_ll);
    this.lTz = findViewById(a.f.lucky_money_prepare_sent_area);
    this.jhV = ((Button)findViewById(a.f.lucky_money_prepare_send_btn));
    this.lMo = ((LuckyMoneyTextInputView)findViewById(a.f.lucky_money_wish_et));
    this.lMo.setHintText(getString(a.i.lucky_money_default_wish));
    this.lMp = ((Button)findViewById(a.f.lucky_money_prepare_btn));
    this.mKeyboard = ((MyKeyboardWindow)findViewById(a.f.tenpay_num_keyboard));
    this.lMr = findViewById(a.f.tenpay_keyboard_layout);
    this.iKV = ((TextView)findViewById(a.f.lucky_money_prepare_amount_tips));
    this.lMm = ((LuckyMoneyNumInputView)findViewById(a.f.lucky_money_num_et));
    this.lTx = ((LuckyMoneyMoneyInputView)findViewById(a.f.lucky_money_amount_et));
    this.iKS = ((TextView)findViewById(a.f.lucky_money_prepare_total_amount));
    this.lTA = ((ViewGroup)findViewById(a.f.lucky_money_prepare_opertaion));
    this.lMt = ((MMScrollView)findViewById(a.f.lucky_money_sv));
    this.lMu = ((TextView)findViewById(a.f.lucky_money_prepare_notice_tips));
    Object localObject1;
    Object localObject2;
    Object localObject3;
    label531:
    label605:
    label746:
    int i;
    if (this.mType == 1)
    {
      setMMTitle(a.i.lucky_money_group);
      this.lTx.setTitle(getString(a.i.lucky_money_total_amount_title));
      this.lTx.setShowGroupIcon(true);
      this.lTx.setOnInputValidChangerListener(this);
      this.lTx.setHint(getString(a.i.lucky_money_money_hint));
      this.lMm.setOnInputValidChangerListener(this);
      this.lMm.setHint(getString(a.i.lucky_money_num_hint));
      this.lMo.setOnInputValidChangerListener(this);
      localObject1 = (EditText)this.lTx.findViewById(a.f.lucky_money_et);
      localObject2 = (EditText)this.lMm.findViewById(a.f.lucky_money_et);
      com.tencent.mm.wallet_core.ui.e.setNoSystemInputOnEditText((EditText)localObject1);
      ((InputMethodManager)this.mController.uMN.getSystemService("input_method")).showSoftInput((View)localObject1, 0);
      ((EditText)localObject1).addTextChangedListener(new LuckyMoneyPrepareUI.4(this, (EditText)localObject1));
      ((EditText)localObject2).addTextChangedListener(new LuckyMoneyPrepareUI.5(this, (EditText)localObject2));
      ((EditText)localObject1).setOnClickListener(new LuckyMoneyPrepareUI.6(this, (EditText)localObject1, (EditText)localObject2));
      ((EditText)localObject1).requestFocus();
      localObject3 = (TextView)this.lTx.findViewById(a.f.lucky_money_amount_unit_title);
      if (localObject3 != null) {
        ((TextView)localObject3).setOnClickListener(new LuckyMoneyPrepareUI.7(this, (EditText)localObject1, (EditText)localObject2));
      }
      com.tencent.mm.wallet_core.ui.e.setNoSystemInputOnEditText((EditText)localObject2);
      ((InputMethodManager)this.mController.uMN.getSystemService("input_method")).showSoftInput((View)localObject2, 0);
      ((EditText)localObject2).setOnClickListener(new LuckyMoneyPrepareUI.8(this, (EditText)localObject1, (EditText)localObject2));
      ((MMEditText)this.lMo.findViewById(a.f.lucky_money_text)).setOnFocusChangeListener(new LuckyMoneyPrepareUI.9(this, (EditText)localObject1, (EditText)localObject2));
      if (this.lLB != null)
      {
        if (this.mType != 1) {
          break label942;
        }
        this.lTx.setMaxAmount(this.lLB.lLa);
        this.lTx.setMinAmount(this.lLB.lKZ);
        if (this.lLB.iHA != 1) {
          dM(this.lLB.lLd, this.lLB.lLc);
        }
      }
      if ((!this.lTE) || (getIntent().getIntExtra("key_chatroom_num", 0) > 1)) {
        break label959;
      }
      this.lMm.setNum("1");
      this.lMm.setMaxNum(this.lLB.lKX);
      this.lMm.setMinNum(1);
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.LuckyMoneyPrepareUI", "init num=" + this.lMm.getInput());
      this.lTx.setMaxLen(12);
      if (bgq()) {
        this.lMp.setText(getString(a.i.lucky_money_prepare_money_format, new Object[] { this.lLB.lPQ }));
      }
      if ((!this.lTE) && (this.drX != 2)) {
        break label1350;
      }
      if (!bgq()) {
        break label972;
      }
      setMMTitle(getString(a.i.lucky_money_to_send_title_format, new Object[] { this.lLB.lPQ }));
      i = getIntent().getIntExtra("key_chatroom_num", 0);
      if ((!this.lTE) || (i != 0)) {
        break label982;
      }
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.LuckyMoneyPrepareUI", "single hb");
      this.lMm.setVisibility(8);
    }
    for (;;)
    {
      this.lMp.setOnClickListener(new LuckyMoneyPrepareUI.28(this));
      this.lMw.a(this.lMm);
      this.lMw.a(this.lTx);
      this.lMw.a(this.lMo);
      localObject1 = (TextView)findViewById(a.f.lucky_money_prepare_error_tips);
      this.lMw.g((TextView)localObject1);
      this.fqP = new am(new LuckyMoneyPrepareUI.29(this), false);
      if (this.lMt != null) {
        this.lMt.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            if (paramAnonymousMotionEvent.getAction() == 0)
            {
              LuckyMoneyPrepareUI.this.VH();
              LuckyMoneyPrepareUI.this.XM();
            }
            return false;
          }
        });
      }
      this.lTx.setType(this.mType);
      init();
      return;
      setMMTitle(a.i.lucky_money_normal);
      this.lTx.setTitle(getString(a.i.lucky_money_unit_amount_title));
      this.lTx.setShowGroupIcon(false);
      break;
      label942:
      this.lTx.setMaxAmount(this.lLB.lKY);
      break label531;
      label959:
      this.lMm.setNum("");
      break label605;
      label972:
      setMMTitle(a.i.lucky_money_to_send_title);
      break label746;
      label982:
      localObject2 = getString(a.i.lucky_money_f2f_random_tip_prefix);
      Object localObject4 = getString(a.i.lucky_money_group_tips_change_to_fixed);
      localObject1 = getString(a.i.lucky_money_f2f_fixed_tip_prefix);
      localObject3 = getString(a.i.lucky_money_group_tips_change_to_random);
      Object localObject5;
      if ((this.lTE) && (i > 0))
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.LuckyMoneyPrepareUI", "group hb,%d people", new Object[] { Integer.valueOf(i) });
        localObject2 = getString(a.i.lucky_money_group_tips_random_prefix);
        localObject1 = getString(a.i.lucky_money_group_tips_fixed_prefix);
        localObject5 = (TextView)findViewById(a.f.lucky_money_prepare_num_tips);
        ((TextView)localObject5).setText(getString(a.i.lucky_money_num_group_tips, new Object[] { Integer.valueOf(getIntent().getIntExtra("key_chatroom_num", 8)) }));
        ((TextView)localObject5).setVisibility(0);
      }
      for (;;)
      {
        localObject5 = new com.tencent.mm.plugin.wallet_core.ui.h(this);
        SpannableString localSpannableString = new SpannableString((String)localObject2 + (String)localObject4);
        localSpannableString.setSpan(localObject5, ((String)localObject2).length(), ((String)localObject2).length() + ((String)localObject4).length(), 33);
        localObject2 = new SpannableString((String)localObject1 + (String)localObject3);
        localObject4 = new com.tencent.mm.plugin.wallet_core.ui.h(this);
        ((SpannableString)localObject2).setSpan(localObject4, ((String)localObject1).length(), ((String)localObject1).length() + ((String)localObject3).length(), 33);
        ((com.tencent.mm.plugin.wallet_core.ui.h)localObject5).qDo = new LuckyMoneyPrepareUI.11(this, (SpannableString)localObject2);
        ((com.tencent.mm.plugin.wallet_core.ui.h)localObject4).qDo = new LuckyMoneyPrepareUI.22(this, localSpannableString);
        this.iKV.setMovementMethod(LinkMovementMethod.getInstance());
        if (a.a.cAj().cAi()) {
          this.iKV.setOnClickListener(new LuckyMoneyPrepareUI.27(this, localSpannableString, (com.tencent.mm.plugin.wallet_core.ui.h)localObject5, (com.tencent.mm.plugin.wallet_core.ui.h)localObject4));
        }
        this.iKV.setText(localSpannableString);
        this.iKV.setVisibility(0);
        break;
        if (this.drX == 2)
        {
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.LuckyMoneyPrepareUI", "f2f hb");
          this.lMo.setVisibility(8);
        }
      }
      label1350:
      if (this.mType == 1)
      {
        this.iKV.setText(this.lLB.lPM);
        this.iKV.setVisibility(0);
      }
      else if (this.mType == 0)
      {
        this.iKV.setText(this.lLB.lPN);
        this.iKV.setVisibility(0);
      }
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      if ((paramIntent != null) && (paramIntent.hasExtra("key_realname_guide_helper"))) {
        this.lXb = ((RealnameGuideHelper)paramIntent.getParcelableExtra("key_realname_guide_helper"));
      }
      if (paramInt2 == -1)
      {
        com.tencent.mm.plugin.report.service.h.nFQ.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(bfV()), Integer.valueOf(5) });
        Object localObject1 = getIntent().getStringExtra("key_username");
        if ((this.lTE) && (!bk.bl((String)localObject1)))
        {
          com.tencent.mm.ui.base.h.bC(this, getString(a.i.has_send));
          Object localObject2 = bn.s(this.lTF, "msg");
          if (localObject2 == null)
          {
            com.tencent.mm.sdk.platformtools.y.e("MicroMsg.LuckyMoneyPrepareUI", "luckymoneyPrepareUI onActivityResult values is null");
            finish();
            return;
          }
          localObject2 = (String)((Map)localObject2).get(".msg.appmsg.wcpayinfo.paymsgid");
          if (com.tencent.mm.plugin.luckymoney.a.a.bfg().bfj().GL((String)localObject2))
          {
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.LuckyMoneyPrepareUI", "insert a local msg for luckymoney");
            if (!o.C(this.lTF, (String)localObject1, 1))
            {
              com.tencent.mm.sdk.platformtools.y.e("MicroMsg.LuckyMoneyPrepareUI", "LuckyMoneyUtil.sendLocalMsg fail!");
              com.tencent.mm.plugin.luckymoney.a.a.bfg().bfj().GM((String)localObject2);
            }
            label262:
            finish();
          }
        }
        for (;;)
        {
          localObject1 = "";
          if (paramIntent != null) {
            localObject1 = paramIntent.getStringExtra("key_trans_id");
          }
          GQ((String)localObject1);
          break;
          com.tencent.mm.sdk.platformtools.y.e("MicroMsg.LuckyMoneyPrepareUI", "it is a duplicate msg");
          break label262;
          bgd();
          localObject1 = findViewById(a.f.lucky_money_prepare_ready_packet_ll);
          this.lTy.setVisibility(0);
          o.a((View)localObject1, null);
          this.jhV.setOnClickListener(new LuckyMoneyPrepareUI.20(this));
          ((ImageView)findViewById(a.f.lucky_money_prepare_close_btn)).setOnClickListener(new LuckyMoneyPrepareUI.21(this));
        }
        if ((paramInt2 == -1) && (paramIntent != null))
        {
          localObject1 = paramIntent.getStringExtra("Select_Conv_User");
          com.tencent.mm.plugin.report.service.h.nFQ.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(bfV()), Integer.valueOf(7), localObject1 });
          if (!bk.bl((String)localObject1)) {
            l(new ah(((String)localObject1).replaceAll(",", "|"), this.lTC, "v1.0"));
          } else {
            finish();
          }
        }
        else if (paramInt2 == 0)
        {
          localObject1 = new Intent();
          ((Intent)localObject1).setClass(this.mController.uMN, LuckyMoneyMyRecordUI.class);
          ((Intent)localObject1).putExtra("key_type", 1);
          startActivity((Intent)localObject1);
          continue;
          if ((paramIntent != null) && (paramIntent.hasExtra("result_data")))
          {
            localObject1 = paramIntent.getBundleExtra("result_data");
            if (localObject1 != null)
            {
              int i = bk.getInt(((Bundle)localObject1).getString("payState", "2"), 0);
              com.tencent.mm.sdk.platformtools.y.e("MicroMsg.LuckyMoneyPrepareUI", "onActivityResult REQUEST_CODE_H5_PAY payState is " + i + ";STATE_H5_PAY_SUCC=0");
              if (i == 0) {
                finish();
              }
            }
            else
            {
              com.tencent.mm.sdk.platformtools.y.e("MicroMsg.LuckyMoneyPrepareUI", "onActivityResult REQUEST_CODE_H5_PAY bundle is null");
              continue;
              if (paramInt2 == -1)
              {
                localObject1 = "";
                if (paramIntent != null) {
                  localObject1 = paramIntent.getStringExtra("key_trans_id");
                }
                GQ((String)localObject1);
              }
              finish();
            }
          }
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mType = getIntent().getIntExtra("key_type", 1);
    this.lTB = getIntent().getIntExtra("key_way", 3);
    this.drX = getIntent().getIntExtra("key_from", 0);
    if (this.drX == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.lTE = bool;
      this.lTG = getIntent().getIntExtra("pay_channel", -1);
      b(new x("v1.0", (byte)0), true);
      com.tencent.mm.plugin.luckymoney.a.a.bfg();
      this.lLB = com.tencent.mm.plugin.luckymoney.a.a.bfh().bfG();
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.LuckyMoneyPrepareUI", "mInWay:" + this.lTB + "mChannel:" + this.lTG);
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.LuckyMoneyPrepareUI", "type=" + this.mType + ", fromAppPanel=" + this.lTE + ", config " + this.lLB);
      initView();
      com.tencent.mm.sdk.b.a.udP.b(this.lXf);
      com.tencent.mm.plugin.report.service.h.nFQ.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(bfV()), Integer.valueOf(1) });
      return;
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.lMw.clear();
    this.fqP.crl();
    if ((this.ftk != null) && (this.ftk.isShowing())) {
      this.ftk.dismiss();
    }
    com.tencent.mm.sdk.b.a.udP.d(this.lXf);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (this.lMr != null) && (this.lMr.isShown()))
    {
      this.lMr.setVisibility(8);
      return true;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  protected void onResume()
  {
    super.onResume();
    kh(1970);
  }
  
  protected void onStop()
  {
    super.onStop();
    ki(1970);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI
 * JD-Core Version:    0.7.0.1
 */