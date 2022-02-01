package com.tencent.mm.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.tinker.entry.ApplicationLike;
import com.tencent.tinker.lib.e.b;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import java.io.File;
import java.util.HashMap;

public final class r
{
  static String cTS = "";
  static ApplicationLike cTo;
  String cTT;
  String cTU;
  long cTV;
  long cTW;
  
  public r(ApplicationLike paramApplicationLike)
  {
    cTo = paramApplicationLike;
    d.cTo = paramApplicationLike;
  }
  
  static final boolean D(File paramFile)
  {
    int i = 0;
    AppMethodBeat.i(175407);
    if ((paramFile == null) || (!paramFile.exists()))
    {
      AppMethodBeat.o(175407);
      return false;
    }
    if (paramFile.isDirectory())
    {
      paramFile = paramFile.listFiles();
      if (paramFile == null)
      {
        AppMethodBeat.o(175407);
        return false;
      }
      while (i < paramFile.length)
      {
        paramFile[i].delete();
        i += 1;
      }
      AppMethodBeat.o(175407);
      return true;
    }
    AppMethodBeat.o(175407);
    return false;
  }
  
  static void a(ApplicationLike paramApplicationLike)
  {
    AppMethodBeat.i(125024);
    if (paramApplicationLike == null)
    {
      AppMethodBeat.o(125024);
      return;
    }
    if ((paramApplicationLike == null) || (paramApplicationLike.getApplication() == null))
    {
      paramApplicationLike = new TinkerRuntimeException("tinkerApplication is null");
      AppMethodBeat.o(125024);
      throw paramApplicationLike;
    }
    paramApplicationLike = paramApplicationLike.getTinkerResultIntent();
    if ((paramApplicationLike != null) && (ShareIntentUtil.getIntentReturnCode(paramApplicationLike) == 0)) {}
    for (paramApplicationLike = ShareIntentUtil.getIntentPackageConfig(paramApplicationLike);; paramApplicationLike = null)
    {
      if (paramApplicationLike != null)
      {
        a.hgI = (String)paramApplicationLike.get("patch.rev");
        a.hgK = (String)paramApplicationLike.get("NEW_TINKER_ID");
        ad.w("MicroMsg.MMApplicationLikeImpl", "application set patch rev:%s patch tinkerId:%s ", new Object[] { a.hgI, a.hgK });
      }
      AppMethodBeat.o(125024);
      return;
    }
  }
  
  static String fj(String paramString)
  {
    AppMethodBeat.i(125025);
    try
    {
      File localFile = SharePatchFileUtil.getPatchDirectory(cTo.getApplication());
      String str = SharePatchFileUtil.getPatchVersionDirectory(b.e(cTo));
      localFile = new File(localFile.getAbsolutePath(), str);
      paramString = new File(localFile.getAbsolutePath() + "/lib/lib/" + paramString).getAbsolutePath();
      AppMethodBeat.o(125025);
      return paramString;
    }
    catch (Throwable paramString)
    {
      ad.printErrStackTrace("MicroMsg.MMApplicationLikeImpl", paramString, "[-] Fail to get patched native libs path.", new Object[0]);
      AppMethodBeat.o(125025);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.r
 * JD-Core Version:    0.7.0.1
 */