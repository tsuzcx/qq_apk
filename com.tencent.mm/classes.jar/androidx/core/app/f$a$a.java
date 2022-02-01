package androidx.core.app;

import android.app.PendingIntent;
import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class f$a$a
{
  private final IconCompat bob;
  public boolean boe;
  private boolean bof;
  private int bog;
  private boolean boh;
  private final PendingIntent boj;
  private ArrayList<j> bok;
  private final CharSequence cZ;
  private final Bundle mExtras;
  
  public f$a$a(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent) {}
  
  private f$a$a(IconCompat paramIconCompat, CharSequence paramCharSequence, PendingIntent paramPendingIntent, Bundle paramBundle)
  {
    AppMethodBeat.i(196457);
    this.boe = true;
    this.bof = true;
    this.bob = paramIconCompat;
    this.cZ = f.d.p(paramCharSequence);
    this.boj = paramPendingIntent;
    this.mExtras = paramBundle;
    this.bok = null;
    this.boe = true;
    this.bog = 0;
    this.bof = true;
    this.boh = false;
    AppMethodBeat.o(196457);
  }
  
  public final f.a Dx()
  {
    AppMethodBeat.i(196471);
    if ((this.boh) && (this.boj == null))
    {
      localObject1 = new NullPointerException("Contextual Actions must contain a valid PendingIntent");
      AppMethodBeat.o(196471);
      throw ((Throwable)localObject1);
    }
    Object localObject1 = new ArrayList();
    Object localObject2 = new ArrayList();
    if (this.bok != null)
    {
      Iterator localIterator = this.bok.iterator();
      while (localIterator.hasNext())
      {
        j localj = (j)localIterator.next();
        if ((!localj.bpN) && ((localj.bpM == null) || (localj.bpM.length == 0)) && (localj.bpP != null) && (!localj.bpP.isEmpty())) {}
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label159;
          }
          ((List)localObject1).add(localj);
          break;
        }
        label159:
        ((List)localObject2).add(localj);
      }
    }
    if (((List)localObject1).isEmpty())
    {
      localObject1 = null;
      if (!((List)localObject2).isEmpty()) {
        break label264;
      }
    }
    label264:
    for (localObject2 = null;; localObject2 = (j[])((List)localObject2).toArray(new j[((List)localObject2).size()]))
    {
      localObject1 = new f.a(this.bob, this.cZ, this.boj, this.mExtras, (j[])localObject2, (j[])localObject1, this.boe, this.bog, this.bof, this.boh);
      AppMethodBeat.o(196471);
      return localObject1;
      localObject1 = (j[])((List)localObject1).toArray(new j[((List)localObject1).size()]);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.core.app.f.a.a
 * JD-Core Version:    0.7.0.1
 */