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
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.model.bw;
import com.tencent.mm.model.bw.a;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.plugin.account.model.c.1;
import com.tencent.mm.plugin.account.model.c.a;
import com.tencent.mm.plugin.comm.c.h;
import com.tencent.mm.plugin.mvvmbase.BaseMvvmWizardActivity;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.model.app.ac;
import com.tencent.mm.pluginsdk.model.app.ac.1;
import com.tencent.mm.pluginsdk.model.app.ac.a;
import com.tencent.mm.pluginsdk.model.app.i;
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
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.xlog.app.XLogSetup;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class SimpleLoginUI
  extends BaseMvvmWizardActivity
  implements com.tencent.mm.am.h
{
  private String idu;
  private ProgressDialog lzP;
  private SecurityImage pRw;
  private String pYt;
  private f pZh;
  private String pZj;
  private String pZk;
  private IListener pZz;
  private MMClearEditText qbv;
  private MMClearEditText qbw;
  private MMFormInputView qbx;
  private MMFormInputView qby;
  private Button qbz;
  private TextWatcher vU;
  
  public SimpleLoginUI()
  {
    AppMethodBeat.i(128778);
    this.lzP = null;
    this.pRw = null;
    this.pZh = new f();
    this.idu = "";
    this.vU = new TextWatcher()
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
    this.pZz = new SimpleLoginUI.2(this, com.tencent.mm.app.f.hfK);
    AppMethodBeat.o(128778);
  }
  
  private void bWj()
  {
    AppMethodBeat.i(128784);
    boolean bool = getIntent().getBooleanExtra("key_auto_login_wizard_exit", false);
    if (!bool) {
      cancel();
    }
    aAp(1);
    if (bool) {
      exit(1);
    }
    AppMethodBeat.o(128784);
  }
  
  private void bXX()
  {
    AppMethodBeat.i(128785);
    this.pZh.account = this.qbv.getText().toString().trim();
    this.pZh.pRx = this.qbw.getText().toString();
    if (this.pZh.account.equals(""))
    {
      com.tencent.mm.ui.base.k.s(this, r.j.verify_username_null_tip, r.j.login_err_title);
      AppMethodBeat.o(128785);
      return;
    }
    if (this.pZh.pRx.equals(""))
    {
      com.tencent.mm.ui.base.k.s(this, r.j.verify_password_null_tip, r.j.login_err_title);
      AppMethodBeat.o(128785);
      return;
    }
    hideVKB();
    com.tencent.mm.modelsimple.u localu = new com.tencent.mm.modelsimple.u(this.pZh.account, this.pZh.pRx, this.pYt, 0);
    com.tencent.mm.kernel.h.aZW().a(localu, 0);
    getString(r.j.app_tip);
    this.lzP = com.tencent.mm.ui.base.k.a(this, getString(r.j.login_logining), true, new SimpleLoginUI.6(this, localu));
    AppMethodBeat.o(128785);
  }
  
  public int getLayoutId()
  {
    return r.g.login;
  }
  
  public void initView()
  {
    AppMethodBeat.i(128783);
    this.qbx = ((MMFormInputView)findViewById(r.f.login_account_auto));
    TextView localTextView = (TextView)findViewById(r.f.login_title);
    if (WeChatBrands.AppInfo.current().isMainland())
    {
      this.qbx.setHint(r.j.login_account_hint);
      localTextView.setText(r.j.login_by_other_account_title);
    }
    for (;;)
    {
      this.qby = ((MMFormInputView)findViewById(r.f.login_password_et));
      this.qbv = ((MMClearEditText)this.qbx.getContentEditText());
      this.qbv.setFocusableInTouchMode(false);
      this.qbv.setOnTouchListener(new View.OnTouchListener()
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
      this.qbw = ((MMClearEditText)this.qby.getContentEditText());
      this.qbw.setFocusableInTouchMode(false);
      this.qbw.setOnTouchListener(new View.OnTouchListener()
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
      com.tencent.mm.ui.tools.b.c.i(this.qbw).aEg(16).a(null);
      this.qbz = ((Button)findViewById(r.f.login_btn));
      this.qbz.setEnabled(false);
      this.qbv.addTextChangedListener(this.vU);
      this.qbw.addTextChangedListener(this.vU);
      this.qbw.setOnEditorActionListener(new TextView.OnEditorActionListener()
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
      this.qbw.setOnKeyListener(new View.OnKeyListener()
      {
        public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(128774);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          localb.sc(paramAnonymousInt);
          localb.cH(paramAnonymousKeyEvent);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/SimpleLoginUI$7", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.aYj());
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
      this.qbv.setOnFocusChangeListener(new View.OnFocusChangeListener()
      {
        public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(305038);
          paramAnonymousView = com.tencent.mm.ui.component.k.aeZF;
          ((com.tencent.mm.plugin.mvvmbase.b.a)com.tencent.mm.ui.component.k.d(SimpleLoginUI.this).q(com.tencent.mm.plugin.mvvmbase.b.a.class)).Aa(paramAnonymousBoolean);
          AppMethodBeat.o(305038);
        }
      });
      this.qbw.setOnFocusChangeListener(new View.OnFocusChangeListener()
      {
        public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(305039);
          paramAnonymousView = com.tencent.mm.ui.component.k.aeZF;
          ((com.tencent.mm.plugin.mvvmbase.b.a)com.tencent.mm.ui.component.k.d(SimpleLoginUI.this).q(com.tencent.mm.plugin.mvvmbase.b.a.class)).Aa(paramAnonymousBoolean);
          AppMethodBeat.o(305039);
        }
      });
      findViewById(r.f.login_by_other).setVisibility(8);
      setMMTitle(r.j.login_title);
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(128759);
          SimpleLoginUI.e(SimpleLoginUI.this);
          AppMethodBeat.o(128759);
          return true;
        }
      });
      this.pYt = getIntent().getStringExtra("auth_ticket");
      if (!Util.isNullOrNil(this.pYt))
      {
        this.qbv.setText(Util.nullAsNil(f.bYd()));
        this.qbw.setText(Util.nullAsNil(f.bYe()));
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
        com.tencent.mm.plugin.account.sdk.a.pFo.u(this);
      }
      this.qbz.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128761);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/SimpleLoginUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          SimpleLoginUI.b(SimpleLoginUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/SimpleLoginUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(128761);
        }
      });
      AppMethodBeat.o(128783);
      return;
      this.qbx.setHint(r.j.login_account_hint_oversea);
      localTextView.setText(r.j.login_by_other_account_title_oversea);
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
      bXX();
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
    paramBundle = getSharedPreferences("system_config_prefs", com.tencent.mm.compatible.util.g.aQe());
    if (paramBundle.getBoolean("first_launch_weixin", true))
    {
      paramBundle.edit().putBoolean("first_launch_weixin", false).commit();
      XLogSetup.realSetupXlog();
    }
    setMMTitle(r.j.app_name);
    if (com.tencent.mm.plugin.account.sdk.a.pFo != null) {
      com.tencent.mm.plugin.account.sdk.a.pFo.aDA();
    }
    initView();
    com.tencent.mm.kernel.h.aZW().a(701, this);
    com.tencent.mm.kernel.h.aZW().a(252, this);
    AppMethodBeat.o(128779);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128781);
    com.tencent.mm.kernel.h.aZW().b(701, this);
    com.tencent.mm.kernel.h.aZW().b(252, this);
    hideVKB();
    super.onDestroy();
    AppMethodBeat.o(128781);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(128786);
    if (paramInt == 4)
    {
      bWj();
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
    this.pYt = paramIntent.getStringExtra("auth_ticket");
    paramIntent = getIntent().getExtras();
    if (paramIntent != null) {
      this.pYt = paramIntent.getString("auth_ticket");
    }
    if (!Util.isNullOrNil(this.pYt))
    {
      this.qbv.setText(Util.nullAsNil(f.bYd()));
      this.qbw.setText(Util.nullAsNil(f.bYe()));
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
    if (this.lzP != null)
    {
      this.lzP.dismiss();
      this.lzP = null;
    }
    super.onPause();
    this.pZz.dead();
    AppMethodBeat.o(128787);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(128780);
    this.pZz.alive();
    super.onResume();
    AppMethodBeat.o(128780);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(128788);
    Log.i("MicroMsg.SimpleLoginUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    Log.d("MicroMsg.SimpleLoginUI", "Scene Type " + paramp.getType());
    if (this.lzP != null)
    {
      this.lzP.dismiss();
      this.lzP = null;
    }
    this.idu = ((com.tencent.mm.modelsimple.u)paramp).bMh();
    int i;
    if ((paramp.getType() == 252) || (paramp.getType() == 701))
    {
      this.pZh.qbo = ((com.tencent.mm.modelsimple.u)paramp).getSecCodeType();
      this.pZh.pRz = ((com.tencent.mm.modelsimple.u)paramp).bMi();
      this.pZh.pRy = ((com.tencent.mm.modelsimple.u)paramp).bMj();
      this.pZh.pRA = ((com.tencent.mm.modelsimple.u)paramp).bMk();
      if (paramInt2 == -205)
      {
        this.pYt = ((com.tencent.mm.modelsimple.u)paramp).bIR();
        this.pZj = ((com.tencent.mm.modelsimple.u)paramp).bMm();
        this.pZk = ((com.tencent.mm.modelsimple.u)paramp).bMp();
      }
      if ((paramInt1 == 4) && ((paramInt2 == -16) || (paramInt2 == -17)))
      {
        i = 1;
        com.tencent.mm.kernel.h.aZW().a(new bw(new bw.a()
        {
          public final void b(com.tencent.mm.network.g paramAnonymousg)
          {
            AppMethodBeat.i(128766);
            if (paramAnonymousg == null)
            {
              AppMethodBeat.o(128766);
              return;
            }
            paramAnonymousg = paramAnonymousg.bGg();
            com.tencent.mm.kernel.h.baC();
            int i = com.tencent.mm.kernel.b.getUin();
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
        com.tencent.mm.kernel.b.aZI();
        v.Sj(this.pZh.account);
        paramString = new com.tencent.mm.plugin.account.model.c(getContext(), new c.a()
        {
          public final void bXK()
          {
            String str = null;
            AppMethodBeat.i(128768);
            ac localac = new ac(SimpleLoginUI.this, new ac.a()
            {
              public final void onFinished()
              {
                AppMethodBeat.i(128767);
                SimpleLoginUI.i(SimpleLoginUI.this);
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
                localg = com.tencent.mm.pluginsdk.model.app.h.s(str, false, false);
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
              com.tencent.mm.pluginsdk.model.app.u.iID();
              if (localac.XSL != null) {
                localac.XSL.onFinished();
              }
              AppMethodBeat.o(128768);
              return;
            }
            Log.i("MicroMsg.LoadAppInfoAfterLogin", "now do batch get appinfos, appid liSst size is :%d", new Object[] { Integer.valueOf(((LinkedList)localObject2).size()) });
            com.tencent.mm.plugin.openapi.a.gxq().a(7, localac);
            com.tencent.mm.plugin.openapi.a.gxm().cq((LinkedList)localObject2);
            if ((localac.mContext != null) && (!((Activity)localac.mContext).isFinishing()))
            {
              localObject1 = localac.mContext;
              localac.mContext.getString(c.h.app_tip);
              localac.tipDialog = com.tencent.mm.ui.base.k.a((Context)localObject1, localac.mContext.getString(c.h.app_waiting), true, new ac.1(localac));
              AppMethodBeat.o(128768);
              return;
            }
            if (localac.XSL != null) {
              localac.XSL.onFinished();
            }
            Log.e("MicroMsg.LoadAppInfoAfterLogin", "dz[loadAppInfo:catch the null window for progress bar");
            AppMethodBeat.o(128768);
          }
        });
        paramString.hEi = com.tencent.mm.plugin.account.sdk.a.pFo.a(paramString);
        if (paramString.hEi == null)
        {
          if (paramString.pWx != null) {
            paramString.pWx.bXK();
          }
          AppMethodBeat.o(128788);
          return;
        }
        if (paramString.hEi.getType() == 139) {
          com.tencent.mm.kernel.h.aZW().a(139, paramString);
        }
        for (;;)
        {
          com.tencent.mm.kernel.h.aZW().a(paramString.hEi, 0);
          paramp = paramString.context;
          paramString.context.getString(r.j.app_tip);
          paramString.tipDialog = com.tencent.mm.ui.base.k.a(paramp, paramString.context.getString(r.j.app_loading_data), true, new c.1(paramString));
          AppMethodBeat.o(128788);
          return;
          if (paramString.hEi.getType() == 138) {
            com.tencent.mm.kernel.h.aZW().a(138, paramString);
          }
        }
      }
      if (paramInt2 == -217)
      {
        v.a(this, com.tencent.mm.platformtools.e.d((com.tencent.mm.modelsimple.u)paramp), paramInt2);
        AppMethodBeat.o(128788);
        return;
      }
      if (com.tencent.mm.plugin.account.sdk.a.pFo.a(getContext(), paramInt1, paramInt2, paramString)) {
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
          if (com.tencent.mm.kernel.h.aZW().bFQ() == 5)
          {
            com.tencent.mm.ui.base.k.s(this, r.j.net_warn_server_down_tip, r.j.net_warn_server_down);
            i = 1;
          }
          break;
        case -30: 
        case -4: 
        case -3: 
          com.tencent.mm.ui.base.k.s(this, r.j.errcode_password, r.j.login_err_title);
          i = 1;
          break;
        case -9: 
          com.tencent.mm.ui.base.k.s(this, r.j.login_err_mailnotverify, r.j.login_err_title);
          i = 1;
          break;
        case -72: 
          com.tencent.mm.ui.base.k.s(getContext(), r.j.regbyqq_auth_err_failed_niceqq, r.j.app_tip);
          i = 1;
          break;
        case -75: 
          v.ei(getContext());
          i = 1;
          break;
        case -311: 
        case -310: 
        case -6: 
          if (this.pRw == null) {
            this.pRw = SecurityImage.a.a(getContext(), r.j.regbyqq_secimg_title, this.pZh.qbo, this.pZh.pRy, this.pZh.pRz, this.pZh.pRA, new DialogInterface.OnClickListener()
            {
              public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(128764);
                Log.d("MicroMsg.SimpleLoginUI", "imgSid:" + SimpleLoginUI.f(SimpleLoginUI.this).pRz + " img len" + SimpleLoginUI.f(SimpleLoginUI.this).pRy.length + " " + com.tencent.mm.compatible.util.f.aPX());
                paramAnonymousDialogInterface = new com.tencent.mm.modelsimple.u(SimpleLoginUI.f(SimpleLoginUI.this).account, SimpleLoginUI.f(SimpleLoginUI.this).pRx, SimpleLoginUI.f(SimpleLoginUI.this).qbo, SimpleLoginUI.g(SimpleLoginUI.this).getSecImgCode(), SimpleLoginUI.g(SimpleLoginUI.this).getSecImgSid(), SimpleLoginUI.g(SimpleLoginUI.this).getSecImgEncryptKey(), 0, "", false, false);
                com.tencent.mm.kernel.h.aZW().a(paramAnonymousDialogInterface, 0);
                SimpleLoginUI localSimpleLoginUI1 = SimpleLoginUI.this;
                SimpleLoginUI localSimpleLoginUI2 = SimpleLoginUI.this;
                SimpleLoginUI.this.getString(r.j.app_tip);
                SimpleLoginUI.a(localSimpleLoginUI1, com.tencent.mm.ui.base.k.a(localSimpleLoginUI2, SimpleLoginUI.this.getString(r.j.login_logining), true, new DialogInterface.OnCancelListener()
                {
                  public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                  {
                    AppMethodBeat.i(128763);
                    com.tencent.mm.kernel.h.aZW().a(paramAnonymousDialogInterface);
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
                SimpleLoginUI.h(SimpleLoginUI.this);
                AppMethodBeat.o(128765);
              }
            }, this.pZh);
          }
          for (;;)
          {
            i = 1;
            break;
            Log.d("MicroMsg.SimpleLoginUI", "imgSid:" + this.pZh.pRz + " img len" + this.pZh.pRy.length + " " + com.tencent.mm.compatible.util.f.aPX());
            this.pRw.b(this.pZh.qbo, this.pZh.pRy, this.pZh.pRz, this.pZh.pRA);
          }
        case -2023: 
        case -100: 
          com.tencent.mm.kernel.b.aZH();
          com.tencent.mm.kernel.h.baC();
          com.tencent.mm.ui.base.k.a(this, com.tencent.mm.kernel.b.aZu(), getString(r.j.app_tip), new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          }, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
          });
          i = 1;
          break;
        case -205: 
          Log.i("MicroMsg.SimpleLoginUI", "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]", new Object[] { Util.secPrint(this.pYt), this.pZk });
          f.a(this.pZh);
          paramp = new Intent();
          paramp.putExtra("auth_ticket", this.pYt);
          paramp.putExtra("binded_mobile", this.pZj);
          paramp.putExtra("close_safe_device_style", this.pZk);
          paramp.putExtra("from_source", 3);
          com.tencent.mm.plugin.account.sdk.a.pFn.g(this, paramp);
          i = 1;
          break;
        case -140: 
          if (!Util.isNullOrNil(this.idu)) {
            v.r(this, paramString, this.idu);
          }
          i = 1;
          break;
        case -106: 
          v.f(this, paramString, 0);
          i = 1;
        }
      }
      paramString = com.tencent.mm.broadcast.a.CH(paramString);
      if ((paramString != null) && (paramString.a(this, null, null)))
      {
        AppMethodBeat.o(128788);
        return;
      }
      Toast.makeText(this, getString(r.j.fmt_auth_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
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
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(305155);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(com.tencent.mm.plugin.mvvmbase.b.a.class);
    AppMethodBeat.o(305155);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.SimpleLoginUI
 * JD-Core Version:    0.7.0.1
 */