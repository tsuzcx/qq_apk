package com.tencent.mm.plugin.appbrand.report;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;

public final class i
{
  public static int j(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(132563);
    if ((paramBundle == null) || (!pv(paramInt)))
    {
      AppMethodBeat.o(132563);
      return 0;
    }
    paramInt = paramBundle.getInt("stat_scene");
    AppMethodBeat.o(132563);
    return paramInt;
  }
  
  public static String k(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(132564);
    if ((paramBundle == null) || (!pv(paramInt)))
    {
      AppMethodBeat.o(132564);
      return "";
    }
    switch (paramBundle.getInt("stat_scene"))
    {
    case 5: 
    default: 
      AppMethodBeat.o(132564);
      return "";
    case 1: 
      paramBundle = paramBundle.getString("stat_send_msg_user");
      AppMethodBeat.o(132564);
      return paramBundle;
    case 2: 
      str = paramBundle.getString("stat_chat_talker_username");
      paramBundle = paramBundle.getString("stat_send_msg_user");
      paramBundle = str + ":" + paramBundle;
      AppMethodBeat.o(132564);
      return paramBundle;
    case 3: 
      str = paramBundle.getString("stat_msg_id");
      paramBundle = paramBundle.getString("stat_send_msg_user");
      paramBundle = str + ":" + paramBundle;
      AppMethodBeat.o(132564);
      return paramBundle;
    case 4: 
      paramBundle = q.encode(paramBundle.getString("stat_url"));
      AppMethodBeat.o(132564);
      return paramBundle;
    case 6: 
      Object localObject = paramBundle.getString("stat_app_id");
      str = paramBundle.getString("stat_url");
      localObject = new StringBuilder().append((String)localObject).append(":");
      paramBundle = str;
      if (str == null) {
        paramBundle = "";
      }
      paramBundle = q.encode(paramBundle);
      AppMethodBeat.o(132564);
      return paramBundle;
    case 7: 
      paramBundle = paramBundle.getString("stat_chat_talker_username");
      AppMethodBeat.o(132564);
      return paramBundle;
    case 8: 
      paramBundle = "search:" + paramBundle.getString("stat_search_id");
      AppMethodBeat.o(132564);
      return paramBundle;
    }
    String str = paramBundle.getString("stat_chat_talker_username");
    paramBundle = paramBundle.getString("stat_send_msg_user");
    paramBundle = str + ":" + paramBundle;
    AppMethodBeat.o(132564);
    return paramBundle;
  }
  
  private static boolean pv(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.i
 * JD-Core Version:    0.7.0.1
 */