package com.tencent.mm.plugin.exdevice.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.os.Bundle;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.qj;
import com.tencent.mm.g.a.sn;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.exdevice.f.a.j;
import com.tencent.mm.plugin.exdevice.f.a.j.a;
import com.tencent.mm.plugin.exdevice.f.b.f;
import com.tencent.mm.plugin.exdevice.model.ac;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.messenger.a.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
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
  implements j.a, com.tencent.mm.plugin.exdevice.f.b.e, f, d
{
  private static int lOc = 128;
  private boolean OZ;
  private String icM;
  private String ikj;
  private boolean lHA;
  public boolean lHM;
  public String lHN;
  private com.tencent.mm.ui.base.p lLB;
  private ImageView lNK;
  private View lNQ;
  private String lNS;
  private String lNT;
  private ListView lOW;
  private b lOX;
  private View lOY;
  private ExdeviceRankListHeaderView lOZ;
  private Map<String, String> lOv;
  private ExdeviceRankChampionInfoView lPa;
  private View lPb;
  private String lPc;
  private String lPd;
  private String lPe;
  private String lPf;
  private com.tencent.mm.plugin.exdevice.f.b.a.a lPg;
  private String lPh;
  private int lPi;
  private List<e> lPj;
  private ArrayList<com.tencent.mm.plugin.exdevice.f.b.a.c> lPk;
  private ArrayList<com.tencent.mm.plugin.exdevice.f.b.a.d> lPl;
  private boolean lPm;
  private boolean lPn;
  private String lPo;
  private boolean lPp;
  private j lPq;
  private com.tencent.mm.plugin.exdevice.a.b<j> lPr;
  private int lPs;
  
  public ExdeviceRankInfoUI()
  {
    AppMethodBeat.i(20163);
    this.lLB = null;
    this.lOv = new HashMap();
    this.lPr = new ExdeviceRankInfoUI.12(this);
    AppMethodBeat.o(20163);
  }
  
  private int LU(String paramString)
  {
    AppMethodBeat.i(20168);
    ab.i("MicroMsg.Sport.ExdeviceRankInfoUI", "locateToUser, locate2User(%s), username(%s).", new Object[] { paramString, this.ikj });
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(20168);
      return -1;
    }
    if ((this.lPj == null) || (this.lPj.size() == 0))
    {
      AppMethodBeat.o(20168);
      return -2;
    }
    int i = 0;
    while (i < this.lPj.size())
    {
      Object localObject = ((e)this.lPj.get(i)).lRp;
      int j = ((e)this.lPj.get(i)).lRq;
      if ((localObject != null) && (paramString.equalsIgnoreCase(((com.tencent.mm.plugin.exdevice.f.b.a.d)localObject).field_username)) && (!paramString.equalsIgnoreCase(this.ikj)) && ((j & 0x2) != 2))
      {
        localObject = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
        j = ((DisplayMetrics)localObject).heightPixels;
        ab.i("MicroMsg.Sport.ExdeviceRankInfoUI", "locateToUser pos(%d).(h : %d)", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        this.lOW.setSelectionFromTop(i, j / 4);
        this.lOX.lOw = paramString;
        this.lOX.notifyDataSetInvalidated();
        brb();
        AppMethodBeat.o(20168);
        return i;
      }
      i += 1;
    }
    this.lOX.lOw = null;
    AppMethodBeat.o(20168);
    return -3;
  }
  
  private void bqS()
  {
    AppMethodBeat.i(20169);
    if ((this.lPg != null) && (this.ikj != null) && (this.ikj.equals(this.lPg.field_username)) && (bo.isNullOrNil(this.lPg.field_championUrl)))
    {
      if (this.lNQ != null) {
        this.lNQ.setVisibility(0);
      }
      if (this.lOZ != null)
      {
        this.lOZ.setOnViewClickListener(new ExdeviceRankInfoUI.21(this));
        AppMethodBeat.o(20169);
      }
    }
    else
    {
      if (this.lNQ != null) {
        this.lNQ.setVisibility(8);
      }
      if ((this.lPg != null) && (!bo.bf(this.lPg.field_username, "").equals(this.ikj)) && (!bo.isNullOrNil(this.lPg.field_championUrl))) {
        this.lOZ.setOnViewClickListener(new ExdeviceRankInfoUI.22(this));
      }
    }
    AppMethodBeat.o(20169);
  }
  
  private void bqX()
  {
    AppMethodBeat.i(20166);
    ab.i("MicroMsg.Sport.ExdeviceRankInfoUI", "updateRankInfoUIFromServer");
    this.lPq = new j(this.lPf, this.lPe, this.lPh, this.lPm, this.lPr);
    this.lPq.lHP = this;
    aw.Rc().a(this.lPq, 0);
    AppMethodBeat.o(20166);
  }
  
  private void bqY()
  {
    AppMethodBeat.i(20167);
    ab.i("MicroMsg.Sport.ExdeviceRankInfoUI", "try2LocateToUser, locate2User(%s), username(%s).", new Object[] { this.lPo, this.ikj });
    if ((bo.isNullOrNil(this.lPo)) || (LU(this.lPo) < 0))
    {
      ab.d("MicroMsg.Sport.ExdeviceRankInfoUI", "locate to username is null or nil.");
      AppMethodBeat.o(20167);
      return;
    }
    AppMethodBeat.o(20167);
  }
  
  private void bqZ()
  {
    AppMethodBeat.i(20170);
    String str = bra();
    if (!bo.isNullOrNil(str)) {
      this.lPh = str;
    }
    AppMethodBeat.o(20170);
  }
  
  private String bra()
  {
    AppMethodBeat.i(20171);
    if (this.lPj != null)
    {
      Object localObject = this.lPj.iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.plugin.exdevice.f.b.a.d locald = ((e)((Iterator)localObject).next()).lRp;
        if ((locald != null) && (locald.field_ranknum == 1))
        {
          localObject = locald.field_username;
          AppMethodBeat.o(20171);
          return localObject;
        }
      }
    }
    AppMethodBeat.o(20171);
    return null;
  }
  
  private void brb()
  {
    AppMethodBeat.i(20173);
    View localView = this.lOW.getChildAt(0);
    int[] arrayOfInt = new int[2];
    if (localView != null)
    {
      if (this.lOW.getFirstVisiblePosition() == 0)
      {
        localView.getLocationOnScreen(arrayOfInt);
        if ((bo.isNullOrNil(this.lPo)) && (lOc == 128)) {
          lOc = arrayOfInt[1];
        }
        int i = arrayOfInt[1];
        if (i > 0)
        {
          if (i >= lOc) {}
          for (float f = 1.0F;; f = i / lOc)
          {
            ab.d("MicroMsg.Sport.ExdeviceRankInfoUI", "ap-alpha: %s", new Object[] { Float.valueOf(f) });
            this.lPa.setAlpha(f);
            this.lPa.setVisibility(0);
            this.lNQ.setAlpha(f);
            AppMethodBeat.o(20173);
            return;
          }
        }
      }
      this.lPa.setAlpha(0.0F);
      this.lNQ.setAlpha(0.0F);
      this.lPa.setVisibility(8);
    }
    AppMethodBeat.o(20173);
  }
  
  private void brc()
  {
    AppMethodBeat.i(20178);
    if (this.lPg != null)
    {
      if ((this.icM != this.lPg.field_championUrl) && ((this.icM == null) || (!this.icM.equals(this.lPg.field_championUrl))))
      {
        com.tencent.mm.plugin.exdevice.f.a.e.a(this, this.lNK, this.lPg.field_championUrl);
        this.icM = this.lPg.field_championUrl;
        AppMethodBeat.o(20178);
      }
    }
    else
    {
      this.lNK.setImageResource(2131689922);
      this.icM = null;
    }
    AppMethodBeat.o(20178);
  }
  
  private void bre()
  {
    AppMethodBeat.i(20187);
    if (bo.isNullOrNil(this.lHN))
    {
      localObject = ad.bqc().LE(this.ikj);
      if (localObject != null) {
        this.lHN = ((com.tencent.mm.plugin.exdevice.f.b.a.a)localObject).field_championUrl;
      }
    }
    com.tencent.mm.plugin.exdevice.f.b.a.d locald = b.h(this.ikj, this.lPl);
    Object localObject = "--";
    String str = "0";
    if (locald != null)
    {
      localObject = String.valueOf(locald.field_ranknum);
      str = String.valueOf(locald.field_score);
    }
    new ac().a(this, (String)localObject, str, this.lHN, new ExdeviceRankInfoUI.11(this));
    AppMethodBeat.o(20187);
  }
  
  private void hg(boolean paramBoolean)
  {
    AppMethodBeat.i(20164);
    if ((this.lPn) && (!paramBoolean))
    {
      AppMethodBeat.o(20164);
      return;
    }
    ad.bqg();
    this.lPl = com.tencent.mm.plugin.exdevice.f.b.c.LA(this.lPf);
    this.lPk = ad.bqa().bqm();
    this.lPj = this.lOX.b(this.lPk, this.lPl, this.lHM);
    runOnUiThread(new ExdeviceRankInfoUI.1(this));
    AppMethodBeat.o(20164);
  }
  
  private void hh(boolean paramBoolean)
  {
    AppMethodBeat.i(20179);
    if (paramBoolean) {
      bqZ();
    }
    if (!bo.isNullOrNil(this.lPe))
    {
      this.lPa.LS(this.lPh);
      this.lPa.setVisibility(0);
      AppMethodBeat.o(20179);
      return;
    }
    this.lPa.setVisibility(8);
    AppMethodBeat.o(20179);
  }
  
  public final void LB(String paramString)
  {
    AppMethodBeat.i(20181);
    ab.d("MicroMsg.Sport.ExdeviceRankInfoUI", "hy: rank changed to %s", new Object[] { paramString });
    this.lPf = paramString;
    AppMethodBeat.o(20181);
  }
  
  public final void LV(String paramString)
  {
    AppMethodBeat.i(20182);
    com.tencent.mm.plugin.sport.a.d.kS(6);
    Intent localIntent = new Intent(this, ExdeviceProfileUI.class);
    localIntent.putExtra("username", paramString);
    localIntent.putExtra("usernickname", (String)this.lOv.get(paramString));
    localIntent.putExtra("app_username", this.lPe);
    localIntent.putExtra("rank_id", this.lPf);
    startActivityForResult(localIntent, 4);
    AppMethodBeat.o(20182);
  }
  
  public final boolean LW(String paramString)
  {
    AppMethodBeat.i(20186);
    if ((!bo.isNullOrNil(this.lPf)) && (!"#".equals(this.lPf)))
    {
      if (r.Zn().equals(paramString))
      {
        ab.d("MicroMsg.Sport.ExdeviceRankInfoUI", "hy: is self. see who likes me");
        paramString = new Intent(this, ExdeviceLikeUI.class);
        paramString.putExtra("app_username", this.lPe);
        paramString.putExtra("rank_id", this.lPf);
        paramString.putExtra("key_is_like_read_only", true);
        startActivity(paramString);
        AppMethodBeat.o(20186);
        return true;
      }
      AppMethodBeat.o(20186);
      return false;
    }
    ab.d("MicroMsg.Sport.ExdeviceRankInfoUI", "hy: rank id is not valid.abort the event");
    Toast.makeText(this, getString(2131299456), 0).show();
    AppMethodBeat.o(20186);
    return true;
  }
  
  public final void a(j paramj)
  {
    AppMethodBeat.i(20188);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(20152);
        if ((ExdeviceRankInfoUI.e(ExdeviceRankInfoUI.this) != null) && (ExdeviceRankInfoUI.e(ExdeviceRankInfoUI.this).isShowing()))
        {
          ExdeviceRankInfoUI.e(ExdeviceRankInfoUI.this).dismiss();
          ExdeviceRankInfoUI.f(ExdeviceRankInfoUI.this);
          ab.d("MicroMsg.Sport.ExdeviceRankInfoUI", "dismiss tips dialog.");
        }
        AppMethodBeat.o(20152);
      }
    });
    this.lNS = paramj.lHq;
    this.lNT = paramj.lHr;
    this.lHN = paramj.lHN;
    this.lHM = paramj.lHM;
    this.lHA = paramj.lHA;
    this.lPl = paramj.lHF;
    this.lPk = paramj.lHG;
    this.lPj = this.lOX.b(this.lPk, this.lPl, this.lHM);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(20153);
        ExdeviceRankInfoUI.b(ExdeviceRankInfoUI.this).lOu = ExdeviceRankInfoUI.a(ExdeviceRankInfoUI.this);
        ExdeviceRankInfoUI.b(ExdeviceRankInfoUI.this).notifyDataSetChanged();
        ExdeviceRankInfoUI.c(ExdeviceRankInfoUI.this);
        AppMethodBeat.o(20153);
      }
    });
    AppMethodBeat.o(20188);
  }
  
  public final void b(String paramString, com.tencent.mm.plugin.exdevice.f.b.d paramd)
  {
    AppMethodBeat.i(20180);
    if ((paramd != null) && (!bo.isNullOrNil(paramString))) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if (!"HardDeviceRankInfo".equals(paramString)) {
        break;
      }
      if ((this.lPf == null) || (!this.lPf.equals(paramd.lHC))) {
        break label216;
      }
      ab.i("MicroMsg.Sport.ExdeviceRankInfoUI", "onRankChange, rankId(%s).", new Object[] { this.lPf });
      hg(true);
      if ((bo.isNullOrNil(this.lPh)) || (!this.lPh.equals(bra())))
      {
        bqZ();
        this.lPg = ad.bqc().LE(this.lPh);
        runOnUiThread(new ExdeviceRankInfoUI.8(this));
      }
      runOnUiThread(new ExdeviceRankInfoUI.9(this));
      AppMethodBeat.o(20180);
      return;
    }
    if (("HardDeviceChampionInfo".equals(paramString)) && (!bo.isNullOrNil(this.lPh)) && (this.lPh.equals(paramd.username)))
    {
      this.lPg = ad.bqc().LE(this.lPh);
      runOnUiThread(new ExdeviceRankInfoUI.10(this));
    }
    label216:
    AppMethodBeat.o(20180);
  }
  
  public final void brd()
  {
    AppMethodBeat.i(20183);
    com.tencent.mm.plugin.sport.a.d.kS(31);
    bre();
    AppMethodBeat.o(20183);
  }
  
  public final void ce(String paramString, int paramInt)
  {
    AppMethodBeat.i(20184);
    ad.bqg();
    String str1 = this.lPf;
    String str2 = this.lPe;
    com.tencent.mm.plugin.exdevice.f.b.b.d locald = ad.bpZ();
    boolean bool;
    com.tencent.mm.plugin.exdevice.f.b.a.d locald1;
    if ((!bo.isNullOrNil(str1)) && (!bo.isNullOrNil(paramString)) && ((paramInt == 1) || (paramInt == 0) || (paramInt == 2)))
    {
      bool = true;
      Assert.assertTrue(bool);
      locald1 = locald.a(new com.tencent.mm.plugin.exdevice.f.b.d(str1, null, paramString));
      if (locald1 != null) {
        break label125;
      }
      ab.w("MicroMsg.ExdeviceRankInfoStg", "hy: info is null. abort");
    }
    for (;;)
    {
      com.tencent.mm.plugin.exdevice.f.b.c.d(str1, str2, paramString, paramInt);
      this.lPs += 1;
      AppMethodBeat.o(20184);
      return;
      bool = false;
      break;
      label125:
      locald1.field_selfLikeState = paramInt;
      switch (locald1.field_selfLikeState)
      {
      default: 
        ab.w("MicroMsg.ExdeviceRankInfoStg", "hy: still loading...abort");
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
    return 2130969475;
  }
  
  public void initView()
  {
    AppMethodBeat.i(20172);
    this.lOY = findViewById(2131823828);
    Object localObject1 = new ExdeviceRankListHeaderView(this);
    Object localObject2 = new Rect();
    getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject2);
    int j = ((Rect)localObject2).top;
    int i = j;
    if (j == 0) {
      i = com.tencent.mm.plugin.exdevice.j.b.K(this, getResources().getDimensionPixelSize(2131427611));
    }
    localObject2 = getResources().getDisplayMetrics();
    if (((DisplayMetrics)localObject2).widthPixels > ((DisplayMetrics)localObject2).heightPixels)
    {
      j = getResources().getDimensionPixelSize(2131427558);
      localObject2 = getWindowManager().getDefaultDisplay();
      j = ((Display)localObject2).getHeight() / 2 - i - j;
      if (((Display)localObject2).getHeight() > 0)
      {
        i = j;
        if (j > 0) {}
      }
      else
      {
        i = getResources().getDimensionPixelSize(2131427605);
      }
      ((ExdeviceRankListHeaderView)localObject1).setMinimumHeight(i);
      ((ExdeviceRankListHeaderView)localObject1).setMinimumWidth(((Display)localObject2).getWidth());
      ((ExdeviceRankListHeaderView)localObject1).setTag(Integer.valueOf(i));
      this.lOZ = ((ExdeviceRankListHeaderView)localObject1);
      localObject1 = (MMPullDownView)findViewById(2131823826);
      this.lOW = ((ListView)findViewById(2131823827));
      this.lPa = ((ExdeviceRankChampionInfoView)findViewById(2131823829));
      this.lNQ = findViewById(2131823817);
      this.lNQ.setOnClickListener(new ExdeviceRankInfoUI.23(this));
      this.lOZ.setIsShowTip(false);
      bqS();
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
      this.lOW.setOnScrollListener(new ExdeviceRankInfoUI.5(this));
      this.lOW.addHeaderView(this.lOZ, null, false);
      localObject2 = getLayoutInflater().inflate(2130969473, null);
      this.lPb = ((View)localObject2).findViewById(2131823823);
      ((View)localObject2).findViewById(2131823824).setOnClickListener(new ExdeviceRankInfoUI.6(this));
      this.lPb.setVisibility(8);
      this.lOW.addFooterView((View)localObject2);
      if (this.lPk == null) {
        break label759;
      }
    }
    label759:
    for (i = this.lPk.size();; i = 0)
    {
      if (this.lPl != null) {}
      for (j = this.lPl.size();; j = 0)
      {
        if (i + j == 0)
        {
          this.lPj = new ArrayList();
          this.lOX.lOu = this.lPj;
          getString(2131297087);
          this.lLB = h.b(this, getString(2131301086), true, new ExdeviceRankInfoUI.7(this));
        }
        this.lOW.setAdapter(this.lOX);
        this.lOX.lOx = this;
        if (this.lPi == 1)
        {
          this.lOW.setVisibility(0);
          this.lOY.setVisibility(8);
        }
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label638;
          }
          ab.d("MicroMsg.Sport.ExdeviceRankInfoUI", "hy: cannot handle this device type");
          finish();
          AppMethodBeat.o(20172);
          return;
          j = getResources().getDimensionPixelSize(2131427559);
          break;
          this.lOW.setVisibility(8);
          this.lOY.setVisibility(0);
        }
        label638:
        this.lNK = ((ImageView)findViewById(2131823816));
        ((MMPullDownView)localObject1).setCanOverScrool(false);
        int k = com.tencent.mm.cb.a.gw(this);
        j = ((Integer)this.lOZ.getTag()).intValue();
        i = j;
        if (this.lHM)
        {
          i = getResources().getDimensionPixelSize(2131427621);
          int m = getResources().getDimensionPixelSize(2131427620);
          i = j + (i / 2 + m);
        }
        localObject1 = new RelativeLayout.LayoutParams(k, i);
        this.lNK.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        brc();
        hh(false);
        AppMethodBeat.o(20172);
        return;
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(20185);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (com.tencent.mm.plugin.exdevice.f.a.e.a(this, paramInt1, paramInt2, paramIntent, this.lPe))
    {
      AppMethodBeat.o(20185);
      return;
    }
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(20185);
      return;
      if (paramIntent == null)
      {
        ab.e("MicroMsg.Sport.ExdeviceRankInfoUI", "onActivityResult, data is null.(reqestCode : %d)", new Object[] { Integer.valueOf(paramInt1) });
        AppMethodBeat.o(20185);
        return;
      }
      if (paramIntent == null) {}
      for (Object localObject = null; (localObject == null) || (((String)localObject).length() == 0); localObject = paramIntent.getStringExtra("Select_Conv_User"))
      {
        ab.e("MicroMsg.Sport.ExdeviceRankInfoUI", "select conversation failed, toUser is null.");
        AppMethodBeat.o(20185);
        return;
      }
      paramIntent = paramIntent.getStringExtra("custom_send_text");
      ac.a(this, (String)localObject, ac.dL(this), paramIntent, this.lNT);
      h.bO(getContext(), getResources().getString(2131297076));
      ab.d("MicroMsg.Sport.ExdeviceRankInfoUI", "Select conversation return.");
      AppMethodBeat.o(20185);
      return;
      h.bO(getContext(), getResources().getString(2131297076));
      ab.d("MicroMsg.Sport.ExdeviceRankInfoUI", "Share to timeline return.");
      AppMethodBeat.o(20185);
      return;
      if (paramIntent != null)
      {
        localObject = bo.P(paramIntent.getStringExtra("received_card_name").split(","));
        paramIntent = paramIntent.getStringExtra("custom_send_text");
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          g.bPJ().q("gh_43f2581f6fd6", str, t.lA(str));
          if (!bo.isNullOrNil(paramIntent))
          {
            qj localqj = new qj();
            localqj.cGX.cGY = str;
            localqj.cGX.content = paramIntent;
            localqj.cGX.type = t.oF(str);
            localqj.cGX.flags = 0;
            com.tencent.mm.sdk.b.a.ymk.l(localqj);
          }
        }
        AppMethodBeat.o(20185);
        return;
        if ((paramIntent != null) && (paramIntent.getBooleanExtra("KeyNeedUpdateRank", false))) {
          bqX();
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(20165);
    super.onCreate(paramBundle);
    this.OZ = false;
    this.ikj = r.Zn();
    paramBundle = getIntent();
    this.lPc = paramBundle.getStringExtra("key_rank_info");
    this.lPd = paramBundle.getStringExtra("key_rank_semi");
    this.lPe = paramBundle.getStringExtra("app_username");
    this.lPf = paramBundle.getStringExtra("rank_id");
    this.lPm = paramBundle.getBooleanExtra("key_is_latest", false);
    this.lPh = paramBundle.getStringExtra("key_champioin_username");
    this.lPi = paramBundle.getIntExtra("device_type", 0);
    this.lPo = paramBundle.getStringExtra("locate_to_username");
    this.lPn = paramBundle.getBooleanExtra("key_only_show_latest_rank", false);
    Object localObject;
    if ((bo.isNullOrNil(this.lPf)) || ("#".equals(this.lPf)))
    {
      if (!this.lPn)
      {
        paramBundle = ad.bpZ();
        localObject = String.format("select * from %s order by %s desc limit 1", new Object[] { "HardDeviceRankInfo", "rankID" });
        localObject = paramBundle.db.a((String)localObject, null, 2);
        if (localObject != null) {
          break label658;
        }
        ab.e("MicroMsg.ExdeviceRankInfoStg", "Get no rank in DB");
        paramBundle = null;
        if (paramBundle != null)
        {
          this.lPf = paramBundle.field_rankID;
          this.lPe = paramBundle.field_appusername;
        }
      }
      this.lPh = null;
      this.lPm = true;
    }
    else
    {
      ad.bqg();
      this.lPl = com.tencent.mm.plugin.exdevice.f.b.c.LA(this.lPf);
      if (!this.lPn)
      {
        if ((this.lPl != null) && (this.lPl.size() > 0)) {
          break label703;
        }
        this.lPk = new ArrayList();
        this.lPl = com.tencent.mm.plugin.exdevice.f.a.a.a(this.lPf, this.lPe, this.lPc, this.lPd, this.lOv, this.lPk);
        ad.bqg();
        com.tencent.mm.plugin.exdevice.f.b.c.f(this.lPf, this.lPl);
      }
    }
    for (;;)
    {
      this.lPk = ad.bqa().bqm();
      this.lOX = new b(this, this.lPe);
      this.lOX.lOv = this.lOv;
      this.lPj = this.lOX.b(this.lPk, this.lPl, this.lHM);
      this.lOX.lOu = this.lPj;
      if (bo.isNullOrNil(this.lPh)) {
        bqZ();
      }
      this.lPg = ad.bqc().LE(this.lPh);
      if ((this.lPg == null) && (!bo.isNullOrNil(this.lPh)))
      {
        this.lPg = new com.tencent.mm.plugin.exdevice.f.b.a.a();
        this.lPg.field_username = this.lPh;
        this.lPg.field_championMotto = getIntent().getStringExtra("key_champion_info");
        this.lPg.field_championUrl = getIntent().getStringExtra("key_champion_coverimg");
        ad.bqg();
        paramBundle = this.lPg;
        ad.bqc().a(paramBundle);
      }
      initView();
      if ((this.lPl != null) && (this.lPl.size() > 0))
      {
        paramBundle = ((com.tencent.mm.plugin.exdevice.f.b.a.d)this.lPl.get(0)).field_username;
        this.lPa.LS(paramBundle);
      }
      ad.bqh().a(this);
      ad.bqg().lHW = this;
      bqX();
      setBackBtn(new ExdeviceRankInfoUI.18(this));
      setMMTitle(2131299491);
      showOptionMenu(true);
      bqY();
      paramBundle = new sn();
      paramBundle.cIP.action = 2;
      com.tencent.mm.sdk.b.a.ymk.a(paramBundle, com.tencent.mm.sdk.g.d.ysm.cjN());
      AppMethodBeat.o(20165);
      return;
      label658:
      if (!((Cursor)localObject).moveToFirst())
      {
        ab.d("MicroMsg.ExdeviceRankInfoStg", "hy: no record");
        paramBundle = null;
      }
      for (;;)
      {
        ((Cursor)localObject).close();
        break;
        paramBundle = new com.tencent.mm.plugin.exdevice.f.b.a.d();
        paramBundle.convertFrom((Cursor)localObject);
      }
      label703:
      com.tencent.mm.plugin.exdevice.f.a.a.d(this.lPc, this.lPd, this.lOv);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(20176);
    this.OZ = true;
    if (this.lOX != null) {
      b.finish();
    }
    super.onDestroy();
    if (this.lPq != null) {
      this.lPq.lHP = null;
    }
    ad.bqh().b(this);
    ad.bqg().lHW = null;
    ad.bqg().lHX = null;
    if (this.lPs > 0)
    {
      int i = this.lPs;
      ab.v("MicroMsg.Sport.SportReportLogic", "reportLikeCount count=%d", new Object[] { Integer.valueOf(i) });
      com.tencent.mm.plugin.report.e.qrI.e(13168, new Object[] { Integer.valueOf(0), Integer.valueOf(i) });
    }
    AppMethodBeat.o(20176);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(20177);
    super.onPause();
    AppMethodBeat.o(20177);
  }
  
  protected void onRestart()
  {
    AppMethodBeat.i(20175);
    super.onRestart();
    hg(true);
    AppMethodBeat.o(20175);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(20174);
    super.onResume();
    AppMethodBeat.o(20174);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI
 * JD-Core Version:    0.7.0.1
 */