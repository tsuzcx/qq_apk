package android.support.v4.a.a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

class h
  extends g
{
  h(Drawable paramDrawable)
  {
    super(paramDrawable);
  }
  
  h(g.a parama, Resources paramResources)
  {
    super(parama, paramResources);
  }
  
  g.a cs()
  {
    return new a(this.Az);
  }
  
  public boolean isAutoMirrored()
  {
    return this.mDrawable.isAutoMirrored();
  }
  
  public void setAutoMirrored(boolean paramBoolean)
  {
    this.mDrawable.setAutoMirrored(paramBoolean);
  }
  
  private static final class a
    extends g.a
  {
    a(g.a parama)
    {
      super();
    }
    
    public final Drawable newDrawable(Resources paramResources)
    {
      return new h(this, paramResources);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.a.a.h
 * JD-Core Version:    0.7.0.1
 */