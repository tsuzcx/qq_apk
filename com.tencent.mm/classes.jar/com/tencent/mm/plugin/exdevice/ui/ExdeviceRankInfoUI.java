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
import com.tencent.mm.g.a.sy;
import com.tencent.mm.g.a.vp;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.model.z;
import com.tencent.mm.model.z.b;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.exdevice.g.a.j;
import com.tencent.mm.plugin.exdevice.g.a.j.a;
import com.tencent.mm.plugin.exdevice.g.b.f;
import com.tencent.mm.plugin.exdevice.model.ac;
import com.tencent.mm.plugin.exdevice.model.ac.a;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.a;
import com.tencent.mm.ui.base.MMPullDownView.b;
import com.tencent.mm.ui.base.MMPullDownView.c;
import com.tencent.mm.ui.base.MMPullDownView.d;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
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
  private static int qsk = 128;
  private String lJm;
  private int likeCount;
  private String lpE;
  private boolean mIsDestroyed;
  private boolean qlF;
  public boolean qlR;
  public String qlS;
  private com.tencent.mm.ui.base.p qpG;
  private ImageView qrQ;
  private View qrW;
  private String qrY;
  private String qrZ;
  private Map<String, String> qsD;
  private ListView qte;
  private b qtf;
  private View qtg;
  private ExdeviceRankListHeaderView qth;
  private ExdeviceRankChampionInfoView qti;
  private View qtj;
  private String qtk;
  private String qtl;
  private String qtm;
  private String qtn;
  private com.tencent.mm.plugin.exdevice.g.b.a.a qto;
  private String qtp;
  private int qtq;
  private List<e> qtr;
  private ArrayList<com.tencent.mm.plugin.exdevice.g.b.a.c> qts;
  private ArrayList<com.tencent.mm.plugin.exdevice.g.b.a.d> qtt;
  private boolean qtu;
  private boolean qtv;
  private String qtw;
  private boolean qtx;
  private j qty;
  private com.tencent.mm.plugin.exdevice.b.b<j> qtz;
  
  public ExdeviceRankInfoUI()
  {
    AppMethodBeat.i(24235);
    this.qpG = null;
    this.qsD = new HashMap();
    this.qtz = new com.tencent.mm.plugin.exdevice.b.b() {};
    AppMethodBeat.o(24235);
  }
  
  private int adM(String paramString)
  {
    AppMethodBeat.i(24240);
    ae.i("MicroMsg.Sport.ExdeviceRankInfoUI", "locateToUser, locate2User(%s), username(%s).", new Object[] { paramString, this.lJm });
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(24240);
      return -1;
    }
    if ((this.qtr == null) || (this.qtr.size() == 0))
    {
      AppMethodBeat.o(24240);
      return -2;
    }
    int i = 0;
    while (i < this.qtr.size())
    {
      Object localObject = ((e)this.qtr.get(i)).qvw;
      int j = ((e)this.qtr.get(i)).qvx;
      if ((localObject != null) && (paramString.equalsIgnoreCase(((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject).field_username)) && (!paramString.equalsIgnoreCase(this.lJm)) && ((j & 0x2) != 2))
      {
        localObject = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
        j = ((DisplayMetrics)localObject).heightPixels;
        ae.i("MicroMsg.Sport.ExdeviceRankInfoUI", "locateToUser pos(%d).(h : %d)", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        this.qte.setSelectionFromTop(i, j / 4);
        this.qtf.qsE = paramString;
        this.qtf.notifyDataSetInvalidated();
        cnN();
        AppMethodBeat.o(24240);
        return i;
      }
      i += 1;
    }
    this.qtf.qsE = null;
    AppMethodBeat.o(24240);
    return -3;
  }
  
  private void cnD()
  {
    AppMethodBeat.i(24241);
    if ((this.qto != null) && (this.lJm != null) && (this.lJm.equals(this.qto.field_username)) && (bu.isNullOrNil(this.qto.field_championUrl)))
    {
      if (this.qrW != null) {
        this.qrW.setVisibility(0);
      }
      if (this.qth != null)
      {
        this.qth.setOnViewClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(24232);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceRankInfoUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
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
      if (this.qrW != null) {
        this.qrW.setVisibility(8);
      }
      if ((this.qto != null) && (!bu.bI(this.qto.field_username, "").equals(this.lJm)) && (!bu.isNullOrNil(this.qto.field_championUrl))) {
        this.qth.setOnViewClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(24233);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceRankInfoUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            ExdeviceRankInfoUI.p(ExdeviceRankInfoUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankInfoUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(24233);
          }
        });
      }
    }
    AppMethodBeat.o(24241);
  }
  
  private void cnJ()
  {
    AppMethodBeat.i(24238);
    ae.i("MicroMsg.Sport.ExdeviceRankInfoUI", "updateRankInfoUIFromServer");
    this.qty = new j(this.qtn, this.qtm, this.qtp, this.qtu, this.qtz);
    this.qty.qlU = this;
    bc.ajj().a(this.qty, 0);
    AppMethodBeat.o(24238);
  }
  
  private void cnK()
  {
    AppMethodBeat.i(24239);
    ae.i("MicroMsg.Sport.ExdeviceRankInfoUI", "try2LocateToUser, locate2User(%s), username(%s).", new Object[] { this.qtw, this.lJm });
    if ((bu.isNullOrNil(this.qtw)) || (adM(this.qtw) < 0))
    {
      ae.d("MicroMsg.Sport.ExdeviceRankInfoUI", "locate to username is null or nil.");
      AppMethodBeat.o(24239);
      return;
    }
    AppMethodBeat.o(24239);
  }
  
  private void cnL()
  {
    AppMethodBeat.i(24242);
    String str = cnM();
    if (!bu.isNullOrNil(str)) {
      this.qtp = str;
    }
    AppMethodBeat.o(24242);
  }
  
  private String cnM()
  {
    AppMethodBeat.i(24243);
    if (this.qtr != null)
    {
      Object localObject = this.qtr.iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.plugin.exdevice.g.b.a.d locald = ((e)((Iterator)localObject).next()).qvw;
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
  
  private void cnN()
  {
    AppMethodBeat.i(24245);
    View localView = this.qte.getChildAt(0);
    int[] arrayOfInt = new int[2];
    if (localView != null)
    {
      if (this.qte.getFirstVisiblePosition() == 0)
      {
        localView.getLocationOnScreen(arrayOfInt);
        if ((bu.isNullOrNil(this.qtw)) && (qsk == 128)) {
          qsk = arrayOfInt[1];
        }
        int i = arrayOfInt[1];
        if (i > 0)
        {
          if (i >= qsk) {}
          for (float f = 1.0F;; f = i / qsk)
          {
            ae.d("MicroMsg.Sport.ExdeviceRankInfoUI", "ap-alpha: %s", new Object[] { Float.valueOf(f) });
            this.qti.setAlpha(f);
            this.qti.setVisibility(0);
            this.qrW.setAlpha(f);
            AppMethodBeat.o(24245);
            return;
          }
        }
      }
      this.qti.setAlpha(0.0F);
      this.qrW.setAlpha(0.0F);
      this.qti.setVisibility(8);
    }
    AppMethodBeat.o(24245);
  }
  
  private void cnO()
  {
    AppMethodBeat.i(24250);
    if (this.qto != null)
    {
      if ((this.lpE != this.qto.field_championUrl) && ((this.lpE == null) || (!this.lpE.equals(this.qto.field_championUrl))))
      {
        com.tencent.mm.plugin.exdevice.g.a.e.a(this, this.qrQ, this.qto.field_championUrl);
        this.lpE = this.qto.field_championUrl;
        AppMethodBeat.o(24250);
      }
    }
    else
    {
      this.qrQ.setImageResource(2131100204);
      this.lpE = null;
    }
    AppMethodBeat.o(24250);
  }
  
  private void cnQ()
  {
    AppMethodBeat.i(24259);
    if (bu.isNullOrNil(this.qlS))
    {
      localObject = ad.cmN().adw(this.lJm);
      if (localObject != null) {
        this.qlS = ((com.tencent.mm.plugin.exdevice.g.b.a.a)localObject).field_championUrl;
      }
    }
    com.tencent.mm.plugin.exdevice.g.b.a.d locald = b.g(this.lJm, this.qtt);
    Object localObject = "--";
    String str = "0";
    if (locald != null)
    {
      localObject = String.valueOf(locald.field_ranknum);
      str = String.valueOf(locald.field_score);
    }
    new ac().a(this, (String)localObject, str, this.qlS, new ac.a()
    {
      public final void ado(String paramAnonymousString)
      {
        AppMethodBeat.i(24223);
        Intent localIntent = new Intent();
        localIntent.putExtra("Ksnsupload_appid", "wx7fa037cc7dfabad5");
        localIntent.putExtra("Ksnsupload_appname", ExdeviceRankInfoUI.this.getString(2131758621));
        localIntent.putExtra("Ksnsupload_source", 1);
        localIntent.putExtra("need_result", true);
        String str = z.Br("wx_sport");
        z.aBG().F(str, true).k("prePublishId", "wx_sport");
        localIntent.putExtra("reportSessionId", str);
        localIntent.putExtra("Ksnsupload_type", 0);
        localIntent.putExtra("sns_kemdia_path", paramAnonymousString);
        com.tencent.mm.br.d.b(ExdeviceRankInfoUI.this, "sns", ".ui.SnsUploadUI", localIntent, 2);
        AppMethodBeat.o(24223);
      }
    });
    AppMethodBeat.o(24259);
  }
  
  private void kP(boolean paramBoolean)
  {
    AppMethodBeat.i(24236);
    if ((this.qtv) && (!paramBoolean))
    {
      AppMethodBeat.o(24236);
      return;
    }
    ad.cmR();
    this.qtt = com.tencent.mm.plugin.exdevice.g.b.c.ads(this.qtn);
    this.qts = ad.cmL().cmX();
    this.qtr = this.qtf.b(this.qts, this.qtt, this.qlR);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(24206);
        ExdeviceRankInfoUI.b(ExdeviceRankInfoUI.this).qsC = ExdeviceRankInfoUI.a(ExdeviceRankInfoUI.this);
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
      cnL();
    }
    if (!bu.isNullOrNil(this.qtm))
    {
      this.qti.adK(this.qtp);
      this.qti.setVisibility(0);
      AppMethodBeat.o(24251);
      return;
    }
    this.qti.setVisibility(8);
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
          ae.d("MicroMsg.Sport.ExdeviceRankInfoUI", "dismiss tips dialog.");
        }
        AppMethodBeat.o(24225);
      }
    });
    this.qrY = paramj.qlv;
    this.qrZ = paramj.qlw;
    this.qlS = paramj.qlS;
    this.qlR = paramj.qlR;
    this.qlF = paramj.qlF;
    this.qtt = paramj.qlK;
    this.qts = paramj.qlL;
    this.qtr = this.qtf.b(this.qts, this.qtt, this.qlR);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(179640);
        ExdeviceRankInfoUI.b(ExdeviceRankInfoUI.this).qsC = ExdeviceRankInfoUI.a(ExdeviceRankInfoUI.this);
        ExdeviceRankInfoUI.b(ExdeviceRankInfoUI.this).notifyDataSetChanged();
        ExdeviceRankInfoUI.c(ExdeviceRankInfoUI.this);
        AppMethodBeat.o(179640);
      }
    });
    AppMethodBeat.o(24260);
  }
  
  public final void adN(String paramString)
  {
    AppMethodBeat.i(24254);
    com.tencent.mm.plugin.sport.a.c.md(6);
    Intent localIntent = new Intent(this, ExdeviceProfileUI.class);
    localIntent.putExtra("username", paramString);
    localIntent.putExtra("usernickname", (String)this.qsD.get(paramString));
    localIntent.putExtra("app_username", this.qtm);
    localIntent.putExtra("rank_id", this.qtn);
    startActivityForResult(localIntent, 4);
    AppMethodBeat.o(24254);
  }
  
  public final boolean adO(String paramString)
  {
    AppMethodBeat.i(24258);
    if ((!bu.isNullOrNil(this.qtn)) && (!"#".equals(this.qtn)))
    {
      if (v.aAC().equals(paramString))
      {
        ae.d("MicroMsg.Sport.ExdeviceRankInfoUI", "hy: is self. see who likes me");
        paramString = new Intent(this, ExdeviceLikeUI.class);
        paramString.putExtra("app_username", this.qtm);
        paramString.putExtra("rank_id", this.qtn);
        paramString.putExtra("key_is_like_read_only", true);
        paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramString);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramString.ahE(), "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankInfoUI", "beforeLikeBtnClicked", "(Ljava/lang/String;I)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramString.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankInfoUI", "beforeLikeBtnClicked", "(Ljava/lang/String;I)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(24258);
        return true;
      }
      AppMethodBeat.o(24258);
      return false;
    }
    ae.d("MicroMsg.Sport.ExdeviceRankInfoUI", "hy: rank id is not valid.abort the event");
    Toast.makeText(this, getString(2131758586), 0).show();
    AppMethodBeat.o(24258);
    return true;
  }
  
  public final void adt(String paramString)
  {
    AppMethodBeat.i(24253);
    ae.d("MicroMsg.Sport.ExdeviceRankInfoUI", "hy: rank changed to %s", new Object[] { paramString });
    this.qtn = paramString;
    AppMethodBeat.o(24253);
  }
  
  public final void b(String paramString, com.tencent.mm.plugin.exdevice.g.b.d paramd)
  {
    AppMethodBeat.i(24252);
    if ((paramd != null) && (!bu.isNullOrNil(paramString))) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if (!"HardDeviceRankInfo".equals(paramString)) {
        break;
      }
      if ((this.qtn == null) || (!this.qtn.equals(paramd.qlH))) {
        break label216;
      }
      ae.i("MicroMsg.Sport.ExdeviceRankInfoUI", "onRankChange, rankId(%s).", new Object[] { this.qtn });
      kP(true);
      if ((bu.isNullOrNil(this.qtp)) || (!this.qtp.equals(cnM())))
      {
        cnL();
        this.qto = ad.cmN().adw(this.qtp);
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
    if (("HardDeviceChampionInfo".equals(paramString)) && (!bu.isNullOrNil(this.qtp)) && (this.qtp.equals(paramd.username)))
    {
      this.qto = ad.cmN().adw(this.qtp);
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
  
  public final void cnP()
  {
    AppMethodBeat.i(24255);
    com.tencent.mm.plugin.sport.a.c.md(31);
    cnQ();
    AppMethodBeat.o(24255);
  }
  
  public final void dc(String paramString, int paramInt)
  {
    AppMethodBeat.i(24256);
    ad.cmR();
    String str1 = this.qtn;
    String str2 = this.qtm;
    com.tencent.mm.plugin.exdevice.g.b.b.d locald = ad.cmK();
    boolean bool;
    com.tencent.mm.plugin.exdevice.g.b.a.d locald1;
    if ((!bu.isNullOrNil(str1)) && (!bu.isNullOrNil(paramString)) && ((paramInt == 1) || (paramInt == 0) || (paramInt == 2)))
    {
      bool = true;
      Assert.assertTrue(bool);
      locald1 = locald.a(new com.tencent.mm.plugin.exdevice.g.b.d(str1, null, paramString));
      if (locald1 != null) {
        break label125;
      }
      ae.w("MicroMsg.ExdeviceRankInfoStg", "hy: info is null. abort");
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
        ae.w("MicroMsg.ExdeviceRankInfoStg", "hy: still loading...abort");
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
    return 2131493887;
  }
  
  public void initView()
  {
    AppMethodBeat.i(24244);
    this.qtg = findViewById(2131302912);
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
      this.qth = ((ExdeviceRankListHeaderView)localObject1);
      localObject1 = (MMPullDownView)findViewById(2131303544);
      this.qte = ((ListView)findViewById(2131299583));
      this.qti = ((ExdeviceRankChampionInfoView)findViewById(2131297945));
      this.qrW = findViewById(2131304599);
      this.qrW.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(179647);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceRankInfoUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          ae.d("MicroMsg.Sport.ExdeviceRankInfoUI", "ap: start change cover");
          com.tencent.mm.plugin.exdevice.g.a.e.e(ExdeviceRankInfoUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankInfoUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(179647);
        }
      });
      this.qth.setIsShowTip(false);
      cnD();
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
        public final boolean ccr()
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
        public final void cnI()
        {
          AppMethodBeat.i(179632);
          ExdeviceRankInfoUI.r(ExdeviceRankInfoUI.this);
          AppMethodBeat.o(179632);
        }
      });
      ((MMPullDownView)localObject1).setAtTopCallBack(new MMPullDownView.d()
      {
        public final boolean ccq()
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
      this.qte.setOnScrollListener(new AbsListView.OnScrollListener()
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
      this.qte.addHeaderView(this.qth, null, false);
      localObject2 = getLayoutInflater().inflate(2131493885, null);
      this.qtj = ((View)localObject2).findViewById(2131301056);
      ((View)localObject2).findViewById(2131301055).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(179636);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceRankInfoUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          com.tencent.mm.plugin.sport.a.c.md(24);
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("Select_Talker_Name", "gh_43f2581f6fd6");
          paramAnonymousView.putExtra("Select_block_List", "gh_43f2581f6fd6");
          paramAnonymousView.putExtra("Select_Conv_Type", 3);
          paramAnonymousView.putExtra("mutil_select_is_ret", true);
          paramAnonymousView.putExtra("Select_Send_Card", true);
          com.tencent.mm.br.d.c(ExdeviceRankInfoUI.this, ".ui.transmit.SelectConversationUI", paramAnonymousView, 3);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankInfoUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(179636);
        }
      });
      this.qtj.setVisibility(8);
      this.qte.addFooterView((View)localObject2);
      if (this.qts == null) {
        break label759;
      }
    }
    label759:
    for (i = this.qts.size();; i = 0)
    {
      if (this.qtt != null) {}
      for (j = this.qtt.size();; j = 0)
      {
        if (i + j == 0)
        {
          this.qtr = new ArrayList();
          this.qtf.qsC = this.qtr;
          getString(2131755906);
          this.qpG = com.tencent.mm.ui.base.h.b(this, getString(2131760709), true, new DialogInterface.OnCancelListener()
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
        this.qte.setAdapter(this.qtf);
        this.qtf.qsF = this;
        if (this.qtq == 1)
        {
          this.qte.setVisibility(0);
          this.qtg.setVisibility(8);
        }
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label638;
          }
          ae.d("MicroMsg.Sport.ExdeviceRankInfoUI", "hy: cannot handle this device type");
          finish();
          AppMethodBeat.o(24244);
          return;
          j = getResources().getDimensionPixelSize(2131165252);
          break;
          this.qte.setVisibility(8);
          this.qtg.setVisibility(0);
        }
        label638:
        this.qrQ = ((ImageView)findViewById(2131299545));
        ((MMPullDownView)localObject1).setCanOverScrool(false);
        int k = com.tencent.mm.cb.a.iu(this);
        j = ((Integer)this.qth.getTag()).intValue();
        i = j;
        if (this.qlR)
        {
          i = getResources().getDimensionPixelSize(2131165326);
          int m = getResources().getDimensionPixelSize(2131165325);
          i = j + (i / 2 + m);
        }
        localObject1 = new RelativeLayout.LayoutParams(k, i);
        this.qrQ.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        cnO();
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
    if (com.tencent.mm.plugin.exdevice.g.a.e.a(this, paramInt1, paramInt2, paramIntent, this.qtm))
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
        ae.e("MicroMsg.Sport.ExdeviceRankInfoUI", "onActivityResult, data is null.(reqestCode : %d)", new Object[] { Integer.valueOf(paramInt1) });
        AppMethodBeat.o(24257);
        return;
      }
      if (paramIntent == null) {}
      for (Object localObject = null; (localObject == null) || (((String)localObject).length() == 0); localObject = paramIntent.getStringExtra("Select_Conv_User"))
      {
        ae.e("MicroMsg.Sport.ExdeviceRankInfoUI", "select conversation failed, toUser is null.");
        AppMethodBeat.o(24257);
        return;
      }
      paramIntent = paramIntent.getStringExtra("custom_send_text");
      ac.a(this, (String)localObject, ac.eH(this), paramIntent, this.qrZ);
      com.tencent.mm.ui.base.h.cm(getContext(), getResources().getString(2131755894));
      ae.d("MicroMsg.Sport.ExdeviceRankInfoUI", "Select conversation return.");
      AppMethodBeat.o(24257);
      return;
      com.tencent.mm.ui.base.h.cm(getContext(), getResources().getString(2131755894));
      ae.d("MicroMsg.Sport.ExdeviceRankInfoUI", "Share to timeline return.");
      AppMethodBeat.o(24257);
      return;
      if (paramIntent != null)
      {
        localObject = bu.U(paramIntent.getStringExtra("received_card_name").split(","));
        paramIntent = paramIntent.getStringExtra("custom_send_text");
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          com.tencent.mm.plugin.messenger.a.g.doC().q("gh_43f2581f6fd6", str, x.wb(str));
          if (!bu.isNullOrNil(paramIntent))
          {
            sy localsy = new sy();
            localsy.dID.cUB = str;
            localsy.dID.content = paramIntent;
            localsy.dID.type = x.Bb(str);
            localsy.dID.flags = 0;
            com.tencent.mm.sdk.b.a.IvT.l(localsy);
          }
        }
        AppMethodBeat.o(24257);
        return;
        if ((paramIntent != null) && (paramIntent.getBooleanExtra("KeyNeedUpdateRank", false))) {
          cnJ();
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(24237);
    super.onCreate(paramBundle);
    this.mIsDestroyed = false;
    this.lJm = v.aAC();
    paramBundle = getIntent();
    this.qtk = paramBundle.getStringExtra("key_rank_info");
    this.qtl = paramBundle.getStringExtra("key_rank_semi");
    this.qtm = paramBundle.getStringExtra("app_username");
    this.qtn = paramBundle.getStringExtra("rank_id");
    this.qtu = paramBundle.getBooleanExtra("key_is_latest", false);
    this.qtp = paramBundle.getStringExtra("key_champioin_username");
    this.qtq = paramBundle.getIntExtra("device_type", 0);
    this.qtw = paramBundle.getStringExtra("locate_to_username");
    this.qtv = paramBundle.getBooleanExtra("key_only_show_latest_rank", false);
    Object localObject;
    if ((bu.isNullOrNil(this.qtn)) || ("#".equals(this.qtn))) {
      if (!this.qtv)
      {
        paramBundle = ad.cmK();
        localObject = String.format("select * from %s order by %s desc limit 1", new Object[] { "HardDeviceRankInfo", "rankID" });
        localObject = paramBundle.db.a((String)localObject, null, 2);
        if (localObject != null) {
          break label749;
        }
        ae.e("MicroMsg.ExdeviceRankInfoStg", "Get no rank in DB");
        paramBundle = null;
      }
    }
    for (;;)
    {
      if (paramBundle != null)
      {
        this.qtn = paramBundle.field_rankID;
        this.qtm = paramBundle.field_appusername;
      }
      this.qtp = null;
      this.qtu = true;
      ad.cmR();
      this.qtt = com.tencent.mm.plugin.exdevice.g.b.c.ads(this.qtn);
      if (!this.qtv)
      {
        if ((this.qtt == null) || (this.qtt.size() <= 0))
        {
          this.qts = new ArrayList();
          this.qtt = com.tencent.mm.plugin.exdevice.g.a.a.a(this.qtn, this.qtm, this.qtk, this.qtl, this.qsD, this.qts);
          ad.cmR();
          com.tencent.mm.plugin.exdevice.g.b.c.e(this.qtn, this.qtt);
          label341:
          this.qts = ad.cmL().cmX();
        }
      }
      else
      {
        this.qtf = new b(this, this.qtm);
        this.qtf.qsD = this.qsD;
        this.qtr = this.qtf.b(this.qts, this.qtt, this.qlR);
        this.qtf.qsC = this.qtr;
        if (bu.isNullOrNil(this.qtp)) {
          cnL();
        }
        this.qto = ad.cmN().adw(this.qtp);
        if ((this.qto == null) && (!bu.isNullOrNil(this.qtp)))
        {
          this.qto = new com.tencent.mm.plugin.exdevice.g.b.a.a();
          this.qto.field_username = this.qtp;
          this.qto.field_championMotto = getIntent().getStringExtra("key_champion_info");
          this.qto.field_championUrl = getIntent().getStringExtra("key_champion_coverimg");
          ad.cmR();
          paramBundle = this.qto;
          ad.cmN().a(paramBundle);
        }
        initView();
        if ((this.qtt != null) && (this.qtt.size() > 0))
        {
          paramBundle = ((com.tencent.mm.plugin.exdevice.g.b.a.d)this.qtt.get(0)).field_username;
          this.qti.adK(paramBundle);
        }
        ad.cmS().a(this);
        ad.cmR().qmb = this;
        cnJ();
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
        cnK();
        paramBundle = new vp();
        paramBundle.dKS.action = 2;
        com.tencent.mm.sdk.b.a.IvT.a(paramBundle, new Executor()
        {
          public final void execute(Runnable paramAnonymousRunnable)
          {
            AppMethodBeat.i(179643);
            com.tencent.e.h.MqF.aO(paramAnonymousRunnable);
            AppMethodBeat.o(179643);
          }
        });
        if (!com.tencent.mm.compatible.util.d.lC(28)) {}
      }
      try
      {
        if (android.support.v4.content.b.checkSelfPermission(this, "android.permission.ACTIVITY_RECOGNITION") != 0)
        {
          ae.i("MicroMsg.Sport.ExdeviceRankInfoUI", "no ACTIVITY_RECOGNITION permission");
          android.support.v4.app.a.a(this, new String[] { "android.permission.ACTIVITY_RECOGNITION" }, 5);
        }
        for (;;)
        {
          label692:
          if (com.tencent.mm.kernel.g.ajR().ajA().getInt(am.a.Jej, 0) == 1)
          {
            ae.i("MicroMsg.Sport.ExdeviceRankInfoUI", "toast get step fail");
            Toast.makeText(this, 2131758595, 0).show();
            com.tencent.mm.plugin.report.e.ywz.idkeyStat(323L, 6L, 1L, false);
          }
          AppMethodBeat.o(24237);
          return;
          label749:
          if (!((Cursor)localObject).moveToFirst())
          {
            ae.d("MicroMsg.ExdeviceRankInfoStg", "hy: no record");
            paramBundle = null;
          }
          for (;;)
          {
            ((Cursor)localObject).close();
            break;
            paramBundle = new com.tencent.mm.plugin.exdevice.g.b.a.d();
            paramBundle.convertFrom((Cursor)localObject);
          }
          com.tencent.mm.plugin.exdevice.g.a.a.d(this.qtk, this.qtl, this.qsD);
          break label341;
          ae.i("MicroMsg.Sport.ExdeviceRankInfoUI", "has ACTIVITY_RECOGNITION permission");
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
    if (this.qtf != null) {
      b.finish();
    }
    super.onDestroy();
    if (this.qty != null) {
      this.qty.qlU = null;
    }
    ad.cmS().b(this);
    ad.cmR().qmb = null;
    ad.cmR().qmc = null;
    if (this.likeCount > 0)
    {
      int i = this.likeCount;
      ae.v("MicroMsg.Sport.SportReportLogic", "reportLikeCount count=%d", new Object[] { Integer.valueOf(i) });
      com.tencent.mm.plugin.report.e.ywz.f(13168, new Object[] { Integer.valueOf(0), Integer.valueOf(i) });
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