package com.tencent.mm.plugin.ai.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.io.ByteArrayOutputStream;

public final class b
  implements g.a
{
  private a kwM;
  public String kwN;
  private boolean kwO;
  private String kwP;
  private String md5;
  public String mediaId;
  private String savePath;
  public String url;
  
  public b(String paramString1, String paramString2, String paramString3, a parama, String paramString4)
  {
    AppMethodBeat.i(238906);
    this.url = "";
    this.savePath = "";
    this.md5 = "";
    this.kwM = null;
    this.mediaId = "";
    this.kwN = "";
    this.kwO = false;
    this.kwP = "";
    this.url = paramString1;
    this.savePath = paramString2;
    this.md5 = paramString3;
    this.kwM = parama;
    this.mediaId = ("ai_download_" + paramString1.hashCode() + Util.nowMilliSecond());
    this.kwN = (paramString2 + ".tmp");
    this.kwO = true;
    this.kwP = paramString4;
    AppMethodBeat.o(238906);
  }
  
  public final int a(String paramString, int paramInt, c paramc, d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(238907);
    if (!Util.isEqual(paramString, this.mediaId))
    {
      AppMethodBeat.o(238907);
      return 0;
    }
    if (paramd != null)
    {
      paramString = "";
      if (paramd.field_retCode != 0) {
        break label182;
      }
      paramc = g.getMD5(this.kwN);
      paramString = paramc;
      if (!this.md5.equalsIgnoreCase(paramc)) {
        break label182;
      }
      if (s.YS(this.savePath)) {
        s.deleteFile(this.savePath);
      }
      paramBoolean = s.nx(this.kwN, this.savePath);
      paramString = paramc;
    }
    for (;;)
    {
      Log.i("MicroMsg.AiDownloadTask", "ai download task finish flag[%b] ret[%d] path[%s] md5[%s] tmpMd5[%s]", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramd.field_retCode), this.savePath, this.md5, paramString });
      if (this.kwM != null) {
        this.kwM.a(paramBoolean, this.url, this.savePath, this.kwO, this.kwP);
      }
      AppMethodBeat.o(238907);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.d.a.b
 * JD-Core Version:    0.7.0.1
 */