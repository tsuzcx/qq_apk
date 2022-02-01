package com.tencent.mm.plugin.ext.ui;

import android.app.Activity;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.model.bg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.base.h;

public class RedirectToChattingByPhoneStubUI
  extends HellActivity
  implements i
{
  private com.tencent.mm.ui.base.q sOk = null;
  
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
      Log.v("MicroMsg.RedirectToChattingByPhoneStubUI", "hide VKB result %B", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(24515);
      return bool;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        Log.e("MicroMsg.RedirectToChattingByPhoneStubUI", "hide VKB exception %s", new Object[] { localIllegalArgumentException });
        boolean bool = false;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(24512);
    super.onCreate(paramBundle);
    getString(2131756029);
    this.sOk = h.a(this, "", false, null);
    MMHandlerThread.postToMainThreadDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(24511);
        RedirectToChattingByPhoneStubUI.this.hideVKB();
        AppMethodBeat.o(24511);
      }
    }, 500L);
    bg.azz().a(106, this);
    AppMethodBeat.o(24512);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(24513);
    super.onDestroy();
    bg.azz().b(106, this);
    if (this.sOk != null)
    {
      this.sOk.dismiss();
      this.sOk = null;
    }
    AppMethodBeat.o(24513);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.ui.RedirectToChattingByPhoneStubUI
 * JD-Core Version:    0.7.0.1
 */