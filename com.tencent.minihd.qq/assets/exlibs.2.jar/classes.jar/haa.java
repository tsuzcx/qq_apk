import android.content.Intent;
import android.os.Handler;
import com.tencent.mobileqq.activity.specialcare.QQSpecialFriendSettingActivity;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class haa
  extends FriendListObserver
{
  public haa(QQSpecialFriendSettingActivity paramQQSpecialFriendSettingActivity) {}
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSpecialFriendSettingActivity", 2, "onUpdateDelFriend isSuccess: " + paramBoolean + ", uin: " + paramObject);
    }
    if ((paramBoolean) && (QQSpecialFriendSettingActivity.a(this.a).equals(String.valueOf(paramObject)))) {
      this.a.finish();
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, List paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSpecialFriendSettingActivity", 2, "onUpdateSpecialCareList isSuccess: " + paramBoolean1 + ", isComplete: " + paramBoolean2);
    }
    QQSpecialFriendSettingActivity.b(this.a);
  }
  
  protected void a(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.d("QQSpecialFriendSettingActivity", 2, "onSetSpecialCareSwith_global isSuccess: " + paramBoolean + ",isFromForwardFriendActivity=" + QQSpecialFriendSettingActivity.b(this.a));
    }
    if (QQSpecialFriendSettingActivity.b(this.a)) {
      return;
    }
    this.a.a.sendEmptyMessage(8194);
    paramArrayOfObject = this.a.a.obtainMessage(8195);
    if (paramBoolean)
    {
      label91:
      paramArrayOfObject.arg1 = i;
      if (!paramBoolean) {
        break label137;
      }
    }
    label137:
    for (i = 2131367798;; i = 2131369178)
    {
      paramArrayOfObject.arg2 = i;
      this.a.a.sendMessage(paramArrayOfObject);
      if (!paramBoolean) {
        break;
      }
      this.a.finish();
      return;
      i = 1;
      break label91;
    }
  }
  
  protected void b(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSpecialFriendSettingActivity", 2, "onSetSpecialCareSwith_specialRing isSuccess: " + paramBoolean);
    }
    if (QQSpecialFriendSettingActivity.b(this.a)) {
      return;
    }
    QQSpecialFriendSettingActivity.b(this.a);
  }
  
  protected void c(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSpecialFriendSettingActivity", 2, "onSetSpecialCareSwith_qzone isSuccess: " + paramBoolean);
    }
    if (QQSpecialFriendSettingActivity.b(this.a)) {}
    while (paramBoolean) {
      return;
    }
    paramArrayOfObject = QQSpecialFriendSettingActivity.b(this.a);
    if (!QQSpecialFriendSettingActivity.b(this.a).a()) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramArrayOfObject.setChecked(paramBoolean);
      return;
    }
  }
  
  protected void d(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    int j = ((Integer)paramArrayOfObject[0]).intValue();
    if (QLog.isColorLevel()) {
      QLog.d("QQSpecialFriendSettingActivity", 2, "onSetSpecialCareSwitchesOfAPerson isSuccess: " + paramBoolean + ",isFromForwardFriendActivity=" + QQSpecialFriendSettingActivity.b(this.a) + ",result=" + j);
    }
    if (!QQSpecialFriendSettingActivity.b(this.a)) {
      return;
    }
    this.a.a.sendEmptyMessage(8194);
    paramArrayOfObject = this.a.a.obtainMessage(8195);
    if ((paramBoolean) && (j == 0))
    {
      i = 2;
      label117:
      paramArrayOfObject.arg1 = i;
      if ((!paramBoolean) || (j != 0)) {
        break label240;
      }
    }
    label240:
    for (int i = 2131367798;; i = 2131369176)
    {
      paramArrayOfObject.arg2 = i;
      this.a.a.sendMessage(paramArrayOfObject);
      if ((!paramBoolean) || (j != 0)) {
        break;
      }
      paramArrayOfObject = new Intent();
      paramArrayOfObject.setClass(this.a, SpecailCareListActivity.class);
      paramArrayOfObject.addFlags(67108864);
      paramArrayOfObject.addFlags(536870912);
      paramArrayOfObject.putExtra("selfSet_leftViewText", this.a.getString(2131369875));
      this.a.startActivity(paramArrayOfObject);
      if (!this.a.isModeleWindow()) {
        break label246;
      }
      this.a.closeModalWindow();
      return;
      i = 1;
      break label117;
    }
    label246:
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     haa
 * JD-Core Version:    0.7.0.1
 */