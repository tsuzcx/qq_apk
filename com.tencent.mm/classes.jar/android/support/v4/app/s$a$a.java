package android.support.v4.app;

import android.app.PendingIntent;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class s$a$a
{
  public boolean Ek = true;
  private boolean El = true;
  private int Em;
  private final int En;
  private final CharSequence Eo;
  private final PendingIntent Ep;
  private ArrayList<x> Eq;
  private final Bundle mExtras;
  
  public s$a$a(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent)
  {
    this(paramInt, paramCharSequence, paramPendingIntent, new Bundle());
  }
  
  private s$a$a(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent, Bundle paramBundle)
  {
    this.En = paramInt;
    this.Eo = s.c.j(paramCharSequence);
    this.Ep = paramPendingIntent;
    this.mExtras = paramBundle;
    this.Eq = null;
    this.Ek = true;
    this.Em = 0;
    this.El = true;
  }
  
  public final s.a dM()
  {
    Object localObject1 = new ArrayList();
    Object localObject2 = new ArrayList();
    if (this.Eq != null)
    {
      Iterator localIterator = this.Eq.iterator();
      while (localIterator.hasNext())
      {
        x localx = (x)localIterator.next();
        if ((!localx.FK) && ((localx.FJ == null) || (localx.FJ.length == 0)) && (localx.FL != null) && (!localx.FL.isEmpty())) {}
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
      return new s.a(this.En, this.Eo, this.Ep, this.mExtras, (x[])localObject2, (x[])localObject1, this.Ek, this.Em, this.El);
      localObject1 = (x[])((List)localObject1).toArray(new x[((List)localObject1).size()]);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.v4.app.s.a.a
 * JD-Core Version:    0.7.0.1
 */