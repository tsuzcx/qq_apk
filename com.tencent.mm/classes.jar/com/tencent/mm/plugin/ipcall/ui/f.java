package com.tencent.mm.plugin.ipcall.ui;

import android.text.Spannable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.List;

public final class f
  extends BaseAdapter
{
  private String gvZ;
  private List<a> list;
  private List<a> nSn;
  private IPCallCountryCodeSelectUI nSo;
  int[] nSp;
  boolean nSq;
  boolean nSr;
  
  public f(IPCallCountryCodeSelectUI paramIPCallCountryCodeSelectUI, List<a> paramList)
  {
    AppMethodBeat.i(22098);
    this.nSn = new ArrayList();
    this.nSq = false;
    this.nSr = false;
    this.nSo = paramIPCallCountryCodeSelectUI;
    this.list = paramList;
    bKg();
    bKh();
    AppMethodBeat.o(22098);
  }
  
  private void bKg()
  {
    AppMethodBeat.i(22099);
    int i = 0;
    int j = this.list.size();
    while (i < j)
    {
      this.nSn.add(this.list.get(i));
      i += 1;
    }
    this.nSo.nSg.setVisibility(8);
    AppMethodBeat.o(22099);
  }
  
  private void bKh()
  {
    AppMethodBeat.i(22100);
    this.nSp = new int[this.list.size()];
    int j = this.list.size();
    int i = 0;
    while (i < j)
    {
      this.nSp[i] = ((a)this.list.get(i)).bJY();
      i += 1;
    }
    AppMethodBeat.o(22100);
  }
  
  private static String xN(int paramInt)
  {
    AppMethodBeat.i(22105);
    char c = (char)paramInt;
    String[] arrayOfString = IPCallCountryCodeScrollbar.nSu;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfString[i].equals(String.valueOf((char)paramInt)))
      {
        AppMethodBeat.o(22105);
        return String.valueOf(c);
      }
      i += 1;
    }
    AppMethodBeat.o(22105);
    return "#";
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(22101);
    int i = this.list.size();
    AppMethodBeat.o(22101);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(22102);
    Object localObject = this.list.get(paramInt);
    AppMethodBeat.o(22102);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(22104);
    Object localObject = (a)getItem(paramInt);
    int i;
    if (paramView == null)
    {
      paramView = View.inflate(this.nSo, 2130969924, null);
      paramViewGroup = new a();
      paramViewGroup.nSs = ((TextView)paramView.findViewById(2131821089));
      paramViewGroup.ejj = ((TextView)paramView.findViewById(2131821099));
      paramViewGroup.nSt = ((TextView)paramView.findViewById(2131821095));
      paramView.setTag(paramViewGroup);
      if (paramInt <= 0) {
        break label235;
      }
      i = this.nSp[(paramInt - 1)];
      label97:
      if (paramInt != 0) {
        break label260;
      }
      paramViewGroup.nSs.setVisibility(0);
      if (!this.nSr) {
        break label241;
      }
      paramViewGroup.nSs.setText(2131302160);
      label125:
      if (bo.isNullOrNil(this.gvZ)) {
        break label314;
      }
      Spannable localSpannable = com.tencent.mm.plugin.fts.a.f.a(((a)localObject).fHT, this.gvZ);
      paramViewGroup.ejj.setText(localSpannable);
      localObject = com.tencent.mm.plugin.fts.a.f.a(" (+" + ((a)localObject).countryCode + ")", this.gvZ);
      paramViewGroup.nSt.setText((CharSequence)localObject);
      label201:
      if (!this.nSq) {
        break label361;
      }
      paramViewGroup.nSt.setVisibility(0);
    }
    for (;;)
    {
      AppMethodBeat.o(22104);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label235:
      i = -1;
      break label97;
      label241:
      paramViewGroup.nSs.setText(xN(this.nSp[paramInt]));
      break label125;
      label260:
      if ((paramInt > 0) && (this.nSp[paramInt] != i))
      {
        paramViewGroup.nSs.setVisibility(0);
        paramViewGroup.nSs.setText(xN(this.nSp[paramInt]));
        break label125;
      }
      paramViewGroup.nSs.setVisibility(8);
      break label125;
      label314:
      paramViewGroup.ejj.setText(((a)localObject).fHT);
      paramViewGroup.nSt.setText(" (+" + ((a)localObject).countryCode + ")");
      break label201;
      label361:
      paramViewGroup.nSt.setVisibility(4);
    }
  }
  
  public final void wQ(String paramString)
  {
    AppMethodBeat.i(22103);
    if (paramString != null)
    {
      this.gvZ = paramString.trim();
      this.list.clear();
      int j = this.nSn.size();
      int i = 0;
      while (i < j)
      {
        if ((((a)this.nSn.get(i)).fHT.toUpperCase().contains(this.gvZ.toUpperCase())) || (((a)this.nSn.get(i)).fHU.toUpperCase().contains(this.gvZ.toUpperCase())) || (((a)this.nSn.get(i)).countryCode.contains(this.gvZ))) {
          this.list.add(this.nSn.get(i));
        }
        i += 1;
      }
      bKh();
      if (this.list.size() != 0) {
        break label199;
      }
      this.nSo.nSg.setVisibility(0);
    }
    for (;;)
    {
      super.notifyDataSetChanged();
      AppMethodBeat.o(22103);
      return;
      label199:
      this.nSo.nSg.setVisibility(8);
    }
  }
  
  static final class a
  {
    TextView ejj;
    TextView nSs;
    TextView nSt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.f
 * JD-Core Version:    0.7.0.1
 */