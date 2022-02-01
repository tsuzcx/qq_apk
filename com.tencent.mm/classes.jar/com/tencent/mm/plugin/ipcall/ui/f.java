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
  private IPCallCountryCodeSelectUI JMb;
  int[] JMc;
  boolean JMd;
  boolean JMe;
  private List<a> dTG;
  private List<a> list;
  private String pRp;
  
  public f(IPCallCountryCodeSelectUI paramIPCallCountryCodeSelectUI, List<a> paramList)
  {
    AppMethodBeat.i(25715);
    this.dTG = new ArrayList();
    this.JMd = false;
    this.JMe = false;
    this.JMb = paramIPCallCountryCodeSelectUI;
    this.list = paramList;
    fSi();
    fSj();
    AppMethodBeat.o(25715);
  }
  
  private static String Zl(int paramInt)
  {
    AppMethodBeat.i(25722);
    char c = (char)paramInt;
    String[] arrayOfString = IPCallCountryCodeScrollbar.JMh;
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
  
  private void fSi()
  {
    AppMethodBeat.i(25716);
    int j = this.list.size();
    int i = 0;
    while (i < j)
    {
      this.dTG.add((a)this.list.get(i));
      i += 1;
    }
    this.JMb.JLU.setVisibility(8);
    AppMethodBeat.o(25716);
  }
  
  private void fSj()
  {
    AppMethodBeat.i(25717);
    this.JMc = new int[this.list.size()];
    int j = this.list.size();
    int i = 0;
    while (i < j)
    {
      this.JMc[i] = ((a)this.list.get(i)).fSa();
      i += 1;
    }
    AppMethodBeat.o(25717);
  }
  
  public final void SM(String paramString)
  {
    AppMethodBeat.i(25720);
    if (paramString != null)
    {
      this.pRp = paramString.trim();
      this.list.clear();
      int j = this.dTG.size();
      int i = 0;
      while (i < j)
      {
        if ((((a)this.dTG.get(i)).oLl.toUpperCase().contains(this.pRp.toUpperCase())) || (((a)this.dTG.get(i)).oLm.toUpperCase().contains(this.pRp.toUpperCase())) || (((a)this.dTG.get(i)).countryCode.contains(this.pRp))) {
          this.list.add((a)this.dTG.get(i));
        }
        i += 1;
      }
      fSj();
      if (this.list.size() != 0) {
        break label202;
      }
      this.JMb.JLU.setVisibility(0);
    }
    for (;;)
    {
      super.notifyDataSetChanged();
      AppMethodBeat.o(25720);
      return;
      label202:
      this.JMb.JLU.setVisibility(8);
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
      paramView = View.inflate(this.JMb, R.i.gkI, null);
      paramViewGroup = new a();
      paramViewGroup.JMf = ((TextView)paramView.findViewById(R.h.contactitem_catalog));
      paramViewGroup.lDe = ((TextView)paramView.findViewById(R.h.fDq));
      paramViewGroup.JMg = ((TextView)paramView.findViewById(R.h.fDt));
      paramView.setTag(paramViewGroup);
      if (paramInt <= 0) {
        break label240;
      }
      i = this.JMc[(paramInt - 1)];
      label101:
      if (paramInt != 0) {
        break label265;
      }
      paramViewGroup.JMf.setVisibility(0);
      if (!this.JMe) {
        break label246;
      }
      paramViewGroup.JMf.setText(R.l.gRy);
      label130:
      if (Util.isNullOrNil(this.pRp)) {
        break label319;
      }
      Spannable localSpannable = com.tencent.mm.plugin.fts.a.f.b(((a)localObject).oLl, this.pRp);
      paramViewGroup.lDe.setText(localSpannable);
      localObject = com.tencent.mm.plugin.fts.a.f.b(" (+" + ((a)localObject).countryCode + ")", this.pRp);
      paramViewGroup.JMg.setText((CharSequence)localObject);
      label206:
      if (!this.JMd) {
        break label366;
      }
      paramViewGroup.JMg.setVisibility(0);
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
      paramViewGroup.JMf.setText(Zl(this.JMc[paramInt]));
      break label130;
      label265:
      if ((paramInt > 0) && (this.JMc[paramInt] != i))
      {
        paramViewGroup.JMf.setVisibility(0);
        paramViewGroup.JMf.setText(Zl(this.JMc[paramInt]));
        break label130;
      }
      paramViewGroup.JMf.setVisibility(8);
      break label130;
      label319:
      paramViewGroup.lDe.setText(((a)localObject).oLl);
      paramViewGroup.JMg.setText(" (+" + ((a)localObject).countryCode + ")");
      break label206;
      label366:
      paramViewGroup.JMg.setVisibility(4);
    }
  }
  
  static final class a
  {
    TextView JMf;
    TextView JMg;
    TextView lDe;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.f
 * JD-Core Version:    0.7.0.1
 */