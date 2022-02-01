package com.tencent.mm.plugin.emoji.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.di;
import com.tencent.mm.plugin.emoji.a.a.f.a;
import com.tencent.mm.plugin.emoji.model.j;
import com.tencent.mm.plugin.emoji.model.j.b;
import com.tencent.mm.pluginsdk.model.p;
import com.tencent.mm.pluginsdk.ui.emoji.StoreBannerEmojiView;
import com.tencent.mm.protocal.protobuf.EmotionBanner;
import com.tencent.mm.protocal.protobuf.EmotionBannerSet;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.protocal.protobuf.GetEmotionListResponse;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.emotion.s;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.c;
import com.tencent.mm.ui.base.MMPullDownView.d;
import com.tencent.mm.ui.base.MMPullDownView.e;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public abstract class BaseEmojiStoreUI
  extends EmojiBaseActivity
  implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener, com.tencent.mm.ak.g, com.tencent.mm.plugin.emoji.model.j.a, j.b, com.tencent.mm.pluginsdk.model.j.a, k.a, MMPullDownView.c, MMPullDownView.d, MMPullDownView.e
{
  private static Map<String, Long> pdU;
  protected View EP;
  private ProgressDialog iFC;
  private boolean kOL;
  public ListView mListView;
  public com.tencent.mm.plugin.emoji.a.a.a paX;
  private com.tencent.mm.plugin.emoji.h.c pbf;
  protected StoreBannerEmojiView pdA;
  protected MMPullDownView pdB;
  protected TextView pdC;
  protected boolean pdD = false;
  int pdE = -1;
  private View pdF;
  protected byte[] pdG;
  private final int pdH = 65537;
  private final int pdI = 20001;
  private final int pdJ = 2002;
  protected final int pdK = 131074;
  private final int pdL = 131075;
  private final int pdM = 131076;
  private final String pdN = "product_id";
  private final String pdO = "progress";
  private final String pdP = "status";
  private com.tencent.mm.plugin.emoji.f.n pdQ;
  private int pdR;
  private com.tencent.mm.plugin.emoji.model.f pdS;
  protected j pdT;
  private com.tencent.mm.sdk.b.c pdV;
  protected com.tencent.mm.plugin.emoji.f.g pdW;
  protected boolean pdX = false;
  private LinkedList<EmotionBanner> pdY = new LinkedList();
  private LinkedList<EmotionBannerSet> pdZ = new LinkedList();
  protected EmojiStoreVpHeader pdy;
  protected View pdz;
  
  private void a(int paramInt, com.tencent.mm.plugin.emoji.model.f paramf, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = false;
    ac.d("MicroMsg.emoji.BaseEmojiStoreUI", "");
    boolean bool1 = bool2;
    switch (paramInt)
    {
    default: 
      bool1 = bool2;
    case 0: 
      if (this.pdS != null) {
        this.pdS.ccg();
      }
      a(bool1, this.pdS, paramBoolean1, paramBoolean2);
      return;
    case -1: 
      this.pdS = paramf;
    }
    for (;;)
    {
      bool1 = true;
      break;
      this.pdS = paramf;
      continue;
      if (this.pdS == null) {
        this.pdS = new com.tencent.mm.plugin.emoji.model.f();
      }
      if (paramf != null)
      {
        this.pdS.Bs(paramf.pay);
        this.pdS.cN(paramf.paz);
      }
    }
  }
  
  private com.tencent.mm.plugin.emoji.f.n aW(byte[] paramArrayOfByte)
  {
    int i = ccZ();
    int j = aX(paramArrayOfByte);
    int k = cda();
    com.tencent.mm.plugin.emoji.f.n localn;
    if (paramArrayOfByte != null)
    {
      ac.i("MicroMsg.emoji.BaseEmojiStoreUI", "[startLoadRemoteEmoji] request buffer %s", new Object[] { paramArrayOfByte.toString() });
      localn = new com.tencent.mm.plugin.emoji.f.n(i, paramArrayOfByte, j);
      paramArrayOfByte = localn;
      if (i == 7)
      {
        localn.pcs = k;
        paramArrayOfByte = localn;
      }
    }
    for (;;)
    {
      this.pdQ = paramArrayOfByte;
      return paramArrayOfByte;
      ac.i("MicroMsg.emoji.BaseEmojiStoreUI", "[startLoadRemoteEmoji] request buffer is null.");
      localn = new com.tencent.mm.plugin.emoji.f.n(i, j);
      paramArrayOfByte = localn;
      if (i == 7)
      {
        localn.pcs = k;
        paramArrayOfByte = localn;
      }
    }
  }
  
  private void c(GetEmotionListResponse paramGetEmotionListResponse)
  {
    if (this.pdE == -1)
    {
      Message localMessage = Message.obtain();
      localMessage.what = 65537;
      localMessage.obj = paramGetEmotionListResponse;
      o(localMessage);
    }
  }
  
  private void cP(String paramString, int paramInt)
  {
    Message localMessage = Message.obtain();
    localMessage.getData().putString("product_id", paramString);
    localMessage.getData().putInt("status", paramInt);
    localMessage.what = 131076;
    n(localMessage);
  }
  
  private void cQ(String paramString, int paramInt)
  {
    Message localMessage = Message.obtain();
    localMessage.getData().putString("product_id", paramString);
    localMessage.getData().putInt("progress", paramInt);
    localMessage.what = 131075;
    n(localMessage);
  }
  
  private void ccY()
  {
    com.tencent.mm.plugin.emoji.a.a.b.a(this.paX.oXZ, this);
  }
  
  private void cdb()
  {
    com.tencent.mm.kernel.g.agQ().ghe.a(this.pdQ, 0);
  }
  
  protected final void K(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.kOL = true;
    if (paramBoolean1) {
      this.pdF.setVisibility(0);
    }
    aW(this.pdG);
    cdb();
    ac.i("MicroMsg.emoji.BaseEmojiStoreUI", "[startLoadRemoteEmoji] doScene GetEmotionListNetScene");
    if ((!paramBoolean1) && (!paramBoolean2)) {
      aOL();
    }
  }
  
  public final void R(ArrayList<p> paramArrayList)
  {
    ac.d("MicroMsg.emoji.BaseEmojiStoreUI", "google [onQueryFinish]");
    if (this.paX == null) {}
    do
    {
      return;
      com.tencent.mm.plugin.emoji.a.a.b.a(paramArrayList, this.paX.oXZ);
    } while (this.peV == null);
    this.peV.removeMessages(131074);
    this.peV.sendEmptyMessage(131074);
  }
  
  protected void Yr(String paramString) {}
  
  protected void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.plugin.emoji.f.n paramn)
  {
    if ((paramn != null) && (paramn.mType == ccZ()))
    {
      this.kOL = false;
      this.pdF.setVisibility(8);
      paramString = null;
      try
      {
        com.tencent.mm.plugin.emoji.model.f localf = com.tencent.mm.plugin.emoji.f.n.b(paramn.ccF());
        paramString = localf;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ac.m("MicroMsg.emoji.BaseEmojiStoreUI", "deal NetGetEmotionList error:%s", new Object[] { localException.toString() });
          continue;
          paramInt1 = 0;
        }
        if (paramInt2 != 2) {
          break label187;
        }
        paramn = paramn.ccF();
        a(this.pdE, paramString, false, false);
        ccY();
        c(paramn);
        this.pdE = 2;
        return;
        if (paramInt2 != 3) {
          break label209;
        }
        a(this.pdE, paramString, false, false);
        this.pdE = 1;
        return;
        this.EP.setVisibility(0);
        this.pdD = true;
        if (ccZ() != 7) {
          break label242;
        }
        this.pdC.setText(2131758380);
        return;
        this.pdC.setText(2131758330);
        return;
      }
      if (paramString != null) {
        if ((paramInt1 == 0) || (paramInt1 == 4))
        {
          paramInt1 = 1;
          if (paramInt1 == 0) {
            break label253;
          }
          this.EP.setVisibility(8);
          this.pdD = false;
          this.pdG = paramn.pcq;
          if (paramInt2 != 0) {
            break label148;
          }
          paramn = paramn.ccF();
          a(paramString, false, true);
          c(paramn);
          this.pdE = 0;
        }
      }
      label148:
      label187:
      label209:
      label242:
      label253:
      while (this.pdX) {
        return;
      }
      this.EP.setVisibility(0);
      this.pdD = true;
      this.pdC.setText(2131758331);
      return;
    }
    paramInt2 = ccZ();
    if (paramn == null) {}
    for (paramInt1 = -1;; paramInt1 = paramn.mType)
    {
      ac.i("MicroMsg.emoji.BaseEmojiStoreUI", "no some scene type. this ui type:%d callbak type:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
      return;
    }
  }
  
  protected void a(com.tencent.mm.plugin.emoji.a.a.f paramf, int paramInt)
  {
    if (paramf == null)
    {
      ac.i("MicroMsg.emoji.BaseEmojiStoreUI", "item is null.");
      return;
    }
    if (paramf.oYk == f.a.oYt)
    {
      paramf = paramf.oYm;
      if (paramf == null)
      {
        ac.i("MicroMsg.emoji.BaseEmojiStoreUI", "banner set is null. do nothing");
        return;
      }
      com.tencent.mm.plugin.emoji.e.k.a(getContext(), paramf, false);
      return;
    }
    EmotionSummary localEmotionSummary = paramf.oYl;
    if (localEmotionSummary == null)
    {
      ac.i("MicroMsg.emoji.BaseEmojiStoreUI", "summary is null. do nothing");
      return;
    }
    String str = getIntent().getStringExtra("to_talker_name");
    com.tencent.mm.plugin.emoji.e.k.a(getContext(), localEmotionSummary, ccQ(), paramf.mStatus, paramf.FG, str, ccR());
  }
  
  public final void a(com.tencent.mm.plugin.emoji.a.a parama)
  {
    String str2 = parama.getProductId();
    String str1;
    if (TextUtils.isEmpty(parama.cbx()))
    {
      str1 = "";
      ac.i("MicroMsg.emoji.BaseEmojiStoreUI", "[onProductClick] productId:%s, productPrice:%s, productStatus:%d", new Object[] { str2, str1, Integer.valueOf(parama.cbw()) });
      if (parama.cbw() == 9)
      {
        str1 = getString(2131755913);
        if (!isFinishing()) {
          break label97;
        }
        ac.i("MicroMsg.emoji.BaseEmojiStoreUI", "[showLoadingDialog] acitivity is finished.");
      }
    }
    for (;;)
    {
      this.pdT.a(parama);
      return;
      str1 = parama.cbx();
      break;
      label97:
      getString(2131755906);
      this.iFC = h.b(this, str1, true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(108786);
          BaseEmojiStoreUI.cdj();
          AppMethodBeat.o(108786);
        }
      });
    }
  }
  
  protected void a(com.tencent.mm.plugin.emoji.f.g paramg)
  {
    cQ(paramg.pbW, 0);
  }
  
  protected void a(com.tencent.mm.plugin.emoji.model.f paramf, boolean paramBoolean1, boolean paramBoolean2)
  {
    ac.d("MicroMsg.emoji.BaseEmojiStoreUI", "jacks initData begin");
    if ((paramf != null) && (paramf.paz.size() > 0))
    {
      this.pdX = true;
      this.EP.setVisibility(8);
      this.pdD = false;
    }
    a(this.pdE, paramf, paramBoolean1, paramBoolean2);
    ccY();
  }
  
  public void a(String paramString, m paramm)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals("delete_group")))
    {
      cdp();
      fh(131074, 50);
    }
  }
  
  protected void a(boolean paramBoolean1, com.tencent.mm.plugin.emoji.model.f paramf, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((this.pdS != null) && (paramBoolean1)) {
      if (ccW())
      {
        if ((this.pdS != null) && (this.pdS.paA != null) && (this.pdS.paA.BannerSummary != null)) {
          break label75;
        }
        ac.d("MicroMsg.emoji.BaseEmojiStoreUI", "update store ui header failed. ");
      }
    }
    for (;;)
    {
      if (this.paX != null) {
        this.paX.b(this.pdS);
      }
      return;
      label75:
      this.pdY = ((LinkedList)this.pdS.paB);
      this.pdZ = ((LinkedList)this.pdS.paC);
      if (this.pdY != null)
      {
        this.pdy.d(this.pdY, this.pdZ);
      }
      else if (this.pdS.paA != null)
      {
        this.pdY = new LinkedList();
        this.pdY.add(this.pdS.paA);
        this.pdy.d(this.pdY, this.pdZ);
      }
    }
  }
  
  protected final void aOL()
  {
    if (isFinishing())
    {
      ac.i("MicroMsg.emoji.BaseEmojiStoreUI", "[showLoadingDialog] acitivity is finished.");
      return;
    }
    getString(2131755906);
    this.iFC = h.b(this, getString(2131755936), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(108785);
        BaseEmojiStoreUI.this.cdc();
        BaseEmojiStoreUI.cdj();
        AppMethodBeat.o(108785);
      }
    });
  }
  
  protected int aX(byte[] paramArrayOfByte)
  {
    return this.pdR;
  }
  
  public final boolean bWx()
  {
    K(true, false);
    ac.i("MicroMsg.emoji.BaseEmojiStoreUI", "[onBottomLoadData] startLoadRemoteEmoji.");
    return true;
  }
  
  public final boolean bWy()
  {
    return false;
  }
  
  public final boolean bWz()
  {
    return false;
  }
  
  protected void ccP()
  {
    this.paX = ccS();
    this.paX.oYa = this;
  }
  
  protected abstract int ccQ();
  
  protected abstract int ccR();
  
  protected abstract com.tencent.mm.plugin.emoji.a.a.a ccS();
  
  protected void ccT() {}
  
  protected void ccU()
  {
    if (!ccV()) {}
    do
    {
      return;
      this.pdB = ((MMPullDownView)findViewById(2131301487));
    } while (this.pdB == null);
    this.pdB.setTopViewVisible(false);
    this.pdB.setAtTopCallBack(this);
    this.pdB.setOnBottomLoadDataListener(this);
    this.pdB.setAtBottomCallBack(this);
    this.pdB.setBottomViewVisible(false);
    this.pdB.setIsBottomShowAll(false);
  }
  
  protected boolean ccV()
  {
    return true;
  }
  
  protected boolean ccW()
  {
    return true;
  }
  
  protected boolean ccX()
  {
    return false;
  }
  
  protected abstract int ccZ();
  
  public final void cci()
  {
    this.pdG = null;
    this.pdE = -1;
    K(false, false);
  }
  
  public int cda()
  {
    return 0;
  }
  
  protected final void cdc()
  {
    com.tencent.mm.kernel.g.agQ().ghe.a(this.pdQ);
  }
  
  protected final void cdd()
  {
    com.tencent.mm.kernel.g.agQ().ghe.a(this.pdW, 0);
  }
  
  protected boolean cde()
  {
    GetEmotionListResponse localGetEmotionListResponse = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().GYc.YY(ccZ());
    com.tencent.mm.plugin.emoji.model.f localf = com.tencent.mm.plugin.emoji.f.n.b(localGetEmotionListResponse);
    int j = ccZ();
    if (localGetEmotionListResponse == null) {}
    for (int i = 0;; i = localGetEmotionListResponse.EmotionCount)
    {
      ac.d("MicroMsg.emoji.BaseEmojiStoreUI", "load cache type: %d, size: %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      if (localf != null) {
        break;
      }
      return false;
    }
    if (localf.paz.size() <= 0) {}
    for (boolean bool = false; bool; bool = true)
    {
      ac.d("MicroMsg.emoji.BaseEmojiStoreUI", "jacks init EmoijStoreUI  by Cache: list:%d", new Object[] { Integer.valueOf(localf.paz.size()) });
      a(localf, true, false);
      return bool;
    }
    ac.d("MicroMsg.emoji.BaseEmojiStoreUI", "jacks init EmoijStoreUI  by NET");
    return bool;
  }
  
  protected final void cdf()
  {
    if ((this.iFC != null) && (this.iFC.isShowing())) {
      this.iFC.dismiss();
    }
  }
  
  protected boolean cdg()
  {
    return false;
  }
  
  protected boolean cdh()
  {
    return true;
  }
  
  public void cdi() {}
  
  protected void d(GetEmotionListResponse paramGetEmotionListResponse)
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
      ac.d("MicroMsg.emoji.BaseEmojiStoreUI", "jacks save EmoijStoreUI Cache: list:%d, size: %d, type: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(ccZ()) });
      com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().GYc.a(ccZ(), paramGetEmotionListResponse);
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
    return 2131493800;
  }
  
  public void i(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    ac.d("MicroMsg.emoji.BaseEmojiStoreUI", "[onExchange] productId:[%s] status:[%d] progress:[%d] cdnClientId:[%s]", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString2 });
    if (this.paX == null) {}
    com.tencent.mm.plugin.emoji.a.a.c localc;
    do
    {
      return;
      localc = this.paX.oXZ;
    } while (localc == null);
    if (paramInt1 == 6) {
      cQ(paramString1, paramInt2);
    }
    for (;;)
    {
      paramString1 = localc.XB(paramString1);
      if (paramString1 == null) {
        break;
      }
      paramString1.oYo = paramString2;
      return;
      ac.i("MicroMsg.emoji.BaseEmojiStoreUI", "product status:%d", new Object[] { Integer.valueOf(paramInt1) });
      cP(paramString1, paramInt1);
    }
  }
  
  public void initView()
  {
    setBackBtn(new BaseEmojiStoreUI.b(this, (byte)0));
    ccP();
    this.EP = findViewById(2131299457);
    this.pdC = ((TextView)this.EP.findViewById(2131299461));
    this.pdF = getLayoutInflater().inflate(2131493799, null);
    this.pdF.setVisibility(8);
    if (ccW()) {
      this.pdy = new EmojiStoreVpHeader(getContext());
    }
    if (ccX())
    {
      this.pdz = LayoutInflater.from(this).inflate(2131493832, null);
      int i = EmojiStoreVpHeader.eB(getContext())[0];
      AbsListView.LayoutParams localLayoutParams = new AbsListView.LayoutParams(i, i * 3 / 8 + 1);
      this.pdz.setLayoutParams(localLayoutParams);
      this.pdA = ((StoreBannerEmojiView)this.pdz.findViewById(2131299332));
    }
    this.mListView = ((ListView)findViewById(16908298));
    this.mListView.setOnItemClickListener(this);
    if (ccW()) {
      this.mListView.addHeaderView(this.pdy);
    }
    for (;;)
    {
      if (cdh()) {
        this.mListView.addFooterView(this.pdF);
      }
      ccT();
      this.mListView.setAdapter(this.paX);
      this.mListView.setOnScrollListener(this);
      this.paX.oXY = this.mListView;
      ccU();
      return;
      if (ccX()) {
        this.mListView.addHeaderView(this.pdz);
      }
    }
  }
  
  public final void l(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      d((GetEmotionListResponse)paramMessage.obj);
      return;
      cdf();
      return;
      paramMessage = (String)paramMessage.obj;
      if (isFinishing())
      {
        ac.i("MicroMsg.emoji.BaseEmojiStoreUI", "[updateLoadingDialog] acitivity is finished.");
        return;
      }
    } while (this.iFC == null);
    this.iFC.setMessage(paramMessage);
  }
  
  public final void l(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    m(paramString1, paramString2, paramString3, paramString4);
    cdd();
  }
  
  protected final com.tencent.mm.plugin.emoji.f.g m(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.pdW = new com.tencent.mm.plugin.emoji.f.g(paramString1, paramString2, paramString3, paramString4);
    return this.pdW;
  }
  
  public void m(Message paramMessage)
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
            } while (this.paX == null);
            this.paX.notifyDataSetChanged();
            cdi();
            return;
          } while ((this.paX == null) || (paramMessage.getData() == null));
          str = paramMessage.getData().getString("product_id");
        } while (str == null);
        i = paramMessage.getData().getInt("progress");
        this.paX.cQ(str, i);
        return;
      } while ((this.paX == null) || (paramMessage.getData() == null));
      str = paramMessage.getData().getString("product_id");
    } while (str == null);
    int i = paramMessage.getData().getInt("status");
    this.paX.cP(str, i);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    ac.d("MicroMsg.emoji.BaseEmojiStoreUI", "onActivityResult . requestCode:" + paramInt1 + "  resultCode:" + paramInt2);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.pdT.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.pdT = new j();
    initView();
    this.pdR = getIntent().getIntExtra("preceding_scence", 2);
    if (com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().GYa != null) {
      com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().GYa.add(this);
    }
    this.pdV = new a((byte)0);
    com.tencent.mm.sdk.b.a.GpY.c(this.pdV);
    this.pdT.mHB = this;
    this.pdT.paX = this.paX;
    this.pdT.pba = ccQ();
    this.pdT.pbd = this;
    boolean bool2 = cdg();
    boolean bool1 = bool2;
    if (bool2) {
      bool1 = cde();
    }
    K(false, bool1);
    if (pdU == null) {
      pdU = new HashMap();
    }
    long l = System.currentTimeMillis();
    ac.d("MicroMsg.emoji.BaseEmojiStoreUI", "refresh last net refresh time: %d", new Object[] { Long.valueOf(l) });
    pdU.put(getClass().toString(), Long.valueOf(l));
    this.pbf = new com.tencent.mm.plugin.emoji.h.c(1005);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.paX != null)
    {
      this.paX.clear();
      this.paX = null;
    }
    if ((ccW()) && (this.pdy != null)) {
      this.pdy.clear();
    }
    com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().GYa.remove(this);
    com.tencent.mm.sdk.b.a.GpY.d(this.pdV);
    com.tencent.mm.kernel.g.agQ().ghe.a(this.pdW);
    if (this.pdT != null)
    {
      j localj = this.pdT;
      localj.paX = null;
      localj.pbd = null;
      localj.mHB = null;
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i;
    if (!ccW())
    {
      i = paramInt;
      if (!ccX()) {}
    }
    else if (paramInt != 0) {}
    while ((i < 0) || (i >= this.paX.getCount()))
    {
      return;
      i = paramInt - 1;
    }
    a(this.paX.Bk(i), i);
  }
  
  public void onPause()
  {
    super.onPause();
    com.tencent.mm.kernel.g.agQ().ghe.b(411, this);
    com.tencent.mm.kernel.g.agQ().ghe.b(423, this);
    com.tencent.mm.kernel.g.agQ().ghe.b(413, this);
    com.tencent.mm.kernel.g.agQ().ghe.b(717, this);
    cdc();
    if ((ccW()) && (this.pdy != null)) {
      this.pdy.cdU();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    com.tencent.mm.kernel.g.agQ().ghe.a(411, this);
    com.tencent.mm.kernel.g.agQ().ghe.a(423, this);
    com.tencent.mm.kernel.g.agQ().ghe.a(413, this);
    com.tencent.mm.kernel.g.agQ().ghe.a(717, this);
    if ((ccW()) && (this.pdy != null)) {
      this.pdy.cdT();
    }
    Boolean localBoolean = Boolean.FALSE;
    this.pdT.paY = false;
    if ((this.paX != null) && (this.paX.oXZ != null))
    {
      this.paX.oXZ.cbK();
      this.paX.refreshView();
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, final com.tencent.mm.ak.n paramn)
  {
    final String str1;
    if (TextUtils.isEmpty(paramString))
    {
      str1 = "";
      ac.i("MicroMsg.emoji.BaseEmojiStoreUI", "jacks [onSceneEnd] errType:%d,errCode:%d,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str1 });
      cdf();
      switch (paramn.getType())
      {
      default: 
        ac.e("MicroMsg.emoji.BaseEmojiStoreUI", "unknow scene type");
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          str1 = paramString;
          break;
        } while (!(paramn instanceof com.tencent.mm.plugin.emoji.f.n));
        a(paramInt1, paramInt2, paramString, (com.tencent.mm.plugin.emoji.f.n)paramn);
        return;
      } while (!(paramn instanceof com.tencent.mm.plugin.emoji.f.g));
      paramString = (com.tencent.mm.plugin.emoji.f.g)paramn;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        a(paramString);
        return;
      }
      paramn = paramString.pbW;
      str1 = paramString.pbY;
      final String str2 = paramString.pbX;
      h.a(this, getString(2131758320, new Object[] { str2 }), "", new DialogInterface.OnClickListener()new BaseEmojiStoreUI.2
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(108784);
          BaseEmojiStoreUI.this.m(paramn, str1, str2, null);
          BaseEmojiStoreUI.this.cdd();
          ac.i("MicroMsg.emoji.BaseEmojiStoreUI", "Retry doScene ExchangeEmotionPackNetScene productId:%s", new Object[] { paramn });
          BaseEmojiStoreUI.a(BaseEmojiStoreUI.this, paramn);
          AppMethodBeat.o(108784);
        }
      }, new BaseEmojiStoreUI.2(this));
      cP(paramString.pbW, -1);
      return;
      paramString = (com.tencent.mm.plugin.emoji.f.q)paramn;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().GYa.aOM(paramString.pbW);
        paramString = new Message();
        paramString.what = 2002;
        paramString.obj = getContext().getString(2131755910);
        n(paramString);
      }
      for (;;)
      {
        fh(20001, 800);
        return;
        paramString = new Message();
        paramString.what = 2002;
        paramString.obj = getContext().getString(2131758251);
        n(paramString);
      }
    } while ((paramInt1 != 0) || (paramInt2 != 0));
    this.pdG = null;
    K(false, true);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1))
    {
      if ((this.pdE == 0) || (this.kOL)) {
        ac.d("MicroMsg.emoji.BaseEmojiStoreUI", "No More List.");
      }
    }
    else {
      return;
    }
    K(true, false);
    ac.i("MicroMsg.emoji.BaseEmojiStoreUI", "[onScrollStateChanged] startLoadRemoteEmoji.");
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends com.tencent.mm.sdk.b.c<di>
  {
    private a()
    {
      AppMethodBeat.i(161086);
      this.__eventId = di.class.getName().hashCode();
      AppMethodBeat.o(161086);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI
 * JD-Core Version:    0.7.0.1
 */