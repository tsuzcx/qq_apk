package com.tencent.mm.plugin.appbrand.p;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.io.IOException;

public final class c
{
  b iJf;
  public com.tencent.mm.sdk.b.c iJg;
  public com.tencent.mm.sdk.b.c iJh;
  public com.tencent.mm.sdk.b.c iJi;
  
  private c()
  {
    AppMethodBeat.i(132719);
    this.iJi = new c.3(this);
    this.iJf = new b();
    this.iJg = new c.1(this);
    this.iJh = new c.2(this);
    AppMethodBeat.o(132719);
  }
  
  private static boolean e(File paramFile, String paramString)
  {
    AppMethodBeat.i(132722);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(132722);
      return false;
    }
    if (!paramFile.exists()) {
      paramFile.mkdirs();
    }
    Object localObject = new File(paramFile, ".nomedia");
    if (!((File)localObject).exists()) {}
    boolean bool;
    try
    {
      ((File)localObject).createNewFile();
      paramFile = new File(paramFile, paramString);
      localObject = paramFile.getAbsolutePath();
      d locald = d.iJl;
      bool = d.cR((String)localObject, paramString);
      if (bool)
      {
        paramString = paramFile.getParent();
        int i = bo.ii((String)localObject, paramString);
        if (i < 0)
        {
          ab.e("MicroMsg.WxaFTSSearchCore", "unzip fail, ret = %s, zipFilePath = %s, unzipPath = %s", new Object[] { Integer.valueOf(i), localObject, paramString });
          AppMethodBeat.o(132722);
          return false;
        }
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.WxaFTSSearchCore", localIOException, "create nomedia file error", new Object[0]);
      }
      ab.i("MicroMsg.WxaFTSSearchCore", "unzip template files into dir(%s) successfully.", new Object[] { paramFile.getAbsolutePath() });
    }
    for (;;)
    {
      AppMethodBeat.o(132722);
      return bool;
      ab.i("MicroMsg.WxaFTSSearchCore", "copy template file from asset fail %s", new Object[] { paramFile.getAbsolutePath() });
    }
  }
  
  static boolean f(File paramFile1, File paramFile2)
  {
    AppMethodBeat.i(132723);
    e.o(paramFile2);
    paramFile2.mkdirs();
    File localFile = new File(paramFile2, ".nomedia");
    if (!localFile.exists()) {}
    try
    {
      localFile.createNewFile();
      paramFile1 = paramFile1.getAbsolutePath();
      paramFile2 = paramFile2.getAbsolutePath();
      int i = bo.ii(paramFile1, paramFile2);
      if (i < 0)
      {
        ab.e("MicroMsg.WxaFTSSearchCore", "unzip fail, ret = %s, zipFilePath = %s, unzipPath = ", new Object[] { Integer.valueOf(i), paramFile1, paramFile2 });
        AppMethodBeat.o(132723);
        return false;
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.WxaFTSSearchCore", localIOException, "create nomedia file error", new Object[0]);
      }
      ab.i("MicroMsg.WxaFTSSearchCore", "Unzip Path : %s.", new Object[] { paramFile2 });
      AppMethodBeat.o(132723);
    }
    return true;
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(132720);
    a.ymk.c(this.iJg);
    a.ymk.c(this.iJh);
    this.iJi.alive();
    refresh();
    File localFile = new File(this.iJf.gZQ);
    ab.d("MicroMsg.WxaFTSSearchCore", "prepare(cv : %s, bv : %s)", new Object[] { Integer.valueOf(this.iJf.cO), Integer.valueOf(65900182) });
    if ((this.iJf.cO < 65900182) && (e(localFile, "wxa_fts_template.zip"))) {
      refresh();
    }
    AppMethodBeat.o(132720);
  }
  
  final void refresh()
  {
    AppMethodBeat.i(132721);
    b localb = this.iJf;
    d locald = d.iJl;
    localb.cO = d.aLx();
    localb = this.iJf;
    locald = d.iJl;
    localb.gZQ = d.aLw();
    AppMethodBeat.o(132721);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.p.c
 * JD-Core Version:    0.7.0.1
 */