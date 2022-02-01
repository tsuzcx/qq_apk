package androidx.constraintlayout.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class p
{
  int CD;
  int CE;
  ArrayList<a> Et;
  int mHeight;
  int mWidth;
  
  public p(f paramf)
  {
    AppMethodBeat.i(229260);
    this.Et = new ArrayList();
    this.CD = paramf.getX();
    this.CE = paramf.getY();
    this.mWidth = paramf.getWidth();
    this.mHeight = paramf.getHeight();
    paramf = paramf.fJ();
    int j = paramf.size();
    int i = 0;
    while (i < j)
    {
      e locale = (e)paramf.get(i);
      this.Et.add(new a(locale));
      i += 1;
    }
    AppMethodBeat.o(229260);
  }
  
  static final class a
  {
    e Bv;
    int Bw;
    e Eb;
    e.b Eu;
    int Ev;
    
    public a(e parame)
    {
      AppMethodBeat.i(229789);
      this.Eb = parame;
      this.Bv = parame.Bv;
      this.Bw = parame.fv();
      this.Eu = parame.By;
      this.Ev = parame.BA;
      AppMethodBeat.o(229789);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.constraintlayout.a.a.p
 * JD-Core Version:    0.7.0.1
 */