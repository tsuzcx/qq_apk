package com.tencent.mm.plugin.account.friend.a;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import java.net.URLEncoder;
import java.util.List;
import org.apache.http.NameValuePair;

public final class m
{
  public static String aIV()
  {
    AppMethodBeat.i(131043);
    ad.i("MicroMsg.GoogleContactLogic", "getRequestCodeUrl:%s", new Object[] { "https://accounts.google.com/o/oauth2/auth?scope=https://www.googleapis.com/auth/userinfo.email https://www.google.com/m8/feeds&redirect_uri=urn:ietf:wg:oauth:2.0:oob&response_type=code&client_id=369820936870.apps.googleusercontent.com" });
    AppMethodBeat.o(131043);
    return "https://accounts.google.com/o/oauth2/auth?scope=https://www.googleapis.com/auth/userinfo.email https://www.google.com/m8/feeds&redirect_uri=urn:ietf:wg:oauth:2.0:oob&response_type=code&client_id=369820936870.apps.googleusercontent.com";
  }
  
  public static String aQ(List<NameValuePair> paramList)
  {
    AppMethodBeat.i(131044);
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      NameValuePair localNameValuePair = (NameValuePair)paramList.get(i);
      if (!TextUtils.isEmpty(localNameValuePair.getName()))
      {
        if (i != 0) {
          localStringBuilder.append("&");
        }
        localStringBuilder.append(URLEncoder.encode(localNameValuePair.getName(), "UTF-8"));
        localStringBuilder.append("=");
        if (!TextUtils.isEmpty(localNameValuePair.getValue())) {
          localStringBuilder.append(URLEncoder.encode(localNameValuePair.getValue(), "UTF-8"));
        }
      }
      i += 1;
    }
    paramList = localStringBuilder.toString();
    AppMethodBeat.o(131044);
    return paramList;
  }
  
  public static boolean cX(Context paramContext)
  {
    AppMethodBeat.i(131045);
    Intent localIntent1 = new Intent("com.google.android.gms.common.account.CHOOSE_ACCOUNT");
    Intent localIntent2 = new Intent("com.tencent.mm.gms.ACTION_CHOOSE_ACCOUNT");
    if ((paramContext.getPackageManager().resolveActivity(localIntent2, 0) != null) && (paramContext.getPackageManager().resolveActivity(localIntent1, 0) != null))
    {
      if (Build.VERSION.SDK_INT >= 8)
      {
        if (paramContext.getSharedPreferences(aj.eFD(), 0).getBoolean("googleauth", false))
        {
          AppMethodBeat.o(131045);
          return false;
        }
        AppMethodBeat.o(131045);
        return true;
      }
      AppMethodBeat.o(131045);
      return false;
    }
    AppMethodBeat.o(131045);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.m
 * JD-Core Version:    0.7.0.1
 */