package com.tencent.mm.plugin.collect.reward.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.g.c;
import com.tencent.mm.g.d;
import com.tencent.mm.g.g.a;
import com.tencent.mm.loader.i.b;
import com.tencent.mm.model.z;
import com.tencent.mm.modelcdntran.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

public final class a
  implements g.a
{
  private static a xaa;
  private String filename;
  public Map<String, a> vcA;
  
  public static a drW()
  {
    AppMethodBeat.i(63915);
    if (xaa == null) {
      xaa = new a();
    }
    a locala = xaa;
    AppMethodBeat.o(63915);
    return locala;
  }
  
  private String drY()
  {
    AppMethodBeat.i(63918);
    if (Util.isNullOrNil(this.filename)) {
      this.filename = MD5Util.getMD5String(z.bAM() + "_reward_img");
    }
    String str = this.filename;
    AppMethodBeat.o(63918);
    return str;
  }
  
  private static String dsa()
  {
    AppMethodBeat.i(63921);
    String str = b.bmz() + "wallet/img/";
    AppMethodBeat.o(63921);
    return str;
  }
  
  public final int a(final String paramString, final int paramInt, c paramc, final d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(63920);
    Log.i("MicroMsg.QrRewardCdnDownloadHelper", "cdn callback, id: %s, ret: %s, sceneResult: %s", new Object[] { paramString, Integer.valueOf(paramInt), paramd });
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(63914);
        a.a locala = (a.a)a.this.vcA.get(paramString);
        if (locala != null)
        {
          if (paramd != null)
          {
            int i = paramd.field_retCode;
            locala.ae(paramString, paramInt, i);
            a.this.vcA.remove(paramString);
            if (paramd.field_retCode == 0)
            {
              com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(724L, 8L, 1L, false);
              AppMethodBeat.o(63914);
              return;
            }
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(724L, 9L, 1L, false);
            AppMethodBeat.o(63914);
            return;
          }
          Log.v("MicroMsg.QrRewardCdnDownloadHelper", "download is not end");
          AppMethodBeat.o(63914);
          return;
        }
        Log.w("MicroMsg.QrRewardCdnDownloadHelper", "no callback");
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
    Log.i("MicroMsg.QrRewardCdnDownloadHelper", "downloadImage. imageId:%s", new Object[] { paramString1 });
    Object localObject = new u(dsa());
    if (!((u)localObject).jKS()) {
      ((u)localObject).jKY();
    }
    localObject = new com.tencent.mm.g.g();
    ((com.tencent.mm.g.g)localObject).taskName = "task_QrRewardCdnDownloadHelper";
    ((com.tencent.mm.g.g)localObject).ihD = false;
    ((com.tencent.mm.g.g)localObject).lwL = this;
    ((com.tencent.mm.g.g)localObject).field_fullpath = (dsa() + drY());
    ((com.tencent.mm.g.g)localObject).field_mediaId = Util.nullAsNil(com.tencent.mm.modelcdntran.h.a("QrRewardImg", Util.nowMilliSecond(), z.bBF().field_username, ""));
    ((com.tencent.mm.g.g)localObject).field_fileId = paramString1;
    ((com.tencent.mm.g.g)localObject).field_aesKey = paramString2;
    ((com.tencent.mm.g.g)localObject).field_fileType = com.tencent.mm.g.a.MediaType_FILE;
    ((com.tencent.mm.g.g)localObject).field_priority = com.tencent.mm.g.a.lvZ;
    ((com.tencent.mm.g.g)localObject).field_needStorage = false;
    ((com.tencent.mm.g.g)localObject).field_isStreamMedia = false;
    ((com.tencent.mm.g.g)localObject).field_appType = 0;
    ((com.tencent.mm.g.g)localObject).field_bzScene = 0;
    if (this.vcA == null) {
      this.vcA = new HashMap();
    }
    this.vcA.put(((com.tencent.mm.g.g)localObject).field_mediaId, parama);
    if (!k.bHW().b((com.tencent.mm.g.g)localObject, -1))
    {
      Log.e("MicroMsg.QrRewardCdnDownloadHelper", "ljd: cdntra addSendTask failed. imageId:%s", new Object[] { paramString1 });
      AppMethodBeat.o(63916);
      return false;
    }
    AppMethodBeat.o(63916);
    return true;
  }
  
  public final boolean drX()
  {
    AppMethodBeat.i(63917);
    boolean bool = new u(dsa() + drY()).jKS();
    AppMethodBeat.o(63917);
    return bool;
  }
  
  public final String drZ()
  {
    AppMethodBeat.i(63919);
    String str = dsa() + drY();
    AppMethodBeat.o(63919);
    return str;
  }
  
  public final byte[] h(String paramString, byte[] paramArrayOfByte)
  {
    return new byte[0];
  }
  
  public static abstract interface a
  {
    public abstract void ae(String paramString, int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.b.a
 * JD-Core Version:    0.7.0.1
 */