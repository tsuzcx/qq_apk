package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class qs
  implements fh
{
  public mk a = null;
  public qr b = null;
  public lc c = null;
  
  public qs(mk parammk, lc paramlc)
  {
    this.a = parammk;
    this.c = paramlc;
  }
  
  private void a(qp paramqp)
  {
    AppMethodBeat.i(226198);
    if ((this.b != null) && (paramqp != null))
    {
      qr localqr = this.b;
      if ((localqr.a == null) || (paramqp == null))
      {
        AppMethodBeat.o(226198);
        return;
      }
      localqr.a.add(paramqp);
    }
    AppMethodBeat.o(226198);
  }
  
  private void b(qp paramqp)
  {
    AppMethodBeat.i(226204);
    if ((this.b != null) && (paramqp != null))
    {
      qr localqr = this.b;
      if ((localqr.a == null) || (paramqp == null))
      {
        AppMethodBeat.o(226204);
        return;
      }
      localqr.a.remove(paramqp);
    }
    AppMethodBeat.o(226204);
  }
  
  private void d()
  {
    AppMethodBeat.i(226191);
    if (this.a == null)
    {
      AppMethodBeat.o(226191);
      return;
    }
    this.a.i.a(this);
    if (this.b == null) {
      this.b = new qr(this.a, this.c);
    }
    try
    {
      this.b.start();
      AppMethodBeat.o(226191);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(226191);
    }
  }
  
  private void e()
  {
    AppMethodBeat.i(226208);
    c();
    AppMethodBeat.o(226208);
  }
  
  public final void a()
  {
    AppMethodBeat.i(226215);
    if (this.b != null) {
      this.b.a();
    }
    AppMethodBeat.o(226215);
  }
  
  public final void b()
  {
    AppMethodBeat.i(226225);
    if (this.b != null)
    {
      this.b.b();
      u();
    }
    AppMethodBeat.o(226225);
  }
  
  public final void c()
  {
    AppMethodBeat.i(226230);
    if (this.a == null)
    {
      AppMethodBeat.o(226230);
      return;
    }
    this.a.i.b(this);
    if (this.b != null)
    {
      this.b.c();
      this.b = null;
    }
    AppMethodBeat.o(226230);
  }
  
  public final void u()
  {
    AppMethodBeat.i(226236);
    if (this.b != null) {
      synchronized (this.b)
      {
        this.b.notify();
        AppMethodBeat.o(226236);
        return;
      }
    }
    AppMethodBeat.o(226236);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.qs
 * JD-Core Version:    0.7.0.1
 */