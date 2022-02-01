package com.tencent.mm.plugin.location.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ph;
import com.tencent.mm.g.a.sy;
import com.tencent.mm.g.a.wr;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.kernel.e;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.location.model.n;
import com.tencent.mm.plugin.location.model.r;
import com.tencent.mm.pluginsdk.location.LocationIntent;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import java.util.LinkedList;

@com.tencent.mm.ui.base.a(23)
public class RedirectUI
  extends HellActivity
{
  private static long fHu = 86400000L;
  private String gpK;
  private final aq handler;
  private String info;
  private boolean isStart;
  private long msgId;
  private int oOD;
  private int type;
  private double vlC;
  private double vlD;
  private int vlE;
  private boolean vnM;
  private String voG;
  private int voH;
  private final int voI;
  private boolean voJ;
  private final int voK;
  private final int voL;
  private final int voM;
  private final int voN;
  
  public RedirectUI()
  {
    AppMethodBeat.i(55874);
    this.type = 0;
    this.isStart = false;
    this.vnM = true;
    this.vlC = 0.0D;
    this.vlD = 0.0D;
    this.voG = "";
    this.gpK = "";
    this.vlE = 0;
    this.info = "";
    this.handler = new aq();
    this.voI = 1;
    this.voJ = false;
    this.voK = 0;
    this.voL = 1;
    this.voM = 0;
    this.voN = 1;
    AppMethodBeat.o(55874);
  }
  
  private void a(Intent paramIntent, double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(55878);
    if (paramIntent != null)
    {
      paramIntent.putExtra("kShowshare", getIntent().getBooleanExtra("kShowshare", true));
      paramIntent.putExtra("kimg_path", com.tencent.mm.plugin.image.d.azQ());
      paramIntent.putExtra("kPoi_url", bu.bI(getIntent().getStringExtra("kPoi_url"), ""));
      paramIntent.putExtra("map_view_type", getIntent().getIntExtra("map_view_type", 0));
      paramIntent.putExtra("kFavInfoLocalId", getIntent().getLongExtra("kFavInfoLocalId", -1L));
      paramIntent.putExtra("kFavCanDel", getIntent().getBooleanExtra("kFavCanDel", true));
      paramIntent.putExtra("kFavCanRemark", getIntent().getBooleanExtra("kFavCanRemark", true));
      paramIntent.putExtra("kwebmap_slat", paramDouble1);
      paramIntent.putExtra("kwebmap_lng", paramDouble2);
      paramIntent.putExtra("kPoiid", getIntent().getStringExtra("kPoiid"));
      paramIntent.putExtra("kPoiName", getIntent().getStringExtra("kPoiName"));
      paramIntent.putExtra("kisUsername", bu.bI(getIntent().getStringExtra("kisUsername"), ""));
      paramIntent.putExtra("map_talker_name", this.gpK);
      paramIntent.putExtra("kIs_pick_poi", getIntent().getBooleanExtra("kIs_pick_poi", false));
      paramIntent.putExtra("KFavLocSigleView", getIntent().getBooleanExtra("KFavLocSigleView", false));
      wr localwr = new wr();
      localwr.dMh.dMi = true;
      com.tencent.mm.sdk.b.a.IvT.l(localwr);
      if (this.type == 6)
      {
        paramIntent.putExtra("kMsgId", getIntent().getLongExtra("kMsgId", -1L));
        paramIntent.putExtra("kRemark", getIntent().getStringExtra("kRemark"));
        if (this.vlE > 0) {
          paramIntent.putExtra("kwebmap_scale", this.vlE);
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
        if (this.vlE > 0) {
          paramIntent.putExtra("kwebmap_scale", this.vlE);
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
  
  private Intent djz()
  {
    AppMethodBeat.i(55877);
    Intent localIntent2 = com.tencent.mm.plugin.location.ui.impl.d.as(this);
    localIntent2.putExtra("type_tag", getIntent().getIntExtra("type_tag", 0));
    Intent localIntent1;
    switch (this.type)
    {
    case 4: 
    case 5: 
    default: 
      ae.d("MicroMsg.RedirectUI", "view type error");
      localIntent1 = null;
    }
    for (;;)
    {
      AppMethodBeat.o(55877);
      return localIntent1;
      String str = getIntent().getStringExtra("fromWhereShare");
      ae.d("MicroMsg.RedirectUI", "location resume");
      localIntent2.putExtra("intent_map_key", 5);
      localIntent1 = localIntent2;
      if (!bu.isNullOrNil(str))
      {
        localIntent2.putExtra("fromWhereShare", str);
        localIntent1 = localIntent2;
        continue;
        ae.d("MicroMsg.RedirectUI", "view normal");
        localIntent2.putExtra("intent_map_key", 4);
        localIntent1 = localIntent2;
        continue;
        localIntent2.putExtra("intent_map_key", 4);
        localIntent1 = localIntent2;
        continue;
        ae.d("MicroMsg.RedirectUI", "view poi isHidePoiOversea : " + com.tencent.mm.n.g.acM().acy());
        localIntent2.putExtra("intent_map_key", 2);
        localIntent1 = localIntent2;
      }
    }
  }
  
  private void k(final double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(55876);
    this.isStart = true;
    final Intent localIntent = djz();
    switch (this.type)
    {
    }
    while (ac.iRf)
    {
      this.handler.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(55873);
          RedirectUI.a(RedirectUI.this, localIntent, paramDouble1, this.rGU);
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
    ae.i("MicroMsg.RedirectUI", "onAcvityResult requestCode:".concat(String.valueOf(paramInt1)));
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
      String str1 = this.gpK;
      LocationIntent localLocationIntent = (LocationIntent)paramIntent.getParcelableExtra("KLocationIntent");
      ae.i("MicroMsg.RedirectUI", "locationintent " + localLocationIntent.alg());
      Object localObject1 = new ph();
      ((ph)localObject1).dEs.dEu = this.voH;
      ((ph)localObject1).dEs.lat = localLocationIntent.lat;
      ((ph)localObject1).dEs.lng = localLocationIntent.lng;
      ((ph)localObject1).dEs.dzG = localLocationIntent.dzG;
      ((ph)localObject1).dEs.label = localLocationIntent.label;
      ((ph)localObject1).dEs.dEv = localLocationIntent.jGd;
      com.tencent.mm.sdk.b.a.IvT.l((b)localObject1);
      double d1 = localLocationIntent.lat;
      double d2 = localLocationIntent.lng;
      paramInt1 = localLocationIntent.dzG;
      String str2 = localLocationIntent.label;
      Object localObject2 = localLocationIntent.jGd;
      String str3 = localLocationIntent.Fcs;
      String str4 = localLocationIntent.vlJ;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localObject1 = "<msg><location x=\"" + d1 + "\" y=\"" + d2 + "\" scale=\"" + paramInt1 + "\" label=\"" + bu.aSz(str2) + "\" poiname=\"" + bu.aSz((String)localObject1) + "\" infourl=\"" + bu.aSz(str3) + "\" maptype=\"0\" poiid=\"" + str4 + "\" /></msg>";
      ae.d("MicroMsg.RedirectUI", "xml ".concat(String.valueOf(localObject1)));
      localObject2 = new sy();
      ((sy)localObject2).dID.cUB = str1;
      ((sy)localObject2).dID.content = ((String)localObject1);
      ((sy)localObject2).dID.type = 48;
      ((sy)localObject2).dID.flags = 0;
      com.tencent.mm.sdk.b.a.IvT.l((b)localObject2);
      o.a(2004, (float)localLocationIntent.lng, (float)localLocationIntent.lat, 0);
      continue;
      localObject1 = (LocationIntent)paramIntent.getParcelableExtra("KLocationIntent");
      ae.i("MicroMsg.RedirectUI", "locationintent " + ((LocationIntent)localObject1).alg());
      if (((LocationIntent)localObject1).Fct == 3)
      {
        com.tencent.mm.plugin.report.service.g.yxI.f(10822, new Object[] { Integer.valueOf(1), ((LocationIntent)localObject1).vlH, Integer.valueOf(1) });
        label582:
        paramIntent.putExtra("kwebmap_slat", ((LocationIntent)localObject1).lat);
        paramIntent.putExtra("kwebmap_lng", ((LocationIntent)localObject1).lng);
        paramIntent.putExtra("kwebmap_scale", ((LocationIntent)localObject1).dzG);
        paramIntent.putExtra("Kwebmap_locaion", ((LocationIntent)localObject1).label);
        paramIntent.putExtra("kTags", paramIntent.getStringArrayListExtra("kTags"));
        if (!((LocationIntent)localObject1).jGd.equals("")) {
          break label710;
        }
      }
      label710:
      for (localObject1 = "";; localObject1 = ((LocationIntent)localObject1).jGd)
      {
        paramIntent.putExtra("kPoiName", (String)localObject1);
        break;
        com.tencent.mm.plugin.report.service.g.yxI.f(10822, new Object[] { Integer.valueOf(1), ((LocationIntent)localObject1).vlH, Integer.valueOf(0) });
        break label582;
      }
      localObject1 = (LocationIntent)paramIntent.getParcelableExtra("KLocationIntent");
      ae.i("MicroMsg.RedirectUI", "locationintent " + ((LocationIntent)localObject1).alg());
      if (((LocationIntent)localObject1).iak != null) {
        ae.d("MicroMsg.RedirectUI", "addr: " + ((LocationIntent)localObject1).iak.toString());
      }
      paramIntent.putExtra("key_pick_addr", ((LocationIntent)localObject1).iak);
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
    if (bu.rZ(bu.i((Long)com.tencent.mm.kernel.g.ajR().ajA().get(81938, null))) * 1000L > fHu)
    {
      i = 1;
      if (i != 0) {
        com.tencent.mm.bb.c.aKl().update();
      }
      this.type = getIntent().getIntExtra("map_view_type", -1);
      if (this.type == -1) {
        finish();
      }
      this.msgId = getIntent().getLongExtra("kMsgId", -1L);
      this.gpK = getIntent().getStringExtra("map_talker_name");
      ae.d("MicroMsg.RedirectUI", "tofutest type: %s", new Object[] { Integer.valueOf(this.type) });
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
      paramBundle = n.djh().apG(this.gpK);
      StringBuilder localStringBuilder = new StringBuilder("resume try to enter trackRoom ");
      if (paramBundle != null) {}
      for (boolean bool = true;; bool = false)
      {
        ae.i("MicroMsg.RedirectUI", bool);
        if (paramBundle == null) {
          break;
        }
        this.vlC = paramBundle.latitude;
        this.vlD = paramBundle.longitude;
        this.info = paramBundle.vly;
        ae.i("MicroMsg.RedirectUI", "resume lat %f lng %f %s member size %d", new Object[] { Double.valueOf(this.vlC), Double.valueOf(this.vlD), this.info, Integer.valueOf(paramBundle.dBp.size()) });
        this.vlE = 0;
        k(this.vlC, this.vlD);
        AppMethodBeat.o(55875);
        return;
      }
      k(-1000.0D, -1000.0D);
      AppMethodBeat.o(55875);
      return;
      this.vlC = getIntent().getDoubleExtra("kwebmap_slat", -85.0D);
      this.vlD = getIntent().getDoubleExtra("kwebmap_lng", -1000.0D);
      this.vlE = getIntent().getIntExtra("kwebmap_scale", 0);
      this.info = getIntent().getStringExtra("Kwebmap_locaion");
      k(this.vlC, this.vlD);
      AppMethodBeat.o(55875);
      return;
      this.voG = getIntent().getStringExtra("map_sender_name");
      this.oOD = getIntent().getIntExtra("view_type_key", 1);
      this.voH = getIntent().getIntExtra("key_get_location_type", 0);
      this.vlC = getIntent().getDoubleExtra("KPickPoiLat", -85.0D);
      this.vlD = getIntent().getDoubleExtra("KPickPoiLong", -85.0D);
      k(this.vlC, this.vlD);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(55880);
    this.vnM = false;
    super.onDestroy();
    AppMethodBeat.o(55880);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.RedirectUI
 * JD-Core Version:    0.7.0.1
 */