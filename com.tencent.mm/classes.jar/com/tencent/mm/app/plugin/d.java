package com.tencent.mm.app.plugin;

import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.o;
import com.tencent.mm.pluginsdk.ui.applet.u;
import com.tencent.mm.pluginsdk.ui.span.a;
import com.tencent.mm.pluginsdk.ui.span.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public final class d
  implements o
{
  private static String a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(19665);
    if ((bt.isNullOrNil(paramString1)) || (bt.isNullOrNil(paramString2)) || (paramInt1 >= paramInt2))
    {
      AppMethodBeat.o(19665);
      return paramString1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      localStringBuilder.append(paramString1.subSequence(0, paramInt1 + 0));
      localStringBuilder.append(paramString2);
      localStringBuilder.append(paramString1.subSequence(paramInt2 + 0, paramString1.length()));
      paramString2.length();
      paramString1 = localStringBuilder.toString();
      AppMethodBeat.o(19665);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      ad.e("MicroMsg.QrCodeURLHelper", paramString1.getMessage());
      AppMethodBeat.o(19665);
    }
    return "";
  }
  
  public final boolean a(Context paramContext, String paramString, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    AppMethodBeat.i(19666);
    ad.d("MicroMsg.QrCodeURLHelper", "tryHandleEvents, url:%s", new Object[] { paramString });
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(19666);
      return false;
    }
    if (paramString.endsWith("@mailto@")) {
      m.b(paramContext, paramString.substring(0, paramString.length() - 8), paramOnDismissListener);
    }
    for (;;)
    {
      AppMethodBeat.o(19666);
      return true;
      if (!paramString.endsWith("@tel@")) {
        break;
      }
      paramString = paramString.substring(0, paramString.length() - 5);
      Bundle localBundle = new Bundle();
      localBundle.putInt("fromScene", 3);
      m.a(paramContext, paramString, paramOnDismissListener, localBundle);
    }
    AppMethodBeat.o(19666);
    return false;
  }
  
  public final boolean eT(String paramString)
  {
    AppMethodBeat.i(19667);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(19667);
      return false;
    }
    if ((paramString.endsWith("@mailto@")) || (paramString.endsWith("@tel@")))
    {
      AppMethodBeat.o(19667);
      return true;
    }
    AppMethodBeat.o(19667);
    return false;
  }
  
  public final String w(Context paramContext, String paramString)
  {
    AppMethodBeat.i(19664);
    paramContext = a.bN(paramContext, paramString);
    if (paramContext.size() == 0)
    {
      AppMethodBeat.o(19664);
      return paramString;
    }
    Collections.sort(paramContext, new Comparator() {});
    Iterator localIterator = paramContext.iterator();
    paramContext = paramString;
    String str1;
    label124:
    String str2;
    if (localIterator.hasNext())
    {
      u localu = (u)localIterator.next();
      str1 = null;
      int i = localu.start;
      int j = localu.end;
      switch (localu.type)
      {
      default: 
        if (str1 != null)
        {
          str2 = localu.url;
          if ((localu.type == 1) && (!str2.startsWith("http://")))
          {
            str1 = String.format(str1, new Object[] { "http://" + str2.trim(), str2.trim() });
            label197:
            str1 = a(paramContext, i, j, str1);
            paramContext = str1;
            if (str1.length() != 0) {
              break label293;
            }
          }
        }
        break;
      }
    }
    for (;;)
    {
      ad.d("MicroMsg.QrCodeURLHelper", "formatQRString, result:%s", new Object[] { paramString });
      AppMethodBeat.o(19664);
      return paramString;
      str1 = "<a href=\"%s@tel@\">%s</a>";
      break label124;
      str1 = "<a href=\"%s@mailto@\">%s</a>";
      break label124;
      str1 = "<a href=\"%s\">%s</a>";
      break label124;
      str1 = String.format(str1, new Object[] { str2.trim(), str2.trim() });
      break label197;
      label293:
      break;
      paramString = paramContext;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.app.plugin.d
 * JD-Core Version:    0.7.0.1
 */