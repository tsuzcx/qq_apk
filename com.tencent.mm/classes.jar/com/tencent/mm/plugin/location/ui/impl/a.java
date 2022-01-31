package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location.model.e;
import com.tencent.mm.plugin.map.a.b;
import com.tencent.mm.plugin.map.a.d;
import com.tencent.mm.plugin.map.a.e;
import com.tencent.mm.plugin.map.a.f;
import com.tencent.mm.plugin.map.a.h;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.an;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

public abstract class a
  extends com.tencent.mm.plugin.p.a
{
  public Activity activity;
  protected int bMJ = 0;
  protected ProgressDialog dnm = null;
  protected float hZz = 0.0F;
  ah handler = new ah(Looper.getMainLooper());
  protected float kXk = 0.0F;
  int lCL;
  protected String lEN;
  protected String lEc = "";
  protected String lFn = "";
  public String lHU = "";
  protected boolean lHV = false;
  public boolean lHW = false;
  protected Addr lHX = null;
  protected com.tencent.mm.plugin.location.ui.d lHY;
  protected LocationInfo lHZ = new LocationInfo((byte)0);
  protected LocationInfo lIa = new LocationInfo((byte)0);
  protected a.a lIb;
  protected boolean lIc = false;
  protected HashMap<String, com.tencent.mm.plugin.location.ui.c> lId = new HashMap();
  protected com.tencent.mm.modelgeo.b lIe;
  protected boolean lIf = false;
  protected ArrayList<String> lIg = new ArrayList();
  protected boolean lIh = false;
  protected boolean lIi = false;
  protected com.tencent.mm.plugin.location.model.c lIj = null;
  protected com.tencent.mm.modelgeo.c lIk;
  public b.a lIl = new a.3(this);
  DisplayMetrics lcj = null;
  protected int type = 0;
  
  public a(Activity paramActivity)
  {
    this.activity = paramActivity;
    this.lIe = com.tencent.mm.modelgeo.b.NZ();
  }
  
  protected abstract String VE();
  
  protected final void XM()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)this.activity.getSystemService("input_method");
    if (localInputMethodManager == null) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = this.activity.getCurrentFocus();
      } while (localObject == null);
      localObject = ((View)localObject).getWindowToken();
    } while (localObject == null);
    localInputMethodManager.hideSoftInputFromWindow((IBinder)localObject, 0);
  }
  
  protected final boolean b(LocationInfo paramLocationInfo)
  {
    if (this.lIb.lFm.getIController() == null) {}
    while (!e.h(paramLocationInfo.lCJ, paramLocationInfo.lCK)) {
      return false;
    }
    this.lIb.lFm.getIController().animateTo(paramLocationInfo.lCJ, paramLocationInfo.lCK);
    return true;
  }
  
  protected final void beG()
  {
    if ((this.lIb.lIt == null) || (this.lIb.lIu == null)) {
      return;
    }
    this.lIb.lIt.setText(j.a(this.lIb.lIt.getContext(), this.lEN, this.lIb.lIt.getTextSize()));
    if ((this.lIg == null) || (this.lIg.isEmpty()))
    {
      this.lIb.lIu.setText("");
      return;
    }
    String str1 = (String)this.lIg.get(0);
    String str2 = this.activity.getResources().getString(a.h.favorite_tag_delimiter_1);
    int i = 1;
    while (i < this.lIg.size())
    {
      str1 = str1 + str2 + (String)this.lIg.get(i);
      i += 1;
    }
    this.lIb.lIu.setText(j.a(this.lIb.lIu.getContext(), str1, this.lIb.lIu.getTextSize()));
  }
  
  protected final void beH()
  {
    this.lIb.lIo.removeAllViews();
    View localView = View.inflate(this.activity, a.f.location_favorite, null);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    this.lIb.lIo.addView(localView, localLayoutParams);
    this.lIb.lIt = ((TextView)localView.findViewById(a.e.location_remark));
    this.lIb.lIt.setOnClickListener(new a.1(this));
    this.lIb.lIu = ((TextView)localView.findViewById(a.e.location_tags));
    this.lIb.lIu.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("key_fav_item_id", a.this.activity.getIntent().getLongExtra("kFavInfoLocalId", -1L));
        paramAnonymousView.putExtra("key_fav_result_list", a.this.activity.getIntent().getStringArrayListExtra("kTags"));
        com.tencent.mm.plugin.fav.a.b.b(a.this.activity, ".ui.FavTagEditUI", paramAnonymousView, 4100);
      }
    });
    beG();
  }
  
  protected final String beI()
  {
    return bk.aM(this.lEN, "");
  }
  
  protected abstract void beJ();
  
  abstract void beK();
  
  public boolean beL()
  {
    return true;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      y.d("MicroMsg.BaseMapUI", "dispatchKeyEvent");
      beJ();
      this.activity.finish();
      return true;
    }
    return false;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public final View findViewById(int paramInt)
  {
    return this.activity.findViewById(paramInt);
  }
  
  public final String getString(int paramInt)
  {
    return this.activity.getString(paramInt);
  }
  
  protected final void initView()
  {
    y.d("MicroMsg.BaseMapUI", "initView");
    this.lIb.lIs = ((LinearLayout)findViewById(a.e.header_bar));
    this.lIb.lFm = ((com.tencent.mm.plugin.p.d)findViewById(a.e.g_mapView));
    this.lIb.lIn = ((FrameLayout)findViewById(a.e.control_id));
    this.lIb.lIo = ((RelativeLayout)findViewById(a.e.tips_area));
    this.lIb.kjC = ((ImageView)findViewById(a.e.title_btn_home));
    this.lIb.lIp = ((ImageButton)findViewById(a.e.title_btn_icon));
    this.lIb.lIq = findViewById(a.e.title_btn_text);
    this.lIb.lIr = ((TextView)findViewById(a.e.action_option_text));
    this.lIb.titleView = ((TextView)findViewById(a.e.mm_action_bar_mmtitle));
    this.lIb.lAx = ((TextView)findViewById(a.e.more_info));
    this.lIb.titleView.setText(VE());
    this.lIb.lFm.getIController().setZoom(com.tencent.mm.plugin.location.ui.d.bem());
    if ((this.type != 0) && (this.type != 3))
    {
      this.lIb.lIp.setVisibility(0);
      this.lIb.lIq.setVisibility(8);
      this.lIb.lIp.setEnabled(false);
      this.lIb.lIp.setImageResource(a.d.mm_title_btn_menu);
    }
    this.lIb.lFm.setBuiltInZoomControls(false);
    this.lIb.kjC.setOnClickListener(new a.4(this));
    this.lIb.lIr.setOnClickListener(new a.5(this));
    beK();
    if (Boolean.valueOf(ae.getContext().getSharedPreferences(ae.cqR() + "_redesign", 4).getBoolean("dark_actionbar", false)).booleanValue())
    {
      ta(ae.getResources().getColor(a.b.dark_actionbar_color));
      return;
    }
    ta(ae.getResources().getColor(a.b.normal_actionbar_color));
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (-1 != paramInt2) {}
    do
    {
      do
      {
        return;
        if (4096 != paramInt1) {
          break;
        }
      } while (this.lIb.lIt == null);
      paramIntent = paramIntent.getCharSequenceExtra("key_result");
      if (paramIntent == null) {}
      for (paramIntent = "";; paramIntent = paramIntent.toString())
      {
        this.lEN = paramIntent;
        beG();
        return;
      }
    } while ((4100 != paramInt1) || (this.lIb.lIu == null));
    this.lIg = paramIntent.getStringArrayListExtra("key_fav_result_list");
    beG();
  }
  
  public void onBackPressed()
  {
    this.activity.finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.lIk = com.tencent.mm.modelgeo.c.Ob();
    LocationInfo localLocationInfo1 = this.lIa;
    LocationInfo localLocationInfo2 = this.lHZ;
    paramBundle = com.tencent.mm.sdk.platformtools.x.d(ae.cqS());
    y.d("MicroMsg.BaseMapUI", " initLanguage " + paramBundle);
    if (paramBundle.equals("language_default"))
    {
      com.tencent.mm.sdk.platformtools.x.a(this.activity, Locale.ENGLISH);
      paramBundle = "en";
    }
    for (;;)
    {
      localLocationInfo2.lCN = paramBundle;
      localLocationInfo1.lCN = paramBundle;
      y.d("MicroMsg.BaseMapUI", "sosomap " + this.lHZ.lCN);
      this.activity.requestWindowFeature(1);
      this.activity.setContentView(a.f.gmap_ui);
      ((FrameLayout)findViewById(a.e.mapview_content)).addView(d.dH(this.activity));
      this.lHY = new com.tencent.mm.plugin.location.ui.d(this.activity);
      this.lIb = new a.a(this);
      this.lEN = this.activity.getIntent().getStringExtra("kRemark");
      this.lIg = this.activity.getIntent().getStringArrayListExtra("kTags");
      this.type = this.activity.getIntent().getIntExtra("map_view_type", 0);
      this.lHW = this.activity.getIntent().getBooleanExtra("kIs_pick_poi", false);
      y.i("MicroMsg.BaseMapUI", "isPickPoi " + this.lHW);
      return;
      Locale localLocale = com.tencent.mm.sdk.platformtools.x.Zi(paramBundle);
      com.tencent.mm.sdk.platformtools.x.a(this.activity, localLocale);
    }
  }
  
  public void onDestroy()
  {
    this.lIe.a(this.lIl);
    y.d("MicroMsg.BaseMapUI", "destroy");
    if (this.dnm != null)
    {
      this.dnm.dismiss();
      this.dnm = null;
    }
    this.lIb.lFm.destroy();
    System.gc();
  }
  
  public void onPause()
  {
    com.tencent.mm.ui.base.x.b(false, new Intent().putExtra("classname", getClass().getName()));
  }
  
  public void onResume()
  {
    com.tencent.mm.ui.base.x.b(true, new Intent().putExtra("classname", getClass().getName()));
  }
  
  protected final void ta(int paramInt)
  {
    this.lIb.lIs.setBackgroundColor(paramInt);
    Boolean localBoolean = Boolean.valueOf(an.Gf(paramInt));
    Object localObject;
    if (localBoolean.booleanValue())
    {
      this.lIb.kjC.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
      this.lIb.lIp.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
      this.lIb.titleView.setTextColor(ae.getResources().getColor(a.b.white_text_color));
      if (Build.VERSION.SDK_INT >= 21)
      {
        localObject = this.activity.getWindow();
        ((Window)localObject).clearFlags(201326592);
        ((Window)localObject).addFlags(-2147483648);
        if ((Build.VERSION.SDK_INT < 23) || (h.zL())) {
          break label237;
        }
      }
    }
    for (;;)
    {
      label123:
      this.activity.getWindow().setStatusBarColor(paramInt);
      if (Build.VERSION.SDK_INT >= 23)
      {
        localObject = this.activity.getWindow().getDecorView();
        paramInt = ((View)localObject).getSystemUiVisibility();
        if (!localBoolean.booleanValue()) {
          break label266;
        }
        paramInt &= 0xFFFFDFFF;
      }
      for (;;)
      {
        ((View)localObject).setSystemUiVisibility(paramInt);
        return;
        this.lIb.kjC.getDrawable().setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
        this.lIb.lIp.getDrawable().setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
        this.lIb.titleView.setTextColor(ae.getResources().getColor(a.b.black_text_color));
        break;
        label237:
        if (Build.VERSION.SDK_INT < 21) {
          break label275;
        }
        paramInt = an.n(this.activity.getResources().getColor(a.b.statusbar_fg_drak_color), paramInt);
        break label123;
        label266:
        paramInt |= 0x2000;
      }
      label275:
      paramInt = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.a
 * JD-Core Version:    0.7.0.1
 */