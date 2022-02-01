package androidx.compose.ui.platform;

import androidx.compose.ui.m.d;
import androidx.compose.ui.m.f.b;
import androidx.compose.ui.m.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/platform/AccessibilityIterators$LineTextSegmentIterator;", "Landroidx/compose/ui/platform/AccessibilityIterators$AbstractTextSegmentIterator;", "()V", "layoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "following", "", "current", "", "getLineEdgeIndex", "lineNumber", "direction", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "initialize", "", "text", "", "preceding", "Companion", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$c
  extends a.a
{
  public static final int Ue;
  public static final a.c.a aQD;
  private static c aQE;
  private static final b aQF;
  private static final b aQG;
  private q ahz;
  
  static
  {
    AppMethodBeat.i(206571);
    aQD = new a.c.a((byte)0);
    Ue = 8;
    aQF = b.bee;
    aQG = b.bed;
    AppMethodBeat.o(206571);
  }
  
  private final int a(int paramInt, b paramb)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(206556);
    q localq2 = this.ahz;
    q localq1 = localq2;
    if (localq2 == null)
    {
      s.bIx("layoutResult");
      localq1 = null;
    }
    int i = localq1.dk(paramInt);
    localq2 = this.ahz;
    localq1 = localq2;
    if (localq2 == null)
    {
      s.bIx("layoutResult");
      localq1 = null;
    }
    if (paramb != localq1.dh(i))
    {
      paramb = this.ahz;
      if (paramb == null)
      {
        s.bIx("layoutResult");
        paramb = localObject1;
      }
      for (;;)
      {
        paramInt = paramb.dk(paramInt);
        AppMethodBeat.o(206556);
        return paramInt;
      }
    }
    paramb = this.ahz;
    if (paramb == null)
    {
      s.bIx("layoutResult");
      paramb = localObject2;
    }
    for (;;)
    {
      paramInt = paramb.dp(paramInt);
      AppMethodBeat.o(206556);
      return paramInt - 1;
    }
  }
  
  public final void a(String paramString, q paramq)
  {
    AppMethodBeat.i(206577);
    s.u(paramString, "text");
    s.u(paramq, "layoutResult");
    setText(paramString);
    this.ahz = paramq;
    AppMethodBeat.o(206577);
  }
  
  public final int[] cS(int paramInt)
  {
    AppMethodBeat.i(206584);
    if (getText().length() <= 0)
    {
      AppMethodBeat.o(206584);
      return null;
    }
    if (paramInt >= getText().length())
    {
      AppMethodBeat.o(206584);
      return null;
    }
    q localq;
    int i;
    if (paramInt < 0)
    {
      localq = this.ahz;
      localObject = localq;
      if (localq == null)
      {
        s.bIx("layoutResult");
        localObject = null;
      }
      i = ((q)localObject).di(0);
    }
    for (;;)
    {
      localq = this.ahz;
      localObject = localq;
      if (localq == null)
      {
        s.bIx("layoutResult");
        localObject = null;
      }
      if (i < ((q)localObject).baw.aYP) {
        break;
      }
      AppMethodBeat.o(206584);
      return null;
      localq = this.ahz;
      localObject = localq;
      if (localq == null)
      {
        s.bIx("layoutResult");
        localObject = null;
      }
      int j = ((q)localObject).di(paramInt);
      i = j;
      if (a(j, aQF) != paramInt) {
        i = j + 1;
      }
    }
    Object localObject = af(a(i, aQF), a(i, aQG) + 1);
    AppMethodBeat.o(206584);
    return localObject;
  }
  
  public final int[] cT(int paramInt)
  {
    AppMethodBeat.i(206590);
    if (getText().length() <= 0)
    {
      AppMethodBeat.o(206590);
      return null;
    }
    if (paramInt <= 0)
    {
      AppMethodBeat.o(206590);
      return null;
    }
    q localq;
    int i;
    if (paramInt > getText().length())
    {
      localq = this.ahz;
      localObject = localq;
      if (localq == null)
      {
        s.bIx("layoutResult");
        localObject = null;
      }
      i = ((q)localObject).di(getText().length());
    }
    while (i < 0)
    {
      AppMethodBeat.o(206590);
      return null;
      localq = this.ahz;
      localObject = localq;
      if (localq == null)
      {
        s.bIx("layoutResult");
        localObject = null;
      }
      int j = ((q)localObject).di(paramInt);
      i = j;
      if (a(j, aQG) + 1 != paramInt) {
        i = j - 1;
      }
    }
    Object localObject = af(a(i, aQF), a(i, aQG) + 1);
    AppMethodBeat.o(206590);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.platform.a.c
 * JD-Core Version:    0.7.0.1
 */