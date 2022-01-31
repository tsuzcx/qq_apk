package com.tencent.mm.plugin.emoji.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.ah.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.a.a.f.a;
import com.tencent.mm.plugin.emoji.e.k;
import com.tencent.mm.plugin.emoji.f.e;
import com.tencent.mm.plugin.emoji.f.f;
import com.tencent.mm.plugin.emoji.f.h;
import com.tencent.mm.plugin.emoji.f.o;
import com.tencent.mm.plugin.emoji.f.r;
import com.tencent.mm.plugin.emoji.model.h.b;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.pluginsdk.model.n;
import com.tencent.mm.pluginsdk.ui.emoji.StoreBannerEmojiView;
import com.tencent.mm.protocal.c.afi;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.vc;
import com.tencent.mm.protocal.c.ve;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.at;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.c;
import com.tencent.mm.ui.base.MMPullDownView.d;
import com.tencent.mm.ui.base.MMPullDownView.e;
import com.tencent.mm.ui.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public abstract class BaseEmojiStoreUI
  extends EmojiBaseActivity
  implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener, com.tencent.mm.ah.f, com.tencent.mm.plugin.emoji.model.h.a, h.b, com.tencent.mm.pluginsdk.model.h.a, j.a, MMPullDownView.c, MMPullDownView.d, MMPullDownView.e
{
  private static Map<String, Long> jbD;
  protected ListView Nn;
  private ProgressDialog faz;
  private boolean gDQ;
  protected View hrf;
  com.tencent.mm.plugin.emoji.a.a.a iYq;
  private com.tencent.mm.plugin.emoji.h.c iYy;
  private int jbA;
  private com.tencent.mm.plugin.emoji.model.f jbB;
  private com.tencent.mm.plugin.emoji.model.h jbC;
  private com.tencent.mm.sdk.b.c jbE;
  protected com.tencent.mm.plugin.emoji.f.h jbF;
  protected boolean jbG = false;
  private LinkedList<vc> jbH = new LinkedList();
  private LinkedList<ve> jbI = new LinkedList();
  protected EmojiStoreVpHeader jbh;
  protected View jbi;
  protected StoreBannerEmojiView jbj;
  protected MMPullDownView jbk;
  protected TextView jbl;
  protected boolean jbm = false;
  int jbn = -1;
  private View jbo;
  byte[] jbp;
  private final int jbq = 65537;
  private final int jbr = 20001;
  private final int jbs = 2002;
  protected final int jbt = 131074;
  private final int jbu = 131075;
  private final int jbv = 131076;
  private final String jbw = "product_id";
  private final String jbx = "progress";
  private final String jby = "status";
  private o jbz;
  
  private void a(int paramInt, com.tencent.mm.plugin.emoji.model.f paramf, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = false;
    y.d("MicroMsg.emoji.BaseEmojiStoreUI", "");
    boolean bool1 = bool2;
    switch (paramInt)
    {
    default: 
      bool1 = bool2;
    case 0: 
      if (this.jbB != null) {
        this.jbB.aHL();
      }
      a(bool1, this.jbB, paramBoolean1, paramBoolean2);
      return;
    case -1: 
      this.jbB = paramf;
    }
    for (;;)
    {
      bool1 = true;
      break;
      this.jbB = paramf;
      continue;
      if (this.jbB == null) {
        this.jbB = new com.tencent.mm.plugin.emoji.model.f();
      }
      if (paramf != null)
      {
        this.jbB.pV(paramf.iYg);
        this.jbB.aZ(paramf.iYh);
      }
    }
  }
  
  private void aID()
  {
    com.tencent.mm.plugin.emoji.a.a.b.a(this.iYq.iVI, this);
  }
  
  private void b(afi paramafi)
  {
    if (this.jbn == -1)
    {
      Message localMessage = Message.obtain();
      localMessage.what = 65537;
      localMessage.obj = paramafi;
      if (this.jcs != null) {
        this.jcs.sendMessage(localMessage);
      }
    }
  }
  
  private void bt(String paramString, int paramInt)
  {
    Message localMessage = Message.obtain();
    localMessage.getData().putString("product_id", paramString);
    localMessage.getData().putInt("status", paramInt);
    localMessage.what = 131076;
    j(localMessage);
  }
  
  private void bu(String paramString, int paramInt)
  {
    Message localMessage = Message.obtain();
    localMessage.getData().putString("product_id", paramString);
    localMessage.getData().putInt("progress", paramInt);
    localMessage.what = 131075;
    j(localMessage);
  }
  
  protected void AW(String paramString) {}
  
  protected final void VZ()
  {
    if (isFinishing())
    {
      y.i("MicroMsg.emoji.BaseEmojiStoreUI", "[showLoadingDialog] acitivity is finished.");
      return;
    }
    getString(f.h.app_tip);
    this.faz = com.tencent.mm.ui.base.h.b(this, getString(f.h.app_waiting), true, new BaseEmojiStoreUI.3(this));
  }
  
  public final void a(com.tencent.mm.plugin.emoji.a.a parama)
  {
    String str2 = parama.getProductId();
    String str1;
    if (TextUtils.isEmpty(parama.aGI()))
    {
      str1 = "";
      y.i("MicroMsg.emoji.BaseEmojiStoreUI", "[onProductClick] productId:%s, productPrice:%s, productStatus:%d", new Object[] { str2, str1, Integer.valueOf(parama.aGH()) });
      if (parama.aGH() == 9)
      {
        str1 = getString(f.h.app_uninstalling);
        if (!isFinishing()) {
          break label97;
        }
        y.i("MicroMsg.emoji.BaseEmojiStoreUI", "[showLoadingDialog] acitivity is finished.");
      }
    }
    for (;;)
    {
      this.jbC.a(parama);
      return;
      str1 = parama.aGI();
      break;
      label97:
      getString(f.h.app_tip);
      this.faz = com.tencent.mm.ui.base.h.b(this, str1, true, new BaseEmojiStoreUI.4(this));
    }
  }
  
  protected void a(com.tencent.mm.plugin.emoji.f.h paramh)
  {
    bu(paramh.iZD, 0);
  }
  
  protected void a(com.tencent.mm.plugin.emoji.model.f paramf, boolean paramBoolean1, boolean paramBoolean2)
  {
    y.d("MicroMsg.emoji.BaseEmojiStoreUI", "jacks initData begin");
    if ((paramf != null) && (paramf.iYh.size() > 0))
    {
      this.jbG = true;
      this.hrf.setVisibility(8);
      this.jbm = false;
    }
    a(this.jbn, paramf, paramBoolean1, paramBoolean2);
    aID();
  }
  
  public void a(String paramString, l paraml)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals("delete_group")))
    {
      aIU();
      cD(131074, 50);
    }
  }
  
  protected void a(boolean paramBoolean1, com.tencent.mm.plugin.emoji.model.f paramf, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((this.jbB != null) && (paramBoolean1)) {
      if (aIB())
      {
        if ((this.jbB != null) && (this.jbB.iYi != null) && (this.jbB.iYi.sRQ != null)) {
          break label75;
        }
        y.d("MicroMsg.emoji.BaseEmojiStoreUI", "update store ui header failed. ");
      }
    }
    for (;;)
    {
      if (this.iYq != null) {
        this.iYq.b(this.jbB);
      }
      return;
      label75:
      this.jbH = ((LinkedList)this.jbB.iYj);
      this.jbI = ((LinkedList)this.jbB.iYk);
      if (this.jbH != null)
      {
        this.jbh.c(this.jbH, this.jbI);
      }
      else if (this.jbB.iYi != null)
      {
        this.jbH = new LinkedList();
        this.jbH.add(this.jbB.iYi);
        this.jbh.c(this.jbH, this.jbI);
      }
    }
  }
  
  public final boolean aEU()
  {
    x(true, false);
    y.i("MicroMsg.emoji.BaseEmojiStoreUI", "[onBottomLoadData] startLoadRemoteEmoji.");
    return true;
  }
  
  public final boolean aEV()
  {
    return false;
  }
  
  public final boolean aEW()
  {
    return false;
  }
  
  public final void aHM()
  {
    this.jbp = null;
    this.jbn = -1;
    x(false, false);
  }
  
  protected boolean aIA()
  {
    return true;
  }
  
  protected boolean aIB()
  {
    return true;
  }
  
  protected boolean aIC()
  {
    return false;
  }
  
  public abstract int aIE();
  
  public int aIF()
  {
    return 0;
  }
  
  protected final void aIG()
  {
    g.DO().dJT.c(this.jbz);
  }
  
  protected final void aIH()
  {
    g.DO().dJT.a(this.jbF, 0);
  }
  
  protected boolean aII()
  {
    afi localafi = i.getEmojiStorageMgr().uBe.FA(aIE());
    com.tencent.mm.plugin.emoji.model.f localf = o.a(localafi);
    int j = aIE();
    if (localafi == null) {}
    for (int i = 0;; i = localafi.tcZ)
    {
      y.d("MicroMsg.emoji.BaseEmojiStoreUI", "load cache type: %d, size: %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      if (localf != null) {
        break;
      }
      return false;
    }
    if (localf.iYh.size() <= 0) {}
    for (boolean bool = false; bool; bool = true)
    {
      y.d("MicroMsg.emoji.BaseEmojiStoreUI", "jacks init EmoijStoreUI  by Cache: list:%d", new Object[] { Integer.valueOf(localf.iYh.size()) });
      a(localf, true, false);
      return bool;
    }
    y.d("MicroMsg.emoji.BaseEmojiStoreUI", "jacks init EmoijStoreUI  by NET");
    return bool;
  }
  
  protected final void aIJ()
  {
    if ((this.faz != null) && (this.faz.isShowing())) {
      this.faz.dismiss();
    }
  }
  
  protected boolean aIK()
  {
    return false;
  }
  
  protected boolean aIL()
  {
    return true;
  }
  
  public void aIM() {}
  
  protected void aIu()
  {
    this.iYq = aIx();
    this.iYq.iVJ = this;
  }
  
  public abstract int aIv();
  
  public abstract int aIw();
  
  public abstract com.tencent.mm.plugin.emoji.a.a.a aIx();
  
  protected void aIy() {}
  
  protected void aIz()
  {
    if (!aIA()) {}
    do
    {
      return;
      this.jbk = ((MMPullDownView)findViewById(f.e.load_more_pull_view));
    } while (this.jbk == null);
    this.jbk.setTopViewVisible(false);
    this.jbk.setAtTopCallBack(this);
    this.jbk.setOnBottomLoadDataListener(this);
    this.jbk.setAtBottomCallBack(this);
    this.jbk.setBottomViewVisible(false);
    this.jbk.setIsBottomShowAll(false);
  }
  
  protected int ak(byte[] paramArrayOfByte)
  {
    return this.jbA;
  }
  
  protected void c(afi paramafi)
  {
    int j = 0;
    int i;
    if (paramafi != null)
    {
      if (paramafi != null) {
        break label68;
      }
      i = 0;
      if (paramafi != null) {
        break label76;
      }
    }
    for (;;)
    {
      y.d("MicroMsg.emoji.BaseEmojiStoreUI", "jacks save EmoijStoreUI Cache: list:%d, size: %d, type: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(aIE()) });
      i.getEmojiStorageMgr().uBe.a(aIE(), paramafi);
      return;
      label68:
      i = paramafi.tcZ;
      break;
      label76:
      if (paramafi.swr != null) {
        j = paramafi.swr.btq();
      }
    }
  }
  
  protected int getLayoutId()
  {
    return f.f.emoji_store_main;
  }
  
  public final void h(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      c((afi)paramMessage.obj);
      return;
      aIJ();
      return;
      paramMessage = (String)paramMessage.obj;
      if (isFinishing())
      {
        y.i("MicroMsg.emoji.BaseEmojiStoreUI", "[updateLoadingDialog] acitivity is finished.");
        return;
      }
    } while (this.faz == null);
    this.faz.setMessage(paramMessage);
  }
  
  public void h(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    y.d("MicroMsg.emoji.BaseEmojiStoreUI", "[onExchange] productId:[%s] status:[%d] progress:[%d] cdnClientId:[%s]", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString2 });
    if ((this.iYq == null) || (this.iYq.iVI == null)) {
      return;
    }
    if (paramInt1 == 6) {
      bu(paramString1, paramInt2);
    }
    for (;;)
    {
      paramString1 = this.iYq.iVI.Al(paramString1);
      if (paramString1 == null) {
        break;
      }
      paramString1.iVX = paramString2;
      return;
      y.i("MicroMsg.emoji.BaseEmojiStoreUI", "product status:%d", new Object[] { Integer.valueOf(paramInt1) });
      bt(paramString1, paramInt1);
    }
  }
  
  public void i(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    String str;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
            } while (this.iYq == null);
            this.iYq.notifyDataSetChanged();
            aIM();
            return;
          } while ((this.iYq == null) || (paramMessage.getData() == null));
          str = paramMessage.getData().getString("product_id");
        } while (str == null);
        i = paramMessage.getData().getInt("progress");
        this.iYq.bu(str, i);
        return;
      } while ((this.iYq == null) || (paramMessage.getData() == null));
      str = paramMessage.getData().getString("product_id");
    } while (str == null);
    int i = paramMessage.getData().getInt("status");
    this.iYq.bt(str, i);
  }
  
  public final void i(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    j(paramString1, paramString2, paramString3, paramString4);
    aIH();
  }
  
  public void initView()
  {
    setBackBtn(new BaseEmojiStoreUI.b(this, (byte)0));
    aIu();
    this.hrf = findViewById(f.e.empty);
    this.jbl = ((TextView)this.hrf.findViewById(f.e.empty_content));
    this.jbo = getLayoutInflater().inflate(f.f.emoji_store_load_more, null);
    this.jbo.setVisibility(8);
    if (aIB()) {
      this.jbh = new EmojiStoreVpHeader(this.mController.uMN);
    }
    if (aIC())
    {
      this.jbi = LayoutInflater.from(this).inflate(f.f.emoji_store_vp_header_item, null);
      int i = EmojiStoreVpHeader.cY(this.mController.uMN)[0];
      AbsListView.LayoutParams localLayoutParams = new AbsListView.LayoutParams(i, i * 3 / 8 + 1);
      this.jbi.setLayoutParams(localLayoutParams);
      this.jbj = ((StoreBannerEmojiView)this.jbi.findViewById(f.e.emoji_bar_view));
    }
    this.Nn = ((ListView)findViewById(16908298));
    this.Nn.setOnItemClickListener(this);
    if (aIB()) {
      this.Nn.addHeaderView(this.jbh);
    }
    for (;;)
    {
      if (aIL()) {
        this.Nn.addFooterView(this.jbo);
      }
      aIy();
      this.Nn.setAdapter(this.iYq);
      this.Nn.setOnScrollListener(this);
      this.iYq.iVH = this.Nn;
      aIz();
      return;
      if (aIC()) {
        this.Nn.addHeaderView(this.jbi);
      }
    }
  }
  
  protected final com.tencent.mm.plugin.emoji.f.h j(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.jbF = new com.tencent.mm.plugin.emoji.f.h(paramString1, paramString2, paramString3, paramString4);
    return this.jbF;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    y.d("MicroMsg.emoji.BaseEmojiStoreUI", "onActivityResult . requestCode:" + paramInt1 + "  resultCode:" + paramInt2);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.jbC.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jbC = new com.tencent.mm.plugin.emoji.model.h();
    initView();
    this.jbA = getIntent().getIntExtra("preceding_scence", 2);
    if (i.getEmojiStorageMgr().uBc != null) {
      i.getEmojiStorageMgr().uBc.c(this);
    }
    this.jbE = new BaseEmojiStoreUI.a(this, (byte)0);
    com.tencent.mm.sdk.b.a.udP.c(this.jbE);
    this.jbC.hxz = this;
    this.jbC.iYq = this.iYq;
    this.jbC.iYt = aIv();
    this.jbC.iYw = this;
    boolean bool2 = aIK();
    boolean bool1 = bool2;
    if (bool2) {
      bool1 = aII();
    }
    x(false, bool1);
    if (jbD == null) {
      jbD = new HashMap();
    }
    long l = System.currentTimeMillis();
    y.d("MicroMsg.emoji.BaseEmojiStoreUI", "refresh last net refresh time: %d", new Object[] { Long.valueOf(l) });
    jbD.put(getClass().toString(), Long.valueOf(l));
    this.iYy = new com.tencent.mm.plugin.emoji.h.c(1005);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.iYq != null)
    {
      this.iYq.clear();
      this.iYq = null;
    }
    if ((aIB()) && (this.jbh != null)) {
      this.jbh.clear();
    }
    i.getEmojiStorageMgr().uBc.d(this);
    com.tencent.mm.sdk.b.a.udP.d(this.jbE);
    g.DO().dJT.c(this.jbF);
    if (this.jbC != null)
    {
      com.tencent.mm.plugin.emoji.model.h localh = this.jbC;
      localh.iYq = null;
      localh.iYw = null;
      localh.hxz = null;
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i;
    if (!aIB())
    {
      i = paramInt;
      if (!aIC()) {}
    }
    else if (paramInt != 0) {}
    while ((i < 0) || (i >= this.iYq.getCount()))
    {
      return;
      i = paramInt - 1;
    }
    paramAdapterView = this.iYq.pP(i);
    if (paramAdapterView == null)
    {
      y.i("MicroMsg.emoji.BaseEmojiStoreUI", "item is null.");
      return;
    }
    if (paramAdapterView.iVT == f.a.iWc)
    {
      paramAdapterView = paramAdapterView.iVV;
      if (paramAdapterView == null)
      {
        y.i("MicroMsg.emoji.BaseEmojiStoreUI", "banner set is null. do nothing");
        return;
      }
      k.a(this.mController.uMN, paramAdapterView, false);
      return;
    }
    paramView = paramAdapterView.iVU;
    if (paramView == null)
    {
      y.i("MicroMsg.emoji.BaseEmojiStoreUI", "summary is null. do nothing");
      return;
    }
    String str = getIntent().getStringExtra("to_talker_name");
    k.a(this.mController.uMN, paramView, aIv(), paramAdapterView.mStatus, paramAdapterView.xL, str, aIw());
  }
  
  protected void onPause()
  {
    super.onPause();
    g.DO().dJT.b(411, this);
    g.DO().dJT.b(423, this);
    g.DO().dJT.b(413, this);
    g.DO().dJT.b(717, this);
    aIG();
    if ((aIB()) && (this.jbh != null)) {
      this.jbh.aJs();
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    g.DO().dJT.a(411, this);
    g.DO().dJT.a(423, this);
    g.DO().dJT.a(413, this);
    g.DO().dJT.a(717, this);
    if ((aIB()) && (this.jbh != null)) {
      this.jbh.aJr();
    }
    this.jbC.iYr = false;
    if ((this.iYq != null) && (this.iYq.iVI != null))
    {
      this.iYq.iVI.aGX();
      this.iYq.aqU();
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    int i = -1;
    Object localObject = paramString;
    if (TextUtils.isEmpty(paramString)) {
      localObject = "";
    }
    y.i("MicroMsg.emoji.BaseEmojiStoreUI", "jacks [onSceneEnd] errType:%d,errCode:%d,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), localObject });
    aIJ();
    switch (paramm.getType())
    {
    default: 
      y.e("MicroMsg.emoji.BaseEmojiStoreUI", "unknow scene type");
    }
    do
    {
      do
      {
        return;
        localObject = (o)paramm;
        if ((localObject == null) || (((o)localObject).mType != aIE())) {
          break;
        }
        this.gDQ = false;
        this.jbo.setVisibility(8);
        paramString = null;
        try
        {
          paramm = o.a(((o)localObject).aIi());
          paramString = paramm;
        }
        catch (Exception paramm)
        {
          for (;;)
          {
            y.l("MicroMsg.emoji.BaseEmojiStoreUI", "deal NetGetEmotionList error:%s", new Object[] { paramm.toString() });
            continue;
            paramInt1 = 0;
          }
          if (paramInt2 != 2) {
            continue;
          }
          paramm = ((o)localObject).aIi();
          a(this.jbn, paramString, false, false);
          aID();
          b(paramm);
          this.jbn = 2;
          return;
          if (paramInt2 != 3) {
            continue;
          }
          a(this.jbn, paramString, false, false);
          this.jbn = 1;
          return;
          this.hrf.setVisibility(0);
          this.jbm = true;
          if (aIE() != 7) {
            continue;
          }
          this.jbl.setText(f.h.emoji_store_topic_empty);
          return;
          this.jbl.setText(f.h.emoji_store_load_failed);
          return;
        }
        if (paramString != null) {
          if ((paramInt1 == 0) || (paramInt1 == 4))
          {
            paramInt1 = 1;
            if (paramInt1 == 0) {
              continue;
            }
            this.hrf.setVisibility(8);
            this.jbm = false;
            this.jbp = ((o)localObject).iZW;
            if (paramInt2 != 0) {
              continue;
            }
            paramm = ((o)localObject).aIi();
            a(paramString, false, true);
            b(paramm);
            this.jbn = 0;
          }
        }
      } while (this.jbG);
      this.hrf.setVisibility(0);
      this.jbm = true;
      this.jbl.setText(f.h.emoji_store_load_failed_network);
      return;
      paramInt2 = aIE();
      if (localObject == null) {}
      for (paramInt1 = i;; paramInt1 = ((o)localObject).mType)
      {
        y.i("MicroMsg.emoji.BaseEmojiStoreUI", "no some scene type. this ui type:%d callbak type:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
        return;
      }
      paramString = (com.tencent.mm.plugin.emoji.f.h)paramm;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        a(paramString);
        return;
      }
      paramm = paramString.iZD;
      localObject = paramString.iZF;
      String str = paramString.iZE;
      com.tencent.mm.ui.base.h.a(this, getString(f.h.emoji_store_download_failed_msg, new Object[] { str }), "", new BaseEmojiStoreUI.1(this, paramm, (String)localObject, str), new BaseEmojiStoreUI.2(this));
      bt(paramString.iZD, -1);
      return;
      paramString = (r)paramm;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        i.getEmojiStorageMgr().uBc.acy(paramString.iZD);
        paramString = new Message();
        paramString.what = 2002;
        paramString.obj = this.mController.uMN.getString(f.h.app_unInstall_finish);
        j(paramString);
      }
      for (;;)
      {
        cD(20001, 800);
        return;
        paramString = new Message();
        paramString.what = 2002;
        paramString.obj = this.mController.uMN.getString(f.h.emoji_delete_failed);
        j(paramString);
      }
    } while ((paramInt1 != 0) || (paramInt2 != 0));
    this.jbp = null;
    x(false, true);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1))
    {
      if ((this.jbn == 0) || (this.gDQ)) {
        y.d("MicroMsg.emoji.BaseEmojiStoreUI", "No More List.");
      }
    }
    else {
      return;
    }
    x(true, false);
    y.i("MicroMsg.emoji.BaseEmojiStoreUI", "[onScrollStateChanged] startLoadRemoteEmoji.");
  }
  
  public final void x(ArrayList<n> paramArrayList)
  {
    y.d("MicroMsg.emoji.BaseEmojiStoreUI", "google [onQueryFinish]");
    if (this.iYq == null) {}
    do
    {
      return;
      com.tencent.mm.plugin.emoji.a.a.b.a(paramArrayList, this.iYq.iVI);
    } while (this.jct == null);
    this.jct.removeMessages(131074);
    this.jct.sendEmptyMessage(131074);
  }
  
  protected final void x(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.gDQ = true;
    if (paramBoolean1) {
      this.jbo.setVisibility(0);
    }
    Object localObject = this.jbp;
    int i = aIE();
    int j = ak((byte[])localObject);
    int k = aIF();
    o localo;
    if (localObject != null)
    {
      y.i("MicroMsg.emoji.BaseEmojiStoreUI", "[startLoadRemoteEmoji] request buffer %s", new Object[] { localObject.toString() });
      localo = new o(i, (byte[])localObject, j);
      localObject = localo;
      if (i == 7)
      {
        localo.iZY = k;
        localObject = localo;
      }
    }
    for (;;)
    {
      this.jbz = ((o)localObject);
      g.DO().dJT.a(this.jbz, 0);
      y.i("MicroMsg.emoji.BaseEmojiStoreUI", "[startLoadRemoteEmoji] doScene GetEmotionListNetScene");
      if ((!paramBoolean1) && (!paramBoolean2)) {
        VZ();
      }
      return;
      y.i("MicroMsg.emoji.BaseEmojiStoreUI", "[startLoadRemoteEmoji] request buffer is null.");
      localo = new o(i, j);
      localObject = localo;
      if (i == 7)
      {
        localo.iZY = k;
        localObject = localo;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI
 * JD-Core Version:    0.7.0.1
 */