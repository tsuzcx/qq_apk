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
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.model.bu;
import com.tencent.mm.model.bu.a;
import com.tencent.mm.plugin.account.model.c.1;
import com.tencent.mm.plugin.account.model.c.a;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.model.app.y.1;
import com.tencent.mm.pluginsdk.model.app.y.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo;
import com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo.WhichApp;
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
  implements com.tencent.mm.ak.i
{
  private TextWatcher aws;
  private String edo;
  private ProgressDialog gtM;
  private SecurityImage kdp;
  private String kjv;
  private IListener kkK;
  private String klX;
  private g klt;
  private String klx;
  private MMClearEditText kmP;
  private MMClearEditText kmQ;
  private MMFormInputView kmR;
  private MMFormInputView kmS;
  private Button kmT;
  private MMKeyboardUperView kmW;
  private ResizeLayout kmb;
  
  public SimpleLoginUI()
  {
    AppMethodBeat.i(128778);
    this.gtM = null;
    this.kdp = null;
    this.klt = new g();
    this.edo = "";
    this.aws = new TextWatcher()
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
    this.kkK = new SimpleLoginUI.12(this);
    AppMethodBeat.o(128778);
  }
  
  private void bnm()
  {
    AppMethodBeat.i(128784);
    boolean bool = getIntent().getBooleanExtra("key_auto_login_wizard_exit", false);
    if (!bool) {
      cancel();
    }
    ala(1);
    if (bool) {
      exit(1);
    }
    AppMethodBeat.o(128784);
  }
  
  private void bpf()
  {
    AppMethodBeat.i(128785);
    this.klt.account = this.kmP.getText().toString().trim();
    this.klt.kdq = this.kmQ.getText().toString();
    if (this.klt.account.equals(""))
    {
      com.tencent.mm.ui.base.h.n(this, 2131767037, 2131762516);
      AppMethodBeat.o(128785);
      return;
    }
    if (this.klt.kdq.equals(""))
    {
      com.tencent.mm.ui.base.h.n(this, 2131767029, 2131762516);
      AppMethodBeat.o(128785);
      return;
    }
    hideVKB();
    final com.tencent.mm.modelsimple.t localt = new com.tencent.mm.modelsimple.t(this.klt.account, this.klt.kdq, this.kjv, 0);
    com.tencent.mm.kernel.g.azz().a(localt, 0);
    getString(2131755998);
    this.gtM = com.tencent.mm.ui.base.h.a(this, getString(2131762532), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(128762);
        com.tencent.mm.kernel.g.azz().a(localt);
        AppMethodBeat.o(128762);
      }
    });
    AppMethodBeat.o(128785);
  }
  
  public int getLayoutId()
  {
    return 2131495313;
  }
  
  public void initView()
  {
    AppMethodBeat.i(128783);
    this.kmR = ((MMFormInputView)findViewById(2131303776));
    TextView localTextView = (TextView)findViewById(2131303812);
    if (WeChatBrands.AppInfo.current().isMainland())
    {
      this.kmR.setHint(2131762484);
      localTextView.setText(2131762504);
    }
    for (;;)
    {
      this.kmS = ((MMFormInputView)findViewById(2131303805));
      this.kmP = ((MMClearEditText)this.kmR.getContentEditText());
      this.kmP.setFocusableInTouchMode(false);
      this.kmP.setOnTouchListener(new View.OnTouchListener()
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
      this.kmQ = ((MMClearEditText)this.kmS.getContentEditText());
      this.kmQ.setFocusableInTouchMode(false);
      this.kmQ.setOnTouchListener(new View.OnTouchListener()
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
      com.tencent.mm.ui.tools.b.c.f(this.kmQ).aoq(16).a(null);
      this.kmT = ((Button)findViewById(2131303784));
      this.kmT.setEnabled(false);
      this.kmP.addTextChangedListener(this.aws);
      this.kmQ.addTextChangedListener(this.aws);
      this.kmQ.setOnEditorActionListener(new TextView.OnEditorActionListener()
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
      this.kmQ.setOnKeyListener(new View.OnKeyListener()
      {
        public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(128774);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          localb.pH(paramAnonymousInt);
          localb.bm(paramAnonymousKeyEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/SimpleLoginUI$7", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.axR());
          if ((66 == paramAnonymousInt) && (paramAnonymousKeyEvent.getAction() == 0))
          {
            SimpleLoginUI.b(SimpleLoginUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/account/ui/SimpleLoginUI$7", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
            AppMethodBeat.o(128774);
            return true;
          }
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/account/ui/SimpleLoginUI$7", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
          AppMethodBeat.o(128774);
          return false;
        }
      });
      this.kmb = ((ResizeLayout)findViewById(2131307029));
      this.kmW = ((MMKeyboardUperView)findViewById(2131307332));
      this.kmb.setOnSizeChanged(new ResizeLayout.a()
      {
        public final void bpj()
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
      this.kmW.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(128777);
          SimpleLoginUI.this.hideVKB();
          AppMethodBeat.o(128777);
          return false;
        }
      });
      findViewById(2131303791).setVisibility(8);
      setMMTitle(2131762540);
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
      this.kjv = getIntent().getStringExtra("auth_ticket");
      if (!Util.isNullOrNil(this.kjv))
      {
        this.kmP.setText(Util.nullAsNil(g.bpk()));
        this.kmQ.setText(Util.nullAsNil(g.bpl()));
        new MMHandler().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(128760);
            SimpleLoginUI.b(SimpleLoginUI.this);
            AppMethodBeat.o(128760);
          }
        }, 500L);
      }
      if (ChannelUtil.shouldShowGprsAlert) {
        com.tencent.mm.plugin.account.a.a.jRu.t(this);
      }
      this.kmT.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128761);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/SimpleLoginUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          SimpleLoginUI.b(SimpleLoginUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/SimpleLoginUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(128761);
        }
      });
      AppMethodBeat.o(128783);
      return;
      this.kmR.setHint(2131762485);
      localTextView.setText(2131762505);
    }
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
      Log.d("MicroMsg.SimpleLoginUI", "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
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
      Log.d("MicroMsg.SimpleLoginUI", "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (paramInt2 != -217) {
        break label178;
      }
      bpf();
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
    paramBundle = getSharedPreferences("system_config_prefs", com.tencent.mm.compatible.util.g.aps());
    if (paramBundle.getBoolean("first_launch_weixin", true))
    {
      paramBundle.edit().putBoolean("first_launch_weixin", false).commit();
      XLogSetup.realSetupXlog();
    }
    setMMTitle(2131755908);
    if (com.tencent.mm.plugin.account.a.a.jRu != null) {
      com.tencent.mm.plugin.account.a.a.jRu.Xc();
    }
    initView();
    com.tencent.mm.kernel.g.azz().a(701, this);
    com.tencent.mm.kernel.g.azz().a(252, this);
    if (!com.tencent.mm.pluginsdk.permission.b.aW(this))
    {
      new Intent().addFlags(67108864);
      com.tencent.mm.plugin.account.a.a.jRt.o(new Intent(), this);
    }
    AppMethodBeat.o(128779);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128781);
    com.tencent.mm.kernel.g.azz().b(701, this);
    com.tencent.mm.kernel.g.azz().b(252, this);
    super.onDestroy();
    AppMethodBeat.o(128781);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(128786);
    if (paramInt == 4)
    {
      bnm();
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
    this.kjv = paramIntent.getStringExtra("auth_ticket");
    paramIntent = getIntent().getExtras();
    if (paramIntent != null) {
      this.kjv = paramIntent.getString("auth_ticket");
    }
    if (!Util.isNullOrNil(this.kjv))
    {
      this.kmP.setText(Util.nullAsNil(g.bpk()));
      this.kmQ.setText(Util.nullAsNil(g.bpl()));
      new MMHandler().postDelayed(new Runnable()
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
    if (this.gtM != null)
    {
      this.gtM.dismiss();
      this.gtM = null;
    }
    super.onPause();
    EventCenter.instance.removeListener(this.kkK);
    AppMethodBeat.o(128787);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(128780);
    EventCenter.instance.addListener(this.kkK);
    super.onResume();
    AppMethodBeat.o(128780);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(128788);
    Log.i("MicroMsg.SimpleLoginUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    Log.d("MicroMsg.SimpleLoginUI", "Scene Type " + paramq.getType());
    if (this.gtM != null)
    {
      this.gtM.dismiss();
      this.gtM = null;
    }
    this.edo = ((com.tencent.mm.modelsimple.t)paramq).bfk();
    int i;
    if ((paramq.getType() == 252) || (paramq.getType() == 701))
    {
      this.klt.kmJ = ((com.tencent.mm.modelsimple.t)paramq).getSecCodeType();
      this.klt.kds = ((com.tencent.mm.modelsimple.t)paramq).bfl();
      this.klt.kdr = ((com.tencent.mm.modelsimple.t)paramq).bfm();
      this.klt.kdt = ((com.tencent.mm.modelsimple.t)paramq).bfn();
      if (paramInt2 == -205)
      {
        this.kjv = ((com.tencent.mm.modelsimple.t)paramq).bbH();
        this.klX = ((com.tencent.mm.modelsimple.t)paramq).bfp();
        this.klx = ((com.tencent.mm.modelsimple.t)paramq).bfs();
      }
      if ((paramInt1 == 4) && ((paramInt2 == -16) || (paramInt2 == -17)))
      {
        i = 1;
        com.tencent.mm.kernel.g.azz().a(new bu(new bu.a()
        {
          public final void a(com.tencent.mm.network.g paramAnonymousg)
          {
            AppMethodBeat.i(128766);
            if (paramAnonymousg == null)
            {
              AppMethodBeat.o(128766);
              return;
            }
            paramAnonymousg = paramAnonymousg.aZh();
            com.tencent.mm.kernel.g.aAf();
            int i = com.tencent.mm.kernel.a.getUin();
            paramAnonymousg.a(new byte[0], new byte[0], new byte[0], i);
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
        com.tencent.mm.platformtools.t.dr(this);
        com.tencent.mm.platformtools.y.St(this.klt.account);
        paramString = new com.tencent.mm.plugin.account.model.c(getContext(), new c.a()
        {
          public final void boN()
          {
            String str = null;
            AppMethodBeat.i(128768);
            com.tencent.mm.pluginsdk.model.app.y localy = new com.tencent.mm.pluginsdk.model.app.y(SimpleLoginUI.this, new y.a()
            {
              public final void onFinished()
              {
                AppMethodBeat.i(128767);
                SimpleLoginUI.j(SimpleLoginUI.this);
                AppMethodBeat.o(128767);
              }
            });
            Object localObject1 = MMApplicationContext.getDefaultPreference();
            if (localObject1 != null)
            {
              localObject1 = ((SharedPreferences)localObject1).getString("key_app_ids_registion_while_not_login", "");
              if (Util.isNullOrNil((String)localObject1)) {
                Log.i("MicroMsg.AppUtil", "no saved appids while not login");
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
                localg = com.tencent.mm.pluginsdk.model.app.h.o(str, false, false);
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
                if (!Util.isNullOrNil(localg))
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
              Log.i("MicroMsg.LoadAppInfoAfterLogin", "no saved appids, just callback");
              com.tencent.mm.pluginsdk.model.app.q.gna();
              if (localy.JWu != null) {
                localy.JWu.onFinished();
              }
              AppMethodBeat.o(128768);
              return;
            }
            Log.i("MicroMsg.LoadAppInfoAfterLogin", "now do batch get appinfos, appid liSst size is :%d", new Object[] { Integer.valueOf(((LinkedList)localObject2).size()) });
            com.tencent.mm.plugin.r.a.eAV().a(7, localy);
            com.tencent.mm.plugin.r.a.eAR().bF((LinkedList)localObject2);
            if ((localy.mContext != null) && (!((Activity)localy.mContext).isFinishing()))
            {
              localObject1 = localy.mContext;
              localy.mContext.getString(2131755998);
              localy.tipDialog = com.tencent.mm.ui.base.h.a((Context)localObject1, localy.mContext.getString(2131756029), true, new y.1(localy));
              AppMethodBeat.o(128768);
              return;
            }
            if (localy.JWu != null) {
              localy.JWu.onFinished();
            }
            Log.e("MicroMsg.LoadAppInfoAfterLogin", "dz[loadAppInfo:catch the null window for progress bar");
            AppMethodBeat.o(128768);
          }
        });
        paramString.dGJ = com.tencent.mm.plugin.account.a.a.jRu.a(paramString);
        if (paramString.dGJ == null)
        {
          if (paramString.kio != null) {
            paramString.kio.boN();
          }
          AppMethodBeat.o(128788);
          return;
        }
        if (paramString.dGJ.getType() == 139) {
          com.tencent.mm.kernel.g.azz().a(139, paramString);
        }
        for (;;)
        {
          com.tencent.mm.kernel.g.azz().a(paramString.dGJ, 0);
          paramq = paramString.context;
          paramString.context.getString(2131755998);
          paramString.tipDialog = com.tencent.mm.ui.base.h.a(paramq, paramString.context.getString(2131755887), true, new c.1(paramString));
          AppMethodBeat.o(128788);
          return;
          if (paramString.dGJ.getType() == 138) {
            com.tencent.mm.kernel.g.azz().a(138, paramString);
          }
        }
      }
      if (paramInt2 == -217)
      {
        com.tencent.mm.platformtools.y.a(this, com.tencent.mm.platformtools.e.a((com.tencent.mm.modelsimple.t)paramq), paramInt2);
        AppMethodBeat.o(128788);
        return;
      }
      if (com.tencent.mm.plugin.account.a.a.jRu.a(getContext(), paramInt1, paramInt2, paramString)) {
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
          if (com.tencent.mm.kernel.g.azz().aYS() == 5)
          {
            com.tencent.mm.ui.base.h.n(this, 2131763503, 2131763502);
            i = 1;
          }
          break;
        case -30: 
        case -4: 
        case -3: 
          com.tencent.mm.ui.base.h.n(this, 2131758757, 2131762516);
          i = 1;
          break;
        case -9: 
          com.tencent.mm.ui.base.h.n(this, 2131762515, 2131762516);
          i = 1;
          break;
        case -72: 
          com.tencent.mm.ui.base.h.n(getContext(), 2131764440, 2131755998);
          i = 1;
          break;
        case -75: 
          com.tencent.mm.platformtools.y.dz(getContext());
          i = 1;
          break;
        case -311: 
        case -310: 
        case -6: 
          if (this.kdp == null) {
            this.kdp = SecurityImage.a.a(getContext(), this.klt.kmJ, this.klt.kdr, this.klt.kds, this.klt.kdt, new DialogInterface.OnClickListener()
            {
              public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(128764);
                Log.d("MicroMsg.SimpleLoginUI", "imgSid:" + SimpleLoginUI.g(SimpleLoginUI.this).kds + " img len" + SimpleLoginUI.g(SimpleLoginUI.this).kdr.length + " " + f.apq());
                paramAnonymousDialogInterface = new com.tencent.mm.modelsimple.t(SimpleLoginUI.g(SimpleLoginUI.this).account, SimpleLoginUI.g(SimpleLoginUI.this).kdq, SimpleLoginUI.g(SimpleLoginUI.this).kmJ, SimpleLoginUI.h(SimpleLoginUI.this).getSecImgCode(), SimpleLoginUI.h(SimpleLoginUI.this).getSecImgSid(), SimpleLoginUI.h(SimpleLoginUI.this).getSecImgEncryptKey(), 0, "", false, false);
                com.tencent.mm.kernel.g.azz().a(paramAnonymousDialogInterface, 0);
                SimpleLoginUI localSimpleLoginUI1 = SimpleLoginUI.this;
                SimpleLoginUI localSimpleLoginUI2 = SimpleLoginUI.this;
                SimpleLoginUI.this.getString(2131755998);
                SimpleLoginUI.a(localSimpleLoginUI1, com.tencent.mm.ui.base.h.a(localSimpleLoginUI2, SimpleLoginUI.this.getString(2131762532), true, new DialogInterface.OnCancelListener()
                {
                  public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                  {
                    AppMethodBeat.i(128763);
                    com.tencent.mm.kernel.g.azz().a(paramAnonymousDialogInterface);
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
            }, this.klt);
          }
          for (;;)
          {
            i = 1;
            break;
            Log.d("MicroMsg.SimpleLoginUI", "imgSid:" + this.klt.kds + " img len" + this.klt.kdr.length + " " + f.apq());
            this.kdp.b(this.klt.kmJ, this.klt.kdr, this.klt.kds, this.klt.kdt);
          }
        case -2023: 
        case -100: 
          com.tencent.mm.kernel.a.hold();
          com.tencent.mm.kernel.g.aAf();
          com.tencent.mm.ui.base.h.a(this, com.tencent.mm.kernel.a.ayX(), getString(2131755998), new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          }, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
          });
          i = 1;
          break;
        case -205: 
          Log.i("MicroMsg.SimpleLoginUI", "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]", new Object[] { Util.secPrint(this.kjv), this.klx });
          g.a(this.klt);
          paramq = new Intent();
          paramq.putExtra("auth_ticket", this.kjv);
          paramq.putExtra("binded_mobile", this.klX);
          paramq.putExtra("close_safe_device_style", this.klx);
          paramq.putExtra("from_source", 3);
          com.tencent.mm.plugin.account.a.a.jRt.g(this, paramq);
          i = 1;
          break;
        case -140: 
          if (!Util.isNullOrNil(this.edo)) {
            com.tencent.mm.platformtools.y.m(this, paramString, this.edo);
          }
          i = 1;
          break;
        case -106: 
          com.tencent.mm.platformtools.y.g(this, paramString, 0);
          i = 1;
        }
      }
      paramString = com.tencent.mm.h.a.Dk(paramString);
      if ((paramString != null) && (paramString.a(this, null, null)))
      {
        AppMethodBeat.o(128788);
        return;
      }
      Toast.makeText(this, getString(2131760805, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.SimpleLoginUI
 * JD-Core Version:    0.7.0.1
 */