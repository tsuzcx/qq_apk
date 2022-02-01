package com.tencent.mm.plugin.collect.reward.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.f;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.v;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.k;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

public final class a
  implements g.a
{
  private static a pix;
  private String filename;
  public Map<String, a> nEq;
  
  public static a cbX()
  {
    AppMethodBeat.i(63915);
    if (pix == null) {
      pix = new a();
    }
    a locala = pix;
    AppMethodBeat.o(63915);
    return locala;
  }
  
  private String cbZ()
  {
    AppMethodBeat.i(63918);
    if (bu.isNullOrNil(this.filename)) {
      this.filename = aj.ej(v.aAC() + "_reward_img");
    }
    String str = this.filename;
    AppMethodBeat.o(63918);
    return str;
  }
  
  private static String ccb()
  {
    AppMethodBeat.i(63921);
    String str = com.tencent.mm.loader.j.b.asj() + "wallet/img/";
    AppMethodBeat.o(63921);
    return str;
  }
  
  public final int a(final String paramString, final int paramInt, com.tencent.mm.i.c paramc, final d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(63920);
    ae.i("MicroMsg.QrRewardCdnDownloadHelper", "cdn callback, id: %s, ret: %s, sceneResult: %s", new Object[] { paramString, Integer.valueOf(paramInt), paramd });
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(63914);
        a.a locala = (a.a)a.this.nEq.get(paramString);
        if (locala != null)
        {
          if (paramd != null)
          {
            int i = paramd.field_retCode;
            locala.X(paramString, paramInt, i);
            a.this.nEq.remove(paramString);
            if (paramd.field_retCode == 0)
            {
              com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(724L, 8L, 1L, false);
              AppMethodBeat.o(63914);
              return;
            }
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(724L, 9L, 1L, false);
            AppMethodBeat.o(63914);
            return;
          }
          ae.v("MicroMsg.QrRewardCdnDownloadHelper", "download is not end");
          AppMethodBeat.o(63914);
          return;
        }
        ae.w("MicroMsg.QrRewardCdnDownloadHelper", "no callback");
        AppMethodBeat.o(63914);
      }
    });
    AppMethodBeat.o(63920);
    return 0;
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public final boolean a(String paramString1, String paramString2, a parama)
  {
    AppMethodBeat.i(63916);
    ae.i("MicroMsg.QrRewardCdnDownloadHelper", "downloadImage. imageId:%s", new Object[] { paramString1 });
    Object localObject = new k(ccb());
    if (!((k)localObject).exists()) {
      ((k)localObject).mkdirs();
    }
    localObject = new com.tencent.mm.i.g();
    ((com.tencent.mm.i.g)localObject).fLl = "task_QrRewardCdnDownloadHelper";
    ((com.tencent.mm.i.g)localObject).dPh = false;
    ((com.tencent.mm.i.g)localObject).fLm = this;
    ((com.tencent.mm.i.g)localObject).field_fullpath = (ccb() + cbZ());
    ((com.tencent.mm.i.g)localObject).field_mediaId = bu.nullAsNil(com.tencent.mm.an.c.a("QrRewardImg", bu.fpO(), v.aBo().field_username, ""));
    ((com.tencent.mm.i.g)localObject).field_fileId = paramString1;
    ((com.tencent.mm.i.g)localObject).field_aesKey = paramString2;
    ((com.tencent.mm.i.g)localObject).field_fileType = com.tencent.mm.i.a.MediaType_FILE;
    ((com.tencent.mm.i.g)localObject).field_priority = com.tencent.mm.i.a.fKA;
    ((com.tencent.mm.i.g)localObject).field_needStorage = false;
    ((com.tencent.mm.i.g)localObject).field_isStreamMedia = false;
    ((com.tencent.mm.i.g)localObject).field_appType = 0;
    ((com.tencent.mm.i.g)localObject).field_bzScene = 0;
    if (this.nEq == null) {
      this.nEq = new HashMap();
    }
    this.nEq.put(((com.tencent.mm.i.g)localObject).field_mediaId, parama);
    if (!f.aGZ().b((com.tencent.mm.i.g)localObject, -1))
    {
      ae.e("MicroMsg.QrRewardCdnDownloadHelper", "ljd: cdntra addSendTask failed. imageId:%s", new Object[] { paramString1 });
      AppMethodBeat.o(63916);
      return false;
    }
    AppMethodBeat.o(63916);
    return true;
  }
  
  public final boolean cbY()
  {
    AppMethodBeat.i(63917);
    boolean bool = new k(ccb() + cbZ()).exists();
    AppMethodBeat.o(63917);
    return bool;
  }
  
  public final String cca()
  {
    AppMethodBeat.i(63919);
    String str = ccb() + cbZ();
    AppMethodBeat.o(63919);
    return str;
  }
  
  public final byte[] f(String paramString, byte[] paramArrayOfByte)
  {
    return new byte[0];
  }
  
  public static abstract interface a
  {
    public abstract void X(String paramString, int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.b.a
 * JD-Core Version:    0.7.0.1
 */