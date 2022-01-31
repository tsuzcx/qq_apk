package com.google.android.gms.tagmanager;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;

public class PreviewActivity
  extends Activity
{
  private void zzp(String paramString1, String paramString2, String paramString3)
  {
    AlertDialog localAlertDialog = new AlertDialog.Builder(this).create();
    localAlertDialog.setTitle(paramString1);
    localAlertDialog.setMessage(paramString2);
    localAlertDialog.setButton(-1, paramString3, new PreviewActivity.1(this));
    localAlertDialog.show();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    try
    {
      super.onCreate(paramBundle);
      zzbo.zzbg("Preview activity");
      paramBundle = getIntent().getData();
      if (!TagManager.getInstance(this).zzv(paramBundle))
      {
        paramBundle = String.valueOf(paramBundle);
        paramBundle = String.valueOf(paramBundle).length() + 73 + "Cannot preview the app with the uri: " + paramBundle + ". Launching current version instead.";
        zzbo.zzbh(paramBundle);
        zzp("Preview failure", paramBundle, "Continue");
      }
      Intent localIntent = getPackageManager().getLaunchIntentForPackage(getPackageName());
      if (localIntent != null)
      {
        paramBundle = String.valueOf(getPackageName());
        if (paramBundle.length() != 0) {}
        for (paramBundle = "Invoke the launch activity for package name: ".concat(paramBundle);; paramBundle = new String("Invoke the launch activity for package name: "))
        {
          zzbo.zzbg(paramBundle);
          startActivity(localIntent);
          return;
        }
        paramBundle = "Calling preview threw an exception: ".concat(paramBundle);
      }
    }
    catch (Exception paramBundle)
    {
      paramBundle = String.valueOf(paramBundle.getMessage());
      if (paramBundle.length() == 0) {}
    }
    for (;;)
    {
      zzbo.e(paramBundle);
      return;
      paramBundle = String.valueOf(getPackageName());
      if (paramBundle.length() != 0) {}
      for (paramBundle = "No launch activity found for package name: ".concat(paramBundle);; paramBundle = new String("No launch activity found for package name: "))
      {
        zzbo.zzbg(paramBundle);
        return;
      }
      paramBundle = new String("Calling preview threw an exception: ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.tagmanager.PreviewActivity
 * JD-Core Version:    0.7.0.1
 */