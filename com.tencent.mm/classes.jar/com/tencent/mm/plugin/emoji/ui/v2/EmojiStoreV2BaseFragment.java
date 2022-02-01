package com.tencent.mm.plugin.emoji.ui.v2;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.dp;
import com.tencent.mm.g.b.a.as;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.plugin.emoji.a.a.f.a;
import com.tencent.mm.plugin.emoji.a.h.a;
import com.tencent.mm.plugin.emoji.f.o;
import com.tencent.mm.plugin.emoji.model.j;
import com.tencent.mm.plugin.emoji.model.j.a;
import com.tencent.mm.plugin.emoji.model.j.b;
import com.tencent.mm.plugin.emoji.ui.EmojiStoreVpHeader;
import com.tencent.mm.pluginsdk.model.k.a;
import com.tencent.mm.protocal.protobuf.EmotionBanner;
import com.tencent.mm.protocal.protobuf.EmotionBannerSet;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.protocal.protobuf.GetEmotionListResponse;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.deu;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.s;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.c;
import com.tencent.mm.ui.base.MMPullDownView.d;
import com.tencent.mm.ui.base.MMPullDownView.e;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public abstract class EmojiStoreV2BaseFragment
  extends MMFragment
  implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener, i, h.a, j.a, j.b, k.a, MStorage.IOnStorageChange, MMPullDownView.c, MMPullDownView.d, MMPullDownView.e
{
  private View GQ;
  private MMHandler czp = new MMHandler()
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      AppMethodBeat.i(109135);
      EmojiStoreV2BaseFragment localEmojiStoreV2BaseFragment = EmojiStoreV2BaseFragment.this;
      switch (paramAnonymousMessage.what)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(109135);
        return;
        if (localEmojiStoreV2BaseFragment.rbD != null)
        {
          localEmojiStoreV2BaseFragment.rbD.notifyDataSetChanged();
          AppMethodBeat.o(109135);
          return;
          if ((localEmojiStoreV2BaseFragment.rbD == null) || (paramAnonymousMessage.getData() == null))
          {
            AppMethodBeat.o(109135);
            return;
          }
          String str = paramAnonymousMessage.getData().getString("product_id");
          if (str != null)
          {
            int i = paramAnonymousMessage.getData().getInt("progress");
            localEmojiStoreV2BaseFragment.rbD.dd(str, i);
            AppMethodBeat.o(109135);
            return;
            if ((localEmojiStoreV2BaseFragment.rbD == null) || (paramAnonymousMessage.getData() == null))
            {
              AppMethodBeat.o(109135);
              return;
            }
            str = paramAnonymousMessage.getData().getString("product_id");
            if (str != null)
            {
              i = paramAnonymousMessage.getData().getInt("status");
              localEmojiStoreV2BaseFragment.rbD.dc(str, i);
              AppMethodBeat.o(109135);
              return;
              if (localEmojiStoreV2BaseFragment.rdY != null) {
                localEmojiStoreV2BaseFragment.rdY.cHN();
              }
            }
          }
        }
      }
    }
  };
  protected long iOB;
  private ProgressDialog jZH;
  private ActionBar mActionBar;
  private com.tencent.mm.ui.a mActionBarHelper;
  protected ListView mListView;
  private boolean mwr;
  com.tencent.mm.plugin.emoji.a.a.a rbD;
  protected as rbN = new as();
  EmojiStoreVpHeader rdY;
  private boolean reA = false;
  private LinkedList<EmotionBanner> reB = new LinkedList();
  private LinkedList<EmotionBannerSet> reC = new LinkedList();
  private MMPullDownView reb;
  private TextView rec;
  private int ree = -1;
  private View reg;
  private byte[] reh;
  private final int rel = 131074;
  private final int rem = 131075;
  private final int ren = 131076;
  private final String reo = "product_id";
  private final String rep = "progress";
  private final String rer = "status";
  private o res;
  private int reu;
  private com.tencent.mm.plugin.emoji.model.g rev;
  private j rew;
  private IListener rey = new IListener() {};
  private com.tencent.mm.plugin.emoji.f.h rez;
  private final int rjL = 131077;
  public EmojiStoreV2HotBarView rjM;
  private boolean rjN = false;
  private boolean rjO = false;
  private boolean rjP = false;
  private MenuItem.OnMenuItemClickListener rjQ = new EmojiStoreV2BaseFragment.4(this);
  
  private void K(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.rev != null) && (paramBoolean1))
    {
      if (paramBoolean2) {
        cHY();
      }
      if (this.rbD != null) {
        this.rbD.b(this.rev);
      }
    }
  }
  
  private void a(int paramInt, com.tencent.mm.plugin.emoji.model.g paramg)
  {
    Log.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "");
    boolean bool1;
    boolean bool2;
    switch (paramInt)
    {
    default: 
      bool1 = false;
      bool2 = false;
    }
    for (;;)
    {
      if (this.rev != null) {
        this.rev.cFZ();
      }
      K(bool2, bool1);
      return;
      this.rev = paramg;
      bool1 = true;
      bool2 = true;
      continue;
      this.rev = paramg;
      bool1 = false;
      bool2 = true;
      continue;
      this.rev = paramg;
      bool1 = false;
      bool2 = false;
      continue;
      if (this.rev == null) {
        this.rev = new com.tencent.mm.plugin.emoji.model.g();
      }
      this.rev.FX(paramg.rbs);
      this.rev.dg(paramg.rbt);
      bool1 = false;
      bool2 = true;
    }
  }
  
  private void a(f paramf, int paramInt)
  {
    int j = 1;
    int k = 0;
    if (paramf == null)
    {
      Log.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "item is null.");
      return;
    }
    if (paramf.qYk == f.a.qYt)
    {
      paramf = paramf.qYm;
      if (paramf == null)
      {
        Log.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "banner set is null. do nothing");
        return;
      }
      com.tencent.mm.plugin.emoji.e.k.a(getContext(), paramf, false);
      return;
    }
    EmotionSummary localEmotionSummary = paramf.qYl;
    if (localEmotionSummary == null)
    {
      Log.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "summary is null. do nothing");
      return;
    }
    int i = k;
    if (cHZ())
    {
      i = k;
      if (com.tencent.mm.plugin.emoji.model.e.cFX().rbn) {
        i = 1;
      }
    }
    this.rbN.iz(String.valueOf(paramInt + 1));
    this.rbN.ix(localEmotionSummary.ProductID);
    as localas = this.rbN;
    String str;
    if (i != 0)
    {
      str = localEmotionSummary.ExptDesc;
      localas.iy(str);
      this.rbN.eqm = 3;
      this.rbN.bfK();
      if (!cHZ()) {
        break label283;
      }
      if ((paramInt < 0) || (paramInt >= this.rbD.cFk())) {
        break label241;
      }
      i = 3;
    }
    for (;;)
    {
      str = thisActivity().getIntent().getStringExtra("to_talker_name");
      com.tencent.mm.plugin.emoji.e.k.a(getContext(), localEmotionSummary, i, paramf.mStatus, paramf.HH, str, 5, this.rbN);
      return;
      str = localEmotionSummary.Introduce;
      break;
      label241:
      i = j;
      if (paramInt >= this.rbD.cFk())
      {
        i = j;
        if (paramInt < this.rbD.cFl() + this.rbD.cFk())
        {
          i = 19;
          continue;
          label283:
          i = 2;
        }
      }
    }
  }
  
  private void amY(String paramString)
  {
    if (isFinishing())
    {
      Log.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[showLoadingDialog] acitivity is finished.");
      return;
    }
    FragmentActivity localFragmentActivity = thisActivity();
    getString(2131755998);
    this.jZH = com.tencent.mm.ui.base.h.a(localFragmentActivity, paramString, true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
  }
  
  private void bq(byte[] paramArrayOfByte)
  {
    int i = cGQ();
    int j = this.reu;
    if (paramArrayOfByte != null)
    {
      Log.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[refreshNetSceneGetEmotionList] request buffer %s", new Object[] { paramArrayOfByte.toString() });
      this.res = new o(i, paramArrayOfByte, j);
      return;
    }
    Log.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[refreshNetSceneGetEmotionList] request buffer is null.");
    this.res = new o(i, j);
  }
  
  private void cGP()
  {
    com.tencent.mm.plugin.emoji.a.a.b.a(this.rbD.qXZ, this);
  }
  
  private void cGS()
  {
    com.tencent.mm.kernel.g.aAg().hqi.a(this.res, 0);
  }
  
  private void cHT()
  {
    this.rjO = true;
    this.iOB = System.currentTimeMillis();
    deu localdeu = new deu();
    localdeu.MJN = this.iOB;
    this.rbN.eqk = this.iOB;
    Log.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "initeData: %s", new Object[] { Long.valueOf(localdeu.MJN) });
    try
    {
      this.reh = localdeu.toByteArray();
      cHV();
      this.reu = thisActivity().getIntent().getIntExtra("preceding_scence", 5);
      if ((cHW()) && (this.czp != null))
      {
        this.czp.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(109140);
            EmojiStoreV2BaseFragment.this.lw(false);
            AppMethodBeat.o(109140);
          }
        }, 3000L);
        MMHandlerThread.postToMainThreadDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(109141);
            EmojiStoreV2BaseFragment.this.cHU();
            AppMethodBeat.o(109141);
          }
        }, 500L);
        return;
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.emoji.EmojiStoreV2BaseFragment", localIOException, "", new Object[0]);
        continue;
        lw(true);
      }
    }
  }
  
  private void cHV()
  {
    this.rew = new j();
    this.rew.owO = thisActivity();
    this.rew.rbF = this;
    this.rew.rbD = this.rbD;
    if (cHZ()) {}
    for (this.rew.rbG = 1;; this.rew.rbG = 2)
    {
      this.rew.rbJ = this;
      return;
    }
  }
  
  private boolean cHW()
  {
    boolean bool2 = false;
    GetEmotionListResponse localGetEmotionListResponse = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpQ.akx(cGQ());
    com.tencent.mm.plugin.emoji.model.g localg = o.a(localGetEmotionListResponse);
    int j = cGQ();
    int i;
    boolean bool1;
    label136:
    int k;
    if (localGetEmotionListResponse == null)
    {
      i = 0;
      Log.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "load cache type: %d, size: %d ", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      bool1 = bool2;
      if (localg != null)
      {
        bool1 = bool2;
        if (localg.rbt.size() > 0)
        {
          this.reA = true;
          this.GQ.setVisibility(8);
          this.reb.setVisibility(0);
          a(this.ree, localg);
          if (localGetEmotionListResponse == null) {
            break label240;
          }
          if (localGetEmotionListResponse.CellSetList != null) {
            break label228;
          }
          i = 0;
          k = localGetEmotionListResponse.TopHotNum;
          j = localGetEmotionListResponse.RecentHotNum;
        }
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "load cache hotcount:%d type:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(cGQ()) });
      if ((this.rbD != null) && (cHZ()))
      {
        this.rbD.FK(i + k);
        this.rbD.FL(j);
      }
      cGP();
      bool1 = true;
      return bool1;
      i = localGetEmotionListResponse.EmotionCount;
      break;
      label228:
      i = localGetEmotionListResponse.CellSetList.size();
      break label136;
      label240:
      j = 0;
      k = 0;
      i = 0;
    }
  }
  
  private static boolean cHX()
  {
    ((Long)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NSM, Long.valueOf(0L))).longValue();
    return true;
  }
  
  private void cHY()
  {
    if (this.rev == null) {
      Log.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "update store ui header failed. ");
    }
    do
    {
      return;
      this.reB = ((LinkedList)this.rev.rbv);
      this.reC = ((LinkedList)this.rev.rbw);
      if (this.reB != null)
      {
        this.rdY.d(this.reB, this.reC);
        return;
      }
    } while (this.rev.rbu == null);
    this.reB = new LinkedList();
    this.reB.add(this.rev.rbu);
    this.rdY.d(this.reB, this.reC);
  }
  
  private void d(final GetEmotionListResponse paramGetEmotionListResponse)
  {
    if (this.ree == -1) {
      com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable()
      {
        public final void run()
        {
          int j = 0;
          AppMethodBeat.i(109142);
          int i;
          if (paramGetEmotionListResponse != null)
          {
            if (paramGetEmotionListResponse != null) {
              break label95;
            }
            i = 0;
            if (paramGetEmotionListResponse != null) {
              break label106;
            }
          }
          for (;;)
          {
            Log.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "jacks save EmoijStoreUI Cache: list:%d, size: %d, type: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(EmojiStoreV2BaseFragment.this.cGQ()) });
            com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpQ.a(EmojiStoreV2BaseFragment.this.cGQ(), paramGetEmotionListResponse);
            AppMethodBeat.o(109142);
            return;
            label95:
            i = paramGetEmotionListResponse.EmotionCount;
            break;
            label106:
            if (paramGetEmotionListResponse.ReqBuf != null) {
              j = paramGetEmotionListResponse.ReqBuf.computeSize();
            }
          }
        }
      });
    }
  }
  
  private void lx(boolean paramBoolean)
  {
    if (this.mwr) {
      Log.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "isLoading");
    }
    do
    {
      return;
      this.mwr = true;
      if (paramBoolean) {
        this.reg.setVisibility(0);
      }
      bq(this.reh);
      cGS();
      Log.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[startLoadRemoteEmoji] doScene GetEmotionListNetScene");
    } while (paramBoolean);
    amY(getString(2131756029));
  }
  
  public final void FP(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= ((com.tencent.mm.plugin.emoji.a.h)this.rbD).cFo())) {
      return;
    }
    a(this.rbD.FN(paramInt), paramInt);
  }
  
  public final void Y(ArrayList<com.tencent.mm.pluginsdk.model.q> paramArrayList)
  {
    Log.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "google [onQueryFinish]");
    if (this.rbD == null) {
      return;
    }
    if (this.czp != null) {
      this.czp.sendEmptyMessageDelayed(131074, 50L);
    }
    com.tencent.mm.plugin.emoji.a.a.b.a(paramArrayList, this.rbD.qXZ);
  }
  
  public final void a(com.tencent.mm.plugin.emoji.a.a parama)
  {
    if (parama.cFc() == 9) {
      amY(getString(2131756005));
    }
    this.rew.rbN = this.rbN;
    j localj = this.rew;
    boolean bool;
    if ((cHZ()) && (com.tencent.mm.plugin.emoji.model.e.cFX().rbn))
    {
      bool = true;
      localj.rbO = bool;
      if (!cHZ()) {
        break label168;
      }
      if ((parama.mPosition < 0) || (parama.mPosition >= this.rbD.cFk())) {
        break label109;
      }
      this.rew.rbG = 3;
    }
    label168:
    for (;;)
    {
      this.rew.a(parama);
      return;
      bool = false;
      break;
      label109:
      if ((parama.mPosition >= this.rbD.cFk()) && (parama.mPosition < this.rbD.cFl() + this.rbD.cFk()))
      {
        this.rew.rbG = 19;
      }
      else
      {
        this.rew.rbG = 1;
        continue;
        this.rew.rbG = 2;
      }
    }
  }
  
  protected void b(int paramInt1, int paramInt2, com.tencent.mm.ak.q paramq)
  {
    this.mwr = false;
    this.reg.setVisibility(8);
    if ((paramInt1 == 0) || (paramInt1 == 4))
    {
      paramInt1 = 1;
      if (paramInt1 == 0) {
        break label192;
      }
      this.GQ.setVisibility(8);
      this.reb.setVisibility(0);
      localObject = (o)paramq;
      paramq = o.a(((o)localObject).cGx());
      this.reh = ((o)localObject).rcY;
      if (paramInt2 != 0) {
        break label107;
      }
      localObject = ((o)localObject).cGx();
      a(this.ree, paramq);
      d((GetEmotionListResponse)localObject);
      this.ree = 0;
    }
    label107:
    while (this.reA)
    {
      Object localObject;
      return;
      paramInt1 = 0;
      break;
      if (paramInt2 == 2)
      {
        localObject = ((o)localObject).cGx();
        a(this.ree, paramq);
        cGP();
        d((GetEmotionListResponse)localObject);
        this.ree = 2;
        return;
      }
      if (paramInt2 == 3)
      {
        a(this.ree, paramq);
        this.ree = 1;
        return;
      }
      this.GQ.setVisibility(0);
      this.reb.setVisibility(8);
      this.rec.setText(2131758624);
      return;
    }
    label192:
    this.GQ.setVisibility(0);
    this.reb.setVisibility(8);
    this.rec.setText(2131758625);
  }
  
  public final boolean cAj()
  {
    Log.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[onBottomLoadData] startLoadRemoteEmoji.");
    lx(true);
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
  
  public abstract com.tencent.mm.plugin.emoji.a.a.a cGJ();
  
  public abstract int cGQ();
  
  public final void cGa()
  {
    this.reh = null;
    this.ree = -1;
    lx(false);
  }
  
  protected void cHU() {}
  
  public abstract boolean cHZ();
  
  public final void cIa()
  {
    if ((this.mListView != null) && (this.rbD != null) && (cHZ())) {
      this.rbD.refreshView();
    }
  }
  
  public final void d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.rez = new com.tencent.mm.plugin.emoji.f.h(paramString1, paramString2, paramString3, null, paramString5);
    com.tencent.mm.kernel.g.aAg().hqi.a(this.rez, 0);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public final void l(Message paramMessage)
  {
    if (this.czp != null) {
      this.czp.sendMessage(paramMessage);
    }
  }
  
  public final void lw(boolean paramBoolean)
  {
    Log.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "loadNetWork force:%b isNeedToRefresh:%b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(cHX()) });
    if (!paramBoolean) {
      cHX();
    }
    bq(this.reh);
    cGS();
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    Log.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onActivityCreated");
    super.onActivityCreated(paramBundle);
    this.rjP = true;
    this.rbD = cGJ();
    this.rbD.qYa = this;
    this.GQ = findViewById(2131300076);
    this.rec = ((TextView)this.GQ.findViewById(2131300085));
    this.reg = getActivityLayoutInflater().inflate(2131493953, null);
    this.reg.setVisibility(8);
    this.rdY = new EmojiStoreVpHeader(getContext());
    this.mListView = ((ListView)findViewById(16908298));
    this.mListView.addHeaderView(this.rdY);
    if (!cHZ())
    {
      this.rjM = new EmojiStoreV2HotBarView(getContext());
      this.rjM.setDesignerEmojiViewVisibility(8);
      this.rjM.setDesignerCatalogViewPadding(false);
      this.mListView.addHeaderView(this.rjM);
    }
    this.mListView.addFooterView(this.reg);
    this.mListView.setAdapter(this.rbD);
    if (cHZ()) {
      this.mListView.setOnItemClickListener(this);
    }
    for (;;)
    {
      this.mListView.setOnScrollListener(this);
      this.mListView.setLongClickable(false);
      this.mListView.setOnTouchListener(new EmojiStoreV2BaseFragment.7(this));
      this.rbD.qXY = this.mListView;
      this.reb = ((MMPullDownView)findViewById(2131303686));
      if (this.reb != null)
      {
        this.reb.setTopViewVisible(false);
        this.reb.setAtTopCallBack(this);
        this.reb.setOnBottomLoadDataListener(this);
        this.reb.setAtBottomCallBack(this);
        this.reb.setBottomViewVisible(false);
        this.reb.setIsBottomShowAll(false);
        this.reb.setIsReturnSuperDispatchWhenCancel(true);
      }
      if (this.rjN) {
        cHT();
      }
      return;
      ((com.tencent.mm.plugin.emoji.a.h)this.rbD).qXI = this;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Log.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onActivityResult . requestCode:" + paramInt1 + "  resultCode:" + paramInt2);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.rew != null)
    {
      this.rew.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
    }
    Log.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "mPayOrDownloadComponent have no init.");
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    Log.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onAttach");
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.rdY != null) {
      this.rdY.requestLayout();
    }
    setRequestedOrientation(1);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setRequestedOrientation(1);
    this.mActionBar = ((AppCompatActivity)thisActivity()).getSupportActionBar();
    paramBundle = aa.jQ(getContext()).inflate(2131492940, null);
    this.mActionBarHelper = new com.tencent.mm.ui.a(paramBundle);
    paramBundle.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    Object localObject = paramBundle.findViewById(2131307172);
    if (localObject != null)
    {
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)((View)localObject).getLayoutParams();
      localMarginLayoutParams.leftMargin = at.fromDPToPix(getContext(), 36);
      ((View)localObject).setLayoutParams(localMarginLayoutParams);
    }
    this.mActionBar.setLogo(new ColorDrawable(getResources().getColor(17170445)));
    this.mActionBar.gt();
    this.mActionBar.setDisplayHomeAsUpEnabled(false);
    this.mActionBar.gs();
    this.mActionBar.gu();
    this.mActionBar.setCustomView(paramBundle);
    this.mActionBar.show();
    paramBundle = this.mActionBarHelper;
    paramBundle.jVO.setText(2131758601);
    if (com.tencent.mm.cb.a.jk(paramBundle.jVO.getContext()))
    {
      localObject = paramBundle.jVO;
      float f = com.tencent.mm.cb.a.aH(paramBundle.jVO.getContext(), 2131165186);
      ((TextView)localObject).setTextSize(0, com.tencent.mm.cb.a.ji(paramBundle.jVO.getContext()) * f);
    }
    this.mActionBarHelper.setClickListener(new EmojiStoreV2BaseFragment.5(this));
    showOptionMenu(true);
    addIconOptionMenu(0, 2131689513, new EmojiStoreV2BaseFragment.6(this));
    EventCenter.instance.addListener(this.rey);
    com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpO.add(this);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    Log.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onCreateView");
    return paramLayoutInflater.inflate(getLayoutId(), paramViewGroup, false);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Log.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onDestroy");
    if (this.rbD != null)
    {
      this.rbD.clear();
      this.rbD = null;
    }
    if (this.rdY != null)
    {
      this.rdY.cHO();
      this.rdY.clear();
    }
    EventCenter.instance.removeListener(this.rey);
    com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpO.remove(this);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    Log.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onResume");
  }
  
  public void onDetach()
  {
    super.onDetach();
    Log.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onDetach");
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramAdapterView);
    localb.bm(paramView);
    localb.pH(paramInt);
    localb.zo(paramLong);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2BaseFragment", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
    paramInt -= this.mListView.getHeaderViewsCount();
    if ((paramInt < 0) || (paramInt >= this.rbD.getCount()))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2BaseFragment", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      return;
    }
    paramAdapterView = this.rbD.FN(paramInt);
    a(paramAdapterView, paramInt);
    if ((cHZ()) && (this.rbD.cFl() > 0) && (paramInt >= this.rbD.cFk()) && (paramInt < this.rbD.cFk() + this.rbD.cFl()) && (paramAdapterView.qYl != null)) {
      com.tencent.mm.plugin.report.service.h.CyF.a(13223, new Object[] { Integer.valueOf(1), paramAdapterView.qYl.ProductID, paramAdapterView.qYl.PackName, Integer.valueOf(1), Integer.valueOf(0) });
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2BaseFragment", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
  }
  
  public void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals("delete_group")) && (this.czp != null)) {
      this.czp.sendEmptyMessageDelayed(131074, 50L);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    com.tencent.mm.kernel.g.aAg().hqi.b(411, this);
    com.tencent.mm.kernel.g.aAg().hqi.b(423, this);
    Log.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onPause");
    if (this.rdY != null) {
      this.rdY.cHO();
    }
    if (this.czp != null) {
      this.czp.removeMessages(131077);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    Log.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onResume");
    com.tencent.mm.kernel.g.aAg().hqi.a(411, this);
    com.tencent.mm.kernel.g.aAg().hqi.a(423, this);
    if (this.rjN)
    {
      if (this.czp != null) {
        this.czp.sendEmptyMessageDelayed(131077, 4000L);
      }
      if ((this.rbD != null) && (this.rbD.qXZ != null))
      {
        this.rbD.qXZ.cFq();
        this.rbD.refreshView();
      }
      if (((Boolean)com.tencent.mm.kernel.g.aAh().azQ().get(208900, Boolean.FALSE)).booleanValue())
      {
        cGa();
        com.tencent.mm.kernel.g.aAh().azQ().set(208900, Boolean.FALSE);
      }
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    Log.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onSceneEnd errType:%d,errCode:%d,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((this.jZH != null) && (this.jZH.isShowing())) {
      this.jZH.dismiss();
    }
    int i3 = paramq.getType();
    switch (i3)
    {
    default: 
      Log.w("MicroMsg.emoji.EmojiStoreV2BaseFragment", "unknow scene type.");
      break;
      break;
    }
    for (;;)
    {
      return;
      if ((paramq instanceof o))
      {
        paramString = (o)paramq;
        if ((paramString == null) || (paramString.mType != cGQ())) {
          break;
        }
        int i2 = 0;
        int m = 0;
        int n = 0;
        int i1 = 0;
        int i = i2;
        int k = i1;
        int j = n;
        if (paramString != null)
        {
          i = i2;
          k = i1;
          j = n;
          if (paramString.cGx() != null)
          {
            i = m;
            if (this.rbD.cFm() <= 0)
            {
              i = m;
              if (cHZ()) {
                if (paramString.cGx().CellSetList != null) {
                  break label474;
                }
              }
            }
          }
        }
        label474:
        for (i = 0;; i = paramString.cGx().CellSetList.size())
        {
          this.rbD.FM(i);
          j = paramString.cGx().TopHotNum;
          k = paramString.cGx().RecentHotNum;
          Log.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onSceneEnd setSize:%d hotcount:%d recentHotCount:%d type:%d getSceneType:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i3), Integer.valueOf(paramString.mType) });
          if ((this.rbD != null) && (this.rbD.cFl() <= 0) && (cHZ()))
          {
            com.tencent.mm.plugin.emoji.a.a.a locala = this.rbD;
            locala.FK(j + locala.cFm());
            this.rbD.FL(k);
          }
          b(paramInt1, paramInt2, paramq);
          if (!cHZ()) {
            break;
          }
          if ((paramString.cGx() == null) || (paramString.cGx().CellSetList == null) || (paramString.cGx().CellSetList.size() <= 0)) {
            break label489;
          }
          paramInt1 = 0;
          while (paramInt1 < paramString.cGx().CellSetList.size())
          {
            com.tencent.mm.plugin.report.service.h.CyF.a(13223, new Object[] { Integer.valueOf(0), Integer.valueOf(((EmotionBannerSet)paramString.cGx().CellSetList.get(paramInt1)).ID), ((EmotionBannerSet)paramString.cGx().CellSetList.get(paramInt1)).Title, Integer.valueOf(0) });
            paramInt1 += 1;
          }
        }
        label489:
        if ((paramString.cGx().RecentHotNum <= 0) || (paramString.cGx().EmotionList == null) || (paramString.cGx().EmotionList.size() <= paramString.cGx().TopHotNum + paramString.cGx().RecentHotNum)) {
          break;
        }
        paramInt1 = 0;
        while (paramInt1 < paramString.cGx().RecentHotNum)
        {
          com.tencent.mm.plugin.report.service.h.CyF.a(13223, new Object[] { Integer.valueOf(0), ((EmotionSummary)paramString.cGx().EmotionList.get(paramString.cGx().TopHotNum + paramInt1)).ProductID, ((EmotionSummary)paramString.cGx().EmotionList.get(paramString.cGx().TopHotNum + paramInt1)).PackName, Integer.valueOf(1) });
          paramInt1 += 1;
        }
      }
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1)) {
      if ((this.ree == 0) || (this.mwr)) {
        Log.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "No More List.");
      }
    }
    while (paramInt != 0)
    {
      return;
      lx(true);
      Log.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[onScrollStateChanged] startLoadRemoteEmoji.");
    }
    cHU();
  }
  
  public void onStart()
  {
    super.onStart();
    Log.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onStart");
  }
  
  public void onStop()
  {
    super.onStop();
    Log.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onStop");
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    Log.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "setUserVisibleHint :%b", new Object[] { Boolean.valueOf(paramBoolean) });
    super.setUserVisibleHint(paramBoolean);
    this.rjN = paramBoolean;
    if ((!this.rjO) && (this.rjP)) {
      cHT();
    }
    while (!paramBoolean) {
      return;
    }
    cHU();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2BaseFragment
 * JD-Core Version:    0.7.0.1
 */