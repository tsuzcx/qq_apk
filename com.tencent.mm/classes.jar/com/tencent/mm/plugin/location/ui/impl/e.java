package com.tencent.mm.plugin.location.ui.impl;

import android.content.Context;
import android.content.res.Resources;
import android.text.Spannable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.map.geolocation.TencentLocationUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class e
  extends BaseAdapter
{
  byte[] buffer;
  private Context context;
  boolean cyW;
  boolean gNN;
  boolean iNn;
  String key;
  String oMj;
  private double tZB;
  private double tZC;
  int ta;
  List<f> ued;
  private String uee;
  private String uef;
  
  public e(Context paramContext)
  {
    AppMethodBeat.i(56089);
    this.ued = new ArrayList();
    this.ta = 0;
    this.buffer = null;
    this.gNN = false;
    this.key = "";
    this.oMj = "";
    this.iNn = false;
    this.cyW = false;
    this.context = paramContext;
    AppMethodBeat.o(56089);
  }
  
  private Spannable ajZ(String paramString)
  {
    AppMethodBeat.i(56096);
    paramString = com.tencent.mm.plugin.fts.a.f.b(paramString, this.oMj);
    AppMethodBeat.o(56096);
    return paramString;
  }
  
  public final f HC(int paramInt)
  {
    AppMethodBeat.i(56094);
    f localf = (f)this.ued.get(paramInt);
    AppMethodBeat.o(56094);
    return localf;
  }
  
  public final void a(List<f> paramList, byte[] paramArrayOfByte, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(56092);
    if ((this.key == null) || (!this.key.equals(paramString)))
    {
      ac.i("MicroMsg.PoiAdapter", "old key, dismiss it %s %s.", new Object[] { this.key, paramString });
      AppMethodBeat.o(56092);
      return;
    }
    int i = this.ued.size();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      paramString = (f)paramList.next();
      paramString.uew = i;
      i += 1;
      this.ued.add(paramString);
    }
    this.buffer = paramArrayOfByte;
    this.gNN = paramBoolean;
    notifyDataSetChanged();
    AppMethodBeat.o(56092);
  }
  
  public final void ajY(String paramString)
  {
    AppMethodBeat.i(56091);
    this.key = paramString;
    ac.i("MicroMsg.PoiAdapter", "initData key %s.", new Object[] { paramString });
    AppMethodBeat.o(56091);
  }
  
  public final void cYa()
  {
    this.buffer = null;
    this.gNN = false;
    this.key = "";
  }
  
  public final void clean()
  {
    AppMethodBeat.i(56090);
    this.buffer = null;
    this.gNN = false;
    this.key = "";
    this.ued.clear();
    this.ta = -1;
    AppMethodBeat.o(56090);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(56093);
    int i = this.ued.size();
    AppMethodBeat.o(56093);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(56095);
    View localView;
    a locala;
    f localf;
    label156:
    label180:
    Object localObject;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.context).inflate(2131495099, paramViewGroup, false);
      locala = new a();
      locala.ueg = localView.findViewById(2131303329);
      locala.titleView = ((TextView)localView.findViewById(2131303331));
      locala.uej = ((TextView)localView.findViewById(2131303330));
      locala.uei = localView.findViewById(2131303333);
      localView.setTag(locala);
      localf = (f)this.ued.get(paramInt);
      if ((1 != localf.type) && (2 != localf.type)) {
        break label567;
      }
      locala.titleView.setText(bs.bG(localf.uek, ""));
      locala.uej.setVisibility(8);
      if (!bs.isNullOrNil(localf.mName)) {
        break label579;
      }
      paramView = this.context.getResources().getString(2131760711);
      localObject = "";
      if ((bs.isNullOrNil(this.uee)) || (!bs.bG(localf.ueo, "").equals(this.uee))) {
        break label588;
      }
      paramViewGroup = (ViewGroup)localObject;
      if (!bs.isNullOrNil(this.uef))
      {
        paramViewGroup = (ViewGroup)localObject;
        if (!bs.bG(localf.uep, "").equals(this.uef)) {
          paramViewGroup = bs.bG(localf.uep, "");
        }
      }
      label261:
      paramViewGroup = paramViewGroup + bs.bG(localf.ueq, "");
      localObject = paramViewGroup + bs.bG(localf.ues, "");
      paramViewGroup = (ViewGroup)localObject;
      if (bs.isNullOrNil((String)localObject)) {
        paramViewGroup = bs.bG(localf.uek, "");
      }
      if ((!this.iNn) || (bs.isNullOrNil(this.oMj))) {
        break label702;
      }
      paramView = ajZ(paramView);
      paramViewGroup = ajZ(paramViewGroup);
    }
    label567:
    label702:
    for (;;)
    {
      locala.titleView.setText(paramView);
      TextView localTextView = locala.uej;
      double d1 = localf.bNq;
      double d2 = localf.bNr;
      int i = (int)TencentLocationUtils.distanceBetween(this.tZB, this.tZC, d1, d2);
      ac.d("MicroMsg.PoiAdapter", "mLat %s mLng %s lat %s lng %s dis %s.", new Object[] { Double.valueOf(this.tZB), Double.valueOf(this.tZC), Double.valueOf(d1), Double.valueOf(d2), Integer.valueOf(i) });
      if (i < 100)
      {
        paramView = "100m内";
        label484:
        localObject = paramView;
        if (!bs.aj(paramViewGroup)) {
          localObject = paramView + " | " + paramViewGroup;
        }
        localTextView.setText((CharSequence)localObject);
        if (paramInt != this.ta) {
          break label690;
        }
        locala.uei.setVisibility(0);
      }
      for (;;)
      {
        AppMethodBeat.o(56095);
        return localView;
        locala = (a)paramView.getTag();
        localView = paramView;
        break;
        locala.uej.setVisibility(0);
        break label156;
        label579:
        paramView = localf.mName;
        break label180;
        label588:
        paramViewGroup = bs.bG(localf.ueo, "");
        paramViewGroup = paramViewGroup + bs.bG(localf.uep, "");
        break label261;
        if (i >= 1000)
        {
          paramView = bs.u("%.1fkm", new Object[] { Double.valueOf(i / 1000.0D) });
          break label484;
        }
        paramView = i + "m";
        break label484;
        locala.uei.setVisibility(4);
      }
    }
  }
  
  public final void hv(String paramString1, String paramString2)
  {
    this.uee = paramString1;
    this.uef = paramString2;
  }
  
  public final void m(double paramDouble1, double paramDouble2)
  {
    this.tZB = paramDouble1;
    this.tZC = paramDouble2;
  }
  
  static final class a
  {
    TextView titleView;
    View ueg;
    View uei;
    TextView uej;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.e
 * JD-Core Version:    0.7.0.1
 */