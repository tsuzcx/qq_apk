package com.tencent.mm.media.g;

import android.opengl.GLES20;
import android.opengl.GLES30;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.Closeable;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/media/globject/GLFrameBufferObject;", "Ljava/io/Closeable;", "scene", "", "(J)V", "frameBufferId", "", "memRelease", "", "tid", "allocatedTid", "bind", "", "close", "finalize", "isClosed", "toString", "", "Companion", "plugin-mediaeditor_release"})
public final class a
  implements Closeable
{
  public static final a.a igq;
  volatile boolean ign;
  public int igo;
  private long igp;
  int tid;
  
  static
  {
    AppMethodBeat.i(93684);
    igq = new a.a((byte)0);
    AppMethodBeat.o(93684);
  }
  
  public a(long paramLong)
  {
    AppMethodBeat.i(93683);
    this.igo = -1;
    this.igp = 2L;
    this.tid = -1;
    this.igp = paramLong;
    Object localObject = b.igr;
    b.aMw();
    this.tid = Process.myTid();
    localObject = c.ilt;
    localObject = new int[1];
    GLES30.glGenFramebuffers(1, (int[])localObject, 0);
    if (localObject[0] == 0) {
      Log.e("MicroMsg.GLEnvironmentUtil", "gen frame buffer error");
    }
    for (;;)
    {
      this.igo = i;
      Log.i("MicroMsg.GLFrameBufferObject", "create frameBuffer:" + this.igo + " tid:" + this.tid + ", stackTrace:\t" + com.tencent.matrix.trace.g.b.getStack());
      AppMethodBeat.o(93683);
      return;
      i = localObject[0];
    }
  }
  
  public final void close()
  {
    AppMethodBeat.i(93680);
    if (this.ign)
    {
      Log.i("MicroMsg.GLFrameBufferObject", hashCode() + " close already close");
      AppMethodBeat.o(93680);
      return;
    }
    int i = Process.myTid();
    if (this.tid != i)
    {
      Log.e("MicroMsg.GLFrameBufferObject", hashCode() + " Leaked by different thread!!!  scene：" + this.igp + "  created in:" + this.tid + " release in:" + i + ", stackTrace:\t" + com.tencent.matrix.trace.g.b.getStack());
      localObject = b.igr;
      b.aMz();
      AppMethodBeat.o(93680);
      return;
    }
    this.ign = true;
    Object localObject = c.ilt;
    GLES20.glDeleteFramebuffers(1, new int[] { this.igo }, 0);
    Log.i("MicroMsg.GLFrameBufferObject", hashCode() + " close framebuffer:" + this.igo);
    AppMethodBeat.o(93680);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(93681);
    if (!this.ign)
    {
      b localb = b.igr;
      b.zH(this.igp);
      localb = b.igr;
      b.aMx();
      Log.e("MicroMsg.GLFrameBufferObject", hashCode() + " Leaked !!!  scene：" + this.igp);
      AppMethodBeat.o(93681);
      return;
    }
    Log.i("MicroMsg.GLFrameBufferObject", hashCode() + " release success!");
    AppMethodBeat.o(93681);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(93682);
    String str = "hashcode:" + hashCode() + " frameBufferId:" + this.igo + " memRelease:" + this.ign + " scene:" + this.igp + " create-tid:" + this.tid;
    AppMethodBeat.o(93682);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.g.a
 * JD-Core Version:    0.7.0.1
 */