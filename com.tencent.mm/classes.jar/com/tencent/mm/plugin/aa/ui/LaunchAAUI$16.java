package com.tencent.mm.plugin.aa.ui;

import android.content.Intent;
import com.tencent.mm.plugin.aa.a.a;
import com.tencent.mm.plugin.report.service.h;

final class LaunchAAUI$16
  implements a.a
{
  LaunchAAUI$16(LaunchAAUI paramLaunchAAUI) {}
  
  public final void Vx()
  {
    Intent localIntent = new Intent(this.eZt, AAQueryListUI.class);
    this.eZt.startActivity(localIntent);
    if (LaunchAAUI.b(this.eZt) == a.eVh)
    {
      h.nFQ.f(13721, new Object[] { Integer.valueOf(5), Integer.valueOf(1) });
      return;
    }
    h.nFQ.f(13721, new Object[] { Integer.valueOf(5), Integer.valueOf(2) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAUI.16
 * JD-Core Version:    0.7.0.1
 */