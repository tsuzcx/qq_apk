package oicq.wlogin_sdk.request;

import android.content.Context;
import oicq.wlogin_sdk.tools.util;

public class h
  extends Thread
{
  private Context a;
  
  public h(Context paramContext)
  {
    this.a = paramContext;
    setName("Wtlogin_CleanThread");
  }
  
  public void run()
  {
    util.deleteExpireLog(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.h
 * JD-Core Version:    0.7.0.1
 */