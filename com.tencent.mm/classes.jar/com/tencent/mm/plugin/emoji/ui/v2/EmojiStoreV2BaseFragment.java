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
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.di;
import com.tencent.mm.g.b.a.w;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.emoji.a.a.f.a;
import com.tencent.mm.plugin.emoji.a.h.a;
import com.tencent.mm.plugin.emoji.model.d;
import com.tencent.mm.plugin.emoji.model.j;
import com.tencent.mm.plugin.emoji.model.j.b;
import com.tencent.mm.plugin.emoji.ui.EmojiStoreVpHeader;
import com.tencent.mm.pluginsdk.model.p;
import com.tencent.mm.protocal.protobuf.EmotionBanner;
import com.tencent.mm.protocal.protobuf.EmotionBannerSet;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.protocal.protobuf.GetEmotionListResponse;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.chh;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.emotion.s;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.c;
import com.tencent.mm.ui.base.MMPullDownView.d;
import com.tencent.mm.ui.base.MMPullDownView.e;
import com.tencent.mm.ui.z;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public abstract class EmojiStoreV2BaseFragment
  extends MMFragment
  implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener, com.tencent.mm.ak.g, h.a, com.tencent.mm.plugin.emoji.model.j.a, j.b, com.tencent.mm.pluginsdk.model.j.a, k.a, MMPullDownView.c, MMPullDownView.d, MMPullDownView.e
{
  private View EP;
  private ao gqT = new ao()
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
        if (localEmojiStoreV2BaseFragment.paX != null)
        {
          localEmojiStoreV2BaseFragment.paX.notifyDataSetChanged();
          AppMethodBeat.o(109135);
          return;
          if ((localEmojiStoreV2BaseFragment.paX == null) || (paramAnonymousMessage.getData() == null))
          {
            AppMethodBeat.o(109135);
            return;
          }
          String str = paramAnonymousMessage.getData().getString("product_id");
          if (str != null)
          {
            int i = paramAnonymousMessage.getData().getInt("progress");
            localEmojiStoreV2BaseFragment.paX.cQ(str, i);
            AppMethodBeat.o(109135);
            return;
            if ((localEmojiStoreV2BaseFragment.paX == null) || (paramAnonymousMessage.getData() == null))
            {
              AppMethodBeat.o(109135);
              return;
            }
            str = paramAnonymousMessage.getData().getString("product_id");
            if (str != null)
            {
              i = paramAnonymousMessage.getData().getInt("status");
              localEmojiStoreV2BaseFragment.paX.cP(str, i);
              AppMethodBeat.o(109135);
              return;
              if (localEmojiStoreV2BaseFragment.pdy != null) {
                localEmojiStoreV2BaseFragment.pdy.cdT();
              }
            }
          }
        }
      }
    }
  };
  private ProgressDialog iFC;
  private boolean kOL;
  private ActionBar mActionBar;
  private com.tencent.mm.ui.a mActionBarHelper;
  protected ListView mListView;
  protected long nfL;
  com.tencent.mm.plugin.emoji.a.a.a paX;
  protected w pbh = new w();
  private MMPullDownView pdB;
  private TextView pdC;
  private int pdE = -1;
  private View pdF;
  private byte[] pdG;
  private final int pdK = 131074;
  private final int pdL = 131075;
  private final int pdM = 131076;
  private final String pdN = "product_id";
  private final String pdO = "progress";
  private final String pdP = "status";
  private com.tencent.mm.plugin.emoji.f.n pdQ;
  private int pdR;
  private com.tencent.mm.plugin.emoji.model.f pdS;
  private j pdT;
  private com.tencent.mm.sdk.b.c pdV = new com.tencent.mm.sdk.b.c() {};
  private com.tencent.mm.plugin.emoji.f.g pdW;
  private boolean pdX = false;
  private LinkedList<EmotionBanner> pdY = new LinkedList();
  private LinkedList<EmotionBannerSet> pdZ = new LinkedList();
  EmojiStoreVpHeader pdy;
  private final int piH = 131077;
  public EmojiStoreV2HotBarView piI;
  private boolean piJ = false;
  private boolean piK = false;
  private boolean piL = false;
  private MenuItem.OnMenuItemClickListener piM = new EmojiStoreV2BaseFragment.4(this);
  
  private void L(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.pdS != null) && (paramBoolean1))
    {
      if (paramBoolean2) {
        cee();
      }
      if (this.paX != null) {
        this.paX.b(this.pdS);
      }
    }
  }
  
  private void Yu(String paramString)
  {
    if (isFinishing())
    {
      ac.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[showLoadingDialog] acitivity is finished.");
      return;
    }
    FragmentActivity localFragmentActivity = thisActivity();
    getString(2131755906);
    this.iFC = com.tencent.mm.ui.base.h.b(localFragmentActivity, paramString, true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
  }
  
  private void a(int paramInt, com.tencent.mm.plugin.emoji.model.f paramf)
  {
    ac.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "");
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
      if (this.pdS != null) {
        this.pdS.ccg();
      }
      L(bool2, bool1);
      return;
      this.pdS = paramf;
      bool1 = true;
      bool2 = true;
      continue;
      this.pdS = paramf;
      bool1 = false;
      bool2 = true;
      continue;
      this.pdS = paramf;
      bool1 = false;
      bool2 = false;
      continue;
      if (this.pdS == null) {
        this.pdS = new com.tencent.mm.plugin.emoji.model.f();
      }
      this.pdS.Bs(paramf.pay);
      this.pdS.cN(paramf.paz);
      bool1 = false;
      bool2 = true;
    }
  }
  
  private void a(com.tencent.mm.plugin.emoji.a.a.f paramf, int paramInt)
  {
    int j = 1;
    int k = 0;
    if (paramf == null)
    {
      ac.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "item is null.");
      return;
    }
    if (paramf.oYk == f.a.oYt)
    {
      paramf = paramf.oYm;
      if (paramf == null)
      {
        ac.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "banner set is null. do nothing");
        return;
      }
      com.tencent.mm.plugin.emoji.e.k.a(getContext(), paramf, false);
      return;
    }
    EmotionSummary localEmotionSummary = paramf.oYl;
    if (localEmotionSummary == null)
    {
      ac.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "summary is null. do nothing");
      return;
    }
    int i = k;
    if (cef())
    {
      i = k;
      if (d.cce().pat) {
        i = 1;
      }
    }
    this.pbh.fU(String.valueOf(paramInt + 1));
    this.pbh.fS(localEmotionSummary.ProductID);
    w localw = this.pbh;
    String str;
    if (i != 0)
    {
      str = localEmotionSummary.ExptDesc;
      localw.fT(str);
      this.pbh.dHA = 3;
      this.pbh.aHZ();
      if (!cef()) {
        break label285;
      }
      if ((paramInt < 0) || (paramInt >= this.paX.cbE())) {
        break label243;
      }
      i = 3;
    }
    for (;;)
    {
      str = thisActivity().getIntent().getStringExtra("to_talker_name");
      com.tencent.mm.plugin.emoji.e.k.a(getContext(), localEmotionSummary, i, paramf.mStatus, paramf.FG, str, 5, this.pbh);
      return;
      str = localEmotionSummary.Introduce;
      break;
      label243:
      i = j;
      if (paramInt >= this.paX.cbE())
      {
        i = j;
        if (paramInt < this.paX.cbF() + this.paX.cbE())
        {
          i = 19;
          continue;
          label285:
          i = 2;
        }
      }
    }
  }
  
  private void aY(byte[] paramArrayOfByte)
  {
    int i = ccZ();
    int j = this.pdR;
    if (paramArrayOfByte != null)
    {
      ac.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[refreshNetSceneGetEmotionList] request buffer %s", new Object[] { paramArrayOfByte.toString() });
      this.pdQ = new com.tencent.mm.plugin.emoji.f.n(i, paramArrayOfByte, j);
      return;
    }
    ac.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[refreshNetSceneGetEmotionList] request buffer is null.");
    this.pdQ = new com.tencent.mm.plugin.emoji.f.n(i, j);
  }
  
  private void ccY()
  {
    com.tencent.mm.plugin.emoji.a.a.b.a(this.paX.oXZ, this);
  }
  
  private void cdZ()
  {
    this.piK = true;
    this.nfL = System.currentTimeMillis();
    chh localchh = new chh();
    localchh.Fvw = this.nfL;
    this.pbh.dHy = this.nfL;
    ac.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "initeData: %s", new Object[] { Long.valueOf(localchh.Fvw) });
    try
    {
      this.pdG = localchh.toByteArray();
      ceb();
      this.pdR = thisActivity().getIntent().getIntExtra("preceding_scence", 5);
      if ((cec()) && (this.gqT != null))
      {
        this.gqT.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(109140);
            EmojiStoreV2BaseFragment.this.kk(false);
            AppMethodBeat.o(109140);
          }
        }, 3000L);
        ap.n(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(109141);
            EmojiStoreV2BaseFragment.this.cea();
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
        ac.printErrStackTrace("MicroMsg.emoji.EmojiStoreV2BaseFragment", localIOException, "", new Object[0]);
        continue;
        kk(true);
      }
    }
  }
  
  private void cdb()
  {
    com.tencent.mm.kernel.g.agQ().ghe.a(this.pdQ, 0);
  }
  
  private void ceb()
  {
    this.pdT = new j();
    this.pdT.mHB = thisActivity();
    this.pdT.paZ = this;
    this.pdT.paX = this.paX;
    if (cef()) {}
    for (this.pdT.pba = 1;; this.pdT.pba = 2)
    {
      this.pdT.pbd = this;
      return;
    }
  }
  
  private boolean cec()
  {
    boolean bool2 = false;
    GetEmotionListResponse localGetEmotionListResponse = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().GYc.YY(ccZ());
    com.tencent.mm.plugin.emoji.model.f localf = com.tencent.mm.plugin.emoji.f.n.b(localGetEmotionListResponse);
    int j = ccZ();
    int i;
    boolean bool1;
    label136:
    int k;
    if (localGetEmotionListResponse == null)
    {
      i = 0;
      ac.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "load cache type: %d, size: %d ", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      bool1 = bool2;
      if (localf != null)
      {
        bool1 = bool2;
        if (localf.paz.size() > 0)
        {
          this.pdX = true;
          this.EP.setVisibility(8);
          this.pdB.setVisibility(0);
          a(this.pdE, localf);
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
      ac.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "load cache hotcount:%d type:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(ccZ()) });
      if ((this.paX != null) && (cef()))
      {
        this.paX.Bh(i + k);
        this.paX.Bi(j);
      }
      ccY();
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
  
  private static boolean ced()
  {
    ((Long)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GDZ, Long.valueOf(0L))).longValue();
    return true;
  }
  
  private void cee()
  {
    if (this.pdS == null) {
      ac.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "update store ui header failed. ");
    }
    do
    {
      return;
      this.pdY = ((LinkedList)this.pdS.paB);
      this.pdZ = ((LinkedList)this.pdS.paC);
      if (this.pdY != null)
      {
        this.pdy.d(this.pdY, this.pdZ);
        return;
      }
    } while (this.pdS.paA == null);
    this.pdY = new LinkedList();
    this.pdY.add(this.pdS.paA);
    this.pdy.d(this.pdY, this.pdZ);
  }
  
  private void e(final GetEmotionListResponse paramGetEmotionListResponse)
  {
    if (this.pdE == -1) {
      com.tencent.mm.kernel.g.agU().az(new Runnable()
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
            ac.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "jacks save EmoijStoreUI Cache: list:%d, size: %d, type: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(EmojiStoreV2BaseFragment.this.ccZ()) });
            com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().GYc.a(EmojiStoreV2BaseFragment.this.ccZ(), paramGetEmotionListResponse);
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
  
  private void kl(boolean paramBoolean)
  {
    if (this.kOL) {
      ac.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "isLoading");
    }
    do
    {
      return;
      this.kOL = true;
      if (paramBoolean) {
        this.pdF.setVisibility(0);
      }
      aY(this.pdG);
      cdb();
      ac.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[startLoadRemoteEmoji] doScene GetEmotionListNetScene");
    } while (paramBoolean);
    Yu(getString(2131755936));
  }
  
  public final void Bm(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= ((com.tencent.mm.plugin.emoji.a.h)this.paX).cbI())) {
      return;
    }
    a(this.paX.Bk(paramInt), paramInt);
  }
  
  public final void R(ArrayList<p> paramArrayList)
  {
    ac.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "google [onQueryFinish]");
    if (this.paX == null) {
      return;
    }
    if (this.gqT != null) {
      this.gqT.sendEmptyMessageDelayed(131074, 50L);
    }
    com.tencent.mm.plugin.emoji.a.a.b.a(paramArrayList, this.paX.oXZ);
  }
  
  public final void a(com.tencent.mm.plugin.emoji.a.a parama)
  {
    if (parama.cbw() == 9) {
      Yu(getString(2131755913));
    }
    this.pdT.pbh = this.pbh;
    j localj = this.pdT;
    boolean bool;
    if ((cef()) && (d.cce().pat))
    {
      bool = true;
      localj.pbi = bool;
      if (!cef()) {
        break label168;
      }
      if ((parama.mPosition < 0) || (parama.mPosition >= this.paX.cbE())) {
        break label109;
      }
      this.pdT.pba = 3;
    }
    label168:
    for (;;)
    {
      this.pdT.a(parama);
      return;
      bool = false;
      break;
      label109:
      if ((parama.mPosition >= this.paX.cbE()) && (parama.mPosition < this.paX.cbF() + this.paX.cbE()))
      {
        this.pdT.pba = 19;
      }
      else
      {
        this.pdT.pba = 1;
        continue;
        this.pdT.pba = 2;
      }
    }
  }
  
  public final void a(String paramString, m paramm)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals("delete_group")) && (this.gqT != null)) {
      this.gqT.sendEmptyMessageDelayed(131074, 50L);
    }
  }
  
  protected void b(int paramInt1, int paramInt2, com.tencent.mm.ak.n paramn)
  {
    this.kOL = false;
    this.pdF.setVisibility(8);
    if ((paramInt1 == 0) || (paramInt1 == 4))
    {
      paramInt1 = 1;
      if (paramInt1 == 0) {
        break label192;
      }
      this.EP.setVisibility(8);
      this.pdB.setVisibility(0);
      localObject = (com.tencent.mm.plugin.emoji.f.n)paramn;
      paramn = com.tencent.mm.plugin.emoji.f.n.b(((com.tencent.mm.plugin.emoji.f.n)localObject).ccF());
      this.pdG = ((com.tencent.mm.plugin.emoji.f.n)localObject).pcq;
      if (paramInt2 != 0) {
        break label107;
      }
      localObject = ((com.tencent.mm.plugin.emoji.f.n)localObject).ccF();
      a(this.pdE, paramn);
      e((GetEmotionListResponse)localObject);
      this.pdE = 0;
    }
    label107:
    while (this.pdX)
    {
      Object localObject;
      return;
      paramInt1 = 0;
      break;
      if (paramInt2 == 2)
      {
        localObject = ((com.tencent.mm.plugin.emoji.f.n)localObject).ccF();
        a(this.pdE, paramn);
        ccY();
        e((GetEmotionListResponse)localObject);
        this.pdE = 2;
        return;
      }
      if (paramInt2 == 3)
      {
        a(this.pdE, paramn);
        this.pdE = 1;
        return;
      }
      this.EP.setVisibility(0);
      this.pdB.setVisibility(8);
      this.pdC.setText(2131758330);
      return;
    }
    label192:
    this.EP.setVisibility(0);
    this.pdB.setVisibility(8);
    this.pdC.setText(2131758331);
  }
  
  public final boolean bWx()
  {
    ac.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[onBottomLoadData] startLoadRemoteEmoji.");
    kl(true);
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
  
  public abstract com.tencent.mm.plugin.emoji.a.a.a ccS();
  
  public abstract int ccZ();
  
  public final void cci()
  {
    this.pdG = null;
    this.pdE = -1;
    kl(false);
  }
  
  protected void cea() {}
  
  public abstract boolean cef();
  
  public final void ceg()
  {
    if ((this.mListView != null) && (this.paX != null) && (cef())) {
      this.paX.refreshView();
    }
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public final void kk(boolean paramBoolean)
  {
    ac.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "loadNetWork force:%b isNeedToRefresh:%b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(ced()) });
    if (!paramBoolean) {
      ced();
    }
    aY(this.pdG);
    cdb();
  }
  
  public final void l(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.pdW = new com.tencent.mm.plugin.emoji.f.g(paramString1, paramString2, paramString3);
    com.tencent.mm.kernel.g.agQ().ghe.a(this.pdW, 0);
  }
  
  public final void n(Message paramMessage)
  {
    if (this.gqT != null) {
      this.gqT.sendMessage(paramMessage);
    }
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    ac.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onActivityCreated");
    super.onActivityCreated(paramBundle);
    this.piL = true;
    this.paX = ccS();
    this.paX.oYa = this;
    this.EP = findViewById(2131299457);
    this.pdC = ((TextView)this.EP.findViewById(2131299461));
    this.pdF = getActivityLayoutInflater().inflate(2131493799, null);
    this.pdF.setVisibility(8);
    this.pdy = new EmojiStoreVpHeader(getContext());
    this.mListView = ((ListView)findViewById(16908298));
    this.mListView.addHeaderView(this.pdy);
    if (!cef())
    {
      this.piI = new EmojiStoreV2HotBarView(getContext());
      this.piI.setDesignerEmojiViewVisibility(8);
      this.piI.setDesignerCatalogViewPadding(false);
      this.mListView.addHeaderView(this.piI);
    }
    this.mListView.addFooterView(this.pdF);
    this.mListView.setAdapter(this.paX);
    if (cef()) {
      this.mListView.setOnItemClickListener(this);
    }
    for (;;)
    {
      this.mListView.setOnScrollListener(this);
      this.mListView.setLongClickable(false);
      this.mListView.setOnTouchListener(new EmojiStoreV2BaseFragment.7(this));
      this.paX.oXY = this.mListView;
      this.pdB = ((MMPullDownView)findViewById(2131301487));
      if (this.pdB != null)
      {
        this.pdB.setTopViewVisible(false);
        this.pdB.setAtTopCallBack(this);
        this.pdB.setOnBottomLoadDataListener(this);
        this.pdB.setAtBottomCallBack(this);
        this.pdB.setBottomViewVisible(false);
        this.pdB.setIsBottomShowAll(false);
        this.pdB.setIsReturnSuperDispatchWhenCancel(true);
      }
      if (this.piJ) {
        cdZ();
      }
      return;
      ((com.tencent.mm.plugin.emoji.a.h)this.paX).oXI = this;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    ac.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onActivityResult . requestCode:" + paramInt1 + "  resultCode:" + paramInt2);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.pdT != null)
    {
      this.pdT.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
    }
    ac.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "mPayOrDownloadComponent have no init.");
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    ac.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onAttach");
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.pdy != null) {
      this.pdy.requestLayout();
    }
    setRequestedOrientation(1);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setRequestedOrientation(1);
    this.mActionBar = ((AppCompatActivity)thisActivity()).getSupportActionBar();
    paramBundle = z.jD(getContext()).inflate(2131492921, null);
    this.mActionBarHelper = new com.tencent.mm.ui.a(paramBundle);
    this.mActionBar.setLogo(new ColorDrawable(getResources().getColor(17170445)));
    this.mActionBar.fU();
    this.mActionBar.setDisplayHomeAsUpEnabled(false);
    this.mActionBar.fT();
    this.mActionBar.fV();
    this.mActionBar.setCustomView(paramBundle);
    this.mActionBar.show();
    paramBundle = this.mActionBarHelper;
    paramBundle.iCg.setText(2131758307);
    if (com.tencent.mm.cc.a.id(paramBundle.iCg.getContext()))
    {
      TextView localTextView = paramBundle.iCg;
      float f = com.tencent.mm.cc.a.av(paramBundle.iCg.getContext(), 2131165184);
      localTextView.setTextSize(0, com.tencent.mm.cc.a.ib(paramBundle.iCg.getContext()) * f);
    }
    this.mActionBarHelper.e(new EmojiStoreV2BaseFragment.5(this));
    showOptionMenu(true);
    addIconOptionMenu(0, 2131689511, new EmojiStoreV2BaseFragment.6(this));
    com.tencent.mm.sdk.b.a.GpY.c(this.pdV);
    com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().GYa.add(this);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    ac.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onCreateView");
    return paramLayoutInflater.inflate(getLayoutId(), paramViewGroup, false);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ac.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onDestroy");
    if (this.paX != null)
    {
      this.paX.clear();
      this.paX = null;
    }
    if (this.pdy != null)
    {
      this.pdy.cdU();
      this.pdy.clear();
    }
    com.tencent.mm.sdk.b.a.GpY.d(this.pdV);
    com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().GYa.remove(this);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    ac.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onResume");
  }
  
  public void onDetach()
  {
    super.onDetach();
    ac.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onDetach");
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramInt -= this.mListView.getHeaderViewsCount();
    if ((paramInt < 0) || (paramInt >= this.paX.getCount())) {}
    do
    {
      return;
      paramAdapterView = this.paX.Bk(paramInt);
      a(paramAdapterView, paramInt);
    } while ((!cef()) || (this.paX.cbF() <= 0) || (paramInt < this.paX.cbE()) || (paramInt >= this.paX.cbE() + this.paX.cbF()) || (paramAdapterView.oYl == null));
    com.tencent.mm.plugin.report.service.h.wUl.f(13223, new Object[] { Integer.valueOf(1), paramAdapterView.oYl.ProductID, paramAdapterView.oYl.PackName, Integer.valueOf(1), Integer.valueOf(0) });
  }
  
  public void onPause()
  {
    super.onPause();
    com.tencent.mm.kernel.g.agQ().ghe.b(411, this);
    com.tencent.mm.kernel.g.agQ().ghe.b(423, this);
    ac.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onPause");
    if (this.pdy != null) {
      this.pdy.cdU();
    }
    if (this.gqT != null) {
      this.gqT.removeMessages(131077);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    ac.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onResume");
    com.tencent.mm.kernel.g.agQ().ghe.a(411, this);
    com.tencent.mm.kernel.g.agQ().ghe.a(423, this);
    if (this.piJ)
    {
      if (this.gqT != null) {
        this.gqT.sendEmptyMessageDelayed(131077, 4000L);
      }
      if ((this.paX != null) && (this.paX.oXZ != null))
      {
        this.paX.oXZ.cbK();
        this.paX.refreshView();
      }
      if (((Boolean)com.tencent.mm.kernel.g.agR().agA().get(208900, Boolean.FALSE)).booleanValue())
      {
        cci();
        com.tencent.mm.kernel.g.agR().agA().set(208900, Boolean.FALSE);
      }
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    ac.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onSceneEnd errType:%d,errCode:%d,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((this.iFC != null) && (this.iFC.isShowing())) {
      this.iFC.dismiss();
    }
    int i3 = paramn.getType();
    switch (i3)
    {
    default: 
      ac.w("MicroMsg.emoji.EmojiStoreV2BaseFragment", "unknow scene type.");
      break;
      break;
    }
    for (;;)
    {
      return;
      if ((paramn instanceof com.tencent.mm.plugin.emoji.f.n))
      {
        paramString = (com.tencent.mm.plugin.emoji.f.n)paramn;
        if ((paramString == null) || (paramString.mType != ccZ())) {
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
          if (paramString.ccF() != null)
          {
            i = m;
            if (this.paX.cbG() <= 0)
            {
              i = m;
              if (cef()) {
                if (paramString.ccF().CellSetList != null) {
                  break label474;
                }
              }
            }
          }
        }
        label474:
        for (i = 0;; i = paramString.ccF().CellSetList.size())
        {
          this.paX.Bj(i);
          j = paramString.ccF().TopHotNum;
          k = paramString.ccF().RecentHotNum;
          ac.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onSceneEnd setSize:%d hotcount:%d recentHotCount:%d type:%d getSceneType:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i3), Integer.valueOf(paramString.mType) });
          if ((this.paX != null) && (this.paX.cbF() <= 0) && (cef()))
          {
            com.tencent.mm.plugin.emoji.a.a.a locala = this.paX;
            locala.Bh(j + locala.cbG());
            this.paX.Bi(k);
          }
          b(paramInt1, paramInt2, paramn);
          if (!cef()) {
            break;
          }
          if ((paramString.ccF() == null) || (paramString.ccF().CellSetList == null) || (paramString.ccF().CellSetList.size() <= 0)) {
            break label489;
          }
          paramInt1 = 0;
          while (paramInt1 < paramString.ccF().CellSetList.size())
          {
            com.tencent.mm.plugin.report.service.h.wUl.f(13223, new Object[] { Integer.valueOf(0), Integer.valueOf(((EmotionBannerSet)paramString.ccF().CellSetList.get(paramInt1)).ID), ((EmotionBannerSet)paramString.ccF().CellSetList.get(paramInt1)).Title, Integer.valueOf(0) });
            paramInt1 += 1;
          }
        }
        label489:
        if ((paramString.ccF().RecentHotNum <= 0) || (paramString.ccF().EmotionList == null) || (paramString.ccF().EmotionList.size() <= paramString.ccF().TopHotNum + paramString.ccF().RecentHotNum)) {
          break;
        }
        paramInt1 = 0;
        while (paramInt1 < paramString.ccF().RecentHotNum)
        {
          com.tencent.mm.plugin.report.service.h.wUl.f(13223, new Object[] { Integer.valueOf(0), ((EmotionSummary)paramString.ccF().EmotionList.get(paramString.ccF().TopHotNum + paramInt1)).ProductID, ((EmotionSummary)paramString.ccF().EmotionList.get(paramString.ccF().TopHotNum + paramInt1)).PackName, Integer.valueOf(1) });
          paramInt1 += 1;
        }
      }
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1)) {
      if ((this.pdE == 0) || (this.kOL)) {
        ac.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "No More List.");
      }
    }
    while (paramInt != 0)
    {
      return;
      kl(true);
      ac.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[onScrollStateChanged] startLoadRemoteEmoji.");
    }
    cea();
  }
  
  public void onStart()
  {
    super.onStart();
    ac.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onStart");
  }
  
  public void onStop()
  {
    super.onStop();
    ac.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onStop");
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    ac.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "setUserVisibleHint :%b", new Object[] { Boolean.valueOf(paramBoolean) });
    super.setUserVisibleHint(paramBoolean);
    this.piJ = paramBoolean;
    if ((!this.piK) && (this.piL)) {
      cdZ();
    }
    while (!paramBoolean) {
      return;
    }
    cea();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2BaseFragment
 * JD-Core Version:    0.7.0.1
 */