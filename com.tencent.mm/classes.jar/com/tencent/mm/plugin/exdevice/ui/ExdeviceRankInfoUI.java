package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
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
import com.tencent.mm.h.a.pe;
import com.tencent.mm.h.a.rb;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.exdevice.f.a.j;
import com.tencent.mm.plugin.exdevice.f.a.j.a;
import com.tencent.mm.plugin.exdevice.model.ac;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.messenger.a.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public class ExdeviceRankInfoUI
  extends MMActivity
  implements j.a, com.tencent.mm.plugin.exdevice.f.b.e, com.tencent.mm.plugin.exdevice.f.b.f, d
{
  private static int jEE = 128;
  private boolean OV;
  private String gDJ;
  private String hcm;
  private com.tencent.mm.ui.base.p jCc = null;
  private Map<String, String> jEX = new HashMap();
  private ImageView jEm;
  private View jEs;
  private String jEu;
  private String jEv;
  private View jFA;
  private ExdeviceRankListHeaderView jFB;
  private ExdeviceRankChampionInfoView jFC;
  private View jFD;
  private String jFE;
  private String jFF;
  private String jFG;
  private String jFH;
  private com.tencent.mm.plugin.exdevice.f.b.a.a jFI;
  private String jFJ;
  private int jFK;
  private List<e> jFL;
  private ArrayList<com.tencent.mm.plugin.exdevice.f.b.a.c> jFM;
  private ArrayList<com.tencent.mm.plugin.exdevice.f.b.a.d> jFN;
  private boolean jFO;
  private boolean jFP;
  private String jFQ;
  private boolean jFR;
  private j jFS;
  private com.tencent.mm.plugin.exdevice.a.b<j> jFT = new ExdeviceRankInfoUI.12(this);
  private int jFU;
  private ListView jFy;
  private b jFz;
  private boolean jyb;
  public boolean jyn;
  public String jyo;
  
  private void aME()
  {
    if ((this.jFI != null) && (this.hcm != null) && (this.hcm.equals(this.jFI.field_username)) && (bk.bl(this.jFI.field_championUrl)))
    {
      if (this.jEs != null) {
        this.jEs.setVisibility(0);
      }
      if (this.jFB != null) {
        this.jFB.setOnViewClickListener(new ExdeviceRankInfoUI.21(this));
      }
    }
    do
    {
      return;
      if (this.jEs != null) {
        this.jEs.setVisibility(8);
      }
    } while ((this.jFI == null) || (bk.aM(this.jFI.field_username, "").equals(this.hcm)) || (bk.bl(this.jFI.field_championUrl)));
    this.jFB.setOnViewClickListener(new ExdeviceRankInfoUI.22(this));
  }
  
  private void aMJ()
  {
    y.i("MicroMsg.Sport.ExdeviceRankInfoUI", "updateRankInfoUIFromServer");
    this.jFS = new j(this.jFH, this.jFG, this.jFJ, this.jFO, this.jFT);
    this.jFS.jyq = this;
    au.Dk().a(this.jFS, 0);
  }
  
  private void aMK()
  {
    y.i("MicroMsg.Sport.ExdeviceRankInfoUI", "try2LocateToUser, locate2User(%s), username(%s).", new Object[] { this.jFQ, this.hcm });
    String str;
    int i;
    if (!bk.bl(this.jFQ))
    {
      str = this.jFQ;
      y.i("MicroMsg.Sport.ExdeviceRankInfoUI", "locateToUser, locate2User(%s), username(%s).", new Object[] { str, this.hcm });
      if (!bk.bl(str)) {
        break label83;
      }
      i = -1;
    }
    label288:
    for (;;)
    {
      if (i < 0) {
        y.d("MicroMsg.Sport.ExdeviceRankInfoUI", "locate to username is null or nil.");
      }
      return;
      label83:
      if ((this.jFL == null) || (this.jFL.size() == 0))
      {
        i = -2;
      }
      else
      {
        i = 0;
        for (;;)
        {
          if (i >= this.jFL.size()) {
            break label288;
          }
          Object localObject = ((e)this.jFL.get(i)).jHR;
          int j = ((e)this.jFL.get(i)).jHS;
          if ((localObject != null) && (str.equalsIgnoreCase(((com.tencent.mm.plugin.exdevice.f.b.a.d)localObject).field_username)) && (!str.equalsIgnoreCase(this.hcm)) && ((j & 0x2) != 2))
          {
            localObject = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
            j = ((DisplayMetrics)localObject).heightPixels;
            y.i("MicroMsg.Sport.ExdeviceRankInfoUI", "locateToUser pos(%d).(h : %d)", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
            this.jFy.setSelectionFromTop(i, j / 4);
            this.jFz.jEY = str;
            this.jFz.notifyDataSetInvalidated();
            aMN();
            break;
          }
          i += 1;
        }
        this.jFz.jEY = null;
        i = -3;
      }
    }
  }
  
  private void aML()
  {
    String str = aMM();
    if (!bk.bl(str)) {
      this.jFJ = str;
    }
  }
  
  private String aMM()
  {
    if (this.jFL != null)
    {
      Iterator localIterator = this.jFL.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.exdevice.f.b.a.d locald = ((e)localIterator.next()).jHR;
        if ((locald != null) && (locald.field_ranknum == 1)) {
          return locald.field_username;
        }
      }
    }
    return null;
  }
  
  private void aMN()
  {
    View localView = this.jFy.getChildAt(0);
    int[] arrayOfInt = new int[2];
    int i;
    if (localView != null)
    {
      if (this.jFy.getFirstVisiblePosition() != 0) {
        break label133;
      }
      localView.getLocationOnScreen(arrayOfInt);
      if ((bk.bl(this.jFQ)) && (jEE == 128)) {
        jEE = arrayOfInt[1];
      }
      i = arrayOfInt[1];
      if (i <= 0) {
        break label133;
      }
      if (i < jEE) {
        break label122;
      }
    }
    label122:
    for (float f = 1.0F;; f = i / jEE)
    {
      y.d("MicroMsg.Sport.ExdeviceRankInfoUI", "ap-alpha: %s", new Object[] { Float.valueOf(f) });
      this.jFC.setAlpha(f);
      this.jFC.setVisibility(0);
      this.jEs.setAlpha(f);
      return;
    }
    label133:
    this.jFC.setAlpha(0.0F);
    this.jEs.setAlpha(0.0F);
    this.jFC.setVisibility(8);
  }
  
  private void aMO()
  {
    if (this.jFI != null)
    {
      if ((this.gDJ != this.jFI.field_championUrl) && ((this.gDJ == null) || (!this.gDJ.equals(this.jFI.field_championUrl))))
      {
        com.tencent.mm.plugin.exdevice.f.a.e.a(this, this.jEm, this.jFI.field_championUrl, R.e.darkgrey);
        this.gDJ = this.jFI.field_championUrl;
      }
      return;
    }
    this.jEm.setImageResource(R.e.darkgrey);
    this.gDJ = null;
  }
  
  private void aMQ()
  {
    if (bk.bl(this.jyo))
    {
      localObject = ad.aLP().BC(this.hcm);
      if (localObject != null) {
        this.jyo = ((com.tencent.mm.plugin.exdevice.f.b.a.a)localObject).field_championUrl;
      }
    }
    com.tencent.mm.plugin.exdevice.f.b.a.d locald = b.f(this.hcm, this.jFN);
    Object localObject = "--";
    String str = "0";
    if (locald != null)
    {
      localObject = String.valueOf(locald.field_ranknum);
      str = String.valueOf(locald.field_score);
    }
    new ac().a(this, (String)localObject, str, this.jyo, new ExdeviceRankInfoUI.11(this));
  }
  
  private void fE(boolean paramBoolean)
  {
    if ((this.jFP) && (!paramBoolean)) {
      return;
    }
    ad.aLT();
    this.jFN = com.tencent.mm.plugin.exdevice.f.b.c.By(this.jFH);
    this.jFM = ad.aLN().aLZ();
    this.jFL = this.jFz.b(this.jFM, this.jFN, this.jyn);
    runOnUiThread(new ExdeviceRankInfoUI.1(this));
  }
  
  private void fF(boolean paramBoolean)
  {
    if (paramBoolean) {
      aML();
    }
    if (!bk.bl(this.jFG))
    {
      this.jFC.BQ(this.jFJ);
      this.jFC.setVisibility(0);
      return;
    }
    this.jFC.setVisibility(8);
  }
  
  public final void BS(String paramString)
  {
    com.tencent.mm.plugin.sport.b.d.jdMethod_if(6);
    Intent localIntent = new Intent(this, ExdeviceProfileUI.class);
    localIntent.putExtra("username", paramString);
    localIntent.putExtra("usernickname", (String)this.jEX.get(paramString));
    localIntent.putExtra("app_username", this.jFG);
    localIntent.putExtra("rank_id", this.jFH);
    startActivityForResult(localIntent, 4);
  }
  
  public final boolean BT(String paramString)
  {
    if ((!bk.bl(this.jFH)) && (!"#".equals(this.jFH)))
    {
      if (q.Gj().equals(paramString))
      {
        y.d("MicroMsg.Sport.ExdeviceRankInfoUI", "hy: is self. see who likes me");
        paramString = new Intent(this, ExdeviceLikeUI.class);
        paramString.putExtra("app_username", this.jFG);
        paramString.putExtra("rank_id", this.jFH);
        paramString.putExtra("key_is_like_read_only", true);
        startActivity(paramString);
        return true;
      }
      return false;
    }
    y.d("MicroMsg.Sport.ExdeviceRankInfoUI", "hy: rank id is not valid.abort the event");
    Toast.makeText(this, getString(R.l.exdevice_rank_id_not_ready), 0).show();
    return true;
  }
  
  public final void Bz(String paramString)
  {
    y.d("MicroMsg.Sport.ExdeviceRankInfoUI", "hy: rank changed to %s", new Object[] { paramString });
    this.jFH = paramString;
  }
  
  public final void a(j paramj)
  {
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        if ((ExdeviceRankInfoUI.e(ExdeviceRankInfoUI.this) != null) && (ExdeviceRankInfoUI.e(ExdeviceRankInfoUI.this).isShowing()))
        {
          ExdeviceRankInfoUI.e(ExdeviceRankInfoUI.this).dismiss();
          ExdeviceRankInfoUI.f(ExdeviceRankInfoUI.this);
          y.d("MicroMsg.Sport.ExdeviceRankInfoUI", "dismiss tips dialog.");
        }
      }
    });
    this.jEu = paramj.jxR;
    this.jEv = paramj.jxS;
    this.jyo = paramj.jyo;
    this.jyn = paramj.jyn;
    this.jyb = paramj.jyb;
    this.jFN = paramj.jyg;
    this.jFM = paramj.jyh;
    this.jFL = this.jFz.b(this.jFM, this.jFN, this.jyn);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        ExdeviceRankInfoUI.b(ExdeviceRankInfoUI.this).jEW = ExdeviceRankInfoUI.a(ExdeviceRankInfoUI.this);
        ExdeviceRankInfoUI.b(ExdeviceRankInfoUI.this).notifyDataSetChanged();
        ExdeviceRankInfoUI.c(ExdeviceRankInfoUI.this);
      }
    });
  }
  
  public final void aMP()
  {
    com.tencent.mm.plugin.sport.b.d.jdMethod_if(31);
    aMQ();
  }
  
  public final void b(String paramString, com.tencent.mm.plugin.exdevice.f.b.d paramd)
  {
    boolean bool;
    if ((paramd != null) && (!bk.bl(paramString)))
    {
      bool = true;
      Assert.assertTrue(bool);
      if (!"HardDeviceRankInfo".equals(paramString)) {
        break label144;
      }
      if ((this.jFH != null) && (this.jFH.equals(paramd.jyd)))
      {
        y.i("MicroMsg.Sport.ExdeviceRankInfoUI", "onRankChange, rankId(%s).", new Object[] { this.jFH });
        fE(true);
        if ((bk.bl(this.jFJ)) || (!this.jFJ.equals(aMM())))
        {
          aML();
          this.jFI = ad.aLP().BC(this.jFJ);
          runOnUiThread(new ExdeviceRankInfoUI.8(this));
        }
        runOnUiThread(new ExdeviceRankInfoUI.9(this));
      }
    }
    label144:
    while ((!"HardDeviceChampionInfo".equals(paramString)) || (bk.bl(this.jFJ)) || (!this.jFJ.equals(paramd.username)))
    {
      return;
      bool = false;
      break;
    }
    this.jFI = ad.aLP().BC(this.jFJ);
    runOnUiThread(new ExdeviceRankInfoUI.10(this));
  }
  
  public final void bz(String paramString, int paramInt)
  {
    ad.aLT();
    String str1 = this.jFH;
    String str2 = this.jFG;
    com.tencent.mm.plugin.exdevice.f.b.b.d locald = ad.aLM();
    boolean bool;
    com.tencent.mm.plugin.exdevice.f.b.a.d locald1;
    if ((!bk.bl(str1)) && (!bk.bl(paramString)) && ((paramInt == 1) || (paramInt == 0) || (paramInt == 2)))
    {
      bool = true;
      Assert.assertTrue(bool);
      locald1 = locald.a(new com.tencent.mm.plugin.exdevice.f.b.d(str1, null, paramString));
      if (locald1 != null) {
        break label113;
      }
      y.w("MicroMsg.ExdeviceRankInfoStg", "hy: info is null. abort");
    }
    for (;;)
    {
      com.tencent.mm.plugin.exdevice.f.b.c.d(str1, str2, paramString, paramInt);
      this.jFU += 1;
      return;
      bool = false;
      break;
      label113:
      locald1.field_selfLikeState = paramInt;
      switch (locald1.field_selfLikeState)
      {
      default: 
        y.w("MicroMsg.ExdeviceRankInfoStg", "hy: still loading...abort");
      }
    }
    for (locald1.field_likecount += 1;; locald1.field_likecount -= 1)
    {
      locald.a(locald1, true);
      break;
    }
  }
  
  protected final int getLayoutId()
  {
    return R.i.exdevice_rank_info;
  }
  
  protected final void initView()
  {
    this.jFA = findViewById(R.h.not_support_msg_type);
    Object localObject1 = new ExdeviceRankListHeaderView(this);
    Object localObject2 = new Rect();
    getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject2);
    int j = ((Rect)localObject2).top;
    int i = j;
    if (j == 0) {
      i = com.tencent.mm.plugin.exdevice.j.b.A(this, getResources().getDimensionPixelSize(R.f.ExdeviceDefaultStatusBarHeight));
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
        i = getResources().getDimensionPixelSize(R.f.ExdeviceChangeCoverClickAreaHeight);
      }
      ((ExdeviceRankListHeaderView)localObject1).setMinimumHeight(i);
      ((ExdeviceRankListHeaderView)localObject1).setMinimumWidth(((Display)localObject2).getWidth());
      ((ExdeviceRankListHeaderView)localObject1).setTag(Integer.valueOf(i));
      this.jFB = ((ExdeviceRankListHeaderView)localObject1);
      localObject1 = (MMPullDownView)findViewById(R.h.pulldown_view);
      this.jFy = ((ListView)findViewById(R.h.exdevice_rank_info_lv));
      this.jFC = ((ExdeviceRankChampionInfoView)findViewById(R.h.championInfoV));
      this.jEs = findViewById(R.h.setCoverV);
      this.jEs.setOnClickListener(new ExdeviceRankInfoUI.23(this));
      this.jFB.setIsShowTip(false);
      aME();
      ((MMPullDownView)localObject1).setIsBottomShowAll(false);
      ((MMPullDownView)localObject1).setTopViewVisible(false);
      ((MMPullDownView)localObject1).setBottomViewVisible(false);
      ((MMPullDownView)localObject1).setIsBottomShowAll(false);
      ((MMPullDownView)localObject1).setIsTopShowAll(false);
      ((MMPullDownView)localObject1).setCanOverScrool(true);
      ((MMPullDownView)localObject1).setOnInterceptTouchEventListener(new ExdeviceRankInfoUI.24(this));
      ((MMPullDownView)localObject1).setAtBottomCallBack(new ExdeviceRankInfoUI.2(this));
      ((MMPullDownView)localObject1).setOnScrollChangedListener(new ExdeviceRankInfoUI.3(this));
      ((MMPullDownView)localObject1).setAtTopCallBack(new ExdeviceRankInfoUI.4(this));
      this.jFy.setOnScrollListener(new ExdeviceRankInfoUI.5(this));
      this.jFy.addHeaderView(this.jFB, null, false);
      localObject2 = getLayoutInflater().inflate(R.i.exdevice_rank_footer_view, null);
      this.jFD = ((View)localObject2).findViewById(R.h.invite_friend_footer);
      ((View)localObject2).findViewById(R.h.invite_friend_btn).setOnClickListener(new ExdeviceRankInfoUI.6(this));
      this.jFD.setVisibility(8);
      this.jFy.addFooterView((View)localObject2);
      if (this.jFM == null) {
        break label741;
      }
    }
    label741:
    for (i = this.jFM.size();; i = 0)
    {
      if (this.jFN != null) {}
      for (j = this.jFN.size();; j = 0)
      {
        if (i + j == 0)
        {
          this.jFL = new ArrayList();
          this.jFz.jEW = this.jFL;
          getString(R.l.app_tip);
          this.jCc = h.b(this, getString(R.l.loading_tips), true, new ExdeviceRankInfoUI.7(this));
        }
        this.jFy.setAdapter(this.jFz);
        this.jFz.jEZ = this;
        if (this.jFK == 1)
        {
          this.jFy.setVisibility(0);
          this.jFA.setVisibility(8);
        }
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label626;
          }
          y.d("MicroMsg.Sport.ExdeviceRankInfoUI", "hy: cannot handle this device type");
          finish();
          return;
          j = getResources().getDimensionPixelSize(R.f.DefaultActionbarHeightPort);
          break;
          this.jFy.setVisibility(8);
          this.jFA.setVisibility(0);
        }
        label626:
        this.jEm = ((ImageView)findViewById(R.h.exdevice_bg_iv));
        ((MMPullDownView)localObject1).setCanOverScrool(false);
        int k = com.tencent.mm.cb.a.fj(this);
        j = ((Integer)this.jFB.getTag()).intValue();
        i = j;
        if (this.jyn)
        {
          i = getResources().getDimensionPixelSize(R.f.ExdeviceProfileAvatarSize);
          int m = getResources().getDimensionPixelSize(R.f.ExdeviceProfileAvatarRoundStrokeWidth);
          i = j + (i / 2 + m);
        }
        localObject1 = new RelativeLayout.LayoutParams(k, i);
        this.jEm.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        aMO();
        fF(false);
        return;
      }
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (com.tencent.mm.plugin.exdevice.f.a.e.a(this, paramInt1, paramInt2, paramIntent, this.jFG)) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (paramInt2 != -1);
        switch (paramInt1)
        {
        default: 
          return;
        case 1: 
          if (paramIntent == null)
          {
            y.e("MicroMsg.Sport.ExdeviceRankInfoUI", "onActivityResult, data is null.(reqestCode : %d)", new Object[] { Integer.valueOf(paramInt1) });
            return;
          }
          if (paramIntent == null) {}
          for (localObject = null; (localObject == null) || (((String)localObject).length() == 0); localObject = paramIntent.getStringExtra("Select_Conv_User"))
          {
            y.e("MicroMsg.Sport.ExdeviceRankInfoUI", "select conversation failed, toUser is null.");
            return;
          }
          paramIntent = paramIntent.getStringExtra("custom_send_text");
          ac.a(this, (String)localObject, ac.cZ(this), paramIntent, this.jEv);
          h.bC(this.mController.uMN, getResources().getString(R.l.app_shared));
          y.d("MicroMsg.Sport.ExdeviceRankInfoUI", "Select conversation return.");
          return;
        case 2: 
          h.bC(this.mController.uMN, getResources().getString(R.l.app_shared));
          y.d("MicroMsg.Sport.ExdeviceRankInfoUI", "Share to timeline return.");
          return;
        }
      } while (paramIntent == null);
      Object localObject = bk.G(paramIntent.getStringExtra("received_card_name").split(","));
      paramIntent = paramIntent.getStringExtra("custom_send_text");
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        g.bhI().o("gh_43f2581f6fd6", str, com.tencent.mm.model.s.fn(str));
        if (!bk.bl(paramIntent))
        {
          pe localpe = new pe();
          localpe.bYQ.bYR = str;
          localpe.bYQ.content = paramIntent;
          localpe.bYQ.type = com.tencent.mm.model.s.hW(str);
          localpe.bYQ.flags = 0;
          com.tencent.mm.sdk.b.a.udP.m(localpe);
        }
      }
    } while ((paramIntent == null) || (!paramIntent.getBooleanExtra("KeyNeedUpdateRank", false)));
    aMJ();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.OV = false;
    this.hcm = q.Gj();
    paramBundle = getIntent();
    this.jFE = paramBundle.getStringExtra("key_rank_info");
    this.jFF = paramBundle.getStringExtra("key_rank_semi");
    this.jFG = paramBundle.getStringExtra("app_username");
    this.jFH = paramBundle.getStringExtra("rank_id");
    this.jFO = paramBundle.getBooleanExtra("key_is_latest", false);
    this.jFJ = paramBundle.getStringExtra("key_champioin_username");
    this.jFK = paramBundle.getIntExtra("device_type", 0);
    this.jFQ = paramBundle.getStringExtra("locate_to_username");
    this.jFP = paramBundle.getBooleanExtra("key_only_show_latest_rank", false);
    Object localObject;
    if ((bk.bl(this.jFH)) || ("#".equals(this.jFH)))
    {
      if (!this.jFP)
      {
        paramBundle = ad.aLM();
        localObject = String.format("select * from %s order by %s desc limit 1", new Object[] { "HardDeviceRankInfo", "rankID" });
        localObject = paramBundle.dXw.a((String)localObject, null, 2);
        if (localObject != null) {
          break label641;
        }
        y.e("MicroMsg.ExdeviceRankInfoStg", "Get no rank in DB");
        paramBundle = null;
        if (paramBundle != null)
        {
          this.jFH = paramBundle.field_rankID;
          this.jFG = paramBundle.field_appusername;
        }
      }
      this.jFJ = null;
      this.jFO = true;
    }
    else
    {
      ad.aLT();
      this.jFN = com.tencent.mm.plugin.exdevice.f.b.c.By(this.jFH);
      if (!this.jFP)
      {
        if ((this.jFN != null) && (this.jFN.size() > 0)) {
          break label686;
        }
        this.jFM = new ArrayList();
        this.jFN = com.tencent.mm.plugin.exdevice.f.a.a.a(this.jFH, this.jFG, this.jFE, this.jFF, this.jEX, this.jFM);
        ad.aLT();
        com.tencent.mm.plugin.exdevice.f.b.c.d(this.jFH, this.jFN);
      }
    }
    for (;;)
    {
      this.jFM = ad.aLN().aLZ();
      this.jFz = new b(this, this.jFG);
      this.jFz.jEX = this.jEX;
      this.jFL = this.jFz.b(this.jFM, this.jFN, this.jyn);
      this.jFz.jEW = this.jFL;
      if (bk.bl(this.jFJ)) {
        aML();
      }
      this.jFI = ad.aLP().BC(this.jFJ);
      if ((this.jFI == null) && (!bk.bl(this.jFJ)))
      {
        this.jFI = new com.tencent.mm.plugin.exdevice.f.b.a.a();
        this.jFI.field_username = this.jFJ;
        this.jFI.field_championMotto = getIntent().getStringExtra("key_champion_info");
        this.jFI.field_championUrl = getIntent().getStringExtra("key_champion_coverimg");
        ad.aLT();
        paramBundle = this.jFI;
        ad.aLP().a(paramBundle);
      }
      initView();
      if ((this.jFN != null) && (this.jFN.size() > 0))
      {
        paramBundle = ((com.tencent.mm.plugin.exdevice.f.b.a.d)this.jFN.get(0)).field_username;
        this.jFC.BQ(paramBundle);
      }
      ad.aLU().a(this);
      ad.aLT().jyx = this;
      aMJ();
      setBackBtn(new ExdeviceRankInfoUI.18(this));
      setMMTitle(R.l.exdevice_wechat_sport_rank_title);
      showOptionMenu(true);
      aMK();
      paramBundle = new rb();
      paramBundle.cap.action = 2;
      com.tencent.mm.sdk.b.a.udP.a(paramBundle, Looper.getMainLooper());
      return;
      label641:
      if (!((Cursor)localObject).moveToFirst())
      {
        y.d("MicroMsg.ExdeviceRankInfoStg", "hy: no record");
        paramBundle = null;
      }
      for (;;)
      {
        ((Cursor)localObject).close();
        break;
        paramBundle = new com.tencent.mm.plugin.exdevice.f.b.a.d();
        paramBundle.d((Cursor)localObject);
      }
      label686:
      com.tencent.mm.plugin.exdevice.f.a.a.a(this.jFE, this.jFF, this.jEX);
    }
  }
  
  protected void onDestroy()
  {
    this.OV = true;
    if (this.jFz != null) {
      b.finish();
    }
    super.onDestroy();
    if (this.jFS != null) {
      this.jFS.jyq = null;
    }
    ad.aLU().b(this);
    ad.aLT().jyx = null;
    ad.aLT().jyy = null;
    if (this.jFU > 0)
    {
      int i = this.jFU;
      y.v("MicroMsg.Sport.SportReportLogic", "reportLikeCount count=%d", new Object[] { Integer.valueOf(i) });
      com.tencent.mm.plugin.report.f.nEG.f(13168, new Object[] { Integer.valueOf(0), Integer.valueOf(i) });
    }
  }
  
  protected void onPause()
  {
    super.onPause();
  }
  
  protected void onRestart()
  {
    super.onRestart();
    fE(true);
  }
  
  protected void onResume()
  {
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI
 * JD-Core Version:    0.7.0.1
 */