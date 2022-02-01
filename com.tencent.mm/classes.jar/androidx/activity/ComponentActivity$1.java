package androidx.activity;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ComponentActivity$1
  implements Runnable
{
  ComponentActivity$1(ComponentActivity paramComponentActivity) {}
  
  public final void run()
  {
    AppMethodBeat.i(199218);
    try
    {
      ComponentActivity.access$001(this.el);
      AppMethodBeat.o(199218);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      if (!TextUtils.equals(localIllegalStateException.getMessage(), "Can not perform this action after onSaveInstanceState"))
      {
        AppMethodBeat.o(199218);
        throw localIllegalStateException;
      }
      AppMethodBeat.o(199218);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.activity.ComponentActivity.1
 * JD-Core Version:    0.7.0.1
 */