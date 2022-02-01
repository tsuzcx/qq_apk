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
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.util.Range;
import android.view.Surface;
import com.tencent.liteav.basic.d.h;
import com.tencent.liteav.basic.d.k;
import com.tencent.liteav.basic.d.l;
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
import org.json.JSONArray;
import org.json.JSONObject;

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
          break label1291;
        }
        paramInt = 3;
        for (;;)
        {
          if (paramInt >= i1 - 4) {
            break label1282;
          }
          if ((arrayOfByte[paramInt] == 0) && (arrayOfByte[(paramInt + 1)] == 0) && (arrayOfByte[(paramInt + 2)] == 0) && (arrayOfByte[(paramInt + 3)] == 1))
          {
            i2 = i1 - paramInt;
            i1 = paramInt;
            paramInt = i2;
            localObject1 = new byte[paramInt];
            System.arraycopy(arrayOfByte, i1, localObject1, 0, paramInt);
            if (localBufferInfo.size != 0) {
              break label409;
            }
            if ((localBufferInfo.flags & 0x4) == 0) {
              break label404;
            }
            if (this.mListener != null) {
              this.mListener.a(null, 0);
            }
            paramInt = -2;
            break;
          }
          paramInt += 1;
        }
        label404:
        paramInt = -1;
      }
      label409:
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
            break label974;
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
      label974:
      for (this.k = 0L;; this.k += 1L)
      {
        this.o += localObject1.length;
        if (l1 <= this.e + 2000L) {
          break label1005;
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
            break label1274;
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
          break label1277;
        }
        localObject1 = a((byte[])localObject1);
        paramInt = 1;
        break;
      }
      this.W.clear();
      this.X = ((int)(3L * l1));
      label1005:
      this.p += 1L;
      localByteBuffer.position(localBufferInfo.offset);
      this.l += 1L;
      if (this.mListener != null) {
        this.mListener.a(2L, this.j, this.k);
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
            break label1269;
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
        continue;
        label1269:
        paramInt = 1;
        continue;
        label1274:
        continue;
        label1277:
        paramInt = 1;
        continue;
        label1282:
        int i2 = 0;
        paramInt = i1;
        int i1 = i2;
        continue;
        label1291:
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
        } else if (localEncoderCapabilities.isBitrateModeSupported(2)) {
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
    TXCLog.i("TXCHWVideoEncoder", "HWVideoEncode createGL");
    if ((this.mGLContextExternal != null) && ((this.mGLContextExternal instanceof android.opengl.EGLContext))) {}
    for (this.w = com.tencent.liteav.basic.d.c.a(null, (android.opengl.EGLContext)this.mGLContextExternal, paramSurface, paramInt1, paramInt2); this.w == null; this.w = com.tencent.liteav.basic.d.b.a(null, (javax.microedition.khronos.egl.EGLContext)this.mGLContextExternal, paramSurface, paramInt1, paramInt2))
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
      if (com.tencent.liteav.basic.e.b.a().c() == 1) {
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
    if ((this.w instanceof com.tencent.liteav.basic.d.b))
    {
      ((com.tencent.liteav.basic.d.b)this.w).c();
      this.w = null;
    }
    if ((this.w instanceof com.tencent.liteav.basic.d.c))
    {
      ((com.tencent.liteav.basic.d.c)this.w).c();
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
        break label308;
      }
    }
    label308:
    for (int i2 = this.mOutputWidth;; i2 = this.mOutputHeight)
    {
      this.mEncodeFilter.a(this.mInputWidth, this.mInputHeight, i4, null, i1 / i2, false, true);
      this.mEncodeFilter.a(i3);
      if ((this.w instanceof com.tencent.liteav.basic.d.c))
      {
        ((com.tencent.liteav.basic.d.c)this.w).a(this.D * 1000000L);
        ((com.tencent.liteav.basic.d.c)this.w).d();
      }
      if ((this.w instanceof com.tencent.liteav.basic.d.b)) {
        ((com.tencent.liteav.basic.d.b)this.w).a();
      }
      do
      {
        i1 = a(paramInt);
      } while (i1 > 0);
      if ((i1 != -1) && (i1 != -2)) {
        break label316;
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
    label316:
    this.O += 1;
    AppMethodBeat.o(14880);
  }
  
  private void c(int paramInt)
  {
    AppMethodBeat.i(14884);
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
        break label286;
      }
      if (paramInt == 0) {
        break label252;
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
    label252:
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("video-bitrate", this.a * 1024);
    this.q.setParameters((Bundle)localObject);
    label286:
    AppMethodBeat.o(14884);
  }
  
  private boolean c()
  {
    AppMethodBeat.i(182432);
    if (Build.VERSION.SDK_INT < 18)
    {
      AppMethodBeat.o(182432);
      return false;
    }
    boolean bool;
    if (com.tencent.liteav.basic.e.b.a().a("Video", "CheckVideoEncDownBps") > 0L)
    {
      bool = true;
      this.ac = bool;
      this.O = 0;
      this.P = 0;
      this.R = 0L;
      this.S = 0;
      this.Q = 0;
      this.T = 0;
    }
    for (;;)
    {
      try
      {
        MediaFormat localMediaFormat1 = a(this.mOutputWidth, this.mOutputHeight, this.a, this.I, this.H, this.J, this.K, this.N);
        if (localMediaFormat1 == null)
        {
          this.y = true;
          AppMethodBeat.o(182432);
          return false;
          bool = false;
          break;
        }
        this.q = MediaCodec.createEncoderByType("video/avc");
        try
        {
          Object localObject = this.mEncFmt;
          if (localObject != null)
          {
            i1 = 0;
            try
            {
              if (i1 < this.mEncFmt.length())
              {
                localObject = this.mEncFmt.getJSONObject(i1);
                localMediaFormat1.setInteger(((JSONObject)localObject).optString("key"), ((JSONObject)localObject).optInt("value"));
                i1 += 1;
                continue;
              }
              try
              {
                this.q.configure(localMediaFormat1, null, null, 1);
                TXCLog.i("TXCHWVideoEncoder", "configure format =  " + localMediaFormat1.toString());
                i1 = 3;
                localMediaFormat2 = a(this.mOutputWidth, this.mOutputHeight, this.a, this.I, this.H, this.J, this.K, false);
              }
              catch (Exception localException1)
              {
                try
                {
                  this.x = this.q.createInputSurface();
                  i1 = 4;
                  this.q.start();
                }
                catch (Exception localException6)
                {
                  MediaFormat localMediaFormat3;
                  MediaFormat localMediaFormat4;
                  continue;
                }
                try
                {
                  this.B = this.q.getOutputBuffers();
                  if ((this.q != null) && (this.B != null) && (this.x != null)) {
                    continue;
                  }
                  this.y = true;
                  AppMethodBeat.o(182432);
                  return false;
                }
                catch (Exception localException7)
                {
                  i1 = 5;
                  continue;
                }
                localException1 = localException1;
                if (!this.N) {
                  continue;
                }
              }
            }
            catch (Exception localException8)
            {
              TXCLog.w("TXCHWVideoEncoder", "config custom format error " + localException8.toString());
            }
          }
          else
          {
            try
            {
              MediaFormat localMediaFormat2;
              this.q.configure(localMediaFormat2, null, null, 1);
            }
            catch (Exception localException2) {}
            if ((!(localException2 instanceof IllegalArgumentException)) && ((Build.VERSION.SDK_INT < 21) || (!(localException2 instanceof MediaCodec.CodecException)))) {
              continue;
            }
            localMediaFormat3 = a(this.mOutputWidth, this.mOutputHeight, this.a, this.I, this.H);
            this.q.configure(localMediaFormat3, null, null, 1);
            continue;
          }
          if (i1 < 5) {}
        }
        catch (Exception localException3)
        {
          i1 = 2;
        }
      }
      catch (Exception localException5)
      {
        i1 = 1;
        continue;
      }
      try
      {
        if (this.q != null) {
          this.q.stop();
        }
        this.q = null;
        if (this.x != null) {
          this.x.release();
        }
        this.x = null;
      }
      catch (Exception localException4) {}
      continue;
      if ((!(localException4 instanceof IllegalArgumentException)) && ((Build.VERSION.SDK_INT < 21) || (!(localException4 instanceof MediaCodec.CodecException)))) {
        continue;
      }
      localMediaFormat4 = a(this.mOutputWidth, this.mOutputHeight, this.a, this.I, this.H);
      this.q.configure(localMediaFormat4, null, null, 1);
    }
    AppMethodBeat.o(182432);
    throw localMediaFormat4;
    if (!a(this.x, this.mOutputWidth, this.mOutputHeight))
    {
      this.y = true;
      AppMethodBeat.o(182432);
      return false;
    }
    AppMethodBeat.o(182432);
    return true;
  }
  
  /* Error */
  private void d()
  {
    // Byte code:
    //   0: ldc_w 876
    //   3: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 135	com/tencent/liteav/videoencoder/a:q	Landroid/media/MediaCodec;
    //   10: ifnonnull +10 -> 20
    //   13: ldc_w 876
    //   16: invokestatic 218	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: return
    //   20: aload_0
    //   21: getfield 135	com/tencent/liteav/videoencoder/a:q	Landroid/media/MediaCodec;
    //   24: invokevirtual 867	android/media/MediaCodec:stop	()V
    //   27: aload_0
    //   28: getfield 135	com/tencent/liteav/videoencoder/a:q	Landroid/media/MediaCodec;
    //   31: invokevirtual 877	android/media/MediaCodec:release	()V
    //   34: aload_0
    //   35: getfield 156	com/tencent/liteav/videoencoder/a:x	Landroid/view/Surface;
    //   38: ifnull +10 -> 48
    //   41: aload_0
    //   42: getfield 156	com/tencent/liteav/videoencoder/a:x	Landroid/view/Surface;
    //   45: invokevirtual 872	android/view/Surface:release	()V
    //   48: aload_0
    //   49: aconst_null
    //   50: putfield 156	com/tencent/liteav/videoencoder/a:x	Landroid/view/Surface;
    //   53: aload_0
    //   54: aconst_null
    //   55: putfield 135	com/tencent/liteav/videoencoder/a:q	Landroid/media/MediaCodec;
    //   58: ldc_w 876
    //   61: invokestatic 218	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   64: return
    //   65: astore_1
    //   66: aload_0
    //   67: getfield 135	com/tencent/liteav/videoencoder/a:q	Landroid/media/MediaCodec;
    //   70: invokevirtual 877	android/media/MediaCodec:release	()V
    //   73: aload_0
    //   74: getfield 156	com/tencent/liteav/videoencoder/a:x	Landroid/view/Surface;
    //   77: ifnull +10 -> 87
    //   80: aload_0
    //   81: getfield 156	com/tencent/liteav/videoencoder/a:x	Landroid/view/Surface;
    //   84: invokevirtual 872	android/view/Surface:release	()V
    //   87: aload_0
    //   88: aconst_null
    //   89: putfield 156	com/tencent/liteav/videoencoder/a:x	Landroid/view/Surface;
    //   92: goto -39 -> 53
    //   95: astore_1
    //   96: goto -43 -> 53
    //   99: astore_1
    //   100: aload_0
    //   101: getfield 135	com/tencent/liteav/videoencoder/a:q	Landroid/media/MediaCodec;
    //   104: invokevirtual 877	android/media/MediaCodec:release	()V
    //   107: aload_0
    //   108: getfield 156	com/tencent/liteav/videoencoder/a:x	Landroid/view/Surface;
    //   111: ifnull +10 -> 121
    //   114: aload_0
    //   115: getfield 156	com/tencent/liteav/videoencoder/a:x	Landroid/view/Surface;
    //   118: invokevirtual 872	android/view/Surface:release	()V
    //   121: aload_0
    //   122: aconst_null
    //   123: putfield 156	com/tencent/liteav/videoencoder/a:x	Landroid/view/Surface;
    //   126: ldc_w 876
    //   129: invokestatic 218	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   132: aload_1
    //   133: athrow
    //   134: astore_2
    //   135: goto -9 -> 126
    //   138: astore_1
    //   139: goto -86 -> 53
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	142	0	this	a
    //   65	1	1	localIllegalStateException	IllegalStateException
    //   95	1	1	localException1	Exception
    //   99	34	1	localObject	Object
    //   138	1	1	localException2	Exception
    //   134	1	2	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   20	27	65	java/lang/IllegalStateException
    //   66	87	95	java/lang/Exception
    //   87	92	95	java/lang/Exception
    //   20	27	99	finally
    //   100	121	134	java/lang/Exception
    //   121	126	134	java/lang/Exception
    //   27	48	138	java/lang/Exception
    //   48	53	138	java/lang/Exception
  }
  
  private void d(int paramInt)
  {
    AppMethodBeat.i(14886);
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
        break label288;
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
          break label281;
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
        label281:
        l1 = l2;
      }
      label288:
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
        this.mListener.a(this.mStreamType);
      }
    }
    if (this.R + 5000L < System.currentTimeMillis())
    {
      this.R = System.currentTimeMillis();
      if ((this.S != 0) && (this.S == this.O))
      {
        TXCLog.i("TXCHWVideoEncoder", String.format("hw encoder error when push[%d] render task[%d] render[%d] pop[%d]", new Object[] { Integer.valueOf(this.Q), Integer.valueOf(this.T), Integer.valueOf(this.O), Integer.valueOf(this.P) }));
        if (this.mListener != null) {
          this.mListener.a(this.mStreamType);
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
            break label338;
          }
        }
        label338:
        for (int j = a.this.mOutputWidth;; j = a.this.mOutputHeight)
        {
          a.this.mEncodeFilter.a(a.this.mInputWidth, a.this.mInputHeight, m, null, i / j, false, true);
          a.this.mEncodeFilter.a(k);
          if ((a.c(a.this) instanceof com.tencent.liteav.basic.d.c))
          {
            ((com.tencent.liteav.basic.d.c)a.c(a.this)).a(1000000L * l);
            ((com.tencent.liteav.basic.d.c)a.c(a.this)).d();
          }
          if ((a.c(a.this) instanceof com.tencent.liteav.basic.d.b)) {
            ((com.tencent.liteav.basic.d.b)a.c(a.this)).a();
          }
          if (a.this.mListener != null) {
            a.this.mListener.a(a.this.mStreamType);
          }
          do
          {
            i = a.c(a.this, 1);
          } while (i > 0);
          if ((i != -1) && (i != -2)) {
            break label349;
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
        label349:
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
          label33:
          while (a.c(a.this, 10) >= 0) {}
          a.a(a.this);
          AppMethodBeat.o(14788);
          return;
        }
        catch (Exception localException)
        {
          break label33;
        }
      }
    });
    AppMethodBeat.o(14868);
  }
  
  public int start(final TXSVideoEncoderParam paramTXSVideoEncoderParam)
  {
    AppMethodBeat.i(14860);
    super.start(paramTXSVideoEncoderParam);
    final boolean[] arrayOfBoolean = new boolean[1];
    if (Build.VERSION.SDK_INT < 18) {
      arrayOfBoolean[0] = false;
    }
    for (;;)
    {
      if (arrayOfBoolean[0] != 0) {
        Monitor.a(2, String.format("VideoEncoder[%d]: Start successfully, streamType:%d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramTXSVideoEncoderParam.streamType) }), "streamType: 2-big, 3-small, 7-sub", 0);
      }
      if (arrayOfBoolean[0] == 0) {
        callDelegate(10000004);
      }
      if (arrayOfBoolean[0] != 0)
      {
        AppMethodBeat.o(14860);
        return 0;
        try
        {
          this.r.a(new Runnable()
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
                arrayOfBoolean[0] = a.a(a.this, paramTXSVideoEncoderParam);
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
            }
          });
        }
        finally
        {
          AppMethodBeat.o(14860);
        }
      }
    }
    AppMethodBeat.o(14860);
    return 10000004;
  }
  
  public void stop()
  {
    AppMethodBeat.i(14861);
    this.z = true;
    try
    {
      this.r.a(new Runnable()
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
      return;
    }
    finally
    {
      AppMethodBeat.o(14861);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.videoencoder.a
 * JD-Core Version:    0.7.0.1
 */