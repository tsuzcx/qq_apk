import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.FriendProfileImageModel.ProfileImageInfo;
import com.tencent.mobileqq.activity.FriendProfileImagePortraits;
import java.util.HashMap;
import java.util.Stack;

public class ecq
  extends Handler
{
  public ecq(FriendProfileImagePortraits paramFriendProfileImagePortraits) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      paramMessage = (String)FriendProfileImagePortraits.a(this.a).pop();
      if ((TextUtils.isEmpty(paramMessage)) && (FriendProfileImagePortraits.a(this.a) != null))
      {
        paramMessage = (FriendProfileImageModel.ProfileImageInfo)FriendProfileImagePortraits.a(this.a).get(paramMessage);
        if (paramMessage != null) {
          this.a.e(paramMessage);
        }
      }
    } while (FriendProfileImagePortraits.a(this.a).isEmpty());
    FriendProfileImagePortraits.a(this.a).sendEmptyMessageDelayed(1, 300L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ecq
 * JD-Core Version:    0.7.0.1
 */