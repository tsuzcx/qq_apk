package com.tencent.mobileqq.activity.particle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import gpc;

public class ParticleView
  extends View
{
  public static final int a = 101;
  public static final long a = 33L;
  private static final String jdField_a_of_type_JavaLangString = "ParticleView";
  private Paint jdField_a_of_type_AndroidGraphicsPaint = null;
  private Handler jdField_a_of_type_AndroidOsHandler = null;
  private ParticleView.ParticleLauncher jdField_a_of_type_ComTencentMobileqqActivityParticleParticleView$ParticleLauncher = null;
  long b = 0L;
  
  public ParticleView(Context paramContext)
  {
    super(paramContext);
    if (QLog.isColorLevel()) {
      QLog.d("ParticleView", 2, "create");
    }
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_ComTencentMobileqqActivityParticleParticleView$ParticleLauncher = new ParticleView.ParticleLauncher(this, null);
    this.jdField_a_of_type_AndroidOsHandler = new gpc(this);
  }
  
  public ParticleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_ComTencentMobileqqActivityParticleParticleView$ParticleLauncher = new ParticleView.ParticleLauncher(this, null);
    this.jdField_a_of_type_AndroidOsHandler = new gpc(this);
  }
  
  public ParticleView.ParticleLauncher a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityParticleParticleView$ParticleLauncher;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    long l2 = System.currentTimeMillis();
    long l1;
    if (this.b == 0L)
    {
      this.b = (l2 - this.jdField_a_of_type_ComTencentMobileqqActivityParticleParticleView$ParticleLauncher.a);
      l1 = this.jdField_a_of_type_ComTencentMobileqqActivityParticleParticleView$ParticleLauncher.a;
      this.jdField_a_of_type_ComTencentMobileqqActivityParticleParticleView$ParticleLauncher.a(l1, paramCanvas, this.jdField_a_of_type_AndroidGraphicsPaint);
      if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(101)) {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
      }
      l1 = 33L - System.currentTimeMillis() + l2;
      paramCanvas = this.jdField_a_of_type_AndroidOsHandler;
      if (l1 <= 0L) {
        break label117;
      }
    }
    for (;;)
    {
      paramCanvas.sendEmptyMessageDelayed(101, l1);
      return;
      l1 = l2 - this.b;
      break;
      label117:
      l1 = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.particle.ParticleView
 * JD-Core Version:    0.7.0.1
 */