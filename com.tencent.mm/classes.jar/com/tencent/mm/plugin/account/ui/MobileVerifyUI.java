package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.text.Editable;
import android.text.Html;
import android.text.InputFilter;
import android.text.Spanned;
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
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.platformtools.ad;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.PhoneFormater;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.tools.m;
import com.tencent.mm.ui.widget.MMEditText.c;

public class MobileVerifyUI
  extends MMActivity
{
  private MTimerHandler cts;
  protected String fLC;
  protected ProgressDialog iXX = null;
  protected Button jbJ;
  protected EditText mSy;
  protected TextView mSz;
  String mTu;
  SecurityImage mUP = null;
  int mam;
  private com.tencent.mm.platformtools.b ndW;
  protected boolean neP = false;
  private int nfI;
  String nfX;
  protected String nfm;
  protected MMFormInputView ngJ;
  protected TextView ngK;
  protected TextView ngL;
  protected TextView ngM;
  protected ScrollView ngN;
  private long ngO = 0L;
  private String[] ngP;
  private boolean ngQ = false;
  Boolean ngR;
  private int ngS = 30;
  protected boolean ngT = false;
  protected boolean ngU = false;
  protected int ngV = -1;
  private b ngW;
  String ngX;
  protected String ngY;
  int ngf;
  protected int ngh;
  String nickName;
  
  private void bzG()
  {
    AppMethodBeat.i(128458);
    if (this.cts == null)
    {
      this.ngO = this.ngS;
      this.cts = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(213803);
          MobileVerifyUI.b(MobileVerifyUI.this);
          if (MobileVerifyUI.c(MobileVerifyUI.this) >= 0L) {
            MobileVerifyUI.this.ngL.setText(MobileVerifyUI.this.getResources().getQuantityString(r.h.mobileverify_send_code_tip, (int)MobileVerifyUI.c(MobileVerifyUI.this), new Object[] { Integer.valueOf((int)MobileVerifyUI.c(MobileVerifyUI.this)) }));
          }
          for (;;)
          {
            AppMethodBeat.o(213803);
            return true;
            MobileVerifyUI.this.ngL.setVisibility(8);
            MobileVerifyUI.this.ngK.setVisibility(0);
            MobileVerifyUI.d(MobileVerifyUI.this);
            MobileVerifyUI.this.ngK.setEnabled(true);
            MobileVerifyUI.this.ngK.setText(MobileVerifyUI.this.getString(r.j.mobileverify_nocode));
          }
        }
      }, true);
      this.cts.startTimer(1000L, 1000L);
    }
    AppMethodBeat.o(128458);
  }
  
  private void bzH()
  {
    AppMethodBeat.i(128461);
    hideVKB();
    if (this.mSy.getText().toString().trim().equals(""))
    {
      com.tencent.mm.ui.base.h.p(this, r.j.bind_mcontact_verifynull, r.j.app_tip);
      AppMethodBeat.o(128461);
      return;
    }
    this.ngW.a(a.nhf);
    AppMethodBeat.o(128461);
  }
  
  private void bzI()
  {
    AppMethodBeat.i(128462);
    this.ngQ = false;
    this.ngK.setEnabled(false);
    this.ngL.setVisibility(0);
    this.ngL.setText(getResources().getQuantityString(r.h.mobileverify_send_code_tip, this.ngS, new Object[] { Integer.valueOf(this.ngS) }));
    this.ngK.setVisibility(8);
    bzG();
    this.ngW.a(a.nhg);
    com.tencent.mm.ui.base.h.cO(this, getString(r.j.mobile_code_sended));
    AppMethodBeat.o(128462);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(128464);
    com.tencent.mm.plugin.b.a.bkD(this.mTu);
    if (!this.ngW.a(a.nhe))
    {
      finish();
      AppMethodBeat.o(128464);
      return;
    }
    AppMethodBeat.o(128464);
  }
  
  public int getLayoutId()
  {
    return r.g.mobile_verify_ui;
  }
  
  protected final void hc(boolean paramBoolean)
  {
    AppMethodBeat.i(128467);
    Intent localIntent = new Intent(this, RegByMobileSetPwdUI.class);
    localIntent.putExtra("kintent_hint", getString(r.j.settings_modify_password_tip));
    localIntent.putExtra("kintent_cancelable", paramBoolean);
    startActivityForResult(localIntent, 0);
    AppMethodBeat.o(128467);
  }
  
  public void initView()
  {
    AppMethodBeat.i(128460);
    Log.d("MicroMsg.MobileVerifyUI", "init getintent mobile:" + this.fLC);
    this.ngJ = ((MMFormInputView)findViewById(r.f.bind_mcontact_verify_num));
    this.ngJ.setImeOption(5);
    this.ngJ.setInputType(3);
    this.mSy = this.ngJ.getContentEditText();
    this.ngK = ((TextView)findViewById(r.f.mobileverify_resend_bt));
    this.ngL = ((TextView)findViewById(r.f.mobileverify_counting_tv));
    this.mSz = ((TextView)findViewById(r.f.bind_mcontact_verify_hint));
    this.mSz.setText(this.fLC);
    this.fLC = PhoneFormater.pureNumber(this.fLC);
    this.ngK.setText(getString(r.j.mobileverify_resend));
    this.ngM = ((TextView)findViewById(r.f.bind_mcontact_verify_tip));
    this.jbJ = ((Button)findViewById(r.f.next_btn));
    this.ngN = ((ScrollView)findViewById(r.f.scroll));
    this.ngP = getResources().getStringArray(r.b.sms_content);
    Object localObject = getString(r.j.regbymobile_reg_input_verify_tip);
    this.ngM.setText(Html.fromHtml((String)localObject));
    localObject = new InputFilter()
    {
      public final CharSequence filter(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, Spanned paramAnonymousSpanned, int paramAnonymousInt3, int paramAnonymousInt4)
      {
        AppMethodBeat.i(128442);
        paramAnonymousCharSequence = Util.filterNumber(paramAnonymousCharSequence);
        AppMethodBeat.o(128442);
        return paramAnonymousCharSequence;
      }
    };
    this.ngL.setVisibility(0);
    this.ngL.setText(getResources().getQuantityString(r.h.mobileverify_send_code_tip, this.ngS, new Object[] { Integer.valueOf(this.ngS) }));
    bzG();
    this.ngQ = false;
    this.mSy.setFilters(new InputFilter[] { localObject });
    this.mSy.addTextChangedListener(new MMEditText.c(this.mSy, null, 12));
    this.jbJ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(128443);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/MobileVerifyUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        MobileVerifyUI.e(MobileVerifyUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileVerifyUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(128443);
      }
    });
    this.jbJ.setEnabled(false);
    this.mSy.setTextSize(15.0F);
    this.mSy.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(128444);
        if (Util.isNullOrNil(MobileVerifyUI.this.mSy.getText().toString()))
        {
          MobileVerifyUI.this.mSy.setTextSize(15.0F);
          MobileVerifyUI.this.mSy.setGravity(16);
        }
        while ((MobileVerifyUI.this.mSy.getText() != null) && (MobileVerifyUI.this.mSy.getText().toString().length() > 0))
        {
          MobileVerifyUI.this.jbJ.setEnabled(true);
          AppMethodBeat.o(128444);
          return;
          MobileVerifyUI.this.mSy.setTextSize(24.0F);
          MobileVerifyUI.this.mSy.setGravity(16);
        }
        MobileVerifyUI.this.jbJ.setEnabled(false);
        AppMethodBeat.o(128444);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.ngK.setOnClickListener(new View.OnClickListener()
    {
      private final int nha = 0;
      private final int nhb = 1;
      private final int nhc = 2;
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(128447);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/MobileVerifyUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = new m(MobileVerifyUI.this);
        paramAnonymousView.ODT = new q.f()
        {
          public final void onCreateMMMenu(com.tencent.mm.ui.base.o paramAnonymous2o)
          {
            AppMethodBeat.i(128445);
            paramAnonymous2o.d(0, MobileVerifyUI.this.getString(r.j.mobileverify_resend));
            if (com.tencent.mm.az.b.WD(MobileVerifyUI.this.fLC)) {
              paramAnonymous2o.d(1, MobileVerifyUI.this.getString(r.j.bind_mcontact_voice_verify_entrance));
            }
            if ((MobileVerifyUI.f(MobileVerifyUI.this) == 2) && (MobileVerifyUI.this.ngU)) {
              paramAnonymous2o.d(2, MobileVerifyUI.this.getString(r.j.regbymobile_reg_qq_reg));
            }
            AppMethodBeat.o(128445);
          }
        };
        paramAnonymousView.ODU = new q.g()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(128446);
            switch (paramAnonymous2MenuItem.getItemId())
            {
            default: 
              AppMethodBeat.o(128446);
              return;
            case 0: 
              MobileVerifyUI.g(MobileVerifyUI.this);
              AppMethodBeat.o(128446);
              return;
            }
            MobileVerifyUI.this.hideVKB();
            if (MobileVerifyUI.f(MobileVerifyUI.this) == 2) {
              com.tencent.mm.plugin.b.a.bkD("R200_500");
            }
            for (;;)
            {
              paramAnonymous2MenuItem = new Intent(MobileVerifyUI.this, RegByMobileVoiceVerifyUI.class);
              Object localObject = new Bundle();
              ((Bundle)localObject).putString("bindmcontact_mobile", MobileVerifyUI.this.fLC);
              ((Bundle)localObject).putInt("voice_verify_type", MobileVerifyUI.h(MobileVerifyUI.this));
              paramAnonymous2MenuItem.putExtras((Bundle)localObject);
              localObject = MobileVerifyUI.this;
              paramAnonymous2MenuItem = new com.tencent.mm.hellhoundlib.b.a().bm(paramAnonymous2MenuItem);
              com.tencent.mm.hellhoundlib.a.a.b(localObject, paramAnonymous2MenuItem.aFh(), "com/tencent/mm/plugin/account/ui/MobileVerifyUI$5$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((MobileVerifyUI)localObject).startActivity((Intent)paramAnonymous2MenuItem.sf(0));
              com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/account/ui/MobileVerifyUI$5$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              break;
              if (MobileVerifyUI.f(MobileVerifyUI.this) == 3) {
                com.tencent.mm.plugin.b.a.bkD("F200_300");
              }
            }
          }
        };
        paramAnonymousView.hYu();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileVerifyUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(128447);
      }
    });
    this.ngK.setEnabled(false);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(128448);
        MobileVerifyUI.i(MobileVerifyUI.this);
        AppMethodBeat.o(128448);
        return true;
      }
    });
    this.mSy.setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(128449);
        if ((paramAnonymousInt == 6) || (paramAnonymousInt == 5))
        {
          MobileVerifyUI.e(MobileVerifyUI.this);
          AppMethodBeat.o(128449);
          return true;
        }
        AppMethodBeat.o(128449);
        return false;
      }
    });
    this.mSy.setOnKeyListener(new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(128450);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        localb.sg(paramAnonymousInt);
        localb.bn(paramAnonymousKeyEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/MobileVerifyUI$8", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.aFi());
        if ((66 == paramAnonymousInt) && (paramAnonymousKeyEvent.getAction() == 0))
        {
          MobileVerifyUI.e(MobileVerifyUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/account/ui/MobileVerifyUI$8", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
          AppMethodBeat.o(128450);
          return true;
        }
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/account/ui/MobileVerifyUI$8", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
        AppMethodBeat.o(128450);
        return false;
      }
    });
    AppMethodBeat.o(128460);
  }
  
  protected final boolean n(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(128466);
    Object localObject = com.tencent.mm.h.a.Kb(paramString);
    if (localObject != null)
    {
      ((com.tencent.mm.h.a)localObject).a(this, null, null);
      AppMethodBeat.o(128466);
      return true;
    }
    if (paramInt1 == 4) {}
    int i;
    switch (paramInt2)
    {
    default: 
      switch (paramInt2)
      {
      default: 
        i = 0;
      }
      break;
    }
    while (i != 0)
    {
      AppMethodBeat.o(128466);
      return true;
      if (com.tencent.mm.kernel.h.aGY().bih() == 5)
      {
        com.tencent.mm.ui.base.h.p(this, r.j.net_warn_server_down_tip, r.j.net_warn_server_down);
        AppMethodBeat.o(128466);
        return true;
      }
      y.dw(this);
      AppMethodBeat.o(128466);
      return true;
      Toast.makeText(this, r.j.bind_mcontact_err_freq_limit, 0).show();
      i = 1;
      continue;
      Toast.makeText(this, r.j.bind_mcontact_err_binded, 0).show();
      i = 1;
      continue;
      Toast.makeText(this, r.j.bind_mcontact_err_format, 0).show();
      i = 1;
      continue;
      Toast.makeText(this, r.j.bind_mcontact_err_unbinded_notbinded, 0).show();
      i = 1;
      continue;
      com.tencent.mm.ui.base.h.d(this, getString(r.j.bind_mcontact_verify_error), "", new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      i = 1;
      continue;
      com.tencent.mm.ui.base.h.a(this, r.j.bind_mcontact_verify_err_time_out_content, r.j.bind_mcontact_verify_tip, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      i = 1;
      continue;
      com.tencent.mm.kernel.b.aGF();
      AppCompatActivity localAppCompatActivity = getContext();
      com.tencent.mm.kernel.h.aHE();
      if (TextUtils.isEmpty(com.tencent.mm.kernel.b.aGs())) {}
      for (localObject = com.tencent.mm.ci.a.ba(getContext(), r.j.main_err_another_place);; localObject = com.tencent.mm.kernel.b.aGs())
      {
        com.tencent.mm.ui.base.h.a(localAppCompatActivity, (String)localObject, getContext().getString(r.j.app_tip), new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        }, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
        });
        i = 1;
        break;
        com.tencent.mm.kernel.h.aHE();
      }
    }
    paramString = new ad(paramInt1, paramInt2, paramString);
    if (this.ndW.a(this, paramString))
    {
      AppMethodBeat.o(128466);
      return true;
    }
    AppMethodBeat.o(128466);
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128454);
    super.onCreate(paramBundle);
    this.ngf = getIntent().getIntExtra("key_reg_style", 1);
    this.nfI = getIntent().getIntExtra("mobile_verify_purpose", 0);
    this.ngX = getIntent().getStringExtra("MicroMsg.MobileVerifyUIIntent_sms_code");
    this.nfX = getIntent().getStringExtra("kintent_password");
    this.nickName = getIntent().getStringExtra("kintent_nickname");
    this.ngR = Boolean.valueOf(getIntent().getBooleanExtra("kintent_hasavatar", false));
    this.neP = getIntent().getBooleanExtra("from_deep_link", false);
    this.nfm = getIntent().getStringExtra("regsession_id");
    this.ngY = getIntent().getStringExtra("reg_3d_app_ticket");
    this.ngh = getIntent().getIntExtra("reg_3d_app_type", 0);
    switch (this.nfI)
    {
    default: 
      Log.e("MicroMsg.MobileVerifyUI", "wrong purpose %s", new Object[] { Integer.valueOf(this.nfI) });
      finish();
      AppMethodBeat.o(128454);
      return;
    case 2: 
      this.ngW = new p();
      if ((this.nfX != null) && (this.nfX.length() >= 8))
      {
        this.mam = 1;
        paramBundle = getString(r.j.bind_mcontact_title_verify);
        if ((d.RAG) || (BuildInfo.IS_FLAVOR_BLUE)) {
          paramBundle = getString(r.j.app_name) + com.tencent.mm.cj.h.kv(this);
        }
        setMMTitle(paramBundle);
        this.ngS = getIntent().getIntExtra("mobileverify_countdownsec", 30);
        this.ngT = getIntent().getBooleanExtra("mobileverify_fb", false);
        this.ngU = getIntent().getBooleanExtra("mobileverify_reg_qq", false);
        this.fLC = getIntent().getExtras().getString("bindmcontact_mobile");
        this.mTu = com.tencent.mm.plugin.b.a.bAt();
        initView();
        this.ngW.a(this);
        if (this.ngX == null) {
          break label478;
        }
        this.mSy.setText(this.ngX);
        bzH();
      }
      break;
    }
    for (;;)
    {
      this.ndW = new com.tencent.mm.platformtools.b();
      AppMethodBeat.o(128454);
      return;
      this.mam = 4;
      break;
      this.ngW = new n(this.nfI);
      break;
      this.ngW = new o();
      break;
      label478:
      if (this.nfI == 5) {
        this.ngW.a(a.nhg);
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128455);
    if (this.ndW != null) {
      this.ndW.close();
    }
    super.onDestroy();
    AppMethodBeat.o(128455);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(128463);
    if (paramInt == 4)
    {
      goBack();
      AppMethodBeat.o(128463);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(128463);
    return bool;
  }
  
  public void onKeyboardStateChanged()
  {
    AppMethodBeat.i(128459);
    if (keyboardState() == 1)
    {
      this.ngN.scrollTo(0, this.ngN.getChildAt(0).getMeasuredHeight() - this.ngN.getMeasuredHeight());
      AppMethodBeat.o(128459);
      return;
    }
    this.ngN.scrollTo(0, 0);
    AppMethodBeat.o(128459);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(128465);
    super.onNewIntent(paramIntent);
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getStringExtra("nofification_type");
      Log.d("MicroMsg.MobileVerifyUI", "[oneliang][notificationType]%s", new Object[] { paramIntent });
      if ((paramIntent != null) && (paramIntent.equals("no_reg_notification"))) {
        bzI();
      }
    }
    AppMethodBeat.o(128465);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(128457);
    super.onPause();
    this.ngW.stop();
    AppMethodBeat.o(128457);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(128456);
    super.onResume();
    this.ngW.start();
    AppMethodBeat.o(128456);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected static enum a
  {
    static
    {
      AppMethodBeat.i(128453);
      nhe = new a("GoBack", 0);
      nhf = new a("GoNext", 1);
      nhg = new a("DoSend", 2);
      nhh = new a("DoProcessSMS", 3);
      nhi = new a[] { nhe, nhf, nhg, nhh };
      AppMethodBeat.o(128453);
    }
    
    private a() {}
  }
  
  public static abstract interface b
  {
    public abstract void a(MobileVerifyUI paramMobileVerifyUI);
    
    public abstract boolean a(MobileVerifyUI.a parama);
    
    public abstract void start();
    
    public abstract void stop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileVerifyUI
 * JD-Core Version:    0.7.0.1
 */