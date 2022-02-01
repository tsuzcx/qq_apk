package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.ArrayMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class WxaPkgWrappingInfo
  extends ModulePkgInfo
  implements Parcelable, Iterable<ModulePkgInfo>
{
  public static final Parcelable.Creator<WxaPkgWrappingInfo> CREATOR;
  static a nHX;
  public int nHY;
  public long nHZ;
  @Deprecated
  public boolean nIa;
  public final LinkedList<ModulePkgInfo> nIb;
  private volatile transient Map<String, String> nIc;
  public WxaRuntimeModulePluginListMap nId;
  
  static
  {
    AppMethodBeat.i(134298);
    WxaPkgWrappingInfo.class.getClassLoader();
    j.KW("appbrandcommon");
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(134298);
  }
  
  public WxaPkgWrappingInfo()
  {
    AppMethodBeat.i(134293);
    this.nIb = new LinkedList();
    this.nId = null;
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
  
  public static void a(a parama)
  {
    nHX = parama;
  }
  
  public static String adg(String paramString)
  {
    AppMethodBeat.i(178557);
    if ("__APP__".equals(paramString))
    {
      AppMethodBeat.o(178557);
      return paramString;
    }
    paramString = o.adS(paramString);
    AppMethodBeat.o(178557);
    return paramString;
  }
  
  public static WxaPkgWrappingInfo adh(String paramString)
  {
    AppMethodBeat.i(134290);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(134290);
      return null;
    }
    q localq = new q(paramString);
    if ((!localq.ifE()) || (localq.isDirectory()))
    {
      Log.e("MicroMsg.WxaPkgWrappingInfo#obtain", "wxPkg invalid, path = %s ", new Object[] { paramString });
      AppMethodBeat.o(134290);
      return null;
    }
    WxaPkgWrappingInfo localWxaPkgWrappingInfo = new WxaPkgWrappingInfo();
    localWxaPkgWrappingInfo.pkgPath = paramString;
    localWxaPkgWrappingInfo.nIa = false;
    try
    {
      localWxaPkgWrappingInfo.md5 = n(localq);
      label90:
      AppMethodBeat.o(134290);
      return localWxaPkgWrappingInfo;
    }
    catch (Exception paramString)
    {
      break label90;
    }
  }
  
  /* Error */
  public static String n(q paramq)
  {
    // Byte code:
    //   0: ldc 162
    //   2: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: iconst_1
    //   6: anewarray 100	java/lang/String
    //   9: astore_1
    //   10: bipush 155
    //   12: aload_0
    //   13: invokevirtual 166	com/tencent/mm/vfs/q:bOF	()Ljava/lang/String;
    //   16: iconst_0
    //   17: invokestatic 171	com/tencent/mm/vfs/u:n	(Ljava/lang/String;Z)Ljava/lang/String;
    //   20: aload_1
    //   21: invokestatic 177	com/tencent/mm/plugin/appbrand/appstorage/MD5JNI:getMD5String	(Ljava/lang/String;[Ljava/lang/String;)I
    //   24: if_icmpne +84 -> 108
    //   27: new 159	java/io/IOException
    //   30: dup
    //   31: ldc 179
    //   33: invokespecial 180	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   36: astore_1
    //   37: ldc 162
    //   39: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   42: aload_1
    //   43: athrow
    //   44: astore_1
    //   45: ldc 182
    //   47: aload_1
    //   48: ldc 184
    //   50: iconst_0
    //   51: anewarray 137	java/lang/Object
    //   54: invokestatic 188	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   57: aconst_null
    //   58: astore_1
    //   59: aload_1
    //   60: astore_2
    //   61: aload_1
    //   62: invokestatic 194	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   65: ifeq +36 -> 101
    //   68: aload_1
    //   69: astore_2
    //   70: aload_0
    //   71: invokestatic 198	com/tencent/mm/vfs/u:al	(Lcom/tencent/mm/vfs/q;)Ljava/io/InputStream;
    //   74: astore 4
    //   76: aload 4
    //   78: sipush 16384
    //   81: invokestatic 204	com/tencent/mm/b/g:b	(Ljava/io/InputStream;I)Ljava/lang/String;
    //   84: astore_0
    //   85: aload_0
    //   86: astore_2
    //   87: aload 4
    //   89: ifnull +12 -> 101
    //   92: aload_0
    //   93: astore_2
    //   94: aload 4
    //   96: invokevirtual 209	java/io/InputStream:close	()V
    //   99: aload_0
    //   100: astore_2
    //   101: ldc 162
    //   103: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   106: aload_2
    //   107: areturn
    //   108: aload_1
    //   109: iconst_0
    //   110: aaload
    //   111: astore_1
    //   112: goto -53 -> 59
    //   115: astore_3
    //   116: ldc 162
    //   118: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   121: aload_3
    //   122: athrow
    //   123: astore_0
    //   124: aload 4
    //   126: ifnull +14 -> 140
    //   129: aload_3
    //   130: ifnull +50 -> 180
    //   133: aload_1
    //   134: astore_2
    //   135: aload 4
    //   137: invokevirtual 209	java/io/InputStream:close	()V
    //   140: aload_1
    //   141: astore_2
    //   142: ldc 162
    //   144: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   147: aload_1
    //   148: astore_2
    //   149: aload_0
    //   150: athrow
    //   151: astore_0
    //   152: ldc 182
    //   154: aload_0
    //   155: ldc 211
    //   157: iconst_0
    //   158: anewarray 137	java/lang/Object
    //   161: invokestatic 188	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   164: goto -63 -> 101
    //   167: astore 4
    //   169: aload_1
    //   170: astore_2
    //   171: aload_3
    //   172: aload 4
    //   174: invokevirtual 215	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   177: goto -37 -> 140
    //   180: aload_1
    //   181: astore_2
    //   182: aload 4
    //   184: invokevirtual 209	java/io/InputStream:close	()V
    //   187: goto -47 -> 140
    //   190: astore_0
    //   191: aconst_null
    //   192: astore_3
    //   193: goto -69 -> 124
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	196	0	paramq	q
    //   9	34	1	localObject1	Object
    //   44	4	1	localUnsatisfiedLinkError	java.lang.UnsatisfiedLinkError
    //   58	123	1	localCharSequence	java.lang.CharSequence
    //   60	122	2	localObject2	Object
    //   115	57	3	localThrowable1	java.lang.Throwable
    //   192	1	3	localObject3	Object
    //   74	62	4	localInputStream	java.io.InputStream
    //   167	16	4	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   5	44	44	java/lang/UnsatisfiedLinkError
    //   76	85	115	java/lang/Throwable
    //   116	123	123	finally
    //   70	76	151	java/io/IOException
    //   94	99	151	java/io/IOException
    //   135	140	151	java/io/IOException
    //   142	147	151	java/io/IOException
    //   149	151	151	java/io/IOException
    //   171	177	151	java/io/IOException
    //   182	187	151	java/io/IOException
    //   135	140	167	java/lang/Throwable
    //   76	85	190	finally
  }
  
  final void adf(String paramString)
  {
    AppMethodBeat.i(178556);
    synchronized (this.nIb)
    {
      if ((this.nIb.isEmpty()) || (this.nIc != null))
      {
        AppMethodBeat.o(178556);
        return;
      }
      this.nIc = new ArrayMap();
      Iterator localIterator = this.nIb.iterator();
      while (localIterator.hasNext())
      {
        ModulePkgInfo localModulePkgInfo = (ModulePkgInfo)localIterator.next();
        localModulePkgInfo.pkgVersion = this.pkgVersion;
        String str = adg(localModulePkgInfo.name);
        Log.i("Luggage.WXA.WxaPkgWrappingInfo", "setupModuleEnv, appId:%s, module mapped %s -> %s", new Object[] { paramString, localModulePkgInfo.name, str });
        if (!str.equals(localModulePkgInfo.name))
        {
          this.nIc.put(str, localModulePkgInfo.name);
          localModulePkgInfo.name = str;
        }
      }
    }
    Log.i("Luggage.WXA.WxaPkgWrappingInfo", "setupModuleEnv, appId:%s, NameMap.size:%d", new Object[] { paramString, Integer.valueOf(this.nIc.size()) });
    AppMethodBeat.o(178556);
  }
  
  public final String cA(String paramString1, String paramString2)
  {
    AppMethodBeat.i(178558);
    if ("__APP__".equals(paramString2))
    {
      AppMethodBeat.o(178558);
      return paramString2;
    }
    synchronized (this.nIb)
    {
      if (this.nIc == null) {
        adf(paramString1);
      }
      String str2 = (String)this.nIc.get(paramString2);
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
      private boolean nIe = false;
      private Iterator<ModulePkgInfo> nIf = null;
      
      public final boolean hasNext()
      {
        AppMethodBeat.i(178553);
        if (!this.nIe)
        {
          AppMethodBeat.o(178553);
          return true;
        }
        if (this.nIf == null) {
          this.nIf = WxaPkgWrappingInfo.this.nIb.iterator();
        }
        boolean bool = this.nIf.hasNext();
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
    this.nHY = paramParcel.readInt();
    this.pkgVersion = paramParcel.readInt();
    this.nHZ = paramParcel.readLong();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.nIa = bool;
      paramParcel.readTypedList(this.nIb, ModulePkgInfo.CREATOR);
      this.nId = ((WxaRuntimeModulePluginListMap)paramParcel.readParcelable(WxaRuntimeModulePluginListMap.class.getClassLoader()));
      AppMethodBeat.o(134297);
      return;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(134295);
    String str = "WxaPkgWrappingInfo{pkgDebugType=" + this.nHY + ", pkgVersion=" + this.pkgVersion + ", pkgCreateTime=" + this.nHZ + ", localPkg=" + this.nIa + ", md5='" + this.md5 + '\'' + ", pkgPath='" + this.pkgPath + '\'' + '}';
    AppMethodBeat.o(134295);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(134296);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.nHY);
    paramParcel.writeInt(this.pkgVersion);
    paramParcel.writeLong(this.nHZ);
    if (this.nIa) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      paramParcel.writeTypedList(this.nIb);
      paramParcel.writeParcelable(this.nId, 0);
      AppMethodBeat.o(134296);
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract ModulePkgInfo b(List<ModulePkgInfo> paramList, String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo
 * JD-Core Version:    0.7.0.1
 */