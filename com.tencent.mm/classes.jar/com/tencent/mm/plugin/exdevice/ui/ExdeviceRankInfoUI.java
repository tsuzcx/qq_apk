package com.tencent.mm.plugin.exdevice.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.tw;
import com.tencent.mm.g.a.wp;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.exdevice.g.a.j;
import com.tencent.mm.plugin.exdevice.g.a.j.a;
import com.tencent.mm.plugin.exdevice.g.b.f;
import com.tencent.mm.plugin.exdevice.model.ac;
import com.tencent.mm.plugin.exdevice.model.ac.a;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.a;
import com.tencent.mm.ui.base.MMPullDownView.b;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.report.MMSecDataActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import junit.framework.Assert;

public class ExdeviceRankInfoUI
  extends MMSecDataActivity
  implements j.a, com.tencent.mm.plugin.exdevice.g.b.e, f, c
{
  private static int rJm = 128;
  private int likeCount;
  private boolean mIsDestroyed;
  private String mRa;
  private String mwj;
  public boolean rCL;
  public String rCM;
  private boolean rCz;
  private q rGN;
  private String rIS;
  private ImageView rIY;
  private Map<String, String> rJE;
  private View rJc;
  private String rJd;
  private String rJe;
  private ArrayList<com.tencent.mm.plugin.exdevice.g.b.a.c> rKA;
  private ArrayList<com.tencent.mm.plugin.exdevice.g.b.a.d> rKB;
  private boolean rKC;
  private boolean rKD;
  private String rKE;
  private boolean rKF;
  private j rKG;
  private com.tencent.mm.plugin.exdevice.b.b<j> rKH;
  private ListView rKn;
  private b rKo;
  private View rKp;
  private ExdeviceRankListHeaderView rKq;
  private ExdeviceRankChampionInfoView rKr;
  private View rKs;
  private String rKt;
  private String rKu;
  private String rKv;
  private com.tencent.mm.plugin.exdevice.g.b.a.a rKw;
  private String rKx;
  private int rKy;
  private List<d> rKz;
  
  public ExdeviceRankInfoUI()
  {
    AppMethodBeat.i(24235);
    this.rGN = null;
    this.rJE = new HashMap();
    this.rKH = new com.tencent.mm.plugin.exdevice.b.b() {};
    AppMethodBeat.o(24235);
  }
  
  private int anV(String paramString)
  {
    AppMethodBeat.i(24240);
    Log.i("MicroMsg.Sport.ExdeviceRankInfoUI", "locateToUser, locate2User(%s), username(%s).", new Object[] { paramString, this.mRa });
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(24240);
      return -1;
    }
    if ((this.rKz == null) || (this.rKz.size() == 0))
    {
      AppMethodBeat.o(24240);
      return -2;
    }
    int i = 0;
    while (i < this.rKz.size())
    {
      Object localObject = ((d)this.rKz.get(i)).rMD;
      int j = ((d)this.rKz.get(i)).rME;
      if ((localObject != null) && (paramString.equalsIgnoreCase(((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject).field_username)) && (!paramString.equalsIgnoreCase(this.mRa)) && ((j & 0x2) != 2))
      {
        localObject = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
        j = ((DisplayMetrics)localObject).heightPixels;
        Log.i("MicroMsg.Sport.ExdeviceRankInfoUI", "locateToUser pos(%d).(h : %d)", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        this.rKn.setSelectionFromTop(i, j / 4);
        this.rKo.rJF = paramString;
        this.rKo.notifyDataSetInvalidated();
        cLY();
        AppMethodBeat.o(24240);
        return i;
      }
      i += 1;
    }
    this.rKo.rJF = null;
    AppMethodBeat.o(24240);
    return -3;
  }
  
  private void cLR()
  {
    AppMethodBeat.i(24241);
    if ((this.rKw != null) && (this.mRa != null) && (this.mRa.equals(this.rKw.field_username)) && (Util.isNullOrNil(this.rKw.field_championUrl)))
    {
      if (this.rJc != null) {
        this.rJc.setVisibility(0);
      }
      if (this.rKq != null)
      {
        this.rKq.setOnViewClickListener(new ExdeviceRankInfoUI.23(this));
        AppMethodBeat.o(24241);
      }
    }
    else
    {
      if (this.rJc != null) {
        this.rJc.setVisibility(8);
      }
      if ((this.rKw != null) && (!Util.nullAs(this.rKw.field_username, "").equals(this.mRa)) && (!Util.isNullOrNil(this.rKw.field_championUrl))) {
        this.rKq.setOnViewClickListener(new ExdeviceRankInfoUI.24(this));
      }
    }
    AppMethodBeat.o(24241);
  }
  
  private void cLU()
  {
    AppMethodBeat.i(24238);
    Log.i("MicroMsg.Sport.ExdeviceRankInfoUI", "updateRankInfoUIFromServer");
    this.rKG = new j(this.rIS, this.rKv, this.rKx, this.rKC, this.rKH);
    this.rKG.rCO = this;
    bg.azz().a(this.rKG, 0);
    AppMethodBeat.o(24238);
  }
  
  private void cLV()
  {
    AppMethodBeat.i(24239);
    Log.i("MicroMsg.Sport.ExdeviceRankInfoUI", "try2LocateToUser, locate2User(%s), username(%s).", new Object[] { this.rKE, this.mRa });
    if ((Util.isNullOrNil(this.rKE)) || (anV(this.rKE) < 0))
    {
      Log.d("MicroMsg.Sport.ExdeviceRankInfoUI", "locate to username is null or nil.");
      AppMethodBeat.o(24239);
      return;
    }
    AppMethodBeat.o(24239);
  }
  
  private void cLW()
  {
    AppMethodBeat.i(24242);
    String str = cLX();
    if (!Util.isNullOrNil(str)) {
      this.rKx = str;
    }
    AppMethodBeat.o(24242);
  }
  
  private String cLX()
  {
    AppMethodBeat.i(24243);
    if (this.rKz != null)
    {
      Object localObject = this.rKz.iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.plugin.exdevice.g.b.a.d locald = ((d)((Iterator)localObject).next()).rMD;
        if ((locald != null) && (locald.field_ranknum == 1))
        {
          localObject = locald.field_username;
          AppMethodBeat.o(24243);
          return localObject;
        }
      }
    }
    AppMethodBeat.o(24243);
    return null;
  }
  
  private void cLY()
  {
    AppMethodBeat.i(24245);
    View localView = this.rKn.getChildAt(0);
    int[] arrayOfInt = new int[2];
    if (localView != null)
    {
      if (this.rKn.getFirstVisiblePosition() == 0)
      {
        localView.getLocationOnScreen(arrayOfInt);
        if ((Util.isNullOrNil(this.rKE)) && (rJm == 128)) {
          rJm = arrayOfInt[1];
        }
        int i = arrayOfInt[1];
        if (i > 0)
        {
          if (i >= rJm) {}
          for (float f = 1.0F;; f = i / rJm)
          {
            Log.d("MicroMsg.Sport.ExdeviceRankInfoUI", "ap-alpha: %s", new Object[] { Float.valueOf(f) });
            this.rKr.setAlpha(f);
            this.rKr.setVisibility(0);
            this.rJc.setAlpha(f);
            AppMethodBeat.o(24245);
            return;
          }
        }
      }
      this.rKr.setAlpha(0.0F);
      this.rJc.setAlpha(0.0F);
      this.rKr.setVisibility(8);
    }
    AppMethodBeat.o(24245);
  }
  
  private void cLZ()
  {
    AppMethodBeat.i(24250);
    if (this.rKw != null)
    {
      if ((this.mwj != this.rKw.field_championUrl) && ((this.mwj == null) || (!this.mwj.equals(this.rKw.field_championUrl))))
      {
        com.tencent.mm.plugin.exdevice.g.a.e.a(this, this.rIY, this.rKw.field_championUrl);
        this.mwj = this.rKw.field_championUrl;
        AppMethodBeat.o(24250);
      }
    }
    else
    {
      this.rIY.setImageResource(2131100237);
      this.mwj = null;
    }
    AppMethodBeat.o(24250);
  }
  
  private void cMb()
  {
    AppMethodBeat.i(24259);
    if (Util.isNullOrNil(this.rCM))
    {
      localObject = ad.cKP().anF(this.mRa);
      if (localObject != null) {
        this.rCM = ((com.tencent.mm.plugin.exdevice.g.b.a.a)localObject).field_championUrl;
      }
    }
    com.tencent.mm.plugin.exdevice.g.b.a.d locald = b.h(this.mRa, this.rKB);
    Object localObject = "--";
    String str = "0";
    if (locald != null)
    {
      localObject = String.valueOf(locald.field_ranknum);
      str = String.valueOf(locald.field_score);
    }
    new ac().a(this, (String)localObject, str, this.rCM, new ExdeviceRankInfoUI.13(this));
    AppMethodBeat.o(24259);
  }
  
  private void lR(boolean paramBoolean)
  {
    AppMethodBeat.i(24236);
    if ((this.rKD) && (!paramBoolean))
    {
      AppMethodBeat.o(24236);
      return;
    }
    ad.cKT();
    this.rKB = com.tencent.mm.plugin.exdevice.g.b.c.anB(this.rIS);
    this.rKA = ad.cKN().cKZ();
    this.rKz = this.rKo.b(this.rKA, this.rKB, this.rCL);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(24206);
        ExdeviceRankInfoUI.b(ExdeviceRankInfoUI.this).rJD = ExdeviceRankInfoUI.a(ExdeviceRankInfoUI.this);
        ExdeviceRankInfoUI.b(ExdeviceRankInfoUI.this).notifyDataSetChanged();
        ExdeviceRankInfoUI.c(ExdeviceRankInfoUI.this);
        AppMethodBeat.o(24206);
      }
    });
    AppMethodBeat.o(24236);
  }
  
  private void lS(boolean paramBoolean)
  {
    AppMethodBeat.i(24251);
    if (paramBoolean) {
      cLW();
    }
    if (!Util.isNullOrNil(this.rKv))
    {
      this.rKr.anT(this.rKx);
      this.rKr.setVisibility(0);
      AppMethodBeat.o(24251);
      return;
    }
    this.rKr.setVisibility(8);
    AppMethodBeat.o(24251);
  }
  
  public final void a(j paramj)
  {
    AppMethodBeat.i(24260);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(24225);
        if ((ExdeviceRankInfoUI.e(ExdeviceRankInfoUI.this) != null) && (ExdeviceRankInfoUI.e(ExdeviceRankInfoUI.this).isShowing()))
        {
          ExdeviceRankInfoUI.e(ExdeviceRankInfoUI.this).dismiss();
          ExdeviceRankInfoUI.f(ExdeviceRankInfoUI.this);
          Log.d("MicroMsg.Sport.ExdeviceRankInfoUI", "dismiss tips dialog.");
        }
        AppMethodBeat.o(24225);
      }
    });
    this.rJd = paramj.rCq;
    this.rJe = paramj.msN;
    this.rCM = paramj.rCM;
    this.rCL = paramj.rCL;
    this.rCz = paramj.rCz;
    this.rKB = paramj.rCE;
    this.rKA = paramj.rCF;
    this.rKz = this.rKo.b(this.rKA, this.rKB, this.rCL);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(179640);
        ExdeviceRankInfoUI.b(ExdeviceRankInfoUI.this).rJD = ExdeviceRankInfoUI.a(ExdeviceRankInfoUI.this);
        ExdeviceRankInfoUI.b(ExdeviceRankInfoUI.this).notifyDataSetChanged();
        ExdeviceRankInfoUI.c(ExdeviceRankInfoUI.this);
        AppMethodBeat.o(179640);
      }
    });
    AppMethodBeat.o(24260);
  }
  
  public final void anC(String paramString)
  {
    AppMethodBeat.i(24253);
    Log.d("MicroMsg.Sport.ExdeviceRankInfoUI", "hy: rank changed to %s", new Object[] { paramString });
    this.rIS = paramString;
    AppMethodBeat.o(24253);
  }
  
  public final void anW(String paramString)
  {
    AppMethodBeat.i(24254);
    com.tencent.mm.plugin.sport.a.c.pl(6);
    Intent localIntent = new Intent(this, ExdeviceProfileUI.class);
    localIntent.putExtra("username", paramString);
    localIntent.putExtra("usernickname", (String)this.rJE.get(paramString));
    localIntent.putExtra("app_username", this.rKv);
    localIntent.putExtra("rank_id", this.rIS);
    startActivityForResult(localIntent, 4);
    AppMethodBeat.o(24254);
  }
  
  public final boolean anX(String paramString)
  {
    AppMethodBeat.i(24258);
    if ((!Util.isNullOrNil(this.rIS)) && (!"#".equals(this.rIS)))
    {
      if (z.aTY().equals(paramString))
      {
        Log.d("MicroMsg.Sport.ExdeviceRankInfoUI", "hy: is self. see who likes me");
        paramString = new Intent(this, ExdeviceLikeUI.class);
        paramString.putExtra("app_username", this.rKv);
        paramString.putExtra("rank_id", this.rIS);
        paramString.putExtra("key_is_like_read_only", true);
        paramString = new com.tencent.mm.hellhoundlib.b.a().bl(paramString);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramString.axQ(), "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankInfoUI", "beforeLikeBtnClicked", "(Ljava/lang/String;I)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramString.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankInfoUI", "beforeLikeBtnClicked", "(Ljava/lang/String;I)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(24258);
        return true;
      }
      AppMethodBeat.o(24258);
      return false;
    }
    Log.d("MicroMsg.Sport.ExdeviceRankInfoUI", "hy: rank id is not valid.abort the event");
    Toast.makeText(this, getString(2131758887), 0).show();
    AppMethodBeat.o(24258);
    return true;
  }
  
  public final void b(String paramString, com.tencent.mm.plugin.exdevice.g.b.d paramd)
  {
    AppMethodBeat.i(24252);
    if ((paramd != null) && (!Util.isNullOrNil(paramString))) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if (!"HardDeviceRankInfo".equals(paramString)) {
        break;
      }
      if ((this.rIS == null) || (!this.rIS.equals(paramd.rCB))) {
        break label216;
      }
      Log.i("MicroMsg.Sport.ExdeviceRankInfoUI", "onRankChange, rankId(%s).", new Object[] { this.rIS });
      lR(true);
      if ((Util.isNullOrNil(this.rKx)) || (!this.rKx.equals(cLX())))
      {
        cLW();
        this.rKw = ad.cKP().anF(this.rKx);
        runOnUiThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(24215);
            ExdeviceRankInfoUI.s(ExdeviceRankInfoUI.this);
            ExdeviceRankInfoUI.t(ExdeviceRankInfoUI.this);
            AppMethodBeat.o(24215);
          }
        });
      }
      runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(24216);
          ExdeviceRankInfoUI.u(ExdeviceRankInfoUI.this);
          if (!ExdeviceRankInfoUI.v(ExdeviceRankInfoUI.this))
          {
            ExdeviceRankInfoUI.h(ExdeviceRankInfoUI.this);
            AppMethodBeat.o(24216);
            return;
          }
          ExdeviceRankInfoUI.b(ExdeviceRankInfoUI.this).notifyDataSetChanged();
          AppMethodBeat.o(24216);
        }
      });
      AppMethodBeat.o(24252);
      return;
    }
    if (("HardDeviceChampionInfo".equals(paramString)) && (!Util.isNullOrNil(this.rKx)) && (this.rKx.equals(paramd.username)))
    {
      this.rKw = ad.cKP().anF(this.rKx);
      runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(179638);
          ExdeviceRankInfoUI.s(ExdeviceRankInfoUI.this);
          ExdeviceRankInfoUI.t(ExdeviceRankInfoUI.this);
          AppMethodBeat.o(179638);
        }
      });
    }
    label216:
    AppMethodBeat.o(24252);
  }
  
  public final void cMa()
  {
    AppMethodBeat.i(24255);
    com.tencent.mm.plugin.sport.a.c.pl(31);
    cMb();
    AppMethodBeat.o(24255);
  }
  
  public final void di(String paramString, int paramInt)
  {
    AppMethodBeat.i(24256);
    ad.cKT();
    String str1 = this.rIS;
    String str2 = this.rKv;
    com.tencent.mm.plugin.exdevice.g.b.b.d locald = ad.cKM();
    boolean bool;
    com.tencent.mm.plugin.exdevice.g.b.a.d locald1;
    if ((!Util.isNullOrNil(str1)) && (!Util.isNullOrNil(paramString)) && ((paramInt == 1) || (paramInt == 0) || (paramInt == 2)))
    {
      bool = true;
      Assert.assertTrue(bool);
      locald1 = locald.a(new com.tencent.mm.plugin.exdevice.g.b.d(str1, null, paramString));
      if (locald1 != null) {
        break label125;
      }
      Log.w("MicroMsg.ExdeviceRankInfoStg", "hy: info is null. abort");
    }
    for (;;)
    {
      com.tencent.mm.plugin.exdevice.g.b.c.c(str1, str2, paramString, paramInt);
      this.likeCount += 1;
      AppMethodBeat.o(24256);
      return;
      bool = false;
      break;
      label125:
      locald1.field_selfLikeState = paramInt;
      switch (locald1.field_selfLikeState)
      {
      default: 
        Log.w("MicroMsg.ExdeviceRankInfoStg", "hy: still loading...abort");
      }
    }
    for (locald1.field_likecount += 1;; locald1.field_likecount -= 1)
    {
      locald.a(locald1, true);
      break;
    }
  }
  
  public int getLayoutId()
  {
    return 2131494044;
  }
  
  public void initView()
  {
    AppMethodBeat.i(24244);
    this.rKp = findViewById(2131305499);
    Object localObject1 = new ExdeviceRankListHeaderView(this);
    Object localObject2 = new Rect();
    getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject2);
    int j = ((Rect)localObject2).top;
    int i = j;
    if (j == 0) {
      i = com.tencent.mm.plugin.exdevice.k.b.D(this, getResources().getDimensionPixelSize(2131165327));
    }
    localObject2 = getResources().getDisplayMetrics();
    if (((DisplayMetrics)localObject2).widthPixels > ((DisplayMetrics)localObject2).heightPixels)
    {
      j = getResources().getDimensionPixelSize(2131165255);
      localObject2 = getWindowManager().getDefaultDisplay();
      j = ((Display)localObject2).getHeight() / 2 - i - j;
      if (((Display)localObject2).getHeight() > 0)
      {
        i = j;
        if (j > 0) {}
      }
      else
      {
        i = getResources().getDimensionPixelSize(2131165321);
      }
      ((ExdeviceRankListHeaderView)localObject1).setMinimumHeight(i);
      ((ExdeviceRankListHeaderView)localObject1).setMinimumWidth(((Display)localObject2).getWidth());
      ((ExdeviceRankListHeaderView)localObject1).setTag(Integer.valueOf(i));
      this.rKq = ((ExdeviceRankListHeaderView)localObject1);
      localObject1 = (MMPullDownView)findViewById(2131306316);
      this.rKn = ((ListView)findViewById(2131300215));
      this.rKr = ((ExdeviceRankChampionInfoView)findViewById(2131298275));
      this.rJc = findViewById(2131307646);
      this.rJc.setOnClickListener(new ExdeviceRankInfoUI.25(this));
      this.rKq.setIsShowTip(false);
      cLR();
      ((MMPullDownView)localObject1).setIsBottomShowAll(false);
      ((MMPullDownView)localObject1).setTopViewVisible(false);
      ((MMPullDownView)localObject1).setBottomViewVisible(false);
      ((MMPullDownView)localObject1).setIsBottomShowAll(false);
      ((MMPullDownView)localObject1).setIsTopShowAll(false);
      ((MMPullDownView)localObject1).setCanOverScrool(true);
      ((MMPullDownView)localObject1).setOnInterceptTouchEventListener(new MMPullDownView.a()
      {
        public final boolean onInterceptTouchEvent(MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(179630);
          paramAnonymousMotionEvent = ExdeviceRankInfoUI.this;
          if ((ExdeviceRankInfoUI.a(ExdeviceRankInfoUI.this) != null) && (ExdeviceRankInfoUI.a(ExdeviceRankInfoUI.this).size() != 0)) {}
          for (boolean bool = true;; bool = false)
          {
            ExdeviceRankInfoUI.b(paramAnonymousMotionEvent, bool);
            AppMethodBeat.o(179630);
            return false;
          }
        }
      });
      ((MMPullDownView)localObject1).setAtBottomCallBack(new ExdeviceRankInfoUI.3(this));
      ((MMPullDownView)localObject1).setOnScrollChangedListener(new MMPullDownView.b()
      {
        public final void cLT()
        {
          AppMethodBeat.i(179632);
          ExdeviceRankInfoUI.r(ExdeviceRankInfoUI.this);
          AppMethodBeat.o(179632);
        }
      });
      ((MMPullDownView)localObject1).setAtTopCallBack(new ExdeviceRankInfoUI.5(this));
      this.rKn.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(179635);
          ExdeviceRankInfoUI.r(ExdeviceRankInfoUI.this);
          AppMethodBeat.o(179635);
        }
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
        {
          AppMethodBeat.i(179634);
          ExdeviceRankInfoUI.r(ExdeviceRankInfoUI.this);
          AppMethodBeat.o(179634);
        }
      });
      this.rKn.addHeaderView(this.rKq, null, false);
      localObject2 = getLayoutInflater().inflate(2131494042, null);
      this.rKs = ((View)localObject2).findViewById(2131302710);
      ((View)localObject2).findViewById(2131302709).setOnClickListener(new ExdeviceRankInfoUI.7(this));
      this.rKs.setVisibility(8);
      this.rKn.addFooterView((View)localObject2);
      if (this.rKA == null) {
        break label759;
      }
    }
    label759:
    for (i = this.rKA.size();; i = 0)
    {
      if (this.rKB != null) {}
      for (j = this.rKB.size();; j = 0)
      {
        if (i + j == 0)
        {
          this.rKz = new ArrayList();
          this.rKo.rJD = this.rKz;
          getString(2131755998);
          this.rGN = com.tencent.mm.ui.base.h.a(this, getString(2131762446), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              AppMethodBeat.i(179637);
              if (ExdeviceRankInfoUI.e(ExdeviceRankInfoUI.this) != null)
              {
                ExdeviceRankInfoUI.e(ExdeviceRankInfoUI.this).dismiss();
                ExdeviceRankInfoUI.f(ExdeviceRankInfoUI.this);
              }
              ExdeviceRankInfoUI.this.finish();
              AppMethodBeat.o(179637);
            }
          });
        }
        this.rKn.setAdapter(this.rKo);
        this.rKo.rJG = this;
        if (this.rKy == 1)
        {
          this.rKn.setVisibility(0);
          this.rKp.setVisibility(8);
        }
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label638;
          }
          Log.d("MicroMsg.Sport.ExdeviceRankInfoUI", "hy: cannot handle this device type");
          finish();
          AppMethodBeat.o(24244);
          return;
          j = getResources().getDimensionPixelSize(2131165256);
          break;
          this.rKn.setVisibility(8);
          this.rKp.setVisibility(0);
        }
        label638:
        this.rIY = ((ImageView)findViewById(2131300193));
        ((MMPullDownView)localObject1).setCanOverScrool(false);
        int k = com.tencent.mm.cb.a.jn(this);
        j = ((Integer)this.rKq.getTag()).intValue();
        i = j;
        if (this.rCL)
        {
          i = getResources().getDimensionPixelSize(2131165337);
          int m = getResources().getDimensionPixelSize(2131165336);
          i = j + (i / 2 + m);
        }
        localObject1 = new RelativeLayout.LayoutParams(k, i);
        this.rIY.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        cLZ();
        lS(false);
        AppMethodBeat.o(24244);
        return;
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(24257);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (com.tencent.mm.plugin.exdevice.g.a.e.a(this, paramInt1, paramInt2, paramIntent, this.rKv))
    {
      AppMethodBeat.o(24257);
      return;
    }
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(24257);
      return;
      if (paramIntent == null)
      {
        Log.e("MicroMsg.Sport.ExdeviceRankInfoUI", "onActivityResult, data is null.(reqestCode : %d)", new Object[] { Integer.valueOf(paramInt1) });
        AppMethodBeat.o(24257);
        return;
      }
      if (paramIntent == null) {}
      for (Object localObject = null; (localObject == null) || (((String)localObject).length() == 0); localObject = paramIntent.getStringExtra("Select_Conv_User"))
      {
        Log.e("MicroMsg.Sport.ExdeviceRankInfoUI", "select conversation failed, toUser is null.");
        AppMethodBeat.o(24257);
        return;
      }
      paramIntent = paramIntent.getStringExtra("custom_send_text");
      ac.a(this, (String)localObject, ac.fb(this), paramIntent, this.rJe);
      com.tencent.mm.ui.base.h.cD(getContext(), getResources().getString(2131755986));
      Log.d("MicroMsg.Sport.ExdeviceRankInfoUI", "Select conversation return.");
      AppMethodBeat.o(24257);
      return;
      com.tencent.mm.ui.base.h.cD(getContext(), getResources().getString(2131755986));
      Log.d("MicroMsg.Sport.ExdeviceRankInfoUI", "Share to timeline return.");
      AppMethodBeat.o(24257);
      return;
      if (paramIntent != null)
      {
        localObject = Util.stringsToList(paramIntent.getStringExtra("received_card_name").split(","));
        paramIntent = paramIntent.getStringExtra("custom_send_text");
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          com.tencent.mm.plugin.messenger.a.g.eir().s("gh_43f2581f6fd6", str, ab.Eq(str));
          if (!Util.isNullOrNil(paramIntent))
          {
            tw localtw = new tw();
            localtw.eaq.dkV = str;
            localtw.eaq.content = paramIntent;
            localtw.eaq.type = ab.JG(str);
            localtw.eaq.flags = 0;
            EventCenter.instance.publish(localtw);
          }
        }
        AppMethodBeat.o(24257);
        return;
        if ((paramIntent != null) && (paramIntent.getBooleanExtra("KeyNeedUpdateRank", false))) {
          cLU();
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(24237);
    super.onCreate(paramBundle);
    this.mIsDestroyed = false;
    this.mRa = z.aTY();
    paramBundle = getIntent();
    this.rKt = paramBundle.getStringExtra("key_rank_info");
    this.rKu = paramBundle.getStringExtra("key_rank_semi");
    this.rKv = paramBundle.getStringExtra("app_username");
    this.rIS = paramBundle.getStringExtra("rank_id");
    this.rKC = paramBundle.getBooleanExtra("key_is_latest", false);
    this.rKx = paramBundle.getStringExtra("key_champioin_username");
    this.rKy = paramBundle.getIntExtra("device_type", 0);
    this.rKE = paramBundle.getStringExtra("locate_to_username");
    this.rKD = paramBundle.getBooleanExtra("key_only_show_latest_rank", false);
    Object localObject;
    if ((Util.isNullOrNil(this.rIS)) || ("#".equals(this.rIS))) {
      if (!this.rKD)
      {
        paramBundle = ad.cKM();
        localObject = String.format("select * from %s order by %s desc limit 1", new Object[] { "HardDeviceRankInfo", "rankID" });
        localObject = paramBundle.db.rawQuery((String)localObject, null, 2);
        if (localObject != null) {
          break label749;
        }
        Log.e("MicroMsg.ExdeviceRankInfoStg", "Get no rank in DB");
        paramBundle = null;
      }
    }
    for (;;)
    {
      if (paramBundle != null)
      {
        this.rIS = paramBundle.field_rankID;
        this.rKv = paramBundle.field_appusername;
      }
      this.rKx = null;
      this.rKC = true;
      ad.cKT();
      this.rKB = com.tencent.mm.plugin.exdevice.g.b.c.anB(this.rIS);
      if (!this.rKD)
      {
        if ((this.rKB == null) || (this.rKB.size() <= 0))
        {
          this.rKA = new ArrayList();
          this.rKB = com.tencent.mm.plugin.exdevice.g.a.a.a(this.rIS, this.rKv, this.rKt, this.rKu, this.rJE, this.rKA);
          ad.cKT();
          com.tencent.mm.plugin.exdevice.g.b.c.f(this.rIS, this.rKB);
          label341:
          this.rKA = ad.cKN().cKZ();
        }
      }
      else
      {
        this.rKo = new b(this, this.rKv);
        this.rKo.rJE = this.rJE;
        this.rKz = this.rKo.b(this.rKA, this.rKB, this.rCL);
        this.rKo.rJD = this.rKz;
        if (Util.isNullOrNil(this.rKx)) {
          cLW();
        }
        this.rKw = ad.cKP().anF(this.rKx);
        if ((this.rKw == null) && (!Util.isNullOrNil(this.rKx)))
        {
          this.rKw = new com.tencent.mm.plugin.exdevice.g.b.a.a();
          this.rKw.field_username = this.rKx;
          this.rKw.field_championMotto = getIntent().getStringExtra("key_champion_info");
          this.rKw.field_championUrl = getIntent().getStringExtra("key_champion_coverimg");
          ad.cKT();
          paramBundle = this.rKw;
          ad.cKP().a(paramBundle);
        }
        initView();
        if ((this.rKB != null) && (this.rKB.size() > 0))
        {
          paramBundle = ((com.tencent.mm.plugin.exdevice.g.b.a.d)this.rKB.get(0)).field_username;
          this.rKr.anT(paramBundle);
        }
        ad.cKU().a(this);
        ad.cKT().rCX = this;
        cLU();
        setBackBtn(new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(179644);
            ExdeviceRankInfoUI.this.finish();
            AppMethodBeat.o(179644);
            return false;
          }
        });
        setMMTitle(2131758928);
        showOptionMenu(true);
        cLV();
        paramBundle = new wp();
        paramBundle.ecH.action = 2;
        EventCenter.instance.asyncPublish(paramBundle, new Executor()
        {
          public final void execute(Runnable paramAnonymousRunnable)
          {
            AppMethodBeat.i(179643);
            com.tencent.f.h.RTc.aX(paramAnonymousRunnable);
            AppMethodBeat.o(179643);
          }
        });
        if (!com.tencent.mm.compatible.util.d.oF(28)) {}
      }
      try
      {
        if (android.support.v4.content.b.checkSelfPermission(this, "android.permission.ACTIVITY_RECOGNITION") != 0)
        {
          Log.i("MicroMsg.Sport.ExdeviceRankInfoUI", "no ACTIVITY_RECOGNITION permission");
          android.support.v4.app.a.a(this, new String[] { "android.permission.ACTIVITY_RECOGNITION" }, 5);
        }
        for (;;)
        {
          label692:
          if (com.tencent.mm.kernel.g.aAh().azQ().getInt(ar.a.OnQ, 0) == 1)
          {
            Log.i("MicroMsg.Sport.ExdeviceRankInfoUI", "toast get step fail");
            Toast.makeText(this, 2131758896, 0).show();
            com.tencent.mm.plugin.report.e.Cxv.idkeyStat(323L, 6L, 1L, false);
          }
          AppMethodBeat.o(24237);
          return;
          label749:
          if (!((Cursor)localObject).moveToFirst())
          {
            Log.d("MicroMsg.ExdeviceRankInfoStg", "hy: no record");
            paramBundle = null;
          }
          for (;;)
          {
            ((Cursor)localObject).close();
            break;
            paramBundle = new com.tencent.mm.plugin.exdevice.g.b.a.d();
            paramBundle.convertFrom((Cursor)localObject);
          }
          com.tencent.mm.plugin.exdevice.g.a.a.b(this.rKt, this.rKu, this.rJE);
          break label341;
          Log.i("MicroMsg.Sport.ExdeviceRankInfoUI", "has ACTIVITY_RECOGNITION permission");
        }
      }
      catch (Exception paramBundle)
      {
        break label692;
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(24248);
    this.mIsDestroyed = true;
    if (this.rKo != null) {
      b.finish();
    }
    super.onDestroy();
    if (this.rKG != null) {
      this.rKG.rCO = null;
    }
    ad.cKU().b(this);
    ad.cKT().rCX = null;
    ad.cKT().rCY = null;
    if (this.likeCount > 0)
    {
      int i = this.likeCount;
      Log.v("MicroMsg.Sport.SportReportLogic", "reportLikeCount count=%d", new Object[] { Integer.valueOf(i) });
      com.tencent.mm.plugin.report.e.Cxv.a(13168, new Object[] { Integer.valueOf(0), Integer.valueOf(i) });
    }
    AppMethodBeat.o(24248);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(24249);
    super.onPause();
    AppMethodBeat.o(24249);
  }
  
  protected void onRestart()
  {
    AppMethodBeat.i(24247);
    super.onRestart();
    lR(true);
    AppMethodBeat.o(24247);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(24246);
    super.onResume();
    AppMethodBeat.o(24246);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI
 * JD-Core Version:    0.7.0.1
 */