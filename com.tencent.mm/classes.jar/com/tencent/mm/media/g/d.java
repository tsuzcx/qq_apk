package com.tencent.mm.media.g;

import android.opengl.GLES20;
import android.opengl.GLES30;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.c;
import com.tencent.mm.media.k.c.a;
import com.tencent.mm.sdk.platformtools.ae;
import d.l;
import java.io.Closeable;
import java.nio.Buffer;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/media/globject/GLTextureObject;", "Ljava/io/Closeable;", "sampler2D", "", "scene", "", "(ZJ)V", "height", "", "internalFormat", "memRelease", "texID", "tid", "width", "allocTexMem", "", "pixels", "Ljava/nio/Buffer;", "minMagFilter", "wrapST", "allocTexMemFromBitmap", "bitmap", "Landroid/graphics/Bitmap;", "allocatedTid", "bind", "bindFrameBuffer", "frameBuffer", "Lcom/tencent/mm/media/globject/GLFrameBufferObject;", "checkFrameBufferStatus", "close", "finalize", "initInGLThread", "isClosed", "isExternalTexture", "isSample2DTexture", "setSize", "texFormatByteSize", "texMemorySize", "toString", "", "Companion", "plugin-mediaeditor_release"})
public final class d
  implements Closeable
{
  public static final d.a hnf;
  public int height;
  volatile boolean hmU;
  private long hmW;
  public int hnc;
  private boolean hnd;
  private int hne;
  int tid;
  public int width;
  
  static
  {
    AppMethodBeat.i(93708);
    hnf = new d.a((byte)0);
    AppMethodBeat.o(93708);
  }
  
  public d(boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(93707);
    this.hmU = true;
    this.hnc = -1;
    this.hmW = 2L;
    this.tid = -1;
    this.width = -1;
    this.height = -1;
    this.hne = 6408;
    this.hmW = paramLong;
    if (this.hmW < 0L) {
      this.hmW = 15L;
    }
    Object localObject = b.hmY;
    b.atS();
    this.hmU = false;
    this.tid = Process.myTid();
    this.hnd = paramBoolean;
    if (paramBoolean) {
      localObject = c.hrD;
    }
    for (this.hnc = c.a.auw();; this.hnc = localObject[0])
    {
      ae.i("MicroMsg.GLTextureObject", hashCode() + " create texID:" + this.hnc + "  sampler2D:" + paramBoolean + " tid:" + this.tid + ", stackTrace:\t" + com.tencent.matrix.trace.g.b.getStack());
      AppMethodBeat.o(93707);
      return;
      localObject = c.hrD;
      localObject = new int[1];
      GLES30.glGenTextures(1, (int[])localObject, 0);
      GLES30.glBindTexture(36197, localObject[0]);
      GLES30.glTexParameteri(36197, 10241, 9729);
      GLES30.glTexParameteri(36197, 10240, 9729);
      GLES30.glTexParameteri(36197, 10242, 33071);
      GLES30.glTexParameteri(36197, 10243, 33071);
      GLES30.glBindTexture(36197, 0);
      c.a.yS("glGenTextures");
    }
  }
  
  private int atZ()
  {
    AppMethodBeat.i(93703);
    if (this.hnd)
    {
      i = this.width;
      int j = this.height;
      int k = aua();
      AppMethodBeat.o(93703);
      return i * j * k;
    }
    int i = this.width * this.height * 3 / 2;
    AppMethodBeat.o(93703);
    return i;
  }
  
  private final int aua()
  {
    int i = 32;
    switch (this.hne)
    {
    default: 
      i = 24;
    case 6408: 
    case 6409: 
    case 6410: 
      return i;
    }
    return 24;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, Buffer paramBuffer, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(93699);
    if ((paramInt1 != this.width) || (paramInt2 != this.height) || (paramInt3 != this.hne) || (paramBuffer != null))
    {
      ae.i("MicroMsg.GLTextureObject", hashCode() + " allocTexMem, width:" + paramInt1 + ", height:" + paramInt2 + ", internalFormat:" + paramInt3 + ", memorySize:" + atZ());
      GLES20.glBindTexture(3553, this.hnc);
      GLES20.glTexImage2D(3553, 0, paramInt3, paramInt1, paramInt2, 0, paramInt3, 5121, paramBuffer);
      GLES20.glTexParameterf(3553, 10241, paramInt4);
      GLES20.glTexParameterf(3553, 10240, paramInt4);
      GLES20.glTexParameterf(3553, 10242, paramInt5);
      GLES20.glTexParameterf(3553, 10243, paramInt5);
      this.width = paramInt1;
      this.height = paramInt2;
      this.hne = paramInt3;
      AppMethodBeat.o(93699);
      return;
    }
    AppMethodBeat.o(93699);
  }
  
  public final void a(a parama, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(93702);
    if (parama != null)
    {
      c.a locala = c.hrD;
      c.a.a(parama, this, paramInt1, paramInt2);
    }
    paramInt1 = GLES20.glCheckFramebufferStatus(36160);
    if (paramInt1 != 36053) {
      switch (paramInt1)
      {
      case 36056: 
      case 36058: 
      case 36059: 
      case 36060: 
      default: 
        parama = "unknown error";
      }
    }
    for (;;)
    {
      ae.e("MicroMsg.GLTextureObject", "bind framebuffer status not complete, status:" + paramInt1 + " error:" + parama);
      AppMethodBeat.o(93702);
      return;
      parama = "GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT";
      continue;
      parama = "GL_FRAMEBUFFER_INCOMPLETE_DIMENSIONS";
      continue;
      parama = "GL_FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT";
      continue;
      parama = "GL_FRAMEBUFFER_UNSUPPORTED";
    }
  }
  
  public final boolean aub()
  {
    return !this.hnd;
  }
  
  public final void close()
  {
    AppMethodBeat.i(93704);
    if (this.hmU)
    {
      ae.i("MicroMsg.GLTextureObject", hashCode() + " tex already close");
      AppMethodBeat.o(93704);
      return;
    }
    int i = Process.myTid();
    if (this.tid != i)
    {
      ae.e("MicroMsg.GLTextureObject", hashCode() + " Leaked by different thread!!!  scene：" + this.hmW + "  created in:" + this.tid + " release in:" + i + ", stackTrace:\t" + com.tencent.matrix.trace.g.b.getStack());
      localObject = b.hmY;
      b.atW();
      this.hmU = false;
      AppMethodBeat.o(93704);
      return;
    }
    this.hmU = true;
    Object localObject = c.hrD;
    GLES20.glDeleteTextures(1, new int[] { this.hnc }, 0);
    ae.i("MicroMsg.GLTextureObject", hashCode() + " close texID:" + this.hnc + "  sampler2D:" + this.hnd + ", stacks:" + com.tencent.matrix.trace.g.b.getStack());
    AppMethodBeat.o(93704);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(93705);
    if (!this.hmU)
    {
      b localb = b.hmY;
      b.atT();
      localb = b.hmY;
      b.rB(this.hmW);
      ae.e("MicroMsg.GLTextureObject", hashCode() + " Leaked !!!  scene：" + this.hmW);
      AppMethodBeat.o(93705);
      return;
    }
    ae.i("MicroMsg.GLTextureObject", hashCode() + " release success!");
    AppMethodBeat.o(93705);
  }
  
  public final void setSize(int paramInt1, int paramInt2)
  {
    this.width = paramInt1;
    this.height = paramInt2;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(93706);
    String str = "hashcode:" + hashCode() + " texID:" + this.hnc + " sampler2D:" + this.hnd + " memRelease:" + this.hmU + " scene:" + this.hmW + " create-tid:" + this.tid + " width:" + this.width + " height:" + this.height;
    AppMethodBeat.o(93706);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.g.d
 * JD-Core Version:    0.7.0.1
 */