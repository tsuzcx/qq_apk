package com.tencent.map.lib.gl.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class f
{
  private ArrayList<e> a;
  
  public f()
  {
    AppMethodBeat.i(98158);
    this.a = new ArrayList();
    AppMethodBeat.o(98158);
  }
  
  public e a(int paramInt)
  {
    AppMethodBeat.i(98159);
    e locale = (e)this.a.get(paramInt);
    AppMethodBeat.o(98159);
    return locale;
  }
  
  public void a(e parame)
  {
    AppMethodBeat.i(98160);
    this.a.add(parame);
    AppMethodBeat.o(98160);
  }
  
  public float[] a()
  {
    AppMethodBeat.i(98161);
    float[] arrayOfFloat = new float[this.a.size() * 3];
    int i = 0;
    while (i < this.a.size())
    {
      int j = i * 3;
      arrayOfFloat[(j + 0)] = ((e)this.a.get(i)).a;
      arrayOfFloat[(j + 1)] = ((e)this.a.get(i)).b;
      arrayOfFloat[(j + 2)] = ((e)this.a.get(i)).c;
      i += 1;
    }
    AppMethodBeat.o(98161);
    return arrayOfFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.map.lib.gl.model.f
 * JD-Core Version:    0.7.0.1
 */