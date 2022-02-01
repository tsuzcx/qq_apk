package com.tencent.mm.plugin.aa.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a;
import com.tencent.mm.g.c;
import com.tencent.mm.g.d;
import com.tencent.mm.g.g.a;
import com.tencent.mm.modelcdntran.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.ByteArrayOutputStream;

public final class e
{
  public static int osI = 20301;
  private String hQn;
  private String mediaId;
  private long osG;
  private g.a osH;
  private a pGi;
  
  public e(String paramString, a parama)
  {
    AppMethodBeat.i(63324);
    this.osG = 0L;
    this.osH = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, c paramAnonymousc, d paramAnonymousd, boolean paramAnonymousBoolean)
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
          e.a(e.this).cp(paramAnonymousd.field_fileUrl, paramAnonymousd.field_thumbUrl);
          Log.i("MicroMsg.Aa.AAImagUpload", "uploadsns cdndone pass: " + (System.currentTimeMillis() - e.b(e.this)) + " " + paramAnonymousd.field_filemd5);
          AppMethodBeat.o(63323);
          return 0;
        }
        if ((paramAnonymousd != null) && (paramAnonymousd.field_retCode != 0))
        {
          Log.i("MicroMsg.Aa.AAImagUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
          e.a(e.this).bVe();
          AppMethodBeat.o(63323);
          return 0;
        }
        if (paramAnonymousInt != 0)
        {
          Log.i("MicroMsg.Aa.AAImagUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
          e.a(e.this).bVe();
          AppMethodBeat.o(63323);
          return 0;
        }
        Log.d("MicroMsg.Aa.AAImagUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
        AppMethodBeat.o(63323);
        return 0;
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] h(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return null;
      }
    };
    this.osG = System.currentTimeMillis();
    this.hQn = paramString;
    this.pGi = parama;
    if (Util.isNullOrNil(this.hQn)) {}
    for (parama = "";; parama = com.tencent.mm.b.g.getMessageDigest(this.hQn.getBytes()))
    {
      this.mediaId = parama;
      Log.i("MicroMsg.Aa.AAImagUpload", "AAImagUpload imgPath:%s mediaId:%s", new Object[] { paramString, this.mediaId });
      AppMethodBeat.o(63324);
      return;
    }
  }
  
  public final boolean bFu()
  {
    AppMethodBeat.i(63325);
    com.tencent.mm.g.g localg = new com.tencent.mm.g.g();
    localg.taskName = "task_AAImagUpload";
    localg.lwL = this.osH;
    localg.field_mediaId = this.mediaId;
    localg.field_fullpath = this.hQn;
    localg.field_thumbpath = "";
    localg.field_fileType = 20301;
    localg.field_talker = "";
    localg.field_priority = a.lvZ;
    localg.field_needStorage = true;
    localg.field_isStreamMedia = false;
    localg.field_appType = 249;
    localg.field_bzScene = 2;
    if (!k.bHW().g(localg))
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
    public abstract void bVe();
    
    public abstract void cp(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.e
 * JD-Core Version:    0.7.0.1
 */