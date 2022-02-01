package com.tencent.mm.media.g;

import android.opengl.GLES20;
import android.opengl.GLES30;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.Closeable;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/globject/GLFrameBufferObject;", "Ljava/io/Closeable;", "scene", "", "(J)V", "frameBufferId", "", "memRelease", "", "tid", "allocatedTid", "bind", "", "close", "finalize", "isClosed", "toString", "", "Companion", "plugin-mediaeditor_release"})
public final class a
  implements Closeable
{
  public static final a kVe;
  volatile boolean kVb;
  public int kVc;
  private long kVd;
  int tid;
  
  static
  {
    AppMethodBeat.i(93684);
    kVe = new a((byte)0);
    AppMethodBeat.o(93684);
  }
  
  public a(long paramLong)
  {
    AppMethodBeat.i(93683);
    this.kVc = -1;
    this.kVd = 2L;
    this.tid = -1;
    this.kVd = paramLong;
    Object localObject = b.kVf;
    b.aUM();
    this.tid = Process.myTid();
    localObject = c.lar;
    localObject = new int[1];
    GLES30.glGenFramebuffers(1, (int[])localObject, 0);
    if (localObject[0] == 0) {
      Log.e("MicroMsg.GLEnvironmentUtil", "gen frame buffer error");
    }
    for (;;)
    {
      this.kVc = i;
      Log.i("MicroMsg.GLFrameBufferObject", "create frameBuffer:" + this.kVc + " tid:" + this.tid + ", stackTrace:\t" + com.tencent.matrix.trace.g.b.getStack());
      AppMethodBeat.o(93683);
      return;
      i = localObject[0];
    }
  }
  
  public final void close()
  {
    AppMethodBeat.i(93680);
    if (this.kVb)
    {
      Log.i("MicroMsg.GLFrameBufferObject", hashCode() + " close already close");
      AppMethodBeat.o(93680);
      return;
    }
    int i = Process.myTid();
    if (this.tid != i)
    {
      Log.e("MicroMsg.GLFrameBufferObject", hashCode() + " Leaked by different thread!!!  scene：" + this.kVd + "  created in:" + this.tid + " release in:" + i + ", stackTrace:\t" + com.tencent.matrix.trace.g.b.getStack());
      localObject = b.kVf;
      b.aUP();
      AppMethodBeat.o(93680);
      return;
    }
    this.kVb = true;
    Object localObject = c.lar;
    GLES20.glDeleteFramebuffers(1, new int[] { this.kVc }, 0);
    Log.i("MicroMsg.GLFrameBufferObject", hashCode() + " close framebuffer:" + this.kVc);
    AppMethodBeat.o(93680);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(93681);
    if (!this.kVb)
    {
      b localb = b.kVf;
      b.FO(this.kVd);
      localb = b.kVf;
      b.aUN();
      Log.e("MicroMsg.GLFrameBufferObject", hashCode() + " Leaked !!!  scene：" + this.kVd);
      AppMethodBeat.o(93681);
      return;
    }
    Log.i("MicroMsg.GLFrameBufferObject", hashCode() + " release success!");
    AppMethodBeat.o(93681);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(93682);
    String str = "hashcode:" + hashCode() + " frameBufferId:" + this.kVc + " memRelease:" + this.kVb + " scene:" + this.kVd + " create-tid:" + this.tid;
    AppMethodBeat.o(93682);
    return str;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/globject/GLFrameBufferObject$Companion;", "", "()V", "TAG", "", "plugin-mediaeditor_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.g.a
 * JD-Core Version:    0.7.0.1
 */