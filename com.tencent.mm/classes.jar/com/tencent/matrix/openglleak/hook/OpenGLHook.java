package com.tencent.matrix.openglleak.hook;

import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.os.Build.VERSION;
import com.tencent.matrix.openglleak.statistics.resource.ResRecordManager;
import com.tencent.matrix.openglleak.statistics.resource.b;
import com.tencent.matrix.openglleak.statistics.resource.c.a;
import java.util.concurrent.atomic.AtomicInteger;

public class OpenGLHook
{
  private static final String TAG = "MicroMsg.OpenGLHook";
  private static OpenGLHook mInstance = new OpenGLHook();
  private byte _hellAccFlag_;
  private a mBindListener;
  private b mErrorListener;
  private c mMemoryListener;
  private d mResourceListener;
  
  static
  {
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().cG("matrix-opengl-leak");
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/matrix/openglleak/hook/OpenGLHook", "<clinit>", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    System.loadLibrary((String)locala.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/matrix/openglleak/hook/OpenGLHook", "<clinit>", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
  }
  
  public static OpenGLHook getInstance()
  {
    return mInstance;
  }
  
  public static String getStack()
  {
    return stackTraceToString(new Throwable().getStackTrace());
  }
  
  private static native boolean hookGlBindBuffer(int paramInt);
  
  private static native boolean hookGlBindFramebuffer(int paramInt);
  
  private static native boolean hookGlBindRenderbuffer(int paramInt);
  
  private static native boolean hookGlBindTexture(int paramInt);
  
  private static native boolean hookGlBufferData(int paramInt);
  
  private static native boolean hookGlDeleteBuffers(int paramInt);
  
  private static native boolean hookGlDeleteFramebuffers(int paramInt);
  
  private static native boolean hookGlDeleteRenderbuffers(int paramInt);
  
  private static native boolean hookGlDeleteTextures(int paramInt);
  
  private static native boolean hookGlGenBuffers(int paramInt);
  
  private static native boolean hookGlGenFramebuffers(int paramInt);
  
  private static native boolean hookGlGenRenderbuffers(int paramInt);
  
  private static native boolean hookGlGenTextures(int paramInt);
  
  private static native boolean hookGlGetError(int paramInt);
  
  private static native boolean hookGlRenderbufferStorage(int paramInt);
  
  private static native boolean hookGlTexImage2D(int paramInt);
  
  private static native boolean hookGlTexImage3D(int paramInt);
  
  public static void onGetError(int paramInt)
  {
    if (getInstance().mErrorListener != null) {
      getInstance();
    }
  }
  
  public static void onGlBindBuffer(int paramInt1, int paramInt2)
  {
    final long l = 0L;
    if (Build.VERSION.SDK_INT >= 21) {
      l = EGL14.eglGetCurrentContext().getNativeHandle();
    }
    com.tencent.matrix.openglleak.a.c.ayU().post(new Runnable()
    {
      public final void run()
      {
        com.tencent.matrix.openglleak.statistics.resource.c localc = null;
        if (this.val$id != 0) {
          localc = ResRecordManager.ayR().b(c.a.eXO, l, this.val$id);
        }
        com.tencent.matrix.openglleak.statistics.a.ayM();
        com.tencent.matrix.openglleak.statistics.a.a(c.a.eXO, this.eWW, l, localc);
      }
    });
    if (getInstance().mBindListener != null) {
      getInstance();
    }
  }
  
  public static void onGlBindFramebuffer(int paramInt1, int paramInt2)
  {
    final long l = 0L;
    if (Build.VERSION.SDK_INT >= 21) {
      l = EGL14.eglGetCurrentContext().getNativeHandle();
    }
    com.tencent.matrix.openglleak.a.c.ayU().post(new Runnable()
    {
      public final void run()
      {
        com.tencent.matrix.openglleak.statistics.resource.c localc = null;
        if (this.val$id != 0) {
          localc = ResRecordManager.ayR().b(c.a.eXP, l, this.val$id);
        }
        com.tencent.matrix.openglleak.statistics.a.ayM();
        com.tencent.matrix.openglleak.statistics.a.a(c.a.eXP, this.eWW, l, localc);
      }
    });
    if (getInstance().mBindListener != null) {
      getInstance();
    }
  }
  
  public static void onGlBindRenderbuffer(int paramInt1, int paramInt2)
  {
    final long l = 0L;
    if (Build.VERSION.SDK_INT >= 21) {
      l = EGL14.eglGetCurrentContext().getNativeHandle();
    }
    com.tencent.matrix.openglleak.a.c.ayU().post(new Runnable()
    {
      public final void run()
      {
        com.tencent.matrix.openglleak.statistics.resource.c localc = null;
        if (this.val$id != 0) {
          localc = ResRecordManager.ayR().b(c.a.eXQ, l, this.val$id);
        }
        com.tencent.matrix.openglleak.statistics.a.ayM();
        com.tencent.matrix.openglleak.statistics.a.a(c.a.eXQ, this.eWW, l, localc);
      }
    });
    if (getInstance().mBindListener != null) {
      getInstance();
    }
  }
  
  public static void onGlBindTexture(int paramInt1, int paramInt2)
  {
    final long l = 0L;
    if (Build.VERSION.SDK_INT >= 21) {
      l = EGL14.eglGetCurrentContext().getNativeHandle();
    }
    com.tencent.matrix.openglleak.a.c.ayU().post(new Runnable()
    {
      public final void run()
      {
        com.tencent.matrix.openglleak.statistics.resource.c localc = null;
        if (this.val$id != 0) {
          localc = ResRecordManager.ayR().b(c.a.eXN, l, this.val$id);
        }
        com.tencent.matrix.openglleak.statistics.a.ayM();
        com.tencent.matrix.openglleak.statistics.a.a(c.a.eXN, this.eWW, l, localc);
      }
    });
    if (getInstance().mBindListener != null) {
      getInstance();
    }
  }
  
  public static void onGlBufferData(int paramInt1, final int paramInt2, final long paramLong1, String paramString, final long paramLong2)
  {
    if (Thread.currentThread().getName().equals("RenderThread")) {
      return;
    }
    long l = 0L;
    if (Build.VERSION.SDK_INT >= 21) {
      l = EGL14.eglGetCurrentContext().getNativeHandle();
    }
    com.tencent.matrix.openglleak.a.c.ayU().post(new Runnable()
    {
      public final void run()
      {
        com.tencent.matrix.openglleak.statistics.a.ayM();
        com.tencent.matrix.openglleak.statistics.resource.c localc = com.tencent.matrix.openglleak.statistics.a.a(c.a.eXO, this.eWV, paramLong1);
        if (localc == null)
        {
          com.tencent.matrix.e.c.e("MicroMsg.OpenGLHook", "onGlBufferData: getCurrentResourceIdByTarget result == null, maybe undo glBindBuffer()", new Object[0]);
          return;
        }
        if (paramLong1 == 35052) {}
        for (long l1 = paramInt2 * 2L;; l1 = paramInt2)
        {
          Object localObject2 = localc.eXK;
          Object localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = new b(c.a.eXO);
          }
          int i = paramLong1;
          int j = paramLong2;
          int k = localc.id;
          long l2 = localc.ayQ();
          localObject2 = this.eXb;
          long l3 = this.eXc;
          ((b)localObject1).eXy = i;
          ((b)localObject1).cIi = j;
          ((b)localObject1).id = k;
          ((b)localObject1).eXC = l2;
          ((b)localObject1).size = l1;
          ((b)localObject1).eXD = ((String)localObject2);
          ((b)localObject1).eXE = l3;
          localc.a((b)localObject1);
          if (OpenGLHook.getInstance().mMemoryListener == null) {
            break;
          }
          localc.ayQ();
          return;
        }
      }
    });
  }
  
  public static void onGlDeleteBuffers(int[] paramArrayOfInt, String paramString)
  {
    if (paramArrayOfInt.length > 0)
    {
      int j = paramArrayOfInt.length;
      int i = 0;
      while (i < j)
      {
        int k = paramArrayOfInt[i];
        com.tencent.matrix.openglleak.statistics.resource.c localc = new com.tencent.matrix.openglleak.statistics.resource.c(c.a.eXO, k, paramString, EGL14.eglGetCurrentContext());
        com.tencent.matrix.openglleak.a.c.ayU().post(new Runnable()
        {
          public final void run()
          {
            ResRecordManager.ayR().c(this.eWU);
          }
        });
        if (getInstance().mResourceListener != null) {
          getInstance();
        }
        i += 1;
      }
    }
  }
  
  public static void onGlDeleteFramebuffers(int[] paramArrayOfInt, String paramString)
  {
    if (paramArrayOfInt.length > 0)
    {
      int j = paramArrayOfInt.length;
      int i = 0;
      while (i < j)
      {
        int k = paramArrayOfInt[i];
        com.tencent.matrix.openglleak.statistics.resource.c localc = new com.tencent.matrix.openglleak.statistics.resource.c(c.a.eXP, k, paramString, EGL14.eglGetCurrentContext());
        com.tencent.matrix.openglleak.a.c.ayU().post(new Runnable()
        {
          public final void run()
          {
            ResRecordManager.ayR().c(this.eWU);
          }
        });
        if (getInstance().mResourceListener != null) {
          getInstance();
        }
        i += 1;
      }
    }
  }
  
  public static void onGlDeleteRenderbuffers(int[] paramArrayOfInt, String paramString)
  {
    if (paramArrayOfInt.length > 0)
    {
      int j = paramArrayOfInt.length;
      int i = 0;
      while (i < j)
      {
        int k = paramArrayOfInt[i];
        com.tencent.matrix.openglleak.statistics.resource.c localc = new com.tencent.matrix.openglleak.statistics.resource.c(c.a.eXQ, k, paramString, EGL14.eglGetCurrentContext());
        com.tencent.matrix.openglleak.a.c.ayU().post(new Runnable()
        {
          public final void run()
          {
            ResRecordManager.ayR().c(this.eWU);
          }
        });
        if (getInstance().mResourceListener != null) {
          getInstance();
        }
        i += 1;
      }
    }
  }
  
  public static void onGlDeleteTextures(int[] paramArrayOfInt, String paramString)
  {
    if (paramArrayOfInt.length > 0)
    {
      int j = paramArrayOfInt.length;
      int i = 0;
      while (i < j)
      {
        int k = paramArrayOfInt[i];
        com.tencent.matrix.openglleak.statistics.resource.c localc = new com.tencent.matrix.openglleak.statistics.resource.c(c.a.eXN, k, paramString, EGL14.eglGetCurrentContext());
        com.tencent.matrix.openglleak.a.c.ayU().post(new Runnable()
        {
          public final void run()
          {
            ResRecordManager.ayR().c(this.eWU);
          }
        });
        if (getInstance().mResourceListener != null) {
          getInstance();
        }
        i += 1;
      }
    }
  }
  
  public static void onGlGenBuffers(int[] paramArrayOfInt, String paramString1, String paramString2, long paramLong)
  {
    if (paramArrayOfInt.length > 0)
    {
      AtomicInteger localAtomicInteger = new AtomicInteger(paramArrayOfInt.length);
      int j = paramArrayOfInt.length;
      int i = 0;
      while (i < j)
      {
        int k = paramArrayOfInt[i];
        com.tencent.matrix.openglleak.statistics.resource.c localc = new com.tencent.matrix.openglleak.statistics.resource.c(c.a.eXO, k, paramString1, EGL14.eglGetCurrentContext(), paramString2, paramLong, com.tencent.matrix.openglleak.a.a.ayS().eXY, localAtomicInteger);
        com.tencent.matrix.openglleak.a.c.ayU().post(new Runnable()
        {
          public final void run()
          {
            ResRecordManager.ayR().b(this.eWU);
          }
        });
        if (getInstance().mResourceListener != null) {
          getInstance();
        }
        i += 1;
      }
    }
  }
  
  public static void onGlGenFramebuffers(int[] paramArrayOfInt, String paramString1, String paramString2, long paramLong)
  {
    if (paramArrayOfInt.length > 0)
    {
      AtomicInteger localAtomicInteger = new AtomicInteger(paramArrayOfInt.length);
      int j = paramArrayOfInt.length;
      int i = 0;
      while (i < j)
      {
        int k = paramArrayOfInt[i];
        com.tencent.matrix.openglleak.statistics.resource.c localc = new com.tencent.matrix.openglleak.statistics.resource.c(c.a.eXP, k, paramString1, EGL14.eglGetCurrentContext(), paramString2, paramLong, com.tencent.matrix.openglleak.a.a.ayS().eXY, localAtomicInteger);
        com.tencent.matrix.openglleak.a.c.ayU().post(new Runnable()
        {
          public final void run()
          {
            ResRecordManager.ayR().b(this.eWU);
          }
        });
        if (getInstance().mResourceListener != null) {
          getInstance();
        }
        i += 1;
      }
    }
  }
  
  public static void onGlGenRenderbuffers(int[] paramArrayOfInt, String paramString1, String paramString2, long paramLong)
  {
    if (paramArrayOfInt.length > 0)
    {
      AtomicInteger localAtomicInteger = new AtomicInteger(paramArrayOfInt.length);
      int j = paramArrayOfInt.length;
      int i = 0;
      while (i < j)
      {
        int k = paramArrayOfInt[i];
        com.tencent.matrix.openglleak.statistics.resource.c localc = new com.tencent.matrix.openglleak.statistics.resource.c(c.a.eXQ, k, paramString1, EGL14.eglGetCurrentContext(), paramString2, paramLong, com.tencent.matrix.openglleak.a.a.ayS().eXY, localAtomicInteger);
        com.tencent.matrix.openglleak.a.c.ayU().post(new Runnable()
        {
          public final void run()
          {
            ResRecordManager.ayR().b(this.eWU);
          }
        });
        if (getInstance().mResourceListener != null) {
          getInstance();
        }
        i += 1;
      }
    }
  }
  
  public static void onGlGenTextures(int[] paramArrayOfInt, String paramString1, String paramString2, long paramLong)
  {
    if (paramArrayOfInt.length > 0)
    {
      AtomicInteger localAtomicInteger = new AtomicInteger(paramArrayOfInt.length);
      int j = paramArrayOfInt.length;
      int i = 0;
      while (i < j)
      {
        int k = paramArrayOfInt[i];
        com.tencent.matrix.openglleak.statistics.resource.c localc = new com.tencent.matrix.openglleak.statistics.resource.c(c.a.eXN, k, paramString1, EGL14.eglGetCurrentContext(), paramString2, paramLong, com.tencent.matrix.openglleak.a.a.ayS().eXY, localAtomicInteger);
        com.tencent.matrix.openglleak.a.c.ayU().post(new Runnable()
        {
          public final void run()
          {
            ResRecordManager.ayR().b(this.eWU);
          }
        });
        if (getInstance().mResourceListener != null) {
          getInstance();
        }
        i += 1;
      }
    }
  }
  
  public static void onGlRenderbufferStorage(int paramInt1, final int paramInt2, final int paramInt3, final int paramInt4, final long paramLong1, final String paramString, long paramLong2)
  {
    long l = 0L;
    if (Build.VERSION.SDK_INT >= 21) {
      l = EGL14.eglGetCurrentContext().getNativeHandle();
    }
    com.tencent.matrix.openglleak.a.c.ayU().post(new Runnable()
    {
      public final void run()
      {
        com.tencent.matrix.openglleak.statistics.a.ayM();
        com.tencent.matrix.openglleak.statistics.resource.c localc = com.tencent.matrix.openglleak.statistics.a.a(c.a.eXQ, this.eWV, paramInt3);
        if (localc == null) {
          com.tencent.matrix.e.c.e("MicroMsg.OpenGLHook", "onGlRenderbufferStorage: getCurrentResourceIdByTarget result == null, maybe undo glBindRenderbuffer()", new Object[0]);
        }
        do
        {
          return;
          Object localObject2 = localc.eXK;
          Object localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = new b(c.a.eXQ);
          }
          int i = paramInt3;
          int j = paramInt4;
          int k = paramInt2;
          int m = paramLong1;
          int n = localc.id;
          long l1 = localc.ayQ();
          long l2 = paramString;
          localObject2 = this.eXb;
          long l3 = this.eXc;
          ((b)localObject1).eXy = i;
          ((b)localObject1).width = j;
          ((b)localObject1).height = k;
          ((b)localObject1).eXA = m;
          ((b)localObject1).id = n;
          ((b)localObject1).eXC = l1;
          ((b)localObject1).size = l2;
          ((b)localObject1).eXD = ((String)localObject2);
          ((b)localObject1).eXE = l3;
          localc.a((b)localObject1);
        } while (OpenGLHook.getInstance().mMemoryListener == null);
        localc.ayQ();
      }
    });
  }
  
  public static void onGlTexImage2D(int paramInt1, final int paramInt2, final int paramInt3, final int paramInt4, final int paramInt5, final int paramInt6, final int paramInt7, final int paramInt8, final long paramLong1, final String paramString, long paramLong2)
  {
    long l = 0L;
    if (Build.VERSION.SDK_INT >= 21) {
      l = EGL14.eglGetCurrentContext().getNativeHandle();
    }
    com.tencent.matrix.openglleak.a.c.ayU().post(new Runnable()
    {
      public final void run()
      {
        com.tencent.matrix.openglleak.statistics.a.ayM();
        com.tencent.matrix.openglleak.statistics.resource.c localc = com.tencent.matrix.openglleak.statistics.a.a(c.a.eXN, this.eWV, paramInt2);
        if (localc == null) {
          com.tencent.matrix.e.c.e("MicroMsg.OpenGLHook", "onGlTexImage2D: getCurrentResourceIdByTarget openGLID == null, maybe undo glBindTextures()", new Object[0]);
        }
        do
        {
          return;
          b localb2 = localc.eXK;
          b localb1 = localb2;
          if (localb2 == null) {
            localb1 = new b(c.a.eXN);
          }
          localb1.a(paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, 0, paramInt7, paramInt8, paramLong1, localc.id, localc.ayQ(), paramString, this.eXb, this.eXc);
          localc.a(localb1);
        } while (OpenGLHook.getInstance().mMemoryListener == null);
        localc.ayQ();
      }
    });
  }
  
  public static void onGlTexImage3D(int paramInt1, final int paramInt2, final int paramInt3, final int paramInt4, final int paramInt5, final int paramInt6, final int paramInt7, final int paramInt8, final int paramInt9, final long paramLong1, final String paramString, long paramLong2)
  {
    long l = 0L;
    if (Build.VERSION.SDK_INT >= 21) {
      l = EGL14.eglGetCurrentContext().getNativeHandle();
    }
    com.tencent.matrix.openglleak.a.c.ayU().post(new Runnable()
    {
      public final void run()
      {
        com.tencent.matrix.openglleak.statistics.a.ayM();
        com.tencent.matrix.openglleak.statistics.resource.c localc = com.tencent.matrix.openglleak.statistics.a.a(c.a.eXN, this.eWV, paramInt2);
        if (localc == null) {
          com.tencent.matrix.e.c.e("MicroMsg.OpenGLHook", "onGlTexImage3D: getCurrentResourceIdByTarget result == null, maybe undo glBindTextures()", new Object[0]);
        }
        do
        {
          return;
          b localb2 = localc.eXK;
          b localb1 = localb2;
          if (localb2 == null) {
            localb1 = new b(c.a.eXN);
          }
          localb1.a(paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramLong1, localc.id, localc.ayQ(), paramString, this.eXb, this.eXc);
          localc.a(localb1);
        } while (OpenGLHook.getInstance().mMemoryListener == null);
        localc.ayQ();
      }
    });
  }
  
  private static String stackTraceToString(StackTraceElement[] paramArrayOfStackTraceElement)
  {
    if (paramArrayOfStackTraceElement == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramArrayOfStackTraceElement.length)
    {
      if (i != 0)
      {
        StackTraceElement localStackTraceElement = paramArrayOfStackTraceElement[i];
        if (!localStackTraceElement.getClassName().contains("java.lang.Thread")) {
          localStringBuilder.append("\t").append(localStackTraceElement).append('\n');
        }
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public boolean hook(String paramString, int paramInt)
  {
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return false;
        if (paramString.equals("glGetError"))
        {
          i = 0;
          continue;
          if (paramString.equals("glGenTextures"))
          {
            i = 1;
            continue;
            if (paramString.equals("glDeleteTextures"))
            {
              i = 2;
              continue;
              if (paramString.equals("glGenBuffers"))
              {
                i = 3;
                continue;
                if (paramString.equals("glDeleteBuffers"))
                {
                  i = 4;
                  continue;
                  if (paramString.equals("glGenFramebuffers"))
                  {
                    i = 5;
                    continue;
                    if (paramString.equals("glDeleteFramebuffers"))
                    {
                      i = 6;
                      continue;
                      if (paramString.equals("glGenRenderbuffers"))
                      {
                        i = 7;
                        continue;
                        if (paramString.equals("glDeleteRenderbuffers"))
                        {
                          i = 8;
                          continue;
                          if (paramString.equals("glTexImage2D"))
                          {
                            i = 9;
                            continue;
                            if (paramString.equals("glTexImage3D"))
                            {
                              i = 10;
                              continue;
                              if (paramString.equals("glBindTexture"))
                              {
                                i = 11;
                                continue;
                                if (paramString.equals("glBindBuffer"))
                                {
                                  i = 12;
                                  continue;
                                  if (paramString.equals("glBindFramebuffer"))
                                  {
                                    i = 13;
                                    continue;
                                    if (paramString.equals("glBindRenderbuffer"))
                                    {
                                      i = 14;
                                      continue;
                                      if (paramString.equals("glBufferData"))
                                      {
                                        i = 15;
                                        continue;
                                        if (paramString.equals("glRenderbufferStorage")) {
                                          i = 16;
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        break;
      }
    }
    return hookGlGetError(paramInt);
    return hookGlGenTextures(paramInt);
    return hookGlDeleteTextures(paramInt);
    return hookGlGenBuffers(paramInt);
    return hookGlDeleteBuffers(paramInt);
    return hookGlGenFramebuffers(paramInt);
    return hookGlDeleteFramebuffers(paramInt);
    return hookGlGenRenderbuffers(paramInt);
    return hookGlDeleteRenderbuffers(paramInt);
    return hookGlTexImage2D(paramInt);
    return hookGlTexImage3D(paramInt);
    return hookGlBindTexture(paramInt);
    return hookGlBindBuffer(paramInt);
    return hookGlBindFramebuffer(paramInt);
    return hookGlBindRenderbuffer(paramInt);
    return hookGlBufferData(paramInt);
    return hookGlRenderbufferStorage(paramInt);
  }
  
  public native boolean init();
  
  public void setBindListener(a parama)
  {
    this.mBindListener = parama;
  }
  
  public void setErrorListener(b paramb)
  {
    this.mErrorListener = paramb;
  }
  
  public native void setJavaStackDump(boolean paramBoolean);
  
  public void setMemoryListener(c paramc)
  {
    this.mMemoryListener = paramc;
  }
  
  public native void setNativeStackDump(boolean paramBoolean);
  
  public void setResourceListener(d paramd)
  {
    this.mResourceListener = paramd;
  }
  
  public static abstract interface a {}
  
  public static abstract interface b {}
  
  public static abstract interface c {}
  
  public static abstract interface d {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.matrix.openglleak.hook.OpenGLHook
 * JD-Core Version:    0.7.0.1
 */