package com.tencent.mm.plugin.location.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.aar;
import com.tencent.mm.autogen.a.sm;
import com.tencent.mm.autogen.a.wp;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.k.i;
import com.tencent.mm.kernel.f;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelpackage.c;
import com.tencent.mm.modelstat.n;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.location.model.SubCoreLocation;
import com.tencent.mm.plugin.location.model.p;
import com.tencent.mm.pluginsdk.location.LocationIntent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import java.util.LinkedList;

@com.tencent.mm.ui.base.a(23)
public class RedirectUI
  extends HellActivity
{
  private static long lsK = 86400000L;
  private double KbW;
  private double KbX;
  private int KbY;
  private String KeY;
  private int KeZ;
  private boolean Kef;
  private final int Kfa;
  private boolean Kfb;
  private final int Kfc;
  private final int Kfd;
  private final int Kfe;
  private final int Kff;
  private String hZn;
  private final MMHandler handler;
  private boolean isStart;
  private String mkQ;
  private long msgId;
  private int type;
  private int viewType;
  
  public RedirectUI()
  {
    AppMethodBeat.i(55874);
    this.type = 0;
    this.isStart = false;
    this.Kef = true;
    this.KbW = 0.0D;
    this.KbX = 0.0D;
    this.KeY = "";
    this.mkQ = "";
    this.KbY = 0;
    this.hZn = "";
    this.handler = new MMHandler();
    this.Kfa = 1;
    this.Kfb = false;
    this.Kfc = 0;
    this.Kfd = 1;
    this.Kfe = 0;
    this.Kff = 1;
    AppMethodBeat.o(55874);
  }
  
  private void a(Intent paramIntent, double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(55878);
    if (paramIntent != null)
    {
      paramIntent.putExtra("kShowshare", getIntent().getBooleanExtra("kShowshare", true));
      paramIntent.putExtra("kimg_path", com.tencent.mm.plugin.image.d.bzL());
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
      paramIntent.putExtra("map_talker_name", this.mkQ);
      paramIntent.putExtra("kIs_pick_poi", getIntent().getBooleanExtra("kIs_pick_poi", false));
      paramIntent.putExtra("KFavLocSigleView", getIntent().getBooleanExtra("KFavLocSigleView", false));
      aar localaar = new aar();
      localaar.iel.iem = true;
      localaar.publish();
      if (this.type == 6)
      {
        paramIntent.putExtra("kMsgId", getIntent().getLongExtra("kMsgId", -1L));
        paramIntent.putExtra("kRemark", getIntent().getStringExtra("kRemark"));
        if (this.KbY > 0) {
          paramIntent.putExtra("kwebmap_scale", this.KbY);
        }
        paramIntent.putExtra("Kwebmap_locaion", this.hZn);
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
        if (this.KbY > 0) {
          paramIntent.putExtra("kwebmap_scale", this.KbY);
        }
        paramIntent.putExtra("Kwebmap_locaion", this.hZn);
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
  
  private Intent fUW()
  {
    AppMethodBeat.i(55877);
    Intent localIntent2 = com.tencent.mm.plugin.location.ui.impl.d.aY(this);
    localIntent2.putExtra("type_tag", getIntent().getIntExtra("type_tag", 0));
    localIntent2.putExtra("key_geo_coder_four_level", getIntent().getBooleanExtra("key_geo_coder_four_level", false));
    localIntent2.putExtra("type_pick_location_btn", getIntent().getIntExtra("type_pick_location_btn", 1));
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
        Log.d("MicroMsg.RedirectUI", "view poi isHidePoiOversea : " + i.aRD().aRr());
        localIntent2.putExtra("intent_map_key", 2);
        localIntent1 = localIntent2;
      }
    }
  }
  
  private void n(final double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(55876);
    this.isStart = true;
    final Intent localIntent = fUW();
    switch (this.type)
    {
    }
    while (z.pBJ)
    {
      this.handler.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(55873);
          RedirectUI.a(RedirectUI.this, localIntent, paramDouble1, this.Ajo);
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
      String str1 = this.mkQ;
      LocationIntent localLocationIntent = (LocationIntent)paramIntent.getParcelableExtra("KLocationIntent");
      Log.i("MicroMsg.RedirectUI", "locationintent " + localLocationIntent.bbZ());
      Object localObject1 = new sm();
      ((sm)localObject1).hVG.eQp = this.KeZ;
      ((sm)localObject1).hVG.lat = localLocationIntent.lat;
      ((sm)localObject1).hVG.lng = localLocationIntent.lng;
      ((sm)localObject1).hVG.hQp = localLocationIntent.hQp;
      ((sm)localObject1).hVG.label = localLocationIntent.label;
      ((sm)localObject1).hVG.hVI = localLocationIntent.poiName;
      ((sm)localObject1).publish();
      double d1 = localLocationIntent.lat;
      double d2 = localLocationIntent.lng;
      paramInt1 = localLocationIntent.hQp;
      String str2 = localLocationIntent.label;
      Object localObject2 = localLocationIntent.poiName;
      String str3 = localLocationIntent.XOv;
      String str4 = localLocationIntent.Kcd;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localObject1 = "<msg><location x=\"" + d1 + "\" y=\"" + d2 + "\" scale=\"" + paramInt1 + "\" label=\"" + Util.escapeStringForXml(str2) + "\" poiname=\"" + Util.escapeStringForXml((String)localObject1) + "\" infourl=\"" + Util.escapeStringForXml(str3) + "\" maptype=\"0\" poiid=\"" + str4 + "\" /></msg>";
      Log.d("MicroMsg.RedirectUI", "xml ".concat(String.valueOf(localObject1)));
      localObject2 = new wp();
      ((wp)localObject2).iak.hgl = str1;
      ((wp)localObject2).iak.content = ((String)localObject1);
      ((wp)localObject2).iak.type = 48;
      ((wp)localObject2).iak.flags = 0;
      ((wp)localObject2).publish();
      n.a(2004, (float)localLocationIntent.lng, (float)localLocationIntent.lat, 0);
      continue;
      localObject1 = (LocationIntent)paramIntent.getParcelableExtra("KLocationIntent");
      Log.i("MicroMsg.RedirectUI", "locationintent " + ((LocationIntent)localObject1).bbZ());
      if (((LocationIntent)localObject1).XOw == 3)
      {
        com.tencent.mm.plugin.report.service.h.OAn.b(10822, new Object[] { Integer.valueOf(1), ((LocationIntent)localObject1).Kcb, Integer.valueOf(1) });
        label576:
        paramIntent.putExtra("kwebmap_slat", ((LocationIntent)localObject1).lat);
        paramIntent.putExtra("kwebmap_lng", ((LocationIntent)localObject1).lng);
        paramIntent.putExtra("kwebmap_scale", ((LocationIntent)localObject1).hQp);
        paramIntent.putExtra("Kwebmap_locaion", ((LocationIntent)localObject1).label);
        paramIntent.putExtra("kTags", paramIntent.getStringArrayListExtra("kTags"));
        if (!((LocationIntent)localObject1).poiName.equals("")) {
          break label704;
        }
      }
      label704:
      for (localObject1 = "";; localObject1 = ((LocationIntent)localObject1).poiName)
      {
        paramIntent.putExtra("kPoiName", (String)localObject1);
        break;
        com.tencent.mm.plugin.report.service.h.OAn.b(10822, new Object[] { Integer.valueOf(1), ((LocationIntent)localObject1).Kcb, Integer.valueOf(0) });
        break label576;
      }
      localObject1 = (LocationIntent)paramIntent.getParcelableExtra("KLocationIntent");
      Log.i("MicroMsg.RedirectUI", "locationintent " + ((LocationIntent)localObject1).bbZ());
      if (((LocationIntent)localObject1).oEd != null) {
        Log.d("MicroMsg.RedirectUI", "addr: " + ((LocationIntent)localObject1).oEd.toString());
      }
      paramIntent.putExtra("key_pick_addr", ((LocationIntent)localObject1).oEd);
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
    if (Util.secondsToNow(Util.nullAsNil((Long)com.tencent.mm.kernel.h.baE().ban().d(81938, null))) * 1000L > lsK)
    {
      i = 1;
      if (i != 0) {
        c.bLz().update();
      }
      this.type = getIntent().getIntExtra("map_view_type", -1);
      if (this.type == -1) {
        finish();
      }
      this.msgId = getIntent().getLongExtra("kMsgId", -1L);
      this.mkQ = getIntent().getStringExtra("map_talker_name");
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
      paramBundle = SubCoreLocation.fUC().aKe(this.mkQ);
      StringBuilder localStringBuilder = new StringBuilder("resume try to enter trackRoom ");
      if (paramBundle != null) {}
      for (boolean bool = true;; bool = false)
      {
        Log.i("MicroMsg.RedirectUI", bool);
        if (paramBundle == null) {
          break;
        }
        this.KbW = paramBundle.latitude;
        this.KbX = paramBundle.longitude;
        this.hZn = paramBundle.KbS;
        Log.i("MicroMsg.RedirectUI", "resume lat %f lng %f %s member size %d", new Object[] { Double.valueOf(this.KbW), Double.valueOf(this.KbX), this.hZn, Integer.valueOf(paramBundle.hSk.size()) });
        this.KbY = 0;
        n(this.KbW, this.KbX);
        AppMethodBeat.o(55875);
        return;
      }
      n(-1000.0D, -1000.0D);
      AppMethodBeat.o(55875);
      return;
      this.KbW = getIntent().getDoubleExtra("kwebmap_slat", -85.0D);
      this.KbX = getIntent().getDoubleExtra("kwebmap_lng", -1000.0D);
      this.KbY = getIntent().getIntExtra("kwebmap_scale", 0);
      this.hZn = getIntent().getStringExtra("Kwebmap_locaion");
      n(this.KbW, this.KbX);
      AppMethodBeat.o(55875);
      return;
      this.KeY = getIntent().getStringExtra("map_sender_name");
      this.viewType = getIntent().getIntExtra("view_type_key", 1);
      this.KeZ = getIntent().getIntExtra("key_get_location_type", 0);
      this.KbW = getIntent().getDoubleExtra("KPickPoiLat", -85.0D);
      this.KbX = getIntent().getDoubleExtra("KPickPoiLong", -85.0D);
      n(this.KbW, this.KbX);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(55880);
    this.Kef = false;
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