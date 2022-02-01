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
import com.tencent.mm.ak.q;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.o;
import com.tencent.mm.g.a.gt;
import com.tencent.mm.g.a.gt.b;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location.ui.NewMyLocationButton;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.pw;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.e.m;
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
  com.tencent.mm.plugin.location.ui.k ueN;
  private com.tencent.mm.plugin.location.ui.j ueP;
  NewMyLocationButton ufc;
  private com.tencent.mm.plugin.location.ui.e ufd;
  View ufe;
  com.tencent.mm.ui.widget.a.e uff;
  Map<String, String> ufg;
  int ufh;
  private com.tencent.mm.plugin.location.model.j ufi;
  View ufj;
  HashMap<String, Integer> ufk;
  
  public j(Activity paramActivity)
  {
    super(paramActivity);
    AppMethodBeat.i(56168);
    this.ufk = new HashMap();
    com.tencent.mm.kernel.g.agi().a(1913, this);
    this.ufi = new com.tencent.mm.plugin.location.model.j();
    com.tencent.mm.kernel.g.agi().a(this.ufi, 0);
    AppMethodBeat.o(56168);
  }
  
  final void cXK()
  {
    AppMethodBeat.i(56170);
    super.cXK();
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
    this.ufe = ((ViewStub)localObject1).inflate();
    findViewById(2131301520).setVisibility(8);
    this.activity.getWindow().getDecorView().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(56149);
        FrameLayout localFrameLayout = (FrameLayout)j.this.findViewById(2131302155);
        RelativeLayout localRelativeLayout = (RelativeLayout)j.this.ufe.findViewById(2131301527);
        if (localFrameLayout == null)
        {
          ac.w("MicroMsg.TrackMapUI", "mapcontent is null!");
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
    this.ueN = new com.tencent.mm.plugin.location.ui.k(this.activity, this.uco.tZg, false);
    this.ueN.uby = false;
    this.ueN.ubz = false;
    localObject1 = this.ueN;
    ((com.tencent.mm.plugin.location.ui.k)localObject1).ubw = true;
    if (((com.tencent.mm.plugin.location.ui.k)localObject1).ubp != null)
    {
      ((com.tencent.mm.plugin.location.ui.k)localObject1).ubp.setOnAvatarOnClickListener(null);
      ((com.tencent.mm.plugin.location.ui.k)localObject1).ubp.setOnLocationOnClickListener(null);
      ((com.tencent.mm.plugin.location.ui.k)localObject1).ubp.cYh();
    }
    this.ueN.ubt = false;
    this.ueP = new com.tencent.mm.plugin.location.ui.j(this.activity, new com.tencent.mm.plugin.location.ui.j.a()
    {
      public final void HB(int paramAnonymousInt) {}
      
      public final void cXB() {}
      
      public final void cXC() {}
    });
    findViewById(2131305183).setVisibility(8);
    this.uco.gyM.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(56151);
        j.this.cXJ();
        j.this.hideVKB();
        j.this.activity.finish();
        AppMethodBeat.o(56151);
      }
    });
    this.ufc = ((NewMyLocationButton)this.ufe.findViewById(2131302789));
    localObject1 = this.ueN;
    Object localObject2 = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(56152);
        j.this.ufc.setSelected(false);
        AppMethodBeat.o(56152);
        return false;
      }
    };
    if (((com.tencent.mm.plugin.location.ui.k)localObject1).tYV != null) {
      ((com.tencent.mm.plugin.location.ui.k)localObject1).tYV.setMapViewOnTouchListener((View.OnTouchListener)localObject2);
    }
    this.ufc.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(56153);
        j.this.ueN.a(j.this.uco.tZg);
        j.this.ufc.setSelected(true);
        AppMethodBeat.o(56153);
      }
    });
    localObject1 = this.activity.getIntent().getStringExtra("kPoi_url");
    if (bs.isNullOrNil((String)localObject1)) {
      this.uco.tTl.setVisibility(8);
    }
    for (;;)
    {
      this.ufH.ucc.setImageResource(2131232887);
      this.ufd = new com.tencent.mm.plugin.location.ui.e(this.uco.tZg, this.activity);
      if (this.ucm.cWM())
      {
        if ((this.gPy != null) && (!this.gPy.equals(""))) {
          this.ufd.gPy = this.gPy;
        }
        this.ufd.setText(this.ufH.getPreText() + this.ucm.tWL);
      }
      localObject1 = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(56150);
          ac.d("MicroMsg.TrackMapUI", "newpoi old go back onclick");
          j.this.dgt = 0;
          j.this.cYd();
          j.this.cYo();
          AppMethodBeat.o(56150);
        }
      };
      localObject2 = this.ufd;
      ((com.tencent.mm.plugin.location.ui.e)localObject2).tZj.setOnClickListener((View.OnClickListener)localObject1);
      ((com.tencent.mm.plugin.location.ui.e)localObject2).tZj.setVisibility(0);
      this.ufj = findViewById(2131299209);
      AppMethodBeat.o(56170);
      return;
      this.uco.tTl.setVisibility(0);
      this.uco.tTl.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(56154);
          paramAnonymousView = new Intent();
          paramAnonymousView.setClass(j.this.activity, e.m.class);
          ac.d("MicroMsg.TrackMapUI", "click url %s", new Object[] { this.ufn });
          paramAnonymousView.putExtra("rawUrl", this.ufn);
          paramAnonymousView.putExtra("showShare", false);
          com.tencent.mm.br.d.e(j.this.activity, "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramAnonymousView);
          AppMethodBeat.o(56154);
        }
      });
    }
  }
  
  public final void cYc()
  {
    AppMethodBeat.i(56172);
    super.cYc();
    AppMethodBeat.o(56172);
  }
  
  public final void cYf()
  {
    AppMethodBeat.i(56173);
    super.cYf();
    ac.i("MicroMsg.TrackMapUI", "onDown");
    AppMethodBeat.o(56173);
  }
  
  protected final void cYg()
  {
    AppMethodBeat.i(56174);
    l locall = l.cYp();
    final ArrayList localArrayList = new ArrayList(8);
    localArrayList.addAll(locall.tWZ);
    this.uff = new com.tencent.mm.ui.widget.a.e(this.activity, 1, false);
    this.uff.ISu = new n.c()
    {
      public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
      {
        AppMethodBeat.i(56160);
        StringBuilder localStringBuilder = new StringBuilder();
        Object localObject2;
        int j;
        Object localObject3;
        if (!bs.gY(localArrayList))
        {
          localObject1 = LayoutInflater.from(j.this.activity).inflate(2131495746, new FrameLayout(j.this.activity), false);
          localObject2 = (LinearLayout)((View)localObject1).findViewById(2131306895);
          i = ao.fromDPToPix(j.this.activity, 24);
          j = ao.fromDPToPix(j.this.activity, 2);
          localObject3 = new c.a();
          ((c.a)localObject3).gLt = true;
          ((c.a)localObject3).gKg = i;
          ((c.a)localObject3).gKh = i;
          localObject3 = ((c.a)localObject3).aFT();
          Object localObject4 = localArrayList.iterator();
          while (((Iterator)localObject4).hasNext())
          {
            pw localpw = (pw)((Iterator)localObject4).next();
            ImageView localImageView = new ImageView(j.this.activity);
            LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(i, i);
            localLayoutParams.leftMargin = j;
            localLayoutParams.rightMargin = j;
            ((LinearLayout)localObject2).addView(localImageView, localLayoutParams);
            o.aFB().a(localpw.ugE, localImageView, (c)localObject3);
            localStringBuilder.append("weapp_id_").append(localpw.djj).append("|");
          }
          if (1 == localArrayList.size())
          {
            localObject3 = new TextView(j.this.activity);
            ((TextView)localObject3).setTextColor(j.this.activity.getResources().getColor(2131100711));
            ((TextView)localObject3).setTextSize(17.0F);
            ((TextView)localObject3).setGravity(17);
            ((TextView)localObject3).setText(((pw)localArrayList.get(0)).nickname);
            localObject4 = new LinearLayout.LayoutParams(-2, -2);
            ((LinearLayout.LayoutParams)localObject4).leftMargin = (j * 3);
            ((LinearLayout)localObject2).addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
          }
          ((View)localObject1).setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(final View paramAnonymous2View)
            {
              AppMethodBeat.i(56159);
              if (1 == j.10.this.ufo.size())
              {
                ac.i("MicroMsg.TrackMapUI", "pennqin, only one taxi weapp.");
                Object localObject = (pw)j.10.this.ufo.get(0);
                ac.i("MicroMsg.TrackMapUI", "taxi weapp info: appid %s, page_url %s, username %s, version %s, version_type %s.", new Object[] { ((pw)localObject).djj, ((pw)localObject).EgB, ((pw)localObject).username, Integer.valueOf(((pw)localObject).version), Integer.valueOf(((pw)localObject).Een) });
                h.wUl.f(12809, new Object[] { Integer.valueOf(4), "weapp_id_".concat(((pw)localObject).djj) });
                if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.n.class) != null)
                {
                  paramAnonymous2View = (com.tencent.mm.plugin.appbrand.service.n)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.n.class);
                  com.tencent.mm.plugin.appbrand.a.f localf = new com.tencent.mm.plugin.appbrand.a.f();
                  localf.appId = ((pw)localObject).djj;
                  localf.username = ((pw)localObject).username;
                  localf.hxM = ((pw)localObject).Een;
                  localf.version = ((pw)localObject).version;
                  localf.jjf = ((pw)localObject).EgB;
                  localf.scene = 1146;
                  localObject = new com.tencent.mm.plugin.appbrand.a.g();
                  ((com.tencent.mm.plugin.appbrand.a.g)localObject).dmL = ((float)j.this.ucm.tWI);
                  ((com.tencent.mm.plugin.appbrand.a.g)localObject).doB = ((float)j.this.ucm.tWJ);
                  ((com.tencent.mm.plugin.appbrand.a.g)localObject).gPy = j.this.ucm.dry;
                  ac.i("MicroMsg.TrackMapUI", "pennqin, extra data: %s.", new Object[] { ((com.tencent.mm.plugin.appbrand.a.g)localObject).aUZ() });
                  localf.jjg = ((com.tencent.mm.plugin.appbrand.a.d)localObject);
                  paramAnonymous2View.a(j.this.activity, localf);
                  j.this.uff.bmi();
                }
                AppMethodBeat.o(56159);
                return;
              }
              paramAnonymous2View = new com.tencent.mm.ui.widget.a.e(j.this.activity, 1, true);
              paramAnonymous2View.JfM = true;
              paramAnonymous2View.JfJ = true;
              paramAnonymous2View.ISu = new n.c()
              {
                public final void onCreateMMMenu(final com.tencent.mm.ui.base.l paramAnonymous3l)
                {
                  AppMethodBeat.i(56157);
                  paramAnonymous2View.J(View.inflate(j.this.activity, 2131495747, null), false);
                  int i = 0;
                  Object localObject2;
                  if (i < j.10.this.ufo.size())
                  {
                    localObject2 = (pw)j.10.this.ufo.get(i);
                    localObject1 = u.a(new i(((pw)localObject2).ugE));
                    u.a(new u.a()
                    {
                      public final void k(final String paramAnonymous4String, final Bitmap paramAnonymous4Bitmap)
                      {
                        AppMethodBeat.i(56156);
                        ap.f(new Runnable()
                        {
                          public final void run()
                          {
                            AppMethodBeat.i(56155);
                            if ((j.this.ufk.containsKey(paramAnonymous4String)) && (paramAnonymous4Bitmap != null) && (!paramAnonymous4Bitmap.isRecycled()))
                            {
                              int i = ((Integer)j.this.ufk.remove(paramAnonymous4String)).intValue();
                              if (j.10.1.1.1.this.ufs.getItem(i) != null)
                              {
                                j.10.1.1.1.this.ufs.getItem(i).setIcon(new BitmapDrawable(com.tencent.mm.sdk.platformtools.f.a(com.tencent.mm.sdk.platformtools.f.a(paramAnonymous4Bitmap, false, paramAnonymous4Bitmap.getWidth() / 2.0F, false), j.this.activity.getResources().getDimensionPixelOffset(2131165929), j.this.activity.getResources().getDimensionPixelOffset(2131165929), true, false)));
                                j.10.1.1.this.ufq.fvu();
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
                      j.this.ufk.put(((pw)localObject2).ugE, Integer.valueOf(i));
                    }
                    localObject2 = ((pw)localObject2).nickname;
                    m localm = new m(paramAnonymous3l.mContext, i, 0);
                    localm.setTitle((CharSequence)localObject2);
                    localm.setIcon((Drawable)localObject1);
                    localm.C((Drawable)localObject1);
                    paramAnonymous3l.Hyi.add(localm);
                    i += 1;
                    break;
                    AppMethodBeat.o(56157);
                    return;
                  }
                }
              };
              paramAnonymous2View.ISv = new n.d()
              {
                public final void onMMMenuItemSelected(MenuItem paramAnonymous3MenuItem, int paramAnonymous3Int)
                {
                  AppMethodBeat.i(56158);
                  ac.i("MicroMsg.TrackMapUI", "taxi weapp, index: %s, itemId: %s.", new Object[] { Integer.valueOf(paramAnonymous3Int), Integer.valueOf(paramAnonymous3MenuItem.getItemId()) });
                  Object localObject = (pw)j.10.this.ufo.get(paramAnonymous3Int);
                  ac.i("MicroMsg.TrackMapUI", "taxi weapp info: appid %s, page_url %s, username %s, version %s, version_type %s.", new Object[] { ((pw)localObject).djj, ((pw)localObject).EgB, ((pw)localObject).username, Integer.valueOf(((pw)localObject).version), Integer.valueOf(((pw)localObject).Een) });
                  h.wUl.f(12809, new Object[] { Integer.valueOf(4), "weapp_id_".concat(((pw)localObject).djj) });
                  if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.n.class) != null)
                  {
                    paramAnonymous3MenuItem = (com.tencent.mm.plugin.appbrand.service.n)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.n.class);
                    com.tencent.mm.plugin.appbrand.a.f localf = new com.tencent.mm.plugin.appbrand.a.f();
                    localf.appId = ((pw)localObject).djj;
                    localf.username = ((pw)localObject).username;
                    localf.hxM = ((pw)localObject).Een;
                    localf.version = ((pw)localObject).version;
                    localf.jjf = ((pw)localObject).EgB;
                    localf.scene = 1146;
                    localObject = new com.tencent.mm.plugin.appbrand.a.g();
                    ((com.tencent.mm.plugin.appbrand.a.g)localObject).dmL = ((float)j.this.ucm.tWI);
                    ((com.tencent.mm.plugin.appbrand.a.g)localObject).doB = ((float)j.this.ucm.tWJ);
                    ((com.tencent.mm.plugin.appbrand.a.g)localObject).gPy = j.this.ucm.dry;
                    ac.i("MicroMsg.TrackMapUI", "pennqin, extra data: %s.", new Object[] { ((com.tencent.mm.plugin.appbrand.a.g)localObject).aUZ() });
                    localf.jjg = ((com.tencent.mm.plugin.appbrand.a.d)localObject);
                    paramAnonymous3MenuItem.a(j.this.activity, localf);
                  }
                  AppMethodBeat.o(56158);
                }
              };
              j.this.uff.bmi();
              paramAnonymous2View.cED();
              AppMethodBeat.o(56159);
            }
          });
          j.this.uff.setFooterView((View)localObject1);
        }
        Object localObject1 = new StringBuilder();
        j.this.ufg = j.this.ucl.b(j.this.ucm);
        if (!com.tencent.mm.sdk.platformtools.i.eUv())
        {
          i = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.pTq, 99);
          if (j.this.ufh >= i) {}
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
            paramAnonymousl.aJ(2, 2131764402, 0);
          }
          localObject2 = j.this.ufg.entrySet().iterator();
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
          h.wUl.f(12809, new Object[] { Integer.valueOf(3), ((StringBuilder)localObject1).toString(), localStringBuilder.toString() });
          AppMethodBeat.o(56160);
          return;
        }
      }
    };
    this.uff.ISv = new n.d()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(56148);
        Iterator localIterator;
        switch (paramAnonymousMenuItem.getItemId())
        {
        default: 
          if (j.this.ufg != null) {
            localIterator = j.this.ufg.entrySet().iterator();
          }
          break;
        case 2: 
          while (localIterator.hasNext())
          {
            Map.Entry localEntry = (Map.Entry)localIterator.next();
            if (((String)localEntry.getValue()).equals(paramAnonymousMenuItem.getTitle()))
            {
              j.this.ucl.a(j.this.ucm, j.this.ucn, (String)localEntry.getKey(), false);
              h.wUl.f(12809, new Object[] { Integer.valueOf(4), localEntry.getKey() });
              AppMethodBeat.o(56148);
              return;
              ac.i("MicroMsg.TrackMapUI", "click tencent map: %s", new Object[] { Boolean.valueOf(j.this.ufg.containsKey("com.tencent.map")) });
              if (j.a(j.this))
              {
                j.this.ucl.a(j.this.ucm, j.this.ucn, "com.tencent.map", false);
                h.wUl.f(12809, new Object[] { Integer.valueOf(4), "com.tencent.map" });
                AppMethodBeat.o(56148);
                return;
              }
              paramAnonymousInt = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.pTq, 99);
              if (j.this.ufh < paramAnonymousInt)
              {
                paramAnonymousMenuItem = j.this;
                paramAnonymousMenuItem.ufh += 1;
                com.tencent.mm.kernel.g.agR().agA().set(ah.a.GMQ, Integer.valueOf(j.this.ufh));
              }
              if (1 == ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.pMk, 0)) {}
              for (paramAnonymousInt = 1; paramAnonymousInt != 0; paramAnonymousInt = 0)
              {
                new j.a(j.this.activity, j.this.ufj).execute(new String[] { "https://3gimg.qq.com/tencentMapTouch/app/download/apkForWXAndroidConf.json" });
                AppMethodBeat.o(56148);
                return;
              }
              paramAnonymousMenuItem = new Intent();
              paramAnonymousMenuItem.putExtra("rawUrl", "http://mapdownload.map.qq.com/?key=wx&referer=wx1&channel=00008");
              com.tencent.mm.br.d.b(j.this.activity, "webview", ".ui.tools.WebViewUI", paramAnonymousMenuItem);
              h.wUl.f(12809, new Object[] { Integer.valueOf(5) });
              AppMethodBeat.o(56148);
              return;
            }
          }
        }
        AppMethodBeat.o(56148);
      }
    };
    this.uff.cED();
    AppMethodBeat.o(56174);
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
    this.ufh = ((Integer)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GMQ, Integer.valueOf(0))).intValue();
    ac.i("MicroMsg.TrackMapUI", "count: %s", new Object[] { Integer.valueOf(this.ufh) });
    this.ucm.tWP = this.activity.getIntent().getStringExtra("kPoiid");
    setActionbarColor(ai.getResources().getColor(2131100705));
    AppMethodBeat.o(56169);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(56175);
    super.onDestroy();
    if (this.ueN != null) {
      this.ueN.destroy();
    }
    if (this.ufi != null) {
      com.tencent.mm.kernel.g.agi().a(this.ufi);
    }
    com.tencent.mm.kernel.g.agi().b(1913, this);
    AppMethodBeat.o(56175);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(56177);
    super.onPause();
    if (this.ueN != null) {
      this.ueN.onPause();
    }
    AppMethodBeat.o(56177);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(56176);
    super.onResume();
    if (this.ueN != null) {
      this.ueN.onResume();
    }
    gt localgt;
    if (this.type == 2)
    {
      localgt = new gt();
      localgt.dhx.dcg = this.activity.getIntent().getLongExtra("kFavInfoLocalId", -1L);
      localgt.dhx.type = 4;
      com.tencent.mm.sdk.b.a.GpY.l(localgt);
      if (localgt.dhy.boK != null)
      {
        if (this.uct != null) {
          break label133;
        }
        this.uct = new ArrayList();
      }
    }
    for (;;)
    {
      this.uct.addAll(localgt.dhy.boK);
      cXG();
      AppMethodBeat.o(56176);
      return;
      label133:
      this.uct.clear();
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(56178);
    ac.i("MicroMsg.TrackMapUI", "onSceneEnd, errType: %s, errCode: %s, errMsg: %s.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      AppMethodBeat.o(56178);
      return;
    }
    if (1913 == paramn.getType())
    {
      Object localObject = (com.tencent.mm.plugin.location.model.j)paramn;
      paramString = l.cYp();
      paramn = new ArrayList(8);
      paramn.addAll(((com.tencent.mm.plugin.location.model.j)localObject).tWZ);
      localObject = new ArrayList(8);
      ((List)localObject).addAll(paramn);
      paramString.tWZ = ((List)localObject);
    }
    AppMethodBeat.o(56178);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.j
 * JD-Core Version:    0.7.0.1
 */