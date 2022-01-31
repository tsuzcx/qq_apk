package com.tencent.mm.plugin.emoji.ui.v2;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.ac.a.e;
import com.tencent.mm.ah.m;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.a.a.f.a;
import com.tencent.mm.plugin.emoji.e.k;
import com.tencent.mm.plugin.emoji.f.b;
import com.tencent.mm.plugin.emoji.f.e;
import com.tencent.mm.plugin.emoji.f.f;
import com.tencent.mm.plugin.emoji.f.g;
import com.tencent.mm.plugin.emoji.f.h;
import com.tencent.mm.plugin.emoji.f.o;
import com.tencent.mm.plugin.emoji.model.h.b;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.emoji.ui.EmojiStoreVpHeader;
import com.tencent.mm.pluginsdk.model.n;
import com.tencent.mm.protocal.c.afi;
import com.tencent.mm.protocal.c.vc;
import com.tencent.mm.protocal.c.ve;
import com.tencent.mm.protocal.c.vn;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.c;
import com.tencent.mm.ui.base.MMPullDownView.d;
import com.tencent.mm.ui.base.MMPullDownView.e;
import com.tencent.mm.ui.x;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public abstract class a
  extends x
  implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener, com.tencent.mm.ah.f, com.tencent.mm.plugin.emoji.a.h.a, com.tencent.mm.plugin.emoji.model.h.a, h.b, com.tencent.mm.pluginsdk.model.h.a, j.a, MMPullDownView.c, MMPullDownView.d, MMPullDownView.e
{
  ListView Nn;
  private ProgressDialog faz;
  private boolean gDQ;
  private View hrf;
  com.tencent.mm.plugin.emoji.a.a.a iYq;
  private int jbA;
  private com.tencent.mm.plugin.emoji.model.f jbB;
  private com.tencent.mm.plugin.emoji.model.h jbC;
  private com.tencent.mm.sdk.b.c jbE = new a.2(this);
  private com.tencent.mm.plugin.emoji.f.h jbF;
  private boolean jbG = false;
  private LinkedList<vc> jbH = new LinkedList();
  private LinkedList<ve> jbI = new LinkedList();
  EmojiStoreVpHeader jbh;
  private MMPullDownView jbk;
  private TextView jbl;
  private int jbn = -1;
  private View jbo;
  private byte[] jbp;
  private final int jbt = 131074;
  private final int jbu = 131075;
  private final int jbv = 131076;
  private final String jbw = "product_id";
  private final String jbx = "progress";
  private final String jby = "status";
  private o jbz;
  private final int jfZ = 131077;
  public EmojiStoreV2HotBarView jga;
  private boolean jgb = false;
  private boolean jgc = false;
  private boolean jgd = false;
  private ah jge = new a.1(this);
  private MenuItem.OnMenuItemClickListener jgf = new MenuItem.OnMenuItemClickListener()
  {
    public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
    {
      a.this.thisActivity().finish();
      return false;
    }
  };
  private ActionBar mActionBar;
  private com.tencent.mm.ui.b mActionBarHelper;
  
  private void Ba(String paramString)
  {
    if (isFinishing())
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[showLoadingDialog] acitivity is finished.");
      return;
    }
    FragmentActivity localFragmentActivity = thisActivity();
    getString(f.h.app_tip);
    this.faz = com.tencent.mm.ui.base.h.b(localFragmentActivity, paramString, true, new a.9(this));
  }
  
  private void a(int paramInt, com.tencent.mm.plugin.emoji.model.f paramf)
  {
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "");
    int i;
    switch (paramInt)
    {
    default: 
      paramInt = 0;
      i = 0;
      if (this.jbB != null) {
        this.jbB.aHL();
      }
      if ((this.jbB != null) && (i != 0)) {
        if (paramInt != 0)
        {
          if (this.jbB != null) {
            break label189;
          }
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "update store ui header failed. ");
        }
      }
      break;
    }
    for (;;)
    {
      if (this.iYq != null) {
        this.iYq.b(this.jbB);
      }
      return;
      this.jbB = paramf;
      paramInt = 1;
      i = 1;
      break;
      this.jbB = paramf;
      paramInt = 0;
      i = 1;
      break;
      this.jbB = paramf;
      paramInt = 0;
      i = 0;
      break;
      if (this.jbB == null) {
        this.jbB = new com.tencent.mm.plugin.emoji.model.f();
      }
      this.jbB.pV(paramf.iYg);
      this.jbB.aZ(paramf.iYh);
      paramInt = 0;
      i = 1;
      break;
      label189:
      this.jbH = ((LinkedList)this.jbB.iYj);
      this.jbI = ((LinkedList)this.jbB.iYk);
      if (this.jbH != null)
      {
        this.jbh.c(this.jbH, this.jbI);
      }
      else if (this.jbB.iYi != null)
      {
        this.jbH = new LinkedList();
        this.jbH.add(this.jbB.iYi);
        this.jbh.c(this.jbH, this.jbI);
      }
    }
  }
  
  private void a(com.tencent.mm.plugin.emoji.a.a.f paramf, int paramInt)
  {
    if (paramf == null)
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "item is null.");
      return;
    }
    if (paramf.iVT == f.a.iWc)
    {
      paramf = paramf.iVV;
      if (paramf == null)
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "banner set is null. do nothing");
        return;
      }
      k.a(getContext(), paramf, false);
      return;
    }
    vn localvn = paramf.iVU;
    if (localvn == null)
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "summary is null. do nothing");
      return;
    }
    if (aJy()) {
      if ((paramInt >= 0) && (paramInt < this.iYq.aGQ())) {
        paramInt = 3;
      }
    }
    for (;;)
    {
      String str = thisActivity().getIntent().getStringExtra("to_talker_name");
      k.a(getContext(), localvn, paramInt, paramf.mStatus, paramf.xL, str, 5);
      return;
      if ((paramInt >= this.iYq.aGQ()) && (paramInt < this.iYq.aGR() + this.iYq.aGQ()))
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
  
  private void aID()
  {
    com.tencent.mm.plugin.emoji.a.a.b.a(this.iYq.iVI, this);
  }
  
  protected static void aIG() {}
  
  private void aJv()
  {
    int j = 0;
    this.jgc = true;
    this.jbC = new com.tencent.mm.plugin.emoji.model.h();
    this.jbC.hxz = thisActivity();
    this.jbC.iYs = this;
    this.jbC.iYq = this.iYq;
    afi localafi;
    int k;
    int i;
    if (aJy())
    {
      this.jbC.iYt = 1;
      this.jbC.iYw = this;
      this.jbA = thisActivity().getIntent().getIntExtra("preceding_scence", 5);
      localafi = i.getEmojiStorageMgr().uBe.FA(aIE());
      com.tencent.mm.plugin.emoji.model.f localf = o.a(localafi);
      k = aIE();
      if (localafi != null) {
        break label339;
      }
      i = 0;
      label123:
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "load cache type: %d, size: %d ", new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
      i = j;
      if (localf != null)
      {
        i = j;
        if (localf.iYh.size() > 0)
        {
          this.jbG = true;
          this.hrf.setVisibility(8);
          this.jbk.setVisibility(0);
          a(this.jbn, localf);
          if (localafi == null) {
            break label366;
          }
          if (localafi.tdl != null) {
            break label348;
          }
          i = 0;
          label218:
          k = localafi.tdi;
          j = localafi.tdj;
        }
      }
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "load cache hotcount:%d type:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(aIE()) });
      if ((this.iYq != null) && (aJy()))
      {
        this.iYq.pM(i + k);
        this.iYq.pN(j);
      }
      aID();
      i = 1;
      if ((i != 0) && (this.jge != null))
      {
        this.jge.postDelayed(new Runnable()
        {
          public final void run()
          {
            a.this.fj(false);
          }
        }, 3000L);
        return;
        this.jbC.iYt = 2;
        break;
        label339:
        i = localafi.tcZ;
        break label123;
        label348:
        i = localafi.tdl.size();
        break label218;
      }
      fj(true);
      return;
      label366:
      j = 0;
      k = 0;
      i = 0;
    }
  }
  
  private void aJw()
  {
    g.DO().dJT.a(this.jbz, 0);
  }
  
  private static boolean aJx()
  {
    ((Long)g.DP().Dz().get(ac.a.uoa, Long.valueOf(0L))).longValue();
    return true;
  }
  
  private void al(byte[] paramArrayOfByte)
  {
    int i = aIE();
    int j = this.jbA;
    if (paramArrayOfByte != null)
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[refreshNetSceneGetEmotionList] request buffer %s", new Object[] { paramArrayOfByte.toString() });
      this.jbz = new o(i, paramArrayOfByte, j);
      return;
    }
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[refreshNetSceneGetEmotionList] request buffer is null.");
    this.jbz = new o(i, j);
  }
  
  private void d(afi paramafi)
  {
    if (this.jbn == -1) {
      g.DS().O(new a.8(this, paramafi));
    }
  }
  
  private void fk(boolean paramBoolean)
  {
    if (this.gDQ) {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "isLoading");
    }
    do
    {
      return;
      this.gDQ = true;
      if (paramBoolean) {
        this.jbo.setVisibility(0);
      }
      al(this.jbp);
      aJw();
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[startLoadRemoteEmoji] doScene GetEmotionListNetScene");
    } while (paramBoolean);
    Ba(getString(f.h.app_waiting));
  }
  
  public final void a(com.tencent.mm.plugin.emoji.a.a parama)
  {
    if (parama.aGH() == 9) {
      Ba(getString(f.h.app_uninstalling));
    }
    if (aJy()) {
      if ((parama.mPosition >= 0) && (parama.mPosition < this.iYq.aGQ())) {
        this.jbC.iYt = 3;
      }
    }
    for (;;)
    {
      this.jbC.a(parama);
      return;
      if ((parama.mPosition >= this.iYq.aGQ()) && (parama.mPosition < this.iYq.aGR() + this.iYq.aGQ()))
      {
        this.jbC.iYt = 19;
      }
      else
      {
        this.jbC.iYt = 1;
        continue;
        this.jbC.iYt = 2;
      }
    }
  }
  
  public final void a(String paramString, l paraml)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals("delete_group")) && (this.jge != null)) {
      this.jge.sendEmptyMessageDelayed(131074, 50L);
    }
  }
  
  public final boolean aEU()
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[onBottomLoadData] startLoadRemoteEmoji.");
    fk(true);
    return true;
  }
  
  public final boolean aEV()
  {
    return false;
  }
  
  public final boolean aEW()
  {
    return false;
  }
  
  public final void aHM()
  {
    this.jbp = null;
    this.jbn = -1;
    fk(false);
  }
  
  public abstract int aIE();
  
  public abstract com.tencent.mm.plugin.emoji.a.a.a aIx();
  
  public abstract boolean aJy();
  
  public final void fj(boolean paramBoolean)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "loadNetWork force:%b isNeedToRefresh:%b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(aJx()) });
    if (!paramBoolean) {
      aJx();
    }
    al(this.jbp);
    aJw();
  }
  
  protected int getForceOrientation()
  {
    return 1;
  }
  
  public final void i(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.jbF = new com.tencent.mm.plugin.emoji.f.h(paramString1, paramString2, paramString3);
    g.DO().dJT.a(this.jbF, 0);
  }
  
  public final void j(Message paramMessage)
  {
    if (this.jge != null) {
      this.jge.sendMessage(paramMessage);
    }
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onActivityCreated");
    super.onActivityCreated(paramBundle);
    this.jgd = true;
    this.iYq = aIx();
    this.iYq.iVJ = this;
    this.hrf = findViewById(f.e.empty);
    this.jbl = ((TextView)this.hrf.findViewById(f.e.empty_content));
    this.jbo = getActivityLayoutInflater().inflate(f.f.emoji_store_load_more, null);
    this.jbo.setVisibility(8);
    this.jbh = new EmojiStoreVpHeader(getContext());
    this.Nn = ((ListView)findViewById(16908298));
    this.Nn.addHeaderView(this.jbh);
    if (!aJy())
    {
      this.jga = new EmojiStoreV2HotBarView(getContext());
      this.jga.setDesignerEmojiViewVisibility(8);
      this.jga.setDesignerCatalogViewPadding(false);
      this.Nn.addHeaderView(this.jga);
    }
    this.Nn.addFooterView(this.jbo);
    this.Nn.setAdapter(this.iYq);
    if (aJy()) {
      this.Nn.setOnItemClickListener(this);
    }
    for (;;)
    {
      this.Nn.setOnScrollListener(this);
      this.Nn.setLongClickable(false);
      this.Nn.setOnTouchListener(new a.6(this));
      this.iYq.iVH = this.Nn;
      this.jbk = ((MMPullDownView)findViewById(f.e.load_more_pull_view));
      if (this.jbk != null)
      {
        this.jbk.setTopViewVisible(false);
        this.jbk.setAtTopCallBack(this);
        this.jbk.setOnBottomLoadDataListener(this);
        this.jbk.setAtBottomCallBack(this);
        this.jbk.setBottomViewVisible(false);
        this.jbk.setIsBottomShowAll(false);
        this.jbk.setIsReturnSuperDispatchWhenCancel(true);
      }
      if (this.jgb) {
        aJv();
      }
      return;
      ((com.tencent.mm.plugin.emoji.a.h)this.iYq).iVs = this;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onActivityResult . requestCode:" + paramInt1 + "  resultCode:" + paramInt2);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.jbC != null)
    {
      this.jbC.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
    }
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "mPayOrDownloadComponent have no init.");
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onAttach");
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.jbh != null) {
      this.jbh.requestLayout();
    }
    setRequestedOrientation(1);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setRequestedOrientation(1);
    this.mActionBar = ((AppCompatActivity)thisActivity()).getSupportActionBar();
    paramBundle = com.tencent.mm.ui.y.gt(getContext()).inflate(f.f.actionbar_custom_area, null);
    this.mActionBarHelper = new com.tencent.mm.ui.b(paramBundle);
    this.mActionBar.setLogo(new ColorDrawable(getResources().getColor(17170445)));
    this.mActionBar.dZ();
    this.mActionBar.setDisplayHomeAsUpEnabled(false);
    this.mActionBar.dY();
    this.mActionBar.ea();
    this.mActionBar.setCustomView(paramBundle);
    this.mActionBar.show();
    paramBundle = this.mActionBarHelper;
    int i = f.h.emoji_store;
    paramBundle.eXO.setText(i);
    Object localObject;
    if (com.tencent.mm.cb.a.fh(paramBundle.eXO.getContext()))
    {
      localObject = paramBundle.eXO;
      float f = com.tencent.mm.cb.a.ab(paramBundle.eXO.getContext(), a.e.ActionBarTextSize);
      ((TextView)localObject).setTextSize(0, com.tencent.mm.cb.a.ff(paramBundle.eXO.getContext()) * f);
    }
    this.mActionBarHelper.d(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        if (!a.this.isScreenEnable()) {}
        while (a.a(a.this) == null) {
          return;
        }
        a.a(a.this).onMenuItemClick(null);
      }
    });
    paramBundle = this.mActionBar;
    boolean bool = ae.getContext().getSharedPreferences(ae.cqR() + "_redesign", 4).getBoolean("dark_actionbar", false);
    if (paramBundle.getCustomView() != null)
    {
      localObject = (ImageView)paramBundle.getCustomView().findViewById(f.e.arrow_area_btn);
      if ((localObject != null) && (bool)) {
        ((ImageView)localObject).getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
      }
      localObject = (TextView)paramBundle.getCustomView().findViewById(f.e.title_area);
      if ((localObject != null) && (bool)) {
        ((TextView)localObject).setTextColor(getActivity().getResources().getColor(f.b.white_text_color));
      }
      paramBundle = (TextView)paramBundle.getCustomView().findViewById(f.e.sub_title_area);
      if ((paramBundle != null) && (bool)) {
        paramBundle.setTextColor(getActivity().getResources().getColor(f.b.white_text_color));
      }
    }
    showOptionMenu(true);
    addIconOptionMenu(0, f.g.actionbar_setting_icon, new a.5(this));
    com.tencent.mm.sdk.b.a.udP.c(this.jbE);
    i.getEmojiStorageMgr().uBc.c(this);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onCreateView");
    return paramLayoutInflater.inflate(getLayoutId(), paramViewGroup, false);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onDestroy");
    if (this.iYq != null)
    {
      this.iYq.clear();
      this.iYq = null;
    }
    if (this.jbh != null)
    {
      this.jbh.aJs();
      this.jbh.clear();
    }
    com.tencent.mm.sdk.b.a.udP.d(this.jbE);
    i.getEmojiStorageMgr().uBc.d(this);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onResume");
  }
  
  public void onDetach()
  {
    super.onDetach();
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onDetach");
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramInt -= this.Nn.getHeaderViewsCount();
    if ((paramInt < 0) || (paramInt >= this.iYq.getCount())) {}
    do
    {
      return;
      paramAdapterView = this.iYq.pP(paramInt);
      a(paramAdapterView, paramInt);
    } while ((!aJy()) || (this.iYq.aGR() <= 0) || (paramInt < this.iYq.aGQ()) || (paramInt >= this.iYq.aGQ() + this.iYq.aGR()) || (paramAdapterView.iVU == null));
    com.tencent.mm.plugin.report.service.h.nFQ.f(13223, new Object[] { Integer.valueOf(1), paramAdapterView.iVU.syc, paramAdapterView.iVU.sSc, Integer.valueOf(1), Integer.valueOf(0) });
  }
  
  public void onPause()
  {
    super.onPause();
    g.DO().dJT.b(411, this);
    g.DO().dJT.b(423, this);
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onPause");
    if (this.jbh != null) {
      this.jbh.aJs();
    }
    if (this.jge != null) {
      this.jge.removeMessages(131077);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onResume");
    g.DO().dJT.a(411, this);
    g.DO().dJT.a(423, this);
    if (this.jgb)
    {
      if (this.jge != null) {
        this.jge.sendEmptyMessageDelayed(131077, 4000L);
      }
      if ((this.iYq != null) && (this.iYq.iVI != null))
      {
        this.iYq.iVI.aGX();
        this.iYq.aqU();
      }
      if (((Boolean)g.DP().Dz().get(208900, Boolean.valueOf(false))).booleanValue())
      {
        aHM();
        g.DP().Dz().o(208900, Boolean.valueOf(false));
      }
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onSceneEnd errType:%d,errCode:%d,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((this.faz != null) && (this.faz.isShowing())) {
      this.faz.dismiss();
    }
    int i3 = paramm.getType();
    switch (i3)
    {
    default: 
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.emoji.EmojiStoreV2BaseFragment", "unknow scene type.");
    }
    for (;;)
    {
      return;
      paramString = (o)paramm;
      if ((paramString != null) && (paramString.mType == aIE()))
      {
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
          if (paramString.aIi() != null)
          {
            i = m;
            if (this.iYq.aGS() <= 0)
            {
              i = m;
              if (aJy())
              {
                if (paramString.aIi().tdl != null) {
                  break label560;
                }
                i = 0;
                this.iYq.pO(i);
              }
            }
            j = paramString.aIi().tdi;
            k = paramString.aIi().tdj;
          }
        }
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onSceneEnd setSize:%d hotcount:%d recentHotCount:%d type:%d getSceneType:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i3), Integer.valueOf(paramString.mType) });
        if ((this.iYq != null) && (this.iYq.aGR() <= 0) && (aJy()))
        {
          this.iYq.pM(j + this.iYq.aGS());
          this.iYq.pN(k);
        }
        this.gDQ = false;
        this.jbo.setVisibility(8);
        label351:
        Object localObject;
        if ((paramInt1 == 0) || (paramInt1 == 4))
        {
          paramInt1 = 1;
          if (paramInt1 == 0) {
            break label673;
          }
          this.hrf.setVisibility(8);
          this.jbk.setVisibility(0);
          localObject = (o)paramm;
          paramm = o.a(((o)localObject).aIi());
          this.jbp = ((o)localObject).iZW;
          if (paramInt2 != 0) {
            break label580;
          }
          localObject = ((o)localObject).aIi();
          a(this.jbn, paramm);
          d((afi)localObject);
          this.jbn = 0;
        }
        label673:
        for (;;)
        {
          if (!aJy()) {
            break label708;
          }
          if ((paramString.aIi() == null) || (paramString.aIi().tdl == null) || (paramString.aIi().tdl.size() <= 0)) {
            break label710;
          }
          paramInt1 = 0;
          while (paramInt1 < paramString.aIi().tdl.size())
          {
            com.tencent.mm.plugin.report.service.h.nFQ.f(13223, new Object[] { Integer.valueOf(0), Integer.valueOf(((ve)paramString.aIi().tdl.get(paramInt1)).bxH), ((ve)paramString.aIi().tdl.get(paramInt1)).bGw, Integer.valueOf(0) });
            paramInt1 += 1;
          }
          label560:
          i = paramString.aIi().tdl.size();
          break;
          paramInt1 = 0;
          break label351;
          label580:
          if (paramInt2 == 2)
          {
            localObject = ((o)localObject).aIi();
            a(this.jbn, paramm);
            aID();
            d((afi)localObject);
            this.jbn = 2;
          }
          else if (paramInt2 == 3)
          {
            a(this.jbn, paramm);
            this.jbn = 1;
          }
          else
          {
            this.hrf.setVisibility(0);
            this.jbk.setVisibility(8);
            this.jbl.setText(f.h.emoji_store_load_failed);
            continue;
            if (!this.jbG)
            {
              this.hrf.setVisibility(0);
              this.jbk.setVisibility(8);
              this.jbl.setText(f.h.emoji_store_load_failed_network);
            }
          }
        }
        label708:
        continue;
        label710:
        if ((paramString.aIi().tdj > 0) && (paramString.aIi().tda != null) && (paramString.aIi().tda.size() > paramString.aIi().tdi + paramString.aIi().tdj))
        {
          paramInt1 = 0;
          while (paramInt1 < paramString.aIi().tdj)
          {
            com.tencent.mm.plugin.report.service.h.nFQ.f(13223, new Object[] { Integer.valueOf(0), ((vn)paramString.aIi().tda.get(paramString.aIi().tdi + paramInt1)).syc, ((vn)paramString.aIi().tda.get(paramString.aIi().tdi + paramInt1)).sSc, Integer.valueOf(1) });
            paramInt1 += 1;
          }
        }
      }
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1))
    {
      if ((this.jbn == 0) || (this.gDQ)) {
        com.tencent.mm.sdk.platformtools.y.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "No More List.");
      }
    }
    else {
      return;
    }
    fk(true);
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[onScrollStateChanged] startLoadRemoteEmoji.");
  }
  
  public void onStart()
  {
    super.onStart();
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onStart");
  }
  
  public void onStop()
  {
    super.onStop();
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onStop");
  }
  
  public final void pQ(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= ((com.tencent.mm.plugin.emoji.a.h)this.iYq).aGV())) {
      return;
    }
    a(this.iYq.pP(paramInt), paramInt);
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "setUserVisibleHint :%b", new Object[] { Boolean.valueOf(paramBoolean) });
    super.setUserVisibleHint(paramBoolean);
    this.jgb = paramBoolean;
    if ((!this.jgc) && (this.jgd)) {
      aJv();
    }
  }
  
  public final void x(ArrayList<n> paramArrayList)
  {
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "google [onQueryFinish]");
    if (this.iYq == null) {
      return;
    }
    if (this.jge != null) {
      this.jge.sendEmptyMessageDelayed(131074, 50L);
    }
    com.tencent.mm.plugin.emoji.a.a.b.a(paramArrayList, this.iYq.iVI);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.a
 * JD-Core Version:    0.7.0.1
 */