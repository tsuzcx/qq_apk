package com.tencent.mm.plugin.luckymoney.sns;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.luckymoney.b.ae;
import com.tencent.mm.plugin.luckymoney.b.d;
import com.tencent.mm.plugin.luckymoney.b.o;
import com.tencent.mm.plugin.luckymoney.b.x;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMoneyInputView;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMyRecordUI;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNumInputView;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyTextInputView;
import com.tencent.mm.plugin.luckymoney.ui.f;
import com.tencent.mm.plugin.luckymoney.ui.g.c;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tenpay.android.wechat.MyKeyboardWindow;
import java.util.Map;

@com.tencent.mm.ui.base.a(19)
public class SnsLuckyMoneyPrepareUI
  extends LuckyMoneyBaseUI
  implements f
{
  private am fqP = null;
  protected Dialog ftk = null;
  private ScrollView gqx;
  protected TextView iKS = null;
  private TextView iKV;
  protected Button jhV = null;
  private d lLB;
  protected LuckyMoneyNumInputView lMm = null;
  protected LuckyMoneyTextInputView lMo = null;
  protected Button lMp = null;
  protected View lMr;
  private TextView lMu;
  private com.tencent.mm.plugin.luckymoney.ui.a lMw = new com.tencent.mm.plugin.luckymoney.ui.a();
  private ViewGroup lTA;
  private int lTB;
  private String lTC;
  private int lTD;
  private boolean lTE;
  private String lTF;
  private int lTG;
  private com.tencent.mm.wallet_core.ui.a lTH;
  protected LuckyMoneyMoneyInputView lTx = null;
  private View lTy;
  private View lTz;
  protected MyKeyboardWindow mKeyboard;
  private int mType;
  
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
    localEditText.setOnFocusChangeListener(new SnsLuckyMoneyPrepareUI.10(this, paramInt, localEditText));
    localEditText.setOnClickListener(new SnsLuckyMoneyPrepareUI.12(this, paramInt, localEditText));
    paramView = (TextView)paramView.findViewById(a.f.lucky_money_amount_unit_title);
    if (paramView != null) {
      paramView.setOnClickListener(new SnsLuckyMoneyPrepareUI.13(this, paramInt, localEditText));
    }
    localView.setOnClickListener(new SnsLuckyMoneyPrepareUI.14(this));
  }
  
  protected final void VH()
  {
    if ((this.lMr != null) && (this.lMr.isShown()))
    {
      this.lMr.setVisibility(8);
      this.lTH.gK(false);
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
        this.lMp.setClickable(false);
        this.lMp.setEnabled(false);
        this.iKS.setText(com.tencent.mm.wallet_core.ui.e.B(d2));
        return;
        if (i > 0) {
          d1 = this.lTx.getInput() / i;
        }
      }
      else
      {
        if ((d2 == 0.0D) || (d1 == 0.0D)) {
          i = 1;
        }
        for (;;)
        {
          label147:
          if (i != 0)
          {
            this.lMp.setClickable(false);
            this.lMp.setEnabled(false);
            break;
            if ((d2 > this.lLB.lLa) && (this.lLB.lLa > 0.0D))
            {
              this.lMw.tR(getString(a.i.lucky_money_total_amount_max_limit_tips, new Object[] { Math.round(this.lLB.lLa), bk.aM(this.lLB.lLd, "") }));
              i = 1;
              continue;
            }
            if (d1 <= 0.0D) {
              break label638;
            }
            if (this.mType == 0)
            {
              if ((d1 <= this.lLB.lKY) || (this.lLB.lKY <= 0.0D)) {
                break label632;
              }
              this.lMw.tR(getString(a.i.lucky_money_per_amount_max_limit_tips, new Object[] { Math.round(this.lLB.lKY), bk.aM(this.lLB.lLd, "") }));
              i = 1;
            }
          }
          for (;;)
          {
            if (i == 0)
            {
              if (this.mType == 0)
              {
                if (d1 >= this.lLB.lKZ) {
                  break label629;
                }
                this.lMw.tR(getString(a.i.lucky_money_per_amount_min_limit_tips, new Object[] { com.tencent.mm.wallet_core.ui.e.A(this.lLB.lKZ), bk.aM(this.lLB.lLd, "") }));
                i = 1;
                break label147;
                if ((d1 <= this.lLB.lLb) || (this.lLB.lLb <= 0.0D)) {
                  break label632;
                }
                this.lMw.tR(getString(a.i.lucky_money_per_amount_max_limit_tips, new Object[] { Math.round(this.lLB.lLb), bk.aM(this.lLB.lLd, "") }));
                this.lMm.onError();
                this.lTx.onError();
                i = 1;
                continue;
              }
              if (d1 < 0.01D)
              {
                this.lMw.tR(getString(a.i.lucky_money_per_amount_min_limit_tips, new Object[] { "0.01", bk.aM(this.lLB.lLd, "") }));
                this.lMm.onError();
                this.lTx.onError();
                i = 1;
                break label147;
                this.lMp.setClickable(true);
                this.lMp.setEnabled(true);
                break;
              }
            }
            label629:
            break label147;
            label632:
            i = 0;
          }
          label638:
          i = 0;
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
    if ((paramm instanceof ae))
    {
      if ((this.ftk != null) && (this.ftk.isShowing())) {
        this.ftk.hide();
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (ae)paramm;
        this.lTD = paramString.iHi;
        this.lTC = paramString.lMg;
        this.lTF = paramString.lRB;
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
      com.tencent.mm.ui.base.h.bC(this, paramString);
      return true;
    }
    if ((paramm instanceof com.tencent.mm.plugin.luckymoney.b.ah))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (this.lTE)
        {
          com.tencent.mm.ui.base.h.bC(this, getString(a.i.has_send));
          finish();
        }
        for (;;)
        {
          return true;
          bgd();
          this.lTz.postDelayed(new SnsLuckyMoneyPrepareUI.2(this), 1000L);
        }
      }
      if (paramInt2 == 402)
      {
        com.tencent.mm.ui.base.h.a(this.mController.uMN, paramString, "", getString(a.i.lucky_money_send_list_title), getString(a.i.app_cancel), new SnsLuckyMoneyPrepareUI.3(this), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        return true;
      }
    }
    else if ((paramm instanceof x))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (x)paramm;
        com.tencent.mm.plugin.luckymoney.a.a.bfg();
        this.lLB = com.tencent.mm.plugin.luckymoney.a.a.bfh().bfG();
        y.d("MicroMsg.LuckyMoneyPrepareUI", "update config:" + this.lLB);
        if (this.mType != 1) {
          break label617;
        }
        this.lTx.setMaxAmount(this.lLB.lLa);
        this.lTx.setMinAmount(this.lLB.lKZ);
        this.lMm.setMaxNum(this.lLB.lKX);
        if ((paramString.lRn) && (this.lTE))
        {
          paramm = (TextView)findViewById(a.f.lucky_money_prepare_has_tips);
          paramm.setOnClickListener(new SnsLuckyMoneyPrepareUI.5(this));
          com.tencent.mm.plugin.report.service.h.nFQ.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(bfV()), Integer.valueOf(8) });
          paramm.setVisibility(0);
        }
        if (bk.bl(paramString.iHC)) {
          break label634;
        }
        y.i("MicroMsg.LuckyMoneyPrepareUI", "Put notice :" + paramString.iHC);
        this.lMu.setText(paramString.iHC);
        if (!bk.bl(paramString.lRp)) {
          this.lMu.setOnClickListener(new SnsLuckyMoneyPrepareUI.6(this, paramString));
        }
        this.lMu.setVisibility(0);
      }
      for (;;)
      {
        paramm = new g.c();
        paramm.textColor = getResources().getColor(a.c.wallet_link_color);
        com.tencent.mm.plugin.luckymoney.ui.g.a(this, this.lTA, paramString.lRr, paramm);
        return true;
        label617:
        this.lTx.setMaxAmount(this.lLB.lKY);
        break;
        label634:
        this.lMu.setVisibility(8);
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
  
  protected final int getLayoutId()
  {
    return a.g.lucky_money_prepare_ui;
  }
  
  protected final void initView()
  {
    getResources().getDrawable(a.e.lucky_money_actionbar_bg);
    setBackBtn(new SnsLuckyMoneyPrepareUI.1(this));
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
    this.gqx = ((ScrollView)findViewById(a.f.lucky_money_sv));
    this.lMu = ((TextView)findViewById(a.f.lucky_money_prepare_notice_tips));
    Object localObject1;
    if (this.mType == 1)
    {
      this.lTx.setTitle(getString(a.i.lucky_money_total_amount_title));
      this.lTx.setShowGroupIcon(true);
      this.lTx.setOnInputValidChangerListener(this);
      this.lMm.setOnInputValidChangerListener(this);
      this.lMo.setOnInputValidChangerListener(this);
      localObject1 = (EditText)this.lTx.findViewById(a.f.lucky_money_et);
      Object localObject2 = (EditText)this.lMm.findViewById(a.f.lucky_money_et);
      com.tencent.mm.wallet_core.ui.e.setNoSystemInputOnEditText((EditText)localObject1);
      ((InputMethodManager)this.mController.uMN.getSystemService("input_method")).showSoftInput((View)localObject1, 0);
      ((EditText)localObject1).setOnClickListener(new SnsLuckyMoneyPrepareUI.19(this, (EditText)localObject1, (EditText)localObject2));
      Object localObject3 = (TextView)this.lTx.findViewById(a.f.lucky_money_amount_unit_title);
      if (localObject3 != null) {
        ((TextView)localObject3).setOnClickListener(new SnsLuckyMoneyPrepareUI.20(this, (EditText)localObject1, (EditText)localObject2));
      }
      com.tencent.mm.wallet_core.ui.e.setNoSystemInputOnEditText((EditText)localObject2);
      ((InputMethodManager)this.mController.uMN.getSystemService("input_method")).showSoftInput((View)localObject2, 0);
      ((EditText)localObject2).setOnClickListener(new SnsLuckyMoneyPrepareUI.21(this, (EditText)localObject1, (EditText)localObject2));
      if (this.lLB != null)
      {
        if (this.mType != 1) {
          break label1030;
        }
        this.lTx.setMaxAmount(this.lLB.lLa);
        label447:
        this.lTx.setMinAmount(this.lLB.lKZ);
      }
      if ((!this.lTE) || (getIntent().getIntExtra("key_chatroom_num", 0) > 1)) {
        break label1047;
      }
      this.lMm.setNum("1");
      label492:
      this.lMm.setMaxNum(this.lLB.lKX);
      this.lMm.setMinNum(1);
      y.d("MicroMsg.LuckyMoneyPrepareUI", "init num=" + this.lMm.getInput());
      this.lTx.setMaxLen(12);
      if (!this.lTE) {
        break label1072;
      }
      if (getIntent().getIntExtra("key_chatroom_num", 0) <= 0) {
        break label1060;
      }
      Object localObject4 = getString(a.i.lucky_money_group_tips_random_prefix);
      Object localObject5 = getString(a.i.lucky_money_group_tips_change_to_fixed);
      localObject1 = getString(a.i.lucky_money_group_tips_fixed_prefix);
      localObject2 = getString(a.i.lucky_money_group_tips_change_to_random);
      localObject3 = new SpannableString((String)localObject4 + (String)localObject5);
      com.tencent.mm.plugin.wallet_core.ui.h localh = new com.tencent.mm.plugin.wallet_core.ui.h(this);
      ((SpannableString)localObject3).setSpan(localh, ((String)localObject4).length(), ((String)localObject4).length() + ((String)localObject5).length(), 33);
      localObject4 = new SpannableString((String)localObject1 + (String)localObject2);
      localObject5 = new com.tencent.mm.plugin.wallet_core.ui.h(this);
      ((SpannableString)localObject4).setSpan(localObject5, ((String)localObject1).length(), ((String)localObject1).length() + ((String)localObject2).length(), 33);
      localh.qDo = new SnsLuckyMoneyPrepareUI.11(this, (SpannableString)localObject4);
      ((com.tencent.mm.plugin.wallet_core.ui.h)localObject5).qDo = new SnsLuckyMoneyPrepareUI.15(this, (SpannableString)localObject3);
      this.iKV.setMovementMethod(LinkMovementMethod.getInstance());
      this.iKV.setText((CharSequence)localObject3);
      this.iKV.setVisibility(0);
    }
    for (;;)
    {
      this.lMp.setOnClickListener(new SnsLuckyMoneyPrepareUI.16(this));
      this.iKS.setText(com.tencent.mm.wallet_core.ui.e.B(0.0D));
      this.lMw.a(this.lMm);
      this.lMw.a(this.lTx);
      this.lMw.a(this.lMo);
      localObject1 = (TextView)findViewById(a.f.lucky_money_prepare_error_tips);
      this.lMw.g((TextView)localObject1);
      if ((this.lTE) && (this.mType == 1))
      {
        localObject1 = (TextView)findViewById(a.f.lucky_money_prepare_num_tips);
        ((TextView)localObject1).setText(getString(a.i.lucky_money_num_group_tips, new Object[] { Integer.valueOf(getIntent().getIntExtra("key_chatroom_num", 8)) }));
        ((TextView)localObject1).setVisibility(0);
      }
      this.fqP = new am(new SnsLuckyMoneyPrepareUI.17(this), false);
      if (this.gqx != null) {
        this.gqx.setOnTouchListener(new SnsLuckyMoneyPrepareUI.18(this));
      }
      this.lTx.setType(this.mType);
      if ((!this.lTE) || (getIntent().getIntExtra("key_chatroom_num", 0) != 0)) {
        break label1137;
      }
      this.lTx.requestFocus();
      return;
      this.lTx.setTitle(getString(a.i.lucky_money_unit_amount_title));
      this.lTx.setShowGroupIcon(false);
      break;
      label1030:
      this.lTx.setMaxAmount(this.lLB.lKY);
      break label447;
      label1047:
      this.lMm.setNum("");
      break label492;
      label1060:
      this.lMm.setVisibility(8);
      continue;
      label1072:
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
    label1137:
    this.lMm.requestFocus();
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
            y.e("MicroMsg.LuckyMoneyPrepareUI", "luckymoneyPrepareUI onActivityResult values is null");
            finish();
            return;
          }
          localObject2 = (String)((Map)localObject2).get(".msg.appmsg.wcpayinfo.paymsgid");
          if (com.tencent.mm.plugin.luckymoney.a.a.bfg().bfj().GL((String)localObject2))
          {
            y.i("MicroMsg.LuckyMoneyPrepareUI", "insert a local msg for luckymoney");
            if (!o.C(this.lTF, (String)localObject1, 1))
            {
              y.e("MicroMsg.LuckyMoneyPrepareUI", "LuckyMoneyUtil.sendLocalMsg fail!");
              com.tencent.mm.plugin.luckymoney.a.a.bfg().bfj().GM((String)localObject2);
            }
          }
          for (;;)
          {
            finish();
            break;
            y.e("MicroMsg.LuckyMoneyPrepareUI", "it is a duplicate msg");
          }
        }
        bgd();
        new com.tencent.mm.sdk.platformtools.ah().postDelayed(new SnsLuckyMoneyPrepareUI.7(this), 200L);
        this.jhV.setOnClickListener(new SnsLuckyMoneyPrepareUI.8(this));
        ((ImageView)findViewById(a.f.lucky_money_prepare_close_btn)).setOnClickListener(new SnsLuckyMoneyPrepareUI.9(this));
        continue;
        if ((paramInt2 == -1) && (paramIntent != null))
        {
          localObject1 = paramIntent.getStringExtra("Select_Conv_User");
          com.tencent.mm.plugin.report.service.h.nFQ.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(bfV()), Integer.valueOf(7), localObject1 });
          if (!bk.bl((String)localObject1)) {
            l(new com.tencent.mm.plugin.luckymoney.b.ah(((String)localObject1).replaceAll(",", "|"), this.lTC, "v1.0"));
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
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mType = getIntent().getIntExtra("key_type", 1);
    this.lTB = getIntent().getIntExtra("key_way", 3);
    if (getIntent().getIntExtra("key_from", 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.lTE = bool;
      this.lTG = getIntent().getIntExtra("pay_channel", -1);
      b(new x("v1.0", (byte)0), false);
      com.tencent.mm.plugin.luckymoney.a.a.bfg();
      this.lLB = com.tencent.mm.plugin.luckymoney.a.a.bfh().bfG();
      y.d("MicroMsg.LuckyMoneyPrepareUI", "type=" + this.mType + ", fromAppPanel=" + this.lTE + ", config " + this.lLB);
      initView();
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
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (this.lMr != null) && (this.lMr.isShown()))
    {
      VH();
      return true;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI
 * JD-Core Version:    0.7.0.1
 */