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
import com.tencent.mm.plugin.map.a.e;
import com.tencent.mm.plugin.map.a.f;
import com.tencent.mm.plugin.map.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class e
  extends BaseAdapter
{
  private double Emf;
  private double Emg;
  List<f> EqE;
  private String EqF;
  private String EqG;
  int bFx;
  byte[] buffer;
  boolean cSY;
  private Context context;
  boolean kSa;
  String key;
  boolean mYQ;
  String una;
  
  public e(Context paramContext)
  {
    AppMethodBeat.i(56089);
    this.EqE = new ArrayList();
    this.bFx = 0;
    this.buffer = null;
    this.kSa = false;
    this.key = "";
    this.una = "";
    this.mYQ = false;
    this.cSY = false;
    this.context = paramContext;
    AppMethodBeat.o(56089);
  }
  
  private Spannable aNu(String paramString)
  {
    AppMethodBeat.i(56096);
    paramString = com.tencent.mm.plugin.fts.a.f.b(paramString, this.una);
    AppMethodBeat.o(56096);
    return paramString;
  }
  
  public final f VI(int paramInt)
  {
    AppMethodBeat.i(56094);
    f localf = (f)this.EqE.get(paramInt);
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
    int i = this.EqE.size();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      paramString = (f)paramList.next();
      paramString.EqX = i;
      i += 1;
      this.EqE.add(paramString);
    }
    this.buffer = paramArrayOfByte;
    this.kSa = paramBoolean;
    notifyDataSetChanged();
    AppMethodBeat.o(56092);
  }
  
  public final void aNt(String paramString)
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
    this.kSa = false;
    this.key = "";
    this.EqE.clear();
    this.bFx = -1;
    AppMethodBeat.o(56090);
  }
  
  public final void eNr()
  {
    this.buffer = null;
    this.kSa = false;
    this.key = "";
  }
  
  public int getCount()
  {
    AppMethodBeat.i(56093);
    int i = this.EqE.size();
    AppMethodBeat.o(56093);
    return i;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(56095);
    View localView;
    a locala;
    f localf;
    label161:
    label186:
    Object localObject;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.context).inflate(a.f.poi_list_item, paramViewGroup, false);
      locala = new a();
      locala.EqH = localView.findViewById(a.e.poi_item_location);
      locala.titleView = ((TextView)localView.findViewById(a.e.poi_item_location_title));
      locala.EqJ = ((TextView)localView.findViewById(a.e.poi_item_location_subtitle));
      locala.EqI = localView.findViewById(a.e.poi_item_tick);
      localView.setTag(locala);
      localf = (f)this.EqE.get(paramInt);
      if ((1 != localf.type) && (2 != localf.type)) {
        break label573;
      }
      locala.titleView.setText(Util.nullAs(localf.EqK, ""));
      locala.EqJ.setVisibility(8);
      if (!Util.isNullOrNil(localf.mName)) {
        break label585;
      }
      paramView = this.context.getResources().getString(a.i.location);
      localObject = "";
      if ((Util.isNullOrNil(this.EqF)) || (!Util.nullAs(localf.EqO, "").equals(this.EqF))) {
        break label594;
      }
      paramViewGroup = (ViewGroup)localObject;
      if (!Util.isNullOrNil(this.EqG))
      {
        paramViewGroup = (ViewGroup)localObject;
        if (!Util.nullAs(localf.EqP, "").equals(this.EqG)) {
          paramViewGroup = Util.nullAs(localf.EqP, "");
        }
      }
      label267:
      paramViewGroup = paramViewGroup + Util.nullAs(localf.EqQ, "");
      localObject = paramViewGroup + Util.nullAs(localf.EqT, "");
      paramViewGroup = (ViewGroup)localObject;
      if (Util.isNullOrNil((String)localObject)) {
        paramViewGroup = Util.nullAs(localf.EqK, "");
      }
      if ((!this.mYQ) || (Util.isNullOrNil(this.una))) {
        break label708;
      }
      paramView = aNu(paramView);
      paramViewGroup = aNu(paramViewGroup);
    }
    label573:
    label708:
    for (;;)
    {
      locala.titleView.setText(paramView);
      TextView localTextView = locala.EqJ;
      double d1 = localf.BVq;
      double d2 = localf.BVp;
      int i = (int)TencentLocationUtils.distanceBetween(this.Emf, this.Emg, d1, d2);
      Log.d("MicroMsg.PoiAdapter", "mLat %s mLng %s lat %s lng %s dis %s.", new Object[] { Double.valueOf(this.Emf), Double.valueOf(this.Emg), Double.valueOf(d1), Double.valueOf(d2), Integer.valueOf(i) });
      if (i < 100)
      {
        paramView = "100m内";
        label490:
        localObject = paramView;
        if (!Util.isNullOrNil(paramViewGroup)) {
          localObject = paramView + " | " + paramViewGroup;
        }
        localTextView.setText((CharSequence)localObject);
        if (paramInt != this.bFx) {
          break label696;
        }
        locala.EqI.setVisibility(0);
      }
      for (;;)
      {
        AppMethodBeat.o(56095);
        return localView;
        locala = (a)paramView.getTag();
        localView = paramView;
        break;
        locala.EqJ.setVisibility(0);
        break label161;
        label585:
        paramView = localf.mName;
        break label186;
        label594:
        paramViewGroup = Util.nullAs(localf.EqO, "");
        paramViewGroup = paramViewGroup + Util.nullAs(localf.EqP, "");
        break label267;
        if (i >= 1000)
        {
          paramView = Util.safeFormatString("%.1fkm", new Object[] { Double.valueOf(i / 1000.0D) });
          break label490;
        }
        paramView = i + "m";
        break label490;
        locala.EqI.setVisibility(4);
      }
    }
  }
  
  public final void iK(String paramString1, String paramString2)
  {
    this.EqF = paramString1;
    this.EqG = paramString2;
  }
  
  public final void k(double paramDouble1, double paramDouble2)
  {
    this.Emf = paramDouble1;
    this.Emg = paramDouble2;
  }
  
  static final class a
  {
    View EqH;
    View EqI;
    TextView EqJ;
    TextView titleView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.e
 * JD-Core Version:    0.7.0.1
 */