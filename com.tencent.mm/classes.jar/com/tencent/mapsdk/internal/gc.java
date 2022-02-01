package com.tencent.mapsdk.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.map.tools.Callback;
import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.JsonUtils;
import com.tencent.map.tools.json.annotation.Json;
import com.tencent.map.tools.net.NetManager;
import com.tencent.map.tools.net.NetMethod;
import com.tencent.map.tools.net.NetRequest;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.map.tools.net.NetUtil;
import com.tencent.mapsdk.core.MapDelegate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.TencentMapProtocol;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

public final class gc
{
  static volatile boolean a;
  
  static boolean a(final Context paramContext, final SharedPreferences paramSharedPreferences, a parama)
  {
    AppMethodBeat.i(225600);
    if ((parama == null) || (paramContext == null))
    {
      AppMethodBeat.o(225600);
      return false;
    }
    if ((kh.d("TRP")) && (Build.VERSION.SDK_INT < 30)) {}
    try
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("日志名称:\n").append(parama.a()).append("\n");
      new StringBuilder();
      Object localObject2 = SimpleDateFormat.getInstance().format(new Date(parama.c));
      ((StringBuilder)localObject1).append("创建时间:\n").append((String)localObject2).append("\n");
      localObject2 = SimpleDateFormat.getInstance();
      if (parama.b != null) {}
      for (long l = Long.parseLong(parama.b.b);; l = 0L)
      {
        localObject2 = ((DateFormat)localObject2).format(new Date(l * 1000L));
        ((StringBuilder)localObject1).append("过期时间:\n").append((String)localObject2).append("\n");
        localObject1 = jx.a(paramContext, "调试模式", ((StringBuilder)localObject1).toString(), 1);
        boolean bool = ((jx.a)localObject1).a().a("上报(仅WIFI)", new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(225630);
            if ((!gc.a) && (this.a.a(paramContext)))
            {
              this.c.a("上报中", null);
              this.a.a(new Callback()
              {
                private void a(Boolean paramAnonymous2Boolean)
                {
                  AppMethodBeat.i(223728);
                  if (!paramAnonymous2Boolean.booleanValue())
                  {
                    kh.c("TRP", "清理本地缓存");
                    kc.a(gc.3.this.d).a("reportFile", "");
                  }
                  paramAnonymous2Boolean = gc.3.this.c;
                  if (paramAnonymous2Boolean.a != null) {
                    paramAnonymous2Boolean.a.cancel();
                  }
                  gc.a = false;
                  AppMethodBeat.o(223728);
                }
              });
              gc.a = true;
              AppMethodBeat.o(225630);
              return;
            }
            kh.c("TRP", "正在上传中");
            AppMethodBeat.o(225630);
          }
        }).b();
        AppMethodBeat.o(225600);
        return bool;
      }
      if ((!a) && (parama.a(paramContext)))
      {
        parama.a(new Callback()
        {
          private void a(Boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(225610);
            if (!paramAnonymousBoolean.booleanValue())
            {
              kh.c("TRP", "清理本地缓存");
              kc.a(this.a).a("reportFile", "");
            }
            gc.a = false;
            AppMethodBeat.o(225610);
          }
        });
        a = true;
      }
    }
    catch (Exception paramContext)
    {
      label254:
      break label254;
    }
    AppMethodBeat.o(225600);
    return false;
  }
  
  public static boolean a(bm parambm)
  {
    AppMethodBeat.i(225592);
    if ((parambm != null) && (!parambm.e))
    {
      localObject1 = (TencentMapProtocol)parambm.getMapComponent(TencentMapProtocol.class);
      if (!(localObject1 instanceof cj)) {
        break label60;
      }
    }
    label60:
    for (Object localObject1 = ((cj)localObject1).d().b; ((cl)localObject1).a(); localObject1 = cj.e())
    {
      AppMethodBeat.o(225592);
      return false;
    }
    final Context localContext = parambm.getContext();
    final bm.b localb = parambm.u();
    String str = localb.a();
    final SharedPreferences localSharedPreferences = kc.a(localContext, "uploadConfig." + localb.c());
    localObject1 = localSharedPreferences.getString("reportFile", null);
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    for (;;)
    {
      Object localObject3;
      try
      {
        kh.c("TRP", "获取本地上报文件：".concat(String.valueOf(localObject1)));
        localObject1 = (a)JsonUtils.parseToModel(new JSONObject((String)localObject1), a.class, new Object[] { parambm });
        if (localObject1 != null)
        {
          localObject3 = localObject1;
          if (str.equals(((a)localObject1).a)) {}
        }
        else
        {
          kh.c("TRP", "重新创建上报文件");
          localObject3 = new a(parambm, str);
        }
        if ((((a)localObject3).b != null) && (!((a)localObject3).b.a())) {
          break label273;
        }
        kh.c("TRP", "请求token");
        jw.a(new jw.g()
        {
          private JSONObject a()
          {
            AppMethodBeat.i(225647);
            Object localObject = ((cq)((dc)cj.a(dc.class)).h()).uploadToken(this.a.b(), localb.a, localb.b);
            kh.c("TRP", "响应状态：" + ((NetResponse)localObject).statusCode);
            if (((NetResponse)localObject).available())
            {
              localObject = gz.a(((NetResponse)localObject).data, ((NetResponse)localObject).charset);
              kh.c("TRP", "获取网络token数据：".concat(String.valueOf(localObject)));
              if (!TextUtils.isEmpty((CharSequence)localObject))
              {
                localObject = new JSONObject((String)localObject).optJSONObject("detail");
                AppMethodBeat.o(225647);
                return localObject;
              }
            }
            AppMethodBeat.o(225647);
            return null;
          }
        }).a(new jw.a()
        {
          private void a(JSONObject paramAnonymousJSONObject)
          {
            AppMethodBeat.i(225655);
            if (paramAnonymousJSONObject != null)
            {
              this.a.b = ((gc.b)JsonUtils.parseToModel(paramAnonymousJSONObject, gc.b.class, new Object[0]));
              gc.a(localContext, localSharedPreferences, this.a);
              paramAnonymousJSONObject = JsonUtils.modelToJson(this.a);
              if (paramAnonymousJSONObject != null)
              {
                kh.c("TRP", "保存上报文件至本地");
                kc.a(localSharedPreferences).a("reportFile", paramAnonymousJSONObject.toString());
              }
            }
            AppMethodBeat.o(225655);
          }
        });
        bool = false;
        AppMethodBeat.o(225592);
        return bool;
      }
      catch (Exception localException) {}
      Object localObject2 = null;
      continue;
      label273:
      kh.c("TRP", "使用本地上报文件");
      boolean bool = a(localContext, localSharedPreferences, (a)localObject3);
    }
  }
  
  static class a
    extends JsonComposer
  {
    @Json(name="name")
    String a;
    @Json(name="token")
    gc.b b;
    @Json(name="create_time")
    long c;
    @Json(ignore=true)
    bm d;
    
    public a(bm parambm)
    {
      this(parambm, "");
    }
    
    public a(bm parambm, String paramString)
    {
      AppMethodBeat.i(224046);
      this.a = paramString;
      this.d = parambm;
      this.c = System.currentTimeMillis();
      AppMethodBeat.o(224046);
    }
    
    private long c()
    {
      return this.c;
    }
    
    private long d()
    {
      AppMethodBeat.i(224064);
      if (this.b != null)
      {
        long l = Long.parseLong(this.b.b);
        AppMethodBeat.o(224064);
        return l;
      }
      AppMethodBeat.o(224064);
      return 0L;
    }
    
    private String e()
    {
      AppMethodBeat.i(224075);
      String str = "https://" + this.b.c + "/" + b();
      AppMethodBeat.o(224075);
      return str;
    }
    
    private boolean f()
    {
      AppMethodBeat.i(224107);
      if (this.d == null)
      {
        AppMethodBeat.o(224107);
        return false;
      }
      File localFile2 = new File(mf.a(this.d.getContext(), null).a());
      File localFile1 = ka.a(localFile2, a());
      kh.c("TRP", "创建上传文件目录:".concat(String.valueOf(localFile1)));
      Object localObject1 = ka.b(localFile1, "base-info.txt");
      Object localObject2 = new StringBuilder();
      bm.b localb = this.d.u();
      ((StringBuilder)localObject2).append(gw.a(localb.c, localb.d));
      ((StringBuilder)localObject2).append("&engine_draw_version=").append(this.d.v());
      ((StringBuilder)localObject2).append("&engine_data_version=").append(this.d.w());
      ((StringBuilder)localObject2).append("&camera=").append(this.d.b.getMap().getCameraPosition());
      kh.c("TRP", "日志数据:".concat(String.valueOf(localObject2)));
      ka.a((File)localObject1, ((StringBuilder)localObject2).toString().getBytes());
      kh.c("TRP", "收集日志数据至文件:".concat(String.valueOf(localObject1)));
      localObject1 = this.d.u().c;
      ka.b(new File(mf.a(this.d.getContext(), null).a((String)localObject1)), new File(localFile1, "config"));
      localObject1 = this.d.y().a();
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = ka.b(localFile1, "engine-crash-info.txt");
        kh.c("TRP", "收集引擎Crash至文件:".concat(String.valueOf(localObject2)));
        ka.a((File)localObject2, ((String)localObject1).getBytes());
      }
      localObject1 = this.d.y().b();
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = ka.b(localFile1, "engine-log-info.txt");
        kh.c("TRP", "收集引擎日志至文件:".concat(String.valueOf(localObject2)));
        ka.a((File)localObject2, ((String)localObject1).getBytes());
      }
      localObject1 = u.a().a.d();
      int j;
      int i;
      if ((localObject1 != null) && (((File)localObject1).exists()) && (((File)localObject1).isDirectory()))
      {
        localObject1 = ((File)localObject1).listFiles();
        if (localObject1 != null)
        {
          j = localObject1.length;
          i = 0;
          while (i < j)
          {
            localObject2 = localObject1[i];
            if ((localObject2 != null) && (((File)localObject2).exists()) && (((File)localObject2).isFile())) {
              ka.b((File)localObject2, new File(localFile1, "plugin"));
            }
            i += 1;
          }
        }
      }
      localObject1 = kh.a();
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = new File((String)localObject1);
        if ((((File)localObject1).exists()) && (((File)localObject1).isDirectory()))
        {
          localObject2 = ka.e((File)localObject1, ".*.log.*");
          if (localObject2 != null)
          {
            j = localObject2.length;
            i = 0;
            while (i < j)
            {
              localb = localObject2[i];
              if ((localb != null) && (localb.exists()) && (localb.isFile())) {
                ka.b(localb, new File(localFile1, "logs"));
              }
              i += 1;
            }
          }
          localObject1 = ka.e((File)localObject1, "archive-.*.zip");
          if (localObject1 != null)
          {
            j = localObject1.length;
            i = 0;
            while (i < j)
            {
              localObject2 = localObject1[i];
              if ((localObject2 != null) && (((File)localObject2).exists()) && (((File)localObject2).isFile())) {
                ka.b((File)localObject2, new File(localFile1, "archives"));
              }
              i += 1;
            }
          }
        }
      }
      localFile2 = kd.a(localFile1, localFile2.getAbsolutePath());
      kh.c("TRP", "打包成zip文件:".concat(String.valueOf(localFile2)));
      if (localFile2 != null)
      {
        localObject1 = ka.c(localFile2);
        if (localObject1 == null)
        {
          AppMethodBeat.o(224107);
          return false;
        }
        kh.c("TRP", "zip文件大小:" + localObject1.length);
        if (localObject1.length > 0)
        {
          kh.c("TRP", "开始上传文件到：" + e());
          localObject2 = kr.a(localFile2);
          localObject1 = new NetRequest(NetMethod.PUT, e()).setPostData((byte[])localObject1).setMapHeaders("Content-Length", localObject1.length).setMapHeaders("Authorization", this.b.a).setMapHeaders("x-cos-content-sha1", (String)localObject2).setTimeout(120000);
          localObject1 = NetManager.getInstance().doRequest((NetRequest)localObject1);
          kh.c("TRP", "结束上传文件");
          ka.b(localFile2);
          ka.b(localFile1);
          i = ((NetResponse)localObject1).statusCode;
          kh.c("TRP", "上传状态:".concat(String.valueOf(i)));
          if (i == 200)
          {
            AppMethodBeat.o(224107);
            return true;
          }
          AppMethodBeat.o(224107);
          return false;
        }
      }
      AppMethodBeat.o(224107);
      return false;
    }
    
    private byte[] g()
    {
      AppMethodBeat.i(224120);
      Object localObject = new StringBuilder();
      bm.b localb = this.d.u();
      ((StringBuilder)localObject).append(gw.a(localb.c, localb.d));
      ((StringBuilder)localObject).append("&engine_draw_version=").append(this.d.v());
      ((StringBuilder)localObject).append("&engine_data_version=").append(this.d.w());
      ((StringBuilder)localObject).append("&camera=").append(this.d.b.getMap().getCameraPosition());
      kh.c("TRP", "日志数据:".concat(String.valueOf(localObject)));
      localObject = ((StringBuilder)localObject).toString().getBytes();
      AppMethodBeat.o(224120);
      return localObject;
    }
    
    public final String a()
    {
      AppMethodBeat.i(224154);
      String str = "android-" + this.a + "-" + this.c;
      AppMethodBeat.o(224154);
      return str;
    }
    
    public final void a(final Callback<Boolean> paramCallback)
    {
      AppMethodBeat.i(224188);
      jw.a(new jw.g()
      {
        private Boolean a()
        {
          AppMethodBeat.i(223738);
          boolean bool = gc.a.a(gc.a.this);
          AppMethodBeat.o(223738);
          return Boolean.valueOf(bool);
        }
      }).a(new jw.a()
      {
        private void a(Boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(223783);
          if (paramCallback != null) {
            paramCallback.callback(paramAnonymousBoolean);
          }
          AppMethodBeat.o(223783);
        }
      });
      AppMethodBeat.o(224188);
    }
    
    public final boolean a(Context paramContext)
    {
      AppMethodBeat.i(224176);
      if ((NetUtil.isWifi(paramContext)) && (this.b != null) && (!this.b.a()))
      {
        AppMethodBeat.o(224176);
        return true;
      }
      AppMethodBeat.o(224176);
      return false;
    }
    
    public final String b()
    {
      AppMethodBeat.i(224165);
      String str = a() + ".zip";
      AppMethodBeat.o(224165);
      return str;
    }
  }
  
  static class b
    extends JsonComposer
  {
    @Json(name="token")
    String a;
    @Json(name="expire")
    String b;
    @Json(name="host")
    String c;
    
    final boolean a()
    {
      AppMethodBeat.i(223997);
      try
      {
        if (Long.parseLong(this.b) < SystemClock.uptimeMillis() / 1000L)
        {
          AppMethodBeat.o(223997);
          return true;
        }
        AppMethodBeat.o(223997);
        return false;
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(223997);
      }
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.gc
 * JD-Core Version:    0.7.0.1
 */