package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.troop.utils.AvatarTroopUtil;
import tencent.im.oidb.cmd0x8b4.GroupInfo;

public class ShowExternalTroop
  extends Entity
{
  public long addedTimestamp;
  public String strFaceUrl;
  public String troopName;
  @unique
  public String troopUin;
  
  public ShowExternalTroop() {}
  
  public ShowExternalTroop(cmd0x8b4.GroupInfo paramGroupInfo)
  {
    if (paramGroupInfo != null)
    {
      this.troopName = paramGroupInfo.str_group_name.get();
      this.troopUin = String.valueOf(paramGroupInfo.uint64_gc.get());
      this.addedTimestamp = paramGroupInfo.uint32_set_display_time.get();
      if (TextUtils.isEmpty(paramGroupInfo.str_face_url.get())) {
        this.strFaceUrl = AvatarTroopUtil.a(AvatarTroopUtil.a(null, this.troopUin, 0));
      }
    }
    else
    {
      return;
    }
    this.strFaceUrl = paramGroupInfo.str_face_url.get();
  }
  
  public static ShowExternalTroop createShowExternalTroop(String paramString1, String paramString2, long paramLong)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return null;
    }
    ShowExternalTroop localShowExternalTroop = new ShowExternalTroop();
    localShowExternalTroop.troopUin = paramString1;
    localShowExternalTroop.troopName = paramString2;
    localShowExternalTroop.addedTimestamp = paramLong;
    localShowExternalTroop.strFaceUrl = AvatarTroopUtil.a(AvatarTroopUtil.a(null, paramString1, 0));
    return localShowExternalTroop;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.ShowExternalTroop
 * JD-Core Version:    0.7.0.1
 */