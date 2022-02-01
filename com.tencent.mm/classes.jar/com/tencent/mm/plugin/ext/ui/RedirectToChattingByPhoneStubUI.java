package com.tencent.mm.plugin.ext.ui;

import android.app.Activity;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.model.az;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

public class RedirectToChattingByPhoneStubUI
  extends HellActivity
  implements g
{
  private p quM = null;
  
  public final boolean hideVKB()
  {
    AppMethodBeat.i(24515);
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    if (localInputMethodManager == null)
    {
      AppMethodBeat.o(24515);
      return false;
    }
    Object localObject = getCurrentFocus();
    if (localObject == null)
    {
      AppMethodBeat.o(24515);
      return false;
    }
    localObject = ((View)localObject).getWindowToken();
    if (localObject == null)
    {
      AppMethodBeat.o(24515);
      return false;
    }
    try
    {
      bool = localInputMethodManager.hideSoftInputFromWindow((IBinder)localObject, 0);
      ac.v("MicroMsg.RedirectToChattingByPhoneStubUI", "hide VKB result %B", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(24515);
      return bool;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        ac.e("MicroMsg.RedirectToChattingByPhoneStubUI", "hide VKB exception %s", new Object[] { localIllegalArgumentException });
        boolean bool = false;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(24512);
    super.onCreate(paramBundle);
    getString(2131755936);
    this.quM = h.b(this, "", false, null);
    ap.n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(24511);
        RedirectToChattingByPhoneStubUI.this.hideVKB();
        AppMethodBeat.o(24511);
      }
    }, 500L);
    az.agi().a(106, this);
    AppMethodBeat.o(24512);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(24513);
    super.onDestroy();
    az.agi().b(106, this);
    if (this.quM != null)
    {
      this.quM.dismiss();
      this.quM = null;
    }
    AppMethodBeat.o(24513);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(24514);
    finish();
    AppMethodBeat.o(24514);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.ui.RedirectToChattingByPhoneStubUI
 * JD-Core Version:    0.7.0.1
 */