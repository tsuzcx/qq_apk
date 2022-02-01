package com.tencent.mobileqq.activity.aio.item;

import fwz;
import java.util.ArrayList;
import java.util.HashMap;

class StructingMsgItemBuilder$CacheMap
  extends HashMap
{
  private static final long serialVersionUID = -7873031099646660622L;
  
  public void add(fwz paramfwz)
  {
    if (paramfwz == null) {
      return;
    }
    get(paramfwz.a).add(paramfwz);
  }
  
  public ArrayList get(String paramString)
  {
    ArrayList localArrayList2 = (ArrayList)super.get(paramString);
    ArrayList localArrayList1 = localArrayList2;
    if (localArrayList2 == null)
    {
      localArrayList1 = new ArrayList();
      put(paramString, localArrayList1);
    }
    return localArrayList1;
  }
  
  public void remove(fwz paramfwz)
  {
    if ((paramfwz == null) || (paramfwz.a == null)) {}
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = get(paramfwz.a);
      localArrayList.remove(paramfwz);
    } while (!localArrayList.isEmpty());
    remove(paramfwz.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.CacheMap
 * JD-Core Version:    0.7.0.1
 */