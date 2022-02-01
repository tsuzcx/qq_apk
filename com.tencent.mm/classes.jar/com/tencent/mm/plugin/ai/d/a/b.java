package com.tencent.mm.plugin.ai.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import java.io.ByteArrayOutputStream;

public final class b
  implements g.a
{
  private String md5;
  public String mediaId;
  private a npG;
  public String npH;
  private boolean npI;
  private String npJ;
  private String savePath;
  public String url;
  
  public b(String paramString1, String paramString2, String paramString3, a parama, String paramString4)
  {
    AppMethodBeat.i(239263);
    this.url = "";
    this.savePath = "";
    this.md5 = "";
    this.npG = null;
    this.mediaId = "";
    this.npH = "";
    this.npI = false;
    this.npJ = "";
    this.url = paramString1;
    this.savePath = paramString2;
    this.md5 = paramString3;
    this.npG = parama;
    this.mediaId = ("ai_download_" + paramString1.hashCode() + Util.nowMilliSecond());
    this.npH = (paramString2 + ".tmp");
    this.npI = true;
    this.npJ = paramString4;
    AppMethodBeat.o(239263);
  }
  
  public final int a(String paramString, int paramInt, c paramc, d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(239266);
    if (!Util.isEqual(paramString, this.mediaId))
    {
      AppMethodBeat.o(239266);
      return 0;
    }
    if (paramd != null)
    {
      paramString = "";
      if (paramd.field_retCode != 0) {
        break label182;
      }
      paramc = g.getMD5(this.npH);
      paramString = paramc;
      if (!this.md5.equalsIgnoreCase(paramc)) {
        break label182;
      }
      if (u.agG(this.savePath)) {
        u.deleteFile(this.savePath);
      }
      paramBoolean = u.oo(this.npH, this.savePath);
      paramString = paramc;
    }
    for (;;)
    {
      Log.i("MicroMsg.AiDownloadTask", "ai download task finish flag[%b] ret[%d] path[%s] md5[%s] tmpMd5[%s]", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramd.field_retCode), this.savePath, this.md5, paramString });
      if (this.npG != null) {
        this.npG.a(paramBoolean, this.url, this.savePath, this.npI, this.npJ);
      }
      AppMethodBeat.o(239266);
      return 0;
      label182:
      paramBoolean = false;
    }
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public final byte[] f(String paramString, byte[] paramArrayOfByte)
  {
    return new byte[0];
  }
  
  static abstract interface a
  {
    public abstract void a(boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2, String paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.d.a.b
 * JD-Core Version:    0.7.0.1
 */