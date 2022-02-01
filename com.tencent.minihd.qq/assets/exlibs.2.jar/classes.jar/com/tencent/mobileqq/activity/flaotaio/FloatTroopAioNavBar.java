package com.tencent.mobileqq.activity.flaotaio;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.DecelerateInterpolator;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.troop.data.TroopAioAgent.Message;
import com.tencent.mobileqq.troop.data.TroopMessageManager;
import com.tencent.widget.XListView;
import java.util.Observable;
import java.util.Observer;

public class FloatTroopAioNavBar
  extends Observable
  implements Animator.AnimatorListener, View.OnClickListener
{
  private static long jdField_a_of_type_Long = 2147483647L;
  private int jdField_a_of_type_Int = 0;
  private ObjectAnimator jdField_a_of_type_AndroidAnimationObjectAnimator;
  Context jdField_a_of_type_AndroidContentContext;
  View jdField_a_of_type_AndroidViewView;
  BaseAdapter jdField_a_of_type_AndroidWidgetBaseAdapter;
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView = null;
  private TextView jdField_a_of_type_AndroidWidgetTextView = null;
  SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  Observer jdField_a_of_type_JavaUtilObserver;
  public boolean a;
  private int jdField_b_of_type_Int = -1;
  private long jdField_b_of_type_Long = jdField_a_of_type_Long;
  private ObjectAnimator jdField_b_of_type_AndroidAnimationObjectAnimator;
  private boolean jdField_b_of_type_Boolean = false;
  private long jdField_c_of_type_Long = 0L;
  private boolean jdField_c_of_type_Boolean = false;
  
  public FloatTroopAioNavBar()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      TroopInfoManager localTroopInfoManager = (TroopInfoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
      if (localTroopInfoManager != null) {
        localTroopInfoManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 0);
      }
      this.jdField_b_of_type_Int = -1;
      if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0)) {
        this.jdField_b_of_type_AndroidAnimationObjectAnimator.start();
      }
    }
  }
  
  private void f()
  {
    this.jdField_c_of_type_Boolean = false;
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 8))
    {
      this.jdField_a_of_type_AndroidAnimationObjectAnimator.start();
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      return;
    }
    int i = (int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131493222);
    Object localObject = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903326, null);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView((View)localObject, new FrameLayout.LayoutParams(-1, i));
    this.jdField_a_of_type_AndroidViewView = ((View)localObject);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131296388));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131296389));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewView, "translationY", new float[] { -i, 0.0F });
    this.jdField_b_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewView, "translationY", new float[] { 0.0F, -i });
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.setDuration(300L);
    this.jdField_b_of_type_AndroidAnimationObjectAnimator.setDuration(300L);
    localObject = new DecelerateInterpolator(1.5F);
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.setInterpolator((TimeInterpolator)localObject);
    this.jdField_b_of_type_AndroidAnimationObjectAnimator.setInterpolator((TimeInterpolator)localObject);
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.addListener(this);
    this.jdField_b_of_type_AndroidAnimationObjectAnimator.addListener(this);
  }
  
  protected void a()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    ((TroopInfoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1, this.jdField_b_of_type_Long, "");
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, Observer paramObserver, SessionInfo paramSessionInfo, FrameLayout paramFrameLayout, XListView paramXListView, BaseAdapter paramBaseAdapter)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_AndroidWidgetFrameLayout = paramFrameLayout;
    this.jdField_a_of_type_AndroidWidgetBaseAdapter = paramBaseAdapter;
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    deleteObservers();
    addObserver(paramObserver);
    paramContext = (FriendManager)paramQQAppInterface.getManager(8);
    paramQQAppInterface = (HotChatManager)paramQQAppInterface.getManager(58);
    if ((paramSessionInfo.jdField_a_of_type_Int == 1) && (!paramContext.f(paramSessionInfo.jdField_a_of_type_JavaLangString)) && (!paramQQAppInterface.d(paramSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      this.jdField_a_of_type_Boolean = true;
      a();
      return;
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public boolean a()
  {
    if ((!this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Boolean)) {
      return false;
    }
    this.jdField_b_of_type_Int = ((TroopInfoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    return (this.jdField_b_of_type_Int == 5) || (this.jdField_b_of_type_Int == 2) || (this.jdField_b_of_type_Int == 3) || (this.jdField_b_of_type_Int == 4);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Boolean) {
      c();
    }
    this.jdField_a_of_type_Boolean = false;
    deleteObservers();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = null;
    this.jdField_a_of_type_AndroidWidgetFrameLayout = null;
    this.jdField_a_of_type_JavaUtilObserver = null;
    this.jdField_a_of_type_AndroidWidgetBaseAdapter = null;
    this.jdField_a_of_type_ComTencentWidgetXListView = null;
  }
  
  protected void c()
  {
    ((TroopInfoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 0);
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_AndroidViewView.clearAnimation();
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public void d()
  {
    label7:
    Object localObject;
    long l;
    if (!a())
    {
      return;
      break label313;
      break label313;
      break label313;
    }
    else
    {
      this.jdField_b_of_type_Boolean = true;
      localObject = (TroopInfoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
      this.jdField_b_of_type_Int = ((TroopInfoManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      this.jdField_c_of_type_Long = ((TroopInfoManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      l = jdField_a_of_type_Long;
      localObject = (MessageRecord)this.jdField_a_of_type_AndroidWidgetBaseAdapter.getItem(this.jdField_a_of_type_ComTencentWidgetXListView.s());
      if (localObject == null) {
        break label555;
      }
      l = ((MessageRecord)localObject).shmsgseq;
    }
    label555:
    for (;;)
    {
      if (this.jdField_b_of_type_Int == 4)
      {
        g();
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_c_of_type_Long);
        if ((localObject != null) && (((MessageRecord)localObject).shmsgseq < l))
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setText("@信息/特别关心信息进入QQ查看");
          this.jdField_a_of_type_AndroidViewView.setTag(TroopAioAgent.Message.a(this.jdField_b_of_type_Int, 0L, this.jdField_c_of_type_Long));
          f();
        }
      }
      for (int i = 1;; i = 0)
      {
        int j;
        if (this.jdField_b_of_type_Int == 5)
        {
          g();
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_c_of_type_Long);
          j = i;
          if (localObject != null)
          {
            j = i;
            if (((MessageRecord)localObject).shmsgseq < l)
            {
              this.jdField_a_of_type_AndroidWidgetTextView.setText("@信息/特别关心信息进入QQ查看");
              this.jdField_a_of_type_AndroidViewView.setTag(TroopAioAgent.Message.a(this.jdField_b_of_type_Int, 0L, this.jdField_c_of_type_Long));
              f();
            }
          }
        }
        for (;;)
        {
          j = 1;
          label313:
          if (j != 0) {
            break label7;
          }
          e();
          return;
          if (this.jdField_b_of_type_Int == 2)
          {
            g();
            this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_c_of_type_Long);
            j = i;
            if (localObject == null) {
              break;
            }
            j = i;
            if (((MessageRecord)localObject).shmsgseq >= l) {
              break;
            }
            this.jdField_a_of_type_AndroidWidgetTextView.setText("@信息/特别关心信息进入QQ查看");
            this.jdField_a_of_type_AndroidViewView.setTag(TroopAioAgent.Message.a(this.jdField_b_of_type_Int, 0L, this.jdField_c_of_type_Long));
            f();
            continue;
          }
          j = i;
          if (this.jdField_b_of_type_Int != 3) {
            break;
          }
          g();
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_c_of_type_Long);
          j = i;
          if (localObject == null) {
            break;
          }
          j = i;
          if (((MessageRecord)localObject).shmsgseq >= l) {
            break;
          }
          this.jdField_a_of_type_AndroidWidgetTextView.setText("@信息/特别关心信息进入QQ查看");
          this.jdField_a_of_type_AndroidViewView.setTag(TroopAioAgent.Message.a(this.jdField_b_of_type_Int, 0L, this.jdField_c_of_type_Long));
          f();
        }
      }
    }
  }
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_AndroidViewView == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (paramAnimator == null)) {}
    do
    {
      do
      {
        return;
      } while (!paramAnimator.equals(this.jdField_b_of_type_AndroidAnimationObjectAnimator));
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    } while ((!this.jdField_c_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)));
    setChanged();
    notifyObservers(this.jdField_a_of_type_AndroidViewView.getTag());
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131296388: 
      this.jdField_c_of_type_Boolean = true;
      e();
      return;
    }
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.flaotaio.FloatTroopAioNavBar
 * JD-Core Version:    0.7.0.1
 */