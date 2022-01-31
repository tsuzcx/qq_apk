package com.tencent.mm.plugin.appbrand.dynamic.debugger;

import android.os.Bundle;
import com.tencent.mm.aa.c.e.a;
import com.tencent.mm.ipcinvoker.d.c;
import com.tencent.mm.modelappbrand.LogInfo;
import com.tencent.mm.plugin.appbrand.wxawidget.console.b;
import java.util.ArrayList;

public final class a
{
  private static e.a fUY = new a.1();
  
  public static void a(String paramString, ArrayList<LogInfo> paramArrayList)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("id", paramString);
    localBundle.putParcelableArrayList("logList", paramArrayList);
    paramString = b.hEf;
    c.Cb().g(paramString.getClass().getName(), localBundle);
  }
  
  public static e.a afl()
  {
    return fUY;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.debugger.a
 * JD-Core Version:    0.7.0.1
 */