package com.tencent.mqp.app.dbfs;

import java.io.ByteArrayOutputStream;

public class DBStoredFile$FileOutputStream
  extends ByteArrayOutputStream
{
  public DBStoredFile$FileOutputStream(DBStoredFile paramDBStoredFile) {}
  
  public void close()
  {
    flush();
  }
  
  public void flush()
  {
    this.a.a(toByteArray());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mqp.app.dbfs.DBStoredFile.FileOutputStream
 * JD-Core Version:    0.7.0.1
 */