import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class hno
  extends Handler
{
  public hno(QQAppInterface paramQQAppInterface, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    ArrayList localArrayList;
    int i;
    Intent localIntent;
    if (paramMessage.what == 990)
    {
      paramMessage = QQAppInterface.a(this.a);
      QQAppInterface.a(this.a, null);
      QQAppInterface.a(this.a).removeMessages(990);
      localArrayList = new ArrayList();
      if ((paramMessage != null) && (paramMessage.size() > 0))
      {
        i = 0;
        while (i < paramMessage.size())
        {
          localArrayList.add(this.a.a(1, (String)paramMessage.get(i), 0));
          i += 1;
        }
        localIntent = new Intent("com.tencent.qqhead.getheadresp");
        localIntent.putStringArrayListExtra("uinList", paramMessage);
        localIntent.putStringArrayListExtra("headPathList", localArrayList);
        this.a.a().sendBroadcast(localIntent, "com.tencent.qqhead.permission.getheadresp2");
      }
      if (QLog.isColorLevel()) {
        QQUtils.a("Q.qqhead.broadcast", 2, "headQQHeadBroadcast, getQQHead resp uinList: ", paramMessage);
      }
    }
    do
    {
      do
      {
        return;
      } while (paramMessage.what != 991);
      paramMessage = QQAppInterface.b(this.a);
      QQAppInterface.b(this.a, null);
      QQAppInterface.a(this.a).removeMessages(991);
      localArrayList = new ArrayList();
      if ((paramMessage != null) && (paramMessage.size() > 0))
      {
        i = 0;
        while (i < paramMessage.size())
        {
          localArrayList.add(this.a.a(4, (String)paramMessage.get(i), 0));
          i += 1;
        }
        localIntent = new Intent("com.tencent.qqhead.getheadresp");
        localIntent.setPackage(QQAppInterface.d(this.a).getPackageName());
        localIntent.putStringArrayListExtra("uinList", paramMessage);
        localIntent.putStringArrayListExtra("headPathList", localArrayList);
        localIntent.putExtra("faceType", 4);
        this.a.a().sendBroadcast(localIntent, "com.tencent.qqhead.permission.getheadresp2");
      }
    } while (!QLog.isColorLevel());
    QQUtils.a("Q.qqhead.broadcast", 2, "headQQHeadBroadcast, getQQHead resp uinList: ", paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hno
 * JD-Core Version:    0.7.0.1
 */