import com.tencent.component.network.utils.thread.PriorityThreadPool;
import java.util.HashMap;

public final class cuk
{
  private final int jdField_a_of_type_Int;
  private final String jdField_a_of_type_JavaLangString;
  private final HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public cuk(String paramString, int paramInt)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    int i = paramInt;
    if (paramInt <= 0) {
      i = 1;
    }
    this.jdField_a_of_type_JavaLangString = str;
    this.jdField_a_of_type_Int = i;
  }
  
  public PriorityThreadPool a(String paramString)
  {
    paramString = this.jdField_a_of_type_JavaLangString + "-" + paramString;
    ??? = (PriorityThreadPool)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (??? != null) {
      return ???;
    }
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      localPriorityThreadPool = (PriorityThreadPool)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
      if (localPriorityThreadPool != null) {
        return localPriorityThreadPool;
      }
    }
    PriorityThreadPool localPriorityThreadPool = new PriorityThreadPool(paramString, this.jdField_a_of_type_Int);
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localPriorityThreadPool);
    return localPriorityThreadPool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     cuk
 * JD-Core Version:    0.7.0.1
 */