package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class ga
{
  private ArrayList<fz> a;
  
  public ga()
  {
    AppMethodBeat.i(221793);
    this.a = new ArrayList();
    AppMethodBeat.o(221793);
  }
  
  private fz a(int paramInt)
  {
    AppMethodBeat.i(221802);
    fz localfz = (fz)this.a.get(paramInt);
    AppMethodBeat.o(221802);
    return localfz;
  }
  
  private void a(ga paramga)
  {
    AppMethodBeat.i(221807);
    this.a.addAll(paramga.a);
    AppMethodBeat.o(221807);
  }
  
  private int b()
  {
    AppMethodBeat.i(221813);
    int i = this.a.size();
    AppMethodBeat.o(221813);
    return i;
  }
  
  public final void a(fz paramfz)
  {
    AppMethodBeat.i(221820);
    this.a.add(paramfz);
    AppMethodBeat.o(221820);
  }
  
  public final float[] a()
  {
    AppMethodBeat.i(221828);
    float[] arrayOfFloat = new float[this.a.size() * 3];
    int i = 0;
    while (i < this.a.size())
    {
      int j = i * 3;
      arrayOfFloat[(j + 0)] = ((fz)this.a.get(i)).a;
      arrayOfFloat[(j + 1)] = ((fz)this.a.get(i)).b;
      arrayOfFloat[(j + 2)] = ((fz)this.a.get(i)).c;
      i += 1;
    }
    AppMethodBeat.o(221828);
    return arrayOfFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mapsdk.internal.ga
 * JD-Core Version:    0.7.0.1
 */