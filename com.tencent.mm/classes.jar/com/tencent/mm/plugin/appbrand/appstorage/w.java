package com.tencent.mm.plugin.appbrand.appstorage;

import android.text.TextUtils;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.regex.Pattern;
import org.apache.commons.a.b;

public final class w
  extends g
{
  public final String gZQ;
  public final String haj;
  public volatile long hak;
  private final w.b hal;
  private final w.b ham;
  private final w.a han;
  private final w.a hao;
  private final w.a hap;
  private final w.a haq;
  private final w.a har;
  private final w.b has;
  private final w.a hat;
  private final w.a hau;
  private final w.a hav;
  private final w.a haw;
  private final w.a hax;
  
  public w(String paramString)
  {
    this(paramString, "file:///usr");
  }
  
  public w(String paramString1, String paramString2)
  {
    AppMethodBeat.i(105453);
    this.hak = -1L;
    this.hal = new w.1(this);
    this.ham = new w.6(this);
    this.han = new w.7(this);
    this.hao = new w.8(this);
    this.hap = new w.9(this);
    this.haq = new w.10(this);
    this.har = new w.11(this);
    this.has = new w.12(this);
    this.hat = new w.13(this);
    this.hau = new w.2(this);
    this.hav = new w.3(this);
    this.haw = new w.4(this);
    this.hax = new w.5(this);
    this.gZQ = paramString1;
    this.haj = paramString2;
    d.i("MicroMsg.LuggageNonFlattenedFileSystem", "mRootPath:%s mPathPrefix:%s", new Object[] { this.gZQ, this.haj });
    AppMethodBeat.o(105453);
  }
  
  private j a(String paramString, w.a parama, boolean paramBoolean, Object... paramVarArgs)
  {
    AppMethodBeat.i(105458);
    if (bo.isNullOrNil(paramString))
    {
      paramString = j.gZE;
      AppMethodBeat.o(105458);
      return paramString;
    }
    paramString = k.zk(paramString.replaceFirst(Pattern.quote(this.haj), ""));
    File localFile = awP();
    if (localFile == null)
    {
      paramString = j.gZC;
      AppMethodBeat.o(105458);
      return paramString;
    }
    paramString = b.jE(localFile.getAbsolutePath(), paramString);
    if (bo.isNullOrNil(paramString))
    {
      paramString = j.gZE;
      AppMethodBeat.o(105458);
      return paramString;
    }
    paramString = new File(paramString);
    localFile = awP();
    if ((localFile != null) && (e(localFile, paramString))) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramString = j.gZE;
      AppMethodBeat.o(105458);
      return paramString;
    }
    if ((!paramBoolean) && (!paramString.getParentFile().exists()))
    {
      paramString = j.gZD;
      AppMethodBeat.o(105458);
      return paramString;
    }
    paramString = parama.a(paramString, paramVarArgs);
    AppMethodBeat.o(105458);
    return paramString;
  }
  
  private j a(String paramString, w.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(105459);
    paramString = a(paramString, parama, false, paramVarArgs);
    AppMethodBeat.o(105459);
    return paramString;
  }
  
  private static boolean e(File paramFile1, File paramFile2)
  {
    AppMethodBeat.i(105460);
    while (paramFile2 != null)
    {
      if (paramFile1.equals(paramFile2))
      {
        AppMethodBeat.o(105460);
        return true;
      }
      paramFile2 = paramFile2.getParentFile();
    }
    AppMethodBeat.o(105460);
    return false;
  }
  
  public final j Y(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(105463);
    paramString = a(paramString, this.han, paramBoolean, new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(105463);
    return paramString;
  }
  
  public final j Z(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(105464);
    paramString = a(paramString, this.hao, paramBoolean, new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(105464);
    return paramString;
  }
  
  public final j a(com.tencent.mm.plugin.appbrand.s.j<String> paramj)
  {
    return j.gZO;
  }
  
  public final j a(File paramFile, String paramString, com.tencent.mm.plugin.appbrand.s.j<String> paramj)
  {
    AppMethodBeat.i(105474);
    if (!bL(paramString))
    {
      paramFile = j.gZO;
      AppMethodBeat.o(105474);
      return paramFile;
    }
    if ((paramFile == null) || (!paramFile.exists()))
    {
      paramFile = j.gZB;
      AppMethodBeat.o(105474);
      return paramFile;
    }
    if (TextUtils.isEmpty(paramString))
    {
      paramFile = j.gZO;
      AppMethodBeat.o(105474);
      return paramFile;
    }
    j localj = ze(paramString);
    Object localObject;
    if (localj != j.gZG)
    {
      localObject = localj;
      if (localj != j.gZI) {
        break label121;
      }
    }
    try
    {
      paramFile = a(paramString, new FileInputStream(paramFile), false);
      localObject = paramFile;
      if (paramj != null)
      {
        paramj.value = paramString;
        localObject = paramFile;
      }
      label121:
      AppMethodBeat.o(105474);
      return localObject;
    }
    catch (Exception paramFile)
    {
      paramFile = j.gZB;
      AppMethodBeat.o(105474);
    }
    return paramFile;
  }
  
  public final j a(File paramFile, String paramString, boolean paramBoolean, com.tencent.mm.plugin.appbrand.s.j<String> paramj)
  {
    return j.gZO;
  }
  
  public final j a(String paramString, FileStructStat paramFileStructStat)
  {
    AppMethodBeat.i(105469);
    paramString = a(paramString, this.hat, new Object[] { paramFileStructStat });
    AppMethodBeat.o(105469);
    return paramString;
  }
  
  public final j a(String paramString, com.tencent.mm.plugin.appbrand.s.j<List<h>> paramj)
  {
    AppMethodBeat.i(105465);
    paramString = a(paramString, this.hap, new Object[] { paramj });
    AppMethodBeat.o(105465);
    return paramString;
  }
  
  public final j a(String paramString, File paramFile, boolean paramBoolean)
  {
    AppMethodBeat.i(105471);
    paramString = a(paramString, this.hav, new Object[] { paramFile, Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(105471);
    return paramString;
  }
  
  public final j a(String paramString, InputStream paramInputStream, boolean paramBoolean)
  {
    AppMethodBeat.i(105467);
    if (paramInputStream == null)
    {
      paramString = j.gZB;
      AppMethodBeat.o(105467);
      return paramString;
    }
    paramString = a(paramString, this.har, new Object[] { paramInputStream, Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(105467);
    return paramString;
  }
  
  public final File aa(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(105472);
    Object localObject = new com.tencent.mm.plugin.appbrand.s.j();
    a(paramString, this.haw, new Object[] { localObject });
    localObject = (File)((com.tencent.mm.plugin.appbrand.s.j)localObject).value;
    if (localObject == null)
    {
      d.e("MicroMsg.LuggageNonFlattenedFileSystem", "getAbsoluteFile with path(%s), get null file", new Object[] { paramString });
      AppMethodBeat.o(105472);
      return null;
    }
    if (!((File)localObject).exists())
    {
      d.e("MicroMsg.LuggageNonFlattenedFileSystem", "getAbsoluteFile with path(%s), file not exists", new Object[] { paramString });
      AppMethodBeat.o(105472);
      return null;
    }
    if ((!paramBoolean) && (!((File)localObject).isFile()))
    {
      d.e("MicroMsg.LuggageNonFlattenedFileSystem", "getAbsoluteFile with path(%s), not a file", new Object[] { paramString });
      AppMethodBeat.o(105472);
      return null;
    }
    if (k.C((File)localObject))
    {
      d.e("MicroMsg.LuggageNonFlattenedFileSystem", "getAbsoluteFile with path(%s), symlink file", new Object[] { paramString });
      AppMethodBeat.o(105472);
      return null;
    }
    AppMethodBeat.o(105472);
    return localObject;
  }
  
  public final void awI()
  {
    AppMethodBeat.i(105456);
    File localFile = new File(this.gZQ);
    k.B(localFile);
    if (localFile.exists()) {
      localFile.delete();
    }
    AppMethodBeat.o(105456);
  }
  
  public final List<o.a> awJ()
  {
    return null;
  }
  
  final File awP()
  {
    AppMethodBeat.i(105457);
    if (TextUtils.isEmpty(this.gZQ))
    {
      AppMethodBeat.o(105457);
      return null;
    }
    File localFile = new File(this.gZQ);
    if ((localFile.exists()) && (localFile.isFile())) {
      localFile.delete();
    }
    localFile.mkdirs();
    try
    {
      new File(localFile.getPath() + "/.nomedia").createNewFile();
      label94:
      AppMethodBeat.o(105457);
      return localFile;
    }
    catch (Exception localException)
    {
      break label94;
    }
  }
  
  public final j b(String paramString, com.tencent.mm.plugin.appbrand.s.j<ByteBuffer> paramj)
  {
    AppMethodBeat.i(105466);
    paramString = a(paramString, this.haq, new Object[] { paramj });
    AppMethodBeat.o(105466);
    return paramString;
  }
  
  public final j b(String paramString, File paramFile)
  {
    AppMethodBeat.i(105473);
    paramString = a(paramString, this.hax, new Object[] { paramFile });
    AppMethodBeat.o(105473);
    return paramString;
  }
  
  public final boolean bL(String paramString)
  {
    AppMethodBeat.i(105454);
    boolean bool = bo.nullAsNil(paramString).startsWith(this.haj);
    AppMethodBeat.o(105454);
    return bool;
  }
  
  public final j h(String paramString, List<u> paramList)
  {
    AppMethodBeat.i(105470);
    paramString = a(paramString, this.hau, new Object[] { paramList });
    AppMethodBeat.o(105470);
    return paramString;
  }
  
  public final void initialize()
  {
    AppMethodBeat.i(105455);
    File localFile = awP();
    if ((localFile == null) || (!localFile.exists())) {
      d.e("MicroMsg.LuggageNonFlattenedFileSystem", "Initialization Failed");
    }
    AppMethodBeat.o(105455);
  }
  
  public final void release() {}
  
  public final j zd(String paramString)
  {
    AppMethodBeat.i(105461);
    paramString = a(paramString, this.hal, new Object[0]);
    AppMethodBeat.o(105461);
    return paramString;
  }
  
  public final j ze(String paramString)
  {
    AppMethodBeat.i(105462);
    paramString = a(paramString, this.ham, new Object[0]);
    AppMethodBeat.o(105462);
    return paramString;
  }
  
  public final j zf(String paramString)
  {
    AppMethodBeat.i(105468);
    paramString = a(paramString, this.has, new Object[0]);
    AppMethodBeat.o(105468);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.w
 * JD-Core Version:    0.7.0.1
 */