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
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.cn;
import com.tencent.mm.g.a.cn.b;
import com.tencent.mm.g.a.dx;
import com.tencent.mm.g.a.dx.b;
import com.tencent.mm.g.a.ms;
import com.tencent.mm.model.u;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location.ui.l.a;
import com.tencent.mm.plugin.location_soso.ViewManager;
import com.tencent.mm.pluginsdk.ui.tools.AppChooserUI;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.afz;
import com.tencent.mm.protocal.protobuf.agi;
import com.tencent.mm.protocal.protobuf.ago;
import com.tencent.mm.protocal.protobuf.agq;
import com.tencent.mm.protocal.protobuf.agu;
import com.tencent.mm.protocal.protobuf.cmu;
import com.tencent.mm.protocal.protobuf.cmv;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnInfoWindowClickListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class k
  extends a
  implements com.tencent.mm.al.g
{
  private boolean drV;
  public com.tencent.mm.remoteservice.d fLo;
  private boolean jVE;
  protected long msgId;
  private long sTp;
  private String sXt;
  com.tencent.mm.plugin.location.ui.l sXu;
  com.tencent.mm.ui.widget.a.e sXv;
  boolean sXw;
  private Runnable sXx;
  private b.a sXy;
  
  public k(Activity paramActivity)
  {
    super(paramActivity);
    AppMethodBeat.i(56208);
    this.msgId = -1L;
    this.sXt = "";
    this.drV = true;
    this.fLo = new com.tencent.mm.remoteservice.d(this.activity);
    this.sXw = false;
    this.sXy = new b.a()
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
        ad.d("MicroMsg.ViewMapUI", "myLocation " + k.this.sUb.sOv + " " + k.this.sUb.sOw);
        ad.d("MicroMsg.ViewMapUI", "location my show");
        k.this.sUb.sOv = paramAnonymousFloat2;
        k.this.sUb.sOw = paramAnonymousFloat1;
        k.this.sUf.a(k.this.sUb.sOv, k.this.sUb.sOw, k.this.sUm, k.this.sUb.sOu);
        AppMethodBeat.o(56205);
        return true;
      }
    };
    this.jVE = false;
    this.sTp = 0L;
    com.tencent.mm.kernel.g.aeS().a(424, this);
    AppMethodBeat.o(56208);
  }
  
  private Intent cKG()
  {
    AppMethodBeat.i(56211);
    Intent localIntent = new Intent();
    localIntent.putExtra("kfavorite", true);
    localIntent.putExtra("kopenGmapNums", this.sTZ.sQD);
    localIntent.putExtra("kopenOthersNums", this.sTZ.sQE);
    localIntent.putExtra("kopenreportType", this.sTZ.dvJ);
    localIntent.putExtra("kRemark", cKd());
    localIntent.putExtra("kwebmap_slat", this.sUa.sOv);
    localIntent.putExtra("kwebmap_lng", this.sUa.sOw);
    localIntent.putExtra("Kwebmap_locaion", this.sUa.sOy);
    localIntent.putExtra("kPoiName", this.goQ);
    AppMethodBeat.o(56211);
    return localIntent;
  }
  
  protected final String aHv()
  {
    AppMethodBeat.i(56222);
    String str = getString(2131760728);
    AppMethodBeat.o(56222);
    return str;
  }
  
  public void cKA() {}
  
  protected void cKB() {}
  
  final void cKF()
  {
    AppMethodBeat.i(56210);
    this.sXv = new com.tencent.mm.ui.widget.a.e(this.activity, 1, false);
    this.sXv.HrX = new n.c()
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
          dx localdx = new dx();
          localdx.dgp.msgId = k.this.msgId;
          com.tencent.mm.sdk.b.a.ESL.l(localdx);
          if ((localdx.dgq.dfO) || (com.tencent.mm.pluginsdk.model.app.h.q(aj.getContext(), 4L))) {
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
    this.sXv.HrY = new n.d()
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
          k.this.cKH();
          AppMethodBeat.o(56202);
          return;
          if (k.this.type == 2) {
            com.tencent.mm.plugin.fav.a.h.i(k.this.activity.getIntent().getLongExtra("kFavInfoLocalId", -1L), 1, 0);
          }
          paramAnonymousMenuItem = new Intent();
          paramAnonymousMenuItem.putExtra("Retr_Msg_content", com.tencent.mm.plugin.location.model.e.a(k.this.sUa));
          paramAnonymousMenuItem.putExtra("Retr_Msg_Type", 9);
          com.tencent.mm.bs.d.e(k.this.activity, ".ui.transmit.MsgRetransmitUI", paramAnonymousMenuItem);
          AppMethodBeat.o(56202);
          return;
          k.this.diY = 0;
          k.this.cKJ();
          AppMethodBeat.o(56202);
          return;
          k.this.cKI();
          AppMethodBeat.o(56202);
          return;
          com.tencent.mm.ui.base.h.a(k.this.activity, k.this.activity.getString(2131755709), "", new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(56201);
              long l = k.this.activity.getIntent().getLongExtra("kFavInfoLocalId", -1L);
              paramAnonymous2DialogInterface = new cn();
              paramAnonymous2DialogInterface.deJ.deL = l;
              com.tencent.mm.sdk.b.a.ESL.l(paramAnonymous2DialogInterface);
              boolean bool = bt.a(Boolean.valueOf(paramAnonymous2DialogInterface.deK.dew), false);
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
          paramAnonymousMenuItem.putExtra("Retr_Msg_content", com.tencent.mm.plugin.location.model.e.a(k.this.sUa));
          paramAnonymousMenuItem.putExtra("Retr_Msg_Id", k.this.msgId);
          com.tencent.mm.bs.d.e(k.this.activity, ".ui.chatting.ChattingSendDataToDeviceUI", paramAnonymousMenuItem);
          AppMethodBeat.o(56202);
          return;
          try
          {
            l = k.this.activity.getIntent().getLongExtra("kFavInfoLocalId", -1L);
            paramAnonymousMenuItem = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().pS(l);
            com.tencent.mm.plugin.report.service.h.vKh.f(15378, new Object[] { Integer.valueOf(paramAnonymousMenuItem.field_id), Integer.valueOf(paramAnonymousMenuItem.field_type) });
            ad.d("MicroMsg.ViewMapUI", "report 15378, id:%s, type:%s", new Object[] { Integer.valueOf(paramAnonymousMenuItem.field_id), Integer.valueOf(paramAnonymousMenuItem.field_type) });
            paramAnonymousMenuItem.field_flag = 0;
            paramAnonymousMenuItem.field_updateTime = System.currentTimeMillis();
            paramAnonymousMenuItem.field_localId = -1L;
            paramAnonymousMenuItem.field_sourceType = 6;
            if (paramAnonymousMenuItem.field_favProto.DiD != null)
            {
              paramAnonymousMenuItem.field_favProto.DiD.aEn("");
              paramAnonymousMenuItem.field_favProto.DiD.VM(6);
              paramAnonymousMenuItem.field_favProto.DiD.aEl(u.aqG());
            }
            paramAnonymousMenuItem.field_fromUser = u.aqG();
            Object localObject1 = new LinkedList();
            Object localObject2 = new afy();
            Object localObject3 = new afz();
            ((afz)localObject3).c(paramAnonymousMenuItem.field_favProto.DhC);
            ((afy)localObject2).a((afz)localObject3);
            ((afy)localObject2).aDI("WeNote_0");
            ((afy)localObject2).VD(6);
            ((LinkedList)localObject1).add(0, localObject2);
            paramAnonymousMenuItem.field_favProto.bd((LinkedList)localObject1);
            paramAnonymousMenuItem.field_type = 18;
            paramAnonymousMenuItem.field_xml = com.tencent.mm.plugin.fav.a.g.t(paramAnonymousMenuItem);
            localObject1 = new agq();
            localObject3 = k.this.activity;
            localObject2 = new ms();
            ((ms)localObject2).drL.field_localId = paramAnonymousMenuItem.field_localId;
            ((ms)localObject2).drL.drU = 5;
            ((ms)localObject2).drL.drN = paramAnonymousMenuItem.field_xml;
            ((ms)localObject2).drL.context = ((Context)localObject3);
            localObject3 = new Bundle();
            agi localagi = paramAnonymousMenuItem.field_favProto.Csh;
            if (localagi != null)
            {
              ((Bundle)localObject3).putString("noteauthor", localagi.Diw);
              ((Bundle)localObject3).putString("noteeditor", localagi.Dix);
            }
            ((Bundle)localObject3).putLong("edittime", paramAnonymousMenuItem.field_updateTime);
            ((ms)localObject2).drL.drS = ((Bundle)localObject3);
            ((ms)localObject2).drL.field_favProto = paramAnonymousMenuItem.field_favProto;
            ((ms)localObject2).drL.type = 2;
            ((ms)localObject2).drL.drV = true;
            ((ms)localObject2).drL.drW = ((agq)localObject1);
            com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject2);
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
  
  protected final void cKH()
  {
    AppMethodBeat.i(56213);
    if (this.sXw)
    {
      com.tencent.mm.pluginsdk.ui.tools.w.a(new com.tencent.mm.pluginsdk.ui.tools.g());
      Intent localIntent = new Intent();
      localIntent.putExtra("show_bottom", false);
      localIntent.putExtra("jsapi_args_appid", "wx751a1acca5688ba3");
      localIntent.putExtra("rawUrl", this.sXt);
      localIntent.putExtra("title", 2131762812);
      localIntent.putExtra("webview_bg_color_rsID", 2131100017);
      com.tencent.mm.bs.d.b(this.activity, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent);
    }
    AppMethodBeat.o(56213);
  }
  
  protected final void cKI()
  {
    AppMethodBeat.i(56218);
    ad.d("MicroMsg.ViewMapUI", "directlyFavorite lat %s, long %s, scale", new Object[] { Double.valueOf(this.sUa.sOv), Double.valueOf(this.sUa.sOw) });
    Intent localIntent = cKG();
    this.activity.setResult(-1, localIntent);
    this.activity.getIntent().getIntExtra("MMActivity.OverrideEnterAnimation", -1);
    this.activity.getIntent().getIntExtra("MMActivity.OverrideExitAnimation", -1);
    this.activity.finish();
    AppMethodBeat.o(56218);
  }
  
  protected final void cKJ()
  {
    AppMethodBeat.i(56219);
    ad.d("MicroMsg.ViewMapUI", "locationLine, locationInfo.slat=%f, locationInfo.slong=%f, myLocation.slat=%f, myLocation.slong=%f", new Object[] { Double.valueOf(this.sUa.sOv), Double.valueOf(this.sUa.sOw), Double.valueOf(this.sUb.sOv), Double.valueOf(this.sUb.sOw) });
    if (this.sUb.cJg())
    {
      cKB();
      AppMethodBeat.o(56219);
      return;
    }
    com.tencent.mm.plugin.report.service.h.vKh.f(12809, new Object[] { Integer.valueOf(3), "" });
    this.sUg = true;
    if (this.handler == null)
    {
      AppMethodBeat.o(56219);
      return;
    }
    if (this.sXx != null) {
      this.handler.removeCallbacks(this.sXx);
    }
    this.sXx = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(56206);
        if (k.this.sUg)
        {
          if (k.this.fpP != null) {
            k.this.fpP.dismiss();
          }
          k.this.cKB();
        }
        k.this.sUg = false;
        AppMethodBeat.o(56206);
      }
    };
    this.handler.postDelayed(this.sXx, 10000L);
    Activity localActivity = this.activity;
    getString(2131755906);
    this.fpP = com.tencent.mm.ui.base.h.b(localActivity, getString(2131760067), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        k.this.sUg = false;
      }
    });
    AppMethodBeat.o(56219);
  }
  
  protected void cKe()
  {
    AppMethodBeat.i(56217);
    Intent localIntent = new Intent();
    localIntent.putExtra("kopenGmapNums", this.sTZ.sQD);
    localIntent.putExtra("kopenOthersNums", this.sTZ.sQE);
    localIntent.putExtra("kopenreportType", this.sTZ.dvJ);
    localIntent.putExtra("kRemark", cKd());
    localIntent.putExtra("soso_street_view_url", this.sXt);
    this.activity.setResult(-1, localIntent);
    AppMethodBeat.o(56217);
  }
  
  void cKf()
  {
    AppMethodBeat.i(56212);
    this.sUc.sUs.setEnabled(true);
    this.sUc.sUo.setVisibility(8);
    c(this.sUa);
    this.sUc.sQT.getIController().setZoom(this.sOx);
    this.sUc.sUq.setEnabled(true);
    this.drV = this.activity.getIntent().getBooleanExtra("kShowshare", true);
    label150:
    Object localObject1;
    Object localObject2;
    if (this.drV)
    {
      this.sUc.sUq.setVisibility(0);
      this.sXt = this.activity.getIntent().getStringExtra("soso_street_view_url");
      if ((bt.isNullOrNil(this.sXt)) || ((!ac.eFs()) && (!ac.eFr()))) {
        break label601;
      }
      this.sXw = true;
      this.sUc.sUq.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(56203);
          k.this.cKF();
          k.this.sXv.csG();
          AppMethodBeat.o(56203);
        }
      });
      this.sXu = new com.tencent.mm.plugin.location.ui.l(this.sUc.sQT, this.activity);
      localObject1 = this.sXu;
      if (((com.tencent.mm.plugin.location.ui.l)localObject1).mViewManager != null)
      {
        ((com.tencent.mm.plugin.location.ui.l)localObject1).mViewManager.addView(((com.tencent.mm.plugin.location.ui.l)localObject1).sTQ, 0.0D, 0.0D);
        ((com.tencent.mm.plugin.location.ui.l)localObject1).mViewManager.setMarkerTag(((com.tencent.mm.plugin.location.ui.l)localObject1).sTQ, "info_window_tag");
        if (((com.tencent.mm.plugin.location.ui.l)localObject1).sTT)
        {
          ((com.tencent.mm.plugin.location.ui.l)localObject1).mViewManager.setInfoWindowAdapter(new l.a((com.tencent.mm.plugin.location.ui.l)localObject1, (byte)0));
          ((com.tencent.mm.plugin.location.ui.l)localObject1).mViewManager.showInfoWindowByView(((com.tencent.mm.plugin.location.ui.l)localObject1).sTQ);
        }
      }
      localObject1 = this.sXu;
      localObject2 = this.sUa;
      ((com.tencent.mm.plugin.location.ui.l)localObject1).sOv = ((LocationInfo)localObject2).sOv;
      ((com.tencent.mm.plugin.location.ui.l)localObject1).sOw = ((LocationInfo)localObject2).sOw;
      if (!com.tencent.mm.plugin.location.model.e.j(this.sUa.sOv, this.sUa.sOw))
      {
        ad.d("MicroMsg.ViewMapUI", "isValidLatLng %f %f", new Object[] { Double.valueOf(this.sUa.sOv), Double.valueOf(this.sUa.sOw) });
        localObject1 = this.sXu;
        ((com.tencent.mm.plugin.location.ui.l)localObject1).sQR = false;
        ((com.tencent.mm.plugin.location.ui.l)localObject1).sTR.setVisibility(8);
      }
      if (2 == this.type)
      {
        ad.i("MicroMsg.ViewMapUI", "location id %s", new Object[] { this.sUa.sOu });
        if (this.activity.getIntent().getBooleanExtra("kFavCanRemark", true)) {
          cKc();
        }
        if (!bt.isNullOrNil(this.sUa.sOy)) {
          this.sUc.sUp.setVisibility(0);
        }
      }
      this.sUe.put(this.sUa.sOu, this.sXu);
      if (!this.sUa.cJh()) {
        break label700;
      }
      if ((this.goQ != null) && (!this.goQ.equals(""))) {
        this.sXu.goQ = this.goQ;
      }
      this.sXu.setText(this.sXu.getPreText() + this.sUa.sOy);
    }
    for (;;)
    {
      for (;;)
      {
        localObject1 = this.sXu;
        localObject2 = new TencentMap.OnInfoWindowClickListener()
        {
          public final void onInfoWindowClick(Marker paramAnonymousMarker)
          {
            AppMethodBeat.i(56204);
            k.this.diY = 0;
            k.this.cKy();
            k.this.cKJ();
            AppMethodBeat.o(56204);
          }
        };
        if ((((com.tencent.mm.plugin.location.ui.l)localObject1).sTT) && (((com.tencent.mm.plugin.location.ui.l)localObject1).mViewManager != null)) {
          ((com.tencent.mm.plugin.location.ui.l)localObject1).mViewManager.setInfoWindowClick(((com.tencent.mm.plugin.location.ui.l)localObject1).sTQ, (TencentMap.OnInfoWindowClickListener)localObject2);
        }
        AppMethodBeat.o(56212);
        return;
        this.sUc.sUq.setVisibility(8);
        break;
        label601:
        if ((!ac.eFs()) && (!ac.eFr())) {
          break label150;
        }
        this.sXw = false;
        try
        {
          localObject1 = (cmu)new com.tencent.mm.modelsimple.w((float)this.sUa.sOw, (float)this.sUa.sOv, this.msgId).rr.gUS.gUX;
          new com.tencent.mm.modelsimple.w((cmu)localObject1);
          com.tencent.mm.kernel.g.aeS().a(new com.tencent.mm.modelsimple.w((cmu)localObject1), 0);
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.ViewMapUI", localException.toString());
        }
      }
      break label150;
      label700:
      if (com.tencent.mm.plugin.location.model.e.j(this.sUa.sOv, this.sUa.sOw)) {
        this.sUf.a(this.sUa.sOv, this.sUa.sOw, this.sUm, this.sUa.sOu);
      }
    }
  }
  
  public boolean cKg()
  {
    AppMethodBeat.i(56209);
    if ((this.sXv != null) && (this.sXv.isShowing())) {
      this.sXv.bfo();
    }
    for (;;)
    {
      AppMethodBeat.o(56209);
      return true;
      cKF();
      this.sXv.csG();
    }
  }
  
  public void cKx() {}
  
  protected void cKy() {}
  
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
      if ((Math.abs(paramMotionEvent.getX() - this.qXK) > 10.0F) || (Math.abs(paramMotionEvent.getY() - this.seQ) > 10.0F))
      {
        this.jVE = true;
        cKx();
        continue;
        this.qXK = paramMotionEvent.getX();
        this.seQ = paramMotionEvent.getY();
        this.sTp = System.currentTimeMillis();
        this.jVE = false;
        cKA();
        continue;
        if (!this.jVE) {
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
      Object localObject1 = this.sTZ;
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
            com.tencent.mm.plugin.report.service.h.vKh.f(11091, new Object[] { Integer.valueOf(6), Integer.valueOf(2) });
            paramIntent = paramIntent.getBundleExtra("transferback").getParcelableArrayList("locations");
            localObject2 = (LocationInfo)paramIntent.get(0);
            localObject3 = (LocationInfo)paramIntent.get(1);
            if (!bt.isNullOrNil(((LocationInfo)localObject2).sOz)) {
              break label483;
            }
          }
          for (paramIntent = "zh-cn";; paramIntent = ((LocationInfo)localObject2).sOz)
          {
            paramIntent = new Intent("android.intent.action.VIEW", Uri.parse(String.format("http://maps.google.com/maps?f=d&saddr=%f,%f&daddr=%f,%f&hl=".concat(String.valueOf(paramIntent)), new Object[] { Double.valueOf(((LocationInfo)localObject3).sOv), Double.valueOf(((LocationInfo)localObject3).sOw), Double.valueOf(((LocationInfo)localObject2).sOv), Double.valueOf(((LocationInfo)localObject2).sOw) })));
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
            com.tencent.mm.plugin.report.service.h.vKh.f(11091, new Object[] { Integer.valueOf(6), Integer.valueOf(1) });
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
          paramIntent = new com.tencent.mm.hellhoundlib.b.a().bd(paramIntent);
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, paramIntent.adn(), "com/tencent/mm/plugin/location/ui/MapHelper", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Context)localObject1).startActivity((Intent)paramIntent.lS(0));
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
    this.sOx = this.activity.getIntent().getIntExtra("kwebmap_scale", 15);
    if (this.sOx <= 0) {
      this.sOx = 15;
    }
    this.goQ = this.activity.getIntent().getStringExtra("kPoiName");
    paramBundle = this.activity.getIntent().getStringExtra("Kwebmap_locaion");
    ad.d("MicroMsg.ViewMapUI", "view " + d1 + " " + d2);
    LocationInfo localLocationInfo = this.sUa;
    localLocationInfo.sOv = d1;
    localLocationInfo.sOw = d2;
    localLocationInfo.sOy = paramBundle;
    localLocationInfo.sOx = this.sOx;
    localLocationInfo.dtN = this.goQ;
    this.msgId = this.activity.getIntent().getLongExtra("kMsgId", -1L);
    this.sPP = this.activity.getIntent().getStringExtra("map_talker_name");
    initView();
    AppMethodBeat.o(56216);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(56221);
    this.fLo.release();
    this.handler.removeCallbacks(this.sXx);
    this.handler = null;
    com.tencent.mm.kernel.g.aeS().b(424, this);
    super.onDestroy();
    AppMethodBeat.o(56221);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(56215);
    ad.d("MicroMsg.ViewMapUI", "onbaseGeoResume");
    if (this.sUl != null) {
      this.sUl.c(this.sXy);
    }
    super.onPause();
    AppMethodBeat.o(56215);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(56214);
    super.onResume();
    ad.d("MicroMsg.ViewMapUI", "onbaseGeoResume");
    if (this.sUl != null) {
      this.sUl.b(this.sXy, true);
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
        paramString = com.tencent.mm.modelsimple.w.zf(((com.tencent.mm.modelsimple.w)paramn).aBa().DyQ);
        ad.d("MicroMsg.ViewMapUI", "getUrl success! url is %s", new Object[] { paramString });
        this.sXt = paramString;
        if (!bt.isNullOrNil(paramString)) {
          this.sXw = true;
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
              k.this.cKH();
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