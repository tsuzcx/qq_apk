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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.ui.al;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

public final class b
  extends Resources
{
  private static Method HVK = null;
  private static Method HVL = null;
  private g HVG;
  private e HVH;
  private boolean HVI;
  public a HVJ;
  private Resources mResources;
  
  private b(Resources paramResources, g paramg, e parame)
  {
    super(paramResources.getAssets(), paramResources.getDisplayMetrics(), paramResources.getConfiguration());
    AppMethodBeat.i(141213);
    this.HVG = paramg;
    if ((paramResources instanceof b)) {}
    for (this.mResources = ((b)paramResources).mResources;; this.mResources = paramResources)
    {
      this.HVH = parame;
      fhW();
      fhX();
      AppMethodBeat.o(141213);
      return;
    }
  }
  
  private b(Resources paramResources, g paramg, e parame, a parama)
  {
    super(paramResources.getAssets(), parama.getDisplayMetrics(), parama.g(paramResources.getConfiguration()));
    AppMethodBeat.i(141214);
    this.HVJ = parama;
    this.HVG = paramg;
    if ((paramResources instanceof b)) {
      this.mResources = ((b)paramResources).mResources;
    }
    for (;;)
    {
      this.HVH = parame;
      fhW();
      fhX();
      try
      {
        this.HVI = aj.fkD().getBoolean("ShowStringName", false);
        ad.i("MicroMsg.MMResources", "originalResources:%s mmresource:%s", new Object[] { paramResources, this });
        AppMethodBeat.o(141214);
        return;
        this.mResources = paramResources;
      }
      catch (Exception paramg)
      {
        for (;;)
        {
          ad.e("MicroMsg.MMResources", paramg.getMessage());
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
    paramResources = new b(paramResources, g.cb(paramContext, paramString), new e(), new a(paramResources.getDisplayMetrics()));
    AppMethodBeat.o(141220);
    return paramResources;
  }
  
  public static Resources a(Resources paramResources, Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(141219);
    paramContext = g.ir(paramContext);
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
      ad.m("MicroMsg.MMResources", "Notice!!! drawable == null!!!", new Object[0]);
    }
    try
    {
      if (this.HVH.nJy.i(this, paramInt)) {
        ad.e("MicroMsg.MMResources", "resources name = %s, this resource %s", new Object[] { getResourceName(paramInt), this });
      }
      localObject = new com.tencent.mm.svg.a.c(new Picture(), 0);
      AppMethodBeat.o(141235);
      return localObject;
    }
    catch (Exception paramDrawable)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.MMResources", paramDrawable, "WTF", new Object[0]);
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
      if (HVK == null) {}
      Object localObject2;
      try
      {
        localObject2 = Resources.class.getDeclaredMethod("loadXmlResourceParser", new Class[] { String.class, Integer.TYPE, Integer.TYPE, String.class });
        HVK = (Method)localObject2;
        ((Method)localObject2).setAccessible(true);
        if (HVL == null) {}
        localObject1 = ((TypedValue)localObject3).string.toString();
      }
      catch (NoSuchMethodException paramResources)
      {
        try
        {
          localObject2 = AssetManager.class.getDeclaredMethod("openNonAsset", new Class[] { Integer.TYPE, String.class, Integer.TYPE });
          HVL = (Method)localObject2;
          ((Method)localObject2).setAccessible(true);
          localObject2 = localObject1;
          if (localObject1 != null) {
            break label350;
          }
          if (((TypedValue)localObject3).string != null) {
            break label270;
          }
          paramResources = new Resources.NotFoundException("Resource is not a Drawable (color or path): ".concat(String.valueOf(localObject3)));
          AppMethodBeat.o(141239);
          throw paramResources;
        }
        catch (NoSuchMethodException paramResources)
        {
          ad.printErrStackTrace("MicroMsg.MMResources", paramResources, "", new Object[0]);
          ad.printErrStackTrace("MicroMsg.MMResources", paramResources, "", new Object[0]);
          AppMethodBeat.o(141239);
          return null;
        }
        paramResources = paramResources;
        ad.printErrStackTrace("MicroMsg.MMResources", paramResources, "", new Object[0]);
        ad.printErrStackTrace("MicroMsg.MMResources", paramResources, "", new Object[0]);
        AppMethodBeat.o(141239);
        return null;
      }
      label270:
      if (((String)localObject1).endsWith(".xml")) {}
      for (;;)
      {
        try
        {
          localObject3 = (XmlResourceParser)HVK.invoke(paramResources, new Object[] { localObject1, Integer.valueOf(paramInt), Integer.valueOf(((TypedValue)localObject3).assetCookie), "drawable" });
          localObject2 = Drawable.createFromXml(paramResources, (XmlPullParser)localObject3);
          ((XmlResourceParser)localObject3).close();
          label350:
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
          InputStream localInputStream = (InputStream)HVL.invoke(paramResources.getAssets(), new Object[] { Integer.valueOf(((TypedValue)localObject3).assetCookie), localObject1, Integer.valueOf(2) });
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
  
  private boolean fhV()
  {
    AppMethodBeat.i(141221);
    if ((this.HVG != null) && (g.fhV()))
    {
      AppMethodBeat.o(141221);
      return true;
    }
    AppMethodBeat.o(141221);
    return false;
  }
  
  private static void fhW()
  {
    Object localObject = null;
    AppMethodBeat.i(141236);
    try
    {
      Class localClass = Class.forName("android.content.res.MiuiResources");
      if (localClass != null)
      {
        ad.i("MicroMsg.MMResources", "sMiuiThemeEnabled false");
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
      ad.e("MicroMsg.MMResources", "some thing wrong. %s %s", new Object[] { localClass, localObject });
      AppMethodBeat.o(141236);
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      ad.i("MicroMsg.MMResources", "sMiuiThemeEnabled ClassNotFoundException");
      AppMethodBeat.o(141236);
      return;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      ad.i("MicroMsg.MMResources", "sMiuiThemeEnabled NoSuchFieldException");
      AppMethodBeat.o(141236);
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      ad.i("MicroMsg.MMResources", "sMiuiThemeEnabled IllegalAccessException");
      AppMethodBeat.o(141236);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      ad.i("MicroMsg.MMResources", "sMiuiThemeEnabled IllegalArgumentException");
      AppMethodBeat.o(141236);
    }
  }
  
  private void fhX()
  {
    AppMethodBeat.i(141237);
    com.tencent.mm.compatible.loader.c localc = new com.tencent.mm.compatible.loader.c(getAssets(), "mThemeCookies", null);
    try
    {
      if (localc.aaY()) {
        localc.set(new a());
      }
      AppMethodBeat.o(141237);
      return;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      ad.printErrStackTrace("MicroMsg.MMResources", localNoSuchFieldException, "", new Object[0]);
      AppMethodBeat.o(141237);
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      ad.printErrStackTrace("MicroMsg.MMResources", localIllegalAccessException, "", new Object[0]);
      AppMethodBeat.o(141237);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      ad.printErrStackTrace("MicroMsg.MMResources", localIllegalArgumentException, "", new Object[0]);
      AppMethodBeat.o(141237);
    }
  }
  
  public final DisplayMetrics getDisplayMetrics()
  {
    AppMethodBeat.i(141215);
    if (this.HVJ != null)
    {
      localDisplayMetrics = this.HVJ.getDisplayMetrics();
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
      localDrawable = this.HVH.g(this.mResources, paramInt);
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
      Drawable localDrawable = this.HVH.g(this.mResources, paramInt);
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
      localDrawable = this.HVH.g(this.mResources, paramInt1);
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
      Drawable localDrawable = this.HVH.g(this.mResources, paramInt1);
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
    if (this.HVI) {
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
    if (fhV())
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
    if (this.HVI) {
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
    if (fhV())
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
    if (this.HVI) {
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
    if (fhV())
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
    if (this.HVI) {
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
    if (fhV())
    {
      localObject = g.getString(paramInt);
      if (localObject != null)
      {
        localObject = g.ah(((CharSequence)localObject).toString()).toString();
        AppMethodBeat.o(141224);
        return localObject;
      }
    }
    try
    {
      localObject = g.ah(this.mResources.getString(paramInt));
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
    if (fhV())
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
    if (this.HVI) {
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
    if (fhV())
    {
      localObject = g.ah(g.getString(paramInt));
      if (localObject != null)
      {
        AppMethodBeat.o(141222);
        return localObject;
      }
    }
    Object localObject = g.ah(this.mResources.getString(paramInt));
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
    if (this.HVI) {
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
    if (fhV())
    {
      paramCharSequence = g.ah(g.getString(paramInt));
      if (paramCharSequence != null)
      {
        AppMethodBeat.o(141223);
        return paramCharSequence;
      }
    }
    paramCharSequence = g.ah(this.mResources.getString(paramInt));
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
    ad.i("MicroMsg.MMResources", "dancy test locale %s, orientation %s, uimode:%s", new Object[] { paramConfiguration.locale, Integer.valueOf(paramConfiguration.orientation), Integer.valueOf(paramConfiguration.uiMode) });
    if (((al.fxZ()) && (aj.cmR())) || (!al.fxZ()))
    {
      c.a(paramConfiguration, this.mResources);
      if (this.mResources != null) {
        this.mResources.getConfiguration().updateFrom(paramConfiguration);
      }
    }
    Object localObject = this.HVJ;
    DisplayMetrics localDisplayMetrics = this.mResources.getDisplayMetrics();
    if (a.fhO())
    {
      localDisplayMetrics.density = ((a)localObject).aJt.density;
      localDisplayMetrics.densityDpi = ((a)localObject).aJt.densityDpi;
      localDisplayMetrics.scaledDensity = ((a)localObject).aJt.scaledDensity;
      ((a)localObject).aJt.setTo(localDisplayMetrics);
    }
    localObject = new Configuration(getConfiguration());
    ((Configuration)localObject).fontScale += 0.1F;
    super.updateConfiguration((Configuration)localObject, getDisplayMetrics());
    super.updateConfiguration(this.HVJ.g(paramConfiguration), getDisplayMetrics());
    AppMethodBeat.o(141216);
  }
  
  public final void updateConfiguration(Configuration paramConfiguration, DisplayMetrics paramDisplayMetrics)
  {
    AppMethodBeat.i(141217);
    super.updateConfiguration(paramConfiguration, paramDisplayMetrics);
    if (((al.fxZ()) && (aj.cmR())) || (!al.fxZ()))
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
    label296:
    label360:
    label368:
    boolean bool2;
    if (this.HVJ != null)
    {
      locala = this.HVJ;
      i = ax.aQz(aj.fkC()).getInt(a.HVp, 0);
      al.fxO();
      j = al.fxO().densityDpi;
      if (i == 0) {
        ax.aQz(aj.fkC()).putInt(a.HVp, j);
      }
      ad.i("MicroMsg.MMDensityManager", "dancy test checkDensity, mDensityDpi:%s,  mCurrentDensityDpi:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      if ((i == 0) || (i == j)) {
        break label1030;
      }
      ax.aQz(aj.fkC()).putInt(a.HVp, j);
      i = 1;
      if (i == 0)
      {
        if (!a.fhO()) {
          break label1122;
        }
        i = com.tencent.mm.cc.a.ij(aj.getContext());
        ad.i("MicroMsg.MMDensityManager", "old version text index: %s", new Object[] { Integer.valueOf(i) });
        if ((i == 1) && (!a.fhN())) {
          break label1122;
        }
        f1 = 1.0F;
        if (a.fhN()) {
          i = 0;
        }
      }
      switch (i)
      {
      default: 
        com.tencent.mm.cc.a.h(aj.getContext(), f1);
        j = 400;
        switch (i)
        {
        default: 
          i = j;
          a.aad(i);
          i = 1;
          if (i != 0)
          {
            ad.i("MicroMsg.MMDensityManager", "checkDensity density change, mIcheckDensitylistener:%s", new Object[] { a.HVx });
            if (a.HVx != null) {
              a.HVx.Mb();
            }
          }
          boolean bool1 = ax.aQz(aj.fkC()).getBoolean(a.HVr, false);
          bool2 = ax.aQz(aj.fkC()).getBoolean(a.HVs, false);
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
      ((WindowManager)aj.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
      i = localDisplayMetrics.widthPixels;
      j = localDisplayMetrics.heightPixels;
      f1 = localDisplayMetrics.density;
      f2 = locala.getDisplayMetrics().density;
      k = (int)(Math.min(i, j) / f1);
      com.tencent.mm.plugin.report.service.g.yhR.f(17089, new Object[] { Integer.valueOf(i), Integer.valueOf(j), Float.toString(f1), Float.toString(f2), Integer.valueOf(k), Integer.valueOf(al.fxP()), Integer.valueOf(al.fxQ()), Integer.valueOf(a.psI), Integer.valueOf(Math.min(locala.HVn.widthPixels, locala.HVn.heightPixels)), Float.valueOf(a.HVv) });
      ax.aQz(aj.fkC()).putBoolean(a.HVr, true);
      if (al.fxP() == 0) {
        break label1160;
      }
      i = Math.round(a.psI / (al.fxP() / 160.0F));
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
          ad.printErrStackTrace("MicroMsg.MMDensityManager", localException, "", new Object[0]);
          continue;
          i = 0;
        }
      } while (i < 550);
      k = 1;
    }
    localDisplayMetrics = al.fxO();
    m = Math.round(Math.min(localDisplayMetrics.heightPixels, localDisplayMetrics.widthPixels) / localDisplayMetrics.density);
    if (m >= 550) {
      j = 1;
    }
    label1030:
    label1160:
    label1166:
    for (;;)
    {
      label715:
      if (!bool2)
      {
        j = localDisplayMetrics.widthPixels;
        k = localDisplayMetrics.heightPixels;
        f1 = localDisplayMetrics.density;
        f2 = locala.getDisplayMetrics().density;
        int n = (int)(Math.min(j, k) / f1);
        com.tencent.mm.plugin.report.service.g.yhR.f(17305, new Object[] { Integer.valueOf(i), Integer.valueOf(m), Integer.valueOf(j), Integer.valueOf(k), Float.toString(f1), Float.toString(f2), Integer.valueOf(n), Integer.valueOf(al.fxP()), Integer.valueOf(al.fxQ()), Integer.valueOf(a.psI), Integer.valueOf(Math.min(locala.HVn.widthPixels, locala.HVn.heightPixels)), Float.valueOf(a.HVv) });
        ax.aQz(aj.fkC()).putBoolean(a.HVs, true);
      }
      label1122:
      do
      {
        if (a.fhO())
        {
          locala.fhM();
          localDisplayMetrics = new DisplayMetrics();
          ((WindowManager)aj.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
          ad.i("MicroMsg.MMDensityManager", " \n************************************************************************* \nTarget -> %s \nCurrent -> %s \nWindowManager -> %s \nConfiguration -> %s fontScale -> %s \noriginalMetric -> [%s]", new Object[] { a.d(locala.aJt), a.d(paramDisplayMetrics), a.d(localDisplayMetrics), Integer.valueOf(paramConfiguration.densityDpi), Float.valueOf(paramConfiguration.fontScale), locala.HVn });
        }
        AppMethodBeat.o(141217);
        return;
        i = 0;
        break;
        f1 = 0.8F;
        break label296;
        f1 = 1.0F;
        break label296;
        f1 = 1.1F;
        break label296;
        f1 = 1.12F;
        break label296;
        f1 = 1.125F;
        break label296;
        f1 = 1.4F;
        break label296;
        f1 = 1.55F;
        break label296;
        f1 = 1.65F;
        break label296;
        i = 440;
        break label360;
        i = 400;
        break label360;
        i = 360;
        break label360;
        i = 340;
        break label360;
        i = 0;
        break label368;
        j = 0;
        break label1166;
        k = 0;
        if (k != 0) {
          break label715;
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
      ad.i("InterceptArrayList", "InterceptArrayList.add index object");
      AppMethodBeat.o(141212);
    }
    
    public final boolean add(E paramE)
    {
      AppMethodBeat.i(141211);
      ad.i("InterceptArrayList", "InterceptArrayList.add");
      AppMethodBeat.o(141211);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.cd.b
 * JD-Core Version:    0.7.0.1
 */