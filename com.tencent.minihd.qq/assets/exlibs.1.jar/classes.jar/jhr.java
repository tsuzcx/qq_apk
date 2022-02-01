import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel;
import com.tencent.qphone.base.util.QLog;

public class jhr
  extends FriendListObserver
{
  public jhr(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  protected void a(boolean paramBoolean, Setting paramSetting)
  {
    if ((paramSetting == null) || (NearbyPeopleProfileActivity.a(this.a) == null) || (!NearbyPeopleProfileActivity.a(this.a).uin.equals(paramSetting.uin))) {
      return;
    }
    if ((paramSetting.bFaceFlags & 0x20) != 0) {
      this.a.t = 0;
    }
    for (;;)
    {
      this.a.y = paramSetting.url;
      NearbyPeopleProfileActivity.a(this.a).e();
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("Q.nearby_people_card.", 2, "onGetHeadInfo mheadSize is: " + this.a.t + " mGetHeadUrl is: " + this.a.y);
      return;
      if ((paramSetting.bFaceFlags & 0x10) != 0) {
        this.a.t = 640;
      } else if ((paramSetting.bFaceFlags & 0x8) != 0) {
        this.a.t = 140;
      } else if ((paramSetting.bFaceFlags & 0x4) != 0) {
        this.a.t = 100;
      } else {
        this.a.t = 40;
      }
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (!paramBoolean) {}
    do
    {
      return;
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.nearby_people_card.", 4, "nearbyprofileActivity onUpdateCustomHead.");
      }
    } while ((NearbyPeopleProfileActivity.a(this.a) == null) || (TextUtils.isEmpty(paramString)));
    NearbyPeopleProfileActivity.a(this.a).a(paramString);
  }
  
  protected void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if ((!paramBoolean) || (TextUtils.isEmpty(paramString))) {}
    while ((this.a.o != 3) || (this.a.d) || (NearbyPeopleProfileActivity.a(this.a) == null) || (!paramString.equals(NearbyPeopleProfileActivity.a(this.a).uin))) {
      return;
    }
    b();
  }
  
  protected void a(boolean paramBoolean1, String paramString, int paramInt, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.nearby_people_card.", 2, "onUpdateStangerHead: " + paramBoolean1 + "isStrangerHead: " + paramBoolean2);
    }
    if ((paramBoolean1) && (!TextUtils.isEmpty(paramString)) && (NearbyPeopleProfileActivity.a(this.a) != null) && (paramString.equals(NearbyPeopleProfileActivity.a(this.a).uin)) && (paramBoolean2) && (this.a.t == 640) && (!TextUtils.isEmpty(this.a.y)) && (!this.a.e)) {
      this.a.a(paramString, this.a.t, this.a.y, true);
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!paramBoolean1) || (!paramBoolean2)) {}
    while ((this.a.o != 3) || (NearbyPeopleProfileActivity.a(this.a) == null) || (TextUtils.isEmpty(NearbyPeopleProfileActivity.a(this.a).uin))) {
      return;
    }
    b();
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, Bundle paramBundle)
  {
    if ((!paramBoolean1) || (!paramBoolean2) || (!paramBoolean3) || (TextUtils.isEmpty(paramString))) {}
    while ((this.a.o != 3) || (this.a.d) || (NearbyPeopleProfileActivity.a(this.a) == null) || (!paramString.equals(NearbyPeopleProfileActivity.a(this.a).uin))) {
      return;
    }
    b();
  }
  
  public void b()
  {
    boolean bool = this.a.d;
    FriendManager localFriendManager = (FriendManager)this.a.app.getManager(8);
    if (localFriendManager != null) {
      bool = localFriendManager.b(NearbyPeopleProfileActivity.a(this.a).uin);
    }
    for (;;)
    {
      if (bool != this.a.d)
      {
        this.a.d = bool;
        this.a.runOnUiThread(new jhs(this));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jhr
 * JD-Core Version:    0.7.0.1
 */