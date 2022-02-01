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
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.base.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

public abstract class a
  extends com.tencent.mm.plugin.k.a
{
  public Activity activity;
  protected int diY = 0;
  protected ProgressDialog fpP = null;
  protected String goQ = "";
  ap handler = new ap(Looper.getMainLooper());
  protected float qXK = 0.0F;
  int sOx;
  protected String sPP = "";
  protected String sQB;
  public String sTV = "";
  protected boolean sTW = false;
  public boolean sTX = false;
  protected Addr sTY = null;
  protected com.tencent.mm.plugin.location.ui.d sTZ;
  protected LocationInfo sUa = new LocationInfo((byte)0);
  protected LocationInfo sUb = new LocationInfo((byte)0);
  protected a sUc;
  protected boolean sUd = false;
  protected HashMap<String, com.tencent.mm.plugin.location.ui.c> sUe = new HashMap();
  protected com.tencent.mm.modelgeo.c sUf;
  protected boolean sUg = false;
  protected ArrayList<String> sUh = new ArrayList();
  protected boolean sUi = false;
  protected boolean sUj = false;
  protected com.tencent.mm.plugin.location.model.c sUk = null;
  protected com.tencent.mm.modelgeo.d sUl;
  public c.a sUm = new c.a()
  {
    public final void b(Addr paramAnonymousAddr)
    {
      AppMethodBeat.i(55997);
      ad.d("MicroMsg.BaseMapUI", "onGetAddrss  %s", new Object[] { paramAnonymousAddr.toString() });
      a.this.sTY = paramAnonymousAddr;
      String str = paramAnonymousAddr.axP();
      a.this.sUb.dtN = a.this.activity.getResources().getString(2131760712);
      if ((paramAnonymousAddr.tag != null) && (paramAnonymousAddr.tag.equals(a.this.sUb.sOu))) {
        a.this.sUb.sOy = str;
      }
      for (;;)
      {
        if ((paramAnonymousAddr.tag != null) && (a.this.sUe.containsKey(paramAnonymousAddr.tag)))
        {
          paramAnonymousAddr = (com.tencent.mm.plugin.location.ui.c)a.this.sUe.get(paramAnonymousAddr.tag);
          paramAnonymousAddr.setText(paramAnonymousAddr.getPreText() + str);
        }
        AppMethodBeat.o(55997);
        return;
        if (!bt.isNullOrNil(paramAnonymousAddr.hdQ)) {
          a.this.sUc.sUp.setVisibility(0);
        }
      }
    }
  };
  protected float seQ = 0.0F;
  DisplayMetrics sjE = null;
  protected int type = 0;
  
  public a(Activity paramActivity)
  {
    this.activity = paramActivity;
    this.sUf = com.tencent.mm.modelgeo.c.axQ();
  }
  
  protected abstract String aHv();
  
  protected final boolean c(LocationInfo paramLocationInfo)
  {
    if (this.sUc.sQT.getIController() == null) {}
    while (!e.j(paramLocationInfo.sOv, paramLocationInfo.sOw)) {
      return false;
    }
    this.sUc.sQT.getIController().animateTo(paramLocationInfo.sOv, paramLocationInfo.sOw);
    return true;
  }
  
  protected final void cKb()
  {
    if ((this.sUc.sUu == null) || (this.sUc.sUv == null)) {
      return;
    }
    this.sUc.sUu.setText(k.b(this.sUc.sUu.getContext(), this.sQB, this.sUc.sUu.getTextSize()));
    if ((this.sUh == null) || (this.sUh.isEmpty()))
    {
      this.sUc.sUv.setText("");
      return;
    }
    String str1 = (String)this.sUh.get(0);
    String str2 = this.activity.getResources().getString(2131759020);
    int i = 1;
    while (i < this.sUh.size())
    {
      str1 = str1 + str2 + (String)this.sUh.get(i);
      i += 1;
    }
    this.sUc.sUv.setText(k.b(this.sUc.sUv.getContext(), str1, this.sUc.sUv.getTextSize()));
  }
  
  protected final void cKc()
  {
    this.sUc.sUp.removeAllViews();
    View localView = View.inflate(this.activity, 2131494596, null);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    this.sUc.sUp.addView(localView, localLayoutParams);
    this.sUc.sUu = ((TextView)localView.findViewById(2131301538));
    this.sUc.sUu.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(55995);
        paramAnonymousView = new Intent(a.this.activity, RemarkUI.class);
        paramAnonymousView.putExtra("key_nullable", true);
        paramAnonymousView.putExtra("key_value", a.this.cKd());
        paramAnonymousView.putExtra("key_hint", a.this.getString(2131760726));
        paramAnonymousView.putExtra("Kwebmap_locaion", a.this.sUa.sOy);
        paramAnonymousView.putExtra("kFavInfoLocalId", a.this.activity.getIntent().getLongExtra("kFavInfoLocalId", -1L));
        paramAnonymousView.putExtra("kRemark", a.this.activity.getIntent().getStringExtra("kRemark"));
        a.this.activity.startActivityForResult(paramAnonymousView, 4096);
        AppMethodBeat.o(55995);
      }
    });
    this.sUc.sUv = ((TextView)localView.findViewById(2131301543));
    this.sUc.sUv.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(55996);
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("key_fav_item_id", a.this.activity.getIntent().getLongExtra("kFavInfoLocalId", -1L));
        paramAnonymousView.putExtra("key_fav_result_list", a.this.activity.getIntent().getStringArrayListExtra("kTags"));
        com.tencent.mm.plugin.fav.a.b.a(a.this.activity, ".ui.FavTagEditUI", paramAnonymousView, 4100);
        AppMethodBeat.o(55996);
      }
    });
    cKb();
  }
  
  protected final String cKd()
  {
    return bt.by(this.sQB, "");
  }
  
  protected abstract void cKe();
  
  abstract void cKf();
  
  public boolean cKg()
  {
    return true;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      ad.d("MicroMsg.BaseMapUI", "dispatchKeyEvent");
      cKe();
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
    this.sUc.sUt = ((LinearLayout)findViewById(2131300707));
    this.sUc.sQT = ((com.tencent.mm.plugin.k.d)findViewById(2131300334));
    this.sUc.sUo = ((FrameLayout)findViewById(2131298786));
    this.sUc.sUp = ((RelativeLayout)findViewById(2131305886));
    this.sUc.oPR = ((ImageView)findViewById(2131305914));
    this.sUc.sUq = ((ImageButton)findViewById(2131305916));
    this.sUc.sUr = findViewById(2131305917);
    this.sUc.sUs = ((TextView)findViewById(2131296377));
    this.sUc.titleView = ((TextView)findViewById(2131302293));
    this.sUc.sLG = ((TextView)findViewById(2131302473));
    this.sUc.titleView.setText(aHv());
    this.sUc.sQT.getIController().setZoom(com.tencent.mm.plugin.location.ui.d.cJD());
    if ((this.type != 0) && (this.type != 3))
    {
      this.sUc.sUq.setVisibility(0);
      this.sUc.sUr.setVisibility(8);
      this.sUc.sUq.setEnabled(false);
      this.sUc.sUq.setImageResource(2131690603);
    }
    this.sUc.sQT.setBuiltInZoomControls(false);
    this.sUc.oPR.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(55998);
        a.this.cKe();
        a.this.hideVKB();
        a.this.activity.finish();
        AppMethodBeat.o(55998);
      }
    });
    this.sUc.sUs.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(55999);
        AppMethodBeat.o(55999);
      }
    });
    cKf();
    setActionbarColor(aj.getResources().getColor(2131100705));
    this.sUc.sQT.setMapAnchor(0.5F, 0.5F);
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
      } while (this.sUc.sUu == null);
      paramIntent = paramIntent.getCharSequenceExtra("key_result");
      if (paramIntent == null) {}
      for (paramIntent = "";; paramIntent = paramIntent.toString())
      {
        this.sQB = paramIntent;
        cKb();
        return;
      }
    } while ((4100 != paramInt1) || (this.sUc.sUv == null));
    this.sUh = paramIntent.getStringArrayListExtra("key_fav_result_list");
    cKb();
  }
  
  public void onBackPressed()
  {
    this.activity.finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.sUl = com.tencent.mm.modelgeo.d.axT();
    Object localObject = this.sUb;
    LocationInfo localLocationInfo = this.sUa;
    paramBundle = ac.f(aj.eFE());
    ad.d("MicroMsg.BaseMapUI", " initLanguage ".concat(String.valueOf(paramBundle)));
    if (paramBundle.equals("language_default"))
    {
      ac.a(this.activity, Locale.ENGLISH);
      paramBundle = "en";
      localLocationInfo.sOz = paramBundle;
      ((LocationInfo)localObject).sOz = paramBundle;
      ad.d("MicroMsg.BaseMapUI", "sosomap " + this.sUa.sOz);
      this.activity.requestWindowFeature(1);
      this.activity.setContentView(2131494411);
      paramBundle = (FrameLayout)findViewById(2131302155);
      localObject = (SoSoMapView)d.fp(this.activity);
      paramBundle.addView((View)localObject);
      if (!ai.Eq()) {
        break label301;
      }
      ((SoSoMapView)localObject).enableDarkMode();
    }
    for (;;)
    {
      this.sTZ = new com.tencent.mm.plugin.location.ui.d(this.activity);
      this.sUc = new a();
      this.sQB = this.activity.getIntent().getStringExtra("kRemark");
      this.sUh = this.activity.getIntent().getStringArrayListExtra("kTags");
      this.type = this.activity.getIntent().getIntExtra("map_view_type", 0);
      this.sTX = this.activity.getIntent().getBooleanExtra("kIs_pick_poi", false);
      ad.i("MicroMsg.BaseMapUI", "isPickPoi " + this.sTX);
      return;
      Locale localLocale = ac.aFt(paramBundle);
      ac.a(this.activity, localLocale);
      break;
      label301:
      ((SoSoMapView)localObject).disableDarkMode();
    }
  }
  
  public void onDestroy()
  {
    this.sUf.a(this.sUm);
    this.sUe.clear();
    ad.d("MicroMsg.BaseMapUI", "destroy");
    if (this.fpP != null)
    {
      this.fpP.dismiss();
      this.fpP = null;
    }
    this.sUc.sQT.destroy();
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
    this.sUc.sUt.setBackgroundColor(paramInt);
    Boolean localBoolean = Boolean.valueOf(am.XC(paramInt));
    Object localObject;
    if (localBoolean.booleanValue())
    {
      this.sUc.oPR.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
      this.sUc.sUq.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
      this.sUc.titleView.setTextColor(aj.getResources().getColor(2131101182));
      if (Build.VERSION.SDK_INT >= 21)
      {
        localObject = this.activity.getWindow();
        ((Window)localObject).clearFlags(201326592);
        ((Window)localObject).addFlags(-2147483648);
        if ((Build.VERSION.SDK_INT < 23) || (g.XM())) {
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
        this.sUc.oPR.getDrawable().setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
        this.sUc.sUq.getDrawable().setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
        this.sUc.titleView.setTextColor(aj.getResources().getColor(2131100021));
        break;
        label237:
        if (Build.VERSION.SDK_INT < 21) {
          break label275;
        }
        paramInt = am.o(this.activity.getResources().getColor(2131100954), paramInt);
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
    ImageView oPR;
    TextView sLG;
    com.tencent.mm.plugin.k.d sQT;
    FrameLayout sUo;
    RelativeLayout sUp;
    ImageButton sUq;
    View sUr;
    TextView sUs;
    LinearLayout sUt;
    TextView sUu;
    TextView sUv;
    TextView titleView;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.a
 * JD-Core Version:    0.7.0.1
 */