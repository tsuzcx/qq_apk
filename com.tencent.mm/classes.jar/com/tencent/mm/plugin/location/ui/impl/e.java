package com.tencent.mm.plugin.location.ui.impl;

import android.content.Context;
import android.os.Looper;
import android.text.Spannable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.map.a.e;
import com.tencent.mm.plugin.map.a.f;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class e
  extends BaseAdapter
{
  byte[] buffer = null;
  private Context context = null;
  boolean fiq = false;
  String iSX = "";
  boolean inQ = false;
  String key = "";
  boolean lJl = false;
  List<f> lJy = new ArrayList();
  int lJz = 0;
  
  public e(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private Spannable GJ(String paramString)
  {
    return com.tencent.mm.plugin.fts.a.f.a(paramString, this.iSX);
  }
  
  public final void GI(String paramString)
  {
    this.key = paramString;
    y.i("MicroMsg.PoiAdapter", "initdata key %s", new Object[] { paramString });
  }
  
  public final void a(List<f> paramList, byte[] paramArrayOfByte, boolean paramBoolean, String paramString)
  {
    if ((this.key == null) || (!this.key.equals(paramString)))
    {
      y.i("MicroMsg.PoiAdapter", "old key come pass it %s %s", new Object[] { this.key, paramString });
      return;
    }
    int i = this.lJy.size();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      paramString = (f)paramList.next();
      paramString.lJR = i;
      i += 1;
      this.lJy.add(paramString);
    }
    this.buffer = paramArrayOfByte;
    this.inQ = paramBoolean;
    notifyDataSetChanged();
  }
  
  public final void b(f paramf)
  {
    if (this.lJy.size() >= 0)
    {
      this.lJy.add(0, paramf);
      notifyDataSetChanged();
    }
  }
  
  public final void clean()
  {
    this.buffer = null;
    this.inQ = false;
    this.key = "";
    this.lJy.clear();
  }
  
  public final int getCount()
  {
    return this.lJy.size();
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = ((LayoutInflater)this.context.getSystemService("layout_inflater")).inflate(a.f.poi_list_item, null);
      paramViewGroup = new e.a();
      paramViewGroup.titleView = ((TextView)paramView.findViewById(a.e.title));
      paramViewGroup.lJA = ((TextView)paramView.findViewById(a.e.subtitle));
      paramViewGroup.lJB = ((ImageView)paramView.findViewById(a.e.tip_view));
      paramViewGroup.lJD = paramView.findViewById(a.e.extend_view);
      paramViewGroup.lJC = paramView.findViewById(a.e.info_view);
      paramViewGroup.hfC = ((TextView)paramView.findViewById(a.e.tip_location));
      paramView.setTag(paramViewGroup);
      if ((((f)this.lJy.get(paramInt)).type != 1) && (((f)this.lJy.get(paramInt)).type != 2)) {
        break label311;
      }
      paramViewGroup.lJD.setVisibility(0);
      paramViewGroup.lJC.setVisibility(8);
      paramViewGroup.hfC.setText(bk.aM(((f)this.lJy.get(paramInt)).lJE, ""));
      label200:
      if ((paramInt != 0) || (this.fiq)) {
        break label477;
      }
      if (!this.lJl) {
        break label331;
      }
      paramViewGroup.titleView.setText(bk.aM(((f)this.lJy.get(0)).mName, ""));
      paramViewGroup.lJA.setVisibility(0);
      paramViewGroup.lJA.setText(bk.aM(((f)this.lJy.get(0)).lJE, ""));
    }
    label311:
    label331:
    label477:
    Object localObject2;
    Object localObject1;
    for (;;)
    {
      if (paramInt == this.lJz)
      {
        paramViewGroup.lJB.setVisibility(0);
        return paramView;
        paramViewGroup = (e.a)paramView.getTag();
        break;
        paramViewGroup.lJD.setVisibility(8);
        paramViewGroup.lJC.setVisibility(0);
        break label200;
        paramViewGroup.lJA.setVisibility(8);
        if (!bk.bl(((f)this.lJy.get(0)).lJE))
        {
          paramViewGroup.titleView.setText(bk.aM(((f)this.lJy.get(paramInt)).lJE, ""));
        }
        else if (bk.bl(((f)this.lJy.get(0)).lJN))
        {
          paramViewGroup.titleView.setText(bk.aM(((f)this.lJy.get(paramInt)).mName, ""));
        }
        else
        {
          paramViewGroup.titleView.setText(bk.aM(((f)this.lJy.get(paramInt)).lJN, ""));
          continue;
          localObject2 = (f)this.lJy.get(paramInt);
          localObject1 = bk.aM(((f)localObject2).mName, "");
          localObject2 = bk.aM(((f)localObject2).lJE, "");
          if ((!this.fiq) || (bk.bl(this.iSX))) {
            break label588;
          }
          localObject1 = GJ((String)localObject1);
          localObject2 = GJ((String)localObject2);
        }
      }
    }
    label588:
    for (;;)
    {
      paramViewGroup.titleView.setText((CharSequence)localObject1);
      paramViewGroup.lJA.setText((CharSequence)localObject2);
      paramViewGroup.lJA.setVisibility(0);
      break;
      paramViewGroup.lJB.setVisibility(4);
      return paramView;
    }
  }
  
  public final void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
    Thread.currentThread().getId();
    Looper.getMainLooper().getThread().getId();
    y.i("MicroMsg.PoiAdapter", "map notifyDataChange " + bk.csb().toString() + " threadId : " + Thread.currentThread().getId());
  }
  
  public final f tc(int paramInt)
  {
    return (f)this.lJy.get(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.e
 * JD-Core Version:    0.7.0.1
 */