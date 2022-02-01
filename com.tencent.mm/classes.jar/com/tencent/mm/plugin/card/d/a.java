package com.tencent.mm.plugin.card.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.b;
import com.tencent.mm.an.f;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.i.g.a;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.w;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public final class a
{
  private static List<WeakReference<a>> oCX;
  
  static
  {
    AppMethodBeat.i(113736);
    oCX = new ArrayList();
    AppMethodBeat.o(113736);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(113733);
    if (oCX == null) {
      oCX = new ArrayList();
    }
    if (parama == null)
    {
      ae.e("MicroMsg.CDNDownloadHelpper", "ICDNDownloadCallback is null");
      AppMethodBeat.o(113733);
      return;
    }
    ae.i("MicroMsg.CDNDownloadHelpper", "register:%d", new Object[] { Integer.valueOf(parama.hashCode()) });
    oCX.add(new WeakReference(parama));
    AppMethodBeat.o(113733);
  }
  
  public static void b(a parama)
  {
    AppMethodBeat.i(113734);
    if ((oCX == null) || (parama == null))
    {
      AppMethodBeat.o(113734);
      return;
    }
    ae.i("MicroMsg.CDNDownloadHelpper", "unregister:%d", new Object[] { Integer.valueOf(parama.hashCode()) });
    int i = 0;
    while (i < oCX.size())
    {
      WeakReference localWeakReference = (WeakReference)oCX.get(i);
      if (localWeakReference != null)
      {
        a locala = (a)localWeakReference.get();
        if ((locala != null) && (locala.equals(parama)))
        {
          oCX.remove(localWeakReference);
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
      ae.e("MicroMsg.CDNDownloadHelpper", "the params is wrongful");
      AppMethodBeat.o(113735);
      return;
    }
    Object localObject = aj.ej(paramString1);
    k localk = new k(m.oGi);
    if (!localk.mkdirs()) {
      ae.i("MicroMsg.CDNDownloadHelpper", "mkdirs failed.File is exist = " + localk.exists());
    }
    if (paramInt2 == 2)
    {
      str = ".jpeg";
      if (!w.B(localk.fTh()).endsWith("/")) {
        break label315;
      }
    }
    label315:
    for (final String str = w.B(localk.fTh()) + (String)localObject + str;; str = w.B(localk.fTh()) + "/" + (String)localObject + str)
    {
      ae.i("MicroMsg.CDNDownloadHelpper", "get file path from capture file name : %s == %s", new Object[] { localObject, str });
      ae.i("MicroMsg.CDNDownloadHelpper", "before downloadVideoFromCDN fieldId:%s, aseKey:%s, dataLength:%d, type:%d, filePath:%s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str });
      ae.i("MicroMsg.CDNDownloadHelpper", "read file length = " + o.aZR(str));
      if ((!o.fB(str)) || (o.aZR(str) != paramInt1)) {
        break label362;
      }
      paramInt1 = i;
      while (paramInt1 < oCX.size())
      {
        paramString2 = (WeakReference)oCX.get(paramInt1);
        if (paramString2 != null)
        {
          paramString2 = (a)paramString2.get();
          if (paramString2 != null) {
            paramString2.ff(paramString1, str);
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
    ae.i("MicroMsg.CDNDownloadHelpper", "filePath:%s is't exist, so download from CDN", new Object[] { str });
    localObject = new g();
    ((g)localObject).fLl = "task_CDNDownloadHelpper";
    ((g)localObject).fLm = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(113730);
        if (paramAnonymousInt == -21005)
        {
          ae.i("MicroMsg.CDNDownloadHelpper", "duplicate request, ignore this request, media id is %s", new Object[] { paramAnonymousString });
          AppMethodBeat.o(113730);
          return 0;
        }
        if (paramAnonymousInt != 0)
        {
          ae.e("MicroMsg.CDNDownloadHelpper", "start failed : %d, media id is :%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          paramAnonymousInt = 0;
          while (paramAnonymousInt < a.oCX.size())
          {
            paramAnonymousString = (WeakReference)a.oCX.get(paramAnonymousInt);
            if (paramAnonymousString != null)
            {
              paramAnonymousString = (a.a)paramAnonymousString.get();
              if (paramAnonymousString != null) {
                paramAnonymousString.ZC(this.iwp);
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
          ae.i("MicroMsg.CDNDownloadHelpper", "progressInfo : %s", new Object[] { paramAnonymousc.toString() });
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
            if (paramAnonymousInt < a.oCX.size())
            {
              paramAnonymousString = (WeakReference)a.oCX.get(paramAnonymousInt);
              if (paramAnonymousString != null)
              {
                paramAnonymousString = (a.a)paramAnonymousString.get();
                if (paramAnonymousString != null) {
                  paramAnonymousString.cJ(this.iwp, (int)l);
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
              ae.e("MicroMsg.CDNDownloadHelpper", "cdntra clientid:%s , sceneResult.retCode:%d , sceneResult[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousd.field_retCode), paramAnonymousd });
              paramAnonymousInt = 0;
              while (paramAnonymousInt < a.oCX.size())
              {
                paramAnonymousString = (WeakReference)a.oCX.get(paramAnonymousInt);
                if (paramAnonymousString != null)
                {
                  paramAnonymousString = (a.a)paramAnonymousString.get();
                  if (paramAnonymousString != null) {
                    paramAnonymousString.ZC(this.iwp);
                  }
                }
                paramAnonymousInt += 1;
              }
            }
            ae.i("MicroMsg.CDNDownloadHelpper", "cdn trans suceess, sceneResult[%s]", new Object[] { paramAnonymousd });
            paramAnonymousInt = 0;
            while (paramAnonymousInt < a.oCX.size())
            {
              paramAnonymousString = (WeakReference)a.oCX.get(paramAnonymousInt);
              if (paramAnonymousString != null)
              {
                paramAnonymousString = (a.a)paramAnonymousString.get();
                if (paramAnonymousString != null) {
                  paramAnonymousString.ff(this.iwp, str);
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
        ae.i("MicroMsg.CDNDownloadHelpper", "getCdnAuthInfo, mediaId = %s", new Object[] { paramAnonymousString });
        AppMethodBeat.o(113731);
      }
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(113732);
        ae.i("MicroMsg.CDNDownloadHelpper", "decodePrepareResponse, mediaId = %s", new Object[] { paramAnonymousString });
        AppMethodBeat.o(113732);
        return null;
      }
    };
    ((g)localObject).dPh = false;
    ((g)localObject).field_mediaId = com.tencent.mm.an.c.a("cardgiftfile", bu.fpO(), paramString1, paramString1);
    ((g)localObject).field_fullpath = str;
    ((g)localObject).field_totalLen = paramInt1;
    ((g)localObject).field_fileType = com.tencent.mm.i.a.fKG;
    ((g)localObject).field_fileId = paramString1;
    ((g)localObject).field_aesKey = paramString2;
    ((g)localObject).field_priority = com.tencent.mm.i.a.fKA;
    ((g)localObject).field_needStorage = true;
    boolean bool = f.aGZ().b((g)localObject, -1);
    ae.i("MicroMsg.CDNDownloadHelpper", "add download cdn task : %b, fileId : %s", new Object[] { Boolean.valueOf(bool), ((g)localObject).field_fileId });
    if (!bool)
    {
      paramInt1 = j;
      while (paramInt1 < oCX.size())
      {
        paramString2 = (WeakReference)oCX.get(paramInt1);
        if (paramString2 != null)
        {
          paramString2 = (a)paramString2.get();
          if (paramString2 != null) {
            paramString2.ZC(paramString1);
          }
        }
        paramInt1 += 1;
      }
      ae.e("MicroMsg.CDNDownloadHelpper", "can't download from cdn!!!");
    }
    AppMethodBeat.o(113735);
  }
  
  public static abstract interface a
  {
    public abstract void ZC(String paramString);
    
    public abstract void cJ(String paramString, int paramInt);
    
    public abstract void ff(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.d.a
 * JD-Core Version:    0.7.0.1
 */