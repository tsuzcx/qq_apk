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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.uz;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.exdevice.g.a.j;
import com.tencent.mm.plugin.exdevice.g.a.j.a;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.ad.a;
import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.plugin.messenger.a.g;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.LifecycleEventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.a;
import com.tencent.mm.ui.base.MMPullDownView.b;
import com.tencent.mm.ui.base.MMPullDownView.c;
import com.tencent.mm.ui.base.MMPullDownView.d;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.report.MMSecDataActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public class ExdeviceRankInfoUI
  extends MMSecDataActivity
  implements j.a, com.tencent.mm.plugin.exdevice.g.b.e, com.tencent.mm.plugin.exdevice.g.b.f, c
{
  private static int voU = 128;
  private int likeCount;
  private boolean mIsDestroyed;
  private String pRV;
  private String puJ;
  private boolean vij;
  public boolean viv;
  public String viw;
  private s vmw;
  private String voA;
  private ImageView voG;
  private View voK;
  private String voL;
  private String voM;
  private ListView vpW;
  private b vpX;
  private View vpY;
  private ExdeviceRankListHeaderView vpZ;
  private Map<String, String> vpm;
  private ExdeviceRankChampionInfoView vqa;
  private View vqb;
  private String vqc;
  private String vqd;
  private String vqe;
  private com.tencent.mm.plugin.exdevice.g.b.a.a vqf;
  private String vqg;
  private int vqh;
  private List<d> vqi;
  private ArrayList<com.tencent.mm.plugin.exdevice.g.b.a.c> vqj;
  private ArrayList<com.tencent.mm.plugin.exdevice.g.b.a.d> vqk;
  private boolean vql;
  private boolean vqm;
  private String vqn;
  private boolean vqo;
  private j vqp;
  private com.tencent.mm.plugin.exdevice.b.b<j> vqq;
  
  public ExdeviceRankInfoUI()
  {
    AppMethodBeat.i(24235);
    this.vmw = null;
    this.vpm = new HashMap();
    this.vqq = new com.tencent.mm.plugin.exdevice.b.b() {};
    AppMethodBeat.o(24235);
  }
  
  private int avT(String paramString)
  {
    AppMethodBeat.i(24240);
    Log.i("MicroMsg.Sport.ExdeviceRankInfoUI", "locateToUser, locate2User(%s), username(%s).", new Object[] { paramString, this.pRV });
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(24240);
      return -1;
    }
    if ((this.vqi == null) || (this.vqi.size() == 0))
    {
      AppMethodBeat.o(24240);
      return -2;
    }
    int i = 0;
    while (i < this.vqi.size())
    {
      Object localObject = ((d)this.vqi.get(i)).vsn;
      int j = ((d)this.vqi.get(i)).vso;
      if ((localObject != null) && (paramString.equalsIgnoreCase(((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject).field_username)) && (!paramString.equalsIgnoreCase(this.pRV)) && ((j & 0x2) != 2))
      {
        localObject = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
        j = ((DisplayMetrics)localObject).heightPixels;
        Log.i("MicroMsg.Sport.ExdeviceRankInfoUI", "locateToUser pos(%d).(h : %d)", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        this.vpW.setSelectionFromTop(i, j / 4);
        this.vpX.vpn = paramString;
        this.vpX.notifyDataSetInvalidated();
        daL();
        AppMethodBeat.o(24240);
        return i;
      }
      i += 1;
    }
    this.vpX.vpn = null;
    AppMethodBeat.o(24240);
    return -3;
  }
  
  private void daE()
  {
    AppMethodBeat.i(24241);
    if ((this.vqf != null) && (this.pRV != null) && (this.pRV.equals(this.vqf.field_username)) && (Util.isNullOrNil(this.vqf.field_championUrl)))
    {
      if (this.voK != null) {
        this.voK.setVisibility(0);
      }
      if (this.vpZ != null)
      {
        this.vpZ.setOnViewClickListener(new ExdeviceRankInfoUI.21(this));
        AppMethodBeat.o(24241);
      }
    }
    else
    {
      if (this.voK != null) {
        this.voK.setVisibility(8);
      }
      if ((this.vqf != null) && (!Util.nullAs(this.vqf.field_username, "").equals(this.pRV)) && (!Util.isNullOrNil(this.vqf.field_championUrl))) {
        this.vpZ.setOnViewClickListener(new ExdeviceRankInfoUI.22(this));
      }
    }
    AppMethodBeat.o(24241);
  }
  
  private void daH()
  {
    AppMethodBeat.i(24238);
    Log.i("MicroMsg.Sport.ExdeviceRankInfoUI", "updateRankInfoUIFromServer");
    this.vqp = new j(this.voA, this.vqe, this.vqg, this.vql, this.vqq);
    this.vqp.viy = this;
    bh.aGY().a(this.vqp, 0);
    AppMethodBeat.o(24238);
  }
  
  private void daI()
  {
    AppMethodBeat.i(24239);
    Log.i("MicroMsg.Sport.ExdeviceRankInfoUI", "try2LocateToUser, locate2User(%s), username(%s).", new Object[] { this.vqn, this.pRV });
    if ((Util.isNullOrNil(this.vqn)) || (avT(this.vqn) < 0))
    {
      Log.d("MicroMsg.Sport.ExdeviceRankInfoUI", "locate to username is null or nil.");
      AppMethodBeat.o(24239);
      return;
    }
    AppMethodBeat.o(24239);
  }
  
  private void daJ()
  {
    AppMethodBeat.i(24242);
    String str = daK();
    if (!Util.isNullOrNil(str)) {
      this.vqg = str;
    }
    AppMethodBeat.o(24242);
  }
  
  private String daK()
  {
    AppMethodBeat.i(24243);
    if (this.vqi != null)
    {
      Object localObject = this.vqi.iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.plugin.exdevice.g.b.a.d locald = ((d)((Iterator)localObject).next()).vsn;
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
  
  private void daL()
  {
    AppMethodBeat.i(24245);
    View localView = this.vpW.getChildAt(0);
    int[] arrayOfInt = new int[2];
    if (localView != null)
    {
      if (this.vpW.getFirstVisiblePosition() == 0)
      {
        localView.getLocationOnScreen(arrayOfInt);
        if ((Util.isNullOrNil(this.vqn)) && (voU == 128)) {
          voU = arrayOfInt[1];
        }
        int i = arrayOfInt[1];
        if (i > 0)
        {
          if (i >= voU) {}
          for (float f = 1.0F;; f = i / voU)
          {
            Log.d("MicroMsg.Sport.ExdeviceRankInfoUI", "ap-alpha: %s", new Object[] { Float.valueOf(f) });
            this.vqa.setAlpha(f);
            this.vqa.setVisibility(0);
            this.voK.setAlpha(f);
            AppMethodBeat.o(24245);
            return;
          }
        }
      }
      this.vqa.setAlpha(0.0F);
      this.voK.setAlpha(0.0F);
      this.vqa.setVisibility(8);
    }
    AppMethodBeat.o(24245);
  }
  
  private void daM()
  {
    AppMethodBeat.i(24250);
    if (this.vqf != null)
    {
      if ((this.puJ != this.vqf.field_championUrl) && ((this.puJ == null) || (!this.puJ.equals(this.vqf.field_championUrl))))
      {
        com.tencent.mm.plugin.exdevice.g.a.e.a(this, this.voG, this.vqf.field_championUrl, R.e.darkgrey);
        this.puJ = this.vqf.field_championUrl;
        AppMethodBeat.o(24250);
      }
    }
    else
    {
      this.voG.setImageResource(R.e.darkgrey);
      this.puJ = null;
    }
    AppMethodBeat.o(24250);
  }
  
  private void daO()
  {
    AppMethodBeat.i(24259);
    if (Util.isNullOrNil(this.viw))
    {
      localObject = ae.cZC().avE(this.pRV);
      if (localObject != null) {
        this.viw = ((com.tencent.mm.plugin.exdevice.g.b.a.a)localObject).field_championUrl;
      }
    }
    com.tencent.mm.plugin.exdevice.g.b.a.d locald = b.h(this.pRV, this.vqk);
    Object localObject = "--";
    String str = "0";
    if (locald != null)
    {
      localObject = String.valueOf(locald.field_ranknum);
      str = String.valueOf(locald.field_score);
    }
    new ad().a(this, (String)localObject, str, this.viw, new ExdeviceRankInfoUI.11(this));
    AppMethodBeat.o(24259);
  }
  
  private void nc(boolean paramBoolean)
  {
    AppMethodBeat.i(24236);
    if ((this.vqm) && (!paramBoolean))
    {
      AppMethodBeat.o(24236);
      return;
    }
    ae.cZG();
    this.vqk = com.tencent.mm.plugin.exdevice.g.b.c.avA(this.voA);
    this.vqj = ae.cZA().cZM();
    this.vqi = this.vpX.b(this.vqj, this.vqk, this.viv);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(24206);
        ExdeviceRankInfoUI.b(ExdeviceRankInfoUI.this).vpl = ExdeviceRankInfoUI.a(ExdeviceRankInfoUI.this);
        ExdeviceRankInfoUI.b(ExdeviceRankInfoUI.this).notifyDataSetChanged();
        ExdeviceRankInfoUI.c(ExdeviceRankInfoUI.this);
        AppMethodBeat.o(24206);
      }
    });
    AppMethodBeat.o(24236);
  }
  
  private void nd(boolean paramBoolean)
  {
    AppMethodBeat.i(24251);
    if (paramBoolean) {
      daJ();
    }
    if (!Util.isNullOrNil(this.vqe))
    {
      this.vqa.avR(this.vqg);
      this.vqa.setVisibility(0);
      AppMethodBeat.o(24251);
      return;
    }
    this.vqa.setVisibility(8);
    AppMethodBeat.o(24251);
  }
  
  public final void a(j paramj)
  {
    AppMethodBeat.i(24260);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(24224);
        if ((ExdeviceRankInfoUI.e(ExdeviceRankInfoUI.this) != null) && (ExdeviceRankInfoUI.e(ExdeviceRankInfoUI.this).isShowing()))
        {
          ExdeviceRankInfoUI.e(ExdeviceRankInfoUI.this).dismiss();
          ExdeviceRankInfoUI.f(ExdeviceRankInfoUI.this);
          Log.d("MicroMsg.Sport.ExdeviceRankInfoUI", "dismiss tips dialog.");
        }
        AppMethodBeat.o(24224);
      }
    });
    this.voL = paramj.vhY;
    this.voM = paramj.pqW;
    this.viw = paramj.viw;
    this.viv = paramj.viv;
    this.vij = paramj.vij;
    this.vqk = paramj.vio;
    this.vqj = paramj.vip;
    this.vqi = this.vpX.b(this.vqj, this.vqk, this.viv);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(24225);
        ExdeviceRankInfoUI.b(ExdeviceRankInfoUI.this).vpl = ExdeviceRankInfoUI.a(ExdeviceRankInfoUI.this);
        ExdeviceRankInfoUI.b(ExdeviceRankInfoUI.this).notifyDataSetChanged();
        ExdeviceRankInfoUI.c(ExdeviceRankInfoUI.this);
        AppMethodBeat.o(24225);
      }
    });
    AppMethodBeat.o(24260);
  }
  
  public final void avB(String paramString)
  {
    AppMethodBeat.i(24253);
    Log.d("MicroMsg.Sport.ExdeviceRankInfoUI", "hy: rank changed to %s", new Object[] { paramString });
    this.voA = paramString;
    AppMethodBeat.o(24253);
  }
  
  public final void avU(String paramString)
  {
    AppMethodBeat.i(24254);
    com.tencent.mm.plugin.sport.a.d.rE(6);
    Intent localIntent = new Intent(this, ExdeviceProfileUI.class);
    localIntent.putExtra("username", paramString);
    localIntent.putExtra("usernickname", (String)this.vpm.get(paramString));
    localIntent.putExtra("app_username", this.vqe);
    localIntent.putExtra("rank_id", this.voA);
    startActivityForResult(localIntent, 4);
    AppMethodBeat.o(24254);
  }
  
  public final boolean avV(String paramString)
  {
    AppMethodBeat.i(24258);
    if ((!Util.isNullOrNil(this.voA)) && (!"#".equals(this.voA)))
    {
      if (z.bcZ().equals(paramString))
      {
        Log.d("MicroMsg.Sport.ExdeviceRankInfoUI", "hy: is self. see who likes me");
        paramString = new Intent(this, ExdeviceLikeUI.class);
        paramString.putExtra("app_username", this.vqe);
        paramString.putExtra("rank_id", this.voA);
        paramString.putExtra("key_is_like_read_only", true);
        paramString = new com.tencent.mm.hellhoundlib.b.a().bm(paramString);
        com.tencent.mm.hellhoundlib.a.a.b(this, paramString.aFh(), "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankInfoUI", "beforeLikeBtnClicked", "(Ljava/lang/String;I)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramString.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankInfoUI", "beforeLikeBtnClicked", "(Ljava/lang/String;I)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(24258);
        return true;
      }
      AppMethodBeat.o(24258);
      return false;
    }
    Log.d("MicroMsg.Sport.ExdeviceRankInfoUI", "hy: rank id is not valid.abort the event");
    Toast.makeText(this, getString(R.l.eDX), 0).show();
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
      if ((this.voA == null) || (!this.voA.equals(paramd.vil))) {
        break label216;
      }
      Log.i("MicroMsg.Sport.ExdeviceRankInfoUI", "onRankChange, rankId(%s).", new Object[] { this.voA });
      nc(true);
      if ((Util.isNullOrNil(this.vqg)) || (!this.vqg.equals(daK())))
      {
        daJ();
        this.vqf = ae.cZC().avE(this.vqg);
        runOnUiThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(24214);
            ExdeviceRankInfoUI.s(ExdeviceRankInfoUI.this);
            ExdeviceRankInfoUI.t(ExdeviceRankInfoUI.this);
            AppMethodBeat.o(24214);
          }
        });
      }
      runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(24215);
          ExdeviceRankInfoUI.u(ExdeviceRankInfoUI.this);
          if (!ExdeviceRankInfoUI.v(ExdeviceRankInfoUI.this))
          {
            ExdeviceRankInfoUI.h(ExdeviceRankInfoUI.this);
            AppMethodBeat.o(24215);
            return;
          }
          ExdeviceRankInfoUI.b(ExdeviceRankInfoUI.this).notifyDataSetChanged();
          AppMethodBeat.o(24215);
        }
      });
      AppMethodBeat.o(24252);
      return;
    }
    if (("HardDeviceChampionInfo".equals(paramString)) && (!Util.isNullOrNil(this.vqg)) && (this.vqg.equals(paramd.username)))
    {
      this.vqf = ae.cZC().avE(this.vqg);
      runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(24216);
          ExdeviceRankInfoUI.s(ExdeviceRankInfoUI.this);
          ExdeviceRankInfoUI.t(ExdeviceRankInfoUI.this);
          AppMethodBeat.o(24216);
        }
      });
    }
    label216:
    AppMethodBeat.o(24252);
  }
  
  public final void dD(String paramString, int paramInt)
  {
    AppMethodBeat.i(24256);
    ae.cZG();
    String str1 = this.voA;
    String str2 = this.vqe;
    com.tencent.mm.plugin.exdevice.g.b.b.d locald = ae.cZz();
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
  
  public final void daN()
  {
    AppMethodBeat.i(24255);
    com.tencent.mm.plugin.sport.a.d.rE(31);
    daO();
    AppMethodBeat.o(24255);
  }
  
  public int getLayoutId()
  {
    return R.i.egN;
  }
  
  public void initView()
  {
    AppMethodBeat.i(24244);
    this.vpY = findViewById(R.h.dPG);
    Object localObject1 = new ExdeviceRankListHeaderView(this);
    Object localObject2 = new Rect();
    getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject2);
    int j = ((Rect)localObject2).top;
    int i = j;
    if (j == 0) {
      i = com.tencent.mm.plugin.exdevice.k.b.F(this, getResources().getDimensionPixelSize(R.f.dkS));
    }
    localObject2 = getResources().getDisplayMetrics();
    if (((DisplayMetrics)localObject2).widthPixels > ((DisplayMetrics)localObject2).heightPixels)
    {
      j = getResources().getDimensionPixelSize(R.f.DefaultActionbarHeightLand);
      localObject2 = getWindowManager().getDefaultDisplay();
      j = ((Display)localObject2).getHeight() / 2 - i - j;
      if (((Display)localObject2).getHeight() > 0)
      {
        i = j;
        if (j > 0) {}
      }
      else
      {
        i = getResources().getDimensionPixelSize(R.f.dkR);
      }
      ((ExdeviceRankListHeaderView)localObject1).setMinimumHeight(i);
      ((ExdeviceRankListHeaderView)localObject1).setMinimumWidth(((Display)localObject2).getWidth());
      ((ExdeviceRankListHeaderView)localObject1).setTag(Integer.valueOf(i));
      this.vpZ = ((ExdeviceRankListHeaderView)localObject1);
      localObject1 = (MMPullDownView)findViewById(R.h.dRG);
      this.vpW = ((ListView)findViewById(R.h.dGd));
      this.vqa = ((ExdeviceRankChampionInfoView)findViewById(R.h.dvl));
      this.voK = findViewById(R.h.dTO);
      this.voK.setOnClickListener(new ExdeviceRankInfoUI.23(this));
      this.vpZ.setIsShowTip(false);
      daE();
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
          AppMethodBeat.i(24234);
          paramAnonymousMotionEvent = ExdeviceRankInfoUI.this;
          if ((ExdeviceRankInfoUI.a(ExdeviceRankInfoUI.this) != null) && (ExdeviceRankInfoUI.a(ExdeviceRankInfoUI.this).size() != 0)) {}
          for (boolean bool = true;; bool = false)
          {
            ExdeviceRankInfoUI.b(paramAnonymousMotionEvent, bool);
            AppMethodBeat.o(24234);
            return false;
          }
        }
      });
      ((MMPullDownView)localObject1).setAtBottomCallBack(new MMPullDownView.c()
      {
        public final boolean cOL()
        {
          AppMethodBeat.i(24207);
          View localView = ExdeviceRankInfoUI.q(ExdeviceRankInfoUI.this).getChildAt(ExdeviceRankInfoUI.q(ExdeviceRankInfoUI.this).getChildCount() - 1);
          int i = ExdeviceRankInfoUI.q(ExdeviceRankInfoUI.this).getCount();
          if ((i > 0) && (localView != null) && (localView.getBottom() <= ExdeviceRankInfoUI.q(ExdeviceRankInfoUI.this).getHeight()) && (ExdeviceRankInfoUI.q(ExdeviceRankInfoUI.this).getLastVisiblePosition() == i - 1))
          {
            AppMethodBeat.o(24207);
            return true;
          }
          AppMethodBeat.o(24207);
          return false;
        }
      });
      ((MMPullDownView)localObject1).setOnScrollChangedListener(new MMPullDownView.b()
      {
        public final void daG()
        {
          AppMethodBeat.i(24208);
          ExdeviceRankInfoUI.r(ExdeviceRankInfoUI.this);
          AppMethodBeat.o(24208);
        }
      });
      ((MMPullDownView)localObject1).setAtTopCallBack(new MMPullDownView.d()
      {
        public final boolean cOK()
        {
          AppMethodBeat.i(24209);
          int i = ExdeviceRankInfoUI.q(ExdeviceRankInfoUI.this).getFirstVisiblePosition();
          if (i == 0)
          {
            View localView = ExdeviceRankInfoUI.q(ExdeviceRankInfoUI.this).getChildAt(i);
            if ((localView != null) && (localView.getTop() >= 0))
            {
              AppMethodBeat.o(24209);
              return true;
            }
          }
          AppMethodBeat.o(24209);
          return false;
        }
      });
      this.vpW.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(24211);
          ExdeviceRankInfoUI.r(ExdeviceRankInfoUI.this);
          AppMethodBeat.o(24211);
        }
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
        {
          AppMethodBeat.i(24210);
          ExdeviceRankInfoUI.r(ExdeviceRankInfoUI.this);
          AppMethodBeat.o(24210);
        }
      });
      this.vpW.addHeaderView(this.vpZ, null, false);
      localObject2 = getLayoutInflater().inflate(R.i.egL, null);
      this.vqb = ((View)localObject2).findViewById(R.h.dJo);
      ((View)localObject2).findViewById(R.h.dJn).setOnClickListener(new ExdeviceRankInfoUI.6(this));
      this.vqb.setVisibility(8);
      this.vpW.addFooterView((View)localObject2);
      if (this.vqj == null) {
        break label759;
      }
    }
    label759:
    for (i = this.vqj.size();; i = 0)
    {
      if (this.vqk != null) {}
      for (j = this.vqk.size();; j = 0)
      {
        if (i + j == 0)
        {
          this.vqi = new ArrayList();
          this.vpX.vpl = this.vqi;
          getString(R.l.app_tip);
          this.vmw = com.tencent.mm.ui.base.h.a(this, getString(R.l.loading_tips), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              AppMethodBeat.i(24213);
              if (ExdeviceRankInfoUI.e(ExdeviceRankInfoUI.this) != null)
              {
                ExdeviceRankInfoUI.e(ExdeviceRankInfoUI.this).dismiss();
                ExdeviceRankInfoUI.f(ExdeviceRankInfoUI.this);
              }
              ExdeviceRankInfoUI.this.finish();
              AppMethodBeat.o(24213);
            }
          });
        }
        this.vpW.setAdapter(this.vpX);
        this.vpX.vpo = this;
        if (this.vqh == 1)
        {
          this.vpW.setVisibility(0);
          this.vpY.setVisibility(8);
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
          j = getResources().getDimensionPixelSize(R.f.DefaultActionbarHeightPort);
          break;
          this.vpW.setVisibility(8);
          this.vpY.setVisibility(0);
        }
        label638:
        this.voG = ((ImageView)findViewById(R.h.dFR));
        ((MMPullDownView)localObject1).setCanOverScrool(false);
        int k = com.tencent.mm.ci.a.kr(this);
        j = ((Integer)this.vpZ.getTag()).intValue();
        i = j;
        if (this.viv)
        {
          i = getResources().getDimensionPixelSize(R.f.dkU);
          int m = getResources().getDimensionPixelSize(R.f.dkT);
          i = j + (i / 2 + m);
        }
        localObject1 = new RelativeLayout.LayoutParams(k, i);
        this.voG.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        daM();
        nd(false);
        AppMethodBeat.o(24244);
        return;
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(24257);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (com.tencent.mm.plugin.exdevice.g.a.e.a(this, paramInt1, paramInt2, paramIntent, this.vqe))
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
      ad.a(this, (String)localObject, ad.ff(this), paramIntent, this.voM);
      com.tencent.mm.ui.base.h.cO(getContext(), getResources().getString(R.l.app_shared));
      Log.d("MicroMsg.Sport.ExdeviceRankInfoUI", "Select conversation return.");
      AppMethodBeat.o(24257);
      return;
      com.tencent.mm.ui.base.h.cO(getContext(), getResources().getString(R.l.app_shared));
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
          g.eRW().u("gh_43f2581f6fd6", str, ab.Lj(str));
          if (!Util.isNullOrNil(paramIntent))
          {
            uz localuz = new uz();
            localuz.fUn.fcD = str;
            localuz.fUn.content = paramIntent;
            localuz.fUn.type = ab.QZ(str);
            localuz.fUn.flags = 0;
            EventCenter.instance.publish(localuz);
          }
        }
        AppMethodBeat.o(24257);
        return;
        if ((paramIntent != null) && (paramIntent.getBooleanExtra("KeyNeedUpdateRank", false))) {
          daH();
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(24237);
    super.onCreate(paramBundle);
    this.mIsDestroyed = false;
    this.pRV = z.bcZ();
    paramBundle = getIntent();
    this.vqc = paramBundle.getStringExtra("key_rank_info");
    this.vqd = paramBundle.getStringExtra("key_rank_semi");
    this.vqe = paramBundle.getStringExtra("app_username");
    this.voA = paramBundle.getStringExtra("rank_id");
    this.vql = paramBundle.getBooleanExtra("key_is_latest", false);
    this.vqg = paramBundle.getStringExtra("key_champioin_username");
    this.vqh = paramBundle.getIntExtra("device_type", 0);
    this.vqn = paramBundle.getStringExtra("locate_to_username");
    this.vqm = paramBundle.getBooleanExtra("key_only_show_latest_rank", false);
    Object localObject;
    if ((Util.isNullOrNil(this.voA)) || ("#".equals(this.voA))) {
      if (!this.vqm)
      {
        paramBundle = ae.cZz();
        localObject = String.format("select * from %s order by %s desc limit 1", new Object[] { "HardDeviceRankInfo", "rankID" });
        localObject = paramBundle.db.rawQuery((String)localObject, null, 2);
        if (localObject != null) {
          break label734;
        }
        Log.e("MicroMsg.ExdeviceRankInfoStg", "Get no rank in DB");
        paramBundle = null;
      }
    }
    for (;;)
    {
      if (paramBundle != null)
      {
        this.voA = paramBundle.field_rankID;
        this.vqe = paramBundle.field_appusername;
      }
      this.vqg = null;
      this.vql = true;
      ae.cZG();
      this.vqk = com.tencent.mm.plugin.exdevice.g.b.c.avA(this.voA);
      if (!this.vqm)
      {
        if ((this.vqk == null) || (this.vqk.size() <= 0))
        {
          this.vqj = new ArrayList();
          this.vqk = com.tencent.mm.plugin.exdevice.g.a.a.a(this.voA, this.vqe, this.vqc, this.vqd, this.vpm, this.vqj);
          ae.cZG();
          com.tencent.mm.plugin.exdevice.g.b.c.f(this.voA, this.vqk);
          label341:
          this.vqj = ae.cZA().cZM();
        }
      }
      else
      {
        this.vpX = new b(this, this.vqe);
        this.vpX.vpm = this.vpm;
        this.vqi = this.vpX.b(this.vqj, this.vqk, this.viv);
        this.vpX.vpl = this.vqi;
        if (Util.isNullOrNil(this.vqg)) {
          daJ();
        }
        this.vqf = ae.cZC().avE(this.vqg);
        if ((this.vqf == null) && (!Util.isNullOrNil(this.vqg)))
        {
          this.vqf = new com.tencent.mm.plugin.exdevice.g.b.a.a();
          this.vqf.field_username = this.vqg;
          this.vqf.field_championMotto = getIntent().getStringExtra("key_champion_info");
          this.vqf.field_championUrl = getIntent().getStringExtra("key_champion_coverimg");
          ae.cZG();
          paramBundle = this.vqf;
          ae.cZC().a(paramBundle);
        }
        initView();
        if ((this.vqk != null) && (this.vqk.size() > 0))
        {
          paramBundle = ((com.tencent.mm.plugin.exdevice.g.b.a.d)this.vqk.get(0)).field_username;
          this.vqa.avR(paramBundle);
        }
        ae.cZH().a(this);
        ae.cZG().viH = this;
        daH();
        setBackBtn(new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(24228);
            ExdeviceRankInfoUI.this.finish();
            AppMethodBeat.o(24228);
            return false;
          }
        });
        setMMTitle(R.l.eEm);
        showOptionMenu(true);
        daI();
        ((com.tencent.mm.plugin.sport.a.c)LifecycleEventCenter.getEvent(com.tencent.mm.plugin.sport.a.c.class)).publish(Integer.valueOf(2));
        if (!com.tencent.mm.compatible.util.d.qX(28)) {}
      }
      try
      {
        if (androidx.core.content.a.checkSelfPermission(this, "android.permission.ACTIVITY_RECOGNITION") != 0)
        {
          Log.i("MicroMsg.Sport.ExdeviceRankInfoUI", "no ACTIVITY_RECOGNITION permission");
          androidx.core.app.a.a(this, new String[] { "android.permission.ACTIVITY_RECOGNITION" }, 5);
        }
        for (;;)
        {
          label677:
          if (com.tencent.mm.kernel.h.aHG().aHp().getInt(ar.a.VDg, 0) == 1)
          {
            Log.i("MicroMsg.Sport.ExdeviceRankInfoUI", "toast get step fail");
            Toast.makeText(this, R.l.eDZ, 0).show();
            com.tencent.mm.plugin.report.f.Iyx.idkeyStat(323L, 6L, 1L, false);
          }
          AppMethodBeat.o(24237);
          return;
          label734:
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
          com.tencent.mm.plugin.exdevice.g.a.a.b(this.vqc, this.vqd, this.vpm);
          break label341;
          Log.i("MicroMsg.Sport.ExdeviceRankInfoUI", "has ACTIVITY_RECOGNITION permission");
        }
      }
      catch (Exception paramBundle)
      {
        break label677;
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(24248);
    this.mIsDestroyed = true;
    if (this.vpX != null) {
      b.finish();
    }
    super.onDestroy();
    if (this.vqp != null) {
      this.vqp.viy = null;
    }
    ae.cZH().b(this);
    ae.cZG().viH = null;
    ae.cZG().viI = null;
    if (this.likeCount > 0)
    {
      int i = this.likeCount;
      Log.v("MicroMsg.Sport.SportReportLogic", "reportLikeCount count=%d", new Object[] { Integer.valueOf(i) });
      com.tencent.mm.plugin.report.f.Iyx.a(13168, new Object[] { Integer.valueOf(0), Integer.valueOf(i) });
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
    nc(true);
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