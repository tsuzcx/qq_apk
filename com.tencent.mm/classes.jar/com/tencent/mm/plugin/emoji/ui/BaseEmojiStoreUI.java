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
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.dp;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.plugin.emoji.a.a.f.a;
import com.tencent.mm.plugin.emoji.f.o;
import com.tencent.mm.plugin.emoji.f.r;
import com.tencent.mm.plugin.emoji.model.j;
import com.tencent.mm.plugin.emoji.model.j.a;
import com.tencent.mm.plugin.emoji.model.j.b;
import com.tencent.mm.pluginsdk.model.k.a;
import com.tencent.mm.pluginsdk.ui.emoji.StoreBannerEmojiView;
import com.tencent.mm.protocal.protobuf.EmotionBanner;
import com.tencent.mm.protocal.protobuf.EmotionBannerSet;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.protocal.protobuf.GetEmotionListResponse;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.s;
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
  implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener, i, j.a, j.b, k.a, MStorage.IOnStorageChange, MMPullDownView.c, MMPullDownView.d, MMPullDownView.e
{
  private static Map<String, Long> rex;
  protected View GQ;
  private ProgressDialog jZH;
  public ListView mListView;
  private boolean mwr;
  public com.tencent.mm.plugin.emoji.a.a.a rbD;
  private com.tencent.mm.plugin.emoji.h.c rbL;
  protected EmojiStoreVpHeader rdY;
  protected View rdZ;
  protected boolean reA = false;
  private LinkedList<EmotionBanner> reB = new LinkedList();
  private LinkedList<EmotionBannerSet> reC = new LinkedList();
  protected StoreBannerEmojiView rea;
  protected MMPullDownView reb;
  protected TextView rec;
  protected boolean red = false;
  int ree = -1;
  private View reg;
  protected byte[] reh;
  private final int rei = 65537;
  private final int rej = 20001;
  private final int rek = 2002;
  protected final int rel = 131074;
  private final int rem = 131075;
  private final int ren = 131076;
  private final String reo = "product_id";
  private final String rep = "progress";
  private final String rer = "status";
  private o res;
  private int reu;
  private com.tencent.mm.plugin.emoji.model.g rev;
  protected j rew;
  private IListener rey;
  protected com.tencent.mm.plugin.emoji.f.h rez;
  
  private void a(int paramInt, com.tencent.mm.plugin.emoji.model.g paramg, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = false;
    Log.d("MicroMsg.emoji.BaseEmojiStoreUI", "");
    boolean bool1 = bool2;
    switch (paramInt)
    {
    default: 
      bool1 = bool2;
    case 0: 
      if (this.rev != null) {
        this.rev.cFZ();
      }
      a(bool1, this.rev, paramBoolean1, paramBoolean2);
      return;
    case -1: 
      this.rev = paramg;
    }
    for (;;)
    {
      bool1 = true;
      break;
      this.rev = paramg;
      continue;
      if (this.rev == null) {
        this.rev = new com.tencent.mm.plugin.emoji.model.g();
      }
      if (paramg != null)
      {
        this.rev.FX(paramg.rbs);
        this.rev.dg(paramg.rbt);
      }
    }
  }
  
  private void b(GetEmotionListResponse paramGetEmotionListResponse)
  {
    if (this.ree == -1)
    {
      Message localMessage = Message.obtain();
      localMessage.what = 65537;
      localMessage.obj = paramGetEmotionListResponse;
      m(localMessage);
    }
  }
  
  private o bo(byte[] paramArrayOfByte)
  {
    int i = cGQ();
    int j = bp(paramArrayOfByte);
    int k = cGR();
    o localo;
    if (paramArrayOfByte != null)
    {
      Log.i("MicroMsg.emoji.BaseEmojiStoreUI", "[startLoadRemoteEmoji] request buffer %s", new Object[] { paramArrayOfByte.toString() });
      localo = new o(i, paramArrayOfByte, j);
      paramArrayOfByte = localo;
      if (i == 7)
      {
        localo.rda = k;
        paramArrayOfByte = localo;
      }
    }
    for (;;)
    {
      this.res = paramArrayOfByte;
      return paramArrayOfByte;
      Log.i("MicroMsg.emoji.BaseEmojiStoreUI", "[startLoadRemoteEmoji] request buffer is null.");
      localo = new o(i, j);
      paramArrayOfByte = localo;
      if (i == 7)
      {
        localo.rda = k;
        paramArrayOfByte = localo;
      }
    }
  }
  
  private void cGP()
  {
    com.tencent.mm.plugin.emoji.a.a.b.a(this.rbD.qXZ, this);
  }
  
  private void cGS()
  {
    com.tencent.mm.kernel.g.aAg().hqi.a(this.res, 0);
  }
  
  private void dc(String paramString, int paramInt)
  {
    Message localMessage = Message.obtain();
    localMessage.getData().putString("product_id", paramString);
    localMessage.getData().putInt("status", paramInt);
    localMessage.what = 131076;
    l(localMessage);
  }
  
  private void dd(String paramString, int paramInt)
  {
    Message localMessage = Message.obtain();
    localMessage.getData().putString("product_id", paramString);
    localMessage.getData().putInt("progress", paramInt);
    localMessage.what = 131075;
    l(localMessage);
  }
  
  protected final void J(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mwr = true;
    if (paramBoolean1) {
      this.reg.setVisibility(0);
    }
    bo(this.reh);
    cGS();
    Log.i("MicroMsg.emoji.BaseEmojiStoreUI", "[startLoadRemoteEmoji] doScene GetEmotionListNetScene");
    if ((!paramBoolean1) && (!paramBoolean2)) {
      bnj();
    }
  }
  
  public final void Y(ArrayList<com.tencent.mm.pluginsdk.model.q> paramArrayList)
  {
    Log.d("MicroMsg.emoji.BaseEmojiStoreUI", "google [onQueryFinish]");
    if (this.rbD == null) {}
    do
    {
      return;
      com.tencent.mm.plugin.emoji.a.a.b.a(paramArrayList, this.rbD.qXZ);
    } while (this.rfA == null);
    this.rfA.removeMessages(131074);
    this.rfA.sendEmptyMessage(131074);
  }
  
  protected void a(int paramInt1, int paramInt2, String paramString, o paramo)
  {
    if ((paramo != null) && (paramo.mType == cGQ()))
    {
      this.mwr = false;
      this.reg.setVisibility(8);
      paramString = null;
      try
      {
        com.tencent.mm.plugin.emoji.model.g localg = o.a(paramo.cGx());
        paramString = localg;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printInfoStack("MicroMsg.emoji.BaseEmojiStoreUI", "deal NetGetEmotionList error:%s", new Object[] { localException.toString() });
          continue;
          paramInt1 = 0;
        }
        if (paramInt2 != 2) {
          break label187;
        }
        paramo = paramo.cGx();
        a(this.ree, paramString, false, false);
        cGP();
        b(paramo);
        this.ree = 2;
        return;
        if (paramInt2 != 3) {
          break label209;
        }
        a(this.ree, paramString, false, false);
        this.ree = 1;
        return;
        this.GQ.setVisibility(0);
        this.red = true;
        if (cGQ() != 7) {
          break label242;
        }
        this.rec.setText(2131758674);
        return;
        this.rec.setText(2131758624);
        return;
      }
      if (paramString != null) {
        if ((paramInt1 == 0) || (paramInt1 == 4))
        {
          paramInt1 = 1;
          if (paramInt1 == 0) {
            break label253;
          }
          this.GQ.setVisibility(8);
          this.red = false;
          this.reh = paramo.rcY;
          if (paramInt2 != 0) {
            break label148;
          }
          paramo = paramo.cGx();
          a(paramString, false, true);
          b(paramo);
          this.ree = 0;
        }
      }
      label148:
      label187:
      label209:
      label242:
      label253:
      while (this.reA) {
        return;
      }
      this.GQ.setVisibility(0);
      this.red = true;
      this.rec.setText(2131758625);
      return;
    }
    paramInt2 = cGQ();
    if (paramo == null) {}
    for (paramInt1 = -1;; paramInt1 = paramo.mType)
    {
      Log.i("MicroMsg.emoji.BaseEmojiStoreUI", "no some scene type. this ui type:%d callbak type:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
      return;
    }
  }
  
  protected void a(f paramf, int paramInt)
  {
    if (paramf == null)
    {
      Log.i("MicroMsg.emoji.BaseEmojiStoreUI", "item is null.");
      return;
    }
    if (paramf.qYk == f.a.qYt)
    {
      paramf = paramf.qYm;
      if (paramf == null)
      {
        Log.i("MicroMsg.emoji.BaseEmojiStoreUI", "banner set is null. do nothing");
        return;
      }
      com.tencent.mm.plugin.emoji.e.k.a(getContext(), paramf, false);
      return;
    }
    EmotionSummary localEmotionSummary = paramf.qYl;
    if (localEmotionSummary == null)
    {
      Log.i("MicroMsg.emoji.BaseEmojiStoreUI", "summary is null. do nothing");
      return;
    }
    String str = getIntent().getStringExtra("to_talker_name");
    com.tencent.mm.plugin.emoji.e.k.a(getContext(), localEmotionSummary, cGH(), paramf.mStatus, paramf.HH, str, cGI());
  }
  
  public final void a(com.tencent.mm.plugin.emoji.a.a parama)
  {
    String str2 = parama.getProductId();
    String str1;
    if (TextUtils.isEmpty(parama.cFd()))
    {
      str1 = "";
      Log.i("MicroMsg.emoji.BaseEmojiStoreUI", "[onProductClick] productId:%s, productPrice:%s, productStatus:%d", new Object[] { str2, str1, Integer.valueOf(parama.cFc()) });
      if (parama.cFc() == 9)
      {
        str1 = getString(2131756005);
        if (!isFinishing()) {
          break label97;
        }
        Log.i("MicroMsg.emoji.BaseEmojiStoreUI", "[showLoadingDialog] acitivity is finished.");
      }
    }
    for (;;)
    {
      this.rew.a(parama);
      return;
      str1 = parama.cFd();
      break;
      label97:
      getString(2131755998);
      this.jZH = com.tencent.mm.ui.base.h.a(this, str1, true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(108786);
          BaseEmojiStoreUI.cHa();
          AppMethodBeat.o(108786);
        }
      });
    }
  }
  
  protected void a(com.tencent.mm.plugin.emoji.f.h paramh)
  {
    dd(paramh.rcD, 0);
  }
  
  protected void a(com.tencent.mm.plugin.emoji.model.g paramg, boolean paramBoolean1, boolean paramBoolean2)
  {
    Log.d("MicroMsg.emoji.BaseEmojiStoreUI", "jacks initData begin");
    if ((paramg != null) && (paramg.rbt.size() > 0))
    {
      this.reA = true;
      this.GQ.setVisibility(8);
      this.red = false;
    }
    a(this.ree, paramg, paramBoolean1, paramBoolean2);
    cGP();
  }
  
  protected void a(boolean paramBoolean1, com.tencent.mm.plugin.emoji.model.g paramg, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((this.rev != null) && (paramBoolean1)) {
      if (cGN())
      {
        if ((this.rev != null) && (this.rev.rbu != null) && (this.rev.rbu.BannerSummary != null)) {
          break label75;
        }
        Log.d("MicroMsg.emoji.BaseEmojiStoreUI", "update store ui header failed. ");
      }
    }
    for (;;)
    {
      if (this.rbD != null) {
        this.rbD.b(this.rev);
      }
      return;
      label75:
      this.reB = ((LinkedList)this.rev.rbv);
      this.reC = ((LinkedList)this.rev.rbw);
      if (this.reB != null)
      {
        this.rdY.d(this.reB, this.reC);
      }
      else if (this.rev.rbu != null)
      {
        this.reB = new LinkedList();
        this.reB.add(this.rev.rbu);
        this.rdY.d(this.reB, this.reC);
      }
    }
  }
  
  protected void amV(String paramString) {}
  
  protected final void bnj()
  {
    if (isFinishing())
    {
      Log.i("MicroMsg.emoji.BaseEmojiStoreUI", "[showLoadingDialog] acitivity is finished.");
      return;
    }
    getString(2131755998);
    this.jZH = com.tencent.mm.ui.base.h.a(this, getString(2131756029), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(108785);
        BaseEmojiStoreUI.this.cGT();
        BaseEmojiStoreUI.cHa();
        AppMethodBeat.o(108785);
      }
    });
  }
  
  protected int bp(byte[] paramArrayOfByte)
  {
    return this.reu;
  }
  
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
      Log.d("MicroMsg.emoji.BaseEmojiStoreUI", "jacks save EmoijStoreUI Cache: list:%d, size: %d, type: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(cGQ()) });
      com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpQ.a(cGQ(), paramGetEmotionListResponse);
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
  
  public final boolean cAj()
  {
    J(true, false);
    Log.i("MicroMsg.emoji.BaseEmojiStoreUI", "[onBottomLoadData] startLoadRemoteEmoji.");
    return true;
  }
  
  public final boolean cAk()
  {
    return false;
  }
  
  public final boolean cAl()
  {
    return false;
  }
  
  protected void cGG()
  {
    this.rbD = cGJ();
    this.rbD.qYa = this;
  }
  
  protected abstract int cGH();
  
  protected abstract int cGI();
  
  protected abstract com.tencent.mm.plugin.emoji.a.a.a cGJ();
  
  protected void cGK() {}
  
  protected void cGL()
  {
    if (!cGM()) {}
    do
    {
      return;
      this.reb = ((MMPullDownView)findViewById(2131303686));
    } while (this.reb == null);
    this.reb.setTopViewVisible(false);
    this.reb.setAtTopCallBack(this);
    this.reb.setOnBottomLoadDataListener(this);
    this.reb.setAtBottomCallBack(this);
    this.reb.setBottomViewVisible(false);
    this.reb.setIsBottomShowAll(false);
  }
  
  protected boolean cGM()
  {
    return true;
  }
  
  protected boolean cGN()
  {
    return true;
  }
  
  protected boolean cGO()
  {
    return false;
  }
  
  protected abstract int cGQ();
  
  public int cGR()
  {
    return 0;
  }
  
  protected final void cGT()
  {
    com.tencent.mm.kernel.g.aAg().hqi.a(this.res);
  }
  
  protected final void cGU()
  {
    com.tencent.mm.kernel.g.aAg().hqi.a(this.rez, 0);
  }
  
  protected boolean cGV()
  {
    GetEmotionListResponse localGetEmotionListResponse = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpQ.akx(cGQ());
    com.tencent.mm.plugin.emoji.model.g localg = o.a(localGetEmotionListResponse);
    int j = cGQ();
    if (localGetEmotionListResponse == null) {}
    for (int i = 0;; i = localGetEmotionListResponse.EmotionCount)
    {
      Log.d("MicroMsg.emoji.BaseEmojiStoreUI", "load cache type: %d, size: %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      if (localg != null) {
        break;
      }
      return false;
    }
    if (localg.rbt.size() <= 0) {}
    for (boolean bool = false; bool; bool = true)
    {
      Log.d("MicroMsg.emoji.BaseEmojiStoreUI", "jacks init EmoijStoreUI  by Cache: list:%d", new Object[] { Integer.valueOf(localg.rbt.size()) });
      a(localg, true, false);
      return bool;
    }
    Log.d("MicroMsg.emoji.BaseEmojiStoreUI", "jacks init EmoijStoreUI  by NET");
    return bool;
  }
  
  protected final void cGW()
  {
    if ((this.jZH != null) && (this.jZH.isShowing())) {
      this.jZH.dismiss();
    }
  }
  
  protected boolean cGX()
  {
    return false;
  }
  
  protected boolean cGY()
  {
    return true;
  }
  
  public void cGZ() {}
  
  public final void cGa()
  {
    this.reh = null;
    this.ree = -1;
    J(false, false);
  }
  
  public final void d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    e(paramString1, paramString2, paramString3, paramString4, paramString5);
    cGU();
  }
  
  protected final com.tencent.mm.plugin.emoji.f.h e(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.rez = new com.tencent.mm.plugin.emoji.f.h(paramString1, paramString2, paramString3, paramString4, paramString5);
    return this.rez;
  }
  
  public int getLayoutId()
  {
    return 2131493954;
  }
  
  public void i(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    Log.d("MicroMsg.emoji.BaseEmojiStoreUI", "[onExchange] productId:[%s] status:[%d] progress:[%d] cdnClientId:[%s]", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString2 });
    if (this.rbD == null) {}
    com.tencent.mm.plugin.emoji.a.a.c localc;
    do
    {
      return;
      localc = this.rbD.qXZ;
    } while (localc == null);
    if (paramInt1 == 6) {
      dd(paramString1, paramInt2);
    }
    for (;;)
    {
      paramString1 = localc.amb(paramString1);
      if (paramString1 == null) {
        break;
      }
      paramString1.qYo = paramString2;
      return;
      Log.i("MicroMsg.emoji.BaseEmojiStoreUI", "product status:%d", new Object[] { Integer.valueOf(paramInt1) });
      dc(paramString1, paramInt1);
    }
  }
  
  public void initView()
  {
    setBackBtn(new b((byte)0));
    cGG();
    this.GQ = findViewById(2131300076);
    this.rec = ((TextView)this.GQ.findViewById(2131300085));
    this.reg = getLayoutInflater().inflate(2131493953, null);
    this.reg.setVisibility(8);
    if (cGN()) {
      this.rdY = new EmojiStoreVpHeader(getContext());
    }
    if (cGO())
    {
      this.rdZ = LayoutInflater.from(this).inflate(2131493986, null);
      int i = EmojiStoreVpHeader.getScreenWH(getContext())[0];
      AbsListView.LayoutParams localLayoutParams = new AbsListView.LayoutParams(i, i * 3 / 8 + 1);
      this.rdZ.setLayoutParams(localLayoutParams);
      this.rea = ((StoreBannerEmojiView)this.rdZ.findViewById(2131299944));
    }
    this.mListView = ((ListView)findViewById(16908298));
    this.mListView.setOnItemClickListener(this);
    if (cGN()) {
      this.mListView.addHeaderView(this.rdY);
    }
    for (;;)
    {
      if (cGY()) {
        this.mListView.addFooterView(this.reg);
      }
      cGK();
      this.mListView.setAdapter(this.rbD);
      this.mListView.setOnScrollListener(this);
      this.rbD.qXY = this.mListView;
      cGL();
      return;
      if (cGO()) {
        this.mListView.addHeaderView(this.rdZ);
      }
    }
  }
  
  public final void j(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      c((GetEmotionListResponse)paramMessage.obj);
      return;
      cGW();
      return;
      paramMessage = (String)paramMessage.obj;
      if (isFinishing())
      {
        Log.i("MicroMsg.emoji.BaseEmojiStoreUI", "[updateLoadingDialog] acitivity is finished.");
        return;
      }
    } while (this.jZH == null);
    this.jZH.setMessage(paramMessage);
  }
  
  public void k(Message paramMessage)
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
            } while (this.rbD == null);
            this.rbD.notifyDataSetChanged();
            cGZ();
            return;
          } while ((this.rbD == null) || (paramMessage.getData() == null));
          str = paramMessage.getData().getString("product_id");
        } while (str == null);
        i = paramMessage.getData().getInt("progress");
        this.rbD.dd(str, i);
        return;
      } while ((this.rbD == null) || (paramMessage.getData() == null));
      str = paramMessage.getData().getString("product_id");
    } while (str == null);
    int i = paramMessage.getData().getInt("status");
    this.rbD.dc(str, i);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Log.d("MicroMsg.emoji.BaseEmojiStoreUI", "onActivityResult . requestCode:" + paramInt1 + "  resultCode:" + paramInt2);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.rew.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.rew = new j();
    initView();
    this.reu = getIntent().getIntExtra("preceding_scence", 2);
    if (com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpO != null) {
      com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpO.add(this);
    }
    this.rey = new a((byte)0);
    EventCenter.instance.addListener(this.rey);
    this.rew.owO = this;
    this.rew.rbD = this.rbD;
    this.rew.rbG = cGH();
    this.rew.rbJ = this;
    boolean bool2 = cGX();
    boolean bool1 = bool2;
    if (bool2) {
      bool1 = cGV();
    }
    J(false, bool1);
    if (rex == null) {
      rex = new HashMap();
    }
    long l = System.currentTimeMillis();
    Log.d("MicroMsg.emoji.BaseEmojiStoreUI", "refresh last net refresh time: %d", new Object[] { Long.valueOf(l) });
    rex.put(getClass().toString(), Long.valueOf(l));
    this.rbL = new com.tencent.mm.plugin.emoji.h.c(1005);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.rbD != null)
    {
      this.rbD.clear();
      this.rbD = null;
    }
    if ((cGN()) && (this.rdY != null)) {
      this.rdY.clear();
    }
    com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpO.remove(this);
    EventCenter.instance.removeListener(this.rey);
    com.tencent.mm.kernel.g.aAg().hqi.a(this.rez);
    if (this.rew != null)
    {
      j localj = this.rew;
      localj.rbD = null;
      localj.rbJ = null;
      localj.owO = null;
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramAdapterView);
    localb.bm(paramView);
    localb.pH(paramInt);
    localb.zo(paramLong);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/BaseEmojiStoreUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
    int i;
    if (!cGN())
    {
      i = paramInt;
      if (!cGO()) {}
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
    if ((i < 0) || (i >= this.rbD.getCount()))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/BaseEmojiStoreUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      return;
    }
    a(this.rbD.FN(i), i);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/BaseEmojiStoreUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
  }
  
  public void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals("delete_group")))
    {
      cHg();
      fC(131074, 50);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    com.tencent.mm.kernel.g.aAg().hqi.b(411, this);
    com.tencent.mm.kernel.g.aAg().hqi.b(423, this);
    com.tencent.mm.kernel.g.aAg().hqi.b(413, this);
    com.tencent.mm.kernel.g.aAg().hqi.b(717, this);
    cGT();
    if ((cGN()) && (this.rdY != null)) {
      this.rdY.cHO();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    com.tencent.mm.kernel.g.aAg().hqi.a(411, this);
    com.tencent.mm.kernel.g.aAg().hqi.a(423, this);
    com.tencent.mm.kernel.g.aAg().hqi.a(413, this);
    com.tencent.mm.kernel.g.aAg().hqi.a(717, this);
    if ((cGN()) && (this.rdY != null)) {
      this.rdY.cHN();
    }
    Boolean localBoolean = Boolean.FALSE;
    this.rew.rbE = false;
    if ((this.rbD != null) && (this.rbD.qXZ != null))
    {
      this.rbD.qXZ.cFq();
      this.rbD.refreshView();
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, final com.tencent.mm.ak.q paramq)
  {
    final String str1;
    if (TextUtils.isEmpty(paramString))
    {
      str1 = "";
      Log.i("MicroMsg.emoji.BaseEmojiStoreUI", "jacks [onSceneEnd] errType:%d,errCode:%d,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str1 });
      cGW();
      switch (paramq.getType())
      {
      default: 
        Log.e("MicroMsg.emoji.BaseEmojiStoreUI", "unknow scene type");
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
        } while (!(paramq instanceof o));
        a(paramInt1, paramInt2, paramString, (o)paramq);
        return;
      } while (!(paramq instanceof com.tencent.mm.plugin.emoji.f.h));
      paramString = (com.tencent.mm.plugin.emoji.f.h)paramq;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        a(paramString);
        return;
      }
      paramq = paramString.rcD;
      str1 = paramString.rcF;
      final String str2 = paramString.rcE;
      final String str3 = paramString.rcH;
      com.tencent.mm.ui.base.h.a(this, getString(2131758614, new Object[] { str2 }), "", new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(108784);
          BaseEmojiStoreUI.this.e(paramq, str1, str2, null, str3);
          BaseEmojiStoreUI.this.cGU();
          Log.i("MicroMsg.emoji.BaseEmojiStoreUI", "Retry doScene ExchangeEmotionPackNetScene productId:%s", new Object[] { paramq });
          BaseEmojiStoreUI.a(BaseEmojiStoreUI.this, paramq);
          AppMethodBeat.o(108784);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      dc(paramString.rcD, -1);
      return;
      paramString = (r)paramq;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpO.blc(paramString.rcD);
        paramString = new Message();
        paramString.what = 2002;
        paramString.obj = getContext().getString(2131756002);
        l(paramString);
      }
      for (;;)
      {
        fC(20001, 800);
        return;
        paramString = new Message();
        paramString.what = 2002;
        paramString.obj = getContext().getString(2131758539);
        l(paramString);
      }
    } while ((paramInt1 != 0) || (paramInt2 != 0));
    this.reh = null;
    J(false, true);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1))
    {
      if ((this.ree == 0) || (this.mwr)) {
        Log.d("MicroMsg.emoji.BaseEmojiStoreUI", "No More List.");
      }
    }
    else {
      return;
    }
    J(true, false);
    Log.i("MicroMsg.emoji.BaseEmojiStoreUI", "[onScrollStateChanged] startLoadRemoteEmoji.");
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends IListener<dp>
  {
    private a()
    {
      AppMethodBeat.i(161086);
      this.__eventId = dp.class.getName().hashCode();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI
 * JD-Core Version:    0.7.0.1
 */