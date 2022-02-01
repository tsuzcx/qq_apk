package com.tencent.mm.openglapihook;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.openglapihook.a.a;
import java.util.concurrent.atomic.AtomicInteger;

public class OpenGLInfo
{
  public String activityName;
  private AtomicInteger counter;
  private boolean iUF = false;
  int id;
  private boolean kTS;
  private boolean mxA;
  OpenGLInfo.a mxB;
  boolean mxC = false;
  long mxD = 0L;
  private int mxv;
  String mxw = "";
  public String mxx = "";
  String mxy = "";
  private long mxz;
  
  protected OpenGLInfo(int paramInt)
  {
    this.mxv = paramInt;
  }
  
  protected OpenGLInfo(OpenGLInfo.a parama, int paramInt, String paramString)
  {
    this.id = paramInt;
    this.mxw = paramString;
    this.mxA = false;
    this.mxB = parama;
  }
  
  protected OpenGLInfo(OpenGLInfo.a parama, int paramInt, String paramString1, String paramString2, long paramLong, String paramString3, AtomicInteger paramAtomicInteger)
  {
    this.id = paramInt;
    this.mxw = paramString1;
    this.mxx = paramString2;
    this.mxz = paramLong;
    this.mxA = true;
    this.mxB = parama;
    this.activityName = paramString3;
    this.counter = paramAtomicInteger;
  }
  
  protected OpenGLInfo(OpenGLInfo paramOpenGLInfo)
  {
    this.id = paramOpenGLInfo.id;
    this.mxv = paramOpenGLInfo.mxv;
    this.mxw = paramOpenGLInfo.mxw;
    this.mxx = paramOpenGLInfo.mxx;
    this.mxy = paramOpenGLInfo.mxy;
    this.mxz = paramOpenGLInfo.mxz;
    this.mxA = paramOpenGLInfo.mxA;
    this.mxB = paramOpenGLInfo.mxB;
    this.kTS = paramOpenGLInfo.kTS;
    this.mxD = paramOpenGLInfo.mxD;
    this.iUF = paramOpenGLInfo.iUF;
    this.mxC = paramOpenGLInfo.mxC;
    this.activityName = paramOpenGLInfo.activityName;
  }
  
  private native String dumpNativeStack(long paramLong);
  
  private native void releaseNative(long paramLong);
  
  public final String bum()
  {
    AppMethodBeat.i(204093);
    if ((TextUtils.isEmpty(this.mxy)) && (!this.kTS)) {}
    synchronized (this.counter)
    {
      if (this.counter.get() > 0) {
        this.mxy = dumpNativeStack(this.mxz);
      }
      ??? = this.mxy;
      AppMethodBeat.o(204093);
      return ???;
    }
  }
  
  protected final void release()
  {
    AppMethodBeat.i(204094);
    if (this.kTS)
    {
      AppMethodBeat.o(204094);
      return;
    }
    this.kTS = true;
    synchronized (this.counter)
    {
      int i = this.counter.get();
      if (i == 1)
      {
        a.i("OpenGLInfo.TAG", "release:" + this.mxz);
        releaseNative(this.mxz);
      }
      this.counter.set(i - 1);
      AppMethodBeat.o(204094);
      return;
    }
  }
  
  public String toString()
  {
    AppMethodBeat.i(204095);
    String str = "OpenGLInfo{id=" + this.id + ", activityName=" + this.activityName + ", type='" + this.mxB.toString() + '\'' + ", error=" + this.mxv + ", isGen=" + this.mxA + ", threadId='" + this.mxw + '\'' + ", javaStack='" + this.mxx + '\'' + ", nativeStack='" + this.mxy + '\'' + ", nativeStackPtr=" + this.mxz + '}';
    AppMethodBeat.o(204095);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.openglapihook.OpenGLInfo
 * JD-Core Version:    0.7.0.1
 */