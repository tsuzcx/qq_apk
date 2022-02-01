package com.tencent.mm.media.f;

import android.opengl.GLES20;
import android.opengl.GLES30;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.c;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;
import java.io.Closeable;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/media/globject/GLFrameBufferObject;", "Ljava/io/Closeable;", "scene", "", "(J)V", "frameBufferId", "", "memRelease", "", "tid", "allocatedTid", "bind", "", "close", "finalize", "isClosed", "toString", "", "Companion", "plugin-mediaeditor_release"})
public final class a
  implements Closeable
{
  public static final a.a grj;
  volatile boolean grg;
  public int grh;
  private long gri;
  int tid;
  
  static
  {
    AppMethodBeat.i(93684);
    grj = new a.a((byte)0);
    AppMethodBeat.o(93684);
  }
  
  public a(long paramLong)
  {
    AppMethodBeat.i(93683);
    this.grg = true;
    this.grh = -1;
    this.gri = 2L;
    this.tid = -1;
    this.gri = paramLong;
    Object localObject = b.grk;
    b.ajS();
    this.tid = Process.myTid();
    localObject = c.gwl;
    localObject = new int[1];
    GLES30.glGenFramebuffers(1, (int[])localObject, 0);
    if (localObject[0] == 0) {
      ad.e("MicroMsg.GLEnvironmentUtil", "gen frame buffer error");
    }
    for (;;)
    {
      this.grh = i;
      ad.i("MicroMsg.GLFrameBufferObject", "create frameBuffer:" + this.grh + " tid:" + this.tid + ", stackTrace:\t" + com.tencent.matrix.trace.g.b.getStack());
      AppMethodBeat.o(93683);
      return;
      i = localObject[0];
    }
  }
  
  public final void close()
  {
    AppMethodBeat.i(93680);
    if (this.grg)
    {
      ad.i("MicroMsg.GLFrameBufferObject", hashCode() + " close already close");
      AppMethodBeat.o(93680);
      return;
    }
    int i = Process.myTid();
    if (this.tid != i)
    {
      ad.e("MicroMsg.GLFrameBufferObject", hashCode() + " Leaked by different thread!!!  scene：" + this.gri + "  created in:" + this.tid + " release in:" + i + ", stackTrace:\t" + com.tencent.matrix.trace.g.b.getStack());
      localObject = b.grk;
      b.ajV();
      AppMethodBeat.o(93680);
      return;
    }
    this.grg = true;
    Object localObject = c.gwl;
    GLES20.glDeleteFramebuffers(1, new int[] { this.grh }, 0);
    ad.i("MicroMsg.GLFrameBufferObject", hashCode() + " close framebuffer:" + this.grh);
    AppMethodBeat.o(93680);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(93681);
    if (!this.grg)
    {
      b localb = b.grk;
      b.lB(this.gri);
      localb = b.grk;
      b.ajT();
      ad.e("MicroMsg.GLFrameBufferObject", hashCode() + " Leaked !!!  scene：" + this.gri);
      AppMethodBeat.o(93681);
      return;
    }
    ad.i("MicroMsg.GLFrameBufferObject", hashCode() + " release success!");
    AppMethodBeat.o(93681);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(93682);
    String str = "hashcode:" + hashCode() + " frameBufferId:" + this.grh + " memRelease:" + this.grg + " scene:" + this.gri + " create-tid:" + this.tid;
    AppMethodBeat.o(93682);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.media.f.a
 * JD-Core Version:    0.7.0.1
 */