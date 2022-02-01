package androidx.lifecycle;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class LifecycleService
  extends Service
  implements q
{
  private final ae bHy;
  
  public LifecycleService()
  {
    AppMethodBeat.i(194511);
    this.bHy = new ae(this);
    AppMethodBeat.o(194511);
  }
  
  public j getLifecycle()
  {
    return this.bHy.bHV;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    AppMethodBeat.i(194527);
    this.bHy.c(j.a.ON_START);
    AppMethodBeat.o(194527);
    return null;
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(194520);
    this.bHy.c(j.a.ON_CREATE);
    super.onCreate();
    AppMethodBeat.o(194520);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(194566);
    ae localae = this.bHy;
    localae.c(j.a.ON_STOP);
    localae.c(j.a.ON_DESTROY);
    super.onDestroy();
    AppMethodBeat.o(194566);
  }
  
  public void onStart(Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(194536);
    this.bHy.c(j.a.ON_START);
    super.onStart(paramIntent, paramInt);
    AppMethodBeat.o(194536);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194552);
    paramInt1 = super.onStartCommand(paramIntent, paramInt1, paramInt2);
    AppMethodBeat.o(194552);
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.lifecycle.LifecycleService
 * JD-Core Version:    0.7.0.1
 */