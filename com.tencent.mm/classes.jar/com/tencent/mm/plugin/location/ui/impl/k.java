package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelsimple.x;
import com.tencent.mm.plugin.k.b;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location.ui.l;
import com.tencent.mm.plugin.location.ui.l.a;
import com.tencent.mm.plugin.location_soso.ViewManager;
import com.tencent.mm.pluginsdk.ui.tools.AppChooserUI;
import com.tencent.mm.pluginsdk.ui.tools.y;
import com.tencent.mm.protocal.protobuf.dqx;
import com.tencent.mm.protocal.protobuf.dqy;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnInfoWindowClickListener;
import java.util.ArrayList;
import java.util.HashMap;

public class k
  extends a
  implements com.tencent.mm.ak.i
{
  private boolean dUo;
  public com.tencent.mm.remoteservice.d gVN;
  private boolean mbo;
  protected long msgId;
  com.tencent.mm.ui.widget.a.e qBG;
  private long yKl;
  private String yOk;
  l yOl;
  boolean yOm;
  private Runnable yOn;
  private b.a yOo;
  
  public k(Activity paramActivity)
  {
    super(paramActivity);
    AppMethodBeat.i(56208);
    this.msgId = -1L;
    this.yOk = "";
    this.dUo = true;
    this.gVN = new com.tencent.mm.remoteservice.d(this.activity);
    this.yOm = false;
    this.yOo = new b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(56205);
        if (!paramAnonymousBoolean)
        {
          AppMethodBeat.o(56205);
          return false;
        }
        Log.d("MicroMsg.ViewMapUI", "onGetLocation flong " + paramAnonymousFloat1 + " flat " + paramAnonymousFloat2);
        if ((paramAnonymousFloat2 == 0.0D) && (paramAnonymousFloat1 == 0.0D))
        {
          AppMethodBeat.o(56205);
          return true;
        }
        Log.d("MicroMsg.ViewMapUI", "myLocation " + k.this.lXl.yFu + " " + k.this.lXl.yFv);
        Log.d("MicroMsg.ViewMapUI", "location my show");
        k.this.lXl.yFu = paramAnonymousFloat2;
        k.this.lXl.yFv = paramAnonymousFloat1;
        k.this.yKY.a(k.this.lXl.yFu, k.this.lXl.yFv, k.this.yLe, k.this.lXl.yFt);
        AppMethodBeat.o(56205);
        return true;
      }
    };
    this.mbo = false;
    this.yKl = 0L;
    g.azz().a(424, this);
    AppMethodBeat.o(56208);
  }
  
  private Intent eei()
  {
    AppMethodBeat.i(56211);
    Intent localIntent = new Intent();
    localIntent.putExtra("kfavorite", true);
    localIntent.putExtra("kopenGmapNums", this.lXm.yHB);
    localIntent.putExtra("kopenOthersNums", this.lXm.yHC);
    localIntent.putExtra("kopenreportType", this.lXm.dYn);
    localIntent.putExtra("kRemark", edE());
    localIntent.putExtra("kwebmap_slat", this.lXk.yFu);
    localIntent.putExtra("kwebmap_lng", this.lXk.yFv);
    localIntent.putExtra("Kwebmap_locaion", this.lXk.yFx);
    localIntent.putExtra("kPoiName", this.kHV);
    AppMethodBeat.o(56211);
    return localIntent;
  }
  
  protected final String bmB()
  {
    AppMethodBeat.i(56222);
    String str = getString(2131762469);
    AppMethodBeat.o(56222);
    return str;
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(56223);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(56223);
      return bool;
      if ((Math.abs(paramMotionEvent.getX() - this.aTD) > 10.0F) || (Math.abs(paramMotionEvent.getY() - this.aTE) > 10.0F))
      {
        this.mbo = true;
        edY();
        continue;
        this.aTD = paramMotionEvent.getX();
        this.aTE = paramMotionEvent.getY();
        this.yKl = System.currentTimeMillis();
        this.mbo = false;
        eeb();
        continue;
        if (!this.mbo) {
          System.currentTimeMillis();
        }
      }
    }
  }
  
  protected void edF()
  {
    AppMethodBeat.i(56217);
    Intent localIntent = new Intent();
    localIntent.putExtra("kopenGmapNums", this.lXm.yHB);
    localIntent.putExtra("kopenOthersNums", this.lXm.yHC);
    localIntent.putExtra("kopenreportType", this.lXm.dYn);
    localIntent.putExtra("kRemark", edE());
    localIntent.putExtra("soso_street_view_url", this.yOk);
    this.activity.setResult(-1, localIntent);
    AppMethodBeat.o(56217);
  }
  
  void edG()
  {
    AppMethodBeat.i(56212);
    this.yKV.yLk.setEnabled(true);
    this.yKV.yLg.setVisibility(8);
    c(this.lXk);
    this.yKV.yHR.getIController().setZoom(this.yFw);
    this.yKV.yLi.setEnabled(true);
    this.dUo = this.activity.getIntent().getBooleanExtra("kShowshare", true);
    label150:
    Object localObject1;
    Object localObject2;
    if (this.dUo)
    {
      this.yKV.yLi.setVisibility(0);
      this.yOk = this.activity.getIntent().getStringExtra("soso_street_view_url");
      if ((Util.isNullOrNil(this.yOk)) || ((!LocaleUtil.isTraditionalChineseAppLang()) && (!LocaleUtil.isSimplifiedChineseAppLang()))) {
        break label601;
      }
      this.yOm = true;
      this.yKV.yLi.setOnClickListener(new k.3(this));
      this.yOl = new l(this.yKV.yHR, this.activity);
      localObject1 = this.yOl;
      if (((l)localObject1).mViewManager != null)
      {
        ((l)localObject1).mViewManager.addView(((l)localObject1).yKM, 0.0D, 0.0D);
        ((l)localObject1).mViewManager.setMarkerTag(((l)localObject1).yKM, "info_window_tag");
        if (((l)localObject1).yKP)
        {
          ((l)localObject1).mViewManager.setInfoWindowAdapter(new l.a((l)localObject1, (byte)0));
          ((l)localObject1).mViewManager.showInfoWindowByView(((l)localObject1).yKM);
        }
      }
      localObject1 = this.yOl;
      localObject2 = this.lXk;
      ((l)localObject1).yFu = ((LocationInfo)localObject2).yFu;
      ((l)localObject1).yFv = ((LocationInfo)localObject2).yFv;
      if (!com.tencent.mm.plugin.location.model.e.j(this.lXk.yFu, this.lXk.yFv))
      {
        Log.d("MicroMsg.ViewMapUI", "isValidLatLng %f %f", new Object[] { Double.valueOf(this.lXk.yFu), Double.valueOf(this.lXk.yFv) });
        localObject1 = this.yOl;
        ((l)localObject1).yHP = false;
        ((l)localObject1).yKN.setVisibility(8);
      }
      if (2 == this.type)
      {
        Log.i("MicroMsg.ViewMapUI", "location id %s", new Object[] { this.lXk.yFt });
        if (this.activity.getIntent().getBooleanExtra("kFavCanRemark", true)) {
          edD();
        }
        if (!Util.isNullOrNil(this.lXk.yFx)) {
          this.yKV.yLh.setVisibility(0);
        }
      }
      this.yKX.put(this.lXk.yFt, this.yOl);
      if (!this.lXk.ecI()) {
        break label700;
      }
      if ((this.kHV != null) && (!this.kHV.equals(""))) {
        this.yOl.kHV = this.kHV;
      }
      this.yOl.setText(this.yOl.getPreText() + this.lXk.yFx);
    }
    for (;;)
    {
      for (;;)
      {
        localObject1 = this.yOl;
        localObject2 = new TencentMap.OnInfoWindowClickListener()
        {
          public final void onInfoWindowClick(Marker paramAnonymousMarker)
          {
            AppMethodBeat.i(56204);
            k.this.dKf = 0;
            k.this.edZ();
            k.this.eel();
            AppMethodBeat.o(56204);
          }
        };
        if ((((l)localObject1).yKP) && (((l)localObject1).mViewManager != null)) {
          ((l)localObject1).mViewManager.setInfoWindowClick(((l)localObject1).yKM, (TencentMap.OnInfoWindowClickListener)localObject2);
        }
        AppMethodBeat.o(56212);
        return;
        this.yKV.yLi.setVisibility(8);
        break;
        label601:
        if ((!LocaleUtil.isTraditionalChineseAppLang()) && (!LocaleUtil.isSimplifiedChineseAppLang())) {
          break label150;
        }
        this.yOm = false;
        try
        {
          localObject1 = (dqx)new x((float)this.lXk.yFv, (float)this.lXk.yFu, this.msgId).rr.iLK.iLR;
          new x((dqx)localObject1);
          g.azz().a(new x((dqx)localObject1), 0);
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.ViewMapUI", localException.toString());
        }
      }
      break label150;
      label700:
      if (com.tencent.mm.plugin.location.model.e.j(this.lXk.yFu, this.lXk.yFv)) {
        this.yKY.a(this.lXk.yFu, this.lXk.yFv, this.yLe, this.lXk.yFt);
      }
    }
  }
  
  public boolean edH()
  {
    AppMethodBeat.i(56209);
    if ((this.qBG != null) && (this.qBG.isShowing())) {
      this.qBG.bMo();
    }
    for (;;)
    {
      AppMethodBeat.o(56209);
      return true;
      eeh();
      this.qBG.dGm();
    }
  }
  
  public void edY() {}
  
  protected void edZ() {}
  
  public void eeb() {}
  
  protected void eec() {}
  
  final void eeh()
  {
    AppMethodBeat.i(56210);
    this.qBG = new com.tencent.mm.ui.widget.a.e(this.activity, 1, false);
    this.qBG.HLX = new k.1(this);
    this.qBG.HLY = new k.2(this);
    AppMethodBeat.o(56210);
  }
  
  protected final void eej()
  {
    AppMethodBeat.i(56213);
    if (this.yOm)
    {
      y.a(new com.tencent.mm.pluginsdk.ui.tools.i());
      Intent localIntent = new Intent();
      localIntent.putExtra("show_bottom", false);
      localIntent.putExtra("jsapi_args_appid", "wx751a1acca5688ba3");
      localIntent.putExtra("rawUrl", this.yOk);
      localIntent.putExtra("title", 2131764909);
      localIntent.putExtra("webview_bg_color_rsID", 2131100042);
      com.tencent.mm.br.c.b(this.activity, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent);
    }
    AppMethodBeat.o(56213);
  }
  
  protected final void eek()
  {
    AppMethodBeat.i(56218);
    Log.d("MicroMsg.ViewMapUI", "directlyFavorite lat %s, long %s, scale", new Object[] { Double.valueOf(this.lXk.yFu), Double.valueOf(this.lXk.yFv) });
    Intent localIntent = eei();
    this.activity.setResult(-1, localIntent);
    this.activity.getIntent().getIntExtra("MMActivity.OverrideEnterAnimation", -1);
    this.activity.getIntent().getIntExtra("MMActivity.OverrideExitAnimation", -1);
    this.activity.finish();
    AppMethodBeat.o(56218);
  }
  
  protected final void eel()
  {
    AppMethodBeat.i(56219);
    Log.d("MicroMsg.ViewMapUI", "locationLine, locationInfo.slat=%f, locationInfo.slong=%f, myLocation.slat=%f, myLocation.slong=%f", new Object[] { Double.valueOf(this.lXk.yFu), Double.valueOf(this.lXk.yFv), Double.valueOf(this.lXl.yFu), Double.valueOf(this.lXl.yFv) });
    if (this.lXl.ecH())
    {
      eec();
      AppMethodBeat.o(56219);
      return;
    }
    com.tencent.mm.plugin.report.service.h.CyF.a(12809, new Object[] { Integer.valueOf(3), "" });
    this.yKZ = true;
    if (this.handler == null)
    {
      AppMethodBeat.o(56219);
      return;
    }
    if (this.yOn != null) {
      this.handler.removeCallbacks(this.yOn);
    }
    this.yOn = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(56206);
        if (k.this.yKZ)
        {
          if (k.this.gtM != null) {
            k.this.gtM.dismiss();
          }
          k.this.eec();
        }
        k.this.yKZ = false;
        AppMethodBeat.o(56206);
      }
    };
    this.handler.postDelayed(this.yOn, 10000L);
    Activity localActivity = this.activity;
    getString(2131755998);
    this.gtM = com.tencent.mm.ui.base.h.a(localActivity, getString(2131761445), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        k.this.yKZ = false;
      }
    });
    AppMethodBeat.o(56219);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(56220);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(56220);
      return;
      Object localObject1 = this.lXm;
      Object localObject2;
      switch (paramInt1)
      {
      default: 
        break;
      case 4098: 
        Object localObject3;
        if ((-1 == paramInt2) && (paramIntent != null))
        {
          localObject2 = paramIntent.getStringExtra("selectpkg");
          localObject3 = paramIntent.getBundleExtra("transferback");
          boolean bool = paramIntent.getBooleanExtra("isalways", false);
          paramIntent = ((Bundle)localObject3).getParcelableArrayList("locations");
          ((com.tencent.mm.plugin.location.ui.d)localObject1).a((LocationInfo)paramIntent.get(0), (LocationInfo)paramIntent.get(1), (String)localObject2, bool);
          AppMethodBeat.o(56220);
          return;
        }
        if (4097 == paramInt2)
        {
          if (paramIntent.getBooleanExtra("isalways", false))
          {
            com.tencent.mm.plugin.report.service.h.CyF.a(11091, new Object[] { Integer.valueOf(6), Integer.valueOf(2) });
            paramIntent = paramIntent.getBundleExtra("transferback").getParcelableArrayList("locations");
            localObject2 = (LocationInfo)paramIntent.get(0);
            localObject3 = (LocationInfo)paramIntent.get(1);
            if (!Util.isNullOrNil(((LocationInfo)localObject2).yFy)) {
              break label483;
            }
          }
          for (paramIntent = "zh-cn";; paramIntent = ((LocationInfo)localObject2).yFy)
          {
            paramIntent = new Intent("android.intent.action.VIEW", Uri.parse(String.format("http://maps.google.com/maps?f=d&saddr=%f,%f&daddr=%f,%f&hl=".concat(String.valueOf(paramIntent)), new Object[] { Double.valueOf(((LocationInfo)localObject3).yFu), Double.valueOf(((LocationInfo)localObject3).yFv), Double.valueOf(((LocationInfo)localObject2).yFu), Double.valueOf(((LocationInfo)localObject2).yFv) })));
            localObject2 = new Bundle();
            ((Bundle)localObject2).putParcelable("targetintent", paramIntent);
            localObject3 = new Intent();
            ((Intent)localObject3).setClass(((com.tencent.mm.plugin.location.ui.d)localObject1).context, AppChooserUI.class);
            ((Intent)localObject3).putExtra("type", 1);
            ((Intent)localObject3).putExtra("title", ((com.tencent.mm.plugin.location.ui.d)localObject1).context.getResources().getString(2131762458));
            ((Intent)localObject3).putExtra("targetintent", paramIntent);
            ((Intent)localObject3).putExtra("transferback", (Bundle)localObject2);
            ((Intent)localObject3).putExtra("scene", 6);
            ((Activity)((com.tencent.mm.plugin.location.ui.d)localObject1).context).startActivityForResult((Intent)localObject3, 4099);
            AppMethodBeat.o(56220);
            return;
            com.tencent.mm.plugin.report.service.h.CyF.a(11091, new Object[] { Integer.valueOf(6), Integer.valueOf(1) });
            break;
          }
        }
        break;
      case 4099: 
        label483:
        if ((-1 == paramInt2) && (paramIntent != null))
        {
          localObject2 = paramIntent.getStringExtra("selectpkg");
          paramIntent = new Intent((Intent)paramIntent.getBundleExtra("transferback").getParcelable("targetintent"));
          paramIntent.setPackage((String)localObject2);
          paramIntent.addFlags(524288);
          localObject1 = ((com.tencent.mm.plugin.location.ui.d)localObject1).context;
          paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent);
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, paramIntent.axQ(), "com/tencent/mm/plugin/location/ui/MapHelper", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Context)localObject1).startActivity((Intent)paramIntent.pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/location/ui/MapHelper", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        break;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(56216);
    super.onCreate(paramBundle);
    double d1 = this.activity.getIntent().getDoubleExtra("kwebmap_slat", 0.0D);
    double d2 = this.activity.getIntent().getDoubleExtra("kwebmap_lng", 0.0D);
    Log.i("MicroMsg.ViewMapUI", "start dslat " + d1 + " " + d2);
    this.yFw = this.activity.getIntent().getIntExtra("kwebmap_scale", 15);
    if (this.yFw <= 0) {
      this.yFw = 15;
    }
    this.kHV = this.activity.getIntent().getStringExtra("kPoiName");
    paramBundle = this.activity.getIntent().getStringExtra("Kwebmap_locaion");
    Log.d("MicroMsg.ViewMapUI", "view " + d1 + " " + d2);
    LocationInfo localLocationInfo = this.lXk;
    localLocationInfo.yFu = d1;
    localLocationInfo.yFv = d2;
    localLocationInfo.yFx = paramBundle;
    localLocationInfo.yFw = this.yFw;
    localLocationInfo.dWi = this.kHV;
    this.msgId = this.activity.getIntent().getLongExtra("kMsgId", -1L);
    this.rgD = this.activity.getIntent().getStringExtra("map_talker_name");
    initView();
    AppMethodBeat.o(56216);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(56221);
    this.gVN.release();
    this.handler.removeCallbacks(this.yOn);
    this.handler = null;
    g.azz().b(424, this);
    super.onDestroy();
    AppMethodBeat.o(56221);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(56215);
    Log.d("MicroMsg.ViewMapUI", "onbaseGeoResume");
    if (this.yLd != null) {
      this.yLd.c(this.yOo);
    }
    super.onPause();
    AppMethodBeat.o(56215);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(56214);
    super.onResume();
    Log.d("MicroMsg.ViewMapUI", "onbaseGeoResume");
    if (this.yLd != null) {
      this.yLd.b(this.yOo, true);
    }
    AppMethodBeat.o(56214);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(56224);
    Log.d("MicroMsg.ViewMapUI", "onScene end %d %d %d", new Object[] { Integer.valueOf(paramq.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramq.getType() == 424)
    {
      if ((paramInt2 == 0) && (paramInt1 == 0))
      {
        paramString = x.PE(((x)paramq).bfB().MbV);
        Log.d("MicroMsg.ViewMapUI", "getUrl success! url is %s", new Object[] { paramString });
        this.yOk = paramString;
        if (!Util.isNullOrNil(paramString)) {
          this.yOm = true;
        }
        if ((this.type == 9) && (!Util.isNullOrNil(paramString)))
        {
          paramString = (TextView)findViewById(2131308711);
          paramString.setVisibility(0);
          paramString.setOnClickListener(new k.8(this));
        }
        AppMethodBeat.o(56224);
      }
    }
    else {
      Log.e("MicroMsg.ViewMapUI", "msg failed.errtype:%d, errcode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    }
    AppMethodBeat.o(56224);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.k
 * JD-Core Version:    0.7.0.1
 */