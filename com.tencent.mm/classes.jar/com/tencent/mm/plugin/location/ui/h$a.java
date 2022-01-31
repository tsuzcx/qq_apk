package com.tencent.mm.plugin.location.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

final class h$a
  extends BaseAdapter
{
  ArrayList<h.b> odf;
  
  public h$a(ArrayList<h.b> paramArrayList)
  {
    AppMethodBeat.i(113494);
    this.odf = new ArrayList();
    Collection localCollection;
    this.odf.addAll(localCollection);
    AppMethodBeat.o(113494);
  }
  
  public final h.b Sf(String paramString)
  {
    AppMethodBeat.i(113498);
    int i = 0;
    while (i < this.odf.size())
    {
      if (((h.b)this.odf.get(i)).username.equals(paramString))
      {
        paramString = (h.b)this.odf.get(i);
        AppMethodBeat.o(113498);
        return paramString;
      }
      i += 1;
    }
    AppMethodBeat.o(113498);
    return null;
  }
  
  public final boolean Sg(String paramString)
  {
    AppMethodBeat.i(113499);
    int i = 0;
    while (i < this.odf.size())
    {
      if (((h.b)this.odf.get(i)).username.equals(paramString))
      {
        AppMethodBeat.o(113499);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(113499);
    return false;
  }
  
  public final ArrayList<String> bLL()
  {
    AppMethodBeat.i(113500);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.odf.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((h.b)localIterator.next()).username);
    }
    AppMethodBeat.o(113500);
    return localArrayList;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(113495);
    int i = this.odf.size();
    AppMethodBeat.o(113495);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(113496);
    Object localObject = this.odf.get(paramInt);
    AppMethodBeat.o(113496);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(113497);
    paramView = ((h.b)this.odf.get(paramInt)).odh.odi;
    AppMethodBeat.o(113497);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.h.a
 * JD-Core Version:    0.7.0.1
 */