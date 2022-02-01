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
  private double KeO;
  private double KeP;
  List<f> Kjl;
  private String Kjm;
  private String Kjn;
  byte[] buffer;
  boolean clZ;
  private Context context;
  int dyx;
  String key;
  boolean nxG;
  boolean pVy;
  String xts;
  
  public e(Context paramContext)
  {
    AppMethodBeat.i(56089);
    this.Kjl = new ArrayList();
    this.dyx = 0;
    this.buffer = null;
    this.nxG = false;
    this.key = "";
    this.xts = "";
    this.pVy = false;
    this.clZ = false;
    this.context = paramContext;
    AppMethodBeat.o(56089);
  }
  
  private Spannable aKp(String paramString)
  {
    AppMethodBeat.i(56096);
    paramString = com.tencent.mm.plugin.fts.a.f.b(paramString, this.xts);
    AppMethodBeat.o(56096);
    return paramString;
  }
  
  public final f ZE(int paramInt)
  {
    AppMethodBeat.i(56094);
    f localf = (f)this.Kjl.get(paramInt);
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
    int i = this.Kjl.size();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      paramString = (f)paramList.next();
      paramString.KjD = i;
      i += 1;
      this.Kjl.add(paramString);
    }
    this.buffer = paramArrayOfByte;
    this.nxG = paramBoolean;
    notifyDataSetChanged();
    AppMethodBeat.o(56092);
  }
  
  public final void aKo(String paramString)
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
    this.nxG = false;
    this.key = "";
    this.Kjl.clear();
    this.dyx = -1;
    AppMethodBeat.o(56090);
  }
  
  public final void fVK()
  {
    this.buffer = null;
    this.nxG = false;
    this.key = "";
  }
  
  public int getCount()
  {
    AppMethodBeat.i(56093);
    int i = this.Kjl.size();
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
      locala.Kjo = localView.findViewById(a.e.poi_item_location);
      locala.titleView = ((TextView)localView.findViewById(a.e.poi_item_location_title));
      locala.KbK = ((TextView)localView.findViewById(a.e.poi_item_location_subtitle));
      locala.Kjp = localView.findViewById(a.e.poi_item_tick);
      localView.setTag(locala);
      localf = (f)this.Kjl.get(paramInt);
      if ((1 != localf.type) && (2 != localf.type)) {
        break label573;
      }
      locala.titleView.setText(Util.nullAs(localf.Kjq, ""));
      locala.KbK.setVisibility(8);
      if (!Util.isNullOrNil(localf.mName)) {
        break label585;
      }
      paramView = this.context.getResources().getString(a.i.location);
      localObject = "";
      if ((Util.isNullOrNil(this.Kjm)) || (!Util.nullAs(localf.Kju, "").equals(this.Kjm))) {
        break label594;
      }
      paramViewGroup = (ViewGroup)localObject;
      if (!Util.isNullOrNil(this.Kjn))
      {
        paramViewGroup = (ViewGroup)localObject;
        if (!Util.nullAs(localf.Kjv, "").equals(this.Kjn)) {
          paramViewGroup = Util.nullAs(localf.Kjv, "");
        }
      }
      label267:
      paramViewGroup = paramViewGroup + Util.nullAs(localf.Kjw, "");
      localObject = paramViewGroup + Util.nullAs(localf.Kjz, "");
      paramViewGroup = (ViewGroup)localObject;
      if (Util.isNullOrNil((String)localObject)) {
        paramViewGroup = Util.nullAs(localf.Kjq, "");
      }
      if ((!this.pVy) || (Util.isNullOrNil(this.xts))) {
        break label708;
      }
      paramView = aKp(paramView);
      paramViewGroup = aKp(paramViewGroup);
    }
    label573:
    label708:
    for (;;)
    {
      locala.titleView.setText(paramView);
      TextView localTextView = locala.KbK;
      double d1 = localf.HHO;
      double d2 = localf.HHN;
      int i = (int)TencentLocationUtils.distanceBetween(this.KeO, this.KeP, d1, d2);
      Log.d("MicroMsg.PoiAdapter", "mLat %s mLng %s lat %s lng %s dis %s.", new Object[] { Double.valueOf(this.KeO), Double.valueOf(this.KeP), Double.valueOf(d1), Double.valueOf(d2), Integer.valueOf(i) });
      if (i < 100)
      {
        paramView = "100m内";
        label490:
        localObject = paramView;
        if (!Util.isNullOrNil(paramViewGroup)) {
          localObject = paramView + " | " + paramViewGroup;
        }
        localTextView.setText((CharSequence)localObject);
        if (paramInt != this.dyx) {
          break label696;
        }
        locala.Kjp.setVisibility(0);
      }
      for (;;)
      {
        AppMethodBeat.o(56095);
        return localView;
        locala = (a)paramView.getTag();
        localView = paramView;
        break;
        locala.KbK.setVisibility(0);
        break label161;
        label585:
        paramView = localf.mName;
        break label186;
        label594:
        paramViewGroup = Util.nullAs(localf.Kju, "");
        paramViewGroup = paramViewGroup + Util.nullAs(localf.Kjv, "");
        break label267;
        if (i >= 1000)
        {
          paramView = Util.safeFormatString("%.1fkm", new Object[] { Double.valueOf(i / 1000.0D) });
          break label490;
        }
        paramView = i + "m";
        break label490;
        locala.Kjp.setVisibility(4);
      }
    }
  }
  
  public final void jU(String paramString1, String paramString2)
  {
    this.Kjm = paramString1;
    this.Kjn = paramString2;
  }
  
  public final void o(double paramDouble1, double paramDouble2)
  {
    this.KeO = paramDouble1;
    this.KeP = paramDouble2;
  }
  
  static final class a
  {
    TextView KbK;
    View Kjo;
    View Kjp;
    TextView titleView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.e
 * JD-Core Version:    0.7.0.1
 */