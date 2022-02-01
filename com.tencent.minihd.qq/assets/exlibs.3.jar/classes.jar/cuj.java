import com.tencent.component.network.downloader.impl.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class cuj
{
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private Map jdField_a_of_type_JavaUtilMap = new HashMap();
  
  private cuj(c paramc) {}
  
  public Object a(String paramString)
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString))
        {
          paramString = this.jdField_a_of_type_JavaUtilMap.get(paramString);
          return paramString;
        }
        if (this.jdField_a_of_type_JavaUtilList.size() > 0)
        {
          localObject1 = this.jdField_a_of_type_JavaUtilList.remove(0);
          this.jdField_a_of_type_JavaUtilMap.put(paramString, localObject1);
          return localObject1;
        }
      }
      Object localObject1 = new Object();
    }
  }
  
  public void a(String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) {
        return;
      }
      paramString = this.jdField_a_of_type_JavaUtilMap.remove(paramString);
      if ((paramString != null) && (!this.jdField_a_of_type_JavaUtilList.contains(paramString))) {
        this.jdField_a_of_type_JavaUtilList.add(paramString);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     cuj
 * JD-Core Version:    0.7.0.1
 */