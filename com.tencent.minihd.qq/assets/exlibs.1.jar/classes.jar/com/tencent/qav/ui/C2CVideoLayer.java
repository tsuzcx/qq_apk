package com.tencent.qav.ui;

import android.content.Context;
import android.graphics.Rect;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.tencent.av.camera.CameraObserver;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.opengl.ui.GLVideoView;
import com.tencent.av.opengl.ui.GLView;
import com.tencent.av.opengl.ui.GLView.OnTouchListener;
import com.tencent.av.opengl.ui.GLViewGroup;
import com.tencent.av.opengl.ui.animation.GLAnimation;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.av.utils.UITools;
import com.tencent.qav.QavSDK;
import com.tencent.qav.bussiness.QavBussinessCtrl;
import com.tencent.qav.log.AVLog;
import com.tencent.qav.session.QavSession;
import ljy;
import ljz;
import lka;

public class C2CVideoLayer
  extends GLViewGroup
  implements GLView.OnTouchListener
{
  private static final String jdField_a_of_type_JavaLangString = "C2CVideoLayer";
  private Context jdField_a_of_type_AndroidContentContext;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private CameraObserver jdField_a_of_type_ComTencentAvCameraCameraObserver = new ljy(this);
  private VideoControlUI jdField_a_of_type_ComTencentAvUiVideoControlUI;
  private C2CVideoView jdField_a_of_type_ComTencentQavUiC2CVideoView;
  private boolean jdField_a_of_type_Boolean;
  private C2CVideoView b;
  
  public C2CVideoLayer(Context paramContext, VideoControlUI paramVideoControlUI)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentAvUiVideoControlUI = paramVideoControlUI;
    c();
    d();
    QavSDK.getInstance().addObserver(this.jdField_a_of_type_ComTencentAvCameraCameraObserver);
  }
  
  private void a(GLVideoView paramGLVideoView1, GLVideoView paramGLVideoView2)
  {
    int i = UITools.getScreenWidth(this.jdField_a_of_type_AndroidContentContext);
    int j = UITools.getScreenHeight(this.jdField_a_of_type_AndroidContentContext);
    int k = (int)UITools.dp2px(this.jdField_a_of_type_AndroidContentContext, 88.0F);
    int m = (int)UITools.dp2px(this.jdField_a_of_type_AndroidContentContext, 135.0F);
    int n = (int)UITools.dp2px(this.jdField_a_of_type_AndroidContentContext, 10.0F);
    int i1 = (int)UITools.dp2px(this.jdField_a_of_type_AndroidContentContext, 10.0F);
    i1 = (int)UITools.dp2px(this.jdField_a_of_type_AndroidContentContext, 1.0F);
    paramGLVideoView1.layout(i - k - n, j - m - (int)UITools.dp2px(this.jdField_a_of_type_AndroidContentContext, 144.0F), i - n, j - (int)UITools.dp2px(this.jdField_a_of_type_AndroidContentContext, 144.0F));
    paramGLVideoView1.setPaddings(i1, i1, i1, i1);
    paramGLVideoView1.setBackgroundColor(-15197410);
    paramGLVideoView1.setZOrder(1);
    paramGLVideoView2.layout(0, 0, i, j);
    paramGLVideoView1.setPaddings(0, 0, 0, 0);
    paramGLVideoView2.setBackgroundColor(-15197410);
    paramGLVideoView2.setZOrder(0);
  }
  
  private void b(GLVideoView paramGLVideoView1, GLVideoView paramGLVideoView2)
  {
    if ((paramGLVideoView1 == null) || (paramGLVideoView2 == null) || (paramGLVideoView1 == paramGLVideoView2)) {
      return;
    }
    Rect localRect1 = paramGLVideoView1.getBounds();
    Rect localRect2 = paramGLVideoView2.getBounds();
    GLAnimation localGLAnimation = new GLAnimation();
    localGLAnimation.setDuration(300);
    localGLAnimation.setSpeedType(2);
    localGLAnimation.setTranslate(localRect1.left, localRect1.top, 0.0F, localRect2.left, localRect2.top, 0.0F);
    localGLAnimation.setScale(localRect1.width(), localRect1.height(), localRect2.width(), localRect2.height());
    localGLAnimation.setAnimationListener(new lka(this, paramGLVideoView2, paramGLVideoView1));
    paramGLVideoView1.startAnimation(localGLAnimation);
    paramGLVideoView1.invalidate();
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentQavUiC2CVideoView = new C2CVideoView(this.jdField_a_of_type_AndroidContentContext);
    this.b = new C2CVideoView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentQavUiC2CVideoView.setVisibility(1);
    this.b.setVisibility(1);
    addView(this.jdField_a_of_type_ComTencentQavUiC2CVideoView);
    addView(this.b);
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_Boolean)
    {
      a(this.jdField_a_of_type_ComTencentQavUiC2CVideoView, this.b);
      return;
    }
    a(this.b, this.jdField_a_of_type_ComTencentQavUiC2CVideoView);
  }
  
  private void d()
  {
    setOnTouchListener(this);
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this.jdField_a_of_type_AndroidContentContext, new ljz(this));
  }
  
  public void a()
  {
    QavSDK.getInstance().removeObserver(this.jdField_a_of_type_ComTencentAvCameraCameraObserver);
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentQavUiC2CVideoView.setSelfUin(paramString1);
    this.jdField_a_of_type_ComTencentQavUiC2CVideoView.setInfo(paramString1, 1);
    this.b.setSelfUin(paramString1);
    this.b.setInfo(paramString2, 1);
  }
  
  public void a(boolean paramBoolean)
  {
    AVLog.d("C2CVideoLayer", String.format("setRemoteHasVideo hasVideo=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    this.b.setNeedRenderVideo(paramBoolean);
    QavSession localQavSession;
    if (paramBoolean)
    {
      this.b.a();
      this.b.setVisibility(0);
      localQavSession = QavBussinessCtrl.a().a();
      if (localQavSession != null)
      {
        if ((!localQavSession.f) || (localQavSession.h)) {
          break label109;
        }
        this.jdField_a_of_type_Boolean = false;
        a(this.b, this.jdField_a_of_type_ComTencentQavUiC2CVideoView);
      }
    }
    label109:
    while ((localQavSession.f) || (!localQavSession.h))
    {
      return;
      this.b.b();
      this.b.setVisibility(1);
      break;
    }
    this.jdField_a_of_type_Boolean = true;
    a(this.jdField_a_of_type_ComTencentQavUiC2CVideoView, this.b);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AVLog.d("C2CVideoLayer", String.format("setLocalHasVideo hasVideo=%s onlyPreview=%s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) }));
    this.jdField_a_of_type_ComTencentQavUiC2CVideoView.setNeedRenderVideo(paramBoolean1);
    QavSession localQavSession;
    if (paramBoolean1)
    {
      this.jdField_a_of_type_ComTencentQavUiC2CVideoView.a(paramBoolean2);
      this.jdField_a_of_type_ComTencentQavUiC2CVideoView.setVisibility(0);
      paramBoolean2 = CameraUtils.getInstance(this.jdField_a_of_type_AndroidContentContext).isFrontCamera();
      this.jdField_a_of_type_ComTencentQavUiC2CVideoView.setMirror(paramBoolean2);
      localQavSession = QavBussinessCtrl.a().a();
      if ((localQavSession != null) && (!paramBoolean3))
      {
        localQavSession.f = paramBoolean1;
        if (!paramBoolean1) {
          break label174;
        }
        localQavSession.c = false;
        localQavSession.a = 2;
        if ((!localQavSession.f) || (localQavSession.h)) {
          break label222;
        }
        this.jdField_a_of_type_Boolean = false;
        a(this.b, this.jdField_a_of_type_ComTencentQavUiC2CVideoView);
      }
    }
    label174:
    label184:
    label216:
    label222:
    while ((localQavSession.f) || (!localQavSession.h))
    {
      return;
      this.jdField_a_of_type_ComTencentQavUiC2CVideoView.b();
      this.jdField_a_of_type_ComTencentQavUiC2CVideoView.setVisibility(1);
      this.jdField_a_of_type_ComTencentQavUiC2CVideoView.setMirror(false);
      break;
      if (!localQavSession.h)
      {
        paramBoolean1 = true;
        localQavSession.c = paramBoolean1;
        if (!localQavSession.c) {
          break label216;
        }
      }
      for (int i = 1;; i = 2)
      {
        localQavSession.a = i;
        break;
        paramBoolean1 = false;
        break label184;
      }
    }
    this.jdField_a_of_type_Boolean = true;
    a(this.jdField_a_of_type_ComTencentQavUiC2CVideoView, this.b);
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentQavUiC2CVideoView.c();
  }
  
  public boolean onTouch(GLView paramGLView, MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_AndroidViewGestureDetector != null) {
      this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.qav.ui.C2CVideoLayer
 * JD-Core Version:    0.7.0.1
 */