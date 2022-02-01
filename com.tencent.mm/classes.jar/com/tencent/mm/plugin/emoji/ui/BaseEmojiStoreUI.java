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
import com.tencent.mm.g.a.dl;
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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bd;
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
  implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener, com.tencent.mm.al.f, com.tencent.mm.plugin.emoji.model.j.a, j.b, com.tencent.mm.pluginsdk.model.j.a, k.a, MMPullDownView.c, MMPullDownView.d, MMPullDownView.e
{
  private static Map<String, Long> pHw;
  protected View GG;
  private ProgressDialog iYL;
  private boolean llo;
  public ListView mListView;
  public com.tencent.mm.plugin.emoji.a.a.a pEH;
  private com.tencent.mm.plugin.emoji.h.c pEP;
  private LinkedList<EmotionBanner> pHA = new LinkedList();
  private LinkedList<EmotionBannerSet> pHB = new LinkedList();
  protected EmojiStoreVpHeader pHa;
  protected View pHb;
  protected StoreBannerEmojiView pHc;
  protected MMPullDownView pHd;
  protected TextView pHe;
  protected boolean pHf = false;
  int pHg = -1;
  private View pHh;
  protected byte[] pHi;
  private final int pHj = 65537;
  private final int pHk = 20001;
  private final int pHl = 2002;
  protected final int pHm = 131074;
  private final int pHn = 131075;
  private final int pHo = 131076;
  private final String pHp = "product_id";
  private final String pHq = "progress";
  private final String pHr = "status";
  private com.tencent.mm.plugin.emoji.f.n pHs;
  private int pHt;
  private com.tencent.mm.plugin.emoji.model.f pHu;
  protected j pHv;
  private com.tencent.mm.sdk.b.c pHx;
  protected com.tencent.mm.plugin.emoji.f.g pHy;
  protected boolean pHz = false;
  
  private void a(int paramInt, com.tencent.mm.plugin.emoji.model.f paramf, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = false;
    ad.d("MicroMsg.emoji.BaseEmojiStoreUI", "");
    boolean bool1 = bool2;
    switch (paramInt)
    {
    default: 
      bool1 = bool2;
    case 0: 
      if (this.pHu != null) {
        this.pHu.cgK();
      }
      a(bool1, this.pHu, paramBoolean1, paramBoolean2);
      return;
    case -1: 
      this.pHu = paramf;
    }
    for (;;)
    {
      bool1 = true;
      break;
      this.pHu = paramf;
      continue;
      if (this.pHu == null) {
        this.pHu = new com.tencent.mm.plugin.emoji.model.f();
      }
      if (paramf != null)
      {
        this.pHu.Ca(paramf.pEi);
        this.pHu.cO(paramf.pEj);
      }
    }
  }
  
  private com.tencent.mm.plugin.emoji.f.n aY(byte[] paramArrayOfByte)
  {
    int i = chC();
    int j = aZ(paramArrayOfByte);
    int k = chD();
    com.tencent.mm.plugin.emoji.f.n localn;
    if (paramArrayOfByte != null)
    {
      ad.i("MicroMsg.emoji.BaseEmojiStoreUI", "[startLoadRemoteEmoji] request buffer %s", new Object[] { paramArrayOfByte.toString() });
      localn = new com.tencent.mm.plugin.emoji.f.n(i, paramArrayOfByte, j);
      paramArrayOfByte = localn;
      if (i == 7)
      {
        localn.pGc = k;
        paramArrayOfByte = localn;
      }
    }
    for (;;)
    {
      this.pHs = paramArrayOfByte;
      return paramArrayOfByte;
      ad.i("MicroMsg.emoji.BaseEmojiStoreUI", "[startLoadRemoteEmoji] request buffer is null.");
      localn = new com.tencent.mm.plugin.emoji.f.n(i, j);
      paramArrayOfByte = localn;
      if (i == 7)
      {
        localn.pGc = k;
        paramArrayOfByte = localn;
      }
    }
  }
  
  private void c(GetEmotionListResponse paramGetEmotionListResponse)
  {
    if (this.pHg == -1)
    {
      Message localMessage = Message.obtain();
      localMessage.what = 65537;
      localMessage.obj = paramGetEmotionListResponse;
      o(localMessage);
    }
  }
  
  private void cS(String paramString, int paramInt)
  {
    Message localMessage = Message.obtain();
    localMessage.getData().putString("product_id", paramString);
    localMessage.getData().putInt("status", paramInt);
    localMessage.what = 131076;
    n(localMessage);
  }
  
  private void cT(String paramString, int paramInt)
  {
    Message localMessage = Message.obtain();
    localMessage.getData().putString("product_id", paramString);
    localMessage.getData().putInt("progress", paramInt);
    localMessage.what = 131075;
    n(localMessage);
  }
  
  private void chB()
  {
    com.tencent.mm.plugin.emoji.a.a.b.a(this.pEH.pBJ, this);
  }
  
  private void chE()
  {
    com.tencent.mm.kernel.g.ajB().gAO.a(this.pHs, 0);
  }
  
  protected final void L(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.llo = true;
    if (paramBoolean1) {
      this.pHh.setVisibility(0);
    }
    aY(this.pHi);
    chE();
    ad.i("MicroMsg.emoji.BaseEmojiStoreUI", "[startLoadRemoteEmoji] doScene GetEmotionListNetScene");
    if ((!paramBoolean1) && (!paramBoolean2)) {
      aRX();
    }
  }
  
  public final void R(ArrayList<p> paramArrayList)
  {
    ad.d("MicroMsg.emoji.BaseEmojiStoreUI", "google [onQueryFinish]");
    if (this.pEH == null) {}
    do
    {
      return;
      com.tencent.mm.plugin.emoji.a.a.b.a(paramArrayList, this.pEH.pBJ);
    } while (this.pIx == null);
    this.pIx.removeMessages(131074);
    this.pIx.sendEmptyMessage(131074);
  }
  
  protected void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.plugin.emoji.f.n paramn)
  {
    if ((paramn != null) && (paramn.mType == chC()))
    {
      this.llo = false;
      this.pHh.setVisibility(8);
      paramString = null;
      try
      {
        com.tencent.mm.plugin.emoji.model.f localf = com.tencent.mm.plugin.emoji.f.n.b(paramn.chj());
        paramString = localf;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.m("MicroMsg.emoji.BaseEmojiStoreUI", "deal NetGetEmotionList error:%s", new Object[] { localException.toString() });
          continue;
          paramInt1 = 0;
        }
        if (paramInt2 != 2) {
          break label187;
        }
        paramn = paramn.chj();
        a(this.pHg, paramString, false, false);
        chB();
        c(paramn);
        this.pHg = 2;
        return;
        if (paramInt2 != 3) {
          break label209;
        }
        a(this.pHg, paramString, false, false);
        this.pHg = 1;
        return;
        this.GG.setVisibility(0);
        this.pHf = true;
        if (chC() != 7) {
          break label242;
        }
        this.pHe.setText(2131758380);
        return;
        this.pHe.setText(2131758330);
        return;
      }
      if (paramString != null) {
        if ((paramInt1 == 0) || (paramInt1 == 4))
        {
          paramInt1 = 1;
          if (paramInt1 == 0) {
            break label253;
          }
          this.GG.setVisibility(8);
          this.pHf = false;
          this.pHi = paramn.pGa;
          if (paramInt2 != 0) {
            break label148;
          }
          paramn = paramn.chj();
          a(paramString, false, true);
          c(paramn);
          this.pHg = 0;
        }
      }
      label148:
      label187:
      label209:
      label242:
      label253:
      while (this.pHz) {
        return;
      }
      this.GG.setVisibility(0);
      this.pHf = true;
      this.pHe.setText(2131758331);
      return;
    }
    paramInt2 = chC();
    if (paramn == null) {}
    for (paramInt1 = -1;; paramInt1 = paramn.mType)
    {
      ad.i("MicroMsg.emoji.BaseEmojiStoreUI", "no some scene type. this ui type:%d callbak type:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
      return;
    }
  }
  
  protected void a(com.tencent.mm.plugin.emoji.a.a.f paramf, int paramInt)
  {
    if (paramf == null)
    {
      ad.i("MicroMsg.emoji.BaseEmojiStoreUI", "item is null.");
      return;
    }
    if (paramf.pBU == f.a.pCd)
    {
      paramf = paramf.pBW;
      if (paramf == null)
      {
        ad.i("MicroMsg.emoji.BaseEmojiStoreUI", "banner set is null. do nothing");
        return;
      }
      com.tencent.mm.plugin.emoji.e.k.a(getContext(), paramf, false);
      return;
    }
    EmotionSummary localEmotionSummary = paramf.pBV;
    if (localEmotionSummary == null)
    {
      ad.i("MicroMsg.emoji.BaseEmojiStoreUI", "summary is null. do nothing");
      return;
    }
    String str = getIntent().getStringExtra("to_talker_name");
    com.tencent.mm.plugin.emoji.e.k.a(getContext(), localEmotionSummary, cht(), paramf.mStatus, paramf.Hx, str, chu());
  }
  
  public final void a(com.tencent.mm.plugin.emoji.a.a parama)
  {
    String str2 = parama.getProductId();
    String str1;
    if (TextUtils.isEmpty(parama.cgb()))
    {
      str1 = "";
      ad.i("MicroMsg.emoji.BaseEmojiStoreUI", "[onProductClick] productId:%s, productPrice:%s, productStatus:%d", new Object[] { str2, str1, Integer.valueOf(parama.cga()) });
      if (parama.cga() == 9)
      {
        str1 = getString(2131755913);
        if (!isFinishing()) {
          break label97;
        }
        ad.i("MicroMsg.emoji.BaseEmojiStoreUI", "[showLoadingDialog] acitivity is finished.");
      }
    }
    for (;;)
    {
      this.pHv.a(parama);
      return;
      str1 = parama.cgb();
      break;
      label97:
      getString(2131755906);
      this.iYL = h.b(this, str1, true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(108786);
          BaseEmojiStoreUI.chM();
          AppMethodBeat.o(108786);
        }
      });
    }
  }
  
  protected void a(com.tencent.mm.plugin.emoji.f.g paramg)
  {
    cT(paramg.pFG, 0);
  }
  
  protected void a(com.tencent.mm.plugin.emoji.model.f paramf, boolean paramBoolean1, boolean paramBoolean2)
  {
    ad.d("MicroMsg.emoji.BaseEmojiStoreUI", "jacks initData begin");
    if ((paramf != null) && (paramf.pEj.size() > 0))
    {
      this.pHz = true;
      this.GG.setVisibility(8);
      this.pHf = false;
    }
    a(this.pHg, paramf, paramBoolean1, paramBoolean2);
    chB();
  }
  
  public void a(String paramString, m paramm)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals("delete_group")))
    {
      chS();
      fl(131074, 50);
    }
  }
  
  protected void a(boolean paramBoolean1, com.tencent.mm.plugin.emoji.model.f paramf, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((this.pHu != null) && (paramBoolean1)) {
      if (chz())
      {
        if ((this.pHu != null) && (this.pHu.pEk != null) && (this.pHu.pEk.BannerSummary != null)) {
          break label75;
        }
        ad.d("MicroMsg.emoji.BaseEmojiStoreUI", "update store ui header failed. ");
      }
    }
    for (;;)
    {
      if (this.pEH != null) {
        this.pEH.b(this.pHu);
      }
      return;
      label75:
      this.pHA = ((LinkedList)this.pHu.pEl);
      this.pHB = ((LinkedList)this.pHu.pEm);
      if (this.pHA != null)
      {
        this.pHa.d(this.pHA, this.pHB);
      }
      else if (this.pHu.pEk != null)
      {
        this.pHA = new LinkedList();
        this.pHA.add(this.pHu.pEk);
        this.pHa.d(this.pHA, this.pHB);
      }
    }
  }
  
  protected final void aRX()
  {
    if (isFinishing())
    {
      ad.i("MicroMsg.emoji.BaseEmojiStoreUI", "[showLoadingDialog] acitivity is finished.");
      return;
    }
    getString(2131755906);
    this.iYL = h.b(this, getString(2131755936), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(108785);
        BaseEmojiStoreUI.this.chF();
        BaseEmojiStoreUI.chM();
        AppMethodBeat.o(108785);
      }
    });
  }
  
  protected int aZ(byte[] paramArrayOfByte)
  {
    return this.pHt;
  }
  
  protected void abX(String paramString) {}
  
  public final boolean cba()
  {
    L(true, false);
    ad.i("MicroMsg.emoji.BaseEmojiStoreUI", "[onBottomLoadData] startLoadRemoteEmoji.");
    return true;
  }
  
  public final boolean cbb()
  {
    return false;
  }
  
  public final boolean cbc()
  {
    return false;
  }
  
  public final void cgM()
  {
    this.pHi = null;
    this.pHg = -1;
    L(false, false);
  }
  
  protected boolean chA()
  {
    return false;
  }
  
  protected abstract int chC();
  
  public int chD()
  {
    return 0;
  }
  
  protected final void chF()
  {
    com.tencent.mm.kernel.g.ajB().gAO.a(this.pHs);
  }
  
  protected final void chG()
  {
    com.tencent.mm.kernel.g.ajB().gAO.a(this.pHy, 0);
  }
  
  protected boolean chH()
  {
    GetEmotionListResponse localGetEmotionListResponse = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().ILq.abh(chC());
    com.tencent.mm.plugin.emoji.model.f localf = com.tencent.mm.plugin.emoji.f.n.b(localGetEmotionListResponse);
    int j = chC();
    if (localGetEmotionListResponse == null) {}
    for (int i = 0;; i = localGetEmotionListResponse.EmotionCount)
    {
      ad.d("MicroMsg.emoji.BaseEmojiStoreUI", "load cache type: %d, size: %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      if (localf != null) {
        break;
      }
      return false;
    }
    if (localf.pEj.size() <= 0) {}
    for (boolean bool = false; bool; bool = true)
    {
      ad.d("MicroMsg.emoji.BaseEmojiStoreUI", "jacks init EmoijStoreUI  by Cache: list:%d", new Object[] { Integer.valueOf(localf.pEj.size()) });
      a(localf, true, false);
      return bool;
    }
    ad.d("MicroMsg.emoji.BaseEmojiStoreUI", "jacks init EmoijStoreUI  by NET");
    return bool;
  }
  
  protected final void chI()
  {
    if ((this.iYL != null) && (this.iYL.isShowing())) {
      this.iYL.dismiss();
    }
  }
  
  protected boolean chJ()
  {
    return false;
  }
  
  protected boolean chK()
  {
    return true;
  }
  
  public void chL() {}
  
  protected void chs()
  {
    this.pEH = chv();
    this.pEH.pBK = this;
  }
  
  protected abstract int cht();
  
  protected abstract int chu();
  
  protected abstract com.tencent.mm.plugin.emoji.a.a.a chv();
  
  protected void chw() {}
  
  protected void chx()
  {
    if (!chy()) {}
    do
    {
      return;
      this.pHd = ((MMPullDownView)findViewById(2131301487));
    } while (this.pHd == null);
    this.pHd.setTopViewVisible(false);
    this.pHd.setAtTopCallBack(this);
    this.pHd.setOnBottomLoadDataListener(this);
    this.pHd.setAtBottomCallBack(this);
    this.pHd.setBottomViewVisible(false);
    this.pHd.setIsBottomShowAll(false);
  }
  
  protected boolean chy()
  {
    return true;
  }
  
  protected boolean chz()
  {
    return true;
  }
  
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
      ad.d("MicroMsg.emoji.BaseEmojiStoreUI", "jacks save EmoijStoreUI Cache: list:%d, size: %d, type: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(chC()) });
      com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().ILq.a(chC(), paramGetEmotionListResponse);
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
    ad.d("MicroMsg.emoji.BaseEmojiStoreUI", "[onExchange] productId:[%s] status:[%d] progress:[%d] cdnClientId:[%s]", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString2 });
    if (this.pEH == null) {}
    com.tencent.mm.plugin.emoji.a.a.c localc;
    do
    {
      return;
      localc = this.pEH.pBJ;
    } while (localc == null);
    if (paramInt1 == 6) {
      cT(paramString1, paramInt2);
    }
    for (;;)
    {
      paramString1 = localc.abi(paramString1);
      if (paramString1 == null) {
        break;
      }
      paramString1.pBY = paramString2;
      return;
      ad.i("MicroMsg.emoji.BaseEmojiStoreUI", "product status:%d", new Object[] { Integer.valueOf(paramInt1) });
      cS(paramString1, paramInt1);
    }
  }
  
  public void initView()
  {
    setBackBtn(new b((byte)0));
    chs();
    this.GG = findViewById(2131299457);
    this.pHe = ((TextView)this.GG.findViewById(2131299461));
    this.pHh = getLayoutInflater().inflate(2131493799, null);
    this.pHh.setVisibility(8);
    if (chz()) {
      this.pHa = new EmojiStoreVpHeader(getContext());
    }
    if (chA())
    {
      this.pHb = LayoutInflater.from(this).inflate(2131493832, null);
      int i = EmojiStoreVpHeader.eB(getContext())[0];
      AbsListView.LayoutParams localLayoutParams = new AbsListView.LayoutParams(i, i * 3 / 8 + 1);
      this.pHb.setLayoutParams(localLayoutParams);
      this.pHc = ((StoreBannerEmojiView)this.pHb.findViewById(2131299332));
    }
    this.mListView = ((ListView)findViewById(16908298));
    this.mListView.setOnItemClickListener(this);
    if (chz()) {
      this.mListView.addHeaderView(this.pHa);
    }
    for (;;)
    {
      if (chK()) {
        this.mListView.addFooterView(this.pHh);
      }
      chw();
      this.mListView.setAdapter(this.pEH);
      this.mListView.setOnScrollListener(this);
      this.pEH.pBI = this.mListView;
      chx();
      return;
      if (chA()) {
        this.mListView.addHeaderView(this.pHb);
      }
    }
  }
  
  public final void k(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    l(paramString1, paramString2, paramString3, paramString4);
    chG();
  }
  
  protected final com.tencent.mm.plugin.emoji.f.g l(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.pHy = new com.tencent.mm.plugin.emoji.f.g(paramString1, paramString2, paramString3, paramString4);
    return this.pHy;
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
      chI();
      return;
      paramMessage = (String)paramMessage.obj;
      if (isFinishing())
      {
        ad.i("MicroMsg.emoji.BaseEmojiStoreUI", "[updateLoadingDialog] acitivity is finished.");
        return;
      }
    } while (this.iYL == null);
    this.iYL.setMessage(paramMessage);
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
            } while (this.pEH == null);
            this.pEH.notifyDataSetChanged();
            chL();
            return;
          } while ((this.pEH == null) || (paramMessage.getData() == null));
          str = paramMessage.getData().getString("product_id");
        } while (str == null);
        i = paramMessage.getData().getInt("progress");
        this.pEH.cT(str, i);
        return;
      } while ((this.pEH == null) || (paramMessage.getData() == null));
      str = paramMessage.getData().getString("product_id");
    } while (str == null);
    int i = paramMessage.getData().getInt("status");
    this.pEH.cS(str, i);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    ad.d("MicroMsg.emoji.BaseEmojiStoreUI", "onActivityResult . requestCode:" + paramInt1 + "  resultCode:" + paramInt2);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.pHv.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.pHv = new j();
    initView();
    this.pHt = getIntent().getIntExtra("preceding_scence", 2);
    if (com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().ILo != null) {
      com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().ILo.add(this);
    }
    this.pHx = new a((byte)0);
    com.tencent.mm.sdk.b.a.IbL.c(this.pHx);
    this.pHv.nhZ = this;
    this.pHv.pEH = this.pEH;
    this.pHv.pEK = cht();
    this.pHv.pEN = this;
    boolean bool2 = chJ();
    boolean bool1 = bool2;
    if (bool2) {
      bool1 = chH();
    }
    L(false, bool1);
    if (pHw == null) {
      pHw = new HashMap();
    }
    long l = System.currentTimeMillis();
    ad.d("MicroMsg.emoji.BaseEmojiStoreUI", "refresh last net refresh time: %d", new Object[] { Long.valueOf(l) });
    pHw.put(getClass().toString(), Long.valueOf(l));
    this.pEP = new com.tencent.mm.plugin.emoji.h.c(1005);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.pEH != null)
    {
      this.pEH.clear();
      this.pEH = null;
    }
    if ((chz()) && (this.pHa != null)) {
      this.pHa.clear();
    }
    com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().ILo.remove(this);
    com.tencent.mm.sdk.b.a.IbL.d(this.pHx);
    com.tencent.mm.kernel.g.ajB().gAO.a(this.pHy);
    if (this.pHv != null)
    {
      j localj = this.pHv;
      localj.pEH = null;
      localj.pEN = null;
      localj.nhZ = null;
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramAdapterView);
    localb.bd(paramView);
    localb.mr(paramInt);
    localb.qY(paramLong);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/BaseEmojiStoreUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
    int i;
    if (!chz())
    {
      i = paramInt;
      if (!chA()) {}
    }
    else
    {
      if (paramInt == 0)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/BaseEmojiStoreUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        return;
      }
      i = paramInt - 1;
    }
    if ((i < 0) || (i >= this.pEH.getCount()))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/BaseEmojiStoreUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      return;
    }
    a(this.pEH.BS(i), i);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/BaseEmojiStoreUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
  }
  
  public void onPause()
  {
    super.onPause();
    com.tencent.mm.kernel.g.ajB().gAO.b(411, this);
    com.tencent.mm.kernel.g.ajB().gAO.b(423, this);
    com.tencent.mm.kernel.g.ajB().gAO.b(413, this);
    com.tencent.mm.kernel.g.ajB().gAO.b(717, this);
    chF();
    if ((chz()) && (this.pHa != null)) {
      this.pHa.cix();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    com.tencent.mm.kernel.g.ajB().gAO.a(411, this);
    com.tencent.mm.kernel.g.ajB().gAO.a(423, this);
    com.tencent.mm.kernel.g.ajB().gAO.a(413, this);
    com.tencent.mm.kernel.g.ajB().gAO.a(717, this);
    if ((chz()) && (this.pHa != null)) {
      this.pHa.ciw();
    }
    Boolean localBoolean = Boolean.FALSE;
    this.pHv.pEI = false;
    if ((this.pEH != null) && (this.pEH.pBJ != null))
    {
      this.pEH.pBJ.cgo();
      this.pEH.refreshView();
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, final com.tencent.mm.al.n paramn)
  {
    final String str1;
    if (TextUtils.isEmpty(paramString))
    {
      str1 = "";
      ad.i("MicroMsg.emoji.BaseEmojiStoreUI", "jacks [onSceneEnd] errType:%d,errCode:%d,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str1 });
      chI();
      switch (paramn.getType())
      {
      default: 
        ad.e("MicroMsg.emoji.BaseEmojiStoreUI", "unknow scene type");
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
      paramn = paramString.pFG;
      str1 = paramString.pFI;
      final String str2 = paramString.pFH;
      h.a(this, getString(2131758320, new Object[] { str2 }), "", new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(108784);
          BaseEmojiStoreUI.this.l(paramn, str1, str2, null);
          BaseEmojiStoreUI.this.chG();
          ad.i("MicroMsg.emoji.BaseEmojiStoreUI", "Retry doScene ExchangeEmotionPackNetScene productId:%s", new Object[] { paramn });
          BaseEmojiStoreUI.a(BaseEmojiStoreUI.this, paramn);
          AppMethodBeat.o(108784);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      cS(paramString.pFG, -1);
      return;
      paramString = (com.tencent.mm.plugin.emoji.f.q)paramn;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().ILo.aUD(paramString.pFG);
        paramString = new Message();
        paramString.what = 2002;
        paramString.obj = getContext().getString(2131755910);
        n(paramString);
      }
      for (;;)
      {
        fl(20001, 800);
        return;
        paramString = new Message();
        paramString.what = 2002;
        paramString.obj = getContext().getString(2131758251);
        n(paramString);
      }
    } while ((paramInt1 != 0) || (paramInt2 != 0));
    this.pHi = null;
    L(false, true);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1))
    {
      if ((this.pHg == 0) || (this.llo)) {
        ad.d("MicroMsg.emoji.BaseEmojiStoreUI", "No More List.");
      }
    }
    else {
      return;
    }
    L(true, false);
    ad.i("MicroMsg.emoji.BaseEmojiStoreUI", "[onScrollStateChanged] startLoadRemoteEmoji.");
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends com.tencent.mm.sdk.b.c<dl>
  {
    private a()
    {
      AppMethodBeat.i(161086);
      this.__eventId = dl.class.getName().hashCode();
      AppMethodBeat.o(161086);
    }
  }
  
  final class b
    implements MenuItem.OnMenuItemClickListener
  {
    private b() {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(108788);
      BaseEmojiStoreUI.this.finish();
      AppMethodBeat.o(108788);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI
 * JD-Core Version:    0.7.0.1
 */