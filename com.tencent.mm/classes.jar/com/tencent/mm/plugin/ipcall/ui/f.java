package com.tencent.mm.plugin.ipcall.ui;

import android.text.Spannable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;
import java.util.List;

public final class f
  extends BaseAdapter
{
  private List<a> fQE;
  private String jff;
  private List<a> list;
  private IPCallCountryCodeSelectUI vco;
  int[] vcp;
  boolean vcq;
  boolean vcr;
  
  public f(IPCallCountryCodeSelectUI paramIPCallCountryCodeSelectUI, List<a> paramList)
  {
    AppMethodBeat.i(25715);
    this.fQE = new ArrayList();
    this.vcq = false;
    this.vcr = false;
    this.vco = paramIPCallCountryCodeSelectUI;
    this.list = paramList;
    dhq();
    dhr();
    AppMethodBeat.o(25715);
  }
  
  private static String Je(int paramInt)
  {
    AppMethodBeat.i(25722);
    char c = (char)paramInt;
    String[] arrayOfString = IPCallCountryCodeScrollbar.vcu;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfString[i].equals(String.valueOf((char)paramInt)))
      {
        AppMethodBeat.o(25722);
        return String.valueOf(c);
      }
      i += 1;
    }
    AppMethodBeat.o(25722);
    return "#";
  }
  
  private void dhq()
  {
    AppMethodBeat.i(25716);
    int i = 0;
    int j = this.list.size();
    while (i < j)
    {
      this.fQE.add(this.list.get(i));
      i += 1;
    }
    this.vco.vch.setVisibility(8);
    AppMethodBeat.o(25716);
  }
  
  private void dhr()
  {
    AppMethodBeat.i(25717);
    this.vcp = new int[this.list.size()];
    int j = this.list.size();
    int i = 0;
    while (i < j)
    {
      this.vcp[i] = ((a)this.list.get(i)).dhi();
      i += 1;
    }
    AppMethodBeat.o(25717);
  }
  
  public final void JN(String paramString)
  {
    AppMethodBeat.i(25720);
    if (paramString != null)
    {
      this.jff = paramString.trim();
      this.list.clear();
      int j = this.fQE.size();
      int i = 0;
      while (i < j)
      {
        if ((((a)this.fQE.get(i)).ihe.toUpperCase().contains(this.jff.toUpperCase())) || (((a)this.fQE.get(i)).ihf.toUpperCase().contains(this.jff.toUpperCase())) || (((a)this.fQE.get(i)).countryCode.contains(this.jff))) {
          this.list.add(this.fQE.get(i));
        }
        i += 1;
      }
      dhr();
      if (this.list.size() != 0) {
        break label199;
      }
      this.vco.vch.setVisibility(0);
    }
    for (;;)
    {
      super.notifyDataSetChanged();
      AppMethodBeat.o(25720);
      return;
      label199:
      this.vco.vch.setVisibility(8);
    }
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(25718);
    int i = this.list.size();
    AppMethodBeat.o(25718);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(25719);
    Object localObject = this.list.get(paramInt);
    AppMethodBeat.o(25719);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(25721);
    Object localObject = (a)getItem(paramInt);
    int i;
    if (paramView == null)
    {
      paramView = View.inflate(this.vco, 2131494502, null);
      paramViewGroup = new a();
      paramViewGroup.vcs = ((TextView)paramView.findViewById(2131298724));
      paramViewGroup.fRI = ((TextView)paramView.findViewById(2131298729));
      paramViewGroup.vct = ((TextView)paramView.findViewById(2131298734));
      paramView.setTag(paramViewGroup);
      if (paramInt <= 0) {
        break label235;
      }
      i = this.vcp[(paramInt - 1)];
      label97:
      if (paramInt != 0) {
        break label260;
      }
      paramViewGroup.vcs.setVisibility(0);
      if (!this.vcr) {
        break label241;
      }
      paramViewGroup.vcs.setText(2131762001);
      label125:
      if (bu.isNullOrNil(this.jff)) {
        break label314;
      }
      Spannable localSpannable = com.tencent.mm.plugin.fts.a.f.b(((a)localObject).ihe, this.jff);
      paramViewGroup.fRI.setText(localSpannable);
      localObject = com.tencent.mm.plugin.fts.a.f.b(" (+" + ((a)localObject).countryCode + ")", this.jff);
      paramViewGroup.vct.setText((CharSequence)localObject);
      label201:
      if (!this.vcq) {
        break label361;
      }
      paramViewGroup.vct.setVisibility(0);
    }
    for (;;)
    {
      AppMethodBeat.o(25721);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label235:
      i = -1;
      break label97;
      label241:
      paramViewGroup.vcs.setText(Je(this.vcp[paramInt]));
      break label125;
      label260:
      if ((paramInt > 0) && (this.vcp[paramInt] != i))
      {
        paramViewGroup.vcs.setVisibility(0);
        paramViewGroup.vcs.setText(Je(this.vcp[paramInt]));
        break label125;
      }
      paramViewGroup.vcs.setVisibility(8);
      break label125;
      label314:
      paramViewGroup.fRI.setText(((a)localObject).ihe);
      paramViewGroup.vct.setText(" (+" + ((a)localObject).countryCode + ")");
      break label201;
      label361:
      paramViewGroup.vct.setVisibility(4);
    }
  }
  
  static final class a
  {
    TextView fRI;
    TextView vcs;
    TextView vct;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.f
 * JD-Core Version:    0.7.0.1
 */