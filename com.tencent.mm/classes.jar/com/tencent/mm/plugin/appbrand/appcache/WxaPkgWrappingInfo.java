package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.ArrayMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.e;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class WxaPkgWrappingInfo
  extends ModulePkgInfo
  implements Parcelable, Iterable<ModulePkgInfo>
{
  public static final Parcelable.Creator<WxaPkgWrappingInfo> CREATOR;
  static a joZ;
  public int jpa;
  public long jpb;
  @Deprecated
  public boolean jpc;
  public final LinkedList<ModulePkgInfo> jpd;
  private volatile transient Map<String, String> jpe;
  public WxaRuntimeModulePluginListMap jpf;
  
  static
  {
    AppMethodBeat.i(134298);
    WxaPkgWrappingInfo.class.getClassLoader();
    j.sC("appbrandcommon");
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(134298);
  }
  
  public WxaPkgWrappingInfo()
  {
    AppMethodBeat.i(134293);
    this.jpd = new LinkedList();
    this.jpf = null;
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
  
  public static String It(String paramString)
  {
    AppMethodBeat.i(178557);
    if ("__APP__".equals(paramString))
    {
      AppMethodBeat.o(178557);
      return paramString;
    }
    paramString = m.IY(paramString);
    AppMethodBeat.o(178557);
    return paramString;
  }
  
  public static WxaPkgWrappingInfo Iu(String paramString)
  {
    AppMethodBeat.i(134290);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(134290);
      return null;
    }
    e locale = new e(paramString);
    if ((!locale.exists()) || (locale.isDirectory()))
    {
      ac.e("MicroMsg.WxaPkgWrappingInfo#obtain", "wxPkg invalid, path = %s ", new Object[] { paramString });
      AppMethodBeat.o(134290);
      return null;
    }
    WxaPkgWrappingInfo localWxaPkgWrappingInfo = new WxaPkgWrappingInfo();
    localWxaPkgWrappingInfo.pkgPath = paramString;
    localWxaPkgWrappingInfo.jpc = false;
    localWxaPkgWrappingInfo.md5 = o(locale);
    AppMethodBeat.o(134290);
    return localWxaPkgWrappingInfo;
  }
  
  public static WxaPkgWrappingInfo Iv(String paramString)
  {
    AppMethodBeat.i(134292);
    if (bs.isNullOrNil(paramString))
    {
      ac.e("MicroMsg.WxaPkgWrappingInfo#obtainPluginCode", "pkgPath null!");
      AppMethodBeat.o(134292);
      return null;
    }
    WxaPkgWrappingInfo localWxaPkgWrappingInfo = new WxaPkgWrappingInfo();
    localWxaPkgWrappingInfo.pkgPath = paramString;
    localWxaPkgWrappingInfo.jpc = false;
    localWxaPkgWrappingInfo.md5 = g.getMD5(paramString);
    AppMethodBeat.o(134292);
    return localWxaPkgWrappingInfo;
  }
  
  public static void a(a parama)
  {
    joZ = parama;
  }
  
  /* Error */
  private static String o(e parame)
  {
    // Byte code:
    //   0: ldc 173
    //   2: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokevirtual 177	com/tencent/mm/vfs/e:fxV	()Landroid/net/Uri;
    //   9: invokestatic 183	com/tencent/mm/vfs/q:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   12: invokestatic 188	com/tencent/mm/plugin/appbrand/appstorage/MD5JNI:getMD5Wrap	(Ljava/lang/String;)Ljava/lang/String;
    //   15: astore_1
    //   16: aload_1
    //   17: astore_2
    //   18: aload_1
    //   19: invokestatic 194	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   22: ifeq +36 -> 58
    //   25: aload_1
    //   26: astore_2
    //   27: aload_0
    //   28: invokestatic 200	com/tencent/mm/vfs/i:ag	(Lcom/tencent/mm/vfs/e;)Ljava/io/InputStream;
    //   31: astore 4
    //   33: aload 4
    //   35: sipush 16384
    //   38: invokestatic 204	com/tencent/mm/b/g:b	(Ljava/io/InputStream;I)Ljava/lang/String;
    //   41: astore_0
    //   42: aload_0
    //   43: astore_2
    //   44: aload 4
    //   46: ifnull +12 -> 58
    //   49: aload_0
    //   50: astore_2
    //   51: aload 4
    //   53: invokevirtual 209	java/io/InputStream:close	()V
    //   56: aload_0
    //   57: astore_2
    //   58: ldc 173
    //   60: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   63: aload_2
    //   64: areturn
    //   65: astore_1
    //   66: ldc 211
    //   68: aload_1
    //   69: ldc 213
    //   71: iconst_0
    //   72: anewarray 132	java/lang/Object
    //   75: invokestatic 217	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   78: aconst_null
    //   79: astore_1
    //   80: goto -64 -> 16
    //   83: astore_3
    //   84: ldc 173
    //   86: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   89: aload_3
    //   90: athrow
    //   91: astore_0
    //   92: aload 4
    //   94: ifnull +14 -> 108
    //   97: aload_3
    //   98: ifnull +50 -> 148
    //   101: aload_1
    //   102: astore_2
    //   103: aload 4
    //   105: invokevirtual 209	java/io/InputStream:close	()V
    //   108: aload_1
    //   109: astore_2
    //   110: ldc 173
    //   112: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   115: aload_1
    //   116: astore_2
    //   117: aload_0
    //   118: athrow
    //   119: astore_0
    //   120: ldc 211
    //   122: aload_0
    //   123: ldc 219
    //   125: iconst_0
    //   126: anewarray 132	java/lang/Object
    //   129: invokestatic 217	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   132: goto -74 -> 58
    //   135: astore 4
    //   137: aload_1
    //   138: astore_2
    //   139: aload_3
    //   140: aload 4
    //   142: invokevirtual 223	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   145: goto -37 -> 108
    //   148: aload_1
    //   149: astore_2
    //   150: aload 4
    //   152: invokevirtual 209	java/io/InputStream:close	()V
    //   155: goto -47 -> 108
    //   158: astore_0
    //   159: aconst_null
    //   160: astore_3
    //   161: goto -69 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	parame	e
    //   15	11	1	str	String
    //   65	4	1	localUnsatisfiedLinkError	java.lang.UnsatisfiedLinkError
    //   79	70	1	localObject1	Object
    //   17	133	2	localObject2	Object
    //   83	57	3	localThrowable1	java.lang.Throwable
    //   160	1	3	localObject3	Object
    //   31	73	4	localInputStream	java.io.InputStream
    //   135	16	4	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   5	16	65	java/lang/UnsatisfiedLinkError
    //   33	42	83	java/lang/Throwable
    //   84	91	91	finally
    //   27	33	119	java/io/IOException
    //   51	56	119	java/io/IOException
    //   103	108	119	java/io/IOException
    //   110	115	119	java/io/IOException
    //   117	119	119	java/io/IOException
    //   139	145	119	java/io/IOException
    //   150	155	119	java/io/IOException
    //   103	108	135	java/lang/Throwable
    //   33	42	158	finally
  }
  
  final void Is(String paramString)
  {
    AppMethodBeat.i(178556);
    synchronized (this.jpd)
    {
      if ((this.jpd.isEmpty()) || (this.jpe != null))
      {
        AppMethodBeat.o(178556);
        return;
      }
      this.jpe = new ArrayMap();
      Iterator localIterator = this.jpd.iterator();
      while (localIterator.hasNext())
      {
        ModulePkgInfo localModulePkgInfo = (ModulePkgInfo)localIterator.next();
        localModulePkgInfo.pkgVersion = this.pkgVersion;
        String str = It(localModulePkgInfo.name);
        ac.i("Luggage.WXA.WxaPkgWrappingInfo", "setupModuleEnv, appId:%s, module mapped %s -> %s", new Object[] { paramString, localModulePkgInfo.name, str });
        if (!str.equals(localModulePkgInfo.name))
        {
          this.jpe.put(str, localModulePkgInfo.name);
          localModulePkgInfo.name = str;
        }
      }
    }
    ac.i("Luggage.WXA.WxaPkgWrappingInfo", "setupModuleEnv, appId:%s, NameMap.size:%d", new Object[] { paramString, Integer.valueOf(this.jpe.size()) });
    AppMethodBeat.o(178556);
  }
  
  public final String ce(String paramString1, String paramString2)
  {
    AppMethodBeat.i(178558);
    if ("__APP__".equals(paramString2))
    {
      AppMethodBeat.o(178558);
      return paramString2;
    }
    synchronized (this.jpd)
    {
      if (this.jpe == null) {
        Is(paramString1);
      }
      String str2 = (String)this.jpe.get(paramString2);
      String str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = paramString2;
      }
      ac.i("Luggage.WXA.WxaPkgWrappingInfo", "getModuleNameForURLFetch appId:%s, retrace module %s -> %s", new Object[] { paramString1, paramString2, str1 });
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
      private boolean jpg = false;
      private Iterator<ModulePkgInfo> jph = null;
      
      public final boolean hasNext()
      {
        AppMethodBeat.i(178553);
        if (!this.jpg)
        {
          AppMethodBeat.o(178553);
          return true;
        }
        if (this.jph == null) {
          this.jph = WxaPkgWrappingInfo.this.jpd.iterator();
        }
        boolean bool = this.jph.hasNext();
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
    this.jpa = paramParcel.readInt();
    this.pkgVersion = paramParcel.readInt();
    this.jpb = paramParcel.readLong();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.jpc = bool;
      paramParcel.readTypedList(this.jpd, ModulePkgInfo.CREATOR);
      this.jpf = ((WxaRuntimeModulePluginListMap)paramParcel.readParcelable(WxaRuntimeModulePluginListMap.class.getClassLoader()));
      AppMethodBeat.o(134297);
      return;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(134295);
    String str = "WxaPkgWrappingInfo{pkgDebugType=" + this.jpa + ", pkgVersion=" + this.pkgVersion + ", pkgCreateTime=" + this.jpb + ", localPkg=" + this.jpc + ", md5='" + this.md5 + '\'' + ", pkgPath='" + this.pkgPath + '\'' + '}';
    AppMethodBeat.o(134295);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(134296);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.jpa);
    paramParcel.writeInt(this.pkgVersion);
    paramParcel.writeLong(this.jpb);
    if (this.jpc) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      paramParcel.writeTypedList(this.jpd);
      paramParcel.writeParcelable(this.jpf, 0);
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