package com.tencent.mm.plugin.aa.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.b;
import com.tencent.mm.an.f;
import com.tencent.mm.g.b.a.h;
import com.tencent.mm.g.b.a.j;
import com.tencent.mm.i.g.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import java.io.ByteArrayOutputStream;

public final class d
{
  public static int iVs = 20301;
  private String dzD;
  private a iVt;
  private long iVu;
  private g.a ieg;
  private String mediaId;
  
  public d(String paramString, a parama)
  {
    AppMethodBeat.i(63324);
    this.iVu = 0L;
    this.ieg = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(63323);
        if (paramAnonymousInt == -21005)
        {
          ae.d("MicroMsg.Aa.AAImagUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
          AppMethodBeat.o(63323);
          return 0;
        }
        if ((paramAnonymousd != null) && (paramAnonymousd.field_retCode == 0))
        {
          ae.i("MicroMsg.Aa.AAImagUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
          d.a(d.this).bL(paramAnonymousd.field_fileUrl, paramAnonymousd.field_thumbUrl);
          ae.i("MicroMsg.Aa.AAImagUpload", "uploadsns cdndone pass: " + (System.currentTimeMillis() - d.b(d.this)) + " " + paramAnonymousd.field_filemd5);
          new j(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(d.b(d.this)), Long.valueOf(bu.fpO()), Integer.valueOf(com.tencent.mm.an.c.cC(ak.getContext())), Integer.valueOf(d.iVs), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.fKX })).aLH();
          AppMethodBeat.o(63323);
          return 0;
        }
        if ((paramAnonymousd != null) && (paramAnonymousd.field_retCode != 0))
        {
          ae.i("MicroMsg.Aa.AAImagUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
          paramAnonymousString = com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), Integer.valueOf(1), Long.valueOf(d.b(d.this)), Long.valueOf(bu.fpO()), Integer.valueOf(com.tencent.mm.an.c.cC(ak.getContext())), Integer.valueOf(d.iVs), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.fKX });
          new j(paramAnonymousString).aLH();
          new h(paramAnonymousString).aLH();
          d.a(d.this).aRA();
          AppMethodBeat.o(63323);
          return 0;
        }
        if (paramAnonymousInt != 0)
        {
          ae.i("MicroMsg.Aa.AAImagUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
          if (paramAnonymousd != null) {
            new j(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(d.b(d.this)), Long.valueOf(bu.fpO()), Integer.valueOf(com.tencent.mm.an.c.cC(ak.getContext())), Integer.valueOf(d.iVs), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.fKX })).aLH();
          }
          d.a(d.this).aRA();
          AppMethodBeat.o(63323);
          return 0;
        }
        ae.d("MicroMsg.Aa.AAImagUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
        AppMethodBeat.o(63323);
        return 0;
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return null;
      }
    };
    this.iVu = System.currentTimeMillis();
    this.dzD = paramString;
    this.iVt = parama;
    if (bu.isNullOrNil(this.dzD)) {}
    for (parama = "";; parama = com.tencent.mm.b.g.getMessageDigest(this.dzD.getBytes()))
    {
      this.mediaId = parama;
      ae.i("MicroMsg.Aa.AAImagUpload", "AAImagUpload imgPath:%s mediaId:%s", new Object[] { paramString, this.mediaId });
      AppMethodBeat.o(63324);
      return;
    }
  }
  
  public final boolean aRz()
  {
    AppMethodBeat.i(63325);
    com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
    localg.fLl = "task_AAImagUpload";
    localg.fLm = this.ieg;
    localg.field_mediaId = this.mediaId;
    localg.field_fullpath = this.dzD;
    localg.field_thumbpath = "";
    localg.field_fileType = 20301;
    localg.field_talker = "";
    localg.field_priority = com.tencent.mm.i.a.fKA;
    localg.field_needStorage = true;
    localg.field_isStreamMedia = false;
    localg.field_appType = 249;
    localg.field_bzScene = 2;
    if (!f.aGZ().f(localg))
    {
      ae.e("MicroMsg.Aa.AAImagUpload", "cdntra addSendTask failed. mediaId:%s", new Object[] { this.mediaId });
      AppMethodBeat.o(63325);
      return false;
    }
    AppMethodBeat.o(63325);
    return true;
  }
  
  public static abstract interface a
  {
    public abstract void aRA();
    
    public abstract void bL(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.d
 * JD-Core Version:    0.7.0.1
 */