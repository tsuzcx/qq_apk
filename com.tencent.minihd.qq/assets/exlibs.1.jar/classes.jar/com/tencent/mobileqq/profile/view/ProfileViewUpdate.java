package com.tencent.mobileqq.profile.view;

import NS_MOBILE_MAIN_PAGE.mobile_sub_get_cover_rsp;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import cooperation.qzone.model.CoverCacheData;

public abstract interface ProfileViewUpdate
{
  public static final String b = "map_key_qzonecover";
  public static final String c = "map_key_face";
  public static final String d = "map_key_profile_nick_name";
  public static final String e = "map_key_sex_age_area";
  public static final String f = "map_key_level";
  public static final String g = "map_key_level_accelerate";
  public static final String h = "map_key_login_day_icon";
  public static final String i = "map_key_login_day_text";
  public static final String j = "map_key_login_day_layout";
  public static final int k = 0;
  public static final String k = "map_key_like";
  public static final int l = 1;
  public static final String l = "map_key_voice_intro";
  public static final int m = 2;
  public static final String m = "map_key_tel";
  public static final String n = "map_key_sign";
  public static final String o = "map_key_play_game";
  public static final String p = "map_key_avatar_pendant";
  public static final String q = "map_key_tips";
  public static final String r = "map_key_tips_set_card";
  public static final String s = "map_key_tips_net_voice";
  public static final String t = "map_key_tag_cloud";
  public static final String u = "map_key_tag_jueban";
  
  public abstract CoverCacheData a();
  
  public abstract void a(ProfileActivity.AllInOne paramAllInOne);
  
  public abstract void a(ProfileActivity.AllInOne paramAllInOne, int paramInt, String paramString);
  
  public abstract void a(ProfileCardInfo paramProfileCardInfo, long paramLong);
  
  public abstract void a(CoverCacheData paramCoverCacheData);
  
  public abstract void a(String paramString, int paramInt);
  
  public abstract void a(boolean paramBoolean, String paramString, mobile_sub_get_cover_rsp parammobile_sub_get_cover_rsp);
  
  public abstract void e(ProfileCardInfo paramProfileCardInfo);
  
  public abstract void f(ProfileCardInfo paramProfileCardInfo);
  
  public abstract void g(ProfileCardInfo paramProfileCardInfo);
  
  public abstract void h(ProfileCardInfo paramProfileCardInfo);
  
  public abstract void i(ProfileCardInfo paramProfileCardInfo);
  
  public abstract void j(ProfileCardInfo paramProfileCardInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.ProfileViewUpdate
 * JD-Core Version:    0.7.0.1
 */