package com.tencent.mobileqq.data;

import com.tencent.mobileqq.mp.mobileqq_mp.ConfigGroupInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.ConfigInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoResponse;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class AccountDetail
  extends Entity
{
  public byte[] accountData = null;
  public int accountFlag = 0;
  public String certifiedDescription = "腾讯认证生活服务号";
  public int certifiedGrade = 0;
  public String configBackgroundColor = "3d7fe3";
  public String displayNumber = "";
  public int followType = 0;
  public int groupId = 0;
  public List groupInfoList;
  public boolean isAgreeSyncLbs = false;
  public boolean isConfirmed = false;
  public boolean isRecvMsg = false;
  public boolean isRecvPush = false;
  public boolean isShowFollowButton = false;
  public boolean isShowShareButton = false;
  public boolean isSyncLbs = false;
  public boolean isSyncLbsSelected = false;
  public int mShowMsgFlag = -1;
  public String name = "公众帐号";
  public List newGroupInfoList;
  public int seqno = 0;
  public int showFlag = 0;
  public String summary = "挺好的";
  @unique
  public String uin;
  
  public AccountDetail() {}
  
  public AccountDetail(mobileqq_mp.GetPublicAccountDetailInfoResponse paramGetPublicAccountDetailInfoResponse)
  {
    this.uin = ("" + (paramGetPublicAccountDetailInfoResponse.uin.get() & 0xFFFFFFFF));
    this.seqno = paramGetPublicAccountDetailInfoResponse.seqno.get();
    this.name = paramGetPublicAccountDetailInfoResponse.name.get();
    this.summary = paramGetPublicAccountDetailInfoResponse.summary.get();
    this.isRecvMsg = paramGetPublicAccountDetailInfoResponse.is_recv_msg.get();
    this.isShowFollowButton = paramGetPublicAccountDetailInfoResponse.is_show_follow_button.get();
    this.isShowShareButton = paramGetPublicAccountDetailInfoResponse.is_show_share_button.get();
    this.groupInfoList = paramGetPublicAccountDetailInfoResponse.config_group_info.get();
    this.followType = paramGetPublicAccountDetailInfoResponse.follow_type.get();
    this.displayNumber = paramGetPublicAccountDetailInfoResponse.display_number.get();
    this.groupId = paramGetPublicAccountDetailInfoResponse.group_id.get();
    this.isRecvPush = paramGetPublicAccountDetailInfoResponse.is_recv_push.get();
    this.certifiedGrade = paramGetPublicAccountDetailInfoResponse.certified_grade.get();
    this.showFlag = paramGetPublicAccountDetailInfoResponse.show_flag.get();
    this.accountFlag = paramGetPublicAccountDetailInfoResponse.account_flag.get();
    this.accountData = paramGetPublicAccountDetailInfoResponse.toByteArray();
    this.configBackgroundColor = paramGetPublicAccountDetailInfoResponse.config_background_color.get();
    this.newGroupInfoList = paramGetPublicAccountDetailInfoResponse.config_group_info_new.get();
    this.certifiedDescription = paramGetPublicAccountDetailInfoResponse.certified_description.get();
    this.mShowMsgFlag = -1;
    Object localObject1;
    int i;
    Object localObject2;
    mobileqq_mp.ConfigInfo localConfigInfo;
    if (paramGetPublicAccountDetailInfoResponse.config_group_info.has())
    {
      localObject1 = paramGetPublicAccountDetailInfoResponse.config_group_info.get();
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        localObject1 = ((List)localObject1).iterator();
        i = 0;
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (mobileqq_mp.ConfigGroupInfo)((Iterator)localObject1).next();
          if (((mobileqq_mp.ConfigGroupInfo)localObject2).config_info.has())
          {
            localObject2 = ((mobileqq_mp.ConfigGroupInfo)localObject2).config_info.get().iterator();
            for (;;)
            {
              if (((Iterator)localObject2).hasNext())
              {
                localConfigInfo = (mobileqq_mp.ConfigInfo)((Iterator)localObject2).next();
                if (localConfigInfo.state_id.get() == 5) {
                  if (localConfigInfo.state.get() == 1)
                  {
                    i = 1;
                    label489:
                    this.mShowMsgFlag = i;
                    i = 1;
                    label496:
                    if (i == 0) {
                      break label961;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      if (paramGetPublicAccountDetailInfoResponse.config_group_info_new.has())
      {
        localObject1 = paramGetPublicAccountDetailInfoResponse.config_group_info_new.get();
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          localObject1 = ((List)localObject1).iterator();
          label543:
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (mobileqq_mp.ConfigGroupInfo)((Iterator)localObject1).next();
            if (!((mobileqq_mp.ConfigGroupInfo)localObject2).config_info.has()) {
              break label1034;
            }
            localObject2 = ((mobileqq_mp.ConfigGroupInfo)localObject2).config_info.get().iterator();
            for (;;)
            {
              if (((Iterator)localObject2).hasNext())
              {
                localConfigInfo = (mobileqq_mp.ConfigInfo)((Iterator)localObject2).next();
                if (localConfigInfo.state_id.get() == 5) {
                  if (localConfigInfo.state.get() == 1)
                  {
                    i = 1;
                    label639:
                    this.mShowMsgFlag = i;
                    i = 1;
                  }
                }
              }
            }
          }
        }
      }
      label1026:
      label1029:
      label1034:
      for (;;)
      {
        label700:
        int k;
        if (i != 0)
        {
          if ((!paramGetPublicAccountDetailInfoResponse.config_group_info_new.has()) || (paramGetPublicAccountDetailInfoResponse.config_group_info_new.isEmpty())) {
            break label1029;
          }
          paramGetPublicAccountDetailInfoResponse = paramGetPublicAccountDetailInfoResponse.config_group_info_new.get();
          if ((paramGetPublicAccountDetailInfoResponse == null) || (paramGetPublicAccountDetailInfoResponse.size() <= 0)) {
            break label1029;
          }
          paramGetPublicAccountDetailInfoResponse = paramGetPublicAccountDetailInfoResponse.iterator();
          i = 0;
          if (!paramGetPublicAccountDetailInfoResponse.hasNext()) {
            break label1026;
          }
          localObject1 = (mobileqq_mp.ConfigGroupInfo)paramGetPublicAccountDetailInfoResponse.next();
          k = i;
          if (!((mobileqq_mp.ConfigGroupInfo)localObject1).config_info.has()) {
            break label1020;
          }
          k = i;
          if (((mobileqq_mp.ConfigGroupInfo)localObject1).config_info.isEmpty()) {
            break label1020;
          }
          localObject1 = ((mobileqq_mp.ConfigGroupInfo)localObject1).config_info.get().iterator();
          int j = i;
          label936:
          do
          {
            k = j;
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            localObject2 = (mobileqq_mp.ConfigInfo)((Iterator)localObject1).next();
            i = j;
            if (((mobileqq_mp.ConfigInfo)localObject2).type.has())
            {
              i = j;
              if (((mobileqq_mp.ConfigInfo)localObject2).type.get() == 2)
              {
                i = j;
                if (((mobileqq_mp.ConfigInfo)localObject2).state_id.has())
                {
                  i = j;
                  if (((mobileqq_mp.ConfigInfo)localObject2).state_id.get() == 3)
                  {
                    this.isSyncLbs = true;
                    if (!((mobileqq_mp.ConfigInfo)localObject2).state.has()) {}
                  }
                }
              }
            }
            switch (((mobileqq_mp.ConfigInfo)localObject2).state.get())
            {
            default: 
              if (QLog.isColorLevel()) {
                QLog.e("EqqDetail", 2, "Error Eqq lbs state value: " + ((mobileqq_mp.ConfigInfo)localObject2).state.get());
              }
              i = 1;
              j = i;
            }
          } while (i == 0);
          label942:
          if (i == 0) {
            break label1017;
          }
        }
        for (;;)
        {
          if (i == 0) {
            this.isSyncLbs = false;
          }
          return;
          i = 0;
          break label489;
          label961:
          break;
          i = 0;
          break label639;
          break label543;
          this.isSyncLbsSelected = false;
          this.isAgreeSyncLbs = false;
          i = 1;
          break label936;
          this.isSyncLbsSelected = true;
          this.isAgreeSyncLbs = true;
          i = 1;
          break label936;
          this.isSyncLbsSelected = true;
          this.isAgreeSyncLbs = false;
          i = 1;
          break label936;
          label1017:
          break label700;
          label1020:
          i = k;
          break label942;
          continue;
          i = 0;
        }
      }
      break label496;
      continue;
      i = 0;
    }
  }
  
  public void clone(AccountDetail paramAccountDetail)
  {
    this.uin = paramAccountDetail.uin;
    this.seqno = paramAccountDetail.seqno;
    this.name = paramAccountDetail.name;
    this.summary = paramAccountDetail.summary;
    this.isRecvMsg = paramAccountDetail.isRecvMsg;
    this.followType = paramAccountDetail.followType;
    this.isShowFollowButton = paramAccountDetail.isShowFollowButton;
    this.accountData = paramAccountDetail.accountData;
    this.groupInfoList = paramAccountDetail.groupInfoList;
    this.displayNumber = paramAccountDetail.displayNumber;
    this.groupId = paramAccountDetail.groupId;
    this.isRecvPush = paramAccountDetail.isRecvPush;
    this.isSyncLbs = paramAccountDetail.isSyncLbs;
    this.certifiedGrade = paramAccountDetail.certifiedGrade;
    this.showFlag = paramAccountDetail.showFlag;
    this.accountFlag = paramAccountDetail.accountFlag;
    this.mShowMsgFlag = paramAccountDetail.mShowMsgFlag;
    this.configBackgroundColor = paramAccountDetail.configBackgroundColor;
    this.newGroupInfoList = paramAccountDetail.newGroupInfoList;
    this.certifiedDescription = paramAccountDetail.certifiedDescription;
    this.isAgreeSyncLbs = paramAccountDetail.isAgreeSyncLbs;
    this.isSyncLbsSelected = paramAccountDetail.isSyncLbsSelected;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.AccountDetail
 * JD-Core Version:    0.7.0.1
 */