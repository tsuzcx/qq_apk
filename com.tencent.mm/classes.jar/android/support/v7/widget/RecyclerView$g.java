package android.support.v7.widget;

import android.view.View;

final class RecyclerView$g
  implements RecyclerView.f.b
{
  RecyclerView$g(RecyclerView paramRecyclerView) {}
  
  public final void m(RecyclerView.v paramv)
  {
    boolean bool = true;
    paramv.ag(true);
    if ((paramv.aik != null) && (paramv.ail == null)) {
      paramv.aik = null;
    }
    paramv.ail = null;
    RecyclerView localRecyclerView;
    Object localObject;
    u localu;
    int i;
    if (!RecyclerView.v.u(paramv))
    {
      localRecyclerView = this.agK;
      localObject = paramv.aie;
      localRecyclerView.ho();
      localu = localRecyclerView.afB;
      i = localu.abh.indexOfChild((View)localObject);
      if (i != -1) {
        break label155;
      }
      localu.aR((View)localObject);
      i = 1;
      if (i != 0)
      {
        localObject = RecyclerView.bf((View)localObject);
        localRecyclerView.afy.p((RecyclerView.v)localObject);
        localRecyclerView.afy.o((RecyclerView.v)localObject);
      }
      if (i != 0) {
        break label206;
      }
    }
    for (;;)
    {
      localRecyclerView.ac(bool);
      if ((i == 0) && (paramv.il())) {
        this.agK.removeDetachedView(paramv.aie, false);
      }
      return;
      label155:
      if (localu.abi.get(i))
      {
        localu.abi.bu(i);
        localu.aR((View)localObject);
        localu.abh.removeViewAt(i);
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