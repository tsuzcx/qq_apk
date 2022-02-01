package com.tencent.mm.media.f;

import android.opengl.GLES20;
import android.opengl.GLES30;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.c;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;
import java.io.Closeable;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/media/globject/GLFrameBufferObject;", "Ljava/io/Closeable;", "scene", "", "(J)V", "frameBufferId", "", "memRelease", "", "tid", "allocatedTid", "bind", "", "close", "finalize", "isClosed", "toString", "", "Companion", "plugin-mediaeditor_release"})
public final class a
  implements Closeable
{
  public static final a.a gRR;
  volatile boolean gRO;
  public int gRP;
  private long gRQ;
  int tid;
  
  static
  {
    AppMethodBeat.i(93684);
    gRR = new a.a((byte)0);
    AppMethodBeat.o(93684);
  }
  
  public a(long paramLong)
  {
    AppMethodBeat.i(93683);
    this.gRO = true;
    this.gRP = -1;
    this.gRQ = 2L;
    this.tid = -1;
    this.gRQ = paramLong;
    Object localObject = b.gRS;
    b.aqR();
    this.tid = Process.myTid();
    localObject = c.gWJ;
    localObject = new int[1];
    GLES30.glGenFramebuffers(1, (int[])localObject, 0);
    if (localObject[0] == 0) {
      ac.e("MicroMsg.GLEnvironmentUtil", "gen frame buffer error");
    }
    for (;;)
    {
      this.gRP = i;
      ac.i("MicroMsg.GLFrameBufferObject", "create frameBuffer:" + this.gRP + " tid:" + this.tid + ", stackTrace:\t" + com.tencent.matrix.trace.g.b.getStack());
      AppMethodBeat.o(93683);
      return;
      i = localObject[0];
    }
  }
  
  public final void close()
  {
    AppMethodBeat.i(93680);
    if (this.gRO)
    {
      ac.i("MicroMsg.GLFrameBufferObject", hashCode() + " close already close");
      AppMethodBeat.o(93680);
      return;
    }
    int i = Process.myTid();
    if (this.tid != i)
    {
      ac.e("MicroMsg.GLFrameBufferObject", hashCode() + " Leaked by different thread!!!  scene：" + this.gRQ + "  created in:" + this.tid + " release in:" + i + ", stackTrace:\t" + com.tencent.matrix.trace.g.b.getStack());
      localObject = b.gRS;
      b.aqU();
      AppMethodBeat.o(93680);
      return;
    }
    this.gRO = true;
    Object localObject = c.gWJ;
    GLES20.glDeleteFramebuffers(1, new int[] { this.gRP }, 0);
    ac.i("MicroMsg.GLFrameBufferObject", hashCode() + " close framebuffer:" + this.gRP);
    AppMethodBeat.o(93680);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(93681);
    if (!this.gRO)
    {
      b localb = b.gRS;
      b.pp(this.gRQ);
      localb = b.gRS;
      b.aqS();
      ac.e("MicroMsg.GLFrameBufferObject", hashCode() + " Leaked !!!  scene：" + this.gRQ);
      AppMethodBeat.o(93681);
      return;
    }
    ac.i("MicroMsg.GLFrameBufferObject", hashCode() + " release success!");
    AppMethodBeat.o(93681);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(93682);
    String str = "hashcode:" + hashCode() + " frameBufferId:" + this.gRP + " memRelease:" + this.gRO + " scene:" + this.gRQ + " create-tid:" + this.tid;
    AppMethodBeat.o(93682);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.media.f.a
 * JD-Core Version:    0.7.0.1
 */