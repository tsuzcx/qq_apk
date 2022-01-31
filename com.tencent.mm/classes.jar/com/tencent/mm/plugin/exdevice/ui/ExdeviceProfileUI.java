package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.GestureDetector;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.h.a.lr;
import com.tencent.mm.h.a.rb;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.exdevice.f.a.i;
import com.tencent.mm.plugin.exdevice.f.a.k;
import com.tencent.mm.plugin.exdevice.model.ac;
import com.tencent.mm.plugin.exdevice.model.ac.a;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.sport.ui.SportChartView;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.c.cnt;
import com.tencent.mm.protocal.c.kz;
import com.tencent.mm.protocal.c.zh;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.a;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.s;
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
  private static int jEE = 0;
  private boolean OV = false;
  private int dOA = 0;
  private String gDJ;
  private TextPaint gI = new TextPaint(1);
  private String hcm;
  private com.tencent.mm.ui.base.p jCc = null;
  private boolean jDM;
  private boolean jDN;
  private int jDO;
  private List<kz> jDR;
  private com.tencent.mm.plugin.exdevice.a.b<i> jEA = new com.tencent.mm.plugin.exdevice.a.b() {};
  private n.d jEB = new ExdeviceProfileUI.29(this);
  private com.tencent.mm.plugin.exdevice.a.b<com.tencent.mm.plugin.exdevice.f.a.h> jEC = new ExdeviceProfileUI.31(this);
  private com.tencent.mm.plugin.exdevice.a.b<com.tencent.mm.plugin.exdevice.f.a.g> jED = new ExdeviceProfileUI.2(this);
  private Runnable jEF = new ExdeviceProfileUI.14(this);
  private com.tencent.mm.plugin.exdevice.a.b<com.tencent.mm.plugin.exdevice.f.a.g> jEG = new ExdeviceProfileUI.15(this);
  private List<String> jEH;
  private com.tencent.mm.plugin.exdevice.a.b<k> jEI = new ExdeviceProfileUI.17(this);
  private com.tencent.mm.sdk.b.c<lr> jEJ = new ExdeviceProfileUI.21(this);
  private GestureDetector jEK;
  private MMPullDownView.a jEL = new ExdeviceProfileUI.25(this);
  private String jEh;
  private com.tencent.mm.plugin.exdevice.f.b.a.a jEi;
  private ArrayList<String> jEj;
  private cnt jEk;
  private ExdeviceProfileAffectedUserView jEl;
  private ImageView jEm;
  private ListView jEn;
  private ExdeviceProfileListHeader jEo;
  private MMSwitchBtn jEp;
  private SportChartView jEq;
  private a jEr;
  private View jEs;
  private volatile boolean jEt;
  private String jEu;
  private String jEv;
  private List<com.tencent.mm.plugin.sport.b.e> jEw;
  private ArrayList<com.tencent.mm.plugin.exdevice.f.b.a.c> jEx;
  private List<zh> jEy;
  private int jEz;
  private String jxO;
  private boolean jyb;
  private List<String> jyr;
  private List<String> jys;
  private String mAppName;
  private Context mContext;
  
  private void aMB()
  {
    this.jEx = ad.aLN().aLZ();
    if (this.jEx != null) {
      y.d("MicroMsg.Sport.ExdeviceProfileUI", "ap: follow size:%s, %s", new Object[] { Integer.valueOf(this.jEx.size()), this.jEx.toString() });
    }
    while (!bk.dk(this.jEx))
    {
      this.jDO = this.jEx.size();
      return;
      y.d("MicroMsg.Sport.ExdeviceProfileUI", "ap: follow is null");
    }
    this.jDO = 0;
  }
  
  private void aMC()
  {
    runOnUiThread(new ExdeviceProfileUI.27(this));
  }
  
  private void aMD()
  {
    runOnUiThread(new ExdeviceProfileUI.3(this));
  }
  
  private void aME()
  {
    String str = q.Gj();
    if (this.jEs != null) {
      this.jEs.setVisibility(8);
    }
    if ((!bk.bl(str)) && (str.equals(this.hcm)))
    {
      if ((this.jEi != null) && (bk.bl(this.jEi.field_championUrl)) && (this.jEs != null)) {
        this.jEs.setVisibility(0);
      }
      if (this.jEo != null) {
        this.jEo.setOnClickListener(new ExdeviceProfileUI.11(this));
      }
    }
    while ((this.jEi == null) || (bk.bl(this.jEi.field_championUrl)) || (this.jEo == null)) {
      return;
    }
    this.jEo.setOnClickListener(new ExdeviceProfileUI.13(this));
  }
  
  private void aMF()
  {
    if (this.jEi != null)
    {
      if ((this.gDJ != this.jEi.field_championUrl) && ((this.gDJ == null) || (!this.gDJ.equals(this.jEi.field_championUrl))))
      {
        com.tencent.mm.plugin.exdevice.f.a.e.a(this, this.jEm, this.jEi.field_championUrl, R.e.darkgrey);
        this.gDJ = this.jEi.field_championUrl;
      }
      return;
    }
    this.jEm.setImageResource(R.e.darkgrey);
    this.gDJ = null;
  }
  
  private void y(long paramLong1, long paramLong2)
  {
    Object localObject1 = ((com.tencent.mm.plugin.sport.b.b)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.sport.b.b.class)).I(paramLong1, paramLong2);
    HashSet localHashSet = new HashSet();
    ArrayList localArrayList = new ArrayList();
    Object localObject2;
    if (this.jEw != null)
    {
      localObject2 = this.jEw.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        com.tencent.mm.plugin.sport.b.e locale = (com.tencent.mm.plugin.sport.b.e)((Iterator)localObject2).next();
        if (localHashSet.add(locale.field_date)) {
          localArrayList.add(locale);
        }
      }
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (com.tencent.mm.plugin.sport.b.e)((Iterator)localObject1).next();
      if (localHashSet.add(((com.tencent.mm.plugin.sport.b.e)localObject2).field_date)) {
        localArrayList.add(localObject2);
      }
    }
    Collections.sort(localArrayList);
    this.jEw = localArrayList;
    this.jEq.cN(this.jEw);
  }
  
  public final void aMG()
  {
    runOnUiThread(new ExdeviceProfileUI.18(this));
    au.Dk().a(new k(this.jEI), 0);
  }
  
  public final void aMH()
  {
    com.tencent.mm.plugin.sport.b.d.jdMethod_if(17);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.hcm);
    au.Dk().a(new com.tencent.mm.plugin.exdevice.f.a.g(localArrayList, this.jED), 0);
  }
  
  public final void b(String paramString, com.tencent.mm.plugin.exdevice.f.b.d paramd)
  {
    if (("HardDeviceChampionInfo".equals(paramString)) && (this.hcm.equals(paramd.username)))
    {
      y.d("MicroMsg.Sport.ExdeviceProfileUI", "hy: url may changed. maybe reload background");
      this.jEi = ad.aLP().BC(this.hcm);
      runOnUiThread(new ExdeviceProfileUI.16(this));
    }
  }
  
  protected final int getLayoutId()
  {
    return R.i.exdevice_profile_ui;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (com.tencent.mm.plugin.exdevice.f.a.e.a(this, paramInt1, paramInt2, paramIntent, this.mAppName)) {}
    label119:
    do
    {
      do
      {
        do
        {
          return;
          switch (paramInt1)
          {
          default: 
            return;
          }
        } while (paramInt2 != -1);
        if (paramIntent == null) {}
        String str2;
        for (String str1 = null;; str1 = paramIntent.getStringExtra("Select_Conv_User"))
        {
          str2 = ac.cZ(this);
          if ((str1 != null) && (str1.length() != 0)) {
            break label119;
          }
          y.e("MicroMsg.Sport.ExdeviceProfileUI", "select conversation failed, toUser is null.");
          return;
          if (paramInt2 != -1) {
            break;
          }
          Toast.makeText(this, R.l.share_ok, 1).show();
          return;
        }
        ac.a(this, str1, str2, paramIntent.getStringExtra("custom_send_text"), this.jEv);
        com.tencent.mm.ui.base.h.bC(this.mController.uMN, getResources().getString(R.l.app_shared));
        return;
      } while (paramInt2 != -1);
      paramIntent = bk.G(paramIntent.getStringExtra("Select_Contact").split(","));
    } while (paramIntent == null);
    if (this.jCc != null) {
      this.jCc.show();
    }
    au.Dk().a(new com.tencent.mm.plugin.exdevice.f.a.g(paramIntent, this.jEG), 0);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mContext = this.mController.uMN;
    paramBundle = getIntent();
    aMB();
    this.hcm = paramBundle.getStringExtra("username");
    this.jEh = paramBundle.getStringExtra("usernickname");
    paramBundle = q.Gj();
    if (paramBundle != null) {
      this.jDM = paramBundle.equals(this.hcm);
    }
    this.mAppName = getIntent().getStringExtra("app_username");
    this.jDN = ad.aLN().BA(this.hcm);
    y.d("MicroMsg.Sport.ExdeviceProfileUI", "is follow %s", new Object[] { Boolean.valueOf(this.jDN) });
    boolean bool;
    int m;
    Object localObject2;
    if (!bk.bl(this.hcm))
    {
      bool = true;
      Assert.assertTrue(bool);
      this.jEi = ad.aLP().BC(this.hcm);
      this.jEj = getIntent().getStringArrayListExtra("key_affected_semi");
      getString(R.l.app_tip);
      this.jCc = com.tencent.mm.ui.base.h.b(this, getString(R.l.loading_tips), new ExdeviceProfileUI.4(this));
      this.jEl = ((ExdeviceProfileAffectedUserView)findViewById(R.h.exdevice_affected_view));
      this.jEm = ((ImageView)findViewById(R.h.exdevice_bg_iv));
      this.jEn = ((ListView)findViewById(R.h.exdevice_profile_lv));
      paramBundle = (MMPullDownView)findViewById(R.h.pull_down_view);
      this.jEl.setAffectedUserInfo(this.jEj);
      aMF();
      this.jEs = findViewById(R.h.setCoverV);
      this.jEK = new GestureDetector(this.mController.uMN, new ExdeviceProfileUI.a(this, (byte)0));
      paramBundle.setIsBottomShowAll(false);
      paramBundle.setTopViewVisible(false);
      paramBundle.setBottomViewVisible(false);
      paramBundle.setIsBottomShowAll(false);
      paramBundle.setIsTopShowAll(false);
      paramBundle.setCanOverScrool(true);
      paramBundle.setOnInterceptTouchEventListener(this.jEL);
      paramBundle.setAtBottomCallBack(new ExdeviceProfileUI.5(this));
      paramBundle.setAtTopCallBack(new ExdeviceProfileUI.6(this));
      paramBundle.setOnBottomLoadDataListener(new ExdeviceProfileUI.7(this));
      paramBundle.setOnScrollChangedListener(new ExdeviceProfileUI.8(this));
      localObject1 = new ExdeviceProfileListHeader(this);
      m = com.tencent.mm.plugin.exdevice.j.b.A(this, getResources().getDimensionPixelSize(R.f.ExdeviceDefaultStatusBarHeight));
      localObject2 = getResources().getDisplayMetrics();
      if (((DisplayMetrics)localObject2).widthPixels <= ((DisplayMetrics)localObject2).heightPixels) {
        break label906;
      }
    }
    label906:
    for (int i = getResources().getDimensionPixelSize(R.f.DefaultActionbarHeightLand);; i = getResources().getDimensionPixelSize(R.f.DefaultActionbarHeightPort))
    {
      j = getResources().getDimensionPixelSize(R.f.ExdeviceProfileAvatarSize);
      int k = getResources().getDimensionPixelSize(R.f.ExdeviceProfileAvatarRoundStrokeWidth);
      localObject2 = getWindowManager().getDefaultDisplay();
      k = ((Display)localObject2).getHeight() / 2 - m - i - j / 2 - k;
      if (((Display)localObject2).getHeight() > 0)
      {
        j = k;
        if (k > 0) {}
      }
      else
      {
        j = getResources().getDimensionPixelSize(R.f.ExdeviceChangeCoverClickAreaHeight);
      }
      ((ExdeviceProfileListHeader)localObject1).setMinimumHeight(j);
      ((ExdeviceProfileListHeader)localObject1).setMinimumWidth(((Display)localObject2).getWidth());
      ((ExdeviceProfileListHeader)localObject1).setTag(Integer.valueOf(((Display)localObject2).getHeight() / 2 - m - i));
      this.jEo = ((ExdeviceProfileListHeader)localObject1);
      this.jEn.addHeaderView(this.jEo, null, false);
      this.jEr = new a(this.mController.uMN, this.mAppName, this.jDM, this.hcm);
      this.jEr.jDL = this;
      this.jEn.setAdapter(this.jEr);
      this.jEn.setOnScrollListener(new ExdeviceProfileUI.9(this));
      this.jEl.setUsername(this.hcm);
      this.jEs.setOnClickListener(new ExdeviceProfileUI.10(this));
      paramBundle.setCanOverScrool(false);
      paramBundle = new RelativeLayout.LayoutParams(com.tencent.mm.cb.a.fj(this), ((Integer)this.jEo.getTag()).intValue());
      this.jEm.setLayoutParams(paramBundle);
      aME();
      ad.aLU().a(this);
      au.Dk().a(new i(this.hcm, bk.pm(this.mAppName), this.jEA), 0);
      try
      {
        this.dOA = getResources().getDimensionPixelSize(R.f.ExdeviceUserNameWidth);
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.Sport.ExdeviceProfileUI", paramBundle, "", new Object[0]);
          if (this.dOA <= 0) {
            this.dOA = 60;
          }
        }
      }
      finally
      {
        if (this.dOA > 0) {
          break label965;
        }
        this.dOA = 60;
      }
      y.d("MicroMsg.Sport.ExdeviceProfileUI", "ap: ellipsizeWidth: %s", new Object[] { Integer.valueOf(this.dOA) });
      if (!this.jDM) {
        break label967;
      }
      paramBundle = getString(R.l.exdevice_profile_my_title);
      N(paramBundle);
      setBackBtn(new ExdeviceProfileUI.28(this));
      y.i("MicroMsg.Sport.ExdeviceProfileUI", "mUsername:" + this.hcm);
      if (q.Gj().equals(this.hcm))
      {
        paramBundle = new rb();
        paramBundle.cap.action = 3;
        com.tencent.mm.sdk.b.a.udP.a(paramBundle, Looper.getMainLooper());
      }
      return;
      bool = false;
      break;
    }
    label965:
    label967:
    i = R.l.exdevice_profile_title;
    paramBundle = this.hcm;
    int j = this.dOA;
    Object localObject1 = r.gV(paramBundle);
    if ((paramBundle.equalsIgnoreCase((String)localObject1)) && (!bk.bl(this.jEh))) {}
    for (paramBundle = j.b(this.mController.uMN, this.jEh);; paramBundle = j.b(this.mController.uMN, (CharSequence)localObject1))
    {
      localObject1 = TextUtils.ellipsize(paramBundle, this.gI, j, TextUtils.TruncateAt.END);
      y.d("MicroMsg.Sport.ExdeviceProfileUI", " width: %d, ap: username %s, ellipseize username %s", new Object[] { Integer.valueOf(j), paramBundle, localObject1 });
      paramBundle = j.b(this, getString(i, new Object[] { localObject1 }));
      break;
    }
  }
  
  protected void onDestroy()
  {
    this.jEJ.dead();
    this.OV = true;
    super.onDestroy();
    ad.aLU().b(this);
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    y.v("MicroMsg.Sport.ExdeviceProfileUI", "ExdeviceProfileUI: onResume");
    aMB();
    aMC();
    if (!this.jDM)
    {
      ad.aLN().BA(this.hcm);
      aMD();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI
 * JD-Core Version:    0.7.0.1
 */