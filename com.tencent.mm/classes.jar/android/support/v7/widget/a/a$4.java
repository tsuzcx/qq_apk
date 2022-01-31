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
    if ((this.aoa.acI != null) && (this.aoa.acI.isAttachedToWindow()) && (!this.aod.aos) && (this.aod.ahi.id() != -1))
    {
      Object localObject = this.aoa.acI.getItemAnimator();
      if ((localObject != null) && (((RecyclerView.f)localObject).a(null))) {
        break label140;
      }
      localObject = this.aoa;
      int j = ((a)localObject).anQ.size();
      i = 0;
      if (i >= j) {
        break label135;
      }
      if (((a.c)((a)localObject).anQ.get(i)).so) {
        break label128;
      }
    }
    label128:
    label135:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label140;
      }
      this.aoa.anN.jq();
      return;
      i += 1;
      break;
    }
    label140:
    this.aoa.acI.post(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v7.widget.a.a.4
 * JD-Core Version:    0.7.0.1
 */