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
  private List<a> fOy;
  private String jcm;
  private List<a> list;
  private IPCallCountryCodeSelectUI uQC;
  int[] uQD;
  boolean uQE;
  boolean uQF;
  
  public f(IPCallCountryCodeSelectUI paramIPCallCountryCodeSelectUI, List<a> paramList)
  {
    AppMethodBeat.i(25715);
    this.fOy = new ArrayList();
    this.uQE = false;
    this.uQF = false;
    this.uQC = paramIPCallCountryCodeSelectUI;
    this.list = paramList;
    dey();
    dez();
    AppMethodBeat.o(25715);
  }
  
  private static String IG(int paramInt)
  {
    AppMethodBeat.i(25722);
    char c = (char)paramInt;
    String[] arrayOfString = IPCallCountryCodeScrollbar.uQI;
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
  
  private void dey()
  {
    AppMethodBeat.i(25716);
    int i = 0;
    int j = this.list.size();
    while (i < j)
    {
      this.fOy.add(this.list.get(i));
      i += 1;
    }
    this.uQC.uQv.setVisibility(8);
    AppMethodBeat.o(25716);
  }
  
  private void dez()
  {
    AppMethodBeat.i(25717);
    this.uQD = new int[this.list.size()];
    int j = this.list.size();
    int i = 0;
    while (i < j)
    {
      this.uQD[i] = ((a)this.list.get(i)).deq();
      i += 1;
    }
    AppMethodBeat.o(25717);
  }
  
  public final void Jo(String paramString)
  {
    AppMethodBeat.i(25720);
    if (paramString != null)
    {
      this.jcm = paramString.trim();
      this.list.clear();
      int j = this.fOy.size();
      int i = 0;
      while (i < j)
      {
        if ((((a)this.fOy.get(i)).iem.toUpperCase().contains(this.jcm.toUpperCase())) || (((a)this.fOy.get(i)).ien.toUpperCase().contains(this.jcm.toUpperCase())) || (((a)this.fOy.get(i)).countryCode.contains(this.jcm))) {
          this.list.add(this.fOy.get(i));
        }
        i += 1;
      }
      dez();
      if (this.list.size() != 0) {
        break label199;
      }
      this.uQC.uQv.setVisibility(0);
    }
    for (;;)
    {
      super.notifyDataSetChanged();
      AppMethodBeat.o(25720);
      return;
      label199:
      this.uQC.uQv.setVisibility(8);
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
      paramView = View.inflate(this.uQC, 2131494502, null);
      paramViewGroup = new a();
      paramViewGroup.uQG = ((TextView)paramView.findViewById(2131298724));
      paramViewGroup.fPC = ((TextView)paramView.findViewById(2131298729));
      paramViewGroup.uQH = ((TextView)paramView.findViewById(2131298734));
      paramView.setTag(paramViewGroup);
      if (paramInt <= 0) {
        break label235;
      }
      i = this.uQD[(paramInt - 1)];
      label97:
      if (paramInt != 0) {
        break label260;
      }
      paramViewGroup.uQG.setVisibility(0);
      if (!this.uQF) {
        break label241;
      }
      paramViewGroup.uQG.setText(2131762001);
      label125:
      if (bt.isNullOrNil(this.jcm)) {
        break label314;
      }
      Spannable localSpannable = com.tencent.mm.plugin.fts.a.f.b(((a)localObject).iem, this.jcm);
      paramViewGroup.fPC.setText(localSpannable);
      localObject = com.tencent.mm.plugin.fts.a.f.b(" (+" + ((a)localObject).countryCode + ")", this.jcm);
      paramViewGroup.uQH.setText((CharSequence)localObject);
      label201:
      if (!this.uQE) {
        break label361;
      }
      paramViewGroup.uQH.setVisibility(0);
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
      paramViewGroup.uQG.setText(IG(this.uQD[paramInt]));
      break label125;
      label260:
      if ((paramInt > 0) && (this.uQD[paramInt] != i))
      {
        paramViewGroup.uQG.setVisibility(0);
        paramViewGroup.uQG.setText(IG(this.uQD[paramInt]));
        break label125;
      }
      paramViewGroup.uQG.setVisibility(8);
      break label125;
      label314:
      paramViewGroup.fPC.setText(((a)localObject).iem);
      paramViewGroup.uQH.setText(" (+" + ((a)localObject).countryCode + ")");
      break label201;
      label361:
      paramViewGroup.uQH.setVisibility(4);
    }
  }
  
  static final class a
  {
    TextView fPC;
    TextView uQG;
    TextView uQH;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.f
 * JD-Core Version:    0.7.0.1
 */