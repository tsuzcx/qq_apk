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
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.em;
import com.tencent.mm.f.a.em.b;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelsimple.x;
import com.tencent.mm.plugin.fav.a.ag;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location.ui.l;
import com.tencent.mm.plugin.location.ui.l.a;
import com.tencent.mm.plugin.location_soso.ViewManager;
import com.tencent.mm.plugin.map.a.b;
import com.tencent.mm.plugin.map.a.e;
import com.tencent.mm.plugin.map.a.i;
import com.tencent.mm.pluginsdk.ui.tools.AppChooserUI;
import com.tencent.mm.pluginsdk.ui.tools.aa;
import com.tencent.mm.pluginsdk.ui.tools.j;
import com.tencent.mm.protocal.protobuf.aoe;
import com.tencent.mm.protocal.protobuf.eat;
import com.tencent.mm.protocal.protobuf.eau;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnInfoWindowClickListener;
import java.util.ArrayList;
import java.util.HashMap;

public class k
  extends a
  implements i
{
  private long Eoe;
  private String Esi;
  l Esj;
  boolean Esk;
  private Runnable Esl;
  private b.a Esm;
  private boolean fNQ;
  public com.tencent.mm.remoteservice.d jGJ;
  protected long msgId;
  private boolean oZf;
  private com.tencent.mm.ui.widget.a.e uaG;
  
  public k(Activity paramActivity)
  {
    super(paramActivity);
    AppMethodBeat.i(56208);
    this.msgId = -1L;
    this.Esi = "";
    this.fNQ = true;
    this.jGJ = new com.tencent.mm.remoteservice.d(this.activity);
    this.Esk = false;
    this.Esm = new b.a()
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
        Log.d("MicroMsg.ViewMapUI", "myLocation " + k.this.oUW.Ejn + " " + k.this.oUW.Ejo);
        Log.d("MicroMsg.ViewMapUI", "location my show");
        k.this.oUW.Ejn = paramAnonymousFloat2;
        k.this.oUW.Ejo = paramAnonymousFloat1;
        k.this.EoR.a(k.this.oUW.Ejn, k.this.oUW.Ejo, k.this.EoX, k.this.oUW.Ejm);
        AppMethodBeat.o(56205);
        return true;
      }
    };
    this.oZf = false;
    this.Eoe = 0L;
    com.tencent.mm.kernel.h.aGY().a(424, this);
    AppMethodBeat.o(56208);
  }
  
  private void bXG()
  {
    AppMethodBeat.i(56210);
    this.uaG = new com.tencent.mm.ui.widget.a.e(this.activity, 1, false);
    this.uaG.ODT = new q.f()
    {
      public final void onCreateMMMenu(o paramAnonymouso)
      {
        AppMethodBeat.i(56200);
        paramAnonymouso.b(1, k.this.getString(a.i.app_share_to_weixin), 0);
        if (k.this.type == 1) {
          paramAnonymouso.b(3, k.this.getString(a.i.plugin_favorite_opt), 0);
        }
        for (;;)
        {
          em localem = new em();
          localem.fAp.msgId = k.this.msgId;
          EventCenter.instance.publish(localem);
          if ((localem.fAq.fzO) || (com.tencent.mm.pluginsdk.model.app.h.u(MMApplicationContext.getContext(), 4L))) {
            paramAnonymouso.b(6, k.this.getString(a.i.download_other_open), 0);
          }
          AppMethodBeat.o(56200);
          return;
          if (k.this.type == 2)
          {
            if (k.this.activity.getIntent().getBooleanExtra("kFavCanDel", true))
            {
              paramAnonymouso.b(7, k.this.getString(a.i.favorite_save_as_note_1), 0);
              paramAnonymouso.b(5, k.this.getString(a.i.favorite_edit_tag_tips_1), 0);
              paramAnonymouso.b(4, k.this.getString(a.i.app_delete), 0);
            }
          }
          else if (k.this.type == 10) {
            paramAnonymouso.b(8, k.this.getString(a.i.plugin_favorite_opt), 0);
          }
        }
      }
    };
    this.uaG.ODU = new q.g()
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
          k.this.eND();
          AppMethodBeat.o(56202);
          return;
          if (k.this.type == 2) {
            com.tencent.mm.plugin.fav.a.h.y(k.this.activity.getIntent().getLongExtra("kFavInfoLocalId", -1L), 1);
          }
          paramAnonymousMenuItem = new Intent();
          paramAnonymousMenuItem.putExtra("Retr_Msg_content", com.tencent.mm.plugin.location.model.e.a(k.this.oUV));
          paramAnonymousMenuItem.putExtra("Retr_Msg_Type", 9);
          com.tencent.mm.by.c.f(k.this.activity, ".ui.transmit.MsgRetransmitUI", paramAnonymousMenuItem);
          AppMethodBeat.o(56202);
          return;
          k.this.fCU = 0;
          k.this.eNF();
          AppMethodBeat.o(56202);
          return;
          k.this.eNE();
          AppMethodBeat.o(56202);
          return;
          com.tencent.mm.ui.base.h.a(k.this.activity, k.this.activity.getString(a.i.app_delete_tips), "", new k.2.1(this), null);
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
          paramAnonymousMenuItem.putExtra("Retr_Msg_content", com.tencent.mm.plugin.location.model.e.a(k.this.oUV));
          paramAnonymousMenuItem.putExtra("Retr_Msg_Id", k.this.msgId);
          com.tencent.mm.by.c.f(k.this.activity, ".ui.chatting.ChattingSendDataToDeviceUI", paramAnonymousMenuItem);
          AppMethodBeat.o(56202);
          return;
          try
          {
            l = k.this.activity.getIntent().getLongExtra("kFavInfoLocalId", -1L);
            paramAnonymousMenuItem = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().Km(l);
            com.tencent.mm.plugin.report.service.h.IzE.a(15378, new Object[] { Integer.valueOf(paramAnonymousMenuItem.field_id), Integer.valueOf(paramAnonymousMenuItem.field_type) });
            Log.d("MicroMsg.ViewMapUI", "report 15378, id:%s, type:%s", new Object[] { Integer.valueOf(paramAnonymousMenuItem.field_id), Integer.valueOf(paramAnonymousMenuItem.field_type) });
            k.M(paramAnonymousMenuItem);
            aoe localaoe = new aoe();
            k.j(k.this.activity, paramAnonymousMenuItem, localaoe);
            k.this.activity.finish();
            AppMethodBeat.o(56202);
            return;
          }
          catch (Throwable paramAnonymousMenuItem)
          {
            Toast.makeText(k.this.activity, a.i.favorite_save_as_note_failed_1, 0).show();
            AppMethodBeat.o(56202);
            return;
          }
          k.a(k.this);
        }
      }
    };
    AppMethodBeat.o(56210);
  }
  
  private Intent eNC()
  {
    AppMethodBeat.i(56211);
    Intent localIntent = new Intent();
    localIntent.putExtra("kfavorite", true);
    localIntent.putExtra("kopenGmapNums", this.oUX.Elu);
    localIntent.putExtra("kopenOthersNums", this.oUX.Elv);
    localIntent.putExtra("kopenreportType", this.oUX.fSe);
    localIntent.putExtra("kRemark", eMZ());
    localIntent.putExtra("kwebmap_slat", this.oUV.Ejn);
    localIntent.putExtra("kwebmap_lng", this.oUV.Ejo);
    localIntent.putExtra("Kwebmap_locaion", this.oUV.Ejq);
    localIntent.putExtra("kPoiName", this.poiName);
    AppMethodBeat.o(56211);
    return localIntent;
  }
  
  protected final String bwJ()
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
      if ((Math.abs(paramMotionEvent.getX() - this.aCa) > 10.0F) || (Math.abs(paramMotionEvent.getY() - this.aCb) > 10.0F))
      {
        this.oZf = true;
        eNt();
        continue;
        this.aCa = paramMotionEvent.getX();
        this.aCb = paramMotionEvent.getY();
        this.Eoe = System.currentTimeMillis();
        this.oZf = false;
        eNw();
        continue;
        if (!this.oZf) {
          System.currentTimeMillis();
        }
      }
    }
  }
  
  protected final void eND()
  {
    AppMethodBeat.i(56213);
    if (this.Esk)
    {
      aa.a(new j());
      Intent localIntent = new Intent();
      localIntent.putExtra("show_bottom", false);
      localIntent.putExtra("jsapi_args_appid", "wx751a1acca5688ba3");
      localIntent.putExtra("rawUrl", this.Esi);
      localIntent.putExtra("title", a.i.scan_entry_street);
      localIntent.putExtra("webview_bg_color_rsID", a.b.black);
      com.tencent.mm.by.c.b(this.activity, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent);
    }
    AppMethodBeat.o(56213);
  }
  
  protected final void eNE()
  {
    AppMethodBeat.i(56218);
    Log.d("MicroMsg.ViewMapUI", "directlyFavorite lat %s, long %s, scale", new Object[] { Double.valueOf(this.oUV.Ejn), Double.valueOf(this.oUV.Ejo) });
    Intent localIntent = eNC();
    this.activity.setResult(-1, localIntent);
    this.activity.getIntent().getIntExtra("MMActivity.OverrideEnterAnimation", -1);
    this.activity.getIntent().getIntExtra("MMActivity.OverrideExitAnimation", -1);
    this.activity.finish();
    AppMethodBeat.o(56218);
  }
  
  protected final void eNF()
  {
    AppMethodBeat.i(56219);
    Log.d("MicroMsg.ViewMapUI", "locationLine, locationInfo.slat=%f, locationInfo.slong=%f, myLocation.slat=%f, myLocation.slong=%f", new Object[] { Double.valueOf(this.oUV.Ejn), Double.valueOf(this.oUV.Ejo), Double.valueOf(this.oUW.Ejn), Double.valueOf(this.oUW.Ejo) });
    if (this.oUW.eLZ())
    {
      eNx();
      AppMethodBeat.o(56219);
      return;
    }
    com.tencent.mm.plugin.report.service.h.IzE.a(12809, new Object[] { Integer.valueOf(3), "" });
    this.EoS = true;
    if (this.handler == null)
    {
      AppMethodBeat.o(56219);
      return;
    }
    if (this.Esl != null) {
      this.handler.removeCallbacks(this.Esl);
    }
    this.Esl = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(56206);
        if (k.this.EoS)
        {
          if (k.this.iXX != null) {
            k.this.iXX.dismiss();
          }
          k.this.eNx();
        }
        k.this.EoS = false;
        AppMethodBeat.o(56206);
      }
    };
    this.handler.postDelayed(this.Esl, 10000L);
    Activity localActivity = this.activity;
    getString(a.i.app_tip);
    this.iXX = com.tencent.mm.ui.base.h.a(localActivity, getString(a.i.get_location), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        k.this.EoS = false;
      }
    });
    AppMethodBeat.o(56219);
  }
  
  protected void eNa()
  {
    AppMethodBeat.i(56217);
    Intent localIntent = new Intent();
    localIntent.putExtra("kopenGmapNums", this.oUX.Elu);
    localIntent.putExtra("kopenOthersNums", this.oUX.Elv);
    localIntent.putExtra("kopenreportType", this.oUX.fSe);
    localIntent.putExtra("kRemark", eMZ());
    localIntent.putExtra("soso_street_view_url", this.Esi);
    this.activity.setResult(-1, localIntent);
    AppMethodBeat.o(56217);
  }
  
  void eNb()
  {
    AppMethodBeat.i(56212);
    this.EoO.Epd.setEnabled(true);
    this.EoO.EoZ.setVisibility(8);
    c(this.oUV);
    this.EoO.ElK.getIController().setZoom(this.Ejp);
    this.EoO.Epb.setEnabled(true);
    this.fNQ = this.activity.getIntent().getBooleanExtra("kShowshare", true);
    label150:
    Object localObject1;
    Object localObject2;
    if (this.fNQ)
    {
      this.EoO.Epb.setVisibility(0);
      this.Esi = this.activity.getIntent().getStringExtra("soso_street_view_url");
      if ((Util.isNullOrNil(this.Esi)) || ((!LocaleUtil.isTraditionalChineseAppLang()) && (!LocaleUtil.isSimplifiedChineseAppLang()))) {
        break label601;
      }
      this.Esk = true;
      this.EoO.Epb.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(56203);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/location/ui/impl/ViewMapUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          k.b(k.this);
          k.c(k.this).eik();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/location/ui/impl/ViewMapUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(56203);
        }
      });
      this.Esj = new l(this.EoO.ElK, this.activity);
      localObject1 = this.Esj;
      if (((l)localObject1).mViewManager != null)
      {
        ((l)localObject1).mViewManager.addView(((l)localObject1).EoF, 0.0D, 0.0D);
        ((l)localObject1).mViewManager.setMarkerTag(((l)localObject1).EoF, "info_window_tag");
        if (((l)localObject1).EoI)
        {
          ((l)localObject1).mViewManager.setInfoWindowAdapter(new l.a((l)localObject1, (byte)0));
          ((l)localObject1).mViewManager.showInfoWindowByView(((l)localObject1).EoF);
        }
      }
      localObject1 = this.Esj;
      localObject2 = this.oUV;
      ((l)localObject1).Ejn = ((LocationInfo)localObject2).Ejn;
      ((l)localObject1).Ejo = ((LocationInfo)localObject2).Ejo;
      if (!com.tencent.mm.plugin.location.model.e.i(this.oUV.Ejn, this.oUV.Ejo))
      {
        Log.d("MicroMsg.ViewMapUI", "isValidLatLng %f %f", new Object[] { Double.valueOf(this.oUV.Ejn), Double.valueOf(this.oUV.Ejo) });
        localObject1 = this.Esj;
        ((l)localObject1).ElI = false;
        ((l)localObject1).EoG.setVisibility(8);
      }
      if (2 == this.type)
      {
        Log.i("MicroMsg.ViewMapUI", "location id %s", new Object[] { this.oUV.Ejm });
        if (this.activity.getIntent().getBooleanExtra("kFavCanRemark", true)) {
          eMY();
        }
        if (!Util.isNullOrNil(this.oUV.Ejq)) {
          this.EoO.Epa.setVisibility(0);
        }
      }
      this.EoQ.put(this.oUV.Ejm, this.Esj);
      if (!this.oUV.eMa()) {
        break label700;
      }
      if ((this.poiName != null) && (!this.poiName.equals(""))) {
        this.Esj.poiName = this.poiName;
      }
      this.Esj.setText(this.Esj.getPreText() + this.oUV.Ejq);
    }
    for (;;)
    {
      for (;;)
      {
        localObject1 = this.Esj;
        localObject2 = new TencentMap.OnInfoWindowClickListener()
        {
          public final void onInfoWindowClick(Marker paramAnonymousMarker)
          {
            AppMethodBeat.i(56204);
            k.this.fCU = 0;
            k.this.eNu();
            k.this.eNF();
            AppMethodBeat.o(56204);
          }
        };
        if ((((l)localObject1).EoI) && (((l)localObject1).mViewManager != null)) {
          ((l)localObject1).mViewManager.setInfoWindowClick(((l)localObject1).EoF, (TencentMap.OnInfoWindowClickListener)localObject2);
        }
        AppMethodBeat.o(56212);
        return;
        this.EoO.Epb.setVisibility(8);
        break;
        label601:
        if ((!LocaleUtil.isTraditionalChineseAppLang()) && (!LocaleUtil.isSimplifiedChineseAppLang())) {
          break label150;
        }
        this.Esk = false;
        try
        {
          localObject1 = (eat)d.b.b(new x((float)this.oUV.Ejo, (float)this.oUV.Ejn, this.msgId).rr.lBR);
          new x((eat)localObject1);
          com.tencent.mm.kernel.h.aGY().a(new x((eat)localObject1), 0);
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.ViewMapUI", localException.toString());
        }
      }
      break label150;
      label700:
      if (com.tencent.mm.plugin.location.model.e.i(this.oUV.Ejn, this.oUV.Ejo)) {
        this.EoR.a(this.oUV.Ejn, this.oUV.Ejo, this.EoX, this.oUV.Ejm);
      }
    }
  }
  
  public boolean eNc()
  {
    AppMethodBeat.i(56209);
    if ((this.uaG != null) && (this.uaG.isShowing())) {
      this.uaG.bYF();
    }
    for (;;)
    {
      AppMethodBeat.o(56209);
      return true;
      bXG();
      this.uaG.eik();
    }
  }
  
  public void eNt() {}
  
  protected void eNu() {}
  
  public void eNw() {}
  
  protected void eNx() {}
  
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
      Object localObject1 = this.oUX;
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
            com.tencent.mm.plugin.report.service.h.IzE.a(11091, new Object[] { Integer.valueOf(6), Integer.valueOf(2) });
            paramIntent = paramIntent.getBundleExtra("transferback").getParcelableArrayList("locations");
            localObject2 = (LocationInfo)paramIntent.get(0);
            localObject3 = (LocationInfo)paramIntent.get(1);
            if (!Util.isNullOrNil(((LocationInfo)localObject2).Ejr)) {
              break label483;
            }
          }
          for (paramIntent = "zh-cn";; paramIntent = ((LocationInfo)localObject2).Ejr)
          {
            paramIntent = new Intent("android.intent.action.VIEW", Uri.parse(String.format("http://maps.google.com/maps?f=d&saddr=%f,%f&daddr=%f,%f&hl=".concat(String.valueOf(paramIntent)), new Object[] { Double.valueOf(((LocationInfo)localObject3).Ejn), Double.valueOf(((LocationInfo)localObject3).Ejo), Double.valueOf(((LocationInfo)localObject2).Ejn), Double.valueOf(((LocationInfo)localObject2).Ejo) })));
            localObject2 = new Bundle();
            ((Bundle)localObject2).putParcelable("targetintent", paramIntent);
            localObject3 = new Intent();
            ((Intent)localObject3).setClass(((com.tencent.mm.plugin.location.ui.d)localObject1).context, AppChooserUI.class);
            ((Intent)localObject3).putExtra("type", 1);
            ((Intent)localObject3).putExtra("title", ((com.tencent.mm.plugin.location.ui.d)localObject1).context.getResources().getString(a.i.location_info_send_tip));
            ((Intent)localObject3).putExtra("targetintent", paramIntent);
            ((Intent)localObject3).putExtra("transferback", (Bundle)localObject2);
            ((Intent)localObject3).putExtra("scene", 6);
            ((Activity)((com.tencent.mm.plugin.location.ui.d)localObject1).context).startActivityForResult((Intent)localObject3, 4099);
            AppMethodBeat.o(56220);
            return;
            com.tencent.mm.plugin.report.service.h.IzE.a(11091, new Object[] { Integer.valueOf(6), Integer.valueOf(1) });
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
          paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(paramIntent);
          com.tencent.mm.hellhoundlib.a.a.b(localObject1, paramIntent.aFh(), "com/tencent/mm/plugin/location/ui/MapHelper", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Context)localObject1).startActivity((Intent)paramIntent.sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/location/ui/MapHelper", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
    this.Ejp = this.activity.getIntent().getIntExtra("kwebmap_scale", 15);
    if (this.Ejp <= 0) {
      this.Ejp = 15;
    }
    this.poiName = this.activity.getIntent().getStringExtra("kPoiName");
    paramBundle = this.activity.getIntent().getStringExtra("Kwebmap_locaion");
    Log.d("MicroMsg.ViewMapUI", "view " + d1 + " " + d2);
    LocationInfo localLocationInfo = this.oUV;
    localLocationInfo.Ejn = d1;
    localLocationInfo.Ejo = d2;
    localLocationInfo.Ejq = paramBundle;
    localLocationInfo.Ejp = this.Ejp;
    localLocationInfo.fPN = this.poiName;
    this.msgId = this.activity.getIntent().getLongExtra("kMsgId", -1L);
    this.uJM = this.activity.getIntent().getStringExtra("map_talker_name");
    initView();
    AppMethodBeat.o(56216);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(56221);
    this.jGJ.release();
    this.handler.removeCallbacks(this.Esl);
    this.handler = null;
    com.tencent.mm.kernel.h.aGY().b(424, this);
    super.onDestroy();
    AppMethodBeat.o(56221);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(56215);
    Log.d("MicroMsg.ViewMapUI", "onbaseGeoResume");
    if (this.EoW != null) {
      this.EoW.b(this.Esm);
    }
    super.onPause();
    AppMethodBeat.o(56215);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(56214);
    super.onResume();
    Log.d("MicroMsg.ViewMapUI", "onbaseGeoResume");
    if (this.EoW != null) {
      this.EoW.b(this.Esm, true);
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
        paramString = x.Xc(((x)paramq).boR().Tlx);
        Log.d("MicroMsg.ViewMapUI", "getUrl success! url is %s", new Object[] { paramString });
        this.Esi = paramString;
        if (!Util.isNullOrNil(paramString)) {
          this.Esk = true;
        }
        if ((this.type == 9) && (!Util.isNullOrNil(paramString)))
        {
          paramString = (TextView)findViewById(a.e.street_tv);
          paramString.setVisibility(0);
          paramString.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(56207);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bn(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/location/ui/impl/ViewMapUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
              k.this.eND();
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/location/ui/impl/ViewMapUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(56207);
            }
          });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.k
 * JD-Core Version:    0.7.0.1
 */