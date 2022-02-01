package androidx.appcompat.b.a;

import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.util.StateSet;
import com.tencent.matrix.trace.core.AppMethodBeat;

class d
  extends b
{
  private boolean iF;
  private a jI;
  
  d()
  {
    this(null, null);
  }
  
  d(byte paramByte) {}
  
  d(a parama, Resources paramResources)
  {
    AppMethodBeat.i(238888);
    a(new a(parama, this, paramResources));
    onStateChange(getState());
    AppMethodBeat.o(238888);
  }
  
  protected void a(b.b paramb)
  {
    AppMethodBeat.i(238886);
    super.a(paramb);
    if ((paramb instanceof a)) {
      this.jI = ((a)paramb);
    }
    AppMethodBeat.o(238886);
  }
  
  public void applyTheme(Resources.Theme paramTheme)
  {
    AppMethodBeat.i(238884);
    super.applyTheme(paramTheme);
    onStateChange(getState());
    AppMethodBeat.o(238884);
  }
  
  a bp()
  {
    AppMethodBeat.i(238883);
    a locala = new a(this.jI, this, null);
    AppMethodBeat.o(238883);
    return locala;
  }
  
  public boolean isStateful()
  {
    return true;
  }
  
  public Drawable mutate()
  {
    AppMethodBeat.i(238882);
    if ((!this.iF) && (super.mutate() == this))
    {
      this.jI.br();
      this.iF = true;
    }
    AppMethodBeat.o(238882);
    return this;
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(238881);
    boolean bool = super.onStateChange(paramArrayOfInt);
    int j = this.jI.c(paramArrayOfInt);
    int i = j;
    if (j < 0) {
      i = this.jI.c(StateSet.WILD_CARD);
    }
    if ((Z(i)) || (bool))
    {
      AppMethodBeat.o(238881);
      return true;
    }
    AppMethodBeat.o(238881);
    return false;
  }
  
  static class a
    extends b.b
  {
    int[][] jJ;
    
    a(a parama, d paramd, Resources paramResources)
    {
      super(paramd, paramResources);
      AppMethodBeat.i(238863);
      if (parama != null)
      {
        this.jJ = parama.jJ;
        AppMethodBeat.o(238863);
        return;
      }
      this.jJ = new int[this.jh.length][];
      AppMethodBeat.o(238863);
    }
    
    void br()
    {
      AppMethodBeat.i(238866);
      int[][] arrayOfInt1 = new int[this.jJ.length][];
      int i = this.jJ.length - 1;
      if (i >= 0)
      {
        if (this.jJ[i] != null) {}
        for (int[] arrayOfInt = (int[])this.jJ[i].clone();; arrayOfInt = null)
        {
          arrayOfInt1[i] = arrayOfInt;
          i -= 1;
          break;
        }
      }
      this.jJ = arrayOfInt1;
      AppMethodBeat.o(238866);
    }
    
    final int c(int[] paramArrayOfInt)
    {
      AppMethodBeat.i(238869);
      int[][] arrayOfInt = this.jJ;
      int j = this.ji;
      int i = 0;
      while (i < j)
      {
        if (StateSet.stateSetMatches(arrayOfInt[i], paramArrayOfInt))
        {
          AppMethodBeat.o(238869);
          return i;
        }
        i += 1;
      }
      AppMethodBeat.o(238869);
      return -1;
    }
    
    public final void h(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(238872);
      super.h(paramInt1, paramInt2);
      int[][] arrayOfInt = new int[paramInt2][];
      System.arraycopy(this.jJ, 0, arrayOfInt, 0, paramInt1);
      this.jJ = arrayOfInt;
      AppMethodBeat.o(238872);
    }
    
    public Drawable newDrawable()
    {
      AppMethodBeat.i(238870);
      d locald = new d(this, null);
      AppMethodBeat.o(238870);
      return locald;
    }
    
    public Drawable newDrawable(Resources paramResources)
    {
      AppMethodBeat.i(238871);
      paramResources = new d(this, paramResources);
      AppMethodBeat.o(238871);
      return paramResources;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.b.a.d
 * JD-Core Version:    0.7.0.1
 */