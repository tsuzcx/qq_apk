package com.tencent.mobileqq.app;

import KQQ.ReqItem;
import KQQ.RespItem;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialCareManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.dating.DatingManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.profile.CheckUpdateItemInterface;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.vas.ColorRingManager;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import tencent.im.oidb.cmd0x5d0.Oidb_0x5d0.SnsUpateBuffer;
import tencent.im.oidb.cmd0x5d0.Oidb_0x5d0.SnsUpdateItem;
import tencent.im.oidb.cmd0x5e0.Oidb_0x5e0.ContentItem;
import tencent.im.oidb.cmd0x5e0.Oidb_0x5e0.FriendRemark;
import tencent.im.oidb.cmd0x5e0.Oidb_0x5e0.FriendTeamList;
import tencent.im.oidb.cmd0x5e0.Oidb_0x5e0.GenderFiled;
import tencent.im.oidb.cmd0x5e0.Oidb_0x5e0.GeneralBuffer;
import tencent.im.oidb.cmd0x5e0.Oidb_0x5e0.GroupName;
import tencent.im.oidb.cmd0x5e0.Oidb_0x5e0.NickNameFiled;
import tencent.im.oidb.cmd0x5e0.Oidb_0x5e0.ProfileListResult;
import tencent.im.oidb.cmd0x5e0.Oidb_0x5e0.ReqBody;
import tencent.im.oidb.cmd0x5e0.Oidb_0x5e0.RspBody;
import tencent.im.oidb.cmd0x5e0.Oidb_0x5e0.UpdateProfileList;
import tencent.im.oidb.cmd0x5e0.Oidb_0x5e0.ValueBit;

public class QQProfileItem
  implements CheckUpdateItemInterface
{
  public static final int a = 1;
  private static final long jdField_a_of_type_Long = 4294967295L;
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 4;
  public static final int e = 5;
  public static final int f = 6;
  public static final int g = 7;
  public static final int h = 8;
  public static final int i = 9;
  public static final int j = 10;
  public static final int k = 11;
  public static final int l = 12;
  public static final int m = 13;
  public static final int n = 14;
  private static final int o = 65535;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ByteStringMicro jdField_a_of_type_ComTencentMobileqqPbByteStringMicro;
  
  public QQProfileItem(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = null;
  }
  
  public static void a(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    Object localObject = new String();
    if (QLog.isColorLevel()) {
      QLog.d(paramString, 2, "len = " + paramInt);
    }
    int i1 = 0;
    while (i1 < paramInt)
    {
      int i2 = paramArrayOfByte[i1];
      int i3 = paramArrayOfByte[i1];
      String str = (String)localObject + "0123456789ABCDEF".charAt(i2 >> 4 & 0xF) + "" + "0123456789ABCDEF".charAt(i3 & 0xF) + " ";
      localObject = str;
      if ((i1 + 1) % 8 == 0)
      {
        str = str + " ";
        localObject = str;
        if ((i1 + 1) % 16 == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d(paramString, 2, str);
          }
          localObject = "";
        }
      }
      i1 += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d(paramString, 2, (String)localObject);
    }
  }
  
  private void a(Oidb_0x5e0.RspBody paramRspBody)
  {
    FriendsManagerImp localFriendsManagerImp = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    Object localObject6 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(49);
    Object localObject1 = paramRspBody.rpt_msg_contentItem.get();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(((List)localObject1).size());
    if ((paramRspBody.uint32_over_flag.has()) && (paramRspBody.uint32_over_flag.get() == 1)) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileService.CheckUpdateReq", 2, "QQProfileItem::handleCheckUpdateRspBody called contentitemlist size = " + ((List)localObject1).size() + " overFlag:" + bool);
      }
      Friends[] arrayOfFriends = new Friends[((List)localObject1).size()];
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList1 = new ArrayList();
      int i1;
      int i2;
      long l1;
      Object localObject3;
      if (localObject1 != null)
      {
        Iterator localIterator1 = ((List)localObject1).iterator();
        i1 = 0;
        i2 = i1;
        if (!localIterator1.hasNext()) {
          break label3170;
        }
        localObject1 = (Oidb_0x5e0.ContentItem)localIterator1.next();
        if (((Oidb_0x5e0.ContentItem)localObject1).uint32_update_profile_id.has()) {}
        switch (((Oidb_0x5e0.ContentItem)localObject1).uint32_update_profile_id.get())
        {
        case 8: 
        default: 
        case 1: 
        case 2: 
          do
          {
            for (;;)
            {
              break;
              if (((Oidb_0x5e0.ContentItem)localObject1).msg_nicknamefiled.has())
              {
                localObject1 = (Oidb_0x5e0.NickNameFiled)((Oidb_0x5e0.ContentItem)localObject1).msg_nicknamefiled.get();
                i2 = i1;
                if (localObject1 != null)
                {
                  i2 = i1;
                  if (((Oidb_0x5e0.NickNameFiled)localObject1).uint64_uin.has())
                  {
                    l1 = ((Oidb_0x5e0.NickNameFiled)localObject1).uint64_uin.get();
                    localObject1 = ((Oidb_0x5e0.NickNameFiled)localObject1).bytes_value.get().toStringUtf8();
                    if (QLog.isColorLevel()) {
                      QLog.d("ProfileService.CheckUpdateReq", 2, "CheckUpdate  Nick：uin = " + new StringBuilder().append(l1).append("temp").toString().substring(0, 4) + " 昵称 = " + Utils.a((String)localObject1));
                    }
                    arrayOfFriends[i1] = localFriendsManagerImp.a(l1 + "", (String)localObject1);
                    i2 = i1 + 1;
                  }
                }
                i1 = i2;
              }
            }
          } while (!((Oidb_0x5e0.ContentItem)localObject1).msg_genderfiled.has());
          localObject3 = (Oidb_0x5e0.GenderFiled)((Oidb_0x5e0.ContentItem)localObject1).msg_genderfiled.get();
          l1 = ((Oidb_0x5e0.GenderFiled)localObject3).uint64_uin.get();
          localObject1 = localFriendsManagerImp.a(l1 + "");
          if (localObject1 != null)
          {
            i2 = ((Oidb_0x5e0.GenderFiled)localObject3).uint32_gender.get();
            if (i2 != 1) {
              break label674;
            }
            i2 = 0;
          }
          break;
        }
      }
      label1305:
      for (;;)
      {
        ((Card)localObject1).shGender = ((short)i2);
        if (Utils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), String.valueOf(l1)))
        {
          localObject3 = (DatingManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(67);
          if (localObject3 != null) {
            ((DatingManager)localObject3).b(((Card)localObject1).shGender);
          }
        }
        localFriendsManagerImp.a((Card)localObject1);
        if (QLog.isColorLevel()) {
          QLog.d("ProfileService.CheckUpdateReq", 2, "CheckUpdate  sex: uin = " + new StringBuilder().append(l1).append("temp").toString().substring(0, 4) + " sex = " + i2);
        }
        break;
        label674:
        if (i2 == 2)
        {
          i2 = 1;
        }
        else if (i2 == 0)
        {
          i2 = 2;
          continue;
          if (!((Oidb_0x5e0.ContentItem)localObject1).msg_friendremark.has()) {
            break;
          }
          localObject1 = (Oidb_0x5e0.FriendRemark)((Oidb_0x5e0.ContentItem)localObject1).msg_friendremark.get();
          if ((localObject1 != null) && (((Oidb_0x5e0.FriendRemark)localObject1).uint64_uin.has()))
          {
            l1 = ((Oidb_0x5e0.FriendRemark)localObject1).uint64_uin.get();
            localObject1 = ((Oidb_0x5e0.FriendRemark)localObject1).bytes_value.get().toStringUtf8();
            if (QLog.isColorLevel()) {
              QLog.d("ProfileService.CheckUpdateReq", 2, "CheckUpdate Remark：uin = " + new StringBuilder().append(l1).append("temp").toString().substring(0, 4) + " 备注内容 = " + Utils.a((String)localObject1));
            }
            localFriendsManagerImp.a(l1 + "", (String)localObject1, (byte)1);
          }
          break;
          break;
          if (!((Oidb_0x5e0.ContentItem)localObject1).msg_groupname.has()) {
            break;
          }
          localObject1 = (Oidb_0x5e0.GroupName)((Oidb_0x5e0.ContentItem)localObject1).msg_groupname.get();
          if ((localObject1 != null) && (((Oidb_0x5e0.GroupName)localObject1).uint64_group_uin.has()))
          {
            l1 = ((Oidb_0x5e0.GroupName)localObject1).uint64_group_uin.get();
            localObject1 = ((Oidb_0x5e0.GroupName)localObject1).bytes_value.get().toStringUtf8();
            localObject3 = localFriendsManagerImp.a(l1 + "");
            if (localObject3 != null)
            {
              ((TroopInfo)localObject3).troopname = ((String)localObject1);
              localArrayList2.add(localObject3);
              if (QLog.isColorLevel()) {
                QLog.d("ProfileService.CheckUpdateReq", 2, "CheckUpdate TroopName：uin = " + new StringBuilder().append(l1).append("temp").toString().substring(0, 4) + " 群名称内容 = " + Utils.a((String)localObject1));
              }
            }
          }
          break;
          if (!((Oidb_0x5e0.ContentItem)localObject1).msg_friend_teamlist.has()) {
            break;
          }
          localObject1 = (Oidb_0x5e0.FriendTeamList)((Oidb_0x5e0.ContentItem)localObject1).msg_friend_teamlist.get();
          if ((localObject1 != null) && (((Oidb_0x5e0.FriendTeamList)localObject1).uint32_update_flag.has()) && (((Oidb_0x5e0.FriendTeamList)localObject1).uint32_update_flag.get() == 1))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ProfileService.CheckUpdateReq", 2, "CheckUpdate GroupList：uin = ");
            }
            ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).a(true);
          }
          break;
          if (!((Oidb_0x5e0.ContentItem)localObject1).msg_value_bit.has()) {
            break;
          }
          localObject1 = (Oidb_0x5e0.ValueBit)((Oidb_0x5e0.ContentItem)localObject1).msg_value_bit.get();
          i2 = i1;
          int i5;
          int i4;
          int i3;
          int i6;
          if (localObject1 != null)
          {
            i2 = i1;
            if (((Oidb_0x5e0.ValueBit)localObject1).uint64_uin.has())
            {
              l1 = ((Oidb_0x5e0.ValueBit)localObject1).uint64_uin.get();
              localObject3 = localFriendsManagerImp.c(Long.toString(l1));
              i5 = 0;
              i4 = 0;
              i3 = 0;
              if (localObject3 != null)
              {
                i5 = ((Friends)localObject3).qqVipInfo;
                i4 = ((Friends)localObject3).superQqInfo;
                i3 = ((Friends)localObject3).superVipInfo;
              }
              if ((((Oidb_0x5e0.ValueBit)localObject1).bytes_identity_flag.has()) && (((Oidb_0x5e0.ValueBit)localObject1).bytes_identity_flag.get().size() >= 3))
              {
                i2 = ((Oidb_0x5e0.ValueBit)localObject1).bytes_identity_flag.get().byteAt(0);
                i6 = ((Oidb_0x5e0.ValueBit)localObject1).bytes_identity_flag.get().byteAt(2);
                if (localObject3 != null)
                {
                  int i7 = ((Friends)localObject3).qqVipInfo;
                  if ((i2 & 0xFC) == 0) {
                    break label1570;
                  }
                  i2 = 1;
                  ((Friends)localObject3).qqVipInfo = (i2 << 24 | i7);
                  i7 = ((Friends)localObject3).qqVipInfo;
                  if ((i6 & 0x60) == 0) {
                    break label1575;
                  }
                  i2 = 1;
                  label1334:
                  ((Friends)localObject3).qqVipInfo = (i2 << 24 | i7);
                }
              }
              if ((((Oidb_0x5e0.ValueBit)localObject1).bytes_ext_flag.has()) && (((Oidb_0x5e0.ValueBit)localObject1).bytes_ext_flag.get().size() >= 5))
              {
                i2 = ((Oidb_0x5e0.ValueBit)localObject1).bytes_ext_flag.get().byteAt(5);
                if (localObject3 != null)
                {
                  i6 = ((Friends)localObject3).superVipInfo;
                  if ((i2 & 0x20) == 0) {
                    break label1580;
                  }
                }
              }
            }
          }
          label1570:
          label1575:
          label1580:
          for (i2 = 1;; i2 = 0)
          {
            ((Friends)localObject3).superVipInfo = (i2 << 24 | i6);
            i2 = i1;
            if (localObject3 != null) {
              if ((((Friends)localObject3).superVipInfo == i3) && (((Friends)localObject3).qqVipInfo == i5))
              {
                i2 = i1;
                if (((Friends)localObject3).superQqInfo == i4) {}
              }
              else
              {
                if (QLog.isColorLevel()) {
                  QLog.d("ProfileService.CheckUpdateReq", 2, "find a vip user uin = " + new StringBuilder().append(l1).append("temp").toString().substring(0, 4) + " superVipInfo = " + ((Friends)localObject3).superVipInfo + " qqVipInfo = " + ((Friends)localObject3).qqVipInfo + " superQqInfo = " + ((Friends)localObject3).superQqInfo);
                }
                arrayOfFriends[i1] = localObject3;
                i2 = i1 + 1;
              }
            }
            i1 = i2;
            break;
            i2 = 0;
            break label1305;
            i2 = 0;
            break label1334;
          }
          if (!((Oidb_0x5e0.ContentItem)localObject1).msg_general_buffer.has()) {
            break;
          }
          localObject1 = (Oidb_0x5e0.GeneralBuffer)((Oidb_0x5e0.ContentItem)localObject1).msg_general_buffer.get();
          long l2;
          Object localObject5;
          if ((localObject1 != null) && (((Oidb_0x5e0.GeneralBuffer)localObject1).bytes_value.has()))
          {
            localObject1 = ByteBuffer.wrap(((Oidb_0x5e0.GeneralBuffer)localObject1).bytes_value.get().toByteArray());
            if (((ByteBuffer)localObject1).remaining() > 8)
            {
              l1 = ((ByteBuffer)localObject1).getInt() & 0xFFFFFFFF;
              l2 = ((ByteBuffer)localObject1).getInt() & 0xFFFFFFFF;
              localObject5 = new byte[((ByteBuffer)localObject1).getShort() & 0xFFFF];
              ((ByteBuffer)localObject1).get((byte[])localObject5);
              localObject3 = localFriendsManagerImp.a(Long.toString(l1));
              localObject1 = localObject3;
              if (localObject3 == null)
              {
                localObject1 = new ExtensionInfo();
                ((ExtensionInfo)localObject1).uin = Long.toString(l1);
              }
              if (((ExtensionInfo)localObject1).richTime != l2)
              {
                ((ExtensionInfo)localObject1).setRichBuffer((byte[])localObject5, l2);
                ((ExtensionInfo)localObject1).isAdded2C2C = SignatureManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.toString(l1), ((ExtensionInfo)localObject1).getRichStatus());
                localFriendsManagerImp.a((ExtensionInfo)localObject1);
                if (QLog.isColorLevel()) {
                  QLog.d("ProfileService.CheckUpdateReq", 2, "QQProfile update richStaus uin=" + l1 + ",time=" + l2);
                }
              }
            }
          }
          break;
          if (!((Oidb_0x5e0.ContentItem)localObject1).msg_general_buffer.has()) {
            break;
          }
          localObject1 = (Oidb_0x5e0.GeneralBuffer)((Oidb_0x5e0.ContentItem)localObject1).msg_general_buffer.get();
          if ((localObject1 != null) && (((Oidb_0x5e0.GeneralBuffer)localObject1).bytes_value.has())) {
            localObject3 = new Oidb_0x5d0.SnsUpateBuffer();
          }
          for (;;)
          {
            try
            {
              ((Oidb_0x5d0.SnsUpateBuffer)localObject3).mergeFrom(((Oidb_0x5e0.GeneralBuffer)localObject1).bytes_value.get().toByteArray());
              if ((localObject3 != null) && (((Oidb_0x5d0.SnsUpateBuffer)localObject3).uint64_uin.has()) && (((Oidb_0x5d0.SnsUpateBuffer)localObject3).rpt_uin32_idlist.has()))
              {
                localIterator2 = ((Oidb_0x5d0.SnsUpateBuffer)localObject3).rpt_uin32_idlist.get().iterator();
                if (!localIterator2.hasNext()) {
                  break label2404;
                }
                if (((Integer)localIterator2.next()).intValue() != 4051) {
                  continue;
                }
                localObject5 = String.valueOf(((Oidb_0x5d0.SnsUpateBuffer)localObject3).uint64_uin.get());
                if (QLog.isColorLevel())
                {
                  if (((String)localObject5).length() < 4) {
                    break label3941;
                  }
                  localObject1 = ((String)localObject5).substring(((String)localObject5).length() - 4);
                  QLog.d("ProfileService.CheckUpdateReq", 2, "CheckUpdate ValueBit : shd: " + (String)localObject1);
                }
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject5, localObject5);
                continue;
              }
            }
            catch (Exception localException1)
            {
              Iterator localIterator2;
              localException1.printStackTrace();
              localObject3 = null;
              continue;
              if ((localObject3 != null) && (((Oidb_0x5d0.SnsUpateBuffer)localObject3).uint64_uin.has()) && (((Oidb_0x5d0.SnsUpateBuffer)localObject3).rpt_msg_sns_update_item.has()))
              {
                localObject2 = ((Oidb_0x5d0.SnsUpateBuffer)localObject3).rpt_msg_sns_update_item.get();
                localObject5 = null;
                l1 = ((Oidb_0x5d0.SnsUpateBuffer)localObject3).uint64_uin.get();
                localIterator2 = ((List)localObject2).iterator();
                if (localIterator2.hasNext())
                {
                  Object localObject7 = (Oidb_0x5d0.SnsUpdateItem)localIterator2.next();
                  if ((localObject7 == null) || (!((Oidb_0x5d0.SnsUpdateItem)localObject7).uint32_update_sns_type.has()) || (!((Oidb_0x5d0.SnsUpdateItem)localObject7).bytes_value.has())) {
                    continue;
                  }
                  if (((Oidb_0x5d0.SnsUpdateItem)localObject7).uint32_update_sns_type.get() == 13568) {
                    QvipSpecialCareManager.a(String.valueOf(((Oidb_0x5d0.SnsUpateBuffer)localObject3).uint64_uin.get()), ((Oidb_0x5d0.SnsUpdateItem)localObject7).bytes_value.get().toStringUtf8(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                  }
                  localObject2 = localObject5;
                  if (localObject5 == null)
                  {
                    localObject5 = ((FriendsManager)localObject6).a(String.valueOf(l1));
                    localObject2 = localObject5;
                    if (localObject5 == null)
                    {
                      localObject2 = new SpecialCareInfo();
                      ((SpecialCareInfo)localObject2).uin = String.valueOf(String.valueOf(l1));
                    }
                  }
                  i2 = ((Oidb_0x5d0.SnsUpdateItem)localObject7).uint32_update_sns_type.get();
                  localObject7 = ((Oidb_0x5d0.SnsUpdateItem)localObject7).bytes_value.get().toStringUtf8();
                  FriendListHandler.a((SpecialCareInfo)localObject2, i2, (String)localObject7);
                  localObject5 = localObject2;
                  if (!QLog.isColorLevel()) {
                    continue;
                  }
                  QLog.d("ProfileService.CheckUpdateReq", 2, "handleCheckUpdateRspBody uin=" + ((SpecialCareInfo)localObject2).uin + ", itemtype=" + i2 + ",itemVal=" + (String)localObject7);
                  localObject5 = localObject2;
                  continue;
                }
                if ((localObject5 != null) && ((((SpecialCareInfo)localObject5).getStatus() != 1000) || (((SpecialCareInfo)localObject5).globalSwitch != 0))) {
                  localArrayList1.add(localObject5);
                }
              }
            }
            label2404:
            break;
            if (!((Oidb_0x5e0.ContentItem)localObject2).msg_general_buffer.has()) {
              break;
            }
            Object localObject2 = (Oidb_0x5e0.GeneralBuffer)((Oidb_0x5e0.ContentItem)localObject2).msg_general_buffer.get();
            l2 = 0L;
            l1 = l2;
            if (localObject2 != null)
            {
              l1 = l2;
              if (((Oidb_0x5e0.GeneralBuffer)localObject2).bytes_value.has()) {
                l1 = ((Oidb_0x5e0.GeneralBuffer)localObject2).uint64_uin.get();
              }
            }
            if ((localObject2 != null) && (((Oidb_0x5e0.GeneralBuffer)localObject2).bytes_value.has()))
            {
              localObject2 = ByteBuffer.wrap(((Oidb_0x5e0.GeneralBuffer)localObject2).bytes_value.get().toByteArray());
              if (((ByteBuffer)localObject2).remaining() >= 8)
              {
                l2 = ((ByteBuffer)localObject2).getLong();
                localObject3 = localFriendsManagerImp.a(String.valueOf(l1));
                localObject2 = localObject3;
                if (localObject3 == null)
                {
                  localObject2 = new ExtensionInfo();
                  ((ExtensionInfo)localObject2).uin = String.valueOf(l1);
                }
                ((ExtensionInfo)localObject2).pendantId = l2;
                ((ExtensionInfo)localObject2).timestamp = System.currentTimeMillis();
                localFriendsManagerImp.a((ExtensionInfo)localObject2);
                if (QLog.isColorLevel()) {
                  QLog.d("ProfileService.CheckUpdateReq", 2, "Check update, Get Pendant, uin=" + new StringBuilder().append(l1).append("temp").toString().substring(0, 4) + ", id=" + ((ExtensionInfo)localObject2).pendantId);
                }
              }
            }
            break;
            if (!((Oidb_0x5e0.ContentItem)localObject2).msg_general_buffer.has()) {
              break;
            }
            localObject2 = (Oidb_0x5e0.GeneralBuffer)((Oidb_0x5e0.ContentItem)localObject2).msg_general_buffer.get();
            l2 = 0L;
            l1 = l2;
            if (localObject2 != null)
            {
              l1 = l2;
              if (((Oidb_0x5e0.GeneralBuffer)localObject2).bytes_value.has()) {
                l1 = ((Oidb_0x5e0.GeneralBuffer)localObject2).uint64_uin.get();
              }
            }
            if ((localObject2 != null) && (((Oidb_0x5e0.GeneralBuffer)localObject2).bytes_value.has()))
            {
              localObject2 = ByteBuffer.wrap(((Oidb_0x5e0.GeneralBuffer)localObject2).bytes_value.get().toByteArray());
              if (((ByteBuffer)localObject2).remaining() >= 4)
              {
                i2 = ((ByteBuffer)localObject2).getInt();
                localObject3 = localFriendsManagerImp.a(String.valueOf(l1));
                localObject2 = localObject3;
                if (localObject3 == null)
                {
                  localObject2 = new ExtensionInfo();
                  ((ExtensionInfo)localObject2).uin = String.valueOf(l1);
                }
                if (((ExtensionInfo)localObject2).uVipFont != i2)
                {
                  ((ExtensionInfo)localObject2).uVipFont = i2;
                  ((ExtensionInfo)localObject2).timestamp = System.currentTimeMillis();
                  localFriendsManagerImp.a((ExtensionInfo)localObject2);
                }
                if (QLog.isColorLevel()) {
                  QLog.d("ProfileService.CheckUpdateReq", 2, "Check update, Get Font, uin=" + new StringBuilder().append(l1).append("temp").toString().substring(0, 4) + ", id=" + i2);
                }
              }
            }
            break;
            if (!((Oidb_0x5e0.ContentItem)localObject2).msg_general_buffer.has()) {
              break;
            }
            localObject2 = (Oidb_0x5e0.GeneralBuffer)((Oidb_0x5e0.ContentItem)localObject2).msg_general_buffer.get();
            l2 = 0L;
            l1 = l2;
            if (localObject2 != null)
            {
              l1 = l2;
              if (((Oidb_0x5e0.GeneralBuffer)localObject2).bytes_value.has()) {
                l1 = ((Oidb_0x5e0.GeneralBuffer)localObject2).uint64_uin.get();
              }
            }
            if ((localObject2 == null) || (!((Oidb_0x5e0.GeneralBuffer)localObject2).bytes_value.has())) {
              break;
            }
            localObject2 = ByteBuffer.wrap(((Oidb_0x5e0.GeneralBuffer)localObject2).bytes_value.get().toByteArray());
            if (((ByteBuffer)localObject2).remaining() < 4) {
              break;
            }
            i2 = ((ByteBuffer)localObject2).getInt();
            localObject3 = localFriendsManagerImp.a(String.valueOf(l1));
            localObject2 = localObject3;
            if (localObject3 == null)
            {
              localObject2 = new ExtensionInfo();
              ((ExtensionInfo)localObject2).uin = String.valueOf(l1);
            }
            if (((ExtensionInfo)localObject2).colorRingId != i2)
            {
              ((ExtensionInfo)localObject2).colorRingId = i2;
              ((ExtensionInfo)localObject2).timestamp = System.currentTimeMillis();
              localFriendsManagerImp.a((ExtensionInfo)localObject2);
              ColorRingManager.a(((ExtensionInfo)localObject2).uin, 1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
            }
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("ProfileService.CheckUpdateReq", 2, "Check update, Get colorRing, uin=" + new StringBuilder().append(l1).append("temp").toString().substring(0, 4) + ", id=" + i2);
            break;
            i2 = 0;
            label3170:
            if (localArrayList2.size() > 0) {
              localObject2 = localFriendsManagerImp.a();
            }
            for (;;)
            {
              try
              {
                ((EntityTransaction)localObject2).a();
                localObject3 = localArrayList2.iterator();
                if (((Iterator)localObject3).hasNext())
                {
                  localFriendsManagerImp.b((TroopInfo)((Iterator)localObject3).next());
                  continue;
                }
                if (((Friends)localObject6).isShield()) {
                  continue;
                }
              }
              catch (Exception localException2)
              {
                localException2.printStackTrace();
                ((EntityTransaction)localObject2).b();
                if (QLog.isColorLevel()) {
                  QLog.d("ProfileService.CheckUpdateReq", 2, "handleCheckUpdateRspBody, bulkSaveOrUpdateSpecialCareInfos,size=" + localArrayList1.size());
                }
                ((FriendsManager)localObject6).c(localArrayList1);
                if ((!bool) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 0)) {
                  break label3755;
                }
                localObject5 = localFriendsManagerImp.b();
                localObject2 = new ArrayList();
                localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
                localObject5 = ((ArrayList)localObject5).iterator();
                if (!((Iterator)localObject5).hasNext()) {
                  break;
                }
                localObject6 = (Friends)((Iterator)localObject5).next();
                if ((((Friends)localObject6).isShield()) && (!((ConcurrentHashMap)localObject4).containsKey(((Friends)localObject6).uin)))
                {
                  ((Friends)localObject6).setShieldFlag(false);
                  ((ArrayList)localObject2).add(localObject6);
                  continue;
                  ((EntityTransaction)localObject2).c();
                  ((EntityTransaction)localObject2).b();
                  continue;
                }
              }
              finally
              {
                ((EntityTransaction)localObject2).b();
              }
              if (((ConcurrentHashMap)localObject4).containsKey(((Friends)localObject6).uin))
              {
                ((Friends)localObject6).setShieldFlag(true);
                ((ArrayList)localObject2).add(localObject6);
              }
            }
            i1 = 0;
            while (i1 < i2)
            {
              if (arrayOfFriends[i1] != null) {
                ((ArrayList)localObject2).add(arrayOfFriends[i1]);
              }
              i1 += 1;
            }
            Object localObject4 = new Friends[((ArrayList)localObject2).size()];
            ((ArrayList)localObject2).toArray((Object[])localObject4);
            if (QLog.isColorLevel()) {
              QLog.d("ProfileService.CheckUpdateReq", 2, "CheckUpdate ValueBit update Friends count = " + i2 + " includeShield:" + localObject4.length);
            }
            localFriendsManagerImp.a((Friends[])localObject4, localObject4.length);
            for (;;)
            {
              localObject4 = paramRspBody.rpt_msg_ProfileListResult.get();
              if (localObject4 == null) {
                break label3807;
              }
              localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit();
              localObject4 = ((List)localObject4).iterator();
              while (((Iterator)localObject4).hasNext())
              {
                localObject5 = (Oidb_0x5e0.ProfileListResult)((Iterator)localObject4).next();
                if ((((Oidb_0x5e0.ProfileListResult)localObject5).uint32_result.has()) && (((Oidb_0x5e0.ProfileListResult)localObject5).uint32_result.get() == 0))
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("ProfileService.CheckUpdateReq", 2, "get result =" + ((Oidb_0x5e0.ProfileListResult)localObject5).uint32_result.get());
                  }
                  if ((((Oidb_0x5e0.ProfileListResult)localObject5).uint32_update_profile_id.has()) && (((Oidb_0x5e0.ProfileListResult)localObject5).uint32_new_content_timestamp.has()))
                  {
                    i1 = ((Oidb_0x5e0.ProfileListResult)localObject5).uint32_update_profile_id.get();
                    i2 = ((Oidb_0x5e0.ProfileListResult)localObject5).uint32_new_content_timestamp.get();
                    ((SharedPreferences.Editor)localObject2).putLong("inccheckupdatetimeStamp" + i1, i2);
                  }
                }
              }
              label3755:
              if (QLog.isColorLevel()) {
                QLog.d("ProfileService.CheckUpdateReq", 2, "CheckUpdate ValueBit update Friends count = " + i2);
              }
              localFriendsManagerImp.a(arrayOfFriends, i2);
            }
            ((SharedPreferences.Editor)localObject2).commit();
            label3807:
            if ((paramRspBody.uint32_over_flag.has()) && (paramRspBody.uint32_over_flag.get() == 1))
            {
              this.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = null;
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.b();
              return;
            }
            if (paramRspBody.bytes_svrcontext.has())
            {
              this.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = paramRspBody.bytes_svrcontext.get();
              paramRspBody = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.a().remove(Integer.valueOf(110));
              paramRspBody.a(false, 1);
              return;
            }
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.b();
            return;
            label3941:
            localObject2 = localObject5;
          }
        }
      }
    }
  }
  
  public int a()
  {
    return 5;
  }
  
  public ReqItem a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileService.CheckUpdateReq", 2, "QQProfileItem::getCheckUpdateItemData called");
    }
    ReqItem localReqItem = new ReqItem();
    localReqItem.eServiceID = 101;
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    Object localObject1 = new long[14];
    int i1 = 0;
    while (i1 < 14)
    {
      localObject1[i1] = ((SharedPreferences)localObject2).getLong("inccheckupdatetimeStamp" + Integer.toString(i1), 0L);
      i1 += 1;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder(50);
      i1 = 0;
      while (i1 < 14)
      {
        ((StringBuilder)localObject2).append(Long.toString(localObject1[i1])).append(" ");
        i1 += 1;
      }
      QLog.d("ProfileService.CheckUpdateReq", 2, ((StringBuilder)localObject2).toString());
    }
    localObject2 = new Oidb_0x5e0.UpdateProfileList();
    ((Oidb_0x5e0.UpdateProfileList)localObject2).uint32_need_content.set(0);
    ((Oidb_0x5e0.UpdateProfileList)localObject2).uint32_update_profile_id.set(1);
    ((Oidb_0x5e0.UpdateProfileList)localObject2).uint32_friendlist_type.set(1);
    ((Oidb_0x5e0.UpdateProfileList)localObject2).uint32_get_content_timestamp.set((int)localObject1[1]);
    Oidb_0x5e0.UpdateProfileList localUpdateProfileList1 = new Oidb_0x5e0.UpdateProfileList();
    localUpdateProfileList1.uint32_need_content.set(0);
    localUpdateProfileList1.uint32_update_profile_id.set(2);
    localUpdateProfileList1.uint32_friendlist_type.set(1);
    localUpdateProfileList1.uint32_get_content_timestamp.set((int)localObject1[2]);
    Oidb_0x5e0.UpdateProfileList localUpdateProfileList2 = new Oidb_0x5e0.UpdateProfileList();
    localUpdateProfileList2.uint32_need_content.set(0);
    localUpdateProfileList2.uint32_update_profile_id.set(3);
    localUpdateProfileList2.uint32_friendlist_type.set(0);
    localUpdateProfileList2.uint32_get_content_timestamp.set((int)localObject1[3]);
    Oidb_0x5e0.UpdateProfileList localUpdateProfileList3 = new Oidb_0x5e0.UpdateProfileList();
    localUpdateProfileList3.uint32_need_content.set(0);
    localUpdateProfileList3.uint32_update_profile_id.set(13);
    localUpdateProfileList3.uint32_friendlist_type.set(1);
    localUpdateProfileList3.uint32_get_content_timestamp.set((int)localObject1[13]);
    Oidb_0x5e0.UpdateProfileList localUpdateProfileList4 = new Oidb_0x5e0.UpdateProfileList();
    localUpdateProfileList4.uint32_need_content.set(0);
    localUpdateProfileList4.uint32_update_profile_id.set(5);
    localUpdateProfileList4.uint32_friendlist_type.set(0);
    localUpdateProfileList4.uint32_get_content_timestamp.set((int)localObject1[5]);
    Oidb_0x5e0.UpdateProfileList localUpdateProfileList5 = new Oidb_0x5e0.UpdateProfileList();
    localUpdateProfileList5.uint32_need_content.set(1);
    localUpdateProfileList5.uint32_update_profile_id.set(6);
    localUpdateProfileList5.uint32_friendlist_type.set(0);
    localUpdateProfileList5.uint32_get_content_timestamp.set((int)localObject1[6]);
    Oidb_0x5e0.UpdateProfileList localUpdateProfileList6 = new Oidb_0x5e0.UpdateProfileList();
    localUpdateProfileList6.uint32_need_content.set(0);
    localUpdateProfileList6.uint32_update_profile_id.set(7);
    localUpdateProfileList6.uint32_friendlist_type.set(1);
    localUpdateProfileList6.uint32_get_content_timestamp.set((int)localObject1[7]);
    Oidb_0x5e0.UpdateProfileList localUpdateProfileList7 = new Oidb_0x5e0.UpdateProfileList();
    localUpdateProfileList7.uint32_need_content.set(0);
    localUpdateProfileList7.uint32_update_profile_id.set(9);
    localUpdateProfileList7.uint32_friendlist_type.set(1);
    localUpdateProfileList7.uint32_get_content_timestamp.set((int)localObject1[9]);
    Oidb_0x5e0.UpdateProfileList localUpdateProfileList8 = new Oidb_0x5e0.UpdateProfileList();
    localUpdateProfileList8.uint32_need_content.set(0);
    localUpdateProfileList8.uint32_update_profile_id.set(10);
    localUpdateProfileList8.uint32_friendlist_type.set(1);
    localUpdateProfileList8.uint32_get_content_timestamp.set((int)localObject1[10]);
    Oidb_0x5e0.UpdateProfileList localUpdateProfileList9 = new Oidb_0x5e0.UpdateProfileList();
    localUpdateProfileList9.uint32_need_content.set(0);
    localUpdateProfileList9.uint32_update_profile_id.set(11);
    localUpdateProfileList9.uint32_friendlist_type.set(1);
    localUpdateProfileList9.uint32_get_content_timestamp.set((int)localObject1[11]);
    Oidb_0x5e0.UpdateProfileList localUpdateProfileList10 = new Oidb_0x5e0.UpdateProfileList();
    localUpdateProfileList10.uint32_need_content.set(0);
    localUpdateProfileList10.uint32_update_profile_id.set(12);
    localUpdateProfileList10.uint32_friendlist_type.set(1);
    localUpdateProfileList10.uint32_get_content_timestamp.set((int)localObject1[12]);
    localObject1 = new Oidb_0x5e0.ReqBody();
    if (this.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro != null) {
      ((Oidb_0x5e0.ReqBody)localObject1).bytes_svrcontext.set(this.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro);
    }
    ((Oidb_0x5e0.ReqBody)localObject1).rpt_msg_update_profile_list.add((MessageMicro)localObject2);
    ((Oidb_0x5e0.ReqBody)localObject1).rpt_msg_update_profile_list.add(localUpdateProfileList1);
    ((Oidb_0x5e0.ReqBody)localObject1).rpt_msg_update_profile_list.add(localUpdateProfileList2);
    ((Oidb_0x5e0.ReqBody)localObject1).rpt_msg_update_profile_list.add(localUpdateProfileList3);
    ((Oidb_0x5e0.ReqBody)localObject1).rpt_msg_update_profile_list.add(localUpdateProfileList4);
    ((Oidb_0x5e0.ReqBody)localObject1).rpt_msg_update_profile_list.add(localUpdateProfileList5);
    ((Oidb_0x5e0.ReqBody)localObject1).rpt_msg_update_profile_list.add(localUpdateProfileList6);
    ((Oidb_0x5e0.ReqBody)localObject1).rpt_msg_update_profile_list.add(localUpdateProfileList7);
    ((Oidb_0x5e0.ReqBody)localObject1).rpt_msg_update_profile_list.add(localUpdateProfileList8);
    ((Oidb_0x5e0.ReqBody)localObject1).rpt_msg_update_profile_list.add(localUpdateProfileList9);
    ((Oidb_0x5e0.ReqBody)localObject1).rpt_msg_update_profile_list.add(localUpdateProfileList10);
    localReqItem.vecParam = ((Oidb_0x5e0.ReqBody)localObject1).toByteArray();
    return localReqItem;
  }
  
  public void a(RespItem paramRespItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileService.CheckUpdateReq", 2, "QQProfileItem::handleCheckUpdateItemData called item.cResult = " + paramRespItem.cResult);
    }
    Oidb_0x5e0.RspBody localRspBody;
    if ((paramRespItem.eServiceID == 101) && (paramRespItem.cResult == 2))
    {
      paramRespItem = paramRespItem.vecUpdate;
      localRspBody = new Oidb_0x5e0.RspBody();
    }
    try
    {
      paramRespItem = (Oidb_0x5e0.RspBody)localRspBody.mergeFrom(paramRespItem);
      if (paramRespItem == null) {
        return;
      }
    }
    catch (Exception paramRespItem)
    {
      for (;;)
      {
        paramRespItem.printStackTrace();
        paramRespItem = null;
      }
      a(paramRespItem);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.QQProfileItem
 * JD-Core Version:    0.7.0.1
 */