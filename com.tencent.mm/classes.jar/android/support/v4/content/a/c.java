package android.support.v4.content.a;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.b.a.a;
import android.support.v4.c.a;
import android.util.Base64;
import android.util.TypedValue;
import android.util.Xml;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class c
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
    skip(paramXmlPullParser);
    return null;
  }
  
  public static List<List<byte[]>> a(Resources paramResources, int paramInt)
  {
    int j = 0;
    if (paramInt == 0) {
      return Collections.emptyList();
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
          break label162;
          if (paramInt < localTypedArray.length())
          {
            i = localTypedArray.getResourceId(paramInt, 0);
            if (i == 0) {
              break label172;
            }
            localArrayList.add(b(paramResources.getStringArray(i)));
            break label172;
          }
        }
        else
        {
          TypedValue localTypedValue = new TypedValue();
          localTypedArray.getValue(0, localTypedValue);
          i = localTypedValue.type;
          break label162;
          localArrayList.add(b(paramResources.getStringArray(paramInt)));
        }
        return localArrayList;
      }
      finally
      {
        localTypedArray.recycle();
      }
      label162:
      if (i == 1)
      {
        paramInt = j;
        continue;
        label172:
        paramInt += 1;
      }
    }
  }
  
  private static a b(XmlPullParser paramXmlPullParser, Resources paramResources)
  {
    Object localObject = paramResources.obtainAttributes(Xml.asAttributeSet(paramXmlPullParser), a.a.FontFamily);
    String str1 = ((TypedArray)localObject).getString(0);
    String str2 = ((TypedArray)localObject).getString(4);
    String str3 = ((TypedArray)localObject).getString(5);
    int i = ((TypedArray)localObject).getResourceId(1, 0);
    int j = ((TypedArray)localObject).getInteger(2, 1);
    int k = ((TypedArray)localObject).getInteger(3, 500);
    ((TypedArray)localObject).recycle();
    if ((str1 != null) && (str2 != null) && (str3 != null))
    {
      while (paramXmlPullParser.next() != 3) {
        skip(paramXmlPullParser);
      }
      return new d(new a(str1, str2, str3, a(paramResources, i)), j, k);
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
    paramResources = paramResources.obtainAttributes(Xml.asAttributeSet(paramXmlPullParser), a.a.FontFamilyFont);
    int k;
    label46:
    boolean bool;
    label59:
    label71:
    int j;
    label83:
    String str1;
    if (paramResources.hasValue(8))
    {
      i = 8;
      k = paramResources.getInt(i, 400);
      if (!paramResources.hasValue(6)) {
        break label148;
      }
      i = 6;
      if (1 != paramResources.getInt(i, 0)) {
        break label153;
      }
      bool = true;
      if (!paramResources.hasValue(9)) {
        break label159;
      }
      i = 9;
      if (!paramResources.hasValue(7)) {
        break label164;
      }
      j = 7;
      str1 = paramResources.getString(j);
      j = paramResources.getInt(i, 0);
      if (!paramResources.hasValue(5)) {
        break label169;
      }
    }
    int m;
    String str2;
    label148:
    label153:
    label159:
    label164:
    label169:
    for (int i = 5;; i = 0)
    {
      m = paramResources.getResourceId(i, 0);
      str2 = paramResources.getString(i);
      paramResources.recycle();
      while (paramXmlPullParser.next() != 3) {
        skip(paramXmlPullParser);
      }
      i = 1;
      break;
      i = 2;
      break label46;
      bool = false;
      break label59;
      i = 3;
      break label71;
      j = 4;
      break label83;
    }
    return new c(str2, k, bool, str1, j, m);
  }
  
  private static void skip(XmlPullParser paramXmlPullParser)
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
  
  public static abstract interface a {}
  
  public static final class b
    implements c.a
  {
    public final c.c[] JE;
    
    public b(c.c[] paramArrayOfc)
    {
      this.JE = paramArrayOfc;
    }
  }
  
  public static final class c
  {
    public int JF;
    public boolean JG;
    public String JH;
    public int JI;
    public int JJ;
    public final String mFileName;
    
    public c(String paramString1, int paramInt1, boolean paramBoolean, String paramString2, int paramInt2, int paramInt3)
    {
      this.mFileName = paramString1;
      this.JF = paramInt1;
      this.JG = paramBoolean;
      this.JH = paramString2;
      this.JI = paramInt2;
      this.JJ = paramInt3;
    }
  }
  
  public static final class d
    implements c.a
  {
    public final a JK;
    public final int JL;
    public final int JM;
    
    public d(a parama, int paramInt1, int paramInt2)
    {
      this.JK = parama;
      this.JM = paramInt1;
      this.JL = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.content.a.c
 * JD-Core Version:    0.7.0.1
 */