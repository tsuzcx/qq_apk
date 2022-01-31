package android.support.customtabs;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class PostMessageService
  extends Service
{
  private f.a dM = new PostMessageService.1(this);
  
  public IBinder onBind(Intent paramIntent)
  {
    return this.dM;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.customtabs.PostMessageService
 * JD-Core Version:    0.7.0.1
 */