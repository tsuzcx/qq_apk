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
import android.view.View.OnClickListener;
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
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.sb;
import com.tencent.mm.g.a.ui;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.n;
import com.tencent.mm.plugin.exdevice.g.a.j.a;
import com.tencent.mm.plugin.exdevice.g.b.f;
import com.tencent.mm.plugin.exdevice.model.ac;
import com.tencent.mm.plugin.exdevice.model.ac.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.a;
import com.tencent.mm.ui.base.MMPullDownView.b;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public class ExdeviceRankInfoUI
  extends MMActivity
  implements j.a, com.tencent.mm.plugin.exdevice.g.b.e, f, d
{
  private static int peP = 128;
  private String kGt;
  private String knl;
  private int likeCount;
  private boolean mIsDestroyed;
  private boolean oYk;
  public boolean oYw;
  public String oYx;
  private p pcl;
  private View peB;
  private String peD;
  private String peE;
  private ImageView pev;
  private ListView pfJ;
  private b pfK;
  private View pfL;
  private ExdeviceRankListHeaderView pfM;
  private ExdeviceRankChampionInfoView pfN;
  private View pfO;
  private String pfP;
  private String pfQ;
  private String pfR;
  private String pfS;
  private com.tencent.mm.plugin.exdevice.g.b.a.a pfT;
  private String pfU;
  private int pfV;
  private List<e> pfW;
  private ArrayList<com.tencent.mm.plugin.exdevice.g.b.a.c> pfX;
  private ArrayList<com.tencent.mm.plugin.exdevice.g.b.a.d> pfY;
  private boolean pfZ;
  private Map<String, String> pfi;
  private boolean pga;
  private String pgb;
  private boolean pgc;
  private com.tencent.mm.plugin.exdevice.g.a.j pgd;
  private com.tencent.mm.plugin.exdevice.b.b<com.tencent.mm.plugin.exdevice.g.a.j> pge;
  
  public ExdeviceRankInfoUI()
  {
    AppMethodBeat.i(24235);
    this.pcl = null;
    this.pfi = new HashMap();
    this.pge = new com.tencent.mm.plugin.exdevice.b.b() {};
    AppMethodBeat.o(24235);
  }
  
  private int Vd(String paramString)
  {
    AppMethodBeat.i(24240);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Sport.ExdeviceRankInfoUI", "locateToUser, locate2User(%s), username(%s).", new Object[] { paramString, this.kGt });
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(24240);
      return -1;
    }
    if ((this.pfW == null) || (this.pfW.size() == 0))
    {
      AppMethodBeat.o(24240);
      return -2;
    }
    int i = 0;
    while (i < this.pfW.size())
    {
      Object localObject = ((e)this.pfW.get(i)).pib;
      int j = ((e)this.pfW.get(i)).pic;
      if ((localObject != null) && (paramString.equalsIgnoreCase(((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject).field_username)) && (!paramString.equalsIgnoreCase(this.kGt)) && ((j & 0x2) != 2))
      {
        localObject = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
        j = ((DisplayMetrics)localObject).heightPixels;
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Sport.ExdeviceRankInfoUI", "locateToUser pos(%d).(h : %d)", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        this.pfJ.setSelectionFromTop(i, j / 4);
        this.pfK.pfj = paramString;
        this.pfK.notifyDataSetInvalidated();
        caK();
        AppMethodBeat.o(24240);
        return i;
      }
      i += 1;
    }
    this.pfK.pfj = null;
    AppMethodBeat.o(24240);
    return -3;
  }
  
  private void caA()
  {
    AppMethodBeat.i(24241);
    if ((this.pfT != null) && (this.kGt != null) && (this.kGt.equals(this.pfT.field_username)) && (bt.isNullOrNil(this.pfT.field_championUrl)))
    {
      if (this.peB != null) {
        this.peB.setVisibility(0);
      }
      if (this.pfM != null)
      {
        this.pfM.setOnViewClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(24232);
            com.tencent.mm.plugin.exdevice.g.a.e.e(ExdeviceRankInfoUI.this);
            AppMethodBeat.o(24232);
          }
        });
        AppMethodBeat.o(24241);
      }
    }
    else
    {
      if (this.peB != null) {
        this.peB.setVisibility(8);
      }
      if ((this.pfT != null) && (!bt.by(this.pfT.field_username, "").equals(this.kGt)) && (!bt.isNullOrNil(this.pfT.field_championUrl))) {
        this.pfM.setOnViewClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(24233);
            ExdeviceRankInfoUI.p(ExdeviceRankInfoUI.this);
            AppMethodBeat.o(24233);
          }
        });
      }
    }
    AppMethodBeat.o(24241);
  }
  
  private void caG()
  {
    AppMethodBeat.i(24238);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Sport.ExdeviceRankInfoUI", "updateRankInfoUIFromServer");
    this.pgd = new com.tencent.mm.plugin.exdevice.g.a.j(this.pfS, this.pfR, this.pfU, this.pfZ, this.pge);
    this.pgd.oYz = this;
    az.aeS().a(this.pgd, 0);
    AppMethodBeat.o(24238);
  }
  
  private void caH()
  {
    AppMethodBeat.i(24239);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Sport.ExdeviceRankInfoUI", "try2LocateToUser, locate2User(%s), username(%s).", new Object[] { this.pgb, this.kGt });
    if ((bt.isNullOrNil(this.pgb)) || (Vd(this.pgb) < 0))
    {
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.Sport.ExdeviceRankInfoUI", "locate to username is null or nil.");
      AppMethodBeat.o(24239);
      return;
    }
    AppMethodBeat.o(24239);
  }
  
  private void caI()
  {
    AppMethodBeat.i(24242);
    String str = caJ();
    if (!bt.isNullOrNil(str)) {
      this.pfU = str;
    }
    AppMethodBeat.o(24242);
  }
  
  private String caJ()
  {
    AppMethodBeat.i(24243);
    if (this.pfW != null)
    {
      Object localObject = this.pfW.iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.plugin.exdevice.g.b.a.d locald = ((e)((Iterator)localObject).next()).pib;
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
  
  private void caK()
  {
    AppMethodBeat.i(24245);
    View localView = this.pfJ.getChildAt(0);
    int[] arrayOfInt = new int[2];
    if (localView != null)
    {
      if (this.pfJ.getFirstVisiblePosition() == 0)
      {
        localView.getLocationOnScreen(arrayOfInt);
        if ((bt.isNullOrNil(this.pgb)) && (peP == 128)) {
          peP = arrayOfInt[1];
        }
        int i = arrayOfInt[1];
        if (i > 0)
        {
          if (i >= peP) {}
          for (float f = 1.0F;; f = i / peP)
          {
            com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.Sport.ExdeviceRankInfoUI", "ap-alpha: %s", new Object[] { Float.valueOf(f) });
            this.pfN.setAlpha(f);
            this.pfN.setVisibility(0);
            this.peB.setAlpha(f);
            AppMethodBeat.o(24245);
            return;
          }
        }
      }
      this.pfN.setAlpha(0.0F);
      this.peB.setAlpha(0.0F);
      this.pfN.setVisibility(8);
    }
    AppMethodBeat.o(24245);
  }
  
  private void caL()
  {
    AppMethodBeat.i(24250);
    if (this.pfT != null)
    {
      if ((this.knl != this.pfT.field_championUrl) && ((this.knl == null) || (!this.knl.equals(this.pfT.field_championUrl))))
      {
        com.tencent.mm.plugin.exdevice.g.a.e.a(this, this.pev, this.pfT.field_championUrl);
        this.knl = this.pfT.field_championUrl;
        AppMethodBeat.o(24250);
      }
    }
    else
    {
      this.pev.setImageResource(2131100204);
      this.knl = null;
    }
    AppMethodBeat.o(24250);
  }
  
  private void caN()
  {
    AppMethodBeat.i(24259);
    if (bt.isNullOrNil(this.oYx))
    {
      localObject = com.tencent.mm.plugin.exdevice.model.ad.bZK().UN(this.kGt);
      if (localObject != null) {
        this.oYx = ((com.tencent.mm.plugin.exdevice.g.b.a.a)localObject).field_championUrl;
      }
    }
    com.tencent.mm.plugin.exdevice.g.b.a.d locald = b.g(this.kGt, this.pfY);
    Object localObject = "--";
    String str = "0";
    if (locald != null)
    {
      localObject = String.valueOf(locald.field_ranknum);
      str = String.valueOf(locald.field_score);
    }
    new ac().a(this, (String)localObject, str, this.oYx, new ExdeviceRankInfoUI.13(this));
    AppMethodBeat.o(24259);
  }
  
  private void ka(boolean paramBoolean)
  {
    AppMethodBeat.i(24236);
    if ((this.pga) && (!paramBoolean))
    {
      AppMethodBeat.o(24236);
      return;
    }
    com.tencent.mm.plugin.exdevice.model.ad.bZO();
    this.pfY = com.tencent.mm.plugin.exdevice.g.b.c.UJ(this.pfS);
    this.pfX = com.tencent.mm.plugin.exdevice.model.ad.bZI().bZU();
    this.pfW = this.pfK.b(this.pfX, this.pfY, this.oYw);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(24206);
        ExdeviceRankInfoUI.b(ExdeviceRankInfoUI.this).pfh = ExdeviceRankInfoUI.a(ExdeviceRankInfoUI.this);
        ExdeviceRankInfoUI.b(ExdeviceRankInfoUI.this).notifyDataSetChanged();
        ExdeviceRankInfoUI.c(ExdeviceRankInfoUI.this);
        AppMethodBeat.o(24206);
      }
    });
    AppMethodBeat.o(24236);
  }
  
  private void kb(boolean paramBoolean)
  {
    AppMethodBeat.i(24251);
    if (paramBoolean) {
      caI();
    }
    if (!bt.isNullOrNil(this.pfR))
    {
      this.pfN.Vb(this.pfU);
      this.pfN.setVisibility(0);
      AppMethodBeat.o(24251);
      return;
    }
    this.pfN.setVisibility(8);
    AppMethodBeat.o(24251);
  }
  
  public final void UK(String paramString)
  {
    AppMethodBeat.i(24253);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.Sport.ExdeviceRankInfoUI", "hy: rank changed to %s", new Object[] { paramString });
    this.pfS = paramString;
    AppMethodBeat.o(24253);
  }
  
  public final void Ve(String paramString)
  {
    AppMethodBeat.i(24254);
    com.tencent.mm.plugin.sport.a.c.lI(6);
    Intent localIntent = new Intent(this, ExdeviceProfileUI.class);
    localIntent.putExtra("username", paramString);
    localIntent.putExtra("usernickname", (String)this.pfi.get(paramString));
    localIntent.putExtra("app_username", this.pfR);
    localIntent.putExtra("rank_id", this.pfS);
    startActivityForResult(localIntent, 4);
    AppMethodBeat.o(24254);
  }
  
  public final boolean Vf(String paramString)
  {
    AppMethodBeat.i(24258);
    if ((!bt.isNullOrNil(this.pfS)) && (!"#".equals(this.pfS)))
    {
      if (u.aqG().equals(paramString))
      {
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.Sport.ExdeviceRankInfoUI", "hy: is self. see who likes me");
        paramString = new Intent(this, ExdeviceLikeUI.class);
        paramString.putExtra("app_username", this.pfR);
        paramString.putExtra("rank_id", this.pfS);
        paramString.putExtra("key_is_like_read_only", true);
        paramString = new com.tencent.mm.hellhoundlib.b.a().bd(paramString);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramString.adn(), "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankInfoUI", "beforeLikeBtnClicked", "(Ljava/lang/String;I)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramString.lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankInfoUI", "beforeLikeBtnClicked", "(Ljava/lang/String;I)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(24258);
        return true;
      }
      AppMethodBeat.o(24258);
      return false;
    }
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.Sport.ExdeviceRankInfoUI", "hy: rank id is not valid.abort the event");
    Toast.makeText(this, getString(2131758586), 0).show();
    AppMethodBeat.o(24258);
    return true;
  }
  
  public final void a(com.tencent.mm.plugin.exdevice.g.a.j paramj)
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
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.Sport.ExdeviceRankInfoUI", "dismiss tips dialog.");
        }
        AppMethodBeat.o(24225);
      }
    });
    this.peD = paramj.oYa;
    this.peE = paramj.oYb;
    this.oYx = paramj.oYx;
    this.oYw = paramj.oYw;
    this.oYk = paramj.oYk;
    this.pfY = paramj.oYp;
    this.pfX = paramj.oYq;
    this.pfW = this.pfK.b(this.pfX, this.pfY, this.oYw);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(179640);
        ExdeviceRankInfoUI.b(ExdeviceRankInfoUI.this).pfh = ExdeviceRankInfoUI.a(ExdeviceRankInfoUI.this);
        ExdeviceRankInfoUI.b(ExdeviceRankInfoUI.this).notifyDataSetChanged();
        ExdeviceRankInfoUI.c(ExdeviceRankInfoUI.this);
        AppMethodBeat.o(179640);
      }
    });
    AppMethodBeat.o(24260);
  }
  
  public final void b(String paramString, com.tencent.mm.plugin.exdevice.g.b.d paramd)
  {
    AppMethodBeat.i(24252);
    if ((paramd != null) && (!bt.isNullOrNil(paramString))) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if (!"HardDeviceRankInfo".equals(paramString)) {
        break;
      }
      if ((this.pfS == null) || (!this.pfS.equals(paramd.oYm))) {
        break label216;
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Sport.ExdeviceRankInfoUI", "onRankChange, rankId(%s).", new Object[] { this.pfS });
      ka(true);
      if ((bt.isNullOrNil(this.pfU)) || (!this.pfU.equals(caJ())))
      {
        caI();
        this.pfT = com.tencent.mm.plugin.exdevice.model.ad.bZK().UN(this.pfU);
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
    if (("HardDeviceChampionInfo".equals(paramString)) && (!bt.isNullOrNil(this.pfU)) && (this.pfU.equals(paramd.username)))
    {
      this.pfT = com.tencent.mm.plugin.exdevice.model.ad.bZK().UN(this.pfU);
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
  
  public final void cQ(String paramString, int paramInt)
  {
    AppMethodBeat.i(24256);
    com.tencent.mm.plugin.exdevice.model.ad.bZO();
    String str1 = this.pfS;
    String str2 = this.pfR;
    com.tencent.mm.plugin.exdevice.g.b.b.d locald = com.tencent.mm.plugin.exdevice.model.ad.bZH();
    boolean bool;
    com.tencent.mm.plugin.exdevice.g.b.a.d locald1;
    if ((!bt.isNullOrNil(str1)) && (!bt.isNullOrNil(paramString)) && ((paramInt == 1) || (paramInt == 0) || (paramInt == 2)))
    {
      bool = true;
      Assert.assertTrue(bool);
      locald1 = locald.a(new com.tencent.mm.plugin.exdevice.g.b.d(str1, null, paramString));
      if (locald1 != null) {
        break label125;
      }
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.ExdeviceRankInfoStg", "hy: info is null. abort");
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
        com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.ExdeviceRankInfoStg", "hy: still loading...abort");
      }
    }
    for (locald1.field_likecount += 1;; locald1.field_likecount -= 1)
    {
      locald.a(locald1, true);
      break;
    }
  }
  
  public final void caM()
  {
    AppMethodBeat.i(24255);
    com.tencent.mm.plugin.sport.a.c.lI(31);
    caN();
    AppMethodBeat.o(24255);
  }
  
  public int getLayoutId()
  {
    return 2131493887;
  }
  
  public void initView()
  {
    AppMethodBeat.i(24244);
    this.pfL = findViewById(2131302912);
    Object localObject1 = new ExdeviceRankListHeaderView(this);
    Object localObject2 = new Rect();
    getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject2);
    int j = ((Rect)localObject2).top;
    int i = j;
    if (j == 0) {
      i = com.tencent.mm.plugin.exdevice.k.b.M(this, getResources().getDimensionPixelSize(2131165316));
    }
    localObject2 = getResources().getDisplayMetrics();
    if (((DisplayMetrics)localObject2).widthPixels > ((DisplayMetrics)localObject2).heightPixels)
    {
      j = getResources().getDimensionPixelSize(2131165251);
      localObject2 = getWindowManager().getDefaultDisplay();
      j = ((Display)localObject2).getHeight() / 2 - i - j;
      if (((Display)localObject2).getHeight() > 0)
      {
        i = j;
        if (j > 0) {}
      }
      else
      {
        i = getResources().getDimensionPixelSize(2131165310);
      }
      ((ExdeviceRankListHeaderView)localObject1).setMinimumHeight(i);
      ((ExdeviceRankListHeaderView)localObject1).setMinimumWidth(((Display)localObject2).getWidth());
      ((ExdeviceRankListHeaderView)localObject1).setTag(Integer.valueOf(i));
      this.pfM = ((ExdeviceRankListHeaderView)localObject1);
      localObject1 = (MMPullDownView)findViewById(2131303544);
      this.pfJ = ((ListView)findViewById(2131299583));
      this.pfN = ((ExdeviceRankChampionInfoView)findViewById(2131297945));
      this.peB = findViewById(2131304599);
      this.peB.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(179647);
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.Sport.ExdeviceRankInfoUI", "ap: start change cover");
          com.tencent.mm.plugin.exdevice.g.a.e.e(ExdeviceRankInfoUI.this);
          AppMethodBeat.o(179647);
        }
      });
      this.pfM.setIsShowTip(false);
      caA();
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
        public final void caF()
        {
          AppMethodBeat.i(179632);
          ExdeviceRankInfoUI.r(ExdeviceRankInfoUI.this);
          AppMethodBeat.o(179632);
        }
      });
      ((MMPullDownView)localObject1).setAtTopCallBack(new ExdeviceRankInfoUI.5(this));
      this.pfJ.setOnScrollListener(new AbsListView.OnScrollListener()
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
      this.pfJ.addHeaderView(this.pfM, null, false);
      localObject2 = getLayoutInflater().inflate(2131493885, null);
      this.pfO = ((View)localObject2).findViewById(2131301056);
      ((View)localObject2).findViewById(2131301055).setOnClickListener(new ExdeviceRankInfoUI.7(this));
      this.pfO.setVisibility(8);
      this.pfJ.addFooterView((View)localObject2);
      if (this.pfX == null) {
        break label759;
      }
    }
    label759:
    for (i = this.pfX.size();; i = 0)
    {
      if (this.pfY != null) {}
      for (j = this.pfY.size();; j = 0)
      {
        if (i + j == 0)
        {
          this.pfW = new ArrayList();
          this.pfK.pfh = this.pfW;
          getString(2131755906);
          this.pcl = h.b(this, getString(2131760709), true, new DialogInterface.OnCancelListener()
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
        this.pfJ.setAdapter(this.pfK);
        this.pfK.pfk = this;
        if (this.pfV == 1)
        {
          this.pfJ.setVisibility(0);
          this.pfL.setVisibility(8);
        }
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label638;
          }
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.Sport.ExdeviceRankInfoUI", "hy: cannot handle this device type");
          finish();
          AppMethodBeat.o(24244);
          return;
          j = getResources().getDimensionPixelSize(2131165252);
          break;
          this.pfJ.setVisibility(8);
          this.pfL.setVisibility(0);
        }
        label638:
        this.pev = ((ImageView)findViewById(2131299545));
        ((MMPullDownView)localObject1).setCanOverScrool(false);
        int k = com.tencent.mm.cd.a.hV(this);
        j = ((Integer)this.pfM.getTag()).intValue();
        i = j;
        if (this.oYw)
        {
          i = getResources().getDimensionPixelSize(2131165326);
          int m = getResources().getDimensionPixelSize(2131165325);
          i = j + (i / 2 + m);
        }
        localObject1 = new RelativeLayout.LayoutParams(k, i);
        this.pev.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        caL();
        kb(false);
        AppMethodBeat.o(24244);
        return;
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(24257);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (com.tencent.mm.plugin.exdevice.g.a.e.a(this, paramInt1, paramInt2, paramIntent, this.pfR))
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
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Sport.ExdeviceRankInfoUI", "onActivityResult, data is null.(reqestCode : %d)", new Object[] { Integer.valueOf(paramInt1) });
        AppMethodBeat.o(24257);
        return;
      }
      if (paramIntent == null) {}
      for (Object localObject = null; (localObject == null) || (((String)localObject).length() == 0); localObject = paramIntent.getStringExtra("Select_Conv_User"))
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Sport.ExdeviceRankInfoUI", "select conversation failed, toUser is null.");
        AppMethodBeat.o(24257);
        return;
      }
      paramIntent = paramIntent.getStringExtra("custom_send_text");
      ac.a(this, (String)localObject, ac.ev(this), paramIntent, this.peE);
      h.cf(getContext(), getResources().getString(2131755894));
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.Sport.ExdeviceRankInfoUI", "Select conversation return.");
      AppMethodBeat.o(24257);
      return;
      h.cf(getContext(), getResources().getString(2131755894));
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.Sport.ExdeviceRankInfoUI", "Share to timeline return.");
      AppMethodBeat.o(24257);
      return;
      if (paramIntent != null)
      {
        localObject = bt.S(paramIntent.getStringExtra("received_card_name").split(","));
        paramIntent = paramIntent.getStringExtra("custom_send_text");
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          com.tencent.mm.plugin.messenger.a.j.cOB().q("gh_43f2581f6fd6", str, w.pF(str));
          if (!bt.isNullOrNil(paramIntent))
          {
            sb localsb = new sb();
            localsb.dxJ.dxK = str;
            localsb.dxJ.content = paramIntent;
            localsb.dxJ.type = w.tq(str);
            localsb.dxJ.flags = 0;
            com.tencent.mm.sdk.b.a.ESL.l(localsb);
          }
        }
        AppMethodBeat.o(24257);
        return;
        if ((paramIntent != null) && (paramIntent.getBooleanExtra("KeyNeedUpdateRank", false))) {
          caG();
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(24237);
    super.onCreate(paramBundle);
    this.mIsDestroyed = false;
    this.kGt = u.aqG();
    paramBundle = getIntent();
    this.pfP = paramBundle.getStringExtra("key_rank_info");
    this.pfQ = paramBundle.getStringExtra("key_rank_semi");
    this.pfR = paramBundle.getStringExtra("app_username");
    this.pfS = paramBundle.getStringExtra("rank_id");
    this.pfZ = paramBundle.getBooleanExtra("key_is_latest", false);
    this.pfU = paramBundle.getStringExtra("key_champioin_username");
    this.pfV = paramBundle.getIntExtra("device_type", 0);
    this.pgb = paramBundle.getStringExtra("locate_to_username");
    this.pga = paramBundle.getBooleanExtra("key_only_show_latest_rank", false);
    Object localObject;
    if ((bt.isNullOrNil(this.pfS)) || ("#".equals(this.pfS))) {
      if (!this.pga)
      {
        paramBundle = com.tencent.mm.plugin.exdevice.model.ad.bZH();
        localObject = String.format("select * from %s order by %s desc limit 1", new Object[] { "HardDeviceRankInfo", "rankID" });
        localObject = paramBundle.db.a((String)localObject, null, 2);
        if (localObject != null) {
          break label749;
        }
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.ExdeviceRankInfoStg", "Get no rank in DB");
        paramBundle = null;
      }
    }
    for (;;)
    {
      if (paramBundle != null)
      {
        this.pfS = paramBundle.field_rankID;
        this.pfR = paramBundle.field_appusername;
      }
      this.pfU = null;
      this.pfZ = true;
      com.tencent.mm.plugin.exdevice.model.ad.bZO();
      this.pfY = com.tencent.mm.plugin.exdevice.g.b.c.UJ(this.pfS);
      if (!this.pga)
      {
        if ((this.pfY == null) || (this.pfY.size() <= 0))
        {
          this.pfX = new ArrayList();
          this.pfY = com.tencent.mm.plugin.exdevice.g.a.a.a(this.pfS, this.pfR, this.pfP, this.pfQ, this.pfi, this.pfX);
          com.tencent.mm.plugin.exdevice.model.ad.bZO();
          com.tencent.mm.plugin.exdevice.g.b.c.e(this.pfS, this.pfY);
          label341:
          this.pfX = com.tencent.mm.plugin.exdevice.model.ad.bZI().bZU();
        }
      }
      else
      {
        this.pfK = new b(this, this.pfR);
        this.pfK.pfi = this.pfi;
        this.pfW = this.pfK.b(this.pfX, this.pfY, this.oYw);
        this.pfK.pfh = this.pfW;
        if (bt.isNullOrNil(this.pfU)) {
          caI();
        }
        this.pfT = com.tencent.mm.plugin.exdevice.model.ad.bZK().UN(this.pfU);
        if ((this.pfT == null) && (!bt.isNullOrNil(this.pfU)))
        {
          this.pfT = new com.tencent.mm.plugin.exdevice.g.b.a.a();
          this.pfT.field_username = this.pfU;
          this.pfT.field_championMotto = getIntent().getStringExtra("key_champion_info");
          this.pfT.field_championUrl = getIntent().getStringExtra("key_champion_coverimg");
          com.tencent.mm.plugin.exdevice.model.ad.bZO();
          paramBundle = this.pfT;
          com.tencent.mm.plugin.exdevice.model.ad.bZK().a(paramBundle);
        }
        initView();
        if ((this.pfY != null) && (this.pfY.size() > 0))
        {
          paramBundle = ((com.tencent.mm.plugin.exdevice.g.b.a.d)this.pfY.get(0)).field_username;
          this.pfN.Vb(paramBundle);
        }
        com.tencent.mm.plugin.exdevice.model.ad.bZP().a(this);
        com.tencent.mm.plugin.exdevice.model.ad.bZO().oYG = this;
        caG();
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
        setMMTitle(2131758622);
        showOptionMenu(true);
        caH();
        paramBundle = new ui();
        paramBundle.dzG.action = 2;
        com.tencent.mm.sdk.b.a.ESL.a(paramBundle, new ExdeviceRankInfoUI.19(this));
        if (!com.tencent.mm.compatible.util.d.lh(28)) {}
      }
      try
      {
        if (android.support.v4.content.b.checkSelfPermission(this, "android.permission.ACTIVITY_RECOGNITION") != 0)
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Sport.ExdeviceRankInfoUI", "no ACTIVITY_RECOGNITION permission");
          android.support.v4.app.a.a(this, new String[] { "android.permission.ACTIVITY_RECOGNITION" }, 5);
        }
        for (;;)
        {
          label692:
          if (g.afB().afk().getInt(ae.a.FxH, 0) == 1)
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Sport.ExdeviceRankInfoUI", "toast get step fail");
            Toast.makeText(this, 2131758595, 0).show();
            com.tencent.mm.plugin.report.e.vIY.idkeyStat(323L, 6L, 1L, false);
          }
          AppMethodBeat.o(24237);
          return;
          label749:
          if (!((Cursor)localObject).moveToFirst())
          {
            com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ExdeviceRankInfoStg", "hy: no record");
            paramBundle = null;
          }
          for (;;)
          {
            ((Cursor)localObject).close();
            break;
            paramBundle = new com.tencent.mm.plugin.exdevice.g.b.a.d();
            paramBundle.convertFrom((Cursor)localObject);
          }
          com.tencent.mm.plugin.exdevice.g.a.a.b(this.pfP, this.pfQ, this.pfi);
          break label341;
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Sport.ExdeviceRankInfoUI", "has ACTIVITY_RECOGNITION permission");
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
    if (this.pfK != null) {
      b.finish();
    }
    super.onDestroy();
    if (this.pgd != null) {
      this.pgd.oYz = null;
    }
    com.tencent.mm.plugin.exdevice.model.ad.bZP().b(this);
    com.tencent.mm.plugin.exdevice.model.ad.bZO().oYG = null;
    com.tencent.mm.plugin.exdevice.model.ad.bZO().oYH = null;
    if (this.likeCount > 0)
    {
      int i = this.likeCount;
      com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.Sport.SportReportLogic", "reportLikeCount count=%d", new Object[] { Integer.valueOf(i) });
      com.tencent.mm.plugin.report.e.vIY.f(13168, new Object[] { Integer.valueOf(0), Integer.valueOf(i) });
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
    ka(true);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI
 * JD-Core Version:    0.7.0.1
 */