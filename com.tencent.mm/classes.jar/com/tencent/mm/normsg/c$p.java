package com.tencent.mm.normsg;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public final class c$p
{
  static
  {
    AppMethodBeat.i(62426);
    Object localObject1 = new StringBuilder("gsmron").reverse().toString();
    if (Process.myPid() == Process.myTid())
    {
      localObject1 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject1);
      localObject3 = new Object();
      com.tencent.mm.hellhoundlib.a.a.b(localObject3, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/normsg/c$p", "<clinit>", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
      System.loadLibrary((String)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(localObject3, "com/tencent/mm/normsg/c$p", "<clinit>", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
      AppMethodBeat.o(62426);
      return;
    }
    Object localObject3 = new CountDownLatch(1);
    new Handler(Looper.getMainLooper()).postAtFrontOfQueue(new c.p.1((String)localObject1, (CountDownLatch)localObject3));
    try
    {
      ((CountDownLatch)localObject3).await();
      return;
    }
    finally
    {
      AppMethodBeat.o(62426);
    }
  }
  
  public static native byte[] aa(int paramInt1, int paramInt2);
  
  public static native boolean ab();
  
  public static native String ac(String paramString, boolean paramBoolean);
  
  public static native byte[] ad();
  
  public static native byte[] ae(int paramInt);
  
  public static native byte[] af(int paramInt);
  
  public static native boolean ag();
  
  public static native boolean ah();
  
  public static native boolean ai();
  
  public static native boolean aj();
  
  static native void ak();
  
  public static native boolean al();
  
  public static native byte[] am(Intent paramIntent);
  
  static native String ba(int paramInt);
  
  static native String bb(int paramInt);
  
  static native boolean bc(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, PValue<Integer> paramPValue1, PValue<Integer> paramPValue2, PValue<byte[]> paramPValue);
  
  static native boolean bd(byte[] paramArrayOfByte, int paramInt1, int paramInt2, PValue<byte[]> paramPValue1, PValue<byte[]> paramPValue2);
  
  static native boolean be(byte[] paramArrayOfByte, int paramInt1, int paramInt2, PValue<byte[]> paramPValue1, PValue<byte[]> paramPValue2);
  
  public static native boolean ca(Object paramObject, Class<?> paramClass);
  
  public static native boolean cb(Object paramObject);
  
  public static native void da(String paramString);
  
  public static native void db(String paramString);
  
  public static native void dc(String paramString);
  
  public static native boolean dd(String paramString);
  
  public static native byte[] de(String paramString);
  
  public static native void df(String paramString1, String paramString2, String paramString3);
  
  public static native void dg(String paramString, MotionEvent paramMotionEvent);
  
  public static native void dh(String paramString);
  
  public static native boolean di(String paramString);
  
  public static native byte[] dj(String paramString);
  
  public static native String dk(String paramString);
  
  public static native byte[] ea(int paramInt1, int paramInt2);
  
  public static native boolean eb(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public static native boolean ec();
  
  static native byte[] ed();
  
  public static native byte[] ee();
  
  public static native String ef();
  
  public static native String eg();
  
  public static native String eh();
  
  public static native void fa(String paramString, int paramInt1, int paramInt2);
  
  public static native void fb(int paramInt, List<b> paramList);
  
  public static native boolean fc();
  
  public static native void fd();
  
  public static native void fe(int paramInt);
  
  public static native void ff(int paramInt);
  
  public static native boolean fg(String paramString);
  
  public static native void fh(String paramString);
  
  public static native byte[] fi(String paramString);
  
  public static native void fj(String paramString);
  
  public static native void fk();
  
  public static native int fl(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.normsg.c.p
 * JD-Core Version:    0.7.0.1
 */