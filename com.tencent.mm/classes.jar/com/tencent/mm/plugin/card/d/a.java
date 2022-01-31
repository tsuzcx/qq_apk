package com.tencent.mm.plugin.card.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.c;
import com.tencent.mm.al.f;
import com.tencent.mm.i.g;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.j;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public final class a
{
  private static List<WeakReference<a.a>> kkV;
  
  static
  {
    AppMethodBeat.i(88808);
    kkV = new ArrayList();
    AppMethodBeat.o(88808);
  }
  
  public static void a(a.a parama)
  {
    AppMethodBeat.i(88805);
    if (kkV == null) {
      kkV = new ArrayList();
    }
    if (parama == null)
    {
      ab.e("MicroMsg.CDNDownloadHelpper", "ICDNDownloadCallback is null");
      AppMethodBeat.o(88805);
      return;
    }
    ab.i("MicroMsg.CDNDownloadHelpper", "register:%d", new Object[] { Integer.valueOf(parama.hashCode()) });
    kkV.add(new WeakReference(parama));
    AppMethodBeat.o(88805);
  }
  
  public static void b(a.a parama)
  {
    AppMethodBeat.i(88806);
    if ((kkV == null) || (parama == null))
    {
      AppMethodBeat.o(88806);
      return;
    }
    ab.i("MicroMsg.CDNDownloadHelpper", "unregister:%d", new Object[] { Integer.valueOf(parama.hashCode()) });
    int i = 0;
    while (i < kkV.size())
    {
      WeakReference localWeakReference = (WeakReference)kkV.get(i);
      if (localWeakReference != null)
      {
        a.a locala = (a.a)localWeakReference.get();
        if ((locala != null) && (locala.equals(parama)))
        {
          kkV.remove(localWeakReference);
          AppMethodBeat.o(88806);
          return;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(88806);
  }
  
  public static void h(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    int j = 0;
    int i = 0;
    AppMethodBeat.i(88807);
    if ((paramString1 == null) || (paramString2 == null) || (paramInt1 == 0))
    {
      ab.e("MicroMsg.CDNDownloadHelpper", "the params is wrongful");
      AppMethodBeat.o(88807);
      return;
    }
    Object localObject = ag.cE(paramString1);
    com.tencent.mm.vfs.b localb = new com.tencent.mm.vfs.b(m.knY);
    if (!localb.mkdirs()) {
      ab.i("MicroMsg.CDNDownloadHelpper", "mkdirs failed.File is exist = " + localb.exists());
    }
    if (paramInt2 == 2)
    {
      str = ".jpeg";
      if (!j.p(localb.dQJ()).endsWith("/")) {
        break label315;
      }
    }
    label315:
    for (String str = j.p(localb.dQJ()) + (String)localObject + str;; str = j.p(localb.dQJ()) + "/" + (String)localObject + str)
    {
      ab.i("MicroMsg.CDNDownloadHelpper", "get file path from capture file name : %s == %s", new Object[] { localObject, str });
      ab.i("MicroMsg.CDNDownloadHelpper", "before downloadVideoFromCDN fieldId:%s, aseKey:%s, dataLength:%d, type:%d, filePath:%s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str });
      ab.i("MicroMsg.CDNDownloadHelpper", "read file length = " + e.avI(str));
      if ((!e.cN(str)) || (e.avI(str) != paramInt1)) {
        break label362;
      }
      paramInt1 = i;
      while (paramInt1 < kkV.size())
      {
        paramString2 = (WeakReference)kkV.get(paramInt1);
        if (paramString2 != null)
        {
          paramString2 = (a.a)paramString2.get();
          if (paramString2 != null) {
            paramString2.du(paramString1, str);
          }
        }
        paramInt1 += 1;
      }
      str = ".mp4";
      break;
    }
    AppMethodBeat.o(88807);
    return;
    label362:
    ab.i("MicroMsg.CDNDownloadHelpper", "filePath:%s is't exist, so download from CDN", new Object[] { str });
    localObject = new g();
    ((g)localObject).edp = new a.1(paramString1, str);
    ((g)localObject).cMU = false;
    ((g)localObject).field_mediaId = c.a("cardgiftfile", bo.aoy(), paramString1, paramString1);
    ((g)localObject).field_fullpath = str;
    ((g)localObject).field_totalLen = paramInt1;
    ((g)localObject).field_fileType = com.tencent.mm.i.a.ecK;
    ((g)localObject).field_fileId = paramString1;
    ((g)localObject).field_aesKey = paramString2;
    ((g)localObject).field_priority = com.tencent.mm.i.a.ecF;
    ((g)localObject).field_needStorage = true;
    boolean bool = f.afO().b((g)localObject, -1);
    ab.i("MicroMsg.CDNDownloadHelpper", "add download cdn task : %b, fileId : %s", new Object[] { Boolean.valueOf(bool), ((g)localObject).field_fileId });
    if (!bool)
    {
      paramInt1 = j;
      while (paramInt1 < kkV.size())
      {
        paramString2 = (WeakReference)kkV.get(paramInt1);
        if (paramString2 != null)
        {
          paramString2 = (a.a)paramString2.get();
          if (paramString2 != null) {
            paramString2.Ig(paramString1);
          }
        }
        paramInt1 += 1;
      }
      ab.e("MicroMsg.CDNDownloadHelpper", "can't download from cdn!!!");
    }
    AppMethodBeat.o(88807);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.d.a
 * JD-Core Version:    0.7.0.1
 */