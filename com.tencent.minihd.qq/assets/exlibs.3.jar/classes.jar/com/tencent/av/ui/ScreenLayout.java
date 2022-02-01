package com.tencent.av.ui;

import android.content.Context;
import android.graphics.Rect;
import com.tencent.av.opengl.ui.GLVideoView;
import com.tencent.qav.app.QavAppInterface;
import com.tencent.qav.session.QavSession;
import com.tencent.qphone.base.util.QLog;

public abstract class ScreenLayout
{
  Context jdField_a_of_type_AndroidContentContext;
  QavAppInterface jdField_a_of_type_ComTencentQavAppQavAppInterface;
  
  protected ScreenLayout(Context paramContext, QavAppInterface paramQavAppInterface)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentQavAppQavAppInterface = paramQavAppInterface;
    QLog.d("ScreenLayout", 1, "ScreenLayout. onCreate." + this);
  }
  
  public static ScreenLayout a(Context paramContext, QavAppInterface paramQavAppInterface, int paramInt, boolean paramBoolean)
  {
    return null;
  }
  
  public abstract int a();
  
  public void a()
  {
    QLog.d("ScreenLayout", 1, "ScreenLayout. onDestroy." + this);
    this.jdField_a_of_type_AndroidContentContext = null;
  }
  
  public void a(int paramInt, Rect paramRect1, Rect paramRect2) {}
  
  public void a(QavSession paramQavSession, GLVideoView[] paramArrayOfGLVideoView, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4) {}
  
  public void a(GLVideoView[] paramArrayOfGLVideoView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {}
  
  public void a(GLVideoView[] paramArrayOfGLVideoView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean) {}
  
  public abstract boolean a();
  
  public boolean b()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.av.ui.ScreenLayout
 * JD-Core Version:    0.7.0.1
 */