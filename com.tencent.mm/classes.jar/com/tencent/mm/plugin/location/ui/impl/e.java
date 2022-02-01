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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class e
  extends BaseAdapter
{
  byte[] buffer;
  boolean cKB;
  private Context context;
  boolean hkx;
  boolean jjp;
  String key;
  String pwx;
  int uT;
  private double vov;
  private double vow;
  List<f> vsU;
  private String vsV;
  private String vsW;
  
  public e(Context paramContext)
  {
    AppMethodBeat.i(56089);
    this.vsU = new ArrayList();
    this.uT = 0;
    this.buffer = null;
    this.hkx = false;
    this.key = "";
    this.pwx = "";
    this.jjp = false;
    this.cKB = false;
    this.context = paramContext;
    AppMethodBeat.o(56089);
  }
  
  private Spannable apR(String paramString)
  {
    AppMethodBeat.i(56096);
    paramString = com.tencent.mm.plugin.fts.a.f.b(paramString, this.pwx);
    AppMethodBeat.o(56096);
    return paramString;
  }
  
  public final f Jx(int paramInt)
  {
    AppMethodBeat.i(56094);
    f localf = (f)this.vsU.get(paramInt);
    AppMethodBeat.o(56094);
    return localf;
  }
  
  public final void a(List<f> paramList, byte[] paramArrayOfByte, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(56092);
    if ((this.key == null) || (!this.key.equals(paramString)))
    {
      ae.i("MicroMsg.PoiAdapter", "old key, dismiss it %s %s.", new Object[] { this.key, paramString });
      AppMethodBeat.o(56092);
      return;
    }
    int i = this.vsU.size();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      paramString = (f)paramList.next();
      paramString.vtm = i;
      i += 1;
      this.vsU.add(paramString);
    }
    this.buffer = paramArrayOfByte;
    this.hkx = paramBoolean;
    notifyDataSetChanged();
    AppMethodBeat.o(56092);
  }
  
  public final void apQ(String paramString)
  {
    AppMethodBeat.i(56091);
    this.key = paramString;
    ae.i("MicroMsg.PoiAdapter", "initData key %s.", new Object[] { paramString });
    AppMethodBeat.o(56091);
  }
  
  public final void clean()
  {
    AppMethodBeat.i(56090);
    this.buffer = null;
    this.hkx = false;
    this.key = "";
    this.vsU.clear();
    this.uT = -1;
    AppMethodBeat.o(56090);
  }
  
  public final void dkl()
  {
    this.buffer = null;
    this.hkx = false;
    this.key = "";
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(56093);
    int i = this.vsU.size();
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
      locala.vsX = localView.findViewById(2131303329);
      locala.titleView = ((TextView)localView.findViewById(2131303331));
      locala.vsZ = ((TextView)localView.findViewById(2131303330));
      locala.vsY = localView.findViewById(2131303333);
      localView.setTag(locala);
      localf = (f)this.vsU.get(paramInt);
      if ((1 != localf.type) && (2 != localf.type)) {
        break label567;
      }
      locala.titleView.setText(bu.bI(localf.vta, ""));
      locala.vsZ.setVisibility(8);
      if (!bu.isNullOrNil(localf.mName)) {
        break label579;
      }
      paramView = this.context.getResources().getString(2131760711);
      localObject = "";
      if ((bu.isNullOrNil(this.vsV)) || (!bu.bI(localf.vte, "").equals(this.vsV))) {
        break label588;
      }
      paramViewGroup = (ViewGroup)localObject;
      if (!bu.isNullOrNil(this.vsW))
      {
        paramViewGroup = (ViewGroup)localObject;
        if (!bu.bI(localf.vtf, "").equals(this.vsW)) {
          paramViewGroup = bu.bI(localf.vtf, "");
        }
      }
      label261:
      paramViewGroup = paramViewGroup + bu.bI(localf.vtg, "");
      localObject = paramViewGroup + bu.bI(localf.vti, "");
      paramViewGroup = (ViewGroup)localObject;
      if (bu.isNullOrNil((String)localObject)) {
        paramViewGroup = bu.bI(localf.vta, "");
      }
      if ((!this.jjp) || (bu.isNullOrNil(this.pwx))) {
        break label702;
      }
      paramView = apR(paramView);
      paramViewGroup = apR(paramViewGroup);
    }
    label567:
    label702:
    for (;;)
    {
      locala.titleView.setText(paramView);
      TextView localTextView = locala.vsZ;
      double d1 = localf.bXD;
      double d2 = localf.bXE;
      int i = (int)TencentLocationUtils.distanceBetween(this.vov, this.vow, d1, d2);
      ae.d("MicroMsg.PoiAdapter", "mLat %s mLng %s lat %s lng %s dis %s.", new Object[] { Double.valueOf(this.vov), Double.valueOf(this.vow), Double.valueOf(d1), Double.valueOf(d2), Integer.valueOf(i) });
      if (i < 100)
      {
        paramView = "100m内";
        label484:
        localObject = paramView;
        if (!bu.ah(paramViewGroup)) {
          localObject = paramView + " | " + paramViewGroup;
        }
        localTextView.setText((CharSequence)localObject);
        if (paramInt != this.uT) {
          break label690;
        }
        locala.vsY.setVisibility(0);
      }
      for (;;)
      {
        AppMethodBeat.o(56095);
        return localView;
        locala = (a)paramView.getTag();
        localView = paramView;
        break;
        locala.vsZ.setVisibility(0);
        break label156;
        label579:
        paramView = localf.mName;
        break label180;
        label588:
        paramViewGroup = bu.bI(localf.vte, "");
        paramViewGroup = paramViewGroup + bu.bI(localf.vtf, "");
        break label261;
        if (i >= 1000)
        {
          paramView = bu.x("%.1fkm", new Object[] { Double.valueOf(i / 1000.0D) });
          break label484;
        }
        paramView = i + "m";
        break label484;
        locala.vsY.setVisibility(4);
      }
    }
  }
  
  public final void hO(String paramString1, String paramString2)
  {
    this.vsV = paramString1;
    this.vsW = paramString2;
  }
  
  public final void m(double paramDouble1, double paramDouble2)
  {
    this.vov = paramDouble1;
    this.vow = paramDouble2;
  }
  
  static final class a
  {
    TextView titleView;
    View vsX;
    View vsY;
    TextView vsZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.e
 * JD-Core Version:    0.7.0.1
 */