package com.tencent.mm.plugin.appbrand.report;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.r;

public final class n
{
  private static boolean Da(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static int o(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(48066);
    if ((paramBundle == null) || (!Da(paramInt)))
    {
      AppMethodBeat.o(48066);
      return 0;
    }
    paramInt = paramBundle.getInt("stat_scene");
    AppMethodBeat.o(48066);
    return paramInt;
  }
  
  public static String p(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(48067);
    if ((paramBundle == null) || (!Da(paramInt)))
    {
      AppMethodBeat.o(48067);
      return "";
    }
    switch (paramBundle.getInt("stat_scene"))
    {
    case 5: 
    default: 
      AppMethodBeat.o(48067);
      return "";
    case 1: 
      paramBundle = paramBundle.getString("stat_send_msg_user");
      AppMethodBeat.o(48067);
      return paramBundle;
    case 2: 
      str = paramBundle.getString("stat_chat_talker_username");
      paramBundle = paramBundle.getString("stat_send_msg_user");
      paramBundle = str + ":" + paramBundle;
      AppMethodBeat.o(48067);
      return paramBundle;
    case 3: 
      str = paramBundle.getString("stat_msg_id");
      paramBundle = paramBundle.getString("stat_send_msg_user");
      paramBundle = str + ":" + paramBundle;
      AppMethodBeat.o(48067);
      return paramBundle;
    case 4: 
      paramBundle = r.cg(paramBundle.getString("stat_url"));
      AppMethodBeat.o(48067);
      return paramBundle;
    case 6: 
      Object localObject = paramBundle.getString("stat_app_id");
      str = paramBundle.getString("stat_url");
      localObject = new StringBuilder().append((String)localObject).append(":");
      paramBundle = str;
      if (str == null) {
        paramBundle = "";
      }
      paramBundle = r.cg(paramBundle);
      AppMethodBeat.o(48067);
      return paramBundle;
    case 7: 
      paramBundle = paramBundle.getString("stat_chat_talker_username");
      AppMethodBeat.o(48067);
      return paramBundle;
    case 8: 
      paramBundle = "search:" + paramBundle.getString("stat_search_id");
      AppMethodBeat.o(48067);
      return paramBundle;
    }
    String str = paramBundle.getString("stat_chat_talker_username");
    paramBundle = paramBundle.getString("stat_send_msg_user");
    paramBundle = str + ":" + paramBundle;
    AppMethodBeat.o(48067);
    return paramBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.n
 * JD-Core Version:    0.7.0.1
 */