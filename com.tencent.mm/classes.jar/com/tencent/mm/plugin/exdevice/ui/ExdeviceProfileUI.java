package com.tencent.mm.plugin.exdevice.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.oc;
import com.tencent.mm.g.a.us;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.plugin.exdevice.model.ac.a;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.sport.ui.SportChartView;
import com.tencent.mm.plugin.sport.ui.SportChartView.a;
import com.tencent.mm.protocal.protobuf.api;
import com.tencent.mm.protocal.protobuf.bel;
import com.tencent.mm.protocal.protobuf.ddd;
import com.tencent.mm.protocal.protobuf.ect;
import com.tencent.mm.protocal.protobuf.px;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.a;
import com.tencent.mm.ui.base.MMPullDownView.b;
import com.tencent.mm.ui.base.MMPullDownView.c;
import com.tencent.mm.ui.base.MMPullDownView.d;
import com.tencent.mm.ui.base.MMPullDownView.e;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executor;
import junit.framework.Assert;

public class ExdeviceProfileUI
  extends MMActivity
  implements com.tencent.mm.ak.g, com.tencent.mm.plugin.exdevice.g.b.e, c
{
  private static int pIa = 0;
  private TextPaint awy;
  private int glT;
  private GestureDetector irA;
  private String kOD;
  private String lhM;
  private String mAppName;
  private Context mContext;
  private boolean mIsDestroyed;
  private List<String> pBL;
  private List<String> pBM;
  private String pBj;
  private boolean pBv;
  private p pFw;
  private String pHB;
  private com.tencent.mm.plugin.exdevice.g.b.a.a pHC;
  private ArrayList<String> pHD;
  private ect pHE;
  private ExdeviceProfileAffectedUserView pHF;
  private ImageView pHG;
  private ListView pHH;
  private ExdeviceProfileListHeader pHI;
  private MMSwitchBtn pHJ;
  private SportChartView pHK;
  private a pHL;
  private View pHM;
  private volatile boolean pHN;
  private String pHO;
  private String pHP;
  private List<com.tencent.mm.plugin.sport.a.d> pHQ;
  private List<com.tencent.mm.plugin.sport.a.d> pHR;
  private ArrayList<com.tencent.mm.plugin.exdevice.g.b.a.c> pHS;
  private List<api> pHT;
  private int pHU;
  private com.tencent.mm.plugin.exdevice.b.b<com.tencent.mm.plugin.exdevice.g.a.i> pHV;
  private com.tencent.mm.plugin.sport.model.d pHW;
  private n.d pHX;
  private com.tencent.mm.plugin.exdevice.b.b<com.tencent.mm.plugin.exdevice.g.a.h> pHY;
  private com.tencent.mm.plugin.exdevice.b.b<com.tencent.mm.plugin.exdevice.g.a.g> pHZ;
  private boolean pHg;
  private boolean pHh;
  private int pHi;
  private List<px> pHl;
  private Runnable pIb;
  private com.tencent.mm.plugin.exdevice.b.b<com.tencent.mm.plugin.exdevice.g.a.g> pIc;
  private List<String> pId;
  private com.tencent.mm.plugin.exdevice.b.b<com.tencent.mm.plugin.exdevice.g.a.k> pIe;
  private com.tencent.mm.plugin.exdevice.g.a.k pIf;
  private com.tencent.mm.sdk.b.c<oc> pIg;
  private MMPullDownView.a pIh;
  
  public ExdeviceProfileUI()
  {
    AppMethodBeat.i(24132);
    this.mIsDestroyed = false;
    this.pFw = null;
    this.pHV = new com.tencent.mm.plugin.exdevice.b.b() {};
    this.awy = new TextPaint(1);
    this.glT = 0;
    this.pHX = new n.d()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(179628);
        switch (paramAnonymousMenuItem.getItemId())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(179628);
          return;
          com.tencent.mm.plugin.sport.a.c.lA(27);
          ExdeviceProfileUI.r(ExdeviceProfileUI.this);
          AppMethodBeat.o(179628);
          return;
          com.tencent.mm.plugin.sport.a.c.lA(26);
          ExdeviceProfileUI.s(ExdeviceProfileUI.this);
          AppMethodBeat.o(179628);
          return;
          ExdeviceProfileUI.t(ExdeviceProfileUI.this);
          AppMethodBeat.o(179628);
          return;
          com.tencent.mm.ui.base.h.a(ExdeviceProfileUI.this.getContext(), ExdeviceProfileUI.this.getString(2131758619), null, true, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(179627);
              az.ayM();
              paramAnonymous2DialogInterface = com.tencent.mm.model.c.awB().aNt(ExdeviceProfileUI.u(ExdeviceProfileUI.this));
              com.tencent.mm.plugin.sport.a.c.lA(37);
              w.k(paramAnonymous2DialogInterface);
              ExdeviceProfileUI.v(ExdeviceProfileUI.this).alive();
              if (ExdeviceProfileUI.d(ExdeviceProfileUI.this) != null) {
                ExdeviceProfileUI.d(ExdeviceProfileUI.this).show();
              }
              AppMethodBeat.o(179627);
            }
          }, null);
          AppMethodBeat.o(179628);
          return;
          ExdeviceProfileUI.b(ExdeviceProfileUI.this, true);
          com.tencent.mm.plugin.sport.a.c.lA(10);
          ad.cgX();
          com.tencent.mm.plugin.exdevice.g.b.c.c("", ExdeviceProfileUI.w(ExdeviceProfileUI.this), ExdeviceProfileUI.u(ExdeviceProfileUI.this), 3);
          AppMethodBeat.o(179628);
          return;
          com.tencent.mm.plugin.sport.a.c.lA(41);
          paramAnonymousMenuItem = new Intent();
          paramAnonymousMenuItem.putExtra("rawUrl", ExdeviceProfileUI.o(ExdeviceProfileUI.this));
          com.tencent.mm.br.d.b(ExdeviceProfileUI.this, "webview", ".ui.tools.WebViewUI", paramAnonymousMenuItem);
        }
      }
    };
    this.pHY = new com.tencent.mm.plugin.exdevice.b.b() {};
    this.pHZ = new com.tencent.mm.plugin.exdevice.b.b() {};
    this.pIb = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(179611);
        Object localObject1 = ExdeviceProfileUI.z(ExdeviceProfileUI.this);
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject1);
        Object localObject2 = new Object();
        com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aeD(), "com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileUI$22", "run", "()V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        BackwardSupportUtil.c.b((ListView)((com.tencent.mm.hellhoundlib.b.a)localObject1).lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileUI$22", "run", "()V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        if (ExdeviceProfileUI.z(ExdeviceProfileUI.this).getCount() > 0) {
          BackwardSupportUtil.c.b(ExdeviceProfileUI.z(ExdeviceProfileUI.this), ExdeviceProfileUI.z(ExdeviceProfileUI.this).getCount() - 1);
        }
        AppMethodBeat.o(179611);
      }
    };
    this.pIc = new com.tencent.mm.plugin.exdevice.b.b() {};
    this.pIe = new com.tencent.mm.plugin.exdevice.b.b() {};
    this.pIg = new com.tencent.mm.sdk.b.c() {};
    this.pIh = new MMPullDownView.a()
    {
      public final boolean onInterceptTouchEvent(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(179622);
        boolean bool = ExdeviceProfileUI.G(ExdeviceProfileUI.this).onTouchEvent(paramAnonymousMotionEvent);
        AppMethodBeat.o(179622);
        return bool;
      }
    };
    AppMethodBeat.o(24132);
  }
  
  private void chG()
  {
    AppMethodBeat.i(24134);
    this.pHS = ad.cgR().chd();
    if (this.pHS != null) {
      com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.Sport.ExdeviceProfileUI", "ap: follow size:%s, %s", new Object[] { Integer.valueOf(this.pHS.size()), this.pHS.toString() });
    }
    while (!bs.gY(this.pHS))
    {
      this.pHi = this.pHS.size();
      AppMethodBeat.o(24134);
      return;
      com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.Sport.ExdeviceProfileUI", "ap: follow is null");
    }
    this.pHi = 0;
    AppMethodBeat.o(24134);
  }
  
  private void chH()
  {
    AppMethodBeat.i(24135);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(179625);
        a locala = ExdeviceProfileUI.l(ExdeviceProfileUI.this);
        ArrayList localArrayList = ExdeviceProfileUI.p(ExdeviceProfileUI.this);
        List localList = ExdeviceProfileUI.q(ExdeviceProfileUI.this);
        locala.pHh = ad.cgR().YX(locala.lhM);
        locala.pHk = localArrayList;
        if (!bs.gY(localArrayList)) {}
        for (locala.pHi = localArrayList.size();; locala.pHi = 0)
        {
          locala.pHl = localList;
          if (!bs.gY(localList)) {
            locala.pHj = localList.size();
          }
          com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.ExdeviceProfileAdapter", "setData,mIsFollower:%s ,mFollowersNum:%s  ,mButtonNum:%s ,mUsername:%s", new Object[] { Boolean.valueOf(locala.pHh), Integer.valueOf(locala.pHi), Integer.valueOf(locala.pHj), locala.lhM });
          ExdeviceProfileUI.l(ExdeviceProfileUI.this).notifyDataSetChanged();
          AppMethodBeat.o(179625);
          return;
        }
      }
    });
    AppMethodBeat.o(24135);
  }
  
  private void chI()
  {
    AppMethodBeat.i(24138);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(179603);
        ExdeviceProfileUI.g(ExdeviceProfileUI.this);
        ExdeviceProfileUI.l(ExdeviceProfileUI.this).notifyDataSetChanged();
        AppMethodBeat.o(179603);
      }
    });
    AppMethodBeat.o(24138);
  }
  
  private void chJ()
  {
    AppMethodBeat.i(24140);
    String str = u.axw();
    if (this.pHM != null) {
      this.pHM.setVisibility(8);
    }
    if ((!bs.isNullOrNil(str)) && (str.equals(this.lhM)))
    {
      if ((this.pHC != null) && (bs.isNullOrNil(this.pHC.field_championUrl)) && (this.pHM != null)) {
        this.pHM.setVisibility(0);
      }
      if (this.pHI != null)
      {
        this.pHI.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(24107);
            com.tencent.mm.plugin.sport.a.c.lA(18);
            com.tencent.mm.plugin.exdevice.g.a.e.d(ExdeviceProfileUI.this);
            AppMethodBeat.o(24107);
          }
        });
        AppMethodBeat.o(24140);
      }
    }
    else if ((this.pHC != null) && (!bs.isNullOrNil(this.pHC.field_championUrl)) && (this.pHI != null))
    {
      this.pHI.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(179610);
          ExdeviceProfileUI.B(ExdeviceProfileUI.this);
          AppMethodBeat.o(179610);
        }
      });
    }
    AppMethodBeat.o(24140);
  }
  
  private void chK()
  {
    AppMethodBeat.i(24141);
    if (this.pHC != null)
    {
      if ((this.kOD != this.pHC.field_championUrl) && ((this.kOD == null) || (!this.kOD.equals(this.pHC.field_championUrl))))
      {
        com.tencent.mm.plugin.exdevice.g.a.e.a(this, this.pHG, this.pHC.field_championUrl);
        this.kOD = this.pHC.field_championUrl;
        AppMethodBeat.o(24141);
      }
    }
    else
    {
      this.pHG.setImageResource(2131100204);
      this.kOD = null;
    }
    AppMethodBeat.o(24141);
  }
  
  private void chN()
  {
    AppMethodBeat.i(161358);
    if (this.pHK == null) {
      this.pHK = ((SportChartView)findViewById(2131299585));
    }
    if (this.pHK == null)
    {
      AppMethodBeat.o(161358);
      return;
    }
    if (this.pHJ == null) {
      this.pHJ = ((MMSwitchBtn)findViewById(2131299587));
    }
    HashSet localHashSet = new HashSet();
    final ArrayList localArrayList = new ArrayList();
    Iterator localIterator;
    com.tencent.mm.plugin.sport.a.d locald;
    if (this.pHQ != null)
    {
      localIterator = this.pHQ.iterator();
      while (localIterator.hasNext())
      {
        locald = (com.tencent.mm.plugin.sport.a.d)localIterator.next();
        if (localHashSet.add(locald.field_date)) {
          localArrayList.add(locald);
        }
      }
    }
    if (this.pHR != null)
    {
      localIterator = this.pHR.iterator();
      while (localIterator.hasNext())
      {
        locald = (com.tencent.mm.plugin.sport.a.d)localIterator.next();
        if (localHashSet.add(locald.field_date)) {
          localArrayList.add(locald);
        }
      }
    }
    Collections.sort(localArrayList);
    if (localArrayList.size() > 0)
    {
      if (this.pHg)
      {
        this.pHK.setHasSwitchBtn(true);
        this.pHJ.setVisibility(0);
        this.pHJ.setSwitchListener(new MMSwitchBtn.a()
        {
          public final void onStatusChange(boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(179621);
            if (paramAnonymousBoolean) {
              ExdeviceProfileUI.F(ExdeviceProfileUI.this).a(SportChartView.a.zpK);
            }
            for (;;)
            {
              ExdeviceProfileUI.F(ExdeviceProfileUI.this).fY(localArrayList);
              AppMethodBeat.o(179621);
              return;
              ExdeviceProfileUI.F(ExdeviceProfileUI.this).a(SportChartView.a.zpJ);
            }
          }
        });
      }
      for (;;)
      {
        this.pHK.setTodayStep(((com.tencent.mm.plugin.sport.a.d)localArrayList.get(localArrayList.size() - 1)).field_step);
        this.pHK.fY(localArrayList);
        AppMethodBeat.o(161358);
        return;
        this.pHK.setHasSwitchBtn(false);
        this.pHJ.setVisibility(8);
        this.pHJ.setSwitchListener(null);
        this.pHK.a(SportChartView.a.zpJ);
        this.pHK.fY(localArrayList);
      }
    }
    this.pHK.setHasSwitchBtn(false);
    this.pHJ.setVisibility(8);
    this.pHK.fY(null);
    AppMethodBeat.o(161358);
  }
  
  public final void b(String paramString, com.tencent.mm.plugin.exdevice.g.b.d paramd)
  {
    AppMethodBeat.i(24143);
    if (("HardDeviceChampionInfo".equals(paramString)) && (this.lhM.equals(paramd.username)))
    {
      com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.Sport.ExdeviceProfileUI", "hy: url may changed. maybe reload background");
      this.pHC = ad.cgT().YZ(this.lhM);
      runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(179614);
          ExdeviceProfileUI.C(ExdeviceProfileUI.this);
          ExdeviceProfileUI.l(ExdeviceProfileUI.this).notifyDataSetChanged();
          ExdeviceProfileUI.D(ExdeviceProfileUI.this);
          AppMethodBeat.o(179614);
        }
      });
    }
    AppMethodBeat.o(24143);
  }
  
  public final void chL()
  {
    AppMethodBeat.i(24144);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(179617);
        if (ExdeviceProfileUI.d(ExdeviceProfileUI.this) != null) {
          ExdeviceProfileUI.d(ExdeviceProfileUI.this).show();
        }
        AppMethodBeat.o(179617);
      }
    });
    if (this.pIf != null) {
      az.agi().a(this.pIf);
    }
    this.pIf = new com.tencent.mm.plugin.exdevice.g.a.k(this.pIe);
    az.agi().a(this.pIf, 0);
    AppMethodBeat.o(24144);
  }
  
  public final void chM()
  {
    AppMethodBeat.i(24145);
    com.tencent.mm.plugin.sport.a.c.lA(17);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.lhM);
    az.agi().a(new com.tencent.mm.plugin.exdevice.g.a.g(localArrayList, this.pHZ), 0);
    AppMethodBeat.o(24145);
  }
  
  public int getLayoutId()
  {
    return 2131493878;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(24142);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (com.tencent.mm.plugin.exdevice.g.a.e.a(this, paramInt1, paramInt2, paramIntent, this.mAppName))
    {
      AppMethodBeat.o(24142);
      return;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(24142);
      return;
      if (paramInt2 == -1)
      {
        Toast.makeText(this, 2131763646, 1).show();
        AppMethodBeat.o(24142);
        return;
        if (paramInt2 == -1)
        {
          if (paramIntent == null) {}
          String str2;
          for (String str1 = null;; str1 = paramIntent.getStringExtra("Select_Conv_User"))
          {
            str2 = com.tencent.mm.plugin.exdevice.model.ac.eD(this);
            if ((str1 != null) && (str1.length() != 0)) {
              break;
            }
            com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.Sport.ExdeviceProfileUI", "select conversation failed, toUser is null.");
            AppMethodBeat.o(24142);
            return;
          }
          com.tencent.mm.plugin.exdevice.model.ac.a(this, str1, str2, paramIntent.getStringExtra("custom_send_text"), this.pHP);
          com.tencent.mm.ui.base.h.cg(getContext(), getResources().getString(2131755894));
          AppMethodBeat.o(24142);
          return;
          if (paramInt2 == -1)
          {
            paramIntent = bs.S(paramIntent.getStringExtra("Select_Contact").split(","));
            if (paramIntent == null)
            {
              AppMethodBeat.o(24142);
              return;
            }
            if (this.pFw != null) {
              this.pFw.show();
            }
            az.agi().a(new com.tencent.mm.plugin.exdevice.g.a.g(paramIntent, this.pIc), 0);
          }
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(24133);
    super.onCreate(paramBundle);
    this.mContext = getContext();
    paramBundle = getIntent();
    chG();
    this.lhM = paramBundle.getStringExtra("username");
    this.pHB = paramBundle.getStringExtra("usernickname");
    paramBundle = u.axw();
    if (paramBundle != null) {
      this.pHg = paramBundle.equals(this.lhM);
    }
    this.mAppName = getIntent().getStringExtra("app_username");
    this.pHh = ad.cgR().YX(this.lhM);
    com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.Sport.ExdeviceProfileUI", "is follow %s", new Object[] { Boolean.valueOf(this.pHh) });
    boolean bool;
    int m;
    Object localObject2;
    if (!bs.isNullOrNil(this.lhM))
    {
      bool = true;
      Assert.assertTrue(bool);
      this.pHC = ad.cgT().YZ(this.lhM);
      this.pHD = getIntent().getStringArrayListExtra("key_affected_semi");
      getString(2131755906);
      this.pFw = com.tencent.mm.ui.base.h.c(this, getString(2131760709), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(179604);
          if (ExdeviceProfileUI.d(ExdeviceProfileUI.this) != null)
          {
            ExdeviceProfileUI.d(ExdeviceProfileUI.this).dismiss();
            ExdeviceProfileUI.y(ExdeviceProfileUI.this);
          }
          ExdeviceProfileUI.this.finish();
          AppMethodBeat.o(179604);
        }
      });
      this.pHF = ((ExdeviceProfileAffectedUserView)findViewById(2131299542));
      this.pHG = ((ImageView)findViewById(2131299545));
      this.pHH = ((ListView)findViewById(2131299581));
      paramBundle = (MMPullDownView)findViewById(2131303543);
      this.pHF.setAffectedUserInfo(this.pHD);
      chK();
      this.pHM = findViewById(2131304599);
      this.irA = new GestureDetector(getContext(), new a((byte)0));
      paramBundle.setIsBottomShowAll(false);
      paramBundle.setTopViewVisible(false);
      paramBundle.setBottomViewVisible(false);
      paramBundle.setIsBottomShowAll(false);
      paramBundle.setIsTopShowAll(false);
      paramBundle.setCanOverScrool(true);
      paramBundle.setOnInterceptTouchEventListener(this.pIh);
      paramBundle.setAtBottomCallBack(new MMPullDownView.c()
      {
        public final boolean bWz()
        {
          AppMethodBeat.i(179605);
          View localView = ExdeviceProfileUI.z(ExdeviceProfileUI.this).getChildAt(ExdeviceProfileUI.z(ExdeviceProfileUI.this).getChildCount() - 1);
          int i = ExdeviceProfileUI.z(ExdeviceProfileUI.this).getAdapter().getCount();
          if ((i > 0) && (localView != null) && (localView.getBottom() <= ExdeviceProfileUI.z(ExdeviceProfileUI.this).getHeight()) && (ExdeviceProfileUI.z(ExdeviceProfileUI.this).getLastVisiblePosition() >= i - 1))
          {
            AppMethodBeat.o(179605);
            return true;
          }
          AppMethodBeat.o(179605);
          return false;
        }
      });
      paramBundle.setAtTopCallBack(new MMPullDownView.d()
      {
        public final boolean bWy()
        {
          AppMethodBeat.i(179606);
          if (ExdeviceProfileUI.z(ExdeviceProfileUI.this).getFirstVisiblePosition() == 0)
          {
            View localView = ExdeviceProfileUI.z(ExdeviceProfileUI.this).getChildAt(ExdeviceProfileUI.z(ExdeviceProfileUI.this).getFirstVisiblePosition());
            if ((localView != null) && (localView.getTop() >= 0))
            {
              AppMethodBeat.o(179606);
              return true;
            }
          }
          AppMethodBeat.o(179606);
          return false;
        }
      });
      paramBundle.setOnBottomLoadDataListener(new MMPullDownView.e()
      {
        public final boolean bWx()
        {
          return true;
        }
      });
      paramBundle.setOnScrollChangedListener(new MMPullDownView.b()
      {
        public final void chO()
        {
          AppMethodBeat.i(179607);
          ExdeviceProfileUI.A(ExdeviceProfileUI.this);
          AppMethodBeat.o(179607);
        }
      });
      localObject1 = new ExdeviceProfileListHeader(this);
      m = com.tencent.mm.plugin.exdevice.k.b.Q(this, getResources().getDimensionPixelSize(2131165316));
      localObject2 = getResources().getDisplayMetrics();
      if (((DisplayMetrics)localObject2).widthPixels <= ((DisplayMetrics)localObject2).heightPixels) {
        break label972;
      }
    }
    label972:
    for (int i = getResources().getDimensionPixelSize(2131165251);; i = getResources().getDimensionPixelSize(2131165252))
    {
      int j = getResources().getDimensionPixelSize(2131165326);
      int k = getResources().getDimensionPixelSize(2131165325);
      localObject2 = getWindowManager().getDefaultDisplay();
      k = ((Display)localObject2).getHeight() / 2 - m - i - j / 2 - k;
      if (((Display)localObject2).getHeight() > 0)
      {
        j = k;
        if (k > 0) {}
      }
      else
      {
        j = getResources().getDimensionPixelSize(2131165310);
      }
      ((ExdeviceProfileListHeader)localObject1).setMinimumHeight(j);
      ((ExdeviceProfileListHeader)localObject1).setMinimumWidth(((Display)localObject2).getWidth());
      ((ExdeviceProfileListHeader)localObject1).setTag(Integer.valueOf(((Display)localObject2).getHeight() / 2 - m - i));
      this.pHI = ((ExdeviceProfileListHeader)localObject1);
      this.pHH.addHeaderView(this.pHI, null, false);
      this.pHL = new a(getContext(), this.mAppName, this.pHg, this.lhM);
      this.pHL.pHf = this;
      this.pHH.setAdapter(this.pHL);
      this.pHH.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(179608);
          ExdeviceProfileUI.A(ExdeviceProfileUI.this);
          AppMethodBeat.o(179608);
        }
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {}
      });
      this.pHF.setUsername(this.lhM);
      this.pHM.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(24104);
          com.tencent.mm.plugin.exdevice.g.a.e.d(ExdeviceProfileUI.this);
          AppMethodBeat.o(24104);
        }
      });
      paramBundle.setCanOverScrool(false);
      paramBundle = new RelativeLayout.LayoutParams(com.tencent.mm.cc.a.ig(this), ((Integer)this.pHI.getTag()).intValue());
      this.pHG.setLayoutParams(paramBundle);
      chJ();
      ad.cgY().a(this);
      az.agi().a(new com.tencent.mm.plugin.exdevice.g.a.i(this.lhM, bs.nullAsNil(this.mAppName), this.pHV), 0);
      try
      {
        this.glT = getResources().getDimensionPixelSize(2131165335);
        if (this.glT <= 0) {
          this.glT = 60;
        }
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.Sport.ExdeviceProfileUI", paramBundle, "", new Object[0]);
          if (this.glT <= 0) {
            this.glT = 60;
          }
        }
      }
      finally
      {
        if (this.glT > 0) {
          break label1031;
        }
        this.glT = 60;
        AppMethodBeat.o(24133);
      }
      com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.Sport.ExdeviceProfileUI", "ap: ellipsizeWidth: %s", new Object[] { Integer.valueOf(this.glT) });
      if (!this.pHg) {
        break label1039;
      }
      paramBundle = getString(2131758580);
      setMMTitle(paramBundle);
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(179626);
          ExdeviceProfileUI.this.finish();
          AppMethodBeat.o(179626);
          return false;
        }
      });
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Sport.ExdeviceProfileUI", "mUsername:" + this.lhM);
      if (u.axw().equals(this.lhM))
      {
        paramBundle = new us();
        paramBundle.dxs.action = 3;
        com.tencent.mm.sdk.b.a.GpY.a(paramBundle, new Executor()
        {
          public final void execute(Runnable paramAnonymousRunnable)
          {
            AppMethodBeat.i(179609);
            com.tencent.e.h.JZN.aS(paramAnonymousRunnable);
            AppMethodBeat.o(179609);
          }
        });
      }
      if (this.pHg)
      {
        if (this.pHW != null) {
          com.tencent.mm.kernel.g.agi().a(this.pHW);
        }
        this.pHW = new com.tencent.mm.plugin.sport.model.d();
        com.tencent.mm.kernel.g.agi().a(1734, this);
        com.tencent.mm.kernel.g.agi().a(this.pHW, 0);
      }
      AppMethodBeat.o(24133);
      return;
      bool = false;
      break;
    }
    label1031:
    label1039:
    paramBundle = this.lhM;
    i = this.glT;
    Object localObject1 = v.wk(paramBundle);
    if ((paramBundle.equalsIgnoreCase((String)localObject1)) && (!bs.isNullOrNil(this.pHB))) {}
    for (paramBundle = com.tencent.mm.pluginsdk.ui.span.k.c(getContext(), this.pHB);; paramBundle = com.tencent.mm.pluginsdk.ui.span.k.c(getContext(), (CharSequence)localObject1))
    {
      localObject1 = TextUtils.ellipsize(paramBundle, this.awy, i, TextUtils.TruncateAt.END);
      com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.Sport.ExdeviceProfileUI", " width: %d, ap: username %s, ellipseize username %s", new Object[] { Integer.valueOf(i), paramBundle, localObject1 });
      paramBundle = com.tencent.mm.pluginsdk.ui.span.k.c(this, getString(2131758584, new Object[] { localObject1 }));
      break;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(24139);
    com.tencent.mm.kernel.g.agi().b(1734, this);
    if (this.pIf != null) {
      az.agi().a(this.pIf);
    }
    this.pIg.dead();
    this.mIsDestroyed = true;
    super.onDestroy();
    ad.cgY().b(this);
    AppMethodBeat.o(24139);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(24136);
    super.onPause();
    AppMethodBeat.o(24136);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(24137);
    super.onResume();
    com.tencent.mm.sdk.platformtools.ac.v("MicroMsg.Sport.ExdeviceProfileUI", "ExdeviceProfileUI: onResume");
    chG();
    chH();
    if (!this.pHg)
    {
      ad.cgR().YX(this.lhM);
      chI();
    }
    AppMethodBeat.o(24137);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(161359);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Sport.ExdeviceProfileUI", "onSceneEnd errType %d errCode %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramn.equals(this.pHW))
    {
      com.tencent.mm.kernel.g.agi().b(1734, this);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = this.pHW.zoY;
        Collections.sort(paramString.ETT, new Comparator() {});
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Sport.ExdeviceProfileUI", "response.Steps %d", new Object[] { Integer.valueOf(paramString.ETT.size()) });
        this.pHR = new ArrayList();
        paramString = paramString.ETT.iterator();
        while (paramString.hasNext())
        {
          paramn = (ddd)paramString.next();
          com.tencent.mm.plugin.sport.a.d locald = new com.tencent.mm.plugin.sport.a.d();
          locald.a(paramn);
          this.pHR.add(locald);
        }
        chN();
      }
    }
    AppMethodBeat.o(161359);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends GestureDetector.SimpleOnGestureListener
  {
    private a() {}
    
    public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(24131);
      if (Math.abs(paramFloat2) < Math.abs(paramFloat1))
      {
        AppMethodBeat.o(24131);
        return true;
      }
      AppMethodBeat.o(24131);
      return false;
    }
    
    public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI
 * JD-Core Version:    0.7.0.1
 */