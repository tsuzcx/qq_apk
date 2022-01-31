package com.tencent.mm.plugin.fav.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.f;
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
import com.tencent.mm.as.o;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.k;
import com.tencent.mm.plugin.fav.a.w;
import com.tencent.mm.plugin.fav.ui.gallery.g.a;
import com.tencent.mm.plugin.fav.ui.widget.FavCapacityPanel;
import com.tencent.mm.plugin.fav.ui.widget.FavSearchActionView;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@com.tencent.mm.ui.base.a(3)
public class FavSearchUI
  extends MMActivity
{
  private String bDB;
  private String bVk = "";
  private int eLC;
  private long iLr;
  private ListView icN;
  private l kbv;
  private com.tencent.mm.plugin.fav.ui.a.b kbw;
  private Animation kcA;
  private Animation kcB;
  private List<Integer> kcC;
  private List<String> kcD;
  private List<String> kcE;
  private Set<String> kcF = new HashSet();
  private View kcG;
  private ImageButton kcH;
  private MenuItem kcI;
  private List<Long> kcJ = new ArrayList();
  FavSearchUI.a kcK;
  private com.tencent.mm.plugin.fav.ui.gallery.c kcL;
  private int kcr = -1;
  private String kcs;
  private Set<Integer> kct;
  private w kcu;
  private com.tencent.mm.plugin.fav.ui.a.c kcv;
  private FavSearchActionView kcw;
  private ListView kcx;
  private View kcy;
  private FavCapacityPanel kcz;
  private ah mHandler;
  
  private void H(int paramInt1, int paramInt2, int paramInt3)
  {
    this.kcK.actionType = paramInt1;
    if (this.kbw != null) {
      this.kcK.jYS = this.kbw.jYS;
    }
    switch (this.eLC)
    {
    default: 
      this.kcK.scene = 0;
      this.kcK.position = paramInt2;
      this.kcK.kcV = ((int)(System.currentTimeMillis() - this.iLr) / 1000);
      this.kcK.bVk = this.bVk;
      this.kcK.jYG = paramInt3;
      if (this.kcC != null)
      {
        if (this.kcC.size() <= 0) {
          break label480;
        }
        switch (((Integer)this.kcC.get(0)).intValue())
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
          this.kcK.kcW = 0;
        }
      }
      break;
    }
    for (;;)
    {
      FavSearchUI.a locala = this.kcK;
      com.tencent.mm.plugin.report.service.h.nFQ.f(15488, new Object[] { Integer.valueOf(locala.actionType), Integer.valueOf(locala.jYS), Integer.valueOf(locala.scene), Integer.valueOf(locala.position), Integer.valueOf(locala.kcV), locala.bVk, Long.valueOf(locala.jYG), Integer.valueOf(locala.kcW) });
      return;
      this.kcK.scene = 1;
      break;
      this.kcK.scene = 2;
      break;
      this.kcK.scene = 3;
      break;
      this.kcK.kcW = 1;
      continue;
      this.kcK.kcW = 2;
      continue;
      this.kcK.kcW = 3;
      continue;
      this.kcK.kcW = 4;
      continue;
      this.kcK.kcW = 5;
      continue;
      this.kcK.kcW = 6;
      continue;
      this.kcK.kcW = 7;
      continue;
      this.kcK.kcW = 8;
      continue;
      label480:
      this.kcK.kcW = 0;
    }
  }
  
  private boolean aRn()
  {
    return this.kcr == 21;
  }
  
  private void aRo()
  {
    if (this.kcw != null) {
      return;
    }
    this.kcw = ((FavSearchActionView)View.inflate(this.mController.uMN, n.f.fav_search_actionview, null));
    this.kcG = this.kcw.findViewById(n.e.ab_back_container);
    this.kcG.setOnClickListener(new FavSearchUI.7(this));
    this.kcH = ((ImageButton)this.kcw.findViewById(n.e.search_clear_button));
    this.kcH.setVisibility(8);
    this.kcw.setOnSearchChangedListener(new FavSearchUI.8(this));
  }
  
  protected final int getLayoutId()
  {
    return n.f.fav_search_ui;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 != 1) || (paramInt2 != -1)) {}
    String str;
    do
    {
      do
      {
        return;
        localObject1 = this.kcL.khv;
        str = paramIntent.getStringExtra("Select_Conv_User");
      } while (bk.bl(str));
      paramIntent = paramIntent.getStringExtra("custom_send_text");
      Object localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        com.tencent.mm.plugin.fav.ui.gallery.d locald = (com.tencent.mm.plugin.fav.ui.gallery.d)((Iterator)localObject1).next();
        if (locald == null)
        {
          y.d("MicroMsg.FavSearchUI", "select %s, send item null, continute", new Object[] { str });
        }
        else
        {
          new k();
          if (k.u(locald.khA))
          {
            com.tencent.mm.ui.base.h.bC(this.mController.uMN, getString(n.i.Fav_NotDownload_CannotForward));
            return;
          }
          y.d("MicroMsg.FavSearchUI", "select %s for sending", new Object[] { str });
          Object localObject2;
          if ((locald.aRQ()) || (locald.aRR()))
          {
            localObject2 = new FavSearchUI.3(this, com.tencent.mm.ui.base.h.b(this.mController.uMN, getString(n.i.favorite_forward_tips), false, null));
            i.a(this, str, locald.bNH, (Runnable)localObject2);
          }
          else
          {
            localObject2 = new ArrayList();
            ((ArrayList)localObject2).add(com.tencent.mm.plugin.fav.a.b.b(locald.bNH));
            o.OH().a(q.Gj(), str, (ArrayList)localObject2, 0, false, n.d.chat_img_template);
          }
        }
      }
    } while (bk.bl(paramIntent));
    com.tencent.mm.plugin.messenger.a.g.bhI().D(str, paramIntent, com.tencent.mm.model.s.hW(str));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle = TransitionInflater.from(this).inflateTransition(17760258);
      paramBundle.excludeTarget(getWindow().getDecorView().findViewById(n.e.action_bar_container), true);
      paramBundle.excludeTarget(16908335, true);
      getWindow().setEnterTransition(paramBundle);
    }
    this.mHandler = new ah();
    setMMTitle("");
    ta(this.mController.uMN.getResources().getColor(n.b.normal_actionbar_color));
    czo();
    this.eLC = getIntent().getIntExtra("key_search_type", 0);
    if (1 == this.eLC)
    {
      this.bDB = getIntent().getStringExtra("key_to_user");
      this.kcs = getIntent().getStringExtra("key_fav_item_id");
    }
    this.kcr = getIntent().getIntExtra("key_preset_search_type", -1);
    this.kcx = ((ListView)findViewById(n.e.tag_panel_list));
    this.icN = ((ListView)findViewById(n.e.search_result_list));
    this.kcy = findViewById(n.e.search_empty_tv);
    this.kcA = AnimationUtils.loadAnimation(this.mController.uMN, n.a.panel_fade_in);
    this.kcB = AnimationUtils.loadAnimation(this.mController.uMN, n.a.panel_fade_out);
    this.kcL = new com.tencent.mm.plugin.fav.ui.gallery.c(this, findViewById(n.e.fav_media_history_gallery));
    aRo();
    this.kcz = ((FavCapacityPanel)View.inflate(this.mController.uMN, n.f.fav_capacity_foot_panel, null));
    this.kcz.kjg = getIntent().getIntExtra("key_enter_fav_search_from", 0);
    this.kcv = new FavSearchUI.9(this, this.mController.uMN);
    if (((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavTagSetMgr().aQh() > 0)
    {
      paramBundle = (TextView)View.inflate(this.mController.uMN, n.f.fav_tag_panel_headerview, null);
      this.kcx.addHeaderView(paramBundle);
    }
    this.kcx.addFooterView(this.kcz);
    this.kcx.setAdapter(this.kcv);
    this.kcx.setOnTouchListener(new FavSearchUI.10(this));
    this.kbv = new l(this.mController.uMN, 16);
    paramBundle = this.mController.uMN;
    this.kbw = new com.tencent.mm.plugin.fav.ui.a.b(this.kbv, false);
    this.kbw.scene = 2;
    this.kbw.keQ = this.icN;
    if (1 == this.eLC)
    {
      this.kct = new HashSet();
      this.kcu = new k();
      if (!bk.bl(this.kcs))
      {
        paramBundle = this.kcs.split(",");
        int j = paramBundle.length;
        int i = 0;
        while (i < j)
        {
          int k = bk.getInt(paramBundle[i], 2147483647);
          if (2147483647 != k) {
            this.kct.add(Integer.valueOf(k));
          }
          i += 1;
        }
      }
      this.kbw.f(this.kct);
      this.kbw.a(this.kcu);
    }
    this.icN.setAdapter(this.kbw);
    this.icN.setOnItemClickListener(new FavSearchUI.11(this));
    this.icN.setOnTouchListener(new FavSearchUI.2(this));
    ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavTagSetMgr().a(this.kcv);
    com.tencent.mm.kernel.g.DS().k(new FavSearchUI.1(this), 1000L);
    this.kcK = new FavSearchUI.a();
    this.iLr = System.currentTimeMillis();
    if (aRn())
    {
      this.kcw.M(this.kcr, false);
      this.icN.setVisibility(8);
      this.kcx.setVisibility(8);
      this.kcL.setVisibility(0);
      paramBundle = this.kcL;
      paramBundle.khh.l(true, paramBundle.khl);
    }
    while (this.kcr <= 0) {
      return;
    }
    this.kcw.M(this.kcr, true);
    this.kcL.setVisibility(8);
    this.icN.setVisibility(0);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    y.d("MicroMsg.FavSearchUI", "on create options menu");
    aRo();
    this.kcI = paramMenu.add(0, n.e.menu_search, 0, n.i.app_empty_string);
    f.a(this.kcI, this.kcw);
    f.a(this.kcI, 9);
    this.kcw.post(new FavSearchUI.4(this));
    f.a(this.kcI, new FavSearchUI.5(this));
    this.mHandler.post(new FavSearchUI.6(this));
    return true;
  }
  
  protected void onDestroy()
  {
    if (!this.kcK.kcX)
    {
      if ((!this.kbw.isEmpty()) && (this.icN.getVisibility() == 0)) {
        break label122;
      }
      H(1, 0, 0);
    }
    for (;;)
    {
      this.kcL.khh.onDetach();
      super.onDestroy();
      this.kbv.destory();
      this.kbv = null;
      ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavTagSetMgr().a(this.kcv);
      ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavTagSetMgr().e(this.kcF);
      if (this.kbw != null) {
        this.kbw.finish();
      }
      return;
      label122:
      H(2, 0, 0);
    }
  }
  
  protected void onPause()
  {
    com.tencent.mm.plugin.fav.a.i.CH(getClass().getSimpleName());
    com.tencent.mm.plugin.fav.ui.gallery.c localc;
    if (aRn())
    {
      localc = this.kcL;
      WXHardCoderJNI.stopPerformace(WXHardCoderJNI.hcMediaGalleryScrollEnable, localc.dmY);
      localc.dmY = 0;
      ((com.tencent.matrix.trace.a)com.tencent.matrix.a.qO().l(com.tencent.matrix.trace.a.class)).bqu.b(localc.kho);
      if (bk.UX() <= localc.ekk) {
        break label118;
      }
    }
    label118:
    for (long l = bk.UX() - localc.ekk;; l = 1L)
    {
      localc.ekk = l;
      WXHardCoderJNI.reportFPS(703, WXHardCoderJNI.hcMediaGalleryScrollAction, 1, localc.dFe, localc.ekk);
      localc.dFe = 0L;
      localc.ekk = 0L;
      super.onPause();
      return;
    }
  }
  
  protected void onResume()
  {
    long l = 0L;
    this.kbw.aRA();
    this.kbw.notifyDataSetChanged();
    Object localObject = this.kcz;
    if (((FavCapacityPanel)localObject).kje != com.tencent.mm.plugin.fav.a.b.aPL() / 1048576L)
    {
      ((FavCapacityPanel)localObject).kje = (com.tencent.mm.plugin.fav.a.b.aPL() / 1048576L);
      TextView localTextView = ((FavCapacityPanel)localObject).kjf;
      Context localContext = ((FavCapacityPanel)localObject).kjf.getContext();
      int i = n.i.fav_capacity_info;
      if (((FavCapacityPanel)localObject).kjh - ((FavCapacityPanel)localObject).kje > 0L) {
        l = ((FavCapacityPanel)localObject).kjh - ((FavCapacityPanel)localObject).kje;
      }
      localTextView.setText(localContext.getString(i, new Object[] { Long.valueOf(l), Long.valueOf(((FavCapacityPanel)localObject).kje) }));
    }
    com.tencent.mm.plugin.fav.a.i.CG(getClass().getSimpleName());
    if (aRn())
    {
      localObject = this.kcL;
      ((com.tencent.mm.plugin.fav.ui.gallery.c)localObject).ekk = bk.UX();
      ((com.tencent.matrix.trace.a)com.tencent.matrix.a.qO().l(com.tencent.matrix.trace.a.class)).bqu.a(((com.tencent.mm.plugin.fav.ui.gallery.c)localObject).kho);
      ((com.tencent.mm.plugin.fav.ui.gallery.c)localObject).khh.onResume();
      if (((com.tencent.mm.plugin.fav.ui.gallery.c)localObject).khk)
      {
        if (!((com.tencent.mm.plugin.fav.ui.gallery.c)localObject).khh.aRY()) {
          break label233;
        }
        ((com.tencent.mm.plugin.fav.ui.gallery.c)localObject).aRO();
      }
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.fav.ui.gallery.c)localObject).khk = false;
      super.onResume();
      return;
      label233:
      ((com.tencent.mm.plugin.fav.ui.gallery.c)localObject).aRP();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavSearchUI
 * JD-Core Version:    0.7.0.1
 */