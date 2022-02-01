package com.tencent.mapsdk.internal;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.map.tools.json.JsonUtils;
import com.tencent.map.tools.net.NetConfig;
import com.tencent.map.tools.net.NetManager;
import com.tencent.mapsdk.core.components.protocol.jce.conf.CSFileUpdateReq;
import com.tencent.mapsdk.core.components.protocol.jce.conf.FileUpdateReq;
import com.tencent.mapsdk.core.components.protocol.jce.conf.FileUpdateRsp;
import com.tencent.mapsdk.core.components.protocol.jce.conf.SCFileUpdateRsp;
import com.tencent.mapsdk.core.components.protocol.jce.rtt.RttRequest;
import com.tencent.mapsdk.core.components.protocol.jce.rtt.RttResponse;
import com.tencent.mapsdk.core.components.protocol.jce.sso.CmdResult;
import com.tencent.mapsdk.core.components.protocol.jce.sso.Header;
import com.tencent.mapsdk.core.components.protocol.jce.sso.Package;
import com.tencent.mapsdk.core.components.protocol.jce.sso.Tag;
import com.tencent.mapsdk.core.components.protocol.jce.trafficevent.Basic;
import com.tencent.mapsdk.core.components.protocol.jce.trafficevent.Detail;
import com.tencent.mapsdk.core.components.protocol.jce.trafficevent.Response;
import com.tencent.mapsdk.core.components.protocol.jce.user.user_login_t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import com.tencent.tencentmap.mapsdk.maps.TencentMapProtocol;
import com.tencent.tencentmap.mapsdk.maps.TencentMapServiceProtocol.IMapService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class cj
  extends bl
  implements cf, TencentMapProtocol
{
  private static final String a = "cuid";
  private static final Stack<cb> e;
  private static final cb f;
  private cb b;
  private final Map<String, String> c;
  private TencentMapOptions d;
  
  static
  {
    AppMethodBeat.i(222777);
    e = new Stack();
    f = new cc();
    AppMethodBeat.o(222777);
  }
  
  public cj()
  {
    AppMethodBeat.i(222694);
    this.c = new HashMap();
    AppMethodBeat.o(222694);
  }
  
  private cj(TencentMapOptions paramTencentMapOptions, cb paramcb)
  {
    AppMethodBeat.i(222699);
    this.c = new HashMap();
    this.d = paramTencentMapOptions;
    this.b = paramcb;
    AppMethodBeat.o(222699);
  }
  
  private cb a(bm parambm, String paramString, int paramInt)
  {
    AppMethodBeat.i(222735);
    parambm = a(paramString, parambm.getContext().getResources().openRawResource(paramInt));
    AppMethodBeat.o(222735);
    return parambm;
  }
  
  /* Error */
  private cb a(bm parambm, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 90
    //   2: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: invokevirtual 71	com/tencent/mapsdk/internal/bm:getContext	()Landroid/content/Context;
    //   9: invokevirtual 77	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   12: invokevirtual 94	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   15: aload_3
    //   16: invokevirtual 100	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   19: astore_1
    //   20: aload_0
    //   21: aload_2
    //   22: aload_1
    //   23: invokespecial 86	com/tencent/mapsdk/internal/cj:a	(Ljava/lang/String;Ljava/io/InputStream;)Lcom/tencent/mapsdk/internal/cb;
    //   26: astore_2
    //   27: aload_1
    //   28: invokestatic 105	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   31: ldc 90
    //   33: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   36: aload_2
    //   37: areturn
    //   38: astore_1
    //   39: aconst_null
    //   40: astore_1
    //   41: aload_1
    //   42: invokestatic 105	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   45: ldc 90
    //   47: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   50: aconst_null
    //   51: areturn
    //   52: astore_1
    //   53: aconst_null
    //   54: astore_2
    //   55: aload_2
    //   56: invokestatic 105	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   59: ldc 90
    //   61: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   64: aload_1
    //   65: athrow
    //   66: astore_2
    //   67: aload_1
    //   68: astore_3
    //   69: aload_2
    //   70: astore_1
    //   71: aload_3
    //   72: astore_2
    //   73: goto -18 -> 55
    //   76: astore_2
    //   77: goto -36 -> 41
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	cj
    //   0	80	1	parambm	bm
    //   0	80	2	paramString1	String
    //   0	80	3	paramString2	String
    // Exception table:
    //   from	to	target	type
    //   5	20	38	java/io/IOException
    //   5	20	52	finally
    //   20	27	66	finally
    //   20	27	76	java/io/IOException
  }
  
  /* Error */
  private cb a(String paramString, java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: ldc 106
    //   2: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_2
    //   6: ifnull +56 -> 62
    //   9: aconst_null
    //   10: astore 5
    //   12: sipush 1024
    //   15: newarray byte
    //   17: astore 6
    //   19: new 108	java/io/ByteArrayOutputStream
    //   22: dup
    //   23: invokespecial 109	java/io/ByteArrayOutputStream:<init>	()V
    //   26: astore 4
    //   28: aload_2
    //   29: aload 6
    //   31: invokevirtual 115	java/io/InputStream:read	([B)I
    //   34: istore_3
    //   35: iconst_m1
    //   36: iload_3
    //   37: if_icmpeq +40 -> 77
    //   40: aload 4
    //   42: aload 6
    //   44: iconst_0
    //   45: iload_3
    //   46: invokevirtual 119	java/io/ByteArrayOutputStream:write	([BII)V
    //   49: goto -21 -> 28
    //   52: astore_1
    //   53: aload 4
    //   55: invokestatic 105	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   58: aload_2
    //   59: invokestatic 105	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   62: new 43	com/tencent/mapsdk/internal/cc
    //   65: dup
    //   66: invokespecial 44	com/tencent/mapsdk/internal/cc:<init>	()V
    //   69: astore_1
    //   70: ldc 106
    //   72: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   75: aload_1
    //   76: areturn
    //   77: aload_0
    //   78: aload_1
    //   79: new 121	java/lang/String
    //   82: dup
    //   83: aload 4
    //   85: invokevirtual 125	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   88: ldc 127
    //   90: invokestatic 133	java/nio/charset/Charset:forName	(Ljava/lang/String;)Ljava/nio/charset/Charset;
    //   93: invokespecial 136	java/lang/String:<init>	([BLjava/nio/charset/Charset;)V
    //   96: invokespecial 139	com/tencent/mapsdk/internal/cj:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mapsdk/internal/cb;
    //   99: astore_1
    //   100: aload 4
    //   102: invokestatic 105	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   105: aload_2
    //   106: invokestatic 105	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   109: ldc 106
    //   111: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   114: aload_1
    //   115: areturn
    //   116: astore_1
    //   117: aconst_null
    //   118: astore 4
    //   120: aload 4
    //   122: invokestatic 105	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   125: aload_2
    //   126: invokestatic 105	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   129: ldc 106
    //   131: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   134: aload_1
    //   135: athrow
    //   136: astore_1
    //   137: goto -17 -> 120
    //   140: astore_1
    //   141: aload 5
    //   143: astore 4
    //   145: goto -92 -> 53
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	148	0	this	cj
    //   0	148	1	paramString	String
    //   0	148	2	paramInputStream	java.io.InputStream
    //   34	12	3	i	int
    //   26	118	4	localObject1	Object
    //   10	132	5	localObject2	Object
    //   17	26	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   28	35	52	java/io/IOException
    //   40	49	52	java/io/IOException
    //   77	100	52	java/io/IOException
    //   12	28	116	finally
    //   28	35	136	finally
    //   40	49	136	finally
    //   77	100	136	finally
    //   12	28	140	java/io/IOException
  }
  
  private cb a(String paramString1, String paramString2)
  {
    int i = 0;
    AppMethodBeat.i(222749);
    try
    {
      Object localObject = new JSONObject(paramString2);
      paramString2 = ((JSONObject)localObject).optString("sdk_protocol", "-1");
      String str = ((JSONObject)localObject).optString("_private_partner", "_unknown");
      if ((!"-1".equals(paramString2)) && (str.equals(paramString1)))
      {
        paramString2 = new ci();
        paramString2.a = paramString1;
        paramString2.a(this);
        paramString1 = ((JSONObject)localObject).optJSONArray("services");
        if ((paramString1 != null) && (paramString1.length() > 0)) {
          while (i < paramString1.length())
          {
            paramString2.a(paramString1.getJSONObject(i));
            i += 1;
          }
        }
        paramString1 = ((JSONObject)localObject).optJSONObject("business_conf");
        if (paramString1 != null)
        {
          paramString1 = (ck)JsonUtils.parseToModel(paramString1, ck.class, new Object[0]);
          localObject = paramString2.b;
          ((cm)localObject).a = paramString1.a;
          ((cm)localObject).b = paramString1.b;
        }
        AppMethodBeat.o(222749);
        return paramString2;
      }
    }
    catch (JSONException paramString1)
    {
      paramString1 = f;
      AppMethodBeat.o(222749);
    }
    return paramString1;
  }
  
  public static <S extends ch> S a(Class<S> paramClass)
  {
    AppMethodBeat.i(222762);
    if (e.isEmpty())
    {
      paramClass = f.c(paramClass);
      AppMethodBeat.o(222762);
      return paramClass;
    }
    paramClass = ((cb)e.peek()).c(paramClass);
    AppMethodBeat.o(222762);
    return paramClass;
  }
  
  private static void a(Context paramContext, TencentMapOptions paramTencentMapOptions)
  {
    AppMethodBeat.i(222710);
    NetManager.init(paramContext, NetConfig.create().setAdapterType(paramTencentMapOptions.getNetAdapterType()).setLogEnable(ry.d).setForceHttps(paramTencentMapOptions.isForceHttps()).setArguments(paramTencentMapOptions.getNetParams()).setProxyRuleList(e().b()));
    AppMethodBeat.o(222710);
  }
  
  private void a(bm parambm, TencentMapOptions paramTencentMapOptions)
  {
    AppMethodBeat.i(222718);
    Object localObject = paramTencentMapOptions.getProtocolDataDesc();
    String str = parambm.u().a;
    if (this.b == null) {
      this.b = f;
    }
    if (localObject != null) {}
    switch (paramTencentMapOptions.getProtocolFrom())
    {
    case 0: 
    case 2: 
    default: 
      parambm = null;
      if (parambm != null) {
        this.b = parambm;
      }
      if (this.b != null)
      {
        this.b.a = str;
        this.b.a(this);
      }
      break;
    }
    for (;;)
    {
      e.push(this.b);
      AppMethodBeat.o(222718);
      return;
      parambm = a(parambm, str, (String)localObject);
      break;
      int i = ((Integer)localObject).intValue();
      parambm = a(str, parambm.getContext().getResources().openRawResource(i));
      break;
      parambm = a(str, (String)localObject);
      break;
      this.b = f;
    }
  }
  
  private void b(String paramString1, String paramString2)
  {
    AppMethodBeat.i(222769);
    if (!gz.a(paramString2)) {
      this.c.put(paramString1, paramString2);
    }
    AppMethodBeat.o(222769);
  }
  
  public static cl e()
  {
    AppMethodBeat.i(222756);
    if (e.isEmpty())
    {
      localcm = new cm();
      AppMethodBeat.o(222756);
      return localcm;
    }
    cm localcm = ((cb)e.peek()).b;
    AppMethodBeat.o(222756);
    return localcm;
  }
  
  public final Map<String, Class<? extends cg.a>> a()
  {
    AppMethodBeat.i(222836);
    HashMap localHashMap = new HashMap();
    localHashMap.put("authorization", dc.class);
    localHashMap.put("indoordata", de.class);
    localHashMap.put("mapdata", dg.class);
    localHashMap.put("mapstyle", di.class);
    localHashMap.put("rttdata", dl.class);
    localHashMap.put("satellitedata", dm.class);
    localHashMap.put("sketchdata", dn.class);
    localHashMap.put("overseadata", dk.class);
    localHashMap.put("statistic", do.class);
    localHashMap.put("trafficevent", dp.class);
    localHashMap.put("offlinemapdata", dj.class);
    localHashMap.put("mappoidata", dh.class);
    AppMethodBeat.o(222836);
    return localHashMap;
  }
  
  public final void a(bm parambm)
  {
    AppMethodBeat.i(222798);
    super.a(parambm);
    if (parambm == null)
    {
      AppMethodBeat.o(222798);
      return;
    }
    this.d = parambm.a;
    TencentMapOptions localTencentMapOptions = this.d;
    Object localObject2 = localTencentMapOptions.getProtocolDataDesc();
    Object localObject1 = parambm.u().a;
    if (this.b == null) {
      this.b = f;
    }
    if (localObject2 != null) {}
    switch (localTencentMapOptions.getProtocolFrom())
    {
    case 0: 
    case 2: 
    default: 
      parambm = null;
      if (parambm != null) {
        this.b = parambm;
      }
      if (this.b != null)
      {
        this.b.a = ((String)localObject1);
        this.b.a(this);
      }
      break;
    }
    for (;;)
    {
      e.push(this.b);
      parambm = b();
      localObject1 = this.d;
      NetManager.init(parambm, NetConfig.create().setAdapterType(((TencentMapOptions)localObject1).getNetAdapterType()).setLogEnable(ry.d).setForceHttps(((TencentMapOptions)localObject1).isForceHttps()).setArguments(((TencentMapOptions)localObject1).getNetParams()).setProxyRuleList(e().b()));
      gw.a(e().a());
      AppMethodBeat.o(222798);
      return;
      parambm = a(parambm, (String)localObject1, (String)localObject2);
      break;
      int i = ((Integer)localObject2).intValue();
      parambm = a((String)localObject1, parambm.getContext().getResources().openRawResource(i));
      break;
      parambm = a((String)localObject1, (String)localObject2);
      break;
      this.b = f;
    }
  }
  
  public final void a(bm parambm, Bundle paramBundle)
  {
    AppMethodBeat.i(222787);
    super.a(parambm, paramBundle);
    gw.a(e().a());
    AppMethodBeat.o(222787);
  }
  
  public final List<Class<? extends p>> a_()
  {
    AppMethodBeat.i(222857);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Basic.class);
    localArrayList.add(Detail.class);
    localArrayList.add(Response.class);
    localArrayList.add(RttRequest.class);
    localArrayList.add(RttResponse.class);
    localArrayList.add(user_login_t.class);
    localArrayList.add(CmdResult.class);
    localArrayList.add(Header.class);
    localArrayList.add(Package.class);
    localArrayList.add(Tag.class);
    localArrayList.add(CSFileUpdateReq.class);
    localArrayList.add(FileUpdateReq.class);
    localArrayList.add(FileUpdateRsp.class);
    localArrayList.add(SCFileUpdateRsp.class);
    AppMethodBeat.o(222857);
    return localArrayList;
  }
  
  public final void b(bm parambm)
  {
    AppMethodBeat.i(222808);
    super.b(parambm);
    if ((!e.isEmpty()) && (this.b != null))
    {
      e.remove(this.b);
      this.b = null;
    }
    AppMethodBeat.o(222808);
  }
  
  public final Map<String, String> c()
  {
    AppMethodBeat.i(222847);
    if (this.d != null)
    {
      localObject = this.d.getCustomUserId();
      if (!gz.a((String)localObject)) {
        this.c.put("cuid", localObject);
      }
    }
    Object localObject = this.c;
    AppMethodBeat.o(222847);
    return localObject;
  }
  
  public final cb d()
  {
    AppMethodBeat.i(222816);
    if (this.b == null) {
      if (e.isEmpty()) {
        break label48;
      }
    }
    label48:
    for (this.b = ((cb)e.peek());; this.b = f)
    {
      cb localcb = this.b;
      AppMethodBeat.o(222816);
      return localcb;
    }
  }
  
  public TencentMapServiceProtocol.IMapService getMapService(String paramString)
  {
    AppMethodBeat.i(222825);
    this.b = d();
    if (this.b != null)
    {
      paramString = this.b.b(paramString);
      if (paramString != null)
      {
        paramString = new a(paramString);
        AppMethodBeat.o(222825);
        return paramString;
      }
    }
    AppMethodBeat.o(222825);
    return null;
  }
  
  static final class a
    implements TencentMapServiceProtocol.IMapService
  {
    cg.a a;
    
    public a(cg.a parama)
    {
      this.a = parama;
    }
    
    public final void setAllow(boolean paramBoolean)
    {
      AppMethodBeat.i(226034);
      this.a.a(paramBoolean);
      AppMethodBeat.o(226034);
    }
    
    public final void setUseHttps(boolean paramBoolean)
    {
      AppMethodBeat.i(226046);
      this.a.c(paramBoolean);
      AppMethodBeat.o(226046);
    }
    
    public final void setUseTest(boolean paramBoolean)
    {
      AppMethodBeat.i(226040);
      this.a.b(paramBoolean);
      AppMethodBeat.o(226040);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.cj
 * JD-Core Version:    0.7.0.1
 */