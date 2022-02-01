package com.tencent.mobileqq.persistence;

import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class EntityTransaction
{
  private static final Lock jdField_a_of_type_JavaUtilConcurrentLocksLock = new ReentrantLock();
  private SQLiteDatabase jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase;
  private final SQLiteOpenHelper jdField_a_of_type_ComTencentMobileqqAppSQLiteOpenHelper;
  
  EntityTransaction(SQLiteOpenHelper paramSQLiteOpenHelper)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppSQLiteOpenHelper = paramSQLiteOpenHelper;
  }
  
  public void a()
  {
    jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqAppSQLiteOpenHelper.a();
    this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase.b();
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 34	com/tencent/mobileqq/persistence/EntityTransaction:jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase	Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   4: invokevirtual 44	com/tencent/mobileqq/app/SQLiteDatabase:d	()V
    //   7: aload_0
    //   8: aconst_null
    //   9: putfield 34	com/tencent/mobileqq/persistence/EntityTransaction:jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase	Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   12: getstatic 17	com/tencent/mobileqq/persistence/EntityTransaction:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   15: invokeinterface 47 1 0
    //   20: return
    //   21: astore_1
    //   22: getstatic 17	com/tencent/mobileqq/persistence/EntityTransaction:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   25: invokeinterface 47 1 0
    //   30: return
    //   31: astore_1
    //   32: getstatic 17	com/tencent/mobileqq/persistence/EntityTransaction:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   35: invokeinterface 47 1 0
    //   40: aload_1
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	EntityTransaction
    //   21	1	1	localException	java.lang.Exception
    //   31	10	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	12	21	java/lang/Exception
    //   0	12	31	finally
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.EntityTransaction
 * JD-Core Version:    0.7.0.1
 */