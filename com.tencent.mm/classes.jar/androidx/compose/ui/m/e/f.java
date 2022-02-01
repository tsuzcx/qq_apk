package androidx.compose.ui.m.e;

import android.graphics.Typeface;
import android.os.Build.VERSION;
import androidx.compose.ui.m.b.a;
import androidx.compose.ui.m.b.c.a;
import androidx.compose.ui.m.b.d;
import androidx.compose.ui.m.b.h;
import androidx.compose.ui.m.b.i;
import androidx.compose.ui.m.b.i.a;
import androidx.compose.ui.m.b.j;
import androidx.compose.ui.m.b.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.p;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/text/platform/TypefaceAdapter;", "", "fontMatcher", "Landroidx/compose/ui/text/font/FontMatcher;", "resourceLoader", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "(Landroidx/compose/ui/text/font/FontMatcher;Landroidx/compose/ui/text/font/Font$ResourceLoader;)V", "getFontMatcher", "()Landroidx/compose/ui/text/font/FontMatcher;", "getResourceLoader", "()Landroidx/compose/ui/text/font/Font$ResourceLoader;", "create", "Landroid/graphics/Typeface;", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "create-DPcqOEQ", "(Landroidx/compose/ui/text/font/FontFamily;Landroidx/compose/ui/text/font/FontWeight;II)Landroid/graphics/Typeface;", "Landroidx/compose/ui/text/font/FontListFontFamily;", "create-xC2X5gM", "(ILandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontListFontFamily;I)Landroid/graphics/Typeface;", "genericFontFamily", "", "create-RetOiIg", "(Ljava/lang/String;Landroidx/compose/ui/text/font/FontWeight;I)Landroid/graphics/Typeface;", "CacheKey", "Companion", "ui-text_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  public static final b bdP;
  private static final i bdR;
  private static final androidx.b.e<a, Typeface> bdS;
  private final c.a ahq;
  private final androidx.compose.ui.m.b.f bdQ;
  
  static
  {
    AppMethodBeat.i(205381);
    bdP = new b((byte)0);
    i.a locala = i.bcc;
    bdR = i.Bi();
    bdS = new androidx.b.e(16);
    AppMethodBeat.o(205381);
  }
  
  private f(androidx.compose.ui.m.b.f paramf, c.a parama)
  {
    AppMethodBeat.i(205347);
    this.bdQ = paramf;
    this.ahq = parama;
    AppMethodBeat.o(205347);
  }
  
  private static Typeface a(i parami, androidx.compose.ui.m.b.e parame)
  {
    AppMethodBeat.i(205372);
    s.u(parame, "fontFamily");
    s.u(parami, "fontWeight");
    AppMethodBeat.o(205372);
    throw null;
  }
  
  private static Typeface a(String paramString, i parami, int paramInt)
  {
    AppMethodBeat.i(205368);
    Object localObject = androidx.compose.ui.m.b.g.bbW;
    int i;
    if (androidx.compose.ui.m.b.g.C(paramInt, androidx.compose.ui.m.b.g.Bd()))
    {
      localObject = i.bcc;
      if (s.p(parami, i.Bk()))
      {
        localObject = (CharSequence)paramString;
        if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
        for (i = 1; i != 0; i = 0)
        {
          paramString = Typeface.DEFAULT;
          s.s(paramString, "DEFAULT");
          AppMethodBeat.o(205368);
          return paramString;
        }
      }
    }
    if (Build.VERSION.SDK_INT < 28)
    {
      i = b.a(parami, paramInt);
      parami = (CharSequence)paramString;
      if ((parami == null) || (parami.length() == 0))
      {
        paramInt = 1;
        if (paramInt == 0) {
          break label145;
        }
      }
      label145:
      for (paramString = Typeface.defaultFromStyle(i);; paramString = Typeface.create(paramString, i))
      {
        s.s(paramString, "{\n            val target…)\n            }\n        }");
        AppMethodBeat.o(205368);
        return paramString;
        paramInt = 0;
        break;
      }
    }
    if (paramString == null) {}
    for (paramString = Typeface.DEFAULT;; paramString = Typeface.create(paramString, 0))
    {
      localObject = g.bdU;
      s.s(paramString, "familyTypeface");
      i = parami.weight;
      parami = androidx.compose.ui.m.b.g.bbW;
      paramString = ((g)localObject).a(paramString, i, androidx.compose.ui.m.b.g.C(paramInt, androidx.compose.ui.m.b.g.Be()));
      AppMethodBeat.o(205368);
      return paramString;
    }
  }
  
  public final Typeface a(d paramd, i parami, int paramInt1, int paramInt2)
  {
    int i = 0;
    AppMethodBeat.i(205395);
    s.u(parami, "fontWeight");
    a locala = new a(paramd, parami, paramInt1, paramInt2, (byte)0);
    Typeface localTypeface = (Typeface)bdS.get(locala);
    if (localTypeface != null)
    {
      AppMethodBeat.o(205395);
      return localTypeface;
    }
    if ((paramd instanceof androidx.compose.ui.m.b.e)) {}
    for (paramd = a(parami, (androidx.compose.ui.m.b.e)paramd);; paramd = a(((j)paramd).name, parami, paramInt1))
    {
      bdS.put(locala, paramd);
      AppMethodBeat.o(205395);
      return paramd;
      if (!(paramd instanceof j)) {
        break;
      }
    }
    if ((paramd instanceof a)) {
      paramInt2 = 1;
    }
    for (;;)
    {
      if (paramInt2 == 0) {
        break label150;
      }
      paramd = a(null, parami, paramInt1);
      break;
      paramInt2 = i;
      if (paramd == null) {
        paramInt2 = 1;
      }
    }
    label150:
    if ((paramd instanceof k))
    {
      AppMethodBeat.o(205395);
      throw null;
    }
    paramd = new p();
    AppMethodBeat.o(205395);
    throw paramd;
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/ui/text/platform/TypefaceAdapter$CacheKey;", "", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "(Landroidx/compose/ui/text/font/FontFamily;Landroidx/compose/ui/text/font/FontWeight;IILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getFontFamily", "()Landroidx/compose/ui/text/font/FontFamily;", "getFontStyle-_-LCdwA", "()I", "I", "getFontSynthesis-GVVA2EU", "getFontWeight", "()Landroidx/compose/ui/text/font/FontWeight;", "component1", "component2", "component3", "component3-_-LCdwA", "component4", "component4-GVVA2EU", "copy", "copy-DPcqOEQ", "(Landroidx/compose/ui/text/font/FontFamily;Landroidx/compose/ui/text/font/FontWeight;II)Landroidx/compose/ui/text/platform/TypefaceAdapter$CacheKey;", "equals", "", "other", "hashCode", "", "toString", "", "ui-text_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    private final i baj;
    private final d bam;
    private final int bdT;
    private final int fontStyle;
    
    private a(d paramd, i parami, int paramInt1, int paramInt2)
    {
      this.bam = paramd;
      this.baj = parami;
      this.fontStyle = paramInt1;
      this.bdT = paramInt2;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(205373);
      if (this == paramObject)
      {
        AppMethodBeat.o(205373);
        return true;
      }
      if (!(paramObject instanceof a))
      {
        AppMethodBeat.o(205373);
        return false;
      }
      paramObject = (a)paramObject;
      if (!s.p(this.bam, paramObject.bam))
      {
        AppMethodBeat.o(205373);
        return false;
      }
      if (!s.p(this.baj, paramObject.baj))
      {
        AppMethodBeat.o(205373);
        return false;
      }
      if (!androidx.compose.ui.m.b.g.C(this.fontStyle, paramObject.fontStyle))
      {
        AppMethodBeat.o(205373);
        return false;
      }
      if (!h.C(this.bdT, paramObject.bdT))
      {
        AppMethodBeat.o(205373);
        return false;
      }
      AppMethodBeat.o(205373);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(205369);
      if (this.bam == null) {}
      for (int i = 0;; i = this.bam.hashCode())
      {
        int j = this.baj.hashCode();
        int k = androidx.compose.ui.m.b.g.cG(this.fontStyle);
        int m = h.cG(this.bdT);
        AppMethodBeat.o(205369);
        return ((i * 31 + j) * 31 + k) * 31 + m;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(205362);
      String str = "CacheKey(fontFamily=" + this.bam + ", fontWeight=" + this.baj + ", fontStyle=" + androidx.compose.ui.m.b.g.cJ(this.fontStyle) + ", fontSynthesis=" + h.cJ(this.bdT) + ')';
      AppMethodBeat.o(205362);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/ui/text/platform/TypefaceAdapter$Companion;", "", "()V", "ANDROID_BOLD", "Landroidx/compose/ui/text/font/FontWeight;", "typefaceCache", "Landroidx/collection/LruCache;", "Landroidx/compose/ui/text/platform/TypefaceAdapter$CacheKey;", "Landroid/graphics/Typeface;", "getTypefaceCache", "()Landroidx/collection/LruCache;", "getTypefaceStyle", "", "fontWeight", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "getTypefaceStyle-FO1MlWM", "(Landroidx/compose/ui/text/font/FontWeight;I)I", "isBold", "", "isItalic", "synthesize", "typeface", "font", "Landroidx/compose/ui/text/font/Font;", "fontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "synthesize-Wqqsr6A", "(Landroid/graphics/Typeface;Landroidx/compose/ui/text/font/Font;Landroidx/compose/ui/text/font/FontWeight;II)Landroid/graphics/Typeface;", "ui-text_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    public static int a(i parami, int paramInt)
    {
      AppMethodBeat.i(205341);
      s.u(parami, "fontWeight");
      if (parami.a(f.BN()) >= 0) {}
      for (boolean bool = true;; bool = false)
      {
        parami = androidx.compose.ui.m.b.g.bbW;
        paramInt = g(bool, androidx.compose.ui.m.b.g.C(paramInt, androidx.compose.ui.m.b.g.Be()));
        AppMethodBeat.o(205341);
        return paramInt;
      }
    }
    
    private static int g(boolean paramBoolean1, boolean paramBoolean2)
    {
      if ((paramBoolean2) && (paramBoolean1)) {
        return 3;
      }
      if (paramBoolean1) {
        return 1;
      }
      if (paramBoolean2) {
        return 2;
      }
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.m.e.f
 * JD-Core Version:    0.7.0.1
 */