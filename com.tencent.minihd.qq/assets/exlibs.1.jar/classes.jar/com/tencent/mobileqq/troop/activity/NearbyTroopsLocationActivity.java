package com.tencent.mobileqq.troop.activity;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.app.LebaHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import java.util.List;

public class NearbyTroopsLocationActivity
  extends NearbyTroopsActivity
{
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, Intent paramIntent)
  {
    if (paramContext == null) {
      return;
    }
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent(paramContext, NearbyTroopsLocationActivity.class);
    }
    int i;
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.a().a();
      if (paramQQAppInterface == null) {
        break label109;
      }
      i = 0;
      if (i >= paramQQAppInterface.size()) {
        break label109;
      }
      paramIntent = (ResourcePluginInfo)paramQQAppInterface.get(i);
      if (paramIntent.uiResId != 886L) {
        break label102;
      }
    }
    label102:
    label109:
    for (paramQQAppInterface = paramIntent.strResName;; paramQQAppInterface = null)
    {
      if (!TextUtils.isEmpty(paramQQAppInterface)) {
        localIntent.putExtra("config_res_plugin_item_name", paramQQAppInterface);
      }
      paramContext.startActivity(localIntent);
      return;
      i += 1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.NearbyTroopsLocationActivity
 * JD-Core Version:    0.7.0.1
 */