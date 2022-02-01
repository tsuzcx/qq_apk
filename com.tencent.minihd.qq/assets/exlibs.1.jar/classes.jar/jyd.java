import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.subaccount.SubAccountProtocManager;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class jyd
  extends Thread
{
  public jyd(SubAccountProtocManager paramSubAccountProtocManager, String paramString)
  {
    super(paramString);
  }
  
  public void run()
  {
    int i = 1;
    super.run();
    SharedPreferences localSharedPreferences = SubAccountProtocManager.a(this.a).a().getSharedPreferences("mobileQQ", 0);
    long l3 = localSharedPreferences.getLong("subaccount_last_report_time_" + SubAccountProtocManager.a(this.a).a(), 0L);
    long l4 = System.currentTimeMillis() - 10L;
    Object localObject = Calendar.getInstance();
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTimeInMillis(l3);
    localCalendar1.add(5, 1);
    localCalendar1.clear(10);
    localCalendar1.clear(12);
    localCalendar1.clear(13);
    localCalendar1.clear(14);
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.add(5, 1);
    localCalendar2.clear(10);
    localCalendar2.clear(12);
    localCalendar2.clear(13);
    localCalendar2.clear(14);
    long l2 = localCalendar2.getTimeInMillis() - l4 - 100L;
    long l1 = l2;
    if (l2 < 0L) {
      l1 = 86400000L;
    }
    if ((l3 > 0L) && (((Calendar)localObject).after(localCalendar1)) && (SubAccountControll.a(SubAccountProtocManager.a(this.a))))
    {
      boolean bool = SubAccountControll.b(SubAccountProtocManager.a(this.a));
      localObject = new HashMap();
      if (!bool) {
        break label454;
      }
    }
    for (;;)
    {
      ((Map)localObject).put("Top_bind_account", Integer.valueOf(i));
      StatisticCollector.a(SubAccountProtocManager.a(this.a).a()).b(SubAccountProtocManager.a(this.a), SubAccountProtocManager.a(this.a).a(), (Map)localObject);
      localSharedPreferences.edit().putLong("subaccount_last_report_time_" + SubAccountProtocManager.a(this.a).a(), l4).commit();
      if (l3 == 0L) {
        localSharedPreferences.edit().putLong("subaccount_last_report_time_" + SubAccountProtocManager.a(this.a).a(), l4).commit();
      }
      l2 = (Math.random() * 30.0D * 60.0D * 1000.0D);
      if (SubAccountProtocManager.a(this.a) != null) {
        SubAccountProtocManager.a(this.a).postDelayed(SubAccountProtocManager.a(this.a), l2 + l1 + 60000L);
      }
      return;
      label454:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jyd
 * JD-Core Version:    0.7.0.1
 */