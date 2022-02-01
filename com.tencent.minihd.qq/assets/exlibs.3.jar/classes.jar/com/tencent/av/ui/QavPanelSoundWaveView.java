package com.tencent.av.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PointF;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import bzr;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QavPanelSoundWaveView
  extends View
{
  public static final int a = 20;
  static final String a = "QavPanelSoundWaveView";
  public float a;
  public Handler a;
  public Runnable a;
  public List a;
  public boolean a;
  float jdField_b_of_type_Float;
  boolean jdField_b_of_type_Boolean = false;
  public float c;
  boolean c;
  
  public QavPanelSoundWaveView(Context paramContext)
  {
    super(paramContext);
    this.jdField_c_of_type_Float = 0.0F;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_JavaLangRunnable = new bzr(this);
    this.jdField_c_of_type_Boolean = false;
    a();
  }
  
  public QavPanelSoundWaveView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_c_of_type_Float = 0.0F;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_JavaLangRunnable = new bzr(this);
    this.jdField_c_of_type_Boolean = false;
    a();
  }
  
  public QavPanelSoundWaveView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_c_of_type_Float = 0.0F;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_JavaLangRunnable = new bzr(this);
    this.jdField_c_of_type_Boolean = false;
    a();
  }
  
  void a()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() != 3)) {}
    do
    {
      do
      {
        return;
        if (!this.jdField_b_of_type_Boolean) {
          break;
        }
        if ((this.jdField_a_of_type_JavaUtilList.get(0) != null) && (((QavPanelWave)this.jdField_a_of_type_JavaUtilList.get(0)).a() != null)) {
          ((QavPanelWave)this.jdField_a_of_type_JavaUtilList.get(0)).a().setColor(Color.parseColor("#b3ffffff"));
        }
        if ((this.jdField_a_of_type_JavaUtilList.get(1) != null) && (((QavPanelWave)this.jdField_a_of_type_JavaUtilList.get(1)).a() != null)) {
          ((QavPanelWave)this.jdField_a_of_type_JavaUtilList.get(1)).a().setColor(Color.parseColor("#66ffffff"));
        }
      } while ((this.jdField_a_of_type_JavaUtilList.get(2) == null) || (((QavPanelWave)this.jdField_a_of_type_JavaUtilList.get(2)).a() == null));
      ((QavPanelWave)this.jdField_a_of_type_JavaUtilList.get(2)).a().setColor(Color.parseColor("#26ffffff"));
      return;
      if ((this.jdField_a_of_type_JavaUtilList.get(0) != null) && (((QavPanelWave)this.jdField_a_of_type_JavaUtilList.get(0)).a() != null)) {
        ((QavPanelWave)this.jdField_a_of_type_JavaUtilList.get(0)).a().setColor(Color.parseColor("#b312b7f5"));
      }
      if ((this.jdField_a_of_type_JavaUtilList.get(1) != null) && (((QavPanelWave)this.jdField_a_of_type_JavaUtilList.get(1)).a() != null)) {
        ((QavPanelWave)this.jdField_a_of_type_JavaUtilList.get(1)).a().setColor(Color.parseColor("#6612b7f5"));
      }
    } while ((this.jdField_a_of_type_JavaUtilList.get(2) == null) || (((QavPanelWave)this.jdField_a_of_type_JavaUtilList.get(2)).a() == null));
    ((QavPanelWave)this.jdField_a_of_type_JavaUtilList.get(2)).a().setColor(Color.parseColor("#2612b7f5"));
  }
  
  void b()
  {
    this.jdField_a_of_type_Float = getWidth();
    this.jdField_b_of_type_Float = getHeight();
    this.jdField_a_of_type_JavaUtilList.clear();
    float f;
    PointF localPointF;
    Paint localPaint;
    if (!this.jdField_a_of_type_Boolean)
    {
      f = 1.5F;
      localPointF = new PointF(0.0F, this.jdField_b_of_type_Float / 2.0F);
      localPaint = new Paint();
      if (!this.jdField_b_of_type_Boolean) {
        break label281;
      }
      localPaint.setColor(Color.parseColor("#b3ffffff"));
      label76:
      localPaint.setStrokeWidth(2.0F);
      localPaint.setAntiAlias(true);
      localPaint.setStyle(Paint.Style.STROKE);
      this.jdField_a_of_type_JavaUtilList.add(new QavPanelWave(0, this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, f, localPaint, localPointF, this.jdField_a_of_type_Boolean));
      localPaint = new Paint();
      if (!this.jdField_b_of_type_Boolean) {
        break label293;
      }
      localPaint.setColor(Color.parseColor("#66ffffff"));
      label150:
      localPaint.setStrokeWidth(2.0F);
      localPaint.setAntiAlias(true);
      localPaint.setStyle(Paint.Style.STROKE);
      this.jdField_a_of_type_JavaUtilList.add(new QavPanelWave(1, this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, f, localPaint, localPointF, this.jdField_a_of_type_Boolean));
      localPaint = new Paint();
      if (!this.jdField_b_of_type_Boolean) {
        break label305;
      }
      localPaint.setColor(Color.parseColor("#26ffffff"));
    }
    for (;;)
    {
      localPaint.setStrokeWidth(2.0F);
      localPaint.setAntiAlias(true);
      localPaint.setStyle(Paint.Style.STROKE);
      this.jdField_a_of_type_JavaUtilList.add(new QavPanelWave(2, this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, f, localPaint, localPointF, this.jdField_a_of_type_Boolean));
      return;
      f = 8.0F;
      break;
      label281:
      localPaint.setColor(Color.parseColor("#b312b7f5"));
      break label76;
      label293:
      localPaint.setColor(Color.parseColor("#6612b7f5"));
      break label150;
      label305:
      localPaint.setColor(Color.parseColor("#2612b7f5"));
    }
  }
  
  public void c()
  {
    e();
    this.jdField_a_of_type_AndroidOsHandler = null;
    this.jdField_a_of_type_JavaLangRunnable = null;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList = null;
    }
  }
  
  void d()
  {
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 20L);
    invalidate();
  }
  
  void e()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_c_of_type_Float = 0.0F;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((QavPanelWave)localIterator.next()).a();
    }
    invalidate();
  }
  
  public void f()
  {
    d();
  }
  
  public void g()
  {
    e();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.jdField_a_of_type_Float != getWidth()) || (this.jdField_b_of_type_Float != getHeight())) {
      b();
    }
    if (this.jdField_c_of_type_Boolean)
    {
      localObject = new Paint();
      ((Paint)localObject).setColor(-268780356);
      paramCanvas.drawRect(0.0F, 0.0F, this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, (Paint)localObject);
    }
    Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((QavPanelWave)((Iterator)localObject).next()).a(paramCanvas);
    }
  }
  
  public void setRoundStyle(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.av.ui.QavPanelSoundWaveView
 * JD-Core Version:    0.7.0.1
 */