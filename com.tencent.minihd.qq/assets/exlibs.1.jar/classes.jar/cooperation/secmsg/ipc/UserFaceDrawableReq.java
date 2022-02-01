package cooperation.secmsg.ipc;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.qphone.base.util.QLog;

public class UserFaceDrawableReq
  extends BaseReq
{
  public static final String a = "UserFaceDrawableReq.drawable";
  private static final String c = UserFaceDrawableReq.class.getName();
  public String b;
  
  public int a()
  {
    return 3;
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    paramBundle.putString("UserFaceDrawableReq.drawable", this.b);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    Bitmap localBitmap = paramQQAppInterface.a(1, this.b, (byte)3, true, 0);
    Object localObject = this.b;
    paramQQAppInterface = (FriendsManager)paramQQAppInterface.getManager(49);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.c(this.b);
      if (paramQQAppInterface == null) {}
    }
    for (paramQQAppInterface = paramQQAppInterface.getFriendNickWithAlias();; paramQQAppInterface = (QQAppInterface)localObject)
    {
      if (QLog.isColorLevel()) {
        QLog.d(c, 2, "request face bitmap of uin:" + this.b + ", userName:" + paramQQAppInterface);
      }
      localObject = new UserFaceDrawableResp();
      ((UserFaceDrawableResp)localObject).a = localBitmap;
      ((UserFaceDrawableResp)localObject).d = this.b;
      ((UserFaceDrawableResp)localObject).e = paramQQAppInterface;
      paramQQAppInterface = new Bundle();
      ((UserFaceDrawableResp)localObject).a(paramQQAppInterface);
      super.a(paramQQAppInterface);
      return;
    }
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    this.b = paramBundle.getString("UserFaceDrawableReq.drawable");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.secmsg.ipc.UserFaceDrawableReq
 * JD-Core Version:    0.7.0.1
 */