import android.text.TextUtils;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import tencent.im.oidb.cmd0x7df.oidb_0x7df.FriendScore;

public class hbc
  implements Runnable
{
  public hbc(SpecailCareListActivity paramSpecailCareListActivity) {}
  
  public void run()
  {
    if ((this.a.b.size() <= 0) && (this.a.a(1)))
    {
      Object localObject = ((FriendListHandler)this.a.app.a(1)).a();
      if ((localObject == null) || (((ArrayList)localObject).size() <= 0)) {
        break label263;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SpecailCareListActivity", 2, "fh.getRecommendList() return size:" + ((ArrayList)localObject).size());
      }
      this.a.jdField_a_of_type_JavaUtilArrayList.clear();
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        oidb_0x7df.FriendScore localFriendScore = (oidb_0x7df.FriendScore)((Iterator)localObject).next();
        hbk localhbk = new hbk();
        localhbk.a = String.valueOf(localFriendScore.uint64_friend_uin.get());
        Friends localFriends = this.a.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(localhbk.a);
        if (localFriends != null) {
          localhbk.b = ContactUtils.a(localFriends);
        }
        if ((TextUtils.isEmpty(localhbk.b)) && (localFriendScore.bytes_nick != null) && (localFriendScore.bytes_nick.get() != null)) {
          localhbk.b = localFriendScore.bytes_nick.get().toStringUtf8();
        }
        this.a.jdField_a_of_type_JavaUtilArrayList.add(localhbk);
      }
      this.a.runOnUiThread(new hbd(this));
    }
    for (;;)
    {
      this.a.a(1, true);
      this.a.a(2, true);
      return;
      label263:
      if (QLog.isColorLevel()) {
        QLog.d("SpecailCareListActivity", 2, "fh.getRecommendList(): empty...");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     hbc
 * JD-Core Version:    0.7.0.1
 */