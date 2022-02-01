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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.PhoneFormater;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.widget.MMEditText.c;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;

public class MobileVerifyUI
  extends MMActivity
{
  protected String dSf;
  protected ProgressDialog gtM = null;
  protected Button gxv;
  int jkp;
  String kbV;
  protected EditText kbd;
  protected TextView kbe;
  SecurityImage kdp = null;
  protected boolean kmX = false;
  private com.tencent.mm.platformtools.b kmf;
  private int knQ;
  protected String knu;
  protected MMFormInputView koR;
  protected TextView koS;
  protected TextView koT;
  protected TextView koU;
  protected ScrollView koV;
  private long koW = 0L;
  private boolean koX = false;
  private String[] koY;
  private boolean koZ = false;
  String kof;
  int kon;
  protected int kop;
  Boolean kpa;
  private int kpb = 30;
  protected boolean kpc = false;
  protected boolean kpd = false;
  protected int kpe = -1;
  private c kpf;
  String kpg;
  protected String kph;
  private Timer mTimer;
  String nickName;
  
  private void bpu()
  {
    AppMethodBeat.i(128458);
    if (!this.koX)
    {
      this.mTimer = new Timer();
      this.koX = true;
      this.koW = this.kpb;
      b localb = new b(this);
      this.mTimer.schedule(localb, 1000L, 1000L);
    }
    AppMethodBeat.o(128458);
  }
  
  private void bpv()
  {
    AppMethodBeat.i(128461);
    hideVKB();
    if (this.kbd.getText().toString().trim().equals(""))
    {
      com.tencent.mm.ui.base.h.n(this, 2131756651, 2131755998);
      AppMethodBeat.o(128461);
      return;
    }
    this.kpf.a(a.kpo);
    AppMethodBeat.o(128461);
  }
  
  private void bpw()
  {
    AppMethodBeat.i(128462);
    this.koZ = false;
    this.koS.setEnabled(false);
    this.koT.setVisibility(0);
    this.koT.setText(getResources().getQuantityString(2131623957, this.kpb, new Object[] { Integer.valueOf(this.kpb) }));
    this.koS.setVisibility(8);
    bpu();
    this.kpf.a(a.kpp);
    com.tencent.mm.ui.base.h.cD(this, getString(2131763074));
    AppMethodBeat.o(128462);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(128464);
    com.tencent.mm.plugin.b.a.bwV(this.kbV);
    if (!this.kpf.a(a.kpn))
    {
      finish();
      AppMethodBeat.o(128464);
      return;
    }
    AppMethodBeat.o(128464);
  }
  
  public int getLayoutId()
  {
    return 2131495678;
  }
  
  protected final void gq(boolean paramBoolean)
  {
    AppMethodBeat.i(128467);
    Intent localIntent = new Intent(this, RegByMobileSetPwdUI.class);
    localIntent.putExtra("kintent_hint", getString(2131765477));
    localIntent.putExtra("kintent_cancelable", paramBoolean);
    startActivityForResult(localIntent, 0);
    AppMethodBeat.o(128467);
  }
  
  public void initView()
  {
    AppMethodBeat.i(128460);
    Log.d("MicroMsg.MobileVerifyUI", "init getintent mobile:" + this.dSf);
    this.koR = ((MMFormInputView)findViewById(2131297407));
    this.koR.setImeOption(5);
    this.koR.setInputType(3);
    this.kbd = this.koR.getContentEditText();
    this.koS = ((TextView)findViewById(2131304814));
    this.koT = ((TextView)findViewById(2131304813));
    this.kbe = ((TextView)findViewById(2131297405));
    this.kbe.setText(this.dSf);
    this.dSf = PhoneFormater.pureNumber(this.dSf);
    this.koS.setText(getString(2131763127));
    this.koU = ((TextView)findViewById(2131297408));
    this.gxv = ((Button)findViewById(2131305423));
    this.koV = ((ScrollView)findViewById(2131307329));
    this.koY = getResources().getStringArray(2130903093);
    Object localObject = getString(2131764393);
    this.koU.setText(Html.fromHtml((String)localObject));
    localObject = new InputFilter()
    {
      public final CharSequence filter(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, Spanned paramAnonymousSpanned, int paramAnonymousInt3, int paramAnonymousInt4)
      {
        AppMethodBeat.i(196877);
        paramAnonymousCharSequence = Util.filterNumber(paramAnonymousCharSequence);
        AppMethodBeat.o(196877);
        return paramAnonymousCharSequence;
      }
    };
    this.koT.setVisibility(0);
    this.koT.setText(getResources().getQuantityString(2131623957, this.kpb, new Object[] { Integer.valueOf(this.kpb) }));
    bpu();
    this.koZ = false;
    this.kbd.setFilters(new InputFilter[] { localObject });
    this.kbd.addTextChangedListener(new MMEditText.c(this.kbd, null, 12));
    this.gxv.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(196878);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/MobileVerifyUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        MobileVerifyUI.e(MobileVerifyUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileVerifyUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(196878);
      }
    });
    this.gxv.setEnabled(false);
    this.kbd.setTextSize(15.0F);
    this.kbd.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(196879);
        if (Util.isNullOrNil(MobileVerifyUI.this.kbd.getText().toString()))
        {
          MobileVerifyUI.this.kbd.setTextSize(15.0F);
          MobileVerifyUI.this.kbd.setGravity(16);
        }
        while ((MobileVerifyUI.this.kbd.getText() != null) && (MobileVerifyUI.this.kbd.getText().toString().length() > 0))
        {
          MobileVerifyUI.this.gxv.setEnabled(true);
          AppMethodBeat.o(196879);
          return;
          MobileVerifyUI.this.kbd.setTextSize(24.0F);
          MobileVerifyUI.this.kbd.setGravity(16);
        }
        MobileVerifyUI.this.gxv.setEnabled(false);
        AppMethodBeat.o(196879);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.koS.setOnClickListener(new View.OnClickListener()
    {
      private final int kpj = 0;
      private final int kpk = 1;
      private final int kpl = 2;
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(196882);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/MobileVerifyUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = new l(MobileVerifyUI.this);
        paramAnonymousView.HLX = new o.f()
        {
          public final void onCreateMMMenu(m paramAnonymous2m)
          {
            AppMethodBeat.i(196880);
            paramAnonymous2m.d(0, MobileVerifyUI.this.getString(2131763127));
            if (com.tencent.mm.aw.b.Pg(MobileVerifyUI.this.dSf)) {
              paramAnonymous2m.d(1, MobileVerifyUI.this.getString(2131756654));
            }
            if ((MobileVerifyUI.f(MobileVerifyUI.this) == 2) && (MobileVerifyUI.this.kpd)) {
              paramAnonymous2m.d(2, MobileVerifyUI.this.getString(2131764397));
            }
            AppMethodBeat.o(196880);
          }
        };
        paramAnonymousView.HLY = new o.g()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(196881);
            switch (paramAnonymous2MenuItem.getItemId())
            {
            default: 
              AppMethodBeat.o(196881);
              return;
            case 0: 
              MobileVerifyUI.g(MobileVerifyUI.this);
              AppMethodBeat.o(196881);
              return;
            }
            MobileVerifyUI.this.hideVKB();
            if (MobileVerifyUI.f(MobileVerifyUI.this) == 2) {
              com.tencent.mm.plugin.b.a.bwV("R200_500");
            }
            for (;;)
            {
              paramAnonymous2MenuItem = new Intent(MobileVerifyUI.this, RegByMobileVoiceVerifyUI.class);
              Object localObject = new Bundle();
              ((Bundle)localObject).putString("bindmcontact_mobile", MobileVerifyUI.this.dSf);
              ((Bundle)localObject).putInt("voice_verify_type", MobileVerifyUI.h(MobileVerifyUI.this));
              paramAnonymous2MenuItem.putExtras((Bundle)localObject);
              localObject = MobileVerifyUI.this;
              paramAnonymous2MenuItem = new com.tencent.mm.hellhoundlib.b.a().bl(paramAnonymous2MenuItem);
              com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymous2MenuItem.axQ(), "com/tencent/mm/plugin/account/ui/MobileVerifyUI$4$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((MobileVerifyUI)localObject).startActivity((Intent)paramAnonymous2MenuItem.pG(0));
              com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/account/ui/MobileVerifyUI$4$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              break;
              if (MobileVerifyUI.f(MobileVerifyUI.this) == 3) {
                com.tencent.mm.plugin.b.a.bwV("F200_300");
              }
            }
          }
        };
        paramAnonymousView.gXI();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileVerifyUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(196882);
      }
    });
    this.koS.setEnabled(false);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(196883);
        MobileVerifyUI.i(MobileVerifyUI.this);
        AppMethodBeat.o(196883);
        return true;
      }
    });
    this.kbd.setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(196884);
        if ((paramAnonymousInt == 6) || (paramAnonymousInt == 5))
        {
          MobileVerifyUI.e(MobileVerifyUI.this);
          AppMethodBeat.o(196884);
          return true;
        }
        AppMethodBeat.o(196884);
        return false;
      }
    });
    this.kbd.setOnKeyListener(new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(196885);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        localb.pH(paramAnonymousInt);
        localb.bm(paramAnonymousKeyEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/MobileVerifyUI$7", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.axR());
        if ((66 == paramAnonymousInt) && (paramAnonymousKeyEvent.getAction() == 0))
        {
          MobileVerifyUI.e(MobileVerifyUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/account/ui/MobileVerifyUI$7", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
          AppMethodBeat.o(196885);
          return true;
        }
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/account/ui/MobileVerifyUI$7", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
        AppMethodBeat.o(196885);
        return false;
      }
    });
    AppMethodBeat.o(128460);
  }
  
  protected final boolean n(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(128466);
    Object localObject = com.tencent.mm.h.a.Dk(paramString);
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
      if (g.azz().aYS() == 5)
      {
        com.tencent.mm.ui.base.h.n(this, 2131763503, 2131763502);
        AppMethodBeat.o(128466);
        return true;
      }
      y.dz(this);
      AppMethodBeat.o(128466);
      return true;
      Toast.makeText(this, 2131756598, 0).show();
      i = 1;
      continue;
      Toast.makeText(this, 2131756595, 0).show();
      i = 1;
      continue;
      Toast.makeText(this, 2131756597, 0).show();
      i = 1;
      continue;
      Toast.makeText(this, 2131756600, 0).show();
      i = 1;
      continue;
      com.tencent.mm.ui.base.h.d(this, getString(2131756646), "", new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      i = 1;
      continue;
      com.tencent.mm.ui.base.h.a(this, 2131756644, 2131756650, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      i = 1;
      continue;
      com.tencent.mm.kernel.a.hold();
      AppCompatActivity localAppCompatActivity = getContext();
      g.aAf();
      if (TextUtils.isEmpty(com.tencent.mm.kernel.a.ayX())) {}
      for (localObject = com.tencent.mm.cb.a.aI(getContext(), 2131762849);; localObject = com.tencent.mm.kernel.a.ayX())
      {
        com.tencent.mm.ui.base.h.a(localAppCompatActivity, (String)localObject, getContext().getString(2131755998), new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        }, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
        });
        i = 1;
        break;
        g.aAf();
      }
    }
    paramString = new ae(paramInt1, paramInt2, paramString);
    if (this.kmf.a(this, paramString))
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
    this.kon = getIntent().getIntExtra("key_reg_style", 1);
    this.knQ = getIntent().getIntExtra("mobile_verify_purpose", 0);
    this.kpg = getIntent().getStringExtra("MicroMsg.MobileVerifyUIIntent_sms_code");
    this.kof = getIntent().getStringExtra("kintent_password");
    this.nickName = getIntent().getStringExtra("kintent_nickname");
    this.kpa = Boolean.valueOf(getIntent().getBooleanExtra("kintent_hasavatar", false));
    this.kmX = getIntent().getBooleanExtra("from_deep_link", false);
    this.knu = getIntent().getStringExtra("regsession_id");
    this.kph = getIntent().getStringExtra("reg_3d_app_ticket");
    this.kop = getIntent().getIntExtra("reg_3d_app_type", 0);
    switch (this.knQ)
    {
    default: 
      Log.e("MicroMsg.MobileVerifyUI", "wrong purpose %s", new Object[] { Integer.valueOf(this.knQ) });
      finish();
      AppMethodBeat.o(128454);
      return;
    case 2: 
      this.kpf = new p();
      if ((this.kof != null) && (this.kof.length() >= 8))
      {
        this.jkp = 1;
        paramBundle = getString(2131756626);
        if ((d.KyR) || (BuildInfo.IS_FLAVOR_BLUE)) {
          paramBundle = getString(2131755908) + com.tencent.mm.cc.h.jr(this);
        }
        setMMTitle(paramBundle);
        this.kpb = getIntent().getIntExtra("mobileverify_countdownsec", 30);
        this.kpc = getIntent().getBooleanExtra("mobileverify_fb", false);
        this.kpd = getIntent().getBooleanExtra("mobileverify_reg_qq", false);
        this.dSf = getIntent().getExtras().getString("bindmcontact_mobile");
        this.kbV = com.tencent.mm.plugin.b.a.bpZ();
        initView();
        this.kpf.a(this);
        if (this.kpg == null) {
          break label478;
        }
        this.kbd.setText(this.kpg);
        bpv();
      }
      break;
    }
    for (;;)
    {
      this.kmf = new com.tencent.mm.platformtools.b();
      AppMethodBeat.o(128454);
      return;
      this.jkp = 4;
      break;
      this.kpf = new n(this.knQ);
      break;
      this.kpf = new o();
      break;
      label478:
      if (this.knQ == 5) {
        this.kpf.a(a.kpp);
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128455);
    if (this.kmf != null) {
      this.kmf.close();
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
      this.koV.scrollTo(0, this.koV.getChildAt(0).getMeasuredHeight() - this.koV.getMeasuredHeight());
      AppMethodBeat.o(128459);
      return;
    }
    this.koV.scrollTo(0, 0);
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
        bpw();
      }
    }
    AppMethodBeat.o(128465);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(128457);
    super.onPause();
    this.kpf.stop();
    AppMethodBeat.o(128457);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(128456);
    super.onResume();
    this.kpf.start();
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
      kpn = new a("GoBack", 0);
      kpo = new a("GoNext", 1);
      kpp = new a("DoSend", 2);
      kpq = new a("DoProcessSMS", 3);
      kpr = new a[] { kpn, kpo, kpp, kpq };
      AppMethodBeat.o(128453);
    }
    
    private a() {}
  }
  
  static final class b
    extends TimerTask
  {
    WeakReference<MobileVerifyUI> kps;
    
    b(MobileVerifyUI paramMobileVerifyUI)
    {
      AppMethodBeat.i(196887);
      this.kps = new WeakReference(paramMobileVerifyUI);
      AppMethodBeat.o(196887);
    }
    
    public final void run()
    {
      AppMethodBeat.i(196888);
      final MobileVerifyUI localMobileVerifyUI = (MobileVerifyUI)this.kps.get();
      if (localMobileVerifyUI == null)
      {
        AppMethodBeat.o(196888);
        return;
      }
      localMobileVerifyUI.koT.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(196886);
          MobileVerifyUI.b(localMobileVerifyUI);
          if (MobileVerifyUI.c(localMobileVerifyUI) >= 0L)
          {
            localMobileVerifyUI.koT.setText(localMobileVerifyUI.getResources().getQuantityString(2131623957, (int)MobileVerifyUI.c(localMobileVerifyUI), new Object[] { Integer.valueOf((int)MobileVerifyUI.c(localMobileVerifyUI)) }));
            AppMethodBeat.o(196886);
            return;
          }
          localMobileVerifyUI.koT.setVisibility(8);
          localMobileVerifyUI.koS.setVisibility(0);
          MobileVerifyUI.d(localMobileVerifyUI);
          localMobileVerifyUI.koS.setEnabled(true);
          localMobileVerifyUI.koS.setText(localMobileVerifyUI.getString(2131763126));
          AppMethodBeat.o(196886);
        }
      });
      AppMethodBeat.o(196888);
    }
  }
  
  public static abstract interface c
  {
    public abstract void a(MobileVerifyUI paramMobileVerifyUI);
    
    public abstract boolean a(MobileVerifyUI.a parama);
    
    public abstract void start();
    
    public abstract void stop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileVerifyUI
 * JD-Core Version:    0.7.0.1
 */