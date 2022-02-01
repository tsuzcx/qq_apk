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
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.base.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

public abstract class a
  extends com.tencent.mm.plugin.k.a
{
  public Activity activity;
  protected int dgt = 0;
  protected ProgressDialog fts = null;
  protected String gPy = "";
  ao handler = new ao(Looper.getMainLooper());
  protected float rYu = 0.0F;
  int tWK;
  protected String tYO;
  protected String tYc = "";
  protected float tmJ = 0.0F;
  DisplayMetrics trx = null;
  protected int type = 0;
  public String uch = "";
  protected boolean uci = false;
  public boolean ucj = false;
  protected Addr uck = null;
  protected com.tencent.mm.plugin.location.ui.d ucl;
  protected LocationInfo ucm = new LocationInfo((byte)0);
  protected LocationInfo ucn = new LocationInfo((byte)0);
  protected a uco;
  protected boolean ucp = false;
  protected HashMap<String, com.tencent.mm.plugin.location.ui.c> ucq = new HashMap();
  protected com.tencent.mm.modelgeo.c ucr;
  protected boolean ucs = false;
  protected ArrayList<String> uct = new ArrayList();
  protected boolean ucu = false;
  protected boolean ucv = false;
  protected com.tencent.mm.plugin.location.model.c ucw = null;
  protected com.tencent.mm.modelgeo.d ucx;
  public c.a ucy = new c.a()
  {
    public final void b(Addr paramAnonymousAddr)
    {
      AppMethodBeat.i(55997);
      ac.d("MicroMsg.BaseMapUI", "onGetAddrss  %s", new Object[] { paramAnonymousAddr.toString() });
      a.this.uck = paramAnonymousAddr;
      String str = paramAnonymousAddr.aEH();
      a.this.ucn.dry = a.this.activity.getResources().getString(2131760712);
      if ((paramAnonymousAddr.tag != null) && (paramAnonymousAddr.tag.equals(a.this.ucn.tWH))) {
        a.this.ucn.tWL = str;
      }
      for (;;)
      {
        if ((paramAnonymousAddr.tag != null) && (a.this.ucq.containsKey(paramAnonymousAddr.tag)))
        {
          paramAnonymousAddr = (com.tencent.mm.plugin.location.ui.c)a.this.ucq.get(paramAnonymousAddr.tag);
          paramAnonymousAddr.setText(paramAnonymousAddr.getPreText() + str);
        }
        AppMethodBeat.o(55997);
        return;
        if (!bs.isNullOrNil(paramAnonymousAddr.hEt)) {
          a.this.uco.ucB.setVisibility(0);
        }
      }
    }
  };
  
  public a(Activity paramActivity)
  {
    this.activity = paramActivity;
    this.ucr = com.tencent.mm.modelgeo.c.aEI();
  }
  
  protected abstract String aOk();
  
  protected final boolean c(LocationInfo paramLocationInfo)
  {
    if (this.uco.tZg.getIController() == null) {}
    while (!e.j(paramLocationInfo.tWI, paramLocationInfo.tWJ)) {
      return false;
    }
    this.uco.tZg.getIController().animateTo(paramLocationInfo.tWI, paramLocationInfo.tWJ);
    return true;
  }
  
  protected final void cXG()
  {
    if ((this.uco.ucG == null) || (this.uco.ucH == null)) {
      return;
    }
    this.uco.ucG.setText(k.b(this.uco.ucG.getContext(), this.tYO, this.uco.ucG.getTextSize()));
    if ((this.uct == null) || (this.uct.isEmpty()))
    {
      this.uco.ucH.setText("");
      return;
    }
    String str1 = (String)this.uct.get(0);
    String str2 = this.activity.getResources().getString(2131759020);
    int i = 1;
    while (i < this.uct.size())
    {
      str1 = str1 + str2 + (String)this.uct.get(i);
      i += 1;
    }
    this.uco.ucH.setText(k.b(this.uco.ucH.getContext(), str1, this.uco.ucH.getTextSize()));
  }
  
  protected final void cXH()
  {
    this.uco.ucB.removeAllViews();
    View localView = View.inflate(this.activity, 2131494596, null);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    this.uco.ucB.addView(localView, localLayoutParams);
    this.uco.ucG = ((TextView)localView.findViewById(2131301538));
    this.uco.ucG.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(55995);
        paramAnonymousView = new Intent(a.this.activity, RemarkUI.class);
        paramAnonymousView.putExtra("key_nullable", true);
        paramAnonymousView.putExtra("key_value", a.this.cXI());
        paramAnonymousView.putExtra("key_hint", a.this.getString(2131760726));
        paramAnonymousView.putExtra("Kwebmap_locaion", a.this.ucm.tWL);
        paramAnonymousView.putExtra("kFavInfoLocalId", a.this.activity.getIntent().getLongExtra("kFavInfoLocalId", -1L));
        paramAnonymousView.putExtra("kRemark", a.this.activity.getIntent().getStringExtra("kRemark"));
        a.this.activity.startActivityForResult(paramAnonymousView, 4096);
        AppMethodBeat.o(55995);
      }
    });
    this.uco.ucH = ((TextView)localView.findViewById(2131301543));
    this.uco.ucH.setOnClickListener(new View.OnClickListener()
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
    cXG();
  }
  
  protected final String cXI()
  {
    return bs.bG(this.tYO, "");
  }
  
  protected abstract void cXJ();
  
  abstract void cXK();
  
  public boolean cXL()
  {
    return true;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      ac.d("MicroMsg.BaseMapUI", "dispatchKeyEvent");
      cXJ();
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
    ac.d("MicroMsg.BaseMapUI", "initView");
    this.uco.ucF = ((LinearLayout)findViewById(2131300707));
    this.uco.tZg = ((com.tencent.mm.plugin.k.d)findViewById(2131300334));
    this.uco.ucA = ((FrameLayout)findViewById(2131298786));
    this.uco.ucB = ((RelativeLayout)findViewById(2131305886));
    this.uco.gyM = ((ImageView)findViewById(2131305914));
    this.uco.ucC = ((ImageButton)findViewById(2131305916));
    this.uco.ucD = findViewById(2131305917);
    this.uco.ucE = ((TextView)findViewById(2131296377));
    this.uco.titleView = ((TextView)findViewById(2131302293));
    this.uco.tTl = ((TextView)findViewById(2131302473));
    this.uco.titleView.setText(aOk());
    this.uco.tZg.getIController().setZoom(com.tencent.mm.plugin.location.ui.d.cXi());
    if ((this.type != 0) && (this.type != 3))
    {
      this.uco.ucC.setVisibility(0);
      this.uco.ucD.setVisibility(8);
      this.uco.ucC.setEnabled(false);
      this.uco.ucC.setImageResource(2131690603);
    }
    this.uco.tZg.setBuiltInZoomControls(false);
    this.uco.gyM.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(55998);
        a.this.cXJ();
        a.this.hideVKB();
        a.this.activity.finish();
        AppMethodBeat.o(55998);
      }
    });
    this.uco.ucE.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(55999);
        AppMethodBeat.o(55999);
      }
    });
    cXK();
    setActionbarColor(ai.getResources().getColor(2131100705));
    this.uco.tZg.setMapAnchor(0.5F, 0.5F);
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
      } while (this.uco.ucG == null);
      paramIntent = paramIntent.getCharSequenceExtra("key_result");
      if (paramIntent == null) {}
      for (paramIntent = "";; paramIntent = paramIntent.toString())
      {
        this.tYO = paramIntent;
        cXG();
        return;
      }
    } while ((4100 != paramInt1) || (this.uco.ucH == null));
    this.uct = paramIntent.getStringArrayListExtra("key_fav_result_list");
    cXG();
  }
  
  public void onBackPressed()
  {
    this.activity.finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.ucx = com.tencent.mm.modelgeo.d.aEL();
    Object localObject = this.ucn;
    LocationInfo localLocationInfo = this.ucm;
    paramBundle = ab.f(ai.eUY());
    ac.d("MicroMsg.BaseMapUI", " initLanguage ".concat(String.valueOf(paramBundle)));
    if (paramBundle.equals("language_default"))
    {
      ab.a(this.activity, Locale.ENGLISH);
      paramBundle = "en";
      localLocationInfo.tWM = paramBundle;
      ((LocationInfo)localObject).tWM = paramBundle;
      ac.d("MicroMsg.BaseMapUI", "sosomap " + this.ucm.tWM);
      this.activity.requestWindowFeature(1);
      this.activity.setContentView(2131494411);
      paramBundle = (FrameLayout)findViewById(2131302155);
      localObject = (SoSoMapView)d.fB(this.activity);
      paramBundle.addView((View)localObject);
      if (!aj.DT()) {
        break label301;
      }
      ((SoSoMapView)localObject).enableDarkMode();
    }
    for (;;)
    {
      this.ucl = new com.tencent.mm.plugin.location.ui.d(this.activity);
      this.uco = new a();
      this.tYO = this.activity.getIntent().getStringExtra("kRemark");
      this.uct = this.activity.getIntent().getStringArrayListExtra("kTags");
      this.type = this.activity.getIntent().getIntExtra("map_view_type", 0);
      this.ucj = this.activity.getIntent().getBooleanExtra("kIs_pick_poi", false);
      ac.i("MicroMsg.BaseMapUI", "isPickPoi " + this.ucj);
      return;
      Locale localLocale = ab.aKK(paramBundle);
      ab.a(this.activity, localLocale);
      break;
      label301:
      ((SoSoMapView)localObject).disableDarkMode();
    }
  }
  
  public void onDestroy()
  {
    this.ucr.a(this.ucy);
    this.ucq.clear();
    ac.d("MicroMsg.BaseMapUI", "destroy");
    if (this.fts != null)
    {
      this.fts.dismiss();
      this.fts = null;
    }
    this.uco.tZg.destroy();
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
    this.uco.ucF.setBackgroundColor(paramInt);
    Boolean localBoolean = Boolean.valueOf(am.ZN(paramInt));
    Object localObject;
    if (localBoolean.booleanValue())
    {
      this.uco.gyM.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
      this.uco.ucC.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
      this.uco.titleView.setTextColor(ai.getResources().getColor(2131101182));
      if (Build.VERSION.SDK_INT >= 21)
      {
        localObject = this.activity.getWindow();
        ((Window)localObject).clearFlags(201326592);
        ((Window)localObject).addFlags(-2147483648);
        if ((Build.VERSION.SDK_INT < 23) || (g.YJ())) {
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
        this.uco.gyM.getDrawable().setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
        this.uco.ucC.getDrawable().setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
        this.uco.titleView.setTextColor(ai.getResources().getColor(2131100021));
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
    ImageView gyM;
    TextView tTl;
    com.tencent.mm.plugin.k.d tZg;
    TextView titleView;
    FrameLayout ucA;
    RelativeLayout ucB;
    ImageButton ucC;
    View ucD;
    TextView ucE;
    LinearLayout ucF;
    TextView ucG;
    TextView ucH;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.a
 * JD-Core Version:    0.7.0.1
 */