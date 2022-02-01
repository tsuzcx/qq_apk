package com.tencent.mm.media.g;

import android.opengl.GLES20;
import android.opengl.GLES30;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.Closeable;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/globject/GLFrameBufferObject;", "Ljava/io/Closeable;", "scene", "", "(J)V", "frameBufferId", "", "memRelease", "", "tid", "allocatedTid", "bind", "", "close", "finalize", "isClosed", "toString", "", "Companion", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements Closeable
{
  public static final a.a nAw;
  volatile boolean nAx;
  public int nAy;
  private long nAz;
  int tid;
  
  static
  {
    AppMethodBeat.i(93684);
    nAw = new a.a((byte)0);
    AppMethodBeat.o(93684);
  }
  
  public a(long paramLong)
  {
    AppMethodBeat.i(93683);
    this.nAy = -1;
    this.nAz = 2L;
    this.tid = -1;
    this.nAz = paramLong;
    Object localObject = b.nAA;
    b.bpt();
    this.tid = Process.myTid();
    localObject = com.tencent.mm.media.util.c.nFs;
    localObject = new int[1];
    GLES30.glGenFramebuffers(1, (int[])localObject, 0);
    if (localObject[0] == 0) {
      Log.e("MicroMsg.GLEnvironmentUtil", "gen frame buffer error");
    }
    for (;;)
    {
      this.nAy = i;
      Log.i("MicroMsg.GLFrameBufferObject", "create frameBuffer:" + this.nAy + " tid:" + this.tid + ", stackTrace:\t" + com.tencent.matrix.trace.f.c.getStack());
      AppMethodBeat.o(93683);
      return;
      i = localObject[0];
    }
  }
  
  public final void close()
  {
    AppMethodBeat.i(93680);
    if (this.nAx)
    {
      Log.i("MicroMsg.GLFrameBufferObject", hashCode() + " close already close");
      AppMethodBeat.o(93680);
      return;
    }
    int i = Process.myTid();
    if (this.tid != i)
    {
      Log.e("MicroMsg.GLFrameBufferObject", hashCode() + " Leaked by different thread!!!  scene：" + this.nAz + "  created in:" + this.tid + " release in:" + i + ", stackTrace:\t" + com.tencent.matrix.trace.f.c.getStack());
      localObject = b.nAA;
      b.bpw();
      AppMethodBeat.o(93680);
      return;
    }
    this.nAx = true;
    Object localObject = com.tencent.mm.media.util.c.nFs;
    GLES20.glDeleteFramebuffers(1, new int[] { this.nAy }, 0);
    Log.i("MicroMsg.GLFrameBufferObject", hashCode() + " close framebuffer:" + this.nAy);
    AppMethodBeat.o(93680);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(93681);
    if (!this.nAx)
    {
      b localb = b.nAA;
      b.hW(this.nAz);
      localb = b.nAA;
      b.bpu();
      Log.e("MicroMsg.GLFrameBufferObject", hashCode() + " Leaked !!!  scene：" + this.nAz);
      AppMethodBeat.o(93681);
      return;
    }
    Log.i("MicroMsg.GLFrameBufferObject", hashCode() + " release success!");
    AppMethodBeat.o(93681);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(93682);
    String str = "hashcode:" + hashCode() + " frameBufferId:" + this.nAy + " memRelease:" + this.nAx + " scene:" + this.nAz + " create-tid:" + this.tid;
    AppMethodBeat.o(93682);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.g.a
 * JD-Core Version:    0.7.0.1
 */