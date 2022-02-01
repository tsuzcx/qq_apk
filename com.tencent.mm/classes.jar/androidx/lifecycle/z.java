package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class z
{
  public static y a(FragmentActivity paramFragmentActivity)
  {
    AppMethodBeat.i(208074);
    paramFragmentActivity = a(paramFragmentActivity, null);
    AppMethodBeat.o(208074);
    return paramFragmentActivity;
  }
  
  public static y a(FragmentActivity paramFragmentActivity, y.b paramb)
  {
    AppMethodBeat.i(208075);
    Application localApplication = j(paramFragmentActivity);
    Object localObject = paramb;
    if (paramb == null) {
      localObject = y.a.a(localApplication);
    }
    paramFragmentActivity = new y(paramFragmentActivity.getViewModelStore(), (y.b)localObject);
    AppMethodBeat.o(208075);
    return paramFragmentActivity;
  }
  
  private static Application j(Activity paramActivity)
  {
    AppMethodBeat.i(208073);
    paramActivity = paramActivity.getApplication();
    if (paramActivity == null)
    {
      paramActivity = new IllegalStateException("Your activity/fragment is not yet attached to Application. You can't request ViewModel before onCreate call.");
      AppMethodBeat.o(208073);
      throw paramActivity;
    }
    AppMethodBeat.o(208073);
    return paramActivity;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     androidx.lifecycle.z
 * JD-Core Version:    0.7.0.1
 */