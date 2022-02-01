package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.l.a.a.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xmlpull.v1.XmlPullParser;

final class f$e
  implements f.d
{
  public final Drawable a(Context paramContext, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    AppMethodBeat.i(199705);
    try
    {
      paramContext = i.d(paramContext.getResources(), paramXmlPullParser, paramAttributeSet, paramTheme);
      AppMethodBeat.o(199705);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(199705);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.appcompat.widget.f.e
 * JD-Core Version:    0.7.0.1
 */