import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable.DebuggableCallback;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class jvy
  implements URLDrawable.DebuggableCallback
{
  private Set a = new HashSet();
  
  void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    StatisticCollector localStatisticCollector = StatisticCollector.a(BaseApplication.getContext());
    HashMap localHashMap = new HashMap();
    localHashMap.put("ViewSize", paramString1);
    localHashMap.put("PicSize", paramString2);
    localHashMap.put("URL", paramString3);
    localHashMap.put("Stack", paramString4);
    localStatisticCollector.a("", "largePic2", true, 0L, 0L, localHashMap, "");
  }
  
  public void onDebug(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    }
    String str2;
    String str3;
    String str4;
    String str1;
    do
    {
      do
      {
        return;
        paramObject = (Object[])paramObject;
      } while (paramObject.length != 5);
      str2 = (String)paramObject[0];
      str3 = (String)paramObject[1];
      str4 = (String)paramObject[2];
      a(str2, str3, str4, (String)paramObject[4]);
      str1 = (String)paramObject[3];
    } while (this.a.contains(str1));
    this.a.add(str1);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("WARNING:图片Decode过大 ");
    if (!TextUtils.isEmpty(str1))
    {
      paramInt = str1.lastIndexOf('.');
      paramObject = str1;
      if (paramInt != -1) {
        paramObject = str1.substring(paramInt + 1);
      }
      localStringBuffer.append("Activity:");
      localStringBuffer.append(paramObject);
      localStringBuffer.append(" ");
    }
    localStringBuffer.append(str2);
    localStringBuffer.append(" ");
    localStringBuffer.append(str3);
    localStringBuffer.append(" url=");
    localStringBuffer.append(str4);
    QQToast.a(BaseApplicationImpl.a.getApplicationContext(), localStringBuffer.toString(), 3000).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     jvy
 * JD-Core Version:    0.7.0.1
 */