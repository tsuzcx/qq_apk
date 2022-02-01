package com.tencent.mm.plugin.collect.reward.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aq.f;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

public final class a
  implements g.a
{
  private static a tWI;
  private String filename;
  public Map<String, a.a> rRk;
  
  public static a cOr()
  {
    AppMethodBeat.i(63915);
    if (tWI == null) {
      tWI = new a();
    }
    a locala = tWI;
    AppMethodBeat.o(63915);
    return locala;
  }
  
  private String cOt()
  {
    AppMethodBeat.i(63918);
    if (Util.isNullOrNil(this.filename)) {
      this.filename = MD5Util.getMD5String(z.bcZ() + "_reward_img");
    }
    String str = this.filename;
    AppMethodBeat.o(63918);
    return str;
  }
  
  private static String cOv()
  {
    AppMethodBeat.i(63921);
    String str = com.tencent.mm.loader.j.b.aSL() + "wallet/img/";
    AppMethodBeat.o(63921);
    return str;
  }
  
  public final int a(String paramString, int paramInt, com.tencent.mm.i.c paramc, d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(63920);
    Log.i("MicroMsg.QrRewardCdnDownloadHelper", "cdn callback, id: %s, ret: %s, sceneResult: %s", new Object[] { paramString, Integer.valueOf(paramInt), paramd });
    MMHandlerThread.postToMainThread(new a.1(this, paramString, paramd, paramInt));
    AppMethodBeat.o(63920);
    return 0;
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public final boolean a(String paramString1, String paramString2, a.a parama)
  {
    AppMethodBeat.i(63916);
    Log.i("MicroMsg.QrRewardCdnDownloadHelper", "downloadImage. imageId:%s", new Object[] { paramString1 });
    Object localObject = new q(cOv());
    if (!((q)localObject).ifE()) {
      ((q)localObject).ifL();
    }
    localObject = new g();
    ((g)localObject).taskName = "task_QrRewardCdnDownloadHelper";
    ((g)localObject).gbt = false;
    ((g)localObject).iUG = this;
    ((g)localObject).field_fullpath = (cOv() + cOt());
    ((g)localObject).field_mediaId = Util.nullAsNil(com.tencent.mm.aq.c.a("QrRewardImg", Util.nowMilliSecond(), z.bdN().field_username, ""));
    ((g)localObject).field_fileId = paramString1;
    ((g)localObject).field_aesKey = paramString2;
    ((g)localObject).field_fileType = com.tencent.mm.i.a.MediaType_FILE;
    ((g)localObject).field_priority = com.tencent.mm.i.a.iTU;
    ((g)localObject).field_needStorage = false;
    ((g)localObject).field_isStreamMedia = false;
    ((g)localObject).field_appType = 0;
    ((g)localObject).field_bzScene = 0;
    if (this.rRk == null) {
      this.rRk = new HashMap();
    }
    this.rRk.put(((g)localObject).field_mediaId, parama);
    if (!f.bkg().b((g)localObject, -1))
    {
      Log.e("MicroMsg.QrRewardCdnDownloadHelper", "ljd: cdntra addSendTask failed. imageId:%s", new Object[] { paramString1 });
      AppMethodBeat.o(63916);
      return false;
    }
    AppMethodBeat.o(63916);
    return true;
  }
  
  public final boolean cOs()
  {
    AppMethodBeat.i(63917);
    boolean bool = new q(cOv() + cOt()).ifE();
    AppMethodBeat.o(63917);
    return bool;
  }
  
  public final String cOu()
  {
    AppMethodBeat.i(63919);
    String str = cOv() + cOt();
    AppMethodBeat.o(63919);
    return str;
  }
  
  public final byte[] f(String paramString, byte[] paramArrayOfByte)
  {
    return new byte[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.b.a
 * JD-Core Version:    0.7.0.1
 */