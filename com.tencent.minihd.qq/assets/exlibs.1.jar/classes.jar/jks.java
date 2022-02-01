import android.text.TextUtils;
import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.mobileqq.nearpeople.TurnBrandActivity;
import com.tencent.mobileqq.nearpeople.TurnBrandDownloader;
import com.tencent.mobileqq.nearpeople.TurnBrandPopupView;
import com.tencent.mobileqq.nearpeople.TurnBrandView;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import tencent.im.fanpaizi.FanPaiZi.RespDislike;
import tencent.im.fanpaizi.FanPaiZi.RespGetList;
import tencent.im.fanpaizi.FanPaiZi.RespPrise;
import tencent.im.fanpaizi.FanPaiZi.UserProfile;

public class jks
  extends LBSObserver
{
  public jks(TurnBrandActivity paramTurnBrandActivity) {}
  
  protected void a(boolean paramBoolean, FanPaiZi.RespDislike paramRespDislike)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TurnBrandActivity", 2, "onRespLbsTurnBrandDislike isSuccess=" + paramBoolean + ", RespDislike: " + paramRespDislike);
    }
  }
  
  protected void a(boolean paramBoolean, FanPaiZi.RespGetList paramRespGetList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TurnBrandActivity", 2, "onGetLbsTurnBrandUserList isSuccess= " + paramBoolean);
    }
    if ((paramBoolean) && (paramRespGetList != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TurnBrandActivity", 2, "rcv UserList suc and response is not null!");
      }
      List localList = paramRespGetList.rpt_msg_user_list.get();
      if ((localList == null) || (localList.size() <= 0))
      {
        this.a.b(2001, this.a.getString(2131369586));
        if (QLog.isColorLevel()) {
          QLog.d("TurnBrandActivity", 2, "rcv profileList is null!");
        }
        return;
      }
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      if (i < localList.size())
      {
        label174:
        String str1;
        label216:
        int j;
        label255:
        int k;
        label294:
        String str2;
        label333:
        int m;
        label372:
        String str3;
        if (((FanPaiZi.UserProfile)localList.get(i)).uint64_tinyid.has())
        {
          paramRespGetList = String.valueOf(((FanPaiZi.UserProfile)localList.get(i)).uint64_tinyid.get());
          if (!((FanPaiZi.UserProfile)localList.get(i)).bytes_face_url.has()) {
            break label618;
          }
          str1 = ((FanPaiZi.UserProfile)localList.get(i)).bytes_face_url.get().toStringUtf8();
          if (!((FanPaiZi.UserProfile)localList.get(i)).int32_sex.has()) {
            break label625;
          }
          j = ((FanPaiZi.UserProfile)localList.get(i)).int32_sex.get();
          if (!((FanPaiZi.UserProfile)localList.get(i)).int32_age.has()) {
            break label631;
          }
          k = ((FanPaiZi.UserProfile)localList.get(i)).int32_age.get();
          if (!((FanPaiZi.UserProfile)localList.get(i)).str_nick.has()) {
            break label637;
          }
          str2 = ((FanPaiZi.UserProfile)localList.get(i)).str_nick.get();
          if (!((FanPaiZi.UserProfile)localList.get(i)).int32_prised.has()) {
            break label644;
          }
          m = ((FanPaiZi.UserProfile)localList.get(i)).int32_prised.get();
          if (!((FanPaiZi.UserProfile)localList.get(i)).uint64_uin.has()) {
            break label650;
          }
          str3 = String.valueOf(((FanPaiZi.UserProfile)localList.get(i)).uint64_uin.get());
          label414:
          if (!((FanPaiZi.UserProfile)localList.get(i)).bytes_sig.has()) {
            break label657;
          }
        }
        label644:
        label650:
        label657:
        for (String str4 = ((FanPaiZi.UserProfile)localList.get(i)).bytes_sig.get().toStringUtf8();; str4 = "")
        {
          if (QLog.isColorLevel()) {
            QLog.d("TurnBrandActivity", 2, "UserProfile: i: " + i + ", tinyid: " + paramRespGetList + ", faceUrl: " + str1 + ", sex: " + j + ", age: " + k + ", nick: " + str2 + ", prised: " + m + ", uin: " + str3 + ", sig: " + str4);
          }
          if (!TextUtils.isEmpty(paramRespGetList)) {
            localArrayList.add(new jku(this.a, paramRespGetList, str1, j, k, str2, m, str3, str4));
          }
          i += 1;
          break;
          paramRespGetList = "";
          break label174;
          label618:
          str1 = "";
          break label216;
          label625:
          j = -1;
          break label255;
          label631:
          k = -1;
          break label294;
          label637:
          str2 = "";
          break label333;
          m = -1;
          break label372;
          str3 = "";
          break label414;
        }
      }
      if (localArrayList.size() <= 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TurnBrandActivity", 2, "All the tiny id of user list are empty!");
        }
        this.a.b(2001, this.a.getString(2131369586));
        return;
      }
      this.a.c(2003);
      TurnBrandActivity.a(this.a).setDataList(localArrayList);
      TurnBrandActivity.a(this.a).clear();
      if (QLog.isColorLevel()) {
        QLog.d("TurnBrandActivity", 2, "pull list finished and switch to brand view!");
      }
      this.a.b(2003, null);
      TurnBrandActivity.a(this.a, TurnBrandActivity.a(this.a).b());
      TurnBrandActivity.a(this.a).a(TurnBrandActivity.a(this.a).a, TurnBrandActivity.a(this.a).b);
      TurnBrandActivity.d(this.a);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TurnBrandActivity", 2, "onGetLbsTurnBrandUserList failed!");
    }
    this.a.b(2001, this.a.getString(2131369585));
  }
  
  protected void a(boolean paramBoolean, FanPaiZi.RespPrise paramRespPrise)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TurnBrandActivity", 2, "onRespLbsTurnBrandPrise isSuccess=" + paramBoolean + ", RespPrise: " + paramRespPrise);
    }
    if ((paramRespPrise != null) && (QLog.isColorLevel())) {
      QLog.d("TurnBrandActivity", 2, "onRespLbsTurnBrandPrise int32_prise_each_other =" + paramRespPrise.int32_prise_each_other.get() + ", uint64_peer_tinyid: " + paramRespPrise.uint64_peer_tinyid.get() + ", uint64_peer_uin: " + paramRespPrise.uint64_peer_uin.get() + ", bytes_sig: " + paramRespPrise.bytes_sig.get().toStringUtf8());
    }
    String str;
    long l;
    jku localjku;
    if ((paramBoolean) && (paramRespPrise != null) && (paramRespPrise.int32_prise_each_other.has()) && (paramRespPrise.int32_prise_each_other.get() == 1))
    {
      str = String.valueOf(paramRespPrise.uint64_peer_tinyid.get());
      l = paramRespPrise.uint64_peer_uin.get();
      localjku = (jku)TurnBrandActivity.a(this.a).get(str);
      if (localjku == null) {
        break label346;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TurnBrandActivity", 2, "onRespLbsTurnBrandPrise: mutual prised and popup dialog!");
      }
      if ((TurnBrandActivity.a(this.a) == null) || (!TurnBrandActivity.a(this.a).isShown()) || (this.a.a == null)) {
        break label280;
      }
      this.a.a.add(localjku);
      TurnBrandActivity.a(this.a).remove(str);
    }
    label280:
    label346:
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        return;
        this.a.a(2004, true);
        TurnBrandActivity.a(this.a).a(TurnBrandDownloader.a(localjku.b));
        TurnBrandActivity.a(this.a).a(localjku.c, String.valueOf(l), paramRespPrise.bytes_sig.get().toStringUtf8(), localjku.b);
      }
    }
    QLog.d("TurnBrandActivity", 2, "onRespLbsTurnBrandPrise dismatch with prise request: tiny id: " + str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jks
 * JD-Core Version:    0.7.0.1
 */