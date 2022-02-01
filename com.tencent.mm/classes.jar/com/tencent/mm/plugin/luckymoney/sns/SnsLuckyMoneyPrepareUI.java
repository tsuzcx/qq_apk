package com.tencent.mm.plugin.luckymoney.sns;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.luckymoney.model.ai;
import com.tencent.mm.plugin.luckymoney.model.aq;
import com.tencent.mm.plugin.luckymoney.model.at;
import com.tencent.mm.plugin.luckymoney.model.j;
import com.tencent.mm.plugin.luckymoney.model.k;
import com.tencent.mm.plugin.luckymoney.model.r;
import com.tencent.mm.plugin.luckymoney.model.z;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyCanShareListUI;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyIndexUI;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMoneyInputView;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMyRecordUI;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNumInputView;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyTextInputView;
import com.tencent.mm.plugin.luckymoney.ui.b;
import com.tencent.mm.plugin.luckymoney.ui.h.c;
import com.tencent.mm.plugin.wallet_core.ui.l;
import com.tencent.mm.plugin.wallet_core.ui.l.a;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.base.t;
import com.tenpay.android.wechat.MyKeyboardWindow;
import java.util.Map;

@com.tencent.mm.ui.base.a(19)
public class SnsLuckyMoneyPrepareUI
  extends LuckyMoneyBaseUI
  implements com.tencent.mm.plugin.luckymoney.ui.g
{
  private au iRv;
  private ScrollView kqh;
  private TextView lLe;
  private int mChannel;
  protected View mKBLayout;
  protected MyKeyboardWindow mKeyboard;
  private com.tencent.mm.wallet_core.ui.a mTenpayKBStateListener;
  private int mType;
  protected TextView oBl;
  protected Button pkJ;
  protected Dialog tipDialog;
  private j ugW;
  protected LuckyMoneyNumInputView uhH;
  protected LuckyMoneyTextInputView uhJ;
  protected Button uhK;
  private TextView uhO;
  private b uhQ;
  protected LuckyMoneyMoneyInputView uoX;
  private View uoY;
  private View uoZ;
  private ViewGroup upa;
  private int upb;
  private String upc;
  private int upd;
  private boolean upe;
  private String upf;
  
  public SnsLuckyMoneyPrepareUI()
  {
    AppMethodBeat.i(65387);
    this.uhH = null;
    this.uoX = null;
    this.uhJ = null;
    this.oBl = null;
    this.uhK = null;
    this.pkJ = null;
    this.tipDialog = null;
    this.uhQ = new b();
    this.iRv = null;
    AppMethodBeat.o(65387);
  }
  
  private int cZv()
  {
    AppMethodBeat.i(65398);
    if (this.upe)
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
  
  protected final void ah(View paramView, final int paramInt)
  {
    AppMethodBeat.i(65394);
    this.mKeyboard = ((MyKeyboardWindow)findViewById(2131305695));
    this.mKBLayout = findViewById(2131305693);
    View localView = findViewById(2131305696);
    final EditText localEditText = (EditText)paramView.findViewById(2131301810);
    if ((this.mKeyboard == null) || (localEditText == null) || (this.mKBLayout == null))
    {
      AppMethodBeat.o(65394);
      return;
    }
    com.tencent.mm.wallet_core.ui.e.setNoSystemInputOnEditText(localEditText);
    localEditText.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public final void onFocusChange(final View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(65374);
        if ((paramAnonymousView.isFocused()) && (!this.val$isShowSysKB))
        {
          ((InputMethodManager)SnsLuckyMoneyPrepareUI.this.getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramAnonymousView.getWindowToken(), 0);
          new ao().postDelayed(new Runnable()
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
        new ao().postDelayed(new Runnable()
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
        if ((!SnsLuckyMoneyPrepareUI.this.mKBLayout.isShown()) && (!this.val$isShowSysKB))
        {
          SnsLuckyMoneyPrepareUI.k(SnsLuckyMoneyPrepareUI.this);
          SnsLuckyMoneyPrepareUI.b(SnsLuckyMoneyPrepareUI.this, paramInt);
          AppMethodBeat.o(65376);
          return;
        }
        if (this.val$isShowSysKB)
        {
          SnsLuckyMoneyPrepareUI.this.hideTenpayKB();
          ((InputMethodManager)SnsLuckyMoneyPrepareUI.this.getContext().getSystemService("input_method")).showSoftInput(localEditText, 0);
        }
        AppMethodBeat.o(65376);
      }
    });
    paramView = (TextView)paramView.findViewById(2131301716);
    if (paramView != null) {
      paramView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(65377);
          if ((!SnsLuckyMoneyPrepareUI.this.mKBLayout.isShown()) && (!this.val$isShowSysKB))
          {
            SnsLuckyMoneyPrepareUI.k(SnsLuckyMoneyPrepareUI.this);
            SnsLuckyMoneyPrepareUI.b(SnsLuckyMoneyPrepareUI.this, paramInt);
            AppMethodBeat.o(65377);
            return;
          }
          if (this.val$isShowSysKB)
          {
            SnsLuckyMoneyPrepareUI.this.hideTenpayKB();
            ((InputMethodManager)SnsLuckyMoneyPrepareUI.this.getContext().getSystemService("input_method")).showSoftInput(localEditText, 0);
          }
          AppMethodBeat.o(65377);
        }
      });
    }
    localView.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(65378);
        SnsLuckyMoneyPrepareUI.this.hideTenpayKB();
        AppMethodBeat.o(65378);
      }
    });
    AppMethodBeat.o(65394);
  }
  
  public final void cYF()
  {
    AppMethodBeat.i(65397);
    com.tencent.mm.plugin.luckymoney.b.a.cYv();
    this.ugW = com.tencent.mm.plugin.luckymoney.b.a.cYw().cYZ();
    int i;
    double d2;
    double d1;
    if ((this.uoX.cYE() != 3) && (this.uhH.cYE() != 3))
    {
      i = this.uhH.getInput();
      d2 = this.uoX.getInput();
      if (this.mType == 0)
      {
        d2 *= i;
        d1 = this.uoX.getInput();
      }
    }
    for (;;)
    {
      if (this.uhQ.dac())
      {
        this.uhK.setClickable(false);
        this.uhK.setEnabled(false);
        this.oBl.setText(com.tencent.mm.wallet_core.ui.e.D(d2));
        AppMethodBeat.o(65397);
        return;
        if (i > 0) {
          d1 = this.uoX.getInput() / i;
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
            this.uhK.setClickable(false);
            this.uhK.setEnabled(false);
            break;
            if ((d2 > this.ugW.ugv) && (this.ugW.ugv > 0.0D))
            {
              this.uhQ.Qr(getString(2131760977, new Object[] { Math.round(this.ugW.ugv), bs.bG(this.ugW.ugy, "") }));
              i = 1;
              continue;
            }
            if (d1 <= 0.0D) {
              break label650;
            }
            if (this.mType == 0)
            {
              if ((d1 <= this.ugW.ugt) || (this.ugW.ugt <= 0.0D)) {
                break label644;
              }
              this.uhQ.Qr(getString(2131760922, new Object[] { Math.round(this.ugW.ugt), bs.bG(this.ugW.ugy, "") }));
              i = 1;
            }
          }
          for (;;)
          {
            if (i == 0)
            {
              if (this.mType == 0)
              {
                if (d1 >= this.ugW.ugu) {
                  break label641;
                }
                this.uhQ.Qr(getString(2131760924, new Object[] { com.tencent.mm.wallet_core.ui.e.C(this.ugW.ugu), bs.bG(this.ugW.ugy, "") }));
                i = 1;
                break label159;
                if ((d1 <= this.ugW.ugw) || (this.ugW.ugw <= 0.0D)) {
                  break label644;
                }
                this.uhQ.Qr(getString(2131760922, new Object[] { Math.round(this.ugW.ugw), bs.bG(this.ugW.ugy, "") }));
                this.uhH.onError();
                this.uoX.onError();
                i = 1;
                continue;
              }
              if (d1 < 0.01D)
              {
                this.uhQ.Qr(getString(2131760924, new Object[] { "0.01", bs.bG(this.ugW.ugy, "") }));
                this.uhH.onError();
                this.uoX.onError();
                i = 1;
                break label159;
                this.uhK.setClickable(true);
                this.uhK.setEnabled(true);
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
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(65391);
    if ((paramKeyEvent.getKeyCode() == 4) && (this.uoY.getVisibility() == 0))
    {
      this.uoY.setVisibility(8);
      cZR();
      AppMethodBeat.o(65391);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(65391);
    return bool;
  }
  
  public int getLayoutId()
  {
    return 2131494656;
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
    getResources().getDrawable(2131232950);
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
    this.uoY = findViewById(2131301905);
    this.uoZ = findViewById(2131301908);
    this.pkJ = ((Button)findViewById(2131301907));
    this.uhJ = ((LuckyMoneyTextInputView)findViewById(2131301959));
    this.uhJ.setHintText(getString(2131760843));
    this.uhK = ((Button)findViewById(2131301896));
    this.mKeyboard = ((MyKeyboardWindow)findViewById(2131305695));
    this.mKBLayout = findViewById(2131305693);
    this.lLe = ((TextView)findViewById(2131301894));
    this.uhH = ((LuckyMoneyNumInputView)findViewById(2131301891));
    this.uoX = ((LuckyMoneyMoneyInputView)findViewById(2131301715));
    this.oBl = ((TextView)findViewById(2131301909));
    this.upa = ((ViewGroup)findViewById(2131301903));
    this.kqh = ((ScrollView)findViewById(2131301943));
    this.uhO = ((TextView)findViewById(2131301901));
    Object localObject1;
    if (this.mType == 1)
    {
      this.uoX.setTitle(getString(2131760978));
      this.uoX.setShowGroupIcon(true);
      this.uoX.setOnInputValidChangerListener(this);
      this.uhH.setOnInputValidChangerListener(this);
      this.uhJ.setOnInputValidChangerListener(this);
      localObject1 = (EditText)this.uoX.findViewById(2131301810);
      Object localObject2 = (EditText)this.uhH.findViewById(2131301810);
      com.tencent.mm.wallet_core.ui.e.setNoSystemInputOnEditText((EditText)localObject1);
      ((InputMethodManager)getContext().getSystemService("input_method")).showSoftInput((View)localObject1, 0);
      ((EditText)localObject1).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(65384);
          this.val$hintTv.setOnClickListener(null);
          this.uhS.setOnClickListener(null);
          SnsLuckyMoneyPrepareUI.this.ah(SnsLuckyMoneyPrepareUI.this.uoX, 2);
          SnsLuckyMoneyPrepareUI.this.ah(SnsLuckyMoneyPrepareUI.this.uhH, 0);
          SnsLuckyMoneyPrepareUI.this.mKeyboard.setXMode(2);
          SnsLuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText)paramAnonymousView);
          SnsLuckyMoneyPrepareUI.k(SnsLuckyMoneyPrepareUI.this);
          AppMethodBeat.o(65384);
        }
      });
      Object localObject3 = (TextView)this.uoX.findViewById(2131301716);
      if (localObject3 != null) {
        ((TextView)localObject3).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(65385);
            this.val$hintTv.setOnClickListener(null);
            this.uhS.setOnClickListener(null);
            SnsLuckyMoneyPrepareUI.this.ah(SnsLuckyMoneyPrepareUI.this.uoX, 2);
            SnsLuckyMoneyPrepareUI.this.ah(SnsLuckyMoneyPrepareUI.this.uhH, 0);
            SnsLuckyMoneyPrepareUI.this.mKeyboard.setXMode(2);
            SnsLuckyMoneyPrepareUI.k(SnsLuckyMoneyPrepareUI.this);
            AppMethodBeat.o(65385);
          }
        });
      }
      com.tencent.mm.wallet_core.ui.e.setNoSystemInputOnEditText((EditText)localObject2);
      ((InputMethodManager)getContext().getSystemService("input_method")).showSoftInput((View)localObject2, 0);
      ((EditText)localObject2).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(65386);
          this.val$hintTv.setOnClickListener(null);
          this.uhS.setOnClickListener(null);
          SnsLuckyMoneyPrepareUI.this.ah(SnsLuckyMoneyPrepareUI.this.uoX, 2);
          SnsLuckyMoneyPrepareUI.this.ah(SnsLuckyMoneyPrepareUI.this.uhH, 0);
          SnsLuckyMoneyPrepareUI.this.mKeyboard.setXMode(0);
          SnsLuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText)paramAnonymousView);
          SnsLuckyMoneyPrepareUI.k(SnsLuckyMoneyPrepareUI.this);
          AppMethodBeat.o(65386);
        }
      });
      if (this.ugW != null)
      {
        if (this.mType != 1) {
          break label1032;
        }
        this.uoX.setMaxAmount(this.ugW.ugv);
        label443:
        this.uoX.setMinAmount(this.ugW.ugu);
      }
      if ((!this.upe) || (getIntent().getIntExtra("key_chatroom_num", 0) > 1)) {
        break label1049;
      }
      this.uhH.setNum("1");
      label488:
      this.uhH.setMaxNum(this.ugW.ugs);
      this.uhH.setMinNum(1);
      ac.d("MicroMsg.LuckyMoneyPrepareUI", "init num=" + this.uhH.getInput());
      this.uoX.setMaxLen(12);
      if (!this.upe) {
        break label1074;
      }
      if (getIntent().getIntExtra("key_chatroom_num", 0) <= 0) {
        break label1062;
      }
      Object localObject4 = getString(2131760885);
      Object localObject5 = getString(2131760882);
      localObject1 = getString(2131760884);
      localObject2 = getString(2131760883);
      localObject3 = new SpannableString((String)localObject4 + (String)localObject5);
      l locall = new l(this);
      ((SpannableString)localObject3).setSpan(locall, ((String)localObject4).length(), ((String)localObject4).length() + ((String)localObject5).length(), 33);
      localObject4 = new SpannableString((String)localObject1 + (String)localObject2);
      localObject5 = new l(this);
      ((SpannableString)localObject4).setSpan(localObject5, ((String)localObject1).length(), ((String)localObject1).length() + ((String)localObject2).length(), 33);
      locall.BFA = new l.a()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(65375);
          int i = SnsLuckyMoneyPrepareUI.this.uhH.getInput();
          double d = SnsLuckyMoneyPrepareUI.this.uoX.getInput();
          SnsLuckyMoneyPrepareUI.a(SnsLuckyMoneyPrepareUI.this, 0);
          SnsLuckyMoneyPrepareUI.this.uoX.setType(SnsLuckyMoneyPrepareUI.a(SnsLuckyMoneyPrepareUI.this));
          SnsLuckyMoneyPrepareUI.this.uoX.setShowGroupIcon(false);
          SnsLuckyMoneyPrepareUI.this.uoX.setTitle(SnsLuckyMoneyPrepareUI.this.getString(2131760979));
          if ((d > 0.0D) && (i > 0)) {
            SnsLuckyMoneyPrepareUI.this.uoX.setAmount(com.tencent.mm.wallet_core.ui.e.C(d / i));
          }
          SnsLuckyMoneyPrepareUI.this.uoX.setMaxAmount(SnsLuckyMoneyPrepareUI.b(SnsLuckyMoneyPrepareUI.this).ugt);
          SnsLuckyMoneyPrepareUI.c(SnsLuckyMoneyPrepareUI.this).setText(this.uhW);
          com.tencent.mm.plugin.report.service.h.wUl.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(SnsLuckyMoneyPrepareUI.d(SnsLuckyMoneyPrepareUI.this)), Integer.valueOf(3) });
          AppMethodBeat.o(65375);
        }
      };
      ((l)localObject5).BFA = new l.a()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(65379);
          int i = SnsLuckyMoneyPrepareUI.this.uhH.getInput();
          double d = SnsLuckyMoneyPrepareUI.this.uoX.getInput();
          SnsLuckyMoneyPrepareUI.a(SnsLuckyMoneyPrepareUI.this, 1);
          SnsLuckyMoneyPrepareUI.this.uoX.setType(SnsLuckyMoneyPrepareUI.a(SnsLuckyMoneyPrepareUI.this));
          SnsLuckyMoneyPrepareUI.this.uoX.setTitle(SnsLuckyMoneyPrepareUI.this.getString(2131760978));
          SnsLuckyMoneyPrepareUI.this.uoX.setShowGroupIcon(true);
          if ((d > 0.0D) && (i > 0)) {
            SnsLuckyMoneyPrepareUI.this.uoX.setAmount(com.tencent.mm.wallet_core.ui.e.C(d * i));
          }
          SnsLuckyMoneyPrepareUI.this.uoX.setMaxAmount(SnsLuckyMoneyPrepareUI.b(SnsLuckyMoneyPrepareUI.this).ugv);
          SnsLuckyMoneyPrepareUI.c(SnsLuckyMoneyPrepareUI.this).setText(this.uhX);
          com.tencent.mm.plugin.report.service.h.wUl.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(SnsLuckyMoneyPrepareUI.d(SnsLuckyMoneyPrepareUI.this)), Integer.valueOf(2) });
          AppMethodBeat.o(65379);
        }
      };
      this.lLe.setMovementMethod(LinkMovementMethod.getInstance());
      this.lLe.setText((CharSequence)localObject3);
      this.lLe.setVisibility(0);
    }
    for (;;)
    {
      this.uhK.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(65381);
          com.tencent.mm.plugin.report.service.h.wUl.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(SnsLuckyMoneyPrepareUI.d(SnsLuckyMoneyPrepareUI.this)), Integer.valueOf(4) });
          if (SnsLuckyMoneyPrepareUI.this.uoX.cYE() != 0)
          {
            t.makeText(SnsLuckyMoneyPrepareUI.this.getContext(), 2131765031, 0).show();
            AppMethodBeat.o(65381);
            return;
          }
          int i = SnsLuckyMoneyPrepareUI.this.uhH.getInput();
          double d = SnsLuckyMoneyPrepareUI.this.uoX.getInput();
          long l2 = 0L;
          long l1;
          String str;
          if (SnsLuckyMoneyPrepareUI.a(SnsLuckyMoneyPrepareUI.this) == 1)
          {
            l1 = com.tencent.mm.wallet_core.ui.e.E(d);
            com.tencent.mm.kernel.g.agS();
            com.tencent.mm.kernel.g.agR().agA().set(356354, Integer.valueOf(i));
            str = SnsLuckyMoneyPrepareUI.this.uhJ.getInput();
            paramAnonymousView = str;
            if (bs.isNullOrNil(str)) {
              paramAnonymousView = SnsLuckyMoneyPrepareUI.this.getString(2131760843);
            }
            str = SnsLuckyMoneyPrepareUI.this.getIntent().getStringExtra("key_username");
            if ((!SnsLuckyMoneyPrepareUI.e(SnsLuckyMoneyPrepareUI.this)) || (bs.isNullOrNil(str))) {
              break label343;
            }
          }
          label343:
          for (paramAnonymousView = new aq(i, l1, l2, SnsLuckyMoneyPrepareUI.a(SnsLuckyMoneyPrepareUI.this), paramAnonymousView, z.cZe(), str, z.wj(str), com.tencent.mm.model.u.axw(), com.tencent.mm.model.u.axy(), SnsLuckyMoneyPrepareUI.f(SnsLuckyMoneyPrepareUI.this), "");; paramAnonymousView = new aq(i, l1, l2, SnsLuckyMoneyPrepareUI.a(SnsLuckyMoneyPrepareUI.this), paramAnonymousView, z.cZe(), null, null, com.tencent.mm.model.u.axw(), com.tencent.mm.model.u.axy(), SnsLuckyMoneyPrepareUI.f(SnsLuckyMoneyPrepareUI.this), ""))
          {
            SnsLuckyMoneyPrepareUI.this.doSceneProgress(paramAnonymousView, false);
            if (SnsLuckyMoneyPrepareUI.this.tipDialog == null) {
              break label388;
            }
            SnsLuckyMoneyPrepareUI.this.tipDialog.show();
            AppMethodBeat.o(65381);
            return;
            l1 = com.tencent.mm.wallet_core.ui.e.E(i * d);
            l2 = com.tencent.mm.wallet_core.ui.e.E(d);
            com.tencent.mm.kernel.g.agS();
            com.tencent.mm.kernel.g.agR().agA().set(356353, Integer.valueOf(i));
            break;
          }
          label388:
          SnsLuckyMoneyPrepareUI.this.tipDialog = com.tencent.mm.wallet_core.ui.g.a(SnsLuckyMoneyPrepareUI.this.getContext(), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(65380);
              if ((SnsLuckyMoneyPrepareUI.this.tipDialog != null) && (SnsLuckyMoneyPrepareUI.this.tipDialog.isShowing())) {
                SnsLuckyMoneyPrepareUI.this.tipDialog.hide();
              }
              if ((SnsLuckyMoneyPrepareUI.g(SnsLuckyMoneyPrepareUI.this).getVisibility() == 8) || (SnsLuckyMoneyPrepareUI.h(SnsLuckyMoneyPrepareUI.this).getVisibility() == 4))
              {
                ac.i("MicroMsg.LuckyMoneyPrepareUI", "usr cancel, & visibility not visiable, so finish");
                SnsLuckyMoneyPrepareUI.this.finish();
              }
              SnsLuckyMoneyPrepareUI.this.usr.forceCancel();
              AppMethodBeat.o(65380);
            }
          });
          AppMethodBeat.o(65381);
        }
      });
      this.oBl.setText(com.tencent.mm.wallet_core.ui.e.D(0.0D));
      this.uhQ.a(this.uhH);
      this.uhQ.a(this.uoX);
      this.uhQ.a(this.uhJ);
      localObject1 = (TextView)findViewById(2131301898);
      this.uhQ.n((TextView)localObject1);
      if ((this.upe) && (this.mType == 1))
      {
        localObject1 = (TextView)findViewById(2131301902);
        ((TextView)localObject1).setText(getString(2131760910, new Object[] { Integer.valueOf(getIntent().getIntExtra("key_chatroom_num", 8)) }));
        ((TextView)localObject1).setVisibility(0);
      }
      this.iRv = new au(new au.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(65382);
          int i;
          double d2;
          if ((SnsLuckyMoneyPrepareUI.this.uoX.cYE() != 3) && (SnsLuckyMoneyPrepareUI.this.uhH.cYE() != 3))
          {
            i = SnsLuckyMoneyPrepareUI.this.uhH.getInput();
            d2 = SnsLuckyMoneyPrepareUI.this.uoX.getInput();
            d1 = d2;
            if (SnsLuckyMoneyPrepareUI.a(SnsLuckyMoneyPrepareUI.this) != 0) {}
          }
          for (double d1 = d2 * i;; d1 = 0.0D)
          {
            if ((d1 == 0.0D) || (d1 > SnsLuckyMoneyPrepareUI.b(SnsLuckyMoneyPrepareUI.this).ugv) || (SnsLuckyMoneyPrepareUI.i(SnsLuckyMoneyPrepareUI.this).dad()))
            {
              SnsLuckyMoneyPrepareUI.this.uhK.setClickable(false);
              SnsLuckyMoneyPrepareUI.this.uhK.setEnabled(false);
            }
            for (;;)
            {
              ac.i("MicroMsg.LuckyMoneyPrepareUI", "onTimeExpired & check: amount=" + d1 + ", hasErr=" + SnsLuckyMoneyPrepareUI.i(SnsLuckyMoneyPrepareUI.this).dad());
              SnsLuckyMoneyPrepareUI.j(SnsLuckyMoneyPrepareUI.this).eVs();
              AppMethodBeat.o(65382);
              return false;
              SnsLuckyMoneyPrepareUI.this.uhK.setClickable(true);
              SnsLuckyMoneyPrepareUI.this.uhK.setEnabled(true);
            }
          }
        }
      }, false);
      if (this.kqh != null) {
        this.kqh.setOnTouchListener(new View.OnTouchListener()
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
      this.uoX.setType(this.mType);
      if ((!this.upe) || (getIntent().getIntExtra("key_chatroom_num", 0) != 0)) {
        break label1139;
      }
      this.uoX.requestFocus();
      AppMethodBeat.o(65389);
      return;
      this.uoX.setTitle(getString(2131760979));
      this.uoX.setShowGroupIcon(false);
      break;
      label1032:
      this.uoX.setMaxAmount(this.ugW.ugt);
      break label443;
      label1049:
      this.uhH.setNum("");
      break label488;
      label1062:
      this.uhH.setVisibility(8);
      continue;
      label1074:
      if (this.mType == 1)
      {
        this.lLe.setText(this.ugW.ulo);
        this.lLe.setVisibility(0);
      }
      else if (this.mType == 0)
      {
        this.lLe.setText(this.ugW.ulp);
        this.lLe.setVisibility(0);
      }
    }
    label1139:
    this.uhH.requestFocus();
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
        com.tencent.mm.plugin.report.service.h.wUl.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(cZv()), Integer.valueOf(5) });
        Object localObject1 = getIntent().getStringExtra("key_username");
        if ((this.upe) && (!bs.isNullOrNil((String)localObject1)))
        {
          com.tencent.mm.ui.base.h.cg(this, getString(2131760233));
          Object localObject2 = bv.L(this.upf, "msg");
          if (localObject2 == null)
          {
            ac.e("MicroMsg.LuckyMoneyPrepareUI", "luckymoneyPrepareUI onActivityResult values is null");
            finish();
            AppMethodBeat.o(65393);
            return;
          }
          localObject2 = (String)((Map)localObject2).get(".msg.appmsg.wcpayinfo.paymsgid");
          if (com.tencent.mm.plugin.luckymoney.b.a.cYv().cYy().akg((String)localObject2))
          {
            ac.i("MicroMsg.LuckyMoneyPrepareUI", "insert a local msg for luckymoney");
            if (!z.W(this.upf, (String)localObject1, 1))
            {
              ac.e("MicroMsg.LuckyMoneyPrepareUI", "LuckyMoneyUtil.sendLocalMsg fail!");
              com.tencent.mm.plugin.luckymoney.b.a.cYv().cYy().akh((String)localObject2);
            }
          }
          for (;;)
          {
            finish();
            break;
            ac.e("MicroMsg.LuckyMoneyPrepareUI", "it is a duplicate msg");
          }
        }
        cZS();
        new ao().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(65368);
            SnsLuckyMoneyPrepareUI.l(SnsLuckyMoneyPrepareUI.this).setVisibility(0);
            ScaleAnimation localScaleAnimation = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.5F, 1, 0.5F);
            localScaleAnimation.setDuration(800L);
            localScaleAnimation.setStartOffset(200L);
            localScaleAnimation.setInterpolator(new BounceInterpolator());
            SnsLuckyMoneyPrepareUI.this.findViewById(2131301906).startAnimation(localScaleAnimation);
            AppMethodBeat.o(65368);
          }
        }, 200L);
        this.pkJ.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(65370);
            com.tencent.mm.plugin.report.service.h.wUl.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(SnsLuckyMoneyPrepareUI.d(SnsLuckyMoneyPrepareUI.this)), Integer.valueOf(6) });
            z.a(SnsLuckyMoneyPrepareUI.this, SnsLuckyMoneyPrepareUI.a(SnsLuckyMoneyPrepareUI.this), SnsLuckyMoneyPrepareUI.m(SnsLuckyMoneyPrepareUI.this), false);
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
            AppMethodBeat.o(65370);
          }
        });
        ((ImageView)findViewById(2131301897)).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(65371);
            SnsLuckyMoneyPrepareUI.l(SnsLuckyMoneyPrepareUI.this).setVisibility(8);
            SnsLuckyMoneyPrepareUI.o(SnsLuckyMoneyPrepareUI.this);
            AppMethodBeat.o(65371);
          }
        });
        continue;
        if ((paramInt2 == -1) && (paramIntent != null))
        {
          localObject1 = paramIntent.getStringExtra("Select_Conv_User");
          com.tencent.mm.plugin.report.service.h.wUl.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(cZv()), Integer.valueOf(7), localObject1 });
          if (!bs.isNullOrNil((String)localObject1)) {
            doSceneProgress(new at(((String)localObject1).replaceAll(",", "|"), this.upc, "v1.0"));
          } else {
            finish();
          }
        }
        else if (paramInt2 == 0)
        {
          localObject1 = new Intent();
          ((Intent)localObject1).setClass(getContext(), LuckyMoneyMyRecordUI.class);
          ((Intent)localObject1).putExtra("key_type", 1);
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject1);
          com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aeD(), "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(65388);
    super.onCreate(paramBundle);
    this.mType = getIntent().getIntExtra("key_type", 1);
    this.upb = getIntent().getIntExtra("key_way", 3);
    if (getIntent().getIntExtra("key_from", 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.upe = bool;
      this.mChannel = getIntent().getIntExtra("pay_channel", -1);
      doSceneProgress(new ai("v1.0", 0, (byte)0), false);
      com.tencent.mm.plugin.luckymoney.b.a.cYv();
      this.ugW = com.tencent.mm.plugin.luckymoney.b.a.cYw().cYZ();
      ac.d("MicroMsg.LuckyMoneyPrepareUI", "type=" + this.mType + ", fromAppPanel=" + this.upe + ", config " + this.ugW);
      initView();
      com.tencent.mm.plugin.report.service.h.wUl.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(cZv()), Integer.valueOf(1) });
      AppMethodBeat.o(65388);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(65390);
    super.onDestroy();
    this.uhQ.clear();
    this.iRv.eVs();
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
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, n paramn)
  {
    AppMethodBeat.i(65392);
    if ((paramn instanceof aq))
    {
      if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
        this.tipDialog.hide();
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (aq)paramn;
        this.upd = paramString.owW;
        this.upc = paramString.uhB;
        this.upf = paramString.unT;
        paramn = new PayInfo();
        paramn.dac = paramString.skK;
        paramn.dqL = 37;
        paramn.channel = this.mChannel;
        f.a(this, paramn, 1);
        AppMethodBeat.o(65392);
        return true;
      }
      if (paramInt2 == 401)
      {
        this.uhK.setEnabled(false);
        this.uhK.setClickable(false);
        this.iRv.au(5000L, 5000L);
        com.tencent.mm.ui.base.h.cg(this, paramString);
        AppMethodBeat.o(65392);
        return true;
      }
      com.tencent.mm.ui.base.h.cg(this, paramString);
      AppMethodBeat.o(65392);
      return true;
    }
    if ((paramn instanceof at))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (this.upe)
        {
          com.tencent.mm.ui.base.h.cg(this, getString(2131760233));
          finish();
        }
        for (;;)
        {
          AppMethodBeat.o(65392);
          return true;
          cZS();
          this.uoZ.postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(65364);
              Object localObject = new Intent();
              ((Intent)localObject).setClass(SnsLuckyMoneyPrepareUI.this.getContext(), LuckyMoneyIndexUI.class);
              ((Intent)localObject).addFlags(67108864);
              AppCompatActivity localAppCompatActivity = SnsLuckyMoneyPrepareUI.this.getContext();
              localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(localAppCompatActivity, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$11", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              localAppCompatActivity.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
              com.tencent.mm.hellhoundlib.a.a.a(localAppCompatActivity, "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$11", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              SnsLuckyMoneyPrepareUI.this.finish();
              AppMethodBeat.o(65364);
            }
          }, 1000L);
        }
      }
      if (paramInt2 == 402)
      {
        com.tencent.mm.ui.base.h.d(getContext(), paramString, "", getString(2131760958), getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(65365);
            Object localObject = new Intent();
            ((Intent)localObject).setClass(SnsLuckyMoneyPrepareUI.this.getContext(), LuckyMoneyMyRecordUI.class);
            ((Intent)localObject).putExtra("key_type", 1);
            paramAnonymousDialogInterface = SnsLuckyMoneyPrepareUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$12", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$12", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
    else if ((paramn instanceof ai))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (ai)paramn;
        com.tencent.mm.plugin.luckymoney.b.a.cYv();
        this.ugW = com.tencent.mm.plugin.luckymoney.b.a.cYw().cYZ();
        ac.d("MicroMsg.LuckyMoneyPrepareUI", "update config:" + this.ugW);
        if (this.mType != 1) {
          break label656;
        }
        this.uoX.setMaxAmount(this.ugW.ugv);
        this.uoX.setMinAmount(this.ugW.ugu);
        this.uhH.setMaxNum(this.ugW.ugs);
        if ((paramString.unz) && (this.upe))
        {
          paramn = (TextView)findViewById(2131301899);
          paramn.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(65366);
              com.tencent.mm.plugin.report.service.h.wUl.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(SnsLuckyMoneyPrepareUI.d(SnsLuckyMoneyPrepareUI.this)), Integer.valueOf(9) });
              Object localObject = new Intent();
              ((Intent)localObject).setClass(SnsLuckyMoneyPrepareUI.this.getContext(), LuckyMoneyCanShareListUI.class);
              paramAnonymousView = SnsLuckyMoneyPrepareUI.this;
              localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$14", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$14", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(65366);
            }
          });
          com.tencent.mm.plugin.report.service.h.wUl.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(cZv()), Integer.valueOf(8) });
          paramn.setVisibility(0);
        }
        if (bs.isNullOrNil(paramString.iAx)) {
          break label673;
        }
        ac.i("MicroMsg.LuckyMoneyPrepareUI", "Put notice :" + paramString.iAx);
        this.uhO.setText(paramString.iAx);
        if (!bs.isNullOrNil(paramString.unB)) {
          this.uhO.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(65367);
              com.tencent.mm.wallet_core.ui.e.o(SnsLuckyMoneyPrepareUI.this.getContext(), paramString.unB, false);
              AppMethodBeat.o(65367);
            }
          });
        }
        this.uhO.setVisibility(0);
      }
      for (;;)
      {
        paramn = new h.c();
        paramn.textColor = getResources().getColor(2131101114);
        com.tencent.mm.plugin.luckymoney.ui.h.a(this, this.upa, paramString.unD, paramn);
        AppMethodBeat.o(65392);
        return true;
        label656:
        this.uoX.setMaxAmount(this.ugW.ugt);
        break;
        label673:
        this.uhO.setVisibility(8);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI
 * JD-Core Version:    0.7.0.1
 */