package com.tencent.mqp.app.dbfs;

import android.content.Context;

public class DBStoredFile
{
  Context jdField_a_of_type_AndroidContentContext;
  DBPathNode jdField_a_of_type_ComTencentMqpAppDbfsDBPathNode;
  
  public DBStoredFile(Context paramContext, String paramString)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMqpAppDbfsDBPathNode = new DBPathNode(paramContext, paramString);
  }
  
  public int a(byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_ComTencentMqpAppDbfsDBPathNode.a()) {
      return this.jdField_a_of_type_ComTencentMqpAppDbfsDBPathNode.a(paramArrayOfByte);
    }
    return 0;
  }
  
  public DBStoredFile.FileInputStream a()
  {
    byte[] arrayOfByte = this.jdField_a_of_type_ComTencentMqpAppDbfsDBPathNode.a();
    if (arrayOfByte == null) {
      return null;
    }
    return new DBStoredFile.FileInputStream(this, arrayOfByte);
  }
  
  public DBStoredFile.FileOutputStream a()
  {
    return new DBStoredFile.FileOutputStream(this);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMqpAppDbfsDBPathNode.b();
  }
  
  public byte[] a()
  {
    return this.jdField_a_of_type_ComTencentMqpAppDbfsDBPathNode.a();
  }
  
  public String[] a()
  {
    return this.jdField_a_of_type_ComTencentMqpAppDbfsDBPathNode.a();
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMqpAppDbfsDBPathNode.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mqp.app.dbfs.DBStoredFile
 * JD-Core Version:    0.7.0.1
 */