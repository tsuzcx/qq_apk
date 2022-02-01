package androidx.constraintlayout.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class p
{
  int biL;
  int biM;
  ArrayList<a> bkB;
  int mHeight;
  int mWidth;
  
  public p(f paramf)
  {
    AppMethodBeat.i(194061);
    this.bkB = new ArrayList();
    this.biL = paramf.getX();
    this.biM = paramf.getY();
    this.mWidth = paramf.getWidth();
    this.mHeight = paramf.getHeight();
    paramf = paramf.CS();
    int j = paramf.size();
    int i = 0;
    while (i < j)
    {
      e locale = (e)paramf.get(i);
      this.bkB.add(new a(locale));
      i += 1;
    }
    AppMethodBeat.o(194061);
  }
  
  static final class a
  {
    e bhD;
    int bhE;
    e.b bkC;
    int bkD;
    e bkj;
    
    public a(e parame)
    {
      AppMethodBeat.i(194081);
      this.bkj = parame;
      this.bhD = parame.bhD;
      this.bhE = parame.CE();
      this.bkC = parame.bhG;
      this.bkD = parame.bhI;
      AppMethodBeat.o(194081);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     androidx.constraintlayout.a.a.p
 * JD-Core Version:    0.7.0.1
 */