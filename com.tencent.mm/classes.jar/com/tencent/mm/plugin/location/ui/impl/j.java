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
import com.tencent.mm.ak.n;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.g.a.gx;
import com.tencent.mm.g.a.gx.b;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.appbrand.api.f;
import com.tencent.mm.plugin.appbrand.service.p;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location.ui.NewMyLocationButton;
import com.tencent.mm.protocal.protobuf.rd;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
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
  Map<String, String> kSd;
  com.tencent.mm.plugin.location.ui.k vtD;
  private com.tencent.mm.plugin.location.ui.j vtF;
  NewMyLocationButton vtS;
  private com.tencent.mm.plugin.location.ui.e vtT;
  View vtU;
  com.tencent.mm.ui.widget.a.e vtV;
  int vtW;
  private com.tencent.mm.plugin.location.model.j vtX;
  View vtY;
  HashMap<String, Integer> vtZ;
  
  public j(Activity paramActivity)
  {
    super(paramActivity);
    AppMethodBeat.i(56168);
    this.vtZ = new HashMap();
    com.tencent.mm.kernel.g.ajj().a(1913, this);
    this.vtX = new com.tencent.mm.plugin.location.model.j();
    com.tencent.mm.kernel.g.ajj().a(this.vtX, 0);
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
  
  final void djV()
  {
    AppMethodBeat.i(56170);
    super.djV();
    ((TextView)findViewById(2131302293)).setText(2131760717);
    findViewById(2131305943).setVisibility(8);
    Object localObject1 = (ViewStub)findViewById(2131301529);
    ((ViewStub)localObject1).setOnInflateListener(new j.1(this));
    this.vtU = ((ViewStub)localObject1).inflate();
    findViewById(2131301520).setVisibility(8);
    this.activity.getWindow().getDecorView().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(56149);
        FrameLayout localFrameLayout = (FrameLayout)j.this.findViewById(2131302155);
        RelativeLayout localRelativeLayout = (RelativeLayout)j.this.vtU.findViewById(2131301527);
        if (localFrameLayout == null)
        {
          ae.w("MicroMsg.TrackMapUI", "mapcontent is null!");
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
    this.vtD = new com.tencent.mm.plugin.location.ui.k(this.activity, this.vrf.voa, false);
    this.vtD.vqs = false;
    this.vtD.vqt = false;
    localObject1 = this.vtD;
    ((com.tencent.mm.plugin.location.ui.k)localObject1).vqq = true;
    if (((com.tencent.mm.plugin.location.ui.k)localObject1).vqj != null)
    {
      ((com.tencent.mm.plugin.location.ui.k)localObject1).vqj.setOnAvatarOnClickListener(null);
      ((com.tencent.mm.plugin.location.ui.k)localObject1).vqj.setOnLocationOnClickListener(null);
      ((com.tencent.mm.plugin.location.ui.k)localObject1).vqj.dks();
    }
    this.vtD.vqn = false;
    this.vtF = new com.tencent.mm.plugin.location.ui.j(this.activity, new com.tencent.mm.plugin.location.ui.j.a()
    {
      public final void Jw(int paramAnonymousInt) {}
      
      public final void djM() {}
      
      public final void djN() {}
    });
    findViewById(2131305183).setVisibility(8);
    this.vrf.gVf.setOnClickListener(new j.6(this));
    this.vtS = ((NewMyLocationButton)this.vtU.findViewById(2131302789));
    localObject1 = this.vtD;
    Object localObject2 = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(56152);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/location/ui/impl/TrackMapUI$6", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
        j.this.vtS.setSelected(false);
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/location/ui/impl/TrackMapUI$6", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(56152);
        return false;
      }
    };
    if (((com.tencent.mm.plugin.location.ui.k)localObject1).vnP != null) {
      ((com.tencent.mm.plugin.location.ui.k)localObject1).vnP.setMapViewOnTouchListener((View.OnTouchListener)localObject2);
    }
    this.vtS.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(56153);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/location/ui/impl/TrackMapUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        j.this.vtD.a(j.this.vrf.voa);
        j.this.vtS.setSelected(true);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/location/ui/impl/TrackMapUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(56153);
      }
    });
    localObject1 = this.activity.getIntent().getStringExtra("kPoi_url");
    if (bu.isNullOrNil((String)localObject1)) {
      this.vrf.rkp.setVisibility(8);
    }
    for (;;)
    {
      this.vuw.vqW.setImageResource(2131232887);
      this.vtT = new com.tencent.mm.plugin.location.ui.e(this.vrf.voa, this.activity);
      if (this.kSe.diX())
      {
        if ((this.jGd != null) && (!this.jGd.equals(""))) {
          this.vtT.jGd = this.jGd;
        }
        this.vtT.setText(this.vuw.getPreText() + this.kSe.vlF);
      }
      localObject1 = new j.4(this);
      localObject2 = this.vtT;
      ((com.tencent.mm.plugin.location.ui.e)localObject2).vod.setOnClickListener((View.OnClickListener)localObject1);
      ((com.tencent.mm.plugin.location.ui.e)localObject2).vod.setVisibility(0);
      this.vtY = findViewById(2131299209);
      AppMethodBeat.o(56170);
      return;
      this.vrf.rkp.setVisibility(0);
      this.vrf.rkp.setOnClickListener(new j.9(this, (String)localObject1));
    }
  }
  
  public final void dkn()
  {
    AppMethodBeat.i(56172);
    super.dkn();
    AppMethodBeat.o(56172);
  }
  
  public final void dkq()
  {
    AppMethodBeat.i(56173);
    super.dkq();
    ae.i("MicroMsg.TrackMapUI", "onDown");
    AppMethodBeat.o(56173);
  }
  
  protected final void dkr()
  {
    AppMethodBeat.i(56174);
    l locall = l.dkA();
    final ArrayList localArrayList = new ArrayList(8);
    localArrayList.addAll(locall.vlT);
    this.vtV = new com.tencent.mm.ui.widget.a.e(this.activity, 1, false);
    this.vtV.LfS = new n.d()
    {
      public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
      {
        AppMethodBeat.i(56160);
        StringBuilder localStringBuilder = new StringBuilder();
        Object localObject2;
        int j;
        Object localObject3;
        if (!bu.ht(localArrayList))
        {
          localObject1 = LayoutInflater.from(j.this.activity).inflate(2131495746, new FrameLayout(j.this.activity), false);
          localObject2 = (LinearLayout)((View)localObject1).findViewById(2131306895);
          i = aq.fromDPToPix(j.this.activity, 24);
          j = aq.fromDPToPix(j.this.activity, 2);
          localObject3 = new c.a();
          ((c.a)localObject3).hhW = true;
          ((c.a)localObject3).hgF = i;
          ((c.a)localObject3).hgG = i;
          localObject3 = ((c.a)localObject3).aJu();
          Object localObject4 = localArrayList.iterator();
          while (((Iterator)localObject4).hasNext())
          {
            rd localrd = (rd)((Iterator)localObject4).next();
            ImageView localImageView = new ImageView(j.this.activity);
            LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(i, i);
            localLayoutParams.leftMargin = j;
            localLayoutParams.rightMargin = j;
            ((LinearLayout)localObject2).addView(localImageView, localLayoutParams);
            com.tencent.mm.av.q.aJb().a(localrd.vvt, localImageView, (c)localObject3);
            localStringBuilder.append("weapp_id_").append(localrd.dwb).append("|");
          }
          if (1 == localArrayList.size())
          {
            localObject3 = new TextView(j.this.activity);
            ((TextView)localObject3).setTextColor(j.this.activity.getResources().getColor(2131100711));
            ((TextView)localObject3).setTextSize(17.0F);
            ((TextView)localObject3).setGravity(17);
            ((TextView)localObject3).setText(((rd)localArrayList.get(0)).nickname);
            localObject4 = new LinearLayout.LayoutParams(-2, -2);
            ((LinearLayout.LayoutParams)localObject4).leftMargin = (j * 3);
            ((LinearLayout)localObject2).addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
          }
          ((View)localObject1).setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(final View paramAnonymous2View)
            {
              AppMethodBeat.i(56159);
              Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
              ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymous2View);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/location/ui/impl/TrackMapUI$9$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
              if (1 == j.10.this.vud.size())
              {
                ae.i("MicroMsg.TrackMapUI", "pennqin, only one taxi weapp.");
                Object localObject2 = (rd)j.10.this.vud.get(0);
                ae.i("MicroMsg.TrackMapUI", "taxi weapp info: appid %s, page_url %s, username %s, version %s, version_type %s.", new Object[] { ((rd)localObject2).dwb, ((rd)localObject2).Gfz, ((rd)localObject2).username, Integer.valueOf(((rd)localObject2).version), Integer.valueOf(((rd)localObject2).Gdl) });
                com.tencent.mm.plugin.report.service.g.yxI.f(12809, new Object[] { Integer.valueOf(4), "weapp_id_".concat(((rd)localObject2).dwb) });
                if (com.tencent.mm.kernel.g.ab(p.class) != null)
                {
                  paramAnonymous2View = (p)com.tencent.mm.kernel.g.ab(p.class);
                  localObject1 = new f();
                  ((f)localObject1).appId = ((rd)localObject2).dwb;
                  ((f)localObject1).username = ((rd)localObject2).username;
                  ((f)localObject1).hSZ = ((rd)localObject2).Gdl;
                  ((f)localObject1).version = ((rd)localObject2).version;
                  ((f)localObject1).jFL = ((rd)localObject2).Gfz;
                  ((f)localObject1).scene = 1146;
                  localObject2 = new com.tencent.mm.plugin.appbrand.api.g();
                  ((com.tencent.mm.plugin.appbrand.api.g)localObject2).dzE = ((float)j.this.kSe.vlC);
                  ((com.tencent.mm.plugin.appbrand.api.g)localObject2).dBu = ((float)j.this.kSe.vlD);
                  ((com.tencent.mm.plugin.appbrand.api.g)localObject2).jGd = j.this.kSe.dEv;
                  ae.i("MicroMsg.TrackMapUI", "pennqin, extra data: %s.", new Object[] { ((com.tencent.mm.plugin.appbrand.api.g)localObject2).aYO() });
                  ((f)localObject1).jFM = ((com.tencent.mm.plugin.appbrand.api.d)localObject2);
                  paramAnonymous2View.a(j.this.activity, (f)localObject1);
                  j.this.vtV.bqD();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/location/ui/impl/TrackMapUI$9$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(56159);
                return;
              }
              paramAnonymous2View = new com.tencent.mm.ui.widget.a.e(j.this.activity, 1, true);
              paramAnonymous2View.Lty = true;
              paramAnonymous2View.Ltv = true;
              paramAnonymous2View.LfS = new n.d()
              {
                public final void onCreateMMMenu(final com.tencent.mm.ui.base.l paramAnonymous3l)
                {
                  AppMethodBeat.i(56157);
                  paramAnonymous2View.P(View.inflate(j.this.activity, 2131495747, null), false);
                  int i = 0;
                  Object localObject2;
                  if (i < j.10.this.vud.size())
                  {
                    localObject2 = (rd)j.10.this.vud.get(i);
                    localObject1 = u.a(new i(((rd)localObject2).vvt));
                    u.a(new u.a()
                    {
                      public final void k(final String paramAnonymous4String, final Bitmap paramAnonymous4Bitmap)
                      {
                        AppMethodBeat.i(56156);
                        ar.f(new Runnable()
                        {
                          public final void run()
                          {
                            AppMethodBeat.i(56155);
                            if ((j.this.vtZ.containsKey(paramAnonymous4String)) && (paramAnonymous4Bitmap != null) && (!paramAnonymous4Bitmap.isRecycled()))
                            {
                              int i = ((Integer)j.this.vtZ.remove(paramAnonymous4String)).intValue();
                              if (j.10.1.1.1.this.vuh.getItem(i) != null)
                              {
                                j.10.1.1.1.this.vuh.getItem(i).setIcon(new BitmapDrawable(h.a(h.a(paramAnonymous4Bitmap, false, paramAnonymous4Bitmap.getWidth() / 2.0F, false), j.this.activity.getResources().getDimensionPixelOffset(2131165929), j.this.activity.getResources().getDimensionPixelOffset(2131165929), true, false)));
                                j.10.1.1.this.vuf.fQA();
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
                  for (Object localObject1 = new BitmapDrawable(h.a(h.a((Bitmap)localObject1, false, ((Bitmap)localObject1).getWidth() / 2.0F, false), j.this.activity.getResources().getDimensionPixelOffset(2131165929), j.this.activity.getResources().getDimensionPixelOffset(2131165929), true, false));; localObject1 = null)
                  {
                    if (localObject1 == null) {
                      j.this.vtZ.put(((rd)localObject2).vvt, Integer.valueOf(i));
                    }
                    localObject2 = ((rd)localObject2).nickname;
                    m localm = new m(paramAnonymous3l.mContext, i, 0);
                    localm.setTitle((CharSequence)localObject2);
                    localm.setIcon((Drawable)localObject1);
                    localm.D((Drawable)localObject1);
                    paramAnonymous3l.JGM.add(localm);
                    i += 1;
                    break;
                    AppMethodBeat.o(56157);
                    return;
                  }
                }
              };
              paramAnonymous2View.LfT = new n.e()
              {
                public final void onMMMenuItemSelected(MenuItem paramAnonymous3MenuItem, int paramAnonymous3Int)
                {
                  AppMethodBeat.i(56158);
                  ae.i("MicroMsg.TrackMapUI", "taxi weapp, index: %s, itemId: %s.", new Object[] { Integer.valueOf(paramAnonymous3Int), Integer.valueOf(paramAnonymous3MenuItem.getItemId()) });
                  Object localObject = (rd)j.10.this.vud.get(paramAnonymous3Int);
                  ae.i("MicroMsg.TrackMapUI", "taxi weapp info: appid %s, page_url %s, username %s, version %s, version_type %s.", new Object[] { ((rd)localObject).dwb, ((rd)localObject).Gfz, ((rd)localObject).username, Integer.valueOf(((rd)localObject).version), Integer.valueOf(((rd)localObject).Gdl) });
                  com.tencent.mm.plugin.report.service.g.yxI.f(12809, new Object[] { Integer.valueOf(4), "weapp_id_".concat(((rd)localObject).dwb) });
                  if (com.tencent.mm.kernel.g.ab(p.class) != null)
                  {
                    paramAnonymous3MenuItem = (p)com.tencent.mm.kernel.g.ab(p.class);
                    f localf = new f();
                    localf.appId = ((rd)localObject).dwb;
                    localf.username = ((rd)localObject).username;
                    localf.hSZ = ((rd)localObject).Gdl;
                    localf.version = ((rd)localObject).version;
                    localf.jFL = ((rd)localObject).Gfz;
                    localf.scene = 1146;
                    localObject = new com.tencent.mm.plugin.appbrand.api.g();
                    ((com.tencent.mm.plugin.appbrand.api.g)localObject).dzE = ((float)j.this.kSe.vlC);
                    ((com.tencent.mm.plugin.appbrand.api.g)localObject).dBu = ((float)j.this.kSe.vlD);
                    ((com.tencent.mm.plugin.appbrand.api.g)localObject).jGd = j.this.kSe.dEv;
                    ae.i("MicroMsg.TrackMapUI", "pennqin, extra data: %s.", new Object[] { ((com.tencent.mm.plugin.appbrand.api.g)localObject).aYO() });
                    localf.jFM = ((com.tencent.mm.plugin.appbrand.api.d)localObject);
                    paramAnonymous3MenuItem.a(j.this.activity, localf);
                  }
                  AppMethodBeat.o(56158);
                }
              };
              j.this.vtV.bqD();
              paramAnonymous2View.cPF();
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/location/ui/impl/TrackMapUI$9$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(56159);
            }
          });
          j.this.vtV.setFooterView((View)localObject1);
        }
        Object localObject1 = new StringBuilder();
        j.this.kSd = j.this.kSg.b(j.this.kSe);
        if (!com.tencent.mm.sdk.platformtools.k.fnT())
        {
          i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qFc, 99);
          if (j.this.vtW >= i) {}
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
            paramAnonymousl.aM(2, 2131764402, 0);
          }
          localObject2 = j.this.kSd.entrySet().iterator();
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
          com.tencent.mm.plugin.report.service.g.yxI.f(12809, new Object[] { Integer.valueOf(3), ((StringBuilder)localObject1).toString(), localStringBuilder.toString() });
          AppMethodBeat.o(56160);
          return;
        }
      }
    };
    this.vtV.LfT = new n.e()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(56148);
        Iterator localIterator;
        switch (paramAnonymousMenuItem.getItemId())
        {
        default: 
          if (j.this.kSd != null) {
            localIterator = j.this.kSd.entrySet().iterator();
          }
          break;
        case 2: 
          while (localIterator.hasNext())
          {
            Map.Entry localEntry = (Map.Entry)localIterator.next();
            if (((String)localEntry.getValue()).equals(paramAnonymousMenuItem.getTitle()))
            {
              j.this.kSg.a(j.this.kSe, j.this.kSf, (String)localEntry.getKey(), false);
              com.tencent.mm.plugin.report.service.g.yxI.f(12809, new Object[] { Integer.valueOf(4), localEntry.getKey() });
              AppMethodBeat.o(56148);
              return;
              ae.i("MicroMsg.TrackMapUI", "click tencent map: %s", new Object[] { Boolean.valueOf(j.this.kSd.containsKey("com.tencent.map")) });
              if (j.a(j.this))
              {
                j.this.kSg.a(j.this.kSe, j.this.kSf, "com.tencent.map", false);
                com.tencent.mm.plugin.report.service.g.yxI.f(12809, new Object[] { Integer.valueOf(4), "com.tencent.map" });
                AppMethodBeat.o(56148);
                return;
              }
              paramAnonymousInt = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qFc, 99);
              if (j.this.vtW < paramAnonymousInt)
              {
                paramAnonymousMenuItem = j.this;
                paramAnonymousMenuItem.vtW += 1;
                com.tencent.mm.kernel.g.ajR().ajA().set(am.a.ITG, Integer.valueOf(j.this.vtW));
              }
              if (1 == ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qwF, 0)) {}
              for (paramAnonymousInt = 1; paramAnonymousInt != 0; paramAnonymousInt = 0)
              {
                new j.a(j.this.activity, j.this.vtY).execute(new String[] { "https://3gimg.qq.com/tencentMapTouch/app/download/apkForWXAndroidConf.json" });
                AppMethodBeat.o(56148);
                return;
              }
              paramAnonymousMenuItem = new Intent();
              paramAnonymousMenuItem.putExtra("rawUrl", "http://mapdownload.map.qq.com/?key=wx&referer=wx1&channel=00008");
              com.tencent.mm.br.d.b(j.this.activity, "webview", ".ui.tools.WebViewUI", paramAnonymousMenuItem);
              com.tencent.mm.plugin.report.service.g.yxI.f(12809, new Object[] { Integer.valueOf(5) });
              AppMethodBeat.o(56148);
              return;
            }
          }
        }
        AppMethodBeat.o(56148);
      }
    };
    this.vtV.cPF();
    AppMethodBeat.o(56174);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(56169);
    super.onCreate(paramBundle);
    this.vtW = ((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.ITG, Integer.valueOf(0))).intValue();
    ae.i("MicroMsg.TrackMapUI", "count: %s", new Object[] { Integer.valueOf(this.vtW) });
    this.kSe.vlJ = this.activity.getIntent().getStringExtra("kPoiid");
    setActionbarColor(ak.getResources().getColor(2131100705));
    AppMethodBeat.o(56169);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(56175);
    super.onDestroy();
    if (this.vtD != null) {
      this.vtD.destroy();
    }
    if (this.vtX != null) {
      com.tencent.mm.kernel.g.ajj().a(this.vtX);
    }
    com.tencent.mm.kernel.g.ajj().b(1913, this);
    AppMethodBeat.o(56175);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(56177);
    super.onPause();
    if (this.vtD != null) {
      this.vtD.onPause();
    }
    AppMethodBeat.o(56177);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(56176);
    super.onResume();
    if (this.vtD != null) {
      this.vtD.onResume();
    }
    gx localgx;
    if (this.type == 2)
    {
      localgx = new gx();
      localgx.dub.doH = this.activity.getIntent().getLongExtra("kFavInfoLocalId", -1L);
      localgx.dub.type = 4;
      com.tencent.mm.sdk.b.a.IvT.l(localgx);
      if (localgx.duc.bzf != null)
      {
        if (this.vrk != null) {
          break label133;
        }
        this.vrk = new ArrayList();
      }
    }
    for (;;)
    {
      this.vrk.addAll(localgx.duc.bzf);
      djR();
      AppMethodBeat.o(56176);
      return;
      label133:
      this.vrk.clear();
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(56178);
    ae.i("MicroMsg.TrackMapUI", "onSceneEnd, errType: %s, errCode: %s, errMsg: %s.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      AppMethodBeat.o(56178);
      return;
    }
    if (1913 == paramn.getType())
    {
      Object localObject = (com.tencent.mm.plugin.location.model.j)paramn;
      paramString = l.dkA();
      paramn = new ArrayList(8);
      paramn.addAll(((com.tencent.mm.plugin.location.model.j)localObject).vlT);
      localObject = new ArrayList(8);
      ((List)localObject).addAll(paramn);
      paramString.vlT = ((List)localObject);
    }
    AppMethodBeat.o(56178);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.j
 * JD-Core Version:    0.7.0.1
 */