package androidx.camera.core.impl;

import android.view.Surface;
import androidx.c.a.b;
import com.google.b.b.a.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

public final class ae
{
  public static void I(List<ad> paramList)
  {
    AppMethodBeat.i(198643);
    if (!paramList.isEmpty())
    {
      int i = 0;
      for (;;)
      {
        int k = i;
        try
        {
          ((ad)paramList.get(i)).gp();
          int j = i + 1;
          k = j;
          int m = paramList.size();
          i = j;
          if (j >= m)
          {
            AppMethodBeat.o(198643);
            return;
          }
        }
        catch (ad.a locala)
        {
          i = k - 1;
          while (i >= 0)
          {
            ((ad)paramList.get(i)).gq();
            i -= 1;
          }
          AppMethodBeat.o(198643);
          throw locala;
        }
      }
    }
    AppMethodBeat.o(198643);
  }
  
  public static void J(List<ad> paramList)
  {
    AppMethodBeat.i(198646);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      ((ad)paramList.next()).gq();
    }
    AppMethodBeat.o(198646);
  }
  
  public static f<List<Surface>> a(Collection<ad> paramCollection, long paramLong, Executor paramExecutor, ScheduledExecutorService paramScheduledExecutorService)
  {
    AppMethodBeat.i(198640);
    ArrayList localArrayList = new ArrayList();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      localArrayList.add(((ad)paramCollection.next()).kf());
    }
    paramCollection = b.a(new ae..ExternalSyntheticLambda0(localArrayList, paramScheduledExecutorService, paramExecutor, paramLong, false));
    AppMethodBeat.o(198640);
    return paramCollection;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.core.impl.ae
 * JD-Core Version:    0.7.0.1
 */