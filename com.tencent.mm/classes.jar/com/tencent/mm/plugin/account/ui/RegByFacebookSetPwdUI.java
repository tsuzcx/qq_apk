package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.b.a.a;
import com.tencent.mm.plugin.account.friend.a.ak;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.h;

public class RegByFacebookSetPwdUI
  extends SetPwdUI
{
  protected final ProgressDialog a(Context paramContext, String paramString, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(125328);
    paramContext = h.b(paramContext, getString(2131302413), true, paramOnCancelListener);
    AppMethodBeat.o(125328);
    return paramContext;
  }
  
  protected final void a(a.a parama)
  {
    AppMethodBeat.i(125332);
    switch (RegByFacebookSetPwdUI.2.gBc[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(125332);
      return;
      h.h(this, 2131302409, 2131302411);
      AppMethodBeat.o(125332);
      return;
      h.h(this, 2131302410, 2131302411);
      AppMethodBeat.o(125332);
      return;
      h.h(this, 2131304499, 2131296924);
      AppMethodBeat.o(125332);
      return;
      h.h(this, 2131304501, 2131296924);
    }
  }
  
  protected final m arI()
  {
    AppMethodBeat.i(125329);
    ak localak = new ak(this.gKa);
    AppMethodBeat.o(125329);
    return localak;
  }
  
  protected final String arJ()
  {
    AppMethodBeat.i(125330);
    String str = ((EditText)findViewById(2131827136)).getText().toString();
    AppMethodBeat.o(125330);
    return str;
  }
  
  protected final String arK()
  {
    AppMethodBeat.i(125331);
    String str = ((EditText)findViewById(2131827137)).getText().toString();
    AppMethodBeat.o(125331);
    return str;
  }
  
  protected final int arL()
  {
    return 382;
  }
  
  public int getLayoutId()
  {
    return 2130970555;
  }
  
  public void initView()
  {
    AppMethodBeat.i(138726);
    setMMTitle(2131302422);
    AppMethodBeat.o(138726);
  }
  
  protected final boolean m(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(125333);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      g.RL().Ru().set(57, Integer.valueOf(0));
      h.a(this, getString(2131302420, new Object[] { (String)g.RL().Ru().get(5, null) }), getString(2131302411), new RegByFacebookSetPwdUI.1(this));
      AppMethodBeat.o(125333);
      return true;
    }
    boolean bool = l(paramInt1, paramInt2, paramString);
    AppMethodBeat.o(125333);
    return bool;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(125325);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(125325);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(125326);
    super.onDestroy();
    AppMethodBeat.o(125326);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByFacebookSetPwdUI
 * JD-Core Version:    0.7.0.1
 */