package com.tencent.map.tools.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.map.tools.EncryptAesUtils;
import com.tencent.map.tools.sheet.SheetNetworkStateMonitor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class i
{
  public Context a;
  public a b;
  boolean c;
  SheetNetworkStateMonitor d;
  private String e;
  private o f;
  private List<p> g;
  
  public i(Context paramContext, Looper paramLooper)
  {
    AppMethodBeat.i(180800);
    this.e = i.class.getSimpleName();
    this.c = false;
    this.a = paramContext;
    this.b = new a(paramLooper);
    this.f = new o(paramContext);
    this.d = new SheetNetworkStateMonitor(paramContext);
    AppMethodBeat.o(180800);
  }
  
  private boolean a()
  {
    AppMethodBeat.i(180803);
    Object localObject = b();
    if (localObject == null)
    {
      AppMethodBeat.o(180803);
      return false;
    }
    localObject = ((String)localObject).getBytes();
    if (localObject != null)
    {
      new HashMap();
      int j;
      for (int i = 0;; i = j)
      {
        j = i + 1;
        if (i >= 3) {
          break;
        }
        byte[] arrayOfByte = r.a("https://cc.map.qq.com?desc_c", (byte[])localObject);
        if (arrayOfByte != null)
        {
          localObject = new String(arrayOfByte);
          g.a(this.a).a("DRG", "response suc,try:".concat(String.valueOf(j)));
          boolean bool = a((String)localObject);
          AppMethodBeat.o(180803);
          return bool;
        }
      }
    }
    AppMethodBeat.o(180803);
    return false;
  }
  
  private boolean a(String paramString)
  {
    AppMethodBeat.i(180801);
    paramString = b(EncryptAesUtils.decryptAes256Base64(paramString, "sE0zy%DVqLnXA$hmNZ8NBwcg7FDrvi!q", t.G));
    if (paramString == null)
    {
      AppMethodBeat.o(180801);
      return false;
    }
    Object localObject1 = x.a(paramString);
    if ((((List)localObject1).isEmpty()) || (y.e < 0)) {}
    for (paramString = null; (paramString == null) || (paramString.isEmpty()); paramString = null)
    {
      label53:
      AppMethodBeat.o(180801);
      return false;
      int m = s.a(this.a).a;
      paramString = new ArrayList();
      localObject1 = ((List)localObject1).iterator();
      int i = 0;
      int k = 0;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (p)((Iterator)localObject1).next();
        int j;
        if (x.a(((p)localObject2).a))
        {
          j = i;
          if (((p)localObject2).a == m)
          {
            paramString.add(localObject2);
            k = 1;
          }
        }
        else
        {
          j = i + 1;
          paramString.add(localObject2);
        }
        i = j;
      }
      if ((y.e == 0) || ((i > 0) && (k != 0)) || ((k != 0) && (i == 0) && (paramString.size() == 1))) {
        break label53;
      }
    }
    localObject1 = x.b(this.a, t.v, "preference_default");
    Object localObject2 = x.a((String)localObject1);
    if ((((String)localObject1).equals("preference_default")) || (((List)localObject2).isEmpty())) {}
    for (boolean bool = false; bool; bool = x.a(paramString, (List)localObject2))
    {
      AppMethodBeat.o(180801);
      return false;
    }
    localObject1 = x.a(x.b(this.a, t.B, "preference_default"));
    if (((List)localObject1).isEmpty()) {}
    for (bool = false; bool; bool = x.a(paramString, (List)localObject1))
    {
      AppMethodBeat.o(180801);
      return false;
    }
    q.a(this.b, 10007, paramString);
    AppMethodBeat.o(180801);
    return true;
  }
  
  private String b()
  {
    AppMethodBeat.i(180804);
    Object localObject = x.a(x.b(this.a, t.q, "default"));
    if (((List)localObject).isEmpty())
    {
      AppMethodBeat.o(180804);
      return null;
    }
    JSONObject localJSONObject1 = new JSONObject();
    JSONArray localJSONArray;
    for (;;)
    {
      try
      {
        localJSONObject1.put("projName", a.a);
        localJSONObject1.put("appkey", x.a(this.a));
        localJSONObject1.put("appversion", x.b(this.a));
        localJSONObject1.put("imei", x.c(this.a));
        localJSONObject1.put("coverSDKver", t.k);
        localJSONObject1.put("model", x.b() + "_" + x.a());
        localJSONObject1.put("APILevel", x.c());
        localJSONArray = new JSONArray();
        Iterator localIterator = ((List)localObject).iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (p)localIterator.next();
        if (localObject != null)
        {
          JSONObject localJSONObject2 = new JSONObject();
          localJSONObject2.put("compId", ((p)localObject).a);
          localJSONObject2.put("compVer", ((p)localObject).b);
          localJSONObject2.put("size", ((p)localObject).d);
          Context localContext = this.a;
          int i = s.a(localContext).a;
          if (x.a(((p)localObject).a))
          {
            localObject = x.b(localContext, x.c + File.separator + t.F[i] + File.separator + ((p)localObject).c);
            localJSONObject2.put("md5", x.a(new File((String)localObject)));
            localJSONArray.put(localJSONObject2);
          }
          else
          {
            str = x.b(localContext, x.a + File.separator + localException.c);
          }
        }
      }
      catch (Exception localException)
      {
        g.a(this.a).a("DRG", "reqDerror:" + localException.toString());
        AppMethodBeat.o(180804);
        return null;
      }
    }
    localJSONObject1.put("compList", localJSONArray);
    String str = localJSONObject1.toString();
    g.a(this.a).a("DRG", "req:".concat(String.valueOf(str)));
    str = EncryptAesUtils.encryptAes256Base64(str, "sE0zy%DVqLnXA$hmNZ8NBwcg7FDrvi!q", t.G);
    AppMethodBeat.o(180804);
    return str;
  }
  
  private static String b(String paramString)
  {
    AppMethodBeat.i(180802);
    try
    {
      Object localObject1 = new JSONObject(paramString);
      paramString = ((JSONObject)localObject1).getString("status");
      g.a().a("DRG", "statucode:".concat(String.valueOf(paramString)));
      boolean bool = paramString.equals("-3");
      if (bool)
      {
        AppMethodBeat.o(180802);
        return null;
      }
      if (paramString.equals("0"))
      {
        paramString = "";
        localObject1 = ((JSONObject)localObject1).getJSONArray("compList");
        int i = 0;
        while (i < ((JSONArray)localObject1).length())
        {
          Object localObject2 = ((JSONArray)localObject1).getJSONObject(i);
          int j = ((JSONObject)localObject2).getInt("compId");
          String str1 = ((JSONObject)localObject2).getString("compVer");
          String str2 = ((JSONObject)localObject2).getString("md5");
          int k = ((JSONObject)localObject2).getInt("size");
          localObject2 = ((JSONObject)localObject2).getString("compName");
          paramString = paramString + j + "," + str1 + "," + (String)localObject2 + "," + k + "," + str2 + ",;";
          i += 1;
        }
        AppMethodBeat.o(180802);
        return paramString;
      }
      bool = paramString.equals("-1");
      if (bool)
      {
        AppMethodBeat.o(180802);
        return null;
      }
      bool = paramString.equals("-2");
      if (bool)
      {
        AppMethodBeat.o(180802);
        return null;
      }
      bool = paramString.equals("-4");
      if (bool)
      {
        AppMethodBeat.o(180802);
        return null;
      }
      bool = paramString.equals("-5");
      if (bool)
      {
        AppMethodBeat.o(180802);
        return null;
      }
    }
    catch (Exception paramString)
    {
      g.a().a("DRG", "statucode:" + paramString.toString());
      AppMethodBeat.o(180802);
    }
    return null;
  }
  
  final class a
    extends Handler
  {
    public a(Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(180799);
      super.handleMessage(paramMessage);
      for (;;)
      {
        try
        {
          int i = paramMessage.what;
          switch (i)
          {
          case 10008: 
          default: 
            AppMethodBeat.o(180799);
            return;
          }
        }
        catch (Throwable paramMessage)
        {
          AppMethodBeat.o(180799);
          return;
        }
        i.a(i.this);
        AppMethodBeat.o(180799);
        return;
        paramMessage = (List)paramMessage.obj;
        i.a(i.this, paramMessage);
        i.b(i.this).a = paramMessage;
        i.b(i.this).a();
        AppMethodBeat.o(180799);
        return;
        if ((i.c(i.this) != null) && (i.b(i.this).b < 4))
        {
          i.b(i.this).a = i.c(i.this);
          i.b(i.this).a();
        }
        q.a(g.a(i.this.a).b, 10005, 0L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.map.tools.internal.i
 * JD-Core Version:    0.7.0.1
 */