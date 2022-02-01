package com.tencent.mapsdk.internal;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.map.tools.Callback;
import com.tencent.map.tools.json.JsonUtils;
import com.tencent.map.tools.net.NetManager;
import com.tencent.map.tools.net.NetRequest.NetRequestBuilder;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.Language;
import com.tencent.tencentmap.mapsdk.maps.model.OverSeaSource;
import com.tencent.tencentmap.mapsdk.maps.model.OverSeaTileProvider;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ri
{
  public int a = rp.a;
  public int b = 1000;
  public int c = rp.c;
  public int d = 0;
  public volatile boolean e = false;
  public int f = 0;
  public rq g;
  boolean h;
  public OverSeaSource i = OverSeaSource.DEFAULT;
  public Language j = Language.zh;
  public OverSeaTileProvider k;
  private String l = null;
  
  private static String a(Context paramContext, OverSeaSource paramOverSeaSource)
  {
    AppMethodBeat.i(223187);
    me localme = me.a(paramContext);
    paramContext = null;
    switch (3.a[paramOverSeaSource.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(223187);
      return paramContext;
      paramContext = localme.a("worldMapConfig");
      continue;
      paramContext = localme.a("worldMapConfig_BING");
    }
  }
  
  private void a(final Context paramContext, final OverSeaSource paramOverSeaSource, final Callback<Boolean> paramCallback)
  {
    AppMethodBeat.i(223176);
    if (paramContext == null)
    {
      AppMethodBeat.o(223176);
      return;
    }
    this.i = paramOverSeaSource;
    paramOverSeaSource = jw.a(new jw.g()
    {
      private Boolean a()
      {
        AppMethodBeat.i(222638);
        kh.c("TO", "开始初始化配置");
        Object localObject2 = paramContext;
        Object localObject1 = paramOverSeaSource;
        localObject2 = me.a((Context)localObject2);
        switch (ri.3.a[localObject1.ordinal()])
        {
        default: 
          localObject1 = null;
          kh.c("TO", "本地配置数据：".concat(String.valueOf(localObject1)));
          if (gz.a((String)localObject1)) {
            break;
          }
        }
        for (;;)
        {
          try
          {
            localObject1 = new JSONObject((String)localObject1);
            ri.this.g = ((rq)JsonUtils.parseToModel((JSONObject)localObject1, rq.class, new Object[0]));
            ri.this.a(ri.this.g);
            kh.c("TO", "完成初始化配置");
            AppMethodBeat.o(222638);
            return null;
            localObject1 = ((me)localObject2).a("worldMapConfig");
            break;
            localObject1 = ((me)localObject2).a("worldMapConfig_BING");
          }
          catch (JSONException localJSONException)
          {
            kh.b("TO", localJSONException);
            continue;
          }
          if (js.a("4.4.7", "4.3.1")) {
            ri.this.a(paramContext);
          }
        }
      }
    });
    Boolean localBoolean = Boolean.FALSE;
    if (paramCallback != null) {}
    for (paramContext = new jw.a()
        {
          private void a(Boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(222671);
            paramCallback.callback(paramAnonymousBoolean);
            AppMethodBeat.o(222671);
          }
        };; paramContext = null)
    {
      paramOverSeaSource.a(localBoolean, paramContext);
      AppMethodBeat.o(223176);
      return;
    }
  }
  
  private static void a(Context paramContext, OverSeaSource paramOverSeaSource, String paramString)
  {
    AppMethodBeat.i(223197);
    paramContext = me.a(paramContext);
    switch (3.a[paramOverSeaSource.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(223197);
      return;
      paramContext.a("worldMapConfig", paramString);
      AppMethodBeat.o(223197);
      return;
      paramContext.a("worldMapConfig_BING", paramString);
    }
  }
  
  private void a(Language paramLanguage)
  {
    this.j = paramLanguage;
  }
  
  private void a(OverSeaTileProvider paramOverSeaTileProvider)
  {
    this.k = paramOverSeaTileProvider;
  }
  
  private boolean a(Context paramContext, String paramString)
  {
    AppMethodBeat.i(223143);
    kh.c("TO", "开始更新配置：".concat(String.valueOf(paramString)));
    Object localObject1 = (rq)JsonUtils.parseToModel(paramString, rq.class, new Object[0]);
    if (localObject1 != null)
    {
      localObject2 = ((rq)localObject1).b;
      if (localObject2 != null) {}
    }
    else
    {
      kh.c("TO", "配置更新数据解析失败，使用上次的配置");
      AppMethodBeat.o(223143);
      return false;
    }
    boolean bool1;
    if (((rq)localObject1).a != 0)
    {
      bool1 = this.e;
      this.e = false;
      kh.c("TO", "权限是否更新：".concat(String.valueOf(bool1)));
      if (((rp)localObject2).g == this.d) {
        break label168;
      }
    }
    label168:
    for (boolean bool2 = true;; bool2 = false)
    {
      kh.c("TO", "协议版本是否更新：".concat(String.valueOf(bool2)));
      if ((bool1 | bool2)) {
        break label174;
      }
      AppMethodBeat.o(223143);
      return false;
      if (!this.e) {}
      for (bool1 = true;; bool1 = false)
      {
        this.e = true;
        break;
      }
    }
    label174:
    Object localObject3 = a((rp)localObject2);
    if (localObject3 != null)
    {
      int m = ((rl)localObject3).d;
      localObject3 = ((rl)localObject3).e;
      if (localObject3 != null)
      {
        int n = ((rr)localObject3).d;
        int i1 = ((rr)localObject3).b;
        kh.c("TO", "版本对比: old[" + this.c + "]-new[" + n + "]");
        kh.c("TO", "样式对比: old[" + this.b + "]-new[" + i1 + "]");
        if ((n != this.c) || (i1 != this.b) || (m != this.a))
        {
          localObject3 = new File(mf.a(paramContext, null).b(), a());
          if (((File)localObject3).exists())
          {
            ka.b((File)localObject3);
            kh.c("TO", "删除海外图缓存目录: ".concat(String.valueOf(localObject3)));
          }
        }
      }
    }
    Object localObject2 = ((rp)localObject2).h;
    if (localObject2 != null)
    {
      localObject3 = ((ro)localObject2).b;
      kh.c("TO", "配置边界线: ".concat(String.valueOf(localObject3)));
      a((String)localObject3);
      ((ro)localObject2).a = this.f;
    }
    this.g = ((rq)localObject1);
    localObject1 = this.i;
    paramContext = me.a(paramContext);
    switch (3.a[localObject1.ordinal()])
    {
    }
    for (;;)
    {
      a(this.g);
      kh.c("TO", "配置更新完成");
      AppMethodBeat.o(223143);
      return true;
      paramContext.a("worldMapConfig", paramString);
      continue;
      paramContext.a("worldMapConfig_BING", paramString);
    }
  }
  
  private rr b(rp paramrp)
  {
    AppMethodBeat.i(223214);
    if (paramrp == null)
    {
      AppMethodBeat.o(223214);
      return null;
    }
    paramrp = a(paramrp);
    if (paramrp != null)
    {
      paramrp = paramrp.e;
      AppMethodBeat.o(223214);
      return paramrp;
    }
    AppMethodBeat.o(223214);
    return null;
  }
  
  private File b(Context paramContext)
  {
    AppMethodBeat.i(223152);
    paramContext = new File(mf.a(paramContext, null).b(), a());
    AppMethodBeat.o(223152);
    return paramContext;
  }
  
  private static List<rm> c(rp paramrp)
  {
    if (paramrp != null) {
      return paramrp.j;
    }
    return null;
  }
  
  private int e()
  {
    return this.d;
  }
  
  private boolean f()
  {
    return this.e;
  }
  
  private int g()
  {
    return this.f;
  }
  
  private ro h()
  {
    if (this.g == null) {}
    rp localrp;
    do
    {
      return null;
      localrp = this.g.b;
    } while (localrp == null);
    return localrp.h;
  }
  
  private boolean i()
  {
    return this.h;
  }
  
  private OverSeaSource j()
  {
    return this.i;
  }
  
  private int k()
  {
    AppMethodBeat.i(223255);
    int m = 0;
    switch (3.a[this.i.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(223255);
      return m;
      m = 2;
      continue;
      m = 1;
    }
  }
  
  private Language l()
  {
    return this.j;
  }
  
  private OverSeaTileProvider m()
  {
    return this.k;
  }
  
  public final rl a(rp paramrp)
  {
    AppMethodBeat.i(223425);
    if (paramrp != null)
    {
      paramrp = paramrp.i;
      if (paramrp != null)
      {
        paramrp = paramrp.iterator();
        while (paramrp.hasNext())
        {
          rl localrl = (rl)paramrp.next();
          if ((localrl.d == 2) && (this.h))
          {
            AppMethodBeat.o(223425);
            return localrl;
          }
          if ((localrl.d == 1) && (!this.h))
          {
            AppMethodBeat.o(223425);
            return localrl;
          }
        }
      }
    }
    AppMethodBeat.o(223425);
    return null;
  }
  
  public final String a()
  {
    AppMethodBeat.i(223351);
    boolean bool = false;
    String str1;
    if (this.k != null)
    {
      bool = this.k.onDayNightChange(this.h);
      str1 = "rastermap/customoversea/" + this.k.getProviderName();
      if ((!this.h) || (!bool)) {
        break label140;
      }
    }
    label140:
    for (String str2 = "/dark";; str2 = "")
    {
      str1 = str1 + str2;
      AppMethodBeat.o(223351);
      return str1;
      switch (3.a[this.i.ordinal()])
      {
      default: 
        bool = true;
        str1 = "rastermap/world";
        break;
      case 2: 
        str1 = "rastermap/bingworld";
        break;
      }
    }
  }
  
  public final void a(Context paramContext)
  {
    AppMethodBeat.i(223375);
    localme = me.a(paramContext);
    kh.c("TO", "兼容老数据");
    int n = localme.b("worldMapStyle", 1000);
    int i1 = localme.b("worldMapScene", rp.a);
    int i2 = localme.b("worldMapVersion", rp.c);
    int i3 = localme.b("worldMapProtocolVersion", 0);
    bool = localme.c("worldMapEnabled");
    localObject3 = localme.a("worldMapTileUrlRegex");
    localObject2 = new int[0];
    localObject1 = localObject2;
    try
    {
      Object localObject4 = localme.a("worldMapTileUrlRangeJson");
      localObject1 = localObject2;
      paramContext = (Context)localObject2;
      int m;
      if (!gz.a((String)localObject4))
      {
        localObject1 = localObject2;
        localObject4 = new JSONArray((String)localObject4);
        localObject1 = localObject2;
        localObject2 = new int[((JSONArray)localObject4).length()];
        m = 0;
        for (;;)
        {
          localObject1 = localObject2;
          paramContext = (Context)localObject2;
          if (m >= localObject2.length) {
            break;
          }
          localObject1 = localObject2;
          localObject2[m] = ((JSONArray)localObject4).getInt(m);
          m += 1;
        }
      }
      try
      {
        if (!gz.a((String)localObject4)) {
          paramContext = JsonUtils.parseToList(new JSONArray((String)localObject4), rm.class, new Object[0]);
        }
        ((rp)localObject3).j = paramContext;
        paramContext = new ArrayList();
        paramContext.add(localObject2);
        ((rp)localObject3).i = paramContext;
        paramContext = new ro();
        paramContext.a = m;
        ((rp)localObject3).h = paramContext;
        this.g = new rq();
        paramContext = this.g;
        if (bool)
        {
          m = 0;
          paramContext.a = m;
          this.g.b = ((rp)localObject3);
          paramContext = this.g.toJson().toString();
          kh.c("TO", "老数据：".concat(String.valueOf(paramContext)));
          localme.a("worldMapConfig", paramContext);
          localme.a(new String[] { "worldMapStyle", "worldMapScene", "worldMapVersion", "worldMapProtocolVersion", "worldMapEnabled", "worldMapTileUrlRegex", "worldMapTileUrlRangeJson", "worldMapLogoChangeRuleJson", "worldMapFrontierVersion" });
          a(this.g);
          AppMethodBeat.o(223375);
          return;
        }
      }
      catch (JSONException paramContext)
      {
        for (;;)
        {
          kh.b("TO", paramContext);
          paramContext = (Context)localObject1;
          continue;
          m = -1;
        }
      }
    }
    catch (Exception paramContext)
    {
      kh.b("TO", paramContext);
      paramContext = (Context)localObject1;
      localObject4 = localme.a("worldMapLogoChangeRuleJson");
      m = localme.b("worldMapFrontierVersion", 0);
      localObject2 = new rl();
      ((rl)localObject2).d = 1;
      localObject1 = new rr();
      ((rr)localObject1).e = ((String)localObject3);
      ((rr)localObject1).f = paramContext;
      ((rr)localObject1).c = i1;
      ((rr)localObject1).b = n;
      ((rr)localObject1).d = i2;
      ((rl)localObject2).e = ((rr)localObject1);
      localObject3 = new rp();
      ((rp)localObject3).g = i3;
      localObject1 = null;
      paramContext = (Context)localObject1;
    }
  }
  
  public final void a(rq paramrq)
  {
    AppMethodBeat.i(223360);
    if (paramrq == null)
    {
      AppMethodBeat.o(223360);
      return;
    }
    Object localObject = paramrq.b;
    if (localObject != null)
    {
      this.d = ((rp)localObject).g;
      kh.c("TO", "更新版本：" + this.d);
      ro localro = ((rp)localObject).h;
      if (localro != null)
      {
        this.f = localro.a;
        kh.c("TO", "更新边界版本：" + this.c);
      }
    }
    localObject = b((rp)localObject);
    if (localObject != null)
    {
      this.b = ((rr)localObject).b;
      this.a = ((rr)localObject).c;
      this.c = ((rr)localObject).d;
      this.l = ((rr)localObject).e;
      kh.c("TO", "更新图源版本：" + this.c);
    }
    if (paramrq.a == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.e = bool;
      AppMethodBeat.o(223360);
      return;
    }
  }
  
  public final void a(String paramString)
  {
    AppMethodBeat.i(223336);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(223336);
      return;
    }
    kh.c("TO", "下载新边界数据：".concat(String.valueOf(paramString)));
    label220:
    for (;;)
    {
      try
      {
        paramString = NetManager.getInstance().builder().gzip().url(paramString).doStream();
        InputStream localInputStream = paramString.getInputStream();
        if (paramString.statusCode == 200)
        {
          if (!TextUtils.isEmpty(paramString.contentEncoding)) {
            continue;
          }
          paramString = "gzip";
          if ((paramString == null) || (paramString.length() <= 0) || (!paramString.toLowerCase().contains("gzip"))) {
            break label220;
          }
          m = 1;
          if (m == 0) {
            continue;
          }
          paramString = kd.a(localInputStream);
          if ((paramString != null) && (paramString.length > 0))
          {
            paramString = new String(paramString);
            rg.a();
            this.f = rg.b(paramString);
            kh.c("TO", "新边界数据版本号：" + this.f);
            rg.a().a(paramString);
          }
        }
        AppMethodBeat.o(223336);
        return;
        paramString = paramString.contentEncoding;
        continue;
        paramString = kb.b(localInputStream);
        continue;
        int m = 0;
      }
      finally
      {
        kh.b("TO", paramString);
        AppMethodBeat.o(223336);
        return;
      }
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    AppMethodBeat.i(223386);
    kh.c("TO", "使用海外暗色模式？".concat(String.valueOf(paramBoolean)));
    this.h = paramBoolean;
    AppMethodBeat.o(223386);
  }
  
  public final rr b()
  {
    AppMethodBeat.i(223397);
    if (this.g == null)
    {
      AppMethodBeat.o(223397);
      return null;
    }
    rr localrr = b(this.g.b);
    AppMethodBeat.o(223397);
    return localrr;
  }
  
  public final List<rm> c()
  {
    AppMethodBeat.i(223410);
    if (this.g == null)
    {
      AppMethodBeat.o(223410);
      return null;
    }
    if (this.k != null)
    {
      localObject = new ArrayList(c(this.g.b));
      rm localrm = new rm();
      localrm.a = new int[] { 0, 18 };
      ArrayList localArrayList = new ArrayList();
      rn localrn = new rn();
      localrn.b = "china";
      localrn.h = true;
      localrn.a = 1;
      localrn.c = this.k.getProviderName();
      localrn.f = this.k.getLogo(true);
      localrn.g = this.k.getLogo(false);
      localArrayList.add(localrn);
      localrm.b = localArrayList;
      ((List)localObject).add(0, localrm);
      AppMethodBeat.o(223410);
      return localObject;
    }
    Object localObject = c(this.g.b);
    AppMethodBeat.o(223410);
    return localObject;
  }
  
  public final String d()
  {
    AppMethodBeat.i(223437);
    if (this.k != null)
    {
      localObject = this.k.getProviderVersion() + File.separator + this.j.name();
      AppMethodBeat.o(223437);
      return localObject;
    }
    Object localObject = b();
    if (localObject != null)
    {
      localObject = ((rr)localObject).c + File.separator + ((rr)localObject).b + File.separator + ((rr)localObject).d + File.separator + this.j.name();
      AppMethodBeat.o(223437);
      return localObject;
    }
    AppMethodBeat.o(223437);
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.ri
 * JD-Core Version:    0.7.0.1
 */