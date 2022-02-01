package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
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
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.c.a;
import com.tencent.mm.plugin.k.b;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location.model.e;
import com.tencent.mm.plugin.location_soso.api.SoSoMapView;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.aa;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

public abstract class a
  extends com.tencent.mm.plugin.k.a
{
  protected float aTD = 0.0F;
  protected float aTE = 0.0F;
  public Activity activity;
  protected int dKf = 0;
  protected ProgressDialog gtM = null;
  MMHandler handler = new MMHandler(Looper.getMainLooper());
  protected String kHV = "";
  protected LocationInfo lXk = new LocationInfo((byte)0);
  protected LocationInfo lXl = new LocationInfo((byte)0);
  protected com.tencent.mm.plugin.location.ui.d lXm;
  protected String rgD = "";
  protected int type = 0;
  protected boolean uSr = false;
  DisplayMetrics xTo = null;
  int yFw;
  protected String yHz;
  public String yKR = "";
  protected boolean yKS = false;
  public boolean yKT = false;
  protected Addr yKU = null;
  protected a yKV;
  protected boolean yKW = false;
  protected HashMap<String, com.tencent.mm.plugin.location.ui.c> yKX = new HashMap();
  protected com.tencent.mm.modelgeo.c yKY;
  protected boolean yKZ = false;
  protected ArrayList<String> yLa = new ArrayList();
  protected boolean yLb = false;
  protected com.tencent.mm.plugin.location.model.c yLc = null;
  protected com.tencent.mm.modelgeo.d yLd;
  public c.a yLe = new c.a()
  {
    public final void b(Addr paramAnonymousAddr)
    {
      AppMethodBeat.i(55997);
      Log.d("MicroMsg.BaseMapUI", "onGetAddrss  %s", new Object[] { paramAnonymousAddr.toString() });
      a.this.yKU = paramAnonymousAddr;
      String str = paramAnonymousAddr.bbW();
      a.this.lXl.dWi = a.this.activity.getResources().getString(2131762450);
      if ((paramAnonymousAddr.tag != null) && (paramAnonymousAddr.tag.equals(a.this.lXl.yFt))) {
        a.this.lXl.yFx = str;
      }
      for (;;)
      {
        if ((paramAnonymousAddr.tag != null) && (a.this.yKX.containsKey(paramAnonymousAddr.tag)))
        {
          paramAnonymousAddr = (com.tencent.mm.plugin.location.ui.c)a.this.yKX.get(paramAnonymousAddr.tag);
          paramAnonymousAddr.setText(paramAnonymousAddr.getPreText() + str);
        }
        AppMethodBeat.o(55997);
        return;
        if (!Util.isNullOrNil(paramAnonymousAddr.iUO)) {
          a.this.yKV.yLh.setVisibility(0);
        }
      }
    }
  };
  
  public a(Activity paramActivity)
  {
    this.activity = paramActivity;
    this.yKY = com.tencent.mm.modelgeo.c.bbX();
  }
  
  protected abstract String bmB();
  
  protected final boolean c(LocationInfo paramLocationInfo)
  {
    if (this.yKV.yHR.getIController() == null) {}
    while (!e.j(paramLocationInfo.yFu, paramLocationInfo.yFv)) {
      return false;
    }
    this.yKV.yHR.getIController().animateTo(paramLocationInfo.yFu, paramLocationInfo.yFv);
    return true;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      Log.d("MicroMsg.BaseMapUI", "dispatchKeyEvent");
      edF();
      this.activity.finish();
      return true;
    }
    return false;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  protected final void edC()
  {
    if ((this.yKV.yLm == null) || (this.yKV.yLn == null)) {
      return;
    }
    this.yKV.yLm.setText(l.b(this.yKV.yLm.getContext(), this.yHz, this.yKV.yLm.getTextSize()));
    if ((this.yLa == null) || (this.yLa.isEmpty()))
    {
      this.yKV.yLn.setText("");
      return;
    }
    String str1 = (String)this.yLa.get(0);
    String str2 = this.activity.getResources().getString(2131759346);
    int i = 1;
    while (i < this.yLa.size())
    {
      str1 = str1 + str2 + (String)this.yLa.get(i);
      i += 1;
    }
    this.yKV.yLn.setText(l.b(this.yKV.yLn.getContext(), str1, this.yKV.yLn.getTextSize()));
  }
  
  protected final void edD()
  {
    this.yKV.yLh.removeAllViews();
    View localView = View.inflate(this.activity, 2131495307, null);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    this.yKV.yLh.addView(localView, localLayoutParams);
    this.yKV.yLm = ((TextView)localView.findViewById(2131303748));
    this.yKV.yLm.setOnClickListener(new a.1(this));
    this.yKV.yLn = ((TextView)localView.findViewById(2131303753));
    this.yKV.yLn.setOnClickListener(new a.2(this));
    edC();
  }
  
  protected final String edE()
  {
    return Util.nullAs(this.yHz, "");
  }
  
  protected abstract void edF();
  
  abstract void edG();
  
  public boolean edH()
  {
    return true;
  }
  
  public final View findViewById(int paramInt)
  {
    return this.activity.findViewById(paramInt);
  }
  
  public final String getString(int paramInt)
  {
    return this.activity.getString(paramInt);
  }
  
  protected final void hideVKB()
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
  
  protected final void initView()
  {
    Log.d("MicroMsg.BaseMapUI", "initView");
    this.yKV.yLl = ((LinearLayout)findViewById(2131302279));
    this.yKV.yHR = ((com.tencent.mm.plugin.k.d)findViewById(2131301852));
    this.yKV.yLg = ((FrameLayout)findViewById(2131299236));
    this.yKV.yLh = ((RelativeLayout)findViewById(2131309169));
    this.yKV.hNZ = ((ImageView)findViewById(2131309210));
    this.yKV.yLi = ((ImageButton)findViewById(2131309212));
    this.yKV.yLj = findViewById(2131309213);
    this.yKV.yLk = ((TextView)findViewById(2131296402));
    this.yKV.titleView = ((TextView)findViewById(2131304687));
    this.yKV.sLV = ((TextView)findViewById(2131304883));
    this.yKV.titleView.setText(bmB());
    this.yKV.yHR.getIController().setZoom(com.tencent.mm.plugin.location.ui.d.ede());
    if ((this.type != 0) && (this.type != 3))
    {
      this.yKV.yLi.setVisibility(0);
      this.yKV.yLj.setVisibility(8);
      this.yKV.yLi.setEnabled(false);
      this.yKV.yLi.setImageResource(2131690843);
    }
    this.yKV.yHR.setBuiltInZoomControls(false);
    this.yKV.hNZ.setOnClickListener(new a.4(this));
    this.yKV.yLk.setOnClickListener(new a.5(this));
    edG();
    setActionbarColor(MMApplicationContext.getResources().getColor(2131100898));
    this.yKV.yHR.setMapAnchor(0.5F, 0.5F);
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
      } while (this.yKV.yLm == null);
      paramIntent = paramIntent.getCharSequenceExtra("key_result");
      if (paramIntent == null) {}
      for (paramIntent = "";; paramIntent = paramIntent.toString())
      {
        this.yHz = paramIntent;
        edC();
        return;
      }
    } while ((4100 != paramInt1) || (this.yKV.yLn == null));
    this.yLa = paramIntent.getStringArrayListExtra("key_fav_result_list");
    edC();
  }
  
  public void onBackPressed()
  {
    this.activity.finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.yLd = com.tencent.mm.modelgeo.d.bca();
    Object localObject = this.lXl;
    LocationInfo localLocationInfo = this.lXk;
    paramBundle = LocaleUtil.loadApplicationLanguage(MMApplicationContext.getDefaultPreference(), this.activity);
    Log.d("MicroMsg.BaseMapUI", " initLanguage ".concat(String.valueOf(paramBundle)));
    if (paramBundle.equals("language_default"))
    {
      LocaleUtil.updateApplicationResourceLocale(this.activity, Locale.ENGLISH);
      paramBundle = "en";
      localLocationInfo.yFy = paramBundle;
      ((LocationInfo)localObject).yFy = paramBundle;
      Log.d("MicroMsg.BaseMapUI", "sosomap " + this.lXk.yFy);
      this.activity.requestWindowFeature(1);
      this.activity.setContentView(2131494983);
      paramBundle = (FrameLayout)findViewById(2131304494);
      localObject = (SoSoMapView)d.gs(this.activity);
      paramBundle.addView((View)localObject);
      if (!ao.isDarkMode()) {
        break label302;
      }
      ((SoSoMapView)localObject).enableDarkMode();
    }
    for (;;)
    {
      this.lXm = new com.tencent.mm.plugin.location.ui.d(this.activity);
      this.yKV = new a();
      this.yHz = this.activity.getIntent().getStringExtra("kRemark");
      this.yLa = this.activity.getIntent().getStringArrayListExtra("kTags");
      this.type = this.activity.getIntent().getIntExtra("map_view_type", 0);
      this.yKT = this.activity.getIntent().getBooleanExtra("kIs_pick_poi", false);
      Log.i("MicroMsg.BaseMapUI", "isPickPoi " + this.yKT);
      return;
      Locale localLocale = LocaleUtil.transLanguageToLocale(paramBundle);
      LocaleUtil.updateApplicationResourceLocale(this.activity, localLocale);
      break;
      label302:
      ((SoSoMapView)localObject).disableDarkMode();
    }
  }
  
  public void onDestroy()
  {
    this.yKY.a(this.yLe);
    this.yKX.clear();
    Log.d("MicroMsg.BaseMapUI", "destroy");
    if (this.gtM != null)
    {
      this.gtM.dismiss();
      this.gtM = null;
    }
    this.yKV.yHR.destroy();
    System.gc();
  }
  
  public void onPause()
  {
    aa.d(false, new Intent().putExtra("classname", getClass().getName()));
  }
  
  public void onResume()
  {
    aa.d(true, new Intent().putExtra("classname", getClass().getName()));
  }
  
  protected final void setActionbarColor(int paramInt)
  {
    this.yKV.yLl.setBackgroundColor(paramInt);
    Boolean localBoolean = Boolean.valueOf(ar.aln(paramInt));
    Object localObject;
    if (localBoolean.booleanValue())
    {
      this.yKV.hNZ.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
      this.yKV.yLi.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
      this.yKV.titleView.setTextColor(MMApplicationContext.getResources().getColor(2131101427));
      if (Build.VERSION.SDK_INT >= 21)
      {
        localObject = this.activity.getWindow();
        ((Window)localObject).clearFlags(201326592);
        ((Window)localObject).addFlags(-2147483648);
        if ((Build.VERSION.SDK_INT < 23) || (g.isMIUIV8())) {
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
        this.yKV.hNZ.getDrawable().setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
        this.yKV.yLi.getDrawable().setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
        this.yKV.titleView.setTextColor(MMApplicationContext.getResources().getColor(2131100047));
        break;
        label237:
        if (Build.VERSION.SDK_INT < 21) {
          break label275;
        }
        paramInt = ar.v(this.activity.getResources().getColor(2131101173), paramInt);
        break label123;
        label266:
        paramInt |= 0x2000;
      }
      label275:
      paramInt = 0;
    }
  }
  
  final class a
  {
    ImageView hNZ;
    TextView sLV;
    TextView titleView;
    com.tencent.mm.plugin.k.d yHR;
    FrameLayout yLg;
    RelativeLayout yLh;
    ImageButton yLi;
    View yLj;
    TextView yLk;
    LinearLayout yLl;
    TextView yLm;
    TextView yLn;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.a
 * JD-Core Version:    0.7.0.1
 */