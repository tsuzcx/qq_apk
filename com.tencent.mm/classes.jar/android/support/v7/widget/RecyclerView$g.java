package android.support.v7.widget;

import android.view.View;

final class RecyclerView$g
  implements RecyclerView.f.b
{
  RecyclerView$g(RecyclerView paramRecyclerView) {}
  
  public final void n(RecyclerView.v paramv)
  {
    boolean bool = true;
    paramv.ap(true);
    if ((paramv.akA != null) && (paramv.akB == null)) {
      paramv.akA = null;
    }
    paramv.akB = null;
    RecyclerView localRecyclerView;
    Object localObject;
    s locals;
    int i;
    if (!RecyclerView.v.z(paramv))
    {
      localRecyclerView = this.aja;
      localObject = paramv.aku;
      localRecyclerView.iP();
      locals = localRecyclerView.ahR;
      i = locals.abS.indexOfChild((View)localObject);
      if (i != -1) {
        break label155;
      }
      locals.aZ((View)localObject);
      i = 1;
      if (i != 0)
      {
        localObject = RecyclerView.bp((View)localObject);
        localRecyclerView.ahO.t((RecyclerView.v)localObject);
        localRecyclerView.ahO.s((RecyclerView.v)localObject);
      }
      if (i != 0) {
        break label206;
      }
    }
    for (;;)
    {
      localRecyclerView.al(bool);
      if ((i == 0) && (paramv.jW())) {
        this.aja.removeDetachedView(paramv.aku, false);
      }
      return;
      label155:
      if (locals.abT.get(i))
      {
        locals.abT.bu(i);
        locals.aZ((View)localObject);
        locals.abS.removeViewAt(i);
        i = 1;
        break;
      }
      i = 0;
      break;
      label206:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.v7.widget.RecyclerView.g
 * JD-Core Version:    0.7.0.1
 */