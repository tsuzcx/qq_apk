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
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.c.a;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location.model.e;
import com.tencent.mm.plugin.location_soso.api.SoSoMapView;
import com.tencent.mm.plugin.map.a.b;
import com.tencent.mm.plugin.map.a.e;
import com.tencent.mm.plugin.map.a.f;
import com.tencent.mm.plugin.map.a.h;
import com.tencent.mm.plugin.map.a.i;
import com.tencent.mm.plugin.p.b;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sensitive.d.c;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.ag;
import com.tencent.mm.ui.bb;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

public abstract class a
  extends com.tencent.mm.plugin.p.a
{
  protected boolean EPh = false;
  DisplayMetrics IRP = null;
  int KbY;
  protected String Keb;
  protected boolean KhA = false;
  protected com.tencent.mm.plugin.location.model.c KhB = null;
  protected SoSoMapView KhC;
  protected com.tencent.mm.modelgeo.d KhD;
  public c.a KhE = new c.a()
  {
    public final void b(Addr paramAnonymousAddr)
    {
      AppMethodBeat.i(55997);
      Log.d("MicroMsg.BaseMapUI", "onGetAddrss  %s", new Object[] { paramAnonymousAddr.toString() });
      a.this.Kht = paramAnonymousAddr;
      String str = paramAnonymousAddr.bJg();
      a.this.saj.hVI = a.this.activity.getResources().getString(a.fVp());
      if ((paramAnonymousAddr.tag != null) && (paramAnonymousAddr.tag.equals(a.this.saj.KbV))) {
        a.this.saj.KbZ = str;
      }
      for (;;)
      {
        if ((paramAnonymousAddr.tag != null) && (a.this.Khw.containsKey(paramAnonymousAddr.tag)))
        {
          paramAnonymousAddr = (com.tencent.mm.plugin.location.ui.c)a.this.Khw.get(paramAnonymousAddr.tag);
          paramAnonymousAddr.setText(paramAnonymousAddr.getPreText() + str);
        }
        AppMethodBeat.o(55997);
        return;
        if (!Util.isNullOrNil(paramAnonymousAddr.oDI)) {
          a.this.Khu.KhH.setVisibility(0);
        }
      }
    }
  };
  public String Khq = "";
  protected boolean Khr = false;
  public boolean Khs = false;
  protected Addr Kht = null;
  protected a Khu;
  protected boolean Khv = false;
  protected HashMap<String, com.tencent.mm.plugin.location.ui.c> Khw = new HashMap();
  protected com.tencent.mm.modelgeo.c Khx;
  protected boolean Khy = false;
  protected ArrayList<String> Khz = new ArrayList();
  public Activity activity;
  protected float cxM = 0.0F;
  protected float cxN = 0.0F;
  protected int hHJ = 0;
  MMHandler handler = new MMHandler(Looper.getMainLooper());
  protected ProgressDialog lzP = null;
  protected String mpr = "";
  protected String poiName = "";
  protected LocationInfo sai = new LocationInfo((byte)0);
  protected LocationInfo saj = new LocationInfo((byte)0);
  protected com.tencent.mm.plugin.location.ui.d sak;
  protected int type = 0;
  
  public a(Activity paramActivity)
  {
    this.activity = paramActivity;
    this.Khx = com.tencent.mm.modelgeo.c.bJh();
  }
  
  protected static int fVp()
  {
    return a.i.location_conversation;
  }
  
  protected abstract String bVz();
  
  protected final boolean c(LocationInfo paramLocationInfo)
  {
    if (this.Khu.Ket.getIController() == null) {}
    while (!e.m(paramLocationInfo.KbW, paramLocationInfo.KbX)) {
      return false;
    }
    this.Khu.Ket.getIController().animateTo(paramLocationInfo.KbW, paramLocationInfo.KbX);
    return true;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      Log.d("MicroMsg.BaseMapUI", "dispatchKeyEvent");
      fVt();
      this.activity.finish();
      return true;
    }
    return false;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  protected final void fVq()
  {
    if ((this.Khu.KhM == null) || (this.Khu.KhN == null)) {
      return;
    }
    this.Khu.KhM.setText(p.b(this.Khu.KhM.getContext(), this.Keb, this.Khu.KhM.getTextSize()));
    if ((this.Khz == null) || (this.Khz.isEmpty()))
    {
      this.Khu.KhN.setText("");
      return;
    }
    String str1 = (String)this.Khz.get(0);
    String str2 = this.activity.getResources().getString(a.i.favorite_tag_delimiter_1);
    int i = 1;
    while (i < this.Khz.size())
    {
      str1 = str1 + str2 + (String)this.Khz.get(i);
      i += 1;
    }
    this.Khu.KhN.setText(p.b(this.Khu.KhN.getContext(), str1, this.Khu.KhN.getTextSize()));
  }
  
  protected final void fVr()
  {
    this.Khu.KhH.removeAllViews();
    View localView = View.inflate(this.activity, a.f.location_favorite, null);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    this.Khu.KhH.addView(localView, localLayoutParams);
    this.Khu.KhM = ((TextView)localView.findViewById(a.e.location_remark));
    this.Khu.KhM.setOnClickListener(new a.1(this));
    this.Khu.KhN = ((TextView)localView.findViewById(a.e.location_tags));
    this.Khu.KhN.setOnClickListener(new a.2(this));
    fVq();
  }
  
  protected final String fVs()
  {
    return Util.nullAs(this.Keb, "");
  }
  
  protected abstract void fVt();
  
  abstract void fVu();
  
  public boolean fVv()
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
    this.Khu.KhL = ((LinearLayout)findViewById(a.e.header_bar));
    this.Khu.Ket = this.KhC;
    this.Khu.KhG = ((FrameLayout)findViewById(a.e.control_id));
    this.Khu.KhH = ((RelativeLayout)findViewById(a.e.tips_area));
    this.Khu.nfU = ((ImageView)findViewById(a.e.title_btn_home));
    this.Khu.KhI = ((ImageButton)findViewById(a.e.title_btn_icon));
    this.Khu.KhJ = findViewById(a.e.title_btn_text);
    this.Khu.KhK = ((TextView)findViewById(a.e.action_option_text));
    this.Khu.titleView = ((TextView)findViewById(a.e.mm_action_bar_mmtitle));
    this.Khu.zNW = ((TextView)findViewById(a.e.more_info));
    this.Khu.titleView.setText(bVz());
    this.Khu.Ket.getIController().setZoom(com.tencent.mm.plugin.location.ui.d.fUQ());
    if ((this.type != 0) && (this.type != 3))
    {
      this.Khu.KhI.setVisibility(0);
      this.Khu.KhJ.setVisibility(8);
      this.Khu.KhI.setEnabled(false);
      this.Khu.KhI.setImageResource(a.h.icons_outlined_more);
    }
    this.Khu.Ket.setBuiltInZoomControls(false);
    this.Khu.nfU.setOnClickListener(new a.4(this));
    this.Khu.KhK.setOnClickListener(new a.5(this));
    fVu();
    setActionbarColor(MMApplicationContext.getResources().getColor(a.b.normal_actionbar_color));
    this.Khu.Ket.setMapAnchor(0.5F, 0.5F);
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
      } while (this.Khu.KhM == null);
      paramIntent = paramIntent.getCharSequenceExtra("key_result");
      if (paramIntent == null) {}
      for (paramIntent = "";; paramIntent = paramIntent.toString())
      {
        this.Keb = paramIntent;
        fVq();
        return;
      }
    } while ((4100 != paramInt1) || (this.Khu.KhN == null));
    this.Khz = paramIntent.getStringArrayListExtra("key_fav_result_list");
    fVq();
  }
  
  public void onBackPressed()
  {
    this.activity.finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.KhD = com.tencent.mm.modelgeo.d.bJl();
    LocationInfo localLocationInfo1 = this.saj;
    LocationInfo localLocationInfo2 = this.sai;
    paramBundle = LocaleUtil.loadApplicationLanguage(MMApplicationContext.getDefaultPreference(), this.activity);
    Log.d("MicroMsg.BaseMapUI", " initLanguage ".concat(String.valueOf(paramBundle)));
    if (paramBundle.equals("language_default"))
    {
      LocaleUtil.updateApplicationResourceLocale(this.activity, Locale.ENGLISH);
      paramBundle = "en";
      localLocationInfo2.Kca = paramBundle;
      localLocationInfo1.Kca = paramBundle;
      Log.d("MicroMsg.BaseMapUI", "sosomap " + this.sai.Kca);
      this.activity.requestWindowFeature(1);
      this.activity.setContentView(a.f.gmap_ui);
      paramBundle = (FrameLayout)findViewById(a.e.mapview_content);
      this.KhC = d.iL(this.activity);
      if (((com.tencent.mm.sensitive.d)h.az(com.tencent.mm.sensitive.d.class)).checkBusinessPermission(d.c.actu, null)) {
        paramBundle.addView(this.KhC);
      }
      if (!aw.isDarkMode()) {
        break label329;
      }
      this.KhC.enableDarkMode();
    }
    for (;;)
    {
      this.sak = new com.tencent.mm.plugin.location.ui.d(this.activity);
      this.Khu = new a();
      this.Keb = this.activity.getIntent().getStringExtra("kRemark");
      this.Khz = this.activity.getIntent().getStringArrayListExtra("kTags");
      this.type = this.activity.getIntent().getIntExtra("map_view_type", 0);
      this.Khs = this.activity.getIntent().getBooleanExtra("kIs_pick_poi", false);
      Log.i("MicroMsg.BaseMapUI", "isPickPoi " + this.Khs);
      return;
      Locale localLocale = LocaleUtil.transLanguageToLocale(paramBundle);
      LocaleUtil.updateApplicationResourceLocale(this.activity, localLocale);
      break;
      label329:
      this.KhC.disableDarkMode();
    }
  }
  
  public void onDestroy()
  {
    this.Khx.a(this.KhE);
    this.Khw.clear();
    Log.d("MicroMsg.BaseMapUI", "destroy");
    if (this.lzP != null)
    {
      this.lzP.dismiss();
      this.lzP = null;
    }
    this.Khu.Ket.destroy();
    System.gc();
  }
  
  public void onPause()
  {
    ag.d(false, new Intent().putExtra("classname", getClass().getName()));
  }
  
  public void onResume()
  {
    ag.d(true, new Intent().putExtra("classname", getClass().getName()));
  }
  
  protected final void setActionbarColor(int paramInt)
  {
    this.Khu.KhL.setBackgroundColor(paramInt);
    Boolean localBoolean = Boolean.valueOf(bb.aAF(paramInt));
    Object localObject;
    if (localBoolean.booleanValue())
    {
      this.Khu.nfU.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
      this.Khu.KhI.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
      this.Khu.titleView.setTextColor(MMApplicationContext.getResources().getColor(a.b.white_text_color));
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
        this.Khu.nfU.getDrawable().setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
        this.Khu.KhI.getDrawable().setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
        this.Khu.titleView.setTextColor(MMApplicationContext.getResources().getColor(a.b.black_text_color));
        break;
        label237:
        if (Build.VERSION.SDK_INT < 21) {
          break label275;
        }
        paramInt = bb.av(this.activity.getResources().getColor(a.b.statusbar_fg_drak_color), paramInt);
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
    com.tencent.mm.plugin.p.d Ket;
    FrameLayout KhG;
    RelativeLayout KhH;
    ImageButton KhI;
    View KhJ;
    TextView KhK;
    LinearLayout KhL;
    TextView KhM;
    TextView KhN;
    ImageView nfU;
    TextView titleView;
    TextView zNW;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.a
 * JD-Core Version:    0.7.0.1
 */