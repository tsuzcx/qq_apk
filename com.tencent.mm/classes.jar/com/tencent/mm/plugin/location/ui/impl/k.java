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
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.cq;
import com.tencent.mm.g.a.cq.b;
import com.tencent.mm.g.a.eb;
import com.tencent.mm.g.a.eb.b;
import com.tencent.mm.g.a.nj;
import com.tencent.mm.model.u;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location.ui.l.a;
import com.tencent.mm.plugin.location_soso.ViewManager;
import com.tencent.mm.pluginsdk.ui.tools.AppChooserUI;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.protocal.protobuf.ajo;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.protocal.protobuf.akf;
import com.tencent.mm.protocal.protobuf.akj;
import com.tencent.mm.protocal.protobuf.cxi;
import com.tencent.mm.protocal.protobuf.cxj;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
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
  private boolean dBt;
  public com.tencent.mm.remoteservice.d giA;
  private boolean kSw;
  protected long msgId;
  private long vek;
  private String viq;
  com.tencent.mm.plugin.location.ui.l vir;
  com.tencent.mm.ui.widget.a.e vis;
  boolean vit;
  private Runnable viu;
  private b.a viv;
  
  public k(Activity paramActivity)
  {
    super(paramActivity);
    AppMethodBeat.i(56208);
    this.msgId = -1L;
    this.viq = "";
    this.dBt = true;
    this.giA = new com.tencent.mm.remoteservice.d(this.activity);
    this.vit = false;
    this.viv = new b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(56205);
        if (!paramAnonymousBoolean)
        {
          AppMethodBeat.o(56205);
          return false;
        }
        ad.d("MicroMsg.ViewMapUI", "onGetLocation flong " + paramAnonymousFloat1 + " flat " + paramAnonymousFloat2);
        if ((paramAnonymousFloat2 == 0.0D) && (paramAnonymousFloat1 == 0.0D))
        {
          AppMethodBeat.o(56205);
          return true;
        }
        ad.d("MicroMsg.ViewMapUI", "myLocation " + k.this.veX.uZr + " " + k.this.veX.uZs);
        ad.d("MicroMsg.ViewMapUI", "location my show");
        k.this.veX.uZr = paramAnonymousFloat2;
        k.this.veX.uZs = paramAnonymousFloat1;
        k.this.vfb.a(k.this.veX.uZr, k.this.veX.uZs, k.this.vfi, k.this.veX.uZq);
        AppMethodBeat.o(56205);
        return true;
      }
    };
    this.kSw = false;
    this.vek = 0L;
    com.tencent.mm.kernel.g.aiU().a(424, this);
    AppMethodBeat.o(56208);
  }
  
  private Intent dhx()
  {
    AppMethodBeat.i(56211);
    Intent localIntent = new Intent();
    localIntent.putExtra("kfavorite", true);
    localIntent.putExtra("kopenGmapNums", this.veV.vbz);
    localIntent.putExtra("kopenOthersNums", this.veV.vbA);
    localIntent.putExtra("kopenreportType", this.veV.dFx);
    localIntent.putExtra("kRemark", dgU());
    localIntent.putExtra("kwebmap_slat", this.veW.uZr);
    localIntent.putExtra("kwebmap_lng", this.veW.uZs);
    localIntent.putExtra("Kwebmap_locaion", this.veW.uZu);
    localIntent.putExtra("kPoiName", this.jDf);
    AppMethodBeat.o(56211);
    return localIntent;
  }
  
  protected final String aRw()
  {
    AppMethodBeat.i(56222);
    String str = getString(2131760728);
    AppMethodBeat.o(56222);
    return str;
  }
  
  protected void dgV()
  {
    AppMethodBeat.i(56217);
    Intent localIntent = new Intent();
    localIntent.putExtra("kopenGmapNums", this.veV.vbz);
    localIntent.putExtra("kopenOthersNums", this.veV.vbA);
    localIntent.putExtra("kopenreportType", this.veV.dFx);
    localIntent.putExtra("kRemark", dgU());
    localIntent.putExtra("soso_street_view_url", this.viq);
    this.activity.setResult(-1, localIntent);
    AppMethodBeat.o(56217);
  }
  
  void dgW()
  {
    AppMethodBeat.i(56212);
    this.veY.vfo.setEnabled(true);
    this.veY.vfk.setVisibility(8);
    c(this.veW);
    this.veY.vbP.getIController().setZoom(this.uZt);
    this.veY.vfm.setEnabled(true);
    this.dBt = this.activity.getIntent().getBooleanExtra("kShowshare", true);
    label148:
    Object localObject1;
    Object localObject2;
    if (this.dBt)
    {
      this.veY.vfm.setVisibility(0);
      this.viq = this.activity.getIntent().getStringExtra("soso_street_view_url");
      if ((bt.isNullOrNil(this.viq)) || ((!ac.fkq()) && (!ac.fkp()))) {
        break label598;
      }
      this.vit = true;
      this.veY.vfm.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(56203);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/location/ui/impl/ViewMapUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          k.this.dhw();
          k.this.vis.cMW();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/location/ui/impl/ViewMapUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(56203);
        }
      });
      this.vir = new com.tencent.mm.plugin.location.ui.l(this.veY.vbP, this.activity);
      localObject1 = this.vir;
      if (((com.tencent.mm.plugin.location.ui.l)localObject1).mViewManager != null)
      {
        ((com.tencent.mm.plugin.location.ui.l)localObject1).mViewManager.addView(((com.tencent.mm.plugin.location.ui.l)localObject1).veM, 0.0D, 0.0D);
        ((com.tencent.mm.plugin.location.ui.l)localObject1).mViewManager.setMarkerTag(((com.tencent.mm.plugin.location.ui.l)localObject1).veM, "info_window_tag");
        if (((com.tencent.mm.plugin.location.ui.l)localObject1).veP)
        {
          ((com.tencent.mm.plugin.location.ui.l)localObject1).mViewManager.setInfoWindowAdapter(new l.a((com.tencent.mm.plugin.location.ui.l)localObject1, (byte)0));
          ((com.tencent.mm.plugin.location.ui.l)localObject1).mViewManager.showInfoWindowByView(((com.tencent.mm.plugin.location.ui.l)localObject1).veM);
        }
      }
      localObject1 = this.vir;
      localObject2 = this.veW;
      ((com.tencent.mm.plugin.location.ui.l)localObject1).uZr = ((LocationInfo)localObject2).uZr;
      ((com.tencent.mm.plugin.location.ui.l)localObject1).uZs = ((LocationInfo)localObject2).uZs;
      if (!com.tencent.mm.plugin.location.model.e.j(this.veW.uZr, this.veW.uZs))
      {
        ad.d("MicroMsg.ViewMapUI", "isValidLatLng %f %f", new Object[] { Double.valueOf(this.veW.uZr), Double.valueOf(this.veW.uZs) });
        localObject1 = this.vir;
        ((com.tencent.mm.plugin.location.ui.l)localObject1).vbN = false;
        ((com.tencent.mm.plugin.location.ui.l)localObject1).veN.setVisibility(8);
      }
      if (2 == this.type)
      {
        ad.i("MicroMsg.ViewMapUI", "location id %s", new Object[] { this.veW.uZq });
        if (this.activity.getIntent().getBooleanExtra("kFavCanRemark", true)) {
          dgT();
        }
        if (!bt.isNullOrNil(this.veW.uZu)) {
          this.veY.vfl.setVisibility(0);
        }
      }
      this.vfa.put(this.veW.uZq, this.vir);
      if (!this.veW.dfY()) {
        break label697;
      }
      if ((this.jDf != null) && (!this.jDf.equals(""))) {
        this.vir.jDf = this.jDf;
      }
      this.vir.setText(this.vir.getPreText() + this.veW.uZu);
    }
    for (;;)
    {
      for (;;)
      {
        localObject1 = this.vir;
        localObject2 = new TencentMap.OnInfoWindowClickListener()
        {
          public final void onInfoWindowClick(Marker paramAnonymousMarker)
          {
            AppMethodBeat.i(56204);
            k.this.drP = 0;
            k.this.dhp();
            k.this.dhA();
            AppMethodBeat.o(56204);
          }
        };
        if ((((com.tencent.mm.plugin.location.ui.l)localObject1).veP) && (((com.tencent.mm.plugin.location.ui.l)localObject1).mViewManager != null)) {
          ((com.tencent.mm.plugin.location.ui.l)localObject1).mViewManager.setInfoWindowClick(((com.tencent.mm.plugin.location.ui.l)localObject1).veM, (TencentMap.OnInfoWindowClickListener)localObject2);
        }
        AppMethodBeat.o(56212);
        return;
        this.veY.vfm.setVisibility(8);
        break;
        label598:
        if ((!ac.fkq()) && (!ac.fkp())) {
          break label148;
        }
        this.vit = false;
        try
        {
          localObject1 = (cxi)new com.tencent.mm.modelsimple.w((float)this.veW.uZs, (float)this.veW.uZr, this.msgId).rr.hNK.hNQ;
          new com.tencent.mm.modelsimple.w((cxi)localObject1);
          com.tencent.mm.kernel.g.aiU().a(new com.tencent.mm.modelsimple.w((cxi)localObject1), 0);
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.ViewMapUI", localException.toString());
        }
      }
      break label148;
      label697:
      if (com.tencent.mm.plugin.location.model.e.j(this.veW.uZr, this.veW.uZs)) {
        this.vfb.a(this.veW.uZr, this.veW.uZs, this.vfi, this.veW.uZq);
      }
    }
  }
  
  public boolean dgX()
  {
    AppMethodBeat.i(56209);
    if ((this.vis != null) && (this.vis.isShowing())) {
      this.vis.bpT();
    }
    for (;;)
    {
      AppMethodBeat.o(56209);
      return true;
      dhw();
      this.vis.cMW();
    }
  }
  
  protected final void dhA()
  {
    AppMethodBeat.i(56219);
    ad.d("MicroMsg.ViewMapUI", "locationLine, locationInfo.slat=%f, locationInfo.slong=%f, myLocation.slat=%f, myLocation.slong=%f", new Object[] { Double.valueOf(this.veW.uZr), Double.valueOf(this.veW.uZs), Double.valueOf(this.veX.uZr), Double.valueOf(this.veX.uZs) });
    if (this.veX.dfX())
    {
      dhs();
      AppMethodBeat.o(56219);
      return;
    }
    com.tencent.mm.plugin.report.service.g.yhR.f(12809, new Object[] { Integer.valueOf(3), "" });
    this.vfc = true;
    if (this.handler == null)
    {
      AppMethodBeat.o(56219);
      return;
    }
    if (this.viu != null) {
      this.handler.removeCallbacks(this.viu);
    }
    this.viu = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(56206);
        if (k.this.vfc)
        {
          if (k.this.fMu != null) {
            k.this.fMu.dismiss();
          }
          k.this.dhs();
        }
        k.this.vfc = false;
        AppMethodBeat.o(56206);
      }
    };
    this.handler.postDelayed(this.viu, 10000L);
    Activity localActivity = this.activity;
    getString(2131755906);
    this.fMu = com.tencent.mm.ui.base.h.b(localActivity, getString(2131760067), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        k.this.vfc = false;
      }
    });
    AppMethodBeat.o(56219);
  }
  
  public void dho() {}
  
  protected void dhp() {}
  
  public void dhr() {}
  
  protected void dhs() {}
  
  final void dhw()
  {
    AppMethodBeat.i(56210);
    this.vis = new com.tencent.mm.ui.widget.a.e(this.activity, 1, false);
    this.vis.KJy = new n.d()
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
          eb localeb = new eb();
          localeb.dpg.msgId = k.this.msgId;
          com.tencent.mm.sdk.b.a.IbL.l(localeb);
          if ((localeb.dph.doF) || (com.tencent.mm.pluginsdk.model.app.h.r(aj.getContext(), 4L))) {
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
    this.vis.KJz = new n.e()
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
          k.this.dhy();
          AppMethodBeat.o(56202);
          return;
          if (k.this.type == 2) {
            com.tencent.mm.plugin.fav.a.h.i(k.this.activity.getIntent().getLongExtra("kFavInfoLocalId", -1L), 1, 0);
          }
          paramAnonymousMenuItem = new Intent();
          paramAnonymousMenuItem.putExtra("Retr_Msg_content", com.tencent.mm.plugin.location.model.e.a(k.this.veW));
          paramAnonymousMenuItem.putExtra("Retr_Msg_Type", 9);
          com.tencent.mm.bs.d.f(k.this.activity, ".ui.transmit.MsgRetransmitUI", paramAnonymousMenuItem);
          AppMethodBeat.o(56202);
          return;
          k.this.drP = 0;
          k.this.dhA();
          AppMethodBeat.o(56202);
          return;
          k.this.dhz();
          AppMethodBeat.o(56202);
          return;
          com.tencent.mm.ui.base.h.a(k.this.activity, k.this.activity.getString(2131755709), "", new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(56201);
              long l = k.this.activity.getIntent().getLongExtra("kFavInfoLocalId", -1L);
              paramAnonymous2DialogInterface = new cq();
              paramAnonymous2DialogInterface.dnA.dnC = l;
              com.tencent.mm.sdk.b.a.IbL.l(paramAnonymous2DialogInterface);
              boolean bool = bt.a(Boolean.valueOf(paramAnonymous2DialogInterface.dnB.dno), false);
              ad.d("MicroMsg.ViewMapUI", "do del fav voice, local id %d, result %B", new Object[] { Long.valueOf(l), Boolean.valueOf(bool) });
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
          paramAnonymousMenuItem.putExtra("Retr_Msg_content", com.tencent.mm.plugin.location.model.e.a(k.this.veW));
          paramAnonymousMenuItem.putExtra("Retr_Msg_Id", k.this.msgId);
          com.tencent.mm.bs.d.f(k.this.activity, ".ui.chatting.ChattingSendDataToDeviceUI", paramAnonymousMenuItem);
          AppMethodBeat.o(56202);
          return;
          try
          {
            l = k.this.activity.getIntent().getLongExtra("kFavInfoLocalId", -1L);
            paramAnonymousMenuItem = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vE(l);
            com.tencent.mm.plugin.report.service.g.yhR.f(15378, new Object[] { Integer.valueOf(paramAnonymousMenuItem.field_id), Integer.valueOf(paramAnonymousMenuItem.field_type) });
            ad.d("MicroMsg.ViewMapUI", "report 15378, id:%s, type:%s", new Object[] { Integer.valueOf(paramAnonymousMenuItem.field_id), Integer.valueOf(paramAnonymousMenuItem.field_type) });
            paramAnonymousMenuItem.field_flag = 0;
            paramAnonymousMenuItem.field_updateTime = System.currentTimeMillis();
            paramAnonymousMenuItem.field_localId = -1L;
            paramAnonymousMenuItem.field_sourceType = 6;
            if (paramAnonymousMenuItem.field_favProto.Gjv != null)
            {
              paramAnonymousMenuItem.field_favProto.Gjv.aPh("");
              paramAnonymousMenuItem.field_favProto.Gjv.ZR(6);
              paramAnonymousMenuItem.field_favProto.Gjv.aPf(u.aAm());
            }
            paramAnonymousMenuItem.field_fromUser = u.aAm();
            Object localObject1 = new LinkedList();
            Object localObject2 = new ajn();
            Object localObject3 = new ajo();
            ((ajo)localObject3).c(paramAnonymousMenuItem.field_favProto.Giu);
            ((ajn)localObject2).a((ajo)localObject3);
            ((ajn)localObject2).aOC("WeNote_0");
            ((ajn)localObject2).ZI(6);
            ((LinkedList)localObject1).add(0, localObject2);
            paramAnonymousMenuItem.field_favProto.bl((LinkedList)localObject1);
            paramAnonymousMenuItem.field_type = 18;
            paramAnonymousMenuItem.field_xml = com.tencent.mm.plugin.fav.a.g.t(paramAnonymousMenuItem);
            localObject1 = new akf();
            localObject3 = k.this.activity;
            localObject2 = new nj();
            ((nj)localObject2).dBj.field_localId = paramAnonymousMenuItem.field_localId;
            ((nj)localObject2).dBj.dBs = 5;
            ((nj)localObject2).dBj.dBl = paramAnonymousMenuItem.field_xml;
            ((nj)localObject2).dBj.context = ((Context)localObject3);
            localObject3 = new Bundle();
            ajx localajx = paramAnonymousMenuItem.field_favProto.FpF;
            if (localajx != null)
            {
              ((Bundle)localObject3).putString("noteauthor", localajx.Gjo);
              ((Bundle)localObject3).putString("noteeditor", localajx.Gjp);
            }
            ((Bundle)localObject3).putLong("edittime", paramAnonymousMenuItem.field_updateTime);
            ((nj)localObject2).dBj.dBq = ((Bundle)localObject3);
            ((nj)localObject2).dBj.field_favProto = paramAnonymousMenuItem.field_favProto;
            ((nj)localObject2).dBj.type = 2;
            ((nj)localObject2).dBj.dBt = true;
            ((nj)localObject2).dBj.dBu = ((akf)localObject1);
            com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject2);
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
  
  protected final void dhy()
  {
    AppMethodBeat.i(56213);
    if (this.vit)
    {
      com.tencent.mm.pluginsdk.ui.tools.w.a(new com.tencent.mm.pluginsdk.ui.tools.g());
      Intent localIntent = new Intent();
      localIntent.putExtra("show_bottom", false);
      localIntent.putExtra("jsapi_args_appid", "wx751a1acca5688ba3");
      localIntent.putExtra("rawUrl", this.viq);
      localIntent.putExtra("title", 2131762812);
      localIntent.putExtra("webview_bg_color_rsID", 2131100017);
      com.tencent.mm.bs.d.b(this.activity, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent);
    }
    AppMethodBeat.o(56213);
  }
  
  protected final void dhz()
  {
    AppMethodBeat.i(56218);
    ad.d("MicroMsg.ViewMapUI", "directlyFavorite lat %s, long %s, scale", new Object[] { Double.valueOf(this.veW.uZr), Double.valueOf(this.veW.uZs) });
    Intent localIntent = dhx();
    this.activity.setResult(-1, localIntent);
    this.activity.getIntent().getIntExtra("MMActivity.OverrideEnterAnimation", -1);
    this.activity.getIntent().getIntExtra("MMActivity.OverrideExitAnimation", -1);
    this.activity.finish();
    AppMethodBeat.o(56218);
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
        this.kSw = true;
        dho();
        continue;
        this.aTL = paramMotionEvent.getX();
        this.aTM = paramMotionEvent.getY();
        this.vek = System.currentTimeMillis();
        this.kSw = false;
        dhr();
        continue;
        if (!this.kSw) {
          System.currentTimeMillis();
        }
      }
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
      Object localObject1 = this.veV;
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
            com.tencent.mm.plugin.report.service.g.yhR.f(11091, new Object[] { Integer.valueOf(6), Integer.valueOf(2) });
            paramIntent = paramIntent.getBundleExtra("transferback").getParcelableArrayList("locations");
            localObject2 = (LocationInfo)paramIntent.get(0);
            localObject3 = (LocationInfo)paramIntent.get(1);
            if (!bt.isNullOrNil(((LocationInfo)localObject2).uZv)) {
              break label483;
            }
          }
          for (paramIntent = "zh-cn";; paramIntent = ((LocationInfo)localObject2).uZv)
          {
            paramIntent = new Intent("android.intent.action.VIEW", Uri.parse(String.format("http://maps.google.com/maps?f=d&saddr=%f,%f&daddr=%f,%f&hl=".concat(String.valueOf(paramIntent)), new Object[] { Double.valueOf(((LocationInfo)localObject3).uZr), Double.valueOf(((LocationInfo)localObject3).uZs), Double.valueOf(((LocationInfo)localObject2).uZr), Double.valueOf(((LocationInfo)localObject2).uZs) })));
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
            com.tencent.mm.plugin.report.service.g.yhR.f(11091, new Object[] { Integer.valueOf(6), Integer.valueOf(1) });
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
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, paramIntent.ahp(), "com/tencent/mm/plugin/location/ui/MapHelper", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Context)localObject1).startActivity((Intent)paramIntent.mq(0));
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
    ad.i("MicroMsg.ViewMapUI", "start dslat " + d1 + " " + d2);
    this.uZt = this.activity.getIntent().getIntExtra("kwebmap_scale", 15);
    if (this.uZt <= 0) {
      this.uZt = 15;
    }
    this.jDf = this.activity.getIntent().getStringExtra("kPoiName");
    paramBundle = this.activity.getIntent().getStringExtra("Kwebmap_locaion");
    ad.d("MicroMsg.ViewMapUI", "view " + d1 + " " + d2);
    LocationInfo localLocationInfo = this.veW;
    localLocationInfo.uZr = d1;
    localLocationInfo.uZs = d2;
    localLocationInfo.uZu = paramBundle;
    localLocationInfo.uZt = this.uZt;
    localLocationInfo.dDq = this.jDf;
    this.msgId = this.activity.getIntent().getLongExtra("kMsgId", -1L);
    this.vaL = this.activity.getIntent().getStringExtra("map_talker_name");
    initView();
    AppMethodBeat.o(56216);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(56221);
    this.giA.release();
    this.handler.removeCallbacks(this.viu);
    this.handler = null;
    com.tencent.mm.kernel.g.aiU().b(424, this);
    super.onDestroy();
    AppMethodBeat.o(56221);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(56215);
    ad.d("MicroMsg.ViewMapUI", "onbaseGeoResume");
    if (this.vfh != null) {
      this.vfh.c(this.viv);
    }
    super.onPause();
    AppMethodBeat.o(56215);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(56214);
    super.onResume();
    ad.d("MicroMsg.ViewMapUI", "onbaseGeoResume");
    if (this.vfh != null) {
      this.vfh.b(this.viv, true);
    }
    AppMethodBeat.o(56214);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(56224);
    ad.d("MicroMsg.ViewMapUI", "onScene end %d %d %d", new Object[] { Integer.valueOf(paramn.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramn.getType() == 424)
    {
      if ((paramInt2 == 0) && (paramInt1 == 0))
      {
        paramString = com.tencent.mm.modelsimple.w.Gp(((com.tencent.mm.modelsimple.w)paramn).aLb().GDJ);
        ad.d("MicroMsg.ViewMapUI", "getUrl success! url is %s", new Object[] { paramString });
        this.viq = paramString;
        if (!bt.isNullOrNil(paramString)) {
          this.vit = true;
        }
        if ((this.type == 9) && (!bt.isNullOrNil(paramString)))
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
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/location/ui/impl/ViewMapUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
              k.this.dhy();
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/location/ui/impl/ViewMapUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(56207);
            }
          });
        }
        AppMethodBeat.o(56224);
      }
    }
    else {
      ad.e("MicroMsg.ViewMapUI", "msg failed.errtype:%d, errcode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    }
    AppMethodBeat.o(56224);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.k
 * JD-Core Version:    0.7.0.1
 */