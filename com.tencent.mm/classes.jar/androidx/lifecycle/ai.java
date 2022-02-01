package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ai
{
  public static ah a(FragmentActivity paramFragmentActivity, ah.b paramb)
  {
    AppMethodBeat.i(194423);
    Application localApplication = paramFragmentActivity.getApplication();
    if (localApplication == null)
    {
      paramFragmentActivity = new IllegalStateException("Your activity/fragment is not yet attached to Application. You can't request ViewModel before onCreate call.");
      AppMethodBeat.o(194423);
      throw paramFragmentActivity;
    }
    Object localObject = paramb;
    if (paramb == null) {
      localObject = ah.a.a(localApplication);
    }
    paramFragmentActivity = new ah(paramFragmentActivity.getViewModelStore(), (ah.b)localObject);
    AppMethodBeat.o(194423);
    return paramFragmentActivity;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.lifecycle.ai
 * JD-Core Version:    0.7.0.1
 */