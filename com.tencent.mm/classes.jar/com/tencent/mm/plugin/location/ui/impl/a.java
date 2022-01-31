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
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.c.a;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location.model.e;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.base.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

public abstract class a
  extends com.tencent.mm.plugin.k.a
{
  public Activity activity;
  protected int cud = 0;
  protected String eSM = "";
  protected ProgressDialog eeN = null;
  ak handler = new ak(Looper.getMainLooper());
  DisplayMetrics nAe = null;
  int nZX;
  protected float nvl = 0.0F;
  protected float nvm = 0.0F;
  protected String obp = "";
  protected String ocb;
  public String ofh = "";
  protected boolean ofi = false;
  public boolean ofj = false;
  protected Addr ofk = null;
  protected com.tencent.mm.plugin.location.ui.d ofl;
  protected LocationInfo ofm = new LocationInfo((byte)0);
  protected LocationInfo ofn = new LocationInfo((byte)0);
  protected a.a ofo;
  protected boolean ofp = false;
  protected HashMap<String, com.tencent.mm.plugin.location.ui.c> ofq = new HashMap();
  protected com.tencent.mm.modelgeo.c ofr;
  protected boolean ofs = false;
  protected ArrayList<String> oft = new ArrayList();
  protected boolean ofu = false;
  protected boolean ofv = false;
  protected com.tencent.mm.plugin.location.model.c ofw = null;
  protected com.tencent.mm.modelgeo.d ofx;
  public c.a ofy = new a.3(this);
  protected int type = 0;
  
  public a(Activity paramActivity)
  {
    this.activity = paramActivity;
    this.ofr = com.tencent.mm.modelgeo.c.agN();
  }
  
  protected abstract String apc();
  
  protected final boolean b(LocationInfo paramLocationInfo)
  {
    if (this.ofo.ocA.getIController() == null) {}
    while (!e.j(paramLocationInfo.nZV, paramLocationInfo.nZW)) {
      return false;
    }
    this.ofo.ocA.getIController().animateTo(paramLocationInfo.nZV, paramLocationInfo.nZW);
    return true;
  }
  
  protected final void bMa()
  {
    if ((this.ofo.ofG == null) || (this.ofo.ofH == null)) {
      return;
    }
    this.ofo.ofG.setText(j.b(this.ofo.ofG.getContext(), this.ocb, this.ofo.ofG.getTextSize()));
    if ((this.oft == null) || (this.oft.isEmpty()))
    {
      this.ofo.ofH.setText("");
      return;
    }
    String str1 = (String)this.oft.get(0);
    String str2 = this.activity.getResources().getString(2131299844);
    int i = 1;
    while (i < this.oft.size())
    {
      str1 = str1 + str2 + (String)this.oft.get(i);
      i += 1;
    }
    this.ofo.ofH.setText(j.b(this.ofo.ofH.getContext(), str1, this.ofo.ofH.getTextSize()));
  }
  
  protected final void bMb()
  {
    this.ofo.ofB.removeAllViews();
    View localView = View.inflate(this.activity, 2130969992, null);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    this.ofo.ofB.addView(localView, localLayoutParams);
    this.ofo.ofG = ((TextView)localView.findViewById(2131825433));
    this.ofo.ofG.setOnClickListener(new a.1(this));
    this.ofo.ofH = ((TextView)localView.findViewById(2131825434));
    this.ofo.ofH.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(113590);
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("key_fav_item_id", a.this.activity.getIntent().getLongExtra("kFavInfoLocalId", -1L));
        paramAnonymousView.putExtra("key_fav_result_list", a.this.activity.getIntent().getStringArrayListExtra("kTags"));
        com.tencent.mm.plugin.fav.a.b.a(a.this.activity, ".ui.FavTagEditUI", paramAnonymousView, 4100);
        AppMethodBeat.o(113590);
      }
    });
    bMa();
  }
  
  protected final String bMc()
  {
    return bo.bf(this.ocb, "");
  }
  
  protected abstract void bMd();
  
  abstract void bMe();
  
  public boolean bMf()
  {
    return true;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      ab.d("MicroMsg.BaseMapUI", "dispatchKeyEvent");
      bMd();
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
    ab.d("MicroMsg.BaseMapUI", "initView");
    this.ofo.ofF = ((LinearLayout)findViewById(2131826116));
    this.ofo.ocA = ((com.tencent.mm.plugin.k.d)findViewById(2131820622));
    this.ofo.ofA = ((FrameLayout)findViewById(2131824803));
    this.ofo.ofB = ((RelativeLayout)findViewById(2131824805));
    this.ofo.lzc = ((ImageView)findViewById(2131826118));
    this.ofo.ofC = ((ImageButton)findViewById(2131826122));
    this.ofo.ofD = findViewById(2131826123);
    this.ofo.ofE = ((TextView)findViewById(2131820974));
    this.ofo.titleView = ((TextView)findViewById(2131826119));
    this.ofo.nXJ = ((TextView)findViewById(2131824808));
    this.ofo.titleView.setText(apc());
    this.ofo.ocA.getIController().setZoom(com.tencent.mm.plugin.location.ui.d.bLF());
    if ((this.type != 0) && (this.type != 3))
    {
      this.ofo.ofC.setVisibility(0);
      this.ofo.ofD.setVisibility(8);
      this.ofo.ofC.setEnabled(false);
      this.ofo.ofC.setImageResource(2130839668);
    }
    this.ofo.ocA.setBuiltInZoomControls(false);
    this.ofo.lzc.setOnClickListener(new a.4(this));
    this.ofo.ofE.setOnClickListener(new a.5(this));
    bMe();
    setActionbarColor(ah.getResources().getColor(2131690316));
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
      } while (this.ofo.ofG == null);
      paramIntent = paramIntent.getCharSequenceExtra("key_result");
      if (paramIntent == null) {}
      for (paramIntent = "";; paramIntent = paramIntent.toString())
      {
        this.ocb = paramIntent;
        bMa();
        return;
      }
    } while ((4100 != paramInt1) || (this.ofo.ofH == null));
    this.oft = paramIntent.getStringArrayListExtra("key_fav_result_list");
    bMa();
  }
  
  public void onBackPressed()
  {
    this.activity.finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.ofx = com.tencent.mm.modelgeo.d.agQ();
    LocationInfo localLocationInfo1 = this.ofn;
    LocationInfo localLocationInfo2 = this.ofm;
    paramBundle = aa.f(ah.dsQ());
    ab.d("MicroMsg.BaseMapUI", " initLanguage ".concat(String.valueOf(paramBundle)));
    if (paramBundle.equals("language_default"))
    {
      aa.a(this.activity, Locale.ENGLISH);
      paramBundle = "en";
    }
    for (;;)
    {
      localLocationInfo2.nZZ = paramBundle;
      localLocationInfo1.nZZ = paramBundle;
      ab.d("MicroMsg.BaseMapUI", "sosomap " + this.ofm.nZZ);
      this.activity.requestWindowFeature(1);
      this.activity.setContentView(2130969840);
      ((FrameLayout)findViewById(2131824802)).addView(d.et(this.activity));
      this.ofl = new com.tencent.mm.plugin.location.ui.d(this.activity);
      this.ofo = new a.a(this);
      this.ocb = this.activity.getIntent().getStringExtra("kRemark");
      this.oft = this.activity.getIntent().getStringArrayListExtra("kTags");
      this.type = this.activity.getIntent().getIntExtra("map_view_type", 0);
      this.ofj = this.activity.getIntent().getBooleanExtra("kIs_pick_poi", false);
      ab.i("MicroMsg.BaseMapUI", "isPickPoi " + this.ofj);
      return;
      Locale localLocale = aa.apg(paramBundle);
      aa.a(this.activity, localLocale);
    }
  }
  
  public void onDestroy()
  {
    this.ofr.a(this.ofy);
    ab.d("MicroMsg.BaseMapUI", "destroy");
    if (this.eeN != null)
    {
      this.eeN.dismiss();
      this.eeN = null;
    }
    this.ofo.ocA.destroy();
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
    this.ofo.ofF.setBackgroundColor(paramInt);
    Boolean localBoolean = Boolean.valueOf(aj.Ow(paramInt));
    Object localObject;
    if (localBoolean.booleanValue())
    {
      this.ofo.lzc.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
      this.ofo.ofC.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
      this.ofo.titleView.setTextColor(ah.getResources().getColor(2131690711));
      if (Build.VERSION.SDK_INT >= 21)
      {
        localObject = this.activity.getWindow();
        ((Window)localObject).clearFlags(201326592);
        ((Window)localObject).addFlags(-2147483648);
        if ((Build.VERSION.SDK_INT < 23) || (h.Mo())) {
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
        this.ofo.lzc.getDrawable().setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
        this.ofo.ofC.getDrawable().setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
        this.ofo.titleView.setTextColor(ah.getResources().getColor(2131689766));
        break;
        label237:
        if (Build.VERSION.SDK_INT < 21) {
          break label275;
        }
        paramInt = aj.n(this.activity.getResources().getColor(2131690523), paramInt);
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