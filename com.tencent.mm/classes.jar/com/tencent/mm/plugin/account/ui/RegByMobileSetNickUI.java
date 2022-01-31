package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.av;
import com.tencent.mm.model.r;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.plugin.account.bind.ui.BindQQUI;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.protocal.protobuf.aek;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.MMEditText.c;

@Deprecated
public class RegByMobileSetNickUI
  extends MMActivity
  implements f
{
  private String czF;
  private ProgressDialog eeN = null;
  private boolean gIA;
  private EditText gIy;
  private q gIz = null;
  
  public int getLayoutId()
  {
    return 2130970558;
  }
  
  public void initView()
  {
    AppMethodBeat.i(125433);
    setMMTitle(2131302440);
    this.gIy = ((EditText)findViewById(2131827156));
    this.gIy.addTextChangedListener(new MMEditText.c(this.gIy, null, 16));
    addTextOptionMenu(0, getString(2131296964), new RegByMobileSetNickUI.1(this));
    setBackBtn(new RegByMobileSetNickUI.2(this));
    AppMethodBeat.o(125433);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(125431);
    super.onCreate(paramBundle);
    this.gIA = getIntent().getBooleanExtra("is_sync_addr", false);
    this.czF = getIntent().getExtras().getString("bindmcontact_mobile");
    initView();
    g.Rc().a(126, this);
    AppMethodBeat.o(125431);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(125432);
    if (this.gIz != null)
    {
      q localq = this.gIz;
      t localt = localq.gHA;
      localt.cancel();
      localt.caS.stopTimer();
      localt.reset();
      localq.text = null;
    }
    g.Rc().b(126, this);
    super.onDestroy();
    AppMethodBeat.o(125432);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(125434);
    if (paramInt == 4)
    {
      finish();
      AppMethodBeat.o(125434);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(125434);
    return bool;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(125435);
    ab.i("MicroMsg.RegByMobileSetNickUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.eeN != null)
    {
      this.eeN.dismiss();
      this.eeN = null;
    }
    if (!bo.cB(this))
    {
      AppMethodBeat.o(125435);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramInt1 = r.Zr();
      ab.d("MicroMsg.RegByMobileSetNickUI", "Reg By mobile status = " + paramInt1 + " isSync = " + this.gIA);
      if (this.gIA)
      {
        paramInt1 &= 0xFFFDFFFF;
        l.dx(true);
        getApplicationContext();
        com.tencent.mm.platformtools.a.aof();
        ab.d("MicroMsg.RegByMobileSetNickUI", "Reg By mobile update = ".concat(String.valueOf(paramInt1)));
        g.RL().Ru().set(7, Integer.valueOf(paramInt1));
        if (this.gIA) {
          break label329;
        }
      }
      label329:
      for (paramInt1 = 1;; paramInt1 = 2)
      {
        paramString = new aek();
        paramString.wXn = 17;
        paramString.pKC = paramInt1;
        ((j)g.E(j.class)).Yz().c(new j.a(23, paramString));
        com.tencent.mm.plugin.account.a.a.gmP.BO();
        av.flM.ao("login_user_name", this.czF);
        paramString = com.tencent.mm.plugin.account.a.a.gmO.bm(this);
        paramString.putExtra("LauncherUI.enter_from_reg", true);
        paramString.addFlags(67108864);
        if (!((u)paramm).fPS) {
          break label334;
        }
        MMWizardActivity.b(this, new Intent(this, BindQQUI.class).putExtra("bindqq_regbymobile", 1), paramString);
        AppMethodBeat.o(125435);
        return;
        paramInt1 |= 0x20000;
        break;
      }
      label334:
      MMWizardActivity.b(this, new Intent(this, BindFacebookUI.class), paramString);
      AppMethodBeat.o(125435);
      return;
    }
    if (paramm.getType() == 126)
    {
      paramm = com.tencent.mm.h.a.kO(paramString);
      if (paramm != null)
      {
        paramm.a(this, null, null);
        AppMethodBeat.o(125435);
        return;
      }
    }
    int i;
    if (com.tencent.mm.plugin.account.a.a.gmP.a(getContext(), paramInt1, paramInt2, paramString)) {
      i = 1;
    }
    while (i != 0)
    {
      AppMethodBeat.o(125435);
      return;
      switch (paramInt1)
      {
      }
      do
      {
        i = 0;
        break;
        if ((paramInt2 == -7) || (paramInt2 == -10))
        {
          h.h(this, 2131302377, 2131302378);
          i = 1;
          break;
        }
      } while (paramInt2 != -75);
      h.h(this, 2131296532, 2131302378);
      i = 1;
    }
    Toast.makeText(this, getString(2131300088, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    AppMethodBeat.o(125435);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileSetNickUI
 * JD-Core Version:    0.7.0.1
 */