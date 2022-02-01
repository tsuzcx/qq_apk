package com.tencent.mobileqq.vaswebviewplugin;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import java.util.ArrayList;

public class VasCommonJsPlugin$ChooseFriendReceiver
  extends ResultReceiver
{
  private VasCommonJsPlugin mJsPlugin;
  
  public VasCommonJsPlugin$ChooseFriendReceiver(VasCommonJsPlugin paramVasCommonJsPlugin, Handler paramHandler)
  {
    super(paramHandler);
    this.mJsPlugin = paramVasCommonJsPlugin;
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    super.onReceiveResult(paramInt, paramBundle);
    if ((paramInt != 0) || (paramBundle == null))
    {
      this.mJsPlugin.doChooseFriendResult(null, null, null);
      return;
    }
    ArrayList localArrayList1 = paramBundle.getStringArrayList("choose_friend_uins");
    ArrayList localArrayList2 = paramBundle.getStringArrayList("choose_friend_phones");
    paramBundle = paramBundle.getStringArrayList("choose_friend_names");
    this.mJsPlugin.doChooseFriendResult(localArrayList1, localArrayList2, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.VasCommonJsPlugin.ChooseFriendReceiver
 * JD-Core Version:    0.7.0.1
 */