package com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
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
import com.tencent.mm.plugin.luckymoney.ui.b;
import com.tencent.mm.plugin.wallet_core.ui.l;
import com.tencent.mm.plugin.wallet_core.ui.l.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.v;
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
  private TextView lln;
  protected View mKBLayout;
  protected MyKeyboardWindow mKeyboard;
  private TextView nXQ;
  private h.a sYL;
  private TextView sZA;
  private int sZB;
  private b sZC;
  private a sZs;
  private LuckyMoneyNumInputView sZt;
  private WxaLuckyMoneyMoneyInputView sZu;
  private LuckyMoneyTextInputView sZv;
  private Button sZw;
  private LinearLayout sZx;
  private TextView sZy;
  private MMScrollView sZz;
  
  public WxaLuckyMoneyPrepareUI()
  {
    AppMethodBeat.i(64965);
    this.sZs = null;
    this.sYL = h.a.sYn;
    this.sZt = null;
    this.sZu = null;
    this.sZv = null;
    this.nXQ = null;
    this.sZw = null;
    this.sZB = 0;
    this.sZC = new b();
    AppMethodBeat.o(64965);
  }
  
  protected final void ag(final View paramView, final int paramInt)
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
        if ((!WxaLuckyMoneyPrepareUI.this.mKBLayout.isShown()) && (!this.val$isShowSysKB))
        {
          WxaLuckyMoneyPrepareUI.this.mKBLayout.setVisibility(0);
          WxaLuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText)paramAnonymousView);
          WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this, paramInt);
          AppMethodBeat.o(64952);
          return;
        }
        if (this.val$isShowSysKB)
        {
          WxaLuckyMoneyPrepareUI.this.mKBLayout.setVisibility(8);
          ((InputMethodManager)WxaLuckyMoneyPrepareUI.this.getContext().getSystemService("input_method")).showSoftInput(localEditText, 0);
        }
        AppMethodBeat.o(64952);
      }
    });
    TextView localTextView = (TextView)paramView.findViewById(2131301716);
    if (localTextView != null) {
      localTextView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(64954);
          if ((WxaLuckyMoneyPrepareUI.this.mKBLayout.isShown()) && (!this.val$isShowSysKB))
          {
            if (WxaLuckyMoneyPrepareUI.this.mKeyboard != null)
            {
              WxaLuckyMoneyPrepareUI.this.mKeyboard.setInputEditText(localEditText);
              AppMethodBeat.o(64954);
            }
          }
          else
          {
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
              AppMethodBeat.o(64954);
              return;
            }
            if (this.val$isShowSysKB)
            {
              WxaLuckyMoneyPrepareUI.this.mKBLayout.setVisibility(8);
              ((InputMethodManager)WxaLuckyMoneyPrepareUI.this.getContext().getSystemService("input_method")).showSoftInput(localEditText, 0);
            }
          }
          AppMethodBeat.o(64954);
        }
      });
    }
    localView.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(64955);
        WxaLuckyMoneyPrepareUI.this.hideTenpayKB();
        AppMethodBeat.o(64955);
      }
    });
    AppMethodBeat.o(64971);
  }
  
  public final MMActivity cKW()
  {
    return this;
  }
  
  public final void cKX() {}
  
  public final void cKZ()
  {
    AppMethodBeat.i(64974);
    double d4 = 0.0D;
    double d3 = 0.0D;
    double d2 = d3;
    double d1 = d4;
    int i;
    if (this.sZu.cKY() != 3)
    {
      d2 = d3;
      d1 = d4;
      if (this.sZt.cKY() != 3)
      {
        i = this.sZt.getInput();
        d4 = this.sZu.getInput();
        if (this.sYL != h.a.sYo) {
          break label162;
        }
        d1 = d4 * i;
        d2 = this.sZu.getInput();
      }
    }
    boolean bool1 = this.sZC.cMw();
    Object localObject = com.tencent.mm.plugin.luckymoney.appbrand.a.g.sYd;
    if (bool1)
    {
      ad.i("MicroMsg.WxaLuckyMoneyPrepareUI", "has error");
      this.sZw.setClickable(false);
      this.sZw.setEnabled(false);
    }
    for (;;)
    {
      localObject = ((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).sYj;
      if (!bt.isNullOrNil((String)localObject)) {
        break label773;
      }
      this.nXQ.setText(e.E(d1));
      AppMethodBeat.o(64974);
      return;
      label162:
      d2 = d3;
      d1 = d4;
      if (i <= 0) {
        break;
      }
      d2 = this.sZu.getInput() / i;
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
          this.sZw.setClickable(false);
          this.sZw.setEnabled(false);
          break;
          if ((d1 > ((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).sYh) && (((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).sYh > 0.0D))
          {
            this.sZC.Mp(getString(2131760977, new Object[] { Math.round(((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).sYh), bt.by(((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).sYk, "") }));
            bool1 = true;
          }
          else if (d2 > 0.0D)
          {
            ad.i("MicroMsg.WxaLuckyMoneyPrepareUI", "perAmount ".concat(String.valueOf(d2)));
            if (this.sYL == h.a.sYo)
            {
              bool1 = bool2;
              if (d2 > ((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).sYf)
              {
                bool1 = bool2;
                if (((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).sYf > 0.0D)
                {
                  this.sZC.Mp(getString(2131760922, new Object[] { Math.round(((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).sYf), bt.by(((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).sYk, "") }));
                  bool1 = true;
                }
              }
              label436:
              ad.i("MicroMsg.WxaLuckyMoneyPrepareUI", "furtherCheckHasErr:" + bool1 + " for max value");
              bool2 = bool1;
              if (!bool1)
              {
                if (this.sYL != h.a.sYo) {
                  break label684;
                }
                bool2 = bool1;
                if (d2 < ((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).sYg)
                {
                  this.sZC.Mp(getString(2131760924, new Object[] { e.D(((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).sYg), bt.by(((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).sYk, "") }));
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
              if (d2 <= ((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).sYi) {
                break label436;
              }
              bool1 = bool2;
              if (((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).sYi <= 0.0D) {
                break label436;
              }
              this.sZC.Mp(getString(2131760922, new Object[] { Math.round(((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).sYi), bt.by(((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).sYk, "") }));
              bool1 = true;
              this.sZt.onError();
              this.sZu.onError();
              break label436;
              label684:
              bool2 = bool1;
              if (d2 < 0.01D)
              {
                this.sZC.Mp(getString(2131760924, new Object[] { "0.01", bt.by(((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).sYk, "") }));
                bool2 = true;
                this.sZt.onError();
                this.sZu.onError();
              }
            }
          }
        }
      }
      this.sZw.setClickable(true);
      this.sZw.setEnabled(true);
    }
    label773:
    this.nXQ.setText((String)localObject + e.D(d1));
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
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(64956);
        WxaLuckyMoneyPrepareUI.this.setResult(0, new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{user cancel}}"));
        WxaLuckyMoneyPrepareUI.this.finish();
        AppMethodBeat.o(64956);
        return true;
      }
    });
    this.sZv = ((LuckyMoneyTextInputView)findViewById(2131301959));
    this.sZv.setHintText(getString(2131760843));
    Object localObject1 = getIntent().getStringExtra("defaultWishingWord");
    ad.i("MicroMsg.WxaLuckyMoneyPrepareUI", "initView defaultWishingWord = %s", new Object[] { localObject1 });
    if (!bt.isNullOrNil((String)localObject1)) {
      this.sZv.setHintText((String)localObject1);
    }
    this.sZw = ((Button)findViewById(2131301896));
    this.mKeyboard = ((MyKeyboardWindow)findViewById(2131305695));
    this.mKBLayout = findViewById(2131305693);
    this.lln = ((TextView)findViewById(2131301894));
    this.sZt = ((LuckyMoneyNumInputView)findViewById(2131301891));
    this.sZu = ((WxaLuckyMoneyMoneyInputView)findViewById(2131301715));
    this.nXQ = ((TextView)findViewById(2131301909));
    this.sZz = ((MMScrollView)findViewById(2131301943));
    this.sZA = ((TextView)findViewById(2131301901));
    this.sZx = ((LinearLayout)findViewById(2131301911));
    this.sZy = ((TextView)findViewById(2131301912));
    setMMTitle(2131760975);
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if (this.sYL == h.a.sYn)
    {
      this.sZu.setTitle(getString(2131760978));
      this.sZu.setShowGroupIcon(true);
      this.sZu.setOnInputValidChangerListener(this);
      this.sZu.setHint(getString(2131760895));
      this.sZt.setOnInputValidChangerListener(this);
      this.sZt.setHint(getString(2131760911));
      this.sZt.setNum("");
      this.sZv.setOnInputValidChangerListener(this);
      localObject2 = (EditText)this.sZu.findViewById(2131301810);
      localObject3 = (EditText)this.sZt.findViewById(2131301810);
      e.setNoSystemInputOnEditText((EditText)localObject2);
      ((InputMethodManager)getContext().getSystemService("input_method")).showSoftInput((View)localObject2, 0);
      ((EditText)localObject2).addTextChangedListener(new WxaLuckyMoneyPrepareUI.17(this));
      ((EditText)localObject2).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(64945);
          this.val$hintTv.setOnClickListener(null);
          this.sZE.setOnClickListener(null);
          WxaLuckyMoneyPrepareUI.this.ag(WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this), 2);
          WxaLuckyMoneyPrepareUI.this.ag(WxaLuckyMoneyPrepareUI.c(WxaLuckyMoneyPrepareUI.this), 0);
          WxaLuckyMoneyPrepareUI.this.mKeyboard.setXMode(2);
          WxaLuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText)paramAnonymousView);
          WxaLuckyMoneyPrepareUI.this.mKBLayout.setVisibility(0);
          AppMethodBeat.o(64945);
        }
      });
      ((EditText)localObject2).requestFocus();
      localObject4 = (TextView)this.sZu.findViewById(2131301716);
      if (localObject4 != null) {
        ((TextView)localObject4).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(64946);
            this.val$hintTv.setOnClickListener(null);
            this.sZE.setOnClickListener(null);
            WxaLuckyMoneyPrepareUI.this.ag(WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this), 2);
            WxaLuckyMoneyPrepareUI.this.ag(WxaLuckyMoneyPrepareUI.c(WxaLuckyMoneyPrepareUI.this), 0);
            WxaLuckyMoneyPrepareUI.this.mKeyboard.setXMode(2);
            WxaLuckyMoneyPrepareUI.this.mKeyboard.setInputEditText(this.val$hintTv);
            WxaLuckyMoneyPrepareUI.this.mKBLayout.setVisibility(0);
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
          this.val$hintTv.setOnClickListener(null);
          this.sZE.setOnClickListener(null);
          WxaLuckyMoneyPrepareUI.this.ag(WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this), 2);
          WxaLuckyMoneyPrepareUI.this.ag(WxaLuckyMoneyPrepareUI.c(WxaLuckyMoneyPrepareUI.this), 0);
          WxaLuckyMoneyPrepareUI.this.mKeyboard.setXMode(0);
          WxaLuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText)paramAnonymousView);
          WxaLuckyMoneyPrepareUI.this.mKBLayout.setVisibility(0);
          AppMethodBeat.o(64947);
        }
      });
      ((MMEditText)this.sZv.findViewById(2131301944)).setOnFocusChangeListener(new View.OnFocusChangeListener()
      {
        public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(64948);
          this.val$hintTv.setOnClickListener(null);
          this.sZE.setOnClickListener(null);
          WxaLuckyMoneyPrepareUI.this.ag(WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this), 2);
          WxaLuckyMoneyPrepareUI.this.ag(WxaLuckyMoneyPrepareUI.c(WxaLuckyMoneyPrepareUI.this), 0);
          AppMethodBeat.o(64948);
        }
      });
      localObject2 = com.tencent.mm.plugin.luckymoney.appbrand.a.g.sYd;
      if (this.sYL != h.a.sYn) {
        break label1022;
      }
      this.sZu.setMaxAmount(((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject2).sYh);
    }
    int i;
    for (;;)
    {
      this.sZu.setMinAmount(((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject2).sYg);
      this.sZt.setMaxNum(((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject2).sYe);
      localObject2 = h.a.sYn;
      this.sZt.setMinNum(1);
      this.sZu.setMaxLen(12);
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
      ((l)localObject4).Anf = new l.a()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(64960);
          int i = WxaLuckyMoneyPrepareUI.c(WxaLuckyMoneyPrepareUI.this).getInput();
          double d = WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).getInput();
          WxaLuckyMoneyPrepareUI.a(WxaLuckyMoneyPrepareUI.this, h.a.sYo);
          WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).setType(WxaLuckyMoneyPrepareUI.e(WxaLuckyMoneyPrepareUI.this));
          WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).setShowGroupIcon(false);
          WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).setTitle(WxaLuckyMoneyPrepareUI.this.getString(2131760979));
          if ((d > 0.0D) && (i > 0)) {
            WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).setAmount(e.D(d / i));
          }
          WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).setMaxAmount(com.tencent.mm.plugin.luckymoney.appbrand.a.g.sYd.sYf);
          WxaLuckyMoneyPrepareUI.g(WxaLuckyMoneyPrepareUI.this).setText(this.sZI);
          AppMethodBeat.o(64960);
        }
      };
      ((l)localObject6).Anf = new l.a()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(64961);
          int i = WxaLuckyMoneyPrepareUI.c(WxaLuckyMoneyPrepareUI.this).getInput();
          double d = WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).getInput();
          WxaLuckyMoneyPrepareUI.a(WxaLuckyMoneyPrepareUI.this, h.a.sYn);
          WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).setType(WxaLuckyMoneyPrepareUI.e(WxaLuckyMoneyPrepareUI.this));
          WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).setMaxAmount(com.tencent.mm.plugin.luckymoney.appbrand.a.g.sYd.sYh);
          WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).setTitle(WxaLuckyMoneyPrepareUI.this.getString(2131760978));
          WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).setShowGroupIcon(true);
          if ((d > 0.0D) && (i > 0)) {
            WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).setAmount(e.D(d * i));
          }
          WxaLuckyMoneyPrepareUI.g(WxaLuckyMoneyPrepareUI.this).setText(localSpannableString);
          AppMethodBeat.o(64961);
        }
      };
      this.lln.setMovementMethod(LinkMovementMethod.getInstance());
      this.lln.setText(localSpannableString);
      this.lln.setVisibility(0);
      this.sZw.setClickable(false);
      this.sZw.setEnabled(false);
      this.sZw.setOnClickListener(new v()
      {
        public final void bOU()
        {
          AppMethodBeat.i(64957);
          if (WxaLuckyMoneyPrepareUI.a(WxaLuckyMoneyPrepareUI.this) == null)
          {
            ad.e("MicroMsg.WxaLuckyMoneyPrepareUI", "Click PrepareBtn but, mLogic == null");
            AppMethodBeat.o(64957);
            return;
          }
          if (WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).cKY() != 0)
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
            if (bt.isNullOrNil(this.sZH)) {
              break label171;
            }
          }
          label171:
          for (str1 = this.sZH; WxaLuckyMoneyPrepareUI.e(WxaLuckyMoneyPrepareUI.this) == h.a.sYn; str1 = WxaLuckyMoneyPrepareUI.this.getString(2131760843))
          {
            WxaLuckyMoneyPrepareUI.a(WxaLuckyMoneyPrepareUI.this).d((int)e.F(d), i, str1, WxaLuckyMoneyPrepareUI.f(WxaLuckyMoneyPrepareUI.this));
            AppMethodBeat.o(64957);
            return;
          }
          if (WxaLuckyMoneyPrepareUI.e(WxaLuckyMoneyPrepareUI.this) == h.a.sYo) {
            WxaLuckyMoneyPrepareUI.a(WxaLuckyMoneyPrepareUI.this).e((int)e.F(d), i, str1, WxaLuckyMoneyPrepareUI.f(WxaLuckyMoneyPrepareUI.this));
          }
          AppMethodBeat.o(64957);
        }
      });
      this.sZC.a(this.sZt);
      this.sZC.a(this.sZu);
      this.sZC.a(this.sZv);
      localObject1 = (TextView)findViewById(2131301898);
      this.sZC.n((TextView)localObject1);
      if (this.sZz != null) {
        this.sZz.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(64958);
            if (paramAnonymousMotionEvent.getAction() == 0)
            {
              WxaLuckyMoneyPrepareUI.this.hideTenpayKB();
              WxaLuckyMoneyPrepareUI.this.hideVKB();
            }
            AppMethodBeat.o(64958);
            return false;
          }
        });
      }
      this.sZu.setType(this.sYL);
      addIconOptionMenu(0, 2131233032, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(64959);
          e.p(WxaLuckyMoneyPrepareUI.this.getContext(), "https://kf.qq.com/touch/scene_product.html?scene_id=kf7", false);
          AppMethodBeat.o(64959);
          return true;
        }
      });
      i = getIntent().getIntExtra("range", 0);
      ad.i("MicroMsg.WxaLuckyMoneyPrepareUI", "initRange range = %d", new Object[] { Integer.valueOf(i) });
      this.sZx.setVisibility(8);
      if (i != 0) {
        break label1036;
      }
      this.sZB = 0;
      AppMethodBeat.o(64968);
      return;
      this.sZu.setTitle(getString(2131760979));
      this.sZu.setShowGroupIcon(false);
      break;
      label1022:
      this.sZu.setMaxAmount(((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject2).sYf);
    }
    label1036:
    if (i == 1)
    {
      this.sZB = 1;
      AppMethodBeat.o(64968);
      return;
    }
    localObject1 = new ArrayList();
    ((ArrayList)localObject1).add(getString(2131766304));
    ((ArrayList)localObject1).add(getString(2131766305));
    this.sZx.setVisibility(0);
    this.sZy.setText((CharSequence)((ArrayList)localObject1).get(this.sZB));
    this.sZx.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(64963);
        paramAnonymousView = new com.tencent.mm.ui.widget.picker.c(WxaLuckyMoneyPrepareUI.this.getContext(), this.sLK);
        paramAnonymousView.aaR(WxaLuckyMoneyPrepareUI.f(WxaLuckyMoneyPrepareUI.this));
        paramAnonymousView.HIW = new c.a()
        {
          public final void onResult(boolean paramAnonymous2Boolean, Object paramAnonymous2Object1, Object paramAnonymous2Object2)
          {
            AppMethodBeat.i(64962);
            paramAnonymousView.hide();
            if (paramAnonymous2Boolean) {
              WxaLuckyMoneyPrepareUI.h(WxaLuckyMoneyPrepareUI.this).setText((CharSequence)paramAnonymous2Object1);
            }
            WxaLuckyMoneyPrepareUI.a(WxaLuckyMoneyPrepareUI.this, paramAnonymousView.ffZ());
            AppMethodBeat.o(64962);
          }
        };
        paramAnonymousView.show();
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
    this.sZs = new d();
    this.sZs.d(this, getIntent());
    AppMethodBeat.o(64966);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(64970);
    super.onDestroy();
    this.sZC.clear();
    if (this.sZs != null) {
      this.sZs.onDestroy();
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