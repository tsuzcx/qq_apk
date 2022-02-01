package com.tencent.mm.media.f;

import android.opengl.GLES20;
import android.opengl.GLES30;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.c;
import com.tencent.mm.media.j.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;
import java.io.Closeable;
import java.nio.Buffer;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/media/globject/GLTextureObject;", "Ljava/io/Closeable;", "sampler2D", "", "scene", "", "(ZJ)V", "height", "", "internalFormat", "memRelease", "texID", "tid", "width", "allocTexMem", "", "pixels", "Ljava/nio/Buffer;", "minMagFilter", "wrapST", "allocTexMemFromBitmap", "bitmap", "Landroid/graphics/Bitmap;", "allocatedTid", "bind", "bindFrameBuffer", "frameBuffer", "Lcom/tencent/mm/media/globject/GLFrameBufferObject;", "checkFrameBufferStatus", "close", "finalize", "initInGLThread", "isClosed", "isExternalTexture", "isSample2DTexture", "setSize", "texFormatByteSize", "texMemorySize", "toString", "", "Companion", "plugin-mediaeditor_release"})
public final class d
  implements Closeable
{
  public static final d.a grr;
  volatile boolean grg;
  private long gri;
  public int gro;
  private boolean grp;
  private int grq;
  public int height;
  int tid;
  public int width;
  
  static
  {
    AppMethodBeat.i(93708);
    grr = new d.a((byte)0);
    AppMethodBeat.o(93708);
  }
  
  public d(boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(93707);
    this.grg = true;
    this.gro = -1;
    this.gri = 2L;
    this.tid = -1;
    this.width = -1;
    this.height = -1;
    this.grq = 6408;
    this.gri = paramLong;
    if (this.gri < 0L) {
      this.gri = 15L;
    }
    Object localObject = b.grk;
    b.ajQ();
    this.grg = false;
    this.tid = Process.myTid();
    this.grp = paramBoolean;
    if (paramBoolean) {
      localObject = c.gwl;
    }
    for (this.gro = c.a.akA();; this.gro = localObject[0])
    {
      ad.i("MicroMsg.GLTextureObject", hashCode() + " create texID:" + this.gro + "  sampler2D:" + paramBoolean + " tid:" + this.tid + ", stackTrace:\t" + com.tencent.matrix.trace.g.b.getStack());
      AppMethodBeat.o(93707);
      return;
      localObject = c.gwl;
      localObject = new int[1];
      GLES30.glGenTextures(1, (int[])localObject, 0);
      GLES30.glBindTexture(36197, localObject[0]);
      GLES30.glTexParameteri(36197, 10241, 9729);
      GLES30.glTexParameteri(36197, 10240, 9729);
      GLES30.glTexParameteri(36197, 10242, 33071);
      GLES30.glTexParameteri(36197, 10243, 33071);
      GLES30.glBindTexture(36197, 0);
      c.a.rp("glGenTextures");
    }
  }
  
  private int ajX()
  {
    AppMethodBeat.i(93703);
    if (this.grp)
    {
      i = this.width;
      int j = this.height;
      int k = ajY();
      AppMethodBeat.o(93703);
      return i * j * k;
    }
    int i = this.width * this.height * 3 / 2;
    AppMethodBeat.o(93703);
    return i;
  }
  
  private final int ajY()
  {
    int i = 32;
    switch (this.grq)
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
    if ((paramInt1 != this.width) || (paramInt2 != this.height) || (paramInt3 != this.grq) || (paramBuffer != null))
    {
      ad.i("MicroMsg.GLTextureObject", hashCode() + " allocTexMem, width:" + paramInt1 + ", height:" + paramInt2 + ", internalFormat:" + paramInt3 + ", memorySize:" + ajX());
      GLES20.glBindTexture(3553, this.gro);
      GLES20.glTexImage2D(3553, 0, paramInt3, paramInt1, paramInt2, 0, paramInt3, 5121, paramBuffer);
      GLES20.glTexParameterf(3553, 10241, paramInt4);
      GLES20.glTexParameterf(3553, 10240, paramInt4);
      GLES20.glTexParameterf(3553, 10242, paramInt5);
      GLES20.glTexParameterf(3553, 10243, paramInt5);
      this.width = paramInt1;
      this.height = paramInt2;
      this.grq = paramInt3;
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
      c.a locala = c.gwl;
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
      ad.e("MicroMsg.GLTextureObject", "bind framebuffer status not complete, status:" + paramInt1 + " error:" + parama);
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
  
  public final boolean ajZ()
  {
    return !this.grp;
  }
  
  public final void close()
  {
    AppMethodBeat.i(93704);
    if (this.grg)
    {
      ad.i("MicroMsg.GLTextureObject", hashCode() + " tex already close");
      AppMethodBeat.o(93704);
      return;
    }
    int i = Process.myTid();
    if (this.tid != i)
    {
      ad.e("MicroMsg.GLTextureObject", hashCode() + " Leaked by different thread!!!  scene：" + this.gri + "  created in:" + this.tid + " release in:" + i + ", stackTrace:\t" + com.tencent.matrix.trace.g.b.getStack());
      localObject = b.grk;
      b.ajU();
      this.grg = false;
      AppMethodBeat.o(93704);
      return;
    }
    this.grg = true;
    Object localObject = c.gwl;
    GLES20.glDeleteTextures(1, new int[] { this.gro }, 0);
    ad.i("MicroMsg.GLTextureObject", hashCode() + " close texID:" + this.gro + "  sampler2D:" + this.grp + ", stacks:" + com.tencent.matrix.trace.g.b.getStack());
    AppMethodBeat.o(93704);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(93705);
    if (!this.grg)
    {
      b localb = b.grk;
      b.ajR();
      localb = b.grk;
      b.lA(this.gri);
      ad.e("MicroMsg.GLTextureObject", hashCode() + " Leaked !!!  scene：" + this.gri);
      AppMethodBeat.o(93705);
      return;
    }
    ad.i("MicroMsg.GLTextureObject", hashCode() + " release success!");
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
    String str = "hashcode:" + hashCode() + " texID:" + this.gro + " sampler2D:" + this.grp + " memRelease:" + this.grg + " scene:" + this.gri + " create-tid:" + this.tid + " width:" + this.width + " height:" + this.height;
    AppMethodBeat.o(93706);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.media.f.d
 * JD-Core Version:    0.7.0.1
 */