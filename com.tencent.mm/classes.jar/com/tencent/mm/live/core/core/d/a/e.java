package com.tencent.mm.live.core.core.d.a;

import android.content.Context;
import android.graphics.Matrix;
import android.os.Handler;
import android.os.Looper;
import android.view.TextureView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class e
{
  private Handler mMainHandler;
  int mPU;
  int mPV;
  int mPW;
  int mPX;
  private float mPY;
  int mVideoHeight;
  TextureView mVideoView;
  int mVideoWidth;
  int mViewHeight;
  int mViewWidth;
  
  public e(TextureView paramTextureView)
  {
    AppMethodBeat.i(248086);
    this.mViewWidth = 0;
    this.mViewHeight = 0;
    this.mVideoWidth = 640;
    this.mVideoHeight = 480;
    this.mPU = 0;
    this.mPV = 0;
    this.mPW = 1;
    this.mPX = 0;
    this.mPY = 1.0F;
    this.mVideoView = paramTextureView;
    this.mViewWidth = paramTextureView.getWidth();
    this.mViewHeight = paramTextureView.getHeight();
    this.mMainHandler = new Handler(paramTextureView.getContext().getMainLooper());
    AppMethodBeat.o(248086);
  }
  
  private void beH()
  {
    AppMethodBeat.i(248093);
    try
    {
      Runnable local3 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(248082);
          e locale = e.this;
          int i = e.this.mVideoWidth;
          int j = e.this.mVideoHeight;
          if ((locale.mVideoView == null) || (i == 0) || (j == 0)) {}
          while ((locale.mViewWidth == 0) || (locale.mViewHeight == 0))
          {
            e.this.sU(e.this.mPW);
            e.this.sV(e.this.mPX);
            AppMethodBeat.o(248082);
            return;
          }
          double d = j / i;
          if (locale.mViewHeight > (int)(locale.mViewWidth * d)) {
            locale.mPU = locale.mViewWidth;
          }
          for (locale.mPV = ((int)(d * locale.mViewWidth));; locale.mPV = locale.mViewHeight)
          {
            float f1 = (locale.mViewWidth - locale.mPU) / 2.0F;
            float f2 = (locale.mViewHeight - locale.mPV) / 2.0F;
            float f3 = locale.mPU / locale.mViewWidth;
            float f4 = locale.mPV / locale.mViewHeight;
            Matrix localMatrix = new Matrix();
            locale.mVideoView.getTransform(localMatrix);
            localMatrix.setScale(f3, f4);
            localMatrix.postTranslate(f1, f2);
            locale.mVideoView.setTransform(localMatrix);
            locale.mVideoView.requestLayout();
            break;
            locale.mPU = ((int)(locale.mViewHeight / d));
          }
        }
      };
      if (Looper.getMainLooper() == Looper.myLooper())
      {
        local3.run();
        AppMethodBeat.o(248093);
        return;
      }
      this.mMainHandler.post(local3);
      AppMethodBeat.o(248093);
      return;
    }
    catch (Exception localException)
    {
      Log.e("CustomTextureViewWrapper", "adjust video size failed.", new Object[] { localException });
      AppMethodBeat.o(248093);
    }
  }
  
  public final void ef(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(248142);
    Log.w("CustomTextureViewWrapper", "vrender: set view size:" + paramInt1 + "," + paramInt2);
    this.mViewWidth = paramInt1;
    this.mViewHeight = paramInt2;
    beH();
    AppMethodBeat.o(248142);
  }
  
  public final void sU(int paramInt)
  {
    float f2 = 1.0F;
    AppMethodBeat.i(248113);
    this.mPW = paramInt;
    float f1;
    if (this.mVideoView != null)
    {
      if (paramInt != 1) {
        break label170;
      }
      f1 = f2;
      if (this.mPX != 0)
      {
        if (this.mPX != 180) {
          break label89;
        }
        f1 = f2;
      }
    }
    label170:
    for (;;)
    {
      f2 = f1;
      if (this.mPY < 0.0F) {
        f2 = -f1;
      }
      this.mVideoView.setScaleX(f2);
      this.mVideoView.setScaleY(Math.abs(f2));
      this.mPY = f2;
      AppMethodBeat.o(248113);
      return;
      label89:
      if (this.mPX != 270)
      {
        f1 = f2;
        if (this.mPX != 90) {}
      }
      else
      {
        if ((this.mPU == 0) || (this.mPV == 0))
        {
          AppMethodBeat.o(248113);
          return;
        }
        f2 = this.mViewHeight / this.mPU;
        float f3 = this.mViewWidth / this.mPV;
        f1 = f3;
        if (f2 <= f3)
        {
          f1 = f2;
          continue;
          f1 = f2;
          if (paramInt == 0)
          {
            if ((this.mPU == 0) || (this.mPV == 0))
            {
              AppMethodBeat.o(248113);
              return;
            }
            if ((this.mPX == 0) || (this.mPX == 180))
            {
              f2 = this.mViewHeight / this.mPV;
              f3 = this.mViewWidth / this.mPU;
              f1 = f3;
              if (f2 >= f3) {
                f1 = f2;
              }
            }
            else if (this.mPX != 270)
            {
              f1 = f2;
              if (this.mPX != 90) {}
            }
            else
            {
              f2 = this.mViewHeight / this.mPU;
              f3 = this.mViewWidth / this.mPV;
              f1 = f3;
              if (f2 >= f3) {
                f1 = f2;
              }
            }
          }
        }
      }
    }
  }
  
  public final void sV(int paramInt)
  {
    float f4 = 1.0F;
    AppMethodBeat.i(248129);
    paramInt %= 360;
    this.mPX = paramInt;
    float f1;
    if (this.mVideoView != null)
    {
      if ((paramInt != 0) && (paramInt != 180)) {
        break label172;
      }
      this.mVideoView.setRotation(360 - paramInt);
      if (this.mPW != 1) {
        break label104;
      }
      f1 = 1.0F;
    }
    for (;;)
    {
      float f2 = f1;
      if (this.mPY < 0.0F) {
        f2 = -f1;
      }
      this.mVideoView.setScaleX(f2);
      this.mVideoView.setScaleY(Math.abs(f2));
      this.mPY = f2;
      AppMethodBeat.o(248129);
      return;
      label104:
      f1 = f4;
      if (this.mPW == 0)
      {
        if ((this.mPU == 0) || (this.mPV == 0))
        {
          AppMethodBeat.o(248129);
          return;
        }
        f1 = this.mViewHeight / this.mPV;
        f2 = this.mViewWidth / this.mPU;
        if (f1 < f2) {
          f1 = f2;
        }
        for (;;)
        {
          break;
        }
        label172:
        if (paramInt != 270)
        {
          f1 = f4;
          if (paramInt != 90) {}
        }
        else
        {
          if ((this.mPU == 0) || (this.mPV == 0))
          {
            AppMethodBeat.o(248129);
            return;
          }
          this.mVideoView.setRotation(360 - paramInt);
          f2 = this.mViewHeight / this.mPU;
          float f3 = this.mViewWidth / this.mPV;
          if (this.mPW == 1)
          {
            if (f2 > f3) {}
            for (f1 = f3;; f1 = f2) {
              break;
            }
          }
          f1 = f4;
          if (this.mPW == 0)
          {
            f1 = f3;
            if (f2 >= f3) {
              f1 = f2;
            }
          }
        }
      }
    }
  }
  
  public final void setRenderMode(final int paramInt)
  {
    AppMethodBeat.i(248101);
    try
    {
      this.mMainHandler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(248076);
          e.this.sU(paramInt);
          AppMethodBeat.o(248076);
        }
      });
      AppMethodBeat.o(248101);
      return;
    }
    catch (Exception localException)
    {
      Log.e("CustomTextureViewWrapper", "set render mode failed", new Object[] { localException });
      AppMethodBeat.o(248101);
    }
  }
  
  public final void setRenderRotation(final int paramInt)
  {
    AppMethodBeat.i(248119);
    try
    {
      this.mMainHandler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(248063);
          e.this.sV(paramInt);
          AppMethodBeat.o(248063);
        }
      });
      AppMethodBeat.o(248119);
      return;
    }
    catch (Exception localException)
    {
      Log.e("CustomTextureViewWrapper", "set render rotation failed.", new Object[] { localException });
      AppMethodBeat.o(248119);
    }
  }
  
  public final void setVideoSize(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(248150);
    Log.w("CustomTextureViewWrapper", "vrender: set video size:" + paramInt1 + "," + paramInt2);
    this.mVideoWidth = paramInt1;
    this.mVideoHeight = paramInt2;
    beH();
    AppMethodBeat.o(248150);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.core.core.d.a.e
 * JD-Core Version:    0.7.0.1
 */