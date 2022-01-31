package android.support.constraint.solver.widgets;

public class Rectangle
{
  public int height;
  public int width;
  public int x;
  public int y;
  
  public boolean contains(int paramInt1, int paramInt2)
  {
    return (paramInt1 >= this.x) && (paramInt1 < this.x + this.width) && (paramInt2 >= this.y) && (paramInt2 < this.y + this.height);
  }
  
  public int getCenterX()
  {
    return (this.x + this.width) / 2;
  }
  
  public int getCenterY()
  {
    return (this.y + this.height) / 2;
  }
  
  void grow(int paramInt1, int paramInt2)
  {
    this.x -= paramInt1;
    this.y -= paramInt2;
    this.width += paramInt1 * 2;
    this.height += paramInt2 * 2;
  }
  
  boolean intersects(Rectangle paramRectangle)
  {
    return (this.x >= paramRectangle.x) && (this.x < paramRectangle.x + paramRectangle.width) && (this.y >= paramRectangle.y) && (this.y < paramRectangle.y + paramRectangle.height);
  }
  
  public void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.x = paramInt1;
    this.y = paramInt2;
    this.width = paramInt3;
    this.height = paramInt4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.constraint.solver.widgets.Rectangle
 * JD-Core Version:    0.7.0.1
 */