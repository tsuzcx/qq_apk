package com.tencent.mm.plugin.appbrand.appcache;

import android.database.Cursor;
import android.os.Build.VERSION;
import android.os.StatFs;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.g.b.a.ca;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig.PackageManager;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.io.FileFilter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public final class n$d
  implements n
{
  final AtomicBoolean gUm;
  
  public n$d()
  {
    AppMethodBeat.i(129343);
    this.gUm = new AtomicBoolean();
    AppMethodBeat.o(129343);
  }
  
  private void avq()
  {
    AppMethodBeat.i(129344);
    if (this.gUm.get())
    {
      InterruptedException localInterruptedException = new InterruptedException();
      AppMethodBeat.o(129344);
      throw localInterruptedException;
    }
    AppMethodBeat.o(129344);
  }
  
  private void avr()
  {
    AppMethodBeat.i(129347);
    avq();
    long l1 = bo.aox();
    long l2 = AppBrandGlobalSystemConfig.ayt().hhY.hio;
    Object localObject1 = ((af)com.tencent.mm.plugin.appbrand.app.g.w(af.class)).getAll();
    if ((localObject1 == null) || (((Cursor)localObject1).isClosed()))
    {
      AppMethodBeat.o(129347);
      return;
    }
    Object localObject2 = new LinkedList();
    if (((Cursor)localObject1).moveToFirst()) {
      do
      {
        ae localae = new ae();
        localae.convertFrom((Cursor)localObject1);
        ((List)localObject2).add(localae);
      } while (((Cursor)localObject1).moveToNext());
    }
    ((Cursor)localObject1).close();
    avq();
    localObject1 = ((List)localObject2).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ae)((Iterator)localObject1).next();
      if (e.cN(((ae)localObject2).field_pkgPath))
      {
        avq();
        if (TimeUnit.MILLISECONDS.toSeconds(new File(((ae)localObject2).field_pkgPath).lastModified()) < l1 - l2)
        {
          ab.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processEncrypted, delete record(%s %d %d)", new Object[] { ((ae)localObject2).field_appId, Integer.valueOf(((ae)localObject2).field_type), Integer.valueOf(((ae)localObject2).field_version) });
          ((af)com.tencent.mm.plugin.appbrand.app.g.w(af.class)).delete((c)localObject2, new String[0]);
          e.cO(((ae)localObject2).field_pkgPath);
        }
      }
    }
    AppMethodBeat.o(129347);
  }
  
  private void avs()
  {
    AppMethodBeat.i(129348);
    Object localObject1 = new File(ap.avQ());
    if ((!((File)localObject1).exists()) || (!((File)localObject1).isDirectory()))
    {
      AppMethodBeat.o(129348);
      return;
    }
    localObject1 = ((File)localObject1).listFiles(new FileFilter()
    {
      public final boolean accept(File paramAnonymousFile)
      {
        AppMethodBeat.i(129340);
        boolean bool = paramAnonymousFile.isFile();
        AppMethodBeat.o(129340);
        return bool;
      }
    });
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      if (!com.tencent.mm.plugin.appbrand.app.g.auM().yG(localObject2.getAbsolutePath())) {
        n.a.yo(localObject2.getAbsolutePath());
      }
      i += 1;
    }
    AppMethodBeat.o(129348);
  }
  
  /* Error */
  private static void aw(List<String> paramList)
  {
    // Byte code:
    //   0: ldc 226
    //   2: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokestatic 230	com/tencent/mm/sdk/platformtools/bo:es	(Ljava/util/List;)Z
    //   9: ifeq +9 -> 18
    //   12: ldc 226
    //   14: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   17: return
    //   18: invokestatic 52	com/tencent/mm/sdk/platformtools/bo:aox	()J
    //   21: lstore_1
    //   22: invokestatic 58	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:ayt	()Lcom/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig;
    //   25: getfield 62	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:hhY	Lcom/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig$PackageManager;
    //   28: getfield 68	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig$PackageManager:hio	J
    //   31: lstore_3
    //   32: aload_0
    //   33: invokeinterface 114 1 0
    //   38: astore_0
    //   39: aload_0
    //   40: invokeinterface 119 1 0
    //   45: ifeq +168 -> 213
    //   48: aload_0
    //   49: invokeinterface 123 1 0
    //   54: checkcast 178	java/lang/String
    //   57: astore 5
    //   59: aload 5
    //   61: invokestatic 233	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   64: ifne +13 -> 77
    //   67: aload 5
    //   69: ldc 235
    //   71: invokevirtual 238	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   74: ifne -35 -> 39
    //   77: aload 5
    //   79: iconst_0
    //   80: invokestatic 244	com/tencent/mm/plugin/appbrand/launching/h:bl	(Ljava/lang/String;I)Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo;
    //   83: astore 6
    //   85: aload 6
    //   87: ifnonnull +39 -> 126
    //   90: new 246	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   97: aload 5
    //   99: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: bipush 36
    //   104: invokevirtual 254	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   107: ldc_w 256
    //   110: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: iconst_0
    //   117: invokestatic 244	com/tencent/mm/plugin/appbrand/launching/h:bl	(Ljava/lang/String;I)Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo;
    //   120: ifnonnull -81 -> 39
    //   123: goto -84 -> 39
    //   126: getstatic 139	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   129: new 141	java/io/File
    //   132: dup
    //   133: aload 6
    //   135: getfield 264	com/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo:gUy	Ljava/lang/String;
    //   138: invokespecial 144	java/io/File:<init>	(Ljava/lang/String;)V
    //   141: invokevirtual 147	java/io/File:lastModified	()J
    //   144: invokevirtual 151	java/util/concurrent/TimeUnit:toSeconds	(J)J
    //   147: lload_1
    //   148: lload_3
    //   149: lsub
    //   150: lcmp
    //   151: ifge -112 -> 39
    //   154: ldc 153
    //   156: ldc_w 266
    //   159: iconst_2
    //   160: anewarray 4	java/lang/Object
    //   163: dup
    //   164: iconst_0
    //   165: aload 5
    //   167: aastore
    //   168: dup
    //   169: iconst_1
    //   170: aload 6
    //   172: getfield 269	com/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo:gXf	I
    //   175: invokestatic 168	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   178: aastore
    //   179: invokestatic 176	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   182: invokestatic 210	com/tencent/mm/plugin/appbrand/app/g:auM	()Lcom/tencent/mm/plugin/appbrand/appcache/ay;
    //   185: aload 5
    //   187: aload 6
    //   189: getfield 269	com/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo:gXf	I
    //   192: invokevirtual 272	com/tencent/mm/plugin/appbrand/appcache/ay:aw	(Ljava/lang/String;I)I
    //   195: pop
    //   196: invokestatic 210	com/tencent/mm/plugin/appbrand/app/g:auM	()Lcom/tencent/mm/plugin/appbrand/appcache/ay;
    //   199: aload 5
    //   201: aload 6
    //   203: getfield 269	com/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo:gXf	I
    //   206: invokevirtual 275	com/tencent/mm/plugin/appbrand/appcache/ay:ax	(Ljava/lang/String;I)I
    //   209: pop
    //   210: goto -171 -> 39
    //   213: ldc 226
    //   215: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   218: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	219	0	paramList	List<String>
    //   21	127	1	l1	long
    //   31	118	3	l2	long
    //   57	143	5	str	String
    //   83	119	6	localWxaPkgWrappingInfo	WxaPkgWrappingInfo
  }
  
  public final void run()
  {
    AppMethodBeat.i(129345);
    if (com.tencent.mm.plugin.appbrand.app.g.auM() == null)
    {
      ab.e("MicroMsg.AppBrand.PkgCleanupNewLogic", "run() entered but storage not ready");
      AppMethodBeat.o(129345);
      return;
    }
    this.gUm.set(false);
    long l1;
    Object localObject3;
    int j;
    int i;
    try
    {
      com.tencent.mm.plugin.report.service.h.qsU.cT(1007, 1);
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        try
        {
          Object localObject1 = com.tencent.mm.plugin.appbrand.app.g.auM().awg();
          if (bo.es((List)localObject1)) {
            break;
          }
          avq();
          l1 = bo.aox();
          localObject1 = ((List)localObject1).iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject3 = (at)((Iterator)localObject1).next();
          if (com.tencent.mm.plugin.appbrand.task.h.EZ(((at)localObject3).field_appId))
          {
            ab.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processDebug appID(%s) is running, skip", new Object[] { ((at)localObject3).field_appId });
            continue;
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          ab.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "interrupted %s", new Object[] { Log.getStackTraceString(localInterruptedException) });
          AppMethodBeat.o(129345);
          return;
          localThrowable1 = localThrowable1;
          ab.printErrStackTrace("MicroMsg.AppBrand.PkgCleanupNewLogic", localThrowable1, "cleanup start report", new Object[0]);
          continue;
          avq();
          if ((((at)localObject3).field_endTime > 0L) && (((at)localObject3).field_endTime <= l1))
          {
            if (((at)localObject3).field_debugType != 999) {
              continue;
            }
            n.a.yo(((at)localObject3).field_pkgPath);
            com.tencent.mm.plugin.appbrand.app.g.auM().a((at)localObject3);
            ab.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processDebug, (%s, %d) exceed time range[%d, %d]", new Object[] { ((at)localObject3).field_appId, Integer.valueOf(((at)localObject3).field_debugType), Long.valueOf(((at)localObject3).field_startTime), Long.valueOf(((at)localObject3).field_endTime) });
            continue;
          }
        }
        catch (Throwable localThrowable2)
        {
          ab.e("MicroMsg.AppBrand.PkgCleanupNewLogic", "process occur exception %s", new Object[] { localThrowable2 });
          AppMethodBeat.o(129345);
          return;
        }
        if (((at)localObject3).field_debugType == 999) {
          ab.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processDebug, debug library not exceed time range[%d %d]", new Object[] { Long.valueOf(((at)localObject3).field_startTime), Long.valueOf(((at)localObject3).field_endTime) });
        }
      }
      avq();
      localObject2 = com.tencent.mm.plugin.appbrand.app.g.auB();
      j = ai.avE();
      i = j;
      if (j <= 0)
      {
        localObject3 = com.tencent.mm.plugin.appbrand.launching.h.bl("@LibraryAppId", 0);
        if (localObject3 != null) {
          break label742;
        }
        i = 0;
      }
    }
    if (i > 0)
    {
      ab.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processRelease, delete libraries record < %d", new Object[] { Integer.valueOf(i) });
      com.tencent.mm.plugin.appbrand.app.g.auM().aw("@LibraryAppId", i);
    }
    Object localObject2 = ((com.tencent.mm.cg.h)localObject2).a("select distinct appId from AppBrandWxaPkgManifestRecord where debugType=? and appId!=? and appId not like '%%$%%'", new String[] { "0", "@LibraryAppId" }, 0);
    label485:
    long l3;
    label524:
    long l2;
    label544:
    double d1;
    double d2;
    if ((localObject2 == null) || (((Cursor)localObject2).isClosed()))
    {
      avr();
      avs();
      avq();
      localObject2 = new StatFs(ap.avQ());
      if (Build.VERSION.SDK_INT < 18) {
        break label1086;
      }
      l1 = ((StatFs)localObject2).getBlockCountLong();
      l3 = n.b.avo();
      if (Build.VERSION.SDK_INT < 18) {
        break label1097;
      }
      l2 = ((StatFs)localObject2).getBlockSizeLong();
      d1 = l3 / l2 / l1;
      d2 = AppBrandGlobalSystemConfig.ayt().hhY.hiq / 100.0F;
      if ((d1 <= d2) || (l3 <= AppBrandGlobalSystemConfig.ayt().hhY.hip * 1048576L)) {
        break label1168;
      }
    }
    label1168:
    for (boolean bool = true;; bool = false)
    {
      ab.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processByFilesystemUsage, usedPercent(%f), maxPercent(%f), usedBytes(%d), maxMB(%d), shouldCleanup=%B", new Object[] { Double.valueOf(d1), Double.valueOf(d2), Long.valueOf(l3), Long.valueOf(AppBrandGlobalSystemConfig.ayt().hhY.hip), Boolean.valueOf(bool) });
      if (bool)
      {
        ab.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processByFilesystemUsage, cleanup by conditions usedPercent(%f) > maxPercent(%f)", new Object[] { Double.valueOf(d1), Double.valueOf(d2) });
        double d3 = l1;
        if (Build.VERSION.SDK_INT >= 18) {}
        for (l1 = ((StatFs)localObject2).getBlockSizeLong();; l1 = ((StatFs)localObject2).getBlockSize())
        {
          l1 = (l1 * (d3 * (d1 - d2)));
          if (l1 >= 0L) {
            break label1119;
          }
          ab.e("MicroMsg.AppBrand.PkgCleanupNewLogic", "processByFilesystemUsage, calculated bytesToTrim is minus");
          AppMethodBeat.o(129345);
          return;
          label742:
          i = ((WxaPkgWrappingInfo)localObject3).gXf;
          break;
          localObject3 = new LinkedList();
          String str;
          if (((Cursor)localObject2).moveToFirst())
          {
            str = ((Cursor)localObject2).getString(0);
            if (com.tencent.mm.plugin.appbrand.task.h.EZ(str))
            {
              ab.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processRelease appID(%s) is running, skip", new Object[] { str });
              label806:
              if (((Cursor)localObject2).moveToNext()) {
                break label927;
              }
            }
          }
          else
          {
            ((Cursor)localObject2).close();
            localObject2 = new LinkedList();
            avq();
            localObject3 = ((List)localObject3).iterator();
          }
          label927:
          label1076:
          for (;;)
          {
            if (!((Iterator)localObject3).hasNext()) {
              break label1078;
            }
            str = (String)((Iterator)localObject3).next();
            Object localObject4 = com.tencent.mm.plugin.appbrand.app.g.auF().e(str, new String[] { "versionInfo" });
            if ((localObject4 == null) || (bo.isNullOrNil(((WxaAttributes)localObject4).field_versionInfo)))
            {
              ((List)localObject2).add(str);
              continue;
              ((List)localObject3).add(str);
              break label806;
              break;
            }
            avq();
            if (((WxaAttributes)localObject4).ayE() == null) {}
            for (i = 0;; i = ((WxaAttributes)localObject4).ayE().bDc)
            {
              if (i <= 0) {
                break label1076;
              }
              j = com.tencent.mm.plugin.appbrand.app.g.auM().aw(str, i);
              if (j > 0)
              {
                ab.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processRelease, delete record(%s) < %d, count(%d)", new Object[] { str, Integer.valueOf(i), Integer.valueOf(j) });
                localObject4 = new ca();
                ((ca)localObject4).cZU = 2L;
                localObject4 = ((ca)localObject4).gZ(str);
                ((ca)localObject4).cZW = 0L;
                ((ca)localObject4).cZX = j;
                ((ca)localObject4).cZS = 1L;
                ((ca)localObject4).ake();
              }
              com.tencent.mm.plugin.appbrand.app.g.auM().ax(str, i);
              break;
            }
          }
          label1078:
          aw((List)localObject2);
          break label485;
          label1086:
          l1 = ((StatFs)localObject2).getBlockCount();
          break label524;
          label1097:
          l2 = ((StatFs)localObject2).getBlockSize();
          break label544;
        }
        label1119:
        avq();
        x.a(l1, new n.d.2(this));
        if (r.avz()) {
          g.a(l1 / 5L, new n.d.3(this));
        }
      }
      AppMethodBeat.o(129345);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.n.d
 * JD-Core Version:    0.7.0.1
 */