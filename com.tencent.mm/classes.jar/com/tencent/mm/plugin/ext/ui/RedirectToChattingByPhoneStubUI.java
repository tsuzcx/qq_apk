package com.tencent.mm.plugin.ext.ui;

import android.app.Activity;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.base.h;

public class RedirectToChattingByPhoneStubUI
  extends Activity
  implements f
{
  private com.tencent.mm.ui.base.p mfs = null;
  
  public final boolean hideVKB()
  {
    AppMethodBeat.i(20438);
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    if (localInputMethodManager == null)
    {
      AppMethodBeat.o(20438);
      return false;
    }
    Object localObject = getCurrentFocus();
    if (localObject == null)
    {
      AppMethodBeat.o(20438);
      return false;
    }
    localObject = ((View)localObject).getWindowToken();
    if (localObject == null)
    {
      AppMethodBeat.o(20438);
      return false;
    }
    try
    {
      bool = localInputMethodManager.hideSoftInputFromWindow((IBinder)localObject, 0);
      ab.v("MicroMsg.RedirectToChattingByPhoneStubUI", "hide VKB result %B", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(20438);
      return bool;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        ab.e("MicroMsg.RedirectToChattingByPhoneStubUI", "hide VKB exception %s", new Object[] { localIllegalArgumentException });
        boolean bool = false;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(20435);
    super.onCreate(paramBundle);
    getString(2131297112);
    this.mfs = h.b(this, "", false, null);
    al.p(new RedirectToChattingByPhoneStubUI.1(this), 500L);
    aw.Rc().a(106, this);
    AppMethodBeat.o(20435);
  }
  
  protected void onDestroy()
  {
    AppMethodBeat.i(20436);
    super.onDestroy();
    aw.Rc().b(106, this);
    if (this.mfs != null)
    {
      this.mfs.dismiss();
      this.mfs = null;
    }
    AppMethodBeat.o(20436);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(20437);
    finish();
    AppMethodBeat.o(20437);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.ui.RedirectToChattingByPhoneStubUI
 * JD-Core Version:    0.7.0.1
 */