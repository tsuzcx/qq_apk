package com.tencent.mm.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tinker.entry.ApplicationLike;
import com.tencent.tinker.lib.e.b;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import java.io.File;
import java.util.HashMap;

public final class s
{
  static ApplicationLike dks;
  static String dlj = "";
  String dlk;
  String dll;
  long dlm;
  long dln;
  
  public s(ApplicationLike paramApplicationLike)
  {
    dks = paramApplicationLike;
    d.dks = paramApplicationLike;
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
        a.ict = (String)paramApplicationLike.get("patch.rev");
        a.icu = (String)paramApplicationLike.get("NEW_TINKER_ID");
        Log.w("MicroMsg.MMApplicationLikeImpl", "application set patch rev:%s patch tinkerId:%s ", new Object[] { a.ict, a.icu });
      }
      AppMethodBeat.o(125024);
      return;
    }
  }
  
  static String gd(String paramString)
  {
    AppMethodBeat.i(125025);
    try
    {
      File localFile = SharePatchFileUtil.getPatchDirectory(dks.getApplication());
      String str = SharePatchFileUtil.getPatchVersionDirectory(b.d(dks));
      localFile = new File(localFile.getAbsolutePath(), str);
      paramString = new File(localFile.getAbsolutePath() + "/lib/lib/" + paramString).getAbsolutePath();
      AppMethodBeat.o(125025);
      return paramString;
    }
    catch (Throwable paramString)
    {
      Log.printErrStackTrace("MicroMsg.MMApplicationLikeImpl", paramString, "[-] Fail to get patched native libs path.", new Object[0]);
      AppMethodBeat.o(125025);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.s
 * JD-Core Version:    0.7.0.1
 */