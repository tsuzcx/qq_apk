package android.support.v7.d.a;

import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.util.StateSet;

class e
  extends b
{
  private a ade;
  private boolean xp;
  
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
      this.ade = ((a)paramb);
    }
  }
  
  public void applyTheme(Resources.Theme paramTheme)
  {
    super.applyTheme(paramTheme);
    onStateChange(getState());
  }
  
  a hr()
  {
    return new a(this.ade, this, null);
  }
  
  public boolean isStateful()
  {
    return true;
  }
  
  public Drawable mutate()
  {
    if ((!this.xp) && (super.mutate() == this))
    {
      this.ade.ht();
      this.xp = true;
    }
    return this;
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    boolean bool = super.onStateChange(paramArrayOfInt);
    int j = this.ade.h(paramArrayOfInt);
    int i = j;
    if (j < 0) {
      i = this.ade.h(StateSet.WILD_CARD);
    }
    return (selectDrawable(i)) || (bool);
  }
  
  static class a
    extends b.b
  {
    int[][] adf;
    
    a(a parama, e parame, Resources paramResources)
    {
      super(parame, paramResources);
      if (parama != null)
      {
        this.adf = parama.adf;
        return;
      }
      this.adf = new int[this.acy.length][];
    }
    
    public final void growArray(int paramInt1, int paramInt2)
    {
      super.growArray(paramInt1, paramInt2);
      int[][] arrayOfInt = new int[paramInt2][];
      System.arraycopy(this.adf, 0, arrayOfInt, 0, paramInt1);
      this.adf = arrayOfInt;
    }
    
    final int h(int[] paramArrayOfInt)
    {
      int[][] arrayOfInt = this.adf;
      int j = this.acz;
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
    
    void ht()
    {
      int[][] arrayOfInt1 = new int[this.adf.length][];
      int i = this.adf.length - 1;
      if (i >= 0)
      {
        if (this.adf[i] != null) {}
        for (int[] arrayOfInt = (int[])this.adf[i].clone();; arrayOfInt = null)
        {
          arrayOfInt1[i] = arrayOfInt;
          i -= 1;
          break;
        }
      }
      this.adf = arrayOfInt1;
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