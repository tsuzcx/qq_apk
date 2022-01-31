package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.av;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;

public class RegByQQAuthUI
  extends MMActivity
  implements f
{
  private String account;
  private String cDs;
  private String crs;
  private ProgressDialog eeN = null;
  private EditText gJl = null;
  private int gJm;
  private String gwh;
  
  public int getLayoutId()
  {
    return 2130970560;
  }
  
  public void initView()
  {
    AppMethodBeat.i(125505);
    this.gJm = getIntent().getIntExtra("RegByQQ_BindUin", 0);
    this.gwh = getIntent().getStringExtra("RegByQQ_RawPsw");
    this.account = getIntent().getStringExtra("RegByQQ_Account");
    this.crs = getIntent().getStringExtra("RegByQQ_Ticket");
    this.cDs = getIntent().getStringExtra("RegByQQ_Nick");
    ab.v("MicroMsg.RegByQQAuthUI", "values : bindUin:" + this.gJm + "  pass:" + this.gwh + "  ticket:" + this.crs);
    this.gJl = ((EditText)findViewById(2131827169));
    if ((this.cDs != null) && (!this.cDs.equals(""))) {
      this.gJl.setText(this.cDs);
    }
    setMMTitle(2131302475);
    addTextOptionMenu(0, getString(2131297013), new RegByQQAuthUI.1(this));
    setBackBtn(new RegByQQAuthUI.2(this));
    AppMethodBeat.o(125505);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(125501);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(125501);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(125502);
    super.onDestroy();
    AppMethodBeat.o(125502);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(125504);
    super.onPause();
    g.Rc().b(126, this);
    AppMethodBeat.o(125504);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(125503);
    super.onResume();
    g.Rc().a(126, this);
    AppMethodBeat.o(125503);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(125506);
    ab.i("MicroMsg.RegByQQAuthUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.eeN != null)
    {
      this.eeN.dismiss();
      this.eeN = null;
    }
    if (!bo.cB(this))
    {
      AppMethodBeat.o(125506);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      switch (paramm.getType())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(125506);
        return;
        com.tencent.mm.kernel.a.unhold();
        av.flM.ao("login_user_name", this.account);
        paramString = new Intent(this, BindMContactIntroUI.class);
        paramString.putExtra("key_upload_scene", 1);
        paramString.putExtra("skip", true);
        paramm = com.tencent.mm.plugin.account.a.a.gmO.bm(this);
        paramm.addFlags(67108864);
        paramm.putExtra("LauncherUI.enter_from_reg", true);
        MMWizardActivity.b(this, paramString, paramm);
      }
    }
    if (paramm.getType() == 126)
    {
      paramm = com.tencent.mm.h.a.kO(paramString);
      if (paramm != null)
      {
        paramm.a(this, null, null);
        AppMethodBeat.o(125506);
        return;
      }
    }
    int i;
    if (com.tencent.mm.plugin.account.a.a.gmP.a(getContext(), paramInt1, paramInt2, paramString)) {
      i = 1;
    }
    while (i != 0)
    {
      AppMethodBeat.o(125506);
      return;
      if (paramInt1 == 4) {}
      switch (paramInt2)
      {
      default: 
        i = 0;
        break;
      case -1: 
        if (g.Rc().adt() == 5)
        {
          h.h(this, 2131301790, 2131301789);
          i = 1;
        }
        break;
      case -3: 
        h.h(this, 2131296923, 2131302473);
        i = 1;
        break;
      case -4: 
        h.h(this, 2131296922, 2131302473);
        i = 1;
        break;
      case -12: 
        h.h(this, 2131302474, 2131302473);
        i = 1;
        break;
      case -11: 
        h.h(this, 2131302472, 2131302473);
        i = 1;
        break;
      case -72: 
        h.h(getContext(), 2131302471, 2131297087);
        i = 1;
        break;
      case -75: 
        h.h(getContext(), 2131296532, 2131297087);
        i = 1;
      }
    }
    Toast.makeText(this, getString(2131300088, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    AppMethodBeat.o(125506);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByQQAuthUI
 * JD-Core Version:    0.7.0.1
 */