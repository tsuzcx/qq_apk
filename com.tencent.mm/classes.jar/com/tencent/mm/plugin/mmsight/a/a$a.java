package com.tencent.mm.plugin.mmsight.a;

public final class a$a
{
  int scene;
  int source = 2;
  
  public a$a(int paramInt)
  {
    if (paramInt == 1) {
      this.scene = 1;
    }
    do
    {
      return;
      if (paramInt == 2)
      {
        this.scene = 2;
        return;
      }
      if (paramInt == 512)
      {
        this.source = 1;
        this.scene = 2;
        return;
      }
    } while (paramInt != 4);
    this.scene = 4;
  }
  
  public final String toString()
  {
    return "VideoEditCountData{scene=" + this.scene + ", source=" + this.source + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.a.a.a
 * JD-Core Version:    0.7.0.1
 */