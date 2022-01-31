package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.cb.a;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.plugin.location.ui.PoiHeaderView;
import com.tencent.mm.plugin.location.ui.SimpleImageView;
import com.tencent.mm.plugin.location.ui.SimpleImageView.a;
import com.tencent.mm.plugin.map.a.b;
import com.tencent.mm.plugin.map.a.c;
import com.tencent.mm.plugin.map.a.d;
import com.tencent.mm.plugin.map.a.e;
import com.tencent.mm.plugin.map.a.f;
import com.tencent.mm.plugin.map.a.h;
import com.tencent.mm.plugin.p.d;
import com.tencent.mm.protocal.c.aih;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.an;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import com.tencent.mm.ui.base.MMLoadMoreListView.a;
import com.tencent.mm.ui.tools.ActionBarSearchView;
import java.util.Iterator;
import java.util.List;

public final class c
  extends b
  implements com.tencent.mm.ah.f
{
  private static int lJh = 11;
  private static int lJi = 12;
  private static int lJj = 13;
  private static int lJk = 14;
  private a.a dig = new c.9(this);
  private String ewH = "";
  private ImageView kjC;
  private String lCY = "";
  private int lCZ = 1;
  private View lIA;
  private e lIB;
  private e lIC;
  private View lID;
  private ImageButton lIE;
  private com.tencent.mm.plugin.location.model.h lIF = null;
  private f lIG = null;
  private View lIH;
  private ImageButton lII;
  ActionBarSearchView lIJ;
  private TextView lIK;
  private LinearLayout lIL;
  private com.tencent.mm.plugin.location.ui.e lIM;
  private com.tencent.mm.plugin.location.ui.g lIN;
  private double lIO = -85.0D;
  private double lIP = -1000.0D;
  private boolean lIQ = false;
  private int lIR = 0;
  private RelativeLayout lIS;
  private int lIT;
  private int lIU;
  private int lIV;
  private boolean lIW = true;
  private boolean lIX = false;
  private boolean lIY = false;
  private FrameLayout lIZ;
  FrameLayout lIn;
  protected PoiHeaderView lIw;
  private PickPoi lIx;
  private MMLoadMoreListView lIy;
  private MMLoadMoreListView lIz;
  private float lJa;
  private float lJb;
  private int lJc = 0;
  private long lJd = -1L;
  private long lJe = -1L;
  private long lJf = -1L;
  private int lJg = -1;
  private boolean lJl = false;
  private boolean lJm;
  private double lat = -85.0D;
  private double lng = -1000.0D;
  private TextView titleView;
  
  public c(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  private void a(f paramf)
  {
    if (this.lJm) {
      ta(ae.getResources().getColor(a.b.dark_actionbar_color));
    }
    for (;;)
    {
      this.ewH = "";
      this.lIQ = false;
      this.lIA.setVisibility(8);
      this.lIz.setVisibility(8);
      this.lIJ.setVisibility(8);
      this.lIJ.setSearchContent("");
      this.lIK.setVisibility(8);
      this.lIy.setVisibility(0);
      this.lIy.setAdapter(this.lIB);
      this.lIB.notifyDataSetChanged();
      this.lIL.setVisibility(0);
      XM();
      if (paramf != null)
      {
        this.lFy.getIController().setCenter(paramf.aWE, paramf.aWF);
        this.lat = paramf.aWE;
        this.lng = paramf.aWF;
        paramf = this.lIx;
        paramf.j(this.lat, this.lng);
        paramf.lJv = false;
        gw(false);
      }
      return;
      ta(ae.getResources().getColor(a.b.normal_actionbar_color));
    }
  }
  
  private void gw(boolean paramBoolean)
  {
    if (this.lIN != null) {
      this.lIN.remove();
    }
    double d1 = this.lat;
    Object localObject = this.ewH;
    this.lCY = ((int)(d1 * 1000000.0D) + "_" + (int)(this.lng * 1000000.0D) + "_" + (String)localObject);
    if (this.lCY.equals(this.lIB.key))
    {
      y.i("MicroMsg.MMPoiMapUI", "same key passed it ", new Object[] { this.lCY });
      return;
    }
    localObject = null;
    int j = 1;
    int i;
    label206:
    label221:
    double d2;
    if (this.lIQ) {
      if ((this.lCZ > 0) && (paramBoolean))
      {
        this.lIz.cAP();
        localObject = this.lIC;
        ((e)localObject).buffer = null;
        ((e)localObject).inQ = false;
        ((e)localObject).key = "";
        this.lIC.GI(this.lCY);
        this.lIC.iSX = this.ewH;
        localObject = this.lIC.buffer;
        i = j;
        if (i == 0) {
          break label504;
        }
        if (this.lIR != 0) {
          break label492;
        }
        i = 0;
        d1 = this.lat;
        d2 = this.lng;
        if (!this.lIQ) {
          break label498;
        }
      }
    }
    label492:
    label498:
    for (j = 0;; j = 1)
    {
      this.lIF = new com.tencent.mm.plugin.location.model.h((byte[])localObject, d1, d2, i, j, this.lJb, this.lJa, this.lCY, this.ewH, paramBoolean);
      com.tencent.mm.kernel.g.Dk().a(this.lIF, 0);
      this.lJc += 1;
      if (this.lJf != -1L) {
        break;
      }
      this.lJf = System.currentTimeMillis();
      return;
      if (!paramBoolean)
      {
        this.lIz.cAP();
        this.lIC.clean();
        this.lIC.GI(this.lCY);
        this.lIC.iSX = this.ewH;
        localObject = this.lIC.buffer;
        this.lIC.notifyDataSetChanged();
        i = j;
        break label206;
      }
      i = 0;
      break label206;
      this.lIy.cAP();
      this.lIB.clean();
      this.lIB.GI(this.lCY);
      this.lIB.notifyDataSetChanged();
      byte[] arrayOfByte = this.lIB.buffer;
      this.lID.setVisibility(0);
      hm(false);
      i = j;
      localObject = arrayOfByte;
      if (!this.lIx.lJv) {
        break label206;
      }
      localObject = this.lIx.getPoi();
      this.lIB.b((f)localObject);
      i = j;
      localObject = arrayOfByte;
      break label206;
      i = 1;
      break label221;
    }
    label504:
    y.i("MicroMsg.MMPoiMapUI", "pass this query because query interval: %d", new Object[] { Integer.valueOf(this.lCZ) });
  }
  
  private void hl(boolean paramBoolean)
  {
    this.lIW = false;
    c.a locala2;
    if (paramBoolean) {
      locala2 = new c.a(this, -(beO() - this.lIU));
    }
    for (c.a locala1 = new c.a(this, -(beO() - this.lIU) / 2);; locala1 = new c.a(this, (this.lIT - beO()) / 2))
    {
      c.15 local15 = new c.15(this, paramBoolean);
      locala2.setDuration(200L);
      locala2 = locala2.beT();
      locala2.setAnimationListener(local15);
      locala2.cF(this.lIS).cF(this.lIE).beU();
      locala1.setDuration(200L);
      locala1.beT().cF(this.lIZ).beU();
      return;
      locala2 = new c.a(this, this.lIT - beO());
    }
  }
  
  private void hm(boolean paramBoolean)
  {
    y.d("MicroMsg.MMPoiMapUI", "enable send.. %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.lIH.setEnabled(paramBoolean);
    findViewById(a.e.action_option_text).setEnabled(paramBoolean);
    this.lII.setEnabled(paramBoolean);
  }
  
  private void j(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    String str3;
    String str1;
    String str2;
    if ((this.lIO == -85.0D) || (this.lIP == -1000.0D))
    {
      str3 = "null/null";
      str1 = "";
      if (paramBoolean) {
        break label564;
      }
      if (this.lIB.lJz >= this.lIB.getCount()) {
        break label633;
      }
      str1 = this.lIB.tc(this.lIB.lJz).lJP;
      str2 = this.lIB.tc(this.lIB.lJz).lJF;
    }
    for (;;)
    {
      label90:
      String str4 = str1;
      if (paramInt2 == 0)
      {
        str4 = str1;
        if (bk.bl(str1))
        {
          str4 = str1;
          if (this.lIB.getCount() > 1)
          {
            y.d("MicroMsg.MMPoiMapUI", "set searchid in first poi");
            str4 = this.lIB.tc(1).lJP;
          }
        }
      }
      if ((this.lIB.getCount() > 0) && (!paramBoolean)) {
        y.d("MicroMsg.MMPoiMapUI", "set request id at index: %s", new Object[] { Integer.valueOf(paramInt2) });
      }
      for (str1 = this.lIB.tc(0).lJQ;; str1 = "")
      {
        int i = paramInt2;
        if (paramInt2 == 0)
        {
          i = paramInt2;
          if (!paramBoolean)
          {
            i = paramInt2;
            if (this.lIB.getCount() > 0)
            {
              int j = this.lIB.tc(0).lJR;
              i = paramInt2;
              if (j >= 0)
              {
                y.d("MicroMsg.MMPoiMapUI", "change to search index: %s", new Object[] { Integer.valueOf(j) });
                i = j;
              }
            }
          }
        }
        y.d("MicroMsg.MMPoiMapUI", "tofutest type:%d, index: %d, startTime: %s, lastTime: %s, firsSuccTime: %s, poiCount: %s, latlng: %s, entryTime: %s, searchId: %s, requestId: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(i + 1), Long.valueOf(this.lJf), Long.valueOf(this.lJe), Long.valueOf(this.lJd), Integer.valueOf(this.lJc), str3, Integer.valueOf(this.lJg), str4, str1 });
        com.tencent.mm.plugin.report.service.h.nFQ.f(11135, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(i + 1), Long.valueOf(this.lJf), Long.valueOf(this.lJe), Long.valueOf(System.currentTimeMillis()), Long.valueOf(this.lJd), Integer.valueOf(this.lJc), str3, str2, Integer.valueOf(this.lJg), str4, q.zf(), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), str1 });
        return;
        str3 = String.format("%f/%f", new Object[] { Double.valueOf(this.lIO), Double.valueOf(this.lIP) });
        break;
        label564:
        if ((paramInt2 < 0) || (this.lIC.lJz >= this.lIC.getCount())) {
          break label633;
        }
        str1 = this.lIC.tc(this.lIC.lJz).lJP;
        str2 = this.lIC.tc(this.lIC.lJz).lJF;
        break label90;
      }
      label633:
      str2 = "";
    }
  }
  
  private void ta(int paramInt)
  {
    this.lIL.setBackgroundColor(paramInt);
    this.lIJ.setBackgroundColor(paramInt);
    Boolean localBoolean = Boolean.valueOf(an.Gf(paramInt));
    if (localBoolean.booleanValue())
    {
      this.kjC.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
      this.lII.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
      this.titleView.setTextColor(ae.getResources().getColor(a.b.white_text_color));
    }
    Object localObject;
    if (Build.VERSION.SDK_INT >= 21)
    {
      localObject = this.activity.getWindow();
      ((Window)localObject).clearFlags(201326592);
      ((Window)localObject).addFlags(-2147483648);
      if ((Build.VERSION.SDK_INT < 23) || (com.tencent.mm.compatible.util.h.zL())) {
        break label173;
      }
    }
    for (;;)
    {
      this.activity.getWindow().setStatusBarColor(paramInt);
      if (Build.VERSION.SDK_INT >= 23)
      {
        localObject = this.activity.getWindow().getDecorView();
        paramInt = ((View)localObject).getSystemUiVisibility();
        if (!localBoolean.booleanValue()) {
          break label202;
        }
        paramInt &= 0xFFFFDFFF;
      }
      for (;;)
      {
        ((View)localObject).setSystemUiVisibility(paramInt);
        return;
        label173:
        if (Build.VERSION.SDK_INT < 21) {
          break label211;
        }
        paramInt = an.n(this.activity.getResources().getColor(a.b.statusbar_fg_drak_color), paramInt);
        break;
        label202:
        paramInt |= 0x2000;
      }
      label211:
      paramInt = 0;
    }
  }
  
  public final d beM()
  {
    return (d)this.activity.findViewById(a.e.g_mapView);
  }
  
  public final void beN()
  {
    PickPoi localPickPoi = this.lIx;
    localPickPoi.lEI.clearAnimation();
    localPickPoi.lEI.startAnimation(localPickPoi.wb);
    this.lat = (this.lFy.getMapCenterX() / 1000000.0D);
    this.lng = (this.lFy.getMapCenterY() / 1000000.0D);
    this.lIx.j(this.lat, this.lng);
    this.lIE.setBackgroundResource(a.d.location_my);
    if (this.lIY) {
      hl(false);
    }
    gw(false);
    this.lJl = false;
    this.lIB.lJl = false;
  }
  
  public final int beO()
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.lIS.getLayoutParams();
    this.lIV = localMarginLayoutParams.topMargin;
    return localMarginLayoutParams.topMargin;
  }
  
  public final boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      y.d("MicroMsg.MMPoiMapUI", "dispatchKeyEvent");
      if (this.lIQ)
      {
        a(null);
        j(lJk, this.lIC.lJz, true);
      }
    }
    else
    {
      return false;
    }
    j(lJi, this.lIB.lJz, false);
    this.activity.finish();
    return true;
  }
  
  public final int getLayoutId()
  {
    return a.f.poi_gmap_ui;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.Dk().a(457, this);
    this.lJg = ((int)(System.currentTimeMillis() / 1000L));
    this.lIL = ((LinearLayout)findViewById(a.e.header_bar));
    this.titleView = ((TextView)findViewById(a.e.mm_action_bar_mmtitle));
    this.titleView.setText(getString(a.h.location_send_location));
    this.lIS = ((RelativeLayout)findViewById(a.e.location_list_rl));
    this.lIy = ((MMLoadMoreListView)this.activity.findViewById(a.e.poi_list));
    this.lIz = ((MMLoadMoreListView)this.activity.findViewById(a.e.search_list));
    this.lIA = this.activity.findViewById(a.e.search_prg);
    this.lIK = ((TextView)findViewById(a.e.search_empty));
    this.lIE = ((ImageButton)findViewById(a.e.locate_to_my_position));
    this.lIE.setContentDescription(getString(a.h.locate_to_my_pos));
    this.lIw = ((PoiHeaderView)findViewById(a.e.poi_header));
    this.lFy.setBuiltInZoomControls(false);
    this.lIn = ((FrameLayout)findViewById(a.e.control_id));
    this.lIM = new com.tencent.mm.plugin.location.ui.e(this.activity, a.d.poi_mylocation_icon, this.lFy);
    this.lIN = new com.tencent.mm.plugin.location.ui.g(this.activity, this.lFy);
    this.lIx = new PickPoi(this.activity);
    this.lIx.setLocationArrow(a.d.location_artboard1);
    this.lIn.addView(this.lIx);
    this.lID = findViewById(a.e.load);
    this.kjC = ((ImageView)this.activity.findViewById(a.e.title_btn_home));
    this.lIH = ((LinearLayout)this.activity.findViewById(a.e.title_btn_text));
    this.lIH.setVisibility(0);
    label879:
    int j;
    switch (this.type)
    {
    default: 
      this.lII = ((ImageButton)findViewById(a.e.title_search_icon));
      this.lII.setContentDescription(getString(a.h.search_position));
      this.lIJ = ((ActionBarSearchView)findViewById(a.e.search_view_helper));
      hm(false);
      this.lIB = new e(this.activity);
      this.lIC = new e(this.activity);
      this.lIC.fiq = true;
      this.lIC.lJz = -1;
      this.lIx.setAdapter(this.lIB);
      this.lIy.setAdapter(this.lIB);
      this.lIy.setOnTouchListener(new c.1(this));
      paramBundle = (String)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.urm, "");
      if ((!bk.bl(paramBundle)) && ((this.lIO == -85.0D) || (this.lIP == -1000.0D)))
      {
        String[] arrayOfString = paramBundle.split(",");
        y.i("MicroMsg.MMPoiMapUI", "lastlocationinfo " + paramBundle);
        if (arrayOfString.length == 2)
        {
          float f1 = (float)(bk.ZR(arrayOfString[0]) * 1.0D / 1000000.0D);
          float f2 = (float)(bk.ZR(arrayOfString[1]) * 1.0D / 1000000.0D);
          this.lFy.getIController().setCenter(f1, f2);
        }
      }
      this.lIy.setOnLoadMoreListener(new c.10(this));
      this.lIE.setOnClickListener(new c.11(this));
      this.kjC.setOnClickListener(new c.12(this));
      this.lIH.setOnClickListener(new c.13(this));
      this.lIy.setOnItemClickListener(new c.14(this));
      this.lII.setOnClickListener(new c.16(this));
      this.lIJ.setHint(getString(a.h.location_search_hint));
      this.lIJ.nH(false);
      this.lIJ.setBackClickCallback(new c.17(this));
      this.lIJ.setOnEditorActionListener(new TextView.OnEditorActionListener()
      {
        public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          y.d("MicroMsg.MMPoiMapUI", "keyboard action");
          if (3 == paramAnonymousInt) {
            c.m(c.this);
          }
          return false;
        }
      });
      this.lIJ.setCallBack(new c.3(this));
      this.lIZ = ((FrameLayout)findViewById(a.e.mapview_fl));
      this.lJm = ae.getContext().getSharedPreferences(ae.cqR() + "_redesign", 4).getBoolean("dark_actionbar", false);
      if (this.lJm)
      {
        ta(ae.getResources().getColor(a.b.dark_actionbar_color));
        this.lIT = BackwardSupportUtil.b.b(this.activity, 280.0F);
        this.lIU = BackwardSupportUtil.b.b(this.activity, 150.0F);
        j = a.fk(this.activity);
        i = ae.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (i <= 0) {
          break label1123;
        }
      }
      break;
    }
    label1123:
    for (int i = ae.getResources().getDimensionPixelSize(i);; i = 0)
    {
      int k = a.aa(this.activity, a.c.DefaultActionbarHeightPort);
      j = j - this.lIU - i - k;
      if (j > a.aa(this.activity, a.c.send_poi_listview_height))
      {
        y.i("MicroMsg.MMPoiMapUI", "reset listview height: %s, statusBar: %s, actionBar: %s", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(k) });
        paramBundle = this.lIS.getLayoutParams();
        paramBundle.height = j;
        this.lIS.setLayoutParams(paramBundle);
      }
      return;
      ((TextView)findViewById(a.e.action_option_text)).setText(a.h.location_send);
      break;
      ((TextView)findViewById(a.e.action_option_text)).setText(a.h.app_nextstep);
      break;
      ((TextView)findViewById(a.e.action_option_text)).setText(a.h.app_finish);
      break;
      ta(ae.getResources().getColor(a.b.normal_actionbar_color));
      break label879;
    }
  }
  
  public final void onDestroy()
  {
    super.onDestroy();
    com.tencent.mm.kernel.g.Dk().b(457, this);
  }
  
  public final void onPause()
  {
    super.onPause();
    com.tencent.mm.modelgeo.c.Ob().c(this.dig);
    com.tencent.mm.plugin.location.ui.e locale = this.lIM;
    locale.lFd.c(locale.dig);
  }
  
  public final void onResume()
  {
    super.onResume();
    com.tencent.mm.modelgeo.c.Ob().b(this.dig, true);
    com.tencent.mm.plugin.location.ui.e locale = this.lIM;
    locale.lFd.b(locale.dig, true);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramm.getType() != 457) || (paramInt1 != 0) || (paramInt2 != 0)) {
      return;
    }
    this.lIF = null;
    com.tencent.mm.plugin.location.model.h localh = (com.tencent.mm.plugin.location.model.h)paramm;
    if (!localh.lCY.equals(this.lCY))
    {
      y.i("MicroMsg.MMPoiMapUI", "pass this resp!" + this.lCY + " " + localh.lCY);
      return;
    }
    y.i("MicroMsg.MMPoiMapUI", "isend " + localh.inQ + "searchId: " + localh.fTF);
    if (this.lJd == -1L)
    {
      long l = System.currentTimeMillis();
      this.lJe = l;
      this.lJd = l;
    }
    for (;;)
    {
      this.lCZ = localh.lCZ;
      if (!this.lIQ) {
        break label343;
      }
      this.lIA.setVisibility(8);
      if ((this.lIC.getCount() != 0) || (localh.list == null) || (localh.list.size() != 0)) {
        break;
      }
      this.lIK.setVisibility(0);
      this.lIz.cAP();
      return;
      this.lJe = System.currentTimeMillis();
    }
    y.d("MicroMsg.MMPoiMapUI", "search is first: %s", new Object[] { Boolean.valueOf(localh.isFirst()) });
    if (localh.isFirst()) {
      this.lIC.lJy.clear();
    }
    this.lIC.a(localh.list, localh.lCX, localh.inQ, localh.lCY);
    if (!this.lIC.inQ)
    {
      this.lIz.cAO();
      this.lIz.cAQ();
      return;
    }
    this.lIz.cAP();
    return;
    label343:
    Object localObject2;
    Object localObject1;
    if (this.lIw != null)
    {
      localObject2 = (aih)localh.dmK.ecF.ecN;
      paramm = this.lIw;
      localObject1 = ((aih)localObject2).sRA;
      paramString = ((aih)localObject2).teQ;
      String str = ((aih)localObject2).kSC;
      localObject2 = com.tencent.mm.plugin.n.c.FG();
      y.d("MicroMsg.PoiHeaderView", "setContent, url:%s, logUrl:%s", new Object[] { paramString, str });
      paramm.lFt = str;
      paramm.lFu = "";
      if ((!bk.bl((String)localObject1)) && (!bk.bl(paramString))) {
        break label688;
      }
      paramm.setVisibility(8);
      paramm.dqa.setVisibility(8);
      paramm.lFv.setVisibility(8);
    }
    for (;;)
    {
      this.lID.setVisibility(8);
      hm(true);
      if (this.lIG != null)
      {
        paramString = localh.list.iterator();
        while (paramString.hasNext())
        {
          paramm = (f)paramString.next();
          if ((paramm.lJE != null) && (paramm.mName != null) && (paramm.lJE.equals(this.lIG.lJE)) && (paramm.mName.equals(this.lIG.mName))) {
            localh.list.remove(paramm);
          }
        }
        this.lIB.b(this.lIG);
        this.lIG = null;
        this.lJl = true;
        this.lIB.lJl = true;
      }
      this.lIB.a(localh.list, localh.lCX, localh.inQ, localh.lCY);
      this.lIB.lJz = 0;
      this.lIB.notifyDataSetChanged();
      if (this.lIB.inQ) {
        break;
      }
      this.lIy.cAO();
      this.lIy.cAQ();
      return;
      label688:
      paramm.setVisibility(0);
      paramm.dqa.setVisibility(0);
      paramm.lFv.setVisibility(0);
      paramm.dqa.setText((CharSequence)localObject1);
      localObject1 = paramm.lFv;
      ((SimpleImageView)localObject1).imagePath = ((String)localObject2);
      ((SimpleImageView)localObject1).url = paramString;
      ((SimpleImageView)localObject1).eIB = 0;
      ((SimpleImageView)localObject1).eIC = 0;
      if ((paramString == null) || (paramString.length() == 0))
      {
        ((SimpleImageView)localObject1).setVisibility(8);
      }
      else if (paramString.startsWith("http"))
      {
        paramm = BitmapFactory.decodeFile(((SimpleImageView)localObject1).imagePath + com.tencent.mm.a.g.o(paramString.getBytes()));
        if (paramm != null)
        {
          paramString = paramm;
          if (((SimpleImageView)localObject1).eIB > 0)
          {
            paramString = paramm;
            if (((SimpleImageView)localObject1).eIC > 0) {
              paramString = com.tencent.mm.sdk.platformtools.c.a(paramm, ((SimpleImageView)localObject1).eIB, ((SimpleImageView)localObject1).eIC, true, false);
            }
          }
          ((SimpleImageView)localObject1).setImageBitmap(paramString);
        }
        else
        {
          com.tencent.mm.sdk.f.e.post(new SimpleImageView.a(paramString, ((SimpleImageView)localObject1).handler), "SimpleImageView_download");
        }
      }
      else if (!com.tencent.mm.vfs.e.bK(paramString))
      {
        ((SimpleImageView)localObject1).setVisibility(8);
      }
      else
      {
        if ((((SimpleImageView)localObject1).eIB <= 0) || (((SimpleImageView)localObject1).eIC <= 0)) {}
        for (paramString = com.tencent.mm.sdk.platformtools.c.YW(paramString);; paramString = com.tencent.mm.sdk.platformtools.c.e(paramString, ((SimpleImageView)localObject1).eIB, ((SimpleImageView)localObject1).eIC, true))
        {
          if (paramString != null) {
            break label965;
          }
          ((SimpleImageView)localObject1).setVisibility(8);
          break;
        }
        label965:
        ((SimpleImageView)localObject1).setImageBitmap(paramString);
      }
    }
    this.lIy.cAP();
  }
  
  public final void tb(int paramInt)
  {
    ((FrameLayout.LayoutParams)this.lIS.getLayoutParams()).topMargin = paramInt;
    int i = BackwardSupportUtil.b.b(this.activity, 65.0F);
    ((FrameLayout.LayoutParams)this.lIE.getLayoutParams()).topMargin = (paramInt - i);
    i = (paramInt - this.lIV) / 2;
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.lIZ.getLayoutParams();
    if (paramInt == this.lIU) {
      localLayoutParams.topMargin = BackwardSupportUtil.b.b(this.activity, -65.0F);
    }
    for (;;)
    {
      this.lIZ.requestLayout();
      this.lIV = paramInt;
      this.lIS.requestLayout();
      this.lIE.requestLayout();
      return;
      if (paramInt == this.lIT) {
        localLayoutParams.topMargin = 0;
      } else {
        localLayoutParams.topMargin = (i + localLayoutParams.topMargin);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.c
 * JD-Core Version:    0.7.0.1
 */