package com.tencent.mm.plugin.flash.b;

import android.app.Activity;
import android.content.Intent;
import android.widget.TextView;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.IYtSDKKitNetResponseParser;
import java.util.HashMap;
import org.json.JSONObject;

public abstract interface g
{
  public abstract void c(TextView paramTextView, String paramString);
  
  public abstract long dhO();
  
  public abstract void epG();
  
  public abstract JSONObject er(String paramString, int paramInt);
  
  public abstract void h(Intent paramIntent, Activity paramActivity);
  
  public abstract void onNetworkRequestEvent(String paramString1, String paramString2, HashMap<String, String> paramHashMap, YtSDKKitFramework.IYtSDKKitNetResponseParser paramIYtSDKKitNetResponseParser);
  
  public abstract void release();
  
  public abstract void reset();
  
  public abstract void x(TextView paramTextView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.flash.b.g
 * JD-Core Version:    0.7.0.1
 */