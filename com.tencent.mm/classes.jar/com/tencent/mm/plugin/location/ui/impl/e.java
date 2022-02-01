package com.tencent.mm.plugin.location.ui.impl;

import android.content.Context;
import android.content.res.Resources;
import android.text.Spannable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.map.geolocation.sapp.TencentLocationUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class e
  extends BaseAdapter
{
  byte[] buffer;
  boolean cJS;
  private Context context;
  boolean hhJ;
  boolean jgw;
  String key;
  String ppR;
  int uT;
  private double vck;
  private double vcl;
  List<f> vgN;
  private String vgO;
  private String vgP;
  
  public e(Context paramContext)
  {
    AppMethodBeat.i(56089);
    this.vgN = new ArrayList();
    this.uT = 0;
    this.buffer = null;
    this.hhJ = false;
    this.key = "";
    this.ppR = "";
    this.jgw = false;
    this.cJS = false;
    this.context = paramContext;
    AppMethodBeat.o(56089);
  }
  
  private Spannable aoM(String paramString)
  {
    AppMethodBeat.i(56096);
    paramString = com.tencent.mm.plugin.fts.a.f.b(paramString, this.ppR);
    AppMethodBeat.o(56096);
    return paramString;
  }
  
  public final f IY(int paramInt)
  {
    AppMethodBeat.i(56094);
    f localf = (f)this.vgN.get(paramInt);
    AppMethodBeat.o(56094);
    return localf;
  }
  
  public final void a(List<f> paramList, byte[] paramArrayOfByte, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(56092);
    if ((this.key == null) || (!this.key.equals(paramString)))
    {
      ad.i("MicroMsg.PoiAdapter", "old key, dismiss it %s %s.", new Object[] { this.key, paramString });
      AppMethodBeat.o(56092);
      return;
    }
    int i = this.vgN.size();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      paramString = (f)paramList.next();
      paramString.vhf = i;
      i += 1;
      this.vgN.add(paramString);
    }
    this.buffer = paramArrayOfByte;
    this.hhJ = paramBoolean;
    notifyDataSetChanged();
    AppMethodBeat.o(56092);
  }
  
  public final void aoL(String paramString)
  {
    AppMethodBeat.i(56091);
    this.key = paramString;
    ad.i("MicroMsg.PoiAdapter", "initData key %s.", new Object[] { paramString });
    AppMethodBeat.o(56091);
  }
  
  public final void clean()
  {
    AppMethodBeat.i(56090);
    this.buffer = null;
    this.hhJ = false;
    this.key = "";
    this.vgN.clear();
    this.uT = -1;
    AppMethodBeat.o(56090);
  }
  
  public final void dhm()
  {
    this.buffer = null;
    this.hhJ = false;
    this.key = "";
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(56093);
    int i = this.vgN.size();
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
      locala.vgQ = localView.findViewById(2131303329);
      locala.titleView = ((TextView)localView.findViewById(2131303331));
      locala.vgS = ((TextView)localView.findViewById(2131303330));
      locala.vgR = localView.findViewById(2131303333);
      localView.setTag(locala);
      localf = (f)this.vgN.get(paramInt);
      if ((1 != localf.type) && (2 != localf.type)) {
        break label567;
      }
      locala.titleView.setText(bt.bI(localf.vgT, ""));
      locala.vgS.setVisibility(8);
      if (!bt.isNullOrNil(localf.mName)) {
        break label579;
      }
      paramView = this.context.getResources().getString(2131760711);
      localObject = "";
      if ((bt.isNullOrNil(this.vgO)) || (!bt.bI(localf.vgX, "").equals(this.vgO))) {
        break label588;
      }
      paramViewGroup = (ViewGroup)localObject;
      if (!bt.isNullOrNil(this.vgP))
      {
        paramViewGroup = (ViewGroup)localObject;
        if (!bt.bI(localf.vgY, "").equals(this.vgP)) {
          paramViewGroup = bt.bI(localf.vgY, "");
        }
      }
      label261:
      paramViewGroup = paramViewGroup + bt.bI(localf.vgZ, "");
      localObject = paramViewGroup + bt.bI(localf.vhb, "");
      paramViewGroup = (ViewGroup)localObject;
      if (bt.isNullOrNil((String)localObject)) {
        paramViewGroup = bt.bI(localf.vgT, "");
      }
      if ((!this.jgw) || (bt.isNullOrNil(this.ppR))) {
        break label702;
      }
      paramView = aoM(paramView);
      paramViewGroup = aoM(paramViewGroup);
    }
    label567:
    label702:
    for (;;)
    {
      locala.titleView.setText(paramView);
      TextView localTextView = locala.vgS;
      double d1 = localf.bXD;
      double d2 = localf.bXE;
      int i = (int)TencentLocationUtils.distanceBetween(this.vck, this.vcl, d1, d2);
      ad.d("MicroMsg.PoiAdapter", "mLat %s mLng %s lat %s lng %s dis %s.", new Object[] { Double.valueOf(this.vck), Double.valueOf(this.vcl), Double.valueOf(d1), Double.valueOf(d2), Integer.valueOf(i) });
      if (i < 100)
      {
        paramView = "100m内";
        label484:
        localObject = paramView;
        if (!bt.ai(paramViewGroup)) {
          localObject = paramView + " | " + paramViewGroup;
        }
        localTextView.setText((CharSequence)localObject);
        if (paramInt != this.uT) {
          break label690;
        }
        locala.vgR.setVisibility(0);
      }
      for (;;)
      {
        AppMethodBeat.o(56095);
        return localView;
        locala = (a)paramView.getTag();
        localView = paramView;
        break;
        locala.vgS.setVisibility(0);
        break label156;
        label579:
        paramView = localf.mName;
        break label180;
        label588:
        paramViewGroup = bt.bI(localf.vgX, "");
        paramViewGroup = paramViewGroup + bt.bI(localf.vgY, "");
        break label261;
        if (i >= 1000)
        {
          paramView = bt.x("%.1fkm", new Object[] { Double.valueOf(i / 1000.0D) });
          break label484;
        }
        paramView = i + "m";
        break label484;
        locala.vgR.setVisibility(4);
      }
    }
  }
  
  public final void hH(String paramString1, String paramString2)
  {
    this.vgO = paramString1;
    this.vgP = paramString2;
  }
  
  public final void m(double paramDouble1, double paramDouble2)
  {
    this.vck = paramDouble1;
    this.vcl = paramDouble2;
  }
  
  static final class a
  {
    TextView titleView;
    View vgQ;
    View vgR;
    TextView vgS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.e
 * JD-Core Version:    0.7.0.1
 */