package androidx.appcompat.b.a;

import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.util.StateSet;
import com.tencent.matrix.trace.core.AppMethodBeat;

class d
  extends b
{
  private boolean jA;
  private a kE;
  
  d()
  {
    this(null, null);
  }
  
  d(byte paramByte) {}
  
  d(a parama, Resources paramResources)
  {
    AppMethodBeat.i(199282);
    a(new a(parama, this, paramResources));
    onStateChange(getState());
    AppMethodBeat.o(199282);
  }
  
  protected void a(b.b paramb)
  {
    AppMethodBeat.i(199324);
    super.a(paramb);
    if ((paramb instanceof a)) {
      this.kE = ((a)paramb);
    }
    AppMethodBeat.o(199324);
  }
  
  public void applyTheme(Resources.Theme paramTheme)
  {
    AppMethodBeat.i(199319);
    super.applyTheme(paramTheme);
    onStateChange(getState());
    AppMethodBeat.o(199319);
  }
  
  a ci()
  {
    AppMethodBeat.i(199311);
    a locala = new a(this.kE, this, null);
    AppMethodBeat.o(199311);
    return locala;
  }
  
  public boolean isStateful()
  {
    return true;
  }
  
  public Drawable mutate()
  {
    AppMethodBeat.i(199302);
    if ((!this.jA) && (super.mutate() == this))
    {
      this.kE.ck();
      this.jA = true;
    }
    AppMethodBeat.o(199302);
    return this;
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(199295);
    boolean bool = super.onStateChange(paramArrayOfInt);
    int j = this.kE.f(paramArrayOfInt);
    int i = j;
    if (j < 0) {
      i = this.kE.f(StateSet.WILD_CARD);
    }
    if ((X(i)) || (bool))
    {
      AppMethodBeat.o(199295);
      return true;
    }
    AppMethodBeat.o(199295);
    return false;
  }
  
  static class a
    extends b.b
  {
    int[][] kF;
    
    a(a parama, d paramd, Resources paramResources)
    {
      super(paramd, paramResources);
      AppMethodBeat.i(199279);
      if (parama != null)
      {
        this.kF = parama.kF;
        AppMethodBeat.o(199279);
        return;
      }
      this.kF = new int[this.kc.length][];
      AppMethodBeat.o(199279);
    }
    
    void ck()
    {
      AppMethodBeat.i(199287);
      int[][] arrayOfInt1 = new int[this.kF.length][];
      int i = this.kF.length - 1;
      if (i >= 0)
      {
        if (this.kF[i] != null) {}
        for (int[] arrayOfInt = (int[])this.kF[i].clone();; arrayOfInt = null)
        {
          arrayOfInt1[i] = arrayOfInt;
          i -= 1;
          break;
        }
      }
      this.kF = arrayOfInt1;
      AppMethodBeat.o(199287);
    }
    
    final int f(int[] paramArrayOfInt)
    {
      AppMethodBeat.i(199294);
      int[][] arrayOfInt = this.kF;
      int j = this.kd;
      int i = 0;
      while (i < j)
      {
        if (StateSet.stateSetMatches(arrayOfInt[i], paramArrayOfInt))
        {
          AppMethodBeat.o(199294);
          return i;
        }
        i += 1;
      }
      AppMethodBeat.o(199294);
      return -1;
    }
    
    public final void m(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(199326);
      super.m(paramInt1, paramInt2);
      int[][] arrayOfInt = new int[paramInt2][];
      System.arraycopy(this.kF, 0, arrayOfInt, 0, paramInt1);
      this.kF = arrayOfInt;
      AppMethodBeat.o(199326);
    }
    
    public Drawable newDrawable()
    {
      AppMethodBeat.i(199307);
      d locald = new d(this, null);
      AppMethodBeat.o(199307);
      return locald;
    }
    
    public Drawable newDrawable(Resources paramResources)
    {
      AppMethodBeat.i(199318);
      paramResources = new d(this, paramResources);
      AppMethodBeat.o(199318);
      return paramResources;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.appcompat.b.a.d
 * JD-Core Version:    0.7.0.1
 */