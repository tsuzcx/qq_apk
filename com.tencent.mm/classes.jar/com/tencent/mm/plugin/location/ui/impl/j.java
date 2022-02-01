package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.ViewStub.OnInflateListener;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.aw.a.a.c;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.aw.o;
import com.tencent.mm.g.a.gs;
import com.tencent.mm.g.a.gs.b;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location.ui.NewMyLocationButton;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.pp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class j
  extends k
{
  com.tencent.mm.plugin.location.ui.k sWA;
  private com.tencent.mm.plugin.location.ui.j sWC;
  NewMyLocationButton sWP;
  private com.tencent.mm.plugin.location.ui.e sWQ;
  View sWR;
  com.tencent.mm.ui.widget.a.e sWS;
  Map<String, String> sWT;
  int sWU;
  private com.tencent.mm.plugin.location.model.j sWV;
  View sWW;
  HashMap<String, Integer> sWX;
  
  public j(Activity paramActivity)
  {
    super(paramActivity);
    AppMethodBeat.i(56168);
    this.sWX = new HashMap();
    com.tencent.mm.kernel.g.aeS().a(1913, this);
    this.sWV = new com.tencent.mm.plugin.location.model.j();
    com.tencent.mm.kernel.g.aeS().a(this.sWV, 0);
    AppMethodBeat.o(56168);
  }
  
  public final void cKA()
  {
    AppMethodBeat.i(56173);
    super.cKA();
    ad.i("MicroMsg.TrackMapUI", "onDown");
    AppMethodBeat.o(56173);
  }
  
  protected final void cKB()
  {
    AppMethodBeat.i(56174);
    l locall = l.cKK();
    final ArrayList localArrayList = new ArrayList(8);
    localArrayList.addAll(locall.sOM);
    this.sWS = new com.tencent.mm.ui.widget.a.e(this.activity, 1, false);
    this.sWS.HrX = new n.c()
    {
      public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
      {
        AppMethodBeat.i(56160);
        StringBuilder localStringBuilder = new StringBuilder();
        Object localObject2;
        int j;
        Object localObject3;
        if (!bt.gL(localArrayList))
        {
          localObject1 = LayoutInflater.from(j.this.activity).inflate(2131495746, new FrameLayout(j.this.activity), false);
          localObject2 = (LinearLayout)((View)localObject1).findViewById(2131306895);
          i = ao.fromDPToPix(j.this.activity, 24);
          j = ao.fromDPToPix(j.this.activity, 2);
          localObject3 = new c.a();
          ((c.a)localObject3).gkG = true;
          ((c.a)localObject3).gjv = i;
          ((c.a)localObject3).gjw = i;
          localObject3 = ((c.a)localObject3).azc();
          Object localObject4 = localArrayList.iterator();
          while (((Iterator)localObject4).hasNext())
          {
            pp localpp = (pp)((Iterator)localObject4).next();
            ImageView localImageView = new ImageView(j.this.activity);
            LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(i, i);
            localLayoutParams.leftMargin = j;
            localLayoutParams.rightMargin = j;
            ((LinearLayout)localObject2).addView(localImageView, localLayoutParams);
            o.ayJ().a(localpp.sYq, localImageView, (c)localObject3);
            localStringBuilder.append("weapp_id_").append(localpp.dlB).append("|");
          }
          if (1 == localArrayList.size())
          {
            localObject3 = new TextView(j.this.activity);
            ((TextView)localObject3).setTextColor(j.this.activity.getResources().getColor(2131100711));
            ((TextView)localObject3).setTextSize(17.0F);
            ((TextView)localObject3).setGravity(17);
            ((TextView)localObject3).setText(((pp)localArrayList.get(0)).nickname);
            localObject4 = new LinearLayout.LayoutParams(-2, -2);
            ((LinearLayout.LayoutParams)localObject4).leftMargin = (j * 3);
            ((LinearLayout)localObject2).addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
          }
          ((View)localObject1).setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(final View paramAnonymous2View)
            {
              AppMethodBeat.i(56159);
              if (1 == j.10.this.sXb.size())
              {
                ad.i("MicroMsg.TrackMapUI", "pennqin, only one taxi weapp.");
                Object localObject = (pp)j.10.this.sXb.get(0);
                ad.i("MicroMsg.TrackMapUI", "taxi weapp info: appid %s, page_url %s, username %s, version %s, version_type %s.", new Object[] { ((pp)localObject).dlB, ((pp)localObject).CNZ, ((pp)localObject).username, Integer.valueOf(((pp)localObject).version), Integer.valueOf(((pp)localObject).CLK) });
                h.vKh.f(12809, new Object[] { Integer.valueOf(4), "weapp_id_".concat(((pp)localObject).dlB) });
                if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.n.class) != null)
                {
                  paramAnonymous2View = (com.tencent.mm.plugin.appbrand.service.n)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.n.class);
                  com.tencent.mm.plugin.appbrand.a.f localf = new com.tencent.mm.plugin.appbrand.a.f();
                  localf.appId = ((pp)localObject).dlB;
                  localf.username = ((pp)localObject).username;
                  localf.gXn = ((pp)localObject).CLK;
                  localf.version = ((pp)localObject).version;
                  localf.iJb = ((pp)localObject).CNZ;
                  localf.scene = 1146;
                  localObject = new com.tencent.mm.plugin.appbrand.a.g();
                  ((com.tencent.mm.plugin.appbrand.a.g)localObject).dpb = ((float)j.this.sUa.sOv);
                  ((com.tencent.mm.plugin.appbrand.a.g)localObject).dqQ = ((float)j.this.sUa.sOw);
                  ((com.tencent.mm.plugin.appbrand.a.g)localObject).goQ = j.this.sUa.dtN;
                  ad.i("MicroMsg.TrackMapUI", "pennqin, extra data: %s.", new Object[] { ((com.tencent.mm.plugin.appbrand.a.g)localObject).aOj() });
                  localf.iJc = ((com.tencent.mm.plugin.appbrand.a.d)localObject);
                  paramAnonymous2View.a(j.this.activity, localf);
                  j.this.sWS.bfo();
                }
                AppMethodBeat.o(56159);
                return;
              }
              paramAnonymous2View = new com.tencent.mm.ui.widget.a.e(j.this.activity, 1, true);
              paramAnonymous2View.HFp = true;
              paramAnonymous2View.HFm = true;
              paramAnonymous2View.HrX = new n.c()
              {
                public final void onCreateMMMenu(final com.tencent.mm.ui.base.l paramAnonymous3l)
                {
                  AppMethodBeat.i(56157);
                  paramAnonymous2View.J(View.inflate(j.this.activity, 2131495747, null), false);
                  int i = 0;
                  Object localObject2;
                  if (i < j.10.this.sXb.size())
                  {
                    localObject2 = (pp)j.10.this.sXb.get(i);
                    localObject1 = u.a(new i(((pp)localObject2).sYq));
                    u.a(new u.a()
                    {
                      public final void l(final String paramAnonymous4String, final Bitmap paramAnonymous4Bitmap)
                      {
                        AppMethodBeat.i(56156);
                        aq.f(new Runnable()
                        {
                          public final void run()
                          {
                            AppMethodBeat.i(56155);
                            if ((j.this.sWX.containsKey(paramAnonymous4String)) && (paramAnonymous4Bitmap != null) && (!paramAnonymous4Bitmap.isRecycled()))
                            {
                              int i = ((Integer)j.this.sWX.remove(paramAnonymous4String)).intValue();
                              if (j.10.1.1.1.this.sXf.getItem(i) != null)
                              {
                                j.10.1.1.1.this.sXf.getItem(i).setIcon(new BitmapDrawable(com.tencent.mm.sdk.platformtools.f.a(com.tencent.mm.sdk.platformtools.f.a(paramAnonymous4Bitmap, false, paramAnonymous4Bitmap.getWidth() / 2.0F, false), j.this.activity.getResources().getDimensionPixelOffset(2131165929), j.this.activity.getResources().getDimensionPixelOffset(2131165929), true, false)));
                                j.10.1.1.this.sXd.ffw();
                              }
                            }
                            AppMethodBeat.o(56155);
                          }
                        });
                        AppMethodBeat.o(56156);
                      }
                    });
                    if (localObject1 == null) {
                      break label274;
                    }
                  }
                  label274:
                  for (Object localObject1 = new BitmapDrawable(com.tencent.mm.sdk.platformtools.f.a(com.tencent.mm.sdk.platformtools.f.a((Bitmap)localObject1, false, ((Bitmap)localObject1).getWidth() / 2.0F, false), j.this.activity.getResources().getDimensionPixelOffset(2131165929), j.this.activity.getResources().getDimensionPixelOffset(2131165929), true, false));; localObject1 = null)
                  {
                    if (localObject1 == null) {
                      j.this.sWX.put(((pp)localObject2).sYq, Integer.valueOf(i));
                    }
                    localObject2 = ((pp)localObject2).nickname;
                    m localm = new m(paramAnonymous3l.mContext, i, 0);
                    localm.setTitle((CharSequence)localObject2);
                    localm.setIcon((Drawable)localObject1);
                    localm.D((Drawable)localObject1);
                    paramAnonymous3l.FYt.add(localm);
                    i += 1;
                    break;
                    AppMethodBeat.o(56157);
                    return;
                  }
                }
              };
              paramAnonymous2View.HrY = new n.d()
              {
                public final void onMMMenuItemSelected(MenuItem paramAnonymous3MenuItem, int paramAnonymous3Int)
                {
                  AppMethodBeat.i(56158);
                  ad.i("MicroMsg.TrackMapUI", "taxi weapp, index: %s, itemId: %s.", new Object[] { Integer.valueOf(paramAnonymous3Int), Integer.valueOf(paramAnonymous3MenuItem.getItemId()) });
                  Object localObject = (pp)j.10.this.sXb.get(paramAnonymous3Int);
                  ad.i("MicroMsg.TrackMapUI", "taxi weapp info: appid %s, page_url %s, username %s, version %s, version_type %s.", new Object[] { ((pp)localObject).dlB, ((pp)localObject).CNZ, ((pp)localObject).username, Integer.valueOf(((pp)localObject).version), Integer.valueOf(((pp)localObject).CLK) });
                  h.vKh.f(12809, new Object[] { Integer.valueOf(4), "weapp_id_".concat(((pp)localObject).dlB) });
                  if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.n.class) != null)
                  {
                    paramAnonymous3MenuItem = (com.tencent.mm.plugin.appbrand.service.n)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.n.class);
                    com.tencent.mm.plugin.appbrand.a.f localf = new com.tencent.mm.plugin.appbrand.a.f();
                    localf.appId = ((pp)localObject).dlB;
                    localf.username = ((pp)localObject).username;
                    localf.gXn = ((pp)localObject).CLK;
                    localf.version = ((pp)localObject).version;
                    localf.iJb = ((pp)localObject).CNZ;
                    localf.scene = 1146;
                    localObject = new com.tencent.mm.plugin.appbrand.a.g();
                    ((com.tencent.mm.plugin.appbrand.a.g)localObject).dpb = ((float)j.this.sUa.sOv);
                    ((com.tencent.mm.plugin.appbrand.a.g)localObject).dqQ = ((float)j.this.sUa.sOw);
                    ((com.tencent.mm.plugin.appbrand.a.g)localObject).goQ = j.this.sUa.dtN;
                    ad.i("MicroMsg.TrackMapUI", "pennqin, extra data: %s.", new Object[] { ((com.tencent.mm.plugin.appbrand.a.g)localObject).aOj() });
                    localf.iJc = ((com.tencent.mm.plugin.appbrand.a.d)localObject);
                    paramAnonymous3MenuItem.a(j.this.activity, localf);
                  }
                  AppMethodBeat.o(56158);
                }
              };
              j.this.sWS.bfo();
              paramAnonymous2View.csG();
              AppMethodBeat.o(56159);
            }
          });
          j.this.sWS.setFooterView((View)localObject1);
        }
        Object localObject1 = new StringBuilder();
        j.this.sWT = j.this.sTZ.b(j.this.sUa);
        if (!com.tencent.mm.sdk.platformtools.i.eFb())
        {
          i = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.ppF, 99);
          if (j.this.sWU >= i) {}
        }
        for (int i = 1;; i = 0)
        {
          j = i;
          if (i == 0)
          {
            j = i;
            if (j.a(j.this)) {
              j = 1;
            }
          }
          if (j != 0)
          {
            ((StringBuilder)localObject1).append("com.tencent.map|");
            paramAnonymousl.aI(2, 2131764402, 0);
          }
          localObject2 = j.this.sWT.entrySet().iterator();
          i = 3;
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (Map.Entry)((Iterator)localObject2).next();
            if (!((String)((Map.Entry)localObject3).getKey()).equals("com.tencent.map"))
            {
              ((StringBuilder)localObject1).append((String)((Map.Entry)localObject3).getKey()).append("|");
              paramAnonymousl.a(i, (CharSequence)((Map.Entry)localObject3).getValue(), 0);
            }
            i += 1;
          }
          h.vKh.f(12809, new Object[] { Integer.valueOf(3), ((StringBuilder)localObject1).toString(), localStringBuilder.toString() });
          AppMethodBeat.o(56160);
          return;
        }
      }
    };
    this.sWS.HrY = new n.d()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(56148);
        Iterator localIterator;
        switch (paramAnonymousMenuItem.getItemId())
        {
        default: 
          if (j.this.sWT != null) {
            localIterator = j.this.sWT.entrySet().iterator();
          }
          break;
        case 2: 
          while (localIterator.hasNext())
          {
            Map.Entry localEntry = (Map.Entry)localIterator.next();
            if (((String)localEntry.getValue()).equals(paramAnonymousMenuItem.getTitle()))
            {
              j.this.sTZ.a(j.this.sUa, j.this.sUb, (String)localEntry.getKey(), false);
              h.vKh.f(12809, new Object[] { Integer.valueOf(4), localEntry.getKey() });
              AppMethodBeat.o(56148);
              return;
              ad.i("MicroMsg.TrackMapUI", "click tencent map: %s", new Object[] { Boolean.valueOf(j.this.sWT.containsKey("com.tencent.map")) });
              if (j.a(j.this))
              {
                j.this.sTZ.a(j.this.sUa, j.this.sUb, "com.tencent.map", false);
                h.vKh.f(12809, new Object[] { Integer.valueOf(4), "com.tencent.map" });
                AppMethodBeat.o(56148);
                return;
              }
              paramAnonymousInt = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.ppF, 99);
              if (j.this.sWU < paramAnonymousInt)
              {
                paramAnonymousMenuItem = j.this;
                paramAnonymousMenuItem.sWU += 1;
                com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fpb, Integer.valueOf(j.this.sWU));
              }
              if (1 == ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.piX, 0)) {}
              for (paramAnonymousInt = 1; paramAnonymousInt != 0; paramAnonymousInt = 0)
              {
                new j.a(j.this.activity, j.this.sWW).execute(new String[] { "https://3gimg.qq.com/tencentMapTouch/app/download/apkForWXAndroidConf.json" });
                AppMethodBeat.o(56148);
                return;
              }
              paramAnonymousMenuItem = new Intent();
              paramAnonymousMenuItem.putExtra("rawUrl", "http://mapdownload.map.qq.com/?key=wx&referer=wx1&channel=00008");
              com.tencent.mm.bs.d.b(j.this.activity, "webview", ".ui.tools.WebViewUI", paramAnonymousMenuItem);
              h.vKh.f(12809, new Object[] { Integer.valueOf(5) });
              AppMethodBeat.o(56148);
              return;
            }
          }
        }
        AppMethodBeat.o(56148);
      }
    };
    this.sWS.csG();
    AppMethodBeat.o(56174);
  }
  
  final void cKf()
  {
    AppMethodBeat.i(56170);
    super.cKf();
    ((TextView)findViewById(2131302293)).setText(2131760717);
    findViewById(2131305943).setVisibility(8);
    Object localObject1 = (ViewStub)findViewById(2131301529);
    ((ViewStub)localObject1).setOnInflateListener(new ViewStub.OnInflateListener()
    {
      public final void onInflate(ViewStub paramAnonymousViewStub, View paramAnonymousView)
      {
        AppMethodBeat.i(56147);
        paramAnonymousView.findViewById(2131301527).setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymous2View, MotionEvent paramAnonymous2MotionEvent)
          {
            return true;
          }
        });
        AppMethodBeat.o(56147);
      }
    });
    this.sWR = ((ViewStub)localObject1).inflate();
    findViewById(2131301520).setVisibility(8);
    this.activity.getWindow().getDecorView().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(56149);
        FrameLayout localFrameLayout = (FrameLayout)j.this.findViewById(2131302155);
        RelativeLayout localRelativeLayout = (RelativeLayout)j.this.sWR.findViewById(2131301527);
        if (localFrameLayout == null)
        {
          ad.w("MicroMsg.TrackMapUI", "mapcontent is null!");
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
    this.sWA = new com.tencent.mm.plugin.location.ui.k(this.activity, this.sUc.sQT, false);
    this.sWA.sTm = false;
    this.sWA.sTn = false;
    localObject1 = this.sWA;
    ((com.tencent.mm.plugin.location.ui.k)localObject1).sTk = true;
    if (((com.tencent.mm.plugin.location.ui.k)localObject1).sTd != null)
    {
      ((com.tencent.mm.plugin.location.ui.k)localObject1).sTd.setOnAvatarOnClickListener(null);
      ((com.tencent.mm.plugin.location.ui.k)localObject1).sTd.setOnLocationOnClickListener(null);
      ((com.tencent.mm.plugin.location.ui.k)localObject1).sTd.cKC();
    }
    this.sWA.sTh = false;
    this.sWC = new com.tencent.mm.plugin.location.ui.j(this.activity, new com.tencent.mm.plugin.location.ui.j.a()
    {
      public final void FG(int paramAnonymousInt) {}
      
      public final void cJW() {}
      
      public final void cJX() {}
    });
    findViewById(2131305183).setVisibility(8);
    this.sUc.oPR.setOnClickListener(new j.6(this));
    this.sWP = ((NewMyLocationButton)this.sWR.findViewById(2131302789));
    localObject1 = this.sWA;
    Object localObject2 = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(56152);
        j.this.sWP.setSelected(false);
        AppMethodBeat.o(56152);
        return false;
      }
    };
    if (((com.tencent.mm.plugin.location.ui.k)localObject1).sQI != null) {
      ((com.tencent.mm.plugin.location.ui.k)localObject1).sQI.setMapViewOnTouchListener((View.OnTouchListener)localObject2);
    }
    this.sWP.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(56153);
        j.this.sWA.a(j.this.sUc.sQT);
        j.this.sWP.setSelected(true);
        AppMethodBeat.o(56153);
      }
    });
    localObject1 = this.activity.getIntent().getStringExtra("kPoi_url");
    if (bt.isNullOrNil((String)localObject1)) {
      this.sUc.sLG.setVisibility(8);
    }
    for (;;)
    {
      this.sXu.sTQ.setImageResource(2131232887);
      this.sWQ = new com.tencent.mm.plugin.location.ui.e(this.sUc.sQT, this.activity);
      if (this.sUa.cJh())
      {
        if ((this.goQ != null) && (!this.goQ.equals(""))) {
          this.sWQ.goQ = this.goQ;
        }
        this.sWQ.setText(this.sXu.getPreText() + this.sUa.sOy);
      }
      localObject1 = new j.4(this);
      localObject2 = this.sWQ;
      ((com.tencent.mm.plugin.location.ui.e)localObject2).sQW.setOnClickListener((View.OnClickListener)localObject1);
      ((com.tencent.mm.plugin.location.ui.e)localObject2).sQW.setVisibility(0);
      this.sWW = findViewById(2131299209);
      AppMethodBeat.o(56170);
      return;
      this.sUc.sLG.setVisibility(0);
      this.sUc.sLG.setOnClickListener(new j.9(this, (String)localObject1));
    }
  }
  
  public final void cKx()
  {
    AppMethodBeat.i(56172);
    super.cKx();
    AppMethodBeat.o(56172);
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
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(56169);
    super.onCreate(paramBundle);
    this.sWU = ((Integer)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fpb, Integer.valueOf(0))).intValue();
    ad.i("MicroMsg.TrackMapUI", "count: %s", new Object[] { Integer.valueOf(this.sWU) });
    this.sUa.sOC = this.activity.getIntent().getStringExtra("kPoiid");
    setActionbarColor(aj.getResources().getColor(2131100705));
    AppMethodBeat.o(56169);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(56175);
    super.onDestroy();
    if (this.sWA != null) {
      this.sWA.destroy();
    }
    if (this.sWV != null) {
      com.tencent.mm.kernel.g.aeS().a(this.sWV);
    }
    com.tencent.mm.kernel.g.aeS().b(1913, this);
    AppMethodBeat.o(56175);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(56177);
    super.onPause();
    if (this.sWA != null) {
      this.sWA.onPause();
    }
    AppMethodBeat.o(56177);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(56176);
    super.onResume();
    if (this.sWA != null) {
      this.sWA.onResume();
    }
    gs localgs;
    if (this.type == 2)
    {
      localgs = new gs();
      localgs.dkc.deL = this.activity.getIntent().getLongExtra("kFavInfoLocalId", -1L);
      localgs.dkc.type = 4;
      com.tencent.mm.sdk.b.a.ESL.l(localgs);
      if (localgs.dkd.bqk != null)
      {
        if (this.sUh != null) {
          break label133;
        }
        this.sUh = new ArrayList();
      }
    }
    for (;;)
    {
      this.sUh.addAll(localgs.dkd.bqk);
      cKb();
      AppMethodBeat.o(56176);
      return;
      label133:
      this.sUh.clear();
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(56178);
    ad.i("MicroMsg.TrackMapUI", "onSceneEnd, errType: %s, errCode: %s, errMsg: %s.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      AppMethodBeat.o(56178);
      return;
    }
    if (1913 == paramn.getType())
    {
      Object localObject = (com.tencent.mm.plugin.location.model.j)paramn;
      paramString = l.cKK();
      paramn = new ArrayList(8);
      paramn.addAll(((com.tencent.mm.plugin.location.model.j)localObject).sOM);
      localObject = new ArrayList(8);
      ((List)localObject).addAll(paramn);
      paramString.sOM = ((List)localObject);
    }
    AppMethodBeat.o(56178);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.j
 * JD-Core Version:    0.7.0.1
 */