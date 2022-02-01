package com.tencent.mobileqq.app;

import appoint.define.appoint_define.LBSInfo;
import com.tencent.mobileqq.dating.DatingHandler;
import com.tencent.mobileqq.facetoface.Face2FaceGroupProfile;
import com.tencent.mobileqq.facetoface.Face2FaceUserProfile;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import tencent.im.nearfield_group.nearfield_group.BusiReqHead;
import tencent.im.nearfield_group.nearfield_group.BusiRespHead;
import tencent.im.nearfield_group.nearfield_group.GroupProfile;
import tencent.im.nearfield_group.nearfield_group.ReqExit;
import tencent.im.nearfield_group.nearfield_group.ReqGetGroupList;
import tencent.im.nearfield_group.nearfield_group.ReqJoinGroup;
import tencent.im.nearfield_group.nearfield_group.RespExit;
import tencent.im.nearfield_group.nearfield_group.RespGetGroupList;
import tencent.im.nearfield_group.nearfield_group.RespJoinGroup;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.NewComeinUserNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.NewGroup;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.NewGroupUser;

public class NearFieldTroopHandler
  extends BusinessHandler
{
  public static final int a = 1;
  public static final long a = 10000L;
  public static final String a = "NearfieldGroupSvr.ReqGetGroupList";
  public static final String b = "NearfieldGroupSvr.ReqExit";
  public static final String c = "NearfieldGroupSvr.ReqJoinGroup";
  private static final String d = NearFieldTroopHandler.class.getSimpleName();
  
  protected NearFieldTroopHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  protected Class a()
  {
    return NearFieldTroopObserver.class;
  }
  
  public void a(int paramInt, SubMsgType0x27.NewComeinUserNotify paramNewComeinUserNotify)
  {
    if (QLog.isColorLevel()) {
      QLog.d(d, 2, "handleNewComeinPush, msgType:" + paramInt);
    }
    if (paramInt == 2) {
      if (paramNewComeinUserNotify.msg_new_group.has())
      {
        localObject2 = (SubMsgType0x27.NewGroup)paramNewComeinUserNotify.msg_new_group.get();
        l1 = ((SubMsgType0x27.NewGroup)localObject2).uint64_group_code.get();
        paramNewComeinUserNotify = ((SubMsgType0x27.NewGroup)localObject2).bytes_group_name.get().toStringUtf8();
        l2 = ((SubMsgType0x27.NewGroup)localObject2).uint64_owner_uin.get();
        localObject1 = ((SubMsgType0x27.NewGroup)localObject2).bytes_owner_nick.get().toStringUtf8();
        localObject2 = ((SubMsgType0x27.NewGroup)localObject2).bytes_distance.get().toStringUtf8();
        a(4, true, new Object[] { new Face2FaceGroupProfile(l1 + "", paramNewComeinUserNotify, l2 + "", (String)localObject1, (String)localObject2) });
      }
    }
    while ((paramInt != 3) || (!paramNewComeinUserNotify.msg_new_group_user.has()))
    {
      Object localObject2;
      long l2;
      return;
    }
    Object localObject1 = (SubMsgType0x27.NewGroupUser)paramNewComeinUserNotify.msg_new_group_user.get();
    long l1 = ((SubMsgType0x27.NewGroupUser)localObject1).uint64_uin.get();
    paramNewComeinUserNotify = ((SubMsgType0x27.NewGroupUser)localObject1).str_nick.get();
    paramInt = ((SubMsgType0x27.NewGroupUser)localObject1).int32_sex.get();
    int i = ((SubMsgType0x27.NewGroupUser)localObject1).int32_age.get();
    localObject1 = ((SubMsgType0x27.NewGroupUser)localObject1).bytes_distance.get().toStringUtf8();
    a(5, true, new Object[] { new Face2FaceUserProfile(l1 + "", paramNewComeinUserNotify, paramInt, i, (String)localObject1) });
  }
  
  public void a(long paramLong, int paramInt)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "NearfieldGroupSvr.ReqExit");
    nearfield_group.BusiReqHead localBusiReqHead = new nearfield_group.BusiReqHead();
    localBusiReqHead.int32_seq.set(paramInt);
    localBusiReqHead.int32_version.set(1);
    nearfield_group.ReqExit localReqExit = new nearfield_group.ReqExit();
    localReqExit.msg_head.set(localBusiReqHead);
    localReqExit.uint64_group_code.set(paramLong);
    localToServiceMsg.putWupBuffer(localReqExit.toByteArray());
    localToServiceMsg.setTimeout(10000L);
    b(localToServiceMsg);
    if (QLog.isColorLevel()) {
      QLog.d(d, 2, "closeFace2faceTroop, troopCode:" + paramLong + ", seqNo:" + paramInt);
    }
  }
  
  public void a(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "NearfieldGroupSvr.ReqJoinGroup");
    nearfield_group.BusiReqHead localBusiReqHead = new nearfield_group.BusiReqHead();
    localBusiReqHead.int32_seq.set(paramInt);
    localBusiReqHead.int32_version.set(1);
    nearfield_group.ReqJoinGroup localReqJoinGroup = new nearfield_group.ReqJoinGroup();
    localReqJoinGroup.msg_head.set(localBusiReqHead);
    localReqJoinGroup.uint64_group_code.set(paramLong1);
    localReqJoinGroup.uint64_owner_uin.set(paramLong2);
    localReqJoinGroup.bytes_distance.set(ByteStringMicro.copyFromUtf8(paramString));
    localToServiceMsg.putWupBuffer(localReqJoinGroup.toByteArray());
    localToServiceMsg.setTimeout(10000L);
    b(localToServiceMsg);
    if (QLog.isColorLevel()) {
      QLog.d(d, 2, "joinTroop, troopCode:" + paramLong1 + ", ownerUin=" + paramLong2 + ", distance=" + paramString + ", seqNo:" + paramInt);
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = paramFromServiceMsg.getServiceCmd();
    if (QLog.isColorLevel()) {
      QLog.d(d, 2, "onReceive:" + paramToServiceMsg);
    }
    if (a(paramToServiceMsg)) {
      if (QLog.isColorLevel()) {
        QLog.d(d, 2, "cmdfilter error=" + paramToServiceMsg);
      }
    }
    boolean bool;
    do
    {
      return;
      if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null)) {}
      for (bool = true; "NearfieldGroupSvr.ReqGetGroupList".equalsIgnoreCase(paramToServiceMsg); bool = false)
      {
        a(bool, paramObject);
        return;
      }
      if ("NearfieldGroupSvr.ReqExit".equalsIgnoreCase(paramToServiceMsg))
      {
        b(bool, paramObject);
        return;
      }
    } while (!"NearfieldGroupSvr.ReqJoinGroup".equalsIgnoreCase(paramToServiceMsg));
    c(bool, paramObject);
  }
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d(d, 2, "handleOpenFace2faceTroop:" + paramBoolean);
    }
    Object localObject1;
    if (paramBoolean)
    {
      localObject1 = new nearfield_group.RespGetGroupList();
      try
      {
        ((nearfield_group.RespGetGroupList)localObject1).mergeFrom((byte[])paramObject);
        paramObject = localObject1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ArrayList localArrayList;
          int i;
          boolean bool = false;
          localObject1 = null;
          paramObject = localObject1;
          paramBoolean = bool;
          if (QLog.isColorLevel())
          {
            QLog.e(d, 2, "handleOpenFace2faceTroop:" + localException.toString());
            paramObject = localObject1;
            paramBoolean = bool;
          }
        }
        a(1, paramBoolean, new Object[] { localObject1, localException });
        return;
      }
      if ((paramBoolean) && (paramObject != null))
      {
        localObject1 = (nearfield_group.BusiRespHead)paramObject.msg_head.get();
        paramObject = paramObject.rpt_msg_group_list.get();
        localArrayList = new ArrayList();
        if (paramObject != null)
        {
          i = 0;
          while (i < paramObject.size())
          {
            Object localObject2 = (nearfield_group.GroupProfile)paramObject.get(i);
            long l1 = ((nearfield_group.GroupProfile)localObject2).uint64_group_code.get();
            String str1 = ((nearfield_group.GroupProfile)localObject2).bytes_group_name.get().toStringUtf8();
            long l2 = ((nearfield_group.GroupProfile)localObject2).uint64_owner_uin.get();
            String str2 = ((nearfield_group.GroupProfile)localObject2).bytes_owner_nick.get().toStringUtf8();
            localObject2 = ((nearfield_group.GroupProfile)localObject2).bytes_distance.get().toStringUtf8();
            localArrayList.add(new Face2FaceGroupProfile(l1 + "", str1, l2 + "", str2, (String)localObject2));
            i += 1;
          }
        }
      }
    }
    a(1, false, null);
  }
  
  public boolean a(long paramLong, int paramInt)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "NearfieldGroupSvr.ReqGetGroupList");
    Object localObject = (DatingHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(40);
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(d, 2, "openFace2faceTroop, datingHandler==null");
      }
      return false;
    }
    localObject = ((DatingHandler)localObject).a();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(d, 2, "openFace2faceTroop, lbsInfo==null");
      }
      return false;
    }
    nearfield_group.BusiReqHead localBusiReqHead = new nearfield_group.BusiReqHead();
    localBusiReqHead.int32_seq.set(paramInt);
    localBusiReqHead.int32_version.set(1);
    nearfield_group.ReqGetGroupList localReqGetGroupList = new nearfield_group.ReqGetGroupList();
    localReqGetGroupList.msg_head.set(localBusiReqHead);
    localReqGetGroupList.uint64_group_code.set(paramLong);
    localReqGetGroupList.msg_lbs_info.set((MessageMicro)localObject);
    localToServiceMsg.putWupBuffer(localReqGetGroupList.toByteArray());
    localToServiceMsg.setTimeout(10000L);
    b(localToServiceMsg);
    if (QLog.isColorLevel()) {
      QLog.d(d, 2, "openFace2faceTroop, troopCode:" + paramLong + ", seqNo:" + paramInt);
    }
    return true;
  }
  
  protected boolean a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilSet == null)
    {
      this.jdField_a_of_type_JavaUtilSet = new HashSet();
      this.jdField_a_of_type_JavaUtilSet.add("NearfieldGroupSvr.ReqGetGroupList");
      this.jdField_a_of_type_JavaUtilSet.add("NearfieldGroupSvr.ReqExit");
      this.jdField_a_of_type_JavaUtilSet.add("NearfieldGroupSvr.ReqJoinGroup");
    }
    return !this.jdField_a_of_type_JavaUtilSet.contains(paramString);
  }
  
  protected void b(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d(d, 2, "handleCloseFace2faceTroop:" + paramBoolean);
    }
    if (paramBoolean)
    {
      nearfield_group.RespExit localRespExit = new nearfield_group.RespExit();
      try
      {
        localRespExit.mergeFrom((byte[])paramObject);
        paramObject = localRespExit;
      }
      catch (Exception paramObject)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e(d, 2, "handleCloseFace2faceTroop:" + paramObject.toString());
          }
          paramObject = null;
          paramBoolean = false;
        }
      }
      if ((paramBoolean) && (paramObject != null))
      {
        a(2, paramBoolean, new Object[] { (nearfield_group.BusiRespHead)paramObject.msg_head.get() });
        return;
      }
    }
    a(2, false, null);
  }
  
  protected void c(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d(d, 2, "handleJoinTroopResp:" + paramBoolean);
    }
    if (paramBoolean)
    {
      nearfield_group.RespJoinGroup localRespJoinGroup = new nearfield_group.RespJoinGroup();
      try
      {
        localRespJoinGroup.mergeFrom((byte[])paramObject);
        paramObject = localRespJoinGroup;
      }
      catch (Exception paramObject)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e(d, 2, "handleJoinTroopResp:" + paramObject.toString());
          }
          paramObject = null;
          paramBoolean = false;
        }
      }
      if ((paramBoolean) && (paramObject != null))
      {
        a(3, paramBoolean, new Object[] { (nearfield_group.BusiRespHead)paramObject.msg_head.get(), String.valueOf(paramObject.uint64_group_code.get()) });
        return;
      }
    }
    a(3, false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.NearFieldTroopHandler
 * JD-Core Version:    0.7.0.1
 */