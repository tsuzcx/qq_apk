package com.tencent.mobileqq.util;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import java.util.Calendar;

public class NotifyLightUtil
{
  public static boolean a(Context paramContext, AppInterface paramAppInterface)
  {
    if ((SettingCloneUtil.readValue(paramContext, paramAppInterface.a(), paramContext.getString(2131366822), "qqsetting_notify_blncontrol_key", true)) && ((paramAppInterface.isBackground_Pause) || (!ReflectionUtil.a(BaseApplicationImpl.a))))
    {
      if (SettingCloneUtil.readValue(paramContext, null, "no_disturb_mode", "qqsetting_nodisturb_mode_key", false))
      {
        int i = Calendar.getInstance().get(11);
        if ((i < 23) && (i >= 8)) {}
      }
    }
    else {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.util.NotifyLightUtil
 * JD-Core Version:    0.7.0.1
 */