package android.support.v7.widget;

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
import java.io.InputStream;

class al
  extends Resources
{
  private final Resources mResources;
  
  public al(Resources paramResources)
  {
    super(paramResources.getAssets(), paramResources.getDisplayMetrics(), paramResources.getConfiguration());
    this.mResources = paramResources;
  }
  
  public XmlResourceParser getAnimation(int paramInt)
  {
    return this.mResources.getAnimation(paramInt);
  }
  
  public boolean getBoolean(int paramInt)
  {
    return this.mResources.getBoolean(paramInt);
  }
  
  public int getColor(int paramInt)
  {
    return this.mResources.getColor(paramInt);
  }
  
  public ColorStateList getColorStateList(int paramInt)
  {
    return this.mResources.getColorStateList(paramInt);
  }
  
  public Configuration getConfiguration()
  {
    return this.mResources.getConfiguration();
  }
  
  public float getDimension(int paramInt)
  {
    return this.mResources.getDimension(paramInt);
  }
  
  public int getDimensionPixelOffset(int paramInt)
  {
    return this.mResources.getDimensionPixelOffset(paramInt);
  }
  
  public int getDimensionPixelSize(int paramInt)
  {
    return this.mResources.getDimensionPixelSize(paramInt);
  }
  
  public DisplayMetrics getDisplayMetrics()
  {
    return this.mResources.getDisplayMetrics();
  }
  
  public Drawable getDrawable(int paramInt)
  {
    return this.mResources.getDrawable(paramInt);
  }
  
  public Drawable getDrawable(int paramInt, Resources.Theme paramTheme)
  {
    return this.mResources.getDrawable(paramInt, paramTheme);
  }
  
  public Drawable getDrawableForDensity(int paramInt1, int paramInt2)
  {
    return this.mResources.getDrawableForDensity(paramInt1, paramInt2);
  }
  
  public Drawable getDrawableForDensity(int paramInt1, int paramInt2, Resources.Theme paramTheme)
  {
    return this.mResources.getDrawableForDensity(paramInt1, paramInt2, paramTheme);
  }
  
  public float getFraction(int paramInt1, int paramInt2, int paramInt3)
  {
    return this.mResources.getFraction(paramInt1, paramInt2, paramInt3);
  }
  
  public int getIdentifier(String paramString1, String paramString2, String paramString3)
  {
    return this.mResources.getIdentifier(paramString1, paramString2, paramString3);
  }
  
  public int[] getIntArray(int paramInt)
  {
    return this.mResources.getIntArray(paramInt);
  }
  
  public int getInteger(int paramInt)
  {
    return this.mResources.getInteger(paramInt);
  }
  
  public XmlResourceParser getLayout(int paramInt)
  {
    return this.mResources.getLayout(paramInt);
  }
  
  public Movie getMovie(int paramInt)
  {
    return this.mResources.getMovie(paramInt);
  }
  
  public String getQuantityString(int paramInt1, int paramInt2)
  {
    return this.mResources.getQuantityString(paramInt1, paramInt2);
  }
  
  public String getQuantityString(int paramInt1, int paramInt2, Object... paramVarArgs)
  {
    return this.mResources.getQuantityString(paramInt1, paramInt2, paramVarArgs);
  }
  
  public CharSequence getQuantityText(int paramInt1, int paramInt2)
  {
    return this.mResources.getQuantityText(paramInt1, paramInt2);
  }
  
  public String getResourceEntryName(int paramInt)
  {
    return this.mResources.getResourceEntryName(paramInt);
  }
  
  public String getResourceName(int paramInt)
  {
    return this.mResources.getResourceName(paramInt);
  }
  
  public String getResourcePackageName(int paramInt)
  {
    return this.mResources.getResourcePackageName(paramInt);
  }
  
  public String getResourceTypeName(int paramInt)
  {
    return this.mResources.getResourceTypeName(paramInt);
  }
  
  public String getString(int paramInt)
  {
    return this.mResources.getString(paramInt);
  }
  
  public String getString(int paramInt, Object... paramVarArgs)
  {
    return this.mResources.getString(paramInt, paramVarArgs);
  }
  
  public String[] getStringArray(int paramInt)
  {
    return this.mResources.getStringArray(paramInt);
  }
  
  public CharSequence getText(int paramInt)
  {
    return this.mResources.getText(paramInt);
  }
  
  public CharSequence getText(int paramInt, CharSequence paramCharSequence)
  {
    return this.mResources.getText(paramInt, paramCharSequence);
  }
  
  public CharSequence[] getTextArray(int paramInt)
  {
    return this.mResources.getTextArray(paramInt);
  }
  
  public void getValue(int paramInt, TypedValue paramTypedValue, boolean paramBoolean)
  {
    this.mResources.getValue(paramInt, paramTypedValue, paramBoolean);
  }
  
  public void getValue(String paramString, TypedValue paramTypedValue, boolean paramBoolean)
  {
    this.mResources.getValue(paramString, paramTypedValue, paramBoolean);
  }
  
  public void getValueForDensity(int paramInt1, int paramInt2, TypedValue paramTypedValue, boolean paramBoolean)
  {
    this.mResources.getValueForDensity(paramInt1, paramInt2, paramTypedValue, paramBoolean);
  }
  
  public XmlResourceParser getXml(int paramInt)
  {
    return this.mResources.getXml(paramInt);
  }
  
  public TypedArray obtainAttributes(AttributeSet paramAttributeSet, int[] paramArrayOfInt)
  {
    return this.mResources.obtainAttributes(paramAttributeSet, paramArrayOfInt);
  }
  
  public TypedArray obtainTypedArray(int paramInt)
  {
    return this.mResources.obtainTypedArray(paramInt);
  }
  
  public InputStream openRawResource(int paramInt)
  {
    return this.mResources.openRawResource(paramInt);
  }
  
  public InputStream openRawResource(int paramInt, TypedValue paramTypedValue)
  {
    return this.mResources.openRawResource(paramInt, paramTypedValue);
  }
  
  public AssetFileDescriptor openRawResourceFd(int paramInt)
  {
    return this.mResources.openRawResourceFd(paramInt);
  }
  
  public void parseBundleExtra(String paramString, AttributeSet paramAttributeSet, Bundle paramBundle)
  {
    this.mResources.parseBundleExtra(paramString, paramAttributeSet, paramBundle);
  }
  
  public void parseBundleExtras(XmlResourceParser paramXmlResourceParser, Bundle paramBundle)
  {
    this.mResources.parseBundleExtras(paramXmlResourceParser, paramBundle);
  }
  
  public void updateConfiguration(Configuration paramConfiguration, DisplayMetrics paramDisplayMetrics)
  {
    super.updateConfiguration(paramConfiguration, paramDisplayMetrics);
    if (this.mResources != null) {
      this.mResources.updateConfiguration(paramConfiguration, paramDisplayMetrics);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.al
 * JD-Core Version:    0.7.0.1
 */