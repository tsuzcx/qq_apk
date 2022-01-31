package com.tencent.mm.plugin.mmsight.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a$b
{
  public boolean eUJ;
  public int ect;
  public int oKo;
  public int oKp;
  public int oKq;
  public int oKr;
  public boolean oKs;
  public int oKt;
  public int oKu;
  public int scene;
  public int textColor;
  
  public a$b(int paramInt)
  {
    AppMethodBeat.i(54955);
    if (paramInt == 1)
    {
      this.scene = 2;
      AppMethodBeat.o(54955);
      return;
    }
    if (paramInt == 2)
    {
      this.scene = 4;
      AppMethodBeat.o(54955);
      return;
    }
    if (paramInt == 512)
    {
      this.scene = 3;
      AppMethodBeat.o(54955);
      return;
    }
    if (paramInt == 4) {
      this.scene = 8;
    }
    AppMethodBeat.o(54955);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(54956);
    String str = "VideoEditDetailData{scene=" + this.scene + ", isCancel=" + this.eUJ + ", rawDuration=" + this.oKo + ", cropDuration=" + this.oKp + ", emojiItemCount=" + this.oKq + ", textItemCount=" + this.oKr + ", isCrop=" + this.oKs + ", undoCount=" + this.ect + ", doodleCount=" + this.oKt + ", penColors=" + this.oKu + ", textColor=" + this.textColor + '}';
    AppMethodBeat.o(54956);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.a.a.b
 * JD-Core Version:    0.7.0.1
 */