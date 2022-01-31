package android.support.v4.content.a;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Base64;
import android.util.Xml;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class a
{
  public static a a(XmlPullParser paramXmlPullParser, Resources paramResources)
  {
    int i;
    do
    {
      i = paramXmlPullParser.next();
    } while ((i != 2) && (i != 1));
    if (i != 2) {
      throw new XmlPullParserException("No start tag found");
    }
    paramXmlPullParser.require(2, null, "font-family");
    if (paramXmlPullParser.getName().equals("font-family")) {
      return b(paramXmlPullParser, paramResources);
    }
    a(paramXmlPullParser);
    return null;
  }
  
  public static List<List<byte[]>> a(Resources paramResources, int paramInt)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    TypedArray localTypedArray;
    if (paramInt != 0)
    {
      localTypedArray = paramResources.obtainTypedArray(paramInt);
      localObject1 = localObject2;
      if (localTypedArray.length() > 0)
      {
        localObject1 = new ArrayList();
        if (localTypedArray.getResourceId(0, 0) != 0) {}
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label106;
          }
          paramInt = 0;
          while (paramInt < localTypedArray.length())
          {
            ((List)localObject1).add(b(paramResources.getStringArray(localTypedArray.getResourceId(paramInt, 0))));
            paramInt += 1;
          }
        }
      }
    }
    for (;;)
    {
      localTypedArray.recycle();
      if (localObject1 == null) {
        break;
      }
      return localObject1;
      label106:
      ((List)localObject1).add(b(paramResources.getStringArray(paramInt)));
    }
    return Collections.emptyList();
  }
  
  private static void a(XmlPullParser paramXmlPullParser)
  {
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
  }
  
  private static a b(XmlPullParser paramXmlPullParser, Resources paramResources)
  {
    Object localObject = paramResources.obtainAttributes(Xml.asAttributeSet(paramXmlPullParser), android.support.a.a.b.FontFamily);
    String str1 = ((TypedArray)localObject).getString(android.support.a.a.b.FontFamily_fontProviderAuthority);
    String str2 = ((TypedArray)localObject).getString(android.support.a.a.b.FontFamily_fontProviderPackage);
    String str3 = ((TypedArray)localObject).getString(android.support.a.a.b.FontFamily_fontProviderQuery);
    int i = ((TypedArray)localObject).getResourceId(android.support.a.a.b.FontFamily_fontProviderCerts, 0);
    int j = ((TypedArray)localObject).getInteger(android.support.a.a.b.FontFamily_fontProviderFetchStrategy, 1);
    int k = ((TypedArray)localObject).getInteger(android.support.a.a.b.FontFamily_fontProviderFetchTimeout, 500);
    ((TypedArray)localObject).recycle();
    if ((str1 != null) && (str2 != null) && (str3 != null))
    {
      while (paramXmlPullParser.next() != 3) {
        a(paramXmlPullParser);
      }
      return new d(new android.support.v4.d.a(str1, str2, str3, a(paramResources, i)), j, k);
    }
    localObject = new ArrayList();
    while (paramXmlPullParser.next() != 3) {
      if (paramXmlPullParser.getEventType() == 2) {
        if (paramXmlPullParser.getName().equals("font")) {
          ((List)localObject).add(c(paramXmlPullParser, paramResources));
        } else {
          a(paramXmlPullParser);
        }
      }
    }
    if (((List)localObject).isEmpty()) {
      return null;
    }
    return new b((c[])((List)localObject).toArray(new c[((List)localObject).size()]));
  }
  
  private static List<byte[]> b(String[] paramArrayOfString)
  {
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(Base64.decode(paramArrayOfString[i], 0));
      i += 1;
    }
    return localArrayList;
  }
  
  private static c c(XmlPullParser paramXmlPullParser, Resources paramResources)
  {
    paramResources = paramResources.obtainAttributes(Xml.asAttributeSet(paramXmlPullParser), android.support.a.a.b.FontFamilyFont);
    int j;
    label49:
    boolean bool;
    if (paramResources.hasValue(android.support.a.a.b.FontFamilyFont_fontWeight))
    {
      i = android.support.a.a.b.FontFamilyFont_fontWeight;
      j = paramResources.getInt(i, 400);
      if (!paramResources.hasValue(android.support.a.a.b.FontFamilyFont_fontStyle)) {
        break label119;
      }
      i = android.support.a.a.b.FontFamilyFont_fontStyle;
      if (1 != paramResources.getInt(i, 0)) {
        break label126;
      }
      bool = true;
      label62:
      if (!paramResources.hasValue(android.support.a.a.b.FontFamilyFont_font)) {
        break label132;
      }
    }
    int k;
    String str;
    label132:
    for (int i = android.support.a.a.b.FontFamilyFont_font;; i = android.support.a.a.b.FontFamilyFont_android_font)
    {
      k = paramResources.getResourceId(i, 0);
      str = paramResources.getString(i);
      paramResources.recycle();
      while (paramXmlPullParser.next() != 3) {
        a(paramXmlPullParser);
      }
      i = android.support.a.a.b.FontFamilyFont_android_fontWeight;
      break;
      label119:
      i = android.support.a.a.b.FontFamilyFont_android_fontStyle;
      break label49;
      label126:
      bool = false;
      break label62;
    }
    return new c(str, j, bool, k);
  }
  
  public static abstract interface a {}
  
  public static final class b
    implements a.a
  {
    public final a.c[] zH;
    
    public b(a.c[] paramArrayOfc)
    {
      this.zH = paramArrayOfc;
    }
  }
  
  public static final class c
  {
    public final String mFileName;
    public int zI;
    public boolean zJ;
    public int zK;
    
    public c(String paramString, int paramInt1, boolean paramBoolean, int paramInt2)
    {
      this.mFileName = paramString;
      this.zI = paramInt1;
      this.zJ = paramBoolean;
      this.zK = paramInt2;
    }
  }
  
  public static final class d
    implements a.a
  {
    public final android.support.v4.d.a zL;
    public final int zM;
    public final int zN;
    
    public d(android.support.v4.d.a parama, int paramInt1, int paramInt2)
    {
      this.zL = parama;
      this.zN = paramInt1;
      this.zM = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.content.a.a
 * JD-Core Version:    0.7.0.1
 */