package androidx.compose.ui;

import androidx.compose.ui.n.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/Alignment;", "", "align", "Landroidx/compose/ui/unit/IntOffset;", "size", "Landroidx/compose/ui/unit/IntSize;", "space", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "align-KFBX0sM", "(JJLandroidx/compose/ui/unit/LayoutDirection;)J", "Companion", "Horizontal", "Vertical", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface a
{
  public static final a atD = a.atE;
  
  public abstract long a(long paramLong1, long paramLong2, n paramn);
  
  @Metadata(d1={""}, d2={"Landroidx/compose/ui/Alignment$Companion;", "", "()V", "Bottom", "Landroidx/compose/ui/Alignment$Vertical;", "getBottom$annotations", "getBottom", "()Landroidx/compose/ui/Alignment$Vertical;", "BottomCenter", "Landroidx/compose/ui/Alignment;", "getBottomCenter$annotations", "getBottomCenter", "()Landroidx/compose/ui/Alignment;", "BottomEnd", "getBottomEnd$annotations", "getBottomEnd", "BottomStart", "getBottomStart$annotations", "getBottomStart", "Center", "getCenter$annotations", "getCenter", "CenterEnd", "getCenterEnd$annotations", "getCenterEnd", "CenterHorizontally", "Landroidx/compose/ui/Alignment$Horizontal;", "getCenterHorizontally$annotations", "getCenterHorizontally", "()Landroidx/compose/ui/Alignment$Horizontal;", "CenterStart", "getCenterStart$annotations", "getCenterStart", "CenterVertically", "getCenterVertically$annotations", "getCenterVertically", "End", "getEnd$annotations", "getEnd", "Start", "getStart$annotations", "getStart", "Top", "getTop$annotations", "getTop", "TopCenter", "getTopCenter$annotations", "getTopCenter", "TopEnd", "getTopEnd$annotations", "getTopEnd", "TopStart", "getTopStart$annotations", "getTopStart", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    private static final a atF;
    private static final a atG;
    private static final a atH;
    private static final a atI;
    private static final a atJ;
    private static final a atK;
    private static final a atL;
    private static final a atM;
    private static final a atN;
    private static final a.c atO;
    private static final a.c atP;
    private static final a.c atQ;
    private static final a.b atR;
    private static final a.b atS;
    private static final a.b atT;
    
    static
    {
      AppMethodBeat.i(204388);
      atE = new a();
      atF = (a)new b(-1.0F, -1.0F);
      atG = (a)new b(0.0F, -1.0F);
      atH = (a)new b(1.0F, -1.0F);
      atI = (a)new b(-1.0F, 0.0F);
      atJ = (a)new b(0.0F, 0.0F);
      atK = (a)new b(1.0F, 0.0F);
      atL = (a)new b(-1.0F, 1.0F);
      atM = (a)new b(0.0F, 1.0F);
      atN = (a)new b(1.0F, 1.0F);
      atO = (a.c)new b.b(-1.0F);
      atP = (a.c)new b.b(0.0F);
      atQ = (a.c)new b.b(1.0F);
      atR = (a.b)new b.a(-1.0F);
      atS = (a.b)new b.a(0.0F);
      atT = (a.b)new b.a(1.0F);
      AppMethodBeat.o(204388);
    }
    
    public static a rU()
    {
      return atF;
    }
    
    public static a rV()
    {
      return atI;
    }
    
    public static a rW()
    {
      return atJ;
    }
    
    public static a rX()
    {
      return atK;
    }
    
    public static a rY()
    {
      return atL;
    }
    
    public static a rZ()
    {
      return atM;
    }
    
    public static a sa()
    {
      return atN;
    }
    
    public static a.c sb()
    {
      return atO;
    }
    
    public static a.c sc()
    {
      return atP;
    }
    
    public static a.b sd()
    {
      return atR;
    }
    
    public static a.b se()
    {
      return atS;
    }
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/ui/Alignment$Horizontal;", "", "align", "", "size", "space", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract int a(int paramInt1, int paramInt2, n paramn);
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/ui/Alignment$Vertical;", "", "align", "", "size", "space", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface c
  {
    public abstract int Y(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.a
 * JD-Core Version:    0.7.0.1
 */