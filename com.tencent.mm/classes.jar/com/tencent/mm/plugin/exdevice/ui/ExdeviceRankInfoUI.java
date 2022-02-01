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
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.sk;
import com.tencent.mm.g.a.us;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.n;
import com.tencent.mm.plugin.exdevice.g.a.j.a;
import com.tencent.mm.plugin.exdevice.g.b.f;
import com.tencent.mm.plugin.exdevice.model.ac.a;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.a;
import com.tencent.mm.ui.base.MMPullDownView.b;
import com.tencent.mm.ui.base.MMPullDownView.c;
import com.tencent.mm.ui.base.MMPullDownView.d;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import junit.framework.Assert;

public class ExdeviceRankInfoUI
  extends MMActivity
  implements j.a, com.tencent.mm.plugin.exdevice.g.b.e, f, d
{
  private static int pIa = 128;
  private String kOD;
  private String lhM;
  private int likeCount;
  private boolean mIsDestroyed;
  public boolean pBH;
  public String pBI;
  private boolean pBv;
  private p pFw;
  private ImageView pHG;
  private View pHM;
  private String pHO;
  private String pHP;
  private ListView pIU;
  private b pIV;
  private View pIW;
  private ExdeviceRankListHeaderView pIX;
  private ExdeviceRankChampionInfoView pIY;
  private View pIZ;
  private Map<String, String> pIt;
  private String pJa;
  private String pJb;
  private String pJc;
  private String pJd;
  private com.tencent.mm.plugin.exdevice.g.b.a.a pJe;
  private String pJf;
  private int pJg;
  private List<e> pJh;
  private ArrayList<com.tencent.mm.plugin.exdevice.g.b.a.c> pJi;
  private ArrayList<com.tencent.mm.plugin.exdevice.g.b.a.d> pJj;
  private boolean pJk;
  private boolean pJl;
  private String pJm;
  private boolean pJn;
  private com.tencent.mm.plugin.exdevice.g.a.j pJo;
  private com.tencent.mm.plugin.exdevice.b.b<com.tencent.mm.plugin.exdevice.g.a.j> pJp;
  
  public ExdeviceRankInfoUI()
  {
    AppMethodBeat.i(24235);
    this.pFw = null;
    this.pIt = new HashMap();
    this.pJp = new com.tencent.mm.plugin.exdevice.b.b() {};
    AppMethodBeat.o(24235);
  }
  
  private int Zp(String paramString)
  {
    AppMethodBeat.i(24240);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Sport.ExdeviceRankInfoUI", "locateToUser, locate2User(%s), username(%s).", new Object[] { paramString, this.lhM });
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(24240);
      return -1;
    }
    if ((this.pJh == null) || (this.pJh.size() == 0))
    {
      AppMethodBeat.o(24240);
      return -2;
    }
    int i = 0;
    while (i < this.pJh.size())
    {
      Object localObject = ((e)this.pJh.get(i)).pLl;
      int j = ((e)this.pJh.get(i)).pLm;
      if ((localObject != null) && (paramString.equalsIgnoreCase(((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject).field_username)) && (!paramString.equalsIgnoreCase(this.lhM)) && ((j & 0x2) != 2))
      {
        localObject = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
        j = ((DisplayMetrics)localObject).heightPixels;
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Sport.ExdeviceRankInfoUI", "locateToUser pos(%d).(h : %d)", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        this.pIU.setSelectionFromTop(i, j / 4);
        this.pIV.pIu = paramString;
        this.pIV.notifyDataSetInvalidated();
        chT();
        AppMethodBeat.o(24240);
        return i;
      }
      i += 1;
    }
    this.pIV.pIu = null;
    AppMethodBeat.o(24240);
    return -3;
  }
  
  private void chJ()
  {
    AppMethodBeat.i(24241);
    if ((this.pJe != null) && (this.lhM != null) && (this.lhM.equals(this.pJe.field_username)) && (bs.isNullOrNil(this.pJe.field_championUrl)))
    {
      if (this.pHM != null) {
        this.pHM.setVisibility(0);
      }
      if (this.pIX != null)
      {
        this.pIX.setOnViewClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(24232);
            com.tencent.mm.plugin.exdevice.g.a.e.d(ExdeviceRankInfoUI.this);
            AppMethodBeat.o(24232);
          }
        });
        AppMethodBeat.o(24241);
      }
    }
    else
    {
      if (this.pHM != null) {
        this.pHM.setVisibility(8);
      }
      if ((this.pJe != null) && (!bs.bG(this.pJe.field_username, "").equals(this.lhM)) && (!bs.isNullOrNil(this.pJe.field_championUrl))) {
        this.pIX.setOnViewClickListener(new View.OnClickListener()
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
  
  private void chP()
  {
    AppMethodBeat.i(24238);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Sport.ExdeviceRankInfoUI", "updateRankInfoUIFromServer");
    this.pJo = new com.tencent.mm.plugin.exdevice.g.a.j(this.pJd, this.pJc, this.pJf, this.pJk, this.pJp);
    this.pJo.pBK = this;
    az.agi().a(this.pJo, 0);
    AppMethodBeat.o(24238);
  }
  
  private void chQ()
  {
    AppMethodBeat.i(24239);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Sport.ExdeviceRankInfoUI", "try2LocateToUser, locate2User(%s), username(%s).", new Object[] { this.pJm, this.lhM });
    if ((bs.isNullOrNil(this.pJm)) || (Zp(this.pJm) < 0))
    {
      com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.Sport.ExdeviceRankInfoUI", "locate to username is null or nil.");
      AppMethodBeat.o(24239);
      return;
    }
    AppMethodBeat.o(24239);
  }
  
  private void chR()
  {
    AppMethodBeat.i(24242);
    String str = chS();
    if (!bs.isNullOrNil(str)) {
      this.pJf = str;
    }
    AppMethodBeat.o(24242);
  }
  
  private String chS()
  {
    AppMethodBeat.i(24243);
    if (this.pJh != null)
    {
      Object localObject = this.pJh.iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.plugin.exdevice.g.b.a.d locald = ((e)((Iterator)localObject).next()).pLl;
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
  
  private void chT()
  {
    AppMethodBeat.i(24245);
    View localView = this.pIU.getChildAt(0);
    int[] arrayOfInt = new int[2];
    if (localView != null)
    {
      if (this.pIU.getFirstVisiblePosition() == 0)
      {
        localView.getLocationOnScreen(arrayOfInt);
        if ((bs.isNullOrNil(this.pJm)) && (pIa == 128)) {
          pIa = arrayOfInt[1];
        }
        int i = arrayOfInt[1];
        if (i > 0)
        {
          if (i >= pIa) {}
          for (float f = 1.0F;; f = i / pIa)
          {
            com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.Sport.ExdeviceRankInfoUI", "ap-alpha: %s", new Object[] { Float.valueOf(f) });
            this.pIY.setAlpha(f);
            this.pIY.setVisibility(0);
            this.pHM.setAlpha(f);
            AppMethodBeat.o(24245);
            return;
          }
        }
      }
      this.pIY.setAlpha(0.0F);
      this.pHM.setAlpha(0.0F);
      this.pIY.setVisibility(8);
    }
    AppMethodBeat.o(24245);
  }
  
  private void chU()
  {
    AppMethodBeat.i(24250);
    if (this.pJe != null)
    {
      if ((this.kOD != this.pJe.field_championUrl) && ((this.kOD == null) || (!this.kOD.equals(this.pJe.field_championUrl))))
      {
        com.tencent.mm.plugin.exdevice.g.a.e.a(this, this.pHG, this.pJe.field_championUrl);
        this.kOD = this.pJe.field_championUrl;
        AppMethodBeat.o(24250);
      }
    }
    else
    {
      this.pHG.setImageResource(2131100204);
      this.kOD = null;
    }
    AppMethodBeat.o(24250);
  }
  
  private void chW()
  {
    AppMethodBeat.i(24259);
    if (bs.isNullOrNil(this.pBI))
    {
      localObject = ad.cgT().YZ(this.lhM);
      if (localObject != null) {
        this.pBI = ((com.tencent.mm.plugin.exdevice.g.b.a.a)localObject).field_championUrl;
      }
    }
    com.tencent.mm.plugin.exdevice.g.b.a.d locald = b.g(this.lhM, this.pJj);
    Object localObject = "--";
    String str = "0";
    if (locald != null)
    {
      localObject = String.valueOf(locald.field_ranknum);
      str = String.valueOf(locald.field_score);
    }
    new com.tencent.mm.plugin.exdevice.model.ac().a(this, (String)localObject, str, this.pBI, new ac.a()
    {
      public final void YR(String paramAnonymousString)
      {
        AppMethodBeat.i(24223);
        Intent localIntent = new Intent();
        localIntent.putExtra("Ksnsupload_appid", "wx7fa037cc7dfabad5");
        localIntent.putExtra("Ksnsupload_appname", ExdeviceRankInfoUI.this.getString(2131758621));
        localIntent.putExtra("Ksnsupload_source", 1);
        localIntent.putExtra("need_result", true);
        String str = y.xJ("wx_sport");
        y.ayq().F(str, true).l("prePublishId", "wx_sport");
        localIntent.putExtra("reportSessionId", str);
        localIntent.putExtra("Ksnsupload_type", 0);
        localIntent.putExtra("sns_kemdia_path", paramAnonymousString);
        com.tencent.mm.br.d.b(ExdeviceRankInfoUI.this, "sns", ".ui.SnsUploadUI", localIntent, 2);
        AppMethodBeat.o(24223);
      }
    });
    AppMethodBeat.o(24259);
  }
  
  private void kE(boolean paramBoolean)
  {
    AppMethodBeat.i(24236);
    if ((this.pJl) && (!paramBoolean))
    {
      AppMethodBeat.o(24236);
      return;
    }
    ad.cgX();
    this.pJj = com.tencent.mm.plugin.exdevice.g.b.c.YV(this.pJd);
    this.pJi = ad.cgR().chd();
    this.pJh = this.pIV.b(this.pJi, this.pJj, this.pBH);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(24206);
        ExdeviceRankInfoUI.b(ExdeviceRankInfoUI.this).pIs = ExdeviceRankInfoUI.a(ExdeviceRankInfoUI.this);
        ExdeviceRankInfoUI.b(ExdeviceRankInfoUI.this).notifyDataSetChanged();
        ExdeviceRankInfoUI.c(ExdeviceRankInfoUI.this);
        AppMethodBeat.o(24206);
      }
    });
    AppMethodBeat.o(24236);
  }
  
  private void kF(boolean paramBoolean)
  {
    AppMethodBeat.i(24251);
    if (paramBoolean) {
      chR();
    }
    if (!bs.isNullOrNil(this.pJc))
    {
      this.pIY.Zn(this.pJf);
      this.pIY.setVisibility(0);
      AppMethodBeat.o(24251);
      return;
    }
    this.pIY.setVisibility(8);
    AppMethodBeat.o(24251);
  }
  
  public final void YW(String paramString)
  {
    AppMethodBeat.i(24253);
    com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.Sport.ExdeviceRankInfoUI", "hy: rank changed to %s", new Object[] { paramString });
    this.pJd = paramString;
    AppMethodBeat.o(24253);
  }
  
  public final void Zq(String paramString)
  {
    AppMethodBeat.i(24254);
    com.tencent.mm.plugin.sport.a.c.lA(6);
    Intent localIntent = new Intent(this, ExdeviceProfileUI.class);
    localIntent.putExtra("username", paramString);
    localIntent.putExtra("usernickname", (String)this.pIt.get(paramString));
    localIntent.putExtra("app_username", this.pJc);
    localIntent.putExtra("rank_id", this.pJd);
    startActivityForResult(localIntent, 4);
    AppMethodBeat.o(24254);
  }
  
  public final boolean Zr(String paramString)
  {
    AppMethodBeat.i(24258);
    if ((!bs.isNullOrNil(this.pJd)) && (!"#".equals(this.pJd)))
    {
      if (u.axw().equals(paramString))
      {
        com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.Sport.ExdeviceRankInfoUI", "hy: is self. see who likes me");
        paramString = new Intent(this, ExdeviceLikeUI.class);
        paramString.putExtra("app_username", this.pJc);
        paramString.putExtra("rank_id", this.pJd);
        paramString.putExtra("key_is_like_read_only", true);
        paramString = new com.tencent.mm.hellhoundlib.b.a().ba(paramString);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramString.aeD(), "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankInfoUI", "beforeLikeBtnClicked", "(Ljava/lang/String;I)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramString.lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankInfoUI", "beforeLikeBtnClicked", "(Ljava/lang/String;I)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(24258);
        return true;
      }
      AppMethodBeat.o(24258);
      return false;
    }
    com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.Sport.ExdeviceRankInfoUI", "hy: rank id is not valid.abort the event");
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
          com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.Sport.ExdeviceRankInfoUI", "dismiss tips dialog.");
        }
        AppMethodBeat.o(24225);
      }
    });
    this.pHO = paramj.pBl;
    this.pHP = paramj.pBm;
    this.pBI = paramj.pBI;
    this.pBH = paramj.pBH;
    this.pBv = paramj.pBv;
    this.pJj = paramj.pBA;
    this.pJi = paramj.pBB;
    this.pJh = this.pIV.b(this.pJi, this.pJj, this.pBH);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(179640);
        ExdeviceRankInfoUI.b(ExdeviceRankInfoUI.this).pIs = ExdeviceRankInfoUI.a(ExdeviceRankInfoUI.this);
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
    if ((paramd != null) && (!bs.isNullOrNil(paramString))) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if (!"HardDeviceRankInfo".equals(paramString)) {
        break;
      }
      if ((this.pJd == null) || (!this.pJd.equals(paramd.pBx))) {
        break label216;
      }
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Sport.ExdeviceRankInfoUI", "onRankChange, rankId(%s).", new Object[] { this.pJd });
      kE(true);
      if ((bs.isNullOrNil(this.pJf)) || (!this.pJf.equals(chS())))
      {
        chR();
        this.pJe = ad.cgT().YZ(this.pJf);
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
    if (("HardDeviceChampionInfo".equals(paramString)) && (!bs.isNullOrNil(this.pJf)) && (this.pJf.equals(paramd.username)))
    {
      this.pJe = ad.cgT().YZ(this.pJf);
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
  
  public final void cV(String paramString, int paramInt)
  {
    AppMethodBeat.i(24256);
    ad.cgX();
    String str1 = this.pJd;
    String str2 = this.pJc;
    com.tencent.mm.plugin.exdevice.g.b.b.d locald = ad.cgQ();
    boolean bool;
    com.tencent.mm.plugin.exdevice.g.b.a.d locald1;
    if ((!bs.isNullOrNil(str1)) && (!bs.isNullOrNil(paramString)) && ((paramInt == 1) || (paramInt == 0) || (paramInt == 2)))
    {
      bool = true;
      Assert.assertTrue(bool);
      locald1 = locald.a(new com.tencent.mm.plugin.exdevice.g.b.d(str1, null, paramString));
      if (locald1 != null) {
        break label125;
      }
      com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.ExdeviceRankInfoStg", "hy: info is null. abort");
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
        com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.ExdeviceRankInfoStg", "hy: still loading...abort");
      }
    }
    for (locald1.field_likecount += 1;; locald1.field_likecount -= 1)
    {
      locald.a(locald1, true);
      break;
    }
  }
  
  public final void chV()
  {
    AppMethodBeat.i(24255);
    com.tencent.mm.plugin.sport.a.c.lA(31);
    chW();
    AppMethodBeat.o(24255);
  }
  
  public int getLayoutId()
  {
    return 2131493887;
  }
  
  public void initView()
  {
    AppMethodBeat.i(24244);
    this.pIW = findViewById(2131302912);
    Object localObject1 = new ExdeviceRankListHeaderView(this);
    Object localObject2 = new Rect();
    getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject2);
    int j = ((Rect)localObject2).top;
    int i = j;
    if (j == 0) {
      i = com.tencent.mm.plugin.exdevice.k.b.Q(this, getResources().getDimensionPixelSize(2131165316));
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
      this.pIX = ((ExdeviceRankListHeaderView)localObject1);
      localObject1 = (MMPullDownView)findViewById(2131303544);
      this.pIU = ((ListView)findViewById(2131299583));
      this.pIY = ((ExdeviceRankChampionInfoView)findViewById(2131297945));
      this.pHM = findViewById(2131304599);
      this.pHM.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(179647);
          com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.Sport.ExdeviceRankInfoUI", "ap: start change cover");
          com.tencent.mm.plugin.exdevice.g.a.e.d(ExdeviceRankInfoUI.this);
          AppMethodBeat.o(179647);
        }
      });
      this.pIX.setIsShowTip(false);
      chJ();
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
      ((MMPullDownView)localObject1).setAtBottomCallBack(new MMPullDownView.c()
      {
        public final boolean bWz()
        {
          AppMethodBeat.i(179631);
          View localView = ExdeviceRankInfoUI.q(ExdeviceRankInfoUI.this).getChildAt(ExdeviceRankInfoUI.q(ExdeviceRankInfoUI.this).getChildCount() - 1);
          int i = ExdeviceRankInfoUI.q(ExdeviceRankInfoUI.this).getCount();
          if ((i > 0) && (localView != null) && (localView.getBottom() <= ExdeviceRankInfoUI.q(ExdeviceRankInfoUI.this).getHeight()) && (ExdeviceRankInfoUI.q(ExdeviceRankInfoUI.this).getLastVisiblePosition() == i - 1))
          {
            AppMethodBeat.o(179631);
            return true;
          }
          AppMethodBeat.o(179631);
          return false;
        }
      });
      ((MMPullDownView)localObject1).setOnScrollChangedListener(new MMPullDownView.b()
      {
        public final void chO()
        {
          AppMethodBeat.i(179632);
          ExdeviceRankInfoUI.r(ExdeviceRankInfoUI.this);
          AppMethodBeat.o(179632);
        }
      });
      ((MMPullDownView)localObject1).setAtTopCallBack(new MMPullDownView.d()
      {
        public final boolean bWy()
        {
          AppMethodBeat.i(179633);
          int i = ExdeviceRankInfoUI.q(ExdeviceRankInfoUI.this).getFirstVisiblePosition();
          if (i == 0)
          {
            View localView = ExdeviceRankInfoUI.q(ExdeviceRankInfoUI.this).getChildAt(i);
            if ((localView != null) && (localView.getTop() >= 0))
            {
              AppMethodBeat.o(179633);
              return true;
            }
          }
          AppMethodBeat.o(179633);
          return false;
        }
      });
      this.pIU.setOnScrollListener(new AbsListView.OnScrollListener()
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
      this.pIU.addHeaderView(this.pIX, null, false);
      localObject2 = getLayoutInflater().inflate(2131493885, null);
      this.pIZ = ((View)localObject2).findViewById(2131301056);
      ((View)localObject2).findViewById(2131301055).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(179636);
          com.tencent.mm.plugin.sport.a.c.lA(24);
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("Select_Talker_Name", "gh_43f2581f6fd6");
          paramAnonymousView.putExtra("Select_block_List", "gh_43f2581f6fd6");
          paramAnonymousView.putExtra("Select_Conv_Type", 3);
          paramAnonymousView.putExtra("mutil_select_is_ret", true);
          paramAnonymousView.putExtra("Select_Send_Card", true);
          com.tencent.mm.br.d.c(ExdeviceRankInfoUI.this, ".ui.transmit.SelectConversationUI", paramAnonymousView, 3);
          AppMethodBeat.o(179636);
        }
      });
      this.pIZ.setVisibility(8);
      this.pIU.addFooterView((View)localObject2);
      if (this.pJi == null) {
        break label759;
      }
    }
    label759:
    for (i = this.pJi.size();; i = 0)
    {
      if (this.pJj != null) {}
      for (j = this.pJj.size();; j = 0)
      {
        if (i + j == 0)
        {
          this.pJh = new ArrayList();
          this.pIV.pIs = this.pJh;
          getString(2131755906);
          this.pFw = com.tencent.mm.ui.base.h.b(this, getString(2131760709), true, new DialogInterface.OnCancelListener()
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
        this.pIU.setAdapter(this.pIV);
        this.pIV.pIv = this;
        if (this.pJg == 1)
        {
          this.pIU.setVisibility(0);
          this.pIW.setVisibility(8);
        }
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label638;
          }
          com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.Sport.ExdeviceRankInfoUI", "hy: cannot handle this device type");
          finish();
          AppMethodBeat.o(24244);
          return;
          j = getResources().getDimensionPixelSize(2131165252);
          break;
          this.pIU.setVisibility(8);
          this.pIW.setVisibility(0);
        }
        label638:
        this.pHG = ((ImageView)findViewById(2131299545));
        ((MMPullDownView)localObject1).setCanOverScrool(false);
        int k = com.tencent.mm.cc.a.ig(this);
        j = ((Integer)this.pIX.getTag()).intValue();
        i = j;
        if (this.pBH)
        {
          i = getResources().getDimensionPixelSize(2131165326);
          int m = getResources().getDimensionPixelSize(2131165325);
          i = j + (i / 2 + m);
        }
        localObject1 = new RelativeLayout.LayoutParams(k, i);
        this.pHG.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        chU();
        kF(false);
        AppMethodBeat.o(24244);
        return;
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(24257);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (com.tencent.mm.plugin.exdevice.g.a.e.a(this, paramInt1, paramInt2, paramIntent, this.pJc))
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
        com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.Sport.ExdeviceRankInfoUI", "onActivityResult, data is null.(reqestCode : %d)", new Object[] { Integer.valueOf(paramInt1) });
        AppMethodBeat.o(24257);
        return;
      }
      if (paramIntent == null) {}
      for (Object localObject = null; (localObject == null) || (((String)localObject).length() == 0); localObject = paramIntent.getStringExtra("Select_Conv_User"))
      {
        com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.Sport.ExdeviceRankInfoUI", "select conversation failed, toUser is null.");
        AppMethodBeat.o(24257);
        return;
      }
      paramIntent = paramIntent.getStringExtra("custom_send_text");
      com.tencent.mm.plugin.exdevice.model.ac.a(this, (String)localObject, com.tencent.mm.plugin.exdevice.model.ac.eD(this), paramIntent, this.pHP);
      com.tencent.mm.ui.base.h.cg(getContext(), getResources().getString(2131755894));
      com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.Sport.ExdeviceRankInfoUI", "Select conversation return.");
      AppMethodBeat.o(24257);
      return;
      com.tencent.mm.ui.base.h.cg(getContext(), getResources().getString(2131755894));
      com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.Sport.ExdeviceRankInfoUI", "Share to timeline return.");
      AppMethodBeat.o(24257);
      return;
      if (paramIntent != null)
      {
        localObject = bs.S(paramIntent.getStringExtra("received_card_name").split(","));
        paramIntent = paramIntent.getStringExtra("custom_send_text");
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          com.tencent.mm.plugin.messenger.a.j.dck().q("gh_43f2581f6fd6", str, w.sQ(str));
          if (!bs.isNullOrNil(paramIntent))
          {
            sk localsk = new sk();
            localsk.dvv.dvw = str;
            localsk.dvv.content = paramIntent;
            localsk.dvv.type = w.xt(str);
            localsk.dvv.flags = 0;
            com.tencent.mm.sdk.b.a.GpY.l(localsk);
          }
        }
        AppMethodBeat.o(24257);
        return;
        if ((paramIntent != null) && (paramIntent.getBooleanExtra("KeyNeedUpdateRank", false))) {
          chP();
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(24237);
    super.onCreate(paramBundle);
    this.mIsDestroyed = false;
    this.lhM = u.axw();
    paramBundle = getIntent();
    this.pJa = paramBundle.getStringExtra("key_rank_info");
    this.pJb = paramBundle.getStringExtra("key_rank_semi");
    this.pJc = paramBundle.getStringExtra("app_username");
    this.pJd = paramBundle.getStringExtra("rank_id");
    this.pJk = paramBundle.getBooleanExtra("key_is_latest", false);
    this.pJf = paramBundle.getStringExtra("key_champioin_username");
    this.pJg = paramBundle.getIntExtra("device_type", 0);
    this.pJm = paramBundle.getStringExtra("locate_to_username");
    this.pJl = paramBundle.getBooleanExtra("key_only_show_latest_rank", false);
    Object localObject;
    if ((bs.isNullOrNil(this.pJd)) || ("#".equals(this.pJd))) {
      if (!this.pJl)
      {
        paramBundle = ad.cgQ();
        localObject = String.format("select * from %s order by %s desc limit 1", new Object[] { "HardDeviceRankInfo", "rankID" });
        localObject = paramBundle.db.a((String)localObject, null, 2);
        if (localObject != null) {
          break label749;
        }
        com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.ExdeviceRankInfoStg", "Get no rank in DB");
        paramBundle = null;
      }
    }
    for (;;)
    {
      if (paramBundle != null)
      {
        this.pJd = paramBundle.field_rankID;
        this.pJc = paramBundle.field_appusername;
      }
      this.pJf = null;
      this.pJk = true;
      ad.cgX();
      this.pJj = com.tencent.mm.plugin.exdevice.g.b.c.YV(this.pJd);
      if (!this.pJl)
      {
        if ((this.pJj == null) || (this.pJj.size() <= 0))
        {
          this.pJi = new ArrayList();
          this.pJj = com.tencent.mm.plugin.exdevice.g.a.a.a(this.pJd, this.pJc, this.pJa, this.pJb, this.pIt, this.pJi);
          ad.cgX();
          com.tencent.mm.plugin.exdevice.g.b.c.e(this.pJd, this.pJj);
          label341:
          this.pJi = ad.cgR().chd();
        }
      }
      else
      {
        this.pIV = new b(this, this.pJc);
        this.pIV.pIt = this.pIt;
        this.pJh = this.pIV.b(this.pJi, this.pJj, this.pBH);
        this.pIV.pIs = this.pJh;
        if (bs.isNullOrNil(this.pJf)) {
          chR();
        }
        this.pJe = ad.cgT().YZ(this.pJf);
        if ((this.pJe == null) && (!bs.isNullOrNil(this.pJf)))
        {
          this.pJe = new com.tencent.mm.plugin.exdevice.g.b.a.a();
          this.pJe.field_username = this.pJf;
          this.pJe.field_championMotto = getIntent().getStringExtra("key_champion_info");
          this.pJe.field_championUrl = getIntent().getStringExtra("key_champion_coverimg");
          ad.cgX();
          paramBundle = this.pJe;
          ad.cgT().a(paramBundle);
        }
        initView();
        if ((this.pJj != null) && (this.pJj.size() > 0))
        {
          paramBundle = ((com.tencent.mm.plugin.exdevice.g.b.a.d)this.pJj.get(0)).field_username;
          this.pIY.Zn(paramBundle);
        }
        ad.cgY().a(this);
        ad.cgX().pBR = this;
        chP();
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
        chQ();
        paramBundle = new us();
        paramBundle.dxs.action = 2;
        com.tencent.mm.sdk.b.a.GpY.a(paramBundle, new Executor()
        {
          public final void execute(Runnable paramAnonymousRunnable)
          {
            AppMethodBeat.i(179643);
            com.tencent.e.h.JZN.aS(paramAnonymousRunnable);
            AppMethodBeat.o(179643);
          }
        });
        if (!com.tencent.mm.compatible.util.d.lb(28)) {}
      }
      try
      {
        if (android.support.v4.content.b.checkSelfPermission(this, "android.permission.ACTIVITY_RECOGNITION") != 0)
        {
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Sport.ExdeviceRankInfoUI", "no ACTIVITY_RECOGNITION permission");
          android.support.v4.app.a.a(this, new String[] { "android.permission.ACTIVITY_RECOGNITION" }, 5);
        }
        for (;;)
        {
          label692:
          if (com.tencent.mm.kernel.g.agR().agA().getInt(ah.a.GWC, 0) == 1)
          {
            com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Sport.ExdeviceRankInfoUI", "toast get step fail");
            Toast.makeText(this, 2131758595, 0).show();
            com.tencent.mm.plugin.report.e.wTc.idkeyStat(323L, 6L, 1L, false);
          }
          AppMethodBeat.o(24237);
          return;
          label749:
          if (!((Cursor)localObject).moveToFirst())
          {
            com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.ExdeviceRankInfoStg", "hy: no record");
            paramBundle = null;
          }
          for (;;)
          {
            ((Cursor)localObject).close();
            break;
            paramBundle = new com.tencent.mm.plugin.exdevice.g.b.a.d();
            paramBundle.convertFrom((Cursor)localObject);
          }
          com.tencent.mm.plugin.exdevice.g.a.a.d(this.pJa, this.pJb, this.pIt);
          break label341;
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Sport.ExdeviceRankInfoUI", "has ACTIVITY_RECOGNITION permission");
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
    if (this.pIV != null) {
      b.finish();
    }
    super.onDestroy();
    if (this.pJo != null) {
      this.pJo.pBK = null;
    }
    ad.cgY().b(this);
    ad.cgX().pBR = null;
    ad.cgX().pBS = null;
    if (this.likeCount > 0)
    {
      int i = this.likeCount;
      com.tencent.mm.sdk.platformtools.ac.v("MicroMsg.Sport.SportReportLogic", "reportLikeCount count=%d", new Object[] { Integer.valueOf(i) });
      com.tencent.mm.plugin.report.e.wTc.f(13168, new Object[] { Integer.valueOf(0), Integer.valueOf(i) });
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
    kE(true);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI
 * JD-Core Version:    0.7.0.1
 */