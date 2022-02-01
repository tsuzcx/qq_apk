package com.tencent.mm.plugin.luckymoney.sns;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.BounceInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.luckymoney.model.aa;
import com.tencent.mm.plugin.luckymoney.model.ag;
import com.tencent.mm.plugin.luckymoney.model.ar;
import com.tencent.mm.plugin.luckymoney.model.bb;
import com.tencent.mm.plugin.luckymoney.model.bg;
import com.tencent.mm.plugin.luckymoney.model.o;
import com.tencent.mm.plugin.luckymoney.model.p;
import com.tencent.mm.plugin.luckymoney.model.x;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyCanShareListUI;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyIndexUI;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMoneyInputView;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMyRecordUI;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNumInputView;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyTextInputView;
import com.tencent.mm.plugin.luckymoney.ui.c;
import com.tencent.mm.plugin.luckymoney.ui.i.c;
import com.tencent.mm.plugin.wallet_core.ui.m;
import com.tencent.mm.plugin.wallet_core.ui.m.a;
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
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.wallet_core.ui.g;
import com.tenpay.android.wechat.MyKeyboardWindow;
import java.util.Map;

@com.tencent.mm.ui.base.a(19)
public class SnsLuckyMoneyPrepareUI
  extends LuckyMoneyBaseUI
  implements com.tencent.mm.plugin.luckymoney.ui.h
{
  private static final String EuI;
  protected LuckyMoneyMoneyInputView ECQ;
  private View ECR;
  private View ECS;
  private ViewGroup ECT;
  private String ECU;
  private int ECV;
  private boolean ECW;
  private String ECX;
  private o EtY;
  protected LuckyMoneyNumInputView EuJ;
  protected LuckyMoneyTextInputView EuL;
  protected Button EuM;
  private TextView EuQ;
  private c EuS;
  private int Eyo;
  private int mChannel;
  protected View mKBLayout;
  protected MyKeyboardWindow mKeyboard;
  private ScrollView mPe;
  private com.tencent.mm.wallet_core.ui.a mTenpayKBStateListener;
  private int mType;
  private MTimerHandler ndv;
  private TextView qCM;
  protected TextView tZC;
  protected Dialog tipDialog;
  protected Button uOZ;
  
  static
  {
    AppMethodBeat.i(196579);
    EuI = "https://" + WeChatHosts.domainString(a.i.host_kf_qq_com) + "/touch/product/wechathongbao_platform_app.html?scene_id=kf7";
    AppMethodBeat.o(196579);
  }
  
  public SnsLuckyMoneyPrepareUI()
  {
    AppMethodBeat.i(65387);
    this.EuJ = null;
    this.ECQ = null;
    this.EuL = null;
    this.tZC = null;
    this.EuM = null;
    this.uOZ = null;
    this.tipDialog = null;
    this.EuS = new c();
    this.ndv = null;
    AppMethodBeat.o(65387);
  }
  
  private int eOZ()
  {
    AppMethodBeat.i(65398);
    if (this.ECW)
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
  
  protected final void ao(View paramView, final int paramInt)
  {
    AppMethodBeat.i(65394);
    this.mKeyboard = ((MyKeyboardWindow)findViewById(a.f.tenpay_num_keyboard));
    this.mKBLayout = findViewById(a.f.tenpay_keyboard_layout);
    View localView = findViewById(a.f.tenpay_push_down);
    final EditText localEditText = (EditText)paramView.findViewById(a.f.lucky_money_et);
    if ((this.mKeyboard == null) || (localEditText == null) || (this.mKBLayout == null))
    {
      AppMethodBeat.o(65394);
      return;
    }
    g.setNoSystemInputOnEditText(localEditText);
    localEditText.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public final void onFocusChange(final View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(65374);
        if ((paramAnonymousView.isFocused()) && (!this.val$isShowSysKB))
        {
          ((InputMethodManager)SnsLuckyMoneyPrepareUI.this.getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramAnonymousView.getWindowToken(), 0);
          new MMHandler().postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(65372);
              if ((!SnsLuckyMoneyPrepareUI.this.mKBLayout.isShown()) && (paramAnonymousView.isShown())) {
                SnsLuckyMoneyPrepareUI.k(SnsLuckyMoneyPrepareUI.this);
              }
              SnsLuckyMoneyPrepareUI.b(SnsLuckyMoneyPrepareUI.this, SnsLuckyMoneyPrepareUI.10.this.val$editMode);
              SnsLuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText)paramAnonymousView);
              ((InputMethodManager)SnsLuckyMoneyPrepareUI.this.getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramAnonymousView.getWindowToken(), 0);
              AppMethodBeat.o(65372);
            }
          }, 300L);
          AppMethodBeat.o(65374);
          return;
        }
        new MMHandler().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(65373);
            SnsLuckyMoneyPrepareUI.this.hideTenpayKB();
            ((InputMethodManager)SnsLuckyMoneyPrepareUI.this.getContext().getSystemService("input_method")).showSoftInput(SnsLuckyMoneyPrepareUI.10.this.val$hintTv, 0);
            AppMethodBeat.o(65373);
          }
        }, 200L);
        AppMethodBeat.o(65374);
      }
    });
    localEditText.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(65376);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if ((!SnsLuckyMoneyPrepareUI.this.mKBLayout.isShown()) && (!this.val$isShowSysKB))
        {
          SnsLuckyMoneyPrepareUI.k(SnsLuckyMoneyPrepareUI.this);
          SnsLuckyMoneyPrepareUI.b(SnsLuckyMoneyPrepareUI.this, paramInt);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(65376);
          return;
          if (this.val$isShowSysKB)
          {
            SnsLuckyMoneyPrepareUI.this.hideTenpayKB();
            ((InputMethodManager)SnsLuckyMoneyPrepareUI.this.getContext().getSystemService("input_method")).showSoftInput(localEditText, 0);
          }
        }
      }
    });
    paramView = (TextView)paramView.findViewById(a.f.lucky_money_amount_unit_title);
    if (paramView != null) {
      paramView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(65377);
          b localb = new b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if ((!SnsLuckyMoneyPrepareUI.this.mKBLayout.isShown()) && (!this.val$isShowSysKB))
          {
            SnsLuckyMoneyPrepareUI.k(SnsLuckyMoneyPrepareUI.this);
            SnsLuckyMoneyPrepareUI.b(SnsLuckyMoneyPrepareUI.this, paramInt);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(65377);
            return;
            if (this.val$isShowSysKB)
            {
              SnsLuckyMoneyPrepareUI.this.hideTenpayKB();
              ((InputMethodManager)SnsLuckyMoneyPrepareUI.this.getContext().getSystemService("input_method")).showSoftInput(localEditText, 0);
            }
          }
        }
      });
    }
    localView.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(65378);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        SnsLuckyMoneyPrepareUI.this.hideTenpayKB();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(65378);
      }
    });
    AppMethodBeat.o(65394);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(65391);
    if ((paramKeyEvent.getKeyCode() == 4) && (this.ECR.getVisibility() == 0))
    {
      this.ECR.setVisibility(8);
      ePA();
      AppMethodBeat.o(65391);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(65391);
    return bool;
  }
  
  public final void eOd()
  {
    AppMethodBeat.i(65397);
    com.tencent.mm.plugin.luckymoney.b.a.eNR();
    this.EtY = com.tencent.mm.plugin.luckymoney.b.a.eNS().eOz();
    int i;
    double d2;
    double d1;
    if ((this.ECQ.eOc() != 3) && (this.EuJ.eOc() != 3))
    {
      i = this.EuJ.getInput();
      d2 = this.ECQ.getInput();
      if (this.mType == 0)
      {
        d2 *= i;
        d1 = this.ECQ.getInput();
      }
    }
    for (;;)
    {
      if (this.EuS.ePM())
      {
        this.EuM.setClickable(false);
        this.EuM.setEnabled(false);
        this.tZC.setText(g.F(d2));
        AppMethodBeat.o(65397);
        return;
        if (i > 0) {
          d1 = this.ECQ.getInput() / i;
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
            this.EuM.setClickable(false);
            this.EuM.setEnabled(false);
            break;
            if ((d2 > this.EtY.Etx) && (this.EtY.Etx > 0.0D))
            {
              this.EuS.amo(getString(a.i.lucky_money_total_amount_max_limit_tips, new Object[] { Math.round(this.EtY.Etx), Util.nullAs(this.EtY.EtA, "") }));
              i = 1;
              continue;
            }
            if (d1 <= 0.0D) {
              break label650;
            }
            if (this.mType == 0)
            {
              if ((d1 <= this.EtY.Etv) || (this.EtY.Etv <= 0.0D)) {
                break label644;
              }
              this.EuS.amo(getString(a.i.lucky_money_per_amount_max_limit_tips, new Object[] { Math.round(this.EtY.Etv), Util.nullAs(this.EtY.EtA, "") }));
              i = 1;
            }
          }
          for (;;)
          {
            if (i == 0)
            {
              if (this.mType == 0)
              {
                if (d1 >= this.EtY.Etw) {
                  break label641;
                }
                this.EuS.amo(getString(a.i.lucky_money_per_amount_min_limit_tips, new Object[] { g.formatMoney2f(this.EtY.Etw), Util.nullAs(this.EtY.EtA, "") }));
                i = 1;
                break label159;
                if ((d1 <= this.EtY.Ety) || (this.EtY.Ety <= 0.0D)) {
                  break label644;
                }
                this.EuS.amo(getString(a.i.lucky_money_per_amount_max_limit_tips, new Object[] { Math.round(this.EtY.Ety), Util.nullAs(this.EtY.EtA, "") }));
                this.EuJ.onError();
                this.ECQ.onError();
                i = 1;
                continue;
              }
              if (d1 < 0.01D)
              {
                this.EuS.amo(getString(a.i.lucky_money_per_amount_min_limit_tips, new Object[] { "0.01", Util.nullAs(this.EtY.EtA, "") }));
                this.EuJ.onError();
                this.ECQ.onError();
                i = 1;
                break label159;
                this.EuM.setClickable(true);
                this.EuM.setEnabled(true);
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
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(65363);
        SnsLuckyMoneyPrepareUI.this.finish();
        AppMethodBeat.o(65363);
        return true;
      }
    });
    this.ECR = findViewById(a.f.lucky_money_prepare_ready_ll);
    this.ECS = findViewById(a.f.lucky_money_prepare_sent_area);
    this.uOZ = ((Button)findViewById(a.f.lucky_money_prepare_send_btn));
    this.EuL = ((LuckyMoneyTextInputView)findViewById(a.f.lucky_money_wish_et));
    this.EuL.setHintText(getString(a.i.lucky_money_default_wish));
    this.EuM = ((Button)findViewById(a.f.lucky_money_prepare_btn));
    this.mKeyboard = ((MyKeyboardWindow)findViewById(a.f.tenpay_num_keyboard));
    this.mKBLayout = findViewById(a.f.tenpay_keyboard_layout);
    this.qCM = ((TextView)findViewById(a.f.lucky_money_prepare_amount_tips));
    this.EuJ = ((LuckyMoneyNumInputView)findViewById(a.f.lucky_money_num_et));
    this.ECQ = ((LuckyMoneyMoneyInputView)findViewById(a.f.lucky_money_amount_et));
    this.tZC = ((TextView)findViewById(a.f.lucky_money_prepare_total_amount));
    this.ECT = ((ViewGroup)findViewById(a.f.lucky_money_prepare_opertaion));
    this.mPe = ((ScrollView)findViewById(a.f.lucky_money_sv));
    this.EuQ = ((TextView)findViewById(a.f.lucky_money_prepare_notice_tips));
    Object localObject1;
    if (this.mType == 1)
    {
      this.ECQ.setTitle(getString(a.i.lucky_money_total_amount_title));
      this.ECQ.setShowGroupIcon(true);
      this.ECQ.setOnInputValidChangerListener(this);
      this.EuJ.setOnInputValidChangerListener(this);
      this.EuL.setOnInputValidChangerListener(this);
      localObject1 = (EditText)this.ECQ.findViewById(a.f.lucky_money_et);
      Object localObject2 = (EditText)this.EuJ.findViewById(a.f.lucky_money_et);
      g.setNoSystemInputOnEditText((EditText)localObject1);
      ((InputMethodManager)getContext().getSystemService("input_method")).showSoftInput((View)localObject1, 0);
      ((EditText)localObject1).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(65384);
          b localb = new b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          this.val$hintTv.setOnClickListener(null);
          this.EuU.setOnClickListener(null);
          SnsLuckyMoneyPrepareUI.this.ao(SnsLuckyMoneyPrepareUI.this.ECQ, 2);
          SnsLuckyMoneyPrepareUI.this.ao(SnsLuckyMoneyPrepareUI.this.EuJ, 0);
          SnsLuckyMoneyPrepareUI.this.mKeyboard.setXMode(2);
          SnsLuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText)paramAnonymousView);
          SnsLuckyMoneyPrepareUI.k(SnsLuckyMoneyPrepareUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(65384);
        }
      });
      Object localObject3 = (TextView)this.ECQ.findViewById(a.f.lucky_money_amount_unit_title);
      if (localObject3 != null) {
        ((TextView)localObject3).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(65385);
            b localb = new b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            this.val$hintTv.setOnClickListener(null);
            this.EuU.setOnClickListener(null);
            SnsLuckyMoneyPrepareUI.this.ao(SnsLuckyMoneyPrepareUI.this.ECQ, 2);
            SnsLuckyMoneyPrepareUI.this.ao(SnsLuckyMoneyPrepareUI.this.EuJ, 0);
            SnsLuckyMoneyPrepareUI.this.mKeyboard.setXMode(2);
            SnsLuckyMoneyPrepareUI.k(SnsLuckyMoneyPrepareUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(65385);
          }
        });
      }
      g.setNoSystemInputOnEditText((EditText)localObject2);
      ((InputMethodManager)getContext().getSystemService("input_method")).showSoftInput((View)localObject2, 0);
      ((EditText)localObject2).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(65386);
          b localb = new b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          this.val$hintTv.setOnClickListener(null);
          this.EuU.setOnClickListener(null);
          SnsLuckyMoneyPrepareUI.this.ao(SnsLuckyMoneyPrepareUI.this.ECQ, 2);
          SnsLuckyMoneyPrepareUI.this.ao(SnsLuckyMoneyPrepareUI.this.EuJ, 0);
          SnsLuckyMoneyPrepareUI.this.mKeyboard.setXMode(0);
          SnsLuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText)paramAnonymousView);
          SnsLuckyMoneyPrepareUI.k(SnsLuckyMoneyPrepareUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(65386);
        }
      });
      if (this.EtY != null)
      {
        if (this.mType != 1) {
          break label1036;
        }
        this.ECQ.setMaxAmount(this.EtY.Etx);
        label447:
        this.ECQ.setMinAmount(this.EtY.Etw);
      }
      if ((!this.ECW) || (getIntent().getIntExtra("key_chatroom_num", 0) > 1)) {
        break label1053;
      }
      this.EuJ.setNum("1");
      label492:
      this.EuJ.setMaxNum(this.EtY.Etu);
      this.EuJ.setMinNum(1);
      Log.d("MicroMsg.LuckyMoneyPrepareUI", "init num=" + this.EuJ.getInput());
      this.ECQ.setMaxLen(12);
      if (!this.ECW) {
        break label1078;
      }
      if (getIntent().getIntExtra("key_chatroom_num", 0) <= 0) {
        break label1066;
      }
      Object localObject4 = getString(a.i.lucky_money_group_tips_random_prefix);
      Object localObject5 = getString(a.i.lucky_money_group_tips_change_to_fixed);
      localObject1 = getString(a.i.lucky_money_group_tips_fixed_prefix);
      localObject2 = getString(a.i.lucky_money_group_tips_change_to_random);
      localObject3 = new SpannableString((String)localObject4 + (String)localObject5);
      m localm = new m(this);
      ((SpannableString)localObject3).setSpan(localm, ((String)localObject4).length(), ((String)localObject4).length() + ((String)localObject5).length(), 33);
      localObject4 = new SpannableString((String)localObject1 + (String)localObject2);
      localObject5 = new m(this);
      ((SpannableString)localObject4).setSpan(localObject5, ((String)localObject1).length(), ((String)localObject1).length() + ((String)localObject2).length(), 33);
      localm.OYN = new m.a()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(65375);
          int i = SnsLuckyMoneyPrepareUI.this.EuJ.getInput();
          double d = SnsLuckyMoneyPrepareUI.this.ECQ.getInput();
          SnsLuckyMoneyPrepareUI.a(SnsLuckyMoneyPrepareUI.this, 0);
          SnsLuckyMoneyPrepareUI.this.ECQ.setType(SnsLuckyMoneyPrepareUI.a(SnsLuckyMoneyPrepareUI.this));
          SnsLuckyMoneyPrepareUI.this.ECQ.setShowGroupIcon(false);
          SnsLuckyMoneyPrepareUI.this.ECQ.setTitle(SnsLuckyMoneyPrepareUI.this.getString(a.i.lucky_money_unit_amount_title));
          if ((d > 0.0D) && (i > 0)) {
            SnsLuckyMoneyPrepareUI.this.ECQ.setAmount(g.formatMoney2f(d / i));
          }
          SnsLuckyMoneyPrepareUI.this.ECQ.setMaxAmount(SnsLuckyMoneyPrepareUI.b(SnsLuckyMoneyPrepareUI.this).Etv);
          SnsLuckyMoneyPrepareUI.c(SnsLuckyMoneyPrepareUI.this).setText(this.EuY);
          com.tencent.mm.plugin.report.service.h.IzE.a(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(SnsLuckyMoneyPrepareUI.d(SnsLuckyMoneyPrepareUI.this)), Integer.valueOf(3) });
          AppMethodBeat.o(65375);
        }
      };
      ((m)localObject5).OYN = new m.a()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(65379);
          int i = SnsLuckyMoneyPrepareUI.this.EuJ.getInput();
          double d = SnsLuckyMoneyPrepareUI.this.ECQ.getInput();
          SnsLuckyMoneyPrepareUI.a(SnsLuckyMoneyPrepareUI.this, 1);
          SnsLuckyMoneyPrepareUI.this.ECQ.setType(SnsLuckyMoneyPrepareUI.a(SnsLuckyMoneyPrepareUI.this));
          SnsLuckyMoneyPrepareUI.this.ECQ.setTitle(SnsLuckyMoneyPrepareUI.this.getString(a.i.lucky_money_total_amount_title));
          SnsLuckyMoneyPrepareUI.this.ECQ.setShowGroupIcon(true);
          if ((d > 0.0D) && (i > 0)) {
            SnsLuckyMoneyPrepareUI.this.ECQ.setAmount(g.formatMoney2f(d * i));
          }
          SnsLuckyMoneyPrepareUI.this.ECQ.setMaxAmount(SnsLuckyMoneyPrepareUI.b(SnsLuckyMoneyPrepareUI.this).Etx);
          SnsLuckyMoneyPrepareUI.c(SnsLuckyMoneyPrepareUI.this).setText(this.EuZ);
          com.tencent.mm.plugin.report.service.h.IzE.a(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(SnsLuckyMoneyPrepareUI.d(SnsLuckyMoneyPrepareUI.this)), Integer.valueOf(2) });
          AppMethodBeat.o(65379);
        }
      };
      this.qCM.setMovementMethod(LinkMovementMethod.getInstance());
      this.qCM.setText((CharSequence)localObject3);
      this.qCM.setVisibility(0);
    }
    for (;;)
    {
      this.EuM.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(65381);
          Object localObject = new b();
          ((b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
          com.tencent.mm.plugin.report.service.h.IzE.a(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(SnsLuckyMoneyPrepareUI.d(SnsLuckyMoneyPrepareUI.this)), Integer.valueOf(4) });
          if (SnsLuckyMoneyPrepareUI.this.ECQ.eOc() != 0) {
            w.makeText(SnsLuckyMoneyPrepareUI.this.getContext(), a.i.wallet_balance_save_input_invalid, 0).show();
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(65381);
            return;
            int i = SnsLuckyMoneyPrepareUI.this.EuJ.getInput();
            double d = SnsLuckyMoneyPrepareUI.this.ECQ.getInput();
            long l2 = 0L;
            long l1;
            if (SnsLuckyMoneyPrepareUI.a(SnsLuckyMoneyPrepareUI.this) == 1)
            {
              l1 = g.G(d);
              com.tencent.mm.kernel.h.aHH();
              com.tencent.mm.kernel.h.aHG().aHp().i(356354, Integer.valueOf(i));
              label202:
              localObject = SnsLuckyMoneyPrepareUI.this.EuL.getInput();
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
            for (paramAnonymousView = new bb(i, l1, l2, SnsLuckyMoneyPrepareUI.a(SnsLuckyMoneyPrepareUI.this), paramAnonymousView, ag.eOH(), (String)localObject, ag.PI((String)localObject), z.bcZ(), z.bdb(), SnsLuckyMoneyPrepareUI.f(SnsLuckyMoneyPrepareUI.this), "");; paramAnonymousView = new bb(i, l1, l2, SnsLuckyMoneyPrepareUI.a(SnsLuckyMoneyPrepareUI.this), paramAnonymousView, ag.eOH(), null, null, z.bcZ(), z.bdb(), SnsLuckyMoneyPrepareUI.f(SnsLuckyMoneyPrepareUI.this), ""))
            {
              SnsLuckyMoneyPrepareUI.this.doSceneProgress(paramAnonymousView, false);
              if (SnsLuckyMoneyPrepareUI.this.tipDialog == null) {
                break label431;
              }
              SnsLuckyMoneyPrepareUI.this.tipDialog.show();
              break;
              l1 = g.G(i * d);
              l2 = g.G(d);
              com.tencent.mm.kernel.h.aHH();
              com.tencent.mm.kernel.h.aHG().aHp().i(356353, Integer.valueOf(i));
              break label202;
            }
            label431:
            SnsLuckyMoneyPrepareUI.this.tipDialog = com.tencent.mm.wallet_core.ui.i.a(SnsLuckyMoneyPrepareUI.this.getContext(), true, new DialogInterface.OnCancelListener()
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
                SnsLuckyMoneyPrepareUI.this.EGu.forceCancel();
                AppMethodBeat.o(65380);
              }
            });
          }
        }
      });
      this.tZC.setText(g.F(0.0D));
      this.EuS.a(this.EuJ);
      this.EuS.a(this.ECQ);
      this.EuS.a(this.EuL);
      localObject1 = (TextView)findViewById(a.f.lucky_money_prepare_error_tips);
      this.EuS.z((TextView)localObject1);
      if ((this.ECW) && (this.mType == 1))
      {
        localObject1 = (TextView)findViewById(a.f.lucky_money_prepare_num_tips);
        ((TextView)localObject1).setText(getString(a.i.lucky_money_num_group_tips, new Object[] { Integer.valueOf(getIntent().getIntExtra("key_chatroom_num", 8)) }));
        ((TextView)localObject1).setVisibility(0);
      }
      this.ndv = new MTimerHandler(new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(65382);
          int i;
          double d2;
          if ((SnsLuckyMoneyPrepareUI.this.ECQ.eOc() != 3) && (SnsLuckyMoneyPrepareUI.this.EuJ.eOc() != 3))
          {
            i = SnsLuckyMoneyPrepareUI.this.EuJ.getInput();
            d2 = SnsLuckyMoneyPrepareUI.this.ECQ.getInput();
            d1 = d2;
            if (SnsLuckyMoneyPrepareUI.a(SnsLuckyMoneyPrepareUI.this) != 0) {}
          }
          for (double d1 = d2 * i;; d1 = 0.0D)
          {
            if ((d1 == 0.0D) || (d1 > SnsLuckyMoneyPrepareUI.b(SnsLuckyMoneyPrepareUI.this).Etx) || (SnsLuckyMoneyPrepareUI.i(SnsLuckyMoneyPrepareUI.this).ePN()))
            {
              SnsLuckyMoneyPrepareUI.this.EuM.setClickable(false);
              SnsLuckyMoneyPrepareUI.this.EuM.setEnabled(false);
            }
            for (;;)
            {
              Log.i("MicroMsg.LuckyMoneyPrepareUI", "onTimeExpired & check: amount=" + d1 + ", hasErr=" + SnsLuckyMoneyPrepareUI.i(SnsLuckyMoneyPrepareUI.this).ePN());
              SnsLuckyMoneyPrepareUI.j(SnsLuckyMoneyPrepareUI.this).stopped();
              AppMethodBeat.o(65382);
              return false;
              SnsLuckyMoneyPrepareUI.this.EuM.setClickable(true);
              SnsLuckyMoneyPrepareUI.this.EuM.setEnabled(true);
            }
          }
        }
      }, false);
      if (this.mPe != null) {
        this.mPe.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(65383);
            if (paramAnonymousMotionEvent.getAction() == 0)
            {
              SnsLuckyMoneyPrepareUI.this.hideTenpayKB();
              SnsLuckyMoneyPrepareUI.this.hideVKB();
            }
            AppMethodBeat.o(65383);
            return false;
          }
        });
      }
      this.ECQ.setType(this.mType);
      if ((!this.ECW) || (getIntent().getIntExtra("key_chatroom_num", 0) != 0)) {
        break label1143;
      }
      this.ECQ.requestFocus();
      AppMethodBeat.o(65389);
      return;
      this.ECQ.setTitle(getString(a.i.lucky_money_unit_amount_title));
      this.ECQ.setShowGroupIcon(false);
      break;
      label1036:
      this.ECQ.setMaxAmount(this.EtY.Etv);
      break label447;
      label1053:
      this.EuJ.setNum("");
      break label492;
      label1066:
      this.EuJ.setVisibility(8);
      continue;
      label1078:
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
    label1143:
    this.EuJ.requestFocus();
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
        com.tencent.mm.plugin.report.service.h.IzE.a(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(eOZ()), Integer.valueOf(5) });
        Object localObject1 = getIntent().getStringExtra("key_username");
        if ((this.ECW) && (!Util.isNullOrNil((String)localObject1)))
        {
          com.tencent.mm.ui.base.h.cO(this, getString(a.i.has_send));
          Object localObject2 = XmlParser.parseXml(this.ECX, "msg", null);
          if (localObject2 == null)
          {
            Log.e("MicroMsg.LuckyMoneyPrepareUI", "luckymoneyPrepareUI onActivityResult values is null");
            finish();
            AppMethodBeat.o(65393);
            return;
          }
          localObject2 = (String)((Map)localObject2).get(".msg.appmsg.wcpayinfo.paymsgid");
          if (com.tencent.mm.plugin.luckymoney.b.a.eNR().eNW().aND((String)localObject2))
          {
            Log.i("MicroMsg.LuckyMoneyPrepareUI", "insert a local msg for luckymoney");
            if (!ag.ag(this.ECX, (String)localObject1, 1))
            {
              Log.e("MicroMsg.LuckyMoneyPrepareUI", "LuckyMoneyUtil.sendLocalMsg fail!");
              com.tencent.mm.plugin.luckymoney.b.a.eNR().eNW().aNE((String)localObject2);
            }
          }
          for (;;)
          {
            finish();
            break;
            Log.e("MicroMsg.LuckyMoneyPrepareUI", "it is a duplicate msg");
          }
        }
        ePB();
        new MMHandler().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(65368);
            SnsLuckyMoneyPrepareUI.l(SnsLuckyMoneyPrepareUI.this).setVisibility(0);
            ScaleAnimation localScaleAnimation = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.5F, 1, 0.5F);
            localScaleAnimation.setDuration(800L);
            localScaleAnimation.setStartOffset(200L);
            localScaleAnimation.setInterpolator(new BounceInterpolator());
            SnsLuckyMoneyPrepareUI.this.findViewById(a.f.lucky_money_prepare_ready_packet_ll).startAnimation(localScaleAnimation);
            AppMethodBeat.o(65368);
          }
        }, 200L);
        this.uOZ.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(65370);
            b localb = new b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            com.tencent.mm.plugin.report.service.h.IzE.a(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(SnsLuckyMoneyPrepareUI.d(SnsLuckyMoneyPrepareUI.this)), Integer.valueOf(6) });
            ag.a(SnsLuckyMoneyPrepareUI.this, SnsLuckyMoneyPrepareUI.a(SnsLuckyMoneyPrepareUI.this), SnsLuckyMoneyPrepareUI.m(SnsLuckyMoneyPrepareUI.this), false);
            SnsLuckyMoneyPrepareUI.l(SnsLuckyMoneyPrepareUI.this).postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(65369);
                SnsLuckyMoneyPrepareUI.l(SnsLuckyMoneyPrepareUI.this).setVisibility(8);
                SnsLuckyMoneyPrepareUI.n(SnsLuckyMoneyPrepareUI.this);
                AppMethodBeat.o(65369);
              }
            }, 100L);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(65370);
          }
        });
        ((ImageView)findViewById(a.f.lucky_money_prepare_close_btn)).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(65371);
            b localb = new b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            SnsLuckyMoneyPrepareUI.l(SnsLuckyMoneyPrepareUI.this).setVisibility(8);
            SnsLuckyMoneyPrepareUI.o(SnsLuckyMoneyPrepareUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(65371);
          }
        });
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
          ((Intent)localObject1).putExtra("key_type", 1);
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject1);
          com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0));
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
    this.Eyo = getIntent().getIntExtra("key_way", 3);
    if (getIntent().getIntExtra("key_from", 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.ECW = bool;
      this.mChannel = getIntent().getIntExtra("pay_channel", -1);
      doSceneProgress(new ar("v1.0", 0), false);
      com.tencent.mm.plugin.luckymoney.b.a.eNR();
      this.EtY = com.tencent.mm.plugin.luckymoney.b.a.eNS().eOz();
      Log.d("MicroMsg.LuckyMoneyPrepareUI", "type=" + this.mType + ", fromAppPanel=" + this.ECW + ", config " + this.EtY);
      initView();
      com.tencent.mm.plugin.report.service.h.IzE.a(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(eOZ()), Integer.valueOf(1) });
      AppMethodBeat.o(65388);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(65390);
    super.onDestroy();
    this.EuS.clear();
    this.ndv.stopped();
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
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, q paramq)
  {
    AppMethodBeat.i(65392);
    if ((paramq instanceof bb))
    {
      if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
        this.tipDialog.hide();
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (bb)paramq;
        this.ECV = paramString.tVd;
        this.ECU = paramString.ybP;
        this.ECX = paramString.EBL;
        paramq = new PayInfo();
        paramq.fwv = paramString.ByI;
        paramq.fOY = 37;
        paramq.channel = this.mChannel;
        com.tencent.mm.pluginsdk.wallet.f.a(this, paramq, 1);
        AppMethodBeat.o(65392);
        return true;
      }
      if (paramInt2 == 401)
      {
        this.EuM.setEnabled(false);
        this.EuM.setClickable(false);
        this.ndv.startTimer(5000L);
        com.tencent.mm.ui.base.h.cO(this, paramString);
        AppMethodBeat.o(65392);
        return true;
      }
      com.tencent.mm.ui.base.h.cO(this, paramString);
      AppMethodBeat.o(65392);
      return true;
    }
    if ((paramq instanceof bg))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (this.ECW)
        {
          com.tencent.mm.ui.base.h.cO(this, getString(a.i.has_send));
          finish();
        }
        for (;;)
        {
          AppMethodBeat.o(65392);
          return true;
          ePB();
          this.ECS.postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(65364);
              Object localObject = new Intent();
              ((Intent)localObject).setClass(SnsLuckyMoneyPrepareUI.this.getContext(), LuckyMoneyIndexUI.class);
              ((Intent)localObject).addFlags(67108864);
              AppCompatActivity localAppCompatActivity = SnsLuckyMoneyPrepareUI.this.getContext();
              localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
              com.tencent.mm.hellhoundlib.a.a.b(localAppCompatActivity, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$11", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              localAppCompatActivity.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
              com.tencent.mm.hellhoundlib.a.a.c(localAppCompatActivity, "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$11", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              SnsLuckyMoneyPrepareUI.this.finish();
              AppMethodBeat.o(65364);
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
            AppMethodBeat.i(65365);
            Object localObject = new Intent();
            ((Intent)localObject).setClass(SnsLuckyMoneyPrepareUI.this.getContext(), LuckyMoneyMyRecordUI.class);
            ((Intent)localObject).putExtra("key_type", 1);
            paramAnonymousDialogInterface = SnsLuckyMoneyPrepareUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
            com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$12", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousDialogInterface, "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$12", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(65365);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(65392);
        return true;
      }
    }
    else if ((paramq instanceof ar))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (ar)paramq;
        com.tencent.mm.plugin.luckymoney.b.a.eNR();
        this.EtY = com.tencent.mm.plugin.luckymoney.b.a.eNS().eOz();
        Log.d("MicroMsg.LuckyMoneyPrepareUI", "update config:" + this.EtY);
        if (this.mType != 1) {
          break label653;
        }
        this.ECQ.setMaxAmount(this.EtY.Etx);
        this.ECQ.setMinAmount(this.EtY.Etw);
        this.EuJ.setMaxNum(this.EtY.Etu);
        if ((paramString.EBq) && (this.ECW))
        {
          paramq = (TextView)findViewById(a.f.lucky_money_prepare_has_tips);
          paramq.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(65366);
              Object localObject = new b();
              ((b)localObject).bn(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
              com.tencent.mm.plugin.report.service.h.IzE.a(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(SnsLuckyMoneyPrepareUI.d(SnsLuckyMoneyPrepareUI.this)), Integer.valueOf(9) });
              localObject = new Intent();
              ((Intent)localObject).setClass(SnsLuckyMoneyPrepareUI.this.getContext(), LuckyMoneyCanShareListUI.class);
              paramAnonymousView = SnsLuckyMoneyPrepareUI.this;
              localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
              com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$14", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
              com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$14", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(65366);
            }
          });
          com.tencent.mm.plugin.report.service.h.IzE.a(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(eOZ()), Integer.valueOf(8) });
          paramq.setVisibility(0);
        }
        if (Util.isNullOrNil(paramString.mKL)) {
          break label670;
        }
        Log.i("MicroMsg.LuckyMoneyPrepareUI", "Put notice :" + paramString.mKL);
        this.EuQ.setText(paramString.mKL);
        if (!Util.isNullOrNil(paramString.EBs)) {
          this.EuQ.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(65367);
              b localb = new b();
              localb.bn(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
              g.p(SnsLuckyMoneyPrepareUI.this.getContext(), paramString.EBs, false);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(65367);
            }
          });
        }
        this.EuQ.setVisibility(0);
      }
      for (;;)
      {
        paramq = new i.c();
        paramq.textColor = getResources().getColor(a.c.wallet_link_color);
        com.tencent.mm.plugin.luckymoney.ui.i.a(this, this.ECT, paramString.EBu, paramq);
        AppMethodBeat.o(65392);
        return true;
        label653:
        this.ECQ.setMaxAmount(this.EtY.Etv);
        break;
        label670:
        this.EuQ.setVisibility(8);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI
 * JD-Core Version:    0.7.0.1
 */