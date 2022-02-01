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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
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
  private TextView lLe;
  protected View mKBLayout;
  protected MyKeyboardWindow mKeyboard;
  private TextView oBl;
  private h.a ugZ;
  private a uhG;
  private LuckyMoneyNumInputView uhH;
  private WxaLuckyMoneyMoneyInputView uhI;
  private LuckyMoneyTextInputView uhJ;
  private Button uhK;
  private LinearLayout uhL;
  private TextView uhM;
  private MMScrollView uhN;
  private TextView uhO;
  private int uhP;
  private b uhQ;
  
  public WxaLuckyMoneyPrepareUI()
  {
    AppMethodBeat.i(64965);
    this.uhG = null;
    this.ugZ = h.a.ugB;
    this.uhH = null;
    this.uhI = null;
    this.uhJ = null;
    this.oBl = null;
    this.uhK = null;
    this.uhP = 0;
    this.uhQ = new b();
    AppMethodBeat.o(64965);
  }
  
  protected final void ah(final View paramView, final int paramInt)
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
          new ao().postDelayed(new Runnable()
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
        new ao().postDelayed(new Runnable()
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
              new ao().postDelayed(new Runnable()
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
  
  public final MMActivity cYC()
  {
    return this;
  }
  
  public final void cYD() {}
  
  public final void cYF()
  {
    AppMethodBeat.i(64974);
    double d4 = 0.0D;
    double d3 = 0.0D;
    double d2 = d3;
    double d1 = d4;
    int i;
    if (this.uhI.cYE() != 3)
    {
      d2 = d3;
      d1 = d4;
      if (this.uhH.cYE() != 3)
      {
        i = this.uhH.getInput();
        d4 = this.uhI.getInput();
        if (this.ugZ != h.a.ugC) {
          break label162;
        }
        d1 = d4 * i;
        d2 = this.uhI.getInput();
      }
    }
    boolean bool1 = this.uhQ.dac();
    Object localObject = com.tencent.mm.plugin.luckymoney.appbrand.a.g.ugr;
    if (bool1)
    {
      ac.i("MicroMsg.WxaLuckyMoneyPrepareUI", "has error");
      this.uhK.setClickable(false);
      this.uhK.setEnabled(false);
    }
    for (;;)
    {
      localObject = ((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).ugx;
      if (!bs.isNullOrNil((String)localObject)) {
        break label773;
      }
      this.oBl.setText(e.D(d1));
      AppMethodBeat.o(64974);
      return;
      label162:
      d2 = d3;
      d1 = d4;
      if (i <= 0) {
        break;
      }
      d2 = this.uhI.getInput() / i;
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
          this.uhK.setClickable(false);
          this.uhK.setEnabled(false);
          break;
          if ((d1 > ((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).ugv) && (((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).ugv > 0.0D))
          {
            this.uhQ.Qr(getString(2131760977, new Object[] { Math.round(((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).ugv), bs.bG(((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).ugy, "") }));
            bool1 = true;
          }
          else if (d2 > 0.0D)
          {
            ac.i("MicroMsg.WxaLuckyMoneyPrepareUI", "perAmount ".concat(String.valueOf(d2)));
            if (this.ugZ == h.a.ugC)
            {
              bool1 = bool2;
              if (d2 > ((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).ugt)
              {
                bool1 = bool2;
                if (((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).ugt > 0.0D)
                {
                  this.uhQ.Qr(getString(2131760922, new Object[] { Math.round(((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).ugt), bs.bG(((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).ugy, "") }));
                  bool1 = true;
                }
              }
              label436:
              ac.i("MicroMsg.WxaLuckyMoneyPrepareUI", "furtherCheckHasErr:" + bool1 + " for max value");
              bool2 = bool1;
              if (!bool1)
              {
                if (this.ugZ != h.a.ugC) {
                  break label684;
                }
                bool2 = bool1;
                if (d2 < ((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).ugu)
                {
                  this.uhQ.Qr(getString(2131760924, new Object[] { e.C(((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).ugu), bs.bG(((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).ugy, "") }));
                  bool2 = true;
                }
              }
            }
            for (;;)
            {
              ac.i("MicroMsg.WxaLuckyMoneyPrepareUI", "furtherCheckHasErr:" + bool2 + " for min value");
              bool1 = bool2;
              break;
              bool1 = bool2;
              if (d2 <= ((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).ugw) {
                break label436;
              }
              bool1 = bool2;
              if (((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).ugw <= 0.0D) {
                break label436;
              }
              this.uhQ.Qr(getString(2131760922, new Object[] { Math.round(((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).ugw), bs.bG(((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).ugy, "") }));
              bool1 = true;
              this.uhH.onError();
              this.uhI.onError();
              break label436;
              label684:
              bool2 = bool1;
              if (d2 < 0.01D)
              {
                this.uhQ.Qr(getString(2131760924, new Object[] { "0.01", bs.bG(((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).ugy, "") }));
                bool2 = true;
                this.uhH.onError();
                this.uhI.onError();
              }
            }
          }
        }
      }
      this.uhK.setClickable(true);
      this.uhK.setEnabled(true);
    }
    label773:
    this.oBl.setText((String)localObject + e.C(d1));
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
    this.uhJ = ((LuckyMoneyTextInputView)findViewById(2131301959));
    this.uhJ.setHintText(getString(2131760843));
    Object localObject1 = getIntent().getStringExtra("defaultWishingWord");
    ac.i("MicroMsg.WxaLuckyMoneyPrepareUI", "initView defaultWishingWord = %s", new Object[] { localObject1 });
    if (!bs.isNullOrNil((String)localObject1)) {
      this.uhJ.setHintText((String)localObject1);
    }
    this.uhK = ((Button)findViewById(2131301896));
    this.mKeyboard = ((MyKeyboardWindow)findViewById(2131305695));
    this.mKBLayout = findViewById(2131305693);
    this.lLe = ((TextView)findViewById(2131301894));
    this.uhH = ((LuckyMoneyNumInputView)findViewById(2131301891));
    this.uhI = ((WxaLuckyMoneyMoneyInputView)findViewById(2131301715));
    this.oBl = ((TextView)findViewById(2131301909));
    this.uhN = ((MMScrollView)findViewById(2131301943));
    this.uhO = ((TextView)findViewById(2131301901));
    this.uhL = ((LinearLayout)findViewById(2131301911));
    this.uhM = ((TextView)findViewById(2131301912));
    setMMTitle(2131760975);
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if (this.ugZ == h.a.ugB)
    {
      this.uhI.setTitle(getString(2131760978));
      this.uhI.setShowGroupIcon(true);
      this.uhI.setOnInputValidChangerListener(this);
      this.uhI.setHint(getString(2131760895));
      this.uhH.setOnInputValidChangerListener(this);
      this.uhH.setHint(getString(2131760911));
      this.uhH.setNum("");
      this.uhJ.setOnInputValidChangerListener(this);
      localObject2 = (EditText)this.uhI.findViewById(2131301810);
      localObject3 = (EditText)this.uhH.findViewById(2131301810);
      e.setNoSystemInputOnEditText((EditText)localObject2);
      ((InputMethodManager)getContext().getSystemService("input_method")).showSoftInput((View)localObject2, 0);
      ((EditText)localObject2).addTextChangedListener(new WxaLuckyMoneyPrepareUI.17(this));
      ((EditText)localObject2).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(64945);
          this.val$hintTv.setOnClickListener(null);
          this.uhS.setOnClickListener(null);
          WxaLuckyMoneyPrepareUI.this.ah(WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this), 2);
          WxaLuckyMoneyPrepareUI.this.ah(WxaLuckyMoneyPrepareUI.c(WxaLuckyMoneyPrepareUI.this), 0);
          WxaLuckyMoneyPrepareUI.this.mKeyboard.setXMode(2);
          WxaLuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText)paramAnonymousView);
          WxaLuckyMoneyPrepareUI.this.mKBLayout.setVisibility(0);
          AppMethodBeat.o(64945);
        }
      });
      ((EditText)localObject2).requestFocus();
      localObject4 = (TextView)this.uhI.findViewById(2131301716);
      if (localObject4 != null) {
        ((TextView)localObject4).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(64946);
            this.val$hintTv.setOnClickListener(null);
            this.uhS.setOnClickListener(null);
            WxaLuckyMoneyPrepareUI.this.ah(WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this), 2);
            WxaLuckyMoneyPrepareUI.this.ah(WxaLuckyMoneyPrepareUI.c(WxaLuckyMoneyPrepareUI.this), 0);
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
          this.uhS.setOnClickListener(null);
          WxaLuckyMoneyPrepareUI.this.ah(WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this), 2);
          WxaLuckyMoneyPrepareUI.this.ah(WxaLuckyMoneyPrepareUI.c(WxaLuckyMoneyPrepareUI.this), 0);
          WxaLuckyMoneyPrepareUI.this.mKeyboard.setXMode(0);
          WxaLuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText)paramAnonymousView);
          WxaLuckyMoneyPrepareUI.this.mKBLayout.setVisibility(0);
          AppMethodBeat.o(64947);
        }
      });
      ((MMEditText)this.uhJ.findViewById(2131301944)).setOnFocusChangeListener(new View.OnFocusChangeListener()
      {
        public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(64948);
          this.val$hintTv.setOnClickListener(null);
          this.uhS.setOnClickListener(null);
          WxaLuckyMoneyPrepareUI.this.ah(WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this), 2);
          WxaLuckyMoneyPrepareUI.this.ah(WxaLuckyMoneyPrepareUI.c(WxaLuckyMoneyPrepareUI.this), 0);
          AppMethodBeat.o(64948);
        }
      });
      localObject2 = com.tencent.mm.plugin.luckymoney.appbrand.a.g.ugr;
      if (this.ugZ != h.a.ugB) {
        break label1022;
      }
      this.uhI.setMaxAmount(((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject2).ugv);
    }
    int i;
    for (;;)
    {
      this.uhI.setMinAmount(((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject2).ugu);
      this.uhH.setMaxNum(((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject2).ugs);
      localObject2 = h.a.ugB;
      this.uhH.setMinNum(1);
      this.uhI.setMaxLen(12);
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
      ((l)localObject4).BFA = new l.a()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(64960);
          int i = WxaLuckyMoneyPrepareUI.c(WxaLuckyMoneyPrepareUI.this).getInput();
          double d = WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).getInput();
          WxaLuckyMoneyPrepareUI.a(WxaLuckyMoneyPrepareUI.this, h.a.ugC);
          WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).setType(WxaLuckyMoneyPrepareUI.e(WxaLuckyMoneyPrepareUI.this));
          WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).setShowGroupIcon(false);
          WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).setTitle(WxaLuckyMoneyPrepareUI.this.getString(2131760979));
          if ((d > 0.0D) && (i > 0)) {
            WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).setAmount(e.C(d / i));
          }
          WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).setMaxAmount(com.tencent.mm.plugin.luckymoney.appbrand.a.g.ugr.ugt);
          WxaLuckyMoneyPrepareUI.g(WxaLuckyMoneyPrepareUI.this).setText(this.uhW);
          AppMethodBeat.o(64960);
        }
      };
      ((l)localObject6).BFA = new l.a()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(64961);
          int i = WxaLuckyMoneyPrepareUI.c(WxaLuckyMoneyPrepareUI.this).getInput();
          double d = WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).getInput();
          WxaLuckyMoneyPrepareUI.a(WxaLuckyMoneyPrepareUI.this, h.a.ugB);
          WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).setType(WxaLuckyMoneyPrepareUI.e(WxaLuckyMoneyPrepareUI.this));
          WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).setMaxAmount(com.tencent.mm.plugin.luckymoney.appbrand.a.g.ugr.ugv);
          WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).setTitle(WxaLuckyMoneyPrepareUI.this.getString(2131760978));
          WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).setShowGroupIcon(true);
          if ((d > 0.0D) && (i > 0)) {
            WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).setAmount(e.C(d * i));
          }
          WxaLuckyMoneyPrepareUI.g(WxaLuckyMoneyPrepareUI.this).setText(localSpannableString);
          AppMethodBeat.o(64961);
        }
      };
      this.lLe.setMovementMethod(LinkMovementMethod.getInstance());
      this.lLe.setText(localSpannableString);
      this.lLe.setVisibility(0);
      this.uhK.setClickable(false);
      this.uhK.setEnabled(false);
      this.uhK.setOnClickListener(new w()
      {
        public final void bWk()
        {
          AppMethodBeat.i(64957);
          if (WxaLuckyMoneyPrepareUI.a(WxaLuckyMoneyPrepareUI.this) == null)
          {
            ac.e("MicroMsg.WxaLuckyMoneyPrepareUI", "Click PrepareBtn but, mLogic == null");
            AppMethodBeat.o(64957);
            return;
          }
          if (WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).cYE() != 0)
          {
            t.makeText(WxaLuckyMoneyPrepareUI.this.getContext(), 2131765031, 0).show();
            AppMethodBeat.o(64957);
            return;
          }
          int i = WxaLuckyMoneyPrepareUI.c(WxaLuckyMoneyPrepareUI.this).getInput();
          double d = WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).getInput();
          String str2 = WxaLuckyMoneyPrepareUI.d(WxaLuckyMoneyPrepareUI.this).getInput();
          String str1 = str2;
          if (bs.isNullOrNil(str2)) {
            if (bs.isNullOrNil(this.uhV)) {
              break label171;
            }
          }
          label171:
          for (str1 = this.uhV; WxaLuckyMoneyPrepareUI.e(WxaLuckyMoneyPrepareUI.this) == h.a.ugB; str1 = WxaLuckyMoneyPrepareUI.this.getString(2131760843))
          {
            WxaLuckyMoneyPrepareUI.a(WxaLuckyMoneyPrepareUI.this).c((int)e.E(d), i, str1, WxaLuckyMoneyPrepareUI.f(WxaLuckyMoneyPrepareUI.this));
            AppMethodBeat.o(64957);
            return;
          }
          if (WxaLuckyMoneyPrepareUI.e(WxaLuckyMoneyPrepareUI.this) == h.a.ugC) {
            WxaLuckyMoneyPrepareUI.a(WxaLuckyMoneyPrepareUI.this).d((int)e.E(d), i, str1, WxaLuckyMoneyPrepareUI.f(WxaLuckyMoneyPrepareUI.this));
          }
          AppMethodBeat.o(64957);
        }
      });
      this.uhQ.a(this.uhH);
      this.uhQ.a(this.uhI);
      this.uhQ.a(this.uhJ);
      localObject1 = (TextView)findViewById(2131301898);
      this.uhQ.n((TextView)localObject1);
      if (this.uhN != null) {
        this.uhN.setOnTouchListener(new View.OnTouchListener()
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
      this.uhI.setType(this.ugZ);
      addIconOptionMenu(0, 2131233032, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(64959);
          e.o(WxaLuckyMoneyPrepareUI.this.getContext(), "https://kf.qq.com/touch/scene_product.html?scene_id=kf7", false);
          AppMethodBeat.o(64959);
          return true;
        }
      });
      i = getIntent().getIntExtra("range", 0);
      ac.i("MicroMsg.WxaLuckyMoneyPrepareUI", "initRange range = %d", new Object[] { Integer.valueOf(i) });
      this.uhL.setVisibility(8);
      if (i != 0) {
        break label1036;
      }
      this.uhP = 0;
      AppMethodBeat.o(64968);
      return;
      this.uhI.setTitle(getString(2131760979));
      this.uhI.setShowGroupIcon(false);
      break;
      label1022:
      this.uhI.setMaxAmount(((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject2).ugt);
    }
    label1036:
    if (i == 1)
    {
      this.uhP = 1;
      AppMethodBeat.o(64968);
      return;
    }
    localObject1 = new ArrayList();
    ((ArrayList)localObject1).add(getString(2131766304));
    ((ArrayList)localObject1).add(getString(2131766305));
    this.uhL.setVisibility(0);
    this.uhM.setText((CharSequence)((ArrayList)localObject1).get(this.uhP));
    this.uhL.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(64963);
        paramAnonymousView = new com.tencent.mm.ui.widget.picker.c(WxaLuckyMoneyPrepareUI.this.getContext(), this.tTp);
        paramAnonymousView.adc(WxaLuckyMoneyPrepareUI.f(WxaLuckyMoneyPrepareUI.this));
        paramAnonymousView.Jjt = new c.a()
        {
          public final void onResult(boolean paramAnonymous2Boolean, Object paramAnonymous2Object1, Object paramAnonymous2Object2)
          {
            AppMethodBeat.i(64962);
            paramAnonymousView.hide();
            if (paramAnonymous2Boolean) {
              WxaLuckyMoneyPrepareUI.h(WxaLuckyMoneyPrepareUI.this).setText((CharSequence)paramAnonymous2Object1);
            }
            WxaLuckyMoneyPrepareUI.a(WxaLuckyMoneyPrepareUI.this, paramAnonymousView.fvY());
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
    this.uhG = new d();
    this.uhG.d(this, getIntent());
    AppMethodBeat.o(64966);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(64970);
    super.onDestroy();
    this.uhQ.clear();
    if (this.uhG != null) {
      this.uhG.onDestroy();
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