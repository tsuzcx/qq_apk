package com.tencent.liteav.videoencoder;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.CodecException;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecInfo.EncoderCapabilities;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.opengl.GLES20;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Range;
import android.view.Surface;
import com.tencent.liteav.basic.d.g;
import com.tencent.liteav.basic.d.j;
import com.tencent.liteav.basic.d.k;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.ArrayDeque;

public class a
  extends c
{
  private static final String a;
  private boolean A;
  private boolean B;
  private ByteBuffer[] C;
  private byte[] D;
  private volatile long E;
  private long F;
  private long G;
  private long H;
  private int I;
  private int J;
  private int K;
  private int L;
  private int M;
  private boolean N;
  private boolean O;
  private int P;
  private int Q;
  private int R;
  private int S;
  private boolean T;
  private int b;
  private long c;
  private double d;
  private long e;
  private long f;
  private int g;
  private boolean h;
  private boolean i;
  private long j;
  private long k;
  private long l;
  private long m;
  private long n;
  private boolean o;
  private long p;
  private long q;
  private MediaCodec r;
  private com.tencent.liteav.basic.util.c s;
  private Runnable t;
  private Runnable u;
  private Runnable v;
  private ArrayDeque<Long> w;
  private Object x;
  private Surface y;
  private boolean z;
  
  static
  {
    AppMethodBeat.i(67395);
    a = a.class.getSimpleName();
    AppMethodBeat.o(67395);
  }
  
  public a()
  {
    AppMethodBeat.i(67366);
    this.b = 0;
    this.c = 0L;
    this.d = 0.0D;
    this.e = 0L;
    this.f = 0L;
    this.g = 0;
    this.h = false;
    this.i = true;
    this.j = 0L;
    this.k = 0L;
    this.l = 0L;
    this.m = 0L;
    this.n = 0L;
    this.p = 0L;
    this.q = 0L;
    this.r = null;
    this.s = null;
    this.t = new a.7(this);
    this.u = new a.8(this);
    this.v = new a.9(this);
    this.w = new ArrayDeque(10);
    this.y = null;
    this.z = true;
    this.A = true;
    this.B = false;
    this.C = null;
    this.D = null;
    this.E = 0L;
    this.F = 0L;
    this.G = 0L;
    this.H = 0L;
    this.O = true;
    this.P = 0;
    this.Q = 0;
    this.R = 0;
    this.S = -1;
    this.T = false;
    this.s = new com.tencent.liteav.basic.util.c("HWVideoEncoder");
    this.F = 0L;
    AppMethodBeat.o(67366);
  }
  
  private int a(int paramInt)
  {
    AppMethodBeat.i(67382);
    if (this.r == null)
    {
      AppMethodBeat.o(67382);
      return -1;
    }
    MediaCodec.BufferInfo localBufferInfo = new MediaCodec.BufferInfo();
    int i3;
    try
    {
      i3 = this.r.dequeueOutputBuffer(localBufferInfo, paramInt * 1000);
      if (i3 == -1)
      {
        AppMethodBeat.o(67382);
        return 0;
      }
    }
    catch (IllegalStateException localIllegalStateException1)
    {
      AppMethodBeat.o(67382);
      return -1;
    }
    if (i3 == -3)
    {
      this.C = this.r.getOutputBuffers();
      AppMethodBeat.o(67382);
      return 1;
    }
    if (i3 == -2)
    {
      callDelegate(this.r.getOutputFormat());
      AppMethodBeat.o(67382);
      return 1;
    }
    if (i3 < 0)
    {
      AppMethodBeat.o(67382);
      return -1;
    }
    ByteBuffer localByteBuffer = this.C[i3];
    if (localByteBuffer == null) {
      paramInt = -1;
    }
    for (;;)
    {
      byte[] arrayOfByte1;
      try
      {
        if (this.r != null) {
          this.r.releaseOutputBuffer(i3, false);
        }
        AppMethodBeat.o(67382);
        return paramInt;
        arrayOfByte1 = new byte[localBufferInfo.size];
        localByteBuffer.position(localBufferInfo.offset);
        localByteBuffer.limit(localBufferInfo.offset + localBufferInfo.size);
        localByteBuffer.get(arrayOfByte1, 0, localBufferInfo.size);
        i1 = arrayOfByte1.length;
        if ((localBufferInfo.size <= 5) || (arrayOfByte1[0] != 0) || (arrayOfByte1[1] != 0) || (arrayOfByte1[2] != 0) || (arrayOfByte1[3] != 0) || (arrayOfByte1[4] != 0) || (arrayOfByte1[5] != 0)) {
          break label1177;
        }
        paramInt = 3;
        if (paramInt >= i1 - 4) {
          break label1168;
        }
        Object localObject1;
        if ((arrayOfByte1[paramInt] == 0) && (arrayOfByte1[(paramInt + 1)] == 0) && (arrayOfByte1[(paramInt + 2)] == 0) && (arrayOfByte1[(paramInt + 3)] == 1))
        {
          i2 = i1 - paramInt;
          i1 = paramInt;
          paramInt = i2;
          localObject1 = new byte[paramInt];
          System.arraycopy(arrayOfByte1, i1, localObject1, 0, paramInt);
          if (localBufferInfo.size != 0) {
            continue;
          }
          if ((localBufferInfo.flags & 0x4) != 0)
          {
            if (this.mListener != null) {
              this.mListener.a(null, 0);
            }
            paramInt = -2;
          }
        }
        else
        {
          paramInt += 1;
          continue;
        }
        paramInt = -1;
        continue;
        if ((localBufferInfo.flags & 0x2) == 2)
        {
          if (this.h)
          {
            this.D = ((byte[])((byte[])localObject1).clone());
            paramInt = 1;
            continue;
          }
          this.D = a((byte[])((byte[])localObject1).clone());
          continue;
        }
        long l3;
        if ((localBufferInfo.flags & 0x1) == 1)
        {
          this.I = -1;
          byte[] arrayOfByte2;
          if (this.h)
          {
            arrayOfByte2 = new byte[this.D.length + localObject1.length];
            System.arraycopy(this.D, 0, arrayOfByte2, 0, this.D.length);
            System.arraycopy(localObject1, 0, arrayOfByte2, this.D.length, localObject1.length);
            paramInt = 0;
            localObject1 = arrayOfByte2;
            if (!this.N)
            {
              i1 = this.I + 1;
              this.I = i1;
              if (i1 == this.g * this.J) {
                f();
              }
            }
            l2 = a();
            l1 = localBufferInfo.presentationTimeUs / 1000L;
            if (this.H == 0L) {
              this.H = l2;
            }
            if (this.G == 0L) {
              this.G = l1;
            }
            l3 = l1 + (this.H - this.G);
            l1 = l2;
            if (l2 <= this.n) {
              l1 = this.n + 1L;
            }
            l2 = l1;
            if (l1 > l3) {
              l2 = l3;
            }
            this.n = l2;
            l1 = TXCTimeUtil.getTimeTick();
            if (paramInt == 0)
            {
              if (l1 > this.e + 1000L)
              {
                this.c = ((this.p * 8000.0D / (l1 - this.e) / 1024.0D));
                this.p = 0L;
                this.e = l1;
              }
              this.k += 1L;
              if (this.k % 256L == 0L) {
                this.k += 1L;
              }
              this.l = 0L;
              this.p += localObject1.length;
              if (l1 > this.f + 2000L)
              {
                this.d = (this.q * 1000.0D / (l1 - this.f));
                this.q = 0L;
                this.f = l1;
              }
              this.q += 1L;
              localByteBuffer.position(localBufferInfo.offset);
              this.m += 1L;
              if (this.mListener != null) {
                this.mListener.a(2L, this.k, this.l);
              }
              if (!this.i) {
                continue;
              }
              l2 = this.k;
              l4 = this.l;
              l5 = this.m;
              if (paramInt != 0) {
                continue;
              }
              l1 = this.l;
              callDelegate((byte[])localObject1, paramInt, l2, l4, l5, l1, l3, l3, 0, localByteBuffer, localBufferInfo);
              this.R += 1;
              if ((localBufferInfo.flags & 0x4) == 0) {
                continue;
              }
              if (this.mListener != null) {
                this.mListener.a(null, 0);
              }
              paramInt = -2;
            }
          }
          else
          {
            arrayOfByte2 = a((byte[])localObject1);
            localObject1 = new byte[this.D.length + arrayOfByte2.length];
            System.arraycopy(this.D, 0, localObject1, 0, this.D.length);
            System.arraycopy(arrayOfByte2, 0, localObject1, this.D.length, arrayOfByte2.length);
            paramInt = 0;
            continue;
          }
        }
        else
        {
          if (this.h) {
            break label1163;
          }
          localObject1 = a((byte[])localObject1);
          paramInt = 1;
          continue;
        }
        this.l += 1L;
        continue;
        long l1 = this.l - 1L;
        continue;
        long l2 = this.k;
        long l4 = this.l;
        long l5 = this.m;
        if (paramInt == 0)
        {
          l1 = this.l;
          callDelegate(arrayOfByte1, paramInt, l2, l4, l5, l1, l3, l3, 0, localByteBuffer, localBufferInfo);
          continue;
        }
        l1 = this.l - 1L;
        continue;
      }
      catch (IllegalStateException localIllegalStateException2)
      {
        continue;
        paramInt = 1;
      }
      continue;
      label1163:
      paramInt = 1;
      continue;
      label1168:
      int i2 = 0;
      paramInt = i1;
      int i1 = i2;
      continue;
      label1177:
      Object localObject2 = arrayOfByte1;
    }
  }
  
  private int a(int paramInt1, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt3)
  {
    AppMethodBeat.i(67384);
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
        TXCLog.e(a, "setNalData exception");
        i1 = paramInt3;
      }
    }
    AppMethodBeat.o(67384);
    return i1;
  }
  
  private long a()
  {
    AppMethodBeat.i(67378);
    Long localLong = (Long)this.w.poll();
    if (localLong == null)
    {
      AppMethodBeat.o(67378);
      return 0L;
    }
    long l1 = localLong.longValue();
    AppMethodBeat.o(67378);
    return l1;
  }
  
  @TargetApi(16)
  private static MediaCodecInfo a(String paramString)
  {
    AppMethodBeat.i(67376);
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
            AppMethodBeat.o(67376);
            return localMediaCodecInfo;
          }
          i2 += 1;
        }
      }
      i1 += 1;
    }
    AppMethodBeat.o(67376);
    return null;
  }
  
  @TargetApi(16)
  private MediaFormat a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(67374);
    if ((paramInt1 == 0) || (paramInt2 == 0) || (paramInt3 == 0) || (paramInt4 == 0))
    {
      AppMethodBeat.o(67374);
      return null;
    }
    MediaFormat localMediaFormat = MediaFormat.createVideoFormat("video/avc", paramInt1, paramInt2);
    localMediaFormat.setInteger("bitrate", paramInt3 * 1024);
    localMediaFormat.setInteger("frame-rate", paramInt4);
    localMediaFormat.setInteger("color-format", 2130708361);
    localMediaFormat.setInteger("i-frame-interval", paramInt5);
    AppMethodBeat.o(67374);
    return localMediaFormat;
  }
  
  @TargetApi(16)
  private MediaFormat a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    AppMethodBeat.i(67375);
    MediaFormat localMediaFormat = a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    if (localMediaFormat == null)
    {
      AppMethodBeat.o(67375);
      return null;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      Object localObject = a("video/avc");
      if (localObject == null)
      {
        AppMethodBeat.o(67375);
        return localMediaFormat;
      }
      localObject = ((MediaCodecInfo)localObject).getCapabilitiesForType("video/avc");
      MediaCodecInfo.EncoderCapabilities localEncoderCapabilities = ((MediaCodecInfo.CodecCapabilities)localObject).getEncoderCapabilities();
      if (localEncoderCapabilities.isBitrateModeSupported(paramInt6)) {
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
        if (localEncoderCapabilities.isBitrateModeSupported(2)) {
          localMediaFormat.setInteger("bitrate-mode", 2);
        }
      }
    }
    AppMethodBeat.o(67375);
    return localMediaFormat;
  }
  
  private void a(long paramLong)
  {
    AppMethodBeat.i(67377);
    this.w.add(Long.valueOf(paramLong));
    AppMethodBeat.o(67377);
  }
  
  private boolean a(Surface paramSurface, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(67379);
    if (paramSurface == null)
    {
      AppMethodBeat.o(67379);
      return false;
    }
    TXCLog.d(a, "HWVideoEncode createGL");
    if ((this.mGLContextExternal != null) && ((this.mGLContextExternal instanceof android.opengl.EGLContext))) {}
    for (this.x = com.tencent.liteav.basic.d.c.a(null, (android.opengl.EGLContext)this.mGLContextExternal, paramSurface, paramInt1, paramInt2); this.x == null; this.x = com.tencent.liteav.basic.d.b.a(null, (javax.microedition.khronos.egl.EGLContext)this.mGLContextExternal, paramSurface, paramInt1, paramInt2))
    {
      AppMethodBeat.o(67379);
      return false;
    }
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    this.mEncodeFilter = new g();
    this.mEncodeFilter.a(k.e, k.a(j.a, false, false));
    if (!this.mEncodeFilter.a())
    {
      this.mEncodeFilter = null;
      AppMethodBeat.o(67379);
      return false;
    }
    GLES20.glViewport(0, 0, paramInt1, paramInt2);
    AppMethodBeat.o(67379);
    return true;
  }
  
  @TargetApi(18)
  private boolean a(TXSVideoEncoderParam paramTXSVideoEncoderParam)
  {
    AppMethodBeat.i(67381);
    this.A = false;
    this.z = false;
    this.c = 0L;
    this.d = 0.0D;
    this.e = 0L;
    this.f = 0L;
    this.g = 0;
    this.j = 0L;
    this.k = paramTXSVideoEncoderParam.baseGopIndex;
    this.l = 0L;
    this.m = paramTXSVideoEncoderParam.baseFrameIndex;
    this.n = 0L;
    this.p = 0L;
    this.q = 0L;
    this.C = null;
    this.D = null;
    this.E = 0L;
    this.I = -1;
    this.mOutputWidth = paramTXSVideoEncoderParam.width;
    this.mOutputHeight = paramTXSVideoEncoderParam.height;
    this.J = paramTXSVideoEncoderParam.gop;
    this.K = paramTXSVideoEncoderParam.fps;
    TXCLog.w(a, "FPS-TEST  HWEncode FPS start" + this.K);
    this.N = paramTXSVideoEncoderParam.fullIFrame;
    this.o = paramTXSVideoEncoderParam.syncOutput;
    this.B = paramTXSVideoEncoderParam.enableEGL14;
    this.w.clear();
    this.O = paramTXSVideoEncoderParam.bLimitFps;
    this.F = 0L;
    if ((paramTXSVideoEncoderParam == null) || (paramTXSVideoEncoderParam.width == 0) || (paramTXSVideoEncoderParam.height == 0) || (paramTXSVideoEncoderParam.fps == 0) || (paramTXSVideoEncoderParam.gop == 0))
    {
      this.z = true;
      AppMethodBeat.o(67381);
      return false;
    }
    this.h = paramTXSVideoEncoderParam.annexb;
    this.i = paramTXSVideoEncoderParam.appendSpsPps;
    if (this.b == 0) {
      this.b = ((int)(Math.sqrt(paramTXSVideoEncoderParam.width * paramTXSVideoEncoderParam.width * 1.0D + paramTXSVideoEncoderParam.height * paramTXSVideoEncoderParam.height) * 1.2D));
    }
    this.j = this.b;
    this.g = paramTXSVideoEncoderParam.fps;
    int i1 = 2;
    switch (paramTXSVideoEncoderParam.encoderMode)
    {
    }
    for (;;)
    {
      if (com.tencent.liteav.basic.e.b.a().c() == 1) {
        paramTXSVideoEncoderParam.encoderProfile = 1;
      }
      this.L = i1;
      this.M = 1;
      if (c()) {
        break;
      }
      AppMethodBeat.o(67381);
      return false;
      i1 = 2;
      continue;
      i1 = 1;
      continue;
      i1 = 0;
    }
    this.mInit = true;
    if (this.O)
    {
      this.S = -1;
      this.s.a(this.u, 1000 / this.K);
    }
    AppMethodBeat.o(67381);
    return true;
  }
  
  private byte[] a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(67383);
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
        AppMethodBeat.o(67383);
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
    AppMethodBeat.i(67380);
    TXCLog.d(a, "HWVideoEncode destroyGL");
    if (this.mEncodeFilter != null)
    {
      this.mEncodeFilter.d();
      this.mEncodeFilter = null;
    }
    if ((this.x instanceof com.tencent.liteav.basic.d.b))
    {
      ((com.tencent.liteav.basic.d.b)this.x).b();
      this.x = null;
    }
    if ((this.x instanceof com.tencent.liteav.basic.d.c))
    {
      ((com.tencent.liteav.basic.d.c)this.x).b();
      this.x = null;
    }
    AppMethodBeat.o(67380);
  }
  
  @TargetApi(18)
  private void b(int paramInt)
  {
    AppMethodBeat.i(67385);
    if ((this.z == true) || (this.x == null))
    {
      AppMethodBeat.o(67385);
      return;
    }
    int i3 = this.S;
    if (this.O)
    {
      this.S = -1;
      if (i3 == -1)
      {
        this.T = true;
        AppMethodBeat.o(67385);
        return;
      }
      this.s.a(this.u, 1000 / this.K);
    }
    a(this.E);
    Object localObject = com.tencent.liteav.basic.util.b.a(this.mInputWidth, this.mInputHeight, this.mOutputWidth, this.mOutputHeight);
    localObject = this.mEncodeFilter.a(this.mInputWidth, this.mInputHeight, null, (com.tencent.liteav.basic.d.a)localObject, 0);
    int i4 = (720 - this.mRotation) % 360;
    int i1;
    if ((i4 == 90) || (i4 == 270))
    {
      i1 = this.mOutputHeight;
      if ((i4 != 90) && (i4 != 270)) {
        break label341;
      }
    }
    label341:
    for (int i2 = this.mOutputWidth;; i2 = this.mOutputHeight)
    {
      this.mEncodeFilter.a(this.mInputWidth, this.mInputHeight, i4, (float[])localObject, i1 / i2, false, true);
      this.mEncodeFilter.a(i3);
      if ((this.x instanceof com.tencent.liteav.basic.d.c))
      {
        ((com.tencent.liteav.basic.d.c)this.x).a(this.E * 1000000L);
        ((com.tencent.liteav.basic.d.c)this.x).c();
      }
      if ((this.x instanceof com.tencent.liteav.basic.d.b)) {
        ((com.tencent.liteav.basic.d.b)this.x).a();
      }
      do
      {
        i1 = a(paramInt);
      } while (i1 > 0);
      if ((i1 != -1) && (i1 != -2)) {
        break label349;
      }
      if (i1 == -1) {
        callDelegate(10000005);
      }
      this.z = true;
      e();
      AppMethodBeat.o(67385);
      return;
      i1 = this.mOutputWidth;
      break;
    }
    label349:
    this.Q += 1;
    AppMethodBeat.o(67385);
  }
  
  private void c(int paramInt)
  {
    AppMethodBeat.i(67387);
    if (this.j == this.b)
    {
      AppMethodBeat.o(67387);
      return;
    }
    this.j = this.b;
    if ((Build.VERSION.SDK_INT >= 19) && (this.r != null))
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("video-bitrate", this.b * 1024);
      this.r.setParameters(localBundle);
    }
    AppMethodBeat.o(67387);
  }
  
  private boolean c()
  {
    AppMethodBeat.i(146309);
    for (;;)
    {
      try
      {
        MediaFormat localMediaFormat = a(this.mOutputWidth, this.mOutputHeight, this.b, this.K, this.J, this.L, this.M);
        if (localMediaFormat == null)
        {
          this.z = true;
          AppMethodBeat.o(146309);
          return false;
        }
        this.r = MediaCodec.createEncoderByType("video/avc");
        try
        {
          this.r.configure(localMediaFormat, null, null, 1);
          i1 = 3;
        }
        catch (Exception localException1)
        {
          try
          {
            this.y = this.r.createInputSurface();
            i1 = 4;
            this.r.start();
          }
          catch (Exception localException5)
          {
            continue;
          }
          try
          {
            this.C = this.r.getOutputBuffers();
            if ((this.r != null) && (this.C != null) && (this.y != null)) {
              continue;
            }
            this.z = true;
            AppMethodBeat.o(146309);
            return false;
          }
          catch (Exception localException6)
          {
            i1 = 5;
            continue;
          }
          localException1 = localException1;
          try
          {
            if ((!(localException1 instanceof IllegalArgumentException)) && ((Build.VERSION.SDK_INT < 21) || (!(localException1 instanceof MediaCodec.CodecException)))) {
              continue;
            }
            this.r.configure(a(this.mOutputWidth, this.mOutputHeight, this.b, this.K, this.J), null, null, 1);
          }
          catch (Exception localException2)
          {
            i1 = 2;
          }
        }
      }
      catch (Exception localException4)
      {
        i1 = 1;
        continue;
      }
      if (i1 >= 5) {}
      try
      {
        if (this.r != null) {
          this.r.stop();
        }
        this.r = null;
        if (this.y != null) {
          this.y.release();
        }
        this.y = null;
      }
      catch (Exception localException3) {}
    }
    AppMethodBeat.o(146309);
    throw localException3;
    if (!a(this.y, this.mOutputWidth, this.mOutputHeight))
    {
      this.z = true;
      AppMethodBeat.o(146309);
      return false;
    }
    AppMethodBeat.o(146309);
    return true;
  }
  
  /* Error */
  private void d()
  {
    // Byte code:
    //   0: ldc_w 738
    //   3: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 116	com/tencent/liteav/videoencoder/a:r	Landroid/media/MediaCodec;
    //   10: ifnonnull +10 -> 20
    //   13: ldc_w 738
    //   16: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: return
    //   20: aload_0
    //   21: getfield 116	com/tencent/liteav/videoencoder/a:r	Landroid/media/MediaCodec;
    //   24: invokevirtual 730	android/media/MediaCodec:stop	()V
    //   27: aload_0
    //   28: getfield 116	com/tencent/liteav/videoencoder/a:r	Landroid/media/MediaCodec;
    //   31: invokevirtual 739	android/media/MediaCodec:release	()V
    //   34: aload_0
    //   35: aconst_null
    //   36: putfield 116	com/tencent/liteav/videoencoder/a:r	Landroid/media/MediaCodec;
    //   39: ldc_w 738
    //   42: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   45: return
    //   46: astore_1
    //   47: aload_0
    //   48: getfield 116	com/tencent/liteav/videoencoder/a:r	Landroid/media/MediaCodec;
    //   51: invokevirtual 739	android/media/MediaCodec:release	()V
    //   54: goto -20 -> 34
    //   57: astore_1
    //   58: goto -24 -> 34
    //   61: astore_1
    //   62: aload_0
    //   63: getfield 116	com/tencent/liteav/videoencoder/a:r	Landroid/media/MediaCodec;
    //   66: invokevirtual 739	android/media/MediaCodec:release	()V
    //   69: ldc_w 738
    //   72: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   75: aload_1
    //   76: athrow
    //   77: astore_2
    //   78: goto -9 -> 69
    //   81: astore_1
    //   82: goto -48 -> 34
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	this	a
    //   46	1	1	localIllegalStateException	IllegalStateException
    //   57	1	1	localException1	Exception
    //   61	15	1	localObject	Object
    //   81	1	1	localException2	Exception
    //   77	1	2	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   20	27	46	java/lang/IllegalStateException
    //   47	54	57	java/lang/Exception
    //   20	27	61	finally
    //   62	69	77	java/lang/Exception
    //   27	34	81	java/lang/Exception
  }
  
  private void d(int paramInt)
  {
    AppMethodBeat.i(146312);
    if ((paramInt == 0) || (this.K == paramInt))
    {
      AppMethodBeat.o(146312);
      return;
    }
    TXCLog.w(a, "FPS-TEST  HWEncode FPS set".concat(String.valueOf(paramInt)));
    b();
    d();
    this.K = paramInt;
    c();
    AppMethodBeat.o(146312);
  }
  
  private void e()
  {
    AppMethodBeat.i(146310);
    if (!this.mInit)
    {
      AppMethodBeat.o(146310);
      return;
    }
    this.z = true;
    this.A = true;
    b();
    d();
    this.S = -1;
    this.c = 0L;
    this.d = 0.0D;
    this.e = 0L;
    this.f = 0L;
    this.g = 0;
    this.j = 0L;
    this.k = 0L;
    this.l = 0L;
    this.m = 0L;
    this.n = 0L;
    this.p = 0L;
    this.q = 0L;
    this.mGLContextExternal = null;
    this.C = null;
    this.D = null;
    this.E = 0L;
    this.mOutputWidth = 0;
    this.mOutputHeight = 0;
    this.mInit = false;
    this.mListener = null;
    this.w.clear();
    AppMethodBeat.o(146310);
  }
  
  private void f()
  {
    AppMethodBeat.i(146311);
    if ((Build.VERSION.SDK_INT >= 19) && (this.r != null))
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("request-sync", 0);
      this.r.setParameters(localBundle);
    }
    AppMethodBeat.o(146311);
  }
  
  public long getRealBitrate()
  {
    return this.c;
  }
  
  public double getRealFPS()
  {
    return this.d;
  }
  
  public long pushVideoFrame(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    AppMethodBeat.i(67371);
    if (this.A)
    {
      AppMethodBeat.o(67371);
      return 10000004L;
    }
    GLES20.glFinish();
    long l1 = TXCTimeUtil.getTimeTick();
    if (this.F == 0L) {
      this.F = (l1 - paramLong);
    }
    this.E = (l1 - this.F);
    this.S = paramInt1;
    this.P += 1;
    this.mInputWidth = paramInt2;
    this.mInputHeight = paramInt3;
    if (this.N) {
      f();
    }
    if ((!this.O) || (this.T))
    {
      this.s.b(this.u);
      this.T = false;
    }
    AppMethodBeat.o(67371);
    return 0L;
  }
  
  public long pushVideoFrameSync(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    AppMethodBeat.i(67372);
    if (this.A)
    {
      AppMethodBeat.o(67372);
      return 10000004L;
    }
    GLES20.glFinish();
    this.E = paramLong;
    this.S = paramInt1;
    this.P += 1;
    if (this.N) {
      f();
    }
    this.s.a(this.v);
    AppMethodBeat.o(67372);
    return 0L;
  }
  
  public void setBitrate(int paramInt)
  {
    AppMethodBeat.i(67370);
    this.b = paramInt;
    this.s.b(new a.4(this, paramInt));
    AppMethodBeat.o(67370);
  }
  
  public void setBitrateFromQos(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(146308);
    this.b = paramInt1;
    this.s.b(new a.5(this, paramInt1));
    AppMethodBeat.o(146308);
  }
  
  public void setEncodeIdrFpsFromQos(int paramInt) {}
  
  public void setFPS(int paramInt)
  {
    AppMethodBeat.i(67369);
    this.s.b(new a.3(this, paramInt));
    AppMethodBeat.o(67369);
  }
  
  public void signalEOSAndFlush()
  {
    AppMethodBeat.i(67373);
    if (this.A)
    {
      AppMethodBeat.o(67373);
      return;
    }
    this.s.a(new a.6(this));
    AppMethodBeat.o(67373);
  }
  
  public int start(TXSVideoEncoderParam paramTXSVideoEncoderParam)
  {
    AppMethodBeat.i(67367);
    super.start(paramTXSVideoEncoderParam);
    boolean[] arrayOfBoolean = new boolean[1];
    if (Build.VERSION.SDK_INT < 18) {
      arrayOfBoolean[0] = false;
    }
    for (;;)
    {
      if (arrayOfBoolean[0] == 0) {
        callDelegate(10000004);
      }
      if (arrayOfBoolean[0] != 0)
      {
        AppMethodBeat.o(67367);
        return 0;
        try
        {
          this.s.a(new a.1(this, arrayOfBoolean, paramTXSVideoEncoderParam));
        }
        finally
        {
          AppMethodBeat.o(67367);
        }
      }
    }
    AppMethodBeat.o(67367);
    return 10000004;
  }
  
  public void stop()
  {
    AppMethodBeat.i(67368);
    this.A = true;
    try
    {
      this.s.a(new a.2(this));
      return;
    }
    finally
    {
      AppMethodBeat.o(67368);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.liteav.videoencoder.a
 * JD-Core Version:    0.7.0.1
 */