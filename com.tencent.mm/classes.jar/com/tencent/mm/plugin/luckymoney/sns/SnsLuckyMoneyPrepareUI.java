package com.tencent.mm.plugin.luckymoney.sns;

import android.app.Activity;
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
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
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
import com.tencent.mm.ai.m;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.luckymoney.model.ag;
import com.tencent.mm.plugin.luckymoney.model.ao;
import com.tencent.mm.plugin.luckymoney.model.ar;
import com.tencent.mm.plugin.luckymoney.model.i;
import com.tencent.mm.plugin.luckymoney.model.p;
import com.tencent.mm.plugin.luckymoney.model.x;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyCanShareListUI;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMoneyInputView;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMyRecordUI;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNumInputView;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyTextInputView;
import com.tencent.mm.plugin.luckymoney.ui.b;
import com.tencent.mm.plugin.luckymoney.ui.h.c;
import com.tencent.mm.plugin.wallet_core.ui.j.a;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.t;
import com.tenpay.android.wechat.MyKeyboardWindow;
import java.util.Map;

@com.tencent.mm.ui.base.a(19)
public class SnsLuckyMoneyPrepareUI
  extends LuckyMoneyBaseUI
  implements com.tencent.mm.plugin.luckymoney.ui.g
{
  private ap gIs;
  protected Dialog gKM;
  private ScrollView hLr;
  private TextView kRB;
  protected TextView kRx;
  protected Button lqP;
  private int mChannel;
  protected View mKBLayout;
  protected MyKeyboardWindow mKeyboard;
  private com.tencent.mm.wallet_core.ui.a mTenpayKBStateListener;
  private int mType;
  private i oiV;
  protected LuckyMoneyNumInputView ojG;
  protected LuckyMoneyTextInputView ojI;
  protected Button ojJ;
  private TextView ojN;
  private b ojP;
  protected LuckyMoneyMoneyInputView oqE;
  private View oqF;
  private View oqG;
  private ViewGroup oqH;
  private int oqI;
  private String oqJ;
  private int oqK;
  private boolean oqL;
  private String oqM;
  
  public SnsLuckyMoneyPrepareUI()
  {
    AppMethodBeat.i(42532);
    this.ojG = null;
    this.oqE = null;
    this.ojI = null;
    this.kRx = null;
    this.ojJ = null;
    this.lqP = null;
    this.gKM = null;
    this.ojP = new b();
    this.gIs = null;
    AppMethodBeat.o(42532);
  }
  
  private int bNH()
  {
    AppMethodBeat.i(42543);
    if (this.oqL)
    {
      if (getIntent().getIntExtra("key_chatroom_num", 0) > 0)
      {
        AppMethodBeat.o(42543);
        return 2;
      }
      AppMethodBeat.o(42543);
      return 1;
    }
    AppMethodBeat.o(42543);
    return 3;
  }
  
  protected final void Z(View paramView, int paramInt)
  {
    AppMethodBeat.i(42539);
    this.mKeyboard = ((MyKeyboardWindow)findViewById(2131822419));
    this.mKBLayout = findViewById(2131822418);
    View localView = findViewById(2131822420);
    EditText localEditText = (EditText)paramView.findViewById(2131825700);
    if ((this.mKeyboard == null) || (localEditText == null) || (this.mKBLayout == null))
    {
      AppMethodBeat.o(42539);
      return;
    }
    com.tencent.mm.wallet_core.ui.e.setNoSystemInputOnEditText(localEditText);
    localEditText.setOnFocusChangeListener(new SnsLuckyMoneyPrepareUI.10(this, paramInt, localEditText));
    localEditText.setOnClickListener(new SnsLuckyMoneyPrepareUI.12(this, paramInt, localEditText));
    paramView = (TextView)paramView.findViewById(2131825701);
    if (paramView != null) {
      paramView.setOnClickListener(new SnsLuckyMoneyPrepareUI.13(this, paramInt, localEditText));
    }
    localView.setOnClickListener(new SnsLuckyMoneyPrepareUI.14(this));
    AppMethodBeat.o(42539);
  }
  
  public final void bMQ()
  {
    AppMethodBeat.i(42542);
    com.tencent.mm.plugin.luckymoney.b.a.bMG();
    this.oiV = com.tencent.mm.plugin.luckymoney.b.a.bMH().bNk();
    int i;
    double d2;
    double d1;
    if ((this.oqE.bMP() != 3) && (this.ojG.bMP() != 3))
    {
      i = this.ojG.getInput();
      d2 = this.oqE.getInput();
      if (this.mType == 0)
      {
        d2 *= i;
        d1 = this.oqE.getInput();
      }
    }
    for (;;)
    {
      if (this.ojP.bNY())
      {
        this.ojJ.setClickable(false);
        this.ojJ.setEnabled(false);
        this.kRx.setText(com.tencent.mm.wallet_core.ui.e.F(d2));
        AppMethodBeat.o(42542);
        return;
        if (i > 0) {
          d1 = this.oqE.getInput() / i;
        }
      }
      else
      {
        if ((d2 == 0.0D) || (d1 == 0.0D)) {
          i = 1;
        }
        for (;;)
        {
          label157:
          if (i != 0)
          {
            this.ojJ.setClickable(false);
            this.ojJ.setEnabled(false);
            break;
            if ((d2 > this.oiV.oiu) && (this.oiV.oiu > 0.0D))
            {
              this.ojP.EC(getString(2131301332, new Object[] { Math.round(this.oiV.oiu), bo.bf(this.oiV.oix, "") }));
              i = 1;
              continue;
            }
            if (d1 <= 0.0D) {
              break label648;
            }
            if (this.mType == 0)
            {
              if ((d1 <= this.oiV.ois) || (this.oiV.ois <= 0.0D)) {
                break label642;
              }
              this.ojP.EC(getString(2131301280, new Object[] { Math.round(this.oiV.ois), bo.bf(this.oiV.oix, "") }));
              i = 1;
            }
          }
          for (;;)
          {
            if (i == 0)
            {
              if (this.mType == 0)
              {
                if (d1 >= this.oiV.oit) {
                  break label639;
                }
                this.ojP.EC(getString(2131301282, new Object[] { com.tencent.mm.wallet_core.ui.e.E(this.oiV.oit), bo.bf(this.oiV.oix, "") }));
                i = 1;
                break label157;
                if ((d1 <= this.oiV.oiv) || (this.oiV.oiv <= 0.0D)) {
                  break label642;
                }
                this.ojP.EC(getString(2131301280, new Object[] { Math.round(this.oiV.oiv), bo.bf(this.oiV.oix, "") }));
                this.ojG.onError();
                this.oqE.onError();
                i = 1;
                continue;
              }
              if (d1 < 0.01D)
              {
                this.ojP.EC(getString(2131301282, new Object[] { "0.01", bo.bf(this.oiV.oix, "") }));
                this.ojG.onError();
                this.oqE.onError();
                i = 1;
                break label157;
                this.ojJ.setClickable(true);
                this.ojJ.setEnabled(true);
                break;
              }
            }
            label639:
            break label157;
            label642:
            i = 0;
          }
          label648:
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
    AppMethodBeat.i(42536);
    if ((paramKeyEvent.getKeyCode() == 4) && (this.oqF.getVisibility() == 0))
    {
      this.oqF.setVisibility(8);
      bNP();
      AppMethodBeat.o(42536);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(42536);
    return bool;
  }
  
  public int getLayoutId()
  {
    return 2130970042;
  }
  
  protected final void hideTenpayKB()
  {
    AppMethodBeat.i(42541);
    if ((this.mKBLayout != null) && (this.mKBLayout.isShown()))
    {
      this.mKBLayout.setVisibility(8);
      this.mTenpayKBStateListener.onVisibleStateChange(false);
    }
    AppMethodBeat.o(42541);
  }
  
  public void initView()
  {
    AppMethodBeat.i(42534);
    getResources().getDrawable(2130839340);
    setBackBtn(new SnsLuckyMoneyPrepareUI.1(this));
    this.oqF = findViewById(2131825801);
    this.oqG = findViewById(2131825806);
    this.lqP = ((Button)findViewById(2131825805));
    this.ojI = ((LuckyMoneyTextInputView)findViewById(2131825789));
    this.ojI.setHintText(getString(2131301208));
    this.ojJ = ((Button)findViewById(2131825798));
    this.mKeyboard = ((MyKeyboardWindow)findViewById(2131822419));
    this.mKBLayout = findViewById(2131822418);
    this.kRB = ((TextView)findViewById(2131825786));
    this.ojG = ((LuckyMoneyNumInputView)findViewById(2131825787));
    this.oqE = ((LuckyMoneyMoneyInputView)findViewById(2131825785));
    this.kRx = ((TextView)findViewById(2131825797));
    this.oqH = ((ViewGroup)findViewById(2131825800));
    this.hLr = ((ScrollView)findViewById(2131825783));
    this.ojN = ((TextView)findViewById(2131825784));
    Object localObject1;
    if (this.mType == 1)
    {
      this.oqE.setTitle(getString(2131301333));
      this.oqE.setShowGroupIcon(true);
      this.oqE.setOnInputValidChangerListener(this);
      this.ojG.setOnInputValidChangerListener(this);
      this.ojI.setOnInputValidChangerListener(this);
      localObject1 = (EditText)this.oqE.findViewById(2131825700);
      Object localObject2 = (EditText)this.ojG.findViewById(2131825700);
      com.tencent.mm.wallet_core.ui.e.setNoSystemInputOnEditText((EditText)localObject1);
      ((InputMethodManager)getContext().getSystemService("input_method")).showSoftInput((View)localObject1, 0);
      ((EditText)localObject1).setOnClickListener(new SnsLuckyMoneyPrepareUI.19(this, (EditText)localObject1, (EditText)localObject2));
      Object localObject3 = (TextView)this.oqE.findViewById(2131825701);
      if (localObject3 != null) {
        ((TextView)localObject3).setOnClickListener(new SnsLuckyMoneyPrepareUI.20(this, (EditText)localObject1, (EditText)localObject2));
      }
      com.tencent.mm.wallet_core.ui.e.setNoSystemInputOnEditText((EditText)localObject2);
      ((InputMethodManager)getContext().getSystemService("input_method")).showSoftInput((View)localObject2, 0);
      ((EditText)localObject2).setOnClickListener(new SnsLuckyMoneyPrepareUI.21(this, (EditText)localObject1, (EditText)localObject2));
      if (this.oiV != null)
      {
        if (this.mType != 1) {
          break label1031;
        }
        this.oqE.setMaxAmount(this.oiV.oiu);
        label442:
        this.oqE.setMinAmount(this.oiV.oit);
      }
      if ((!this.oqL) || (getIntent().getIntExtra("key_chatroom_num", 0) > 1)) {
        break label1048;
      }
      this.ojG.setNum("1");
      label487:
      this.ojG.setMaxNum(this.oiV.oir);
      this.ojG.setMinNum(1);
      ab.d("MicroMsg.LuckyMoneyPrepareUI", "init num=" + this.ojG.getInput());
      this.oqE.setMaxLen(12);
      if (!this.oqL) {
        break label1073;
      }
      if (getIntent().getIntExtra("key_chatroom_num", 0) <= 0) {
        break label1061;
      }
      Object localObject4 = getString(2131301243);
      Object localObject5 = getString(2131301240);
      localObject1 = getString(2131301242);
      localObject2 = getString(2131301241);
      localObject3 = new SpannableString((String)localObject4 + (String)localObject5);
      com.tencent.mm.plugin.wallet_core.ui.j localj = new com.tencent.mm.plugin.wallet_core.ui.j(this);
      ((SpannableString)localObject3).setSpan(localj, ((String)localObject4).length(), ((String)localObject4).length() + ((String)localObject5).length(), 33);
      localObject4 = new SpannableString((String)localObject1 + (String)localObject2);
      localObject5 = new com.tencent.mm.plugin.wallet_core.ui.j(this);
      ((SpannableString)localObject4).setSpan(localObject5, ((String)localObject1).length(), ((String)localObject1).length() + ((String)localObject2).length(), 33);
      localj.uqj = new j.a()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(42520);
          int i = SnsLuckyMoneyPrepareUI.this.ojG.getInput();
          double d = SnsLuckyMoneyPrepareUI.this.oqE.getInput();
          SnsLuckyMoneyPrepareUI.a(SnsLuckyMoneyPrepareUI.this, 0);
          SnsLuckyMoneyPrepareUI.this.oqE.setType(SnsLuckyMoneyPrepareUI.a(SnsLuckyMoneyPrepareUI.this));
          SnsLuckyMoneyPrepareUI.this.oqE.setShowGroupIcon(false);
          SnsLuckyMoneyPrepareUI.this.oqE.setTitle(SnsLuckyMoneyPrepareUI.this.getString(2131301334));
          if ((d > 0.0D) && (i > 0)) {
            SnsLuckyMoneyPrepareUI.this.oqE.setAmount(com.tencent.mm.wallet_core.ui.e.E(d / i));
          }
          SnsLuckyMoneyPrepareUI.this.oqE.setMaxAmount(SnsLuckyMoneyPrepareUI.b(SnsLuckyMoneyPrepareUI.this).ois);
          SnsLuckyMoneyPrepareUI.c(SnsLuckyMoneyPrepareUI.this).setText(this.ojV);
          com.tencent.mm.plugin.report.service.h.qsU.e(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(SnsLuckyMoneyPrepareUI.d(SnsLuckyMoneyPrepareUI.this)), Integer.valueOf(3) });
          AppMethodBeat.o(42520);
        }
      };
      ((com.tencent.mm.plugin.wallet_core.ui.j)localObject5).uqj = new SnsLuckyMoneyPrepareUI.15(this, (SpannableString)localObject3);
      this.kRB.setMovementMethod(LinkMovementMethod.getInstance());
      this.kRB.setText((CharSequence)localObject3);
      this.kRB.setVisibility(0);
    }
    for (;;)
    {
      this.ojJ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(42526);
          com.tencent.mm.plugin.report.service.h.qsU.e(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(SnsLuckyMoneyPrepareUI.d(SnsLuckyMoneyPrepareUI.this)), Integer.valueOf(4) });
          if (SnsLuckyMoneyPrepareUI.this.oqE.bMP() != 0)
          {
            t.makeText(SnsLuckyMoneyPrepareUI.this.getContext(), 2131304847, 0).show();
            AppMethodBeat.o(42526);
            return;
          }
          int i = SnsLuckyMoneyPrepareUI.this.ojG.getInput();
          double d = SnsLuckyMoneyPrepareUI.this.oqE.getInput();
          long l2 = 0L;
          long l1;
          String str;
          if (SnsLuckyMoneyPrepareUI.a(SnsLuckyMoneyPrepareUI.this) == 1)
          {
            l1 = com.tencent.mm.wallet_core.ui.e.G(d);
            com.tencent.mm.kernel.g.RM();
            com.tencent.mm.kernel.g.RL().Ru().set(356354, Integer.valueOf(i));
            str = SnsLuckyMoneyPrepareUI.this.ojI.getInput();
            paramAnonymousView = str;
            if (bo.isNullOrNil(str)) {
              paramAnonymousView = SnsLuckyMoneyPrepareUI.this.getString(2131301208);
            }
            str = SnsLuckyMoneyPrepareUI.this.getIntent().getStringExtra("key_username");
            if ((!SnsLuckyMoneyPrepareUI.e(SnsLuckyMoneyPrepareUI.this)) || (bo.isNullOrNil(str))) {
              break label343;
            }
          }
          label343:
          for (paramAnonymousView = new ao(i, l1, l2, SnsLuckyMoneyPrepareUI.a(SnsLuckyMoneyPrepareUI.this), paramAnonymousView, x.bNq(), str, x.nD(str), r.Zn(), r.Zp(), SnsLuckyMoneyPrepareUI.f(SnsLuckyMoneyPrepareUI.this), "");; paramAnonymousView = new ao(i, l1, l2, SnsLuckyMoneyPrepareUI.a(SnsLuckyMoneyPrepareUI.this), paramAnonymousView, x.bNq(), null, null, r.Zn(), r.Zp(), SnsLuckyMoneyPrepareUI.f(SnsLuckyMoneyPrepareUI.this), ""))
          {
            SnsLuckyMoneyPrepareUI.this.doSceneProgress(paramAnonymousView, false);
            if (SnsLuckyMoneyPrepareUI.this.gKM == null) {
              break label388;
            }
            SnsLuckyMoneyPrepareUI.this.gKM.show();
            AppMethodBeat.o(42526);
            return;
            l1 = com.tencent.mm.wallet_core.ui.e.G(i * d);
            l2 = com.tencent.mm.wallet_core.ui.e.G(d);
            com.tencent.mm.kernel.g.RM();
            com.tencent.mm.kernel.g.RL().Ru().set(356353, Integer.valueOf(i));
            break;
          }
          label388:
          SnsLuckyMoneyPrepareUI.this.gKM = com.tencent.mm.wallet_core.ui.g.a(SnsLuckyMoneyPrepareUI.this.getContext(), true, new SnsLuckyMoneyPrepareUI.16.1(this));
          AppMethodBeat.o(42526);
        }
      });
      this.kRx.setText(com.tencent.mm.wallet_core.ui.e.F(0.0D));
      this.ojP.a(this.ojG);
      this.ojP.a(this.oqE);
      this.ojP.a(this.ojI);
      localObject1 = (TextView)findViewById(2131825807);
      this.ojP.i((TextView)localObject1);
      if ((this.oqL) && (this.mType == 1))
      {
        localObject1 = (TextView)findViewById(2131825788);
        ((TextView)localObject1).setText(getString(2131301268, new Object[] { Integer.valueOf(getIntent().getIntExtra("key_chatroom_num", 8)) }));
        ((TextView)localObject1).setVisibility(0);
      }
      this.gIs = new ap(new ap.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(42527);
          int i;
          double d2;
          if ((SnsLuckyMoneyPrepareUI.this.oqE.bMP() != 3) && (SnsLuckyMoneyPrepareUI.this.ojG.bMP() != 3))
          {
            i = SnsLuckyMoneyPrepareUI.this.ojG.getInput();
            d2 = SnsLuckyMoneyPrepareUI.this.oqE.getInput();
            d1 = d2;
            if (SnsLuckyMoneyPrepareUI.a(SnsLuckyMoneyPrepareUI.this) != 0) {}
          }
          for (double d1 = d2 * i;; d1 = 0.0D)
          {
            if ((d1 == 0.0D) || (d1 > SnsLuckyMoneyPrepareUI.b(SnsLuckyMoneyPrepareUI.this).oiu) || (SnsLuckyMoneyPrepareUI.i(SnsLuckyMoneyPrepareUI.this).bNZ()))
            {
              SnsLuckyMoneyPrepareUI.this.ojJ.setClickable(false);
              SnsLuckyMoneyPrepareUI.this.ojJ.setEnabled(false);
            }
            for (;;)
            {
              ab.i("MicroMsg.LuckyMoneyPrepareUI", "onTimeExpired & check: amount=" + d1 + ", hasErr=" + SnsLuckyMoneyPrepareUI.i(SnsLuckyMoneyPrepareUI.this).bNZ());
              SnsLuckyMoneyPrepareUI.j(SnsLuckyMoneyPrepareUI.this).dtj();
              AppMethodBeat.o(42527);
              return false;
              SnsLuckyMoneyPrepareUI.this.ojJ.setClickable(true);
              SnsLuckyMoneyPrepareUI.this.ojJ.setEnabled(true);
            }
          }
        }
      }, false);
      if (this.hLr != null) {
        this.hLr.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(42528);
            if (paramAnonymousMotionEvent.getAction() == 0)
            {
              SnsLuckyMoneyPrepareUI.this.hideTenpayKB();
              SnsLuckyMoneyPrepareUI.this.hideVKB();
            }
            AppMethodBeat.o(42528);
            return false;
          }
        });
      }
      this.oqE.setType(this.mType);
      if ((!this.oqL) || (getIntent().getIntExtra("key_chatroom_num", 0) != 0)) {
        break label1138;
      }
      this.oqE.requestFocus();
      AppMethodBeat.o(42534);
      return;
      this.oqE.setTitle(getString(2131301334));
      this.oqE.setShowGroupIcon(false);
      break;
      label1031:
      this.oqE.setMaxAmount(this.oiV.ois);
      break label442;
      label1048:
      this.ojG.setNum("");
      break label487;
      label1061:
      this.ojG.setVisibility(8);
      continue;
      label1073:
      if (this.mType == 1)
      {
        this.kRB.setText(this.oiV.onj);
        this.kRB.setVisibility(0);
      }
      else if (this.mType == 0)
      {
        this.kRB.setText(this.oiV.onk);
        this.kRB.setVisibility(0);
      }
    }
    label1138:
    this.ojG.requestFocus();
    AppMethodBeat.o(42534);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(42538);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(42538);
      return;
      if (paramInt2 == -1)
      {
        com.tencent.mm.plugin.report.service.h.qsU.e(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(bNH()), Integer.valueOf(5) });
        Object localObject1 = getIntent().getStringExtra("key_username");
        if ((this.oqL) && (!bo.isNullOrNil((String)localObject1)))
        {
          com.tencent.mm.ui.base.h.bO(this, getString(2131300637));
          Object localObject2 = br.F(this.oqM, "msg");
          if (localObject2 == null)
          {
            ab.e("MicroMsg.LuckyMoneyPrepareUI", "luckymoneyPrepareUI onActivityResult values is null");
            finish();
            AppMethodBeat.o(42538);
            return;
          }
          localObject2 = (String)((Map)localObject2).get(".msg.appmsg.wcpayinfo.paymsgid");
          if (com.tencent.mm.plugin.luckymoney.b.a.bMG().bMJ().Sr((String)localObject2))
          {
            ab.i("MicroMsg.LuckyMoneyPrepareUI", "insert a local msg for luckymoney");
            if (!x.J(this.oqM, (String)localObject1, 1))
            {
              ab.e("MicroMsg.LuckyMoneyPrepareUI", "LuckyMoneyUtil.sendLocalMsg fail!");
              com.tencent.mm.plugin.luckymoney.b.a.bMG().bMJ().Ss((String)localObject2);
            }
          }
          for (;;)
          {
            finish();
            break;
            ab.e("MicroMsg.LuckyMoneyPrepareUI", "it is a duplicate msg");
          }
        }
        bNQ();
        new ak().postDelayed(new SnsLuckyMoneyPrepareUI.7(this), 200L);
        this.lqP.setOnClickListener(new SnsLuckyMoneyPrepareUI.8(this));
        ((ImageView)findViewById(2131825804)).setOnClickListener(new SnsLuckyMoneyPrepareUI.9(this));
        continue;
        if ((paramInt2 == -1) && (paramIntent != null))
        {
          localObject1 = paramIntent.getStringExtra("Select_Conv_User");
          com.tencent.mm.plugin.report.service.h.qsU.e(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(bNH()), Integer.valueOf(7), localObject1 });
          if (!bo.isNullOrNil((String)localObject1)) {
            doSceneProgress(new ar(((String)localObject1).replaceAll(",", "|"), this.oqJ, "v1.0"));
          } else {
            finish();
          }
        }
        else if (paramInt2 == 0)
        {
          localObject1 = new Intent();
          ((Intent)localObject1).setClass(getContext(), LuckyMoneyMyRecordUI.class);
          ((Intent)localObject1).putExtra("key_type", 1);
          startActivity((Intent)localObject1);
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(42533);
    super.onCreate(paramBundle);
    this.mType = getIntent().getIntExtra("key_type", 1);
    this.oqI = getIntent().getIntExtra("key_way", 3);
    if (getIntent().getIntExtra("key_from", 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.oqL = bool;
      this.mChannel = getIntent().getIntExtra("pay_channel", -1);
      doSceneProgress(new ag("v1.0", 0, (byte)0), false);
      com.tencent.mm.plugin.luckymoney.b.a.bMG();
      this.oiV = com.tencent.mm.plugin.luckymoney.b.a.bMH().bNk();
      ab.d("MicroMsg.LuckyMoneyPrepareUI", "type=" + this.mType + ", fromAppPanel=" + this.oqL + ", config " + this.oiV);
      initView();
      com.tencent.mm.plugin.report.service.h.qsU.e(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(bNH()), Integer.valueOf(1) });
      AppMethodBeat.o(42533);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(42535);
    super.onDestroy();
    this.ojP.clear();
    this.gIs.dtj();
    if ((this.gKM != null) && (this.gKM.isShowing())) {
      this.gKM.dismiss();
    }
    AppMethodBeat.o(42535);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(42540);
    if ((paramInt == 4) && (this.mKBLayout != null) && (this.mKBLayout.isShown()))
    {
      hideTenpayKB();
      AppMethodBeat.o(42540);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(42540);
    return bool;
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(42537);
    if ((paramm instanceof ao))
    {
      if ((this.gKM != null) && (this.gKM.isShowing())) {
        this.gKM.hide();
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (ao)paramm;
        this.oqK = paramString.kNn;
        this.oqJ = paramString.ojA;
        this.oqM = paramString.opz;
        paramm = new PayInfo();
        paramm.cnI = paramString.opy;
        paramm.cCD = 37;
        paramm.cCy = this.mChannel;
        com.tencent.mm.pluginsdk.wallet.h.a(this, paramm, 1);
        AppMethodBeat.o(42537);
        return true;
      }
      if (paramInt2 == 401)
      {
        this.ojJ.setEnabled(false);
        this.ojJ.setClickable(false);
        this.gIs.ag(5000L, 5000L);
        com.tencent.mm.ui.base.h.bO(this, paramString);
        AppMethodBeat.o(42537);
        return true;
      }
      com.tencent.mm.ui.base.h.bO(this, paramString);
      AppMethodBeat.o(42537);
      return true;
    }
    if ((paramm instanceof ar))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (this.oqL)
        {
          com.tencent.mm.ui.base.h.bO(this, getString(2131300637));
          finish();
        }
        for (;;)
        {
          AppMethodBeat.o(42537);
          return true;
          bNQ();
          this.oqG.postDelayed(new SnsLuckyMoneyPrepareUI.2(this), 1000L);
        }
      }
      if (paramInt2 == 402)
      {
        com.tencent.mm.ui.base.h.d(getContext(), paramString, "", getString(2131301313), getString(2131296888), new SnsLuckyMoneyPrepareUI.3(this), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(42537);
        return true;
      }
    }
    else if ((paramm instanceof ag))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (ag)paramm;
        com.tencent.mm.plugin.luckymoney.b.a.bMG();
        this.oiV = com.tencent.mm.plugin.luckymoney.b.a.bMH().bNk();
        ab.d("MicroMsg.LuckyMoneyPrepareUI", "update config:" + this.oiV);
        if (this.mType != 1) {
          break label656;
        }
        this.oqE.setMaxAmount(this.oiV.oiu);
        this.oqE.setMinAmount(this.oiV.oit);
        this.ojG.setMaxNum(this.oiV.oir);
        if ((paramString.opf) && (this.oqL))
        {
          paramm = (TextView)findViewById(2131825799);
          paramm.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(42511);
              com.tencent.mm.plugin.report.service.h.qsU.e(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(SnsLuckyMoneyPrepareUI.d(SnsLuckyMoneyPrepareUI.this)), Integer.valueOf(9) });
              paramAnonymousView = new Intent();
              paramAnonymousView.setClass(SnsLuckyMoneyPrepareUI.this.getContext(), LuckyMoneyCanShareListUI.class);
              SnsLuckyMoneyPrepareUI.this.startActivity(paramAnonymousView);
              AppMethodBeat.o(42511);
            }
          });
          com.tencent.mm.plugin.report.service.h.qsU.e(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(bNH()), Integer.valueOf(8) });
          paramm.setVisibility(0);
        }
        if (bo.isNullOrNil(paramString.kNG)) {
          break label673;
        }
        ab.i("MicroMsg.LuckyMoneyPrepareUI", "Put notice :" + paramString.kNG);
        this.ojN.setText(paramString.kNG);
        if (!bo.isNullOrNil(paramString.oph)) {
          this.ojN.setOnClickListener(new SnsLuckyMoneyPrepareUI.6(this, paramString));
        }
        this.ojN.setVisibility(0);
      }
      for (;;)
      {
        paramm = new h.c();
        paramm.textColor = getResources().getColor(2131690648);
        com.tencent.mm.plugin.luckymoney.ui.h.a(this, this.oqH, paramString.opj, paramm);
        AppMethodBeat.o(42537);
        return true;
        label656:
        this.oqE.setMaxAmount(this.oiV.ois);
        break;
        label673:
        this.ojN.setVisibility(8);
      }
    }
    AppMethodBeat.o(42537);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI
 * JD-Core Version:    0.7.0.1
 */