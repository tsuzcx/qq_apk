package android.support.v4.app;

import android.app.PendingIntent;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class s$a$a
{
  public boolean Fi = true;
  private boolean Fj = true;
  private int Fk;
  private final int Fl;
  private final CharSequence Fm;
  private final PendingIntent Fn;
  private ArrayList<x> Fo;
  private final Bundle mExtras;
  
  public s$a$a(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent)
  {
    this(paramInt, paramCharSequence, paramPendingIntent, new Bundle());
  }
  
  private s$a$a(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent, Bundle paramBundle)
  {
    this.Fl = paramInt;
    this.Fm = s.c.j(paramCharSequence);
    this.Fn = paramPendingIntent;
    this.mExtras = paramBundle;
    this.Fo = null;
    this.Fi = true;
    this.Fk = 0;
    this.Fj = true;
  }
  
  public final s.a dT()
  {
    Object localObject1 = new ArrayList();
    Object localObject2 = new ArrayList();
    if (this.Fo != null)
    {
      Iterator localIterator = this.Fo.iterator();
      while (localIterator.hasNext())
      {
        x localx = (x)localIterator.next();
        if ((!localx.GI) && ((localx.GH == null) || (localx.GH.length == 0)) && (localx.GJ != null) && (!localx.GJ.isEmpty())) {}
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label123;
          }
          ((List)localObject1).add(localx);
          break;
        }
        label123:
        ((List)localObject2).add(localx);
      }
    }
    if (((List)localObject1).isEmpty())
    {
      localObject1 = null;
      if (!((List)localObject2).isEmpty()) {
        break label217;
      }
    }
    label217:
    for (localObject2 = null;; localObject2 = (x[])((List)localObject2).toArray(new x[((List)localObject2).size()]))
    {
      return new s.a(this.Fl, this.Fm, this.Fn, this.mExtras, (x[])localObject2, (x[])localObject1, this.Fi, this.Fk, this.Fj);
      localObject1 = (x[])((List)localObject1).toArray(new x[((List)localObject1).size()]);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.v4.app.s.a.a
 * JD-Core Version:    0.7.0.1
 */