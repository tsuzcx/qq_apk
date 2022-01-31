package com.tencent.mm.modelvideo;

import com.tencent.mm.j.c;
import com.tencent.mm.j.d;
import com.tencent.mm.sdk.platformtools.y;
import java.io.ByteArrayOutputStream;

final class f$1
  implements com.tencent.mm.j.f.a
{
  f$1(f paramf) {}
  
  public final int a(String paramString, int paramInt, c paramc, d paramd, boolean paramBoolean)
  {
    if (paramInt != 0)
    {
      y.w("MicroMsg.NetScenePreloadVideoFake", "%d preload video error startRet[%d]", new Object[] { Integer.valueOf(this.eGg.hashCode()), Integer.valueOf(paramInt) });
      if (this.eGg.eGf != null) {
        this.eGg.eGf.a(this.eGg, false, 0, 0);
      }
    }
    if (paramc != null) {
      y.d("MicroMsg.NetScenePreloadVideoFake", "%d preload video[%d %d] mediaId[%s]", new Object[] { Integer.valueOf(this.eGg.hashCode()), Integer.valueOf(paramc.field_finishedLength), Integer.valueOf(paramc.field_toltalLength), paramString });
    }
    if (paramd != null)
    {
      y.i("MicroMsg.NetScenePreloadVideoFake", "%d preload video error [%d]", new Object[] { Integer.valueOf(this.eGg.hashCode()), Integer.valueOf(paramd.field_retCode) });
      if (paramd.field_retCode == 0) {
        break label195;
      }
      if (this.eGg.eGf != null) {
        this.eGg.eGf.a(this.eGg, false, 0, 0);
      }
    }
    return 0;
    label195:
    y.i("MicroMsg.NetScenePreloadVideoFake", "%d preload video download all video file", new Object[] { Integer.valueOf(this.eGg.hashCode()) });
    this.eGg.f(this.eGg.eFZ, paramd.field_fileLength, this.eGg.dme);
    return 0;
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public final byte[] f(String paramString, byte[] paramArrayOfByte)
  {
    return new byte[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.modelvideo.f.1
 * JD-Core Version:    0.7.0.1
 */