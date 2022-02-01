package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.platformtools.b;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ba;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.MMEditText.c;
import java.util.Timer;
import java.util.TimerTask;

public class MobileVerifyUI
  extends MMActivity
{
  String bVF;
  protected String dzn;
  protected ProgressDialog fMu = null;
  protected Button fQh;
  int imo;
  String jaZ;
  protected EditText jah;
  protected TextView jai;
  SecurityImage jct = null;
  protected boolean jlT = false;
  private b jlc;
  private int jmM;
  String jmZ;
  protected String jmq;
  protected MMFormInputView jnM;
  protected TextView jnN;
  protected TextView jnO;
  protected TextView jnP;
  protected ScrollView jnQ;
  private long jnR = 0L;
  private boolean jnS = false;
  private String[] jnT;
  private boolean jnU = false;
  Boolean jnV;
  private int jnW = 30;
  protected boolean jnX = false;
  protected boolean jnY = false;
  protected int jnZ = -1;
  int jnh;
  protected int jnk;
  private b joa;
  String job;
  protected String joc;
  private Timer mTimer;
  
  private void aUi()
  {
    AppMethodBeat.i(128458);
    if (!this.jnS)
    {
      this.mTimer = new Timer();
      this.jnS = true;
      this.jnR = this.jnW;
      TimerTask local1 = new TimerTask()
      {
        public final void run()
        {
          AppMethodBeat.i(128441);
          MobileVerifyUI.this.jnO.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(128440);
              MobileVerifyUI.b(MobileVerifyUI.this);
              if (MobileVerifyUI.c(MobileVerifyUI.this) >= 0L)
              {
                MobileVerifyUI.this.jnO.setText(MobileVerifyUI.this.getResources().getQuantityString(2131623957, (int)MobileVerifyUI.c(MobileVerifyUI.this), new Object[] { Integer.valueOf((int)MobileVerifyUI.c(MobileVerifyUI.this)) }));
                AppMethodBeat.o(128440);
                return;
              }
              MobileVerifyUI.this.jnO.setVisibility(8);
              MobileVerifyUI.this.jnN.setVisibility(0);
              MobileVerifyUI.d(MobileVerifyUI.this);
              MobileVerifyUI.this.jnN.setEnabled(true);
              MobileVerifyUI.this.jnN.setText(MobileVerifyUI.this.getString(2131761300));
              AppMethodBeat.o(128440);
            }
          });
          AppMethodBeat.o(128441);
        }
      };
      this.mTimer.schedule(local1, 1000L, 1000L);
    }
    AppMethodBeat.o(128458);
  }
  
  private void aUj()
  {
    AppMethodBeat.i(128461);
    hideVKB();
    if (this.jah.getText().toString().trim().equals(""))
    {
      h.l(this, 2131756515, 2131755906);
      AppMethodBeat.o(128461);
      return;
    }
    this.joa.a(a.jok);
    AppMethodBeat.o(128461);
  }
  
  private void aUk()
  {
    AppMethodBeat.i(128462);
    this.jnU = false;
    this.jnN.setEnabled(false);
    this.jnO.setVisibility(0);
    this.jnO.setText(getResources().getQuantityString(2131623957, this.jnW, new Object[] { Integer.valueOf(this.jnW) }));
    this.jnN.setVisibility(8);
    aUi();
    this.joa.a(a.jol);
    h.cl(this, getString(2131761248));
    AppMethodBeat.o(128462);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(128464);
    com.tencent.mm.plugin.b.a.Ma(this.jaZ);
    if (!this.joa.a(a.joj))
    {
      finish();
      AppMethodBeat.o(128464);
      return;
    }
    AppMethodBeat.o(128464);
  }
  
  protected final void fw(boolean paramBoolean)
  {
    AppMethodBeat.i(128467);
    Intent localIntent = new Intent(this, RegByMobileSetPwdUI.class);
    localIntent.putExtra("kintent_hint", getString(2131763302));
    localIntent.putExtra("kintent_cancelable", paramBoolean);
    startActivityForResult(localIntent, 0);
    AppMethodBeat.o(128467);
  }
  
  public int getLayoutId()
  {
    return 2131494936;
  }
  
  public void initView()
  {
    AppMethodBeat.i(128460);
    ad.d("MicroMsg.MobileVerifyUI", "init getintent mobile:" + this.dzn);
    this.jnM = ((MMFormInputView)findViewById(2131297252));
    this.jnM.setImeOption(5);
    this.jnM.setInputType(3);
    this.jah = this.jnM.getContentEditText();
    this.jnN = ((TextView)findViewById(2131302417));
    this.jnO = ((TextView)findViewById(2131302416));
    this.jai = ((TextView)findViewById(2131297250));
    this.jai.setText(this.dzn);
    this.dzn = ba.aQI(this.dzn);
    this.jnN.setText(getString(2131761301));
    this.jnP = ((TextView)findViewById(2131297253));
    this.fQh = ((Button)findViewById(2131302852));
    this.jnQ = ((ScrollView)findViewById(2131304367));
    this.jnT = getResources().getStringArray(2130903092);
    Object localObject = getString(2131762327);
    this.jnP.setText(Html.fromHtml((String)localObject));
    localObject = new MobileVerifyUI.5(this);
    this.jnO.setVisibility(0);
    this.jnO.setText(getResources().getQuantityString(2131623957, this.jnW, new Object[] { Integer.valueOf(this.jnW) }));
    aUi();
    this.jnU = false;
    this.jah.setFilters(new InputFilter[] { localObject });
    this.jah.addTextChangedListener(new MMEditText.c(this.jah, null, 12));
    this.fQh.setOnClickListener(new MobileVerifyUI.6(this));
    this.fQh.setEnabled(false);
    this.jah.setTextSize(15.0F);
    this.jah.addTextChangedListener(new MobileVerifyUI.7(this));
    this.jnN.setOnClickListener(new MobileVerifyUI.8(this));
    this.jnN.setEnabled(false);
    setBackBtn(new MobileVerifyUI.9(this));
    this.jah.setOnEditorActionListener(new MobileVerifyUI.10(this));
    this.jah.setOnKeyListener(new MobileVerifyUI.11(this));
    AppMethodBeat.o(128460);
  }
  
  protected final boolean n(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(128466);
    Object localObject = com.tencent.mm.h.a.uz(paramString);
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
      if (com.tencent.mm.kernel.g.aiU().aEN() == 5)
      {
        h.l(this, 2131761537, 2131761536);
        AppMethodBeat.o(128466);
        return true;
      }
      y.dc(this);
      AppMethodBeat.o(128466);
      return true;
      Toast.makeText(this, 2131756462, 0).show();
      i = 1;
      continue;
      Toast.makeText(this, 2131756459, 0).show();
      i = 1;
      continue;
      Toast.makeText(this, 2131756461, 0).show();
      i = 1;
      continue;
      Toast.makeText(this, 2131756464, 0).show();
      i = 1;
      continue;
      h.d(this, getString(2131756510), "", new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      i = 1;
      continue;
      h.a(this, 2131756508, 2131756514, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      i = 1;
      continue;
      com.tencent.mm.kernel.a.hold();
      AppCompatActivity localAppCompatActivity = getContext();
      com.tencent.mm.kernel.g.ajA();
      if (TextUtils.isEmpty(com.tencent.mm.kernel.a.ais())) {}
      for (localObject = com.tencent.mm.cc.a.az(getContext(), 2131761063);; localObject = com.tencent.mm.kernel.a.ais())
      {
        h.a(localAppCompatActivity, (String)localObject, getContext().getString(2131755906), new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        }, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
        });
        i = 1;
        break;
        com.tencent.mm.kernel.g.ajA();
      }
    }
    paramString = new ae(paramInt1, paramInt2, paramString);
    if (this.jlc.a(this, paramString))
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
    this.jnh = getIntent().getIntExtra("key_reg_style", 1);
    this.jmM = getIntent().getIntExtra("mobile_verify_purpose", 0);
    this.job = getIntent().getStringExtra("MicroMsg.MobileVerifyUIIntent_sms_code");
    this.jmZ = getIntent().getStringExtra("kintent_password");
    this.bVF = getIntent().getStringExtra("kintent_nickname");
    this.jnV = Boolean.valueOf(getIntent().getBooleanExtra("kintent_hasavatar", false));
    this.jlT = getIntent().getBooleanExtra("from_deep_link", false);
    this.jmq = getIntent().getStringExtra("regsession_id");
    this.joc = getIntent().getStringExtra("reg_3d_app_ticket");
    this.jnk = getIntent().getIntExtra("reg_3d_app_type", 0);
    switch (this.jmM)
    {
    default: 
      ad.e("MicroMsg.MobileVerifyUI", "wrong purpose %s", new Object[] { Integer.valueOf(this.jmM) });
      finish();
      AppMethodBeat.o(128454);
      return;
    case 2: 
      this.joa = new o();
      if ((this.jmZ != null) && (this.jmZ.length() >= 8))
      {
        this.imo = 1;
        paramBundle = getString(2131756490);
        if ((d.Fnm) || (i.IS_FLAVOR_BLUE)) {
          paramBundle = getString(2131755822) + com.tencent.mm.cd.g.is(this);
        }
        setMMTitle(paramBundle);
        this.jnW = getIntent().getIntExtra("mobileverify_countdownsec", 30);
        this.jnX = getIntent().getBooleanExtra("mobileverify_fb", false);
        this.jnY = getIntent().getBooleanExtra("mobileverify_reg_qq", false);
        this.dzn = getIntent().getExtras().getString("bindmcontact_mobile");
        this.jaZ = com.tencent.mm.plugin.b.a.Mp();
        initView();
        this.joa.a(this);
        if (this.job == null) {
          break label478;
        }
        this.jah.setText(this.job);
        aUj();
      }
      break;
    }
    for (;;)
    {
      this.jlc = new b();
      AppMethodBeat.o(128454);
      return;
      this.imo = 4;
      break;
      this.joa = new m(this.jmM);
      break;
      this.joa = new n();
      break;
      label478:
      if (this.jmM == 5) {
        this.joa.a(a.jol);
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128455);
    if (this.jlc != null) {
      this.jlc.close();
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
      this.jnQ.scrollTo(0, this.jnQ.getChildAt(0).getMeasuredHeight() - this.jnQ.getMeasuredHeight());
      AppMethodBeat.o(128459);
      return;
    }
    this.jnQ.scrollTo(0, 0);
    AppMethodBeat.o(128459);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(128465);
    super.onNewIntent(paramIntent);
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getStringExtra("nofification_type");
      ad.d("MicroMsg.MobileVerifyUI", "[oneliang][notificationType]%s", new Object[] { paramIntent });
      if ((paramIntent != null) && (paramIntent.equals("no_reg_notification"))) {
        aUk();
      }
    }
    AppMethodBeat.o(128465);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(128457);
    super.onPause();
    this.joa.stop();
    AppMethodBeat.o(128457);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(128456);
    super.onResume();
    this.joa.start();
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
      joj = new a("GoBack", 0);
      jok = new a("GoNext", 1);
      jol = new a("DoSend", 2);
      jom = new a("DoProcessSMS", 3);
      jon = new a[] { joj, jok, jol, jom };
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileVerifyUI
 * JD-Core Version:    0.7.0.1
 */