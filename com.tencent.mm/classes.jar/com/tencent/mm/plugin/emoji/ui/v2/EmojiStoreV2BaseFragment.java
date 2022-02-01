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
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.e;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.du;
import com.tencent.mm.f.b.a.ba;
import com.tencent.mm.plugin.emoji.a.a.f.a;
import com.tencent.mm.plugin.emoji.a.h.a;
import com.tencent.mm.plugin.emoji.e.k;
import com.tencent.mm.plugin.emoji.i.b;
import com.tencent.mm.plugin.emoji.i.e;
import com.tencent.mm.plugin.emoji.i.f;
import com.tencent.mm.plugin.emoji.i.g;
import com.tencent.mm.plugin.emoji.i.h;
import com.tencent.mm.plugin.emoji.model.j;
import com.tencent.mm.plugin.emoji.model.l;
import com.tencent.mm.plugin.emoji.model.o.a;
import com.tencent.mm.plugin.emoji.model.o.b;
import com.tencent.mm.plugin.emoji.model.p;
import com.tencent.mm.plugin.emoji.ui.EmojiStoreVpHeader;
import com.tencent.mm.pluginsdk.model.m.a;
import com.tencent.mm.pluginsdk.model.u;
import com.tencent.mm.protocal.protobuf.aju;
import com.tencent.mm.protocal.protobuf.ajw;
import com.tencent.mm.protocal.protobuf.akh;
import com.tencent.mm.protocal.protobuf.buh;
import com.tencent.mm.protocal.protobuf.don;
import com.tencent.mm.protocal.protobuf.eae;
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
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.c;
import com.tencent.mm.ui.base.MMPullDownView.d;
import com.tencent.mm.ui.base.MMPullDownView.e;
import com.tencent.mm.ui.widget.d;
import com.tencent.mm.ui.widget.pulldown.e;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public abstract class EmojiStoreV2BaseFragment
  extends MMFragment
  implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener, i, h.a, o.a, o.b, m.a, MStorage.IOnStorageChange, MMPullDownView.c, MMPullDownView.d, MMPullDownView.e
{
  private View Xd;
  private MMHandler cyl = new MMHandler()
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
        if (localEmojiStoreV2BaseFragment.uEH != null)
        {
          localEmojiStoreV2BaseFragment.uEH.notifyDataSetChanged();
          AppMethodBeat.o(109135);
          return;
          if ((localEmojiStoreV2BaseFragment.uEH == null) || (paramAnonymousMessage.getData() == null))
          {
            AppMethodBeat.o(109135);
            return;
          }
          String str = paramAnonymousMessage.getData().getString("product_id");
          if (str != null)
          {
            int i = paramAnonymousMessage.getData().getInt("progress");
            localEmojiStoreV2BaseFragment.uEH.dx(str, i);
            AppMethodBeat.o(109135);
            return;
            if ((localEmojiStoreV2BaseFragment.uEH == null) || (paramAnonymousMessage.getData() == null))
            {
              AppMethodBeat.o(109135);
              return;
            }
            str = paramAnonymousMessage.getData().getString("product_id");
            if (str != null)
            {
              i = paramAnonymousMessage.getData().getInt("status");
              localEmojiStoreV2BaseFragment.uEH.dw(str, i);
              AppMethodBeat.o(109135);
              return;
              if (localEmojiStoreV2BaseFragment.uHd != null) {
                localEmojiStoreV2BaseFragment.uHd.cWu();
              }
            }
          }
        }
      }
    }
  };
  protected long lER;
  private ActionBar mActionBar;
  private com.tencent.mm.ui.b mActionBarHelper;
  protected ListView mListView;
  private ProgressDialog mRa;
  private boolean puR;
  com.tencent.mm.plugin.emoji.a.a.a uEH;
  protected ba uES = new ba();
  private IListener uHA = new IListener() {};
  private com.tencent.mm.plugin.emoji.f.h uHB;
  private boolean uHC = false;
  private LinkedList<aju> uHD = new LinkedList();
  private LinkedList<ajw> uHE = new LinkedList();
  EmojiStoreVpHeader uHd;
  private MMPullDownView uHg;
  private TextView uHh;
  private int uHj = -1;
  private View uHk;
  private byte[] uHl;
  private final int uHp = 131074;
  private final int uHq = 131075;
  private final int uHr = 131076;
  private final String uHs = "product_id";
  private final String uHt = "progress";
  private final String uHu = "status";
  private com.tencent.mm.plugin.emoji.f.o uHv;
  private int uHw;
  private l uHx;
  private com.tencent.mm.plugin.emoji.model.o uHy;
  private final int uMY = 131077;
  public EmojiStoreV2HotBarView uMZ;
  private boolean uNa = false;
  private boolean uNb = false;
  private boolean uNc = false;
  private MenuItem.OnMenuItemClickListener uNd = new MenuItem.OnMenuItemClickListener()
  {
    public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
    {
      AppMethodBeat.i(109137);
      EmojiStoreV2BaseFragment.this.thisActivity().finish();
      AppMethodBeat.o(109137);
      return false;
    }
  };
  
  private void O(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.uHx != null) && (paramBoolean1))
    {
      if (paramBoolean2) {
        cWF();
      }
      if (this.uEH != null) {
        this.uEH.b(this.uHx);
      }
    }
  }
  
  private void a(int paramInt, l paraml)
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
      if (this.uHx != null) {
        this.uHx.cUI();
      }
      O(bool2, bool1);
      return;
      this.uHx = paraml;
      bool1 = true;
      bool2 = true;
      continue;
      this.uHx = paraml;
      bool1 = false;
      bool2 = true;
      continue;
      this.uHx = paraml;
      bool1 = false;
      bool2 = false;
      continue;
      if (this.uHx == null) {
        this.uHx = new l();
      }
      this.uHx.JF(paraml.uEw);
      this.uHx.df(paraml.uEx);
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
    if (paramf.uAZ == f.a.uBi)
    {
      paramf = paramf.uBb;
      if (paramf == null)
      {
        Log.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "banner set is null. do nothing");
        return;
      }
      k.a(getContext(), paramf, false);
      return;
    }
    akh localakh = paramf.uBa;
    if (localakh == null)
    {
      Log.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "summary is null. do nothing");
      return;
    }
    int i = k;
    if (cWG())
    {
      i = k;
      if (j.cUG().uEr) {
        i = 1;
      }
    }
    this.uES.jA(String.valueOf(paramInt + 1));
    this.uES.jy(localakh.ProductID);
    ba localba = this.uES;
    String str;
    if (i != 0)
    {
      str = localakh.VHR;
      localba.jz(str);
      this.uES.gly = 3;
      this.uES.bpa();
      if (!cWG()) {
        break label283;
      }
      if ((paramInt < 0) || (paramInt >= this.uEH.cTM())) {
        break label241;
      }
      i = 3;
    }
    for (;;)
    {
      str = thisActivity().getIntent().getStringExtra("to_talker_name");
      k.a(getContext(), localakh, i, paramf.mStatus, paramf.IB, str, 5, this.uES);
      return;
      str = localakh.VHP;
      break;
      label241:
      i = j;
      if (paramInt >= this.uEH.cTM())
      {
        i = j;
        if (paramInt < this.uEH.cTN() + this.uEH.cTM())
        {
          i = 19;
          continue;
          label283:
          i = 2;
        }
      }
    }
  }
  
  private void auS(String paramString)
  {
    if (isFinishing())
    {
      Log.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[showLoadingDialog] acitivity is finished.");
      return;
    }
    FragmentActivity localFragmentActivity = thisActivity();
    getString(i.h.app_tip);
    this.mRa = com.tencent.mm.ui.base.h.a(localFragmentActivity, paramString, true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
  }
  
  private void bE(byte[] paramArrayOfByte)
  {
    int i = cVA();
    int j = this.uHw;
    if (paramArrayOfByte != null)
    {
      Log.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[refreshNetSceneGetEmotionList] request buffer %s", new Object[] { paramArrayOfByte.toString() });
      this.uHv = new com.tencent.mm.plugin.emoji.f.o(i, paramArrayOfByte, j);
      return;
    }
    Log.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[refreshNetSceneGetEmotionList] request buffer is null.");
    this.uHv = new com.tencent.mm.plugin.emoji.f.o(i, j);
  }
  
  private void cVC()
  {
    com.tencent.mm.kernel.h.aHF().kcd.a(this.uHv, 0);
  }
  
  private void cVz()
  {
    com.tencent.mm.plugin.emoji.a.a.b.a(this.uEH.uAO, this);
  }
  
  private void cWA()
  {
    this.uNb = true;
    this.lER = System.currentTimeMillis();
    don localdon = new don();
    localdon.TVG = this.lER;
    this.uES.glw = this.lER;
    Log.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "initeData: %s", new Object[] { Long.valueOf(localdon.TVG) });
    try
    {
      this.uHl = localdon.toByteArray();
      cWC();
      this.uHw = thisActivity().getIntent().getIntExtra("preceding_scence", 5);
      if ((cWD()) && (this.cyl != null))
      {
        this.cyl.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(109140);
            EmojiStoreV2BaseFragment.this.mH(false);
            AppMethodBeat.o(109140);
          }
        }, 3000L);
        MMHandlerThread.postToMainThreadDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(109141);
            EmojiStoreV2BaseFragment.this.cWB();
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
        mH(true);
      }
    }
  }
  
  private void cWC()
  {
    this.uHy = new com.tencent.mm.plugin.emoji.model.o();
    this.uHy.uEJ = thisActivity();
    this.uHy.uEK = this;
    this.uHy.uEH = this.uEH;
    if (cWG()) {}
    for (this.uHy.uEL = 1;; this.uHy.uEL = 2)
    {
      this.uHy.uEO = this;
      return;
    }
  }
  
  private boolean cWD()
  {
    boolean bool2 = false;
    buh localbuh = p.getEmojiStorageMgr().VFK.asU(cVA());
    l locall = com.tencent.mm.plugin.emoji.f.o.a(localbuh);
    int j = cVA();
    int i;
    boolean bool1;
    label136:
    int k;
    if (localbuh == null)
    {
      i = 0;
      Log.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "load cache type: %d, size: %d ", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      bool1 = bool2;
      if (locall != null)
      {
        bool1 = bool2;
        if (locall.uEx.size() > 0)
        {
          this.uHC = true;
          this.Xd.setVisibility(8);
          this.uHg.setVisibility(0);
          a(this.uHj, locall);
          if (localbuh == null) {
            break label240;
          }
          if (localbuh.VIe != null) {
            break label228;
          }
          i = 0;
          k = localbuh.VIb;
          j = localbuh.VIc;
        }
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "load cache hotcount:%d type:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(cVA()) });
      if ((this.uEH != null) && (cWG()))
      {
        this.uEH.Js(i + k);
        this.uEH.Jt(j);
      }
      cVz();
      bool1 = true;
      return bool1;
      i = localbuh.VHV;
      break;
      label228:
      i = localbuh.VIe.size();
      break label136;
      label240:
      j = 0;
      k = 0;
      i = 0;
    }
  }
  
  private static boolean cWE()
  {
    ((Long)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VgK, Long.valueOf(0L))).longValue();
    return true;
  }
  
  private void cWF()
  {
    if (this.uHx == null) {
      Log.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "update store ui header failed. ");
    }
    do
    {
      return;
      this.uHD = ((LinkedList)this.uHx.uEz);
      this.uHE = ((LinkedList)this.uHx.uEA);
      if (this.uHD != null)
      {
        this.uHd.d(this.uHD, this.uHE);
        return;
      }
    } while (this.uHx.uEy == null);
    this.uHD = new LinkedList();
    this.uHD.add(this.uHx.uEy);
    this.uHd.d(this.uHD, this.uHE);
  }
  
  private void d(final buh parambuh)
  {
    if (this.uHj == -1) {
      com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
      {
        public final void run()
        {
          int j = 0;
          AppMethodBeat.i(109142);
          int i;
          if (parambuh != null)
          {
            if (parambuh != null) {
              break label95;
            }
            i = 0;
            if (parambuh != null) {
              break label106;
            }
          }
          for (;;)
          {
            Log.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "jacks save EmoijStoreUI Cache: list:%d, size: %d, type: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(EmojiStoreV2BaseFragment.this.cVA()) });
            p.getEmojiStorageMgr().VFK.a(EmojiStoreV2BaseFragment.this.cVA(), parambuh);
            AppMethodBeat.o(109142);
            return;
            label95:
            i = parambuh.VHV;
            break;
            label106:
            if (parambuh.RJA != null) {
              j = parambuh.RJA.computeSize();
            }
          }
        }
      });
    }
  }
  
  private void mI(boolean paramBoolean)
  {
    if (this.puR) {
      Log.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "isLoading");
    }
    do
    {
      return;
      this.puR = true;
      if (paramBoolean) {
        this.uHk.setVisibility(0);
      }
      bE(this.uHl);
      cVC();
      Log.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[startLoadRemoteEmoji] doScene GetEmotionListNetScene");
    } while (paramBoolean);
    auS(getString(i.h.app_waiting));
  }
  
  public final void Jx(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= ((com.tencent.mm.plugin.emoji.a.h)this.uEH).cTQ())) {
      return;
    }
    a(this.uEH.Jv(paramInt), paramInt);
  }
  
  public final void Y(ArrayList<u> paramArrayList)
  {
    Log.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "google [onQueryFinish]");
    if (this.uEH == null) {
      return;
    }
    if (this.cyl != null) {
      this.cyl.sendEmptyMessageDelayed(131074, 50L);
    }
    com.tencent.mm.plugin.emoji.a.a.b.a(paramArrayList, this.uEH.uAO);
  }
  
  public final void a(com.tencent.mm.plugin.emoji.a.a parama)
  {
    if (parama.cTE() == 9) {
      auS(getString(i.h.app_uninstalling));
    }
    this.uHy.uES = this.uES;
    com.tencent.mm.plugin.emoji.model.o localo = this.uHy;
    boolean bool;
    if ((cWG()) && (j.cUG().uEr))
    {
      bool = true;
      localo.uET = bool;
      if (!cWG()) {
        break label168;
      }
      if ((parama.mPosition < 0) || (parama.mPosition >= this.uEH.cTM())) {
        break label109;
      }
      this.uHy.uEL = 3;
    }
    label168:
    for (;;)
    {
      this.uHy.a(parama);
      return;
      bool = false;
      break;
      label109:
      if ((parama.mPosition >= this.uEH.cTM()) && (parama.mPosition < this.uEH.cTN() + this.uEH.cTM()))
      {
        this.uHy.uEL = 19;
      }
      else
      {
        this.uHy.uEL = 1;
        continue;
        this.uHy.uEL = 2;
      }
    }
  }
  
  protected void b(int paramInt1, int paramInt2, q paramq)
  {
    this.puR = false;
    this.uHk.setVisibility(8);
    if ((paramInt1 == 0) || (paramInt1 == 4))
    {
      paramInt1 = 1;
      if (paramInt1 == 0) {
        break label192;
      }
      this.Xd.setVisibility(8);
      this.uHg.setVisibility(0);
      localObject = (com.tencent.mm.plugin.emoji.f.o)paramq;
      paramq = com.tencent.mm.plugin.emoji.f.o.a(((com.tencent.mm.plugin.emoji.f.o)localObject).cVg());
      this.uHl = ((com.tencent.mm.plugin.emoji.f.o)localObject).uGe;
      if (paramInt2 != 0) {
        break label107;
      }
      localObject = ((com.tencent.mm.plugin.emoji.f.o)localObject).cVg();
      a(this.uHj, paramq);
      d((buh)localObject);
      this.uHj = 0;
    }
    label107:
    while (this.uHC)
    {
      Object localObject;
      return;
      paramInt1 = 0;
      break;
      if (paramInt2 == 2)
      {
        localObject = ((com.tencent.mm.plugin.emoji.f.o)localObject).cVg();
        a(this.uHj, paramq);
        cVz();
        d((buh)localObject);
        this.uHj = 2;
        return;
      }
      if (paramInt2 == 3)
      {
        a(this.uHj, paramq);
        this.uHj = 1;
        return;
      }
      this.Xd.setVisibility(0);
      this.uHg.setVisibility(8);
      this.uHh.setText(i.h.emoji_store_load_failed);
      return;
    }
    label192:
    this.Xd.setVisibility(0);
    this.uHg.setVisibility(8);
    this.uHh.setText(i.h.emoji_store_load_failed_network);
  }
  
  public final boolean cOJ()
  {
    Log.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[onBottomLoadData] startLoadRemoteEmoji.");
    mI(true);
    return true;
  }
  
  public final boolean cOK()
  {
    return false;
  }
  
  public final boolean cOL()
  {
    return false;
  }
  
  public final void cUJ()
  {
    this.uHl = null;
    this.uHj = -1;
    mI(false);
  }
  
  public abstract int cVA();
  
  public abstract com.tencent.mm.plugin.emoji.a.a.a cVt();
  
  protected void cWB() {}
  
  public abstract boolean cWG();
  
  public final void cWH()
  {
    if ((this.mListView != null) && (this.uEH != null) && (cWG())) {
      this.uEH.refreshView();
    }
  }
  
  public final void d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.uHB = new com.tencent.mm.plugin.emoji.f.h(paramString1, paramString2, paramString3, null, paramString5);
    com.tencent.mm.kernel.h.aHF().kcd.a(this.uHB, 0);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public final void l(Message paramMessage)
  {
    if (this.cyl != null) {
      this.cyl.sendMessage(paramMessage);
    }
  }
  
  public final void mH(boolean paramBoolean)
  {
    Log.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "loadNetWork force:%b isNeedToRefresh:%b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(cWE()) });
    if (!paramBoolean) {
      cWE();
    }
    bE(this.uHl);
    cVC();
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    Log.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onActivityCreated");
    super.onActivityCreated(paramBundle);
    this.uNc = true;
    this.uEH = cVt();
    this.uEH.uAP = this;
    this.Xd = findViewById(i.e.empty);
    this.uHh = ((TextView)this.Xd.findViewById(i.e.empty_content));
    this.uHk = getActivityLayoutInflater().inflate(i.f.emoji_store_load_more, null);
    this.uHk.setVisibility(8);
    this.uHd = new EmojiStoreVpHeader(getContext());
    this.mListView = ((ListView)findViewById(16908298));
    this.mListView.addHeaderView(this.uHd);
    if (!cWG())
    {
      this.uMZ = new EmojiStoreV2HotBarView(getContext());
      this.uMZ.setDesignerEmojiViewVisibility(8);
      this.uMZ.setDesignerCatalogViewPadding(false);
      this.mListView.addHeaderView(this.uMZ);
    }
    this.mListView.addFooterView(this.uHk);
    this.mListView.setAdapter(this.uEH);
    if (cWG()) {
      this.mListView.setOnItemClickListener(this);
    }
    for (;;)
    {
      this.mListView.setOnScrollListener(this);
      this.mListView.setLongClickable(false);
      this.mListView.setOnTouchListener(new EmojiStoreV2BaseFragment.7(this));
      this.uEH.uAN = this.mListView;
      this.uHg = ((MMPullDownView)findViewById(i.e.load_more_pull_view));
      if (this.uHg != null)
      {
        this.uHg.setTopViewVisible(false);
        this.uHg.setAtTopCallBack(this);
        this.uHg.setOnBottomLoadDataListener(this);
        this.uHg.setAtBottomCallBack(this);
        this.uHg.setBottomViewVisible(false);
        this.uHg.setIsBottomShowAll(false);
        this.uHg.setIsReturnSuperDispatchWhenCancel(true);
      }
      if (this.uNa) {
        cWA();
      }
      return;
      ((com.tencent.mm.plugin.emoji.a.h)this.uEH).uAx = this;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Log.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onActivityResult . requestCode:" + paramInt1 + "  resultCode:" + paramInt2);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.uHy != null)
    {
      this.uHy.onActivityResult(paramInt1, paramInt2, paramIntent);
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
    if (this.uHd != null) {
      this.uHd.requestLayout();
    }
    setRequestedOrientation(1);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setRequestedOrientation(1);
    this.mActionBar = d.c(((AppCompatActivity)thisActivity()).getSupportActionBar());
    paramBundle = ad.kS(getContext()).inflate(i.f.actionbar_custom_area_center, null);
    this.mActionBarHelper = new com.tencent.mm.ui.b(paramBundle);
    paramBundle.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.mActionBar.setLogo(new ColorDrawable(getResources().getColor(17170445)));
    this.mActionBar.t(false);
    this.mActionBar.s(false);
    this.mActionBar.r(false);
    this.mActionBar.u(true);
    this.mActionBar.setCustomView(paramBundle);
    this.mActionBar.show();
    paramBundle = this.mActionBarHelper;
    int i = i.h.emoji_store;
    paramBundle.mNb.setText(i);
    if (com.tencent.mm.ci.a.ko(paramBundle.mNb.getContext()))
    {
      TextView localTextView = paramBundle.mNb;
      float f = com.tencent.mm.ci.a.aZ(paramBundle.mNb.getContext(), a.e.ActionBarTextSize);
      localTextView.setTextSize(0, com.tencent.mm.ci.a.km(paramBundle.mNb.getContext()) * f);
    }
    this.mActionBarHelper.setClickListener(new EmojiStoreV2BaseFragment.5(this));
    showOptionMenu(true);
    addIconOptionMenu(0, i.g.actionbar_setting_icon, new EmojiStoreV2BaseFragment.6(this));
    EventCenter.instance.addListener(this.uHA);
    p.getEmojiStorageMgr().VFI.add(this);
    if (getBounceView() != null) {
      getBounceView().setStart2EndBgColor(getResources().getColor(i.b.white));
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
    if (this.uEH != null)
    {
      this.uEH.clear();
      this.uEH = null;
    }
    if (this.uHd != null)
    {
      this.uHd.cWv();
      this.uHd.clear();
    }
    EventCenter.instance.removeListener(this.uHA);
    p.getEmojiStorageMgr().VFI.remove(this);
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
    localb.bn(paramAdapterView);
    localb.bn(paramView);
    localb.sg(paramInt);
    localb.Fs(paramLong);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2BaseFragment", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
    paramInt -= this.mListView.getHeaderViewsCount();
    if ((paramInt < 0) || (paramInt >= this.uEH.getCount()))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2BaseFragment", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      return;
    }
    paramAdapterView = this.uEH.Jv(paramInt);
    a(paramAdapterView, paramInt);
    if ((cWG()) && (this.uEH.cTN() > 0) && (paramInt >= this.uEH.cTM()) && (paramInt < this.uEH.cTM() + this.uEH.cTN()) && (paramAdapterView.uBa != null)) {
      com.tencent.mm.plugin.report.service.h.IzE.a(13223, new Object[] { Integer.valueOf(1), paramAdapterView.uBa.ProductID, paramAdapterView.uBa.Suv, Integer.valueOf(1), Integer.valueOf(0) });
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2BaseFragment", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
  }
  
  public void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals("delete_group")) && (this.cyl != null)) {
      this.cyl.sendEmptyMessageDelayed(131074, 50L);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    com.tencent.mm.kernel.h.aHF().kcd.b(411, this);
    com.tencent.mm.kernel.h.aHF().kcd.b(423, this);
    Log.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onPause");
    if (this.uHd != null) {
      this.uHd.cWv();
    }
    if (this.cyl != null) {
      this.cyl.removeMessages(131077);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    Log.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onResume");
    com.tencent.mm.kernel.h.aHF().kcd.a(411, this);
    com.tencent.mm.kernel.h.aHF().kcd.a(423, this);
    if (this.uNa)
    {
      if (this.cyl != null) {
        this.cyl.sendEmptyMessageDelayed(131077, 4000L);
      }
      if ((this.uEH != null) && (this.uEH.uAO != null))
      {
        this.uEH.uAO.cTS();
        this.uEH.refreshView();
      }
      if (((Boolean)com.tencent.mm.kernel.h.aHG().aHp().b(208900, Boolean.FALSE)).booleanValue())
      {
        cUJ();
        com.tencent.mm.kernel.h.aHG().aHp().i(208900, Boolean.FALSE);
      }
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    Log.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onSceneEnd errType:%d,errCode:%d,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((this.mRa != null) && (this.mRa.isShowing())) {
      this.mRa.dismiss();
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
      if ((paramq instanceof com.tencent.mm.plugin.emoji.f.o))
      {
        paramString = (com.tencent.mm.plugin.emoji.f.o)paramq;
        if ((paramString == null) || (paramString.mType != cVA())) {
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
          if (paramString.cVg() != null)
          {
            i = m;
            if (this.uEH.cTO() <= 0)
            {
              i = m;
              if (cWG()) {
                if (paramString.cVg().VIe != null) {
                  break label474;
                }
              }
            }
          }
        }
        label474:
        for (i = 0;; i = paramString.cVg().VIe.size())
        {
          this.uEH.Ju(i);
          j = paramString.cVg().VIb;
          k = paramString.cVg().VIc;
          Log.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onSceneEnd setSize:%d hotcount:%d recentHotCount:%d type:%d getSceneType:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i3), Integer.valueOf(paramString.mType) });
          if ((this.uEH != null) && (this.uEH.cTN() <= 0) && (cWG()))
          {
            com.tencent.mm.plugin.emoji.a.a.a locala = this.uEH;
            locala.Js(j + locala.cTO());
            this.uEH.Jt(k);
          }
          b(paramInt1, paramInt2, paramq);
          if (!cWG()) {
            break;
          }
          if ((paramString.cVg() == null) || (paramString.cVg().VIe == null) || (paramString.cVg().VIe.size() <= 0)) {
            break label489;
          }
          paramInt1 = 0;
          while (paramInt1 < paramString.cVg().VIe.size())
          {
            com.tencent.mm.plugin.report.service.h.IzE.a(13223, new Object[] { Integer.valueOf(0), Integer.valueOf(((ajw)paramString.cVg().VIe.get(paramInt1)).ffF), ((ajw)paramString.cVg().VIe.get(paramInt1)).fwr, Integer.valueOf(0) });
            paramInt1 += 1;
          }
        }
        label489:
        if ((paramString.cVg().VIc <= 0) || (paramString.cVg().Tek == null) || (paramString.cVg().Tek.size() <= paramString.cVg().VIb + paramString.cVg().VIc)) {
          break;
        }
        paramInt1 = 0;
        while (paramInt1 < paramString.cVg().VIc)
        {
          com.tencent.mm.plugin.report.service.h.IzE.a(13223, new Object[] { Integer.valueOf(0), ((akh)paramString.cVg().Tek.get(paramString.cVg().VIb + paramInt1)).ProductID, ((akh)paramString.cVg().Tek.get(paramString.cVg().VIb + paramInt1)).Suv, Integer.valueOf(1) });
          paramInt1 += 1;
        }
      }
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1)) {
      if ((this.uHj == 0) || (this.puR)) {
        Log.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "No More List.");
      }
    }
    while (paramInt != 0)
    {
      return;
      mI(true);
      Log.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[onScrollStateChanged] startLoadRemoteEmoji.");
    }
    cWB();
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
    this.uNa = paramBoolean;
    if ((!this.uNb) && (this.uNc)) {
      cWA();
    }
    while (!paramBoolean) {
      return;
    }
    cWB();
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