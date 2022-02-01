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
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ba;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.MMEditText.c;
import java.util.Timer;
import java.util.TimerTask;

public class MobileVerifyUI
  extends MMActivity
{
  String bNK;
  protected String dpO;
  protected ProgressDialog fpP = null;
  protected Button ftn;
  int hsv;
  protected EditText igP;
  protected TextView igQ;
  String ihI;
  SecurityImage ijd = null;
  private com.tencent.mm.platformtools.b irP;
  protected boolean isG = false;
  String itM;
  int itU;
  protected int itW;
  protected String itd;
  private int itz;
  protected TextView iuA;
  protected TextView iuB;
  protected ScrollView iuC;
  private long iuD = 0L;
  private boolean iuE = false;
  private String[] iuF;
  private boolean iuG = false;
  Boolean iuH;
  private int iuI = 30;
  protected boolean iuJ = false;
  protected boolean iuK = false;
  protected int iuL = -1;
  private b iuM;
  String iuN;
  protected String iuO;
  protected MMFormInputView iuy;
  protected TextView iuz;
  private Timer mTimer;
  
  private void aKf()
  {
    AppMethodBeat.i(128458);
    if (!this.iuE)
    {
      this.mTimer = new Timer();
      this.iuE = true;
      this.iuD = this.iuI;
      TimerTask local1 = new TimerTask()
      {
        public final void run()
        {
          AppMethodBeat.i(128441);
          MobileVerifyUI.this.iuA.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(128440);
              MobileVerifyUI.b(MobileVerifyUI.this);
              if (MobileVerifyUI.c(MobileVerifyUI.this) >= 0L)
              {
                MobileVerifyUI.this.iuA.setText(MobileVerifyUI.this.getResources().getQuantityString(2131623957, (int)MobileVerifyUI.c(MobileVerifyUI.this), new Object[] { Integer.valueOf((int)MobileVerifyUI.c(MobileVerifyUI.this)) }));
                AppMethodBeat.o(128440);
                return;
              }
              MobileVerifyUI.this.iuA.setVisibility(8);
              MobileVerifyUI.this.iuz.setVisibility(0);
              MobileVerifyUI.d(MobileVerifyUI.this);
              MobileVerifyUI.this.iuz.setEnabled(true);
              MobileVerifyUI.this.iuz.setText(MobileVerifyUI.this.getString(2131761300));
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
  
  private void aKg()
  {
    AppMethodBeat.i(128461);
    hideVKB();
    if (this.igP.getText().toString().trim().equals(""))
    {
      h.j(this, 2131756515, 2131755906);
      AppMethodBeat.o(128461);
      return;
    }
    this.iuM.a(a.iuW);
    AppMethodBeat.o(128461);
  }
  
  private void aKh()
  {
    AppMethodBeat.i(128462);
    this.iuG = false;
    this.iuz.setEnabled(false);
    this.iuA.setVisibility(0);
    this.iuA.setText(getResources().getQuantityString(2131623957, this.iuI, new Object[] { Integer.valueOf(this.iuI) }));
    this.iuz.setVisibility(8);
    aKf();
    this.iuM.a(a.iuX);
    h.cf(this, getString(2131761248));
    AppMethodBeat.o(128462);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(128464);
    com.tencent.mm.plugin.b.a.aUz(this.ihI);
    if (!this.iuM.a(a.iuV))
    {
      finish();
      AppMethodBeat.o(128464);
      return;
    }
    AppMethodBeat.o(128464);
  }
  
  protected final void eY(boolean paramBoolean)
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
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.MobileVerifyUI", "init getintent mobile:" + this.dpO);
    this.iuy = ((MMFormInputView)findViewById(2131297252));
    this.iuy.setImeOption(5);
    this.iuy.setInputType(3);
    this.igP = this.iuy.getContentEditText();
    this.iuz = ((TextView)findViewById(2131302417));
    this.iuA = ((TextView)findViewById(2131302416));
    this.igQ = ((TextView)findViewById(2131297250));
    this.igQ.setText(this.dpO);
    this.dpO = ba.aFL(this.dpO);
    this.iuz.setText(getString(2131761301));
    this.iuB = ((TextView)findViewById(2131297253));
    this.ftn = ((Button)findViewById(2131302852));
    this.iuC = ((ScrollView)findViewById(2131304367));
    this.iuF = getResources().getStringArray(2130903092);
    Object localObject = getString(2131762327);
    this.iuB.setText(Html.fromHtml((String)localObject));
    localObject = new InputFilter()
    {
      public final CharSequence filter(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, Spanned paramAnonymousSpanned, int paramAnonymousInt3, int paramAnonymousInt4)
      {
        AppMethodBeat.i(128442);
        paramAnonymousCharSequence = bt.aj(paramAnonymousCharSequence);
        AppMethodBeat.o(128442);
        return paramAnonymousCharSequence;
      }
    };
    this.iuA.setVisibility(0);
    this.iuA.setText(getResources().getQuantityString(2131623957, this.iuI, new Object[] { Integer.valueOf(this.iuI) }));
    aKf();
    this.iuG = false;
    this.igP.setFilters(new InputFilter[] { localObject });
    this.igP.addTextChangedListener(new MMEditText.c(this.igP, null, 12));
    this.ftn.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(128443);
        MobileVerifyUI.e(MobileVerifyUI.this);
        AppMethodBeat.o(128443);
      }
    });
    this.ftn.setEnabled(false);
    this.igP.setTextSize(15.0F);
    this.igP.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(128444);
        if (bt.isNullOrNil(MobileVerifyUI.this.igP.getText().toString()))
        {
          MobileVerifyUI.this.igP.setTextSize(15.0F);
          MobileVerifyUI.this.igP.setGravity(16);
        }
        while ((MobileVerifyUI.this.igP.getText() != null) && (MobileVerifyUI.this.igP.getText().toString().length() > 0))
        {
          MobileVerifyUI.this.ftn.setEnabled(true);
          AppMethodBeat.o(128444);
          return;
          MobileVerifyUI.this.igP.setTextSize(24.0F);
          MobileVerifyUI.this.igP.setGravity(16);
        }
        MobileVerifyUI.this.ftn.setEnabled(false);
        AppMethodBeat.o(128444);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.iuz.setOnClickListener(new View.OnClickListener()
    {
      private final int iuR = 0;
      private final int iuS = 1;
      private final int iuT = 2;
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(128447);
        paramAnonymousView = new com.tencent.mm.ui.tools.l(MobileVerifyUI.this);
        paramAnonymousView.HrX = new n.c()
        {
          public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
          {
            AppMethodBeat.i(128445);
            paramAnonymous2l.c(0, MobileVerifyUI.this.getString(2131761301));
            if (com.tencent.mm.ax.b.yJ(MobileVerifyUI.this.dpO)) {
              paramAnonymous2l.c(1, MobileVerifyUI.this.getString(2131756518));
            }
            if ((MobileVerifyUI.f(MobileVerifyUI.this) == 2) && (MobileVerifyUI.this.iuK)) {
              paramAnonymous2l.c(2, MobileVerifyUI.this.getString(2131762331));
            }
            AppMethodBeat.o(128445);
          }
        };
        paramAnonymousView.HrY = new n.d()
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
              com.tencent.mm.plugin.b.a.aUz("R200_500");
            }
            for (;;)
            {
              paramAnonymous2MenuItem = new Intent(MobileVerifyUI.this, RegByMobileVoiceVerifyUI.class);
              Object localObject = new Bundle();
              ((Bundle)localObject).putString("bindmcontact_mobile", MobileVerifyUI.this.dpO);
              ((Bundle)localObject).putInt("voice_verify_type", MobileVerifyUI.h(MobileVerifyUI.this));
              paramAnonymous2MenuItem.putExtras((Bundle)localObject);
              localObject = MobileVerifyUI.this;
              paramAnonymous2MenuItem = new com.tencent.mm.hellhoundlib.b.a().bd(paramAnonymous2MenuItem);
              com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymous2MenuItem.adn(), "com/tencent/mm/plugin/account/ui/MobileVerifyUI$5$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((MobileVerifyUI)localObject).startActivity((Intent)paramAnonymous2MenuItem.lS(0));
              com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/account/ui/MobileVerifyUI$5$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              break;
              if (MobileVerifyUI.f(MobileVerifyUI.this) == 3) {
                com.tencent.mm.plugin.b.a.aUz("F200_300");
              }
            }
          }
        };
        paramAnonymousView.fdQ();
        AppMethodBeat.o(128447);
      }
    });
    this.iuz.setEnabled(false);
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
    this.igP.setOnEditorActionListener(new TextView.OnEditorActionListener()
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
    this.igP.setOnKeyListener(new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(128450);
        if ((66 == paramAnonymousInt) && (paramAnonymousKeyEvent.getAction() == 0))
        {
          MobileVerifyUI.e(MobileVerifyUI.this);
          AppMethodBeat.o(128450);
          return true;
        }
        AppMethodBeat.o(128450);
        return false;
      }
    });
    AppMethodBeat.o(128460);
  }
  
  protected final boolean n(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(128466);
    Object localObject = com.tencent.mm.h.a.oG(paramString);
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
      if (g.aeS().auR() == 5)
      {
        h.j(this, 2131761537, 2131761536);
        AppMethodBeat.o(128466);
        return true;
      }
      y.cV(this);
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
      g.afz();
      if (TextUtils.isEmpty(com.tencent.mm.kernel.a.aeq())) {}
      for (localObject = com.tencent.mm.cd.a.aq(getContext(), 2131761063);; localObject = com.tencent.mm.kernel.a.aeq())
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
        g.afz();
      }
    }
    paramString = new com.tencent.mm.platformtools.ad(paramInt1, paramInt2, paramString);
    if (this.irP.a(this, paramString))
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
    this.itU = getIntent().getIntExtra("key_reg_style", 1);
    this.itz = getIntent().getIntExtra("mobile_verify_purpose", 0);
    this.iuN = getIntent().getStringExtra("MicroMsg.MobileVerifyUIIntent_sms_code");
    this.itM = getIntent().getStringExtra("kintent_password");
    this.bNK = getIntent().getStringExtra("kintent_nickname");
    this.iuH = Boolean.valueOf(getIntent().getBooleanExtra("kintent_hasavatar", false));
    this.isG = getIntent().getBooleanExtra("from_deep_link", false);
    this.itd = getIntent().getStringExtra("regsession_id");
    this.iuO = getIntent().getStringExtra("reg_3d_app_ticket");
    this.itW = getIntent().getIntExtra("reg_3d_app_type", 0);
    switch (this.itz)
    {
    default: 
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.MobileVerifyUI", "wrong purpose %s", new Object[] { Integer.valueOf(this.itz) });
      finish();
      AppMethodBeat.o(128454);
      return;
    case 2: 
      this.iuM = new o();
      if ((this.itM != null) && (this.itM.length() >= 8))
      {
        this.hsv = 1;
        paramBundle = getString(2131756490);
        if (d.CpN) {
          paramBundle = getString(2131755822) + getString(2131755263);
        }
        setMMTitle(paramBundle);
        this.iuI = getIntent().getIntExtra("mobileverify_countdownsec", 30);
        this.iuJ = getIntent().getBooleanExtra("mobileverify_fb", false);
        this.iuK = getIntent().getBooleanExtra("mobileverify_reg_qq", false);
        this.dpO = getIntent().getExtras().getString("bindmcontact_mobile");
        this.ihI = com.tencent.mm.plugin.b.a.fQQ();
        initView();
        this.iuM.a(this);
        if (this.iuN == null) {
          break label475;
        }
        this.igP.setText(this.iuN);
        aKg();
      }
      break;
    }
    for (;;)
    {
      this.irP = new com.tencent.mm.platformtools.b();
      AppMethodBeat.o(128454);
      return;
      this.hsv = 4;
      break;
      this.iuM = new m(this.itz);
      break;
      this.iuM = new n();
      break;
      label475:
      if (this.itz == 5) {
        this.iuM.a(a.iuX);
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128455);
    if (this.irP != null) {
      this.irP.close();
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
      this.iuC.scrollTo(0, this.iuC.getChildAt(0).getMeasuredHeight() - this.iuC.getMeasuredHeight());
      AppMethodBeat.o(128459);
      return;
    }
    this.iuC.scrollTo(0, 0);
    AppMethodBeat.o(128459);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(128465);
    super.onNewIntent(paramIntent);
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getStringExtra("nofification_type");
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.MobileVerifyUI", "[oneliang][notificationType]%s", new Object[] { paramIntent });
      if ((paramIntent != null) && (paramIntent.equals("no_reg_notification"))) {
        aKh();
      }
    }
    AppMethodBeat.o(128465);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(128457);
    super.onPause();
    this.iuM.stop();
    AppMethodBeat.o(128457);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(128456);
    super.onResume();
    this.iuM.start();
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
      iuV = new a("GoBack", 0);
      iuW = new a("GoNext", 1);
      iuX = new a("DoSend", 2);
      iuY = new a("DoProcessSMS", 3);
      iuZ = new a[] { iuV, iuW, iuX, iuY };
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileVerifyUI
 * JD-Core Version:    0.7.0.1
 */