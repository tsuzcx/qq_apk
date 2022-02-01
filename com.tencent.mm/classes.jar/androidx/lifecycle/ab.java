package androidx.lifecycle;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ab
  extends Fragment
{
  a bIc;
  
  static void a(Activity paramActivity, j.a parama)
  {
    AppMethodBeat.i(194461);
    if ((paramActivity instanceof t))
    {
      ((t)paramActivity).Hj().a(parama);
      AppMethodBeat.o(194461);
      return;
    }
    if ((paramActivity instanceof q))
    {
      paramActivity = ((q)paramActivity).getLifecycle();
      if ((paramActivity instanceof s)) {
        ((s)paramActivity).a(parama);
      }
    }
    AppMethodBeat.o(194461);
  }
  
  private void b(j.a parama)
  {
    AppMethodBeat.i(194478);
    if (Build.VERSION.SDK_INT < 29) {
      a(getActivity(), parama);
    }
    AppMethodBeat.o(194478);
  }
  
  public static void j(Activity paramActivity)
  {
    AppMethodBeat.i(194452);
    if (Build.VERSION.SDK_INT >= 29) {
      b.registerIn(paramActivity);
    }
    paramActivity = paramActivity.getFragmentManager();
    if (paramActivity.findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") == null)
    {
      paramActivity.beginTransaction().add(new ab(), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
      paramActivity.executePendingTransactions();
    }
    AppMethodBeat.o(194452);
  }
  
  static ab k(Activity paramActivity)
  {
    AppMethodBeat.i(194469);
    paramActivity = (ab)paramActivity.getFragmentManager().findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag");
    AppMethodBeat.o(194469);
    return paramActivity;
  }
  
  public final void onActivityCreated(Bundle paramBundle)
  {
    AppMethodBeat.i(194485);
    super.onActivityCreated(paramBundle);
    b(j.a.ON_CREATE);
    AppMethodBeat.o(194485);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(194513);
    super.onDestroy();
    b(j.a.ON_DESTROY);
    this.bIc = null;
    AppMethodBeat.o(194513);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(194501);
    super.onPause();
    b(j.a.ON_PAUSE);
    AppMethodBeat.o(194501);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(194498);
    super.onResume();
    a locala = this.bIc;
    if (locala != null) {
      locala.onResume();
    }
    b(j.a.ON_RESUME);
    AppMethodBeat.o(194498);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(194492);
    super.onStart();
    a locala = this.bIc;
    if (locala != null) {
      locala.onStart();
    }
    b(j.a.ON_START);
    AppMethodBeat.o(194492);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(194508);
    super.onStop();
    b(j.a.ON_STOP);
    AppMethodBeat.o(194508);
  }
  
  static abstract interface a
  {
    public abstract void onResume();
    
    public abstract void onStart();
  }
  
  static final class b
    implements Application.ActivityLifecycleCallbacks
  {
    static void registerIn(Activity paramActivity)
    {
      AppMethodBeat.i(194497);
      paramActivity.registerActivityLifecycleCallbacks(new b());
      AppMethodBeat.o(194497);
    }
    
    public final void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
    
    public final void onActivityDestroyed(Activity paramActivity) {}
    
    public final void onActivityPaused(Activity paramActivity) {}
    
    public final void onActivityPostCreated(Activity paramActivity, Bundle paramBundle)
    {
      AppMethodBeat.i(194505);
      ab.a(paramActivity, j.a.ON_CREATE);
      AppMethodBeat.o(194505);
    }
    
    public final void onActivityPostResumed(Activity paramActivity)
    {
      AppMethodBeat.i(194526);
      ab.a(paramActivity, j.a.ON_RESUME);
      AppMethodBeat.o(194526);
    }
    
    public final void onActivityPostStarted(Activity paramActivity)
    {
      AppMethodBeat.i(194517);
      ab.a(paramActivity, j.a.ON_START);
      AppMethodBeat.o(194517);
    }
    
    public final void onActivityPreDestroyed(Activity paramActivity)
    {
      AppMethodBeat.i(194572);
      ab.a(paramActivity, j.a.ON_DESTROY);
      AppMethodBeat.o(194572);
    }
    
    public final void onActivityPrePaused(Activity paramActivity)
    {
      AppMethodBeat.i(194535);
      ab.a(paramActivity, j.a.ON_PAUSE);
      AppMethodBeat.o(194535);
    }
    
    public final void onActivityPreStopped(Activity paramActivity)
    {
      AppMethodBeat.i(194547);
      ab.a(paramActivity, j.a.ON_STOP);
      AppMethodBeat.o(194547);
    }
    
    public final void onActivityResumed(Activity paramActivity) {}
    
    public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
    
    public final void onActivityStarted(Activity paramActivity) {}
    
    public final void onActivityStopped(Activity paramActivity) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.lifecycle.ab
 * JD-Core Version:    0.7.0.1
 */