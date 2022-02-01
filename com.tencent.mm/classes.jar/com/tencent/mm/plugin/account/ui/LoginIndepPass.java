package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bu;
import com.tencent.mm.model.bu.a;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.PhoneFormater;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;

public class LoginIndepPass
  extends MMActivity
  implements i
{
  private String account;
  private String edo;
  private ProgressDialog gtM;
  private String kbV;
  private com.tencent.mm.ui.base.q kdn;
  private SecurityImage kdp;
  private String kjv;
  private IListener kkK;
  private String klX;
  private g klt;
  private String klx;
  private Button kmA;
  private EditText kmy;
  private String kmz;
  
  public LoginIndepPass()
  {
    AppMethodBeat.i(128163);
    this.gtM = null;
    this.kdp = null;
    this.klt = new g();
    this.kkK = new LoginIndepPass.1(this);
    AppMethodBeat.o(128163);
  }
  
  private void bpf()
  {
    AppMethodBeat.i(128169);
    Object localObject = this.kmy.getText().toString();
    if (Util.isNullOrNil(this.account))
    {
      com.tencent.mm.ui.base.h.n(this, 2131767037, 2131762516);
      AppMethodBeat.o(128169);
      return;
    }
    if (((String)localObject).equals(""))
    {
      com.tencent.mm.ui.base.h.n(this, 2131767029, 2131762516);
      AppMethodBeat.o(128169);
      return;
    }
    hideVKB();
    com.tencent.mm.kernel.g.azz().a(701, this);
    com.tencent.mm.kernel.g.azz().a(252, this);
    localObject = new com.tencent.mm.modelsimple.t(this.account, (String)localObject, null, 1);
    com.tencent.mm.kernel.g.azz().a((com.tencent.mm.ak.q)localObject, 0);
    getString(2131755998);
    this.gtM = com.tencent.mm.ui.base.h.a(this, getString(2131762532), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(128162);
        com.tencent.mm.kernel.g.azz().a(this.klI);
        AppMethodBeat.o(128162);
      }
    });
    AppMethodBeat.o(128169);
  }
  
  private boolean n(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(128171);
    if (com.tencent.mm.plugin.account.a.a.jRu.a(getContext(), paramInt1, paramInt2, paramString))
    {
      AppMethodBeat.o(128171);
      return true;
    }
    if (paramInt1 == 4) {}
    switch (paramInt2)
    {
    default: 
      AppMethodBeat.o(128171);
      return false;
    case -1: 
      if (com.tencent.mm.kernel.g.azz().aYS() == 5)
      {
        com.tencent.mm.ui.base.h.n(this, 2131763503, 2131763502);
        AppMethodBeat.o(128171);
        return true;
      }
      AppMethodBeat.o(128171);
      return false;
    case -4: 
    case -3: 
      com.tencent.mm.ui.base.h.n(this, 2131758757, 2131762516);
      AppMethodBeat.o(128171);
      return true;
    case -9: 
      com.tencent.mm.ui.base.h.n(this, 2131762515, 2131762516);
      AppMethodBeat.o(128171);
      return true;
    case -2023: 
    case -100: 
      com.tencent.mm.kernel.a.hold();
      AppCompatActivity localAppCompatActivity = getContext();
      com.tencent.mm.kernel.g.aAf();
      if (TextUtils.isEmpty(com.tencent.mm.kernel.a.ayX())) {}
      for (paramString = com.tencent.mm.cb.a.aI(getContext(), 2131762849);; paramString = com.tencent.mm.kernel.a.ayX())
      {
        com.tencent.mm.ui.base.h.a(localAppCompatActivity, paramString, getContext().getString(2131755998), new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        }, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
        });
        AppMethodBeat.o(128171);
        return true;
        com.tencent.mm.kernel.g.aAf();
      }
    }
    if (!Util.isNullOrNil(this.edo)) {
      y.m(getContext(), paramString, this.edo);
    }
    AppMethodBeat.o(128171);
    return true;
  }
  
  public int getLayoutId()
  {
    return 2131495318;
  }
  
  public void initView()
  {
    AppMethodBeat.i(128168);
    this.kmy = ((EditText)findViewById(2131302639));
    this.kmA = ((Button)findViewById(2131303811));
    enableOptionMenu(false);
    addTextOptionMenu(0, getString(2131762525), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(128153);
        LoginIndepPass.a(LoginIndepPass.this);
        AppMethodBeat.o(128153);
        return true;
      }
    });
    this.kmy.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(128154);
        LoginIndepPass.b(LoginIndepPass.this);
        AppMethodBeat.o(128154);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.kmy.setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(128155);
        if ((paramAnonymousInt == 6) || (paramAnonymousInt == 5))
        {
          LoginIndepPass.a(LoginIndepPass.this);
          AppMethodBeat.o(128155);
          return true;
        }
        AppMethodBeat.o(128155);
        return false;
      }
    });
    this.kmy.setOnKeyListener(new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(128156);
        b localb = new b();
        localb.bm(paramAnonymousView);
        localb.pH(paramAnonymousInt);
        localb.bm(paramAnonymousKeyEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/LoginIndepPass$5", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.axR());
        if ((66 == paramAnonymousInt) && (paramAnonymousKeyEvent.getAction() == 0))
        {
          LoginIndepPass.a(LoginIndepPass.this);
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/account/ui/LoginIndepPass$5", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
          AppMethodBeat.o(128156);
          return true;
        }
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/account/ui/LoginIndepPass$5", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
        AppMethodBeat.o(128156);
        return false;
      }
    });
    this.kmA.setText(getString(2131762529));
    this.kmA.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(128159);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/LoginIndepPass$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        com.tencent.mm.ui.base.h.a(LoginIndepPass.this, LoginIndepPass.this.getString(2131764431) + LoginIndepPass.c(LoginIndepPass.this), LoginIndepPass.this.getString(2131764432), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(final DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(128158);
            com.tencent.mm.kernel.g.azz().a(145, LoginIndepPass.this);
            paramAnonymous2DialogInterface = new com.tencent.mm.modelfriend.a(LoginIndepPass.d(LoginIndepPass.this), 16, "", 0, "");
            com.tencent.mm.kernel.g.azz().a(paramAnonymous2DialogInterface, 0);
            LoginIndepPass localLoginIndepPass1 = LoginIndepPass.this;
            LoginIndepPass localLoginIndepPass2 = LoginIndepPass.this;
            LoginIndepPass.this.getString(2131755998);
            LoginIndepPass.a(localLoginIndepPass1, com.tencent.mm.ui.base.h.a(localLoginIndepPass2, LoginIndepPass.this.getString(2131755886), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymous3DialogInterface)
              {
                AppMethodBeat.i(128157);
                com.tencent.mm.kernel.g.azz().a(paramAnonymous2DialogInterface);
                com.tencent.mm.kernel.g.azz().b(701, LoginIndepPass.this);
                com.tencent.mm.kernel.g.azz().b(252, LoginIndepPass.this);
                AppMethodBeat.o(128157);
              }
            }));
            AppMethodBeat.o(128158);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
        });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginIndepPass$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(128159);
      }
    });
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(128160);
        com.tencent.mm.plugin.b.a.bwV("L200_100");
        Object localObject = new Intent(LoginIndepPass.this, MobileInputUI.class);
        ((Intent)localObject).putExtra("mobile_input_purpose", 1);
        ((Intent)localObject).addFlags(67108864);
        paramAnonymousMenuItem = LoginIndepPass.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/account/ui/LoginIndepPass$7", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, "com/tencent/mm/plugin/account/ui/LoginIndepPass$7", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        LoginIndepPass.this.finish();
        AppMethodBeat.o(128160);
        return true;
      }
    });
    this.kjv = getIntent().getStringExtra("auth_ticket");
    if (!Util.isNullOrNil(this.kjv)) {
      new MMHandler().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(128161);
          LoginIndepPass.a(LoginIndepPass.this, g.bpk(), g.bpl());
          AppMethodBeat.o(128161);
        }
      }, 500L);
    }
    AppMethodBeat.o(128168);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 0;
    AppMethodBeat.i(128172);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    boolean bool;
    String str;
    if (paramIntent == null)
    {
      bool = true;
      Log.d("MicroMsg.LoginIndepPass", "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      if ((paramInt2 != -1) || (paramInt1 != 1024) || (paramIntent == null)) {
        break label178;
      }
      str = paramIntent.getStringExtra("VoiceLoginAuthPwd");
      paramInt2 = paramIntent.getIntExtra("KVoiceHelpCode", 0);
      bool = Util.isNullOrNil(str);
      if (!Util.isNullOrNil(str)) {
        break label169;
      }
    }
    label169:
    for (paramInt1 = i;; paramInt1 = str.length())
    {
      Log.d("MicroMsg.LoginIndepPass", "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (paramInt2 != -217) {
        break label178;
      }
      bpf();
      AppMethodBeat.o(128172);
      return;
      bool = false;
      break;
    }
    label178:
    AppMethodBeat.o(128172);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128164);
    super.onCreate(paramBundle);
    paramBundle = getString(2131762523);
    if ((d.KyR) || (BuildInfo.IS_FLAVOR_BLUE)) {
      paramBundle = getString(2131755908) + com.tencent.mm.cc.h.jr(this);
    }
    setMMTitle(paramBundle);
    this.kmz = getIntent().getStringExtra("bindmcontact_mobile");
    if (this.kmz != null) {
      this.account = PhoneFormater.pureNumber(this.kmz);
    }
    com.tencent.mm.plugin.account.a.a.jRu.Xc();
    this.kbV = com.tencent.mm.plugin.b.a.bpZ();
    initView();
    AppMethodBeat.o(128164);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128167);
    com.tencent.mm.kernel.g.azz().b(701, this);
    com.tencent.mm.kernel.g.azz().b(252, this);
    super.onDestroy();
    AppMethodBeat.o(128167);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(128166);
    super.onPause();
    EventCenter.instance.removeListener(this.kkK);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.aAf();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",L200_200,");
    com.tencent.mm.kernel.g.aAf();
    com.tencent.mm.plugin.b.a.j(false, com.tencent.mm.kernel.a.FN("L200_200") + ",2");
    AppMethodBeat.o(128166);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(128165);
    EventCenter.instance.addListener(this.kkK);
    super.onResume();
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.aAf();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",L200_200,");
    com.tencent.mm.kernel.g.aAf();
    com.tencent.mm.plugin.b.a.j(true, com.tencent.mm.kernel.a.FN("L200_200") + ",1");
    com.tencent.mm.plugin.b.a.bwU("L200_200");
    AppMethodBeat.o(128165);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(128170);
    Log.i("MicroMsg.LoginIndepPass", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.gtM != null)
    {
      this.gtM.dismiss();
      this.gtM = null;
    }
    if (this.kdn != null)
    {
      this.kdn.dismiss();
      this.kdn = null;
    }
    if ((paramq.getType() == 252) || (paramq.getType() == 701))
    {
      this.edo = ((com.tencent.mm.modelsimple.t)paramq).bfk();
      com.tencent.mm.kernel.g.azz().b(701, this);
      com.tencent.mm.kernel.g.azz().b(252, this);
      this.klt.kds = ((com.tencent.mm.modelsimple.t)paramq).bfl();
      this.klt.kdr = ((com.tencent.mm.modelsimple.t)paramq).bfm();
      this.klt.kdt = ((com.tencent.mm.modelsimple.t)paramq).bfn();
      this.klt.kmJ = ((com.tencent.mm.modelsimple.t)paramq).getSecCodeType();
      this.klt.account = this.account;
      this.klt.kdq = this.kmy.getText().toString();
      if (paramInt2 == -75)
      {
        y.dz(getContext());
        AppMethodBeat.o(128170);
        return;
      }
      if (paramInt2 == -106)
      {
        y.g(this, paramString, 0);
        AppMethodBeat.o(128170);
        return;
      }
      if (paramInt2 == -217)
      {
        y.a(this, com.tencent.mm.platformtools.e.a((com.tencent.mm.modelsimple.t)paramq), paramInt2);
        AppMethodBeat.o(128170);
        return;
      }
      if (paramInt2 == -205)
      {
        this.kjv = ((com.tencent.mm.modelsimple.t)paramq).bbH();
        this.klX = ((com.tencent.mm.modelsimple.t)paramq).bfp();
        this.klx = ((com.tencent.mm.modelsimple.t)paramq).bfs();
        Log.i("MicroMsg.LoginIndepPass", "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]", new Object[] { Util.secPrint(this.kjv), this.klx });
        g.a(this.klt);
        paramString = new Intent();
        paramString.putExtra("auth_ticket", this.kjv);
        paramString.putExtra("binded_mobile", this.klX);
        paramString.putExtra("close_safe_device_style", this.klx);
        paramString.putExtra("from_source", 5);
        com.tencent.mm.plugin.account.a.a.jRt.g(this, paramString);
        AppMethodBeat.o(128170);
        return;
      }
      if (paramInt2 == -140)
      {
        if (!Util.isNullOrNil(this.edo)) {
          y.m(this, paramString, this.edo);
        }
        AppMethodBeat.o(128170);
        return;
      }
      if ((paramInt1 != 4) || ((paramInt2 != -16) && (paramInt2 != -17))) {
        break label1229;
      }
      com.tencent.mm.kernel.g.azz().a(new bu(new bu.a()
      {
        public final void a(com.tencent.mm.network.g paramAnonymousg)
        {
          AppMethodBeat.i(128148);
          if (paramAnonymousg == null)
          {
            AppMethodBeat.o(128148);
            return;
          }
          paramAnonymousg = paramAnonymousg.aZh();
          com.tencent.mm.kernel.g.aAf();
          int i = com.tencent.mm.kernel.a.getUin();
          paramAnonymousg.a(new byte[0], new byte[0], new byte[0], i);
          AppMethodBeat.o(128148);
        }
      }), 0);
    }
    label1229:
    for (int i = 1;; i = 0)
    {
      if ((paramInt2 == -6) || (paramInt2 == -311) || (paramInt2 == -310))
      {
        com.tencent.mm.kernel.g.azz().a(701, this);
        com.tencent.mm.kernel.g.azz().a(252, this);
        if (this.kdp == null)
        {
          this.kdp = SecurityImage.a.a(getContext(), this.klt.kmJ, this.klt.kdr, this.klt.kds, this.klt.kdt, new DialogInterface.OnClickListener()
          {
            public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(128150);
              Log.d("MicroMsg.LoginIndepPass", "imgSid:" + LoginIndepPass.e(LoginIndepPass.this).kds + " img len" + LoginIndepPass.e(LoginIndepPass.this).kdr.length + " " + f.apq());
              paramAnonymousDialogInterface = new com.tencent.mm.modelsimple.t(LoginIndepPass.e(LoginIndepPass.this).account, LoginIndepPass.e(LoginIndepPass.this).kdq, LoginIndepPass.e(LoginIndepPass.this).kmJ, LoginIndepPass.f(LoginIndepPass.this).getSecImgCode(), LoginIndepPass.f(LoginIndepPass.this).getSecImgSid(), LoginIndepPass.f(LoginIndepPass.this).getSecImgEncryptKey(), 1, "", false, false);
              com.tencent.mm.kernel.g.azz().a(paramAnonymousDialogInterface, 0);
              LoginIndepPass localLoginIndepPass1 = LoginIndepPass.this;
              LoginIndepPass localLoginIndepPass2 = LoginIndepPass.this;
              LoginIndepPass.this.getString(2131755998);
              LoginIndepPass.a(localLoginIndepPass1, com.tencent.mm.ui.base.h.a(localLoginIndepPass2, LoginIndepPass.this.getString(2131762532), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(128149);
                  com.tencent.mm.kernel.g.azz().a(paramAnonymousDialogInterface);
                  com.tencent.mm.kernel.g.azz().b(701, LoginIndepPass.this);
                  com.tencent.mm.kernel.g.azz().b(252, LoginIndepPass.this);
                  AppMethodBeat.o(128149);
                }
              }));
              AppMethodBeat.o(128150);
            }
          }, null, new DialogInterface.OnDismissListener()
          {
            public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
            {
              AppMethodBeat.i(128151);
              LoginIndepPass.g(LoginIndepPass.this);
              AppMethodBeat.o(128151);
            }
          }, this.klt);
          AppMethodBeat.o(128170);
          return;
        }
        Log.d("MicroMsg.LoginIndepPass", "imgSid:" + this.klt.kds + " img len" + this.klt.kdr.length + " " + f.apq());
        this.kdp.b(this.klt.kmJ, this.klt.kdr, this.klt.kds, this.klt.kdt);
        AppMethodBeat.o(128170);
        return;
      }
      if ((i != 0) || ((paramInt1 == 0) && (paramInt2 == 0)))
      {
        com.tencent.mm.kernel.a.unhold();
        com.tencent.mm.plugin.account.friend.a.l.boe();
        y.St(this.klt.account);
        com.tencent.mm.platformtools.t.dr(this);
        y.showAddrBookUploadConfirm(this, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(128152);
            Log.d("MicroMsg.LoginIndepPass", "onSceneEnd, in runnable");
            Object localObject = com.tencent.mm.plugin.account.a.a.jRt.bZ(LoginIndepPass.this);
            ((Intent)localObject).addFlags(67108864);
            LoginIndepPass localLoginIndepPass = LoginIndepPass.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(localLoginIndepPass, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/account/ui/LoginIndepPass$14", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localLoginIndepPass.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(localLoginIndepPass, "com/tencent/mm/plugin/account/ui/LoginIndepPass$14", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            LoginIndepPass.this.finish();
            AppMethodBeat.o(128152);
          }
        }, false, 2);
        AppMethodBeat.o(128170);
        return;
      }
      if (n(paramInt1, paramInt2, paramString))
      {
        AppMethodBeat.o(128170);
        return;
      }
      if ((paramq.getType() == 252) || (paramq.getType() == 701))
      {
        paramString = com.tencent.mm.h.a.Dk(paramString);
        if ((paramString != null) && (paramString.a(this, null, null)))
        {
          AppMethodBeat.o(128170);
          return;
        }
      }
      Toast.makeText(this, getString(2131760805, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      AppMethodBeat.o(128170);
      return;
      if (paramq.getType() == 145)
      {
        com.tencent.mm.kernel.g.azz().b(145, this);
        paramString = ((com.tencent.mm.modelfriend.a)paramq).bbI();
        if (paramInt2 == -41)
        {
          com.tencent.mm.ui.base.h.n(this, 2131764394, 2131764395);
          AppMethodBeat.o(128170);
          return;
        }
        if (paramInt2 == -75)
        {
          com.tencent.mm.ui.base.h.c(this, getString(2131755300), "", true);
          AppMethodBeat.o(128170);
          return;
        }
        com.tencent.mm.plugin.b.a.bwV("L3");
        Object localObject = new StringBuilder();
        com.tencent.mm.kernel.g.aAf();
        localObject = ((StringBuilder)localObject).append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",L3,");
        com.tencent.mm.kernel.g.aAf();
        com.tencent.mm.plugin.b.a.j(true, com.tencent.mm.kernel.a.FN("L3") + ",1");
        localObject = new Intent();
        ((Intent)localObject).putExtra("bindmcontact_mobile", this.kmz);
        ((Intent)localObject).putExtra("bindmcontact_shortmobile", paramString);
        ((Intent)localObject).putExtra("mobile_verify_purpose", 1);
        ((Intent)localObject).putExtra("mobileverify_countdownsec", ((com.tencent.mm.modelfriend.a)paramq).bbO());
        ((Intent)localObject).putExtra("mobileverify_countdownstyle", ((com.tencent.mm.modelfriend.a)paramq).bbP());
        ((Intent)localObject).putExtra("mobileverify_fb", ((com.tencent.mm.modelfriend.a)paramq).bbQ());
        startActivity(MobileVerifyUI.class, (Intent)localObject);
        AppMethodBeat.o(128170);
        return;
      }
      if (n(paramInt1, paramInt2, paramString))
      {
        AppMethodBeat.o(128170);
        return;
      }
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        Toast.makeText(this, getString(2131760805, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      }
      AppMethodBeat.o(128170);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginIndepPass
 * JD-Core Version:    0.7.0.1
 */