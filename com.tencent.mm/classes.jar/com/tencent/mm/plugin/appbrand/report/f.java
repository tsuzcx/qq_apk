package com.tencent.mm.plugin.appbrand.report;

import android.os.Bundle;
import com.tencent.mm.compatible.util.q;

public final class f
{
  public static int g(int paramInt, Bundle paramBundle)
  {
    if ((paramBundle == null) || (!mm(paramInt))) {
      return 0;
    }
    return paramBundle.getInt("stat_scene");
  }
  
  public static String h(int paramInt, Bundle paramBundle)
  {
    if ((paramBundle == null) || (!mm(paramInt))) {
      return "";
    }
    switch (paramBundle.getInt("stat_scene"))
    {
    case 5: 
    default: 
      return "";
    case 1: 
      return paramBundle.getString("stat_send_msg_user");
    case 2: 
      str = paramBundle.getString("stat_chat_talker_username");
      paramBundle = paramBundle.getString("stat_send_msg_user");
      return str + ":" + paramBundle;
    case 3: 
      str = paramBundle.getString("stat_msg_id");
      paramBundle = paramBundle.getString("stat_send_msg_user");
      return str + ":" + paramBundle;
    case 4: 
      return q.encode(paramBundle.getString("stat_url"));
    case 6: 
      Object localObject = paramBundle.getString("stat_app_id");
      str = paramBundle.getString("stat_url");
      localObject = new StringBuilder().append((String)localObject).append(":");
      paramBundle = str;
      if (str == null) {
        paramBundle = "";
      }
      return q.encode(paramBundle);
    case 7: 
      return paramBundle.getString("stat_chat_talker_username");
    case 8: 
      return "search:" + paramBundle.getString("stat_search_id");
    }
    String str = paramBundle.getString("stat_chat_talker_username");
    paramBundle = paramBundle.getString("stat_send_msg_user");
    return str + ":" + paramBundle;
  }
  
  private static boolean mm(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.f
 * JD-Core Version:    0.7.0.1
 */