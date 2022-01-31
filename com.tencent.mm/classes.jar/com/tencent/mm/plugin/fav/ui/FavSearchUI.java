package com.tencent.mm.plugin.fav.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.o;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.k;
import com.tencent.mm.plugin.fav.a.w;
import com.tencent.mm.plugin.fav.ui.gallery.g.a;
import com.tencent.mm.plugin.fav.ui.widget.FavCapacityPanel;
import com.tencent.mm.plugin.fav.ui.widget.FavSearchActionView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@a(3)
public class FavSearchUI
  extends MMActivity
{
  private String ckq;
  private int gbj;
  private ListView jTC;
  private long kRY;
  private ak mHandler;
  private l mvR;
  private com.tencent.mm.plugin.fav.ui.a.b mvS;
  private int mxc;
  private String mxd;
  private Set<Integer> mxe;
  private w mxf;
  private com.tencent.mm.plugin.fav.ui.a.c mxg;
  private FavSearchActionView mxh;
  private ListView mxi;
  private View mxj;
  private FavCapacityPanel mxk;
  private Animation mxl;
  private Animation mxm;
  private List<Integer> mxn;
  private List<String> mxo;
  private List<String> mxp;
  private Set<String> mxq;
  private View mxr;
  private ImageButton mxs;
  private MenuItem mxt;
  private List<Long> mxu;
  FavSearchUI.a mxv;
  private com.tencent.mm.plugin.fav.ui.gallery.c mxw;
  private String query;
  
  public FavSearchUI()
  {
    AppMethodBeat.i(74085);
    this.mxc = -1;
    this.mxq = new HashSet();
    this.mxu = new ArrayList();
    this.query = "";
    AppMethodBeat.o(74085);
  }
  
  private void T(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(74090);
    this.mxv.actionType = paramInt1;
    if (this.mvS != null) {
      this.mxv.kbN = this.mvS.kbN;
    }
    switch (this.gbj)
    {
    default: 
      this.mxv.scene = 0;
      this.mxv.position = paramInt2;
      this.mxv.mxG = ((int)(System.currentTimeMillis() - this.kRY) / 1000);
      this.mxv.query = this.query;
      this.mxv.msZ = paramInt3;
      if (this.mxn != null)
      {
        if (this.mxn.size() <= 0) {
          break label389;
        }
        switch (((Integer)this.mxn.get(0)).intValue())
        {
        case 4: 
        case 9: 
        case 10: 
        case 11: 
        case 12: 
        case 13: 
        case 14: 
        case 15: 
        case 16: 
        case 19: 
        case 20: 
        default: 
          this.mxv.mxH = 0;
        }
      }
      break;
    }
    for (;;)
    {
      this.mxv.IE();
      AppMethodBeat.o(74090);
      return;
      this.mxv.scene = 1;
      break;
      this.mxv.scene = 2;
      break;
      this.mxv.scene = 3;
      break;
      this.mxv.mxH = 1;
      continue;
      this.mxv.mxH = 2;
      continue;
      this.mxv.mxH = 3;
      continue;
      this.mxv.mxH = 4;
      continue;
      this.mxv.mxH = 5;
      continue;
      this.mxv.mxH = 6;
      continue;
      this.mxv.mxH = 7;
      continue;
      this.mxv.mxH = 8;
      continue;
      label389:
      this.mxv.mxH = 0;
    }
  }
  
  private boolean bxC()
  {
    return this.mxc == 21;
  }
  
  private void bxD()
  {
    AppMethodBeat.i(74089);
    if (this.mxh != null)
    {
      AppMethodBeat.o(74089);
      return;
    }
    this.mxh = ((FavSearchActionView)View.inflate(getContext(), 2130969557, null));
    this.mxr = this.mxh.findViewById(2131820992);
    this.mxr.setOnClickListener(new FavSearchUI.7(this));
    this.mxs = ((ImageButton)this.mxh.findViewById(2131824083));
    this.mxs.setVisibility(8);
    this.mxh.setOnSearchChangedListener(new FavSearchUI.8(this));
    AppMethodBeat.o(74089);
  }
  
  public int getLayoutId()
  {
    return 2130969558;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(74093);
    if (paramInt1 == 1)
    {
      if (paramInt2 != -1)
      {
        AppMethodBeat.o(74093);
        return;
      }
      Object localObject3 = this.mxw.mCg;
      Object localObject1 = paramIntent.getStringExtra("Select_Conv_User");
      if (bo.isNullOrNil((String)localObject1))
      {
        AppMethodBeat.o(74093);
        return;
      }
      Object localObject2 = bo.P(((String)localObject1).split(","));
      paramIntent = paramIntent.getStringExtra("custom_send_text");
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        Object localObject4 = (com.tencent.mm.plugin.fav.ui.gallery.d)((Iterator)localObject3).next();
        if (localObject4 == null)
        {
          ab.d("MicroMsg.FavSearchUI", "select %s, send item null, continute", new Object[] { localObject1 });
        }
        else
        {
          new k();
          if (k.u(((com.tencent.mm.plugin.fav.ui.gallery.d)localObject4).mCk))
          {
            com.tencent.mm.ui.base.h.bO(getContext(), getString(2131296330));
            AppMethodBeat.o(74093);
            return;
          }
          ab.d("MicroMsg.FavSearchUI", "select %s for sending", new Object[] { localObject1 });
          Object localObject5;
          Object localObject6;
          if ((((com.tencent.mm.plugin.fav.ui.gallery.d)localObject4).byj()) || (((com.tencent.mm.plugin.fav.ui.gallery.d)localObject4).byk()))
          {
            localObject5 = new FavSearchUI.3(this, com.tencent.mm.ui.base.h.b(getContext(), getString(2131299734), false, null));
            localObject6 = ((List)localObject2).iterator();
            while (((Iterator)localObject6).hasNext()) {
              i.a(this, (String)((Iterator)localObject6).next(), ((com.tencent.mm.plugin.fav.ui.gallery.d)localObject4).cuZ, (Runnable)localObject5);
            }
          }
          else
          {
            localObject5 = new ArrayList();
            ((ArrayList)localObject5).add(com.tencent.mm.plugin.fav.a.b.b(((com.tencent.mm.plugin.fav.ui.gallery.d)localObject4).cuZ));
            localObject4 = ((List)localObject2).iterator();
            while (((Iterator)localObject4).hasNext())
            {
              localObject6 = (String)((Iterator)localObject4).next();
              o.ahA().a(r.Zn(), (String)localObject6, (ArrayList)localObject5, 0, false);
            }
          }
        }
      }
      if (!bo.isNullOrNil(paramIntent))
      {
        localObject1 = ((List)localObject2).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          com.tencent.mm.plugin.messenger.a.g.bPJ().K((String)localObject2, paramIntent, t.oF((String)localObject2));
        }
      }
    }
    AppMethodBeat.o(74093);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74086);
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle = TransitionInflater.from(this).inflateTransition(17760258);
      paramBundle.excludeTarget(getWindow().getDecorView().findViewById(2131820956), true);
      paramBundle.excludeTarget(16908335, true);
      getWindow().setEnterTransition(paramBundle);
    }
    this.mHandler = new ak();
    setMMTitle("");
    setActionbarColor(getContext().getResources().getColor(2131690316));
    this.gbj = getIntent().getIntExtra("key_search_type", 0);
    if (1 == this.gbj)
    {
      this.ckq = getIntent().getStringExtra("key_to_user");
      this.mxd = getIntent().getStringExtra("key_fav_item_id");
    }
    this.mxc = getIntent().getIntExtra("key_preset_search_type", -1);
    this.mxi = ((ListView)findViewById(2131824084));
    this.jTC = ((ListView)findViewById(2131824085));
    this.mxj = findViewById(2131824087);
    this.mxl = AnimationUtils.loadAnimation(getContext(), 2131034215);
    this.mxm = AnimationUtils.loadAnimation(getContext(), 2131034216);
    this.mxw = new com.tencent.mm.plugin.fav.ui.gallery.c(this, findViewById(2131824086));
    bxD();
    this.mxk = ((FavCapacityPanel)View.inflate(getContext(), 2130969524, null));
    this.mxk.mDM = getIntent().getIntExtra("key_enter_fav_search_from", 0);
    this.mxg = new FavSearchUI.9(this, getContext());
    if (((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavTagSetMgr().bww() > 0)
    {
      paramBundle = (TextView)View.inflate(getContext(), 2130969562, null);
      this.mxi.addHeaderView(paramBundle);
    }
    this.mxi.addFooterView(this.mxk);
    this.mxi.setAdapter(this.mxg);
    this.mxi.setOnTouchListener(new FavSearchUI.10(this));
    this.mvR = new l(getContext(), 16);
    getContext();
    this.mvS = new com.tencent.mm.plugin.fav.ui.a.b(this.mvR, false);
    this.mvS.scene = 2;
    this.mvS.mzz = this.jTC;
    if (1 == this.gbj)
    {
      this.mxe = new HashSet();
      this.mxf = new k();
      if (!bo.isNullOrNil(this.mxd))
      {
        paramBundle = this.mxd.split(",");
        int j = paramBundle.length;
        int i = 0;
        while (i < j)
        {
          int k = bo.getInt(paramBundle[i], 2147483647);
          if (2147483647 != k) {
            this.mxe.add(Integer.valueOf(k));
          }
          i += 1;
        }
      }
      this.mvS.e(this.mxe);
      this.mvS.a(this.mxf);
    }
    this.jTC.setAdapter(this.mvS);
    this.jTC.setOnItemClickListener(new FavSearchUI.11(this));
    this.jTC.setOnTouchListener(new FavSearchUI.2(this));
    ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavTagSetMgr().a(this.mxg);
    com.tencent.mm.kernel.g.RO().o(new FavSearchUI.1(this), 1000L);
    this.mxv = new FavSearchUI.a();
    this.kRY = System.currentTimeMillis();
    if (bxC())
    {
      this.mxh.U(this.mxc, false);
      this.jTC.setVisibility(8);
      this.mxi.setVisibility(8);
      this.mxw.setVisibility(0);
      paramBundle = this.mxw;
      paramBundle.mBW.v(true, paramBundle.mBZ);
      AppMethodBeat.o(74086);
      return;
    }
    if (this.mxc > 0)
    {
      this.mxh.U(this.mxc, true);
      this.mxw.setVisibility(8);
      this.jTC.setVisibility(0);
    }
    AppMethodBeat.o(74086);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(74088);
    ab.d("MicroMsg.FavSearchUI", "on create options menu");
    bxD();
    this.mxt = paramMenu.add(0, 2131820646, 0, 2131296919);
    this.mxt.setActionView(this.mxh);
    this.mxt.setShowAsAction(9);
    this.mxh.post(new FavSearchUI.4(this));
    android.support.v4.view.h.a(this.mxt, new FavSearchUI.5(this));
    this.mHandler.post(new FavSearchUI.6(this));
    AppMethodBeat.o(74088);
    return true;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74087);
    if (!this.mxv.mxI)
    {
      if ((!this.mvS.isEmpty()) && (this.jTC.getVisibility() == 0)) {
        break label134;
      }
      T(1, 0, 0);
    }
    for (;;)
    {
      this.mxw.mBW.onDetach();
      super.onDestroy();
      this.mvR.destory();
      this.mvR = null;
      ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavTagSetMgr().a(this.mxg);
      ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavTagSetMgr().d(this.mxq);
      if (this.mvS != null) {
        this.mvS.finish();
      }
      AppMethodBeat.o(74087);
      return;
      label134:
      T(2, 0, 0);
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(74092);
    com.tencent.mm.plugin.fav.a.i.NJ(getClass().getSimpleName());
    com.tencent.mm.plugin.fav.ui.gallery.c localc;
    if (bxC())
    {
      localc = this.mxw;
      WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcMediaGalleryScrollEnable, localc.eez);
      localc.eez = 0;
      if ((com.tencent.matrix.b.isInstalled()) && (com.tencent.matrix.b.yD().z(com.tencent.matrix.trace.b.class) != null))
      {
        com.tencent.matrix.trace.f.c localc1 = ((com.tencent.matrix.trace.b)com.tencent.matrix.b.yD().z(com.tencent.matrix.trace.b.class)).bQQ;
        if (localc1 != null) {
          localc1.b(localc.mCa);
        }
      }
      if (bo.aox() <= localc.fAA) {
        break label157;
      }
    }
    label157:
    for (long l = bo.aox() - localc.fAA;; l = 1L)
    {
      localc.fAA = l;
      WXHardCoderJNI.reportFPS(703, WXHardCoderJNI.hcMediaGalleryScrollAction, 1, localc.eCX, localc.fAA);
      localc.eCX = 0L;
      localc.fAA = 0L;
      super.onPause();
      AppMethodBeat.o(74092);
      return;
    }
  }
  
  public void onResume()
  {
    long l = 0L;
    AppMethodBeat.i(74091);
    this.mvS.bxP();
    this.mvS.notifyDataSetChanged();
    Object localObject1 = this.mxk;
    Object localObject2;
    if (((FavCapacityPanel)localObject1).mDK != com.tencent.mm.plugin.fav.a.b.bvZ() / 1048576L)
    {
      ((FavCapacityPanel)localObject1).mDK = (com.tencent.mm.plugin.fav.a.b.bvZ() / 1048576L);
      localObject2 = ((FavCapacityPanel)localObject1).mDL;
      Context localContext = ((FavCapacityPanel)localObject1).mDL.getContext();
      if (((FavCapacityPanel)localObject1).mDN - ((FavCapacityPanel)localObject1).mDK > 0L) {
        l = ((FavCapacityPanel)localObject1).mDN - ((FavCapacityPanel)localObject1).mDK;
      }
      ((TextView)localObject2).setText(localContext.getString(2131299661, new Object[] { Long.valueOf(l), Long.valueOf(((FavCapacityPanel)localObject1).mDK) }));
    }
    com.tencent.mm.plugin.fav.a.i.NI(getClass().getSimpleName());
    if (bxC())
    {
      localObject1 = this.mxw;
      ((com.tencent.mm.plugin.fav.ui.gallery.c)localObject1).fAA = bo.aox();
      if ((com.tencent.matrix.b.isInstalled()) && (com.tencent.matrix.b.yD().z(com.tencent.matrix.trace.b.class) != null))
      {
        localObject2 = ((com.tencent.matrix.trace.b)com.tencent.matrix.b.yD().z(com.tencent.matrix.trace.b.class)).bQQ;
        if (localObject2 != null) {
          ((com.tencent.matrix.trace.f.c)localObject2).a(((com.tencent.mm.plugin.fav.ui.gallery.c)localObject1).mCa);
        }
      }
      ((com.tencent.mm.plugin.fav.ui.gallery.c)localObject1).mBW.onResume();
      if (((com.tencent.mm.plugin.fav.ui.gallery.c)localObject1).mBY)
      {
        if (!((com.tencent.mm.plugin.fav.ui.gallery.c)localObject1).mBW.byp()) {
          break label252;
        }
        ((com.tencent.mm.plugin.fav.ui.gallery.c)localObject1).byh();
      }
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.fav.ui.gallery.c)localObject1).mBY = false;
      super.onResume();
      AppMethodBeat.o(74091);
      return;
      label252:
      ((com.tencent.mm.plugin.fav.ui.gallery.c)localObject1).byi();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavSearchUI
 * JD-Core Version:    0.7.0.1
 */