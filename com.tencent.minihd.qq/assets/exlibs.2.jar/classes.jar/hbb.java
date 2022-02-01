import android.os.Handler;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.List;

public class hbb
  extends FriendListObserver
{
  public hbb(SpecailCareListActivity paramSpecailCareListActivity) {}
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SpecailCareListActivity", 2, "onUpdateDelFriend isSucess= " + paramBoolean + ", uin=" + (Long)paramObject);
    }
    if (paramBoolean)
    {
      this.a.a();
      this.a.jdField_a_of_type_Hbl.notifyDataSetChanged();
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SpecailCareListActivity", 2, "onUpdateFriendList isSuccess=" + paramBoolean1 + ", isComplete=" + paramBoolean2 + " mIsPullRefresh=" + this.a.jdField_a_of_type_Boolean);
    }
    if ((!paramBoolean1) || (paramBoolean2))
    {
      this.a.a();
      this.a.jdField_a_of_type_Hbl.notifyDataSetChanged();
    }
    if (this.a.jdField_a_of_type_Boolean)
    {
      if ((!paramBoolean1) || (!paramBoolean2)) {
        break label135;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0);
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2001, 1000L);
      this.a.jdField_a_of_type_Boolean = false;
    }
    label135:
    while (paramBoolean1) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(1);
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2001, 1000L);
    this.a.jdField_a_of_type_Boolean = false;
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, List paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SpecailCareListActivity", 2, "onUpdateSpecialCareList isSucess= " + paramBoolean1 + ",isComplete=" + paramBoolean2);
    }
    if (paramBoolean1)
    {
      this.a.a();
      this.a.jdField_a_of_type_Hbl.notifyDataSetChanged();
    }
  }
  
  protected void a(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    int i = ((Integer)paramArrayOfObject[0]).intValue();
    paramArrayOfObject = (String[])paramArrayOfObject[1];
    if (QLog.isColorLevel()) {
      QLog.d("SpecailCareListActivity", 2, "onSetSpecialCareSwitch_global isSucess= " + paramBoolean + ",type=" + i + ",uinSize=" + paramArrayOfObject.length);
    }
    if ((SpecailCareListActivity.a(this.a) != null) && (paramArrayOfObject != null)) {}
    for (boolean bool = Arrays.equals(SpecailCareListActivity.a(this.a), paramArrayOfObject);; bool = false)
    {
      if (bool) {
        if (paramArrayOfObject.length >= 1)
        {
          this.a.h();
          if (paramBoolean) {
            if (this.a.c != null)
            {
              this.a.d();
              QQToast.a(BaseApplication.getContext(), 2, 2131367794, 0).b(this.a.getTitleBarHeight());
              this.a.a();
              this.a.jdField_a_of_type_Hbl.notifyDataSetChanged();
            }
          }
        }
      }
      while (!paramBoolean)
      {
        do
        {
          for (;;)
          {
            return;
            QQToast.a(BaseApplication.getContext(), 2, 2131369179, 0).b(this.a.getTitleBarHeight());
          }
          if (this.a.c != null)
          {
            QQToast.a(BaseApplication.getContext(), 1, 2131369176, 0).b(this.a.getTitleBarHeight());
            return;
          }
          QQToast.a(BaseApplication.getContext(), 1, 2131369180, 0).b(this.a.getTitleBarHeight());
          return;
        } while (!paramBoolean);
        this.a.a();
        this.a.jdField_a_of_type_Hbl.notifyDataSetChanged();
        return;
      }
      this.a.a();
      this.a.jdField_a_of_type_Hbl.notifyDataSetChanged();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     hbb
 * JD-Core Version:    0.7.0.1
 */