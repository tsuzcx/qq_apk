package com.samsung.android.sdk.look.airbutton;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SlookAirButtonAdapter$AirButtonItem
{
  private Object mData;
  private String mDescription;
  private Drawable mImage;
  private String mSubDescription;
  private View mView;
  
  public SlookAirButtonAdapter$AirButtonItem(Drawable paramDrawable, String paramString, Object paramObject)
  {
    AppMethodBeat.i(117233);
    this.mView = null;
    this.mImage = null;
    this.mDescription = null;
    this.mSubDescription = null;
    this.mData = null;
    if ((paramDrawable == null) && (paramString == null) && (paramObject == null))
    {
      paramDrawable = new IllegalArgumentException("You should set the Drawable, String and Object in Param");
      AppMethodBeat.o(117233);
      throw paramDrawable;
    }
    set(paramDrawable, paramString, paramObject);
    AppMethodBeat.o(117233);
  }
  
  public SlookAirButtonAdapter$AirButtonItem(Drawable paramDrawable, String paramString1, String paramString2, Object paramObject)
  {
    AppMethodBeat.i(117234);
    this.mView = null;
    this.mImage = null;
    this.mDescription = null;
    this.mSubDescription = null;
    this.mData = null;
    if ((paramDrawable == null) && (paramString1 == null) && (paramString2 == null) && (paramObject == null))
    {
      paramDrawable = new IllegalArgumentException("You should set the Drawable, String, subDescription and Object in Param");
      AppMethodBeat.o(117234);
      throw paramDrawable;
    }
    set(paramDrawable, paramString1, paramString2, paramObject);
    AppMethodBeat.o(117234);
  }
  
  public SlookAirButtonAdapter$AirButtonItem(View paramView, Object paramObject)
  {
    AppMethodBeat.i(117232);
    this.mView = null;
    this.mImage = null;
    this.mDescription = null;
    this.mSubDescription = null;
    this.mData = null;
    if ((paramView == null) && (paramObject == null))
    {
      paramView = new IllegalArgumentException("You should set the View and Object in Param");
      AppMethodBeat.o(117232);
      throw paramView;
    }
    set(paramView, paramObject);
    AppMethodBeat.o(117232);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.samsung.android.sdk.look.airbutton.SlookAirButtonAdapter.AirButtonItem
 * JD-Core Version:    0.7.0.1
 */