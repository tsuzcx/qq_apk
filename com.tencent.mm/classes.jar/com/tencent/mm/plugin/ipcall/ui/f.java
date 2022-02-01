package com.tencent.mm.plugin.ipcall.ui;

import android.text.Spannable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.List;

public final class f
  extends BaseAdapter
{
  private List<a> frK;
  private String iiW;
  private List<a> list;
  private IPCallCountryCodeSelectUI sGi;
  int[] sGj;
  boolean sGk;
  boolean sGl;
  
  public f(IPCallCountryCodeSelectUI paramIPCallCountryCodeSelectUI, List<a> paramList)
  {
    AppMethodBeat.i(25715);
    this.frK = new ArrayList();
    this.sGk = false;
    this.sGl = false;
    this.sGi = paramIPCallCountryCodeSelectUI;
    this.list = paramList;
    cIc();
    cId();
    AppMethodBeat.o(25715);
  }
  
  private static String Fp(int paramInt)
  {
    AppMethodBeat.i(25722);
    char c = (char)paramInt;
    String[] arrayOfString = IPCallCountryCodeScrollbar.sGo;
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
  
  private void cIc()
  {
    AppMethodBeat.i(25716);
    int i = 0;
    int j = this.list.size();
    while (i < j)
    {
      this.frK.add(this.list.get(i));
      i += 1;
    }
    this.sGi.sGb.setVisibility(8);
    AppMethodBeat.o(25716);
  }
  
  private void cId()
  {
    AppMethodBeat.i(25717);
    this.sGj = new int[this.list.size()];
    int j = this.list.size();
    int i = 0;
    while (i < j)
    {
      this.sGj[i] = ((a)this.list.get(i)).cHU();
      i += 1;
    }
    AppMethodBeat.o(25717);
  }
  
  public final void BW(String paramString)
  {
    AppMethodBeat.i(25720);
    if (paramString != null)
    {
      this.iiW = paramString.trim();
      this.list.clear();
      int j = this.frK.size();
      int i = 0;
      while (i < j)
      {
        if ((((a)this.frK.get(i)).hkO.toUpperCase().contains(this.iiW.toUpperCase())) || (((a)this.frK.get(i)).hkP.toUpperCase().contains(this.iiW.toUpperCase())) || (((a)this.frK.get(i)).countryCode.contains(this.iiW))) {
          this.list.add(this.frK.get(i));
        }
        i += 1;
      }
      cId();
      if (this.list.size() != 0) {
        break label199;
      }
      this.sGi.sGb.setVisibility(0);
    }
    for (;;)
    {
      super.notifyDataSetChanged();
      AppMethodBeat.o(25720);
      return;
      label199:
      this.sGi.sGb.setVisibility(8);
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
      paramView = View.inflate(this.sGi, 2131494502, null);
      paramViewGroup = new a();
      paramViewGroup.sGm = ((TextView)paramView.findViewById(2131298724));
      paramViewGroup.fsI = ((TextView)paramView.findViewById(2131298729));
      paramViewGroup.sGn = ((TextView)paramView.findViewById(2131298734));
      paramView.setTag(paramViewGroup);
      if (paramInt <= 0) {
        break label235;
      }
      i = this.sGj[(paramInt - 1)];
      label97:
      if (paramInt != 0) {
        break label260;
      }
      paramViewGroup.sGm.setVisibility(0);
      if (!this.sGl) {
        break label241;
      }
      paramViewGroup.sGm.setText(2131762001);
      label125:
      if (bt.isNullOrNil(this.iiW)) {
        break label314;
      }
      Spannable localSpannable = com.tencent.mm.plugin.fts.a.f.a(((a)localObject).hkO, this.iiW);
      paramViewGroup.fsI.setText(localSpannable);
      localObject = com.tencent.mm.plugin.fts.a.f.a(" (+" + ((a)localObject).countryCode + ")", this.iiW);
      paramViewGroup.sGn.setText((CharSequence)localObject);
      label201:
      if (!this.sGk) {
        break label361;
      }
      paramViewGroup.sGn.setVisibility(0);
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
      paramViewGroup.sGm.setText(Fp(this.sGj[paramInt]));
      break label125;
      label260:
      if ((paramInt > 0) && (this.sGj[paramInt] != i))
      {
        paramViewGroup.sGm.setVisibility(0);
        paramViewGroup.sGm.setText(Fp(this.sGj[paramInt]));
        break label125;
      }
      paramViewGroup.sGm.setVisibility(8);
      break label125;
      label314:
      paramViewGroup.fsI.setText(((a)localObject).hkO);
      paramViewGroup.sGn.setText(" (+" + ((a)localObject).countryCode + ")");
      break label201;
      label361:
      paramViewGroup.sGn.setVisibility(4);
    }
  }
  
  static final class a
  {
    TextView fsI;
    TextView sGm;
    TextView sGn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.f
 * JD-Core Version:    0.7.0.1
 */