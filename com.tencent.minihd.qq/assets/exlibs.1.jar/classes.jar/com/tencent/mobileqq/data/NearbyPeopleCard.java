package com.tencent.mobileqq.data;

import GameCenter.RespLastGameInfo;
import android.text.TextUtils;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.profile.ProfileBusiEntry;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public class NearbyPeopleCard
  extends Entity
{
  public int age;
  public byte bVoted;
  public int birthday;
  public String busiEntry;
  public String college;
  public String company;
  public byte constellation;
  public byte[] dateInfo;
  public String distance;
  public int favoriteSource;
  public long feedPreviewTime;
  public byte gender;
  public String hometownCity;
  public String hometownCountry;
  public String hometownDistrict;
  public String hometownProvice;
  public boolean isPhotoUseCache;
  public int job;
  public long lastUpdateNickTime;
  public int likeCount;
  public int likeCountInc;
  public byte maritalStatus;
  public int nLastGameFlag;
  public String nickname;
  public int oldPhotoCount;
  public byte[] photoInfoes;
  @notColumn
  public List profileBusiEntry;
  public String qzoneFeed;
  public String qzoneName;
  public String qzonePicUrl_1;
  public String qzonePicUrl_2;
  public String qzonePicUrl_3;
  public String strProfileUrl;
  public boolean switchHobby;
  public boolean switchQzone;
  public String timeDiff;
  public long tinyId = 0L;
  public long uiShowControl;
  public String uin;
  public long userFlag;
  public byte[] vCookies;
  public byte[] vSeed;
  public byte[] xuanYan;
  
  public void addOrUpdateBuisEntry(ProfileBusiEntry paramProfileBusiEntry)
  {
    int k = 0;
    if (paramProfileBusiEntry == null) {
      return;
    }
    int m = paramProfileBusiEntry.jdField_a_of_type_Int;
    if (this.profileBusiEntry == null) {
      getBusiEntrys();
    }
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < this.profileBusiEntry.size())
      {
        if (((ProfileBusiEntry)this.profileBusiEntry.get(i)).jdField_a_of_type_Int == m)
        {
          j = 1;
          this.profileBusiEntry.remove(i);
          this.profileBusiEntry.add(paramProfileBusiEntry);
        }
      }
      else
      {
        if (j != 0) {
          break;
        }
        this.profileBusiEntry.add(paramProfileBusiEntry);
        return;
      }
      i += 1;
    }
  }
  
  public List getBusiEntrys()
  {
    if (this.profileBusiEntry == null)
    {
      this.profileBusiEntry = new ArrayList();
      if (TextUtils.isEmpty(this.busiEntry)) {}
    }
    for (;;)
    {
      int i;
      try
      {
        JSONArray localJSONArray = new JSONArray(this.busiEntry);
        i = 0;
        if (i < localJSONArray.length())
        {
          JSONObject localJSONObject = localJSONArray.getJSONObject(i);
          if (localJSONObject == null) {
            break label172;
          }
          ProfileBusiEntry localProfileBusiEntry = new ProfileBusiEntry();
          localProfileBusiEntry.jdField_a_of_type_Int = localJSONObject.getInt("nBusiEntryType");
          localProfileBusiEntry.jdField_a_of_type_JavaLangString = localJSONObject.getString("strLogoUrl");
          localProfileBusiEntry.b = localJSONObject.getString("strTitle");
          localProfileBusiEntry.c = localJSONObject.getString("strContent");
          localProfileBusiEntry.d = localJSONObject.getString("strJumpUrl");
          if (localProfileBusiEntry.a()) {
            break label172;
          }
          this.profileBusiEntry.add(localProfileBusiEntry);
        }
      }
      catch (JSONException localJSONException)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.SummaryCard", 2, localJSONException.toString());
        }
      }
      return this.profileBusiEntry;
      label172:
      i += 1;
    }
  }
  
  public List getQZonePhotoList()
  {
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty(this.qzonePicUrl_1)) {
      localArrayList.add(this.qzonePicUrl_1);
    }
    if (!TextUtils.isEmpty(this.qzonePicUrl_2)) {
      localArrayList.add(this.qzonePicUrl_2);
    }
    if (!TextUtils.isEmpty(this.qzonePicUrl_3)) {
      localArrayList.add(this.qzonePicUrl_3);
    }
    return localArrayList;
  }
  
  public boolean hasQzonePhotoUrl()
  {
    return (!StringUtil.b(this.qzonePicUrl_1)) || (!StringUtil.b(this.qzonePicUrl_2)) || (!StringUtil.b(this.qzonePicUrl_3));
  }
  
  public boolean isAuthUser()
  {
    return (this.userFlag & 0x20) != 0L;
  }
  
  public boolean isOpenRecentPlayingGamesByNative()
  {
    return (this.nLastGameFlag & 0x2) == 2;
  }
  
  public boolean isPhotoUseCache()
  {
    return this.isPhotoUseCache;
  }
  
  public void removeBuisEntry(ProfileBusiEntry paramProfileBusiEntry)
  {
    if (paramProfileBusiEntry == null) {}
    for (;;)
    {
      return;
      int j = paramProfileBusiEntry.jdField_a_of_type_Int;
      if (this.profileBusiEntry == null) {
        getBusiEntrys();
      }
      int i = 0;
      while (i < this.profileBusiEntry.size())
      {
        if (((ProfileBusiEntry)this.profileBusiEntry.get(i)).jdField_a_of_type_Int == j)
        {
          this.profileBusiEntry.remove(i);
          return;
        }
        i += 1;
      }
    }
  }
  
  public void saveBusiEntrys(List paramList)
  {
    JSONStringer localJSONStringer = new JSONStringer();
    int i;
    if (paramList == null)
    {
      i = 0;
      if (i <= 0) {
        break label205;
      }
    }
    for (;;)
    {
      try
      {
        localJSONStringer.array();
        int j = 0;
        if (j < i)
        {
          ProfileBusiEntry localProfileBusiEntry = (ProfileBusiEntry)paramList.get(j);
          if ((localProfileBusiEntry != null) && (!localProfileBusiEntry.a())) {
            localJSONStringer.object().key("nBusiEntryType").value(localProfileBusiEntry.jdField_a_of_type_Int).key("strLogoUrl").value(localProfileBusiEntry.jdField_a_of_type_JavaLangString).key("strTitle").value(localProfileBusiEntry.b).key("strContent").value(localProfileBusiEntry.c).key("strJumpUrl").value(localProfileBusiEntry.d).endObject();
          }
          j += 1;
          continue;
          i = paramList.size();
          break;
        }
        localJSONStringer.endArray();
        this.busiEntry = localJSONStringer.toString();
      }
      catch (JSONException localJSONException)
      {
        label205:
        this.busiEntry = "";
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("Q.profilecard.SummaryCard", 2, localJSONException.toString());
        continue;
      }
      if (this.profileBusiEntry != null)
      {
        this.profileBusiEntry.clear();
        if ((paramList != null) && (paramList.size() > 0)) {
          this.profileBusiEntry.addAll(paramList);
        }
      }
      return;
      this.busiEntry = "";
    }
  }
  
  public void setPhotoUseCache(long paramLong)
  {
    if ((1L & paramLong) != 0L) {}
    for (boolean bool = true;; bool = false)
    {
      this.isPhotoUseCache = bool;
      return;
    }
  }
  
  public boolean shouldShowHobby()
  {
    return (this.uiShowControl & 0x20) == 0L;
  }
  
  public boolean shouldShowLikeBtn()
  {
    return (this.uiShowControl & 0x4) != 0L;
  }
  
  public boolean shouldShowQzoneFeed()
  {
    return (this.uiShowControl & 1L) != 0L;
  }
  
  public void updateLastGameInfo(RespLastGameInfo paramRespLastGameInfo)
  {
    if ((paramRespLastGameInfo == null) || (paramRespLastGameInfo.iResult != 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i("SummaryCard", 2, "handleGetSummaryCard|updateLastGameInfo|info = null or info.iResult != 0");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("SummaryCard", 2, "updateLastGameInfo|info.bShowGameLogo = " + paramRespLastGameInfo.bShowGameLogo + "|info.bNative = " + paramRespLastGameInfo.bNative + "|info.sLogoUrl = " + paramRespLastGameInfo.sLogoUrl);
    }
    if (paramRespLastGameInfo.bShowGameLogo)
    {
      this.nLastGameFlag |= 0x1;
      if (paramRespLastGameInfo.bNative) {}
      for (this.nLastGameFlag |= 0x2;; this.nLastGameFlag &= 0xFFFFFFFD)
      {
        this.strProfileUrl = paramRespLastGameInfo.sProfileUrl;
        return;
      }
    }
    this.nLastGameFlag &= 0xFFFFFFFE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.NearbyPeopleCard
 * JD-Core Version:    0.7.0.1
 */