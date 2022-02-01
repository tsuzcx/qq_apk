package com.tencent.mobileqq.activity.widget.qqmusic.business.manager;

public abstract class BaseLoadFolderListManager
  implements ILoadFolderListManager
{
  protected static final int a = 0;
  private static final long a = 3600000L;
  protected static final int b = 1;
  protected static final int c = 2;
  private long b = 0L;
  protected int d = 0;
  
  public void a(boolean paramBoolean)
  {
    this.d = 0;
  }
  
  protected boolean a()
  {
    long l = System.currentTimeMillis();
    if (this.d != 1)
    {
      this.b = l;
      return false;
    }
    if (l - this.b > 3600000L)
    {
      this.b = l;
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.qqmusic.business.manager.BaseLoadFolderListManager
 * JD-Core Version:    0.7.0.1
 */