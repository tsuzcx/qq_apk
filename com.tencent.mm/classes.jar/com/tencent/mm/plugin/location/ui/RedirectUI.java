package com.tencent.mm.plugin.location.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.be.c;
import com.tencent.mm.f.a.qx;
import com.tencent.mm.f.a.uz;
import com.tencent.mm.f.a.yy;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.kernel.f;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.platformtools.ac;
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
  private static long iQO = 86400000L;
  private double Ejn;
  private double Ejo;
  private int Ejp;
  private boolean Elw;
  private String Emp;
  private int Emq;
  private final int Emr;
  private boolean Ems;
  private final int Emt;
  private final int Emu;
  private final int Emv;
  private final int Emw;
  private String fTp;
  private final MMHandler handler;
  private boolean isStart;
  private String jLI;
  private long msgId;
  private int type;
  private int viewType;
  
  public RedirectUI()
  {
    AppMethodBeat.i(55874);
    this.type = 0;
    this.isStart = false;
    this.Elw = true;
    this.Ejn = 0.0D;
    this.Ejo = 0.0D;
    this.Emp = "";
    this.jLI = "";
    this.Ejp = 0;
    this.fTp = "";
    this.handler = new MMHandler();
    this.Emr = 1;
    this.Ems = false;
    this.Emt = 0;
    this.Emu = 1;
    this.Emv = 0;
    this.Emw = 1;
    AppMethodBeat.o(55874);
  }
  
  private void a(Intent paramIntent, double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(55878);
    if (paramIntent != null)
    {
      paramIntent.putExtra("kShowshare", getIntent().getBooleanExtra("kShowshare", true));
      paramIntent.putExtra("kimg_path", com.tencent.mm.plugin.image.d.bbW());
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
      paramIntent.putExtra("map_talker_name", this.jLI);
      paramIntent.putExtra("kIs_pick_poi", getIntent().getBooleanExtra("kIs_pick_poi", false));
      paramIntent.putExtra("KFavLocSigleView", getIntent().getBooleanExtra("KFavLocSigleView", false));
      yy localyy = new yy();
      localyy.fYl.fYm = true;
      EventCenter.instance.publish(localyy);
      if (this.type == 6)
      {
        paramIntent.putExtra("kMsgId", getIntent().getLongExtra("kMsgId", -1L));
        paramIntent.putExtra("kRemark", getIntent().getStringExtra("kRemark"));
        if (this.Ejp > 0) {
          paramIntent.putExtra("kwebmap_scale", this.Ejp);
        }
        paramIntent.putExtra("Kwebmap_locaion", this.fTp);
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
        if (this.Ejp > 0) {
          paramIntent.putExtra("kwebmap_scale", this.Ejp);
        }
        paramIntent.putExtra("Kwebmap_locaion", this.fTp);
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
  
  private Intent eMD()
  {
    AppMethodBeat.i(55877);
    Intent localIntent2 = com.tencent.mm.plugin.location.ui.impl.d.ax(this);
    localIntent2.putExtra("type_tag", getIntent().getIntExtra("type_tag", 0));
    localIntent2.putExtra("key_geo_coder_four_level", getIntent().getBooleanExtra("key_geo_coder_four_level", false));
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
        Log.d("MicroMsg.RedirectUI", "view poi isHidePoiOversea : " + com.tencent.mm.n.h.axd().awR());
        localIntent2.putExtra("intent_map_key", 2);
        localIntent1 = localIntent2;
      }
    }
  }
  
  private void j(final double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(55876);
    this.isStart = true;
    final Intent localIntent = eMD();
    switch (this.type)
    {
    }
    while (ac.mFi)
    {
      this.handler.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(55873);
          RedirectUI.a(RedirectUI.this, localIntent, paramDouble1, this.wMR);
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
      String str1 = this.jLI;
      LocationIntent localLocationIntent = (LocationIntent)paramIntent.getParcelableExtra("KLocationIntent");
      Log.i("MicroMsg.RedirectUI", "locationintent " + localLocationIntent.aJc());
      Object localObject1 = new qx();
      ((qx)localObject1).fPL.cUP = this.Emq;
      ((qx)localObject1).fPL.lat = localLocationIntent.lat;
      ((qx)localObject1).fPL.lng = localLocationIntent.lng;
      ((qx)localObject1).fPL.fKJ = localLocationIntent.fKJ;
      ((qx)localObject1).fPL.label = localLocationIntent.label;
      ((qx)localObject1).fPL.fPN = localLocationIntent.poiName;
      EventCenter.instance.publish((IEvent)localObject1);
      double d1 = localLocationIntent.lat;
      double d2 = localLocationIntent.lng;
      paramInt1 = localLocationIntent.fKJ;
      String str2 = localLocationIntent.label;
      Object localObject2 = localLocationIntent.poiName;
      String str3 = localLocationIntent.QSw;
      String str4 = localLocationIntent.Eju;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localObject1 = "<msg><location x=\"" + d1 + "\" y=\"" + d2 + "\" scale=\"" + paramInt1 + "\" label=\"" + Util.escapeStringForXml(str2) + "\" poiname=\"" + Util.escapeStringForXml((String)localObject1) + "\" infourl=\"" + Util.escapeStringForXml(str3) + "\" maptype=\"0\" poiid=\"" + str4 + "\" /></msg>";
      Log.d("MicroMsg.RedirectUI", "xml ".concat(String.valueOf(localObject1)));
      localObject2 = new uz();
      ((uz)localObject2).fUn.fcD = str1;
      ((uz)localObject2).fUn.content = ((String)localObject1);
      ((uz)localObject2).fUn.type = 48;
      ((uz)localObject2).fUn.flags = 0;
      EventCenter.instance.publish((IEvent)localObject2);
      com.tencent.mm.modelstat.n.a(2004, (float)localLocationIntent.lng, (float)localLocationIntent.lat, 0);
      continue;
      localObject1 = (LocationIntent)paramIntent.getParcelableExtra("KLocationIntent");
      Log.i("MicroMsg.RedirectUI", "locationintent " + ((LocationIntent)localObject1).aJc());
      if (((LocationIntent)localObject1).QSx == 3)
      {
        com.tencent.mm.plugin.report.service.h.IzE.a(10822, new Object[] { Integer.valueOf(1), ((LocationIntent)localObject1).Ejs, Integer.valueOf(1) });
        label582:
        paramIntent.putExtra("kwebmap_slat", ((LocationIntent)localObject1).lat);
        paramIntent.putExtra("kwebmap_lng", ((LocationIntent)localObject1).lng);
        paramIntent.putExtra("kwebmap_scale", ((LocationIntent)localObject1).fKJ);
        paramIntent.putExtra("Kwebmap_locaion", ((LocationIntent)localObject1).label);
        paramIntent.putExtra("kTags", paramIntent.getStringArrayListExtra("kTags"));
        if (!((LocationIntent)localObject1).poiName.equals("")) {
          break label710;
        }
      }
      label710:
      for (localObject1 = "";; localObject1 = ((LocationIntent)localObject1).poiName)
      {
        paramIntent.putExtra("kPoiName", (String)localObject1);
        break;
        com.tencent.mm.plugin.report.service.h.IzE.a(10822, new Object[] { Integer.valueOf(1), ((LocationIntent)localObject1).Ejs, Integer.valueOf(0) });
        break label582;
      }
      localObject1 = (LocationIntent)paramIntent.getParcelableExtra("KLocationIntent");
      Log.i("MicroMsg.RedirectUI", "locationintent " + ((LocationIntent)localObject1).aJc());
      if (((LocationIntent)localObject1).lLB != null) {
        Log.d("MicroMsg.RedirectUI", "addr: " + ((LocationIntent)localObject1).lLB.toString());
      }
      paramIntent.putExtra("key_pick_addr", ((LocationIntent)localObject1).lLB);
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
    if (Util.secondsToNow(Util.nullAsNil((Long)com.tencent.mm.kernel.h.aHG().aHp().b(81938, null))) * 1000L > iQO)
    {
      i = 1;
      if (i != 0) {
        c.bnM().update();
      }
      this.type = getIntent().getIntExtra("map_view_type", -1);
      if (this.type == -1) {
        finish();
      }
      this.msgId = getIntent().getLongExtra("kMsgId", -1L);
      this.jLI = getIntent().getStringExtra("map_talker_name");
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
      paramBundle = com.tencent.mm.plugin.location.model.n.eMk().aNj(this.jLI);
      StringBuilder localStringBuilder = new StringBuilder("resume try to enter trackRoom ");
      if (paramBundle != null) {}
      for (boolean bool = true;; bool = false)
      {
        Log.i("MicroMsg.RedirectUI", bool);
        if (paramBundle == null) {
          break;
        }
        this.Ejn = paramBundle.latitude;
        this.Ejo = paramBundle.longitude;
        this.fTp = paramBundle.Ejj;
        Log.i("MicroMsg.RedirectUI", "resume lat %f lng %f %s member size %d", new Object[] { Double.valueOf(this.Ejn), Double.valueOf(this.Ejo), this.fTp, Integer.valueOf(paramBundle.fMA.size()) });
        this.Ejp = 0;
        j(this.Ejn, this.Ejo);
        AppMethodBeat.o(55875);
        return;
      }
      j(-1000.0D, -1000.0D);
      AppMethodBeat.o(55875);
      return;
      this.Ejn = getIntent().getDoubleExtra("kwebmap_slat", -85.0D);
      this.Ejo = getIntent().getDoubleExtra("kwebmap_lng", -1000.0D);
      this.Ejp = getIntent().getIntExtra("kwebmap_scale", 0);
      this.fTp = getIntent().getStringExtra("Kwebmap_locaion");
      j(this.Ejn, this.Ejo);
      AppMethodBeat.o(55875);
      return;
      this.Emp = getIntent().getStringExtra("map_sender_name");
      this.viewType = getIntent().getIntExtra("view_type_key", 1);
      this.Emq = getIntent().getIntExtra("key_get_location_type", 0);
      this.Ejn = getIntent().getDoubleExtra("KPickPoiLat", -85.0D);
      this.Ejo = getIntent().getDoubleExtra("KPickPoiLong", -85.0D);
      j(this.Ejn, this.Ejo);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(55880);
    this.Elw = false;
    super.onDestroy();
    AppMethodBeat.o(55880);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.RedirectUI
 * JD-Core Version:    0.7.0.1
 */