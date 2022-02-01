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
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.hb;
import com.tencent.mm.g.a.hb.b;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.k.d;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location.ui.NewMyLocationButton;
import com.tencent.mm.plugin.location.ui.j.a;
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
  private static final String yNM;
  private Map<String, String> lXj;
  private NewMyLocationButton yNF;
  private com.tencent.mm.plugin.location.ui.e yNG;
  private View yNH;
  private com.tencent.mm.ui.widget.a.e yNI;
  private int yNJ;
  private com.tencent.mm.plugin.location.model.j yNK;
  private View yNL;
  private HashMap<String, Integer> yNN;
  private com.tencent.mm.plugin.location.ui.k yNq;
  private com.tencent.mm.plugin.location.ui.j yNs;
  
  static
  {
    AppMethodBeat.i(201733);
    yNM = "https://" + WeChatHosts.domainString(2131761701) + "/tencentMapTouch/app/download/apkForWXAndroidConf.json";
    AppMethodBeat.o(201733);
  }
  
  public j(Activity paramActivity)
  {
    super(paramActivity);
    AppMethodBeat.i(56168);
    this.yNN = new HashMap();
    g.azz().a(1913, this);
    this.yNK = new com.tencent.mm.plugin.location.model.j();
    g.azz().a(this.yNK, 0);
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
  
  final void edG()
  {
    AppMethodBeat.i(56170);
    super.edG();
    ((TextView)findViewById(2131304687)).setText(2131762457);
    findViewById(2131309242).setVisibility(8);
    Object localObject1 = (ViewStub)findViewById(2131303735);
    ((ViewStub)localObject1).setOnInflateListener(new ViewStub.OnInflateListener()
    {
      public final void onInflate(ViewStub paramAnonymousViewStub, View paramAnonymousView)
      {
        AppMethodBeat.i(56147);
        paramAnonymousView.findViewById(2131303733).setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymous2View, MotionEvent paramAnonymous2MotionEvent)
          {
            return true;
          }
        });
        AppMethodBeat.o(56147);
      }
    });
    this.yNH = ((ViewStub)localObject1).inflate();
    findViewById(2131303726).setVisibility(8);
    this.activity.getWindow().getDecorView().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(56149);
        FrameLayout localFrameLayout = (FrameLayout)j.this.findViewById(2131304494);
        RelativeLayout localRelativeLayout = (RelativeLayout)j.a(j.this).findViewById(2131303733);
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
    this.yNq = new com.tencent.mm.plugin.location.ui.k(this.activity, this.yKV.yHR, false);
    this.yNq.yKi = false;
    this.yNq.yKj = false;
    localObject1 = this.yNq;
    ((com.tencent.mm.plugin.location.ui.k)localObject1).yKg = true;
    if (((com.tencent.mm.plugin.location.ui.k)localObject1).yJZ != null)
    {
      ((com.tencent.mm.plugin.location.ui.k)localObject1).yJZ.setOnAvatarOnClickListener(null);
      ((com.tencent.mm.plugin.location.ui.k)localObject1).yJZ.setOnLocationOnClickListener(null);
      ((com.tencent.mm.plugin.location.ui.k)localObject1).yJZ.eee();
    }
    this.yNq.yKd = false;
    this.yNs = new com.tencent.mm.plugin.location.ui.j(this.activity, new j.a()
    {
      public final void Py(int paramAnonymousInt) {}
      
      public final void edx() {}
      
      public final void edy() {}
    });
    findViewById(2131308373).setVisibility(8);
    this.yKV.hNZ.setOnClickListener(new j.6(this));
    this.yNF = ((NewMyLocationButton)this.yNH.findViewById(2131305358));
    localObject1 = this.yNq;
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
    if (((com.tencent.mm.plugin.location.ui.k)localObject1).yHG != null) {
      ((com.tencent.mm.plugin.location.ui.k)localObject1).yHG.setMapViewOnTouchListener((View.OnTouchListener)localObject2);
    }
    this.yNF.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(56153);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/location/ui/impl/TrackMapUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        j.c(j.this).a(j.this.yKV.yHR);
        j.b(j.this).setSelected(true);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/location/ui/impl/TrackMapUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(56153);
      }
    });
    localObject1 = this.activity.getIntent().getStringExtra("kPoi_url");
    if (Util.isNullOrNil((String)localObject1)) {
      this.yKV.sLV.setVisibility(8);
    }
    for (;;)
    {
      this.yOl.yKM.setImageResource(2131233529);
      this.yNG = new com.tencent.mm.plugin.location.ui.e(this.yKV.yHR, this.activity);
      if (this.lXk.ecI())
      {
        if ((this.kHV != null) && (!this.kHV.equals(""))) {
          this.yNG.kHV = this.kHV;
        }
        this.yNG.setText(this.yOl.getPreText() + this.lXk.yFx);
      }
      localObject1 = new j.4(this);
      localObject2 = this.yNG;
      ((com.tencent.mm.plugin.location.ui.e)localObject2).yHU.setOnClickListener((View.OnClickListener)localObject1);
      ((com.tencent.mm.plugin.location.ui.e)localObject2).yHU.setVisibility(0);
      this.yNL = findViewById(2131299766);
      AppMethodBeat.o(56170);
      return;
      this.yKV.sLV.setVisibility(0);
      this.yKV.sLV.setOnClickListener(new j.9(this, (String)localObject1));
    }
  }
  
  public final void edY()
  {
    AppMethodBeat.i(56172);
    super.edY();
    AppMethodBeat.o(56172);
  }
  
  public final void eeb()
  {
    AppMethodBeat.i(56173);
    super.eeb();
    Log.i("MicroMsg.TrackMapUI", "onDown");
    AppMethodBeat.o(56173);
  }
  
  protected final void eec()
  {
    AppMethodBeat.i(56174);
    l locall = l.eem();
    ArrayList localArrayList = new ArrayList(8);
    localArrayList.addAll(locall.yFL);
    this.yNI = new com.tencent.mm.ui.widget.a.e(this.activity, 1, false);
    this.yNI.HLX = new j.10(this, localArrayList);
    this.yNI.HLY = new j.2(this);
    this.yNI.dGm();
    AppMethodBeat.o(56174);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(56169);
    super.onCreate(paramBundle);
    this.yNJ = ((Integer)g.aAh().azQ().get(ar.a.ObU, Integer.valueOf(0))).intValue();
    Log.i("MicroMsg.TrackMapUI", "count: %s", new Object[] { Integer.valueOf(this.yNJ) });
    this.lXk.yFB = this.activity.getIntent().getStringExtra("kPoiid");
    setActionbarColor(MMApplicationContext.getResources().getColor(2131100898));
    AppMethodBeat.o(56169);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(56175);
    super.onDestroy();
    if (this.yNq != null) {
      this.yNq.destroy();
    }
    if (this.yNK != null) {
      g.azz().a(this.yNK);
    }
    g.azz().b(1913, this);
    AppMethodBeat.o(56175);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(56177);
    super.onPause();
    if (this.yNq != null) {
      this.yNq.onPause();
    }
    AppMethodBeat.o(56177);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(56176);
    super.onResume();
    if (this.yNq != null) {
      this.yNq.onResume();
    }
    hb localhb;
    if (this.type == 2)
    {
      localhb = new hb();
      localhb.dLm.dFW = this.activity.getIntent().getLongExtra("kFavInfoLocalId", -1L);
      localhb.dLm.type = 4;
      EventCenter.instance.publish(localhb);
      if (localhb.dLn.bzh != null)
      {
        if (this.yLa != null) {
          break label133;
        }
        this.yLa = new ArrayList();
      }
    }
    for (;;)
    {
      this.yLa.addAll(localhb.dLn.bzh);
      edC();
      AppMethodBeat.o(56176);
      return;
      label133:
      this.yLa.clear();
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
      paramString = l.eem();
      paramq = new ArrayList(8);
      paramq.addAll(((com.tencent.mm.plugin.location.model.j)localObject).yFL);
      localObject = new ArrayList(8);
      ((List)localObject).addAll(paramq);
      paramString.yFL = ((List)localObject);
    }
    AppMethodBeat.o(56178);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.j
 * JD-Core Version:    0.7.0.1
 */