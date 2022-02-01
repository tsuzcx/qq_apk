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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.c.a;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location.model.e;
import com.tencent.mm.plugin.location.ui.RemarkUI;
import com.tencent.mm.plugin.location_soso.api.SoSoMapView;
import com.tencent.mm.plugin.map.a.b;
import com.tencent.mm.plugin.map.a.e;
import com.tencent.mm.plugin.map.a.f;
import com.tencent.mm.plugin.map.a.h;
import com.tencent.mm.plugin.map.a.i;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.ac;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

public abstract class a
  extends com.tencent.mm.plugin.q.a
{
  DisplayMetrics CXz = null;
  int Ejp;
  protected String Els;
  public String EoK = "";
  protected boolean EoL = false;
  public boolean EoM = false;
  protected Addr EoN = null;
  protected a EoO;
  protected boolean EoP = false;
  protected HashMap<String, com.tencent.mm.plugin.location.ui.c> EoQ = new HashMap();
  protected com.tencent.mm.modelgeo.c EoR;
  protected boolean EoS = false;
  protected ArrayList<String> EoT = new ArrayList();
  protected boolean EoU = false;
  protected com.tencent.mm.plugin.location.model.c EoV = null;
  protected com.tencent.mm.modelgeo.d EoW;
  public c.a EoX = new c.a()
  {
    public final void b(Addr paramAnonymousAddr)
    {
      AppMethodBeat.i(55997);
      Log.d("MicroMsg.BaseMapUI", "onGetAddrss  %s", new Object[] { paramAnonymousAddr.toString() });
      a.this.EoN = paramAnonymousAddr;
      String str = paramAnonymousAddr.blm();
      a.this.oUW.fPN = a.this.activity.getResources().getString(a.eMW());
      if ((paramAnonymousAddr.tag != null) && (paramAnonymousAddr.tag.equals(a.this.oUW.Ejm))) {
        a.this.oUW.Ejq = str;
      }
      for (;;)
      {
        if ((paramAnonymousAddr.tag != null) && (a.this.EoQ.containsKey(paramAnonymousAddr.tag)))
        {
          paramAnonymousAddr = (com.tencent.mm.plugin.location.ui.c)a.this.EoQ.get(paramAnonymousAddr.tag);
          paramAnonymousAddr.setText(paramAnonymousAddr.getPreText() + str);
        }
        AppMethodBeat.o(55997);
        return;
        if (!Util.isNullOrNil(paramAnonymousAddr.lLg)) {
          a.this.EoO.Epa.setVisibility(0);
        }
      }
    }
  };
  protected float aCa = 0.0F;
  protected float aCb = 0.0F;
  public Activity activity;
  protected int fCU = 0;
  MMHandler handler = new MMHandler(Looper.getMainLooper());
  protected ProgressDialog iXX = null;
  protected LocationInfo oUV = new LocationInfo((byte)0);
  protected LocationInfo oUW = new LocationInfo((byte)0);
  protected com.tencent.mm.plugin.location.ui.d oUX;
  protected String poiName = "";
  protected int type = 0;
  protected String uJM = "";
  protected boolean zHF = false;
  
  public a(Activity paramActivity)
  {
    this.activity = paramActivity;
    this.EoR = com.tencent.mm.modelgeo.c.bln();
  }
  
  protected static int eMW()
  {
    return a.i.location_conversation;
  }
  
  protected abstract String bwJ();
  
  protected final boolean c(LocationInfo paramLocationInfo)
  {
    if (this.EoO.ElK.getIController() == null) {}
    while (!e.i(paramLocationInfo.Ejn, paramLocationInfo.Ejo)) {
      return false;
    }
    this.EoO.ElK.getIController().animateTo(paramLocationInfo.Ejn, paramLocationInfo.Ejo);
    return true;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      Log.d("MicroMsg.BaseMapUI", "dispatchKeyEvent");
      eNa();
      this.activity.finish();
      return true;
    }
    return false;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  protected final void eMX()
  {
    if ((this.EoO.Epf == null) || (this.EoO.Epg == null)) {
      return;
    }
    this.EoO.Epf.setText(l.b(this.EoO.Epf.getContext(), this.Els, this.EoO.Epf.getTextSize()));
    if ((this.EoT == null) || (this.EoT.isEmpty()))
    {
      this.EoO.Epg.setText("");
      return;
    }
    String str1 = (String)this.EoT.get(0);
    String str2 = this.activity.getResources().getString(a.i.favorite_tag_delimiter_1);
    int i = 1;
    while (i < this.EoT.size())
    {
      str1 = str1 + str2 + (String)this.EoT.get(i);
      i += 1;
    }
    this.EoO.Epg.setText(l.b(this.EoO.Epg.getContext(), str1, this.EoO.Epg.getTextSize()));
  }
  
  protected final void eMY()
  {
    this.EoO.Epa.removeAllViews();
    View localView = View.inflate(this.activity, a.f.location_favorite, null);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    this.EoO.Epa.addView(localView, localLayoutParams);
    this.EoO.Epf = ((TextView)localView.findViewById(a.e.location_remark));
    this.EoO.Epf.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(55995);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/location/ui/impl/BaseMapUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = new Intent(a.this.activity, RemarkUI.class);
        paramAnonymousView.putExtra("key_nullable", true);
        paramAnonymousView.putExtra("key_value", a.this.eMZ());
        paramAnonymousView.putExtra("key_hint", a.this.getString(a.i.location_remark_hint));
        paramAnonymousView.putExtra("Kwebmap_locaion", a.this.oUV.Ejq);
        paramAnonymousView.putExtra("kFavInfoLocalId", a.this.activity.getIntent().getLongExtra("kFavInfoLocalId", -1L));
        paramAnonymousView.putExtra("kRemark", a.this.activity.getIntent().getStringExtra("kRemark"));
        a.this.activity.startActivityForResult(paramAnonymousView, 4096);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/location/ui/impl/BaseMapUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(55995);
      }
    });
    this.EoO.Epg = ((TextView)localView.findViewById(a.e.location_tags));
    this.EoO.Epg.setOnClickListener(new a.2(this));
    eMX();
  }
  
  protected final String eMZ()
  {
    return Util.nullAs(this.Els, "");
  }
  
  protected abstract void eNa();
  
  abstract void eNb();
  
  public boolean eNc()
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
    this.EoO.Epe = ((LinearLayout)findViewById(a.e.header_bar));
    this.EoO.ElK = ((com.tencent.mm.plugin.q.d)findViewById(a.e.g_mapView));
    this.EoO.EoZ = ((FrameLayout)findViewById(a.e.control_id));
    this.EoO.Epa = ((RelativeLayout)findViewById(a.e.tips_area));
    this.EoO.kCv = ((ImageView)findViewById(a.e.title_btn_home));
    this.EoO.Epb = ((ImageButton)findViewById(a.e.title_btn_icon));
    this.EoO.Epc = findViewById(a.e.title_btn_text);
    this.EoO.Epd = ((TextView)findViewById(a.e.action_option_text));
    this.EoO.titleView = ((TextView)findViewById(a.e.mm_action_bar_mmtitle));
    this.EoO.wrQ = ((TextView)findViewById(a.e.more_info));
    this.EoO.titleView.setText(bwJ());
    this.EoO.ElK.getIController().setZoom(com.tencent.mm.plugin.location.ui.d.eMx());
    if ((this.type != 0) && (this.type != 3))
    {
      this.EoO.Epb.setVisibility(0);
      this.EoO.Epc.setVisibility(8);
      this.EoO.Epb.setEnabled(false);
      this.EoO.Epb.setImageResource(a.h.icons_outlined_more);
    }
    this.EoO.ElK.setBuiltInZoomControls(false);
    this.EoO.kCv.setOnClickListener(new a.4(this));
    this.EoO.Epd.setOnClickListener(new a.5(this));
    eNb();
    setActionbarColor(MMApplicationContext.getResources().getColor(a.b.normal_actionbar_color));
    this.EoO.ElK.setMapAnchor(0.5F, 0.5F);
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
      } while (this.EoO.Epf == null);
      paramIntent = paramIntent.getCharSequenceExtra("key_result");
      if (paramIntent == null) {}
      for (paramIntent = "";; paramIntent = paramIntent.toString())
      {
        this.Els = paramIntent;
        eMX();
        return;
      }
    } while ((4100 != paramInt1) || (this.EoO.Epg == null));
    this.EoT = paramIntent.getStringArrayListExtra("key_fav_result_list");
    eMX();
  }
  
  public void onBackPressed()
  {
    this.activity.finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.EoW = com.tencent.mm.modelgeo.d.blq();
    Object localObject = this.oUW;
    LocationInfo localLocationInfo = this.oUV;
    paramBundle = LocaleUtil.loadApplicationLanguage(MMApplicationContext.getDefaultPreference(), this.activity);
    Log.d("MicroMsg.BaseMapUI", " initLanguage ".concat(String.valueOf(paramBundle)));
    if (paramBundle.equals("language_default"))
    {
      LocaleUtil.updateApplicationResourceLocale(this.activity, Locale.ENGLISH);
      paramBundle = "en";
      localLocationInfo.Ejr = paramBundle;
      ((LocationInfo)localObject).Ejr = paramBundle;
      Log.d("MicroMsg.BaseMapUI", "sosomap " + this.oUV.Ejr);
      this.activity.requestWindowFeature(1);
      this.activity.setContentView(a.f.gmap_ui);
      paramBundle = (FrameLayout)findViewById(a.e.mapview_content);
      localObject = (SoSoMapView)d.hq(this.activity);
      paramBundle.addView((View)localObject);
      if (!ar.isDarkMode()) {
        break label302;
      }
      ((SoSoMapView)localObject).enableDarkMode();
    }
    for (;;)
    {
      this.oUX = new com.tencent.mm.plugin.location.ui.d(this.activity);
      this.EoO = new a();
      this.Els = this.activity.getIntent().getStringExtra("kRemark");
      this.EoT = this.activity.getIntent().getStringArrayListExtra("kTags");
      this.type = this.activity.getIntent().getIntExtra("map_view_type", 0);
      this.EoM = this.activity.getIntent().getBooleanExtra("kIs_pick_poi", false);
      Log.i("MicroMsg.BaseMapUI", "isPickPoi " + this.EoM);
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
    this.EoR.a(this.EoX);
    this.EoQ.clear();
    Log.d("MicroMsg.BaseMapUI", "destroy");
    if (this.iXX != null)
    {
      this.iXX.dismiss();
      this.iXX = null;
    }
    this.EoO.ElK.destroy();
    System.gc();
  }
  
  public void onPause()
  {
    ac.d(false, new Intent().putExtra("classname", getClass().getName()));
  }
  
  public void onResume()
  {
    ac.d(true, new Intent().putExtra("classname", getClass().getName()));
  }
  
  protected final void setActionbarColor(int paramInt)
  {
    this.EoO.Epe.setBackgroundColor(paramInt);
    Boolean localBoolean = Boolean.valueOf(au.auk(paramInt));
    Object localObject;
    if (localBoolean.booleanValue())
    {
      this.EoO.kCv.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
      this.EoO.Epb.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
      this.EoO.titleView.setTextColor(MMApplicationContext.getResources().getColor(a.b.white_text_color));
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
        this.EoO.kCv.getDrawable().setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
        this.EoO.Epb.getDrawable().setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
        this.EoO.titleView.setTextColor(MMApplicationContext.getResources().getColor(a.b.black_text_color));
        break;
        label237:
        if (Build.VERSION.SDK_INT < 21) {
          break label275;
        }
        paramInt = au.A(this.activity.getResources().getColor(a.b.statusbar_fg_drak_color), paramInt);
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
    com.tencent.mm.plugin.q.d ElK;
    FrameLayout EoZ;
    RelativeLayout Epa;
    ImageButton Epb;
    View Epc;
    TextView Epd;
    LinearLayout Epe;
    TextView Epf;
    TextView Epg;
    ImageView kCv;
    TextView titleView;
    TextView wrQ;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.a
 * JD-Core Version:    0.7.0.1
 */