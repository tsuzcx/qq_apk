package com.tencent.mm.plugin.account.bind.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.jl;
import com.tencent.mm.g.a.jl.b;
import com.tencent.mm.g.a.jm;
import com.tencent.mm.g.a.jm.a;
import com.tencent.mm.g.a.xn;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.modelsimple.BindWordingContent;
import com.tencent.mm.plugin.account.friend.a.z;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import java.util.Timer;
import java.util.TimerTask;

public class BindMobileVerifyUI
  extends MMWizardActivity
  implements f
{
  private String dAs;
  private int fromScene;
  private TextView jdD;
  private TextView jdE;
  private Integer jdF;
  private EditText jda;
  private Button jdc;
  private BindWordingContent jdm;
  private int jdn;
  private boolean jdo;
  private boolean jdp;
  private Timer mTimer;
  private p tipDialog;
  
  public BindMobileVerifyUI()
  {
    AppMethodBeat.i(109961);
    this.tipDialog = null;
    this.jdF = Integer.valueOf(15);
    AppMethodBeat.o(109961);
  }
  
  private void aSC()
  {
    AppMethodBeat.i(109966);
    if (this.mTimer != null)
    {
      this.mTimer.cancel();
      this.mTimer = null;
    }
    AppMethodBeat.o(109966);
  }
  
  public int getLayoutId()
  {
    return 2131493182;
  }
  
  public void initView()
  {
    AppMethodBeat.i(109965);
    this.dAs = ((String)g.ajR().ajA().get(4097, null));
    this.jda = ((EditText)findViewById(2131297252));
    this.jdD = ((TextView)findViewById(2131297251));
    this.jdE = ((TextView)findViewById(2131297246));
    Object localObject = (Button)findViewById(2131297249);
    if ((this.dAs == null) || (this.dAs.equals(""))) {
      this.dAs = ((String)g.ajR().ajA().get(6, null));
    }
    if ((this.dAs != null) && (this.dAs.length() > 0))
    {
      this.jdD.setVisibility(0);
      this.jdD.setText(this.dAs);
    }
    InputFilter local1 = new InputFilter()
    {
      public final CharSequence filter(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, Spanned paramAnonymousSpanned, int paramAnonymousInt3, int paramAnonymousInt4)
      {
        AppMethodBeat.i(109954);
        paramAnonymousCharSequence = bu.ai(paramAnonymousCharSequence);
        AppMethodBeat.o(109954);
        return paramAnonymousCharSequence;
      }
    };
    this.jda.setFilters(new InputFilter[] { local1 });
    this.jdc = ((Button)findViewById(2131297254));
    ((Button)localObject).setVisibility(8);
    this.jdE.setText(getResources().getQuantityString(2131623957, this.jdF.intValue(), new Object[] { this.jdF }));
    if (this.mTimer == null)
    {
      this.mTimer = new Timer();
      localObject = new TimerTask()
      {
        public final void run()
        {
          AppMethodBeat.i(109959);
          if (BindMobileVerifyUI.c(BindMobileVerifyUI.this) != null) {
            BindMobileVerifyUI.d(BindMobileVerifyUI.this);
          }
          AppMethodBeat.o(109959);
        }
      };
      if (this.mTimer != null) {
        this.mTimer.schedule((TimerTask)localObject, 1000L, 1000L);
      }
    }
    addTextOptionMenu(0, getString(2131755830), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(final MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(109956);
        paramAnonymousMenuItem = BindMobileVerifyUI.a(BindMobileVerifyUI.this).getText().toString().trim();
        if (paramAnonymousMenuItem.equals(""))
        {
          h.l(BindMobileVerifyUI.this, 2131756515, 2131755906);
          AppMethodBeat.o(109956);
          return true;
        }
        BindMobileVerifyUI.this.hideVKB();
        Object localObject1 = new jl();
        ((jl)localObject1).dxo.context = BindMobileVerifyUI.this;
        com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject1);
        localObject1 = ((jl)localObject1).dxp.dxq;
        Object localObject2 = new jm();
        com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject2);
        localObject2 = ((jm)localObject2).dxr.dxs;
        paramAnonymousMenuItem = new z(BindMobileVerifyUI.b(BindMobileVerifyUI.this), 2, paramAnonymousMenuItem, "", (String)localObject1, (String)localObject2);
        g.ajj().a(paramAnonymousMenuItem, 0);
        localObject1 = BindMobileVerifyUI.this;
        localObject2 = BindMobileVerifyUI.this;
        BindMobileVerifyUI.this.getString(2131755906);
        BindMobileVerifyUI.a((BindMobileVerifyUI)localObject1, h.b((Context)localObject2, BindMobileVerifyUI.this.getString(2131756503), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
          {
            AppMethodBeat.i(109955);
            g.ajj().a(paramAnonymousMenuItem);
            AppMethodBeat.o(109955);
          }
        }));
        AppMethodBeat.o(109956);
        return true;
      }
    });
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(109957);
        BindMobileVerifyUI.this.finish();
        AppMethodBeat.o(109957);
        return true;
      }
    });
    localObject = this.jdc;
    if (com.tencent.mm.aw.b.Gu(this.dAs)) {}
    for (int i = 0;; i = 8)
    {
      ((Button)localObject).setVisibility(i);
      this.jdc.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(109958);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/bind/ui/BindMobileVerifyUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          BindMobileVerifyUI.this.hideVKB();
          paramAnonymousView = new Intent();
          localObject = new Bundle();
          ((Bundle)localObject).putString("bindmcontact_mobile", BindMobileVerifyUI.b(BindMobileVerifyUI.this));
          ((Bundle)localObject).putInt("voice_verify_type", 4);
          paramAnonymousView.putExtras((Bundle)localObject);
          com.tencent.mm.plugin.account.a.a.iUz.f(BindMobileVerifyUI.this, paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindMobileVerifyUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(109958);
        }
      });
      AppMethodBeat.o(109965);
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(109962);
    super.onCreate(paramBundle);
    g.ajj().a(132, this);
    setMMTitle(2131756490);
    this.jdm = ((BindWordingContent)getIntent().getParcelableExtra("kstyle_bind_wording"));
    this.jdn = getIntent().getIntExtra("kstyle_bind_recommend_show", 0);
    this.jdo = getIntent().getBooleanExtra("Kfind_friend_by_mobile_flag", false);
    this.jdp = getIntent().getBooleanExtra("Krecom_friends_by_mobile_flag", false);
    this.fromScene = getIntent().getIntExtra("bind_scene", 0);
    initView();
    AppMethodBeat.o(109962);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(109963);
    g.ajj().b(132, this);
    super.onDestroy();
    AppMethodBeat.o(109963);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(109967);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      acs(1);
      AppMethodBeat.o(109967);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(109967);
    return bool;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    boolean bool2 = true;
    AppMethodBeat.i(109968);
    ae.i("MicroMsg.BindMobileVerifyUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (((z)paramn).KZ() != 2)
    {
      AppMethodBeat.o(109968);
      return;
    }
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (((z)paramn).KZ() == 2) {}
      switch (this.fromScene)
      {
      default: 
        if ((this.fromScene == 0) || (this.fromScene == 3)) {
          ((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).syncAddrBookAndUpload();
        }
        paramString = new Intent(this, BindMobileStatusUI.class);
        paramString.putExtra("kstyle_bind_wording", this.jdm);
        paramString.putExtra("kstyle_bind_recommend_show", this.jdn);
        paramString.putExtra("Kfind_friend_by_mobile_flag", this.jdo);
        paramString.putExtra("Krecom_friends_by_mobile_flag", this.jdp);
        paramString.putExtra("bind_scene", this.fromScene);
        al(this, paramString);
        AppMethodBeat.o(109968);
        return;
      case 1: 
        if (!v.aAL())
        {
          paramString = new xn();
          paramString.dMV.dMW = true;
          paramString.dMV.dMX = true;
          com.tencent.mm.sdk.b.a.IvT.l(paramString);
        }
        acs(1);
        paramString = new Intent();
        paramString.addFlags(67108864);
        com.tencent.mm.plugin.account.a.a.iUz.e(this, paramString);
        AppMethodBeat.o(109968);
        return;
      }
      boolean bool1;
      if (!this.jdo)
      {
        bool1 = true;
        if (this.jdp) {
          break label371;
        }
      }
      for (;;)
      {
        BindMobileStatusUI.c(this, bool1, bool2);
        exit(-1);
        AppMethodBeat.o(109968);
        return;
        bool1 = false;
        break;
        label371:
        bool2 = false;
      }
    }
    int i;
    if (com.tencent.mm.plugin.account.a.a.iUA.a(this, paramInt1, paramInt2, paramString)) {
      i = 1;
    }
    while (i != 0)
    {
      AppMethodBeat.o(109968);
      return;
      switch (paramInt2)
      {
      default: 
        i = 0;
        break;
      case -34: 
        Toast.makeText(this, 2131756462, 0).show();
        i = 1;
        break;
      case -43: 
        Toast.makeText(this, 2131756459, 0).show();
        i = 1;
        break;
      case -214: 
        paramString = com.tencent.mm.h.a.uU(paramString);
        if (paramString != null) {
          paramString.a(this, null, null);
        }
        i = 1;
        break;
      case -41: 
        Toast.makeText(this, 2131756461, 0).show();
        i = 1;
        break;
      case -35: 
        Toast.makeText(this, 2131756460, 0).show();
        i = 1;
        break;
      case -36: 
        Toast.makeText(this, 2131756464, 0).show();
        i = 1;
        break;
      case -32: 
        h.a(this, 2131756509, 2131756514, null);
        i = 1;
        break;
      case -33: 
        h.a(this, 2131756508, 2131756514, null);
        i = 1;
      }
    }
    Toast.makeText(this, getString(2131756507, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    AppMethodBeat.o(109968);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(109964);
    aSC();
    super.onStop();
    AppMethodBeat.o(109964);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMobileVerifyUI
 * JD-Core Version:    0.7.0.1
 */