package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMAutoCompleteTextView;
import com.tencent.mm.ui.base.h;
import java.util.Map;
import java.util.Set;

public class RegByEmailUI
  extends MMActivity
  implements f
{
  private static String[] gHG;
  private String dqF;
  private ProgressDialog eeN = null;
  private MMAutoCompleteTextView gHB;
  private EditText gHC;
  private CheckBox gHD;
  private String gHE;
  private Map<String, String> gHF;
  private String guI;
  private String gwh;
  
  private void goBack()
  {
    AppMethodBeat.i(125317);
    h.a(this, 2131302382, 2131302385, 2131297018, 2131296888, new RegByEmailUI.2(this), null);
    AppMethodBeat.o(125317);
  }
  
  public int getLayoutId()
  {
    return 2130970552;
  }
  
  public void initView()
  {
    AppMethodBeat.i(125316);
    this.gHB = ((MMAutoCompleteTextView)findViewById(2131827129));
    this.gHC = ((EditText)findViewById(2131827130));
    this.gHD = ((CheckBox)findViewById(2131826244));
    if (!bo.isNullOrNil(this.gHE))
    {
      this.gHC.postDelayed(new RegByEmailUI.1(this), 500L);
      this.gHB.setText(this.gHE);
    }
    if (gHG != null)
    {
      c localc = new c(this, gHG, "@");
      this.gHB.setSpilter("@");
      this.gHB.setDropDownAnchor(2131827128);
      this.gHB.setDropDownVerticalOffset(this.gHB.getPaddingBottom());
      this.gHB.setAdapter(localc);
    }
    findViewById(2131826245).setOnClickListener(new RegByEmailUI.5(this));
    this.gHD.setOnCheckedChangeListener(new RegByEmailUI.6(this));
    addTextOptionMenu(0, getString(2131297013), new RegByEmailUI.7(this));
    enableOptionMenu(false);
    this.gHB.addTextChangedListener(new RegByEmailUI.8(this));
    this.gHC.addTextChangedListener(new RegByEmailUI.9(this));
    this.gHC.setOnEditorActionListener(new RegByEmailUI.10(this));
    this.gHC.setOnKeyListener(new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(125311);
        if ((66 == paramAnonymousInt) && (paramAnonymousKeyEvent.getAction() == 0))
        {
          if (!RegByEmailUI.d(RegByEmailUI.this).isChecked())
          {
            AppMethodBeat.o(125311);
            return false;
          }
          RegByEmailUI.c(RegByEmailUI.this);
          AppMethodBeat.o(125311);
          return true;
        }
        AppMethodBeat.o(125311);
        return false;
      }
    });
    setBackBtn(new RegByEmailUI.12(this));
    AppMethodBeat.o(125316);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(125313);
    super.onCreate(paramBundle);
    paramBundle = getString(2131302398);
    if (d.whK) {
      paramBundle = getString(2131297005) + getString(2131296529);
    }
    setMMTitle(paramBundle);
    com.tencent.mm.plugin.account.a.a.gmP.BR();
    this.gHE = w.cz(this);
    ab.i("MicroMsg.RegByEmailUI", "get google account:[%s]", new Object[] { this.gHE });
    this.gHF = j.gjp.cr(this);
    if ((this.gHF != null) && (!this.gHF.isEmpty()))
    {
      gHG = new String[this.gHF.size()];
      this.gHF.keySet().toArray(gHG);
    }
    this.guI = com.tencent.mm.plugin.b.a.awy();
    initView();
    AppMethodBeat.o(125313);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(125318);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      goBack();
      AppMethodBeat.o(125318);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(125318);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(125315);
    super.onPause();
    g.Rc().b(481, this);
    StringBuilder localStringBuilder = new StringBuilder();
    g.RJ();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.QX()).append(",").append(getClass().getName()).append(",R500_100,");
    g.RJ();
    com.tencent.mm.plugin.b.a.g(false, com.tencent.mm.kernel.a.mx("R500_100") + ",2");
    AppMethodBeat.o(125315);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(125314);
    super.onResume();
    g.Rc().a(481, this);
    StringBuilder localStringBuilder = new StringBuilder();
    g.RJ();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.QX()).append(",").append(getClass().getName()).append(",R500_100,");
    g.RJ();
    com.tencent.mm.plugin.b.a.g(true, com.tencent.mm.kernel.a.mx("R500_100") + ",1");
    com.tencent.mm.plugin.b.a.xC("R500_100");
    AppMethodBeat.o(125314);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(125319);
    ab.i("MicroMsg.RegByEmailUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if ((this.eeN != null) && (this.eeN.isShowing()))
    {
      this.eeN.dismiss();
      this.eeN = null;
    }
    if (paramm.getType() != 481)
    {
      ab.e("MicroMsg.RegByEmailUI", "error cgi type callback:[%d]", new Object[] { Integer.valueOf(paramm.getType()) });
      AppMethodBeat.o(125319);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      com.tencent.mm.plugin.b.a.xD("R500_200");
      paramString = new Intent(this, EmailVerifyUI.class);
      paramString.putExtra("email_address", this.dqF);
      paramString.putExtra("password", this.gwh);
      if ((this.gHF != null) && (!this.gHF.isEmpty()))
      {
        paramm = this.dqF.split("@");
        if ((paramm != null) && (paramm.length == 2))
        {
          paramm = paramm[1];
          paramString.putExtra("email_login_page", (String)this.gHF.get(paramm));
        }
      }
      startActivity(paramString);
      AppMethodBeat.o(125319);
      return;
    }
    int i;
    if (com.tencent.mm.plugin.account.a.a.gmP.a(this, paramInt1, paramInt2, paramString)) {
      i = 1;
    }
    while (i != 0)
    {
      AppMethodBeat.o(125319);
      return;
      switch (paramInt2)
      {
      default: 
        i = 0;
        break;
      case -7: 
        paramm = new StringBuilder();
        g.RJ();
        paramm = paramm.append(com.tencent.mm.kernel.a.QX()).append(",").append(getClass().getName()).append(",R20_email_duplicate_confirm,");
        g.RJ();
        com.tencent.mm.plugin.b.a.xE(com.tencent.mm.kernel.a.mx("R20_email_duplicate_confirm") + ",3");
        h.a(this, 2131302399, 2131302385, 2131302401, 2131302400, new RegByEmailUI.4(this), null);
        i = 1;
        break;
      case -111: 
        h.h(this, 2131302388, 2131302385);
        i = 1;
        break;
      case -34: 
        Toast.makeText(this, 2131302383, 0).show();
        i = 1;
        break;
      case -75: 
        h.h(this, 2131296532, 2131302378);
        i = 1;
      }
    }
    if (!bo.isNullOrNil(paramString))
    {
      paramString = br.F(paramString, "e");
      if ((paramString != null) && (paramString.size() > 0))
      {
        paramString = (String)paramString.get(".e.Content");
        if (!bo.isNullOrNil(paramString))
        {
          h.b(this, paramString, getString(2131302385), true);
          AppMethodBeat.o(125319);
          return;
        }
      }
    }
    Toast.makeText(this, getString(2131302396, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    AppMethodBeat.o(125319);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByEmailUI
 * JD-Core Version:    0.7.0.1
 */