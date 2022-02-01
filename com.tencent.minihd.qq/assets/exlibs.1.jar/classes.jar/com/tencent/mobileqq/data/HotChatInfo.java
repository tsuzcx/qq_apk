package com.tencent.mobileqq.data;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.util.Utils;
import java.io.Serializable;
import tencent.im.oidb.hotchat.Common.WifiPOIInfo;

public class HotChatInfo
  extends Entity
  implements Serializable, Cloneable
{
  public static final int RU_STATE_DELETED = 1;
  public static final int RU_STATE_NORMAL = 0;
  public static final int STATE_JOINED = 0;
  public static final int STATE_LEFT_NORMAL = 4;
  public static final int STATE_LEFT__LONG_TIME_NOT_SAY = 1;
  public static final int STATE_LEFT__LONG_WAY_TO_GO = 3;
  public static final int STATE_LEFT__SWITCH_WIFI = 2;
  public static final int STATE_SHELL = 5;
  private static final long serialVersionUID = 4511795799007124151L;
  public String detail;
  public int faceId;
  private boolean hasJoined;
  public int hotThemeGroupFlag;
  public boolean isWifiHotChat;
  public long leftTime;
  public int memberCount;
  public String name;
  public int ruState = 0;
  public String signature;
  public int state = 4;
  public String troopCode;
  @unique
  public String troopUin;
  public String uuid;
  
  public static HotChatInfo createHotChat(Common.WifiPOIInfo paramWifiPOIInfo, boolean paramBoolean)
  {
    HotChatInfo localHotChatInfo = new HotChatInfo();
    localHotChatInfo.faceId = paramWifiPOIInfo.uint32_face_id.get();
    localHotChatInfo.memberCount = paramWifiPOIInfo.uint32_visitor_num.get();
    localHotChatInfo.troopUin = String.valueOf(Utils.a(paramWifiPOIInfo.uint32_group_code.get()));
    localHotChatInfo.troopCode = String.valueOf(Utils.a(paramWifiPOIInfo.uint32_group_uin.get()));
    localHotChatInfo.isWifiHotChat = paramBoolean;
    localHotChatInfo.name = paramWifiPOIInfo.bytes_name.get().toStringUtf8();
    localHotChatInfo.signature = paramWifiPOIInfo.bytes_sig.get().toStringUtf8();
    if (paramWifiPOIInfo.uint32_is_member.get() > 0) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localHotChatInfo.hasJoined = paramBoolean;
      localHotChatInfo.uuid = paramWifiPOIInfo.bytes_uid.get().toStringUtf8();
      localHotChatInfo.hotThemeGroupFlag = paramWifiPOIInfo.hot_theme_group_flag.get();
      return localHotChatInfo;
    }
  }
  
  public static RecentUser createRecentUser(HotChatInfo paramHotChatInfo, boolean paramBoolean)
  {
    RecentUser localRecentUser = new RecentUser();
    localRecentUser.displayName = paramHotChatInfo.name;
    localRecentUser.lastmsgtime = (System.currentTimeMillis() / 1000L);
    if (paramBoolean) {
      localRecentUser.type = 1;
    }
    for (localRecentUser.uin = AppConstants.aq;; localRecentUser.uin = paramHotChatInfo.troopUin)
    {
      localRecentUser.troopUin = paramHotChatInfo.troopUin;
      return localRecentUser;
      localRecentUser.type = 1;
    }
  }
  
  public static Common.WifiPOIInfo createWifiPOIInfo(HotChatInfo paramHotChatInfo)
  {
    int j = 1;
    Common.WifiPOIInfo localWifiPOIInfo = new Common.WifiPOIInfo();
    localWifiPOIInfo.bytes_name.set(ByteStringMicro.copyFromUtf8(paramHotChatInfo.name));
    localWifiPOIInfo.bytes_sig.set(ByteStringMicro.copyFromUtf8(paramHotChatInfo.signature));
    localWifiPOIInfo.uint32_face_id.set(paramHotChatInfo.faceId);
    localWifiPOIInfo.uint32_group_code.set(Utils.a(Long.parseLong(paramHotChatInfo.troopUin)));
    localWifiPOIInfo.uint32_group_uin.set(Utils.a(Long.parseLong(paramHotChatInfo.troopCode)));
    PBUInt32Field localPBUInt32Field = localWifiPOIInfo.uint32_is_member;
    if (paramHotChatInfo.hasJoined)
    {
      i = 1;
      localPBUInt32Field.set(i);
      localWifiPOIInfo.bytes_uid.set(ByteStringMicro.copyFromUtf8(paramHotChatInfo.uuid));
      localPBUInt32Field = localWifiPOIInfo.uint32_wifi_poi_type;
      if (!paramHotChatInfo.isWifiHotChat) {
        break label157;
      }
    }
    label157:
    for (int i = j;; i = 0)
    {
      localPBUInt32Field.set(i);
      localWifiPOIInfo.hot_theme_group_flag.set(paramHotChatInfo.hotThemeGroupFlag);
      return localWifiPOIInfo;
      i = 0;
      break;
    }
  }
  
  public HotChatInfo clone()
  {
    try
    {
      HotChatInfo localHotChatInfo = (HotChatInfo)super.clone();
      return localHotChatInfo;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public String toString()
  {
    return "HotChatInfo [name=" + this.name + ", troopCode=" + this.troopCode + ", signature=" + this.signature + ", troopUin=" + this.troopUin + ", faceId=" + this.faceId + ", memberCount=" + this.memberCount + ", hasJoined=" + this.hasJoined + ", isWifiHotChat=" + this.isWifiHotChat + ", uuid=" + this.uuid + ", detail=" + this.detail + ", state=" + this.state + ", leftTime=" + this.leftTime + ", hot_theme_group_flag" + this.hotThemeGroupFlag + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.HotChatInfo
 * JD-Core Version:    0.7.0.1
 */