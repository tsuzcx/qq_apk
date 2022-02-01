import android.os.Handler;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.memoryleak.DumpMemInfoHandler;
import com.tencent.mobileqq.memoryleak.LeakInspector;
import com.tencent.mobileqq.memoryleak.LeakInspector.InspectorListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class jgf
  implements Runnable
{
  private int jdField_a_of_type_Int = 0;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private String b;
  
  public jgf(LeakInspector paramLeakInspector, WeakReference paramWeakReference, String paramString, int paramInt)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
    try
    {
      this.b = paramWeakReference.get().getClass().getSimpleName();
      return;
    }
    catch (Exception paramLeakInspector)
    {
      this.b = "Default";
    }
  }
  
  public void run()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("LeakInspector", 2, "Inspecting " + this.jdField_a_of_type_JavaLangString + " Time=" + System.currentTimeMillis() + " count=" + this.jdField_a_of_type_Int);
      }
      if (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) {
        break label503;
      }
      int i = this.jdField_a_of_type_Int + 1;
      this.jdField_a_of_type_Int = i;
      if (i < LeakInspector.a())
      {
        System.gc();
        LeakInspector.a(this.jdField_a_of_type_ComTencentMobileqqMemoryleakLeakInspector).postDelayed(this, 1000L);
        return;
      }
      if (!AppSetting.j) {
        break label334;
      }
      localObject1 = LeakInspector.a(this.jdField_a_of_type_ComTencentMobileqqMemoryleakLeakInspector).a(this.jdField_a_of_type_JavaLangString);
      localObject3 = this.b + "_leak";
      Object[] arrayOfObject = DumpMemInfoHandler.b((String)localObject3);
      localObject4 = (Boolean)arrayOfObject[0];
      str = "";
      if (!((Boolean)localObject4).booleanValue()) {
        break label454;
      }
      localObject4 = new ArrayList();
      ((List)localObject4).add((String)arrayOfObject[1]);
      if ((localObject1 != null) && (((List)localObject1).size() > 0)) {
        ((List)localObject4).addAll((Collection)localObject1);
      }
      localObject1 = DumpMemInfoHandler.a((List)localObject4, (String)localObject3);
      localObject4 = (Boolean)localObject1[0];
      str = (String)localObject1[1];
      localObject1 = localObject4;
      localObject3 = str;
      if (QLog.isColorLevel())
      {
        QLog.d("LeakInspector", 2, "leakFlag=true,ZipFile=" + localObject4 + ",leakName=" + this.jdField_a_of_type_JavaLangString + ",dumpPath=" + str);
        localObject3 = str;
        localObject1 = localObject4;
      }
    }
    catch (Throwable localThrowable)
    {
      Object localObject1;
      Object localObject3;
      Object localObject4;
      String str;
      label334:
      while (QLog.isColorLevel())
      {
        QLog.e("LeakInspector", 2, "error, " + this.jdField_a_of_type_JavaLangString + " Time=" + System.currentTimeMillis() + " count=" + this.jdField_a_of_type_Int, localThrowable);
        return;
        Object localObject2 = localObject4;
        localObject3 = str;
        if (QLog.isColorLevel())
        {
          QLog.e("LeakInspector", 2, "generateHprof error " + this.jdField_a_of_type_JavaLangString);
          localObject2 = localObject4;
          localObject3 = str;
        }
      }
      label454:
      label503:
      if (!QLog.isColorLevel()) {
        return;
      }
      QLog.d("LeakInspector", 2, "inspect " + this.jdField_a_of_type_JavaLangString + " finished no leak");
    }
    LeakInspector.a(this.jdField_a_of_type_ComTencentMobileqqMemoryleakLeakInspector).a(((Boolean)localObject1).booleanValue(), this.jdField_a_of_type_JavaLangString, (String)localObject3);
    if (QLog.isColorLevel()) {
      QLog.d("LeakInspector", 2, "inspect " + this.jdField_a_of_type_JavaLangString + " leaked");
    }
    LeakInspector.a(this.jdField_a_of_type_ComTencentMobileqqMemoryleakLeakInspector).a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangRefWeakReference);
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jgf
 * JD-Core Version:    0.7.0.1
 */