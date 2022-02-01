package android.support.customtabs;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;

public class PostMessageService
  extends Service
{
  private f.a gI = new f.a()
  {
    public final void a(d paramAnonymousd, Bundle paramAnonymousBundle)
    {
      paramAnonymousd.b(paramAnonymousBundle);
    }
    
    public final void a(d paramAnonymousd, String paramAnonymousString, Bundle paramAnonymousBundle)
    {
      paramAnonymousd.c(paramAnonymousString, paramAnonymousBundle);
    }
  };
  
  public IBinder onBind(Intent paramIntent)
  {
    return this.gI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.customtabs.PostMessageService
 * JD-Core Version:    0.7.0.1
 */