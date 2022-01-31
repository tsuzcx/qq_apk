package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.ah.m;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.b;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.am.b;
import com.tencent.mm.model.am.b.a;
import com.tencent.mm.plugin.emoji.e.j.2;
import com.tencent.mm.plugin.emoji.e.l;
import com.tencent.mm.plugin.emoji.f.e;
import com.tencent.mm.plugin.emoji.f.f;
import com.tencent.mm.plugin.emoji.f.g;
import com.tencent.mm.plugin.emoji.f.h;
import com.tencent.mm.plugin.emoji.f.q;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.h.a;
import com.tencent.mm.plugin.emoji.model.h.b;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.emoji.BannerEmojiView;
import com.tencent.mm.protocal.c.aeu;
import com.tencent.mm.protocal.c.aix;
import com.tencent.mm.protocal.c.bel;
import com.tencent.mm.protocal.c.ut;
import com.tencent.mm.protocal.c.vn;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.c;
import com.tencent.mm.ui.base.MMPullDownView.e;
import com.tencent.mm.ui.s;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class EmojiStoreV2DesignerUI
  extends MMActivity
  implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener, com.tencent.mm.ah.f, h.a, h.b, MMPullDownView.c, MMPullDownView.e
{
  private ListView Nn;
  private View VH;
  private int fzn;
  private boolean gDQ;
  private long iYu;
  private String iYv;
  private String iYz;
  private String iZQ;
  private com.tencent.mm.plugin.emoji.model.f jbB;
  private com.tencent.mm.plugin.emoji.model.h jbC;
  private c jbE = new EmojiStoreV2DesignerUI.1(this);
  private com.tencent.mm.plugin.emoji.f.h jbF;
  com.tencent.mm.plugin.emoji.a.f jbM;
  private int jbn = -1;
  private byte[] jbp;
  protected final int jbt = 131074;
  private final int jbu = 131075;
  private final int jbv = 131076;
  private final String jbw = "product_id";
  private final String jbx = "progress";
  private final String jby = "status";
  private d jgA;
  View jgB;
  View jgC;
  View jgD;
  TextView jgE;
  View jgF;
  private MMPullDownView jgG;
  private aix jgH;
  private com.tencent.mm.plugin.emoji.f.j jgI;
  private com.tencent.mm.ui.base.p jgJ;
  private am.b.a jgK = new EmojiStoreV2DesignerUI.8(this);
  private final int jgL = 10001;
  private final int jgM = 10002;
  private final int jgN = 10003;
  private q jgO;
  private int jgi;
  private String jgj;
  private String jgk;
  private ad jgl;
  private View jgm;
  private BannerEmojiView jgn;
  private TextView jgo;
  private TextView jgp;
  private View jgq;
  private View jgr;
  private TextView jgs;
  private ImageView jgt;
  private TextView jgu;
  private TextView jgv;
  View jgw;
  private List<ut> jgx = new ArrayList();
  private View jgy;
  PreViewListGridView jgz;
  private ah mHandler = new EmojiStoreV2DesignerUI.9(this);
  
  private void aJz()
  {
    if ((this.jgl != null) && ((int)this.jgl.dBe != 0))
    {
      this.jgr.setVisibility(0);
      this.jgq.setVisibility(0);
      if (!bk.bl(this.jgl.Bp())) {
        this.jgs.setText(this.jgl.Bp());
      }
      for (;;)
      {
        a.b.n(this.jgt, this.jgl.field_username);
        this.jgu.setEnabled(true);
        return;
        this.jgs.setText(this.jgl.field_username);
      }
    }
    this.jgr.setVisibility(8);
    this.jgq.setVisibility(8);
  }
  
  private void am(byte[] paramArrayOfByte)
  {
    this.gDQ = true;
    this.jgO = new q(this.jgi, paramArrayOfByte);
    com.tencent.mm.kernel.g.DO().dJT.a(this.jgO, 0);
  }
  
  private void b(int paramInt, com.tencent.mm.plugin.emoji.model.f paramf)
  {
    int i = 1;
    switch (paramInt)
    {
    default: 
      paramInt = 0;
    }
    for (;;)
    {
      if ((this.jbB != null) && (paramInt != 0))
      {
        if (this.jbM != null) {
          this.jbM.b(this.jbB);
        }
        if (this.mHandler != null) {
          this.mHandler.sendEmptyMessage(10002);
        }
      }
      return;
      this.jbB = paramf;
      paramInt = i;
      continue;
      this.jbB = paramf;
      paramInt = i;
      continue;
      this.jbB = paramf;
      paramInt = i;
      continue;
      if (this.jbB == null) {
        this.jbB = new com.tencent.mm.plugin.emoji.model.f();
      }
      this.jbB.pV(paramf.iYg);
      this.jbB.aZ(paramf.iYh);
      paramInt = i;
    }
  }
  
  private void bb(List<ut> paramList)
  {
    int i = 1;
    String str = com.tencent.mm.m.g.AA().getValue("ShowDesignerEmoji");
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "get dynamic Disgner_Emoji_Store_Show config value:%s", new Object[] { str });
    if ((!bk.bl(str)) && (bk.ZR(str) == 1)) {}
    while ((paramList != null) && (paramList.size() > 0) && (i != 0))
    {
      this.jgw.setVisibility(0);
      if (this.mHandler != null) {
        this.mHandler.post(new EmojiStoreV2DesignerUI.2(this, paramList));
      }
      this.jgA.bc(paramList);
      return;
      i = 0;
    }
    this.jgw.setVisibility(8);
  }
  
  private void c(com.tencent.mm.plugin.emoji.model.f paramf)
  {
    b(this.jbn, paramf);
    this.jbn = 0;
  }
  
  private void updateData()
  {
    if (this.jgH == null)
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "update data failed. data is null.");
      return;
    }
    fl(true);
    if (!bk.bl(this.jgH.sAD))
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "biz name is :%s", new Object[] { this.jgH.sAD });
      this.jgl = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(this.jgH.sAD);
      if (((this.jgl == null) || ((int)this.jgl.dBe == 0)) && (am.a.dVy != null))
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "getContact %s", new Object[] { this.jgH.sAD });
        am.a.dVy.a(this.jgH.sAD, "", this.jgK);
      }
      this.jgu.setText(f.h.emoji_store_weixin);
      if (bk.bl(this.jgH.kRN)) {
        break label278;
      }
      this.jgp.setText(this.jgH.kRN);
      this.jgp.setVisibility(0);
    }
    for (;;)
    {
      aJz();
      if ((this.jbB != null) && (this.jbB.iYh != null) && (!this.jbB.iYh.isEmpty())) {
        break label290;
      }
      this.jgv.setVisibility(8);
      return;
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.emoji.EmojiStoreV2DesignerUI", "mData.BizName is null");
      this.jgq.setVisibility(8);
      this.jgr.setVisibility(8);
      break;
      label278:
      this.jgp.setVisibility(8);
    }
    label290:
    this.jgv.setVisibility(0);
  }
  
  private void xK()
  {
    setMMTitle(this.iYz);
    this.jbM = new com.tencent.mm.plugin.emoji.a.f(this.mController.uMN);
    this.Nn.addHeaderView(this.VH);
    this.Nn.setAdapter(this.jbM);
    this.jbM.iVJ = this;
    this.jbM.iVg = l.aHz();
    this.jbM.iVh = false;
    this.jgo.setText(this.iYz);
    this.jgH = i.getEmojiStorageMgr().uBe.acL(String.valueOf(this.jgi));
    this.jbC = new com.tencent.mm.plugin.emoji.model.h();
    this.jbC.hxz = this;
    this.jbC.iYq = this.jbM;
    this.jbC.iYt = 6;
    this.jbC.iYw = this;
    this.jbC.iYz = this.iYz;
    this.jbC.iYu = this.iYu;
    this.jbC.iYv = this.iYv;
    if (this.jgH != null)
    {
      c(q.a(this.jgH));
      LinkedList localLinkedList1 = this.jgH.sAu;
      LinkedList localLinkedList2 = this.jgH.tda;
      bb(localLinkedList1);
    }
    updateData();
    am(this.jbp);
  }
  
  protected final com.tencent.mm.plugin.emoji.f.h K(String paramString1, String paramString2, String paramString3)
  {
    this.jbF = new com.tencent.mm.plugin.emoji.f.h(paramString1, paramString2, paramString3);
    return this.jbF;
  }
  
  public final void a(com.tencent.mm.plugin.emoji.a.a parama)
  {
    String str2 = parama.getProductId();
    if (TextUtils.isEmpty(parama.aGI())) {}
    for (String str1 = "";; str1 = parama.aGI())
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "[onProductClick] productId:%s, productPrice:%s, productStatus:%d", new Object[] { str2, str1, Integer.valueOf(parama.aGH()) });
      parama.aGH();
      this.jbC.a(parama);
      return;
    }
  }
  
  public final boolean aEU()
  {
    return true;
  }
  
  public final boolean aEW()
  {
    return false;
  }
  
  public final void aHM() {}
  
  protected final void aIH()
  {
    com.tencent.mm.kernel.g.DO().dJT.a(this.jbF, 0);
  }
  
  final void bt(String paramString, int paramInt)
  {
    Message localMessage = Message.obtain();
    localMessage.getData().putString("product_id", paramString);
    localMessage.getData().putInt("status", paramInt);
    localMessage.what = 131076;
    if (this.mHandler != null) {
      this.mHandler.sendMessage(localMessage);
    }
  }
  
  final void bu(String paramString, int paramInt)
  {
    Message localMessage = Message.obtain();
    localMessage.getData().putString("product_id", paramString);
    localMessage.getData().putInt("progress", paramInt);
    localMessage.what = 131075;
    if (this.mHandler != null) {
      this.mHandler.sendMessage(localMessage);
    }
  }
  
  protected final void fl(boolean paramBoolean)
  {
    if (this.jgH == null) {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "update header failed. data is null.");
    }
    while ((this.jgn == null) || (bk.bl(this.jgH.tfJ))) {
      return;
    }
    Object localObject = this.jgH.tfJ;
    com.tencent.mm.cb.a.getDensity(this);
    localObject = EmojiLogic.t("Designer", 8, (String)localObject);
    if (localObject == null)
    {
      if (paramBoolean)
      {
        com.tencent.mm.as.o.ON().a(this.jgH.tfJ, null, com.tencent.mm.plugin.emoji.e.e.h("Designer", this.jgH.tfJ, new Object[] { "Designer", "BANNER" }), new EmojiStoreV2DesignerUI.15(this));
        return;
      }
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "updateDesignerHeader failed");
      return;
    }
    this.jgn.setImageFilePath(((EmojiInfo)localObject).cwL());
  }
  
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  protected final int getLayoutId()
  {
    return f.f.emoji_store_v2_designer_ui;
  }
  
  public final void i(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    K(paramString1, paramString2, paramString3);
    aIH();
  }
  
  protected final void initView()
  {
    if (!bk.bl(this.iYz)) {
      setMMTitle(this.iYz);
    }
    this.VH = com.tencent.mm.ui.y.gt(this.mController.uMN).inflate(f.f.emoji_store_v2_designer_header, null);
    this.jgm = this.VH.findViewById(f.e.designer_header);
    this.jgn = ((BannerEmojiView)this.jgm.findViewById(f.e.emoji_bar_view));
    this.jgo = ((TextView)this.VH.findViewById(f.e.designer_name));
    this.jgp = ((TextView)this.VH.findViewById(f.e.designer_desc));
    this.jgq = this.VH.findViewById(f.e.designer_bar_line);
    this.jgr = this.VH.findViewById(f.e.designer_bar_container);
    this.jgs = ((TextView)this.VH.findViewById(f.e.designer_title));
    this.jgt = ((ImageView)this.VH.findViewById(f.e.designer_icon));
    this.jgu = ((TextView)this.VH.findViewById(f.e.designer_detail));
    this.jgv = ((TextView)this.VH.findViewById(f.e.designer_works));
    this.jgw = this.VH.findViewById(f.e.designer_product);
    this.jgy = this.VH.findViewById(f.e.designer_product_more);
    this.jgy.setOnClickListener(new EmojiStoreV2DesignerUI.10(this));
    this.jgz = ((PreViewListGridView)this.VH.findViewById(f.e.designer_product_list));
    this.jgA = new d(this.mController.uMN);
    this.jgA.jjt = new EmojiStoreV2DesignerUI.11(this);
    this.jgz.setAdapter(this.jgA);
    this.jgB = this.VH.findViewById(f.e.designer_product_title);
    this.jgC = this.VH.findViewById(f.e.designer_product_title_tv);
    this.jgD = this.VH.findViewById(f.e.designer_product_more);
    this.jgE = ((TextView)this.VH.findViewById(f.e.designer_single_product));
    this.jgF = this.VH.findViewById(f.e.designer_product_divider);
    this.jgG = ((MMPullDownView)findViewById(f.e.load_more_pull_view));
    this.jgG.setOnBottomLoadDataListener(this);
    this.jgG.setAtBottomCallBack(this);
    this.jgG.setBottomViewVisible(false);
    this.jgG.setIsBottomShowAll(false);
    this.Nn = ((ListView)findViewById(16908298));
    this.Nn.setOnItemClickListener(this);
    this.Nn.setOnScrollListener(this);
    this.jgr.setOnClickListener(new EmojiStoreV2DesignerUI.12(this));
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        EmojiStoreV2DesignerUI.this.finish();
        return false;
      }
    });
    addIconOptionMenu(0, f.g.ofm_send_icon, new EmojiStoreV2DesignerUI.14(this));
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.jbC.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 2002) && (paramInt2 == -1))
    {
      String str1 = paramIntent.getStringExtra("Select_Conv_User");
      if ((bk.bl(str1)) || (this.jgH == null)) {
        break label219;
      }
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.emoji.EmojiStoreV2DesignerUI", ".." + str1);
      String str2 = this.iYz;
      String str3 = this.jgH.kRN;
      int i = this.jgi;
      String str4 = this.jgk;
      String str5 = this.iYz;
      String str6 = this.jgH.sSy;
      String str7 = getResources().getString(f.h.app_designer_share);
      str7 = str7 + str2;
      String str8 = getString(f.h.app_send);
      String str9 = getString(f.h.confirm_dialog_edittext_hint);
      ((com.tencent.mm.pluginsdk.h)com.tencent.mm.kernel.g.r(com.tencent.mm.pluginsdk.h.class)).a(this, str1, str7, str8, str9, str6, new j.2(str1, str5, str3, i, str4, str2, str6, this));
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      label219:
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "member or data is null.");
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.iZQ = getIntent().getStringExtra("id");
    this.jgi = getIntent().getIntExtra("uin", 0);
    this.iYz = getIntent().getStringExtra("name");
    this.jgj = getIntent().getStringExtra("headurl");
    this.jgk = getIntent().getStringExtra("rediret_url");
    this.fzn = getIntent().getIntExtra("extra_scence", 0);
    this.iYu = getIntent().getLongExtra("searchID", 0L);
    this.iYv = bk.aM(getIntent().getStringExtra("docID"), "");
    paramBundle = getIntent().getStringExtra("sns_object_data");
    if (!TextUtils.isEmpty(paramBundle))
    {
      this.jgi = EmojiLogic.AB(paramBundle);
      this.iYz = EmojiLogic.AC(paramBundle);
      this.jgk = EmojiLogic.AI(paramBundle);
    }
    initView();
    int i;
    if (!bk.bl(this.iZQ))
    {
      paramBundle = i.getEmojiStorageMgr().uBh.acG(this.iZQ);
      if ((paramBundle != null) && (paramBundle.tcO != null) && (paramBundle.tcO.tcH != 0) && (!bk.bl(paramBundle.tcO.kRZ)))
      {
        this.jgi = paramBundle.tcO.tcH;
        this.iYz = paramBundle.tcO.kRZ;
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "uin:%s name:%s", new Object[] { Integer.valueOf(this.jgi), this.iYz });
      }
    }
    else
    {
      i = 0;
      if (i != 0) {
        break label440;
      }
      xK();
    }
    for (;;)
    {
      com.tencent.mm.kernel.g.DO().dJT.a(239, this);
      com.tencent.mm.kernel.g.DO().dJT.a(720, this);
      com.tencent.mm.sdk.b.a.udP.c(this.jbE);
      com.tencent.mm.plugin.report.service.h.nFQ.f(12067, new Object[] { Integer.valueOf(1), "", "", "", "" });
      com.tencent.mm.plugin.report.service.h.nFQ.f(12740, new Object[] { Integer.valueOf(2), com.tencent.mm.a.o.getString(this.jgi), "", "", Integer.valueOf(this.fzn), Integer.valueOf(6) });
      return;
      i = 1;
      break;
      label440:
      this.jgI = new com.tencent.mm.plugin.emoji.f.j(this.iZQ);
      com.tencent.mm.kernel.g.DO().dJT.a(this.jgI, 0);
      getString(f.h.app_tip);
      this.jgJ = com.tencent.mm.ui.base.h.b(this, getString(f.h.app_waiting), true, new EmojiStoreV2DesignerUI.7(this));
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.jgO != null) {
      com.tencent.mm.kernel.g.DO().dJT.c(this.jgO);
    }
    com.tencent.mm.kernel.g.DO().dJT.b(239, this);
    com.tencent.mm.kernel.g.DO().dJT.b(720, this);
    com.tencent.mm.sdk.b.a.udP.d(this.jbE);
    if (this.mHandler != null)
    {
      this.mHandler.removeMessages(10002);
      this.mHandler.removeMessages(10001);
      this.mHandler = null;
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject;
    if (this.jbM != null)
    {
      int i = this.Nn.getHeaderViewsCount();
      paramAdapterView = this.jbM.pP(paramInt - i);
      if (paramAdapterView != null)
      {
        paramView = new Intent();
        paramView.setClass(this, EmojiStoreDetailUI.class);
        localObject = paramAdapterView.iVU;
        if (localObject != null) {
          break label72;
        }
        paramAdapterView = null;
      }
    }
    for (;;)
    {
      if (paramAdapterView != null) {
        startActivity(paramAdapterView);
      }
      return;
      label72:
      paramView.putExtra("extra_id", ((vn)localObject).syc);
      paramView.putExtra("extra_name", ((vn)localObject).sSc);
      paramView.putExtra("extra_copyright", ((vn)localObject).sSm);
      paramView.putExtra("extra_coverurl", ((vn)localObject).sSk);
      paramView.putExtra("extra_description", ((vn)localObject).sSd);
      paramView.putExtra("extra_price", ((vn)localObject).sSf);
      paramView.putExtra("extra_type", ((vn)localObject).sSg);
      paramView.putExtra("extra_flag", ((vn)localObject).sSh);
      paramView.putExtra("preceding_scence", 106);
      paramView.putExtra("download_entrance_scene", 6);
      paramView.putExtra("call_by", 1);
      paramView.putExtra("check_clickflag", false);
      paramView.putExtra("extra_status", paramAdapterView.mStatus);
      paramView.putExtra("extra_progress", paramAdapterView.xL);
      paramView.putExtra("searchID", this.iYu);
      localObject = getIntent().getStringExtra("to_talker_name");
      paramAdapterView = paramView;
      if (!bk.bl((String)localObject))
      {
        paramView.putExtra("to_talker_name", (String)localObject);
        paramAdapterView = paramView;
      }
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    com.tencent.mm.kernel.g.DO().dJT.b(423, this);
  }
  
  protected void onResume()
  {
    super.onResume();
    com.tencent.mm.kernel.g.DO().dJT.a(423, this);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    switch (paramm.getType())
    {
    default: 
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.emoji.EmojiStoreV2DesignerUI", "unknow scene type");
    }
    do
    {
      do
      {
        return;
        paramString = (com.tencent.mm.plugin.emoji.f.h)paramm;
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          bu(paramString.iZD, 0);
          return;
        }
        paramm = paramString.iZD;
        Object localObject = paramString.iZF;
        String str = paramString.iZE;
        com.tencent.mm.ui.base.h.a(this, getString(f.h.emoji_store_download_failed_msg, new Object[] { str }), "", new EmojiStoreV2DesignerUI.3(this, paramm, (String)localObject, str), new EmojiStoreV2DesignerUI.4(this));
        bt(paramString.iZD, -1);
        return;
        this.gDQ = false;
        if ((paramInt1 == 0) || (paramInt1 == 4))
        {
          paramString = (q)paramm;
          paramm = q.a(paramString.aIl());
          if (paramInt2 == 0)
          {
            this.jgH = paramString.aIl();
            c(paramm);
          }
          for (;;)
          {
            if ((this.jbp == null) && (this.jgH != null))
            {
              i.getEmojiStorageMgr().uBe.a(String.valueOf(this.jgi), paramString.aIl());
              this.jgx = this.jgH.sAu;
              paramm = this.jgx;
              localObject = this.jgH.tda;
              bb(paramm);
            }
            this.jbp = paramString.iZW;
            return;
            if (paramInt2 == 2)
            {
              this.jgH = paramString.aIl();
              b(this.jbn, paramm);
              this.jbn = 2;
            }
            else if (paramInt2 == 3)
            {
              this.jgH = paramString.aIl();
              b(this.jbn, paramm);
              this.jbn = 1;
              com.tencent.mm.sdk.platformtools.y.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "get person designer failed errCode:%d", new Object[] { Integer.valueOf(paramInt2) });
            }
          }
        }
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "get person designer failed");
        return;
        if ((this.jgJ != null) && (this.jgJ.isShowing())) {
          this.jgJ.dismiss();
        }
        if ((paramInt2 != 0) || (paramInt1 != 0)) {
          break;
        }
        paramString = ((com.tencent.mm.plugin.emoji.f.j)paramm).aIe();
      } while ((paramString == null) || (paramString.tcO == null));
      this.jgi = paramString.tcO.tcH;
      this.iYz = paramString.tcO.kRZ;
      this.jgj = paramString.tcO.sSy;
    } while (this.mHandler == null);
    this.mHandler.sendEmptyMessage(10003);
    return;
    showOptionMenu(0, false);
    com.tencent.mm.ui.base.h.b(this.mController.uMN, getString(f.h.emoji_designer_load_failed), null, true);
    com.tencent.mm.sdk.platformtools.y.e("MicroMsg.emoji.EmojiStoreV2DesignerUI", "open designer failed .");
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1))
    {
      if ((this.jbn == 0) || (this.gDQ)) {
        com.tencent.mm.sdk.platformtools.y.d("MicroMsg.emoji.EmojiStoreV2DesignerUI", "No More List.");
      }
    }
    else {
      return;
    }
    am(this.jbp);
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "[onScrollStateChanged] startLoadRemoteEmoji.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI
 * JD-Core Version:    0.7.0.1
 */