package com.samsung.android.sdk.look.airbutton;

import android.graphics.drawable.Drawable;
import android.view.View;

public class SlookAirButtonAdapter$AirButtonItem
{
  private Object mData = null;
  private String mDescription = null;
  private Drawable mImage = null;
  private String mSubDescription = null;
  private View mView = null;
  
  public SlookAirButtonAdapter$AirButtonItem(Drawable paramDrawable, String paramString, Object paramObject)
  {
    if ((paramDrawable == null) && (paramString == null) && (paramObject == null)) {
      throw new IllegalArgumentException("You should set the Drawable, String and Object in Param");
    }
    set(paramDrawable, paramString, paramObject);
  }
  
  public SlookAirButtonAdapter$AirButtonItem(Drawable paramDrawable, String paramString1, String paramString2, Object paramObject)
  {
    if ((paramDrawable == null) && (paramString1 == null) && (paramString2 == null) && (paramObject == null)) {
      throw new IllegalArgumentException("You should set the Drawable, String, subDescription and Object in Param");
    }
    set(paramDrawable, paramString1, paramString2, paramObject);
  }
  
  public SlookAirButtonAdapter$AirButtonItem(View paramView, Object paramObject)
  {
    if ((paramView == null) && (paramObject == null)) {
      throw new IllegalArgumentException("You should set the View and Object in Param");
    }
    set(paramView, paramObject);
  }
  
  public Object getData()
  {
    return this.mData;
  }
  
  public String getDescription()
  {
    return this.mDescription;
  }
  
  public Drawable getImage()
  {
    return this.mImage;
  }
  
  public String getSubDescription()
  {
    return this.mSubDescription;
  }
  
  public View getView()
  {
    return this.mView;
  }
  
  public void set(Drawable paramDrawable, String paramString, Object paramObject)
  {
    this.mImage = paramDrawable;
    this.mDescription = paramString;
    this.mData = paramObject;
  }
  
  public void set(Drawable paramDrawable, String paramString1, String paramString2, Object paramObject)
  {
    this.mImage = paramDrawable;
    this.mDescription = paramString1;
    this.mSubDescription = paramString2;
    this.mData = paramObject;
  }
  
  public void set(View paramView, Object paramObject)
  {
    this.mView = paramView;
    this.mData = paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.samsung.android.sdk.look.airbutton.SlookAirButtonAdapter.AirButtonItem
 * JD-Core Version:    0.7.0.1
 */