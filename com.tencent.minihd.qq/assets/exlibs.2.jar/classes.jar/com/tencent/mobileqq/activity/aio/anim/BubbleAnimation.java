package com.tencent.mobileqq.activity.aio.anim;

import com.tencent.mobileqq.bubble.AnimationConfig;
import com.tencent.mobileqq.bubble.BubbleInfo.CommonAttrs;
import com.tencent.mobileqq.bubble.BubbleNewAIOAnim;
import com.tencent.util.Pair;
import com.tencent.widget.ListView;

public class BubbleAnimation
  extends AIOAnimationConatiner.AIOAnimator
{
  private AIOAnimationConatiner.AIOAnimator jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner$AIOAnimator;
  private SigTlpAnimation jdField_a_of_type_ComTencentMobileqqActivityAioAnimSigTlpAnimation;
  private XBubbleAnimation jdField_a_of_type_ComTencentMobileqqActivityAioAnimXBubbleAnimation;
  
  public BubbleAnimation(int paramInt, AIOAnimationConatiner paramAIOAnimationConatiner, ListView paramListView)
  {
    super(paramInt, paramAIOAnimationConatiner, paramListView);
  }
  
  private boolean b(Object... paramVarArgs)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramVarArgs.length == 4)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner != null)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_ComTencentWidgetListView != null)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner$AIOAnimator == null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner$AIOAnimator = new BubbleNewAIOAnim(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner, this.jdField_a_of_type_ComTencentWidgetListView);
          }
          bool1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner$AIOAnimator.a(paramVarArgs);
        }
      }
    }
    return bool1;
  }
  
  private boolean c(Object... paramVarArgs)
  {
    boolean bool = ((Boolean)paramVarArgs[4]).booleanValue();
    if (((paramVarArgs[5] != null) || (bool)) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimSigTlpAnimation != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimSigTlpAnimation.e();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimSigTlpAnimation = new SigTlpAnimation(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner, this.jdField_a_of_type_ComTencentWidgetListView);
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimSigTlpAnimation.a(paramVarArgs);
  }
  
  private boolean d(Object... paramVarArgs)
  {
    Pair localPair = null;
    if (paramVarArgs.length == 3) {
      localPair = (Pair)paramVarArgs[2];
    }
    if ((localPair == null) || (localPair.first == null)) {
      return false;
    }
    if (((BubbleInfo.CommonAttrs)localPair.first).a.n == 1)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimXBubbleAnimation != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimXBubbleAnimation.e();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimXBubbleAnimation = new XBubbleAnimation(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner, this.jdField_a_of_type_ComTencentWidgetListView);
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimXBubbleAnimation.a(paramVarArgs);
    }
    return false;
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimSigTlpAnimation != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimSigTlpAnimation.e();
    }
  }
  
  protected void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimXBubbleAnimation != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimXBubbleAnimation.a(paramInt);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner$AIOAnimator != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner$AIOAnimator.a(paramInt);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimSigTlpAnimation != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimSigTlpAnimation.a(paramInt);
    }
  }
  
  protected boolean a(int paramInt)
  {
    return true;
  }
  
  protected boolean a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool1 = false;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner$AIOAnimator != null) {}
    for (boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner$AIOAnimator.a(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);; bool2 = false)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimXBubbleAnimation != null) {
        if ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimXBubbleAnimation.a(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4)) && (!bool2)) {}
      }
      for (bool1 = true;; bool1 = bool2)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimSigTlpAnimation != null) {
          bool1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimSigTlpAnimation.a(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
        }
        return bool1;
      }
    }
  }
  
  protected boolean a(Object... paramVarArgs)
  {
    int i = ((Integer)paramVarArgs[0]).intValue();
    if ((i == 0) || (i == 1)) {
      return d(paramVarArgs);
    }
    if ((i == 5) || (i == 3)) {
      return b(paramVarArgs);
    }
    if (i == 4) {
      return c(paramVarArgs);
    }
    return false;
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimXBubbleAnimation != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimXBubbleAnimation.e();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner$AIOAnimator != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner$AIOAnimator.c();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimSigTlpAnimation != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimSigTlpAnimation.e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.BubbleAnimation
 * JD-Core Version:    0.7.0.1
 */