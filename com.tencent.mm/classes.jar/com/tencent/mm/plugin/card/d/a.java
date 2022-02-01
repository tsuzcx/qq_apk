package com.tencent.mm.plugin.card.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.b;
import com.tencent.mm.an.f;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.i.g.a;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import com.tencent.mm.vfs.q;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public final class a
{
  private static List<WeakReference<a>> nTa;
  
  static
  {
    AppMethodBeat.i(113736);
    nTa = new ArrayList();
    AppMethodBeat.o(113736);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(113733);
    if (nTa == null) {
      nTa = new ArrayList();
    }
    if (parama == null)
    {
      ac.e("MicroMsg.CDNDownloadHelpper", "ICDNDownloadCallback is null");
      AppMethodBeat.o(113733);
      return;
    }
    ac.i("MicroMsg.CDNDownloadHelpper", "register:%d", new Object[] { Integer.valueOf(parama.hashCode()) });
    nTa.add(new WeakReference(parama));
    AppMethodBeat.o(113733);
  }
  
  public static void b(a parama)
  {
    AppMethodBeat.i(113734);
    if ((nTa == null) || (parama == null))
    {
      AppMethodBeat.o(113734);
      return;
    }
    ac.i("MicroMsg.CDNDownloadHelpper", "unregister:%d", new Object[] { Integer.valueOf(parama.hashCode()) });
    int i = 0;
    while (i < nTa.size())
    {
      WeakReference localWeakReference = (WeakReference)nTa.get(i);
      if (localWeakReference != null)
      {
        a locala = (a)localWeakReference.get();
        if ((locala != null) && (locala.equals(parama)))
        {
          nTa.remove(localWeakReference);
          AppMethodBeat.o(113734);
          return;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(113734);
  }
  
  public static void g(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    int j = 0;
    int i = 0;
    AppMethodBeat.i(113735);
    if ((paramString1 == null) || (paramString2 == null) || (paramInt1 == 0))
    {
      ac.e("MicroMsg.CDNDownloadHelpper", "the params is wrongful");
      AppMethodBeat.o(113735);
      return;
    }
    Object localObject = ah.dg(paramString1);
    e locale = new e(m.nWm);
    if (!locale.mkdirs()) {
      ac.i("MicroMsg.CDNDownloadHelpper", "mkdirs failed.File is exist = " + locale.exists());
    }
    if (paramInt2 == 2)
    {
      str = ".jpeg";
      if (!q.B(locale.fxV()).endsWith("/")) {
        break label315;
      }
    }
    label315:
    for (final String str = q.B(locale.fxV()) + (String)localObject + str;; str = q.B(locale.fxV()) + "/" + (String)localObject + str)
    {
      ac.i("MicroMsg.CDNDownloadHelpper", "get file path from capture file name : %s == %s", new Object[] { localObject, str });
      ac.i("MicroMsg.CDNDownloadHelpper", "before downloadVideoFromCDN fieldId:%s, aseKey:%s, dataLength:%d, type:%d, filePath:%s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str });
      ac.i("MicroMsg.CDNDownloadHelpper", "read file length = " + i.aSp(str));
      if ((!i.eA(str)) || (i.aSp(str) != paramInt1)) {
        break label362;
      }
      paramInt1 = i;
      while (paramInt1 < nTa.size())
      {
        paramString2 = (WeakReference)nTa.get(paramInt1);
        if (paramString2 != null)
        {
          paramString2 = (a)paramString2.get();
          if (paramString2 != null) {
            paramString2.eR(paramString1, str);
          }
        }
        paramInt1 += 1;
      }
      str = ".mp4";
      break;
    }
    AppMethodBeat.o(113735);
    return;
    label362:
    ac.i("MicroMsg.CDNDownloadHelpper", "filePath:%s is't exist, so download from CDN", new Object[] { str });
    localObject = new g();
    ((g)localObject).frb = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(113730);
        if (paramAnonymousInt == -21005)
        {
          ac.i("MicroMsg.CDNDownloadHelpper", "duplicate request, ignore this request, media id is %s", new Object[] { paramAnonymousString });
          AppMethodBeat.o(113730);
          return 0;
        }
        if (paramAnonymousInt != 0)
        {
          ac.e("MicroMsg.CDNDownloadHelpper", "start failed : %d, media id is :%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          paramAnonymousInt = 0;
          while (paramAnonymousInt < a.nTa.size())
          {
            paramAnonymousString = (WeakReference)a.nTa.get(paramAnonymousInt);
            if (paramAnonymousString != null)
            {
              paramAnonymousString = (a.a)paramAnonymousString.get();
              if (paramAnonymousString != null) {
                paramAnonymousString.Vc(this.iaa);
              }
            }
            paramAnonymousInt += 1;
          }
          AppMethodBeat.o(113730);
          return 0;
        }
        long l;
        if (paramAnonymousc != null)
        {
          ac.i("MicroMsg.CDNDownloadHelpper", "progressInfo : %s", new Object[] { paramAnonymousc.toString() });
          l = 0L;
          if (paramAnonymousc.field_toltalLength > 0L) {
            l = paramAnonymousc.field_finishedLength * 100L / paramAnonymousc.field_toltalLength;
          }
          if (l < 0L) {
            l = 0L;
          }
        }
        label464:
        for (;;)
        {
          paramAnonymousInt = 0;
          for (;;)
          {
            if (paramAnonymousInt < a.nTa.size())
            {
              paramAnonymousString = (WeakReference)a.nTa.get(paramAnonymousInt);
              if (paramAnonymousString != null)
              {
                paramAnonymousString = (a.a)paramAnonymousString.get();
                if (paramAnonymousString != null) {
                  paramAnonymousString.cC(this.iaa, (int)l);
                }
              }
              paramAnonymousInt += 1;
              continue;
              if (l <= 100L) {
                break label464;
              }
              l = 100L;
              break;
            }
          }
          AppMethodBeat.o(113730);
          return 0;
          if (paramAnonymousd != null)
          {
            if (paramAnonymousd.field_retCode != 0)
            {
              ac.e("MicroMsg.CDNDownloadHelpper", "cdntra clientid:%s , sceneResult.retCode:%d , sceneResult[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousd.field_retCode), paramAnonymousd });
              paramAnonymousInt = 0;
              while (paramAnonymousInt < a.nTa.size())
              {
                paramAnonymousString = (WeakReference)a.nTa.get(paramAnonymousInt);
                if (paramAnonymousString != null)
                {
                  paramAnonymousString = (a.a)paramAnonymousString.get();
                  if (paramAnonymousString != null) {
                    paramAnonymousString.Vc(this.iaa);
                  }
                }
                paramAnonymousInt += 1;
              }
            }
            ac.i("MicroMsg.CDNDownloadHelpper", "cdn trans suceess, sceneResult[%s]", new Object[] { paramAnonymousd });
            paramAnonymousInt = 0;
            while (paramAnonymousInt < a.nTa.size())
            {
              paramAnonymousString = (WeakReference)a.nTa.get(paramAnonymousInt);
              if (paramAnonymousString != null)
              {
                paramAnonymousString = (a.a)paramAnonymousString.get();
                if (paramAnonymousString != null) {
                  paramAnonymousString.eR(this.iaa, str);
                }
              }
              paramAnonymousInt += 1;
            }
          }
          AppMethodBeat.o(113730);
          return 0;
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream)
      {
        AppMethodBeat.i(113731);
        ac.i("MicroMsg.CDNDownloadHelpper", "getCdnAuthInfo, mediaId = %s", new Object[] { paramAnonymousString });
        AppMethodBeat.o(113731);
      }
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(113732);
        ac.i("MicroMsg.CDNDownloadHelpper", "decodePrepareResponse, mediaId = %s", new Object[] { paramAnonymousString });
        AppMethodBeat.o(113732);
        return null;
      }
    };
    ((g)localObject).dBE = false;
    ((g)localObject).field_mediaId = com.tencent.mm.an.c.a("cardgiftfile", bs.eWj(), paramString1, paramString1);
    ((g)localObject).field_fullpath = str;
    ((g)localObject).field_totalLen = paramInt1;
    ((g)localObject).field_fileType = com.tencent.mm.i.a.fqv;
    ((g)localObject).field_fileId = paramString1;
    ((g)localObject).field_aesKey = paramString2;
    ((g)localObject).field_priority = com.tencent.mm.i.a.fqp;
    ((g)localObject).field_needStorage = true;
    boolean bool = f.aDD().b((g)localObject, -1);
    ac.i("MicroMsg.CDNDownloadHelpper", "add download cdn task : %b, fileId : %s", new Object[] { Boolean.valueOf(bool), ((g)localObject).field_fileId });
    if (!bool)
    {
      paramInt1 = j;
      while (paramInt1 < nTa.size())
      {
        paramString2 = (WeakReference)nTa.get(paramInt1);
        if (paramString2 != null)
        {
          paramString2 = (a)paramString2.get();
          if (paramString2 != null) {
            paramString2.Vc(paramString1);
          }
        }
        paramInt1 += 1;
      }
      ac.e("MicroMsg.CDNDownloadHelpper", "can't download from cdn!!!");
    }
    AppMethodBeat.o(113735);
  }
  
  public static abstract interface a
  {
    public abstract void Vc(String paramString);
    
    public abstract void cC(String paramString, int paramInt);
    
    public abstract void eR(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.d.a
 * JD-Core Version:    0.7.0.1
 */