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
import android.os.Process;
import android.util.Range;
import android.view.Surface;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.Monitor;
import com.tencent.liteav.basic.opengl.b;
import com.tencent.liteav.basic.opengl.j;
import com.tencent.liteav.basic.opengl.l;
import com.tencent.liteav.basic.opengl.m;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.basic.util.g;
import com.tencent.liteav.basic.util.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

public class a
  extends d
{
  private Surface A;
  private boolean B;
  private boolean C;
  private boolean D;
  private ByteBuffer[] E;
  private byte[] F;
  private volatile long G;
  private long H;
  private long I;
  private int J;
  private int K;
  private int L;
  private int M;
  private int N;
  private boolean O;
  private boolean P;
  private boolean Q;
  private boolean R;
  private int S;
  private int T;
  private int U;
  private long V;
  private int W;
  private int X;
  private int Y;
  private j Z;
  private int a;
  private final Object aa;
  private boolean ab;
  private ArrayList<Long> ac;
  private int ad;
  private boolean ae;
  private long af;
  private int ag;
  private int ah;
  private boolean ai;
  private boolean aj;
  private long ak;
  private Runnable al;
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
  private long n;
  private boolean o;
  private boolean p;
  private long q;
  private long r;
  private MediaCodec s;
  private String t;
  private i u;
  private Runnable v;
  private Runnable w;
  private Runnable x;
  private ArrayDeque<Long> y;
  private Object z;
  
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
    this.n = 0L;
    this.q = 0L;
    this.r = 0L;
    this.s = null;
    this.t = "video/avc";
    this.u = null;
    this.v = new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(229070);
        a.a(a.this);
        AppMethodBeat.o(229070);
      }
    };
    this.w = new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(14789);
        a.d(a.this, 10);
        AppMethodBeat.o(14789);
      }
    };
    this.x = new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(14822);
        a.d(a.this, 1);
        AppMethodBeat.o(14822);
      }
    };
    this.y = new ArrayDeque(10);
    this.A = null;
    this.B = true;
    this.C = true;
    this.D = false;
    this.E = null;
    this.F = null;
    this.G = 0L;
    this.H = 0L;
    this.I = 0L;
    this.P = true;
    this.Q = false;
    this.R = false;
    this.S = 0;
    this.T = 0;
    this.U = 0;
    this.V = 0L;
    this.W = 0;
    this.X = 0;
    this.Y = -1;
    this.aa = new Object();
    this.ab = false;
    this.ad = 0;
    this.ae = true;
    this.af = 0L;
    this.ag = 3;
    this.ah = 0;
    this.ai = false;
    this.aj = true;
    this.ak = 0L;
    this.al = new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(14857);
        a.b(a.this, System.currentTimeMillis());
        a.f(a.this);
        a.g(a.this);
        a.h(a.this);
        AppMethodBeat.o(14857);
      }
    };
    this.u = new i("HWVideoEncoder");
    AppMethodBeat.o(14859);
  }
  
  private int a(int paramInt)
  {
    AppMethodBeat.i(14877);
    if (this.s == null)
    {
      AppMethodBeat.o(14877);
      return -1;
    }
    MediaCodec.BufferInfo localBufferInfo = new MediaCodec.BufferInfo();
    int i3;
    try
    {
      i3 = this.s.dequeueOutputBuffer(localBufferInfo, paramInt * 1000);
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
      this.E = this.s.getOutputBuffers();
      AppMethodBeat.o(14877);
      return 1;
    }
    if (i3 == -2) {
      try
      {
        callDelegate(this.s.getOutputFormat());
        AppMethodBeat.o(14877);
        return 1;
      }
      catch (IllegalStateException localIllegalStateException2)
      {
        TXCLog.e("TXCHWVideoEncoder", "mediacodec getOutputFormat failed.".concat(String.valueOf(localIllegalStateException2)));
        AppMethodBeat.o(14877);
        return -1;
      }
    }
    if (i3 < 0)
    {
      AppMethodBeat.o(14877);
      return -1;
    }
    long l4 = TXCTimeUtil.getTimeTick();
    ByteBuffer localByteBuffer = this.E[i3];
    if (localByteBuffer == null) {
      paramInt = -1;
    }
    try
    {
      Object localObject1;
      label458:
      label463:
      long l1;
      label809:
      long l3;
      for (;;)
      {
        if (this.s != null) {
          this.s.releaseOutputBuffer(i3, false);
        }
        AppMethodBeat.o(14877);
        return paramInt;
        arrayOfByte = new byte[localBufferInfo.size];
        localByteBuffer.position(localBufferInfo.offset);
        localByteBuffer.limit(localBufferInfo.offset + localBufferInfo.size);
        localByteBuffer.get(arrayOfByte, 0, localBufferInfo.size);
        i1 = arrayOfByte.length;
        if ((localBufferInfo.size <= 5) || (arrayOfByte[0] != 0) || (arrayOfByte[1] != 0) || (arrayOfByte[2] != 0) || (arrayOfByte[3] != 0) || (arrayOfByte[4] != 0) || (arrayOfByte[5] != 0)) {
          break label1686;
        }
        paramInt = 3;
        for (;;)
        {
          if (paramInt >= i1 - 4) {
            break label1677;
          }
          if ((arrayOfByte[paramInt] == 0) && (arrayOfByte[(paramInt + 1)] == 0) && (arrayOfByte[(paramInt + 2)] == 0) && (arrayOfByte[(paramInt + 3)] == 1))
          {
            i2 = i1 - paramInt;
            i1 = paramInt;
            paramInt = i2;
            localObject1 = new byte[paramInt];
            System.arraycopy(arrayOfByte, i1, localObject1, 0, paramInt);
            if (localBufferInfo.size != 0) {
              break label463;
            }
            if ((localBufferInfo.flags & 0x4) == 0) {
              break label458;
            }
            if (this.mListener != null) {
              this.mListener.a(null, 0);
            }
            paramInt = -2;
            break;
          }
          paramInt += 1;
        }
        paramInt = -1;
        continue;
        if ((localBufferInfo.flags & 0x2) == 2)
        {
          if (this.g) {}
          for (this.F = ((byte[])((byte[])localObject1).clone());; this.F = a((byte[])((byte[])localObject1).clone()))
          {
            paramInt = 1;
            break;
          }
        }
        Object localObject4;
        if ((localBufferInfo.flags & 0x1) == 1)
        {
          this.J = -1;
          if (this.g)
          {
            localObject3 = new byte[this.F.length + localObject1.length];
            System.arraycopy(this.F, 0, localObject3, 0, this.F.length);
            System.arraycopy(localObject1, 0, localObject3, this.F.length, localObject1.length);
            paramInt = 0;
            localObject1 = localObject3;
            if (!this.O)
            {
              i1 = this.J + 1;
              this.J = i1;
              if (i1 == this.f * this.K) {
                f();
              }
            }
            l1 = a();
            long l2 = localBufferInfo.presentationTimeUs / 1000L;
            if ((l2 < this.n) && (!this.o))
            {
              this.o = true;
              localObject4 = "[Encoder] pts error, maybe have b frames. profile:" + this.N + " device:" + TXCCommonUtil.getDeviceInfo() + " last pts:" + this.n + " current pts:" + l2;
              localObject3 = localObject4;
              if (this.R) {
                localObject3 = (String)localObject4 + " hevc";
              }
              TXCLog.e("TXCHWVideoEncoder", (String)localObject3);
              Monitor.a(2, (String)localObject3, "", 0);
              if (!this.R) {
                break label1195;
              }
              g.a().a("enable_hw_hevc_encode", false);
              callDelegate(10000006);
              TXCLog.i("TXCHWVideoEncoder", "[Encoder] hevc Got BFrame ,post ErrorCode_EncodeGotBFrame callback.");
            }
            this.n = l2;
            if (this.I == 0L) {
              this.I = l1;
            }
            if (this.H == 0L) {
              this.H = l2;
            }
            l3 = l2 + (this.I - this.H);
            if (l1 > this.m) {
              break label1669;
            }
            l1 = this.m + 1L;
            l2 = l1;
            if (l1 > l3) {
              l2 = l3;
            }
            this.m = l2;
            l1 = TXCTimeUtil.getTimeTick();
            if (paramInt != 0) {
              break label1257;
            }
            if (l1 > this.d + 1000L)
            {
              this.b = ((this.q * 8000.0D / (l1 - this.d) / 1024.0D));
              this.q = 0L;
              this.d = l1;
              g();
            }
            this.j += 1L;
            if (this.j % 256L == 0L) {
              this.j += 1L;
            }
          }
        }
        label1195:
        label1257:
        for (this.k = 0L;; this.k += 1L)
        {
          this.q += localObject1.length;
          if (l1 <= this.e + 2000L) {
            break label1288;
          }
          this.c = (this.r * 1000.0D / (l1 - this.e));
          this.r = 0L;
          this.e = l1;
          l1 = 0L;
          localObject3 = this.ac.iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (Long)((Iterator)localObject3).next();
            if (((Long)localObject4).longValue() <= l1) {
              break label1666;
            }
            l1 = ((Long)localObject4).longValue();
          }
          localObject3 = a((byte[])localObject1);
          localObject1 = new byte[this.F.length + localObject3.length];
          System.arraycopy(this.F, 0, localObject1, 0, this.F.length);
          System.arraycopy(localObject3, 0, localObject1, this.F.length, localObject3.length);
          paramInt = 0;
          break;
          if (this.g) {
            break label1672;
          }
          localObject1 = a((byte[])localObject1);
          paramInt = 1;
          break;
          if (this.N != 1)
          {
            this.N = 1;
            TXCLog.e("TXCHWVideoEncoder", "[Encoder] force reset profile to baseline when recv b frame.");
          }
          g.a().a("enable_high_profile", false);
          TXCLog.i("TXCHWVideoEncoder", "[Encoder] post restart encoder task.");
          if (this.u == null) {
            break label809;
          }
          this.u.b(this.al);
          break label809;
        }
        this.ac.clear();
        this.ad = ((int)(3L * l1));
        label1288:
        this.r += 1L;
        localByteBuffer.position(localBufferInfo.offset);
        this.l += 1L;
        if (this.mListener != null) {
          this.mListener.a(2, this.j, this.k);
        }
        if (!this.o) {
          break;
        }
        TXCLog.w("TXCHWVideoEncoder", "[Encoder] drop all frame when find b frame.");
        this.T += 1;
        if ((localBufferInfo.flags & 0x4) == 0) {
          break label1661;
        }
        if (this.mListener != null) {
          this.mListener.a(null, 0);
        }
        paramInt = -2;
        l1 = TXCTimeUtil.getTimeTick();
        this.ac.add(Long.valueOf(l1 - l4));
      }
      Object localObject3 = new TXSNALPacket();
      if (this.h)
      {
        ((TXSNALPacket)localObject3).nalData = ((byte[])localObject1);
        label1448:
        ((TXSNALPacket)localObject3).nalType = paramInt;
        ((TXSNALPacket)localObject3).gopIndex = this.j;
        ((TXSNALPacket)localObject3).gopFrameIndex = this.k;
        ((TXSNALPacket)localObject3).frameIndex = this.l;
        if (paramInt != 0) {
          break label1607;
        }
        l1 = this.k;
        label1491:
        ((TXSNALPacket)localObject3).refFremeIndex = l1;
        ((TXSNALPacket)localObject3).pts = l3;
        ((TXSNALPacket)localObject3).dts = l3;
        if (localByteBuffer == null) {
          break label1618;
        }
        localObject1 = localByteBuffer.asReadOnlyBuffer();
        label1524:
        ((TXSNALPacket)localObject3).buffer = ((ByteBuffer)localObject1);
        if (!this.R) {
          break label1624;
        }
      }
      label1607:
      label1618:
      label1624:
      for (paramInt = 1;; paramInt = 0)
      {
        ((TXSNALPacket)localObject3).codecId = paramInt;
        localObject1 = new MediaCodec.BufferInfo();
        ((MediaCodec.BufferInfo)localObject1).set(localBufferInfo.offset, localBufferInfo.size, localBufferInfo.presentationTimeUs, localBufferInfo.flags);
        ((TXSNALPacket)localObject3).info = ((MediaCodec.BufferInfo)localObject1);
        callDelegate((TXSNALPacket)localObject3, 0);
        break;
        ((TXSNALPacket)localObject3).nalData = arrayOfByte;
        break label1448;
        l1 = this.k - 1L;
        break label1491;
        localObject1 = null;
        break label1524;
      }
    }
    catch (IllegalStateException localIllegalStateException3)
    {
      for (;;)
      {
        byte[] arrayOfByte;
        TXCLog.e("TXCHWVideoEncoder", "releaseOutputBuffer failed." + localIllegalStateException3.getMessage());
        continue;
        label1661:
        paramInt = 1;
        continue;
        label1666:
        continue;
        label1669:
        continue;
        label1672:
        paramInt = 1;
        continue;
        label1677:
        int i2 = 0;
        paramInt = i1;
        int i1 = i2;
        continue;
        label1686:
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
    Long localLong = (Long)this.y.poll();
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
    MediaFormat localMediaFormat = MediaFormat.createVideoFormat(this.t, paramInt1, paramInt2);
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
      Object localObject = a(this.t);
      if (localObject == null)
      {
        AppMethodBeat.o(14870);
        return localMediaFormat;
      }
      localObject = ((MediaCodecInfo)localObject).getCapabilitiesForType(this.t);
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
        } else if (this.O)
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
  
  private void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(229954);
    TXCLog.i("TXCHWVideoEncoder", "createCopyTexture");
    synchronized (this.aa)
    {
      this.Z = new j();
      this.Z.a(true);
      this.Z.a();
      this.Z.a(paramInt1, paramInt2);
      AppMethodBeat.o(229954);
      return;
    }
  }
  
  private void a(long paramLong)
  {
    AppMethodBeat.i(14872);
    this.y.add(Long.valueOf(paramLong));
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
    for (this.z = com.tencent.liteav.basic.opengl.c.a(null, (android.opengl.EGLContext)this.mGLContextExternal, paramSurface, paramInt1, paramInt2); this.z == null; this.z = b.a(null, (javax.microedition.khronos.egl.EGLContext)this.mGLContextExternal, paramSurface, paramInt1, paramInt2))
    {
      AppMethodBeat.o(14874);
      return false;
    }
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    this.mEncodeFilter = new j();
    this.mEncodeFilter.a(m.e, m.a(l.a, false, false));
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
    int i2 = 2;
    AppMethodBeat.i(14876);
    this.C = false;
    this.B = false;
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
    this.n = 0L;
    this.q = 0L;
    this.r = 0L;
    this.E = null;
    this.F = null;
    this.G = 0L;
    this.J = -1;
    this.mOutputWidth = paramTXSVideoEncoderParam.width;
    this.mOutputHeight = paramTXSVideoEncoderParam.height;
    this.K = paramTXSVideoEncoderParam.gop;
    this.L = paramTXSVideoEncoderParam.fps;
    TXCLog.i("TXCHWVideoEncoder", "init with fps " + this.L);
    this.O = paramTXSVideoEncoderParam.fullIFrame;
    this.p = paramTXSVideoEncoderParam.syncOutput;
    this.D = paramTXSVideoEncoderParam.enableEGL14;
    this.Q = paramTXSVideoEncoderParam.forceSetBitrateMode;
    this.y.clear();
    this.P = paramTXSVideoEncoderParam.bLimitFps;
    if ((paramTXSVideoEncoderParam == null) || (paramTXSVideoEncoderParam.width == 0) || (paramTXSVideoEncoderParam.height == 0) || (paramTXSVideoEncoderParam.fps == 0) || (paramTXSVideoEncoderParam.gop == 0))
    {
      this.B = true;
      AppMethodBeat.o(14876);
      return false;
    }
    this.R = paramTXSVideoEncoderParam.isH265EncoderEnabled;
    this.g = paramTXSVideoEncoderParam.annexb;
    this.h = paramTXSVideoEncoderParam.appendSpsPps;
    if (this.a == 0) {
      this.a = ((int)(Math.sqrt(paramTXSVideoEncoderParam.width * paramTXSVideoEncoderParam.width * 1.0D + paramTXSVideoEncoderParam.height * paramTXSVideoEncoderParam.height) * 1.2D));
    }
    this.i = this.a;
    this.f = paramTXSVideoEncoderParam.fps;
    int i1;
    switch (paramTXSVideoEncoderParam.encoderMode)
    {
    default: 
      i1 = 2;
      TXCLog.i("TXCHWVideoEncoder", "[Encoder] HWEncValue: " + com.tencent.liteav.basic.d.c.a().d());
      if (paramTXSVideoEncoderParam.encoderProfile == 2)
      {
        TXCLog.w("TXCHWVideoEncoder", "[Encoder] force reset profile to high. android is't support main profile.");
        paramTXSVideoEncoderParam.encoderProfile = 3;
      }
      if (com.tencent.liteav.basic.d.c.a().d() == 1)
      {
        TXCLog.e("TXCHWVideoEncoder", "[Encoder] force reset profile to baseline. device:" + TXCCommonUtil.getDeviceInfo());
        paramTXSVideoEncoderParam.encoderProfile = 1;
      }
      if (!com.tencent.liteav.basic.d.c.a().g())
      {
        TXCLog.e("TXCHWVideoEncoder", "[Encoder] force reset profile to baseline. this cmd from config.");
        paramTXSVideoEncoderParam.encoderProfile = 1;
      }
      if (!g.a().b("enable_high_profile", true))
      {
        TXCLog.e("TXCHWVideoEncoder", "[Encoder] force set profile to baseline. this cmd from local.");
        paramTXSVideoEncoderParam.encoderProfile = 1;
      }
      switch (paramTXSVideoEncoderParam.encoderProfile)
      {
      default: 
        i2 = 1;
      }
      break;
    }
    for (;;)
    {
      this.M = i1;
      this.N = i2;
      if ((this.R) && (Build.VERSION.SDK_INT >= 21)) {
        this.N = 1;
      }
      if (c()) {
        break label617;
      }
      AppMethodBeat.o(14876);
      return false;
      i1 = 2;
      break;
      i1 = 1;
      break;
      i1 = 0;
      break;
      i2 = 1;
      continue;
      i2 = 64;
    }
    label617:
    this.mInit = true;
    if (this.P)
    {
      this.Y = -1;
      this.u.b(this.w);
    }
    this.ac = new ArrayList();
    this.ad = 0;
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
    if ((this.z instanceof b))
    {
      ((b)this.z).c();
      this.z = null;
    }
    if ((this.z instanceof com.tencent.liteav.basic.opengl.c))
    {
      ((com.tencent.liteav.basic.opengl.c)this.z).d();
      this.z = null;
    }
    AppMethodBeat.o(182431);
  }
  
  @TargetApi(18)
  private void b(int paramInt)
  {
    AppMethodBeat.i(14880);
    if ((this.B == true) || (this.z == null))
    {
      AppMethodBeat.o(14880);
      return;
    }
    for (;;)
    {
      int i4;
      synchronized (this.aa)
      {
        int i3 = this.Y;
        if (this.P)
        {
          this.Y = -1;
          if (i3 == -1)
          {
            this.ab = true;
            AppMethodBeat.o(14880);
            return;
          }
          this.X += 1;
          this.u.a(this.w, 1000 / this.L);
        }
        if (i3 == -1)
        {
          AppMethodBeat.o(14880);
          return;
        }
        a(this.G);
        i4 = (720 - this.mRotation) % 360;
        int i1;
        int i2;
        if ((i4 == 90) || (i4 == 270))
        {
          i1 = this.mOutputHeight;
          break label369;
          i2 = this.mOutputWidth;
          this.mEncodeFilter.a(this.mInputWidth, this.mInputHeight, i4, null, i1 / i2, this.mEnableXMirror, true);
          this.mEncodeFilter.a(i3);
          if ((this.z instanceof com.tencent.liteav.basic.opengl.c))
          {
            ((com.tencent.liteav.basic.opengl.c)this.z).a(this.G * 1000000L);
            ((com.tencent.liteav.basic.opengl.c)this.z).e();
          }
          if ((this.z instanceof b)) {
            ((b)this.z).a();
          }
          i1 = a(paramInt);
          if (i1 > 0) {
            continue;
          }
          if ((i1 == -1) || (i1 == -2))
          {
            if (i1 == -1) {
              callDelegate(10000005);
            }
            this.B = true;
            e();
            AppMethodBeat.o(14880);
          }
        }
        else
        {
          i1 = this.mOutputWidth;
          break label369;
          i2 = this.mOutputHeight;
        }
      }
      this.S += 1;
      AppMethodBeat.o(14880);
      return;
      label369:
      if (i4 != 90) {
        if (i4 != 270) {}
      }
    }
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
    if ((this.a < this.i) && (this.aj)) {
      if (this.ai)
      {
        paramInt = 1;
        Monitor.a(4, "restart video hw encoder when down bps。[module:" + Build.MODEL + "] [Hardware:" + Build.HARDWARE + "] [osVersion:" + Build.VERSION.RELEASE + "]", "", 0);
      }
    }
    long l1;
    for (;;)
    {
      this.i = this.a;
      if ((Build.VERSION.SDK_INT < 19) || (this.s == null)) {
        break label288;
      }
      if (paramInt == 0) {
        break label254;
      }
      this.u.a().removeCallbacks(this.al);
      l1 = System.currentTimeMillis();
      if (l1 - this.ak < 2000L) {
        break;
      }
      this.al.run();
      AppMethodBeat.o(14884);
      return;
      this.ag = 3;
      this.af = System.currentTimeMillis();
      this.ah = this.a;
      paramInt = 0;
    }
    this.u.a(this.al, 2000L - (l1 - this.ak));
    AppMethodBeat.o(14884);
    return;
    label254:
    Bundle localBundle = new Bundle();
    localBundle.putInt("video-bitrate", this.a * 1024);
    this.s.setParameters(localBundle);
    label288:
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
    if (com.tencent.liteav.basic.d.c.a().a("Video", "CheckVideoEncDownBps") > 0L)
    {
      bool = true;
      this.aj = bool;
      this.o = false;
      this.S = 0;
      this.T = 0;
      this.V = 0L;
      this.W = 0;
      this.U = 0;
      this.X = 0;
      if (this.R) {
        this.t = "video/hevc";
      }
    }
    for (;;)
    {
      try
      {
        MediaFormat localMediaFormat1 = a(this.mOutputWidth, this.mOutputHeight, this.a, this.L, this.K, this.M, this.N, this.Q);
        if (localMediaFormat1 == null)
        {
          this.B = true;
          AppMethodBeat.o(182432);
          return false;
          bool = false;
          break;
        }
        this.s = MediaCodec.createEncoderByType(this.t);
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
                this.s.configure(localMediaFormat1, null, null, 1);
                i1 = 3;
                localMediaFormat3 = a(this.mOutputWidth, this.mOutputHeight, this.a, this.L, this.K, this.M, this.N, false);
              }
              catch (Exception localException7)
              {
                try
                {
                  this.A = this.s.createInputSurface();
                  i1 = 4;
                  this.s.start();
                }
                catch (Exception localException4)
                {
                  MediaFormat localMediaFormat2;
                  continue;
                }
                try
                {
                  this.E = this.s.getOutputBuffers();
                  if ((this.s != null) && (this.E != null) && (this.A != null)) {
                    continue;
                  }
                  this.B = true;
                  AppMethodBeat.o(182432);
                  return false;
                }
                catch (Exception localException5)
                {
                  i1 = 5;
                  continue;
                }
                localException7 = localException7;
                TXCLog.i("TXCHWVideoEncoder", "[Encoder] set fmt error. fmt:".concat(String.valueOf(localMediaFormat1)));
                if (!this.Q) {
                  continue;
                }
              }
            }
            catch (Exception localException6)
            {
              TXCLog.w("TXCHWVideoEncoder", "config custom format error " + localException6.toString());
            }
          }
          else
          {
            try
            {
              MediaFormat localMediaFormat3;
              this.s.configure(localMediaFormat3, null, null, 1);
            }
            catch (Exception localException8)
            {
              TXCLog.i("TXCHWVideoEncoder", "[Encoder] set fmt error. fmt:".concat(String.valueOf(localMediaFormat1)));
            }
            if ((!(localException8 instanceof IllegalArgumentException)) && ((Build.VERSION.SDK_INT < 21) || (!(localException8 instanceof MediaCodec.CodecException)))) {
              continue;
            }
            localMediaFormat1 = a(this.mOutputWidth, this.mOutputHeight, this.a, this.L, this.K);
            this.s.configure(localMediaFormat1, null, null, 1);
            continue;
          }
          TXCLog.e("TXCHWVideoEncoder", "create encode format failed.", localException1);
        }
        catch (Exception localException1)
        {
          i1 = 2;
        }
      }
      catch (Exception localException3)
      {
        i1 = 1;
        continue;
      }
      if (i1 >= 5) {}
      try
      {
        if (this.s != null) {
          this.s.stop();
        }
        this.s = null;
        if (this.A != null) {
          this.A.release();
        }
        this.A = null;
      }
      catch (Exception localException2) {}
      continue;
      if ((!(localException8 instanceof IllegalArgumentException)) && ((Build.VERSION.SDK_INT < 21) || (!(localException8 instanceof MediaCodec.CodecException)))) {
        continue;
      }
      localMediaFormat2 = a(this.mOutputWidth, this.mOutputHeight, this.a, this.L, this.K);
      this.s.configure(localMediaFormat2, null, null, 1);
    }
    AppMethodBeat.o(182432);
    throw localException8;
    if (!a(this.A, this.mOutputWidth, this.mOutputHeight))
    {
      this.B = true;
      AppMethodBeat.o(182432);
      return false;
    }
    AppMethodBeat.o(182432);
    return true;
  }
  
  private void d()
  {
    AppMethodBeat.i(182433);
    if (this.s == null)
    {
      AppMethodBeat.o(182433);
      return;
    }
    for (;;)
    {
      try
      {
        this.s.stop();
      }
      catch (IllegalStateException localIllegalStateException)
      {
        localIllegalStateException = localIllegalStateException;
        TXCLog.e("TXCHWVideoEncoder", "stop encoder failed.", localIllegalStateException);
        try
        {
          this.s.release();
          if (this.A != null) {
            this.A.release();
          }
          this.A = null;
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
        this.s.release();
        if (this.A != null) {
          this.A.release();
        }
        this.A = null;
      }
      catch (Exception localException1)
      {
        TXCLog.e("TXCHWVideoEncoder", "release encoder failed.", localException1);
      }
    }
    this.s = null;
    AppMethodBeat.o(182433);
    return;
    try
    {
      this.s.release();
      if (this.A != null) {
        this.A.release();
      }
      this.A = null;
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
    if ((paramInt == 0) || (this.L == paramInt))
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
    this.L = paramInt;
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
    this.B = true;
    this.C = true;
    b();
    d();
    this.Y = -1;
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
    this.q = 0L;
    this.r = 0L;
    this.mGLContextExternal = null;
    this.E = null;
    this.F = null;
    this.G = 0L;
    this.mOutputWidth = 0;
    this.mOutputHeight = 0;
    this.mInit = false;
    this.mListener = null;
    this.y.clear();
    this.ac.clear();
    this.ad = 0;
    AppMethodBeat.o(14882);
  }
  
  private void f()
  {
    AppMethodBeat.i(14883);
    if ((Build.VERSION.SDK_INT >= 19) && (this.s != null))
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("request-sync", 0);
      this.s.setParameters(localBundle);
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
    if (this.af > 0L)
    {
      i3 = this.L;
      i4 = (int)this.c;
      i2 = this.L / 2;
      if (i2 >= 5) {
        break label379;
      }
    }
    for (;;)
    {
      long l3;
      long l4;
      long l2;
      if ((i3 - i4 <= i1) && (System.currentTimeMillis() - this.af > (3 - this.ag + 1) * 2000))
      {
        l3 = this.ah;
        l4 = this.b;
        l2 = this.i / 2L;
        if (l2 >= 100L) {
          break label372;
        }
      }
      for (;;)
      {
        if (l3 - l4 > l1)
        {
          this.ai = true;
          String str = "real bitrate is too much lower than target bitrate![current profile:" + this.N + "][targetBr:" + this.ah + "] [realBr:" + this.b + "]. restart encoder. [module:" + Build.MODEL + "] [Hardware:" + Build.HARDWARE + "] [osVersion:" + Build.VERSION.RELEASE + "]";
          TXCLog.e("TXCHWVideoEncoder", str);
          Monitor.a(3, str, "", 0);
          if (this.R)
          {
            this.N = 1;
            TXCLog.w("TXCHWVideoEncoder", "[Encoder] force reset hevc profile to HEVCProfileMain when restart encoder. device:" + TXCCommonUtil.getDeviceInfo());
          }
          for (;;)
          {
            if (this.u != null) {
              this.u.b(this.al);
            }
            this.af = 0L;
            AppMethodBeat.o(14885);
            return;
            if (this.N != 1)
            {
              this.N = 1;
              TXCLog.e("TXCHWVideoEncoder", "[Encoder] force reset profile to baseline when restart encoder. device:" + TXCCommonUtil.getDeviceInfo());
            }
          }
        }
        this.ag -= 1;
        if (this.ag <= 0) {
          this.af = 0L;
        }
        AppMethodBeat.o(14885);
        return;
        label372:
        l1 = l2;
      }
      label379:
      i1 = i2;
    }
  }
  
  private void h()
  {
    AppMethodBeat.i(14887);
    TXCLog.i("TXCHWVideoEncoder", "destroyCopyTexture");
    synchronized (this.aa)
    {
      if (this.Z != null)
      {
        this.Z.d();
        this.Z = null;
      }
      this.Y = -1;
      AppMethodBeat.o(14887);
      return;
    }
  }
  
  public int getEncodeCost()
  {
    return this.ad;
  }
  
  public long getRealBitrate()
  {
    return this.b;
  }
  
  public double getRealFPS()
  {
    return this.c;
  }
  
  public boolean isH265Encoder()
  {
    return this.R;
  }
  
  public long pushVideoFrame(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    AppMethodBeat.i(14865);
    if (this.C)
    {
      AppMethodBeat.o(14865);
      return 10000004L;
    }
    synchronized (this.aa)
    {
      if (this.Z == null) {
        a(paramInt2, paramInt3);
      }
      this.Z.a(paramInt2, paramInt3);
      GLES20.glViewport(0, 0, paramInt2, paramInt3);
      paramInt1 = this.Z.b(paramInt1);
      if (this.ae)
      {
        GLES20.glFinish();
        this.U += 1;
        this.G = paramLong;
        this.Y = paramInt1;
        this.mInputWidth = paramInt2;
        this.mInputHeight = paramInt3;
        if (this.O) {
          f();
        }
        if ((!this.P) || (this.ab))
        {
          this.X += 1;
          this.u.b(this.w);
          this.ab = false;
        }
        if (this.S > this.T + 30)
        {
          TXCLog.e("TXCHWVideoEncoder", String.format("hw encoder error when render[%d] pop[%d]", new Object[] { Integer.valueOf(this.S), Integer.valueOf(this.T) }));
          if (this.mListener != null)
          {
            this.mListener.l(this.mStreamType);
            if (this.R) {
              Monitor.a(2, String.format(Locale.getDefault(), "VideoEncoder: hevc hardware encoder error: mRendIdx= %d,mPopIdx= %d , switch to 264 hardware encoder. %s", new Object[] { Integer.valueOf(this.S), Integer.valueOf(this.T), TXCCommonUtil.getDeviceInfo() }), "", 0);
            }
          }
        }
        if (this.V + 5000L < System.currentTimeMillis())
        {
          this.V = System.currentTimeMillis();
          if ((this.W != 0) && (this.W == this.S))
          {
            TXCLog.i("TXCHWVideoEncoder", String.format("hw encoder error when push[%d] render task[%d] render[%d] pop[%d]", new Object[] { Integer.valueOf(this.U), Integer.valueOf(this.X), Integer.valueOf(this.S), Integer.valueOf(this.T) }));
            if (this.mListener != null)
            {
              this.mListener.l(this.mStreamType);
              if (this.R) {
                Monitor.a(2, String.format(Locale.getDefault(), "VideoEncoder: hevc hardware encoder error: timecheck , switch to 264 hardware encoder. %s", new Object[] { TXCCommonUtil.getDeviceInfo() }), "", 0);
              }
            }
          }
          this.W = this.S;
        }
        AppMethodBeat.o(14865);
        return 0L;
      }
      GLES20.glFlush();
    }
  }
  
  public long pushVideoFrameAsync(final int paramInt1, int paramInt2, int paramInt3, final long paramLong)
  {
    AppMethodBeat.i(14866);
    if (this.C)
    {
      AppMethodBeat.o(14866);
      return 10000004L;
    }
    if (this.ae) {
      GLES20.glFinish();
    }
    for (;;)
    {
      if (this.O) {
        f();
      }
      this.u.a().post(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(14784);
          if ((a.b(a.this) == true) || (a.c(a.this) == null))
          {
            AppMethodBeat.o(14784);
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
            if ((a.c(a.this) instanceof com.tencent.liteav.basic.opengl.c))
            {
              ((com.tencent.liteav.basic.opengl.c)a.c(a.this)).a(1000000L * l);
              ((com.tencent.liteav.basic.opengl.c)a.c(a.this)).e();
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
            AppMethodBeat.o(14784);
            return;
            i = a.this.mOutputWidth;
            break;
          }
          label354:
          a.d(a.this);
          AppMethodBeat.o(14784);
        }
      });
      AppMethodBeat.o(14866);
      return 0L;
      GLES20.glFlush();
    }
  }
  
  public long pushVideoFrameSync(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    AppMethodBeat.i(14867);
    if (this.C)
    {
      AppMethodBeat.o(14867);
      return 10000004L;
    }
    if (this.ae) {
      GLES20.glFinish();
    }
    for (;;)
    {
      this.G = paramLong;
      this.Y = paramInt1;
      if (this.O) {
        f();
      }
      this.u.a(this.x);
      AppMethodBeat.o(14867);
      return 0L;
      GLES20.glFlush();
    }
  }
  
  public void setBitrate(final int paramInt)
  {
    AppMethodBeat.i(14863);
    this.a = paramInt;
    this.u.b(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(14820);
        a.b(a.this, paramInt);
        AppMethodBeat.o(14820);
      }
    });
    AppMethodBeat.o(14863);
  }
  
  public void setBitrateFromQos(final int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(14864);
    this.a = paramInt1;
    this.u.b(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(14788);
        a.b(a.this, paramInt1);
        AppMethodBeat.o(14788);
      }
    });
    AppMethodBeat.o(14864);
  }
  
  public void setEncodeIdrFpsFromQos(int paramInt) {}
  
  public void setFPS(final int paramInt)
  {
    AppMethodBeat.i(14862);
    this.u.b(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(14858);
        a.a(a.this, paramInt);
        AppMethodBeat.o(14858);
      }
    });
    AppMethodBeat.o(14862);
  }
  
  public void setGLFinishedTextureNeed(boolean paramBoolean)
  {
    this.ae = paramBoolean;
  }
  
  public void setThreadPriority(final com.tencent.liteav.basic.structs.c paramc)
  {
    AppMethodBeat.i(229883);
    super.setThreadPriority(paramc);
    this.u.b(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(14785);
        TXCLog.i("TXCHWVideoEncoder", "setThreadPriority: priority:" + paramc);
        Process.setThreadPriority(paramc.a());
        AppMethodBeat.o(14785);
      }
    });
    AppMethodBeat.o(229883);
  }
  
  public void signalEOSAndFlush()
  {
    AppMethodBeat.i(14868);
    if (this.C)
    {
      AppMethodBeat.o(14868);
      return;
    }
    this.u.a(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(14850);
        if (a.e(a.this) == null)
        {
          AppMethodBeat.o(14850);
          return;
        }
        try
        {
          a.e(a.this).signalEndOfInputStream();
          while (a.c(a.this, 10) >= 0) {}
          a.a(a.this);
          AppMethodBeat.o(14850);
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
      this.u.b(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(14787);
          String str1 = "unknown";
          String str2 = "unknown";
          label80:
          int i;
          int j;
          int k;
          int m;
          int n;
          int i1;
          String str3;
          label145:
          int i2;
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
              if (paramTXSVideoEncoderParam.bMultiRef)
              {
                str3 = "true";
                i2 = paramTXSVideoEncoderParam.streamType;
                if (!paramTXSVideoEncoderParam.isH265EncoderEnabled) {
                  break label411;
                }
              }
              break;
            }
            break;
          }
          label411:
          for (String str4 = "true";; str4 = "false")
          {
            str1 = String.format("VideoEncoder[%d]: Start [type:hardware][resolution:%d*%d][fps:%d][bitrate:%dkbps][gop:%d][rateControl:%s][profile:%s][rps:%s][streamType:%d][enable hevc:%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), str1, str2, str3, Integer.valueOf(i2), str4 });
            Monitor.a(2, str1, "", 0);
            TXCLog.i("TXCHWVideoEncoder", "start:".concat(String.valueOf(str1)));
            if (a.this.mInit) {
              a.a(a.this);
            }
            if (!a.a(a.this, paramTXSVideoEncoderParam)) {
              break label418;
            }
            Monitor.a(2, String.format("VideoEncoder[%d]: Start successfully, streamType:%d", new Object[] { Integer.valueOf(a.this.hashCode()), Integer.valueOf(paramTXSVideoEncoderParam.streamType) }), "streamType: 2-big, 3-small, 7-sub", 0);
            AppMethodBeat.o(14787);
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
            str3 = "false";
            break label145;
          }
          label418:
          a.this.callDelegate(10000004);
          AppMethodBeat.o(14787);
        }
      });
    }
    AppMethodBeat.o(14860);
    return 10000004;
  }
  
  public void stop()
  {
    AppMethodBeat.i(14861);
    this.C = true;
    this.u.b(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(14851);
        if (a.this.mInit)
        {
          Monitor.a(2, String.format("VideoEncoder[%d]: Stop, streamType:%d", new Object[] { Integer.valueOf(a.this.hashCode()), Integer.valueOf(a.this.mStreamType) }), "streamType: 2-big, 3-small, 7-sub", 0);
          a.a(a.this);
        }
        AppMethodBeat.o(14851);
      }
    });
    h();
    AppMethodBeat.o(14861);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.videoencoder.a
 * JD-Core Version:    0.7.0.1
 */