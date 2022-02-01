package com.tencent.live2.impl.a;

import android.os.Bundle;
import com.tencent.live2.V2TXLivePlayerObserver;

public abstract class a
  extends V2TXLivePlayerObserver
{
  public abstract void onNetworkQuality(int paramInt);
  
  public abstract void onPlayEvent(int paramInt, Bundle paramBundle);
  
  public abstract void onPlayNetStatus(Bundle paramBundle);
  
  public abstract void onRecvSEIMessage(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.live2.impl.a.a
 * JD-Core Version:    0.7.0.1
 */