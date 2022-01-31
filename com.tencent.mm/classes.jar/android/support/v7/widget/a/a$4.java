package android.support.v7.widget.a;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.f;
import android.support.v7.widget.RecyclerView.v;
import java.util.List;

final class a$4
  implements Runnable
{
  a$4(a parama, a.c paramc, int paramInt) {}
  
  public final void run()
  {
    if ((this.aqr.adt != null) && (this.aqr.adt.isAttachedToWindow()) && (!this.aqu.aqH) && (this.aqu.ajy.jN() != -1))
    {
      Object localObject = this.aqr.adt.getItemAnimator();
      if ((localObject == null) || (!((RecyclerView.f)localObject).a(null)))
      {
        localObject = this.aqr;
        int j = ((a)localObject).aqh.size();
        i = 0;
        if (i >= j) {
          break label137;
        }
        if (((a.c)((a)localObject).aqh.get(i)).tn) {
          break label130;
        }
      }
    }
    label130:
    label137:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.aqr.adt.post(this);
      }
      return;
      i += 1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v7.widget.a.a.4
 * JD-Core Version:    0.7.0.1
 */