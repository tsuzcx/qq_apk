package com.tencent.mm.plugin.emoji.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
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
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.a.ee;
import com.tencent.mm.autogen.mmdata.rpt.bw;
import com.tencent.mm.plugin.emoji.a.a.f.a;
import com.tencent.mm.plugin.emoji.e.o;
import com.tencent.mm.plugin.emoji.g.e;
import com.tencent.mm.plugin.emoji.h.e;
import com.tencent.mm.plugin.emoji.h.f;
import com.tencent.mm.plugin.emoji.h.h;
import com.tencent.mm.plugin.emoji.model.m;
import com.tencent.mm.plugin.emoji.model.r;
import com.tencent.mm.plugin.emoji.model.r.a;
import com.tencent.mm.plugin.emoji.model.r.b;
import com.tencent.mm.pluginsdk.model.o.a;
import com.tencent.mm.pluginsdk.model.w;
import com.tencent.mm.pluginsdk.ui.emoji.StoreBannerEmojiView;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.protocal.protobuf.anj;
import com.tencent.mm.protocal.protobuf.cjb;
import com.tencent.mm.protocal.protobuf.gog;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.bl;
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
  implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener, com.tencent.mm.am.h, r.a, r.b, o.a, MStorage.IOnStorageChange, MMPullDownView.c, MMPullDownView.d, MMPullDownView.e
{
  private static Map<String, Long> xQf;
  protected View bEx;
  public ListView mListView;
  private ProgressDialog pNH;
  private boolean szX;
  public com.tencent.mm.plugin.emoji.a.a.a xNj;
  private e xNs;
  protected EmojiStoreVpHeader xPJ;
  protected View xPK;
  protected StoreBannerEmojiView xPL;
  protected MMPullDownView xPM;
  protected TextView xPN;
  protected boolean xPO = false;
  private int xPP = -1;
  private View xPQ;
  private byte[] xPR;
  private final int xPS = 65537;
  private final int xPT = 20001;
  private final int xPU = 2002;
  protected final int xPV = 131074;
  private final int xPW = 131075;
  private final int xPX = 131076;
  private final String xPY = "product_id";
  private final String xPZ = "progress";
  private final String xQa = "status";
  private o xQb;
  private int xQc;
  private m xQd;
  protected r xQe;
  private IListener xQg;
  private boolean xQh = true;
  private boolean xQi = true;
  protected com.tencent.mm.plugin.emoji.e.h xQj;
  protected boolean xQk = false;
  private LinkedList<anh> xQl = new LinkedList();
  private LinkedList<anj> xQm = new LinkedList();
  
  private void a(int paramInt, m paramm, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = false;
    Log.d("MicroMsg.emoji.BaseEmojiStoreUI", "");
    boolean bool1 = bool2;
    switch (paramInt)
    {
    default: 
      bool1 = bool2;
    case 0: 
      if (this.xQd != null) {
        this.xQd.dzS();
      }
      a(bool1, this.xQd, paramBoolean1, paramBoolean2);
      return;
    case -1: 
      this.xQd = paramm;
    }
    for (;;)
    {
      bool1 = true;
      break;
      this.xQd = paramm;
      continue;
      if (this.xQd == null) {
        this.xQd = new m();
      }
      if (paramm != null)
      {
        this.xQd.Kq(paramm.xMT);
        this.xQd.fb(paramm.xMU);
      }
    }
  }
  
  private o bB(byte[] paramArrayOfByte)
  {
    int i = dBa();
    int j = bC(paramArrayOfByte);
    int k = dBb();
    o localo;
    if (paramArrayOfByte != null)
    {
      Log.i("MicroMsg.emoji.BaseEmojiStoreUI", "[startLoadRemoteEmoji] request buffer %s", new Object[] { paramArrayOfByte.toString() });
      localo = new o(i, paramArrayOfByte, j);
      paramArrayOfByte = localo;
      if (i == 7)
      {
        localo.xOJ = k;
        paramArrayOfByte = localo;
      }
    }
    for (;;)
    {
      paramArrayOfByte.xOK = dBi();
      this.xQb = paramArrayOfByte;
      return paramArrayOfByte;
      Log.i("MicroMsg.emoji.BaseEmojiStoreUI", "[startLoadRemoteEmoji] request buffer is null.");
      localo = new o(i, j);
      paramArrayOfByte = localo;
      if (i == 7)
      {
        localo.xOJ = k;
        paramArrayOfByte = localo;
      }
    }
  }
  
  private void d(gog paramgog)
  {
    if (this.xPP == -1)
    {
      Message localMessage = Message.obtain();
      localMessage.what = 65537;
      localMessage.obj = paramgog;
      n(localMessage);
    }
  }
  
  private void dAZ()
  {
    if (dBj()) {
      com.tencent.mm.plugin.emoji.a.a.b.a(this.xNj.xHr, this);
    }
  }
  
  private void dBc()
  {
    com.tencent.mm.kernel.h.baD().mCm.a(this.xQb, 0);
  }
  
  private void dX(String paramString, int paramInt)
  {
    Message localMessage = Message.obtain();
    localMessage.getData().putString("product_id", paramString);
    localMessage.getData().putInt("status", paramInt);
    localMessage.what = 131076;
    m(localMessage);
  }
  
  private void dY(String paramString, int paramInt)
  {
    Message localMessage = Message.obtain();
    localMessage.getData().putString("product_id", paramString);
    localMessage.getData().putInt("progress", paramInt);
    localMessage.what = 131075;
    m(localMessage);
  }
  
  protected final void R(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.szX = true;
    if (paramBoolean1) {
      this.xPQ.setVisibility(0);
    }
    bB(this.xPR);
    dBc();
    Log.i("MicroMsg.emoji.BaseEmojiStoreUI", "[startLoadRemoteEmoji] doScene GetEmotionListNetScene");
    if ((!paramBoolean1) && (!paramBoolean2)) {
      showLoadingDialog();
    }
  }
  
  protected void a(int paramInt1, int paramInt2, String paramString, o paramo)
  {
    if ((paramo != null) && (paramo.mType == dBa()))
    {
      this.szX = false;
      this.xPQ.setVisibility(8);
      paramString = null;
      try
      {
        m localm = o.c(paramo.dAF());
        paramString = localm;
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
        paramo = paramo.dAF();
        a(this.xPP, paramString, false, false);
        dAZ();
        d(paramo);
        this.xPP = 2;
        return;
        if (paramInt2 != 3) {
          break label209;
        }
        a(this.xPP, paramString, false, false);
        this.xPP = 1;
        return;
        this.bEx.setVisibility(0);
        this.xPO = true;
        if (dBa() != 7) {
          break label242;
        }
        this.xPN.setText(h.h.emoji_store_topic_empty);
        return;
        this.xPN.setText(h.h.emoji_store_load_failed);
        return;
      }
      if (paramString != null) {
        if ((paramInt1 == 0) || (paramInt1 == 4))
        {
          paramInt1 = 1;
          if (paramInt1 == 0) {
            break label253;
          }
          this.bEx.setVisibility(8);
          this.xPO = false;
          this.xPR = paramo.xOH;
          if (paramInt2 != 0) {
            break label148;
          }
          paramo = paramo.dAF();
          a(paramString, false, true);
          d(paramo);
          this.xPP = 0;
        }
      }
      label148:
      label187:
      label209:
      label242:
      label253:
      while (this.xQk) {
        return;
      }
      this.bEx.setVisibility(0);
      this.xPO = true;
      this.xPN.setText(h.h.emoji_store_load_failed_network);
      return;
    }
    paramInt2 = dBa();
    if (paramo == null) {}
    for (paramInt1 = -1;; paramInt1 = paramo.mType)
    {
      Log.i("MicroMsg.emoji.BaseEmojiStoreUI", "no some scene type. this ui type:%d callbak type:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
      return;
    }
  }
  
  public void a(int paramInt, com.tencent.mm.plugin.emoji.ui.v3.b.b paramb) {}
  
  protected void a(com.tencent.mm.plugin.emoji.a.a.f paramf, int paramInt)
  {
    if (paramf == null)
    {
      Log.i("MicroMsg.emoji.BaseEmojiStoreUI", "item is null.");
      return;
    }
    if (paramf.xHD == f.a.xHN)
    {
      paramf = paramf.xHF;
      if (paramf == null)
      {
        Log.i("MicroMsg.emoji.BaseEmojiStoreUI", "banner set is null. do nothing");
        return;
      }
      com.tencent.mm.plugin.emoji.mgr.k.a(getContext(), paramf, false);
      return;
    }
    cjb localcjb = paramf.xHE;
    if (localcjb == null)
    {
      Log.i("MicroMsg.emoji.BaseEmojiStoreUI", "summary is null. do nothing");
      return;
    }
    String str = getIntent().getStringExtra("to_talker_name");
    if (dBo())
    {
      com.tencent.mm.plugin.emoji.ui.v3.b.b localb = new com.tencent.mm.plugin.emoji.ui.v3.b.b(paramInt, localcjb.ProductID, localcjb.Zul);
      bw localbw = b(4, localb);
      com.tencent.mm.plugin.emoji.mgr.k.a(getContext(), localcjb, dAR(), paramf.mStatus, paramf.boE, str, dAS(), localbw);
      a(3, localb);
      return;
    }
    com.tencent.mm.plugin.emoji.mgr.k.a(getContext(), localcjb, dAR(), paramf.mStatus, paramf.boE, str, dAS());
  }
  
  public final void a(com.tencent.mm.plugin.emoji.a.a parama)
  {
    String str = parama.getProductId();
    Object localObject;
    if (TextUtils.isEmpty(parama.dya()))
    {
      localObject = "";
      Log.i("MicroMsg.emoji.BaseEmojiStoreUI", "[onProductClick] productId:%s, productPrice:%s, productStatus:%d", new Object[] { str, localObject, Integer.valueOf(parama.dxZ()) });
      if (dBj()) {
        if (parama.dxZ() == 9)
        {
          localObject = getString(h.h.app_uninstalling);
          if (!isFinishing()) {
            break label130;
          }
          Log.i("MicroMsg.emoji.BaseEmojiStoreUI", "[showLoadingDialog] acitivity is finished.");
        }
      }
    }
    for (;;)
    {
      localObject = b(2, null);
      if ((dBo()) && (localObject != null)) {
        this.xQe.xNu = ((bw)localObject);
      }
      this.xQe.a(parama);
      return;
      localObject = parama.dya();
      break;
      label130:
      getString(h.h.app_tip);
      this.pNH = com.tencent.mm.ui.base.k.a(this, (String)localObject, true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(108786);
          BaseEmojiStoreUI.dBq();
          AppMethodBeat.o(108786);
        }
      });
    }
  }
  
  protected void a(m paramm, boolean paramBoolean1, boolean paramBoolean2)
  {
    Log.d("MicroMsg.emoji.BaseEmojiStoreUI", "jacks initData begin");
    if ((paramm != null) && (paramm.xMU.size() > 0))
    {
      this.xQk = true;
      this.bEx.setVisibility(8);
      this.xPO = false;
    }
    a(this.xPP, paramm, paramBoolean1, paramBoolean2);
    dAZ();
  }
  
  protected void a(boolean paramBoolean1, m paramm, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((this.xQd != null) && (paramBoolean1)) {
      if (dAX())
      {
        if ((this.xQd != null) && (this.xQd.xMV != null) && (this.xQd.xMV.akjR != null)) {
          break label107;
        }
        Log.d("MicroMsg.emoji.BaseEmojiStoreUI", "update store ui header failed. ");
      }
    }
    for (;;)
    {
      if (this.xNj != null) {
        this.xNj.b(this.xQd);
      }
      if (this.xQh)
      {
        this.xQh = false;
        com.tencent.threadpool.h.ahAA.o(new BaseEmojiStoreUI..ExternalSyntheticLambda0(this), 500L);
      }
      return;
      label107:
      this.xQl = ((LinkedList)this.xQd.xMW);
      this.xQm = ((LinkedList)this.xQd.xMX);
      if (this.xQl != null)
      {
        this.xPJ.d(this.xQl, this.xQm);
      }
      else if (this.xQd.xMV != null)
      {
        this.xQl = new LinkedList();
        this.xQl.add(this.xQd.xMV);
        this.xPJ.d(this.xQl, this.xQm);
      }
    }
  }
  
  public final void ac(ArrayList<w> paramArrayList)
  {
    Log.d("MicroMsg.emoji.BaseEmojiStoreUI", "google [onQueryFinish]");
    if (this.xNj == null) {}
    do
    {
      return;
      com.tencent.mm.plugin.emoji.a.a.b.a(paramArrayList, this.xNj.xHr);
    } while (this.xRz == null);
    this.xRz.removeMessages(131074);
    this.xRz.sendEmptyMessage(131074);
  }
  
  protected void aoO(String paramString) {}
  
  public bw b(int paramInt, com.tencent.mm.plugin.emoji.ui.v3.b.b paramb)
  {
    return null;
  }
  
  protected int bC(byte[] paramArrayOfByte)
  {
    return this.xQc;
  }
  
  protected final void bD(byte[] paramArrayOfByte)
  {
    this.xPR = paramArrayOfByte;
  }
  
  public final void d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    e(paramString1, paramString2, paramString3, paramString4, paramString5);
    dBe();
  }
  
  protected void dAQ()
  {
    this.xNj = dAT();
    if (dBj()) {
      this.xNj.xHs = this;
    }
  }
  
  protected abstract int dAR();
  
  protected abstract int dAS();
  
  protected abstract com.tencent.mm.plugin.emoji.a.a.a dAT();
  
  protected void dAU() {}
  
  protected void dAV()
  {
    if (!dAW())
    {
      this.xPM = ((MMPullDownView)findViewById(h.e.load_more_pull_view));
      this.xPM.setEnableGesture(false);
    }
    do
    {
      return;
      this.xPM = ((MMPullDownView)findViewById(h.e.load_more_pull_view));
    } while (this.xPM == null);
    this.xPM.setTopViewVisible(false);
    this.xPM.setAtTopCallBack(this);
    this.xPM.setOnBottomLoadDataListener(this);
    this.xPM.setAtBottomCallBack(this);
    this.xPM.setBottomViewVisible(false);
    this.xPM.setIsBottomShowAll(false);
  }
  
  protected boolean dAW()
  {
    return true;
  }
  
  protected boolean dAX()
  {
    return true;
  }
  
  protected boolean dAY()
  {
    return false;
  }
  
  public final void dAg()
  {
    this.xPR = null;
    this.xPP = -1;
    R(false, false);
  }
  
  protected abstract int dBa();
  
  public int dBb()
  {
    return 0;
  }
  
  protected final void dBd()
  {
    com.tencent.mm.kernel.h.baD().mCm.a(this.xQb);
  }
  
  protected final void dBe()
  {
    com.tencent.mm.kernel.h.baD().mCm.a(this.xQj, 0);
  }
  
  protected boolean dBf()
  {
    gog localgog = com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adjx.azj(dBa());
    m localm = o.c(localgog);
    int j = dBa();
    if (localgog == null) {}
    for (int i = 0;; i = localgog.Zve)
    {
      Log.d("MicroMsg.emoji.BaseEmojiStoreUI", "load cache type: %d, size: %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      if (localm != null) {
        break;
      }
      return false;
    }
    if (localm.xMU.size() <= 0) {}
    for (boolean bool = false; bool; bool = true)
    {
      Log.d("MicroMsg.emoji.BaseEmojiStoreUI", "jacks init EmoijStoreUI  by Cache: list:%d", new Object[] { Integer.valueOf(localm.xMU.size()) });
      a(localm, true, false);
      return bool;
    }
    Log.d("MicroMsg.emoji.BaseEmojiStoreUI", "jacks init EmoijStoreUI  by NET");
    return bool;
  }
  
  protected final m dBg()
  {
    return this.xQd;
  }
  
  protected final void dBh()
  {
    this.xPP = -1;
  }
  
  protected byte[] dBi()
  {
    return null;
  }
  
  protected boolean dBj()
  {
    return true;
  }
  
  protected boolean dBk()
  {
    return false;
  }
  
  protected boolean dBl()
  {
    return false;
  }
  
  protected boolean dBm()
  {
    return true;
  }
  
  public void dBn() {}
  
  public boolean dBo()
  {
    return false;
  }
  
  protected final void dismissLoadingDialog()
  {
    if ((this.pNH != null) && (this.pNH.isShowing())) {
      this.pNH.dismiss();
    }
  }
  
  public final boolean dso()
  {
    R(true, false);
    Log.i("MicroMsg.emoji.BaseEmojiStoreUI", "[onBottomLoadData] startLoadRemoteEmoji.");
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
  
  protected final com.tencent.mm.plugin.emoji.e.h e(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.xQj = new com.tencent.mm.plugin.emoji.e.h(paramString1, paramString2, paramString3, paramString4, paramString5);
    return this.xQj;
  }
  
  protected void e(gog paramgog)
  {
    int j = 0;
    int i;
    if (paramgog != null)
    {
      if (paramgog != null) {
        break label68;
      }
      i = 0;
      if (paramgog != null) {
        break label76;
      }
    }
    for (;;)
    {
      Log.d("MicroMsg.emoji.BaseEmojiStoreUI", "jacks save EmoijStoreUI Cache: list:%d, size: %d, type: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(dBa()) });
      com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adjx.a(dBa(), paramgog);
      return;
      label68:
      i = paramgog.Zve;
      break;
      label76:
      if (paramgog.YGU != null) {
        j = paramgog.YGU.computeSize();
      }
    }
  }
  
  public int getLayoutId()
  {
    return h.f.emoji_store_main;
  }
  
  protected void h(com.tencent.mm.plugin.emoji.e.h paramh)
  {
    dY(paramh.xOk, 0);
  }
  
  public void initView()
  {
    setBackBtn(new a((byte)0));
    dAQ();
    this.bEx = findViewById(h.e.empty);
    this.xPN = ((TextView)this.bEx.findViewById(h.e.empty_content));
    this.xPQ = getLayoutInflater().inflate(h.f.emoji_store_load_more, null);
    this.xPQ.setVisibility(8);
    if (dAX()) {
      this.xPJ = new EmojiStoreVpHeader(getContext());
    }
    if (dAY())
    {
      this.xPK = LayoutInflater.from(this).inflate(h.f.emoji_store_vp_header_item, null);
      int i = EmojiStoreVpHeader.getScreenWH(getContext())[0];
      AbsListView.LayoutParams localLayoutParams = new AbsListView.LayoutParams(i, i * 3 / 8 + 1);
      this.xPK.setLayoutParams(localLayoutParams);
      this.xPL = ((StoreBannerEmojiView)this.xPK.findViewById(h.e.emoji_bar_view));
    }
    this.mListView = ((ListView)findViewById(16908298));
    this.mListView.setOnItemClickListener(this);
    if (dAX()) {
      this.mListView.addHeaderView(this.xPJ);
    }
    for (;;)
    {
      if (dBm()) {
        this.mListView.addFooterView(this.xPQ);
      }
      dAU();
      this.mListView.setAdapter(this.xNj);
      this.mListView.setOnScrollListener(this);
      this.xNj.xHq = this.mListView;
      dAV();
      return;
      if (dAY()) {
        this.mListView.addHeaderView(this.xPK);
      }
    }
  }
  
  public final void k(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      e((gog)paramMessage.obj);
      return;
      dismissLoadingDialog();
      return;
      paramMessage = (String)paramMessage.obj;
      if (isFinishing())
      {
        Log.i("MicroMsg.emoji.BaseEmojiStoreUI", "[updateLoadingDialog] acitivity is finished.");
        return;
      }
    } while (this.pNH == null);
    this.pNH.setMessage(paramMessage);
  }
  
  public void k(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    Log.d("MicroMsg.emoji.BaseEmojiStoreUI", "[onExchange] productId:[%s] status:[%d] progress:[%d] cdnClientId:[%s]", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString2 });
    if (this.xNj == null) {}
    com.tencent.mm.plugin.emoji.a.a.c localc;
    do
    {
      return;
      localc = this.xNj.xHr;
    } while (localc == null);
    if (paramInt1 == 6) {
      dY(paramString1, paramInt2);
    }
    for (;;)
    {
      paramString1 = localc.anN(paramString1);
      if (paramString1 == null) {
        break;
      }
      paramString1.xHI = paramString2;
      return;
      Log.i("MicroMsg.emoji.BaseEmojiStoreUI", "product status:%d", new Object[] { Integer.valueOf(paramInt1) });
      dX(paramString1, paramInt1);
    }
  }
  
  public void l(Message paramMessage)
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
            } while (this.xNj == null);
            this.xNj.notifyDataSetChanged();
            dBn();
            return;
          } while ((this.xNj == null) || (paramMessage.getData() == null));
          str = paramMessage.getData().getString("product_id");
        } while (str == null);
        i = paramMessage.getData().getInt("progress");
        this.xNj.dY(str, i);
        return;
      } while ((this.xNj == null) || (paramMessage.getData() == null));
      str = paramMessage.getData().getString("product_id");
    } while (str == null);
    int i = paramMessage.getData().getInt("status");
    this.xNj.dX(str, i);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Log.d("MicroMsg.emoji.BaseEmojiStoreUI", "onActivityResult . requestCode:" + paramInt1 + "  resultCode:" + paramInt2);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (dBj()) {
      this.xQe.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (dBj()) {
      this.xQe = new r();
    }
    initView();
    this.xQc = getIntent().getIntExtra("preceding_scence", 2);
    if (com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adjv != null) {
      com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adjv.add(this);
    }
    this.xQg = new EmotionStatusChangeL();
    this.xQg.alive();
    if (dBj())
    {
      this.xQe.xNl = this;
      this.xQe.xNj = this.xNj;
      this.xQe.xNn = dAR();
      this.xQe.xNq = this;
    }
    boolean bool = dBk();
    if (bool) {
      bool = dBf();
    }
    for (;;)
    {
      if ((bool) && (dBl()) && (xQf != null) && (xQf.get(getClass().toString()) != null) && (System.currentTimeMillis() - ((Long)xQf.get(getClass().toString())).longValue() < 300000L)) {
        Log.d("MicroMsg.emoji.BaseEmojiStoreUI", "pass load by net ");
      }
      for (int i = 0;; i = 1)
      {
        if (i != 0)
        {
          R(false, bool);
          if (xQf == null) {
            xQf = new HashMap();
          }
          long l = System.currentTimeMillis();
          Log.d("MicroMsg.emoji.BaseEmojiStoreUI", "refresh last net refresh time: %d", new Object[] { Long.valueOf(l) });
          xQf.put(getClass().toString(), Long.valueOf(l));
        }
        this.xNs = new e(1005);
        return;
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.xNj != null)
    {
      this.xNj.clear();
      this.xNj = null;
    }
    Object localObject;
    if ((dAX()) && (this.xPJ != null))
    {
      localObject = this.xPJ;
      if (((EmojiStoreVpHeader)localObject).xUt != null)
      {
        com.tencent.mm.plugin.emoji.a.i locali = ((EmojiStoreVpHeader)localObject).xUt;
        if (locali.xHf != null) {
          locali.xHf.clear();
        }
        if (locali.xHj != null) {
          locali.xHj.clear();
        }
        locali.xHi = true;
        locali.xHk.xHl = null;
        ((EmojiStoreVpHeader)localObject).xUt = null;
      }
      ((EmojiStoreVpHeader)localObject).xUw = null;
    }
    com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adjv.remove(this);
    this.xQg.dead();
    com.tencent.mm.kernel.h.baD().mCm.a(this.xQj);
    if (this.xQe != null)
    {
      localObject = this.xQe;
      ((r)localObject).xNj = null;
      ((r)localObject).xNq = null;
      ((r)localObject).xNl = null;
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramAdapterView);
    localb.cH(paramView);
    localb.sc(paramInt);
    localb.hB(paramLong);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emoji/ui/BaseEmojiStoreUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
    int i;
    if (!dAX())
    {
      i = paramInt;
      if (!dAY()) {}
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
    if ((i < 0) || (i >= this.xNj.getCount()))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/BaseEmojiStoreUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      return;
    }
    a(this.xNj.Kd(i), i);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/BaseEmojiStoreUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
  }
  
  public void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals("delete_group")))
    {
      dBx();
      gS(131074, 50);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    com.tencent.mm.kernel.h.baD().mCm.b(411, this);
    com.tencent.mm.kernel.h.baD().mCm.b(423, this);
    com.tencent.mm.kernel.h.baD().mCm.b(413, this);
    com.tencent.mm.kernel.h.baD().mCm.b(717, this);
    dBd();
    if ((dAX()) && (this.xPJ != null)) {
      this.xPJ.dBZ();
    }
    this.xQi = true;
  }
  
  public void onResume()
  {
    super.onResume();
    com.tencent.mm.kernel.h.baD().mCm.a(411, this);
    com.tencent.mm.kernel.h.baD().mCm.a(423, this);
    com.tencent.mm.kernel.h.baD().mCm.a(413, this);
    com.tencent.mm.kernel.h.baD().mCm.a(717, this);
    if ((dAX()) && (this.xPJ != null)) {
      this.xPJ.dBY();
    }
    Boolean localBoolean = Boolean.FALSE;
    if (dBj()) {
      this.xQe.xNk = false;
    }
    if ((this.xNj != null) && (this.xNj.xHr != null))
    {
      this.xNj.xHr.dyn();
      this.xNj.refreshView();
      if ((this.xQi) && (dBo())) {
        a(1, null);
      }
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, final p paramp)
  {
    final String str1;
    if (TextUtils.isEmpty(paramString))
    {
      str1 = "";
      Log.i("MicroMsg.emoji.BaseEmojiStoreUI", "jacks [onSceneEnd] errType:%d,errCode:%d,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str1 });
      dismissLoadingDialog();
      switch (paramp.getType())
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
        } while (!(paramp instanceof o));
        a(paramInt1, paramInt2, paramString, (o)paramp);
        return;
      } while (!(paramp instanceof com.tencent.mm.plugin.emoji.e.h));
      paramString = (com.tencent.mm.plugin.emoji.e.h)paramp;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        h(paramString);
        return;
      }
      paramp = paramString.xOk;
      str1 = paramString.xOm;
      final String str2 = paramString.xOl;
      final String str3 = paramString.xOo;
      com.tencent.mm.ui.base.k.a(this, getString(h.h.emoji_store_download_failed_msg, new Object[] { str2 }), "", new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(108784);
          BaseEmojiStoreUI.this.e(paramp, str1, str2, null, str3);
          BaseEmojiStoreUI.this.dBe();
          Log.i("MicroMsg.emoji.BaseEmojiStoreUI", "Retry doScene ExchangeEmotionPackNetScene productId:%s", new Object[] { paramp });
          BaseEmojiStoreUI.a(BaseEmojiStoreUI.this, paramp);
          AppMethodBeat.o(108784);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      dX(paramString.xOk, -1);
      return;
      paramString = (com.tencent.mm.plugin.emoji.e.s)paramp;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adjv.byT(paramString.xOk);
        paramString = new Message();
        paramString.what = 2002;
        paramString.obj = getContext().getString(h.h.app_unInstall_finish);
        m(paramString);
      }
      for (;;)
      {
        gS(20001, 800);
        return;
        paramString = new Message();
        paramString.what = 2002;
        paramString.obj = getContext().getString(h.h.emoji_delete_failed);
        m(paramString);
      }
    } while ((paramInt1 != 0) || (paramInt2 != 0));
    this.xPR = null;
    R(false, true);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1)) {
      if ((this.xPP == 0) || (this.szX)) {
        Log.d("MicroMsg.emoji.BaseEmojiStoreUI", "No More List.");
      }
    }
    while ((paramInt != 0) || (!dBo()))
    {
      return;
      R(true, false);
      Log.i("MicroMsg.emoji.BaseEmojiStoreUI", "[onScrollStateChanged] startLoadRemoteEmoji.");
    }
    a(1, null);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected final void showLoadingDialog()
  {
    if (isFinishing())
    {
      Log.i("MicroMsg.emoji.BaseEmojiStoreUI", "[showLoadingDialog] acitivity is finished.");
      return;
    }
    getString(h.h.app_tip);
    this.pNH = com.tencent.mm.ui.base.k.a(this, getString(h.h.app_waiting), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(108785);
        BaseEmojiStoreUI.this.dBd();
        BaseEmojiStoreUI.dBq();
        AppMethodBeat.o(108785);
      }
    });
  }
  
  class EmotionStatusChangeL
    extends IListener<ee>
  {
    public EmotionStatusChangeL()
    {
      super();
      AppMethodBeat.i(161086);
      this.__eventId = ee.class.getName().hashCode();
      AppMethodBeat.o(161086);
    }
  }
  
  final class a
    implements MenuItem.OnMenuItemClickListener
  {
    private a() {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(108788);
      BaseEmojiStoreUI.this.finish();
      AppMethodBeat.o(108788);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI
 * JD-Core Version:    0.7.0.1
 */