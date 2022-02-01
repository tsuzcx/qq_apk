import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.equipmentlock.EquipLockWebImpl;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ihl
  extends FriendListObserver
{
  public ihl(EquipLockWebImpl paramEquipLockWebImpl) {}
  
  protected void b(boolean paramBoolean, ArrayList paramArrayList)
  {
    if (paramBoolean) {
      EquipmentLockImpl.a().a(paramArrayList);
    }
    for (;;)
    {
      EquipLockWebImpl.a(this.a, false);
      EquipLockWebImpl.b(this.a, false);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("EquipLockWebImpl", 2, "error, fetch recommend list !");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ihl
 * JD-Core Version:    0.7.0.1
 */