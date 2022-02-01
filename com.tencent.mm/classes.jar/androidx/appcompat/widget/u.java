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
    AppMethodBeat.i(199750);
    this.mResources = paramResources;
    AppMethodBeat.o(199750);
  }
  
  public XmlResourceParser getAnimation(int paramInt)
  {
    AppMethodBeat.i(200008);
    XmlResourceParser localXmlResourceParser = this.mResources.getAnimation(paramInt);
    AppMethodBeat.o(200008);
    return localXmlResourceParser;
  }
  
  public boolean getBoolean(int paramInt)
  {
    AppMethodBeat.i(199982);
    boolean bool = this.mResources.getBoolean(paramInt);
    AppMethodBeat.o(199982);
    return bool;
  }
  
  public int getColor(int paramInt)
  {
    AppMethodBeat.i(199967);
    paramInt = this.mResources.getColor(paramInt);
    AppMethodBeat.o(199967);
    return paramInt;
  }
  
  public ColorStateList getColorStateList(int paramInt)
  {
    AppMethodBeat.i(199976);
    ColorStateList localColorStateList = this.mResources.getColorStateList(paramInt);
    AppMethodBeat.o(199976);
    return localColorStateList;
  }
  
  public Configuration getConfiguration()
  {
    AppMethodBeat.i(200104);
    Configuration localConfiguration = this.mResources.getConfiguration();
    AppMethodBeat.o(200104);
    return localConfiguration;
  }
  
  public float getDimension(int paramInt)
  {
    AppMethodBeat.i(199853);
    float f = this.mResources.getDimension(paramInt);
    AppMethodBeat.o(199853);
    return f;
  }
  
  public int getDimensionPixelOffset(int paramInt)
  {
    AppMethodBeat.i(199862);
    paramInt = this.mResources.getDimensionPixelOffset(paramInt);
    AppMethodBeat.o(199862);
    return paramInt;
  }
  
  public int getDimensionPixelSize(int paramInt)
  {
    AppMethodBeat.i(199873);
    paramInt = this.mResources.getDimensionPixelSize(paramInt);
    AppMethodBeat.o(199873);
    return paramInt;
  }
  
  public DisplayMetrics getDisplayMetrics()
  {
    AppMethodBeat.i(200100);
    DisplayMetrics localDisplayMetrics = this.mResources.getDisplayMetrics();
    AppMethodBeat.o(200100);
    return localDisplayMetrics;
  }
  
  public Drawable getDrawable(int paramInt)
  {
    AppMethodBeat.i(199889);
    Drawable localDrawable = this.mResources.getDrawable(paramInt);
    AppMethodBeat.o(199889);
    return localDrawable;
  }
  
  public Drawable getDrawable(int paramInt, Resources.Theme paramTheme)
  {
    AppMethodBeat.i(199926);
    paramTheme = this.mResources.getDrawable(paramInt, paramTheme);
    AppMethodBeat.o(199926);
    return paramTheme;
  }
  
  public Drawable getDrawableForDensity(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(199933);
    Drawable localDrawable = this.mResources.getDrawableForDensity(paramInt1, paramInt2);
    AppMethodBeat.o(199933);
    return localDrawable;
  }
  
  public Drawable getDrawableForDensity(int paramInt1, int paramInt2, Resources.Theme paramTheme)
  {
    AppMethodBeat.i(199944);
    paramTheme = this.mResources.getDrawableForDensity(paramInt1, paramInt2, paramTheme);
    AppMethodBeat.o(199944);
    return paramTheme;
  }
  
  public float getFraction(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(199882);
    float f = this.mResources.getFraction(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(199882);
    return f;
  }
  
  public int getIdentifier(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(200113);
    int i = this.mResources.getIdentifier(paramString1, paramString2, paramString3);
    AppMethodBeat.o(200113);
    return i;
  }
  
  public int[] getIntArray(int paramInt)
  {
    AppMethodBeat.i(199832);
    int[] arrayOfInt = this.mResources.getIntArray(paramInt);
    AppMethodBeat.o(199832);
    return arrayOfInt;
  }
  
  public int getInteger(int paramInt)
  {
    AppMethodBeat.i(199991);
    paramInt = this.mResources.getInteger(paramInt);
    AppMethodBeat.o(199991);
    return paramInt;
  }
  
  public XmlResourceParser getLayout(int paramInt)
  {
    AppMethodBeat.i(199998);
    XmlResourceParser localXmlResourceParser = this.mResources.getLayout(paramInt);
    AppMethodBeat.o(199998);
    return localXmlResourceParser;
  }
  
  public Movie getMovie(int paramInt)
  {
    AppMethodBeat.i(199959);
    Movie localMovie = this.mResources.getMovie(paramInt);
    AppMethodBeat.o(199959);
    return localMovie;
  }
  
  public String getQuantityString(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(199799);
    String str = this.mResources.getQuantityString(paramInt1, paramInt2);
    AppMethodBeat.o(199799);
    return str;
  }
  
  public String getQuantityString(int paramInt1, int paramInt2, Object... paramVarArgs)
  {
    AppMethodBeat.i(199790);
    paramVarArgs = this.mResources.getQuantityString(paramInt1, paramInt2, paramVarArgs);
    AppMethodBeat.o(199790);
    return paramVarArgs;
  }
  
  public CharSequence getQuantityText(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(199767);
    CharSequence localCharSequence = this.mResources.getQuantityText(paramInt1, paramInt2);
    AppMethodBeat.o(199767);
    return localCharSequence;
  }
  
  public String getResourceEntryName(int paramInt)
  {
    AppMethodBeat.i(200143);
    String str = this.mResources.getResourceEntryName(paramInt);
    AppMethodBeat.o(200143);
    return str;
  }
  
  public String getResourceName(int paramInt)
  {
    AppMethodBeat.i(200119);
    String str = this.mResources.getResourceName(paramInt);
    AppMethodBeat.o(200119);
    return str;
  }
  
  public String getResourcePackageName(int paramInt)
  {
    AppMethodBeat.i(200129);
    String str = this.mResources.getResourcePackageName(paramInt);
    AppMethodBeat.o(200129);
    return str;
  }
  
  public String getResourceTypeName(int paramInt)
  {
    AppMethodBeat.i(200133);
    String str = this.mResources.getResourceTypeName(paramInt);
    AppMethodBeat.o(200133);
    return str;
  }
  
  public String getString(int paramInt)
  {
    AppMethodBeat.i(199775);
    String str = this.mResources.getString(paramInt);
    AppMethodBeat.o(199775);
    return str;
  }
  
  public String getString(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(199781);
    paramVarArgs = this.mResources.getString(paramInt, paramVarArgs);
    AppMethodBeat.o(199781);
    return paramVarArgs;
  }
  
  public String[] getStringArray(int paramInt)
  {
    AppMethodBeat.i(199823);
    String[] arrayOfString = this.mResources.getStringArray(paramInt);
    AppMethodBeat.o(199823);
    return arrayOfString;
  }
  
  public CharSequence getText(int paramInt)
  {
    AppMethodBeat.i(199757);
    CharSequence localCharSequence = this.mResources.getText(paramInt);
    AppMethodBeat.o(199757);
    return localCharSequence;
  }
  
  public CharSequence getText(int paramInt, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(199806);
    paramCharSequence = this.mResources.getText(paramInt, paramCharSequence);
    AppMethodBeat.o(199806);
    return paramCharSequence;
  }
  
  public CharSequence[] getTextArray(int paramInt)
  {
    AppMethodBeat.i(199815);
    CharSequence[] arrayOfCharSequence = this.mResources.getTextArray(paramInt);
    AppMethodBeat.o(199815);
    return arrayOfCharSequence;
  }
  
  public void getValue(int paramInt, TypedValue paramTypedValue, boolean paramBoolean)
  {
    AppMethodBeat.i(200056);
    this.mResources.getValue(paramInt, paramTypedValue, paramBoolean);
    AppMethodBeat.o(200056);
  }
  
  public void getValue(String paramString, TypedValue paramTypedValue, boolean paramBoolean)
  {
    AppMethodBeat.i(200072);
    this.mResources.getValue(paramString, paramTypedValue, paramBoolean);
    AppMethodBeat.o(200072);
  }
  
  public void getValueForDensity(int paramInt1, int paramInt2, TypedValue paramTypedValue, boolean paramBoolean)
  {
    AppMethodBeat.i(200065);
    this.mResources.getValueForDensity(paramInt1, paramInt2, paramTypedValue, paramBoolean);
    AppMethodBeat.o(200065);
  }
  
  public XmlResourceParser getXml(int paramInt)
  {
    AppMethodBeat.i(200020);
    XmlResourceParser localXmlResourceParser = this.mResources.getXml(paramInt);
    AppMethodBeat.o(200020);
    return localXmlResourceParser;
  }
  
  public TypedArray obtainAttributes(AttributeSet paramAttributeSet, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(200082);
    paramAttributeSet = this.mResources.obtainAttributes(paramAttributeSet, paramArrayOfInt);
    AppMethodBeat.o(200082);
    return paramAttributeSet;
  }
  
  public TypedArray obtainTypedArray(int paramInt)
  {
    AppMethodBeat.i(199841);
    TypedArray localTypedArray = this.mResources.obtainTypedArray(paramInt);
    AppMethodBeat.o(199841);
    return localTypedArray;
  }
  
  public InputStream openRawResource(int paramInt)
  {
    AppMethodBeat.i(200029);
    InputStream localInputStream = this.mResources.openRawResource(paramInt);
    AppMethodBeat.o(200029);
    return localInputStream;
  }
  
  public InputStream openRawResource(int paramInt, TypedValue paramTypedValue)
  {
    AppMethodBeat.i(200038);
    paramTypedValue = this.mResources.openRawResource(paramInt, paramTypedValue);
    AppMethodBeat.o(200038);
    return paramTypedValue;
  }
  
  public AssetFileDescriptor openRawResourceFd(int paramInt)
  {
    AppMethodBeat.i(200046);
    AssetFileDescriptor localAssetFileDescriptor = this.mResources.openRawResourceFd(paramInt);
    AppMethodBeat.o(200046);
    return localAssetFileDescriptor;
  }
  
  public void parseBundleExtra(String paramString, AttributeSet paramAttributeSet, Bundle paramBundle)
  {
    AppMethodBeat.i(200161);
    this.mResources.parseBundleExtra(paramString, paramAttributeSet, paramBundle);
    AppMethodBeat.o(200161);
  }
  
  public void parseBundleExtras(XmlResourceParser paramXmlResourceParser, Bundle paramBundle)
  {
    AppMethodBeat.i(200149);
    this.mResources.parseBundleExtras(paramXmlResourceParser, paramBundle);
    AppMethodBeat.o(200149);
  }
  
  public void updateConfiguration(Configuration paramConfiguration, DisplayMetrics paramDisplayMetrics)
  {
    AppMethodBeat.i(200090);
    super.updateConfiguration(paramConfiguration, paramDisplayMetrics);
    if (this.mResources != null) {
      this.mResources.updateConfiguration(paramConfiguration, paramDisplayMetrics);
    }
    AppMethodBeat.o(200090);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.widget.u
 * JD-Core Version:    0.7.0.1
 */