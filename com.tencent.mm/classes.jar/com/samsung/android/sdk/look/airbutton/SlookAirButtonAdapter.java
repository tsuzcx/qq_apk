package com.samsung.android.sdk.look.airbutton;

import android.view.View;
import java.util.ArrayList;

public class SlookAirButtonAdapter
{
  private CharSequence mEmptyText;
  private ArrayList<SlookAirButtonAdapter.AirButtonItem> mItemList = null;
  
  public SlookAirButtonAdapter() {}
  
  public SlookAirButtonAdapter(ArrayList<SlookAirButtonAdapter.AirButtonItem> paramArrayList)
  {
    addItem(paramArrayList);
  }
  
  public int addItem(ArrayList<SlookAirButtonAdapter.AirButtonItem> paramArrayList)
  {
    if (this.mItemList != null) {
      this.mItemList.clear();
    }
    this.mItemList = paramArrayList;
    return this.mItemList.size() - 1;
  }
  
  public void addItem(SlookAirButtonAdapter.AirButtonItem paramAirButtonItem)
  {
    if (this.mItemList == null) {
      this.mItemList = new ArrayList();
    }
    this.mItemList.add(paramAirButtonItem);
  }
  
  public void clear()
  {
    if (this.mItemList == null) {
      return;
    }
    this.mItemList.clear();
  }
  
  public int getCount()
  {
    if (this.mItemList == null) {
      return 0;
    }
    return this.mItemList.size();
  }
  
  public CharSequence getEmptyText()
  {
    return this.mEmptyText;
  }
  
  public SlookAirButtonAdapter.AirButtonItem getItem(int paramInt)
  {
    if ((this.mItemList != null) && (paramInt < this.mItemList.size())) {
      return (SlookAirButtonAdapter.AirButtonItem)this.mItemList.get(paramInt);
    }
    return null;
  }
  
  public void insertItem(int paramInt, SlookAirButtonAdapter.AirButtonItem paramAirButtonItem)
  {
    if (this.mItemList == null)
    {
      if (paramInt == 0)
      {
        addItem(paramAirButtonItem);
        return;
      }
      throw new IllegalArgumentException("The list is empty.");
    }
    this.mItemList.add(paramInt, paramAirButtonItem);
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
    if (this.mItemList == null) {
      throw new IllegalArgumentException("The list is empty.");
    }
    this.mItemList.remove(paramInt);
  }
  
  public void setEmptyText(CharSequence paramCharSequence)
  {
    this.mEmptyText = paramCharSequence;
  }
  
  public void updateItem(int paramInt, SlookAirButtonAdapter.AirButtonItem paramAirButtonItem)
  {
    if (this.mItemList == null) {
      throw new IllegalArgumentException("The list is empty.");
    }
    this.mItemList.set(paramInt, paramAirButtonItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.samsung.android.sdk.look.airbutton.SlookAirButtonAdapter
 * JD-Core Version:    0.7.0.1
 */