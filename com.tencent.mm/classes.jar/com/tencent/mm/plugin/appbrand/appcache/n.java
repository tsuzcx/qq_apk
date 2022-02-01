package com.tencent.mm.plugin.appbrand.appcache;

import android.database.Cursor;
import android.os.Build.VERSION;
import android.os.StatFs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.op;
import com.tencent.mm.platformtools.r.a;
import com.tencent.mm.plugin.appbrand.app.m;
import com.tencent.mm.plugin.appbrand.appcache.predownload.export.c;
import com.tencent.mm.plugin.appbrand.appcache.predownload.export.c.b;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig.PackageManager;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaPluginCodeInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.ac;
import com.tencent.mm.plugin.appbrand.config.v;
import com.tencent.mm.plugin.appbrand.config.z;
import com.tencent.mm.plugin.appbrand.launching.ar;
import com.tencent.mm.plugin.appbrand.launching.l;
import com.tencent.mm.plugin.appbrand.page.bl;
import com.tencent.mm.plugin.appbrand.page.bl.a;
import com.tencent.mm.plugin.appbrand.task.d;
import com.tencent.mm.plugin.appbrand.task.i;
import com.tencent.mm.plugin.appbrand.ui.c.a.b.b.c;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabaseEx;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.Collection;
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
    static void acC(String paramString)
    {
      AppMethodBeat.i(44240);
      u.deleteFile(paramString);
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
    public static long bGw()
    {
      AppMethodBeat.i(44241);
      long l = o.p(new com.tencent.mm.vfs.q(bc.bHt()));
      AppMethodBeat.o(44241);
      return l;
    }
  }
  
  public static final class c
  {
    private static final n.d nEr;
    
    static
    {
      AppMethodBeat.i(44244);
      nEr = new n.d();
      AppMethodBeat.o(44244);
    }
    
    public static n bGx()
    {
      AppMethodBeat.i(44242);
      n.d locald = nEr;
      AppMethodBeat.o(44242);
      return locald;
    }
    
    public static void interrupt()
    {
      AppMethodBeat.i(44243);
      n.d locald = nEr;
      try
      {
        com.tencent.mm.plugin.report.service.h.IzE.el(1007, 2);
        locald.nEs.set(true);
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
    final AtomicBoolean nEs;
    
    public d()
    {
      AppMethodBeat.i(44248);
      this.nEs = new AtomicBoolean();
      AppMethodBeat.o(44248);
    }
    
    private void bGA()
    {
      AppMethodBeat.i(275428);
      bGy();
      Object localObject1 = m.bFB();
      Object localObject3 = (Iterable)i.cjb().RS();
      Object localObject2 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject3, 10));
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((Collection)localObject2).add(Integer.valueOf(((d)((Iterator)localObject3).next()).qRa));
      }
      localObject2 = kotlin.a.j.s((Collection)localObject2);
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
        localObject2 = l.cq("@LibraryAppId", 0);
        if (localObject2 == null) {
          i = 0;
        }
      }
      for (;;)
      {
        if (i > 0)
        {
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processRelease, library.minValidVersion = %d", new Object[] { Integer.valueOf(i) });
          j = i - Math.max(0, ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vBb, 3) - 1);
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processRelease, delete libraries record < %d", new Object[] { Integer.valueOf(j) });
          localObject2 = m.bFP().adc("@LibraryAppId");
          m.bFP().E("@LibraryAppId", 0, j);
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
                  u.dK(bl.Cv(m), true);
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
          AppMethodBeat.o(275428);
          return;
        }
        localObject3 = new LinkedList();
        if (((Cursor)localObject1).moveToFirst())
        {
          localObject2 = ((Cursor)localObject1).getString(0);
          if (i.cjb().eh((String)localObject2))
          {
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processRelease appID(%s) is running, skip", new Object[] { localObject2 });
            label416:
            if (((Cursor)localObject1).moveToNext()) {
              break label546;
            }
          }
        }
        else
        {
          ((Cursor)localObject1).close();
          localObject1 = new LinkedList();
          bGy();
          localObject2 = new HashMap() {};
          localObject3 = ((List)localObject3).iterator();
        }
        for (;;)
        {
          if (!((Iterator)localObject3).hasNext()) {
            break label942;
          }
          Object localObject4 = (String)((Iterator)localObject3).next();
          Object localObject5 = m.bFF().d((String)localObject4, new String[] { "versionInfo" });
          if ((localObject5 == null) || (Util.isNullOrNil(((WxaAttributes)localObject5).field_versionInfo)))
          {
            ((List)localObject1).add(localObject4);
            continue;
            ((List)localObject3).add(localObject2);
            break label416;
            label546:
            break;
          }
          bGy();
          if (((Map)localObject2).containsKey(localObject4))
          {
            localObject4 = (c.b)((Map)localObject2).get(localObject4);
            if (localObject4 == null)
            {
              com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrand.PkgCleanupNewLogic", "processReleaseContact, pkg is null!");
            }
            else
            {
              i = m.bFP().E(((c.b)localObject4).appId, ((c.b)localObject4).cBU, ((c.b)localObject4).version);
              j = m.bFP().F(((c.b)localObject4).appId, ((c.b)localObject4).cBU, ((c.b)localObject4).version);
              com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processReleaseContact, for export occupied, delete record(%s) < %d, deleting pkgCount: %d, moduleCount: %d", new Object[] { ((c.b)localObject4).appId, Integer.valueOf(((c.b)localObject4).version), Integer.valueOf(i), Integer.valueOf(j) });
            }
          }
          else
          {
            if (((WxaAttributes)localObject5).bLH() == null) {}
            for (i = 0; i > 0; i = ((WxaAttributes)localObject5).bLH().appVersion)
            {
              localObject5 = m.bFP().adb((String)localObject4);
              j = m.bFP().E((String)localObject4, 0, i);
              if (j <= 0) {
                break label872;
              }
              com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processRelease, delete record(%s) < %d, count(%d)", new Object[] { localObject4, Integer.valueOf(i), Integer.valueOf(j) });
              op localop = new op();
              localop.hci = 2L;
              localop = localop.FF((String)localObject4);
              localop.hcj = 0L;
              localop.hck = j;
              localop.hcg = 1L;
              localop.bpa();
              if ((localObject5 == null) || (localObject5.length <= 0)) {
                break label872;
              }
              k = localObject5.length;
              j = 0;
              while (j < k)
              {
                m = localObject5[j];
                if (m < i) {
                  u.dK(bl.cA((String)localObject4, m), true);
                }
                j += 1;
              }
            }
            continue;
            label872:
            m.bFP().F((String)localObject4, 0, i);
            ((com.tencent.mm.plugin.appbrand.ui.c.a.b)m.W(com.tencent.mm.plugin.appbrand.ui.c.a.b.class)).a((String)localObject4, 0, new b.b.c(i));
            ((bx)m.W(bx.class)).bt((String)localObject4, i);
            ((v)m.W(v.class)).bY((String)localObject4, i);
          }
        }
        label942:
        bb((List)localObject1);
        AppMethodBeat.o(275428);
        return;
      }
    }
    
    private void bGB()
    {
      AppMethodBeat.i(44252);
      bGy();
      long l1 = Util.nowSecond();
      long l2 = AppBrandGlobalSystemConfig.bLe().nXt.nXP;
      Object localObject1 = ((ao)m.W(ao.class)).getAll();
      if ((localObject1 == null) || (((Cursor)localObject1).isClosed()))
      {
        AppMethodBeat.o(44252);
        return;
      }
      Object localObject2 = new LinkedList();
      if (((Cursor)localObject1).moveToFirst()) {
        do
        {
          an localan = new an();
          localan.convertFrom((Cursor)localObject1);
          ((List)localObject2).add(localan);
        } while (((Cursor)localObject1).moveToNext());
      }
      ((Cursor)localObject1).close();
      bGy();
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (an)((Iterator)localObject1).next();
        if (u.agG(((an)localObject2).field_pkgPath))
        {
          bGy();
          if (TimeUnit.MILLISECONDS.toSeconds(new com.tencent.mm.vfs.q(((an)localObject2).field_pkgPath).lastModified()) < l1 - l2)
          {
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processEncrypted, delete record(%s %d %d)", new Object[] { ((an)localObject2).field_appId, Integer.valueOf(((an)localObject2).field_type), Integer.valueOf(((an)localObject2).field_version) });
            ((ao)m.W(ao.class)).delete((IAutoDBItem)localObject2, new String[0]);
            u.deleteDir(((an)localObject2).field_pkgPath);
          }
        }
      }
      AppMethodBeat.o(44252);
    }
    
    private void bGC()
    {
      AppMethodBeat.i(44253);
      Object localObject1 = new com.tencent.mm.vfs.q(bc.bHt());
      if ((!((com.tencent.mm.vfs.q)localObject1).ifE()) || (!((com.tencent.mm.vfs.q)localObject1).isDirectory()))
      {
        AppMethodBeat.o(44253);
        return;
      }
      localObject1 = ((com.tencent.mm.vfs.q)localObject1).a(new com.tencent.mm.vfs.s()
      {
        public final boolean accept(com.tencent.mm.vfs.q paramAnonymousq)
        {
          AppMethodBeat.i(280885);
          boolean bool = paramAnonymousq.ifH();
          AppMethodBeat.o(280885);
          return bool;
        }
      });
      int j = localObject1.length;
      int i = 0;
      if (i < j)
      {
        Object localObject2 = localObject1[i];
        Object localObject4 = m.bFP();
        Object localObject3 = localObject2.bOF();
        localObject4 = ((bm)localObject4).nHI;
        String str = String.format("%s=?", new Object[] { "pkgPath" });
        localObject3 = ((ISQLiteDatabaseEx)localObject4).query("AppBrandWxaPkgManifestRecord", new String[] { "appId" }, str, new String[] { localObject3 }, null, null, null, 2);
        boolean bool;
        if (localObject3 == null) {
          bool = false;
        }
        for (;;)
        {
          if (!bool) {
            n.a.acC(localObject2.bOF());
          }
          i += 1;
          break;
          bool = ((Cursor)localObject3).moveToFirst();
          ((Cursor)localObject3).close();
        }
      }
      AppMethodBeat.o(44253);
    }
    
    private static void bGD()
    {
      AppMethodBeat.i(44254);
      Object localObject1 = bl.qvp;
      localObject1 = new com.tencent.mm.vfs.q(bl.a.Pg());
      if ((!((com.tencent.mm.vfs.q)localObject1).ifE()) || (!((com.tencent.mm.vfs.q)localObject1).isDirectory()))
      {
        ((com.tencent.mm.vfs.q)localObject1).cFq();
        AppMethodBeat.o(44254);
        return;
      }
      com.tencent.mm.vfs.q[] arrayOfq = ((com.tencent.mm.vfs.q)localObject1).ifJ();
      if ((arrayOfq == null) || (arrayOfq.length == 0))
      {
        ((com.tencent.mm.vfs.q)localObject1).cFq();
        AppMethodBeat.o(44254);
        return;
      }
      HashMap localHashMap = new HashMap();
      int j = arrayOfq.length;
      int i = 0;
      com.tencent.mm.vfs.q localq;
      Object localObject2;
      while (i < j)
      {
        localq = arrayOfq[i];
        localObject1 = localq.getName().split(Pattern.quote("-"));
        if ((localObject1 == null) || (localObject1.length < 2))
        {
          u.deleteFile(localq.bOF());
          u.dK(localq.bOF(), true);
          i += 1;
        }
        else
        {
          localObject2 = localObject1[0];
          if (!"LIB".equals(localObject2)) {
            break label352;
          }
          localObject2 = "@LibraryAppId";
        }
      }
      label352:
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
            arrayOfInt = m.bFP().adb((String)localObject2);
            localObject1 = arrayOfInt;
            if (arrayOfInt == null)
            {
              localObject1 = new int[1];
              localObject1[0] = 0;
            }
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processExpiredWebViewCodeCache, select_versionArray(%s), get(%s)", new Object[] { localObject2, a.m(localObject1, "-1") });
            localHashMap.put(localObject2, localObject1);
          }
          if (a.contains((int[])localObject1, k)) {
            break;
          }
          u.deleteFile(localq.bOF());
          u.dK(localq.bOF(), true);
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processExpiredWebViewCodeCache, file(%s) deleted", new Object[] { localq.bOF() });
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
    
    private void bGy()
    {
      AppMethodBeat.i(44249);
      if (this.nEs.get())
      {
        InterruptedException localInterruptedException = new InterruptedException();
        AppMethodBeat.o(44249);
        throw localInterruptedException;
      }
      AppMethodBeat.o(44249);
    }
    
    private static void bGz()
    {
      AppMethodBeat.i(275426);
      Object localObject1 = new LinkedList();
      Object localObject4 = ((com.tencent.mm.plugin.appbrand.launching.s)m.W(com.tencent.mm.plugin.appbrand.launching.s.class)).getAll();
      if ((localObject4 == null) || (((Cursor)localObject4).isClosed()))
      {
        AppMethodBeat.o(275426);
        return;
      }
      boolean bool1;
      try
      {
        if (((Cursor)localObject4).moveToFirst()) {
          do
          {
            localq = new com.tencent.mm.plugin.appbrand.launching.q();
            localq.convertFrom((Cursor)localObject4);
            ((List)localObject1).add(localq);
            bool1 = ((Cursor)localObject4).moveToNext();
          } while (bool1);
        }
        ((Cursor)localObject4).close();
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          com.tencent.mm.plugin.appbrand.launching.q localq;
          com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("MicroMsg.AppBrand.PkgCleanupNewLogic", localException1, "getDevPkgLaunchExtInfoStorage", new Object[0]);
          ((Cursor)localObject4).close();
        }
      }
      finally
      {
        ((Cursor)localObject4).close();
        AppMethodBeat.o(275426);
      }
      localObject4 = new LinkedList();
      localObject1 = ((List)localObject1).iterator();
      Object localObject7;
      while (((Iterator)localObject1).hasNext())
      {
        localq = (com.tencent.mm.plugin.appbrand.launching.q)((Iterator)localObject1).next();
        localObject7 = localq.field_extJson;
        if ((Util.isNullOrNil((String)localObject7)) || ((!Util.isNullOrNil((String)localObject7)) && (((String)localObject7).equals("{}"))))
        {
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processPluginDebug appID(%s) extJson null", new Object[] { localq.field_appId });
        }
        else
        {
          localObject6 = ac.afy((String)localObject7).obB;
          if ((localObject6 != null) && (((List)localObject6).size() > 0))
          {
            localObject6 = ((List)localObject6).iterator();
            while (((Iterator)localObject6).hasNext())
            {
              localObject7 = (WxaAttributes.WxaPluginCodeInfo)((Iterator)localObject6).next();
              if (!Util.isNullOrNil(((WxaAttributes.WxaPluginCodeInfo)localObject7).nGm))
              {
                ((List)localObject4).add(localObject7);
                com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processPluginDebug needKeep provider:%s,versionDesc:%s", new Object[] { ((WxaAttributes.WxaPluginCodeInfo)localObject7).provider, ((WxaAttributes.WxaPluginCodeInfo)localObject7).nGm });
              }
            }
          }
        }
      }
      Object localObject6 = new LinkedList();
      Object localObject3 = m.bFQ().getAll();
      if ((localObject3 == null) || (((Cursor)localObject3).isClosed()))
      {
        AppMethodBeat.o(275426);
        return;
      }
      try
      {
        if (((Cursor)localObject3).moveToFirst()) {
          do
          {
            localObject7 = new bi();
            ((bi)localObject7).convertFrom((Cursor)localObject3);
            ((List)localObject6).add(localObject7);
            bool1 = ((Cursor)localObject3).moveToNext();
          } while (bool1);
        }
        ((Cursor)localObject3).close();
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("MicroMsg.AppBrand.PkgCleanupNewLogic", localException2, "getWxaPkgDescIndexedStorage", new Object[0]);
          ((Cursor)localObject3).close();
        }
      }
      finally
      {
        ((Cursor)localObject3).close();
        AppMethodBeat.o(275426);
      }
      localObject6 = ((List)localObject6).iterator();
      while (((Iterator)localObject6).hasNext())
      {
        localObject7 = (bi)((Iterator)localObject6).next();
        com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.AppBrand.PkgCleanupNewLogic", "processPluginDebug pkgRecord provider:%s", new Object[] { ((bi)localObject7).field_appId });
        localObject3 = ((List)localObject4).iterator();
        for (int i = 0; ((Iterator)localObject3).hasNext(); i = 1)
        {
          label495:
          WxaAttributes.WxaPluginCodeInfo localWxaPluginCodeInfo = (WxaAttributes.WxaPluginCodeInfo)((Iterator)localObject3).next();
          if ((Util.isNullOrNil(((bi)localObject7).field_appId)) || (Util.isNullOrNil(localWxaPluginCodeInfo.provider)) || (Util.isNullOrNil(((bi)localObject7).field_versionDesc)) || (Util.isNullOrNil(localWxaPluginCodeInfo.nGm)) || (!((bi)localObject7).field_appId.equals(new ae(localWxaPluginCodeInfo.provider, "", 6).toString())) || (!((bi)localObject7).field_versionDesc.equals(localWxaPluginCodeInfo.nGm))) {
            break label495;
          }
        }
        if (i == 0)
        {
          n.a.acC(localException2.field_pkgPath);
          bool1 = m.bFQ().delete(localException2, new String[0]);
          if ((Util.isNullOrNil(localException2.field_appId)) || (!localException2.field_appId.contains("$"))) {
            break label787;
          }
        }
      }
      label787:
      for (localObject3 = localException2.field_appId.split(Pattern.quote("$"))[0];; localObject3 = "")
      {
        boolean bool2 = ((ar)m.W(ar.class)).ew((String)localObject3, localException2.field_versionDesc);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processPluginDebug no need keep dev plugin provider:%s,pkgPath:%s,deletePkgRecord:%b,deletePluginContactRecord:%b", new Object[] { localObject3, localException2.field_pkgPath, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        break;
        AppMethodBeat.o(275426);
        return;
      }
    }
    
    /* Error */
    private static void bb(List<String> paramList)
    {
      // Byte code:
      //   0: ldc_w 659
      //   3: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   6: aload_0
      //   7: invokestatic 662	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/util/List;)Z
      //   10: ifeq +10 -> 20
      //   13: ldc_w 659
      //   16: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   19: return
      //   20: new 664	java/util/HashSet
      //   23: dup
      //   24: aload_0
      //   25: invokespecial 667	java/util/HashSet:<init>	(Ljava/util/Collection;)V
      //   28: astore_0
      //   29: invokestatic 673	com/tencent/mm/plugin/appbrand/appcache/predownload/export/c:bIc	()Lcom/tencent/mm/plugin/appbrand/appcache/predownload/export/c;
      //   32: invokevirtual 676	com/tencent/mm/plugin/appbrand/appcache/predownload/export/c:bIb	()Ljava/util/List;
      //   35: astore 7
      //   37: aload 7
      //   39: invokeinterface 679 1 0
      //   44: ifne +136 -> 180
      //   47: aload 7
      //   49: invokeinterface 228 1 0
      //   54: astore 7
      //   56: aload 7
      //   58: invokeinterface 83 1 0
      //   63: ifeq +117 -> 180
      //   66: aload 7
      //   68: invokeinterface 87 1 0
      //   73: checkcast 262	com/tencent/mm/plugin/appbrand/appcache/predownload/export/c$b
      //   76: astore 8
      //   78: aload_0
      //   79: aload 8
      //   81: getfield 271	com/tencent/mm/plugin/appbrand/appcache/predownload/export/c$b:appId	Ljava/lang/String;
      //   84: invokevirtual 682	java/util/HashSet:remove	(Ljava/lang/Object;)Z
      //   87: pop
      //   88: invokestatic 159	com/tencent/mm/plugin/appbrand/app/m:bFP	()Lcom/tencent/mm/plugin/appbrand/appcache/bm;
      //   91: aload 8
      //   93: getfield 271	com/tencent/mm/plugin/appbrand/appcache/predownload/export/c$b:appId	Ljava/lang/String;
      //   96: aload 8
      //   98: getfield 274	com/tencent/mm/plugin/appbrand/appcache/predownload/export/c$b:cBU	I
      //   101: aload 8
      //   103: getfield 277	com/tencent/mm/plugin/appbrand/appcache/predownload/export/c$b:version	I
      //   106: invokevirtual 169	com/tencent/mm/plugin/appbrand/appcache/bm:E	(Ljava/lang/String;II)I
      //   109: istore_1
      //   110: invokestatic 159	com/tencent/mm/plugin/appbrand/app/m:bFP	()Lcom/tencent/mm/plugin/appbrand/appcache/bm;
      //   113: aload 8
      //   115: getfield 271	com/tencent/mm/plugin/appbrand/appcache/predownload/export/c$b:appId	Ljava/lang/String;
      //   118: aload 8
      //   120: getfield 274	com/tencent/mm/plugin/appbrand/appcache/predownload/export/c$b:cBU	I
      //   123: aload 8
      //   125: getfield 277	com/tencent/mm/plugin/appbrand/appcache/predownload/export/c$b:version	I
      //   128: invokevirtual 280	com/tencent/mm/plugin/appbrand/appcache/bm:F	(Ljava/lang/String;II)I
      //   131: istore_2
      //   132: ldc 126
      //   134: ldc_w 282
      //   137: iconst_4
      //   138: anewarray 4	java/lang/Object
      //   141: dup
      //   142: iconst_0
      //   143: aload 8
      //   145: getfield 271	com/tencent/mm/plugin/appbrand/appcache/predownload/export/c$b:appId	Ljava/lang/String;
      //   148: aastore
      //   149: dup
      //   150: iconst_1
      //   151: aload 8
      //   153: getfield 277	com/tencent/mm/plugin/appbrand/appcache/predownload/export/c$b:version	I
      //   156: invokestatic 99	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   159: aastore
      //   160: dup
      //   161: iconst_2
      //   162: iload_1
      //   163: invokestatic 99	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   166: aastore
      //   167: dup
      //   168: iconst_3
      //   169: iload_2
      //   170: invokestatic 99	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   173: aastore
      //   174: invokestatic 133	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   177: goto -121 -> 56
      //   180: invokestatic 359	com/tencent/mm/sdk/platformtools/Util:nowSecond	()J
      //   183: lstore_3
      //   184: invokestatic 365	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:bLe	()Lcom/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig;
      //   187: getfield 369	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:nXt	Lcom/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig$PackageManager;
      //   190: getfield 374	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig$PackageManager:nXP	J
      //   193: lstore 5
      //   195: aload_0
      //   196: invokevirtual 683	java/util/HashSet:iterator	()Ljava/util/Iterator;
      //   199: astore_0
      //   200: aload_0
      //   201: invokeinterface 83 1 0
      //   206: ifeq +200 -> 406
      //   209: aload_0
      //   210: invokeinterface 87 1 0
      //   215: checkcast 190	java/lang/String
      //   218: astore 7
      //   220: aload 7
      //   222: invokestatic 250	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
      //   225: ifne +14 -> 239
      //   228: aload 7
      //   230: ldc_w 685
      //   233: invokevirtual 688	java/lang/String:endsWith	(Ljava/lang/String;)Z
      //   236: ifne -36 -> 200
      //   239: aload 7
      //   241: iconst_0
      //   242: invokestatic 124	com/tencent/mm/plugin/appbrand/launching/l:cq	(Ljava/lang/String;I)Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo;
      //   245: astore 8
      //   247: aload 8
      //   249: ifnonnull +39 -> 288
      //   252: new 690	java/lang/StringBuilder
      //   255: dup
      //   256: invokespecial 691	java/lang/StringBuilder:<init>	()V
      //   259: aload 7
      //   261: invokevirtual 695	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   264: bipush 36
      //   266: invokevirtual 698	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
      //   269: ldc_w 700
      //   272: invokevirtual 695	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   275: invokevirtual 701	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   278: iconst_0
      //   279: invokestatic 124	com/tencent/mm/plugin/appbrand/launching/l:cq	(Ljava/lang/String;I)Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo;
      //   282: ifnonnull -82 -> 200
      //   285: goto -85 -> 200
      //   288: getstatic 399	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
      //   291: new 401	com/tencent/mm/vfs/q
      //   294: dup
      //   295: aload 8
      //   297: getfield 703	com/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo:pkgPath	Ljava/lang/String;
      //   300: invokespecial 404	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
      //   303: invokevirtual 407	com/tencent/mm/vfs/q:lastModified	()J
      //   306: invokevirtual 411	java/util/concurrent/TimeUnit:toSeconds	(J)J
      //   309: lload_3
      //   310: lload 5
      //   312: lsub
      //   313: lcmp
      //   314: ifge -114 -> 200
      //   317: ldc 126
      //   319: ldc_w 705
      //   322: iconst_2
      //   323: anewarray 4	java/lang/Object
      //   326: dup
      //   327: iconst_0
      //   328: aload 7
      //   330: aastore
      //   331: dup
      //   332: iconst_1
      //   333: aload 8
      //   335: getfield 186	com/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo:pkgVersion	I
      //   338: invokestatic 99	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   341: aastore
      //   342: invokestatic 133	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   345: invokestatic 159	com/tencent/mm/plugin/appbrand/app/m:bFP	()Lcom/tencent/mm/plugin/appbrand/appcache/bm;
      //   348: aload 7
      //   350: iconst_0
      //   351: aload 8
      //   353: getfield 186	com/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo:pkgVersion	I
      //   356: invokevirtual 169	com/tencent/mm/plugin/appbrand/appcache/bm:E	(Ljava/lang/String;II)I
      //   359: pop
      //   360: invokestatic 159	com/tencent/mm/plugin/appbrand/app/m:bFP	()Lcom/tencent/mm/plugin/appbrand/appcache/bm;
      //   363: aload 7
      //   365: iconst_0
      //   366: aload 8
      //   368: getfield 186	com/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo:pkgVersion	I
      //   371: invokevirtual 280	com/tencent/mm/plugin/appbrand/appcache/bm:F	(Ljava/lang/String;II)I
      //   374: pop
      //   375: ldc_w 327
      //   378: invokestatic 331	com/tencent/mm/plugin/appbrand/app/m:W	(Ljava/lang/Class;)Ljava/lang/Object;
      //   381: checkcast 327	com/tencent/mm/plugin/appbrand/ui/c/a/b
      //   384: aload 7
      //   386: iconst_0
      //   387: new 333	com/tencent/mm/plugin/appbrand/ui/c/a/b$b$c
      //   390: dup
      //   391: aload 8
      //   393: getfield 186	com/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo:pkgVersion	I
      //   396: invokespecial 334	com/tencent/mm/plugin/appbrand/ui/c/a/b$b$c:<init>	(I)V
      //   399: invokevirtual 337	com/tencent/mm/plugin/appbrand/ui/c/a/b:a	(Ljava/lang/String;ILcom/tencent/mm/plugin/appbrand/ui/c/a/b$b;)I
      //   402: pop
      //   403: goto -203 -> 200
      //   406: ldc_w 659
      //   409: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   412: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	413	0	paramList	List<String>
      //   109	54	1	i	int
      //   131	39	2	j	int
      //   183	127	3	l1	long
      //   193	118	5	l2	long
      //   35	350	7	localObject1	Object
      //   76	316	8	localObject2	Object
    }
    
    public final void run()
    {
      AppMethodBeat.i(44250);
      if (m.bFP() == null)
      {
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrand.PkgCleanupNewLogic", "run() entered but storage not ready");
        AppMethodBeat.o(44250);
        return;
      }
      this.nEs.set(false);
      long l3;
      long l1;
      label328:
      label600:
      for (;;)
      {
        Object localObject3;
        try
        {
          com.tencent.mm.plugin.report.service.h.IzE.el(1007, 1);
          l3 = Util.currentTicks();
        }
        catch (Throwable localThrowable1)
        {
          try
          {
            bm localbm = m.bFP();
            localObject3 = new StringBuilder("debugType");
            ((StringBuilder)localObject3).append(" in (");
            localObject4 = j.nEl;
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
            localObject3 = localThrowable1.nHI.query("AppBrandWxaPkgManifestRecord", null, (String)localObject3, null, null, null, null, 2);
            if (localObject3 != null) {
              break label328;
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
              break label351;
            }
            ((Cursor)localObject3).close();
            ArrayList localArrayList = null;
            continue;
            localArrayList = new ArrayList();
            do
            {
              localObject4 = new bh();
              ((bh)localObject4).convertFrom((Cursor)localObject3);
              localArrayList.add(localObject4);
            } while (((Cursor)localObject3).moveToNext());
            ((Cursor)localObject3).close();
            continue;
          }
          catch (Throwable localThrowable2)
          {
            com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrand.PkgCleanupNewLogic", "process occur exception %s", new Object[] { localThrowable2 });
            return;
            bGy();
            if ((((bh)localObject3).field_endTime <= 0L) || (((bh)localObject3).field_endTime > l1)) {
              break label600;
            }
            if (((bh)localObject3).field_debugType != 999) {
              continue;
            }
            n.a.acC(((bh)localObject3).field_pkgPath);
            m.bFP().c((bh)localObject3);
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processDebug, (%s, %d) exceed time range[%d, %d]", new Object[] { ((bh)localObject3).field_appId, Integer.valueOf(((bh)localObject3).field_debugType), Long.valueOf(((bh)localObject3).field_startTime), Long.valueOf(((bh)localObject3).field_endTime) });
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
          bGy();
          l1 = Util.nowSecond();
          localObject1 = ((List)localObject1).iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject3 = (bh)((Iterator)localObject1).next();
          if (i.cjb().eh(((bh)localObject3).field_appId))
          {
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processDebug appID(%s) is running, skip", new Object[] { ((bh)localObject3).field_appId });
            continue;
          }
        }
        label351:
        if (((bh)localObject3).field_debugType == 999) {
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processDebug, debug library not exceed time range[%d %d]", new Object[] { Long.valueOf(((bh)localObject3).field_startTime), Long.valueOf(((bh)localObject3).field_endTime) });
        }
      }
      bGz();
      bGA();
      bGB();
      bGC();
      bGD();
      bGy();
      StatFs localStatFs = new StatFs(bc.bHt());
      long l4;
      long l2;
      label717:
      double d1;
      double d2;
      if (Build.VERSION.SDK_INT >= 18)
      {
        l1 = localStatFs.getBlockCountLong();
        l4 = n.b.bGw();
        if (Build.VERSION.SDK_INT < 18) {
          break label950;
        }
        l2 = localStatFs.getBlockSizeLong();
        d1 = l4 / l2 / l1;
        d2 = AppBrandGlobalSystemConfig.bLe().nXt.nXR / 100.0F;
        if ((d1 <= d2) || (l4 <= AppBrandGlobalSystemConfig.bLe().nXt.nXQ * 1048576L)) {
          break label1017;
        }
      }
      label880:
      label1017:
      for (boolean bool = true;; bool = false)
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processByFilesystemUsage, usedPercent(%f), maxPercent(%f), usedBytes(%d), maxMB(%d), shouldCleanup=%B", new Object[] { Double.valueOf(d1), Double.valueOf(d2), Long.valueOf(l4), Long.valueOf(AppBrandGlobalSystemConfig.bLe().nXt.nXQ), Boolean.valueOf(bool) });
        if (bool)
        {
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processByFilesystemUsage, cleanup by conditions usedPercent(%f) > maxPercent(%f)", new Object[] { Double.valueOf(d1), Double.valueOf(d2) });
          double d3 = l1;
          if (Build.VERSION.SDK_INT < 18) {
            break label961;
          }
          l1 = localStatFs.getBlockSizeLong();
          l1 = (l1 * (d3 * (d1 - d2)));
          if (l1 >= 0L) {
            break label972;
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
          break label717;
          l1 = localStatFs.getBlockSize();
          break label880;
          bGy();
          ad.a(l1, new ad.a()
          {
            public final boolean bBN()
            {
              AppMethodBeat.i(44247);
              boolean bool = n.d.a(n.d.this).get();
              AppMethodBeat.o(44247);
              return bool;
            }
          });
          if (w.bGN()) {
            al.a(l1 / 5L, new al.a()
            {
              public final boolean bBN()
              {
                AppMethodBeat.i(280510);
                boolean bool = n.d.a(n.d.this).get();
                AppMethodBeat.o(280510);
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
    public static int bGE()
    {
      AppMethodBeat.i(44255);
      HashSet localHashSet = new HashSet();
      Object localObject = "select distinct appId from AppBrandWxaPkgManifestRecord where  ( appId not like '%%$%%' or appId like " + String.format(Locale.US, "'%%$%s'", new Object[] { "__APP__" }) + " )  and  ( pkgPath is not null  and pkgPath != ''  ) ";
      Cursor localCursor = m.bFB().rawQuery((String)localObject, null, 2);
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
      localObject = m.bFB().rawQuery("select distinct appId from PredownloadEncryptPkgInfo where pkgPath is not null  and pkgPath != '' ", null, 2);
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