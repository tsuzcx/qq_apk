package com.tencent.mm.plugin.luckymoney.story;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vfs.o;
import java.io.ByteArrayOutputStream;

final class EnvelopeStoryVideoManager$2
  implements g.a
{
  EnvelopeStoryVideoManager$2(String paramString) {}
  
  public final int a(String paramString, int paramInt, c paramc, d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(182456);
    ae.i("MicroMsg.EnvelopeStoryVideoManager", "task callback: %s", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt != 0) {
      o.deleteFile(this.val$path);
    }
    AppMethodBeat.o(182456);
    return 0;
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public final byte[] f(String paramString, byte[] paramArrayOfByte)
  {
    return new byte[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.story.EnvelopeStoryVideoManager.2
 * JD-Core Version:    0.7.0.1
 */