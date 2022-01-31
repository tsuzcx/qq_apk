package com.tencent.mm.modelstat.a;

import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.y;

public final class b$1
  implements Runnable
{
  public b$1(Bundle paramBundle) {}
  
  public final void run()
  {
    try
    {
      String str = this.byv.getString("mm_event_class");
      a locala = (a)Class.forName(str).newInstance();
      y.i("MicroMsg.WebViewMMReportUtil", "webview callback report className[%s]", new Object[] { str });
      locala.j(this.byv);
      return;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.WebViewMMReportUtil", localException, "receiveWebViewCallback error", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelstat.a.b.1
 * JD-Core Version:    0.7.0.1
 */