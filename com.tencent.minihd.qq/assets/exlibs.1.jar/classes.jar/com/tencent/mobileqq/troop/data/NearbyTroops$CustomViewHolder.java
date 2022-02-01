package com.tencent.mobileqq.troop.data;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.adapter.WebFacePreloadBaseAdapter.ViewHolder;
import com.tencent.mobileqq.troop.widget.TroopLabelTextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class NearbyTroops$CustomViewHolder
  extends WebFacePreloadBaseAdapter.ViewHolder
{
  public Drawable a;
  public LinearLayout a;
  public ArrayList a;
  public Map a;
  public int b;
  public int c;
  public ImageView c;
  public ImageView d;
  public ImageView e;
  public ImageView f;
  public TextView f;
  public TextView g;
  public TextView h;
  
  public TroopLabelTextView a(int paramInt)
  {
    if (this.a == null) {}
    while (!this.a.containsKey(Integer.valueOf(paramInt))) {
      return null;
    }
    return (TroopLabelTextView)this.a.get(Integer.valueOf(paramInt));
  }
  
  public void a(int paramInt, TroopLabelTextView paramTroopLabelTextView)
  {
    if (this.a == null) {
      this.a = new HashMap();
    }
    if (!this.a.containsKey(Integer.valueOf(paramInt))) {
      this.a.put(Integer.valueOf(paramInt), paramTroopLabelTextView);
    }
  }
  
  public void a(Map paramMap)
  {
    if (this.a == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.a.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (!paramMap.containsKey(localEntry.getKey())) {
          ((TroopLabelTextView)localEntry.getValue()).setVisibility(8);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.NearbyTroops.CustomViewHolder
 * JD-Core Version:    0.7.0.1
 */