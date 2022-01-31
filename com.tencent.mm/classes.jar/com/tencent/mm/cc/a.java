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
import com.tencent.mm.sdk.platformtools.y;
import java.io.InputStream;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;

public final class a
  extends Resources
{
  private static Method uaU = null;
  private static Method uaV = null;
  private Resources mResources;
  private e uaR;
  private c uaS;
  private boolean uaT;
  
  /* Error */
  private a(Resources paramResources, e parame, c paramc)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 40	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   5: aload_1
    //   6: invokevirtual 44	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   9: aload_1
    //   10: invokevirtual 48	android/content/res/Resources:getConfiguration	()Landroid/content/res/Configuration;
    //   13: invokespecial 51	android/content/res/Resources:<init>	(Landroid/content/res/AssetManager;Landroid/util/DisplayMetrics;Landroid/content/res/Configuration;)V
    //   16: aload_0
    //   17: aload_2
    //   18: putfield 53	com/tencent/mm/cc/a:uaR	Lcom/tencent/mm/cc/e;
    //   21: aload_1
    //   22: instanceof 2
    //   25: ifeq +112 -> 137
    //   28: aload_0
    //   29: aload_1
    //   30: checkcast 2	com/tencent/mm/cc/a
    //   33: getfield 55	com/tencent/mm/cc/a:mResources	Landroid/content/res/Resources;
    //   36: putfield 55	com/tencent/mm/cc/a:mResources	Landroid/content/res/Resources;
    //   39: aload_0
    //   40: aload_3
    //   41: putfield 57	com/tencent/mm/cc/a:uaS	Lcom/tencent/mm/cc/c;
    //   44: ldc 59
    //   46: invokestatic 65	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   49: astore_3
    //   50: aload_3
    //   51: ifnull +94 -> 145
    //   54: ldc 67
    //   56: ldc 69
    //   58: invokestatic 75	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   61: aload_3
    //   62: ldc 77
    //   64: invokevirtual 81	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   67: astore_2
    //   68: aload_2
    //   69: astore_1
    //   70: aload_2
    //   71: ifnull +76 -> 147
    //   74: aload_2
    //   75: iconst_1
    //   76: invokevirtual 87	java/lang/reflect/Field:setAccessible	(Z)V
    //   79: aload_2
    //   80: aconst_null
    //   81: iconst_0
    //   82: invokestatic 93	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   85: invokevirtual 97	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   88: new 99	com/tencent/mm/compatible/loader/c
    //   91: dup
    //   92: aload_0
    //   93: invokevirtual 100	com/tencent/mm/cc/a:getAssets	()Landroid/content/res/AssetManager;
    //   96: ldc 102
    //   98: aconst_null
    //   99: invokespecial 105	com/tencent/mm/compatible/loader/c:<init>	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   102: astore_1
    //   103: aload_1
    //   104: invokevirtual 109	com/tencent/mm/compatible/loader/c:zy	()Z
    //   107: ifeq +14 -> 121
    //   110: aload_1
    //   111: new 6	com/tencent/mm/cc/a$a
    //   114: dup
    //   115: invokespecial 111	com/tencent/mm/cc/a$a:<init>	()V
    //   118: invokevirtual 114	com/tencent/mm/compatible/loader/c:set	(Ljava/lang/Object;)V
    //   121: aload_0
    //   122: invokestatic 120	com/tencent/mm/sdk/platformtools/ae:cqS	()Landroid/content/SharedPreferences;
    //   125: ldc 122
    //   127: iconst_0
    //   128: invokeinterface 128 3 0
    //   133: putfield 130	com/tencent/mm/cc/a:uaT	Z
    //   136: return
    //   137: aload_0
    //   138: aload_1
    //   139: putfield 55	com/tencent/mm/cc/a:mResources	Landroid/content/res/Resources;
    //   142: goto -103 -> 39
    //   145: aconst_null
    //   146: astore_1
    //   147: ldc 67
    //   149: ldc 132
    //   151: iconst_2
    //   152: anewarray 134	java/lang/Object
    //   155: dup
    //   156: iconst_0
    //   157: aload_3
    //   158: aastore
    //   159: dup
    //   160: iconst_1
    //   161: aload_1
    //   162: aastore
    //   163: invokestatic 138	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   166: goto -78 -> 88
    //   169: astore_1
    //   170: ldc 67
    //   172: ldc 140
    //   174: invokestatic 75	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   177: goto -89 -> 88
    //   180: astore_1
    //   181: ldc 67
    //   183: ldc 142
    //   185: invokestatic 75	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   188: goto -100 -> 88
    //   191: astore_1
    //   192: ldc 67
    //   194: ldc 144
    //   196: invokestatic 75	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   199: goto -111 -> 88
    //   202: astore_1
    //   203: ldc 67
    //   205: ldc 146
    //   207: invokestatic 75	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   210: goto -122 -> 88
    //   213: astore_1
    //   214: ldc 67
    //   216: aload_1
    //   217: ldc 148
    //   219: iconst_0
    //   220: anewarray 134	java/lang/Object
    //   223: invokestatic 152	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   226: goto -105 -> 121
    //   229: astore_1
    //   230: ldc 67
    //   232: aload_1
    //   233: ldc 148
    //   235: iconst_0
    //   236: anewarray 134	java/lang/Object
    //   239: invokestatic 152	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   242: goto -121 -> 121
    //   245: astore_1
    //   246: ldc 67
    //   248: aload_1
    //   249: ldc 148
    //   251: iconst_0
    //   252: anewarray 134	java/lang/Object
    //   255: invokestatic 152	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   258: goto -137 -> 121
    //   261: astore_1
    //   262: ldc 67
    //   264: aload_1
    //   265: invokevirtual 156	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   268: invokestatic 158	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   271: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	272	0	this	a
    //   0	272	1	paramResources	Resources
    //   0	272	2	parame	e
    //   0	272	3	paramc	c
    // Exception table:
    //   from	to	target	type
    //   44	50	169	java/lang/ClassNotFoundException
    //   54	68	169	java/lang/ClassNotFoundException
    //   74	88	169	java/lang/ClassNotFoundException
    //   147	166	169	java/lang/ClassNotFoundException
    //   44	50	180	java/lang/NoSuchFieldException
    //   54	68	180	java/lang/NoSuchFieldException
    //   74	88	180	java/lang/NoSuchFieldException
    //   147	166	180	java/lang/NoSuchFieldException
    //   44	50	191	java/lang/IllegalAccessException
    //   54	68	191	java/lang/IllegalAccessException
    //   74	88	191	java/lang/IllegalAccessException
    //   147	166	191	java/lang/IllegalAccessException
    //   44	50	202	java/lang/IllegalArgumentException
    //   54	68	202	java/lang/IllegalArgumentException
    //   74	88	202	java/lang/IllegalArgumentException
    //   147	166	202	java/lang/IllegalArgumentException
    //   103	121	213	java/lang/NoSuchFieldException
    //   103	121	229	java/lang/IllegalAccessException
    //   103	121	245	java/lang/IllegalArgumentException
    //   121	136	261	java/lang/Exception
  }
  
  public static Resources a(Resources paramResources, Context paramContext)
  {
    return new a(paramResources, e.fl(paramContext), new c());
  }
  
  public static Resources a(Resources paramResources, Context paramContext, String paramString)
  {
    return new a(paramResources, e.br(paramContext, paramString), new c());
  }
  
  public static Drawable c(Resources paramResources, int paramInt)
  {
    return com.tencent.mm.svg.a.e.c(paramResources, paramInt);
  }
  
  private boolean cpv()
  {
    return (this.uaR != null) && (e.cpv());
  }
  
  public static Drawable d(Resources paramResources, int paramInt)
  {
    int i = 1;
    Object localObject3 = new TypedValue();
    paramResources.getValue(paramInt, (TypedValue)localObject3, true);
    if ((((TypedValue)localObject3).type >= 28) && (((TypedValue)localObject3).type <= 31)) {}
    for (;;)
    {
      if (i != 0) {}
      for (Object localObject1 = new ColorDrawable(((TypedValue)localObject3).data);; localObject1 = null)
      {
        if (uaU == null) {}
        Object localObject2;
        try
        {
          localObject2 = Resources.class.getDeclaredMethod("loadXmlResourceParser", new Class[] { String.class, Integer.TYPE, Integer.TYPE, String.class });
          uaU = (Method)localObject2;
          ((Method)localObject2).setAccessible(true);
          if (uaV == null) {}
          localObject1 = ((TypedValue)localObject3).string.toString();
        }
        catch (NoSuchMethodException paramResources)
        {
          try
          {
            localObject2 = AssetManager.class.getDeclaredMethod("openNonAsset", new Class[] { Integer.TYPE, String.class, Integer.TYPE });
            uaV = (Method)localObject2;
            ((Method)localObject2).setAccessible(true);
            localObject2 = localObject1;
            if (localObject1 != null) {
              break label328;
            }
            if (((TypedValue)localObject3).string != null) {
              break label249;
            }
            throw new Resources.NotFoundException("Resource is not a Drawable (color or path): " + localObject3);
          }
          catch (NoSuchMethodException paramResources)
          {
            y.printErrStackTrace("MicroMsg.MMResources", paramResources, "", new Object[0]);
            y.printErrStackTrace("MicroMsg.MMResources", paramResources, "", new Object[0]);
            return null;
          }
          paramResources = paramResources;
          y.printErrStackTrace("MicroMsg.MMResources", paramResources, "", new Object[0]);
          y.printErrStackTrace("MicroMsg.MMResources", paramResources, "", new Object[0]);
          return null;
        }
        label249:
        if (((String)localObject1).endsWith(".xml")) {}
        for (;;)
        {
          try
          {
            localObject3 = (XmlResourceParser)uaU.invoke(paramResources, new Object[] { localObject1, Integer.valueOf(paramInt), Integer.valueOf(((TypedValue)localObject3).assetCookie), "drawable" });
            localObject2 = Drawable.createFromXml(paramResources, (XmlPullParser)localObject3);
            ((XmlResourceParser)localObject3).close();
            label328:
            return localObject2;
          }
          catch (Exception paramResources)
          {
            localObject1 = new Resources.NotFoundException("File " + (String)localObject1 + " from drawable resource ID #0x" + Integer.toHexString(paramInt));
            ((Resources.NotFoundException)localObject1).initCause(paramResources);
            throw ((Throwable)localObject1);
          }
          try
          {
            InputStream localInputStream = (InputStream)uaV.invoke(paramResources.getAssets(), new Object[] { Integer.valueOf(((TypedValue)localObject3).assetCookie), localObject1, Integer.valueOf(2) });
            localObject2 = Drawable.createFromResourceStream(paramResources, (TypedValue)localObject3, localInputStream, (String)localObject1, null);
            localInputStream.close();
          }
          catch (Exception paramResources)
          {
            localObject1 = new Resources.NotFoundException("File " + (String)localObject1 + " from drawable resource ID #0x" + Integer.toHexString(paramInt));
            ((Resources.NotFoundException)localObject1).initCause(paramResources);
            throw ((Throwable)localObject1);
          }
        }
      }
      i = 0;
    }
  }
  
  private Drawable d(Drawable paramDrawable, int paramInt)
  {
    Object localObject = paramDrawable;
    if (paramDrawable == null) {
      y.l("MicroMsg.MMResources", "Notice!!! drawable == null!!!", new Object[0]);
    }
    try
    {
      if (this.uaS.uba.f(this, paramInt)) {
        y.e("MicroMsg.MMResources", "resources name = %s, this resource %s", new Object[] { getResourceName(paramInt), this });
      }
      localObject = new com.tencent.mm.svg.a.c(new Picture(), 0);
      return localObject;
    }
    catch (Exception paramDrawable)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.MMResources", paramDrawable, "WTF", new Object[0]);
      }
    }
  }
  
  public final Drawable getDrawable(int paramInt)
  {
    if (paramInt != 0)
    {
      Drawable localDrawable = this.uaS.e(this.mResources, paramInt);
      if (localDrawable != null) {
        return localDrawable;
      }
    }
    return d(super.getDrawable(paramInt), paramInt);
  }
  
  @TargetApi(21)
  public final Drawable getDrawable(int paramInt, Resources.Theme paramTheme)
  {
    if (paramInt != 0)
    {
      Drawable localDrawable = this.uaS.e(this.mResources, paramInt);
      if (localDrawable != null) {
        return localDrawable;
      }
    }
    return d(super.getDrawable(paramInt, paramTheme), paramInt);
  }
  
  public final Drawable getDrawableForDensity(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 0)
    {
      Drawable localDrawable = this.uaS.e(this.mResources, paramInt1);
      if (localDrawable != null) {
        return localDrawable;
      }
    }
    return d(super.getDrawableForDensity(paramInt1, paramInt2), paramInt1);
  }
  
  @TargetApi(22)
  public final Drawable getDrawableForDensity(int paramInt1, int paramInt2, Resources.Theme paramTheme)
  {
    if (paramInt1 != 0)
    {
      Drawable localDrawable = this.uaS.e(this.mResources, paramInt1);
      if (localDrawable != null) {
        return localDrawable;
      }
    }
    return d(super.getDrawableForDensity(paramInt1, paramInt2, paramTheme), paramInt1);
  }
  
  public final String getQuantityString(int paramInt1, int paramInt2)
  {
    if (this.uaT) {
      try
      {
        String str1 = this.mResources.getResourceEntryName(paramInt1);
        return str1;
      }
      catch (Exception localException)
      {
        return "";
      }
    }
    if (cpv())
    {
      String str2 = e.getQuantityString(paramInt1, paramInt2);
      if (str2 != null) {
        return str2.toString();
      }
    }
    return this.mResources.getQuantityString(paramInt1, paramInt2);
  }
  
  public final String getQuantityString(int paramInt1, int paramInt2, Object... paramVarArgs)
  {
    if (this.uaT) {
      try
      {
        paramVarArgs = this.mResources.getResourceEntryName(paramInt1);
        return paramVarArgs;
      }
      catch (Exception paramVarArgs)
      {
        return "";
      }
    }
    if (cpv())
    {
      String str = e.getQuantityString(paramInt1, paramInt2, paramVarArgs);
      if (str != null) {
        return str.toString();
      }
    }
    return this.mResources.getQuantityString(paramInt1, paramInt2, paramVarArgs);
  }
  
  public final CharSequence getQuantityText(int paramInt1, int paramInt2)
  {
    if (this.uaT) {
      try
      {
        String str1 = this.mResources.getResourceEntryName(paramInt1);
        return str1;
      }
      catch (Exception localException)
      {
        return "";
      }
    }
    if (cpv())
    {
      String str2 = e.getQuantityString(paramInt1, paramInt2);
      if (str2 != null) {
        return str2.toString();
      }
    }
    return this.mResources.getQuantityString(paramInt1, paramInt2);
  }
  
  public final String getString(int paramInt)
  {
    if (this.uaT) {
      try
      {
        String str = this.mResources.getResourceEntryName(paramInt);
        return str;
      }
      catch (Exception localException1)
      {
        return "";
      }
    }
    Object localObject;
    if (cpv())
    {
      localObject = e.getString(paramInt);
      if (localObject != null) {
        return e.d(paramInt, ((CharSequence)localObject).toString()).toString();
      }
    }
    try
    {
      localObject = e.d(paramInt, this.mResources.getString(paramInt));
      if (localObject != null) {
        return ((CharSequence)localObject).toString();
      }
      localObject = this.mResources.getString(paramInt);
      return localObject;
    }
    catch (Exception localException2) {}
    return "";
  }
  
  public final String[] getStringArray(int paramInt)
  {
    if (cpv())
    {
      String[] arrayOfString = e.getStringArray(paramInt);
      if (arrayOfString != null) {
        return arrayOfString;
      }
    }
    return super.getStringArray(paramInt);
  }
  
  public final CharSequence getText(int paramInt)
  {
    if (this.uaT) {}
    CharSequence localCharSequence;
    do
    {
      try
      {
        String str = this.mResources.getResourceEntryName(paramInt);
        return str;
      }
      catch (Exception localException)
      {
        return "";
      }
      if (!cpv()) {
        break;
      }
      localCharSequence = e.d(paramInt, e.getString(paramInt));
      localObject = localCharSequence;
    } while (localCharSequence != null);
    Object localObject = e.d(paramInt, this.mResources.getString(paramInt));
    if (localObject != null) {
      return ((CharSequence)localObject).toString();
    }
    return this.mResources.getString(paramInt);
  }
  
  public final CharSequence getText(int paramInt, CharSequence paramCharSequence)
  {
    if (this.uaT) {}
    CharSequence localCharSequence;
    do
    {
      try
      {
        paramCharSequence = this.mResources.getResourceEntryName(paramInt);
        return paramCharSequence;
      }
      catch (Exception paramCharSequence)
      {
        return "";
      }
      if (!cpv()) {
        break;
      }
      localCharSequence = e.d(paramInt, e.getString(paramInt));
      paramCharSequence = localCharSequence;
    } while (localCharSequence != null);
    paramCharSequence = e.d(paramInt, this.mResources.getString(paramInt));
    if (paramCharSequence != null) {
      return paramCharSequence.toString();
    }
    return this.mResources.getString(paramInt);
  }
  
  public final CharSequence[] getTextArray(int paramInt)
  {
    String[] arrayOfString = getStringArray(paramInt);
    if (arrayOfString != null) {
      return arrayOfString;
    }
    return super.getTextArray(paramInt);
  }
  
  public final TypedArray obtainTypedArray(int paramInt)
  {
    return this.mResources.obtainTypedArray(paramInt);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    y.i("MicroMsg.MMResources", "locale %s, orientation %s", new Object[] { paramConfiguration.locale, Integer.valueOf(paramConfiguration.orientation) });
    super.updateConfiguration(paramConfiguration, this.mResources.getDisplayMetrics());
  }
  
  public final void updateConfiguration(Configuration paramConfiguration, DisplayMetrics paramDisplayMetrics)
  {
    super.updateConfiguration(paramConfiguration, paramDisplayMetrics);
    if (this.mResources != null) {
      this.mResources.updateConfiguration(paramConfiguration, paramDisplayMetrics);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.cc.a
 * JD-Core Version:    0.7.0.1
 */