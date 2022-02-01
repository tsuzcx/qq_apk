package androidx.recyclerview.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  implements q
{
  final q bUu;
  int bUv = 0;
  int bUw = -1;
  int bUx = -1;
  Object bUy = null;
  
  public d(q paramq)
  {
    this.bUu = paramq;
  }
  
  public final void IT()
  {
    AppMethodBeat.i(194707);
    if (this.bUv == 0)
    {
      AppMethodBeat.o(194707);
      return;
    }
    switch (this.bUv)
    {
    }
    for (;;)
    {
      this.bUy = null;
      this.bUv = 0;
      AppMethodBeat.o(194707);
      return;
      this.bUu.aR(this.bUw, this.bUx);
      continue;
      this.bUu.aS(this.bUw, this.bUx);
      continue;
      this.bUu.c(this.bUw, this.bUx, this.bUy);
    }
  }
  
  public final void aR(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194715);
    if ((this.bUv == 1) && (paramInt1 >= this.bUw) && (paramInt1 <= this.bUw + this.bUx))
    {
      this.bUx += paramInt2;
      this.bUw = Math.min(paramInt1, this.bUw);
      AppMethodBeat.o(194715);
      return;
    }
    IT();
    this.bUw = paramInt1;
    this.bUx = paramInt2;
    this.bUv = 1;
    AppMethodBeat.o(194715);
  }
  
  public final void aS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194725);
    if ((this.bUv == 2) && (this.bUw >= paramInt1) && (this.bUw <= paramInt1 + paramInt2))
    {
      this.bUx += paramInt2;
      this.bUw = paramInt1;
      AppMethodBeat.o(194725);
      return;
    }
    IT();
    this.bUw = paramInt1;
    this.bUx = paramInt2;
    this.bUv = 2;
    AppMethodBeat.o(194725);
  }
  
  public final void aW(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194733);
    IT();
    this.bUu.aW(paramInt1, paramInt2);
    AppMethodBeat.o(194733);
  }
  
  public final void c(int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(194744);
    if ((this.bUv == 3) && (paramInt1 <= this.bUw + this.bUx) && (paramInt1 + paramInt2 >= this.bUw) && (this.bUy == paramObject))
    {
      int i = this.bUw;
      int j = this.bUx;
      this.bUw = Math.min(paramInt1, this.bUw);
      this.bUx = (Math.max(i + j, paramInt1 + paramInt2) - this.bUw);
      AppMethodBeat.o(194744);
      return;
    }
    IT();
    this.bUw = paramInt1;
    this.bUx = paramInt2;
    this.bUy = paramObject;
    this.bUv = 3;
    AppMethodBeat.o(194744);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.recyclerview.widget.d
 * JD-Core Version:    0.7.0.1
 */