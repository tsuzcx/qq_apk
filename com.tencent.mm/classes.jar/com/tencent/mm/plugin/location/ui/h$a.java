package com.tencent.mm.plugin.location.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

final class h$a
  extends BaseAdapter
{
  ArrayList<h.b> lFS = new ArrayList();
  
  public h$a(ArrayList<h.b> paramArrayList)
  {
    Collection localCollection;
    this.lFS.addAll(localCollection);
  }
  
  public final h.b GC(String paramString)
  {
    int i = 0;
    while (i < this.lFS.size())
    {
      if (((h.b)this.lFS.get(i)).username.equals(paramString)) {
        return (h.b)this.lFS.get(i);
      }
      i += 1;
    }
    return null;
  }
  
  public final boolean GD(String paramString)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.lFS.size())
      {
        if (((h.b)this.lFS.get(i)).username.equals(paramString)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public final ArrayList<String> ber()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.lFS.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((h.b)localIterator.next()).username);
    }
    return localArrayList;
  }
  
  public final int getCount()
  {
    return this.lFS.size();
  }
  
  public final Object getItem(int paramInt)
  {
    return this.lFS.get(paramInt);
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return ((h.b)this.lFS.get(paramInt)).lFU.lFV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.h.a
 * JD-Core Version:    0.7.0.1
 */