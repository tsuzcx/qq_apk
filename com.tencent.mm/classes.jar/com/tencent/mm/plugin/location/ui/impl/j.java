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
import com.tencent.mm.al.n;
import com.tencent.mm.aw.a.a.c;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.g.a.gw;
import com.tencent.mm.g.a.gw.b;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.appbrand.api.f;
import com.tencent.mm.plugin.appbrand.service.o;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location.ui.NewMyLocationButton;
import com.tencent.mm.protocal.protobuf.rb;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
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
  NewMyLocationButton vhL;
  private com.tencent.mm.plugin.location.ui.e vhM;
  View vhN;
  com.tencent.mm.ui.widget.a.e vhO;
  Map<String, String> vhP;
  int vhQ;
  private com.tencent.mm.plugin.location.model.j vhR;
  View vhS;
  HashMap<String, Integer> vhT;
  com.tencent.mm.plugin.location.ui.k vhw;
  private com.tencent.mm.plugin.location.ui.j vhy;
  
  public j(Activity paramActivity)
  {
    super(paramActivity);
    AppMethodBeat.i(56168);
    this.vhT = new HashMap();
    com.tencent.mm.kernel.g.aiU().a(1913, this);
    this.vhR = new com.tencent.mm.plugin.location.model.j();
    com.tencent.mm.kernel.g.aiU().a(this.vhR, 0);
    AppMethodBeat.o(56168);
  }
  
  final void dgW()
  {
    AppMethodBeat.i(56170);
    super.dgW();
    ((TextView)findViewById(2131302293)).setText(2131760717);
    findViewById(2131305943).setVisibility(8);
    Object localObject1 = (ViewStub)findViewById(2131301529);
    ((ViewStub)localObject1).setOnInflateListener(new j.1(this));
    this.vhN = ((ViewStub)localObject1).inflate();
    findViewById(2131301520).setVisibility(8);
    this.activity.getWindow().getDecorView().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(56149);
        FrameLayout localFrameLayout = (FrameLayout)j.this.findViewById(2131302155);
        RelativeLayout localRelativeLayout = (RelativeLayout)j.this.vhN.findViewById(2131301527);
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
    this.vhw = new com.tencent.mm.plugin.location.ui.k(this.activity, this.veY.vbP, false);
    this.vhw.veh = false;
    this.vhw.vei = false;
    localObject1 = this.vhw;
    ((com.tencent.mm.plugin.location.ui.k)localObject1).vef = true;
    if (((com.tencent.mm.plugin.location.ui.k)localObject1).vdY != null)
    {
      ((com.tencent.mm.plugin.location.ui.k)localObject1).vdY.setOnAvatarOnClickListener(null);
      ((com.tencent.mm.plugin.location.ui.k)localObject1).vdY.setOnLocationOnClickListener(null);
      ((com.tencent.mm.plugin.location.ui.k)localObject1).vdY.dht();
    }
    this.vhw.vec = false;
    this.vhy = new com.tencent.mm.plugin.location.ui.j(this.activity, new com.tencent.mm.plugin.location.ui.j.a()
    {
      public final void IX(int paramAnonymousInt) {}
      
      public final void dgN() {}
      
      public final void dgO() {}
    });
    findViewById(2131305183).setVisibility(8);
    this.veY.gSx.setOnClickListener(new j.6(this));
    this.vhL = ((NewMyLocationButton)this.vhN.findViewById(2131302789));
    localObject1 = this.vhw;
    Object localObject2 = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(56152);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/location/ui/impl/TrackMapUI$6", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
        j.this.vhL.setSelected(false);
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/location/ui/impl/TrackMapUI$6", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(56152);
        return false;
      }
    };
    if (((com.tencent.mm.plugin.location.ui.k)localObject1).vbE != null) {
      ((com.tencent.mm.plugin.location.ui.k)localObject1).vbE.setMapViewOnTouchListener((View.OnTouchListener)localObject2);
    }
    this.vhL.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(56153);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/location/ui/impl/TrackMapUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        j.this.vhw.a(j.this.veY.vbP);
        j.this.vhL.setSelected(true);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/location/ui/impl/TrackMapUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(56153);
      }
    });
    localObject1 = this.activity.getIntent().getStringExtra("kPoi_url");
    if (bt.isNullOrNil((String)localObject1)) {
      this.veY.rcj.setVisibility(8);
    }
    for (;;)
    {
      this.vir.veM.setImageResource(2131232887);
      this.vhM = new com.tencent.mm.plugin.location.ui.e(this.veY.vbP, this.activity);
      if (this.veW.dfY())
      {
        if ((this.jDf != null) && (!this.jDf.equals(""))) {
          this.vhM.jDf = this.jDf;
        }
        this.vhM.setText(this.vir.getPreText() + this.veW.uZu);
      }
      localObject1 = new j.4(this);
      localObject2 = this.vhM;
      ((com.tencent.mm.plugin.location.ui.e)localObject2).vbS.setOnClickListener((View.OnClickListener)localObject1);
      ((com.tencent.mm.plugin.location.ui.e)localObject2).vbS.setVisibility(0);
      this.vhS = findViewById(2131299209);
      AppMethodBeat.o(56170);
      return;
      this.veY.rcj.setVisibility(0);
      this.veY.rcj.setOnClickListener(new j.9(this, (String)localObject1));
    }
  }
  
  public final void dho()
  {
    AppMethodBeat.i(56172);
    super.dho();
    AppMethodBeat.o(56172);
  }
  
  public final void dhr()
  {
    AppMethodBeat.i(56173);
    super.dhr();
    ad.i("MicroMsg.TrackMapUI", "onDown");
    AppMethodBeat.o(56173);
  }
  
  protected final void dhs()
  {
    AppMethodBeat.i(56174);
    l locall = l.dhB();
    final ArrayList localArrayList = new ArrayList(8);
    localArrayList.addAll(locall.uZI);
    this.vhO = new com.tencent.mm.ui.widget.a.e(this.activity, 1, false);
    this.vhO.KJy = new n.d()
    {
      public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
      {
        AppMethodBeat.i(56160);
        StringBuilder localStringBuilder = new StringBuilder();
        Object localObject2;
        int j;
        Object localObject3;
        if (!bt.hj(localArrayList))
        {
          localObject1 = LayoutInflater.from(j.this.activity).inflate(2131495746, new FrameLayout(j.this.activity), false);
          localObject2 = (LinearLayout)((View)localObject1).findViewById(2131306895);
          i = com.tencent.mm.ui.aq.fromDPToPix(j.this.activity, 24);
          j = com.tencent.mm.ui.aq.fromDPToPix(j.this.activity, 2);
          localObject3 = new c.a();
          ((c.a)localObject3).hfi = true;
          ((c.a)localObject3).hdR = i;
          ((c.a)localObject3).hdS = i;
          localObject3 = ((c.a)localObject3).aJc();
          Object localObject4 = localArrayList.iterator();
          while (((Iterator)localObject4).hasNext())
          {
            rb localrb = (rb)((Iterator)localObject4).next();
            ImageView localImageView = new ImageView(j.this.activity);
            LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(i, i);
            localLayoutParams.leftMargin = j;
            localLayoutParams.rightMargin = j;
            ((LinearLayout)localObject2).addView(localImageView, localLayoutParams);
            com.tencent.mm.aw.q.aIJ().a(localrb.vjo, localImageView, (c)localObject3);
            localStringBuilder.append("weapp_id_").append(localrb.duW).append("|");
          }
          if (1 == localArrayList.size())
          {
            localObject3 = new TextView(j.this.activity);
            ((TextView)localObject3).setTextColor(j.this.activity.getResources().getColor(2131100711));
            ((TextView)localObject3).setTextSize(17.0F);
            ((TextView)localObject3).setGravity(17);
            ((TextView)localObject3).setText(((rb)localArrayList.get(0)).nickname);
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
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/location/ui/impl/TrackMapUI$9$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
              if (1 == j.10.this.vhX.size())
              {
                ad.i("MicroMsg.TrackMapUI", "pennqin, only one taxi weapp.");
                Object localObject2 = (rb)j.10.this.vhX.get(0);
                ad.i("MicroMsg.TrackMapUI", "taxi weapp info: appid %s, page_url %s, username %s, version %s, version_type %s.", new Object[] { ((rb)localObject2).duW, ((rb)localObject2).FNa, ((rb)localObject2).username, Integer.valueOf(((rb)localObject2).version), Integer.valueOf(((rb)localObject2).FKM) });
                com.tencent.mm.plugin.report.service.g.yhR.f(12809, new Object[] { Integer.valueOf(4), "weapp_id_".concat(((rb)localObject2).duW) });
                if (com.tencent.mm.kernel.g.ab(o.class) != null)
                {
                  paramAnonymous2View = (o)com.tencent.mm.kernel.g.ab(o.class);
                  localObject1 = new f();
                  ((f)localObject1).appId = ((rb)localObject2).duW;
                  ((f)localObject1).username = ((rb)localObject2).username;
                  ((f)localObject1).hQh = ((rb)localObject2).FKM;
                  ((f)localObject1).version = ((rb)localObject2).version;
                  ((f)localObject1).jCN = ((rb)localObject2).FNa;
                  ((f)localObject1).scene = 1146;
                  localObject2 = new com.tencent.mm.plugin.appbrand.api.g();
                  ((com.tencent.mm.plugin.appbrand.api.g)localObject2).dyz = ((float)j.this.veW.uZr);
                  ((com.tencent.mm.plugin.appbrand.api.g)localObject2).dAp = ((float)j.this.veW.uZs);
                  ((com.tencent.mm.plugin.appbrand.api.g)localObject2).jDf = j.this.veW.dDq;
                  ad.i("MicroMsg.TrackMapUI", "pennqin, extra data: %s.", new Object[] { ((com.tencent.mm.plugin.appbrand.api.g)localObject2).aYt() });
                  ((f)localObject1).jCO = ((com.tencent.mm.plugin.appbrand.api.d)localObject2);
                  paramAnonymous2View.a(j.this.activity, (f)localObject1);
                  j.this.vhO.bpT();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/location/ui/impl/TrackMapUI$9$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(56159);
                return;
              }
              paramAnonymous2View = new com.tencent.mm.ui.widget.a.e(j.this.activity, 1, true);
              paramAnonymous2View.KXa = true;
              paramAnonymous2View.KWX = true;
              paramAnonymous2View.KJy = new n.d()
              {
                public final void onCreateMMMenu(final com.tencent.mm.ui.base.l paramAnonymous3l)
                {
                  AppMethodBeat.i(56157);
                  paramAnonymous2View.K(View.inflate(j.this.activity, 2131495747, null), false);
                  int i = 0;
                  Object localObject2;
                  if (i < j.10.this.vhX.size())
                  {
                    localObject2 = (rb)j.10.this.vhX.get(i);
                    localObject1 = u.a(new i(((rb)localObject2).vjo));
                    u.a(new u.a()
                    {
                      public final void k(final String paramAnonymous4String, final Bitmap paramAnonymous4Bitmap)
                      {
                        AppMethodBeat.i(56156);
                        com.tencent.mm.sdk.platformtools.aq.f(new Runnable()
                        {
                          public final void run()
                          {
                            AppMethodBeat.i(56155);
                            if ((j.this.vhT.containsKey(paramAnonymous4String)) && (paramAnonymous4Bitmap != null) && (!paramAnonymous4Bitmap.isRecycled()))
                            {
                              int i = ((Integer)j.this.vhT.remove(paramAnonymous4String)).intValue();
                              if (j.10.1.1.1.this.vic.getItem(i) != null)
                              {
                                j.10.1.1.1.this.vic.getItem(i).setIcon(new BitmapDrawable(com.tencent.mm.sdk.platformtools.g.a(com.tencent.mm.sdk.platformtools.g.a(paramAnonymous4Bitmap, false, paramAnonymous4Bitmap.getWidth() / 2.0F, false), j.this.activity.getResources().getDimensionPixelOffset(2131165929), j.this.activity.getResources().getDimensionPixelOffset(2131165929), true, false)));
                                j.10.1.1.this.vhZ.fMg();
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
                  for (Object localObject1 = new BitmapDrawable(com.tencent.mm.sdk.platformtools.g.a(com.tencent.mm.sdk.platformtools.g.a((Bitmap)localObject1, false, ((Bitmap)localObject1).getWidth() / 2.0F, false), j.this.activity.getResources().getDimensionPixelOffset(2131165929), j.this.activity.getResources().getDimensionPixelOffset(2131165929), true, false));; localObject1 = null)
                  {
                    if (localObject1 == null) {
                      j.this.vhT.put(((rb)localObject2).vjo, Integer.valueOf(i));
                    }
                    localObject2 = ((rb)localObject2).nickname;
                    m localm = new m(paramAnonymous3l.mContext, i, 0);
                    localm.setTitle((CharSequence)localObject2);
                    localm.setIcon((Drawable)localObject1);
                    localm.C((Drawable)localObject1);
                    paramAnonymous3l.JlY.add(localm);
                    i += 1;
                    break;
                    AppMethodBeat.o(56157);
                    return;
                  }
                }
              };
              paramAnonymous2View.KJz = new n.e()
              {
                public final void onMMMenuItemSelected(MenuItem paramAnonymous3MenuItem, int paramAnonymous3Int)
                {
                  AppMethodBeat.i(56158);
                  ad.i("MicroMsg.TrackMapUI", "taxi weapp, index: %s, itemId: %s.", new Object[] { Integer.valueOf(paramAnonymous3Int), Integer.valueOf(paramAnonymous3MenuItem.getItemId()) });
                  Object localObject = (rb)j.10.this.vhX.get(paramAnonymous3Int);
                  ad.i("MicroMsg.TrackMapUI", "taxi weapp info: appid %s, page_url %s, username %s, version %s, version_type %s.", new Object[] { ((rb)localObject).duW, ((rb)localObject).FNa, ((rb)localObject).username, Integer.valueOf(((rb)localObject).version), Integer.valueOf(((rb)localObject).FKM) });
                  com.tencent.mm.plugin.report.service.g.yhR.f(12809, new Object[] { Integer.valueOf(4), "weapp_id_".concat(((rb)localObject).duW) });
                  if (com.tencent.mm.kernel.g.ab(o.class) != null)
                  {
                    paramAnonymous3MenuItem = (o)com.tencent.mm.kernel.g.ab(o.class);
                    f localf = new f();
                    localf.appId = ((rb)localObject).duW;
                    localf.username = ((rb)localObject).username;
                    localf.hQh = ((rb)localObject).FKM;
                    localf.version = ((rb)localObject).version;
                    localf.jCN = ((rb)localObject).FNa;
                    localf.scene = 1146;
                    localObject = new com.tencent.mm.plugin.appbrand.api.g();
                    ((com.tencent.mm.plugin.appbrand.api.g)localObject).dyz = ((float)j.this.veW.uZr);
                    ((com.tencent.mm.plugin.appbrand.api.g)localObject).dAp = ((float)j.this.veW.uZs);
                    ((com.tencent.mm.plugin.appbrand.api.g)localObject).jDf = j.this.veW.dDq;
                    ad.i("MicroMsg.TrackMapUI", "pennqin, extra data: %s.", new Object[] { ((com.tencent.mm.plugin.appbrand.api.g)localObject).aYt() });
                    localf.jCO = ((com.tencent.mm.plugin.appbrand.api.d)localObject);
                    paramAnonymous3MenuItem.a(j.this.activity, localf);
                  }
                  AppMethodBeat.o(56158);
                }
              };
              j.this.vhO.bpT();
              paramAnonymous2View.cMW();
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/location/ui/impl/TrackMapUI$9$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(56159);
            }
          });
          j.this.vhO.setFooterView((View)localObject1);
        }
        Object localObject1 = new StringBuilder();
        j.this.vhP = j.this.veV.b(j.this.veW);
        if (!com.tencent.mm.sdk.platformtools.j.fjZ())
        {
          i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qxW, 99);
          if (j.this.vhQ >= i) {}
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
            paramAnonymousl.aL(2, 2131764402, 0);
          }
          localObject2 = j.this.vhP.entrySet().iterator();
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
          com.tencent.mm.plugin.report.service.g.yhR.f(12809, new Object[] { Integer.valueOf(3), ((StringBuilder)localObject1).toString(), localStringBuilder.toString() });
          AppMethodBeat.o(56160);
          return;
        }
      }
    };
    this.vhO.KJz = new n.e()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(56148);
        Iterator localIterator;
        switch (paramAnonymousMenuItem.getItemId())
        {
        default: 
          if (j.this.vhP != null) {
            localIterator = j.this.vhP.entrySet().iterator();
          }
          break;
        case 2: 
          while (localIterator.hasNext())
          {
            Map.Entry localEntry = (Map.Entry)localIterator.next();
            if (((String)localEntry.getValue()).equals(paramAnonymousMenuItem.getTitle()))
            {
              j.this.veV.a(j.this.veW, j.this.veX, (String)localEntry.getKey(), false);
              com.tencent.mm.plugin.report.service.g.yhR.f(12809, new Object[] { Integer.valueOf(4), localEntry.getKey() });
              AppMethodBeat.o(56148);
              return;
              ad.i("MicroMsg.TrackMapUI", "click tencent map: %s", new Object[] { Boolean.valueOf(j.this.vhP.containsKey("com.tencent.map")) });
              if (j.a(j.this))
              {
                j.this.veV.a(j.this.veW, j.this.veX, "com.tencent.map", false);
                com.tencent.mm.plugin.report.service.g.yhR.f(12809, new Object[] { Integer.valueOf(4), "com.tencent.map" });
                AppMethodBeat.o(56148);
                return;
              }
              paramAnonymousInt = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qxW, 99);
              if (j.this.vhQ < paramAnonymousInt)
              {
                paramAnonymousMenuItem = j.this;
                paramAnonymousMenuItem.vhQ += 1;
                com.tencent.mm.kernel.g.ajC().ajl().set(al.a.Izi, Integer.valueOf(j.this.vhQ));
              }
              if (1 == ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qpY, 0)) {}
              for (paramAnonymousInt = 1; paramAnonymousInt != 0; paramAnonymousInt = 0)
              {
                new j.a(j.this.activity, j.this.vhS).execute(new String[] { "https://3gimg.qq.com/tencentMapTouch/app/download/apkForWXAndroidConf.json" });
                AppMethodBeat.o(56148);
                return;
              }
              paramAnonymousMenuItem = new Intent();
              paramAnonymousMenuItem.putExtra("rawUrl", "http://mapdownload.map.qq.com/?key=wx&referer=wx1&channel=00008");
              com.tencent.mm.bs.d.b(j.this.activity, "webview", ".ui.tools.WebViewUI", paramAnonymousMenuItem);
              com.tencent.mm.plugin.report.service.g.yhR.f(12809, new Object[] { Integer.valueOf(5) });
              AppMethodBeat.o(56148);
              return;
            }
          }
        }
        AppMethodBeat.o(56148);
      }
    };
    this.vhO.cMW();
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
    this.vhQ = ((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Izi, Integer.valueOf(0))).intValue();
    ad.i("MicroMsg.TrackMapUI", "count: %s", new Object[] { Integer.valueOf(this.vhQ) });
    this.veW.uZy = this.activity.getIntent().getStringExtra("kPoiid");
    setActionbarColor(aj.getResources().getColor(2131100705));
    AppMethodBeat.o(56169);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(56175);
    super.onDestroy();
    if (this.vhw != null) {
      this.vhw.destroy();
    }
    if (this.vhR != null) {
      com.tencent.mm.kernel.g.aiU().a(this.vhR);
    }
    com.tencent.mm.kernel.g.aiU().b(1913, this);
    AppMethodBeat.o(56175);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(56177);
    super.onPause();
    if (this.vhw != null) {
      this.vhw.onPause();
    }
    AppMethodBeat.o(56177);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(56176);
    super.onResume();
    if (this.vhw != null) {
      this.vhw.onResume();
    }
    gw localgw;
    if (this.type == 2)
    {
      localgw = new gw();
      localgw.dsV.dnC = this.activity.getIntent().getLongExtra("kFavInfoLocalId", -1L);
      localgw.dsV.type = 4;
      com.tencent.mm.sdk.b.a.IbL.l(localgw);
      if (localgw.dsW.bzf != null)
      {
        if (this.vfd != null) {
          break label133;
        }
        this.vfd = new ArrayList();
      }
    }
    for (;;)
    {
      this.vfd.addAll(localgw.dsW.bzf);
      dgS();
      AppMethodBeat.o(56176);
      return;
      label133:
      this.vfd.clear();
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
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
      paramString = l.dhB();
      paramn = new ArrayList(8);
      paramn.addAll(((com.tencent.mm.plugin.location.model.j)localObject).uZI);
      localObject = new ArrayList(8);
      ((List)localObject).addAll(paramn);
      paramString.uZI = ((List)localObject);
    }
    AppMethodBeat.o(56178);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.j
 * JD-Core Version:    0.7.0.1
 */