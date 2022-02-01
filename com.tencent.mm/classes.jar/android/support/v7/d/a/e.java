package android.support.v7.d.a;

import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.util.StateSet;

class e
  extends b
{
  private a acR;
  private boolean xi;
  
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
      this.acR = ((a)paramb);
    }
  }
  
  public void applyTheme(Resources.Theme paramTheme)
  {
    super.applyTheme(paramTheme);
    onStateChange(getState());
  }
  
  a hi()
  {
    return new a(this.acR, this, null);
  }
  
  public boolean isStateful()
  {
    return true;
  }
  
  public Drawable mutate()
  {
    if ((!this.xi) && (super.mutate() == this))
    {
      this.acR.hk();
      this.xi = true;
    }
    return this;
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    boolean bool = super.onStateChange(paramArrayOfInt);
    int j = this.acR.h(paramArrayOfInt);
    int i = j;
    if (j < 0) {
      i = this.acR.h(StateSet.WILD_CARD);
    }
    return (selectDrawable(i)) || (bool);
  }
  
  static class a
    extends b.b
  {
    int[][] acS;
    
    a(a parama, e parame, Resources paramResources)
    {
      super(parame, paramResources);
      if (parama != null)
      {
        this.acS = parama.acS;
        return;
      }
      this.acS = new int[this.acl.length][];
    }
    
    public final void growArray(int paramInt1, int paramInt2)
    {
      super.growArray(paramInt1, paramInt2);
      int[][] arrayOfInt = new int[paramInt2][];
      System.arraycopy(this.acS, 0, arrayOfInt, 0, paramInt1);
      this.acS = arrayOfInt;
    }
    
    final int h(int[] paramArrayOfInt)
    {
      int[][] arrayOfInt = this.acS;
      int j = this.acm;
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
    
    void hk()
    {
      int[][] arrayOfInt1 = new int[this.acS.length][];
      int i = this.acS.length - 1;
      if (i >= 0)
      {
        if (this.acS[i] != null) {}
        for (int[] arrayOfInt = (int[])this.acS[i].clone();; arrayOfInt = null)
        {
          arrayOfInt1[i] = arrayOfInt;
          i -= 1;
          break;
        }
      }
      this.acS = arrayOfInt1;
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