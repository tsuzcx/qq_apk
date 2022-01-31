package android.support.v7.widget;

final class RecyclerView$4
  implements be.b
{
  RecyclerView$4(RecyclerView paramRecyclerView) {}
  
  public final void a(RecyclerView.v paramv, RecyclerView.f.c paramc1, RecyclerView.f.c paramc2)
  {
    this.agK.afy.p(paramv);
    RecyclerView localRecyclerView = this.agK;
    localRecyclerView.f(paramv);
    paramv.ag(false);
    if (localRecyclerView.agf.d(paramv, paramc1, paramc2)) {
      localRecyclerView.hC();
    }
  }
  
  public final void b(RecyclerView.v paramv, RecyclerView.f.c paramc1, RecyclerView.f.c paramc2)
  {
    RecyclerView localRecyclerView = this.agK;
    paramv.ag(false);
    if (localRecyclerView.agf.e(paramv, paramc1, paramc2)) {
      localRecyclerView.hC();
    }
  }
  
  public final void c(RecyclerView.v paramv, RecyclerView.f.c paramc1, RecyclerView.f.c paramc2)
  {
    paramv.ag(false);
    if (this.agK.afW) {
      if (this.agK.agf.a(paramv, paramv, paramc1, paramc2)) {
        this.agK.hC();
      }
    }
    while (!this.agK.agf.f(paramv, paramc1, paramc2)) {
      return;
    }
    this.agK.hC();
  }
  
  public final void j(RecyclerView.v paramv)
  {
    this.agK.afG.a(paramv.aie, this.agK.afy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v7.widget.RecyclerView.4
 * JD-Core Version:    0.7.0.1
 */