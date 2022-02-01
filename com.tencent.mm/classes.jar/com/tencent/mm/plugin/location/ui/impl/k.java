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
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.dy;
import com.tencent.mm.g.a.dy.b;
import com.tencent.mm.g.a.nb;
import com.tencent.mm.model.u;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location.ui.l.a;
import com.tencent.mm.plugin.location_soso.ViewManager;
import com.tencent.mm.pluginsdk.ui.tools.AppChooserUI;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.agy;
import com.tencent.mm.protocal.protobuf.ahh;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.protocal.protobuf.ahp;
import com.tencent.mm.protocal.protobuf.aht;
import com.tencent.mm.protocal.protobuf.csb;
import com.tencent.mm.protocal.protobuf.csc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnInfoWindowClickListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class k
  extends a
  implements com.tencent.mm.ak.g
{
  private boolean dpG;
  public com.tencent.mm.remoteservice.d fPa;
  private boolean kwq;
  protected long msgId;
  private long ubB;
  private String ufG;
  com.tencent.mm.plugin.location.ui.l ufH;
  com.tencent.mm.ui.widget.a.e ufI;
  boolean ufJ;
  private Runnable ufK;
  private b.a ufL;
  
  public k(Activity paramActivity)
  {
    super(paramActivity);
    AppMethodBeat.i(56208);
    this.msgId = -1L;
    this.ufG = "";
    this.dpG = true;
    this.fPa = new com.tencent.mm.remoteservice.d(this.activity);
    this.ufJ = false;
    this.ufL = new b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(56205);
        if (!paramAnonymousBoolean)
        {
          AppMethodBeat.o(56205);
          return false;
        }
        ac.d("MicroMsg.ViewMapUI", "onGetLocation flong " + paramAnonymousFloat1 + " flat " + paramAnonymousFloat2);
        if ((paramAnonymousFloat2 == 0.0D) && (paramAnonymousFloat1 == 0.0D))
        {
          AppMethodBeat.o(56205);
          return true;
        }
        ac.d("MicroMsg.ViewMapUI", "myLocation " + k.this.ucn.tWI + " " + k.this.ucn.tWJ);
        ac.d("MicroMsg.ViewMapUI", "location my show");
        k.this.ucn.tWI = paramAnonymousFloat2;
        k.this.ucn.tWJ = paramAnonymousFloat1;
        k.this.ucr.a(k.this.ucn.tWI, k.this.ucn.tWJ, k.this.ucy, k.this.ucn.tWH);
        AppMethodBeat.o(56205);
        return true;
      }
    };
    this.kwq = false;
    this.ubB = 0L;
    com.tencent.mm.kernel.g.agi().a(424, this);
    AppMethodBeat.o(56208);
  }
  
  private Intent cYl()
  {
    AppMethodBeat.i(56211);
    Intent localIntent = new Intent();
    localIntent.putExtra("kfavorite", true);
    localIntent.putExtra("kopenGmapNums", this.ucl.tYQ);
    localIntent.putExtra("kopenOthersNums", this.ucl.tYR);
    localIntent.putExtra("kopenreportType", this.ucl.dtw);
    localIntent.putExtra("kRemark", cXI());
    localIntent.putExtra("kwebmap_slat", this.ucm.tWI);
    localIntent.putExtra("kwebmap_lng", this.ucm.tWJ);
    localIntent.putExtra("Kwebmap_locaion", this.ucm.tWL);
    localIntent.putExtra("kPoiName", this.gPy);
    AppMethodBeat.o(56211);
    return localIntent;
  }
  
  protected final String aOk()
  {
    AppMethodBeat.i(56222);
    String str = getString(2131760728);
    AppMethodBeat.o(56222);
    return str;
  }
  
  protected void cXJ()
  {
    AppMethodBeat.i(56217);
    Intent localIntent = new Intent();
    localIntent.putExtra("kopenGmapNums", this.ucl.tYQ);
    localIntent.putExtra("kopenOthersNums", this.ucl.tYR);
    localIntent.putExtra("kopenreportType", this.ucl.dtw);
    localIntent.putExtra("kRemark", cXI());
    localIntent.putExtra("soso_street_view_url", this.ufG);
    this.activity.setResult(-1, localIntent);
    AppMethodBeat.o(56217);
  }
  
  void cXK()
  {
    AppMethodBeat.i(56212);
    this.uco.ucE.setEnabled(true);
    this.uco.ucA.setVisibility(8);
    c(this.ucm);
    this.uco.tZg.getIController().setZoom(this.tWK);
    this.uco.ucC.setEnabled(true);
    this.dpG = this.activity.getIntent().getBooleanExtra("kShowshare", true);
    label148:
    Object localObject1;
    Object localObject2;
    if (this.dpG)
    {
      this.uco.ucC.setVisibility(0);
      this.ufG = this.activity.getIntent().getStringExtra("soso_street_view_url");
      if ((bs.isNullOrNil(this.ufG)) || ((!ab.eUM()) && (!ab.eUL()))) {
        break label598;
      }
      this.ufJ = true;
      this.uco.ucC.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(56203);
          k.this.cYk();
          k.this.ufI.cED();
          AppMethodBeat.o(56203);
        }
      });
      this.ufH = new com.tencent.mm.plugin.location.ui.l(this.uco.tZg, this.activity);
      localObject1 = this.ufH;
      if (((com.tencent.mm.plugin.location.ui.l)localObject1).mViewManager != null)
      {
        ((com.tencent.mm.plugin.location.ui.l)localObject1).mViewManager.addView(((com.tencent.mm.plugin.location.ui.l)localObject1).ucc, 0.0D, 0.0D);
        ((com.tencent.mm.plugin.location.ui.l)localObject1).mViewManager.setMarkerTag(((com.tencent.mm.plugin.location.ui.l)localObject1).ucc, "info_window_tag");
        if (((com.tencent.mm.plugin.location.ui.l)localObject1).ucf)
        {
          ((com.tencent.mm.plugin.location.ui.l)localObject1).mViewManager.setInfoWindowAdapter(new l.a((com.tencent.mm.plugin.location.ui.l)localObject1, (byte)0));
          ((com.tencent.mm.plugin.location.ui.l)localObject1).mViewManager.showInfoWindowByView(((com.tencent.mm.plugin.location.ui.l)localObject1).ucc);
        }
      }
      localObject1 = this.ufH;
      localObject2 = this.ucm;
      ((com.tencent.mm.plugin.location.ui.l)localObject1).tWI = ((LocationInfo)localObject2).tWI;
      ((com.tencent.mm.plugin.location.ui.l)localObject1).tWJ = ((LocationInfo)localObject2).tWJ;
      if (!com.tencent.mm.plugin.location.model.e.j(this.ucm.tWI, this.ucm.tWJ))
      {
        ac.d("MicroMsg.ViewMapUI", "isValidLatLng %f %f", new Object[] { Double.valueOf(this.ucm.tWI), Double.valueOf(this.ucm.tWJ) });
        localObject1 = this.ufH;
        ((com.tencent.mm.plugin.location.ui.l)localObject1).tZe = false;
        ((com.tencent.mm.plugin.location.ui.l)localObject1).ucd.setVisibility(8);
      }
      if (2 == this.type)
      {
        ac.i("MicroMsg.ViewMapUI", "location id %s", new Object[] { this.ucm.tWH });
        if (this.activity.getIntent().getBooleanExtra("kFavCanRemark", true)) {
          cXH();
        }
        if (!bs.isNullOrNil(this.ucm.tWL)) {
          this.uco.ucB.setVisibility(0);
        }
      }
      this.ucq.put(this.ucm.tWH, this.ufH);
      if (!this.ucm.cWM()) {
        break label697;
      }
      if ((this.gPy != null) && (!this.gPy.equals(""))) {
        this.ufH.gPy = this.gPy;
      }
      this.ufH.setText(this.ufH.getPreText() + this.ucm.tWL);
    }
    for (;;)
    {
      for (;;)
      {
        localObject1 = this.ufH;
        localObject2 = new TencentMap.OnInfoWindowClickListener()
        {
          public final void onInfoWindowClick(Marker paramAnonymousMarker)
          {
            AppMethodBeat.i(56204);
            k.this.dgt = 0;
            k.this.cYd();
            k.this.cYo();
            AppMethodBeat.o(56204);
          }
        };
        if ((((com.tencent.mm.plugin.location.ui.l)localObject1).ucf) && (((com.tencent.mm.plugin.location.ui.l)localObject1).mViewManager != null)) {
          ((com.tencent.mm.plugin.location.ui.l)localObject1).mViewManager.setInfoWindowClick(((com.tencent.mm.plugin.location.ui.l)localObject1).ucc, (TencentMap.OnInfoWindowClickListener)localObject2);
        }
        AppMethodBeat.o(56212);
        return;
        this.uco.ucC.setVisibility(8);
        break;
        label598:
        if ((!ab.eUM()) && (!ab.eUL())) {
          break label148;
        }
        this.ufJ = false;
        try
        {
          localObject1 = (csb)new com.tencent.mm.modelsimple.w((float)this.ucm.tWJ, (float)this.ucm.tWI, this.msgId).rr.hvr.hvw;
          new com.tencent.mm.modelsimple.w((csb)localObject1);
          com.tencent.mm.kernel.g.agi().a(new com.tencent.mm.modelsimple.w((csb)localObject1), 0);
        }
        catch (Exception localException)
        {
          ac.e("MicroMsg.ViewMapUI", localException.toString());
        }
      }
      break label148;
      label697:
      if (com.tencent.mm.plugin.location.model.e.j(this.ucm.tWI, this.ucm.tWJ)) {
        this.ucr.a(this.ucm.tWI, this.ucm.tWJ, this.ucy, this.ucm.tWH);
      }
    }
  }
  
  public boolean cXL()
  {
    AppMethodBeat.i(56209);
    if ((this.ufI != null) && (this.ufI.isShowing())) {
      this.ufI.bmi();
    }
    for (;;)
    {
      AppMethodBeat.o(56209);
      return true;
      cYk();
      this.ufI.cED();
    }
  }
  
  public void cYc() {}
  
  protected void cYd() {}
  
  public void cYf() {}
  
  protected void cYg() {}
  
  final void cYk()
  {
    AppMethodBeat.i(56210);
    this.ufI = new com.tencent.mm.ui.widget.a.e(this.activity, 1, false);
    this.ufI.ISu = new n.c()
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
          dy localdy = new dy();
          localdy.ddK.msgId = k.this.msgId;
          com.tencent.mm.sdk.b.a.GpY.l(localdy);
          if ((localdy.ddL.ddj) || (com.tencent.mm.pluginsdk.model.app.h.r(ai.getContext(), 4L))) {
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
    this.ufI.ISv = new n.d()
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
          k.this.cYm();
          AppMethodBeat.o(56202);
          return;
          if (k.this.type == 2) {
            com.tencent.mm.plugin.fav.a.h.i(k.this.activity.getIntent().getLongExtra("kFavInfoLocalId", -1L), 1, 0);
          }
          paramAnonymousMenuItem = new Intent();
          paramAnonymousMenuItem.putExtra("Retr_Msg_content", com.tencent.mm.plugin.location.model.e.a(k.this.ucm));
          paramAnonymousMenuItem.putExtra("Retr_Msg_Type", 9);
          com.tencent.mm.br.d.e(k.this.activity, ".ui.transmit.MsgRetransmitUI", paramAnonymousMenuItem);
          AppMethodBeat.o(56202);
          return;
          k.this.dgt = 0;
          k.this.cYo();
          AppMethodBeat.o(56202);
          return;
          k.this.cYn();
          AppMethodBeat.o(56202);
          return;
          com.tencent.mm.ui.base.h.a(k.this.activity, k.this.activity.getString(2131755709), "", new k.2.1(this), null);
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
          paramAnonymousMenuItem.putExtra("Retr_Msg_content", com.tencent.mm.plugin.location.model.e.a(k.this.ucm));
          paramAnonymousMenuItem.putExtra("Retr_Msg_Id", k.this.msgId);
          com.tencent.mm.br.d.e(k.this.activity, ".ui.chatting.ChattingSendDataToDeviceUI", paramAnonymousMenuItem);
          AppMethodBeat.o(56202);
          return;
          try
          {
            l = k.this.activity.getIntent().getLongExtra("kFavInfoLocalId", -1L);
            paramAnonymousMenuItem = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().tH(l);
            com.tencent.mm.plugin.report.service.h.wUl.f(15378, new Object[] { Integer.valueOf(paramAnonymousMenuItem.field_id), Integer.valueOf(paramAnonymousMenuItem.field_type) });
            ac.d("MicroMsg.ViewMapUI", "report 15378, id:%s, type:%s", new Object[] { Integer.valueOf(paramAnonymousMenuItem.field_id), Integer.valueOf(paramAnonymousMenuItem.field_type) });
            paramAnonymousMenuItem.field_flag = 0;
            paramAnonymousMenuItem.field_updateTime = System.currentTimeMillis();
            paramAnonymousMenuItem.field_localId = -1L;
            paramAnonymousMenuItem.field_sourceType = 6;
            if (paramAnonymousMenuItem.field_favProto.EBJ != null)
            {
              paramAnonymousMenuItem.field_favProto.EBJ.aJE("");
              paramAnonymousMenuItem.field_favProto.EBJ.XV(6);
              paramAnonymousMenuItem.field_favProto.EBJ.aJC(u.axw());
            }
            paramAnonymousMenuItem.field_fromUser = u.axw();
            Object localObject1 = new LinkedList();
            Object localObject2 = new agx();
            Object localObject3 = new agy();
            ((agy)localObject3).c(paramAnonymousMenuItem.field_favProto.EAI);
            ((agx)localObject2).a((agy)localObject3);
            ((agx)localObject2).aIZ("WeNote_0");
            ((agx)localObject2).XM(6);
            ((LinkedList)localObject1).add(0, localObject2);
            paramAnonymousMenuItem.field_favProto.bk((LinkedList)localObject1);
            paramAnonymousMenuItem.field_type = 18;
            paramAnonymousMenuItem.field_xml = com.tencent.mm.plugin.fav.a.g.t(paramAnonymousMenuItem);
            localObject1 = new ahp();
            localObject3 = k.this.activity;
            localObject2 = new nb();
            ((nb)localObject2).dpw.field_localId = paramAnonymousMenuItem.field_localId;
            ((nb)localObject2).dpw.dpF = 5;
            ((nb)localObject2).dpw.dpy = paramAnonymousMenuItem.field_xml;
            ((nb)localObject2).dpw.context = ((Context)localObject3);
            localObject3 = new Bundle();
            ahh localahh = paramAnonymousMenuItem.field_favProto.DKz;
            if (localahh != null)
            {
              ((Bundle)localObject3).putString("noteauthor", localahh.EBC);
              ((Bundle)localObject3).putString("noteeditor", localahh.EBD);
            }
            ((Bundle)localObject3).putLong("edittime", paramAnonymousMenuItem.field_updateTime);
            ((nb)localObject2).dpw.dpD = ((Bundle)localObject3);
            ((nb)localObject2).dpw.field_favProto = paramAnonymousMenuItem.field_favProto;
            ((nb)localObject2).dpw.type = 2;
            ((nb)localObject2).dpw.dpG = true;
            ((nb)localObject2).dpw.dpH = ((ahp)localObject1);
            com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject2);
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
  
  protected final void cYm()
  {
    AppMethodBeat.i(56213);
    if (this.ufJ)
    {
      com.tencent.mm.pluginsdk.ui.tools.w.a(new com.tencent.mm.pluginsdk.ui.tools.g());
      Intent localIntent = new Intent();
      localIntent.putExtra("show_bottom", false);
      localIntent.putExtra("jsapi_args_appid", "wx751a1acca5688ba3");
      localIntent.putExtra("rawUrl", this.ufG);
      localIntent.putExtra("title", 2131762812);
      localIntent.putExtra("webview_bg_color_rsID", 2131100017);
      com.tencent.mm.br.d.b(this.activity, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent);
    }
    AppMethodBeat.o(56213);
  }
  
  protected final void cYn()
  {
    AppMethodBeat.i(56218);
    ac.d("MicroMsg.ViewMapUI", "directlyFavorite lat %s, long %s, scale", new Object[] { Double.valueOf(this.ucm.tWI), Double.valueOf(this.ucm.tWJ) });
    Intent localIntent = cYl();
    this.activity.setResult(-1, localIntent);
    this.activity.getIntent().getIntExtra("MMActivity.OverrideEnterAnimation", -1);
    this.activity.getIntent().getIntExtra("MMActivity.OverrideExitAnimation", -1);
    this.activity.finish();
    AppMethodBeat.o(56218);
  }
  
  protected final void cYo()
  {
    AppMethodBeat.i(56219);
    ac.d("MicroMsg.ViewMapUI", "locationLine, locationInfo.slat=%f, locationInfo.slong=%f, myLocation.slat=%f, myLocation.slong=%f", new Object[] { Double.valueOf(this.ucm.tWI), Double.valueOf(this.ucm.tWJ), Double.valueOf(this.ucn.tWI), Double.valueOf(this.ucn.tWJ) });
    if (this.ucn.cWL())
    {
      cYg();
      AppMethodBeat.o(56219);
      return;
    }
    com.tencent.mm.plugin.report.service.h.wUl.f(12809, new Object[] { Integer.valueOf(3), "" });
    this.ucs = true;
    if (this.handler == null)
    {
      AppMethodBeat.o(56219);
      return;
    }
    if (this.ufK != null) {
      this.handler.removeCallbacks(this.ufK);
    }
    this.ufK = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(56206);
        if (k.this.ucs)
        {
          if (k.this.fts != null) {
            k.this.fts.dismiss();
          }
          k.this.cYg();
        }
        k.this.ucs = false;
        AppMethodBeat.o(56206);
      }
    };
    this.handler.postDelayed(this.ufK, 10000L);
    Activity localActivity = this.activity;
    getString(2131755906);
    this.fts = com.tencent.mm.ui.base.h.b(localActivity, getString(2131760067), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        k.this.ucs = false;
      }
    });
    AppMethodBeat.o(56219);
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
      if ((Math.abs(paramMotionEvent.getX() - this.rYu) > 10.0F) || (Math.abs(paramMotionEvent.getY() - this.tmJ) > 10.0F))
      {
        this.kwq = true;
        cYc();
        continue;
        this.rYu = paramMotionEvent.getX();
        this.tmJ = paramMotionEvent.getY();
        this.ubB = System.currentTimeMillis();
        this.kwq = false;
        cYf();
        continue;
        if (!this.kwq) {
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
      Object localObject1 = this.ucl;
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
            com.tencent.mm.plugin.report.service.h.wUl.f(11091, new Object[] { Integer.valueOf(6), Integer.valueOf(2) });
            paramIntent = paramIntent.getBundleExtra("transferback").getParcelableArrayList("locations");
            localObject2 = (LocationInfo)paramIntent.get(0);
            localObject3 = (LocationInfo)paramIntent.get(1);
            if (!bs.isNullOrNil(((LocationInfo)localObject2).tWM)) {
              break label483;
            }
          }
          for (paramIntent = "zh-cn";; paramIntent = ((LocationInfo)localObject2).tWM)
          {
            paramIntent = new Intent("android.intent.action.VIEW", Uri.parse(String.format("http://maps.google.com/maps?f=d&saddr=%f,%f&daddr=%f,%f&hl=".concat(String.valueOf(paramIntent)), new Object[] { Double.valueOf(((LocationInfo)localObject3).tWI), Double.valueOf(((LocationInfo)localObject3).tWJ), Double.valueOf(((LocationInfo)localObject2).tWI), Double.valueOf(((LocationInfo)localObject2).tWJ) })));
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
            com.tencent.mm.plugin.report.service.h.wUl.f(11091, new Object[] { Integer.valueOf(6), Integer.valueOf(1) });
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
          paramIntent = new com.tencent.mm.hellhoundlib.b.a().ba(paramIntent);
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, paramIntent.aeD(), "com/tencent/mm/plugin/location/ui/MapHelper", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Context)localObject1).startActivity((Intent)paramIntent.lR(0));
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
    ac.i("MicroMsg.ViewMapUI", "start dslat " + d1 + " " + d2);
    this.tWK = this.activity.getIntent().getIntExtra("kwebmap_scale", 15);
    if (this.tWK <= 0) {
      this.tWK = 15;
    }
    this.gPy = this.activity.getIntent().getStringExtra("kPoiName");
    paramBundle = this.activity.getIntent().getStringExtra("Kwebmap_locaion");
    ac.d("MicroMsg.ViewMapUI", "view " + d1 + " " + d2);
    LocationInfo localLocationInfo = this.ucm;
    localLocationInfo.tWI = d1;
    localLocationInfo.tWJ = d2;
    localLocationInfo.tWL = paramBundle;
    localLocationInfo.tWK = this.tWK;
    localLocationInfo.dry = this.gPy;
    this.msgId = this.activity.getIntent().getLongExtra("kMsgId", -1L);
    this.tYc = this.activity.getIntent().getStringExtra("map_talker_name");
    initView();
    AppMethodBeat.o(56216);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(56221);
    this.fPa.release();
    this.handler.removeCallbacks(this.ufK);
    this.handler = null;
    com.tencent.mm.kernel.g.agi().b(424, this);
    super.onDestroy();
    AppMethodBeat.o(56221);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(56215);
    ac.d("MicroMsg.ViewMapUI", "onbaseGeoResume");
    if (this.ucx != null) {
      this.ucx.c(this.ufL);
    }
    super.onPause();
    AppMethodBeat.o(56215);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(56214);
    super.onResume();
    ac.d("MicroMsg.ViewMapUI", "onbaseGeoResume");
    if (this.ucx != null) {
      this.ucx.b(this.ufL, true);
    }
    AppMethodBeat.o(56214);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(56224);
    ac.d("MicroMsg.ViewMapUI", "onScene end %d %d %d", new Object[] { Integer.valueOf(paramn.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramn.getType() == 424)
    {
      if ((paramInt2 == 0) && (paramInt1 == 0))
      {
        paramString = com.tencent.mm.modelsimple.w.Dk(((com.tencent.mm.modelsimple.w)paramn).aHQ().EUm);
        ac.d("MicroMsg.ViewMapUI", "getUrl success! url is %s", new Object[] { paramString });
        this.ufG = paramString;
        if (!bs.isNullOrNil(paramString)) {
          this.ufJ = true;
        }
        if ((this.type == 9) && (!bs.isNullOrNil(paramString)))
        {
          paramString = (TextView)findViewById(2131305503);
          paramString.setVisibility(0);
          paramString.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(56207);
              k.this.cYm();
              AppMethodBeat.o(56207);
            }
          });
        }
        AppMethodBeat.o(56224);
      }
    }
    else {
      ac.e("MicroMsg.ViewMapUI", "msg failed.errtype:%d, errcode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    }
    AppMethodBeat.o(56224);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.k
 * JD-Core Version:    0.7.0.1
 */