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
import android.text.Editable;
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
import com.tencent.mm.al.n;
import com.tencent.mm.model.bn;
import com.tencent.mm.model.bn.a;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.account.model.c.1;
import com.tencent.mm.plugin.account.model.c.a;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.model.app.y.1;
import com.tencent.mm.pluginsdk.model.app.y.a;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.base.MMClearEditText;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.xlog.app.XLogSetup;
import java.util.Iterator;
import java.util.LinkedList;

public class SimpleLoginUI
  extends MMWizardActivity
  implements com.tencent.mm.al.g
{
  private TextWatcher atH;
  private String dAl;
  private ProgressDialog fpP;
  private SecurityImage ijd;
  private String ipj;
  private com.tencent.mm.sdk.b.c iqt;
  private String irI;
  private ResizeLayout irM;
  private f ird;
  private String irh;
  private MMFormInputView isA;
  private MMFormInputView isB;
  private Button isC;
  private MMKeyboardUperView isF;
  private MMClearEditText isy;
  private MMClearEditText isz;
  
  public SimpleLoginUI()
  {
    AppMethodBeat.i(128778);
    this.fpP = null;
    this.ijd = null;
    this.ird = new f();
    this.dAl = "";
    this.atH = new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(128758);
        SimpleLoginUI.a(SimpleLoginUI.this);
        AppMethodBeat.o(128758);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    };
    this.iqt = new SimpleLoginUI.12(this);
    AppMethodBeat.o(128778);
  }
  
  private void aHX()
  {
    AppMethodBeat.i(128784);
    boolean bool = getIntent().getBooleanExtra("key_auto_login_wizard_exit", false);
    if (!bool) {
      cancel();
    }
    Xo(1);
    if (bool) {
      exit(1);
    }
    AppMethodBeat.o(128784);
  }
  
  private void aJQ()
  {
    AppMethodBeat.i(128785);
    this.ird.account = this.isy.getText().toString().trim();
    this.ird.ije = this.isz.getText().toString();
    if (this.ird.account.equals(""))
    {
      com.tencent.mm.ui.base.h.j(this, 2131764665, 2131760766);
      AppMethodBeat.o(128785);
      return;
    }
    if (this.ird.ije.equals(""))
    {
      com.tencent.mm.ui.base.h.j(this, 2131764658, 2131760766);
      AppMethodBeat.o(128785);
      return;
    }
    hideVKB();
    s locals = new s(this.ird.account, this.ird.ije, this.ipj, 0);
    com.tencent.mm.kernel.g.aeS().a(locals, 0);
    getString(2131755906);
    this.fpP = com.tencent.mm.ui.base.h.b(this, getString(2131760781), true, new SimpleLoginUI.5(this, locals));
    AppMethodBeat.o(128785);
  }
  
  public int getLayoutId()
  {
    return 2131494602;
  }
  
  public void initView()
  {
    AppMethodBeat.i(128783);
    this.isA = ((MMFormInputView)findViewById(2131301558));
    this.isB = ((MMFormInputView)findViewById(2131301577));
    this.isy = ((MMClearEditText)this.isA.getContentEditText());
    this.isy.setFocusableInTouchMode(false);
    this.isy.setOnTouchListener(new View.OnTouchListener()
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
    this.isz = ((MMClearEditText)this.isB.getContentEditText());
    this.isz.setFocusableInTouchMode(false);
    this.isz.setOnTouchListener(new View.OnTouchListener()
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
    com.tencent.mm.ui.tools.b.c.d(this.isz).aaj(16).a(null);
    this.isC = ((Button)findViewById(2131301562));
    this.isC.setEnabled(false);
    this.isy.addTextChangedListener(this.atH);
    this.isz.addTextChangedListener(this.atH);
    this.isz.setOnEditorActionListener(new TextView.OnEditorActionListener()
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
    this.isz.setOnKeyListener(new View.OnKeyListener()
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
    this.irM = ((ResizeLayout)findViewById(2131304133));
    this.isF = ((MMKeyboardUperView)findViewById(2131304370));
    this.irM.setOnSizeChanged(new ResizeLayout.a()
    {
      public final void aJU()
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
    this.isF.setOnTouchListener(new View.OnTouchListener()
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
    this.ipj = getIntent().getStringExtra("auth_ticket");
    if (!bt.isNullOrNil(this.ipj))
    {
      this.isy.setText(bt.nullAsNil(f.aJV()));
      this.isz.setText(bt.nullAsNil(f.aJW()));
      new ap().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(128760);
          SimpleLoginUI.b(SimpleLoginUI.this);
          AppMethodBeat.o(128760);
        }
      }, 500L);
    }
    if (com.tencent.mm.sdk.platformtools.i.ETy) {
      com.tencent.mm.plugin.account.a.a.hYu.t(this);
    }
    this.isC.setOnClickListener(new View.OnClickListener()
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
      aJQ();
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
    paramBundle = getSharedPreferences("system_config_prefs", com.tencent.mm.compatible.util.g.XN());
    if (paramBundle.getBoolean("first_launch_weixin", true))
    {
      paramBundle.edit().putBoolean("first_launch_weixin", false).commit();
      XLogSetup.realSetupXlog();
    }
    setMMTitle(2131755822);
    if (com.tencent.mm.plugin.account.a.a.hYu != null) {
      com.tencent.mm.plugin.account.a.a.hYu.Lo();
    }
    initView();
    com.tencent.mm.kernel.g.aeS().a(701, this);
    com.tencent.mm.kernel.g.aeS().a(252, this);
    if (!b.aL(this))
    {
      new Intent().addFlags(67108864);
      com.tencent.mm.plugin.account.a.a.hYt.p(new Intent(), this);
    }
    AppMethodBeat.o(128779);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128781);
    com.tencent.mm.kernel.g.aeS().b(701, this);
    com.tencent.mm.kernel.g.aeS().b(252, this);
    super.onDestroy();
    AppMethodBeat.o(128781);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(128786);
    if (paramInt == 4)
    {
      aHX();
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
    this.ipj = paramIntent.getStringExtra("auth_ticket");
    paramIntent = getIntent().getExtras();
    if (paramIntent != null) {
      this.ipj = paramIntent.getString("auth_ticket");
    }
    if (!bt.isNullOrNil(this.ipj))
    {
      this.isy.setText(bt.nullAsNil(f.aJV()));
      this.isz.setText(bt.nullAsNil(f.aJW()));
      new ap().postDelayed(new Runnable()
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
    if (this.fpP != null)
    {
      this.fpP.dismiss();
      this.fpP = null;
    }
    super.onPause();
    com.tencent.mm.sdk.b.a.ESL.d(this.iqt);
    AppMethodBeat.o(128787);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(128780);
    com.tencent.mm.sdk.b.a.ESL.c(this.iqt);
    super.onResume();
    AppMethodBeat.o(128780);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(128788);
    ad.i("MicroMsg.SimpleLoginUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    ad.d("MicroMsg.SimpleLoginUI", "Scene Type " + paramn.getType());
    if (this.fpP != null)
    {
      this.fpP.dismiss();
      this.fpP = null;
    }
    this.dAl = ((s)paramn).aAJ();
    int i;
    if ((paramn.getType() == 252) || (paramn.getType() == 701))
    {
      this.ird.iss = ((s)paramn).getSecCodeType();
      this.ird.ijg = ((s)paramn).aAK();
      this.ird.ijf = ((s)paramn).aAL();
      this.ird.ijh = ((s)paramn).aAM();
      if (paramInt2 == -205)
      {
        this.ipj = ((s)paramn).axA();
        this.irI = ((s)paramn).aAO();
        this.irh = ((s)paramn).aAR();
      }
      if ((paramInt1 == 4) && ((paramInt2 == -16) || (paramInt2 == -17)))
      {
        i = 1;
        com.tencent.mm.kernel.g.aeS().a(new bn(new bn.a()
        {
          public final void a(com.tencent.mm.network.e paramAnonymouse)
          {
            AppMethodBeat.i(128766);
            if (paramAnonymouse == null)
            {
              AppMethodBeat.o(128766);
              return;
            }
            paramAnonymouse = paramAnonymouse.avg();
            com.tencent.mm.kernel.g.afz();
            int i = com.tencent.mm.kernel.a.getUin();
            paramAnonymouse.a(new byte[0], new byte[0], new byte[0], i);
            AppMethodBeat.o(128766);
          }
        }), 0);
      }
    }
    for (;;)
    {
      if ((i != 0) || ((paramInt1 == 0) && (paramInt2 == 0)))
      {
        com.tencent.mm.kernel.a.unhold();
        t.cN(this);
        com.tencent.mm.platformtools.y.BD(this.ird.account);
        paramString = new com.tencent.mm.plugin.account.model.c(getContext(), new c.a()
        {
          public final void aJz()
          {
            String str = null;
            AppMethodBeat.i(128768);
            com.tencent.mm.pluginsdk.model.app.y localy = new com.tencent.mm.pluginsdk.model.app.y(SimpleLoginUI.this, new y.a()
            {
              public final void aKJ()
              {
                AppMethodBeat.i(128767);
                SimpleLoginUI.j(SimpleLoginUI.this);
                AppMethodBeat.o(128767);
              }
            });
            Object localObject1 = aj.eFE();
            if (localObject1 != null)
            {
              localObject1 = ((SharedPreferences)localObject1).getString("key_app_ids_registion_while_not_login", "");
              if (bt.isNullOrNil((String)localObject1)) {
                ad.i("MicroMsg.AppUtil", "no saved appids while not login");
              }
            }
            else
            {
              localObject1 = null;
            }
            Object localObject2;
            for (;;)
            {
              localObject2 = str;
              if (localObject1 == null) {
                break label251;
              }
              localObject2 = str;
              if (((LinkedList)localObject1).isEmpty()) {
                break label251;
              }
              localObject2 = new LinkedList();
              localObject1 = ((LinkedList)localObject1).iterator();
              com.tencent.mm.pluginsdk.model.app.g localg;
              while (((Iterator)localObject1).hasNext())
              {
                str = (String)((Iterator)localObject1).next();
                localg = com.tencent.mm.pluginsdk.model.app.h.j(str, false, false);
                if ((localg == null) || (localg.field_status == 0)) {
                  ((LinkedList)localObject2).add(str);
                }
              }
              localObject2 = ((String)localObject1).split("\\|");
              if ((localObject2 == null) || (localObject2.length <= 0)) {
                break;
              }
              localObject1 = new LinkedList();
              int m = localObject2.length;
              int i = 0;
              int k;
              for (int j = 1; i < m; j = k)
              {
                localg = localObject2[i];
                k = j;
                if (!bt.isNullOrNil(localg))
                {
                  ((LinkedList)localObject1).add(localg);
                  k = j + 1;
                }
                if (k > 5) {
                  break;
                }
                i += 1;
              }
            }
            label251:
            if ((localObject2 == null) || (((LinkedList)localObject2).isEmpty()))
            {
              ad.i("MicroMsg.LoadAppInfoAfterLogin", "no saved appids, just callback");
              com.tencent.mm.pluginsdk.model.app.q.evN();
              if (localy.BQe != null) {
                localy.BQe.aKJ();
              }
              AppMethodBeat.o(128768);
              return;
            }
            ad.i("MicroMsg.LoadAppInfoAfterLogin", "now do batch get appinfos, appid liSst size is :%d", new Object[] { Integer.valueOf(((LinkedList)localObject2).size()) });
            com.tencent.mm.plugin.s.a.cZT().a(7, localy);
            com.tencent.mm.plugin.s.a.cZP().bb((LinkedList)localObject2);
            if ((localy.mContext != null) && (!((Activity)localy.mContext).isFinishing()))
            {
              localObject1 = localy.mContext;
              localy.mContext.getString(2131755906);
              localy.tipDialog = com.tencent.mm.ui.base.h.b((Context)localObject1, localy.mContext.getString(2131755936), true, new y.1(localy));
              AppMethodBeat.o(128768);
              return;
            }
            if (localy.BQe != null) {
              localy.BQe.aKJ();
            }
            ad.e("MicroMsg.LoadAppInfoAfterLogin", "dz[loadAppInfo:catch the null window for progress bar");
            AppMethodBeat.o(128768);
          }
        });
        paramString.dfA = com.tencent.mm.plugin.account.a.a.hYu.a(paramString);
        if (paramString.dfA == null)
        {
          if (paramString.ioe != null) {
            paramString.ioe.aJz();
          }
          AppMethodBeat.o(128788);
          return;
        }
        if (paramString.dfA.getType() == 139) {
          com.tencent.mm.kernel.g.aeS().a(139, paramString);
        }
        for (;;)
        {
          com.tencent.mm.kernel.g.aeS().a(paramString.dfA, 0);
          paramn = paramString.context;
          paramString.context.getString(2131755906);
          paramString.tipDialog = com.tencent.mm.ui.base.h.b(paramn, paramString.context.getString(2131755805), true, new c.1(paramString));
          AppMethodBeat.o(128788);
          return;
          if (paramString.dfA.getType() == 138) {
            com.tencent.mm.kernel.g.aeS().a(138, paramString);
          }
        }
      }
      if (paramInt2 == -217)
      {
        com.tencent.mm.platformtools.y.a(this, com.tencent.mm.platformtools.e.a((s)paramn), paramInt2);
        AppMethodBeat.o(128788);
        return;
      }
      if (com.tencent.mm.plugin.account.a.a.hYu.a(getContext(), paramInt1, paramInt2, paramString)) {
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
          if (com.tencent.mm.kernel.g.aeS().auR() == 5)
          {
            com.tencent.mm.ui.base.h.j(this, 2131761537, 2131761536);
            i = 1;
          }
          break;
        case -30: 
        case -4: 
        case -3: 
          com.tencent.mm.ui.base.h.j(this, 2131758459, 2131760766);
          i = 1;
          break;
        case -9: 
          com.tencent.mm.ui.base.h.j(this, 2131760765, 2131760766);
          i = 1;
          break;
        case -72: 
          com.tencent.mm.ui.base.h.j(getContext(), 2131762374, 2131755906);
          i = 1;
          break;
        case -75: 
          com.tencent.mm.platformtools.y.cV(getContext());
          i = 1;
          break;
        case -311: 
        case -310: 
        case -6: 
          if (this.ijd == null) {
            this.ijd = SecurityImage.a.a(getContext(), this.ird.iss, this.ird.ijf, this.ird.ijg, this.ird.ijh, new DialogInterface.OnClickListener()
            {
              public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(128764);
                ad.d("MicroMsg.SimpleLoginUI", "imgSid:" + SimpleLoginUI.g(SimpleLoginUI.this).ijg + " img len" + SimpleLoginUI.g(SimpleLoginUI.this).ijf.length + " " + com.tencent.mm.compatible.util.f.XJ());
                paramAnonymousDialogInterface = new s(SimpleLoginUI.g(SimpleLoginUI.this).account, SimpleLoginUI.g(SimpleLoginUI.this).ije, SimpleLoginUI.g(SimpleLoginUI.this).iss, SimpleLoginUI.h(SimpleLoginUI.this).getSecImgCode(), SimpleLoginUI.h(SimpleLoginUI.this).getSecImgSid(), SimpleLoginUI.h(SimpleLoginUI.this).getSecImgEncryptKey(), 0, "", false, false);
                com.tencent.mm.kernel.g.aeS().a(paramAnonymousDialogInterface, 0);
                SimpleLoginUI localSimpleLoginUI1 = SimpleLoginUI.this;
                SimpleLoginUI localSimpleLoginUI2 = SimpleLoginUI.this;
                SimpleLoginUI.this.getString(2131755906);
                SimpleLoginUI.a(localSimpleLoginUI1, com.tencent.mm.ui.base.h.b(localSimpleLoginUI2, SimpleLoginUI.this.getString(2131760781), true, new DialogInterface.OnCancelListener()
                {
                  public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                  {
                    AppMethodBeat.i(128763);
                    com.tencent.mm.kernel.g.aeS().a(paramAnonymousDialogInterface);
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
            }, this.ird);
          }
          for (;;)
          {
            i = 1;
            break;
            ad.d("MicroMsg.SimpleLoginUI", "imgSid:" + this.ird.ijg + " img len" + this.ird.ijf.length + " " + com.tencent.mm.compatible.util.f.XJ());
            this.ijd.b(this.ird.iss, this.ird.ijf, this.ird.ijg, this.ird.ijh);
          }
        case -100: 
          com.tencent.mm.kernel.a.hold();
          com.tencent.mm.kernel.g.afz();
          com.tencent.mm.ui.base.h.a(this, com.tencent.mm.kernel.a.aeq(), getString(2131755906), new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          }, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
          });
          i = 1;
          break;
        case -205: 
          ad.i("MicroMsg.SimpleLoginUI", "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]", new Object[] { bt.aGs(this.ipj), this.irh });
          f.a(this.ird);
          paramn = new Intent();
          paramn.putExtra("auth_ticket", this.ipj);
          paramn.putExtra("binded_mobile", this.irI);
          paramn.putExtra("close_safe_device_style", this.irh);
          paramn.putExtra("from_source", 3);
          com.tencent.mm.plugin.account.a.a.hYt.g(this, paramn);
          i = 1;
          break;
        case -140: 
          if (!bt.isNullOrNil(this.dAl)) {
            com.tencent.mm.platformtools.y.m(this, paramString, this.dAl);
          }
          i = 1;
          break;
        case -106: 
          com.tencent.mm.platformtools.y.g(this, paramString, 0);
          i = 1;
        }
      }
      paramString = com.tencent.mm.h.a.oG(paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.SimpleLoginUI
 * JD-Core Version:    0.7.0.1
 */