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
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.sx;
import com.tencent.mm.g.a.vl;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.o;
import com.tencent.mm.plugin.exdevice.g.a.j;
import com.tencent.mm.plugin.exdevice.g.a.j.a;
import com.tencent.mm.plugin.exdevice.g.b.f;
import com.tencent.mm.plugin.exdevice.model.ac;
import com.tencent.mm.plugin.exdevice.model.ac.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.a;
import com.tencent.mm.ui.base.MMPullDownView.b;
import com.tencent.mm.ui.base.MMPullDownView.c;
import com.tencent.mm.ui.base.MMPullDownView.d;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
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
  private static int qlF = 128;
  private String lEN;
  private int likeCount;
  private String llg;
  private boolean mIsDestroyed;
  private boolean qfa;
  public boolean qfm;
  public String qfn;
  private p qjb;
  private Map<String, String> qlY;
  private ImageView qll;
  private View qlr;
  private String qlt;
  private String qlu;
  private b qmA;
  private View qmB;
  private ExdeviceRankListHeaderView qmC;
  private ExdeviceRankChampionInfoView qmD;
  private View qmE;
  private String qmF;
  private String qmG;
  private String qmH;
  private String qmI;
  private com.tencent.mm.plugin.exdevice.g.b.a.a qmJ;
  private String qmK;
  private int qmL;
  private List<e> qmM;
  private ArrayList<com.tencent.mm.plugin.exdevice.g.b.a.c> qmN;
  private ArrayList<com.tencent.mm.plugin.exdevice.g.b.a.d> qmO;
  private boolean qmP;
  private boolean qmQ;
  private String qmR;
  private boolean qmS;
  private j qmT;
  private com.tencent.mm.plugin.exdevice.b.b<j> qmU;
  private ListView qmz;
  
  public ExdeviceRankInfoUI()
  {
    AppMethodBeat.i(24235);
    this.qjb = null;
    this.qlY = new HashMap();
    this.qmU = new com.tencent.mm.plugin.exdevice.b.b() {};
    AppMethodBeat.o(24235);
  }
  
  private int acV(String paramString)
  {
    AppMethodBeat.i(24240);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Sport.ExdeviceRankInfoUI", "locateToUser, locate2User(%s), username(%s).", new Object[] { paramString, this.lEN });
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(24240);
      return -1;
    }
    if ((this.qmM == null) || (this.qmM.size() == 0))
    {
      AppMethodBeat.o(24240);
      return -2;
    }
    int i = 0;
    while (i < this.qmM.size())
    {
      Object localObject = ((e)this.qmM.get(i)).qoQ;
      int j = ((e)this.qmM.get(i)).qoR;
      if ((localObject != null) && (paramString.equalsIgnoreCase(((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject).field_username)) && (!paramString.equalsIgnoreCase(this.lEN)) && ((j & 0x2) != 2))
      {
        localObject = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
        j = ((DisplayMetrics)localObject).heightPixels;
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Sport.ExdeviceRankInfoUI", "locateToUser pos(%d).(h : %d)", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        this.qmz.setSelectionFromTop(i, j / 4);
        this.qmA.qlZ = paramString;
        this.qmA.notifyDataSetInvalidated();
        cmx();
        AppMethodBeat.o(24240);
        return i;
      }
      i += 1;
    }
    this.qmA.qlZ = null;
    AppMethodBeat.o(24240);
    return -3;
  }
  
  private void cmA()
  {
    AppMethodBeat.i(24259);
    if (bt.isNullOrNil(this.qfn))
    {
      localObject = com.tencent.mm.plugin.exdevice.model.ad.clx().acF(this.lEN);
      if (localObject != null) {
        this.qfn = ((com.tencent.mm.plugin.exdevice.g.b.a.a)localObject).field_championUrl;
      }
    }
    com.tencent.mm.plugin.exdevice.g.b.a.d locald = b.g(this.lEN, this.qmO);
    Object localObject = "--";
    String str = "0";
    if (locald != null)
    {
      localObject = String.valueOf(locald.field_ranknum);
      str = String.valueOf(locald.field_score);
    }
    new ac().a(this, (String)localObject, str, this.qfn, new ac.a()
    {
      public final void acx(String paramAnonymousString)
      {
        AppMethodBeat.i(24223);
        Intent localIntent = new Intent();
        localIntent.putExtra("Ksnsupload_appid", "wx7fa037cc7dfabad5");
        localIntent.putExtra("Ksnsupload_appname", ExdeviceRankInfoUI.this.getString(2131758621));
        localIntent.putExtra("Ksnsupload_source", 1);
        localIntent.putExtra("need_result", true);
        String str = y.AH("wx_sport");
        y.aBq().F(str, true).k("prePublishId", "wx_sport");
        localIntent.putExtra("reportSessionId", str);
        localIntent.putExtra("Ksnsupload_type", 0);
        localIntent.putExtra("sns_kemdia_path", paramAnonymousString);
        com.tencent.mm.bs.d.b(ExdeviceRankInfoUI.this, "sns", ".ui.SnsUploadUI", localIntent, 2);
        AppMethodBeat.o(24223);
      }
    });
    AppMethodBeat.o(24259);
  }
  
  private void cmn()
  {
    AppMethodBeat.i(24241);
    if ((this.qmJ != null) && (this.lEN != null) && (this.lEN.equals(this.qmJ.field_username)) && (bt.isNullOrNil(this.qmJ.field_championUrl)))
    {
      if (this.qlr != null) {
        this.qlr.setVisibility(0);
      }
      if (this.qmC != null)
      {
        this.qmC.setOnViewClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(24232);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceRankInfoUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            com.tencent.mm.plugin.exdevice.g.a.e.e(ExdeviceRankInfoUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankInfoUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(24232);
          }
        });
        AppMethodBeat.o(24241);
      }
    }
    else
    {
      if (this.qlr != null) {
        this.qlr.setVisibility(8);
      }
      if ((this.qmJ != null) && (!bt.bI(this.qmJ.field_username, "").equals(this.lEN)) && (!bt.isNullOrNil(this.qmJ.field_championUrl))) {
        this.qmC.setOnViewClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(24233);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceRankInfoUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            ExdeviceRankInfoUI.p(ExdeviceRankInfoUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankInfoUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(24233);
          }
        });
      }
    }
    AppMethodBeat.o(24241);
  }
  
  private void cmt()
  {
    AppMethodBeat.i(24238);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Sport.ExdeviceRankInfoUI", "updateRankInfoUIFromServer");
    this.qmT = new j(this.qmI, this.qmH, this.qmK, this.qmP, this.qmU);
    this.qmT.qfp = this;
    ba.aiU().a(this.qmT, 0);
    AppMethodBeat.o(24238);
  }
  
  private void cmu()
  {
    AppMethodBeat.i(24239);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Sport.ExdeviceRankInfoUI", "try2LocateToUser, locate2User(%s), username(%s).", new Object[] { this.qmR, this.lEN });
    if ((bt.isNullOrNil(this.qmR)) || (acV(this.qmR) < 0))
    {
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.Sport.ExdeviceRankInfoUI", "locate to username is null or nil.");
      AppMethodBeat.o(24239);
      return;
    }
    AppMethodBeat.o(24239);
  }
  
  private void cmv()
  {
    AppMethodBeat.i(24242);
    String str = cmw();
    if (!bt.isNullOrNil(str)) {
      this.qmK = str;
    }
    AppMethodBeat.o(24242);
  }
  
  private String cmw()
  {
    AppMethodBeat.i(24243);
    if (this.qmM != null)
    {
      Object localObject = this.qmM.iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.plugin.exdevice.g.b.a.d locald = ((e)((Iterator)localObject).next()).qoQ;
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
  
  private void cmx()
  {
    AppMethodBeat.i(24245);
    View localView = this.qmz.getChildAt(0);
    int[] arrayOfInt = new int[2];
    if (localView != null)
    {
      if (this.qmz.getFirstVisiblePosition() == 0)
      {
        localView.getLocationOnScreen(arrayOfInt);
        if ((bt.isNullOrNil(this.qmR)) && (qlF == 128)) {
          qlF = arrayOfInt[1];
        }
        int i = arrayOfInt[1];
        if (i > 0)
        {
          if (i >= qlF) {}
          for (float f = 1.0F;; f = i / qlF)
          {
            com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.Sport.ExdeviceRankInfoUI", "ap-alpha: %s", new Object[] { Float.valueOf(f) });
            this.qmD.setAlpha(f);
            this.qmD.setVisibility(0);
            this.qlr.setAlpha(f);
            AppMethodBeat.o(24245);
            return;
          }
        }
      }
      this.qmD.setAlpha(0.0F);
      this.qlr.setAlpha(0.0F);
      this.qmD.setVisibility(8);
    }
    AppMethodBeat.o(24245);
  }
  
  private void cmy()
  {
    AppMethodBeat.i(24250);
    if (this.qmJ != null)
    {
      if ((this.llg != this.qmJ.field_championUrl) && ((this.llg == null) || (!this.llg.equals(this.qmJ.field_championUrl))))
      {
        com.tencent.mm.plugin.exdevice.g.a.e.a(this, this.qll, this.qmJ.field_championUrl);
        this.llg = this.qmJ.field_championUrl;
        AppMethodBeat.o(24250);
      }
    }
    else
    {
      this.qll.setImageResource(2131100204);
      this.llg = null;
    }
    AppMethodBeat.o(24250);
  }
  
  private void kP(boolean paramBoolean)
  {
    AppMethodBeat.i(24236);
    if ((this.qmQ) && (!paramBoolean))
    {
      AppMethodBeat.o(24236);
      return;
    }
    com.tencent.mm.plugin.exdevice.model.ad.clB();
    this.qmO = com.tencent.mm.plugin.exdevice.g.b.c.acB(this.qmI);
    this.qmN = com.tencent.mm.plugin.exdevice.model.ad.clv().clH();
    this.qmM = this.qmA.b(this.qmN, this.qmO, this.qfm);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(24206);
        ExdeviceRankInfoUI.b(ExdeviceRankInfoUI.this).qlX = ExdeviceRankInfoUI.a(ExdeviceRankInfoUI.this);
        ExdeviceRankInfoUI.b(ExdeviceRankInfoUI.this).notifyDataSetChanged();
        ExdeviceRankInfoUI.c(ExdeviceRankInfoUI.this);
        AppMethodBeat.o(24206);
      }
    });
    AppMethodBeat.o(24236);
  }
  
  private void kQ(boolean paramBoolean)
  {
    AppMethodBeat.i(24251);
    if (paramBoolean) {
      cmv();
    }
    if (!bt.isNullOrNil(this.qmH))
    {
      this.qmD.acT(this.qmK);
      this.qmD.setVisibility(0);
      AppMethodBeat.o(24251);
      return;
    }
    this.qmD.setVisibility(8);
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
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.Sport.ExdeviceRankInfoUI", "dismiss tips dialog.");
        }
        AppMethodBeat.o(24225);
      }
    });
    this.qlt = paramj.qeQ;
    this.qlu = paramj.qeR;
    this.qfn = paramj.qfn;
    this.qfm = paramj.qfm;
    this.qfa = paramj.qfa;
    this.qmO = paramj.qff;
    this.qmN = paramj.qfg;
    this.qmM = this.qmA.b(this.qmN, this.qmO, this.qfm);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(179640);
        ExdeviceRankInfoUI.b(ExdeviceRankInfoUI.this).qlX = ExdeviceRankInfoUI.a(ExdeviceRankInfoUI.this);
        ExdeviceRankInfoUI.b(ExdeviceRankInfoUI.this).notifyDataSetChanged();
        ExdeviceRankInfoUI.c(ExdeviceRankInfoUI.this);
        AppMethodBeat.o(179640);
      }
    });
    AppMethodBeat.o(24260);
  }
  
  public final void acC(String paramString)
  {
    AppMethodBeat.i(24253);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.Sport.ExdeviceRankInfoUI", "hy: rank changed to %s", new Object[] { paramString });
    this.qmI = paramString;
    AppMethodBeat.o(24253);
  }
  
  public final void acW(String paramString)
  {
    AppMethodBeat.i(24254);
    com.tencent.mm.plugin.sport.a.c.ma(6);
    Intent localIntent = new Intent(this, ExdeviceProfileUI.class);
    localIntent.putExtra("username", paramString);
    localIntent.putExtra("usernickname", (String)this.qlY.get(paramString));
    localIntent.putExtra("app_username", this.qmH);
    localIntent.putExtra("rank_id", this.qmI);
    startActivityForResult(localIntent, 4);
    AppMethodBeat.o(24254);
  }
  
  public final boolean acX(String paramString)
  {
    AppMethodBeat.i(24258);
    if ((!bt.isNullOrNil(this.qmI)) && (!"#".equals(this.qmI)))
    {
      if (u.aAm().equals(paramString))
      {
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.Sport.ExdeviceRankInfoUI", "hy: is self. see who likes me");
        paramString = new Intent(this, ExdeviceLikeUI.class);
        paramString.putExtra("app_username", this.qmH);
        paramString.putExtra("rank_id", this.qmI);
        paramString.putExtra("key_is_like_read_only", true);
        paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramString);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramString.ahp(), "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankInfoUI", "beforeLikeBtnClicked", "(Ljava/lang/String;I)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramString.mq(0));
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
      if ((this.qmI == null) || (!this.qmI.equals(paramd.qfc))) {
        break label216;
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Sport.ExdeviceRankInfoUI", "onRankChange, rankId(%s).", new Object[] { this.qmI });
      kP(true);
      if ((bt.isNullOrNil(this.qmK)) || (!this.qmK.equals(cmw())))
      {
        cmv();
        this.qmJ = com.tencent.mm.plugin.exdevice.model.ad.clx().acF(this.qmK);
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
    if (("HardDeviceChampionInfo".equals(paramString)) && (!bt.isNullOrNil(this.qmK)) && (this.qmK.equals(paramd.username)))
    {
      this.qmJ = com.tencent.mm.plugin.exdevice.model.ad.clx().acF(this.qmK);
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
  
  public final void cY(String paramString, int paramInt)
  {
    AppMethodBeat.i(24256);
    com.tencent.mm.plugin.exdevice.model.ad.clB();
    String str1 = this.qmI;
    String str2 = this.qmH;
    com.tencent.mm.plugin.exdevice.g.b.b.d locald = com.tencent.mm.plugin.exdevice.model.ad.clu();
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
  
  public final void cmz()
  {
    AppMethodBeat.i(24255);
    com.tencent.mm.plugin.sport.a.c.ma(31);
    cmA();
    AppMethodBeat.o(24255);
  }
  
  public int getLayoutId()
  {
    return 2131493887;
  }
  
  public void initView()
  {
    AppMethodBeat.i(24244);
    this.qmB = findViewById(2131302912);
    Object localObject1 = new ExdeviceRankListHeaderView(this);
    Object localObject2 = new Rect();
    getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject2);
    int j = ((Rect)localObject2).top;
    int i = j;
    if (j == 0) {
      i = com.tencent.mm.plugin.exdevice.k.b.B(this, getResources().getDimensionPixelSize(2131165316));
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
      this.qmC = ((ExdeviceRankListHeaderView)localObject1);
      localObject1 = (MMPullDownView)findViewById(2131303544);
      this.qmz = ((ListView)findViewById(2131299583));
      this.qmD = ((ExdeviceRankChampionInfoView)findViewById(2131297945));
      this.qlr = findViewById(2131304599);
      this.qlr.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(179647);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceRankInfoUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.Sport.ExdeviceRankInfoUI", "ap: start change cover");
          com.tencent.mm.plugin.exdevice.g.a.e.e(ExdeviceRankInfoUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankInfoUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(179647);
        }
      });
      this.qmC.setIsShowTip(false);
      cmn();
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
        public final boolean cbc()
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
        public final void cms()
        {
          AppMethodBeat.i(179632);
          ExdeviceRankInfoUI.r(ExdeviceRankInfoUI.this);
          AppMethodBeat.o(179632);
        }
      });
      ((MMPullDownView)localObject1).setAtTopCallBack(new MMPullDownView.d()
      {
        public final boolean cbb()
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
      this.qmz.setOnScrollListener(new AbsListView.OnScrollListener()
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
      this.qmz.addHeaderView(this.qmC, null, false);
      localObject2 = getLayoutInflater().inflate(2131493885, null);
      this.qmE = ((View)localObject2).findViewById(2131301056);
      ((View)localObject2).findViewById(2131301055).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(179636);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceRankInfoUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          com.tencent.mm.plugin.sport.a.c.ma(24);
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("Select_Talker_Name", "gh_43f2581f6fd6");
          paramAnonymousView.putExtra("Select_block_List", "gh_43f2581f6fd6");
          paramAnonymousView.putExtra("Select_Conv_Type", 3);
          paramAnonymousView.putExtra("mutil_select_is_ret", true);
          paramAnonymousView.putExtra("Select_Send_Card", true);
          com.tencent.mm.bs.d.c(ExdeviceRankInfoUI.this, ".ui.transmit.SelectConversationUI", paramAnonymousView, 3);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankInfoUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(179636);
        }
      });
      this.qmE.setVisibility(8);
      this.qmz.addFooterView((View)localObject2);
      if (this.qmN == null) {
        break label759;
      }
    }
    label759:
    for (i = this.qmN.size();; i = 0)
    {
      if (this.qmO != null) {}
      for (j = this.qmO.size();; j = 0)
      {
        if (i + j == 0)
        {
          this.qmM = new ArrayList();
          this.qmA.qlX = this.qmM;
          getString(2131755906);
          this.qjb = com.tencent.mm.ui.base.h.b(this, getString(2131760709), true, new DialogInterface.OnCancelListener()
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
        this.qmz.setAdapter(this.qmA);
        this.qmA.qma = this;
        if (this.qmL == 1)
        {
          this.qmz.setVisibility(0);
          this.qmB.setVisibility(8);
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
          this.qmz.setVisibility(8);
          this.qmB.setVisibility(0);
        }
        label638:
        this.qll = ((ImageView)findViewById(2131299545));
        ((MMPullDownView)localObject1).setCanOverScrool(false);
        int k = com.tencent.mm.cc.a.ip(this);
        j = ((Integer)this.qmC.getTag()).intValue();
        i = j;
        if (this.qfm)
        {
          i = getResources().getDimensionPixelSize(2131165326);
          int m = getResources().getDimensionPixelSize(2131165325);
          i = j + (i / 2 + m);
        }
        localObject1 = new RelativeLayout.LayoutParams(k, i);
        this.qll.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        cmy();
        kQ(false);
        AppMethodBeat.o(24244);
        return;
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(24257);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (com.tencent.mm.plugin.exdevice.g.a.e.a(this, paramInt1, paramInt2, paramIntent, this.qmH))
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
      ac.a(this, (String)localObject, ac.eD(this), paramIntent, this.qlu);
      com.tencent.mm.ui.base.h.cl(getContext(), getResources().getString(2131755894));
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.Sport.ExdeviceRankInfoUI", "Select conversation return.");
      AppMethodBeat.o(24257);
      return;
      com.tencent.mm.ui.base.h.cl(getContext(), getResources().getString(2131755894));
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.Sport.ExdeviceRankInfoUI", "Share to timeline return.");
      AppMethodBeat.o(24257);
      return;
      if (paramIntent != null)
      {
        localObject = bt.U(paramIntent.getStringExtra("received_card_name").split(","));
        paramIntent = paramIntent.getStringExtra("custom_send_text");
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          com.tencent.mm.plugin.messenger.a.g.dlD().q("gh_43f2581f6fd6", str, w.vF(str));
          if (!bt.isNullOrNil(paramIntent))
          {
            sx localsx = new sx();
            localsx.dHy.dHz = str;
            localsx.dHy.content = paramIntent;
            localsx.dHy.type = w.Ar(str);
            localsx.dHy.flags = 0;
            com.tencent.mm.sdk.b.a.IbL.l(localsx);
          }
        }
        AppMethodBeat.o(24257);
        return;
        if ((paramIntent != null) && (paramIntent.getBooleanExtra("KeyNeedUpdateRank", false))) {
          cmt();
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(24237);
    super.onCreate(paramBundle);
    this.mIsDestroyed = false;
    this.lEN = u.aAm();
    paramBundle = getIntent();
    this.qmF = paramBundle.getStringExtra("key_rank_info");
    this.qmG = paramBundle.getStringExtra("key_rank_semi");
    this.qmH = paramBundle.getStringExtra("app_username");
    this.qmI = paramBundle.getStringExtra("rank_id");
    this.qmP = paramBundle.getBooleanExtra("key_is_latest", false);
    this.qmK = paramBundle.getStringExtra("key_champioin_username");
    this.qmL = paramBundle.getIntExtra("device_type", 0);
    this.qmR = paramBundle.getStringExtra("locate_to_username");
    this.qmQ = paramBundle.getBooleanExtra("key_only_show_latest_rank", false);
    Object localObject;
    if ((bt.isNullOrNil(this.qmI)) || ("#".equals(this.qmI))) {
      if (!this.qmQ)
      {
        paramBundle = com.tencent.mm.plugin.exdevice.model.ad.clu();
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
        this.qmI = paramBundle.field_rankID;
        this.qmH = paramBundle.field_appusername;
      }
      this.qmK = null;
      this.qmP = true;
      com.tencent.mm.plugin.exdevice.model.ad.clB();
      this.qmO = com.tencent.mm.plugin.exdevice.g.b.c.acB(this.qmI);
      if (!this.qmQ)
      {
        if ((this.qmO == null) || (this.qmO.size() <= 0))
        {
          this.qmN = new ArrayList();
          this.qmO = com.tencent.mm.plugin.exdevice.g.a.a.a(this.qmI, this.qmH, this.qmF, this.qmG, this.qlY, this.qmN);
          com.tencent.mm.plugin.exdevice.model.ad.clB();
          com.tencent.mm.plugin.exdevice.g.b.c.e(this.qmI, this.qmO);
          label341:
          this.qmN = com.tencent.mm.plugin.exdevice.model.ad.clv().clH();
        }
      }
      else
      {
        this.qmA = new b(this, this.qmH);
        this.qmA.qlY = this.qlY;
        this.qmM = this.qmA.b(this.qmN, this.qmO, this.qfm);
        this.qmA.qlX = this.qmM;
        if (bt.isNullOrNil(this.qmK)) {
          cmv();
        }
        this.qmJ = com.tencent.mm.plugin.exdevice.model.ad.clx().acF(this.qmK);
        if ((this.qmJ == null) && (!bt.isNullOrNil(this.qmK)))
        {
          this.qmJ = new com.tencent.mm.plugin.exdevice.g.b.a.a();
          this.qmJ.field_username = this.qmK;
          this.qmJ.field_championMotto = getIntent().getStringExtra("key_champion_info");
          this.qmJ.field_championUrl = getIntent().getStringExtra("key_champion_coverimg");
          com.tencent.mm.plugin.exdevice.model.ad.clB();
          paramBundle = this.qmJ;
          com.tencent.mm.plugin.exdevice.model.ad.clx().a(paramBundle);
        }
        initView();
        if ((this.qmO != null) && (this.qmO.size() > 0))
        {
          paramBundle = ((com.tencent.mm.plugin.exdevice.g.b.a.d)this.qmO.get(0)).field_username;
          this.qmD.acT(paramBundle);
        }
        com.tencent.mm.plugin.exdevice.model.ad.clC().a(this);
        com.tencent.mm.plugin.exdevice.model.ad.clB().qfw = this;
        cmt();
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
        cmu();
        paramBundle = new vl();
        paramBundle.dJE.action = 2;
        com.tencent.mm.sdk.b.a.IbL.a(paramBundle, new Executor()
        {
          public final void execute(Runnable paramAnonymousRunnable)
          {
            AppMethodBeat.i(179643);
            com.tencent.e.h.LTJ.aR(paramAnonymousRunnable);
            AppMethodBeat.o(179643);
          }
        });
        if (!com.tencent.mm.compatible.util.d.lA(28)) {}
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
          if (com.tencent.mm.kernel.g.ajC().ajl().getInt(al.a.IJD, 0) == 1)
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Sport.ExdeviceRankInfoUI", "toast get step fail");
            Toast.makeText(this, 2131758595, 0).show();
            com.tencent.mm.plugin.report.e.ygI.idkeyStat(323L, 6L, 1L, false);
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
          com.tencent.mm.plugin.exdevice.g.a.a.d(this.qmF, this.qmG, this.qlY);
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
    if (this.qmA != null) {
      b.finish();
    }
    super.onDestroy();
    if (this.qmT != null) {
      this.qmT.qfp = null;
    }
    com.tencent.mm.plugin.exdevice.model.ad.clC().b(this);
    com.tencent.mm.plugin.exdevice.model.ad.clB().qfw = null;
    com.tencent.mm.plugin.exdevice.model.ad.clB().qfx = null;
    if (this.likeCount > 0)
    {
      int i = this.likeCount;
      com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.Sport.SportReportLogic", "reportLikeCount count=%d", new Object[] { Integer.valueOf(i) });
      com.tencent.mm.plugin.report.e.ygI.f(13168, new Object[] { Integer.valueOf(0), Integer.valueOf(i) });
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
    kP(true);
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