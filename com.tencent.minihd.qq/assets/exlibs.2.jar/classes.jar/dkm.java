import com.tencent.mobileqq.activity.Call;
import com.tencent.mobileqq.activity.recent.RecentCallHelper;
import com.tencent.mobileqq.activity.recent.RecentCallObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class dkm
  extends RecentCallObserver
{
  public dkm(Call paramCall) {}
  
  protected void a(boolean paramBoolean1, Integer paramInteger, String paramString, List paramList, boolean paramBoolean2)
  {
    if (Call.a(this.a) != null)
    {
      Call.a(this.a).a(paramBoolean1, paramInteger.intValue(), paramString, paramList);
      if ((!paramBoolean1) && (paramBoolean2)) {
        Call.a(this.a).a(this.a.app);
      }
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onOIDB0X7D7_0_Ret|isSuccess: " + paramBoolean1 + ", requestGap: " + paramInteger + ", cookies: " + paramString + ", retry: " + paramBoolean2);
      if (paramList != null)
      {
        paramInteger = paramList.iterator();
        while (paramInteger.hasNext())
        {
          paramString = (Long)paramInteger.next();
          localStringBuilder.append(", " + paramString);
        }
      }
      QLog.i("CallTab", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dkm
 * JD-Core Version:    0.7.0.1
 */