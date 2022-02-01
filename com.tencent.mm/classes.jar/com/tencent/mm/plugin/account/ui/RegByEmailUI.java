package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.platformtools.i;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.account.friend.a.ab;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMAutoCompleteTextView;
import com.tencent.mm.ui.base.h;
import java.util.Map;
import java.util.Set;

public class RegByEmailUI
  extends MMActivity
  implements com.tencent.mm.al.g
{
  private static String[] ivg;
  private String evs;
  private ProgressDialog fpP = null;
  private String ihI;
  private String ije;
  private MMAutoCompleteTextView ivb;
  private EditText ivc;
  private CheckBox ivd;
  private String ive;
  private Map<String, String> ivf;
  
  private void goBack()
  {
    AppMethodBeat.i(128489);
    h.b(this, 2131762279, 2131762282, 2131755835, 2131755691, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(128474);
        com.tencent.mm.plugin.b.a.aUz(RegByEmailUI.f(RegByEmailUI.this));
        RegByEmailUI.this.hideVKB();
        RegByEmailUI.this.finish();
        AppMethodBeat.o(128474);
      }
    }, null);
    AppMethodBeat.o(128489);
  }
  
  public int getLayoutId()
  {
    return 2131495235;
  }
  
  public void initView()
  {
    AppMethodBeat.i(128488);
    this.ivb = ((MMAutoCompleteTextView)findViewById(2131303935));
    this.ivc = ((EditText)findViewById(2131303942));
    this.ivd = ((CheckBox)findViewById(2131296514));
    if (!bt.isNullOrNil(this.ive))
    {
      this.ivc.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(128473);
          RegByEmailUI.a(RegByEmailUI.this).requestFocus();
          AppMethodBeat.o(128473);
        }
      }, 500L);
      this.ivb.setText(this.ive);
    }
    if (ivg != null)
    {
      c localc = new c(this, ivg, "@");
      this.ivb.setSpilter("@");
      this.ivb.setDropDownAnchor(2131303936);
      this.ivb.setDropDownVerticalOffset(this.ivb.getPaddingBottom());
      this.ivb.setAdapter(localc);
    }
    findViewById(2131296513).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(128477);
        bt.bX(RegByEmailUI.this, RegByEmailUI.this.getString(2131764600, new Object[] { ac.eFu(), ac.eFt() }));
        AppMethodBeat.o(128477);
      }
    });
    this.ivd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(128478);
        RegByEmailUI.b(RegByEmailUI.this);
        AppMethodBeat.o(128478);
      }
    });
    addTextOptionMenu(0, getString(2131755830), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(128479);
        RegByEmailUI.c(RegByEmailUI.this);
        AppMethodBeat.o(128479);
        return true;
      }
    });
    enableOptionMenu(false);
    this.ivb.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(128480);
        RegByEmailUI.b(RegByEmailUI.this);
        AppMethodBeat.o(128480);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.ivc.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(128481);
        RegByEmailUI.b(RegByEmailUI.this);
        AppMethodBeat.o(128481);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.ivc.setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(128482);
        if ((paramAnonymousInt == 6) || (paramAnonymousInt == 5))
        {
          if (!RegByEmailUI.d(RegByEmailUI.this).isChecked())
          {
            AppMethodBeat.o(128482);
            return false;
          }
          RegByEmailUI.c(RegByEmailUI.this);
          AppMethodBeat.o(128482);
          return true;
        }
        AppMethodBeat.o(128482);
        return false;
      }
    });
    this.ivc.setOnKeyListener(new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(128483);
        if ((66 == paramAnonymousInt) && (paramAnonymousKeyEvent.getAction() == 0))
        {
          if (!RegByEmailUI.d(RegByEmailUI.this).isChecked())
          {
            AppMethodBeat.o(128483);
            return false;
          }
          RegByEmailUI.c(RegByEmailUI.this);
          AppMethodBeat.o(128483);
          return true;
        }
        AppMethodBeat.o(128483);
        return false;
      }
    });
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(128484);
        RegByEmailUI.e(RegByEmailUI.this);
        AppMethodBeat.o(128484);
        return true;
      }
    });
    AppMethodBeat.o(128488);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128485);
    super.onCreate(paramBundle);
    paramBundle = getString(2131762295);
    if (d.CpN) {
      paramBundle = getString(2131755822) + getString(2131755263);
    }
    setMMTitle(paramBundle);
    com.tencent.mm.plugin.account.a.a.hYu.Lo();
    this.ive = t.cU(this);
    ad.i("MicroMsg.RegByEmailUI", "get google account:[%s]", new Object[] { this.ive });
    this.ivf = i.hTT.cM(this);
    if ((this.ivf != null) && (!this.ivf.isEmpty()))
    {
      ivg = new String[this.ivf.size()];
      this.ivf.keySet().toArray(ivg);
    }
    this.ihI = com.tencent.mm.plugin.b.a.fQQ();
    initView();
    AppMethodBeat.o(128485);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(128490);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      goBack();
      AppMethodBeat.o(128490);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(128490);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(128487);
    super.onPause();
    com.tencent.mm.kernel.g.aeS().b(481, this);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.afz();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.aeM()).append(",").append(getClass().getName()).append(",R500_100,");
    com.tencent.mm.kernel.g.afz();
    com.tencent.mm.plugin.b.a.K(false, com.tencent.mm.kernel.a.qN("R500_100") + ",2");
    AppMethodBeat.o(128487);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(128486);
    super.onResume();
    com.tencent.mm.kernel.g.aeS().a(481, this);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.afz();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.aeM()).append(",").append(getClass().getName()).append(",R500_100,");
    com.tencent.mm.kernel.g.afz();
    com.tencent.mm.plugin.b.a.K(true, com.tencent.mm.kernel.a.qN("R500_100") + ",1");
    com.tencent.mm.plugin.b.a.aUy("R500_100");
    AppMethodBeat.o(128486);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(128491);
    ad.i("MicroMsg.RegByEmailUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if ((this.fpP != null) && (this.fpP.isShowing()))
    {
      this.fpP.dismiss();
      this.fpP = null;
    }
    if (paramn.getType() != 481)
    {
      ad.e("MicroMsg.RegByEmailUI", "error cgi type callback:[%d]", new Object[] { Integer.valueOf(paramn.getType()) });
      AppMethodBeat.o(128491);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      com.tencent.mm.plugin.b.a.aUz("R500_200");
      paramString = new Intent(this, EmailVerifyUI.class);
      paramString.putExtra("email_address", this.evs);
      paramString.putExtra("password", this.ije);
      if ((this.ivf != null) && (!this.ivf.isEmpty()))
      {
        paramn = this.evs.split("@");
        if ((paramn != null) && (paramn.length == 2))
        {
          paramn = paramn[1];
          paramString.putExtra("email_login_page", (String)this.ivf.get(paramn));
        }
      }
      paramString = new com.tencent.mm.hellhoundlib.b.a().bd(paramString);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramString.adn(), "com/tencent/mm/plugin/account/ui/RegByEmailUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramString.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByEmailUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(128491);
      return;
    }
    int i;
    if (com.tencent.mm.plugin.account.a.a.hYu.a(this, paramInt1, paramInt2, paramString)) {
      i = 1;
    }
    while (i != 0)
    {
      AppMethodBeat.o(128491);
      return;
      switch (paramInt2)
      {
      default: 
        i = 0;
        break;
      case -7: 
        paramn = new StringBuilder();
        com.tencent.mm.kernel.g.afz();
        paramn = paramn.append(com.tencent.mm.kernel.a.aeM()).append(",").append(getClass().getName()).append(",R20_email_duplicate_confirm,");
        com.tencent.mm.kernel.g.afz();
        com.tencent.mm.plugin.b.a.pj(com.tencent.mm.kernel.a.qN("R20_email_duplicate_confirm") + ",3");
        h.b(this, 2131762296, 2131762282, 2131762298, 2131762297, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(128476);
            RegByEmailUI.this.finish();
            com.tencent.mm.plugin.b.a.aUz("L2_signup");
            Object localObject = new Intent(RegByEmailUI.this, LoginPasswordUI.class);
            ((Intent)localObject).putExtra("email_address", RegByEmailUI.g(RegByEmailUI.this));
            paramAnonymousDialogInterface = RegByEmailUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/account/ui/RegByEmailUI$12", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/plugin/account/ui/RegByEmailUI$12", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(128476);
          }
        }, null);
        i = 1;
        break;
      case -111: 
        h.j(this, 2131762285, 2131762282);
        i = 1;
        break;
      case -34: 
        Toast.makeText(this, 2131762280, 0).show();
        i = 1;
        break;
      case -75: 
        h.j(this, 2131755266, 2131762275);
        i = 1;
      }
    }
    if (!bt.isNullOrNil(paramString))
    {
      paramString = bw.K(paramString, "e");
      if ((paramString != null) && (paramString.size() > 0))
      {
        paramString = (String)paramString.get(".e.Content");
        if (!bt.isNullOrNil(paramString))
        {
          h.c(this, paramString, getString(2131762282), true);
          AppMethodBeat.o(128491);
          return;
        }
      }
    }
    Toast.makeText(this, getString(2131762293, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    AppMethodBeat.o(128491);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByEmailUI
 * JD-Core Version:    0.7.0.1
 */