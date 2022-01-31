package com.tencent.mm.plugin.aa.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mm.plugin.aa.a.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.List;

final class LaunchAAUI$5
  implements TextWatcher
{
  LaunchAAUI$5(LaunchAAUI paramLaunchAAUI) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable.toString().startsWith(".")) {
      paramEditable.insert(0, "0");
    }
    String str = paramEditable.toString();
    int i = str.indexOf(".");
    int j = str.length();
    if ((i >= 0) && (j - i > 3))
    {
      paramEditable.delete(i + 3, j);
      double d = bk.getDouble(paramEditable.toString(), 0.0D);
      if ((LaunchAAUI.f(this.eZt) == null) || (LaunchAAUI.f(this.eZt).size() <= 0)) {
        break label241;
      }
      d = d * 100.0D / LaunchAAUI.f(this.eZt).size();
      LaunchAAUI.d(this.eZt);
      if (d <= d.Vp()) {
        break label241;
      }
      LaunchAAUI.a(this.eZt, true);
      h.nFQ.f(13722, new Object[] { Integer.valueOf(2) });
    }
    for (;;)
    {
      LaunchAAUI.c(this.eZt);
      LaunchAAUI.g(this.eZt);
      LaunchAAUI.h(this.eZt);
      return;
      if (i > 6)
      {
        paramEditable.delete(6, i);
        break;
      }
      if ((i != -1) || (j <= 6)) {
        break;
      }
      paramEditable.delete(6, j);
      break;
      label241:
      LaunchAAUI.a(this.eZt, false);
    }
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAUI.5
 * JD-Core Version:    0.7.0.1
 */