package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.ByteArrayOutputStream;

final class f$1
  implements g.a
{
  f$1(f paramf) {}
  
  public final int a(String paramString, int paramInt, c paramc, d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(50682);
    if (paramInt != 0)
    {
      ab.w("MicroMsg.NetScenePreloadVideoFake", "%d preload video error startRet[%d]", new Object[] { Integer.valueOf(this.fVX.hashCode()), Integer.valueOf(paramInt) });
      if (this.fVX.fVW != null) {
        this.fVX.fVW.a(this.fVX, false, 0, 0);
      }
    }
    if (paramc != null) {
      ab.d("MicroMsg.NetScenePreloadVideoFake", "%d preload video[%d %d] mediaId[%s]", new Object[] { Integer.valueOf(this.fVX.hashCode()), Integer.valueOf(paramc.field_finishedLength), Integer.valueOf(paramc.field_toltalLength), paramString });
    }
    if (paramd != null)
    {
      ab.i("MicroMsg.NetScenePreloadVideoFake", "%d preload video error [%d]", new Object[] { Integer.valueOf(this.fVX.hashCode()), Integer.valueOf(paramd.field_retCode) });
      if (paramd.field_retCode == 0) {
        break label205;
      }
      if (this.fVX.fVW != null) {
        this.fVX.fVW.a(this.fVX, false, 0, 0);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(50682);
      return 0;
      label205:
      ab.i("MicroMsg.NetScenePreloadVideoFake", "%d preload video download all video file", new Object[] { Integer.valueOf(this.fVX.hashCode()) });
      this.fVX.e(this.fVX.fVQ, paramd.field_fileLength, this.fVX.edH);
    }
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public final byte[] l(String paramString, byte[] paramArrayOfByte)
  {
    return new byte[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelvideo.f.1
 * JD-Core Version:    0.7.0.1
 */