package com.tencent.mm.plugin.ipcall.ui;

import android.text.Spannable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;

public final class f
  extends BaseAdapter
{
  private IPCallCountryCodeSelectUI DUS;
  int[] DUT;
  boolean DUU;
  boolean DUV;
  private List<a> iZZ;
  private List<a> list;
  private String mUI;
  
  public f(IPCallCountryCodeSelectUI paramIPCallCountryCodeSelectUI, List<a> paramList)
  {
    AppMethodBeat.i(25715);
    this.iZZ = new ArrayList();
    this.DUU = false;
    this.DUV = false;
    this.DUS = paramIPCallCountryCodeSelectUI;
    this.list = paramList;
    eKi();
    eKj();
    AppMethodBeat.o(25715);
  }
  
  private static String Vq(int paramInt)
  {
    AppMethodBeat.i(25722);
    char c = (char)paramInt;
    String[] arrayOfString = IPCallCountryCodeScrollbar.DUY;
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
  
  private void eKi()
  {
    AppMethodBeat.i(25716);
    int i = 0;
    int j = this.list.size();
    while (i < j)
    {
      this.iZZ.add(this.list.get(i));
      i += 1;
    }
    this.DUS.DUL.setVisibility(8);
    AppMethodBeat.o(25716);
  }
  
  private void eKj()
  {
    AppMethodBeat.i(25717);
    this.DUT = new int[this.list.size()];
    int j = this.list.size();
    int i = 0;
    while (i < j)
    {
      this.DUT[i] = ((a)this.list.get(i)).eKa();
      i += 1;
    }
    AppMethodBeat.o(25717);
  }
  
  public final void aas(String paramString)
  {
    AppMethodBeat.i(25720);
    if (paramString != null)
    {
      this.mUI = paramString.trim();
      this.list.clear();
      int j = this.iZZ.size();
      int i = 0;
      while (i < j)
      {
        if ((((a)this.iZZ.get(i)).lSz.toUpperCase().contains(this.mUI.toUpperCase())) || (((a)this.iZZ.get(i)).lSA.toUpperCase().contains(this.mUI.toUpperCase())) || (((a)this.iZZ.get(i)).countryCode.contains(this.mUI))) {
          this.list.add(this.iZZ.get(i));
        }
        i += 1;
      }
      eKj();
      if (this.list.size() != 0) {
        break label199;
      }
      this.DUS.DUL.setVisibility(0);
    }
    for (;;)
    {
      super.notifyDataSetChanged();
      AppMethodBeat.o(25720);
      return;
      label199:
      this.DUS.DUL.setVisibility(8);
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
      paramView = View.inflate(this.DUS, R.i.ehN, null);
      paramViewGroup = new a();
      paramViewGroup.DUW = ((TextView)paramView.findViewById(R.h.dCx));
      paramViewGroup.jbe = ((TextView)paramView.findViewById(R.h.dCB));
      paramViewGroup.DUX = ((TextView)paramView.findViewById(R.h.dCE));
      paramView.setTag(paramViewGroup);
      if (paramInt <= 0) {
        break label240;
      }
      i = this.DUT[(paramInt - 1)];
      label101:
      if (paramInt != 0) {
        break label265;
      }
      paramViewGroup.DUW.setVisibility(0);
      if (!this.DUV) {
        break label246;
      }
      paramViewGroup.DUW.setText(R.l.eOX);
      label130:
      if (Util.isNullOrNil(this.mUI)) {
        break label319;
      }
      Spannable localSpannable = com.tencent.mm.plugin.fts.a.f.b(((a)localObject).lSz, this.mUI);
      paramViewGroup.jbe.setText(localSpannable);
      localObject = com.tencent.mm.plugin.fts.a.f.b(" (+" + ((a)localObject).countryCode + ")", this.mUI);
      paramViewGroup.DUX.setText((CharSequence)localObject);
      label206:
      if (!this.DUU) {
        break label366;
      }
      paramViewGroup.DUX.setVisibility(0);
    }
    for (;;)
    {
      AppMethodBeat.o(25721);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label240:
      i = -1;
      break label101;
      label246:
      paramViewGroup.DUW.setText(Vq(this.DUT[paramInt]));
      break label130;
      label265:
      if ((paramInt > 0) && (this.DUT[paramInt] != i))
      {
        paramViewGroup.DUW.setVisibility(0);
        paramViewGroup.DUW.setText(Vq(this.DUT[paramInt]));
        break label130;
      }
      paramViewGroup.DUW.setVisibility(8);
      break label130;
      label319:
      paramViewGroup.jbe.setText(((a)localObject).lSz);
      paramViewGroup.DUX.setText(" (+" + ((a)localObject).countryCode + ")");
      break label206;
      label366:
      paramViewGroup.DUX.setVisibility(4);
    }
  }
  
  static final class a
  {
    TextView DUW;
    TextView DUX;
    TextView jbe;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.f
 * JD-Core Version:    0.7.0.1
 */