package com.tencent.mobileqq.magicface.view;

import android.opengl.GLSurfaceView.Renderer;
import com.tencent.mobileqq.magicface.model.MagicFaceGLDisplayer;
import com.tencent.qphone.base.util.QLog;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import jek;

public class GLRender
  implements GLSurfaceView.Renderer
{
  public static final String a;
  private MagicFaceGLDisplayer jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicFaceGLDisplayer;
  private jek jdField_a_of_type_Jek = null;
  
  static
  {
    jdField_a_of_type_JavaLangString = GLRender.class.getSimpleName();
  }
  
  public void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func copyFrame2Render begins, datas:" + paramArrayOfByte1);
    }
    jek localjek = new jek(this);
    if (localjek.a(paramArrayOfByte1, paramArrayOfByte2, paramInt1, paramInt2, paramInt3, paramInt4, paramFloat, paramBoolean))
    {
      this.jdField_a_of_type_Jek = null;
      this.jdField_a_of_type_Jek = localjek;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func copyFrame2Render ends, mCurData:" + this.jdField_a_of_type_Jek);
    }
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func onDrawFrame begins, gl:" + paramGL10);
    }
    if ((this.jdField_a_of_type_Jek == null) || (this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicFaceGLDisplayer == null)) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "func onDrawFrame ends, NULL data, mCurData:" + this.jdField_a_of_type_Jek + ",mBitmapDisplayer:" + this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicFaceGLDisplayer);
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicFaceGLDisplayer.a(this.jdField_a_of_type_Jek.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Jek.jdField_b_of_type_ArrayOfByte, this.jdField_a_of_type_Jek.c, this.jdField_a_of_type_Jek.d, this.jdField_a_of_type_Jek.jdField_a_of_type_Int, this.jdField_a_of_type_Jek.jdField_b_of_type_Int, this.jdField_a_of_type_Jek.jdField_a_of_type_Float, this.jdField_a_of_type_Jek.jdField_a_of_type_Boolean);
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "func onDrawFrame ends. One FRAME is drawn.");
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    paramGL10.glViewport(0, 0, paramInt1, paramInt2);
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func onSurfaceCreated begins");
    }
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicFaceGLDisplayer = new MagicFaceGLDisplayer();
    this.jdField_a_of_type_Jek = null;
    paramGL10.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func onSurfaceCreated ends");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.view.GLRender
 * JD-Core Version:    0.7.0.1
 */