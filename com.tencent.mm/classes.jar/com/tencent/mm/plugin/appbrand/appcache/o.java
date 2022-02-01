package com.tencent.mm.plugin.appbrand.appcache;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.si;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.predownload.export.c.b;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig.PackageManager;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaPluginCodeInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.aa;
import com.tencent.mm.plugin.appbrand.config.aj;
import com.tencent.mm.plugin.appbrand.launching.at;
import com.tencent.mm.plugin.appbrand.launching.m;
import com.tencent.mm.plugin.appbrand.launching.r;
import com.tencent.mm.plugin.appbrand.page.bl;
import com.tencent.mm.plugin.appbrand.page.bl.a;
import com.tencent.mm.plugin.appbrand.task.d;
import com.tencent.mm.plugin.appbrand.ui.b.a.b;
import com.tencent.mm.plugin.appbrand.ui.b.a.b.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabaseEx;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.w;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;
import kotlin.a.p;
import org.apache.commons.c.a;

public abstract interface o
  extends Runnable
{
  public static final class c
  {
    public static long cfW()
    {
      AppMethodBeat.i(44241);
      long l = com.tencent.mm.plugin.appbrand.appstorage.t.q(new u(bd.cgP()));
      AppMethodBeat.o(44241);
      return l;
    }
  }
  
  public static final class d
  {
    private static final o.f qEm;
    
    static
    {
      AppMethodBeat.i(44244);
      qEm = new o.f();
      AppMethodBeat.o(44244);
    }
    
    public static o cfX()
    {
      AppMethodBeat.i(44242);
      o.f localf = qEm;
      AppMethodBeat.o(44242);
      return localf;
    }
    
    public static void interrupt()
    {
      AppMethodBeat.i(44243);
      o.f localf = qEm;
      try
      {
        com.tencent.mm.plugin.report.service.h.OAn.kJ(1007, 2);
        localf.qEn.set(true);
        AppMethodBeat.o(44243);
        return;
      }
      finally
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.AppBrand.PkgCleanupNewLogic", localThrowable, "cleanup interrupted report", new Object[0]);
        }
      }
    }
  }
  
  public static abstract interface e
  {
    public abstract List<o.a> cfY();
  }
  
  public static final class f
    implements o
  {
    final AtomicBoolean qEn;
    private final List<o.e> qEo;
    
    public f()
    {
      AppMethodBeat.i(44248);
      this.qEn = new AtomicBoolean();
      this.qEo = new CopyOnWriteArrayList();
      AppMethodBeat.o(44248);
    }
    
    private void cH(List<o.a> paramList)
    {
      Object localObject1 = null;
      AppMethodBeat.i(320351);
      Object localObject2 = n.cfm();
      Object localObject3 = new StringBuilder("debugType");
      ((StringBuilder)localObject3).append(" in (");
      int[] arrayOfInt = k.qEg;
      int j = arrayOfInt.length;
      int i = 0;
      while (i < j)
      {
        ((StringBuilder)localObject3).append(arrayOfInt[i]).append(',');
        i += 1;
      }
      ((StringBuilder)localObject3).append(-1).append(')');
      localObject3 = ((StringBuilder)localObject3).toString();
      localObject2 = ((bm)localObject2).qHv.query("AppBrandWxaPkgManifestRecord", null, (String)localObject3, null, null, null, null, 2);
      if (localObject2 == null) {}
      while (Util.isNullOrNil((List)localObject1))
      {
        AppMethodBeat.o(320351);
        return;
        if (!((Cursor)localObject2).moveToFirst())
        {
          ((Cursor)localObject2).close();
        }
        else
        {
          localObject1 = new ArrayList();
          do
          {
            localObject3 = new bh();
            ((bh)localObject3).convertFrom((Cursor)localObject2);
            ((List)localObject1).add(localObject3);
          } while (((Cursor)localObject2).moveToNext());
          ((Cursor)localObject2).close();
        }
      }
      cfZ();
      long l = Util.nowSecond();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (bh)((Iterator)localObject1).next();
        if (com.tencent.mm.plugin.appbrand.task.i.cJV().fA(((bh)localObject2).field_appId))
        {
          Log.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processDebug appID(%s) is running, skip", new Object[] { ((bh)localObject2).field_appId });
        }
        else
        {
          localObject3 = new o.a(((bh)localObject2).field_appId, ((bh)localObject2).field_debugType);
          if (paramList.contains(localObject3))
          {
            Log.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processDebug appPkg: %s is in white list, skip", new Object[] { localObject3 });
          }
          else
          {
            cfZ();
            if ((((bh)localObject2).field_endTime > 0L) && (((bh)localObject2).field_endTime <= l))
            {
              if (((bh)localObject2).field_debugType == 999)
              {
                o.b.Vb(((bh)localObject2).field_pkgPath);
                n.cfm().c((bh)localObject2);
                Log.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processDebug, (%s, %d) exceed time range[%d, %d]", new Object[] { ((bh)localObject2).field_appId, Integer.valueOf(((bh)localObject2).field_debugType), Long.valueOf(((bh)localObject2).field_startTime), Long.valueOf(((bh)localObject2).field_endTime) });
              }
            }
            else if (((bh)localObject2).field_debugType == 999) {
              Log.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processDebug, debug library not exceed time range[%d %d]", new Object[] { Long.valueOf(((bh)localObject2).field_startTime), Long.valueOf(((bh)localObject2).field_endTime) });
            }
          }
        }
      }
      AppMethodBeat.o(320351);
    }
    
    private void cI(List<o.a> paramList)
    {
      AppMethodBeat.i(320364);
      cfZ();
      Object localObject1 = n.ceY();
      Object localObject3 = (Iterable)com.tencent.mm.plugin.appbrand.task.i.cJV().asg();
      Object localObject2 = (Collection)new ArrayList(p.a((Iterable)localObject3, 10));
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((Collection)localObject2).add(Integer.valueOf(((d)((Iterator)localObject3).next()).tVP));
      }
      localObject2 = p.I((Collection)localObject2);
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
        localObject2 = m.cQ("@LibraryAppId", 0);
        if (localObject2 == null) {
          i = 0;
        }
      }
      for (;;)
      {
        if (i > 0)
        {
          Log.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processRelease, library.minValidVersion = %d", new Object[] { Integer.valueOf(i) });
          j = i - Math.max(0, ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yOU, 3) - 1);
          Log.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processRelease, delete libraries record < %d", new Object[] { Integer.valueOf(j) });
          localObject2 = n.cfm().Vz("@LibraryAppId");
          n.cfm().I("@LibraryAppId", 0, j);
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
                  y.ew(bl.CL(m), true);
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
          AppMethodBeat.o(320364);
          return;
        }
        localObject3 = new LinkedList();
        if (((Cursor)localObject1).moveToFirst())
        {
          localObject2 = ((Cursor)localObject1).getString(0);
          if (com.tencent.mm.plugin.appbrand.task.i.cJV().fA((String)localObject2))
          {
            Log.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processRelease appID(%s) is running, skip", new Object[] { localObject2 });
            label433:
            if (((Cursor)localObject1).moveToNext()) {
              break label564;
            }
          }
        }
        else
        {
          ((Cursor)localObject1).close();
          localObject1 = new LinkedList();
          cfZ();
          localObject2 = new HashMap() {};
          localObject3 = ((List)localObject3).iterator();
        }
        for (;;)
        {
          if (!((Iterator)localObject3).hasNext()) {
            break label1005;
          }
          Object localObject4 = (String)((Iterator)localObject3).next();
          Object localObject5 = n.cfc().e((String)localObject4, new String[] { "versionInfo" });
          if ((localObject5 == null) || (Util.isNullOrNil(((WxaAttributes)localObject5).field_versionInfo)))
          {
            ((List)localObject1).add(localObject4);
            continue;
            ((List)localObject3).add(localObject2);
            break label433;
            label564:
            break;
          }
          cfZ();
          if (((Map)localObject2).containsKey(localObject4))
          {
            localObject4 = (c.b)((Map)localObject2).get(localObject4);
            if (localObject4 == null)
            {
              Log.e("MicroMsg.AppBrand.PkgCleanupNewLogic", "processReleaseContact, pkg is null!");
            }
            else
            {
              i = n.cfm().I(((c.b)localObject4).appId, ((c.b)localObject4).euz, ((c.b)localObject4).version);
              j = n.cfm().J(((c.b)localObject4).appId, ((c.b)localObject4).euz, ((c.b)localObject4).version);
              Log.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processReleaseContact, for export occupied, delete record(%s) < %d, deleting pkgCount: %d, moduleCount: %d", new Object[] { ((c.b)localObject4).appId, Integer.valueOf(((c.b)localObject4).version), Integer.valueOf(i), Integer.valueOf(j) });
            }
          }
          else
          {
            Object localObject6 = new o.a((String)localObject4, 0);
            if (paramList.contains(localObject6))
            {
              Log.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processReleaseContact appPkg: %s is in white list, skip", new Object[] { localObject6 });
            }
            else
            {
              if (((WxaAttributes)localObject5).clf() == null) {}
              for (i = 0; i > 0; i = ((WxaAttributes)localObject5).clf().appVersion)
              {
                localObject5 = n.cfm().Vy((String)localObject4);
                j = n.cfm().I((String)localObject4, 0, i);
                if (j <= 0) {
                  break label935;
                }
                Log.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processRelease, delete record(%s) < %d, count(%d)", new Object[] { localObject4, Integer.valueOf(i), Integer.valueOf(j) });
                localObject6 = new si();
                ((si)localObject6).jxW = 2L;
                localObject6 = ((si)localObject6).yW((String)localObject4);
                ((si)localObject6).jxX = 0L;
                ((si)localObject6).jxY = j;
                ((si)localObject6).jxU = 1L;
                ((si)localObject6).bMH();
                if ((localObject5 == null) || (localObject5.length <= 0)) {
                  break label935;
                }
                k = localObject5.length;
                j = 0;
                while (j < k)
                {
                  m = localObject5[j];
                  if (m < i) {
                    y.ew(bl.cY((String)localObject4, m), true);
                  }
                  j += 1;
                }
              }
              continue;
              label935:
              n.cfm().J((String)localObject4, 0, i);
              ((b)n.ag(b.class)).a((String)localObject4, 0, new b.b.c(i));
              ((bw)n.ag(bw.class)).bK((String)localObject4, i);
              ((aa)n.ag(aa.class)).cq((String)localObject4, i);
            }
          }
        }
        label1005:
        l((List)localObject1, paramList);
        AppMethodBeat.o(320364);
        return;
      }
    }
    
    private void cJ(List<o.a> paramList)
    {
      AppMethodBeat.i(320369);
      cfZ();
      long l1 = Util.nowSecond();
      long l2 = AppBrandGlobalSystemConfig.ckD().qXj.qXJ;
      Object localObject1 = ((ap)n.ag(ap.class)).getAll();
      if ((localObject1 == null) || (((Cursor)localObject1).isClosed()))
      {
        AppMethodBeat.o(320369);
        return;
      }
      Object localObject2 = new LinkedList();
      Object localObject3;
      if (((Cursor)localObject1).moveToFirst()) {
        do
        {
          localObject3 = new ao();
          ((ao)localObject3).convertFrom((Cursor)localObject1);
          ((List)localObject2).add(localObject3);
        } while (((Cursor)localObject1).moveToNext());
      }
      ((Cursor)localObject1).close();
      cfZ();
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ao)((Iterator)localObject1).next();
        if (y.ZC(((ao)localObject2).field_pkgPath))
        {
          localObject3 = new o.a(((ao)localObject2).field_appId, 0);
          if (paramList.contains(localObject3))
          {
            Log.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processEncrypted appPkg: %s is in white list, skip", new Object[] { localObject3 });
          }
          else
          {
            cfZ();
            if (TimeUnit.MILLISECONDS.toSeconds(new u(((ao)localObject2).field_pkgPath).lastModified()) < l1 - l2)
            {
              Log.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processEncrypted, delete record(%s %d %d)", new Object[] { ((ao)localObject2).field_appId, Integer.valueOf(((ao)localObject2).field_type), Integer.valueOf(((ao)localObject2).field_version) });
              ((ap)n.ag(ap.class)).delete((IAutoDBItem)localObject2, new String[0]);
              y.ew(((ao)localObject2).field_pkgPath, true);
            }
          }
        }
      }
      AppMethodBeat.o(320369);
    }
    
    private void cfZ()
    {
      AppMethodBeat.i(44249);
      if (this.qEn.get())
      {
        InterruptedException localInterruptedException = new InterruptedException();
        AppMethodBeat.o(44249);
        throw localInterruptedException;
      }
      AppMethodBeat.o(44249);
    }
    
    private static void cga()
    {
      AppMethodBeat.i(320359);
      Object localObject1 = new LinkedList();
      Object localObject4 = ((com.tencent.mm.plugin.appbrand.launching.t)n.ag(com.tencent.mm.plugin.appbrand.launching.t.class)).getAll();
      if ((localObject4 == null) || (((Cursor)localObject4).isClosed()))
      {
        AppMethodBeat.o(320359);
        return;
      }
      boolean bool1;
      try
      {
        if (((Cursor)localObject4).moveToFirst()) {
          do
          {
            localr = new r();
            localr.convertFrom((Cursor)localObject4);
            ((List)localObject1).add(localr);
            bool1 = ((Cursor)localObject4).moveToNext();
          } while (bool1);
        }
        ((Cursor)localObject4).close();
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          r localr;
          Log.printErrStackTrace("MicroMsg.AppBrand.PkgCleanupNewLogic", localException1, "getDevPkgLaunchExtInfoStorage", new Object[0]);
          ((Cursor)localObject4).close();
        }
      }
      finally
      {
        ((Cursor)localObject4).close();
        AppMethodBeat.o(320359);
      }
      localObject4 = new LinkedList();
      localObject1 = ((List)localObject1).iterator();
      Object localObject7;
      while (((Iterator)localObject1).hasNext())
      {
        localr = (r)((Iterator)localObject1).next();
        localObject7 = localr.field_extJson;
        if ((Util.isNullOrNil((String)localObject7)) || ((!Util.isNullOrNil((String)localObject7)) && (((String)localObject7).equals("{}"))))
        {
          Log.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processPluginDebug appID(%s) extJson null", new Object[] { localr.field_appId });
        }
        else
        {
          localObject6 = ((WxaAttributes.WxaVersionInfo)Objects.requireNonNull(aj.Ya((String)localObject7))).rco;
          if ((localObject6 != null) && (((List)localObject6).size() > 0))
          {
            localObject6 = ((List)localObject6).iterator();
            while (((Iterator)localObject6).hasNext())
            {
              localObject7 = (WxaAttributes.WxaPluginCodeInfo)((Iterator)localObject6).next();
              if (!Util.isNullOrNil(((WxaAttributes.WxaPluginCodeInfo)localObject7).qGf))
              {
                ((List)localObject4).add(localObject7);
                Log.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processPluginDebug needKeep provider:%s,versionDesc:%s", new Object[] { ((WxaAttributes.WxaPluginCodeInfo)localObject7).provider, ((WxaAttributes.WxaPluginCodeInfo)localObject7).qGf });
              }
            }
          }
        }
      }
      Object localObject6 = new LinkedList();
      Object localObject3 = n.cfn().getAll();
      if ((localObject3 == null) || (((Cursor)localObject3).isClosed()))
      {
        AppMethodBeat.o(320359);
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
          Log.printErrStackTrace("MicroMsg.AppBrand.PkgCleanupNewLogic", localException2, "getWxaPkgDescIndexedStorage", new Object[0]);
          ((Cursor)localObject3).close();
        }
      }
      finally
      {
        ((Cursor)localObject3).close();
        AppMethodBeat.o(320359);
      }
      localObject6 = ((List)localObject6).iterator();
      while (((Iterator)localObject6).hasNext())
      {
        localObject7 = (bi)((Iterator)localObject6).next();
        Log.d("MicroMsg.AppBrand.PkgCleanupNewLogic", "processPluginDebug pkgRecord provider:%s", new Object[] { ((bi)localObject7).field_appId });
        localObject3 = ((List)localObject4).iterator();
        for (int i = 0; ((Iterator)localObject3).hasNext(); i = 1)
        {
          label501:
          WxaAttributes.WxaPluginCodeInfo localWxaPluginCodeInfo = (WxaAttributes.WxaPluginCodeInfo)((Iterator)localObject3).next();
          if ((Util.isNullOrNil(((bi)localObject7).field_appId)) || (Util.isNullOrNil(localWxaPluginCodeInfo.provider)) || (Util.isNullOrNil(((bi)localObject7).field_versionDesc)) || (Util.isNullOrNil(localWxaPluginCodeInfo.qGf)) || (!((bi)localObject7).field_appId.equals(new af(localWxaPluginCodeInfo.provider, "", 6).toString())) || (!((bi)localObject7).field_versionDesc.equals(localWxaPluginCodeInfo.qGf))) {
            break label501;
          }
        }
        if (i == 0)
        {
          o.b.Vb(localException2.field_pkgPath);
          bool1 = n.cfn().delete(localException2, new String[0]);
          if ((Util.isNullOrNil(localException2.field_appId)) || (!localException2.field_appId.contains("$"))) {
            break label793;
          }
        }
      }
      label793:
      for (localObject3 = localException2.field_appId.split(Pattern.quote("$"))[0];; localObject3 = "")
      {
        boolean bool2 = ((at)n.ag(at.class)).eO((String)localObject3, localException2.field_versionDesc);
        Log.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processPluginDebug no need keep dev plugin provider:%s,pkgPath:%s,deletePkgRecord:%b,deletePluginContactRecord:%b", new Object[] { localObject3, localException2.field_pkgPath, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        break;
        AppMethodBeat.o(320359);
        return;
      }
    }
    
    private void cgb()
    {
      AppMethodBeat.i(44253);
      Object localObject1 = new u(bd.cgP());
      if ((!((u)localObject1).jKS()) || (!((u)localObject1).isDirectory()))
      {
        AppMethodBeat.o(44253);
        return;
      }
      localObject1 = ((u)localObject1).a(new w()
      {
        public final boolean accept(u paramAnonymousu)
        {
          AppMethodBeat.i(320378);
          boolean bool = paramAnonymousu.jKV();
          AppMethodBeat.o(320378);
          return bool;
        }
      });
      int j = localObject1.length;
      int i = 0;
      if (i < j)
      {
        Object localObject2 = localObject1[i];
        Object localObject4 = n.cfm();
        Object localObject3 = ah.v(localObject2.jKT());
        localObject4 = ((bm)localObject4).qHv;
        String str = String.format("%s=?", new Object[] { "pkgPath" });
        localObject3 = ((ISQLiteDatabaseEx)localObject4).query("AppBrandWxaPkgManifestRecord", new String[] { "appId" }, str, new String[] { localObject3 }, null, null, null, 2);
        boolean bool;
        if (localObject3 == null) {
          bool = false;
        }
        for (;;)
        {
          if (!bool) {
            o.b.Vb(ah.v(localObject2.jKT()));
          }
          i += 1;
          break;
          bool = ((Cursor)localObject3).moveToFirst();
          ((Cursor)localObject3).close();
        }
      }
      AppMethodBeat.o(44253);
    }
    
    private static void cgc()
    {
      AppMethodBeat.i(44254);
      Object localObject1 = bl.tAb;
      localObject1 = new u(bl.a.apo());
      if ((!((u)localObject1).jKS()) || (!((u)localObject1).isDirectory()))
      {
        ((u)localObject1).diJ();
        AppMethodBeat.o(44254);
        return;
      }
      u[] arrayOfu = ((u)localObject1).jKX();
      if ((arrayOfu == null) || (arrayOfu.length == 0))
      {
        ((u)localObject1).diJ();
        AppMethodBeat.o(44254);
        return;
      }
      HashMap localHashMap = new HashMap();
      int j = arrayOfu.length;
      int i = 0;
      u localu;
      Object localObject2;
      while (i < j)
      {
        localu = arrayOfu[i];
        localObject1 = localu.getName().split(Pattern.quote("-"));
        if ((localObject1 == null) || (localObject1.length < 2))
        {
          y.deleteFile(ah.v(localu.jKT()));
          y.ew(ah.v(localu.jKT()), true);
          i += 1;
        }
        else
        {
          localObject2 = localObject1[0];
          if (!"LIB".equals(localObject2)) {
            break label340;
          }
          localObject2 = "@LibraryAppId";
        }
      }
      label340:
      for (;;)
      {
        int k = Util.getInt(org.apache.commons.c.i.jZ(localObject1[1], 1), 0);
        int[] arrayOfInt = (int[])localHashMap.get(localObject2);
        localObject1 = arrayOfInt;
        if (arrayOfInt == null)
        {
          arrayOfInt = n.cfm().Vy((String)localObject2);
          localObject1 = arrayOfInt;
          if (arrayOfInt == null)
          {
            localObject1 = new int[1];
            localObject1[0] = 0;
          }
          Log.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processExpiredWebViewCodeCache, select_versionArray(%s), get(%s)", new Object[] { localObject2, a.w(localObject1, "-1") });
          localHashMap.put(localObject2, localObject1);
        }
        if (a.contains((int[])localObject1, k)) {
          break;
        }
        y.deleteFile(ah.v(localu.jKT()));
        y.ew(ah.v(localu.jKT()), true);
        Log.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processExpiredWebViewCodeCache, file(%s) deleted", new Object[] { ah.v(localu.jKT()) });
        break;
        AppMethodBeat.o(44254);
        return;
      }
    }
    
    /* Error */
    private static void l(List<String> paramList, List<o.a> paramList1)
    {
      // Byte code:
      //   0: ldc_w 747
      //   3: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   6: aload_0
      //   7: invokestatic 105	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/util/List;)Z
      //   10: ifeq +10 -> 20
      //   13: ldc_w 747
      //   16: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   19: return
      //   20: new 749	java/util/HashSet
      //   23: dup
      //   24: aload_0
      //   25: invokespecial 752	java/util/HashSet:<init>	(Ljava/util/Collection;)V
      //   28: astore_0
      //   29: invokestatic 758	com/tencent/mm/plugin/appbrand/appcache/predownload/export/c:chy	()Lcom/tencent/mm/plugin/appbrand/appcache/predownload/export/c;
      //   32: invokevirtual 761	com/tencent/mm/plugin/appbrand/appcache/predownload/export/c:chx	()Ljava/util/List;
      //   35: astore 8
      //   37: aload 8
      //   39: invokeinterface 764 1 0
      //   44: ifne +136 -> 180
      //   47: aload 8
      //   49: invokeinterface 144 1 0
      //   54: astore 8
      //   56: aload 8
      //   58: invokeinterface 149 1 0
      //   63: ifeq +117 -> 180
      //   66: aload 8
      //   68: invokeinterface 153 1 0
      //   73: checkcast 376	com/tencent/mm/plugin/appbrand/appcache/predownload/export/c$b
      //   76: astore 9
      //   78: aload_0
      //   79: aload 9
      //   81: getfield 384	com/tencent/mm/plugin/appbrand/appcache/predownload/export/c$b:appId	Ljava/lang/String;
      //   84: invokevirtual 767	java/util/HashSet:remove	(Ljava/lang/Object;)Z
      //   87: pop
      //   88: invokestatic 56	com/tencent/mm/plugin/appbrand/app/n:cfm	()Lcom/tencent/mm/plugin/appbrand/appcache/bm;
      //   91: aload 9
      //   93: getfield 384	com/tencent/mm/plugin/appbrand/appcache/predownload/export/c$b:appId	Ljava/lang/String;
      //   96: aload 9
      //   98: getfield 387	com/tencent/mm/plugin/appbrand/appcache/predownload/export/c$b:euz	I
      //   101: aload 9
      //   103: getfield 390	com/tencent/mm/plugin/appbrand/appcache/predownload/export/c$b:version	I
      //   106: invokevirtual 303	com/tencent/mm/plugin/appbrand/appcache/bm:I	(Ljava/lang/String;II)I
      //   109: istore_2
      //   110: invokestatic 56	com/tencent/mm/plugin/appbrand/app/n:cfm	()Lcom/tencent/mm/plugin/appbrand/appcache/bm;
      //   113: aload 9
      //   115: getfield 384	com/tencent/mm/plugin/appbrand/appcache/predownload/export/c$b:appId	Ljava/lang/String;
      //   118: aload 9
      //   120: getfield 387	com/tencent/mm/plugin/appbrand/appcache/predownload/export/c$b:euz	I
      //   123: aload 9
      //   125: getfield 390	com/tencent/mm/plugin/appbrand/appcache/predownload/export/c$b:version	I
      //   128: invokevirtual 392	com/tencent/mm/plugin/appbrand/appcache/bm:J	(Ljava/lang/String;II)I
      //   131: istore_3
      //   132: ldc 169
      //   134: ldc_w 394
      //   137: iconst_4
      //   138: anewarray 4	java/lang/Object
      //   141: dup
      //   142: iconst_0
      //   143: aload 9
      //   145: getfield 384	com/tencent/mm/plugin/appbrand/appcache/predownload/export/c$b:appId	Ljava/lang/String;
      //   148: aastore
      //   149: dup
      //   150: iconst_1
      //   151: aload 9
      //   153: getfield 390	com/tencent/mm/plugin/appbrand/appcache/predownload/export/c$b:version	I
      //   156: invokestatic 214	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   159: aastore
      //   160: dup
      //   161: iconst_2
      //   162: iload_2
      //   163: invokestatic 214	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   166: aastore
      //   167: dup
      //   168: iconst_3
      //   169: iload_3
      //   170: invokestatic 214	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   173: aastore
      //   174: invokestatic 176	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   177: goto -121 -> 56
      //   180: invokestatic 140	com/tencent/mm/sdk/platformtools/Util:nowSecond	()J
      //   183: lstore 4
      //   185: invokestatic 474	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:ckD	()Lcom/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig;
      //   188: getfield 478	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:qXj	Lcom/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig$PackageManager;
      //   191: getfield 483	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig$PackageManager:qXJ	J
      //   194: lstore 6
      //   196: aload_0
      //   197: invokevirtual 768	java/util/HashSet:iterator	()Ljava/util/Iterator;
      //   200: astore_0
      //   201: aload_0
      //   202: invokeinterface 149 1 0
      //   207: ifeq +244 -> 451
      //   210: aload_0
      //   211: invokeinterface 153 1 0
      //   216: checkcast 324	java/lang/String
      //   219: astore 8
      //   221: new 178	com/tencent/mm/plugin/appbrand/appcache/o$a
      //   224: dup
      //   225: aload 8
      //   227: iconst_0
      //   228: invokespecial 185	com/tencent/mm/plugin/appbrand/appcache/o$a:<init>	(Ljava/lang/String;I)V
      //   231: astore 9
      //   233: aload_1
      //   234: aload 9
      //   236: invokeinterface 188 2 0
      //   241: ifeq +23 -> 264
      //   244: ldc 169
      //   246: ldc_w 770
      //   249: iconst_1
      //   250: anewarray 4	java/lang/Object
      //   253: dup
      //   254: iconst_0
      //   255: aload 9
      //   257: aastore
      //   258: invokestatic 176	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   261: goto -60 -> 201
      //   264: aload 8
      //   266: invokestatic 365	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
      //   269: ifne +14 -> 283
      //   272: aload 8
      //   274: ldc_w 772
      //   277: invokevirtual 775	java/lang/String:endsWith	(Ljava/lang/String;)Z
      //   280: ifne -79 -> 201
      //   283: aload 8
      //   285: iconst_0
      //   286: invokestatic 272	com/tencent/mm/plugin/appbrand/launching/m:cQ	(Ljava/lang/String;I)Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo;
      //   289: astore 9
      //   291: aload 9
      //   293: ifnonnull +39 -> 332
      //   296: new 58	java/lang/StringBuilder
      //   299: dup
      //   300: invokespecial 776	java/lang/StringBuilder:<init>	()V
      //   303: aload 8
      //   305: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   308: bipush 36
      //   310: invokevirtual 81	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
      //   313: ldc_w 778
      //   316: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   319: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   322: iconst_0
      //   323: invokestatic 272	com/tencent/mm/plugin/appbrand/launching/m:cQ	(Ljava/lang/String;I)Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo;
      //   326: ifnonnull -125 -> 201
      //   329: goto -128 -> 201
      //   332: getstatic 506	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
      //   335: new 508	com/tencent/mm/vfs/u
      //   338: dup
      //   339: aload 9
      //   341: getfield 780	com/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo:pkgPath	Ljava/lang/String;
      //   344: invokespecial 509	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
      //   347: invokevirtual 512	com/tencent/mm/vfs/u:lastModified	()J
      //   350: invokevirtual 516	java/util/concurrent/TimeUnit:toSeconds	(J)J
      //   353: lload 4
      //   355: lload 6
      //   357: lsub
      //   358: lcmp
      //   359: ifge -158 -> 201
      //   362: ldc 169
      //   364: ldc_w 782
      //   367: iconst_2
      //   368: anewarray 4	java/lang/Object
      //   371: dup
      //   372: iconst_0
      //   373: aload 8
      //   375: aastore
      //   376: dup
      //   377: iconst_1
      //   378: aload 9
      //   380: getfield 320	com/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo:pkgVersion	I
      //   383: invokestatic 214	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   386: aastore
      //   387: invokestatic 176	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   390: invokestatic 56	com/tencent/mm/plugin/appbrand/app/n:cfm	()Lcom/tencent/mm/plugin/appbrand/appcache/bm;
      //   393: aload 8
      //   395: iconst_0
      //   396: aload 9
      //   398: getfield 320	com/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo:pkgVersion	I
      //   401: invokevirtual 303	com/tencent/mm/plugin/appbrand/appcache/bm:I	(Ljava/lang/String;II)I
      //   404: pop
      //   405: invokestatic 56	com/tencent/mm/plugin/appbrand/app/n:cfm	()Lcom/tencent/mm/plugin/appbrand/appcache/bm;
      //   408: aload 8
      //   410: iconst_0
      //   411: aload 9
      //   413: getfield 320	com/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo:pkgVersion	I
      //   416: invokevirtual 392	com/tencent/mm/plugin/appbrand/appcache/bm:J	(Ljava/lang/String;II)I
      //   419: pop
      //   420: ldc_w 440
      //   423: invokestatic 444	com/tencent/mm/plugin/appbrand/app/n:ag	(Ljava/lang/Class;)Ljava/lang/Object;
      //   426: checkcast 440	com/tencent/mm/plugin/appbrand/ui/b/a/b
      //   429: aload 8
      //   431: iconst_0
      //   432: new 446	com/tencent/mm/plugin/appbrand/ui/b/a/b$b$c
      //   435: dup
      //   436: aload 9
      //   438: getfield 320	com/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo:pkgVersion	I
      //   441: invokespecial 447	com/tencent/mm/plugin/appbrand/ui/b/a/b$b$c:<init>	(I)V
      //   444: invokevirtual 450	com/tencent/mm/plugin/appbrand/ui/b/a/b:a	(Ljava/lang/String;ILcom/tencent/mm/plugin/appbrand/ui/b/a/b$b;)I
      //   447: pop
      //   448: goto -247 -> 201
      //   451: ldc_w 747
      //   454: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   457: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	458	0	paramList	List<String>
      //   0	458	1	paramList1	List<o.a>
      //   109	54	2	i	int
      //   131	39	3	j	int
      //   183	171	4	l1	long
      //   194	162	6	l2	long
      //   35	395	8	localObject1	Object
      //   76	361	9	localObject2	Object
    }
    
    /* Error */
    public final void run()
    {
      // Byte code:
      //   0: ldc_w 785
      //   3: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   6: invokestatic 56	com/tencent/mm/plugin/appbrand/app/n:cfm	()Lcom/tencent/mm/plugin/appbrand/appcache/bm;
      //   9: ifnonnull +18 -> 27
      //   12: ldc 169
      //   14: ldc_w 787
      //   17: invokestatic 381	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   20: ldc_w 785
      //   23: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   26: return
      //   27: aload_0
      //   28: getfield 36	com/tencent/mm/plugin/appbrand/appcache/o$f:qEn	Ljava/util/concurrent/atomic/AtomicBoolean;
      //   31: iconst_0
      //   32: invokevirtual 791	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
      //   35: getstatic 797	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
      //   38: sipush 1007
      //   41: iconst_1
      //   42: invokevirtual 801	com/tencent/mm/plugin/report/service/h:kJ	(II)V
      //   45: invokestatic 804	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
      //   48: lstore 11
      //   50: new 116	java/util/ArrayList
      //   53: dup
      //   54: invokespecial 117	java/util/ArrayList:<init>	()V
      //   57: astore 16
      //   59: aload_0
      //   60: getfield 41	com/tencent/mm/plugin/appbrand/appcache/o$f:qEo	Ljava/util/List;
      //   63: invokeinterface 144 1 0
      //   68: astore 17
      //   70: aload 17
      //   72: invokeinterface 149 1 0
      //   77: ifeq +101 -> 178
      //   80: aload 16
      //   82: aload 17
      //   84: invokeinterface 153 1 0
      //   89: checkcast 806	com/tencent/mm/plugin/appbrand/appcache/o$e
      //   92: invokeinterface 809 1 0
      //   97: invokeinterface 813 2 0
      //   102: pop
      //   103: goto -33 -> 70
      //   106: astore 16
      //   108: ldc 169
      //   110: ldc_w 815
      //   113: iconst_1
      //   114: anewarray 4	java/lang/Object
      //   117: dup
      //   118: iconst_0
      //   119: aload 16
      //   121: invokestatic 821	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   124: aastore
      //   125: invokestatic 176	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   128: ldc 169
      //   130: ldc_w 823
      //   133: iconst_1
      //   134: anewarray 4	java/lang/Object
      //   137: dup
      //   138: iconst_0
      //   139: invokestatic 804	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
      //   142: lload 11
      //   144: lsub
      //   145: invokestatic 222	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   148: aastore
      //   149: invokestatic 176	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   152: ldc_w 785
      //   155: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   158: return
      //   159: astore 16
      //   161: ldc 169
      //   163: aload 16
      //   165: ldc_w 825
      //   168: iconst_0
      //   169: anewarray 4	java/lang/Object
      //   172: invokestatic 562	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   175: goto -130 -> 45
      //   178: aload_0
      //   179: aload 16
      //   181: invokespecial 827	com/tencent/mm/plugin/appbrand/appcache/o$f:cH	(Ljava/util/List;)V
      //   184: invokestatic 829	com/tencent/mm/plugin/appbrand/appcache/o$f:cga	()V
      //   187: aload_0
      //   188: aload 16
      //   190: invokespecial 831	com/tencent/mm/plugin/appbrand/appcache/o$f:cI	(Ljava/util/List;)V
      //   193: aload_0
      //   194: aload 16
      //   196: invokespecial 833	com/tencent/mm/plugin/appbrand/appcache/o$f:cJ	(Ljava/util/List;)V
      //   199: aload_0
      //   200: invokespecial 835	com/tencent/mm/plugin/appbrand/appcache/o$f:cgb	()V
      //   203: invokestatic 837	com/tencent/mm/plugin/appbrand/appcache/o$f:cgc	()V
      //   206: ldc_w 839
      //   209: invokestatic 444	com/tencent/mm/plugin/appbrand/app/n:ag	(Ljava/lang/Class;)Ljava/lang/Object;
      //   212: checkcast 839	com/tencent/mm/plugin/appbrand/appcache/predownload/storage/l
      //   215: invokestatic 56	com/tencent/mm/plugin/appbrand/app/n:cfm	()Lcom/tencent/mm/plugin/appbrand/appcache/bm;
      //   218: invokevirtual 843	com/tencent/mm/plugin/appbrand/appcache/predownload/storage/l:b	(Lcom/tencent/mm/plugin/appbrand/appcache/bm;)V
      //   221: aload_0
      //   222: invokespecial 136	com/tencent/mm/plugin/appbrand/appcache/o$f:cfZ	()V
      //   225: new 845	android/os/StatFs
      //   228: dup
      //   229: invokestatic 657	com/tencent/mm/plugin/appbrand/appcache/bd:cgP	()Ljava/lang/String;
      //   232: invokespecial 846	android/os/StatFs:<init>	(Ljava/lang/String;)V
      //   235: astore 17
      //   237: getstatic 851	android/os/Build$VERSION:SDK_INT	I
      //   240: bipush 18
      //   242: if_icmplt +324 -> 566
      //   245: aload 17
      //   247: invokevirtual 854	android/os/StatFs:getBlockCountLong	()J
      //   250: lstore 7
      //   252: invokestatic 859	com/tencent/mm/plugin/appbrand/appcache/o$c:cfW	()J
      //   255: lstore 13
      //   257: getstatic 851	android/os/Build$VERSION:SDK_INT	I
      //   260: bipush 18
      //   262: if_icmplt +315 -> 577
      //   265: aload 17
      //   267: invokevirtual 862	android/os/StatFs:getBlockSizeLong	()J
      //   270: lstore 9
      //   272: lload 13
      //   274: lload 9
      //   276: ldiv
      //   277: l2d
      //   278: lload 7
      //   280: l2d
      //   281: ddiv
      //   282: dstore_1
      //   283: invokestatic 474	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:ckD	()Lcom/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig;
      //   286: getfield 478	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:qXj	Lcom/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig$PackageManager;
      //   289: getfield 865	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig$PackageManager:qXL	I
      //   292: i2f
      //   293: ldc_w 866
      //   296: fdiv
      //   297: f2d
      //   298: dstore_3
      //   299: dload_1
      //   300: dload_3
      //   301: dcmpl
      //   302: ifle +373 -> 675
      //   305: lload 13
      //   307: invokestatic 474	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:ckD	()Lcom/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig;
      //   310: getfield 478	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:qXj	Lcom/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig$PackageManager;
      //   313: getfield 869	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig$PackageManager:qXK	J
      //   316: ldc2_w 870
      //   319: lmul
      //   320: lcmp
      //   321: ifle +354 -> 675
      //   324: iconst_1
      //   325: istore 15
      //   327: ldc 169
      //   329: ldc_w 873
      //   332: iconst_5
      //   333: anewarray 4	java/lang/Object
      //   336: dup
      //   337: iconst_0
      //   338: dload_1
      //   339: invokestatic 878	java/lang/Double:valueOf	(D)Ljava/lang/Double;
      //   342: aastore
      //   343: dup
      //   344: iconst_1
      //   345: dload_3
      //   346: invokestatic 878	java/lang/Double:valueOf	(D)Ljava/lang/Double;
      //   349: aastore
      //   350: dup
      //   351: iconst_2
      //   352: lload 13
      //   354: invokestatic 222	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   357: aastore
      //   358: dup
      //   359: iconst_3
      //   360: invokestatic 474	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:ckD	()Lcom/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig;
      //   363: getfield 478	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:qXj	Lcom/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig$PackageManager;
      //   366: getfield 869	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig$PackageManager:qXK	J
      //   369: invokestatic 222	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   372: aastore
      //   373: dup
      //   374: iconst_4
      //   375: iload 15
      //   377: invokestatic 650	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   380: aastore
      //   381: invokestatic 176	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   384: iload 15
      //   386: ifeq +77 -> 463
      //   389: ldc 169
      //   391: ldc_w 880
      //   394: iconst_2
      //   395: anewarray 4	java/lang/Object
      //   398: dup
      //   399: iconst_0
      //   400: dload_1
      //   401: invokestatic 878	java/lang/Double:valueOf	(D)Ljava/lang/Double;
      //   404: aastore
      //   405: dup
      //   406: iconst_1
      //   407: dload_3
      //   408: invokestatic 878	java/lang/Double:valueOf	(D)Ljava/lang/Double;
      //   411: aastore
      //   412: invokestatic 176	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   415: lload 7
      //   417: l2d
      //   418: dstore 5
      //   420: getstatic 851	android/os/Build$VERSION:SDK_INT	I
      //   423: bipush 18
      //   425: if_icmplt +163 -> 588
      //   428: aload 17
      //   430: invokevirtual 862	android/os/StatFs:getBlockSizeLong	()J
      //   433: lstore 7
      //   435: lload 7
      //   437: l2d
      //   438: dload 5
      //   440: dload_1
      //   441: dload_3
      //   442: dsub
      //   443: dmul
      //   444: dmul
      //   445: d2l
      //   446: lstore 7
      //   448: lload 7
      //   450: lconst_0
      //   451: lcmp
      //   452: ifge +147 -> 599
      //   455: ldc 169
      //   457: ldc_w 882
      //   460: invokestatic 381	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   463: ldc 169
      //   465: ldc_w 823
      //   468: iconst_1
      //   469: anewarray 4	java/lang/Object
      //   472: dup
      //   473: iconst_0
      //   474: invokestatic 804	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
      //   477: lload 11
      //   479: lsub
      //   480: invokestatic 222	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   483: aastore
      //   484: invokestatic 176	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   487: ldc_w 785
      //   490: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   493: return
      //   494: astore 17
      //   496: ldc 169
      //   498: ldc_w 884
      //   501: iconst_1
      //   502: anewarray 4	java/lang/Object
      //   505: dup
      //   506: iconst_0
      //   507: aload 17
      //   509: aastore
      //   510: invokestatic 886	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   513: goto -292 -> 221
      //   516: astore 16
      //   518: ldc 169
      //   520: ldc_w 888
      //   523: iconst_1
      //   524: anewarray 4	java/lang/Object
      //   527: dup
      //   528: iconst_0
      //   529: aload 16
      //   531: aastore
      //   532: invokestatic 886	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   535: ldc 169
      //   537: ldc_w 823
      //   540: iconst_1
      //   541: anewarray 4	java/lang/Object
      //   544: dup
      //   545: iconst_0
      //   546: invokestatic 804	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
      //   549: lload 11
      //   551: lsub
      //   552: invokestatic 222	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   555: aastore
      //   556: invokestatic 176	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   559: ldc_w 785
      //   562: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   565: return
      //   566: aload 17
      //   568: invokevirtual 891	android/os/StatFs:getBlockCount	()I
      //   571: i2l
      //   572: lstore 7
      //   574: goto -322 -> 252
      //   577: aload 17
      //   579: invokevirtual 894	android/os/StatFs:getBlockSize	()I
      //   582: i2l
      //   583: lstore 9
      //   585: goto -313 -> 272
      //   588: aload 17
      //   590: invokevirtual 894	android/os/StatFs:getBlockSize	()I
      //   593: i2l
      //   594: lstore 7
      //   596: goto -161 -> 435
      //   599: aload_0
      //   600: invokespecial 136	com/tencent/mm/plugin/appbrand/appcache/o$f:cfZ	()V
      //   603: lload 7
      //   605: aload 16
      //   607: new 13	com/tencent/mm/plugin/appbrand/appcache/o$f$3
      //   610: dup
      //   611: aload_0
      //   612: invokespecial 895	com/tencent/mm/plugin/appbrand/appcache/o$f$3:<init>	(Lcom/tencent/mm/plugin/appbrand/appcache/o$f;)V
      //   615: invokestatic 900	com/tencent/mm/plugin/appbrand/appcache/ae:a	(JLjava/util/List;Lcom/tencent/mm/plugin/appbrand/appcache/ae$a;)Lcom/tencent/mm/plugin/appbrand/appcache/ae$b;
      //   618: pop
      //   619: lload 7
      //   621: ldc2_w 901
      //   624: ldiv
      //   625: new 15	com/tencent/mm/plugin/appbrand/appcache/o$f$4
      //   628: dup
      //   629: aload_0
      //   630: invokespecial 903	com/tencent/mm/plugin/appbrand/appcache/o$f$4:<init>	(Lcom/tencent/mm/plugin/appbrand/appcache/o$f;)V
      //   633: invokestatic 908	com/tencent/mm/plugin/appbrand/appcache/am:a	(JLcom/tencent/mm/plugin/appbrand/appcache/am$a;)Lcom/tencent/mm/plugin/appbrand/appcache/am$b;
      //   636: pop
      //   637: goto -174 -> 463
      //   640: astore 16
      //   642: ldc 169
      //   644: ldc_w 823
      //   647: iconst_1
      //   648: anewarray 4	java/lang/Object
      //   651: dup
      //   652: iconst_0
      //   653: invokestatic 804	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
      //   656: lload 11
      //   658: lsub
      //   659: invokestatic 222	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   662: aastore
      //   663: invokestatic 176	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   666: ldc_w 785
      //   669: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   672: aload 16
      //   674: athrow
      //   675: iconst_0
      //   676: istore 15
      //   678: goto -351 -> 327
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	681	0	this	f
      //   282	159	1	d1	double
      //   298	144	3	d2	double
      //   418	21	5	d3	double
      //   250	370	7	l1	long
      //   270	314	9	l2	long
      //   48	609	11	l3	long
      //   255	98	13	l4	long
      //   325	352	15	bool	boolean
      //   57	24	16	localArrayList	ArrayList
      //   106	14	16	localInterruptedException	InterruptedException
      //   159	36	16	localThrowable	Throwable
      //   516	90	16	localList	List
      //   640	33	16	localObject1	Object
      //   68	361	17	localObject2	Object
      //   494	95	17	localException	Exception
      // Exception table:
      //   from	to	target	type
      //   50	70	106	java/lang/InterruptedException
      //   70	103	106	java/lang/InterruptedException
      //   178	206	106	java/lang/InterruptedException
      //   206	221	106	java/lang/InterruptedException
      //   221	252	106	java/lang/InterruptedException
      //   252	272	106	java/lang/InterruptedException
      //   272	299	106	java/lang/InterruptedException
      //   305	324	106	java/lang/InterruptedException
      //   327	384	106	java/lang/InterruptedException
      //   389	415	106	java/lang/InterruptedException
      //   420	435	106	java/lang/InterruptedException
      //   455	463	106	java/lang/InterruptedException
      //   496	513	106	java/lang/InterruptedException
      //   566	574	106	java/lang/InterruptedException
      //   577	585	106	java/lang/InterruptedException
      //   588	596	106	java/lang/InterruptedException
      //   599	637	106	java/lang/InterruptedException
      //   35	45	159	finally
      //   206	221	494	java/lang/Exception
      //   50	70	516	finally
      //   70	103	516	finally
      //   178	206	516	finally
      //   206	221	516	finally
      //   221	252	516	finally
      //   252	272	516	finally
      //   272	299	516	finally
      //   305	324	516	finally
      //   327	384	516	finally
      //   389	415	516	finally
      //   420	435	516	finally
      //   455	463	516	finally
      //   496	513	516	finally
      //   566	574	516	finally
      //   577	585	516	finally
      //   588	596	516	finally
      //   599	637	516	finally
      //   108	128	640	finally
      //   518	535	640	finally
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.o
 * JD-Core Version:    0.7.0.1
 */