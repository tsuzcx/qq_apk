package com.tencent.mm.plugin.appbrand.appcache;

import android.database.Cursor;
import android.os.Build.VERSION;
import android.os.StatFs;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.hw;
import com.tencent.mm.platformtools.r.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig.PackageManager;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.page.bf;
import com.tencent.mm.plugin.appbrand.page.bf.a;
import com.tencent.mm.plugin.appbrand.ui.c.a.b.b.c;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
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
    static void LJ(String paramString)
    {
      AppMethodBeat.i(44240);
      o.deleteFile(paramString);
      try
      {
        Runtime.getRuntime().exec("rm -r " + paramString + "_xdir");
        AppMethodBeat.o(44240);
        return;
      }
      catch (Exception localException)
      {
        ae.e("MicroMsg.AppBrand.PkgCleanupLogic.CleanupUtil", "rm -r %s, e = %s", new Object[] { paramString + "_xdir", localException });
        AppMethodBeat.o(44240);
      }
    }
  }
  
  public static final class b
  {
    public static long aZZ()
    {
      AppMethodBeat.i(44241);
      long l = com.tencent.mm.plugin.appbrand.appstorage.n.r(new k(az.baY()));
      AppMethodBeat.o(44241);
      return l;
    }
  }
  
  public static final class c
  {
    private static final n.d jIG;
    
    static
    {
      AppMethodBeat.i(44244);
      jIG = new n.d();
      AppMethodBeat.o(44244);
    }
    
    public static n baa()
    {
      AppMethodBeat.i(44242);
      n.d locald = jIG;
      AppMethodBeat.o(44242);
      return locald;
    }
    
    public static void interrupt()
    {
      AppMethodBeat.i(44243);
      n.d locald = jIG;
      try
      {
        com.tencent.mm.plugin.report.service.g.yxI.dD(1007, 2);
        locald.jIH.set(true);
        AppMethodBeat.o(44243);
        return;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          ae.printErrStackTrace("MicroMsg.AppBrand.PkgCleanupNewLogic", localThrowable, "cleanup interrupted report", new Object[0]);
        }
      }
    }
  }
  
  public static final class d
    implements n
  {
    final AtomicBoolean jIH;
    
    public d()
    {
      AppMethodBeat.i(44248);
      this.jIH = new AtomicBoolean();
      AppMethodBeat.o(44248);
    }
    
    /* Error */
    private static void aT(List<String> paramList)
    {
      // Byte code:
      //   0: ldc 40
      //   2: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: invokestatic 46	com/tencent/mm/sdk/platformtools/bu:ht	(Ljava/util/List;)Z
      //   9: ifeq +9 -> 18
      //   12: ldc 40
      //   14: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   17: return
      //   18: invokestatic 50	com/tencent/mm/sdk/platformtools/bu:aRi	()J
      //   21: lstore_1
      //   22: invokestatic 56	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:bez	()Lcom/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig;
      //   25: getfield 60	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:kah	Lcom/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig$PackageManager;
      //   28: getfield 66	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig$PackageManager:kay	J
      //   31: lstore_3
      //   32: aload_0
      //   33: invokeinterface 72 1 0
      //   38: astore_0
      //   39: aload_0
      //   40: invokeinterface 78 1 0
      //   45: ifeq +193 -> 238
      //   48: aload_0
      //   49: invokeinterface 82 1 0
      //   54: checkcast 84	java/lang/String
      //   57: astore 5
      //   59: aload 5
      //   61: invokestatic 88	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
      //   64: ifne +13 -> 77
      //   67: aload 5
      //   69: ldc 90
      //   71: invokevirtual 93	java/lang/String:endsWith	(Ljava/lang/String;)Z
      //   74: ifne -35 -> 39
      //   77: aload 5
      //   79: iconst_0
      //   80: invokestatic 99	com/tencent/mm/plugin/appbrand/launching/m:bN	(Ljava/lang/String;I)Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo;
      //   83: astore 6
      //   85: aload 6
      //   87: ifnonnull +38 -> 125
      //   90: new 101	java/lang/StringBuilder
      //   93: dup
      //   94: invokespecial 102	java/lang/StringBuilder:<init>	()V
      //   97: aload 5
      //   99: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   102: bipush 36
      //   104: invokevirtual 109	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
      //   107: ldc 111
      //   109: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   112: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   115: iconst_0
      //   116: invokestatic 99	com/tencent/mm/plugin/appbrand/launching/m:bN	(Ljava/lang/String;I)Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo;
      //   119: ifnonnull -80 -> 39
      //   122: goto -83 -> 39
      //   125: getstatic 121	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
      //   128: new 123	com/tencent/mm/vfs/k
      //   131: dup
      //   132: aload 6
      //   134: getfield 129	com/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo:pkgPath	Ljava/lang/String;
      //   137: invokespecial 132	com/tencent/mm/vfs/k:<init>	(Ljava/lang/String;)V
      //   140: invokevirtual 135	com/tencent/mm/vfs/k:lastModified	()J
      //   143: invokevirtual 139	java/util/concurrent/TimeUnit:toSeconds	(J)J
      //   146: lload_1
      //   147: lload_3
      //   148: lsub
      //   149: lcmp
      //   150: ifge -111 -> 39
      //   153: ldc 141
      //   155: ldc 143
      //   157: iconst_2
      //   158: anewarray 4	java/lang/Object
      //   161: dup
      //   162: iconst_0
      //   163: aload 5
      //   165: aastore
      //   166: dup
      //   167: iconst_1
      //   168: aload 6
      //   170: getfield 147	com/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo:pkgVersion	I
      //   173: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   176: aastore
      //   177: invokestatic 158	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   180: invokestatic 164	com/tencent/mm/plugin/appbrand/app/j:aZu	()Lcom/tencent/mm/plugin/appbrand/appcache/bh;
      //   183: aload 5
      //   185: aload 6
      //   187: getfield 147	com/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo:pkgVersion	I
      //   190: invokevirtual 170	com/tencent/mm/plugin/appbrand/appcache/bh:aU	(Ljava/lang/String;I)I
      //   193: pop
      //   194: invokestatic 164	com/tencent/mm/plugin/appbrand/app/j:aZu	()Lcom/tencent/mm/plugin/appbrand/appcache/bh;
      //   197: aload 5
      //   199: aload 6
      //   201: getfield 147	com/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo:pkgVersion	I
      //   204: invokevirtual 173	com/tencent/mm/plugin/appbrand/appcache/bh:aV	(Ljava/lang/String;I)I
      //   207: pop
      //   208: ldc 175
      //   210: invokestatic 179	com/tencent/mm/plugin/appbrand/app/j:T	(Ljava/lang/Class;)Ljava/lang/Object;
      //   213: checkcast 175	com/tencent/mm/plugin/appbrand/ui/c/a/b
      //   216: aload 5
      //   218: iconst_0
      //   219: new 181	com/tencent/mm/plugin/appbrand/ui/c/a/b$b$c
      //   222: dup
      //   223: aload 6
      //   225: getfield 147	com/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo:pkgVersion	I
      //   228: invokespecial 183	com/tencent/mm/plugin/appbrand/ui/c/a/b$b$c:<init>	(I)V
      //   231: invokevirtual 186	com/tencent/mm/plugin/appbrand/ui/c/a/b:a	(Ljava/lang/String;ILcom/tencent/mm/plugin/appbrand/ui/c/a/b$b;)I
      //   234: pop
      //   235: goto -196 -> 39
      //   238: ldc 40
      //   240: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   243: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	244	0	paramList	List<String>
      //   21	126	1	l1	long
      //   31	117	3	l2	long
      //   57	160	5	str	String
      //   83	141	6	localWxaPkgWrappingInfo	WxaPkgWrappingInfo
    }
    
    private void bab()
    {
      AppMethodBeat.i(44249);
      if (this.jIH.get())
      {
        InterruptedException localInterruptedException = new InterruptedException();
        AppMethodBeat.o(44249);
        throw localInterruptedException;
      }
      AppMethodBeat.o(44249);
    }
    
    private void bac()
    {
      AppMethodBeat.i(222126);
      bab();
      Object localObject1 = com.tencent.mm.plugin.appbrand.app.j.aZh();
      Object localObject2 = com.tencent.mm.plugin.appbrand.task.f.bzz();
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
        localObject2 = com.tencent.mm.plugin.appbrand.launching.m.bN("@LibraryAppId", 0);
        if (localObject2 == null) {
          i = 0;
        }
      }
      for (;;)
      {
        if (i > 0)
        {
          ae.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processRelease, library.minValidVersion = %d", new Object[] { Integer.valueOf(i) });
          j = i - Math.max(0, ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qBF, 3) - 1);
          ae.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processRelease, delete libraries record < %d", new Object[] { Integer.valueOf(j) });
          localObject2 = com.tencent.mm.plugin.appbrand.app.j.aZu().Mk("@LibraryAppId");
          com.tencent.mm.plugin.appbrand.app.j.aZu().aU("@LibraryAppId", j);
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
                  o.dd(bf.uZ(m), true);
                }
                i += 1;
                continue;
                i = ((WxaPkgWrappingInfo)localObject2).pkgVersion;
                break;
              }
            }
          }
        }
        localObject1 = ((h)localObject1).a("select distinct appId from AppBrandWxaPkgManifestRecord where debugType=? and appId!=? and appId not like '%%$%%'", new String[] { "0", "@LibraryAppId" }, 0);
        if ((localObject1 == null) || (((Cursor)localObject1).isClosed()))
        {
          AppMethodBeat.o(222126);
          return;
        }
        localObject2 = new LinkedList();
        String str;
        if (((Cursor)localObject1).moveToFirst())
        {
          str = ((Cursor)localObject1).getString(0);
          if (com.tencent.mm.plugin.appbrand.task.f.Vq(str))
          {
            ae.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processRelease appID(%s) is running, skip", new Object[] { str });
            label332:
            if (((Cursor)localObject1).moveToNext()) {
              break label453;
            }
          }
        }
        else
        {
          ((Cursor)localObject1).close();
          localObject1 = new LinkedList();
          bab();
          localObject2 = ((List)localObject2).iterator();
        }
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext()) {
            break label680;
          }
          str = (String)((Iterator)localObject2).next();
          Object localObject3 = com.tencent.mm.plugin.appbrand.app.j.aZl().e(str, new String[] { "versionInfo" });
          if ((localObject3 == null) || (bu.isNullOrNil(((WxaAttributes)localObject3).field_versionInfo)))
          {
            ((List)localObject1).add(str);
            continue;
            ((List)localObject2).add(str);
            break label332;
            label453:
            break;
          }
          bab();
          if (((WxaAttributes)localObject3).beV() == null) {}
          for (i = 0; i > 0; i = ((WxaAttributes)localObject3).beV().aDD)
          {
            localObject3 = com.tencent.mm.plugin.appbrand.app.j.aZu().Mj(str);
            j = com.tencent.mm.plugin.appbrand.app.j.aZu().aU(str, i);
            if (j <= 0) {
              break label644;
            }
            ae.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processRelease, delete record(%s) < %d, count(%d)", new Object[] { str, Integer.valueOf(i), Integer.valueOf(j) });
            hw localhw = new hw();
            localhw.euV = 2L;
            localhw = localhw.qW(str);
            localhw.euW = 0L;
            localhw.euX = j;
            localhw.euT = 1L;
            localhw.aLH();
            if ((localObject3 == null) || (localObject3.length <= 0)) {
              break label644;
            }
            k = localObject3.length;
            j = 0;
            while (j < k)
            {
              m = localObject3[j];
              if (m < i) {
                o.dd(bf.bU(str, m), true);
              }
              j += 1;
            }
          }
          continue;
          label644:
          com.tencent.mm.plugin.appbrand.app.j.aZu().aV(str, i);
          ((com.tencent.mm.plugin.appbrand.ui.c.a.b)com.tencent.mm.plugin.appbrand.app.j.T(com.tencent.mm.plugin.appbrand.ui.c.a.b.class)).a(str, 0, new b.b.c(i));
        }
        label680:
        aT((List)localObject1);
        AppMethodBeat.o(222126);
        return;
      }
    }
    
    private void bad()
    {
      AppMethodBeat.i(44252);
      bab();
      long l1 = bu.aRi();
      long l2 = AppBrandGlobalSystemConfig.bez().kah.kay;
      Object localObject1 = ((an)com.tencent.mm.plugin.appbrand.app.j.T(an.class)).getAll();
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
      bab();
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (am)((Iterator)localObject1).next();
        if (o.fB(((am)localObject2).field_pkgPath))
        {
          bab();
          if (TimeUnit.MILLISECONDS.toSeconds(new k(((am)localObject2).field_pkgPath).lastModified()) < l1 - l2)
          {
            ae.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processEncrypted, delete record(%s %d %d)", new Object[] { ((am)localObject2).field_appId, Integer.valueOf(((am)localObject2).field_type), Integer.valueOf(((am)localObject2).field_version) });
            ((an)com.tencent.mm.plugin.appbrand.app.j.T(an.class)).delete((c)localObject2, new String[0]);
            o.dd(((am)localObject2).field_pkgPath, true);
          }
        }
      }
      AppMethodBeat.o(44252);
    }
    
    private void bae()
    {
      AppMethodBeat.i(44253);
      Object localObject1 = new k(az.baY());
      if ((!((k)localObject1).exists()) || (!((k)localObject1).isDirectory()))
      {
        AppMethodBeat.o(44253);
        return;
      }
      localObject1 = ((k)localObject1).a(new com.tencent.mm.vfs.m()
      {
        public final boolean accept(k paramAnonymousk)
        {
          AppMethodBeat.i(174706);
          boolean bool = paramAnonymousk.isFile();
          AppMethodBeat.o(174706);
          return bool;
        }
      });
      int j = localObject1.length;
      int i = 0;
      if (i < j)
      {
        Object localObject2 = localObject1[i];
        Object localObject4 = com.tencent.mm.plugin.appbrand.app.j.aZu();
        Object localObject3 = com.tencent.mm.vfs.w.B(localObject2.fTh());
        localObject4 = ((bh)localObject4).jLK;
        String str = String.format("%s=?", new Object[] { "pkgPath" });
        localObject3 = ((com.tencent.mm.sdk.e.f)localObject4).a("AppBrandWxaPkgManifestRecord", new String[] { "appId" }, str, new String[] { localObject3 }, null, null, null, 2);
        boolean bool;
        if (localObject3 == null) {
          bool = false;
        }
        for (;;)
        {
          if (!bool) {
            n.a.LJ(com.tencent.mm.vfs.w.B(localObject2.fTh()));
          }
          i += 1;
          break;
          bool = ((Cursor)localObject3).moveToFirst();
          ((Cursor)localObject3).close();
        }
      }
      AppMethodBeat.o(44253);
    }
    
    private static void baf()
    {
      AppMethodBeat.i(44254);
      Object localObject1 = bf.mja;
      localObject1 = new k(bf.a.CS());
      if ((!((k)localObject1).exists()) || (!((k)localObject1).isDirectory()))
      {
        ((k)localObject1).delete();
        AppMethodBeat.o(44254);
        return;
      }
      HashMap localHashMap = new HashMap();
      k[] arrayOfk = ((k)localObject1).fTj();
      int j = arrayOfk.length;
      int i = 0;
      k localk;
      Object localObject2;
      while (i < j)
      {
        localk = arrayOfk[i];
        localObject1 = localk.getName().split(Pattern.quote("-"));
        if ((localObject1 == null) || (localObject1.length < 2))
        {
          o.deleteFile(com.tencent.mm.vfs.w.B(localk.fTh()));
          o.dd(com.tencent.mm.vfs.w.B(localk.fTh()), true);
          i += 1;
        }
        else
        {
          localObject2 = localObject1[0];
          if (!"LIB".equals(localObject2)) {
            break label277;
          }
          localObject2 = "@LibraryAppId";
        }
      }
      label277:
      for (;;)
      {
        localObject1 = localObject1[1];
        if (localObject1 == null) {
          localObject1 = null;
        }
        for (;;)
        {
          int k = bu.getInt((String)localObject1, 0);
          int[] arrayOfInt = (int[])localHashMap.get(localObject2);
          localObject1 = arrayOfInt;
          if (arrayOfInt == null)
          {
            localObject1 = com.tencent.mm.plugin.appbrand.app.j.aZu().Mj((String)localObject2);
            localHashMap.put(localObject2, localObject1);
          }
          if (a.contains((int[])localObject1, k)) {
            break;
          }
          o.deleteFile(com.tencent.mm.vfs.w.B(localk.fTh()));
          o.dd(com.tencent.mm.vfs.w.B(localk.fTh()), true);
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
      if (com.tencent.mm.plugin.appbrand.app.j.aZu() == null)
      {
        ae.e("MicroMsg.AppBrand.PkgCleanupNewLogic", "run() entered but storage not ready");
        AppMethodBeat.o(44250);
        return;
      }
      this.jIH.set(false);
      long l3;
      long l1;
      label325:
      label597:
      for (;;)
      {
        Object localObject3;
        try
        {
          com.tencent.mm.plugin.report.service.g.yxI.dD(1007, 1);
          l3 = bu.HQ();
        }
        catch (Throwable localThrowable1)
        {
          try
          {
            bh localbh = com.tencent.mm.plugin.appbrand.app.j.aZu();
            localObject3 = new StringBuilder("debugType");
            ((StringBuilder)localObject3).append(" in (");
            localObject4 = j.jIz;
            int j = localObject4.length;
            int i = 0;
            if (i < j)
            {
              ((StringBuilder)localObject3).append(localObject4[i]).append(',');
              i += 1;
              continue;
              localThrowable1 = localThrowable1;
              ae.printErrStackTrace("MicroMsg.AppBrand.PkgCleanupNewLogic", localThrowable1, "cleanup start report", new Object[0]);
              continue;
            }
            ((StringBuilder)localObject3).append(-1).append(')');
            localObject3 = ((StringBuilder)localObject3).toString();
            localObject3 = localThrowable1.jLK.a("AppBrandWxaPkgManifestRecord", null, (String)localObject3, null, null, null, null, 2);
            if (localObject3 != null) {
              break label325;
            }
            localObject1 = null;
          }
          catch (InterruptedException localInterruptedException)
          {
            Object localObject4;
            Object localObject1;
            ae.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "interrupted %s", new Object[] { Log.getStackTraceString(localInterruptedException) });
            return;
            if (((Cursor)localObject3).moveToFirst()) {
              break label348;
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
            ae.e("MicroMsg.AppBrand.PkgCleanupNewLogic", "process occur exception %s", new Object[] { localThrowable2 });
            return;
            bab();
            if ((((bd)localObject3).field_endTime <= 0L) || (((bd)localObject3).field_endTime > l1)) {
              break label597;
            }
            if (((bd)localObject3).field_debugType != 999) {
              continue;
            }
            n.a.LJ(((bd)localObject3).field_pkgPath);
            com.tencent.mm.plugin.appbrand.app.j.aZu().a((bd)localObject3);
            ae.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processDebug, (%s, %d) exceed time range[%d, %d]", new Object[] { ((bd)localObject3).field_appId, Integer.valueOf(((bd)localObject3).field_debugType), Long.valueOf(((bd)localObject3).field_startTime), Long.valueOf(((bd)localObject3).field_endTime) });
            continue;
          }
          finally
          {
            ae.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "run() cost %dms", new Object[] { Long.valueOf(bu.HQ() - l3) });
            AppMethodBeat.o(44250);
          }
          if (bu.ht((List)localObject1)) {
            break;
          }
          bab();
          l1 = bu.aRi();
          localObject1 = ((List)localObject1).iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject3 = (bd)((Iterator)localObject1).next();
          if (com.tencent.mm.plugin.appbrand.task.f.Vq(((bd)localObject3).field_appId))
          {
            ae.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processDebug appID(%s) is running, skip", new Object[] { ((bd)localObject3).field_appId });
            continue;
          }
        }
        label348:
        if (((bd)localObject3).field_debugType == 999) {
          ae.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processDebug, debug library not exceed time range[%d %d]", new Object[] { Long.valueOf(((bd)localObject3).field_startTime), Long.valueOf(((bd)localObject3).field_endTime) });
        }
      }
      bac();
      bad();
      bae();
      baf();
      bab();
      StatFs localStatFs = new StatFs(az.baY());
      long l4;
      long l2;
      label711:
      double d1;
      double d2;
      if (Build.VERSION.SDK_INT >= 18)
      {
        l1 = localStatFs.getBlockCountLong();
        l4 = n.b.aZZ();
        if (Build.VERSION.SDK_INT < 18) {
          break label944;
        }
        l2 = localStatFs.getBlockSizeLong();
        d1 = l4 / l2 / l1;
        d2 = AppBrandGlobalSystemConfig.bez().kah.kaA / 100.0F;
        if ((d1 <= d2) || (l4 <= AppBrandGlobalSystemConfig.bez().kah.kaz * 1048576L)) {
          break label1011;
        }
      }
      label874:
      label1011:
      for (boolean bool = true;; bool = false)
      {
        ae.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processByFilesystemUsage, usedPercent(%f), maxPercent(%f), usedBytes(%d), maxMB(%d), shouldCleanup=%B", new Object[] { Double.valueOf(d1), Double.valueOf(d2), Long.valueOf(l4), Long.valueOf(AppBrandGlobalSystemConfig.bez().kah.kaz), Boolean.valueOf(bool) });
        if (bool)
        {
          ae.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processByFilesystemUsage, cleanup by conditions usedPercent(%f) > maxPercent(%f)", new Object[] { Double.valueOf(d1), Double.valueOf(d2) });
          double d3 = l1;
          if (Build.VERSION.SDK_INT < 18) {
            break label955;
          }
          l1 = localStatFs.getBlockSizeLong();
          l1 = (l1 * (d3 * (d1 - d2)));
          if (l1 >= 0L) {
            break label966;
          }
          ae.e("MicroMsg.AppBrand.PkgCleanupNewLogic", "processByFilesystemUsage, calculated bytesToTrim is minus");
        }
        for (;;)
        {
          ae.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "run() cost %dms", new Object[] { Long.valueOf(bu.HQ() - l3) });
          AppMethodBeat.o(44250);
          return;
          l1 = localStatFs.getBlockCount();
          break;
          l2 = localStatFs.getBlockSize();
          break label711;
          l1 = localStatFs.getBlockSize();
          break label874;
          bab();
          ac.a(l1, new ac.a()
          {
            public final boolean aWa()
            {
              AppMethodBeat.i(44246);
              boolean bool = n.d.a(n.d.this).get();
              AppMethodBeat.o(44246);
              return bool;
            }
          });
          if (v.bas()) {
            ak.a(l1 / 5L, new ak.a()
            {
              public final boolean aWa()
              {
                AppMethodBeat.i(44247);
                boolean bool = n.d.a(n.d.this).get();
                AppMethodBeat.o(44247);
                return bool;
              }
            });
          }
        }
      }
    }
  }
  
  public static final class e
  {
    public static int bag()
    {
      AppMethodBeat.i(44255);
      HashSet localHashSet = new HashSet();
      Object localObject = "select distinct appId from AppBrandWxaPkgManifestRecord where  ( appId not like '%%$%%' or appId like " + String.format(Locale.US, "'%%$%s'", new Object[] { "__APP__" }) + " )  and  ( pkgPath is not null  and pkgPath != ''  ) ";
      Cursor localCursor = com.tencent.mm.plugin.appbrand.app.j.aZh().a((String)localObject, null, 2);
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
      localObject = com.tencent.mm.plugin.appbrand.app.j.aZh().a("select distinct appId from PredownloadEncryptPkgInfo where pkgPath is not null  and pkgPath != '' ", null, 2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.n
 * JD-Core Version:    0.7.0.1
 */