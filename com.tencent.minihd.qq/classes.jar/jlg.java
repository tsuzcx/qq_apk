import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.persistence.OGStat;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class jlg
  implements Runnable
{
  public jlg(OGStat paramOGStat) {}
  
  public void run()
  {
    Object localObject1 = new ArrayList(this.a.jdField_a_of_type_JavaUtilHashMap.keySet());
    Collections.sort((List)localObject1);
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      String str2 = (String)((Iterator)localObject1).next();
      long l = ((Long)this.a.jdField_a_of_type_JavaUtilHashMap.get(str2)).longValue();
      int i = ((Integer)this.a.b.get(str2)).intValue();
      this.a.jdField_a_of_type_JavaLangStringBuilder.delete(0, this.a.jdField_a_of_type_JavaLangStringBuilder.length());
      this.a.jdField_a_of_type_JavaLangStringBuilder.append(str2);
      this.a.jdField_a_of_type_JavaLangStringBuilder.append(" t=");
      this.a.jdField_a_of_type_JavaLangStringBuilder.append(l);
      this.a.jdField_a_of_type_JavaLangStringBuilder.append(" c=");
      this.a.jdField_a_of_type_JavaLangStringBuilder.append(i);
      this.a.jdField_a_of_type_JavaLangStringBuilder.append(" per=");
      l = Math.round(l * 1.0D / i);
      this.a.jdField_a_of_type_JavaLangStringBuilder.append(l);
      OGStat.a(this.a.jdField_a_of_type_JavaLangStringBuilder.toString());
      Object localObject2 = BaseApplicationImpl.a().a();
      String str1 = ((AppRuntime)localObject2).getAccount();
      if (localObject2 != null)
      {
        localObject2 = BaseApplicationImpl.a;
        str2 = "actQOrmOper__" + str2;
        if (QLog.isDevelopLevel()) {
          QLog.d("OGStat", 2, "uploadStats tag = " + str2 + ", per = " + l);
        }
        StatisticCollector.a((Context)localObject2).a(str1, str2, true, l, 0L, null, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     jlg
 * JD-Core Version:    0.7.0.1
 */