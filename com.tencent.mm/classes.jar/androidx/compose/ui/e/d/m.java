package androidx.compose.ui.e.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.a.a;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/vector/VectorGroup;", "Landroidx/compose/ui/graphics/vector/VectorNode;", "", "name", "", "rotation", "", "pivotX", "pivotY", "scaleX", "scaleY", "translationX", "translationY", "clipPathData", "", "Landroidx/compose/ui/graphics/vector/PathNode;", "children", "(Ljava/lang/String;FFFFFFFLjava/util/List;Ljava/util/List;)V", "getClipPathData", "()Ljava/util/List;", "getName", "()Ljava/lang/String;", "getPivotX", "()F", "getPivotY", "getRotation", "getScaleX", "getScaleY", "size", "", "getSize", "()I", "getTranslationX", "getTranslationY", "equals", "", "other", "", "get", "index", "hashCode", "iterator", "", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
  extends o
  implements Iterable<o>, a
{
  private final List<o> aAO;
  final List<f> aAP;
  final float aAU;
  final float aAV;
  final float ayc;
  final float ayd;
  final String name;
  final float rotation;
  final float scaleX;
  final float scaleY;
  
  public m(String paramString, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, List<? extends f> paramList, List<? extends o> paramList1)
  {
    super((byte)0);
    AppMethodBeat.i(206392);
    this.name = paramString;
    this.rotation = paramFloat1;
    this.aAU = paramFloat2;
    this.aAV = paramFloat3;
    this.scaleX = paramFloat4;
    this.scaleY = paramFloat5;
    this.ayc = paramFloat6;
    this.ayd = paramFloat7;
    this.aAP = paramList;
    this.aAO = paramList1;
    AppMethodBeat.o(206392);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(206415);
    if (this == paramObject)
    {
      AppMethodBeat.o(206415);
      return true;
    }
    if ((paramObject == null) || (!(paramObject instanceof m)))
    {
      AppMethodBeat.o(206415);
      return false;
    }
    if (!s.p(this.name, ((m)paramObject).name))
    {
      AppMethodBeat.o(206415);
      return false;
    }
    if (this.rotation == ((m)paramObject).rotation) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(206415);
      return false;
    }
    if (this.aAU == ((m)paramObject).aAU) {}
    for (i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(206415);
      return false;
    }
    if (this.aAV == ((m)paramObject).aAV) {}
    for (i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(206415);
      return false;
    }
    if (this.scaleX == ((m)paramObject).scaleX) {}
    for (i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(206415);
      return false;
    }
    if (this.scaleY == ((m)paramObject).scaleY) {}
    for (i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(206415);
      return false;
    }
    if (this.ayc == ((m)paramObject).ayc) {}
    for (i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(206415);
      return false;
    }
    if (this.ayd == ((m)paramObject).ayd) {}
    for (i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(206415);
      return false;
    }
    if (!s.p(this.aAP, ((m)paramObject).aAP))
    {
      AppMethodBeat.o(206415);
      return false;
    }
    if (!s.p(this.aAO, ((m)paramObject).aAO))
    {
      AppMethodBeat.o(206415);
      return false;
    }
    AppMethodBeat.o(206415);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(206424);
    int i = this.name.hashCode();
    int j = Float.floatToIntBits(this.rotation);
    int k = Float.floatToIntBits(this.aAU);
    int m = Float.floatToIntBits(this.aAV);
    int n = Float.floatToIntBits(this.scaleX);
    int i1 = Float.floatToIntBits(this.scaleY);
    int i2 = Float.floatToIntBits(this.ayc);
    int i3 = Float.floatToIntBits(this.ayd);
    int i4 = this.aAP.hashCode();
    int i5 = this.aAO.hashCode();
    AppMethodBeat.o(206424);
    return ((((((((i * 31 + j) * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i5;
  }
  
  public final Iterator<o> iterator()
  {
    AppMethodBeat.i(206407);
    Iterator localIterator = (Iterator)new a(this);
    AppMethodBeat.o(206407);
    return localIterator;
  }
  
  @Metadata(d1={""}, d2={"androidx/compose/ui/graphics/vector/VectorGroup$iterator$1", "", "Landroidx/compose/ui/graphics/vector/VectorNode;", "it", "getIt", "()Ljava/util/Iterator;", "hasNext", "", "next", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Iterator<o>, a
  {
    private final Iterator<o> aDi;
    
    a(m paramm)
    {
      AppMethodBeat.i(206370);
      this.aDi = m.a(this.aDj).iterator();
      AppMethodBeat.o(206370);
    }
    
    public final boolean hasNext()
    {
      AppMethodBeat.i(206371);
      boolean bool = this.aDi.hasNext();
      AppMethodBeat.o(206371);
      return bool;
    }
    
    public final void remove()
    {
      AppMethodBeat.i(206372);
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
      AppMethodBeat.o(206372);
      throw localUnsupportedOperationException;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.e.d.m
 * JD-Core Version:    0.7.0.1
 */