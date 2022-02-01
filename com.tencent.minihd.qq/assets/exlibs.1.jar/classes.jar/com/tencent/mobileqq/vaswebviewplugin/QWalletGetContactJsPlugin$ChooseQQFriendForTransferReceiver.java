package com.tencent.mobileqq.vaswebviewplugin;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import java.util.ArrayList;
import java.util.List;

public class QWalletGetContactJsPlugin$ChooseQQFriendForTransferReceiver
  extends ResultReceiver
{
  private QWalletGetContactJsPlugin mJsPlugin;
  
  public QWalletGetContactJsPlugin$ChooseQQFriendForTransferReceiver(QWalletGetContactJsPlugin paramQWalletGetContactJsPlugin, Handler paramHandler)
  {
    super(paramHandler);
    this.mJsPlugin = paramQWalletGetContactJsPlugin;
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    super.onReceiveResult(paramInt, paramBundle);
    if ((paramInt != 0) || (paramBundle == null))
    {
      this.mJsPlugin.dochooseQQFriendsForTransferResult(null);
      return;
    }
    ArrayList localArrayList = paramBundle.getStringArrayList("choose_friend_uins");
    paramBundle = paramBundle.getStringArrayList("choose_friend_names");
    this.mJsPlugin.startTransactionActivity((String)localArrayList.get(0), (String)paramBundle.get(0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.QWalletGetContactJsPlugin.ChooseQQFriendForTransferReceiver
 * JD-Core Version:    0.7.0.1
 */