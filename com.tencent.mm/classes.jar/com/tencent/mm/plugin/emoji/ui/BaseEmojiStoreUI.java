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
import com.tencent.mm.g.a.dh;
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
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.emotion.r;
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
  implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener, com.tencent.mm.al.g, com.tencent.mm.plugin.emoji.model.j.a, j.b, com.tencent.mm.pluginsdk.model.j.a, k.a, MMPullDownView.c, MMPullDownView.d, MMPullDownView.e
{
  private static Map<String, Long> oAu;
  protected View DR;
  private ProgressDialog ift;
  private boolean knt;
  public ListView mListView;
  protected StoreBannerEmojiView oAa;
  protected MMPullDownView oAb;
  protected TextView oAc;
  protected boolean oAd = false;
  int oAe = -1;
  private View oAf;
  protected byte[] oAg;
  private final int oAh = 65537;
  private final int oAi = 20001;
  private final int oAj = 2002;
  protected final int oAk = 131074;
  private final int oAl = 131075;
  private final int oAm = 131076;
  private final String oAn = "product_id";
  private final String oAo = "progress";
  private final String oAp = "status";
  private com.tencent.mm.plugin.emoji.f.n oAq;
  private int oAr;
  private com.tencent.mm.plugin.emoji.model.f oAs;
  protected j oAt;
  private com.tencent.mm.sdk.b.c oAv;
  protected com.tencent.mm.plugin.emoji.f.g oAw;
  protected boolean oAx = false;
  private LinkedList<EmotionBanner> oAy = new LinkedList();
  private LinkedList<EmotionBannerSet> oAz = new LinkedList();
  private com.tencent.mm.plugin.emoji.h.c oxF;
  public com.tencent.mm.plugin.emoji.a.a.a oxx;
  protected EmojiStoreVpHeader ozY;
  protected View ozZ;
  
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
      if (this.oAs != null) {
        this.oAs.bUT();
      }
      a(bool1, this.oAs, paramBoolean1, paramBoolean2);
      return;
    case -1: 
      this.oAs = paramf;
    }
    for (;;)
    {
      bool1 = true;
      break;
      this.oAs = paramf;
      continue;
      if (this.oAs == null) {
        this.oAs = new com.tencent.mm.plugin.emoji.model.f();
      }
      if (paramf != null)
      {
        this.oAs.AA(paramf.owY);
        this.oAs.cL(paramf.owZ);
      }
    }
  }
  
  private com.tencent.mm.plugin.emoji.f.n aX(byte[] paramArrayOfByte)
  {
    int i = bVM();
    int j = aY(paramArrayOfByte);
    int k = bVN();
    com.tencent.mm.plugin.emoji.f.n localn;
    if (paramArrayOfByte != null)
    {
      ad.i("MicroMsg.emoji.BaseEmojiStoreUI", "[startLoadRemoteEmoji] request buffer %s", new Object[] { paramArrayOfByte.toString() });
      localn = new com.tencent.mm.plugin.emoji.f.n(i, paramArrayOfByte, j);
      paramArrayOfByte = localn;
      if (i == 7)
      {
        localn.oyS = k;
        paramArrayOfByte = localn;
      }
    }
    for (;;)
    {
      this.oAq = paramArrayOfByte;
      return paramArrayOfByte;
      ad.i("MicroMsg.emoji.BaseEmojiStoreUI", "[startLoadRemoteEmoji] request buffer is null.");
      localn = new com.tencent.mm.plugin.emoji.f.n(i, j);
      paramArrayOfByte = localn;
      if (i == 7)
      {
        localn.oyS = k;
        paramArrayOfByte = localn;
      }
    }
  }
  
  private void bVL()
  {
    com.tencent.mm.plugin.emoji.a.a.b.a(this.oxx.ouz, this);
  }
  
  private void bVO()
  {
    com.tencent.mm.kernel.g.afA().gcy.a(this.oAq, 0);
  }
  
  private void c(GetEmotionListResponse paramGetEmotionListResponse)
  {
    if (this.oAe == -1)
    {
      Message localMessage = Message.obtain();
      localMessage.what = 65537;
      localMessage.obj = paramGetEmotionListResponse;
      o(localMessage);
    }
  }
  
  private void cK(String paramString, int paramInt)
  {
    Message localMessage = Message.obtain();
    localMessage.getData().putString("product_id", paramString);
    localMessage.getData().putInt("status", paramInt);
    localMessage.what = 131076;
    n(localMessage);
  }
  
  private void cL(String paramString, int paramInt)
  {
    Message localMessage = Message.obtain();
    localMessage.getData().putString("product_id", paramString);
    localMessage.getData().putInt("progress", paramInt);
    localMessage.what = 131075;
    n(localMessage);
  }
  
  protected final void I(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.knt = true;
    if (paramBoolean1) {
      this.oAf.setVisibility(0);
    }
    aX(this.oAg);
    bVO();
    ad.i("MicroMsg.emoji.BaseEmojiStoreUI", "[startLoadRemoteEmoji] doScene GetEmotionListNetScene");
    if ((!paramBoolean1) && (!paramBoolean2)) {
      aHU();
    }
  }
  
  public final void M(ArrayList<p> paramArrayList)
  {
    ad.d("MicroMsg.emoji.BaseEmojiStoreUI", "google [onQueryFinish]");
    if (this.oxx == null) {}
    do
    {
      return;
      com.tencent.mm.plugin.emoji.a.a.b.a(paramArrayList, this.oxx.ouz);
    } while (this.oBv == null);
    this.oBv.removeMessages(131074);
    this.oBv.sendEmptyMessage(131074);
  }
  
  protected void Uf(String paramString) {}
  
  protected void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.plugin.emoji.f.n paramn)
  {
    if ((paramn != null) && (paramn.mType == bVM()))
    {
      this.knt = false;
      this.oAf.setVisibility(8);
      paramString = null;
      try
      {
        com.tencent.mm.plugin.emoji.model.f localf = com.tencent.mm.plugin.emoji.f.n.b(paramn.bVs());
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
        paramn = paramn.bVs();
        a(this.oAe, paramString, false, false);
        bVL();
        c(paramn);
        this.oAe = 2;
        return;
        if (paramInt2 != 3) {
          break label209;
        }
        a(this.oAe, paramString, false, false);
        this.oAe = 1;
        return;
        this.DR.setVisibility(0);
        this.oAd = true;
        if (bVM() != 7) {
          break label242;
        }
        this.oAc.setText(2131758380);
        return;
        this.oAc.setText(2131758330);
        return;
      }
      if (paramString != null) {
        if ((paramInt1 == 0) || (paramInt1 == 4))
        {
          paramInt1 = 1;
          if (paramInt1 == 0) {
            break label253;
          }
          this.DR.setVisibility(8);
          this.oAd = false;
          this.oAg = paramn.oyQ;
          if (paramInt2 != 0) {
            break label148;
          }
          paramn = paramn.bVs();
          a(paramString, false, true);
          c(paramn);
          this.oAe = 0;
        }
      }
      label148:
      label187:
      label209:
      label242:
      label253:
      while (this.oAx) {
        return;
      }
      this.DR.setVisibility(0);
      this.oAd = true;
      this.oAc.setText(2131758331);
      return;
    }
    paramInt2 = bVM();
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
    if (paramf.ouK == f.a.ouT)
    {
      paramf = paramf.ouM;
      if (paramf == null)
      {
        ad.i("MicroMsg.emoji.BaseEmojiStoreUI", "banner set is null. do nothing");
        return;
      }
      com.tencent.mm.plugin.emoji.e.k.a(getContext(), paramf, false);
      return;
    }
    EmotionSummary localEmotionSummary = paramf.ouL;
    if (localEmotionSummary == null)
    {
      ad.i("MicroMsg.emoji.BaseEmojiStoreUI", "summary is null. do nothing");
      return;
    }
    String str = getIntent().getStringExtra("to_talker_name");
    com.tencent.mm.plugin.emoji.e.k.a(getContext(), localEmotionSummary, bVD(), paramf.mStatus, paramf.EI, str, bVE());
  }
  
  public final void a(com.tencent.mm.plugin.emoji.a.a parama)
  {
    String str2 = parama.getProductId();
    String str1;
    if (TextUtils.isEmpty(parama.bUj()))
    {
      str1 = "";
      ad.i("MicroMsg.emoji.BaseEmojiStoreUI", "[onProductClick] productId:%s, productPrice:%s, productStatus:%d", new Object[] { str2, str1, Integer.valueOf(parama.bUi()) });
      if (parama.bUi() == 9)
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
      this.oAt.a(parama);
      return;
      str1 = parama.bUj();
      break;
      label97:
      getString(2131755906);
      this.ift = h.b(this, str1, true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(108786);
          BaseEmojiStoreUI.bVW();
          AppMethodBeat.o(108786);
        }
      });
    }
  }
  
  protected void a(com.tencent.mm.plugin.emoji.f.g paramg)
  {
    cL(paramg.oyw, 0);
  }
  
  protected void a(com.tencent.mm.plugin.emoji.model.f paramf, boolean paramBoolean1, boolean paramBoolean2)
  {
    ad.d("MicroMsg.emoji.BaseEmojiStoreUI", "jacks initData begin");
    if ((paramf != null) && (paramf.owZ.size() > 0))
    {
      this.oAx = true;
      this.DR.setVisibility(8);
      this.oAd = false;
    }
    a(this.oAe, paramf, paramBoolean1, paramBoolean2);
    bVL();
  }
  
  public void a(String paramString, m paramm)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals("delete_group")))
    {
      bWc();
      fe(131074, 50);
    }
  }
  
  protected void a(boolean paramBoolean1, com.tencent.mm.plugin.emoji.model.f paramf, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((this.oAs != null) && (paramBoolean1)) {
      if (bVJ())
      {
        if ((this.oAs != null) && (this.oAs.oxa != null) && (this.oAs.oxa.BannerSummary != null)) {
          break label75;
        }
        ad.d("MicroMsg.emoji.BaseEmojiStoreUI", "update store ui header failed. ");
      }
    }
    for (;;)
    {
      if (this.oxx != null) {
        this.oxx.b(this.oAs);
      }
      return;
      label75:
      this.oAy = ((LinkedList)this.oAs.oxb);
      this.oAz = ((LinkedList)this.oAs.oxc);
      if (this.oAy != null)
      {
        this.ozY.d(this.oAy, this.oAz);
      }
      else if (this.oAs.oxa != null)
      {
        this.oAy = new LinkedList();
        this.oAy.add(this.oAs.oxa);
        this.ozY.d(this.oAy, this.oAz);
      }
    }
  }
  
  protected final void aHU()
  {
    if (isFinishing())
    {
      ad.i("MicroMsg.emoji.BaseEmojiStoreUI", "[showLoadingDialog] acitivity is finished.");
      return;
    }
    getString(2131755906);
    this.ift = h.b(this, getString(2131755936), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(108785);
        BaseEmojiStoreUI.this.bVP();
        BaseEmojiStoreUI.bVW();
        AppMethodBeat.o(108785);
      }
    });
  }
  
  protected int aY(byte[] paramArrayOfByte)
  {
    return this.oAr;
  }
  
  public final boolean bPh()
  {
    I(true, false);
    ad.i("MicroMsg.emoji.BaseEmojiStoreUI", "[onBottomLoadData] startLoadRemoteEmoji.");
    return true;
  }
  
  public final boolean bPi()
  {
    return false;
  }
  
  public final boolean bPj()
  {
    return false;
  }
  
  public final void bUV()
  {
    this.oAg = null;
    this.oAe = -1;
    I(false, false);
  }
  
  protected void bVC()
  {
    this.oxx = bVF();
    this.oxx.ouA = this;
  }
  
  protected abstract int bVD();
  
  protected abstract int bVE();
  
  protected abstract com.tencent.mm.plugin.emoji.a.a.a bVF();
  
  protected void bVG() {}
  
  protected void bVH()
  {
    if (!bVI()) {}
    do
    {
      return;
      this.oAb = ((MMPullDownView)findViewById(2131301487));
    } while (this.oAb == null);
    this.oAb.setTopViewVisible(false);
    this.oAb.setAtTopCallBack(this);
    this.oAb.setOnBottomLoadDataListener(this);
    this.oAb.setAtBottomCallBack(this);
    this.oAb.setBottomViewVisible(false);
    this.oAb.setIsBottomShowAll(false);
  }
  
  protected boolean bVI()
  {
    return true;
  }
  
  protected boolean bVJ()
  {
    return true;
  }
  
  protected boolean bVK()
  {
    return false;
  }
  
  protected abstract int bVM();
  
  public int bVN()
  {
    return 0;
  }
  
  protected final void bVP()
  {
    com.tencent.mm.kernel.g.afA().gcy.a(this.oAq);
  }
  
  protected final void bVQ()
  {
    com.tencent.mm.kernel.g.afA().gcy.a(this.oAw, 0);
  }
  
  protected boolean bVR()
  {
    GetEmotionListResponse localGetEmotionListResponse = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().Fzb.WO(bVM());
    com.tencent.mm.plugin.emoji.model.f localf = com.tencent.mm.plugin.emoji.f.n.b(localGetEmotionListResponse);
    int j = bVM();
    if (localGetEmotionListResponse == null) {}
    for (int i = 0;; i = localGetEmotionListResponse.EmotionCount)
    {
      ad.d("MicroMsg.emoji.BaseEmojiStoreUI", "load cache type: %d, size: %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      if (localf != null) {
        break;
      }
      return false;
    }
    if (localf.owZ.size() <= 0) {}
    for (boolean bool = false; bool; bool = true)
    {
      ad.d("MicroMsg.emoji.BaseEmojiStoreUI", "jacks init EmoijStoreUI  by Cache: list:%d", new Object[] { Integer.valueOf(localf.owZ.size()) });
      a(localf, true, false);
      return bool;
    }
    ad.d("MicroMsg.emoji.BaseEmojiStoreUI", "jacks init EmoijStoreUI  by NET");
    return bool;
  }
  
  protected final void bVS()
  {
    if ((this.ift != null) && (this.ift.isShowing())) {
      this.ift.dismiss();
    }
  }
  
  protected boolean bVT()
  {
    return false;
  }
  
  protected boolean bVU()
  {
    return true;
  }
  
  public void bVV() {}
  
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
      ad.d("MicroMsg.emoji.BaseEmojiStoreUI", "jacks save EmoijStoreUI Cache: list:%d, size: %d, type: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(bVM()) });
      com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().Fzb.a(bVM(), paramGetEmotionListResponse);
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
  
  public void h(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    ad.d("MicroMsg.emoji.BaseEmojiStoreUI", "[onExchange] productId:[%s] status:[%d] progress:[%d] cdnClientId:[%s]", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString2 });
    if (this.oxx == null) {}
    com.tencent.mm.plugin.emoji.a.a.c localc;
    do
    {
      return;
      localc = this.oxx.ouz;
    } while (localc == null);
    if (paramInt1 == 6) {
      cL(paramString1, paramInt2);
    }
    for (;;)
    {
      paramString1 = localc.Tp(paramString1);
      if (paramString1 == null) {
        break;
      }
      paramString1.ouO = paramString2;
      return;
      ad.i("MicroMsg.emoji.BaseEmojiStoreUI", "product status:%d", new Object[] { Integer.valueOf(paramInt1) });
      cK(paramString1, paramInt1);
    }
  }
  
  public void initView()
  {
    setBackBtn(new b((byte)0));
    bVC();
    this.DR = findViewById(2131299457);
    this.oAc = ((TextView)this.DR.findViewById(2131299461));
    this.oAf = getLayoutInflater().inflate(2131493799, null);
    this.oAf.setVisibility(8);
    if (bVJ()) {
      this.ozY = new EmojiStoreVpHeader(getContext());
    }
    if (bVK())
    {
      this.ozZ = LayoutInflater.from(this).inflate(2131493832, null);
      int i = EmojiStoreVpHeader.et(getContext())[0];
      AbsListView.LayoutParams localLayoutParams = new AbsListView.LayoutParams(i, i * 3 / 8 + 1);
      this.ozZ.setLayoutParams(localLayoutParams);
      this.oAa = ((StoreBannerEmojiView)this.ozZ.findViewById(2131299332));
    }
    this.mListView = ((ListView)findViewById(16908298));
    this.mListView.setOnItemClickListener(this);
    if (bVJ()) {
      this.mListView.addHeaderView(this.ozY);
    }
    for (;;)
    {
      if (bVU()) {
        this.mListView.addFooterView(this.oAf);
      }
      bVG();
      this.mListView.setAdapter(this.oxx);
      this.mListView.setOnScrollListener(this);
      this.oxx.ouy = this.mListView;
      bVH();
      return;
      if (bVK()) {
        this.mListView.addHeaderView(this.ozZ);
      }
    }
  }
  
  public final void j(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    k(paramString1, paramString2, paramString3, paramString4);
    bVQ();
  }
  
  protected final com.tencent.mm.plugin.emoji.f.g k(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.oAw = new com.tencent.mm.plugin.emoji.f.g(paramString1, paramString2, paramString3, paramString4);
    return this.oAw;
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
      bVS();
      return;
      paramMessage = (String)paramMessage.obj;
      if (isFinishing())
      {
        ad.i("MicroMsg.emoji.BaseEmojiStoreUI", "[updateLoadingDialog] acitivity is finished.");
        return;
      }
    } while (this.ift == null);
    this.ift.setMessage(paramMessage);
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
            } while (this.oxx == null);
            this.oxx.notifyDataSetChanged();
            bVV();
            return;
          } while ((this.oxx == null) || (paramMessage.getData() == null));
          str = paramMessage.getData().getString("product_id");
        } while (str == null);
        i = paramMessage.getData().getInt("progress");
        this.oxx.cL(str, i);
        return;
      } while ((this.oxx == null) || (paramMessage.getData() == null));
      str = paramMessage.getData().getString("product_id");
    } while (str == null);
    int i = paramMessage.getData().getInt("status");
    this.oxx.cK(str, i);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    ad.d("MicroMsg.emoji.BaseEmojiStoreUI", "onActivityResult . requestCode:" + paramInt1 + "  resultCode:" + paramInt2);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.oAt.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.oAt = new j();
    initView();
    this.oAr = getIntent().getIntExtra("preceding_scence", 2);
    if (com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().FyZ != null) {
      com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().FyZ.add(this);
    }
    this.oAv = new a((byte)0);
    com.tencent.mm.sdk.b.a.ESL.c(this.oAv);
    this.oAt.mfC = this;
    this.oAt.oxx = this.oxx;
    this.oAt.oxA = bVD();
    this.oAt.oxD = this;
    boolean bool2 = bVT();
    boolean bool1 = bool2;
    if (bool2) {
      bool1 = bVR();
    }
    I(false, bool1);
    if (oAu == null) {
      oAu = new HashMap();
    }
    long l = System.currentTimeMillis();
    ad.d("MicroMsg.emoji.BaseEmojiStoreUI", "refresh last net refresh time: %d", new Object[] { Long.valueOf(l) });
    oAu.put(getClass().toString(), Long.valueOf(l));
    this.oxF = new com.tencent.mm.plugin.emoji.h.c(1005);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.oxx != null)
    {
      this.oxx.clear();
      this.oxx = null;
    }
    if ((bVJ()) && (this.ozY != null)) {
      this.ozY.clear();
    }
    com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().FyZ.remove(this);
    com.tencent.mm.sdk.b.a.ESL.d(this.oAv);
    com.tencent.mm.kernel.g.afA().gcy.a(this.oAw);
    if (this.oAt != null)
    {
      j localj = this.oAt;
      localj.oxx = null;
      localj.oxD = null;
      localj.mfC = null;
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i;
    if (!bVJ())
    {
      i = paramInt;
      if (!bVK()) {}
    }
    else if (paramInt != 0) {}
    while ((i < 0) || (i >= this.oxx.getCount()))
    {
      return;
      i = paramInt - 1;
    }
    a(this.oxx.As(i), i);
  }
  
  public void onPause()
  {
    super.onPause();
    com.tencent.mm.kernel.g.afA().gcy.b(411, this);
    com.tencent.mm.kernel.g.afA().gcy.b(423, this);
    com.tencent.mm.kernel.g.afA().gcy.b(413, this);
    com.tencent.mm.kernel.g.afA().gcy.b(717, this);
    bVP();
    if ((bVJ()) && (this.ozY != null)) {
      this.ozY.bWH();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    com.tencent.mm.kernel.g.afA().gcy.a(411, this);
    com.tencent.mm.kernel.g.afA().gcy.a(423, this);
    com.tencent.mm.kernel.g.afA().gcy.a(413, this);
    com.tencent.mm.kernel.g.afA().gcy.a(717, this);
    if ((bVJ()) && (this.ozY != null)) {
      this.ozY.bWG();
    }
    Boolean localBoolean = Boolean.FALSE;
    this.oAt.oxy = false;
    if ((this.oxx != null) && (this.oxx.ouz != null))
    {
      this.oxx.ouz.bUx();
      this.oxx.refreshView();
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, final com.tencent.mm.al.n paramn)
  {
    final String str1;
    if (TextUtils.isEmpty(paramString))
    {
      str1 = "";
      ad.i("MicroMsg.emoji.BaseEmojiStoreUI", "jacks [onSceneEnd] errType:%d,errCode:%d,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str1 });
      bVS();
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
      paramn = paramString.oyw;
      str1 = paramString.oyy;
      final String str2 = paramString.oyx;
      h.a(this, getString(2131758320, new Object[] { str2 }), "", new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(108784);
          BaseEmojiStoreUI.this.k(paramn, str1, str2, null);
          BaseEmojiStoreUI.this.bVQ();
          ad.i("MicroMsg.emoji.BaseEmojiStoreUI", "Retry doScene ExchangeEmotionPackNetScene productId:%s", new Object[] { paramn });
          BaseEmojiStoreUI.a(BaseEmojiStoreUI.this, paramn);
          AppMethodBeat.o(108784);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      cK(paramString.oyw, -1);
      return;
      paramString = (com.tencent.mm.plugin.emoji.f.q)paramn;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().FyZ.aJq(paramString.oyw);
        paramString = new Message();
        paramString.what = 2002;
        paramString.obj = getContext().getString(2131755910);
        n(paramString);
      }
      for (;;)
      {
        fe(20001, 800);
        return;
        paramString = new Message();
        paramString.what = 2002;
        paramString.obj = getContext().getString(2131758251);
        n(paramString);
      }
    } while ((paramInt1 != 0) || (paramInt2 != 0));
    this.oAg = null;
    I(false, true);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1))
    {
      if ((this.oAe == 0) || (this.knt)) {
        ad.d("MicroMsg.emoji.BaseEmojiStoreUI", "No More List.");
      }
    }
    else {
      return;
    }
    I(true, false);
    ad.i("MicroMsg.emoji.BaseEmojiStoreUI", "[onScrollStateChanged] startLoadRemoteEmoji.");
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends com.tencent.mm.sdk.b.c<dh>
  {
    private a()
    {
      AppMethodBeat.i(161086);
      this.__eventId = dh.class.getName().hashCode();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI
 * JD-Core Version:    0.7.0.1
 */