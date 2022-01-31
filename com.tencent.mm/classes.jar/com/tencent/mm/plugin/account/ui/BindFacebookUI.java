package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.plugin.account.friend.a.v;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.g.a.b;
import com.tencent.mm.ui.g.a.c;
import com.tencent.mm.ui.g.a.c.a;

public class BindFacebookUI
  extends MMWizardActivity
  implements f
{
  private static final String[] gCv = { "public_profile" };
  private c gAP;
  private ProgressDialog gCs;
  private DialogInterface.OnCancelListener gCt;
  private v gCu;
  
  public int getLayoutId()
  {
    return 2130968843;
  }
  
  public void initView()
  {
    AppMethodBeat.i(124736);
    this.gAP = new c(getString(2131306163));
    this.gCt = new BindFacebookUI.1(this);
    addTextOptionMenu(0, getString(2131296980), new BindFacebookUI.2(this));
    setMMTitle(2131297546);
    Object localObject = (TextView)findViewById(2131821785);
    ((TextView)localObject).setVisibility(4);
    ((TextView)localObject).setText(2131297545);
    localObject = (Button)findViewById(2131821786);
    ((Button)localObject).setVisibility(0);
    ((Button)localObject).setOnClickListener(new BindFacebookUI.3(this));
    AppMethodBeat.o(124736);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(124732);
    super.onCreate(paramBundle);
    AppMethodBeat.o(124732);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(124733);
    super.onDestroy();
    AppMethodBeat.o(124733);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(124735);
    super.onPause();
    g.Rc().b(183, this);
    AppMethodBeat.o(124735);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(124734);
    super.onResume();
    g.Rc().a(183, this);
    initView();
    AppMethodBeat.o(124734);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(124737);
    if (paramm.getType() != 183)
    {
      AppMethodBeat.o(124737);
      return;
    }
    if (this.gCs != null) {
      this.gCs.dismiss();
    }
    if (a.gmP.a(getContext(), paramInt1, paramInt2, paramString))
    {
      AppMethodBeat.o(124737);
      return;
    }
    int i = ((v)paramm).opType;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (i == 1)
      {
        ((j)g.E(j.class)).YF().arF("facebookapp");
        ((j)g.E(j.class)).bPQ().Ts("facebookapp");
      }
      Oi(1);
      AppMethodBeat.o(124737);
      return;
    }
    if ((paramInt1 == 4) && (paramInt2 == -67))
    {
      Toast.makeText(this, 2131299622, 1).show();
      AppMethodBeat.o(124737);
      return;
    }
    if ((paramInt1 == 4) && (paramInt2 == -5))
    {
      if (i == 1) {}
      for (paramInt1 = 2131299616;; paramInt1 = 2131299625)
      {
        Toast.makeText(this, paramInt1, 1).show();
        AppMethodBeat.o(124737);
        return;
      }
    }
    if (i == 0) {}
    for (paramInt1 = 2131298602;; paramInt1 = 2131298597)
    {
      Toast.makeText(this, paramInt1, 1).show();
      AppMethodBeat.o(124737);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    implements c.a
  {
    private a() {}
    
    public final void a(b paramb)
    {
      AppMethodBeat.i(124730);
      ab.d("MicroMsg.BindFacebookUI", "onError:" + paramb.getMessage());
      com.tencent.mm.ui.base.h.b(BindFacebookUI.this, paramb.getMessage(), BindFacebookUI.this.getString(2131298597), true);
      BindFacebookUI.dA(false);
      AppMethodBeat.o(124730);
    }
    
    public final void a(com.tencent.mm.ui.g.a.e parame)
    {
      AppMethodBeat.i(124729);
      ab.d("MicroMsg.BindFacebookUI", "onFacebookError:" + parame.Aoe);
      com.tencent.mm.ui.base.h.b(BindFacebookUI.this, parame.getMessage(), BindFacebookUI.this.getString(2131298597), true);
      BindFacebookUI.dA(false);
      AppMethodBeat.o(124729);
    }
    
    public final void onCancel()
    {
      AppMethodBeat.i(124731);
      ab.d("MicroMsg.BindFacebookUI", "onCancel");
      BindFacebookUI.dA(false);
      AppMethodBeat.o(124731);
    }
    
    public final void u(Bundle paramBundle)
    {
      AppMethodBeat.i(124728);
      ab.d("MicroMsg.BindFacebookUI", "token:" + BindFacebookUI.c(BindFacebookUI.this).gsH);
      g.RL().Ru().set(65830, BindFacebookUI.c(BindFacebookUI.this).gsH);
      if (BindFacebookUI.c(BindFacebookUI.this).AnR != 0L) {
        g.RL().Ru().set(65832, Long.valueOf(BindFacebookUI.c(BindFacebookUI.this).AnR));
      }
      paramBundle = BindFacebookUI.this.getString(2131297087);
      String str = BindFacebookUI.this.getString(2131299619);
      BindFacebookUI.a(BindFacebookUI.this, ProgressDialog.show(BindFacebookUI.this, paramBundle, str, true));
      BindFacebookUI.e(BindFacebookUI.this).setOnCancelListener(BindFacebookUI.d(BindFacebookUI.this));
      BindFacebookUI.a(BindFacebookUI.this, new v(1, BindFacebookUI.c(BindFacebookUI.this).gsH));
      g.Rc().a(BindFacebookUI.a(BindFacebookUI.this), 0);
      BindFacebookUI.dA(true);
      AppMethodBeat.o(124728);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.BindFacebookUI
 * JD-Core Version:    0.7.0.1
 */