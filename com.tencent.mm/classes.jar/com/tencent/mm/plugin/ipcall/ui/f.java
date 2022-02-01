package com.tencent.mm.plugin.ipcall.ui;

import android.text.Spannable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;
import java.util.List;

public final class f
  extends BaseAdapter
{
  private List<a> fvr;
  private String iJd;
  private List<a> list;
  private IPCallCountryCodeSelectUI tNP;
  int[] tNQ;
  boolean tNR;
  boolean tNS;
  
  public f(IPCallCountryCodeSelectUI paramIPCallCountryCodeSelectUI, List<a> paramList)
  {
    AppMethodBeat.i(25715);
    this.fvr = new ArrayList();
    this.tNR = false;
    this.tNS = false;
    this.tNP = paramIPCallCountryCodeSelectUI;
    this.list = paramList;
    cVn();
    cVo();
    AppMethodBeat.o(25715);
  }
  
  private static String Hk(int paramInt)
  {
    AppMethodBeat.i(25722);
    char c = (char)paramInt;
    String[] arrayOfString = IPCallCountryCodeScrollbar.tNV;
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
  
  private void cVn()
  {
    AppMethodBeat.i(25716);
    int i = 0;
    int j = this.list.size();
    while (i < j)
    {
      this.fvr.add(this.list.get(i));
      i += 1;
    }
    this.tNP.tNI.setVisibility(8);
    AppMethodBeat.o(25716);
  }
  
  private void cVo()
  {
    AppMethodBeat.i(25717);
    this.tNQ = new int[this.list.size()];
    int j = this.list.size();
    int i = 0;
    while (i < j)
    {
      this.tNQ[i] = ((a)this.list.get(i)).cVf();
      i += 1;
    }
    AppMethodBeat.o(25717);
  }
  
  public final void FZ(String paramString)
  {
    AppMethodBeat.i(25720);
    if (paramString != null)
    {
      this.iJd = paramString.trim();
      this.list.clear();
      int j = this.fvr.size();
      int i = 0;
      while (i < j)
      {
        if ((((a)this.fvr.get(i)).hLr.toUpperCase().contains(this.iJd.toUpperCase())) || (((a)this.fvr.get(i)).hLs.toUpperCase().contains(this.iJd.toUpperCase())) || (((a)this.fvr.get(i)).countryCode.contains(this.iJd))) {
          this.list.add(this.fvr.get(i));
        }
        i += 1;
      }
      cVo();
      if (this.list.size() != 0) {
        break label199;
      }
      this.tNP.tNI.setVisibility(0);
    }
    for (;;)
    {
      super.notifyDataSetChanged();
      AppMethodBeat.o(25720);
      return;
      label199:
      this.tNP.tNI.setVisibility(8);
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
      paramView = View.inflate(this.tNP, 2131494502, null);
      paramViewGroup = new a();
      paramViewGroup.tNT = ((TextView)paramView.findViewById(2131298724));
      paramViewGroup.fwp = ((TextView)paramView.findViewById(2131298729));
      paramViewGroup.tNU = ((TextView)paramView.findViewById(2131298734));
      paramView.setTag(paramViewGroup);
      if (paramInt <= 0) {
        break label235;
      }
      i = this.tNQ[(paramInt - 1)];
      label97:
      if (paramInt != 0) {
        break label260;
      }
      paramViewGroup.tNT.setVisibility(0);
      if (!this.tNS) {
        break label241;
      }
      paramViewGroup.tNT.setText(2131762001);
      label125:
      if (bs.isNullOrNil(this.iJd)) {
        break label314;
      }
      Spannable localSpannable = com.tencent.mm.plugin.fts.a.f.b(((a)localObject).hLr, this.iJd);
      paramViewGroup.fwp.setText(localSpannable);
      localObject = com.tencent.mm.plugin.fts.a.f.b(" (+" + ((a)localObject).countryCode + ")", this.iJd);
      paramViewGroup.tNU.setText((CharSequence)localObject);
      label201:
      if (!this.tNR) {
        break label361;
      }
      paramViewGroup.tNU.setVisibility(0);
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
      paramViewGroup.tNT.setText(Hk(this.tNQ[paramInt]));
      break label125;
      label260:
      if ((paramInt > 0) && (this.tNQ[paramInt] != i))
      {
        paramViewGroup.tNT.setVisibility(0);
        paramViewGroup.tNT.setText(Hk(this.tNQ[paramInt]));
        break label125;
      }
      paramViewGroup.tNT.setVisibility(8);
      break label125;
      label314:
      paramViewGroup.fwp.setText(((a)localObject).hLr);
      paramViewGroup.tNU.setText(" (+" + ((a)localObject).countryCode + ")");
      break label201;
      label361:
      paramViewGroup.tNU.setVisibility(4);
    }
  }
  
  static final class a
  {
    TextView fwp;
    TextView tNT;
    TextView tNU;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.f
 * JD-Core Version:    0.7.0.1
 */