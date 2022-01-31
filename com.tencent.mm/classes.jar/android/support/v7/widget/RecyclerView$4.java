package android.support.v7.widget;

final class RecyclerView$4
  implements bg.b
{
  RecyclerView$4(RecyclerView paramRecyclerView) {}
  
  public final void a(RecyclerView.v paramv, RecyclerView.f.c paramc1, RecyclerView.f.c paramc2)
  {
    this.aja.ahO.t(paramv);
    RecyclerView localRecyclerView = this.aja;
    localRecyclerView.f(paramv);
    paramv.ap(false);
    if (localRecyclerView.aiv.d(paramv, paramc1, paramc2)) {
      localRecyclerView.je();
    }
  }
  
  public final void b(RecyclerView.v paramv, RecyclerView.f.c paramc1, RecyclerView.f.c paramc2)
  {
    RecyclerView localRecyclerView = this.aja;
    paramv.ap(false);
    if (localRecyclerView.aiv.e(paramv, paramc1, paramc2)) {
      localRecyclerView.je();
    }
  }
  
  public final void c(RecyclerView.v paramv, RecyclerView.f.c paramc1, RecyclerView.f.c paramc2)
  {
    paramv.ap(false);
    if (this.aja.aim) {
      if (this.aja.aiv.a(paramv, paramv, paramc1, paramc2)) {
        this.aja.je();
      }
    }
    while (!this.aja.aiv.f(paramv, paramc1, paramc2)) {
      return;
    }
    this.aja.je();
  }
  
  public final void j(RecyclerView.v paramv)
  {
    this.aja.ahW.a(paramv.aku, this.aja.ahO);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v7.widget.RecyclerView.4
 * JD-Core Version:    0.7.0.1
 */