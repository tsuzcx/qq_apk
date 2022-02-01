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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
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
  protected int drP = 0;
  protected ProgressDialog fMu = null;
  ap handler = new ap(Looper.getMainLooper());
  protected String jDf = "";
  protected int type = 0;
  int uZt;
  DisplayMetrics upU = null;
  protected String vaL = "";
  protected String vbx;
  public String veR = "";
  protected boolean veS = false;
  public boolean veT = false;
  protected Addr veU = null;
  protected com.tencent.mm.plugin.location.ui.d veV;
  protected LocationInfo veW = new LocationInfo((byte)0);
  protected LocationInfo veX = new LocationInfo((byte)0);
  protected a veY;
  protected boolean veZ = false;
  protected HashMap<String, com.tencent.mm.plugin.location.ui.c> vfa = new HashMap();
  protected com.tencent.mm.modelgeo.c vfb;
  protected boolean vfc = false;
  protected ArrayList<String> vfd = new ArrayList();
  protected boolean vfe = false;
  protected boolean vff = false;
  protected com.tencent.mm.plugin.location.model.c vfg = null;
  protected com.tencent.mm.modelgeo.d vfh;
  public c.a vfi = new c.a()
  {
    public final void b(Addr paramAnonymousAddr)
    {
      AppMethodBeat.i(55997);
      ad.d("MicroMsg.BaseMapUI", "onGetAddrss  %s", new Object[] { paramAnonymousAddr.toString() });
      a.this.veU = paramAnonymousAddr;
      String str = paramAnonymousAddr.aHM();
      a.this.veX.dDq = a.this.activity.getResources().getString(2131760712);
      if ((paramAnonymousAddr.tag != null) && (paramAnonymousAddr.tag.equals(a.this.veX.uZq))) {
        a.this.veX.uZu = str;
      }
      for (;;)
      {
        if ((paramAnonymousAddr.tag != null) && (a.this.vfa.containsKey(paramAnonymousAddr.tag)))
        {
          paramAnonymousAddr = (com.tencent.mm.plugin.location.ui.c)a.this.vfa.get(paramAnonymousAddr.tag);
          paramAnonymousAddr.setText(paramAnonymousAddr.getPreText() + str);
        }
        AppMethodBeat.o(55997);
        return;
        if (!bt.isNullOrNil(paramAnonymousAddr.hWY)) {
          a.this.veY.vfl.setVisibility(0);
        }
      }
    }
  };
  
  public a(Activity paramActivity)
  {
    this.activity = paramActivity;
    this.vfb = com.tencent.mm.modelgeo.c.aHN();
  }
  
  protected abstract String aRw();
  
  protected final boolean c(LocationInfo paramLocationInfo)
  {
    if (this.veY.vbP.getIController() == null) {}
    while (!e.j(paramLocationInfo.uZr, paramLocationInfo.uZs)) {
      return false;
    }
    this.veY.vbP.getIController().animateTo(paramLocationInfo.uZr, paramLocationInfo.uZs);
    return true;
  }
  
  protected final void dgS()
  {
    if ((this.veY.vfq == null) || (this.veY.vfr == null)) {
      return;
    }
    this.veY.vfq.setText(k.b(this.veY.vfq.getContext(), this.vbx, this.veY.vfq.getTextSize()));
    if ((this.vfd == null) || (this.vfd.isEmpty()))
    {
      this.veY.vfr.setText("");
      return;
    }
    String str1 = (String)this.vfd.get(0);
    String str2 = this.activity.getResources().getString(2131759020);
    int i = 1;
    while (i < this.vfd.size())
    {
      str1 = str1 + str2 + (String)this.vfd.get(i);
      i += 1;
    }
    this.veY.vfr.setText(k.b(this.veY.vfr.getContext(), str1, this.veY.vfr.getTextSize()));
  }
  
  protected final void dgT()
  {
    this.veY.vfl.removeAllViews();
    View localView = View.inflate(this.activity, 2131494596, null);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    this.veY.vfl.addView(localView, localLayoutParams);
    this.veY.vfq = ((TextView)localView.findViewById(2131301538));
    this.veY.vfq.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(55995);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/location/ui/impl/BaseMapUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = new Intent(a.this.activity, RemarkUI.class);
        paramAnonymousView.putExtra("key_nullable", true);
        paramAnonymousView.putExtra("key_value", a.this.dgU());
        paramAnonymousView.putExtra("key_hint", a.this.getString(2131760726));
        paramAnonymousView.putExtra("Kwebmap_locaion", a.this.veW.uZu);
        paramAnonymousView.putExtra("kFavInfoLocalId", a.this.activity.getIntent().getLongExtra("kFavInfoLocalId", -1L));
        paramAnonymousView.putExtra("kRemark", a.this.activity.getIntent().getStringExtra("kRemark"));
        a.this.activity.startActivityForResult(paramAnonymousView, 4096);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/location/ui/impl/BaseMapUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(55995);
      }
    });
    this.veY.vfr = ((TextView)localView.findViewById(2131301543));
    this.veY.vfr.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(55996);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/location/ui/impl/BaseMapUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("key_fav_item_id", a.this.activity.getIntent().getLongExtra("kFavInfoLocalId", -1L));
        paramAnonymousView.putExtra("key_fav_result_list", a.this.activity.getIntent().getStringArrayListExtra("kTags"));
        com.tencent.mm.plugin.fav.a.b.a(a.this.activity, ".ui.FavTagEditUI", paramAnonymousView, 4100);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/location/ui/impl/BaseMapUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(55996);
      }
    });
    dgS();
  }
  
  protected final String dgU()
  {
    return bt.bI(this.vbx, "");
  }
  
  protected abstract void dgV();
  
  abstract void dgW();
  
  public boolean dgX()
  {
    return true;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      ad.d("MicroMsg.BaseMapUI", "dispatchKeyEvent");
      dgV();
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
    ad.d("MicroMsg.BaseMapUI", "initView");
    this.veY.vfp = ((LinearLayout)findViewById(2131300707));
    this.veY.vbP = ((com.tencent.mm.plugin.k.d)findViewById(2131300334));
    this.veY.vfk = ((FrameLayout)findViewById(2131298786));
    this.veY.vfl = ((RelativeLayout)findViewById(2131305886));
    this.veY.gSx = ((ImageView)findViewById(2131305914));
    this.veY.vfm = ((ImageButton)findViewById(2131305916));
    this.veY.vfn = findViewById(2131305917);
    this.veY.vfo = ((TextView)findViewById(2131296377));
    this.veY.titleView = ((TextView)findViewById(2131302293));
    this.veY.rcj = ((TextView)findViewById(2131302473));
    this.veY.titleView.setText(aRw());
    this.veY.vbP.getIController().setZoom(com.tencent.mm.plugin.location.ui.d.dgu());
    if ((this.type != 0) && (this.type != 3))
    {
      this.veY.vfm.setVisibility(0);
      this.veY.vfn.setVisibility(8);
      this.veY.vfm.setEnabled(false);
      this.veY.vfm.setImageResource(2131690603);
    }
    this.veY.vbP.setBuiltInZoomControls(false);
    this.veY.gSx.setOnClickListener(new a.4(this));
    this.veY.vfo.setOnClickListener(new a.5(this));
    dgW();
    setActionbarColor(aj.getResources().getColor(2131100705));
    this.veY.vbP.setMapAnchor(0.5F, 0.5F);
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
      } while (this.veY.vfq == null);
      paramIntent = paramIntent.getCharSequenceExtra("key_result");
      if (paramIntent == null) {}
      for (paramIntent = "";; paramIntent = paramIntent.toString())
      {
        this.vbx = paramIntent;
        dgS();
        return;
      }
    } while ((4100 != paramInt1) || (this.veY.vfr == null));
    this.vfd = paramIntent.getStringArrayListExtra("key_fav_result_list");
    dgS();
  }
  
  public void onBackPressed()
  {
    this.activity.finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.vfh = com.tencent.mm.modelgeo.d.aHQ();
    Object localObject = this.veX;
    LocationInfo localLocationInfo = this.veW;
    paramBundle = ac.f(aj.fkD());
    ad.d("MicroMsg.BaseMapUI", " initLanguage ".concat(String.valueOf(paramBundle)));
    if (paramBundle.equals("language_default"))
    {
      ac.a(this.activity, Locale.ENGLISH);
      paramBundle = "en";
      localLocationInfo.uZv = paramBundle;
      ((LocationInfo)localObject).uZv = paramBundle;
      ad.d("MicroMsg.BaseMapUI", "sosomap " + this.veW.uZv);
      this.activity.requestWindowFeature(1);
      this.activity.setContentView(2131494411);
      paramBundle = (FrameLayout)findViewById(2131302155);
      localObject = (SoSoMapView)d.fG(this.activity);
      paramBundle.addView((View)localObject);
      if (!al.isDarkMode()) {
        break label301;
      }
      ((SoSoMapView)localObject).enableDarkMode();
    }
    for (;;)
    {
      this.veV = new com.tencent.mm.plugin.location.ui.d(this.activity);
      this.veY = new a();
      this.vbx = this.activity.getIntent().getStringExtra("kRemark");
      this.vfd = this.activity.getIntent().getStringArrayListExtra("kTags");
      this.type = this.activity.getIntent().getIntExtra("map_view_type", 0);
      this.veT = this.activity.getIntent().getBooleanExtra("kIs_pick_poi", false);
      ad.i("MicroMsg.BaseMapUI", "isPickPoi " + this.veT);
      return;
      Locale localLocale = ac.aQq(paramBundle);
      ac.a(this.activity, localLocale);
      break;
      label301:
      ((SoSoMapView)localObject).disableDarkMode();
    }
  }
  
  public void onDestroy()
  {
    this.vfb.a(this.vfi);
    this.vfa.clear();
    ad.d("MicroMsg.BaseMapUI", "destroy");
    if (this.fMu != null)
    {
      this.fMu.dismiss();
      this.fMu = null;
    }
    this.veY.vbP.destroy();
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
    this.veY.vfp.setBackgroundColor(paramInt);
    Boolean localBoolean = Boolean.valueOf(ao.abX(paramInt));
    Object localObject;
    if (localBoolean.booleanValue())
    {
      this.veY.gSx.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
      this.veY.vfm.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
      this.veY.titleView.setTextColor(aj.getResources().getColor(2131101182));
      if (Build.VERSION.SDK_INT >= 21)
      {
        localObject = this.activity.getWindow();
        ((Window)localObject).clearFlags(201326592);
        ((Window)localObject).addFlags(-2147483648);
        if ((Build.VERSION.SDK_INT < 23) || (g.abl())) {
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
        this.veY.gSx.getDrawable().setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
        this.veY.vfm.getDrawable().setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
        this.veY.titleView.setTextColor(aj.getResources().getColor(2131100021));
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
    ImageView gSx;
    TextView rcj;
    TextView titleView;
    com.tencent.mm.plugin.k.d vbP;
    FrameLayout vfk;
    RelativeLayout vfl;
    ImageButton vfm;
    View vfn;
    TextView vfo;
    LinearLayout vfp;
    TextView vfq;
    TextView vfr;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.a
 * JD-Core Version:    0.7.0.1
 */