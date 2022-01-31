package com.tencent.mm.plugin.card.d;

import com.tencent.mm.ak.c;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.j;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public final class a
{
  private static List<WeakReference<a.a>> fKm = new ArrayList();
  
  public static void a(a.a parama)
  {
    if (fKm == null) {
      fKm = new ArrayList();
    }
    if (parama == null)
    {
      y.e("MicroMsg.CDNDownloadHelpper", "ICDNDownloadCallback is null");
      return;
    }
    y.i("MicroMsg.CDNDownloadHelpper", "register:%d", new Object[] { Integer.valueOf(parama.hashCode()) });
    fKm.add(new WeakReference(parama));
  }
  
  public static void b(a.a parama)
  {
    if ((fKm == null) || (parama == null)) {}
    for (;;)
    {
      return;
      y.i("MicroMsg.CDNDownloadHelpper", "unregister:%d", new Object[] { Integer.valueOf(parama.hashCode()) });
      int i = 0;
      while (i < fKm.size())
      {
        WeakReference localWeakReference = (WeakReference)fKm.get(i);
        if (localWeakReference != null)
        {
          a.a locala = (a.a)localWeakReference.get();
          if ((locala != null) && (locala.equals(parama)))
          {
            fKm.remove(localWeakReference);
            return;
          }
        }
        i += 1;
      }
    }
  }
  
  public static void g(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    int j = 0;
    int i = 0;
    if ((paramString1 == null) || (paramString2 == null) || (paramInt1 == 0)) {
      y.e("MicroMsg.CDNDownloadHelpper", "the params is wrongful");
    }
    label86:
    label346:
    boolean bool;
    label305:
    do
    {
      return;
      Object localObject = ad.bB(paramString1);
      com.tencent.mm.vfs.b localb = new com.tencent.mm.vfs.b(m.ind);
      if (!localb.mkdirs()) {
        y.i("MicroMsg.CDNDownloadHelpper", "mkdirs failed.File is exist = " + localb.exists());
      }
      if (paramInt2 == 2)
      {
        str = ".jpeg";
        if (!j.n(localb.cLr()).endsWith("/")) {
          break label305;
        }
      }
      for (String str = j.n(localb.cLr()) + (String)localObject + str;; str = j.n(localb.cLr()) + "/" + (String)localObject + str)
      {
        y.i("MicroMsg.CDNDownloadHelpper", "get file path from capture file name : %s == %s", new Object[] { localObject, str });
        y.i("MicroMsg.CDNDownloadHelpper", "before downloadVideoFromCDN fieldId:%s, aseKey:%s, dataLength:%d, type:%d, filePath:%s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str });
        y.i("MicroMsg.CDNDownloadHelpper", "read file length = " + e.aeQ(str));
        if ((!e.bK(str)) || (e.aeQ(str) != paramInt1)) {
          break label346;
        }
        paramInt1 = i;
        while (paramInt1 < fKm.size())
        {
          paramString2 = (WeakReference)fKm.get(paramInt1);
          if (paramString2 != null)
          {
            paramString2 = (a.a)paramString2.get();
            if (paramString2 != null) {
              paramString2.cx(paramString1, str);
            }
          }
          paramInt1 += 1;
        }
        break;
        str = ".mp4";
        break label86;
      }
      y.i("MicroMsg.CDNDownloadHelpper", "filePath:%s is't exist, so download from CDN", new Object[] { str });
      localObject = new com.tencent.mm.j.f();
      ((com.tencent.mm.j.f)localObject).dlP = new a.1(paramString1, str);
      ((com.tencent.mm.j.f)localObject).ceg = false;
      ((com.tencent.mm.j.f)localObject).field_mediaId = c.a("cardgiftfile", bk.UY(), paramString1, paramString1);
      ((com.tencent.mm.j.f)localObject).field_fullpath = str;
      ((com.tencent.mm.j.f)localObject).field_totalLen = paramInt1;
      ((com.tencent.mm.j.f)localObject).field_fileType = com.tencent.mm.j.a.dlp;
      ((com.tencent.mm.j.f)localObject).field_fileId = paramString1;
      ((com.tencent.mm.j.f)localObject).field_aesKey = paramString2;
      ((com.tencent.mm.j.f)localObject).field_priority = com.tencent.mm.j.a.dlk;
      ((com.tencent.mm.j.f)localObject).field_needStorage = true;
      bool = com.tencent.mm.ak.f.Nd().b((com.tencent.mm.j.f)localObject, -1);
      y.i("MicroMsg.CDNDownloadHelpper", "add download cdn task : %b, fileId : %s", new Object[] { Boolean.valueOf(bool), ((com.tencent.mm.j.f)localObject).field_fileId });
    } while (bool);
    paramInt1 = j;
    while (paramInt1 < fKm.size())
    {
      paramString2 = (WeakReference)fKm.get(paramInt1);
      if (paramString2 != null)
      {
        paramString2 = (a.a)paramString2.get();
        if (paramString2 != null) {
          paramString2.fail(paramString1);
        }
      }
      paramInt1 += 1;
    }
    y.e("MicroMsg.CDNDownloadHelpper", "can't download from cdn!!!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.d.a
 * JD-Core Version:    0.7.0.1
 */