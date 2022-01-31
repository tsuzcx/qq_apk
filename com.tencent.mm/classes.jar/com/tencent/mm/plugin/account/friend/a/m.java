package com.tencent.mm.plugin.account.friend.a;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mm.sdk.platformtools.ae;
import java.net.URLEncoder;
import java.util.List;
import org.apache.http.NameValuePair;

public final class m
{
  public static String ak(List<NameValuePair> paramList)
  {
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
    return localStringBuilder.toString();
  }
  
  public static boolean bX(Context paramContext)
  {
    Intent localIntent1 = new Intent("com.google.android.gms.common.account.CHOOSE_ACCOUNT");
    Intent localIntent2 = new Intent("com.tencent.mm.gms.ACTION_CHOOSE_ACCOUNT");
    return (paramContext.getPackageManager().resolveActivity(localIntent2, 0) != null) && (paramContext.getPackageManager().resolveActivity(localIntent1, 0) != null) && (Build.VERSION.SDK_INT >= 8) && (!paramContext.getSharedPreferences(ae.cqR(), 0).getBoolean("googleauth", false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.m
 * JD-Core Version:    0.7.0.1
 */