package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.j;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.b.k;
import com.tencent.mm.plugin.card.base.CardBaseUI;
import com.tencent.mm.plugin.card.model.ad;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.n.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.lz;
import com.tencent.mm.protocal.c.mj;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

@j
public class CardHomePageUI
  extends CardBaseUI
  implements com.tencent.mm.plugin.card.base.d, j.a
{
  private int fromScene = 0;
  private boolean iqA = false;
  private boolean iqB = false;
  private long iqF = 0L;
  boolean iqG = false;
  private com.tencent.mm.plugin.card.sharecard.a.b iqh;
  private boolean iqu = false;
  private boolean iqw = true;
  private boolean iqy = false;
  private String iqz = "";
  private i iuU;
  private f iuV;
  private f iuW;
  private boolean iuX = true;
  private boolean iuY = false;
  private TextView iuZ;
  private LinearLayout iva;
  private long mStartTime = 0L;
  
  private void a(mj parammj)
  {
    this.iva.removeAllViews();
    if ((parammj != null) && (parammj.sJh != null) && (!parammj.sJh.isEmpty()))
    {
      parammj = parammj.sJh.iterator();
      while (parammj.hasNext())
      {
        lz locallz = (lz)parammj.next();
        View localView = LayoutInflater.from(this.mController.uMN).inflate(a.e.card_home_page_item, this.iva, false);
        new f(this, localView, 4, this.iqh, locallz).setOnClickListener(new CardHomePageUI.8(this, locallz));
        this.iva.addView(localView);
      }
    }
  }
  
  private void aBV()
  {
    y.i("MicroMsg.CardHomePageUI", "updateMemberCardItem()");
    Object localObject = (c)this.ijG;
    if (this.iuZ == null)
    {
      this.iuZ = ((TextView)findViewById(a.d.member_card_show_all_tv));
      this.iuZ.setOnClickListener(new CardHomePageUI.5(this));
    }
    if (((c)localObject).getCount() > 0)
    {
      this.iuZ.setVisibility(0);
      this.iuZ.setText(getString(a.g.card_show_all_member_card, new Object[] { Integer.valueOf(com.tencent.mm.plugin.card.sharecard.a.b.aAO()) }));
    }
    for (;;)
    {
      this.iuV.aBU();
      return;
      this.iuZ.setVisibility(0);
      this.iuZ.setText(getString(a.g.card_show_all_member_card, new Object[] { Integer.valueOf(com.tencent.mm.plugin.card.sharecard.a.b.aAO()) }));
      localObject = (LinearLayout)findViewById(a.d.card_home_page_header);
      if (localObject != null)
      {
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((LinearLayout)localObject).getLayoutParams();
        localLayoutParams.topMargin = com.tencent.mm.cb.a.fromDPToPix(this, 29);
        localLayoutParams.bottomMargin = com.tencent.mm.cb.a.fromDPToPix(this, 29);
        ((LinearLayout)localObject).setLayoutParams(localLayoutParams);
      }
    }
  }
  
  private static mj aBW()
  {
    String str = (String)g.DP().Dz().get(ac.a.upq, null);
    if (bk.bl(str)) {
      return null;
    }
    mj localmj = new mj();
    try
    {
      localmj.aH(str.getBytes("ISO-8859-1"));
      return localmj;
    }
    catch (IOException localIOException)
    {
      y.printErrStackTrace("MicroMsg.CardHomePageUI", localIOException, "", new Object[0]);
    }
    return null;
  }
  
  private void aBX()
  {
    Intent localIntent = new Intent();
    localIntent.addFlags(67108864);
    localIntent.putExtra("preferred_tab", 3);
    com.tencent.mm.br.d.e(this, "com.tencent.mm.ui.LauncherUI", localIntent);
    finish();
  }
  
  private void aBf()
  {
    y.d("MicroMsg.CardHomePageUI", "initLocation");
    g.DS().O(new CardHomePageUI.4(this));
  }
  
  private void aBi()
  {
    y.d("MicroMsg.CardHomePageUI", "doGetLayout() >> doNetSceneGetCardsHomePageLayout()");
    Object localObject;
    if (!this.iuX)
    {
      y.i("MicroMsg.CardHomePageUI", "doNetSceneGetCardsHomePageLayout, shouldGetHomePage is false");
      if (!com.tencent.mm.plugin.card.d.l.aDd()) {
        break label214;
      }
      int i = ((Integer)g.DP().Dz().get(ac.a.upd, Integer.valueOf(1))).intValue();
      y.i("MicroMsg.BatchGetCardMgr", "need do getCardsLayoutScene scene is " + i);
      localObject = new ad(am.aAy().dia, am.aAy().dib, i);
      g.DO().dJT.a((m)localObject, 0);
    }
    for (;;)
    {
      am.aAy().r("", "", 4);
      return;
      if (this.iqy)
      {
        y.e("MicroMsg.CardHomePageUI", "doNetSceneGetCardsHomePageLayout, isDoingGetData is true");
        break;
      }
      if ((this.iqw) && (!bk.bl(this.iqz))) {
        this.iqz = "";
      }
      this.iqy = true;
      this.iuX = false;
      localObject = new com.tencent.mm.plugin.card.sharecard.model.b(am.aAy().dia, am.aAy().dib, this.iqz);
      g.DO().dJT.a((m)localObject, 0);
      break;
      label214:
      y.i("MicroMsg.CardHomePageUI", "the card entrance is not open, don't do doNetSceneGetCardsLayout!");
    }
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
      h.nFQ.f(11324, new Object[] { "CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(2), Integer.valueOf(i), "", Integer.valueOf(0), str });
      return;
    }
    if (bool2)
    {
      h.nFQ.f(11324, new Object[] { "CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(1), Integer.valueOf(i), "", Integer.valueOf(0), str });
      return;
    }
    if ((bool3) && (!bool4))
    {
      h.nFQ.f(11324, new Object[] { "CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(3), Integer.valueOf(i), "", Integer.valueOf(0), str });
      return;
    }
    if ((bool3) && (bool4))
    {
      h.nFQ.f(11324, new Object[] { "CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(4), Integer.valueOf(i), "", Integer.valueOf(0), str });
      return;
    }
    if (bool4)
    {
      h.nFQ.f(11324, new Object[] { "CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(5), Integer.valueOf(i), "", Integer.valueOf(0), str });
      return;
    }
    h.nFQ.f(11324, new Object[] { "CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(i), "", Integer.valueOf(0), str });
  }
  
  private void aZ()
  {
    y.i("MicroMsg.CardHomePageUI", "updateView()");
    this.iuU.aCb();
    aBV();
    this.iuW.aZ();
  }
  
  protected final void a(com.tencent.mm.plugin.card.base.b paramb)
  {
    super.a(paramb);
  }
  
  public final void a(String paramString, com.tencent.mm.sdk.e.l paraml)
  {
    this.iqu = true;
  }
  
  protected final void ayQ()
  {
    setMMTitle(a.g.card_home_page_title);
    addTextOptionMenu(0, getString(a.g.card_msg_center), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        com.tencent.mm.plugin.card.d.b.a(CardHomePageUI.this, true);
        h.nFQ.f(11582, new Object[] { "CardListMsgMenu", Integer.valueOf(2), Integer.valueOf(0), "", "" });
        return true;
      }
    });
    this.iqh = new com.tencent.mm.plugin.card.sharecard.a.b(this);
    this.iqh.init();
    if (this.iuU == null)
    {
      this.iuU = new i(this, this.mController.contentView);
      localObject = this.iuU;
      ((i)localObject).ivW = View.inflate(((i)localObject).hxN, a.e.card_msg_tip_header, null);
      ((i)localObject).ivW.setVisibility(8);
      ((i)localObject).ivX = ((TextView)((i)localObject).ivW.findViewById(a.d.card_index_new_msg_tv));
      ((i)localObject).ivY = ((ImageView)((i)localObject).ivW.findViewById(a.d.card_index_new_msg_img));
      ((i)localObject).ivW.setOnClickListener(new i.1((i)localObject));
      ((i)localObject).aCb();
      if (((i)localObject).ivZ == null)
      {
        ((i)localObject).ivZ = ((ViewStub)((i)localObject).ipf.findViewById(a.d.card_msg_layout_stub)).inflate();
        ((i)localObject).ivZ.setVisibility(8);
        ((i)localObject).iwa = ((TextView)((i)localObject).ivZ.findViewById(a.d.card_index_new_msg_tv));
        ((i)localObject).iwb = ((ImageView)((i)localObject).ivZ.findViewById(a.d.card_index_new_msg_img));
        ((i)localObject).ivZ.setOnClickListener(new i.2((i)localObject));
      }
      this.iuU.iqM = true;
    }
    if (this.iuV == null) {
      this.iuV = new f(this, findViewById(a.d.card_member_card_item), 1, this.iqh);
    }
    if (this.iuW == null) {
      this.iuW = new f(this, findViewById(a.d.card_ticket_item), 3, this.iqh);
    }
    if (this.iuV != null) {
      this.iuV.setOnClickListener(new CardHomePageUI.6(this));
    }
    if (this.iuW != null) {
      this.iuW.setOnClickListener(new CardHomePageUI.7(this));
    }
    this.iva = ((LinearLayout)findViewById(a.d.card_common_item_layout));
    Object localObject = aBW();
    if (localObject != null) {
      a((mj)localObject);
    }
    setBackBtn(new CardHomePageUI.3(this));
  }
  
  protected final n.a ayR()
  {
    return n.a.ink;
  }
  
  protected final boolean ayS()
  {
    return super.ayS();
  }
  
  protected final boolean ayT()
  {
    return true;
  }
  
  protected final void ayY()
  {
    if (this.iqA)
    {
      y.e("MicroMsg.CardHomePageUI", "onLocationFinish, has do GetShareCardLayout,don't get again");
      if (this.iuY) {
        ayX();
      }
      return;
    }
    y.d("MicroMsg.CardHomePageUI", "onLocationFinish()");
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
    y.i("MicroMsg.CardHomePageUI", "onLocationFail()");
    aBi();
  }
  
  public final void azI()
  {
    this.iqu = true;
  }
  
  protected final void aza()
  {
    y.i("MicroMsg.CardHomePageUI", "onMPermissionGranted locationPermissionGranted " + this.iuY);
    if (!this.iuY)
    {
      this.iuY = true;
      aBf();
    }
  }
  
  protected final void azb()
  {
    aBV();
  }
  
  protected final void b(com.tencent.mm.plugin.card.base.b paramb, int paramInt)
  {
    super.b(paramb, paramInt);
  }
  
  protected final int getLayoutId()
  {
    return a.e.card_home_page_ui;
  }
  
  protected final void initView()
  {
    boolean bool = com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 69, null, null);
    y.i("MicroMsg.CardHomePageUI", "checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
    this.iuY = bool;
    if (this.iuY) {
      aBf();
    }
    for (;;)
    {
      super.initView();
      return;
      y.e("MicroMsg.CardHomePageUI", "location permission is denied, doGetLayout");
      aBi();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.fromScene = getIntent().getIntExtra("key_home_page_from_scene", 0);
    long l = System.currentTimeMillis();
    this.mStartTime = l;
    this.iqF = l;
    initView();
    paramBundle = this.iuU;
    am.aAw().a(paramBundle);
    g.DO().dJT.a(1164, this);
    g.DO().dJT.a(984, this);
    am.aAz().aAN();
    am.aAr();
    com.tencent.mm.plugin.card.b.b.oM(1);
    aBk();
    Looper.myQueue().addIdleHandler(new CardHomePageUI.9(this));
    am.aAz().a(this);
    am.aAs().c(this);
  }
  
  protected void onDestroy()
  {
    if (this.iuY) {
      ayX();
    }
    i locali = this.iuU;
    am.aAw().b(locali);
    this.iqh.ioA = null;
    g.DO().dJT.b(1164, this);
    g.DO().dJT.b(984, this);
    am.aAz().b(this);
    am.aAs().d(this);
    k.aAg();
    com.tencent.mm.plugin.card.sharecard.a.b.aAT();
    long l1 = System.currentTimeMillis();
    long l2 = this.iqF;
    h.nFQ.f(13219, new Object[] { "CardHomePageUI", Integer.valueOf(this.fromScene), "", "", Long.valueOf(l1 - l2) });
    super.onDestroy();
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if ((this.fromScene != 1) && (this.fromScene != 2)) {
        break label32;
      }
      aBX();
    }
    for (;;)
    {
      return super.onKeyUp(paramInt, paramKeyEvent);
      label32:
      finish();
    }
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    aBk();
    this.iqu = true;
    this.iuX = true;
  }
  
  protected void onPause()
  {
    super.onPause();
  }
  
  protected void onResume()
  {
    y.i("MicroMsg.CardHomePageUI", "onResume locationPermissionGranted %s, hasInitLocation %s, shouldGetLayout %s", new Object[] { Boolean.valueOf(this.iuY), Boolean.valueOf(this.iqG), Boolean.valueOf(this.iqu) });
    if ((this.iuY) && (this.iqG) && (this.iqu))
    {
      this.iqz = "";
      this.iqA = false;
      ayW();
    }
    for (;;)
    {
      this.iqu = false;
      aZ();
      long l = System.currentTimeMillis();
      if (this.mStartTime != 0L)
      {
        int i = (int)(l - this.mStartTime);
        ArrayList localArrayList = new ArrayList();
        IDKey localIDKey1 = new IDKey();
        localIDKey1.SetID(281);
        localIDKey1.SetKey(0);
        localIDKey1.SetValue(1L);
        IDKey localIDKey2 = new IDKey();
        localIDKey2.SetID(281);
        localIDKey2.SetKey(1);
        localIDKey2.SetValue(i);
        localArrayList.add(localIDKey1);
        localArrayList.add(localIDKey2);
        h.nFQ.b(localArrayList, true);
        this.mStartTime = 0L;
      }
      g.DS().O(new CardHomePageUI.1(this));
      super.onResume();
      return;
      if (this.iqu)
      {
        this.iqz = "";
        aBi();
      }
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramm);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramm instanceof ad))
      {
        aBV();
        this.ijM.HL();
        this.iuW.aZ();
        a(((ad)paramm).inF);
      }
      while (!(paramm instanceof com.tencent.mm.plugin.card.sharecard.model.b)) {
        return;
      }
      paramString = (com.tencent.mm.plugin.card.sharecard.model.b)paramm;
      this.iqy = false;
      this.iqz = paramString.ioI;
      this.iqh.al(paramString.inn, this.iqw);
      if ((!com.tencent.mm.plugin.card.sharecard.a.b.aAU()) || (!com.tencent.mm.plugin.card.sharecard.a.b.aAV())) {
        this.iqw = false;
      }
      y.i("MicroMsg.CardHomePageUI", "NetSceneGetShareCardsLayout() >> updateView()");
      aZ();
      return;
    }
    if ((paramm instanceof com.tencent.mm.plugin.card.sharecard.model.b)) {
      this.iqy = false;
    }
    y.i("MicroMsg.CardHomePageUI", "share card list ui, onSceneEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardHomePageUI
 * JD-Core Version:    0.7.0.1
 */