package com.tencent.mobileqq.activity.aio.anim;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import com.tencent.util.VersionUtils;
import com.tencent.widget.ListView;
import frg;
import java.util.ArrayList;
import java.util.Iterator;

@TargetApi(11)
public class FloorJumperSet
  extends AIOAnimationConatiner.AIOAnimator
{
  @SuppressLint({"NewApi"})
  static final long jdField_a_of_type_Long;
  public static final int b;
  frg jdField_a_of_type_Frg;
  public ArrayList a;
  private long b;
  
  static
  {
    long l;
    if (VersionUtils.e())
    {
      l = ValueAnimator.getFrameDelay();
      jdField_a_of_type_Long = l;
      if (!VersionUtils.e()) {
        break label35;
      }
    }
    label35:
    for (int i = 20;; i = 1)
    {
      jdField_b_of_type_Int = i;
      return;
      l = 16L;
      break;
    }
  }
  
  public FloorJumperSet(int paramInt, AIOAnimationConatiner paramAIOAnimationConatiner, ListView paramListView)
  {
    super(paramInt, paramAIOAnimationConatiner, paramListView);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(jdField_b_of_type_Int);
    this.jdField_b_of_type_Long = 0L;
  }
  
  protected void a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      FloorJumper localFloorJumper = (FloorJumper)localIterator.next();
      localFloorJumper.o += paramInt;
      localFloorJumper.m += paramInt;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.offsetChildrenTopAndBottom(paramInt);
  }
  
  protected boolean a(int paramInt)
  {
    return paramInt == 2;
  }
  
  protected boolean a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      if (((FloorJumper)localIterator.next()).a(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4)) {
        bool = true;
      }
      for (;;)
      {
        break;
        localIterator.remove();
      }
    }
    if (!bool)
    {
      c();
      d();
      return bool;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.invalidate();
    return bool;
  }
  
  protected boolean a(Object... paramVarArgs)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() < jdField_b_of_type_Int)
    {
      FloorJumper localFloorJumper = new FloorJumper(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner, this.jdField_a_of_type_ComTencentWidgetListView);
      this.jdField_a_of_type_JavaUtilArrayList.add(localFloorJumper);
      localFloorJumper.a(paramVarArgs);
      if (this.jdField_a_of_type_Frg == null)
      {
        this.jdField_a_of_type_Frg = new frg(this, null);
        if (this.jdField_b_of_type_Long == 0L) {
          this.jdField_a_of_type_ComTencentWidgetListView.postDelayed(this.jdField_a_of_type_Frg, jdField_a_of_type_Long);
        }
      }
      return true;
    }
    return false;
  }
  
  protected void b()
  {
    this.jdField_b_of_type_Long = 0L;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      if (((FloorJumper)localIterator.next()).a(false)) {
        i = 1;
      }
      for (;;)
      {
        break;
        localIterator.remove();
      }
    }
    if ((i != 0) && (this.jdField_a_of_type_Frg != null))
    {
      this.jdField_a_of_type_ComTencentWidgetListView.post(this.jdField_a_of_type_Frg);
      return;
    }
    d();
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_Frg != null)
    {
      this.jdField_a_of_type_ComTencentWidgetListView.removeCallbacks(this.jdField_a_of_type_Frg);
      this.jdField_a_of_type_Frg = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.FloorJumperSet
 * JD-Core Version:    0.7.0.1
 */