package com.tencent.mm.j;

public final class c
{
  public String bUi;
  public int field_finishedLength;
  public boolean field_isUploadTask = false;
  public boolean field_mtlnotify;
  public int field_status;
  public int field_toltalLength;
  
  public final String toString()
  {
    return String.format("id:%s total:%d finLen:%d status:%d,mtl:%b, upload:%b", new Object[] { this.bUi, Integer.valueOf(this.field_toltalLength), Integer.valueOf(this.field_finishedLength), Integer.valueOf(this.field_status), Boolean.valueOf(this.field_mtlnotify), Boolean.valueOf(this.field_isUploadTask) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.j.c
 * JD-Core Version:    0.7.0.1
 */