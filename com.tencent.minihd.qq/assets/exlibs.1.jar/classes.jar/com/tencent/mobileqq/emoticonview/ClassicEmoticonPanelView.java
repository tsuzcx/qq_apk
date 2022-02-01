package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.util.MQLruCache;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.util.SizeMeasure;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import ifp;
import ifq;
import ifr;
import java.io.File;
import java.util.List;

public class ClassicEmoticonPanelView
  extends View
{
  public static final String a = "ClassicEmoticonPanelView";
  public static final String b = "page_";
  private static final int c = 3;
  private static final int jdField_d_of_type_Int = 7;
  private static final String jdField_d_of_type_JavaLangString = "classic_emoticon";
  private static final int e = 30;
  private static final int f = 20;
  private float jdField_a_of_type_Float = super.getContext().getResources().getDisplayMetrics().density;
  public int a;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  public EmoticonCallback a;
  private EmoticonInfo jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonInfo;
  private ifr jdField_a_of_type_Ifr;
  public Runnable a;
  private List jdField_a_of_type_JavaUtilList;
  public boolean a;
  public int b;
  private FrameLayout jdField_b_of_type_AndroidWidgetFrameLayout;
  private boolean jdField_b_of_type_Boolean;
  public String c;
  private int g = (int)(30.0F * this.jdField_a_of_type_Float);
  private int h = 0;
  
  public ClassicEmoticonPanelView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangRunnable = new ifq(this);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setFilterBitmap(true);
    this.c = super.getContext().getDir("classic_emoticon", 0).getPath();
    this.h = AIOUtils.a(40.0F, paramContext.getResources());
  }
  
  private int a(float paramFloat1, float paramFloat2)
  {
    int j = (super.getMeasuredWidth() - this.h) / 7;
    int i = (int)(paramFloat2 / (super.getMeasuredHeight() / 3));
    if (i >= 3) {
      i = 2;
    }
    for (;;)
    {
      int k = (int)(paramFloat1 / j);
      j = k;
      if (k >= 7) {
        j = 6;
      }
      return j + i * 7;
    }
  }
  
  private void a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size())) {}
    EmoticonInfo localEmoticonInfo;
    Drawable localDrawable;
    do
    {
      do
      {
        return;
        localEmoticonInfo = (EmoticonInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      } while (localEmoticonInfo == null);
      localDrawable = localEmoticonInfo.b(getContext(), this.jdField_a_of_type_Float);
    } while (localDrawable == null);
    if (this.jdField_b_of_type_AndroidWidgetFrameLayout == null)
    {
      this.jdField_b_of_type_AndroidWidgetFrameLayout = new FrameLayout(getContext());
      this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(getContext());
      this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
      this.jdField_a_of_type_AndroidWidgetImageView.setAdjustViewBounds(false);
      this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
      this.jdField_b_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_AndroidWidgetFrameLayout);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView);
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localDrawable);
    int i = (int)(64.0F * this.jdField_a_of_type_Float);
    int j = (int)(71.0F * this.jdField_a_of_type_Float);
    int k = (int)(5.0F * this.jdField_a_of_type_Float);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2130837561);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setPadding(k, k, k, k);
    Object localObject1 = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject1).width = ((int)(this.jdField_a_of_type_Float * 28.0F));
    ((FrameLayout.LayoutParams)localObject1).height = ((int)(this.jdField_a_of_type_Float * 28.0F));
    ((FrameLayout.LayoutParams)localObject1).bottomMargin = ((int)(6.0F * this.jdField_a_of_type_Float));
    ((FrameLayout.LayoutParams)localObject1).gravity = 17;
    localObject1 = new Rect();
    super.getGlobalVisibleRect((Rect)localObject1);
    Object localObject2 = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject2).gravity = 51;
    k = (super.getMeasuredWidth() - this.h * 2 - this.g * 7) / 6;
    int m = super.getMeasuredHeight() / 3;
    int n = this.h;
    ((FrameLayout.LayoutParams)localObject2).leftMargin = ((k + this.g) * (paramInt % 7) + n - (i - this.g) / 2);
    if (getContext().getResources().getConfiguration().orientation == 2)
    {
      ((FrameLayout.LayoutParams)localObject2).leftMargin += SizeMeasure.a(getContext()) + SizeMeasure.b(getContext());
      label421:
      ((FrameLayout.LayoutParams)localObject2).topMargin = (((Rect)localObject1).top + paramInt / 7 * m - j - (int)(15.0F * this.jdField_a_of_type_Float));
      ((FrameLayout.LayoutParams)localObject2).width = i;
      ((FrameLayout.LayoutParams)localObject2).height = j;
      if (!this.jdField_b_of_type_Boolean) {
        break label532;
      }
      this.jdField_a_of_type_AndroidWidgetFrameLayout.requestLayout();
    }
    for (;;)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonInfo;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonInfo = localEmoticonInfo;
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback.a((EmoticonInfo)localObject1, localEmoticonInfo, localDrawable);
      return;
      ((FrameLayout.LayoutParams)localObject2).leftMargin += SizeMeasure.a(getContext());
      break label421;
      label532:
      localObject1 = (WindowManager)getContext().getSystemService("window");
      localObject2 = new WindowManager.LayoutParams(-1, -1, 2, 24, -3);
      ((WindowManager)localObject1).addView(this.jdField_b_of_type_AndroidWidgetFrameLayout, (ViewGroup.LayoutParams)localObject2);
      this.jdField_b_of_type_Boolean = true;
    }
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidWidgetFrameLayout != null) && (this.jdField_b_of_type_Boolean))
    {
      ((WindowManager)getContext().getSystemService("window")).removeViewImmediate(this.jdField_b_of_type_AndroidWidgetFrameLayout);
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback != null) {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback.b(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonInfo);
      }
      this.jdField_b_of_type_Boolean = false;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilList = null;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback = null;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    long l = System.currentTimeMillis();
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {}
    int j;
    int i;
    int k;
    StringBuilder localStringBuilder1;
    Object localObject5;
    Object localObject4;
    StringBuilder localStringBuilder2;
    Object localObject6;
    do
    {
      Object localObject1;
      do
      {
        return;
        j = super.getMeasuredWidth();
        i = super.getMeasuredHeight();
        if (QLog.isColorLevel()) {
          QLog.e("ClassicEmoticonPanelView", 2, "viewWidth=" + j + ",viewHeight=" + i);
        }
        k = super.getResources().getConfiguration().orientation;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("page_").append(this.jdField_a_of_type_Int).append("_").append(k).append("_").append(j).append("_").append(i);
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("AIOClassicEmoticon://").append(((StringBuilder)localObject1).toString());
        localObject5 = localStringBuilder1.toString();
        if (BaseApplicationImpl.a == null) {
          break;
        }
        localObject4 = (Bitmap)BaseApplicationImpl.a.get(localObject5);
        if (localObject4 == null) {
          break;
        }
        paramCanvas.drawBitmap((Bitmap)localObject4, 0.0F, 0.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
      } while (!QLog.isColorLevel());
      QLog.d("ClassicEmoticonPanelView", 2, "[Performance] onDraw complete, duration=" + (System.currentTimeMillis() - l) + ", page=" + this.jdField_a_of_type_Int + ", cache hit");
      return;
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(this.c).append("/").append(((StringBuilder)localObject1).toString()).append(".png");
      localObject6 = new File(localStringBuilder2.toString());
      if ((localObject6 == null) || (!((File)localObject6).exists())) {
        break label505;
      }
      try
      {
        localObject4 = BitmapFactory.decodeFile(((File)localObject6).getAbsolutePath());
        localObject1 = localObject4;
        if (localObject4 == null)
        {
          ((File)localObject6).delete();
          localObject1 = localObject4;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        for (;;)
        {
          localObject4 = null;
          localObject2 = localObject4;
          if (QLog.isColorLevel())
          {
            QLog.e("ClassicEmoticonPanelView", 2, "decodeFile oom: " + localObject6);
            localObject2 = localObject4;
          }
        }
      }
      if (localObject1 == null) {
        break label505;
      }
      paramCanvas.drawBitmap((Bitmap)localObject1, 0.0F, 0.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
      if (BaseApplicationImpl.a != null) {
        BaseApplicationImpl.a.put(localObject5, localObject1);
      }
    } while (!QLog.isColorLevel());
    QLog.d("ClassicEmoticonPanelView", 2, "[Performance] onDraw complete, duration=" + (System.currentTimeMillis() - l) + ", page=" + this.jdField_a_of_type_Int + ", file found");
    return;
    for (;;)
    {
      label505:
      Object localObject3;
      try
      {
        Object localObject2;
        localObject4 = Bitmap.createBitmap(super.getMeasuredWidth(), super.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        if (localObject4 == null) {
          break label1214;
        }
        localObject5 = new Canvas((Bitmap)localObject4);
        m = (j - this.h * 2 - this.g * 7) / 6;
        n = i / 3;
        i = 0;
        if (i < 3)
        {
          j = 0;
          if (j < 7)
          {
            i1 = i * 7 + j;
            if ((i1 != 20) && (i1 < this.jdField_a_of_type_JavaUtilList.size())) {}
          }
          else
          {
            i += 1;
            continue;
          }
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError2)
      {
        int m;
        int n;
        int i1;
        localObject3 = null;
        localObject4 = localObject3;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("ClassicEmoticonPanelView", 2, "mGeneratedBitmap create oom");
        localObject4 = localObject3;
        continue;
        localObject3 = (EmoticonInfo)this.jdField_a_of_type_JavaUtilList.get(i1);
        if (localObject3 != null)
        {
          localObject3 = ((EmoticonInfo)localObject3).a(getContext(), this.jdField_a_of_type_Float);
          if (localObject3 != null)
          {
            if (!(localObject3 instanceof BitmapDrawable)) {
              continue;
            }
            localObject3 = ((BitmapDrawable)localObject3).getBitmap();
            if (localObject3 != null)
            {
              localObject6 = new Rect();
              ((Rect)localObject6).left = (this.h + (this.g + m) * j);
              ((Rect)localObject6).top = (n * i + (n - this.g) / 2);
              ((Rect)localObject6).right = (((Rect)localObject6).left + this.g);
              ((Rect)localObject6).bottom = (((Rect)localObject6).top + this.g);
              paramCanvas.drawBitmap((Bitmap)localObject3, null, (Rect)localObject6, this.jdField_a_of_type_AndroidGraphicsPaint);
              if (localObject5 != null) {
                ((Canvas)localObject5).drawBitmap((Bitmap)localObject3, null, (Rect)localObject6, this.jdField_a_of_type_AndroidGraphicsPaint);
              }
            }
          }
        }
        j += 1;
        continue;
        if ((localObject3 instanceof SkinnableBitmapDrawable))
        {
          localObject3 = ((SkinnableBitmapDrawable)localObject3).getBitmap();
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.e("ClassicEmoticonPanelView", 2, "Should never reach here, drawable=" + localObject3);
        }
        localObject3 = null;
        continue;
        localObject3 = getContext().getResources().getDrawable(2130838230);
        if (localObject3 != null)
        {
          if (!(localObject3 instanceof BitmapDrawable)) {
            break label1154;
          }
          localObject3 = ((BitmapDrawable)localObject3).getBitmap();
          if (localObject3 != null)
          {
            i = this.g * ((Bitmap)localObject3).getHeight() / ((Bitmap)localObject3).getWidth();
            localObject6 = new Rect();
            ((Rect)localObject6).left = (this.h + (m + this.g) * 6);
            ((Rect)localObject6).top = (n * 2 + (n - i) / 2);
            ((Rect)localObject6).right = (((Rect)localObject6).left + this.g);
            ((Rect)localObject6).bottom = (i + ((Rect)localObject6).top);
            paramCanvas.drawBitmap((Bitmap)localObject3, null, (Rect)localObject6, this.jdField_a_of_type_AndroidGraphicsPaint);
            if (localObject5 != null) {
              ((Canvas)localObject5).drawBitmap((Bitmap)localObject3, null, (Rect)localObject6, this.jdField_a_of_type_AndroidGraphicsPaint);
            }
          }
        }
        if (localObject4 != null)
        {
          i = this.jdField_a_of_type_Int;
          if (BaseApplicationImpl.a != null) {
            BaseApplicationImpl.a.put(localStringBuilder1.toString(), localObject4);
          }
          ThreadManager.b(new ifp(this, (Bitmap)localObject4, i, k, localStringBuilder2));
        }
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ClassicEmoticonPanelView", 2, "[Performance] onDraw complete, duration=" + (System.currentTimeMillis() - l) + ", page=" + this.jdField_a_of_type_Int + ", using several drawables");
      return;
      label1154:
      if ((localObject3 instanceof SkinnableBitmapDrawable))
      {
        localObject3 = ((SkinnableBitmapDrawable)localObject3).getBitmap();
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.e("ClassicEmoticonPanelView", 2, "Should never reach here, deleteDrawable=" + localObject3);
        }
        localObject3 = null;
        continue;
        label1214:
        localObject5 = null;
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return true;
            if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Ifr != null)) {
              removeCallbacks(this.jdField_a_of_type_Ifr);
            }
            if ((this.jdField_b_of_type_Int != -1) && (!this.jdField_a_of_type_Boolean))
            {
              super.sendAccessibilityEvent(1);
              super.playSoundEffect(0);
              if (this.jdField_b_of_type_Int != 20)
              {
                paramMotionEvent = (EmoticonInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_b_of_type_Int);
                if ((paramMotionEvent != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback != null)) {
                  this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback.a(paramMotionEvent);
                }
              }
            }
            a();
            this.jdField_b_of_type_Int = -1;
            super.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
            return true;
            this.jdField_a_of_type_Boolean = false;
            this.jdField_b_of_type_Int = a(paramMotionEvent.getX(), paramMotionEvent.getY());
          } while (this.jdField_b_of_type_Int == -1);
          if (this.jdField_a_of_type_Ifr == null) {
            this.jdField_a_of_type_Ifr = new ifr(this);
          }
          this.jdField_a_of_type_Ifr.a();
          super.postDelayed(this.jdField_a_of_type_Ifr, ViewConfiguration.getLongPressTimeout());
        } while (this.jdField_b_of_type_Int != 20);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback.a();
        return true;
        super.setPressed(false);
        if (this.jdField_a_of_type_Ifr != null) {
          super.removeCallbacks(this.jdField_a_of_type_Ifr);
        }
        super.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        a();
        this.jdField_b_of_type_Int = -1;
        return true;
      } while (!this.jdField_a_of_type_Boolean);
      this.jdField_b_of_type_Int = a(paramMotionEvent.getX(), paramMotionEvent.getY());
      if (this.jdField_b_of_type_Int == -1) {
        break;
      }
    } while (this.jdField_b_of_type_Int == 20);
    a(this.jdField_b_of_type_Int);
    return true;
    a();
    return true;
  }
  
  public void setCallback(EmoticonCallback paramEmoticonCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback = paramEmoticonCallback;
  }
  
  public void setData(List paramList, int paramInt)
  {
    if (paramList == null) {}
    do
    {
      return;
      j = paramInt * 20;
      if (j < paramList.size()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("ClassicEmoticonPanelView", 2, "Wrong page, check your code!!!");
    return;
    int i = j;
    if (j < 0) {
      i = 0;
    }
    int k = i + 20;
    int j = k;
    if (k >= paramList.size()) {
      j = paramList.size() - 1;
    }
    this.jdField_a_of_type_JavaUtilList = paramList.subList(i, j);
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.ClassicEmoticonPanelView
 * JD-Core Version:    0.7.0.1
 */