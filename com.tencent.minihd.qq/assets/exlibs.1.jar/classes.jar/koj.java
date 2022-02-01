import android.content.Context;
import android.graphics.PointF;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager;
import com.tencent.mobileqq.troop.widget.TroopFeedViewFactory;
import com.tencent.mobileqq.troop.widget.TroopFeedViewFactory.ViewHolder;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.BubblePopupWindow.OnDismissListener;

public class koj
  implements View.OnClickListener, View.OnLongClickListener, View.OnTouchListener, BubblePopupWindow.OnDismissListener
{
  protected PointF a;
  protected TroopFeedViewFactory.ViewHolder a;
  protected BubblePopupWindow a;
  
  private koj(TroopFeedViewFactory paramTroopFeedViewFactory)
  {
    this.jdField_a_of_type_AndroidGraphicsPointF = new PointF();
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = null;
  }
  
  void a(View paramView)
  {
    MotionEvent localMotionEvent = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 3, 0.0F, 0.0F, 0);
    paramView.dispatchTouchEvent(localMotionEvent);
    localMotionEvent.recycle();
  }
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopFeedViewFactory$ViewHolder == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopFeedViewFactory$ViewHolder.a == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopFeedViewFactory.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager == null)) {
      return;
    }
    if (!NetworkUtil.e(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopFeedViewFactory.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopFeedViewFactory.jdField_a_of_type_AndroidContentContext, "删除失败，请检查网络", 3000).a();
      return;
    }
    switch (paramView.getId())
    {
    default: 
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopFeedViewFactory.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopFeedViewFactory$ViewHolder.a);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopFeedViewFactory.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "Clk_del", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopFeedViewFactory.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "0", "", "");
  }
  
  public boolean onLongClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d(ChatItemBuilder.a, 2, "bubble onLongClick() is called");
    }
    if ((this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) && (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.g()))
    {
      a(paramView);
      return false;
    }
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    localQQCustomMenu.a(2131302479, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopFeedViewFactory.jdField_a_of_type_AndroidContentContext.getString(2131366320));
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = BubbleContextMenu.a(paramView, (int)this.jdField_a_of_type_AndroidGraphicsPointF.x, (int)this.jdField_a_of_type_AndroidGraphicsPointF.y, localQQCustomMenu, this);
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopFeedViewFactory$ViewHolder = ((TroopFeedViewFactory.ViewHolder)paramView.getTag());
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopFeedViewFactory.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "exp_del", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopFeedViewFactory.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "", "", "");
    a(paramView);
    return true;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     koj
 * JD-Core Version:    0.7.0.1
 */