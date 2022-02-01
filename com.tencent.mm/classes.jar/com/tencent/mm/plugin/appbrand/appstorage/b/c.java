package com.tencent.mm.plugin.appbrand.appstorage.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import org.apache.commons.a.b;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/appstorage/compatibility/AppBrandTransferTask;", "", "legacyPath", "", "targetPath", "(Ljava/lang/String;Ljava/lang/String;)V", "dirSpaceUsage", "dir", "Ljava/io/File;", "executeSync", "Lcom/tencent/mm/plugin/appbrand/appstorage/compatibility/TransferTaskResult;", "hasLocalRecord", "", "hasSyncRecord", "fakeNative", "legacyDisapprove", "moveDir", "needLogSpaceForTest", "recursiveDelete", "Companion", "plugin-appbrand-integration_release"})
public final class c
{
  @Deprecated
  public static final a kTR;
  private final String kTP;
  private final String kTQ;
  
  static
  {
    AppMethodBeat.i(175122);
    kTR = new a((byte)0);
    AppMethodBeat.o(175122);
  }
  
  public c(String paramString1, String paramString2)
  {
    AppMethodBeat.i(175120);
    this.kTP = paramString1;
    this.kTQ = paramString2;
    AppMethodBeat.o(175120);
  }
  
  private static boolean G(File paramFile)
  {
    AppMethodBeat.i(228122);
    try
    {
      a.kTL.deleteDirectory(paramFile);
      AppMethodBeat.o(228122);
      return true;
    }
    catch (IOException paramFile)
    {
      Log.w("MicroMsg.AppBrand.AppBrandTransferTask", "recursiveDelete: [%s]", new Object[] { paramFile.getMessage() });
      AppMethodBeat.o(228122);
    }
    return false;
  }
  
  private static boolean cL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(228121);
    paramString1 = new File(paramString1);
    paramString2 = new File(paramString2);
    Object localObject;
    if ((paramString2.exists()) && (paramString2.isDirectory()))
    {
      localObject = paramString2.list();
      p.g(localObject, "targetFile.list()");
      if (localObject.length != 0) {
        break label98;
      }
    }
    label98:
    for (int i = 1; i != 0; i = 0)
    {
      paramString2.delete();
      if ((paramString1.exists()) && (paramString1.isDirectory())) {
        break label123;
      }
      paramString1 = (Throwable)new IllegalStateException("transfer src dir is not exists");
      AppMethodBeat.o(228121);
      throw paramString1;
    }
    paramString1 = (Throwable)new IllegalStateException("transfer desc dir is exists");
    AppMethodBeat.o(228121);
    throw paramString1;
    try
    {
      label123:
      localObject = a.kTL;
      p.h(paramString1, "srcDir");
      p.h(paramString2, "destDir");
      if (!paramString1.exists())
      {
        paramString1 = (Throwable)new FileNotFoundException("Source '" + paramString1 + "' does not exist");
        AppMethodBeat.o(228121);
        throw paramString1;
      }
    }
    catch (IOException paramString1)
    {
      Log.w("MicroMsg.AppBrand.AppBrandTransferTask", "moveDir: [%s]", new Object[] { paramString1.getMessage() });
      AppMethodBeat.o(228121);
      return false;
    }
    if (!paramString1.isDirectory())
    {
      paramString1 = (Throwable)new IOException("Source '" + paramString1 + "' is not a directory");
      AppMethodBeat.o(228121);
      throw paramString1;
    }
    if (paramString2.exists())
    {
      paramString1 = (Throwable)new b("Destination '" + paramString2 + "' already exists");
      AppMethodBeat.o(228121);
      throw paramString1;
    }
    if (!paramString1.renameTo(paramString2))
    {
      String str = paramString2.getCanonicalPath();
      p.g(str, "destDir.canonicalPath");
      if (n.J(str, paramString1.getCanonicalPath() + File.separator, false))
      {
        paramString1 = (Throwable)new IOException("Cannot move directory: " + paramString1 + " to a subdirectory of itself: " + paramString2);
        AppMethodBeat.o(228121);
        throw paramString1;
      }
      org.apache.commons.a.c.h(paramString1, paramString2);
      ((a)localObject).deleteDirectory(paramString1);
      if (paramString1.exists())
      {
        paramString1 = (Throwable)new IOException("Failed to delete original directory '" + paramString1 + "' after copy to '" + paramString2 + "'");
        AppMethodBeat.o(228121);
        throw paramString1;
      }
    }
    AppMethodBeat.o(228121);
    return true;
  }
  
  public final e d(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    boolean bool3 = true;
    AppMethodBeat.i(228120);
    Object localObject = new File(this.kTP);
    int i;
    label68:
    boolean bool1;
    label76:
    boolean bool2;
    if ((((File)localObject).exists()) && (((File)localObject).isDirectory()))
    {
      localObject = ((File)localObject).list();
      p.g(localObject, "it.list()");
      if (localObject.length == 0)
      {
        i = 1;
        if (i != 0) {
          break label296;
        }
        i = 1;
        if (i == 0) {
          break label302;
        }
        bool1 = true;
        localObject = new File(this.kTQ);
        if ((!((File)localObject).exists()) || (!((File)localObject).isDirectory())) {
          break label320;
        }
        localObject = ((File)localObject).list();
        p.g(localObject, "it.list()");
        if (localObject.length != 0) {
          break label308;
        }
        i = 1;
        label128:
        if (i != 0) {
          break label314;
        }
        i = 1;
        label136:
        if (i == 0) {
          break label320;
        }
        bool2 = true;
        label144:
        Log.i("MicroMsg.AppBrand.AppBrandTransferTask", "legacyDisapprove: oldDirExists [%b], targetDirExists [%b], hasLocalRecord [%b], hasSyncRecord [%b], fakeNative [%b]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3) });
        if ((!bool1) || (!bool2)) {
          break label326;
        }
        Log.i("MicroMsg.AppBrand.AppBrandTransferTask", "legacyDisapprove: delDirRes = [%b]", new Object[] { Boolean.valueOf(G(new File(this.kTP))) });
        i = 1;
        label236:
        if (i == 0) {
          break label478;
        }
        h.CyF.dN(1323, 4);
        if (new File(this.kTP).exists()) {
          break label473;
        }
      }
    }
    label296:
    label302:
    label308:
    label314:
    label320:
    label326:
    label473:
    for (paramBoolean1 = bool3;; paramBoolean1 = false)
    {
      localObject = new e(paramBoolean1, false);
      AppMethodBeat.o(228120);
      return localObject;
      i = 0;
      break;
      i = 0;
      break label68;
      bool1 = false;
      break label76;
      i = 0;
      break label128;
      i = 0;
      break label136;
      bool2 = false;
      break label144;
      if ((bool2) && (!bool1))
      {
        i = 1;
        break label236;
      }
      if ((!bool2) && (bool1))
      {
        if (((paramBoolean1) && (paramBoolean3)) || (paramBoolean2)) {}
        for (i = 0;; i = 1)
        {
          if (i == 0) {
            break label422;
          }
          h.CyF.dN(1323, 5);
          break;
          Log.i("MicroMsg.AppBrand.AppBrandTransferTask", "legacyDisapprove: delDirRes = [%b]", new Object[] { Boolean.valueOf(G(new File(this.kTP))) });
        }
        h.CyF.dN(1323, 4);
        break label236;
      }
      if ((!bool2) && (!bool1))
      {
        i = 1;
        break label236;
      }
      localObject = (Throwable)new IllegalStateException("impossible");
      AppMethodBeat.o(228120);
      throw ((Throwable)localObject);
    }
    label422:
    label478:
    if (cL(this.kTP, this.kTQ))
    {
      Log.i("MicroMsg.AppBrand.AppBrandTransferTask", this.kTP + " -> " + this.kTQ + " successful");
      localObject = new e(true, true);
      AppMethodBeat.o(228120);
      return localObject;
    }
    localObject = new File(this.kTQ);
    if ((((File)localObject).exists()) && (((File)localObject).isDirectory())) {}
    try
    {
      a.kTL.deleteDirectory((File)localObject);
      label587:
      Log.i("MicroMsg.AppBrand.AppBrandTransferTask", this.kTP + " -> " + this.kTQ + " fail, try del target dir");
      localObject = new e(false, true, "move fail");
      AppMethodBeat.o(228120);
      return localObject;
    }
    catch (IOException localIOException)
    {
      break label587;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/appstorage/compatibility/AppBrandTransferTask$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.b.c
 * JD-Core Version:    0.7.0.1
 */