package com.facebook.login;

import android.content.Context;
import android.os.Bundle;
import com.facebook.internal.PlatformServiceClient;

final class GetTokenClient
  extends PlatformServiceClient
{
  GetTokenClient(Context paramContext, String paramString)
  {
    super(paramContext, 65536, 65537, 20121101, paramString);
  }
  
  public final void populateRequestBundle(Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.facebook.login.GetTokenClient
 * JD-Core Version:    0.7.0.1
 */