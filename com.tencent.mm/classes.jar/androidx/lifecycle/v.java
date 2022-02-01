package androidx.lifecycle;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class v
  extends Fragment
{
  a aaI;
  
  private void c(h.a parama)
  {
    AppMethodBeat.i(263253);
    Object localObject = getActivity();
    if ((localObject instanceof n))
    {
      ((n)localObject).jg().a(parama);
      AppMethodBeat.o(263253);
      return;
    }
    if ((localObject instanceof l))
    {
      localObject = ((l)localObject).getLifecycle();
      if ((localObject instanceof m)) {
        ((m)localObject).a(parama);
      }
    }
    AppMethodBeat.o(263253);
  }
  
  public static void h(Activity paramActivity)
  {
    AppMethodBeat.i(263241);
    paramActivity = paramActivity.getFragmentManager();
    if (paramActivity.findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") == null)
    {
      paramActivity.beginTransaction().add(new v(), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
      paramActivity.executePendingTransactions();
    }
    AppMethodBeat.o(263241);
  }
  
  static v i(Activity paramActivity)
  {
    AppMethodBeat.i(263242);
    paramActivity = (v)paramActivity.getFragmentManager().findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag");
    AppMethodBeat.o(263242);
    return paramActivity;
  }
  
  public final void onActivityCreated(Bundle paramBundle)
  {
    AppMethodBeat.i(263244);
    super.onActivityCreated(paramBundle);
    c(h.a.ON_CREATE);
    AppMethodBeat.o(263244);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(263252);
    super.onDestroy();
    c(h.a.ON_DESTROY);
    this.aaI = null;
    AppMethodBeat.o(263252);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(263247);
    super.onPause();
    c(h.a.ON_PAUSE);
    AppMethodBeat.o(263247);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(263246);
    super.onResume();
    a locala = this.aaI;
    if (locala != null) {
      locala.onResume();
    }
    c(h.a.ON_RESUME);
    AppMethodBeat.o(263246);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(263245);
    super.onStart();
    a locala = this.aaI;
    if (locala != null) {
      locala.onStart();
    }
    c(h.a.ON_START);
    AppMethodBeat.o(263245);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(263250);
    super.onStop();
    c(h.a.ON_STOP);
    AppMethodBeat.o(263250);
  }
  
  static abstract interface a
  {
    public abstract void onResume();
    
    public abstract void onStart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.lifecycle.v
 * JD-Core Version:    0.7.0.1
 */