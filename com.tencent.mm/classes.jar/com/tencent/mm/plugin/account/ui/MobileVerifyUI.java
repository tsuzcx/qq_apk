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
import com.tencent.mm.ak.q;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.bb;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.widget.MMEditText.c;
import java.util.Timer;
import java.util.TimerTask;

public class MobileVerifyUI
  extends MMActivity
{
  String bVF;
  protected String dAs;
  protected ProgressDialog fOC = null;
  protected Button fSn;
  int ipi;
  String jdS;
  protected EditText jda;
  protected TextView jdb;
  SecurityImage jfm = null;
  private com.tencent.mm.platformtools.b jnW;
  protected boolean joN = false;
  private int jpG;
  String jpT;
  protected String jpk;
  protected MMFormInputView jqF;
  protected TextView jqG;
  protected TextView jqH;
  protected TextView jqI;
  protected ScrollView jqJ;
  private long jqK = 0L;
  private boolean jqL = false;
  private String[] jqM;
  private boolean jqN = false;
  Boolean jqO;
  private int jqP = 30;
  protected boolean jqQ = false;
  protected boolean jqR = false;
  protected int jqS = -1;
  private b jqT;
  String jqU;
  protected String jqV;
  int jqb;
  protected int jqd;
  private Timer mTimer;
  
  private void aUH()
  {
    AppMethodBeat.i(128458);
    if (!this.jqL)
    {
      this.mTimer = new Timer();
      this.jqL = true;
      this.jqK = this.jqP;
      TimerTask local1 = new TimerTask()
      {
        public final void run()
        {
          AppMethodBeat.i(128441);
          MobileVerifyUI.this.jqH.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(128440);
              MobileVerifyUI.b(MobileVerifyUI.this);
              if (MobileVerifyUI.c(MobileVerifyUI.this) >= 0L)
              {
                MobileVerifyUI.this.jqH.setText(MobileVerifyUI.this.getResources().getQuantityString(2131623957, (int)MobileVerifyUI.c(MobileVerifyUI.this), new Object[] { Integer.valueOf((int)MobileVerifyUI.c(MobileVerifyUI.this)) }));
                AppMethodBeat.o(128440);
                return;
              }
              MobileVerifyUI.this.jqH.setVisibility(8);
              MobileVerifyUI.this.jqG.setVisibility(0);
              MobileVerifyUI.d(MobileVerifyUI.this);
              MobileVerifyUI.this.jqG.setEnabled(true);
              MobileVerifyUI.this.jqG.setText(MobileVerifyUI.this.getString(2131761300));
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
  
  private void aUI()
  {
    AppMethodBeat.i(128461);
    hideVKB();
    if (this.jda.getText().toString().trim().equals(""))
    {
      h.l(this, 2131756515, 2131755906);
      AppMethodBeat.o(128461);
      return;
    }
    this.jqT.a(a.jrd);
    AppMethodBeat.o(128461);
  }
  
  private void aUJ()
  {
    AppMethodBeat.i(128462);
    this.jqN = false;
    this.jqG.setEnabled(false);
    this.jqH.setVisibility(0);
    this.jqH.setText(getResources().getQuantityString(2131623957, this.jqP, new Object[] { Integer.valueOf(this.jqP) }));
    this.jqG.setVisibility(8);
    aUH();
    this.jqT.a(a.jre);
    h.cm(this, getString(2131761248));
    AppMethodBeat.o(128462);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(128464);
    com.tencent.mm.plugin.b.a.KB(this.jdS);
    if (!this.jqT.a(a.jrc))
    {
      finish();
      AppMethodBeat.o(128464);
      return;
    }
    AppMethodBeat.o(128464);
  }
  
  protected final void fx(boolean paramBoolean)
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
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.MobileVerifyUI", "init getintent mobile:" + this.dAs);
    this.jqF = ((MMFormInputView)findViewById(2131297252));
    this.jqF.setImeOption(5);
    this.jqF.setInputType(3);
    this.jda = this.jqF.getContentEditText();
    this.jqG = ((TextView)findViewById(2131302417));
    this.jqH = ((TextView)findViewById(2131302416));
    this.jdb = ((TextView)findViewById(2131297250));
    this.jdb.setText(this.dAs);
    this.dAs = bb.aSf(this.dAs);
    this.jqG.setText(getString(2131761301));
    this.jqI = ((TextView)findViewById(2131297253));
    this.fSn = ((Button)findViewById(2131302852));
    this.jqJ = ((ScrollView)findViewById(2131304367));
    this.jqM = getResources().getStringArray(2130903092);
    Object localObject = getString(2131762327);
    this.jqI.setText(Html.fromHtml((String)localObject));
    localObject = new InputFilter()
    {
      public final CharSequence filter(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, Spanned paramAnonymousSpanned, int paramAnonymousInt3, int paramAnonymousInt4)
      {
        AppMethodBeat.i(128442);
        paramAnonymousCharSequence = bu.ai(paramAnonymousCharSequence);
        AppMethodBeat.o(128442);
        return paramAnonymousCharSequence;
      }
    };
    this.jqH.setVisibility(0);
    this.jqH.setText(getResources().getQuantityString(2131623957, this.jqP, new Object[] { Integer.valueOf(this.jqP) }));
    aUH();
    this.jqN = false;
    this.jda.setFilters(new InputFilter[] { localObject });
    this.jda.addTextChangedListener(new MMEditText.c(this.jda, null, 12));
    this.fSn.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(128443);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/MobileVerifyUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        MobileVerifyUI.e(MobileVerifyUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileVerifyUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(128443);
      }
    });
    this.fSn.setEnabled(false);
    this.jda.setTextSize(15.0F);
    this.jda.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(128444);
        if (bu.isNullOrNil(MobileVerifyUI.this.jda.getText().toString()))
        {
          MobileVerifyUI.this.jda.setTextSize(15.0F);
          MobileVerifyUI.this.jda.setGravity(16);
        }
        while ((MobileVerifyUI.this.jda.getText() != null) && (MobileVerifyUI.this.jda.getText().toString().length() > 0))
        {
          MobileVerifyUI.this.fSn.setEnabled(true);
          AppMethodBeat.o(128444);
          return;
          MobileVerifyUI.this.jda.setTextSize(24.0F);
          MobileVerifyUI.this.jda.setGravity(16);
        }
        MobileVerifyUI.this.fSn.setEnabled(false);
        AppMethodBeat.o(128444);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.jqG.setOnClickListener(new View.OnClickListener()
    {
      private final int jqY = 0;
      private final int jqZ = 1;
      private final int jra = 2;
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(128447);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/MobileVerifyUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramAnonymousView = new com.tencent.mm.ui.tools.l(MobileVerifyUI.this);
        paramAnonymousView.LfS = new n.d()
        {
          public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
          {
            AppMethodBeat.i(128445);
            paramAnonymous2l.d(0, MobileVerifyUI.this.getString(2131761301));
            if (com.tencent.mm.aw.b.Gu(MobileVerifyUI.this.dAs)) {
              paramAnonymous2l.d(1, MobileVerifyUI.this.getString(2131756518));
            }
            if ((MobileVerifyUI.f(MobileVerifyUI.this) == 2) && (MobileVerifyUI.this.jqR)) {
              paramAnonymous2l.d(2, MobileVerifyUI.this.getString(2131762331));
            }
            AppMethodBeat.o(128445);
          }
        };
        paramAnonymousView.LfT = new n.e()
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
              com.tencent.mm.plugin.b.a.KB("R200_500");
            }
            for (;;)
            {
              paramAnonymous2MenuItem = new Intent(MobileVerifyUI.this, RegByMobileVoiceVerifyUI.class);
              Object localObject = new Bundle();
              ((Bundle)localObject).putString("bindmcontact_mobile", MobileVerifyUI.this.dAs);
              ((Bundle)localObject).putInt("voice_verify_type", MobileVerifyUI.h(MobileVerifyUI.this));
              paramAnonymous2MenuItem.putExtras((Bundle)localObject);
              localObject = MobileVerifyUI.this;
              paramAnonymous2MenuItem = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymous2MenuItem);
              com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymous2MenuItem.ahE(), "com/tencent/mm/plugin/account/ui/MobileVerifyUI$5$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((MobileVerifyUI)localObject).startActivity((Intent)paramAnonymous2MenuItem.mt(0));
              com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/account/ui/MobileVerifyUI$5$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              break;
              if (MobileVerifyUI.f(MobileVerifyUI.this) == 3) {
                com.tencent.mm.plugin.b.a.KB("F200_300");
              }
            }
          }
        };
        paramAnonymousView.fOP();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileVerifyUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(128447);
      }
    });
    this.jqG.setEnabled(false);
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
    this.jda.setOnEditorActionListener(new TextView.OnEditorActionListener()
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
    this.jda.setOnKeyListener(new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(128450);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        localb.mu(paramAnonymousInt);
        localb.bd(paramAnonymousKeyEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/MobileVerifyUI$8", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.ahF());
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
    Object localObject = com.tencent.mm.h.a.uU(paramString);
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
      if (com.tencent.mm.kernel.g.ajj().aFd() == 5)
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
      com.tencent.mm.kernel.g.ajP();
      if (TextUtils.isEmpty(com.tencent.mm.kernel.a.aiH())) {}
      for (localObject = com.tencent.mm.cb.a.az(getContext(), 2131761063);; localObject = com.tencent.mm.kernel.a.aiH())
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
        com.tencent.mm.kernel.g.ajP();
      }
    }
    paramString = new com.tencent.mm.platformtools.ae(paramInt1, paramInt2, paramString);
    if (this.jnW.a(this, paramString))
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
    this.jqb = getIntent().getIntExtra("key_reg_style", 1);
    this.jpG = getIntent().getIntExtra("mobile_verify_purpose", 0);
    this.jqU = getIntent().getStringExtra("MicroMsg.MobileVerifyUIIntent_sms_code");
    this.jpT = getIntent().getStringExtra("kintent_password");
    this.bVF = getIntent().getStringExtra("kintent_nickname");
    this.jqO = Boolean.valueOf(getIntent().getBooleanExtra("kintent_hasavatar", false));
    this.joN = getIntent().getBooleanExtra("from_deep_link", false);
    this.jpk = getIntent().getStringExtra("regsession_id");
    this.jqV = getIntent().getStringExtra("reg_3d_app_ticket");
    this.jqd = getIntent().getIntExtra("reg_3d_app_type", 0);
    switch (this.jpG)
    {
    default: 
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.MobileVerifyUI", "wrong purpose %s", new Object[] { Integer.valueOf(this.jpG) });
      finish();
      AppMethodBeat.o(128454);
      return;
    case 2: 
      this.jqT = new o();
      if ((this.jpT != null) && (this.jpT.length() >= 8))
      {
        this.ipi = 1;
        paramBundle = getString(2131756490);
        if ((d.FFK) || (j.IS_FLAVOR_BLUE)) {
          paramBundle = getString(2131755822) + com.tencent.mm.cc.g.ix(this);
        }
        setMMTitle(paramBundle);
        this.jqP = getIntent().getIntExtra("mobileverify_countdownsec", 30);
        this.jqQ = getIntent().getBooleanExtra("mobileverify_fb", false);
        this.jqR = getIntent().getBooleanExtra("mobileverify_reg_qq", false);
        this.dAs = getIntent().getExtras().getString("bindmcontact_mobile");
        this.jdS = com.tencent.mm.plugin.b.a.aVo();
        initView();
        this.jqT.a(this);
        if (this.jqU == null) {
          break label478;
        }
        this.jda.setText(this.jqU);
        aUI();
      }
      break;
    }
    for (;;)
    {
      this.jnW = new com.tencent.mm.platformtools.b();
      AppMethodBeat.o(128454);
      return;
      this.ipi = 4;
      break;
      this.jqT = new m(this.jpG);
      break;
      this.jqT = new n();
      break;
      label478:
      if (this.jpG == 5) {
        this.jqT.a(a.jre);
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128455);
    if (this.jnW != null) {
      this.jnW.close();
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
      this.jqJ.scrollTo(0, this.jqJ.getChildAt(0).getMeasuredHeight() - this.jqJ.getMeasuredHeight());
      AppMethodBeat.o(128459);
      return;
    }
    this.jqJ.scrollTo(0, 0);
    AppMethodBeat.o(128459);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(128465);
    super.onNewIntent(paramIntent);
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getStringExtra("nofification_type");
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.MobileVerifyUI", "[oneliang][notificationType]%s", new Object[] { paramIntent });
      if ((paramIntent != null) && (paramIntent.equals("no_reg_notification"))) {
        aUJ();
      }
    }
    AppMethodBeat.o(128465);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(128457);
    super.onPause();
    this.jqT.stop();
    AppMethodBeat.o(128457);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(128456);
    super.onResume();
    this.jqT.start();
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
      jrc = new a("GoBack", 0);
      jrd = new a("GoNext", 1);
      jre = new a("DoSend", 2);
      jrf = new a("DoProcessSMS", 3);
      jrg = new a[] { jrc, jrd, jre, jrf };
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileVerifyUI
 * JD-Core Version:    0.7.0.1
 */