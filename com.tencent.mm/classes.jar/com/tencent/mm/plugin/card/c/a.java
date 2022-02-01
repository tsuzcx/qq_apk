package com.tencent.mm.plugin.card.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c;
import com.tencent.mm.g.d;
import com.tencent.mm.g.g.a;
import com.tencent.mm.modelcdntran.h;
import com.tencent.mm.modelcdntran.k;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public final class a
{
  private static List<WeakReference<a>> eNV;
  
  static
  {
    AppMethodBeat.i(113736);
    eNV = new ArrayList();
    AppMethodBeat.o(113736);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(113733);
    if (eNV == null) {
      eNV = new ArrayList();
    }
    if (parama == null)
    {
      Log.e("MicroMsg.CDNDownloadHelpper", "ICDNDownloadCallback is null");
      AppMethodBeat.o(113733);
      return;
    }
    Log.i("MicroMsg.CDNDownloadHelpper", "register:%d", new Object[] { Integer.valueOf(parama.hashCode()) });
    eNV.add(new WeakReference(parama));
    AppMethodBeat.o(113733);
  }
  
  public static void b(a parama)
  {
    AppMethodBeat.i(113734);
    if ((eNV == null) || (parama == null))
    {
      AppMethodBeat.o(113734);
      return;
    }
    Log.i("MicroMsg.CDNDownloadHelpper", "unregister:%d", new Object[] { Integer.valueOf(parama.hashCode()) });
    int i = 0;
    while (i < eNV.size())
    {
      WeakReference localWeakReference = (WeakReference)eNV.get(i);
      if (localWeakReference != null)
      {
        a locala = (a)localWeakReference.get();
        if ((locala != null) && (locala.equals(parama)))
        {
          eNV.remove(localWeakReference);
          AppMethodBeat.o(113734);
          return;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(113734);
  }
  
  public static void h(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    int j = 0;
    int i = 0;
    AppMethodBeat.i(113735);
    if ((paramString1 == null) || (paramString2 == null) || (paramInt1 == 0))
    {
      Log.e("MicroMsg.CDNDownloadHelpper", "the params is wrongful");
      AppMethodBeat.o(113735);
      return;
    }
    Object localObject = MD5Util.getMD5String(paramString1);
    u localu = new u(m.wuo);
    if (!localu.jKY()) {
      Log.i("MicroMsg.CDNDownloadHelpper", "mkdirs failed.File is exist = " + localu.jKS());
    }
    if (paramInt2 == 2)
    {
      str = ".jpeg";
      if (!ah.v(localu.jKT()).endsWith("/")) {
        break label315;
      }
    }
    label315:
    for (final String str = ah.v(localu.jKT()) + (String)localObject + str;; str = ah.v(localu.jKT()) + "/" + (String)localObject + str)
    {
      Log.i("MicroMsg.CDNDownloadHelpper", "get file path from capture file name : %s == %s", new Object[] { localObject, str });
      Log.i("MicroMsg.CDNDownloadHelpper", "before downloadVideoFromCDN fieldId:%s, aseKey:%s, dataLength:%d, type:%d, filePath:%s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str });
      Log.i("MicroMsg.CDNDownloadHelpper", "read file length = " + y.bEl(str));
      if ((!y.ZC(str)) || (y.bEl(str) != paramInt1)) {
        break label362;
      }
      paramInt1 = i;
      while (paramInt1 < eNV.size())
      {
        paramString2 = (WeakReference)eNV.get(paramInt1);
        if (paramString2 != null)
        {
          paramString2 = (a)paramString2.get();
          if (paramString2 != null) {
            paramString2.gj(paramString1, str);
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
    Log.i("MicroMsg.CDNDownloadHelpper", "filePath:%s is't exist, so download from CDN", new Object[] { str });
    localObject = new com.tencent.mm.g.g();
    ((com.tencent.mm.g.g)localObject).taskName = "task_CDNDownloadHelpper";
    ((com.tencent.mm.g.g)localObject).lwL = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, c paramAnonymousc, d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(113730);
        if (paramAnonymousInt == -21005)
        {
          Log.i("MicroMsg.CDNDownloadHelpper", "duplicate request, ignore this request, media id is %s", new Object[] { paramAnonymousString });
          AppMethodBeat.o(113730);
          return 0;
        }
        if (paramAnonymousInt != 0)
        {
          Log.e("MicroMsg.CDNDownloadHelpper", "start failed : %d, media id is :%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          paramAnonymousInt = 0;
          while (paramAnonymousInt < a.eNV.size())
          {
            paramAnonymousString = (WeakReference)a.eNV.get(paramAnonymousInt);
            if (paramAnonymousString != null)
            {
              paramAnonymousString = (a.a)paramAnonymousString.get();
              if (paramAnonymousString != null) {
                paramAnonymousString.akZ(a.this);
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
          Log.i("MicroMsg.CDNDownloadHelpper", "progressInfo : %s", new Object[] { paramAnonymousc.toString() });
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
            if (paramAnonymousInt < a.eNV.size())
            {
              paramAnonymousString = (WeakReference)a.eNV.get(paramAnonymousInt);
              if (paramAnonymousString != null)
              {
                paramAnonymousString = (a.a)paramAnonymousString.get();
                if (paramAnonymousString != null) {
                  paramAnonymousString.dK(a.this, (int)l);
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
              Log.e("MicroMsg.CDNDownloadHelpper", "cdntra clientid:%s , sceneResult.retCode:%d , sceneResult[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousd.field_retCode), paramAnonymousd });
              paramAnonymousInt = 0;
              while (paramAnonymousInt < a.eNV.size())
              {
                paramAnonymousString = (WeakReference)a.eNV.get(paramAnonymousInt);
                if (paramAnonymousString != null)
                {
                  paramAnonymousString = (a.a)paramAnonymousString.get();
                  if (paramAnonymousString != null) {
                    paramAnonymousString.akZ(a.this);
                  }
                }
                paramAnonymousInt += 1;
              }
            }
            Log.i("MicroMsg.CDNDownloadHelpper", "cdn trans suceess, sceneResult[%s]", new Object[] { paramAnonymousd });
            paramAnonymousInt = 0;
            while (paramAnonymousInt < a.eNV.size())
            {
              paramAnonymousString = (WeakReference)a.eNV.get(paramAnonymousInt);
              if (paramAnonymousString != null)
              {
                paramAnonymousString = (a.a)paramAnonymousString.get();
                if (paramAnonymousString != null) {
                  paramAnonymousString.gj(a.this, str);
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
        Log.i("MicroMsg.CDNDownloadHelpper", "getCdnAuthInfo, mediaId = %s", new Object[] { paramAnonymousString });
        AppMethodBeat.o(113731);
      }
      
      public final byte[] h(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(113732);
        Log.i("MicroMsg.CDNDownloadHelpper", "decodePrepareResponse, mediaId = %s", new Object[] { paramAnonymousString });
        AppMethodBeat.o(113732);
        return null;
      }
    };
    ((com.tencent.mm.g.g)localObject).ihD = false;
    ((com.tencent.mm.g.g)localObject).field_mediaId = h.a("cardgiftfile", Util.nowMilliSecond(), paramString1, paramString1);
    ((com.tencent.mm.g.g)localObject).field_fullpath = str;
    ((com.tencent.mm.g.g)localObject).field_totalLen = paramInt1;
    ((com.tencent.mm.g.g)localObject).field_fileType = com.tencent.mm.g.a.lwf;
    ((com.tencent.mm.g.g)localObject).field_fileId = paramString1;
    ((com.tencent.mm.g.g)localObject).field_aesKey = paramString2;
    ((com.tencent.mm.g.g)localObject).field_priority = com.tencent.mm.g.a.lvZ;
    ((com.tencent.mm.g.g)localObject).field_needStorage = true;
    boolean bool = k.bHW().b((com.tencent.mm.g.g)localObject, -1);
    Log.i("MicroMsg.CDNDownloadHelpper", "add download cdn task : %b, fileId : %s", new Object[] { Boolean.valueOf(bool), ((com.tencent.mm.g.g)localObject).field_fileId });
    if (!bool)
    {
      paramInt1 = j;
      while (paramInt1 < eNV.size())
      {
        paramString2 = (WeakReference)eNV.get(paramInt1);
        if (paramString2 != null)
        {
          paramString2 = (a)paramString2.get();
          if (paramString2 != null) {
            paramString2.akZ(paramString1);
          }
        }
        paramInt1 += 1;
      }
      Log.e("MicroMsg.CDNDownloadHelpper", "can't download from cdn!!!");
    }
    AppMethodBeat.o(113735);
  }
  
  public static abstract interface a
  {
    public abstract void akZ(String paramString);
    
    public abstract void dK(String paramString, int paramInt);
    
    public abstract void gj(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.card.c.a
 * JD-Core Version:    0.7.0.1
 */