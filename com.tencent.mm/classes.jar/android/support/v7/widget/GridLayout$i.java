package android.support.v7.widget;

public class GridLayout$i
{
  static final i afC = ;
  final GridLayout.f aeC;
  final boolean afD;
  final GridLayout.a afE;
  final float weight;
  
  GridLayout$i(boolean paramBoolean, int paramInt1, int paramInt2, GridLayout.a parama, float paramFloat)
  {
    this(paramBoolean, new GridLayout.f(paramInt1, paramInt1 + paramInt2), parama, paramFloat);
  }
  
  private GridLayout$i(boolean paramBoolean, GridLayout.f paramf, GridLayout.a parama, float paramFloat)
  {
    this.afD = paramBoolean;
    this.aeC = paramf;
    this.afE = parama;
    this.weight = paramFloat;
  }
  
  final i a(GridLayout.f paramf)
  {
    return new i(this.afD, paramf, this.afE, this.weight);
  }
  
  public final GridLayout.a ah(boolean paramBoolean)
  {
    if (this.afE != GridLayout.aen) {
      return this.afE;
    }
    if (this.weight == 0.0F)
    {
      if (paramBoolean) {
        return GridLayout.aes;
      }
      return GridLayout.aex;
    }
    return GridLayout.aey;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (i)paramObject;
      if (!this.afE.equals(paramObject.afE)) {
        return false;
      }
    } while (this.aeC.equals(paramObject.aeC));
    return false;
  }
  
  public int hashCode()
  {
    return this.aeC.hashCode() * 31 + this.afE.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.v7.widget.GridLayout.i
 * JD-Core Version:    0.7.0.1
 */