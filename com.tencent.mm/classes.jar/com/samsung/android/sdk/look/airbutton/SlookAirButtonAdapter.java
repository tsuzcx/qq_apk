package com.samsung.android.sdk.look.airbutton;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class SlookAirButtonAdapter
{
  private CharSequence mEmptyText;
  private ArrayList<AirButtonItem> mItemList;
  
  public SlookAirButtonAdapter()
  {
    this.mItemList = null;
  }
  
  public SlookAirButtonAdapter(ArrayList<AirButtonItem> paramArrayList)
  {
    AppMethodBeat.i(76284);
    this.mItemList = null;
    addItem(paramArrayList);
    AppMethodBeat.o(76284);
  }
  
  public int addItem(ArrayList<AirButtonItem> paramArrayList)
  {
    AppMethodBeat.i(76286);
    if (this.mItemList != null) {
      this.mItemList.clear();
    }
    this.mItemList = paramArrayList;
    int i = this.mItemList.size();
    AppMethodBeat.o(76286);
    return i - 1;
  }
  
  public void addItem(AirButtonItem paramAirButtonItem)
  {
    AppMethodBeat.i(76285);
    if (this.mItemList == null) {
      this.mItemList = new ArrayList();
    }
    this.mItemList.add(paramAirButtonItem);
    AppMethodBeat.o(76285);
  }
  
  public void clear()
  {
    AppMethodBeat.i(76290);
    if (this.mItemList == null)
    {
      AppMethodBeat.o(76290);
      return;
    }
    this.mItemList.clear();
    AppMethodBeat.o(76290);
  }
  
  public int getCount()
  {
    AppMethodBeat.i(76291);
    if (this.mItemList == null)
    {
      AppMethodBeat.o(76291);
      return 0;
    }
    int i = this.mItemList.size();
    AppMethodBeat.o(76291);
    return i;
  }
  
  public CharSequence getEmptyText()
  {
    return this.mEmptyText;
  }
  
  public AirButtonItem getItem(int paramInt)
  {
    AppMethodBeat.i(76292);
    if ((this.mItemList != null) && (paramInt < this.mItemList.size()))
    {
      AirButtonItem localAirButtonItem = (AirButtonItem)this.mItemList.get(paramInt);
      AppMethodBeat.o(76292);
      return localAirButtonItem;
    }
    AppMethodBeat.o(76292);
    return null;
  }
  
  public void insertItem(int paramInt, AirButtonItem paramAirButtonItem)
  {
    AppMethodBeat.i(76287);
    if (this.mItemList == null)
    {
      if (paramInt == 0)
      {
        addItem(paramAirButtonItem);
        AppMethodBeat.o(76287);
        return;
      }
      paramAirButtonItem = new IllegalArgumentException("The list is empty.");
      AppMethodBeat.o(76287);
      throw paramAirButtonItem;
    }
    this.mItemList.add(paramInt, paramAirButtonItem);
    AppMethodBeat.o(76287);
  }
  
  public void onDismiss(View paramView) {}
  
  public void onHide(View paramView) {}
  
  public boolean onHoverEnter(View paramView)
  {
    return true;
  }
  
  public void onHoverExit(View paramView) {}
  
  public void onShow(View paramView) {}
  
  public void removeItem(int paramInt)
  {
    AppMethodBeat.i(76288);
    if (this.mItemList == null)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("The list is empty.");
      AppMethodBeat.o(76288);
      throw localIllegalArgumentException;
    }
    this.mItemList.remove(paramInt);
    AppMethodBeat.o(76288);
  }
  
  public void setEmptyText(CharSequence paramCharSequence)
  {
    this.mEmptyText = paramCharSequence;
  }
  
  public void updateItem(int paramInt, AirButtonItem paramAirButtonItem)
  {
    AppMethodBeat.i(76289);
    if (this.mItemList == null)
    {
      paramAirButtonItem = new IllegalArgumentException("The list is empty.");
      AppMethodBeat.o(76289);
      throw paramAirButtonItem;
    }
    this.mItemList.set(paramInt, paramAirButtonItem);
    AppMethodBeat.o(76289);
  }
  
  public static class AirButtonItem
  {
    private Object mData;
    private String mDescription;
    private Drawable mImage;
    private String mSubDescription;
    private View mView;
    
    public AirButtonItem(Drawable paramDrawable, String paramString, Object paramObject)
    {
      AppMethodBeat.i(76275);
      this.mView = null;
      this.mImage = null;
      this.mDescription = null;
      this.mSubDescription = null;
      this.mData = null;
      if ((paramDrawable == null) && (paramString == null) && (paramObject == null))
      {
        paramDrawable = new IllegalArgumentException("You should set the Drawable, String and Object in Param");
        AppMethodBeat.o(76275);
        throw paramDrawable;
      }
      set(paramDrawable, paramString, paramObject);
      AppMethodBeat.o(76275);
    }
    
    public AirButtonItem(Drawable paramDrawable, String paramString1, String paramString2, Object paramObject)
    {
      AppMethodBeat.i(76276);
      this.mView = null;
      this.mImage = null;
      this.mDescription = null;
      this.mSubDescription = null;
      this.mData = null;
      if ((paramDrawable == null) && (paramString1 == null) && (paramString2 == null) && (paramObject == null))
      {
        paramDrawable = new IllegalArgumentException("You should set the Drawable, String, subDescription and Object in Param");
        AppMethodBeat.o(76276);
        throw paramDrawable;
      }
      set(paramDrawable, paramString1, paramString2, paramObject);
      AppMethodBeat.o(76276);
    }
    
    public AirButtonItem(View paramView, Object paramObject)
    {
      AppMethodBeat.i(76274);
      this.mView = null;
      this.mImage = null;
      this.mDescription = null;
      this.mSubDescription = null;
      this.mData = null;
      if ((paramView == null) && (paramObject == null))
      {
        paramView = new IllegalArgumentException("You should set the View and Object in Param");
        AppMethodBeat.o(76274);
        throw paramView;
      }
      set(paramView, paramObject);
      AppMethodBeat.o(76274);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.samsung.android.sdk.look.airbutton.SlookAirButtonAdapter
 * JD-Core Version:    0.7.0.1
 */