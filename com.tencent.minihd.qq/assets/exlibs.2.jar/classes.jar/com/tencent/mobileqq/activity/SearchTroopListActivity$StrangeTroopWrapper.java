package com.tencent.mobileqq.activity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import ezh;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.kqq.searchgroup.SearchGroup.GroupInfo;

public class SearchTroopListActivity$StrangeTroopWrapper
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new ezh();
  private SearchGroup.GroupInfo a;
  
  public SearchTroopListActivity$StrangeTroopWrapper() {}
  
  public SearchTroopListActivity$StrangeTroopWrapper(SearchGroup.GroupInfo paramGroupInfo)
  {
    this.a = paramGroupInfo;
  }
  
  private static ArrayList b(List paramList)
  {
    ArrayList localArrayList = null;
    if (paramList != null)
    {
      localArrayList = new ArrayList(paramList.size());
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localArrayList.add(new StrangeTroopWrapper((SearchGroup.GroupInfo)paramList.next()));
      }
    }
    return localArrayList;
  }
  
  private static List b(List paramList)
  {
    ArrayList localArrayList = null;
    if (paramList != null)
    {
      localArrayList = new ArrayList(paramList.size());
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localArrayList.add(((StrangeTroopWrapper)paramList.next()).a);
      }
    }
    return localArrayList;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (this.a != null)
    {
      byte[] arrayOfByte = this.a.toByteArray();
      paramParcel.writeInt(arrayOfByte.length);
      paramParcel.writeByteArray(arrayOfByte);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SearchTroopListActivity.StrangeTroopWrapper
 * JD-Core Version:    0.7.0.1
 */