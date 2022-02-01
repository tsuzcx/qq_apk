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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class e
  extends BaseAdapter
{
  byte[] buffer;
  private Context context;
  boolean daZ;
  boolean idt;
  String key;
  boolean khr;
  String qLO;
  int va;
  private double yIm;
  private double yIn;
  List<f> yMH;
  private String yMI;
  private String yMJ;
  
  public e(Context paramContext)
  {
    AppMethodBeat.i(56089);
    this.yMH = new ArrayList();
    this.va = 0;
    this.buffer = null;
    this.idt = false;
    this.key = "";
    this.qLO = "";
    this.khr = false;
    this.daZ = false;
    this.context = paramContext;
    AppMethodBeat.o(56089);
  }
  
  private Spannable aDk(String paramString)
  {
    AppMethodBeat.i(56096);
    paramString = com.tencent.mm.plugin.fts.a.f.b(paramString, this.qLO);
    AppMethodBeat.o(56096);
    return paramString;
  }
  
  public final f Pz(int paramInt)
  {
    AppMethodBeat.i(56094);
    f localf = (f)this.yMH.get(paramInt);
    AppMethodBeat.o(56094);
    return localf;
  }
  
  public final void a(List<f> paramList, byte[] paramArrayOfByte, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(56092);
    if ((this.key == null) || (!this.key.equals(paramString)))
    {
      Log.i("MicroMsg.PoiAdapter", "old key, dismiss it %s %s.", new Object[] { this.key, paramString });
      AppMethodBeat.o(56092);
      return;
    }
    int i = this.yMH.size();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      paramString = (f)paramList.next();
      paramString.yMZ = i;
      i += 1;
      this.yMH.add(paramString);
    }
    this.buffer = paramArrayOfByte;
    this.idt = paramBoolean;
    notifyDataSetChanged();
    AppMethodBeat.o(56092);
  }
  
  public final void aDj(String paramString)
  {
    AppMethodBeat.i(56091);
    this.key = paramString;
    Log.i("MicroMsg.PoiAdapter", "initData key %s.", new Object[] { paramString });
    AppMethodBeat.o(56091);
  }
  
  public final void clean()
  {
    AppMethodBeat.i(56090);
    this.buffer = null;
    this.idt = false;
    this.key = "";
    this.yMH.clear();
    this.va = -1;
    AppMethodBeat.o(56090);
  }
  
  public final void edW()
  {
    this.buffer = null;
    this.idt = false;
    this.key = "";
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(56093);
    int i = this.yMH.size();
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
      localView = LayoutInflater.from(this.context).inflate(2131495939, paramViewGroup, false);
      locala = new a();
      locala.yMK = localView.findViewById(2131306006);
      locala.titleView = ((TextView)localView.findViewById(2131306008));
      locala.yMM = ((TextView)localView.findViewById(2131306007));
      locala.yML = localView.findViewById(2131306010);
      localView.setTag(locala);
      localf = (f)this.yMH.get(paramInt);
      if ((1 != localf.type) && (2 != localf.type)) {
        break label567;
      }
      locala.titleView.setText(Util.nullAs(localf.yMN, ""));
      locala.yMM.setVisibility(8);
      if (!Util.isNullOrNil(localf.mName)) {
        break label579;
      }
      paramView = this.context.getResources().getString(2131762449);
      localObject = "";
      if ((Util.isNullOrNil(this.yMI)) || (!Util.nullAs(localf.yMR, "").equals(this.yMI))) {
        break label588;
      }
      paramViewGroup = (ViewGroup)localObject;
      if (!Util.isNullOrNil(this.yMJ))
      {
        paramViewGroup = (ViewGroup)localObject;
        if (!Util.nullAs(localf.yMS, "").equals(this.yMJ)) {
          paramViewGroup = Util.nullAs(localf.yMS, "");
        }
      }
      label261:
      paramViewGroup = paramViewGroup + Util.nullAs(localf.yMT, "");
      localObject = paramViewGroup + Util.nullAs(localf.yMV, "");
      paramViewGroup = (ViewGroup)localObject;
      if (Util.isNullOrNil((String)localObject)) {
        paramViewGroup = Util.nullAs(localf.yMN, "");
      }
      if ((!this.khr) || (Util.isNullOrNil(this.qLO))) {
        break label702;
      }
      paramView = aDk(paramView);
      paramViewGroup = aDk(paramViewGroup);
    }
    label567:
    label702:
    for (;;)
    {
      locala.titleView.setText(paramView);
      TextView localTextView = locala.yMM;
      double d1 = localf.cik;
      double d2 = localf.cil;
      int i = (int)TencentLocationUtils.distanceBetween(this.yIm, this.yIn, d1, d2);
      Log.d("MicroMsg.PoiAdapter", "mLat %s mLng %s lat %s lng %s dis %s.", new Object[] { Double.valueOf(this.yIm), Double.valueOf(this.yIn), Double.valueOf(d1), Double.valueOf(d2), Integer.valueOf(i) });
      if (i < 100)
      {
        paramView = "100m内";
        label484:
        localObject = paramView;
        if (!Util.isNullOrNil(paramViewGroup)) {
          localObject = paramView + " | " + paramViewGroup;
        }
        localTextView.setText((CharSequence)localObject);
        if (paramInt != this.va) {
          break label690;
        }
        locala.yML.setVisibility(0);
      }
      for (;;)
      {
        AppMethodBeat.o(56095);
        return localView;
        locala = (a)paramView.getTag();
        localView = paramView;
        break;
        locala.yMM.setVisibility(0);
        break label156;
        label579:
        paramView = localf.mName;
        break label180;
        label588:
        paramViewGroup = Util.nullAs(localf.yMR, "");
        paramViewGroup = paramViewGroup + Util.nullAs(localf.yMS, "");
        break label261;
        if (i >= 1000)
        {
          paramView = Util.safeFormatString("%.1fkm", new Object[] { Double.valueOf(i / 1000.0D) });
          break label484;
        }
        paramView = i + "m";
        break label484;
        locala.yML.setVisibility(4);
      }
    }
  }
  
  public final void iy(String paramString1, String paramString2)
  {
    this.yMI = paramString1;
    this.yMJ = paramString2;
  }
  
  public final void m(double paramDouble1, double paramDouble2)
  {
    this.yIm = paramDouble1;
    this.yIn = paramDouble2;
  }
  
  static final class a
  {
    TextView titleView;
    View yMK;
    View yML;
    TextView yMM;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.e
 * JD-Core Version:    0.7.0.1
 */