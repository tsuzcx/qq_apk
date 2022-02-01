package com.tencent.mm.plugin.appbrand.appcache;

import android.database.Cursor;
import android.os.Build.VERSION;
import android.os.StatFs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.lr;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.r.a;
import com.tencent.mm.plugin.appbrand.appcache.predownload.export.c;
import com.tencent.mm.plugin.appbrand.appcache.predownload.export.c.b;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig.PackageManager;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.z;
import com.tencent.mm.plugin.appbrand.launching.m;
import com.tencent.mm.plugin.appbrand.page.bj;
import com.tencent.mm.plugin.appbrand.page.bj.a;
import com.tencent.mm.plugin.appbrand.task.p;
import com.tencent.mm.plugin.appbrand.ui.c.a.b.b.c;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabaseEx;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;
import org.apache.commons.b.a;

public abstract interface n
  extends Runnable
{
  public static final class a
  {
    static void US(String paramString)
    {
      AppMethodBeat.i(44240);
      s.deleteFile(paramString);
      try
      {
        Runtime.getRuntime().exec("rm -r " + paramString + "_xdir");
        AppMethodBeat.o(44240);
        return;
      }
      catch (Exception localException)
      {
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrand.PkgCleanupLogic.CleanupUtil", "rm -r %s, e = %s", new Object[] { paramString + "_xdir", localException });
        AppMethodBeat.o(44240);
      }
    }
  }
  
  public static final class b
  {
    public static long bvq()
    {
      AppMethodBeat.i(44241);
      long l = com.tencent.mm.plugin.appbrand.appstorage.n.q(new o(az.bwm()));
      AppMethodBeat.o(44241);
      return l;
    }
  }
  
  public static final class c
  {
    private static final n.d kKC;
    
    static
    {
      AppMethodBeat.i(44244);
      kKC = new n.d();
      AppMethodBeat.o(44244);
    }
    
    public static n bvr()
    {
      AppMethodBeat.i(44242);
      n.d locald = kKC;
      AppMethodBeat.o(44242);
      return locald;
    }
    
    public static void interrupt()
    {
      AppMethodBeat.i(44243);
      n.d locald = kKC;
      try
      {
        com.tencent.mm.plugin.report.service.h.CyF.dN(1007, 2);
        locald.kKD.set(true);
        AppMethodBeat.o(44243);
        return;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("MicroMsg.AppBrand.PkgCleanupNewLogic", localThrowable, "cleanup interrupted report", new Object[0]);
        }
      }
    }
  }
  
  public static final class d
    implements n
  {
    final AtomicBoolean kKD;
    
    public d()
    {
      AppMethodBeat.i(44248);
      this.kKD = new AtomicBoolean();
      AppMethodBeat.o(44248);
    }
    
    /* Error */
    private static void bd(List<String> paramList)
    {
      // Byte code:
      //   0: ldc 40
      //   2: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: invokestatic 46	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/util/List;)Z
      //   9: ifeq +9 -> 18
      //   12: ldc 40
      //   14: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   17: return
      //   18: new 48	java/util/HashSet
      //   21: dup
      //   22: aload_0
      //   23: invokespecial 51	java/util/HashSet:<init>	(Ljava/util/Collection;)V
      //   26: astore_0
      //   27: invokestatic 57	com/tencent/mm/plugin/appbrand/appcache/predownload/export/c:bwU	()Lcom/tencent/mm/plugin/appbrand/appcache/predownload/export/c;
      //   30: invokevirtual 61	com/tencent/mm/plugin/appbrand/appcache/predownload/export/c:bxg	()Ljava/util/List;
      //   33: astore 7
      //   35: aload 7
      //   37: invokeinterface 67 1 0
      //   42: ifne +135 -> 177
      //   45: aload 7
      //   47: invokeinterface 71 1 0
      //   52: astore 7
      //   54: aload 7
      //   56: invokeinterface 76 1 0
      //   61: ifeq +116 -> 177
      //   64: aload 7
      //   66: invokeinterface 80 1 0
      //   71: checkcast 82	com/tencent/mm/plugin/appbrand/appcache/predownload/export/c$b
      //   74: astore 8
      //   76: aload_0
      //   77: aload 8
      //   79: getfield 86	com/tencent/mm/plugin/appbrand/appcache/predownload/export/c$b:appId	Ljava/lang/String;
      //   82: invokevirtual 90	java/util/HashSet:remove	(Ljava/lang/Object;)Z
      //   85: pop
      //   86: invokestatic 96	com/tencent/mm/plugin/appbrand/app/n:buL	()Lcom/tencent/mm/plugin/appbrand/appcache/bh;
      //   89: aload 8
      //   91: getfield 86	com/tencent/mm/plugin/appbrand/appcache/predownload/export/c$b:appId	Ljava/lang/String;
      //   94: aload 8
      //   96: getfield 100	com/tencent/mm/plugin/appbrand/appcache/predownload/export/c$b:iOo	I
      //   99: aload 8
      //   101: getfield 103	com/tencent/mm/plugin/appbrand/appcache/predownload/export/c$b:version	I
      //   104: invokevirtual 109	com/tencent/mm/plugin/appbrand/appcache/bh:E	(Ljava/lang/String;II)I
      //   107: istore_1
      //   108: invokestatic 96	com/tencent/mm/plugin/appbrand/app/n:buL	()Lcom/tencent/mm/plugin/appbrand/appcache/bh;
      //   111: aload 8
      //   113: getfield 86	com/tencent/mm/plugin/appbrand/appcache/predownload/export/c$b:appId	Ljava/lang/String;
      //   116: aload 8
      //   118: getfield 100	com/tencent/mm/plugin/appbrand/appcache/predownload/export/c$b:iOo	I
      //   121: aload 8
      //   123: getfield 103	com/tencent/mm/plugin/appbrand/appcache/predownload/export/c$b:version	I
      //   126: invokevirtual 112	com/tencent/mm/plugin/appbrand/appcache/bh:F	(Ljava/lang/String;II)I
      //   129: istore_2
      //   130: ldc 114
      //   132: ldc 116
      //   134: iconst_4
      //   135: anewarray 4	java/lang/Object
      //   138: dup
      //   139: iconst_0
      //   140: aload 8
      //   142: getfield 86	com/tencent/mm/plugin/appbrand/appcache/predownload/export/c$b:appId	Ljava/lang/String;
      //   145: aastore
      //   146: dup
      //   147: iconst_1
      //   148: aload 8
      //   150: getfield 103	com/tencent/mm/plugin/appbrand/appcache/predownload/export/c$b:version	I
      //   153: invokestatic 122	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   156: aastore
      //   157: dup
      //   158: iconst_2
      //   159: iload_1
      //   160: invokestatic 122	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   163: aastore
      //   164: dup
      //   165: iconst_3
      //   166: iload_2
      //   167: invokestatic 122	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   170: aastore
      //   171: invokestatic 127	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   174: goto -120 -> 54
      //   177: invokestatic 131	com/tencent/mm/sdk/platformtools/Util:nowSecond	()J
      //   180: lstore_3
      //   181: invokestatic 137	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:bzP	()Lcom/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig;
      //   184: getfield 141	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:ldk	Lcom/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig$PackageManager;
      //   187: getfield 147	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig$PackageManager:ldC	J
      //   190: lstore 5
      //   192: aload_0
      //   193: invokevirtual 148	java/util/HashSet:iterator	()Ljava/util/Iterator;
      //   196: astore_0
      //   197: aload_0
      //   198: invokeinterface 76 1 0
      //   203: ifeq +196 -> 399
      //   206: aload_0
      //   207: invokeinterface 80 1 0
      //   212: checkcast 150	java/lang/String
      //   215: astore 7
      //   217: aload 7
      //   219: invokestatic 153	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
      //   222: ifne +13 -> 235
      //   225: aload 7
      //   227: ldc 155
      //   229: invokevirtual 158	java/lang/String:endsWith	(Ljava/lang/String;)Z
      //   232: ifne -35 -> 197
      //   235: aload 7
      //   237: iconst_0
      //   238: invokestatic 164	com/tencent/mm/plugin/appbrand/launching/m:bS	(Ljava/lang/String;I)Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo;
      //   241: astore 8
      //   243: aload 8
      //   245: ifnonnull +38 -> 283
      //   248: new 166	java/lang/StringBuilder
      //   251: dup
      //   252: invokespecial 167	java/lang/StringBuilder:<init>	()V
      //   255: aload 7
      //   257: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   260: bipush 36
      //   262: invokevirtual 174	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
      //   265: ldc 176
      //   267: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   270: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   273: iconst_0
      //   274: invokestatic 164	com/tencent/mm/plugin/appbrand/launching/m:bS	(Ljava/lang/String;I)Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo;
      //   277: ifnonnull -80 -> 197
      //   280: goto -83 -> 197
      //   283: getstatic 186	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
      //   286: new 188	com/tencent/mm/vfs/o
      //   289: dup
      //   290: aload 8
      //   292: getfield 193	com/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo:pkgPath	Ljava/lang/String;
      //   295: invokespecial 196	com/tencent/mm/vfs/o:<init>	(Ljava/lang/String;)V
      //   298: invokevirtual 199	com/tencent/mm/vfs/o:lastModified	()J
      //   301: invokevirtual 203	java/util/concurrent/TimeUnit:toSeconds	(J)J
      //   304: lload_3
      //   305: lload 5
      //   307: lsub
      //   308: lcmp
      //   309: ifge -112 -> 197
      //   312: ldc 114
      //   314: ldc 205
      //   316: iconst_2
      //   317: anewarray 4	java/lang/Object
      //   320: dup
      //   321: iconst_0
      //   322: aload 7
      //   324: aastore
      //   325: dup
      //   326: iconst_1
      //   327: aload 8
      //   329: getfield 208	com/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo:pkgVersion	I
      //   332: invokestatic 122	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   335: aastore
      //   336: invokestatic 127	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   339: invokestatic 96	com/tencent/mm/plugin/appbrand/app/n:buL	()Lcom/tencent/mm/plugin/appbrand/appcache/bh;
      //   342: aload 7
      //   344: iconst_0
      //   345: aload 8
      //   347: getfield 208	com/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo:pkgVersion	I
      //   350: invokevirtual 109	com/tencent/mm/plugin/appbrand/appcache/bh:E	(Ljava/lang/String;II)I
      //   353: pop
      //   354: invokestatic 96	com/tencent/mm/plugin/appbrand/app/n:buL	()Lcom/tencent/mm/plugin/appbrand/appcache/bh;
      //   357: aload 7
      //   359: iconst_0
      //   360: aload 8
      //   362: getfield 208	com/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo:pkgVersion	I
      //   365: invokevirtual 112	com/tencent/mm/plugin/appbrand/appcache/bh:F	(Ljava/lang/String;II)I
      //   368: pop
      //   369: ldc 210
      //   371: invokestatic 214	com/tencent/mm/plugin/appbrand/app/n:W	(Ljava/lang/Class;)Ljava/lang/Object;
      //   374: checkcast 210	com/tencent/mm/plugin/appbrand/ui/c/a/b
      //   377: aload 7
      //   379: iconst_0
      //   380: new 216	com/tencent/mm/plugin/appbrand/ui/c/a/b$b$c
      //   383: dup
      //   384: aload 8
      //   386: getfield 208	com/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo:pkgVersion	I
      //   389: invokespecial 218	com/tencent/mm/plugin/appbrand/ui/c/a/b$b$c:<init>	(I)V
      //   392: invokevirtual 221	com/tencent/mm/plugin/appbrand/ui/c/a/b:a	(Ljava/lang/String;ILcom/tencent/mm/plugin/appbrand/ui/c/a/b$b;)I
      //   395: pop
      //   396: goto -199 -> 197
      //   399: ldc 40
      //   401: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   404: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	405	0	paramList	List<String>
      //   107	53	1	i	int
      //   129	38	2	j	int
      //   180	125	3	l1	long
      //   190	116	5	l2	long
      //   33	345	7	localObject1	Object
      //   74	311	8	localObject2	Object
    }
    
    private void bvs()
    {
      AppMethodBeat.i(44249);
      if (this.kKD.get())
      {
        InterruptedException localInterruptedException = new InterruptedException();
        AppMethodBeat.o(44249);
        throw localInterruptedException;
      }
      AppMethodBeat.o(44249);
    }
    
    private void bvt()
    {
      AppMethodBeat.i(226351);
      bvs();
      Object localObject1 = com.tencent.mm.plugin.appbrand.app.n.buy();
      Object localObject2 = com.tencent.mm.plugin.appbrand.task.h.bWb().bVY();
      int i = 2147483647;
      int m = localObject2.length;
      int j = 0;
      int k;
      while (j < m)
      {
        int n = localObject2[j];
        k = i;
        if (n > 0) {
          k = Math.min(i, n);
        }
        j += 1;
        i = k;
      }
      if (2147483647 == i)
      {
        localObject2 = m.bS("@LibraryAppId", 0);
        if (localObject2 == null) {
          i = 0;
        }
      }
      for (;;)
      {
        if (i > 0)
        {
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processRelease, library.minValidVersion = %d", new Object[] { Integer.valueOf(i) });
          j = i - Math.max(0, ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rUr, 3) - 1);
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processRelease, delete libraries record < %d", new Object[] { Integer.valueOf(j) });
          localObject2 = com.tencent.mm.plugin.appbrand.app.n.buL().Vt("@LibraryAppId");
          com.tencent.mm.plugin.appbrand.app.n.buL().E("@LibraryAppId", 0, j);
          if ((localObject2 != null) && (localObject2.length > 0))
          {
            k = localObject2.length;
            i = 0;
            for (;;)
            {
              if (i < k)
              {
                m = localObject2[i];
                if (m < j) {
                  s.dy(bj.yR(m), true);
                }
                i += 1;
                continue;
                i = ((WxaPkgWrappingInfo)localObject2).pkgVersion;
                break;
              }
            }
          }
        }
        localObject1 = ((com.tencent.mm.storagebase.h)localObject1).rawQuery("select distinct appId from AppBrandWxaPkgManifestRecord where debugType=? and appId!=? and appId not like '%%$%%'", new String[] { "0", "@LibraryAppId" });
        if ((localObject1 == null) || (((Cursor)localObject1).isClosed()))
        {
          AppMethodBeat.o(226351);
          return;
        }
        Object localObject3 = new LinkedList();
        if (((Cursor)localObject1).moveToFirst())
        {
          localObject2 = ((Cursor)localObject1).getString(0);
          if (com.tencent.mm.plugin.appbrand.task.h.bWb().afi((String)localObject2))
          {
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processRelease appID(%s) is running, skip", new Object[] { localObject2 });
            label349:
            if (((Cursor)localObject1).moveToNext()) {
              break label480;
            }
          }
        }
        else
        {
          ((Cursor)localObject1).close();
          localObject1 = new LinkedList();
          bvs();
          localObject2 = new HashMap() {};
          localObject3 = ((List)localObject3).iterator();
        }
        for (;;)
        {
          if (!((Iterator)localObject3).hasNext()) {
            break label842;
          }
          Object localObject4 = (String)((Iterator)localObject3).next();
          Object localObject5 = com.tencent.mm.plugin.appbrand.app.n.buC().e((String)localObject4, new String[] { "versionInfo" });
          if ((localObject5 == null) || (Util.isNullOrNil(((WxaAttributes)localObject5).field_versionInfo)))
          {
            ((List)localObject1).add(localObject4);
            continue;
            ((List)localObject3).add(localObject2);
            break label349;
            label480:
            break;
          }
          bvs();
          if (((Map)localObject2).containsKey(localObject4))
          {
            localObject4 = (c.b)((Map)localObject2).get(localObject4);
            if (localObject4 == null)
            {
              com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrand.PkgCleanupNewLogic", "processReleaseContact, pkg is null!");
            }
            else
            {
              i = com.tencent.mm.plugin.appbrand.app.n.buL().E(((c.b)localObject4).appId, ((c.b)localObject4).iOo, ((c.b)localObject4).version);
              j = com.tencent.mm.plugin.appbrand.app.n.buL().F(((c.b)localObject4).appId, ((c.b)localObject4).iOo, ((c.b)localObject4).version);
              com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processReleaseContact, for export occupied, delete record(%s) < %d, deleting pkgCount: %d, moduleCount: %d", new Object[] { ((c.b)localObject4).appId, Integer.valueOf(((c.b)localObject4).version), Integer.valueOf(i), Integer.valueOf(j) });
            }
          }
          else
          {
            if (((WxaAttributes)localObject5).bAp() == null) {}
            for (i = 0; i > 0; i = ((WxaAttributes)localObject5).bAp().appVersion)
            {
              localObject5 = com.tencent.mm.plugin.appbrand.app.n.buL().Vs((String)localObject4);
              j = com.tencent.mm.plugin.appbrand.app.n.buL().E((String)localObject4, 0, i);
              if (j <= 0) {
                break label805;
              }
              com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processRelease, delete record(%s) < %d, count(%d)", new Object[] { localObject4, Integer.valueOf(i), Integer.valueOf(j) });
              lr locallr = new lr();
              locallr.eZr = 2L;
              locallr = locallr.yZ((String)localObject4);
              locallr.eZs = 0L;
              locallr.eZt = j;
              locallr.eZp = 1L;
              locallr.bfK();
              if ((localObject5 == null) || (localObject5.length <= 0)) {
                break label805;
              }
              k = localObject5.length;
              j = 0;
              while (j < k)
              {
                m = localObject5[j];
                if (m < i) {
                  s.dy(bj.cc((String)localObject4, m), true);
                }
                j += 1;
              }
            }
            continue;
            label805:
            com.tencent.mm.plugin.appbrand.app.n.buL().F((String)localObject4, 0, i);
            ((com.tencent.mm.plugin.appbrand.ui.c.a.b)com.tencent.mm.plugin.appbrand.app.n.W(com.tencent.mm.plugin.appbrand.ui.c.a.b.class)).a((String)localObject4, 0, new b.b.c(i));
          }
        }
        label842:
        bd((List)localObject1);
        AppMethodBeat.o(226351);
        return;
      }
    }
    
    private void bvu()
    {
      AppMethodBeat.i(44252);
      bvs();
      long l1 = Util.nowSecond();
      long l2 = AppBrandGlobalSystemConfig.bzP().ldk.ldC;
      Object localObject1 = ((an)com.tencent.mm.plugin.appbrand.app.n.W(an.class)).getAll();
      if ((localObject1 == null) || (((Cursor)localObject1).isClosed()))
      {
        AppMethodBeat.o(44252);
        return;
      }
      Object localObject2 = new LinkedList();
      if (((Cursor)localObject1).moveToFirst()) {
        do
        {
          am localam = new am();
          localam.convertFrom((Cursor)localObject1);
          ((List)localObject2).add(localam);
        } while (((Cursor)localObject1).moveToNext());
      }
      ((Cursor)localObject1).close();
      bvs();
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (am)((Iterator)localObject1).next();
        if (s.YS(((am)localObject2).field_pkgPath))
        {
          bvs();
          if (TimeUnit.MILLISECONDS.toSeconds(new o(((am)localObject2).field_pkgPath).lastModified()) < l1 - l2)
          {
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processEncrypted, delete record(%s %d %d)", new Object[] { ((am)localObject2).field_appId, Integer.valueOf(((am)localObject2).field_type), Integer.valueOf(((am)localObject2).field_version) });
            ((an)com.tencent.mm.plugin.appbrand.app.n.W(an.class)).delete((IAutoDBItem)localObject2, new String[0]);
            s.dy(((am)localObject2).field_pkgPath, true);
          }
        }
      }
      AppMethodBeat.o(44252);
    }
    
    private void bvv()
    {
      AppMethodBeat.i(44253);
      Object localObject1 = new o(az.bwm());
      if ((!((o)localObject1).exists()) || (!((o)localObject1).isDirectory()))
      {
        AppMethodBeat.o(44253);
        return;
      }
      localObject1 = ((o)localObject1).a(new q()
      {
        public final boolean accept(o paramAnonymouso)
        {
          AppMethodBeat.i(258036);
          boolean bool = paramAnonymouso.isFile();
          AppMethodBeat.o(258036);
          return bool;
        }
      });
      int j = localObject1.length;
      int i = 0;
      if (i < j)
      {
        Object localObject2 = localObject1[i];
        Object localObject4 = com.tencent.mm.plugin.appbrand.app.n.buL();
        Object localObject3 = aa.z(localObject2.her());
        localObject4 = ((bh)localObject4).kNJ;
        String str = String.format("%s=?", new Object[] { "pkgPath" });
        localObject3 = ((ISQLiteDatabaseEx)localObject4).query("AppBrandWxaPkgManifestRecord", new String[] { "appId" }, str, new String[] { localObject3 }, null, null, null, 2);
        boolean bool;
        if (localObject3 == null) {
          bool = false;
        }
        for (;;)
        {
          if (!bool) {
            n.a.US(aa.z(localObject2.her()));
          }
          i += 1;
          break;
          bool = ((Cursor)localObject3).moveToFirst();
          ((Cursor)localObject3).close();
        }
      }
      AppMethodBeat.o(44253);
    }
    
    private static void bvw()
    {
      AppMethodBeat.i(44254);
      Object localObject1 = bj.ntu;
      localObject1 = new o(bj.a.Mo());
      if ((!((o)localObject1).exists()) || (!((o)localObject1).isDirectory()))
      {
        ((o)localObject1).delete();
        AppMethodBeat.o(44254);
        return;
      }
      HashMap localHashMap = new HashMap();
      o[] arrayOfo = ((o)localObject1).het();
      int j = arrayOfo.length;
      int i = 0;
      o localo;
      Object localObject2;
      while (i < j)
      {
        localo = arrayOfo[i];
        localObject1 = localo.getName().split(Pattern.quote("-"));
        if ((localObject1 == null) || (localObject1.length < 2))
        {
          s.deleteFile(aa.z(localo.her()));
          s.dy(aa.z(localo.her()), true);
          i += 1;
        }
        else
        {
          localObject2 = localObject1[0];
          if (!"LIB".equals(localObject2)) {
            break label278;
          }
          localObject2 = "@LibraryAppId";
        }
      }
      label278:
      for (;;)
      {
        localObject1 = localObject1[1];
        if (localObject1 == null) {
          localObject1 = null;
        }
        for (;;)
        {
          int k = Util.getInt((String)localObject1, 0);
          int[] arrayOfInt = (int[])localHashMap.get(localObject2);
          localObject1 = arrayOfInt;
          if (arrayOfInt == null)
          {
            localObject1 = com.tencent.mm.plugin.appbrand.app.n.buL().Vs((String)localObject2);
            localHashMap.put(localObject2, localObject1);
          }
          if (a.contains((int[])localObject1, k)) {
            break;
          }
          s.deleteFile(aa.z(localo.her()));
          s.dy(aa.z(localo.her()), true);
          break;
          if (1 > ((String)localObject1).length()) {
            localObject1 = "";
          } else {
            localObject1 = ((String)localObject1).substring(1);
          }
        }
        AppMethodBeat.o(44254);
        return;
      }
    }
    
    public final void run()
    {
      AppMethodBeat.i(44250);
      if (com.tencent.mm.plugin.appbrand.app.n.buL() == null)
      {
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrand.PkgCleanupNewLogic", "run() entered but storage not ready");
        AppMethodBeat.o(44250);
        return;
      }
      this.kKD.set(false);
      long l3;
      long l1;
      label330:
      label602:
      for (;;)
      {
        Object localObject3;
        try
        {
          com.tencent.mm.plugin.report.service.h.CyF.dN(1007, 1);
          l3 = Util.currentTicks();
        }
        catch (Throwable localThrowable1)
        {
          try
          {
            bh localbh = com.tencent.mm.plugin.appbrand.app.n.buL();
            localObject3 = new StringBuilder("debugType");
            ((StringBuilder)localObject3).append(" in (");
            localObject4 = j.kKv;
            int j = localObject4.length;
            int i = 0;
            if (i < j)
            {
              ((StringBuilder)localObject3).append(localObject4[i]).append(',');
              i += 1;
              continue;
              localThrowable1 = localThrowable1;
              com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("MicroMsg.AppBrand.PkgCleanupNewLogic", localThrowable1, "cleanup start report", new Object[0]);
              continue;
            }
            ((StringBuilder)localObject3).append(-1).append(')');
            localObject3 = ((StringBuilder)localObject3).toString();
            localObject3 = localThrowable1.kNJ.query("AppBrandWxaPkgManifestRecord", null, (String)localObject3, null, null, null, null, 2);
            if (localObject3 != null) {
              break label330;
            }
            localObject1 = null;
          }
          catch (InterruptedException localInterruptedException)
          {
            Object localObject4;
            Object localObject1;
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "interrupted %s", new Object[] { android.util.Log.getStackTraceString(localInterruptedException) });
            return;
            if (((Cursor)localObject3).moveToFirst()) {
              break label353;
            }
            ((Cursor)localObject3).close();
            ArrayList localArrayList = null;
            continue;
            localArrayList = new ArrayList();
            do
            {
              localObject4 = new bd();
              ((bd)localObject4).convertFrom((Cursor)localObject3);
              localArrayList.add(localObject4);
            } while (((Cursor)localObject3).moveToNext());
            ((Cursor)localObject3).close();
            continue;
          }
          catch (Throwable localThrowable2)
          {
            com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrand.PkgCleanupNewLogic", "process occur exception %s", new Object[] { localThrowable2 });
            return;
            bvs();
            if ((((bd)localObject3).field_endTime <= 0L) || (((bd)localObject3).field_endTime > l1)) {
              break label602;
            }
            if (((bd)localObject3).field_debugType != 999) {
              continue;
            }
            n.a.US(((bd)localObject3).field_pkgPath);
            com.tencent.mm.plugin.appbrand.app.n.buL().a((bd)localObject3);
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processDebug, (%s, %d) exceed time range[%d, %d]", new Object[] { ((bd)localObject3).field_appId, Integer.valueOf(((bd)localObject3).field_debugType), Long.valueOf(((bd)localObject3).field_startTime), Long.valueOf(((bd)localObject3).field_endTime) });
            continue;
          }
          finally
          {
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "run() cost %dms", new Object[] { Long.valueOf(Util.currentTicks() - l3) });
            AppMethodBeat.o(44250);
          }
          if (Util.isNullOrNil((List)localObject1)) {
            break;
          }
          bvs();
          l1 = Util.nowSecond();
          localObject1 = ((List)localObject1).iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject3 = (bd)((Iterator)localObject1).next();
          if (com.tencent.mm.plugin.appbrand.task.h.bWb().afi(((bd)localObject3).field_appId))
          {
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processDebug appID(%s) is running, skip", new Object[] { ((bd)localObject3).field_appId });
            continue;
          }
        }
        label353:
        if (((bd)localObject3).field_debugType == 999) {
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processDebug, debug library not exceed time range[%d %d]", new Object[] { Long.valueOf(((bd)localObject3).field_startTime), Long.valueOf(((bd)localObject3).field_endTime) });
        }
      }
      bvt();
      bvu();
      bvv();
      bvw();
      bvs();
      StatFs localStatFs = new StatFs(az.bwm());
      long l4;
      long l2;
      label716:
      double d1;
      double d2;
      if (Build.VERSION.SDK_INT >= 18)
      {
        l1 = localStatFs.getBlockCountLong();
        l4 = n.b.bvq();
        if (Build.VERSION.SDK_INT < 18) {
          break label949;
        }
        l2 = localStatFs.getBlockSizeLong();
        d1 = l4 / l2 / l1;
        d2 = AppBrandGlobalSystemConfig.bzP().ldk.ldE / 100.0F;
        if ((d1 <= d2) || (l4 <= AppBrandGlobalSystemConfig.bzP().ldk.ldD * 1048576L)) {
          break label1016;
        }
      }
      label879:
      label1016:
      for (boolean bool = true;; bool = false)
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processByFilesystemUsage, usedPercent(%f), maxPercent(%f), usedBytes(%d), maxMB(%d), shouldCleanup=%B", new Object[] { Double.valueOf(d1), Double.valueOf(d2), Long.valueOf(l4), Long.valueOf(AppBrandGlobalSystemConfig.bzP().ldk.ldD), Boolean.valueOf(bool) });
        if (bool)
        {
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processByFilesystemUsage, cleanup by conditions usedPercent(%f) > maxPercent(%f)", new Object[] { Double.valueOf(d1), Double.valueOf(d2) });
          double d3 = l1;
          if (Build.VERSION.SDK_INT < 18) {
            break label960;
          }
          l1 = localStatFs.getBlockSizeLong();
          l1 = (l1 * (d3 * (d1 - d2)));
          if (l1 >= 0L) {
            break label971;
          }
          com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrand.PkgCleanupNewLogic", "processByFilesystemUsage, calculated bytesToTrim is minus");
        }
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "run() cost %dms", new Object[] { Long.valueOf(Util.currentTicks() - l3) });
          AppMethodBeat.o(44250);
          return;
          l1 = localStatFs.getBlockCount();
          break;
          l2 = localStatFs.getBlockSize();
          break label716;
          l1 = localStatFs.getBlockSize();
          break label879;
          bvs();
          ac.a(l1, new ac.a()
          {
            public final boolean bqX()
            {
              AppMethodBeat.i(44247);
              boolean bool = n.d.a(n.d.this).get();
              AppMethodBeat.o(44247);
              return bool;
            }
          });
          if (v.bvG()) {
            ak.a(l1 / 5L, new n.d.4(this));
          }
        }
      }
    }
  }
  
  public static final class e
  {
    public static int bvx()
    {
      AppMethodBeat.i(44255);
      HashSet localHashSet = new HashSet();
      Object localObject = "select distinct appId from AppBrandWxaPkgManifestRecord where  ( appId not like '%%$%%' or appId like " + String.format(Locale.US, "'%%$%s'", new Object[] { "__APP__" }) + " )  and  ( pkgPath is not null  and pkgPath != ''  ) ";
      Cursor localCursor = com.tencent.mm.plugin.appbrand.app.n.buy().rawQuery((String)localObject, null, 2);
      if ((localCursor != null) && (!localCursor.isClosed()))
      {
        if (localCursor.moveToFirst()) {
          do
          {
            String str = localCursor.getString(0);
            i = str.indexOf('$');
            localObject = str;
            if (i > 0) {
              localObject = str.substring(0, i);
            }
            localHashSet.add(localObject);
          } while (localCursor.moveToNext());
        }
        localCursor.close();
      }
      localObject = com.tencent.mm.plugin.appbrand.app.n.buy().rawQuery("select distinct appId from PredownloadEncryptPkgInfo where pkgPath is not null  and pkgPath != '' ", null, 2);
      if ((localObject != null) && (!((Cursor)localObject).isClosed()))
      {
        if (((Cursor)localObject).moveToFirst()) {
          localHashSet.add(((Cursor)localObject).getString(0));
        }
        while (((Cursor)localObject).moveToNext()) {}
        ((Cursor)localObject).close();
      }
      int i = localHashSet.size();
      AppMethodBeat.o(44255);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.n
 * JD-Core Version:    0.7.0.1
 */