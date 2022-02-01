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
    AppMethodBeat.i(131407);
    this.mResources = paramResources;
    AppMethodBeat.o(131407);
  }
  
  public XmlResourceParser getAnimation(int paramInt)
  {
    AppMethodBeat.i(131435);
    XmlResourceParser localXmlResourceParser = this.mResources.getAnimation(paramInt);
    AppMethodBeat.o(131435);
    return localXmlResourceParser;
  }
  
  public boolean getBoolean(int paramInt)
  {
    AppMethodBeat.i(131432);
    boolean bool = this.mResources.getBoolean(paramInt);
    AppMethodBeat.o(131432);
    return bool;
  }
  
  public int getColor(int paramInt)
  {
    AppMethodBeat.i(131430);
    paramInt = this.mResources.getColor(paramInt);
    AppMethodBeat.o(131430);
    return paramInt;
  }
  
  public int getColor(int paramInt, Resources.Theme paramTheme)
  {
    AppMethodBeat.i(177586);
    paramInt = this.mResources.getColor(paramInt, paramTheme);
    AppMethodBeat.o(177586);
    return paramInt;
  }
  
  public ColorStateList getColorStateList(int paramInt)
  {
    AppMethodBeat.i(131431);
    ColorStateList localColorStateList = this.mResources.getColorStateList(paramInt);
    AppMethodBeat.o(131431);
    return localColorStateList;
  }
  
  public ColorStateList getColorStateList(int paramInt, Resources.Theme paramTheme)
  {
    AppMethodBeat.i(177587);
    paramTheme = this.mResources.getColorStateList(paramInt, paramTheme);
    AppMethodBeat.o(177587);
    return paramTheme;
  }
  
  public Configuration getConfiguration()
  {
    AppMethodBeat.i(131446);
    Configuration localConfiguration = this.mResources.getConfiguration();
    AppMethodBeat.o(131446);
    return localConfiguration;
  }
  
  public float getDimension(int paramInt)
  {
    AppMethodBeat.i(131419);
    float f = this.mResources.getDimension(paramInt);
    AppMethodBeat.o(131419);
    return f;
  }
  
  public int getDimensionPixelOffset(int paramInt)
  {
    AppMethodBeat.i(131421);
    paramInt = this.mResources.getDimensionPixelOffset(paramInt);
    AppMethodBeat.o(131421);
    return paramInt;
  }
  
  public int getDimensionPixelSize(int paramInt)
  {
    AppMethodBeat.i(131423);
    paramInt = this.mResources.getDimensionPixelSize(paramInt);
    AppMethodBeat.o(131423);
    return paramInt;
  }
  
  public DisplayMetrics getDisplayMetrics()
  {
    AppMethodBeat.i(131445);
    DisplayMetrics localDisplayMetrics = this.mResources.getDisplayMetrics();
    AppMethodBeat.o(131445);
    return localDisplayMetrics;
  }
  
  public Drawable getDrawable(int paramInt)
  {
    AppMethodBeat.i(131425);
    Drawable localDrawable = this.mResources.getDrawable(paramInt);
    AppMethodBeat.o(131425);
    return localDrawable;
  }
  
  public Drawable getDrawable(int paramInt, Resources.Theme paramTheme)
  {
    AppMethodBeat.i(131426);
    paramTheme = this.mResources.getDrawable(paramInt, paramTheme);
    AppMethodBeat.o(131426);
    return paramTheme;
  }
  
  public Drawable getDrawableForDensity(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(131427);
    Drawable localDrawable = this.mResources.getDrawableForDensity(paramInt1, paramInt2);
    AppMethodBeat.o(131427);
    return localDrawable;
  }
  
  public Drawable getDrawableForDensity(int paramInt1, int paramInt2, Resources.Theme paramTheme)
  {
    AppMethodBeat.i(131428);
    paramTheme = this.mResources.getDrawableForDensity(paramInt1, paramInt2, paramTheme);
    AppMethodBeat.o(131428);
    return paramTheme;
  }
  
  public float getFraction(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(131424);
    float f = this.mResources.getFraction(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(131424);
    return f;
  }
  
  public int getIdentifier(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(131447);
    int i = this.mResources.getIdentifier(paramString1, paramString2, paramString3);
    AppMethodBeat.o(131447);
    return i;
  }
  
  public int[] getIntArray(int paramInt)
  {
    AppMethodBeat.i(131417);
    int[] arrayOfInt = this.mResources.getIntArray(paramInt);
    AppMethodBeat.o(131417);
    return arrayOfInt;
  }
  
  public int getInteger(int paramInt)
  {
    AppMethodBeat.i(131433);
    paramInt = this.mResources.getInteger(paramInt);
    AppMethodBeat.o(131433);
    return paramInt;
  }
  
  public XmlResourceParser getLayout(int paramInt)
  {
    AppMethodBeat.i(131434);
    XmlResourceParser localXmlResourceParser = this.mResources.getLayout(paramInt);
    AppMethodBeat.o(131434);
    return localXmlResourceParser;
  }
  
  public Movie getMovie(int paramInt)
  {
    AppMethodBeat.i(131429);
    Movie localMovie = this.mResources.getMovie(paramInt);
    AppMethodBeat.o(131429);
    return localMovie;
  }
  
  public String getQuantityString(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(131413);
    String str = this.mResources.getQuantityString(paramInt1, paramInt2);
    AppMethodBeat.o(131413);
    return str;
  }
  
  public String getQuantityString(int paramInt1, int paramInt2, Object... paramVarArgs)
  {
    AppMethodBeat.i(131412);
    paramVarArgs = this.mResources.getQuantityString(paramInt1, paramInt2, paramVarArgs);
    AppMethodBeat.o(131412);
    return paramVarArgs;
  }
  
  public CharSequence getQuantityText(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(131409);
    CharSequence localCharSequence = this.mResources.getQuantityText(paramInt1, paramInt2);
    AppMethodBeat.o(131409);
    return localCharSequence;
  }
  
  public String getResourceEntryName(int paramInt)
  {
    AppMethodBeat.i(131451);
    String str = this.mResources.getResourceEntryName(paramInt);
    AppMethodBeat.o(131451);
    return str;
  }
  
  public String getResourceName(int paramInt)
  {
    AppMethodBeat.i(131448);
    String str = this.mResources.getResourceName(paramInt);
    AppMethodBeat.o(131448);
    return str;
  }
  
  public String getResourcePackageName(int paramInt)
  {
    AppMethodBeat.i(131449);
    String str = this.mResources.getResourcePackageName(paramInt);
    AppMethodBeat.o(131449);
    return str;
  }
  
  public String getResourceTypeName(int paramInt)
  {
    AppMethodBeat.i(131450);
    String str = this.mResources.getResourceTypeName(paramInt);
    AppMethodBeat.o(131450);
    return str;
  }
  
  public String getString(int paramInt)
  {
    AppMethodBeat.i(131410);
    String str = this.mResources.getString(paramInt);
    AppMethodBeat.o(131410);
    return str;
  }
  
  public String getString(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(131411);
    paramVarArgs = this.mResources.getString(paramInt, paramVarArgs);
    AppMethodBeat.o(131411);
    return paramVarArgs;
  }
  
  public String[] getStringArray(int paramInt)
  {
    AppMethodBeat.i(131416);
    String[] arrayOfString = this.mResources.getStringArray(paramInt);
    AppMethodBeat.o(131416);
    return arrayOfString;
  }
  
  public CharSequence getText(int paramInt)
  {
    AppMethodBeat.i(131408);
    CharSequence localCharSequence = this.mResources.getText(paramInt);
    AppMethodBeat.o(131408);
    return localCharSequence;
  }
  
  public CharSequence getText(int paramInt, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(131414);
    paramCharSequence = this.mResources.getText(paramInt, paramCharSequence);
    AppMethodBeat.o(131414);
    return paramCharSequence;
  }
  
  public CharSequence[] getTextArray(int paramInt)
  {
    AppMethodBeat.i(131415);
    CharSequence[] arrayOfCharSequence = this.mResources.getTextArray(paramInt);
    AppMethodBeat.o(131415);
    return arrayOfCharSequence;
  }
  
  public void getValue(int paramInt, TypedValue paramTypedValue, boolean paramBoolean)
  {
    AppMethodBeat.i(131440);
    this.mResources.getValue(paramInt, paramTypedValue, paramBoolean);
    AppMethodBeat.o(131440);
  }
  
  public void getValue(String paramString, TypedValue paramTypedValue, boolean paramBoolean)
  {
    AppMethodBeat.i(131442);
    this.mResources.getValue(paramString, paramTypedValue, paramBoolean);
    AppMethodBeat.o(131442);
  }
  
  public void getValueForDensity(int paramInt1, int paramInt2, TypedValue paramTypedValue, boolean paramBoolean)
  {
    AppMethodBeat.i(131441);
    this.mResources.getValueForDensity(paramInt1, paramInt2, paramTypedValue, paramBoolean);
    AppMethodBeat.o(131441);
  }
  
  public XmlResourceParser getXml(int paramInt)
  {
    AppMethodBeat.i(131436);
    XmlResourceParser localXmlResourceParser = this.mResources.getXml(paramInt);
    AppMethodBeat.o(131436);
    return localXmlResourceParser;
  }
  
  public TypedArray obtainAttributes(AttributeSet paramAttributeSet, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(131443);
    paramAttributeSet = this.mResources.obtainAttributes(paramAttributeSet, paramArrayOfInt);
    AppMethodBeat.o(131443);
    return paramAttributeSet;
  }
  
  public TypedArray obtainTypedArray(int paramInt)
  {
    AppMethodBeat.i(131418);
    TypedArray localTypedArray = this.mResources.obtainTypedArray(paramInt);
    AppMethodBeat.o(131418);
    return localTypedArray;
  }
  
  public InputStream openRawResource(int paramInt)
  {
    AppMethodBeat.i(131437);
    InputStream localInputStream = this.mResources.openRawResource(paramInt);
    AppMethodBeat.o(131437);
    return localInputStream;
  }
  
  public InputStream openRawResource(int paramInt, TypedValue paramTypedValue)
  {
    AppMethodBeat.i(131438);
    paramTypedValue = this.mResources.openRawResource(paramInt, paramTypedValue);
    AppMethodBeat.o(131438);
    return paramTypedValue;
  }
  
  public AssetFileDescriptor openRawResourceFd(int paramInt)
  {
    AppMethodBeat.i(131439);
    AssetFileDescriptor localAssetFileDescriptor = this.mResources.openRawResourceFd(paramInt);
    AppMethodBeat.o(131439);
    return localAssetFileDescriptor;
  }
  
  public void parseBundleExtra(String paramString, AttributeSet paramAttributeSet, Bundle paramBundle)
  {
    AppMethodBeat.i(131453);
    this.mResources.parseBundleExtra(paramString, paramAttributeSet, paramBundle);
    AppMethodBeat.o(131453);
  }
  
  public void parseBundleExtras(XmlResourceParser paramXmlResourceParser, Bundle paramBundle)
  {
    AppMethodBeat.i(131452);
    this.mResources.parseBundleExtras(paramXmlResourceParser, paramBundle);
    AppMethodBeat.o(131452);
  }
  
  public void updateConfiguration(Configuration paramConfiguration, DisplayMetrics paramDisplayMetrics)
  {
    AppMethodBeat.i(131444);
    super.updateConfiguration(paramConfiguration, paramDisplayMetrics);
    if (this.mResources != null) {
      this.mResources.updateConfiguration(paramConfiguration, paramDisplayMetrics);
    }
    AppMethodBeat.o(131444);
  }
  
  public final int zI(int paramInt)
  {
    AppMethodBeat.i(131420);
    paramInt = super.getDimensionPixelOffset(paramInt);
    AppMethodBeat.o(131420);
    return paramInt;
  }
  
  public final int zJ(int paramInt)
  {
    AppMethodBeat.i(131422);
    paramInt = super.getDimensionPixelSize(paramInt);
    AppMethodBeat.o(131422);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.a
 * JD-Core Version:    0.7.0.1
 */