package com.tencent.mm.plugin.collect.reward.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public final class a
  implements g.a
{
  private static final String kON;
  private static a kOO;
  private String filename;
  public Map<String, a.a> jFd;
  
  static
  {
    AppMethodBeat.i(41061);
    kON = com.tencent.mm.loader.j.b.eQv + "wallet/img/";
    AppMethodBeat.o(41061);
  }
  
  public static a bhT()
  {
    AppMethodBeat.i(41055);
    if (kOO == null) {
      kOO = new a();
    }
    a locala = kOO;
    AppMethodBeat.o(41055);
    return locala;
  }
  
  private String bhV()
  {
    AppMethodBeat.i(41058);
    if (bo.isNullOrNil(this.filename)) {
      this.filename = ag.cE(r.Zn() + "_reward_img");
    }
    String str = this.filename;
    AppMethodBeat.o(41058);
    return str;
  }
  
  public final int a(String paramString, int paramInt, com.tencent.mm.i.c paramc, d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(41060);
    ab.i("MicroMsg.QrRewardCdnDownloadHelper", "cdn callback, id: %s, ret: %s, sceneResult: %s", new Object[] { paramString, Integer.valueOf(paramInt), paramd });
    al.d(new a.1(this, paramString, paramd, paramInt));
    AppMethodBeat.o(41060);
    return 0;
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public final boolean a(String paramString1, String paramString2, a.a parama)
  {
    AppMethodBeat.i(41056);
    ab.i("MicroMsg.QrRewardCdnDownloadHelper", "downloadImage. imageId:%s", new Object[] { paramString1 });
    Object localObject = new File(kON);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    localObject = new g();
    ((g)localObject).cMU = false;
    ((g)localObject).edp = this;
    ((g)localObject).field_fullpath = (kON + bhV());
    ((g)localObject).field_mediaId = bo.nullAsNil(com.tencent.mm.al.c.a("QrRewardImg", bo.aoy(), r.ZS().field_username, ""));
    ((g)localObject).field_fileId = paramString1;
    ((g)localObject).field_aesKey = paramString2;
    ((g)localObject).field_fileType = com.tencent.mm.i.a.MediaType_FILE;
    ((g)localObject).field_priority = com.tencent.mm.i.a.ecF;
    ((g)localObject).field_needStorage = false;
    ((g)localObject).field_isStreamMedia = false;
    ((g)localObject).field_appType = 0;
    ((g)localObject).field_bzScene = 0;
    if (this.jFd == null) {
      this.jFd = new HashMap();
    }
    this.jFd.put(((g)localObject).field_mediaId, parama);
    if (!f.afO().b((g)localObject, -1))
    {
      ab.e("MicroMsg.QrRewardCdnDownloadHelper", "ljd: cdntra addSendTask failed. imageId:%s", new Object[] { paramString1 });
      AppMethodBeat.o(41056);
      return false;
    }
    AppMethodBeat.o(41056);
    return true;
  }
  
  public final boolean bhU()
  {
    AppMethodBeat.i(41057);
    boolean bool = new File(kON + bhV()).exists();
    AppMethodBeat.o(41057);
    return bool;
  }
  
  public final String bhW()
  {
    AppMethodBeat.i(41059);
    String str = kON + bhV();
    AppMethodBeat.o(41059);
    return str;
  }
  
  public final byte[] l(String paramString, byte[] paramArrayOfByte)
  {
    return new byte[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.b.a
 * JD-Core Version:    0.7.0.1
 */