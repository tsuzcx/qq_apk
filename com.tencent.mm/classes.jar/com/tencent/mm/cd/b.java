package com.tencent.mm.cd;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.ui.aj;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

public final class b
  extends Resources
{
  private static Method GjX = null;
  private static Method GjY = null;
  private g GjT;
  private e GjU;
  private boolean GjV;
  public a GjW;
  private Resources mResources;
  
  private b(Resources paramResources, g paramg, e parame)
  {
    super(paramResources.getAssets(), paramResources.getDisplayMetrics(), paramResources.getConfiguration());
    AppMethodBeat.i(141213);
    this.GjT = paramg;
    if ((paramResources instanceof b)) {}
    for (this.mResources = ((b)paramResources).mResources;; this.mResources = paramResources)
    {
      this.GjU = parame;
      eSD();
      eSE();
      AppMethodBeat.o(141213);
      return;
    }
  }
  
  private b(Resources paramResources, g paramg, e parame, a parama)
  {
    super(paramResources.getAssets(), parama.getDisplayMetrics(), parama.g(paramResources.getConfiguration()));
    AppMethodBeat.i(141214);
    this.GjW = parama;
    this.GjT = paramg;
    if ((paramResources instanceof b)) {
      this.mResources = ((b)paramResources).mResources;
    }
    for (;;)
    {
      this.GjU = parame;
      eSD();
      eSE();
      try
      {
        this.GjV = ai.eUY().getBoolean("ShowStringName", false);
        ac.i("MicroMsg.MMResources", "originalResources:%s mmresource:%s", new Object[] { paramResources, this });
        AppMethodBeat.o(141214);
        return;
        this.mResources = paramResources;
      }
      catch (Exception paramg)
      {
        for (;;)
        {
          ac.e("MicroMsg.MMResources", paramg.getMessage());
        }
      }
    }
  }
  
  public static Resources a(Resources paramResources, Context paramContext)
  {
    AppMethodBeat.i(141218);
    paramResources = a(paramResources, paramContext, false);
    AppMethodBeat.o(141218);
    return paramResources;
  }
  
  public static Resources a(Resources paramResources, Context paramContext, String paramString)
  {
    AppMethodBeat.i(141220);
    paramResources = new b(paramResources, g.bW(paramContext, paramString), new e(), new a(paramResources.getDisplayMetrics()));
    AppMethodBeat.o(141220);
    return paramResources;
  }
  
  public static Resources a(Resources paramResources, Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(141219);
    paramContext = g.ii(paramContext);
    e locale = new e();
    if (paramBoolean)
    {
      paramResources = new b(paramResources, paramContext, locale);
      AppMethodBeat.o(141219);
      return paramResources;
    }
    paramResources = new b(paramResources, paramContext, locale, new a(paramResources.getDisplayMetrics()));
    AppMethodBeat.o(141219);
    return paramResources;
  }
  
  private Drawable d(Drawable paramDrawable, int paramInt)
  {
    AppMethodBeat.i(141235);
    Object localObject = paramDrawable;
    if (paramDrawable == null) {
      ac.m("MicroMsg.MMResources", "Notice!!! drawable == null!!!", new Object[0]);
    }
    try
    {
      if (this.GjU.njc.i(this, paramInt)) {
        ac.e("MicroMsg.MMResources", "resources name = %s, this resource %s", new Object[] { getResourceName(paramInt), this });
      }
      localObject = new com.tencent.mm.svg.a.c(new Picture(), 0);
      AppMethodBeat.o(141235);
      return localObject;
    }
    catch (Exception paramDrawable)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.MMResources", paramDrawable, "WTF", new Object[0]);
      }
    }
  }
  
  public static Drawable e(Resources paramResources, int paramInt)
  {
    AppMethodBeat.i(141238);
    paramResources = com.tencent.mm.svg.a.e.e(paramResources, paramInt);
    AppMethodBeat.o(141238);
    return paramResources;
  }
  
  private boolean eSC()
  {
    AppMethodBeat.i(141221);
    if ((this.GjT != null) && (g.eSC()))
    {
      AppMethodBeat.o(141221);
      return true;
    }
    AppMethodBeat.o(141221);
    return false;
  }
  
  private static void eSD()
  {
    Object localObject = null;
    AppMethodBeat.i(141236);
    try
    {
      Class localClass = Class.forName("android.content.res.MiuiResources");
      if (localClass != null)
      {
        ac.i("MicroMsg.MMResources", "sMiuiThemeEnabled false");
        Field localField = localClass.getDeclaredField("sMiuiThemeEnabled");
        localObject = localField;
        if (localField != null)
        {
          localField.setAccessible(true);
          localField.set(null, Boolean.FALSE);
          AppMethodBeat.o(141236);
          return;
        }
      }
      ac.e("MicroMsg.MMResources", "some thing wrong. %s %s", new Object[] { localClass, localObject });
      AppMethodBeat.o(141236);
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      ac.i("MicroMsg.MMResources", "sMiuiThemeEnabled ClassNotFoundException");
      AppMethodBeat.o(141236);
      return;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      ac.i("MicroMsg.MMResources", "sMiuiThemeEnabled NoSuchFieldException");
      AppMethodBeat.o(141236);
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      ac.i("MicroMsg.MMResources", "sMiuiThemeEnabled IllegalAccessException");
      AppMethodBeat.o(141236);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      ac.i("MicroMsg.MMResources", "sMiuiThemeEnabled IllegalArgumentException");
      AppMethodBeat.o(141236);
    }
  }
  
  private void eSE()
  {
    AppMethodBeat.i(141237);
    com.tencent.mm.compatible.loader.c localc = new com.tencent.mm.compatible.loader.c(getAssets(), "mThemeCookies", null);
    try
    {
      if (localc.Yw()) {
        localc.set(new a());
      }
      AppMethodBeat.o(141237);
      return;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      ac.printErrStackTrace("MicroMsg.MMResources", localNoSuchFieldException, "", new Object[0]);
      AppMethodBeat.o(141237);
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      ac.printErrStackTrace("MicroMsg.MMResources", localIllegalAccessException, "", new Object[0]);
      AppMethodBeat.o(141237);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      ac.printErrStackTrace("MicroMsg.MMResources", localIllegalArgumentException, "", new Object[0]);
      AppMethodBeat.o(141237);
    }
  }
  
  public static Drawable f(Resources paramResources, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(141239);
    Object localObject3 = new TypedValue();
    paramResources.getValue(paramInt, (TypedValue)localObject3, true);
    Object localObject1 = null;
    if ((((TypedValue)localObject3).type >= 28) && (((TypedValue)localObject3).type <= 31)) {}
    for (;;)
    {
      if (i != 0) {
        localObject1 = new ColorDrawable(((TypedValue)localObject3).data);
      }
      if (GjX == null) {}
      Object localObject2;
      try
      {
        localObject2 = Resources.class.getDeclaredMethod("loadXmlResourceParser", new Class[] { String.class, Integer.TYPE, Integer.TYPE, String.class });
        GjX = (Method)localObject2;
        ((Method)localObject2).setAccessible(true);
        if (GjY == null) {}
        localObject1 = ((TypedValue)localObject3).string.toString();
      }
      catch (NoSuchMethodException paramResources)
      {
        try
        {
          localObject2 = AssetManager.class.getDeclaredMethod("openNonAsset", new Class[] { Integer.TYPE, String.class, Integer.TYPE });
          GjY = (Method)localObject2;
          ((Method)localObject2).setAccessible(true);
          localObject2 = localObject1;
          if (localObject1 != null) {
            break label361;
          }
          if (((TypedValue)localObject3).string != null) {
            break label281;
          }
          paramResources = new Resources.NotFoundException("Resource is not a Drawable (color or path): ".concat(String.valueOf(localObject3)));
          AppMethodBeat.o(141239);
          throw paramResources;
        }
        catch (NoSuchMethodException paramResources)
        {
          ac.printErrStackTrace("MicroMsg.MMResources", paramResources, "", new Object[0]);
          ac.printErrStackTrace("MicroMsg.MMResources", paramResources, "", new Object[0]);
          AppMethodBeat.o(141239);
          return null;
        }
        paramResources = paramResources;
        ac.printErrStackTrace("MicroMsg.MMResources", paramResources, "", new Object[0]);
        ac.printErrStackTrace("MicroMsg.MMResources", paramResources, "", new Object[0]);
        AppMethodBeat.o(141239);
        return null;
      }
      label281:
      if (((String)localObject1).endsWith(".xml")) {}
      for (;;)
      {
        try
        {
          localObject3 = (XmlResourceParser)GjX.invoke(paramResources, new Object[] { localObject1, Integer.valueOf(paramInt), Integer.valueOf(((TypedValue)localObject3).assetCookie), "drawable" });
          localObject2 = Drawable.createFromXml(paramResources, (XmlPullParser)localObject3);
          ((XmlResourceParser)localObject3).close();
          label361:
          AppMethodBeat.o(141239);
          return localObject2;
        }
        catch (Exception paramResources)
        {
          localObject1 = new Resources.NotFoundException("File " + (String)localObject1 + " from drawable resource ID #0x" + Integer.toHexString(paramInt));
          ((Resources.NotFoundException)localObject1).initCause(paramResources);
          AppMethodBeat.o(141239);
          throw ((Throwable)localObject1);
        }
        try
        {
          InputStream localInputStream = (InputStream)GjY.invoke(paramResources.getAssets(), new Object[] { Integer.valueOf(((TypedValue)localObject3).assetCookie), localObject1, Integer.valueOf(2) });
          localObject2 = Drawable.createFromResourceStream(paramResources, (TypedValue)localObject3, localInputStream, (String)localObject1, null);
          localInputStream.close();
        }
        catch (Exception paramResources)
        {
          localObject1 = new Resources.NotFoundException("File " + (String)localObject1 + " from drawable resource ID #0x" + Integer.toHexString(paramInt));
          ((Resources.NotFoundException)localObject1).initCause(paramResources);
          AppMethodBeat.o(141239);
          throw ((Throwable)localObject1);
        }
      }
      i = 0;
    }
  }
  
  public final DisplayMetrics getDisplayMetrics()
  {
    AppMethodBeat.i(141215);
    if (this.GjW != null)
    {
      localDisplayMetrics = this.GjW.getDisplayMetrics();
      AppMethodBeat.o(141215);
      return localDisplayMetrics;
    }
    DisplayMetrics localDisplayMetrics = this.mResources.getDisplayMetrics();
    AppMethodBeat.o(141215);
    return localDisplayMetrics;
  }
  
  public final Drawable getDrawable(int paramInt)
  {
    AppMethodBeat.i(141231);
    if (paramInt != 0)
    {
      localDrawable = this.GjU.g(this.mResources, paramInt);
      if (localDrawable != null)
      {
        AppMethodBeat.o(141231);
        return localDrawable;
      }
    }
    Drawable localDrawable = d(super.getDrawable(paramInt), paramInt);
    AppMethodBeat.o(141231);
    return localDrawable;
  }
  
  @TargetApi(21)
  public final Drawable getDrawable(int paramInt, Resources.Theme paramTheme)
  {
    AppMethodBeat.i(141232);
    if (paramInt != 0)
    {
      Drawable localDrawable = this.GjU.g(this.mResources, paramInt);
      if (localDrawable != null)
      {
        AppMethodBeat.o(141232);
        return localDrawable;
      }
    }
    paramTheme = d(super.getDrawable(paramInt, paramTheme), paramInt);
    AppMethodBeat.o(141232);
    return paramTheme;
  }
  
  public final Drawable getDrawableForDensity(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(141233);
    if (paramInt1 != 0)
    {
      localDrawable = this.GjU.g(this.mResources, paramInt1);
      if (localDrawable != null)
      {
        AppMethodBeat.o(141233);
        return localDrawable;
      }
    }
    Drawable localDrawable = d(super.getDrawableForDensity(paramInt1, paramInt2), paramInt1);
    AppMethodBeat.o(141233);
    return localDrawable;
  }
  
  @TargetApi(22)
  public final Drawable getDrawableForDensity(int paramInt1, int paramInt2, Resources.Theme paramTheme)
  {
    AppMethodBeat.i(141234);
    if (paramInt1 != 0)
    {
      Drawable localDrawable = this.GjU.g(this.mResources, paramInt1);
      if (localDrawable != null)
      {
        AppMethodBeat.o(141234);
        return localDrawable;
      }
    }
    paramTheme = d(super.getDrawableForDensity(paramInt1, paramInt2, paramTheme), paramInt1);
    AppMethodBeat.o(141234);
    return paramTheme;
  }
  
  public final String getQuantityString(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(141225);
    if (this.GjV) {
      try
      {
        String str1 = this.mResources.getResourceEntryName(paramInt1);
        AppMethodBeat.o(141225);
        return str1;
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(141225);
        return "";
      }
    }
    if (eSC())
    {
      str2 = g.getQuantityString(paramInt1, paramInt2);
      if (str2 != null)
      {
        str2 = str2.toString();
        AppMethodBeat.o(141225);
        return str2;
      }
    }
    String str2 = this.mResources.getQuantityString(paramInt1, paramInt2);
    AppMethodBeat.o(141225);
    return str2;
  }
  
  public final String getQuantityString(int paramInt1, int paramInt2, Object... paramVarArgs)
  {
    AppMethodBeat.i(141226);
    if (this.GjV) {
      try
      {
        paramVarArgs = this.mResources.getResourceEntryName(paramInt1);
        AppMethodBeat.o(141226);
        return paramVarArgs;
      }
      catch (Exception paramVarArgs)
      {
        AppMethodBeat.o(141226);
        return "";
      }
    }
    if (eSC())
    {
      String str = g.getQuantityString(paramInt1, paramInt2, paramVarArgs);
      if (str != null)
      {
        paramVarArgs = str.toString();
        AppMethodBeat.o(141226);
        return paramVarArgs;
      }
    }
    paramVarArgs = this.mResources.getQuantityString(paramInt1, paramInt2, paramVarArgs);
    AppMethodBeat.o(141226);
    return paramVarArgs;
  }
  
  public final CharSequence getQuantityText(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(141227);
    if (this.GjV) {
      try
      {
        String str1 = this.mResources.getResourceEntryName(paramInt1);
        AppMethodBeat.o(141227);
        return str1;
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(141227);
        return "";
      }
    }
    if (eSC())
    {
      str2 = g.getQuantityString(paramInt1, paramInt2);
      if (str2 != null)
      {
        str2 = str2.toString();
        AppMethodBeat.o(141227);
        return str2;
      }
    }
    String str2 = this.mResources.getQuantityString(paramInt1, paramInt2);
    AppMethodBeat.o(141227);
    return str2;
  }
  
  public final String getString(int paramInt)
  {
    AppMethodBeat.i(141224);
    if (this.GjV) {
      try
      {
        String str = this.mResources.getResourceEntryName(paramInt);
        AppMethodBeat.o(141224);
        return str;
      }
      catch (Exception localException1)
      {
        AppMethodBeat.o(141224);
        return "";
      }
    }
    Object localObject;
    if (eSC())
    {
      localObject = g.getString(paramInt);
      if (localObject != null)
      {
        localObject = g.ai(((CharSequence)localObject).toString()).toString();
        AppMethodBeat.o(141224);
        return localObject;
      }
    }
    try
    {
      localObject = g.ai(this.mResources.getString(paramInt));
      if (localObject != null)
      {
        localObject = ((CharSequence)localObject).toString();
        AppMethodBeat.o(141224);
        return localObject;
      }
      localObject = this.mResources.getString(paramInt);
      AppMethodBeat.o(141224);
      return localObject;
    }
    catch (Exception localException2)
    {
      AppMethodBeat.o(141224);
    }
    return "";
  }
  
  public final String[] getStringArray(int paramInt)
  {
    AppMethodBeat.i(141228);
    if (eSC())
    {
      arrayOfString = g.getStringArray(paramInt);
      if (arrayOfString != null)
      {
        AppMethodBeat.o(141228);
        return arrayOfString;
      }
    }
    String[] arrayOfString = super.getStringArray(paramInt);
    AppMethodBeat.o(141228);
    return arrayOfString;
  }
  
  public final CharSequence getText(int paramInt)
  {
    AppMethodBeat.i(141222);
    if (this.GjV) {
      try
      {
        String str = this.mResources.getResourceEntryName(paramInt);
        AppMethodBeat.o(141222);
        return str;
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(141222);
        return "";
      }
    }
    if (eSC())
    {
      localObject = g.ai(g.getString(paramInt));
      if (localObject != null)
      {
        AppMethodBeat.o(141222);
        return localObject;
      }
    }
    Object localObject = g.ai(this.mResources.getString(paramInt));
    if (localObject != null)
    {
      localObject = ((CharSequence)localObject).toString();
      AppMethodBeat.o(141222);
      return localObject;
    }
    localObject = this.mResources.getString(paramInt);
    AppMethodBeat.o(141222);
    return localObject;
  }
  
  public final CharSequence getText(int paramInt, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(141223);
    if (this.GjV) {
      try
      {
        paramCharSequence = this.mResources.getResourceEntryName(paramInt);
        AppMethodBeat.o(141223);
        return paramCharSequence;
      }
      catch (Exception paramCharSequence)
      {
        AppMethodBeat.o(141223);
        return "";
      }
    }
    if (eSC())
    {
      paramCharSequence = g.ai(g.getString(paramInt));
      if (paramCharSequence != null)
      {
        AppMethodBeat.o(141223);
        return paramCharSequence;
      }
    }
    paramCharSequence = g.ai(this.mResources.getString(paramInt));
    if (paramCharSequence != null)
    {
      paramCharSequence = paramCharSequence.toString();
      AppMethodBeat.o(141223);
      return paramCharSequence;
    }
    paramCharSequence = this.mResources.getString(paramInt);
    AppMethodBeat.o(141223);
    return paramCharSequence;
  }
  
  public final CharSequence[] getTextArray(int paramInt)
  {
    AppMethodBeat.i(141229);
    Object localObject = getStringArray(paramInt);
    if (localObject != null)
    {
      AppMethodBeat.o(141229);
      return localObject;
    }
    localObject = super.getTextArray(paramInt);
    AppMethodBeat.o(141229);
    return localObject;
  }
  
  public final TypedArray obtainTypedArray(int paramInt)
  {
    AppMethodBeat.i(141230);
    TypedArray localTypedArray = this.mResources.obtainTypedArray(paramInt);
    AppMethodBeat.o(141230);
    return localTypedArray;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(141216);
    ac.i("MicroMsg.MMResources", "dancy test locale %s, orientation %s, uimode:%s", new Object[] { paramConfiguration.locale, Integer.valueOf(paramConfiguration.orientation), Integer.valueOf(paramConfiguration.uiMode) });
    if (ai.cin())
    {
      c.a(paramConfiguration, this.mResources);
      if (this.mResources != null) {
        this.mResources.getConfiguration().updateFrom(paramConfiguration);
      }
    }
    a locala = this.GjW;
    DisplayMetrics localDisplayMetrics = this.mResources.getDisplayMetrics();
    if (a.eSv())
    {
      localDisplayMetrics.density = locala.aHC.density;
      localDisplayMetrics.densityDpi = locala.aHC.densityDpi;
      localDisplayMetrics.scaledDensity = locala.aHC.scaledDensity;
      locala.aHC.setTo(localDisplayMetrics);
    }
    super.updateConfiguration(this.GjW.g(paramConfiguration), getDisplayMetrics());
    AppMethodBeat.o(141216);
  }
  
  public final void updateConfiguration(Configuration paramConfiguration, DisplayMetrics paramDisplayMetrics)
  {
    AppMethodBeat.i(141217);
    super.updateConfiguration(paramConfiguration, paramDisplayMetrics);
    if (ai.cin())
    {
      c.a(paramConfiguration, this.mResources);
      if (this.mResources != null)
      {
        this.mResources.getConfiguration().updateFrom(paramConfiguration);
        this.mResources.updateConfiguration(paramConfiguration, paramDisplayMetrics);
      }
    }
    a locala;
    int i;
    int j;
    float f1;
    label284:
    label348:
    label356:
    boolean bool2;
    if (this.GjW != null)
    {
      locala = this.GjW;
      i = aw.aKT(ai.eUX()).getInt(a.GjC, 0);
      aj.fhB();
      j = aj.fhB().densityDpi;
      if (i == 0) {
        aw.aKT(ai.eUX()).putInt(a.GjC, j);
      }
      ac.i("MicroMsg.MMDensityManager", "dancy test checkDensity, mDensityDpi:%s,  mCurrentDensityDpi:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      if ((i == 0) || (i == j)) {
        break label1018;
      }
      aw.aKT(ai.eUX()).putInt(a.GjC, j);
      i = 1;
      if (i == 0)
      {
        if (!a.eSv()) {
          break label1110;
        }
        i = com.tencent.mm.cc.a.ia(ai.getContext());
        ac.i("MicroMsg.MMDensityManager", "old version text index: %s", new Object[] { Integer.valueOf(i) });
        if ((i == 1) && (!a.eSu())) {
          break label1110;
        }
        f1 = 1.0F;
        if (a.eSu()) {
          i = 0;
        }
      }
      switch (i)
      {
      default: 
        com.tencent.mm.cc.a.h(ai.getContext(), f1);
        j = 400;
        switch (i)
        {
        default: 
          i = j;
          a.Ya(i);
          i = 1;
          if (i != 0)
          {
            ac.i("MicroMsg.MMDensityManager", "checkDensity density change, mIcheckDensitylistener:%s", new Object[] { a.GjK });
            if (a.GjK != null) {
              a.GjK.Kx();
            }
          }
          boolean bool1 = aw.aKT(ai.eUX()).getBoolean(a.GjE, false);
          bool2 = aw.aKT(ai.eUX()).getBoolean(a.GjF, false);
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
      ((WindowManager)ai.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
      i = localDisplayMetrics.widthPixels;
      j = localDisplayMetrics.heightPixels;
      f1 = localDisplayMetrics.density;
      f2 = locala.getDisplayMetrics().density;
      k = (int)(Math.min(i, j) / f1);
      h.wUl.f(17089, new Object[] { Integer.valueOf(i), Integer.valueOf(j), Float.toString(f1), Float.toString(f2), Integer.valueOf(k), Integer.valueOf(aj.fhC()), Integer.valueOf(aj.fhD()), Integer.valueOf(a.oPa), Integer.valueOf(Math.min(locala.GjA.widthPixels, locala.GjA.heightPixels)), Float.valueOf(a.GjI) });
      aw.aKT(ai.eUX()).putBoolean(a.GjE, true);
      if (aj.fhC() == 0) {
        break label1148;
      }
      i = Math.round(a.oPa / (aj.fhC() / 160.0F));
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
          ac.printErrStackTrace("MicroMsg.MMDensityManager", localException, "", new Object[0]);
          continue;
          i = 0;
        }
      } while (i < 550);
      k = 1;
    }
    localDisplayMetrics = aj.fhB();
    m = Math.round(Math.min(localDisplayMetrics.heightPixels, localDisplayMetrics.widthPixels) / localDisplayMetrics.density);
    if (m >= 550) {
      j = 1;
    }
    label703:
    label1110:
    for (;;)
    {
      if (!bool2)
      {
        j = localDisplayMetrics.widthPixels;
        k = localDisplayMetrics.heightPixels;
        f1 = localDisplayMetrics.density;
        f2 = locala.getDisplayMetrics().density;
        int n = (int)(Math.min(j, k) / f1);
        h.wUl.f(17305, new Object[] { Integer.valueOf(i), Integer.valueOf(m), Integer.valueOf(j), Integer.valueOf(k), Float.toString(f1), Float.toString(f2), Integer.valueOf(n), Integer.valueOf(aj.fhC()), Integer.valueOf(aj.fhD()), Integer.valueOf(a.oPa), Integer.valueOf(Math.min(locala.GjA.widthPixels, locala.GjA.heightPixels)), Float.valueOf(a.GjI) });
        aw.aKT(ai.eUX()).putBoolean(a.GjF, true);
      }
      label1018:
      label1148:
      do
      {
        if (a.eSv())
        {
          locala.eSt();
          localDisplayMetrics = new DisplayMetrics();
          ((WindowManager)ai.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
          ac.i("MicroMsg.MMDensityManager", " \n************************************************************************* \nTarget -> %s \nCurrent -> %s \nWindowManager -> %s \nConfiguration -> %s fontScale -> %s \noriginalMetric -> [%s]", new Object[] { a.d(locala.aHC), a.d(paramDisplayMetrics), a.d(localDisplayMetrics), Integer.valueOf(paramConfiguration.densityDpi), Float.valueOf(paramConfiguration.fontScale), locala.GjA });
        }
        AppMethodBeat.o(141217);
        return;
        i = 0;
        break;
        f1 = 0.8F;
        break label284;
        f1 = 1.0F;
        break label284;
        f1 = 1.1F;
        break label284;
        f1 = 1.12F;
        break label284;
        f1 = 1.125F;
        break label284;
        f1 = 1.4F;
        break label284;
        f1 = 1.55F;
        break label284;
        f1 = 1.65F;
        break label284;
        i = 440;
        break label348;
        i = 400;
        break label348;
        i = 360;
        break label348;
        i = 340;
        break label348;
        i = 0;
        break label356;
        j = 0;
        break label1154;
        k = 0;
        if (k != 0) {
          break label703;
        }
      } while (j == 0);
    }
  }
  
  public static final class a<E>
    extends ArrayList<E>
  {
    public final void add(int paramInt, E paramE)
    {
      AppMethodBeat.i(141212);
      ac.i("InterceptArrayList", "InterceptArrayList.add index object");
      AppMethodBeat.o(141212);
    }
    
    public final boolean add(E paramE)
    {
      AppMethodBeat.i(141211);
      ac.i("InterceptArrayList", "InterceptArrayList.add");
      AppMethodBeat.o(141211);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.cd.b
 * JD-Core Version:    0.7.0.1
 */