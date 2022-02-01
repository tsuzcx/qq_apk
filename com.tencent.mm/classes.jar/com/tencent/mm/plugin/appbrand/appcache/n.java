package com.tencent.mm.plugin.appbrand.appcache;

import android.database.Cursor;
import android.os.Build.VERSION;
import android.os.StatFs;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ez;
import com.tencent.mm.platformtools.r.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig.PackageManager;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.v;
import com.tencent.mm.plugin.appbrand.page.bl;
import com.tencent.mm.plugin.appbrand.page.bl.a;
import com.tencent.mm.plugin.appbrand.ui.c.a.b;
import com.tencent.mm.plugin.appbrand.ui.c.a.b.b.c;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.g;
import com.tencent.mm.vfs.i;
import com.tencent.mm.vfs.q;
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
    static void DN(String paramString)
    {
      AppMethodBeat.i(44240);
      i.deleteFile(paramString);
      try
      {
        Runtime.getRuntime().exec("rm -r " + paramString + "_xdir");
        AppMethodBeat.o(44240);
        return;
      }
      catch (Exception localException)
      {
        ad.e("MicroMsg.AppBrand.PkgCleanupLogic.CleanupUtil", "rm -r %s, e = %s", new Object[] { paramString + "_xdir", localException });
        AppMethodBeat.o(44240);
      }
    }
  }
  
  public static final class b
  {
    public static long aPp()
    {
      AppMethodBeat.i(44241);
      long l = com.tencent.mm.plugin.appbrand.appstorage.m.r(new e(ax.aQj()));
      AppMethodBeat.o(44241);
      return l;
    }
  }
  
  public static final class c
  {
    private static final n.d iLK;
    
    static
    {
      AppMethodBeat.i(44244);
      iLK = new n.d();
      AppMethodBeat.o(44244);
    }
    
    public static n aPq()
    {
      AppMethodBeat.i(44242);
      n.d locald = iLK;
      AppMethodBeat.o(44242);
      return locald;
    }
    
    public static void interrupt()
    {
      AppMethodBeat.i(44243);
      n.d locald = iLK;
      try
      {
        com.tencent.mm.plugin.report.service.h.vKh.dB(1007, 2);
        locald.iLL.set(true);
        AppMethodBeat.o(44243);
        return;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.AppBrand.PkgCleanupNewLogic", localThrowable, "cleanup interrupted report", new Object[0]);
        }
      }
    }
  }
  
  public static final class d
    implements n
  {
    final AtomicBoolean iLL;
    
    public d()
    {
      AppMethodBeat.i(44248);
      this.iLL = new AtomicBoolean();
      AppMethodBeat.o(44248);
    }
    
    private void aPr()
    {
      AppMethodBeat.i(44249);
      if (this.iLL.get())
      {
        InterruptedException localInterruptedException = new InterruptedException();
        AppMethodBeat.o(44249);
        throw localInterruptedException;
      }
      AppMethodBeat.o(44249);
    }
    
    private void aPs()
    {
      AppMethodBeat.i(195617);
      aPr();
      Object localObject1 = com.tencent.mm.plugin.appbrand.app.j.aOy();
      Object localObject2 = com.tencent.mm.plugin.appbrand.task.f.bnF();
      int m = localObject2.length;
      int j = 0;
      int k;
      for (int i = 2147483647; j < m; i = k)
      {
        int n = localObject2[j];
        k = i;
        if (n > 0) {
          k = Math.min(i, n);
        }
        j += 1;
      }
      if (2147483647 == i)
      {
        localObject2 = com.tencent.mm.plugin.appbrand.launching.m.bD("@LibraryAppId", 0);
        if (localObject2 == null) {
          i = 0;
        }
      }
      for (;;)
      {
        if (i > 0)
        {
          ad.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processRelease, delete libraries record < %d", new Object[] { Integer.valueOf(i) });
          localObject2 = com.tencent.mm.plugin.appbrand.app.j.aOK().Em("@LibraryAppId");
          com.tencent.mm.plugin.appbrand.app.j.aOK().aL("@LibraryAppId", i);
          if ((localObject2 != null) && (localObject2.length > 0))
          {
            k = localObject2.length;
            j = 0;
            for (;;)
            {
              if (j < k)
              {
                m = localObject2[j];
                if (m < i) {
                  i.cO(bl.tB(m), true);
                }
                j += 1;
                continue;
                i = ((WxaPkgWrappingInfo)localObject2).pkgVersion;
                break;
              }
            }
          }
        }
        localObject1 = ((com.tencent.mm.storagebase.h)localObject1).a("select distinct appId from AppBrandWxaPkgManifestRecord where debugType=? and appId!=? and appId not like '%%$%%'", new String[] { "0", "@LibraryAppId" }, 0);
        if ((localObject1 == null) || (((Cursor)localObject1).isClosed()))
        {
          AppMethodBeat.o(195617);
          return;
        }
        localObject2 = new LinkedList();
        String str;
        if (((Cursor)localObject1).moveToFirst())
        {
          str = ((Cursor)localObject1).getString(0);
          if (com.tencent.mm.plugin.appbrand.task.f.MQ(str))
          {
            ad.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processRelease appID(%s) is running, skip", new Object[] { str });
            label285:
            if (((Cursor)localObject1).moveToNext()) {
              break label405;
            }
          }
        }
        else
        {
          ((Cursor)localObject1).close();
          localObject1 = new LinkedList();
          aPr();
          localObject2 = ((List)localObject2).iterator();
        }
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext()) {
            break label631;
          }
          str = (String)((Iterator)localObject2).next();
          Object localObject3 = com.tencent.mm.plugin.appbrand.app.j.aOC().e(str, new String[] { "versionInfo" });
          if ((localObject3 == null) || (bt.isNullOrNil(((WxaAttributes)localObject3).field_versionInfo)))
          {
            ((List)localObject1).add(str);
            continue;
            ((List)localObject2).add(str);
            break label285;
            label405:
            break;
          }
          aPr();
          if (((WxaAttributes)localObject3).aTP() == null) {}
          for (i = 0; i > 0; i = ((WxaAttributes)localObject3).aTP().aAS)
          {
            localObject3 = com.tencent.mm.plugin.appbrand.app.j.aOK().El(str);
            j = com.tencent.mm.plugin.appbrand.app.j.aOK().aL(str, i);
            if (j <= 0) {
              break label595;
            }
            ad.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processRelease, delete record(%s) < %d, count(%d)", new Object[] { str, Integer.valueOf(i), Integer.valueOf(j) });
            ez localez = new ez();
            localez.eaD = 2L;
            localez = localez.kX(str);
            localez.eaE = 0L;
            localez.eaF = j;
            localez.eaB = 1L;
            localez.aBj();
            if ((localObject3 == null) || (localObject3.length <= 0)) {
              break label595;
            }
            k = localObject3.length;
            j = 0;
            while (j < k)
            {
              m = localObject3[j];
              if (m < i) {
                i.cO(bl.bJ(str, m), true);
              }
              j += 1;
            }
          }
          continue;
          label595:
          com.tencent.mm.plugin.appbrand.app.j.aOK().aM(str, i);
          ((b)com.tencent.mm.plugin.appbrand.app.j.T(b.class)).a(str, 0, new b.b.c(i));
        }
        label631:
        aU((List)localObject1);
        AppMethodBeat.o(195617);
        return;
      }
    }
    
    private void aPt()
    {
      AppMethodBeat.i(44252);
      aPr();
      long l1 = bt.aGK();
      long l2 = AppBrandGlobalSystemConfig.aTv().jcJ.jda;
      Object localObject1 = ((al)com.tencent.mm.plugin.appbrand.app.j.T(al.class)).getAll();
      if ((localObject1 == null) || (((Cursor)localObject1).isClosed()))
      {
        AppMethodBeat.o(44252);
        return;
      }
      Object localObject2 = new LinkedList();
      if (((Cursor)localObject1).moveToFirst()) {
        do
        {
          ak localak = new ak();
          localak.convertFrom((Cursor)localObject1);
          ((List)localObject2).add(localak);
        } while (((Cursor)localObject1).moveToNext());
      }
      ((Cursor)localObject1).close();
      aPr();
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ak)((Iterator)localObject1).next();
        if (i.eK(((ak)localObject2).field_pkgPath))
        {
          aPr();
          if (TimeUnit.MILLISECONDS.toSeconds(new e(((ak)localObject2).field_pkgPath).lastModified()) < l1 - l2)
          {
            ad.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processEncrypted, delete record(%s %d %d)", new Object[] { ((ak)localObject2).field_appId, Integer.valueOf(((ak)localObject2).field_type), Integer.valueOf(((ak)localObject2).field_version) });
            ((al)com.tencent.mm.plugin.appbrand.app.j.T(al.class)).delete((c)localObject2, new String[0]);
            i.cO(((ak)localObject2).field_pkgPath, true);
          }
        }
      }
      AppMethodBeat.o(44252);
    }
    
    private void aPu()
    {
      AppMethodBeat.i(44253);
      Object localObject1 = new e(ax.aQj());
      if ((!((e)localObject1).exists()) || (!((e)localObject1).isDirectory()))
      {
        AppMethodBeat.o(44253);
        return;
      }
      localObject1 = ((e)localObject1).a(new g()
      {
        public final boolean accept(e paramAnonymouse)
        {
          AppMethodBeat.i(174706);
          boolean bool = paramAnonymouse.isFile();
          AppMethodBeat.o(174706);
          return bool;
        }
      });
      int j = localObject1.length;
      int i = 0;
      if (i < j)
      {
        Object localObject2 = localObject1[i];
        Object localObject4 = com.tencent.mm.plugin.appbrand.app.j.aOK();
        Object localObject3 = q.B(localObject2.fhU());
        localObject4 = ((bf)localObject4).iOE;
        String str = String.format("%s=?", new Object[] { "pkgPath" });
        localObject3 = ((com.tencent.mm.sdk.e.f)localObject4).a("AppBrandWxaPkgManifestRecord", new String[] { "appId" }, str, new String[] { localObject3 }, null, null, null, 2);
        boolean bool;
        if (localObject3 == null) {
          bool = false;
        }
        for (;;)
        {
          if (!bool) {
            n.a.DN(q.B(localObject2.fhU()));
          }
          i += 1;
          break;
          bool = ((Cursor)localObject3).moveToFirst();
          ((Cursor)localObject3).close();
        }
      }
      AppMethodBeat.o(44253);
    }
    
    private static void aPv()
    {
      AppMethodBeat.i(44254);
      Object localObject1 = bl.lfm;
      localObject1 = new e(bl.a.BM());
      if ((!((e)localObject1).exists()) || (!((e)localObject1).isDirectory()))
      {
        ((e)localObject1).delete();
        AppMethodBeat.o(44254);
        return;
      }
      HashMap localHashMap = new HashMap();
      e[] arrayOfe = ((e)localObject1).fhW();
      int j = arrayOfe.length;
      int i = 0;
      e locale;
      Object localObject2;
      while (i < j)
      {
        locale = arrayOfe[i];
        localObject1 = locale.getName().split(Pattern.quote("-"));
        if ((localObject1 == null) || (localObject1.length < 2))
        {
          i.deleteFile(q.B(locale.fhU()));
          i.cO(q.B(locale.fhU()), true);
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
          int k = bt.getInt((String)localObject1, 0);
          int[] arrayOfInt = (int[])localHashMap.get(localObject2);
          localObject1 = arrayOfInt;
          if (arrayOfInt == null)
          {
            localObject1 = com.tencent.mm.plugin.appbrand.app.j.aOK().El((String)localObject2);
            localHashMap.put(localObject2, localObject1);
          }
          if (a.contains((int[])localObject1, k)) {
            break;
          }
          i.deleteFile(q.B(locale.fhU()));
          i.cO(q.B(locale.fhU()), true);
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
    
    /* Error */
    private static void aU(List<String> paramList)
    {
      // Byte code:
      //   0: ldc_w 466
      //   3: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   6: aload_0
      //   7: invokestatic 470	com/tencent/mm/sdk/platformtools/bt:gL	(Ljava/util/List;)Z
      //   10: ifeq +10 -> 20
      //   13: ldc_w 466
      //   16: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   19: return
      //   20: invokestatic 272	com/tencent/mm/sdk/platformtools/bt:aGK	()J
      //   23: lstore_1
      //   24: invokestatic 278	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:aTv	()Lcom/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig;
      //   27: getfield 282	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:jcJ	Lcom/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig$PackageManager;
      //   30: getfield 287	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig$PackageManager:jda	J
      //   33: lstore_3
      //   34: aload_0
      //   35: invokeinterface 167 1 0
      //   40: astore_0
      //   41: aload_0
      //   42: invokeinterface 172 1 0
      //   47: ifeq +196 -> 243
      //   50: aload_0
      //   51: invokeinterface 176 1 0
      //   56: checkcast 128	java/lang/String
      //   59: astore 5
      //   61: aload 5
      //   63: invokestatic 199	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
      //   66: ifne +14 -> 80
      //   69: aload 5
      //   71: ldc_w 472
      //   74: invokevirtual 475	java/lang/String:endsWith	(Ljava/lang/String;)Z
      //   77: ifne -36 -> 41
      //   80: aload 5
      //   82: iconst_0
      //   83: invokestatic 77	com/tencent/mm/plugin/appbrand/launching/m:bD	(Ljava/lang/String;I)Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo;
      //   86: astore 6
      //   88: aload 6
      //   90: ifnonnull +39 -> 129
      //   93: new 477	java/lang/StringBuilder
      //   96: dup
      //   97: invokespecial 478	java/lang/StringBuilder:<init>	()V
      //   100: aload 5
      //   102: invokevirtual 482	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   105: bipush 36
      //   107: invokevirtual 485	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
      //   110: ldc_w 487
      //   113: invokevirtual 482	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   116: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   119: iconst_0
      //   120: invokestatic 77	com/tencent/mm/plugin/appbrand/launching/m:bD	(Ljava/lang/String;I)Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo;
      //   123: ifnonnull -82 -> 41
      //   126: goto -85 -> 41
      //   129: getstatic 312	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
      //   132: new 314	com/tencent/mm/vfs/e
      //   135: dup
      //   136: aload 6
      //   138: getfield 492	com/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo:pkgPath	Ljava/lang/String;
      //   141: invokespecial 317	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
      //   144: invokevirtual 320	com/tencent/mm/vfs/e:lastModified	()J
      //   147: invokevirtual 324	java/util/concurrent/TimeUnit:toSeconds	(J)J
      //   150: lload_1
      //   151: lload_3
      //   152: lsub
      //   153: lcmp
      //   154: ifge -113 -> 41
      //   157: ldc 79
      //   159: ldc_w 494
      //   162: iconst_2
      //   163: anewarray 4	java/lang/Object
      //   166: dup
      //   167: iconst_0
      //   168: aload 5
      //   170: aastore
      //   171: dup
      //   172: iconst_1
      //   173: aload 6
      //   175: getfield 124	com/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo:pkgVersion	I
      //   178: invokestatic 87	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   181: aastore
      //   182: invokestatic 92	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   185: invokestatic 96	com/tencent/mm/plugin/appbrand/app/j:aOK	()Lcom/tencent/mm/plugin/appbrand/appcache/bf;
      //   188: aload 5
      //   190: aload 6
      //   192: getfield 124	com/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo:pkgVersion	I
      //   195: invokevirtual 106	com/tencent/mm/plugin/appbrand/appcache/bf:aL	(Ljava/lang/String;I)I
      //   198: pop
      //   199: invokestatic 96	com/tencent/mm/plugin/appbrand/app/j:aOK	()Lcom/tencent/mm/plugin/appbrand/appcache/bf;
      //   202: aload 5
      //   204: aload 6
      //   206: getfield 124	com/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo:pkgVersion	I
      //   209: invokevirtual 249	com/tencent/mm/plugin/appbrand/appcache/bf:aM	(Ljava/lang/String;I)I
      //   212: pop
      //   213: ldc 251
      //   215: invokestatic 255	com/tencent/mm/plugin/appbrand/app/j:T	(Ljava/lang/Class;)Ljava/lang/Object;
      //   218: checkcast 251	com/tencent/mm/plugin/appbrand/ui/c/a/b
      //   221: aload 5
      //   223: iconst_0
      //   224: new 257	com/tencent/mm/plugin/appbrand/ui/c/a/b$b$c
      //   227: dup
      //   228: aload 6
      //   230: getfield 124	com/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo:pkgVersion	I
      //   233: invokespecial 259	com/tencent/mm/plugin/appbrand/ui/c/a/b$b$c:<init>	(I)V
      //   236: invokevirtual 262	com/tencent/mm/plugin/appbrand/ui/c/a/b:a	(Ljava/lang/String;ILcom/tencent/mm/plugin/appbrand/ui/c/a/b$b;)I
      //   239: pop
      //   240: goto -199 -> 41
      //   243: ldc_w 466
      //   246: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   249: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	250	0	paramList	List<String>
      //   23	128	1	l1	long
      //   33	119	3	l2	long
      //   59	163	5	str	String
      //   86	143	6	localWxaPkgWrappingInfo	WxaPkgWrappingInfo
    }
    
    public final void run()
    {
      AppMethodBeat.i(44250);
      if (com.tencent.mm.plugin.appbrand.app.j.aOK() == null)
      {
        ad.e("MicroMsg.AppBrand.PkgCleanupNewLogic", "run() entered but storage not ready");
        AppMethodBeat.o(44250);
        return;
      }
      this.iLL.set(false);
      long l3;
      long l1;
      label325:
      label597:
      for (;;)
      {
        Object localObject3;
        try
        {
          com.tencent.mm.plugin.report.service.h.vKh.dB(1007, 1);
          l3 = bt.GC();
        }
        catch (Throwable localThrowable1)
        {
          try
          {
            bf localbf = com.tencent.mm.plugin.appbrand.app.j.aOK();
            localObject3 = new StringBuilder("debugType");
            ((StringBuilder)localObject3).append(" in (");
            localObject4 = j.iLD;
            int j = localObject4.length;
            int i = 0;
            if (i < j)
            {
              ((StringBuilder)localObject3).append(localObject4[i]).append(',');
              i += 1;
              continue;
              localThrowable1 = localThrowable1;
              ad.printErrStackTrace("MicroMsg.AppBrand.PkgCleanupNewLogic", localThrowable1, "cleanup start report", new Object[0]);
              continue;
            }
            ((StringBuilder)localObject3).append(-1).append(')');
            localObject3 = ((StringBuilder)localObject3).toString();
            localObject3 = localThrowable1.iOE.a("AppBrandWxaPkgManifestRecord", null, (String)localObject3, null, null, null, null, 2);
            if (localObject3 != null) {
              break label325;
            }
            localObject1 = null;
          }
          catch (InterruptedException localInterruptedException)
          {
            Object localObject4;
            Object localObject1;
            ad.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "interrupted %s", new Object[] { Log.getStackTraceString(localInterruptedException) });
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
              localObject4 = new bb();
              ((bb)localObject4).convertFrom((Cursor)localObject3);
              localArrayList.add(localObject4);
            } while (((Cursor)localObject3).moveToNext());
            ((Cursor)localObject3).close();
            continue;
          }
          catch (Throwable localThrowable2)
          {
            ad.e("MicroMsg.AppBrand.PkgCleanupNewLogic", "process occur exception %s", new Object[] { localThrowable2 });
            return;
            aPr();
            if ((((bb)localObject3).field_endTime <= 0L) || (((bb)localObject3).field_endTime > l1)) {
              break label597;
            }
            if (((bb)localObject3).field_debugType != 999) {
              continue;
            }
            n.a.DN(((bb)localObject3).field_pkgPath);
            com.tencent.mm.plugin.appbrand.app.j.aOK().a((bb)localObject3);
            ad.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processDebug, (%s, %d) exceed time range[%d, %d]", new Object[] { ((bb)localObject3).field_appId, Integer.valueOf(((bb)localObject3).field_debugType), Long.valueOf(((bb)localObject3).field_startTime), Long.valueOf(((bb)localObject3).field_endTime) });
            continue;
          }
          finally
          {
            ad.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "run() cost %dms", new Object[] { Long.valueOf(bt.GC() - l3) });
            AppMethodBeat.o(44250);
          }
          if (bt.gL((List)localObject1)) {
            break;
          }
          aPr();
          l1 = bt.aGK();
          localObject1 = ((List)localObject1).iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject3 = (bb)((Iterator)localObject1).next();
          if (com.tencent.mm.plugin.appbrand.task.f.MQ(((bb)localObject3).field_appId))
          {
            ad.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processDebug appID(%s) is running, skip", new Object[] { ((bb)localObject3).field_appId });
            continue;
          }
        }
        label348:
        if (((bb)localObject3).field_debugType == 999) {
          ad.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processDebug, debug library not exceed time range[%d %d]", new Object[] { Long.valueOf(((bb)localObject3).field_startTime), Long.valueOf(((bb)localObject3).field_endTime) });
        }
      }
      aPs();
      aPt();
      aPu();
      aPv();
      aPr();
      StatFs localStatFs = new StatFs(ax.aQj());
      long l4;
      long l2;
      label711:
      double d1;
      double d2;
      if (Build.VERSION.SDK_INT >= 18)
      {
        l1 = localStatFs.getBlockCountLong();
        l4 = n.b.aPp();
        if (Build.VERSION.SDK_INT < 18) {
          break label944;
        }
        l2 = localStatFs.getBlockSizeLong();
        d1 = l4 / l2 / l1;
        d2 = AppBrandGlobalSystemConfig.aTv().jcJ.jdc / 100.0F;
        if ((d1 <= d2) || (l4 <= AppBrandGlobalSystemConfig.aTv().jcJ.jdb * 1048576L)) {
          break label1011;
        }
      }
      label874:
      label1011:
      for (boolean bool = true;; bool = false)
      {
        ad.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processByFilesystemUsage, usedPercent(%f), maxPercent(%f), usedBytes(%d), maxMB(%d), shouldCleanup=%B", new Object[] { Double.valueOf(d1), Double.valueOf(d2), Long.valueOf(l4), Long.valueOf(AppBrandGlobalSystemConfig.aTv().jcJ.jdb), Boolean.valueOf(bool) });
        if (bool)
        {
          ad.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processByFilesystemUsage, cleanup by conditions usedPercent(%f) > maxPercent(%f)", new Object[] { Double.valueOf(d1), Double.valueOf(d2) });
          double d3 = l1;
          if (Build.VERSION.SDK_INT < 18) {
            break label955;
          }
          l1 = localStatFs.getBlockSizeLong();
          l1 = (l1 * (d3 * (d1 - d2)));
          if (l1 >= 0L) {
            break label966;
          }
          ad.e("MicroMsg.AppBrand.PkgCleanupNewLogic", "processByFilesystemUsage, calculated bytesToTrim is minus");
        }
        for (;;)
        {
          ad.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "run() cost %dms", new Object[] { Long.valueOf(bt.GC() - l3) });
          AppMethodBeat.o(44250);
          return;
          l1 = localStatFs.getBlockCount();
          break;
          l2 = localStatFs.getBlockSize();
          break label711;
          l1 = localStatFs.getBlockSize();
          break label874;
          aPr();
          aa.a(l1, new aa.a()
          {
            public final boolean aLy()
            {
              AppMethodBeat.i(44246);
              boolean bool = n.d.a(n.d.this).get();
              AppMethodBeat.o(44246);
              return bool;
            }
          });
          if (u.aPG()) {
            ai.a(l1 / 5L, new ai.a()
            {
              public final boolean aLy()
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
    public static int aPw()
    {
      AppMethodBeat.i(44255);
      HashSet localHashSet = new HashSet();
      Object localObject = "select distinct appId from AppBrandWxaPkgManifestRecord where  ( appId not like '%%$%%' or appId like " + String.format(Locale.US, "'%%$%s'", new Object[] { "__APP__" }) + " )  and  ( pkgPath is not null  and pkgPath != ''  ) ";
      Cursor localCursor = com.tencent.mm.plugin.appbrand.app.j.aOy().a((String)localObject, null, 2);
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
      localObject = com.tencent.mm.plugin.appbrand.app.j.aOy().a("select distinct appId from PredownloadEncryptPkgInfo where pkgPath is not null  and pkgPath != '' ", null, 2);
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