package androidx.recyclerview.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
  implements s
{
  final s afO;
  int afP = 0;
  int afQ = -1;
  int afR = -1;
  Object afS = null;
  
  public e(s params)
  {
    this.afO = params;
  }
  
  public final void W(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(260784);
    if ((this.afP == 1) && (paramInt1 >= this.afQ) && (paramInt1 <= this.afQ + this.afR))
    {
      this.afR += paramInt2;
      this.afQ = Math.min(paramInt1, this.afQ);
      AppMethodBeat.o(260784);
      return;
    }
    ki();
    this.afQ = paramInt1;
    this.afR = paramInt2;
    this.afP = 1;
    AppMethodBeat.o(260784);
  }
  
  public final void ac(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(260788);
    if ((this.afP == 2) && (this.afQ >= paramInt1) && (this.afQ <= paramInt1 + paramInt2))
    {
      this.afR += paramInt2;
      this.afQ = paramInt1;
      AppMethodBeat.o(260788);
      return;
    }
    ki();
    this.afQ = paramInt1;
    this.afR = paramInt2;
    this.afP = 2;
    AppMethodBeat.o(260788);
  }
  
  public final void ad(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(260791);
    ki();
    this.afO.ad(paramInt1, paramInt2);
    AppMethodBeat.o(260791);
  }
  
  public final void c(int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(260793);
    if ((this.afP == 3) && (paramInt1 <= this.afQ + this.afR) && (paramInt1 + paramInt2 >= this.afQ) && (this.afS == paramObject))
    {
      int i = this.afQ;
      int j = this.afR;
      this.afQ = Math.min(paramInt1, this.afQ);
      this.afR = (Math.max(i + j, paramInt1 + paramInt2) - this.afQ);
      AppMethodBeat.o(260793);
      return;
    }
    ki();
    this.afQ = paramInt1;
    this.afR = paramInt2;
    this.afS = paramObject;
    this.afP = 3;
    AppMethodBeat.o(260793);
  }
  
  public final void ki()
  {
    AppMethodBeat.i(260780);
    if (this.afP == 0)
    {
      AppMethodBeat.o(260780);
      return;
    }
    switch (this.afP)
    {
    }
    for (;;)
    {
      this.afS = null;
      this.afP = 0;
      AppMethodBeat.o(260780);
      return;
      this.afO.W(this.afQ, this.afR);
      continue;
      this.afO.ac(this.afQ, this.afR);
      continue;
      this.afO.c(this.afQ, this.afR, this.afS);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.recyclerview.widget.e
 * JD-Core Version:    0.7.0.1
 */