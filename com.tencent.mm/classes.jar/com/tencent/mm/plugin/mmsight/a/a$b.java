package com.tencent.mm.plugin.mmsight.a;

public final class a$b
{
  public int dkZ;
  public boolean edT;
  public int mli;
  public int mlj;
  public int mlk;
  public int mll;
  public boolean mlm;
  public int mln;
  public int mlo;
  public int scene;
  public int textColor;
  
  public a$b(int paramInt)
  {
    if (paramInt == 1) {
      this.scene = 2;
    }
    do
    {
      return;
      if (paramInt == 2)
      {
        this.scene = 4;
        return;
      }
      if (paramInt == 512)
      {
        this.scene = 3;
        return;
      }
    } while (paramInt != 4);
    this.scene = 8;
  }
  
  public final String toString()
  {
    return "VideoEditDetailData{scene=" + this.scene + ", isCancel=" + this.edT + ", rawDuration=" + this.mli + ", cropDuration=" + this.mlj + ", emojiItemCount=" + this.mlk + ", textItemCount=" + this.mll + ", isCrop=" + this.mlm + ", undoCount=" + this.dkZ + ", doodleCount=" + this.mln + ", penColors=" + this.mlo + ", textColor=" + this.textColor + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.a.a.b
 * JD-Core Version:    0.7.0.1
 */