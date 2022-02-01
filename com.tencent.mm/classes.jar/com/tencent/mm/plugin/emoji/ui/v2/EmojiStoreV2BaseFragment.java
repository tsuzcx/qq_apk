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
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.e;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.a.ee;
import com.tencent.mm.autogen.mmdata.rpt.bw;
import com.tencent.mm.plugin.emoji.a.a.f.a;
import com.tencent.mm.plugin.emoji.a.h.a;
import com.tencent.mm.plugin.emoji.e.o;
import com.tencent.mm.plugin.emoji.h.b;
import com.tencent.mm.plugin.emoji.h.e;
import com.tencent.mm.plugin.emoji.h.f;
import com.tencent.mm.plugin.emoji.h.g;
import com.tencent.mm.plugin.emoji.h.h;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.j;
import com.tencent.mm.plugin.emoji.model.m;
import com.tencent.mm.plugin.emoji.model.r;
import com.tencent.mm.plugin.emoji.model.r.a;
import com.tencent.mm.plugin.emoji.model.r.b;
import com.tencent.mm.plugin.emoji.ui.v3.banner.EmojiStoreV3BannerView;
import com.tencent.mm.plugin.emoji.ui.v3.banner.EmojiStoreV3BannerView.a;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.pluginsdk.model.o.a;
import com.tencent.mm.pluginsdk.model.w;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.protocal.protobuf.anj;
import com.tencent.mm.protocal.protobuf.cjb;
import com.tencent.mm.protocal.protobuf.ehf;
import com.tencent.mm.protocal.protobuf.gog;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.af;
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
  implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener, com.tencent.mm.am.h, h.a, r.a, r.b, o.a, MStorage.IOnStorageChange, MMPullDownView.c, MMPullDownView.d, MMPullDownView.e
{
  private View bEx;
  private MMHandler eqE = new MMHandler()
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
        if (localEmojiStoreV2BaseFragment.xNj != null)
        {
          localEmojiStoreV2BaseFragment.xNj.notifyDataSetChanged();
          AppMethodBeat.o(109135);
          return;
          if ((localEmojiStoreV2BaseFragment.xNj == null) || (paramAnonymousMessage.getData() == null))
          {
            AppMethodBeat.o(109135);
            return;
          }
          String str = paramAnonymousMessage.getData().getString("product_id");
          if (str != null)
          {
            int i = paramAnonymousMessage.getData().getInt("progress");
            localEmojiStoreV2BaseFragment.xNj.dY(str, i);
            AppMethodBeat.o(109135);
            return;
            if ((localEmojiStoreV2BaseFragment.xNj == null) || (paramAnonymousMessage.getData() == null))
            {
              AppMethodBeat.o(109135);
              return;
            }
            str = paramAnonymousMessage.getData().getString("product_id");
            if (str != null)
            {
              i = paramAnonymousMessage.getData().getInt("status");
              localEmojiStoreV2BaseFragment.xNj.dX(str, i);
              AppMethodBeat.o(109135);
              return;
              if (localEmojiStoreV2BaseFragment.xVD != null)
              {
                Log.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "startPlayHeader");
                localEmojiStoreV2BaseFragment.xVD.dCU();
              }
            }
          }
        }
      }
    }
  };
  private ActionBar mActionBar;
  private com.tencent.mm.ui.b mActionBarHelper;
  protected ListView mListView;
  protected long owx;
  private ProgressDialog pNH;
  private boolean szX;
  com.tencent.mm.plugin.emoji.a.a.a xNj;
  protected bw xNu = new bw();
  private MMPullDownView xPM;
  private TextView xPN;
  private int xPP = -1;
  private View xPQ;
  private byte[] xPR;
  private final int xPV = 131074;
  private final int xPW = 131075;
  private final int xPX = 131076;
  private final String xPY = "product_id";
  private final String xPZ = "progress";
  private final String xQa = "status";
  private o xQb;
  private int xQc;
  private m xQd;
  private r xQe;
  private IListener xQg = new IListener(com.tencent.mm.app.f.hfK) {};
  private com.tencent.mm.plugin.emoji.e.h xQj;
  private boolean xQk = false;
  private LinkedList<anh> xQl = new LinkedList();
  private LinkedList<anj> xQm = new LinkedList();
  private final int xVB = 131077;
  private View xVC;
  EmojiStoreV3BannerView xVD;
  private com.tencent.mm.plugin.emoji.ui.v3.banner.a xVE;
  private com.tencent.mm.plugin.emoji.ui.v3.a.b xVF;
  private Boolean xVG = Boolean.TRUE;
  public EmojiStoreV2HotBarView xVH;
  private boolean xVI = false;
  private boolean xVJ = false;
  private boolean xVK = false;
  private MenuItem.OnMenuItemClickListener xVL = new EmojiStoreV2BaseFragment.4(this);
  
  private void S(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.xQd != null) && (paramBoolean1))
    {
      if (paramBoolean2) {
        dCk();
      }
      if (this.xNj != null) {
        this.xNj.b(this.xQd);
      }
    }
  }
  
  private void a(int paramInt, m paramm)
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
      if (this.xQd != null) {
        this.xQd.dzS();
      }
      S(bool2, bool1);
      return;
      this.xQd = paramm;
      bool1 = true;
      bool2 = true;
      continue;
      this.xQd = paramm;
      bool1 = false;
      bool2 = true;
      continue;
      this.xQd = paramm;
      bool1 = false;
      bool2 = false;
      continue;
      if (this.xQd == null) {
        this.xQd = new m();
      }
      this.xQd.Kq(paramm.xMT);
      this.xQd.fb(paramm.xMU);
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
      Log.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "item is null.");
      return;
    }
    if (paramf.xHD == f.a.xHN)
    {
      paramf = paramf.xHF;
      if (paramf == null)
      {
        Log.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "banner set is null. do nothing");
        return;
      }
      com.tencent.mm.plugin.emoji.mgr.k.a(getContext(), paramf, false);
      return;
    }
    cjb localcjb = paramf.xHE;
    if (localcjb == null)
    {
      Log.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "summary is null. do nothing");
      return;
    }
    int i = k;
    if (dCl())
    {
      i = k;
      if (j.dzN().xMI) {
        i = 1;
      }
    }
    this.xNu.li(String.valueOf(paramInt + 1));
    this.xNu.lg(localcjb.ProductID);
    bw localbw = this.xNu;
    String str;
    if (i != 0)
    {
      str = localcjb.akkC;
      localbw.lh(str);
      this.xNu.ipB = 3;
      this.xNu.bMH();
      if (!dCl()) {
        break label285;
      }
      if ((paramInt < 0) || (paramInt >= this.xNj.dyh())) {
        break label243;
      }
      i = 3;
    }
    for (;;)
    {
      str = thisActivity().getIntent().getStringExtra("to_talker_name");
      com.tencent.mm.plugin.emoji.mgr.k.a(getContext(), localcjb, i, paramf.mStatus, paramf.boE, str, 5, this.xNu);
      return;
      str = localcjb.akkA;
      break;
      label243:
      i = j;
      if (paramInt >= this.xNj.dyh())
      {
        i = j;
        if (paramInt < this.xNj.dyi() + this.xNj.dyh())
        {
          i = 19;
          continue;
          label285:
          i = 2;
        }
      }
    }
  }
  
  private void aoR(String paramString)
  {
    if (isFinishing())
    {
      Log.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[showLoadingDialog] acitivity is finished.");
      return;
    }
    FragmentActivity localFragmentActivity = thisActivity();
    getString(h.h.app_tip);
    this.pNH = com.tencent.mm.ui.base.k.a(localFragmentActivity, paramString, true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
  }
  
  private void bE(byte[] paramArrayOfByte)
  {
    int i = dBa();
    int j = this.xQc;
    if (paramArrayOfByte != null)
    {
      Log.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[refreshNetSceneGetEmotionList] request buffer %s", new Object[] { paramArrayOfByte.toString() });
      this.xQb = new o(i, paramArrayOfByte, j);
      return;
    }
    Log.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[refreshNetSceneGetEmotionList] request buffer is null.");
    this.xQb = new o(i, j);
  }
  
  private void dAZ()
  {
    com.tencent.mm.plugin.emoji.a.a.b.a(this.xNj.xHr, this);
  }
  
  private void dBc()
  {
    com.tencent.mm.kernel.h.baD().mCm.a(this.xQb, 0);
  }
  
  private void dCf()
  {
    this.xVJ = true;
    this.owx = System.currentTimeMillis();
    ehf localehf = new ehf();
    localehf.abmu = this.owx;
    this.xNu.iuE = this.owx;
    Log.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "initeData: %s", new Object[] { Long.valueOf(localehf.abmu) });
    try
    {
      this.xPR = localehf.toByteArray();
      dCh();
      this.xQc = thisActivity().getIntent().getIntExtra("preceding_scence", 5);
      if ((dCi()) && (this.eqE != null))
      {
        this.eqE.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(109140);
            EmojiStoreV2BaseFragment.this.oe(false);
            AppMethodBeat.o(109140);
          }
        }, 3000L);
        MMHandlerThread.postToMainThreadDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(109141);
            EmojiStoreV2BaseFragment.this.dCg();
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
        oe(true);
      }
    }
  }
  
  private void dCh()
  {
    this.xQe = new r();
    this.xQe.xNl = thisActivity();
    this.xQe.xNm = this;
    this.xQe.xNj = this.xNj;
    if (dCl()) {}
    for (this.xQe.xNn = 1;; this.xQe.xNn = 2)
    {
      this.xQe.xNq = this;
      return;
    }
  }
  
  private boolean dCi()
  {
    boolean bool2 = false;
    gog localgog = com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adjx.azj(dBa());
    m localm = o.c(localgog);
    int j = dBa();
    int i;
    boolean bool1;
    label136:
    int k;
    if (localgog == null)
    {
      i = 0;
      Log.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "load cache type: %d, size: %d ", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      bool1 = bool2;
      if (localm != null)
      {
        bool1 = bool2;
        if (localm.xMU.size() > 0)
        {
          this.xQk = true;
          this.bEx.setVisibility(8);
          this.xPM.setVisibility(0);
          a(this.xPP, localm);
          if (localgog == null) {
            break label240;
          }
          if (localgog.akle != null) {
            break label228;
          }
          i = 0;
          k = localgog.aklb;
          j = localgog.aklc;
        }
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "load cache hotcount:%d type:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(dBa()) });
      if ((this.xNj != null) && (dCl()))
      {
        this.xNj.JZ(i + k);
        this.xNj.Ka(j);
      }
      dAZ();
      bool1 = true;
      return bool1;
      i = localgog.Zve;
      break;
      label228:
      i = localgog.akle.size();
      break label136;
      label240:
      j = 0;
      k = 0;
      i = 0;
    }
  }
  
  private static boolean dCj()
  {
    ((Long)com.tencent.mm.kernel.h.baE().ban().get(at.a.acHZ, Long.valueOf(0L))).longValue();
    return true;
  }
  
  private void dCk()
  {
    if (this.xQd == null)
    {
      Log.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "update store ui header failed. ");
      return;
    }
    this.xQl = ((LinkedList)this.xQd.xMW);
    this.xQm = ((LinkedList)this.xQd.xMX);
    if (this.xQl != null) {
      this.xVE.r(this.xQl, this.xQm);
    }
    for (;;)
    {
      int i = this.xVF.spanCount;
      if (this.xVG.booleanValue())
      {
        this.xVD.KD(i);
        this.xVG = Boolean.FALSE;
      }
      if (this.xVE.getItemCount() != 0) {
        break;
      }
      this.mListView.removeHeaderView(this.xVC);
      if (getBounceView() == null) {
        break;
      }
      getBounceView().setStart2EndBgColor(getResources().getColor(h.b.white));
      return;
      if (this.xQd.xMV != null)
      {
        this.xQl = new LinkedList();
        this.xQl.add(this.xQd.xMV);
        this.xVE.r(this.xQl, this.xQm);
      }
    }
  }
  
  private void f(final gog paramgog)
  {
    if (this.xPP == -1) {
      com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
      {
        public final void run()
        {
          int j = 0;
          AppMethodBeat.i(109142);
          int i;
          if (paramgog != null)
          {
            if (paramgog != null) {
              break label95;
            }
            i = 0;
            if (paramgog != null) {
              break label106;
            }
          }
          for (;;)
          {
            Log.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "jacks save EmoijStoreUI Cache: list:%d, size: %d, type: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(EmojiStoreV2BaseFragment.this.dBa()) });
            com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adjx.a(EmojiStoreV2BaseFragment.this.dBa(), paramgog);
            AppMethodBeat.o(109142);
            return;
            label95:
            i = paramgog.Zve;
            break;
            label106:
            if (paramgog.YGU != null) {
              j = paramgog.YGU.computeSize();
            }
          }
        }
      });
    }
  }
  
  private void of(boolean paramBoolean)
  {
    if (this.szX) {
      Log.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "isLoading");
    }
    do
    {
      return;
      this.szX = true;
      if (paramBoolean) {
        this.xPQ.setVisibility(0);
      }
      bE(this.xPR);
      dBc();
      Log.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[startLoadRemoteEmoji] doScene GetEmotionListNetScene");
    } while (paramBoolean);
    aoR(getString(h.h.app_waiting));
  }
  
  public final void Kf(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= ((com.tencent.mm.plugin.emoji.a.h)this.xNj).dyl())) {
      return;
    }
    a(this.xNj.Kd(paramInt), paramInt);
  }
  
  public final void a(com.tencent.mm.plugin.emoji.a.a parama)
  {
    if (parama.dxZ() == 9) {
      aoR(getString(h.h.app_uninstalling));
    }
    this.xQe.xNu = this.xNu;
    r localr = this.xQe;
    boolean bool;
    if ((dCl()) && (j.dzN().xMI))
    {
      bool = true;
      localr.xNv = bool;
      if (!dCl()) {
        break label168;
      }
      if ((parama.mPosition < 0) || (parama.mPosition >= this.xNj.dyh())) {
        break label109;
      }
      this.xQe.xNn = 3;
    }
    label168:
    for (;;)
    {
      this.xQe.a(parama);
      return;
      bool = false;
      break;
      label109:
      if ((parama.mPosition >= this.xNj.dyh()) && (parama.mPosition < this.xNj.dyi() + this.xNj.dyh()))
      {
        this.xQe.xNn = 19;
      }
      else
      {
        this.xQe.xNn = 1;
        continue;
        this.xQe.xNn = 2;
      }
    }
  }
  
  public final void ac(ArrayList<w> paramArrayList)
  {
    Log.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "google [onQueryFinish]");
    if (this.xNj == null) {
      return;
    }
    if (this.eqE != null) {
      this.eqE.sendEmptyMessageDelayed(131074, 50L);
    }
    com.tencent.mm.plugin.emoji.a.a.b.a(paramArrayList, this.xNj.xHr);
  }
  
  protected void b(int paramInt1, int paramInt2, p paramp)
  {
    this.szX = false;
    this.xPQ.setVisibility(8);
    if ((paramInt1 == 0) || (paramInt1 == 4))
    {
      paramInt1 = 1;
      if (paramInt1 == 0) {
        break label192;
      }
      this.bEx.setVisibility(8);
      this.xPM.setVisibility(0);
      localObject = (o)paramp;
      paramp = o.c(((o)localObject).dAF());
      this.xPR = ((o)localObject).xOH;
      if (paramInt2 != 0) {
        break label107;
      }
      localObject = ((o)localObject).dAF();
      a(this.xPP, paramp);
      f((gog)localObject);
      this.xPP = 0;
    }
    label107:
    while (this.xQk)
    {
      Object localObject;
      return;
      paramInt1 = 0;
      break;
      if (paramInt2 == 2)
      {
        localObject = ((o)localObject).dAF();
        a(this.xPP, paramp);
        dAZ();
        f((gog)localObject);
        this.xPP = 2;
        return;
      }
      if (paramInt2 == 3)
      {
        a(this.xPP, paramp);
        this.xPP = 1;
        return;
      }
      this.bEx.setVisibility(0);
      this.xPM.setVisibility(8);
      this.xPN.setText(h.h.emoji_store_load_failed);
      return;
    }
    label192:
    this.bEx.setVisibility(0);
    this.xPM.setVisibility(8);
    this.xPN.setText(h.h.emoji_store_load_failed_network);
  }
  
  public final void d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.xQj = new com.tencent.mm.plugin.emoji.e.h(paramString1, paramString2, paramString3, null, paramString5);
    com.tencent.mm.kernel.h.baD().mCm.a(this.xQj, 0);
  }
  
  public abstract com.tencent.mm.plugin.emoji.a.a.a dAT();
  
  public final void dAg()
  {
    this.xPR = null;
    this.xPP = -1;
    of(false);
  }
  
  public abstract int dBa();
  
  protected void dCg() {}
  
  public abstract boolean dCl();
  
  public final void dCm()
  {
    if ((this.mListView != null) && (this.xNj != null) && (dCl())) {
      this.xNj.refreshView();
    }
  }
  
  public final boolean dso()
  {
    Log.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[onBottomLoadData] startLoadRemoteEmoji.");
    of(true);
    return true;
  }
  
  public final boolean dsp()
  {
    return false;
  }
  
  public final boolean dsq()
  {
    return false;
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public final void m(Message paramMessage)
  {
    if (this.eqE != null) {
      this.eqE.sendMessage(paramMessage);
    }
  }
  
  public final void oe(boolean paramBoolean)
  {
    Log.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "loadNetWork force:%b isNeedToRefresh:%b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(dCj()) });
    if ((paramBoolean) || (dCj()))
    {
      bE(this.xPR);
      dBc();
    }
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    Log.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onActivityCreated");
    super.onActivityCreated(paramBundle);
    this.xVK = true;
    this.xNj = dAT();
    this.xNj.xHs = this;
    this.bEx = findViewById(h.e.empty);
    this.xPN = ((TextView)this.bEx.findViewById(h.e.empty_content));
    this.xPQ = getActivityLayoutInflater().inflate(h.f.emoji_store_load_more, null);
    this.xPQ.setVisibility(8);
    int i = com.tencent.mm.view.d.e(getContext(), 12.0F);
    paramBundle = new EmojiStoreV3BannerView.a('\000');
    paramBundle.ybl = true;
    paramBundle.ybo = i;
    paramBundle.loop = true;
    paramBundle.yaY = i;
    paramBundle.ybm = 5000L;
    i = com.tencent.mm.view.d.e(getContext(), 19.040001F);
    int j = com.tencent.mm.view.d.e(getContext(), 24.0F);
    int k = com.tencent.mm.view.d.e(getContext(), 176.0F);
    this.xVC = af.mU(getContext()).inflate(h.f.emoji_store_v3_banner_header, null, false);
    this.xVC.setBackgroundResource(h.b.BW_93);
    this.xVD = ((EmojiStoreV3BannerView)this.xVC.findViewById(h.e.emoji_store_header_banner));
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, k);
    localLayoutParams.setMargins(0, i, 0, j);
    this.xVD.setLayoutParams(localLayoutParams);
    this.xVE = this.xVD.dCW();
    this.xVD.a(paramBundle, this.xVE);
    this.xVF = new com.tencent.mm.plugin.emoji.ui.v3.a.b();
    this.mListView = ((ListView)findViewById(16908298));
    this.mListView.addHeaderView(this.xVC);
    if (!dCl())
    {
      this.xVH = new EmojiStoreV2HotBarView(getContext());
      this.xVH.setDesignerEmojiViewVisibility(8);
      this.xVH.setDesignerCatalogViewPadding(false);
      this.mListView.addHeaderView(this.xVH);
    }
    this.mListView.addFooterView(this.xPQ);
    this.mListView.setAdapter(this.xNj);
    if (dCl()) {
      this.mListView.setOnItemClickListener(this);
    }
    for (;;)
    {
      this.mListView.setOnScrollListener(this);
      this.mListView.setLongClickable(false);
      this.mListView.setOnTouchListener(new EmojiStoreV2BaseFragment.7(this));
      this.xNj.xHq = this.mListView;
      this.xPM = ((MMPullDownView)findViewById(h.e.load_more_pull_view));
      if (this.xPM != null)
      {
        this.xPM.setTopViewVisible(false);
        this.xPM.setAtTopCallBack(this);
        this.xPM.setOnBottomLoadDataListener(this);
        this.xPM.setAtBottomCallBack(this);
        this.xPM.setBottomViewVisible(false);
        this.xPM.setIsBottomShowAll(false);
        this.xPM.setIsReturnSuperDispatchWhenCancel(true);
      }
      if (this.xVI) {
        dCf();
      }
      return;
      ((com.tencent.mm.plugin.emoji.a.h)this.xNj).xHa = this;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Log.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onActivityResult . requestCode:" + paramInt1 + "  resultCode:" + paramInt2);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.xQe != null)
    {
      this.xQe.onActivityResult(paramInt1, paramInt2, paramIntent);
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
    if (this.xVD != null) {
      this.xVD.requestLayout();
    }
    setRequestedOrientation(1);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setRequestedOrientation(1);
    if ((EmojiLogic.bBX()) || (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yRM, 0) == 0))
    {
      this.mActionBar = com.tencent.mm.ui.widget.d.c(((AppCompatActivity)thisActivity()).getSupportActionBar());
      paramBundle = af.mU(getContext()).inflate(h.f.actionbar_custom_area_center, null);
      this.mActionBarHelper = new com.tencent.mm.ui.b(paramBundle);
      paramBundle.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      this.mActionBar.setLogo(new ColorDrawable(getResources().getColor(17170445)));
      this.mActionBar.x(false);
      this.mActionBar.w(false);
      this.mActionBar.v(false);
      this.mActionBar.y(true);
      this.mActionBar.setCustomView(paramBundle);
      this.mActionBar.show();
      paramBundle = this.mActionBarHelper;
      int i = h.h.emoji_store;
      paramBundle.pJJ.setText(i);
      if (com.tencent.mm.ui.a.jhB()) {
        break label320;
      }
      if (com.tencent.mm.cd.a.mp(paramBundle.pJJ.getContext()))
      {
        TextView localTextView = paramBundle.pJJ;
        float f = com.tencent.mm.cd.a.bs(paramBundle.pJJ.getContext(), a.e.ActionBarTextSize);
        localTextView.setTextSize(0, com.tencent.mm.cd.a.jO(paramBundle.pJJ.getContext()) * f);
      }
    }
    for (;;)
    {
      this.mActionBarHelper.setClickListener(new EmojiStoreV2BaseFragment.5(this));
      showOptionMenu(true);
      addIconOptionMenu(0, h.g.actionbar_setting_icon, new EmojiStoreV2BaseFragment.6(this));
      this.xQg.alive();
      com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adjv.add(this);
      if (getBounceView() != null) {
        getBounceView().setStart2EndBgColor(getResources().getColor(h.b.BW_93));
      }
      return;
      label320:
      com.tencent.mm.ui.a.v(paramBundle.pJJ, a.e.ActionBarTextSize);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    Log.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onCreateView");
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    setHasOptionsMenu(false);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Log.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onDestroy");
    if (this.xNj != null)
    {
      this.xNj.clear();
      this.xNj = null;
    }
    if (this.xVE != null)
    {
      com.tencent.mm.plugin.emoji.ui.v3.banner.a locala = this.xVE;
      Log.i(locala.TAG, "clear");
      locala.yaU.clear();
      locala.yaV.clear();
      locala.yaW.ybz = null;
    }
    this.xQg.dead();
    com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adjv.remove(this);
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
    localb.cH(paramAdapterView);
    localb.cH(paramView);
    localb.sc(paramInt);
    localb.hB(paramLong);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2BaseFragment", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
    paramInt -= this.mListView.getHeaderViewsCount();
    if ((paramInt < 0) || (paramInt >= this.xNj.getCount()))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2BaseFragment", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      return;
    }
    paramAdapterView = this.xNj.Kd(paramInt);
    a(paramAdapterView, paramInt);
    if ((dCl()) && (this.xNj.dyi() > 0) && (paramInt >= this.xNj.dyh()) && (paramInt < this.xNj.dyh() + this.xNj.dyi()) && (paramAdapterView.xHE != null)) {
      com.tencent.mm.plugin.report.service.h.OAn.b(13223, new Object[] { Integer.valueOf(1), paramAdapterView.xHE.ProductID, paramAdapterView.xHE.Zul, Integer.valueOf(1), Integer.valueOf(0) });
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2BaseFragment", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
  }
  
  public void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals("delete_group")) && (this.eqE != null)) {
      this.eqE.sendEmptyMessageDelayed(131074, 50L);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    com.tencent.mm.kernel.h.baD().mCm.b(411, this);
    com.tencent.mm.kernel.h.baD().mCm.b(423, this);
    Log.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onPause");
  }
  
  public void onResume()
  {
    super.onResume();
    Log.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onResume");
    com.tencent.mm.kernel.h.baD().mCm.a(411, this);
    com.tencent.mm.kernel.h.baD().mCm.a(423, this);
    if (this.xVI)
    {
      if ((this.xNj != null) && (this.xNj.xHr != null))
      {
        this.xNj.xHr.dyn();
        this.xNj.refreshView();
      }
      if (((Boolean)com.tencent.mm.kernel.h.baE().ban().d(208900, Boolean.FALSE)).booleanValue())
      {
        dAg();
        com.tencent.mm.kernel.h.baE().ban().B(208900, Boolean.FALSE);
      }
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    Log.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onSceneEnd errType:%d,errCode:%d,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((this.pNH != null) && (this.pNH.isShowing())) {
      this.pNH.dismiss();
    }
    int i3 = paramp.getType();
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
      if ((paramp instanceof o))
      {
        paramString = (o)paramp;
        if ((paramString == null) || (paramString.mType != dBa())) {
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
          if (paramString.dAF() != null)
          {
            i = m;
            if (this.xNj.dyj() <= 0)
            {
              i = m;
              if (dCl()) {
                if (paramString.dAF().akle != null) {
                  break label474;
                }
              }
            }
          }
        }
        label474:
        for (i = 0;; i = paramString.dAF().akle.size())
        {
          this.xNj.Kb(i);
          j = paramString.dAF().aklb;
          k = paramString.dAF().aklc;
          Log.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onSceneEnd setSize:%d hotcount:%d recentHotCount:%d type:%d getSceneType:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i3), Integer.valueOf(paramString.mType) });
          if ((this.xNj != null) && (this.xNj.dyi() <= 0) && (dCl()))
          {
            com.tencent.mm.plugin.emoji.a.a.a locala = this.xNj;
            locala.JZ(j + locala.dyj());
            this.xNj.Ka(k);
          }
          b(paramInt1, paramInt2, paramp);
          if (!dCl()) {
            break;
          }
          if ((paramString.dAF() == null) || (paramString.dAF().akle == null) || (paramString.dAF().akle.size() <= 0)) {
            break label489;
          }
          paramInt1 = 0;
          while (paramInt1 < paramString.dAF().akle.size())
          {
            com.tencent.mm.plugin.report.service.h.OAn.b(13223, new Object[] { Integer.valueOf(0), Integer.valueOf(((anj)paramString.dAF().akle.get(paramInt1)).hjP), ((anj)paramString.dAF().akle.get(paramInt1)).hAP, Integer.valueOf(0) });
            paramInt1 += 1;
          }
        }
        label489:
        if ((paramString.dAF().aklc <= 0) || (paramString.dAF().Zvf == null) || (paramString.dAF().Zvf.size() <= paramString.dAF().aklb + paramString.dAF().aklc)) {
          break;
        }
        paramInt1 = 0;
        while (paramInt1 < paramString.dAF().aklc)
        {
          com.tencent.mm.plugin.report.service.h.OAn.b(13223, new Object[] { Integer.valueOf(0), ((cjb)paramString.dAF().Zvf.get(paramString.dAF().aklb + paramInt1)).ProductID, ((cjb)paramString.dAF().Zvf.get(paramString.dAF().aklb + paramInt1)).Zul, Integer.valueOf(1) });
          paramInt1 += 1;
        }
      }
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1)) {
      if ((this.xPP == 0) || (this.szX)) {
        Log.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "No More List.");
      }
    }
    while (paramInt != 0)
    {
      return;
      of(true);
      Log.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[onScrollStateChanged] startLoadRemoteEmoji.");
    }
    dCg();
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
    this.xVI = paramBoolean;
    if ((!this.xVJ) && (this.xVK)) {
      dCf();
    }
    do
    {
      while (this.xVI)
      {
        if (this.eqE != null) {
          this.eqE.sendEmptyMessageDelayed(131077, 0L);
        }
        return;
        if (paramBoolean) {
          dCg();
        }
      }
      if (this.eqE != null) {
        this.eqE.removeMessages(131077);
      }
    } while (this.xVD == null);
    Log.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "stopPlayHeader");
    this.xVD.dCV();
  }
  
  public boolean supportNavigationSwipeBack()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2BaseFragment
 * JD-Core Version:    0.7.0.1
 */