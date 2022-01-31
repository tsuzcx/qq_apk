package com.google.android.gms.auth;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class UserRecoverableAuthException
  extends GoogleAuthException
{
  private final Intent mIntent;
  
  public UserRecoverableAuthException(String paramString, Intent paramIntent)
  {
    super(paramString);
    this.mIntent = paramIntent;
  }
  
  public Intent getIntent()
  {
    AppMethodBeat.i(76961);
    if (this.mIntent == null)
    {
      AppMethodBeat.o(76961);
      return null;
    }
    Intent localIntent = new Intent(this.mIntent);
    AppMethodBeat.o(76961);
    return localIntent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.auth.UserRecoverableAuthException
 * JD-Core Version:    0.7.0.1
 */