package com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.luckymoney.appbrand.a.g;
import com.tencent.mm.plugin.luckymoney.appbrand.a.h.a;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.WxaLuckyMoneyBaseUI;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.WxaLuckyMoneyMoneyInputView;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNumInputView;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyTextInputView;
import com.tencent.mm.plugin.wallet_core.ui.l;
import com.tencent.mm.plugin.wallet_core.ui.l.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.picker.c.b;
import com.tencent.mm.ui.x;
import com.tencent.mm.wallet_core.ui.MMScrollView;
import com.tencent.mm.wallet_core.ui.f;
import com.tenpay.android.wechat.MyKeyboardWindow;
import java.util.ArrayList;

@com.tencent.mm.ui.base.a(19)
public class WxaLuckyMoneyPrepareUI
  extends WxaLuckyMoneyBaseUI
  implements c, com.tencent.mm.plugin.luckymoney.ui.h
{
  private static final String yQK;
  protected View mKBLayout;
  protected MyKeyboardWindow mKeyboard;
  private TextView nAB;
  private TextView qAC;
  private a yQJ;
  private LuckyMoneyNumInputView yQL;
  private WxaLuckyMoneyMoneyInputView yQM;
  private LuckyMoneyTextInputView yQN;
  private Button yQO;
  private LinearLayout yQP;
  private TextView yQQ;
  private MMScrollView yQR;
  private TextView yQS;
  private int yQT;
  private com.tencent.mm.plugin.luckymoney.ui.c yQU;
  private h.a yQc;
  
  static
  {
    AppMethodBeat.i(213264);
    yQK = "https://" + WeChatHosts.domainString(2131761715) + "/touch/scene_product.html?scene_id=kf7";
    AppMethodBeat.o(213264);
  }
  
  public WxaLuckyMoneyPrepareUI()
  {
    AppMethodBeat.i(64965);
    this.yQJ = null;
    this.yQc = h.a.yPE;
    this.yQL = null;
    this.yQM = null;
    this.yQN = null;
    this.qAC = null;
    this.yQO = null;
    this.yQT = 0;
    this.yQU = new com.tencent.mm.plugin.luckymoney.ui.c();
    AppMethodBeat.o(64965);
  }
  
  protected final void ak(final View paramView, final int paramInt)
  {
    AppMethodBeat.i(64971);
    this.mKeyboard = ((MyKeyboardWindow)findViewById(2131308962));
    this.mKBLayout = findViewById(2131308960);
    View localView = findViewById(2131308963);
    final EditText localEditText = (EditText)paramView.findViewById(2131304116);
    if ((this.mKeyboard == null) || (localEditText == null) || (this.mKBLayout == null))
    {
      AppMethodBeat.o(64971);
      return;
    }
    f.setNoSystemInputOnEditText(localEditText);
    localEditText.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public final void onFocusChange(final View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(64951);
        if ((paramAnonymousView.isFocused()) && (!this.val$isShowSysKB))
        {
          ((InputMethodManager)WxaLuckyMoneyPrepareUI.this.getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramAnonymousView.getWindowToken(), 0);
          new MMHandler().postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(64949);
              if ((!WxaLuckyMoneyPrepareUI.this.mKBLayout.isShown()) && (paramAnonymousView.isShown())) {
                WxaLuckyMoneyPrepareUI.this.mKBLayout.setVisibility(0);
              }
              WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this, WxaLuckyMoneyPrepareUI.6.this.val$editMode);
              WxaLuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText)paramAnonymousView);
              ((InputMethodManager)WxaLuckyMoneyPrepareUI.this.getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramAnonymousView.getWindowToken(), 0);
              AppMethodBeat.o(64949);
            }
          }, 300L);
          AppMethodBeat.o(64951);
          return;
        }
        new MMHandler().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(64950);
            WxaLuckyMoneyPrepareUI.this.hideTenpayKB();
            ((InputMethodManager)WxaLuckyMoneyPrepareUI.this.getContext().getSystemService("input_method")).showSoftInput(WxaLuckyMoneyPrepareUI.6.this.val$hintTv, 0);
            AppMethodBeat.o(64950);
          }
        }, 200L);
        AppMethodBeat.o(64951);
      }
    });
    localEditText.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(64952);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/appbrand/ui/prepare/WxaLuckyMoneyPrepareUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if ((!WxaLuckyMoneyPrepareUI.this.mKBLayout.isShown()) && (!this.val$isShowSysKB))
        {
          WxaLuckyMoneyPrepareUI.this.mKBLayout.setVisibility(0);
          WxaLuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText)paramAnonymousView);
          WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this, paramInt);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/appbrand/ui/prepare/WxaLuckyMoneyPrepareUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(64952);
          return;
          if (this.val$isShowSysKB)
          {
            WxaLuckyMoneyPrepareUI.this.mKBLayout.setVisibility(8);
            ((InputMethodManager)WxaLuckyMoneyPrepareUI.this.getContext().getSystemService("input_method")).showSoftInput(localEditText, 0);
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
          AppMethodBeat.i(64954);
          b localb = new b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/appbrand/ui/prepare/WxaLuckyMoneyPrepareUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if ((WxaLuckyMoneyPrepareUI.this.mKBLayout.isShown()) && (!this.val$isShowSysKB)) {
            if (WxaLuckyMoneyPrepareUI.this.mKeyboard != null) {
              WxaLuckyMoneyPrepareUI.this.mKeyboard.setInputEditText(localEditText);
            }
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/appbrand/ui/prepare/WxaLuckyMoneyPrepareUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(64954);
            return;
            if ((!WxaLuckyMoneyPrepareUI.this.mKBLayout.isShown()) && (!this.val$isShowSysKB))
            {
              ((InputMethodManager)WxaLuckyMoneyPrepareUI.this.getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramAnonymousView.getWindowToken(), 0);
              new MMHandler().postDelayed(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(64953);
                  WxaLuckyMoneyPrepareUI.this.mKBLayout.setVisibility(0);
                  WxaLuckyMoneyPrepareUI.8.this.val$parent.requestFocus();
                  if (WxaLuckyMoneyPrepareUI.this.mKeyboard != null) {
                    WxaLuckyMoneyPrepareUI.this.mKeyboard.setInputEditText(WxaLuckyMoneyPrepareUI.8.this.val$hintTv);
                  }
                  WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this, WxaLuckyMoneyPrepareUI.8.this.val$editMode);
                  AppMethodBeat.o(64953);
                }
              }, 200L);
            }
            else if (this.val$isShowSysKB)
            {
              WxaLuckyMoneyPrepareUI.this.mKBLayout.setVisibility(8);
              ((InputMethodManager)WxaLuckyMoneyPrepareUI.this.getContext().getSystemService("input_method")).showSoftInput(localEditText, 0);
            }
          }
        }
      });
    }
    localView.setOnClickListener(new WxaLuckyMoneyPrepareUI.9(this));
    AppMethodBeat.o(64971);
  }
  
  public final MMActivity eeF()
  {
    return this;
  }
  
  public final void eeG() {}
  
  public final void eeI()
  {
    AppMethodBeat.i(64974);
    double d4 = 0.0D;
    double d3 = 0.0D;
    double d2 = d3;
    double d1 = d4;
    int i;
    if (this.yQM.eeH() != 3)
    {
      d2 = d3;
      d1 = d4;
      if (this.yQL.eeH() != 3)
      {
        i = this.yQL.getInput();
        d4 = this.yQM.getInput();
        if (this.yQc != h.a.yPF) {
          break label164;
        }
        d1 = d4 * i;
        d2 = this.yQM.getInput();
      }
    }
    boolean bool1 = this.yQU.egj();
    Object localObject = g.yPu;
    if (bool1)
    {
      Log.i("MicroMsg.WxaLuckyMoneyPrepareUI", "has error");
      this.yQO.setClickable(false);
      this.yQO.setEnabled(false);
    }
    for (;;)
    {
      localObject = ((g)localObject).yPA;
      if (!Util.isNullOrNil((String)localObject)) {
        break label778;
      }
      this.qAC.setText(f.D(d1));
      AppMethodBeat.o(64974);
      return;
      label164:
      d2 = d3;
      d1 = d4;
      if (i <= 0) {
        break;
      }
      d2 = this.yQM.getInput() / i;
      d1 = d4;
      break;
      boolean bool2 = false;
      bool1 = false;
      if ((d1 == 0.0D) || (d2 == 0.0D)) {
        bool1 = true;
      }
      for (;;)
      {
        if (bool1)
        {
          this.yQO.setClickable(false);
          this.yQO.setEnabled(false);
          break;
          if ((d1 > ((g)localObject).yPy) && (((g)localObject).yPy > 0.0D))
          {
            this.yQU.aeu(getString(2131762752, new Object[] { Math.round(((g)localObject).yPy), Util.nullAs(((g)localObject).yPB, "") }));
            bool1 = true;
          }
          else if (d2 > 0.0D)
          {
            Log.i("MicroMsg.WxaLuckyMoneyPrepareUI", "perAmount ".concat(String.valueOf(d2)));
            if (this.yQc == h.a.yPF)
            {
              bool1 = bool2;
              if (d2 > ((g)localObject).yPw)
              {
                bool1 = bool2;
                if (((g)localObject).yPw > 0.0D)
                {
                  this.yQU.aeu(getString(2131762696, new Object[] { Math.round(((g)localObject).yPw), Util.nullAs(((g)localObject).yPB, "") }));
                  bool1 = true;
                }
              }
              label439:
              Log.i("MicroMsg.WxaLuckyMoneyPrepareUI", "furtherCheckHasErr:" + bool1 + " for max value");
              bool2 = bool1;
              if (!bool1)
              {
                if (this.yQc != h.a.yPF) {
                  break label689;
                }
                bool2 = bool1;
                if (d2 < ((g)localObject).yPx)
                {
                  this.yQU.aeu(getString(2131762698, new Object[] { f.formatMoney2f(((g)localObject).yPx), Util.nullAs(((g)localObject).yPB, "") }));
                  bool2 = true;
                }
              }
            }
            for (;;)
            {
              Log.i("MicroMsg.WxaLuckyMoneyPrepareUI", "furtherCheckHasErr:" + bool2 + " for min value");
              bool1 = bool2;
              break;
              bool1 = bool2;
              if (d2 <= ((g)localObject).yPz) {
                break label439;
              }
              bool1 = bool2;
              if (((g)localObject).yPz <= 0.0D) {
                break label439;
              }
              this.yQU.aeu(getString(2131762696, new Object[] { Math.round(((g)localObject).yPz), Util.nullAs(((g)localObject).yPB, "") }));
              bool1 = true;
              this.yQL.onError();
              this.yQM.onError();
              break label439;
              label689:
              bool2 = bool1;
              if (d2 < 0.01D)
              {
                this.yQU.aeu(getString(2131762698, new Object[] { "0.01", Util.nullAs(((g)localObject).yPB, "") }));
                bool2 = true;
                this.yQL.onError();
                this.yQM.onError();
              }
            }
          }
        }
      }
      this.yQO.setClickable(true);
      this.yQO.setEnabled(true);
    }
    label778:
    this.qAC.setText((String)localObject + f.formatMoney2f(d1));
    AppMethodBeat.o(64974);
  }
  
  public final void error(String paramString)
  {
    AppMethodBeat.i(64967);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = getString(2131768354);
    }
    com.tencent.mm.ui.base.h.a(this, str, null, false, new WxaLuckyMoneyPrepareUI.1(this));
    AppMethodBeat.o(64967);
  }
  
  public int getLayoutId()
  {
    return 2131497113;
  }
  
  protected final void hideTenpayKB()
  {
    AppMethodBeat.i(64973);
    if ((this.mKBLayout != null) && (this.mKBLayout.isShown())) {
      this.mKBLayout.setVisibility(8);
    }
    AppMethodBeat.o(64973);
  }
  
  public void initView()
  {
    AppMethodBeat.i(64968);
    setBackBtn(new WxaLuckyMoneyPrepareUI.10(this));
    this.yQN = ((LuckyMoneyTextInputView)findViewById(2131304284));
    this.yQN.setHintText(getString(2131762600));
    Object localObject1 = getIntent().getStringExtra("defaultWishingWord");
    Log.i("MicroMsg.WxaLuckyMoneyPrepareUI", "initView defaultWishingWord = %s", new Object[] { localObject1 });
    if (!Util.isNullOrNil((String)localObject1)) {
      this.yQN.setHintText((String)localObject1);
    }
    this.yQO = ((Button)findViewById(2131304215));
    this.mKeyboard = ((MyKeyboardWindow)findViewById(2131308962));
    this.mKBLayout = findViewById(2131308960);
    this.nAB = ((TextView)findViewById(2131304213));
    this.yQL = ((LuckyMoneyNumInputView)findViewById(2131304210));
    this.yQM = ((WxaLuckyMoneyMoneyInputView)findViewById(2131304015));
    this.qAC = ((TextView)findViewById(2131304228));
    this.yQR = ((MMScrollView)findViewById(2131304268));
    this.yQS = ((TextView)findViewById(2131304220));
    this.yQP = ((LinearLayout)findViewById(2131304230));
    this.yQQ = ((TextView)findViewById(2131304231));
    setMMTitle(2131762749);
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if (this.yQc == h.a.yPE)
    {
      this.yQM.setTitle(getString(2131762753));
      this.yQM.setShowGroupIcon(true);
      this.yQM.setOnInputValidChangerListener(this);
      this.yQM.setHint(getString(2131762669));
      this.yQL.setOnInputValidChangerListener(this);
      this.yQL.setHint(getString(2131762685));
      this.yQL.setNum("");
      this.yQN.setOnInputValidChangerListener(this);
      localObject2 = (EditText)this.yQM.findViewById(2131304116);
      localObject3 = (EditText)this.yQL.findViewById(2131304116);
      f.setNoSystemInputOnEditText((EditText)localObject2);
      ((InputMethodManager)getContext().getSystemService("input_method")).showSoftInput((View)localObject2, 0);
      ((EditText)localObject2).addTextChangedListener(new WxaLuckyMoneyPrepareUI.17(this));
      ((EditText)localObject2).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(64945);
          b localb = new b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/appbrand/ui/prepare/WxaLuckyMoneyPrepareUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          this.val$hintTv.setOnClickListener(null);
          this.yQW.setOnClickListener(null);
          WxaLuckyMoneyPrepareUI.this.ak(WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this), 2);
          WxaLuckyMoneyPrepareUI.this.ak(WxaLuckyMoneyPrepareUI.c(WxaLuckyMoneyPrepareUI.this), 0);
          WxaLuckyMoneyPrepareUI.this.mKeyboard.setXMode(2);
          WxaLuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText)paramAnonymousView);
          WxaLuckyMoneyPrepareUI.this.mKBLayout.setVisibility(0);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/appbrand/ui/prepare/WxaLuckyMoneyPrepareUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(64945);
        }
      });
      ((EditText)localObject2).requestFocus();
      localObject4 = (TextView)this.yQM.findViewById(2131304016);
      if (localObject4 != null) {
        ((TextView)localObject4).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(64946);
            b localb = new b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/appbrand/ui/prepare/WxaLuckyMoneyPrepareUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            this.val$hintTv.setOnClickListener(null);
            this.yQW.setOnClickListener(null);
            WxaLuckyMoneyPrepareUI.this.ak(WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this), 2);
            WxaLuckyMoneyPrepareUI.this.ak(WxaLuckyMoneyPrepareUI.c(WxaLuckyMoneyPrepareUI.this), 0);
            WxaLuckyMoneyPrepareUI.this.mKeyboard.setXMode(2);
            WxaLuckyMoneyPrepareUI.this.mKeyboard.setInputEditText(this.val$hintTv);
            WxaLuckyMoneyPrepareUI.this.mKBLayout.setVisibility(0);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/appbrand/ui/prepare/WxaLuckyMoneyPrepareUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(64946);
          }
        });
      }
      f.setNoSystemInputOnEditText((EditText)localObject3);
      ((InputMethodManager)getContext().getSystemService("input_method")).showSoftInput((View)localObject3, 0);
      ((EditText)localObject3).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(64947);
          b localb = new b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/appbrand/ui/prepare/WxaLuckyMoneyPrepareUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          this.val$hintTv.setOnClickListener(null);
          this.yQW.setOnClickListener(null);
          WxaLuckyMoneyPrepareUI.this.ak(WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this), 2);
          WxaLuckyMoneyPrepareUI.this.ak(WxaLuckyMoneyPrepareUI.c(WxaLuckyMoneyPrepareUI.this), 0);
          WxaLuckyMoneyPrepareUI.this.mKeyboard.setXMode(0);
          WxaLuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText)paramAnonymousView);
          WxaLuckyMoneyPrepareUI.this.mKBLayout.setVisibility(0);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/appbrand/ui/prepare/WxaLuckyMoneyPrepareUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(64947);
        }
      });
      ((MMEditText)this.yQN.findViewById(2131304269)).setOnFocusChangeListener(new View.OnFocusChangeListener()
      {
        public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(64948);
          this.val$hintTv.setOnClickListener(null);
          this.yQW.setOnClickListener(null);
          WxaLuckyMoneyPrepareUI.this.ak(WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this), 2);
          WxaLuckyMoneyPrepareUI.this.ak(WxaLuckyMoneyPrepareUI.c(WxaLuckyMoneyPrepareUI.this), 0);
          AppMethodBeat.o(64948);
        }
      });
      localObject2 = g.yPu;
      if (this.yQc != h.a.yPE) {
        break label1024;
      }
      this.yQM.setMaxAmount(((g)localObject2).yPy);
    }
    int i;
    for (;;)
    {
      this.yQM.setMinAmount(((g)localObject2).yPx);
      this.yQL.setMaxNum(((g)localObject2).yPv);
      localObject2 = h.a.yPE;
      this.yQL.setMinNum(1);
      this.yQM.setMaxLen(12);
      Object localObject5 = getString(2131762636);
      Object localObject6 = getString(2131762651);
      localObject2 = getString(2131762630);
      localObject3 = getString(2131762652);
      localObject4 = new l(this);
      final SpannableString localSpannableString = new SpannableString((String)localObject5 + (String)localObject6);
      localSpannableString.setSpan(localObject4, ((String)localObject5).length(), ((String)localObject5).length() + ((String)localObject6).length(), 33);
      localObject5 = new SpannableString((String)localObject2 + (String)localObject3);
      localObject6 = new l(this);
      ((SpannableString)localObject5).setSpan(localObject6, ((String)localObject2).length(), ((String)localObject2).length() + ((String)localObject3).length(), 33);
      ((l)localObject4).IgH = new l.a()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(64960);
          int i = WxaLuckyMoneyPrepareUI.c(WxaLuckyMoneyPrepareUI.this).getInput();
          double d = WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).getInput();
          WxaLuckyMoneyPrepareUI.a(WxaLuckyMoneyPrepareUI.this, h.a.yPF);
          WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).setType(WxaLuckyMoneyPrepareUI.e(WxaLuckyMoneyPrepareUI.this));
          WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).setShowGroupIcon(false);
          WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).setTitle(WxaLuckyMoneyPrepareUI.this.getString(2131762754));
          if ((d > 0.0D) && (i > 0)) {
            WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).setAmount(f.formatMoney2f(d / i));
          }
          WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).setMaxAmount(g.yPu.yPw);
          WxaLuckyMoneyPrepareUI.g(WxaLuckyMoneyPrepareUI.this).setText(this.yRa);
          AppMethodBeat.o(64960);
        }
      };
      ((l)localObject6).IgH = new l.a()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(64961);
          int i = WxaLuckyMoneyPrepareUI.c(WxaLuckyMoneyPrepareUI.this).getInput();
          double d = WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).getInput();
          WxaLuckyMoneyPrepareUI.a(WxaLuckyMoneyPrepareUI.this, h.a.yPE);
          WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).setType(WxaLuckyMoneyPrepareUI.e(WxaLuckyMoneyPrepareUI.this));
          WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).setMaxAmount(g.yPu.yPy);
          WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).setTitle(WxaLuckyMoneyPrepareUI.this.getString(2131762753));
          WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).setShowGroupIcon(true);
          if ((d > 0.0D) && (i > 0)) {
            WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).setAmount(f.formatMoney2f(d * i));
          }
          WxaLuckyMoneyPrepareUI.g(WxaLuckyMoneyPrepareUI.this).setText(localSpannableString);
          AppMethodBeat.o(64961);
        }
      };
      this.nAB.setMovementMethod(LinkMovementMethod.getInstance());
      this.nAB.setText(localSpannableString);
      this.nAB.setVisibility(0);
      this.yQO.setClickable(false);
      this.yQO.setEnabled(false);
      this.yQO.setOnClickListener(new x()
      {
        public final void czW()
        {
          AppMethodBeat.i(64957);
          if (WxaLuckyMoneyPrepareUI.a(WxaLuckyMoneyPrepareUI.this) == null)
          {
            Log.e("MicroMsg.WxaLuckyMoneyPrepareUI", "Click PrepareBtn but, mLogic == null");
            AppMethodBeat.o(64957);
            return;
          }
          if (WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).eeH() != 0)
          {
            u.makeText(WxaLuckyMoneyPrepareUI.this.getContext(), 2131767474, 0).show();
            AppMethodBeat.o(64957);
            return;
          }
          int i = WxaLuckyMoneyPrepareUI.c(WxaLuckyMoneyPrepareUI.this).getInput();
          double d = WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).getInput();
          String str2 = WxaLuckyMoneyPrepareUI.d(WxaLuckyMoneyPrepareUI.this).getInput();
          String str1 = str2;
          if (Util.isNullOrNil(str2)) {
            if (Util.isNullOrNil(this.yQZ)) {
              break label171;
            }
          }
          label171:
          for (str1 = this.yQZ; WxaLuckyMoneyPrepareUI.e(WxaLuckyMoneyPrepareUI.this) == h.a.yPE; str1 = WxaLuckyMoneyPrepareUI.this.getString(2131762600))
          {
            WxaLuckyMoneyPrepareUI.a(WxaLuckyMoneyPrepareUI.this).d((int)f.E(d), i, str1, WxaLuckyMoneyPrepareUI.f(WxaLuckyMoneyPrepareUI.this));
            AppMethodBeat.o(64957);
            return;
          }
          if (WxaLuckyMoneyPrepareUI.e(WxaLuckyMoneyPrepareUI.this) == h.a.yPF) {
            WxaLuckyMoneyPrepareUI.a(WxaLuckyMoneyPrepareUI.this).e((int)f.E(d), i, str1, WxaLuckyMoneyPrepareUI.f(WxaLuckyMoneyPrepareUI.this));
          }
          AppMethodBeat.o(64957);
        }
      });
      this.yQU.a(this.yQL);
      this.yQU.a(this.yQM);
      this.yQU.a(this.yQN);
      localObject1 = (TextView)findViewById(2131304217);
      this.yQU.t((TextView)localObject1);
      if (this.yQR != null) {
        this.yQR.setOnTouchListener(new WxaLuckyMoneyPrepareUI.12(this));
      }
      this.yQM.setType(this.yQc);
      addIconOptionMenu(0, 2131233685, new WxaLuckyMoneyPrepareUI.13(this));
      i = getIntent().getIntExtra("range", 0);
      Log.i("MicroMsg.WxaLuckyMoneyPrepareUI", "initRange range = %d", new Object[] { Integer.valueOf(i) });
      this.yQP.setVisibility(8);
      if (i != 0) {
        break label1038;
      }
      this.yQT = 0;
      AppMethodBeat.o(64968);
      return;
      this.yQM.setTitle(getString(2131762754));
      this.yQM.setShowGroupIcon(false);
      break;
      label1024:
      this.yQM.setMaxAmount(((g)localObject2).yPw);
    }
    label1038:
    if (i == 1)
    {
      this.yQT = 1;
      AppMethodBeat.o(64968);
      return;
    }
    localObject1 = new ArrayList();
    ((ArrayList)localObject1).add(getString(2131768815));
    ((ArrayList)localObject1).add(getString(2131768816));
    this.yQP.setVisibility(0);
    this.yQQ.setText((CharSequence)((ArrayList)localObject1).get(this.yQT));
    this.yQP.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(64963);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/appbrand/ui/prepare/WxaLuckyMoneyPrepareUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = new com.tencent.mm.ui.widget.picker.c(WxaLuckyMoneyPrepareUI.this.getContext(), this.sLZ);
        paramAnonymousView.app(WxaLuckyMoneyPrepareUI.f(WxaLuckyMoneyPrepareUI.this));
        paramAnonymousView.QTc = new c.b()
        {
          public final void onResult(boolean paramAnonymous2Boolean, Object paramAnonymous2Object1, Object paramAnonymous2Object2)
          {
            AppMethodBeat.i(64962);
            paramAnonymousView.hide();
            if (paramAnonymous2Boolean) {
              WxaLuckyMoneyPrepareUI.h(WxaLuckyMoneyPrepareUI.this).setText((CharSequence)paramAnonymous2Object1);
            }
            WxaLuckyMoneyPrepareUI.a(WxaLuckyMoneyPrepareUI.this, paramAnonymousView.hci());
            AppMethodBeat.o(64962);
          }
        };
        paramAnonymousView.show();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/appbrand/ui/prepare/WxaLuckyMoneyPrepareUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(64963);
      }
    });
    AppMethodBeat.o(64968);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(64969);
    setResult(0, new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{user cancel}}"));
    finish();
    AppMethodBeat.o(64969);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(64966);
    super.onCreate(paramBundle);
    initView();
    this.yQJ = new d();
    this.yQJ.d(this, getIntent());
    AppMethodBeat.o(64966);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(64970);
    super.onDestroy();
    this.yQU.clear();
    if (this.yQJ != null) {
      this.yQJ.onDestroy();
    }
    AppMethodBeat.o(64970);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(64972);
    if ((paramInt == 4) && (this.mKBLayout != null) && (this.mKBLayout.isShown()))
    {
      this.mKBLayout.setVisibility(8);
      AppMethodBeat.o(64972);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(64972);
    return bool;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyPrepareUI
 * JD-Core Version:    0.7.0.1
 */