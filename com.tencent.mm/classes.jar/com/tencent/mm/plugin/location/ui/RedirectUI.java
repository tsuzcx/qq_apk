package com.tencent.mm.plugin.location.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.oo;
import com.tencent.mm.g.a.sb;
import com.tencent.mm.g.a.vk;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.kernel.e;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.plugin.location.model.n;
import com.tencent.mm.plugin.location.model.r;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.location.LocationIntent;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;

@com.tencent.mm.ui.base.a(23)
public class RedirectUI
  extends HellActivity
{
  private static long fjO = 86400000L;
  private String fPP;
  private final ap handler;
  private String info;
  private boolean isStart;
  private long msgId;
  private int nBH;
  private double sOv;
  private double sOw;
  private int sOx;
  private boolean sQF;
  private int sRA;
  private final int sRB;
  private boolean sRC;
  private final int sRD;
  private final int sRE;
  private final int sRF;
  private final int sRG;
  private String sRz;
  private int type;
  
  public RedirectUI()
  {
    AppMethodBeat.i(55874);
    this.type = 0;
    this.isStart = false;
    this.sQF = true;
    this.sOv = 0.0D;
    this.sOw = 0.0D;
    this.sRz = "";
    this.fPP = "";
    this.sOx = 0;
    this.info = "";
    this.handler = new ap();
    this.sRB = 1;
    this.sRC = false;
    this.sRD = 0;
    this.sRE = 1;
    this.sRF = 0;
    this.sRG = 1;
    AppMethodBeat.o(55874);
  }
  
  private void a(Intent paramIntent, double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(55878);
    if (paramIntent != null)
    {
      paramIntent.putExtra("kShowshare", getIntent().getBooleanExtra("kShowshare", true));
      paramIntent.putExtra("kimg_path", com.tencent.mm.plugin.image.d.apW());
      paramIntent.putExtra("kPoi_url", bt.by(getIntent().getStringExtra("kPoi_url"), ""));
      paramIntent.putExtra("map_view_type", getIntent().getIntExtra("map_view_type", 0));
      paramIntent.putExtra("kFavInfoLocalId", getIntent().getLongExtra("kFavInfoLocalId", -1L));
      paramIntent.putExtra("kFavCanDel", getIntent().getBooleanExtra("kFavCanDel", true));
      paramIntent.putExtra("kFavCanRemark", getIntent().getBooleanExtra("kFavCanRemark", true));
      paramIntent.putExtra("kwebmap_slat", paramDouble1);
      paramIntent.putExtra("kwebmap_lng", paramDouble2);
      paramIntent.putExtra("kPoiid", getIntent().getStringExtra("kPoiid"));
      paramIntent.putExtra("kPoiName", getIntent().getStringExtra("kPoiName"));
      paramIntent.putExtra("kisUsername", bt.by(getIntent().getStringExtra("kisUsername"), ""));
      paramIntent.putExtra("map_talker_name", this.fPP);
      paramIntent.putExtra("kIs_pick_poi", getIntent().getBooleanExtra("kIs_pick_poi", false));
      paramIntent.putExtra("KFavLocSigleView", getIntent().getBooleanExtra("KFavLocSigleView", false));
      vk localvk = new vk();
      localvk.dAU.dAV = true;
      com.tencent.mm.sdk.b.a.ESL.l(localvk);
      if (this.type == 6)
      {
        paramIntent.putExtra("kMsgId", getIntent().getLongExtra("kMsgId", -1L));
        paramIntent.putExtra("kRemark", getIntent().getStringExtra("kRemark"));
        if (this.sOx > 0) {
          paramIntent.putExtra("kwebmap_scale", this.sOx);
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
        if (this.sOx > 0) {
          paramIntent.putExtra("kwebmap_scale", this.sOx);
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
  
  private Intent cJJ()
  {
    AppMethodBeat.i(55877);
    Intent localIntent2 = com.tencent.mm.plugin.location.ui.impl.d.an(this);
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
        ad.d("MicroMsg.RedirectUI", "view poi isHidePoiOversea : " + com.tencent.mm.m.g.Ze().YP());
        localIntent2.putExtra("intent_map_key", 2);
        localIntent1 = localIntent2;
      }
    }
  }
  
  private void k(final double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(55876);
    this.isStart = true;
    final Intent localIntent = cJJ();
    switch (this.type)
    {
    }
    while (com.tencent.mm.platformtools.ab.hVa)
    {
      this.handler.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(55873);
          RedirectUI.a(RedirectUI.this, localIntent, paramDouble1, this.qgi);
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
      String str1 = this.fPP;
      LocationIntent localLocationIntent = (LocationIntent)paramIntent.getParcelableExtra("KLocationIntent");
      ad.i("MicroMsg.RedirectUI", "locationintent " + localLocationIntent.agO());
      Object localObject1 = new oo();
      ((oo)localObject1).dtK.dtM = this.sRA;
      ((oo)localObject1).dtK.lat = localLocationIntent.lat;
      ((oo)localObject1).dtK.lng = localLocationIntent.lng;
      ((oo)localObject1).dtK.dpd = localLocationIntent.dpd;
      ((oo)localObject1).dtK.label = localLocationIntent.label;
      ((oo)localObject1).dtK.dtN = localLocationIntent.goQ;
      com.tencent.mm.sdk.b.a.ESL.l((b)localObject1);
      double d1 = localLocationIntent.lat;
      double d2 = localLocationIntent.lng;
      paramInt1 = localLocationIntent.dpd;
      String str2 = localLocationIntent.label;
      Object localObject2 = localLocationIntent.goQ;
      String str3 = localLocationIntent.BNO;
      String str4 = localLocationIntent.sOC;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localObject1 = "<msg><location x=\"" + d1 + "\" y=\"" + d2 + "\" scale=\"" + paramInt1 + "\" label=\"" + bt.aGf(str2) + "\" poiname=\"" + bt.aGf((String)localObject1) + "\" infourl=\"" + bt.aGf(str3) + "\" maptype=\"0\" poiid=\"" + str4 + "\" /></msg>";
      ad.d("MicroMsg.RedirectUI", "xml ".concat(String.valueOf(localObject1)));
      localObject2 = new sb();
      ((sb)localObject2).dxJ.dxK = str1;
      ((sb)localObject2).dxJ.content = ((String)localObject1);
      ((sb)localObject2).dxJ.type = 48;
      ((sb)localObject2).dxJ.flags = 0;
      com.tencent.mm.sdk.b.a.ESL.l((b)localObject2);
      o.a(2004, (float)localLocationIntent.lng, (float)localLocationIntent.lat, 0);
      continue;
      localObject1 = (LocationIntent)paramIntent.getParcelableExtra("KLocationIntent");
      ad.i("MicroMsg.RedirectUI", "locationintent " + ((LocationIntent)localObject1).agO());
      if (((LocationIntent)localObject1).BNP == 3)
      {
        h.vKh.f(10822, new Object[] { Integer.valueOf(1), ((LocationIntent)localObject1).sOA, Integer.valueOf(1) });
        label582:
        paramIntent.putExtra("kwebmap_slat", ((LocationIntent)localObject1).lat);
        paramIntent.putExtra("kwebmap_lng", ((LocationIntent)localObject1).lng);
        paramIntent.putExtra("kwebmap_scale", ((LocationIntent)localObject1).dpd);
        paramIntent.putExtra("Kwebmap_locaion", ((LocationIntent)localObject1).label);
        paramIntent.putExtra("kTags", paramIntent.getStringArrayListExtra("kTags"));
        if (!((LocationIntent)localObject1).goQ.equals("")) {
          break label710;
        }
      }
      label710:
      for (localObject1 = "";; localObject1 = ((LocationIntent)localObject1).goQ)
      {
        paramIntent.putExtra("kPoiName", (String)localObject1);
        break;
        h.vKh.f(10822, new Object[] { Integer.valueOf(1), ((LocationIntent)localObject1).sOA, Integer.valueOf(0) });
        break label582;
      }
      localObject1 = (LocationIntent)paramIntent.getParcelableExtra("KLocationIntent");
      ad.i("MicroMsg.RedirectUI", "locationintent " + ((LocationIntent)localObject1).agO());
      if (((LocationIntent)localObject1).hek != null) {
        ad.d("MicroMsg.RedirectUI", "addr: " + ((LocationIntent)localObject1).hek.toString());
      }
      paramIntent.putExtra("key_pick_addr", ((LocationIntent)localObject1).hek);
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
    if (bt.lZ(bt.f((Long)com.tencent.mm.kernel.g.afB().afk().get(81938, null))) * 1000L > fjO)
    {
      i = 1;
      if (i != 0) {
        com.tencent.mm.bc.c.azR().update();
      }
      this.type = getIntent().getIntExtra("map_view_type", -1);
      if (this.type == -1) {
        finish();
      }
      this.msgId = getIntent().getLongExtra("kMsgId", -1L);
      this.fPP = getIntent().getStringExtra("map_talker_name");
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
      paramBundle = n.cJr().aeU(this.fPP);
      StringBuilder localStringBuilder = new StringBuilder("resume try to enter trackRoom ");
      if (paramBundle != null) {}
      for (boolean bool = true;; bool = false)
      {
        ad.i("MicroMsg.RedirectUI", bool);
        if (paramBundle == null) {
          break;
        }
        this.sOv = paramBundle.latitude;
        this.sOw = paramBundle.longitude;
        this.info = paramBundle.sOr;
        ad.i("MicroMsg.RedirectUI", "resume lat %f lng %f %s member size %d", new Object[] { Double.valueOf(this.sOv), Double.valueOf(this.sOw), this.info, Integer.valueOf(paramBundle.dqL.size()) });
        this.sOx = 0;
        k(this.sOv, this.sOw);
        AppMethodBeat.o(55875);
        return;
      }
      k(-1000.0D, -1000.0D);
      AppMethodBeat.o(55875);
      return;
      this.sOv = getIntent().getDoubleExtra("kwebmap_slat", -85.0D);
      this.sOw = getIntent().getDoubleExtra("kwebmap_lng", -1000.0D);
      this.sOx = getIntent().getIntExtra("kwebmap_scale", 0);
      this.info = getIntent().getStringExtra("Kwebmap_locaion");
      k(this.sOv, this.sOw);
      AppMethodBeat.o(55875);
      return;
      this.sRz = getIntent().getStringExtra("map_sender_name");
      this.nBH = getIntent().getIntExtra("view_type_key", 1);
      this.sRA = getIntent().getIntExtra("key_get_location_type", 0);
      this.sOv = getIntent().getDoubleExtra("KPickPoiLat", -85.0D);
      this.sOw = getIntent().getDoubleExtra("KPickPoiLong", -85.0D);
      k(this.sOv, this.sOw);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(55880);
    this.sQF = false;
    super.onDestroy();
    AppMethodBeat.o(55880);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.RedirectUI
 * JD-Core Version:    0.7.0.1
 */