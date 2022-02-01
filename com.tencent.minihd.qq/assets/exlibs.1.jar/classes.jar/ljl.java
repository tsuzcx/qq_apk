import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.qav.ipc.IQavService;
import com.tencent.qav.ipc.QavStateManager;
import com.tencent.qav.log.AVLog;
import java.util.ArrayList;

public class ljl
  extends FriendListObserver
{
  public ljl(QavStateManager paramQavStateManager) {}
  
  protected void a(String paramString, boolean paramBoolean)
  {
    if (QavStateManager.a(this.a).contains(paramString))
    {
      AVLog.d("QavStateManager", String.format("onUpdateFriendInfo uin=%s isSuccess=%s", new Object[] { paramString, Boolean.valueOf(paramBoolean) }));
      if (paramBoolean)
      {
        localObject1 = (FriendsManager)QavStateManager.a(this.a).getManager(49);
        if (localObject1 == null) {
          break label141;
        }
        localObject1 = ((FriendsManager)localObject1).c(paramString);
        if (localObject1 == null) {
          break label141;
        }
      }
    }
    label141:
    Object localObject2;
    for (Object localObject1 = ((Friends)localObject1).getFriendNickWithAlias();; localObject2 = null)
    {
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (QavStateManager.a(this.a) != null)) {}
      try
      {
        QavStateManager.a(this.a).a(paramString, (String)localObject1);
        QavStateManager.a(this.a).remove(paramString);
        QavStateManager.a(this.a);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          AVLog.e("QavStateManager", "onUpdateFriendInfo fail.", localException);
        }
      }
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    Bitmap localBitmap;
    if (QavStateManager.b(this.a).contains(paramString))
    {
      AVLog.d("QavStateManager", String.format("onUpdateCustomHead uin=%s isSuccess=%s", new Object[] { paramString, Boolean.valueOf(paramBoolean) }));
      if (paramBoolean)
      {
        localBitmap = QavStateManager.a(this.a).a(paramString, false);
        if ((localBitmap == null) || (QavStateManager.a(this.a) == null)) {}
      }
    }
    try
    {
      QavStateManager.a(this.a).a(paramString, localBitmap);
      QavStateManager.b(this.a).remove(paramString);
      QavStateManager.a(this.a);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        AVLog.e("QavStateManager", "onUpdateCustomHead fail.", localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ljl
 * JD-Core Version:    0.7.0.1
 */