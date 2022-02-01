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
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

public abstract class a
  extends com.tencent.mm.plugin.k.a
{
  protected float aTL = 0.0F;
  protected float aTM = 0.0F;
  public Activity activity;
  protected int dsV = 0;
  protected ProgressDialog fOC = null;
  aq handler = new aq(Looper.getMainLooper());
  protected String jGd = "";
  protected LocationInfo kSe = new LocationInfo((byte)0);
  protected LocationInfo kSf = new LocationInfo((byte)0);
  protected com.tencent.mm.plugin.location.ui.d kSg;
  protected int type = 0;
  DisplayMetrics uBq = null;
  int vlE;
  protected String vmW = "";
  protected String vnI;
  public String vrb = "";
  protected boolean vrc = false;
  public boolean vrd = false;
  protected Addr vre = null;
  protected a vrf;
  protected boolean vrg = false;
  protected HashMap<String, com.tencent.mm.plugin.location.ui.c> vrh = new HashMap();
  protected com.tencent.mm.modelgeo.c vri;
  protected boolean vrj = false;
  protected ArrayList<String> vrk = new ArrayList();
  protected boolean vrl = false;
  protected boolean vrm = false;
  protected com.tencent.mm.plugin.location.model.c vrn = null;
  protected com.tencent.mm.modelgeo.d vro;
  public c.a vrp = new c.a()
  {
    public final void b(Addr paramAnonymousAddr)
    {
      AppMethodBeat.i(55997);
      ae.d("MicroMsg.BaseMapUI", "onGetAddrss  %s", new Object[] { paramAnonymousAddr.toString() });
      a.this.vre = paramAnonymousAddr;
      String str = paramAnonymousAddr.aId();
      a.this.kSf.dEv = a.this.activity.getResources().getString(2131760712);
      if ((paramAnonymousAddr.tag != null) && (paramAnonymousAddr.tag.equals(a.this.kSf.vlB))) {
        a.this.kSf.vlF = str;
      }
      for (;;)
      {
        if ((paramAnonymousAddr.tag != null) && (a.this.vrh.containsKey(paramAnonymousAddr.tag)))
        {
          paramAnonymousAddr = (com.tencent.mm.plugin.location.ui.c)a.this.vrh.get(paramAnonymousAddr.tag);
          paramAnonymousAddr.setText(paramAnonymousAddr.getPreText() + str);
        }
        AppMethodBeat.o(55997);
        return;
        if (!bu.isNullOrNil(paramAnonymousAddr.hZQ)) {
          a.this.vrf.vrs.setVisibility(0);
        }
      }
    }
  };
  
  public a(Activity paramActivity)
  {
    this.activity = paramActivity;
    this.vri = com.tencent.mm.modelgeo.c.aIe();
  }
  
  protected abstract String aRV();
  
  protected final boolean c(LocationInfo paramLocationInfo)
  {
    if (this.vrf.voa.getIController() == null) {}
    while (!e.j(paramLocationInfo.vlC, paramLocationInfo.vlD)) {
      return false;
    }
    this.vrf.voa.getIController().animateTo(paramLocationInfo.vlC, paramLocationInfo.vlD);
    return true;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      ae.d("MicroMsg.BaseMapUI", "dispatchKeyEvent");
      djU();
      this.activity.finish();
      return true;
    }
    return false;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  protected final void djR()
  {
    if ((this.vrf.vrx == null) || (this.vrf.vry == null)) {
      return;
    }
    this.vrf.vrx.setText(k.b(this.vrf.vrx.getContext(), this.vnI, this.vrf.vrx.getTextSize()));
    if ((this.vrk == null) || (this.vrk.isEmpty()))
    {
      this.vrf.vry.setText("");
      return;
    }
    String str1 = (String)this.vrk.get(0);
    String str2 = this.activity.getResources().getString(2131759020);
    int i = 1;
    while (i < this.vrk.size())
    {
      str1 = str1 + str2 + (String)this.vrk.get(i);
      i += 1;
    }
    this.vrf.vry.setText(k.b(this.vrf.vry.getContext(), str1, this.vrf.vry.getTextSize()));
  }
  
  protected final void djS()
  {
    this.vrf.vrs.removeAllViews();
    View localView = View.inflate(this.activity, 2131494596, null);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    this.vrf.vrs.addView(localView, localLayoutParams);
    this.vrf.vrx = ((TextView)localView.findViewById(2131301538));
    this.vrf.vrx.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(55995);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/location/ui/impl/BaseMapUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramAnonymousView = new Intent(a.this.activity, RemarkUI.class);
        paramAnonymousView.putExtra("key_nullable", true);
        paramAnonymousView.putExtra("key_value", a.this.djT());
        paramAnonymousView.putExtra("key_hint", a.this.getString(2131760726));
        paramAnonymousView.putExtra("Kwebmap_locaion", a.this.kSe.vlF);
        paramAnonymousView.putExtra("kFavInfoLocalId", a.this.activity.getIntent().getLongExtra("kFavInfoLocalId", -1L));
        paramAnonymousView.putExtra("kRemark", a.this.activity.getIntent().getStringExtra("kRemark"));
        a.this.activity.startActivityForResult(paramAnonymousView, 4096);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/location/ui/impl/BaseMapUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(55995);
      }
    });
    this.vrf.vry = ((TextView)localView.findViewById(2131301543));
    this.vrf.vry.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(55996);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/location/ui/impl/BaseMapUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("key_fav_item_id", a.this.activity.getIntent().getLongExtra("kFavInfoLocalId", -1L));
        paramAnonymousView.putExtra("key_fav_result_list", a.this.activity.getIntent().getStringArrayListExtra("kTags"));
        com.tencent.mm.plugin.fav.a.b.a(a.this.activity, ".ui.FavTagEditUI", paramAnonymousView, 4100);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/location/ui/impl/BaseMapUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(55996);
      }
    });
    djR();
  }
  
  protected final String djT()
  {
    return bu.bI(this.vnI, "");
  }
  
  protected abstract void djU();
  
  abstract void djV();
  
  public boolean djW()
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
    ae.d("MicroMsg.BaseMapUI", "initView");
    this.vrf.vrw = ((LinearLayout)findViewById(2131300707));
    this.vrf.voa = ((com.tencent.mm.plugin.k.d)findViewById(2131300334));
    this.vrf.vrr = ((FrameLayout)findViewById(2131298786));
    this.vrf.vrs = ((RelativeLayout)findViewById(2131305886));
    this.vrf.gVf = ((ImageView)findViewById(2131305914));
    this.vrf.vrt = ((ImageButton)findViewById(2131305916));
    this.vrf.vru = findViewById(2131305917);
    this.vrf.vrv = ((TextView)findViewById(2131296377));
    this.vrf.titleView = ((TextView)findViewById(2131302293));
    this.vrf.rkp = ((TextView)findViewById(2131302473));
    this.vrf.titleView.setText(aRV());
    this.vrf.voa.getIController().setZoom(com.tencent.mm.plugin.location.ui.d.djt());
    if ((this.type != 0) && (this.type != 3))
    {
      this.vrf.vrt.setVisibility(0);
      this.vrf.vru.setVisibility(8);
      this.vrf.vrt.setEnabled(false);
      this.vrf.vrt.setImageResource(2131690603);
    }
    this.vrf.voa.setBuiltInZoomControls(false);
    this.vrf.gVf.setOnClickListener(new a.4(this));
    this.vrf.vrv.setOnClickListener(new a.5(this));
    djV();
    setActionbarColor(ak.getResources().getColor(2131100705));
    this.vrf.voa.setMapAnchor(0.5F, 0.5F);
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
      } while (this.vrf.vrx == null);
      paramIntent = paramIntent.getCharSequenceExtra("key_result");
      if (paramIntent == null) {}
      for (paramIntent = "";; paramIntent = paramIntent.toString())
      {
        this.vnI = paramIntent;
        djR();
        return;
      }
    } while ((4100 != paramInt1) || (this.vrf.vry == null));
    this.vrk = paramIntent.getStringArrayListExtra("key_fav_result_list");
    djR();
  }
  
  public void onBackPressed()
  {
    this.activity.finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.vro = com.tencent.mm.modelgeo.d.aIh();
    Object localObject = this.kSf;
    LocationInfo localLocationInfo = this.kSe;
    paramBundle = ad.f(ak.fox());
    ae.d("MicroMsg.BaseMapUI", " initLanguage ".concat(String.valueOf(paramBundle)));
    if (paramBundle.equals("language_default"))
    {
      ad.a(this.activity, Locale.ENGLISH);
      paramBundle = "en";
      localLocationInfo.vlG = paramBundle;
      ((LocationInfo)localObject).vlG = paramBundle;
      ae.d("MicroMsg.BaseMapUI", "sosomap " + this.kSe.vlG);
      this.activity.requestWindowFeature(1);
      this.activity.setContentView(2131494411);
      paramBundle = (FrameLayout)findViewById(2131302155);
      localObject = (SoSoMapView)d.fM(this.activity);
      paramBundle.addView((View)localObject);
      if (!al.isDarkMode()) {
        break label298;
      }
      ((SoSoMapView)localObject).enableDarkMode();
    }
    for (;;)
    {
      this.kSg = new com.tencent.mm.plugin.location.ui.d(this.activity);
      this.vrf = new a();
      this.vnI = this.activity.getIntent().getStringExtra("kRemark");
      this.vrk = this.activity.getIntent().getStringArrayListExtra("kTags");
      this.type = this.activity.getIntent().getIntExtra("map_view_type", 0);
      this.vrd = this.activity.getIntent().getBooleanExtra("kIs_pick_poi", false);
      ae.i("MicroMsg.BaseMapUI", "isPickPoi " + this.vrd);
      return;
      Locale localLocale = ad.aRN(paramBundle);
      ad.a(this.activity, localLocale);
      break;
      label298:
      ((SoSoMapView)localObject).disableDarkMode();
    }
  }
  
  public void onDestroy()
  {
    this.vri.a(this.vrp);
    this.vrh.clear();
    ae.d("MicroMsg.BaseMapUI", "destroy");
    if (this.fOC != null)
    {
      this.fOC.dismiss();
      this.fOC = null;
    }
    this.vrf.voa.destroy();
    System.gc();
  }
  
  public void onPause()
  {
    y.d(false, new Intent().putExtra("classname", getClass().getName()));
  }
  
  public void onResume()
  {
    y.d(true, new Intent().putExtra("classname", getClass().getName()));
  }
  
  protected final void setActionbarColor(int paramInt)
  {
    this.vrf.vrw.setBackgroundColor(paramInt);
    Boolean localBoolean = Boolean.valueOf(ao.acF(paramInt));
    Object localObject;
    if (localBoolean.booleanValue())
    {
      this.vrf.gVf.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
      this.vrf.vrt.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
      this.vrf.titleView.setTextColor(ak.getResources().getColor(2131101182));
      if (Build.VERSION.SDK_INT >= 21)
      {
        localObject = this.activity.getWindow();
        ((Window)localObject).clearFlags(201326592);
        ((Window)localObject).addFlags(-2147483648);
        if ((Build.VERSION.SDK_INT < 23) || (g.abu())) {
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
        this.vrf.gVf.getDrawable().setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
        this.vrf.vrt.getDrawable().setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
        this.vrf.titleView.setTextColor(ak.getResources().getColor(2131100021));
        break;
        label237:
        if (Build.VERSION.SDK_INT < 21) {
          break label275;
        }
        paramInt = ao.v(this.activity.getResources().getColor(2131100954), paramInt);
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
    ImageView gVf;
    TextView rkp;
    TextView titleView;
    com.tencent.mm.plugin.k.d voa;
    FrameLayout vrr;
    RelativeLayout vrs;
    ImageButton vrt;
    View vru;
    TextView vrv;
    LinearLayout vrw;
    TextView vrx;
    TextView vry;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.a
 * JD-Core Version:    0.7.0.1
 */