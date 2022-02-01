package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.ht;
import com.tencent.mm.autogen.a.ht.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location.ui.NewMyLocationButton;
import com.tencent.mm.plugin.location.ui.e;
import com.tencent.mm.plugin.location.ui.j.a;
import com.tencent.mm.plugin.map.a.b;
import com.tencent.mm.plugin.map.a.d;
import com.tencent.mm.plugin.map.a.e;
import com.tencent.mm.plugin.map.a.i;
import com.tencent.mm.plugin.p.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class j
  extends k
{
  private static final String Kkq;
  private com.tencent.mm.plugin.location.ui.k KjU;
  private com.tencent.mm.plugin.location.ui.j KjW;
  private NewMyLocationButton Kkj;
  private e Kkk;
  private View Kkl;
  private com.tencent.mm.ui.widget.a.f Kkm;
  private int Kkn;
  private com.tencent.mm.plugin.location.model.j Kko;
  private View Kkp;
  private HashMap<String, Integer> Kkr;
  private Map<String, String> sah;
  
  static
  {
    AppMethodBeat.i(264978);
    Kkq = "https://" + WeChatHosts.domainString(a.i.host_3gimg_qq_com) + "/tencentMapTouch/app/download/apkForWXAndroidConf.json";
    AppMethodBeat.o(264978);
  }
  
  public j(Activity paramActivity)
  {
    super(paramActivity);
    AppMethodBeat.i(56168);
    this.Kkr = new HashMap();
    h.aZW().a(1913, this);
    this.Kko = new com.tencent.mm.plugin.location.model.j();
    h.aZW().a(this.Kko, 0);
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
  
  public final void fVM()
  {
    AppMethodBeat.i(56172);
    super.fVM();
    AppMethodBeat.o(56172);
  }
  
  public final void fVP()
  {
    AppMethodBeat.i(56173);
    super.fVP();
    Log.i("MicroMsg.TrackMapUI", "onDown");
    AppMethodBeat.o(56173);
  }
  
  protected final void fVQ()
  {
    AppMethodBeat.i(56174);
    l locall = l.fVZ();
    ArrayList localArrayList = new ArrayList(8);
    localArrayList.addAll(locall.Kcn);
    this.Kkm = new com.tencent.mm.ui.widget.a.f(this.activity, 1, false);
    this.Kkm.Vtg = new j.10(this, localArrayList);
    this.Kkm.GAC = new j.2(this);
    this.Kkm.dDn();
    AppMethodBeat.o(56174);
  }
  
  final void fVu()
  {
    AppMethodBeat.i(56170);
    super.fVu();
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
    this.Kkl = ((ViewStub)localObject1).inflate();
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
    this.KjU = new com.tencent.mm.plugin.location.ui.k(this.activity, this.Khu.Ket, false);
    this.KjU.KgH = false;
    this.KjU.KgI = false;
    localObject1 = this.KjU;
    ((com.tencent.mm.plugin.location.ui.k)localObject1).KgF = true;
    if (((com.tencent.mm.plugin.location.ui.k)localObject1).Kgz != null)
    {
      ((com.tencent.mm.plugin.location.ui.k)localObject1).Kgz.setOnAvatarOnClickListener(null);
      ((com.tencent.mm.plugin.location.ui.k)localObject1).Kgz.setOnLocationOnClickListener(null);
      ((com.tencent.mm.plugin.location.ui.k)localObject1).Kgz.fVS();
    }
    this.KjU.KgD = false;
    this.KjW = new com.tencent.mm.plugin.location.ui.j(this.activity, new j.a()
    {
      public final void ZD(int paramAnonymousInt) {}
      
      public final void fVk() {}
      
      public final void fVl() {}
    });
    findViewById(a.e.start_share).setVisibility(8);
    this.Khu.nfU.setOnClickListener(new j.6(this));
    this.Kkj = ((NewMyLocationButton)this.Kkl.findViewById(a.e.new_locate_to_my_position));
    localObject1 = this.KjU;
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
    if (((com.tencent.mm.plugin.location.ui.k)localObject1).Kei != null) {
      ((com.tencent.mm.plugin.location.ui.k)localObject1).Kei.setMapViewOnTouchListener((View.OnTouchListener)localObject2);
    }
    this.Kkj.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(56153);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/location/ui/impl/TrackMapUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        j.c(j.this).a(j.this.Khu.Ket);
        j.b(j.this).setSelected(true);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/location/ui/impl/TrackMapUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(56153);
      }
    });
    localObject1 = this.activity.getIntent().getStringExtra("kPoi_url");
    int i;
    if (Util.isNullOrNil((String)localObject1))
    {
      this.Khu.zNW.setVisibility(8);
      localObject1 = this.KkP;
      if (!com.tencent.mm.ce.b.iRp()) {
        break label554;
      }
      i = a.d.location_current_marker_easy_mode;
      label354:
      ((com.tencent.mm.plugin.location.ui.l)localObject1).Khl.setImageResource(i);
      this.Kkk = new e(this.Khu.Ket, this.activity);
      if (this.sai.fUt())
      {
        if ((this.poiName != null) && (!this.poiName.equals(""))) {
          this.Kkk.poiName = this.poiName;
        }
        if (!TextUtils.isEmpty(this.sai.KbZ)) {
          break label561;
        }
      }
    }
    label554:
    label561:
    for (localObject1 = "";; localObject1 = this.sai.KbZ)
    {
      this.Kkk.setText(this.KkP.getPreText() + (String)localObject1);
      localObject1 = new j.4(this);
      localObject2 = this.Kkk;
      ((e)localObject2).Kew.setOnClickListener((View.OnClickListener)localObject1);
      ((e)localObject2).Kew.setVisibility(0);
      this.Kkp = findViewById(a.e.download_info_loading);
      AppMethodBeat.o(56170);
      return;
      this.Khu.zNW.setVisibility(0);
      this.Khu.zNW.setOnClickListener(new j.9(this, (String)localObject1));
      break;
      i = a.d.location_current_marker;
      break label354;
    }
  }
  
  public final void onBusinessPermissionDenied(String paramString)
  {
    AppMethodBeat.i(264982);
    this.activity.finish();
    AppMethodBeat.o(264982);
  }
  
  public final void onBusinessPermissionGranted(String paramString)
  {
    AppMethodBeat.i(264981);
    this.activity.recreate();
    AppMethodBeat.o(264981);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(56169);
    super.onCreate(paramBundle);
    this.Kkn = ((Integer)h.baE().ban().get(at.a.acRz, Integer.valueOf(0))).intValue();
    Log.i("MicroMsg.TrackMapUI", "count: %s", new Object[] { Integer.valueOf(this.Kkn) });
    this.sai.Kcd = this.activity.getIntent().getStringExtra("kPoiid");
    setActionbarColor(MMApplicationContext.getResources().getColor(a.b.normal_actionbar_color));
    AppMethodBeat.o(56169);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(56175);
    super.onDestroy();
    if (this.KjU != null) {
      this.KjU.destroy();
    }
    if (this.Kko != null) {
      h.aZW().a(this.Kko);
    }
    h.aZW().b(1913, this);
    AppMethodBeat.o(56175);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(56177);
    super.onPause();
    if (this.KjU != null) {
      this.KjU.onPause();
    }
    AppMethodBeat.o(56177);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(56176);
    super.onResume();
    if (this.KjU != null) {
      this.KjU.onResume();
    }
    ht localht;
    if (this.type == 2)
    {
      localht = new ht();
      localht.hIR.hDn = this.activity.getIntent().getLongExtra("kFavInfoLocalId", -1L);
      localht.hIR.type = 4;
      localht.publish();
      if (localht.hIS.dcC != null)
      {
        if (this.Khz != null) {
          break label130;
        }
        this.Khz = new ArrayList();
      }
    }
    for (;;)
    {
      this.Khz.addAll(localht.hIS.dcC);
      fVq();
      AppMethodBeat.o(56176);
      return;
      label130:
      this.Khz.clear();
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(56178);
    Log.i("MicroMsg.TrackMapUI", "onSceneEnd, errType: %s, errCode: %s, errMsg: %s.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      AppMethodBeat.o(56178);
      return;
    }
    if (1913 == paramp.getType())
    {
      Object localObject = (com.tencent.mm.plugin.location.model.j)paramp;
      paramString = l.fVZ();
      paramp = new ArrayList(8);
      paramp.addAll(((com.tencent.mm.plugin.location.model.j)localObject).Kcn);
      localObject = new ArrayList(8);
      ((List)localObject).addAll(paramp);
      paramString.Kcn = ((List)localObject);
    }
    AppMethodBeat.o(56178);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.j
 * JD-Core Version:    0.7.0.1
 */