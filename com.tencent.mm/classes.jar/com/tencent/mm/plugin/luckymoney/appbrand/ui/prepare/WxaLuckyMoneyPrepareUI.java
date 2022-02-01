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
import com.tencent.mm.plugin.luckymoney.appbrand.a.h.a;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.WxaLuckyMoneyBaseUI;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.WxaLuckyMoneyMoneyInputView;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNumInputView;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyTextInputView;
import com.tencent.mm.plugin.wallet_core.ui.l;
import com.tencent.mm.plugin.wallet_core.ui.l.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.w;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.picker.c.a;
import com.tencent.mm.wallet_core.ui.MMScrollView;
import com.tencent.mm.wallet_core.ui.e;
import com.tenpay.android.wechat.MyKeyboardWindow;
import java.util.ArrayList;

@com.tencent.mm.ui.base.a(19)
public class WxaLuckyMoneyPrepareUI
  extends WxaLuckyMoneyBaseUI
  implements c, com.tencent.mm.plugin.luckymoney.ui.g
{
  protected View mKBLayout;
  protected MyKeyboardWindow mKeyboard;
  private TextView mkS;
  private TextView peG;
  private h.a vjJ;
  private com.tencent.mm.plugin.luckymoney.ui.b vkA;
  private a vkq;
  private LuckyMoneyNumInputView vkr;
  private WxaLuckyMoneyMoneyInputView vks;
  private LuckyMoneyTextInputView vkt;
  private Button vku;
  private LinearLayout vkv;
  private TextView vkw;
  private MMScrollView vkx;
  private TextView vky;
  private int vkz;
  
  public WxaLuckyMoneyPrepareUI()
  {
    AppMethodBeat.i(64965);
    this.vkq = null;
    this.vjJ = h.a.vjl;
    this.vkr = null;
    this.vks = null;
    this.vkt = null;
    this.peG = null;
    this.vku = null;
    this.vkz = 0;
    this.vkA = new com.tencent.mm.plugin.luckymoney.ui.b();
    AppMethodBeat.o(64965);
  }
  
  protected final void ai(final View paramView, final int paramInt)
  {
    AppMethodBeat.i(64971);
    this.mKeyboard = ((MyKeyboardWindow)findViewById(2131305695));
    this.mKBLayout = findViewById(2131305693);
    View localView = findViewById(2131305696);
    final EditText localEditText = (EditText)paramView.findViewById(2131301810);
    if ((this.mKeyboard == null) || (localEditText == null) || (this.mKBLayout == null))
    {
      AppMethodBeat.o(64971);
      return;
    }
    e.setNoSystemInputOnEditText(localEditText);
    localEditText.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public final void onFocusChange(final View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(64951);
        if ((paramAnonymousView.isFocused()) && (!this.val$isShowSysKB))
        {
          ((InputMethodManager)WxaLuckyMoneyPrepareUI.this.getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramAnonymousView.getWindowToken(), 0);
          new ap().postDelayed(new Runnable()
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
        new ap().postDelayed(new Runnable()
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
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/appbrand/ui/prepare/WxaLuckyMoneyPrepareUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
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
    TextView localTextView = (TextView)paramView.findViewById(2131301716);
    if (localTextView != null) {
      localTextView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(64954);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/appbrand/ui/prepare/WxaLuckyMoneyPrepareUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
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
              new ap().postDelayed(new Runnable()
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
  
  public final MMActivity dhO()
  {
    return this;
  }
  
  public final void dhP() {}
  
  public final void dhR()
  {
    AppMethodBeat.i(64974);
    double d4 = 0.0D;
    double d3 = 0.0D;
    double d2 = d3;
    double d1 = d4;
    int i;
    if (this.vks.dhQ() != 3)
    {
      d2 = d3;
      d1 = d4;
      if (this.vkr.dhQ() != 3)
      {
        i = this.vkr.getInput();
        d4 = this.vks.getInput();
        if (this.vjJ != h.a.vjm) {
          break label162;
        }
        d1 = d4 * i;
        d2 = this.vks.getInput();
      }
    }
    boolean bool1 = this.vkA.djp();
    Object localObject = com.tencent.mm.plugin.luckymoney.appbrand.a.g.vjb;
    if (bool1)
    {
      ad.i("MicroMsg.WxaLuckyMoneyPrepareUI", "has error");
      this.vku.setClickable(false);
      this.vku.setEnabled(false);
    }
    for (;;)
    {
      localObject = ((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).vjh;
      if (!bt.isNullOrNil((String)localObject)) {
        break label773;
      }
      this.peG.setText(e.D(d1));
      AppMethodBeat.o(64974);
      return;
      label162:
      d2 = d3;
      d1 = d4;
      if (i <= 0) {
        break;
      }
      d2 = this.vks.getInput() / i;
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
          this.vku.setClickable(false);
          this.vku.setEnabled(false);
          break;
          if ((d1 > ((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).vjf) && (((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).vjf > 0.0D))
          {
            this.vkA.TW(getString(2131760977, new Object[] { Math.round(((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).vjf), bt.bI(((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).vji, "") }));
            bool1 = true;
          }
          else if (d2 > 0.0D)
          {
            ad.i("MicroMsg.WxaLuckyMoneyPrepareUI", "perAmount ".concat(String.valueOf(d2)));
            if (this.vjJ == h.a.vjm)
            {
              bool1 = bool2;
              if (d2 > ((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).vjd)
              {
                bool1 = bool2;
                if (((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).vjd > 0.0D)
                {
                  this.vkA.TW(getString(2131760922, new Object[] { Math.round(((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).vjd), bt.bI(((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).vji, "") }));
                  bool1 = true;
                }
              }
              label436:
              ad.i("MicroMsg.WxaLuckyMoneyPrepareUI", "furtherCheckHasErr:" + bool1 + " for max value");
              bool2 = bool1;
              if (!bool1)
              {
                if (this.vjJ != h.a.vjm) {
                  break label684;
                }
                bool2 = bool1;
                if (d2 < ((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).vje)
                {
                  this.vkA.TW(getString(2131760924, new Object[] { e.C(((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).vje), bt.bI(((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).vji, "") }));
                  bool2 = true;
                }
              }
            }
            for (;;)
            {
              ad.i("MicroMsg.WxaLuckyMoneyPrepareUI", "furtherCheckHasErr:" + bool2 + " for min value");
              bool1 = bool2;
              break;
              bool1 = bool2;
              if (d2 <= ((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).vjg) {
                break label436;
              }
              bool1 = bool2;
              if (((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).vjg <= 0.0D) {
                break label436;
              }
              this.vkA.TW(getString(2131760922, new Object[] { Math.round(((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).vjg), bt.bI(((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).vji, "") }));
              bool1 = true;
              this.vkr.onError();
              this.vks.onError();
              break label436;
              label684:
              bool2 = bool1;
              if (d2 < 0.01D)
              {
                this.vkA.TW(getString(2131760924, new Object[] { "0.01", bt.bI(((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).vji, "") }));
                bool2 = true;
                this.vkr.onError();
                this.vks.onError();
              }
            }
          }
        }
      }
      this.vku.setClickable(true);
      this.vku.setEnabled(true);
    }
    label773:
    this.peG.setText((String)localObject + e.C(d1));
    AppMethodBeat.o(64974);
  }
  
  public final void error(String paramString)
  {
    AppMethodBeat.i(64967);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = getString(2131765901);
    }
    h.a(this, str, null, false, new WxaLuckyMoneyPrepareUI.1(this));
    AppMethodBeat.o(64967);
  }
  
  public int getLayoutId()
  {
    return 2131496119;
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
    this.vkt = ((LuckyMoneyTextInputView)findViewById(2131301959));
    this.vkt.setHintText(getString(2131760843));
    Object localObject1 = getIntent().getStringExtra("defaultWishingWord");
    ad.i("MicroMsg.WxaLuckyMoneyPrepareUI", "initView defaultWishingWord = %s", new Object[] { localObject1 });
    if (!bt.isNullOrNil((String)localObject1)) {
      this.vkt.setHintText((String)localObject1);
    }
    this.vku = ((Button)findViewById(2131301896));
    this.mKeyboard = ((MyKeyboardWindow)findViewById(2131305695));
    this.mKBLayout = findViewById(2131305693);
    this.mkS = ((TextView)findViewById(2131301894));
    this.vkr = ((LuckyMoneyNumInputView)findViewById(2131301891));
    this.vks = ((WxaLuckyMoneyMoneyInputView)findViewById(2131301715));
    this.peG = ((TextView)findViewById(2131301909));
    this.vkx = ((MMScrollView)findViewById(2131301943));
    this.vky = ((TextView)findViewById(2131301901));
    this.vkv = ((LinearLayout)findViewById(2131301911));
    this.vkw = ((TextView)findViewById(2131301912));
    setMMTitle(2131760975);
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if (this.vjJ == h.a.vjl)
    {
      this.vks.setTitle(getString(2131760978));
      this.vks.setShowGroupIcon(true);
      this.vks.setOnInputValidChangerListener(this);
      this.vks.setHint(getString(2131760895));
      this.vkr.setOnInputValidChangerListener(this);
      this.vkr.setHint(getString(2131760911));
      this.vkr.setNum("");
      this.vkt.setOnInputValidChangerListener(this);
      localObject2 = (EditText)this.vks.findViewById(2131301810);
      localObject3 = (EditText)this.vkr.findViewById(2131301810);
      e.setNoSystemInputOnEditText((EditText)localObject2);
      ((InputMethodManager)getContext().getSystemService("input_method")).showSoftInput((View)localObject2, 0);
      ((EditText)localObject2).addTextChangedListener(new WxaLuckyMoneyPrepareUI.17(this));
      ((EditText)localObject2).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(64945);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/appbrand/ui/prepare/WxaLuckyMoneyPrepareUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          this.val$hintTv.setOnClickListener(null);
          this.vkC.setOnClickListener(null);
          WxaLuckyMoneyPrepareUI.this.ai(WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this), 2);
          WxaLuckyMoneyPrepareUI.this.ai(WxaLuckyMoneyPrepareUI.c(WxaLuckyMoneyPrepareUI.this), 0);
          WxaLuckyMoneyPrepareUI.this.mKeyboard.setXMode(2);
          WxaLuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText)paramAnonymousView);
          WxaLuckyMoneyPrepareUI.this.mKBLayout.setVisibility(0);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/appbrand/ui/prepare/WxaLuckyMoneyPrepareUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(64945);
        }
      });
      ((EditText)localObject2).requestFocus();
      localObject4 = (TextView)this.vks.findViewById(2131301716);
      if (localObject4 != null) {
        ((TextView)localObject4).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(64946);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/appbrand/ui/prepare/WxaLuckyMoneyPrepareUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            this.val$hintTv.setOnClickListener(null);
            this.vkC.setOnClickListener(null);
            WxaLuckyMoneyPrepareUI.this.ai(WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this), 2);
            WxaLuckyMoneyPrepareUI.this.ai(WxaLuckyMoneyPrepareUI.c(WxaLuckyMoneyPrepareUI.this), 0);
            WxaLuckyMoneyPrepareUI.this.mKeyboard.setXMode(2);
            WxaLuckyMoneyPrepareUI.this.mKeyboard.setInputEditText(this.val$hintTv);
            WxaLuckyMoneyPrepareUI.this.mKBLayout.setVisibility(0);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/appbrand/ui/prepare/WxaLuckyMoneyPrepareUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(64946);
          }
        });
      }
      e.setNoSystemInputOnEditText((EditText)localObject3);
      ((InputMethodManager)getContext().getSystemService("input_method")).showSoftInput((View)localObject3, 0);
      ((EditText)localObject3).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(64947);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/appbrand/ui/prepare/WxaLuckyMoneyPrepareUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          this.val$hintTv.setOnClickListener(null);
          this.vkC.setOnClickListener(null);
          WxaLuckyMoneyPrepareUI.this.ai(WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this), 2);
          WxaLuckyMoneyPrepareUI.this.ai(WxaLuckyMoneyPrepareUI.c(WxaLuckyMoneyPrepareUI.this), 0);
          WxaLuckyMoneyPrepareUI.this.mKeyboard.setXMode(0);
          WxaLuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText)paramAnonymousView);
          WxaLuckyMoneyPrepareUI.this.mKBLayout.setVisibility(0);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/appbrand/ui/prepare/WxaLuckyMoneyPrepareUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(64947);
        }
      });
      ((MMEditText)this.vkt.findViewById(2131301944)).setOnFocusChangeListener(new View.OnFocusChangeListener()
      {
        public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(64948);
          this.val$hintTv.setOnClickListener(null);
          this.vkC.setOnClickListener(null);
          WxaLuckyMoneyPrepareUI.this.ai(WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this), 2);
          WxaLuckyMoneyPrepareUI.this.ai(WxaLuckyMoneyPrepareUI.c(WxaLuckyMoneyPrepareUI.this), 0);
          AppMethodBeat.o(64948);
        }
      });
      localObject2 = com.tencent.mm.plugin.luckymoney.appbrand.a.g.vjb;
      if (this.vjJ != h.a.vjl) {
        break label1022;
      }
      this.vks.setMaxAmount(((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject2).vjf);
    }
    int i;
    for (;;)
    {
      this.vks.setMinAmount(((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject2).vje);
      this.vkr.setMaxNum(((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject2).vjc);
      localObject2 = h.a.vjl;
      this.vkr.setMinNum(1);
      this.vks.setMaxLen(12);
      Object localObject5 = getString(2131760867);
      Object localObject6 = getString(2131760882);
      localObject2 = getString(2131760861);
      localObject3 = getString(2131760883);
      localObject4 = new l(this);
      final SpannableString localSpannableString = new SpannableString((String)localObject5 + (String)localObject6);
      localSpannableString.setSpan(localObject4, ((String)localObject5).length(), ((String)localObject5).length() + ((String)localObject6).length(), 33);
      localObject5 = new SpannableString((String)localObject2 + (String)localObject3);
      localObject6 = new l(this);
      ((SpannableString)localObject5).setSpan(localObject6, ((String)localObject2).length(), ((String)localObject2).length() + ((String)localObject3).length(), 33);
      ((l)localObject4).DfS = new l.a()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(64960);
          int i = WxaLuckyMoneyPrepareUI.c(WxaLuckyMoneyPrepareUI.this).getInput();
          double d = WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).getInput();
          WxaLuckyMoneyPrepareUI.a(WxaLuckyMoneyPrepareUI.this, h.a.vjm);
          WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).setType(WxaLuckyMoneyPrepareUI.e(WxaLuckyMoneyPrepareUI.this));
          WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).setShowGroupIcon(false);
          WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).setTitle(WxaLuckyMoneyPrepareUI.this.getString(2131760979));
          if ((d > 0.0D) && (i > 0)) {
            WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).setAmount(e.C(d / i));
          }
          WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).setMaxAmount(com.tencent.mm.plugin.luckymoney.appbrand.a.g.vjb.vjd);
          WxaLuckyMoneyPrepareUI.g(WxaLuckyMoneyPrepareUI.this).setText(this.vkG);
          AppMethodBeat.o(64960);
        }
      };
      ((l)localObject6).DfS = new l.a()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(64961);
          int i = WxaLuckyMoneyPrepareUI.c(WxaLuckyMoneyPrepareUI.this).getInput();
          double d = WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).getInput();
          WxaLuckyMoneyPrepareUI.a(WxaLuckyMoneyPrepareUI.this, h.a.vjl);
          WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).setType(WxaLuckyMoneyPrepareUI.e(WxaLuckyMoneyPrepareUI.this));
          WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).setMaxAmount(com.tencent.mm.plugin.luckymoney.appbrand.a.g.vjb.vjf);
          WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).setTitle(WxaLuckyMoneyPrepareUI.this.getString(2131760978));
          WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).setShowGroupIcon(true);
          if ((d > 0.0D) && (i > 0)) {
            WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).setAmount(e.C(d * i));
          }
          WxaLuckyMoneyPrepareUI.g(WxaLuckyMoneyPrepareUI.this).setText(localSpannableString);
          AppMethodBeat.o(64961);
        }
      };
      this.mkS.setMovementMethod(LinkMovementMethod.getInstance());
      this.mkS.setText(localSpannableString);
      this.mkS.setVisibility(0);
      this.vku.setClickable(false);
      this.vku.setEnabled(false);
      this.vku.setOnClickListener(new w()
      {
        public final void caN()
        {
          AppMethodBeat.i(64957);
          if (WxaLuckyMoneyPrepareUI.a(WxaLuckyMoneyPrepareUI.this) == null)
          {
            ad.e("MicroMsg.WxaLuckyMoneyPrepareUI", "Click PrepareBtn but, mLogic == null");
            AppMethodBeat.o(64957);
            return;
          }
          if (WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).dhQ() != 0)
          {
            t.makeText(WxaLuckyMoneyPrepareUI.this.getContext(), 2131765031, 0).show();
            AppMethodBeat.o(64957);
            return;
          }
          int i = WxaLuckyMoneyPrepareUI.c(WxaLuckyMoneyPrepareUI.this).getInput();
          double d = WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).getInput();
          String str2 = WxaLuckyMoneyPrepareUI.d(WxaLuckyMoneyPrepareUI.this).getInput();
          String str1 = str2;
          if (bt.isNullOrNil(str2)) {
            if (bt.isNullOrNil(this.vkF)) {
              break label171;
            }
          }
          label171:
          for (str1 = this.vkF; WxaLuckyMoneyPrepareUI.e(WxaLuckyMoneyPrepareUI.this) == h.a.vjl; str1 = WxaLuckyMoneyPrepareUI.this.getString(2131760843))
          {
            WxaLuckyMoneyPrepareUI.a(WxaLuckyMoneyPrepareUI.this).c((int)e.E(d), i, str1, WxaLuckyMoneyPrepareUI.f(WxaLuckyMoneyPrepareUI.this));
            AppMethodBeat.o(64957);
            return;
          }
          if (WxaLuckyMoneyPrepareUI.e(WxaLuckyMoneyPrepareUI.this) == h.a.vjm) {
            WxaLuckyMoneyPrepareUI.a(WxaLuckyMoneyPrepareUI.this).d((int)e.E(d), i, str1, WxaLuckyMoneyPrepareUI.f(WxaLuckyMoneyPrepareUI.this));
          }
          AppMethodBeat.o(64957);
        }
      });
      this.vkA.a(this.vkr);
      this.vkA.a(this.vks);
      this.vkA.a(this.vkt);
      localObject1 = (TextView)findViewById(2131301898);
      this.vkA.n((TextView)localObject1);
      if (this.vkx != null) {
        this.vkx.setOnTouchListener(new WxaLuckyMoneyPrepareUI.12(this));
      }
      this.vks.setType(this.vjJ);
      addIconOptionMenu(0, 2131233032, new WxaLuckyMoneyPrepareUI.13(this));
      i = getIntent().getIntExtra("range", 0);
      ad.i("MicroMsg.WxaLuckyMoneyPrepareUI", "initRange range = %d", new Object[] { Integer.valueOf(i) });
      this.vkv.setVisibility(8);
      if (i != 0) {
        break label1036;
      }
      this.vkz = 0;
      AppMethodBeat.o(64968);
      return;
      this.vks.setTitle(getString(2131760979));
      this.vks.setShowGroupIcon(false);
      break;
      label1022:
      this.vks.setMaxAmount(((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject2).vjd);
    }
    label1036:
    if (i == 1)
    {
      this.vkz = 1;
      AppMethodBeat.o(64968);
      return;
    }
    localObject1 = new ArrayList();
    ((ArrayList)localObject1).add(getString(2131766304));
    ((ArrayList)localObject1).add(getString(2131766305));
    this.vkv.setVisibility(0);
    this.vkw.setText((CharSequence)((ArrayList)localObject1).get(this.vkz));
    this.vkv.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(64963);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/appbrand/ui/prepare/WxaLuckyMoneyPrepareUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = new com.tencent.mm.ui.widget.picker.c(WxaLuckyMoneyPrepareUI.this.getContext(), this.rcn);
        paramAnonymousView.afD(WxaLuckyMoneyPrepareUI.f(WxaLuckyMoneyPrepareUI.this));
        paramAnonymousView.LaQ = new c.a()
        {
          public final void onResult(boolean paramAnonymous2Boolean, Object paramAnonymous2Object1, Object paramAnonymous2Object2)
          {
            AppMethodBeat.i(64962);
            paramAnonymousView.hide();
            if (paramAnonymous2Boolean) {
              WxaLuckyMoneyPrepareUI.h(WxaLuckyMoneyPrepareUI.this).setText((CharSequence)paramAnonymous2Object1);
            }
            WxaLuckyMoneyPrepareUI.a(WxaLuckyMoneyPrepareUI.this, paramAnonymousView.fMM());
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
    this.vkq = new d();
    this.vkq.d(this, getIntent());
    AppMethodBeat.o(64966);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(64970);
    super.onDestroy();
    this.vkA.clear();
    if (this.vkq != null) {
      this.vkq.onDestroy();
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