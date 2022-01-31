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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.modelsimple.w;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location.model.e;
import com.tencent.mm.plugin.location.ui.n;
import com.tencent.mm.plugin.location.ui.n.a;
import com.tencent.mm.plugin.location_soso.ViewManager;
import com.tencent.mm.pluginsdk.ui.tools.AppChooserUI;
import com.tencent.mm.pluginsdk.ui.tools.t;
import com.tencent.mm.protocal.protobuf.bwr;
import com.tencent.mm.protocal.protobuf.bws;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.HashMap;

public class i
  extends a
  implements f
{
  private boolean cBz;
  protected long cpO;
  public com.tencent.mm.remoteservice.d evl;
  private boolean hPP;
  private long oeC;
  private String ohR;
  n ohS;
  com.tencent.mm.ui.widget.b.d ohT;
  boolean ohU;
  private Runnable ohV;
  private b.a ohW;
  
  public i(Activity paramActivity)
  {
    super(paramActivity);
    AppMethodBeat.i(113746);
    this.cpO = -1L;
    this.ohR = "";
    this.cBz = true;
    this.evl = new com.tencent.mm.remoteservice.d(this.activity);
    this.ohU = false;
    this.ohW = new i.5(this);
    this.hPP = false;
    this.oeC = 0L;
    g.Rc().a(424, this);
    AppMethodBeat.o(113746);
  }
  
  private Intent bMA()
  {
    AppMethodBeat.i(145798);
    Intent localIntent = new Intent();
    localIntent.putExtra("kfavorite", true);
    localIntent.putExtra("kopenGmapNums", this.ofl.ocd);
    localIntent.putExtra("kopenOthersNums", this.ofl.oce);
    localIntent.putExtra("kopenreportType", this.ofl.cFd);
    localIntent.putExtra("kRemark", bMc());
    localIntent.putExtra("kwebmap_slat", this.ofm.nZV);
    localIntent.putExtra("kwebmap_lng", this.ofm.nZW);
    localIntent.putExtra("Kwebmap_locaion", this.ofm.nZY);
    localIntent.putExtra("kPoiName", this.eSM);
    AppMethodBeat.o(145798);
    return localIntent;
  }
  
  protected final String apc()
  {
    AppMethodBeat.i(113759);
    String str = getString(2131301104);
    AppMethodBeat.o(113759);
    return str;
  }
  
  protected final void bMB()
  {
    AppMethodBeat.i(113750);
    if (this.ohU)
    {
      t.a(new com.tencent.mm.pluginsdk.ui.tools.d());
      Intent localIntent = new Intent();
      localIntent.putExtra("show_bottom", false);
      localIntent.putExtra("jsapi_args_appid", "wx751a1acca5688ba3");
      localIntent.putExtra("rawUrl", this.ohR);
      localIntent.putExtra("title", 2131302898);
      localIntent.putExtra("webview_bg_color_rsID", 2131689763);
      com.tencent.mm.bq.d.b(this.activity, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent);
    }
    AppMethodBeat.o(113750);
  }
  
  protected final void bMC()
  {
    AppMethodBeat.i(113755);
    ab.d("MicroMsg.ViewMapUI", "directlyFavorite lat %s, long %s, scale", new Object[] { Double.valueOf(this.ofm.nZV), Double.valueOf(this.ofm.nZW) });
    Intent localIntent = bMA();
    this.activity.setResult(-1, localIntent);
    this.activity.getIntent().getIntExtra("MMActivity.OverrideEnterAnimation", -1);
    this.activity.getIntent().getIntExtra("MMActivity.OverrideExitAnimation", -1);
    this.activity.finish();
    AppMethodBeat.o(113755);
  }
  
  protected final void bMD()
  {
    AppMethodBeat.i(113756);
    com.tencent.mm.plugin.report.service.h.qsU.e(12809, new Object[] { Integer.valueOf(3), "" });
    ab.d("MicroMsg.ViewMapUI", "locationLine, locationInfo.slat=%f, locationInfo.slong=%f, myLocation.slat=%f, myLocation.slong=%f", new Object[] { Double.valueOf(this.ofm.nZV), Double.valueOf(this.ofm.nZW), Double.valueOf(this.ofn.nZV), Double.valueOf(this.ofn.nZW) });
    if (this.ofn.bLh())
    {
      bMv();
      AppMethodBeat.o(113756);
      return;
    }
    this.ofs = true;
    if (this.handler == null)
    {
      AppMethodBeat.o(113756);
      return;
    }
    if (this.ohV != null) {
      this.handler.removeCallbacks(this.ohV);
    }
    this.ohV = new i.6(this);
    this.handler.postDelayed(this.ohV, 10000L);
    Activity localActivity = this.activity;
    getString(2131297087);
    this.eeN = com.tencent.mm.ui.base.h.b(localActivity, getString(2131300528), true, new i.7(this));
    AppMethodBeat.o(113756);
  }
  
  protected void bMd()
  {
    AppMethodBeat.i(113754);
    Intent localIntent = new Intent();
    localIntent.putExtra("kopenGmapNums", this.ofl.ocd);
    localIntent.putExtra("kopenOthersNums", this.ofl.oce);
    localIntent.putExtra("kopenreportType", this.ofl.cFd);
    localIntent.putExtra("kRemark", bMc());
    localIntent.putExtra("soso_street_view_url", this.ohR);
    this.activity.setResult(-1, localIntent);
    AppMethodBeat.o(113754);
  }
  
  void bMe()
  {
    AppMethodBeat.i(113749);
    this.ofo.ofE.setEnabled(true);
    this.ofo.ofA.setVisibility(8);
    b(this.ofm);
    this.ofo.ocA.getIController().setZoom(this.nZX);
    this.ofo.ofC.setEnabled(true);
    this.cBz = this.activity.getIntent().getBooleanExtra("kShowshare", true);
    label150:
    Object localObject1;
    Object localObject2;
    if (this.cBz)
    {
      this.ofo.ofC.setVisibility(0);
      this.ohR = this.activity.getIntent().getStringExtra("soso_street_view_url");
      if ((bo.isNullOrNil(this.ohR)) || ((!aa.dsE()) && (!aa.dsD()))) {
        break label599;
      }
      this.ohU = true;
      this.ofo.ofC.setOnClickListener(new i.3(this));
      this.ohS = new n(this.ofo.ocA, this.activity);
      localObject1 = this.ohS;
      if (((n)localObject1).mViewManager != null)
      {
        ((n)localObject1).mViewManager.addView(((n)localObject1).ofb, 0.0D, 0.0D);
        ((n)localObject1).mViewManager.setMarkerTag(((n)localObject1).ofb, "info_window_tag");
        if (((n)localObject1).ofe)
        {
          ((n)localObject1).mViewManager.setInfoWindowAdapter(new n.a((n)localObject1, (byte)0));
          ((n)localObject1).mViewManager.showInfoWindowByView(((n)localObject1).ofb);
        }
      }
      localObject1 = this.ohS;
      localObject2 = this.ofm;
      ((n)localObject1).nZV = ((LocationInfo)localObject2).nZV;
      ((n)localObject1).nZW = ((LocationInfo)localObject2).nZW;
      if (!e.j(this.ofm.nZV, this.ofm.nZW))
      {
        ab.d("MicroMsg.ViewMapUI", "isValidLatLng %f %f", new Object[] { Double.valueOf(this.ofm.nZV), Double.valueOf(this.ofm.nZW) });
        localObject1 = this.ohS;
        ((n)localObject1).ocy = false;
        ((n)localObject1).ofc.setVisibility(8);
      }
      if (2 == this.type)
      {
        ab.i("MicroMsg.ViewMapUI", "location id %s", new Object[] { this.ofm.nZU });
        if (this.activity.getIntent().getBooleanExtra("kFavCanRemark", true)) {
          bMb();
        }
        if (!bo.isNullOrNil(this.ofm.nZY)) {
          this.ofo.ofB.setVisibility(0);
        }
      }
      this.ofq.put(this.ofm.nZU, this.ohS);
      if (!this.ofm.bLi()) {
        break label697;
      }
      if ((this.eSM != null) && (!this.eSM.equals(""))) {
        this.ohS.eSM = this.eSM;
      }
      this.ohS.setText(this.ohS.getPreText() + this.ofm.nZY);
    }
    for (;;)
    {
      for (;;)
      {
        localObject1 = this.ohS;
        localObject2 = new i.4(this);
        if ((((n)localObject1).ofe) && (((n)localObject1).mViewManager != null)) {
          ((n)localObject1).mViewManager.setMarkerClick(((n)localObject1).ofb, (View.OnClickListener)localObject2);
        }
        AppMethodBeat.o(113749);
        return;
        this.ofo.ofC.setVisibility(8);
        break;
        label599:
        if ((!aa.dsE()) && (!aa.dsD())) {
          break label150;
        }
        this.ohU = false;
        try
        {
          localObject1 = (bwr)new w((float)this.ofm.nZW, (float)this.ofm.nZV, this.cpO).rr.fsV.fta;
          new w((bwr)localObject1);
          g.Rc().a(new w((bwr)localObject1), 0);
        }
        catch (Exception localException)
        {
          ab.e("MicroMsg.ViewMapUI", localException.toString());
        }
      }
      break label150;
      label697:
      if (e.j(this.ofm.nZV, this.ofm.nZW)) {
        this.ofr.a(this.ofm.nZV, this.ofm.nZW, this.ofy, this.ofm.nZU);
      }
    }
  }
  
  public boolean bMf()
  {
    AppMethodBeat.i(113747);
    if ((this.ohT != null) && (this.ohT.isShowing())) {
      this.ohT.cre();
    }
    for (;;)
    {
      AppMethodBeat.o(113747);
      return true;
      bMz();
      this.ohT.crd();
    }
  }
  
  public void bMs() {}
  
  protected void bMt() {}
  
  public void bMu() {}
  
  protected void bMv() {}
  
  final void bMz()
  {
    AppMethodBeat.i(113748);
    this.ohT = new com.tencent.mm.ui.widget.b.d(this.activity, 1, false);
    this.ohT.sao = new i.1(this);
    this.ohT.sap = new i.2(this);
    AppMethodBeat.o(113748);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(113760);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(113760);
      return bool;
      if ((Math.abs(paramMotionEvent.getX() - this.nvl) > 10.0F) || (Math.abs(paramMotionEvent.getY() - this.nvm) > 10.0F))
      {
        this.hPP = true;
        bMs();
        continue;
        this.nvl = paramMotionEvent.getX();
        this.nvm = paramMotionEvent.getY();
        this.oeC = System.currentTimeMillis();
        this.hPP = false;
        bMu();
        continue;
        if (!this.hPP) {
          System.currentTimeMillis();
        }
      }
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(113757);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(113757);
      return;
      com.tencent.mm.plugin.location.ui.d locald = this.ofl;
      Object localObject1;
      switch (paramInt1)
      {
      default: 
        break;
      case 4098: 
        Object localObject2;
        if ((-1 == paramInt2) && (paramIntent != null))
        {
          localObject1 = paramIntent.getStringExtra("selectpkg");
          localObject2 = paramIntent.getBundleExtra("transferback");
          boolean bool = paramIntent.getBooleanExtra("isalways", false);
          paramIntent = ((Bundle)localObject2).getParcelableArrayList("locations");
          locald.a((LocationInfo)paramIntent.get(0), (LocationInfo)paramIntent.get(1), (String)localObject1, bool);
          AppMethodBeat.o(113757);
          return;
        }
        if (4097 == paramInt2)
        {
          if (paramIntent.getBooleanExtra("isalways", false))
          {
            com.tencent.mm.plugin.report.service.h.qsU.e(11091, new Object[] { Integer.valueOf(6), Integer.valueOf(2) });
            paramIntent = paramIntent.getBundleExtra("transferback").getParcelableArrayList("locations");
            localObject1 = (LocationInfo)paramIntent.get(0);
            localObject2 = (LocationInfo)paramIntent.get(1);
            if (!bo.isNullOrNil(((LocationInfo)localObject1).nZZ)) {
              break label482;
            }
          }
          for (paramIntent = "zh-cn";; paramIntent = ((LocationInfo)localObject1).nZZ)
          {
            paramIntent = new Intent("android.intent.action.VIEW", Uri.parse(String.format("http://maps.google.com/maps?f=d&saddr=%f,%f&daddr=%f,%f&hl=".concat(String.valueOf(paramIntent)), new Object[] { Double.valueOf(((LocationInfo)localObject2).nZV), Double.valueOf(((LocationInfo)localObject2).nZW), Double.valueOf(((LocationInfo)localObject1).nZV), Double.valueOf(((LocationInfo)localObject1).nZW) })));
            localObject1 = new Bundle();
            ((Bundle)localObject1).putParcelable("targetintent", paramIntent);
            localObject2 = new Intent();
            ((Intent)localObject2).setClass(locald.context, AppChooserUI.class);
            ((Intent)localObject2).putExtra("type", 1);
            ((Intent)localObject2).putExtra("title", locald.context.getResources().getString(2131301094));
            ((Intent)localObject2).putExtra("targetintent", paramIntent);
            ((Intent)localObject2).putExtra("transferback", (Bundle)localObject1);
            ((Intent)localObject2).putExtra("scene", 6);
            ((Activity)locald.context).startActivityForResult((Intent)localObject2, 4099);
            AppMethodBeat.o(113757);
            return;
            com.tencent.mm.plugin.report.service.h.qsU.e(11091, new Object[] { Integer.valueOf(6), Integer.valueOf(1) });
            break;
          }
        }
        break;
      case 4099: 
        label482:
        if ((-1 == paramInt2) && (paramIntent != null))
        {
          localObject1 = paramIntent.getStringExtra("selectpkg");
          paramIntent = new Intent((Intent)paramIntent.getBundleExtra("transferback").getParcelable("targetintent"));
          paramIntent.setPackage((String)localObject1);
          paramIntent.addFlags(524288);
          locald.context.startActivity(paramIntent);
        }
        break;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(113753);
    super.onCreate(paramBundle);
    double d1 = this.activity.getIntent().getDoubleExtra("kwebmap_slat", 0.0D);
    double d2 = this.activity.getIntent().getDoubleExtra("kwebmap_lng", 0.0D);
    ab.i("MicroMsg.ViewMapUI", "start dslat " + d1 + " " + d2);
    this.nZX = this.activity.getIntent().getIntExtra("kwebmap_scale", 15);
    if (this.nZX <= 0) {
      this.nZX = 15;
    }
    this.eSM = this.activity.getIntent().getStringExtra("kPoiName");
    paramBundle = this.activity.getIntent().getStringExtra("Kwebmap_locaion");
    ab.d("MicroMsg.ViewMapUI", "view " + d1 + " " + d2);
    LocationInfo localLocationInfo = this.ofm;
    localLocationInfo.nZV = d1;
    localLocationInfo.nZW = d2;
    localLocationInfo.nZY = paramBundle;
    localLocationInfo.nZX = this.nZX;
    localLocationInfo.cDl = this.eSM;
    this.cpO = this.activity.getIntent().getLongExtra("kMsgId", -1L);
    this.obp = this.activity.getIntent().getStringExtra("map_talker_name");
    initView();
    AppMethodBeat.o(113753);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113758);
    this.evl.release();
    this.handler.removeCallbacks(this.ohV);
    this.handler = null;
    g.Rc().b(424, this);
    super.onDestroy();
    AppMethodBeat.o(113758);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(113752);
    ab.d("MicroMsg.ViewMapUI", "onbaseGeoResume");
    if (this.ofx != null) {
      this.ofx.c(this.ohW);
    }
    super.onPause();
    AppMethodBeat.o(113752);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(113751);
    super.onResume();
    ab.d("MicroMsg.ViewMapUI", "onbaseGeoResume");
    if (this.ofx != null) {
      this.ofx.b(this.ohW, true);
    }
    AppMethodBeat.o(113751);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(113761);
    ab.d("MicroMsg.ViewMapUI", "onScene end %d %d %d", new Object[] { Integer.valueOf(paramm.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramm.getType() == 424)
    {
      if ((paramInt2 == 0) && (paramInt1 == 0))
      {
        paramString = w.us(((w)paramm).ajW().wzV);
        ab.d("MicroMsg.ViewMapUI", "getUrl success! url is %s", new Object[] { paramString });
        this.ohR = paramString;
        if (!bo.isNullOrNil(paramString)) {
          this.ohU = true;
        }
        if ((this.type == 9) && (!bo.isNullOrNil(paramString)))
        {
          paramString = (TextView)findViewById(2131824807);
          paramString.setVisibility(0);
          paramString.setOnClickListener(new i.8(this));
        }
        AppMethodBeat.o(113761);
      }
    }
    else {
      ab.e("MicroMsg.ViewMapUI", "msg failed.errtype:%d, errcode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    }
    AppMethodBeat.o(113761);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.i
 * JD-Core Version:    0.7.0.1
 */