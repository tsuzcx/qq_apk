import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.av.utils.UITools1;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.qav.ipc.IQavCallback.Stub;
import com.tencent.qav.ipc.QavMsgRecord;
import com.tencent.qav.ipc.QavState;
import com.tencent.qav.ipc.QavStateManager;
import com.tencent.qav.log.AVLog;
import java.util.ArrayList;

public class ljn
  extends IQavCallback.Stub
{
  private ljn(QavStateManager paramQavStateManager) {}
  
  public Bitmap a(int paramInt, String paramString)
  {
    Bitmap localBitmap = QavStateManager.a(this.a).a(paramString, true);
    if (localBitmap == null)
    {
      QavStateManager.b(this.a).add(paramString);
      QavStateManager.c(this.a);
    }
    return localBitmap;
  }
  
  public String a(int paramInt, String paramString)
  {
    FriendListHandler localFriendListHandler = null;
    Object localObject2 = (FriendsManager)QavStateManager.a(this.a).getManager(49);
    Object localObject1 = localFriendListHandler;
    if (localObject2 != null)
    {
      localObject2 = ((FriendsManager)localObject2).c(paramString);
      localObject1 = localFriendListHandler;
      if (localObject2 != null) {
        localObject1 = ((Friends)localObject2).getFriendNickWithAlias();
      }
    }
    if ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.equals((CharSequence)localObject1, paramString)))
    {
      localFriendListHandler = (FriendListHandler)QavStateManager.a(this.a).a(1);
      if (localFriendListHandler != null)
      {
        QavStateManager.a(this.a).add(paramString);
        QavStateManager.c(this.a);
        localFriendListHandler.b(paramString);
      }
    }
    return localObject1;
  }
  
  public void a(QavMsgRecord paramQavMsgRecord)
  {
    AVLog.d("QavStateManager", String.format("sendMsgRecord peerUin=%s recordType=%s", new Object[] { paramQavMsgRecord.b, Integer.valueOf(paramQavMsgRecord.jdField_a_of_type_Int) }));
    if (QavStateManager.a(this.a) != null) {
      if (paramQavMsgRecord.jdField_a_of_type_Long <= 0L) {
        break label76;
      }
    }
    label76:
    for (String str = UITools1.a(paramQavMsgRecord.jdField_a_of_type_Long / 1000L);; str = null)
    {
      VideoMsgTools.a(QavStateManager.a(this.a), paramQavMsgRecord, 0, str);
      return;
    }
  }
  
  public void a(QavState paramQavState)
  {
    AVLog.d("QavStateManager", String.format("notifyStartVideoChat sessionId=%s sessionState=%s", new Object[] { paramQavState.jdField_a_of_type_JavaLangString, paramQavState.jdField_a_of_type_ComTencentQavSessionQavSession$SessionStatus }));
    QavStateManager.a(this.a, paramQavState);
  }
  
  public void b(QavState paramQavState)
  {
    AVLog.d("QavStateManager", String.format("notifyUpdateVideoChat sessionId=%s sessionState=%s duration=%s", new Object[] { paramQavState.jdField_a_of_type_JavaLangString, paramQavState.jdField_a_of_type_ComTencentQavSessionQavSession$SessionStatus, Long.valueOf(paramQavState.b) }));
    QavStateManager.b(this.a, paramQavState);
  }
  
  public void c(QavState paramQavState)
  {
    AVLog.d("QavStateManager", String.format("notifyStopVideoChat sessionId=%s sessionState=%s", new Object[] { paramQavState.jdField_a_of_type_JavaLangString, paramQavState.jdField_a_of_type_ComTencentQavSessionQavSession$SessionStatus }));
    QavStateManager.c(this.a, paramQavState);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ljn
 * JD-Core Version:    0.7.0.1
 */