package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewStub;
import android.view.ViewStub.OnInflateListener;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.hi;
import com.tencent.mm.f.a.hi.b;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location.ui.NewMyLocationButton;
import com.tencent.mm.plugin.location.ui.j.a;
import com.tencent.mm.plugin.map.a.b;
import com.tencent.mm.plugin.map.a.d;
import com.tencent.mm.plugin.map.a.e;
import com.tencent.mm.plugin.map.a.i;
import com.tencent.mm.plugin.q.d;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class j
  extends k
{
  private static final String ErK;
  private NewMyLocationButton ErD;
  private com.tencent.mm.plugin.location.ui.e ErE;
  private View ErF;
  private com.tencent.mm.ui.widget.a.e ErG;
  private int ErH;
  private com.tencent.mm.plugin.location.model.j ErI;
  private View ErJ;
  private HashMap<String, Integer> ErL;
  private com.tencent.mm.plugin.location.ui.k Ero;
  private com.tencent.mm.plugin.location.ui.j Erq;
  private Map<String, String> oUU;
  
  static
  {
    AppMethodBeat.i(244865);
    ErK = "https://" + WeChatHosts.domainString(a.i.host_3gimg_qq_com) + "/tencentMapTouch/app/download/apkForWXAndroidConf.json";
    AppMethodBeat.o(244865);
  }
  
  public j(Activity paramActivity)
  {
    super(paramActivity);
    AppMethodBeat.i(56168);
    this.ErL = new HashMap();
    h.aGY().a(1913, this);
    this.ErI = new com.tencent.mm.plugin.location.model.j();
    h.aGY().a(this.ErI, 0);
    AppMethodBeat.o(56168);
  }
  
  public final boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(56171);
    if (paramKeyEvent.getKeyCode() == 4) {
      paramKeyEvent.getAction();
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(56171);
    return bool;
  }
  
  final void eNb()
  {
    AppMethodBeat.i(56170);
    super.eNb();
    ((TextView)findViewById(a.e.mm_action_bar_mmtitle)).setText(a.i.location_info);
    findViewById(a.e.title_search_icon).setVisibility(8);
    Object localObject1 = (ViewStub)findViewById(a.e.location_info_stub);
    ((ViewStub)localObject1).setOnInflateListener(new ViewStub.OnInflateListener()
    {
      public final void onInflate(ViewStub paramAnonymousViewStub, View paramAnonymousView)
      {
        AppMethodBeat.i(56147);
        paramAnonymousView.findViewById(a.e.location_info_frame).setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymous2View, MotionEvent paramAnonymous2MotionEvent)
          {
            return true;
          }
        });
        AppMethodBeat.o(56147);
      }
    });
    this.ErF = ((ViewStub)localObject1).inflate();
    findViewById(a.e.locate_to_my_position).setVisibility(8);
    this.activity.getWindow().getDecorView().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(56149);
        FrameLayout localFrameLayout = (FrameLayout)j.this.findViewById(a.e.mapview_content);
        RelativeLayout localRelativeLayout = (RelativeLayout)j.a(j.this).findViewById(a.e.location_info_frame);
        if (localFrameLayout == null)
        {
          Log.w("MicroMsg.TrackMapUI", "mapcontent is null!");
          AppMethodBeat.o(56149);
          return;
        }
        RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)localFrameLayout.getLayoutParams();
        RelativeLayout.LayoutParams localLayoutParams1 = localLayoutParams2;
        if (localLayoutParams2 == null) {
          localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -1);
        }
        localLayoutParams1.height = (localFrameLayout.getHeight() - localRelativeLayout.getHeight());
        localFrameLayout.setLayoutParams(localLayoutParams1);
        AppMethodBeat.o(56149);
      }
    });
    this.Ero = new com.tencent.mm.plugin.location.ui.k(this.activity, this.EoO.ElK, false);
    this.Ero.Eob = false;
    this.Ero.Eoc = false;
    localObject1 = this.Ero;
    ((com.tencent.mm.plugin.location.ui.k)localObject1).EnZ = true;
    if (((com.tencent.mm.plugin.location.ui.k)localObject1).EnS != null)
    {
      ((com.tencent.mm.plugin.location.ui.k)localObject1).EnS.setOnAvatarOnClickListener(null);
      ((com.tencent.mm.plugin.location.ui.k)localObject1).EnS.setOnLocationOnClickListener(null);
      ((com.tencent.mm.plugin.location.ui.k)localObject1).EnS.eNz();
    }
    this.Ero.EnW = false;
    this.Erq = new com.tencent.mm.plugin.location.ui.j(this.activity, new j.a()
    {
      public final void VH(int paramAnonymousInt) {}
      
      public final void eMR() {}
      
      public final void eMS() {}
    });
    findViewById(a.e.start_share).setVisibility(8);
    this.EoO.kCv.setOnClickListener(new j.6(this));
    this.ErD = ((NewMyLocationButton)this.ErF.findViewById(a.e.new_locate_to_my_position));
    localObject1 = this.Ero;
    Object localObject2 = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(56152);
        j.b(j.this).setSelected(false);
        AppMethodBeat.o(56152);
        return false;
      }
    };
    if (((com.tencent.mm.plugin.location.ui.k)localObject1).Elz != null) {
      ((com.tencent.mm.plugin.location.ui.k)localObject1).Elz.setMapViewOnTouchListener((View.OnTouchListener)localObject2);
    }
    this.ErD.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(56153);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/location/ui/impl/TrackMapUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        j.c(j.this).a(j.this.EoO.ElK);
        j.b(j.this).setSelected(true);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/location/ui/impl/TrackMapUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(56153);
      }
    });
    localObject1 = this.activity.getIntent().getStringExtra("kPoi_url");
    if (Util.isNullOrNil((String)localObject1)) {
      this.EoO.wrQ.setVisibility(8);
    }
    for (;;)
    {
      localObject1 = this.Esj;
      int i = a.d.location_current_marker;
      ((com.tencent.mm.plugin.location.ui.l)localObject1).EoF.setImageResource(i);
      this.ErE = new com.tencent.mm.plugin.location.ui.e(this.EoO.ElK, this.activity);
      if (this.oUV.eMa())
      {
        if ((this.poiName != null) && (!this.poiName.equals(""))) {
          this.ErE.poiName = this.poiName;
        }
        this.ErE.setText(this.Esj.getPreText() + this.oUV.Ejq);
      }
      localObject1 = new j.4(this);
      localObject2 = this.ErE;
      ((com.tencent.mm.plugin.location.ui.e)localObject2).ElN.setOnClickListener((View.OnClickListener)localObject1);
      ((com.tencent.mm.plugin.location.ui.e)localObject2).ElN.setVisibility(0);
      this.ErJ = findViewById(a.e.download_info_loading);
      AppMethodBeat.o(56170);
      return;
      this.EoO.wrQ.setVisibility(0);
      this.EoO.wrQ.setOnClickListener(new j.9(this, (String)localObject1));
    }
  }
  
  public final void eNt()
  {
    AppMethodBeat.i(56172);
    super.eNt();
    AppMethodBeat.o(56172);
  }
  
  public final void eNw()
  {
    AppMethodBeat.i(56173);
    super.eNw();
    Log.i("MicroMsg.TrackMapUI", "onDown");
    AppMethodBeat.o(56173);
  }
  
  protected final void eNx()
  {
    AppMethodBeat.i(56174);
    l locall = l.eNG();
    ArrayList localArrayList = new ArrayList(8);
    localArrayList.addAll(locall.EjE);
    this.ErG = new com.tencent.mm.ui.widget.a.e(this.activity, 1, false);
    this.ErG.ODT = new j.10(this, localArrayList);
    this.ErG.ODU = new j.2(this);
    this.ErG.eik();
    AppMethodBeat.o(56174);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(56169);
    super.onCreate(paramBundle);
    this.ErH = ((Integer)h.aHG().aHp().get(ar.a.VpX, Integer.valueOf(0))).intValue();
    Log.i("MicroMsg.TrackMapUI", "count: %s", new Object[] { Integer.valueOf(this.ErH) });
    this.oUV.Eju = this.activity.getIntent().getStringExtra("kPoiid");
    setActionbarColor(MMApplicationContext.getResources().getColor(a.b.normal_actionbar_color));
    AppMethodBeat.o(56169);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(56175);
    super.onDestroy();
    if (this.Ero != null) {
      this.Ero.destroy();
    }
    if (this.ErI != null) {
      h.aGY().a(this.ErI);
    }
    h.aGY().b(1913, this);
    AppMethodBeat.o(56175);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(56177);
    super.onPause();
    if (this.Ero != null) {
      this.Ero.onPause();
    }
    AppMethodBeat.o(56177);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(56176);
    super.onResume();
    if (this.Ero != null) {
      this.Ero.onResume();
    }
    hi localhi;
    if (this.type == 2)
    {
      localhi = new hi();
      localhi.fEb.fyE = this.activity.getIntent().getLongExtra("kFavInfoLocalId", -1L);
      localhi.fEb.type = 4;
      EventCenter.instance.publish(localhi);
      if (localhi.fEc.biI != null)
      {
        if (this.EoT != null) {
          break label133;
        }
        this.EoT = new ArrayList();
      }
    }
    for (;;)
    {
      this.EoT.addAll(localhi.fEc.biI);
      eMX();
      AppMethodBeat.o(56176);
      return;
      label133:
      this.EoT.clear();
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(56178);
    Log.i("MicroMsg.TrackMapUI", "onSceneEnd, errType: %s, errCode: %s, errMsg: %s.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      AppMethodBeat.o(56178);
      return;
    }
    if (1913 == paramq.getType())
    {
      Object localObject = (com.tencent.mm.plugin.location.model.j)paramq;
      paramString = l.eNG();
      paramq = new ArrayList(8);
      paramq.addAll(((com.tencent.mm.plugin.location.model.j)localObject).EjE);
      localObject = new ArrayList(8);
      ((List)localObject).addAll(paramq);
      paramString.EjE = ((List)localObject);
    }
    AppMethodBeat.o(56178);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.j
 * JD-Core Version:    0.7.0.1
 */