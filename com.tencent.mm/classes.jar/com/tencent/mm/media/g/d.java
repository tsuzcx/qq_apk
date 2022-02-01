package com.tencent.mm.media.g;

import android.opengl.GLES20;
import android.opengl.GLES30;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.util.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.Closeable;
import java.nio.Buffer;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/globject/GLTextureObject;", "Ljava/io/Closeable;", "sampler2D", "", "scene", "", "(ZJ)V", "height", "", "internalFormat", "memRelease", "texID", "tid", "width", "allocTexMem", "", "pixels", "Ljava/nio/Buffer;", "minMagFilter", "wrapST", "allocTexMemFromBitmap", "bitmap", "Landroid/graphics/Bitmap;", "allocatedTid", "bind", "bindFrameBuffer", "frameBuffer", "Lcom/tencent/mm/media/globject/GLFrameBufferObject;", "checkFrameBufferStatus", "close", "finalize", "initInGLThread", "isClosed", "isExternalTexture", "isSample2DTexture", "setSize", "texFormatByteSize", "texMemorySize", "toString", "", "Companion", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  implements Closeable
{
  public static final d.a nAE;
  private int eXA;
  public int height;
  public int nAF;
  private boolean nAG;
  public volatile boolean nAx;
  private long nAz;
  int tid;
  public int width;
  
  static
  {
    AppMethodBeat.i(93708);
    nAE = new d.a((byte)0);
    AppMethodBeat.o(93708);
  }
  
  public d(boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(93707);
    this.nAx = true;
    this.nAF = -1;
    this.nAz = 2L;
    this.tid = -1;
    this.width = -1;
    this.height = -1;
    this.eXA = 6408;
    this.nAz = paramLong;
    if (this.nAz < 0L) {
      this.nAz = 15L;
    }
    Object localObject = b.nAA;
    b.bpr();
    this.nAx = false;
    this.tid = Process.myTid();
    this.nAG = paramBoolean;
    if (paramBoolean) {
      localObject = com.tencent.mm.media.util.c.nFs;
    }
    for (this.nAF = c.a.bql();; this.nAF = localObject[0])
    {
      Log.i("MicroMsg.GLTextureObject", hashCode() + " create texID:" + this.nAF + "  sampler2D:" + paramBoolean + " tid:" + this.tid + ", stackTrace:\t" + com.tencent.matrix.trace.f.c.getStack());
      AppMethodBeat.o(93707);
      return;
      localObject = com.tencent.mm.media.util.c.nFs;
      localObject = new int[1];
      GLES30.glGenTextures(1, (int[])localObject, 0);
      GLES30.glBindTexture(36197, localObject[0]);
      GLES30.glTexParameteri(36197, 10241, 9729);
      GLES30.glTexParameteri(36197, 10240, 9729);
      GLES30.glTexParameteri(36197, 10242, 33071);
      GLES30.glTexParameteri(36197, 10243, 33071);
      GLES30.glBindTexture(36197, 0);
      c.a.GS("glGenTextures");
    }
  }
  
  private int bpy()
  {
    AppMethodBeat.i(93703);
    if (this.nAG)
    {
      i = this.width;
      int j = this.height;
      int k = bpz();
      AppMethodBeat.o(93703);
      return i * j * k;
    }
    int i = this.width * this.height * 3 / 2;
    AppMethodBeat.o(93703);
    return i;
  }
  
  private final int bpz()
  {
    int i = 32;
    switch (this.eXA)
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
    if ((paramInt1 != this.width) || (paramInt2 != this.height) || (paramInt3 != this.eXA) || (paramBuffer != null))
    {
      Log.i("MicroMsg.GLTextureObject", hashCode() + " allocTexMem, width:" + paramInt1 + ", height:" + paramInt2 + ", internalFormat:" + paramInt3 + ", memorySize:" + bpy());
      GLES20.glBindTexture(3553, this.nAF);
      GLES20.glTexImage2D(3553, 0, paramInt3, paramInt1, paramInt2, 0, paramInt3, 5121, paramBuffer);
      GLES20.glTexParameterf(3553, 10241, paramInt4);
      GLES20.glTexParameterf(3553, 10240, paramInt4);
      GLES20.glTexParameterf(3553, 10242, paramInt5);
      GLES20.glTexParameterf(3553, 10243, paramInt5);
      this.width = paramInt1;
      this.height = paramInt2;
      this.eXA = paramInt3;
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
      c.a locala = com.tencent.mm.media.util.c.nFs;
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
      Log.e("MicroMsg.GLTextureObject", "bind framebuffer status not complete, status:" + paramInt1 + " error:" + parama);
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
  
  public final boolean bpA()
  {
    return !this.nAG;
  }
  
  public final void close()
  {
    AppMethodBeat.i(93704);
    if (this.nAx)
    {
      Log.i("MicroMsg.GLTextureObject", hashCode() + " tex already close");
      AppMethodBeat.o(93704);
      return;
    }
    int i = Process.myTid();
    if (this.tid != i)
    {
      Log.e("MicroMsg.GLTextureObject", hashCode() + " Leaked by different thread!!!  scene：" + this.nAz + "  created in:" + this.tid + " release in:" + i + ", stackTrace:\t" + com.tencent.matrix.trace.f.c.getStack());
      localObject = b.nAA;
      b.bpv();
      this.nAx = false;
      AppMethodBeat.o(93704);
      return;
    }
    this.nAx = true;
    Object localObject = com.tencent.mm.media.util.c.nFs;
    GLES20.glDeleteTextures(1, new int[] { this.nAF }, 0);
    Log.i("MicroMsg.GLTextureObject", hashCode() + " close texID:" + this.nAF + "  sampler2D:" + this.nAG + ", stacks:" + com.tencent.matrix.trace.f.c.getStack());
    AppMethodBeat.o(93704);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(93705);
    if (!this.nAx)
    {
      b localb = b.nAA;
      b.bps();
      localb = b.nAA;
      b.hV(this.nAz);
      Log.e("MicroMsg.GLTextureObject", hashCode() + " Leaked !!!  scene：" + this.nAz);
      AppMethodBeat.o(93705);
      return;
    }
    Log.i("MicroMsg.GLTextureObject", hashCode() + " release success!");
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
    String str = "hashcode:" + hashCode() + " texID:" + this.nAF + " sampler2D:" + this.nAG + " memRelease:" + this.nAx + " scene:" + this.nAz + " create-tid:" + this.tid + " width:" + this.width + " height:" + this.height;
    AppMethodBeat.o(93706);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.g.d
 * JD-Core Version:    0.7.0.1
 */