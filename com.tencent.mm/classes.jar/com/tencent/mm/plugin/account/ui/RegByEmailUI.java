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
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.ab;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMAutoCompleteTextView;
import java.util.Map;
import java.util.Set;

public class RegByEmailUI
  extends MMActivity
  implements com.tencent.mm.ak.i
{
  private static String[] kpB;
  private String fuD;
  private ProgressDialog gtM = null;
  private String kbV;
  private String kdq;
  private Map<String, String> kpA;
  private MMAutoCompleteTextView kpw;
  private EditText kpx;
  private CheckBox kpy;
  private String kpz;
  
  private void goBack()
  {
    AppMethodBeat.i(128489);
    com.tencent.mm.ui.base.h.a(this, 2131764345, 2131764348, 2131755921, 2131755761, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(128474);
        com.tencent.mm.plugin.b.a.bwV(RegByEmailUI.f(RegByEmailUI.this));
        RegByEmailUI.this.hideVKB();
        RegByEmailUI.this.finish();
        AppMethodBeat.o(128474);
      }
    }, null);
    AppMethodBeat.o(128489);
  }
  
  public int getLayoutId()
  {
    return 2131496081;
  }
  
  public void initView()
  {
    AppMethodBeat.i(128488);
    this.kpw = ((MMAutoCompleteTextView)findViewById(2131306789));
    this.kpx = ((EditText)findViewById(2131306796));
    this.kpy = ((CheckBox)findViewById(2131296588));
    if (!Util.isNullOrNil(this.kpz))
    {
      this.kpx.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(128473);
          RegByEmailUI.a(RegByEmailUI.this).requestFocus();
          AppMethodBeat.o(128473);
        }
      }, 500L);
      this.kpw.setText(this.kpz);
    }
    if (kpB != null)
    {
      d locald = new d(this, kpB, "@");
      this.kpw.setSpilter("@");
      this.kpw.setDropDownAnchor(2131306790);
      this.kpw.setDropDownVerticalOffset(this.kpw.getPaddingBottom());
      this.kpw.setAdapter(locald);
    }
    findViewById(2131296587).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(128477);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/RegByEmailUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        Util.jump(RegByEmailUI.this, RegByEmailUI.this.getString(2131766959, new Object[] { LocaleUtil.getApplicationLanguage(), LocaleUtil.getCurrentCountryCode() }));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByEmailUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(128477);
      }
    });
    this.kpy.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(128478);
        RegByEmailUI.b(RegByEmailUI.this);
        AppMethodBeat.o(128478);
      }
    });
    addTextOptionMenu(0, getString(2131755916), new MenuItem.OnMenuItemClickListener()
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
    this.kpw.addTextChangedListener(new TextWatcher()
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
    this.kpx.addTextChangedListener(new TextWatcher()
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
    this.kpx.setOnEditorActionListener(new TextView.OnEditorActionListener()
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
    this.kpx.setOnKeyListener(new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(128483);
        b localb = new b();
        localb.bm(paramAnonymousView);
        localb.pH(paramAnonymousInt);
        localb.bm(paramAnonymousKeyEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/RegByEmailUI$8", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.axR());
        if ((66 == paramAnonymousInt) && (paramAnonymousKeyEvent.getAction() == 0))
        {
          if (!RegByEmailUI.d(RegByEmailUI.this).isChecked())
          {
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/account/ui/RegByEmailUI$8", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
            AppMethodBeat.o(128483);
            return false;
          }
          RegByEmailUI.c(RegByEmailUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/account/ui/RegByEmailUI$8", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
          AppMethodBeat.o(128483);
          return true;
        }
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/account/ui/RegByEmailUI$8", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
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
    paramBundle = getString(2131764361);
    if ((com.tencent.mm.protocal.d.KyR) || (BuildInfo.IS_FLAVOR_BLUE)) {
      paramBundle = getString(2131755908) + com.tencent.mm.cc.h.jr(this);
    }
    setMMTitle(paramBundle);
    com.tencent.mm.plugin.account.a.a.jRu.Xc();
    this.kpz = com.tencent.mm.platformtools.t.dy(this);
    Log.i("MicroMsg.RegByEmailUI", "get google account:[%s]", new Object[] { this.kpz });
    this.kpA = com.tencent.mm.platformtools.i.jMH.dq(this);
    if ((this.kpA != null) && (!this.kpA.isEmpty()))
    {
      kpB = new String[this.kpA.size()];
      this.kpA.keySet().toArray(kpB);
    }
    this.kbV = com.tencent.mm.plugin.b.a.bpZ();
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
    g.azz().b(481, this);
    StringBuilder localStringBuilder = new StringBuilder();
    g.aAf();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R500_100,");
    g.aAf();
    com.tencent.mm.plugin.b.a.j(false, com.tencent.mm.kernel.a.FN("R500_100") + ",2");
    AppMethodBeat.o(128487);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(128486);
    super.onResume();
    g.azz().a(481, this);
    StringBuilder localStringBuilder = new StringBuilder();
    g.aAf();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R500_100,");
    g.aAf();
    com.tencent.mm.plugin.b.a.j(true, com.tencent.mm.kernel.a.FN("R500_100") + ",1");
    com.tencent.mm.plugin.b.a.bwU("R500_100");
    AppMethodBeat.o(128486);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(128491);
    Log.i("MicroMsg.RegByEmailUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if ((this.gtM != null) && (this.gtM.isShowing()))
    {
      this.gtM.dismiss();
      this.gtM = null;
    }
    if (paramq.getType() != 481)
    {
      Log.e("MicroMsg.RegByEmailUI", "error cgi type callback:[%d]", new Object[] { Integer.valueOf(paramq.getType()) });
      AppMethodBeat.o(128491);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      com.tencent.mm.plugin.b.a.bwV("R500_200");
      paramString = new Intent(this, EmailVerifyUI.class);
      paramString.putExtra("email_address", this.fuD);
      paramString.putExtra("password", this.kdq);
      if ((this.kpA != null) && (!this.kpA.isEmpty()))
      {
        paramq = this.fuD.split("@");
        if ((paramq != null) && (paramq.length == 2))
        {
          paramq = paramq[1];
          paramString.putExtra("email_login_page", (String)this.kpA.get(paramq));
        }
      }
      paramString = new com.tencent.mm.hellhoundlib.b.a().bl(paramString);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramString.axQ(), "com/tencent/mm/plugin/account/ui/RegByEmailUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramString.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByEmailUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(128491);
      return;
    }
    int i;
    if (com.tencent.mm.plugin.account.a.a.jRu.a(this, paramInt1, paramInt2, paramString)) {
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
        paramq = new StringBuilder();
        g.aAf();
        paramq = paramq.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R20_email_duplicate_confirm,");
        g.aAf();
        com.tencent.mm.plugin.b.a.DX(com.tencent.mm.kernel.a.FN("R20_email_duplicate_confirm") + ",3");
        com.tencent.mm.ui.base.h.a(this, 2131764362, 2131764348, 2131764364, 2131764363, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(128476);
            RegByEmailUI.this.finish();
            com.tencent.mm.plugin.b.a.bwV("L2_signup");
            Object localObject = new Intent(RegByEmailUI.this, LoginPasswordUI.class);
            ((Intent)localObject).putExtra("email_address", RegByEmailUI.g(RegByEmailUI.this));
            paramAnonymousDialogInterface = RegByEmailUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/account/ui/RegByEmailUI$12", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/plugin/account/ui/RegByEmailUI$12", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(128476);
          }
        }, null);
        i = 1;
        break;
      case -111: 
        com.tencent.mm.ui.base.h.n(this, 2131764351, 2131764348);
        i = 1;
        break;
      case -34: 
        Toast.makeText(this, 2131764346, 0).show();
        i = 1;
        break;
      case -75: 
        com.tencent.mm.ui.base.h.n(this, 2131755301, 2131764341);
        i = 1;
      }
    }
    if (!Util.isNullOrNil(paramString))
    {
      paramString = XmlParser.parseXml(paramString, "e", null);
      if ((paramString != null) && (paramString.size() > 0))
      {
        paramString = (String)paramString.get(".e.Content");
        if (!Util.isNullOrNil(paramString))
        {
          com.tencent.mm.ui.base.h.c(this, paramString, getString(2131764348), true);
          AppMethodBeat.o(128491);
          return;
        }
      }
    }
    Toast.makeText(this, getString(2131764359, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    AppMethodBeat.o(128491);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByEmailUI
 * JD-Core Version:    0.7.0.1
 */