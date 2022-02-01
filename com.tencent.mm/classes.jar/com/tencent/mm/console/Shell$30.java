package com.tencent.mm.console;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cr.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import java.util.Iterator;
import java.util.Set;

final class Shell$30
  implements Shell.a
{
  @SuppressLint({"VisibleForTests"})
  public final void s(Intent paramIntent)
  {
    AppMethodBeat.i(231523);
    if ((!WeChatEnvironment.hasDebugger()) && (!WeChatEnvironment.isMonkeyEnv()))
    {
      Log.e("MicroMsg.Shell", "Environment denied: not coolassist or monkey env");
      AppMethodBeat.o(231523);
      return;
    }
    paramIntent = paramIntent.getExtras();
    if (paramIntent == null)
    {
      Log.e("MicroMsg.Shell", "extras is null");
      AppMethodBeat.o(231523);
      return;
    }
    Log.i("MicroMsg.Shell", "#BRANDS_BIZ");
    Iterator localIterator = paramIntent.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      if ((str1.startsWith("set_biz_")) && (str1.length() > 8))
      {
        String str2 = str1.substring(str1.indexOf("set_biz_") + 8);
        int i = Integer.parseInt(String.valueOf(paramIntent.get(str1)));
        Log.i("MicroMsg.Shell", "#BRANDS_BIZ, set " + str2 + " = " + i);
        cr.d.am(str2, i);
      }
    }
    AppMethodBeat.o(231523);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.console.Shell.30
 * JD-Core Version:    0.7.0.1
 */