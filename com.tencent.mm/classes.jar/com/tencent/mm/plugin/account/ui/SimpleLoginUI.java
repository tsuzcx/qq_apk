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
import com.tencent.mm.ak.n;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.bq.a;
import com.tencent.mm.plugin.account.model.c.1;
import com.tencent.mm.plugin.account.model.c.a;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.model.app.i;
import com.tencent.mm.pluginsdk.model.app.y.1;
import com.tencent.mm.pluginsdk.model.app.y.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.k;
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
  implements com.tencent.mm.ak.f
{
  private TextWatcher awu;
  private String dLz;
  private ProgressDialog fOC;
  private SecurityImage jfm;
  private String jlr;
  private com.tencent.mm.sdk.b.c jmB;
  private String jnP;
  private ResizeLayout jnT;
  private f jnl;
  private String jnp;
  private MMClearEditText joF;
  private MMClearEditText joG;
  private MMFormInputView joH;
  private MMFormInputView joI;
  private Button joJ;
  private MMKeyboardUperView joM;
  
  public SimpleLoginUI()
  {
    AppMethodBeat.i(128778);
    this.fOC = null;
    this.jfm = null;
    this.jnl = new f();
    this.dLz = "";
    this.awu = new TextWatcher()
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
    this.jmB = new SimpleLoginUI.12(this);
    AppMethodBeat.o(128778);
  }
  
  private void aSz()
  {
    AppMethodBeat.i(128784);
    boolean bool = getIntent().getBooleanExtra("key_auto_login_wizard_exit", false);
    if (!bool) {
      cancel();
    }
    acs(1);
    if (bool) {
      exit(1);
    }
    AppMethodBeat.o(128784);
  }
  
  private void aUs()
  {
    AppMethodBeat.i(128785);
    this.jnl.account = this.joF.getText().toString().trim();
    this.jnl.jfn = this.joG.getText().toString();
    if (this.jnl.account.equals(""))
    {
      com.tencent.mm.ui.base.h.l(this, 2131764665, 2131760766);
      AppMethodBeat.o(128785);
      return;
    }
    if (this.jnl.jfn.equals(""))
    {
      com.tencent.mm.ui.base.h.l(this, 2131764658, 2131760766);
      AppMethodBeat.o(128785);
      return;
    }
    hideVKB();
    final com.tencent.mm.modelsimple.t localt = new com.tencent.mm.modelsimple.t(this.jnl.account, this.jnl.jfn, this.jlr, 0);
    com.tencent.mm.kernel.g.ajj().a(localt, 0);
    getString(2131755906);
    this.fOC = com.tencent.mm.ui.base.h.b(this, getString(2131760781), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(128762);
        com.tencent.mm.kernel.g.ajj().a(localt);
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
    this.joH = ((MMFormInputView)findViewById(2131301558));
    this.joI = ((MMFormInputView)findViewById(2131301577));
    this.joF = ((MMClearEditText)this.joH.getContentEditText());
    this.joF.setFocusableInTouchMode(false);
    this.joF.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(128771);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/SimpleLoginUI$4", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
        SimpleLoginUI.c(SimpleLoginUI.this).setFocusableInTouchMode(true);
        boolean bool = SimpleLoginUI.c(SimpleLoginUI.this).getDefaultOnTouchListener().onTouch(paramAnonymousView, paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/account/ui/SimpleLoginUI$4", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(128771);
        return bool;
      }
    });
    this.joG = ((MMClearEditText)this.joI.getContentEditText());
    this.joG.setFocusableInTouchMode(false);
    this.joG.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(128772);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/SimpleLoginUI$5", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
        SimpleLoginUI.d(SimpleLoginUI.this).setFocusableInTouchMode(true);
        SimpleLoginUI.c(SimpleLoginUI.this).setFocusableInTouchMode(false);
        boolean bool = SimpleLoginUI.d(SimpleLoginUI.this).getDefaultOnTouchListener().onTouch(paramAnonymousView, paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/account/ui/SimpleLoginUI$5", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(128772);
        return bool;
      }
    });
    com.tencent.mm.ui.tools.b.c.d(this.joG).afD(16).a(null);
    this.joJ = ((Button)findViewById(2131301562));
    this.joJ.setEnabled(false);
    this.joF.addTextChangedListener(this.awu);
    this.joG.addTextChangedListener(this.awu);
    this.joG.setOnEditorActionListener(new TextView.OnEditorActionListener()
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
    this.joG.setOnKeyListener(new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(128774);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        localb.mu(paramAnonymousInt);
        localb.bd(paramAnonymousKeyEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/SimpleLoginUI$7", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.ahF());
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
    this.jnT = ((ResizeLayout)findViewById(2131304133));
    this.joM = ((MMKeyboardUperView)findViewById(2131304370));
    this.jnT.setOnSizeChanged(new ResizeLayout.a()
    {
      public final void aUw()
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
    this.joM.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(128777);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/SimpleLoginUI$9", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
        SimpleLoginUI.this.hideVKB();
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/account/ui/SimpleLoginUI$9", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
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
    this.jlr = getIntent().getStringExtra("auth_ticket");
    if (!bu.isNullOrNil(this.jlr))
    {
      this.joF.setText(bu.nullAsNil(f.aUx()));
      this.joG.setText(bu.nullAsNil(f.aUy()));
      new aq().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(128760);
          SimpleLoginUI.b(SimpleLoginUI.this);
          AppMethodBeat.o(128760);
        }
      }, 500L);
    }
    if (k.IwK) {
      com.tencent.mm.plugin.account.a.a.iUA.t(this);
    }
    this.joJ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(128761);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/SimpleLoginUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        SimpleLoginUI.b(SimpleLoginUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/SimpleLoginUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
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
      ae.d("MicroMsg.SimpleLoginUI", "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      if ((paramInt2 != -1) || (paramInt1 != 1024) || (paramIntent == null)) {
        break label178;
      }
      str = paramIntent.getStringExtra("VoiceLoginAuthPwd");
      paramInt2 = paramIntent.getIntExtra("KVoiceHelpCode", 0);
      bool = bu.isNullOrNil(str);
      if (!bu.isNullOrNil(str)) {
        break label169;
      }
    }
    label169:
    for (paramInt1 = i;; paramInt1 = str.length())
    {
      ae.d("MicroMsg.SimpleLoginUI", "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (paramInt2 != -217) {
        break label178;
      }
      aUs();
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
    paramBundle = getSharedPreferences("system_config_prefs", com.tencent.mm.compatible.util.g.abv());
    if (paramBundle.getBoolean("first_launch_weixin", true))
    {
      paramBundle.edit().putBoolean("first_launch_weixin", false).commit();
      XLogSetup.realSetupXlog();
    }
    setMMTitle(2131755822);
    if (com.tencent.mm.plugin.account.a.a.iUA != null) {
      com.tencent.mm.plugin.account.a.a.iUA.MP();
    }
    initView();
    com.tencent.mm.kernel.g.ajj().a(701, this);
    com.tencent.mm.kernel.g.ajj().a(252, this);
    if (!com.tencent.mm.pluginsdk.permission.b.aQ(this))
    {
      new Intent().addFlags(67108864);
      com.tencent.mm.plugin.account.a.a.iUz.p(new Intent(), this);
    }
    AppMethodBeat.o(128779);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128781);
    com.tencent.mm.kernel.g.ajj().b(701, this);
    com.tencent.mm.kernel.g.ajj().b(252, this);
    super.onDestroy();
    AppMethodBeat.o(128781);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(128786);
    if (paramInt == 4)
    {
      aSz();
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
    this.jlr = paramIntent.getStringExtra("auth_ticket");
    paramIntent = getIntent().getExtras();
    if (paramIntent != null) {
      this.jlr = paramIntent.getString("auth_ticket");
    }
    if (!bu.isNullOrNil(this.jlr))
    {
      this.joF.setText(bu.nullAsNil(f.aUx()));
      this.joG.setText(bu.nullAsNil(f.aUy()));
      new aq().postDelayed(new Runnable()
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
    if (this.fOC != null)
    {
      this.fOC.dismiss();
      this.fOC = null;
    }
    super.onPause();
    com.tencent.mm.sdk.b.a.IvT.d(this.jmB);
    AppMethodBeat.o(128787);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(128780);
    com.tencent.mm.sdk.b.a.IvT.c(this.jmB);
    super.onResume();
    AppMethodBeat.o(128780);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(128788);
    ae.i("MicroMsg.SimpleLoginUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    ae.d("MicroMsg.SimpleLoginUI", "Scene Type " + paramn.getType());
    if (this.fOC != null)
    {
      this.fOC.dismiss();
      this.fOC = null;
    }
    this.dLz = ((com.tencent.mm.modelsimple.t)paramn).aLh();
    int i;
    if ((paramn.getType() == 252) || (paramn.getType() == 701))
    {
      this.jnl.joz = ((com.tencent.mm.modelsimple.t)paramn).getSecCodeType();
      this.jnl.jfp = ((com.tencent.mm.modelsimple.t)paramn).aLi();
      this.jnl.jfo = ((com.tencent.mm.modelsimple.t)paramn).aLj();
      this.jnl.jfq = ((com.tencent.mm.modelsimple.t)paramn).aLk();
      if (paramInt2 == -205)
      {
        this.jlr = ((com.tencent.mm.modelsimple.t)paramn).aHO();
        this.jnP = ((com.tencent.mm.modelsimple.t)paramn).aLm();
        this.jnp = ((com.tencent.mm.modelsimple.t)paramn).aLp();
      }
      if ((paramInt1 == 4) && ((paramInt2 == -16) || (paramInt2 == -17)))
      {
        i = 1;
        com.tencent.mm.kernel.g.ajj().a(new bq(new bq.a()
        {
          public final void a(com.tencent.mm.network.e paramAnonymouse)
          {
            AppMethodBeat.i(128766);
            if (paramAnonymouse == null)
            {
              AppMethodBeat.o(128766);
              return;
            }
            paramAnonymouse = paramAnonymouse.aFs();
            com.tencent.mm.kernel.g.ajP();
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
        com.tencent.mm.platformtools.t.cW(this);
        com.tencent.mm.platformtools.y.Jv(this.jnl.account);
        paramString = new com.tencent.mm.plugin.account.model.c(getContext(), new c.a()
        {
          public final void aUb()
          {
            String str = null;
            AppMethodBeat.i(128768);
            com.tencent.mm.pluginsdk.model.app.y localy = new com.tencent.mm.pluginsdk.model.app.y(SimpleLoginUI.this, new y.a()
            {
              public final void aVl()
              {
                AppMethodBeat.i(128767);
                SimpleLoginUI.j(SimpleLoginUI.this);
                AppMethodBeat.o(128767);
              }
            });
            Object localObject1 = ak.fox();
            if (localObject1 != null)
            {
              localObject1 = ((SharedPreferences)localObject1).getString("key_app_ids_registion_while_not_login", "");
              if (bu.isNullOrNil((String)localObject1)) {
                ae.i("MicroMsg.AppUtil", "no saved appids while not login");
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
                localg = com.tencent.mm.pluginsdk.model.app.h.m(str, false, false);
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
                if (!bu.isNullOrNil(localg))
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
              ae.i("MicroMsg.LoadAppInfoAfterLogin", "no saved appids, just callback");
              com.tencent.mm.pluginsdk.model.app.q.fdP();
              if (localy.FfD != null) {
                localy.FfD.aVl();
              }
              AppMethodBeat.o(128768);
              return;
            }
            ae.i("MicroMsg.LoadAppInfoAfterLogin", "now do batch get appinfos, appid liSst size is :%d", new Object[] { Integer.valueOf(((LinkedList)localObject2).size()) });
            com.tencent.mm.plugin.s.a.dBj().a(7, localy);
            com.tencent.mm.plugin.s.a.dBf().bk((LinkedList)localObject2);
            if ((localy.mContext != null) && (!((Activity)localy.mContext).isFinishing()))
            {
              localObject1 = localy.mContext;
              localy.mContext.getString(2131755906);
              localy.tipDialog = com.tencent.mm.ui.base.h.b((Context)localObject1, localy.mContext.getString(2131755936), true, new y.1(localy));
              AppMethodBeat.o(128768);
              return;
            }
            if (localy.FfD != null) {
              localy.FfD.aVl();
            }
            ae.e("MicroMsg.LoadAppInfoAfterLogin", "dz[loadAppInfo:catch the null window for progress bar");
            AppMethodBeat.o(128768);
          }
        });
        paramString.dpw = com.tencent.mm.plugin.account.a.a.iUA.a(paramString);
        if (paramString.dpw == null)
        {
          if (paramString.jkm != null) {
            paramString.jkm.aUb();
          }
          AppMethodBeat.o(128788);
          return;
        }
        if (paramString.dpw.getType() == 139) {
          com.tencent.mm.kernel.g.ajj().a(139, paramString);
        }
        for (;;)
        {
          com.tencent.mm.kernel.g.ajj().a(paramString.dpw, 0);
          paramn = paramString.context;
          paramString.context.getString(2131755906);
          paramString.tipDialog = com.tencent.mm.ui.base.h.b(paramn, paramString.context.getString(2131755805), true, new c.1(paramString));
          AppMethodBeat.o(128788);
          return;
          if (paramString.dpw.getType() == 138) {
            com.tencent.mm.kernel.g.ajj().a(138, paramString);
          }
        }
      }
      if (paramInt2 == -217)
      {
        com.tencent.mm.platformtools.y.a(this, com.tencent.mm.platformtools.e.a((com.tencent.mm.modelsimple.t)paramn), paramInt2);
        AppMethodBeat.o(128788);
        return;
      }
      if (com.tencent.mm.plugin.account.a.a.iUA.a(getContext(), paramInt1, paramInt2, paramString)) {
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
          if (com.tencent.mm.kernel.g.ajj().aFd() == 5)
          {
            com.tencent.mm.ui.base.h.l(this, 2131761537, 2131761536);
            i = 1;
          }
          break;
        case -30: 
        case -4: 
        case -3: 
          com.tencent.mm.ui.base.h.l(this, 2131758459, 2131760766);
          i = 1;
          break;
        case -9: 
          com.tencent.mm.ui.base.h.l(this, 2131760765, 2131760766);
          i = 1;
          break;
        case -72: 
          com.tencent.mm.ui.base.h.l(getContext(), 2131762374, 2131755906);
          i = 1;
          break;
        case -75: 
          com.tencent.mm.platformtools.y.de(getContext());
          i = 1;
          break;
        case -311: 
        case -310: 
        case -6: 
          if (this.jfm == null) {
            this.jfm = SecurityImage.a.a(getContext(), this.jnl.joz, this.jnl.jfo, this.jnl.jfp, this.jnl.jfq, new DialogInterface.OnClickListener()
            {
              public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(128764);
                ae.d("MicroMsg.SimpleLoginUI", "imgSid:" + SimpleLoginUI.g(SimpleLoginUI.this).jfp + " img len" + SimpleLoginUI.g(SimpleLoginUI.this).jfo.length + " " + com.tencent.mm.compatible.util.f.abr());
                paramAnonymousDialogInterface = new com.tencent.mm.modelsimple.t(SimpleLoginUI.g(SimpleLoginUI.this).account, SimpleLoginUI.g(SimpleLoginUI.this).jfn, SimpleLoginUI.g(SimpleLoginUI.this).joz, SimpleLoginUI.h(SimpleLoginUI.this).getSecImgCode(), SimpleLoginUI.h(SimpleLoginUI.this).getSecImgSid(), SimpleLoginUI.h(SimpleLoginUI.this).getSecImgEncryptKey(), 0, "", false, false);
                com.tencent.mm.kernel.g.ajj().a(paramAnonymousDialogInterface, 0);
                SimpleLoginUI localSimpleLoginUI1 = SimpleLoginUI.this;
                SimpleLoginUI localSimpleLoginUI2 = SimpleLoginUI.this;
                SimpleLoginUI.this.getString(2131755906);
                SimpleLoginUI.a(localSimpleLoginUI1, com.tencent.mm.ui.base.h.b(localSimpleLoginUI2, SimpleLoginUI.this.getString(2131760781), true, new DialogInterface.OnCancelListener()
                {
                  public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                  {
                    AppMethodBeat.i(128763);
                    com.tencent.mm.kernel.g.ajj().a(paramAnonymousDialogInterface);
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
            }, this.jnl);
          }
          for (;;)
          {
            i = 1;
            break;
            ae.d("MicroMsg.SimpleLoginUI", "imgSid:" + this.jnl.jfp + " img len" + this.jnl.jfo.length + " " + com.tencent.mm.compatible.util.f.abr());
            this.jfm.b(this.jnl.joz, this.jnl.jfo, this.jnl.jfp, this.jnl.jfq);
          }
        case -100: 
          com.tencent.mm.kernel.a.hold();
          com.tencent.mm.kernel.g.ajP();
          com.tencent.mm.ui.base.h.a(this, com.tencent.mm.kernel.a.aiH(), getString(2131755906), new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          }, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
          });
          i = 1;
          break;
        case -205: 
          ae.i("MicroMsg.SimpleLoginUI", "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]", new Object[] { bu.aSM(this.jlr), this.jnp });
          f.a(this.jnl);
          paramn = new Intent();
          paramn.putExtra("auth_ticket", this.jlr);
          paramn.putExtra("binded_mobile", this.jnP);
          paramn.putExtra("close_safe_device_style", this.jnp);
          paramn.putExtra("from_source", 3);
          com.tencent.mm.plugin.account.a.a.iUz.g(this, paramn);
          i = 1;
          break;
        case -140: 
          if (!bu.isNullOrNil(this.dLz)) {
            com.tencent.mm.platformtools.y.n(this, paramString, this.dLz);
          }
          i = 1;
          break;
        case -106: 
          com.tencent.mm.platformtools.y.g(this, paramString, 0);
          i = 1;
        }
      }
      paramString = com.tencent.mm.h.a.uU(paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.SimpleLoginUI
 * JD-Core Version:    0.7.0.1
 */