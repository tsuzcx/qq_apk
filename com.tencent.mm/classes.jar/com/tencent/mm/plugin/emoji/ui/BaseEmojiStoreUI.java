package com.tencent.mm.plugin.emoji.ui;

import android.app.Activity;
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
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.du;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.plugin.emoji.a.a.f.a;
import com.tencent.mm.plugin.emoji.e.k;
import com.tencent.mm.plugin.emoji.f.r;
import com.tencent.mm.plugin.emoji.i.e;
import com.tencent.mm.plugin.emoji.i.f;
import com.tencent.mm.plugin.emoji.i.h;
import com.tencent.mm.plugin.emoji.model.l;
import com.tencent.mm.plugin.emoji.model.o.a;
import com.tencent.mm.plugin.emoji.model.o.b;
import com.tencent.mm.plugin.emoji.model.p;
import com.tencent.mm.pluginsdk.model.m.a;
import com.tencent.mm.pluginsdk.model.u;
import com.tencent.mm.pluginsdk.ui.emoji.StoreBannerEmojiView;
import com.tencent.mm.protocal.protobuf.aju;
import com.tencent.mm.protocal.protobuf.ajw;
import com.tencent.mm.protocal.protobuf.akh;
import com.tencent.mm.protocal.protobuf.buh;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.s;
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
  implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener, i, o.a, o.b, m.a, MStorage.IOnStorageChange, MMPullDownView.c, MMPullDownView.d, MMPullDownView.e
{
  private static Map<String, Long> uHz;
  protected View Xd;
  public ListView mListView;
  private ProgressDialog mRa;
  private boolean puR;
  public com.tencent.mm.plugin.emoji.a.a.a uEH;
  private com.tencent.mm.plugin.emoji.i.c uEQ;
  private IListener uHA;
  protected com.tencent.mm.plugin.emoji.f.h uHB;
  protected boolean uHC = false;
  private LinkedList<aju> uHD = new LinkedList();
  private LinkedList<ajw> uHE = new LinkedList();
  protected EmojiStoreVpHeader uHd;
  protected View uHe;
  protected StoreBannerEmojiView uHf;
  protected MMPullDownView uHg;
  protected TextView uHh;
  protected boolean uHi = false;
  private int uHj = -1;
  private View uHk;
  private byte[] uHl;
  private final int uHm = 65537;
  private final int uHn = 20001;
  private final int uHo = 2002;
  protected final int uHp = 131074;
  private final int uHq = 131075;
  private final int uHr = 131076;
  private final String uHs = "product_id";
  private final String uHt = "progress";
  private final String uHu = "status";
  private com.tencent.mm.plugin.emoji.f.o uHv;
  private int uHw;
  private l uHx;
  protected com.tencent.mm.plugin.emoji.model.o uHy;
  
  private void a(int paramInt, l paraml, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = false;
    Log.d("MicroMsg.emoji.BaseEmojiStoreUI", "");
    boolean bool1 = bool2;
    switch (paramInt)
    {
    default: 
      bool1 = bool2;
    case 0: 
      if (this.uHx != null) {
        this.uHx.cUI();
      }
      a(bool1, this.uHx, paramBoolean1, paramBoolean2);
      return;
    case -1: 
      this.uHx = paraml;
    }
    for (;;)
    {
      bool1 = true;
      break;
      this.uHx = paraml;
      continue;
      if (this.uHx == null) {
        this.uHx = new l();
      }
      if (paraml != null)
      {
        this.uHx.JF(paraml.uEw);
        this.uHx.df(paraml.uEx);
      }
    }
  }
  
  private void b(buh parambuh)
  {
    if (this.uHj == -1)
    {
      Message localMessage = Message.obtain();
      localMessage.what = 65537;
      localMessage.obj = parambuh;
      m(localMessage);
    }
  }
  
  private com.tencent.mm.plugin.emoji.f.o bB(byte[] paramArrayOfByte)
  {
    int i = cVA();
    int j = bC(paramArrayOfByte);
    int k = cVB();
    com.tencent.mm.plugin.emoji.f.o localo;
    if (paramArrayOfByte != null)
    {
      Log.i("MicroMsg.emoji.BaseEmojiStoreUI", "[startLoadRemoteEmoji] request buffer %s", new Object[] { paramArrayOfByte.toString() });
      localo = new com.tencent.mm.plugin.emoji.f.o(i, paramArrayOfByte, j);
      paramArrayOfByte = localo;
      if (i == 7)
      {
        localo.uGg = k;
        paramArrayOfByte = localo;
      }
    }
    for (;;)
    {
      this.uHv = paramArrayOfByte;
      return paramArrayOfByte;
      Log.i("MicroMsg.emoji.BaseEmojiStoreUI", "[startLoadRemoteEmoji] request buffer is null.");
      localo = new com.tencent.mm.plugin.emoji.f.o(i, j);
      paramArrayOfByte = localo;
      if (i == 7)
      {
        localo.uGg = k;
        paramArrayOfByte = localo;
      }
    }
  }
  
  private void cVC()
  {
    com.tencent.mm.kernel.h.aHF().kcd.a(this.uHv, 0);
  }
  
  private void cVz()
  {
    com.tencent.mm.plugin.emoji.a.a.b.a(this.uEH.uAO, this);
  }
  
  private void dw(String paramString, int paramInt)
  {
    Message localMessage = Message.obtain();
    localMessage.getData().putString("product_id", paramString);
    localMessage.getData().putInt("status", paramInt);
    localMessage.what = 131076;
    l(localMessage);
  }
  
  private void dx(String paramString, int paramInt)
  {
    Message localMessage = Message.obtain();
    localMessage.getData().putString("product_id", paramString);
    localMessage.getData().putInt("progress", paramInt);
    localMessage.what = 131075;
    l(localMessage);
  }
  
  protected final void N(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.puR = true;
    if (paramBoolean1) {
      this.uHk.setVisibility(0);
    }
    bB(this.uHl);
    cVC();
    Log.i("MicroMsg.emoji.BaseEmojiStoreUI", "[startLoadRemoteEmoji] doScene GetEmotionListNetScene");
    if ((!paramBoolean1) && (!paramBoolean2)) {
      bxs();
    }
  }
  
  public final void Y(ArrayList<u> paramArrayList)
  {
    Log.d("MicroMsg.emoji.BaseEmojiStoreUI", "google [onQueryFinish]");
    if (this.uEH == null) {}
    do
    {
      return;
      com.tencent.mm.plugin.emoji.a.a.b.a(paramArrayList, this.uEH.uAO);
    } while (this.uIJ == null);
    this.uIJ.removeMessages(131074);
    this.uIJ.sendEmptyMessage(131074);
  }
  
  protected void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.plugin.emoji.f.o paramo)
  {
    if ((paramo != null) && (paramo.mType == cVA()))
    {
      this.puR = false;
      this.uHk.setVisibility(8);
      paramString = null;
      try
      {
        l locall = com.tencent.mm.plugin.emoji.f.o.a(paramo.cVg());
        paramString = locall;
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
        paramo = paramo.cVg();
        a(this.uHj, paramString, false, false);
        cVz();
        b(paramo);
        this.uHj = 2;
        return;
        if (paramInt2 != 3) {
          break label209;
        }
        a(this.uHj, paramString, false, false);
        this.uHj = 1;
        return;
        this.Xd.setVisibility(0);
        this.uHi = true;
        if (cVA() != 7) {
          break label242;
        }
        this.uHh.setText(i.h.emoji_store_topic_empty);
        return;
        this.uHh.setText(i.h.emoji_store_load_failed);
        return;
      }
      if (paramString != null) {
        if ((paramInt1 == 0) || (paramInt1 == 4))
        {
          paramInt1 = 1;
          if (paramInt1 == 0) {
            break label253;
          }
          this.Xd.setVisibility(8);
          this.uHi = false;
          this.uHl = paramo.uGe;
          if (paramInt2 != 0) {
            break label148;
          }
          paramo = paramo.cVg();
          a(paramString, false, true);
          b(paramo);
          this.uHj = 0;
        }
      }
      label148:
      label187:
      label209:
      label242:
      label253:
      while (this.uHC) {
        return;
      }
      this.Xd.setVisibility(0);
      this.uHi = true;
      this.uHh.setText(i.h.emoji_store_load_failed_network);
      return;
    }
    paramInt2 = cVA();
    if (paramo == null) {}
    for (paramInt1 = -1;; paramInt1 = paramo.mType)
    {
      Log.i("MicroMsg.emoji.BaseEmojiStoreUI", "no some scene type. this ui type:%d callbak type:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
      return;
    }
  }
  
  protected void a(f paramf, int paramInt)
  {
    if (paramf == null)
    {
      Log.i("MicroMsg.emoji.BaseEmojiStoreUI", "item is null.");
      return;
    }
    if (paramf.uAZ == f.a.uBi)
    {
      paramf = paramf.uBb;
      if (paramf == null)
      {
        Log.i("MicroMsg.emoji.BaseEmojiStoreUI", "banner set is null. do nothing");
        return;
      }
      k.a(getContext(), paramf, false);
      return;
    }
    akh localakh = paramf.uBa;
    if (localakh == null)
    {
      Log.i("MicroMsg.emoji.BaseEmojiStoreUI", "summary is null. do nothing");
      return;
    }
    String str = getIntent().getStringExtra("to_talker_name");
    k.a(getContext(), localakh, cVr(), paramf.mStatus, paramf.IB, str, cVs());
  }
  
  public final void a(com.tencent.mm.plugin.emoji.a.a parama)
  {
    String str2 = parama.getProductId();
    String str1;
    if (TextUtils.isEmpty(parama.cTF()))
    {
      str1 = "";
      Log.i("MicroMsg.emoji.BaseEmojiStoreUI", "[onProductClick] productId:%s, productPrice:%s, productStatus:%d", new Object[] { str2, str1, Integer.valueOf(parama.cTE()) });
      if (parama.cTE() == 9)
      {
        str1 = getString(i.h.app_uninstalling);
        if (!isFinishing()) {
          break label97;
        }
        Log.i("MicroMsg.emoji.BaseEmojiStoreUI", "[showLoadingDialog] acitivity is finished.");
      }
    }
    for (;;)
    {
      this.uHy.a(parama);
      return;
      str1 = parama.cTF();
      break;
      label97:
      getString(i.h.app_tip);
      this.mRa = com.tencent.mm.ui.base.h.a(this, str1, true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(108786);
          BaseEmojiStoreUI.cVM();
          AppMethodBeat.o(108786);
        }
      });
    }
  }
  
  protected void a(l paraml, boolean paramBoolean1, boolean paramBoolean2)
  {
    Log.d("MicroMsg.emoji.BaseEmojiStoreUI", "jacks initData begin");
    if ((paraml != null) && (paraml.uEx.size() > 0))
    {
      this.uHC = true;
      this.Xd.setVisibility(8);
      this.uHi = false;
    }
    a(this.uHj, paraml, paramBoolean1, paramBoolean2);
    cVz();
  }
  
  protected void a(boolean paramBoolean1, l paraml, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((this.uHx != null) && (paramBoolean1)) {
      if (cVx())
      {
        if ((this.uHx != null) && (this.uHx.uEy != null) && (this.uHx.uEy.Tej != null)) {
          break label75;
        }
        Log.d("MicroMsg.emoji.BaseEmojiStoreUI", "update store ui header failed. ");
      }
    }
    for (;;)
    {
      if (this.uEH != null) {
        this.uEH.b(this.uHx);
      }
      return;
      label75:
      this.uHD = ((LinkedList)this.uHx.uEz);
      this.uHE = ((LinkedList)this.uHx.uEA);
      if (this.uHD != null)
      {
        this.uHd.d(this.uHD, this.uHE);
      }
      else if (this.uHx.uEy != null)
      {
        this.uHD = new LinkedList();
        this.uHD.add(this.uHx.uEy);
        this.uHd.d(this.uHD, this.uHE);
      }
    }
  }
  
  protected void auP(String paramString) {}
  
  protected int bC(byte[] paramArrayOfByte)
  {
    return this.uHw;
  }
  
  protected final void bD(byte[] paramArrayOfByte)
  {
    this.uHl = paramArrayOfByte;
  }
  
  protected final void bxs()
  {
    if (isFinishing())
    {
      Log.i("MicroMsg.emoji.BaseEmojiStoreUI", "[showLoadingDialog] acitivity is finished.");
      return;
    }
    getString(i.h.app_tip);
    this.mRa = com.tencent.mm.ui.base.h.a(this, getString(i.h.app_waiting), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(108785);
        BaseEmojiStoreUI.this.cVD();
        BaseEmojiStoreUI.cVM();
        AppMethodBeat.o(108785);
      }
    });
  }
  
  protected void c(buh parambuh)
  {
    int j = 0;
    int i;
    if (parambuh != null)
    {
      if (parambuh != null) {
        break label68;
      }
      i = 0;
      if (parambuh != null) {
        break label76;
      }
    }
    for (;;)
    {
      Log.d("MicroMsg.emoji.BaseEmojiStoreUI", "jacks save EmoijStoreUI Cache: list:%d, size: %d, type: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(cVA()) });
      p.getEmojiStorageMgr().VFK.a(cVA(), parambuh);
      return;
      label68:
      i = parambuh.VHV;
      break;
      label76:
      if (parambuh.RJA != null) {
        j = parambuh.RJA.computeSize();
      }
    }
  }
  
  public final boolean cOJ()
  {
    N(true, false);
    Log.i("MicroMsg.emoji.BaseEmojiStoreUI", "[onBottomLoadData] startLoadRemoteEmoji.");
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
    N(false, false);
  }
  
  protected abstract int cVA();
  
  public int cVB()
  {
    return 0;
  }
  
  protected final void cVD()
  {
    com.tencent.mm.kernel.h.aHF().kcd.a(this.uHv);
  }
  
  protected final void cVE()
  {
    com.tencent.mm.kernel.h.aHF().kcd.a(this.uHB, 0);
  }
  
  protected boolean cVF()
  {
    buh localbuh = p.getEmojiStorageMgr().VFK.asU(cVA());
    l locall = com.tencent.mm.plugin.emoji.f.o.a(localbuh);
    int j = cVA();
    if (localbuh == null) {}
    for (int i = 0;; i = localbuh.VHV)
    {
      Log.d("MicroMsg.emoji.BaseEmojiStoreUI", "load cache type: %d, size: %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      if (locall != null) {
        break;
      }
      return false;
    }
    if (locall.uEx.size() <= 0) {}
    for (boolean bool = false; bool; bool = true)
    {
      Log.d("MicroMsg.emoji.BaseEmojiStoreUI", "jacks init EmoijStoreUI  by Cache: list:%d", new Object[] { Integer.valueOf(locall.uEx.size()) });
      a(locall, true, false);
      return bool;
    }
    Log.d("MicroMsg.emoji.BaseEmojiStoreUI", "jacks init EmoijStoreUI  by NET");
    return bool;
  }
  
  protected final void cVG()
  {
    if ((this.mRa != null) && (this.mRa.isShowing())) {
      this.mRa.dismiss();
    }
  }
  
  protected final l cVH()
  {
    return this.uHx;
  }
  
  protected final void cVI()
  {
    this.uHj = -1;
  }
  
  protected boolean cVJ()
  {
    return false;
  }
  
  protected boolean cVK()
  {
    return true;
  }
  
  public void cVL() {}
  
  protected void cVq()
  {
    this.uEH = cVt();
    this.uEH.uAP = this;
  }
  
  protected abstract int cVr();
  
  protected abstract int cVs();
  
  protected abstract com.tencent.mm.plugin.emoji.a.a.a cVt();
  
  protected void cVu() {}
  
  protected void cVv()
  {
    if (!cVw())
    {
      this.uHg = ((MMPullDownView)findViewById(i.e.load_more_pull_view));
      this.uHg.setEnableGesture(false);
    }
    do
    {
      return;
      this.uHg = ((MMPullDownView)findViewById(i.e.load_more_pull_view));
    } while (this.uHg == null);
    this.uHg.setTopViewVisible(false);
    this.uHg.setAtTopCallBack(this);
    this.uHg.setOnBottomLoadDataListener(this);
    this.uHg.setAtBottomCallBack(this);
    this.uHg.setBottomViewVisible(false);
    this.uHg.setIsBottomShowAll(false);
  }
  
  protected boolean cVw()
  {
    return true;
  }
  
  protected boolean cVx()
  {
    return true;
  }
  
  protected boolean cVy()
  {
    return false;
  }
  
  public final void d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    e(paramString1, paramString2, paramString3, paramString4, paramString5);
    cVE();
  }
  
  protected final com.tencent.mm.plugin.emoji.f.h e(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.uHB = new com.tencent.mm.plugin.emoji.f.h(paramString1, paramString2, paramString3, paramString4, paramString5);
    return this.uHB;
  }
  
  public int getLayoutId()
  {
    return i.f.emoji_store_main;
  }
  
  protected void h(com.tencent.mm.plugin.emoji.f.h paramh)
  {
    dx(paramh.uFI, 0);
  }
  
  public void initView()
  {
    setBackBtn(new b((byte)0));
    cVq();
    this.Xd = findViewById(i.e.empty);
    this.uHh = ((TextView)this.Xd.findViewById(i.e.empty_content));
    this.uHk = getLayoutInflater().inflate(i.f.emoji_store_load_more, null);
    this.uHk.setVisibility(8);
    if (cVx()) {
      this.uHd = new EmojiStoreVpHeader(getContext());
    }
    if (cVy())
    {
      this.uHe = LayoutInflater.from(this).inflate(i.f.emoji_store_vp_header_item, null);
      int i = EmojiStoreVpHeader.getScreenWH(getContext())[0];
      AbsListView.LayoutParams localLayoutParams = new AbsListView.LayoutParams(i, i * 3 / 8 + 1);
      this.uHe.setLayoutParams(localLayoutParams);
      this.uHf = ((StoreBannerEmojiView)this.uHe.findViewById(i.e.emoji_bar_view));
    }
    this.mListView = ((ListView)findViewById(16908298));
    this.mListView.setOnItemClickListener(this);
    if (cVx()) {
      this.mListView.addHeaderView(this.uHd);
    }
    for (;;)
    {
      if (cVK()) {
        this.mListView.addFooterView(this.uHk);
      }
      cVu();
      this.mListView.setAdapter(this.uEH);
      this.mListView.setOnScrollListener(this);
      this.uEH.uAN = this.mListView;
      cVv();
      return;
      if (cVy()) {
        this.mListView.addHeaderView(this.uHe);
      }
    }
  }
  
  public final void j(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      c((buh)paramMessage.obj);
      return;
      cVG();
      return;
      paramMessage = (String)paramMessage.obj;
      if (isFinishing())
      {
        Log.i("MicroMsg.emoji.BaseEmojiStoreUI", "[updateLoadingDialog] acitivity is finished.");
        return;
      }
    } while (this.mRa == null);
    this.mRa.setMessage(paramMessage);
  }
  
  public void k(Message paramMessage)
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
            } while (this.uEH == null);
            this.uEH.notifyDataSetChanged();
            cVL();
            return;
          } while ((this.uEH == null) || (paramMessage.getData() == null));
          str = paramMessage.getData().getString("product_id");
        } while (str == null);
        i = paramMessage.getData().getInt("progress");
        this.uEH.dx(str, i);
        return;
      } while ((this.uEH == null) || (paramMessage.getData() == null));
      str = paramMessage.getData().getString("product_id");
    } while (str == null);
    int i = paramMessage.getData().getInt("status");
    this.uEH.dw(str, i);
  }
  
  public void k(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    Log.d("MicroMsg.emoji.BaseEmojiStoreUI", "[onExchange] productId:[%s] status:[%d] progress:[%d] cdnClientId:[%s]", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString2 });
    if (this.uEH == null) {}
    com.tencent.mm.plugin.emoji.a.a.c localc;
    do
    {
      return;
      localc = this.uEH.uAO;
    } while (localc == null);
    if (paramInt1 == 6) {
      dx(paramString1, paramInt2);
    }
    for (;;)
    {
      paramString1 = localc.atV(paramString1);
      if (paramString1 == null) {
        break;
      }
      paramString1.uBd = paramString2;
      return;
      Log.i("MicroMsg.emoji.BaseEmojiStoreUI", "product status:%d", new Object[] { Integer.valueOf(paramInt1) });
      dw(paramString1, paramInt1);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Log.d("MicroMsg.emoji.BaseEmojiStoreUI", "onActivityResult . requestCode:" + paramInt1 + "  resultCode:" + paramInt2);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.uHy.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.uHy = new com.tencent.mm.plugin.emoji.model.o();
    initView();
    this.uHw = getIntent().getIntExtra("preceding_scence", 2);
    if (p.getEmojiStorageMgr().VFI != null) {
      p.getEmojiStorageMgr().VFI.add(this);
    }
    this.uHA = new a((byte)0);
    EventCenter.instance.addListener(this.uHA);
    this.uHy.uEJ = this;
    this.uHy.uEH = this.uEH;
    this.uHy.uEL = cVr();
    this.uHy.uEO = this;
    boolean bool2 = cVJ();
    boolean bool1 = bool2;
    if (bool2) {
      bool1 = cVF();
    }
    N(false, bool1);
    if (uHz == null) {
      uHz = new HashMap();
    }
    long l = System.currentTimeMillis();
    Log.d("MicroMsg.emoji.BaseEmojiStoreUI", "refresh last net refresh time: %d", new Object[] { Long.valueOf(l) });
    uHz.put(getClass().toString(), Long.valueOf(l));
    this.uEQ = new com.tencent.mm.plugin.emoji.i.c(1005);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.uEH != null)
    {
      this.uEH.clear();
      this.uEH = null;
    }
    if ((cVx()) && (this.uHd != null)) {
      this.uHd.clear();
    }
    p.getEmojiStorageMgr().VFI.remove(this);
    EventCenter.instance.removeListener(this.uHA);
    com.tencent.mm.kernel.h.aHF().kcd.a(this.uHB);
    if (this.uHy != null)
    {
      com.tencent.mm.plugin.emoji.model.o localo = this.uHy;
      localo.uEH = null;
      localo.uEO = null;
      localo.uEJ = null;
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramAdapterView);
    localb.bn(paramView);
    localb.sg(paramInt);
    localb.Fs(paramLong);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emoji/ui/BaseEmojiStoreUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
    int i;
    if (!cVx())
    {
      i = paramInt;
      if (!cVy()) {}
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
    if ((i < 0) || (i >= this.uEH.getCount()))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/BaseEmojiStoreUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      return;
    }
    a(this.uEH.Jv(i), i);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/BaseEmojiStoreUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
  }
  
  public void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals("delete_group")))
    {
      cVS();
      fZ(131074, 50);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    com.tencent.mm.kernel.h.aHF().kcd.b(411, this);
    com.tencent.mm.kernel.h.aHF().kcd.b(423, this);
    com.tencent.mm.kernel.h.aHF().kcd.b(413, this);
    com.tencent.mm.kernel.h.aHF().kcd.b(717, this);
    cVD();
    if ((cVx()) && (this.uHd != null)) {
      this.uHd.cWv();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    com.tencent.mm.kernel.h.aHF().kcd.a(411, this);
    com.tencent.mm.kernel.h.aHF().kcd.a(423, this);
    com.tencent.mm.kernel.h.aHF().kcd.a(413, this);
    com.tencent.mm.kernel.h.aHF().kcd.a(717, this);
    if ((cVx()) && (this.uHd != null)) {
      this.uHd.cWu();
    }
    Boolean localBoolean = Boolean.FALSE;
    this.uHy.uEI = false;
    if ((this.uEH != null) && (this.uEH.uAO != null))
    {
      this.uEH.uAO.cTS();
      this.uEH.refreshView();
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, final q paramq)
  {
    final String str1;
    if (TextUtils.isEmpty(paramString))
    {
      str1 = "";
      Log.i("MicroMsg.emoji.BaseEmojiStoreUI", "jacks [onSceneEnd] errType:%d,errCode:%d,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str1 });
      cVG();
      switch (paramq.getType())
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
        } while (!(paramq instanceof com.tencent.mm.plugin.emoji.f.o));
        a(paramInt1, paramInt2, paramString, (com.tencent.mm.plugin.emoji.f.o)paramq);
        return;
      } while (!(paramq instanceof com.tencent.mm.plugin.emoji.f.h));
      paramString = (com.tencent.mm.plugin.emoji.f.h)paramq;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        h(paramString);
        return;
      }
      paramq = paramString.uFI;
      str1 = paramString.uFK;
      final String str2 = paramString.uFJ;
      final String str3 = paramString.uFM;
      com.tencent.mm.ui.base.h.a(this, getString(i.h.emoji_store_download_failed_msg, new Object[] { str2 }), "", new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(108784);
          BaseEmojiStoreUI.this.e(paramq, str1, str2, null, str3);
          BaseEmojiStoreUI.this.cVE();
          Log.i("MicroMsg.emoji.BaseEmojiStoreUI", "Retry doScene ExchangeEmotionPackNetScene productId:%s", new Object[] { paramq });
          BaseEmojiStoreUI.a(BaseEmojiStoreUI.this, paramq);
          AppMethodBeat.o(108784);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      dw(paramString.uFI, -1);
      return;
      paramString = (r)paramq;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        p.getEmojiStorageMgr().VFI.bxC(paramString.uFI);
        paramString = new Message();
        paramString.what = 2002;
        paramString.obj = getContext().getString(i.h.app_unInstall_finish);
        l(paramString);
      }
      for (;;)
      {
        fZ(20001, 800);
        return;
        paramString = new Message();
        paramString.what = 2002;
        paramString.obj = getContext().getString(i.h.emoji_delete_failed);
        l(paramString);
      }
    } while ((paramInt1 != 0) || (paramInt2 != 0));
    this.uHl = null;
    N(false, true);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1))
    {
      if ((this.uHj == 0) || (this.puR)) {
        Log.d("MicroMsg.emoji.BaseEmojiStoreUI", "No More List.");
      }
    }
    else {
      return;
    }
    N(true, false);
    Log.i("MicroMsg.emoji.BaseEmojiStoreUI", "[onScrollStateChanged] startLoadRemoteEmoji.");
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends IListener<du>
  {
    private a()
    {
      AppMethodBeat.i(161086);
      this.__eventId = du.class.getName().hashCode();
      AppMethodBeat.o(161086);
    }
  }
  
  final class b
    implements MenuItem.OnMenuItemClickListener
  {
    private b() {}
    
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