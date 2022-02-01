package com.tencent.mm.app;

import android.content.Intent;
import android.os.Process;
import android.util.Base64;
import com.tencent.mm.plugin.y.c;
import com.tencent.mm.plugin.y.d;
import com.tencent.mm.sdk.crash.ISubReporter;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class w$2
  implements ISubReporter
{
  public final void report(String paramString)
  {
    if (d.gdL() != null)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("uncatch_exception");
      localIntent.putExtra("exceptionPid", Process.myPid());
      localIntent.putExtra("userName", w.access$100());
      localIntent.putExtra("tag", 0);
      localIntent.putExtra("exceptionMsg", Base64.encodeToString((w.aa("", BuildInfo.CLIENT_VERSION) + paramString).getBytes(), 2));
      d.gdL().aB(MMApplicationContext.getContext(), localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.w.2
 * JD-Core Version:    0.7.0.1
 */