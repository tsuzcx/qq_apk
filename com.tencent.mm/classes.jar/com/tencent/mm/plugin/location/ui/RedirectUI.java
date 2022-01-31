package com.tencent.mm.plugin.location.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Window;
import com.tencent.mm.h.a.mh;
import com.tencent.mm.h.a.pe;
import com.tencent.mm.h.a.rv;
import com.tencent.mm.kernel.e;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.location.model.l;
import com.tencent.mm.plugin.location.model.p;
import com.tencent.mm.plugin.location_soso.SoSoProxyUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.location.LocationIntent;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import java.util.LinkedList;

@com.tencent.mm.ui.base.a(23)
public class RedirectUI
  extends Activity
{
  private static long dil = 86400000L;
  private long bIt;
  private boolean bSr = false;
  private final ah handler = new ah();
  private String info = "";
  private int ivk;
  private double lCJ = 0.0D;
  private double lCK = 0.0D;
  private int lCL = 0;
  private boolean lER = true;
  private String lFA = "";
  private int lFB;
  private final int lFC = 1;
  private boolean lFD = false;
  private final int lFE = 0;
  private final int lFF = 1;
  private final int lFG = 0;
  private final int lFH = 1;
  private String lFz = "";
  private int type = 0;
  
  private void a(Intent paramIntent, double paramDouble1, double paramDouble2)
  {
    if (paramIntent != null)
    {
      paramIntent.putExtra("kShowshare", getIntent().getBooleanExtra("kShowshare", true));
      paramIntent.putExtra("kimg_path", com.tencent.mm.plugin.n.c.FG());
      paramIntent.putExtra("kPoi_url", bk.aM(getIntent().getStringExtra("kPoi_url"), ""));
      paramIntent.putExtra("map_view_type", getIntent().getIntExtra("map_view_type", 0));
      paramIntent.putExtra("kFavInfoLocalId", getIntent().getLongExtra("kFavInfoLocalId", -1L));
      paramIntent.putExtra("kFavCanDel", getIntent().getBooleanExtra("kFavCanDel", true));
      paramIntent.putExtra("kFavCanRemark", getIntent().getBooleanExtra("kFavCanRemark", true));
      paramIntent.putExtra("kwebmap_slat", paramDouble1);
      paramIntent.putExtra("kwebmap_lng", paramDouble2);
      paramIntent.putExtra("kPoiid", getIntent().getStringExtra("kPoiid"));
      paramIntent.putExtra("kPoiName", getIntent().getStringExtra("kPoiName"));
      paramIntent.putExtra("kisUsername", bk.aM(getIntent().getStringExtra("kisUsername"), ""));
      paramIntent.putExtra("map_talker_name", this.lFA);
      paramIntent.putExtra("kIs_pick_poi", getIntent().getBooleanExtra("kIs_pick_poi", false));
      paramIntent.putExtra("KFavLocSigleView", getIntent().getBooleanExtra("KFavLocSigleView", false));
      rv localrv = new rv();
      localrv.cbv.cbw = true;
      com.tencent.mm.sdk.b.a.udP.m(localrv);
      if (this.type == 6)
      {
        paramIntent.putExtra("kMsgId", getIntent().getLongExtra("kMsgId", -1L));
        paramIntent.putExtra("kRemark", getIntent().getStringExtra("kRemark"));
        if (this.lCL > 0) {
          paramIntent.putExtra("kwebmap_scale", this.lCL);
        }
        paramIntent.putExtra("Kwebmap_locaion", this.info);
        paramIntent.putExtra("soso_street_view_url", getIntent().getStringExtra("soso_street_view_url"));
        startActivityForResult(paramIntent, 3);
      }
      do
      {
        return;
        if ((this.type == 1) || (this.type == 2) || (this.type == 7) || (this.type == 9))
        {
          paramIntent.putExtra("kMsgId", getIntent().getLongExtra("kMsgId", -1L));
          paramIntent.putExtra("kRemark", getIntent().getStringExtra("kRemark"));
          paramIntent.putExtra("kTags", getIntent().getStringArrayListExtra("kTags"));
          if (this.lCL > 0) {
            paramIntent.putExtra("kwebmap_scale", this.lCL);
          }
          paramIntent.putExtra("Kwebmap_locaion", this.info);
          paramIntent.putExtra("soso_street_view_url", getIntent().getStringExtra("soso_street_view_url"));
          startActivityForResult(paramIntent, 3);
          return;
        }
        if (this.type == 0)
        {
          startActivityForResult(paramIntent, 2);
          return;
        }
        if (this.type == 3)
        {
          startActivityForResult(paramIntent, 5);
          return;
        }
      } while (this.type != 8);
      startActivityForResult(paramIntent, 6);
      return;
    }
    finish();
  }
  
  private void i(double paramDouble1, double paramDouble2)
  {
    this.bSr = true;
    Intent localIntent = new Intent(this, SoSoProxyUI.class);
    Object localObject;
    switch (this.type)
    {
    case 4: 
    case 5: 
    default: 
      y.d("MicroMsg.RedirectUI", "view type error");
      localObject = null;
      switch (this.type)
      {
      }
      break;
    }
    for (;;)
    {
      if (!ae.eSn) {
        break label343;
      }
      this.handler.postDelayed(new RedirectUI.1(this, (Intent)localObject, paramDouble1, paramDouble2), 2000L);
      return;
      String str = getIntent().getStringExtra("fromWhereShare");
      y.d("MicroMsg.RedirectUI", "location resume");
      localIntent.putExtra("intent_map_key", 5);
      localObject = localIntent;
      if (bk.bl(str)) {
        break;
      }
      localIntent.putExtra("fromWhereShare", str);
      localObject = localIntent;
      break;
      y.d("MicroMsg.RedirectUI", "view normal");
      localIntent.putExtra("intent_map_key", 4);
      localObject = localIntent;
      break;
      localIntent.putExtra("intent_map_key", 4);
      localObject = localIntent;
      break;
      localObject = new StringBuilder("view poi      isHidePoiOversea : ");
      if (bk.getInt(com.tencent.mm.m.g.AB().H("ShowConfig", "hidePoiOversea"), 1) == 1) {}
      for (boolean bool = true;; bool = false)
      {
        y.d("MicroMsg.ConfigListDecoder", "isHidePoiOversea : " + bool);
        y.d("MicroMsg.RedirectUI", bool);
        localIntent.putExtra("intent_map_key", 2);
        localObject = localIntent;
        break;
      }
      ((Intent)localObject).putExtra("location_scene", 1);
    }
    label343:
    a((Intent)localObject, paramDouble1, paramDouble2);
  }
  
  public void finish()
  {
    super.finish();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    y.i("MicroMsg.RedirectUI", "onAcvityResult requestCode:" + paramInt1);
    if (paramInt2 != -1)
    {
      finish();
      return;
    }
    if (paramIntent == null)
    {
      finish();
      return;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      setResult(paramInt2, paramIntent);
      finish();
      return;
      String str1 = this.lFA;
      LocationIntent localLocationIntent = (LocationIntent)paramIntent.getParcelableExtra("KLocationIntent");
      y.i("MicroMsg.RedirectUI", "locationintent " + localLocationIntent.bLE());
      Object localObject1 = new mh();
      ((mh)localObject1).bVy.bcw = this.lFB;
      ((mh)localObject1).bVy.lat = localLocationIntent.lat;
      ((mh)localObject1).bVy.lng = localLocationIntent.lng;
      ((mh)localObject1).bVy.bRv = localLocationIntent.bRv;
      ((mh)localObject1).bVy.label = localLocationIntent.label;
      ((mh)localObject1).bVy.bVA = localLocationIntent.lFn;
      com.tencent.mm.sdk.b.a.udP.m((b)localObject1);
      double d1 = localLocationIntent.lat;
      double d2 = localLocationIntent.lng;
      paramInt1 = localLocationIntent.bRv;
      String str2 = localLocationIntent.label;
      Object localObject2 = localLocationIntent.lFn;
      String str3 = localLocationIntent.rSW;
      String str4 = localLocationIntent.lCQ;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localObject1 = "<msg><location x=\"" + d1 + "\" y=\"" + d2 + "\" scale=\"" + paramInt1 + "\" label=\"" + bk.ZP(str2) + "\" poiname=\"" + bk.ZP((String)localObject1) + "\" infourl=\"" + bk.ZP(str3) + "\" maptype=\"0\" poiid=\"" + str4 + "\" /></msg>";
      y.d("MicroMsg.RedirectUI", "xml " + (String)localObject1);
      localObject2 = new pe();
      ((pe)localObject2).bYQ.bYR = str1;
      ((pe)localObject2).bYQ.content = ((String)localObject1);
      ((pe)localObject2).bYQ.type = 48;
      ((pe)localObject2).bYQ.flags = 0;
      com.tencent.mm.sdk.b.a.udP.m((b)localObject2);
      o.a(2004, (float)localLocationIntent.lng, (float)localLocationIntent.lat, 0);
      continue;
      localObject1 = (LocationIntent)paramIntent.getParcelableExtra("KLocationIntent");
      y.i("MicroMsg.RedirectUI", "locationintent " + ((LocationIntent)localObject1).bLE());
      if (((LocationIntent)localObject1).rSX == 3)
      {
        h.nFQ.f(10822, new Object[] { Integer.valueOf(1), ((LocationIntent)localObject1).lCO, Integer.valueOf(1) });
        label571:
        paramIntent.putExtra("kwebmap_slat", ((LocationIntent)localObject1).lat);
        paramIntent.putExtra("kwebmap_lng", ((LocationIntent)localObject1).lng);
        paramIntent.putExtra("kwebmap_scale", ((LocationIntent)localObject1).bRv);
        paramIntent.putExtra("Kwebmap_locaion", ((LocationIntent)localObject1).label);
        paramIntent.putExtra("kTags", paramIntent.getStringArrayListExtra("kTags"));
        if (!((LocationIntent)localObject1).lFn.equals("")) {
          break label699;
        }
      }
      label699:
      for (localObject1 = "";; localObject1 = ((LocationIntent)localObject1).lFn)
      {
        paramIntent.putExtra("kPoiName", (String)localObject1);
        break;
        h.nFQ.f(10822, new Object[] { Integer.valueOf(1), ((LocationIntent)localObject1).lCO, Integer.valueOf(0) });
        break label571;
      }
      localObject1 = (LocationIntent)paramIntent.getParcelableExtra("KLocationIntent");
      y.i("MicroMsg.RedirectUI", "locationintent " + ((LocationIntent)localObject1).bLE());
      if (((LocationIntent)localObject1).els != null) {
        y.d("MicroMsg.RedirectUI", "addr: " + ((LocationIntent)localObject1).els.toString());
      }
      paramIntent.putExtra("key_pick_addr", ((LocationIntent)localObject1).els);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 21)
    {
      getWindow().addFlags(-2147483648);
      getWindow().setStatusBarColor(0);
    }
    if (bk.cn(Long.valueOf(bk.c((Long)com.tencent.mm.kernel.g.DP().Dz().get(81938, null))).longValue()) * 1000L > dil) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        com.tencent.mm.az.c.PE().update();
      }
      this.type = getIntent().getIntExtra("map_view_type", -1);
      if (this.type == -1) {
        finish();
      }
      this.bIt = getIntent().getLongExtra("kMsgId", -1L);
      this.lFA = getIntent().getStringExtra("map_talker_name");
      y.d("MicroMsg.RedirectUI", "tofutest type: %s", new Object[] { Integer.valueOf(this.type) });
      switch (this.type)
      {
      case 4: 
      case 5: 
      default: 
        return;
      }
    }
    paramBundle = l.bdY().Gx(this.lFA);
    StringBuilder localStringBuilder = new StringBuilder("resume try to enter trackRoom ");
    if (paramBundle != null) {}
    for (boolean bool = true;; bool = false)
    {
      y.i("MicroMsg.RedirectUI", bool);
      if (paramBundle == null) {
        break;
      }
      this.lCJ = paramBundle.latitude;
      this.lCK = paramBundle.longitude;
      this.info = paramBundle.lCF;
      y.i("MicroMsg.RedirectUI", "resume lat %f lng %f %s member size %d", new Object[] { Double.valueOf(this.lCJ), Double.valueOf(this.lCK), this.info, Integer.valueOf(paramBundle.bSX.size()) });
      this.lCL = 0;
      i(this.lCJ, this.lCK);
      return;
    }
    i(-1000.0D, -1000.0D);
    return;
    this.lCJ = getIntent().getDoubleExtra("kwebmap_slat", -85.0D);
    this.lCK = getIntent().getDoubleExtra("kwebmap_lng", -1000.0D);
    this.lCL = getIntent().getIntExtra("kwebmap_scale", 0);
    this.info = getIntent().getStringExtra("Kwebmap_locaion");
    i(this.lCJ, this.lCK);
    return;
    this.lFz = getIntent().getStringExtra("map_sender_name");
    this.ivk = getIntent().getIntExtra("view_type_key", 1);
    this.lFB = getIntent().getIntExtra("key_get_location_type", 0);
    i(-85.0D, -1000.0D);
  }
  
  protected void onDestroy()
  {
    this.lER = false;
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.RedirectUI
 * JD-Core Version:    0.7.0.1
 */