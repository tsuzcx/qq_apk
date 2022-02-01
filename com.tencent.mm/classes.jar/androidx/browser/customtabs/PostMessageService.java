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
  private c.a yD;
  
  public PostMessageService()
  {
    AppMethodBeat.i(191342);
    this.yD = new c.a()
    {
      public final void a(a paramAnonymousa, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(191334);
        paramAnonymousa.b(paramAnonymousBundle);
        AppMethodBeat.o(191334);
      }
      
      public final void a(a paramAnonymousa, String paramAnonymousString, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(191337);
        paramAnonymousa.c(paramAnonymousString, paramAnonymousBundle);
        AppMethodBeat.o(191337);
      }
    };
    AppMethodBeat.o(191342);
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return this.yD;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     androidx.browser.customtabs.PostMessageService
 * JD-Core Version:    0.7.0.1
 */