package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.cr;
import com.tencent.mm.g.a.cr.b;
import com.tencent.mm.g.a.ec;
import com.tencent.mm.g.a.ec.b;
import com.tencent.mm.g.a.nk;
import com.tencent.mm.model.v;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location.ui.l.a;
import com.tencent.mm.plugin.location_soso.ViewManager;
import com.tencent.mm.pluginsdk.ui.tools.AppChooserUI;
import com.tencent.mm.pluginsdk.ui.tools.w;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.ajy;
import com.tencent.mm.protocal.protobuf.akh;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.protocal.protobuf.akp;
import com.tencent.mm.protocal.protobuf.akt;
import com.tencent.mm.protocal.protobuf.cyc;
import com.tencent.mm.protocal.protobuf.cyd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnInfoWindowClickListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class k
  extends a
  implements f
{
  private boolean dCy;
  public com.tencent.mm.remoteservice.d gkS;
  private boolean kWf;
  protected long msgId;
  private long vqv;
  private b.a vuA;
  private String vuv;
  com.tencent.mm.plugin.location.ui.l vuw;
  com.tencent.mm.ui.widget.a.e vux;
  boolean vuy;
  private Runnable vuz;
  
  public k(Activity paramActivity)
  {
    super(paramActivity);
    AppMethodBeat.i(56208);
    this.msgId = -1L;
    this.vuv = "";
    this.dCy = true;
    this.gkS = new com.tencent.mm.remoteservice.d(this.activity);
    this.vuy = false;
    this.vuA = new b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(56205);
        if (!paramAnonymousBoolean)
        {
          AppMethodBeat.o(56205);
          return false;
        }
        ae.d("MicroMsg.ViewMapUI", "onGetLocation flong " + paramAnonymousFloat1 + " flat " + paramAnonymousFloat2);
        if ((paramAnonymousFloat2 == 0.0D) && (paramAnonymousFloat1 == 0.0D))
        {
          AppMethodBeat.o(56205);
          return true;
        }
        ae.d("MicroMsg.ViewMapUI", "myLocation " + k.this.kSf.vlC + " " + k.this.kSf.vlD);
        ae.d("MicroMsg.ViewMapUI", "location my show");
        k.this.kSf.vlC = paramAnonymousFloat2;
        k.this.kSf.vlD = paramAnonymousFloat1;
        k.this.vri.a(k.this.kSf.vlC, k.this.kSf.vlD, k.this.vrp, k.this.kSf.vlB);
        AppMethodBeat.o(56205);
        return true;
      }
    };
    this.kWf = false;
    this.vqv = 0L;
    com.tencent.mm.kernel.g.ajj().a(424, this);
    AppMethodBeat.o(56208);
  }
  
  private Intent dkw()
  {
    AppMethodBeat.i(56211);
    Intent localIntent = new Intent();
    localIntent.putExtra("kfavorite", true);
    localIntent.putExtra("kopenGmapNums", this.kSg.vnK);
    localIntent.putExtra("kopenOthersNums", this.kSg.vnL);
    localIntent.putExtra("kopenreportType", this.kSg.dGC);
    localIntent.putExtra("kRemark", djT());
    localIntent.putExtra("kwebmap_slat", this.kSe.vlC);
    localIntent.putExtra("kwebmap_lng", this.kSe.vlD);
    localIntent.putExtra("Kwebmap_locaion", this.kSe.vlF);
    localIntent.putExtra("kPoiName", this.jGd);
    AppMethodBeat.o(56211);
    return localIntent;
  }
  
  protected final String aRV()
  {
    AppMethodBeat.i(56222);
    String str = getString(2131760728);
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
      if ((Math.abs(paramMotionEvent.getX() - this.aTL) > 10.0F) || (Math.abs(paramMotionEvent.getY() - this.aTM) > 10.0F))
      {
        this.kWf = true;
        dkn();
        continue;
        this.aTL = paramMotionEvent.getX();
        this.aTM = paramMotionEvent.getY();
        this.vqv = System.currentTimeMillis();
        this.kWf = false;
        dkq();
        continue;
        if (!this.kWf) {
          System.currentTimeMillis();
        }
      }
    }
  }
  
  protected void djU()
  {
    AppMethodBeat.i(56217);
    Intent localIntent = new Intent();
    localIntent.putExtra("kopenGmapNums", this.kSg.vnK);
    localIntent.putExtra("kopenOthersNums", this.kSg.vnL);
    localIntent.putExtra("kopenreportType", this.kSg.dGC);
    localIntent.putExtra("kRemark", djT());
    localIntent.putExtra("soso_street_view_url", this.vuv);
    this.activity.setResult(-1, localIntent);
    AppMethodBeat.o(56217);
  }
  
  void djV()
  {
    AppMethodBeat.i(56212);
    this.vrf.vrv.setEnabled(true);
    this.vrf.vrr.setVisibility(8);
    c(this.kSe);
    this.vrf.voa.getIController().setZoom(this.vlE);
    this.vrf.vrt.setEnabled(true);
    this.dCy = this.activity.getIntent().getBooleanExtra("kShowshare", true);
    label150:
    Object localObject1;
    Object localObject2;
    if (this.dCy)
    {
      this.vrf.vrt.setVisibility(0);
      this.vuv = this.activity.getIntent().getStringExtra("soso_street_view_url");
      if ((bu.isNullOrNil(this.vuv)) || ((!ad.fok()) && (!ad.foj()))) {
        break label601;
      }
      this.vuy = true;
      this.vrf.vrt.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(56203);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/location/ui/impl/ViewMapUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          k.this.dkv();
          k.this.vux.cPF();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/location/ui/impl/ViewMapUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(56203);
        }
      });
      this.vuw = new com.tencent.mm.plugin.location.ui.l(this.vrf.voa, this.activity);
      localObject1 = this.vuw;
      if (((com.tencent.mm.plugin.location.ui.l)localObject1).mViewManager != null)
      {
        ((com.tencent.mm.plugin.location.ui.l)localObject1).mViewManager.addView(((com.tencent.mm.plugin.location.ui.l)localObject1).vqW, 0.0D, 0.0D);
        ((com.tencent.mm.plugin.location.ui.l)localObject1).mViewManager.setMarkerTag(((com.tencent.mm.plugin.location.ui.l)localObject1).vqW, "info_window_tag");
        if (((com.tencent.mm.plugin.location.ui.l)localObject1).vqZ)
        {
          ((com.tencent.mm.plugin.location.ui.l)localObject1).mViewManager.setInfoWindowAdapter(new l.a((com.tencent.mm.plugin.location.ui.l)localObject1, (byte)0));
          ((com.tencent.mm.plugin.location.ui.l)localObject1).mViewManager.showInfoWindowByView(((com.tencent.mm.plugin.location.ui.l)localObject1).vqW);
        }
      }
      localObject1 = this.vuw;
      localObject2 = this.kSe;
      ((com.tencent.mm.plugin.location.ui.l)localObject1).vlC = ((LocationInfo)localObject2).vlC;
      ((com.tencent.mm.plugin.location.ui.l)localObject1).vlD = ((LocationInfo)localObject2).vlD;
      if (!com.tencent.mm.plugin.location.model.e.j(this.kSe.vlC, this.kSe.vlD))
      {
        ae.d("MicroMsg.ViewMapUI", "isValidLatLng %f %f", new Object[] { Double.valueOf(this.kSe.vlC), Double.valueOf(this.kSe.vlD) });
        localObject1 = this.vuw;
        ((com.tencent.mm.plugin.location.ui.l)localObject1).vnY = false;
        ((com.tencent.mm.plugin.location.ui.l)localObject1).vqX.setVisibility(8);
      }
      if (2 == this.type)
      {
        ae.i("MicroMsg.ViewMapUI", "location id %s", new Object[] { this.kSe.vlB });
        if (this.activity.getIntent().getBooleanExtra("kFavCanRemark", true)) {
          djS();
        }
        if (!bu.isNullOrNil(this.kSe.vlF)) {
          this.vrf.vrs.setVisibility(0);
        }
      }
      this.vrh.put(this.kSe.vlB, this.vuw);
      if (!this.kSe.diX()) {
        break label700;
      }
      if ((this.jGd != null) && (!this.jGd.equals(""))) {
        this.vuw.jGd = this.jGd;
      }
      this.vuw.setText(this.vuw.getPreText() + this.kSe.vlF);
    }
    for (;;)
    {
      for (;;)
      {
        localObject1 = this.vuw;
        localObject2 = new TencentMap.OnInfoWindowClickListener()
        {
          public final void onInfoWindowClick(Marker paramAnonymousMarker)
          {
            AppMethodBeat.i(56204);
            k.this.dsV = 0;
            k.this.dko();
            k.this.dkz();
            AppMethodBeat.o(56204);
          }
        };
        if ((((com.tencent.mm.plugin.location.ui.l)localObject1).vqZ) && (((com.tencent.mm.plugin.location.ui.l)localObject1).mViewManager != null)) {
          ((com.tencent.mm.plugin.location.ui.l)localObject1).mViewManager.setInfoWindowClick(((com.tencent.mm.plugin.location.ui.l)localObject1).vqW, (TencentMap.OnInfoWindowClickListener)localObject2);
        }
        AppMethodBeat.o(56212);
        return;
        this.vrf.vrt.setVisibility(8);
        break;
        label601:
        if ((!ad.fok()) && (!ad.foj())) {
          break label150;
        }
        this.vuy = false;
        try
        {
          localObject1 = (cyc)new com.tencent.mm.modelsimple.x((float)this.kSe.vlD, (float)this.kSe.vlC, this.msgId).rr.hQD.hQJ;
          new com.tencent.mm.modelsimple.x((cyc)localObject1);
          com.tencent.mm.kernel.g.ajj().a(new com.tencent.mm.modelsimple.x((cyc)localObject1), 0);
        }
        catch (Exception localException)
        {
          ae.e("MicroMsg.ViewMapUI", localException.toString());
        }
      }
      break label150;
      label700:
      if (com.tencent.mm.plugin.location.model.e.j(this.kSe.vlC, this.kSe.vlD)) {
        this.vri.a(this.kSe.vlC, this.kSe.vlD, this.vrp, this.kSe.vlB);
      }
    }
  }
  
  public boolean djW()
  {
    AppMethodBeat.i(56209);
    if ((this.vux != null) && (this.vux.isShowing())) {
      this.vux.bqD();
    }
    for (;;)
    {
      AppMethodBeat.o(56209);
      return true;
      dkv();
      this.vux.cPF();
    }
  }
  
  public void dkn() {}
  
  protected void dko() {}
  
  public void dkq() {}
  
  protected void dkr() {}
  
  final void dkv()
  {
    AppMethodBeat.i(56210);
    this.vux = new com.tencent.mm.ui.widget.a.e(this.activity, 1, false);
    this.vux.LfS = new n.d()
    {
      public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
      {
        AppMethodBeat.i(56200);
        paramAnonymousl.a(1, k.this.getString(2131755893), 0);
        if (k.this.type == 1) {
          paramAnonymousl.a(3, k.this.getString(2131761941), 0);
        }
        for (;;)
        {
          ec localec = new ec();
          localec.dql.msgId = k.this.msgId;
          com.tencent.mm.sdk.b.a.IvT.l(localec);
          if ((localec.dqm.dpK) || (com.tencent.mm.pluginsdk.model.app.h.s(ak.getContext(), 4L))) {
            paramAnonymousl.a(6, k.this.getString(2131758114), 0);
          }
          AppMethodBeat.o(56200);
          return;
          if (k.this.type == 2)
          {
            if (k.this.activity.getIntent().getBooleanExtra("kFavCanDel", true))
            {
              paramAnonymousl.a(7, k.this.getString(2131758989), 0);
              paramAnonymousl.a(5, k.this.getString(2131758876), 0);
              paramAnonymousl.a(4, k.this.getString(2131755707), 0);
            }
          }
          else if (k.this.type == 10) {
            paramAnonymousl.a(8, k.this.getString(2131761941), 0);
          }
        }
      }
    };
    this.vux.LfT = new n.e()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(56202);
        switch (paramAnonymousMenuItem.getItemId())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(56202);
          return;
          k.this.dkx();
          AppMethodBeat.o(56202);
          return;
          if (k.this.type == 2) {
            com.tencent.mm.plugin.fav.a.h.i(k.this.activity.getIntent().getLongExtra("kFavInfoLocalId", -1L), 1, 0);
          }
          paramAnonymousMenuItem = new Intent();
          paramAnonymousMenuItem.putExtra("Retr_Msg_content", com.tencent.mm.plugin.location.model.e.a(k.this.kSe));
          paramAnonymousMenuItem.putExtra("Retr_Msg_Type", 9);
          com.tencent.mm.br.d.f(k.this.activity, ".ui.transmit.MsgRetransmitUI", paramAnonymousMenuItem);
          AppMethodBeat.o(56202);
          return;
          k.this.dsV = 0;
          k.this.dkz();
          AppMethodBeat.o(56202);
          return;
          k.this.dky();
          AppMethodBeat.o(56202);
          return;
          com.tencent.mm.ui.base.h.a(k.this.activity, k.this.activity.getString(2131755709), "", new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(56201);
              long l = k.this.activity.getIntent().getLongExtra("kFavInfoLocalId", -1L);
              paramAnonymous2DialogInterface = new cr();
              paramAnonymous2DialogInterface.doF.doH = l;
              com.tencent.mm.sdk.b.a.IvT.l(paramAnonymous2DialogInterface);
              boolean bool = bu.a(Boolean.valueOf(paramAnonymous2DialogInterface.doG.doq), false);
              ae.d("MicroMsg.ViewMapUI", "do del fav voice, local id %d, result %B", new Object[] { Long.valueOf(l), Boolean.valueOf(bool) });
              if (bool) {
                k.this.activity.finish();
              }
              AppMethodBeat.o(56201);
            }
          }, null);
          AppMethodBeat.o(56202);
          return;
          long l = k.this.activity.getIntent().getLongExtra("kFavInfoLocalId", -1L);
          paramAnonymousMenuItem = new Intent();
          paramAnonymousMenuItem.putExtra("key_fav_item_id", l);
          paramAnonymousMenuItem.putExtra("key_fav_scene", 2);
          com.tencent.mm.plugin.fav.a.b.b(k.this.activity, ".ui.FavTagEditUI", paramAnonymousMenuItem);
          AppMethodBeat.o(56202);
          return;
          paramAnonymousMenuItem = new Intent();
          paramAnonymousMenuItem.putExtra("Retr_Msg_content", com.tencent.mm.plugin.location.model.e.a(k.this.kSe));
          paramAnonymousMenuItem.putExtra("Retr_Msg_Id", k.this.msgId);
          com.tencent.mm.br.d.f(k.this.activity, ".ui.chatting.ChattingSendDataToDeviceUI", paramAnonymousMenuItem);
          AppMethodBeat.o(56202);
          return;
          try
          {
            l = k.this.activity.getIntent().getLongExtra("kFavInfoLocalId", -1L);
            paramAnonymousMenuItem = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vU(l);
            com.tencent.mm.plugin.report.service.g.yxI.f(15378, new Object[] { Integer.valueOf(paramAnonymousMenuItem.field_id), Integer.valueOf(paramAnonymousMenuItem.field_type) });
            ae.d("MicroMsg.ViewMapUI", "report 15378, id:%s, type:%s", new Object[] { Integer.valueOf(paramAnonymousMenuItem.field_id), Integer.valueOf(paramAnonymousMenuItem.field_type) });
            paramAnonymousMenuItem.field_flag = 0;
            paramAnonymousMenuItem.field_updateTime = System.currentTimeMillis();
            paramAnonymousMenuItem.field_localId = -1L;
            paramAnonymousMenuItem.field_sourceType = 6;
            if (paramAnonymousMenuItem.field_favProto.GCe != null)
            {
              paramAnonymousMenuItem.field_favProto.GCe.aQE("");
              paramAnonymousMenuItem.field_favProto.GCe.aax(6);
              paramAnonymousMenuItem.field_favProto.GCe.aQC(v.aAC());
            }
            paramAnonymousMenuItem.field_fromUser = v.aAC();
            Object localObject1 = new LinkedList();
            Object localObject2 = new ajx();
            Object localObject3 = new ajy();
            ((ajy)localObject3).c(paramAnonymousMenuItem.field_favProto.GBd);
            ((ajx)localObject2).a((ajy)localObject3);
            ((ajx)localObject2).aPZ("WeNote_0");
            ((ajx)localObject2).aao(6);
            ((LinkedList)localObject1).add(0, localObject2);
            paramAnonymousMenuItem.field_favProto.bm((LinkedList)localObject1);
            paramAnonymousMenuItem.field_type = 18;
            paramAnonymousMenuItem.field_xml = com.tencent.mm.plugin.fav.a.g.t(paramAnonymousMenuItem);
            localObject1 = new akp();
            localObject3 = k.this.activity;
            localObject2 = new nk();
            ((nk)localObject2).dCo.field_localId = paramAnonymousMenuItem.field_localId;
            ((nk)localObject2).dCo.dCx = 5;
            ((nk)localObject2).dCo.dCq = paramAnonymousMenuItem.field_xml;
            ((nk)localObject2).dCo.context = ((Context)localObject3);
            localObject3 = new Bundle();
            akh localakh = paramAnonymousMenuItem.field_favProto.FId;
            if (localakh != null)
            {
              ((Bundle)localObject3).putString("noteauthor", localakh.GBX);
              ((Bundle)localObject3).putString("noteeditor", localakh.GBY);
            }
            ((Bundle)localObject3).putLong("edittime", paramAnonymousMenuItem.field_updateTime);
            ((nk)localObject2).dCo.dCv = ((Bundle)localObject3);
            ((nk)localObject2).dCo.field_favProto = paramAnonymousMenuItem.field_favProto;
            ((nk)localObject2).dCo.type = 2;
            ((nk)localObject2).dCo.dCy = true;
            ((nk)localObject2).dCo.dCz = ((akp)localObject1);
            com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject2);
            k.this.activity.finish();
            AppMethodBeat.o(56202);
            return;
          }
          catch (Throwable paramAnonymousMenuItem)
          {
            Toast.makeText(k.this.activity, 2131758991, 0).show();
            AppMethodBeat.o(56202);
            return;
          }
          k.a(k.this);
        }
      }
    };
    AppMethodBeat.o(56210);
  }
  
  protected final void dkx()
  {
    AppMethodBeat.i(56213);
    if (this.vuy)
    {
      w.a(new com.tencent.mm.pluginsdk.ui.tools.g());
      Intent localIntent = new Intent();
      localIntent.putExtra("show_bottom", false);
      localIntent.putExtra("jsapi_args_appid", "wx751a1acca5688ba3");
      localIntent.putExtra("rawUrl", this.vuv);
      localIntent.putExtra("title", 2131762812);
      localIntent.putExtra("webview_bg_color_rsID", 2131100017);
      com.tencent.mm.br.d.b(this.activity, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent);
    }
    AppMethodBeat.o(56213);
  }
  
  protected final void dky()
  {
    AppMethodBeat.i(56218);
    ae.d("MicroMsg.ViewMapUI", "directlyFavorite lat %s, long %s, scale", new Object[] { Double.valueOf(this.kSe.vlC), Double.valueOf(this.kSe.vlD) });
    Intent localIntent = dkw();
    this.activity.setResult(-1, localIntent);
    this.activity.getIntent().getIntExtra("MMActivity.OverrideEnterAnimation", -1);
    this.activity.getIntent().getIntExtra("MMActivity.OverrideExitAnimation", -1);
    this.activity.finish();
    AppMethodBeat.o(56218);
  }
  
  protected final void dkz()
  {
    AppMethodBeat.i(56219);
    ae.d("MicroMsg.ViewMapUI", "locationLine, locationInfo.slat=%f, locationInfo.slong=%f, myLocation.slat=%f, myLocation.slong=%f", new Object[] { Double.valueOf(this.kSe.vlC), Double.valueOf(this.kSe.vlD), Double.valueOf(this.kSf.vlC), Double.valueOf(this.kSf.vlD) });
    if (this.kSf.diW())
    {
      dkr();
      AppMethodBeat.o(56219);
      return;
    }
    com.tencent.mm.plugin.report.service.g.yxI.f(12809, new Object[] { Integer.valueOf(3), "" });
    this.vrj = true;
    if (this.handler == null)
    {
      AppMethodBeat.o(56219);
      return;
    }
    if (this.vuz != null) {
      this.handler.removeCallbacks(this.vuz);
    }
    this.vuz = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(56206);
        if (k.this.vrj)
        {
          if (k.this.fOC != null) {
            k.this.fOC.dismiss();
          }
          k.this.dkr();
        }
        k.this.vrj = false;
        AppMethodBeat.o(56206);
      }
    };
    this.handler.postDelayed(this.vuz, 10000L);
    Activity localActivity = this.activity;
    getString(2131755906);
    this.fOC = com.tencent.mm.ui.base.h.b(localActivity, getString(2131760067), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        k.this.vrj = false;
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
      Object localObject1 = this.kSg;
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
            com.tencent.mm.plugin.report.service.g.yxI.f(11091, new Object[] { Integer.valueOf(6), Integer.valueOf(2) });
            paramIntent = paramIntent.getBundleExtra("transferback").getParcelableArrayList("locations");
            localObject2 = (LocationInfo)paramIntent.get(0);
            localObject3 = (LocationInfo)paramIntent.get(1);
            if (!bu.isNullOrNil(((LocationInfo)localObject2).vlG)) {
              break label483;
            }
          }
          for (paramIntent = "zh-cn";; paramIntent = ((LocationInfo)localObject2).vlG)
          {
            paramIntent = new Intent("android.intent.action.VIEW", Uri.parse(String.format("http://maps.google.com/maps?f=d&saddr=%f,%f&daddr=%f,%f&hl=".concat(String.valueOf(paramIntent)), new Object[] { Double.valueOf(((LocationInfo)localObject3).vlC), Double.valueOf(((LocationInfo)localObject3).vlD), Double.valueOf(((LocationInfo)localObject2).vlC), Double.valueOf(((LocationInfo)localObject2).vlD) })));
            localObject2 = new Bundle();
            ((Bundle)localObject2).putParcelable("targetintent", paramIntent);
            localObject3 = new Intent();
            ((Intent)localObject3).setClass(((com.tencent.mm.plugin.location.ui.d)localObject1).context, AppChooserUI.class);
            ((Intent)localObject3).putExtra("type", 1);
            ((Intent)localObject3).putExtra("title", ((com.tencent.mm.plugin.location.ui.d)localObject1).context.getResources().getString(2131760718));
            ((Intent)localObject3).putExtra("targetintent", paramIntent);
            ((Intent)localObject3).putExtra("transferback", (Bundle)localObject2);
            ((Intent)localObject3).putExtra("scene", 6);
            ((Activity)((com.tencent.mm.plugin.location.ui.d)localObject1).context).startActivityForResult((Intent)localObject3, 4099);
            AppMethodBeat.o(56220);
            return;
            com.tencent.mm.plugin.report.service.g.yxI.f(11091, new Object[] { Integer.valueOf(6), Integer.valueOf(1) });
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
          paramIntent = new com.tencent.mm.hellhoundlib.b.a().bc(paramIntent);
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, paramIntent.ahE(), "com/tencent/mm/plugin/location/ui/MapHelper", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Context)localObject1).startActivity((Intent)paramIntent.mt(0));
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
    ae.i("MicroMsg.ViewMapUI", "start dslat " + d1 + " " + d2);
    this.vlE = this.activity.getIntent().getIntExtra("kwebmap_scale", 15);
    if (this.vlE <= 0) {
      this.vlE = 15;
    }
    this.jGd = this.activity.getIntent().getStringExtra("kPoiName");
    paramBundle = this.activity.getIntent().getStringExtra("Kwebmap_locaion");
    ae.d("MicroMsg.ViewMapUI", "view " + d1 + " " + d2);
    LocationInfo localLocationInfo = this.kSe;
    localLocationInfo.vlC = d1;
    localLocationInfo.vlD = d2;
    localLocationInfo.vlF = paramBundle;
    localLocationInfo.vlE = this.vlE;
    localLocationInfo.dEv = this.jGd;
    this.msgId = this.activity.getIntent().getLongExtra("kMsgId", -1L);
    this.vmW = this.activity.getIntent().getStringExtra("map_talker_name");
    initView();
    AppMethodBeat.o(56216);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(56221);
    this.gkS.release();
    this.handler.removeCallbacks(this.vuz);
    this.handler = null;
    com.tencent.mm.kernel.g.ajj().b(424, this);
    super.onDestroy();
    AppMethodBeat.o(56221);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(56215);
    ae.d("MicroMsg.ViewMapUI", "onbaseGeoResume");
    if (this.vro != null) {
      this.vro.c(this.vuA);
    }
    super.onPause();
    AppMethodBeat.o(56215);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(56214);
    super.onResume();
    ae.d("MicroMsg.ViewMapUI", "onbaseGeoResume");
    if (this.vro != null) {
      this.vro.b(this.vuA, true);
    }
    AppMethodBeat.o(56214);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(56224);
    ae.d("MicroMsg.ViewMapUI", "onScene end %d %d %d", new Object[] { Integer.valueOf(paramn.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramn.getType() == 424)
    {
      if ((paramInt2 == 0) && (paramInt1 == 0))
      {
        paramString = com.tencent.mm.modelsimple.x.GR(((com.tencent.mm.modelsimple.x)paramn).aLy().GXm);
        ae.d("MicroMsg.ViewMapUI", "getUrl success! url is %s", new Object[] { paramString });
        this.vuv = paramString;
        if (!bu.isNullOrNil(paramString)) {
          this.vuy = true;
        }
        if ((this.type == 9) && (!bu.isNullOrNil(paramString)))
        {
          paramString = (TextView)findViewById(2131305503);
          paramString.setVisibility(0);
          paramString.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(56207);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/location/ui/impl/ViewMapUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
              k.this.dkx();
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/location/ui/impl/ViewMapUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(56207);
            }
          });
        }
        AppMethodBeat.o(56224);
      }
    }
    else {
      ae.e("MicroMsg.ViewMapUI", "msg failed.errtype:%d, errcode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    }
    AppMethodBeat.o(56224);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.k
 * JD-Core Version:    0.7.0.1
 */