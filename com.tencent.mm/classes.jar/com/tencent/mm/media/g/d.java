package com.tencent.mm.media.g;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.opengl.GLUtils;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.c;
import com.tencent.mm.media.k.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.Closeable;
import java.nio.Buffer;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/media/globject/GLTextureObject;", "Ljava/io/Closeable;", "sampler2D", "", "scene", "", "(ZJ)V", "height", "", "internalFormat", "memRelease", "texID", "tid", "width", "allocTexMem", "", "pixels", "Ljava/nio/Buffer;", "minMagFilter", "wrapST", "allocTexMemFromBitmap", "bitmap", "Landroid/graphics/Bitmap;", "allocatedTid", "bind", "bindFrameBuffer", "frameBuffer", "Lcom/tencent/mm/media/globject/GLFrameBufferObject;", "checkFrameBufferStatus", "close", "finalize", "initInGLThread", "isClosed", "isExternalTexture", "isSample2DTexture", "setSize", "texFormatByteSize", "texMemorySize", "toString", "", "Companion", "plugin-mediaeditor_release"})
public final class d
  implements Closeable
{
  public static final d.a igy;
  public int height;
  volatile boolean ign;
  private long igp;
  public int igv;
  private boolean igw;
  private int igx;
  int tid;
  public int width;
  
  static
  {
    AppMethodBeat.i(93708);
    igy = new d.a((byte)0);
    AppMethodBeat.o(93708);
  }
  
  public d(boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(93707);
    this.ign = true;
    this.igv = -1;
    this.igp = 2L;
    this.tid = -1;
    this.width = -1;
    this.height = -1;
    this.igx = 6408;
    this.igp = paramLong;
    if (this.igp < 0L) {
      this.igp = 15L;
    }
    Object localObject = b.igr;
    b.aMu();
    this.ign = false;
    this.tid = Process.myTid();
    this.igw = paramBoolean;
    if (paramBoolean) {
      localObject = c.ilt;
    }
    for (this.igv = c.a.aMZ();; this.igv = localObject[0])
    {
      Log.i("MicroMsg.GLTextureObject", hashCode() + " create texID:" + this.igv + "  sampler2D:" + paramBoolean + " tid:" + this.tid + ", stackTrace:\t" + com.tencent.matrix.trace.g.b.getStack());
      AppMethodBeat.o(93707);
      return;
      localObject = c.ilt;
      localObject = new int[1];
      GLES30.glGenTextures(1, (int[])localObject, 0);
      GLES30.glBindTexture(36197, localObject[0]);
      GLES30.glTexParameteri(36197, 10241, 9729);
      GLES30.glTexParameteri(36197, 10240, 9729);
      GLES30.glTexParameteri(36197, 10242, 33071);
      GLES30.glTexParameteri(36197, 10243, 33071);
      GLES30.glBindTexture(36197, 0);
      c.a.Hr("glGenTextures");
    }
  }
  
  private int aMB()
  {
    AppMethodBeat.i(93703);
    if (this.igw)
    {
      i = this.width;
      int j = this.height;
      int k = aMC();
      AppMethodBeat.o(93703);
      return i * j * k;
    }
    int i = this.width * this.height * 3 / 2;
    AppMethodBeat.o(93703);
    return i;
  }
  
  private final int aMC()
  {
    int i = 32;
    switch (this.igx)
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
    if ((paramInt1 != this.width) || (paramInt2 != this.height) || (paramInt3 != this.igx) || (paramBuffer != null))
    {
      Log.i("MicroMsg.GLTextureObject", hashCode() + " allocTexMem, width:" + paramInt1 + ", height:" + paramInt2 + ", internalFormat:" + paramInt3 + ", memorySize:" + aMB());
      GLES20.glBindTexture(3553, this.igv);
      GLES20.glTexImage2D(3553, 0, paramInt3, paramInt1, paramInt2, 0, paramInt3, 5121, paramBuffer);
      GLES20.glTexParameterf(3553, 10241, paramInt4);
      GLES20.glTexParameterf(3553, 10240, paramInt4);
      GLES20.glTexParameterf(3553, 10242, paramInt5);
      GLES20.glTexParameterf(3553, 10243, paramInt5);
      this.width = paramInt1;
      this.height = paramInt2;
      this.igx = paramInt3;
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
      c.a locala = c.ilt;
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
  
  public final boolean aMD()
  {
    return !this.igw;
  }
  
  public final void c(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(218748);
    p.h(paramBitmap, "bitmap");
    if ((this.width != paramBitmap.getWidth()) || (this.height != paramBitmap.getHeight()) || (this.igx != this.igx)) {
      Log.i("MicroMsg.GLTextureObject", hashCode() + " allocTexMemFromBitmap, width:" + paramBitmap.getWidth() + ", height:" + paramBitmap.getHeight() + ", internalFormat:" + this.igx + ", memorySize:" + aMB());
    }
    GLES20.glBindTexture(3553, this.igv);
    GLUtils.texImage2D(3553, 0, paramBitmap, 0);
    GLES20.glTexParameterf(3553, 10241, paramInt1);
    GLES20.glTexParameterf(3553, 10240, paramInt1);
    GLES20.glTexParameterf(3553, 10242, paramInt2);
    GLES20.glTexParameterf(3553, 10243, paramInt2);
    this.width = paramBitmap.getWidth();
    this.height = paramBitmap.getHeight();
    this.igx = GLUtils.getInternalFormat(paramBitmap);
    AppMethodBeat.o(218748);
  }
  
  public final void close()
  {
    AppMethodBeat.i(93704);
    if (this.ign)
    {
      Log.i("MicroMsg.GLTextureObject", hashCode() + " tex already close");
      AppMethodBeat.o(93704);
      return;
    }
    int i = Process.myTid();
    if (this.tid != i)
    {
      Log.e("MicroMsg.GLTextureObject", hashCode() + " Leaked by different thread!!!  scene：" + this.igp + "  created in:" + this.tid + " release in:" + i + ", stackTrace:\t" + com.tencent.matrix.trace.g.b.getStack());
      localObject = b.igr;
      b.aMy();
      this.ign = false;
      AppMethodBeat.o(93704);
      return;
    }
    this.ign = true;
    Object localObject = c.ilt;
    GLES20.glDeleteTextures(1, new int[] { this.igv }, 0);
    Log.i("MicroMsg.GLTextureObject", hashCode() + " close texID:" + this.igv + "  sampler2D:" + this.igw + ", stacks:" + com.tencent.matrix.trace.g.b.getStack());
    AppMethodBeat.o(93704);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(93705);
    if (!this.ign)
    {
      b localb = b.igr;
      b.aMv();
      localb = b.igr;
      b.zG(this.igp);
      Log.e("MicroMsg.GLTextureObject", hashCode() + " Leaked !!!  scene：" + this.igp);
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
    String str = "hashcode:" + hashCode() + " texID:" + this.igv + " sampler2D:" + this.igw + " memRelease:" + this.ign + " scene:" + this.igp + " create-tid:" + this.tid + " width:" + this.width + " height:" + this.height;
    AppMethodBeat.o(93706);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.g.d
 * JD-Core Version:    0.7.0.1
 */