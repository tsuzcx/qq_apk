package com.tencent.mm.plugin.aa.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.b;
import com.tencent.mm.g.b.a.h;
import com.tencent.mm.i.g.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import java.io.ByteArrayOutputStream;

public final class d
{
  public static int izq = 20301;
  private String dmK;
  private g.a hIz;
  private a izr;
  private long izs;
  private String mediaId;
  
  public d(String paramString, a parama)
  {
    AppMethodBeat.i(63324);
    this.izs = 0L;
    this.hIz = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(63323);
        if (paramAnonymousInt == -21005)
        {
          ac.d("MicroMsg.Aa.AAImagUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
          AppMethodBeat.o(63323);
          return 0;
        }
        if ((paramAnonymousd != null) && (paramAnonymousd.field_retCode == 0))
        {
          ac.i("MicroMsg.Aa.AAImagUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
          d.a(d.this).bJ(paramAnonymousd.field_fileUrl, paramAnonymousd.field_thumbUrl);
          ac.i("MicroMsg.Aa.AAImagUpload", "uploadsns cdndone pass: " + (System.currentTimeMillis() - d.b(d.this)) + " " + paramAnonymousd.field_filemd5);
          new h(com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(d.b(d.this)), Long.valueOf(bs.eWj()), Integer.valueOf(com.tencent.mm.an.c.cD(ai.getContext())), Integer.valueOf(d.izq), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.fqM })).aHZ();
          AppMethodBeat.o(63323);
          return 0;
        }
        if ((paramAnonymousd != null) && (paramAnonymousd.field_retCode != 0))
        {
          ac.i("MicroMsg.Aa.AAImagUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
          paramAnonymousString = com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), Integer.valueOf(1), Long.valueOf(d.b(d.this)), Long.valueOf(bs.eWj()), Integer.valueOf(com.tencent.mm.an.c.cD(ai.getContext())), Integer.valueOf(d.izq), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.fqM });
          new h(paramAnonymousString).aHZ();
          new com.tencent.mm.g.b.a.f(paramAnonymousString).aHZ();
          d.a(d.this).aNP();
          AppMethodBeat.o(63323);
          return 0;
        }
        if (paramAnonymousInt != 0)
        {
          ac.i("MicroMsg.Aa.AAImagUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
          if (paramAnonymousd != null) {
            new h(com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(d.b(d.this)), Long.valueOf(bs.eWj()), Integer.valueOf(com.tencent.mm.an.c.cD(ai.getContext())), Integer.valueOf(d.izq), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.fqM })).aHZ();
          }
          d.a(d.this).aNP();
          AppMethodBeat.o(63323);
          return 0;
        }
        ac.d("MicroMsg.Aa.AAImagUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
        AppMethodBeat.o(63323);
        return 0;
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return null;
      }
    };
    this.izs = System.currentTimeMillis();
    this.dmK = paramString;
    this.izr = parama;
    if (bs.isNullOrNil(this.dmK)) {}
    for (parama = "";; parama = com.tencent.mm.b.g.getMessageDigest(this.dmK.getBytes()))
    {
      this.mediaId = parama;
      ac.i("MicroMsg.Aa.AAImagUpload", "AAImagUpload imgPath:%s mediaId:%s", new Object[] { paramString, this.mediaId });
      AppMethodBeat.o(63324);
      return;
    }
  }
  
  public final boolean aNO()
  {
    AppMethodBeat.i(63325);
    com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
    localg.frb = this.hIz;
    localg.field_mediaId = this.mediaId;
    localg.field_fullpath = this.dmK;
    localg.field_thumbpath = "";
    localg.field_fileType = 20301;
    localg.field_talker = "";
    localg.field_priority = com.tencent.mm.i.a.fqp;
    localg.field_needStorage = true;
    localg.field_isStreamMedia = false;
    localg.field_appType = 249;
    localg.field_bzScene = 2;
    if (!com.tencent.mm.an.f.aDD().f(localg))
    {
      ac.e("MicroMsg.Aa.AAImagUpload", "cdntra addSendTask failed. mediaId:%s", new Object[] { this.mediaId });
      AppMethodBeat.o(63325);
      return false;
    }
    AppMethodBeat.o(63325);
    return true;
  }
  
  public static abstract interface a
  {
    public abstract void aNP();
    
    public abstract void bJ(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.d
 * JD-Core Version:    0.7.0.1
 */