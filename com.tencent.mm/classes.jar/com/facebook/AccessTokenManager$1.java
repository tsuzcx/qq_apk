package com.facebook;

import com.tencent.matrix.trace.core.AppMethodBeat;

class AccessTokenManager$1
  implements Runnable
{
  AccessTokenManager$1(AccessTokenManager paramAccessTokenManager, AccessToken.AccessTokenRefreshCallback paramAccessTokenRefreshCallback) {}
  
  public void run()
  {
    AppMethodBeat.i(71550);
    AccessTokenManager.access$000(this.this$0, this.val$callback);
    AppMethodBeat.o(71550);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.facebook.AccessTokenManager.1
 * JD-Core Version:    0.7.0.1
 */