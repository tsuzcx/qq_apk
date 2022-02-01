package com.tencent.mobileqq.activity.widget.qqmusic.business.download;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import com.tencent.mobileqq.music.SongInfo;
import hco;
import hcp;
import java.util.List;

public class DownloadHelper
{
  private static DialogInterface.OnClickListener a = new hco();
  private static DialogInterface.OnClickListener b = new hcp();
  
  public static void a(Context paramContext) {}
  
  public static void a(Context paramContext, SongInfo paramSongInfo)
  {
    int k = 0;
    if ((paramContext == null) || (paramSongInfo == null)) {
      return;
    }
    Object localObject = paramContext.getPackageManager().getInstalledPackages(0);
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < ((List)localObject).size())
      {
        String str = ((PackageInfo)((List)localObject).get(i)).packageName;
        if (("com.tencent.qqmusic".equals(str)) || ("com.tencent.qqmusicpad".equals(str))) {
          j = 1;
        }
      }
      else
      {
        if (j == 0) {
          break;
        }
        localObject = new Intent();
        ((Intent)localObject).setAction("android.intent.action.VIEW");
        ((Intent)localObject).setData(Uri.parse("androidqqmusic://form=webpage&mid=23&k1=0&k2=" + paramSongInfo.a + "&download=1&action=download"));
        paramContext.startActivity((Intent)localObject);
        return;
      }
      i += 1;
    }
    a(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.qqmusic.business.download.DownloadHelper
 * JD-Core Version:    0.7.0.1
 */