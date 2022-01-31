package com.tencent.mm.plugin.aa.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
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
      label100:
      break label100;
    }
    if ((!bk.L(paramEditable)) && (bk.getDouble(paramEditable.toString(), 0.0D) > 0.0D)) {
      LaunchAAByPersonAmountSelectUI.c(this.eYG).put(this.username, paramEditable.toString());
    }
    for (;;)
    {
      LaunchAAByPersonAmountSelectUI.j(this.eYG).removeCallbacks(LaunchAAByPersonAmountSelectUI.i(this.eYG));
      LaunchAAByPersonAmountSelectUI.j(this.eYG).postDelayed(LaunchAAByPersonAmountSelectUI.i(this.eYG), 50L);
      return;
      LaunchAAByPersonAmountSelectUI.c(this.eYG).remove(this.username);
    }
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAByPersonAmountSelectUI.c
 * JD-Core Version:    0.7.0.1
 */