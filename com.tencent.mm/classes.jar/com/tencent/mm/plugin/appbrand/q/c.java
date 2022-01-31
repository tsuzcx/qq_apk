package com.tencent.mm.plugin.appbrand.q;

import android.text.TextUtils;
import com.tencent.mm.a.e;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.io.IOException;

public final class c
{
  b haD = new b();
  public com.tencent.mm.sdk.b.c haE = new c.1(this);
  public com.tencent.mm.sdk.b.c haF = new c.2(this);
  public com.tencent.mm.sdk.b.c haG = new c.3(this);
  
  private static boolean d(File paramFile, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
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
      d locald = d.haJ;
      bool = d.cb((String)localObject, paramString);
      if (bool)
      {
        paramString = paramFile.getParent();
        int i = bk.gh((String)localObject, paramString);
        if (i < 0)
        {
          y.e("MicroMsg.WxaFTSSearchCore", "unzip fail, ret = %s, zipFilePath = %s, unzipPath = %s", new Object[] { Integer.valueOf(i), localObject, paramString });
          return false;
        }
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.WxaFTSSearchCore", localIOException, "create nomedia file error", new Object[0]);
      }
      y.i("MicroMsg.WxaFTSSearchCore", "unzip template files into dir(%s) successfully.", new Object[] { paramFile.getAbsolutePath() });
    }
    for (;;)
    {
      return bool;
      y.i("MicroMsg.WxaFTSSearchCore", "copy template file from asset fail %s", new Object[] { paramFile.getAbsolutePath() });
    }
  }
  
  static boolean f(File paramFile1, File paramFile2)
  {
    e.k(paramFile2);
    paramFile2.mkdirs();
    File localFile = new File(paramFile2, ".nomedia");
    if (!localFile.exists()) {}
    try
    {
      localFile.createNewFile();
      paramFile1 = paramFile1.getAbsolutePath();
      paramFile2 = paramFile2.getAbsolutePath();
      int i = bk.gh(paramFile1, paramFile2);
      if (i < 0)
      {
        y.e("MicroMsg.WxaFTSSearchCore", "unzip fail, ret = %s, zipFilePath = %s, unzipPath = ", new Object[] { Integer.valueOf(i), paramFile1, paramFile2 });
        return false;
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.WxaFTSSearchCore", localIOException, "create nomedia file error", new Object[0]);
      }
      y.i("MicroMsg.WxaFTSSearchCore", "Unzip Path : %s.", new Object[] { paramFile2 });
    }
    return true;
  }
  
  public final void prepare()
  {
    a.udP.c(this.haE);
    a.udP.c(this.haF);
    this.haG.cqo();
    refresh();
    File localFile = new File(this.haD.mRootPath);
    y.d("MicroMsg.WxaFTSSearchCore", "prepare(cv : %s, bv : %s)", new Object[] { Integer.valueOf(this.haD.mVersion), Integer.valueOf(65900182) });
    if ((this.haD.mVersion < 65900182) && (d(localFile, "wxa_fts_template.zip"))) {
      refresh();
    }
  }
  
  final void refresh()
  {
    b localb = this.haD;
    d locald = d.haJ;
    localb.mVersion = d.aoB();
    localb = this.haD;
    locald = d.haJ;
    localb.mRootPath = d.aoA();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.q.c
 * JD-Core Version:    0.7.0.1
 */