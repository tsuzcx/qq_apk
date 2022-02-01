package coil.util;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Xml;
import androidx.appcompat.a.a.a;
import androidx.core.content.a.f;
import androidx.l.a.a.i;
import androidx.lifecycle.j;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@Metadata(d1={""}, d2={"getDrawableCompat", "Landroid/graphics/drawable/Drawable;", "Landroid/content/Context;", "resId", "", "Landroid/content/res/Resources;", "theme", "Landroid/content/res/Resources$Theme;", "getLifecycle", "Landroidx/lifecycle/Lifecycle;", "getXmlDrawableCompat", "resources", "isPermissionGranted", "", "permission", "", "requireSystemService", "T", "", "(Landroid/content/Context;)Ljava/lang/Object;", "coil-base_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final j aA(Context paramContext)
  {
    AppMethodBeat.i(188129);
    for (;;)
    {
      if ((paramContext instanceof q))
      {
        paramContext = ((q)paramContext).getLifecycle();
        AppMethodBeat.o(188129);
        return paramContext;
      }
      if (!(paramContext instanceof ContextWrapper))
      {
        AppMethodBeat.o(188129);
        return null;
      }
      paramContext = ((ContextWrapper)paramContext).getBaseContext();
    }
  }
  
  public static final Drawable b(Context paramContext, Resources paramResources, int paramInt)
  {
    AppMethodBeat.i(188117);
    s.u(paramContext, "<this>");
    s.u(paramResources, "resources");
    XmlResourceParser localXmlResourceParser = paramResources.getXml(paramInt);
    s.s(localXmlResourceParser, "resources.getXml(resId)");
    for (int i = localXmlResourceParser.next(); (i != 2) && (i != 1); i = localXmlResourceParser.next()) {}
    if (i != 2)
    {
      paramContext = new XmlPullParserException("No start tag found.");
      AppMethodBeat.o(188117);
      throw paramContext;
    }
    if (Build.VERSION.SDK_INT < 24)
    {
      Object localObject = localXmlResourceParser.getName();
      if (s.p(localObject, "vector"))
      {
        localObject = Xml.asAttributeSet((XmlPullParser)localXmlResourceParser);
        paramContext = i.d(paramResources, (XmlPullParser)localXmlResourceParser, (AttributeSet)localObject, paramContext.getTheme());
        s.s(paramContext, "createFromXmlInner(resou…es, parser, attrs, theme)");
        paramContext = (Drawable)paramContext;
        AppMethodBeat.o(188117);
        return paramContext;
      }
      if (s.p(localObject, "animated-vector"))
      {
        localObject = Xml.asAttributeSet((XmlPullParser)localXmlResourceParser);
        paramContext = androidx.l.a.a.c.d(paramContext, paramResources, (XmlPullParser)localXmlResourceParser, (AttributeSet)localObject, paramContext.getTheme());
        s.s(paramContext, "createFromXmlInner(this,…es, parser, attrs, theme)");
        paramContext = (Drawable)paramContext;
        AppMethodBeat.o(188117);
        return paramContext;
      }
    }
    paramContext = paramContext.getTheme();
    s.u(paramResources, "<this>");
    paramContext = f.b(paramResources, paramInt, paramContext);
    if (paramContext == null)
    {
      paramContext = (Throwable)new IllegalStateException(s.X("Invalid resource ID: ", Integer.valueOf(paramInt)).toString());
      AppMethodBeat.o(188117);
      throw paramContext;
    }
    AppMethodBeat.o(188117);
    return paramContext;
  }
  
  public static final Drawable z(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(188098);
    s.u(paramContext, "<this>");
    paramContext = a.m(paramContext, paramInt);
    if (paramContext == null)
    {
      paramContext = (Throwable)new IllegalStateException(s.X("Invalid resource ID: ", Integer.valueOf(paramInt)).toString());
      AppMethodBeat.o(188098);
      throw paramContext;
    }
    AppMethodBeat.o(188098);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     coil.util.c
 * JD-Core Version:    0.7.0.1
 */