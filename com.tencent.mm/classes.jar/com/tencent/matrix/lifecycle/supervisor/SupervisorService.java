package com.tencent.matrix.lifecycle.supervisor;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/matrix/lifecycle/supervisor/SupervisorService;", "Landroid/app/Service;", "()V", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "plugin-performance_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class SupervisorService
  extends Service
{
  public final IBinder onBind(Intent paramIntent)
  {
    Log.d("STUB-SERVICE", "STUB-SERVICE");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.lifecycle.supervisor.SupervisorService
 * JD-Core Version:    0.7.0.1
 */