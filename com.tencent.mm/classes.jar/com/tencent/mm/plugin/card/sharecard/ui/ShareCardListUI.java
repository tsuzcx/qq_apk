package com.tencent.mm.plugin.card.sharecard.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.a.b;
import com.tencent.mm.plugin.card.a.c;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.base.CardBaseUI;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.model.k;
import com.tencent.mm.plugin.card.ui.CardDetailUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import java.util.ArrayList;

public class ShareCardListUI
  extends CardBaseUI
  implements com.tencent.mm.plugin.card.base.d, j.a
{
  private long ihf = 0L;
  private final long ihg = 500L;
  private boolean ihh = false;
  private String imf = null;
  private b.a ioA = null;
  private boolean iqA = false;
  private boolean iqB = false;
  private boolean iqC = false;
  private int iqD = 0;
  private boolean iqE = false;
  private long iqF = 0L;
  boolean iqG = false;
  private boolean iqH = false;
  private com.tencent.mm.plugin.card.sharecard.a.b iqh;
  private f iqq;
  private e iqr;
  private i iqs;
  private boolean iqt = false;
  private boolean iqu = true;
  private boolean iqv = false;
  private boolean iqw = true;
  private boolean iqx = true;
  private boolean iqy = false;
  private String iqz = "";
  private long mStartTime = 0L;
  
  private void aBf()
  {
    y.d("MicroMsg.ShareCardListUI", "initLocation");
    g.DS().O(new ShareCardListUI.1(this));
  }
  
  private void aBg()
  {
    long l = System.currentTimeMillis() - this.ihf;
    if ((this.ihh) && (l < 1000L))
    {
      y.d("MicroMsg.ShareCardListUI", "DoingUpdateView return");
      return;
    }
    y.d("MicroMsg.ShareCardListUI", "try2UpdateView isDoingUpdateView %s,interval %s", new Object[] { Boolean.valueOf(this.ihh), Long.valueOf(l) });
    this.ihh = true;
    if (l < 500L)
    {
      ai.l(new ShareCardListUI.5(this), 500L);
      return;
    }
    if ((this.iqD == 0) || (this.iqD == 4) || ((this.iqD == 2) && ((!com.tencent.mm.plugin.card.sharecard.a.b.aAS()) || (!com.tencent.mm.plugin.card.sharecard.a.b.aAR()))) || ((this.iqD == 1) && ((!com.tencent.mm.plugin.card.sharecard.a.b.aAS()) || (com.tencent.mm.plugin.card.sharecard.a.b.aAR()))) || ((this.iqD == 3) && ((!com.tencent.mm.plugin.card.sharecard.a.b.aAR()) || (com.tencent.mm.plugin.card.sharecard.a.b.aAS())))) {
      this.iqD = com.tencent.mm.plugin.card.sharecard.a.b.aAQ();
    }
    am.aAx().putValue("key_share_card_show_type", Integer.valueOf(this.iqD));
    y.i("MicroMsg.ShareCardListUI", "updateView() currentType is %s, canShowLocalCity %s, canShowOtherCity %s", new Object[] { Integer.valueOf(this.iqD), Boolean.valueOf(com.tencent.mm.plugin.card.sharecard.a.b.aAS()), Boolean.valueOf(com.tencent.mm.plugin.card.sharecard.a.b.aAR()) });
    f localf = this.iqq;
    localf.iqm.setVisibility(0);
    localf.iql.setImageDrawable(localf.hxN.getResources().getDrawable(a.c.card_has_card_entrance_bg));
    localf.iqm.setText(a.g.card_share_card_list_has_card_tips_title);
    localf.iqn.setText(a.g.card_share_card_list_has_card_tips);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localf.iql.getLayoutParams();
    localLayoutParams.topMargin = localf.hxN.getResources().getDimensionPixelOffset(a.b.card_no_card_tip_img_top_margin_for_share_card_ui);
    localf.iql.setLayoutParams(localLayoutParams);
    localf.iql.invalidate();
    if ((!com.tencent.mm.plugin.card.sharecard.a.b.aAS()) && (!com.tencent.mm.plugin.card.sharecard.a.b.aAR()))
    {
      this.iqr.aBe();
      this.iqs.iqJ.setVisibility(8);
      if (this.ijF.getEmptyView() != this.ijH)
      {
        this.ijF.setEmptyView(this.ijH);
        this.ijF.invalidate();
      }
    }
    for (;;)
    {
      aBh();
      this.ihf = System.currentTimeMillis();
      this.ihh = false;
      return;
      this.iqr.aZ();
      this.iqs.aZ();
      if ((this.iqD == 4) && (this.ijF.getEmptyView() != null))
      {
        this.ijF.setEmptyView(null);
        this.ijF.invalidate();
      }
    }
  }
  
  private void aBh()
  {
    if ((this.ijG instanceof c))
    {
      c localc = (c)this.ijG;
      localc.iqe = this.iqD;
      localc.a(null, null);
    }
  }
  
  private void aBi()
  {
    if ((com.tencent.mm.plugin.card.sharecard.a.b.aAU()) && (com.tencent.mm.plugin.card.sharecard.a.b.aAV()))
    {
      y.i("MicroMsg.ShareCardListUI", "doGetLayout() no data to load");
      this.iqx = true;
      return;
    }
    if ((!com.tencent.mm.plugin.card.sharecard.a.b.aAU()) || (!com.tencent.mm.plugin.card.sharecard.a.b.aAV())) {
      this.iqw = false;
    }
    y.i("MicroMsg.ShareCardListUI", "doGetLayout() >> doNetSceneGetCardsHomePageLayout()");
    aBj();
    am.aAy().r("", "", 4);
  }
  
  private void aBj()
  {
    if (this.iqy)
    {
      y.e("MicroMsg.ShareCardListUI", "doNetSceneGetCardsHomePageLayout, isDoingGetData is true");
      return;
    }
    if ((bk.bl(this.iqz)) && (!com.tencent.mm.plugin.card.sharecard.a.b.aAS()) && (!com.tencent.mm.plugin.card.sharecard.a.b.aAR()) && (!com.tencent.mm.plugin.card.sharecard.a.b.aAS()) && (!com.tencent.mm.plugin.card.sharecard.a.b.aAR()))
    {
      this.iqr.aBb();
      this.ijF.setEmptyView(null);
      this.ijF.invalidate();
      this.iqH = true;
    }
    if ((this.iqw) && (!bk.bl(this.iqz))) {
      this.iqz = "";
    }
    this.iqy = true;
    com.tencent.mm.plugin.card.sharecard.model.b localb = new com.tencent.mm.plugin.card.sharecard.model.b(am.aAy().dia, am.aAy().dib, this.iqz);
    g.DO().dJT.a(localb, 0);
  }
  
  private void aBk()
  {
    int i = getIntent().getIntExtra("key_from_scene", 22);
    boolean bool1 = com.tencent.mm.y.c.BS().bb(262152, 266256);
    boolean bool2 = com.tencent.mm.y.c.BS().bc(262152, 266256);
    boolean bool3 = com.tencent.mm.y.c.BS().a(ac.a.uoR, ac.a.uoT);
    boolean bool4 = com.tencent.mm.y.c.BS().a(ac.a.uoS, ac.a.uoU);
    String str = bk.pm((String)g.DP().Dz().get(ac.a.uoX, null));
    if (bool1)
    {
      h.nFQ.f(11324, new Object[] { "ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(2), Integer.valueOf(i), "", Integer.valueOf(0), str });
      return;
    }
    if (bool2)
    {
      h.nFQ.f(11324, new Object[] { "ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(1), Integer.valueOf(i), "", Integer.valueOf(0), str });
      return;
    }
    if ((bool3) && (!bool4))
    {
      h.nFQ.f(11324, new Object[] { "ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(3), Integer.valueOf(i), "", Integer.valueOf(0), str });
      return;
    }
    if ((bool3) && (bool4))
    {
      h.nFQ.f(11324, new Object[] { "ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(4), Integer.valueOf(i), "", Integer.valueOf(0), str });
      return;
    }
    if (bool4)
    {
      h.nFQ.f(11324, new Object[] { "ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(5), Integer.valueOf(i), "", Integer.valueOf(0), str });
      return;
    }
    h.nFQ.f(11324, new Object[] { "ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(i), "", Integer.valueOf(0), str });
  }
  
  private void ex(boolean paramBoolean)
  {
    y.i("MicroMsg.ShareCardListUI", "doRefreshData() >> updateView() shouldGetLayout %s fromOnresume %s", new Object[] { Boolean.valueOf(this.iqu), Boolean.valueOf(paramBoolean) });
    if (this.iqu)
    {
      this.iqu = false;
      this.iqA = false;
      this.iqw = true;
      this.iqz = "";
      y.d("MicroMsg.ShareCardListUI", "doRefreshData() >> doNetSceneGetCardsHomePageLayout()");
      if (!paramBoolean) {
        break label92;
      }
      if ((this.iqE) && (this.iqG)) {
        ayW();
      }
    }
    for (;;)
    {
      aBg();
      return;
      label92:
      aBj();
    }
  }
  
  protected final void a(com.tencent.mm.plugin.card.base.b paramb)
  {
    super.a(paramb);
  }
  
  protected final void a(com.tencent.mm.plugin.card.base.b paramb, int paramInt)
  {
    Intent localIntent = new Intent(this, CardDetailUI.class);
    y.i("MicroMsg.ShareCardListUI", "card tp id:" + paramb.azC());
    y.i("MicroMsg.ShareCardListUI", "card id:" + paramb.azB());
    localIntent.putExtra("key_card_id", am.aAA().yw(paramb.azC()));
    localIntent.putExtra("key_card_tp_id", paramb.azC());
    localIntent.putExtra("key_is_share_card", true);
    localIntent.putExtra("key_from_scene", 3);
    startActivity(localIntent);
    com.tencent.mm.plugin.card.sharecard.a.b.yt(paramb.azC());
  }
  
  public final void a(String paramString, com.tencent.mm.sdk.e.l paraml)
  {
    y.d("MicroMsg.ShareCardListUI", "onNotifyChange");
    this.iqu = true;
  }
  
  protected final void ayQ()
  {
    setMMTitle(a.g.card_share_card_list_ui_title);
    this.iqh = new com.tencent.mm.plugin.card.sharecard.a.b(this);
    this.ioA = new b.a() {};
    this.iqh.ioA = this.ioA;
    this.iqh.init();
    this.iqD = com.tencent.mm.plugin.card.sharecard.a.b.aAQ();
    Object localObject;
    if (this.iqs == null)
    {
      this.iqs = new i(this, this.mController.contentView);
      localObject = this.iqs;
      ((i)localObject).iqJ = View.inflate(((i)localObject).hxN, a.e.card_share_no_local_city_item, null);
      ((i)localObject).iqK = ((TextView)((i)localObject).iqJ.findViewById(a.d.card_item_category_title));
      ((i)localObject).iqL = ((TextView)((i)localObject).iqJ.findViewById(a.d.card_item_subcategory_title));
      ((i)localObject).aZ();
    }
    if (this.iqq == null)
    {
      this.iqq = new f(this, this.mController.contentView);
      localObject = this.iqq;
      ((f)localObject).iql = ((ImageView)((f)localObject).ipf.findViewById(a.d.no_card_tip_img));
      ((f)localObject).iqn = ((TextView)((f)localObject).ipf.findViewById(a.d.no_card_tip_text));
      ((f)localObject).iqm = ((TextView)((f)localObject).ipf.findViewById(a.d.no_card_tip_title));
      this.iqq.iqh = this.iqh;
    }
    if (this.iqr == null)
    {
      localObject = this.mController.contentView;
      this.iqr = new e(this);
      this.iqr.iqh = this.iqh;
      this.iqr.aBa();
      localObject = this.iqr;
      ShareCardListUI.3 local3 = new ShareCardListUI.3(this);
      if (((e)localObject).iqg != null) {
        ((e)localObject).iqg.setOnClickListener(local3);
      }
    }
    if (this.ijI != null) {
      this.ijI.addView(this.iqs.iqJ);
    }
    if (this.ijJ != null) {
      this.ijJ.addView(this.iqr.iqg);
    }
    this.ijF.setVisibility(0);
    this.ijF.setOnScrollListener(new ShareCardListUI.4(this));
    if ((getIntent() != null) && (getIntent().getBooleanExtra("KEY_IS_SHOW_SHARE_CARD_ENTRANCE_TIPS", true)))
    {
      localObject = (Integer)g.DP().Dz().get(ac.a.upj, Integer.valueOf(0));
      if ((localObject == null) || (((Integer)localObject).intValue() != 1))
      {
        g.DP().Dz().c(ac.a.upj, Integer.valueOf(1));
        com.tencent.mm.plugin.card.d.d.c(this, a.e.card_show_share_card_entrance_tips, a.g.card_share_card_tips_title, "");
      }
    }
    for (;;)
    {
      this.imf = getIntent().getStringExtra("KEY_CARD_TP_ID");
      this.iqz = getIntent().getStringExtra("key_layout_buff");
      if (!bk.bl(this.iqz)) {
        this.iqu = false;
      }
      if (!bk.bl(this.imf))
      {
        this.iqt = true;
        this.iqv = true;
      }
      return;
      localObject = (Integer)g.DP().Dz().get(ac.a.upj, Integer.valueOf(0));
      if ((localObject != null) && (((Integer)localObject).intValue() != 1)) {
        g.DP().Dz().c(ac.a.upj, Integer.valueOf(1));
      }
    }
  }
  
  protected final boolean ayS()
  {
    return super.ayS();
  }
  
  protected final boolean ayT()
  {
    return false;
  }
  
  protected final void ayY()
  {
    this.iqC = true;
    if (this.iqA)
    {
      y.e("MicroMsg.ShareCardListUI", "onLocationFinish, has do GetShareCardLayout,don't get again");
      if (this.iqE) {
        ayX();
      }
      return;
    }
    y.d("MicroMsg.ShareCardListUI", "onLocationFinish()");
    this.iqA = true;
    aBi();
    ayX();
  }
  
  protected final void ayZ()
  {
    if ((this.iqB) || (this.iqA))
    {
      ayX();
      return;
    }
    this.iqB = true;
    y.i("MicroMsg.ShareCardListUI", "onLocationFail()");
    aBi();
  }
  
  public final void azI()
  {
    com.tencent.mm.plugin.card.sharecard.a.b.aAP();
    this.iqu = true;
    y.i("MicroMsg.ShareCardListUI", "onDBchange() shouldRefreshDataOnDbChange %s  mIsActive %s hasLocationInfo %s", new Object[] { Boolean.valueOf(this.iqv), Boolean.valueOf(this.ijL), Boolean.valueOf(this.iqC) });
    if ((this.iqv) && (this.ijL) && (this.iqC)) {
      ex(false);
    }
    for (;;)
    {
      this.iqv = false;
      return;
      aBg();
    }
  }
  
  protected final void aza()
  {
    y.i("MicroMsg.ShareCardListUI", "onMPermissionGranted LocationPermissionGranted " + this.iqE);
    if (!this.iqE)
    {
      this.iqE = true;
      aBf();
    }
  }
  
  protected final void b(com.tencent.mm.plugin.card.base.b paramb, int paramInt)
  {
    if (paramb != null) {
      com.tencent.mm.plugin.card.sharecard.a.b.yo(paramb.azC());
    }
    super.b(paramb, paramInt);
  }
  
  protected final void initView()
  {
    super.initView();
    boolean bool = com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 69, null, null);
    y.i("MicroMsg.ShareCardListUI", "checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
    this.iqE = bool;
    if (this.iqE)
    {
      aBf();
      return;
    }
    y.e("MicroMsg.ShareCardListUI", "location permission is denied, doGetLayout");
    aBi();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    long l = System.currentTimeMillis();
    this.mStartTime = l;
    this.iqF = l;
    initView();
    g.DO().dJT.a(1164, this);
    am.aAz().a(this);
    aBk();
    am.aAA().c(this);
  }
  
  protected void onDestroy()
  {
    if (this.iqE) {
      ayX();
    }
    this.iqq.iqh = null;
    this.iqr.iqh = null;
    this.iqh.ioA = null;
    g.DO().dJT.b(1164, this);
    am.aAz().b(this);
    com.tencent.mm.plugin.card.sharecard.a.b.aAT();
    am.aAA().d(this);
    long l = System.currentTimeMillis() - this.iqF;
    if (!TextUtils.isEmpty(this.imf)) {
      h.nFQ.f(13219, new Object[] { "ShareCardListUI", Integer.valueOf(0), "", "", Long.valueOf(l) });
    }
    for (;;)
    {
      super.onDestroy();
      return;
      h.nFQ.f(13219, new Object[] { "ShareCardListUI", Integer.valueOf(1), "", "", Long.valueOf(l) });
    }
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    aBk();
    if (paramIntent != null)
    {
      this.imf = paramIntent.getStringExtra("KEY_CARD_TP_ID");
      if (!bk.bl(this.imf))
      {
        this.iqt = true;
        this.iqv = true;
      }
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    this.iqu = false;
    this.iqv = true;
  }
  
  protected void onResume()
  {
    ex(true);
    long l = System.currentTimeMillis();
    if (this.mStartTime != 0L)
    {
      int i = (int)(l - this.mStartTime);
      ArrayList localArrayList = new ArrayList();
      IDKey localIDKey1 = new IDKey();
      localIDKey1.SetID(281);
      localIDKey1.SetKey(56);
      localIDKey1.SetValue(1L);
      IDKey localIDKey2 = new IDKey();
      localIDKey2.SetID(281);
      localIDKey2.SetKey(57);
      localIDKey2.SetValue(i);
      localArrayList.add(localIDKey1);
      localArrayList.add(localIDKey2);
      h.nFQ.b(localArrayList, true);
      this.mStartTime = 0L;
    }
    super.onResume();
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    boolean bool = true;
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramm);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramm instanceof com.tencent.mm.plugin.card.sharecard.model.b))
      {
        paramString = (com.tencent.mm.plugin.card.sharecard.model.b)paramm;
        this.iqy = false;
        this.iqz = paramString.ioI;
        this.iqh.al(paramString.inn, this.iqw);
        if ((!com.tencent.mm.plugin.card.sharecard.a.b.aAU()) || (!com.tencent.mm.plugin.card.sharecard.a.b.aAV())) {
          this.iqw = false;
        }
        if ((!com.tencent.mm.plugin.card.sharecard.a.b.aAU()) || (!com.tencent.mm.plugin.card.sharecard.a.b.aAV())) {
          break label110;
        }
      }
      for (;;)
      {
        this.iqx = bool;
        y.i("MicroMsg.ShareCardListUI", "NetSceneGetShareCardsLayout() >> updateView()");
        aBg();
        return;
        label110:
        bool = false;
      }
    }
    if ((paramm instanceof com.tencent.mm.plugin.card.sharecard.model.b))
    {
      if (this.iqH)
      {
        this.iqH = false;
        this.iqr.aBc();
        this.ijF.setEmptyView(this.ijH);
        this.ijF.invalidate();
      }
      this.iqy = false;
      this.iqx = true;
    }
    y.i("MicroMsg.ShareCardListUI", "share card list ui, onSceneEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  protected final BaseAdapter xX()
  {
    return new c(this.mController.uMN);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.ShareCardListUI
 * JD-Core Version:    0.7.0.1
 */