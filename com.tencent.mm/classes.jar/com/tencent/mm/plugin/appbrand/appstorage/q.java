package com.tencent.mm.plugin.appbrand.appstorage;

import android.text.TextUtils;
import com.tencent.luggage.j.c;
import com.tencent.mm.plugin.appbrand.u.k;
import com.tencent.mm.sdk.platformtools.bk;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.regex.Pattern;
import org.a.a.a.a;

public class q
  extends e
{
  private final q.a fHA = new q.13(this);
  private final q.a fHB = new q.2(this);
  private final q.a fHC = new q.3(this);
  private final q.a fHD = new q.4(this);
  private final q.a fHE = new q.5(this);
  private final String fHq;
  public volatile long fHr = -1L;
  private final q.b fHs = new q.1(this);
  private final q.b fHt = new q.6(this);
  private final q.a fHu = new q.7(this);
  private final q.a fHv = new q.8(this);
  private final q.a fHw = new q.9(this);
  private final q.a fHx = new q.10(this);
  private final q.a fHy = new q.11(this);
  private final q.b fHz = new q.12(this);
  public final String mRootPath;
  
  public q(String paramString)
  {
    this(paramString, "file:///usr");
  }
  
  public q(String paramString1, String paramString2)
  {
    this.mRootPath = paramString1;
    this.fHq = paramString2;
  }
  
  private h a(String paramString, q.a parama, boolean paramBoolean, Object... paramVarArgs)
  {
    if (bk.bl(paramString)) {
      return h.fGY;
    }
    paramString = i.rz(paramString.replaceFirst(Pattern.quote(this.fHq), ""));
    File localFile = acJ();
    if (localFile == null) {
      return h.fGW;
    }
    paramString = a.gY(localFile.getAbsolutePath(), paramString);
    if (bk.bl(paramString)) {
      return h.fGY;
    }
    paramString = new File(paramString);
    localFile = acJ();
    if ((localFile != null) && (e(localFile, paramString))) {}
    for (int i = 1; i == 0; i = 0) {
      return h.fGY;
    }
    if ((!paramBoolean) && (!paramString.getParentFile().exists())) {
      return h.fGX;
    }
    return parama.a(paramString, paramVarArgs);
  }
  
  private h a(String paramString, q.a parama, Object... paramVarArgs)
  {
    return a(paramString, parama, false, paramVarArgs);
  }
  
  private File acJ()
  {
    if (TextUtils.isEmpty(this.mRootPath)) {
      return null;
    }
    File localFile = new File(this.mRootPath);
    if ((localFile.exists()) && (localFile.isFile())) {
      localFile.delete();
    }
    localFile.mkdirs();
    try
    {
      new File(localFile.getPath() + "/.nomedia").createNewFile();
      return localFile;
    }
    catch (Exception localException) {}
    return localFile;
  }
  
  private static boolean e(File paramFile1, File paramFile2)
  {
    while (paramFile2 != null)
    {
      if (paramFile1.equals(paramFile2)) {
        return true;
      }
      paramFile2 = paramFile2.getParentFile();
    }
    return false;
  }
  
  public final h U(String paramString, boolean paramBoolean)
  {
    return a(paramString, this.fHu, paramBoolean, new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public final h V(String paramString, boolean paramBoolean)
  {
    return a(paramString, this.fHv, paramBoolean, new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public final h a(k<String> paramk)
  {
    return h.fHi;
  }
  
  public final h a(File paramFile, String paramString, k<String> paramk)
  {
    Object localObject;
    if ((paramFile == null) || (!paramFile.exists())) {
      localObject = h.fGV;
    }
    for (;;)
    {
      return localObject;
      if (TextUtils.isEmpty(paramString)) {
        return h.fHi;
      }
      h localh = rv(paramString);
      if (localh != h.fHa)
      {
        localObject = localh;
        if (localh != h.fHc) {}
      }
      else
      {
        try
        {
          paramFile = a(paramString, new FileInputStream(paramFile), false);
          localObject = paramFile;
          if (paramk != null)
          {
            paramk.value = paramString;
            return paramFile;
          }
        }
        catch (Exception paramFile) {}
      }
    }
    return h.fGV;
  }
  
  public final h a(File paramFile, String paramString, boolean paramBoolean, k<String> paramk)
  {
    return h.fHi;
  }
  
  public final h a(String paramString, FileStructStat paramFileStructStat)
  {
    return a(paramString, this.fHA, new Object[] { paramFileStructStat });
  }
  
  public final h a(String paramString, k<List<f>> paramk)
  {
    return a(paramString, this.fHw, new Object[] { paramk });
  }
  
  public final h a(String paramString, File paramFile, boolean paramBoolean)
  {
    return a(paramString, this.fHC, new Object[] { paramFile, Boolean.valueOf(paramBoolean) });
  }
  
  public final h a(String paramString, InputStream paramInputStream, boolean paramBoolean)
  {
    if (paramInputStream == null) {
      return h.fGV;
    }
    return a(paramString, this.fHy, new Object[] { paramInputStream, Boolean.valueOf(paramBoolean) });
  }
  
  public final List<k.a> acI()
  {
    return null;
  }
  
  public final h b(String paramString, k<ByteBuffer> paramk)
  {
    return a(paramString, this.fHx, new Object[] { paramk });
  }
  
  public final h b(String paramString, File paramFile)
  {
    return a(paramString, this.fHE, new Object[] { paramFile });
  }
  
  public final boolean bs(String paramString)
  {
    return bk.pm(paramString).startsWith(this.fHq);
  }
  
  public final h g(String paramString, List<n> paramList)
  {
    return a(paramString, this.fHB, new Object[] { paramList });
  }
  
  public final void initialize()
  {
    File localFile = acJ();
    if ((localFile == null) || (!localFile.exists())) {
      c.e("MicroMsg.LuggageNonFlattenedFileSystem", "Initialization Failed");
    }
  }
  
  public final void release() {}
  
  public final h ru(String paramString)
  {
    return a(paramString, this.fHs, new Object[0]);
  }
  
  public final h rv(String paramString)
  {
    return a(paramString, this.fHt, new Object[0]);
  }
  
  public final h rw(String paramString)
  {
    return a(paramString, this.fHz, new Object[0]);
  }
  
  public final File rx(String paramString)
  {
    Object localObject = new k();
    a(paramString, this.fHD, new Object[] { localObject });
    File localFile = (File)((k)localObject).value;
    if (localFile == null)
    {
      c.e("MicroMsg.LuggageNonFlattenedFileSystem", "getAbsoluteFile with path(%s), get null file", new Object[] { paramString });
      localObject = null;
    }
    do
    {
      return localObject;
      if (!localFile.exists())
      {
        c.e("MicroMsg.LuggageNonFlattenedFileSystem", "getAbsoluteFile with path(%s), file not exists", new Object[] { paramString });
        return null;
      }
      if (!localFile.isFile())
      {
        c.e("MicroMsg.LuggageNonFlattenedFileSystem", "getAbsoluteFile with path(%s), not a file", new Object[] { paramString });
        return null;
      }
      localObject = localFile;
    } while (!i.w(localFile));
    c.e("MicroMsg.LuggageNonFlattenedFileSystem", "getAbsoluteFile with path(%s), symlink file", new Object[] { paramString });
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.q
 * JD-Core Version:    0.7.0.1
 */