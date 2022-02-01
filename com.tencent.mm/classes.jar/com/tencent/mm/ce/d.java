package com.tencent.mm.ce;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
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
import com.tencent.mm.ah.a.d;
import com.tencent.mm.model.ct;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Wordings;
import com.tencent.mm.ui.aw;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

public final class d
  extends Resources
{
  private static Method acmb = null;
  private static Method acmc = null;
  private j aclX;
  private h aclY;
  private boolean aclZ;
  public c acma;
  public Resources mResources;
  
  private d(Resources paramResources, j paramj, h paramh)
  {
    super(paramResources.getAssets(), paramResources.getDisplayMetrics(), paramResources.getConfiguration());
    AppMethodBeat.i(141213);
    this.aclX = paramj;
    if ((paramResources instanceof d)) {}
    for (this.mResources = ((d)paramResources).mResources;; this.mResources = paramResources)
    {
      this.aclY = paramh;
      iRM();
      iRN();
      AppMethodBeat.o(141213);
      return;
    }
  }
  
  private d(Resources paramResources, j paramj, h paramh, c paramc)
  {
    super(paramResources.getAssets(), c.getDisplayMetrics(), paramc.h(paramResources.getConfiguration()));
    AppMethodBeat.i(141214);
    this.acma = paramc;
    this.aclX = paramj;
    if ((paramResources instanceof d)) {
      this.mResources = ((d)paramResources).mResources;
    }
    for (;;)
    {
      this.aclY = paramh;
      iRM();
      iRN();
      try
      {
        this.aclZ = MMApplicationContext.getDefaultPreference().getBoolean("ShowStringName", false);
        Log.i("MicroMsg.MMResources", "originalResources:%s mmresource:%s", new Object[] { paramResources, this });
        ct.bDF();
        AppMethodBeat.o(141214);
        return;
        this.mResources = paramResources;
      }
      catch (Exception paramj)
      {
        for (;;)
        {
          Log.e("MicroMsg.MMResources", paramj.getMessage());
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
    paramResources = new d(paramResources, j.cR(paramContext, paramString), new h(), new c(paramResources.getDisplayMetrics()));
    AppMethodBeat.o(141220);
    return paramResources;
  }
  
  public static Resources a(Resources paramResources, Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(141219);
    paramContext = j.mw(paramContext);
    h localh = new h();
    if (paramBoolean)
    {
      paramResources = new d(paramResources, paramContext, localh);
      AppMethodBeat.o(141219);
      return paramResources;
    }
    paramResources = new d(paramResources, paramContext, localh, new c(paramResources.getDisplayMetrics()));
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
      if (this.aclY.vnn.k(this, paramInt)) {
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
  
  public static Drawable g(Resources paramResources, int paramInt)
  {
    AppMethodBeat.i(141238);
    paramResources = com.tencent.mm.svg.a.e.g(paramResources, paramInt);
    AppMethodBeat.o(141238);
    return paramResources;
  }
  
  public static Drawable h(Resources paramResources, int paramInt)
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
      if (acmb == null) {}
      Object localObject2;
      try
      {
        localObject2 = Resources.class.getDeclaredMethod("loadXmlResourceParser", new Class[] { String.class, Integer.TYPE, Integer.TYPE, String.class });
        acmb = (Method)localObject2;
        ((Method)localObject2).setAccessible(true);
        if (acmc == null) {}
        localObject1 = ((TypedValue)localObject3).string.toString();
      }
      catch (NoSuchMethodException paramResources)
      {
        try
        {
          localObject2 = AssetManager.class.getDeclaredMethod("openNonAsset", new Class[] { Integer.TYPE, String.class, Integer.TYPE });
          acmc = (Method)localObject2;
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
          localObject3 = (XmlResourceParser)acmb.invoke(paramResources, new Object[] { localObject1, Integer.valueOf(paramInt), Integer.valueOf(((TypedValue)localObject3).assetCookie), "drawable" });
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
          InputStream localInputStream = (InputStream)acmc.invoke(paramResources.getAssets(), new Object[] { Integer.valueOf(((TypedValue)localObject3).assetCookie), localObject1, Integer.valueOf(2) });
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
  
  private boolean iRL()
  {
    AppMethodBeat.i(141221);
    if ((this.aclX != null) && (j.iRL()))
    {
      AppMethodBeat.o(141221);
      return true;
    }
    AppMethodBeat.o(141221);
    return false;
  }
  
  private static void iRM()
  {
    Object localObject = null;
    AppMethodBeat.i(232998);
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
          AppMethodBeat.o(232998);
          return;
        }
      }
      Log.e("MicroMsg.MMResources", "some thing wrong. %s %s", new Object[] { localClass, localObject });
      AppMethodBeat.o(232998);
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      Log.i("MicroMsg.MMResources", "sMiuiThemeEnabled ClassNotFoundException");
      AppMethodBeat.o(232998);
      return;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      Log.i("MicroMsg.MMResources", "sMiuiThemeEnabled NoSuchFieldException");
      AppMethodBeat.o(232998);
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      Log.i("MicroMsg.MMResources", "sMiuiThemeEnabled IllegalAccessException");
      AppMethodBeat.o(232998);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      Log.i("MicroMsg.MMResources", "sMiuiThemeEnabled IllegalArgumentException");
      AppMethodBeat.o(232998);
    }
  }
  
  private void iRN()
  {
    AppMethodBeat.i(141237);
    com.tencent.mm.compatible.loader.b localb = new com.tencent.mm.compatible.loader.b(getAssets(), "mThemeCookies", null);
    try
    {
      if (localb.aPM()) {
        localb.set(new d.a());
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
  
  public final int getColor(int paramInt)
  {
    AppMethodBeat.i(233130);
    if ((MMApplicationContext.isMMProcess()) && (b.iRp()))
    {
      if (this.mResources.getColor(paramInt) == this.mResources.getColor(a.d.FG_0))
      {
        paramInt = this.mResources.getColor(a.d.FG_0_CARE);
        AppMethodBeat.o(233130);
        return paramInt;
      }
      if (paramInt == a.d.FG_0_5)
      {
        paramInt = this.mResources.getColor(a.d.FG_0_5_CARE);
        AppMethodBeat.o(233130);
        return paramInt;
      }
      if (this.mResources.getColor(paramInt) == this.mResources.getColor(a.d.FG_1))
      {
        paramInt = this.mResources.getColor(a.d.FG_1_CARE);
        AppMethodBeat.o(233130);
        return paramInt;
      }
      if (this.mResources.getColor(paramInt) == this.mResources.getColor(a.d.FG_2))
      {
        paramInt = this.mResources.getColor(a.d.FG_2_CARE);
        AppMethodBeat.o(233130);
        return paramInt;
      }
      if (paramInt == a.d.UN_BW_0_Alpha_0_9)
      {
        paramInt = this.mResources.getColor(a.d.UN_FG_0_CARE);
        AppMethodBeat.o(233130);
        return paramInt;
      }
      if ((this.mResources.getColor(paramInt) == this.mResources.getColor(a.d.Brand)) || (this.mResources.getColor(paramInt) == this.mResources.getColor(a.d.Brand_90)))
      {
        paramInt = this.mResources.getColor(a.d.Brand_100_CARE);
        AppMethodBeat.o(233130);
        return paramInt;
      }
      if (this.mResources.getColor(paramInt) == this.mResources.getColor(a.d.Red))
      {
        paramInt = this.mResources.getColor(a.d.Red_100_CARE);
        AppMethodBeat.o(233130);
        return paramInt;
      }
      if (this.mResources.getColor(paramInt) == this.mResources.getColor(a.d.Brand_BG_100))
      {
        paramInt = this.mResources.getColor(a.d.Brand_BG_100_CARE);
        AppMethodBeat.o(233130);
        return paramInt;
      }
      if (this.mResources.getColor(paramInt) == this.mResources.getColor(a.d.Yellow_BG_100))
      {
        paramInt = this.mResources.getColor(a.d.Yellow_BG_100_CARE);
        AppMethodBeat.o(233130);
        return paramInt;
      }
      if (this.mResources.getColor(paramInt) == this.mResources.getColor(a.d.Orange))
      {
        paramInt = this.mResources.getColor(a.d.Orange_100_CARE);
        AppMethodBeat.o(233130);
        return paramInt;
      }
      if (this.mResources.getColor(paramInt) == this.mResources.getColor(a.d.Yellow))
      {
        paramInt = this.mResources.getColor(a.d.Yellow_100_CARE);
        AppMethodBeat.o(233130);
        return paramInt;
      }
      paramInt = this.mResources.getColor(paramInt);
      AppMethodBeat.o(233130);
      return paramInt;
    }
    paramInt = this.mResources.getColor(paramInt);
    AppMethodBeat.o(233130);
    return paramInt;
  }
  
  public final ColorStateList getColorStateList(int paramInt)
  {
    AppMethodBeat.i(233140);
    if ((MMApplicationContext.isMMProcess()) && (b.iRp()))
    {
      if (super.getColorStateList(paramInt).getDefaultColor() == this.mResources.getColor(a.d.FG_0))
      {
        localColorStateList = super.getColorStateList(a.d.FG_0_CARE);
        AppMethodBeat.o(233140);
        return localColorStateList;
      }
      if (paramInt == a.d.FG_0_5)
      {
        localColorStateList = super.getColorStateList(a.d.FG_0_5_CARE);
        AppMethodBeat.o(233140);
        return localColorStateList;
      }
      if (super.getColorStateList(paramInt).getDefaultColor() == this.mResources.getColor(a.d.FG_1))
      {
        localColorStateList = super.getColorStateList(a.d.FG_1_CARE);
        AppMethodBeat.o(233140);
        return localColorStateList;
      }
      if (super.getColorStateList(paramInt).getDefaultColor() == this.mResources.getColor(a.d.FG_2))
      {
        localColorStateList = super.getColorStateList(a.d.FG_2_CARE);
        AppMethodBeat.o(233140);
        return localColorStateList;
      }
      if (paramInt == a.d.UN_BW_0_Alpha_0_9)
      {
        localColorStateList = super.getColorStateList(a.d.UN_FG_0_CARE);
        AppMethodBeat.o(233140);
        return localColorStateList;
      }
      if ((super.getColorStateList(paramInt).getDefaultColor() == this.mResources.getColor(a.d.Brand)) || (super.getColorStateList(paramInt).getDefaultColor() == this.mResources.getColor(a.d.Brand_90)))
      {
        localColorStateList = super.getColorStateList(a.d.Brand_100_CARE);
        AppMethodBeat.o(233140);
        return localColorStateList;
      }
      if (super.getColorStateList(paramInt).getDefaultColor() == this.mResources.getColor(a.d.Red))
      {
        localColorStateList = super.getColorStateList(a.d.Red_100_CARE);
        AppMethodBeat.o(233140);
        return localColorStateList;
      }
      if (super.getColorStateList(paramInt).getDefaultColor() == this.mResources.getColor(a.d.Brand_BG_100))
      {
        localColorStateList = super.getColorStateList(a.d.Brand_BG_100_CARE);
        AppMethodBeat.o(233140);
        return localColorStateList;
      }
      if (super.getColorStateList(paramInt).getDefaultColor() == this.mResources.getColor(a.d.Yellow_BG_100))
      {
        localColorStateList = super.getColorStateList(a.d.Yellow_BG_100_CARE);
        AppMethodBeat.o(233140);
        return localColorStateList;
      }
      if (super.getColorStateList(paramInt).getDefaultColor() == this.mResources.getColor(a.d.Orange))
      {
        localColorStateList = super.getColorStateList(a.d.Orange_100_CARE);
        AppMethodBeat.o(233140);
        return localColorStateList;
      }
      if (super.getColorStateList(paramInt).getDefaultColor() == this.mResources.getColor(a.d.Yellow))
      {
        localColorStateList = super.getColorStateList(a.d.Yellow_100_CARE);
        AppMethodBeat.o(233140);
        return localColorStateList;
      }
      localColorStateList = super.getColorStateList(paramInt);
      AppMethodBeat.o(233140);
      return localColorStateList;
    }
    ColorStateList localColorStateList = super.getColorStateList(paramInt);
    AppMethodBeat.o(233140);
    return localColorStateList;
  }
  
  public final DisplayMetrics getDisplayMetrics()
  {
    AppMethodBeat.i(141215);
    if (this.acma != null)
    {
      localDisplayMetrics = c.getDisplayMetrics();
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
      localDrawable = this.aclY.i(this.mResources, paramInt);
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
  
  public final Drawable getDrawable(int paramInt, Resources.Theme paramTheme)
  {
    AppMethodBeat.i(141232);
    if (paramInt != 0)
    {
      Drawable localDrawable = this.aclY.i(this.mResources, paramInt);
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
      localDrawable = this.aclY.i(this.mResources, paramInt1);
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
  
  public final Drawable getDrawableForDensity(int paramInt1, int paramInt2, Resources.Theme paramTheme)
  {
    AppMethodBeat.i(141234);
    if (paramInt1 != 0)
    {
      Drawable localDrawable = this.aclY.i(this.mResources, paramInt1);
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
    if (this.aclZ) {
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
    if (iRL())
    {
      str2 = j.getQuantityString(paramInt1, paramInt2);
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
    if (this.aclZ) {
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
    if (iRL())
    {
      String str = j.getQuantityString(paramInt1, paramInt2, paramVarArgs);
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
    if (this.aclZ) {
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
    if (iRL())
    {
      str2 = j.getQuantityString(paramInt1, paramInt2);
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
    if (this.aclZ) {
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
    if (iRL())
    {
      localObject = j.getString(paramInt);
      if (localObject != null)
      {
        localObject = WeChatBrands.Wordings.translate(j.aP(((CharSequence)localObject).toString()).toString());
        AppMethodBeat.o(141224);
        return localObject;
      }
    }
    try
    {
      localObject = j.aP(this.mResources.getString(paramInt));
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
    if (iRL()) {
      localObject1 = j.getStringArray(paramInt);
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
    if (this.aclZ) {
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
    if (iRL())
    {
      localObject = j.aP(j.getString(paramInt));
      if (localObject != null)
      {
        localObject = WeChatBrands.Wordings.translate(((CharSequence)localObject).toString());
        AppMethodBeat.o(141222);
        return localObject;
      }
    }
    Object localObject = j.aP(this.mResources.getString(paramInt));
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
    if (this.aclZ) {
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
    if (iRL())
    {
      paramCharSequence = j.aP(j.getString(paramInt));
      if (paramCharSequence != null)
      {
        paramCharSequence = WeChatBrands.Wordings.translate(paramCharSequence.toString());
        AppMethodBeat.o(141223);
        return paramCharSequence;
      }
    }
    paramCharSequence = j.aP(this.mResources.getString(paramInt));
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
    Log.i("MicroMsg.MMResources", "dancy test locale %s, orientation %s, uimode:%s, systemfont:%s", new Object[] { paramConfiguration.locale, Integer.valueOf(paramConfiguration.orientation), Integer.valueOf(paramConfiguration.uiMode), Float.valueOf(paramConfiguration.fontScale) });
    if (((aw.aXo()) && (MMApplicationContext.isMainProcess())) || (!aw.aXo()))
    {
      e.a(paramConfiguration, this.mResources);
      if (this.mResources != null) {
        this.mResources.getConfiguration().updateFrom(paramConfiguration);
      }
    }
    c.e(this.mResources.getDisplayMetrics());
    Configuration localConfiguration = new Configuration(getConfiguration());
    localConfiguration.fontScale += 0.1F;
    super.updateConfiguration(localConfiguration, getDisplayMetrics());
    com.tencent.mm.sdk.vendor.Oppo._isUnDefaultFont = null;
    super.updateConfiguration(this.acma.h(paramConfiguration), getDisplayMetrics());
    AppMethodBeat.o(141216);
  }
  
  public final void updateConfiguration(Configuration paramConfiguration, DisplayMetrics paramDisplayMetrics)
  {
    int m = 1;
    AppMethodBeat.i(141217);
    super.updateConfiguration(paramConfiguration, paramDisplayMetrics);
    for (;;)
    {
      try
      {
        if (((aw.aXo()) && (MMApplicationContext.isMainProcess())) || (!aw.aXo()))
        {
          e.a(paramConfiguration, this.mResources);
          if (this.mResources != null)
          {
            this.mResources.getConfiguration().updateFrom(paramConfiguration);
            this.mResources.updateConfiguration(paramConfiguration, paramDisplayMetrics);
          }
        }
        Object localObject;
        float f1;
        if (this.acma != null)
        {
          localObject = this.acma;
          j = MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).getInt(c.aclG, 0);
          if (aw.jld() == null) {
            break label1139;
          }
          i = aw.jld().densityDpi;
          if (j == 0) {
            MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).putInt(c.aclG, i);
          }
          Log.i("MicroMsg.MMDensityManager", "dancy test checkDensity, mDensityDpi:%s,  mCurrentDensityDpi:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
          if ((j == 0) || (j == i)) {
            continue;
          }
          MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).putInt(c.aclG, i);
          i = 1;
          if (i == 0)
          {
            if (!c.iRE()) {
              continue;
            }
            i = com.tencent.mm.cd.a.mn(MMApplicationContext.getContext());
            Log.i("MicroMsg.MMDensityManager", "old version text index: %s", new Object[] { Integer.valueOf(i) });
            if ((i == 1) && (!c.iRC())) {
              continue;
            }
            f1 = 1.0F;
            if (!c.iRC()) {
              break label1145;
            }
            i = 0;
            break label1145;
            com.tencent.mm.cd.a.i(MMApplicationContext.getContext(), f1);
            j = 400;
          }
        }
        boolean bool2;
        switch (i)
        {
        case 0: 
          c.axV(i);
          i = 1;
          break label1202;
          Log.i("MicroMsg.MMDensityManager", "checkDensity density change, mIcheckDensitylistener:%s", new Object[] { c.aclO });
          if (c.aclO != null) {
            c.aclO.aCy();
          }
          boolean bool1 = MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).getBoolean(c.aclI, false);
          bool2 = MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).getBoolean(c.aclJ, false);
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
            f2 = c.getDisplayMetrics().density;
            k = (int)(Math.min(i, j) / f1);
            com.tencent.mm.plugin.report.service.h.OAn.b(17089, new Object[] { Integer.valueOf(i), Integer.valueOf(j), Float.toString(f1), Float.toString(f2), Integer.valueOf(k), Integer.valueOf(aw.jle()), Integer.valueOf(aw.jlf()), Integer.valueOf(c.xxg), Integer.valueOf(Math.min(c.aclE.widthPixels, c.aclE.heightPixels)), Float.valueOf(c.aclM) });
            MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).putBoolean(c.aclI, true);
            if (aw.jle() == 0) {
              break label1133;
            }
            j = Math.round(c.xxg / (aw.jle() / 160.0F));
            localDisplayMetrics = aw.jld();
            if (localDisplayMetrics == null) {
              break label1124;
            }
            k = Math.round(Math.min(localDisplayMetrics.heightPixels, localDisplayMetrics.widthPixels) / localDisplayMetrics.density);
            if (k < 550) {
              continue;
            }
            i = 1;
          }
          catch (Exception localException)
          {
            DisplayMetrics localDisplayMetrics;
            float f2;
            int n;
            Log.printErrStackTrace("MicroMsg.MMDensityManager", localException, "", new Object[0]);
            continue;
          }
          if (!bool2)
          {
            i = localDisplayMetrics.widthPixels;
            m = localDisplayMetrics.heightPixels;
            f1 = localDisplayMetrics.density;
            f2 = c.getDisplayMetrics().density;
            n = (int)(Math.min(i, m) / f1);
            com.tencent.mm.plugin.report.service.h.OAn.b(17305, new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(m), Float.toString(f1), Float.toString(f2), Integer.valueOf(n), Integer.valueOf(aw.jle()), Integer.valueOf(aw.jlf()), Integer.valueOf(c.xxg), Integer.valueOf(Math.min(c.aclE.widthPixels, c.aclE.heightPixels)), Float.valueOf(c.aclM) });
            MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).putBoolean(c.aclJ, true);
          }
          if (c.iRE())
          {
            ((c)localObject).iRB();
            localObject = new DisplayMetrics();
            ((WindowManager)MMApplicationContext.getContext().getSystemService("window")).getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
            Log.i("MicroMsg.MMDensityManager", " \n************************************************************************* \nTarget -> %s \nCurrent -> %s \nWindowManager -> %s \nConfiguration -> %s fontScale -> %s \noriginalMetric -> [%s]", new Object[] { c.f(c.euS), c.f(paramDisplayMetrics), c.f((DisplayMetrics)localObject), Integer.valueOf(paramConfiguration.densityDpi), Float.valueOf(paramConfiguration.fontScale), c.aclE });
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
      int i = 0;
      break label1210;
      m = 0;
      break label1218;
      label1124:
      i = 0;
      int k = 0;
      break label1210;
      label1133:
      int j = 0;
      continue;
      label1139:
      i = 0;
      continue;
      label1145:
      switch (i)
      {
      }
      continue;
      i = j;
      continue;
      label1202:
      if (i != 0)
      {
        continue;
        label1210:
        if (j >= 550) {
          label1218:
          if (m == 0) {
            if (i == 0) {}
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ce.d
 * JD-Core Version:    0.7.0.1
 */