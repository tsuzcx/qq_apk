package androidx.compose.ui.e.d;

import androidx.compose.ui.e.aj;
import androidx.compose.ui.e.ao;
import androidx.compose.ui.e.b.d;
import androidx.compose.ui.e.b.e;
import androidx.compose.ui.e.m;
import androidx.compose.ui.e.u;
import androidx.compose.ui.e.y;
import androidx.compose.ui.e.y.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/vector/GroupComponent;", "Landroidx/compose/ui/graphics/vector/VNode;", "()V", "children", "", "clipPath", "Landroidx/compose/ui/graphics/Path;", "value", "", "Landroidx/compose/ui/graphics/vector/PathNode;", "clipPathData", "getClipPathData", "()Ljava/util/List;", "setClipPathData", "(Ljava/util/List;)V", "groupMatrix", "Landroidx/compose/ui/graphics/Matrix;", "[F", "Lkotlin/Function0;", "", "invalidateListener", "getInvalidateListener$ui_release", "()Lkotlin/jvm/functions/Function0;", "setInvalidateListener$ui_release", "(Lkotlin/jvm/functions/Function0;)V", "isClipPathDirty", "", "isMatrixDirty", "", "name", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "numChildren", "", "getNumChildren", "()I", "parser", "Landroidx/compose/ui/graphics/vector/PathParser;", "", "pivotX", "getPivotX", "()F", "setPivotX", "(F)V", "pivotY", "getPivotY", "setPivotY", "rotation", "getRotation", "setRotation", "scaleX", "getScaleX", "setScaleX", "scaleY", "getScaleY", "setScaleY", "translationX", "getTranslationX", "setTranslationX", "translationY", "getTranslationY", "setTranslationY", "willClipPath", "getWillClipPath", "()Z", "insertAt", "index", "instance", "move", "from", "to", "count", "remove", "toString", "updateClipPath", "updateMatrix", "draw", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends i
{
  private float[] aAN;
  final List<i> aAO;
  List<? extends f> aAP;
  boolean aAQ;
  private ao aAR;
  private g aAS;
  a<ah> aAT;
  private float aAU;
  private float aAV;
  boolean aAW;
  float ayc;
  float ayd;
  String name;
  float rotation;
  private float scaleX;
  private float scaleY;
  
  public c()
  {
    super((byte)0);
    AppMethodBeat.i(206440);
    this.aAO = ((List)new ArrayList());
    this.aAP = n.uX();
    this.aAQ = true;
    this.name = "";
    this.scaleX = 1.0F;
    this.scaleY = 1.0F;
    this.aAW = true;
    AppMethodBeat.o(206440);
  }
  
  private final boolean uO()
  {
    AppMethodBeat.i(206443);
    if (!((Collection)this.aAP).isEmpty())
    {
      AppMethodBeat.o(206443);
      return true;
    }
    AppMethodBeat.o(206443);
    return false;
  }
  
  public final void G(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(206492);
    int i = 0;
    while (i < paramInt2)
    {
      if (paramInt1 < this.aAO.size())
      {
        ((i)this.aAO.get(paramInt1)).i(null);
        this.aAO.remove(paramInt1);
      }
      i += 1;
    }
    invalidate();
    AppMethodBeat.o(206492);
  }
  
  public final void c(e parame)
  {
    AppMethodBeat.i(206497);
    s.u(parame, "<this>");
    Object localObject1;
    label145:
    Object localObject2;
    label167:
    long l;
    int k;
    if (this.aAW)
    {
      localObject1 = this.aAN;
      if (localObject1 == null)
      {
        localObject1 = aj.tF();
        this.aAN = ((float[])localObject1);
        aj.b((float[])localObject1, this.ayc + this.aAU, this.ayd + this.aAV);
        aj.a((float[])localObject1, this.rotation);
        aj.a((float[])localObject1, this.scaleX, this.scaleY);
        aj.b((float[])localObject1, -this.aAU, -this.aAV);
        this.aAW = false;
      }
    }
    else
    {
      if (this.aAQ)
      {
        if (uO())
        {
          localObject1 = this.aAS;
          if (localObject1 != null) {
            break label364;
          }
          localObject1 = new g();
          this.aAS = ((g)localObject1);
          localObject2 = this.aAR;
          if (localObject2 != null) {
            break label372;
          }
          localObject2 = m.sQ();
          this.aAR = ((ao)localObject2);
          ((g)localObject1).R(this.aAP).b((ao)localObject2);
        }
        this.aAQ = false;
      }
      localObject1 = parame.uG();
      l = ((d)localObject1).sf();
      ((d)localObject1).uH().sz();
      localObject2 = ((d)localObject1).uI();
      Object localObject3 = this.aAN;
      if (localObject3 != null) {
        ((androidx.compose.ui.e.b.g)localObject2).k((float[])localObject3);
      }
      localObject3 = this.aAR;
      if ((uO()) && (localObject3 != null))
      {
        y.a locala = y.awI;
        ((androidx.compose.ui.e.b.g)localObject2).a((ao)localObject3, y.tu());
      }
      localObject2 = this.aAO;
      k = ((List)localObject2).size() - 1;
      if (k < 0) {}
    }
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      ((i)((List)localObject2).get(i)).c(parame);
      if (j > k)
      {
        ((d)localObject1).uH().restore();
        ((d)localObject1).ao(l);
        AppMethodBeat.o(206497);
        return;
        aj.e((float[])localObject1);
        break;
        label364:
        ((g)localObject1).clear();
        break label145;
        label372:
        ((ao)localObject2).reset();
        break label167;
      }
    }
  }
  
  public final void i(a<ah> parama)
  {
    AppMethodBeat.i(206456);
    this.aAT = parama;
    List localList = this.aAO;
    int i = 0;
    int k = localList.size() - 1;
    if (k >= 0) {}
    for (;;)
    {
      int j = i + 1;
      ((i)localList.get(i)).i(parama);
      if (j > k)
      {
        AppMethodBeat.o(206456);
        return;
      }
      i = j;
    }
  }
  
  public final void setName(String paramString)
  {
    AppMethodBeat.i(206459);
    s.u(paramString, "value");
    this.name = paramString;
    invalidate();
    AppMethodBeat.o(206459);
  }
  
  public final void setPivotX(float paramFloat)
  {
    AppMethodBeat.i(206463);
    this.aAU = paramFloat;
    this.aAW = true;
    invalidate();
    AppMethodBeat.o(206463);
  }
  
  public final void setPivotY(float paramFloat)
  {
    AppMethodBeat.i(206468);
    this.aAV = paramFloat;
    this.aAW = true;
    invalidate();
    AppMethodBeat.o(206468);
  }
  
  public final void setScaleX(float paramFloat)
  {
    AppMethodBeat.i(206481);
    this.scaleX = paramFloat;
    this.aAW = true;
    invalidate();
    AppMethodBeat.o(206481);
  }
  
  public final void setScaleY(float paramFloat)
  {
    AppMethodBeat.i(206485);
    this.scaleY = paramFloat;
    this.aAW = true;
    invalidate();
    AppMethodBeat.o(206485);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(206512);
    Object localObject = new StringBuilder("VGroup: ").append(this.name);
    List localList = this.aAO;
    int i = 0;
    int k = localList.size() - 1;
    if (k >= 0) {}
    for (;;)
    {
      int j = i + 1;
      i locali = (i)localList.get(i);
      ((StringBuilder)localObject).append("\t").append(locali.toString()).append("\n");
      if (j > k)
      {
        localObject = ((StringBuilder)localObject).toString();
        s.s(localObject, "sb.toString()");
        AppMethodBeat.o(206512);
        return localObject;
      }
      i = j;
    }
  }
  
  public final a<ah> uP()
  {
    return this.aAT;
  }
  
  public final int uQ()
  {
    AppMethodBeat.i(206504);
    int i = this.aAO.size();
    AppMethodBeat.o(206504);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.e.d.c
 * JD-Core Version:    0.7.0.1
 */