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
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelsimple.y;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location.model.e;
import com.tencent.mm.plugin.location.ui.l;
import com.tencent.mm.plugin.location.ui.l.a;
import com.tencent.mm.plugin.location_soso.ViewManager;
import com.tencent.mm.plugin.map.a.b;
import com.tencent.mm.plugin.map.a.e;
import com.tencent.mm.plugin.map.a.i;
import com.tencent.mm.pluginsdk.ui.tools.AppChooserUI;
import com.tencent.mm.pluginsdk.ui.tools.z;
import com.tencent.mm.protocal.protobuf.euc;
import com.tencent.mm.protocal.protobuf.eud;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sensitive.d.e;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnInfoWindowClickListener;
import java.util.ArrayList;
import java.util.HashMap;

public class k
  extends a
  implements com.tencent.mm.am.h, d.e
{
  private long KgK;
  private String KkO;
  l KkP;
  boolean KkQ;
  private Runnable KkR;
  private b.a KkS;
  private boolean hTH;
  protected long msgId;
  public com.tencent.mm.remoteservice.d pfZ;
  private boolean seH;
  private f xdY;
  
  public k(Activity paramActivity)
  {
    super(paramActivity);
    AppMethodBeat.i(56208);
    this.msgId = -1L;
    this.KkO = "";
    this.hTH = true;
    this.pfZ = new com.tencent.mm.remoteservice.d(this.activity);
    this.KkQ = false;
    this.KkS = new b.a()
    {
      public final boolean onGetLocation(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2, double paramAnonymousDouble3)
      {
        AppMethodBeat.i(264984);
        if (!paramAnonymousBoolean)
        {
          AppMethodBeat.o(264984);
          return false;
        }
        Log.d("MicroMsg.ViewMapUI", "onGetLocation flong " + paramAnonymousFloat1 + " flat " + paramAnonymousFloat2);
        if ((paramAnonymousFloat2 == 0.0D) && (paramAnonymousFloat1 == 0.0D))
        {
          AppMethodBeat.o(264984);
          return true;
        }
        Log.d("MicroMsg.ViewMapUI", "myLocation " + k.this.saj.KbW + " " + k.this.saj.KbX);
        Log.d("MicroMsg.ViewMapUI", "location my show");
        k.this.saj.KbW = paramAnonymousFloat2;
        k.this.saj.KbX = paramAnonymousFloat1;
        k.this.Khx.a(k.this.saj.KbW, k.this.saj.KbX, k.this.KhE, k.this.saj.KbV);
        AppMethodBeat.o(264984);
        return true;
      }
    };
    this.seH = false;
    this.KgK = 0L;
    com.tencent.mm.kernel.h.aZW().a(424, this);
    AppMethodBeat.o(56208);
  }
  
  private void cxR()
  {
    AppMethodBeat.i(56210);
    this.xdY = new f(this.activity, 1, false);
    this.xdY.Vtg = new k.1(this);
    this.xdY.GAC = new k.2(this);
    AppMethodBeat.o(56210);
  }
  
  private Intent fVV()
  {
    AppMethodBeat.i(56211);
    Intent localIntent = new Intent();
    localIntent.putExtra("kfavorite", true);
    localIntent.putExtra("kopenGmapNums", this.sak.Ked);
    localIntent.putExtra("kopenOthersNums", this.sak.Kee);
    localIntent.putExtra("kopenreportType", this.sak.hYb);
    localIntent.putExtra("kRemark", fVs());
    localIntent.putExtra("kwebmap_slat", this.sai.KbW);
    localIntent.putExtra("kwebmap_lng", this.sai.KbX);
    localIntent.putExtra("Kwebmap_locaion", this.sai.KbZ);
    localIntent.putExtra("kPoiName", this.poiName);
    AppMethodBeat.o(56211);
    return localIntent;
  }
  
  protected final String bVz()
  {
    AppMethodBeat.i(56222);
    String str = getString(a.i.location_see_info);
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
      if ((Math.abs(paramMotionEvent.getX() - this.cxM) > 10.0F) || (Math.abs(paramMotionEvent.getY() - this.cxN) > 10.0F))
      {
        this.seH = true;
        fVM();
        continue;
        this.cxM = paramMotionEvent.getX();
        this.cxN = paramMotionEvent.getY();
        this.KgK = System.currentTimeMillis();
        this.seH = false;
        fVP();
        continue;
        if (!this.seH) {
          System.currentTimeMillis();
        }
      }
    }
  }
  
  public void fVM() {}
  
  protected void fVN() {}
  
  public void fVP() {}
  
  protected void fVQ() {}
  
  protected final void fVW()
  {
    AppMethodBeat.i(56213);
    if (this.KkQ)
    {
      z.a(new com.tencent.mm.pluginsdk.ui.tools.h());
      Intent localIntent = new Intent();
      localIntent.putExtra("show_bottom", false);
      localIntent.putExtra("jsapi_args_appid", "wx751a1acca5688ba3");
      localIntent.putExtra("rawUrl", this.KkO);
      localIntent.putExtra("title", a.i.scan_entry_street);
      localIntent.putExtra("webview_bg_color_rsID", a.b.black);
      com.tencent.mm.br.c.b(this.activity, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent);
    }
    AppMethodBeat.o(56213);
  }
  
  protected final void fVX()
  {
    AppMethodBeat.i(56218);
    Log.d("MicroMsg.ViewMapUI", "directlyFavorite lat %s, long %s, scale", new Object[] { Double.valueOf(this.sai.KbW), Double.valueOf(this.sai.KbX) });
    Intent localIntent = fVV();
    this.activity.setResult(-1, localIntent);
    this.activity.getIntent().getIntExtra("MMActivity.OverrideEnterAnimation", -1);
    this.activity.getIntent().getIntExtra("MMActivity.OverrideExitAnimation", -1);
    this.activity.finish();
    AppMethodBeat.o(56218);
  }
  
  protected final void fVY()
  {
    AppMethodBeat.i(56219);
    Log.d("MicroMsg.ViewMapUI", "locationLine, locationInfo.slat=%f, locationInfo.slong=%f, myLocation.slat=%f, myLocation.slong=%f", new Object[] { Double.valueOf(this.sai.KbW), Double.valueOf(this.sai.KbX), Double.valueOf(this.saj.KbW), Double.valueOf(this.saj.KbX) });
    if (this.saj.fUs())
    {
      fVQ();
      AppMethodBeat.o(56219);
      return;
    }
    com.tencent.mm.plugin.report.service.h.OAn.b(12809, new Object[] { Integer.valueOf(3), "" });
    this.Khy = true;
    if (this.handler == null)
    {
      AppMethodBeat.o(56219);
      return;
    }
    if (this.KkR != null) {
      this.handler.removeCallbacks(this.KkR);
    }
    this.KkR = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(56206);
        if (k.this.Khy)
        {
          if (k.this.lzP != null) {
            k.this.lzP.dismiss();
          }
          k.this.fVQ();
        }
        k.this.Khy = false;
        AppMethodBeat.o(56206);
      }
    };
    this.handler.postDelayed(this.KkR, 10000L);
    Activity localActivity = this.activity;
    getString(a.i.app_tip);
    this.lzP = com.tencent.mm.ui.base.k.a(localActivity, getString(a.i.get_location), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        k.this.Khy = false;
      }
    });
    AppMethodBeat.o(56219);
  }
  
  protected void fVt()
  {
    AppMethodBeat.i(56217);
    Intent localIntent = new Intent();
    localIntent.putExtra("kopenGmapNums", this.sak.Ked);
    localIntent.putExtra("kopenOthersNums", this.sak.Kee);
    localIntent.putExtra("kopenreportType", this.sak.hYb);
    localIntent.putExtra("kRemark", fVs());
    localIntent.putExtra("soso_street_view_url", this.KkO);
    this.activity.setResult(-1, localIntent);
    AppMethodBeat.o(56217);
  }
  
  void fVu()
  {
    AppMethodBeat.i(56212);
    this.Khu.KhK.setEnabled(true);
    this.Khu.KhG.setVisibility(8);
    c(this.sai);
    this.Khu.Ket.getIController().setZoom(this.KbY);
    this.Khu.KhI.setEnabled(true);
    this.hTH = this.activity.getIntent().getBooleanExtra("kShowshare", true);
    label150:
    Object localObject1;
    Object localObject2;
    if (this.hTH)
    {
      this.Khu.KhI.setVisibility(0);
      this.KkO = this.activity.getIntent().getStringExtra("soso_street_view_url");
      if ((Util.isNullOrNil(this.KkO)) || ((!LocaleUtil.isTraditionalChineseAppLang()) && (!LocaleUtil.isSimplifiedChineseAppLang()))) {
        break label601;
      }
      this.KkQ = true;
      this.Khu.KhI.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(56203);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/location/ui/impl/ViewMapUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          k.b(k.this);
          k.c(k.this).dDn();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/location/ui/impl/ViewMapUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(56203);
        }
      });
      this.KkP = new l(this.Khu.Ket, this.activity);
      localObject1 = this.KkP;
      if (((l)localObject1).mViewManager != null)
      {
        ((l)localObject1).mViewManager.addView(((l)localObject1).Khl, 0.0D, 0.0D);
        ((l)localObject1).mViewManager.setMarkerTag(((l)localObject1).Khl, "info_window_tag");
        if (((l)localObject1).Kho)
        {
          ((l)localObject1).mViewManager.setInfoWindowAdapter(new l.a((l)localObject1, (byte)0));
          ((l)localObject1).mViewManager.showInfoWindowByView(((l)localObject1).Khl);
        }
      }
      localObject1 = this.KkP;
      localObject2 = this.sai;
      ((l)localObject1).KbW = ((LocationInfo)localObject2).KbW;
      ((l)localObject1).KbX = ((LocationInfo)localObject2).KbX;
      if (!e.m(this.sai.KbW, this.sai.KbX))
      {
        Log.d("MicroMsg.ViewMapUI", "isValidLatLng %f %f", new Object[] { Double.valueOf(this.sai.KbW), Double.valueOf(this.sai.KbX) });
        localObject1 = this.KkP;
        ((l)localObject1).Ker = false;
        ((l)localObject1).Khm.setVisibility(8);
      }
      if (2 == this.type)
      {
        Log.i("MicroMsg.ViewMapUI", "location id %s", new Object[] { this.sai.KbV });
        if (this.activity.getIntent().getBooleanExtra("kFavCanRemark", true)) {
          fVr();
        }
        if (!Util.isNullOrNil(this.sai.KbZ)) {
          this.Khu.KhH.setVisibility(0);
        }
      }
      this.Khw.put(this.sai.KbV, this.KkP);
      if (!this.sai.fUt()) {
        break label700;
      }
      if ((this.poiName != null) && (!this.poiName.equals(""))) {
        this.KkP.poiName = this.poiName;
      }
      this.KkP.setText(this.KkP.getPreText() + this.sai.KbZ);
    }
    for (;;)
    {
      for (;;)
      {
        localObject1 = this.KkP;
        localObject2 = new TencentMap.OnInfoWindowClickListener()
        {
          public final void onInfoWindowClick(Marker paramAnonymousMarker)
          {
            AppMethodBeat.i(56204);
            k.this.hHJ = 0;
            k.this.fVN();
            k.this.fVY();
            AppMethodBeat.o(56204);
          }
        };
        if ((((l)localObject1).Kho) && (((l)localObject1).mViewManager != null)) {
          ((l)localObject1).mViewManager.setInfoWindowClick(((l)localObject1).Khl, (TencentMap.OnInfoWindowClickListener)localObject2);
        }
        AppMethodBeat.o(56212);
        return;
        this.Khu.KhI.setVisibility(8);
        break;
        label601:
        if ((!LocaleUtil.isTraditionalChineseAppLang()) && (!LocaleUtil.isSimplifiedChineseAppLang())) {
          break label150;
        }
        this.KkQ = false;
        try
        {
          localObject1 = (euc)c.b.b(new y((float)this.sai.KbX, (float)this.sai.KbW, this.msgId).rr.otB);
          new y((euc)localObject1);
          com.tencent.mm.kernel.h.aZW().a(new y((euc)localObject1), 0);
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.ViewMapUI", localException.toString());
        }
      }
      break label150;
      label700:
      if (e.m(this.sai.KbW, this.sai.KbX)) {
        this.Khx.a(this.sai.KbW, this.sai.KbX, this.KhE, this.sai.KbV);
      }
    }
  }
  
  public boolean fVv()
  {
    AppMethodBeat.i(56209);
    if ((this.xdY != null) && (this.xdY.isShowing())) {
      this.xdY.cyW();
    }
    for (;;)
    {
      AppMethodBeat.o(56209);
      return true;
      cxR();
      this.xdY.dDn();
    }
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
      Object localObject1 = this.sak;
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
            com.tencent.mm.plugin.report.service.h.OAn.b(11091, new Object[] { Integer.valueOf(6), Integer.valueOf(2) });
            paramIntent = paramIntent.getBundleExtra("transferback").getParcelableArrayList("locations");
            localObject2 = (LocationInfo)paramIntent.get(0);
            localObject3 = (LocationInfo)paramIntent.get(1);
            if (!Util.isNullOrNil(((LocationInfo)localObject2).Kca)) {
              break label518;
            }
          }
          for (paramIntent = "zh-cn";; paramIntent = ((LocationInfo)localObject2).Kca)
          {
            paramIntent = new Intent("android.intent.action.VIEW", Uri.parse(String.format("http://maps.google.com/maps?f=d&saddr=%f,%f&daddr=%f,%f&hl=".concat(String.valueOf(paramIntent)), new Object[] { Double.valueOf(((LocationInfo)localObject3).KbW), Double.valueOf(((LocationInfo)localObject3).KbX), Double.valueOf(((LocationInfo)localObject2).KbW), Double.valueOf(((LocationInfo)localObject2).KbX) })));
            localObject2 = new Bundle();
            ((Bundle)localObject2).putParcelable("targetintent", paramIntent);
            localObject3 = new Intent();
            ((Intent)localObject3).setClass(((com.tencent.mm.plugin.location.ui.d)localObject1).context, AppChooserUI.class);
            ((Intent)localObject3).putExtra("type", 1);
            ((Intent)localObject3).putExtra("title", ((com.tencent.mm.plugin.location.ui.d)localObject1).context.getResources().getString(a.i.location_info_send_tip));
            ((Intent)localObject3).putExtra("targetintent", paramIntent);
            ((Intent)localObject3).putExtra("transferback", (Bundle)localObject2);
            ((Intent)localObject3).putExtra("scene", 6);
            com.tencent.mm.hellhoundlib.a.a.a((Activity)((com.tencent.mm.plugin.location.ui.d)localObject1).context, com.tencent.mm.hellhoundlib.b.c.a(4099, new com.tencent.mm.hellhoundlib.b.a()).cG(localObject3).aYi(), "com/tencent/mm/plugin/location/ui/MapHelper", "webMap", "(Lcom/tencent/mm/plugin/location/model/LocationInfo;Lcom/tencent/mm/plugin/location/model/LocationInfo;)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
            AppMethodBeat.o(56220);
            return;
            com.tencent.mm.plugin.report.service.h.OAn.b(11091, new Object[] { Integer.valueOf(6), Integer.valueOf(1) });
            break;
          }
        }
        break;
      case 4099: 
        label518:
        if ((-1 == paramInt2) && (paramIntent != null))
        {
          localObject2 = paramIntent.getStringExtra("selectpkg");
          paramIntent = new Intent((Intent)paramIntent.getBundleExtra("transferback").getParcelable("targetintent"));
          paramIntent.setPackage((String)localObject2);
          paramIntent.addFlags(524288);
          localObject1 = ((com.tencent.mm.plugin.location.ui.d)localObject1).context;
          paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
          com.tencent.mm.hellhoundlib.a.a.b(localObject1, paramIntent.aYi(), "com/tencent/mm/plugin/location/ui/MapHelper", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Context)localObject1).startActivity((Intent)paramIntent.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/location/ui/MapHelper", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        break;
      }
    }
  }
  
  public void onBusinessPermissionDenied(String paramString) {}
  
  public void onBusinessPermissionGranted(String paramString) {}
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(56216);
    super.onCreate(paramBundle);
    double d1 = this.activity.getIntent().getDoubleExtra("kwebmap_slat", 0.0D);
    double d2 = this.activity.getIntent().getDoubleExtra("kwebmap_lng", 0.0D);
    Log.i("MicroMsg.ViewMapUI", "start dslat " + d1 + " " + d2);
    this.KbY = this.activity.getIntent().getIntExtra("kwebmap_scale", 15);
    if (this.KbY <= 0) {
      this.KbY = 15;
    }
    this.poiName = this.activity.getIntent().getStringExtra("kPoiName");
    paramBundle = this.activity.getIntent().getStringExtra("Kwebmap_locaion");
    Log.d("MicroMsg.ViewMapUI", "view " + d1 + " " + d2);
    LocationInfo localLocationInfo = this.sai;
    localLocationInfo.KbW = d1;
    localLocationInfo.KbX = d2;
    localLocationInfo.KbZ = paramBundle;
    localLocationInfo.KbY = this.KbY;
    localLocationInfo.hVI = this.poiName;
    this.msgId = this.activity.getIntent().getLongExtra("kMsgId", -1L);
    this.mpr = this.activity.getIntent().getStringExtra("map_talker_name");
    initView();
    AppMethodBeat.o(56216);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(56221);
    this.pfZ.release();
    this.handler.removeCallbacks(this.KkR);
    this.handler = null;
    com.tencent.mm.kernel.h.aZW().b(424, this);
    super.onDestroy();
    AppMethodBeat.o(56221);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(56215);
    Log.d("MicroMsg.ViewMapUI", "onbaseGeoResume");
    if (this.KhD != null) {
      this.KhD.a(this.KkS);
    }
    super.onPause();
    AppMethodBeat.o(56215);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(56214);
    super.onResume();
    Log.d("MicroMsg.ViewMapUI", "onbaseGeoResume");
    if (this.KhD != null) {
      this.KhD.a(this.KkS, true);
    }
    AppMethodBeat.o(56214);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(56224);
    Log.d("MicroMsg.ViewMapUI", "onScene end %d %d %d", new Object[] { Integer.valueOf(paramp.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramp.getType() == 424)
    {
      if ((paramInt2 == 0) && (paramInt1 == 0))
      {
        paramString = y.Pc(((y)paramp).bMy().aazh);
        Log.d("MicroMsg.ViewMapUI", "getUrl success! url is %s", new Object[] { paramString });
        this.KkO = paramString;
        if (!Util.isNullOrNil(paramString)) {
          this.KkQ = true;
        }
        if ((this.type == 9) && (!Util.isNullOrNil(paramString)))
        {
          paramString = (TextView)findViewById(a.e.street_tv);
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