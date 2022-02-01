package com.tencent.mm.plugin.appbrand.appstorage.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;
import d.n.n;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.commons.a.b;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/appstorage/compatibility/AppBrandTransferTask;", "", "legacyPath", "", "targetPath", "(Ljava/lang/String;Ljava/lang/String;)V", "dirSpaceUsage", "dir", "Ljava/io/File;", "executeSync", "Lcom/tencent/mm/plugin/appbrand/appstorage/compatibility/TransferTaskResult;", "hasLocalRecord", "", "hasSyncRecord", "fakeNative", "legacyDisapprove", "moveDir", "recursiveDelete", "Companion", "plugin-appbrand-integration_release"})
public final class c
{
  @Deprecated
  public static final a jtW;
  private final String jtU;
  private final String jtV;
  
  static
  {
    AppMethodBeat.i(175122);
    jtW = new a((byte)0);
    AppMethodBeat.o(175122);
  }
  
  public c(String paramString1, String paramString2)
  {
    AppMethodBeat.i(175120);
    this.jtU = paramString1;
    this.jtV = paramString2;
    AppMethodBeat.o(175120);
  }
  
  private static String G(File paramFile)
  {
    AppMethodBeat.i(187098);
    if (!paramFile.exists())
    {
      AppMethodBeat.o(187098);
      return "not exists";
    }
    try
    {
      paramFile = org.apache.commons.a.c.CH(org.apache.commons.a.c.an(paramFile));
      k.g(paramFile, "try {\n                Fi…ot support\"\n            }");
      AppMethodBeat.o(187098);
      return paramFile;
    }
    catch (Exception paramFile)
    {
      for (;;)
      {
        paramFile = "not support";
      }
    }
  }
  
  private static boolean H(File paramFile)
  {
    AppMethodBeat.i(187099);
    try
    {
      a.jtQ.deleteDirectory(paramFile);
      AppMethodBeat.o(187099);
      return true;
    }
    catch (IOException paramFile)
    {
      ac.w("MicroMsg.AppBrand.AppBrandTransferTask", "recursiveDelete: [%s]", new Object[] { paramFile.getMessage() });
      AppMethodBeat.o(187099);
    }
    return false;
  }
  
  private static boolean ct(String paramString1, String paramString2)
  {
    AppMethodBeat.i(187097);
    paramString1 = new File(paramString1);
    paramString2 = new File(paramString2);
    if (paramString2.exists())
    {
      paramString1 = (Throwable)new IllegalStateException("transfer desc dir is exists");
      AppMethodBeat.o(187097);
      throw paramString1;
    }
    if ((!paramString1.exists()) || (!paramString1.isDirectory()))
    {
      paramString1 = (Throwable)new IllegalStateException("transfer src dir is not exists");
      AppMethodBeat.o(187097);
      throw paramString1;
    }
    a locala;
    try
    {
      locala = a.jtQ;
      k.h(paramString1, "srcDir");
      k.h(paramString2, "destDir");
      if (!paramString1.exists())
      {
        paramString1 = (Throwable)new FileNotFoundException("Source '" + paramString1 + "' does not exist");
        AppMethodBeat.o(187097);
        throw paramString1;
      }
    }
    catch (IOException paramString1)
    {
      ac.w("MicroMsg.AppBrand.AppBrandTransferTask", "moveDir: [%s]", new Object[] { paramString1.getMessage() });
      AppMethodBeat.o(187097);
      return false;
    }
    if (!paramString1.isDirectory())
    {
      paramString1 = (Throwable)new IOException("Source '" + paramString1 + "' is not a directory");
      AppMethodBeat.o(187097);
      throw paramString1;
    }
    if (paramString2.exists())
    {
      paramString1 = (Throwable)new b("Destination '" + paramString2 + "' already exists");
      AppMethodBeat.o(187097);
      throw paramString1;
    }
    if (!paramString1.renameTo(paramString2))
    {
      String str = paramString2.getCanonicalPath();
      k.g(str, "destDir.canonicalPath");
      if (n.nb(str, paramString1.getCanonicalPath() + File.separator))
      {
        paramString1 = (Throwable)new IOException("Cannot move directory: " + paramString1 + " to a subdirectory of itself: " + paramString2);
        AppMethodBeat.o(187097);
        throw paramString1;
      }
      org.apache.commons.a.c.h(paramString1, paramString2);
      locala.deleteDirectory(paramString1);
      if (paramString1.exists())
      {
        paramString1 = (Throwable)new IOException("Failed to delete original directory '" + paramString1 + "' after copy to '" + paramString2 + "'");
        AppMethodBeat.o(187097);
        throw paramString1;
      }
    }
    AppMethodBeat.o(187097);
    return true;
  }
  
  public final e d(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    boolean bool3 = true;
    AppMethodBeat.i(187096);
    Object localObject = new File(this.jtU);
    int i;
    label68:
    boolean bool1;
    label76:
    boolean bool2;
    if ((((File)localObject).exists()) && (((File)localObject).isDirectory()))
    {
      localObject = ((File)localObject).list();
      k.g(localObject, "it.list()");
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
        localObject = new File(this.jtV);
        if ((!((File)localObject).exists()) || (!((File)localObject).isDirectory())) {
          break label320;
        }
        localObject = ((File)localObject).list();
        k.g(localObject, "it.list()");
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
        ac.i("MicroMsg.AppBrand.AppBrandTransferTask", "legacyDisapprove: oldDirExists [%b], targetDirExists [%b], hasLocalRecord [%b], hasSyncRecord [%b], fakeNative [%b]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3) });
        if ((!bool1) || (!bool2)) {
          break label326;
        }
        ac.i("MicroMsg.AppBrand.AppBrandTransferTask", "legacyDisapprove: delDirRes = [%b]", new Object[] { Boolean.valueOf(H(new File(this.jtU))) });
        i = 1;
        label236:
        if (i == 0) {
          break label479;
        }
        com.tencent.mm.plugin.report.service.h.wUl.dB(1323, 4);
        if (new File(this.jtU).exists()) {
          break label474;
        }
      }
    }
    label296:
    label302:
    label308:
    label314:
    label320:
    label326:
    label474:
    for (paramBoolean1 = bool3;; paramBoolean1 = false)
    {
      localObject = new e(paramBoolean1, false);
      AppMethodBeat.o(187096);
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
          com.tencent.mm.plugin.report.service.h.wUl.dB(1323, 5);
          break;
          ac.i("MicroMsg.AppBrand.AppBrandTransferTask", "legacyDisapprove: delDirRes = [%b]", new Object[] { Boolean.valueOf(H(new File(this.jtU))) });
        }
        com.tencent.mm.plugin.report.service.h.wUl.dB(1323, 4);
        break label236;
      }
      if ((!bool2) && (!bool1))
      {
        i = 1;
        break label236;
      }
      localObject = (Throwable)new IllegalStateException("impossible");
      AppMethodBeat.o(187096);
      throw ((Throwable)localObject);
    }
    label422:
    label479:
    if ((com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_PURPLE) || (com.tencent.mm.sdk.platformtools.h.DEBUG)) {
      ac.i("MicroMsg.AppBrand.AppBrandTransferTask", "before transfer: legacySum = [%s], targetSum = [%s]", new Object[] { G(new File(this.jtU)), G(new File(this.jtV)) });
    }
    if (ct(this.jtU, this.jtV))
    {
      if ((com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_PURPLE) || (com.tencent.mm.sdk.platformtools.h.DEBUG)) {
        ac.i("MicroMsg.AppBrand.AppBrandTransferTask", "after transfer: legacySum = [%s], targetSum = [%s]", new Object[] { G(new File(this.jtU)), G(new File(this.jtV)) });
      }
      ac.i("MicroMsg.AppBrand.AppBrandTransferTask", this.jtU + " -> " + this.jtV + " successful");
      localObject = new e(true, true);
      AppMethodBeat.o(187096);
      return localObject;
    }
    localObject = new File(this.jtV);
    if ((((File)localObject).exists()) && (((File)localObject).isDirectory())) {}
    try
    {
      a.jtQ.deleteDirectory((File)localObject);
      label718:
      ac.i("MicroMsg.AppBrand.AppBrandTransferTask", this.jtU + " -> " + this.jtV + " fail, try del target dir");
      localObject = new e(false, true, "move fail");
      AppMethodBeat.o(187096);
      return localObject;
    }
    catch (IOException localIOException)
    {
      break label718;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/appstorage/compatibility/AppBrandTransferTask$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.b.c
 * JD-Core Version:    0.7.0.1
 */