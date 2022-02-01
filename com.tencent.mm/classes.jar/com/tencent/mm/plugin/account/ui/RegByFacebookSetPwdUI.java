package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.b.a.a;
import com.tencent.mm.plugin.account.friend.a.an;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.base.h;

public class RegByFacebookSetPwdUI
  extends SetPwdUI
{
  protected final ProgressDialog a(Context paramContext, String paramString1, String paramString2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(196889);
    paramContext = h.a(paramContext, getString(2131764376), true, paramOnCancelListener);
    AppMethodBeat.o(196889);
    return paramContext;
  }
  
  protected final void a(a.a parama)
  {
    AppMethodBeat.i(128504);
    switch (2.kiH[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(128504);
      return;
      h.n(this, 2131764372, 2131764374);
      AppMethodBeat.o(128504);
      return;
      h.n(this, 2131764373, 2131764374);
      AppMethodBeat.o(128504);
      return;
      h.n(this, 2131767027, 2131755802);
      AppMethodBeat.o(128504);
      return;
      h.n(this, 2131767031, 2131755802);
    }
  }
  
  protected final int bpA()
  {
    return 382;
  }
  
  protected final q bpx()
  {
    AppMethodBeat.i(128501);
    an localan = new an(this.ksb);
    AppMethodBeat.o(128501);
    return localan;
  }
  
  protected final String bpy()
  {
    AppMethodBeat.i(128502);
    String str = ((EditText)findViewById(2131306802)).getText().toString();
    AppMethodBeat.o(128502);
    return str;
  }
  
  protected final String bpz()
  {
    AppMethodBeat.i(128503);
    String str = ((EditText)findViewById(2131306801)).getText().toString();
    AppMethodBeat.o(128503);
    return str;
  }
  
  public int getLayoutId()
  {
    return 2131496085;
  }
  
  public void initView()
  {
    AppMethodBeat.i(128499);
    setMMTitle(2131764385);
    AppMethodBeat.o(128499);
  }
  
  protected final boolean o(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(128505);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      g.aAh().azQ().set(57, Integer.valueOf(0));
      h.d(this, getString(2131764383, new Object[] { (String)g.aAh().azQ().get(5, null) }), getString(2131764374), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(128495);
          RegByFacebookSetPwdUI.this.finish();
          AppMethodBeat.o(128495);
        }
      });
      AppMethodBeat.o(128505);
      return true;
    }
    boolean bool = n(paramInt1, paramInt2, paramString);
    AppMethodBeat.o(128505);
    return bool;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128497);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(128497);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128498);
    super.onDestroy();
    AppMethodBeat.o(128498);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByFacebookSetPwdUI
 * JD-Core Version:    0.7.0.1
 */