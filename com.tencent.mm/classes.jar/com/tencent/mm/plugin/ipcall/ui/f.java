package com.tencent.mm.plugin.ipcall.ui;

import android.text.Spannable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.ArrayList;
import java.util.List;

public final class f
  extends BaseAdapter
{
  private String feq;
  private List<a> list;
  private List<a> luW = new ArrayList();
  private IPCallCountryCodeSelectUI luX;
  int[] luY;
  boolean luZ = false;
  boolean lva = false;
  
  public f(IPCallCountryCodeSelectUI paramIPCallCountryCodeSelectUI, List<a> paramList)
  {
    this.luX = paramIPCallCountryCodeSelectUI;
    this.list = paramList;
    bcW();
    bcX();
  }
  
  private void bcW()
  {
    int i = 0;
    int j = this.list.size();
    while (i < j)
    {
      this.luW.add(this.list.get(i));
      i += 1;
    }
    this.luX.luO.setVisibility(8);
  }
  
  private void bcX()
  {
    this.luY = new int[this.list.size()];
    int j = this.list.size();
    int i = 0;
    while (i < j)
    {
      this.luY[i] = ((a)this.list.get(i)).bcP();
      i += 1;
    }
  }
  
  private static String sL(int paramInt)
  {
    char c = (char)paramInt;
    String[] arrayOfString = IPCallCountryCodeScrollbar.lvd;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfString[i].equals(String.valueOf((char)paramInt))) {
        return String.valueOf(c);
      }
      i += 1;
    }
    return "#";
  }
  
  public final int getCount()
  {
    return this.list.size();
  }
  
  public final Object getItem(int paramInt)
  {
    return this.list.get(paramInt);
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = (a)getItem(paramInt);
    int i;
    if (paramView == null)
    {
      paramView = View.inflate(this.luX, R.i.ip_call_country_list_item, null);
      paramViewGroup = new a();
      paramViewGroup.lvb = ((TextView)paramView.findViewById(R.h.contactitem_catalog));
      paramViewGroup.drB = ((TextView)paramView.findViewById(R.h.contactitem_nick));
      paramViewGroup.lvc = ((TextView)paramView.findViewById(R.h.contactitem_signature));
      paramView.setTag(paramViewGroup);
      if (paramInt <= 0) {
        break label228;
      }
      i = this.luY[(paramInt - 1)];
      label95:
      if (paramInt != 0) {
        break label253;
      }
      paramViewGroup.lvb.setVisibility(0);
      if (!this.lva) {
        break label234;
      }
      paramViewGroup.lvb.setText(R.l.popular_country_header);
      label124:
      if (bk.bl(this.feq)) {
        break label307;
      }
      Spannable localSpannable = com.tencent.mm.plugin.fts.a.f.a(((a)localObject).esg, this.feq);
      paramViewGroup.drB.setText(localSpannable);
      localObject = com.tencent.mm.plugin.fts.a.f.a(" (+" + ((a)localObject).countryCode + ")", this.feq);
      paramViewGroup.lvc.setText((CharSequence)localObject);
    }
    for (;;)
    {
      if (!this.luZ) {
        break label354;
      }
      paramViewGroup.lvc.setVisibility(0);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label228:
      i = -1;
      break label95;
      label234:
      paramViewGroup.lvb.setText(sL(this.luY[paramInt]));
      break label124;
      label253:
      if ((paramInt > 0) && (this.luY[paramInt] != i))
      {
        paramViewGroup.lvb.setVisibility(0);
        paramViewGroup.lvb.setText(sL(this.luY[paramInt]));
        break label124;
      }
      paramViewGroup.lvb.setVisibility(8);
      break label124;
      label307:
      paramViewGroup.drB.setText(((a)localObject).esg);
      paramViewGroup.lvc.setText(" (+" + ((a)localObject).countryCode + ")");
    }
    label354:
    paramViewGroup.lvc.setVisibility(4);
    return paramView;
  }
  
  public final void pA(String paramString)
  {
    if (paramString != null)
    {
      this.feq = paramString.trim();
      this.list.clear();
      int j = this.luW.size();
      int i = 0;
      while (i < j)
      {
        if ((((a)this.luW.get(i)).esg.toUpperCase().contains(this.feq.toUpperCase())) || (((a)this.luW.get(i)).esh.toUpperCase().contains(this.feq.toUpperCase())) || (((a)this.luW.get(i)).countryCode.contains(this.feq))) {
          this.list.add(this.luW.get(i));
        }
        i += 1;
      }
      bcX();
      if (this.list.size() != 0) {
        break label187;
      }
      this.luX.luO.setVisibility(0);
    }
    for (;;)
    {
      super.notifyDataSetChanged();
      return;
      label187:
      this.luX.luO.setVisibility(8);
    }
  }
  
  static final class a
  {
    TextView drB;
    TextView lvb;
    TextView lvc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.f
 * JD-Core Version:    0.7.0.1
 */