package com.tencent.mm.cc;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Picture;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.svg.a.c;
import com.tencent.mm.svg.a.e;
import com.tencent.mm.ui.af;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

public final class b
  extends Resources
{
  private static Method yjk = null;
  private static Method yjl = null;
  private Resources mResources;
  private f yjg;
  private d yjh;
  private boolean yji;
  public a yjj;
  
  /* Error */
  private b(Resources paramResources, f paramf, d paramd, a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 43	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   5: aload 4
    //   7: invokevirtual 49	com/tencent/mm/cc/a:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   10: aload 4
    //   12: aload_1
    //   13: invokevirtual 53	android/content/res/Resources:getConfiguration	()Landroid/content/res/Configuration;
    //   16: invokevirtual 57	com/tencent/mm/cc/a:c	(Landroid/content/res/Configuration;)Landroid/content/res/Configuration;
    //   19: invokespecial 60	android/content/res/Resources:<init>	(Landroid/content/res/AssetManager;Landroid/util/DisplayMetrics;Landroid/content/res/Configuration;)V
    //   22: ldc 61
    //   24: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   27: aload_0
    //   28: aload 4
    //   30: putfield 69	com/tencent/mm/cc/b:yjj	Lcom/tencent/mm/cc/a;
    //   33: aload_0
    //   34: aload_2
    //   35: putfield 71	com/tencent/mm/cc/b:yjg	Lcom/tencent/mm/cc/f;
    //   38: aload_1
    //   39: instanceof 2
    //   42: ifeq +138 -> 180
    //   45: aload_0
    //   46: aload_1
    //   47: checkcast 2	com/tencent/mm/cc/b
    //   50: getfield 73	com/tencent/mm/cc/b:mResources	Landroid/content/res/Resources;
    //   53: putfield 73	com/tencent/mm/cc/b:mResources	Landroid/content/res/Resources;
    //   56: aload_0
    //   57: aload_3
    //   58: putfield 75	com/tencent/mm/cc/b:yjh	Lcom/tencent/mm/cc/d;
    //   61: ldc 77
    //   63: invokestatic 83	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   66: astore 4
    //   68: aload 4
    //   70: ifnull +118 -> 188
    //   73: ldc 85
    //   75: ldc 87
    //   77: invokestatic 92	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   80: aload 4
    //   82: ldc 94
    //   84: invokevirtual 98	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   87: astore_3
    //   88: aload_3
    //   89: astore_2
    //   90: aload_3
    //   91: ifnull +99 -> 190
    //   94: aload_3
    //   95: iconst_1
    //   96: invokevirtual 104	java/lang/reflect/Field:setAccessible	(Z)V
    //   99: aload_3
    //   100: aconst_null
    //   101: getstatic 110	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   104: invokevirtual 114	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   107: new 116	com/tencent/mm/compatible/loader/c
    //   110: dup
    //   111: aload_0
    //   112: invokevirtual 117	com/tencent/mm/cc/b:getAssets	()Landroid/content/res/AssetManager;
    //   115: ldc 119
    //   117: aconst_null
    //   118: invokespecial 122	com/tencent/mm/compatible/loader/c:<init>	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   121: astore_2
    //   122: aload_2
    //   123: invokevirtual 126	com/tencent/mm/compatible/loader/c:Mb	()Z
    //   126: ifeq +14 -> 140
    //   129: aload_2
    //   130: new 6	com/tencent/mm/cc/b$a
    //   133: dup
    //   134: invokespecial 128	com/tencent/mm/cc/b$a:<init>	()V
    //   137: invokevirtual 131	com/tencent/mm/compatible/loader/c:set	(Ljava/lang/Object;)V
    //   140: aload_0
    //   141: invokestatic 137	com/tencent/mm/sdk/platformtools/ah:dsQ	()Landroid/content/SharedPreferences;
    //   144: ldc 139
    //   146: iconst_0
    //   147: invokeinterface 145 3 0
    //   152: putfield 147	com/tencent/mm/cc/b:yji	Z
    //   155: ldc 85
    //   157: ldc 149
    //   159: iconst_2
    //   160: anewarray 151	java/lang/Object
    //   163: dup
    //   164: iconst_0
    //   165: aload_1
    //   166: aastore
    //   167: dup
    //   168: iconst_1
    //   169: aload_0
    //   170: aastore
    //   171: invokestatic 154	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   174: ldc 61
    //   176: invokestatic 157	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   179: return
    //   180: aload_0
    //   181: aload_1
    //   182: putfield 73	com/tencent/mm/cc/b:mResources	Landroid/content/res/Resources;
    //   185: goto -129 -> 56
    //   188: aconst_null
    //   189: astore_2
    //   190: ldc 85
    //   192: ldc 159
    //   194: iconst_2
    //   195: anewarray 151	java/lang/Object
    //   198: dup
    //   199: iconst_0
    //   200: aload 4
    //   202: aastore
    //   203: dup
    //   204: iconst_1
    //   205: aload_2
    //   206: aastore
    //   207: invokestatic 162	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   210: goto -103 -> 107
    //   213: astore_2
    //   214: ldc 85
    //   216: ldc 164
    //   218: invokestatic 92	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   221: goto -114 -> 107
    //   224: astore_2
    //   225: ldc 85
    //   227: ldc 166
    //   229: invokestatic 92	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   232: goto -125 -> 107
    //   235: astore_2
    //   236: ldc 85
    //   238: ldc 168
    //   240: invokestatic 92	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   243: goto -136 -> 107
    //   246: astore_2
    //   247: ldc 85
    //   249: ldc 170
    //   251: invokestatic 92	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   254: goto -147 -> 107
    //   257: astore_2
    //   258: ldc 85
    //   260: aload_2
    //   261: ldc 172
    //   263: iconst_0
    //   264: anewarray 151	java/lang/Object
    //   267: invokestatic 176	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   270: goto -130 -> 140
    //   273: astore_2
    //   274: ldc 85
    //   276: aload_2
    //   277: ldc 172
    //   279: iconst_0
    //   280: anewarray 151	java/lang/Object
    //   283: invokestatic 176	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   286: goto -146 -> 140
    //   289: astore_2
    //   290: ldc 85
    //   292: aload_2
    //   293: ldc 172
    //   295: iconst_0
    //   296: anewarray 151	java/lang/Object
    //   299: invokestatic 176	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   302: goto -162 -> 140
    //   305: astore_2
    //   306: ldc 85
    //   308: aload_2
    //   309: invokevirtual 180	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   312: invokestatic 182	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   315: goto -160 -> 155
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	318	0	this	b
    //   0	318	1	paramResources	Resources
    //   0	318	2	paramf	f
    //   0	318	3	paramd	d
    //   0	318	4	parama	a
    // Exception table:
    //   from	to	target	type
    //   61	68	213	java/lang/ClassNotFoundException
    //   73	88	213	java/lang/ClassNotFoundException
    //   94	107	213	java/lang/ClassNotFoundException
    //   190	210	213	java/lang/ClassNotFoundException
    //   61	68	224	java/lang/NoSuchFieldException
    //   73	88	224	java/lang/NoSuchFieldException
    //   94	107	224	java/lang/NoSuchFieldException
    //   190	210	224	java/lang/NoSuchFieldException
    //   61	68	235	java/lang/IllegalAccessException
    //   73	88	235	java/lang/IllegalAccessException
    //   94	107	235	java/lang/IllegalAccessException
    //   190	210	235	java/lang/IllegalAccessException
    //   61	68	246	java/lang/IllegalArgumentException
    //   73	88	246	java/lang/IllegalArgumentException
    //   94	107	246	java/lang/IllegalArgumentException
    //   190	210	246	java/lang/IllegalArgumentException
    //   122	140	257	java/lang/NoSuchFieldException
    //   122	140	273	java/lang/IllegalAccessException
    //   122	140	289	java/lang/IllegalArgumentException
    //   140	155	305	java/lang/Exception
  }
  
  public static Resources a(Resources paramResources, Context paramContext)
  {
    AppMethodBeat.i(105891);
    paramResources = new b(paramResources, f.gy(paramContext), new d(), new a(paramResources.getDisplayMetrics()));
    AppMethodBeat.o(105891);
    return paramResources;
  }
  
  public static Resources a(Resources paramResources, Context paramContext, String paramString)
  {
    AppMethodBeat.i(105892);
    paramResources = new b(paramResources, f.bF(paramContext, paramString), new d(), new a(paramResources.getDisplayMetrics()));
    AppMethodBeat.o(105892);
    return paramResources;
  }
  
  private Drawable d(Drawable paramDrawable, int paramInt)
  {
    AppMethodBeat.i(105907);
    Object localObject = paramDrawable;
    if (paramDrawable == null) {
      ab.b("MicroMsg.MMResources", "Notice!!! drawable == null!!!", new Object[0]);
    }
    try
    {
      if (this.yjh.yjq.h(this, paramInt)) {
        ab.e("MicroMsg.MMResources", "resources name = %s, this resource %s", new Object[] { getResourceName(paramInt), this });
      }
      localObject = new c(new Picture(), 0);
      AppMethodBeat.o(105907);
      return localObject;
    }
    catch (Exception paramDrawable)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.MMResources", paramDrawable, "WTF", new Object[0]);
      }
    }
  }
  
  private boolean drj()
  {
    AppMethodBeat.i(105893);
    if ((this.yjg != null) && (f.drj()))
    {
      AppMethodBeat.o(105893);
      return true;
    }
    AppMethodBeat.o(105893);
    return false;
  }
  
  public static Drawable e(Resources paramResources, int paramInt)
  {
    AppMethodBeat.i(105908);
    paramResources = e.e(paramResources, paramInt);
    AppMethodBeat.o(105908);
    return paramResources;
  }
  
  public static Drawable f(Resources paramResources, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(105909);
    Object localObject3 = new TypedValue();
    paramResources.getValue(paramInt, (TypedValue)localObject3, true);
    Object localObject1 = null;
    if ((((TypedValue)localObject3).type >= 28) && (((TypedValue)localObject3).type <= 31)) {}
    for (;;)
    {
      if (i != 0) {
        localObject1 = new ColorDrawable(((TypedValue)localObject3).data);
      }
      if (yjk == null) {}
      Object localObject2;
      try
      {
        localObject2 = Resources.class.getDeclaredMethod("loadXmlResourceParser", new Class[] { String.class, Integer.TYPE, Integer.TYPE, String.class });
        yjk = (Method)localObject2;
        ((Method)localObject2).setAccessible(true);
        if (yjl == null) {}
        localObject1 = ((TypedValue)localObject3).string.toString();
      }
      catch (NoSuchMethodException paramResources)
      {
        try
        {
          localObject2 = AssetManager.class.getDeclaredMethod("openNonAsset", new Class[] { Integer.TYPE, String.class, Integer.TYPE });
          yjl = (Method)localObject2;
          ((Method)localObject2).setAccessible(true);
          localObject2 = localObject1;
          if (localObject1 != null) {
            break label353;
          }
          if (((TypedValue)localObject3).string != null) {
            break label273;
          }
          paramResources = new Resources.NotFoundException("Resource is not a Drawable (color or path): ".concat(String.valueOf(localObject3)));
          AppMethodBeat.o(105909);
          throw paramResources;
        }
        catch (NoSuchMethodException paramResources)
        {
          ab.printErrStackTrace("MicroMsg.MMResources", paramResources, "", new Object[0]);
          ab.printErrStackTrace("MicroMsg.MMResources", paramResources, "", new Object[0]);
          AppMethodBeat.o(105909);
          return null;
        }
        paramResources = paramResources;
        ab.printErrStackTrace("MicroMsg.MMResources", paramResources, "", new Object[0]);
        ab.printErrStackTrace("MicroMsg.MMResources", paramResources, "", new Object[0]);
        AppMethodBeat.o(105909);
        return null;
      }
      label273:
      if (((String)localObject1).endsWith(".xml")) {}
      for (;;)
      {
        try
        {
          localObject3 = (XmlResourceParser)yjk.invoke(paramResources, new Object[] { localObject1, Integer.valueOf(paramInt), Integer.valueOf(((TypedValue)localObject3).assetCookie), "drawable" });
          localObject2 = Drawable.createFromXml(paramResources, (XmlPullParser)localObject3);
          ((XmlResourceParser)localObject3).close();
          label353:
          AppMethodBeat.o(105909);
          return localObject2;
        }
        catch (Exception paramResources)
        {
          localObject1 = new Resources.NotFoundException("File " + (String)localObject1 + " from drawable resource ID #0x" + Integer.toHexString(paramInt));
          ((Resources.NotFoundException)localObject1).initCause(paramResources);
          AppMethodBeat.o(105909);
          throw ((Throwable)localObject1);
        }
        try
        {
          InputStream localInputStream = (InputStream)yjl.invoke(paramResources.getAssets(), new Object[] { Integer.valueOf(((TypedValue)localObject3).assetCookie), localObject1, Integer.valueOf(2) });
          localObject2 = Drawable.createFromResourceStream(paramResources, (TypedValue)localObject3, localInputStream, (String)localObject1, null);
          localInputStream.close();
        }
        catch (Exception paramResources)
        {
          localObject1 = new Resources.NotFoundException("File " + (String)localObject1 + " from drawable resource ID #0x" + Integer.toHexString(paramInt));
          ((Resources.NotFoundException)localObject1).initCause(paramResources);
          AppMethodBeat.o(105909);
          throw ((Throwable)localObject1);
        }
      }
      i = 0;
    }
  }
  
  public final DisplayMetrics getDisplayMetrics()
  {
    AppMethodBeat.i(105888);
    DisplayMetrics localDisplayMetrics = this.yjj.getDisplayMetrics();
    AppMethodBeat.o(105888);
    return localDisplayMetrics;
  }
  
  public final Drawable getDrawable(int paramInt)
  {
    AppMethodBeat.i(105903);
    if (paramInt != 0)
    {
      localDrawable = this.yjh.g(this.mResources, paramInt);
      if (localDrawable != null)
      {
        AppMethodBeat.o(105903);
        return localDrawable;
      }
    }
    Drawable localDrawable = d(super.getDrawable(paramInt), paramInt);
    AppMethodBeat.o(105903);
    return localDrawable;
  }
  
  @TargetApi(21)
  public final Drawable getDrawable(int paramInt, Resources.Theme paramTheme)
  {
    AppMethodBeat.i(105904);
    if (paramInt != 0)
    {
      Drawable localDrawable = this.yjh.g(this.mResources, paramInt);
      if (localDrawable != null)
      {
        AppMethodBeat.o(105904);
        return localDrawable;
      }
    }
    paramTheme = d(super.getDrawable(paramInt, paramTheme), paramInt);
    AppMethodBeat.o(105904);
    return paramTheme;
  }
  
  public final Drawable getDrawableForDensity(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(105905);
    if (paramInt1 != 0)
    {
      localDrawable = this.yjh.g(this.mResources, paramInt1);
      if (localDrawable != null)
      {
        AppMethodBeat.o(105905);
        return localDrawable;
      }
    }
    Drawable localDrawable = d(super.getDrawableForDensity(paramInt1, paramInt2), paramInt1);
    AppMethodBeat.o(105905);
    return localDrawable;
  }
  
  @TargetApi(22)
  public final Drawable getDrawableForDensity(int paramInt1, int paramInt2, Resources.Theme paramTheme)
  {
    AppMethodBeat.i(105906);
    if (paramInt1 != 0)
    {
      Drawable localDrawable = this.yjh.g(this.mResources, paramInt1);
      if (localDrawable != null)
      {
        AppMethodBeat.o(105906);
        return localDrawable;
      }
    }
    paramTheme = d(super.getDrawableForDensity(paramInt1, paramInt2, paramTheme), paramInt1);
    AppMethodBeat.o(105906);
    return paramTheme;
  }
  
  public final String getQuantityString(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(105897);
    if (this.yji) {
      try
      {
        String str1 = this.mResources.getResourceEntryName(paramInt1);
        AppMethodBeat.o(105897);
        return str1;
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(105897);
        return "";
      }
    }
    if (drj())
    {
      str2 = f.getQuantityString(paramInt1, paramInt2);
      if (str2 != null)
      {
        str2 = str2.toString();
        AppMethodBeat.o(105897);
        return str2;
      }
    }
    String str2 = this.mResources.getQuantityString(paramInt1, paramInt2);
    AppMethodBeat.o(105897);
    return str2;
  }
  
  public final String getQuantityString(int paramInt1, int paramInt2, Object... paramVarArgs)
  {
    AppMethodBeat.i(105898);
    if (this.yji) {
      try
      {
        paramVarArgs = this.mResources.getResourceEntryName(paramInt1);
        AppMethodBeat.o(105898);
        return paramVarArgs;
      }
      catch (Exception paramVarArgs)
      {
        AppMethodBeat.o(105898);
        return "";
      }
    }
    if (drj())
    {
      String str = f.getQuantityString(paramInt1, paramInt2, paramVarArgs);
      if (str != null)
      {
        paramVarArgs = str.toString();
        AppMethodBeat.o(105898);
        return paramVarArgs;
      }
    }
    paramVarArgs = this.mResources.getQuantityString(paramInt1, paramInt2, paramVarArgs);
    AppMethodBeat.o(105898);
    return paramVarArgs;
  }
  
  public final CharSequence getQuantityText(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(105899);
    if (this.yji) {
      try
      {
        String str1 = this.mResources.getResourceEntryName(paramInt1);
        AppMethodBeat.o(105899);
        return str1;
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(105899);
        return "";
      }
    }
    if (drj())
    {
      str2 = f.getQuantityString(paramInt1, paramInt2);
      if (str2 != null)
      {
        str2 = str2.toString();
        AppMethodBeat.o(105899);
        return str2;
      }
    }
    String str2 = this.mResources.getQuantityString(paramInt1, paramInt2);
    AppMethodBeat.o(105899);
    return str2;
  }
  
  public final String getString(int paramInt)
  {
    AppMethodBeat.i(105896);
    if (this.yji) {
      try
      {
        String str = this.mResources.getResourceEntryName(paramInt);
        AppMethodBeat.o(105896);
        return str;
      }
      catch (Exception localException1)
      {
        AppMethodBeat.o(105896);
        return "";
      }
    }
    Object localObject;
    if (drj())
    {
      localObject = f.getString(paramInt);
      if (localObject != null)
      {
        localObject = f.d(paramInt, ((CharSequence)localObject).toString()).toString();
        AppMethodBeat.o(105896);
        return localObject;
      }
    }
    try
    {
      localObject = f.d(paramInt, this.mResources.getString(paramInt));
      if (localObject != null)
      {
        localObject = ((CharSequence)localObject).toString();
        AppMethodBeat.o(105896);
        return localObject;
      }
      localObject = this.mResources.getString(paramInt);
      AppMethodBeat.o(105896);
      return localObject;
    }
    catch (Exception localException2)
    {
      AppMethodBeat.o(105896);
    }
    return "";
  }
  
  public final String[] getStringArray(int paramInt)
  {
    AppMethodBeat.i(105900);
    if (drj())
    {
      arrayOfString = f.getStringArray(paramInt);
      if (arrayOfString != null)
      {
        AppMethodBeat.o(105900);
        return arrayOfString;
      }
    }
    String[] arrayOfString = super.getStringArray(paramInt);
    AppMethodBeat.o(105900);
    return arrayOfString;
  }
  
  public final CharSequence getText(int paramInt)
  {
    AppMethodBeat.i(105894);
    if (this.yji) {
      try
      {
        String str = this.mResources.getResourceEntryName(paramInt);
        AppMethodBeat.o(105894);
        return str;
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(105894);
        return "";
      }
    }
    if (drj())
    {
      localObject = f.d(paramInt, f.getString(paramInt));
      if (localObject != null)
      {
        AppMethodBeat.o(105894);
        return localObject;
      }
    }
    Object localObject = f.d(paramInt, this.mResources.getString(paramInt));
    if (localObject != null)
    {
      localObject = ((CharSequence)localObject).toString();
      AppMethodBeat.o(105894);
      return localObject;
    }
    localObject = this.mResources.getString(paramInt);
    AppMethodBeat.o(105894);
    return localObject;
  }
  
  public final CharSequence getText(int paramInt, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(105895);
    if (this.yji) {
      try
      {
        paramCharSequence = this.mResources.getResourceEntryName(paramInt);
        AppMethodBeat.o(105895);
        return paramCharSequence;
      }
      catch (Exception paramCharSequence)
      {
        AppMethodBeat.o(105895);
        return "";
      }
    }
    if (drj())
    {
      paramCharSequence = f.d(paramInt, f.getString(paramInt));
      if (paramCharSequence != null)
      {
        AppMethodBeat.o(105895);
        return paramCharSequence;
      }
    }
    paramCharSequence = f.d(paramInt, this.mResources.getString(paramInt));
    if (paramCharSequence != null)
    {
      paramCharSequence = paramCharSequence.toString();
      AppMethodBeat.o(105895);
      return paramCharSequence;
    }
    paramCharSequence = this.mResources.getString(paramInt);
    AppMethodBeat.o(105895);
    return paramCharSequence;
  }
  
  public final CharSequence[] getTextArray(int paramInt)
  {
    AppMethodBeat.i(105901);
    Object localObject = getStringArray(paramInt);
    if (localObject != null)
    {
      AppMethodBeat.o(105901);
      return localObject;
    }
    localObject = super.getTextArray(paramInt);
    AppMethodBeat.o(105901);
    return localObject;
  }
  
  public final TypedArray obtainTypedArray(int paramInt)
  {
    AppMethodBeat.i(105902);
    TypedArray localTypedArray = this.mResources.obtainTypedArray(paramInt);
    AppMethodBeat.o(105902);
    return localTypedArray;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(105889);
    ab.i("MicroMsg.MMResources", "locale %s, orientation %s", new Object[] { paramConfiguration.locale, Integer.valueOf(paramConfiguration.orientation) });
    a locala = this.yjj;
    DisplayMetrics localDisplayMetrics = this.mResources.getDisplayMetrics();
    if (a.drc())
    {
      localDisplayMetrics.density = locala.bTx.density;
      localDisplayMetrics.densityDpi = locala.bTx.densityDpi;
      localDisplayMetrics.scaledDensity = locala.bTx.scaledDensity;
      locala.bTx.setTo(localDisplayMetrics);
    }
    super.updateConfiguration(this.yjj.c(paramConfiguration), getDisplayMetrics());
    AppMethodBeat.o(105889);
  }
  
  public final void updateConfiguration(Configuration paramConfiguration, DisplayMetrics paramDisplayMetrics)
  {
    AppMethodBeat.i(105890);
    super.updateConfiguration(paramConfiguration, paramDisplayMetrics);
    if (this.mResources != null) {
      this.mResources.updateConfiguration(paramConfiguration, paramDisplayMetrics);
    }
    a locala;
    int i;
    int j;
    float f1;
    label260:
    label324:
    label332:
    boolean bool2;
    if (this.yjj != null)
    {
      locala = this.yjj;
      i = as.apq(ah.dsP()).getInt(a.yiP, 0);
      af.dDo();
      j = af.dDo().densityDpi;
      if (i == 0) {
        as.apq(ah.dsP()).putInt(a.yiP, j);
      }
      ab.i("MicroMsg.MMDensityManager", "dancy test checkDensity, mDensityDpi:%s,  mCurrentDensityDpi:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      if ((i == 0) || (i == j)) {
        break label994;
      }
      as.apq(ah.dsP()).putInt(a.yiP, j);
      i = 1;
      if (i == 0)
      {
        if (!a.drc()) {
          break label1086;
        }
        i = com.tencent.mm.cb.a.gq(ah.getContext());
        ab.i("MicroMsg.MMDensityManager", "old version text index: %s", new Object[] { Integer.valueOf(i) });
        if ((i == 1) && (!a.drb())) {
          break label1086;
        }
        f1 = 1.0F;
        if (a.drb()) {
          i = 0;
        }
      }
      switch (i)
      {
      default: 
        com.tencent.mm.cb.a.h(ah.getContext(), f1);
        j = 400;
        switch (i)
        {
        default: 
          i = j;
          a.MW(i);
          i = 1;
          if (i != 0)
          {
            ab.i("MicroMsg.MMDensityManager", "checkDensity density change, mIcheckDensitylistener:%s", new Object[] { a.yiX });
            if (a.yiX != null) {
              a.yiX.Bl();
            }
          }
          boolean bool1 = as.apq(ah.dsP()).getBoolean(a.yiR, false);
          bool2 = as.apq(ah.dsP()).getBoolean(a.yiS, false);
          if (bool1) {}
          break;
        }
        break;
      }
    }
    int k;
    try
    {
      localDisplayMetrics = new DisplayMetrics();
      ((WindowManager)ah.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
      i = localDisplayMetrics.widthPixels;
      j = localDisplayMetrics.heightPixels;
      f1 = localDisplayMetrics.density;
      f2 = locala.getDisplayMetrics().density;
      k = (int)(Math.min(i, j) / f1);
      h.qsU.e(17089, new Object[] { Integer.valueOf(i), Integer.valueOf(j), Float.toString(f1), Float.toString(f2), Integer.valueOf(k), Integer.valueOf(af.dDp()), Integer.valueOf(af.dDq()), Integer.valueOf(a.vDR), Integer.valueOf(Math.min(locala.yiN.widthPixels, locala.yiN.heightPixels)), Float.valueOf(a.yiV) });
      as.apq(ah.dsP()).putBoolean(a.yiR, true);
      if (af.dDp() == 0) {
        break label1123;
      }
      i = Math.round(a.vDR / (af.dDp() / 160.0F));
    }
    catch (Exception localException)
    {
      do
      {
        for (;;)
        {
          DisplayMetrics localDisplayMetrics;
          float f2;
          int m;
          ab.printErrStackTrace("MicroMsg.MMDensityManager", localException, "", new Object[0]);
          continue;
          i = 0;
        }
      } while (i < 550);
      k = 1;
    }
    localDisplayMetrics = af.dDo();
    m = Math.round(Math.min(localDisplayMetrics.heightPixels, localDisplayMetrics.widthPixels) / localDisplayMetrics.density);
    if (m >= 550) {
      j = 1;
    }
    label679:
    label1086:
    for (;;)
    {
      if (!bool2)
      {
        j = localDisplayMetrics.widthPixels;
        k = localDisplayMetrics.heightPixels;
        f1 = localDisplayMetrics.density;
        f2 = locala.getDisplayMetrics().density;
        int n = (int)(Math.min(j, k) / f1);
        h.qsU.e(17305, new Object[] { Integer.valueOf(i), Integer.valueOf(m), Integer.valueOf(j), Integer.valueOf(k), Float.toString(f1), Float.toString(f2), Integer.valueOf(n), Integer.valueOf(af.dDp()), Integer.valueOf(af.dDq()), Integer.valueOf(a.vDR), Integer.valueOf(Math.min(locala.yiN.widthPixels, locala.yiN.heightPixels)), Float.valueOf(a.yiV) });
        as.apq(ah.dsP()).putBoolean(a.yiS, true);
      }
      label994:
      label1123:
      label1129:
      do
      {
        if (a.drc())
        {
          locala.dra();
          localDisplayMetrics = new DisplayMetrics();
          ((WindowManager)ah.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
          ab.i("MicroMsg.MMDensityManager", " \n************************************************************************* \nTarget -> %s \nCurrent -> %s \nWindowManager -> %s \nConfiguration -> %s fontScale -> %s \noriginalMetric -> [%s]", new Object[] { a.e(locala.bTx), a.e(paramDisplayMetrics), a.e(localDisplayMetrics), Integer.valueOf(paramConfiguration.densityDpi), Float.valueOf(paramConfiguration.fontScale), locala.yiN });
        }
        AppMethodBeat.o(105890);
        return;
        i = 0;
        break;
        f1 = 0.8F;
        break label260;
        f1 = 1.0F;
        break label260;
        f1 = 1.1F;
        break label260;
        f1 = 1.12F;
        break label260;
        f1 = 1.125F;
        break label260;
        f1 = 1.4F;
        break label260;
        f1 = 1.55F;
        break label260;
        f1 = 1.65F;
        break label260;
        i = 440;
        break label324;
        i = 400;
        break label324;
        i = 360;
        break label324;
        i = 340;
        break label324;
        i = 0;
        break label332;
        j = 0;
        break label1129;
        k = 0;
        if (k != 0) {
          break label679;
        }
      } while (j == 0);
    }
  }
  
  public static final class a<E>
    extends ArrayList<E>
  {
    public final void add(int paramInt, E paramE)
    {
      AppMethodBeat.i(105886);
      ab.i("InterceptArrayList", "InterceptArrayList.add index object");
      AppMethodBeat.o(105886);
    }
    
    public final boolean add(E paramE)
    {
      AppMethodBeat.i(105885);
      ab.i("InterceptArrayList", "InterceptArrayList.add");
      AppMethodBeat.o(105885);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.cc.b
 * JD-Core Version:    0.7.0.1
 */