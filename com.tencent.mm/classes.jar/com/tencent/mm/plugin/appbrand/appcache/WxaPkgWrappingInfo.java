package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.ArrayMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.plugin.appbrand.appstorage.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class WxaPkgWrappingInfo
  extends ModulePkgInfo
  implements Parcelable, Iterable<ModulePkgInfo>
{
  public static final Parcelable.Creator<WxaPkgWrappingInfo> CREATOR;
  static WxaPkgWrappingInfo.a qHN;
  public int qHO;
  public long qHP;
  @Deprecated
  public boolean qHQ;
  public final LinkedList<ModulePkgInfo> qHR;
  private volatile transient Map<String, String> qHS;
  public WxaRuntimeModulePluginListMap qHT;
  
  static
  {
    AppMethodBeat.i(134298);
    WxaPkgWrappingInfo.class.getClassLoader();
    k.DA("appbrandcommon");
    CREATOR = new WxaPkgWrappingInfo.2();
    AppMethodBeat.o(134298);
  }
  
  public WxaPkgWrappingInfo()
  {
    AppMethodBeat.i(134293);
    this.qHR = new LinkedList();
    this.qHT = null;
    this.name = "__APP__";
    this.independent = true;
    AppMethodBeat.o(134293);
  }
  
  public WxaPkgWrappingInfo(Parcel paramParcel)
  {
    this();
    AppMethodBeat.i(134294);
    readFromParcel(paramParcel);
    AppMethodBeat.o(134294);
  }
  
  public static String VC(String paramString)
  {
    AppMethodBeat.i(178557);
    if ("__APP__".equals(paramString))
    {
      AppMethodBeat.o(178557);
      return paramString;
    }
    paramString = t.as(paramString, true);
    AppMethodBeat.o(178557);
    return paramString;
  }
  
  public static WxaPkgWrappingInfo VD(String paramString)
  {
    AppMethodBeat.i(134290);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(134290);
      return null;
    }
    u localu = new u(paramString);
    if ((!localu.jKS()) || (localu.isDirectory()))
    {
      Log.e("MicroMsg.WxaPkgWrappingInfo#obtain", "wxPkg invalid, path = %s ", new Object[] { paramString });
      AppMethodBeat.o(134290);
      return null;
    }
    WxaPkgWrappingInfo localWxaPkgWrappingInfo = new WxaPkgWrappingInfo();
    localWxaPkgWrappingInfo.pkgPath = paramString;
    localWxaPkgWrappingInfo.qHQ = false;
    try
    {
      localWxaPkgWrappingInfo.md5 = n(localu);
      label90:
      AppMethodBeat.o(134290);
      return localWxaPkgWrappingInfo;
    }
    catch (Exception paramString)
    {
      break label90;
    }
  }
  
  public static void a(WxaPkgWrappingInfo.a parama)
  {
    qHN = parama;
  }
  
  /* Error */
  public static String n(u paramu)
  {
    // Byte code:
    //   0: ldc 161
    //   2: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: iconst_1
    //   6: anewarray 96	java/lang/String
    //   9: astore_1
    //   10: bipush 155
    //   12: aload_0
    //   13: invokevirtual 165	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
    //   16: invokestatic 171	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
    //   19: iconst_0
    //   20: invokestatic 175	com/tencent/mm/vfs/y:n	(Ljava/lang/String;Z)Ljava/lang/String;
    //   23: aload_1
    //   24: invokestatic 181	com/tencent/mm/plugin/appbrand/appstorage/MD5JNI:getMD5String	(Ljava/lang/String;[Ljava/lang/String;)I
    //   27: if_icmpne +80 -> 107
    //   30: new 160	java/io/IOException
    //   33: dup
    //   34: ldc 183
    //   36: invokespecial 184	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   39: astore_1
    //   40: ldc 161
    //   42: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   45: aload_1
    //   46: athrow
    //   47: astore_1
    //   48: ldc 186
    //   50: aload_1
    //   51: ldc 188
    //   53: iconst_0
    //   54: anewarray 134	java/lang/Object
    //   57: invokestatic 192	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   60: aconst_null
    //   61: astore_1
    //   62: aload_1
    //   63: astore_2
    //   64: aload_1
    //   65: invokestatic 198	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   68: ifeq +32 -> 100
    //   71: aload_1
    //   72: astore_2
    //   73: aload_0
    //   74: invokestatic 202	com/tencent/mm/vfs/y:ao	(Lcom/tencent/mm/vfs/u;)Ljava/io/InputStream;
    //   77: astore_3
    //   78: aload_3
    //   79: sipush 16384
    //   82: invokestatic 207	com/tencent/mm/b/g:e	(Ljava/io/InputStream;I)Ljava/lang/String;
    //   85: astore_0
    //   86: aload_0
    //   87: astore_2
    //   88: aload_3
    //   89: ifnull +11 -> 100
    //   92: aload_0
    //   93: astore_2
    //   94: aload_3
    //   95: invokevirtual 212	java/io/InputStream:close	()V
    //   98: aload_0
    //   99: astore_2
    //   100: ldc 161
    //   102: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   105: aload_2
    //   106: areturn
    //   107: aload_1
    //   108: iconst_0
    //   109: aaload
    //   110: astore_1
    //   111: goto -49 -> 62
    //   114: astore_0
    //   115: aload_3
    //   116: ifnull +7 -> 123
    //   119: aload_3
    //   120: invokevirtual 212	java/io/InputStream:close	()V
    //   123: aload_1
    //   124: astore_2
    //   125: ldc 161
    //   127: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   130: aload_1
    //   131: astore_2
    //   132: aload_0
    //   133: athrow
    //   134: astore_0
    //   135: ldc 186
    //   137: aload_0
    //   138: ldc 214
    //   140: iconst_0
    //   141: anewarray 134	java/lang/Object
    //   144: invokestatic 192	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   147: goto -47 -> 100
    //   150: astore_3
    //   151: aload_1
    //   152: astore_2
    //   153: aload_0
    //   154: aload_3
    //   155: invokevirtual 220	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   158: goto -35 -> 123
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	161	0	paramu	u
    //   9	37	1	localObject1	Object
    //   47	4	1	localUnsatisfiedLinkError	java.lang.UnsatisfiedLinkError
    //   61	91	1	localCharSequence	java.lang.CharSequence
    //   63	90	2	localObject2	Object
    //   77	43	3	localInputStream	java.io.InputStream
    //   150	5	3	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   5	47	47	java/lang/UnsatisfiedLinkError
    //   78	86	114	finally
    //   73	78	134	java/io/IOException
    //   94	98	134	java/io/IOException
    //   125	130	134	java/io/IOException
    //   132	134	134	java/io/IOException
    //   153	158	134	java/io/IOException
    //   119	123	150	finally
  }
  
  final void VB(String paramString)
  {
    AppMethodBeat.i(178556);
    synchronized (this.qHR)
    {
      if ((this.qHR.isEmpty()) || (this.qHS != null))
      {
        AppMethodBeat.o(178556);
        return;
      }
      this.qHS = new ArrayMap();
      Iterator localIterator = this.qHR.iterator();
      while (localIterator.hasNext())
      {
        ModulePkgInfo localModulePkgInfo = (ModulePkgInfo)localIterator.next();
        localModulePkgInfo.pkgVersion = this.pkgVersion;
        String str = VC(localModulePkgInfo.name);
        if (!str.equals(localModulePkgInfo.name))
        {
          Log.i("Luggage.WXA.WxaPkgWrappingInfo", "setupModuleEnv, appId:%s, module mapped %s -> %s", new Object[] { paramString, localModulePkgInfo.name, str });
          this.qHS.put(str, localModulePkgInfo.name);
          localModulePkgInfo.name = str;
        }
      }
    }
    Log.i("Luggage.WXA.WxaPkgWrappingInfo", "setupModuleEnv, appId:%s, NameMap.size:%d", new Object[] { paramString, Integer.valueOf(this.qHS.size()) });
    AppMethodBeat.o(178556);
  }
  
  public final String cR(String paramString1, String paramString2)
  {
    AppMethodBeat.i(178558);
    if ("__APP__".equals(paramString2))
    {
      AppMethodBeat.o(178558);
      return paramString2;
    }
    synchronized (this.qHR)
    {
      if (this.qHS == null) {
        VB(paramString1);
      }
      String str2 = (String)this.qHS.get(paramString2);
      String str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = paramString2;
      }
      Log.i("Luggage.WXA.WxaPkgWrappingInfo", "getModuleNameForURLFetch appId:%s, retrace module %s -> %s", new Object[] { paramString1, paramString2, str1 });
      AppMethodBeat.o(178558);
      return str1;
    }
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean isAssignable(ModulePkgInfo paramModulePkgInfo)
  {
    AppMethodBeat.i(178560);
    if ((paramModulePkgInfo instanceof WxaPkgWrappingInfo))
    {
      if ((super.isAssignable(paramModulePkgInfo)) && (this.pkgVersion == paramModulePkgInfo.pkgVersion))
      {
        AppMethodBeat.o(178560);
        return true;
      }
      AppMethodBeat.o(178560);
      return false;
    }
    boolean bool = super.isAssignable(paramModulePkgInfo);
    AppMethodBeat.o(178560);
    return bool;
  }
  
  public final Iterator<ModulePkgInfo> iterator()
  {
    AppMethodBeat.i(178559);
    Iterator local1 = new Iterator()
    {
      private boolean qHU = false;
      private Iterator<ModulePkgInfo> qHV = null;
      
      public final boolean hasNext()
      {
        AppMethodBeat.i(178553);
        if (!this.qHU)
        {
          AppMethodBeat.o(178553);
          return true;
        }
        if (this.qHV == null) {
          this.qHV = WxaPkgWrappingInfo.this.qHR.iterator();
        }
        boolean bool = this.qHV.hasNext();
        AppMethodBeat.o(178553);
        return bool;
      }
    };
    AppMethodBeat.o(178559);
    return local1;
  }
  
  public final void readFromParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(134297);
    super.readFromParcel(paramParcel);
    this.qHO = paramParcel.readInt();
    this.pkgVersion = paramParcel.readInt();
    this.qHP = paramParcel.readLong();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.qHQ = bool;
      paramParcel.readTypedList(this.qHR, ModulePkgInfo.CREATOR);
      this.qHT = ((WxaRuntimeModulePluginListMap)paramParcel.readParcelable(WxaRuntimeModulePluginListMap.class.getClassLoader()));
      AppMethodBeat.o(134297);
      return;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(134295);
    String str = "WxaPkgWrappingInfo{pkgDebugType=" + this.qHO + ", pkgVersion=" + this.pkgVersion + ", pkgCreateTime=" + this.qHP + ", localPkg=" + this.qHQ + ", md5='" + this.md5 + '\'' + ", pkgPath='" + this.pkgPath + '\'' + '}';
    AppMethodBeat.o(134295);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(134296);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.qHO);
    paramParcel.writeInt(this.pkgVersion);
    paramParcel.writeLong(this.qHP);
    if (this.qHQ) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      paramParcel.writeTypedList(this.qHR);
      paramParcel.writeParcelable(this.qHT, 0);
      AppMethodBeat.o(134296);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo
 * JD-Core Version:    0.7.0.1
 */