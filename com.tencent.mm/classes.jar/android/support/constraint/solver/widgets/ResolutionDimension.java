package android.support.constraint.solver.widgets;

public class ResolutionDimension
  extends ResolutionNode
{
  float value = 0.0F;
  
  public void remove()
  {
    this.state = 2;
  }
  
  public void reset()
  {
    super.reset();
    this.value = 0.0F;
  }
  
  public void resolve(int paramInt)
  {
    if ((this.state == 0) || (this.value != paramInt))
    {
      this.value = paramInt;
      if (this.state == 1) {
        invalidate();
      }
      didResolve();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.constraint.solver.widgets.ResolutionDimension
 * JD-Core Version:    0.7.0.1
 */