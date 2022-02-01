import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.troop.utils.TroopAvatarManger;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;

public class fhe
  extends TroopObserver
{
  public fhe(TroopInfoActivity paramTroopInfoActivity) {}
  
  protected void a(int paramInt1, boolean paramBoolean, int paramInt2, List paramList)
  {
    Message localMessage = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage();
    localMessage.what = 7;
    localMessage.obj = paramList;
    localMessage.arg1 = paramInt2;
    if (paramBoolean) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      localMessage.arg2 = paramInt1;
      this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
      return;
    }
  }
  
  protected void a(String paramString, int paramInt1, List paramList, int paramInt2)
  {
    TroopInfo localTroopInfo = ((FriendManager)this.a.app.getManager(8)).a(paramString);
    Message localMessage = new Message();
    localMessage.what = 8;
    Bundle localBundle = localMessage.getData();
    if (localTroopInfo != null) {
      if (localTroopInfo.mTroopPicList != null) {
        localBundle.putStringArrayList("AVATAR_WALL_LIST", (ArrayList)localTroopInfo.mTroopPicList);
      }
    }
    for (;;)
    {
      localBundle.putInt("newSeq", paramInt1);
      localBundle.putString("troopUin", paramString);
      localBundle.putInt("CMD_TYPE", paramInt2);
      if (this.a.jdField_a_of_type_AndroidOsHandler != null) {
        this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
      }
      return;
      localBundle.putStringArrayList("AVATAR_WALL_LIST", null);
      continue;
      if (paramList != null) {
        localBundle.putStringArrayList("AVATAR_WALL_LIST", (ArrayList)paramList);
      } else {
        localBundle.putStringArrayList("AVATAR_WALL_LIST", null);
      }
    }
  }
  
  protected void a(boolean paramBoolean1, byte paramByte, TroopInfo paramTroopInfo, boolean paramBoolean2)
  {
    if ((!paramBoolean1) || (paramTroopInfo == null) || (!Utils.a(paramTroopInfo.troopuin, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.c))) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopinfo", 2, "onTroopSearch|result = " + paramByte + ", p = " + paramTroopInfo);
      }
    } while (paramByte != 0);
    this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = paramTroopInfo;
    this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.a(paramTroopInfo, this.a.app.a());
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
  }
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt, TroopInfo paramTroopInfo)
  {
    if (!Utils.a(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.c, String.valueOf(paramLong))) {}
    do
    {
      do
      {
        return;
        if ((this.a.jdField_a_of_type_JavaUtilList != null) && (this.a.jdField_a_of_type_JavaUtilList.contains(Integer.valueOf(paramInt))))
        {
          this.a.jdField_a_of_type_JavaUtilList.remove(Integer.valueOf(paramInt));
          if (paramTroopInfo != null) {
            this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = paramTroopInfo;
          }
          if (paramBoolean)
          {
            this.a.a(2131366194, 2);
            return;
          }
          this.a.a(2131366195, 1);
          TroopInfoActivity.a(this.a, paramInt);
          return;
        }
      } while ((!paramBoolean) || (paramTroopInfo == null));
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = paramTroopInfo;
    } while ((this.a.jdField_a_of_type_JavaUtilList != null) && (this.a.jdField_a_of_type_JavaUtilList.size() != 0));
    this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.a(paramTroopInfo, this.a.app.a());
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
  }
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt1, TroopInfo paramTroopInfo, int paramInt2, String paramString)
  {
    this.a.q();
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Int == 4) {}
    while (paramLong != Long.parseLong(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.c)) {
      return;
    }
    if (paramBoolean)
    {
      if ((paramTroopInfo.cGroupOption == 4) || (paramTroopInfo.cGroupOption == 5)) {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_r_of_type_JavaLangString = paramTroopInfo.joinTroopQuestion;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Short = ((short)(byte)paramTroopInfo.cGroupOption);
      TroopInfoActivity.c(this.a);
      return;
    }
    this.a.a(2131366997, 1);
  }
  
  protected void a(boolean paramBoolean, TroopInfo paramTroopInfo)
  {
    if ((paramBoolean) && (paramTroopInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin != null) && (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin.equals(paramTroopInfo.troopuin)))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopowneruin = paramTroopInfo.troopowneruin;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopname = paramTroopInfo.troopname;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopface = paramTroopInfo.troopface;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopmemo = paramTroopInfo.troopmemo;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.fingertroopmemo = paramTroopInfo.fingertroopmemo;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.mRichFingerMemo = paramTroopInfo.mRichFingerMemo;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.strLocation = paramTroopInfo.strLocation;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopLat = paramTroopInfo.troopLat;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopLon = paramTroopInfo.troopLon;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.dwGroupFlagExt = paramTroopInfo.dwGroupFlagExt;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopAuthenticateInfo = paramTroopInfo.troopAuthenticateInfo;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopTypeExt = paramTroopInfo.troopTypeExt;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.dwGroupClassExt = paramTroopInfo.dwGroupClassExt;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.mTags = paramTroopInfo.mTags;
      if (!TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.mRichFingerMemo)) {
        break label480;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.mRichFingerMemo = this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.fingertroopmemo;
      this.a.aM = this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopTypeExt;
      this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.a(this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo, this.a.app.a());
      if ((this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Boolean))
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("Q.troopinfo", 4, "updateTroopInfoToDB");
        }
        ((FriendsManagerImp)this.a.app.getManager(8)).b(this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo);
      }
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
      if (4 == this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_r_of_type_Int) {
        TroopInfoActivity.d(this.a);
      }
      if ((3 != this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_r_of_type_Int) && (4 != this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_r_of_type_Int)) {
        break label529;
      }
      TroopInfoActivity.e(this.a);
      if (TroopInfoActivity.a(this.a) != null) {
        TroopInfoActivity.b(this.a).setVisibility(0);
      }
    }
    label480:
    while (TroopInfoActivity.a(this.a) == null)
    {
      return;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.mRichFingerMemo = HttpUtil.c(this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.mRichFingerMemo);
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.mRichFingerMemo = HttpUtil.b(this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.mRichFingerMemo);
      break;
    }
    label529:
    TroopInfoActivity.a(this.a).a(TroopInfoActivity.a(this.a));
    TroopInfoActivity.a(this.a, null);
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if ((!paramBoolean) || (!Utils.a(paramString, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.c))) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopinfo", 2, "onGetTroopInfoResult|uin = " + paramString);
      }
      paramString = ((FriendManager)this.a.app.getManager(8)).a(paramString);
    } while (paramString == null);
    this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = paramString;
    this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.a(paramString, this.a.app.a());
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
  }
  
  protected void a(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, List paramList)
  {
    if (this.a.c) {}
    do
    {
      do
      {
        return;
      } while ((this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) || (!paramBoolean) || (!Utils.a(paramString1, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.c)));
      if (paramInt1 == 0)
      {
        a(paramString1, paramInt2, paramList, 0);
        return;
      }
      if (paramString2 != null)
      {
        QQToast.a(this.a, paramString2, 1).b(this.a.getTitleBarHeight());
        return;
      }
      if ((paramInt1 == 1) && (paramInt1 == 2))
      {
        QQToast.a(this.a, this.a.getString(2131363767), 1).b(this.a.getTitleBarHeight());
        return;
      }
      if (paramInt1 == 19)
      {
        QQToast.a(this.a, this.a.getString(2131363768), 1).b(this.a.getTitleBarHeight());
        return;
      }
    } while (paramInt1 != 65);
    QQToast.a(this.a, this.a.getString(2131363769), 1).b(this.a.getTitleBarHeight());
  }
  
  protected void a(boolean paramBoolean, ArrayList paramArrayList)
  {
    if ((!paramBoolean) || (paramArrayList == null) || (paramArrayList.size() == 0)) {}
    Object localObject;
    do
    {
      return;
      int i = 0;
      localObject = null;
      if ((localObject == null) && (i < paramArrayList.size()))
      {
        TroopInfo localTroopInfo = (TroopInfo)paramArrayList.get(i);
        if (localTroopInfo == null) {
          localObject = localTroopInfo;
        }
        for (;;)
        {
          i += 1;
          break;
          localObject = localTroopInfo;
          if (!Utils.a(localTroopInfo.troopuin, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.c)) {
            localObject = null;
          }
        }
      }
    } while (localObject == null);
    this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = localObject;
    this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.a(localObject, this.a.app.a());
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
  }
  
  protected void b(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.mTags = paramString;
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_JavaUtilList = TroopInfo.getTags(paramString);
      }
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
    }
  }
  
  protected void b(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, List paramList)
  {
    TroopAvatarManger.jdField_a_of_type_Int -= 1;
    if (this.a.c) {
      return;
    }
    if (paramInt1 == 0)
    {
      a(paramString1, 23, paramList, 1);
      return;
    }
    if (paramString2 != null)
    {
      a(paramString1, 23, paramList, 0);
      QQToast.a(this.a, paramString2, 1).b(this.a.getTitleBarHeight());
      return;
    }
    if (paramInt1 == 1)
    {
      QQToast.a(this.a, this.a.getString(2131363767), 1).b(this.a.getTitleBarHeight());
      return;
    }
    if (paramInt1 == 2)
    {
      QQToast.a(this.a, this.a.getString(2131363768), 1).b(this.a.getTitleBarHeight());
      return;
    }
    if (paramInt1 == 3)
    {
      QQToast.a(this.a, this.a.getString(2131363771), 1).b(this.a.getTitleBarHeight());
      return;
    }
    if (paramInt1 == 4)
    {
      QQToast.a(this.a, this.a.getString(2131363772), 1).b(this.a.getTitleBarHeight());
      return;
    }
    QQToast.a(this.a, this.a.getString(2131363773), 1).b(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fhe
 * JD-Core Version:    0.7.0.1
 */