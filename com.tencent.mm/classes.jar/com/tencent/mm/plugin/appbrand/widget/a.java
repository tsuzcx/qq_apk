package com.tencent.mm.plugin.appbrand.widget;

import android.content.res.AssetFileDescriptor;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

public class a
  extends Resources
{
  private final Resources mResources;
  
  public a(Resources paramResources)
  {
    super(paramResources.getAssets(), paramResources.getDisplayMetrics(), paramResources.getConfiguration());
    AppMethodBeat.i(142973);
    this.mResources = paramResources;
    AppMethodBeat.o(142973);
  }
  
  public XmlResourceParser getAnimation(int paramInt)
  {
    AppMethodBeat.i(143001);
    XmlResourceParser localXmlResourceParser = this.mResources.getAnimation(paramInt);
    AppMethodBeat.o(143001);
    return localXmlResourceParser;
  }
  
  public boolean getBoolean(int paramInt)
  {
    AppMethodBeat.i(142998);
    boolean bool = this.mResources.getBoolean(paramInt);
    AppMethodBeat.o(142998);
    return bool;
  }
  
  public int getColor(int paramInt)
  {
    AppMethodBeat.i(142996);
    paramInt = this.mResources.getColor(paramInt);
    AppMethodBeat.o(142996);
    return paramInt;
  }
  
  public ColorStateList getColorStateList(int paramInt)
  {
    AppMethodBeat.i(142997);
    ColorStateList localColorStateList = this.mResources.getColorStateList(paramInt);
    AppMethodBeat.o(142997);
    return localColorStateList;
  }
  
  public Configuration getConfiguration()
  {
    AppMethodBeat.i(143012);
    Configuration localConfiguration = this.mResources.getConfiguration();
    AppMethodBeat.o(143012);
    return localConfiguration;
  }
  
  public float getDimension(int paramInt)
  {
    AppMethodBeat.i(142985);
    float f = this.mResources.getDimension(paramInt);
    AppMethodBeat.o(142985);
    return f;
  }
  
  public int getDimensionPixelOffset(int paramInt)
  {
    AppMethodBeat.i(142987);
    paramInt = this.mResources.getDimensionPixelOffset(paramInt);
    AppMethodBeat.o(142987);
    return paramInt;
  }
  
  public int getDimensionPixelSize(int paramInt)
  {
    AppMethodBeat.i(142989);
    paramInt = this.mResources.getDimensionPixelSize(paramInt);
    AppMethodBeat.o(142989);
    return paramInt;
  }
  
  public DisplayMetrics getDisplayMetrics()
  {
    AppMethodBeat.i(143011);
    DisplayMetrics localDisplayMetrics = this.mResources.getDisplayMetrics();
    AppMethodBeat.o(143011);
    return localDisplayMetrics;
  }
  
  public Drawable getDrawable(int paramInt)
  {
    AppMethodBeat.i(142991);
    Drawable localDrawable = this.mResources.getDrawable(paramInt);
    AppMethodBeat.o(142991);
    return localDrawable;
  }
  
  public Drawable getDrawable(int paramInt, Resources.Theme paramTheme)
  {
    AppMethodBeat.i(142992);
    paramTheme = this.mResources.getDrawable(paramInt, paramTheme);
    AppMethodBeat.o(142992);
    return paramTheme;
  }
  
  public Drawable getDrawableForDensity(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(142993);
    Drawable localDrawable = this.mResources.getDrawableForDensity(paramInt1, paramInt2);
    AppMethodBeat.o(142993);
    return localDrawable;
  }
  
  public Drawable getDrawableForDensity(int paramInt1, int paramInt2, Resources.Theme paramTheme)
  {
    AppMethodBeat.i(142994);
    paramTheme = this.mResources.getDrawableForDensity(paramInt1, paramInt2, paramTheme);
    AppMethodBeat.o(142994);
    return paramTheme;
  }
  
  public float getFraction(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(142990);
    float f = this.mResources.getFraction(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(142990);
    return f;
  }
  
  public int getIdentifier(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(143013);
    int i = this.mResources.getIdentifier(paramString1, paramString2, paramString3);
    AppMethodBeat.o(143013);
    return i;
  }
  
  public int[] getIntArray(int paramInt)
  {
    AppMethodBeat.i(142983);
    int[] arrayOfInt = this.mResources.getIntArray(paramInt);
    AppMethodBeat.o(142983);
    return arrayOfInt;
  }
  
  public int getInteger(int paramInt)
  {
    AppMethodBeat.i(142999);
    paramInt = this.mResources.getInteger(paramInt);
    AppMethodBeat.o(142999);
    return paramInt;
  }
  
  public XmlResourceParser getLayout(int paramInt)
  {
    AppMethodBeat.i(143000);
    XmlResourceParser localXmlResourceParser = this.mResources.getLayout(paramInt);
    AppMethodBeat.o(143000);
    return localXmlResourceParser;
  }
  
  public Movie getMovie(int paramInt)
  {
    AppMethodBeat.i(142995);
    Movie localMovie = this.mResources.getMovie(paramInt);
    AppMethodBeat.o(142995);
    return localMovie;
  }
  
  public String getQuantityString(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(142979);
    String str = this.mResources.getQuantityString(paramInt1, paramInt2);
    AppMethodBeat.o(142979);
    return str;
  }
  
  public String getQuantityString(int paramInt1, int paramInt2, Object... paramVarArgs)
  {
    AppMethodBeat.i(142978);
    paramVarArgs = this.mResources.getQuantityString(paramInt1, paramInt2, paramVarArgs);
    AppMethodBeat.o(142978);
    return paramVarArgs;
  }
  
  public CharSequence getQuantityText(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(142975);
    CharSequence localCharSequence = this.mResources.getQuantityText(paramInt1, paramInt2);
    AppMethodBeat.o(142975);
    return localCharSequence;
  }
  
  public String getResourceEntryName(int paramInt)
  {
    AppMethodBeat.i(143017);
    String str = this.mResources.getResourceEntryName(paramInt);
    AppMethodBeat.o(143017);
    return str;
  }
  
  public String getResourceName(int paramInt)
  {
    AppMethodBeat.i(143014);
    String str = this.mResources.getResourceName(paramInt);
    AppMethodBeat.o(143014);
    return str;
  }
  
  public String getResourcePackageName(int paramInt)
  {
    AppMethodBeat.i(143015);
    String str = this.mResources.getResourcePackageName(paramInt);
    AppMethodBeat.o(143015);
    return str;
  }
  
  public String getResourceTypeName(int paramInt)
  {
    AppMethodBeat.i(143016);
    String str = this.mResources.getResourceTypeName(paramInt);
    AppMethodBeat.o(143016);
    return str;
  }
  
  public String getString(int paramInt)
  {
    AppMethodBeat.i(142976);
    String str = this.mResources.getString(paramInt);
    AppMethodBeat.o(142976);
    return str;
  }
  
  public String getString(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(142977);
    paramVarArgs = this.mResources.getString(paramInt, paramVarArgs);
    AppMethodBeat.o(142977);
    return paramVarArgs;
  }
  
  public String[] getStringArray(int paramInt)
  {
    AppMethodBeat.i(142982);
    String[] arrayOfString = this.mResources.getStringArray(paramInt);
    AppMethodBeat.o(142982);
    return arrayOfString;
  }
  
  public CharSequence getText(int paramInt)
  {
    AppMethodBeat.i(142974);
    CharSequence localCharSequence = this.mResources.getText(paramInt);
    AppMethodBeat.o(142974);
    return localCharSequence;
  }
  
  public CharSequence getText(int paramInt, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(142980);
    paramCharSequence = this.mResources.getText(paramInt, paramCharSequence);
    AppMethodBeat.o(142980);
    return paramCharSequence;
  }
  
  public CharSequence[] getTextArray(int paramInt)
  {
    AppMethodBeat.i(142981);
    CharSequence[] arrayOfCharSequence = this.mResources.getTextArray(paramInt);
    AppMethodBeat.o(142981);
    return arrayOfCharSequence;
  }
  
  public void getValue(int paramInt, TypedValue paramTypedValue, boolean paramBoolean)
  {
    AppMethodBeat.i(143006);
    this.mResources.getValue(paramInt, paramTypedValue, paramBoolean);
    AppMethodBeat.o(143006);
  }
  
  public void getValue(String paramString, TypedValue paramTypedValue, boolean paramBoolean)
  {
    AppMethodBeat.i(143008);
    this.mResources.getValue(paramString, paramTypedValue, paramBoolean);
    AppMethodBeat.o(143008);
  }
  
  public void getValueForDensity(int paramInt1, int paramInt2, TypedValue paramTypedValue, boolean paramBoolean)
  {
    AppMethodBeat.i(143007);
    this.mResources.getValueForDensity(paramInt1, paramInt2, paramTypedValue, paramBoolean);
    AppMethodBeat.o(143007);
  }
  
  public XmlResourceParser getXml(int paramInt)
  {
    AppMethodBeat.i(143002);
    XmlResourceParser localXmlResourceParser = this.mResources.getXml(paramInt);
    AppMethodBeat.o(143002);
    return localXmlResourceParser;
  }
  
  public TypedArray obtainAttributes(AttributeSet paramAttributeSet, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(143009);
    paramAttributeSet = this.mResources.obtainAttributes(paramAttributeSet, paramArrayOfInt);
    AppMethodBeat.o(143009);
    return paramAttributeSet;
  }
  
  public TypedArray obtainTypedArray(int paramInt)
  {
    AppMethodBeat.i(142984);
    TypedArray localTypedArray = this.mResources.obtainTypedArray(paramInt);
    AppMethodBeat.o(142984);
    return localTypedArray;
  }
  
  public InputStream openRawResource(int paramInt)
  {
    AppMethodBeat.i(143003);
    InputStream localInputStream = this.mResources.openRawResource(paramInt);
    AppMethodBeat.o(143003);
    return localInputStream;
  }
  
  public InputStream openRawResource(int paramInt, TypedValue paramTypedValue)
  {
    AppMethodBeat.i(143004);
    paramTypedValue = this.mResources.openRawResource(paramInt, paramTypedValue);
    AppMethodBeat.o(143004);
    return paramTypedValue;
  }
  
  public AssetFileDescriptor openRawResourceFd(int paramInt)
  {
    AppMethodBeat.i(143005);
    AssetFileDescriptor localAssetFileDescriptor = this.mResources.openRawResourceFd(paramInt);
    AppMethodBeat.o(143005);
    return localAssetFileDescriptor;
  }
  
  public final int pS(int paramInt)
  {
    AppMethodBeat.i(142986);
    paramInt = super.getDimensionPixelOffset(paramInt);
    AppMethodBeat.o(142986);
    return paramInt;
  }
  
  public final int pT(int paramInt)
  {
    AppMethodBeat.i(142988);
    paramInt = super.getDimensionPixelSize(paramInt);
    AppMethodBeat.o(142988);
    return paramInt;
  }
  
  public void parseBundleExtra(String paramString, AttributeSet paramAttributeSet, Bundle paramBundle)
  {
    AppMethodBeat.i(143019);
    this.mResources.parseBundleExtra(paramString, paramAttributeSet, paramBundle);
    AppMethodBeat.o(143019);
  }
  
  public void parseBundleExtras(XmlResourceParser paramXmlResourceParser, Bundle paramBundle)
  {
    AppMethodBeat.i(143018);
    this.mResources.parseBundleExtras(paramXmlResourceParser, paramBundle);
    AppMethodBeat.o(143018);
  }
  
  public void updateConfiguration(Configuration paramConfiguration, DisplayMetrics paramDisplayMetrics)
  {
    AppMethodBeat.i(143010);
    super.updateConfiguration(paramConfiguration, paramDisplayMetrics);
    if (this.mResources != null) {
      this.mResources.updateConfiguration(paramConfiguration, paramDisplayMetrics);
    }
    AppMethodBeat.o(143010);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.a
 * JD-Core Version:    0.7.0.1
 */