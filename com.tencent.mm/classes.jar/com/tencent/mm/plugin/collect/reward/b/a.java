package com.tencent.mm.plugin.collect.reward.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ao.f;
import com.tencent.mm.g.c.au;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.e;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

public final class a
  implements g.a
{
  private static a nVb;
  private String filename;
  public Map<String, a> mwx;
  
  public static a bOP()
  {
    AppMethodBeat.i(63915);
    if (nVb == null) {
      nVb = new a();
    }
    a locala = nVb;
    AppMethodBeat.o(63915);
    return locala;
  }
  
  private String bOR()
  {
    AppMethodBeat.i(63918);
    if (bt.isNullOrNil(this.filename)) {
      this.filename = ai.du(u.aqG() + "_reward_img");
    }
    String str = this.filename;
    AppMethodBeat.o(63918);
    return str;
  }
  
  private static String bOT()
  {
    AppMethodBeat.i(63921);
    String str = com.tencent.mm.loader.j.b.aih() + "wallet/img/";
    AppMethodBeat.o(63921);
    return str;
  }
  
  public final int a(final String paramString, final int paramInt, com.tencent.mm.i.c paramc, final d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(63920);
    ad.i("MicroMsg.QrRewardCdnDownloadHelper", "cdn callback, id: %s, ret: %s, sceneResult: %s", new Object[] { paramString, Integer.valueOf(paramInt), paramd });
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(63914);
        a.a locala = (a.a)a.this.mwx.get(paramString);
        if (locala != null)
        {
          if (paramd != null)
          {
            int i = paramd.field_retCode;
            locala.W(paramString, paramInt, i);
            a.this.mwx.remove(paramString);
            if (paramd.field_retCode == 0)
            {
              h.vKh.idkeyStat(724L, 8L, 1L, false);
              AppMethodBeat.o(63914);
              return;
            }
            h.vKh.idkeyStat(724L, 9L, 1L, false);
            AppMethodBeat.o(63914);
            return;
          }
          ad.v("MicroMsg.QrRewardCdnDownloadHelper", "download is not end");
          AppMethodBeat.o(63914);
          return;
        }
        ad.w("MicroMsg.QrRewardCdnDownloadHelper", "no callback");
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
    ad.i("MicroMsg.QrRewardCdnDownloadHelper", "downloadImage. imageId:%s", new Object[] { paramString1 });
    Object localObject = new e(bOT());
    if (!((e)localObject).exists()) {
      ((e)localObject).mkdirs();
    }
    localObject = new g();
    ((g)localObject).dDS = false;
    ((g)localObject).fnH = this;
    ((g)localObject).field_fullpath = (bOT() + bOR());
    ((g)localObject).field_mediaId = bt.nullAsNil(com.tencent.mm.ao.c.a("QrRewardImg", bt.eGO(), u.arm().field_username, ""));
    ((g)localObject).field_fileId = paramString1;
    ((g)localObject).field_aesKey = paramString2;
    ((g)localObject).field_fileType = com.tencent.mm.i.a.MediaType_FILE;
    ((g)localObject).field_priority = com.tencent.mm.i.a.fmV;
    ((g)localObject).field_needStorage = false;
    ((g)localObject).field_isStreamMedia = false;
    ((g)localObject).field_appType = 0;
    ((g)localObject).field_bzScene = 0;
    if (this.mwx == null) {
      this.mwx = new HashMap();
    }
    this.mwx.put(((g)localObject).field_mediaId, parama);
    if (!f.awL().b((g)localObject, -1))
    {
      ad.e("MicroMsg.QrRewardCdnDownloadHelper", "ljd: cdntra addSendTask failed. imageId:%s", new Object[] { paramString1 });
      AppMethodBeat.o(63916);
      return false;
    }
    AppMethodBeat.o(63916);
    return true;
  }
  
  public final boolean bOQ()
  {
    AppMethodBeat.i(63917);
    boolean bool = new e(bOT() + bOR()).exists();
    AppMethodBeat.o(63917);
    return bool;
  }
  
  public final String bOS()
  {
    AppMethodBeat.i(63919);
    String str = bOT() + bOR();
    AppMethodBeat.o(63919);
    return str;
  }
  
  public final byte[] f(String paramString, byte[] paramArrayOfByte)
  {
    return new byte[0];
  }
  
  public static abstract interface a
  {
    public abstract void W(String paramString, int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.b.a
 * JD-Core Version:    0.7.0.1
 */