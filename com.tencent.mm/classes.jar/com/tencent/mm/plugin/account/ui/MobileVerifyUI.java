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
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.ad;
import com.tencent.mm.platformtools.b;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.az;
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
  String bLs;
  protected String dnz;
  protected ProgressDialog fts = null;
  protected Button fwU;
  int hSX;
  protected EditText iGY;
  protected TextView iGZ;
  String iHQ;
  SecurityImage iJk = null;
  private b iRU;
  protected boolean iSL = false;
  private int iTE;
  String iTR;
  int iTZ;
  protected String iTi;
  protected MMFormInputView iUD;
  protected TextView iUE;
  protected TextView iUF;
  protected TextView iUG;
  protected ScrollView iUH;
  private long iUI = 0L;
  private boolean iUJ = false;
  private String[] iUK;
  private boolean iUL = false;
  Boolean iUM;
  private int iUN = 30;
  protected boolean iUO = false;
  protected boolean iUP = false;
  protected int iUQ = -1;
  private b iUR;
  String iUS;
  protected String iUT;
  protected int iUb;
  private Timer mTimer;
  
  private void aQW()
  {
    AppMethodBeat.i(128458);
    if (!this.iUJ)
    {
      this.mTimer = new Timer();
      this.iUJ = true;
      this.iUI = this.iUN;
      TimerTask local1 = new TimerTask()
      {
        public final void run()
        {
          AppMethodBeat.i(128441);
          MobileVerifyUI.this.iUF.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(128440);
              MobileVerifyUI.b(MobileVerifyUI.this);
              if (MobileVerifyUI.c(MobileVerifyUI.this) >= 0L)
              {
                MobileVerifyUI.this.iUF.setText(MobileVerifyUI.this.getResources().getQuantityString(2131623957, (int)MobileVerifyUI.c(MobileVerifyUI.this), new Object[] { Integer.valueOf((int)MobileVerifyUI.c(MobileVerifyUI.this)) }));
                AppMethodBeat.o(128440);
                return;
              }
              MobileVerifyUI.this.iUF.setVisibility(8);
              MobileVerifyUI.this.iUE.setVisibility(0);
              MobileVerifyUI.d(MobileVerifyUI.this);
              MobileVerifyUI.this.iUE.setEnabled(true);
              MobileVerifyUI.this.iUE.setText(MobileVerifyUI.this.getString(2131761300));
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
  
  private void aQX()
  {
    AppMethodBeat.i(128461);
    hideVKB();
    if (this.iGY.getText().toString().trim().equals(""))
    {
      h.l(this, 2131756515, 2131755906);
      AppMethodBeat.o(128461);
      return;
    }
    this.iUR.a(a.iVb);
    AppMethodBeat.o(128461);
  }
  
  private void aQY()
  {
    AppMethodBeat.i(128462);
    this.iUL = false;
    this.iUE.setEnabled(false);
    this.iUF.setVisibility(0);
    this.iUF.setText(getResources().getQuantityString(2131623957, this.iUN, new Object[] { Integer.valueOf(this.iUN) }));
    this.iUE.setVisibility(8);
    aQW();
    this.iUR.a(a.iVc);
    h.cg(this, getString(2131761248));
    AppMethodBeat.o(128462);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(128464);
    com.tencent.mm.plugin.b.a.IL(this.iHQ);
    if (!this.iUR.a(a.iVa))
    {
      finish();
      AppMethodBeat.o(128464);
      return;
    }
    AppMethodBeat.o(128464);
  }
  
  protected final void fs(boolean paramBoolean)
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
    ac.d("MicroMsg.MobileVerifyUI", "init getintent mobile:" + this.dnz);
    this.iUD = ((MMFormInputView)findViewById(2131297252));
    this.iUD.setImeOption(5);
    this.iUD.setInputType(3);
    this.iGY = this.iUD.getContentEditText();
    this.iUE = ((TextView)findViewById(2131302417));
    this.iUF = ((TextView)findViewById(2131302416));
    this.iGZ = ((TextView)findViewById(2131297250));
    this.iGZ.setText(this.dnz);
    this.dnz = az.aLc(this.dnz);
    this.iUE.setText(getString(2131761301));
    this.iUG = ((TextView)findViewById(2131297253));
    this.fwU = ((Button)findViewById(2131302852));
    this.iUH = ((ScrollView)findViewById(2131304367));
    this.iUK = getResources().getStringArray(2130903092);
    Object localObject = getString(2131762327);
    this.iUG.setText(Html.fromHtml((String)localObject));
    localObject = new MobileVerifyUI.5(this);
    this.iUF.setVisibility(0);
    this.iUF.setText(getResources().getQuantityString(2131623957, this.iUN, new Object[] { Integer.valueOf(this.iUN) }));
    aQW();
    this.iUL = false;
    this.iGY.setFilters(new InputFilter[] { localObject });
    this.iGY.addTextChangedListener(new MMEditText.c(this.iGY, null, 12));
    this.fwU.setOnClickListener(new MobileVerifyUI.6(this));
    this.fwU.setEnabled(false);
    this.iGY.setTextSize(15.0F);
    this.iGY.addTextChangedListener(new MobileVerifyUI.7(this));
    this.iUE.setOnClickListener(new MobileVerifyUI.8(this));
    this.iUE.setEnabled(false);
    setBackBtn(new MobileVerifyUI.9(this));
    this.iGY.setOnEditorActionListener(new MobileVerifyUI.10(this));
    this.iGY.setOnKeyListener(new MobileVerifyUI.11(this));
    AppMethodBeat.o(128460);
  }
  
  protected final boolean n(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(128466);
    Object localObject = com.tencent.mm.h.a.rM(paramString);
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
      if (g.agi().aBK() == 5)
      {
        h.l(this, 2131761537, 2131761536);
        AppMethodBeat.o(128466);
        return true;
      }
      y.de(this);
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
      g.agP();
      if (TextUtils.isEmpty(com.tencent.mm.kernel.a.afG())) {}
      for (localObject = com.tencent.mm.cc.a.aw(getContext(), 2131761063);; localObject = com.tencent.mm.kernel.a.afG())
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
        g.agP();
      }
    }
    paramString = new ad(paramInt1, paramInt2, paramString);
    if (this.iRU.a(this, paramString))
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
    this.iTZ = getIntent().getIntExtra("key_reg_style", 1);
    this.iTE = getIntent().getIntExtra("mobile_verify_purpose", 0);
    this.iUS = getIntent().getStringExtra("MicroMsg.MobileVerifyUIIntent_sms_code");
    this.iTR = getIntent().getStringExtra("kintent_password");
    this.bLs = getIntent().getStringExtra("kintent_nickname");
    this.iUM = Boolean.valueOf(getIntent().getBooleanExtra("kintent_hasavatar", false));
    this.iSL = getIntent().getBooleanExtra("from_deep_link", false);
    this.iTi = getIntent().getStringExtra("regsession_id");
    this.iUT = getIntent().getStringExtra("reg_3d_app_ticket");
    this.iUb = getIntent().getIntExtra("reg_3d_app_type", 0);
    switch (this.iTE)
    {
    default: 
      ac.e("MicroMsg.MobileVerifyUI", "wrong purpose %s", new Object[] { Integer.valueOf(this.iTE) });
      finish();
      AppMethodBeat.o(128454);
      return;
    case 2: 
      this.iUR = new o();
      if ((this.iTR != null) && (this.iTR.length() >= 8))
      {
        this.hSX = 1;
        paramBundle = getString(2131756490);
        if (d.DIf) {
          paramBundle = getString(2131755822) + getString(2131755263);
        }
        setMMTitle(paramBundle);
        this.iUN = getIntent().getIntExtra("mobileverify_countdownsec", 30);
        this.iUO = getIntent().getBooleanExtra("mobileverify_fb", false);
        this.iUP = getIntent().getBooleanExtra("mobileverify_reg_qq", false);
        this.dnz = getIntent().getExtras().getString("bindmcontact_mobile");
        this.iHQ = com.tencent.mm.plugin.b.a.EL();
        initView();
        this.iUR.a(this);
        if (this.iUS == null) {
          break label475;
        }
        this.iGY.setText(this.iUS);
        aQX();
      }
      break;
    }
    for (;;)
    {
      this.iRU = new b();
      AppMethodBeat.o(128454);
      return;
      this.hSX = 4;
      break;
      this.iUR = new m(this.iTE);
      break;
      this.iUR = new n();
      break;
      label475:
      if (this.iTE == 5) {
        this.iUR.a(a.iVc);
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128455);
    if (this.iRU != null) {
      this.iRU.close();
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
      this.iUH.scrollTo(0, this.iUH.getChildAt(0).getMeasuredHeight() - this.iUH.getMeasuredHeight());
      AppMethodBeat.o(128459);
      return;
    }
    this.iUH.scrollTo(0, 0);
    AppMethodBeat.o(128459);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(128465);
    super.onNewIntent(paramIntent);
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getStringExtra("nofification_type");
      ac.d("MicroMsg.MobileVerifyUI", "[oneliang][notificationType]%s", new Object[] { paramIntent });
      if ((paramIntent != null) && (paramIntent.equals("no_reg_notification"))) {
        aQY();
      }
    }
    AppMethodBeat.o(128465);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(128457);
    super.onPause();
    this.iUR.stop();
    AppMethodBeat.o(128457);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(128456);
    super.onResume();
    this.iUR.start();
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
      iVa = new a("GoBack", 0);
      iVb = new a("GoNext", 1);
      iVc = new a("DoSend", 2);
      iVd = new a("DoProcessSMS", 3);
      iVe = new a[] { iVa, iVb, iVc, iVd };
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