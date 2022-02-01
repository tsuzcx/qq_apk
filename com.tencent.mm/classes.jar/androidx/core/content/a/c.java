package androidx.core.content.a;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.util.Base64;
import android.util.TypedValue;
import android.util.Xml;
import androidx.core.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class c
{
  public static a a(XmlPullParser paramXmlPullParser, Resources paramResources)
  {
    AppMethodBeat.i(195577);
    int i;
    do
    {
      i = paramXmlPullParser.next();
    } while ((i != 2) && (i != 1));
    if (i != 2)
    {
      paramXmlPullParser = new XmlPullParserException("No start tag found");
      AppMethodBeat.o(195577);
      throw paramXmlPullParser;
    }
    paramXmlPullParser.require(2, null, "font-family");
    if (paramXmlPullParser.getName().equals("font-family"))
    {
      paramXmlPullParser = b(paramXmlPullParser, paramResources);
      AppMethodBeat.o(195577);
      return paramXmlPullParser;
    }
    skip(paramXmlPullParser);
    AppMethodBeat.o(195577);
    return null;
  }
  
  private static a b(XmlPullParser paramXmlPullParser, Resources paramResources)
  {
    AppMethodBeat.i(195592);
    Object localObject = paramResources.obtainAttributes(Xml.asAttributeSet(paramXmlPullParser), a.d.FontFamily);
    String str1 = ((TypedArray)localObject).getString(a.d.FontFamily_fontProviderAuthority);
    String str2 = ((TypedArray)localObject).getString(a.d.FontFamily_fontProviderPackage);
    String str3 = ((TypedArray)localObject).getString(a.d.FontFamily_fontProviderQuery);
    int i = ((TypedArray)localObject).getResourceId(a.d.FontFamily_fontProviderCerts, 0);
    int j = ((TypedArray)localObject).getInteger(a.d.FontFamily_fontProviderFetchStrategy, 1);
    int k = ((TypedArray)localObject).getInteger(a.d.FontFamily_fontProviderFetchTimeout, 500);
    String str4 = ((TypedArray)localObject).getString(a.d.FontFamily_fontProviderSystemFontFamily);
    ((TypedArray)localObject).recycle();
    if ((str1 != null) && (str2 != null) && (str3 != null))
    {
      while (paramXmlPullParser.next() != 3) {
        skip(paramXmlPullParser);
      }
      paramXmlPullParser = new d(new androidx.core.d.c(str1, str2, str3, c(paramResources, i)), j, k, str4);
      AppMethodBeat.o(195592);
      return paramXmlPullParser;
    }
    localObject = new ArrayList();
    while (paramXmlPullParser.next() != 3) {
      if (paramXmlPullParser.getEventType() == 2) {
        if (paramXmlPullParser.getName().equals("font")) {
          ((List)localObject).add(c(paramXmlPullParser, paramResources));
        } else {
          skip(paramXmlPullParser);
        }
      }
    }
    if (((List)localObject).isEmpty())
    {
      AppMethodBeat.o(195592);
      return null;
    }
    paramXmlPullParser = new b((c[])((List)localObject).toArray(new c[((List)localObject).size()]));
    AppMethodBeat.o(195592);
    return paramXmlPullParser;
  }
  
  private static List<byte[]> b(String[] paramArrayOfString)
  {
    AppMethodBeat.i(195615);
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(Base64.decode(paramArrayOfString[i], 0));
      i += 1;
    }
    AppMethodBeat.o(195615);
    return localArrayList;
  }
  
  private static c c(XmlPullParser paramXmlPullParser, Resources paramResources)
  {
    boolean bool = true;
    AppMethodBeat.i(195626);
    paramResources = paramResources.obtainAttributes(Xml.asAttributeSet(paramXmlPullParser), a.d.FontFamilyFont);
    int k;
    label58:
    label68:
    label82:
    int j;
    label96:
    String str1;
    if (paramResources.hasValue(a.d.FontFamilyFont_fontWeight))
    {
      i = a.d.FontFamilyFont_fontWeight;
      k = paramResources.getInt(i, 400);
      if (!paramResources.hasValue(a.d.FontFamilyFont_fontStyle)) {
        break label167;
      }
      i = a.d.FontFamilyFont_fontStyle;
      if (1 != paramResources.getInt(i, 0)) {
        break label174;
      }
      if (!paramResources.hasValue(a.d.FontFamilyFont_ttcIndex)) {
        break label180;
      }
      i = a.d.FontFamilyFont_ttcIndex;
      if (!paramResources.hasValue(a.d.FontFamilyFont_fontVariationSettings)) {
        break label187;
      }
      j = a.d.FontFamilyFont_fontVariationSettings;
      str1 = paramResources.getString(j);
      j = paramResources.getInt(i, 0);
      if (!paramResources.hasValue(a.d.FontFamilyFont_font)) {
        break label194;
      }
    }
    int m;
    String str2;
    label167:
    label174:
    label180:
    label187:
    label194:
    for (int i = a.d.FontFamilyFont_font;; i = a.d.FontFamilyFont_android_font)
    {
      m = paramResources.getResourceId(i, 0);
      str2 = paramResources.getString(i);
      paramResources.recycle();
      while (paramXmlPullParser.next() != 3) {
        skip(paramXmlPullParser);
      }
      i = a.d.FontFamilyFont_android_fontWeight;
      break;
      i = a.d.FontFamilyFont_android_fontStyle;
      break label58;
      bool = false;
      break label68;
      i = a.d.FontFamilyFont_android_ttcIndex;
      break label82;
      j = a.d.FontFamilyFont_android_fontVariationSettings;
      break label96;
    }
    paramXmlPullParser = new c(str2, k, bool, str1, j, m);
    AppMethodBeat.o(195626);
    return paramXmlPullParser;
  }
  
  public static List<List<byte[]>> c(Resources paramResources, int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(195604);
    if (paramInt == 0)
    {
      paramResources = Collections.emptyList();
      AppMethodBeat.o(195604);
      return paramResources;
    }
    TypedArray localTypedArray = paramResources.obtainTypedArray(paramInt);
    for (;;)
    {
      int i;
      try
      {
        if (localTypedArray.length() == 0)
        {
          paramResources = Collections.emptyList();
          return paramResources;
        }
        ArrayList localArrayList = new ArrayList();
        if (Build.VERSION.SDK_INT >= 21)
        {
          i = localTypedArray.getType(0);
          break label189;
          if (paramInt < localTypedArray.length())
          {
            i = localTypedArray.getResourceId(paramInt, 0);
            if (i == 0) {
              break label199;
            }
            localArrayList.add(b(paramResources.getStringArray(i)));
            break label199;
          }
        }
        else
        {
          TypedValue localTypedValue = new TypedValue();
          localTypedArray.getValue(0, localTypedValue);
          i = localTypedValue.type;
          break label189;
          localArrayList.add(b(paramResources.getStringArray(paramInt)));
        }
        return localArrayList;
      }
      finally
      {
        localTypedArray.recycle();
        AppMethodBeat.o(195604);
      }
      label189:
      if (i == 1)
      {
        paramInt = j;
        continue;
        label199:
        paramInt += 1;
      }
    }
  }
  
  private static void skip(XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(195638);
    int i = 1;
    while (i > 0) {
      switch (paramXmlPullParser.next())
      {
      default: 
        break;
      case 2: 
        i += 1;
        break;
      case 3: 
        i -= 1;
      }
    }
    AppMethodBeat.o(195638);
  }
  
  public static abstract interface a {}
  
  public static final class b
    implements c.a
  {
    public final c.c[] bqf;
    
    public b(c.c[] paramArrayOfc)
    {
      this.bqf = paramArrayOfc;
    }
  }
  
  public static final class c
  {
    public int bqg;
    public boolean bqh;
    public String bqi;
    public int bqj;
    public int bqk;
    public final String mFileName;
    
    public c(String paramString1, int paramInt1, boolean paramBoolean, String paramString2, int paramInt2, int paramInt3)
    {
      this.mFileName = paramString1;
      this.bqg = paramInt1;
      this.bqh = paramBoolean;
      this.bqi = paramString2;
      this.bqj = paramInt2;
      this.bqk = paramInt3;
    }
  }
  
  public static final class d
    implements c.a
  {
    public final androidx.core.d.c bql;
    public final int bqm;
    public final String bqn;
    public final int mTimeoutMs;
    
    public d(androidx.core.d.c paramc, int paramInt1, int paramInt2, String paramString)
    {
      this.bql = paramc;
      this.bqm = paramInt1;
      this.mTimeoutMs = paramInt2;
      this.bqn = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.core.content.a.c
 * JD-Core Version:    0.7.0.1
 */