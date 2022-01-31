package com.tencent.mm.plugin.gms;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.AccountPicker;
import com.google.android.gms.common.GooglePlayServicesUtil;

public class MMGoogleAuthUtil
  extends Activity
{
  private String fdD;
  private String gjZ;
  private String liF;
  public int liG = 0;
  
  private void dw(String paramString1, String paramString2)
  {
    new MMGoogleAuthUtil.a(this, this, paramString1, paramString2).execute(new Void[0]);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1)
    {
      switch (paramInt1)
      {
      default: 
        return;
      case 2001: 
        paramIntent = paramIntent.getStringExtra("authAccount");
        Intent localIntent = new Intent();
        localIntent.putExtra("error_code", 0);
        localIntent.putExtra("account", paramIntent);
        setResult(-1, localIntent);
        finish();
        return;
      }
      dw(this.liF, this.gjZ);
      return;
    }
    switch (paramInt1)
    {
    default: 
      return;
    }
    paramIntent = new Intent();
    paramIntent.putExtra("error_code", -1);
    paramIntent.putExtra("error_msg", "User Cancel.");
    setResult(paramInt2, paramIntent);
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    boolean bool = false;
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    paramBundle = getIntent();
    Intent localIntent = new Intent();
    if (paramBundle != null)
    {
      String str = paramBundle.getAction();
      if (!TextUtils.isEmpty(str))
      {
        if (str.equals("com.tencent.mm.gms.ACTION_CHOOSE_ACCOUNT"))
        {
          startActivityForResult(AccountPicker.newChooseAccountIntent(null, null, new String[] { "com.google" }, false, null, null, null, null), 2001);
          return;
        }
        if (str.equals("com.tencent.mm.gms.ACTION_GET_TOKEN"))
        {
          this.liF = paramBundle.getStringExtra("gmail");
          this.gjZ = paramBundle.getStringExtra("scope");
          dw(this.liF, this.gjZ);
          return;
        }
        if (str.equals("com.tencent.mm.gms.CHECK_GP_SERVICES"))
        {
          int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
          new StringBuilder().append(i);
          if (i == 0) {
            bool = true;
          }
          localIntent.putExtra("gpservices", bool);
          setResult(-1, localIntent);
          finish();
        }
      }
    }
    localIntent.putExtra("error_msg", "null intent or action.");
    setResult(-1, localIntent);
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gms.MMGoogleAuthUtil
 * JD-Core Version:    0.7.0.1
 */