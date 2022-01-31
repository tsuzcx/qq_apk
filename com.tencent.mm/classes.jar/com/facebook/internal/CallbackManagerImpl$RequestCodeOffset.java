package com.facebook.internal;

import com.facebook.FacebookSdk;
import com.tencent.matrix.trace.core.AppMethodBeat;

public enum CallbackManagerImpl$RequestCodeOffset
{
  private final int offset;
  
  static
  {
    AppMethodBeat.i(72270);
    Login = new RequestCodeOffset("Login", 0, 0);
    Share = new RequestCodeOffset("Share", 1, 1);
    Message = new RequestCodeOffset("Message", 2, 2);
    Like = new RequestCodeOffset("Like", 3, 3);
    GameRequest = new RequestCodeOffset("GameRequest", 4, 4);
    AppGroupCreate = new RequestCodeOffset("AppGroupCreate", 5, 5);
    AppGroupJoin = new RequestCodeOffset("AppGroupJoin", 6, 6);
    AppInvite = new RequestCodeOffset("AppInvite", 7, 7);
    DeviceShare = new RequestCodeOffset("DeviceShare", 8, 8);
    $VALUES = new RequestCodeOffset[] { Login, Share, Message, Like, GameRequest, AppGroupCreate, AppGroupJoin, AppInvite, DeviceShare };
    AppMethodBeat.o(72270);
  }
  
  private CallbackManagerImpl$RequestCodeOffset(int paramInt)
  {
    this.offset = paramInt;
  }
  
  public final int toRequestCode()
  {
    AppMethodBeat.i(72269);
    int i = FacebookSdk.getCallbackRequestCodeOffset();
    int j = this.offset;
    AppMethodBeat.o(72269);
    return i + j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.facebook.internal.CallbackManagerImpl.RequestCodeOffset
 * JD-Core Version:    0.7.0.1
 */