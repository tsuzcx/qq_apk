import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.troop.activity.TroopAdminList;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class kfh
  extends FriendListObserver
{
  public kfh(TroopAdminList paramTroopAdminList) {}
  
  protected void a(ArrayList paramArrayList, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopAdminList", 2, "onUpdateFriendInfoFinished ");
    }
    this.a.c();
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString))) {
      this.a.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kfh
 * JD-Core Version:    0.7.0.1
 */