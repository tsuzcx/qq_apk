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
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.appbrand.a.h.a;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.WxaLuckyMoneyBaseUI;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.WxaLuckyMoneyMoneyInputView;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNumInputView;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyTextInputView;
import com.tencent.mm.plugin.luckymoney.ui.b;
import com.tencent.mm.plugin.wallet_core.ui.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.wallet_core.ui.MMScrollView;
import com.tencent.mm.wallet_core.ui.e;
import com.tenpay.android.wechat.MyKeyboardWindow;
import java.util.ArrayList;

@com.tencent.mm.ui.base.a(19)
public class WxaLuckyMoneyPrepareUI
  extends WxaLuckyMoneyBaseUI
  implements c, com.tencent.mm.plugin.luckymoney.ui.g
{
  private TextView kRB;
  private TextView kRx;
  protected View mKBLayout;
  protected MyKeyboardWindow mKeyboard;
  private h.a oiY;
  private a ojF;
  private LuckyMoneyNumInputView ojG;
  private WxaLuckyMoneyMoneyInputView ojH;
  private LuckyMoneyTextInputView ojI;
  private Button ojJ;
  private LinearLayout ojK;
  private TextView ojL;
  private MMScrollView ojM;
  private TextView ojN;
  private int ojO;
  private b ojP;
  
  public WxaLuckyMoneyPrepareUI()
  {
    AppMethodBeat.i(42074);
    this.ojF = null;
    this.oiY = h.a.oiA;
    this.ojG = null;
    this.ojH = null;
    this.ojI = null;
    this.kRx = null;
    this.ojJ = null;
    this.ojO = 0;
    this.ojP = new b();
    AppMethodBeat.o(42074);
  }
  
  public final void Sp(String paramString)
  {
    AppMethodBeat.i(42076);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = getString(2131305682);
    }
    h.a(this, str, null, false, new WxaLuckyMoneyPrepareUI.1(this));
    AppMethodBeat.o(42076);
  }
  
  protected final void Z(View paramView, int paramInt)
  {
    AppMethodBeat.i(42084);
    this.mKeyboard = ((MyKeyboardWindow)findViewById(2131822419));
    this.mKBLayout = findViewById(2131822418);
    View localView = findViewById(2131822420);
    EditText localEditText = (EditText)paramView.findViewById(2131825700);
    if ((this.mKeyboard == null) || (localEditText == null) || (this.mKBLayout == null))
    {
      AppMethodBeat.o(42084);
      return;
    }
    e.setNoSystemInputOnEditText(localEditText);
    localEditText.setOnFocusChangeListener(new WxaLuckyMoneyPrepareUI.6(this, paramInt, localEditText));
    localEditText.setOnClickListener(new WxaLuckyMoneyPrepareUI.7(this, paramInt, localEditText));
    TextView localTextView = (TextView)paramView.findViewById(2131825701);
    if (localTextView != null) {
      localTextView.setOnClickListener(new WxaLuckyMoneyPrepareUI.8(this, localEditText, paramView, paramInt));
    }
    localView.setOnClickListener(new WxaLuckyMoneyPrepareUI.9(this));
    AppMethodBeat.o(42084);
  }
  
  public final MMActivity bMN()
  {
    return this;
  }
  
  public final void bMO() {}
  
  public final void bMQ()
  {
    AppMethodBeat.i(42087);
    double d4 = 0.0D;
    double d3 = 0.0D;
    double d2 = d3;
    double d1 = d4;
    int i;
    if (this.ojH.bMP() != 3)
    {
      d2 = d3;
      d1 = d4;
      if (this.ojG.bMP() != 3)
      {
        i = this.ojG.getInput();
        d4 = this.ojH.getInput();
        if (this.oiY != h.a.oiB) {
          break label162;
        }
        d1 = d4 * i;
        d2 = this.ojH.getInput();
      }
    }
    boolean bool1 = this.ojP.bNY();
    Object localObject = com.tencent.mm.plugin.luckymoney.appbrand.a.g.oiq;
    if (bool1)
    {
      ab.i("MicroMsg.WxaLuckyMoneyPrepareUI", "has error");
      this.ojJ.setClickable(false);
      this.ojJ.setEnabled(false);
    }
    for (;;)
    {
      localObject = ((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).oiw;
      if (!bo.isNullOrNil((String)localObject)) {
        break label773;
      }
      this.kRx.setText(e.F(d1));
      AppMethodBeat.o(42087);
      return;
      label162:
      d2 = d3;
      d1 = d4;
      if (i <= 0) {
        break;
      }
      d2 = this.ojH.getInput() / i;
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
          this.ojJ.setClickable(false);
          this.ojJ.setEnabled(false);
          break;
          if ((d1 > ((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).oiu) && (((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).oiu > 0.0D))
          {
            this.ojP.EC(getString(2131301332, new Object[] { Math.round(((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).oiu), bo.bf(((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).oix, "") }));
            bool1 = true;
          }
          else if (d2 > 0.0D)
          {
            ab.i("MicroMsg.WxaLuckyMoneyPrepareUI", "perAmount ".concat(String.valueOf(d2)));
            if (this.oiY == h.a.oiB)
            {
              bool1 = bool2;
              if (d2 > ((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).ois)
              {
                bool1 = bool2;
                if (((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).ois > 0.0D)
                {
                  this.ojP.EC(getString(2131301280, new Object[] { Math.round(((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).ois), bo.bf(((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).oix, "") }));
                  bool1 = true;
                }
              }
              label436:
              ab.i("MicroMsg.WxaLuckyMoneyPrepareUI", "furtherCheckHasErr:" + bool1 + " for max value");
              bool2 = bool1;
              if (!bool1)
              {
                if (this.oiY != h.a.oiB) {
                  break label684;
                }
                bool2 = bool1;
                if (d2 < ((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).oit)
                {
                  this.ojP.EC(getString(2131301282, new Object[] { e.E(((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).oit), bo.bf(((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).oix, "") }));
                  bool2 = true;
                }
              }
            }
            for (;;)
            {
              ab.i("MicroMsg.WxaLuckyMoneyPrepareUI", "furtherCheckHasErr:" + bool2 + " for min value");
              bool1 = bool2;
              break;
              bool1 = bool2;
              if (d2 <= ((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).oiv) {
                break label436;
              }
              bool1 = bool2;
              if (((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).oiv <= 0.0D) {
                break label436;
              }
              this.ojP.EC(getString(2131301280, new Object[] { Math.round(((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).oiv), bo.bf(((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).oix, "") }));
              bool1 = true;
              this.ojG.onError();
              this.ojH.onError();
              break label436;
              label684:
              bool2 = bool1;
              if (d2 < 0.01D)
              {
                this.ojP.EC(getString(2131301282, new Object[] { "0.01", bo.bf(((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).oix, "") }));
                bool2 = true;
                this.ojG.onError();
                this.ojH.onError();
              }
            }
          }
        }
      }
      this.ojJ.setClickable(true);
      this.ojJ.setEnabled(true);
    }
    label773:
    this.kRx.setText((String)localObject + e.E(d1));
    AppMethodBeat.o(42087);
  }
  
  public int getLayoutId()
  {
    return 2130971336;
  }
  
  protected final void hideTenpayKB()
  {
    AppMethodBeat.i(42086);
    if ((this.mKBLayout != null) && (this.mKBLayout.isShown())) {
      this.mKBLayout.setVisibility(8);
    }
    AppMethodBeat.o(42086);
  }
  
  public void initView()
  {
    AppMethodBeat.i(42077);
    setBackBtn(new WxaLuckyMoneyPrepareUI.10(this));
    this.ojI = ((LuckyMoneyTextInputView)findViewById(2131825789));
    this.ojI.setHintText(getString(2131301208));
    Object localObject1 = getIntent().getStringExtra("defaultWishingWord");
    ab.i("MicroMsg.WxaLuckyMoneyPrepareUI", "initView defaultWishingWord = %s", new Object[] { localObject1 });
    if (!bo.isNullOrNil((String)localObject1)) {
      this.ojI.setHintText((String)localObject1);
    }
    this.ojJ = ((Button)findViewById(2131825798));
    this.mKeyboard = ((MyKeyboardWindow)findViewById(2131822419));
    this.mKBLayout = findViewById(2131822418);
    this.kRB = ((TextView)findViewById(2131825786));
    this.ojG = ((LuckyMoneyNumInputView)findViewById(2131825787));
    this.ojH = ((WxaLuckyMoneyMoneyInputView)findViewById(2131825785));
    this.kRx = ((TextView)findViewById(2131825797));
    this.ojM = ((MMScrollView)findViewById(2131825783));
    this.ojN = ((TextView)findViewById(2131825784));
    this.ojK = ((LinearLayout)findViewById(2131829602));
    this.ojL = ((TextView)findViewById(2131829604));
    setMMTitle(2131301330);
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if (this.oiY == h.a.oiA)
    {
      this.ojH.setTitle(getString(2131301333));
      this.ojH.setShowGroupIcon(true);
      this.ojH.setOnInputValidChangerListener(this);
      this.ojH.setHint(getString(2131301253));
      this.ojG.setOnInputValidChangerListener(this);
      this.ojG.setHint(getString(2131301269));
      this.ojG.setNum("");
      this.ojI.setOnInputValidChangerListener(this);
      localObject2 = (EditText)this.ojH.findViewById(2131825700);
      localObject3 = (EditText)this.ojG.findViewById(2131825700);
      e.setNoSystemInputOnEditText((EditText)localObject2);
      ((InputMethodManager)getContext().getSystemService("input_method")).showSoftInput((View)localObject2, 0);
      ((EditText)localObject2).addTextChangedListener(new WxaLuckyMoneyPrepareUI.17(this));
      ((EditText)localObject2).setOnClickListener(new WxaLuckyMoneyPrepareUI.2(this, (EditText)localObject2, (EditText)localObject3));
      ((EditText)localObject2).requestFocus();
      localObject4 = (TextView)this.ojH.findViewById(2131825701);
      if (localObject4 != null) {
        ((TextView)localObject4).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(42055);
            this.val$hintTv.setOnClickListener(null);
            this.ojR.setOnClickListener(null);
            WxaLuckyMoneyPrepareUI.this.Z(WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this), 2);
            WxaLuckyMoneyPrepareUI.this.Z(WxaLuckyMoneyPrepareUI.c(WxaLuckyMoneyPrepareUI.this), 0);
            WxaLuckyMoneyPrepareUI.this.mKeyboard.setXMode(2);
            WxaLuckyMoneyPrepareUI.this.mKeyboard.setInputEditText(this.val$hintTv);
            WxaLuckyMoneyPrepareUI.this.mKBLayout.setVisibility(0);
            AppMethodBeat.o(42055);
          }
        });
      }
      e.setNoSystemInputOnEditText((EditText)localObject3);
      ((InputMethodManager)getContext().getSystemService("input_method")).showSoftInput((View)localObject3, 0);
      ((EditText)localObject3).setOnClickListener(new WxaLuckyMoneyPrepareUI.4(this, (EditText)localObject2, (EditText)localObject3));
      ((MMEditText)this.ojI.findViewById(2131825833)).setOnFocusChangeListener(new WxaLuckyMoneyPrepareUI.5(this, (EditText)localObject2, (EditText)localObject3));
      localObject2 = com.tencent.mm.plugin.luckymoney.appbrand.a.g.oiq;
      if (this.oiY != h.a.oiA) {
        break label1022;
      }
      this.ojH.setMaxAmount(((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject2).oiu);
    }
    int i;
    for (;;)
    {
      this.ojH.setMinAmount(((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject2).oit);
      this.ojG.setMaxNum(((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject2).oir);
      localObject2 = h.a.oiA;
      this.ojG.setMinNum(1);
      this.ojH.setMaxLen(12);
      Object localObject5 = getString(2131301225);
      Object localObject6 = getString(2131301240);
      localObject2 = getString(2131301219);
      localObject3 = getString(2131301241);
      localObject4 = new j(this);
      SpannableString localSpannableString = new SpannableString((String)localObject5 + (String)localObject6);
      localSpannableString.setSpan(localObject4, ((String)localObject5).length(), ((String)localObject5).length() + ((String)localObject6).length(), 33);
      localObject5 = new SpannableString((String)localObject2 + (String)localObject3);
      localObject6 = new j(this);
      ((SpannableString)localObject5).setSpan(localObject6, ((String)localObject2).length(), ((String)localObject2).length() + ((String)localObject3).length(), 33);
      ((j)localObject4).uqj = new WxaLuckyMoneyPrepareUI.14(this, (SpannableString)localObject5);
      ((j)localObject6).uqj = new WxaLuckyMoneyPrepareUI.15(this, localSpannableString);
      this.kRB.setMovementMethod(LinkMovementMethod.getInstance());
      this.kRB.setText(localSpannableString);
      this.kRB.setVisibility(0);
      this.ojJ.setClickable(false);
      this.ojJ.setEnabled(false);
      this.ojJ.setOnClickListener(new WxaLuckyMoneyPrepareUI.11(this, (String)localObject1));
      this.ojP.a(this.ojG);
      this.ojP.a(this.ojH);
      this.ojP.a(this.ojI);
      localObject1 = (TextView)findViewById(2131825807);
      this.ojP.i((TextView)localObject1);
      if (this.ojM != null) {
        this.ojM.setOnTouchListener(new WxaLuckyMoneyPrepareUI.12(this));
      }
      this.ojH.setType(this.oiY);
      addIconOptionMenu(0, 2130839419, new WxaLuckyMoneyPrepareUI.13(this));
      i = getIntent().getIntExtra("range", 0);
      ab.i("MicroMsg.WxaLuckyMoneyPrepareUI", "initRange range = %d", new Object[] { Integer.valueOf(i) });
      this.ojK.setVisibility(8);
      if (i != 0) {
        break label1036;
      }
      this.ojO = 0;
      AppMethodBeat.o(42077);
      return;
      this.ojH.setTitle(getString(2131301334));
      this.ojH.setShowGroupIcon(false);
      break;
      label1022:
      this.ojH.setMaxAmount(((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject2).ois);
    }
    label1036:
    if (i == 1)
    {
      this.ojO = 1;
      AppMethodBeat.o(42077);
      return;
    }
    localObject1 = new ArrayList();
    ((ArrayList)localObject1).add(getString(2131306055));
    ((ArrayList)localObject1).add(getString(2131306056));
    this.ojK.setVisibility(0);
    this.ojL.setText((CharSequence)((ArrayList)localObject1).get(this.ojO));
    this.ojK.setOnClickListener(new WxaLuckyMoneyPrepareUI.16(this, (ArrayList)localObject1));
    AppMethodBeat.o(42077);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(42081);
    setResult(0, new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{user cancel}}"));
    finish();
    AppMethodBeat.o(42081);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(42075);
    super.onCreate(paramBundle);
    initView();
    this.ojF = new d();
    this.ojF.a(this, getIntent());
    AppMethodBeat.o(42075);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(42082);
    super.onDestroy();
    this.ojP.clear();
    if (this.ojF != null) {
      this.ojF.onDestroy();
    }
    AppMethodBeat.o(42082);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(42085);
    if ((paramInt == 4) && (this.mKBLayout != null) && (this.mKBLayout.isShown()))
    {
      this.mKBLayout.setVisibility(8);
      AppMethodBeat.o(42085);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(42085);
    return bool;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyPrepareUI
 * JD-Core Version:    0.7.0.1
 */