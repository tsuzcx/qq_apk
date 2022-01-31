package com.tencent.mm.plugin.location.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.nb;
import com.tencent.mm.g.a.qj;
import com.tencent.mm.g.a.tm;
import com.tencent.mm.kernel.e;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.location.model.l;
import com.tencent.mm.plugin.location.model.p;
import com.tencent.mm.plugin.location.ui.impl.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.location.LocationIntent;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import java.util.LinkedList;

@com.tencent.mm.ui.base.a(23)
public class RedirectUI
  extends Activity
{
  private static long dZF = 86400000L;
  private long cpO;
  private final ak handler;
  private String info;
  private boolean isStart;
  private int kwo;
  private double nZV;
  private double nZW;
  private int nZX;
  private String ocM;
  private String ocN;
  private int ocO;
  private final int ocP;
  private boolean ocQ;
  private final int ocR;
  private final int ocS;
  private final int ocT;
  private final int ocU;
  private boolean ocf;
  private int type;
  
  public RedirectUI()
  {
    AppMethodBeat.i(113474);
    this.type = 0;
    this.isStart = false;
    this.ocf = true;
    this.nZV = 0.0D;
    this.nZW = 0.0D;
    this.ocM = "";
    this.ocN = "";
    this.nZX = 0;
    this.info = "";
    this.handler = new ak();
    this.ocP = 1;
    this.ocQ = false;
    this.ocR = 0;
    this.ocS = 1;
    this.ocT = 0;
    this.ocU = 1;
    AppMethodBeat.o(113474);
  }
  
  private void a(Intent paramIntent, double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(113478);
    if (paramIntent != null)
    {
      paramIntent.putExtra("kShowshare", getIntent().getBooleanExtra("kShowshare", true));
      paramIntent.putExtra("kimg_path", com.tencent.mm.plugin.i.c.YK());
      paramIntent.putExtra("kPoi_url", bo.bf(getIntent().getStringExtra("kPoi_url"), ""));
      paramIntent.putExtra("map_view_type", getIntent().getIntExtra("map_view_type", 0));
      paramIntent.putExtra("kFavInfoLocalId", getIntent().getLongExtra("kFavInfoLocalId", -1L));
      paramIntent.putExtra("kFavCanDel", getIntent().getBooleanExtra("kFavCanDel", true));
      paramIntent.putExtra("kFavCanRemark", getIntent().getBooleanExtra("kFavCanRemark", true));
      paramIntent.putExtra("kwebmap_slat", paramDouble1);
      paramIntent.putExtra("kwebmap_lng", paramDouble2);
      paramIntent.putExtra("kPoiid", getIntent().getStringExtra("kPoiid"));
      paramIntent.putExtra("kPoiName", getIntent().getStringExtra("kPoiName"));
      paramIntent.putExtra("kisUsername", bo.bf(getIntent().getStringExtra("kisUsername"), ""));
      paramIntent.putExtra("map_talker_name", this.ocN);
      paramIntent.putExtra("kIs_pick_poi", getIntent().getBooleanExtra("kIs_pick_poi", false));
      paramIntent.putExtra("KFavLocSigleView", getIntent().getBooleanExtra("KFavLocSigleView", false));
      tm localtm = new tm();
      localtm.cJY.cJZ = true;
      com.tencent.mm.sdk.b.a.ymk.l(localtm);
      if (this.type == 6)
      {
        paramIntent.putExtra("kMsgId", getIntent().getLongExtra("kMsgId", -1L));
        paramIntent.putExtra("kRemark", getIntent().getStringExtra("kRemark"));
        if (this.nZX > 0) {
          paramIntent.putExtra("kwebmap_scale", this.nZX);
        }
        paramIntent.putExtra("Kwebmap_locaion", this.info);
        paramIntent.putExtra("soso_street_view_url", getIntent().getStringExtra("soso_street_view_url"));
        startActivityForResult(paramIntent, 3);
        AppMethodBeat.o(113478);
        return;
      }
      if ((this.type == 1) || (this.type == 2) || (this.type == 7) || (this.type == 9) || (this.type == 10))
      {
        paramIntent.putExtra("kMsgId", getIntent().getLongExtra("kMsgId", -1L));
        paramIntent.putExtra("kRemark", getIntent().getStringExtra("kRemark"));
        paramIntent.putExtra("kTags", getIntent().getStringArrayListExtra("kTags"));
        if (this.nZX > 0) {
          paramIntent.putExtra("kwebmap_scale", this.nZX);
        }
        paramIntent.putExtra("Kwebmap_locaion", this.info);
        paramIntent.putExtra("soso_street_view_url", getIntent().getStringExtra("soso_street_view_url"));
        startActivityForResult(paramIntent, 3);
        AppMethodBeat.o(113478);
        return;
      }
      if (this.type == 0)
      {
        startActivityForResult(paramIntent, 2);
        AppMethodBeat.o(113478);
        return;
      }
      if (this.type == 3)
      {
        startActivityForResult(paramIntent, 5);
        AppMethodBeat.o(113478);
        return;
      }
      if (this.type == 8) {
        startActivityForResult(paramIntent, 6);
      }
      AppMethodBeat.o(113478);
      return;
    }
    finish();
    AppMethodBeat.o(113478);
  }
  
  private Intent bLI()
  {
    AppMethodBeat.i(113477);
    Intent localIntent2 = d.V(this);
    Intent localIntent1;
    switch (this.type)
    {
    case 4: 
    case 5: 
    default: 
      ab.d("MicroMsg.RedirectUI", "view type error");
      localIntent1 = null;
    }
    for (;;)
    {
      AppMethodBeat.o(113477);
      return localIntent1;
      String str = getIntent().getStringExtra("fromWhereShare");
      ab.d("MicroMsg.RedirectUI", "location resume");
      localIntent2.putExtra("intent_map_key", 5);
      localIntent1 = localIntent2;
      if (!bo.isNullOrNil(str))
      {
        localIntent2.putExtra("fromWhereShare", str);
        localIntent1 = localIntent2;
        continue;
        ab.d("MicroMsg.RedirectUI", "view normal");
        localIntent2.putExtra("intent_map_key", 4);
        localIntent1 = localIntent2;
        continue;
        localIntent2.putExtra("intent_map_key", 4);
        localIntent1 = localIntent2;
        continue;
        ab.d("MicroMsg.RedirectUI", "view poi      isHidePoiOversea : " + com.tencent.mm.m.g.Nr().Nc());
        localIntent2.putExtra("intent_map_key", 2);
        localIntent1 = localIntent2;
      }
    }
  }
  
  private void k(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(113476);
    this.isStart = true;
    Intent localIntent = bLI();
    switch (this.type)
    {
    }
    while (ae.gki)
    {
      this.handler.postDelayed(new RedirectUI.1(this, localIntent, paramDouble1, paramDouble2), 2000L);
      AppMethodBeat.o(113476);
      return;
      localIntent.putExtra("location_scene", 1);
    }
    a(localIntent, paramDouble1, paramDouble2);
    AppMethodBeat.o(113476);
  }
  
  public void finish()
  {
    AppMethodBeat.i(113481);
    super.finish();
    AppMethodBeat.o(113481);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(113479);
    ab.i("MicroMsg.RedirectUI", "onAcvityResult requestCode:".concat(String.valueOf(paramInt1)));
    if (paramInt2 != -1)
    {
      finish();
      AppMethodBeat.o(113479);
      return;
    }
    if (paramIntent == null)
    {
      finish();
      AppMethodBeat.o(113479);
      return;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      setResult(paramInt2, paramIntent);
      finish();
      AppMethodBeat.o(113479);
      return;
      String str1 = this.ocN;
      LocationIntent localLocationIntent = (LocationIntent)paramIntent.getParcelableExtra("KLocationIntent");
      ab.i("MicroMsg.RedirectUI", "locationintent " + localLocationIntent.SU());
      Object localObject1 = new nb();
      ((nb)localObject1).cDj.bsY = this.ocO;
      ((nb)localObject1).cDj.lat = localLocationIntent.lat;
      ((nb)localObject1).cDj.lng = localLocationIntent.lng;
      ((nb)localObject1).cDj.cyX = localLocationIntent.cyX;
      ((nb)localObject1).cDj.label = localLocationIntent.label;
      ((nb)localObject1).cDj.cDl = localLocationIntent.eSM;
      com.tencent.mm.sdk.b.a.ymk.l((b)localObject1);
      double d1 = localLocationIntent.lat;
      double d2 = localLocationIntent.lng;
      paramInt1 = localLocationIntent.cyX;
      String str2 = localLocationIntent.label;
      Object localObject2 = localLocationIntent.eSM;
      String str3 = localLocationIntent.vJU;
      String str4 = localLocationIntent.oac;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localObject1 = "<msg><location x=\"" + d1 + "\" y=\"" + d2 + "\" scale=\"" + paramInt1 + "\" label=\"" + bo.apT(str2) + "\" poiname=\"" + bo.apT((String)localObject1) + "\" infourl=\"" + bo.apT(str3) + "\" maptype=\"0\" poiid=\"" + str4 + "\" /></msg>";
      ab.d("MicroMsg.RedirectUI", "xml ".concat(String.valueOf(localObject1)));
      localObject2 = new qj();
      ((qj)localObject2).cGX.cGY = str1;
      ((qj)localObject2).cGX.content = ((String)localObject1);
      ((qj)localObject2).cGX.type = 48;
      ((qj)localObject2).cGX.flags = 0;
      com.tencent.mm.sdk.b.a.ymk.l((b)localObject2);
      o.a(2004, (float)localLocationIntent.lng, (float)localLocationIntent.lat, 0);
      continue;
      localObject1 = (LocationIntent)paramIntent.getParcelableExtra("KLocationIntent");
      ab.i("MicroMsg.RedirectUI", "locationintent " + ((LocationIntent)localObject1).SU());
      if (((LocationIntent)localObject1).vJV == 3)
      {
        h.qsU.e(10822, new Object[] { Integer.valueOf(1), ((LocationIntent)localObject1).oaa, Integer.valueOf(1) });
        label582:
        paramIntent.putExtra("kwebmap_slat", ((LocationIntent)localObject1).lat);
        paramIntent.putExtra("kwebmap_lng", ((LocationIntent)localObject1).lng);
        paramIntent.putExtra("kwebmap_scale", ((LocationIntent)localObject1).cyX);
        paramIntent.putExtra("Kwebmap_locaion", ((LocationIntent)localObject1).label);
        paramIntent.putExtra("kTags", paramIntent.getStringArrayListExtra("kTags"));
        if (!((LocationIntent)localObject1).eSM.equals("")) {
          break label710;
        }
      }
      label710:
      for (localObject1 = "";; localObject1 = ((LocationIntent)localObject1).eSM)
      {
        paramIntent.putExtra("kPoiName", (String)localObject1);
        break;
        h.qsU.e(10822, new Object[] { Integer.valueOf(1), ((LocationIntent)localObject1).oaa, Integer.valueOf(0) });
        break label582;
      }
      localObject1 = (LocationIntent)paramIntent.getParcelableExtra("KLocationIntent");
      ab.i("MicroMsg.RedirectUI", "locationintent " + ((LocationIntent)localObject1).SU());
      if (((LocationIntent)localObject1).fBK != null) {
        ab.d("MicroMsg.RedirectUI", "addr: " + ((LocationIntent)localObject1).fBK.toString());
      }
      paramIntent.putExtra("key_pick_addr", ((LocationIntent)localObject1).fBK);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(113475);
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 21)
    {
      getWindow().addFlags(-2147483648);
      getWindow().setStatusBarColor(0);
    }
    int i;
    if (bo.gz(bo.c((Long)com.tencent.mm.kernel.g.RL().Ru().get(81938, null))) * 1000L > dZF)
    {
      i = 1;
      if (i != 0) {
        com.tencent.mm.ba.c.aiI().update();
      }
      this.type = getIntent().getIntExtra("map_view_type", -1);
      if (this.type == -1) {
        finish();
      }
      this.cpO = getIntent().getLongExtra("kMsgId", -1L);
      this.ocN = getIntent().getStringExtra("map_talker_name");
      ab.d("MicroMsg.RedirectUI", "tofutest type: %s", new Object[] { Integer.valueOf(this.type) });
      switch (this.type)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(113475);
      return;
      i = 0;
      break;
      paramBundle = l.bLs().Sa(this.ocN);
      StringBuilder localStringBuilder = new StringBuilder("resume try to enter trackRoom ");
      if (paramBundle != null) {}
      for (boolean bool = true;; bool = false)
      {
        ab.i("MicroMsg.RedirectUI", bool);
        if (paramBundle == null) {
          break;
        }
        this.nZV = paramBundle.latitude;
        this.nZW = paramBundle.longitude;
        this.info = paramBundle.nZR;
        ab.i("MicroMsg.RedirectUI", "resume lat %f lng %f %s member size %d", new Object[] { Double.valueOf(this.nZV), Double.valueOf(this.nZW), this.info, Integer.valueOf(paramBundle.cAC.size()) });
        this.nZX = 0;
        k(this.nZV, this.nZW);
        AppMethodBeat.o(113475);
        return;
      }
      k(-1000.0D, -1000.0D);
      AppMethodBeat.o(113475);
      return;
      this.nZV = getIntent().getDoubleExtra("kwebmap_slat", -85.0D);
      this.nZW = getIntent().getDoubleExtra("kwebmap_lng", -1000.0D);
      this.nZX = getIntent().getIntExtra("kwebmap_scale", 0);
      this.info = getIntent().getStringExtra("Kwebmap_locaion");
      k(this.nZV, this.nZW);
      AppMethodBeat.o(113475);
      return;
      this.ocM = getIntent().getStringExtra("map_sender_name");
      this.kwo = getIntent().getIntExtra("view_type_key", 1);
      this.ocO = getIntent().getIntExtra("key_get_location_type", 0);
      k(-85.0D, -1000.0D);
    }
  }
  
  protected void onDestroy()
  {
    AppMethodBeat.i(113480);
    this.ocf = false;
    super.onDestroy();
    AppMethodBeat.o(113480);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.RedirectUI
 * JD-Core Version:    0.7.0.1
 */