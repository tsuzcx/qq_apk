package com.facebook;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.support.v4.content.d;
import com.facebook.internal.Validate;

public abstract class AccessTokenTracker
{
  private static final String TAG = AccessTokenTracker.class.getSimpleName();
  private final d broadcastManager;
  private boolean isTracking = false;
  private final BroadcastReceiver receiver;
  
  public AccessTokenTracker()
  {
    Validate.sdkInitialized();
    this.receiver = new AccessTokenTracker.CurrentAccessTokenBroadcastReceiver(this, null);
    this.broadcastManager = d.R(FacebookSdk.getApplicationContext());
    startTracking();
  }
  
  private void addBroadcastReceiver()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED");
    this.broadcastManager.a(this.receiver, localIntentFilter);
  }
  
  public boolean isTracking()
  {
    return this.isTracking;
  }
  
  protected abstract void onCurrentAccessTokenChanged(AccessToken paramAccessToken1, AccessToken paramAccessToken2);
  
  public void startTracking()
  {
    if (this.isTracking) {
      return;
    }
    addBroadcastReceiver();
    this.isTracking = true;
  }
  
  public void stopTracking()
  {
    if (!this.isTracking) {
      return;
    }
    this.broadcastManager.unregisterReceiver(this.receiver);
    this.isTracking = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.facebook.AccessTokenTracker
 * JD-Core Version:    0.7.0.1
 */