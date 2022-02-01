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
import com.tencent.mm.g.a.dm;
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
import com.tencent.mm.protocal.protobuf.cna;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.emotion.s;
import com.tencent.mm.ui.MMFragment;
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
  implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener, com.tencent.mm.ak.f, h.a, com.tencent.mm.plugin.emoji.model.j.a, j.b, com.tencent.mm.pluginsdk.model.j.a, k.a, MMPullDownView.c, MMPullDownView.d, MMPullDownView.e
{
  private View GG;
  private aq gNm = new aq()
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
        if (localEmojiStoreV2BaseFragment.pLl != null)
        {
          localEmojiStoreV2BaseFragment.pLl.notifyDataSetChanged();
          AppMethodBeat.o(109135);
          return;
          if ((localEmojiStoreV2BaseFragment.pLl == null) || (paramAnonymousMessage.getData() == null))
          {
            AppMethodBeat.o(109135);
            return;
          }
          String str = paramAnonymousMessage.getData().getString("product_id");
          if (str != null)
          {
            int i = paramAnonymousMessage.getData().getInt("progress");
            localEmojiStoreV2BaseFragment.pLl.cX(str, i);
            AppMethodBeat.o(109135);
            return;
            if ((localEmojiStoreV2BaseFragment.pLl == null) || (paramAnonymousMessage.getData() == null))
            {
              AppMethodBeat.o(109135);
              return;
            }
            str = paramAnonymousMessage.getData().getString("product_id");
            if (str != null)
            {
              i = paramAnonymousMessage.getData().getInt("status");
              localEmojiStoreV2BaseFragment.pLl.cW(str, i);
              AppMethodBeat.o(109135);
              return;
              if (localEmojiStoreV2BaseFragment.pNE != null) {
                localEmojiStoreV2BaseFragment.pNE.cjM();
              }
            }
          }
        }
      }
    }
  };
  private ProgressDialog jbE;
  private boolean lpM;
  private ActionBar mActionBar;
  private com.tencent.mm.ui.a mActionBarHelper;
  protected ListView mListView;
  protected long nLI;
  com.tencent.mm.plugin.emoji.a.a.a pLl;
  protected com.tencent.mm.g.b.a.z pLv = new com.tencent.mm.g.b.a.z();
  EmojiStoreVpHeader pNE;
  private MMPullDownView pNH;
  private TextView pNI;
  private int pNK = -1;
  private View pNL;
  private byte[] pNM;
  private final int pNQ = 131074;
  private final int pNR = 131075;
  private final int pNS = 131076;
  private final String pNT = "product_id";
  private final String pNU = "progress";
  private final String pNV = "status";
  private com.tencent.mm.plugin.emoji.f.n pNW;
  private int pNX;
  private com.tencent.mm.plugin.emoji.model.f pNY;
  private j pNZ;
  private com.tencent.mm.sdk.b.c pOb = new com.tencent.mm.sdk.b.c() {};
  private com.tencent.mm.plugin.emoji.f.g pOc;
  private boolean pOd = false;
  private LinkedList<EmotionBanner> pOe = new LinkedList();
  private LinkedList<EmotionBannerSet> pOf = new LinkedList();
  private final int pSM = 131077;
  public EmojiStoreV2HotBarView pSN;
  private boolean pSO = false;
  private boolean pSP = false;
  private boolean pSQ = false;
  private MenuItem.OnMenuItemClickListener pSR = new EmojiStoreV2BaseFragment.4(this);
  
  private void L(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.pNY != null) && (paramBoolean1))
    {
      if (paramBoolean2) {
        cjX();
      }
      if (this.pLl != null) {
        this.pLl.b(this.pNY);
      }
    }
  }
  
  private void a(int paramInt, com.tencent.mm.plugin.emoji.model.f paramf)
  {
    ae.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "");
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
      if (this.pNY != null) {
        this.pNY.cia();
      }
      L(bool2, bool1);
      return;
      this.pNY = paramf;
      bool1 = true;
      bool2 = true;
      continue;
      this.pNY = paramf;
      bool1 = false;
      bool2 = true;
      continue;
      this.pNY = paramf;
      bool1 = false;
      bool2 = false;
      continue;
      if (this.pNY == null) {
        this.pNY = new com.tencent.mm.plugin.emoji.model.f();
      }
      this.pNY.Cm(paramf.pKM);
      this.pNY.cR(paramf.pKN);
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
      ae.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "item is null.");
      return;
    }
    if (paramf.pIy == f.a.pIH)
    {
      paramf = paramf.pIA;
      if (paramf == null)
      {
        ae.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "banner set is null. do nothing");
        return;
      }
      com.tencent.mm.plugin.emoji.e.k.a(getContext(), paramf, false);
      return;
    }
    EmotionSummary localEmotionSummary = paramf.pIz;
    if (localEmotionSummary == null)
    {
      ae.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "summary is null. do nothing");
      return;
    }
    int i = k;
    if (cjY())
    {
      i = k;
      if (d.chY().pKH) {
        i = 1;
      }
    }
    this.pLv.hc(String.valueOf(paramInt + 1));
    this.pLv.ha(localEmotionSummary.ProductID);
    com.tencent.mm.g.b.a.z localz = this.pLv;
    String str;
    if (i != 0)
    {
      str = localEmotionSummary.ExptDesc;
      localz.hb(str);
      this.pLv.dVT = 3;
      this.pLv.aLH();
      if (!cjY()) {
        break label283;
      }
      if ((paramInt < 0) || (paramInt >= this.pLl.chy())) {
        break label241;
      }
      i = 3;
    }
    for (;;)
    {
      str = thisActivity().getIntent().getStringExtra("to_talker_name");
      com.tencent.mm.plugin.emoji.e.k.a(getContext(), localEmotionSummary, i, paramf.mStatus, paramf.Hx, str, 5, this.pLv);
      return;
      str = localEmotionSummary.Introduce;
      break;
      label241:
      i = j;
      if (paramInt >= this.pLl.chy())
      {
        i = j;
        if (paramInt < this.pLl.chz() + this.pLl.chy())
        {
          i = 19;
          continue;
          label283:
          i = 2;
        }
      }
    }
  }
  
  private void aZ(byte[] paramArrayOfByte)
  {
    int i = ciS();
    int j = this.pNX;
    if (paramArrayOfByte != null)
    {
      ae.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[refreshNetSceneGetEmotionList] request buffer %s", new Object[] { paramArrayOfByte.toString() });
      this.pNW = new com.tencent.mm.plugin.emoji.f.n(i, paramArrayOfByte, j);
      return;
    }
    ae.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[refreshNetSceneGetEmotionList] request buffer is null.");
    this.pNW = new com.tencent.mm.plugin.emoji.f.n(i, j);
  }
  
  private void acR(String paramString)
  {
    if (isFinishing())
    {
      ae.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[showLoadingDialog] acitivity is finished.");
      return;
    }
    FragmentActivity localFragmentActivity = thisActivity();
    getString(2131755906);
    this.jbE = com.tencent.mm.ui.base.h.b(localFragmentActivity, paramString, true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
  }
  
  private void ciR()
  {
    com.tencent.mm.plugin.emoji.a.a.b.a(this.pLl.pIn, this);
  }
  
  private void ciU()
  {
    com.tencent.mm.kernel.g.ajQ().gDv.a(this.pNW, 0);
  }
  
  private void cjS()
  {
    this.pSP = true;
    this.nLI = System.currentTimeMillis();
    cna localcna = new cna();
    localcna.Hzb = this.nLI;
    this.pLv.dVR = this.nLI;
    ae.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "initeData: %s", new Object[] { Long.valueOf(localcna.Hzb) });
    try
    {
      this.pNM = localcna.toByteArray();
      cjU();
      this.pNX = thisActivity().getIntent().getIntExtra("preceding_scence", 5);
      if ((cjV()) && (this.gNm != null))
      {
        this.gNm.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(109140);
            EmojiStoreV2BaseFragment.this.ku(false);
            AppMethodBeat.o(109140);
          }
        }, 3000L);
        ar.o(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(109141);
            EmojiStoreV2BaseFragment.this.cjT();
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
        ae.printErrStackTrace("MicroMsg.emoji.EmojiStoreV2BaseFragment", localIOException, "", new Object[0]);
        continue;
        ku(true);
      }
    }
  }
  
  private void cjU()
  {
    this.pNZ = new j();
    this.pNZ.nnh = thisActivity();
    this.pNZ.pLn = this;
    this.pNZ.pLl = this.pLl;
    if (cjY()) {}
    for (this.pNZ.pLo = 1;; this.pNZ.pLo = 2)
    {
      this.pNZ.pLr = this;
      return;
    }
  }
  
  private boolean cjV()
  {
    boolean bool2 = false;
    GetEmotionListResponse localGetEmotionListResponse = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().JfX.abP(ciS());
    com.tencent.mm.plugin.emoji.model.f localf = com.tencent.mm.plugin.emoji.f.n.b(localGetEmotionListResponse);
    int j = ciS();
    int i;
    boolean bool1;
    label136:
    int k;
    if (localGetEmotionListResponse == null)
    {
      i = 0;
      ae.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "load cache type: %d, size: %d ", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      bool1 = bool2;
      if (localf != null)
      {
        bool1 = bool2;
        if (localf.pKN.size() > 0)
        {
          this.pOd = true;
          this.GG.setVisibility(8);
          this.pNH.setVisibility(0);
          a(this.pNK, localf);
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
      ae.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "load cache hotcount:%d type:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(ciS()) });
      if ((this.pLl != null) && (cjY()))
      {
        this.pLl.Cb(i + k);
        this.pLl.Cc(j);
      }
      ciR();
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
  
  private static boolean cjW()
  {
    ((Long)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IKO, Long.valueOf(0L))).longValue();
    return true;
  }
  
  private void cjX()
  {
    if (this.pNY == null) {
      ae.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "update store ui header failed. ");
    }
    do
    {
      return;
      this.pOe = ((LinkedList)this.pNY.pKP);
      this.pOf = ((LinkedList)this.pNY.pKQ);
      if (this.pOe != null)
      {
        this.pNE.d(this.pOe, this.pOf);
        return;
      }
    } while (this.pNY.pKO == null);
    this.pOe = new LinkedList();
    this.pOe.add(this.pNY.pKO);
    this.pNE.d(this.pOe, this.pOf);
  }
  
  private void e(final GetEmotionListResponse paramGetEmotionListResponse)
  {
    if (this.pNK == -1) {
      com.tencent.mm.kernel.g.ajU().aw(new Runnable()
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
            ae.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "jacks save EmoijStoreUI Cache: list:%d, size: %d, type: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(EmojiStoreV2BaseFragment.this.ciS()) });
            com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().JfX.a(EmojiStoreV2BaseFragment.this.ciS(), paramGetEmotionListResponse);
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
  
  private void kv(boolean paramBoolean)
  {
    if (this.lpM) {
      ae.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "isLoading");
    }
    do
    {
      return;
      this.lpM = true;
      if (paramBoolean) {
        this.pNL.setVisibility(0);
      }
      aZ(this.pNM);
      ciU();
      ae.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[startLoadRemoteEmoji] doScene GetEmotionListNetScene");
    } while (paramBoolean);
    acR(getString(2131755936));
  }
  
  public final void Cg(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= ((com.tencent.mm.plugin.emoji.a.h)this.pLl).chC())) {
      return;
    }
    a(this.pLl.Ce(paramInt), paramInt);
  }
  
  public final void R(ArrayList<p> paramArrayList)
  {
    ae.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "google [onQueryFinish]");
    if (this.pLl == null) {
      return;
    }
    if (this.gNm != null) {
      this.gNm.sendEmptyMessageDelayed(131074, 50L);
    }
    com.tencent.mm.plugin.emoji.a.a.b.a(paramArrayList, this.pLl.pIn);
  }
  
  public final void a(com.tencent.mm.plugin.emoji.a.a parama)
  {
    if (parama.chq() == 9) {
      acR(getString(2131755913));
    }
    this.pNZ.pLv = this.pLv;
    j localj = this.pNZ;
    boolean bool;
    if ((cjY()) && (d.chY().pKH))
    {
      bool = true;
      localj.pLw = bool;
      if (!cjY()) {
        break label168;
      }
      if ((parama.mPosition < 0) || (parama.mPosition >= this.pLl.chy())) {
        break label109;
      }
      this.pNZ.pLo = 3;
    }
    label168:
    for (;;)
    {
      this.pNZ.a(parama);
      return;
      bool = false;
      break;
      label109:
      if ((parama.mPosition >= this.pLl.chy()) && (parama.mPosition < this.pLl.chz() + this.pLl.chy()))
      {
        this.pNZ.pLo = 19;
      }
      else
      {
        this.pNZ.pLo = 1;
        continue;
        this.pNZ.pLo = 2;
      }
    }
  }
  
  public final void a(String paramString, m paramm)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals("delete_group")) && (this.gNm != null)) {
      this.gNm.sendEmptyMessageDelayed(131074, 50L);
    }
  }
  
  protected void b(int paramInt1, int paramInt2, com.tencent.mm.ak.n paramn)
  {
    this.lpM = false;
    this.pNL.setVisibility(8);
    if ((paramInt1 == 0) || (paramInt1 == 4))
    {
      paramInt1 = 1;
      if (paramInt1 == 0) {
        break label192;
      }
      this.GG.setVisibility(8);
      this.pNH.setVisibility(0);
      localObject = (com.tencent.mm.plugin.emoji.f.n)paramn;
      paramn = com.tencent.mm.plugin.emoji.f.n.b(((com.tencent.mm.plugin.emoji.f.n)localObject).ciz());
      this.pNM = ((com.tencent.mm.plugin.emoji.f.n)localObject).pME;
      if (paramInt2 != 0) {
        break label107;
      }
      localObject = ((com.tencent.mm.plugin.emoji.f.n)localObject).ciz();
      a(this.pNK, paramn);
      e((GetEmotionListResponse)localObject);
      this.pNK = 0;
    }
    label107:
    while (this.pOd)
    {
      Object localObject;
      return;
      paramInt1 = 0;
      break;
      if (paramInt2 == 2)
      {
        localObject = ((com.tencent.mm.plugin.emoji.f.n)localObject).ciz();
        a(this.pNK, paramn);
        ciR();
        e((GetEmotionListResponse)localObject);
        this.pNK = 2;
        return;
      }
      if (paramInt2 == 3)
      {
        a(this.pNK, paramn);
        this.pNK = 1;
        return;
      }
      this.GG.setVisibility(0);
      this.pNH.setVisibility(8);
      this.pNI.setText(2131758330);
      return;
    }
    label192:
    this.GG.setVisibility(0);
    this.pNH.setVisibility(8);
    this.pNI.setText(2131758331);
  }
  
  public final boolean ccp()
  {
    ae.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[onBottomLoadData] startLoadRemoteEmoji.");
    kv(true);
    return true;
  }
  
  public final boolean ccq()
  {
    return false;
  }
  
  public final boolean ccr()
  {
    return false;
  }
  
  public abstract com.tencent.mm.plugin.emoji.a.a.a ciL();
  
  public abstract int ciS();
  
  public final void cic()
  {
    this.pNM = null;
    this.pNK = -1;
    kv(false);
  }
  
  protected void cjT() {}
  
  public abstract boolean cjY();
  
  public final void cjZ()
  {
    if ((this.mListView != null) && (this.pLl != null) && (cjY())) {
      this.pLl.refreshView();
    }
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public final void k(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.pOc = new com.tencent.mm.plugin.emoji.f.g(paramString1, paramString2, paramString3);
    com.tencent.mm.kernel.g.ajQ().gDv.a(this.pOc, 0);
  }
  
  public final void ku(boolean paramBoolean)
  {
    ae.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "loadNetWork force:%b isNeedToRefresh:%b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(cjW()) });
    if (!paramBoolean) {
      cjW();
    }
    aZ(this.pNM);
    ciU();
  }
  
  public final void n(Message paramMessage)
  {
    if (this.gNm != null) {
      this.gNm.sendMessage(paramMessage);
    }
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    ae.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onActivityCreated");
    super.onActivityCreated(paramBundle);
    this.pSQ = true;
    this.pLl = ciL();
    this.pLl.pIo = this;
    this.GG = findViewById(2131299457);
    this.pNI = ((TextView)this.GG.findViewById(2131299461));
    this.pNL = getActivityLayoutInflater().inflate(2131493799, null);
    this.pNL.setVisibility(8);
    this.pNE = new EmojiStoreVpHeader(getContext());
    this.mListView = ((ListView)findViewById(16908298));
    this.mListView.addHeaderView(this.pNE);
    if (!cjY())
    {
      this.pSN = new EmojiStoreV2HotBarView(getContext());
      this.pSN.setDesignerEmojiViewVisibility(8);
      this.pSN.setDesignerCatalogViewPadding(false);
      this.mListView.addHeaderView(this.pSN);
    }
    this.mListView.addFooterView(this.pNL);
    this.mListView.setAdapter(this.pLl);
    if (cjY()) {
      this.mListView.setOnItemClickListener(this);
    }
    for (;;)
    {
      this.mListView.setOnScrollListener(this);
      this.mListView.setLongClickable(false);
      this.mListView.setOnTouchListener(new EmojiStoreV2BaseFragment.7(this));
      this.pLl.pIm = this.mListView;
      this.pNH = ((MMPullDownView)findViewById(2131301487));
      if (this.pNH != null)
      {
        this.pNH.setTopViewVisible(false);
        this.pNH.setAtTopCallBack(this);
        this.pNH.setOnBottomLoadDataListener(this);
        this.pNH.setAtBottomCallBack(this);
        this.pNH.setBottomViewVisible(false);
        this.pNH.setIsBottomShowAll(false);
        this.pNH.setIsReturnSuperDispatchWhenCancel(true);
      }
      if (this.pSO) {
        cjS();
      }
      return;
      ((com.tencent.mm.plugin.emoji.a.h)this.pLl).pHW = this;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    ae.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onActivityResult . requestCode:" + paramInt1 + "  resultCode:" + paramInt2);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.pNZ != null)
    {
      this.pNZ.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
    }
    ae.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "mPayOrDownloadComponent have no init.");
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    ae.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onAttach");
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.pNE != null) {
      this.pNE.requestLayout();
    }
    setRequestedOrientation(1);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setRequestedOrientation(1);
    this.mActionBar = ((AppCompatActivity)thisActivity()).getSupportActionBar();
    paramBundle = com.tencent.mm.ui.z.jV(getContext()).inflate(2131492921, null);
    this.mActionBarHelper = new com.tencent.mm.ui.a(paramBundle);
    this.mActionBar.setLogo(new ColorDrawable(getResources().getColor(17170445)));
    this.mActionBar.gm();
    this.mActionBar.setDisplayHomeAsUpEnabled(false);
    this.mActionBar.gl();
    this.mActionBar.gn();
    this.mActionBar.setCustomView(paramBundle);
    this.mActionBar.show();
    paramBundle = this.mActionBarHelper;
    paramBundle.iYj.setText(2131758307);
    if (com.tencent.mm.cb.a.ir(paramBundle.iYj.getContext()))
    {
      TextView localTextView = paramBundle.iYj;
      float f = com.tencent.mm.cb.a.ay(paramBundle.iYj.getContext(), 2131165184);
      localTextView.setTextSize(0, com.tencent.mm.cb.a.ip(paramBundle.iYj.getContext()) * f);
    }
    this.mActionBarHelper.setClickListener(new EmojiStoreV2BaseFragment.5(this));
    showOptionMenu(true);
    addIconOptionMenu(0, 2131689511, new EmojiStoreV2BaseFragment.6(this));
    com.tencent.mm.sdk.b.a.IvT.c(this.pOb);
    com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().JfV.add(this);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    ae.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onCreateView");
    return paramLayoutInflater.inflate(getLayoutId(), paramViewGroup, false);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ae.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onDestroy");
    if (this.pLl != null)
    {
      this.pLl.clear();
      this.pLl = null;
    }
    if (this.pNE != null)
    {
      this.pNE.cjN();
      this.pNE.clear();
    }
    com.tencent.mm.sdk.b.a.IvT.d(this.pOb);
    com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().JfV.remove(this);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    ae.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onResume");
  }
  
  public void onDetach()
  {
    super.onDetach();
    ae.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onDetach");
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramAdapterView);
    localb.bd(paramView);
    localb.mu(paramInt);
    localb.rl(paramLong);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2BaseFragment", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
    paramInt -= this.mListView.getHeaderViewsCount();
    if ((paramInt < 0) || (paramInt >= this.pLl.getCount()))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2BaseFragment", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      return;
    }
    paramAdapterView = this.pLl.Ce(paramInt);
    a(paramAdapterView, paramInt);
    if ((cjY()) && (this.pLl.chz() > 0) && (paramInt >= this.pLl.chy()) && (paramInt < this.pLl.chy() + this.pLl.chz()) && (paramAdapterView.pIz != null)) {
      com.tencent.mm.plugin.report.service.g.yxI.f(13223, new Object[] { Integer.valueOf(1), paramAdapterView.pIz.ProductID, paramAdapterView.pIz.PackName, Integer.valueOf(1), Integer.valueOf(0) });
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2BaseFragment", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
  }
  
  public void onPause()
  {
    super.onPause();
    com.tencent.mm.kernel.g.ajQ().gDv.b(411, this);
    com.tencent.mm.kernel.g.ajQ().gDv.b(423, this);
    ae.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onPause");
    if (this.pNE != null) {
      this.pNE.cjN();
    }
    if (this.gNm != null) {
      this.gNm.removeMessages(131077);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    ae.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onResume");
    com.tencent.mm.kernel.g.ajQ().gDv.a(411, this);
    com.tencent.mm.kernel.g.ajQ().gDv.a(423, this);
    if (this.pSO)
    {
      if (this.gNm != null) {
        this.gNm.sendEmptyMessageDelayed(131077, 4000L);
      }
      if ((this.pLl != null) && (this.pLl.pIn != null))
      {
        this.pLl.pIn.chE();
        this.pLl.refreshView();
      }
      if (((Boolean)com.tencent.mm.kernel.g.ajR().ajA().get(208900, Boolean.FALSE)).booleanValue())
      {
        cic();
        com.tencent.mm.kernel.g.ajR().ajA().set(208900, Boolean.FALSE);
      }
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    ae.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onSceneEnd errType:%d,errCode:%d,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((this.jbE != null) && (this.jbE.isShowing())) {
      this.jbE.dismiss();
    }
    int i3 = paramn.getType();
    switch (i3)
    {
    default: 
      ae.w("MicroMsg.emoji.EmojiStoreV2BaseFragment", "unknow scene type.");
      break;
      break;
    }
    for (;;)
    {
      return;
      if ((paramn instanceof com.tencent.mm.plugin.emoji.f.n))
      {
        paramString = (com.tencent.mm.plugin.emoji.f.n)paramn;
        if ((paramString == null) || (paramString.mType != ciS())) {
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
          if (paramString.ciz() != null)
          {
            i = m;
            if (this.pLl.chA() <= 0)
            {
              i = m;
              if (cjY()) {
                if (paramString.ciz().CellSetList != null) {
                  break label474;
                }
              }
            }
          }
        }
        label474:
        for (i = 0;; i = paramString.ciz().CellSetList.size())
        {
          this.pLl.Cd(i);
          j = paramString.ciz().TopHotNum;
          k = paramString.ciz().RecentHotNum;
          ae.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onSceneEnd setSize:%d hotcount:%d recentHotCount:%d type:%d getSceneType:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i3), Integer.valueOf(paramString.mType) });
          if ((this.pLl != null) && (this.pLl.chz() <= 0) && (cjY()))
          {
            com.tencent.mm.plugin.emoji.a.a.a locala = this.pLl;
            locala.Cb(j + locala.chA());
            this.pLl.Cc(k);
          }
          b(paramInt1, paramInt2, paramn);
          if (!cjY()) {
            break;
          }
          if ((paramString.ciz() == null) || (paramString.ciz().CellSetList == null) || (paramString.ciz().CellSetList.size() <= 0)) {
            break label489;
          }
          paramInt1 = 0;
          while (paramInt1 < paramString.ciz().CellSetList.size())
          {
            com.tencent.mm.plugin.report.service.g.yxI.f(13223, new Object[] { Integer.valueOf(0), Integer.valueOf(((EmotionBannerSet)paramString.ciz().CellSetList.get(paramInt1)).ID), ((EmotionBannerSet)paramString.ciz().CellSetList.get(paramInt1)).Title, Integer.valueOf(0) });
            paramInt1 += 1;
          }
        }
        label489:
        if ((paramString.ciz().RecentHotNum <= 0) || (paramString.ciz().EmotionList == null) || (paramString.ciz().EmotionList.size() <= paramString.ciz().TopHotNum + paramString.ciz().RecentHotNum)) {
          break;
        }
        paramInt1 = 0;
        while (paramInt1 < paramString.ciz().RecentHotNum)
        {
          com.tencent.mm.plugin.report.service.g.yxI.f(13223, new Object[] { Integer.valueOf(0), ((EmotionSummary)paramString.ciz().EmotionList.get(paramString.ciz().TopHotNum + paramInt1)).ProductID, ((EmotionSummary)paramString.ciz().EmotionList.get(paramString.ciz().TopHotNum + paramInt1)).PackName, Integer.valueOf(1) });
          paramInt1 += 1;
        }
      }
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1)) {
      if ((this.pNK == 0) || (this.lpM)) {
        ae.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "No More List.");
      }
    }
    while (paramInt != 0)
    {
      return;
      kv(true);
      ae.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[onScrollStateChanged] startLoadRemoteEmoji.");
    }
    cjT();
  }
  
  public void onStart()
  {
    super.onStart();
    ae.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onStart");
  }
  
  public void onStop()
  {
    super.onStop();
    ae.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onStop");
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    ae.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "setUserVisibleHint :%b", new Object[] { Boolean.valueOf(paramBoolean) });
    super.setUserVisibleHint(paramBoolean);
    this.pSO = paramBoolean;
    if ((!this.pSP) && (this.pSQ)) {
      cjS();
    }
    while (!paramBoolean) {
      return;
    }
    cjT();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2BaseFragment
 * JD-Core Version:    0.7.0.1
 */