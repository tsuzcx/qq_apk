package com.tencent.mm.plugin.aa.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ao.b;
import com.tencent.mm.ao.f;
import com.tencent.mm.g.b.a.h;
import com.tencent.mm.g.b.a.j;
import com.tencent.mm.i.g.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.ByteArrayOutputStream;

public final class d
{
  public static int iSz = 20301;
  private String dyy;
  private a iSA;
  private long iSB;
  private g.a ibn;
  private String mediaId;
  
  public d(String paramString, a parama)
  {
    AppMethodBeat.i(63324);
    this.iSB = 0L;
    this.ibn = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(63323);
        if (paramAnonymousInt == -21005)
        {
          ad.d("MicroMsg.Aa.AAImagUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
          AppMethodBeat.o(63323);
          return 0;
        }
        if ((paramAnonymousd != null) && (paramAnonymousd.field_retCode == 0))
        {
          ad.i("MicroMsg.Aa.AAImagUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
          d.a(d.this).bL(paramAnonymousd.field_fileUrl, paramAnonymousd.field_thumbUrl);
          ad.i("MicroMsg.Aa.AAImagUpload", "uploadsns cdndone pass: " + (System.currentTimeMillis() - d.b(d.this)) + " " + paramAnonymousd.field_filemd5);
          new j(com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(d.b(d.this)), Long.valueOf(bt.flT()), Integer.valueOf(com.tencent.mm.ao.c.cA(aj.getContext())), Integer.valueOf(d.iSz), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.fIT })).aLk();
          AppMethodBeat.o(63323);
          return 0;
        }
        if ((paramAnonymousd != null) && (paramAnonymousd.field_retCode != 0))
        {
          ad.i("MicroMsg.Aa.AAImagUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
          paramAnonymousString = com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), Integer.valueOf(1), Long.valueOf(d.b(d.this)), Long.valueOf(bt.flT()), Integer.valueOf(com.tencent.mm.ao.c.cA(aj.getContext())), Integer.valueOf(d.iSz), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.fIT });
          new j(paramAnonymousString).aLk();
          new h(paramAnonymousString).aLk();
          d.a(d.this).aRb();
          AppMethodBeat.o(63323);
          return 0;
        }
        if (paramAnonymousInt != 0)
        {
          ad.i("MicroMsg.Aa.AAImagUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
          if (paramAnonymousd != null) {
            new j(com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(d.b(d.this)), Long.valueOf(bt.flT()), Integer.valueOf(com.tencent.mm.ao.c.cA(aj.getContext())), Integer.valueOf(d.iSz), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.fIT })).aLk();
          }
          d.a(d.this).aRb();
          AppMethodBeat.o(63323);
          return 0;
        }
        ad.d("MicroMsg.Aa.AAImagUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
        AppMethodBeat.o(63323);
        return 0;
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return null;
      }
    };
    this.iSB = System.currentTimeMillis();
    this.dyy = paramString;
    this.iSA = parama;
    if (bt.isNullOrNil(this.dyy)) {}
    for (parama = "";; parama = com.tencent.mm.b.g.getMessageDigest(this.dyy.getBytes()))
    {
      this.mediaId = parama;
      ad.i("MicroMsg.Aa.AAImagUpload", "AAImagUpload imgPath:%s mediaId:%s", new Object[] { paramString, this.mediaId });
      AppMethodBeat.o(63324);
      return;
    }
  }
  
  public final boolean aRa()
  {
    AppMethodBeat.i(63325);
    com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
    localg.fJi = "task_AAImagUpload";
    localg.fJj = this.ibn;
    localg.field_mediaId = this.mediaId;
    localg.field_fullpath = this.dyy;
    localg.field_thumbpath = "";
    localg.field_fileType = 20301;
    localg.field_talker = "";
    localg.field_priority = com.tencent.mm.i.a.fIw;
    localg.field_needStorage = true;
    localg.field_isStreamMedia = false;
    localg.field_appType = 249;
    localg.field_bzScene = 2;
    if (!f.aGI().f(localg))
    {
      ad.e("MicroMsg.Aa.AAImagUpload", "cdntra addSendTask failed. mediaId:%s", new Object[] { this.mediaId });
      AppMethodBeat.o(63325);
      return false;
    }
    AppMethodBeat.o(63325);
    return true;
  }
  
  public static abstract interface a
  {
    public abstract void aRb();
    
    public abstract void bL(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.d
 * JD-Core Version:    0.7.0.1
 */