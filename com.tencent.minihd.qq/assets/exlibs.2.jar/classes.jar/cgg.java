import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.util.LruCache;
import com.tencent.biz.helper.QQHeadFace;
import com.tencent.biz.helper.QQHeadFace.IGetQQHeadCallBack;
import java.util.ArrayList;

public class cgg
  extends BroadcastReceiver
{
  public cgg(QQHeadFace paramQQHeadFace) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (!"com.tencent.qqhead.getheadresp".equals(paramIntent.getAction())) {}
    do
    {
      return;
      paramContext = paramIntent.getStringArrayListExtra("uinList");
      ArrayList localArrayList = paramIntent.getStringArrayListExtra("headPathList");
      paramIntent.getIntExtra("faceType", -1);
      paramIntent = new ArrayList();
      int i = 0;
      while (i < paramContext.size())
      {
        String str = (String)paramContext.get(i);
        if (QQHeadFace.a(this.a).contains(str))
        {
          QQHeadFace.a(this.a).remove(str);
          paramIntent.add(str);
          if (i < localArrayList.size()) {
            QQHeadFace.a(this.a).put(str, localArrayList.get(i));
          }
        }
        i += 1;
      }
    } while (paramIntent.size() <= 0);
    QQHeadFace.a(this.a).a(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cgg
 * JD-Core Version:    0.7.0.1
 */