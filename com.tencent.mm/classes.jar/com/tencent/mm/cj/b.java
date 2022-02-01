package com.tencent.mm.cj;

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
import com.tencent.mm.model.cs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Wordings;
import com.tencent.mm.svg.a.e;
import com.tencent.mm.ui.ar;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

public final class b
  extends Resources
{
  private static Method UQM = null;
  private static Method UQN = null;
  private h UQI;
  private f UQJ;
  private boolean UQK;
  public a UQL;
  private Resources mResources;
  
  private b(Resources paramResources, h paramh, f paramf)
  {
    super(paramResources.getAssets(), paramResources.getDisplayMetrics(), paramResources.getConfiguration());
    AppMethodBeat.i(141213);
    this.UQI = paramh;
    if ((paramResources instanceof b)) {}
    for (this.mResources = ((b)paramResources).mResources;; this.mResources = paramResources)
    {
      this.UQJ = paramf;
      hry();
      hrz();
      AppMethodBeat.o(141213);
      return;
    }
  }
  
  private b(Resources paramResources, h paramh, f paramf, a parama)
  {
    super(paramResources.getAssets(), parama.getDisplayMetrics(), parama.f(paramResources.getConfiguration()));
    AppMethodBeat.i(141214);
    this.UQL = parama;
    this.UQI = paramh;
    if ((paramResources instanceof b)) {
      this.mResources = ((b)paramResources).mResources;
    }
    for (;;)
    {
      this.UQJ = paramf;
      hry();
      hrz();
      try
      {
        this.UQK = MMApplicationContext.getDefaultPreference().getBoolean("ShowStringName", false);
        Log.i("MicroMsg.MMResources", "originalResources:%s mmresource:%s", new Object[] { paramResources, this });
        cs.bfO();
        AppMethodBeat.o(141214);
        return;
        this.mResources = paramResources;
      }
      catch (Exception paramh)
      {
        for (;;)
        {
          Log.e("MicroMsg.MMResources", paramh.getMessage());
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
    paramResources = new b(paramResources, h.cG(paramContext, paramString), new f(), new a(paramResources.getDisplayMetrics()));
    AppMethodBeat.o(141220);
    return paramResources;
  }
  
  public static Resources a(Resources paramResources, Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(141219);
    paramContext = h.ku(paramContext);
    f localf = new f();
    if (paramBoolean)
    {
      paramResources = new b(paramResources, paramContext, localf);
      AppMethodBeat.o(141219);
      return paramResources;
    }
    paramResources = new b(paramResources, paramContext, localf, new a(paramResources.getDisplayMetrics()));
    AppMethodBeat.o(141219);
    return paramResources;
  }
  
  private Drawable d(Drawable paramDrawable, int paramInt)
  {
    AppMethodBeat.i(141235);
    Object localObject = paramDrawable;
    if (paramDrawable == null) {
      Log.printInfoStack("MicroMsg.MMResources", "Notice!!! drawable == null!!!", new Object[0]);
    }
    try
    {
      if (this.UQJ.sbV.j(this, paramInt)) {
        Log.e("MicroMsg.MMResources", "resources name = %s, this resource %s", new Object[] { getResourceName(paramInt), this });
      }
      localObject = new com.tencent.mm.svg.a.c(new Picture(), 0);
      AppMethodBeat.o(141235);
      return localObject;
    }
    catch (Exception paramDrawable)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.MMResources", paramDrawable, "WTF", new Object[0]);
      }
    }
  }
  
  public static Drawable f(Resources paramResources, int paramInt)
  {
    AppMethodBeat.i(141238);
    paramResources = e.f(paramResources, paramInt);
    AppMethodBeat.o(141238);
    return paramResources;
  }
  
  public static Drawable g(Resources paramResources, int paramInt)
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
      if (UQM == null) {}
      Object localObject2;
      try
      {
        localObject2 = Resources.class.getDeclaredMethod("loadXmlResourceParser", new Class[] { String.class, Integer.TYPE, Integer.TYPE, String.class });
        UQM = (Method)localObject2;
        ((Method)localObject2).setAccessible(true);
        if (UQN == null) {}
        localObject1 = ((TypedValue)localObject3).string.toString();
      }
      catch (NoSuchMethodException paramResources)
      {
        try
        {
          localObject2 = AssetManager.class.getDeclaredMethod("openNonAsset", new Class[] { Integer.TYPE, String.class, Integer.TYPE });
          UQN = (Method)localObject2;
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
          Log.printErrStackTrace("MicroMsg.MMResources", paramResources, "", new Object[0]);
          Log.printErrStackTrace("MicroMsg.MMResources", paramResources, "", new Object[0]);
          AppMethodBeat.o(141239);
          return null;
        }
        paramResources = paramResources;
        Log.printErrStackTrace("MicroMsg.MMResources", paramResources, "", new Object[0]);
        Log.printErrStackTrace("MicroMsg.MMResources", paramResources, "", new Object[0]);
        AppMethodBeat.o(141239);
        return null;
      }
      label270:
      if (((String)localObject1).endsWith(".xml")) {}
      for (;;)
      {
        try
        {
          localObject3 = (XmlResourceParser)UQM.invoke(paramResources, new Object[] { localObject1, Integer.valueOf(paramInt), Integer.valueOf(((TypedValue)localObject3).assetCookie), "drawable" });
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
          InputStream localInputStream = (InputStream)UQN.invoke(paramResources.getAssets(), new Object[] { Integer.valueOf(((TypedValue)localObject3).assetCookie), localObject1, Integer.valueOf(2) });
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
  
  private boolean hrx()
  {
    AppMethodBeat.i(141221);
    if ((this.UQI != null) && (h.hrx()))
    {
      AppMethodBeat.o(141221);
      return true;
    }
    AppMethodBeat.o(141221);
    return false;
  }
  
  private static void hry()
  {
    Object localObject = null;
    AppMethodBeat.i(141236);
    try
    {
      Class localClass = Class.forName("android.content.res.MiuiResources");
      if (localClass != null)
      {
        Log.i("MicroMsg.MMResources", "sMiuiThemeEnabled false");
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
      Log.e("MicroMsg.MMResources", "some thing wrong. %s %s", new Object[] { localClass, localObject });
      AppMethodBeat.o(141236);
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      Log.i("MicroMsg.MMResources", "sMiuiThemeEnabled ClassNotFoundException");
      AppMethodBeat.o(141236);
      return;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      Log.i("MicroMsg.MMResources", "sMiuiThemeEnabled NoSuchFieldException");
      AppMethodBeat.o(141236);
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      Log.i("MicroMsg.MMResources", "sMiuiThemeEnabled IllegalAccessException");
      AppMethodBeat.o(141236);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      Log.i("MicroMsg.MMResources", "sMiuiThemeEnabled IllegalArgumentException");
      AppMethodBeat.o(141236);
    }
  }
  
  private void hrz()
  {
    AppMethodBeat.i(141237);
    com.tencent.mm.compatible.loader.b localb = new com.tencent.mm.compatible.loader.b(getAssets(), "mThemeCookies", null);
    try
    {
      if (localb.avs()) {
        localb.set(new b.a());
      }
      AppMethodBeat.o(141237);
      return;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      Log.printErrStackTrace("MicroMsg.MMResources", localNoSuchFieldException, "", new Object[0]);
      AppMethodBeat.o(141237);
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      Log.printErrStackTrace("MicroMsg.MMResources", localIllegalAccessException, "", new Object[0]);
      AppMethodBeat.o(141237);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      Log.printErrStackTrace("MicroMsg.MMResources", localIllegalArgumentException, "", new Object[0]);
      AppMethodBeat.o(141237);
    }
  }
  
  public final DisplayMetrics getDisplayMetrics()
  {
    AppMethodBeat.i(141215);
    if (this.UQL != null)
    {
      localDisplayMetrics = this.UQL.getDisplayMetrics();
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
      localDrawable = this.UQJ.h(this.mResources, paramInt);
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
      Drawable localDrawable = this.UQJ.h(this.mResources, paramInt);
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
      localDrawable = this.UQJ.h(this.mResources, paramInt1);
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
      Drawable localDrawable = this.UQJ.h(this.mResources, paramInt1);
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
    if (this.UQK) {
      try
      {
        String str1 = WeChatBrands.Wordings.translate(this.mResources.getResourceEntryName(paramInt1));
        AppMethodBeat.o(141225);
        return str1;
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(141225);
        return "";
      }
    }
    if (hrx())
    {
      str2 = h.getQuantityString(paramInt1, paramInt2);
      if (str2 != null)
      {
        str2 = WeChatBrands.Wordings.translate(str2.toString());
        AppMethodBeat.o(141225);
        return str2;
      }
    }
    String str2 = WeChatBrands.Wordings.translate(this.mResources.getQuantityString(paramInt1, paramInt2));
    AppMethodBeat.o(141225);
    return str2;
  }
  
  public final String getQuantityString(int paramInt1, int paramInt2, Object... paramVarArgs)
  {
    AppMethodBeat.i(141226);
    if (this.UQK) {
      try
      {
        paramVarArgs = WeChatBrands.Wordings.translate(this.mResources.getResourceEntryName(paramInt1));
        AppMethodBeat.o(141226);
        return paramVarArgs;
      }
      catch (Exception paramVarArgs)
      {
        AppMethodBeat.o(141226);
        return "";
      }
    }
    if (hrx())
    {
      String str = h.getQuantityString(paramInt1, paramInt2, paramVarArgs);
      if (str != null)
      {
        paramVarArgs = str.toString();
        AppMethodBeat.o(141226);
        return paramVarArgs;
      }
    }
    paramVarArgs = WeChatBrands.Wordings.translate(this.mResources.getQuantityString(paramInt1, paramInt2, paramVarArgs));
    AppMethodBeat.o(141226);
    return paramVarArgs;
  }
  
  public final CharSequence getQuantityText(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(141227);
    if (this.UQK) {
      try
      {
        String str1 = WeChatBrands.Wordings.translate(this.mResources.getResourceEntryName(paramInt1));
        AppMethodBeat.o(141227);
        return str1;
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(141227);
        return "";
      }
    }
    if (hrx())
    {
      str2 = h.getQuantityString(paramInt1, paramInt2);
      if (str2 != null)
      {
        str2 = WeChatBrands.Wordings.translate(str2.toString());
        AppMethodBeat.o(141227);
        return str2;
      }
    }
    String str2 = WeChatBrands.Wordings.translate(this.mResources.getQuantityString(paramInt1, paramInt2));
    AppMethodBeat.o(141227);
    return str2;
  }
  
  public final String getString(int paramInt)
  {
    AppMethodBeat.i(141224);
    if (this.UQK) {
      try
      {
        String str = WeChatBrands.Wordings.translate(this.mResources.getResourceEntryName(paramInt));
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
    if (hrx())
    {
      localObject = h.getString(paramInt);
      if (localObject != null)
      {
        localObject = WeChatBrands.Wordings.translate(h.aB(((CharSequence)localObject).toString()).toString());
        AppMethodBeat.o(141224);
        return localObject;
      }
    }
    try
    {
      localObject = h.aB(this.mResources.getString(paramInt));
      if (localObject != null)
      {
        localObject = WeChatBrands.Wordings.translate(((CharSequence)localObject).toString());
        AppMethodBeat.o(141224);
        return localObject;
      }
      localObject = WeChatBrands.Wordings.translate(this.mResources.getString(paramInt));
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
    Object localObject1 = null;
    if (hrx()) {
      localObject1 = h.getStringArray(paramInt);
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject1 = super.getStringArray(paramInt);
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (localObject1.length != 0) {}
      }
      else
      {
        AppMethodBeat.o(141228);
        return localObject1;
      }
    }
    localObject1 = new ArrayList(localObject2.length);
    int i = localObject2.length;
    paramInt = 0;
    while (paramInt < i)
    {
      ((List)localObject1).add(WeChatBrands.Wordings.translate(localObject2[paramInt]));
      paramInt += 1;
    }
    localObject1 = (String[])((List)localObject1).toArray(new String[0]);
    AppMethodBeat.o(141228);
    return localObject1;
  }
  
  public final CharSequence getText(int paramInt)
  {
    AppMethodBeat.i(141222);
    if (this.UQK) {
      try
      {
        String str = WeChatBrands.Wordings.translate(this.mResources.getResourceEntryName(paramInt));
        AppMethodBeat.o(141222);
        return str;
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(141222);
        return "";
      }
    }
    if (hrx())
    {
      localObject = h.aB(h.getString(paramInt));
      if (localObject != null)
      {
        localObject = WeChatBrands.Wordings.translate(((CharSequence)localObject).toString());
        AppMethodBeat.o(141222);
        return localObject;
      }
    }
    Object localObject = h.aB(this.mResources.getString(paramInt));
    if (localObject != null)
    {
      localObject = WeChatBrands.Wordings.translate(((CharSequence)localObject).toString());
      AppMethodBeat.o(141222);
      return localObject;
    }
    localObject = WeChatBrands.Wordings.translate(this.mResources.getString(paramInt));
    AppMethodBeat.o(141222);
    return localObject;
  }
  
  public final CharSequence getText(int paramInt, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(141223);
    if (this.UQK) {
      try
      {
        paramCharSequence = WeChatBrands.Wordings.translate(this.mResources.getResourceEntryName(paramInt));
        AppMethodBeat.o(141223);
        return paramCharSequence;
      }
      catch (Exception paramCharSequence)
      {
        AppMethodBeat.o(141223);
        return "";
      }
    }
    if (hrx())
    {
      paramCharSequence = h.aB(h.getString(paramInt));
      if (paramCharSequence != null)
      {
        paramCharSequence = WeChatBrands.Wordings.translate(paramCharSequence.toString());
        AppMethodBeat.o(141223);
        return paramCharSequence;
      }
    }
    paramCharSequence = h.aB(this.mResources.getString(paramInt));
    if (paramCharSequence != null)
    {
      paramCharSequence = WeChatBrands.Wordings.translate(paramCharSequence.toString());
      AppMethodBeat.o(141223);
      return paramCharSequence;
    }
    paramCharSequence = WeChatBrands.Wordings.translate(this.mResources.getString(paramInt));
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
  
  public final a hrv()
  {
    return this.UQL;
  }
  
  public final Resources hrw()
  {
    return this.mResources;
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
    Log.i("MicroMsg.MMResources", "dancy test locale %s, orientation %s, uimode:%s", new Object[] { paramConfiguration.locale, Integer.valueOf(paramConfiguration.orientation), Integer.valueOf(paramConfiguration.uiMode) });
    if (((ar.aEk()) && (MMApplicationContext.isMainProcess())) || (!ar.aEk()))
    {
      c.a(paramConfiguration, this.mResources);
      if (this.mResources != null) {
        this.mResources.getConfiguration().updateFrom(paramConfiguration);
      }
    }
    Object localObject = this.UQL;
    DisplayMetrics localDisplayMetrics = this.mResources.getDisplayMetrics();
    if (a.hro())
    {
      localDisplayMetrics.density = ((a)localObject).cCm.density;
      localDisplayMetrics.densityDpi = ((a)localObject).cCm.densityDpi;
      localDisplayMetrics.scaledDensity = ((a)localObject).cCm.scaledDensity;
      ((a)localObject).cCm.setTo(localDisplayMetrics);
    }
    localObject = new Configuration(getConfiguration());
    ((Configuration)localObject).fontScale += 0.1F;
    super.updateConfiguration((Configuration)localObject, getDisplayMetrics());
    com.tencent.mm.sdk.vendor.Oppo._isUnDefaultFont = null;
    super.updateConfiguration(this.UQL.f(paramConfiguration), getDisplayMetrics());
    AppMethodBeat.o(141216);
  }
  
  public final void updateConfiguration(Configuration paramConfiguration, DisplayMetrics paramDisplayMetrics)
  {
    AppMethodBeat.i(141217);
    super.updateConfiguration(paramConfiguration, paramDisplayMetrics);
    for (;;)
    {
      try
      {
        if (((ar.aEk()) && (MMApplicationContext.isMainProcess())) || (!ar.aEk()))
        {
          c.a(paramConfiguration, this.mResources);
          if (this.mResources != null)
          {
            this.mResources.getConfiguration().updateFrom(paramConfiguration);
            this.mResources.updateConfiguration(paramConfiguration, paramDisplayMetrics);
          }
        }
        a locala;
        float f1;
        if (this.UQL != null)
        {
          locala = this.UQL;
          i = MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).getInt(a.UQr, 0);
          ar.hIP();
          j = ar.hIP().densityDpi;
          if (i == 0) {
            MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).putInt(a.UQr, j);
          }
          Log.i("MicroMsg.MMDensityManager", "dancy test checkDensity, mDensityDpi:%s,  mCurrentDensityDpi:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          if ((i == 0) || (i == j)) {
            continue;
          }
          MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).putInt(a.UQr, j);
          i = 1;
          if (i == 0)
          {
            if (!a.hro()) {
              continue;
            }
            i = com.tencent.mm.ci.a.kl(MMApplicationContext.getContext());
            Log.i("MicroMsg.MMDensityManager", "old version text index: %s", new Object[] { Integer.valueOf(i) });
            if ((i == 1) && (!a.hrn())) {
              continue;
            }
            f1 = 1.0F;
            if (!a.hrn()) {
              break label1127;
            }
            i = 0;
            break label1127;
            com.tencent.mm.ci.a.h(MMApplicationContext.getContext(), f1);
            j = 400;
          }
        }
        boolean bool2;
        switch (i)
        {
        case 0: 
          a.arQ(i);
          i = 1;
          break label1186;
          Log.i("MicroMsg.MMDensityManager", "checkDensity density change, mIcheckDensitylistener:%s", new Object[] { a.UQz });
          if (a.UQz != null) {
            a.UQz.aaP();
          }
          boolean bool1 = MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).getBoolean(a.UQt, false);
          bool2 = MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).getBoolean(a.UQu, false);
          if (bool1) {
            break;
          }
        case 1: 
        case 2: 
        case 3: 
        case 4: 
        case 5: 
        case 6: 
        case 7: 
          try
          {
            localDisplayMetrics = new DisplayMetrics();
            ((WindowManager)MMApplicationContext.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
            i = localDisplayMetrics.widthPixels;
            j = localDisplayMetrics.heightPixels;
            f1 = localDisplayMetrics.density;
            f2 = locala.getDisplayMetrics().density;
            k = (int)(Math.min(i, j) / f1);
            com.tencent.mm.plugin.report.service.h.IzE.a(17089, new Object[] { Integer.valueOf(i), Integer.valueOf(j), Float.toString(f1), Float.toString(f2), Integer.valueOf(k), Integer.valueOf(ar.hIQ()), Integer.valueOf(ar.hIR()), Integer.valueOf(a.uqJ), Integer.valueOf(Math.min(a.UQp.widthPixels, a.UQp.heightPixels)), Float.valueOf(a.UQx) });
            MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).putBoolean(a.UQt, true);
            if (ar.hIQ() == 0) {
              break label1121;
            }
            i = Math.round(a.uqJ / (ar.hIQ() / 160.0F));
            localDisplayMetrics = ar.hIP();
            m = Math.round(Math.min(localDisplayMetrics.heightPixels, localDisplayMetrics.widthPixels) / localDisplayMetrics.density);
            if (m < 550) {
              continue;
            }
            j = 1;
          }
          catch (Exception localException)
          {
            DisplayMetrics localDisplayMetrics;
            float f2;
            int m;
            int n;
            Log.printErrStackTrace("MicroMsg.MMDensityManager", localException, "", new Object[0]);
            continue;
          }
          if (!bool2)
          {
            j = localDisplayMetrics.widthPixels;
            k = localDisplayMetrics.heightPixels;
            f1 = localDisplayMetrics.density;
            f2 = locala.getDisplayMetrics().density;
            n = (int)(Math.min(j, k) / f1);
            com.tencent.mm.plugin.report.service.h.IzE.a(17305, new Object[] { Integer.valueOf(i), Integer.valueOf(m), Integer.valueOf(j), Integer.valueOf(k), Float.toString(f1), Float.toString(f2), Integer.valueOf(n), Integer.valueOf(ar.hIQ()), Integer.valueOf(ar.hIR()), Integer.valueOf(a.uqJ), Integer.valueOf(Math.min(a.UQp.widthPixels, a.UQp.heightPixels)), Float.valueOf(a.UQx) });
            MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).putBoolean(a.UQu, true);
          }
          if (a.hro())
          {
            locala.hrm();
            localDisplayMetrics = new DisplayMetrics();
            ((WindowManager)MMApplicationContext.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
            Log.i("MicroMsg.MMDensityManager", " \n************************************************************************* \nTarget -> %s \nCurrent -> %s \nWindowManager -> %s \nConfiguration -> %s fontScale -> %s \noriginalMetric -> [%s]", new Object[] { a.c(locala.cCm), a.c(paramDisplayMetrics), a.c(localDisplayMetrics), Integer.valueOf(paramConfiguration.densityDpi), Float.valueOf(paramConfiguration.fontScale), a.UQp });
          }
          AppMethodBeat.o(141217);
          return;
          i = 0;
          continue;
          f1 = 0.8F;
          continue;
          f1 = 1.0F;
          continue;
          f1 = 1.1F;
          continue;
          f1 = 1.12F;
          continue;
          f1 = 1.125F;
          continue;
          f1 = 1.4F;
          continue;
          f1 = 1.55F;
          continue;
          f1 = 1.65F;
          continue;
          i = 440;
          continue;
          i = 400;
          continue;
          i = 360;
          continue;
          i = 340;
          continue;
          i = 0;
        }
      }
      catch (UnsatisfiedLinkError paramConfiguration)
      {
        Log.printErrStackTrace("MicroMsg.MMResources", paramConfiguration, "Rarely exception.", new Object[0]);
        AppMethodBeat.o(141217);
        return;
      }
      int j = 0;
      break label1194;
      int k = 0;
      break label1205;
      label1121:
      int i = 0;
      continue;
      label1127:
      switch (i)
      {
      }
      continue;
      i = j;
      continue;
      label1186:
      if (i != 0)
      {
        continue;
        label1194:
        if (i >= 550)
        {
          k = 1;
          label1205:
          if (k == 0) {
            if (j == 0) {}
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.cj.b
 * JD-Core Version:    0.7.0.1
 */