package androidx.gridlayout.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class GridLayout$b
{
  public final GridLayout.f Yk;
  public final GridLayout.g Yl;
  public boolean Ym = true;
  
  public GridLayout$b(GridLayout.f paramf, GridLayout.g paramg)
  {
    this.Yk = paramf;
    this.Yl = paramg;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(255437);
    StringBuilder localStringBuilder = new StringBuilder().append(this.Yk).append(" ");
    if (!this.Ym) {}
    for (String str = "+>";; str = "->")
    {
      str = str + " " + this.Yl;
      AppMethodBeat.o(255437);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.gridlayout.widget.GridLayout.b
 * JD-Core Version:    0.7.0.1
 */