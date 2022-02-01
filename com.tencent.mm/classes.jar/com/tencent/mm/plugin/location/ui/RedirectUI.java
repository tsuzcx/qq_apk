package com.tencent.mm.plugin.location.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ox;
import com.tencent.mm.g.a.sk;
import com.tencent.mm.g.a.vu;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.kernel.e;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.location.model.n;
import com.tencent.mm.plugin.location.model.r;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.location.LocationIntent;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import java.util.LinkedList;

@com.tencent.mm.ui.base.a(23)
public class RedirectUI
  extends HellActivity
{
  private static long fni = 86400000L;
  private String fTK;
  private final ao handler;
  private String info;
  private boolean isStart;
  private long msgId;
  private int oeH;
  private double tWI;
  private double tWJ;
  private int tWK;
  private boolean tYS;
  private String tZM;
  private int tZN;
  private final int tZO;
  private boolean tZP;
  private final int tZQ;
  private final int tZR;
  private final int tZS;
  private final int tZT;
  private int type;
  
  public RedirectUI()
  {
    AppMethodBeat.i(55874);
    this.type = 0;
    this.isStart = false;
    this.tYS = true;
    this.tWI = 0.0D;
    this.tWJ = 0.0D;
    this.tZM = "";
    this.fTK = "";
    this.tWK = 0;
    this.info = "";
    this.handler = new ao();
    this.tZO = 1;
    this.tZP = false;
    this.tZQ = 0;
    this.tZR = 1;
    this.tZS = 0;
    this.tZT = 1;
    AppMethodBeat.o(55874);
  }
  
  private void a(Intent paramIntent, double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(55878);
    if (paramIntent != null)
    {
      paramIntent.putExtra("kShowshare", getIntent().getBooleanExtra("kShowshare", true));
      paramIntent.putExtra("kimg_path", com.tencent.mm.plugin.image.d.awL());
      paramIntent.putExtra("kPoi_url", bs.bG(getIntent().getStringExtra("kPoi_url"), ""));
      paramIntent.putExtra("map_view_type", getIntent().getIntExtra("map_view_type", 0));
      paramIntent.putExtra("kFavInfoLocalId", getIntent().getLongExtra("kFavInfoLocalId", -1L));
      paramIntent.putExtra("kFavCanDel", getIntent().getBooleanExtra("kFavCanDel", true));
      paramIntent.putExtra("kFavCanRemark", getIntent().getBooleanExtra("kFavCanRemark", true));
      paramIntent.putExtra("kwebmap_slat", paramDouble1);
      paramIntent.putExtra("kwebmap_lng", paramDouble2);
      paramIntent.putExtra("kPoiid", getIntent().getStringExtra("kPoiid"));
      paramIntent.putExtra("kPoiName", getIntent().getStringExtra("kPoiName"));
      paramIntent.putExtra("kisUsername", bs.bG(getIntent().getStringExtra("kisUsername"), ""));
      paramIntent.putExtra("map_talker_name", this.fTK);
      paramIntent.putExtra("kIs_pick_poi", getIntent().getBooleanExtra("kIs_pick_poi", false));
      paramIntent.putExtra("KFavLocSigleView", getIntent().getBooleanExtra("KFavLocSigleView", false));
      vu localvu = new vu();
      localvu.dyG.dyH = true;
      com.tencent.mm.sdk.b.a.GpY.l(localvu);
      if (this.type == 6)
      {
        paramIntent.putExtra("kMsgId", getIntent().getLongExtra("kMsgId", -1L));
        paramIntent.putExtra("kRemark", getIntent().getStringExtra("kRemark"));
        if (this.tWK > 0) {
          paramIntent.putExtra("kwebmap_scale", this.tWK);
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
        if (this.tWK > 0) {
          paramIntent.putExtra("kwebmap_scale", this.tWK);
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
  
  private Intent cXo()
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
      ac.d("MicroMsg.RedirectUI", "view type error");
      localIntent1 = null;
    }
    for (;;)
    {
      AppMethodBeat.o(55877);
      return localIntent1;
      String str = getIntent().getStringExtra("fromWhereShare");
      ac.d("MicroMsg.RedirectUI", "location resume");
      localIntent2.putExtra("intent_map_key", 5);
      localIntent1 = localIntent2;
      if (!bs.isNullOrNil(str))
      {
        localIntent2.putExtra("fromWhereShare", str);
        localIntent1 = localIntent2;
        continue;
        ac.d("MicroMsg.RedirectUI", "view normal");
        localIntent2.putExtra("intent_map_key", 4);
        localIntent1 = localIntent2;
        continue;
        localIntent2.putExtra("intent_map_key", 4);
        localIntent1 = localIntent2;
        continue;
        ac.d("MicroMsg.RedirectUI", "view poi isHidePoiOversea : " + com.tencent.mm.m.g.ZZ().ZM());
        localIntent2.putExtra("intent_map_key", 2);
        localIntent1 = localIntent2;
      }
    }
  }
  
  private void k(final double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(55876);
    this.isStart = true;
    final Intent localIntent = cXo();
    switch (this.type)
    {
    }
    while (ab.ive)
    {
      this.handler.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(55873);
          RedirectUI.a(RedirectUI.this, localIntent, paramDouble1, this.qOK);
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
    ac.i("MicroMsg.RedirectUI", "onAcvityResult requestCode:".concat(String.valueOf(paramInt1)));
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
      String str1 = this.fTK;
      LocationIntent localLocationIntent = (LocationIntent)paramIntent.getParcelableExtra("KLocationIntent");
      ac.i("MicroMsg.RedirectUI", "locationintent " + localLocationIntent.aif());
      Object localObject1 = new ox();
      ((ox)localObject1).drv.drx = this.tZN;
      ((ox)localObject1).drv.lat = localLocationIntent.lat;
      ((ox)localObject1).drv.lng = localLocationIntent.lng;
      ((ox)localObject1).drv.dmN = localLocationIntent.dmN;
      ((ox)localObject1).drv.label = localLocationIntent.label;
      ((ox)localObject1).drv.dry = localLocationIntent.gPy;
      com.tencent.mm.sdk.b.a.GpY.l((b)localObject1);
      double d1 = localLocationIntent.lat;
      double d2 = localLocationIntent.lng;
      paramInt1 = localLocationIntent.dmN;
      String str2 = localLocationIntent.label;
      Object localObject2 = localLocationIntent.gPy;
      String str3 = localLocationIntent.DfY;
      String str4 = localLocationIntent.tWP;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localObject1 = "<msg><location x=\"" + d1 + "\" y=\"" + d2 + "\" scale=\"" + paramInt1 + "\" label=\"" + bs.aLw(str2) + "\" poiname=\"" + bs.aLw((String)localObject1) + "\" infourl=\"" + bs.aLw(str3) + "\" maptype=\"0\" poiid=\"" + str4 + "\" /></msg>";
      ac.d("MicroMsg.RedirectUI", "xml ".concat(String.valueOf(localObject1)));
      localObject2 = new sk();
      ((sk)localObject2).dvv.dvw = str1;
      ((sk)localObject2).dvv.content = ((String)localObject1);
      ((sk)localObject2).dvv.type = 48;
      ((sk)localObject2).dvv.flags = 0;
      com.tencent.mm.sdk.b.a.GpY.l((b)localObject2);
      o.a(2004, (float)localLocationIntent.lng, (float)localLocationIntent.lat, 0);
      continue;
      localObject1 = (LocationIntent)paramIntent.getParcelableExtra("KLocationIntent");
      ac.i("MicroMsg.RedirectUI", "locationintent " + ((LocationIntent)localObject1).aif());
      if (((LocationIntent)localObject1).DfZ == 3)
      {
        h.wUl.f(10822, new Object[] { Integer.valueOf(1), ((LocationIntent)localObject1).tWN, Integer.valueOf(1) });
        label582:
        paramIntent.putExtra("kwebmap_slat", ((LocationIntent)localObject1).lat);
        paramIntent.putExtra("kwebmap_lng", ((LocationIntent)localObject1).lng);
        paramIntent.putExtra("kwebmap_scale", ((LocationIntent)localObject1).dmN);
        paramIntent.putExtra("Kwebmap_locaion", ((LocationIntent)localObject1).label);
        paramIntent.putExtra("kTags", paramIntent.getStringArrayListExtra("kTags"));
        if (!((LocationIntent)localObject1).gPy.equals("")) {
          break label710;
        }
      }
      label710:
      for (localObject1 = "";; localObject1 = ((LocationIntent)localObject1).gPy)
      {
        paramIntent.putExtra("kPoiName", (String)localObject1);
        break;
        h.wUl.f(10822, new Object[] { Integer.valueOf(1), ((LocationIntent)localObject1).tWN, Integer.valueOf(0) });
        break label582;
      }
      localObject1 = (LocationIntent)paramIntent.getParcelableExtra("KLocationIntent");
      ac.i("MicroMsg.RedirectUI", "locationintent " + ((LocationIntent)localObject1).aif());
      if (((LocationIntent)localObject1).hEN != null) {
        ac.d("MicroMsg.RedirectUI", "addr: " + ((LocationIntent)localObject1).hEN.toString());
      }
      paramIntent.putExtra("key_pick_addr", ((LocationIntent)localObject1).hEN);
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
    if (bs.pN(bs.g((Long)com.tencent.mm.kernel.g.agR().agA().get(81938, null))) * 1000L > fni)
    {
      i = 1;
      if (i != 0) {
        com.tencent.mm.bb.c.aGH().update();
      }
      this.type = getIntent().getIntExtra("map_view_type", -1);
      if (this.type == -1) {
        finish();
      }
      this.msgId = getIntent().getLongExtra("kMsgId", -1L);
      this.fTK = getIntent().getStringExtra("map_talker_name");
      ac.d("MicroMsg.RedirectUI", "tofutest type: %s", new Object[] { Integer.valueOf(this.type) });
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
      paramBundle = n.cWW().ajO(this.fTK);
      StringBuilder localStringBuilder = new StringBuilder("resume try to enter trackRoom ");
      if (paramBundle != null) {}
      for (boolean bool = true;; bool = false)
      {
        ac.i("MicroMsg.RedirectUI", bool);
        if (paramBundle == null) {
          break;
        }
        this.tWI = paramBundle.latitude;
        this.tWJ = paramBundle.longitude;
        this.info = paramBundle.tWE;
        ac.i("MicroMsg.RedirectUI", "resume lat %f lng %f %s member size %d", new Object[] { Double.valueOf(this.tWI), Double.valueOf(this.tWJ), this.info, Integer.valueOf(paramBundle.dow.size()) });
        this.tWK = 0;
        k(this.tWI, this.tWJ);
        AppMethodBeat.o(55875);
        return;
      }
      k(-1000.0D, -1000.0D);
      AppMethodBeat.o(55875);
      return;
      this.tWI = getIntent().getDoubleExtra("kwebmap_slat", -85.0D);
      this.tWJ = getIntent().getDoubleExtra("kwebmap_lng", -1000.0D);
      this.tWK = getIntent().getIntExtra("kwebmap_scale", 0);
      this.info = getIntent().getStringExtra("Kwebmap_locaion");
      k(this.tWI, this.tWJ);
      AppMethodBeat.o(55875);
      return;
      this.tZM = getIntent().getStringExtra("map_sender_name");
      this.oeH = getIntent().getIntExtra("view_type_key", 1);
      this.tZN = getIntent().getIntExtra("key_get_location_type", 0);
      this.tWI = getIntent().getDoubleExtra("KPickPoiLat", -85.0D);
      this.tWJ = getIntent().getDoubleExtra("KPickPoiLong", -85.0D);
      k(this.tWI, this.tWJ);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(55880);
    this.tYS = false;
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