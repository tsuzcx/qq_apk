package com.tencent.mm.plugin.ai.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a;
import com.tencent.mm.g.c;
import com.tencent.mm.g.d;
import com.tencent.mm.g.g.a;
import com.tencent.mm.modelcdntran.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import java.io.ByteArrayOutputStream;

public final class b
  implements g.a
{
  private String md5;
  private String mediaId;
  private a qol;
  private String qom;
  private boolean qon;
  private String qoo;
  private String savePath;
  private String url;
  
  public b(String paramString1, String paramString2, String paramString3, a parama, boolean paramBoolean, String paramString4)
  {
    AppMethodBeat.i(267446);
    this.url = "";
    this.savePath = "";
    this.md5 = "";
    this.qol = null;
    this.mediaId = "";
    this.qom = "";
    this.qon = false;
    this.qoo = "";
    this.url = paramString1;
    this.savePath = paramString2;
    this.md5 = paramString3;
    this.qol = parama;
    this.mediaId = ("ai_download_" + paramString1.hashCode() + Util.nowMilliSecond());
    this.qom = (paramString2 + ".tmp");
    this.qon = paramBoolean;
    this.qoo = paramString4;
    AppMethodBeat.o(267446);
  }
  
  public final int a(String paramString, int paramInt, c paramc, d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(267462);
    if (!Util.isEqual(paramString, this.mediaId))
    {
      AppMethodBeat.o(267462);
      return 0;
    }
    if (paramd != null)
    {
      paramString = "";
      if (paramd.field_retCode != 0) {
        break label182;
      }
      paramc = com.tencent.mm.b.g.getMD5(this.qom);
      paramString = paramc;
      if (!this.md5.equalsIgnoreCase(paramc)) {
        break label182;
      }
      if (y.ZC(this.savePath)) {
        y.deleteFile(this.savePath);
      }
      paramBoolean = y.qn(this.qom, this.savePath);
      paramString = paramc;
    }
    for (;;)
    {
      Log.i("MicroMsg.AiDownloadTask", "ai download task finish flag[%b] ret[%d] path[%s] md5[%s] tmpMd5[%s]", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramd.field_retCode), this.savePath, this.md5, paramString });
      if (this.qol != null) {
        this.qol.a(paramBoolean, this.url, this.savePath, this.qon, this.qoo);
      }
      AppMethodBeat.o(267462);
      return 0;
      label182:
      paramBoolean = false;
    }
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public final void blf()
  {
    AppMethodBeat.i(267456);
    com.tencent.mm.g.g localg = new com.tencent.mm.g.g();
    localg.field_mediaId = this.mediaId;
    localg.lwO = this.url;
    localg.field_fullpath = this.qom;
    localg.field_fileType = a.lwt;
    localg.lwS = false;
    localg.lwL = this;
    k.bHW().b(localg, -1);
    Log.i("MicroMsg.AiDownloadTask", "start to download task [%s] [%s] [%s]", new Object[] { this.mediaId, this.qom, this.url });
    AppMethodBeat.o(267456);
  }
  
  public final byte[] h(String paramString, byte[] paramArrayOfByte)
  {
    return new byte[0];
  }
  
  static abstract interface a
  {
    public abstract void a(boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2, String paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.c.a.b
 * JD-Core Version:    0.7.0.1
 */