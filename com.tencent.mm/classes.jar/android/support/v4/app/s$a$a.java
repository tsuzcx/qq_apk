package android.support.v4.app;

import android.app.PendingIntent;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class s$a$a
{
  public boolean GZ = true;
  private boolean Ha = true;
  private int Hb;
  private final int Hc;
  private final CharSequence Hd;
  private final PendingIntent He;
  private ArrayList<x> Hf;
  private final Bundle mExtras;
  
  public s$a$a(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent)
  {
    this(paramInt, paramCharSequence, paramPendingIntent, new Bundle());
  }
  
  private s$a$a(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent, Bundle paramBundle)
  {
    this.Hc = paramInt;
    this.Hd = s.c.j(paramCharSequence);
    this.He = paramPendingIntent;
    this.mExtras = paramBundle;
    this.Hf = null;
    this.GZ = true;
    this.Hb = 0;
    this.Ha = true;
  }
  
  public final s.a eo()
  {
    Object localObject1 = new ArrayList();
    Object localObject2 = new ArrayList();
    if (this.Hf != null)
    {
      Iterator localIterator = this.Hf.iterator();
      while (localIterator.hasNext())
      {
        x localx = (x)localIterator.next();
        if ((!localx.IA) && ((localx.Iz == null) || (localx.Iz.length == 0)) && (localx.IB != null) && (!localx.IB.isEmpty())) {}
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
      return new s.a(this.Hc, this.Hd, this.He, this.mExtras, (x[])localObject2, (x[])localObject1, this.GZ, this.Hb, this.Ha);
      localObject1 = (x[])((List)localObject1).toArray(new x[((List)localObject1).size()]);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.v4.app.s.a.a
 * JD-Core Version:    0.7.0.1
 */