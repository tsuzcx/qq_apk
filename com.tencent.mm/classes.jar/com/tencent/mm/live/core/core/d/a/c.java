package com.tencent.mm.live.core.core.d.a;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.opengl.GLES20;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Size;
import android.util.SparseArray;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.core.d.a.a.a.2;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler.Callback;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLivePlayer.ITXLivePlayVideoRenderListener;
import com.tencent.rtmp.TXLivePlayer.TXLiteAVTexture;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;

public final class c
  implements MMHandler.Callback, TXLivePlayer.ITXLivePlayVideoRenderListener
{
  public static int mPB = 1;
  TextureView eDa;
  Context mContext;
  private String mID;
  protected boolean mPC;
  private final HandlerThread mPD;
  final a mPE;
  TXCloudVideoView mPF;
  e mPG;
  private com.tencent.mm.live.core.core.d.b.c mPH;
  private SurfaceTexture mPI;
  boolean mPJ;
  public a mPK;
  boolean mPL;
  TXLivePlayer.TXLiteAVTexture mPM;
  private boolean mPN;
  ITXLivePlayListener mPO;
  private boolean mPP;
  int mPQ;
  int mRenderMode;
  int mRenderRotation;
  private SurfaceTexture mSurfaceTexture;
  protected int mVideoHeight;
  protected int mVideoWidth;
  protected int mViewHeight;
  protected int mViewWidth;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(248096);
    this.mID = "";
    this.mPC = false;
    this.mPF = null;
    this.eDa = null;
    this.mPG = null;
    this.mSurfaceTexture = null;
    this.mViewWidth = 0;
    this.mViewHeight = 0;
    this.mVideoWidth = 0;
    this.mVideoHeight = 0;
    this.mPH = null;
    this.mPI = null;
    this.mPJ = false;
    this.mPK = null;
    this.mRenderMode = 1;
    this.mRenderRotation = 0;
    this.mPL = false;
    this.mPM = null;
    this.mPN = false;
    this.mPO = null;
    this.mPP = false;
    this.mPQ = 0;
    this.mContext = paramContext;
    this.mPD = com.tencent.threadpool.c.d.jw("CustomRender.CustomRender", 10);
    this.mPD.start();
    this.mPE = new a(this.mPD.getLooper(), this);
    if (Build.VERSION.SDK_INT >= 21) {}
    for (this.mPJ = true;; this.mPJ = false)
    {
      this.mPK = new a();
      AppMethodBeat.o(248096);
      return;
    }
  }
  
  public final void ef(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(248182);
    if ((paramInt1 != this.mViewWidth) || (paramInt2 != this.mViewHeight))
    {
      this.mViewWidth = paramInt1;
      this.mViewHeight = paramInt2;
      if ((this.mPG != null) && (this.mPQ != 1)) {
        this.mPG.ef(this.mViewWidth, this.mViewHeight);
      }
      if (this.mPM != null) {
        this.mPE.obtainMessage(2, this.mPM).sendToTarget();
      }
    }
    AppMethodBeat.o(248182);
  }
  
  public final void finalize()
  {
    AppMethodBeat.i(248147);
    if ((this.mPK != null) && (this.mContext != null)) {
      this.mPK.dA(this.mContext);
    }
    AppMethodBeat.o(248147);
  }
  
  public final boolean handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(248235);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(248235);
      return false;
      paramMessage = (TXLivePlayer.TXLiteAVTexture)paramMessage.obj;
      if ((this.mPL) && (this.mSurfaceTexture != null))
      {
        if (this.mPK == null) {
          this.mPK = new a();
        }
        Object localObject6;
        Object localObject5;
        if (!this.mPK.mPt)
        {
          localObject6 = paramMessage.eglContext;
          try
          {
            Object localObject1 = this.mPK;
            localObject5 = new Surface(this.mSurfaceTexture);
            if (!(localObject6 instanceof EGLContext)) {
              break label1300;
            }
            Log.i("CustomRender.CustomGLRenderImp", "init use javax.microedition.khronos.egl.EGLContext");
            localObject6 = (EGLContext)localObject6;
            Log.i("CustomRender.CustomGLRenderImp", "init egl");
            ((a)localObject1).mPu = ((EGL10)EGLContext.getEGL());
            ((a)localObject1).mPv = ((a)localObject1).mPu.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (((a)localObject1).mPv != EGL10.EGL_NO_DISPLAY) {
              break label941;
            }
            localObject1 = new RuntimeException("unable to get EGL14 display");
            AppMethodBeat.o(248235);
            throw ((Throwable)localObject1);
          }
          catch (Exception localException1)
          {
            Log.e("CustomRender.CustomRender", "CustomGLRenderImp create failed!");
            this.mPK.beE();
          }
          label218:
          if (!this.mPK.mPt) {
            continue;
          }
        }
        else
        {
          this.mPK.makeCurrent();
          if (!this.mPN)
          {
            if (this.mPQ != 2) {
              break label1317;
            }
            this.mPK.compileShaders();
            label258:
            this.mPN = true;
          }
          this.mPM = paramMessage;
          if ((this.mPC) && (this.mPH != null)) {}
        }
        label941:
        Object localObject4;
        try
        {
          this.mPH = new com.tencent.mm.live.core.core.d.b.c();
          if (this.mPH != null)
          {
            if (this.mVideoWidth * this.mVideoHeight > 953856)
            {
              i = 2;
              try
              {
                Object localObject2 = this.mPH;
                if (i != 0)
                {
                  j = paramMessage.width;
                  k = paramMessage.height;
                  localObject5 = ((com.tencent.mm.live.core.core.d.b.c)localObject2).mRa;
                  m = paramMessage.textureId;
                  if ((((com.tencent.mm.live.core.core.d.b.b)localObject5).mWidth != j) || (((com.tencent.mm.live.core.core.d.b.b)localObject5).mHeight != k))
                  {
                    if (localObject5.mFrameBuffer[0] != 0)
                    {
                      GLES20.glDeleteFramebuffers(1, ((com.tencent.mm.live.core.core.d.b.b)localObject5).mFrameBuffer, 0);
                      ((com.tencent.mm.live.core.core.d.b.b)localObject5).mFrameBuffer[0] = 0;
                    }
                    if (localObject5.mTextureid[0] != 0)
                    {
                      GLES20.glDeleteTextures(1, ((com.tencent.mm.live.core.core.d.b.b)localObject5).mTextureid, 0);
                      ((com.tencent.mm.live.core.core.d.b.b)localObject5).mTextureid[0] = 0;
                    }
                    GLES20.glGenFramebuffers(1, ((com.tencent.mm.live.core.core.d.b.b)localObject5).mFrameBuffer, 0);
                    GLES20.glBindFramebuffer(36160, localObject5.mFrameBuffer[0]);
                    GLES20.glGenTextures(1, ((com.tencent.mm.live.core.core.d.b.b)localObject5).mTextureid, 0);
                    GLES20.glBindTexture(3553, localObject5.mTextureid[0]);
                    GLES20.glTexImage2D(3553, 0, 6408, j, k, 0, 6408, 5121, null);
                    GLES20.glTexParameteri(3553, 10241, 9729);
                    GLES20.glTexParameteri(3553, 10240, 9729);
                    GLES20.glTexParameteri(3553, 10242, 33071);
                    GLES20.glTexParameteri(3553, 10243, 33071);
                    GLES20.glFramebufferTexture2D(36160, 36064, 3553, localObject5.mTextureid[0], 0);
                    GLES20.glBindTexture(3553, 0);
                    GLES20.glBindFramebuffer(36160, 0);
                    ((com.tencent.mm.live.core.core.d.b.b)localObject5).mWidth = j;
                    ((com.tencent.mm.live.core.core.d.b.b)localObject5).mHeight = k;
                  }
                  GLES20.glBindFramebuffer(36160, localObject5.mFrameBuffer[0]);
                  GLES20.glUseProgram(((com.tencent.mm.live.core.core.d.b.b)localObject5).mProgramHandle);
                  GLES20.glViewport(0, 0, j, k);
                  GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
                  GLES20.glClear(16384);
                  GLES20.glActiveTexture(33984);
                  GLES20.glBindTexture(3553, m);
                  GLES20.glUniform1i(((com.tencent.mm.live.core.core.d.b.b)localObject5).minputImageTextureid, 0);
                  android.opengl.Matrix.setIdentityM(((com.tencent.mm.live.core.core.d.b.b)localObject5).mMVPMatrix, 0);
                  android.opengl.Matrix.setIdentityM(((com.tencent.mm.live.core.core.d.b.b)localObject5).mSTMatrix, 0);
                  GLES20.glUniformMatrix4fv(((com.tencent.mm.live.core.core.d.b.b)localObject5).muMVPMatrixHandle, 1, false, ((com.tencent.mm.live.core.core.d.b.b)localObject5).mMVPMatrix, 0);
                  GLES20.glUniformMatrix4fv(((com.tencent.mm.live.core.core.d.b.b)localObject5).muSTMatrixHandle, 1, false, ((com.tencent.mm.live.core.core.d.b.b)localObject5).mSTMatrix, 0);
                  ((com.tencent.mm.live.core.core.d.b.b)localObject5).mPositoins.position(0);
                  ((com.tencent.mm.live.core.core.d.b.b)localObject5).mTexcoords.position(0);
                  GLES20.glVertexAttribPointer(((com.tencent.mm.live.core.core.d.b.b)localObject5).mpositionid, 3, 5126, false, 0, ((com.tencent.mm.live.core.core.d.b.b)localObject5).mPositoins);
                  GLES20.glVertexAttribPointer(((com.tencent.mm.live.core.core.d.b.b)localObject5).mtexcoordid, 2, 5126, false, 0, ((com.tencent.mm.live.core.core.d.b.b)localObject5).mTexcoords);
                  GLES20.glDrawArrays(5, 0, 4);
                  GLES20.glBindFramebuffer(36160, 0);
                  if (com.tencent.mm.live.core.core.d.b.b.checkGlError("OES2TextureFilter") == 0) {
                    break label1698;
                  }
                  localObject2 = new RuntimeException("sifeng: OES2TextureFilter process failed");
                  AppMethodBeat.o(248235);
                  throw ((Throwable)localObject2);
                }
              }
              catch (Exception localException2)
              {
                Log.e("CustomRender.CustomRender", "sharpen filter failed!");
              }
            }
          }
          else
          {
            if ((this.mPQ == 2) || (this.mPQ != 1)) {
              break label3128;
            }
            Object localObject3 = this.mPK;
            j = this.mViewWidth;
            k = this.mViewHeight;
            i = this.mRenderRotation;
            if ((((a)localObject3).mPz != null) && (((a)localObject3).mPy != null)) {
              break label2341;
            }
            paramMessage = this.mPK;
            if (paramMessage.mPu != null) {
              paramMessage.mPu.eglSwapBuffers(paramMessage.mPv, paramMessage.mPx);
            }
            if ((this.mPP) || (this.mPO == null)) {
              continue;
            }
            this.mPO.onPlayEvent(2032, null);
            this.mPP = true;
            continue;
            localObject7 = new int[2];
            if (!((a)localObject3).mPu.eglInitialize(((a)localObject3).mPv, (int[])localObject7))
            {
              ((a)localObject3).mPv = null;
              localObject3 = new RuntimeException("unable to initialize EGL14");
              AppMethodBeat.o(248235);
              throw ((Throwable)localObject3);
            }
            localObject7 = new EGLConfig[1];
            int[] arrayOfInt = new int[1];
            if (!((a)localObject3).mPu.eglChooseConfig(((a)localObject3).mPv, new int[] { 12339, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12610, 1, 12344 }, (EGLConfig[])localObject7, 1, arrayOfInt))
            {
              localObject3 = new RuntimeException("unable to find RGB888+recordable ES2 EGL config");
              AppMethodBeat.o(248235);
              throw ((Throwable)localObject3);
            }
            ((a)localObject3).mPw = ((a)localObject3).mPu.eglCreateContext(((a)localObject3).mPv, localObject7[0], (EGLContext)localObject6, new int[] { 12440, 2, 12344 });
            ((a)localObject3).checkEglError("eglCreateContext");
            if (((a)localObject3).mPw == null)
            {
              localObject3 = new RuntimeException("null context");
              AppMethodBeat.o(248235);
              throw ((Throwable)localObject3);
            }
            ((a)localObject3).mPx = ((a)localObject3).mPu.eglCreateWindowSurface(((a)localObject3).mPv, localObject7[0], localObject5, new int[] { 12344 });
            ((a)localObject3).checkEglError("eglCreateWindowSurface");
            if (((a)localObject3).mPx == null)
            {
              localObject3 = new RuntimeException("surface was null");
              AppMethodBeat.o(248235);
              throw ((Throwable)localObject3);
            }
            ((a)localObject3).mPt = true;
            break label218;
            label1300:
            Log.i("CustomRender.CustomGLRenderImp", "not support eglContext");
            ((a)localObject3).mPt = false;
            break label218;
            label1317:
            if (this.mPQ == 1)
            {
              localObject3 = this.mPK;
              i = a.compileShader("uniform mat4 u_MVPMatrix;\n                            \n                                                     attribute vec4 position;\n                             attribute vec4 inputTextureCoordinate;\n               \n                                                     varying vec2 textureCoordinate;\n                      \n                                                     // The entry point for our vertex shader.\n            void main()\n                                          {\n                                                        textureCoordinate = inputTextureCoordinate.xy;\n       gl_Position = u_MVPMatrix * position;\n            }\n                                                    ", 35633);
              if (i == 0) {
                break label258;
              }
              j = a.compileShader("varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}", 35632);
              if (j == 0) {
                break label258;
              }
              ((a)localObject3).mProgramHandle = GLES20.glCreateProgram();
              if (a.checkGlError("glCreateProgram") != 0) {
                break label258;
              }
              GLES20.glAttachShader(((a)localObject3).mProgramHandle, i);
              if (a.checkGlError("glAttachShader") != 0) {
                break label258;
              }
              GLES20.glAttachShader(((a)localObject3).mProgramHandle, j);
              if (a.checkGlError("glAttachShader") != 0) {
                break label258;
              }
              GLES20.glLinkProgram(((a)localObject3).mProgramHandle);
              localObject5 = new int[1];
              GLES20.glGetProgramiv(((a)localObject3).mProgramHandle, 35714, (int[])localObject5, 0);
              if (localObject5[0] != 1)
              {
                Log.e("CustomRender.CustomGLRenderImp", "Could not link program: ");
                Log.e("CustomRender.CustomGLRenderImp", GLES20.glGetProgramInfoLog(((a)localObject3).mProgramHandle));
                GLES20.glDeleteProgram(((a)localObject3).mProgramHandle);
                ((a)localObject3).mProgramHandle = 0;
                break label258;
              }
              GLES20.glUseProgram(((a)localObject3).mProgramHandle);
              ((a)localObject3).mPj = GLES20.glGetAttribLocation(((a)localObject3).mProgramHandle, "position");
              ((a)localObject3).mPk = GLES20.glGetUniformLocation(((a)localObject3).mProgramHandle, "inputImageTexture");
              ((a)localObject3).mPm = GLES20.glGetAttribLocation(((a)localObject3).mProgramHandle, "inputTextureCoordinate");
              ((a)localObject3).mPl = GLES20.glGetUniformLocation(((a)localObject3).mProgramHandle, "u_MVPMatrix");
              GLES20.glEnableVertexAttribArray(((a)localObject3).mPj);
              GLES20.glEnableVertexAttribArray(((a)localObject3).mPm);
              if ((((a)localObject3).mPj != -1) && (((a)localObject3).mPk != -1) && (((a)localObject3).mPm != -1) && (((a)localObject3).mPl != -1) && (a.checkGlError("AdjustResidueFilter") == 0)) {
                break label258;
              }
              paramMessage = new RuntimeException("Shaders create failed");
              AppMethodBeat.o(248235);
              throw paramMessage;
            }
            this.mPK.compileShaders();
          }
        }
        catch (Exception localException3)
        {
          for (;;)
          {
            int i;
            int j;
            int k;
            int m;
            Object localObject7;
            Log.e("CustomRender.CustomRender", "create sharpen surface failed!");
            this.mPC = false;
            continue;
            if (this.mVideoWidth * this.mVideoHeight > 246656)
            {
              i = 1;
            }
            else
            {
              i = 0;
              continue;
              label1698:
              m = localObject5.mTextureid[0];
              localException3.mRc.process(m, j, k);
              localObject5 = localException3.mRb;
              int n = localException3.mRc.mTextureid[0];
              int i1 = localException3.mRc.mTextureid[1];
              int i2 = localException3.mRc.mTextureid[2];
              if ((((com.tencent.mm.live.core.core.d.b.d)localObject5).mWidth != j) || (((com.tencent.mm.live.core.core.d.b.d)localObject5).mHeight != k))
              {
                if (localObject5.mFrameBuffer[0] != 0)
                {
                  GLES20.glDeleteFramebuffers(1, ((com.tencent.mm.live.core.core.d.b.d)localObject5).mFrameBuffer, 0);
                  ((com.tencent.mm.live.core.core.d.b.d)localObject5).mFrameBuffer[0] = 0;
                }
                if (localObject5.mTextureid[0] != 0)
                {
                  GLES20.glDeleteTextures(1, ((com.tencent.mm.live.core.core.d.b.d)localObject5).mTextureid, 0);
                  ((com.tencent.mm.live.core.core.d.b.d)localObject5).mTextureid[0] = 0;
                }
                GLES20.glGenFramebuffers(1, ((com.tencent.mm.live.core.core.d.b.d)localObject5).mFrameBuffer, 0);
                GLES20.glBindFramebuffer(36160, localObject5.mFrameBuffer[0]);
                GLES20.glGenTextures(1, ((com.tencent.mm.live.core.core.d.b.d)localObject5).mTextureid, 0);
                GLES20.glBindTexture(3553, localObject5.mTextureid[0]);
                GLES20.glTexImage2D(3553, 0, 6408, j, k, 0, 6408, 5121, null);
                GLES20.glTexParameteri(3553, 10241, 9729);
                GLES20.glTexParameteri(3553, 10240, 9729);
                GLES20.glTexParameteri(3553, 10242, 33071);
                GLES20.glTexParameteri(3553, 10243, 33071);
                GLES20.glFramebufferTexture2D(36160, 36064, 3553, localObject5.mTextureid[0], 0);
                GLES20.glBindTexture(3553, 0);
                GLES20.glBindFramebuffer(36160, 0);
                ((com.tencent.mm.live.core.core.d.b.d)localObject5).mWidth = j;
                ((com.tencent.mm.live.core.core.d.b.d)localObject5).mHeight = k;
              }
              GLES20.glBindFramebuffer(36160, localObject5.mFrameBuffer[0]);
              GLES20.glUseProgram(((com.tencent.mm.live.core.core.d.b.d)localObject5).mProgramHandle);
              GLES20.glViewport(0, 0, j, k);
              GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
              GLES20.glClear(16384);
              GLES20.glActiveTexture(33984);
              GLES20.glBindTexture(3553, m);
              GLES20.glUniform1i(((com.tencent.mm.live.core.core.d.b.d)localObject5).minputImageTextureid, 0);
              GLES20.glActiveTexture(33985);
              GLES20.glBindTexture(3553, n);
              GLES20.glUniform1i(((com.tencent.mm.live.core.core.d.b.d)localObject5).mblurredImageTexture1id, 1);
              GLES20.glActiveTexture(33986);
              GLES20.glBindTexture(3553, i1);
              GLES20.glUniform1i(((com.tencent.mm.live.core.core.d.b.d)localObject5).mblurredImageTexture2id, 2);
              GLES20.glActiveTexture(33987);
              GLES20.glBindTexture(3553, i2);
              GLES20.glUniform1i(((com.tencent.mm.live.core.core.d.b.d)localObject5).mblurredImageTexture3id, 3);
              j = (i - 1) * 6;
              i = j;
              if (j != 0)
              {
                i = j;
                if (j != 6) {
                  i = 0;
                }
              }
              GLES20.glUniform1fv(((com.tencent.mm.live.core.core.d.b.d)localObject5).mRe, 6, com.tencent.mm.live.core.core.d.b.d.mRd, i);
              android.opengl.Matrix.setIdentityM(((com.tencent.mm.live.core.core.d.b.d)localObject5).mMVPMatrix, 0);
              GLES20.glUniformMatrix4fv(((com.tencent.mm.live.core.core.d.b.d)localObject5).muMVPMatrixHandle, 1, false, ((com.tencent.mm.live.core.core.d.b.d)localObject5).mMVPMatrix, 0);
              GLES20.glUniformMatrix4fv(((com.tencent.mm.live.core.core.d.b.d)localObject5).muSTMatrixHandle, 1, false, ((com.tencent.mm.live.core.core.d.b.d)localObject5).mSTMatrix, 0);
              ((com.tencent.mm.live.core.core.d.b.d)localObject5).mPositoins.position(0);
              ((com.tencent.mm.live.core.core.d.b.d)localObject5).mTexcoords.position(0);
              GLES20.glVertexAttribPointer(((com.tencent.mm.live.core.core.d.b.d)localObject5).mpositionid, 3, 5126, false, 0, ((com.tencent.mm.live.core.core.d.b.d)localObject5).mPositoins);
              GLES20.glVertexAttribPointer(((com.tencent.mm.live.core.core.d.b.d)localObject5).mtexcoordid, 2, 5126, false, 0, ((com.tencent.mm.live.core.core.d.b.d)localObject5).mTexcoords);
              GLES20.glDrawArrays(5, 0, 4);
              GLES20.glBindFramebuffer(36160, 0);
              if (com.tencent.mm.live.core.core.d.b.d.checkGlError("USM3FusionFilter") != 0)
              {
                localObject4 = new RuntimeException("sifeng: USM3FusionFilter process failed");
                AppMethodBeat.o(248235);
                throw ((Throwable)localObject4);
              }
              paramMessage.textureId = localObject5.mTextureid[0];
              continue;
              label2341:
              label2374:
              float f1;
              float f3;
              float f2;
              if ((j != ((a)localObject4).mPn) || (k != ((a)localObject4).mPo) || (i != ((a)localObject4).mPs))
              {
                i = 1;
                if (i != 0)
                {
                  ((a)localObject4).mPn = j;
                  ((a)localObject4).mPo = k;
                  localObject5 = ((a)localObject4).mPz;
                  if (j <= k) {
                    break label3008;
                  }
                  ((com.tencent.mm.live.core.core.d.a.a.a)localObject5).mViewWidth = j;
                  ((com.tencent.mm.live.core.core.d.a.a.a)localObject5).mViewHeight = k;
                  f1 = Math.min(Math.max(35.0F, 20.0F), 65.0F);
                  f3 = j / k;
                  f2 = (float)Math.tan(f1 / 180.0F * 3.141593F);
                  f3 *= f2;
                  ((com.tencent.mm.live.core.core.d.a.a.a)localObject5).o(-f3, f3, -f2, f2);
                  ((com.tencent.mm.live.core.core.d.a.a.a)localObject5).mQl = ((float)Math.atan(f3) / 3.141593F * 180.0F);
                  ((com.tencent.mm.live.core.core.d.a.a.a)localObject5).mQm = f1;
                }
                label2506:
                localObject5 = ((a)localObject4).beG();
                GLES20.glViewport(0, 0, ((Size)localObject5).getWidth(), ((Size)localObject5).getHeight());
                GLES20.glBindFramebuffer(36160, 0);
                GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
                GLES20.glClear(16640);
                localObject5 = (FloatBuffer)((a)localObject4).mPy.mQT.get(0);
                localObject6 = (FloatBuffer)((a)localObject4).mPy.mQS.get(0);
                if ((localObject6 == null) || (localObject5 == null)) {
                  continue;
                }
                ((FloatBuffer)localObject5).position(0);
                ((FloatBuffer)localObject6).position(0);
                localObject7 = ((a)localObject4).mPz;
                ((com.tencent.mm.live.core.core.d.a.a.a)localObject7).hbY = Math.min(((com.tencent.mm.live.core.core.d.a.a.a)localObject7).hbY, 90.0F - ((com.tencent.mm.live.core.core.d.a.a.a)localObject7).pitch);
                ((com.tencent.mm.live.core.core.d.a.a.a)localObject7).hbY = Math.max(((com.tencent.mm.live.core.core.d.a.a.a)localObject7).hbY, -90.0F - ((com.tencent.mm.live.core.core.d.a.a.a)localObject7).pitch);
                f1 = -((com.tencent.mm.live.core.core.d.a.a.a)localObject7).pitch;
                f2 = -((com.tencent.mm.live.core.core.d.a.a.a)localObject7).hbY;
                f3 = -((com.tencent.mm.live.core.core.d.a.a.a)localObject7).yaw;
                float f4 = -((com.tencent.mm.live.core.core.d.a.a.a)localObject7).hbX;
                android.opengl.Matrix.setLookAtM(((com.tencent.mm.live.core.core.d.a.a.a)localObject7).mQc, 0, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F);
                android.opengl.Matrix.rotateM(((com.tencent.mm.live.core.core.d.a.a.a)localObject7).mQc, 0, f1 + f2, 0.0F, 0.0F, 1.0F);
                android.opengl.Matrix.rotateM(((com.tencent.mm.live.core.core.d.a.a.a)localObject7).mQc, 0, f3 + f4, 0.0F, 1.0F, 0.0F);
                if (((com.tencent.mm.live.core.core.d.a.a.a)localObject7).mQH)
                {
                  f2 = ((com.tencent.mm.live.core.core.d.a.a.a)localObject7).mViewWidth / ((com.tencent.mm.live.core.core.d.a.a.a)localObject7).mViewHeight;
                  f1 = (float)Math.tan(Math.min(Math.max(((com.tencent.mm.live.core.core.d.a.a.a)localObject7).mQI * ((com.tencent.mm.live.core.core.d.a.a.a)localObject7).mQm, 20.0F), 65.0F) / 180.0F * 3.141593F);
                  f2 *= f1;
                  ((com.tencent.mm.live.core.core.d.a.a.a)localObject7).o(-f2, f2, -f1, f1);
                }
                android.opengl.Matrix.multiplyMM(((com.tencent.mm.live.core.core.d.a.a.a)localObject7).mQa, 0, ((com.tencent.mm.live.core.core.d.a.a.a)localObject7).mQc, 0, ((com.tencent.mm.live.core.core.d.a.a.a)localObject7).mQb, 0);
                android.opengl.Matrix.multiplyMM(((com.tencent.mm.live.core.core.d.a.a.a)localObject7).mMVPMatrix, 0, ((com.tencent.mm.live.core.core.d.a.a.a)localObject7).mQd, 0, ((com.tencent.mm.live.core.core.d.a.a.a)localObject7).mQa, 0);
                localObject7 = ((com.tencent.mm.live.core.core.d.a.a.a)localObject7).mMVPMatrix;
                if (localObject7 == null) {
                  continue;
                }
                GLES20.glUseProgram(((a)localObject4).mProgramHandle);
                GLES20.glVertexAttribPointer(((a)localObject4).mPj, 3, 5126, false, 0, (Buffer)localObject5);
                GLES20.glVertexAttribPointer(((a)localObject4).mPm, 2, 5126, false, 0, (Buffer)localObject6);
                GLES20.glUniformMatrix4fv(((a)localObject4).mPl, 1, false, (float[])localObject7, 0);
                GLES20.glActiveTexture(33984);
                GLES20.glBindTexture(3553, paramMessage.textureId);
                GLES20.glUniform1i(((a)localObject4).mPk, 0);
                if (((a)localObject4).mPy.beJ() == null) {
                  break label3110;
                }
                ((a)localObject4).mPy.beJ().position(0);
                GLES20.glDrawElements(4, localObject4.mPy.mQP[0], 5123, ((a)localObject4).mPy.beJ());
              }
              for (;;)
              {
                GLES20.glBindTexture(3553, 0);
                break;
                i = 0;
                break label2374;
                label3008:
                ((com.tencent.mm.live.core.core.d.a.a.a)localObject5).mViewWidth = j;
                ((com.tencent.mm.live.core.core.d.a.a.a)localObject5).mViewHeight = k;
                f1 = Math.min(Math.max(35.0F, 20.0F), 65.0F);
                f3 = k / j;
                f2 = (float)Math.tan(f1 / 180.0F * 3.141593F);
                f3 *= f2;
                ((com.tencent.mm.live.core.core.d.a.a.a)localObject5).o(-f2, f2, -f3, f3);
                ((com.tencent.mm.live.core.core.d.a.a.a)localObject5).mQl = f1;
                ((com.tencent.mm.live.core.core.d.a.a.a)localObject5).mQm = ((float)Math.atan(f3) / 3.141593F * 180.0F);
                break label2506;
                label3110:
                GLES20.glDrawArrays(4, 0, localObject4.mPy.mQP[0]);
              }
              label3128:
              localObject4 = this.mPK;
              localObject5 = ((a)localObject4).beG();
              GLES20.glViewport(0, 0, ((Size)localObject5).getWidth(), ((Size)localObject5).getHeight());
              GLES20.glBindFramebuffer(36160, 0);
              GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
              GLES20.glClear(16640);
              GLES20.glUseProgram(((a)localObject4).mProgramHandle);
              GLES20.glVertexAttribPointer(((a)localObject4).mPj, 2, 5126, false, 0, ((a)localObject4).mPositoins);
              GLES20.glVertexAttribPointer(((a)localObject4).mPm, 2, 5126, false, 0, ((a)localObject4).mTexcoords);
              GLES20.glActiveTexture(33984);
              GLES20.glBindTexture(3553, paramMessage.textureId);
              GLES20.glUniform1i(((a)localObject4).mPk, 0);
              GLES20.glDrawArrays(5, 0, 4);
              GLES20.glBindTexture(3553, 0);
            }
          }
        }
        if ((this.mPK != null) && (this.mPK.mPt))
        {
          this.mPK.makeCurrent();
          if (this.mPH != null)
          {
            paramMessage = this.mPH;
            if (paramMessage.mRa != null)
            {
              localObject4 = paramMessage.mRa;
              if (localObject4.mFrameBuffer[0] != 0)
              {
                GLES20.glDeleteFramebuffers(1, ((com.tencent.mm.live.core.core.d.b.b)localObject4).mFrameBuffer, 0);
                ((com.tencent.mm.live.core.core.d.b.b)localObject4).mFrameBuffer[0] = 0;
              }
              if (localObject4.mTextureid[0] != 0)
              {
                GLES20.glDeleteTextures(1, ((com.tencent.mm.live.core.core.d.b.b)localObject4).mTextureid, 0);
                ((com.tencent.mm.live.core.core.d.b.b)localObject4).mTextureid[0] = 0;
              }
              if (((com.tencent.mm.live.core.core.d.b.b)localObject4).mProgramHandle != 0)
              {
                GLES20.glDeleteProgram(((com.tencent.mm.live.core.core.d.b.b)localObject4).mProgramHandle);
                ((com.tencent.mm.live.core.core.d.b.b)localObject4).mProgramHandle = 0;
              }
              paramMessage.mRa = null;
            }
            if (paramMessage.mRb != null)
            {
              localObject4 = paramMessage.mRb;
              if (localObject4.mFrameBuffer[0] != 0)
              {
                GLES20.glDeleteFramebuffers(1, ((com.tencent.mm.live.core.core.d.b.d)localObject4).mFrameBuffer, 0);
                ((com.tencent.mm.live.core.core.d.b.d)localObject4).mFrameBuffer[0] = 0;
              }
              if (localObject4.mTextureid[0] != 0)
              {
                GLES20.glDeleteTextures(1, ((com.tencent.mm.live.core.core.d.b.d)localObject4).mTextureid, 0);
                ((com.tencent.mm.live.core.core.d.b.d)localObject4).mTextureid[0] = 0;
              }
              if (((com.tencent.mm.live.core.core.d.b.d)localObject4).mProgramHandle != 0)
              {
                GLES20.glDeleteProgram(((com.tencent.mm.live.core.core.d.b.d)localObject4).mProgramHandle);
                ((com.tencent.mm.live.core.core.d.b.d)localObject4).mProgramHandle = 0;
              }
              paramMessage.mRb = null;
            }
            if (paramMessage.mRc != null)
            {
              paramMessage.mRc.destroyBuffers();
              paramMessage.mRc = null;
            }
            this.mPH = null;
          }
          this.mPK.beF();
          this.mPK = null;
        }
        Log.i("CustomRender.CustomRender", "MSG_DESTROY");
      }
    }
  }
  
  public final void onRenderVideoFrame(TXLivePlayer.TXLiteAVTexture paramTXLiteAVTexture)
  {
    AppMethodBeat.i(248188);
    int i = paramTXLiteAVTexture.width;
    int j = paramTXLiteAVTexture.height;
    if ((this.mVideoWidth != i) || (this.mVideoHeight != j))
    {
      this.mVideoWidth = i;
      this.mVideoHeight = j;
      if ((this.mPG != null) && (this.mPQ != 1)) {
        this.mPG.setVideoSize(this.mVideoWidth, this.mVideoHeight);
      }
    }
    GLES20.glFinish();
    this.mPE.obtainMessage(2, paramTXLiteAVTexture).sendToTarget();
    AppMethodBeat.o(248188);
  }
  
  public final void sT(int paramInt)
  {
    AppMethodBeat.i(248163);
    this.mPQ = paramInt;
    this.mPN = false;
    if (this.mPQ == 1)
    {
      Object localObject2 = this.mPK;
      Object localObject1 = this.mContext;
      if (((a)localObject2).mPy == null) {
        ((a)localObject2).mPy = new com.tencent.mm.live.core.core.d.a.a.b();
      }
      if (((a)localObject2).mPz == null) {
        ((a)localObject2).mPz = new com.tencent.mm.live.core.core.d.a.a.a((Context)localObject1);
      }
      Object localObject3 = ((a)localObject2).mPy;
      paramInt = (((com.tencent.mm.live.core.core.d.a.a.b)localObject3).mQM + 1) * (((com.tencent.mm.live.core.core.d.a.a.b)localObject3).mQN + 1);
      Object localObject6 = new float[paramInt * 3];
      Object localObject5 = new float[paramInt * 2];
      short[] arrayOfShort = new short[paramInt * 6];
      int k = 0;
      int j = 0;
      double d1 = 6.283185307179586D / ((com.tencent.mm.live.core.core.d.a.a.b)localObject3).mQN;
      double d2 = 3.141592653589793D / ((com.tencent.mm.live.core.core.d.a.a.b)localObject3).mQM;
      double d3 = 1.0F / ((com.tencent.mm.live.core.core.d.a.a.b)localObject3).mQN;
      double d4 = 1.0F / ((com.tencent.mm.live.core.core.d.a.a.b)localObject3).mQM;
      paramInt = 0;
      while (paramInt <= ((com.tencent.mm.live.core.core.d.a.a.b)localObject3).mQM)
      {
        i = 0;
        while (i <= ((com.tencent.mm.live.core.core.d.a.a.b)localObject3).mQN)
        {
          localObject5[(k + 0)] = ((float)(i * d3));
          localObject5[(k + 1)] = ((float)(paramInt * d4));
          localObject6[(j + 0)] = ((float)(Math.sin(paramInt * d2) * Math.cos(i * d1 - 3.141592653589793D)) * ((com.tencent.mm.live.core.core.d.a.a.b)localObject3).mQO);
          localObject6[(j + 1)] = ((float)Math.cos(paramInt * d2) * ((com.tencent.mm.live.core.core.d.a.a.b)localObject3).mQO);
          localObject6[(j + 2)] = ((float)(Math.sin(paramInt * d2) * Math.sin(i * d1 - 3.141592653589793D)) * ((com.tencent.mm.live.core.core.d.a.a.b)localObject3).mQO);
          k += 2;
          j += 3;
          i += 1;
        }
        paramInt += 1;
      }
      k = ((com.tencent.mm.live.core.core.d.a.a.b)localObject3).mQN + 1;
      paramInt = 0;
      int i = 0;
      while (paramInt < ((com.tencent.mm.live.core.core.d.a.a.b)localObject3).mQM)
      {
        j = 0;
        while (j < ((com.tencent.mm.live.core.core.d.a.a.b)localObject3).mQN)
        {
          arrayOfShort[(i + 0)] = ((short)(paramInt * k + j));
          arrayOfShort[(i + 1)] = ((short)((paramInt + 1) * k + j));
          arrayOfShort[(i + 2)] = ((short)((paramInt + 1) * k + j + 1));
          arrayOfShort[(i + 3)] = ((short)((paramInt + 1) * k + j + 1));
          arrayOfShort[(i + 4)] = ((short)(paramInt * k + j + 1));
          arrayOfShort[(i + 5)] = ((short)(paramInt * k + j));
          i += 6;
          j += 1;
        }
        paramInt += 1;
      }
      Object localObject4 = ByteBuffer.allocateDirect(localObject6.length * 4);
      ((ByteBuffer)localObject4).order(ByteOrder.nativeOrder());
      localObject4 = ((ByteBuffer)localObject4).asFloatBuffer();
      ((FloatBuffer)localObject4).put((float[])localObject6);
      ((FloatBuffer)localObject4).position(0);
      localObject6 = ByteBuffer.allocateDirect(localObject5.length * 4);
      ((ByteBuffer)localObject6).order(ByteOrder.nativeOrder());
      localObject6 = ((ByteBuffer)localObject6).asFloatBuffer();
      ((FloatBuffer)localObject6).put((float[])localObject5);
      ((FloatBuffer)localObject6).position(0);
      localObject5 = ByteBuffer.allocateDirect(arrayOfShort.length * 2);
      ((ByteBuffer)localObject5).order(ByteOrder.nativeOrder());
      localObject5 = ((ByteBuffer)localObject5).asShortBuffer();
      ((ShortBuffer)localObject5).put(arrayOfShort);
      ((ShortBuffer)localObject5).position(0);
      ((com.tencent.mm.live.core.core.d.a.a.b)localObject3).a(0, (ShortBuffer)localObject5);
      ((com.tencent.mm.live.core.core.d.a.a.b)localObject3).a(1, (ShortBuffer)localObject5);
      ((com.tencent.mm.live.core.core.d.a.a.b)localObject3).mQP[0] = i;
      ((com.tencent.mm.live.core.core.d.a.a.b)localObject3).mQP[1] = i;
      ((com.tencent.mm.live.core.core.d.a.a.b)localObject3).c(0, (FloatBuffer)localObject6);
      ((com.tencent.mm.live.core.core.d.a.a.b)localObject3).c(1, (FloatBuffer)localObject6);
      ((com.tencent.mm.live.core.core.d.a.a.b)localObject3).b(0, (FloatBuffer)localObject4);
      ((com.tencent.mm.live.core.core.d.a.a.b)localObject3).b(1, (FloatBuffer)localObject4);
      localObject3 = ((a)localObject2).mPz;
      ((com.tencent.mm.live.core.core.d.a.a.a)localObject3).hbX = 0.0F;
      ((com.tencent.mm.live.core.core.d.a.a.a)localObject3).hbY = 0.0F;
      android.opengl.Matrix.setIdentityM(((com.tencent.mm.live.core.core.d.a.a.a)localObject3).mQe, 0);
      android.opengl.Matrix.setIdentityM(((com.tencent.mm.live.core.core.d.a.a.a)localObject3).mQb, 0);
      android.opengl.Matrix.setLookAtM(((com.tencent.mm.live.core.core.d.a.a.a)localObject3).mQc, 0, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F);
      ((com.tencent.mm.live.core.core.d.a.a.a)localObject3).mQw = 0.0F;
      ((com.tencent.mm.live.core.core.d.a.a.a)localObject3).mQv = false;
      ((com.tencent.mm.live.core.core.d.a.a.a)localObject3).mQx = 0;
      ((com.tencent.mm.live.core.core.d.a.a.a)localObject3).mQy = 0;
      ((com.tencent.mm.live.core.core.d.a.a.a)localObject3).pitch = 0.0F;
      ((com.tencent.mm.live.core.core.d.a.a.a)localObject3).yaw = 0.0F;
      localObject2 = ((a)localObject2).mPz;
      if (!((com.tencent.mm.live.core.core.d.a.a.a)localObject2).mQr)
      {
        ((com.tencent.mm.live.core.core.d.a.a.a)localObject2).windowManager = ((WindowManager)((Context)localObject1).getSystemService("window"));
        localObject1 = (SensorManager)((Context)localObject1).getSystemService("sensor");
        localObject3 = ((SensorManager)localObject1).getDefaultSensor(4);
        if (localObject3 != null)
        {
          ((com.tencent.mm.live.core.core.d.a.a.a)localObject2).mQu = new a.2((com.tencent.mm.live.core.core.d.a.a.a)localObject2);
          ((SensorManager)localObject1).registerListener(((com.tencent.mm.live.core.core.d.a.a.a)localObject2).mQu, (Sensor)localObject3, 1);
          ((com.tencent.mm.live.core.core.d.a.a.a)localObject2).mQr = true;
        }
      }
    }
    for (;;)
    {
      if (this.mPQ == 2) {
        this.mPC = true;
      }
      AppMethodBeat.o(248163);
      return;
      this.mPK.dA(this.mContext);
    }
  }
  
  public final void setPlayerView(TXCloudVideoView paramTXCloudVideoView)
  {
    AppMethodBeat.i(248175);
    if ((this.mPF != null) && (this.mPF != paramTXCloudVideoView))
    {
      TextureView localTextureView = this.mPF.getVideoView();
      if (localTextureView != null) {
        this.mPF.removeView(localTextureView);
      }
    }
    if (((this.mPF == null) && (paramTXCloudVideoView != null)) || ((this.mPF != null) && (!this.mPF.equals(paramTXCloudVideoView)))) {
      this.mPP = false;
    }
    this.mPF = paramTXCloudVideoView;
    if (this.mPF != null)
    {
      this.eDa = this.mPF.getVideoView();
      if (this.eDa == null) {
        this.eDa = new TextureView(this.mPF.getContext());
      }
      this.eDa.setTransform(new android.graphics.Matrix());
      this.eDa.setScaleX(1.0F);
      this.eDa.setScaleY(1.0F);
      this.eDa.setRotation(0.0F);
      this.mPF.addVideoView(this.eDa);
    }
    if ((this.eDa != null) && (this.mPI == null)) {
      this.eDa.setSurfaceTextureListener(null);
    }
    if ((this.eDa.getWidth() != 0) && (this.eDa.getHeight() != 0))
    {
      this.mSurfaceTexture = this.eDa.getSurfaceTexture();
      this.mViewWidth = this.eDa.getWidth();
      this.mViewHeight = this.eDa.getHeight();
    }
    if ((this.eDa != null) && (this.mPQ != 1))
    {
      this.mViewWidth = this.eDa.getWidth();
      this.mViewHeight = this.eDa.getHeight();
      this.mPG = new e(this.eDa);
      this.mPG.setVideoSize(this.mVideoWidth, this.mVideoHeight);
      this.mPG.ef(this.mViewWidth, this.mViewHeight);
      this.mPG.setRenderMode(this.mRenderMode);
      this.mPG.setRenderRotation(this.mRenderRotation % 360);
    }
    this.eDa.setSurfaceTextureListener(new TextureView.SurfaceTextureListener()
    {
      public final void onSurfaceTextureAvailable(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(248083);
        if (c.a(c.this) != null)
        {
          if ((Build.VERSION.SDK_INT >= 16) && (c.b(c.this).getSurfaceTexture() != c.a(c.this))) {
            c.b(c.this).setSurfaceTexture(c.a(c.this));
          }
          c.a(c.this, c.a(c.this));
          c.b(c.this, null);
        }
        for (;;)
        {
          c.this.ef(paramAnonymousInt1, paramAnonymousInt2);
          Log.i("CustomRender.CustomRender", "onSurfaceTextureAvailable " + c.this.mViewWidth + " " + c.this.mViewHeight);
          AppMethodBeat.o(248083);
          return;
          c.a(c.this, paramAnonymousSurfaceTexture);
        }
      }
      
      public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramAnonymousSurfaceTexture)
      {
        AppMethodBeat.i(248094);
        if (c.c(c.this)) {
          c.b(c.this, paramAnonymousSurfaceTexture);
        }
        for (;;)
        {
          Log.i("CustomRender.CustomRender", "onSurfaceTextureDestroyed");
          if (c.a(c.this) != null) {
            break;
          }
          AppMethodBeat.o(248094);
          return true;
          c.a(c.this, null);
        }
        AppMethodBeat.o(248094);
        return false;
      }
      
      public final void onSurfaceTextureSizeChanged(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(248088);
        c.this.ef(paramAnonymousInt1, paramAnonymousInt2);
        Log.i("CustomRender.CustomRender", "onSurfaceTextureSizeChanged " + c.this.mViewWidth + " " + c.this.mViewHeight);
        AppMethodBeat.o(248088);
      }
      
      public final void onSurfaceTextureUpdated(SurfaceTexture paramAnonymousSurfaceTexture) {}
    });
    if (this.mPI != null)
    {
      if ((Build.VERSION.SDK_INT >= 16) && (this.eDa.getSurfaceTexture() != this.mPI))
      {
        Log.i("CustomRender.CustomRender", "setSurfaceTexture " + this.eDa + ", surfaceTexture " + this.mPI);
        try
        {
          this.eDa.setSurfaceTexture(this.mPI);
          this.mSurfaceTexture = this.mPI;
          AppMethodBeat.o(248175);
          return;
        }
        catch (Exception paramTXCloudVideoView)
        {
          for (;;)
          {
            Log.i("CustomRender.CustomRender", "setSurfaceTexture error ".concat(String.valueOf(paramTXCloudVideoView)));
          }
        }
      }
      Log.i("CustomRender.CustomRender", "not setSurfaceTexture old surfaceTexture " + this.eDa.getSurfaceTexture() + ", new surfaceTexture " + this.mPI);
    }
    AppMethodBeat.o(248175);
  }
  
  public static final class a
    extends Handler
  {
    public a(Looper paramLooper, Handler.Callback paramCallback)
    {
      super(paramCallback);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.core.core.d.a.c
 * JD-Core Version:    0.7.0.1
 */