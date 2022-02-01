package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;

public abstract interface IWXChannelJumpInfo
{
  public static final int WX_CHANNEL_JUMP_TYPE_MINI_PROGRAM = 1;
  public static final int WX_CHANNEL_JUMP_TYPE_UNKNOWN = 0;
  public static final int WX_CHANNEL_JUMP_TYPE_URL = 2;
  
  public abstract boolean checkArgs();
  
  public abstract void serialize(Bundle paramBundle);
  
  public abstract int type();
  
  public abstract void unserialize(Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.IWXChannelJumpInfo
 * JD-Core Version:    0.7.0.1
 */