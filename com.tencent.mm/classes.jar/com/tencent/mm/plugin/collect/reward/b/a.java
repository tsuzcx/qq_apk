package com.tencent.mm.plugin.collect.reward.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.f;
import com.tencent.mm.g.c.av;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.e;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

public final class a
  implements g.a
{
  private static a oyw;
  private String filename;
  public Map<String, a> mYy;
  
  public static a bWf()
  {
    AppMethodBeat.i(63915);
    if (oyw == null) {
      oyw = new a();
    }
    a locala = oyw;
    AppMethodBeat.o(63915);
    return locala;
  }
  
  private String bWh()
  {
    AppMethodBeat.i(63918);
    if (bs.isNullOrNil(this.filename)) {
      this.filename = ah.dg(u.axw() + "_reward_img");
    }
    String str = this.filename;
    AppMethodBeat.o(63918);
    return str;
  }
  
  private static String bWj()
  {
    AppMethodBeat.i(63921);
    String str = com.tencent.mm.loader.j.b.aph() + "wallet/img/";
    AppMethodBeat.o(63921);
    return str;
  }
  
  public final int a(final String paramString, final int paramInt, com.tencent.mm.i.c paramc, final d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(63920);
    ac.i("MicroMsg.QrRewardCdnDownloadHelper", "cdn callback, id: %s, ret: %s, sceneResult: %s", new Object[] { paramString, Integer.valueOf(paramInt), paramd });
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(63914);
        a.a locala = (a.a)a.this.mYy.get(paramString);
        if (locala != null)
        {
          if (paramd != null)
          {
            int i = paramd.field_retCode;
            locala.V(paramString, paramInt, i);
            a.this.mYy.remove(paramString);
            if (paramd.field_retCode == 0)
            {
              h.wUl.idkeyStat(724L, 8L, 1L, false);
              AppMethodBeat.o(63914);
              return;
            }
            h.wUl.idkeyStat(724L, 9L, 1L, false);
            AppMethodBeat.o(63914);
            return;
          }
          ac.v("MicroMsg.QrRewardCdnDownloadHelper", "download is not end");
          AppMethodBeat.o(63914);
          return;
        }
        ac.w("MicroMsg.QrRewardCdnDownloadHelper", "no callback");
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
    ac.i("MicroMsg.QrRewardCdnDownloadHelper", "downloadImage. imageId:%s", new Object[] { paramString1 });
    Object localObject = new e(bWj());
    if (!((e)localObject).exists()) {
      ((e)localObject).mkdirs();
    }
    localObject = new g();
    ((g)localObject).dBE = false;
    ((g)localObject).frb = this;
    ((g)localObject).field_fullpath = (bWj() + bWh());
    ((g)localObject).field_mediaId = bs.nullAsNil(com.tencent.mm.an.c.a("QrRewardImg", bs.eWj(), u.ayc().field_username, ""));
    ((g)localObject).field_fileId = paramString1;
    ((g)localObject).field_aesKey = paramString2;
    ((g)localObject).field_fileType = com.tencent.mm.i.a.MediaType_FILE;
    ((g)localObject).field_priority = com.tencent.mm.i.a.fqp;
    ((g)localObject).field_needStorage = false;
    ((g)localObject).field_isStreamMedia = false;
    ((g)localObject).field_appType = 0;
    ((g)localObject).field_bzScene = 0;
    if (this.mYy == null) {
      this.mYy = new HashMap();
    }
    this.mYy.put(((g)localObject).field_mediaId, parama);
    if (!f.aDD().b((g)localObject, -1))
    {
      ac.e("MicroMsg.QrRewardCdnDownloadHelper", "ljd: cdntra addSendTask failed. imageId:%s", new Object[] { paramString1 });
      AppMethodBeat.o(63916);
      return false;
    }
    AppMethodBeat.o(63916);
    return true;
  }
  
  public final boolean bWg()
  {
    AppMethodBeat.i(63917);
    boolean bool = new e(bWj() + bWh()).exists();
    AppMethodBeat.o(63917);
    return bool;
  }
  
  public final String bWi()
  {
    AppMethodBeat.i(63919);
    String str = bWj() + bWh();
    AppMethodBeat.o(63919);
    return str;
  }
  
  public final byte[] f(String paramString, byte[] paramArrayOfByte)
  {
    return new byte[0];
  }
  
  public static abstract interface a
  {
    public abstract void V(String paramString, int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.b.a
 * JD-Core Version:    0.7.0.1
 */