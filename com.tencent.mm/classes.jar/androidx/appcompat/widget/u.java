package androidx.appcompat.widget;

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

class u
  extends Resources
{
  private final Resources mResources;
  
  public u(Resources paramResources)
  {
    super(paramResources.getAssets(), paramResources.getDisplayMetrics(), paramResources.getConfiguration());
    AppMethodBeat.i(241453);
    this.mResources = paramResources;
    AppMethodBeat.o(241453);
  }
  
  public XmlResourceParser getAnimation(int paramInt)
  {
    AppMethodBeat.i(241484);
    XmlResourceParser localXmlResourceParser = this.mResources.getAnimation(paramInt);
    AppMethodBeat.o(241484);
    return localXmlResourceParser;
  }
  
  public boolean getBoolean(int paramInt)
  {
    AppMethodBeat.i(241479);
    boolean bool = this.mResources.getBoolean(paramInt);
    AppMethodBeat.o(241479);
    return bool;
  }
  
  public int getColor(int paramInt)
  {
    AppMethodBeat.i(241477);
    paramInt = this.mResources.getColor(paramInt);
    AppMethodBeat.o(241477);
    return paramInt;
  }
  
  public ColorStateList getColorStateList(int paramInt)
  {
    AppMethodBeat.i(241478);
    ColorStateList localColorStateList = this.mResources.getColorStateList(paramInt);
    AppMethodBeat.o(241478);
    return localColorStateList;
  }
  
  public Configuration getConfiguration()
  {
    AppMethodBeat.i(241502);
    Configuration localConfiguration = this.mResources.getConfiguration();
    AppMethodBeat.o(241502);
    return localConfiguration;
  }
  
  public float getDimension(int paramInt)
  {
    AppMethodBeat.i(241467);
    float f = this.mResources.getDimension(paramInt);
    AppMethodBeat.o(241467);
    return f;
  }
  
  public int getDimensionPixelOffset(int paramInt)
  {
    AppMethodBeat.i(241468);
    paramInt = this.mResources.getDimensionPixelOffset(paramInt);
    AppMethodBeat.o(241468);
    return paramInt;
  }
  
  public int getDimensionPixelSize(int paramInt)
  {
    AppMethodBeat.i(241469);
    paramInt = this.mResources.getDimensionPixelSize(paramInt);
    AppMethodBeat.o(241469);
    return paramInt;
  }
  
  public DisplayMetrics getDisplayMetrics()
  {
    AppMethodBeat.i(241501);
    DisplayMetrics localDisplayMetrics = this.mResources.getDisplayMetrics();
    AppMethodBeat.o(241501);
    return localDisplayMetrics;
  }
  
  public Drawable getDrawable(int paramInt)
  {
    AppMethodBeat.i(241471);
    Drawable localDrawable = this.mResources.getDrawable(paramInt);
    AppMethodBeat.o(241471);
    return localDrawable;
  }
  
  public Drawable getDrawable(int paramInt, Resources.Theme paramTheme)
  {
    AppMethodBeat.i(241472);
    paramTheme = this.mResources.getDrawable(paramInt, paramTheme);
    AppMethodBeat.o(241472);
    return paramTheme;
  }
  
  public Drawable getDrawableForDensity(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(241473);
    Drawable localDrawable = this.mResources.getDrawableForDensity(paramInt1, paramInt2);
    AppMethodBeat.o(241473);
    return localDrawable;
  }
  
  public Drawable getDrawableForDensity(int paramInt1, int paramInt2, Resources.Theme paramTheme)
  {
    AppMethodBeat.i(241474);
    paramTheme = this.mResources.getDrawableForDensity(paramInt1, paramInt2, paramTheme);
    AppMethodBeat.o(241474);
    return paramTheme;
  }
  
  public float getFraction(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(241470);
    float f = this.mResources.getFraction(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(241470);
    return f;
  }
  
  public int getIdentifier(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(241503);
    int i = this.mResources.getIdentifier(paramString1, paramString2, paramString3);
    AppMethodBeat.o(241503);
    return i;
  }
  
  public int[] getIntArray(int paramInt)
  {
    AppMethodBeat.i(241465);
    int[] arrayOfInt = this.mResources.getIntArray(paramInt);
    AppMethodBeat.o(241465);
    return arrayOfInt;
  }
  
  public int getInteger(int paramInt)
  {
    AppMethodBeat.i(241481);
    paramInt = this.mResources.getInteger(paramInt);
    AppMethodBeat.o(241481);
    return paramInt;
  }
  
  public XmlResourceParser getLayout(int paramInt)
  {
    AppMethodBeat.i(241483);
    XmlResourceParser localXmlResourceParser = this.mResources.getLayout(paramInt);
    AppMethodBeat.o(241483);
    return localXmlResourceParser;
  }
  
  public Movie getMovie(int paramInt)
  {
    AppMethodBeat.i(241476);
    Movie localMovie = this.mResources.getMovie(paramInt);
    AppMethodBeat.o(241476);
    return localMovie;
  }
  
  public String getQuantityString(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(241461);
    String str = this.mResources.getQuantityString(paramInt1, paramInt2);
    AppMethodBeat.o(241461);
    return str;
  }
  
  public String getQuantityString(int paramInt1, int paramInt2, Object... paramVarArgs)
  {
    AppMethodBeat.i(241460);
    paramVarArgs = this.mResources.getQuantityString(paramInt1, paramInt2, paramVarArgs);
    AppMethodBeat.o(241460);
    return paramVarArgs;
  }
  
  public CharSequence getQuantityText(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(241456);
    CharSequence localCharSequence = this.mResources.getQuantityText(paramInt1, paramInt2);
    AppMethodBeat.o(241456);
    return localCharSequence;
  }
  
  public String getResourceEntryName(int paramInt)
  {
    AppMethodBeat.i(241511);
    String str = this.mResources.getResourceEntryName(paramInt);
    AppMethodBeat.o(241511);
    return str;
  }
  
  public String getResourceName(int paramInt)
  {
    AppMethodBeat.i(241504);
    String str = this.mResources.getResourceName(paramInt);
    AppMethodBeat.o(241504);
    return str;
  }
  
  public String getResourcePackageName(int paramInt)
  {
    AppMethodBeat.i(241506);
    String str = this.mResources.getResourcePackageName(paramInt);
    AppMethodBeat.o(241506);
    return str;
  }
  
  public String getResourceTypeName(int paramInt)
  {
    AppMethodBeat.i(241508);
    String str = this.mResources.getResourceTypeName(paramInt);
    AppMethodBeat.o(241508);
    return str;
  }
  
  public String getString(int paramInt)
  {
    AppMethodBeat.i(241458);
    String str = this.mResources.getString(paramInt);
    AppMethodBeat.o(241458);
    return str;
  }
  
  public String getString(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(241459);
    paramVarArgs = this.mResources.getString(paramInt, paramVarArgs);
    AppMethodBeat.o(241459);
    return paramVarArgs;
  }
  
  public String[] getStringArray(int paramInt)
  {
    AppMethodBeat.i(241464);
    String[] arrayOfString = this.mResources.getStringArray(paramInt);
    AppMethodBeat.o(241464);
    return arrayOfString;
  }
  
  public CharSequence getText(int paramInt)
  {
    AppMethodBeat.i(241454);
    CharSequence localCharSequence = this.mResources.getText(paramInt);
    AppMethodBeat.o(241454);
    return localCharSequence;
  }
  
  public CharSequence getText(int paramInt, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(241462);
    paramCharSequence = this.mResources.getText(paramInt, paramCharSequence);
    AppMethodBeat.o(241462);
    return paramCharSequence;
  }
  
  public CharSequence[] getTextArray(int paramInt)
  {
    AppMethodBeat.i(241463);
    CharSequence[] arrayOfCharSequence = this.mResources.getTextArray(paramInt);
    AppMethodBeat.o(241463);
    return arrayOfCharSequence;
  }
  
  public void getValue(int paramInt, TypedValue paramTypedValue, boolean paramBoolean)
  {
    AppMethodBeat.i(241493);
    this.mResources.getValue(paramInt, paramTypedValue, paramBoolean);
    AppMethodBeat.o(241493);
  }
  
  public void getValue(String paramString, TypedValue paramTypedValue, boolean paramBoolean)
  {
    AppMethodBeat.i(241497);
    this.mResources.getValue(paramString, paramTypedValue, paramBoolean);
    AppMethodBeat.o(241497);
  }
  
  public void getValueForDensity(int paramInt1, int paramInt2, TypedValue paramTypedValue, boolean paramBoolean)
  {
    AppMethodBeat.i(241495);
    this.mResources.getValueForDensity(paramInt1, paramInt2, paramTypedValue, paramBoolean);
    AppMethodBeat.o(241495);
  }
  
  public XmlResourceParser getXml(int paramInt)
  {
    AppMethodBeat.i(241486);
    XmlResourceParser localXmlResourceParser = this.mResources.getXml(paramInt);
    AppMethodBeat.o(241486);
    return localXmlResourceParser;
  }
  
  public TypedArray obtainAttributes(AttributeSet paramAttributeSet, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(241499);
    paramAttributeSet = this.mResources.obtainAttributes(paramAttributeSet, paramArrayOfInt);
    AppMethodBeat.o(241499);
    return paramAttributeSet;
  }
  
  public TypedArray obtainTypedArray(int paramInt)
  {
    AppMethodBeat.i(241466);
    TypedArray localTypedArray = this.mResources.obtainTypedArray(paramInt);
    AppMethodBeat.o(241466);
    return localTypedArray;
  }
  
  public InputStream openRawResource(int paramInt)
  {
    AppMethodBeat.i(241487);
    InputStream localInputStream = this.mResources.openRawResource(paramInt);
    AppMethodBeat.o(241487);
    return localInputStream;
  }
  
  public InputStream openRawResource(int paramInt, TypedValue paramTypedValue)
  {
    AppMethodBeat.i(241489);
    paramTypedValue = this.mResources.openRawResource(paramInt, paramTypedValue);
    AppMethodBeat.o(241489);
    return paramTypedValue;
  }
  
  public AssetFileDescriptor openRawResourceFd(int paramInt)
  {
    AppMethodBeat.i(241491);
    AssetFileDescriptor localAssetFileDescriptor = this.mResources.openRawResourceFd(paramInt);
    AppMethodBeat.o(241491);
    return localAssetFileDescriptor;
  }
  
  public void parseBundleExtra(String paramString, AttributeSet paramAttributeSet, Bundle paramBundle)
  {
    AppMethodBeat.i(241517);
    this.mResources.parseBundleExtra(paramString, paramAttributeSet, paramBundle);
    AppMethodBeat.o(241517);
  }
  
  public void parseBundleExtras(XmlResourceParser paramXmlResourceParser, Bundle paramBundle)
  {
    AppMethodBeat.i(241514);
    this.mResources.parseBundleExtras(paramXmlResourceParser, paramBundle);
    AppMethodBeat.o(241514);
  }
  
  public void updateConfiguration(Configuration paramConfiguration, DisplayMetrics paramDisplayMetrics)
  {
    AppMethodBeat.i(241500);
    super.updateConfiguration(paramConfiguration, paramDisplayMetrics);
    if (this.mResources != null) {
      this.mResources.updateConfiguration(paramConfiguration, paramDisplayMetrics);
    }
    AppMethodBeat.o(241500);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     androidx.appcompat.widget.u
 * JD-Core Version:    0.7.0.1
 */