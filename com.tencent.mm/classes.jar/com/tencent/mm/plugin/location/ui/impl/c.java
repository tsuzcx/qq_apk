package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Point;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.cb.a;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.plugin.location.ui.PoiHeaderView;
import com.tencent.mm.plugin.location.ui.SimpleImageView;
import com.tencent.mm.plugin.location.ui.SimpleImageView.a;
import com.tencent.mm.protocal.protobuf.ank;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import com.tencent.mm.ui.base.MMLoadMoreListView.a;
import com.tencent.mm.ui.tools.ActionBarSearchView;
import java.util.Iterator;
import java.util.List;

public final class c
  extends b
  implements com.tencent.mm.ai.f
{
  private static int ogu = 11;
  private static int ogv = 12;
  private static int ogw = 13;
  private static int ogx = 14;
  private b.a dZA;
  private String fMx;
  private double lat;
  private double lng;
  private ImageView lzc;
  private String oak;
  private int oal;
  FrameLayout ofA;
  protected PoiHeaderView ofJ;
  private PickPoi ofK;
  private MMLoadMoreListView ofL;
  private MMLoadMoreListView ofM;
  private View ofN;
  private e ofO;
  private e ofP;
  private View ofQ;
  private ImageButton ofR;
  private com.tencent.mm.plugin.location.model.h ofS;
  private f ofT;
  private View ofU;
  private ImageButton ofV;
  ActionBarSearchView ofW;
  private TextView ofX;
  private LinearLayout ofY;
  private com.tencent.mm.plugin.location.ui.e ofZ;
  private boolean ogA;
  private com.tencent.mm.plugin.location.ui.g oga;
  private double ogb;
  private double ogc;
  private boolean ogd;
  private int oge;
  private RelativeLayout ogf;
  private int ogg;
  private int ogh;
  private int ogi;
  private boolean ogj;
  private boolean ogk;
  private boolean ogl;
  private FrameLayout ogm;
  private float ogn;
  private float ogo;
  private int ogp;
  private long ogq;
  private long ogr;
  private long ogs;
  private int ogt;
  private boolean ogy;
  private boolean ogz;
  private TextView titleView;
  
  public c(Activity paramActivity)
  {
    super(paramActivity);
    AppMethodBeat.i(113618);
    this.ofS = null;
    this.ofT = null;
    this.lat = -85.0D;
    this.lng = -1000.0D;
    this.ogb = -85.0D;
    this.ogc = -1000.0D;
    this.oak = "";
    this.ogd = false;
    this.fMx = "";
    this.oge = 0;
    this.ogj = true;
    this.ogk = false;
    this.ogl = false;
    this.ogp = 0;
    this.ogq = -1L;
    this.ogr = -1L;
    this.ogs = -1L;
    this.ogt = -1;
    this.ogy = false;
    this.oal = 1;
    this.dZA = new c.9(this);
    AppMethodBeat.o(113618);
  }
  
  private void a(f paramf)
  {
    AppMethodBeat.i(113624);
    if (this.ogz) {
      setActionbarColor(ah.getResources().getColor(2131689915));
    }
    for (;;)
    {
      this.fMx = "";
      this.ogd = false;
      this.ofN.setVisibility(8);
      this.ofM.setVisibility(8);
      this.ofW.setVisibility(8);
      this.ofW.setSearchContent("");
      this.ofX.setVisibility(8);
      this.ofL.setVisibility(0);
      this.ofL.setAdapter(this.ofO);
      this.ofO.notifyDataSetChanged();
      this.ofY.setVisibility(0);
      hideVKB();
      if (paramf != null)
      {
        this.ocL.getIController().setCenter(paramf.bnl, paramf.bnm);
        this.lat = paramf.bnl;
        this.lng = paramf.bnm;
        this.ofK.m(this.lat, this.lng);
        ie(false);
      }
      AppMethodBeat.o(113624);
      return;
      setActionbarColor(ah.getResources().getColor(2131690316));
    }
  }
  
  private String b(double paramDouble, String paramString)
  {
    AppMethodBeat.i(113626);
    paramString = (int)(paramDouble * 1000000.0D) + "_" + (int)(this.lng * 1000000.0D) + "_" + paramString;
    AppMethodBeat.o(113626);
    return paramString;
  }
  
  private void bMi()
  {
    AppMethodBeat.i(113627);
    if (this.ofK.ogK)
    {
      f localf = this.ofK.getPoi();
      this.ofO.b(localf);
    }
    AppMethodBeat.o(113627);
  }
  
  private void iV(boolean paramBoolean)
  {
    AppMethodBeat.i(113622);
    this.ogj = false;
    c.a locala2;
    if (paramBoolean) {
      locala2 = new c.a(this, -(bMj() - this.ogh));
    }
    for (c.a locala1 = new c.a(this, -(bMj() - this.ogh) / 2);; locala1 = new c.a(this, (this.ogg - bMj()) / 2))
    {
      c.15 local15 = new c.15(this, paramBoolean);
      locala2.setDuration(200L);
      locala2 = locala2.bMo();
      locala2.setAnimationListener(local15);
      locala2.dq(this.ogf).dq(this.ofR).bMp();
      locala1.setDuration(200L);
      locala1.bMo().dq(this.ogm).bMp();
      AppMethodBeat.o(113622);
      return;
      locala2 = new c.a(this, this.ogg - bMj());
    }
  }
  
  private void iW(boolean paramBoolean)
  {
    AppMethodBeat.i(113632);
    ab.d("MicroMsg.MMPoiMapUI", "enable send.. %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.ofU.setEnabled(paramBoolean);
    findViewById(2131820974).setEnabled(paramBoolean);
    this.ofV.setEnabled(paramBoolean);
    AppMethodBeat.o(113632);
  }
  
  private void ie(boolean paramBoolean)
  {
    AppMethodBeat.i(113628);
    if (this.oga != null) {
      this.oga.remove();
    }
    this.oak = b(this.lat, this.fMx);
    if (this.oak.equals(this.ofO.key))
    {
      ab.i("MicroMsg.MMPoiMapUI", "same key passed it ", new Object[] { this.oak });
      AppMethodBeat.o(113628);
      return;
    }
    byte[] arrayOfByte = null;
    int i = 1;
    label164:
    double d1;
    double d2;
    if (this.ogd) {
      if ((this.oal > 0) && (paramBoolean))
      {
        this.ofM.dDZ();
        this.ofP.bMq();
        this.ofP.Sl(this.oak);
        this.ofP.lbI = this.fMx;
        arrayOfByte = this.ofP.buffer;
        if (i == 0) {
          break label409;
        }
        if (this.oge != 0) {
          break label397;
        }
        i = 0;
        d1 = this.lat;
        d2 = this.lng;
        if (!this.ogd) {
          break label403;
        }
      }
    }
    label397:
    label403:
    for (int j = 0;; j = 1)
    {
      this.ofS = new com.tencent.mm.plugin.location.model.h(arrayOfByte, d1, d2, i, j, this.ogo, this.ogn, this.oak, this.fMx, paramBoolean);
      com.tencent.mm.kernel.g.Rc().a(this.ofS, 0);
      this.ogp += 1;
      if (this.ogs == -1L) {
        this.ogs = System.currentTimeMillis();
      }
      AppMethodBeat.o(113628);
      return;
      if (!paramBoolean)
      {
        this.ofM.dDZ();
        this.ofP.clean();
        this.ofP.Sl(this.oak);
        this.ofP.lbI = this.fMx;
        arrayOfByte = this.ofP.buffer;
        this.ofP.notifyDataSetChanged();
        break;
      }
      i = 0;
      break;
      this.ofL.dDZ();
      this.ofO.clean();
      this.ofO.Sl(this.oak);
      this.ofO.notifyDataSetChanged();
      arrayOfByte = this.ofO.buffer;
      this.ofQ.setVisibility(0);
      iW(false);
      bMi();
      break;
      i = 1;
      break label164;
    }
    label409:
    ab.i("MicroMsg.MMPoiMapUI", "pass this query because query interval: %d", new Object[] { Integer.valueOf(this.oal) });
    AppMethodBeat.o(113628);
  }
  
  private void m(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(113629);
    String str3;
    String str1;
    String str2;
    if ((this.ogb == -85.0D) || (this.ogc == -1000.0D))
    {
      str3 = "null/null";
      str1 = "";
      if (paramBoolean) {
        break label577;
      }
      if (this.ofO.lxQ >= this.ofO.getCount()) {
        break label646;
      }
      str1 = this.ofO.ye(this.ofO.lxQ).ohd;
      str2 = this.ofO.ye(this.ofO.lxQ).ogT;
    }
    for (;;)
    {
      label96:
      String str4 = str1;
      if (paramInt2 == 0)
      {
        str4 = str1;
        if (bo.isNullOrNil(str1))
        {
          str4 = str1;
          if (this.ofO.getCount() > 1)
          {
            ab.d("MicroMsg.MMPoiMapUI", "set searchid in first poi");
            str4 = this.ofO.ye(1).ohd;
          }
        }
      }
      if ((this.ofO.getCount() > 0) && (!paramBoolean)) {
        ab.d("MicroMsg.MMPoiMapUI", "set request id at index: %s", new Object[] { Integer.valueOf(paramInt2) });
      }
      for (str1 = this.ofO.ye(0).ohe;; str1 = "")
      {
        int i = paramInt2;
        if (paramInt2 == 0)
        {
          i = paramInt2;
          if (!paramBoolean)
          {
            i = paramInt2;
            if (this.ofO.getCount() > 0)
            {
              int j = this.ofO.ye(0).ohf;
              i = paramInt2;
              if (j >= 0)
              {
                ab.d("MicroMsg.MMPoiMapUI", "change to search index: %s", new Object[] { Integer.valueOf(j) });
                i = j;
              }
            }
          }
        }
        ab.d("MicroMsg.MMPoiMapUI", "tofutest type:%d, index: %d, startTime: %s, lastTime: %s, firsSuccTime: %s, poiCount: %s, latlng: %s, entryTime: %s, searchId: %s, requestId: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(i + 1), Long.valueOf(this.ogs), Long.valueOf(this.ogr), Long.valueOf(this.ogq), Integer.valueOf(this.ogp), str3, Integer.valueOf(this.ogt), str4, str1 });
        com.tencent.mm.plugin.report.service.h.qsU.e(11135, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(i + 1), Long.valueOf(this.ogs), Long.valueOf(this.ogr), Long.valueOf(System.currentTimeMillis()), Long.valueOf(this.ogq), Integer.valueOf(this.ogp), str3, str2, Integer.valueOf(this.ogt), str4, q.bP(true), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), str1 });
        AppMethodBeat.o(113629);
        return;
        str3 = String.format("%f/%f", new Object[] { Double.valueOf(this.ogb), Double.valueOf(this.ogc) });
        break;
        label577:
        if ((paramInt2 < 0) || (this.ofP.lxQ >= this.ofP.getCount())) {
          break label646;
        }
        str1 = this.ofP.ye(this.ofP.lxQ).ohd;
        str2 = this.ofP.ye(this.ofP.lxQ).ogT;
        break label96;
      }
      label646:
      str2 = "";
    }
  }
  
  private void setActionbarColor(int paramInt)
  {
    AppMethodBeat.i(113621);
    this.ofY.setBackgroundColor(paramInt);
    this.ofW.setBackgroundColor(paramInt);
    Boolean localBoolean = Boolean.valueOf(aj.Ow(paramInt));
    if (localBoolean.booleanValue())
    {
      this.lzc.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
      this.ofV.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
      this.titleView.setTextColor(ah.getResources().getColor(2131690711));
    }
    Object localObject;
    if (Build.VERSION.SDK_INT >= 21)
    {
      localObject = this.activity.getWindow();
      ((Window)localObject).clearFlags(201326592);
      ((Window)localObject).addFlags(-2147483648);
      if ((Build.VERSION.SDK_INT < 23) || (com.tencent.mm.compatible.util.h.Mo())) {
        break label185;
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
          break label214;
        }
        paramInt &= 0xFFFFDFFF;
      }
      for (;;)
      {
        ((View)localObject).setSystemUiVisibility(paramInt);
        AppMethodBeat.o(113621);
        return;
        label185:
        if (Build.VERSION.SDK_INT < 21) {
          break label223;
        }
        paramInt = aj.n(this.activity.getResources().getColor(2131690523), paramInt);
        break;
        label214:
        paramInt |= 0x2000;
      }
      label223:
      paramInt = 0;
    }
  }
  
  public final com.tencent.mm.plugin.k.d bMg()
  {
    AppMethodBeat.i(113620);
    com.tencent.mm.plugin.k.d locald = (com.tencent.mm.plugin.k.d)this.activity.findViewById(2131820622);
    AppMethodBeat.o(113620);
    return locald;
  }
  
  public final void bMh()
  {
    AppMethodBeat.i(113625);
    PickPoi localPickPoi = this.ofK;
    localPickPoi.obW.clearAnimation();
    localPickPoi.obW.startAnimation(localPickPoi.wq);
    this.lat = (this.ocL.getMapCenterX() / 1000000.0D);
    this.lng = (this.ocL.getMapCenterY() / 1000000.0D);
    this.ofK.l(this.lat, this.lng);
    this.ofR.setBackgroundResource(2130839295);
    if (this.ogl) {
      iV(false);
    }
    ie(false);
    this.ogy = false;
    this.ofO.ogy = false;
    AppMethodBeat.o(113625);
  }
  
  public final int bMj()
  {
    AppMethodBeat.i(113636);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.ogf.getLayoutParams();
    this.ogi = localMarginLayoutParams.topMargin;
    int i = localMarginLayoutParams.topMargin;
    AppMethodBeat.o(113636);
    return i;
  }
  
  public final boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(113623);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      ab.d("MicroMsg.MMPoiMapUI", "dispatchKeyEvent");
      if (this.ogd)
      {
        a(null);
        m(ogx, this.ofP.lxQ, true);
        AppMethodBeat.o(113623);
        return false;
      }
      m(ogv, this.ofO.lxQ, false);
      this.activity.finish();
      AppMethodBeat.o(113623);
      return true;
    }
    AppMethodBeat.o(113623);
    return false;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(113619);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.Rc().a(457, this);
    this.ogt = ((int)(System.currentTimeMillis() / 1000L));
    this.ofY = ((LinearLayout)findViewById(2131826116));
    this.titleView = ((TextView)findViewById(2131826119));
    this.titleView.setText(getString(2131301107));
    this.ogf = ((RelativeLayout)findViewById(2131826744));
    this.ofL = ((MMLoadMoreListView)this.activity.findViewById(2131826746));
    this.ofM = ((MMLoadMoreListView)this.activity.findViewById(2131826748));
    this.ofN = this.activity.findViewById(2131826750);
    this.ofX = ((TextView)findViewById(2131826749));
    this.ofR = ((ImageButton)findViewById(2131824806));
    this.ofR.setContentDescription(getString(2131301087));
    this.ofJ = ((PoiHeaderView)findViewById(2131826745));
    this.ocL.setBuiltInZoomControls(false);
    this.ofA = ((FrameLayout)findViewById(2131824803));
    this.ofZ = new com.tencent.mm.plugin.location.ui.e(this.activity, this.ocL);
    this.oga = new com.tencent.mm.plugin.location.ui.g(this.activity, this.ocL);
    this.ofK = new PickPoi(this.activity);
    this.ofK.setLocationArrow(2130839292);
    this.ofA.addView(this.ofK);
    this.ofQ = findViewById(2131826747);
    this.lzc = ((ImageView)this.activity.findViewById(2131826118));
    this.ofU = ((LinearLayout)this.activity.findViewById(2131826123));
    this.ofU.setVisibility(0);
    int k;
    int i;
    switch (this.type)
    {
    default: 
      this.ofV = ((ImageButton)findViewById(2131826121));
      this.ofV.setContentDescription(getString(2131303019));
      this.ofW = ((ActionBarSearchView)findViewById(2131826742));
      iW(false);
      this.ofO = new e(this.activity);
      this.ofP = new e(this.activity);
      this.ofP.gzX = true;
      this.ofP.lxQ = -1;
      this.ofK.setAdapter(this.ofO);
      this.ofL.setAdapter(this.ofO);
      this.ofL.setOnTouchListener(new c.1(this));
      paramBundle = (String)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yBl, "");
      if ((!bo.isNullOrNil(paramBundle)) && ((this.ogb == -85.0D) || (this.ogc == -1000.0D)))
      {
        String[] arrayOfString = paramBundle.split(",");
        ab.i("MicroMsg.MMPoiMapUI", "lastlocationinfo ".concat(String.valueOf(paramBundle)));
        if (arrayOfString.length == 2)
        {
          float f1 = (float)(bo.apV(arrayOfString[0]) * 1.0D / 1000000.0D);
          float f2 = (float)(bo.apV(arrayOfString[1]) * 1.0D / 1000000.0D);
          this.ocL.getIController().setCenter(f1, f2);
        }
      }
      this.ofL.setOnLoadMoreListener(new c.10(this));
      this.ofR.setOnClickListener(new c.11(this));
      this.lzc.setOnClickListener(new c.12(this));
      this.ofU.setOnClickListener(new c.13(this));
      this.ofL.setOnItemClickListener(new c.14(this));
      this.ofV.setOnClickListener(new c.16(this));
      this.ofW.setHint(getString(2131301103));
      this.ofW.rr(false);
      this.ofW.setBackClickCallback(new c.17(this));
      this.ofW.setOnEditorActionListener(new c.2(this));
      this.ofW.setCallBack(new c.3(this));
      this.ogm = ((FrameLayout)findViewById(2131826743));
      setActionbarColor(ah.getResources().getColor(2131690316));
      this.ogg = BackwardSupportUtil.b.b(this.activity, 280.0F);
      this.ogh = BackwardSupportUtil.b.b(this.activity, 150.0F);
      paramBundle = af.hQ(this.activity);
      k = Math.max(paramBundle.x, paramBundle.y);
      i = ah.getResources().getIdentifier("status_bar_height", "dimen", "android");
      if (i <= 0) {
        break;
      }
    }
    for (int j = ah.getResources().getDimensionPixelSize(i);; j = 0)
    {
      int m = a.ao(this.activity, 2131427559);
      paramBundle = this.activity.findViewById(16908336);
      if (paramBundle == null)
      {
        i = 0;
        label938:
        if (i == 0) {
          break label1139;
        }
      }
      label1139:
      for (i = af.fx(this.activity);; i = 0)
      {
        i = k - this.ogh - j - m - i;
        if (i > a.ao(this.activity, 2131428659))
        {
          ab.i("MicroMsg.MMPoiMapUI", "reset listview height: %s, statusBar: %s, actionBar: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(m) });
          paramBundle = this.ogf.getLayoutParams();
          paramBundle.height = i;
          this.ogf.setLayoutParams(paramBundle);
        }
        AppMethodBeat.o(113619);
        return;
        ((TextView)findViewById(2131820974)).setText(2131301106);
        break;
        ((TextView)findViewById(2131820974)).setText(2131297013);
        break;
        ((TextView)findViewById(2131820974)).setText(2131296964);
        break;
        i = paramBundle.getVisibility();
        if ((i == 8) || (i == 4))
        {
          i = 0;
          break label938;
        }
        i = 1;
        break label938;
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(113633);
    super.onDestroy();
    com.tencent.mm.kernel.g.Rc().b(457, this);
    AppMethodBeat.o(113633);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(113631);
    super.onPause();
    com.tencent.mm.modelgeo.d.agQ().c(this.dZA);
    com.tencent.mm.plugin.location.ui.e locale = this.ofZ;
    locale.ocr.c(locale.dZA);
    AppMethodBeat.o(113631);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(113630);
    super.onResume();
    com.tencent.mm.modelgeo.d.agQ().b(this.dZA, true);
    com.tencent.mm.plugin.location.ui.e locale = this.ofZ;
    locale.ocr.b(locale.dZA, true);
    AppMethodBeat.o(113630);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(113634);
    if (paramm.getType() == 457)
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        AppMethodBeat.o(113634);
        return;
      }
      this.ofS = null;
      com.tencent.mm.plugin.location.model.h localh = (com.tencent.mm.plugin.location.model.h)paramm;
      if (!localh.oak.equals(this.oak))
      {
        ab.i("MicroMsg.MMPoiMapUI", "pass this resp!" + this.oak + " " + localh.oak);
        AppMethodBeat.o(113634);
        return;
      }
      ab.i("MicroMsg.MMPoiMapUI", "isend " + localh.eRq + "searchId: " + localh.hng);
      if (this.ogq == -1L)
      {
        long l = System.currentTimeMillis();
        this.ogr = l;
        this.ogq = l;
      }
      for (;;)
      {
        this.oal = localh.oal;
        if (!this.ogd) {
          break label386;
        }
        this.ofN.setVisibility(8);
        if ((this.ofP.getCount() != 0) || (localh.list == null) || (localh.list.size() != 0)) {
          break;
        }
        this.ofX.setVisibility(0);
        this.ofM.dDZ();
        AppMethodBeat.o(113634);
        return;
        this.ogr = System.currentTimeMillis();
      }
      ab.d("MicroMsg.MMPoiMapUI", "search is first: %s", new Object[] { Boolean.valueOf(localh.isFirst()) });
      if (localh.isFirst()) {
        this.ofP.ogN.clear();
      }
      this.ofP.a(localh.list, localh.oaj, localh.eRq, localh.oak);
      if (!this.ofP.eRq)
      {
        this.ofM.dDY();
        this.ofM.dEa();
        AppMethodBeat.o(113634);
        return;
      }
      this.ofM.dDZ();
      this.ofM.dEb();
      AppMethodBeat.o(113634);
      return;
      label386:
      Object localObject2;
      Object localObject1;
      if (this.ofJ != null)
      {
        localObject2 = (ank)localh.rr.fsW.fta;
        paramm = this.ofJ;
        localObject1 = ((ank)localObject2).wxW;
        paramString = ((ank)localObject2).xcN;
        String str = ((ank)localObject2).Url;
        localObject2 = com.tencent.mm.plugin.i.c.YK();
        ab.d("MicroMsg.PoiHeaderView", "setContent, url:%s, logUrl:%s", new Object[] { paramString, str });
        paramm.ocG = str;
        paramm.ocH = "";
        if ((!bo.isNullOrNil((String)localObject1)) && (!bo.isNullOrNil(paramString))) {
          break label737;
        }
        paramm.setVisibility(8);
        paramm.ehx.setVisibility(8);
        paramm.ocI.setVisibility(8);
      }
      for (;;)
      {
        this.ofQ.setVisibility(8);
        iW(true);
        if (this.ofT != null)
        {
          paramString = localh.list.iterator();
          while (paramString.hasNext())
          {
            paramm = (f)paramString.next();
            if ((paramm.ogS != null) && (paramm.mName != null) && (paramm.ogS.equals(this.ofT.ogS)) && (paramm.mName.equals(this.ofT.mName))) {
              localh.list.remove(paramm);
            }
          }
          this.ofO.b(this.ofT);
          this.ofT = null;
          this.ogy = true;
          this.ofO.ogy = true;
        }
        this.ofO.a(localh.list, localh.oaj, localh.eRq, localh.oak);
        this.ofO.lxQ = 0;
        this.ofO.notifyDataSetChanged();
        if (this.ofO.eRq) {
          break;
        }
        this.ofL.dDY();
        this.ofL.dEa();
        AppMethodBeat.o(113634);
        return;
        label737:
        paramm.setVisibility(0);
        paramm.ehx.setVisibility(0);
        paramm.ocI.setVisibility(0);
        paramm.ehx.setText((CharSequence)localObject1);
        localObject1 = paramm.ocI;
        ((SimpleImageView)localObject1).imagePath = ((String)localObject2);
        ((SimpleImageView)localObject1).url = paramString;
        ((SimpleImageView)localObject1).eRu = 0;
        ((SimpleImageView)localObject1).eRv = 0;
        if ((paramString == null) || (paramString.length() == 0))
        {
          ((SimpleImageView)localObject1).setVisibility(8);
        }
        else if (paramString.startsWith("http"))
        {
          paramm = BitmapFactory.decodeFile(((SimpleImageView)localObject1).imagePath + com.tencent.mm.a.g.w(paramString.getBytes()));
          if (paramm != null)
          {
            paramString = paramm;
            if (((SimpleImageView)localObject1).eRu > 0)
            {
              paramString = paramm;
              if (((SimpleImageView)localObject1).eRv > 0) {
                paramString = com.tencent.mm.sdk.platformtools.d.a(paramm, ((SimpleImageView)localObject1).eRu, ((SimpleImageView)localObject1).eRv, true, false);
              }
            }
            ((SimpleImageView)localObject1).setImageBitmap(paramString);
          }
          else
          {
            com.tencent.mm.sdk.g.d.post(new SimpleImageView.a(paramString, ((SimpleImageView)localObject1).handler), "SimpleImageView_download");
          }
        }
        else if (!com.tencent.mm.vfs.e.cN(paramString))
        {
          ((SimpleImageView)localObject1).setVisibility(8);
        }
        else
        {
          if ((((SimpleImageView)localObject1).eRu <= 0) || (((SimpleImageView)localObject1).eRv <= 0)) {}
          for (paramString = com.tencent.mm.sdk.platformtools.d.aoV(paramString);; paramString = com.tencent.mm.sdk.platformtools.d.d(paramString, ((SimpleImageView)localObject1).eRu, ((SimpleImageView)localObject1).eRv, true))
          {
            if (paramString != null) {
              break label1014;
            }
            ((SimpleImageView)localObject1).setVisibility(8);
            break;
          }
          label1014:
          ((SimpleImageView)localObject1).setImageBitmap(paramString);
        }
      }
      this.ofL.dDZ();
      this.ofL.dEb();
    }
    AppMethodBeat.o(113634);
  }
  
  public final void yd(int paramInt)
  {
    AppMethodBeat.i(113635);
    ((FrameLayout.LayoutParams)this.ogf.getLayoutParams()).topMargin = paramInt;
    int i = BackwardSupportUtil.b.b(this.activity, 65.0F);
    ((FrameLayout.LayoutParams)this.ofR.getLayoutParams()).topMargin = (paramInt - i);
    i = (paramInt - this.ogi) / 2;
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.ogm.getLayoutParams();
    if (paramInt == this.ogh) {
      localLayoutParams.topMargin = BackwardSupportUtil.b.b(this.activity, -65.0F);
    }
    for (;;)
    {
      this.ogm.requestLayout();
      this.ogi = paramInt;
      this.ogf.requestLayout();
      this.ofR.requestLayout();
      AppMethodBeat.o(113635);
      return;
      if (paramInt == this.ogg) {
        localLayoutParams.topMargin = 0;
      } else {
        localLayoutParams.topMargin = (i + localLayoutParams.topMargin);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.c
 * JD-Core Version:    0.7.0.1
 */