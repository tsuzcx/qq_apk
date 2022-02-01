package com.google.android.exoplayer2.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Comparator;

public final class r
{
  public static final Comparator<a> dkF;
  public static final Comparator<a> dkG;
  public final int dkH;
  public final ArrayList<a> dkI;
  public final a[] dkJ;
  public int dkK;
  public int dkL;
  public int dkM;
  public int dkN;
  
  static
  {
    AppMethodBeat.i(93197);
    dkF = new Comparator() {};
    dkG = new Comparator() {};
    AppMethodBeat.o(93197);
  }
  
  public r(int paramInt)
  {
    AppMethodBeat.i(210295);
    this.dkH = 2000;
    this.dkJ = new a[5];
    this.dkI = new ArrayList();
    this.dkK = -1;
    AppMethodBeat.o(210295);
  }
  
  public static final class a
  {
    public int index;
    public float value;
    public int weight;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.android.exoplayer2.i.r
 * JD-Core Version:    0.7.0.1
 */