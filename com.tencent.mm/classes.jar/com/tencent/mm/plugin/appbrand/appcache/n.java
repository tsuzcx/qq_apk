package com.tencent.mm.plugin.appbrand.appcache;

import android.database.Cursor;
import android.os.Build.VERSION;
import android.os.StatFs;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.gr;
import com.tencent.mm.platformtools.r.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig.PackageManager;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.v;
import com.tencent.mm.plugin.appbrand.page.bg;
import com.tencent.mm.plugin.appbrand.page.bg.a;
import com.tencent.mm.plugin.appbrand.ui.c.a.b;
import com.tencent.mm.plugin.appbrand.ui.c.a.b.b.c;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
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
    static void HQ(String paramString)
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
        ac.e("MicroMsg.AppBrand.PkgCleanupLogic.CleanupUtil", "rm -r %s, e = %s", new Object[] { paramString + "_xdir", localException });
        AppMethodBeat.o(44240);
      }
    }
  }
  
  public static final class b
  {
    public static long aWh()
    {
      AppMethodBeat.i(44241);
      long l = com.tencent.mm.plugin.appbrand.appstorage.m.r(new e(ax.aXb()));
      AppMethodBeat.o(44241);
      return l;
    }
  }
  
  public static final class c
  {
    private static final n.d jlR;
    
    static
    {
      AppMethodBeat.i(44244);
      jlR = new n.d();
      AppMethodBeat.o(44244);
    }
    
    public static n aWi()
    {
      AppMethodBeat.i(44242);
      n.d locald = jlR;
      AppMethodBeat.o(44242);
      return locald;
    }
    
    public static void interrupt()
    {
      AppMethodBeat.i(44243);
      n.d locald = jlR;
      try
      {
        com.tencent.mm.plugin.report.service.h.wUl.dB(1007, 2);
        locald.jlS.set(true);
        AppMethodBeat.o(44243);
        return;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          ac.printErrStackTrace("MicroMsg.AppBrand.PkgCleanupNewLogic", localThrowable, "cleanup interrupted report", new Object[0]);
        }
      }
    }
  }
  
  public static final class d
    implements n
  {
    final AtomicBoolean jlS;
    
    public d()
    {
      AppMethodBeat.i(44248);
      this.jlS = new AtomicBoolean();
      AppMethodBeat.o(44248);
    }
    
    /* Error */
    private static void aS(List<String> paramList)
    {
      // Byte code:
      //   0: ldc 40
      //   2: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: invokestatic 46	com/tencent/mm/sdk/platformtools/bs:gY	(Ljava/util/List;)Z
      //   9: ifeq +9 -> 18
      //   12: ldc 40
      //   14: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   17: return
      //   18: invokestatic 50	com/tencent/mm/sdk/platformtools/bs:aNx	()J
      //   21: lstore_1
      //   22: invokestatic 56	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:bat	()Lcom/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig;
      //   25: getfield 60	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:jCW	Lcom/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig$PackageManager;
      //   28: getfield 66	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig$PackageManager:jDn	J
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
      //   61: invokestatic 88	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
      //   64: ifne +13 -> 77
      //   67: aload 5
      //   69: ldc 90
      //   71: invokevirtual 93	java/lang/String:endsWith	(Ljava/lang/String;)Z
      //   74: ifne -35 -> 39
      //   77: aload 5
      //   79: iconst_0
      //   80: invokestatic 99	com/tencent/mm/plugin/appbrand/launching/m:bH	(Ljava/lang/String;I)Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo;
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
      //   116: invokestatic 99	com/tencent/mm/plugin/appbrand/launching/m:bH	(Ljava/lang/String;I)Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo;
      //   119: ifnonnull -80 -> 39
      //   122: goto -83 -> 39
      //   125: getstatic 121	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
      //   128: new 123	com/tencent/mm/vfs/e
      //   131: dup
      //   132: aload 6
      //   134: getfield 129	com/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo:pkgPath	Ljava/lang/String;
      //   137: invokespecial 132	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
      //   140: invokevirtual 135	com/tencent/mm/vfs/e:lastModified	()J
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
      //   177: invokestatic 158	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   180: invokestatic 164	com/tencent/mm/plugin/appbrand/app/j:aVC	()Lcom/tencent/mm/plugin/appbrand/appcache/bf;
      //   183: aload 5
      //   185: aload 6
      //   187: getfield 147	com/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo:pkgVersion	I
      //   190: invokevirtual 170	com/tencent/mm/plugin/appbrand/appcache/bf:aP	(Ljava/lang/String;I)I
      //   193: pop
      //   194: invokestatic 164	com/tencent/mm/plugin/appbrand/app/j:aVC	()Lcom/tencent/mm/plugin/appbrand/appcache/bf;
      //   197: aload 5
      //   199: aload 6
      //   201: getfield 147	com/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo:pkgVersion	I
      //   204: invokevirtual 173	com/tencent/mm/plugin/appbrand/appcache/bf:aQ	(Ljava/lang/String;I)I
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
    
    private void aWj()
    {
      AppMethodBeat.i(44249);
      if (this.jlS.get())
      {
        InterruptedException localInterruptedException = new InterruptedException();
        AppMethodBeat.o(44249);
        throw localInterruptedException;
      }
      AppMethodBeat.o(44249);
    }
    
    private void aWk()
    {
      AppMethodBeat.i(186321);
      aWj();
      Object localObject1 = com.tencent.mm.plugin.appbrand.app.j.aVq();
      Object localObject2 = com.tencent.mm.plugin.appbrand.task.f.buB();
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
        localObject2 = com.tencent.mm.plugin.appbrand.launching.m.bH("@LibraryAppId", 0);
        if (localObject2 == null) {
          i = 0;
        }
      }
      for (;;)
      {
        if (i > 0)
        {
          ac.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processRelease, delete libraries record < %d", new Object[] { Integer.valueOf(i) });
          localObject2 = com.tencent.mm.plugin.appbrand.app.j.aVC().Ip("@LibraryAppId");
          com.tencent.mm.plugin.appbrand.app.j.aVC().aP("@LibraryAppId", i);
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
                  i.cU(bg.ur(m), true);
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
          AppMethodBeat.o(186321);
          return;
        }
        localObject2 = new LinkedList();
        String str;
        if (((Cursor)localObject1).moveToFirst())
        {
          str = ((Cursor)localObject1).getString(0);
          if (com.tencent.mm.plugin.appbrand.task.f.QZ(str))
          {
            ac.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processRelease appID(%s) is running, skip", new Object[] { str });
            label286:
            if (((Cursor)localObject1).moveToNext()) {
              break label407;
            }
          }
        }
        else
        {
          ((Cursor)localObject1).close();
          localObject1 = new LinkedList();
          aWj();
          localObject2 = ((List)localObject2).iterator();
        }
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext()) {
            break label634;
          }
          str = (String)((Iterator)localObject2).next();
          Object localObject3 = com.tencent.mm.plugin.appbrand.app.j.aVu().e(str, new String[] { "versionInfo" });
          if ((localObject3 == null) || (bs.isNullOrNil(((WxaAttributes)localObject3).field_versionInfo)))
          {
            ((List)localObject1).add(str);
            continue;
            ((List)localObject2).add(str);
            break label286;
            label407:
            break;
          }
          aWj();
          if (((WxaAttributes)localObject3).baN() == null) {}
          for (i = 0; i > 0; i = ((WxaAttributes)localObject3).baN().aBM)
          {
            localObject3 = com.tencent.mm.plugin.appbrand.app.j.aVC().Io(str);
            j = com.tencent.mm.plugin.appbrand.app.j.aVC().aP(str, i);
            if (j <= 0) {
              break label598;
            }
            ac.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processRelease, delete record(%s) < %d, count(%d)", new Object[] { str, Integer.valueOf(i), Integer.valueOf(j) });
            gr localgr = new gr();
            localgr.ecJ = 2L;
            localgr = localgr.oc(str);
            localgr.ecK = 0L;
            localgr.ecL = j;
            localgr.ecH = 1L;
            localgr.aHZ();
            if ((localObject3 == null) || (localObject3.length <= 0)) {
              break label598;
            }
            k = localObject3.length;
            j = 0;
            while (j < k)
            {
              m = localObject3[j];
              if (m < i) {
                i.cU(bg.bN(str, m), true);
              }
              j += 1;
            }
          }
          continue;
          label598:
          com.tencent.mm.plugin.appbrand.app.j.aVC().aQ(str, i);
          ((b)com.tencent.mm.plugin.appbrand.app.j.T(b.class)).a(str, 0, new b.b.c(i));
        }
        label634:
        aS((List)localObject1);
        AppMethodBeat.o(186321);
        return;
      }
    }
    
    private void aWl()
    {
      AppMethodBeat.i(44252);
      aWj();
      long l1 = bs.aNx();
      long l2 = AppBrandGlobalSystemConfig.bat().jCW.jDn;
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
      aWj();
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ak)((Iterator)localObject1).next();
        if (i.eA(((ak)localObject2).field_pkgPath))
        {
          aWj();
          if (TimeUnit.MILLISECONDS.toSeconds(new e(((ak)localObject2).field_pkgPath).lastModified()) < l1 - l2)
          {
            ac.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processEncrypted, delete record(%s %d %d)", new Object[] { ((ak)localObject2).field_appId, Integer.valueOf(((ak)localObject2).field_type), Integer.valueOf(((ak)localObject2).field_version) });
            ((al)com.tencent.mm.plugin.appbrand.app.j.T(al.class)).delete((c)localObject2, new String[0]);
            i.cU(((ak)localObject2).field_pkgPath, true);
          }
        }
      }
      AppMethodBeat.o(44252);
    }
    
    private void aWm()
    {
      AppMethodBeat.i(44253);
      Object localObject1 = new e(ax.aXb());
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
        Object localObject4 = com.tencent.mm.plugin.appbrand.app.j.aVC();
        Object localObject3 = q.B(localObject2.fxV());
        localObject4 = ((bf)localObject4).joN;
        String str = String.format("%s=?", new Object[] { "pkgPath" });
        localObject3 = ((com.tencent.mm.sdk.e.f)localObject4).a("AppBrandWxaPkgManifestRecord", new String[] { "appId" }, str, new String[] { localObject3 }, null, null, null, 2);
        boolean bool;
        if (localObject3 == null) {
          bool = false;
        }
        for (;;)
        {
          if (!bool) {
            n.a.HQ(q.B(localObject2.fxV()));
          }
          i += 1;
          break;
          bool = ((Cursor)localObject3).moveToFirst();
          ((Cursor)localObject3).close();
        }
      }
      AppMethodBeat.o(44253);
    }
    
    private static void aWn()
    {
      AppMethodBeat.i(44254);
      Object localObject1 = bg.lFc;
      localObject1 = new e(bg.a.Bq());
      if ((!((e)localObject1).exists()) || (!((e)localObject1).isDirectory()))
      {
        ((e)localObject1).delete();
        AppMethodBeat.o(44254);
        return;
      }
      HashMap localHashMap = new HashMap();
      e[] arrayOfe = ((e)localObject1).fxX();
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
          i.deleteFile(q.B(locale.fxV()));
          i.cU(q.B(locale.fxV()), true);
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
          int k = bs.getInt((String)localObject1, 0);
          int[] arrayOfInt = (int[])localHashMap.get(localObject2);
          localObject1 = arrayOfInt;
          if (arrayOfInt == null)
          {
            localObject1 = com.tencent.mm.plugin.appbrand.app.j.aVC().Io((String)localObject2);
            localHashMap.put(localObject2, localObject1);
          }
          if (a.contains((int[])localObject1, k)) {
            break;
          }
          i.deleteFile(q.B(locale.fxV()));
          i.cU(q.B(locale.fxV()), true);
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
      if (com.tencent.mm.plugin.appbrand.app.j.aVC() == null)
      {
        ac.e("MicroMsg.AppBrand.PkgCleanupNewLogic", "run() entered but storage not ready");
        AppMethodBeat.o(44250);
        return;
      }
      this.jlS.set(false);
      long l3;
      long l1;
      label325:
      label597:
      for (;;)
      {
        Object localObject3;
        try
        {
          com.tencent.mm.plugin.report.service.h.wUl.dB(1007, 1);
          l3 = bs.Gn();
        }
        catch (Throwable localThrowable1)
        {
          try
          {
            bf localbf = com.tencent.mm.plugin.appbrand.app.j.aVC();
            localObject3 = new StringBuilder("debugType");
            ((StringBuilder)localObject3).append(" in (");
            localObject4 = j.jlK;
            int j = localObject4.length;
            int i = 0;
            if (i < j)
            {
              ((StringBuilder)localObject3).append(localObject4[i]).append(',');
              i += 1;
              continue;
              localThrowable1 = localThrowable1;
              ac.printErrStackTrace("MicroMsg.AppBrand.PkgCleanupNewLogic", localThrowable1, "cleanup start report", new Object[0]);
              continue;
            }
            ((StringBuilder)localObject3).append(-1).append(')');
            localObject3 = ((StringBuilder)localObject3).toString();
            localObject3 = localThrowable1.joN.a("AppBrandWxaPkgManifestRecord", null, (String)localObject3, null, null, null, null, 2);
            if (localObject3 != null) {
              break label325;
            }
            localObject1 = null;
          }
          catch (InterruptedException localInterruptedException)
          {
            Object localObject4;
            Object localObject1;
            ac.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "interrupted %s", new Object[] { Log.getStackTraceString(localInterruptedException) });
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
            ac.e("MicroMsg.AppBrand.PkgCleanupNewLogic", "process occur exception %s", new Object[] { localThrowable2 });
            return;
            aWj();
            if ((((bb)localObject3).field_endTime <= 0L) || (((bb)localObject3).field_endTime > l1)) {
              break label597;
            }
            if (((bb)localObject3).field_debugType != 999) {
              continue;
            }
            n.a.HQ(((bb)localObject3).field_pkgPath);
            com.tencent.mm.plugin.appbrand.app.j.aVC().a((bb)localObject3);
            ac.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processDebug, (%s, %d) exceed time range[%d, %d]", new Object[] { ((bb)localObject3).field_appId, Integer.valueOf(((bb)localObject3).field_debugType), Long.valueOf(((bb)localObject3).field_startTime), Long.valueOf(((bb)localObject3).field_endTime) });
            continue;
          }
          finally
          {
            ac.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "run() cost %dms", new Object[] { Long.valueOf(bs.Gn() - l3) });
            AppMethodBeat.o(44250);
          }
          if (bs.gY((List)localObject1)) {
            break;
          }
          aWj();
          l1 = bs.aNx();
          localObject1 = ((List)localObject1).iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject3 = (bb)((Iterator)localObject1).next();
          if (com.tencent.mm.plugin.appbrand.task.f.QZ(((bb)localObject3).field_appId))
          {
            ac.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processDebug appID(%s) is running, skip", new Object[] { ((bb)localObject3).field_appId });
            continue;
          }
        }
        label348:
        if (((bb)localObject3).field_debugType == 999) {
          ac.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processDebug, debug library not exceed time range[%d %d]", new Object[] { Long.valueOf(((bb)localObject3).field_startTime), Long.valueOf(((bb)localObject3).field_endTime) });
        }
      }
      aWk();
      aWl();
      aWm();
      aWn();
      aWj();
      StatFs localStatFs = new StatFs(ax.aXb());
      long l4;
      long l2;
      label711:
      double d1;
      double d2;
      if (Build.VERSION.SDK_INT >= 18)
      {
        l1 = localStatFs.getBlockCountLong();
        l4 = n.b.aWh();
        if (Build.VERSION.SDK_INT < 18) {
          break label944;
        }
        l2 = localStatFs.getBlockSizeLong();
        d1 = l4 / l2 / l1;
        d2 = AppBrandGlobalSystemConfig.bat().jCW.jDp / 100.0F;
        if ((d1 <= d2) || (l4 <= AppBrandGlobalSystemConfig.bat().jCW.jDo * 1048576L)) {
          break label1011;
        }
      }
      label874:
      label1011:
      for (boolean bool = true;; bool = false)
      {
        ac.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processByFilesystemUsage, usedPercent(%f), maxPercent(%f), usedBytes(%d), maxMB(%d), shouldCleanup=%B", new Object[] { Double.valueOf(d1), Double.valueOf(d2), Long.valueOf(l4), Long.valueOf(AppBrandGlobalSystemConfig.bat().jCW.jDo), Boolean.valueOf(bool) });
        if (bool)
        {
          ac.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processByFilesystemUsage, cleanup by conditions usedPercent(%f) > maxPercent(%f)", new Object[] { Double.valueOf(d1), Double.valueOf(d2) });
          double d3 = l1;
          if (Build.VERSION.SDK_INT < 18) {
            break label955;
          }
          l1 = localStatFs.getBlockSizeLong();
          l1 = (l1 * (d3 * (d1 - d2)));
          if (l1 >= 0L) {
            break label966;
          }
          ac.e("MicroMsg.AppBrand.PkgCleanupNewLogic", "processByFilesystemUsage, calculated bytesToTrim is minus");
        }
        for (;;)
        {
          ac.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "run() cost %dms", new Object[] { Long.valueOf(bs.Gn() - l3) });
          AppMethodBeat.o(44250);
          return;
          l1 = localStatFs.getBlockCount();
          break;
          l2 = localStatFs.getBlockSize();
          break label711;
          l1 = localStatFs.getBlockSize();
          break label874;
          aWj();
          aa.a(l1, new aa.a()
          {
            public final boolean aSp()
            {
              AppMethodBeat.i(44246);
              boolean bool = n.d.a(n.d.this).get();
              AppMethodBeat.o(44246);
              return bool;
            }
          });
          if (u.aWy()) {
            ai.a(l1 / 5L, new ai.a()
            {
              public final boolean aSp()
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
    public static int aWo()
    {
      AppMethodBeat.i(44255);
      HashSet localHashSet = new HashSet();
      Object localObject = "select distinct appId from AppBrandWxaPkgManifestRecord where  ( appId not like '%%$%%' or appId like " + String.format(Locale.US, "'%%$%s'", new Object[] { "__APP__" }) + " )  and  ( pkgPath is not null  and pkgPath != ''  ) ";
      Cursor localCursor = com.tencent.mm.plugin.appbrand.app.j.aVq().a((String)localObject, null, 2);
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
      localObject = com.tencent.mm.plugin.appbrand.app.j.aVq().a("select distinct appId from PredownloadEncryptPkgInfo where pkgPath is not null  and pkgPath != '' ", null, 2);
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