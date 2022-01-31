package com.tencent.mm.plugin.gms;

import android.content.Context;
import android.os.AsyncTask;
import com.google.android.gms.auth.GoogleAuthException;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.auth.GooglePlayServicesAvailabilityException;
import com.google.android.gms.auth.UserRecoverableAuthException;
import java.io.IOException;

final class MMGoogleAuthUtil$a
  extends AsyncTask<Void, Void, Void>
{
  private String gio;
  private String gjZ;
  private boolean liH = false;
  private boolean liI;
  private String liJ;
  private Context mContext;
  private int mErrorCode;
  
  public MMGoogleAuthUtil$a(MMGoogleAuthUtil paramMMGoogleAuthUtil, Context paramContext, String paramString1, String paramString2)
  {
    this.mContext = paramContext;
    this.liJ = paramString1;
    this.gjZ = paramString2;
    this.liH = false;
  }
  
  private Void Wb()
  {
    try
    {
      MMGoogleAuthUtil.a(this.liK, GoogleAuthUtil.getToken(this.mContext, this.liJ, this.gjZ));
      this.liI = true;
      this.mErrorCode = 0;
      return null;
    }
    catch (GooglePlayServicesAvailabilityException localGooglePlayServicesAvailabilityException)
    {
      for (;;)
      {
        this.gio = localGooglePlayServicesAvailabilityException.getMessage();
        this.mErrorCode = -2;
      }
    }
    catch (UserRecoverableAuthException localUserRecoverableAuthException)
    {
      for (;;)
      {
        this.gio = localUserRecoverableAuthException.getMessage();
        this.mErrorCode = -3;
        if (this.liK.liG < 4)
        {
          MMGoogleAuthUtil localMMGoogleAuthUtil = this.liK;
          localMMGoogleAuthUtil.liG += 1;
          this.liH = true;
          this.liK.startActivityForResult(localUserRecoverableAuthException.getIntent(), 2002);
        }
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        this.gio = localIOException.getMessage();
        this.mErrorCode = -4;
      }
    }
    catch (GoogleAuthException localGoogleAuthException)
    {
      for (;;)
      {
        this.gio = localGoogleAuthException.getMessage();
        this.mErrorCode = -5;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.gio = localException.getMessage();
        this.mErrorCode = -1;
      }
    }
  }
  
  protected final void onPreExecute()
  {
    super.onPreExecute();
    this.liI = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gms.MMGoogleAuthUtil.a
 * JD-Core Version:    0.7.0.1
 */