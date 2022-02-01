package com.tencent.mapsdk.internal;

import android.os.Message;
import android.text.TextUtils;
import com.tencent.map.sdk.comps.vis.VisualLayer;
import com.tencent.map.sdk.comps.vis.VisualLayerOptions;
import com.tencent.map.tools.Callback;
import com.tencent.map.tools.Condition;
import com.tencent.map.tools.Util;
import com.tencent.map.tools.json.JsonUtils;
import com.tencent.map.tools.net.NetRequest.NetRequestBuilder;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class rc
  extends bl
  implements dv
{
  private Map<String, qz> a;
  private File b;
  private File c;
  private String d;
  private boolean e;
  private List<ea> f;
  private eb g;
  private rc.b h;
  private le i;
  private Set<String> j;
  private boolean k;
  
  private boolean b(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(223366);
    kh.b("TDL", "#parseLayerInfoJson:".concat(String.valueOf(paramJSONObject)));
    paramJSONObject = (eb)JsonUtils.parseToModel(paramJSONObject, eb.class, new Object[0]);
    if (paramJSONObject != null)
    {
      this.e = paramJSONObject.a();
      this.f.clear();
      List localList = paramJSONObject.a;
      if ((localList != null) && (!localList.isEmpty())) {
        this.f.addAll(localList);
      }
      kh.b("TDL", "解析LayerInfo数据成功");
      this.g = paramJSONObject;
      AppMethodBeat.o(223366);
      return true;
    }
    kh.d("TDL", "解析LayerInfo数据失败");
    AppMethodBeat.o(223366);
    return false;
  }
  
  private void d()
  {
    AppMethodBeat.i(223391);
    kh.b("TDL", "#loadLayerJsonFromLocal");
    Object localObject = ka.c(this.c);
    if ((localObject != null) && (localObject.length > 0))
    {
      localObject = new String((byte[])localObject);
      try
      {
        b(new JSONObject((String)localObject));
        AppMethodBeat.o(223391);
        return;
      }
      catch (JSONException localJSONException) {}
    }
    AppMethodBeat.o(223391);
  }
  
  private void e()
  {
    AppMethodBeat.i(223401);
    kh.b("TDL", "#restoreLayerJsonToLocal");
    if ((this.g != null) && (this.e))
    {
      JSONObject localJSONObject = this.g.toJson();
      if (localJSONObject != null) {
        f(localJSONObject.toString());
      }
    }
    AppMethodBeat.o(223401);
  }
  
  private void f(String paramString)
  {
    AppMethodBeat.i(223373);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(223373);
      return;
    }
    ka.b(this.c);
    ka.a(this.c, paramString.getBytes());
    AppMethodBeat.o(223373);
  }
  
  private void g(String paramString)
  {
    AppMethodBeat.i(223383);
    kh.b("TDL", "#refreshLayerData[" + paramString + "]");
    paramString = (qz)this.a.get(paramString);
    if (paramString != null) {
      paramString.b(this);
    }
    AppMethodBeat.o(223383);
  }
  
  private File h(String paramString)
  {
    AppMethodBeat.i(223414);
    paramString = new File(new File(this.b, Util.getMD5String(paramString)), "cache.dat");
    AppMethodBeat.o(223414);
    return paramString;
  }
  
  private ea i(final String paramString)
  {
    AppMethodBeat.i(223424);
    paramString = (ea)Util.singleWhere(new ArrayList(this.f), new Condition()
    {
      private boolean a(ea paramAnonymousea)
      {
        AppMethodBeat.i(223019);
        if ((paramAnonymousea != null) && (paramString.equals(paramString)))
        {
          AppMethodBeat.o(223019);
          return true;
        }
        AppMethodBeat.o(223019);
        return false;
      }
    });
    AppMethodBeat.o(223424);
    return paramString;
  }
  
  private qz j(final String paramString)
  {
    AppMethodBeat.i(223433);
    paramString = (qz)Util.singleWhere(this.a.values(), new Condition()
    {
      private boolean a(qz paramAnonymousqz)
      {
        AppMethodBeat.i(223021);
        if ((paramAnonymousqz != null) && (paramAnonymousqz.getId().equals(paramString)))
        {
          AppMethodBeat.o(223021);
          return true;
        }
        AppMethodBeat.o(223021);
        return false;
      }
    });
    AppMethodBeat.o(223433);
    return paramString;
  }
  
  public final VisualLayer a(VisualLayerOptions paramVisualLayerOptions)
  {
    AppMethodBeat.i(223497);
    if (paramVisualLayerOptions == null)
    {
      AppMethodBeat.o(223497);
      return null;
    }
    Object localObject = paramVisualLayerOptions.getLayerId();
    kh.b("TDL", "#createLayer[" + (String)localObject + "]");
    localObject = (qz)this.a.get(paramVisualLayerOptions.getLayerId());
    if (localObject != null)
    {
      ((qz)localObject).a(paramVisualLayerOptions);
      AppMethodBeat.o(223497);
      return localObject;
    }
    localObject = new qz(paramVisualLayerOptions);
    this.a.put(paramVisualLayerOptions.getLayerId(), localObject);
    ((qz)localObject).a(this);
    AppMethodBeat.o(223497);
    return localObject;
  }
  
  public final void a(bm parambm)
  {
    AppMethodBeat.i(223486);
    super.a(parambm);
    this.k = false;
    this.h = new rc.b(this);
    this.a = new ConcurrentHashMap();
    this.f = new CopyOnWriteArrayList();
    this.i = new le();
    this.j = new HashSet();
    this.d = parambm.u().a;
    if (!TextUtils.isEmpty(parambm.u().c)) {
      this.d = parambm.u().c;
    }
    String str = parambm.u().c();
    this.b = new File(parambm.t().b(), "visual/".concat(String.valueOf(str)));
    this.c = new File(this.b, "layerInfo.json");
    kh.b("TDL", "#datalayer config file [" + this.c + "]");
    kh.b("TDL", "#loadLayerJsonFromLocal");
    parambm = ka.c(this.c);
    if ((parambm != null) && (parambm.length > 0))
    {
      parambm = new String(parambm);
      try
      {
        b(new JSONObject(parambm));
        AppMethodBeat.o(223486);
        return;
      }
      catch (JSONException parambm) {}
    }
    AppMethodBeat.o(223486);
  }
  
  public final void a(String paramString)
  {
    AppMethodBeat.i(223515);
    kh.b("TDL", "#removeLayer[" + paramString + "]");
    if (this.a != null) {
      this.a.remove(paramString);
    }
    e(paramString);
    AppMethodBeat.o(223515);
  }
  
  public final void a(String paramString, int paramInt)
  {
    AppMethodBeat.i(223593);
    kh.b("TDL", "#startTimeInterval[" + paramString + "], hash = " + paramString.hashCode() + " timeInterval = " + paramInt);
    if ((paramInt > 0) && (!TextUtils.isEmpty(paramString)))
    {
      this.h.removeMessages(paramString.hashCode());
      Message.obtain(this.h, paramString.hashCode(), paramInt * 1000, 0, paramString).sendToTarget();
    }
    AppMethodBeat.o(223593);
  }
  
  public final void a(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(223508);
    kh.b("TDL", "#updateLayerVersionInfo[" + paramString + "], dv=" + paramInt1 + " sv=" + paramInt2);
    paramString = i(paramString);
    if (paramString != null)
    {
      if (paramInt2 != paramString.d) {
        paramString.e = null;
      }
      paramString.d = paramInt2;
      if (paramInt1 != paramString.c) {
        paramString.e = null;
      }
      paramString.c = paramInt1;
    }
    AppMethodBeat.o(223508);
  }
  
  public final void a(final String paramString, final Callback<byte[]> paramCallback)
  {
    AppMethodBeat.i(223567);
    kh.b("TDL", "#readLayerDataFromCache[" + paramString + "]");
    jw.b(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(223098);
        byte[] arrayOfByte = ka.c(rc.b(rc.this, paramString));
        paramCallback.callback(arrayOfByte);
        AppMethodBeat.o(223098);
      }
    });
    AppMethodBeat.o(223567);
  }
  
  public final void a(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(223585);
    kh.b("TDL", "#saveLayerData[" + paramString + "]");
    paramString = h(paramString);
    File localFile = ka.e(paramString);
    ka.a(localFile, paramArrayOfByte);
    ka.a(localFile, paramString);
    AppMethodBeat.o(223585);
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    boolean bool = false;
    AppMethodBeat.i(223541);
    kh.b("TDL", "#saveLayerInfosToLocal[" + paramJSONObject + "]");
    this.k = true;
    if (paramJSONObject != null)
    {
      bool = b(paramJSONObject);
      if (!bool) {
        break label233;
      }
      f(paramJSONObject.toString());
      if (this.j.isEmpty()) {
        break label233;
      }
      kh.b("TDL", "初始化等待队列图层[" + this.j.size() + "]");
      paramJSONObject = this.j.iterator();
      while (paramJSONObject.hasNext())
      {
        Object localObject = (String)paramJSONObject.next();
        localObject = (qz)this.a.get(localObject);
        if (localObject != null) {
          ((qz)localObject).a(this);
        }
      }
      this.j.clear();
    }
    label233:
    for (;;)
    {
      if ((!bool) || (!this.e)) {
        Util.foreach(this.a.values(), new Callback()
        {
          private static void a(qz paramAnonymousqz)
          {
            AppMethodBeat.i(223081);
            if (paramAnonymousqz != null)
            {
              paramAnonymousqz.a(2);
              paramAnonymousqz.a();
            }
            AppMethodBeat.o(223081);
          }
        });
      }
      AppMethodBeat.o(223541);
      return;
      this.e = false;
      this.f.clear();
      this.g = null;
    }
  }
  
  public final boolean a()
  {
    return this.k;
  }
  
  public final void b(bm parambm)
  {
    AppMethodBeat.i(223611);
    super.b(parambm);
    if (this.a != null)
    {
      parambm = this.a.values().iterator();
      while (parambm.hasNext())
      {
        VisualLayer localVisualLayer = (VisualLayer)parambm.next();
        if (!localVisualLayer.isRemoved()) {
          localVisualLayer.remove();
        }
      }
      this.a.clear();
    }
    kh.b("TDL", "#restoreLayerJsonToLocal");
    if ((this.g != null) && (this.e))
    {
      parambm = this.g.toJson();
      if (parambm != null) {
        f(parambm.toString());
      }
    }
    kh.b("TDL", "退出数据图层成功");
    AppMethodBeat.o(223611);
  }
  
  public final void b(String paramString)
  {
    AppMethodBeat.i(223526);
    kh.b("TDL", "#clearCache[" + paramString + "]");
    if ((paramString != null) && (!TextUtils.isEmpty(paramString)))
    {
      File localFile = h(paramString);
      kh.b("TDL", "执行删除文件[" + localFile + "]");
      ka.f(localFile);
      a(paramString, 0, 0);
    }
    AppMethodBeat.o(223526);
  }
  
  public final void b(String paramString, Callback<byte[]> paramCallback)
  {
    AppMethodBeat.i(223577);
    kh.b("TDL", "#requestNew[" + paramString + "]");
    Object localObject = i(paramString);
    int n = 0;
    int m = n;
    if (localObject != null)
    {
      localObject = ((ea)localObject).a();
      m = n;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        m = 1;
        localObject = ((String)localObject).concat("&key=" + this.d);
        kh.b("TDL", "请求数据的URL[" + (String)localObject + "]");
        paramString = new a(paramString, (String)localObject);
        paramString.c.i.a(paramString);
        paramString.c.i.a(paramString.a, paramString);
        paramString.b = paramCallback;
      }
    }
    if (m == 0) {
      paramCallback.callback(null);
    }
    AppMethodBeat.o(223577);
  }
  
  public final boolean c(String paramString)
  {
    AppMethodBeat.i(223550);
    kh.b("TDL", "#checkLayerStatusById[" + paramString + "]");
    if (this.e)
    {
      ea localea = i(paramString);
      if (localea != null)
      {
        paramString = j(paramString);
        if (paramString != null) {
          switch (rc.5.a[dw.a(localea.b).ordinal()])
          {
          }
        }
      }
      while (localea != null)
      {
        AppMethodBeat.o(223550);
        return true;
        paramString.a = new rb();
        continue;
        paramString.a = new qx();
        continue;
        paramString.a = new qy();
      }
      AppMethodBeat.o(223550);
      return false;
    }
    AppMethodBeat.o(223550);
    return false;
  }
  
  public final void d(String paramString)
  {
    AppMethodBeat.i(223559);
    kh.d("TDL", "添加到等待队列[" + paramString + "]");
    this.j.add(paramString);
    AppMethodBeat.o(223559);
  }
  
  public final void e(String paramString)
  {
    AppMethodBeat.i(223600);
    kh.b("TDL", "#stopTimeInterval[" + paramString + "]");
    if (!TextUtils.isEmpty(paramString)) {
      this.h.removeMessages(paramString.hashCode());
    }
    AppMethodBeat.o(223600);
  }
  
  final class a
    extends lk
    implements ld
  {
    final String a;
    Callback<byte[]> b;
    private final String d;
    private ByteArrayOutputStream e;
    private String f;
    
    public a(String paramString1, String paramString2)
    {
      this.d = paramString1;
      this.a = paramString2;
    }
    
    private void a(Callback<byte[]> paramCallback)
    {
      AppMethodBeat.i(222517);
      rc.a(rc.this).a(this);
      rc.a(rc.this).a(this.a, this);
      this.b = paramCallback;
      AppMethodBeat.o(222517);
    }
    
    public final void a(NetRequest.NetRequestBuilder paramNetRequestBuilder)
    {
      AppMethodBeat.i(222572);
      super.a(paramNetRequestBuilder);
      paramNetRequestBuilder.gzip();
      AppMethodBeat.o(222572);
    }
    
    public final void a(NetResponse paramNetResponse)
    {
      AppMethodBeat.i(222587);
      super.a(paramNetResponse);
      this.f = paramNetResponse.contentEncoding;
      AppMethodBeat.o(222587);
    }
    
    public final void a(lf paramlf) {}
    
    public final void a(String paramString)
    {
      AppMethodBeat.i(222532);
      kh.b("TDL", "#start download {" + this.d + "} [" + paramString + "]");
      this.e = new ByteArrayOutputStream();
      AppMethodBeat.o(222532);
    }
    
    public final void a(String paramString, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(222546);
      if (paramArrayOfByte != null) {
        try
        {
          this.e.write(paramArrayOfByte);
          AppMethodBeat.o(222546);
          return;
        }
        catch (IOException paramString) {}
      }
      AppMethodBeat.o(222546);
    }
    
    public final void b(String paramString)
    {
      AppMethodBeat.i(222561);
      kh.b("TDL", "#cancel download {" + this.d + "} [" + paramString + "]");
      kb.a(this.e);
      paramString = rc.c(rc.this, this.d);
      if (paramString != null) {
        paramString.a(1);
      }
      AppMethodBeat.o(222561);
    }
    
    public final void c(String paramString)
    {
      int j = 0;
      AppMethodBeat.i(222602);
      kh.b("TDL", "#completed download {" + this.d + "} [" + paramString + "]");
      rc.a(rc.this).b(this);
      Object localObject;
      if (this.b != null)
      {
        localObject = this.e.toByteArray();
        if (!"gzip".equals(this.f)) {
          break label198;
        }
      }
      label198:
      for (paramString = kd.a(new ByteArrayInputStream((byte[])localObject));; paramString = (String)localObject)
      {
        StringBuilder localStringBuilder = new StringBuilder("数据量大小 {").append(this.d).append("} [");
        if (localObject != null) {}
        for (int i = localObject.length;; i = 0)
        {
          localObject = localStringBuilder.append(i).append(" : ");
          i = j;
          if (paramString != null) {
            i = paramString.length;
          }
          kh.b("TDL", i + "]");
          this.b.callback(paramString);
          kb.a(this.e);
          AppMethodBeat.o(222602);
          return;
        }
      }
    }
    
    public final void d(String paramString)
    {
      AppMethodBeat.i(222612);
      kh.b("TDL", "#fail download {" + this.d + "} [" + paramString + "]");
      kb.a(this.e);
      paramString = rc.c(rc.this, this.d);
      if (paramString != null) {
        paramString.a(1);
      }
      AppMethodBeat.o(222612);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.rc
 * JD-Core Version:    0.7.0.1
 */