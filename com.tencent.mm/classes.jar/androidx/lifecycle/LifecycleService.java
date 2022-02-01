package androidx.lifecycle;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class LifecycleService
  extends Service
  implements l
{
  private final w aae;
  
  public LifecycleService()
  {
    AppMethodBeat.i(188837);
    this.aae = new w(this);
    AppMethodBeat.o(188837);
  }
  
  public h getLifecycle()
  {
    return this.aae.aaB;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    AppMethodBeat.i(188845);
    this.aae.d(h.a.ON_START);
    AppMethodBeat.o(188845);
    return null;
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(188840);
    this.aae.d(h.a.ON_CREATE);
    super.onCreate();
    AppMethodBeat.o(188840);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(188853);
    w localw = this.aae;
    localw.d(h.a.ON_STOP);
    localw.d(h.a.ON_DESTROY);
    super.onDestroy();
    AppMethodBeat.o(188853);
  }
  
  public void onStart(Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(188849);
    this.aae.d(h.a.ON_START);
    super.onStart(paramIntent, paramInt);
    AppMethodBeat.o(188849);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(188851);
    paramInt1 = super.onStartCommand(paramIntent, paramInt1, paramInt2);
    AppMethodBeat.o(188851);
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     androidx.lifecycle.LifecycleService
 * JD-Core Version:    0.7.0.1
 */