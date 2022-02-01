package com.tencent.liteav.videoencoder;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecInfo.EncoderCapabilities;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.opengl.GLES20;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.util.Range;
import android.view.Surface;
import com.tencent.liteav.basic.c.b;
import com.tencent.liteav.basic.c.h;
import com.tencent.liteav.basic.c.k;
import com.tencent.liteav.basic.c.l;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.Monitor;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.basic.util.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;

public class a
  extends c
{
  private boolean A;
  private ByteBuffer[] B;
  private byte[] C;
  private volatile long D;
  private long E;
  private long F;
  private int G;
  private int H;
  private int I;
  private int J;
  private int K;
  private boolean L;
  private boolean M;
  private boolean N;
  private int O;
  private int P;
  private int Q;
  private long R;
  private int S;
  private int T;
  private int U;
  private boolean V;
  private ArrayList<Long> W;
  private int X;
  private long Y;
  private int Z;
  private int a;
  private int aa;
  private boolean ab;
  private boolean ac;
  private long ad;
  private Runnable ae;
  private long b;
  private double c;
  private long d;
  private long e;
  private int f;
  private boolean g;
  private boolean h;
  private long i;
  private long j;
  private long k;
  private long l;
  private long m;
  private boolean n;
  private long o;
  private long p;
  private MediaCodec q;
  private g r;
  private Runnable s;
  private Runnable t;
  private Runnable u;
  private ArrayDeque<Long> v;
  private Object w;
  private Surface x;
  private boolean y;
  private boolean z;
  
  public a()
  {
    AppMethodBeat.i(14859);
    this.a = 0;
    this.b = 0L;
    this.c = 0.0D;
    this.d = 0L;
    this.e = 0L;
    this.f = 0;
    this.g = false;
    this.h = true;
    this.i = 0L;
    this.j = 0L;
    this.k = 0L;
    this.l = 0L;
    this.m = 0L;
    this.o = 0L;
    this.p = 0L;
    this.q = null;
    this.r = null;
    this.s = new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(14784);
        a.a(a.this);
        AppMethodBeat.o(14784);
      }
    };
    this.t = new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(14850);
        a.d(a.this, 10);
        AppMethodBeat.o(14850);
      }
    };
    this.u = new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(14789);
        a.d(a.this, 1);
        AppMethodBeat.o(14789);
      }
    };
    this.v = new ArrayDeque(10);
    this.x = null;
    this.y = true;
    this.z = true;
    this.A = false;
    this.B = null;
    this.C = null;
    this.D = 0L;
    this.E = 0L;
    this.F = 0L;
    this.M = true;
    this.N = false;
    this.O = 0;
    this.P = 0;
    this.Q = 0;
    this.R = 0L;
    this.S = 0;
    this.T = 0;
    this.U = -1;
    this.V = false;
    this.X = 0;
    this.Y = 0L;
    this.Z = 3;
    this.aa = 0;
    this.ab = false;
    this.ac = true;
    this.ad = 0L;
    this.ae = new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(14822);
        a.b(a.this, System.currentTimeMillis());
        a.f(a.this);
        a.g(a.this);
        a.h(a.this);
        AppMethodBeat.o(14822);
      }
    };
    this.r = new g("HWVideoEncoder");
    AppMethodBeat.o(14859);
  }
  
  private int a(int paramInt)
  {
    AppMethodBeat.i(14877);
    if (this.q == null)
    {
      AppMethodBeat.o(14877);
      return -1;
    }
    MediaCodec.BufferInfo localBufferInfo = new MediaCodec.BufferInfo();
    int i3;
    try
    {
      i3 = this.q.dequeueOutputBuffer(localBufferInfo, paramInt * 1000);
      if (i3 == -1)
      {
        AppMethodBeat.o(14877);
        return 0;
      }
    }
    catch (IllegalStateException localIllegalStateException1)
    {
      TXCLog.e("TXCHWVideoEncoder", "dequeueOutputBuffer failed." + localIllegalStateException1.getMessage());
      AppMethodBeat.o(14877);
      return -1;
    }
    if (i3 == -3)
    {
      this.B = this.q.getOutputBuffers();
      AppMethodBeat.o(14877);
      return 1;
    }
    if (i3 == -2)
    {
      callDelegate(this.q.getOutputFormat());
      AppMethodBeat.o(14877);
      return 1;
    }
    if (i3 < 0)
    {
      AppMethodBeat.o(14877);
      return -1;
    }
    long l4 = TXCTimeUtil.getTimeTick();
    ByteBuffer localByteBuffer = this.B[i3];
    if (localByteBuffer == null) {
      paramInt = -1;
    }
    try
    {
      Object localObject1;
      for (;;)
      {
        if (this.q != null) {
          this.q.releaseOutputBuffer(i3, false);
        }
        AppMethodBeat.o(14877);
        return paramInt;
        arrayOfByte = new byte[localBufferInfo.size];
        localByteBuffer.position(localBufferInfo.offset);
        localByteBuffer.limit(localBufferInfo.offset + localBufferInfo.size);
        localByteBuffer.get(arrayOfByte, 0, localBufferInfo.size);
        i1 = arrayOfByte.length;
        if ((localBufferInfo.size <= 5) || (arrayOfByte[0] != 0) || (arrayOfByte[1] != 0) || (arrayOfByte[2] != 0) || (arrayOfByte[3] != 0) || (arrayOfByte[4] != 0) || (arrayOfByte[5] != 0)) {
          break label1340;
        }
        paramInt = 3;
        for (;;)
        {
          if (paramInt >= i1 - 4) {
            break label1331;
          }
          if ((arrayOfByte[paramInt] == 0) && (arrayOfByte[(paramInt + 1)] == 0) && (arrayOfByte[(paramInt + 2)] == 0) && (arrayOfByte[(paramInt + 3)] == 1))
          {
            i2 = i1 - paramInt;
            i1 = paramInt;
            paramInt = i2;
            localObject1 = new byte[paramInt];
            System.arraycopy(arrayOfByte, i1, localObject1, 0, paramInt);
            if (localBufferInfo.size != 0) {
              break label434;
            }
            if ((localBufferInfo.flags & 0x4) == 0) {
              break label429;
            }
            if (this.mListener != null) {
              this.mListener.a(null, 0);
            }
            paramInt = -2;
            break;
          }
          paramInt += 1;
        }
        label429:
        paramInt = -1;
      }
      label434:
      if ((localBufferInfo.flags & 0x2) == 2)
      {
        if (this.g) {}
        for (this.C = ((byte[])((byte[])localObject1).clone());; this.C = a((byte[])((byte[])localObject1).clone()))
        {
          paramInt = 1;
          break;
        }
      }
      Object localObject3;
      long l3;
      if ((localBufferInfo.flags & 0x1) == 1)
      {
        this.G = -1;
        if (this.g)
        {
          localObject3 = new byte[this.C.length + localObject1.length];
          System.arraycopy(this.C, 0, localObject3, 0, this.C.length);
          System.arraycopy(localObject1, 0, localObject3, this.C.length, localObject1.length);
          paramInt = 0;
          localObject1 = localObject3;
          if (!this.L)
          {
            i1 = this.G + 1;
            this.G = i1;
            if (i1 == this.f * this.H) {
              f();
            }
          }
          l2 = a();
          l1 = localBufferInfo.presentationTimeUs / 1000L;
          if (this.F == 0L) {
            this.F = l2;
          }
          if (this.E == 0L) {
            this.E = l1;
          }
          l3 = l1 + (this.F - this.E);
          l1 = l2;
          if (l2 <= this.m) {
            l1 = this.m + 1L;
          }
          l2 = l1;
          if (l1 > l3) {
            l2 = l3;
          }
          this.m = l2;
          l1 = TXCTimeUtil.getTimeTick();
          if (paramInt != 0) {
            break label999;
          }
          if (l1 > this.d + 1000L)
          {
            this.b = ((this.o * 8000.0D / (l1 - this.d) / 1024.0D));
            this.o = 0L;
            this.d = l1;
            g();
          }
          this.j += 1L;
          if (this.j % 256L == 0L) {
            this.j += 1L;
          }
        }
      }
      label999:
      for (this.k = 0L;; this.k += 1L)
      {
        this.o += localObject1.length;
        if (l1 <= this.e + 2000L) {
          break label1030;
        }
        this.c = (this.p * 1000.0D / (l1 - this.e));
        this.p = 0L;
        this.e = l1;
        l1 = 0L;
        localObject3 = this.W.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          Long localLong = (Long)((Iterator)localObject3).next();
          if (localLong.longValue() <= l1) {
            break label1323;
          }
          l1 = localLong.longValue();
        }
        localObject3 = a((byte[])localObject1);
        localObject1 = new byte[this.C.length + localObject3.length];
        System.arraycopy(this.C, 0, localObject1, 0, this.C.length);
        System.arraycopy(localObject3, 0, localObject1, this.C.length, localObject3.length);
        paramInt = 0;
        break;
        if (this.g) {
          break label1326;
        }
        localObject1 = a((byte[])localObject1);
        paramInt = 1;
        break;
      }
      this.W.clear();
      this.X = ((int)(3L * l1));
      label1030:
      this.p += 1L;
      localByteBuffer.position(localBufferInfo.offset);
      this.l += 1L;
      if (this.mListener != null) {
        this.mListener.a(2, this.j, this.k);
      }
      if (this.h)
      {
        l2 = this.j;
        l5 = this.k;
        l6 = this.l;
        if (paramInt == 0) {}
        for (l1 = this.k;; l1 = this.k - 1L)
        {
          callDelegate((byte[])localObject1, paramInt, l2, l5, l6, l1, l3, l3, 0, localByteBuffer, localBufferInfo);
          this.P += 1;
          if ((localBufferInfo.flags & 0x4) == 0) {
            break label1318;
          }
          if (this.mListener != null) {
            this.mListener.a(null, 0);
          }
          paramInt = -2;
          l1 = TXCTimeUtil.getTimeTick();
          this.W.add(Long.valueOf(l1 - l4));
          break;
        }
      }
      long l2 = this.j;
      long l5 = this.k;
      long l6 = this.l;
      if (paramInt == 0) {}
      for (long l1 = this.k;; l1 = this.k - 1L)
      {
        callDelegate(arrayOfByte, paramInt, l2, l5, l6, l1, l3, l3, 0, localByteBuffer, localBufferInfo);
        break;
      }
    }
    catch (IllegalStateException localIllegalStateException2)
    {
      for (;;)
      {
        byte[] arrayOfByte;
        TXCLog.e("TXCHWVideoEncoder", "releaseOutputBuffer failed." + localIllegalStateException2.getMessage());
        continue;
        label1318:
        paramInt = 1;
        continue;
        label1323:
        continue;
        label1326:
        paramInt = 1;
        continue;
        label1331:
        int i2 = 0;
        paramInt = i1;
        int i1 = i2;
        continue;
        label1340:
        Object localObject2 = arrayOfByte;
      }
    }
  }
  
  private int a(int paramInt1, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt3)
  {
    AppMethodBeat.i(14879);
    i1 = paramInt3;
    if (paramInt2 > 0)
    {
      i1 = paramInt3;
      if (paramInt1 > paramInt2) {
        paramInt1 -= paramInt2;
      }
    }
    try
    {
      ByteBuffer localByteBuffer = ByteBuffer.wrap(new byte[4]);
      localByteBuffer.asIntBuffer().put(paramInt1);
      localByteBuffer.order(ByteOrder.BIG_ENDIAN);
      System.arraycopy(localByteBuffer.array(), 0, paramArrayOfByte1, paramInt3, 4);
      System.arraycopy(paramArrayOfByte2, paramInt2, paramArrayOfByte1, paramInt3 + 4, paramInt1);
      i1 = paramInt3 + (paramInt1 + 4);
    }
    catch (Exception paramArrayOfByte1)
    {
      for (;;)
      {
        TXCLog.e("TXCHWVideoEncoder", "setNalData exception");
        i1 = paramInt3;
      }
    }
    AppMethodBeat.o(14879);
    return i1;
  }
  
  private long a()
  {
    AppMethodBeat.i(182430);
    Long localLong = (Long)this.v.poll();
    if (localLong == null)
    {
      AppMethodBeat.o(182430);
      return 0L;
    }
    long l1 = localLong.longValue();
    AppMethodBeat.o(182430);
    return l1;
  }
  
  @TargetApi(16)
  private static MediaCodecInfo a(String paramString)
  {
    AppMethodBeat.i(14871);
    int i3 = MediaCodecList.getCodecCount();
    int i1 = 0;
    while (i1 < i3)
    {
      MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i1);
      if (localMediaCodecInfo.isEncoder())
      {
        String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
        int i4 = arrayOfString.length;
        int i2 = 0;
        while (i2 < i4)
        {
          if (arrayOfString[i2].equalsIgnoreCase(paramString))
          {
            AppMethodBeat.o(14871);
            return localMediaCodecInfo;
          }
          i2 += 1;
        }
      }
      i1 += 1;
    }
    AppMethodBeat.o(14871);
    return null;
  }
  
  @TargetApi(16)
  private MediaFormat a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(14869);
    if ((paramInt1 == 0) || (paramInt2 == 0) || (paramInt3 == 0) || (paramInt4 == 0))
    {
      AppMethodBeat.o(14869);
      return null;
    }
    MediaFormat localMediaFormat = MediaFormat.createVideoFormat("video/avc", paramInt1, paramInt2);
    localMediaFormat.setInteger("bitrate", paramInt3 * 1024);
    localMediaFormat.setInteger("frame-rate", paramInt4);
    localMediaFormat.setInteger("color-format", 2130708361);
    localMediaFormat.setInteger("i-frame-interval", paramInt5);
    AppMethodBeat.o(14869);
    return localMediaFormat;
  }
  
  @TargetApi(16)
  private MediaFormat a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, boolean paramBoolean)
  {
    AppMethodBeat.i(14870);
    MediaFormat localMediaFormat = a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    if (localMediaFormat == null)
    {
      AppMethodBeat.o(14870);
      return null;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      Object localObject = a("video/avc");
      if (localObject == null)
      {
        AppMethodBeat.o(14870);
        return localMediaFormat;
      }
      localObject = ((MediaCodecInfo)localObject).getCapabilitiesForType("video/avc");
      MediaCodecInfo.EncoderCapabilities localEncoderCapabilities = ((MediaCodecInfo.CodecCapabilities)localObject).getEncoderCapabilities();
      if (paramBoolean) {
        localMediaFormat.setInteger("bitrate-mode", paramInt6);
      }
      for (;;)
      {
        localMediaFormat.setInteger("complexity", ((Integer)localEncoderCapabilities.getComplexityRange().clamp(Integer.valueOf(5))).intValue());
        paramInt2 = 0;
        if (Build.VERSION.SDK_INT < 23) {
          break;
        }
        localObject = ((MediaCodecInfo.CodecCapabilities)localObject).profileLevels;
        paramInt4 = localObject.length;
        paramInt1 = 0;
        while (paramInt1 < paramInt4)
        {
          localEncoderCapabilities = localObject[paramInt1];
          paramInt3 = paramInt2;
          if (localEncoderCapabilities.profile <= paramInt7)
          {
            paramInt3 = paramInt2;
            if (localEncoderCapabilities.profile > paramInt2)
            {
              paramInt3 = localEncoderCapabilities.profile;
              localMediaFormat.setInteger("profile", localEncoderCapabilities.profile);
              localMediaFormat.setInteger("level", localEncoderCapabilities.level);
            }
          }
          paramInt1 += 1;
          paramInt2 = paramInt3;
        }
        if (localEncoderCapabilities.isBitrateModeSupported(paramInt6)) {
          localMediaFormat.setInteger("bitrate-mode", paramInt6);
        } else if (this.L)
        {
          if (localEncoderCapabilities.isBitrateModeSupported(1)) {
            localMediaFormat.setInteger("bitrate-mode", 1);
          } else if (localEncoderCapabilities.isBitrateModeSupported(2)) {
            localMediaFormat.setInteger("bitrate-mode", 2);
          }
        }
        else if (localEncoderCapabilities.isBitrateModeSupported(2)) {
          localMediaFormat.setInteger("bitrate-mode", 2);
        }
      }
    }
    AppMethodBeat.o(14870);
    return localMediaFormat;
  }
  
  private void a(long paramLong)
  {
    AppMethodBeat.i(14872);
    this.v.add(Long.valueOf(paramLong));
    AppMethodBeat.o(14872);
  }
  
  private boolean a(Surface paramSurface, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(14874);
    if (paramSurface == null)
    {
      AppMethodBeat.o(14874);
      return false;
    }
    TXCLog.i("TXCHWVideoEncoder", "HWVideoEncode createGL: " + this.mGLContextExternal);
    if ((this.mGLContextExternal != null) && ((this.mGLContextExternal instanceof android.opengl.EGLContext))) {}
    for (this.w = com.tencent.liteav.basic.c.c.a(null, (android.opengl.EGLContext)this.mGLContextExternal, paramSurface, paramInt1, paramInt2); this.w == null; this.w = b.a(null, (javax.microedition.khronos.egl.EGLContext)this.mGLContextExternal, paramSurface, paramInt1, paramInt2))
    {
      AppMethodBeat.o(14874);
      return false;
    }
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    this.mEncodeFilter = new h();
    this.mEncodeFilter.a(l.e, l.a(k.a, false, false));
    if (!this.mEncodeFilter.a())
    {
      this.mEncodeFilter = null;
      AppMethodBeat.o(14874);
      return false;
    }
    GLES20.glViewport(0, 0, paramInt1, paramInt2);
    AppMethodBeat.o(14874);
    return true;
  }
  
  @TargetApi(18)
  private boolean a(TXSVideoEncoderParam paramTXSVideoEncoderParam)
  {
    AppMethodBeat.i(14876);
    this.z = false;
    this.y = false;
    this.b = 0L;
    this.c = 0.0D;
    this.d = 0L;
    this.e = 0L;
    this.f = 0;
    this.i = 0L;
    this.j = paramTXSVideoEncoderParam.baseGopIndex;
    this.k = 0L;
    this.l = paramTXSVideoEncoderParam.baseFrameIndex;
    this.m = 0L;
    this.o = 0L;
    this.p = 0L;
    this.B = null;
    this.C = null;
    this.D = 0L;
    this.G = -1;
    this.mOutputWidth = paramTXSVideoEncoderParam.width;
    this.mOutputHeight = paramTXSVideoEncoderParam.height;
    this.H = paramTXSVideoEncoderParam.gop;
    this.I = paramTXSVideoEncoderParam.fps;
    TXCLog.i("TXCHWVideoEncoder", "init with fps " + this.I);
    this.L = paramTXSVideoEncoderParam.fullIFrame;
    this.n = paramTXSVideoEncoderParam.syncOutput;
    this.A = paramTXSVideoEncoderParam.enableEGL14;
    this.N = paramTXSVideoEncoderParam.forceSetBitrateMode;
    this.v.clear();
    this.M = paramTXSVideoEncoderParam.bLimitFps;
    if ((paramTXSVideoEncoderParam == null) || (paramTXSVideoEncoderParam.width == 0) || (paramTXSVideoEncoderParam.height == 0) || (paramTXSVideoEncoderParam.fps == 0) || (paramTXSVideoEncoderParam.gop == 0))
    {
      this.y = true;
      AppMethodBeat.o(14876);
      return false;
    }
    this.g = paramTXSVideoEncoderParam.annexb;
    this.h = paramTXSVideoEncoderParam.appendSpsPps;
    if (this.a == 0) {
      this.a = ((int)(Math.sqrt(paramTXSVideoEncoderParam.width * paramTXSVideoEncoderParam.width * 1.0D + paramTXSVideoEncoderParam.height * paramTXSVideoEncoderParam.height) * 1.2D));
    }
    this.i = this.a;
    this.f = paramTXSVideoEncoderParam.fps;
    int i1 = 2;
    switch (paramTXSVideoEncoderParam.encoderMode)
    {
    }
    for (;;)
    {
      if (com.tencent.liteav.basic.d.c.a().d() == 1) {
        paramTXSVideoEncoderParam.encoderProfile = 1;
      }
      this.J = i1;
      this.K = 1;
      if (c()) {
        break;
      }
      AppMethodBeat.o(14876);
      return false;
      i1 = 2;
      continue;
      i1 = 1;
      continue;
      i1 = 0;
    }
    this.mInit = true;
    if (this.M)
    {
      this.U = -1;
      this.r.b(this.t);
    }
    this.W = new ArrayList();
    this.X = 0;
    AppMethodBeat.o(14876);
    return true;
  }
  
  private byte[] a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(14878);
    int i7 = paramArrayOfByte.length;
    byte[] arrayOfByte = new byte[i7 + 20];
    int i1 = 0;
    int i5 = 0;
    int i3;
    for (int i4 = 0;; i4 = i3)
    {
      int i6 = i1;
      int i2 = i5;
      i3 = i4;
      if (i1 < i7)
      {
        if ((paramArrayOfByte[i1] != 0) || (paramArrayOfByte[(i1 + 1)] != 0) || (paramArrayOfByte[(i1 + 2)] != 1)) {
          break label162;
        }
        i3 = a(i1, i5, arrayOfByte, paramArrayOfByte, i4);
        i2 = i1 + 3;
        i6 = i2;
      }
      while ((i6 == i7 - 4) && ((paramArrayOfByte[(i6 + 1)] != 0) || (paramArrayOfByte[(i6 + 2)] != 0) || (paramArrayOfByte[(i6 + 3)] != 1)))
      {
        i6 = i7;
        i1 = a(i6, i2, arrayOfByte, paramArrayOfByte, i3);
        paramArrayOfByte = new byte[i1];
        System.arraycopy(arrayOfByte, 0, paramArrayOfByte, 0, i1);
        AppMethodBeat.o(14878);
        return paramArrayOfByte;
        label162:
        i6 = i1;
        i2 = i5;
        i3 = i4;
        if (paramArrayOfByte[i1] == 0)
        {
          i6 = i1;
          i2 = i5;
          i3 = i4;
          if (paramArrayOfByte[(i1 + 1)] == 0)
          {
            i6 = i1;
            i2 = i5;
            i3 = i4;
            if (paramArrayOfByte[(i1 + 2)] == 0)
            {
              i6 = i1;
              i2 = i5;
              i3 = i4;
              if (paramArrayOfByte[(i1 + 3)] == 1)
              {
                i3 = a(i1, i5, arrayOfByte, paramArrayOfByte, i4);
                i2 = i1 + 4;
                i6 = i2;
              }
            }
          }
        }
      }
      i1 = i6 + 1;
      i5 = i2;
    }
  }
  
  private void b()
  {
    AppMethodBeat.i(182431);
    TXCLog.i("TXCHWVideoEncoder", "HWVideoEncode destroyGL");
    if (this.mEncodeFilter != null)
    {
      this.mEncodeFilter.d();
      this.mEncodeFilter = null;
    }
    if ((this.w instanceof b))
    {
      ((b)this.w).c();
      this.w = null;
    }
    if ((this.w instanceof com.tencent.liteav.basic.c.c))
    {
      ((com.tencent.liteav.basic.c.c)this.w).c();
      this.w = null;
    }
    AppMethodBeat.o(182431);
  }
  
  @TargetApi(18)
  private void b(int paramInt)
  {
    AppMethodBeat.i(14880);
    if ((this.y == true) || (this.w == null))
    {
      AppMethodBeat.o(14880);
      return;
    }
    int i3 = this.U;
    if (this.M)
    {
      this.U = -1;
      if (i3 == -1)
      {
        this.V = true;
        AppMethodBeat.o(14880);
        return;
      }
      this.T += 1;
      this.r.a(this.t, 1000 / this.I);
    }
    a(this.D);
    int i4 = (720 - this.mRotation) % 360;
    int i1;
    if ((i4 == 90) || (i4 == 270))
    {
      i1 = this.mOutputHeight;
      if ((i4 != 90) && (i4 != 270)) {
        break label311;
      }
    }
    label311:
    for (int i2 = this.mOutputWidth;; i2 = this.mOutputHeight)
    {
      this.mEncodeFilter.a(this.mInputWidth, this.mInputHeight, i4, null, i1 / i2, this.mEnableXMirror, true);
      this.mEncodeFilter.a(i3);
      if ((this.w instanceof com.tencent.liteav.basic.c.c))
      {
        ((com.tencent.liteav.basic.c.c)this.w).a(this.D * 1000000L);
        ((com.tencent.liteav.basic.c.c)this.w).d();
      }
      if ((this.w instanceof b)) {
        ((b)this.w).a();
      }
      do
      {
        i1 = a(paramInt);
      } while (i1 > 0);
      if ((i1 != -1) && (i1 != -2)) {
        break label319;
      }
      if (i1 == -1) {
        callDelegate(10000005);
      }
      this.y = true;
      e();
      AppMethodBeat.o(14880);
      return;
      i1 = this.mOutputWidth;
      break;
    }
    label319:
    this.O += 1;
    AppMethodBeat.o(14880);
  }
  
  private void c(int paramInt)
  {
    AppMethodBeat.i(14884);
    if (!this.mInit)
    {
      AppMethodBeat.o(14884);
      return;
    }
    if (this.i == this.a)
    {
      AppMethodBeat.o(14884);
      return;
    }
    if ((this.a < this.i) && (this.ac)) {
      if (this.ab)
      {
        paramInt = 1;
        localObject = "restart video hw encoder when down bps。[module:" + Build.MODEL + "] [Hardware:" + Build.HARDWARE + "] [osVersion:" + Build.VERSION.RELEASE + "]";
        TXCLog.w("TXCHWVideoEncoder", (String)localObject);
        Monitor.a(2, (String)localObject, "", 0);
      }
    }
    long l1;
    for (;;)
    {
      this.i = this.a;
      if ((Build.VERSION.SDK_INT < 19) || (this.q == null)) {
        break label299;
      }
      if (paramInt == 0) {
        break label265;
      }
      this.r.a().removeCallbacks(this.ae);
      l1 = System.currentTimeMillis();
      if (l1 - this.ad < 2000L) {
        break;
      }
      this.ae.run();
      AppMethodBeat.o(14884);
      return;
      this.Z = 3;
      this.Y = System.currentTimeMillis();
      this.aa = this.a;
      paramInt = 0;
    }
    this.r.a(this.ae, 2000L - (l1 - this.ad));
    AppMethodBeat.o(14884);
    return;
    label265:
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("video-bitrate", this.a * 1024);
    this.q.setParameters((Bundle)localObject);
    label299:
    AppMethodBeat.o(14884);
  }
  
  /* Error */
  private boolean c()
  {
    // Byte code:
    //   0: ldc_w 815
    //   3: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: getstatic 488	android/os/Build$VERSION:SDK_INT	I
    //   9: bipush 18
    //   11: if_icmpge +11 -> 22
    //   14: ldc_w 815
    //   17: invokestatic 218	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   20: iconst_0
    //   21: ireturn
    //   22: invokestatic 689	com/tencent/liteav/basic/d/c:a	()Lcom/tencent/liteav/basic/d/c;
    //   25: ldc_w 817
    //   28: ldc_w 819
    //   31: invokevirtual 822	com/tencent/liteav/basic/d/c:a	(Ljava/lang/String;Ljava/lang/String;)J
    //   34: lconst_0
    //   35: lcmp
    //   36: ifle +94 -> 130
    //   39: iconst_1
    //   40: istore_2
    //   41: aload_0
    //   42: iload_2
    //   43: putfield 204	com/tencent/liteav/videoencoder/a:ac	Z
    //   46: aload_0
    //   47: iconst_0
    //   48: putfield 178	com/tencent/liteav/videoencoder/a:O	I
    //   51: aload_0
    //   52: iconst_0
    //   53: putfield 180	com/tencent/liteav/videoencoder/a:P	I
    //   56: aload_0
    //   57: lconst_0
    //   58: putfield 184	com/tencent/liteav/videoencoder/a:R	J
    //   61: aload_0
    //   62: iconst_0
    //   63: putfield 186	com/tencent/liteav/videoencoder/a:S	I
    //   66: aload_0
    //   67: iconst_0
    //   68: putfield 182	com/tencent/liteav/videoencoder/a:Q	I
    //   71: aload_0
    //   72: iconst_0
    //   73: putfield 188	com/tencent/liteav/videoencoder/a:T	I
    //   76: aload_0
    //   77: aload_0
    //   78: getfield 630	com/tencent/liteav/videoencoder/a:mOutputWidth	I
    //   81: aload_0
    //   82: getfield 636	com/tencent/liteav/videoencoder/a:mOutputHeight	I
    //   85: aload_0
    //   86: getfield 105	com/tencent/liteav/videoencoder/a:a	I
    //   89: aload_0
    //   90: getfield 644	com/tencent/liteav/videoencoder/a:I	I
    //   93: aload_0
    //   94: getfield 327	com/tencent/liteav/videoencoder/a:H	I
    //   97: aload_0
    //   98: getfield 696	com/tencent/liteav/videoencoder/a:J	I
    //   101: aload_0
    //   102: getfield 698	com/tencent/liteav/videoencoder/a:K	I
    //   105: aload_0
    //   106: getfield 176	com/tencent/liteav/videoencoder/a:N	Z
    //   109: invokespecial 824	com/tencent/liteav/videoencoder/a:a	(IIIIIIIZ)Landroid/media/MediaFormat;
    //   112: astore_3
    //   113: aload_3
    //   114: ifnonnull +21 -> 135
    //   117: aload_0
    //   118: iconst_1
    //   119: putfield 158	com/tencent/liteav/videoencoder/a:y	Z
    //   122: ldc_w 815
    //   125: invokestatic 218	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   128: iconst_0
    //   129: ireturn
    //   130: iconst_0
    //   131: istore_2
    //   132: goto -91 -> 41
    //   135: aload_0
    //   136: ldc_w 461
    //   139: invokestatic 828	android/media/MediaCodec:createEncoderByType	(Ljava/lang/String;)Landroid/media/MediaCodec;
    //   142: putfield 135	com/tencent/liteav/videoencoder/a:q	Landroid/media/MediaCodec;
    //   145: aload_0
    //   146: getfield 832	com/tencent/liteav/videoencoder/a:mEncFmt	Lorg/json/JSONArray;
    //   149: astore 4
    //   151: aload 4
    //   153: ifnull +81 -> 234
    //   156: iconst_0
    //   157: istore_1
    //   158: iload_1
    //   159: aload_0
    //   160: getfield 832	com/tencent/liteav/videoencoder/a:mEncFmt	Lorg/json/JSONArray;
    //   163: invokevirtual 837	org/json/JSONArray:length	()I
    //   166: if_icmpge +68 -> 234
    //   169: aload_0
    //   170: getfield 832	com/tencent/liteav/videoencoder/a:mEncFmt	Lorg/json/JSONArray;
    //   173: iload_1
    //   174: invokevirtual 841	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   177: astore 4
    //   179: aload_3
    //   180: aload 4
    //   182: ldc_w 843
    //   185: invokevirtual 849	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   188: aload 4
    //   190: ldc_w 850
    //   193: invokevirtual 854	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   196: invokevirtual 473	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   199: iload_1
    //   200: iconst_1
    //   201: iadd
    //   202: istore_1
    //   203: goto -45 -> 158
    //   206: astore 4
    //   208: ldc 233
    //   210: new 235	java/lang/StringBuilder
    //   213: dup
    //   214: ldc_w 856
    //   217: invokespecial 238	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   220: aload 4
    //   222: invokevirtual 857	java/lang/Exception:toString	()Ljava/lang/String;
    //   225: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   231: invokestatic 779	com/tencent/liteav/basic/log/TXCLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   234: aload_0
    //   235: getfield 135	com/tencent/liteav/videoencoder/a:q	Landroid/media/MediaCodec;
    //   238: aload_3
    //   239: aconst_null
    //   240: aconst_null
    //   241: iconst_1
    //   242: invokevirtual 861	android/media/MediaCodec:configure	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    //   245: ldc 233
    //   247: new 235	java/lang/StringBuilder
    //   250: dup
    //   251: ldc_w 863
    //   254: invokespecial 238	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   257: aload_3
    //   258: invokevirtual 864	android/media/MediaFormat:toString	()Ljava/lang/String;
    //   261: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   267: invokestatic 563	com/tencent/liteav/basic/log/TXCLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   270: iconst_3
    //   271: istore_1
    //   272: aload_0
    //   273: aload_0
    //   274: getfield 135	com/tencent/liteav/videoencoder/a:q	Landroid/media/MediaCodec;
    //   277: invokevirtual 868	android/media/MediaCodec:createInputSurface	()Landroid/view/Surface;
    //   280: putfield 156	com/tencent/liteav/videoencoder/a:x	Landroid/view/Surface;
    //   283: iconst_4
    //   284: istore_1
    //   285: aload_0
    //   286: getfield 135	com/tencent/liteav/videoencoder/a:q	Landroid/media/MediaCodec;
    //   289: invokevirtual 871	android/media/MediaCodec:start	()V
    //   292: aload_0
    //   293: aload_0
    //   294: getfield 135	com/tencent/liteav/videoencoder/a:q	Landroid/media/MediaCodec;
    //   297: invokevirtual 258	android/media/MediaCodec:getOutputBuffers	()[Ljava/nio/ByteBuffer;
    //   300: putfield 164	com/tencent/liteav/videoencoder/a:B	[Ljava/nio/ByteBuffer;
    //   303: aload_0
    //   304: getfield 135	com/tencent/liteav/videoencoder/a:q	Landroid/media/MediaCodec;
    //   307: ifnull +17 -> 324
    //   310: aload_0
    //   311: getfield 164	com/tencent/liteav/videoencoder/a:B	[Ljava/nio/ByteBuffer;
    //   314: ifnull +10 -> 324
    //   317: aload_0
    //   318: getfield 156	com/tencent/liteav/videoencoder/a:x	Landroid/view/Surface;
    //   321: ifnonnull +265 -> 586
    //   324: aload_0
    //   325: iconst_1
    //   326: putfield 158	com/tencent/liteav/videoencoder/a:y	Z
    //   329: ldc_w 815
    //   332: invokestatic 218	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   335: iconst_0
    //   336: ireturn
    //   337: astore_3
    //   338: aload_0
    //   339: getfield 176	com/tencent/liteav/videoencoder/a:N	Z
    //   342: ifeq +175 -> 517
    //   345: aload_0
    //   346: aload_0
    //   347: getfield 630	com/tencent/liteav/videoencoder/a:mOutputWidth	I
    //   350: aload_0
    //   351: getfield 636	com/tencent/liteav/videoencoder/a:mOutputHeight	I
    //   354: aload_0
    //   355: getfield 105	com/tencent/liteav/videoencoder/a:a	I
    //   358: aload_0
    //   359: getfield 644	com/tencent/liteav/videoencoder/a:I	I
    //   362: aload_0
    //   363: getfield 327	com/tencent/liteav/videoencoder/a:H	I
    //   366: aload_0
    //   367: getfield 696	com/tencent/liteav/videoencoder/a:J	I
    //   370: aload_0
    //   371: getfield 698	com/tencent/liteav/videoencoder/a:K	I
    //   374: iconst_0
    //   375: invokespecial 824	com/tencent/liteav/videoencoder/a:a	(IIIIIIIZ)Landroid/media/MediaFormat;
    //   378: astore_3
    //   379: aload_0
    //   380: getfield 135	com/tencent/liteav/videoencoder/a:q	Landroid/media/MediaCodec;
    //   383: aload_3
    //   384: aconst_null
    //   385: aconst_null
    //   386: iconst_1
    //   387: invokevirtual 861	android/media/MediaCodec:configure	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    //   390: goto -120 -> 270
    //   393: astore_3
    //   394: aload_3
    //   395: instanceof 873
    //   398: ifne +18 -> 416
    //   401: getstatic 488	android/os/Build$VERSION:SDK_INT	I
    //   404: bipush 21
    //   406: if_icmplt -136 -> 270
    //   409: aload_3
    //   410: instanceof 875
    //   413: ifeq -143 -> 270
    //   416: aload_0
    //   417: aload_0
    //   418: getfield 630	com/tencent/liteav/videoencoder/a:mOutputWidth	I
    //   421: aload_0
    //   422: getfield 636	com/tencent/liteav/videoencoder/a:mOutputHeight	I
    //   425: aload_0
    //   426: getfield 105	com/tencent/liteav/videoencoder/a:a	I
    //   429: aload_0
    //   430: getfield 644	com/tencent/liteav/videoencoder/a:I	I
    //   433: aload_0
    //   434: getfield 327	com/tencent/liteav/videoencoder/a:H	I
    //   437: invokespecial 483	com/tencent/liteav/videoencoder/a:a	(IIIII)Landroid/media/MediaFormat;
    //   440: astore_3
    //   441: aload_0
    //   442: getfield 135	com/tencent/liteav/videoencoder/a:q	Landroid/media/MediaCodec;
    //   445: aload_3
    //   446: aconst_null
    //   447: aconst_null
    //   448: iconst_1
    //   449: invokevirtual 861	android/media/MediaCodec:configure	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    //   452: goto -182 -> 270
    //   455: astore_3
    //   456: iconst_2
    //   457: istore_1
    //   458: ldc 233
    //   460: ldc_w 877
    //   463: aload_3
    //   464: invokestatic 880	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   467: iload_1
    //   468: iconst_5
    //   469: if_icmplt +17 -> 486
    //   472: aload_0
    //   473: getfield 135	com/tencent/liteav/videoencoder/a:q	Landroid/media/MediaCodec;
    //   476: ifnull +10 -> 486
    //   479: aload_0
    //   480: getfield 135	com/tencent/liteav/videoencoder/a:q	Landroid/media/MediaCodec;
    //   483: invokevirtual 883	android/media/MediaCodec:stop	()V
    //   486: aload_0
    //   487: aconst_null
    //   488: putfield 135	com/tencent/liteav/videoencoder/a:q	Landroid/media/MediaCodec;
    //   491: aload_0
    //   492: getfield 156	com/tencent/liteav/videoencoder/a:x	Landroid/view/Surface;
    //   495: ifnull +10 -> 505
    //   498: aload_0
    //   499: getfield 156	com/tencent/liteav/videoencoder/a:x	Landroid/view/Surface;
    //   502: invokevirtual 888	android/view/Surface:release	()V
    //   505: aload_0
    //   506: aconst_null
    //   507: putfield 156	com/tencent/liteav/videoencoder/a:x	Landroid/view/Surface;
    //   510: goto -207 -> 303
    //   513: astore_3
    //   514: goto -211 -> 303
    //   517: aload_3
    //   518: instanceof 873
    //   521: ifne +18 -> 539
    //   524: getstatic 488	android/os/Build$VERSION:SDK_INT	I
    //   527: bipush 21
    //   529: if_icmplt +49 -> 578
    //   532: aload_3
    //   533: instanceof 875
    //   536: ifeq +42 -> 578
    //   539: aload_0
    //   540: aload_0
    //   541: getfield 630	com/tencent/liteav/videoencoder/a:mOutputWidth	I
    //   544: aload_0
    //   545: getfield 636	com/tencent/liteav/videoencoder/a:mOutputHeight	I
    //   548: aload_0
    //   549: getfield 105	com/tencent/liteav/videoencoder/a:a	I
    //   552: aload_0
    //   553: getfield 644	com/tencent/liteav/videoencoder/a:I	I
    //   556: aload_0
    //   557: getfield 327	com/tencent/liteav/videoencoder/a:H	I
    //   560: invokespecial 483	com/tencent/liteav/videoencoder/a:a	(IIIII)Landroid/media/MediaFormat;
    //   563: astore_3
    //   564: aload_0
    //   565: getfield 135	com/tencent/liteav/videoencoder/a:q	Landroid/media/MediaCodec;
    //   568: aload_3
    //   569: aconst_null
    //   570: aconst_null
    //   571: iconst_1
    //   572: invokevirtual 861	android/media/MediaCodec:configure	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    //   575: goto -305 -> 270
    //   578: ldc_w 815
    //   581: invokestatic 218	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   584: aload_3
    //   585: athrow
    //   586: aload_0
    //   587: aload_0
    //   588: getfield 156	com/tencent/liteav/videoencoder/a:x	Landroid/view/Surface;
    //   591: aload_0
    //   592: getfield 630	com/tencent/liteav/videoencoder/a:mOutputWidth	I
    //   595: aload_0
    //   596: getfield 636	com/tencent/liteav/videoencoder/a:mOutputHeight	I
    //   599: invokespecial 890	com/tencent/liteav/videoencoder/a:a	(Landroid/view/Surface;II)Z
    //   602: ifne +16 -> 618
    //   605: aload_0
    //   606: iconst_1
    //   607: putfield 158	com/tencent/liteav/videoencoder/a:y	Z
    //   610: ldc_w 815
    //   613: invokestatic 218	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   616: iconst_0
    //   617: ireturn
    //   618: ldc_w 815
    //   621: invokestatic 218	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   624: iconst_1
    //   625: ireturn
    //   626: astore_3
    //   627: iconst_1
    //   628: istore_1
    //   629: goto -171 -> 458
    //   632: astore_3
    //   633: goto -175 -> 458
    //   636: astore_3
    //   637: iconst_5
    //   638: istore_1
    //   639: goto -181 -> 458
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	642	0	this	a
    //   157	482	1	i1	int
    //   40	92	2	bool	boolean
    //   112	146	3	localMediaFormat1	MediaFormat
    //   337	1	3	localException1	Exception
    //   378	6	3	localMediaFormat2	MediaFormat
    //   393	17	3	localException2	Exception
    //   440	6	3	localMediaFormat3	MediaFormat
    //   455	9	3	localException3	Exception
    //   513	20	3	localException4	Exception
    //   563	22	3	localMediaFormat4	MediaFormat
    //   626	1	3	localException5	Exception
    //   632	1	3	localException6	Exception
    //   636	1	3	localException7	Exception
    //   149	40	4	localObject	Object
    //   206	15	4	localException8	Exception
    // Exception table:
    //   from	to	target	type
    //   158	199	206	java/lang/Exception
    //   234	270	337	java/lang/Exception
    //   379	390	393	java/lang/Exception
    //   145	151	455	java/lang/Exception
    //   208	234	455	java/lang/Exception
    //   338	379	455	java/lang/Exception
    //   394	416	455	java/lang/Exception
    //   416	452	455	java/lang/Exception
    //   517	539	455	java/lang/Exception
    //   539	575	455	java/lang/Exception
    //   578	586	455	java/lang/Exception
    //   472	486	513	java/lang/Exception
    //   486	505	513	java/lang/Exception
    //   505	510	513	java/lang/Exception
    //   76	113	626	java/lang/Exception
    //   117	122	626	java/lang/Exception
    //   135	145	626	java/lang/Exception
    //   272	283	632	java/lang/Exception
    //   285	292	632	java/lang/Exception
    //   292	303	636	java/lang/Exception
  }
  
  private void d()
  {
    AppMethodBeat.i(182433);
    if (this.q == null)
    {
      AppMethodBeat.o(182433);
      return;
    }
    for (;;)
    {
      try
      {
        this.q.stop();
      }
      catch (IllegalStateException localIllegalStateException)
      {
        localIllegalStateException = localIllegalStateException;
        TXCLog.e("TXCHWVideoEncoder", "stop encoder failed.", localIllegalStateException);
        try
        {
          this.q.release();
          if (this.x != null) {
            this.x.release();
          }
          this.x = null;
        }
        catch (Exception localException2)
        {
          TXCLog.e("TXCHWVideoEncoder", "release encoder failed.", localException2);
        }
        continue;
      }
      finally {}
      try
      {
        this.q.release();
        if (this.x != null) {
          this.x.release();
        }
        this.x = null;
      }
      catch (Exception localException1)
      {
        TXCLog.e("TXCHWVideoEncoder", "release encoder failed.", localException1);
      }
    }
    this.q = null;
    AppMethodBeat.o(182433);
    return;
    try
    {
      this.q.release();
      if (this.x != null) {
        this.x.release();
      }
      this.x = null;
    }
    catch (Exception localException3)
    {
      for (;;)
      {
        TXCLog.e("TXCHWVideoEncoder", "release encoder failed.", localException3);
      }
    }
    AppMethodBeat.o(182433);
    throw localObject;
  }
  
  private void d(int paramInt)
  {
    AppMethodBeat.i(14886);
    if (!this.mInit)
    {
      AppMethodBeat.o(14886);
      return;
    }
    if ((paramInt == 0) || (this.I == paramInt))
    {
      AppMethodBeat.o(14886);
      return;
    }
    if (Build.VERSION.SDK_INT < 18)
    {
      AppMethodBeat.o(14886);
      return;
    }
    TXCLog.i("TXCHWVideoEncoder", "set fps " + paramInt + ", restart encoder.");
    b();
    d();
    this.I = paramInt;
    c();
    AppMethodBeat.o(14886);
  }
  
  private void e()
  {
    AppMethodBeat.i(14882);
    if (!this.mInit)
    {
      AppMethodBeat.o(14882);
      return;
    }
    this.y = true;
    this.z = true;
    b();
    d();
    this.U = -1;
    this.b = 0L;
    this.c = 0.0D;
    this.d = 0L;
    this.e = 0L;
    this.f = 0;
    this.i = 0L;
    this.j = 0L;
    this.k = 0L;
    this.l = 0L;
    this.m = 0L;
    this.o = 0L;
    this.p = 0L;
    this.mGLContextExternal = null;
    this.B = null;
    this.C = null;
    this.D = 0L;
    this.mOutputWidth = 0;
    this.mOutputHeight = 0;
    this.mInit = false;
    this.mListener = null;
    this.v.clear();
    this.W.clear();
    this.X = 0;
    AppMethodBeat.o(14882);
  }
  
  private void f()
  {
    AppMethodBeat.i(14883);
    if ((Build.VERSION.SDK_INT >= 19) && (this.q != null))
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("request-sync", 0);
      this.q.setParameters(localBundle);
    }
    AppMethodBeat.o(14883);
  }
  
  private void g()
  {
    long l1 = 100L;
    int i1 = 5;
    AppMethodBeat.i(14885);
    int i3;
    int i4;
    int i2;
    if (this.Y > 0L)
    {
      i3 = this.I;
      i4 = (int)this.c;
      i2 = this.I / 2;
      if (i2 >= 5) {
        break label287;
      }
    }
    for (;;)
    {
      long l3;
      long l4;
      long l2;
      if ((i3 - i4 <= i1) && (System.currentTimeMillis() - this.Y > (3 - this.Z + 1) * 2000))
      {
        l3 = this.aa;
        l4 = this.b;
        l2 = this.i / 2L;
        if (l2 >= 100L) {
          break label280;
        }
      }
      for (;;)
      {
        if (l3 - l4 > l1)
        {
          this.ab = true;
          String str = "real bitrate is too much lower than target bitrate![targetBr:" + this.aa + "] [realBr:" + this.b + "]. restart encoder. [module:" + Build.MODEL + "] [Hardware:" + Build.HARDWARE + "] [osVersion:" + Build.VERSION.RELEASE + "]";
          TXCLog.e("TXCHWVideoEncoder", str);
          Monitor.a(3, str, "", 0);
          if (this.r != null) {
            this.r.b(this.ae);
          }
          this.Y = 0L;
          AppMethodBeat.o(14885);
          return;
        }
        this.Z -= 1;
        if (this.Z <= 0) {
          this.Y = 0L;
        }
        AppMethodBeat.o(14885);
        return;
        label280:
        l1 = l2;
      }
      label287:
      i1 = i2;
    }
  }
  
  public int getEncodeCost()
  {
    return this.X;
  }
  
  public long getRealBitrate()
  {
    return this.b;
  }
  
  public double getRealFPS()
  {
    return this.c;
  }
  
  public long pushVideoFrame(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    AppMethodBeat.i(14865);
    if (this.z)
    {
      AppMethodBeat.o(14865);
      return 10000004L;
    }
    GLES20.glFinish();
    this.Q += 1;
    this.D = paramLong;
    this.U = paramInt1;
    this.mInputWidth = paramInt2;
    this.mInputHeight = paramInt3;
    if (this.L) {
      f();
    }
    if ((!this.M) || (this.V))
    {
      this.T += 1;
      this.r.b(this.t);
      this.V = false;
    }
    if (this.O > this.P + 30)
    {
      TXCLog.e("TXCHWVideoEncoder", String.format("hw encoder error when render[%d] pop[%d]", new Object[] { Integer.valueOf(this.O), Integer.valueOf(this.P) }));
      if (this.mListener != null) {
        this.mListener.l(this.mStreamType);
      }
    }
    if (this.R + 5000L < System.currentTimeMillis())
    {
      this.R = System.currentTimeMillis();
      if ((this.S != 0) && (this.S == this.O))
      {
        TXCLog.i("TXCHWVideoEncoder", String.format("hw encoder error when push[%d] render task[%d] render[%d] pop[%d]", new Object[] { Integer.valueOf(this.Q), Integer.valueOf(this.T), Integer.valueOf(this.O), Integer.valueOf(this.P) }));
        if (this.mListener != null) {
          this.mListener.l(this.mStreamType);
        }
      }
      this.S = this.O;
    }
    AppMethodBeat.o(14865);
    return 0L;
  }
  
  public long pushVideoFrameAsync(final int paramInt1, int paramInt2, int paramInt3, final long paramLong)
  {
    AppMethodBeat.i(14866);
    if (this.z)
    {
      AppMethodBeat.o(14866);
      return 10000004L;
    }
    GLES20.glFinish();
    if (this.L) {
      f();
    }
    this.r.a().post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(14820);
        if ((a.b(a.this) == true) || (a.c(a.this) == null))
        {
          AppMethodBeat.o(14820);
          return;
        }
        int k = paramInt1;
        long l = paramLong;
        a.a(a.this, l);
        int m = (720 - a.this.mRotation) % 360;
        int i;
        if ((m == 90) || (m == 270))
        {
          i = a.this.mOutputHeight;
          if ((m != 90) && (m != 270)) {
            break label343;
          }
        }
        label343:
        for (int j = a.this.mOutputWidth;; j = a.this.mOutputHeight)
        {
          a.this.mEncodeFilter.a(a.this.mInputWidth, a.this.mInputHeight, m, null, i / j, a.this.mEnableXMirror, true);
          a.this.mEncodeFilter.a(k);
          if ((a.c(a.this) instanceof com.tencent.liteav.basic.c.c))
          {
            ((com.tencent.liteav.basic.c.c)a.c(a.this)).a(1000000L * l);
            ((com.tencent.liteav.basic.c.c)a.c(a.this)).d();
          }
          if ((a.c(a.this) instanceof b)) {
            ((b)a.c(a.this)).a();
          }
          if (a.this.mListener != null) {
            a.this.mListener.m(a.this.mStreamType);
          }
          do
          {
            i = a.c(a.this, 1);
          } while (i > 0);
          if ((i != -1) && (i != -2)) {
            break label354;
          }
          if (i == -1) {
            a.this.callDelegate(10000005);
          }
          a.a(a.this, true);
          a.a(a.this);
          AppMethodBeat.o(14820);
          return;
          i = a.this.mOutputWidth;
          break;
        }
        label354:
        a.d(a.this);
        AppMethodBeat.o(14820);
      }
    });
    AppMethodBeat.o(14866);
    return 0L;
  }
  
  public long pushVideoFrameSync(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    AppMethodBeat.i(14867);
    if (this.z)
    {
      AppMethodBeat.o(14867);
      return 10000004L;
    }
    GLES20.glFinish();
    this.D = paramLong;
    this.U = paramInt1;
    if (this.L) {
      f();
    }
    this.r.a(this.u);
    AppMethodBeat.o(14867);
    return 0L;
  }
  
  public void setBitrate(final int paramInt)
  {
    AppMethodBeat.i(14863);
    this.a = paramInt;
    this.r.b(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(14851);
        a.b(a.this, paramInt);
        AppMethodBeat.o(14851);
      }
    });
    AppMethodBeat.o(14863);
  }
  
  public void setBitrateFromQos(final int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(14864);
    this.a = paramInt1;
    this.r.b(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(14858);
        a.b(a.this, paramInt1);
        AppMethodBeat.o(14858);
      }
    });
    AppMethodBeat.o(14864);
  }
  
  public void setEncodeIdrFpsFromQos(int paramInt) {}
  
  public void setFPS(final int paramInt)
  {
    AppMethodBeat.i(14862);
    this.r.b(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(14787);
        a.a(a.this, paramInt);
        AppMethodBeat.o(14787);
      }
    });
    AppMethodBeat.o(14862);
  }
  
  public void signalEOSAndFlush()
  {
    AppMethodBeat.i(14868);
    if (this.z)
    {
      AppMethodBeat.o(14868);
      return;
    }
    this.r.a(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(14788);
        if (a.e(a.this) == null)
        {
          AppMethodBeat.o(14788);
          return;
        }
        try
        {
          a.e(a.this).signalEndOfInputStream();
          while (a.c(a.this, 10) >= 0) {}
          a.a(a.this);
          AppMethodBeat.o(14788);
          return;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            TXCLog.e("TXCHWVideoEncoder", "signalEndOfInputStream failed.", localException);
          }
        }
      }
    });
    AppMethodBeat.o(14868);
  }
  
  public int start(final TXSVideoEncoderParam paramTXSVideoEncoderParam)
  {
    AppMethodBeat.i(14860);
    super.start(paramTXSVideoEncoderParam);
    int i1 = 1;
    if (Build.VERSION.SDK_INT < 18) {
      i1 = 0;
    }
    while (i1 != 0)
    {
      AppMethodBeat.o(14860);
      return 0;
      this.r.b(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(14785);
          String str1 = "unknown";
          String str2 = "unknown";
          label80:
          int i;
          int j;
          int k;
          int m;
          int n;
          int i1;
          switch (paramTXSVideoEncoderParam.encoderMode)
          {
          default: 
            switch (paramTXSVideoEncoderParam.encoderProfile)
            {
            default: 
              i = a.this.hashCode();
              j = paramTXSVideoEncoderParam.width;
              k = paramTXSVideoEncoderParam.height;
              m = paramTXSVideoEncoderParam.fps;
              n = paramTXSVideoEncoderParam.bitrate;
              i1 = paramTXSVideoEncoderParam.gop;
              if (!paramTXSVideoEncoderParam.bMultiRef) {}
              break;
            }
            break;
          }
          for (String str3 = "true";; str3 = "false")
          {
            str1 = String.format("VideoEncoder[%d]: Start [type:hardware][resolution:%d*%d][fps:%d][bitrate:%dkbps][gop:%d][rateControl:%s][profile:%s][rps:%s][streamType:%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), str1, str2, str3, Integer.valueOf(paramTXSVideoEncoderParam.streamType) });
            Monitor.a(2, str1, "", 0);
            TXCLog.i("TXCHWVideoEncoder", "start:".concat(String.valueOf(str1)));
            if (a.this.mInit) {
              a.a(a.this);
            }
            if (!a.a(a.this, paramTXSVideoEncoderParam)) {
              break label387;
            }
            Monitor.a(2, String.format("VideoEncoder[%d]: Start successfully, streamType:%d", new Object[] { Integer.valueOf(a.this.hashCode()), Integer.valueOf(paramTXSVideoEncoderParam.streamType) }), "streamType: 2-big, 3-small, 7-sub", 0);
            AppMethodBeat.o(14785);
            return;
            str1 = "CBR";
            break;
            str1 = "VBR";
            break;
            str1 = "CQ";
            break;
            str2 = "Baseline";
            break label80;
            str2 = "Main";
            break label80;
            str2 = "High";
            break label80;
          }
          label387:
          a.this.callDelegate(10000004);
          AppMethodBeat.o(14785);
        }
      });
    }
    AppMethodBeat.o(14860);
    return 10000004;
  }
  
  public void stop()
  {
    AppMethodBeat.i(14861);
    this.z = true;
    this.r.b(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(14857);
        if (a.this.mInit)
        {
          Monitor.a(2, String.format("VideoEncoder[%d]: Stop, streamType:%d", new Object[] { Integer.valueOf(a.this.hashCode()), Integer.valueOf(a.this.mStreamType) }), "streamType: 2-big, 3-small, 7-sub", 0);
          a.a(a.this);
        }
        AppMethodBeat.o(14857);
      }
    });
    AppMethodBeat.o(14861);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.liteav.videoencoder.a
 * JD-Core Version:    0.7.0.1
 */