package com.tencent.mobileqq.activity.particle;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.tencent.qphone.base.util.QLog;
import gpb;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ParticleView$ParticleLauncher
{
  private static final String jdField_a_of_type_JavaLangString = "ParticleManager";
  public float a;
  public int a;
  public long a;
  public Bitmap a;
  private List jdField_a_of_type_JavaUtilList = new LinkedList();
  public Random a;
  public boolean a;
  public float b;
  public int b;
  private long b;
  public boolean b;
  public float c;
  public int c;
  public float d;
  public int d;
  public float e;
  private int e;
  private int f = 0;
  private int g = 60;
  
  private ParticleView$ParticleLauncher(ParticleView paramParticleView)
  {
    this.jdField_a_of_type_Int = 18;
    this.jdField_a_of_type_Long = 3000L;
    this.jdField_a_of_type_Float = 218.0F;
    this.jdField_b_of_type_Float = 212.0F;
    this.jdField_b_of_type_Int = 5;
    this.jdField_c_of_type_Int = 4;
    this.jdField_d_of_type_Int = 6;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    this.jdField_a_of_type_JavaUtilRandom = null;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_e_of_type_Int = 0;
  }
  
  private void a()
  {
    while (this.jdField_b_of_type_Long < this.jdField_a_of_type_Long) {
      b();
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_JavaUtilRandom == null) {
      this.jdField_a_of_type_JavaUtilRandom = new Random(System.currentTimeMillis());
    }
    int i = 0;
    while (i < this.jdField_a_of_type_Int)
    {
      gpb localgpb = new gpb(this.jdField_a_of_type_ComTencentMobileqqActivityParticleParticleView);
      localgpb.jdField_c_of_type_Float = this.jdField_c_of_type_Float;
      localgpb.jdField_d_of_type_Float = this.jdField_d_of_type_Float;
      localgpb.jdField_e_of_type_Float = this.jdField_e_of_type_Float;
      localgpb.f = (this.jdField_a_of_type_JavaUtilRandom.nextFloat() / this.jdField_b_of_type_Int);
      if (this.jdField_a_of_type_JavaUtilRandom.nextInt() % 2 == 0) {
        localgpb.f = (-localgpb.f);
      }
      localgpb.g = (this.jdField_a_of_type_JavaUtilRandom.nextFloat() / this.jdField_c_of_type_Int);
      if (this.jdField_a_of_type_JavaUtilRandom.nextInt() % 2 == 0) {
        localgpb.g = (-localgpb.g);
      }
      localgpb.h = (this.jdField_a_of_type_JavaUtilRandom.nextFloat() / this.jdField_d_of_type_Int);
      localgpb.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
      localgpb.jdField_a_of_type_Long = (this.jdField_b_of_type_Long + this.jdField_a_of_type_JavaUtilRandom.nextLong() % 1000L);
      this.jdField_a_of_type_JavaUtilList.add(localgpb);
      i += 1;
    }
    this.jdField_b_of_type_Long += 1000L;
  }
  
  public void a(long paramLong, Canvas paramCanvas, Paint paramPaint)
  {
    if (paramLong - this.jdField_b_of_type_Long > 1000L) {
      b();
    }
    if (this.jdField_e_of_type_Int == 0)
    {
      this.jdField_e_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityParticleParticleView.getMeasuredWidth();
      this.f = this.jdField_a_of_type_ComTencentMobileqqActivityParticleParticleView.getMeasuredHeight();
    }
    Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      gpb localgpb = (gpb)((Iterator)localObject).next();
      long l = paramLong - localgpb.jdField_a_of_type_Long;
      if (l < 0L)
      {
        localgpb.jdField_a_of_type_Boolean = false;
      }
      else
      {
        localgpb.jdField_a_of_type_Boolean = true;
        float f1 = (float)l;
        f1 = localgpb.f * f1;
        float f2 = (float)l * localgpb.g;
        localgpb.jdField_c_of_type_Float = (this.jdField_c_of_type_Float + f1);
        localgpb.jdField_d_of_type_Float = (this.jdField_d_of_type_Float + f2);
        float f3 = this.jdField_e_of_type_Float;
        localgpb.jdField_e_of_type_Float = ((float)l * localgpb.h + f3);
        f3 = 1.0F - localgpb.jdField_e_of_type_Float / this.jdField_e_of_type_Float;
        localgpb.jdField_a_of_type_Float = (this.jdField_a_of_type_Float * f3);
        localgpb.jdField_b_of_type_Float = (f3 * this.jdField_b_of_type_Float);
        localgpb.i = 1.0F;
        if (this.jdField_b_of_type_Boolean)
        {
          if (f1 > 0.0F)
          {
            label241:
            if (f2 <= 0.0F) {
              break label308;
            }
            label248:
            f1 = f2 + f1;
            if (this.g >= f1) {
              continue;
            }
            f1 -= this.g;
            if (f1 <= this.g) {
              break label316;
            }
          }
          label308:
          label316:
          for (f1 = 0.0F;; f1 = 1.0F - f1 / this.g)
          {
            localgpb.i = f1;
            break;
            f1 = -f1;
            break label241;
            f2 = -f2;
            break label248;
          }
        }
      }
    }
    if (paramCanvas != null)
    {
      int i = this.jdField_a_of_type_JavaUtilList.size() - 1;
      if (i > -1)
      {
        localObject = (gpb)this.jdField_a_of_type_JavaUtilList.get(i);
        if ((((gpb)localObject).jdField_e_of_type_Float < 0.0F) && (((gpb)localObject).jdField_a_of_type_Boolean))
        {
          paramPaint.setAlpha((int)(((gpb)localObject).i * 255.0F));
          paramCanvas.drawBitmap(((gpb)localObject).jdField_a_of_type_AndroidGraphicsBitmap, null, ((gpb)localObject).a(), paramPaint);
        }
        for (;;)
        {
          i -= 1;
          break;
          if ((((gpb)localObject).jdField_e_of_type_Float > 0.0F) || (((gpb)localObject).jdField_c_of_type_Float < 0.0F) || (((gpb)localObject).jdField_c_of_type_Float > this.jdField_e_of_type_Int) || (((gpb)localObject).jdField_d_of_type_Float < 0.0F) || (((gpb)localObject).jdField_d_of_type_Float > this.f)) {
            this.jdField_a_of_type_JavaUtilList.remove(i);
          }
        }
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("ParticleManager", 2, "canvas is null");
    }
  }
  
  public void a(Bitmap paramBitmap, Random paramRandom)
  {
    this.jdField_a_of_type_JavaUtilRandom = paramRandom;
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    if (paramBitmap != null)
    {
      this.jdField_a_of_type_Float = paramBitmap.getWidth();
      this.jdField_b_of_type_Float = paramBitmap.getHeight();
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.particle.ParticleView.ParticleLauncher
 * JD-Core Version:    0.7.0.1
 */