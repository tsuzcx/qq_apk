import com.tencent.mobileqq.persistence.OGStat;
import java.util.HashMap;

public class jlf
  implements Runnable
{
  public jlf(OGStat paramOGStat, String paramString, long paramLong) {}
  
  public void run()
  {
    Object localObject2 = (Long)this.jdField_a_of_type_ComTencentMobileqqPersistenceOGStat.a.get(this.jdField_a_of_type_JavaLangString);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = Long.valueOf(0L);
    }
    long l1 = ((Long)localObject1).longValue();
    long l2 = this.jdField_a_of_type_Long;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceOGStat.a.put(this.jdField_a_of_type_JavaLangString, Long.valueOf(l1 + l2));
    localObject2 = (Integer)this.jdField_a_of_type_ComTencentMobileqqPersistenceOGStat.b.get(this.jdField_a_of_type_JavaLangString);
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = Integer.valueOf(0);
    }
    int i = ((Integer)localObject1).intValue();
    this.jdField_a_of_type_ComTencentMobileqqPersistenceOGStat.b.put(this.jdField_a_of_type_JavaLangString, Integer.valueOf(i + 1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     jlf
 * JD-Core Version:    0.7.0.1
 */