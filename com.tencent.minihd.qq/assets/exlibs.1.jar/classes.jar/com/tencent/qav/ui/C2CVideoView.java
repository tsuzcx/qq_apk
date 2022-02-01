package com.tencent.qav.ui;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.av.opengl.ui.GLVideoView;
import com.tencent.qav.QavSDK;
import com.tencent.qav.controller.QavCtrl;
import com.tencent.qav.controller.c2c.IC2COperator;
import com.tencent.qav.log.AVLog;

public class C2CVideoView
  extends GLVideoView
{
  private static int jdField_a_of_type_Int = 0;
  private static final String jdField_a_of_type_JavaLangString = "C2CVideoView";
  private IC2COperator jdField_a_of_type_ComTencentQavControllerC2cIC2COperator = QavSDK.getInstance().getC2COperator();
  private String b;
  
  static
  {
    try
    {
      IC2COperator localIC2COperator = QavSDK.getInstance().getC2COperator();
      if (localIC2COperator != null) {
        jdField_a_of_type_Int = localIC2COperator.getFrameRenderEndFunctionPtr();
      }
      return;
    }
    catch (Exception localException)
    {
      AVLog.e("C2CVideoView", "C2CVideoView init sRenderEndPtr fail.", localException);
    }
  }
  
  public C2CVideoView(Context paramContext)
  {
    super(paramContext, jdField_a_of_type_Int);
  }
  
  private boolean a()
  {
    String str = getUin();
    return (!TextUtils.isEmpty(this.mSelfUin)) && (this.mSelfUin.equals(str));
  }
  
  public String a()
  {
    return this.b;
  }
  
  public void a()
  {
    a(false);
  }
  
  public void a(boolean paramBoolean)
  {
    try
    {
      if (a())
      {
        this.jdField_a_of_type_ComTencentQavControllerC2cIC2COperator.startLocalPreview(true, this);
        if (!paramBoolean) {
          this.jdField_a_of_type_ComTencentQavControllerC2cIC2COperator.enableLocalVideo(true);
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentQavControllerC2cIC2COperator.startRemotePreview(this.b, this);
        return;
      }
    }
    catch (Exception localException)
    {
      AVLog.e("C2CVideoView", "openVideo fail.", localException);
    }
  }
  
  public void b()
  {
    try
    {
      if (a())
      {
        this.jdField_a_of_type_ComTencentQavControllerC2cIC2COperator.stopLocalPreview();
        this.jdField_a_of_type_ComTencentQavControllerC2cIC2COperator.enableLocalVideo(false);
        return;
      }
      this.jdField_a_of_type_ComTencentQavControllerC2cIC2COperator.stopRemotePreview(this.b);
      return;
    }
    catch (Exception localException)
    {
      AVLog.e("C2CVideoView", "closeVideo fail.", localException);
    }
  }
  
  public void c()
  {
    try
    {
      if (a())
      {
        this.jdField_a_of_type_ComTencentQavControllerC2cIC2COperator.switchCamera();
        return;
      }
      AVLog.w("C2CVideoView", "switchCamera remote video can not switch camera.");
      return;
    }
    catch (Exception localException)
    {
      AVLog.e("C2CVideoView", "switchCamera fail.", localException);
    }
  }
  
  public void setInfo(String paramString, int paramInt)
  {
    super.setInfo(paramString, paramInt);
    this.b = QavCtrl.getUserKey(paramString, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.qav.ui.C2CVideoView
 * JD-Core Version:    0.7.0.1
 */