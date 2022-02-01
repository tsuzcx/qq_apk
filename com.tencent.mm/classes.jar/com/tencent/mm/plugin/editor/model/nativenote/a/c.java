package com.tencent.mm.plugin.editor.model.nativenote.a;

import android.annotation.SuppressLint;
import android.text.Editable;
import android.text.Html.TagHandler;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.TypefaceSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.editor.model.nativenote.manager.f;
import com.tencent.mm.plugin.editor.model.nativenote.spans.BoldSpan;
import com.tencent.mm.plugin.editor.model.nativenote.spans.a;
import com.tencent.mm.plugin.editor.model.nativenote.spans.d;
import com.tencent.mm.plugin.editor.model.nativenote.spans.k;
import com.tencent.mm.plugin.editor.model.nativenote.spans.o;
import com.tencent.mm.plugin.editor.model.nativenote.spans.s;
import com.tencent.mm.sdk.platformtools.bu;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Locale;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xml.sax.XMLReader;

public final class c
  implements Html.TagHandler
{
  private static final Pattern bCH;
  private static final Pattern pAN;
  private static HashMap<String, Integer> pAO;
  private Stack<a> pAL;
  final HashMap<String, String> pAM;
  
  static
  {
    AppMethodBeat.i(181712);
    bCH = Pattern.compile("\\d+");
    pAN = Pattern.compile("#[a-f0-9]+");
    HashMap localHashMap = new HashMap();
    pAO = localHashMap;
    localHashMap.put("aqua", Integer.valueOf(65535));
    pAO.put("black", Integer.valueOf(0));
    pAO.put("blue", Integer.valueOf(255));
    pAO.put("fuchsia", Integer.valueOf(16711935));
    pAO.put("green", Integer.valueOf(32768));
    pAO.put("grey", Integer.valueOf(8421504));
    pAO.put("lime", Integer.valueOf(65280));
    pAO.put("maroon", Integer.valueOf(8388608));
    pAO.put("navy", Integer.valueOf(128));
    pAO.put("olive", Integer.valueOf(8421376));
    pAO.put("purple", Integer.valueOf(8388736));
    pAO.put("red", Integer.valueOf(16711680));
    pAO.put("silver", Integer.valueOf(12632256));
    pAO.put("teal", Integer.valueOf(32896));
    pAO.put("white", Integer.valueOf(16777215));
    pAO.put("yellow", Integer.valueOf(16776960));
    AppMethodBeat.o(181712);
  }
  
  public c()
  {
    AppMethodBeat.i(181704);
    this.pAL = new Stack();
    this.pAM = new HashMap();
    AppMethodBeat.o(181704);
  }
  
  private static Object a(Editable paramEditable, Class<? extends Object> paramClass)
  {
    AppMethodBeat.i(181709);
    paramEditable = paramEditable.getSpans(0, paramEditable.length(), paramClass);
    if (paramEditable.length == 0)
    {
      AppMethodBeat.o(181709);
      return null;
    }
    paramEditable = paramEditable[(paramEditable.length - 1)];
    AppMethodBeat.o(181709);
    return paramEditable;
  }
  
  private static void a(Editable paramEditable, Object paramObject)
  {
    AppMethodBeat.i(181710);
    int i = paramEditable.length();
    paramEditable.setSpan(paramObject, i, i, 17);
    AppMethodBeat.o(181710);
  }
  
  private void a(boolean paramBoolean, o paramo)
  {
    AppMethodBeat.i(181707);
    if (paramBoolean) {
      paramo = o.pEa;
    }
    if (this.pAL.isEmpty()) {}
    for (a locala = null; locala == null; locala = (a)this.pAL.peek())
    {
      paramo = new a(paramo, 1, 1);
      this.pAL.push(paramo);
      AppMethodBeat.o(181707);
      return;
    }
    if (locala.pDG == paramo)
    {
      locala.pDH += 1;
      locala.pDI += 1;
      AppMethodBeat.o(181707);
      return;
    }
    paramo = new a(paramo, locala.pDH + 1, 1);
    this.pAL.push(paramo);
    AppMethodBeat.o(181707);
  }
  
  @SuppressLint({"DefaultLocale"})
  private static int abN(String paramString)
  {
    AppMethodBeat.i(181711);
    Integer localInteger = (Integer)pAO.get(paramString.toLowerCase());
    int i;
    if (localInteger != null)
    {
      i = localInteger.intValue();
      AppMethodBeat.o(181711);
      return i;
    }
    if (paramString == null) {}
    int k;
    try
    {
      AppMethodBeat.o(181711);
      return -1;
    }
    catch (NumberFormatException paramString)
    {
      AppMethodBeat.o(181711);
      return -1;
    }
    paramString = paramString.toString();
    int j = paramString.length();
    int m = 10;
    if ('-' == paramString.charAt(0))
    {
      i = 1;
      k = -1;
      if ('0' == paramString.charAt(i))
      {
        if (i == j - 1)
        {
          AppMethodBeat.o(181711);
          return 0;
        }
        j = paramString.charAt(i + 1);
        if (120 == j) {
          break label200;
        }
        if (88 == j) {
          break label200;
        }
      }
    }
    for (;;)
    {
      i = Integer.parseInt(paramString.substring(j), i);
      AppMethodBeat.o(181711);
      return i * k;
      j = i + 1;
      i = 8;
      continue;
      j = paramString.charAt(i);
      if (35 == j)
      {
        j = i + 1;
        i = 16;
      }
      else
      {
        j = i;
        i = m;
        continue;
        i = 0;
        k = 1;
        break;
        label200:
        j = i + 2;
        i = 16;
      }
    }
  }
  
  private static void d(Editable paramEditable)
  {
    AppMethodBeat.i(181706);
    int i = paramEditable.length();
    if ((i > 0) && (paramEditable.charAt(i - 1) == '\n'))
    {
      AppMethodBeat.o(181706);
      return;
    }
    if (i != 0) {
      paramEditable.append("\n");
    }
    AppMethodBeat.o(181706);
  }
  
  private void kd(boolean paramBoolean)
  {
    AppMethodBeat.i(181708);
    while (!this.pAL.isEmpty())
    {
      a locala = (a)this.pAL.peek();
      o localo = locala.pDG;
      if (((paramBoolean) && (localo.cgK())) || ((!paramBoolean) && (localo.cgJ())) || ((!paramBoolean) && (localo.cgL())))
      {
        int i = locala.pDI;
        if (i > 1)
        {
          locala.pDI = (i - 1);
          locala.pDH -= 1;
          AppMethodBeat.o(181708);
          return;
        }
        this.pAL.pop();
        AppMethodBeat.o(181708);
        return;
      }
      this.pAL.pop();
    }
    AppMethodBeat.o(181708);
  }
  
  public final void handleTag(boolean paramBoolean, String paramString, Editable paramEditable, XMLReader paramXMLReader)
  {
    boolean bool3 = true;
    int j = 1;
    boolean bool2 = true;
    boolean bool1 = false;
    AppMethodBeat.i(181705);
    this.pAM.clear();
    Object localObject;
    Field localField;
    int k;
    int i;
    try
    {
      localObject = paramXMLReader.getClass().getDeclaredField("theNewElement");
      ((Field)localObject).setAccessible(true);
      paramXMLReader = ((Field)localObject).get(paramXMLReader);
      localObject = paramXMLReader.getClass().getDeclaredField("theAtts");
      ((Field)localObject).setAccessible(true);
      paramXMLReader = ((Field)localObject).get(paramXMLReader);
      localObject = paramXMLReader.getClass().getDeclaredField("data");
      ((Field)localObject).setAccessible(true);
      localObject = (String[])((Field)localObject).get(paramXMLReader);
      localField = paramXMLReader.getClass().getDeclaredField("length");
      localField.setAccessible(true);
      k = ((Integer)localField.get(paramXMLReader)).intValue();
      i = 0;
      while (i < k)
      {
        this.pAM.put(localObject[(i * 5 + 1)], localObject[(i * 5 + 4)]);
        i += 1;
      }
      if (!paramBoolean) {
        break label910;
      }
    }
    catch (Exception paramXMLReader) {}
    if (paramString.equalsIgnoreCase("wx-ul")) {
      a(false, o.pDZ);
    }
    label393:
    label663:
    label1562:
    label1568:
    label1697:
    for (;;)
    {
      a.pAJ = paramEditable;
      AppMethodBeat.o(181705);
      return;
      label1574:
      if (paramString.equalsIgnoreCase("wx-ol")) {
        a(true, o.pEa);
      } else {
        label1449:
        label1578:
        if (paramString.equalsIgnoreCase("wn-todo"))
        {
          paramString = new a(o.pEb, 1, 1);
          this.pAL.push(paramString);
          paramString = (String)this.pAM.get("checked");
          paramBoolean = bool1;
          if (!bu.isNullOrNil(paramString))
          {
            paramBoolean = bool1;
            if (paramString.equals("1")) {
              paramBoolean = true;
            }
          }
          a(paramEditable, new e(((a)this.pAL.peek()).pDH, paramBoolean));
        }
        else
        {
          if (paramString.equalsIgnoreCase("wx-li"))
          {
            paramString = (String)this.pAM.get("done");
            if ((!bu.isNullOrNil(paramString)) && (paramString.equals("true")))
            {
              paramBoolean = bool2;
              if (this.pAL.isEmpty()) {
                break label504;
              }
              paramString = (a)this.pAL.peek();
              paramXMLReader = paramString.pDG;
              i = paramString.pDH;
              if (!paramXMLReader.cgK()) {
                break label461;
              }
              paramString = new d(i);
            }
          }
          label1097:
          for (;;)
          {
            if (paramString == null) {
              break label1697;
            }
            a(paramEditable, paramString);
            break;
            paramBoolean = false;
            break label393;
            label461:
            if (paramXMLReader.cgJ())
            {
              paramString = new f(i);
            }
            else if (paramXMLReader.cgL())
            {
              paramString = new e(i, paramBoolean);
              continue;
              label504:
              paramString = new f(0);
              continue;
              int m;
              if ((paramString.equalsIgnoreCase("wx-font")) || (paramString.equalsIgnoreCase("span")))
              {
                i = -2147483648;
                paramString = (String)this.pAM.get("style");
                if (paramString == null) {
                  break label1686;
                }
                localObject = paramString.toLowerCase(Locale.ENGLISH).split(";");
                m = localObject.length;
                j = 0;
                paramXMLReader = null;
                paramString = null;
                if (j < m)
                {
                  localField = localObject[j];
                  Matcher localMatcher;
                  int n;
                  if (localField.startsWith("font-size"))
                  {
                    localMatcher = bCH.matcher(localField);
                    if (localMatcher.find(0))
                    {
                      k = localMatcher.start();
                      n = localMatcher.end();
                    }
                  }
                  for (;;)
                  {
                    try
                    {
                      k = Integer.parseInt(localField.substring(k, n));
                      i = k;
                      j += 1;
                    }
                    catch (NumberFormatException localNumberFormatException) {}
                    continue;
                    if (localNumberFormatException.startsWith("color"))
                    {
                      localMatcher = pAN.matcher(localNumberFormatException);
                      if (localMatcher.find(0)) {
                        paramString = localNumberFormatException.substring(localMatcher.start(), localMatcher.end());
                      }
                    }
                    else
                    {
                      if (!localNumberFormatException.startsWith("background-color")) {
                        break label1683;
                      }
                      localMatcher = pAN.matcher(localNumberFormatException);
                      if (!localMatcher.find(0)) {
                        break label1683;
                      }
                      paramXMLReader = localNumberFormatException.substring(localMatcher.start(), localMatcher.end());
                    }
                  }
                }
              }
              for (;;)
              {
                localObject = (String)this.pAM.get("face");
                j = paramEditable.length();
                b localb = new b((byte)0);
                localb.mSize = i;
                localb.pAP = paramString;
                localb.pAQ = paramXMLReader;
                paramEditable.setSpan(b.a(localb, (String)localObject), j, j, 17);
                break;
                if (paramString.equalsIgnoreCase("wx-b"))
                {
                  a(paramEditable, new c.a((byte)0));
                  break;
                }
                if (paramString.equalsIgnoreCase("wx-p"))
                {
                  d(paramEditable);
                  break;
                }
                if (!paramString.equalsIgnoreCase("wx-div")) {
                  break;
                }
                d(paramEditable);
                break;
                if (paramString.equalsIgnoreCase("wx-ul")) {
                  kd(false);
                }
                for (;;)
                {
                  this.pAM.clear();
                  break;
                  if (paramString.equalsIgnoreCase("wx-ol"))
                  {
                    kd(true);
                  }
                  else if (paramString.equalsIgnoreCase("wn-todo"))
                  {
                    paramString = (c)a(paramEditable, c.class);
                    if (paramString != null)
                    {
                      if ((paramEditable.length() == 0) || (paramEditable.charAt(paramEditable.length() - 1) != '\n')) {
                        paramEditable.append('\n');
                      }
                      i = paramEditable.getSpanStart(paramString);
                      j = paramEditable.length();
                      if (!paramString.pAT)
                      {
                        k = f.cfO();
                        bool1 = ((e)paramString).oB;
                        if (i != j) {
                          break label1097;
                        }
                      }
                      for (paramBoolean = true;; paramBoolean = false)
                      {
                        paramEditable.setSpan(new s(bool1, k, paramBoolean, false, false), i, j, 33);
                        paramEditable.removeSpan(paramString);
                        break;
                      }
                    }
                  }
                  else if (paramString.equalsIgnoreCase("wx-li"))
                  {
                    paramXMLReader = (c)a(paramEditable, c.class);
                    if (paramXMLReader != null)
                    {
                      if ((paramEditable.length() == 0) || (paramEditable.charAt(paramEditable.length() - 1) != '\n')) {
                        paramEditable.append('\n');
                      }
                      i = paramEditable.getSpanStart(paramXMLReader);
                      j = paramEditable.length();
                      if (!paramXMLReader.pAT)
                      {
                        k = f.cfO();
                        if (!(paramXMLReader instanceof d)) {
                          break label1256;
                        }
                        if (i != j) {
                          break label1251;
                        }
                      }
                      label1251:
                      for (paramBoolean = true;; paramBoolean = false)
                      {
                        paramString = new k(1, k, paramBoolean, false, false);
                        paramEditable.setSpan(paramString, i, j, 33);
                        paramEditable.removeSpan(paramXMLReader);
                        break;
                      }
                      label1256:
                      if (i == j) {}
                      for (paramBoolean = bool3;; paramBoolean = false)
                      {
                        paramString = new d(k, paramBoolean, false, false);
                        break;
                      }
                    }
                  }
                  else if ((paramString.equalsIgnoreCase("wx-font")) || (paramString.equalsIgnoreCase("span")))
                  {
                    k = paramEditable.length();
                    paramString = a(paramEditable, b.class);
                    if (paramString != null)
                    {
                      m = paramEditable.getSpanStart(paramString);
                      paramEditable.removeSpan(paramString);
                      if (m != k)
                      {
                        paramString = (b)paramString;
                        if (!TextUtils.isEmpty(paramString.pAR))
                        {
                          i = 1;
                          label1367:
                          if (i != 0) {
                            paramEditable.setSpan(new TypefaceSpan(paramString.pAR), m, k, 33);
                          }
                          if (paramString.mSize <= 0) {
                            break label1562;
                          }
                          i = 1;
                          label1405:
                          if (i != 0) {
                            paramEditable.setSpan(new AbsoluteSizeSpan(f.BP(paramString.mSize)), m, k, 33);
                          }
                          if (TextUtils.isEmpty(paramString.pAP)) {
                            break label1568;
                          }
                          i = 1;
                          if (i != 0)
                          {
                            i = abN(paramString.pAP);
                            if (i != -1) {
                              paramEditable.setSpan(new ForegroundColorSpan(i | 0xFF000000), m, k, 33);
                            }
                          }
                          if (TextUtils.isEmpty(paramString.pAQ)) {
                            break label1574;
                          }
                        }
                        for (i = j;; i = 0)
                        {
                          if (i == 0) {
                            break label1578;
                          }
                          i = abN(paramString.pAQ);
                          if (i == -1) {
                            break;
                          }
                          paramEditable.setSpan(new BackgroundColorSpan(i | 0xFF000000), m, k, 33);
                          break;
                          i = 0;
                          break label1367;
                          i = 0;
                          break label1405;
                          i = 0;
                          break label1449;
                        }
                      }
                    }
                  }
                  else if (paramString.equalsIgnoreCase("wx-b"))
                  {
                    paramString = new BoldSpan();
                    i = paramEditable.length();
                    paramXMLReader = a(paramEditable, c.a.class);
                    j = paramEditable.getSpanStart(paramXMLReader);
                    paramEditable.removeSpan(paramXMLReader);
                    if (j != i) {
                      paramEditable.setSpan(paramString, j, i, 33);
                    }
                  }
                  else if (paramString.equalsIgnoreCase("wx-p"))
                  {
                    d(paramEditable);
                  }
                  else
                  {
                    paramString.equalsIgnoreCase("wx-div");
                  }
                }
                break label663;
                paramXMLReader = null;
                paramString = null;
              }
            }
            else
            {
              paramString = null;
            }
          }
        }
      }
    }
  }
  
  static class b
  {
    int mSize = -2147483648;
    String pAP;
    String pAQ;
    String pAR;
  }
  
  static abstract class c
  {
    int pAS;
    boolean pAT;
    
    c(int paramInt)
    {
      this.pAS = paramInt;
      this.pAT = false;
    }
  }
  
  static final class d
    extends c.c
  {
    d(int paramInt)
    {
      super();
    }
  }
  
  static final class e
    extends c.c
  {
    boolean oB = false;
    
    e(int paramInt, boolean paramBoolean)
    {
      super();
      this.oB = paramBoolean;
    }
  }
  
  static final class f
    extends c.c
  {
    f(int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.a.c
 * JD-Core Version:    0.7.0.1
 */