package com.tencent.mm.plugin.emoji.ui.v2;

import android.app.Activity;
import android.app.ProgressDialog;
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
import com.tencent.mm.g.a.db;
import com.tencent.mm.plugin.emoji.a.a.f.a;
import com.tencent.mm.plugin.emoji.model.h.b;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.emoji.ui.EmojiStoreVpHeader;
import com.tencent.mm.protocal.protobuf.EmotionBanner;
import com.tencent.mm.protocal.protobuf.EmotionBannerSet;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.protocal.protobuf.GetEmotionListResponse;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.c;
import com.tencent.mm.ui.base.MMPullDownView.d;
import com.tencent.mm.ui.base.MMPullDownView.e;
import com.tencent.mm.ui.w;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public abstract class EmojiStoreV2BaseFragment
  extends MMFragment
  implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener, com.tencent.mm.ai.f, com.tencent.mm.plugin.emoji.a.h.a, com.tencent.mm.plugin.emoji.model.h.a, h.b, com.tencent.mm.pluginsdk.model.h.a, k.a, MMPullDownView.c, MMPullDownView.d, MMPullDownView.e
{
  private ProgressDialog gsr;
  private boolean icT;
  com.tencent.mm.plugin.emoji.a.a.a lhv;
  EmojiStoreVpHeader ljQ;
  private MMPullDownView ljT;
  private TextView ljU;
  private int ljW = -1;
  private View ljX;
  private byte[] ljY;
  private final int lkc = 131074;
  private final int lkd = 131075;
  private final int lke = 131076;
  private final String lkf = "product_id";
  private final String lkg = "progress";
  private final String lkh = "status";
  private com.tencent.mm.plugin.emoji.f.n lki;
  private int lkj;
  private com.tencent.mm.plugin.emoji.model.e lkk;
  private com.tencent.mm.plugin.emoji.model.h lkl;
  private com.tencent.mm.sdk.b.c lkn = new com.tencent.mm.sdk.b.c() {};
  private com.tencent.mm.plugin.emoji.f.g lko;
  private boolean lkp = false;
  private LinkedList<EmotionBanner> lkq = new LinkedList();
  private LinkedList<EmotionBannerSet> lkr = new LinkedList();
  private final int loS = 131077;
  public EmojiStoreV2HotBarView loT;
  private boolean loU = false;
  private boolean loV = false;
  private boolean loW = false;
  private ak loX = new EmojiStoreV2BaseFragment.1(this);
  private MenuItem.OnMenuItemClickListener loY = new EmojiStoreV2BaseFragment.3(this);
  private ActionBar mActionBar;
  private com.tencent.mm.ui.a mActionBarHelper;
  ListView mListView;
  private View xy;
  
  private void A(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.lkk != null) && (paramBoolean1))
    {
      if (paramBoolean2) {
        bng();
      }
      if (this.lhv != null) {
        this.lhv.b(this.lkk);
      }
    }
  }
  
  private void Lc(String paramString)
  {
    if (isFinishing())
    {
      ab.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[showLoadingDialog] acitivity is finished.");
      return;
    }
    FragmentActivity localFragmentActivity = thisActivity();
    getString(2131297087);
    this.gsr = com.tencent.mm.ui.base.h.b(localFragmentActivity, paramString, true, new EmojiStoreV2BaseFragment.9(this));
  }
  
  private void a(int paramInt, com.tencent.mm.plugin.emoji.model.e parame)
  {
    ab.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "");
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
      if (this.lkk != null) {
        this.lkk.bll();
      }
      A(bool2, bool1);
      return;
      this.lkk = parame;
      bool1 = true;
      bool2 = true;
      continue;
      this.lkk = parame;
      bool1 = false;
      bool2 = true;
      continue;
      this.lkk = parame;
      bool1 = false;
      bool2 = false;
      continue;
      if (this.lkk == null) {
        this.lkk = new com.tencent.mm.plugin.emoji.model.e();
      }
      this.lkk.uq(parame.lhk);
      this.lkk.bo(parame.lhl);
      bool1 = false;
      bool2 = true;
    }
  }
  
  private void a(com.tencent.mm.plugin.emoji.a.a.f paramf, int paramInt)
  {
    if (paramf == null)
    {
      ab.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "item is null.");
      return;
    }
    if (paramf.leZ == f.a.lfi)
    {
      paramf = paramf.lfb;
      if (paramf == null)
      {
        ab.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "banner set is null. do nothing");
        return;
      }
      com.tencent.mm.plugin.emoji.e.m.a(getContext(), paramf, false);
      return;
    }
    EmotionSummary localEmotionSummary = paramf.lfa;
    if (localEmotionSummary == null)
    {
      ab.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "summary is null. do nothing");
      return;
    }
    if (bnh()) {
      if ((paramInt >= 0) && (paramInt < this.lhv.bkC())) {
        paramInt = 3;
      }
    }
    for (;;)
    {
      String str = thisActivity().getIntent().getStringExtra("to_talker_name");
      com.tencent.mm.plugin.emoji.e.m.a(getContext(), localEmotionSummary, paramInt, paramf.mStatus, paramf.ym, str, 5);
      return;
      if ((paramInt >= this.lhv.bkC()) && (paramInt < this.lhv.bkD() + this.lhv.bkC()))
      {
        paramInt = 19;
      }
      else
      {
        paramInt = 1;
        continue;
        paramInt = 2;
      }
    }
  }
  
  private void aJ(byte[] paramArrayOfByte)
  {
    int i = bmb();
    int j = this.lkj;
    if (paramArrayOfByte != null)
    {
      ab.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[refreshNetSceneGetEmotionList] request buffer %s", new Object[] { paramArrayOfByte.toString() });
      this.lki = new com.tencent.mm.plugin.emoji.f.n(i, paramArrayOfByte, j);
      return;
    }
    ab.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[refreshNetSceneGetEmotionList] request buffer is null.");
    this.lki = new com.tencent.mm.plugin.emoji.f.n(i, j);
  }
  
  private void bma()
  {
    com.tencent.mm.plugin.emoji.a.a.b.a(this.lhv.leO, this);
  }
  
  private void bmd()
  {
    com.tencent.mm.kernel.g.RK().eHt.a(this.lki, 0);
  }
  
  private void bnc()
  {
    this.loV = true;
    bnd();
    this.lkj = thisActivity().getIntent().getIntExtra("preceding_scence", 5);
    if ((bne()) && (this.loX != null))
    {
      this.loX.postDelayed(new EmojiStoreV2BaseFragment.7(this), 3000L);
      return;
    }
    gK(true);
  }
  
  private void bnd()
  {
    this.lkl = new com.tencent.mm.plugin.emoji.model.h();
    this.lkl.jpJ = thisActivity();
    this.lkl.lhx = this;
    this.lkl.lhv = this.lhv;
    if (bnh()) {}
    for (this.lkl.lhy = 1;; this.lkl.lhy = 2)
    {
      this.lkl.lhB = this;
      return;
    }
  }
  
  private boolean bne()
  {
    boolean bool2 = false;
    GetEmotionListResponse localGetEmotionListResponse = i.getEmojiStorageMgr().yNq.NK(bmb());
    com.tencent.mm.plugin.emoji.model.e locale = com.tencent.mm.plugin.emoji.f.n.a(localGetEmotionListResponse);
    int j = bmb();
    int i;
    boolean bool1;
    label136:
    int k;
    if (localGetEmotionListResponse == null)
    {
      i = 0;
      ab.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "load cache type: %d, size: %d ", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      bool1 = bool2;
      if (locale != null)
      {
        bool1 = bool2;
        if (locale.lhl.size() > 0)
        {
          this.lkp = true;
          this.xy.setVisibility(8);
          this.ljT.setVisibility(0);
          a(this.ljW, locale);
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
      ab.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "load cache hotcount:%d type:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(bmb()) });
      if ((this.lhv != null) && (bnh()))
      {
        this.lhv.ug(i + k);
        this.lhv.uh(j);
      }
      bma();
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
  
  private static boolean bnf()
  {
    ((Long)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yxR, Long.valueOf(0L))).longValue();
    return true;
  }
  
  private void bng()
  {
    if (this.lkk == null) {
      ab.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "update store ui header failed. ");
    }
    do
    {
      return;
      this.lkq = ((LinkedList)this.lkk.lhn);
      this.lkr = ((LinkedList)this.lkk.lho);
      if (this.lkq != null)
      {
        this.ljQ.d(this.lkq, this.lkr);
        return;
      }
    } while (this.lkk.lhm == null);
    this.lkq = new LinkedList();
    this.lkq.add(this.lkk.lhm);
    this.ljQ.d(this.lkq, this.lkr);
  }
  
  private void d(GetEmotionListResponse paramGetEmotionListResponse)
  {
    if (this.ljW == -1) {
      com.tencent.mm.kernel.g.RO().ac(new EmojiStoreV2BaseFragment.8(this, paramGetEmotionListResponse));
    }
  }
  
  private void gL(boolean paramBoolean)
  {
    if (this.icT) {
      ab.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "isLoading");
    }
    do
    {
      return;
      this.icT = true;
      if (paramBoolean) {
        this.ljX.setVisibility(0);
      }
      aJ(this.ljY);
      bmd();
      ab.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[startLoadRemoteEmoji] doScene GetEmotionListNetScene");
    } while (paramBoolean);
    Lc(getString(2131297112));
  }
  
  public final void A(ArrayList<com.tencent.mm.pluginsdk.model.n> paramArrayList)
  {
    ab.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "google [onQueryFinish]");
    if (this.lhv == null) {
      return;
    }
    if (this.loX != null) {
      this.loX.sendEmptyMessageDelayed(131074, 50L);
    }
    com.tencent.mm.plugin.emoji.a.a.b.a(paramArrayList, this.lhv.leO);
  }
  
  public final void a(com.tencent.mm.plugin.emoji.a.a parama)
  {
    if (parama.bkt() == 9) {
      Lc(getString(2131297094));
    }
    if (bnh()) {
      if ((parama.mPosition >= 0) && (parama.mPosition < this.lhv.bkC())) {
        this.lkl.lhy = 3;
      }
    }
    for (;;)
    {
      this.lkl.a(parama);
      return;
      if ((parama.mPosition >= this.lhv.bkC()) && (parama.mPosition < this.lhv.bkD() + this.lhv.bkC()))
      {
        this.lkl.lhy = 19;
      }
      else
      {
        this.lkl.lhy = 1;
        continue;
        this.lkl.lhy = 2;
      }
    }
  }
  
  public final void a(String paramString, com.tencent.mm.sdk.e.m paramm)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals("delete_group")) && (this.loX != null)) {
      this.loX.sendEmptyMessageDelayed(131074, 50L);
    }
  }
  
  public final boolean bik()
  {
    ab.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[onBottomLoadData] startLoadRemoteEmoji.");
    gL(true);
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
  
  public abstract com.tencent.mm.plugin.emoji.a.a.a blU();
  
  public final void blm()
  {
    this.ljY = null;
    this.ljW = -1;
    gL(false);
  }
  
  public abstract int bmb();
  
  public abstract boolean bnh();
  
  public final void gK(boolean paramBoolean)
  {
    ab.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "loadNetWork force:%b isNeedToRefresh:%b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bnf()) });
    if (!paramBoolean) {
      bnf();
    }
    aJ(this.ljY);
    bmd();
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public final void i(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.lko = new com.tencent.mm.plugin.emoji.f.g(paramString1, paramString2, paramString3);
    com.tencent.mm.kernel.g.RK().eHt.a(this.lko, 0);
  }
  
  public final void o(Message paramMessage)
  {
    if (this.loX != null) {
      this.loX.sendMessage(paramMessage);
    }
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    ab.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onActivityCreated");
    super.onActivityCreated(paramBundle);
    this.loW = true;
    this.lhv = blU();
    this.lhv.leP = this;
    this.xy = findViewById(2131821788);
    this.ljU = ((TextView)this.xy.findViewById(2131823644));
    this.ljX = getActivityLayoutInflater().inflate(2130969387, null);
    this.ljX.setVisibility(8);
    this.ljQ = new EmojiStoreVpHeader(getContext());
    this.mListView = ((ListView)findViewById(16908298));
    this.mListView.addHeaderView(this.ljQ);
    if (!bnh())
    {
      this.loT = new EmojiStoreV2HotBarView(getContext());
      this.loT.setDesignerEmojiViewVisibility(8);
      this.loT.setDesignerCatalogViewPadding(false);
      this.mListView.addHeaderView(this.loT);
    }
    this.mListView.addFooterView(this.ljX);
    this.mListView.setAdapter(this.lhv);
    if (bnh()) {
      this.mListView.setOnItemClickListener(this);
    }
    for (;;)
    {
      this.mListView.setOnScrollListener(this);
      this.mListView.setLongClickable(false);
      this.mListView.setOnTouchListener(new EmojiStoreV2BaseFragment.6(this));
      this.lhv.leN = this.mListView;
      this.ljT = ((MMPullDownView)findViewById(2131823652));
      if (this.ljT != null)
      {
        this.ljT.setTopViewVisible(false);
        this.ljT.setAtTopCallBack(this);
        this.ljT.setOnBottomLoadDataListener(this);
        this.ljT.setAtBottomCallBack(this);
        this.ljT.setBottomViewVisible(false);
        this.ljT.setIsBottomShowAll(false);
        this.ljT.setIsReturnSuperDispatchWhenCancel(true);
      }
      if (this.loU) {
        bnc();
      }
      return;
      ((com.tencent.mm.plugin.emoji.a.h)this.lhv).lex = this;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    ab.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onActivityResult . requestCode:" + paramInt1 + "  resultCode:" + paramInt2);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.lkl != null)
    {
      this.lkl.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
    }
    ab.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "mPayOrDownloadComponent have no init.");
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    ab.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onAttach");
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.ljQ != null) {
      this.ljQ.requestLayout();
    }
    setRequestedOrientation(1);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setRequestedOrientation(1);
    this.mActionBar = ((AppCompatActivity)thisActivity()).getSupportActionBar();
    paramBundle = w.hM(getContext()).inflate(2130968613, null);
    this.mActionBarHelper = new com.tencent.mm.ui.a(paramBundle);
    this.mActionBar.setLogo(new ColorDrawable(getResources().getColor(17170445)));
    this.mActionBar.eu();
    this.mActionBar.setDisplayHomeAsUpEnabled(false);
    this.mActionBar.et();
    this.mActionBar.ev();
    this.mActionBar.setCustomView(paramBundle);
    this.mActionBar.show();
    paramBundle = this.mActionBarHelper;
    paramBundle.gpL.setText(2131299181);
    if (com.tencent.mm.cb.a.gt(paramBundle.gpL.getContext()))
    {
      TextView localTextView = paramBundle.gpL;
      float f = com.tencent.mm.cb.a.ap(paramBundle.gpL.getContext(), 2131427493);
      localTextView.setTextSize(0, com.tencent.mm.cb.a.gr(paramBundle.gpL.getContext()) * f);
    }
    this.mActionBarHelper.b(new EmojiStoreV2BaseFragment.4(this));
    showOptionMenu(true);
    addIconOptionMenu(0, 2131230758, new EmojiStoreV2BaseFragment.5(this));
    com.tencent.mm.sdk.b.a.ymk.c(this.lkn);
    i.getEmojiStorageMgr().yNo.add(this);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    ab.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onCreateView");
    return paramLayoutInflater.inflate(getLayoutId(), paramViewGroup, false);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ab.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onDestroy");
    if (this.lhv != null)
    {
      this.lhv.clear();
      this.lhv = null;
    }
    if (this.ljQ != null)
    {
      this.ljQ.bmX();
      this.ljQ.clear();
    }
    com.tencent.mm.sdk.b.a.ymk.d(this.lkn);
    i.getEmojiStorageMgr().yNo.remove(this);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    ab.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onResume");
  }
  
  public void onDetach()
  {
    super.onDetach();
    ab.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onDetach");
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramInt -= this.mListView.getHeaderViewsCount();
    if ((paramInt < 0) || (paramInt >= this.lhv.getCount())) {}
    do
    {
      return;
      paramAdapterView = this.lhv.uj(paramInt);
      a(paramAdapterView, paramInt);
    } while ((!bnh()) || (this.lhv.bkD() <= 0) || (paramInt < this.lhv.bkC()) || (paramInt >= this.lhv.bkC() + this.lhv.bkD()) || (paramAdapterView.lfa == null));
    com.tencent.mm.plugin.report.service.h.qsU.e(13223, new Object[] { Integer.valueOf(1), paramAdapterView.lfa.ProductID, paramAdapterView.lfa.PackName, Integer.valueOf(1), Integer.valueOf(0) });
  }
  
  public void onPause()
  {
    super.onPause();
    com.tencent.mm.kernel.g.RK().eHt.b(411, this);
    com.tencent.mm.kernel.g.RK().eHt.b(423, this);
    ab.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onPause");
    if (this.ljQ != null) {
      this.ljQ.bmX();
    }
    if (this.loX != null) {
      this.loX.removeMessages(131077);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    ab.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onResume");
    com.tencent.mm.kernel.g.RK().eHt.a(411, this);
    com.tencent.mm.kernel.g.RK().eHt.a(423, this);
    if (this.loU)
    {
      if (this.loX != null) {
        this.loX.sendEmptyMessageDelayed(131077, 4000L);
      }
      if ((this.lhv != null) && (this.lhv.leO != null))
      {
        this.lhv.leO.bkJ();
        this.lhv.refreshView();
      }
      if (((Boolean)com.tencent.mm.kernel.g.RL().Ru().get(208900, Boolean.FALSE)).booleanValue())
      {
        blm();
        com.tencent.mm.kernel.g.RL().Ru().set(208900, Boolean.FALSE);
      }
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    ab.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onSceneEnd errType:%d,errCode:%d,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((this.gsr != null) && (this.gsr.isShowing())) {
      this.gsr.dismiss();
    }
    int i3 = paramm.getType();
    switch (i3)
    {
    default: 
      ab.w("MicroMsg.emoji.EmojiStoreV2BaseFragment", "unknow scene type.");
      break;
    }
    for (;;)
    {
      return;
      if ((paramm instanceof com.tencent.mm.plugin.emoji.f.n))
      {
        paramString = (com.tencent.mm.plugin.emoji.f.n)paramm;
        if ((paramString == null) || (paramString.mType != bmb())) {
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
          if (paramString.blH() != null)
          {
            i = m;
            if (this.lhv.bkE() <= 0)
            {
              i = m;
              if (bnh())
              {
                if (paramString.blH().CellSetList != null) {
                  break label570;
                }
                i = 0;
                this.lhv.ui(i);
              }
            }
            j = paramString.blH().TopHotNum;
            k = paramString.blH().RecentHotNum;
          }
        }
        ab.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onSceneEnd setSize:%d hotcount:%d recentHotCount:%d type:%d getSceneType:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i3), Integer.valueOf(paramString.mType) });
        Object localObject;
        if ((this.lhv != null) && (this.lhv.bkD() <= 0) && (bnh()))
        {
          localObject = this.lhv;
          ((com.tencent.mm.plugin.emoji.a.a.a)localObject).ug(j + ((com.tencent.mm.plugin.emoji.a.a.a)localObject).bkE());
          this.lhv.uh(k);
        }
        this.icT = false;
        this.ljX.setVisibility(8);
        if ((paramInt1 == 0) || (paramInt1 == 4))
        {
          paramInt1 = 1;
          label361:
          if (paramInt1 == 0) {
            break label683;
          }
          this.xy.setVisibility(8);
          this.ljT.setVisibility(0);
          localObject = (com.tencent.mm.plugin.emoji.f.n)paramm;
          paramm = com.tencent.mm.plugin.emoji.f.n.a(((com.tencent.mm.plugin.emoji.f.n)localObject).blH());
          this.ljY = ((com.tencent.mm.plugin.emoji.f.n)localObject).liN;
          if (paramInt2 != 0) {
            break label590;
          }
          localObject = ((com.tencent.mm.plugin.emoji.f.n)localObject).blH();
          a(this.ljW, paramm);
          d((GetEmotionListResponse)localObject);
          this.ljW = 0;
        }
        label683:
        for (;;)
        {
          if (!bnh()) {
            break label718;
          }
          if ((paramString.blH() == null) || (paramString.blH().CellSetList == null) || (paramString.blH().CellSetList.size() <= 0)) {
            break label720;
          }
          paramInt1 = 0;
          while (paramInt1 < paramString.blH().CellSetList.size())
          {
            com.tencent.mm.plugin.report.service.h.qsU.e(13223, new Object[] { Integer.valueOf(0), Integer.valueOf(((EmotionBannerSet)paramString.blH().CellSetList.get(paramInt1)).ID), ((EmotionBannerSet)paramString.blH().CellSetList.get(paramInt1)).Title, Integer.valueOf(0) });
            paramInt1 += 1;
          }
          label570:
          i = paramString.blH().CellSetList.size();
          break;
          paramInt1 = 0;
          break label361;
          label590:
          if (paramInt2 == 2)
          {
            localObject = ((com.tencent.mm.plugin.emoji.f.n)localObject).blH();
            a(this.ljW, paramm);
            bma();
            d((GetEmotionListResponse)localObject);
            this.ljW = 2;
          }
          else if (paramInt2 == 3)
          {
            a(this.ljW, paramm);
            this.ljW = 1;
          }
          else
          {
            this.xy.setVisibility(0);
            this.ljT.setVisibility(8);
            this.ljU.setText(2131299204);
            continue;
            if (!this.lkp)
            {
              this.xy.setVisibility(0);
              this.ljT.setVisibility(8);
              this.ljU.setText(2131299205);
            }
          }
        }
        label718:
        continue;
        label720:
        if ((paramString.blH().RecentHotNum <= 0) || (paramString.blH().EmotionList == null) || (paramString.blH().EmotionList.size() <= paramString.blH().TopHotNum + paramString.blH().RecentHotNum)) {
          break;
        }
        paramInt1 = 0;
        while (paramInt1 < paramString.blH().RecentHotNum)
        {
          com.tencent.mm.plugin.report.service.h.qsU.e(13223, new Object[] { Integer.valueOf(0), ((EmotionSummary)paramString.blH().EmotionList.get(paramString.blH().TopHotNum + paramInt1)).ProductID, ((EmotionSummary)paramString.blH().EmotionList.get(paramString.blH().TopHotNum + paramInt1)).PackName, Integer.valueOf(1) });
          paramInt1 += 1;
        }
      }
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1))
    {
      if ((this.ljW == 0) || (this.icT)) {
        ab.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "No More List.");
      }
    }
    else {
      return;
    }
    gL(true);
    ab.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[onScrollStateChanged] startLoadRemoteEmoji.");
  }
  
  public void onStart()
  {
    super.onStart();
    ab.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onStart");
  }
  
  public void onStop()
  {
    super.onStop();
    ab.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onStop");
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    ab.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "setUserVisibleHint :%b", new Object[] { Boolean.valueOf(paramBoolean) });
    super.setUserVisibleHint(paramBoolean);
    this.loU = paramBoolean;
    if ((!this.loV) && (this.loW)) {
      bnc();
    }
  }
  
  public final void uk(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= ((com.tencent.mm.plugin.emoji.a.h)this.lhv).bkH())) {
      return;
    }
    a(this.lhv.uj(paramInt), paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2BaseFragment
 * JD-Core Version:    0.7.0.1
 */