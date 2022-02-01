package com.tencent.mm.plugin.appbrand.appstorage.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import d.n.n;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.commons.a.b;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/appstorage/compatibility/AppBrandTransferTask;", "", "legacyPath", "", "targetPath", "(Ljava/lang/String;Ljava/lang/String;)V", "dirSpaceUsage", "dir", "Ljava/io/File;", "executeSync", "Lcom/tencent/mm/plugin/appbrand/appstorage/compatibility/TransferTaskResult;", "hasLocalRecord", "", "hasSyncRecord", "fakeNative", "legacyDisapprove", "moveDir", "needLogSpaceForTest", "recursiveDelete", "Companion", "plugin-appbrand-integration_release"})
public final class c
{
  @Deprecated
  public static final a jRh;
  private final String jRf;
  private final String jRg;
  
  static
  {
    AppMethodBeat.i(175122);
    jRh = new a((byte)0);
    AppMethodBeat.o(175122);
  }
  
  public c(String paramString1, String paramString2)
  {
    AppMethodBeat.i(175120);
    this.jRf = paramString1;
    this.jRg = paramString2;
    AppMethodBeat.o(175120);
  }
  
  private static boolean G(File paramFile)
  {
    AppMethodBeat.i(223247);
    try
    {
      a.jRb.deleteDirectory(paramFile);
      AppMethodBeat.o(223247);
      return true;
    }
    catch (IOException paramFile)
    {
      ae.w("MicroMsg.AppBrand.AppBrandTransferTask", "recursiveDelete: [%s]", new Object[] { paramFile.getMessage() });
      AppMethodBeat.o(223247);
    }
    return false;
  }
  
  private static boolean cx(String paramString1, String paramString2)
  {
    AppMethodBeat.i(223246);
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
      AppMethodBeat.o(223246);
      throw paramString1;
    }
    paramString1 = (Throwable)new IllegalStateException("transfer desc dir is exists");
    AppMethodBeat.o(223246);
    throw paramString1;
    try
    {
      label123:
      localObject = a.jRb;
      p.h(paramString1, "srcDir");
      p.h(paramString2, "destDir");
      if (!paramString1.exists())
      {
        paramString1 = (Throwable)new FileNotFoundException("Source '" + paramString1 + "' does not exist");
        AppMethodBeat.o(223246);
        throw paramString1;
      }
    }
    catch (IOException paramString1)
    {
      ae.w("MicroMsg.AppBrand.AppBrandTransferTask", "moveDir: [%s]", new Object[] { paramString1.getMessage() });
      AppMethodBeat.o(223246);
      return false;
    }
    if (!paramString1.isDirectory())
    {
      paramString1 = (Throwable)new IOException("Source '" + paramString1 + "' is not a directory");
      AppMethodBeat.o(223246);
      throw paramString1;
    }
    if (paramString2.exists())
    {
      paramString1 = (Throwable)new b("Destination '" + paramString2 + "' already exists");
      AppMethodBeat.o(223246);
      throw paramString1;
    }
    if (!paramString1.renameTo(paramString2))
    {
      String str = paramString2.getCanonicalPath();
      p.g(str, "destDir.canonicalPath");
      if (n.nF(str, paramString1.getCanonicalPath() + File.separator))
      {
        paramString1 = (Throwable)new IOException("Cannot move directory: " + paramString1 + " to a subdirectory of itself: " + paramString2);
        AppMethodBeat.o(223246);
        throw paramString1;
      }
      org.apache.commons.a.c.h(paramString1, paramString2);
      ((a)localObject).deleteDirectory(paramString1);
      if (paramString1.exists())
      {
        paramString1 = (Throwable)new IOException("Failed to delete original directory '" + paramString1 + "' after copy to '" + paramString2 + "'");
        AppMethodBeat.o(223246);
        throw paramString1;
      }
    }
    AppMethodBeat.o(223246);
    return true;
  }
  
  public final e d(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    boolean bool3 = true;
    AppMethodBeat.i(223245);
    Object localObject = new File(this.jRf);
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
        localObject = new File(this.jRg);
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
        ae.i("MicroMsg.AppBrand.AppBrandTransferTask", "legacyDisapprove: oldDirExists [%b], targetDirExists [%b], hasLocalRecord [%b], hasSyncRecord [%b], fakeNative [%b]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3) });
        if ((!bool1) || (!bool2)) {
          break label326;
        }
        ae.i("MicroMsg.AppBrand.AppBrandTransferTask", "legacyDisapprove: delDirRes = [%b]", new Object[] { Boolean.valueOf(G(new File(this.jRf))) });
        i = 1;
        label236:
        if (i == 0) {
          break label478;
        }
        g.yxI.dD(1323, 4);
        if (new File(this.jRf).exists()) {
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
      AppMethodBeat.o(223245);
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
          g.yxI.dD(1323, 5);
          break;
          ae.i("MicroMsg.AppBrand.AppBrandTransferTask", "legacyDisapprove: delDirRes = [%b]", new Object[] { Boolean.valueOf(G(new File(this.jRf))) });
        }
        g.yxI.dD(1323, 4);
        break label236;
      }
      if ((!bool2) && (!bool1))
      {
        i = 1;
        break label236;
      }
      localObject = (Throwable)new IllegalStateException("impossible");
      AppMethodBeat.o(223245);
      throw ((Throwable)localObject);
    }
    label422:
    label478:
    if (cx(this.jRf, this.jRg))
    {
      ae.i("MicroMsg.AppBrand.AppBrandTransferTask", this.jRf + " -> " + this.jRg + " successful");
      localObject = new e(true, true);
      AppMethodBeat.o(223245);
      return localObject;
    }
    localObject = new File(this.jRg);
    if ((((File)localObject).exists()) && (((File)localObject).isDirectory())) {}
    try
    {
      a.jRb.deleteDirectory((File)localObject);
      label587:
      ae.i("MicroMsg.AppBrand.AppBrandTransferTask", this.jRf + " -> " + this.jRg + " fail, try del target dir");
      localObject = new e(false, true, "move fail");
      AppMethodBeat.o(223245);
      return localObject;
    }
    catch (IOException localIOException)
    {
      break label587;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/appstorage/compatibility/AppBrandTransferTask$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.b.c
 * JD-Core Version:    0.7.0.1
 */