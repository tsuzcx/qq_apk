package com.tencent.mobileqq.persistence;

import com.tencent.mobileqq.app.SQLiteOpenHelper;

public abstract class EntityManagerFactory
{
  private static final String CLOSE_EXCEPTION_MSG = "The EntityManagerFactory has been already closed";
  private boolean closed;
  private final SQLiteOpenHelper dbHelper = build(paramString);
  
  public EntityManagerFactory(String paramString) {}
  
  public abstract SQLiteOpenHelper build(String paramString);
  
  public void close()
  {
    if (this.closed) {
      throw new IllegalStateException("The EntityManagerFactory has been already closed");
    }
    this.closed = true;
    this.dbHelper.a();
  }
  
  public EntityManager createEntityManager()
  {
    if (this.closed) {
      throw new IllegalStateException("The EntityManagerFactory has been already closed");
    }
    EntityManager localEntityManager = new EntityManager(this.dbHelper);
    this.closed = false;
    return localEntityManager;
  }
  
  public EntityManager createMessageRecordEntityManager()
  {
    if (this.closed) {
      throw new IllegalStateException("The EntityManagerFactory has been already closed");
    }
    MessageRecordEntityManager localMessageRecordEntityManager = new MessageRecordEntityManager(this.dbHelper);
    this.closed = false;
    return localMessageRecordEntityManager;
  }
  
  public boolean isOpen()
  {
    return !this.closed;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.EntityManagerFactory
 * JD-Core Version:    0.7.0.1
 */