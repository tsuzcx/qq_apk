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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class e
  extends BaseAdapter
{
  byte[] buffer;
  boolean cBN;
  private Context context;
  boolean gna;
  boolean inh;
  String key;
  String oiJ;
  int rZ;
  private double sRo;
  private double sRp;
  List<f> sVR;
  private String sVS;
  private String sVT;
  
  public e(Context paramContext)
  {
    AppMethodBeat.i(56089);
    this.sVR = new ArrayList();
    this.rZ = 0;
    this.buffer = null;
    this.gna = false;
    this.key = "";
    this.oiJ = "";
    this.inh = false;
    this.cBN = false;
    this.context = paramContext;
    AppMethodBeat.o(56089);
  }
  
  private Spannable aff(String paramString)
  {
    AppMethodBeat.i(56096);
    paramString = com.tencent.mm.plugin.fts.a.f.a(paramString, this.oiJ);
    AppMethodBeat.o(56096);
    return paramString;
  }
  
  public final f FH(int paramInt)
  {
    AppMethodBeat.i(56094);
    f localf = (f)this.sVR.get(paramInt);
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
    int i = this.sVR.size();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      paramString = (f)paramList.next();
      paramString.sWj = i;
      i += 1;
      this.sVR.add(paramString);
    }
    this.buffer = paramArrayOfByte;
    this.gna = paramBoolean;
    notifyDataSetChanged();
    AppMethodBeat.o(56092);
  }
  
  public final void afe(String paramString)
  {
    AppMethodBeat.i(56091);
    this.key = paramString;
    ad.i("MicroMsg.PoiAdapter", "initData key %s.", new Object[] { paramString });
    AppMethodBeat.o(56091);
  }
  
  public final void cKv()
  {
    this.buffer = null;
    this.gna = false;
    this.key = "";
  }
  
  public final void clean()
  {
    AppMethodBeat.i(56090);
    this.buffer = null;
    this.gna = false;
    this.key = "";
    this.sVR.clear();
    this.rZ = -1;
    AppMethodBeat.o(56090);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(56093);
    int i = this.sVR.size();
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
      locala.sVU = localView.findViewById(2131303329);
      locala.titleView = ((TextView)localView.findViewById(2131303331));
      locala.sVW = ((TextView)localView.findViewById(2131303330));
      locala.sVV = localView.findViewById(2131303333);
      localView.setTag(locala);
      localf = (f)this.sVR.get(paramInt);
      if ((1 != localf.type) && (2 != localf.type)) {
        break label567;
      }
      locala.titleView.setText(bt.by(localf.sVX, ""));
      locala.sVW.setVisibility(8);
      if (!bt.isNullOrNil(localf.mName)) {
        break label579;
      }
      paramView = this.context.getResources().getString(2131760711);
      localObject = "";
      if ((bt.isNullOrNil(this.sVS)) || (!bt.by(localf.sWb, "").equals(this.sVS))) {
        break label588;
      }
      paramViewGroup = (ViewGroup)localObject;
      if (!bt.isNullOrNil(this.sVT))
      {
        paramViewGroup = (ViewGroup)localObject;
        if (!bt.by(localf.sWc, "").equals(this.sVT)) {
          paramViewGroup = bt.by(localf.sWc, "");
        }
      }
      label261:
      paramViewGroup = paramViewGroup + bt.by(localf.sWd, "");
      localObject = paramViewGroup + bt.by(localf.sWf, "");
      paramViewGroup = (ViewGroup)localObject;
      if (bt.isNullOrNil((String)localObject)) {
        paramViewGroup = bt.by(localf.sVX, "");
      }
      if ((!this.inh) || (bt.isNullOrNil(this.oiJ))) {
        break label702;
      }
      paramView = aff(paramView);
      paramViewGroup = aff(paramViewGroup);
    }
    label567:
    label702:
    for (;;)
    {
      locala.titleView.setText(paramView);
      TextView localTextView = locala.sVW;
      double d1 = localf.bPI;
      double d2 = localf.bPJ;
      int i = (int)TencentLocationUtils.distanceBetween(this.sRo, this.sRp, d1, d2);
      ad.d("MicroMsg.PoiAdapter", "mLat %s mLng %s lat %s lng %s dis %s.", new Object[] { Double.valueOf(this.sRo), Double.valueOf(this.sRp), Double.valueOf(d1), Double.valueOf(d2), Integer.valueOf(i) });
      if (i < 100)
      {
        paramView = "100m内";
        label484:
        localObject = paramView;
        if (!bt.ai(paramViewGroup)) {
          localObject = paramView + " | " + paramViewGroup;
        }
        localTextView.setText((CharSequence)localObject);
        if (paramInt != this.rZ) {
          break label690;
        }
        locala.sVV.setVisibility(0);
      }
      for (;;)
      {
        AppMethodBeat.o(56095);
        return localView;
        locala = (a)paramView.getTag();
        localView = paramView;
        break;
        locala.sVW.setVisibility(0);
        break label156;
        label579:
        paramView = localf.mName;
        break label180;
        label588:
        paramViewGroup = bt.by(localf.sWb, "");
        paramViewGroup = paramViewGroup + bt.by(localf.sWc, "");
        break label261;
        if (i >= 1000)
        {
          paramView = bt.u("%.1fkm", new Object[] { Double.valueOf(i / 1000.0D) });
          break label484;
        }
        paramView = i + "m";
        break label484;
        locala.sVV.setVisibility(4);
      }
    }
  }
  
  public final void hc(String paramString1, String paramString2)
  {
    this.sVS = paramString1;
    this.sVT = paramString2;
  }
  
  public final void m(double paramDouble1, double paramDouble2)
  {
    this.sRo = paramDouble1;
    this.sRp = paramDouble2;
  }
  
  static final class a
  {
    View sVU;
    View sVV;
    TextView sVW;
    TextView titleView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.e
 * JD-Core Version:    0.7.0.1
 */