package com.tencent.mm.plugin.aa.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.aa.model.i;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public final class LaunchAAByPersonAmountSelectUI$c
  implements TextWatcher
{
  String username;
  
  public LaunchAAByPersonAmountSelectUI$c(LaunchAAByPersonAmountSelectUI paramLaunchAAByPersonAmountSelectUI, String paramString)
  {
    this.username = paramString;
  }
  
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(63605);
    try
    {
      if (paramEditable.toString().startsWith(".")) {
        paramEditable.insert(0, "0");
      }
      String str = paramEditable.toString();
      int i = str.indexOf(".");
      int j = str.length();
      if ((i >= 0) && (j - i > 2)) {
        paramEditable.delete(i + 3, j);
      }
      int k = str.lastIndexOf(".");
      if ((k != i) && (k > 0) && (j > k)) {
        paramEditable.delete(k, j);
      }
    }
    catch (Exception localException)
    {
      label105:
      break label105;
    }
    if ((!Util.isNullOrNil(paramEditable)) && (Util.getDouble(paramEditable.toString(), 0.0D) > 0.0D)) {
      LaunchAAByPersonAmountSelectUI.c(this.jWI).put(this.username, paramEditable.toString());
    }
    for (;;)
    {
      LaunchAAByPersonAmountSelectUI.k(this.jWI).removeCallbacks(LaunchAAByPersonAmountSelectUI.j(this.jWI));
      LaunchAAByPersonAmountSelectUI.k(this.jWI).postDelayed(LaunchAAByPersonAmountSelectUI.j(this.jWI), 50L);
      if (LaunchAAByPersonAmountSelectUI.p(this.jWI)) {
        i.uZ(3);
      }
      AppMethodBeat.o(63605);
      return;
      LaunchAAByPersonAmountSelectUI.c(this.jWI).remove(this.username);
    }
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAByPersonAmountSelectUI.c
 * JD-Core Version:    0.7.0.1
 */