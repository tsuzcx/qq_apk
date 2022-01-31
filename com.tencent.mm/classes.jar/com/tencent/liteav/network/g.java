package com.tencent.liteav.network;

import android.content.Context;
import android.os.Handler;
import com.tencent.liteav.basic.e.b;
import com.tencent.liteav.basic.util.TXCCommonUtil;

public class g
{
  private String a = "";
  private String b = "";
  private int c = 0;
  private String d = "";
  private Handler e;
  
  public g(Context paramContext)
  {
    if (paramContext != null) {
      this.e = new Handler(paramContext.getMainLooper());
    }
  }
  
  private String a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.length() == 0) || (paramString2 == null) || (paramString2.length() == 0))
    {
      paramString1 = null;
      return paramString1;
    }
    String str = paramString1.toLowerCase();
    paramString2 = paramString2.split("[?&]");
    int j = paramString2.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label112;
      }
      paramString1 = paramString2[i];
      if (paramString1.indexOf("=") != -1)
      {
        paramString1 = paramString1.split("[=]");
        if (paramString1.length == 2)
        {
          Object localObject = paramString1[0];
          paramString1 = paramString1[1];
          if ((localObject != null) && (localObject.toLowerCase().equalsIgnoreCase(str))) {
            break;
          }
        }
      }
      i += 1;
    }
    label112:
    return "";
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, g.a parama)
  {
    new g.2(this, "getRTMPAccUrl", paramString2, paramString4, paramString3, paramString1, paramInt, parama).start();
  }
  
  private boolean a(boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    if (paramBoolean) {
      if ((paramString1 == null) || (paramString1.isEmpty()) || (paramString2 == null) || (paramString2.isEmpty()) || (paramString3 == null) || (paramString3.isEmpty())) {}
    }
    while ((paramString1 != null) && (paramString2 != null) && (paramString3 != null))
    {
      return true;
      return false;
    }
    return false;
  }
  
  private long e()
  {
    return b.a().a("Network", "AccRetryCountWithoutSecret");
  }
  
  public int a(String paramString, int paramInt, g.a parama)
  {
    this.a = "";
    this.b = "";
    this.c = 0;
    this.d = "";
    if ((paramString == null) || (paramString.isEmpty())) {
      return -1;
    }
    String str1 = TXCCommonUtil.getStreamIDByStreamUrl(paramString);
    if ((str1 == null) || (str1.isEmpty())) {
      return -2;
    }
    String str2 = a("bizid", paramString);
    String str3 = a("txSecret", paramString);
    paramString = a("txTime", paramString);
    if (e() <= 0L) {}
    for (boolean bool = true;; bool = false)
    {
      if (!a(bool, str2, paramString, str3)) {
        return -3;
      }
      a(str1, str2, str3, paramString, paramInt, new g.1(this, str1, str2, str3, paramString, parama));
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