package com.tencent.mm.plugin.aa.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
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
    AppMethodBeat.i(40804);
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
    if ((!bo.aa(paramEditable)) && (bo.getDouble(paramEditable.toString(), 0.0D) > 0.0D)) {
      LaunchAAByPersonAmountSelectUI.c(this.gqx).put(this.username, paramEditable.toString());
    }
    for (;;)
    {
      LaunchAAByPersonAmountSelectUI.j(this.gqx).removeCallbacks(LaunchAAByPersonAmountSelectUI.i(this.gqx));
      LaunchAAByPersonAmountSelectUI.j(this.gqx).postDelayed(LaunchAAByPersonAmountSelectUI.i(this.gqx), 50L);
      AppMethodBeat.o(40804);
      return;
      LaunchAAByPersonAmountSelectUI.c(this.gqx).remove(this.username);
    }
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAByPersonAmountSelectUI.c
 * JD-Core Version:    0.7.0.1
 */