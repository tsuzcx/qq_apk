package com.tencent.mapsdk.internal;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.map.tools.json.JsonParser;
import com.tencent.map.tools.json.JsonUtils;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class pc
  extends AsyncTask<Object, Void, Void>
{
  public static final int a = 10000;
  private Handler b;
  private String c;
  private String d;
  private b e;
  private a f;
  private Handler g;
  
  public pc(Handler paramHandler, String paramString1, String paramString2, b paramb)
  {
    AppMethodBeat.i(225518);
    this.g = new Handler(Looper.myLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(226045);
        super.handleMessage(paramAnonymousMessage);
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(226045);
          return;
          new pc(pc.a(pc.this), pc.b(pc.this), pc.c(pc.this), pc.d(pc.this)).execute(new Object[0]);
        }
      }
    };
    this.b = paramHandler;
    this.e = paramb;
    paramHandler = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      paramHandler = "";
    }
    this.c = paramHandler;
    paramHandler = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramHandler = "";
    }
    this.d = paramHandler;
    AppMethodBeat.o(225518);
  }
  
  private static void a(int paramInt, String paramString)
  {
    AppMethodBeat.i(225582);
    Object localObject = new ArrayList(4);
    ((List)localObject).add("腾讯地图鉴权失败，请访问 lbs.qq.com 检查 key 配置");
    ((List)localObject).add("错误码：".concat(String.valueOf(paramInt)));
    ((List)localObject).add("错误信息：".concat(String.valueOf(paramString)));
    paramString = new StringBuilder(1024);
    paramString.append("Auth Fail:\n");
    char[] arrayOfChar = new char[81];
    Arrays.fill(arrayOfChar, '*');
    arrayOfChar[80] = '\n';
    paramString.append(arrayOfChar);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramString.append((String)((Iterator)localObject).next()).append("\n");
    }
    paramString.append(arrayOfChar);
    AppMethodBeat.o(225582);
  }
  
  private static void a(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(225547);
    Object localObject = null;
    paramJSONObject = paramJSONObject.optJSONObject("info");
    int i;
    if (paramJSONObject != null) {
      i = paramJSONObject.optInt("error");
    }
    for (paramJSONObject = paramJSONObject.optString("msg");; paramJSONObject = localObject)
    {
      if (i == 0)
      {
        gw.i = 0;
        AppMethodBeat.o(225547);
        return;
      }
      a(i, paramJSONObject);
      if (i < -400)
      {
        gw.i = -1;
        AppMethodBeat.o(225547);
        return;
      }
      gw.i = 1;
      AppMethodBeat.o(225547);
      return;
      i = 0;
    }
  }
  
  private boolean a()
  {
    AppMethodBeat.i(225532);
    Object localObject1 = (cq)((dc)cj.a(dc.class)).h();
    Object localObject2 = gw.a();
    String str2 = this.c;
    Object localObject3 = gw.k();
    String str3 = this.d;
    String str4 = gw.g();
    String str5 = gw.d();
    int i = gw.i();
    String str6 = gw.j();
    String str7 = gw.l();
    String str8 = gw.c();
    String str1 = gw.f();
    if (TextUtils.isEmpty(str1))
    {
      str1 = "0";
      localObject3 = ((cq)localObject1).checkAuth((String)localObject2, str2, (String)localObject3, str3, str4, str5, i, str6, str7, str8, str1);
      str1 = "utf-8";
      localObject2 = new byte[0];
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        str2 = ((NetResponse)localObject3).charset;
        str1 = str2;
        localObject1 = localObject2;
        if (((NetResponse)localObject3).data != null)
        {
          localObject1 = ((NetResponse)localObject3).data;
          str1 = str2;
        }
      }
      gw.j = Calendar.getInstance().get(1);
      gw.k = Calendar.getInstance().get(2);
      gw.l = Calendar.getInstance().get(5);
    }
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject(new String((byte[])localObject1, str1));
        this.f = ((a)JsonUtils.parseToModel(((JSONObject)localObject1).optJSONObject("detail"), a.class, new Object[0]));
        this.b.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(226023);
            if (pc.d(pc.this) != null) {
              pc.d(pc.this).a(pc.e(pc.this));
            }
            AppMethodBeat.o(226023);
          }
        });
        i = 0;
        str1 = null;
        localObject1 = ((JSONObject)localObject1).optJSONObject("info");
        if (localObject1 != null)
        {
          i = ((JSONObject)localObject1).optInt("error");
          str1 = ((JSONObject)localObject1).optString("msg");
        }
        if (i == 0)
        {
          gw.i = 0;
          if (gw.i != 0) {
            break label353;
          }
          AppMethodBeat.o(225532);
          return true;
          if ("wifi".equals(str1))
          {
            str1 = "2";
            break;
          }
          str1 = "1";
          break;
        }
        a(i, str1);
        if (i < -400) {
          gw.i = -1;
        } else {
          gw.i = 1;
        }
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(225532);
        return false;
      }
    }
    label353:
    AppMethodBeat.o(225532);
    return false;
  }
  
  private static String b()
  {
    AppMethodBeat.i(225537);
    String str = gw.f();
    if (TextUtils.isEmpty(str))
    {
      AppMethodBeat.o(225537);
      return "0";
    }
    if ("wifi".equals(str))
    {
      AppMethodBeat.o(225537);
      return "2";
    }
    AppMethodBeat.o(225537);
    return "1";
  }
  
  private void b(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(225557);
    this.f = ((a)JsonUtils.parseToModel(paramJSONObject.optJSONObject("detail"), a.class, new Object[0]));
    this.b.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(226023);
        if (pc.d(pc.this) != null) {
          pc.d(pc.this).a(pc.e(pc.this));
        }
        AppMethodBeat.o(226023);
      }
    });
    AppMethodBeat.o(225557);
  }
  
  private Void c()
  {
    AppMethodBeat.i(225563);
    boolean bool = a();
    if (gw.i == 2) {
      this.g.sendEmptyMessageDelayed(10000, 10000L);
    }
    if ((!bool) && (this.b != null))
    {
      Object localObject = new fr();
      ((fr)localObject).f = 3;
      localObject = this.b.obtainMessage(((fr)localObject).f, localObject);
      this.b.sendMessage((Message)localObject);
    }
    AppMethodBeat.o(225563);
    return null;
  }
  
  private void d()
  {
    AppMethodBeat.i(225574);
    if (this.b != null)
    {
      Object localObject = new fr();
      ((fr)localObject).f = 3;
      localObject = this.b.obtainMessage(((fr)localObject).f, localObject);
      this.b.sendMessage((Message)localObject);
    }
    AppMethodBeat.o(225574);
  }
  
  public static class a
    implements JsonParser
  {
    public fo a;
    public JSONArray b;
    public JSONObject c;
    public ph d;
    public int e = qw.c;
    
    public void parse(JSONObject paramJSONObject)
    {
      AppMethodBeat.i(225427);
      if (paramJSONObject == null)
      {
        AppMethodBeat.o(225427);
        return;
      }
      paramJSONObject = paramJSONObject.optJSONObject("cfg");
      if (paramJSONObject != null)
      {
        this.b = paramJSONObject.optJSONObject("custom_map_style").optJSONArray("style_list");
        JSONObject localJSONObject = paramJSONObject.optJSONObject("indoor_map");
        if (localJSONObject != null)
        {
          int i = localJSONObject.optInt("enable", -1);
          int j = localJSONObject.optInt("type", -1);
          if ((i != -1) && (j != -1)) {
            this.a = new fo(i, j, localJSONObject.optJSONArray("building_list"));
          }
        }
        localJSONObject = paramJSONObject.optJSONObject("custom_layer");
        if (localJSONObject != null) {
          this.d = ((ph)JsonUtils.parseToModel(localJSONObject, ph.class, new Object[0]));
        }
        localJSONObject = paramJSONObject.optJSONObject("event_map");
        if (localJSONObject != null) {
          this.e = localJSONObject.optInt("enable", qw.c);
        }
        this.c = paramJSONObject.optJSONObject("data_layer");
      }
      AppMethodBeat.o(225427);
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(pc.a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.pc
 * JD-Core Version:    0.7.0.1
 */