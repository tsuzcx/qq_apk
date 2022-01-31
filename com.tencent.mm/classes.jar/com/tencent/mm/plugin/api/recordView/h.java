package com.tencent.mm.plugin.api.recordView;

import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

public final class h
{
  private final String TAG;
  boolean eAT;
  HandlerThread eVQ;
  ak eVR;
  int[] eZt;
  EGLSurface eZy;
  EGLContext eZz;
  int fbz;
  int gNA;
  int gNB;
  int gOA;
  int gOB;
  EGLDisplay gOC;
  i gOy;
  i.a gOz;
  
  public h()
  {
    AppMethodBeat.i(76389);
    this.TAG = "MicroMsg.YUVDateRenderToRBGBufferThread";
    this.eVQ = d.aqu("YUVDateRenderToRBGBufferThread");
    this.gOz = null;
    this.eAT = false;
    this.eZt = new int[] { 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12610, 1, 12344 };
    this.gOC = null;
    this.eZy = null;
    this.eZz = null;
    AppMethodBeat.o(76389);
  }
  
  static boolean xK(String paramString)
  {
    AppMethodBeat.i(76394);
    int i = EGL14.eglGetError();
    if (i != 12288)
    {
      ab.b("MicroMsg.YUVDateRenderToRBGBufferThread", paramString + ": EGL error: 0x" + Integer.toHexString(i), new Object[0]);
      AppMethodBeat.o(76394);
      return true;
    }
    AppMethodBeat.o(76394);
    return false;
  }
  
  public final void b(EGLContext paramEGLContext)
  {
    AppMethodBeat.i(76390);
    ab.d("MicroMsg.YUVDateRenderToRBGBufferThread", "start context : " + paramEGLContext + "  hasStart : " + this.eAT);
    if ((this.eAT) || (paramEGLContext == null))
    {
      AppMethodBeat.o(76390);
      return;
    }
    this.eAT = true;
    this.eVQ.start();
    this.eVR = new ak(this.eVQ.getLooper());
    queue(new h.1(this, paramEGLContext));
    AppMethodBeat.o(76390);
  }
  
  public final void h(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(76391);
    ab.i("MicroMsg.YUVDateRenderToRBGBufferThread", "setFrameInfo, width: %s, height: %s, rotate: %s ,targetWidth:%d ,targetHeight:%d , this: %s ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), this });
    if ((paramInt1 != this.gNA) || (paramInt2 != this.gNB) || (paramInt3 != this.fbz))
    {
      this.gNA = paramInt1;
      this.gNB = paramInt2;
      this.fbz = paramInt3;
    }
    this.gOA = paramInt4;
    this.gOB = paramInt5;
    AppMethodBeat.o(76391);
  }
  
  final void queue(Runnable paramRunnable)
  {
    AppMethodBeat.i(76392);
    if (this.eVQ.isAlive()) {
      this.eVR.post(paramRunnable);
    }
    AppMethodBeat.o(76392);
  }
  
  public final void release()
  {
    AppMethodBeat.i(76393);
    queue(new h.3(this));
    AppMethodBeat.o(76393);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.api.recordView.h
 * JD-Core Version:    0.7.0.1
 */