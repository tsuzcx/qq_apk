package androidx.compose.ui.platform;

import android.graphics.Rect;
import androidx.compose.ui.d.g;
import androidx.compose.ui.k.o;
import androidx.compose.ui.m.d;
import androidx.compose.ui.m.f.b;
import androidx.compose.ui.m.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.h.a;
import kotlin.k.k;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/platform/AccessibilityIterators$PageTextSegmentIterator;", "Landroidx/compose/ui/platform/AccessibilityIterators$AbstractTextSegmentIterator;", "()V", "layoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "node", "Landroidx/compose/ui/semantics/SemanticsNode;", "tempRect", "Landroid/graphics/Rect;", "following", "", "current", "", "getLineEdgeIndex", "lineNumber", "direction", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "initialize", "", "text", "", "preceding", "Companion", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$d
  extends a.a
{
  public static final int Ue;
  private static final b aQF;
  private static final b aQG;
  public static final a.d.a aQH;
  private static d aQK;
  private o aQI;
  private Rect aQJ;
  private q ahz;
  
  static
  {
    AppMethodBeat.i(206567);
    aQH = new a.d.a((byte)0);
    Ue = 8;
    aQF = b.bee;
    aQG = b.bed;
    AppMethodBeat.o(206567);
  }
  
  private a$d()
  {
    AppMethodBeat.i(206545);
    this.aQJ = new Rect();
    AppMethodBeat.o(206545);
  }
  
  private final int a(int paramInt, b paramb)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(206553);
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
        AppMethodBeat.o(206553);
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
      AppMethodBeat.o(206553);
      return paramInt - 1;
    }
  }
  
  public final void a(String paramString, q paramq, o paramo)
  {
    AppMethodBeat.i(206574);
    s.u(paramString, "text");
    s.u(paramq, "layoutResult");
    s.u(paramo, "node");
    setText(paramString);
    this.ahz = paramq;
    this.aQI = paramo;
    AppMethodBeat.o(206574);
  }
  
  public final int[] cS(int paramInt)
  {
    Object localObject5 = null;
    Object localObject4 = null;
    AppMethodBeat.i(206582);
    if (getText().length() <= 0)
    {
      AppMethodBeat.o(206582);
      return null;
    }
    if (paramInt >= getText().length())
    {
      AppMethodBeat.o(206582);
      return null;
    }
    for (;;)
    {
      try
      {
        Object localObject3 = this.aQI;
        Object localObject1 = localObject3;
        if (localObject3 == null)
        {
          s.bIx("node");
          localObject1 = null;
        }
        int j = a.eH(((o)localObject1).zX().getHeight());
        int i = k.qu(0, paramInt);
        localObject3 = this.ahz;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          s.bIx("layoutResult");
          localObject1 = null;
        }
        paramInt = ((q)localObject1).di(i);
        localObject3 = this.ahz;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          s.bIx("layoutResult");
          localObject1 = null;
        }
        float f = ((q)localObject1).dj(paramInt) + j;
        localObject3 = this.ahz;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          s.bIx("layoutResult");
          localObject1 = null;
        }
        q localq = this.ahz;
        localObject3 = localq;
        if (localq == null)
        {
          s.bIx("layoutResult");
          localObject3 = null;
        }
        if (f >= ((q)localObject1).dj(((q)localObject3).baw.aYP - 1)) {
          break;
        }
        localObject1 = this.ahz;
        if (localObject1 == null)
        {
          s.bIx("layoutResult");
          localObject1 = localObject4;
          paramInt = ((q)localObject1).ag(f) - 1;
          localObject1 = af(i, a(paramInt, aQG) + 1);
          AppMethodBeat.o(206582);
          return localObject1;
        }
      }
      catch (IllegalStateException localIllegalStateException)
      {
        AppMethodBeat.o(206582);
        return null;
      }
    }
    Object localObject2 = this.ahz;
    if (localObject2 == null)
    {
      s.bIx("layoutResult");
      localObject2 = localObject5;
    }
    for (;;)
    {
      paramInt = ((q)localObject2).baw.aYP - 1;
      break;
    }
  }
  
  public final int[] cT(int paramInt)
  {
    Object localObject2 = null;
    AppMethodBeat.i(206589);
    if (getText().length() <= 0)
    {
      AppMethodBeat.o(206589);
      return null;
    }
    if (paramInt <= 0)
    {
      AppMethodBeat.o(206589);
      return null;
    }
    for (;;)
    {
      try
      {
        Object localObject3 = this.aQI;
        Object localObject1 = localObject3;
        if (localObject3 == null)
        {
          s.bIx("node");
          localObject1 = null;
        }
        int i = a.eH(((o)localObject1).zX().getHeight());
        int j = k.qv(getText().length(), paramInt);
        localObject3 = this.ahz;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          s.bIx("layoutResult");
          localObject1 = null;
        }
        int k = ((q)localObject1).di(j);
        localObject3 = this.ahz;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          s.bIx("layoutResult");
          localObject1 = null;
        }
        float f = ((q)localObject1).dj(k) - i;
        if (f <= 0.0F) {
          break label245;
        }
        localObject1 = this.ahz;
        if (localObject1 == null)
        {
          s.bIx("layoutResult");
          localObject1 = localObject2;
          paramInt = ((q)localObject1).ag(f);
          i = paramInt;
          if (j == getText().length())
          {
            i = paramInt;
            if (paramInt < k) {
              i = paramInt + 1;
            }
          }
          localObject1 = af(a(i, aQF), j);
          AppMethodBeat.o(206589);
          return localObject1;
        }
      }
      catch (IllegalStateException localIllegalStateException)
      {
        AppMethodBeat.o(206589);
        return null;
      }
      continue;
      label245:
      paramInt = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.platform.a.d
 * JD-Core Version:    0.7.0.1
 */