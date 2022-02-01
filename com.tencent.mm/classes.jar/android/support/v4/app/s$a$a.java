package android.support.v4.app;

import android.app.PendingIntent;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class s$a$a
{
  public boolean Hj = true;
  private boolean Hk = true;
  private int Hl;
  private final int Hm;
  private final CharSequence Hn;
  private final PendingIntent Ho;
  private ArrayList<x> Hp;
  private final Bundle mExtras;
  
  public s$a$a(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent)
  {
    this(paramInt, paramCharSequence, paramPendingIntent, new Bundle());
  }
  
  private s$a$a(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent, Bundle paramBundle)
  {
    this.Hm = paramInt;
    this.Hn = s.c.j(paramCharSequence);
    this.Ho = paramPendingIntent;
    this.mExtras = paramBundle;
    this.Hp = null;
    this.Hj = true;
    this.Hl = 0;
    this.Hk = true;
  }
  
  public final s.a es()
  {
    Object localObject1 = new ArrayList();
    Object localObject2 = new ArrayList();
    if (this.Hp != null)
    {
      Iterator localIterator = this.Hp.iterator();
      while (localIterator.hasNext())
      {
        x localx = (x)localIterator.next();
        if ((!localx.IL) && ((localx.IK == null) || (localx.IK.length == 0)) && (localx.IM != null) && (!localx.IM.isEmpty())) {}
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
      return new s.a(this.Hm, this.Hn, this.Ho, this.mExtras, (x[])localObject2, (x[])localObject1, this.Hj, this.Hl, this.Hk);
      localObject1 = (x[])((List)localObject1).toArray(new x[((List)localObject1).size()]);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.v4.app.s.a.a
 * JD-Core Version:    0.7.0.1
 */