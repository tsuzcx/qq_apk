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
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.dl;
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
import com.tencent.mm.protocal.protobuf.cmg;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.bd;
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
  implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener, com.tencent.mm.al.f, h.a, com.tencent.mm.plugin.emoji.model.j.a, j.b, com.tencent.mm.pluginsdk.model.j.a, k.a, MMPullDownView.c, MMPullDownView.d, MMPullDownView.e
{
  private View GG;
  private ap gKD = new ap()
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
        if (localEmojiStoreV2BaseFragment.pEH != null)
        {
          localEmojiStoreV2BaseFragment.pEH.notifyDataSetChanged();
          AppMethodBeat.o(109135);
          return;
          if ((localEmojiStoreV2BaseFragment.pEH == null) || (paramAnonymousMessage.getData() == null))
          {
            AppMethodBeat.o(109135);
            return;
          }
          String str = paramAnonymousMessage.getData().getString("product_id");
          if (str != null)
          {
            int i = paramAnonymousMessage.getData().getInt("progress");
            localEmojiStoreV2BaseFragment.pEH.cT(str, i);
            AppMethodBeat.o(109135);
            return;
            if ((localEmojiStoreV2BaseFragment.pEH == null) || (paramAnonymousMessage.getData() == null))
            {
              AppMethodBeat.o(109135);
              return;
            }
            str = paramAnonymousMessage.getData().getString("product_id");
            if (str != null)
            {
              i = paramAnonymousMessage.getData().getInt("status");
              localEmojiStoreV2BaseFragment.pEH.cS(str, i);
              AppMethodBeat.o(109135);
              return;
              if (localEmojiStoreV2BaseFragment.pHa != null) {
                localEmojiStoreV2BaseFragment.pHa.ciw();
              }
            }
          }
        }
      }
    }
  };
  private ProgressDialog iYL;
  private boolean llo;
  private ActionBar mActionBar;
  private com.tencent.mm.ui.a mActionBarHelper;
  protected ListView mListView;
  protected long nGh;
  com.tencent.mm.plugin.emoji.a.a.a pEH;
  protected com.tencent.mm.g.b.a.z pER = new com.tencent.mm.g.b.a.z();
  private LinkedList<EmotionBanner> pHA = new LinkedList();
  private LinkedList<EmotionBannerSet> pHB = new LinkedList();
  EmojiStoreVpHeader pHa;
  private MMPullDownView pHd;
  private TextView pHe;
  private int pHg = -1;
  private View pHh;
  private byte[] pHi;
  private final int pHm = 131074;
  private final int pHn = 131075;
  private final int pHo = 131076;
  private final String pHp = "product_id";
  private final String pHq = "progress";
  private final String pHr = "status";
  private com.tencent.mm.plugin.emoji.f.n pHs;
  private int pHt;
  private com.tencent.mm.plugin.emoji.model.f pHu;
  private j pHv;
  private com.tencent.mm.sdk.b.c pHx = new com.tencent.mm.sdk.b.c() {};
  private com.tencent.mm.plugin.emoji.f.g pHy;
  private boolean pHz = false;
  private final int pMh = 131077;
  public EmojiStoreV2HotBarView pMi;
  private boolean pMj = false;
  private boolean pMk = false;
  private boolean pMl = false;
  private MenuItem.OnMenuItemClickListener pMm = new EmojiStoreV2BaseFragment.4(this);
  
  private void M(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.pHu != null) && (paramBoolean1))
    {
      if (paramBoolean2) {
        ciH();
      }
      if (this.pEH != null) {
        this.pEH.b(this.pHu);
      }
    }
  }
  
  private void a(int paramInt, com.tencent.mm.plugin.emoji.model.f paramf)
  {
    ad.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "");
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
      if (this.pHu != null) {
        this.pHu.cgK();
      }
      M(bool2, bool1);
      return;
      this.pHu = paramf;
      bool1 = true;
      bool2 = true;
      continue;
      this.pHu = paramf;
      bool1 = false;
      bool2 = true;
      continue;
      this.pHu = paramf;
      bool1 = false;
      bool2 = false;
      continue;
      if (this.pHu == null) {
        this.pHu = new com.tencent.mm.plugin.emoji.model.f();
      }
      this.pHu.Ca(paramf.pEi);
      this.pHu.cO(paramf.pEj);
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
      ad.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "item is null.");
      return;
    }
    if (paramf.pBU == f.a.pCd)
    {
      paramf = paramf.pBW;
      if (paramf == null)
      {
        ad.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "banner set is null. do nothing");
        return;
      }
      com.tencent.mm.plugin.emoji.e.k.a(getContext(), paramf, false);
      return;
    }
    EmotionSummary localEmotionSummary = paramf.pBV;
    if (localEmotionSummary == null)
    {
      ad.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "summary is null. do nothing");
      return;
    }
    int i = k;
    if (ciI())
    {
      i = k;
      if (d.cgI().pEd) {
        i = 1;
      }
    }
    this.pER.gW(String.valueOf(paramInt + 1));
    this.pER.gU(localEmotionSummary.ProductID);
    com.tencent.mm.g.b.a.z localz = this.pER;
    String str;
    if (i != 0)
    {
      str = localEmotionSummary.ExptDesc;
      localz.gV(str);
      this.pER.dUD = 3;
      this.pER.aLk();
      if (!ciI()) {
        break label283;
      }
      if ((paramInt < 0) || (paramInt >= this.pEH.cgi())) {
        break label241;
      }
      i = 3;
    }
    for (;;)
    {
      str = thisActivity().getIntent().getStringExtra("to_talker_name");
      com.tencent.mm.plugin.emoji.e.k.a(getContext(), localEmotionSummary, i, paramf.mStatus, paramf.Hx, str, 5, this.pER);
      return;
      str = localEmotionSummary.Introduce;
      break;
      label241:
      i = j;
      if (paramInt >= this.pEH.cgi())
      {
        i = j;
        if (paramInt < this.pEH.cgj() + this.pEH.cgi())
        {
          i = 19;
          continue;
          label283:
          i = 2;
        }
      }
    }
  }
  
  private void aca(String paramString)
  {
    if (isFinishing())
    {
      ad.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[showLoadingDialog] acitivity is finished.");
      return;
    }
    FragmentActivity localFragmentActivity = thisActivity();
    getString(2131755906);
    this.iYL = com.tencent.mm.ui.base.h.b(localFragmentActivity, paramString, true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
  }
  
  private void ba(byte[] paramArrayOfByte)
  {
    int i = chC();
    int j = this.pHt;
    if (paramArrayOfByte != null)
    {
      ad.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[refreshNetSceneGetEmotionList] request buffer %s", new Object[] { paramArrayOfByte.toString() });
      this.pHs = new com.tencent.mm.plugin.emoji.f.n(i, paramArrayOfByte, j);
      return;
    }
    ad.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[refreshNetSceneGetEmotionList] request buffer is null.");
    this.pHs = new com.tencent.mm.plugin.emoji.f.n(i, j);
  }
  
  private void chB()
  {
    com.tencent.mm.plugin.emoji.a.a.b.a(this.pEH.pBJ, this);
  }
  
  private void chE()
  {
    com.tencent.mm.kernel.g.ajB().gAO.a(this.pHs, 0);
  }
  
  private void ciC()
  {
    this.pMk = true;
    this.nGh = System.currentTimeMillis();
    cmg localcmg = new cmg();
    localcmg.HfB = this.nGh;
    this.pER.dUB = this.nGh;
    ad.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "initeData: %s", new Object[] { Long.valueOf(localcmg.HfB) });
    try
    {
      this.pHi = localcmg.toByteArray();
      ciE();
      this.pHt = thisActivity().getIntent().getIntExtra("preceding_scence", 5);
      if ((ciF()) && (this.gKD != null))
      {
        this.gKD.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(109140);
            EmojiStoreV2BaseFragment.this.kv(false);
            AppMethodBeat.o(109140);
          }
        }, 3000L);
        aq.o(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(109141);
            EmojiStoreV2BaseFragment.this.ciD();
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
        ad.printErrStackTrace("MicroMsg.emoji.EmojiStoreV2BaseFragment", localIOException, "", new Object[0]);
        continue;
        kv(true);
      }
    }
  }
  
  private void ciE()
  {
    this.pHv = new j();
    this.pHv.nhZ = thisActivity();
    this.pHv.pEJ = this;
    this.pHv.pEH = this.pEH;
    if (ciI()) {}
    for (this.pHv.pEK = 1;; this.pHv.pEK = 2)
    {
      this.pHv.pEN = this;
      return;
    }
  }
  
  private boolean ciF()
  {
    boolean bool2 = false;
    GetEmotionListResponse localGetEmotionListResponse = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().ILq.abh(chC());
    com.tencent.mm.plugin.emoji.model.f localf = com.tencent.mm.plugin.emoji.f.n.b(localGetEmotionListResponse);
    int j = chC();
    int i;
    boolean bool1;
    label136:
    int k;
    if (localGetEmotionListResponse == null)
    {
      i = 0;
      ad.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "load cache type: %d, size: %d ", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      bool1 = bool2;
      if (localf != null)
      {
        bool1 = bool2;
        if (localf.pEj.size() > 0)
        {
          this.pHz = true;
          this.GG.setVisibility(8);
          this.pHd.setVisibility(0);
          a(this.pHg, localf);
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
      ad.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "load cache hotcount:%d type:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(chC()) });
      if ((this.pEH != null) && (ciI()))
      {
        this.pEH.BP(i + k);
        this.pEH.BQ(j);
      }
      chB();
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
  
  private static boolean ciG()
  {
    ((Long)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Iqs, Long.valueOf(0L))).longValue();
    return true;
  }
  
  private void ciH()
  {
    if (this.pHu == null) {
      ad.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "update store ui header failed. ");
    }
    do
    {
      return;
      this.pHA = ((LinkedList)this.pHu.pEl);
      this.pHB = ((LinkedList)this.pHu.pEm);
      if (this.pHA != null)
      {
        this.pHa.d(this.pHA, this.pHB);
        return;
      }
    } while (this.pHu.pEk == null);
    this.pHA = new LinkedList();
    this.pHA.add(this.pHu.pEk);
    this.pHa.d(this.pHA, this.pHB);
  }
  
  private void e(final GetEmotionListResponse paramGetEmotionListResponse)
  {
    if (this.pHg == -1) {
      com.tencent.mm.kernel.g.ajF().ay(new Runnable()
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
            ad.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "jacks save EmoijStoreUI Cache: list:%d, size: %d, type: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(EmojiStoreV2BaseFragment.this.chC()) });
            com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().ILq.a(EmojiStoreV2BaseFragment.this.chC(), paramGetEmotionListResponse);
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
  
  private void kw(boolean paramBoolean)
  {
    if (this.llo) {
      ad.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "isLoading");
    }
    do
    {
      return;
      this.llo = true;
      if (paramBoolean) {
        this.pHh.setVisibility(0);
      }
      ba(this.pHi);
      chE();
      ad.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[startLoadRemoteEmoji] doScene GetEmotionListNetScene");
    } while (paramBoolean);
    aca(getString(2131755936));
  }
  
  public final void BU(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= ((com.tencent.mm.plugin.emoji.a.h)this.pEH).cgm())) {
      return;
    }
    a(this.pEH.BS(paramInt), paramInt);
  }
  
  public final void R(ArrayList<p> paramArrayList)
  {
    ad.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "google [onQueryFinish]");
    if (this.pEH == null) {
      return;
    }
    if (this.gKD != null) {
      this.gKD.sendEmptyMessageDelayed(131074, 50L);
    }
    com.tencent.mm.plugin.emoji.a.a.b.a(paramArrayList, this.pEH.pBJ);
  }
  
  public final void a(com.tencent.mm.plugin.emoji.a.a parama)
  {
    if (parama.cga() == 9) {
      aca(getString(2131755913));
    }
    this.pHv.pER = this.pER;
    j localj = this.pHv;
    boolean bool;
    if ((ciI()) && (d.cgI().pEd))
    {
      bool = true;
      localj.pES = bool;
      if (!ciI()) {
        break label168;
      }
      if ((parama.mPosition < 0) || (parama.mPosition >= this.pEH.cgi())) {
        break label109;
      }
      this.pHv.pEK = 3;
    }
    label168:
    for (;;)
    {
      this.pHv.a(parama);
      return;
      bool = false;
      break;
      label109:
      if ((parama.mPosition >= this.pEH.cgi()) && (parama.mPosition < this.pEH.cgj() + this.pEH.cgi()))
      {
        this.pHv.pEK = 19;
      }
      else
      {
        this.pHv.pEK = 1;
        continue;
        this.pHv.pEK = 2;
      }
    }
  }
  
  public final void a(String paramString, m paramm)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals("delete_group")) && (this.gKD != null)) {
      this.gKD.sendEmptyMessageDelayed(131074, 50L);
    }
  }
  
  protected void b(int paramInt1, int paramInt2, com.tencent.mm.al.n paramn)
  {
    this.llo = false;
    this.pHh.setVisibility(8);
    if ((paramInt1 == 0) || (paramInt1 == 4))
    {
      paramInt1 = 1;
      if (paramInt1 == 0) {
        break label192;
      }
      this.GG.setVisibility(8);
      this.pHd.setVisibility(0);
      localObject = (com.tencent.mm.plugin.emoji.f.n)paramn;
      paramn = com.tencent.mm.plugin.emoji.f.n.b(((com.tencent.mm.plugin.emoji.f.n)localObject).chj());
      this.pHi = ((com.tencent.mm.plugin.emoji.f.n)localObject).pGa;
      if (paramInt2 != 0) {
        break label107;
      }
      localObject = ((com.tencent.mm.plugin.emoji.f.n)localObject).chj();
      a(this.pHg, paramn);
      e((GetEmotionListResponse)localObject);
      this.pHg = 0;
    }
    label107:
    while (this.pHz)
    {
      Object localObject;
      return;
      paramInt1 = 0;
      break;
      if (paramInt2 == 2)
      {
        localObject = ((com.tencent.mm.plugin.emoji.f.n)localObject).chj();
        a(this.pHg, paramn);
        chB();
        e((GetEmotionListResponse)localObject);
        this.pHg = 2;
        return;
      }
      if (paramInt2 == 3)
      {
        a(this.pHg, paramn);
        this.pHg = 1;
        return;
      }
      this.GG.setVisibility(0);
      this.pHd.setVisibility(8);
      this.pHe.setText(2131758330);
      return;
    }
    label192:
    this.GG.setVisibility(0);
    this.pHd.setVisibility(8);
    this.pHe.setText(2131758331);
  }
  
  public final boolean cba()
  {
    ad.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[onBottomLoadData] startLoadRemoteEmoji.");
    kw(true);
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
    kw(false);
  }
  
  public abstract int chC();
  
  public abstract com.tencent.mm.plugin.emoji.a.a.a chv();
  
  protected void ciD() {}
  
  public abstract boolean ciI();
  
  public final void ciJ()
  {
    if ((this.mListView != null) && (this.pEH != null) && (ciI())) {
      this.pEH.refreshView();
    }
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public final void k(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.pHy = new com.tencent.mm.plugin.emoji.f.g(paramString1, paramString2, paramString3);
    com.tencent.mm.kernel.g.ajB().gAO.a(this.pHy, 0);
  }
  
  public final void kv(boolean paramBoolean)
  {
    ad.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "loadNetWork force:%b isNeedToRefresh:%b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(ciG()) });
    if (!paramBoolean) {
      ciG();
    }
    ba(this.pHi);
    chE();
  }
  
  public final void n(Message paramMessage)
  {
    if (this.gKD != null) {
      this.gKD.sendMessage(paramMessage);
    }
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    ad.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onActivityCreated");
    super.onActivityCreated(paramBundle);
    this.pMl = true;
    this.pEH = chv();
    this.pEH.pBK = this;
    this.GG = findViewById(2131299457);
    this.pHe = ((TextView)this.GG.findViewById(2131299461));
    this.pHh = getActivityLayoutInflater().inflate(2131493799, null);
    this.pHh.setVisibility(8);
    this.pHa = new EmojiStoreVpHeader(getContext());
    this.mListView = ((ListView)findViewById(16908298));
    this.mListView.addHeaderView(this.pHa);
    if (!ciI())
    {
      this.pMi = new EmojiStoreV2HotBarView(getContext());
      this.pMi.setDesignerEmojiViewVisibility(8);
      this.pMi.setDesignerCatalogViewPadding(false);
      this.mListView.addHeaderView(this.pMi);
    }
    this.mListView.addFooterView(this.pHh);
    this.mListView.setAdapter(this.pEH);
    if (ciI()) {
      this.mListView.setOnItemClickListener(this);
    }
    for (;;)
    {
      this.mListView.setOnScrollListener(this);
      this.mListView.setLongClickable(false);
      this.mListView.setOnTouchListener(new EmojiStoreV2BaseFragment.7(this));
      this.pEH.pBI = this.mListView;
      this.pHd = ((MMPullDownView)findViewById(2131301487));
      if (this.pHd != null)
      {
        this.pHd.setTopViewVisible(false);
        this.pHd.setAtTopCallBack(this);
        this.pHd.setOnBottomLoadDataListener(this);
        this.pHd.setAtBottomCallBack(this);
        this.pHd.setBottomViewVisible(false);
        this.pHd.setIsBottomShowAll(false);
        this.pHd.setIsReturnSuperDispatchWhenCancel(true);
      }
      if (this.pMj) {
        ciC();
      }
      return;
      ((com.tencent.mm.plugin.emoji.a.h)this.pEH).pBs = this;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    ad.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onActivityResult . requestCode:" + paramInt1 + "  resultCode:" + paramInt2);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.pHv != null)
    {
      this.pHv.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
    }
    ad.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "mPayOrDownloadComponent have no init.");
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    ad.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onAttach");
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.pHa != null) {
      this.pHa.requestLayout();
    }
    setRequestedOrientation(1);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setRequestedOrientation(1);
    this.mActionBar = ((AppCompatActivity)thisActivity()).getSupportActionBar();
    paramBundle = com.tencent.mm.ui.z.jO(getContext()).inflate(2131492921, null);
    this.mActionBarHelper = new com.tencent.mm.ui.a(paramBundle);
    this.mActionBar.setLogo(new ColorDrawable(getResources().getColor(17170445)));
    this.mActionBar.gm();
    this.mActionBar.setDisplayHomeAsUpEnabled(false);
    this.mActionBar.gl();
    this.mActionBar.gn();
    this.mActionBar.setCustomView(paramBundle);
    this.mActionBar.show();
    paramBundle = this.mActionBarHelper;
    paramBundle.iVq.setText(2131758307);
    if (com.tencent.mm.cc.a.im(paramBundle.iVq.getContext()))
    {
      TextView localTextView = paramBundle.iVq;
      float f = com.tencent.mm.cc.a.ay(paramBundle.iVq.getContext(), 2131165184);
      localTextView.setTextSize(0, com.tencent.mm.cc.a.ik(paramBundle.iVq.getContext()) * f);
    }
    this.mActionBarHelper.setClickListener(new EmojiStoreV2BaseFragment.5(this));
    showOptionMenu(true);
    addIconOptionMenu(0, 2131689511, new EmojiStoreV2BaseFragment.6(this));
    com.tencent.mm.sdk.b.a.IbL.c(this.pHx);
    com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().ILo.add(this);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    ad.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onCreateView");
    return paramLayoutInflater.inflate(getLayoutId(), paramViewGroup, false);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ad.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onDestroy");
    if (this.pEH != null)
    {
      this.pEH.clear();
      this.pEH = null;
    }
    if (this.pHa != null)
    {
      this.pHa.cix();
      this.pHa.clear();
    }
    com.tencent.mm.sdk.b.a.IbL.d(this.pHx);
    com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().ILo.remove(this);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    ad.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onResume");
  }
  
  public void onDetach()
  {
    super.onDetach();
    ad.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onDetach");
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramAdapterView);
    localb.bd(paramView);
    localb.mr(paramInt);
    localb.qY(paramLong);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2BaseFragment", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
    paramInt -= this.mListView.getHeaderViewsCount();
    if ((paramInt < 0) || (paramInt >= this.pEH.getCount()))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2BaseFragment", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      return;
    }
    paramAdapterView = this.pEH.BS(paramInt);
    a(paramAdapterView, paramInt);
    if ((ciI()) && (this.pEH.cgj() > 0) && (paramInt >= this.pEH.cgi()) && (paramInt < this.pEH.cgi() + this.pEH.cgj()) && (paramAdapterView.pBV != null)) {
      com.tencent.mm.plugin.report.service.g.yhR.f(13223, new Object[] { Integer.valueOf(1), paramAdapterView.pBV.ProductID, paramAdapterView.pBV.PackName, Integer.valueOf(1), Integer.valueOf(0) });
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2BaseFragment", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
  }
  
  public void onPause()
  {
    super.onPause();
    com.tencent.mm.kernel.g.ajB().gAO.b(411, this);
    com.tencent.mm.kernel.g.ajB().gAO.b(423, this);
    ad.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onPause");
    if (this.pHa != null) {
      this.pHa.cix();
    }
    if (this.gKD != null) {
      this.gKD.removeMessages(131077);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    ad.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onResume");
    com.tencent.mm.kernel.g.ajB().gAO.a(411, this);
    com.tencent.mm.kernel.g.ajB().gAO.a(423, this);
    if (this.pMj)
    {
      if (this.gKD != null) {
        this.gKD.sendEmptyMessageDelayed(131077, 4000L);
      }
      if ((this.pEH != null) && (this.pEH.pBJ != null))
      {
        this.pEH.pBJ.cgo();
        this.pEH.refreshView();
      }
      if (((Boolean)com.tencent.mm.kernel.g.ajC().ajl().get(208900, Boolean.FALSE)).booleanValue())
      {
        cgM();
        com.tencent.mm.kernel.g.ajC().ajl().set(208900, Boolean.FALSE);
      }
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    ad.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onSceneEnd errType:%d,errCode:%d,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((this.iYL != null) && (this.iYL.isShowing())) {
      this.iYL.dismiss();
    }
    int i3 = paramn.getType();
    switch (i3)
    {
    default: 
      ad.w("MicroMsg.emoji.EmojiStoreV2BaseFragment", "unknow scene type.");
      break;
      break;
    }
    for (;;)
    {
      return;
      if ((paramn instanceof com.tencent.mm.plugin.emoji.f.n))
      {
        paramString = (com.tencent.mm.plugin.emoji.f.n)paramn;
        if ((paramString == null) || (paramString.mType != chC())) {
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
          if (paramString.chj() != null)
          {
            i = m;
            if (this.pEH.cgk() <= 0)
            {
              i = m;
              if (ciI()) {
                if (paramString.chj().CellSetList != null) {
                  break label474;
                }
              }
            }
          }
        }
        label474:
        for (i = 0;; i = paramString.chj().CellSetList.size())
        {
          this.pEH.BR(i);
          j = paramString.chj().TopHotNum;
          k = paramString.chj().RecentHotNum;
          ad.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onSceneEnd setSize:%d hotcount:%d recentHotCount:%d type:%d getSceneType:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i3), Integer.valueOf(paramString.mType) });
          if ((this.pEH != null) && (this.pEH.cgj() <= 0) && (ciI()))
          {
            com.tencent.mm.plugin.emoji.a.a.a locala = this.pEH;
            locala.BP(j + locala.cgk());
            this.pEH.BQ(k);
          }
          b(paramInt1, paramInt2, paramn);
          if (!ciI()) {
            break;
          }
          if ((paramString.chj() == null) || (paramString.chj().CellSetList == null) || (paramString.chj().CellSetList.size() <= 0)) {
            break label489;
          }
          paramInt1 = 0;
          while (paramInt1 < paramString.chj().CellSetList.size())
          {
            com.tencent.mm.plugin.report.service.g.yhR.f(13223, new Object[] { Integer.valueOf(0), Integer.valueOf(((EmotionBannerSet)paramString.chj().CellSetList.get(paramInt1)).ID), ((EmotionBannerSet)paramString.chj().CellSetList.get(paramInt1)).Title, Integer.valueOf(0) });
            paramInt1 += 1;
          }
        }
        label489:
        if ((paramString.chj().RecentHotNum <= 0) || (paramString.chj().EmotionList == null) || (paramString.chj().EmotionList.size() <= paramString.chj().TopHotNum + paramString.chj().RecentHotNum)) {
          break;
        }
        paramInt1 = 0;
        while (paramInt1 < paramString.chj().RecentHotNum)
        {
          com.tencent.mm.plugin.report.service.g.yhR.f(13223, new Object[] { Integer.valueOf(0), ((EmotionSummary)paramString.chj().EmotionList.get(paramString.chj().TopHotNum + paramInt1)).ProductID, ((EmotionSummary)paramString.chj().EmotionList.get(paramString.chj().TopHotNum + paramInt1)).PackName, Integer.valueOf(1) });
          paramInt1 += 1;
        }
      }
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1)) {
      if ((this.pHg == 0) || (this.llo)) {
        ad.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "No More List.");
      }
    }
    while (paramInt != 0)
    {
      return;
      kw(true);
      ad.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[onScrollStateChanged] startLoadRemoteEmoji.");
    }
    ciD();
  }
  
  public void onStart()
  {
    super.onStart();
    ad.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onStart");
  }
  
  public void onStop()
  {
    super.onStop();
    ad.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onStop");
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    ad.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "setUserVisibleHint :%b", new Object[] { Boolean.valueOf(paramBoolean) });
    super.setUserVisibleHint(paramBoolean);
    this.pMj = paramBoolean;
    if ((!this.pMk) && (this.pMl)) {
      ciC();
    }
    while (!paramBoolean) {
      return;
    }
    ciD();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2BaseFragment
 * JD-Core Version:    0.7.0.1
 */