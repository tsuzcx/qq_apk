package com.tencent.mm.plugin.exdevice.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.GestureDetector;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.nt;
import com.tencent.mm.g.a.ui;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.exdevice.g.a.i;
import com.tencent.mm.plugin.exdevice.model.ac;
import com.tencent.mm.plugin.exdevice.model.ac.a;
import com.tencent.mm.plugin.sport.ui.SportChartView;
import com.tencent.mm.plugin.sport.ui.SportChartView.a;
import com.tencent.mm.protocal.protobuf.amf;
import com.tencent.mm.protocal.protobuf.bat;
import com.tencent.mm.protocal.protobuf.cxr;
import com.tencent.mm.protocal.protobuf.dxc;
import com.tencent.mm.protocal.protobuf.pq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.a;
import com.tencent.mm.ui.base.MMPullDownView.b;
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
import junit.framework.Assert;

public class ExdeviceProfileUI
  extends MMActivity
  implements com.tencent.mm.al.g, com.tencent.mm.plugin.exdevice.g.b.e, c
{
  private static int peP = 0;
  private TextPaint avD;
  private int ghn;
  private GestureDetector hRv;
  private String kGt;
  private String knl;
  private String mAppName;
  private Context mContext;
  private boolean mIsDestroyed;
  private String oXY;
  private List<String> oYA;
  private List<String> oYB;
  private boolean oYk;
  private p pcl;
  private boolean pdV;
  private boolean pdW;
  private int pdX;
  private a peA;
  private View peB;
  private volatile boolean peC;
  private String peD;
  private String peE;
  private List<com.tencent.mm.plugin.sport.a.d> peF;
  private List<com.tencent.mm.plugin.sport.a.d> peG;
  private ArrayList<com.tencent.mm.plugin.exdevice.g.b.a.c> peH;
  private List<amf> peI;
  private int peJ;
  private com.tencent.mm.plugin.exdevice.b.b<i> peK;
  private com.tencent.mm.plugin.sport.model.d peL;
  private n.d peM;
  private com.tencent.mm.plugin.exdevice.b.b<com.tencent.mm.plugin.exdevice.g.a.h> peN;
  private com.tencent.mm.plugin.exdevice.b.b<com.tencent.mm.plugin.exdevice.g.a.g> peO;
  private Runnable peQ;
  private com.tencent.mm.plugin.exdevice.b.b<com.tencent.mm.plugin.exdevice.g.a.g> peR;
  private List<String> peS;
  private com.tencent.mm.plugin.exdevice.b.b<com.tencent.mm.plugin.exdevice.g.a.k> peT;
  private com.tencent.mm.plugin.exdevice.g.a.k peU;
  private com.tencent.mm.sdk.b.c<nt> peV;
  private MMPullDownView.a peW;
  private List<pq> pea;
  private String peq;
  private com.tencent.mm.plugin.exdevice.g.b.a.a per;
  private ArrayList<String> pes;
  private dxc pet;
  private ExdeviceProfileAffectedUserView peu;
  private ImageView pev;
  private ListView pew;
  private ExdeviceProfileListHeader pex;
  private MMSwitchBtn pey;
  private SportChartView pez;
  
  public ExdeviceProfileUI()
  {
    AppMethodBeat.i(24132);
    this.mIsDestroyed = false;
    this.pcl = null;
    this.peK = new com.tencent.mm.plugin.exdevice.b.b() {};
    this.avD = new TextPaint(1);
    this.ghn = 0;
    this.peM = new ExdeviceProfileUI.31(this);
    this.peN = new ExdeviceProfileUI.2(this);
    this.peO = new ExdeviceProfileUI.3(this);
    this.peQ = new ExdeviceProfileUI.15(this);
    this.peR = new com.tencent.mm.plugin.exdevice.b.b() {};
    this.peT = new com.tencent.mm.plugin.exdevice.b.b() {};
    this.peV = new ExdeviceProfileUI.22(this);
    this.peW = new ExdeviceProfileUI.26(this);
    AppMethodBeat.o(24132);
  }
  
  private void caA()
  {
    AppMethodBeat.i(24140);
    String str = u.aqG();
    if (this.peB != null) {
      this.peB.setVisibility(8);
    }
    if ((!bt.isNullOrNil(str)) && (str.equals(this.kGt)))
    {
      if ((this.per != null) && (bt.isNullOrNil(this.per.field_championUrl)) && (this.peB != null)) {
        this.peB.setVisibility(0);
      }
      if (this.pex != null)
      {
        this.pex.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(24107);
            com.tencent.mm.plugin.sport.a.c.lI(18);
            com.tencent.mm.plugin.exdevice.g.a.e.e(ExdeviceProfileUI.this);
            AppMethodBeat.o(24107);
          }
        });
        AppMethodBeat.o(24140);
      }
    }
    else if ((this.per != null) && (!bt.isNullOrNil(this.per.field_championUrl)) && (this.pex != null))
    {
      this.pex.setOnClickListener(new View.OnClickListener()
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
  
  private void caB()
  {
    AppMethodBeat.i(24141);
    if (this.per != null)
    {
      if ((this.knl != this.per.field_championUrl) && ((this.knl == null) || (!this.knl.equals(this.per.field_championUrl))))
      {
        com.tencent.mm.plugin.exdevice.g.a.e.a(this, this.pev, this.per.field_championUrl);
        this.knl = this.per.field_championUrl;
        AppMethodBeat.o(24141);
      }
    }
    else
    {
      this.pev.setImageResource(2131100204);
      this.knl = null;
    }
    AppMethodBeat.o(24141);
  }
  
  private void caE()
  {
    AppMethodBeat.i(161358);
    if (this.pez == null) {
      this.pez = ((SportChartView)findViewById(2131299585));
    }
    if (this.pez == null)
    {
      AppMethodBeat.o(161358);
      return;
    }
    if (this.pey == null) {
      this.pey = ((MMSwitchBtn)findViewById(2131299587));
    }
    HashSet localHashSet = new HashSet();
    final ArrayList localArrayList = new ArrayList();
    Iterator localIterator;
    com.tencent.mm.plugin.sport.a.d locald;
    if (this.peF != null)
    {
      localIterator = this.peF.iterator();
      while (localIterator.hasNext())
      {
        locald = (com.tencent.mm.plugin.sport.a.d)localIterator.next();
        if (localHashSet.add(locald.field_date)) {
          localArrayList.add(locald);
        }
      }
    }
    if (this.peG != null)
    {
      localIterator = this.peG.iterator();
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
      if (this.pdV)
      {
        this.pez.setHasSwitchBtn(true);
        this.pey.setVisibility(0);
        this.pey.setSwitchListener(new MMSwitchBtn.a()
        {
          public final void onStatusChange(boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(179621);
            if (paramAnonymousBoolean) {
              ExdeviceProfileUI.F(ExdeviceProfileUI.this).a(SportChartView.a.ycK);
            }
            for (;;)
            {
              ExdeviceProfileUI.F(ExdeviceProfileUI.this).fQ(localArrayList);
              AppMethodBeat.o(179621);
              return;
              ExdeviceProfileUI.F(ExdeviceProfileUI.this).a(SportChartView.a.ycJ);
            }
          }
        });
      }
      for (;;)
      {
        this.pez.setTodayStep(((com.tencent.mm.plugin.sport.a.d)localArrayList.get(localArrayList.size() - 1)).field_step);
        this.pez.fQ(localArrayList);
        AppMethodBeat.o(161358);
        return;
        this.pez.setHasSwitchBtn(false);
        this.pey.setVisibility(8);
        this.pey.setSwitchListener(null);
        this.pez.a(SportChartView.a.ycJ);
        this.pez.fQ(localArrayList);
      }
    }
    this.pez.setHasSwitchBtn(false);
    this.pey.setVisibility(8);
    this.pez.fQ(null);
    AppMethodBeat.o(161358);
  }
  
  private void cax()
  {
    AppMethodBeat.i(24134);
    this.peH = com.tencent.mm.plugin.exdevice.model.ad.bZI().bZU();
    if (this.peH != null) {
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.Sport.ExdeviceProfileUI", "ap: follow size:%s, %s", new Object[] { Integer.valueOf(this.peH.size()), this.peH.toString() });
    }
    while (!bt.gL(this.peH))
    {
      this.pdX = this.peH.size();
      AppMethodBeat.o(24134);
      return;
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.Sport.ExdeviceProfileUI", "ap: follow is null");
    }
    this.pdX = 0;
    AppMethodBeat.o(24134);
  }
  
  private void cay()
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
        locala.pdW = com.tencent.mm.plugin.exdevice.model.ad.bZI().UL(locala.kGt);
        locala.pdZ = localArrayList;
        if (!bt.gL(localArrayList)) {}
        for (locala.pdX = localArrayList.size();; locala.pdX = 0)
        {
          locala.pea = localList;
          if (!bt.gL(localList)) {
            locala.pdY = localList.size();
          }
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ExdeviceProfileAdapter", "setData,mIsFollower:%s ,mFollowersNum:%s  ,mButtonNum:%s ,mUsername:%s", new Object[] { Boolean.valueOf(locala.pdW), Integer.valueOf(locala.pdX), Integer.valueOf(locala.pdY), locala.kGt });
          ExdeviceProfileUI.l(ExdeviceProfileUI.this).notifyDataSetChanged();
          AppMethodBeat.o(179625);
          return;
        }
      }
    });
    AppMethodBeat.o(24135);
  }
  
  private void caz()
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
  
  public final void b(String paramString, com.tencent.mm.plugin.exdevice.g.b.d paramd)
  {
    AppMethodBeat.i(24143);
    if (("HardDeviceChampionInfo".equals(paramString)) && (this.kGt.equals(paramd.username)))
    {
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.Sport.ExdeviceProfileUI", "hy: url may changed. maybe reload background");
      this.per = com.tencent.mm.plugin.exdevice.model.ad.bZK().UN(this.kGt);
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
  
  public final void caC()
  {
    AppMethodBeat.i(24144);
    runOnUiThread(new ExdeviceProfileUI.19(this));
    if (this.peU != null) {
      az.aeS().a(this.peU);
    }
    this.peU = new com.tencent.mm.plugin.exdevice.g.a.k(this.peT);
    az.aeS().a(this.peU, 0);
    AppMethodBeat.o(24144);
  }
  
  public final void caD()
  {
    AppMethodBeat.i(24145);
    com.tencent.mm.plugin.sport.a.c.lI(17);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.kGt);
    az.aeS().a(new com.tencent.mm.plugin.exdevice.g.a.g(localArrayList, this.peO), 0);
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
            str2 = ac.ev(this);
            if ((str1 != null) && (str1.length() != 0)) {
              break;
            }
            com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Sport.ExdeviceProfileUI", "select conversation failed, toUser is null.");
            AppMethodBeat.o(24142);
            return;
          }
          ac.a(this, str1, str2, paramIntent.getStringExtra("custom_send_text"), this.peE);
          com.tencent.mm.ui.base.h.cf(getContext(), getResources().getString(2131755894));
          AppMethodBeat.o(24142);
          return;
          if (paramInt2 == -1)
          {
            paramIntent = bt.S(paramIntent.getStringExtra("Select_Contact").split(","));
            if (paramIntent == null)
            {
              AppMethodBeat.o(24142);
              return;
            }
            if (this.pcl != null) {
              this.pcl.show();
            }
            az.aeS().a(new com.tencent.mm.plugin.exdevice.g.a.g(paramIntent, this.peR), 0);
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
    cax();
    this.kGt = paramBundle.getStringExtra("username");
    this.peq = paramBundle.getStringExtra("usernickname");
    paramBundle = u.aqG();
    if (paramBundle != null) {
      this.pdV = paramBundle.equals(this.kGt);
    }
    this.mAppName = getIntent().getStringExtra("app_username");
    this.pdW = com.tencent.mm.plugin.exdevice.model.ad.bZI().UL(this.kGt);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.Sport.ExdeviceProfileUI", "is follow %s", new Object[] { Boolean.valueOf(this.pdW) });
    boolean bool;
    int m;
    Object localObject2;
    if (!bt.isNullOrNil(this.kGt))
    {
      bool = true;
      Assert.assertTrue(bool);
      this.per = com.tencent.mm.plugin.exdevice.model.ad.bZK().UN(this.kGt);
      this.pes = getIntent().getStringArrayListExtra("key_affected_semi");
      getString(2131755906);
      this.pcl = com.tencent.mm.ui.base.h.c(this, getString(2131760709), true, new ExdeviceProfileUI.5(this));
      this.peu = ((ExdeviceProfileAffectedUserView)findViewById(2131299542));
      this.pev = ((ImageView)findViewById(2131299545));
      this.pew = ((ListView)findViewById(2131299581));
      paramBundle = (MMPullDownView)findViewById(2131303543);
      this.peu.setAffectedUserInfo(this.pes);
      caB();
      this.peB = findViewById(2131304599);
      this.hRv = new GestureDetector(getContext(), new ExdeviceProfileUI.a(this, (byte)0));
      paramBundle.setIsBottomShowAll(false);
      paramBundle.setTopViewVisible(false);
      paramBundle.setBottomViewVisible(false);
      paramBundle.setIsBottomShowAll(false);
      paramBundle.setIsTopShowAll(false);
      paramBundle.setCanOverScrool(true);
      paramBundle.setOnInterceptTouchEventListener(this.peW);
      paramBundle.setAtBottomCallBack(new ExdeviceProfileUI.6(this));
      paramBundle.setAtTopCallBack(new ExdeviceProfileUI.7(this));
      paramBundle.setOnBottomLoadDataListener(new ExdeviceProfileUI.8(this));
      paramBundle.setOnScrollChangedListener(new MMPullDownView.b()
      {
        public final void caF()
        {
          AppMethodBeat.i(179607);
          ExdeviceProfileUI.A(ExdeviceProfileUI.this);
          AppMethodBeat.o(179607);
        }
      });
      localObject1 = new ExdeviceProfileListHeader(this);
      m = com.tencent.mm.plugin.exdevice.k.b.M(this, getResources().getDimensionPixelSize(2131165316));
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
      this.pex = ((ExdeviceProfileListHeader)localObject1);
      this.pew.addHeaderView(this.pex, null, false);
      this.peA = new a(getContext(), this.mAppName, this.pdV, this.kGt);
      this.peA.pdU = this;
      this.pew.setAdapter(this.peA);
      this.pew.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(179608);
          ExdeviceProfileUI.A(ExdeviceProfileUI.this);
          AppMethodBeat.o(179608);
        }
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {}
      });
      this.peu.setUsername(this.kGt);
      this.peB.setOnClickListener(new ExdeviceProfileUI.11(this));
      paramBundle.setCanOverScrool(false);
      paramBundle = new RelativeLayout.LayoutParams(com.tencent.mm.cd.a.hV(this), ((Integer)this.pex.getTag()).intValue());
      this.pev.setLayoutParams(paramBundle);
      caA();
      com.tencent.mm.plugin.exdevice.model.ad.bZP().a(this);
      az.aeS().a(new i(this.kGt, bt.nullAsNil(this.mAppName), this.peK), 0);
      try
      {
        this.ghn = getResources().getDimensionPixelSize(2131165335);
        if (this.ghn <= 0) {
          this.ghn = 60;
        }
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.Sport.ExdeviceProfileUI", paramBundle, "", new Object[0]);
          if (this.ghn <= 0) {
            this.ghn = 60;
          }
        }
      }
      finally
      {
        if (this.ghn > 0) {
          break label1031;
        }
        this.ghn = 60;
        AppMethodBeat.o(24133);
      }
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.Sport.ExdeviceProfileUI", "ap: ellipsizeWidth: %s", new Object[] { Integer.valueOf(this.ghn) });
      if (!this.pdV) {
        break label1039;
      }
      paramBundle = getString(2131758580);
      setMMTitle(paramBundle);
      setBackBtn(new ExdeviceProfileUI.30(this));
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Sport.ExdeviceProfileUI", "mUsername:" + this.kGt);
      if (u.aqG().equals(this.kGt))
      {
        paramBundle = new ui();
        paramBundle.dzG.action = 3;
        com.tencent.mm.sdk.b.a.ESL.a(paramBundle, new ExdeviceProfileUI.12(this));
      }
      if (this.pdV)
      {
        if (this.peL != null) {
          com.tencent.mm.kernel.g.aeS().a(this.peL);
        }
        this.peL = new com.tencent.mm.plugin.sport.model.d();
        com.tencent.mm.kernel.g.aeS().a(1734, this);
        com.tencent.mm.kernel.g.aeS().a(this.peL, 0);
      }
      AppMethodBeat.o(24133);
      return;
      bool = false;
      break;
    }
    label1031:
    label1039:
    paramBundle = this.kGt;
    i = this.ghn;
    Object localObject1 = v.sh(paramBundle);
    if ((paramBundle.equalsIgnoreCase((String)localObject1)) && (!bt.isNullOrNil(this.peq))) {}
    for (paramBundle = com.tencent.mm.pluginsdk.ui.span.k.c(getContext(), this.peq);; paramBundle = com.tencent.mm.pluginsdk.ui.span.k.c(getContext(), (CharSequence)localObject1))
    {
      localObject1 = TextUtils.ellipsize(paramBundle, this.avD, i, TextUtils.TruncateAt.END);
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.Sport.ExdeviceProfileUI", " width: %d, ap: username %s, ellipseize username %s", new Object[] { Integer.valueOf(i), paramBundle, localObject1 });
      paramBundle = com.tencent.mm.pluginsdk.ui.span.k.c(this, getString(2131758584, new Object[] { localObject1 }));
      break;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(24139);
    com.tencent.mm.kernel.g.aeS().b(1734, this);
    if (this.peU != null) {
      az.aeS().a(this.peU);
    }
    this.peV.dead();
    this.mIsDestroyed = true;
    super.onDestroy();
    com.tencent.mm.plugin.exdevice.model.ad.bZP().b(this);
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
    com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.Sport.ExdeviceProfileUI", "ExdeviceProfileUI: onResume");
    cax();
    cay();
    if (!this.pdV)
    {
      com.tencent.mm.plugin.exdevice.model.ad.bZI().UL(this.kGt);
      caz();
    }
    AppMethodBeat.o(24137);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(161359);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Sport.ExdeviceProfileUI", "onSceneEnd errType %d errCode %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramn.equals(this.peL))
    {
      com.tencent.mm.kernel.g.aeS().b(1734, this);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = this.peL.ybY;
        Collections.sort(paramString.Dyx, new Comparator() {});
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Sport.ExdeviceProfileUI", "response.Steps %d", new Object[] { Integer.valueOf(paramString.Dyx.size()) });
        this.peG = new ArrayList();
        paramString = paramString.Dyx.iterator();
        while (paramString.hasNext())
        {
          paramn = (cxr)paramString.next();
          com.tencent.mm.plugin.sport.a.d locald = new com.tencent.mm.plugin.sport.a.d();
          locald.a(paramn);
          this.peG.add(locald);
        }
        caE();
      }
    }
    AppMethodBeat.o(161359);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI
 * JD-Core Version:    0.7.0.1
 */