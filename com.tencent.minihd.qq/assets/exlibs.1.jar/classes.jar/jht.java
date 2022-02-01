import NS_MOBILE_MAIN_PAGE.mobile_sub_get_cover_rsp;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity.PicInfo;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.profile.view.QzonePhotoView.PhotoInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import tencent.im.oidb.cmd0x5e9.GetPhotoList.HeadInfo;
import tencent.im.oidb.cmd0x5e9.GetPhotoList.RspBody;
import tencent.im.oidb.cmd0x5e9.GetPhotoList.UinHeadInfo;
import tencent.im.oidb.cmd0x5ea.UpdatePhotoList.HeadInfo;

public class jht
  extends CardObserver
{
  public jht(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  protected void onGetQZoneCover(boolean paramBoolean, String paramString, mobile_sub_get_cover_rsp parammobile_sub_get_cover_rsp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.nearby_people_card.", 2, "onGetQZoneCover. isSuc : " + paramBoolean);
    }
    if ((paramBoolean) && (NearbyPeopleProfileActivity.a(this.a) != null) && (paramString.equals(NearbyPeopleProfileActivity.a(this.a).uin)) && (parammobile_sub_get_cover_rsp != null))
    {
      paramString = parammobile_sub_get_cover_rsp.vecUrls;
      if ((paramString != null) && (paramString.size() > 0) && (1 != this.a.o))
      {
        int i = 0;
        while ((i < paramString.size()) && (i < 12))
        {
          parammobile_sub_get_cover_rsp = new QzonePhotoView.PhotoInfo(i, 100, (Map)paramString.get(i));
          NearbyPeopleProfileActivity.PicInfo localPicInfo = new NearbyPeopleProfileActivity.PicInfo();
          localPicInfo.c = parammobile_sub_get_cover_rsp.a();
          localPicInfo.b = parammobile_sub_get_cover_rsp.a(this.a.p);
          this.a.jdField_a_of_type_JavaUtilArrayList.add(localPicInfo);
          if (QLog.isColorLevel()) {
            QLog.i("Q.nearby_people_card.", 2, "onGetQZoneCover. pic is: " + localPicInfo.c);
          }
          i += 1;
        }
        if (NearbyPeopleProfileActivity.a(this.a) != null) {
          NearbyPeopleProfileActivity.a(this.a).a();
        }
      }
    }
  }
  
  protected void onImportQzonePhotos(boolean paramBoolean, ArrayList paramArrayList, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.a.o != 1) {}
    do
    {
      return;
      if ((!paramBoolean) || ((paramInt1 != 0) && (paramInt1 != 1))) {
        break;
      }
      if (paramInt1 == 0)
      {
        this.a.a();
        if ((paramArrayList != null) && (paramArrayList.size() > 0))
        {
          if (paramArrayList.size() > 12) {}
          ArrayList localArrayList;
          for (paramInt1 = 12;; paramInt1 = paramArrayList.size())
          {
            localArrayList = new ArrayList(paramInt1);
            paramInt2 = 0;
            while (paramInt2 < paramInt1)
            {
              UpdatePhotoList.HeadInfo localHeadInfo = (UpdatePhotoList.HeadInfo)paramArrayList.get(paramInt2);
              NearbyPeopleProfileActivity.PicInfo localPicInfo = new NearbyPeopleProfileActivity.PicInfo();
              localPicInfo.a = localHeadInfo.uint32_headid.get();
              localPicInfo.c = localHeadInfo.str_headurl.get();
              localPicInfo.b = (localPicInfo.c + "250");
              localArrayList.add(localPicInfo);
              paramInt2 += 1;
            }
          }
          this.a.jdField_a_of_type_JavaUtilArrayList.addAll(0, localArrayList);
          if (this.a.jdField_a_of_type_JavaUtilArrayList.size() > 13)
          {
            paramInt1 = this.a.jdField_a_of_type_JavaUtilArrayList.size() - 1;
            while (paramInt1 >= 12)
            {
              this.a.jdField_a_of_type_JavaUtilArrayList.remove(paramInt1);
              paramInt1 -= 1;
            }
            this.a.jdField_a_of_type_JavaUtilArrayList.add(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity$PicInfo);
          }
          NearbyPeopleProfileActivity.a(this.a).e();
          NearbyPeopleProfileActivity.a(this.a).a(8);
          this.a.b = true;
          if (paramInt4 > 0)
          {
            paramArrayList = DialogUtil.a(this.a, "最多可同步12张照片，精选照片，展示最好的自己吧。", 0, 0, null, null);
            paramArrayList.setPositiveButton(2131365737, new jhx(this, paramArrayList));
            paramArrayList.show();
          }
        }
        ReportController.b(this.a.app, "CliOper", "", "", "0X800481C", "0X800481C", 0, 0, "", "", "", "");
        return;
      }
    } while (paramInt1 != 1);
    this.a.jdField_a_of_type_AndroidOsHandler.removeMessages(1001);
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1001, 2000L);
    return;
    this.a.a();
    this.a.b("导入失败");
  }
  
  protected void onNearbyCardDownload(boolean paramBoolean, NearbyPeopleCard paramNearbyPeopleCard)
  {
    GetPhotoList.HeadInfo localHeadInfo = null;
    if ((paramNearbyPeopleCard != null) && (paramNearbyPeopleCard.tinyId != this.a.jdField_a_of_type_Long) && ((paramNearbyPeopleCard.uin == null) || (!paramNearbyPeopleCard.uin.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a)))) {
      return;
    }
    this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(new jhu(this), 200L);
    Object localObject2;
    StringBuilder localStringBuilder;
    Object localObject1;
    if ((paramNearbyPeopleCard != null) && (QLog.isColorLevel()))
    {
      localObject2 = new StringBuilder();
      localStringBuilder = ((StringBuilder)localObject2).append("tinyid=").append(paramNearbyPeopleCard.tinyId).append(", uin=").append(paramNearbyPeopleCard.uin).append(", nickname=").append(paramNearbyPeopleCard.nickname).append(", gender=").append(paramNearbyPeopleCard.gender).append(", age=").append(paramNearbyPeopleCard.age).append(", birthday=").append(paramNearbyPeopleCard.birthday).append(", constellation=").append(paramNearbyPeopleCard.constellation).append(", distance=").append(paramNearbyPeopleCard.distance).append(", timeDiff=").append(paramNearbyPeopleCard.timeDiff).append(", photoInfoes=").append(paramNearbyPeopleCard.photoInfoes).append(", photoInfo_length=");
      if (paramNearbyPeopleCard.photoInfoes != null) {
        break label1127;
      }
      localObject1 = "null";
    }
    label322:
    int i;
    for (;;)
    {
      localStringBuilder = localStringBuilder.append(localObject1).append(", likeCount=").append(paramNearbyPeopleCard.likeCount).append(",likeCountInc=").append(paramNearbyPeopleCard.likeCountInc).append(", oldPhotoCount=").append(paramNearbyPeopleCard.oldPhotoCount).append(", dateInfo=").append(paramNearbyPeopleCard.dateInfo).append(", dateInfo_length=");
      if (paramNearbyPeopleCard.dateInfo == null)
      {
        localObject1 = "null";
        localStringBuilder = localStringBuilder.append(localObject1).append(", xuanYan=").append(paramNearbyPeopleCard.xuanYan).append(", xuanYan_length=");
        if (paramNearbyPeopleCard.xuanYan != null) {
          break label1153;
        }
        localObject1 = "null";
        localStringBuilder.append(localObject1).append(", maritalStatus=").append(paramNearbyPeopleCard.maritalStatus).append(", job=").append(paramNearbyPeopleCard.job).append(", company=").append(paramNearbyPeopleCard.company).append(", college=").append(paramNearbyPeopleCard.college).append(", hometownCountry=").append(paramNearbyPeopleCard.hometownCountry).append(", hometownProvice=").append(paramNearbyPeopleCard.hometownProvice).append(", hometownCity=").append(paramNearbyPeopleCard.hometownCity).append(", hometownDistrict=").append(paramNearbyPeopleCard.hometownDistrict).append(", bVoted=").append(paramNearbyPeopleCard.bVoted).append(", feedPreviewTime=").append(paramNearbyPeopleCard.feedPreviewTime).append(", qzoneFeed=").append(paramNearbyPeopleCard.qzoneFeed).append(", qzoneName=").append(paramNearbyPeopleCard.qzoneName).append(", qzonePicUrl_1=").append(paramNearbyPeopleCard.qzonePicUrl_1).append(", qzonePicUrl_2=").append(paramNearbyPeopleCard.qzonePicUrl_2).append(", qzonePicUrl_3=").append(paramNearbyPeopleCard.qzonePicUrl_3).append(", isPhotoUseCache=").append(paramNearbyPeopleCard.isPhotoUseCache).append(", switchQzone=").append(paramNearbyPeopleCard.switchQzone).append(", switchHobby=").append(paramNearbyPeopleCard.switchHobby).append(", uiShowControl=").append(paramNearbyPeopleCard.uiShowControl).append(", userFlag=").append(paramNearbyPeopleCard.userFlag).append(", strProfileUrl=").append(paramNearbyPeopleCard.strProfileUrl);
        QLog.d("Q.nearby_people_card.", 2, "Q.nearby_people_card..onNearbyCardDownload(), isSuccess: " + paramBoolean + ", card = " + ((StringBuilder)localObject2).toString());
        if ((!paramBoolean) || (paramNearbyPeopleCard == null)) {
          break label1565;
        }
        this.a.jdField_a_of_type_Boolean = true;
        NearbyPeopleProfileActivity.a(this.a, paramNearbyPeopleCard);
        this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a = NearbyPeopleProfileActivity.a(this.a).uin;
        this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h = NearbyPeopleProfileActivity.a(this.a).nickname;
        if (this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b != null)
        {
          NearbyPeopleProfileActivity.a(this.a).distance = this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b;
          NearbyPeopleProfileActivity.a(this.a).timeDiff = null;
        }
        localObject1 = new GetPhotoList.RspBody();
      }
      try
      {
        ((GetPhotoList.RspBody)localObject1).mergeFrom(paramNearbyPeopleCard.photoInfoes);
        if (((GetPhotoList.RspBody)localObject1).rpt_msg_uin_heads.has())
        {
          localObject1 = ((GetPhotoList.UinHeadInfo)((GetPhotoList.RspBody)localObject1).rpt_msg_uin_heads.get().get(0)).rpt_msg_headinfo.get();
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder().append("head size = ");
            if (localObject1 == null)
            {
              paramNearbyPeopleCard = "null";
              QLog.d("Q.nearby_people_card.", 2, paramNearbyPeopleCard);
            }
          }
          else
          {
            if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
              break label1408;
            }
            int j = Math.min(12, ((List)localObject1).size());
            paramNearbyPeopleCard = localHeadInfo;
            if (this.a.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
              paramNearbyPeopleCard = (NearbyPeopleProfileActivity.PicInfo)this.a.jdField_a_of_type_JavaUtilArrayList.get(this.a.jdField_a_of_type_JavaUtilArrayList.size() - 1);
            }
            this.a.jdField_a_of_type_JavaUtilArrayList.clear();
            i = 0;
            for (;;)
            {
              if (i < j)
              {
                localHeadInfo = (GetPhotoList.HeadInfo)((List)localObject1).get(i);
                localObject2 = new NearbyPeopleProfileActivity.PicInfo();
                ((NearbyPeopleProfileActivity.PicInfo)localObject2).a = localHeadInfo.uint32_headid.get();
                ((NearbyPeopleProfileActivity.PicInfo)localObject2).c = localHeadInfo.str_headurl.get();
                ((NearbyPeopleProfileActivity.PicInfo)localObject2).b = (((NearbyPeopleProfileActivity.PicInfo)localObject2).c + "250");
                this.a.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
                if (QLog.isColorLevel()) {
                  QLog.d("Q.nearby_people_card.", 2, "photo_id = " + ((NearbyPeopleProfileActivity.PicInfo)localObject2).a + ", big_pic_url = " + ((NearbyPeopleProfileActivity.PicInfo)localObject2).c);
                }
                i += 1;
                continue;
                label1127:
                localObject1 = Integer.valueOf(paramNearbyPeopleCard.photoInfoes.length);
                break;
                localObject1 = Integer.valueOf(paramNearbyPeopleCard.dateInfo.length);
                break label322;
                label1153:
                localObject1 = Integer.valueOf(paramNearbyPeopleCard.xuanYan.length);
              }
            }
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramNearbyPeopleCard)
      {
        for (;;)
        {
          if (QLog.isColorLevel())
          {
            QLog.d("Q.nearby_people_card.", 2, "Q.nearby_people_card..onNearbyCardDownload(), parse head info fail.");
            continue;
            paramNearbyPeopleCard = Integer.valueOf(((List)localObject1).size());
          }
        }
        if ((paramNearbyPeopleCard != null) && (paramNearbyPeopleCard == this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity$PicInfo)) {
          this.a.jdField_a_of_type_JavaUtilArrayList.add(paramNearbyPeopleCard);
        }
      }
    }
    if ((this.a.o == 3) && (NearbyPeopleProfileActivity.a(this.a) != null))
    {
      if (Utils.a(this.a.app.a(), NearbyPeopleProfileActivity.a(this.a).uin))
      {
        this.a.getIntent().putExtra("param_mode", 2);
        this.a.o = 2;
      }
    }
    else
    {
      label1296:
      if (this.a.o != 1) {
        break label1526;
      }
      NearbyPeopleProfileActivity.a(this.a).a(NearbyPeopleProfileActivity.a(this.a));
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(100, 1000L);
      label1340:
      localObject1 = this.a.app;
      i = this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g;
      if (NearbyPeopleProfileActivity.a(this.a) == null) {
        break label1559;
      }
    }
    label1408:
    label1559:
    for (paramNearbyPeopleCard = NearbyPeopleProfileActivity.a(this.a).uin;; paramNearbyPeopleCard = "")
    {
      ReportController.b((QQAppInterface)localObject1, "CliOper", "", "", "0X8004CC5", "0X8004CC5", i, 0, paramNearbyPeopleCard, "", "", "");
      return;
      if (1 == this.a.o) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.nearby_people_card.", 2, "onNearbyCardDownload need to getQzoneCover.");
      }
      this.a.e = false;
      this.a.jdField_a_of_type_ComTencentMobileqqAppCardHandler.a(NearbyPeopleProfileActivity.a(this.a).uin, 2);
      break;
      if (TextUtils.isEmpty(NearbyPeopleProfileActivity.a(this.a).uin)) {
        break label1296;
      }
      paramNearbyPeopleCard = (FriendsManager)this.a.app.getManager(49);
      if (paramNearbyPeopleCard == null) {
        break label1296;
      }
      this.a.d = paramNearbyPeopleCard.b(NearbyPeopleProfileActivity.a(this.a).uin);
      break label1296;
      label1526:
      this.a.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
      NearbyPeopleProfileActivity.a(this.a).a(NearbyPeopleProfileActivity.a(this.a), false);
      break label1340;
    }
    label1565:
    QQToast.a(this.a, "加载失败", 0).b(this.a.getTitleBarHeight());
  }
  
  protected void onQueryImportQzonePhotoesStatus(boolean paramBoolean, ArrayList paramArrayList, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.a.o != 1) {}
    do
    {
      return;
      if ((!paramBoolean) || ((paramInt1 != 0) && (paramInt1 != 1))) {
        break;
      }
      if (paramInt1 == 0)
      {
        this.a.a();
        if ((paramArrayList != null) && (paramArrayList.size() > 0))
        {
          if (paramArrayList.size() > 12) {}
          ArrayList localArrayList;
          for (paramInt1 = 12;; paramInt1 = paramArrayList.size())
          {
            localArrayList = new ArrayList(paramInt1);
            paramInt2 = 0;
            while (paramInt2 < paramInt1)
            {
              UpdatePhotoList.HeadInfo localHeadInfo = (UpdatePhotoList.HeadInfo)paramArrayList.get(paramInt2);
              NearbyPeopleProfileActivity.PicInfo localPicInfo = new NearbyPeopleProfileActivity.PicInfo();
              localPicInfo.a = localHeadInfo.uint32_headid.get();
              localPicInfo.c = localHeadInfo.str_headurl.get();
              localPicInfo.b = (localPicInfo.c + "250");
              localArrayList.add(localPicInfo);
              paramInt2 += 1;
            }
          }
          this.a.jdField_a_of_type_JavaUtilArrayList.addAll(0, localArrayList);
          if (this.a.jdField_a_of_type_JavaUtilArrayList.size() > 13)
          {
            paramInt1 = this.a.jdField_a_of_type_JavaUtilArrayList.size() - 1;
            while (paramInt1 >= 12)
            {
              this.a.jdField_a_of_type_JavaUtilArrayList.remove(paramInt1);
              paramInt1 -= 1;
            }
            this.a.jdField_a_of_type_JavaUtilArrayList.add(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity$PicInfo);
          }
          NearbyPeopleProfileActivity.a(this.a).e();
          NearbyPeopleProfileActivity.a(this.a).a(8);
          this.a.b = true;
          if (paramInt4 > 0)
          {
            paramArrayList = DialogUtil.a(this.a, "最多可同步12张照片，精选照片，展示最好的自己吧。", 0, 0, null, null);
            paramArrayList.setPositiveButton(2131365737, new jhy(this, paramArrayList));
            paramArrayList.show();
          }
        }
        ReportController.b(this.a.app, "CliOper", "", "", "0X800481C", "0X800481C", 0, 0, "", "", "", "");
        return;
      }
    } while (paramInt1 != 1);
    this.a.jdField_a_of_type_AndroidOsHandler.removeMessages(1001);
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1001, 2000L);
    return;
    this.a.a();
    this.a.b("导入失败");
  }
  
  protected void onReqFavoriteResult(boolean paramBoolean, String paramString1, String paramString2)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (NearbyPeopleProfileActivity.a(this.a) == null) || (TextUtils.isEmpty(NearbyPeopleProfileActivity.a(this.a).uin)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1)) || (Utils.a(paramString2, paramString1))) {}
    while ((!Utils.a(paramString2, NearbyPeopleProfileActivity.a(this.a).uin)) || (!Utils.a(paramString1, this.a.app.a())) || (paramBoolean)) {
      return;
    }
    QQToast.a(this.a, 2131368258, 0).b(this.a.getTitleBarHeight());
    paramString1 = NearbyPeopleProfileActivity.a(this.a);
    paramString1.likeCount -= 1;
    NearbyPeopleProfileActivity.a(this.a).bVoted = 0;
    NearbyPeopleProfileActivity.a(this.a).b();
  }
  
  protected void onUpdateNearbyPeoplePhotoList(boolean paramBoolean)
  {
    if (this.a.o != 1) {
      return;
    }
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.nearby_people_card.", 2, "onUpdateNearbyPeopleList hasNewPhoto true.");
      }
      this.a.e = true;
      this.a.app.a(new jhv(this));
      return;
    }
    this.a.a();
    QQToast.a(this.a, "资料保存失败", 0).b(this.a.getTitleBarHeight());
  }
  
  protected void onUpdateNearbyProfile(boolean paramBoolean, NearbyPeopleCard paramNearbyPeopleCard)
  {
    int j = 1;
    if (this.a.o != 1) {}
    while ((paramNearbyPeopleCard != null) && (paramNearbyPeopleCard.tinyId != this.a.jdField_a_of_type_Long) && ((paramNearbyPeopleCard.uin == null) || (!paramNearbyPeopleCard.uin.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a)))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby_people_card.update_profile", 2, "Q.nearby_people_card..onUpdateNearbyProfile(), isSuccess: " + paramBoolean + ", card = " + paramNearbyPeopleCard);
    }
    this.a.a();
    int i;
    if ((paramBoolean) && (paramNearbyPeopleCard != null))
    {
      this.a.b = false;
      QQToast.a(this.a, 2, "资料保存成功", 0).b(this.a.getTitleBarHeight());
      NearbyPeopleProfileActivity.a(this.a, paramNearbyPeopleCard);
      if (this.a.getIntent().getIntExtra("param_mode", 0) == 1)
      {
        NearbyPeopleProfileActivity.a(this.a);
        paramNearbyPeopleCard = new Intent();
        paramNearbyPeopleCard.putExtra("param_xuan_yan", NearbyPeopleProfileActivity.a(this.a).xuanYan);
        paramNearbyPeopleCard.putExtra("param_nickname", NearbyPeopleProfileActivity.a(this.a).nickname);
        paramNearbyPeopleCard.putExtra("param_gender", NearbyPeopleProfileActivity.a(this.a).gender);
        paramNearbyPeopleCard.putExtra("param_age", NearbyPeopleProfileActivity.a(this.a).age);
        paramNearbyPeopleCard.putExtra("param_career", NearbyPeopleProfileActivity.a(this.a).job);
        paramNearbyPeopleCard.putExtra("param_constellation", NearbyPeopleProfileActivity.a(this.a).constellation);
        paramNearbyPeopleCard.putExtra("param_marital_status", NearbyPeopleProfileActivity.a(this.a).maritalStatus);
        i = this.a.jdField_a_of_type_JavaUtilArrayList.size();
        if ((this.a.jdField_a_of_type_JavaUtilArrayList.size() <= 0) || (!((NearbyPeopleProfileActivity.PicInfo)this.a.jdField_a_of_type_JavaUtilArrayList.get(this.a.jdField_a_of_type_JavaUtilArrayList.size() - 1)).equals(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity$PicInfo))) {
          break label523;
        }
        i = this.a.jdField_a_of_type_JavaUtilArrayList.size() - 1;
      }
    }
    label523:
    for (;;)
    {
      paramNearbyPeopleCard.putExtra("param_photo_count", i);
      this.a.setResult(-1, paramNearbyPeopleCard);
      paramNearbyPeopleCard = this.a.app;
      if (this.a.getIntent().getIntExtra("param_mode", 0) == 1) {}
      for (i = j;; i = 2)
      {
        ReportController.b(paramNearbyPeopleCard, "CliOper", "", "", "0X8004823", "0X8004823", i, 0, "", "", "", "");
        return;
        if (this.a.r != 1) {
          NearbyPeopleProfileActivity.b(this.a);
        }
        NearbyPeopleProfileActivity.c(this.a);
        break;
      }
      QQToast.a(this.a, "资料保存失败", 0).b(this.a.getTitleBarHeight());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jht
 * JD-Core Version:    0.7.0.1
 */