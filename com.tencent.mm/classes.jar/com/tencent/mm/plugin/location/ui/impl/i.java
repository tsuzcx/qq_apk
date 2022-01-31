package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location.ui.n;
import com.tencent.mm.plugin.location.ui.n.a;
import com.tencent.mm.plugin.location_soso.ViewManager;
import com.tencent.mm.plugin.map.a.b;
import com.tencent.mm.plugin.map.a.e;
import com.tencent.mm.plugin.map.a.h;
import com.tencent.mm.pluginsdk.ui.tools.AppChooserUI;
import com.tencent.mm.pluginsdk.ui.tools.r;
import com.tencent.mm.protocal.c.bmy;
import com.tencent.mm.protocal.c.bmz;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.HashMap;

public class i
  extends a
  implements f
{
  protected long bIt = -1L;
  private boolean bTT = true;
  public com.tencent.mm.remoteservice.d eMh = new com.tencent.mm.remoteservice.d(this.activity);
  private boolean guU = false;
  private long lHp = 0L;
  n lKA;
  com.tencent.mm.ui.widget.a.d lKB;
  boolean lKC = false;
  private Runnable lKD;
  private com.tencent.mm.modelgeo.a.a lKE = new i.5(this);
  private String lKz = "";
  
  public i(Activity paramActivity)
  {
    super(paramActivity);
    g.Dk().a(424, this);
  }
  
  protected final String VE()
  {
    return getString(a.h.location_see_info);
  }
  
  protected void beJ()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("kopenGmapNums", this.lHY.lEP);
    localIntent.putExtra("kopenOthersNums", this.lHY.lEQ);
    localIntent.putExtra("kopenreportType", this.lHY.ewz);
    localIntent.putExtra("kRemark", beI());
    localIntent.putExtra("soso_street_view_url", this.lKz);
    this.activity.setResult(-1, localIntent);
  }
  
  void beK()
  {
    this.lIb.lIr.setEnabled(true);
    this.lIb.lIn.setVisibility(8);
    b(this.lHZ);
    this.lIb.lFm.getIController().setZoom(this.lCL);
    this.lIb.lIp.setEnabled(true);
    this.bTT = this.activity.getIntent().getBooleanExtra("kShowshare", true);
    label142:
    Object localObject1;
    Object localObject2;
    if (this.bTT)
    {
      this.lIb.lIp.setVisibility(0);
      this.lKz = this.activity.getIntent().getStringExtra("soso_street_view_url");
      if ((bk.bl(this.lKz)) || ((!x.cqH()) && (!x.cqG()))) {
        break label587;
      }
      this.lKC = true;
      this.lIb.lIp.setOnClickListener(new i.3(this));
      this.lKA = new n(this.lIb.lFm, this.activity);
      localObject1 = this.lKA;
      if (((n)localObject1).mViewManager != null)
      {
        ((n)localObject1).mViewManager.addView(((n)localObject1).lHP, 0.0D, 0.0D);
        ((n)localObject1).mViewManager.setMarkerTag(((n)localObject1).lHP, "info_window_tag");
        if (((n)localObject1).lHS)
        {
          ((n)localObject1).mViewManager.setInfoWindowAdapter(new n.a((n)localObject1, (byte)0));
          ((n)localObject1).mViewManager.showInfoWindowByView(((n)localObject1).lHP);
        }
      }
      localObject1 = this.lKA;
      localObject2 = this.lHZ;
      ((n)localObject1).lCJ = ((LocationInfo)localObject2).lCJ;
      ((n)localObject1).lCK = ((LocationInfo)localObject2).lCK;
      if (!com.tencent.mm.plugin.location.model.e.h(this.lHZ.lCJ, this.lHZ.lCK))
      {
        y.d("MicroMsg.ViewMapUI", "isValidLatLng %f %f", new Object[] { Double.valueOf(this.lHZ.lCJ), Double.valueOf(this.lHZ.lCK) });
        localObject1 = this.lKA;
        ((n)localObject1).lFk = false;
        ((n)localObject1).lHQ.setVisibility(8);
      }
      if (2 == this.type)
      {
        y.i("MicroMsg.ViewMapUI", "location id %s", new Object[] { this.lHZ.lCI });
        if (this.activity.getIntent().getBooleanExtra("kFavCanRemark", true)) {
          beH();
        }
        if (!bk.bl(this.lHZ.lCM)) {
          this.lIb.lIo.setVisibility(0);
        }
      }
      this.lId.put(this.lHZ.lCI, this.lKA);
      if (!this.lHZ.bdO()) {
        break label686;
      }
      if ((this.lFn != null) && (!this.lFn.equals(""))) {
        this.lKA.lFn = this.lFn;
      }
      this.lKA.setText(this.lKA.getPreText() + this.lHZ.lCM);
    }
    for (;;)
    {
      for (;;)
      {
        localObject1 = this.lKA;
        localObject2 = new i.4(this);
        if ((((n)localObject1).lHS) && (((n)localObject1).mViewManager != null)) {
          ((n)localObject1).mViewManager.setMarkerClick(((n)localObject1).lHP, (View.OnClickListener)localObject2);
        }
        return;
        this.lIb.lIp.setVisibility(8);
        break;
        label587:
        if ((!x.cqH()) && (!x.cqG())) {
          break label142;
        }
        this.lKC = false;
        try
        {
          localObject1 = (bmy)new v((float)this.lHZ.lCK, (float)this.lHZ.lCJ, this.bIt).dmK.ecE.ecN;
          new v((bmy)localObject1);
          g.Dk().a(new v((bmy)localObject1), 0);
        }
        catch (Exception localException)
        {
          y.e("MicroMsg.ViewMapUI", localException.toString());
        }
      }
      break label142;
      label686:
      if (com.tencent.mm.plugin.location.model.e.h(this.lHZ.lCJ, this.lHZ.lCK)) {
        this.lIe.a(this.lHZ.lCJ, this.lHZ.lCK, this.lIl, this.lHZ.lCI);
      }
    }
  }
  
  public boolean beL()
  {
    if ((this.lKB != null) && (this.lKB.isShowing())) {
      this.lKB.bFp();
    }
    for (;;)
    {
      return true;
      bfc();
      this.lKB.cfU();
    }
  }
  
  public void beW() {}
  
  protected void beX() {}
  
  public void beY() {}
  
  protected void beZ() {}
  
  final void bfc()
  {
    this.lKB = new com.tencent.mm.ui.widget.a.d(this.activity, 1, false);
    this.lKB.phH = new i.1(this);
    this.lKB.phI = new i.2(this);
  }
  
  protected final void bfd()
  {
    if (this.lKC)
    {
      r.a(new com.tencent.mm.pluginsdk.ui.tools.e());
      Intent localIntent = new Intent();
      localIntent.putExtra("show_bottom", false);
      localIntent.putExtra("jsapi_args_appid", "wx751a1acca5688ba3");
      localIntent.putExtra("rawUrl", this.lKz);
      localIntent.putExtra("title", a.h.scan_entry_street);
      localIntent.putExtra("webview_bg_color_rsID", a.b.black);
      com.tencent.mm.br.d.b(this.activity, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent);
    }
  }
  
  protected final void bfe()
  {
    y.d("MicroMsg.ViewMapUI", "directlyFavorite lat %s, long %s, scale", new Object[] { Double.valueOf(this.lHZ.lCJ), Double.valueOf(this.lHZ.lCK) });
    Intent localIntent = new Intent();
    localIntent.putExtra("kfavorite", true);
    localIntent.putExtra("kopenGmapNums", this.lHY.lEP);
    localIntent.putExtra("kopenOthersNums", this.lHY.lEQ);
    localIntent.putExtra("kopenreportType", this.lHY.ewz);
    localIntent.putExtra("kRemark", beI());
    localIntent.putExtra("kwebmap_slat", this.lHZ.lCJ);
    localIntent.putExtra("kwebmap_lng", this.lHZ.lCK);
    localIntent.putExtra("Kwebmap_locaion", this.lHZ.lCM);
    localIntent.putExtra("kPoiName", this.lFn);
    this.activity.setResult(-1, localIntent);
    this.activity.getIntent().getIntExtra("MMActivity.OverrideEnterAnimation", -1);
    this.activity.getIntent().getIntExtra("MMActivity.OverrideExitAnimation", -1);
    this.activity.finish();
  }
  
  protected final void bff()
  {
    com.tencent.mm.plugin.report.service.h.nFQ.f(12809, new Object[] { Integer.valueOf(3), "" });
    y.d("MicroMsg.ViewMapUI", "locationLine, locationInfo.slat=%f, locationInfo.slong=%f, myLocation.slat=%f, myLocation.slong=%f", new Object[] { Double.valueOf(this.lHZ.lCJ), Double.valueOf(this.lHZ.lCK), Double.valueOf(this.lIa.lCJ), Double.valueOf(this.lIa.lCK) });
    if (this.lIa.bdN()) {
      beZ();
    }
    do
    {
      return;
      this.lIf = true;
    } while (this.handler == null);
    if (this.lKD != null) {
      this.handler.removeCallbacks(this.lKD);
    }
    this.lKD = new i.6(this);
    this.handler.postDelayed(this.lKD, 10000L);
    Activity localActivity = this.activity;
    getString(a.h.app_tip);
    this.dnm = com.tencent.mm.ui.base.h.b(localActivity, getString(a.h.get_location), true, new i.7(this));
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      if ((Math.abs(paramMotionEvent.getX() - this.kXk) > 10.0F) || (Math.abs(paramMotionEvent.getY() - this.hZz) > 10.0F))
      {
        this.guU = true;
        beW();
        continue;
        this.kXk = paramMotionEvent.getX();
        this.hZz = paramMotionEvent.getY();
        this.lHp = System.currentTimeMillis();
        this.guU = false;
        beY();
        continue;
        if (!this.guU) {
          System.currentTimeMillis();
        }
      }
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    com.tencent.mm.plugin.location.ui.d locald;
    label468:
    do
    {
      Object localObject2;
      do
      {
        return;
        locald = this.lHY;
        switch (paramInt1)
        {
        default: 
          return;
        case 4098: 
          if ((-1 == paramInt2) && (paramIntent != null))
          {
            localObject1 = paramIntent.getStringExtra("selectpkg");
            localObject2 = paramIntent.getBundleExtra("transferback");
            boolean bool = paramIntent.getBooleanExtra("isalways", false);
            paramIntent = ((Bundle)localObject2).getParcelableArrayList("locations");
            locald.a((LocationInfo)paramIntent.get(0), (LocationInfo)paramIntent.get(1), (String)localObject1, bool);
            return;
          }
          break;
        }
      } while (4097 != paramInt2);
      if (paramIntent.getBooleanExtra("isalways", false))
      {
        com.tencent.mm.plugin.report.service.h.nFQ.f(11091, new Object[] { Integer.valueOf(6), Integer.valueOf(2) });
        paramIntent = paramIntent.getBundleExtra("transferback").getParcelableArrayList("locations");
        localObject1 = (LocationInfo)paramIntent.get(0);
        localObject2 = (LocationInfo)paramIntent.get(1);
        if (!bk.bl(((LocationInfo)localObject1).lCN)) {
          break label468;
        }
      }
      for (paramIntent = "zh-cn";; paramIntent = ((LocationInfo)localObject1).lCN)
      {
        paramIntent = new Intent("android.intent.action.VIEW", Uri.parse(String.format("http://maps.google.com/maps?f=d&saddr=%f,%f&daddr=%f,%f&hl=" + paramIntent, new Object[] { Double.valueOf(((LocationInfo)localObject2).lCJ), Double.valueOf(((LocationInfo)localObject2).lCK), Double.valueOf(((LocationInfo)localObject1).lCJ), Double.valueOf(((LocationInfo)localObject1).lCK) })));
        localObject1 = new Bundle();
        ((Bundle)localObject1).putParcelable("targetintent", paramIntent);
        localObject2 = new Intent();
        ((Intent)localObject2).setClass(locald.context, AppChooserUI.class);
        ((Intent)localObject2).putExtra("type", 1);
        ((Intent)localObject2).putExtra("title", locald.context.getResources().getString(a.h.location_info_send_tip));
        ((Intent)localObject2).putExtra("targetintent", paramIntent);
        ((Intent)localObject2).putExtra("transferback", (Bundle)localObject1);
        ((Intent)localObject2).putExtra("scene", 6);
        ((Activity)locald.context).startActivityForResult((Intent)localObject2, 4099);
        return;
        com.tencent.mm.plugin.report.service.h.nFQ.f(11091, new Object[] { Integer.valueOf(6), Integer.valueOf(1) });
        break;
      }
    } while ((-1 != paramInt2) || (paramIntent == null));
    Object localObject1 = paramIntent.getStringExtra("selectpkg");
    paramIntent = new Intent((Intent)paramIntent.getBundleExtra("transferback").getParcelable("targetintent"));
    paramIntent.setPackage((String)localObject1);
    paramIntent.addFlags(524288);
    locald.context.startActivity(paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    double d1 = this.activity.getIntent().getDoubleExtra("kwebmap_slat", 0.0D);
    double d2 = this.activity.getIntent().getDoubleExtra("kwebmap_lng", 0.0D);
    y.i("MicroMsg.ViewMapUI", "start dslat " + d1 + " " + d2);
    this.lCL = this.activity.getIntent().getIntExtra("kwebmap_scale", 15);
    if (this.lCL <= 0) {
      this.lCL = 15;
    }
    this.lFn = this.activity.getIntent().getStringExtra("kPoiName");
    paramBundle = this.activity.getIntent().getStringExtra("Kwebmap_locaion");
    y.d("MicroMsg.ViewMapUI", "view " + d1 + " " + d2);
    LocationInfo localLocationInfo = this.lHZ;
    localLocationInfo.lCJ = d1;
    localLocationInfo.lCK = d2;
    localLocationInfo.lCM = paramBundle;
    localLocationInfo.lCL = this.lCL;
    localLocationInfo.bVA = this.lFn;
    this.bIt = this.activity.getIntent().getLongExtra("kMsgId", -1L);
    this.lEc = this.activity.getIntent().getStringExtra("map_talker_name");
    initView();
  }
  
  public void onDestroy()
  {
    this.eMh.release();
    this.handler.removeCallbacks(this.lKD);
    this.handler = null;
    g.Dk().b(424, this);
    super.onDestroy();
  }
  
  public void onPause()
  {
    y.d("MicroMsg.ViewMapUI", "onbaseGeoResume");
    if (this.lIk != null) {
      this.lIk.c(this.lKE);
    }
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    y.d("MicroMsg.ViewMapUI", "onbaseGeoResume");
    if (this.lIk != null) {
      this.lIk.b(this.lKE, true);
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.d("MicroMsg.ViewMapUI", "onScene end %d %d %d", new Object[] { Integer.valueOf(paramm.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramm.getType() == 424)
    {
      if ((paramInt2 == 0) && (paramInt1 == 0))
      {
        paramString = v.nf(((v)paramm).QP().sDW);
        y.d("MicroMsg.ViewMapUI", "getUrl success! url is %s", new Object[] { paramString });
        this.lKz = paramString;
        if (!bk.bl(paramString)) {
          this.lKC = true;
        }
        if ((this.type == 9) && (!bk.bl(paramString)))
        {
          paramString = (TextView)findViewById(a.e.street_tv);
          paramString.setVisibility(0);
          paramString.setOnClickListener(new i.8(this));
        }
      }
      return;
    }
    y.e("MicroMsg.ViewMapUI", "msg failed.errtype:%d, errcode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.i
 * JD-Core Version:    0.7.0.1
 */