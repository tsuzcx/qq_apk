package com.tencent.mm.plugin.aa.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.b;
import com.tencent.mm.an.f;
import com.tencent.mm.g.b.a.w;
import com.tencent.mm.g.b.a.y;
import com.tencent.mm.i.g.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.ByteArrayOutputStream;

public final class d
{
  public static int jSm = 20301;
  private String dRr;
  private g.a iZc;
  private a jSn;
  private long jSo;
  private String mediaId;
  
  public d(String paramString, a parama)
  {
    AppMethodBeat.i(63324);
    this.jSo = 0L;
    this.iZc = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(63323);
        if (paramAnonymousInt == -21005)
        {
          Log.d("MicroMsg.Aa.AAImagUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
          AppMethodBeat.o(63323);
          return 0;
        }
        if ((paramAnonymousd != null) && (paramAnonymousd.field_retCode == 0))
        {
          Log.i("MicroMsg.Aa.AAImagUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
          d.a(d.this).bU(paramAnonymousd.field_fileUrl, paramAnonymousd.field_thumbUrl);
          Log.i("MicroMsg.Aa.AAImagUpload", "uploadsns cdndone pass: " + (System.currentTimeMillis() - d.b(d.this)) + " " + paramAnonymousd.field_filemd5);
          new y(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(d.b(d.this)), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(d.jSm), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.gqk })).bfK();
          AppMethodBeat.o(63323);
          return 0;
        }
        if ((paramAnonymousd != null) && (paramAnonymousd.field_retCode != 0))
        {
          Log.i("MicroMsg.Aa.AAImagUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
          paramAnonymousString = com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), Integer.valueOf(1), Long.valueOf(d.b(d.this)), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(d.jSm), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.gqk });
          new y(paramAnonymousString).bfK();
          new w(paramAnonymousString).bfK();
          d.a(d.this).bme();
          AppMethodBeat.o(63323);
          return 0;
        }
        if (paramAnonymousInt != 0)
        {
          Log.i("MicroMsg.Aa.AAImagUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
          if (paramAnonymousd != null) {
            new y(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(d.b(d.this)), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(d.jSm), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.gqk })).bfK();
          }
          d.a(d.this).bme();
          AppMethodBeat.o(63323);
          return 0;
        }
        Log.d("MicroMsg.Aa.AAImagUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
        AppMethodBeat.o(63323);
        return 0;
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return null;
      }
    };
    this.jSo = System.currentTimeMillis();
    this.dRr = paramString;
    this.jSn = parama;
    if (Util.isNullOrNil(this.dRr)) {}
    for (parama = "";; parama = com.tencent.mm.b.g.getMessageDigest(this.dRr.getBytes()))
    {
      this.mediaId = parama;
      Log.i("MicroMsg.Aa.AAImagUpload", "AAImagUpload imgPath:%s mediaId:%s", new Object[] { paramString, this.mediaId });
      AppMethodBeat.o(63324);
      return;
    }
  }
  
  public final boolean bmd()
  {
    AppMethodBeat.i(63325);
    com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
    localg.taskName = "task_AAImagUpload";
    localg.gqy = this.iZc;
    localg.field_mediaId = this.mediaId;
    localg.field_fullpath = this.dRr;
    localg.field_thumbpath = "";
    localg.field_fileType = 20301;
    localg.field_talker = "";
    localg.field_priority = com.tencent.mm.i.a.gpM;
    localg.field_needStorage = true;
    localg.field_isStreamMedia = false;
    localg.field_appType = 249;
    localg.field_bzScene = 2;
    if (!f.baQ().f(localg))
    {
      Log.e("MicroMsg.Aa.AAImagUpload", "cdntra addSendTask failed. mediaId:%s", new Object[] { this.mediaId });
      AppMethodBeat.o(63325);
      return false;
    }
    AppMethodBeat.o(63325);
    return true;
  }
  
  public static abstract interface a
  {
    public abstract void bU(String paramString1, String paramString2);
    
    public abstract void bme();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.d
 * JD-Core Version:    0.7.0.1
 */