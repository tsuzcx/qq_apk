package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.h.a.gf;
import com.tencent.mm.h.a.gf.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location.ui.NewMyLocationButton;
import com.tencent.mm.plugin.location.ui.f;
import com.tencent.mm.plugin.location.ui.l;
import com.tencent.mm.plugin.location.ui.l.a;
import com.tencent.mm.plugin.location.ui.m;
import com.tencent.mm.plugin.location.ui.n;
import com.tencent.mm.plugin.map.a.b;
import com.tencent.mm.plugin.map.a.d;
import com.tencent.mm.plugin.map.a.e;
import com.tencent.mm.plugin.map.a.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.a.d;
import java.util.ArrayList;
import java.util.Map;

public final class h
  extends i
{
  m lJV;
  private l lJX;
  private NewMyLocationButton lKj;
  private f lKk;
  View lKl;
  private d lKm;
  Map<String, String> lKn;
  int lKo;
  
  public h(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  final void beK()
  {
    super.beK();
    ((TextView)findViewById(a.e.mm_action_bar_mmtitle)).setText(a.h.location_info);
    findViewById(a.e.title_search_icon).setVisibility(8);
    Object localObject = (ViewStub)findViewById(a.e.location_info_stub);
    ((ViewStub)localObject).setOnInflateListener(new h.1(this));
    this.lKl = ((ViewStub)localObject).inflate();
    findViewById(a.e.locate_to_my_position).setVisibility(8);
    this.activity.getWindow().getDecorView().post(new h.2(this));
    this.lJV = new m(this.activity, this.lIb.lFm, false);
    this.lJV.lHm = false;
    this.lJV.lHn = false;
    localObject = this.lJV;
    ((m)localObject).lHk = true;
    if (((m)localObject).lHd != null)
    {
      ((m)localObject).lHd.setOnAvatarOnClickListener(null);
      ((m)localObject).lHd.setOnLocationOnClickListener(null);
      ((m)localObject).lHd.bfa();
    }
    this.lJV.lHh = false;
    this.lJX = new l(this.activity, new l.a()
    {
      public final void beC() {}
      
      public final void beD() {}
      
      public final void sZ(int paramAnonymousInt) {}
    });
    findViewById(a.e.start_share).setVisibility(8);
    this.lIb.kjC.setOnClickListener(new h.5(this));
    this.lKj = ((NewMyLocationButton)this.lKl.findViewById(a.e.new_locate_to_my_position));
    this.lKj.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        h.this.lJV.a(h.this.lIb.lFm);
      }
    });
    localObject = this.activity.getIntent().getStringExtra("kPoi_url");
    if (bk.bl((String)localObject)) {
      this.lIb.lAx.setVisibility(8);
    }
    for (;;)
    {
      localObject = this.lKA;
      int i = a.d.location_artboard1;
      ((n)localObject).lHP.setImageResource(i);
      this.lKk = new f(this.lIb.lFm, this.activity);
      if (this.lHZ.bdO())
      {
        if ((this.lFn != null) && (!this.lFn.equals(""))) {
          this.lKk.lFn = this.lFn;
        }
        this.lKk.setText(this.lKA.getPreText() + this.lHZ.lCM);
      }
      localObject = new h.3(this);
      f localf = this.lKk;
      localf.lFq.setOnClickListener((View.OnClickListener)localObject);
      localf.lFq.setVisibility(0);
      return;
      this.lIb.lAx.setVisibility(0);
      this.lIb.lAx.setOnClickListener(new h.7(this, (String)localObject));
    }
  }
  
  public final void beW()
  {
    super.beW();
  }
  
  public final void beY()
  {
    super.beY();
    y.i("MicroMsg.TrackMapUI", "onDown");
  }
  
  protected final void beZ()
  {
    this.lKm = new d(this.activity, 1, false);
    this.lKm.phH = new h.8(this);
    this.lKm.phI = new h.9(this);
    this.lKm.cfU();
  }
  
  public final boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getKeyCode() == 4) {
      paramKeyEvent.getAction();
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.lKo = ((Integer)g.DP().Dz().get(ac.a.uwk, Integer.valueOf(0))).intValue();
    y.i("MicroMsg.TrackMapUI", "count: %s", new Object[] { Integer.valueOf(this.lKo) });
    this.lHZ.lCQ = this.activity.getIntent().getStringExtra("kPoiid");
    ta(ae.getResources().getColor(a.b.normal_actionbar_color));
  }
  
  public final void onDestroy()
  {
    super.onDestroy();
    if (this.lJV != null) {
      this.lJV.destroy();
    }
  }
  
  public final void onPause()
  {
    super.onPause();
    if (this.lJV != null) {
      this.lJV.onPause();
    }
  }
  
  public final void onResume()
  {
    super.onResume();
    if (this.lJV != null) {
      this.lJV.onResume();
    }
    gf localgf;
    if (this.type == 2)
    {
      localgf = new gf();
      localgf.bNF.bIr = this.activity.getIntent().getLongExtra("kFavInfoLocalId", -1L);
      localgf.bNF.type = 4;
      com.tencent.mm.sdk.b.a.udP.m(localgf);
      if (localgf.bNG.aLn != null)
      {
        if (this.lIg != null) {
          break label121;
        }
        this.lIg = new ArrayList();
      }
    }
    for (;;)
    {
      this.lIg.addAll(localgf.bNG.aLn);
      beG();
      return;
      label121:
      this.lIg.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.h
 * JD-Core Version:    0.7.0.1
 */