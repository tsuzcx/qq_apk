package androidx.compose.ui.e.d.a;

import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Shader;
import android.util.AttributeSet;
import androidx.compose.ui.e.ab;
import androidx.compose.ui.e.aq;
import androidx.compose.ui.e.ba;
import androidx.compose.ui.e.bb;
import androidx.compose.ui.e.bc;
import androidx.compose.ui.e.d.d.a;
import androidx.compose.ui.e.d.d.a.a;
import androidx.compose.ui.e.d.n;
import androidx.compose.ui.e.t;
import androidx.core.content.a.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@Metadata(d1={""}, d2={"FILL_TYPE_WINDING", "", "LINECAP_BUTT", "LINECAP_ROUND", "LINECAP_SQUARE", "LINEJOIN_BEVEL", "LINEJOIN_MITER", "LINEJOIN_ROUND", "SHAPE_CLIP_PATH", "", "SHAPE_GROUP", "SHAPE_PATH", "getStrokeLineCap", "Landroidx/compose/ui/graphics/StrokeCap;", "id", "defValue", "getStrokeLineCap-CSYIeUk", "(II)I", "getStrokeLineJoin", "Landroidx/compose/ui/graphics/StrokeJoin;", "getStrokeLineJoin-kLtJ_vA", "obtainBrushFromComplexColor", "Landroidx/compose/ui/graphics/Brush;", "complexColor", "Landroidx/core/content/res/ComplexColorCompat;", "createVectorImageBuilder", "Landroidx/compose/ui/graphics/vector/ImageVector$Builder;", "Lorg/xmlpull/v1/XmlPullParser;", "res", "Landroid/content/res/Resources;", "theme", "Landroid/content/res/Resources$Theme;", "attrs", "Landroid/util/AttributeSet;", "isAtEnd", "", "parseClipPath", "", "builder", "parseCurrentVectorNode", "nestedGroups", "parseGroup", "parsePath", "seekToStartTag", "ui_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class b
{
  private static final int aFi = 0;
  
  public static final int a(XmlPullParser paramXmlPullParser, Resources paramResources, AttributeSet paramAttributeSet, Resources.Theme paramTheme, d.a parama, int paramInt)
  {
    AppMethodBeat.i(206390);
    kotlin.g.b.s.u(paramXmlPullParser, "<this>");
    kotlin.g.b.s.u(paramResources, "res");
    kotlin.g.b.s.u(paramAttributeSet, "attrs");
    kotlin.g.b.s.u(parama, "builder");
    switch (paramXmlPullParser.getEventType())
    {
    }
    label680:
    label740:
    do
    {
      Object localObject1;
      do
      {
        for (;;)
        {
          AppMethodBeat.o(206390);
          return paramInt;
          localObject1 = paramXmlPullParser.getName();
          if (localObject1 != null) {
            switch (((String)localObject1).hashCode())
            {
            }
          }
        }
      } while (!((String)localObject1).equals("clip-path"));
      kotlin.g.b.s.u(paramXmlPullParser, "<this>");
      kotlin.g.b.s.u(paramResources, "res");
      kotlin.g.b.s.u(paramAttributeSet, "attrs");
      kotlin.g.b.s.u(parama, "builder");
      if (paramTheme == null) {}
      for (paramXmlPullParser = null;; paramXmlPullParser = paramTheme.obtainStyledAttributes(paramAttributeSet, a.vG(), 0, 0))
      {
        paramTheme = paramXmlPullParser;
        if (paramXmlPullParser == null)
        {
          paramXmlPullParser = a.aDL;
          paramTheme = paramResources.obtainAttributes(paramAttributeSet, a.vG());
        }
        paramXmlPullParser = a.aDL;
        paramResources = paramTheme.getString(a.vH());
        paramXmlPullParser = paramResources;
        if (paramResources == null) {
          paramXmlPullParser = "";
        }
        paramResources = a.aDL;
        paramResources = n.ak(paramTheme.getString(a.vI()));
        paramTheme.recycle();
        d.a.a(parama, paramXmlPullParser, paramResources);
        AppMethodBeat.o(206390);
        return paramInt + 1;
        if (!((String)localObject1).equals("path")) {
          break;
        }
        kotlin.g.b.s.u(paramXmlPullParser, "<this>");
        kotlin.g.b.s.u(paramResources, "res");
        kotlin.g.b.s.u(paramAttributeSet, "attrs");
        kotlin.g.b.s.u(parama, "builder");
        localObject1 = a.aDL;
        localObject1 = g.a(paramResources, paramTheme, paramAttributeSet, a.vr());
        kotlin.g.b.s.s(localObject1, "obtainAttributes(\n      …ECTOR_DRAWABLE_PATH\n    )");
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        if (!g.a(paramXmlPullParser, "pathData"))
        {
          paramXmlPullParser = new IllegalArgumentException("No path data available");
          AppMethodBeat.o(206390);
          throw paramXmlPullParser;
          if (!((String)localObject1).equals("group")) {
            break;
          }
          kotlin.g.b.s.u(paramXmlPullParser, "<this>");
          kotlin.g.b.s.u(paramResources, "res");
          kotlin.g.b.s.u(paramAttributeSet, "attrs");
          kotlin.g.b.s.u(parama, "builder");
          localObject1 = a.aDL;
          paramAttributeSet = g.a(paramResources, paramTheme, paramAttributeSet, a.vi());
          kotlin.g.b.s.s(paramAttributeSet, "obtainAttributes(\n      …CTOR_DRAWABLE_GROUP\n    )");
          paramResources = a.aDL;
          f1 = g.a(paramAttributeSet, paramXmlPullParser, "rotation", a.vm(), 0.0F);
          paramResources = a.aDL;
          f2 = paramAttributeSet.getFloat(a.vk(), 0.0F);
          paramResources = a.aDL;
          f3 = paramAttributeSet.getFloat(a.vl(), 0.0F);
          paramResources = a.aDL;
          f4 = g.a(paramAttributeSet, paramXmlPullParser, "scaleX", a.vn(), 1.0F);
          paramResources = a.aDL;
          f5 = g.a(paramAttributeSet, paramXmlPullParser, "scaleY", a.vo(), 1.0F);
          paramResources = a.aDL;
          f6 = g.a(paramAttributeSet, paramXmlPullParser, "translateX", a.vp(), 0.0F);
          paramResources = a.aDL;
          f7 = g.a(paramAttributeSet, paramXmlPullParser, "translateY", a.vq(), 0.0F);
          paramXmlPullParser = a.aDL;
          paramResources = paramAttributeSet.getString(a.vj());
          paramXmlPullParser = paramResources;
          if (paramResources == null) {
            paramXmlPullParser = "";
          }
          paramAttributeSet.recycle();
          parama.a(paramXmlPullParser, f1, f2, f3, f4, f5, f6, f7, n.uX());
          break;
        }
        paramResources = a.aDL;
        paramAttributeSet = ((TypedArray)localObject1).getString(a.vu());
        paramResources = paramAttributeSet;
        if (paramAttributeSet == null) {
          paramResources = "";
        }
        paramAttributeSet = a.aDL;
        paramAttributeSet = n.ak(((TypedArray)localObject1).getString(a.vv()));
        Object localObject2 = a.aDL;
        localObject2 = g.a((TypedArray)localObject1, paramXmlPullParser, paramTheme, "fillColor", a.vt());
        Object localObject3 = a.aDL;
        float f1 = g.a((TypedArray)localObject1, paramXmlPullParser, "fillAlpha", a.vs(), 1.0F);
        localObject3 = a.aDL;
        int j = g.a((TypedArray)localObject1, paramXmlPullParser, "strokeLineCap", a.vy(), -1);
        localObject3 = bb.ayr;
        i = bb.tO();
        switch (j)
        {
        default: 
          localObject3 = a.aDL;
          k = g.a((TypedArray)localObject1, paramXmlPullParser, "strokeLineJoin", a.vz(), -1);
          localObject3 = bc.ayv;
          j = bc.tS();
          switch (k)
          {
          default: 
            localObject3 = a.aDL;
            f2 = g.a((TypedArray)localObject1, paramXmlPullParser, "strokeMiterLimit", a.vA(), 1.0F);
            localObject3 = a.aDL;
            paramTheme = g.a((TypedArray)localObject1, paramXmlPullParser, paramTheme, "strokeColor", a.vx());
            localObject3 = a.aDL;
            f3 = g.a((TypedArray)localObject1, paramXmlPullParser, "strokeAlpha", a.vw(), 1.0F);
            localObject3 = a.aDL;
            f4 = g.a((TypedArray)localObject1, paramXmlPullParser, "strokeWidth", a.vB(), 1.0F);
            localObject3 = a.aDL;
            f5 = g.a((TypedArray)localObject1, paramXmlPullParser, "trimPathEnd", a.vC(), 1.0F);
            localObject3 = a.aDL;
            f6 = g.a((TypedArray)localObject1, paramXmlPullParser, "trimPathOffset", a.vD(), 0.0F);
            localObject3 = a.aDL;
            f7 = g.a((TypedArray)localObject1, paramXmlPullParser, "trimPathStart", a.vE(), 0.0F);
            localObject3 = a.aDL;
            k = g.a((TypedArray)localObject1, paramXmlPullParser, "fillType", a.vF(), aFi);
            ((TypedArray)localObject1).recycle();
            kotlin.g.b.s.s(localObject2, "fillColor");
            paramXmlPullParser = a((androidx.core.content.a.b)localObject2);
            kotlin.g.b.s.s(paramTheme, "strokeColor");
            paramTheme = a(paramTheme);
            if (k == 0) {
              localObject1 = aq.axV;
            }
            break;
          }
          break;
        }
        for (int k = aq.tI();; k = aq.tJ())
        {
          kotlin.g.b.s.u(paramAttributeSet, "pathData");
          kotlin.g.b.s.u(paramResources, "name");
          parama.uU();
          parama.uR().aAO.add(new androidx.compose.ui.e.d.s(paramResources, paramAttributeSet, k, paramXmlPullParser, f1, paramTheme, f3, f4, i, j, f2, f7, f5, f6, (byte)0));
          break;
          localObject3 = bb.ayr;
          i = bb.tO();
          break label680;
          localObject3 = bb.ayr;
          i = bb.tP();
          break label680;
          localObject3 = bb.ayr;
          i = bb.tQ();
          break label680;
          localObject3 = bc.ayv;
          j = bc.tR();
          break label740;
          localObject3 = bc.ayv;
          j = bc.tP();
          break label740;
          localObject3 = bc.ayv;
          j = bc.tS();
          break label740;
          localObject1 = aq.axV;
        }
        paramXmlPullParser = a.aDL;
      }
    } while (!kotlin.g.b.s.p("group", paramXmlPullParser.getName()));
    int i = 0;
    while (i < paramInt + 1)
    {
      parama.uS();
      i += 1;
    }
    AppMethodBeat.o(206390);
    return 0;
  }
  
  private static final androidx.compose.ui.e.s a(androidx.core.content.a.b paramb)
  {
    AppMethodBeat.i(206401);
    if (paramb.DF())
    {
      Shader localShader = paramb.bqd;
      if (localShader != null)
      {
        paramb = (androidx.compose.ui.e.s)t.b(localShader);
        AppMethodBeat.o(206401);
        return paramb;
      }
      paramb = (androidx.compose.ui.e.s)new ba(ab.cH(paramb.mColor), (byte)0);
      AppMethodBeat.o(206401);
      return paramb;
    }
    AppMethodBeat.o(206401);
    return null;
  }
  
  public static final XmlPullParser a(XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(206393);
    kotlin.g.b.s.u(paramXmlPullParser, "<this>");
    for (int i = paramXmlPullParser.next(); (i != 2) && (i != 1); i = paramXmlPullParser.next()) {}
    if (i != 2)
    {
      paramXmlPullParser = new XmlPullParserException("No start tag found");
      AppMethodBeat.o(206393);
      throw paramXmlPullParser;
    }
    AppMethodBeat.o(206393);
    return paramXmlPullParser;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.compose.ui.e.d.a.b
 * JD-Core Version:    0.7.0.1
 */