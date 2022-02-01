package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bn;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.platformtools.e;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.plugin.account.model.c.1;
import com.tencent.mm.plugin.account.model.c.a;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.base.MMClearEditText;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.xlog.app.XLogSetup;

public class SimpleLoginUI
  extends MMWizardActivity
  implements com.tencent.mm.ak.g
{
  private TextWatcher auC;
  private String dxX;
  private ProgressDialog fts;
  private SecurityImage iJk;
  private String iPp;
  private com.tencent.mm.sdk.b.c iQA;
  private String iRN;
  private ResizeLayout iRR;
  private f iRj;
  private String iRn;
  private MMClearEditText iSD;
  private MMClearEditText iSE;
  private MMFormInputView iSF;
  private MMFormInputView iSG;
  private Button iSH;
  private MMKeyboardUperView iSK;
  
  public SimpleLoginUI()
  {
    AppMethodBeat.i(128778);
    this.fts = null;
    this.iJk = null;
    this.iRj = new f();
    this.dxX = "";
    this.auC = new SimpleLoginUI.1(this);
    this.iQA = new SimpleLoginUI.12(this);
    AppMethodBeat.o(128778);
  }
  
  private void aOO()
  {
    AppMethodBeat.i(128784);
    boolean bool = getIntent().getBooleanExtra("key_auto_login_wizard_exit", false);
    if (!bool) {
      cancel();
    }
    ZA(1);
    if (bool) {
      exit(1);
    }
    AppMethodBeat.o(128784);
  }
  
  private void aQH()
  {
    AppMethodBeat.i(128785);
    this.iRj.account = this.iSD.getText().toString().trim();
    this.iRj.iJl = this.iSE.getText().toString();
    if (this.iRj.account.equals(""))
    {
      h.l(this, 2131764665, 2131760766);
      AppMethodBeat.o(128785);
      return;
    }
    if (this.iRj.iJl.equals(""))
    {
      h.l(this, 2131764658, 2131760766);
      AppMethodBeat.o(128785);
      return;
    }
    hideVKB();
    s locals = new s(this.iRj.account, this.iRj.iJl, this.iPp, 0);
    com.tencent.mm.kernel.g.agi().a(locals, 0);
    getString(2131755906);
    this.fts = h.b(this, getString(2131760781), true, new SimpleLoginUI.5(this, locals));
    AppMethodBeat.o(128785);
  }
  
  public int getLayoutId()
  {
    return 2131494602;
  }
  
  public void initView()
  {
    AppMethodBeat.i(128783);
    this.iSF = ((MMFormInputView)findViewById(2131301558));
    this.iSG = ((MMFormInputView)findViewById(2131301577));
    this.iSD = ((MMClearEditText)this.iSF.getContentEditText());
    this.iSD.setFocusableInTouchMode(false);
    this.iSD.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(128771);
        SimpleLoginUI.c(SimpleLoginUI.this).setFocusableInTouchMode(true);
        boolean bool = SimpleLoginUI.c(SimpleLoginUI.this).getDefaultOnTouchListener().onTouch(paramAnonymousView, paramAnonymousMotionEvent);
        AppMethodBeat.o(128771);
        return bool;
      }
    });
    this.iSE = ((MMClearEditText)this.iSG.getContentEditText());
    this.iSE.setFocusableInTouchMode(false);
    this.iSE.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(128772);
        SimpleLoginUI.d(SimpleLoginUI.this).setFocusableInTouchMode(true);
        SimpleLoginUI.c(SimpleLoginUI.this).setFocusableInTouchMode(false);
        boolean bool = SimpleLoginUI.d(SimpleLoginUI.this).getDefaultOnTouchListener().onTouch(paramAnonymousView, paramAnonymousMotionEvent);
        AppMethodBeat.o(128772);
        return bool;
      }
    });
    com.tencent.mm.ui.tools.b.c.d(this.iSE).acw(16).a(null);
    this.iSH = ((Button)findViewById(2131301562));
    this.iSH.setEnabled(false);
    this.iSD.addTextChangedListener(this.auC);
    this.iSE.addTextChangedListener(this.auC);
    this.iSE.setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(128773);
        if ((paramAnonymousInt == 6) || (paramAnonymousInt == 5))
        {
          SimpleLoginUI.b(SimpleLoginUI.this);
          AppMethodBeat.o(128773);
          return true;
        }
        AppMethodBeat.o(128773);
        return false;
      }
    });
    this.iSE.setOnKeyListener(new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(128774);
        if ((66 == paramAnonymousInt) && (paramAnonymousKeyEvent.getAction() == 0))
        {
          SimpleLoginUI.b(SimpleLoginUI.this);
          AppMethodBeat.o(128774);
          return true;
        }
        AppMethodBeat.o(128774);
        return false;
      }
    });
    this.iRR = ((ResizeLayout)findViewById(2131304133));
    this.iSK = ((MMKeyboardUperView)findViewById(2131304370));
    this.iRR.setOnSizeChanged(new ResizeLayout.a()
    {
      public final void aQL()
      {
        AppMethodBeat.i(128776);
        SimpleLoginUI.e(SimpleLoginUI.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(128775);
            SimpleLoginUI.e(SimpleLoginUI.this).fullScroll(130);
            AppMethodBeat.o(128775);
          }
        });
        AppMethodBeat.o(128776);
      }
    });
    this.iSK.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(128777);
        SimpleLoginUI.this.hideVKB();
        AppMethodBeat.o(128777);
        return false;
      }
    });
    findViewById(2131301569).setVisibility(8);
    setMMTitle(2131760787);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(128759);
        SimpleLoginUI.f(SimpleLoginUI.this);
        AppMethodBeat.o(128759);
        return true;
      }
    });
    this.iPp = getIntent().getStringExtra("auth_ticket");
    if (!bs.isNullOrNil(this.iPp))
    {
      this.iSD.setText(bs.nullAsNil(f.aQM()));
      this.iSE.setText(bs.nullAsNil(f.aQN()));
      new ao().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(128760);
          SimpleLoginUI.b(SimpleLoginUI.this);
          AppMethodBeat.o(128760);
        }
      }, 500L);
    }
    if (i.GqL) {
      com.tencent.mm.plugin.account.a.a.iyy.t(this);
    }
    this.iSH.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(128761);
        SimpleLoginUI.b(SimpleLoginUI.this);
        AppMethodBeat.o(128761);
      }
    });
    AppMethodBeat.o(128783);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 0;
    AppMethodBeat.i(128789);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    boolean bool;
    String str;
    if (paramIntent == null)
    {
      bool = true;
      ac.d("MicroMsg.SimpleLoginUI", "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      if ((paramInt2 != -1) || (paramInt1 != 1024) || (paramIntent == null)) {
        break label178;
      }
      str = paramIntent.getStringExtra("VoiceLoginAuthPwd");
      paramInt2 = paramIntent.getIntExtra("KVoiceHelpCode", 0);
      bool = bs.isNullOrNil(str);
      if (!bs.isNullOrNil(str)) {
        break label169;
      }
    }
    label169:
    for (paramInt1 = i;; paramInt1 = str.length())
    {
      ac.d("MicroMsg.SimpleLoginUI", "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (paramInt2 != -217) {
        break label178;
      }
      aQH();
      AppMethodBeat.o(128789);
      return;
      bool = false;
      break;
    }
    label178:
    AppMethodBeat.o(128789);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128779);
    super.onCreate(paramBundle);
    paramBundle = getSharedPreferences("system_config_prefs", com.tencent.mm.compatible.util.g.YK());
    if (paramBundle.getBoolean("first_launch_weixin", true))
    {
      paramBundle.edit().putBoolean("first_launch_weixin", false).commit();
      XLogSetup.realSetupXlog();
    }
    setMMTitle(2131755822);
    if (com.tencent.mm.plugin.account.a.a.iyy != null) {
      com.tencent.mm.plugin.account.a.a.iyy.Lm();
    }
    initView();
    com.tencent.mm.kernel.g.agi().a(701, this);
    com.tencent.mm.kernel.g.agi().a(252, this);
    if (!b.aP(this))
    {
      new Intent().addFlags(67108864);
      com.tencent.mm.plugin.account.a.a.iyx.p(new Intent(), this);
    }
    AppMethodBeat.o(128779);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128781);
    com.tencent.mm.kernel.g.agi().b(701, this);
    com.tencent.mm.kernel.g.agi().b(252, this);
    super.onDestroy();
    AppMethodBeat.o(128781);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(128786);
    if (paramInt == 4)
    {
      aOO();
      AppMethodBeat.o(128786);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(128786);
    return bool;
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(128782);
    super.onNewIntent(paramIntent);
    this.iPp = paramIntent.getStringExtra("auth_ticket");
    paramIntent = getIntent().getExtras();
    if (paramIntent != null) {
      this.iPp = paramIntent.getString("auth_ticket");
    }
    if (!bs.isNullOrNil(this.iPp))
    {
      this.iSD.setText(bs.nullAsNil(f.aQM()));
      this.iSE.setText(bs.nullAsNil(f.aQN()));
      new ao().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(128770);
          SimpleLoginUI.b(SimpleLoginUI.this);
          AppMethodBeat.o(128770);
        }
      }, 500L);
    }
    AppMethodBeat.o(128782);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(128787);
    if (this.fts != null)
    {
      this.fts.dismiss();
      this.fts = null;
    }
    super.onPause();
    com.tencent.mm.sdk.b.a.GpY.d(this.iQA);
    AppMethodBeat.o(128787);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(128780);
    com.tencent.mm.sdk.b.a.GpY.c(this.iQA);
    super.onResume();
    AppMethodBeat.o(128780);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(128788);
    ac.i("MicroMsg.SimpleLoginUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    ac.d("MicroMsg.SimpleLoginUI", "Scene Type " + paramn.getType());
    if (this.fts != null)
    {
      this.fts.dismiss();
      this.fts = null;
    }
    this.dxX = ((s)paramn).aHz();
    int i;
    if ((paramn.getType() == 252) || (paramn.getType() == 701))
    {
      this.iRj.iSx = ((s)paramn).getSecCodeType();
      this.iRj.iJn = ((s)paramn).aHA();
      this.iRj.iJm = ((s)paramn).aHB();
      this.iRj.iJo = ((s)paramn).aHC();
      if (paramInt2 == -205)
      {
        this.iPp = ((s)paramn).aEs();
        this.iRN = ((s)paramn).aHE();
        this.iRn = ((s)paramn).aHH();
      }
      if ((paramInt1 == 4) && ((paramInt2 == -16) || (paramInt2 == -17)))
      {
        i = 1;
        com.tencent.mm.kernel.g.agi().a(new bn(new SimpleLoginUI.10(this)), 0);
      }
    }
    for (;;)
    {
      if ((i != 0) || ((paramInt1 == 0) && (paramInt2 == 0)))
      {
        com.tencent.mm.kernel.a.unhold();
        t.cW(this);
        y.FH(this.iRj.account);
        paramString = new com.tencent.mm.plugin.account.model.c(getContext(), new SimpleLoginUI.11(this));
        paramString.dcV = com.tencent.mm.plugin.account.a.a.iyy.a(paramString);
        if (paramString.dcV == null)
        {
          if (paramString.iOk != null) {
            paramString.iOk.aQq();
          }
          AppMethodBeat.o(128788);
          return;
        }
        if (paramString.dcV.getType() == 139) {
          com.tencent.mm.kernel.g.agi().a(139, paramString);
        }
        for (;;)
        {
          com.tencent.mm.kernel.g.agi().a(paramString.dcV, 0);
          paramn = paramString.context;
          paramString.context.getString(2131755906);
          paramString.tipDialog = h.b(paramn, paramString.context.getString(2131755805), true, new c.1(paramString));
          AppMethodBeat.o(128788);
          return;
          if (paramString.dcV.getType() == 138) {
            com.tencent.mm.kernel.g.agi().a(138, paramString);
          }
        }
      }
      if (paramInt2 == -217)
      {
        y.a(this, e.a((s)paramn), paramInt2);
        AppMethodBeat.o(128788);
        return;
      }
      if (com.tencent.mm.plugin.account.a.a.iyy.a(getContext(), paramInt1, paramInt2, paramString)) {
        i = 1;
      }
      while (i != 0)
      {
        AppMethodBeat.o(128788);
        return;
        if (paramInt1 == 4) {}
        switch (paramInt2)
        {
        default: 
          i = 0;
          break;
        case -1: 
          if (com.tencent.mm.kernel.g.agi().aBK() == 5)
          {
            h.l(this, 2131761537, 2131761536);
            i = 1;
          }
          break;
        case -30: 
        case -4: 
        case -3: 
          h.l(this, 2131758459, 2131760766);
          i = 1;
          break;
        case -9: 
          h.l(this, 2131760765, 2131760766);
          i = 1;
          break;
        case -72: 
          h.l(getContext(), 2131762374, 2131755906);
          i = 1;
          break;
        case -75: 
          y.de(getContext());
          i = 1;
          break;
        case -311: 
        case -310: 
        case -6: 
          if (this.iJk == null) {
            this.iJk = SecurityImage.a.a(getContext(), this.iRj.iSx, this.iRj.iJm, this.iRj.iJn, this.iRj.iJo, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(128764);
                ac.d("MicroMsg.SimpleLoginUI", "imgSid:" + SimpleLoginUI.g(SimpleLoginUI.this).iJn + " img len" + SimpleLoginUI.g(SimpleLoginUI.this).iJm.length + " " + com.tencent.mm.compatible.util.f.YG());
                paramAnonymousDialogInterface = new s(SimpleLoginUI.g(SimpleLoginUI.this).account, SimpleLoginUI.g(SimpleLoginUI.this).iJl, SimpleLoginUI.g(SimpleLoginUI.this).iSx, SimpleLoginUI.h(SimpleLoginUI.this).getSecImgCode(), SimpleLoginUI.h(SimpleLoginUI.this).getSecImgSid(), SimpleLoginUI.h(SimpleLoginUI.this).getSecImgEncryptKey(), 0, "", false, false);
                com.tencent.mm.kernel.g.agi().a(paramAnonymousDialogInterface, 0);
                SimpleLoginUI localSimpleLoginUI1 = SimpleLoginUI.this;
                SimpleLoginUI localSimpleLoginUI2 = SimpleLoginUI.this;
                SimpleLoginUI.this.getString(2131755906);
                SimpleLoginUI.a(localSimpleLoginUI1, h.b(localSimpleLoginUI2, SimpleLoginUI.this.getString(2131760781), true, new SimpleLoginUI.6.1(this, paramAnonymousDialogInterface)));
                AppMethodBeat.o(128764);
              }
            }, null, new DialogInterface.OnDismissListener()
            {
              public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
              {
                AppMethodBeat.i(128765);
                SimpleLoginUI.i(SimpleLoginUI.this);
                AppMethodBeat.o(128765);
              }
            }, this.iRj);
          }
          for (;;)
          {
            i = 1;
            break;
            ac.d("MicroMsg.SimpleLoginUI", "imgSid:" + this.iRj.iJn + " img len" + this.iRj.iJm.length + " " + com.tencent.mm.compatible.util.f.YG());
            this.iJk.b(this.iRj.iSx, this.iRj.iJm, this.iRj.iJn, this.iRj.iJo);
          }
        case -100: 
          com.tencent.mm.kernel.a.hold();
          com.tencent.mm.kernel.g.agP();
          h.a(this, com.tencent.mm.kernel.a.afG(), getString(2131755906), new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          }, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
          });
          i = 1;
          break;
        case -205: 
          ac.i("MicroMsg.SimpleLoginUI", "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]", new Object[] { bs.aLJ(this.iPp), this.iRn });
          f.a(this.iRj);
          paramn = new Intent();
          paramn.putExtra("auth_ticket", this.iPp);
          paramn.putExtra("binded_mobile", this.iRN);
          paramn.putExtra("close_safe_device_style", this.iRn);
          paramn.putExtra("from_source", 3);
          com.tencent.mm.plugin.account.a.a.iyx.g(this, paramn);
          i = 1;
          break;
        case -140: 
          if (!bs.isNullOrNil(this.dxX)) {
            y.m(this, paramString, this.dxX);
          }
          i = 1;
          break;
        case -106: 
          y.g(this, paramString, 0);
          i = 1;
        }
      }
      paramString = com.tencent.mm.h.a.rM(paramString);
      if ((paramString != null) && (paramString.a(this, null, null)))
      {
        AppMethodBeat.o(128788);
        return;
      }
      Toast.makeText(this, getString(2131759490, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      AppMethodBeat.o(128788);
      return;
      i = 0;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.SimpleLoginUI
 * JD-Core Version:    0.7.0.1
 */