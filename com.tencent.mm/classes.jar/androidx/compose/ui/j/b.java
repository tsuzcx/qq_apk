package androidx.compose.ui.j;

import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.util.Xml;
import androidx.compose.ui.e.ab;
import androidx.compose.ui.e.d.a.a;
import androidx.compose.ui.e.d.d;
import androidx.compose.ui.e.d.d.a;
import androidx.compose.ui.e.p;
import androidx.compose.ui.e.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@Metadata(d1={""}, d2={"loadVectorResourceInner", "Landroidx/compose/ui/graphics/vector/ImageVector;", "theme", "Landroid/content/res/Resources$Theme;", "Landroid/content/res/Resources;", "res", "parser", "Landroid/content/res/XmlResourceParser;", "vectorResource", "Landroidx/compose/ui/graphics/vector/ImageVector$Companion;", "resId", "", "id", "(Landroidx/compose/ui/graphics/vector/ImageVector$Companion;ILandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/vector/ImageVector;", "ui_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final d a(Resources.Theme paramTheme, Resources paramResources, XmlResourceParser paramXmlResourceParser)
  {
    AppMethodBeat.i(204361);
    s.u(paramResources, "res");
    s.u(paramXmlResourceParser, "parser");
    AttributeSet localAttributeSet = Xml.asAttributeSet((XmlPullParser)paramXmlResourceParser);
    Object localObject2 = (XmlPullParser)paramXmlResourceParser;
    s.s(localAttributeSet, "attrs");
    s.u(localObject2, "<this>");
    s.u(paramResources, "res");
    s.u(localAttributeSet, "attrs");
    Object localObject1 = a.aDL;
    localObject1 = androidx.core.content.a.g.a(paramResources, paramTheme, localAttributeSet, a.vb());
    s.s(localObject1, "obtainAttributes(\n      …DRAWABLE_TYPE_ARRAY\n    )");
    a locala = a.aDL;
    float f1 = androidx.core.content.a.g.a((TypedArray)localObject1, (XmlPullParser)localObject2, "viewportWidth", a.vg(), 0.0F);
    locala = a.aDL;
    float f2 = androidx.core.content.a.g.a((TypedArray)localObject1, (XmlPullParser)localObject2, "viewportHeight", a.vf(), 0.0F);
    if (f1 <= 0.0F)
    {
      paramTheme = new XmlPullParserException(s.X(((TypedArray)localObject1).getPositionDescription(), "<VectorGraphic> tag requires viewportWidth > 0"));
      AppMethodBeat.o(204361);
      throw paramTheme;
    }
    if (f2 <= 0.0F)
    {
      paramTheme = new XmlPullParserException(s.X(((TypedArray)localObject1).getPositionDescription(), "<VectorGraphic> tag requires viewportHeight > 0"));
      AppMethodBeat.o(204361);
      throw paramTheme;
    }
    localObject2 = a.aDL;
    float f4 = ((TypedArray)localObject1).getDimension(a.vh(), 0.0F);
    localObject2 = a.aDL;
    float f3 = ((TypedArray)localObject1).getDimension(a.vc(), 0.0F);
    localObject2 = a.aDL;
    long l;
    int i;
    if (((TypedArray)localObject1).hasValue(a.vd()))
    {
      localObject2 = new TypedValue();
      locala = a.aDL;
      ((TypedArray)localObject1).getValue(a.vd(), (TypedValue)localObject2);
      if ((((TypedValue)localObject2).type >= 28) && (((TypedValue)localObject2).type <= 31))
      {
        l = ab.cH(((TypedValue)localObject2).data);
        localObject2 = a.aDL;
        i = ((TypedArray)localObject1).getInt(a.ve(), -1);
        if (i == -1) {
          break label636;
        }
        switch (i)
        {
        case 4: 
        case 6: 
        case 7: 
        case 8: 
        case 10: 
        case 11: 
        case 12: 
        case 13: 
        default: 
          localObject2 = p.avT;
          i = p.sW();
          label394:
          f4 = androidx.compose.ui.n.g.ai(f4 / paramResources.getDisplayMetrics().density);
          f3 = androidx.compose.ui.n.g.ai(f3 / paramResources.getDisplayMetrics().density);
          ((TypedArray)localObject1).recycle();
          localObject1 = new d.a(f4, f3, f1, f2, l, i);
          i = 0;
          label452:
          localObject2 = (XmlPullParser)paramXmlResourceParser;
          s.u(localObject2, "<this>");
          if ((((XmlPullParser)localObject2).getEventType() != 1) && ((((XmlPullParser)localObject2).getDepth() > 0) || (((XmlPullParser)localObject2).getEventType() != 3))) {
            break;
          }
        }
      }
    }
    for (int j = 1;; j = 0)
    {
      if (j != 0) {
        break label655;
      }
      i = androidx.compose.ui.e.d.a.b.a((XmlPullParser)paramXmlResourceParser, paramResources, localAttributeSet, paramTheme, (d.a)localObject1, i);
      paramXmlResourceParser.next();
      break label452;
      localObject2 = z.awK;
      l = z.sw();
      break;
      localObject2 = z.awK;
      l = z.sw();
      break;
      localObject2 = p.avT;
      i = p.sU();
      break label394;
      localObject2 = p.avT;
      i = p.sW();
      break label394;
      localObject2 = p.avT;
      i = p.ta();
      break label394;
      localObject2 = p.avT;
      i = p.te();
      break label394;
      localObject2 = p.avT;
      i = p.tf();
      break label394;
      localObject2 = p.avT;
      i = p.td();
      break label394;
      label636:
      localObject2 = p.avT;
      i = p.sW();
      break label394;
    }
    label655:
    paramTheme = ((d.a)localObject1).uT();
    AppMethodBeat.o(204361);
    return paramTheme;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.compose.ui.j.b
 * JD-Core Version:    0.7.0.1
 */