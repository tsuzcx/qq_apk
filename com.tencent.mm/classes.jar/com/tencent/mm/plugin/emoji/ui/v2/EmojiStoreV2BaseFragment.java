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
import com.tencent.mm.g.a.dh;
import com.tencent.mm.g.b.a.u;
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
import com.tencent.mm.protocal.protobuf.ccf;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.emotion.r;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.c;
import com.tencent.mm.ui.base.MMPullDownView.d;
import com.tencent.mm.ui.base.MMPullDownView.e;
import com.tencent.mm.ui.y;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public abstract class EmojiStoreV2BaseFragment
  extends MMFragment
  implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener, com.tencent.mm.al.g, h.a, com.tencent.mm.plugin.emoji.model.j.a, j.b, com.tencent.mm.pluginsdk.model.j.a, k.a, MMPullDownView.c, MMPullDownView.d, MMPullDownView.e
{
  private View DR;
  private ProgressDialog ift;
  private boolean knt;
  private ActionBar mActionBar;
  private com.tencent.mm.ui.a mActionBarHelper;
  protected long mDF;
  protected ListView mListView;
  private MMPullDownView oAb;
  private TextView oAc;
  private int oAe = -1;
  private View oAf;
  private byte[] oAg;
  private final int oAk = 131074;
  private final int oAl = 131075;
  private final int oAm = 131076;
  private final String oAn = "product_id";
  private final String oAo = "progress";
  private final String oAp = "status";
  private com.tencent.mm.plugin.emoji.f.n oAq;
  private int oAr;
  private com.tencent.mm.plugin.emoji.model.f oAs;
  private j oAt;
  private com.tencent.mm.sdk.b.c oAv = new com.tencent.mm.sdk.b.c() {};
  private com.tencent.mm.plugin.emoji.f.g oAw;
  private boolean oAx = false;
  private LinkedList<EmotionBanner> oAy = new LinkedList();
  private LinkedList<EmotionBannerSet> oAz = new LinkedList();
  private final int oFg = 131077;
  public EmojiStoreV2HotBarView oFh;
  private boolean oFi = false;
  private boolean oFj = false;
  private boolean oFk = false;
  private ap oFl = new ap()
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
        if (localEmojiStoreV2BaseFragment.oxx != null)
        {
          localEmojiStoreV2BaseFragment.oxx.notifyDataSetChanged();
          AppMethodBeat.o(109135);
          return;
          if ((localEmojiStoreV2BaseFragment.oxx == null) || (paramAnonymousMessage.getData() == null))
          {
            AppMethodBeat.o(109135);
            return;
          }
          String str = paramAnonymousMessage.getData().getString("product_id");
          if (str != null)
          {
            int i = paramAnonymousMessage.getData().getInt("progress");
            localEmojiStoreV2BaseFragment.oxx.cL(str, i);
            AppMethodBeat.o(109135);
            return;
            if ((localEmojiStoreV2BaseFragment.oxx == null) || (paramAnonymousMessage.getData() == null))
            {
              AppMethodBeat.o(109135);
              return;
            }
            str = paramAnonymousMessage.getData().getString("product_id");
            if (str != null)
            {
              i = paramAnonymousMessage.getData().getInt("status");
              localEmojiStoreV2BaseFragment.oxx.cK(str, i);
              AppMethodBeat.o(109135);
              return;
              if (localEmojiStoreV2BaseFragment.ozY != null) {
                localEmojiStoreV2BaseFragment.ozY.bWG();
              }
            }
          }
        }
      }
    }
  };
  private MenuItem.OnMenuItemClickListener oFm = new EmojiStoreV2BaseFragment.4(this);
  protected u oxH = new u();
  com.tencent.mm.plugin.emoji.a.a.a oxx;
  EmojiStoreVpHeader ozY;
  
  private void J(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.oAs != null) && (paramBoolean1))
    {
      if (paramBoolean2) {
        bWR();
      }
      if (this.oxx != null) {
        this.oxx.b(this.oAs);
      }
    }
  }
  
  private void Ui(String paramString)
  {
    if (isFinishing())
    {
      ad.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[showLoadingDialog] acitivity is finished.");
      return;
    }
    FragmentActivity localFragmentActivity = thisActivity();
    getString(2131755906);
    this.ift = com.tencent.mm.ui.base.h.b(localFragmentActivity, paramString, true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
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
      if (this.oAs != null) {
        this.oAs.bUT();
      }
      J(bool2, bool1);
      return;
      this.oAs = paramf;
      bool1 = true;
      bool2 = true;
      continue;
      this.oAs = paramf;
      bool1 = false;
      bool2 = true;
      continue;
      this.oAs = paramf;
      bool1 = false;
      bool2 = false;
      continue;
      if (this.oAs == null) {
        this.oAs = new com.tencent.mm.plugin.emoji.model.f();
      }
      this.oAs.AA(paramf.owY);
      this.oAs.cL(paramf.owZ);
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
    if (paramf.ouK == f.a.ouT)
    {
      paramf = paramf.ouM;
      if (paramf == null)
      {
        ad.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "banner set is null. do nothing");
        return;
      }
      com.tencent.mm.plugin.emoji.e.k.a(getContext(), paramf, false);
      return;
    }
    EmotionSummary localEmotionSummary = paramf.ouL;
    if (localEmotionSummary == null)
    {
      ad.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "summary is null. do nothing");
      return;
    }
    int i = k;
    if (bWS())
    {
      i = k;
      if (d.bUR().owT) {
        i = 1;
      }
    }
    this.oxH.gd(String.valueOf(paramInt + 1));
    this.oxH.gb(localEmotionSummary.ProductID);
    u localu = this.oxH;
    String str;
    if (i != 0)
    {
      str = localEmotionSummary.ExptDesc;
      localu.gc(str);
      this.oxH.dJy = 3;
      this.oxH.aBj();
      if (!bWS()) {
        break label285;
      }
      if ((paramInt < 0) || (paramInt >= this.oxx.bUr())) {
        break label243;
      }
      i = 3;
    }
    for (;;)
    {
      str = thisActivity().getIntent().getStringExtra("to_talker_name");
      com.tencent.mm.plugin.emoji.e.k.a(getContext(), localEmotionSummary, i, paramf.mStatus, paramf.EI, str, 5, this.oxH);
      return;
      str = localEmotionSummary.Introduce;
      break;
      label243:
      i = j;
      if (paramInt >= this.oxx.bUr())
      {
        i = j;
        if (paramInt < this.oxx.bUs() + this.oxx.bUr())
        {
          i = 19;
          continue;
          label285:
          i = 2;
        }
      }
    }
  }
  
  private void aZ(byte[] paramArrayOfByte)
  {
    int i = bVM();
    int j = this.oAr;
    if (paramArrayOfByte != null)
    {
      ad.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[refreshNetSceneGetEmotionList] request buffer %s", new Object[] { paramArrayOfByte.toString() });
      this.oAq = new com.tencent.mm.plugin.emoji.f.n(i, paramArrayOfByte, j);
      return;
    }
    ad.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[refreshNetSceneGetEmotionList] request buffer is null.");
    this.oAq = new com.tencent.mm.plugin.emoji.f.n(i, j);
  }
  
  private void bVL()
  {
    com.tencent.mm.plugin.emoji.a.a.b.a(this.oxx.ouz, this);
  }
  
  private void bVO()
  {
    com.tencent.mm.kernel.g.afA().gcy.a(this.oAq, 0);
  }
  
  private void bWM()
  {
    this.oFj = true;
    this.mDF = System.currentTimeMillis();
    ccf localccf = new ccf();
    localccf.DYC = this.mDF;
    this.oxH.dJw = this.mDF;
    ad.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "initeData: %s", new Object[] { Long.valueOf(localccf.DYC) });
    try
    {
      this.oAg = localccf.toByteArray();
      bWO();
      this.oAr = thisActivity().getIntent().getIntExtra("preceding_scence", 5);
      if ((bWP()) && (this.oFl != null))
      {
        this.oFl.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(109140);
            EmojiStoreV2BaseFragment.this.jH(false);
            AppMethodBeat.o(109140);
          }
        }, 3000L);
        aq.n(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(109141);
            EmojiStoreV2BaseFragment.this.bWN();
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
        jH(true);
      }
    }
  }
  
  private void bWO()
  {
    this.oAt = new j();
    this.oAt.mfC = thisActivity();
    this.oAt.oxz = this;
    this.oAt.oxx = this.oxx;
    if (bWS()) {}
    for (this.oAt.oxA = 1;; this.oAt.oxA = 2)
    {
      this.oAt.oxD = this;
      return;
    }
  }
  
  private boolean bWP()
  {
    boolean bool2 = false;
    GetEmotionListResponse localGetEmotionListResponse = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().Fzb.WO(bVM());
    com.tencent.mm.plugin.emoji.model.f localf = com.tencent.mm.plugin.emoji.f.n.b(localGetEmotionListResponse);
    int j = bVM();
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
        if (localf.owZ.size() > 0)
        {
          this.oAx = true;
          this.DR.setVisibility(8);
          this.oAb.setVisibility(0);
          a(this.oAe, localf);
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
      ad.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "load cache hotcount:%d type:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(bVM()) });
      if ((this.oxx != null) && (bWS()))
      {
        this.oxx.Ap(i + k);
        this.oxx.Aq(j);
      }
      bVL();
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
  
  private static boolean bWQ()
  {
    ((Long)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fgl, Long.valueOf(0L))).longValue();
    return true;
  }
  
  private void bWR()
  {
    if (this.oAs == null) {
      ad.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "update store ui header failed. ");
    }
    do
    {
      return;
      this.oAy = ((LinkedList)this.oAs.oxb);
      this.oAz = ((LinkedList)this.oAs.oxc);
      if (this.oAy != null)
      {
        this.ozY.d(this.oAy, this.oAz);
        return;
      }
    } while (this.oAs.oxa == null);
    this.oAy = new LinkedList();
    this.oAy.add(this.oAs.oxa);
    this.ozY.d(this.oAy, this.oAz);
  }
  
  private void e(final GetEmotionListResponse paramGetEmotionListResponse)
  {
    if (this.oAe == -1) {
      com.tencent.mm.kernel.g.afE().ax(new Runnable()
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
            ad.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "jacks save EmoijStoreUI Cache: list:%d, size: %d, type: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(EmojiStoreV2BaseFragment.this.bVM()) });
            com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().Fzb.a(EmojiStoreV2BaseFragment.this.bVM(), paramGetEmotionListResponse);
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
  
  private void jI(boolean paramBoolean)
  {
    if (this.knt) {
      ad.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "isLoading");
    }
    do
    {
      return;
      this.knt = true;
      if (paramBoolean) {
        this.oAf.setVisibility(0);
      }
      aZ(this.oAg);
      bVO();
      ad.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[startLoadRemoteEmoji] doScene GetEmotionListNetScene");
    } while (paramBoolean);
    Ui(getString(2131755936));
  }
  
  public final void Au(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= ((com.tencent.mm.plugin.emoji.a.h)this.oxx).bUv())) {
      return;
    }
    a(this.oxx.As(paramInt), paramInt);
  }
  
  public final void M(ArrayList<p> paramArrayList)
  {
    ad.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "google [onQueryFinish]");
    if (this.oxx == null) {
      return;
    }
    if (this.oFl != null) {
      this.oFl.sendEmptyMessageDelayed(131074, 50L);
    }
    com.tencent.mm.plugin.emoji.a.a.b.a(paramArrayList, this.oxx.ouz);
  }
  
  public final void a(com.tencent.mm.plugin.emoji.a.a parama)
  {
    if (parama.bUi() == 9) {
      Ui(getString(2131755913));
    }
    this.oAt.oxH = this.oxH;
    j localj = this.oAt;
    boolean bool;
    if ((bWS()) && (d.bUR().owT))
    {
      bool = true;
      localj.oxI = bool;
      if (!bWS()) {
        break label168;
      }
      if ((parama.mPosition < 0) || (parama.mPosition >= this.oxx.bUr())) {
        break label109;
      }
      this.oAt.oxA = 3;
    }
    label168:
    for (;;)
    {
      this.oAt.a(parama);
      return;
      bool = false;
      break;
      label109:
      if ((parama.mPosition >= this.oxx.bUr()) && (parama.mPosition < this.oxx.bUs() + this.oxx.bUr()))
      {
        this.oAt.oxA = 19;
      }
      else
      {
        this.oAt.oxA = 1;
        continue;
        this.oAt.oxA = 2;
      }
    }
  }
  
  public final void a(String paramString, m paramm)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals("delete_group")) && (this.oFl != null)) {
      this.oFl.sendEmptyMessageDelayed(131074, 50L);
    }
  }
  
  protected void b(int paramInt1, int paramInt2, com.tencent.mm.al.n paramn)
  {
    this.knt = false;
    this.oAf.setVisibility(8);
    if ((paramInt1 == 0) || (paramInt1 == 4))
    {
      paramInt1 = 1;
      if (paramInt1 == 0) {
        break label192;
      }
      this.DR.setVisibility(8);
      this.oAb.setVisibility(0);
      localObject = (com.tencent.mm.plugin.emoji.f.n)paramn;
      paramn = com.tencent.mm.plugin.emoji.f.n.b(((com.tencent.mm.plugin.emoji.f.n)localObject).bVs());
      this.oAg = ((com.tencent.mm.plugin.emoji.f.n)localObject).oyQ;
      if (paramInt2 != 0) {
        break label107;
      }
      localObject = ((com.tencent.mm.plugin.emoji.f.n)localObject).bVs();
      a(this.oAe, paramn);
      e((GetEmotionListResponse)localObject);
      this.oAe = 0;
    }
    label107:
    while (this.oAx)
    {
      Object localObject;
      return;
      paramInt1 = 0;
      break;
      if (paramInt2 == 2)
      {
        localObject = ((com.tencent.mm.plugin.emoji.f.n)localObject).bVs();
        a(this.oAe, paramn);
        bVL();
        e((GetEmotionListResponse)localObject);
        this.oAe = 2;
        return;
      }
      if (paramInt2 == 3)
      {
        a(this.oAe, paramn);
        this.oAe = 1;
        return;
      }
      this.DR.setVisibility(0);
      this.oAb.setVisibility(8);
      this.oAc.setText(2131758330);
      return;
    }
    label192:
    this.DR.setVisibility(0);
    this.oAb.setVisibility(8);
    this.oAc.setText(2131758331);
  }
  
  public final boolean bPh()
  {
    ad.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[onBottomLoadData] startLoadRemoteEmoji.");
    jI(true);
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
    jI(false);
  }
  
  public abstract com.tencent.mm.plugin.emoji.a.a.a bVF();
  
  public abstract int bVM();
  
  protected void bWN() {}
  
  public abstract boolean bWS();
  
  public final void bWT()
  {
    if ((this.mListView != null) && (this.oxx != null) && (bWS())) {
      this.oxx.refreshView();
    }
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public final void j(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.oAw = new com.tencent.mm.plugin.emoji.f.g(paramString1, paramString2, paramString3);
    com.tencent.mm.kernel.g.afA().gcy.a(this.oAw, 0);
  }
  
  public final void jH(boolean paramBoolean)
  {
    ad.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "loadNetWork force:%b isNeedToRefresh:%b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bWQ()) });
    if (!paramBoolean) {
      bWQ();
    }
    aZ(this.oAg);
    bVO();
  }
  
  public final void n(Message paramMessage)
  {
    if (this.oFl != null) {
      this.oFl.sendMessage(paramMessage);
    }
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    ad.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onActivityCreated");
    super.onActivityCreated(paramBundle);
    this.oFk = true;
    this.oxx = bVF();
    this.oxx.ouA = this;
    this.DR = findViewById(2131299457);
    this.oAc = ((TextView)this.DR.findViewById(2131299461));
    this.oAf = getActivityLayoutInflater().inflate(2131493799, null);
    this.oAf.setVisibility(8);
    this.ozY = new EmojiStoreVpHeader(getContext());
    this.mListView = ((ListView)findViewById(16908298));
    this.mListView.addHeaderView(this.ozY);
    if (!bWS())
    {
      this.oFh = new EmojiStoreV2HotBarView(getContext());
      this.oFh.setDesignerEmojiViewVisibility(8);
      this.oFh.setDesignerCatalogViewPadding(false);
      this.mListView.addHeaderView(this.oFh);
    }
    this.mListView.addFooterView(this.oAf);
    this.mListView.setAdapter(this.oxx);
    if (bWS()) {
      this.mListView.setOnItemClickListener(this);
    }
    for (;;)
    {
      this.mListView.setOnScrollListener(this);
      this.mListView.setLongClickable(false);
      this.mListView.setOnTouchListener(new EmojiStoreV2BaseFragment.7(this));
      this.oxx.ouy = this.mListView;
      this.oAb = ((MMPullDownView)findViewById(2131301487));
      if (this.oAb != null)
      {
        this.oAb.setTopViewVisible(false);
        this.oAb.setAtTopCallBack(this);
        this.oAb.setOnBottomLoadDataListener(this);
        this.oAb.setAtBottomCallBack(this);
        this.oAb.setBottomViewVisible(false);
        this.oAb.setIsBottomShowAll(false);
        this.oAb.setIsReturnSuperDispatchWhenCancel(true);
      }
      if (this.oFi) {
        bWM();
      }
      return;
      ((com.tencent.mm.plugin.emoji.a.h)this.oxx).ouh = this;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    ad.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onActivityResult . requestCode:" + paramInt1 + "  resultCode:" + paramInt2);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.oAt != null)
    {
      this.oAt.onActivityResult(paramInt1, paramInt2, paramIntent);
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
    if (this.ozY != null) {
      this.ozY.requestLayout();
    }
    setRequestedOrientation(1);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setRequestedOrientation(1);
    this.mActionBar = ((AppCompatActivity)thisActivity()).getSupportActionBar();
    paramBundle = y.js(getContext()).inflate(2131492921, null);
    this.mActionBarHelper = new com.tencent.mm.ui.a(paramBundle);
    this.mActionBar.setLogo(new ColorDrawable(getResources().getColor(17170445)));
    this.mActionBar.fM();
    this.mActionBar.setDisplayHomeAsUpEnabled(false);
    this.mActionBar.fL();
    this.mActionBar.fN();
    this.mActionBar.setCustomView(paramBundle);
    this.mActionBar.show();
    paramBundle = this.mActionBarHelper;
    paramBundle.ica.setText(2131758307);
    if (com.tencent.mm.cd.a.hS(paramBundle.ica.getContext()))
    {
      TextView localTextView = paramBundle.ica;
      float f = com.tencent.mm.cd.a.ap(paramBundle.ica.getContext(), 2131165184);
      localTextView.setTextSize(0, com.tencent.mm.cd.a.hQ(paramBundle.ica.getContext()) * f);
    }
    this.mActionBarHelper.e(new EmojiStoreV2BaseFragment.5(this));
    showOptionMenu(true);
    addIconOptionMenu(0, 2131689511, new EmojiStoreV2BaseFragment.6(this));
    com.tencent.mm.sdk.b.a.ESL.c(this.oAv);
    com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().FyZ.add(this);
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
    if (this.oxx != null)
    {
      this.oxx.clear();
      this.oxx = null;
    }
    if (this.ozY != null)
    {
      this.ozY.bWH();
      this.ozY.clear();
    }
    com.tencent.mm.sdk.b.a.ESL.d(this.oAv);
    com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().FyZ.remove(this);
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
    paramInt -= this.mListView.getHeaderViewsCount();
    if ((paramInt < 0) || (paramInt >= this.oxx.getCount())) {}
    do
    {
      return;
      paramAdapterView = this.oxx.As(paramInt);
      a(paramAdapterView, paramInt);
    } while ((!bWS()) || (this.oxx.bUs() <= 0) || (paramInt < this.oxx.bUr()) || (paramInt >= this.oxx.bUr() + this.oxx.bUs()) || (paramAdapterView.ouL == null));
    com.tencent.mm.plugin.report.service.h.vKh.f(13223, new Object[] { Integer.valueOf(1), paramAdapterView.ouL.ProductID, paramAdapterView.ouL.PackName, Integer.valueOf(1), Integer.valueOf(0) });
  }
  
  public void onPause()
  {
    super.onPause();
    com.tencent.mm.kernel.g.afA().gcy.b(411, this);
    com.tencent.mm.kernel.g.afA().gcy.b(423, this);
    ad.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onPause");
    if (this.ozY != null) {
      this.ozY.bWH();
    }
    if (this.oFl != null) {
      this.oFl.removeMessages(131077);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    ad.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onResume");
    com.tencent.mm.kernel.g.afA().gcy.a(411, this);
    com.tencent.mm.kernel.g.afA().gcy.a(423, this);
    if (this.oFi)
    {
      if (this.oFl != null) {
        this.oFl.sendEmptyMessageDelayed(131077, 4000L);
      }
      if ((this.oxx != null) && (this.oxx.ouz != null))
      {
        this.oxx.ouz.bUx();
        this.oxx.refreshView();
      }
      if (((Boolean)com.tencent.mm.kernel.g.afB().afk().get(208900, Boolean.FALSE)).booleanValue())
      {
        bUV();
        com.tencent.mm.kernel.g.afB().afk().set(208900, Boolean.FALSE);
      }
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    ad.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onSceneEnd errType:%d,errCode:%d,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((this.ift != null) && (this.ift.isShowing())) {
      this.ift.dismiss();
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
        if ((paramString == null) || (paramString.mType != bVM())) {
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
          if (paramString.bVs() != null)
          {
            i = m;
            if (this.oxx.bUt() <= 0)
            {
              i = m;
              if (bWS()) {
                if (paramString.bVs().CellSetList != null) {
                  break label474;
                }
              }
            }
          }
        }
        label474:
        for (i = 0;; i = paramString.bVs().CellSetList.size())
        {
          this.oxx.Ar(i);
          j = paramString.bVs().TopHotNum;
          k = paramString.bVs().RecentHotNum;
          ad.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onSceneEnd setSize:%d hotcount:%d recentHotCount:%d type:%d getSceneType:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i3), Integer.valueOf(paramString.mType) });
          if ((this.oxx != null) && (this.oxx.bUs() <= 0) && (bWS()))
          {
            com.tencent.mm.plugin.emoji.a.a.a locala = this.oxx;
            locala.Ap(j + locala.bUt());
            this.oxx.Aq(k);
          }
          b(paramInt1, paramInt2, paramn);
          if (!bWS()) {
            break;
          }
          if ((paramString.bVs() == null) || (paramString.bVs().CellSetList == null) || (paramString.bVs().CellSetList.size() <= 0)) {
            break label489;
          }
          paramInt1 = 0;
          while (paramInt1 < paramString.bVs().CellSetList.size())
          {
            com.tencent.mm.plugin.report.service.h.vKh.f(13223, new Object[] { Integer.valueOf(0), Integer.valueOf(((EmotionBannerSet)paramString.bVs().CellSetList.get(paramInt1)).ID), ((EmotionBannerSet)paramString.bVs().CellSetList.get(paramInt1)).Title, Integer.valueOf(0) });
            paramInt1 += 1;
          }
        }
        label489:
        if ((paramString.bVs().RecentHotNum <= 0) || (paramString.bVs().EmotionList == null) || (paramString.bVs().EmotionList.size() <= paramString.bVs().TopHotNum + paramString.bVs().RecentHotNum)) {
          break;
        }
        paramInt1 = 0;
        while (paramInt1 < paramString.bVs().RecentHotNum)
        {
          com.tencent.mm.plugin.report.service.h.vKh.f(13223, new Object[] { Integer.valueOf(0), ((EmotionSummary)paramString.bVs().EmotionList.get(paramString.bVs().TopHotNum + paramInt1)).ProductID, ((EmotionSummary)paramString.bVs().EmotionList.get(paramString.bVs().TopHotNum + paramInt1)).PackName, Integer.valueOf(1) });
          paramInt1 += 1;
        }
      }
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1)) {
      if ((this.oAe == 0) || (this.knt)) {
        ad.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "No More List.");
      }
    }
    while (paramInt != 0)
    {
      return;
      jI(true);
      ad.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[onScrollStateChanged] startLoadRemoteEmoji.");
    }
    bWN();
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
    this.oFi = paramBoolean;
    if ((!this.oFj) && (this.oFk)) {
      bWM();
    }
    while (!paramBoolean) {
      return;
    }
    bWN();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2BaseFragment
 * JD-Core Version:    0.7.0.1
 */