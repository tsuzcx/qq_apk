package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
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
import com.tencent.mm.g.a.gi;
import com.tencent.mm.g.a.gi.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location.ui.NewMyLocationButton;
import com.tencent.mm.plugin.location.ui.f;
import com.tencent.mm.plugin.location.ui.l;
import com.tencent.mm.plugin.location.ui.l.a;
import com.tencent.mm.plugin.location.ui.m;
import com.tencent.mm.plugin.location.ui.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.b.d;
import java.util.ArrayList;
import java.util.Map;

public final class h
  extends i
{
  private d ohA;
  Map<String, String> ohB;
  int ohC;
  View ohD;
  m ohj;
  private l ohl;
  private NewMyLocationButton ohx;
  private f ohy;
  View ohz;
  
  public h(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  final void bMe()
  {
    AppMethodBeat.i(113711);
    super.bMe();
    ((TextView)findViewById(2131826119)).setText(2131301093);
    findViewById(2131826121).setVisibility(8);
    Object localObject = (ViewStub)findViewById(2131824804);
    ((ViewStub)localObject).setOnInflateListener(new ViewStub.OnInflateListener()
    {
      public final void onInflate(ViewStub paramAnonymousViewStub, View paramAnonymousView)
      {
        AppMethodBeat.i(113695);
        paramAnonymousView.findViewById(2131826543).setOnTouchListener(new h.1.1(this));
        AppMethodBeat.o(113695);
      }
    });
    this.ohz = ((ViewStub)localObject).inflate();
    findViewById(2131824806).setVisibility(8);
    this.activity.getWindow().getDecorView().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(113696);
        FrameLayout localFrameLayout = (FrameLayout)h.this.findViewById(2131824802);
        RelativeLayout localRelativeLayout = (RelativeLayout)h.this.ohz.findViewById(2131826543);
        if (localFrameLayout == null)
        {
          ab.w("MicroMsg.TrackMapUI", "mapcontent is null!");
          AppMethodBeat.o(113696);
          return;
        }
        RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)localFrameLayout.getLayoutParams();
        RelativeLayout.LayoutParams localLayoutParams1 = localLayoutParams2;
        if (localLayoutParams2 == null) {
          localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -1);
        }
        localLayoutParams1.height = (localFrameLayout.getHeight() - localRelativeLayout.getHeight());
        localFrameLayout.setLayoutParams(localLayoutParams1);
        AppMethodBeat.o(113696);
      }
    });
    this.ohj = new m(this.activity, this.ofo.ocA, false);
    this.ohj.oez = false;
    this.ohj.oeA = false;
    localObject = this.ohj;
    ((m)localObject).oex = true;
    if (((m)localObject).oeq != null)
    {
      ((m)localObject).oeq.setOnAvatarOnClickListener(null);
      ((m)localObject).oeq.setOnLocationOnClickListener(null);
      ((m)localObject).oeq.bMw();
    }
    this.ohj.oeu = false;
    this.ohl = new l(this.activity, new l.a()
    {
      public final void bLV() {}
      
      public final void bLW() {}
      
      public final void yc(int paramAnonymousInt) {}
    });
    findViewById(2131824809).setVisibility(8);
    this.ofo.lzc.setOnClickListener(new h.5(this));
    this.ohx = ((NewMyLocationButton)this.ohz.findViewById(2131826542));
    this.ohx.setOnClickListener(new h.6(this));
    localObject = this.activity.getIntent().getStringExtra("kPoi_url");
    if (bo.isNullOrNil((String)localObject)) {
      this.ofo.nXJ.setVisibility(8);
    }
    for (;;)
    {
      this.ohS.ofb.setImageResource(2130839292);
      this.ohy = new f(this.ofo.ocA, this.activity);
      if (this.ofm.bLi())
      {
        if ((this.eSM != null) && (!this.eSM.equals(""))) {
          this.ohy.eSM = this.eSM;
        }
        this.ohy.setText(this.ohS.getPreText() + this.ofm.nZY);
      }
      localObject = new h.3(this);
      f localf = this.ohy;
      localf.ocD.setOnClickListener((View.OnClickListener)localObject);
      localf.ocD.setVisibility(0);
      this.ohD = findViewById(2131824813);
      AppMethodBeat.o(113711);
      return;
      this.ofo.nXJ.setVisibility(0);
      this.ofo.nXJ.setOnClickListener(new h.7(this, (String)localObject));
    }
  }
  
  public final void bMs()
  {
    AppMethodBeat.i(113713);
    super.bMs();
    AppMethodBeat.o(113713);
  }
  
  public final void bMu()
  {
    AppMethodBeat.i(113714);
    super.bMu();
    ab.i("MicroMsg.TrackMapUI", "onDown");
    AppMethodBeat.o(113714);
  }
  
  protected final void bMv()
  {
    AppMethodBeat.i(113715);
    this.ohA = new d(this.activity, 1, false);
    this.ohA.sao = new h.8(this);
    this.ohA.sap = new h.9(this);
    this.ohA.crd();
    AppMethodBeat.o(113715);
  }
  
  public final boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(113712);
    if (paramKeyEvent.getKeyCode() == 4) {
      paramKeyEvent.getAction();
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(113712);
    return bool;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(113710);
    super.onCreate(paramBundle);
    this.ohC = ((Integer)g.RL().Ru().get(ac.a.yGs, Integer.valueOf(0))).intValue();
    ab.i("MicroMsg.TrackMapUI", "count: %s", new Object[] { Integer.valueOf(this.ohC) });
    this.ofm.oac = this.activity.getIntent().getStringExtra("kPoiid");
    setActionbarColor(ah.getResources().getColor(2131690316));
    AppMethodBeat.o(113710);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(113716);
    super.onDestroy();
    if (this.ohj != null) {
      this.ohj.destroy();
    }
    AppMethodBeat.o(113716);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(113718);
    super.onPause();
    if (this.ohj != null) {
      this.ohj.onPause();
    }
    AppMethodBeat.o(113718);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(113717);
    super.onResume();
    if (this.ohj != null) {
      this.ohj.onResume();
    }
    gi localgi;
    if (this.type == 2)
    {
      localgi = new gi();
      localgi.cuX.cpM = this.activity.getIntent().getLongExtra("kFavInfoLocalId", -1L);
      localgi.cuX.type = 4;
      com.tencent.mm.sdk.b.a.ymk.l(localgi);
      if (localgi.cuY.aSH != null)
      {
        if (this.oft != null) {
          break label133;
        }
        this.oft = new ArrayList();
      }
    }
    for (;;)
    {
      this.oft.addAll(localgi.cuY.aSH);
      bMa();
      AppMethodBeat.o(113717);
      return;
      label133:
      this.oft.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.h
 * JD-Core Version:    0.7.0.1
 */