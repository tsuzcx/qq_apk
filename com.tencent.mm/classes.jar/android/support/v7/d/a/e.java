package android.support.v7.d.a;

import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.util.StateSet;

class e
  extends b
{
  private a abc;
  private boolean vp;
  
  e()
  {
    this(null, null);
  }
  
  e(byte paramByte) {}
  
  e(a parama, Resources paramResources)
  {
    a(new a(parama, this, paramResources));
    onStateChange(getState());
  }
  
  protected void a(b.b paramb)
  {
    super.a(paramb);
    if ((paramb instanceof a)) {
      this.abc = ((a)paramb);
    }
  }
  
  public void applyTheme(Resources.Theme paramTheme)
  {
    super.applyTheme(paramTheme);
    onStateChange(getState());
  }
  
  a gR()
  {
    return new a(this.abc, this, null);
  }
  
  public boolean isStateful()
  {
    return true;
  }
  
  public Drawable mutate()
  {
    if ((!this.vp) && (super.mutate() == this))
    {
      this.abc.gT();
      this.vp = true;
    }
    return this;
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    boolean bool = super.onStateChange(paramArrayOfInt);
    int j = this.abc.h(paramArrayOfInt);
    int i = j;
    if (j < 0) {
      i = this.abc.h(StateSet.WILD_CARD);
    }
    return (selectDrawable(i)) || (bool);
  }
  
  static class a
    extends b.b
  {
    int[][] abd;
    
    a(a parama, e parame, Resources paramResources)
    {
      super(parame, paramResources);
      if (parama != null)
      {
        this.abd = parama.abd;
        return;
      }
      this.abd = new int[this.aav.length][];
    }
    
    void gT()
    {
      int[][] arrayOfInt1 = new int[this.abd.length][];
      int i = this.abd.length - 1;
      if (i >= 0)
      {
        if (this.abd[i] != null) {}
        for (int[] arrayOfInt = (int[])this.abd[i].clone();; arrayOfInt = null)
        {
          arrayOfInt1[i] = arrayOfInt;
          i -= 1;
          break;
        }
      }
      this.abd = arrayOfInt1;
    }
    
    public final void growArray(int paramInt1, int paramInt2)
    {
      super.growArray(paramInt1, paramInt2);
      int[][] arrayOfInt = new int[paramInt2][];
      System.arraycopy(this.abd, 0, arrayOfInt, 0, paramInt1);
      this.abd = arrayOfInt;
    }
    
    final int h(int[] paramArrayOfInt)
    {
      int[][] arrayOfInt = this.abd;
      int j = this.aaw;
      int i = 0;
      while (i < j)
      {
        if (StateSet.stateSetMatches(arrayOfInt[i], paramArrayOfInt)) {
          return i;
        }
        i += 1;
      }
      return -1;
    }
    
    public Drawable newDrawable()
    {
      return new e(this, null);
    }
    
    public Drawable newDrawable(Resources paramResources)
    {
      return new e(this, paramResources);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.d.a.e
 * JD-Core Version:    0.7.0.1
 */