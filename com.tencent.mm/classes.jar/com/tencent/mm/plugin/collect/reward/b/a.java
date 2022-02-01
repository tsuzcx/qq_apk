package com.tencent.mm.plugin.collect.reward.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.f;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

public final class a
  implements g.a
{
  private static a qxI;
  private String filename;
  public Map<String, a> oPn;
  
  public static a czR()
  {
    AppMethodBeat.i(63915);
    if (qxI == null) {
      qxI = new a();
    }
    a locala = qxI;
    AppMethodBeat.o(63915);
    return locala;
  }
  
  private String czT()
  {
    AppMethodBeat.i(63918);
    if (Util.isNullOrNil(this.filename)) {
      this.filename = MD5Util.getMD5String(z.aTY() + "_reward_img");
    }
    String str = this.filename;
    AppMethodBeat.o(63918);
    return str;
  }
  
  private static String czV()
  {
    AppMethodBeat.i(63921);
    String str = com.tencent.mm.loader.j.b.aKJ() + "wallet/img/";
    AppMethodBeat.o(63921);
    return str;
  }
  
  public final int a(final String paramString, final int paramInt, com.tencent.mm.i.c paramc, final d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(63920);
    Log.i("MicroMsg.QrRewardCdnDownloadHelper", "cdn callback, id: %s, ret: %s, sceneResult: %s", new Object[] { paramString, Integer.valueOf(paramInt), paramd });
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(63914);
        a.a locala = (a.a)a.this.oPn.get(paramString);
        if (locala != null)
        {
          if (paramd != null)
          {
            int i = paramd.field_retCode;
            locala.Y(paramString, paramInt, i);
            a.this.oPn.remove(paramString);
            if (paramd.field_retCode == 0)
            {
              h.CyF.idkeyStat(724L, 8L, 1L, false);
              AppMethodBeat.o(63914);
              return;
            }
            h.CyF.idkeyStat(724L, 9L, 1L, false);
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
    Object localObject = new o(czV());
    if (!((o)localObject).exists()) {
      ((o)localObject).mkdirs();
    }
    localObject = new g();
    ((g)localObject).taskName = "task_QrRewardCdnDownloadHelper";
    ((g)localObject).ehd = false;
    ((g)localObject).gqy = this;
    ((g)localObject).field_fullpath = (czV() + czT());
    ((g)localObject).field_mediaId = Util.nullAsNil(com.tencent.mm.an.c.a("QrRewardImg", Util.nowMilliSecond(), z.aUL().field_username, ""));
    ((g)localObject).field_fileId = paramString1;
    ((g)localObject).field_aesKey = paramString2;
    ((g)localObject).field_fileType = com.tencent.mm.i.a.MediaType_FILE;
    ((g)localObject).field_priority = com.tencent.mm.i.a.gpM;
    ((g)localObject).field_needStorage = false;
    ((g)localObject).field_isStreamMedia = false;
    ((g)localObject).field_appType = 0;
    ((g)localObject).field_bzScene = 0;
    if (this.oPn == null) {
      this.oPn = new HashMap();
    }
    this.oPn.put(((g)localObject).field_mediaId, parama);
    if (!f.baQ().b((g)localObject, -1))
    {
      Log.e("MicroMsg.QrRewardCdnDownloadHelper", "ljd: cdntra addSendTask failed. imageId:%s", new Object[] { paramString1 });
      AppMethodBeat.o(63916);
      return false;
    }
    AppMethodBeat.o(63916);
    return true;
  }
  
  public final boolean czS()
  {
    AppMethodBeat.i(63917);
    boolean bool = new o(czV() + czT()).exists();
    AppMethodBeat.o(63917);
    return bool;
  }
  
  public final String czU()
  {
    AppMethodBeat.i(63919);
    String str = czV() + czT();
    AppMethodBeat.o(63919);
    return str;
  }
  
  public final byte[] f(String paramString, byte[] paramArrayOfByte)
  {
    return new byte[0];
  }
  
  public static abstract interface a
  {
    public abstract void Y(String paramString, int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.b.a
 * JD-Core Version:    0.7.0.1
 */