package com.tencent.mm.plugin.location.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.pg;
import com.tencent.mm.g.a.sx;
import com.tencent.mm.g.a.wn;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.kernel.e;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.location.model.n;
import com.tencent.mm.plugin.location.model.r;
import com.tencent.mm.pluginsdk.location.LocationIntent;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import java.util.LinkedList;

@com.tencent.mm.ui.base.a(23)
public class RedirectUI
  extends HellActivity
{
  private static long fFq = 86400000L;
  private String gno;
  private final ap handler;
  private String info;
  private boolean isStart;
  private long msgId;
  private int oIb;
  private int type;
  private double uZr;
  private double uZs;
  private int uZt;
  private boolean vbB;
  private final int vcA;
  private final int vcB;
  private final int vcC;
  private String vcv;
  private int vcw;
  private final int vcx;
  private boolean vcy;
  private final int vcz;
  
  public RedirectUI()
  {
    AppMethodBeat.i(55874);
    this.type = 0;
    this.isStart = false;
    this.vbB = true;
    this.uZr = 0.0D;
    this.uZs = 0.0D;
    this.vcv = "";
    this.gno = "";
    this.uZt = 0;
    this.info = "";
    this.handler = new ap();
    this.vcx = 1;
    this.vcy = false;
    this.vcz = 0;
    this.vcA = 1;
    this.vcB = 0;
    this.vcC = 1;
    AppMethodBeat.o(55874);
  }
  
  private void a(Intent paramIntent, double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(55878);
    if (paramIntent != null)
    {
      paramIntent.putExtra("kShowshare", getIntent().getBooleanExtra("kShowshare", true));
      paramIntent.putExtra("kimg_path", com.tencent.mm.plugin.image.d.azA());
      paramIntent.putExtra("kPoi_url", bt.bI(getIntent().getStringExtra("kPoi_url"), ""));
      paramIntent.putExtra("map_view_type", getIntent().getIntExtra("map_view_type", 0));
      paramIntent.putExtra("kFavInfoLocalId", getIntent().getLongExtra("kFavInfoLocalId", -1L));
      paramIntent.putExtra("kFavCanDel", getIntent().getBooleanExtra("kFavCanDel", true));
      paramIntent.putExtra("kFavCanRemark", getIntent().getBooleanExtra("kFavCanRemark", true));
      paramIntent.putExtra("kwebmap_slat", paramDouble1);
      paramIntent.putExtra("kwebmap_lng", paramDouble2);
      paramIntent.putExtra("kPoiid", getIntent().getStringExtra("kPoiid"));
      paramIntent.putExtra("kPoiName", getIntent().getStringExtra("kPoiName"));
      paramIntent.putExtra("kisUsername", bt.bI(getIntent().getStringExtra("kisUsername"), ""));
      paramIntent.putExtra("map_talker_name", this.gno);
      paramIntent.putExtra("kIs_pick_poi", getIntent().getBooleanExtra("kIs_pick_poi", false));
      paramIntent.putExtra("KFavLocSigleView", getIntent().getBooleanExtra("KFavLocSigleView", false));
      wn localwn = new wn();
      localwn.dKS.dKT = true;
      com.tencent.mm.sdk.b.a.IbL.l(localwn);
      if (this.type == 6)
      {
        paramIntent.putExtra("kMsgId", getIntent().getLongExtra("kMsgId", -1L));
        paramIntent.putExtra("kRemark", getIntent().getStringExtra("kRemark"));
        if (this.uZt > 0) {
          paramIntent.putExtra("kwebmap_scale", this.uZt);
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
        if (this.uZt > 0) {
          paramIntent.putExtra("kwebmap_scale", this.uZt);
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
  
  private Intent dgA()
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
      ad.d("MicroMsg.RedirectUI", "view type error");
      localIntent1 = null;
    }
    for (;;)
    {
      AppMethodBeat.o(55877);
      return localIntent1;
      String str = getIntent().getStringExtra("fromWhereShare");
      ad.d("MicroMsg.RedirectUI", "location resume");
      localIntent2.putExtra("intent_map_key", 5);
      localIntent1 = localIntent2;
      if (!bt.isNullOrNil(str))
      {
        localIntent2.putExtra("fromWhereShare", str);
        localIntent1 = localIntent2;
        continue;
        ad.d("MicroMsg.RedirectUI", "view normal");
        localIntent2.putExtra("intent_map_key", 4);
        localIntent1 = localIntent2;
        continue;
        localIntent2.putExtra("intent_map_key", 4);
        localIntent1 = localIntent2;
        continue;
        ad.d("MicroMsg.RedirectUI", "view poi isHidePoiOversea : " + com.tencent.mm.n.g.acB().acn());
        localIntent2.putExtra("intent_map_key", 2);
        localIntent1 = localIntent2;
      }
    }
  }
  
  private void k(final double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(55876);
    this.isStart = true;
    final Intent localIntent = dgA();
    switch (this.type)
    {
    }
    while (ac.iOl)
    {
      this.handler.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(55873);
          RedirectUI.a(RedirectUI.this, localIntent, paramDouble1, this.ryJ);
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
    ad.i("MicroMsg.RedirectUI", "onAcvityResult requestCode:".concat(String.valueOf(paramInt1)));
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
      String str1 = this.gno;
      LocationIntent localLocationIntent = (LocationIntent)paramIntent.getParcelableExtra("KLocationIntent");
      ad.i("MicroMsg.RedirectUI", "locationintent " + localLocationIntent.akR());
      Object localObject1 = new pg();
      ((pg)localObject1).dDn.dDp = this.vcw;
      ((pg)localObject1).dDn.lat = localLocationIntent.lat;
      ((pg)localObject1).dDn.lng = localLocationIntent.lng;
      ((pg)localObject1).dDn.dyB = localLocationIntent.dyB;
      ((pg)localObject1).dDn.label = localLocationIntent.label;
      ((pg)localObject1).dDn.dDq = localLocationIntent.jDf;
      com.tencent.mm.sdk.b.a.IbL.l((b)localObject1);
      double d1 = localLocationIntent.lat;
      double d2 = localLocationIntent.lng;
      paramInt1 = localLocationIntent.dyB;
      String str2 = localLocationIntent.label;
      Object localObject2 = localLocationIntent.jDf;
      String str3 = localLocationIntent.EJU;
      String str4 = localLocationIntent.uZy;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localObject1 = "<msg><location x=\"" + d1 + "\" y=\"" + d2 + "\" scale=\"" + paramInt1 + "\" label=\"" + bt.aRc(str2) + "\" poiname=\"" + bt.aRc((String)localObject1) + "\" infourl=\"" + bt.aRc(str3) + "\" maptype=\"0\" poiid=\"" + str4 + "\" /></msg>";
      ad.d("MicroMsg.RedirectUI", "xml ".concat(String.valueOf(localObject1)));
      localObject2 = new sx();
      ((sx)localObject2).dHy.dHz = str1;
      ((sx)localObject2).dHy.content = ((String)localObject1);
      ((sx)localObject2).dHy.type = 48;
      ((sx)localObject2).dHy.flags = 0;
      com.tencent.mm.sdk.b.a.IbL.l((b)localObject2);
      o.a(2004, (float)localLocationIntent.lng, (float)localLocationIntent.lat, 0);
      continue;
      localObject1 = (LocationIntent)paramIntent.getParcelableExtra("KLocationIntent");
      ad.i("MicroMsg.RedirectUI", "locationintent " + ((LocationIntent)localObject1).akR());
      if (((LocationIntent)localObject1).EJV == 3)
      {
        com.tencent.mm.plugin.report.service.g.yhR.f(10822, new Object[] { Integer.valueOf(1), ((LocationIntent)localObject1).uZw, Integer.valueOf(1) });
        label582:
        paramIntent.putExtra("kwebmap_slat", ((LocationIntent)localObject1).lat);
        paramIntent.putExtra("kwebmap_lng", ((LocationIntent)localObject1).lng);
        paramIntent.putExtra("kwebmap_scale", ((LocationIntent)localObject1).dyB);
        paramIntent.putExtra("Kwebmap_locaion", ((LocationIntent)localObject1).label);
        paramIntent.putExtra("kTags", paramIntent.getStringArrayListExtra("kTags"));
        if (!((LocationIntent)localObject1).jDf.equals("")) {
          break label710;
        }
      }
      label710:
      for (localObject1 = "";; localObject1 = ((LocationIntent)localObject1).jDf)
      {
        paramIntent.putExtra("kPoiName", (String)localObject1);
        break;
        com.tencent.mm.plugin.report.service.g.yhR.f(10822, new Object[] { Integer.valueOf(1), ((LocationIntent)localObject1).uZw, Integer.valueOf(0) });
        break label582;
      }
      localObject1 = (LocationIntent)paramIntent.getParcelableExtra("KLocationIntent");
      ad.i("MicroMsg.RedirectUI", "locationintent " + ((LocationIntent)localObject1).akR());
      if (((LocationIntent)localObject1).hXs != null) {
        ad.d("MicroMsg.RedirectUI", "addr: " + ((LocationIntent)localObject1).hXs.toString());
      }
      paramIntent.putExtra("key_pick_addr", ((LocationIntent)localObject1).hXs);
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
    if (bt.rM(bt.g((Long)com.tencent.mm.kernel.g.ajC().ajl().get(81938, null))) * 1000L > fFq)
    {
      i = 1;
      if (i != 0) {
        com.tencent.mm.bc.c.aJS().update();
      }
      this.type = getIntent().getIntExtra("map_view_type", -1);
      if (this.type == -1) {
        finish();
      }
      this.msgId = getIntent().getLongExtra("kMsgId", -1L);
      this.gno = getIntent().getStringExtra("map_talker_name");
      ad.d("MicroMsg.RedirectUI", "tofutest type: %s", new Object[] { Integer.valueOf(this.type) });
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
      paramBundle = n.dgi().aoB(this.gno);
      StringBuilder localStringBuilder = new StringBuilder("resume try to enter trackRoom ");
      if (paramBundle != null) {}
      for (boolean bool = true;; bool = false)
      {
        ad.i("MicroMsg.RedirectUI", bool);
        if (paramBundle == null) {
          break;
        }
        this.uZr = paramBundle.latitude;
        this.uZs = paramBundle.longitude;
        this.info = paramBundle.uZn;
        ad.i("MicroMsg.RedirectUI", "resume lat %f lng %f %s member size %d", new Object[] { Double.valueOf(this.uZr), Double.valueOf(this.uZs), this.info, Integer.valueOf(paramBundle.dAk.size()) });
        this.uZt = 0;
        k(this.uZr, this.uZs);
        AppMethodBeat.o(55875);
        return;
      }
      k(-1000.0D, -1000.0D);
      AppMethodBeat.o(55875);
      return;
      this.uZr = getIntent().getDoubleExtra("kwebmap_slat", -85.0D);
      this.uZs = getIntent().getDoubleExtra("kwebmap_lng", -1000.0D);
      this.uZt = getIntent().getIntExtra("kwebmap_scale", 0);
      this.info = getIntent().getStringExtra("Kwebmap_locaion");
      k(this.uZr, this.uZs);
      AppMethodBeat.o(55875);
      return;
      this.vcv = getIntent().getStringExtra("map_sender_name");
      this.oIb = getIntent().getIntExtra("view_type_key", 1);
      this.vcw = getIntent().getIntExtra("key_get_location_type", 0);
      this.uZr = getIntent().getDoubleExtra("KPickPoiLat", -85.0D);
      this.uZs = getIntent().getDoubleExtra("KPickPoiLong", -85.0D);
      k(this.uZr, this.uZs);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(55880);
    this.vbB = false;
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