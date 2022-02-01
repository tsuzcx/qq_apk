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
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.model.bo;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.platformtools.e;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.plugin.account.model.c.1;
import com.tencent.mm.plugin.account.model.c.a;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.base.MMClearEditText;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.xlog.app.XLogSetup;

public class SimpleLoginUI
  extends MMWizardActivity
  implements com.tencent.mm.al.f
{
  private TextWatcher awu;
  private String dKk;
  private ProgressDialog fMu;
  private SecurityImage jct;
  private String jiy;
  private com.tencent.mm.sdk.b.c jjI;
  private String jkV;
  private ResizeLayout jkZ;
  private f jkr;
  private String jkv;
  private MMClearEditText jlL;
  private MMClearEditText jlM;
  private MMFormInputView jlN;
  private MMFormInputView jlO;
  private Button jlP;
  private MMKeyboardUperView jlS;
  
  public SimpleLoginUI()
  {
    AppMethodBeat.i(128778);
    this.fMu = null;
    this.jct = null;
    this.jkr = new f();
    this.dKk = "";
    this.awu = new SimpleLoginUI.1(this);
    this.jjI = new SimpleLoginUI.12(this);
    AppMethodBeat.o(128778);
  }
  
  private void aSa()
  {
    AppMethodBeat.i(128784);
    boolean bool = getIntent().getBooleanExtra("key_auto_login_wizard_exit", false);
    if (!bool) {
      cancel();
    }
    abK(1);
    if (bool) {
      exit(1);
    }
    AppMethodBeat.o(128784);
  }
  
  private void aTT()
  {
    AppMethodBeat.i(128785);
    this.jkr.account = this.jlL.getText().toString().trim();
    this.jkr.jcu = this.jlM.getText().toString();
    if (this.jkr.account.equals(""))
    {
      h.l(this, 2131764665, 2131760766);
      AppMethodBeat.o(128785);
      return;
    }
    if (this.jkr.jcu.equals(""))
    {
      h.l(this, 2131764658, 2131760766);
      AppMethodBeat.o(128785);
      return;
    }
    hideVKB();
    final s locals = new s(this.jkr.account, this.jkr.jcu, this.jiy, 0);
    com.tencent.mm.kernel.g.aiU().a(locals, 0);
    getString(2131755906);
    this.fMu = h.b(this, getString(2131760781), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(128762);
        com.tencent.mm.kernel.g.aiU().a(locals);
        AppMethodBeat.o(128762);
      }
    });
    AppMethodBeat.o(128785);
  }
  
  public int getLayoutId()
  {
    return 2131494602;
  }
  
  public void initView()
  {
    AppMethodBeat.i(128783);
    this.jlN = ((MMFormInputView)findViewById(2131301558));
    this.jlO = ((MMFormInputView)findViewById(2131301577));
    this.jlL = ((MMClearEditText)this.jlN.getContentEditText());
    this.jlL.setFocusableInTouchMode(false);
    this.jlL.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(128771);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/SimpleLoginUI$4", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
        SimpleLoginUI.c(SimpleLoginUI.this).setFocusableInTouchMode(true);
        boolean bool = SimpleLoginUI.c(SimpleLoginUI.this).getDefaultOnTouchListener().onTouch(paramAnonymousView, paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/account/ui/SimpleLoginUI$4", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(128771);
        return bool;
      }
    });
    this.jlM = ((MMClearEditText)this.jlO.getContentEditText());
    this.jlM.setFocusableInTouchMode(false);
    this.jlM.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(128772);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/SimpleLoginUI$5", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
        SimpleLoginUI.d(SimpleLoginUI.this).setFocusableInTouchMode(true);
        SimpleLoginUI.c(SimpleLoginUI.this).setFocusableInTouchMode(false);
        boolean bool = SimpleLoginUI.d(SimpleLoginUI.this).getDefaultOnTouchListener().onTouch(paramAnonymousView, paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/account/ui/SimpleLoginUI$5", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(128772);
        return bool;
      }
    });
    com.tencent.mm.ui.tools.b.c.d(this.jlM).aeU(16).a(null);
    this.jlP = ((Button)findViewById(2131301562));
    this.jlP.setEnabled(false);
    this.jlL.addTextChangedListener(this.awu);
    this.jlM.addTextChangedListener(this.awu);
    this.jlM.setOnEditorActionListener(new SimpleLoginUI.16(this));
    this.jlM.setOnKeyListener(new SimpleLoginUI.17(this));
    this.jkZ = ((ResizeLayout)findViewById(2131304133));
    this.jlS = ((MMKeyboardUperView)findViewById(2131304370));
    this.jkZ.setOnSizeChanged(new ResizeLayout.a()
    {
      public final void aTX()
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
    this.jlS.setOnTouchListener(new SimpleLoginUI.19(this));
    findViewById(2131301569).setVisibility(8);
    setMMTitle(2131760787);
    setBackBtn(new SimpleLoginUI.2(this));
    this.jiy = getIntent().getStringExtra("auth_ticket");
    if (!bt.isNullOrNil(this.jiy))
    {
      this.jlL.setText(bt.nullAsNil(f.aTY()));
      this.jlM.setText(bt.nullAsNil(f.aTZ()));
      new ap().postDelayed(new SimpleLoginUI.3(this), 500L);
    }
    if (j.Icz) {
      com.tencent.mm.plugin.account.a.a.iRH.t(this);
    }
    this.jlP.setOnClickListener(new SimpleLoginUI.4(this));
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
      ad.d("MicroMsg.SimpleLoginUI", "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      if ((paramInt2 != -1) || (paramInt1 != 1024) || (paramIntent == null)) {
        break label178;
      }
      str = paramIntent.getStringExtra("VoiceLoginAuthPwd");
      paramInt2 = paramIntent.getIntExtra("KVoiceHelpCode", 0);
      bool = bt.isNullOrNil(str);
      if (!bt.isNullOrNil(str)) {
        break label169;
      }
    }
    label169:
    for (paramInt1 = i;; paramInt1 = str.length())
    {
      ad.d("MicroMsg.SimpleLoginUI", "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (paramInt2 != -217) {
        break label178;
      }
      aTT();
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
    paramBundle = getSharedPreferences("system_config_prefs", com.tencent.mm.compatible.util.g.abm());
    if (paramBundle.getBoolean("first_launch_weixin", true))
    {
      paramBundle.edit().putBoolean("first_launch_weixin", false).commit();
      XLogSetup.realSetupXlog();
    }
    setMMTitle(2131755822);
    if (com.tencent.mm.plugin.account.a.a.iRH != null) {
      com.tencent.mm.plugin.account.a.a.iRH.MU();
    }
    initView();
    com.tencent.mm.kernel.g.aiU().a(701, this);
    com.tencent.mm.kernel.g.aiU().a(252, this);
    if (!com.tencent.mm.pluginsdk.permission.b.aP(this))
    {
      new Intent().addFlags(67108864);
      com.tencent.mm.plugin.account.a.a.iRG.p(new Intent(), this);
    }
    AppMethodBeat.o(128779);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128781);
    com.tencent.mm.kernel.g.aiU().b(701, this);
    com.tencent.mm.kernel.g.aiU().b(252, this);
    super.onDestroy();
    AppMethodBeat.o(128781);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(128786);
    if (paramInt == 4)
    {
      aSa();
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
    this.jiy = paramIntent.getStringExtra("auth_ticket");
    paramIntent = getIntent().getExtras();
    if (paramIntent != null) {
      this.jiy = paramIntent.getString("auth_ticket");
    }
    if (!bt.isNullOrNil(this.jiy))
    {
      this.jlL.setText(bt.nullAsNil(f.aTY()));
      this.jlM.setText(bt.nullAsNil(f.aTZ()));
      new ap().postDelayed(new SimpleLoginUI.13(this), 500L);
    }
    AppMethodBeat.o(128782);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(128787);
    if (this.fMu != null)
    {
      this.fMu.dismiss();
      this.fMu = null;
    }
    super.onPause();
    com.tencent.mm.sdk.b.a.IbL.d(this.jjI);
    AppMethodBeat.o(128787);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(128780);
    com.tencent.mm.sdk.b.a.IbL.c(this.jjI);
    super.onResume();
    AppMethodBeat.o(128780);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(128788);
    ad.i("MicroMsg.SimpleLoginUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    ad.d("MicroMsg.SimpleLoginUI", "Scene Type " + paramn.getType());
    if (this.fMu != null)
    {
      this.fMu.dismiss();
      this.fMu = null;
    }
    this.dKk = ((s)paramn).aKK();
    int i;
    if ((paramn.getType() == 252) || (paramn.getType() == 701))
    {
      this.jkr.jlF = ((s)paramn).getSecCodeType();
      this.jkr.jcw = ((s)paramn).aKL();
      this.jkr.jcv = ((s)paramn).aKM();
      this.jkr.jcx = ((s)paramn).aKN();
      if (paramInt2 == -205)
      {
        this.jiy = ((s)paramn).aHx();
        this.jkV = ((s)paramn).aKP();
        this.jkv = ((s)paramn).aKS();
      }
      if ((paramInt1 == 4) && ((paramInt2 == -16) || (paramInt2 == -17)))
      {
        i = 1;
        com.tencent.mm.kernel.g.aiU().a(new bo(new SimpleLoginUI.10(this)), 0);
      }
    }
    for (;;)
    {
      if ((i != 0) || ((paramInt1 == 0) && (paramInt2 == 0)))
      {
        com.tencent.mm.kernel.a.unhold();
        t.cU(this);
        y.IW(this.jkr.account);
        paramString = new com.tencent.mm.plugin.account.model.c(getContext(), new SimpleLoginUI.11(this));
        paramString.dor = com.tencent.mm.plugin.account.a.a.iRH.a(paramString);
        if (paramString.dor == null)
        {
          if (paramString.jht != null) {
            paramString.jht.aTC();
          }
          AppMethodBeat.o(128788);
          return;
        }
        if (paramString.dor.getType() == 139) {
          com.tencent.mm.kernel.g.aiU().a(139, paramString);
        }
        for (;;)
        {
          com.tencent.mm.kernel.g.aiU().a(paramString.dor, 0);
          paramn = paramString.context;
          paramString.context.getString(2131755906);
          paramString.tipDialog = h.b(paramn, paramString.context.getString(2131755805), true, new c.1(paramString));
          AppMethodBeat.o(128788);
          return;
          if (paramString.dor.getType() == 138) {
            com.tencent.mm.kernel.g.aiU().a(138, paramString);
          }
        }
      }
      if (paramInt2 == -217)
      {
        y.a(this, e.a((s)paramn), paramInt2);
        AppMethodBeat.o(128788);
        return;
      }
      if (com.tencent.mm.plugin.account.a.a.iRH.a(getContext(), paramInt1, paramInt2, paramString)) {
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
          if (com.tencent.mm.kernel.g.aiU().aEN() == 5)
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
          y.dc(getContext());
          i = 1;
          break;
        case -311: 
        case -310: 
        case -6: 
          if (this.jct == null) {
            this.jct = SecurityImage.a.a(getContext(), this.jkr.jlF, this.jkr.jcv, this.jkr.jcw, this.jkr.jcx, new DialogInterface.OnClickListener()
            {
              public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(128764);
                ad.d("MicroMsg.SimpleLoginUI", "imgSid:" + SimpleLoginUI.g(SimpleLoginUI.this).jcw + " img len" + SimpleLoginUI.g(SimpleLoginUI.this).jcv.length + " " + com.tencent.mm.compatible.util.f.abi());
                paramAnonymousDialogInterface = new s(SimpleLoginUI.g(SimpleLoginUI.this).account, SimpleLoginUI.g(SimpleLoginUI.this).jcu, SimpleLoginUI.g(SimpleLoginUI.this).jlF, SimpleLoginUI.h(SimpleLoginUI.this).getSecImgCode(), SimpleLoginUI.h(SimpleLoginUI.this).getSecImgSid(), SimpleLoginUI.h(SimpleLoginUI.this).getSecImgEncryptKey(), 0, "", false, false);
                com.tencent.mm.kernel.g.aiU().a(paramAnonymousDialogInterface, 0);
                SimpleLoginUI localSimpleLoginUI1 = SimpleLoginUI.this;
                SimpleLoginUI localSimpleLoginUI2 = SimpleLoginUI.this;
                SimpleLoginUI.this.getString(2131755906);
                SimpleLoginUI.a(localSimpleLoginUI1, h.b(localSimpleLoginUI2, SimpleLoginUI.this.getString(2131760781), true, new DialogInterface.OnCancelListener()
                {
                  public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                  {
                    AppMethodBeat.i(128763);
                    com.tencent.mm.kernel.g.aiU().a(paramAnonymousDialogInterface);
                    AppMethodBeat.o(128763);
                  }
                }));
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
            }, this.jkr);
          }
          for (;;)
          {
            i = 1;
            break;
            ad.d("MicroMsg.SimpleLoginUI", "imgSid:" + this.jkr.jcw + " img len" + this.jkr.jcv.length + " " + com.tencent.mm.compatible.util.f.abi());
            this.jct.b(this.jkr.jlF, this.jkr.jcv, this.jkr.jcw, this.jkr.jcx);
          }
        case -100: 
          com.tencent.mm.kernel.a.hold();
          com.tencent.mm.kernel.g.ajA();
          h.a(this, com.tencent.mm.kernel.a.ais(), getString(2131755906), new SimpleLoginUI.8(this), new SimpleLoginUI.9(this));
          i = 1;
          break;
        case -205: 
          ad.i("MicroMsg.SimpleLoginUI", "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]", new Object[] { bt.aRp(this.jiy), this.jkv });
          f.a(this.jkr);
          paramn = new Intent();
          paramn.putExtra("auth_ticket", this.jiy);
          paramn.putExtra("binded_mobile", this.jkV);
          paramn.putExtra("close_safe_device_style", this.jkv);
          paramn.putExtra("from_source", 3);
          com.tencent.mm.plugin.account.a.a.iRG.g(this, paramn);
          i = 1;
          break;
        case -140: 
          if (!bt.isNullOrNil(this.dKk)) {
            y.n(this, paramString, this.dKk);
          }
          i = 1;
          break;
        case -106: 
          y.g(this, paramString, 0);
          i = 1;
        }
      }
      paramString = com.tencent.mm.h.a.uz(paramString);
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