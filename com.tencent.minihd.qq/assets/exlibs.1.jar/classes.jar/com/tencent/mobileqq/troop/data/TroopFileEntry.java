package com.tencent.mobileqq.troop.data;

import com.tencent.mobileqq.troop.utils.TroopFileManager;
import java.util.UUID;

public class TroopFileEntry
{
  public TroopFileManager a;
  public UUID a;
  
  public TroopFileEntry(TroopFileManager paramTroopFileManager, UUID paramUUID)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager = paramTroopFileManager;
    this.jdField_a_of_type_JavaUtilUUID = paramUUID;
  }
  
  public TroopFileInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager.a(this.jdField_a_of_type_JavaUtilUUID);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (!(paramObject instanceof TroopFileEntry))) {
        return false;
      }
      paramObject = (TroopFileEntry)paramObject;
    } while ((this.jdField_a_of_type_JavaUtilUUID.equals(paramObject.jdField_a_of_type_JavaUtilUUID)) && (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager == paramObject.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopFileEntry
 * JD-Core Version:    0.7.0.1
 */