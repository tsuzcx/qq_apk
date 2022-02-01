package com.tencent.widget.widget;

public class ItemsRange
{
  private int a;
  private int b;
  
  public ItemsRange()
  {
    this(0, 0);
  }
  
  public ItemsRange(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public int a()
  {
    return this.a;
  }
  
  public boolean a(int paramInt)
  {
    return (paramInt >= a()) && (paramInt <= b());
  }
  
  public int b()
  {
    return a() + c() - 1;
  }
  
  public int c()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.widget.widget.ItemsRange
 * JD-Core Version:    0.7.0.1
 */