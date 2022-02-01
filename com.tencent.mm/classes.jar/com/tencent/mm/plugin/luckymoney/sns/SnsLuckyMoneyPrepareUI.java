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
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.t;
import com.tenpay.android.wechat.MyKeyboardWindow;
import java.util.Map;

@com.tencent.mm.ui.base.a(19)
public class SnsLuckyMoneyPrepareUI
  extends LuckyMoneyBaseUI
  implements com.tencent.mm.plugin.luckymoney.ui.g
{
  private av irp;
  private ScrollView jPx;
  private TextView lln;
  private int mChannel;
  protected View mKBLayout;
  protected MyKeyboardWindow mKeyboard;
  private com.tencent.mm.wallet_core.ui.a mTenpayKBStateListener;
  private int mType;
  protected TextView nXQ;
  protected Button oHj;
  private j sYI;
  private TextView sZA;
  private b sZC;
  protected LuckyMoneyNumInputView sZt;
  protected LuckyMoneyTextInputView sZv;
  protected Button sZw;
  protected LuckyMoneyMoneyInputView tgI;
  private View tgJ;
  private View tgK;
  private ViewGroup tgL;
  private int tgM;
  private String tgN;
  private int tgO;
  private boolean tgP;
  private String tgQ;
  protected Dialog tipDialog;
  
  public SnsLuckyMoneyPrepareUI()
  {
    AppMethodBeat.i(65387);
    this.sZt = null;
    this.tgI = null;
    this.sZv = null;
    this.nXQ = null;
    this.sZw = null;
    this.oHj = null;
    this.tipDialog = null;
    this.sZC = new b();
    this.irp = null;
    AppMethodBeat.o(65387);
  }
  
  private int cLP()
  {
    AppMethodBeat.i(65398);
    if (this.tgP)
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
  
  protected final void ag(View paramView, final int paramInt)
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
          new ap().postDelayed(new Runnable()
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
        new ap().postDelayed(new Runnable()
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
  
  public final void cKZ()
  {
    AppMethodBeat.i(65397);
    com.tencent.mm.plugin.luckymoney.b.a.cKP();
    this.sYI = com.tencent.mm.plugin.luckymoney.b.a.cKQ().cLt();
    int i;
    double d2;
    double d1;
    if ((this.tgI.cKY() != 3) && (this.sZt.cKY() != 3))
    {
      i = this.sZt.getInput();
      d2 = this.tgI.getInput();
      if (this.mType == 0)
      {
        d2 *= i;
        d1 = this.tgI.getInput();
      }
    }
    for (;;)
    {
      if (this.sZC.cMw())
      {
        this.sZw.setClickable(false);
        this.sZw.setEnabled(false);
        this.nXQ.setText(com.tencent.mm.wallet_core.ui.e.E(d2));
        AppMethodBeat.o(65397);
        return;
        if (i > 0) {
          d1 = this.tgI.getInput() / i;
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
            this.sZw.setClickable(false);
            this.sZw.setEnabled(false);
            break;
            if ((d2 > this.sYI.sYh) && (this.sYI.sYh > 0.0D))
            {
              this.sZC.Mp(getString(2131760977, new Object[] { Math.round(this.sYI.sYh), bt.by(this.sYI.sYk, "") }));
              i = 1;
              continue;
            }
            if (d1 <= 0.0D) {
              break label650;
            }
            if (this.mType == 0)
            {
              if ((d1 <= this.sYI.sYf) || (this.sYI.sYf <= 0.0D)) {
                break label644;
              }
              this.sZC.Mp(getString(2131760922, new Object[] { Math.round(this.sYI.sYf), bt.by(this.sYI.sYk, "") }));
              i = 1;
            }
          }
          for (;;)
          {
            if (i == 0)
            {
              if (this.mType == 0)
              {
                if (d1 >= this.sYI.sYg) {
                  break label641;
                }
                this.sZC.Mp(getString(2131760924, new Object[] { com.tencent.mm.wallet_core.ui.e.D(this.sYI.sYg), bt.by(this.sYI.sYk, "") }));
                i = 1;
                break label159;
                if ((d1 <= this.sYI.sYi) || (this.sYI.sYi <= 0.0D)) {
                  break label644;
                }
                this.sZC.Mp(getString(2131760922, new Object[] { Math.round(this.sYI.sYi), bt.by(this.sYI.sYk, "") }));
                this.sZt.onError();
                this.tgI.onError();
                i = 1;
                continue;
              }
              if (d1 < 0.01D)
              {
                this.sZC.Mp(getString(2131760924, new Object[] { "0.01", bt.by(this.sYI.sYk, "") }));
                this.sZt.onError();
                this.tgI.onError();
                i = 1;
                break label159;
                this.sZw.setClickable(true);
                this.sZw.setEnabled(true);
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
    if ((paramKeyEvent.getKeyCode() == 4) && (this.tgJ.getVisibility() == 0))
    {
      this.tgJ.setVisibility(8);
      cMl();
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
    this.tgJ = findViewById(2131301905);
    this.tgK = findViewById(2131301908);
    this.oHj = ((Button)findViewById(2131301907));
    this.sZv = ((LuckyMoneyTextInputView)findViewById(2131301959));
    this.sZv.setHintText(getString(2131760843));
    this.sZw = ((Button)findViewById(2131301896));
    this.mKeyboard = ((MyKeyboardWindow)findViewById(2131305695));
    this.mKBLayout = findViewById(2131305693);
    this.lln = ((TextView)findViewById(2131301894));
    this.sZt = ((LuckyMoneyNumInputView)findViewById(2131301891));
    this.tgI = ((LuckyMoneyMoneyInputView)findViewById(2131301715));
    this.nXQ = ((TextView)findViewById(2131301909));
    this.tgL = ((ViewGroup)findViewById(2131301903));
    this.jPx = ((ScrollView)findViewById(2131301943));
    this.sZA = ((TextView)findViewById(2131301901));
    Object localObject1;
    if (this.mType == 1)
    {
      this.tgI.setTitle(getString(2131760978));
      this.tgI.setShowGroupIcon(true);
      this.tgI.setOnInputValidChangerListener(this);
      this.sZt.setOnInputValidChangerListener(this);
      this.sZv.setOnInputValidChangerListener(this);
      localObject1 = (EditText)this.tgI.findViewById(2131301810);
      Object localObject2 = (EditText)this.sZt.findViewById(2131301810);
      com.tencent.mm.wallet_core.ui.e.setNoSystemInputOnEditText((EditText)localObject1);
      ((InputMethodManager)getContext().getSystemService("input_method")).showSoftInput((View)localObject1, 0);
      ((EditText)localObject1).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(65384);
          this.val$hintTv.setOnClickListener(null);
          this.sZE.setOnClickListener(null);
          SnsLuckyMoneyPrepareUI.this.ag(SnsLuckyMoneyPrepareUI.this.tgI, 2);
          SnsLuckyMoneyPrepareUI.this.ag(SnsLuckyMoneyPrepareUI.this.sZt, 0);
          SnsLuckyMoneyPrepareUI.this.mKeyboard.setXMode(2);
          SnsLuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText)paramAnonymousView);
          SnsLuckyMoneyPrepareUI.k(SnsLuckyMoneyPrepareUI.this);
          AppMethodBeat.o(65384);
        }
      });
      Object localObject3 = (TextView)this.tgI.findViewById(2131301716);
      if (localObject3 != null) {
        ((TextView)localObject3).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(65385);
            this.val$hintTv.setOnClickListener(null);
            this.sZE.setOnClickListener(null);
            SnsLuckyMoneyPrepareUI.this.ag(SnsLuckyMoneyPrepareUI.this.tgI, 2);
            SnsLuckyMoneyPrepareUI.this.ag(SnsLuckyMoneyPrepareUI.this.sZt, 0);
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
          this.sZE.setOnClickListener(null);
          SnsLuckyMoneyPrepareUI.this.ag(SnsLuckyMoneyPrepareUI.this.tgI, 2);
          SnsLuckyMoneyPrepareUI.this.ag(SnsLuckyMoneyPrepareUI.this.sZt, 0);
          SnsLuckyMoneyPrepareUI.this.mKeyboard.setXMode(0);
          SnsLuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText)paramAnonymousView);
          SnsLuckyMoneyPrepareUI.k(SnsLuckyMoneyPrepareUI.this);
          AppMethodBeat.o(65386);
        }
      });
      if (this.sYI != null)
      {
        if (this.mType != 1) {
          break label1032;
        }
        this.tgI.setMaxAmount(this.sYI.sYh);
        label443:
        this.tgI.setMinAmount(this.sYI.sYg);
      }
      if ((!this.tgP) || (getIntent().getIntExtra("key_chatroom_num", 0) > 1)) {
        break label1049;
      }
      this.sZt.setNum("1");
      label488:
      this.sZt.setMaxNum(this.sYI.sYe);
      this.sZt.setMinNum(1);
      ad.d("MicroMsg.LuckyMoneyPrepareUI", "init num=" + this.sZt.getInput());
      this.tgI.setMaxLen(12);
      if (!this.tgP) {
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
      locall.Anf = new l.a()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(65375);
          int i = SnsLuckyMoneyPrepareUI.this.sZt.getInput();
          double d = SnsLuckyMoneyPrepareUI.this.tgI.getInput();
          SnsLuckyMoneyPrepareUI.a(SnsLuckyMoneyPrepareUI.this, 0);
          SnsLuckyMoneyPrepareUI.this.tgI.setType(SnsLuckyMoneyPrepareUI.a(SnsLuckyMoneyPrepareUI.this));
          SnsLuckyMoneyPrepareUI.this.tgI.setShowGroupIcon(false);
          SnsLuckyMoneyPrepareUI.this.tgI.setTitle(SnsLuckyMoneyPrepareUI.this.getString(2131760979));
          if ((d > 0.0D) && (i > 0)) {
            SnsLuckyMoneyPrepareUI.this.tgI.setAmount(com.tencent.mm.wallet_core.ui.e.D(d / i));
          }
          SnsLuckyMoneyPrepareUI.this.tgI.setMaxAmount(SnsLuckyMoneyPrepareUI.b(SnsLuckyMoneyPrepareUI.this).sYf);
          SnsLuckyMoneyPrepareUI.c(SnsLuckyMoneyPrepareUI.this).setText(this.sZI);
          com.tencent.mm.plugin.report.service.h.vKh.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(SnsLuckyMoneyPrepareUI.d(SnsLuckyMoneyPrepareUI.this)), Integer.valueOf(3) });
          AppMethodBeat.o(65375);
        }
      };
      ((l)localObject5).Anf = new l.a()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(65379);
          int i = SnsLuckyMoneyPrepareUI.this.sZt.getInput();
          double d = SnsLuckyMoneyPrepareUI.this.tgI.getInput();
          SnsLuckyMoneyPrepareUI.a(SnsLuckyMoneyPrepareUI.this, 1);
          SnsLuckyMoneyPrepareUI.this.tgI.setType(SnsLuckyMoneyPrepareUI.a(SnsLuckyMoneyPrepareUI.this));
          SnsLuckyMoneyPrepareUI.this.tgI.setTitle(SnsLuckyMoneyPrepareUI.this.getString(2131760978));
          SnsLuckyMoneyPrepareUI.this.tgI.setShowGroupIcon(true);
          if ((d > 0.0D) && (i > 0)) {
            SnsLuckyMoneyPrepareUI.this.tgI.setAmount(com.tencent.mm.wallet_core.ui.e.D(d * i));
          }
          SnsLuckyMoneyPrepareUI.this.tgI.setMaxAmount(SnsLuckyMoneyPrepareUI.b(SnsLuckyMoneyPrepareUI.this).sYh);
          SnsLuckyMoneyPrepareUI.c(SnsLuckyMoneyPrepareUI.this).setText(this.sZJ);
          com.tencent.mm.plugin.report.service.h.vKh.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(SnsLuckyMoneyPrepareUI.d(SnsLuckyMoneyPrepareUI.this)), Integer.valueOf(2) });
          AppMethodBeat.o(65379);
        }
      };
      this.lln.setMovementMethod(LinkMovementMethod.getInstance());
      this.lln.setText((CharSequence)localObject3);
      this.lln.setVisibility(0);
    }
    for (;;)
    {
      this.sZw.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(65381);
          com.tencent.mm.plugin.report.service.h.vKh.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(SnsLuckyMoneyPrepareUI.d(SnsLuckyMoneyPrepareUI.this)), Integer.valueOf(4) });
          if (SnsLuckyMoneyPrepareUI.this.tgI.cKY() != 0)
          {
            t.makeText(SnsLuckyMoneyPrepareUI.this.getContext(), 2131765031, 0).show();
            AppMethodBeat.o(65381);
            return;
          }
          int i = SnsLuckyMoneyPrepareUI.this.sZt.getInput();
          double d = SnsLuckyMoneyPrepareUI.this.tgI.getInput();
          long l2 = 0L;
          long l1;
          String str;
          if (SnsLuckyMoneyPrepareUI.a(SnsLuckyMoneyPrepareUI.this) == 1)
          {
            l1 = com.tencent.mm.wallet_core.ui.e.F(d);
            com.tencent.mm.kernel.g.afC();
            com.tencent.mm.kernel.g.afB().afk().set(356354, Integer.valueOf(i));
            str = SnsLuckyMoneyPrepareUI.this.sZv.getInput();
            paramAnonymousView = str;
            if (bt.isNullOrNil(str)) {
              paramAnonymousView = SnsLuckyMoneyPrepareUI.this.getString(2131760843);
            }
            str = SnsLuckyMoneyPrepareUI.this.getIntent().getStringExtra("key_username");
            if ((!SnsLuckyMoneyPrepareUI.e(SnsLuckyMoneyPrepareUI.this)) || (bt.isNullOrNil(str))) {
              break label343;
            }
          }
          label343:
          for (paramAnonymousView = new aq(i, l1, l2, SnsLuckyMoneyPrepareUI.a(SnsLuckyMoneyPrepareUI.this), paramAnonymousView, z.cLy(), str, z.sg(str), com.tencent.mm.model.u.aqG(), com.tencent.mm.model.u.aqI(), SnsLuckyMoneyPrepareUI.f(SnsLuckyMoneyPrepareUI.this), "");; paramAnonymousView = new aq(i, l1, l2, SnsLuckyMoneyPrepareUI.a(SnsLuckyMoneyPrepareUI.this), paramAnonymousView, z.cLy(), null, null, com.tencent.mm.model.u.aqG(), com.tencent.mm.model.u.aqI(), SnsLuckyMoneyPrepareUI.f(SnsLuckyMoneyPrepareUI.this), ""))
          {
            SnsLuckyMoneyPrepareUI.this.doSceneProgress(paramAnonymousView, false);
            if (SnsLuckyMoneyPrepareUI.this.tipDialog == null) {
              break label388;
            }
            SnsLuckyMoneyPrepareUI.this.tipDialog.show();
            AppMethodBeat.o(65381);
            return;
            l1 = com.tencent.mm.wallet_core.ui.e.F(i * d);
            l2 = com.tencent.mm.wallet_core.ui.e.F(d);
            com.tencent.mm.kernel.g.afC();
            com.tencent.mm.kernel.g.afB().afk().set(356353, Integer.valueOf(i));
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
                ad.i("MicroMsg.LuckyMoneyPrepareUI", "usr cancel, & visibility not visiable, so finish");
                SnsLuckyMoneyPrepareUI.this.finish();
              }
              SnsLuckyMoneyPrepareUI.this.tjY.forceCancel();
              AppMethodBeat.o(65380);
            }
          });
          AppMethodBeat.o(65381);
        }
      });
      this.nXQ.setText(com.tencent.mm.wallet_core.ui.e.E(0.0D));
      this.sZC.a(this.sZt);
      this.sZC.a(this.tgI);
      this.sZC.a(this.sZv);
      localObject1 = (TextView)findViewById(2131301898);
      this.sZC.n((TextView)localObject1);
      if ((this.tgP) && (this.mType == 1))
      {
        localObject1 = (TextView)findViewById(2131301902);
        ((TextView)localObject1).setText(getString(2131760910, new Object[] { Integer.valueOf(getIntent().getIntExtra("key_chatroom_num", 8)) }));
        ((TextView)localObject1).setVisibility(0);
      }
      this.irp = new av(new av.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(65382);
          int i;
          double d2;
          if ((SnsLuckyMoneyPrepareUI.this.tgI.cKY() != 3) && (SnsLuckyMoneyPrepareUI.this.sZt.cKY() != 3))
          {
            i = SnsLuckyMoneyPrepareUI.this.sZt.getInput();
            d2 = SnsLuckyMoneyPrepareUI.this.tgI.getInput();
            d1 = d2;
            if (SnsLuckyMoneyPrepareUI.a(SnsLuckyMoneyPrepareUI.this) != 0) {}
          }
          for (double d1 = d2 * i;; d1 = 0.0D)
          {
            if ((d1 == 0.0D) || (d1 > SnsLuckyMoneyPrepareUI.b(SnsLuckyMoneyPrepareUI.this).sYh) || (SnsLuckyMoneyPrepareUI.i(SnsLuckyMoneyPrepareUI.this).cMx()))
            {
              SnsLuckyMoneyPrepareUI.this.sZw.setClickable(false);
              SnsLuckyMoneyPrepareUI.this.sZw.setEnabled(false);
            }
            for (;;)
            {
              ad.i("MicroMsg.LuckyMoneyPrepareUI", "onTimeExpired & check: amount=" + d1 + ", hasErr=" + SnsLuckyMoneyPrepareUI.i(SnsLuckyMoneyPrepareUI.this).cMx());
              SnsLuckyMoneyPrepareUI.j(SnsLuckyMoneyPrepareUI.this).eFX();
              AppMethodBeat.o(65382);
              return false;
              SnsLuckyMoneyPrepareUI.this.sZw.setClickable(true);
              SnsLuckyMoneyPrepareUI.this.sZw.setEnabled(true);
            }
          }
        }
      }, false);
      if (this.jPx != null) {
        this.jPx.setOnTouchListener(new View.OnTouchListener()
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
      this.tgI.setType(this.mType);
      if ((!this.tgP) || (getIntent().getIntExtra("key_chatroom_num", 0) != 0)) {
        break label1139;
      }
      this.tgI.requestFocus();
      AppMethodBeat.o(65389);
      return;
      this.tgI.setTitle(getString(2131760979));
      this.tgI.setShowGroupIcon(false);
      break;
      label1032:
      this.tgI.setMaxAmount(this.sYI.sYf);
      break label443;
      label1049:
      this.sZt.setNum("");
      break label488;
      label1062:
      this.sZt.setVisibility(8);
      continue;
      label1074:
      if (this.mType == 1)
      {
        this.lln.setText(this.sYI.tcZ);
        this.lln.setVisibility(0);
      }
      else if (this.mType == 0)
      {
        this.lln.setText(this.sYI.tda);
        this.lln.setVisibility(0);
      }
    }
    label1139:
    this.sZt.requestFocus();
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
        com.tencent.mm.plugin.report.service.h.vKh.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(cLP()), Integer.valueOf(5) });
        Object localObject1 = getIntent().getStringExtra("key_username");
        if ((this.tgP) && (!bt.isNullOrNil((String)localObject1)))
        {
          com.tencent.mm.ui.base.h.cf(this, getString(2131760233));
          Object localObject2 = bw.K(this.tgQ, "msg");
          if (localObject2 == null)
          {
            ad.e("MicroMsg.LuckyMoneyPrepareUI", "luckymoneyPrepareUI onActivityResult values is null");
            finish();
            AppMethodBeat.o(65393);
            return;
          }
          localObject2 = (String)((Map)localObject2).get(".msg.appmsg.wcpayinfo.paymsgid");
          if (com.tencent.mm.plugin.luckymoney.b.a.cKP().cKS().afm((String)localObject2))
          {
            ad.i("MicroMsg.LuckyMoneyPrepareUI", "insert a local msg for luckymoney");
            if (!z.V(this.tgQ, (String)localObject1, 1))
            {
              ad.e("MicroMsg.LuckyMoneyPrepareUI", "LuckyMoneyUtil.sendLocalMsg fail!");
              com.tencent.mm.plugin.luckymoney.b.a.cKP().cKS().afn((String)localObject2);
            }
          }
          for (;;)
          {
            finish();
            break;
            ad.e("MicroMsg.LuckyMoneyPrepareUI", "it is a duplicate msg");
          }
        }
        cMm();
        new ap().postDelayed(new SnsLuckyMoneyPrepareUI.7(this), 200L);
        this.oHj.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(65370);
            com.tencent.mm.plugin.report.service.h.vKh.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(SnsLuckyMoneyPrepareUI.d(SnsLuckyMoneyPrepareUI.this)), Integer.valueOf(6) });
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
        ((ImageView)findViewById(2131301897)).setOnClickListener(new SnsLuckyMoneyPrepareUI.9(this));
        continue;
        if ((paramInt2 == -1) && (paramIntent != null))
        {
          localObject1 = paramIntent.getStringExtra("Select_Conv_User");
          com.tencent.mm.plugin.report.service.h.vKh.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(cLP()), Integer.valueOf(7), localObject1 });
          if (!bt.isNullOrNil((String)localObject1)) {
            doSceneProgress(new at(((String)localObject1).replaceAll(",", "|"), this.tgN, "v1.0"));
          } else {
            finish();
          }
        }
        else if (paramInt2 == 0)
        {
          localObject1 = new Intent();
          ((Intent)localObject1).setClass(getContext(), LuckyMoneyMyRecordUI.class);
          ((Intent)localObject1).putExtra("key_type", 1);
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject1);
          com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).adn(), "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lS(0));
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
    this.tgM = getIntent().getIntExtra("key_way", 3);
    if (getIntent().getIntExtra("key_from", 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.tgP = bool;
      this.mChannel = getIntent().getIntExtra("pay_channel", -1);
      doSceneProgress(new ai("v1.0", 0, (byte)0), false);
      com.tencent.mm.plugin.luckymoney.b.a.cKP();
      this.sYI = com.tencent.mm.plugin.luckymoney.b.a.cKQ().cLt();
      ad.d("MicroMsg.LuckyMoneyPrepareUI", "type=" + this.mType + ", fromAppPanel=" + this.tgP + ", config " + this.sYI);
      initView();
      com.tencent.mm.plugin.report.service.h.vKh.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(cLP()), Integer.valueOf(1) });
      AppMethodBeat.o(65388);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(65390);
    super.onDestroy();
    this.sZC.clear();
    this.irp.eFX();
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
        this.tgO = paramString.nTB;
        this.tgN = paramString.sZn;
        this.tgQ = paramString.tfE;
        paramn = new PayInfo();
        paramn.dcE = paramString.rcq;
        paramn.dtb = 37;
        paramn.channel = this.mChannel;
        f.a(this, paramn, 1);
        AppMethodBeat.o(65392);
        return true;
      }
      if (paramInt2 == 401)
      {
        this.sZw.setEnabled(false);
        this.sZw.setClickable(false);
        this.irp.av(5000L, 5000L);
        com.tencent.mm.ui.base.h.cf(this, paramString);
        AppMethodBeat.o(65392);
        return true;
      }
      com.tencent.mm.ui.base.h.cf(this, paramString);
      AppMethodBeat.o(65392);
      return true;
    }
    if ((paramn instanceof at))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (this.tgP)
        {
          com.tencent.mm.ui.base.h.cf(this, getString(2131760233));
          finish();
        }
        for (;;)
        {
          AppMethodBeat.o(65392);
          return true;
          cMm();
          this.tgK.postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(65364);
              Object localObject = new Intent();
              ((Intent)localObject).setClass(SnsLuckyMoneyPrepareUI.this.getContext(), LuckyMoneyIndexUI.class);
              ((Intent)localObject).addFlags(67108864);
              AppCompatActivity localAppCompatActivity = SnsLuckyMoneyPrepareUI.this.getContext();
              localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(localAppCompatActivity, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$11", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              localAppCompatActivity.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
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
            localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$12", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
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
        com.tencent.mm.plugin.luckymoney.b.a.cKP();
        this.sYI = com.tencent.mm.plugin.luckymoney.b.a.cKQ().cLt();
        ad.d("MicroMsg.LuckyMoneyPrepareUI", "update config:" + this.sYI);
        if (this.mType != 1) {
          break label656;
        }
        this.tgI.setMaxAmount(this.sYI.sYh);
        this.tgI.setMinAmount(this.sYI.sYg);
        this.sZt.setMaxNum(this.sYI.sYe);
        if ((paramString.tfk) && (this.tgP))
        {
          paramn = (TextView)findViewById(2131301899);
          paramn.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(65366);
              com.tencent.mm.plugin.report.service.h.vKh.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(SnsLuckyMoneyPrepareUI.d(SnsLuckyMoneyPrepareUI.this)), Integer.valueOf(9) });
              Object localObject = new Intent();
              ((Intent)localObject).setClass(SnsLuckyMoneyPrepareUI.this.getContext(), LuckyMoneyCanShareListUI.class);
              paramAnonymousView = SnsLuckyMoneyPrepareUI.this;
              localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$14", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$14", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(65366);
            }
          });
          com.tencent.mm.plugin.report.service.h.vKh.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(cLP()), Integer.valueOf(8) });
          paramn.setVisibility(0);
        }
        if (bt.isNullOrNil(paramString.iau)) {
          break label673;
        }
        ad.i("MicroMsg.LuckyMoneyPrepareUI", "Put notice :" + paramString.iau);
        this.sZA.setText(paramString.iau);
        if (!bt.isNullOrNil(paramString.tfm)) {
          this.sZA.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(65367);
              com.tencent.mm.wallet_core.ui.e.p(SnsLuckyMoneyPrepareUI.this.getContext(), paramString.tfm, false);
              AppMethodBeat.o(65367);
            }
          });
        }
        this.sZA.setVisibility(0);
      }
      for (;;)
      {
        paramn = new h.c();
        paramn.textColor = getResources().getColor(2131101114);
        com.tencent.mm.plugin.luckymoney.ui.h.a(this, this.tgL, paramString.tfo, paramn);
        AppMethodBeat.o(65392);
        return true;
        label656:
        this.tgI.setMaxAmount(this.sYI.sYf);
        break;
        label673:
        this.sZA.setVisibility(8);
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