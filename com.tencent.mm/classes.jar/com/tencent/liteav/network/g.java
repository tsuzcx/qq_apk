package com.tencent.liteav.network;

import android.content.Context;
import android.os.Handler;
import com.tencent.liteav.basic.e.b;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class g
{
  private String a;
  private String b;
  private int c;
  private String d;
  private Handler e;
  
  public g(Context paramContext)
  {
    AppMethodBeat.i(67535);
    this.a = "";
    this.b = "";
    this.c = 0;
    this.d = "";
    if (paramContext != null) {
      this.e = new Handler(paramContext.getMainLooper());
    }
    AppMethodBeat.o(67535);
  }
  
  private String a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(67540);
    if ((paramString1 == null) || (paramString1.length() == 0) || (paramString2 == null) || (paramString2.length() == 0))
    {
      AppMethodBeat.o(67540);
      return null;
    }
    paramString1 = paramString1.toLowerCase();
    paramString2 = paramString2.split("[?&]");
    int j = paramString2.length;
    int i = 0;
    while (i < j)
    {
      Object localObject1 = paramString2[i];
      if (localObject1.indexOf("=") != -1)
      {
        Object localObject2 = localObject1.split("[=]");
        if (localObject2.length == 2)
        {
          localObject1 = localObject2[0];
          localObject2 = localObject2[1];
          if ((localObject1 != null) && (localObject1.toLowerCase().equalsIgnoreCase(paramString1)))
          {
            AppMethodBeat.o(67540);
            return localObject2;
          }
        }
      }
      i += 1;
    }
    AppMethodBeat.o(67540);
    return "";
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, g.a parama)
  {
    AppMethodBeat.i(67539);
    new g.2(this, "getRTMPAccUrl", paramString2, paramString4, paramString3, paramString1, paramInt, parama).start();
    AppMethodBeat.o(67539);
  }
  
  private boolean a(boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(67537);
    if (paramBoolean)
    {
      if ((paramString1 != null) && (!paramString1.isEmpty()) && (paramString2 != null) && (!paramString2.isEmpty()) && (paramString3 != null) && (!paramString3.isEmpty()))
      {
        AppMethodBeat.o(67537);
        return true;
      }
      AppMethodBeat.o(67537);
      return false;
    }
    if ((paramString1 != null) && (paramString2 != null) && (paramString3 != null))
    {
      AppMethodBeat.o(67537);
      return true;
    }
    AppMethodBeat.o(67537);
    return false;
  }
  
  private long e()
  {
    AppMethodBeat.i(67538);
    long l = b.a().a("Network", "AccRetryCountWithoutSecret");
    AppMethodBeat.o(67538);
    return l;
  }
  
  public int a(String paramString, int paramInt, g.a parama)
  {
    AppMethodBeat.i(67536);
    this.a = "";
    this.b = "";
    this.c = 0;
    this.d = "";
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(67536);
      return -1;
    }
    String str1 = TXCCommonUtil.getStreamIDByStreamUrl(paramString);
    if ((str1 == null) || (str1.isEmpty()))
    {
      AppMethodBeat.o(67536);
      return -2;
    }
    String str2 = a("bizid", paramString);
    String str3 = a("txSecret", paramString);
    paramString = a("txTime", paramString);
    if (e() <= 0L) {}
    for (boolean bool = true;; bool = false)
    {
      if (!a(bool, str2, paramString, str3))
      {
        AppMethodBeat.o(67536);
        return -3;
      }
      a(str1, str2, str3, paramString, paramInt, new g.1(this, str1, str2, str3, paramString, parama));
      AppMethodBeat.o(67536);
      return 0;
    }
  }
  
  public String a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public int c()
  {
    return this.c;
  }
  
  public String d()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.liteav.network.g
 * JD-Core Version:    0.7.0.1
 */