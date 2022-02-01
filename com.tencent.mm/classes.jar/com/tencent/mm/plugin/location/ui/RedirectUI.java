package com.tencent.mm.plugin.location.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bb.c;
import com.tencent.mm.g.a.pz;
import com.tencent.mm.g.a.tw;
import com.tencent.mm.g.a.xr;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.location.model.n;
import com.tencent.mm.plugin.location.model.r;
import com.tencent.mm.pluginsdk.location.LocationIntent;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import java.util.LinkedList;

@com.tencent.mm.ui.base.a(23)
public class RedirectUI
  extends HellActivity
{
  private static long gmF = 86400000L;
  private String haD;
  private final MMHandler handler;
  private String info;
  private boolean isStart;
  private long msgId;
  private int qcr;
  private int type;
  private double yFu;
  private double yFv;
  private int yFw;
  private boolean yHD;
  private final int yIA;
  private final int yIB;
  private final int yIC;
  private final int yID;
  private String yIw;
  private int yIx;
  private final int yIy;
  private boolean yIz;
  
  public RedirectUI()
  {
    AppMethodBeat.i(55874);
    this.type = 0;
    this.isStart = false;
    this.yHD = true;
    this.yFu = 0.0D;
    this.yFv = 0.0D;
    this.yIw = "";
    this.haD = "";
    this.yFw = 0;
    this.info = "";
    this.handler = new MMHandler();
    this.yIy = 1;
    this.yIz = false;
    this.yIA = 0;
    this.yIB = 1;
    this.yIC = 0;
    this.yID = 1;
    AppMethodBeat.o(55874);
  }
  
  private void a(Intent paramIntent, double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(55878);
    if (paramIntent != null)
    {
      paramIntent.putExtra("kShowshare", getIntent().getBooleanExtra("kShowshare", true));
      paramIntent.putExtra("kimg_path", com.tencent.mm.plugin.image.d.aSY());
      paramIntent.putExtra("kPoi_url", Util.nullAs(getIntent().getStringExtra("kPoi_url"), ""));
      paramIntent.putExtra("map_view_type", getIntent().getIntExtra("map_view_type", 0));
      paramIntent.putExtra("kFavInfoLocalId", getIntent().getLongExtra("kFavInfoLocalId", -1L));
      paramIntent.putExtra("kFavCanDel", getIntent().getBooleanExtra("kFavCanDel", true));
      paramIntent.putExtra("kFavCanRemark", getIntent().getBooleanExtra("kFavCanRemark", true));
      paramIntent.putExtra("kwebmap_slat", paramDouble1);
      paramIntent.putExtra("kwebmap_lng", paramDouble2);
      paramIntent.putExtra("kPoiid", getIntent().getStringExtra("kPoiid"));
      paramIntent.putExtra("kPoiName", getIntent().getStringExtra("kPoiName"));
      paramIntent.putExtra("kisUsername", Util.nullAs(getIntent().getStringExtra("kisUsername"), ""));
      paramIntent.putExtra("map_talker_name", this.haD);
      paramIntent.putExtra("kIs_pick_poi", getIntent().getBooleanExtra("kIs_pick_poi", false));
      paramIntent.putExtra("KFavLocSigleView", getIntent().getBooleanExtra("KFavLocSigleView", false));
      xr localxr = new xr();
      localxr.edW.edX = true;
      EventCenter.instance.publish(localxr);
      if (this.type == 6)
      {
        paramIntent.putExtra("kMsgId", getIntent().getLongExtra("kMsgId", -1L));
        paramIntent.putExtra("kRemark", getIntent().getStringExtra("kRemark"));
        if (this.yFw > 0) {
          paramIntent.putExtra("kwebmap_scale", this.yFw);
        }
        paramIntent.putExtra("Kwebmap_locaion", this.info);
        paramIntent.putExtra("soso_street_view_url", getIntent().getStringExtra("soso_street_view_url"));
        startActivityForResult(paramIntent, 3);
        AppMethodBeat.o(55878);
        return;
      }
      if ((this.type == 1) || (this.type == 2) || (this.type == 7) || (this.type == 9) || (this.type == 10))
      {
        paramIntent.putExtra("kMsgId", getIntent().getLongExtra("kMsgId", -1L));
        paramIntent.putExtra("kRemark", getIntent().getStringExtra("kRemark"));
        paramIntent.putExtra("kTags", getIntent().getStringArrayListExtra("kTags"));
        if (this.yFw > 0) {
          paramIntent.putExtra("kwebmap_scale", this.yFw);
        }
        paramIntent.putExtra("Kwebmap_locaion", this.info);
        paramIntent.putExtra("soso_street_view_url", getIntent().getStringExtra("soso_street_view_url"));
        startActivityForResult(paramIntent, 3);
        AppMethodBeat.o(55878);
        return;
      }
      if (this.type == 0)
      {
        startActivityForResult(paramIntent, 2);
        AppMethodBeat.o(55878);
        return;
      }
      if (this.type == 3)
      {
        startActivityForResult(paramIntent, 5);
        AppMethodBeat.o(55878);
        return;
      }
      if (this.type == 8)
      {
        paramIntent.putExtra("KPickPoiLat", paramDouble1);
        paramIntent.putExtra("KPickPoiLong", paramDouble2);
        startActivityForResult(paramIntent, 6);
      }
      AppMethodBeat.o(55878);
      return;
    }
    finish();
    AppMethodBeat.o(55878);
  }
  
  private Intent edk()
  {
    AppMethodBeat.i(55877);
    Intent localIntent2 = com.tencent.mm.plugin.location.ui.impl.d.ar(this);
    localIntent2.putExtra("type_tag", getIntent().getIntExtra("type_tag", 0));
    Intent localIntent1;
    switch (this.type)
    {
    case 4: 
    case 5: 
    default: 
      Log.d("MicroMsg.RedirectUI", "view type error");
      localIntent1 = null;
    }
    for (;;)
    {
      AppMethodBeat.o(55877);
      return localIntent1;
      String str = getIntent().getStringExtra("fromWhereShare");
      Log.d("MicroMsg.RedirectUI", "location resume");
      localIntent2.putExtra("intent_map_key", 5);
      localIntent1 = localIntent2;
      if (!Util.isNullOrNil(str))
      {
        localIntent2.putExtra("fromWhereShare", str);
        localIntent1 = localIntent2;
        continue;
        Log.d("MicroMsg.RedirectUI", "view normal");
        localIntent2.putExtra("intent_map_key", 4);
        localIntent1 = localIntent2;
        continue;
        localIntent2.putExtra("intent_map_key", 4);
        localIntent1 = localIntent2;
        continue;
        Log.d("MicroMsg.RedirectUI", "view poi isHidePoiOversea : " + com.tencent.mm.n.h.aqK().aqx());
        localIntent2.putExtra("intent_map_key", 2);
        localIntent1 = localIntent2;
      }
    }
  }
  
  private void k(final double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(55876);
    this.isStart = true;
    final Intent localIntent = edk();
    switch (this.type)
    {
    }
    while (ac.jNZ)
    {
      this.handler.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(55873);
          RedirectUI.a(RedirectUI.this, localIntent, paramDouble1, this.tgB);
          AppMethodBeat.o(55873);
        }
      }, 2000L);
      AppMethodBeat.o(55876);
      return;
      localIntent.putExtra("location_scene", 1);
    }
    a(localIntent, paramDouble1, paramDouble2);
    AppMethodBeat.o(55876);
  }
  
  public void finish()
  {
    AppMethodBeat.i(55881);
    super.finish();
    AppMethodBeat.o(55881);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(55879);
    Log.i("MicroMsg.RedirectUI", "onAcvityResult requestCode:".concat(String.valueOf(paramInt1)));
    if (paramInt2 != -1)
    {
      finish();
      AppMethodBeat.o(55879);
      return;
    }
    if (paramIntent == null)
    {
      finish();
      AppMethodBeat.o(55879);
      return;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      setResult(paramInt2, paramIntent);
      finish();
      AppMethodBeat.o(55879);
      return;
      String str1 = this.haD;
      LocationIntent localLocationIntent = (LocationIntent)paramIntent.getParcelableExtra("KLocationIntent");
      Log.i("MicroMsg.RedirectUI", "locationintent " + localLocationIntent.aBz());
      Object localObject1 = new pz();
      ((pz)localObject1).dWg.cSx = this.yIx;
      ((pz)localObject1).dWg.lat = localLocationIntent.lat;
      ((pz)localObject1).dWg.lng = localLocationIntent.lng;
      ((pz)localObject1).dWg.dRt = localLocationIntent.dRt;
      ((pz)localObject1).dWg.label = localLocationIntent.label;
      ((pz)localObject1).dWg.dWi = localLocationIntent.kHV;
      EventCenter.instance.publish((IEvent)localObject1);
      double d1 = localLocationIntent.lat;
      double d2 = localLocationIntent.lng;
      paramInt1 = localLocationIntent.dRt;
      String str2 = localLocationIntent.label;
      Object localObject2 = localLocationIntent.kHV;
      String str3 = localLocationIntent.JTr;
      String str4 = localLocationIntent.yFB;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localObject1 = "<msg><location x=\"" + d1 + "\" y=\"" + d2 + "\" scale=\"" + paramInt1 + "\" label=\"" + Util.escapeStringForXml(str2) + "\" poiname=\"" + Util.escapeStringForXml((String)localObject1) + "\" infourl=\"" + Util.escapeStringForXml(str3) + "\" maptype=\"0\" poiid=\"" + str4 + "\" /></msg>";
      Log.d("MicroMsg.RedirectUI", "xml ".concat(String.valueOf(localObject1)));
      localObject2 = new tw();
      ((tw)localObject2).eaq.dkV = str1;
      ((tw)localObject2).eaq.content = ((String)localObject1);
      ((tw)localObject2).eaq.type = 48;
      ((tw)localObject2).eaq.flags = 0;
      EventCenter.instance.publish((IEvent)localObject2);
      o.a(2004, (float)localLocationIntent.lng, (float)localLocationIntent.lat, 0);
      continue;
      localObject1 = (LocationIntent)paramIntent.getParcelableExtra("KLocationIntent");
      Log.i("MicroMsg.RedirectUI", "locationintent " + ((LocationIntent)localObject1).aBz());
      if (((LocationIntent)localObject1).JTs == 3)
      {
        com.tencent.mm.plugin.report.service.h.CyF.a(10822, new Object[] { Integer.valueOf(1), ((LocationIntent)localObject1).yFz, Integer.valueOf(1) });
        label582:
        paramIntent.putExtra("kwebmap_slat", ((LocationIntent)localObject1).lat);
        paramIntent.putExtra("kwebmap_lng", ((LocationIntent)localObject1).lng);
        paramIntent.putExtra("kwebmap_scale", ((LocationIntent)localObject1).dRt);
        paramIntent.putExtra("Kwebmap_locaion", ((LocationIntent)localObject1).label);
        paramIntent.putExtra("kTags", paramIntent.getStringArrayListExtra("kTags"));
        if (!((LocationIntent)localObject1).kHV.equals("")) {
          break label710;
        }
      }
      label710:
      for (localObject1 = "";; localObject1 = ((LocationIntent)localObject1).kHV)
      {
        paramIntent.putExtra("kPoiName", (String)localObject1);
        break;
        com.tencent.mm.plugin.report.service.h.CyF.a(10822, new Object[] { Integer.valueOf(1), ((LocationIntent)localObject1).yFz, Integer.valueOf(0) });
        break label582;
      }
      localObject1 = (LocationIntent)paramIntent.getParcelableExtra("KLocationIntent");
      Log.i("MicroMsg.RedirectUI", "locationintent " + ((LocationIntent)localObject1).aBz());
      if (((LocationIntent)localObject1).iVi != null) {
        Log.d("MicroMsg.RedirectUI", "addr: " + ((LocationIntent)localObject1).iVi.toString());
      }
      paramIntent.putExtra("key_pick_addr", ((LocationIntent)localObject1).iVi);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(55875);
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 21)
    {
      getWindow().addFlags(-2147483648);
      getWindow().setStatusBarColor(0);
    }
    int i;
    if (Util.secondsToNow(Util.nullAsNil((Long)g.aAh().azQ().get(81938, null))) * 1000L > gmF)
    {
      i = 1;
      if (i != 0) {
        c.beo().update();
      }
      this.type = getIntent().getIntExtra("map_view_type", -1);
      if (this.type == -1) {
        finish();
      }
      this.msgId = getIntent().getLongExtra("kMsgId", -1L);
      this.haD = getIntent().getStringExtra("map_talker_name");
      Log.d("MicroMsg.RedirectUI", "tofutest type: %s", new Object[] { Integer.valueOf(this.type) });
      switch (this.type)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(55875);
      return;
      i = 0;
      break;
      paramBundle = n.ecS().aCZ(this.haD);
      StringBuilder localStringBuilder = new StringBuilder("resume try to enter trackRoom ");
      if (paramBundle != null) {}
      for (boolean bool = true;; bool = false)
      {
        Log.i("MicroMsg.RedirectUI", bool);
        if (paramBundle == null) {
          break;
        }
        this.yFu = paramBundle.latitude;
        this.yFv = paramBundle.longitude;
        this.info = paramBundle.yFq;
        Log.i("MicroMsg.RedirectUI", "resume lat %f lng %f %s member size %d", new Object[] { Double.valueOf(this.yFu), Double.valueOf(this.yFv), this.info, Integer.valueOf(paramBundle.dTe.size()) });
        this.yFw = 0;
        k(this.yFu, this.yFv);
        AppMethodBeat.o(55875);
        return;
      }
      k(-1000.0D, -1000.0D);
      AppMethodBeat.o(55875);
      return;
      this.yFu = getIntent().getDoubleExtra("kwebmap_slat", -85.0D);
      this.yFv = getIntent().getDoubleExtra("kwebmap_lng", -1000.0D);
      this.yFw = getIntent().getIntExtra("kwebmap_scale", 0);
      this.info = getIntent().getStringExtra("Kwebmap_locaion");
      k(this.yFu, this.yFv);
      AppMethodBeat.o(55875);
      return;
      this.yIw = getIntent().getStringExtra("map_sender_name");
      this.qcr = getIntent().getIntExtra("view_type_key", 1);
      this.yIx = getIntent().getIntExtra("key_get_location_type", 0);
      this.yFu = getIntent().getDoubleExtra("KPickPoiLat", -85.0D);
      this.yFv = getIntent().getDoubleExtra("KPickPoiLong", -85.0D);
      k(this.yFu, this.yFv);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(55880);
    this.yHD = false;
    super.onDestroy();
    AppMethodBeat.o(55880);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.RedirectUI
 * JD-Core Version:    0.7.0.1
 */