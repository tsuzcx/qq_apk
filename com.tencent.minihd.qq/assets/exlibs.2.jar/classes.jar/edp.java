import com.tencent.mobileqq.activity.GroupManagerActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.proxy.GroupActionResp;
import com.tencent.qphone.base.util.QLog;

public class edp
  extends FriendListObserver
{
  public edp(GroupManagerActivity paramGroupManagerActivity) {}
  
  protected void a(boolean paramBoolean, GroupActionResp paramGroupActionResp)
  {
    if (QLog.isColorLevel()) {
      QLog.d(GroupManagerActivity.a, 2, "onAddGroupResp isSuccess = " + paramBoolean);
    }
    this.a.a(paramBoolean);
    GroupManagerActivity.c(this.a, true);
  }
  
  protected void b(boolean paramBoolean, GroupActionResp paramGroupActionResp)
  {
    if (QLog.isColorLevel()) {
      QLog.d(GroupManagerActivity.a, 2, "onRenameGroupResp isSuccess = " + paramBoolean);
    }
    this.a.a(paramBoolean);
    GroupManagerActivity.c(this.a, true);
  }
  
  protected void c(boolean paramBoolean, GroupActionResp paramGroupActionResp)
  {
    if (QLog.isColorLevel()) {
      QLog.d(GroupManagerActivity.a, 2, "onDeleteGroupResp isSuccess = " + paramBoolean);
    }
    this.a.a(paramBoolean);
    GroupManagerActivity.c(this.a, true);
  }
  
  protected void d(boolean paramBoolean, GroupActionResp paramGroupActionResp)
  {
    if (QLog.isColorLevel()) {
      QLog.d(GroupManagerActivity.a, 2, "onResortGroupResp isSuccess = " + paramBoolean);
    }
    this.a.a(true);
    GroupManagerActivity.c(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     edp
 * JD-Core Version:    0.7.0.1
 */