package com.tencent.mm.plugin.luckymoney.sns;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.luckymoney.model.ah;
import com.tencent.mm.plugin.luckymoney.model.as;
import com.tencent.mm.plugin.luckymoney.model.bc;
import com.tencent.mm.plugin.luckymoney.model.bh;
import com.tencent.mm.plugin.luckymoney.model.o;
import com.tencent.mm.plugin.luckymoney.model.w;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMoneyInputView;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMyRecordUI;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNumInputView;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyTextInputView;
import com.tencent.mm.plugin.luckymoney.ui.c;
import com.tencent.mm.plugin.luckymoney.ui.i.c;
import com.tencent.mm.plugin.wallet_core.ui.n;
import com.tencent.mm.plugin.wallet_core.ui.n.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.wallet_core.ui.l;
import com.tenpay.android.wechat.MyKeyboardWindow;
import java.util.Map;

@com.tencent.mm.ui.base.a(19)
public class SnsLuckyMoneyPrepareUI
  extends LuckyMoneyBaseUI
  implements com.tencent.mm.plugin.luckymoney.ui.h
{
  private static final String Knp;
  private o KmF;
  protected LuckyMoneyNumInputView Knq;
  protected LuckyMoneyTextInputView Kns;
  protected Button Knt;
  private TextView Knx;
  private c Knz;
  private int Krb;
  protected LuckyMoneyMoneyInputView KvU;
  private View KvV;
  private View KvW;
  private ViewGroup KvX;
  private String KvY;
  private int KvZ;
  private boolean Kwa;
  private String Kwb;
  private int mChannel;
  protected View mKBLayout;
  protected MyKeyboardWindow mKeyboard;
  private com.tencent.mm.wallet_core.ui.a mTenpayKBStateListener;
  private int mType;
  private ScrollView pLK;
  private MTimerHandler qaM;
  private TextView tHK;
  protected Dialog tipDialog;
  protected Button xXJ;
  protected TextView xcT;
  
  static
  {
    AppMethodBeat.i(283914);
    Knp = "https://" + WeChatHosts.domainString(a.i.host_kf_qq_com) + "/touch/product/wechathongbao_platform_app.html?scene_id=kf7";
    AppMethodBeat.o(283914);
  }
  
  public SnsLuckyMoneyPrepareUI()
  {
    AppMethodBeat.i(65387);
    this.Knq = null;
    this.KvU = null;
    this.Kns = null;
    this.xcT = null;
    this.Knt = null;
    this.xXJ = null;
    this.tipDialog = null;
    this.Knz = new c();
    this.qaM = null;
    AppMethodBeat.o(65387);
  }
  
  private int fXD()
  {
    AppMethodBeat.i(65398);
    if (this.Kwa)
    {
      if (getIntent().getIntExtra("key_chatroom_num", 0) > 0)
      {
        AppMethodBeat.o(65398);
        return 2;
      }
      AppMethodBeat.o(65398);
      return 1;
    }
    AppMethodBeat.o(65398);
    return 3;
  }
  
  protected final void aF(View paramView, int paramInt)
  {
    AppMethodBeat.i(65394);
    this.mKeyboard = ((MyKeyboardWindow)findViewById(a.f.tenpay_num_keyboard));
    this.mKBLayout = findViewById(a.f.tenpay_keyboard_layout);
    View localView = findViewById(a.f.tenpay_push_down);
    paramView = (EditText)paramView.findViewById(a.f.lucky_money_et);
    if ((this.mKeyboard == null) || (paramView == null) || (this.mKBLayout == null))
    {
      AppMethodBeat.o(65394);
      return;
    }
    com.tencent.mm.wallet_core.ui.i.setNoSystemInputOnEditText(paramView);
    paramView.setOnFocusChangeListener(new SnsLuckyMoneyPrepareUI.10(this, paramInt, paramView));
    paramView.setOnClickListener(new SnsLuckyMoneyPrepareUI.11(this, paramInt, paramView));
    localView.setOnClickListener(new SnsLuckyMoneyPrepareUI.13(this));
    AppMethodBeat.o(65394);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(65391);
    if ((paramKeyEvent.getKeyCode() == 4) && (this.KvV.getVisibility() == 0))
    {
      this.KvV.setVisibility(8);
      showActionBar();
      AppMethodBeat.o(65391);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(65391);
    return bool;
  }
  
  public final void fWx()
  {
    AppMethodBeat.i(65397);
    com.tencent.mm.plugin.luckymoney.app.a.fWk();
    this.KmF = com.tencent.mm.plugin.luckymoney.app.a.fWl().fWW();
    int i;
    double d2;
    double d1;
    if ((this.KvU.fWv() != 3) && (this.Knq.fWv() != 3))
    {
      i = this.Knq.getInput();
      d2 = this.KvU.getInput();
      if (this.mType == 0)
      {
        d2 *= i;
        d1 = this.KvU.getInput();
      }
    }
    for (;;)
    {
      if (this.Knz.fYs())
      {
        this.Knt.setClickable(false);
        this.Knt.setEnabled(false);
        this.xcT.setText(com.tencent.mm.wallet_core.ui.i.X(d2));
        AppMethodBeat.o(65397);
        return;
        if (i > 0) {
          d1 = this.KvU.getInput() / i;
        }
      }
      else
      {
        if ((d2 == 0.0D) || (d1 == 0.0D)) {
          i = 1;
        }
        for (;;)
        {
          label159:
          if (i != 0)
          {
            this.Knt.setClickable(false);
            this.Knt.setEnabled(false);
            break;
            if ((d2 > this.KmF.Kme) && (this.KmF.Kme > 0.0D))
            {
              this.Knz.afy(getString(a.i.lucky_money_total_amount_max_limit_tips, new Object[] { Math.round(this.KmF.Kme), Util.nullAs(this.KmF.Kmh, "") }));
              i = 1;
              continue;
            }
            if (d1 <= 0.0D) {
              break label650;
            }
            if (this.mType == 0)
            {
              if ((d1 <= this.KmF.Kmc) || (this.KmF.Kmc <= 0.0D)) {
                break label644;
              }
              this.Knz.afy(getString(a.i.lucky_money_per_amount_max_limit_tips, new Object[] { Math.round(this.KmF.Kmc), Util.nullAs(this.KmF.Kmh, "") }));
              i = 1;
            }
          }
          for (;;)
          {
            if (i == 0)
            {
              if (this.mType == 0)
              {
                if (d1 >= this.KmF.Kmd) {
                  break label641;
                }
                this.Knz.afy(getString(a.i.lucky_money_per_amount_min_limit_tips, new Object[] { com.tencent.mm.wallet_core.ui.i.formatMoney2f(this.KmF.Kmd), Util.nullAs(this.KmF.Kmh, "") }));
                i = 1;
                break label159;
                if ((d1 <= this.KmF.Kmf) || (this.KmF.Kmf <= 0.0D)) {
                  break label644;
                }
                this.Knz.afy(getString(a.i.lucky_money_per_amount_max_limit_tips, new Object[] { Math.round(this.KmF.Kmf), Util.nullAs(this.KmF.Kmh, "") }));
                this.Knq.atR();
                this.KvU.atR();
                i = 1;
                continue;
              }
              if (d1 < 0.01D)
              {
                this.Knz.afy(getString(a.i.lucky_money_per_amount_min_limit_tips, new Object[] { "0.01", Util.nullAs(this.KmF.Kmh, "") }));
                this.Knq.atR();
                this.KvU.atR();
                i = 1;
                break label159;
                this.Knt.setClickable(true);
                this.Knt.setEnabled(true);
                break;
              }
            }
            label641:
            break label159;
            label644:
            i = 0;
          }
          label650:
          i = 0;
        }
      }
      d1 = 0.0D;
      continue;
      d1 = 0.0D;
      d2 = 0.0D;
    }
  }
  
  public int getLayoutId()
  {
    return a.g.lucky_money_prepare_ui;
  }
  
  protected final void hideTenpayKB()
  {
    AppMethodBeat.i(65396);
    if ((this.mKBLayout != null) && (this.mKBLayout.isShown()))
    {
      this.mKBLayout.setVisibility(8);
      this.mTenpayKBStateListener.onVisibleStateChange(false);
    }
    AppMethodBeat.o(65396);
  }
  
  public void initView()
  {
    AppMethodBeat.i(65389);
    getResources().getDrawable(a.e.lucky_money_actionbar_bg);
    setBackBtn(new SnsLuckyMoneyPrepareUI.1(this));
    this.KvV = findViewById(a.f.lucky_money_prepare_ready_ll);
    this.KvW = findViewById(a.f.lucky_money_prepare_sent_area);
    this.xXJ = ((Button)findViewById(a.f.lucky_money_prepare_send_btn));
    this.Kns = ((LuckyMoneyTextInputView)findViewById(a.f.lucky_money_wish_et));
    this.Kns.setHintText(getString(a.i.lucky_money_default_wish));
    this.Knt = ((Button)findViewById(a.f.lucky_money_prepare_btn));
    this.mKeyboard = ((MyKeyboardWindow)findViewById(a.f.tenpay_num_keyboard));
    this.mKBLayout = findViewById(a.f.tenpay_keyboard_layout);
    this.tHK = ((TextView)findViewById(a.f.lucky_money_prepare_amount_tips));
    this.Knq = ((LuckyMoneyNumInputView)findViewById(a.f.lucky_money_num_et));
    this.KvU = ((LuckyMoneyMoneyInputView)findViewById(a.f.lucky_money_amount_et));
    this.xcT = ((TextView)findViewById(a.f.lucky_money_prepare_total_amount));
    this.KvX = ((ViewGroup)findViewById(a.f.lucky_money_prepare_opertaion));
    this.pLK = ((ScrollView)findViewById(a.f.lucky_money_sv));
    this.Knx = ((TextView)findViewById(a.f.lucky_money_prepare_notice_tips));
    Object localObject1;
    if (this.mType == 1)
    {
      this.KvU.setTitle(getString(a.i.lucky_money_total_amount_title));
      this.KvU.setShowGroupIcon(true);
      this.KvU.setOnInputValidChangerListener(this);
      this.Knq.setOnInputValidChangerListener(this);
      this.Kns.setOnInputValidChangerListener(this);
      localObject1 = (EditText)this.KvU.findViewById(a.f.lucky_money_et);
      Object localObject2 = (EditText)this.Knq.findViewById(a.f.lucky_money_et);
      com.tencent.mm.wallet_core.ui.i.setNoSystemInputOnEditText((EditText)localObject1);
      ((InputMethodManager)getContext().getSystemService("input_method")).showSoftInput((View)localObject1, 0);
      ((EditText)localObject1).setOnClickListener(new SnsLuckyMoneyPrepareUI.18(this, (EditText)localObject1, (EditText)localObject2));
      com.tencent.mm.wallet_core.ui.i.setNoSystemInputOnEditText((EditText)localObject2);
      ((InputMethodManager)getContext().getSystemService("input_method")).showSoftInput((View)localObject2, 0);
      ((EditText)localObject2).setOnClickListener(new SnsLuckyMoneyPrepareUI.19(this, (EditText)localObject1, (EditText)localObject2));
      if (this.KmF != null)
      {
        if (this.mType != 1) {
          break label1004;
        }
        this.KvU.setMaxAmount(this.KmF.Kme);
        label415:
        this.KvU.setMinAmount(this.KmF.Kmd);
      }
      if ((!this.Kwa) || (getIntent().getIntExtra("key_chatroom_num", 0) > 1)) {
        break label1021;
      }
      this.Knq.setNum("1");
      label460:
      this.Knq.setMaxNum(this.KmF.Kmb);
      this.Knq.setMinNum(1);
      Log.d("MicroMsg.LuckyMoneyPrepareUI", "init num=" + this.Knq.getInput());
      this.KvU.setMaxLen(12);
      if (!this.Kwa) {
        break label1046;
      }
      if (getIntent().getIntExtra("key_chatroom_num", 0) <= 0) {
        break label1034;
      }
      Object localObject3 = getString(a.i.lucky_money_group_tips_random_prefix);
      Object localObject4 = getString(a.i.lucky_money_group_tips_change_to_fixed);
      localObject1 = getString(a.i.lucky_money_group_tips_fixed_prefix);
      localObject2 = getString(a.i.lucky_money_group_tips_change_to_random);
      final SpannableString localSpannableString = new SpannableString((String)localObject3 + (String)localObject4);
      n localn = new n(this);
      localSpannableString.setSpan(localn, ((String)localObject3).length(), ((String)localObject3).length() + ((String)localObject4).length(), 33);
      localObject3 = new SpannableString((String)localObject1 + (String)localObject2);
      localObject4 = new n(this);
      ((SpannableString)localObject3).setSpan(localObject4, ((String)localObject1).length(), ((String)localObject1).length() + ((String)localObject2).length(), 33);
      localn.VPb = new n.a()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(65375);
          int i = SnsLuckyMoneyPrepareUI.this.Knq.getInput();
          double d = SnsLuckyMoneyPrepareUI.this.KvU.getInput();
          SnsLuckyMoneyPrepareUI.a(SnsLuckyMoneyPrepareUI.this, 0);
          SnsLuckyMoneyPrepareUI.this.KvU.setType(SnsLuckyMoneyPrepareUI.a(SnsLuckyMoneyPrepareUI.this));
          SnsLuckyMoneyPrepareUI.this.KvU.setShowGroupIcon(false);
          SnsLuckyMoneyPrepareUI.this.KvU.setTitle(SnsLuckyMoneyPrepareUI.this.getString(a.i.lucky_money_unit_amount_title));
          if ((d > 0.0D) && (i > 0)) {
            SnsLuckyMoneyPrepareUI.this.KvU.setAmount(com.tencent.mm.wallet_core.ui.i.formatMoney2f(d / i));
          }
          SnsLuckyMoneyPrepareUI.this.KvU.setMaxAmount(SnsLuckyMoneyPrepareUI.b(SnsLuckyMoneyPrepareUI.this).Kmc);
          SnsLuckyMoneyPrepareUI.c(SnsLuckyMoneyPrepareUI.this).setText(this.KnF);
          com.tencent.mm.plugin.report.service.h.OAn.b(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(SnsLuckyMoneyPrepareUI.d(SnsLuckyMoneyPrepareUI.this)), Integer.valueOf(3) });
          AppMethodBeat.o(65375);
        }
      };
      ((n)localObject4).VPb = new n.a()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(65379);
          int i = SnsLuckyMoneyPrepareUI.this.Knq.getInput();
          double d = SnsLuckyMoneyPrepareUI.this.KvU.getInput();
          SnsLuckyMoneyPrepareUI.a(SnsLuckyMoneyPrepareUI.this, 1);
          SnsLuckyMoneyPrepareUI.this.KvU.setType(SnsLuckyMoneyPrepareUI.a(SnsLuckyMoneyPrepareUI.this));
          SnsLuckyMoneyPrepareUI.this.KvU.setTitle(SnsLuckyMoneyPrepareUI.this.getString(a.i.lucky_money_total_amount_title));
          SnsLuckyMoneyPrepareUI.this.KvU.setShowGroupIcon(true);
          if ((d > 0.0D) && (i > 0)) {
            SnsLuckyMoneyPrepareUI.this.KvU.setAmount(com.tencent.mm.wallet_core.ui.i.formatMoney2f(d * i));
          }
          SnsLuckyMoneyPrepareUI.this.KvU.setMaxAmount(SnsLuckyMoneyPrepareUI.b(SnsLuckyMoneyPrepareUI.this).Kme);
          SnsLuckyMoneyPrepareUI.c(SnsLuckyMoneyPrepareUI.this).setText(localSpannableString);
          com.tencent.mm.plugin.report.service.h.OAn.b(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(SnsLuckyMoneyPrepareUI.d(SnsLuckyMoneyPrepareUI.this)), Integer.valueOf(2) });
          AppMethodBeat.o(65379);
        }
      };
      this.tHK.setMovementMethod(LinkMovementMethod.getInstance());
      this.tHK.setText(localSpannableString);
      this.tHK.setVisibility(0);
    }
    for (;;)
    {
      this.Knt.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(65381);
          Object localObject = new b();
          ((b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
          com.tencent.mm.plugin.report.service.h.OAn.b(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(SnsLuckyMoneyPrepareUI.d(SnsLuckyMoneyPrepareUI.this)), Integer.valueOf(4) });
          if (SnsLuckyMoneyPrepareUI.this.KvU.fWv() != 0) {
            aa.makeText(SnsLuckyMoneyPrepareUI.this.getContext(), a.i.wallet_balance_save_input_invalid, 0).show();
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(65381);
            return;
            int i = SnsLuckyMoneyPrepareUI.this.Knq.getInput();
            double d = SnsLuckyMoneyPrepareUI.this.KvU.getInput();
            long l2 = 0L;
            long l1;
            if (SnsLuckyMoneyPrepareUI.a(SnsLuckyMoneyPrepareUI.this) == 1)
            {
              l1 = com.tencent.mm.wallet_core.ui.i.Y(d);
              com.tencent.mm.kernel.h.baF();
              com.tencent.mm.kernel.h.baE().ban().B(356354, Integer.valueOf(i));
              label202:
              localObject = SnsLuckyMoneyPrepareUI.this.Kns.getInput();
              paramAnonymousView = (View)localObject;
              if (Util.isNullOrNil((String)localObject)) {
                paramAnonymousView = SnsLuckyMoneyPrepareUI.this.getString(a.i.lucky_money_default_wish);
              }
              localObject = SnsLuckyMoneyPrepareUI.this.getIntent().getStringExtra("key_username");
              if ((!SnsLuckyMoneyPrepareUI.e(SnsLuckyMoneyPrepareUI.this)) || (Util.isNullOrNil((String)localObject))) {
                break label386;
              }
            }
            label386:
            for (paramAnonymousView = new bc(i, l1, l2, SnsLuckyMoneyPrepareUI.a(SnsLuckyMoneyPrepareUI.this), paramAnonymousView, ah.fXi(), (String)localObject, ah.ID((String)localObject), com.tencent.mm.model.z.bAM(), com.tencent.mm.model.z.bAO(), SnsLuckyMoneyPrepareUI.f(SnsLuckyMoneyPrepareUI.this), "");; paramAnonymousView = new bc(i, l1, l2, SnsLuckyMoneyPrepareUI.a(SnsLuckyMoneyPrepareUI.this), paramAnonymousView, ah.fXi(), null, null, com.tencent.mm.model.z.bAM(), com.tencent.mm.model.z.bAO(), SnsLuckyMoneyPrepareUI.f(SnsLuckyMoneyPrepareUI.this), ""))
            {
              SnsLuckyMoneyPrepareUI.this.doSceneProgress(paramAnonymousView, false);
              if (SnsLuckyMoneyPrepareUI.this.tipDialog == null) {
                break label431;
              }
              SnsLuckyMoneyPrepareUI.this.tipDialog.show();
              break;
              l1 = com.tencent.mm.wallet_core.ui.i.Y(i * d);
              l2 = com.tencent.mm.wallet_core.ui.i.Y(d);
              com.tencent.mm.kernel.h.baF();
              com.tencent.mm.kernel.h.baE().ban().B(356353, Integer.valueOf(i));
              break label202;
            }
            label431:
            SnsLuckyMoneyPrepareUI.this.tipDialog = l.a(SnsLuckyMoneyPrepareUI.this.getContext(), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
              {
                AppMethodBeat.i(65380);
                if ((SnsLuckyMoneyPrepareUI.this.tipDialog != null) && (SnsLuckyMoneyPrepareUI.this.tipDialog.isShowing())) {
                  SnsLuckyMoneyPrepareUI.this.tipDialog.hide();
                }
                if ((SnsLuckyMoneyPrepareUI.g(SnsLuckyMoneyPrepareUI.this).getVisibility() == 8) || (SnsLuckyMoneyPrepareUI.h(SnsLuckyMoneyPrepareUI.this).getVisibility() == 4))
                {
                  Log.i("MicroMsg.LuckyMoneyPrepareUI", "usr cancel, & visibility not visiable, so finish");
                  SnsLuckyMoneyPrepareUI.this.finish();
                }
                SnsLuckyMoneyPrepareUI.this.KzD.forceCancel();
                AppMethodBeat.o(65380);
              }
            });
          }
        }
      });
      this.xcT.setText(com.tencent.mm.wallet_core.ui.i.X(0.0D));
      this.Knz.a(this.Knq);
      this.Knz.a(this.KvU);
      this.Knz.a(this.Kns);
      localObject1 = (TextView)findViewById(a.f.lucky_money_prepare_error_tips);
      this.Knz.A((TextView)localObject1);
      if ((this.Kwa) && (this.mType == 1))
      {
        localObject1 = (TextView)findViewById(a.f.lucky_money_prepare_num_tips);
        ((TextView)localObject1).setText(getString(a.i.lucky_money_num_group_tips, new Object[] { Integer.valueOf(getIntent().getIntExtra("key_chatroom_num", 8)) }));
        ((TextView)localObject1).setVisibility(0);
      }
      this.qaM = new MTimerHandler(new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(65382);
          int i;
          double d2;
          if ((SnsLuckyMoneyPrepareUI.this.KvU.fWv() != 3) && (SnsLuckyMoneyPrepareUI.this.Knq.fWv() != 3))
          {
            i = SnsLuckyMoneyPrepareUI.this.Knq.getInput();
            d2 = SnsLuckyMoneyPrepareUI.this.KvU.getInput();
            d1 = d2;
            if (SnsLuckyMoneyPrepareUI.a(SnsLuckyMoneyPrepareUI.this) != 0) {}
          }
          for (double d1 = d2 * i;; d1 = 0.0D)
          {
            if ((d1 == 0.0D) || (d1 > SnsLuckyMoneyPrepareUI.b(SnsLuckyMoneyPrepareUI.this).Kme) || (SnsLuckyMoneyPrepareUI.i(SnsLuckyMoneyPrepareUI.this).fYt()))
            {
              SnsLuckyMoneyPrepareUI.this.Knt.setClickable(false);
              SnsLuckyMoneyPrepareUI.this.Knt.setEnabled(false);
            }
            for (;;)
            {
              Log.i("MicroMsg.LuckyMoneyPrepareUI", "onTimeExpired & check: amount=" + d1 + ", hasErr=" + SnsLuckyMoneyPrepareUI.i(SnsLuckyMoneyPrepareUI.this).fYt());
              SnsLuckyMoneyPrepareUI.j(SnsLuckyMoneyPrepareUI.this).stopped();
              AppMethodBeat.o(65382);
              return false;
              SnsLuckyMoneyPrepareUI.this.Knt.setClickable(true);
              SnsLuckyMoneyPrepareUI.this.Knt.setEnabled(true);
            }
          }
        }
      }, false);
      if (this.pLK != null) {
        this.pLK.setOnTouchListener(new SnsLuckyMoneyPrepareUI.17(this));
      }
      this.KvU.setType(this.mType);
      if ((!this.Kwa) || (getIntent().getIntExtra("key_chatroom_num", 0) != 0)) {
        break label1111;
      }
      this.KvU.requestFocus();
      AppMethodBeat.o(65389);
      return;
      this.KvU.setTitle(getString(a.i.lucky_money_unit_amount_title));
      this.KvU.setShowGroupIcon(false);
      break;
      label1004:
      this.KvU.setMaxAmount(this.KmF.Kmc);
      break label415;
      label1021:
      this.Knq.setNum("");
      break label460;
      label1034:
      this.Knq.setVisibility(8);
      continue;
      label1046:
      if (this.mType == 1)
      {
        this.tHK.setText(this.KmF.KrB);
        this.tHK.setVisibility(0);
      }
      else if (this.mType == 0)
      {
        this.tHK.setText(this.KmF.KrC);
        this.tHK.setVisibility(0);
      }
    }
    label1111:
    this.Knq.requestFocus();
    AppMethodBeat.o(65389);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(65393);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(65393);
      return;
      if (paramInt2 == -1)
      {
        com.tencent.mm.plugin.report.service.h.OAn.b(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(fXD()), Integer.valueOf(5) });
        Object localObject1 = getIntent().getStringExtra("key_username");
        if ((this.Kwa) && (!Util.isNullOrNil((String)localObject1)))
        {
          k.cZ(this, getString(a.i.has_send));
          Object localObject2 = XmlParser.parseXml(this.Kwb, "msg", null);
          if (localObject2 == null)
          {
            Log.e("MicroMsg.LuckyMoneyPrepareUI", "luckymoneyPrepareUI onActivityResult values is null");
            finish();
            AppMethodBeat.o(65393);
            return;
          }
          localObject2 = (String)((Map)localObject2).get(".msg.appmsg.wcpayinfo.paymsgid");
          if (com.tencent.mm.plugin.luckymoney.app.a.fWk().fWp().aKz((String)localObject2))
          {
            Log.i("MicroMsg.LuckyMoneyPrepareUI", "insert a local msg for luckymoney");
            if (!ah.an(this.Kwb, (String)localObject1, 1))
            {
              Log.e("MicroMsg.LuckyMoneyPrepareUI", "LuckyMoneyUtil.sendLocalMsg fail!");
              com.tencent.mm.plugin.luckymoney.app.a.fWk().fWp().aKA((String)localObject2);
            }
          }
          for (;;)
          {
            finish();
            break;
            Log.e("MicroMsg.LuckyMoneyPrepareUI", "it is a duplicate msg");
          }
        }
        hideActionBar();
        new MMHandler().postDelayed(new SnsLuckyMoneyPrepareUI.7(this), 200L);
        this.xXJ.setOnClickListener(new SnsLuckyMoneyPrepareUI.8(this));
        ((ImageView)findViewById(a.f.lucky_money_prepare_close_btn)).setOnClickListener(new SnsLuckyMoneyPrepareUI.9(this));
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
          ((Intent)localObject1).putExtra("key_type", 1);
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject1);
          com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(65388);
    super.onCreate(paramBundle);
    this.mType = getIntent().getIntExtra("key_type", 1);
    this.Krb = getIntent().getIntExtra("key_way", 3);
    if (getIntent().getIntExtra("key_from", 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.Kwa = bool;
      this.mChannel = getIntent().getIntExtra("pay_channel", -1);
      doSceneProgress(new as("v1.0", 0), false);
      com.tencent.mm.plugin.luckymoney.app.a.fWk();
      this.KmF = com.tencent.mm.plugin.luckymoney.app.a.fWl().fWW();
      Log.d("MicroMsg.LuckyMoneyPrepareUI", "type=" + this.mType + ", fromAppPanel=" + this.Kwa + ", config " + this.KmF);
      initView();
      com.tencent.mm.plugin.report.service.h.OAn.b(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(fXD()), Integer.valueOf(1) });
      AppMethodBeat.o(65388);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(65390);
    super.onDestroy();
    this.Knz.clear();
    this.qaM.stopped();
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    AppMethodBeat.o(65390);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(65395);
    if ((paramInt == 4) && (this.mKBLayout != null) && (this.mKBLayout.isShown()))
    {
      hideTenpayKB();
      AppMethodBeat.o(65395);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(65395);
    return bool;
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(65392);
    if ((paramp instanceof bc))
    {
      if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
        this.tipDialog.hide();
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (bc)paramp;
        this.KvZ = paramString.wYz;
        this.KvY = paramString.CAf;
        this.Kwb = paramString.KuM;
        paramp = new PayInfo();
        paramp.hAT = paramString.Hgk;
        paramp.hUR = 37;
        paramp.channel = this.mChannel;
        com.tencent.mm.pluginsdk.wallet.f.a(this, paramp, 1);
        AppMethodBeat.o(65392);
        return true;
      }
      if (paramInt2 == 401)
      {
        this.Knt.setEnabled(false);
        this.Knt.setClickable(false);
        this.qaM.startTimer(5000L);
        k.cZ(this, paramString);
        AppMethodBeat.o(65392);
        return true;
      }
      k.cZ(this, paramString);
      AppMethodBeat.o(65392);
      return true;
    }
    if ((paramp instanceof bh))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (this.Kwa)
        {
          k.cZ(this, getString(a.i.has_send));
          finish();
        }
        for (;;)
        {
          AppMethodBeat.o(65392);
          return true;
          hideActionBar();
          this.KvW.postDelayed(new SnsLuckyMoneyPrepareUI.2(this), 1000L);
        }
      }
      if (paramInt2 == 402)
      {
        k.b(getContext(), paramString, "", getString(a.i.lucky_money_send_list_title), getString(a.i.app_cancel), new SnsLuckyMoneyPrepareUI.3(this), new SnsLuckyMoneyPrepareUI.4(this));
        AppMethodBeat.o(65392);
        return true;
      }
    }
    else if ((paramp instanceof as))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (as)paramp;
        com.tencent.mm.plugin.luckymoney.app.a.fWk();
        this.KmF = com.tencent.mm.plugin.luckymoney.app.a.fWl().fWW();
        Log.d("MicroMsg.LuckyMoneyPrepareUI", "update config:" + this.KmF);
        if (this.mType != 1) {
          break label653;
        }
        this.KvU.setMaxAmount(this.KmF.Kme);
        this.KvU.setMinAmount(this.KmF.Kmd);
        this.Knq.setMaxNum(this.KmF.Kmb);
        if ((paramString.Kuo) && (this.Kwa))
        {
          paramp = (TextView)findViewById(a.f.lucky_money_prepare_has_tips);
          paramp.setOnClickListener(new SnsLuckyMoneyPrepareUI.5(this));
          com.tencent.mm.plugin.report.service.h.OAn.b(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(fXD()), Integer.valueOf(8) });
          paramp.setVisibility(0);
        }
        if (Util.isNullOrNil(paramString.pHt)) {
          break label670;
        }
        Log.i("MicroMsg.LuckyMoneyPrepareUI", "Put notice :" + paramString.pHt);
        this.Knx.setText(paramString.pHt);
        if (!Util.isNullOrNil(paramString.Kuq)) {
          this.Knx.setOnClickListener(new SnsLuckyMoneyPrepareUI.6(this, paramString));
        }
        this.Knx.setVisibility(0);
      }
      for (;;)
      {
        paramp = new i.c();
        paramp.textColor = getResources().getColor(a.c.wallet_link_color);
        com.tencent.mm.plugin.luckymoney.ui.i.a(this, this.KvX, paramString.Kus, paramp);
        AppMethodBeat.o(65392);
        return true;
        label653:
        this.KvU.setMaxAmount(this.KmF.Kmc);
        break;
        label670:
        this.Knx.setVisibility(8);
      }
    }
    AppMethodBeat.o(65392);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI
 * JD-Core Version:    0.7.0.1
 */