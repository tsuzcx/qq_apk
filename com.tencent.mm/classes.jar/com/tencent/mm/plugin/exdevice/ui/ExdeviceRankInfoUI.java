package com.tencent.mm.plugin.exdevice.ui;

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
import com.tencent.mm.autogen.a.wp;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.exdevice.g.a.j;
import com.tencent.mm.plugin.exdevice.g.a.j.a;
import com.tencent.mm.plugin.exdevice.model.ag;
import com.tencent.mm.plugin.exdevice.model.ag.a;
import com.tencent.mm.plugin.exdevice.model.ah;
import com.tencent.mm.plugin.messenger.a.g;
import com.tencent.mm.plugin.secdata.ui.MMSecDataActivity;
import com.tencent.mm.sdk.event.MvvmEventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sensitive.d.a;
import com.tencent.mm.sensitive.d.c;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.a;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.component.UIComponent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public class ExdeviceRankInfoUI
  extends MMSecDataActivity
  implements j.a, com.tencent.mm.plugin.exdevice.g.b.e, com.tencent.mm.plugin.exdevice.g.b.f, c
{
  private static int yBq = 128;
  private int likeCount;
  private boolean mIsDestroyed;
  private String sWX;
  private String szP;
  private String yAW;
  private Map<String, String> yBI;
  private ImageView yBc;
  private View yBg;
  private String yBh;
  private String yBi;
  private ArrayList<com.tencent.mm.plugin.exdevice.g.b.a.c> yCA;
  private ArrayList<com.tencent.mm.plugin.exdevice.g.b.a.d> yCB;
  private boolean yCC;
  private boolean yCD;
  private String yCE;
  private boolean yCF;
  private j yCG;
  private com.tencent.mm.plugin.exdevice.b.b<j> yCH;
  private ListView yCn;
  private b yCo;
  private View yCp;
  private ExdeviceRankListHeaderView yCq;
  private ExdeviceRankChampionInfoView yCr;
  private View yCs;
  private String yCt;
  private String yCu;
  private String yCv;
  private com.tencent.mm.plugin.exdevice.g.b.a.a yCw;
  private String yCx;
  private int yCy;
  private List<d> yCz;
  private boolean yui;
  public boolean yuu;
  public String yuv;
  private w yyY;
  
  public ExdeviceRankInfoUI()
  {
    AppMethodBeat.i(24235);
    this.yyY = null;
    this.yBI = new HashMap();
    this.yCH = new com.tencent.mm.plugin.exdevice.b.b() {};
    AppMethodBeat.o(24235);
  }
  
  private int apT(String paramString)
  {
    AppMethodBeat.i(24240);
    Log.i("MicroMsg.Sport.ExdeviceRankInfoUI", "locateToUser, locate2User(%s), username(%s).", new Object[] { paramString, this.sWX });
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(24240);
      return -1;
    }
    if ((this.yCz == null) || (this.yCz.size() == 0))
    {
      AppMethodBeat.o(24240);
      return -2;
    }
    int i = 0;
    while (i < this.yCz.size())
    {
      Object localObject = ((d)this.yCz.get(i)).yEC;
      int j = ((d)this.yCz.get(i)).yED;
      if ((localObject != null) && (paramString.equalsIgnoreCase(((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject).field_username)) && (!paramString.equalsIgnoreCase(this.sWX)) && ((j & 0x2) != 2))
      {
        localObject = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
        j = ((DisplayMetrics)localObject).heightPixels;
        Log.i("MicroMsg.Sport.ExdeviceRankInfoUI", "locateToUser pos(%d).(h : %d)", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        this.yCn.setSelectionFromTop(i, j / 4);
        this.yCo.yBJ = paramString;
        this.yCo.notifyDataSetInvalidated();
        dHf();
        AppMethodBeat.o(24240);
        return i;
      }
      i += 1;
    }
    this.yCo.yBJ = null;
    AppMethodBeat.o(24240);
    return -3;
  }
  
  private void dGY()
  {
    AppMethodBeat.i(24241);
    if ((this.yCw != null) && (this.sWX != null) && (this.sWX.equals(this.yCw.field_username)) && (Util.isNullOrNil(this.yCw.field_championUrl)))
    {
      if (this.yBg != null) {
        this.yBg.setVisibility(0);
      }
      if (this.yCq != null)
      {
        this.yCq.setOnViewClickListener(new ExdeviceRankInfoUI.21(this));
        AppMethodBeat.o(24241);
      }
    }
    else
    {
      if (this.yBg != null) {
        this.yBg.setVisibility(8);
      }
      if ((this.yCw != null) && (!Util.nullAs(this.yCw.field_username, "").equals(this.sWX)) && (!Util.isNullOrNil(this.yCw.field_championUrl))) {
        this.yCq.setOnViewClickListener(new ExdeviceRankInfoUI.22(this));
      }
    }
    AppMethodBeat.o(24241);
  }
  
  private void dHb()
  {
    AppMethodBeat.i(24238);
    Log.i("MicroMsg.Sport.ExdeviceRankInfoUI", "updateRankInfoUIFromServer");
    this.yCG = new j(this.yAW, this.yCv, this.yCx, this.yCC, this.yCH);
    this.yCG.yux = this;
    bh.aZW().a(this.yCG, 0);
    AppMethodBeat.o(24238);
  }
  
  private void dHc()
  {
    AppMethodBeat.i(24239);
    Log.i("MicroMsg.Sport.ExdeviceRankInfoUI", "try2LocateToUser, locate2User(%s), username(%s).", new Object[] { this.yCE, this.sWX });
    if ((Util.isNullOrNil(this.yCE)) || (apT(this.yCE) < 0))
    {
      Log.d("MicroMsg.Sport.ExdeviceRankInfoUI", "locate to username is null or nil.");
      AppMethodBeat.o(24239);
      return;
    }
    AppMethodBeat.o(24239);
  }
  
  private void dHd()
  {
    AppMethodBeat.i(24242);
    String str = dHe();
    if (!Util.isNullOrNil(str)) {
      this.yCx = str;
    }
    AppMethodBeat.o(24242);
  }
  
  private String dHe()
  {
    AppMethodBeat.i(24243);
    if (this.yCz != null)
    {
      Object localObject = this.yCz.iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.plugin.exdevice.g.b.a.d locald = ((d)((Iterator)localObject).next()).yEC;
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
  
  private void dHf()
  {
    AppMethodBeat.i(24245);
    View localView = this.yCn.getChildAt(0);
    int[] arrayOfInt = new int[2];
    if (localView != null)
    {
      if (this.yCn.getFirstVisiblePosition() == 0)
      {
        localView.getLocationOnScreen(arrayOfInt);
        if ((Util.isNullOrNil(this.yCE)) && (yBq == 128)) {
          yBq = arrayOfInt[1];
        }
        int i = arrayOfInt[1];
        if (i > 0)
        {
          if (i >= yBq) {}
          for (float f = 1.0F;; f = i / yBq)
          {
            Log.d("MicroMsg.Sport.ExdeviceRankInfoUI", "ap-alpha: %s", new Object[] { Float.valueOf(f) });
            this.yCr.setAlpha(f);
            this.yCr.setVisibility(0);
            this.yBg.setAlpha(f);
            AppMethodBeat.o(24245);
            return;
          }
        }
      }
      this.yCr.setAlpha(0.0F);
      this.yBg.setAlpha(0.0F);
      this.yCr.setVisibility(8);
    }
    AppMethodBeat.o(24245);
  }
  
  private void dHg()
  {
    AppMethodBeat.i(24250);
    if (this.yCw != null)
    {
      if ((this.szP != this.yCw.field_championUrl) && ((this.szP == null) || (!this.szP.equals(this.yCw.field_championUrl))))
      {
        com.tencent.mm.plugin.exdevice.g.a.e.a(this, this.yBc, this.yCw.field_championUrl, R.e.darkgrey);
        this.szP = this.yCw.field_championUrl;
        AppMethodBeat.o(24250);
      }
    }
    else
    {
      this.yBc.setImageResource(R.e.darkgrey);
      this.szP = null;
    }
    AppMethodBeat.o(24250);
  }
  
  private void dHi()
  {
    AppMethodBeat.i(24259);
    if (Util.isNullOrNil(this.yuv))
    {
      localObject = ah.dFV().apE(this.sWX);
      if (localObject != null) {
        this.yuv = ((com.tencent.mm.plugin.exdevice.g.b.a.a)localObject).field_championUrl;
      }
    }
    com.tencent.mm.plugin.exdevice.g.b.a.d locald = b.h(this.sWX, this.yCB);
    Object localObject = "--";
    String str = "0";
    if (locald != null)
    {
      localObject = String.valueOf(locald.field_ranknum);
      str = String.valueOf(locald.field_score);
    }
    new ag().a(this, (String)localObject, str, this.yuv, new ExdeviceRankInfoUI.11(this));
    AppMethodBeat.o(24259);
  }
  
  private void oC(boolean paramBoolean)
  {
    AppMethodBeat.i(24236);
    if ((this.yCD) && (!paramBoolean))
    {
      AppMethodBeat.o(24236);
      return;
    }
    ah.dFZ();
    this.yCB = com.tencent.mm.plugin.exdevice.g.b.c.apA(this.yAW);
    this.yCA = ah.dFT().dGf();
    this.yCz = this.yCo.b(this.yCA, this.yCB, this.yuu);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(24206);
        ExdeviceRankInfoUI.b(ExdeviceRankInfoUI.this).yBH = ExdeviceRankInfoUI.a(ExdeviceRankInfoUI.this);
        ExdeviceRankInfoUI.b(ExdeviceRankInfoUI.this).notifyDataSetChanged();
        ExdeviceRankInfoUI.c(ExdeviceRankInfoUI.this);
        AppMethodBeat.o(24206);
      }
    });
    AppMethodBeat.o(24236);
  }
  
  private void oD(boolean paramBoolean)
  {
    AppMethodBeat.i(24251);
    if (paramBoolean) {
      dHd();
    }
    if (!Util.isNullOrNil(this.yCv))
    {
      this.yCr.apR(this.yCx);
      this.yCr.setVisibility(0);
      AppMethodBeat.o(24251);
      return;
    }
    this.yCr.setVisibility(8);
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
    this.yBh = paramj.ytZ;
    this.yBi = paramj.svG;
    this.yuv = paramj.yuv;
    this.yuu = paramj.yuu;
    this.yui = paramj.yui;
    this.yCB = paramj.yun;
    this.yCA = paramj.yuo;
    this.yCz = this.yCo.b(this.yCA, this.yCB, this.yuu);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(24225);
        ExdeviceRankInfoUI.b(ExdeviceRankInfoUI.this).yBH = ExdeviceRankInfoUI.a(ExdeviceRankInfoUI.this);
        ExdeviceRankInfoUI.b(ExdeviceRankInfoUI.this).notifyDataSetChanged();
        ExdeviceRankInfoUI.c(ExdeviceRankInfoUI.this);
        AppMethodBeat.o(24225);
      }
    });
    AppMethodBeat.o(24260);
  }
  
  public final void apB(String paramString)
  {
    AppMethodBeat.i(24253);
    Log.d("MicroMsg.Sport.ExdeviceRankInfoUI", "hy: rank changed to %s", new Object[] { paramString });
    this.yAW = paramString;
    AppMethodBeat.o(24253);
  }
  
  public final void apU(String paramString)
  {
    AppMethodBeat.i(24254);
    com.tencent.mm.plugin.sport.a.d.rG(6);
    Intent localIntent = new Intent(this, ExdeviceProfileUI.class);
    localIntent.putExtra("username", paramString);
    localIntent.putExtra("usernickname", (String)this.yBI.get(paramString));
    localIntent.putExtra("app_username", this.yCv);
    localIntent.putExtra("rank_id", this.yAW);
    startActivityForResult(localIntent, 4);
    AppMethodBeat.o(24254);
  }
  
  public final boolean apV(String paramString)
  {
    AppMethodBeat.i(24258);
    if ((!Util.isNullOrNil(this.yAW)) && (!"#".equals(this.yAW)))
    {
      if (z.bAM().equals(paramString))
      {
        Log.d("MicroMsg.Sport.ExdeviceRankInfoUI", "hy: is self. see who likes me");
        paramString = new Intent(this, ExdeviceLikeUI.class);
        paramString.putExtra("app_username", this.yCv);
        paramString.putExtra("rank_id", this.yAW);
        paramString.putExtra("key_is_like_read_only", true);
        paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
        com.tencent.mm.hellhoundlib.a.a.b(this, paramString.aYi(), "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankInfoUI", "beforeLikeBtnClicked", "(Ljava/lang/String;I)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramString.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankInfoUI", "beforeLikeBtnClicked", "(Ljava/lang/String;I)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(24258);
        return true;
      }
      AppMethodBeat.o(24258);
      return false;
    }
    Log.d("MicroMsg.Sport.ExdeviceRankInfoUI", "hy: rank id is not valid.abort the event");
    Toast.makeText(this, getString(R.l.gGL), 0).show();
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
      if ((this.yAW == null) || (!this.yAW.equals(paramd.yuk))) {
        break label216;
      }
      Log.i("MicroMsg.Sport.ExdeviceRankInfoUI", "onRankChange, rankId(%s).", new Object[] { this.yAW });
      oC(true);
      if ((Util.isNullOrNil(this.yCx)) || (!this.yCx.equals(dHe())))
      {
        dHd();
        this.yCw = ah.dFV().apE(this.yCx);
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
    if (("HardDeviceChampionInfo".equals(paramString)) && (!Util.isNullOrNil(this.yCx)) && (this.yCx.equals(paramd.username)))
    {
      this.yCw = ah.dFV().apE(this.yCx);
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
  
  public final void dHh()
  {
    AppMethodBeat.i(24255);
    com.tencent.mm.plugin.sport.a.d.rG(31);
    dHi();
    AppMethodBeat.o(24255);
  }
  
  public final void eg(String paramString, int paramInt)
  {
    AppMethodBeat.i(24256);
    ah.dFZ();
    String str1 = this.yAW;
    String str2 = this.yCv;
    com.tencent.mm.plugin.exdevice.g.b.b.d locald = ah.dFS();
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
      com.tencent.mm.plugin.exdevice.g.b.c.f(str1, str2, paramString, paramInt);
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
    return R.i.gjJ;
  }
  
  public void initView()
  {
    AppMethodBeat.i(24244);
    this.yCp = findViewById(R.h.fRL);
    Object localObject1 = new ExdeviceRankListHeaderView(this);
    Object localObject2 = new Rect();
    getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject2);
    int j = ((Rect)localObject2).top;
    int i = j;
    if (j == 0) {
      i = com.tencent.mm.plugin.exdevice.k.b.I(this, getResources().getDimensionPixelSize(R.f.fli));
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
        i = getResources().getDimensionPixelSize(R.f.flh);
      }
      ((ExdeviceRankListHeaderView)localObject1).setMinimumHeight(i);
      ((ExdeviceRankListHeaderView)localObject1).setMinimumWidth(((Display)localObject2).getWidth());
      ((ExdeviceRankListHeaderView)localObject1).setTag(Integer.valueOf(i));
      this.yCq = ((ExdeviceRankListHeaderView)localObject1);
      localObject1 = (MMPullDownView)findViewById(R.h.fTG);
      this.yCn = ((ListView)findViewById(R.h.fHj));
      this.yCr = ((ExdeviceRankChampionInfoView)findViewById(R.h.fvC));
      this.yBg = findViewById(R.h.fVW);
      this.yBg.setOnClickListener(new ExdeviceRankInfoUI.23(this));
      this.yCq.setIsShowTip(false);
      dGY();
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
      ((MMPullDownView)localObject1).setAtBottomCallBack(new ExdeviceRankInfoUI.2(this));
      ((MMPullDownView)localObject1).setOnScrollChangedListener(new ExdeviceRankInfoUI.3(this));
      ((MMPullDownView)localObject1).setAtTopCallBack(new ExdeviceRankInfoUI.4(this));
      this.yCn.setOnScrollListener(new ExdeviceRankInfoUI.5(this));
      this.yCn.addHeaderView(this.yCq, null, false);
      localObject2 = getLayoutInflater().inflate(R.i.gjH, null);
      this.yCs = ((View)localObject2).findViewById(R.h.fKI);
      ((View)localObject2).findViewById(R.h.fKH).setOnClickListener(new ExdeviceRankInfoUI.6(this));
      this.yCs.setVisibility(8);
      this.yCn.addFooterView((View)localObject2);
      if (this.yCA == null) {
        break label759;
      }
    }
    label759:
    for (i = this.yCA.size();; i = 0)
    {
      if (this.yCB != null) {}
      for (j = this.yCB.size();; j = 0)
      {
        if (i + j == 0)
        {
          this.yCz = new ArrayList();
          this.yCo.yBH = this.yCz;
          getString(R.l.app_tip);
          this.yyY = k.a(this, getString(R.l.loading_tips), true, new DialogInterface.OnCancelListener()
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
        this.yCn.setAdapter(this.yCo);
        this.yCo.yBK = this;
        if (this.yCy == 1)
        {
          this.yCn.setVisibility(0);
          this.yCp.setVisibility(8);
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
          this.yCn.setVisibility(8);
          this.yCp.setVisibility(0);
        }
        label638:
        this.yBc = ((ImageView)findViewById(R.h.fGX));
        ((MMPullDownView)localObject1).setCanOverScrool(false);
        int k = com.tencent.mm.cd.a.ms(this);
        j = ((Integer)this.yCq.getTag()).intValue();
        i = j;
        if (this.yuu)
        {
          i = getResources().getDimensionPixelSize(R.f.flk);
          int m = getResources().getDimensionPixelSize(R.f.flj);
          i = j + (i / 2 + m);
        }
        localObject1 = new RelativeLayout.LayoutParams(k, i);
        this.yBc.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        dHg();
        oD(false);
        AppMethodBeat.o(24244);
        return;
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(24257);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (com.tencent.mm.plugin.exdevice.g.a.e.a(this, paramInt1, paramInt2, paramIntent, this.yCv))
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
      ag.a(this, (String)localObject, ag.gc(this), paramIntent, this.yBi);
      k.cZ(getContext(), getResources().getString(R.l.app_shared));
      Log.d("MicroMsg.Sport.ExdeviceRankInfoUI", "Select conversation return.");
      AppMethodBeat.o(24257);
      return;
      k.cZ(getContext(), getResources().getString(R.l.app_shared));
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
          g.gaI().B("gh_43f2581f6fd6", str, au.bwE(str));
          if (!Util.isNullOrNil(paramIntent))
          {
            wp localwp = new wp();
            localwp.iak.hgl = str;
            localwp.iak.content = paramIntent;
            localwp.iak.type = ab.IX(str);
            localwp.iak.flags = 0;
            localwp.publish();
          }
        }
        AppMethodBeat.o(24257);
        return;
        if ((paramIntent != null) && (paramIntent.getBooleanExtra("KeyNeedUpdateRank", false))) {
          dHb();
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(24237);
    super.onCreate(paramBundle);
    this.mIsDestroyed = false;
    this.sWX = z.bAM();
    paramBundle = getIntent();
    this.yCt = paramBundle.getStringExtra("key_rank_info");
    this.yCu = paramBundle.getStringExtra("key_rank_semi");
    this.yCv = paramBundle.getStringExtra("app_username");
    this.yAW = paramBundle.getStringExtra("rank_id");
    this.yCC = paramBundle.getBooleanExtra("key_is_latest", false);
    this.yCx = paramBundle.getStringExtra("key_champioin_username");
    this.yCy = paramBundle.getIntExtra("device_type", 0);
    this.yCE = paramBundle.getStringExtra("locate_to_username");
    this.yCD = paramBundle.getBooleanExtra("key_only_show_latest_rank", false);
    Object localObject;
    if ((Util.isNullOrNil(this.yAW)) || ("#".equals(this.yAW))) {
      if (!this.yCD)
      {
        paramBundle = ah.dFS();
        localObject = String.format("select * from %s order by %s desc limit 1", new Object[] { "HardDeviceRankInfo", "rankID" });
        localObject = paramBundle.db.rawQuery((String)localObject, null, 2);
        if (localObject != null) {
          break label729;
        }
        Log.e("MicroMsg.ExdeviceRankInfoStg", "Get no rank in DB");
        paramBundle = null;
      }
    }
    for (;;)
    {
      if (paramBundle != null)
      {
        this.yAW = paramBundle.field_rankID;
        this.yCv = paramBundle.field_appusername;
      }
      this.yCx = null;
      this.yCC = true;
      ah.dFZ();
      this.yCB = com.tencent.mm.plugin.exdevice.g.b.c.apA(this.yAW);
      if (!this.yCD)
      {
        if ((this.yCB == null) || (this.yCB.size() <= 0))
        {
          this.yCA = new ArrayList();
          this.yCB = com.tencent.mm.plugin.exdevice.g.a.a.a(this.yAW, this.yCv, this.yCt, this.yCu, this.yBI, this.yCA);
          ah.dFZ();
          com.tencent.mm.plugin.exdevice.g.b.c.f(this.yAW, this.yCB);
          label341:
          this.yCA = ah.dFT().dGf();
        }
      }
      else
      {
        this.yCo = new b(this, this.yCv);
        this.yCo.yBI = this.yBI;
        this.yCz = this.yCo.b(this.yCA, this.yCB, this.yuu);
        this.yCo.yBH = this.yCz;
        if (Util.isNullOrNil(this.yCx)) {
          dHd();
        }
        this.yCw = ah.dFV().apE(this.yCx);
        if ((this.yCw == null) && (!Util.isNullOrNil(this.yCx)))
        {
          this.yCw = new com.tencent.mm.plugin.exdevice.g.b.a.a();
          this.yCw.field_username = this.yCx;
          this.yCw.field_championMotto = getIntent().getStringExtra("key_champion_info");
          this.yCw.field_championUrl = getIntent().getStringExtra("key_champion_coverimg");
          ah.dFZ();
          paramBundle = this.yCw;
          ah.dFV().a(paramBundle);
        }
        initView();
        if ((this.yCB != null) && (this.yCB.size() > 0))
        {
          paramBundle = ((com.tencent.mm.plugin.exdevice.g.b.a.d)this.yCB.get(0)).field_username;
          this.yCr.apR(paramBundle);
        }
        ah.dGa().a(this);
        ah.dFZ().yuG = this;
        dHb();
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
        setMMTitle(R.l.gHd);
        showOptionMenu(true);
        dHc();
        ((com.tencent.mm.plugin.sport.a.c)MvvmEventCenter.getEvent(com.tencent.mm.plugin.sport.a.c.class)).publish(Integer.valueOf(2));
        if (!com.tencent.mm.compatible.util.d.rd(28)) {}
      }
      try
      {
        if (androidx.core.content.a.checkSelfPermission(this, "android.permission.ACTIVITY_RECOGNITION") != 0)
        {
          Log.i("MicroMsg.Sport.ExdeviceRankInfoUI", "no ACTIVITY_RECOGNITION permission");
          com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.ACTIVITY_RECOGNITION", 5, null);
        }
        for (;;)
        {
          label672:
          if (h.baE().ban().getInt(at.a.adgb, 0) == 1)
          {
            Log.i("MicroMsg.Sport.ExdeviceRankInfoUI", "toast get step fail");
            Toast.makeText(this, R.l.gGN, 0).show();
            com.tencent.mm.plugin.report.f.Ozc.idkeyStat(323L, 6L, 1L, false);
          }
          AppMethodBeat.o(24237);
          return;
          label729:
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
          com.tencent.mm.plugin.exdevice.g.a.a.b(this.yCt, this.yCu, this.yBI);
          break label341;
          paramBundle = com.tencent.mm.sensitive.ui.a.acvO;
          if (com.tencent.mm.sensitive.ui.a.a(d.c.actA, d.a.acti, null))
          {
            Toast.makeText(this, R.l.gGN, 0).show();
            Log.i("MicroMsg.Sport.ExdeviceRankInfoUI", "business switch close");
          }
          Log.i("MicroMsg.Sport.ExdeviceRankInfoUI", "has ACTIVITY_RECOGNITION permission");
        }
      }
      catch (Exception paramBundle)
      {
        break label672;
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(24248);
    this.mIsDestroyed = true;
    if (this.yCo != null) {
      b.finish();
    }
    super.onDestroy();
    if (this.yCG != null) {
      this.yCG.yux = null;
    }
    ah.dGa().b(this);
    ah.dFZ().yuG = null;
    ah.dFZ().yuH = null;
    if (this.likeCount > 0)
    {
      int i = this.likeCount;
      Log.v("MicroMsg.Sport.SportReportLogic", "reportLikeCount count=%d", new Object[] { Integer.valueOf(i) });
      com.tencent.mm.plugin.report.f.Ozc.b(13168, new Object[] { Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(0) });
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
    oC(true);
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
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(274910);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(f.class);
    paramHashSet.add(com.tencent.mm.plugin.exdevice.ui.a.a.class);
    AppMethodBeat.o(274910);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI
 * JD-Core Version:    0.7.0.1
 */