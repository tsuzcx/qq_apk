package com.tencent.mm.plugin.account.ui;

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
import com.tencent.mm.ce.j;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.platformtools.v;
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
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.widget.MMEditText.c;

public class MobileVerifyUI
  extends MMActivity
{
  private MTimerHandler eln;
  protected String hRk;
  protected Button lDJ;
  protected ProgressDialog lzP = null;
  String nickName;
  int oTc;
  protected EditText pPd;
  protected TextView pPe;
  String pQb;
  SecurityImage pRw = null;
  private com.tencent.mm.platformtools.b pZq;
  protected boolean qbB = false;
  private int qcR;
  protected String qcu;
  protected MMFormInputView qdR;
  protected TextView qdS;
  protected TextView qdT;
  protected TextView qdU;
  protected ScrollView qdV;
  private long qdW = 0L;
  private String[] qdX;
  private boolean qdY = false;
  Boolean qdZ;
  String qdg;
  int qdn;
  protected int qdp;
  private int qea = 30;
  protected boolean qeb = false;
  protected boolean qec = false;
  protected int qed = -1;
  private b qee;
  String qef;
  protected String qeg;
  
  private void bYv()
  {
    AppMethodBeat.i(128458);
    if (this.eln == null)
    {
      this.qdW = this.qea;
      this.eln = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(304923);
          MobileVerifyUI.b(MobileVerifyUI.this);
          if (MobileVerifyUI.c(MobileVerifyUI.this) >= 0L) {
            MobileVerifyUI.this.qdT.setText(MobileVerifyUI.this.getResources().getQuantityString(r.h.mobileverify_send_code_tip, (int)MobileVerifyUI.c(MobileVerifyUI.this), new Object[] { Integer.valueOf((int)MobileVerifyUI.c(MobileVerifyUI.this)) }));
          }
          for (;;)
          {
            AppMethodBeat.o(304923);
            return true;
            MobileVerifyUI.this.qdT.setVisibility(8);
            MobileVerifyUI.this.qdS.setVisibility(0);
            MobileVerifyUI.d(MobileVerifyUI.this);
            MobileVerifyUI.this.qdS.setEnabled(true);
            MobileVerifyUI.this.qdS.setText(MobileVerifyUI.this.getString(r.j.mobileverify_nocode));
          }
        }
      }, true);
      this.eln.startTimer(1000L, 1000L);
    }
    AppMethodBeat.o(128458);
  }
  
  private void bYw()
  {
    AppMethodBeat.i(128461);
    hideVKB();
    if (this.pPd.getText().toString().trim().equals(""))
    {
      k.s(this, r.j.bind_mcontact_verifynull, r.j.app_tip);
      AppMethodBeat.o(128461);
      return;
    }
    this.qee.a(a.qen);
    AppMethodBeat.o(128461);
  }
  
  private void bYx()
  {
    AppMethodBeat.i(128462);
    this.qdY = false;
    this.qdS.setEnabled(false);
    this.qdT.setVisibility(0);
    this.qdT.setText(getResources().getQuantityString(r.h.mobileverify_send_code_tip, this.qea, new Object[] { Integer.valueOf(this.qea) }));
    this.qdS.setVisibility(8);
    bYv();
    this.qee.a(a.qeo);
    k.cZ(this, getString(r.j.mobile_code_sended));
    AppMethodBeat.o(128462);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(128464);
    com.tencent.mm.plugin.b.a.TA(this.pQb);
    if (!this.qee.a(a.qem))
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
  
  protected final void hR(boolean paramBoolean)
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
    Log.d("MicroMsg.MobileVerifyUI", "init getintent mobile:" + this.hRk);
    this.qdR = ((MMFormInputView)findViewById(r.f.bind_mcontact_verify_num));
    this.qdR.setImeOption(5);
    this.qdR.setInputType(3);
    this.pPd = this.qdR.getContentEditText();
    this.qdS = ((TextView)findViewById(r.f.mobileverify_resend_bt));
    this.qdT = ((TextView)findViewById(r.f.mobileverify_counting_tv));
    this.pPe = ((TextView)findViewById(r.f.bind_mcontact_verify_hint));
    this.pPe.setText(this.hRk);
    this.hRk = PhoneFormater.pureNumber(this.hRk);
    this.qdS.setText(getString(r.j.mobileverify_resend));
    this.qdU = ((TextView)findViewById(r.f.bind_mcontact_verify_tip));
    this.lDJ = ((Button)findViewById(r.f.next_btn));
    this.qdV = ((ScrollView)findViewById(r.f.scroll));
    this.qdX = getResources().getStringArray(r.b.sms_content);
    Object localObject = getString(r.j.regbymobile_reg_input_verify_tip);
    this.qdU.setText(Html.fromHtml((String)localObject));
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
    this.qdT.setVisibility(0);
    this.qdT.setText(getResources().getQuantityString(r.h.mobileverify_send_code_tip, this.qea, new Object[] { Integer.valueOf(this.qea) }));
    bYv();
    this.qdY = false;
    this.pPd.setFilters(new InputFilter[] { localObject });
    this.pPd.addTextChangedListener(new MMEditText.c(this.pPd, null, 12));
    this.lDJ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(128443);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/MobileVerifyUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        MobileVerifyUI.e(MobileVerifyUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileVerifyUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(128443);
      }
    });
    this.lDJ.setEnabled(false);
    this.pPd.setTextSize(15.0F);
    this.pPd.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(128444);
        if (Util.isNullOrNil(MobileVerifyUI.this.pPd.getText().toString()))
        {
          MobileVerifyUI.this.pPd.setTextSize(15.0F);
          MobileVerifyUI.this.pPd.setGravity(16);
        }
        while ((MobileVerifyUI.this.pPd.getText() != null) && (MobileVerifyUI.this.pPd.getText().toString().length() > 0))
        {
          MobileVerifyUI.this.lDJ.setEnabled(true);
          AppMethodBeat.o(128444);
          return;
          MobileVerifyUI.this.pPd.setTextSize(24.0F);
          MobileVerifyUI.this.pPd.setGravity(16);
        }
        MobileVerifyUI.this.lDJ.setEnabled(false);
        AppMethodBeat.o(128444);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.qdS.setOnClickListener(new View.OnClickListener()
    {
      private final int qei = 0;
      private final int qej = 1;
      private final int qek = 2;
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(128447);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/MobileVerifyUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        paramAnonymousView = new l(MobileVerifyUI.this);
        paramAnonymousView.Vtg = new u.g()
        {
          public final void onCreateMMMenu(com.tencent.mm.ui.base.s paramAnonymous2s)
          {
            AppMethodBeat.i(128445);
            paramAnonymous2s.c(0, MobileVerifyUI.this.getString(r.j.mobileverify_resend));
            if (com.tencent.mm.au.b.OC(MobileVerifyUI.this.hRk)) {
              paramAnonymous2s.c(1, MobileVerifyUI.this.getString(r.j.bind_mcontact_voice_verify_entrance));
            }
            if ((MobileVerifyUI.f(MobileVerifyUI.this) == 2) && (MobileVerifyUI.this.qec)) {
              paramAnonymous2s.c(2, MobileVerifyUI.this.getString(r.j.regbymobile_reg_qq_reg));
            }
            AppMethodBeat.o(128445);
          }
        };
        paramAnonymousView.GAC = new u.i()
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
              com.tencent.mm.plugin.b.a.TA("R200_500");
            }
            for (;;)
            {
              paramAnonymous2MenuItem = new Intent(MobileVerifyUI.this, RegByMobileVoiceVerifyUI.class);
              Object localObject = new Bundle();
              ((Bundle)localObject).putString("bindmcontact_mobile", MobileVerifyUI.this.hRk);
              ((Bundle)localObject).putInt("voice_verify_type", MobileVerifyUI.h(MobileVerifyUI.this));
              paramAnonymous2MenuItem.putExtras((Bundle)localObject);
              localObject = MobileVerifyUI.this;
              paramAnonymous2MenuItem = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymous2MenuItem);
              com.tencent.mm.hellhoundlib.a.a.b(localObject, paramAnonymous2MenuItem.aYi(), "com/tencent/mm/plugin/account/ui/MobileVerifyUI$5$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((MobileVerifyUI)localObject).startActivity((Intent)paramAnonymous2MenuItem.sb(0));
              com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/account/ui/MobileVerifyUI$5$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              break;
              if (MobileVerifyUI.f(MobileVerifyUI.this) == 3) {
                com.tencent.mm.plugin.b.a.TA("F200_300");
              }
            }
          }
        };
        paramAnonymousView.jDd();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileVerifyUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(128447);
      }
    });
    this.qdS.setEnabled(false);
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
    this.pPd.setOnEditorActionListener(new TextView.OnEditorActionListener()
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
    this.pPd.setOnKeyListener(new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(128450);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        localb.sc(paramAnonymousInt);
        localb.cH(paramAnonymousKeyEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/MobileVerifyUI$8", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.aYj());
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
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128454);
    super.onCreate(paramBundle);
    this.qdn = getIntent().getIntExtra("key_reg_style", 1);
    this.qcR = getIntent().getIntExtra("mobile_verify_purpose", 0);
    this.qef = getIntent().getStringExtra("MicroMsg.MobileVerifyUIIntent_sms_code");
    this.qdg = getIntent().getStringExtra("kintent_password");
    this.nickName = getIntent().getStringExtra("kintent_nickname");
    this.qdZ = Boolean.valueOf(getIntent().getBooleanExtra("kintent_hasavatar", false));
    this.qbB = getIntent().getBooleanExtra("from_deep_link", false);
    this.qcu = getIntent().getStringExtra("regsession_id");
    this.qeg = getIntent().getStringExtra("reg_3d_app_ticket");
    this.qdp = getIntent().getIntExtra("reg_3d_app_type", 0);
    switch (this.qcR)
    {
    default: 
      Log.e("MicroMsg.MobileVerifyUI", "wrong purpose %s", new Object[] { Integer.valueOf(this.qcR) });
      finish();
      AppMethodBeat.o(128454);
      return;
    case 2: 
      this.qee = new p();
      if ((this.qdg != null) && (this.qdg.length() >= 8))
      {
        this.oTc = 1;
        paramBundle = getString(r.j.bind_mcontact_title_verify);
        if ((d.Yxk) || (BuildInfo.IS_FLAVOR_BLUE)) {
          paramBundle = getString(r.j.app_name) + j.mx(this);
        }
        setMMTitle(paramBundle);
        this.qea = getIntent().getIntExtra("mobileverify_countdownsec", 30);
        this.qeb = getIntent().getBooleanExtra("mobileverify_fb", false);
        this.qec = getIntent().getBooleanExtra("mobileverify_reg_qq", false);
        this.hRk = getIntent().getExtras().getString("bindmcontact_mobile");
        this.pQb = com.tencent.mm.plugin.b.a.chY();
        initView();
        this.qee.a(this);
        if (this.qef == null) {
          break label478;
        }
        this.pPd.setText(this.qef);
        bYw();
      }
      break;
    }
    for (;;)
    {
      this.pZq = new com.tencent.mm.platformtools.b();
      AppMethodBeat.o(128454);
      return;
      this.oTc = 4;
      break;
      this.qee = new n(this.qcR);
      break;
      this.qee = new o();
      break;
      label478:
      if (this.qcR == 5) {
        this.qee.a(a.qeo);
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128455);
    if (this.pZq != null) {
      this.pZq.close();
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
      this.qdV.scrollTo(0, this.qdV.getChildAt(0).getMeasuredHeight() - this.qdV.getMeasuredHeight());
      AppMethodBeat.o(128459);
      return;
    }
    this.qdV.scrollTo(0, 0);
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
        bYx();
      }
    }
    AppMethodBeat.o(128465);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(128457);
    super.onPause();
    this.qee.stop();
    AppMethodBeat.o(128457);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(128456);
    super.onResume();
    this.qee.start();
    AppMethodBeat.o(128456);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected final boolean p(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(128466);
    Object localObject = com.tencent.mm.broadcast.a.CH(paramString);
    if (localObject != null)
    {
      ((com.tencent.mm.broadcast.a)localObject).a(this, null, null);
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
      if (h.aZW().bFQ() == 5)
      {
        k.s(this, r.j.net_warn_server_down_tip, r.j.net_warn_server_down);
        AppMethodBeat.o(128466);
        return true;
      }
      v.ei(this);
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
      k.d(this, getString(r.j.bind_mcontact_verify_error), "", new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      i = 1;
      continue;
      k.a(this, r.j.bind_mcontact_verify_err_time_out_content, r.j.bind_mcontact_verify_tip, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      i = 1;
      continue;
      com.tencent.mm.kernel.b.aZH();
      AppCompatActivity localAppCompatActivity = getContext();
      h.baC();
      if (TextUtils.isEmpty(com.tencent.mm.kernel.b.aZu())) {}
      for (localObject = com.tencent.mm.cd.a.bt(getContext(), r.j.main_err_another_place);; localObject = com.tencent.mm.kernel.b.aZu())
      {
        k.a(localAppCompatActivity, (String)localObject, getContext().getString(r.j.app_tip), new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        }, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
        });
        i = 1;
        break;
        h.baC();
      }
    }
    paramString = new aa(paramInt1, paramInt2, paramString);
    if (this.pZq.a(this, paramString))
    {
      AppMethodBeat.o(128466);
      return true;
    }
    AppMethodBeat.o(128466);
    return false;
  }
  
  protected static enum a
  {
    static
    {
      AppMethodBeat.i(128453);
      qem = new a("GoBack", 0);
      qen = new a("GoNext", 1);
      qeo = new a("DoSend", 2);
      qep = new a("DoProcessSMS", 3);
      qeq = new a[] { qem, qen, qeo, qep };
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileVerifyUI
 * JD-Core Version:    0.7.0.1
 */