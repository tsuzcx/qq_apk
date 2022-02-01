package com.tencent.mm.media.g;

import android.opengl.GLES20;
import android.opengl.GLES30;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.c;
import com.tencent.mm.sdk.platformtools.ae;
import d.l;
import java.io.Closeable;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/media/globject/GLFrameBufferObject;", "Ljava/io/Closeable;", "scene", "", "(J)V", "frameBufferId", "", "memRelease", "", "tid", "allocatedTid", "bind", "", "close", "finalize", "isClosed", "toString", "", "Companion", "plugin-mediaeditor_release"})
public final class a
  implements Closeable
{
  public static final a.a hmX;
  volatile boolean hmU;
  public int hmV;
  private long hmW;
  int tid;
  
  static
  {
    AppMethodBeat.i(93684);
    hmX = new a.a((byte)0);
    AppMethodBeat.o(93684);
  }
  
  public a(long paramLong)
  {
    AppMethodBeat.i(93683);
    this.hmV = -1;
    this.hmW = 2L;
    this.tid = -1;
    this.hmW = paramLong;
    Object localObject = b.hmY;
    b.atU();
    this.tid = Process.myTid();
    localObject = c.hrD;
    localObject = new int[1];
    GLES30.glGenFramebuffers(1, (int[])localObject, 0);
    if (localObject[0] == 0) {
      ae.e("MicroMsg.GLEnvironmentUtil", "gen frame buffer error");
    }
    for (;;)
    {
      this.hmV = i;
      ae.i("MicroMsg.GLFrameBufferObject", "create frameBuffer:" + this.hmV + " tid:" + this.tid + ", stackTrace:\t" + com.tencent.matrix.trace.g.b.getStack());
      AppMethodBeat.o(93683);
      return;
      i = localObject[0];
    }
  }
  
  public final void close()
  {
    AppMethodBeat.i(93680);
    if (this.hmU)
    {
      ae.i("MicroMsg.GLFrameBufferObject", hashCode() + " close already close");
      AppMethodBeat.o(93680);
      return;
    }
    int i = Process.myTid();
    if (this.tid != i)
    {
      ae.e("MicroMsg.GLFrameBufferObject", hashCode() + " Leaked by different thread!!!  scene：" + this.hmW + "  created in:" + this.tid + " release in:" + i + ", stackTrace:\t" + com.tencent.matrix.trace.g.b.getStack());
      localObject = b.hmY;
      b.atX();
      AppMethodBeat.o(93680);
      return;
    }
    this.hmU = true;
    Object localObject = c.hrD;
    GLES20.glDeleteFramebuffers(1, new int[] { this.hmV }, 0);
    ae.i("MicroMsg.GLFrameBufferObject", hashCode() + " close framebuffer:" + this.hmV);
    AppMethodBeat.o(93680);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(93681);
    if (!this.hmU)
    {
      b localb = b.hmY;
      b.rC(this.hmW);
      localb = b.hmY;
      b.atV();
      ae.e("MicroMsg.GLFrameBufferObject", hashCode() + " Leaked !!!  scene：" + this.hmW);
      AppMethodBeat.o(93681);
      return;
    }
    ae.i("MicroMsg.GLFrameBufferObject", hashCode() + " release success!");
    AppMethodBeat.o(93681);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(93682);
    String str = "hashcode:" + hashCode() + " frameBufferId:" + this.hmV + " memRelease:" + this.hmU + " scene:" + this.hmW + " create-tid:" + this.tid;
    AppMethodBeat.o(93682);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.g.a
 * JD-Core Version:    0.7.0.1
 */