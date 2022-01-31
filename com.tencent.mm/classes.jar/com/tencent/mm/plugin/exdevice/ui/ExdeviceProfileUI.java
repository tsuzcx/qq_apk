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
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mh;
import com.tencent.mm.g.a.sn;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.exdevice.f.a.i;
import com.tencent.mm.plugin.exdevice.f.a.k;
import com.tencent.mm.plugin.exdevice.model.ac;
import com.tencent.mm.plugin.exdevice.model.ac.a;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.sport.ui.SportChartView;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.protobuf.adu;
import com.tencent.mm.protocal.protobuf.dcb;
import com.tencent.mm.protocal.protobuf.nl;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.a;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;

public class ExdeviceProfileUI
  extends MMActivity
  implements com.tencent.mm.plugin.exdevice.f.b.e, c
{
  private static int lOc = 0;
  private boolean OZ;
  private int eMi;
  private TextPaint hB;
  private String icM;
  private String ikj;
  private boolean lHA;
  private List<String> lHQ;
  private List<String> lHR;
  private String lHn;
  private com.tencent.mm.ui.base.p lLB;
  private String lNF;
  private com.tencent.mm.plugin.exdevice.f.b.a.a lNG;
  private ArrayList<String> lNH;
  private dcb lNI;
  private ExdeviceProfileAffectedUserView lNJ;
  private ImageView lNK;
  private ListView lNL;
  private ExdeviceProfileListHeader lNM;
  private MMSwitchBtn lNN;
  private SportChartView lNO;
  private a lNP;
  private View lNQ;
  private volatile boolean lNR;
  private String lNS;
  private String lNT;
  private List<com.tencent.mm.plugin.sport.a.e> lNU;
  private ArrayList<com.tencent.mm.plugin.exdevice.f.b.a.c> lNV;
  private List<adu> lNW;
  private int lNX;
  private com.tencent.mm.plugin.exdevice.a.b<i> lNY;
  private n.d lNZ;
  private boolean lNk;
  private boolean lNl;
  private int lNm;
  private List<nl> lNp;
  private com.tencent.mm.plugin.exdevice.a.b<com.tencent.mm.plugin.exdevice.f.a.h> lOa;
  private com.tencent.mm.plugin.exdevice.a.b<com.tencent.mm.plugin.exdevice.f.a.g> lOb;
  private Runnable lOd;
  private com.tencent.mm.plugin.exdevice.a.b<com.tencent.mm.plugin.exdevice.f.a.g> lOe;
  private List<String> lOf;
  private com.tencent.mm.plugin.exdevice.a.b<k> lOg;
  private k lOh;
  private com.tencent.mm.sdk.b.c<mh> lOi;
  private GestureDetector lOj;
  private MMPullDownView.a lOk;
  private String mAppName;
  private Context mContext;
  
  public ExdeviceProfileUI()
  {
    AppMethodBeat.i(20061);
    this.OZ = false;
    this.lLB = null;
    this.lNY = new com.tencent.mm.plugin.exdevice.a.b() {};
    this.hB = new TextPaint(1);
    this.eMi = 0;
    this.lNZ = new ExdeviceProfileUI.29(this);
    this.lOa = new ExdeviceProfileUI.31(this);
    this.lOb = new ExdeviceProfileUI.2(this);
    this.lOd = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(20036);
        BackwardSupportUtil.c.a(ExdeviceProfileUI.z(ExdeviceProfileUI.this));
        if (ExdeviceProfileUI.z(ExdeviceProfileUI.this).getCount() > 0) {
          BackwardSupportUtil.c.b(ExdeviceProfileUI.z(ExdeviceProfileUI.this), ExdeviceProfileUI.z(ExdeviceProfileUI.this).getCount() - 1);
        }
        AppMethodBeat.o(20036);
      }
    };
    this.lOe = new ExdeviceProfileUI.15(this);
    this.lOg = new ExdeviceProfileUI.17(this);
    this.lOi = new ExdeviceProfileUI.21(this);
    this.lOk = new MMPullDownView.a()
    {
      public final boolean onInterceptTouchEvent(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(20051);
        boolean bool = ExdeviceProfileUI.H(ExdeviceProfileUI.this).onTouchEvent(paramAnonymousMotionEvent);
        AppMethodBeat.o(20051);
        return bool;
      }
    };
    AppMethodBeat.o(20061);
  }
  
  private void K(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(20075);
    Object localObject1 = ((com.tencent.mm.plugin.sport.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.sport.a.b.class)).X(paramLong1, paramLong2);
    HashSet localHashSet = new HashSet();
    ArrayList localArrayList = new ArrayList();
    Object localObject2;
    if (this.lNU != null)
    {
      localObject2 = this.lNU.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        com.tencent.mm.plugin.sport.a.e locale = (com.tencent.mm.plugin.sport.a.e)((Iterator)localObject2).next();
        if (localHashSet.add(locale.field_date)) {
          localArrayList.add(locale);
        }
      }
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (com.tencent.mm.plugin.sport.a.e)((Iterator)localObject1).next();
      if (localHashSet.add(((com.tencent.mm.plugin.sport.a.e)localObject2).field_date)) {
        localArrayList.add(localObject2);
      }
    }
    Collections.sort(localArrayList);
    this.lNU = localArrayList;
    if (this.lNO != null) {
      this.lNO.dz(this.lNU);
    }
    AppMethodBeat.o(20075);
  }
  
  private void bqP()
  {
    AppMethodBeat.i(20063);
    this.lNV = ad.bqa().bqm();
    if (this.lNV != null) {
      ab.d("MicroMsg.Sport.ExdeviceProfileUI", "ap: follow size:%s, %s", new Object[] { Integer.valueOf(this.lNV.size()), this.lNV.toString() });
    }
    while (!bo.es(this.lNV))
    {
      this.lNm = this.lNV.size();
      AppMethodBeat.o(20063);
      return;
      ab.d("MicroMsg.Sport.ExdeviceProfileUI", "ap: follow is null");
    }
    this.lNm = 0;
    AppMethodBeat.o(20063);
  }
  
  private void bqQ()
  {
    AppMethodBeat.i(20064);
    runOnUiThread(new ExdeviceProfileUI.27(this));
    AppMethodBeat.o(20064);
  }
  
  private void bqR()
  {
    AppMethodBeat.i(20067);
    runOnUiThread(new ExdeviceProfileUI.3(this));
    AppMethodBeat.o(20067);
  }
  
  private void bqS()
  {
    AppMethodBeat.i(20069);
    String str = r.Zn();
    if (this.lNQ != null) {
      this.lNQ.setVisibility(8);
    }
    if ((!bo.isNullOrNil(str)) && (str.equals(this.ikj)))
    {
      if ((this.lNG != null) && (bo.isNullOrNil(this.lNG.field_championUrl)) && (this.lNQ != null)) {
        this.lNQ.setVisibility(0);
      }
      if (this.lNM != null)
      {
        this.lNM.setOnClickListener(new ExdeviceProfileUI.11(this));
        AppMethodBeat.o(20069);
      }
    }
    else if ((this.lNG != null) && (!bo.isNullOrNil(this.lNG.field_championUrl)) && (this.lNM != null))
    {
      this.lNM.setOnClickListener(new ExdeviceProfileUI.13(this));
    }
    AppMethodBeat.o(20069);
  }
  
  private void bqT()
  {
    AppMethodBeat.i(20070);
    if (this.lNG != null)
    {
      if ((this.icM != this.lNG.field_championUrl) && ((this.icM == null) || (!this.icM.equals(this.lNG.field_championUrl))))
      {
        com.tencent.mm.plugin.exdevice.f.a.e.a(this, this.lNK, this.lNG.field_championUrl);
        this.icM = this.lNG.field_championUrl;
        AppMethodBeat.o(20070);
      }
    }
    else
    {
      this.lNK.setImageResource(2131689922);
      this.icM = null;
    }
    AppMethodBeat.o(20070);
  }
  
  public final void b(String paramString, com.tencent.mm.plugin.exdevice.f.b.d paramd)
  {
    AppMethodBeat.i(20072);
    if (("HardDeviceChampionInfo".equals(paramString)) && (this.ikj.equals(paramd.username)))
    {
      ab.d("MicroMsg.Sport.ExdeviceProfileUI", "hy: url may changed. maybe reload background");
      this.lNG = ad.bqc().LE(this.ikj);
      runOnUiThread(new ExdeviceProfileUI.16(this));
    }
    AppMethodBeat.o(20072);
  }
  
  public final void bqU()
  {
    AppMethodBeat.i(20073);
    runOnUiThread(new ExdeviceProfileUI.18(this));
    if (this.lOh != null) {
      aw.Rc().a(this.lOh);
    }
    this.lOh = new k(this.lOg);
    aw.Rc().a(this.lOh, 0);
    AppMethodBeat.o(20073);
  }
  
  public final void bqV()
  {
    AppMethodBeat.i(20074);
    com.tencent.mm.plugin.sport.a.d.kS(17);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.ikj);
    aw.Rc().a(new com.tencent.mm.plugin.exdevice.f.a.g(localArrayList, this.lOb), 0);
    AppMethodBeat.o(20074);
  }
  
  public int getLayoutId()
  {
    return 2130969466;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(20071);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (com.tencent.mm.plugin.exdevice.f.a.e.a(this, paramInt1, paramInt2, paramIntent, this.mAppName))
    {
      AppMethodBeat.o(20071);
      return;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(20071);
      return;
      if (paramInt2 == -1)
      {
        Toast.makeText(this, 2131303664, 1).show();
        AppMethodBeat.o(20071);
        return;
        if (paramInt2 == -1)
        {
          if (paramIntent == null) {}
          String str2;
          for (String str1 = null;; str1 = paramIntent.getStringExtra("Select_Conv_User"))
          {
            str2 = ac.dL(this);
            if ((str1 != null) && (str1.length() != 0)) {
              break;
            }
            ab.e("MicroMsg.Sport.ExdeviceProfileUI", "select conversation failed, toUser is null.");
            AppMethodBeat.o(20071);
            return;
          }
          ac.a(this, str1, str2, paramIntent.getStringExtra("custom_send_text"), this.lNT);
          com.tencent.mm.ui.base.h.bO(getContext(), getResources().getString(2131297076));
          AppMethodBeat.o(20071);
          return;
          if (paramInt2 == -1)
          {
            paramIntent = bo.P(paramIntent.getStringExtra("Select_Contact").split(","));
            if (paramIntent == null)
            {
              AppMethodBeat.o(20071);
              return;
            }
            if (this.lLB != null) {
              this.lLB.show();
            }
            aw.Rc().a(new com.tencent.mm.plugin.exdevice.f.a.g(paramIntent, this.lOe), 0);
          }
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(20062);
    super.onCreate(paramBundle);
    this.mContext = getContext();
    paramBundle = getIntent();
    bqP();
    this.ikj = paramBundle.getStringExtra("username");
    this.lNF = paramBundle.getStringExtra("usernickname");
    paramBundle = r.Zn();
    if (paramBundle != null) {
      this.lNk = paramBundle.equals(this.ikj);
    }
    this.mAppName = getIntent().getStringExtra("app_username");
    this.lNl = ad.bqa().LC(this.ikj);
    ab.d("MicroMsg.Sport.ExdeviceProfileUI", "is follow %s", new Object[] { Boolean.valueOf(this.lNl) });
    boolean bool;
    int m;
    Object localObject2;
    if (!bo.isNullOrNil(this.ikj))
    {
      bool = true;
      Assert.assertTrue(bool);
      this.lNG = ad.bqc().LE(this.ikj);
      this.lNH = getIntent().getStringArrayListExtra("key_affected_semi");
      getString(2131297087);
      this.lLB = com.tencent.mm.ui.base.h.b(this, getString(2131301086), new ExdeviceProfileUI.4(this));
      this.lNJ = ((ExdeviceProfileAffectedUserView)findViewById(2131823819));
      this.lNK = ((ImageView)findViewById(2131823816));
      this.lNL = ((ListView)findViewById(2131823818));
      paramBundle = (MMPullDownView)findViewById(2131823243);
      this.lNJ.setAffectedUserInfo(this.lNH);
      bqT();
      this.lNQ = findViewById(2131823817);
      this.lOj = new GestureDetector(getContext(), new ExdeviceProfileUI.a(this, (byte)0));
      paramBundle.setIsBottomShowAll(false);
      paramBundle.setTopViewVisible(false);
      paramBundle.setBottomViewVisible(false);
      paramBundle.setIsBottomShowAll(false);
      paramBundle.setIsTopShowAll(false);
      paramBundle.setCanOverScrool(true);
      paramBundle.setOnInterceptTouchEventListener(this.lOk);
      paramBundle.setAtBottomCallBack(new ExdeviceProfileUI.5(this));
      paramBundle.setAtTopCallBack(new ExdeviceProfileUI.6(this));
      paramBundle.setOnBottomLoadDataListener(new ExdeviceProfileUI.7(this));
      paramBundle.setOnScrollChangedListener(new ExdeviceProfileUI.8(this));
      localObject1 = new ExdeviceProfileListHeader(this);
      m = com.tencent.mm.plugin.exdevice.j.b.K(this, getResources().getDimensionPixelSize(2131427611));
      localObject2 = getResources().getDisplayMetrics();
      if (((DisplayMetrics)localObject2).widthPixels <= ((DisplayMetrics)localObject2).heightPixels) {
        break label914;
      }
    }
    label914:
    for (int i = getResources().getDimensionPixelSize(2131427558);; i = getResources().getDimensionPixelSize(2131427559))
    {
      int j = getResources().getDimensionPixelSize(2131427621);
      int k = getResources().getDimensionPixelSize(2131427620);
      localObject2 = getWindowManager().getDefaultDisplay();
      k = ((Display)localObject2).getHeight() / 2 - m - i - j / 2 - k;
      if (((Display)localObject2).getHeight() > 0)
      {
        j = k;
        if (k > 0) {}
      }
      else
      {
        j = getResources().getDimensionPixelSize(2131427605);
      }
      ((ExdeviceProfileListHeader)localObject1).setMinimumHeight(j);
      ((ExdeviceProfileListHeader)localObject1).setMinimumWidth(((Display)localObject2).getWidth());
      ((ExdeviceProfileListHeader)localObject1).setTag(Integer.valueOf(((Display)localObject2).getHeight() / 2 - m - i));
      this.lNM = ((ExdeviceProfileListHeader)localObject1);
      this.lNL.addHeaderView(this.lNM, null, false);
      this.lNP = new a(getContext(), this.mAppName, this.lNk, this.ikj);
      this.lNP.lNj = this;
      this.lNL.setAdapter(this.lNP);
      this.lNL.setOnScrollListener(new ExdeviceProfileUI.9(this));
      this.lNJ.setUsername(this.ikj);
      this.lNQ.setOnClickListener(new ExdeviceProfileUI.10(this));
      paramBundle.setCanOverScrool(false);
      paramBundle = new RelativeLayout.LayoutParams(com.tencent.mm.cb.a.gw(this), ((Integer)this.lNM.getTag()).intValue());
      this.lNK.setLayoutParams(paramBundle);
      bqS();
      ad.bqh().a(this);
      aw.Rc().a(new i(this.ikj, bo.nullAsNil(this.mAppName), this.lNY), 0);
      try
      {
        this.eMi = getResources().getDimensionPixelSize(2131427630);
        if (this.eMi <= 0) {
          this.eMi = 60;
        }
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.Sport.ExdeviceProfileUI", paramBundle, "", new Object[0]);
          if (this.eMi <= 0) {
            this.eMi = 60;
          }
        }
      }
      finally
      {
        if (this.eMi > 0) {
          break label973;
        }
        this.eMi = 60;
        AppMethodBeat.o(20062);
      }
      ab.d("MicroMsg.Sport.ExdeviceProfileUI", "ap: ellipsizeWidth: %s", new Object[] { Integer.valueOf(this.eMi) });
      if (!this.lNk) {
        break label981;
      }
      paramBundle = getString(2131299450);
      setMMTitle(paramBundle);
      setBackBtn(new ExdeviceProfileUI.28(this));
      ab.i("MicroMsg.Sport.ExdeviceProfileUI", "mUsername:" + this.ikj);
      if (r.Zn().equals(this.ikj))
      {
        paramBundle = new sn();
        paramBundle.cIP.action = 3;
        com.tencent.mm.sdk.b.a.ymk.a(paramBundle, com.tencent.mm.sdk.g.d.ysm.cjN());
      }
      AppMethodBeat.o(20062);
      return;
      bool = false;
      break;
    }
    label973:
    label981:
    paramBundle = this.ikj;
    i = this.eMi;
    Object localObject1 = s.nE(paramBundle);
    if ((paramBundle.equalsIgnoreCase((String)localObject1)) && (!bo.isNullOrNil(this.lNF))) {}
    for (paramBundle = j.b(getContext(), this.lNF);; paramBundle = j.b(getContext(), (CharSequence)localObject1))
    {
      localObject1 = TextUtils.ellipsize(paramBundle, this.hB, i, TextUtils.TruncateAt.END);
      ab.d("MicroMsg.Sport.ExdeviceProfileUI", " width: %d, ap: username %s, ellipseize username %s", new Object[] { Integer.valueOf(i), paramBundle, localObject1 });
      paramBundle = j.b(this, getString(2131299454, new Object[] { localObject1 }));
      break;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(20068);
    if (this.lOh != null) {
      aw.Rc().a(this.lOh);
    }
    this.lOi.dead();
    this.OZ = true;
    super.onDestroy();
    ad.bqh().b(this);
    AppMethodBeat.o(20068);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(20065);
    super.onPause();
    AppMethodBeat.o(20065);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(20066);
    super.onResume();
    ab.v("MicroMsg.Sport.ExdeviceProfileUI", "ExdeviceProfileUI: onResume");
    bqP();
    bqQ();
    if (!this.lNk)
    {
      ad.bqa().LC(this.ikj);
      bqR();
    }
    AppMethodBeat.o(20066);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI
 * JD-Core Version:    0.7.0.1
 */