package com.tencent.mm.plugin.editor;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.text.Spanned;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.b.g;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.plugin.editor.model.a.d;
import com.tencent.mm.plugin.editor.model.a.h;
import com.tencent.mm.plugin.editor.model.a.i;
import com.tencent.mm.plugin.editor.model.a.j;
import com.tencent.mm.plugin.editor.model.a.l;
import com.tencent.mm.plugin.editor.model.a.m;
import com.tencent.mm.plugin.fav.a.aq;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.LongBitmapHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class b
{
  public static b xvQ;
  private static f<String, Integer> xvR;
  
  static
  {
    AppMethodBeat.i(181633);
    xvQ = null;
    xvR = new c(30);
    AppMethodBeat.o(181633);
  }
  
  private static int A(char paramChar)
  {
    if (paramChar <= '') {
      return 1;
    }
    return 2;
  }
  
  public static CharSequence Q(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(181628);
    if (paramInt <= 0)
    {
      paramContext = paramContext.getString(d.h.favorite_second_format, new Object[] { Integer.valueOf(0), Integer.valueOf(0) });
      AppMethodBeat.o(181628);
      return paramContext;
    }
    int i = paramInt / 60;
    paramContext = paramContext.getString(d.h.favorite_second_format, new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt % 60) });
    AppMethodBeat.o(181628);
    return paramContext;
  }
  
  public static com.tencent.mm.plugin.editor.model.a.a a(com.tencent.mm.plugin.editor.model.a.a parama)
  {
    AppMethodBeat.i(181618);
    if (parama == null)
    {
      AppMethodBeat.o(181618);
      return null;
    }
    Object localObject1;
    switch (parama.getType())
    {
    case 0: 
    case 3: 
    case 5: 
    default: 
      localObject1 = null;
    }
    while (localObject1 == null)
    {
      AppMethodBeat.o(181618);
      return null;
      localObject1 = new j();
      ((j)localObject1).content = ((j)parama).content;
      continue;
      localObject1 = new h();
      ((h)localObject1).xym = ((h)parama).xym;
      continue;
      localObject1 = new l();
      Object localObject2 = (l)localObject1;
      Object localObject3 = (l)parama;
      ((l)localObject2).thumbPath = ((l)localObject3).thumbPath;
      ((l)localObject2).duration = ((l)localObject3).duration;
      ((l)localObject2).xyq = ((l)localObject3).xyq;
      continue;
      localObject1 = new m();
      localObject2 = (m)localObject1;
      localObject3 = (m)parama;
      ((m)localObject2).xyu = ((m)localObject3).xyu;
      ((m)localObject2).length = ((m)localObject3).length;
      ((m)localObject2).xyt = ((m)localObject3).xyt;
      ((m)localObject2).sdM = ((m)localObject3).sdM;
      ((m)localObject2).hIZ = ((m)localObject3).hIZ;
      ((m)localObject2).hIY = ((m)localObject3).hIY;
      ((m)localObject2).xyq = ((m)localObject3).xyq;
      continue;
      localObject1 = new i();
    }
    ((d)localObject1).type = ((d)parama).type;
    ((d)localObject1).xyp = ((d)parama).xyp;
    ((d)localObject1).hTM = ((d)parama).hTM;
    AppMethodBeat.o(181618);
    return localObject1;
  }
  
  public static String a(Context paramContext, com.tencent.mm.plugin.editor.model.a.a parama)
  {
    AppMethodBeat.i(181625);
    if (parama == null)
    {
      AppMethodBeat.o(181625);
      return "";
    }
    int i = parama.getType();
    if (i == 1)
    {
      paramContext = ((j)parama).content;
      AppMethodBeat.o(181625);
      return paramContext;
    }
    if (i == 3)
    {
      paramContext = paramContext.getString(d.h.xwz);
      AppMethodBeat.o(181625);
      return paramContext;
    }
    if (i == 2)
    {
      paramContext = paramContext.getString(d.h.xwy);
      AppMethodBeat.o(181625);
      return paramContext;
    }
    if (i == 6)
    {
      paramContext = paramContext.getString(d.h.xwA);
      AppMethodBeat.o(181625);
      return paramContext;
    }
    if (i == 4)
    {
      paramContext = paramContext.getString(d.h.xwB);
      AppMethodBeat.o(181625);
      return paramContext;
    }
    if (i == 5)
    {
      paramContext = paramContext.getString(d.h.xwx);
      AppMethodBeat.o(181625);
      return paramContext;
    }
    AppMethodBeat.o(181625);
    return "";
  }
  
  public static Bitmap anq(String paramString)
  {
    AppMethodBeat.i(181617);
    paramString = e.bs(paramString, false);
    if (paramString != null)
    {
      AppMethodBeat.o(181617);
      return paramString;
    }
    if (Util.isNullOrNil(null))
    {
      AppMethodBeat.o(181617);
      return null;
    }
    paramString = e.bs(null, false);
    AppMethodBeat.o(181617);
    return paramString;
  }
  
  public static int anr(String paramString)
  {
    AppMethodBeat.i(181621);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(181621);
      return 0;
    }
    int i = ant(anw(paramString));
    AppMethodBeat.o(181621);
    return i;
  }
  
  public static int ans(String paramString)
  {
    AppMethodBeat.i(181623);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(181623);
      return 0;
    }
    if (xvR.check(paramString))
    {
      i = ((Integer)xvR.get(paramString)).intValue();
      AppMethodBeat.o(181623);
      return i;
    }
    int i = ant(paramString);
    xvR.put(paramString, Integer.valueOf(i));
    AppMethodBeat.o(181623);
    return i;
  }
  
  private static int ant(String paramString)
  {
    AppMethodBeat.i(181624);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(181624);
      return 0;
    }
    int j = 0;
    int k;
    for (int i = 0; j < paramString.length(); i = k + i)
    {
      k = A(paramString.charAt(j));
      j += 1;
    }
    AppMethodBeat.o(181624);
    return i;
  }
  
  public static String anu(String paramString)
  {
    AppMethodBeat.i(181626);
    paramString = Pattern.compile("wx-b>", 2).matcher(paramString).replaceAll("wa-b>");
    paramString = Pattern.compile("</wx-li>", 2).matcher(paramString).replaceAll("<br/>");
    paramString = Pattern.compile("</wn-todo>", 2).matcher(paramString).replaceAll("<br/>");
    paramString = Pattern.compile("<[/]?w(x|n)-[^>]*>", 2).matcher(paramString).replaceAll("");
    paramString = Pattern.compile("wa-b>", 2).matcher(paramString).replaceAll("wx-b>");
    AppMethodBeat.o(181626);
    return paramString;
  }
  
  public static ArrayList<String> anv(String paramString)
  {
    AppMethodBeat.i(181629);
    if ((Util.isNullOrNil(paramString)) || (paramString.length() == 0))
    {
      AppMethodBeat.o(181629);
      return null;
    }
    paramString = Pattern.compile("<div><object[^>]*></object></div>", 2).matcher(paramString).replaceAll("<object>");
    paramString = Pattern.compile("<object[^>]*>", 2).matcher(paramString).replaceAll("#WNNoteNode#<ThisisNoteNodeObj>#WNNoteNode#");
    paramString = Pattern.compile("<hr[^>]*>", 2).matcher(paramString).replaceAll("#WNNoteNode#<ThisisNoteNodeHrObj>#WNNoteNode#");
    paramString = Pattern.compile("</object>", 2).matcher(paramString).replaceAll("");
    paramString = Pattern.compile("<div></div>", 2).matcher(paramString).replaceAll("");
    String[] arrayOfString = Pattern.compile("\n", 2).matcher(paramString).replaceAll("").replaceAll("<br>", "<br/>").trim().split("#WNNoteNode#");
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < arrayOfString.length)
    {
      paramString = arrayOfString[i];
      if (paramString.length() > 0)
      {
        String str = paramString.replace("</div>", "<div>");
        int j = -1;
        if (str.endsWith("<div>")) {
          j = str.lastIndexOf("<div>");
        }
        paramString = str;
        if (j > 0) {
          paramString = str.substring(0, j);
        }
        localArrayList.add(paramString.replace("<div><br/>", "<div>"));
      }
      i += 1;
    }
    AppMethodBeat.o(181629);
    return localArrayList;
  }
  
  public static String anw(String paramString)
  {
    AppMethodBeat.i(181630);
    if ((Util.isNullOrNil(paramString)) || (paramString.length() == 0))
    {
      AppMethodBeat.o(181630);
      return paramString;
    }
    paramString = Pattern.compile("<br[^>]*>", 2).matcher(paramString).replaceAll("\n");
    paramString = Pattern.compile("<div>", 2).matcher(paramString).replaceAll("");
    paramString = Pattern.compile("</wx-li>", 2).matcher(paramString).replaceAll("\n");
    paramString = Pattern.compile("</wx-todo>", 2).matcher(paramString).replaceAll("\n");
    paramString = Pattern.compile("<hr[^>]*>", 2).matcher(paramString).replaceAll("\n");
    paramString = Pattern.compile("<p [^>]*>", 2).matcher(paramString).replaceAll("");
    paramString = Pattern.compile("</p>", 2).matcher(paramString).replaceAll("");
    paramString = Pattern.compile("<[^>]*>", 2).matcher(paramString).replaceAll("");
    paramString = Pattern.compile("&nbsp;", 2).matcher(paramString).replaceAll(" ");
    AppMethodBeat.o(181630);
    return paramString;
  }
  
  public static boolean anx(String paramString)
  {
    AppMethodBeat.i(181631);
    int k = "<br/>".length();
    if ((Util.isNullOrNil(paramString)) || (paramString.length() < k))
    {
      AppMethodBeat.o(181631);
      return false;
    }
    int j;
    for (int i = 0; i < paramString.length(); i = j)
    {
      j = i + k;
      if (j > paramString.length())
      {
        AppMethodBeat.o(181631);
        return false;
      }
      if (!"<br/>".equalsIgnoreCase(paramString.substring(i, j)))
      {
        AppMethodBeat.o(181631);
        return false;
      }
    }
    AppMethodBeat.o(181631);
    return true;
  }
  
  public static String any(String paramString)
  {
    AppMethodBeat.i(181632);
    paramString = anw(Pattern.compile("<object[^>]*>", 2).matcher(paramString).replaceAll("#WNNoteNode#<ThisisNoteNodeObj>#WNNoteNode#"));
    if ((Util.isNullOrNil(paramString)) || (paramString.length() == 0))
    {
      AppMethodBeat.o(181632);
      return paramString;
    }
    paramString = Pattern.compile("\\s*|\t|\r|\n").matcher(paramString).replaceAll("");
    AppMethodBeat.o(181632);
    return paramString;
  }
  
  public static int b(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(181622);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(181622);
      return 0;
    }
    paramString = com.tencent.mm.plugin.editor.model.nativenote.a.a.anA(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(181622);
      return 0;
    }
    if (paramBoolean) {
      paramInt2 = paramString.length();
    }
    if ((paramInt1 < 0) || (paramInt1 > paramString.length()) || (paramInt2 < 0) || (paramInt2 > paramString.length()) || (paramInt1 > paramInt2))
    {
      AppMethodBeat.o(181622);
      return 0;
    }
    paramString = (Spanned)paramString.subSequence(paramInt1, paramInt2);
    if (paramString == null)
    {
      AppMethodBeat.o(181622);
      return 0;
    }
    paramInt1 = ant(paramString.toString());
    AppMethodBeat.o(181622);
    return paramInt1;
  }
  
  public static String b(com.tencent.mm.plugin.editor.model.a.a parama)
  {
    AppMethodBeat.i(181619);
    if (parama == null)
    {
      AppMethodBeat.o(181619);
      return "";
    }
    if (parama.getType() == 2)
    {
      parama = ((h)parama).xym;
      AppMethodBeat.o(181619);
      return parama;
    }
    parama = ((d)parama).hTM;
    AppMethodBeat.o(181619);
    return parama;
  }
  
  public static String c(com.tencent.mm.plugin.editor.model.a.a parama)
  {
    AppMethodBeat.i(181620);
    if (parama == null)
    {
      AppMethodBeat.o(181620);
      return "";
    }
    if (parama.getType() == 2)
    {
      parama = ((h)parama).hTM;
      AppMethodBeat.o(181620);
      return parama;
    }
    if (parama.getType() == 6)
    {
      parama = ((l)parama).thumbPath;
      AppMethodBeat.o(181620);
      return parama;
    }
    AppMethodBeat.o(181620);
    return "";
  }
  
  public static String gA(String paramString1, String paramString2)
  {
    int j = 1280;
    AppMethodBeat.i(181615);
    if (Util.isNullOrNil(paramString2))
    {
      paramString2 = g.getMessageDigest(new StringBuilder().append(paramString1).append(System.currentTimeMillis()).toString().getBytes()) + "_HD";
      paramString2 = aq.dRc() + "/" + paramString2;
    }
    for (;;)
    {
      BitmapFactory.Options localOptions;
      int k;
      int i;
      if (!y.ZC(paramString2))
      {
        localOptions = BitmapUtil.getImageOptions(paramString1);
        if ((localOptions == null) || (localOptions.outWidth <= 0) || (localOptions.outHeight <= 0))
        {
          Log.e("MicroMsg.EditorUtil", "GetImageOptions Error");
          AppMethodBeat.o(181615);
          return null;
        }
        k = localOptions.outHeight;
        int m = localOptions.outWidth;
        i = m;
        if (m > 1280) {
          i = 1280;
        }
        if (k <= 1280) {
          break label243;
        }
      }
      for (;;)
      {
        if (localOptions.outHeight < localOptions.outWidth)
        {
          k = i;
          i = j;
          j = k;
        }
        for (;;)
        {
          if (LongBitmapHandler.isLongPicture(paramString1) > 0)
          {
            j = localOptions.outHeight;
            i = localOptions.outWidth;
          }
          BitmapUtil.createThumbNail(paramString1, j, i, Bitmap.CompressFormat.JPEG, 95, paramString2, true);
          AppMethodBeat.o(181615);
          return paramString2;
        }
        label243:
        j = k;
      }
    }
  }
  
  public static String gB(String paramString1, String paramString2)
  {
    int m = 800;
    AppMethodBeat.i(181616);
    if (Util.isNullOrNil(paramString2))
    {
      paramString2 = g.getMessageDigest(new StringBuilder().append(paramString1).append(System.currentTimeMillis()).toString().getBytes()) + "_TH";
      paramString2 = aq.dRc() + "/" + paramString2;
    }
    for (;;)
    {
      BitmapFactory.Options localOptions;
      int j;
      int k;
      int i;
      if (!y.ZC(paramString2))
      {
        localOptions = BitmapUtil.getImageOptions(paramString1);
        if ((localOptions == null) || (localOptions.outWidth <= 0) || (localOptions.outHeight <= 0))
        {
          Log.e("MicroMsg.EditorUtil", "GetImageOptions Error,use orignal file");
          AppMethodBeat.o(181616);
          return null;
        }
        j = localOptions.outHeight;
        k = localOptions.outWidth;
        while (k * j > 2764800)
        {
          k >>= 1;
          j >>= 1;
        }
        i = k;
        if (k > 800) {
          i = 800;
        }
        if (j <= 800) {
          break label250;
        }
        j = m;
      }
      label250:
      for (;;)
      {
        if (localOptions.outHeight < localOptions.outWidth)
        {
          k = j;
          j = i;
        }
        for (;;)
        {
          BitmapUtil.createThumbNail(paramString1, j, k, Bitmap.CompressFormat.JPEG, 95, paramString2, true);
          AppMethodBeat.o(181616);
          return paramString2;
          k = i;
        }
      }
    }
  }
  
  public static float jh(long paramLong)
  {
    float f1 = 1.0F;
    AppMethodBeat.i(181627);
    float f2 = (float)paramLong / 1000.0F;
    if (f2 < 1.0F) {}
    for (;;)
    {
      f1 = Math.round(f1);
      AppMethodBeat.o(181627);
      return f1;
      f1 = f2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.b
 * JD-Core Version:    0.7.0.1
 */