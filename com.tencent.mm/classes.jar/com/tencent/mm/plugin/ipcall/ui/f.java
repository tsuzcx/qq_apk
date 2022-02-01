package com.tencent.mm.plugin.ipcall.ui;

import android.text.Spannable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;

public final class f
  extends BaseAdapter
{
  private List<a> bXV;
  private String kdi;
  private List<a> list;
  private IPCallCountryCodeSelectUI yuO;
  int[] yuP;
  boolean yuQ;
  boolean yuR;
  
  public f(IPCallCountryCodeSelectUI paramIPCallCountryCodeSelectUI, List<a> paramList)
  {
    AppMethodBeat.i(25715);
    this.bXV = new ArrayList();
    this.yuQ = false;
    this.yuR = false;
    this.yuO = paramIPCallCountryCodeSelectUI;
    this.list = paramList;
    ebk();
    ebl();
    AppMethodBeat.o(25715);
  }
  
  private static String Ph(int paramInt)
  {
    AppMethodBeat.i(25722);
    char c = (char)paramInt;
    String[] arrayOfString = IPCallCountryCodeScrollbar.yuU;
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
  
  private void ebk()
  {
    AppMethodBeat.i(25716);
    int i = 0;
    int j = this.list.size();
    while (i < j)
    {
      this.bXV.add(this.list.get(i));
      i += 1;
    }
    this.yuO.yuH.setVisibility(8);
    AppMethodBeat.o(25716);
  }
  
  private void ebl()
  {
    AppMethodBeat.i(25717);
    this.yuP = new int[this.list.size()];
    int j = this.list.size();
    int i = 0;
    while (i < j)
    {
      this.yuP[i] = ((a)this.list.get(i)).ebc();
      i += 1;
    }
    AppMethodBeat.o(25717);
  }
  
  public final void SM(String paramString)
  {
    AppMethodBeat.i(25720);
    if (paramString != null)
    {
      this.kdi = paramString.trim();
      this.list.clear();
      int j = this.bXV.size();
      int i = 0;
      while (i < j)
      {
        if ((((a)this.bXV.get(i)).jbZ.toUpperCase().contains(this.kdi.toUpperCase())) || (((a)this.bXV.get(i)).jca.toUpperCase().contains(this.kdi.toUpperCase())) || (((a)this.bXV.get(i)).countryCode.contains(this.kdi))) {
          this.list.add(this.bXV.get(i));
        }
        i += 1;
      }
      ebl();
      if (this.list.size() != 0) {
        break label199;
      }
      this.yuO.yuH.setVisibility(0);
    }
    for (;;)
    {
      super.notifyDataSetChanged();
      AppMethodBeat.o(25720);
      return;
      label199:
      this.yuO.yuH.setVisibility(8);
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
      paramView = View.inflate(this.yuO, 2131495094, null);
      paramViewGroup = new a();
      paramViewGroup.yuS = ((TextView)paramView.findViewById(2131299162));
      paramViewGroup.gwR = ((TextView)paramView.findViewById(2131299167));
      paramViewGroup.yuT = ((TextView)paramView.findViewById(2131299172));
      paramView.setTag(paramViewGroup);
      if (paramInt <= 0) {
        break label235;
      }
      i = this.yuP[(paramInt - 1)];
      label97:
      if (paramInt != 0) {
        break label260;
      }
      paramViewGroup.yuS.setVisibility(0);
      if (!this.yuR) {
        break label241;
      }
      paramViewGroup.yuS.setText(2131764011);
      label125:
      if (Util.isNullOrNil(this.kdi)) {
        break label314;
      }
      Spannable localSpannable = com.tencent.mm.plugin.fts.a.f.b(((a)localObject).jbZ, this.kdi);
      paramViewGroup.gwR.setText(localSpannable);
      localObject = com.tencent.mm.plugin.fts.a.f.b(" (+" + ((a)localObject).countryCode + ")", this.kdi);
      paramViewGroup.yuT.setText((CharSequence)localObject);
      label201:
      if (!this.yuQ) {
        break label361;
      }
      paramViewGroup.yuT.setVisibility(0);
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
      paramViewGroup.yuS.setText(Ph(this.yuP[paramInt]));
      break label125;
      label260:
      if ((paramInt > 0) && (this.yuP[paramInt] != i))
      {
        paramViewGroup.yuS.setVisibility(0);
        paramViewGroup.yuS.setText(Ph(this.yuP[paramInt]));
        break label125;
      }
      paramViewGroup.yuS.setVisibility(8);
      break label125;
      label314:
      paramViewGroup.gwR.setText(((a)localObject).jbZ);
      paramViewGroup.yuT.setText(" (+" + ((a)localObject).countryCode + ")");
      break label201;
      label361:
      paramViewGroup.yuT.setVisibility(4);
    }
  }
  
  static final class a
  {
    TextView gwR;
    TextView yuS;
    TextView yuT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.f
 * JD-Core Version:    0.7.0.1
 */