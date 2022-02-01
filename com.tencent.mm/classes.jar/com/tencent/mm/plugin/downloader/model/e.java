package com.tencent.mm.plugin.downloader.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.c.b.q;
import com.tencent.mm.plugin.downloader.f.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.security.MessageDigest;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class e
{
  private static Set<Long> qIq;
  
  static
  {
    AppMethodBeat.i(88970);
    qIq = new HashSet();
    AppMethodBeat.o(88970);
  }
  
  public static boolean CA(long paramLong)
  {
    AppMethodBeat.i(88966);
    boolean bool = qIq.contains(Long.valueOf(paramLong));
    AppMethodBeat.o(88966);
    return bool;
  }
  
  public static void Cy(long paramLong)
  {
    AppMethodBeat.i(88964);
    qIq.add(Long.valueOf(paramLong));
    AppMethodBeat.o(88964);
  }
  
  public static void Cz(long paramLong)
  {
    AppMethodBeat.i(88965);
    qIq.remove(Long.valueOf(paramLong));
    AppMethodBeat.o(88965);
  }
  
  private static boolean c(String paramString, LinkedList<com.tencent.mm.plugin.downloader.c.b.a> paramLinkedList)
  {
    AppMethodBeat.i(88969);
    localObject = null;
    str = null;
    try
    {
      paramString = s.dB(paramString, false);
      str = paramString;
      localObject = paramString;
      localMessageDigest = MessageDigest.getInstance("MD5");
      str = paramString;
      localObject = paramString;
      paramLinkedList = paramLinkedList.iterator();
    }
    catch (Exception paramString)
    {
      MessageDigest localMessageDigest;
      com.tencent.mm.plugin.downloader.c.b.a locala;
      long l;
      int i;
      byte[] arrayOfByte;
      localObject = str;
      Log.printErrStackTrace("MicroMsg.FileDownloadMD5Manager", paramString, "", new Object[0]);
      if (str == null) {
        break label410;
      }
      for (;;)
      {
        try
        {
          str.close();
          bool1 = true;
        }
        catch (IOException paramString)
        {
          StringBuilder localStringBuilder;
          bool1 = true;
          continue;
        }
        AppMethodBeat.o(88969);
        return bool1;
        str = paramString;
        localObject = paramString;
        arrayOfByte = localMessageDigest.digest();
        if (arrayOfByte == null) {
          break;
        }
        str = paramString;
        localObject = paramString;
        localStringBuilder = new StringBuilder(32);
        i = 0;
        str = paramString;
        localObject = paramString;
        if (i < arrayOfByte.length)
        {
          str = paramString;
          localObject = paramString;
          localStringBuilder.append(Integer.toString((arrayOfByte[i] & 0xFF) + 256, 16).substring(1));
          i += 1;
        }
        else
        {
          str = paramString;
          localObject = paramString;
          bool1 = localStringBuilder.toString().trim().equals(locala.qGl);
          if (bool1) {
            break;
          }
          bool2 = false;
          bool1 = bool2;
          if (paramString != null) {
            try
            {
              paramString.close();
              bool1 = bool2;
            }
            catch (IOException paramString)
            {
              bool1 = bool2;
            }
          }
        }
      }
    }
    finally
    {
      for (;;)
      {
        if (localObject != null) {}
        try
        {
          ((RandomAccessFile)localObject).close();
          AppMethodBeat.o(88969);
          throw paramString;
        }
        catch (IOException paramLinkedList)
        {
          break label399;
        }
        boolean bool1 = true;
        continue;
        boolean bool2 = true;
      }
    }
    str = paramString;
    localObject = paramString;
    if (paramLinkedList.hasNext())
    {
      str = paramString;
      localObject = paramString;
      locala = (com.tencent.mm.plugin.downloader.c.b.a)paramLinkedList.next();
      str = paramString;
      localObject = paramString;
      paramString.seek(locala.qGj);
      str = paramString;
      localObject = paramString;
      l = locala.qGk - locala.qGj + 1L;
      str = paramString;
      localObject = paramString;
      i = (int)Math.min(2048L, l);
      str = paramString;
      localObject = paramString;
      arrayOfByte = new byte[i];
      while (l > 0L)
      {
        str = paramString;
        localObject = paramString;
        int j = paramString.read(arrayOfByte, 0, (int)Math.min(i, l));
        if (j < 0) {
          break;
        }
        l -= j;
        str = paramString;
        localObject = paramString;
        localMessageDigest.update(arrayOfByte, 0, j);
      }
    }
  }
  
  public static boolean f(com.tencent.mm.plugin.downloader.g.a parama)
  {
    int i = 1;
    AppMethodBeat.i(88967);
    if (parama.field_sectionMd5Byte == null)
    {
      String str2 = parama.field_filePath;
      String str1 = parama.field_md5;
      parama = parama.field_appId;
      o localo = new o(str2);
      Log.i("MicroMsg.FileDownloadMD5Manager", "MD5 Check: %s, File Exists: %b", new Object[] { str2, Boolean.valueOf(localo.exists()) });
      long l1 = System.currentTimeMillis();
      str2 = s.bhK(aa.z(localo.mUri));
      l1 = System.currentTimeMillis() - l1;
      Log.i("MicroMsg.FileDownloadMD5Manager", "MD5 Check Time: %d", new Object[] { Long.valueOf(l1) });
      Log.i("MicroMsg.FileDownloadMD5Manager", "Original MD5: %s, Calculated MD5: %s", new Object[] { str1, str2 });
      long l2;
      if (!Util.isNullOrNil(parama))
      {
        com.tencent.mm.plugin.downloader.g.a locala = d.alb(parama);
        if (locala != null)
        {
          l2 = locala.field_downloadId;
          if (!locala.field_reserveInWifi) {
            break label206;
          }
        }
      }
      for (;;)
      {
        com.tencent.mm.plugin.downloader.f.a.a(111, new b(parama, l2, "", l1, i));
        if (!Util.isNullOrNil(str1)) {
          break;
        }
        bool = localo.exists();
        AppMethodBeat.o(88967);
        return bool;
        label206:
        i = 0;
      }
      if (Util.isNullOrNil(str2))
      {
        Log.i("MicroMsg.FileDownloadMD5Manager", "check from file failed, may caused by low memory while checking md5");
        bool = localo.exists();
        AppMethodBeat.o(88967);
        return bool;
      }
      bool = str1.trim().equalsIgnoreCase(str2.trim());
      AppMethodBeat.o(88967);
      return bool;
    }
    boolean bool = g(parama);
    AppMethodBeat.o(88967);
    return bool;
  }
  
  public static boolean g(com.tencent.mm.plugin.downloader.g.a parama)
  {
    AppMethodBeat.i(88968);
    if ((parama == null) || (parama.field_sectionMd5Byte == null))
    {
      AppMethodBeat.o(88968);
      return true;
    }
    long l1 = System.currentTimeMillis();
    Object localObject = new q();
    try
    {
      ((q)localObject).parseFrom(parama.field_sectionMd5Byte);
      boolean bool = c(parama.field_filePath, ((q)localObject).qGz);
      l1 = System.currentTimeMillis() - l1;
      Log.i("MicroMsg.FileDownloadMD5Manager", "sectionMd5Check, costTime = %d, ret = %b", new Object[] { Long.valueOf(l1), Boolean.valueOf(bool) });
      localObject = parama.field_appId;
      long l2 = parama.field_downloadId;
      if (parama.field_reserveInWifi) {}
      for (int i = 1;; i = 0)
      {
        com.tencent.mm.plugin.downloader.f.a.a(111, new b((String)localObject, l2, "", l1, i));
        AppMethodBeat.o(88968);
        return bool;
      }
      return true;
    }
    catch (IOException parama)
    {
      Log.printErrStackTrace("MicroMsg.FileDownloadMD5Manager", parama, "", new Object[0]);
      AppMethodBeat.o(88968);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.e
 * JD-Core Version:    0.7.0.1
 */