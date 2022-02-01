package com.tencent.mm.app;

import android.os.Handler;

public abstract class q$a
  implements q
{
  q wrapper = new q.a.1(this);
  
  public void alive()
  {
    AppForegroundDelegate.heY.a(this.wrapper);
  }
  
  public void dead()
  {
    AppForegroundDelegate.heY.b(this.wrapper);
  }
  
  Handler getHandler()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.app.q.a
 * JD-Core Version:    0.7.0.1
 */