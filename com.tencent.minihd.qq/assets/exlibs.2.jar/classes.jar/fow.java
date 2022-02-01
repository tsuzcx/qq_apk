import android.content.Context;
import android.graphics.PointF;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.item.ItemBuilderFactory;
import com.tencent.mobileqq.activity.aio.item.PicItemBuilder;
import com.tencent.mobileqq.activity.aio.item.TextItemBuilder;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.SizeMeasure;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.BubblePopupWindow.OnDismissListener;
import mqq.app.BasePadActivity;

public class fow
  implements View.OnClickListener, OnLongClickAndTouchListener, BubblePopupWindow.OnDismissListener
{
  private PointF jdField_a_of_type_AndroidGraphicsPointF = new PointF();
  ChatMessage jdField_a_of_type_ComTencentMobileqqDataChatMessage;
  public BubblePopupWindow a;
  
  private fow(ChatAdapter1 paramChatAdapter1) {}
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = null;
    if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null)
    {
      ChatItemBuilder localChatItemBuilder = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.jdField_a_of_type_ComTencentMobileqqActivityAioItemItemBuilderFactory.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1);
      if ((localChatItemBuilder instanceof BaseBubbleBuilder)) {
        ((BaseBubbleBuilder)localChatItemBuilder).c();
      }
    }
    BubbleContextMenu.a = false;
  }
  
  void a(View paramView)
  {
    MotionEvent localMotionEvent = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 3, 0.0F, 0.0F, 0);
    paramView.dispatchTouchEvent(localMotionEvent);
    localMotionEvent.recycle();
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null)
    {
      localChatItemBuilder = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.jdField_a_of_type_ComTencentMobileqqActivityAioItemItemBuilderFactory.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1);
      localContext = paramView.getContext();
      localChatItemBuilder.a(paramView.getId(), localContext, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
      this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = null;
    }
    while (!QLog.isColorLevel())
    {
      ChatItemBuilder localChatItemBuilder;
      Context localContext;
      return;
    }
    QLog.d(ChatItemBuilder.a, 2, "bubble onClick() is called while the chatMessage is null.");
  }
  
  public boolean onLongClick(View paramView)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.jdField_a_of_type_JavaLangBoolean.booleanValue()) {
      return true;
    }
    AIOUtils.h = true;
    if (QLog.isColorLevel()) {
      QLog.d(ChatItemBuilder.a, 2, "bubble onLongClick() is called");
    }
    if ((this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) && (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.g()))
    {
      a(paramView);
      return false;
    }
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    ChatItemBuilder localChatItemBuilder = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.jdField_a_of_type_ComTencentMobileqqActivityAioItemItemBuilderFactory.a(AIOUtils.a(paramView), this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1);
    Object localObject = localChatItemBuilder.a(paramView);
    if ((localObject != null) && (localObject.length > 0))
    {
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        localQQCustomMenu.a(localObject[i]);
        i += 1;
      }
      this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = AIOUtils.a(paramView);
      if (((ChatAdapter1.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1) instanceof BasePadActivity)) && (!((BasePadActivity)ChatAdapter1.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1)).bActivityToFragment))
      {
        localObject = this.jdField_a_of_type_AndroidGraphicsPointF;
        ((PointF)localObject).x -= SizeMeasure.h(ChatAdapter1.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1)) - SizeMeasure.e(ChatAdapter1.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1));
      }
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = BubbleContextMenu.a(paramView, (int)this.jdField_a_of_type_AndroidGraphicsPointF.x, (int)this.jdField_a_of_type_AndroidGraphicsPointF.y, localQQCustomMenu, this);
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(this);
      a(paramView);
      if ((localChatItemBuilder instanceof TextItemBuilder)) {
        paramView = Integer.toString(0);
      }
      for (;;)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004044", "0X8004404", 0, 0, paramView, "", "", "");
        BubbleContextMenu.a = true;
        return true;
        if ((localChatItemBuilder instanceof PicItemBuilder)) {
          paramView = Integer.toString(1);
        } else {
          paramView = Integer.toString(999);
        }
      }
    }
    a(paramView);
    return false;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.d(ChatItemBuilder.a, 2, "bubble onTouch() is called,action is:" + paramMotionEvent.getAction());
    }
    if (paramMotionEvent.getAction() == 0)
    {
      this.jdField_a_of_type_AndroidGraphicsPointF.x = paramMotionEvent.getRawX();
      this.jdField_a_of_type_AndroidGraphicsPointF.y = paramMotionEvent.getRawY();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fow
 * JD-Core Version:    0.7.0.1
 */