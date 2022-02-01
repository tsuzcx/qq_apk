package com.tencent.mm.media.g;

import android.opengl.GLES20;
import android.opengl.GLES30;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.c;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;
import java.io.Closeable;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/media/globject/GLFrameBufferObject;", "Ljava/io/Closeable;", "scene", "", "(J)V", "frameBufferId", "", "memRelease", "", "tid", "allocatedTid", "bind", "", "close", "finalize", "isClosed", "toString", "", "Companion", "plugin-mediaeditor_release"})
public final class a
  implements Closeable
{
  public static final a.a hkj;
  volatile boolean hkg;
  public int hkh;
  private long hki;
  int tid;
  
  static
  {
    AppMethodBeat.i(93684);
    hkj = new a.a((byte)0);
    AppMethodBeat.o(93684);
  }
  
  public a(long paramLong)
  {
    AppMethodBeat.i(93683);
    this.hkh = -1;
    this.hki = 2L;
    this.tid = -1;
    this.hki = paramLong;
    Object localObject = b.hkk;
    b.atF();
    this.tid = Process.myTid();
    localObject = c.hoP;
    localObject = new int[1];
    GLES30.glGenFramebuffers(1, (int[])localObject, 0);
    if (localObject[0] == 0) {
      ad.e("MicroMsg.GLEnvironmentUtil", "gen frame buffer error");
    }
    for (;;)
    {
      this.hkh = i;
      ad.i("MicroMsg.GLFrameBufferObject", "create frameBuffer:" + this.hkh + " tid:" + this.tid + ", stackTrace:\t" + com.tencent.matrix.trace.g.b.getStack());
      AppMethodBeat.o(93683);
      return;
      i = localObject[0];
    }
  }
  
  public final void close()
  {
    AppMethodBeat.i(93680);
    if (this.hkg)
    {
      ad.i("MicroMsg.GLFrameBufferObject", hashCode() + " close already close");
      AppMethodBeat.o(93680);
      return;
    }
    int i = Process.myTid();
    if (this.tid != i)
    {
      ad.e("MicroMsg.GLFrameBufferObject", hashCode() + " Leaked by different thread!!!  scene：" + this.hki + "  created in:" + this.tid + " release in:" + i + ", stackTrace:\t" + com.tencent.matrix.trace.g.b.getStack());
      localObject = b.hkk;
      b.atI();
      AppMethodBeat.o(93680);
      return;
    }
    this.hkg = true;
    Object localObject = c.hoP;
    GLES20.glDeleteFramebuffers(1, new int[] { this.hkh }, 0);
    ad.i("MicroMsg.GLFrameBufferObject", hashCode() + " close framebuffer:" + this.hkh);
    AppMethodBeat.o(93680);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(93681);
    if (!this.hkg)
    {
      b localb = b.hkk;
      b.rp(this.hki);
      localb = b.hkk;
      b.atG();
      ad.e("MicroMsg.GLFrameBufferObject", hashCode() + " Leaked !!!  scene：" + this.hki);
      AppMethodBeat.o(93681);
      return;
    }
    ad.i("MicroMsg.GLFrameBufferObject", hashCode() + " release success!");
    AppMethodBeat.o(93681);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(93682);
    String str = "hashcode:" + hashCode() + " frameBufferId:" + this.hkh + " memRelease:" + this.hkg + " scene:" + this.hki + " create-tid:" + this.tid;
    AppMethodBeat.o(93682);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.g.a
 * JD-Core Version:    0.7.0.1
 */