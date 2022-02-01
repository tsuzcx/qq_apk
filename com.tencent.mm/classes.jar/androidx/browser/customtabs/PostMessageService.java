package androidx.browser.customtabs;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.support.a.a;
import android.support.a.c.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class PostMessageService
  extends Service
{
  private c.a zz;
  
  public PostMessageService()
  {
    AppMethodBeat.i(192979);
    this.zz = new c.a()
    {
      public final void a(a paramAnonymousa, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(192965);
        paramAnonymousa.c(paramAnonymousBundle);
        AppMethodBeat.o(192965);
      }
      
      public final void a(a paramAnonymousa, String paramAnonymousString, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(192977);
        paramAnonymousa.c(paramAnonymousString, paramAnonymousBundle);
        AppMethodBeat.o(192977);
      }
    };
    AppMethodBeat.o(192979);
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return this.zz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     androidx.browser.customtabs.PostMessageService
 * JD-Core Version:    0.7.0.1
 */