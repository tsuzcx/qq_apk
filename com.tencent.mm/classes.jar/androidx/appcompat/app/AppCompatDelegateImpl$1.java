package androidx.appcompat.app;

import android.content.res.Resources.NotFoundException;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AppCompatDelegateImpl$1
  implements Thread.UncaughtExceptionHandler
{
  AppCompatDelegateImpl$1(Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler) {}
  
  public final void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    int j = 0;
    AppMethodBeat.i(238084);
    int i = j;
    Object localObject;
    if ((paramThrowable instanceof Resources.NotFoundException))
    {
      localObject = paramThrowable.getMessage();
      i = j;
      if (localObject != null) {
        if (!((String)localObject).contains("drawable"))
        {
          i = j;
          if (!((String)localObject).contains("Drawable")) {}
        }
        else
        {
          i = 1;
        }
      }
    }
    if (i != 0)
    {
      localObject = new Resources.NotFoundException(paramThrowable.getMessage() + ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
      ((Throwable)localObject).initCause(paramThrowable.getCause());
      ((Throwable)localObject).setStackTrace(paramThrowable.getStackTrace());
      this.gF.uncaughtException(paramThread, (Throwable)localObject);
      AppMethodBeat.o(238084);
      return;
    }
    this.gF.uncaughtException(paramThread, paramThrowable);
    AppMethodBeat.o(238084);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     androidx.appcompat.app.AppCompatDelegateImpl.1
 * JD-Core Version:    0.7.0.1
 */