import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import java.util.Map;

public class kmg
  extends BizTroopObserver
{
  static
  {
    if (!TroopFileManager.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  public kmg(TroopFileManager paramTroopFileManager) {}
  
  protected void a(Object arg1)
  {
    boolean bool = true;
    if ((??? == null) || (!(??? instanceof TroopFileStatusInfo))) {}
    TroopFileStatusInfo localTroopFileStatusInfo1;
    do
    {
      return;
      localTroopFileStatusInfo1 = (TroopFileStatusInfo)???;
    } while (localTroopFileStatusInfo1.jdField_a_of_type_Long != this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager.jdField_b_of_type_Long);
    if (localTroopFileStatusInfo1.b == 12)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager.b(localTroopFileStatusInfo1.jdField_a_of_type_JavaUtilUUID);
      return;
    }
    TroopFileInfo localTroopFileInfo;
    synchronized (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager)
    {
      localTroopFileInfo = (TroopFileInfo)this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager.jdField_b_of_type_JavaUtilMap.get(localTroopFileStatusInfo1.jdField_a_of_type_JavaUtilUUID);
      if ((!jdField_a_of_type_Boolean) && (localTroopFileInfo == null)) {
        throw new AssertionError();
      }
    }
    if (localTroopFileInfo == null) {
      return;
    }
    int i = localTroopFileInfo.g;
    if (localTroopFileInfo.jdField_a_of_type_Boolean) {
      if (localTroopFileStatusInfo2.b != 11) {
        break label271;
      }
    }
    for (;;)
    {
      for (localTroopFileInfo.jdField_a_of_type_Boolean = bool;; localTroopFileInfo.jdField_a_of_type_Boolean = true) {
        do
        {
          if ((localTroopFileInfo.b == null) && (localTroopFileStatusInfo2.d != null)) {
            this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager.c.put(localTroopFileStatusInfo2.d, localTroopFileInfo);
          }
          localTroopFileInfo.a(localTroopFileStatusInfo2, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager.a);
          if ((localTroopFileStatusInfo2.b == 6) && (i != 6)) {
            this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager.a(localTroopFileStatusInfo2.d);
          }
          this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager.c(localTroopFileInfo);
          return;
        } while ((localTroopFileStatusInfo2.b != 11) || (localTroopFileInfo.g == 11));
      }
      label271:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kmg
 * JD-Core Version:    0.7.0.1
 */