package com.tencent.mm.plugin.downloader.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.j;
import java.util.HashSet;
import java.util.Set;

public final class e
{
  private static Set<Long> kYo;
  
  static
  {
    AppMethodBeat.i(141063);
    kYo = new HashSet();
    AppMethodBeat.o(141063);
  }
  
  public static boolean K(String paramString1, String paramString2, String paramString3)
  {
    int i = 1;
    AppMethodBeat.i(141062);
    com.tencent.mm.vfs.b localb = new com.tencent.mm.vfs.b(paramString1);
    ab.i("MicroMsg.FileDownloadMD5Manager", "MD5 Check: %s, File Exists: %b", new Object[] { paramString1, Boolean.valueOf(localb.exists()) });
    long l1 = System.currentTimeMillis();
    paramString1 = com.tencent.mm.vfs.e.avP(j.p(localb.mUri));
    l1 = System.currentTimeMillis() - l1;
    ab.i("MicroMsg.FileDownloadMD5Manager", "MD5 Check Time: %d", new Object[] { Long.valueOf(l1) });
    ab.i("MicroMsg.FileDownloadMD5Manager", "Original MD5: %s, Calculated MD5: %s", new Object[] { paramString2, paramString1 });
    long l2;
    if (!bo.isNullOrNil(paramString3))
    {
      com.tencent.mm.plugin.downloader.g.a locala = d.JD(paramString3);
      if (locala != null)
      {
        l2 = locala.field_downloadId;
        if (!locala.field_reserveInWifi) {
          break label181;
        }
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.downloader.f.a.a(111, new com.tencent.mm.plugin.downloader.f.b(paramString3, l2, "", l1, i));
      if (!bo.isNullOrNil(paramString2)) {
        break;
      }
      bool = localb.exists();
      AppMethodBeat.o(141062);
      return bool;
      label181:
      i = 0;
    }
    if (bo.isNullOrNil(paramString1))
    {
      ab.i("MicroMsg.FileDownloadMD5Manager", "check from file failed, may caused by low memory while checking md5");
      bool = localb.exists();
      AppMethodBeat.o(141062);
      return bool;
    }
    boolean bool = paramString2.trim().equalsIgnoreCase(paramString1.trim());
    AppMethodBeat.o(141062);
    return bool;
  }
  
  public static void iL(long paramLong)
  {
    AppMethodBeat.i(141059);
    kYo.add(Long.valueOf(paramLong));
    AppMethodBeat.o(141059);
  }
  
  public static void iM(long paramLong)
  {
    AppMethodBeat.i(141060);
    kYo.remove(Long.valueOf(paramLong));
    AppMethodBeat.o(141060);
  }
  
  public static boolean iN(long paramLong)
  {
    AppMethodBeat.i(141061);
    boolean bool = kYo.contains(Long.valueOf(paramLong));
    AppMethodBeat.o(141061);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.e
 * JD-Core Version:    0.7.0.1
 */