package com.tencent.mm.plugin.card.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ao.b;
import com.tencent.mm.ao.f;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.i.g.a;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import com.tencent.mm.vfs.q;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public final class a
{
  private static List<WeakReference<a>> owv;
  
  static
  {
    AppMethodBeat.i(113736);
    owv = new ArrayList();
    AppMethodBeat.o(113736);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(113733);
    if (owv == null) {
      owv = new ArrayList();
    }
    if (parama == null)
    {
      ad.e("MicroMsg.CDNDownloadHelpper", "ICDNDownloadCallback is null");
      AppMethodBeat.o(113733);
      return;
    }
    ad.i("MicroMsg.CDNDownloadHelpper", "register:%d", new Object[] { Integer.valueOf(parama.hashCode()) });
    owv.add(new WeakReference(parama));
    AppMethodBeat.o(113733);
  }
  
  public static void b(a parama)
  {
    AppMethodBeat.i(113734);
    if ((owv == null) || (parama == null))
    {
      AppMethodBeat.o(113734);
      return;
    }
    ad.i("MicroMsg.CDNDownloadHelpper", "unregister:%d", new Object[] { Integer.valueOf(parama.hashCode()) });
    int i = 0;
    while (i < owv.size())
    {
      WeakReference localWeakReference = (WeakReference)owv.get(i);
      if (localWeakReference != null)
      {
        a locala = (a)localWeakReference.get();
        if ((locala != null) && (locala.equals(parama)))
        {
          owv.remove(localWeakReference);
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
      ad.e("MicroMsg.CDNDownloadHelpper", "the params is wrongful");
      AppMethodBeat.o(113735);
      return;
    }
    Object localObject = ai.ee(paramString1);
    e locale = new e(m.ozG);
    if (!locale.mkdirs()) {
      ad.i("MicroMsg.CDNDownloadHelpper", "mkdirs failed.File is exist = " + locale.exists());
    }
    if (paramInt2 == 2)
    {
      str = ".jpeg";
      if (!q.B(locale.fOK()).endsWith("/")) {
        break label315;
      }
    }
    label315:
    for (final String str = q.B(locale.fOK()) + (String)localObject + str;; str = q.B(locale.fOK()) + "/" + (String)localObject + str)
    {
      ad.i("MicroMsg.CDNDownloadHelpper", "get file path from capture file name : %s == %s", new Object[] { localObject, str });
      ad.i("MicroMsg.CDNDownloadHelpper", "before downloadVideoFromCDN fieldId:%s, aseKey:%s, dataLength:%d, type:%d, filePath:%s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str });
      ad.i("MicroMsg.CDNDownloadHelpper", "read file length = " + i.aYo(str));
      if ((!i.fv(str)) || (i.aYo(str) != paramInt1)) {
        break label362;
      }
      paramInt1 = i;
      while (paramInt1 < owv.size())
      {
        paramString2 = (WeakReference)owv.get(paramInt1);
        if (paramString2 != null)
        {
          paramString2 = (a)paramString2.get();
          if (paramString2 != null) {
            paramString2.fb(paramString1, str);
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
    ad.i("MicroMsg.CDNDownloadHelpper", "filePath:%s is't exist, so download from CDN", new Object[] { str });
    localObject = new g();
    ((g)localObject).fJi = "task_CDNDownloadHelpper";
    ((g)localObject).fJj = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(113730);
        if (paramAnonymousInt == -21005)
        {
          ad.i("MicroMsg.CDNDownloadHelpper", "duplicate request, ignore this request, media id is %s", new Object[] { paramAnonymousString });
          AppMethodBeat.o(113730);
          return 0;
        }
        if (paramAnonymousInt != 0)
        {
          ad.e("MicroMsg.CDNDownloadHelpper", "start failed : %d, media id is :%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          paramAnonymousInt = 0;
          while (paramAnonymousInt < a.owv.size())
          {
            paramAnonymousString = (WeakReference)a.owv.get(paramAnonymousInt);
            if (paramAnonymousString != null)
            {
              paramAnonymousString = (a.a)paramAnonymousString.get();
              if (paramAnonymousString != null) {
                paramAnonymousString.YL(this.itv);
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
          ad.i("MicroMsg.CDNDownloadHelpper", "progressInfo : %s", new Object[] { paramAnonymousc.toString() });
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
            if (paramAnonymousInt < a.owv.size())
            {
              paramAnonymousString = (WeakReference)a.owv.get(paramAnonymousInt);
              if (paramAnonymousString != null)
              {
                paramAnonymousString = (a.a)paramAnonymousString.get();
                if (paramAnonymousString != null) {
                  paramAnonymousString.cF(this.itv, (int)l);
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
              ad.e("MicroMsg.CDNDownloadHelpper", "cdntra clientid:%s , sceneResult.retCode:%d , sceneResult[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousd.field_retCode), paramAnonymousd });
              paramAnonymousInt = 0;
              while (paramAnonymousInt < a.owv.size())
              {
                paramAnonymousString = (WeakReference)a.owv.get(paramAnonymousInt);
                if (paramAnonymousString != null)
                {
                  paramAnonymousString = (a.a)paramAnonymousString.get();
                  if (paramAnonymousString != null) {
                    paramAnonymousString.YL(this.itv);
                  }
                }
                paramAnonymousInt += 1;
              }
            }
            ad.i("MicroMsg.CDNDownloadHelpper", "cdn trans suceess, sceneResult[%s]", new Object[] { paramAnonymousd });
            paramAnonymousInt = 0;
            while (paramAnonymousInt < a.owv.size())
            {
              paramAnonymousString = (WeakReference)a.owv.get(paramAnonymousInt);
              if (paramAnonymousString != null)
              {
                paramAnonymousString = (a.a)paramAnonymousString.get();
                if (paramAnonymousString != null) {
                  paramAnonymousString.fb(this.itv, str);
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
        ad.i("MicroMsg.CDNDownloadHelpper", "getCdnAuthInfo, mediaId = %s", new Object[] { paramAnonymousString });
        AppMethodBeat.o(113731);
      }
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(113732);
        ad.i("MicroMsg.CDNDownloadHelpper", "decodePrepareResponse, mediaId = %s", new Object[] { paramAnonymousString });
        AppMethodBeat.o(113732);
        return null;
      }
    };
    ((g)localObject).dNR = false;
    ((g)localObject).field_mediaId = com.tencent.mm.ao.c.a("cardgiftfile", bt.flT(), paramString1, paramString1);
    ((g)localObject).field_fullpath = str;
    ((g)localObject).field_totalLen = paramInt1;
    ((g)localObject).field_fileType = com.tencent.mm.i.a.fIC;
    ((g)localObject).field_fileId = paramString1;
    ((g)localObject).field_aesKey = paramString2;
    ((g)localObject).field_priority = com.tencent.mm.i.a.fIw;
    ((g)localObject).field_needStorage = true;
    boolean bool = f.aGI().b((g)localObject, -1);
    ad.i("MicroMsg.CDNDownloadHelpper", "add download cdn task : %b, fileId : %s", new Object[] { Boolean.valueOf(bool), ((g)localObject).field_fileId });
    if (!bool)
    {
      paramInt1 = j;
      while (paramInt1 < owv.size())
      {
        paramString2 = (WeakReference)owv.get(paramInt1);
        if (paramString2 != null)
        {
          paramString2 = (a)paramString2.get();
          if (paramString2 != null) {
            paramString2.YL(paramString1);
          }
        }
        paramInt1 += 1;
      }
      ad.e("MicroMsg.CDNDownloadHelpper", "can't download from cdn!!!");
    }
    AppMethodBeat.o(113735);
  }
  
  public static abstract interface a
  {
    public abstract void YL(String paramString);
    
    public abstract void cF(String paramString, int paramInt);
    
    public abstract void fb(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.d.a
 * JD-Core Version:    0.7.0.1
 */