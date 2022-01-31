package com.tencent.mm.plugin.emoji.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.db;
import com.tencent.mm.plugin.emoji.a.a.f.a;
import com.tencent.mm.plugin.emoji.f.q;
import com.tencent.mm.plugin.emoji.model.e;
import com.tencent.mm.plugin.emoji.model.h.b;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.pluginsdk.ui.emoji.StoreBannerEmojiView;
import com.tencent.mm.protocal.protobuf.EmotionBanner;
import com.tencent.mm.protocal.protobuf.EmotionBannerSet;
import com.tencent.mm.protocal.protobuf.GetEmotionListResponse;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.at;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.c;
import com.tencent.mm.ui.base.MMPullDownView.d;
import com.tencent.mm.ui.base.MMPullDownView.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public abstract class BaseEmojiStoreUI
  extends EmojiBaseActivity
  implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener, com.tencent.mm.ai.f, com.tencent.mm.plugin.emoji.model.h.a, h.b, com.tencent.mm.pluginsdk.model.h.a, k.a, MMPullDownView.c, MMPullDownView.d, MMPullDownView.e
{
  private static Map<String, Long> lkm;
  private ProgressDialog gsr;
  private boolean icT;
  private com.tencent.mm.plugin.emoji.h.c lhD;
  com.tencent.mm.plugin.emoji.a.a.a lhv;
  protected EmojiStoreVpHeader ljQ;
  protected View ljR;
  protected StoreBannerEmojiView ljS;
  protected MMPullDownView ljT;
  protected TextView ljU;
  protected boolean ljV = false;
  int ljW = -1;
  private View ljX;
  byte[] ljY;
  private final int ljZ = 65537;
  private final int lka = 20001;
  private final int lkb = 2002;
  protected final int lkc = 131074;
  private final int lkd = 131075;
  private final int lke = 131076;
  private final String lkf = "product_id";
  private final String lkg = "progress";
  private final String lkh = "status";
  private com.tencent.mm.plugin.emoji.f.n lki;
  private int lkj;
  private e lkk;
  private com.tencent.mm.plugin.emoji.model.h lkl;
  private com.tencent.mm.sdk.b.c lkn;
  protected com.tencent.mm.plugin.emoji.f.g lko;
  protected boolean lkp = false;
  private LinkedList<EmotionBanner> lkq = new LinkedList();
  private LinkedList<EmotionBannerSet> lkr = new LinkedList();
  protected ListView mListView;
  protected View xy;
  
  private void a(int paramInt, e parame, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = false;
    ab.d("MicroMsg.emoji.BaseEmojiStoreUI", "");
    boolean bool1 = bool2;
    switch (paramInt)
    {
    default: 
      bool1 = bool2;
    case 0: 
      if (this.lkk != null) {
        this.lkk.bll();
      }
      a(bool1, this.lkk, paramBoolean1, paramBoolean2);
      return;
    case -1: 
      this.lkk = parame;
    }
    for (;;)
    {
      bool1 = true;
      break;
      this.lkk = parame;
      continue;
      if (this.lkk == null) {
        this.lkk = new e();
      }
      if (parame != null)
      {
        this.lkk.uq(parame.lhk);
        this.lkk.bo(parame.lhl);
      }
    }
  }
  
  private com.tencent.mm.plugin.emoji.f.n aH(byte[] paramArrayOfByte)
  {
    int i = bmb();
    int j = aI(paramArrayOfByte);
    int k = bmc();
    com.tencent.mm.plugin.emoji.f.n localn;
    if (paramArrayOfByte != null)
    {
      ab.i("MicroMsg.emoji.BaseEmojiStoreUI", "[startLoadRemoteEmoji] request buffer %s", new Object[] { paramArrayOfByte.toString() });
      localn = new com.tencent.mm.plugin.emoji.f.n(i, paramArrayOfByte, j);
      paramArrayOfByte = localn;
      if (i == 7)
      {
        localn.liP = k;
        paramArrayOfByte = localn;
      }
    }
    for (;;)
    {
      this.lki = paramArrayOfByte;
      return paramArrayOfByte;
      ab.i("MicroMsg.emoji.BaseEmojiStoreUI", "[startLoadRemoteEmoji] request buffer is null.");
      localn = new com.tencent.mm.plugin.emoji.f.n(i, j);
      paramArrayOfByte = localn;
      if (i == 7)
      {
        localn.liP = k;
        paramArrayOfByte = localn;
      }
    }
  }
  
  private void b(GetEmotionListResponse paramGetEmotionListResponse)
  {
    if (this.ljW == -1)
    {
      Message localMessage = Message.obtain();
      localMessage.what = 65537;
      localMessage.obj = paramGetEmotionListResponse;
      p(localMessage);
    }
  }
  
  private void bX(String paramString, int paramInt)
  {
    Message localMessage = Message.obtain();
    localMessage.getData().putString("product_id", paramString);
    localMessage.getData().putInt("status", paramInt);
    localMessage.what = 131076;
    o(localMessage);
  }
  
  private void bY(String paramString, int paramInt)
  {
    Message localMessage = Message.obtain();
    localMessage.getData().putString("product_id", paramString);
    localMessage.getData().putInt("progress", paramInt);
    localMessage.what = 131075;
    o(localMessage);
  }
  
  private void bma()
  {
    com.tencent.mm.plugin.emoji.a.a.b.a(this.lhv.leO, this);
  }
  
  private void bmd()
  {
    com.tencent.mm.kernel.g.RK().eHt.a(this.lki, 0);
  }
  
  public final void A(ArrayList<com.tencent.mm.pluginsdk.model.n> paramArrayList)
  {
    ab.d("MicroMsg.emoji.BaseEmojiStoreUI", "google [onQueryFinish]");
    if (this.lhv == null) {}
    do
    {
      return;
      com.tencent.mm.plugin.emoji.a.a.b.a(paramArrayList, this.lhv.leO);
    } while (this.llf == null);
    this.llf.removeMessages(131074);
    this.llf.sendEmptyMessage(131074);
  }
  
  protected void KY(String paramString) {}
  
  public final void a(com.tencent.mm.plugin.emoji.a.a parama)
  {
    String str2 = parama.getProductId();
    String str1;
    if (TextUtils.isEmpty(parama.bku()))
    {
      str1 = "";
      ab.i("MicroMsg.emoji.BaseEmojiStoreUI", "[onProductClick] productId:%s, productPrice:%s, productStatus:%d", new Object[] { str2, str1, Integer.valueOf(parama.bkt()) });
      if (parama.bkt() == 9)
      {
        str1 = getString(2131297094);
        if (!isFinishing()) {
          break label97;
        }
        ab.i("MicroMsg.emoji.BaseEmojiStoreUI", "[showLoadingDialog] acitivity is finished.");
      }
    }
    for (;;)
    {
      this.lkl.a(parama);
      return;
      str1 = parama.bku();
      break;
      label97:
      getString(2131297087);
      this.gsr = com.tencent.mm.ui.base.h.b(this, str1, true, new BaseEmojiStoreUI.4(this));
    }
  }
  
  protected void a(com.tencent.mm.plugin.emoji.f.g paramg)
  {
    bY(paramg.liu, 0);
  }
  
  protected void a(e parame, boolean paramBoolean1, boolean paramBoolean2)
  {
    ab.d("MicroMsg.emoji.BaseEmojiStoreUI", "jacks initData begin");
    if ((parame != null) && (parame.lhl.size() > 0))
    {
      this.lkp = true;
      this.xy.setVisibility(8);
      this.ljV = false;
    }
    a(this.ljW, parame, paramBoolean1, paramBoolean2);
    bma();
  }
  
  public void a(String paramString, com.tencent.mm.sdk.e.m paramm)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals("delete_group")))
    {
      bms();
      eb(131074, 50);
    }
  }
  
  protected void a(boolean paramBoolean1, e parame, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((this.lkk != null) && (paramBoolean1)) {
      if (blY())
      {
        if ((this.lkk != null) && (this.lkk.lhm != null) && (this.lkk.lhm.BannerSummary != null)) {
          break label75;
        }
        ab.d("MicroMsg.emoji.BaseEmojiStoreUI", "update store ui header failed. ");
      }
    }
    for (;;)
    {
      if (this.lhv != null) {
        this.lhv.b(this.lkk);
      }
      return;
      label75:
      this.lkq = ((LinkedList)this.lkk.lhn);
      this.lkr = ((LinkedList)this.lkk.lho);
      if (this.lkq != null)
      {
        this.ljQ.d(this.lkq, this.lkr);
      }
      else if (this.lkk.lhm != null)
      {
        this.lkq = new LinkedList();
        this.lkq.add(this.lkk.lhm);
        this.ljQ.d(this.lkq, this.lkr);
      }
    }
  }
  
  protected int aI(byte[] paramArrayOfByte)
  {
    return this.lkj;
  }
  
  protected final void apy()
  {
    if (isFinishing())
    {
      ab.i("MicroMsg.emoji.BaseEmojiStoreUI", "[showLoadingDialog] acitivity is finished.");
      return;
    }
    getString(2131297087);
    this.gsr = com.tencent.mm.ui.base.h.b(this, getString(2131297112), true, new BaseEmojiStoreUI.3(this));
  }
  
  public final boolean bik()
  {
    z(true, false);
    ab.i("MicroMsg.emoji.BaseEmojiStoreUI", "[onBottomLoadData] startLoadRemoteEmoji.");
    return true;
  }
  
  public final boolean bil()
  {
    return false;
  }
  
  public final boolean bim()
  {
    return false;
  }
  
  protected void blR()
  {
    this.lhv = blU();
    this.lhv.leP = this;
  }
  
  protected abstract int blS();
  
  protected abstract int blT();
  
  protected abstract com.tencent.mm.plugin.emoji.a.a.a blU();
  
  protected void blV() {}
  
  protected void blW()
  {
    if (!blX()) {}
    do
    {
      return;
      this.ljT = ((MMPullDownView)findViewById(2131823652));
    } while (this.ljT == null);
    this.ljT.setTopViewVisible(false);
    this.ljT.setAtTopCallBack(this);
    this.ljT.setOnBottomLoadDataListener(this);
    this.ljT.setAtBottomCallBack(this);
    this.ljT.setBottomViewVisible(false);
    this.ljT.setIsBottomShowAll(false);
  }
  
  protected boolean blX()
  {
    return true;
  }
  
  protected boolean blY()
  {
    return true;
  }
  
  protected boolean blZ()
  {
    return false;
  }
  
  public final void blm()
  {
    this.ljY = null;
    this.ljW = -1;
    z(false, false);
  }
  
  protected abstract int bmb();
  
  public int bmc()
  {
    return 0;
  }
  
  protected final void bme()
  {
    com.tencent.mm.kernel.g.RK().eHt.a(this.lki);
  }
  
  protected final void bmf()
  {
    com.tencent.mm.kernel.g.RK().eHt.a(this.lko, 0);
  }
  
  protected boolean bmg()
  {
    GetEmotionListResponse localGetEmotionListResponse = i.getEmojiStorageMgr().yNq.NK(bmb());
    e locale = com.tencent.mm.plugin.emoji.f.n.a(localGetEmotionListResponse);
    int j = bmb();
    if (localGetEmotionListResponse == null) {}
    for (int i = 0;; i = localGetEmotionListResponse.EmotionCount)
    {
      ab.d("MicroMsg.emoji.BaseEmojiStoreUI", "load cache type: %d, size: %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      if (locale != null) {
        break;
      }
      return false;
    }
    if (locale.lhl.size() <= 0) {}
    for (boolean bool = false; bool; bool = true)
    {
      ab.d("MicroMsg.emoji.BaseEmojiStoreUI", "jacks init EmoijStoreUI  by Cache: list:%d", new Object[] { Integer.valueOf(locale.lhl.size()) });
      a(locale, true, false);
      return bool;
    }
    ab.d("MicroMsg.emoji.BaseEmojiStoreUI", "jacks init EmoijStoreUI  by NET");
    return bool;
  }
  
  protected final void bmh()
  {
    if ((this.gsr != null) && (this.gsr.isShowing())) {
      this.gsr.dismiss();
    }
  }
  
  protected boolean bmi()
  {
    return false;
  }
  
  protected boolean bmj()
  {
    return true;
  }
  
  public void bmk() {}
  
  protected void c(GetEmotionListResponse paramGetEmotionListResponse)
  {
    int j = 0;
    int i;
    if (paramGetEmotionListResponse != null)
    {
      if (paramGetEmotionListResponse != null) {
        break label68;
      }
      i = 0;
      if (paramGetEmotionListResponse != null) {
        break label76;
      }
    }
    for (;;)
    {
      ab.d("MicroMsg.emoji.BaseEmojiStoreUI", "jacks save EmoijStoreUI Cache: list:%d, size: %d, type: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(bmb()) });
      i.getEmojiStorageMgr().yNq.a(bmb(), paramGetEmotionListResponse);
      return;
      label68:
      i = paramGetEmotionListResponse.EmotionCount;
      break;
      label76:
      if (paramGetEmotionListResponse.ReqBuf != null) {
        j = paramGetEmotionListResponse.ReqBuf.computeSize();
      }
    }
  }
  
  public int getLayoutId()
  {
    return 2130969388;
  }
  
  public void h(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    ab.d("MicroMsg.emoji.BaseEmojiStoreUI", "[onExchange] productId:[%s] status:[%d] progress:[%d] cdnClientId:[%s]", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString2 });
    if (this.lhv == null) {}
    com.tencent.mm.plugin.emoji.a.a.c localc;
    do
    {
      return;
      localc = this.lhv.leO;
    } while (localc == null);
    if (paramInt1 == 6) {
      bY(paramString1, paramInt2);
    }
    for (;;)
    {
      paramString1 = localc.Kj(paramString1);
      if (paramString1 == null) {
        break;
      }
      paramString1.lfd = paramString2;
      return;
      ab.i("MicroMsg.emoji.BaseEmojiStoreUI", "product status:%d", new Object[] { Integer.valueOf(paramInt1) });
      bX(paramString1, paramInt1);
    }
  }
  
  public final void i(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    j(paramString1, paramString2, paramString3, paramString4);
    bmf();
  }
  
  public void initView()
  {
    setBackBtn(new b((byte)0));
    blR();
    this.xy = findViewById(2131821788);
    this.ljU = ((TextView)this.xy.findViewById(2131823644));
    this.ljX = getLayoutInflater().inflate(2130969387, null);
    this.ljX.setVisibility(8);
    if (blY()) {
      this.ljQ = new EmojiStoreVpHeader(getContext());
    }
    if (blZ())
    {
      this.ljR = LayoutInflater.from(this).inflate(2130969420, null);
      int i = EmojiStoreVpHeader.dh(getContext())[0];
      AbsListView.LayoutParams localLayoutParams = new AbsListView.LayoutParams(i, i * 3 / 8 + 1);
      this.ljR.setLayoutParams(localLayoutParams);
      this.ljS = ((StoreBannerEmojiView)this.ljR.findViewById(2131823664));
    }
    this.mListView = ((ListView)findViewById(16908298));
    this.mListView.setOnItemClickListener(this);
    if (blY()) {
      this.mListView.addHeaderView(this.ljQ);
    }
    for (;;)
    {
      if (bmj()) {
        this.mListView.addFooterView(this.ljX);
      }
      blV();
      this.mListView.setAdapter(this.lhv);
      this.mListView.setOnScrollListener(this);
      this.lhv.leN = this.mListView;
      blW();
      return;
      if (blZ()) {
        this.mListView.addHeaderView(this.ljR);
      }
    }
  }
  
  protected final com.tencent.mm.plugin.emoji.f.g j(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.lko = new com.tencent.mm.plugin.emoji.f.g(paramString1, paramString2, paramString3, paramString4);
    return this.lko;
  }
  
  public final void m(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      c((GetEmotionListResponse)paramMessage.obj);
      return;
      bmh();
      return;
      paramMessage = (String)paramMessage.obj;
      if (isFinishing())
      {
        ab.i("MicroMsg.emoji.BaseEmojiStoreUI", "[updateLoadingDialog] acitivity is finished.");
        return;
      }
    } while (this.gsr == null);
    this.gsr.setMessage(paramMessage);
  }
  
  public void n(Message paramMessage)
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
            } while (this.lhv == null);
            this.lhv.notifyDataSetChanged();
            bmk();
            return;
          } while ((this.lhv == null) || (paramMessage.getData() == null));
          str = paramMessage.getData().getString("product_id");
        } while (str == null);
        i = paramMessage.getData().getInt("progress");
        this.lhv.bY(str, i);
        return;
      } while ((this.lhv == null) || (paramMessage.getData() == null));
      str = paramMessage.getData().getString("product_id");
    } while (str == null);
    int i = paramMessage.getData().getInt("status");
    this.lhv.bX(str, i);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    ab.d("MicroMsg.emoji.BaseEmojiStoreUI", "onActivityResult . requestCode:" + paramInt1 + "  resultCode:" + paramInt2);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.lkl.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.lkl = new com.tencent.mm.plugin.emoji.model.h();
    initView();
    this.lkj = getIntent().getIntExtra("preceding_scence", 2);
    if (i.getEmojiStorageMgr().yNo != null) {
      i.getEmojiStorageMgr().yNo.add(this);
    }
    this.lkn = new a((byte)0);
    com.tencent.mm.sdk.b.a.ymk.c(this.lkn);
    this.lkl.jpJ = this;
    this.lkl.lhv = this.lhv;
    this.lkl.lhy = blS();
    this.lkl.lhB = this;
    boolean bool2 = bmi();
    boolean bool1 = bool2;
    if (bool2) {
      bool1 = bmg();
    }
    z(false, bool1);
    if (lkm == null) {
      lkm = new HashMap();
    }
    long l = System.currentTimeMillis();
    ab.d("MicroMsg.emoji.BaseEmojiStoreUI", "refresh last net refresh time: %d", new Object[] { Long.valueOf(l) });
    lkm.put(getClass().toString(), Long.valueOf(l));
    this.lhD = new com.tencent.mm.plugin.emoji.h.c(1005);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.lhv != null)
    {
      this.lhv.clear();
      this.lhv = null;
    }
    if ((blY()) && (this.ljQ != null)) {
      this.ljQ.clear();
    }
    i.getEmojiStorageMgr().yNo.remove(this);
    com.tencent.mm.sdk.b.a.ymk.d(this.lkn);
    com.tencent.mm.kernel.g.RK().eHt.a(this.lko);
    if (this.lkl != null)
    {
      com.tencent.mm.plugin.emoji.model.h localh = this.lkl;
      localh.lhv = null;
      localh.lhB = null;
      localh.jpJ = null;
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i;
    if (!blY())
    {
      i = paramInt;
      if (!blZ()) {}
    }
    else if (paramInt != 0) {}
    while ((i < 0) || (i >= this.lhv.getCount()))
    {
      return;
      i = paramInt - 1;
    }
    paramAdapterView = this.lhv.uj(i);
    if (paramAdapterView == null)
    {
      ab.i("MicroMsg.emoji.BaseEmojiStoreUI", "item is null.");
      return;
    }
    if (paramAdapterView.leZ == f.a.lfi)
    {
      paramAdapterView = paramAdapterView.lfb;
      if (paramAdapterView == null)
      {
        ab.i("MicroMsg.emoji.BaseEmojiStoreUI", "banner set is null. do nothing");
        return;
      }
      com.tencent.mm.plugin.emoji.e.m.a(getContext(), paramAdapterView, false);
      return;
    }
    paramView = paramAdapterView.lfa;
    if (paramView == null)
    {
      ab.i("MicroMsg.emoji.BaseEmojiStoreUI", "summary is null. do nothing");
      return;
    }
    String str = getIntent().getStringExtra("to_talker_name");
    com.tencent.mm.plugin.emoji.e.m.a(getContext(), paramView, blS(), paramAdapterView.mStatus, paramAdapterView.ym, str, blT());
  }
  
  public void onPause()
  {
    super.onPause();
    com.tencent.mm.kernel.g.RK().eHt.b(411, this);
    com.tencent.mm.kernel.g.RK().eHt.b(423, this);
    com.tencent.mm.kernel.g.RK().eHt.b(413, this);
    com.tencent.mm.kernel.g.RK().eHt.b(717, this);
    bme();
    if ((blY()) && (this.ljQ != null)) {
      this.ljQ.bmX();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    com.tencent.mm.kernel.g.RK().eHt.a(411, this);
    com.tencent.mm.kernel.g.RK().eHt.a(423, this);
    com.tencent.mm.kernel.g.RK().eHt.a(413, this);
    com.tencent.mm.kernel.g.RK().eHt.a(717, this);
    if ((blY()) && (this.ljQ != null)) {
      this.ljQ.bmW();
    }
    Boolean localBoolean = Boolean.FALSE;
    this.lkl.lhw = false;
    if ((this.lhv != null) && (this.lhv.leO != null))
    {
      this.lhv.leO.bkJ();
      this.lhv.refreshView();
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    int i = -1;
    Object localObject = paramString;
    if (TextUtils.isEmpty(paramString)) {
      localObject = "";
    }
    ab.i("MicroMsg.emoji.BaseEmojiStoreUI", "jacks [onSceneEnd] errType:%d,errCode:%d,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), localObject });
    bmh();
    switch (paramm.getType())
    {
    default: 
      ab.e("MicroMsg.emoji.BaseEmojiStoreUI", "unknow scene type");
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
          } while (!(paramm instanceof com.tencent.mm.plugin.emoji.f.n));
          localObject = (com.tencent.mm.plugin.emoji.f.n)paramm;
          if ((localObject == null) || (((com.tencent.mm.plugin.emoji.f.n)localObject).mType != bmb())) {
            break;
          }
          this.icT = false;
          this.ljX.setVisibility(8);
          paramString = null;
          try
          {
            paramm = com.tencent.mm.plugin.emoji.f.n.a(((com.tencent.mm.plugin.emoji.f.n)localObject).blH());
            paramString = paramm;
          }
          catch (Exception paramm)
          {
            for (;;)
            {
              ab.b("MicroMsg.emoji.BaseEmojiStoreUI", "deal NetGetEmotionList error:%s", new Object[] { paramm.toString() });
              continue;
              paramInt1 = 0;
            }
            if (paramInt2 != 2) {
              continue;
            }
            paramm = ((com.tencent.mm.plugin.emoji.f.n)localObject).blH();
            a(this.ljW, paramString, false, false);
            bma();
            b(paramm);
            this.ljW = 2;
            return;
            if (paramInt2 != 3) {
              continue;
            }
            a(this.ljW, paramString, false, false);
            this.ljW = 1;
            return;
            this.xy.setVisibility(0);
            this.ljV = true;
            if (bmb() != 7) {
              continue;
            }
            this.ljU.setText(2131299254);
            return;
            this.ljU.setText(2131299204);
            return;
          }
          if (paramString != null) {
            if ((paramInt1 == 0) || (paramInt1 == 4))
            {
              paramInt1 = 1;
              if (paramInt1 == 0) {
                continue;
              }
              this.xy.setVisibility(8);
              this.ljV = false;
              this.ljY = ((com.tencent.mm.plugin.emoji.f.n)localObject).liN;
              if (paramInt2 != 0) {
                continue;
              }
              paramm = ((com.tencent.mm.plugin.emoji.f.n)localObject).blH();
              a(paramString, false, true);
              b(paramm);
              this.ljW = 0;
            }
          }
        } while (this.lkp);
        this.xy.setVisibility(0);
        this.ljV = true;
        this.ljU.setText(2131299205);
        return;
        paramInt2 = bmb();
        if (localObject == null) {}
        for (paramInt1 = i;; paramInt1 = ((com.tencent.mm.plugin.emoji.f.n)localObject).mType)
        {
          ab.i("MicroMsg.emoji.BaseEmojiStoreUI", "no some scene type. this ui type:%d callbak type:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
          return;
        }
      } while (!(paramm instanceof com.tencent.mm.plugin.emoji.f.g));
      paramString = (com.tencent.mm.plugin.emoji.f.g)paramm;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        a(paramString);
        return;
      }
      paramm = paramString.liu;
      localObject = paramString.liw;
      String str = paramString.liv;
      com.tencent.mm.ui.base.h.a(this, getString(2131299194, new Object[] { str }), "", new BaseEmojiStoreUI.1(this, paramm, (String)localObject, str), new BaseEmojiStoreUI.2(this));
      bX(paramString.liu, -1);
      return;
      paramString = (q)paramm;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        i.getEmojiStorageMgr().yNo.asK(paramString.liu);
        paramString = new Message();
        paramString.what = 2002;
        paramString.obj = getContext().getString(2131297091);
        o(paramString);
      }
      for (;;)
      {
        eb(20001, 800);
        return;
        paramString = new Message();
        paramString.what = 2002;
        paramString.obj = getContext().getString(2131299135);
        o(paramString);
      }
    } while ((paramInt1 != 0) || (paramInt2 != 0));
    this.ljY = null;
    z(false, true);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1))
    {
      if ((this.ljW == 0) || (this.icT)) {
        ab.d("MicroMsg.emoji.BaseEmojiStoreUI", "No More List.");
      }
    }
    else {
      return;
    }
    z(true, false);
    ab.i("MicroMsg.emoji.BaseEmojiStoreUI", "[onScrollStateChanged] startLoadRemoteEmoji.");
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected final void z(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.icT = true;
    if (paramBoolean1) {
      this.ljX.setVisibility(0);
    }
    aH(this.ljY);
    bmd();
    ab.i("MicroMsg.emoji.BaseEmojiStoreUI", "[startLoadRemoteEmoji] doScene GetEmotionListNetScene");
    if ((!paramBoolean1) && (!paramBoolean2)) {
      apy();
    }
  }
  
  final class a
    extends com.tencent.mm.sdk.b.c<db>
  {
    private a()
    {
      AppMethodBeat.i(53216);
      this.__eventId = db.class.getName().hashCode();
      AppMethodBeat.o(53216);
    }
  }
  
  final class b
    implements MenuItem.OnMenuItemClickListener
  {
    private b() {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(53219);
      BaseEmojiStoreUI.this.finish();
      AppMethodBeat.o(53219);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI
 * JD-Core Version:    0.7.0.1
 */