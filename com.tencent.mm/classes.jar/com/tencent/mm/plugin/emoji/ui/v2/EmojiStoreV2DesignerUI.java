package com.tencent.mm.plugin.emoji.ui.v2;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.emoji.a.m;
import com.tencent.mm.g.a.dl;
import com.tencent.mm.g.b.a.x;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.as.a;
import com.tencent.mm.model.as.b;
import com.tencent.mm.model.as.b.a;
import com.tencent.mm.plugin.emoji.e.j.2;
import com.tencent.mm.plugin.emoji.f.i;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.j.a;
import com.tencent.mm.plugin.emoji.model.j.b;
import com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.emoji.BannerEmojiView;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.protocal.protobuf.PersonalDesigner;
import com.tencent.mm.protocal.protobuf.agb;
import com.tencent.mm.protocal.protobuf.bad;
import com.tencent.mm.protocal.protobuf.bgd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.ba;
import com.tencent.mm.storage.ba.a;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.s;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.c;
import com.tencent.mm.ui.base.MMPullDownView.e;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class EmojiStoreV2DesignerUI
  extends MMActivity
  implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener, com.tencent.mm.al.f, j.a, j.b, MMPullDownView.c, MMPullDownView.e
{
  private View agn;
  private boolean llo;
  private ap mHandler;
  private ListView mListView;
  private int mScene;
  private long pEL;
  private String pEM;
  private String pEQ;
  private String pFU;
  com.tencent.mm.plugin.emoji.a.f pHF;
  private int pHg;
  private byte[] pHi;
  protected final int pHm;
  private final int pHn;
  private final int pHo;
  private final String pHp;
  private final String pHq;
  private final String pHr;
  private com.tencent.mm.plugin.emoji.model.f pHu;
  private com.tencent.mm.plugin.emoji.model.j pHv;
  private com.tencent.mm.sdk.b.c pHx;
  private com.tencent.mm.plugin.emoji.f.g pHy;
  private TextView pMA;
  private ImageView pMB;
  private TextView pMC;
  private TextView pMD;
  View pME;
  private List<agb> pMF;
  private View pMG;
  PreViewListGridView pMH;
  private a pMI;
  View pMJ;
  View pMK;
  View pML;
  TextView pMM;
  View pMN;
  private MMPullDownView pMO;
  private bgd pMP;
  private i pMQ;
  private com.tencent.mm.ui.base.p pMR;
  private as.b.a pMS;
  private final int pMT;
  private final int pMU;
  private final int pMV;
  private com.tencent.mm.plugin.emoji.f.p pMW;
  private int pMp;
  private String pMq;
  private String pMr;
  private List<String> pMs;
  private am pMt;
  private View pMu;
  private BannerEmojiView pMv;
  private TextView pMw;
  private TextView pMx;
  private View pMy;
  private View pMz;
  
  public EmojiStoreV2DesignerUI()
  {
    AppMethodBeat.i(109157);
    this.pMF = new ArrayList();
    this.pHg = -1;
    this.pHm = 131074;
    this.pHn = 131075;
    this.pHo = 131076;
    this.pHp = "product_id";
    this.pHq = "progress";
    this.pHr = "status";
    this.pHx = new com.tencent.mm.sdk.b.c() {};
    this.pMS = new as.b.a()
    {
      public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(109149);
        ad.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "getContactCallBack username:%s,succ:%b", new Object[] { paramAnonymousString, Boolean.valueOf(paramAnonymousBoolean) });
        if (paramAnonymousBoolean)
        {
          EmojiStoreV2DesignerUI.a(EmojiStoreV2DesignerUI.this, ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf(paramAnonymousString));
          EmojiStoreV2DesignerUI.a(EmojiStoreV2DesignerUI.this);
        }
        AppMethodBeat.o(109149);
      }
    };
    this.pMT = 10001;
    this.pMU = 10002;
    this.pMV = 10003;
    this.mHandler = new ap()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(109150);
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(109150);
          return;
          EmojiStoreV2DesignerUI.b(EmojiStoreV2DesignerUI.this);
          AppMethodBeat.o(109150);
          return;
          EmojiStoreV2DesignerUI.this.kx(false);
          AppMethodBeat.o(109150);
          return;
          EmojiStoreV2DesignerUI.c(EmojiStoreV2DesignerUI.this);
          AppMethodBeat.o(109150);
          return;
          if ((EmojiStoreV2DesignerUI.d(EmojiStoreV2DesignerUI.this) == null) || (paramAnonymousMessage.getData() == null))
          {
            AppMethodBeat.o(109150);
            return;
          }
          String str = paramAnonymousMessage.getData().getString("product_id");
          if (str == null)
          {
            AppMethodBeat.o(109150);
            return;
          }
          int i = paramAnonymousMessage.getData().getInt("progress");
          EmojiStoreV2DesignerUI.d(EmojiStoreV2DesignerUI.this).cT(str, i);
          AppMethodBeat.o(109150);
          return;
          if ((EmojiStoreV2DesignerUI.d(EmojiStoreV2DesignerUI.this) == null) || (paramAnonymousMessage.getData() == null))
          {
            AppMethodBeat.o(109150);
            return;
          }
          str = paramAnonymousMessage.getData().getString("product_id");
          if (str == null)
          {
            AppMethodBeat.o(109150);
            return;
          }
          i = paramAnonymousMessage.getData().getInt("status");
          EmojiStoreV2DesignerUI.d(EmojiStoreV2DesignerUI.this).cS(str, i);
        }
      }
    };
    AppMethodBeat.o(109157);
  }
  
  private void Zd()
  {
    AppMethodBeat.i(109163);
    setMMTitle(this.pEQ);
    this.pHF = new com.tencent.mm.plugin.emoji.a.f(getContext());
    this.pHF.cN(this.pMs);
    this.mListView.addHeaderView(this.agn);
    this.mListView.setAdapter(this.pHF);
    this.pHF.pBK = this;
    this.pHF.pBf = m.aeT();
    this.pHF.pBg = false;
    this.pMw.setText(this.pEQ);
    this.pMP = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().ILq.aUW(String.valueOf(this.pMp));
    this.pHv = new com.tencent.mm.plugin.emoji.model.j();
    this.pHv.nhZ = this;
    this.pHv.pEH = this.pHF;
    this.pHv.pEK = 6;
    this.pHv.pEN = this;
    this.pHv.pEQ = this.pEQ;
    this.pHv.pEL = this.pEL;
    this.pHv.pEM = this.pEM;
    if (this.pMP != null)
    {
      c(com.tencent.mm.plugin.emoji.f.p.a(this.pMP));
      cR(this.pMP.FCm);
    }
    updateData();
    bb(this.pHi);
    AppMethodBeat.o(109163);
  }
  
  private void b(int paramInt, com.tencent.mm.plugin.emoji.model.f paramf)
  {
    boolean bool = true;
    AppMethodBeat.i(109171);
    switch (paramInt)
    {
    default: 
      bool = false;
    }
    for (;;)
    {
      ky(bool);
      AppMethodBeat.o(109171);
      return;
      this.pHu = paramf;
      continue;
      this.pHu = paramf;
      continue;
      this.pHu = paramf;
      continue;
      if (this.pHu == null) {
        this.pHu = new com.tencent.mm.plugin.emoji.model.f();
      }
      this.pHu.Ca(paramf.pEi);
      this.pHu.cO(paramf.pEj);
    }
  }
  
  private void bb(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(109167);
    this.llo = true;
    this.pMW = new com.tencent.mm.plugin.emoji.f.p(this.pMp, paramArrayOfByte);
    com.tencent.mm.kernel.g.ajB().gAO.a(this.pMW, 0);
    AppMethodBeat.o(109167);
  }
  
  private void c(com.tencent.mm.plugin.emoji.model.f paramf)
  {
    AppMethodBeat.i(109170);
    b(this.pHg, paramf);
    this.pHg = 0;
    AppMethodBeat.o(109170);
  }
  
  private void cR(final List<agb> paramList)
  {
    int i = 1;
    AppMethodBeat.i(109169);
    String str = com.tencent.mm.n.g.acA().getValue("ShowDesignerEmoji");
    ad.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "get dynamic Disgner_Emoji_Store_Show config value:%s", new Object[] { str });
    if ((!bt.isNullOrNil(str)) && (bt.aRe(str) == 1)) {}
    while ((paramList != null) && (paramList.size() > 0) && (i != 0))
    {
      this.pME.setVisibility(0);
      if (this.mHandler != null) {
        this.mHandler.post(new Runnable()
        {
          public final void run()
          {
            int k = 8;
            AppMethodBeat.i(109144);
            EmojiStoreV2DesignerUI localEmojiStoreV2DesignerUI = EmojiStoreV2DesignerUI.this;
            int i;
            View localView;
            if (paramList.size() > 3)
            {
              i = 1;
              if (localEmojiStoreV2DesignerUI.pMH != null) {
                localEmojiStoreV2DesignerUI.pMH.setVisibility(0);
              }
              if (localEmojiStoreV2DesignerUI.pMK != null) {
                localEmojiStoreV2DesignerUI.pMK.setVisibility(0);
              }
              if (localEmojiStoreV2DesignerUI.pMJ != null) {
                localEmojiStoreV2DesignerUI.pMJ.setVisibility(0);
              }
              if (localEmojiStoreV2DesignerUI.pML != null)
              {
                localView = localEmojiStoreV2DesignerUI.pML;
                if (i == 0) {
                  break label185;
                }
              }
            }
            label185:
            for (int j = 0;; j = 8)
            {
              localView.setVisibility(j);
              if (localEmojiStoreV2DesignerUI.pMM != null) {
                localEmojiStoreV2DesignerUI.pMM.setText(2131758347);
              }
              if (localEmojiStoreV2DesignerUI.pMN != null)
              {
                localView = localEmojiStoreV2DesignerUI.pMN;
                j = k;
                if (i != 0) {
                  j = 0;
                }
                localView.setVisibility(j);
              }
              if (localEmojiStoreV2DesignerUI.pME != null) {
                localEmojiStoreV2DesignerUI.pME.setPadding(0, 0, 0, 0);
              }
              AppMethodBeat.o(109144);
              return;
              i = 0;
              break;
            }
          }
        });
      }
      this.pMI.V(paramList);
      AppMethodBeat.o(109169);
      return;
      i = 0;
    }
    this.pME.setVisibility(8);
    AppMethodBeat.o(109169);
  }
  
  private void ciK()
  {
    AppMethodBeat.i(109166);
    if ((this.pMt != null) && ((int)this.pMt.gfj != 0))
    {
      this.pMz.setVisibility(0);
      this.pMy.setVisibility(0);
      if (!bt.isNullOrNil(this.pMt.adu())) {
        this.pMA.setText(this.pMt.adu());
      }
      for (;;)
      {
        a.b.d(this.pMB, this.pMt.field_username);
        this.pMC.setEnabled(true);
        AppMethodBeat.o(109166);
        return;
        this.pMA.setText(this.pMt.field_username);
      }
    }
    this.pMz.setVisibility(8);
    this.pMy.setVisibility(8);
    AppMethodBeat.o(109166);
  }
  
  private void ky(boolean paramBoolean)
  {
    AppMethodBeat.i(109172);
    if ((this.pHu != null) && (paramBoolean))
    {
      if (this.pHF != null) {
        this.pHF.b(this.pHu);
      }
      if (this.mHandler != null) {
        this.mHandler.sendEmptyMessage(10002);
      }
    }
    AppMethodBeat.o(109172);
  }
  
  private void updateData()
  {
    AppMethodBeat.i(109164);
    if (this.pMP == null)
    {
      ad.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "update data failed. data is null.");
      AppMethodBeat.o(109164);
      return;
    }
    kx(true);
    if (!bt.isNullOrNil(this.pMP.FCL))
    {
      ad.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "biz name is :%s", new Object[] { this.pMP.FCL });
      this.pMt = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf(this.pMP.FCL);
      if (((this.pMt == null) || ((int)this.pMt.gfj == 0)) && (as.a.hFO != null))
      {
        ad.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "getContact %s", new Object[] { this.pMP.FCL });
        as.a.hFO.a(this.pMP.FCL, "", this.pMS);
      }
      this.pMC.setText(2131758390);
      if (bt.isNullOrNil(this.pMP.Desc)) {
        break label296;
      }
      this.pMx.setText(this.pMP.Desc);
      this.pMx.setVisibility(0);
    }
    for (;;)
    {
      ciK();
      if ((this.pHu != null) && (this.pHu.pEj != null) && (!this.pHu.pEj.isEmpty())) {
        break label308;
      }
      this.pMD.setVisibility(8);
      AppMethodBeat.o(109164);
      return;
      ad.w("MicroMsg.emoji.EmojiStoreV2DesignerUI", "mData.BizName is null");
      this.pMy.setVisibility(8);
      this.pMz.setVisibility(8);
      break;
      label296:
      this.pMx.setVisibility(8);
    }
    label308:
    this.pMD.setVisibility(0);
    AppMethodBeat.o(109164);
  }
  
  protected final com.tencent.mm.plugin.emoji.f.g R(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(109177);
    this.pHy = new com.tencent.mm.plugin.emoji.f.g(paramString1, paramString2, paramString3);
    paramString1 = this.pHy;
    AppMethodBeat.o(109177);
    return paramString1;
  }
  
  public final void a(com.tencent.mm.plugin.emoji.a.a parama)
  {
    AppMethodBeat.i(109175);
    String str = parama.getProductId();
    if (TextUtils.isEmpty(parama.cgb())) {}
    for (Object localObject = "";; localObject = parama.cgb())
    {
      ad.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "[onProductClick] productId:%s, productPrice:%s, productStatus:%d", new Object[] { str, localObject, Integer.valueOf(parama.cga()) });
      parama.cga();
      localObject = com.tencent.mm.emoji.b.c.goE;
      com.tencent.mm.emoji.b.c.afZ().gR(parama.getProductId());
      localObject = com.tencent.mm.emoji.b.c.goE;
      com.tencent.mm.emoji.b.c.ma(3);
      localObject = com.tencent.mm.emoji.b.c.goE;
      com.tencent.mm.emoji.b.c.afZ().gR("");
      this.pHv.a(parama);
      AppMethodBeat.o(109175);
      return;
    }
  }
  
  final void cS(String paramString, int paramInt)
  {
    AppMethodBeat.i(109180);
    Message localMessage = Message.obtain();
    localMessage.getData().putString("product_id", paramString);
    localMessage.getData().putInt("status", paramInt);
    localMessage.what = 131076;
    if (this.mHandler != null) {
      this.mHandler.sendMessage(localMessage);
    }
    AppMethodBeat.o(109180);
  }
  
  final void cT(String paramString, int paramInt)
  {
    AppMethodBeat.i(109179);
    Message localMessage = Message.obtain();
    localMessage.getData().putString("product_id", paramString);
    localMessage.getData().putInt("progress", paramInt);
    localMessage.what = 131075;
    if (this.mHandler != null) {
      this.mHandler.sendMessage(localMessage);
    }
    AppMethodBeat.o(109179);
  }
  
  public final boolean cba()
  {
    return true;
  }
  
  public final boolean cbc()
  {
    return false;
  }
  
  public final void cgM() {}
  
  protected final void chG()
  {
    AppMethodBeat.i(109178);
    com.tencent.mm.kernel.g.ajB().gAO.a(this.pHy, 0);
    AppMethodBeat.o(109178);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131493807;
  }
  
  public void initView()
  {
    AppMethodBeat.i(109162);
    if (!bt.isNullOrNil(this.pEQ)) {
      setMMTitle(this.pEQ);
    }
    this.agn = z.jO(getContext()).inflate(2131493803, null);
    this.pMu = this.agn.findViewById(2131299021);
    this.pMv = ((BannerEmojiView)this.pMu.findViewById(2131299332));
    this.pMw = ((TextView)this.agn.findViewById(2131299023));
    this.pMx = ((TextView)this.agn.findViewById(2131299019));
    this.pMy = this.agn.findViewById(2131299017);
    this.pMz = this.agn.findViewById(2131299016);
    this.pMA = ((TextView)this.agn.findViewById(2131299032));
    this.pMB = ((ImageView)this.agn.findViewById(2131299022));
    this.pMC = ((TextView)this.agn.findViewById(2131299020));
    this.pMD = ((TextView)this.agn.findViewById(2131299033));
    this.pME = this.agn.findViewById(2131299024);
    this.pMG = this.agn.findViewById(2131299028);
    this.pMG.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(109151);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2DesignerUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        EmojiStoreV2DesignerUI.e(EmojiStoreV2DesignerUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2DesignerUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(109151);
      }
    });
    this.pMH = ((PreViewListGridView)this.agn.findViewById(2131299027));
    this.pMI = new a(getContext());
    this.pMI.pPE = new a.a()
    {
      public final void BU(int paramAnonymousInt)
      {
        AppMethodBeat.i(109152);
        if ((EmojiStoreV2DesignerUI.f(EmojiStoreV2DesignerUI.this) != null) && (EmojiStoreV2DesignerUI.g(EmojiStoreV2DesignerUI.this) != null))
        {
          agb localagb = EmojiStoreV2DesignerUI.g(EmojiStoreV2DesignerUI.this).Cj(paramAnonymousInt);
          if (localagb != null)
          {
            com.tencent.mm.plugin.report.service.g.yhR.f(12787, new Object[] { Integer.valueOf(1), Integer.valueOf(0), localagb.Md5, Long.valueOf(EmojiStoreV2DesignerUI.h(EmojiStoreV2DesignerUI.this)), localagb.GdY, localagb.ProductID, Integer.valueOf(6) });
            try
            {
              Intent localIntent = new Intent();
              localIntent.putExtra("extra_object", localagb.toByteArray());
              localIntent.putExtra("add_source", 5);
              localIntent.putExtra("entrance_scene", 6);
              localIntent.setClass(EmojiStoreV2DesignerUI.this.getContext(), EmojiStoreV2SingleProductDialogUI.class);
              EmojiStoreV2DesignerUI.this.startActivityForResult(localIntent, 2004);
              EmojiStoreV2DesignerUI.this.overridePendingTransition(2130772095, 2130772100);
              AppMethodBeat.o(109152);
              return;
            }
            catch (Exception localException) {}
          }
        }
        AppMethodBeat.o(109152);
      }
    };
    this.pMH.setAdapter(this.pMI);
    this.pMJ = this.agn.findViewById(2131299029);
    this.pMK = this.agn.findViewById(2131299030);
    this.pML = this.agn.findViewById(2131299028);
    this.pMM = ((TextView)this.agn.findViewById(2131299031));
    this.pMN = this.agn.findViewById(2131299026);
    this.pMO = ((MMPullDownView)findViewById(2131301487));
    this.pMO.setOnBottomLoadDataListener(this);
    this.pMO.setAtBottomCallBack(this);
    this.pMO.setBottomViewVisible(false);
    this.pMO.setIsBottomShowAll(false);
    this.mListView = ((ListView)findViewById(16908298));
    this.mListView.setOnItemClickListener(this);
    this.mListView.setOnScrollListener(this);
    this.pMz.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(109153);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2DesignerUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        EmojiStoreV2DesignerUI.i(EmojiStoreV2DesignerUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2DesignerUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(109153);
      }
    });
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(109154);
        EmojiStoreV2DesignerUI.this.finish();
        AppMethodBeat.o(109154);
        return false;
      }
    });
    addIconOptionMenu(0, 2131690655, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(109155);
        ad.d("MicroMsg.emoji.EmojiStoreV2DesignerUI", "on shard click.");
        EmojiStoreV2DesignerUI.j(EmojiStoreV2DesignerUI.this);
        AppMethodBeat.o(109155);
        return true;
      }
    });
    AppMethodBeat.o(109162);
  }
  
  public final void k(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(109176);
    R(paramString1, paramString2, paramString3);
    chG();
    AppMethodBeat.o(109176);
  }
  
  protected final void kx(boolean paramBoolean)
  {
    AppMethodBeat.i(109165);
    if (this.pMP == null)
    {
      ad.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "update header failed. data is null.");
      AppMethodBeat.o(109165);
      return;
    }
    if ((this.pMv != null) && (!bt.isNullOrNil(this.pMP.GBA)))
    {
      Object localObject = this.pMP.GBA;
      com.tencent.mm.cc.a.getDensity(this);
      localObject = EmojiLogic.y("Designer", 8, (String)localObject);
      if (localObject == null)
      {
        if (paramBoolean)
        {
          com.tencent.mm.aw.q.aIJ().a(this.pMP.GBA, null, com.tencent.mm.plugin.emoji.e.e.h("Designer", this.pMP.GBA, new Object[] { "Designer", "BANNER" }), new com.tencent.mm.aw.a.c.k()
          {
            public final void a(String paramAnonymousString, View paramAnonymousView, Bitmap paramAnonymousBitmap, Object... paramAnonymousVarArgs)
            {
              AppMethodBeat.i(109156);
              if (EmojiStoreV2DesignerUI.k(EmojiStoreV2DesignerUI.this) != null) {
                EmojiStoreV2DesignerUI.k(EmojiStoreV2DesignerUI.this).sendEmptyMessage(10001);
              }
              AppMethodBeat.o(109156);
            }
          });
          AppMethodBeat.o(109165);
          return;
        }
        ad.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "updateDesignerHeader failed");
        AppMethodBeat.o(109165);
        return;
      }
      this.pMv.setImageFilePath(((EmojiInfo)localObject).gzQ());
    }
    AppMethodBeat.o(109165);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(109181);
    this.pHv.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 2002) {
      if (paramInt2 == -1)
      {
        String str1 = paramIntent.getStringExtra("Select_Conv_User");
        if ((bt.isNullOrNil(str1)) || (this.pMP == null)) {
          break label224;
        }
        ad.d("MicroMsg.emoji.EmojiStoreV2DesignerUI", "..".concat(String.valueOf(str1)));
        String str2 = this.pEQ;
        String str3 = this.pMP.Desc;
        int i = this.pMp;
        String str4 = this.pMr;
        String str5 = this.pEQ;
        String str6 = this.pMP.HeadUrl;
        String str7 = getResources().getString(2131755710);
        str7 = str7 + str2;
        String str8 = getString(2131755884);
        String str9 = getString(2131757559);
        ((com.tencent.mm.pluginsdk.j)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.j.class)).a(this, str1, str7, str8, str9, str6, new j.2(str1, str5, str3, i, str4, str2, str6, this));
      }
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(109181);
      return;
      label224:
      ad.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "member or data is null.");
      continue;
      if ((paramInt1 == 2004) && (paramInt2 == -1)) {
        com.tencent.mm.ui.widget.snackbar.b.n(this, getContext().getString(2131755887));
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(109158);
    super.onCreate(paramBundle);
    this.pFU = getIntent().getStringExtra("id");
    this.pMp = getIntent().getIntExtra("uin", 0);
    this.pEQ = getIntent().getStringExtra("name");
    this.pMq = getIntent().getStringExtra("headurl");
    this.pMr = getIntent().getStringExtra("rediret_url");
    this.mScene = getIntent().getIntExtra("extra_scence", 0);
    this.pEL = getIntent().getLongExtra("searchID", 0L);
    this.pEM = bt.bI(getIntent().getStringExtra("docID"), "");
    paramBundle = getIntent().getStringExtra("sns_object_data");
    if (!TextUtils.isEmpty(paramBundle))
    {
      this.pMp = EmojiLogic.abA(paramBundle);
      this.pEQ = EmojiLogic.abB(paramBundle);
      this.pMr = EmojiLogic.abJ(paramBundle);
    }
    initView();
    paramBundle = ba.a.IKU;
    paramBundle = ba.a.aaS(this.pMp);
    int i = (int)bt.aQJ();
    paramBundle = (Iterable)paramBundle.IKR;
    Collection localCollection = (Collection)new ArrayList();
    Iterator localIterator = paramBundle.iterator();
    label281:
    while (localIterator.hasNext())
    {
      paramBundle = (com.tencent.mm.storage.emotion.a)localIterator.next();
      if (paramBundle.field_syncTime > i - 2592000L) {}
      for (paramBundle = paramBundle.field_productId;; paramBundle = null)
      {
        if (paramBundle == null) {
          break label281;
        }
        localCollection.add(paramBundle);
        break;
      }
    }
    this.pMs = ((List)localCollection);
    if (!bt.isNullOrNil(this.pFU))
    {
      paramBundle = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().ILt.aUR(this.pFU);
      if ((paramBundle != null) && (paramBundle.Gxo != null) && (paramBundle.Gxo.DesignerUin != 0) && (!bt.isNullOrNil(paramBundle.Gxo.Name)))
      {
        this.pMp = paramBundle.Gxo.DesignerUin;
        this.pEQ = paramBundle.Gxo.Name;
        ad.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "uin:%s name:%s", new Object[] { Integer.valueOf(this.pMp), this.pEQ });
      }
    }
    else
    {
      i = 0;
      if (i != 0) {
        break label579;
      }
      Zd();
    }
    for (;;)
    {
      com.tencent.mm.kernel.g.ajB().gAO.a(239, this);
      com.tencent.mm.kernel.g.ajB().gAO.a(720, this);
      com.tencent.mm.sdk.b.a.IbL.c(this.pHx);
      com.tencent.mm.plugin.report.service.g.yhR.f(12067, new Object[] { Integer.valueOf(1), "", "", "", "" });
      com.tencent.mm.plugin.report.service.g.yhR.f(12740, new Object[] { Integer.valueOf(2), com.tencent.mm.b.p.getString(this.pMp), "", "", Integer.valueOf(this.mScene), Integer.valueOf(6) });
      paramBundle = ba.a.IKU;
      ba.a.aaS(this.pMp).frb();
      AppMethodBeat.o(109158);
      return;
      i = 1;
      break;
      label579:
      this.pMQ = new i(this.pFU);
      com.tencent.mm.kernel.g.ajB().gAO.a(this.pMQ, 0);
      getString(2131755906);
      this.pMR = h.b(this, getString(2131755936), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(109148);
          if (EmojiStoreV2DesignerUI.p(EmojiStoreV2DesignerUI.this) != null) {
            com.tencent.mm.kernel.g.ajB().gAO.a(EmojiStoreV2DesignerUI.p(EmojiStoreV2DesignerUI.this));
          }
          AppMethodBeat.o(109148);
        }
      });
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(109161);
    super.onDestroy();
    com.tencent.mm.emoji.b.c localc = com.tencent.mm.emoji.b.c.goE;
    com.tencent.mm.emoji.b.c.afZ().gR("");
    localc = com.tencent.mm.emoji.b.c.goE;
    com.tencent.mm.emoji.b.c.ma(5);
    if (this.pMW != null) {
      com.tencent.mm.kernel.g.ajB().gAO.a(this.pMW);
    }
    com.tencent.mm.kernel.g.ajB().gAO.b(239, this);
    com.tencent.mm.kernel.g.ajB().gAO.b(720, this);
    com.tencent.mm.sdk.b.a.IbL.d(this.pHx);
    if (this.mHandler != null)
    {
      this.mHandler.removeMessages(10002);
      this.mHandler.removeMessages(10001);
      this.mHandler = null;
    }
    AppMethodBeat.o(109161);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(109174);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAdapterView);
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
    ((com.tencent.mm.hellhoundlib.b.b)localObject).mr(paramInt);
    ((com.tencent.mm.hellhoundlib.b.b)localObject).qY(paramLong);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2DesignerUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
    if (this.pHF != null)
    {
      int i = this.mListView.getHeaderViewsCount();
      paramAdapterView = this.pHF.BS(paramInt - i);
      if (paramAdapterView != null)
      {
        paramView = new Intent();
        paramView.setClass(this, EmojiStoreDetailUI.class);
        localObject = paramAdapterView.pBV;
        if (localObject != null) {
          break label222;
        }
        paramAdapterView = null;
      }
    }
    for (;;)
    {
      if (paramAdapterView != null)
      {
        paramAdapterView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAdapterView);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramAdapterView.ahp(), "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2DesignerUI", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramAdapterView.mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2DesignerUI", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2DesignerUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(109174);
      return;
      label222:
      com.tencent.mm.emoji.b.c localc = com.tencent.mm.emoji.b.c.goE;
      com.tencent.mm.emoji.b.c.afZ().gR(((EmotionSummary)localObject).ProductID);
      localc = com.tencent.mm.emoji.b.c.goE;
      com.tencent.mm.emoji.b.c.ma(4);
      localc = com.tencent.mm.emoji.b.c.goE;
      com.tencent.mm.emoji.b.c.afZ().gR("");
      paramView.putExtra("extra_id", ((EmotionSummary)localObject).ProductID);
      paramView.putExtra("extra_name", ((EmotionSummary)localObject).PackName);
      paramView.putExtra("extra_copyright", ((EmotionSummary)localObject).PackCopyright);
      paramView.putExtra("extra_coverurl", ((EmotionSummary)localObject).CoverUrl);
      paramView.putExtra("extra_description", ((EmotionSummary)localObject).PackDesc);
      paramView.putExtra("extra_price", ((EmotionSummary)localObject).PackPrice);
      paramView.putExtra("extra_type", ((EmotionSummary)localObject).PackType);
      paramView.putExtra("extra_flag", ((EmotionSummary)localObject).PackFlag);
      paramView.putExtra("preceding_scence", 106);
      paramView.putExtra("download_entrance_scene", 6);
      paramView.putExtra("call_by", 1);
      paramView.putExtra("check_clickflag", false);
      paramView.putExtra("extra_status", paramAdapterView.mStatus);
      paramView.putExtra("extra_progress", paramAdapterView.Hx);
      paramView.putExtra("searchID", this.pEL);
      localObject = getIntent().getStringExtra("to_talker_name");
      paramAdapterView = paramView;
      if (!bt.isNullOrNil((String)localObject))
      {
        paramView.putExtra("to_talker_name", (String)localObject);
        paramAdapterView = paramView;
      }
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(109160);
    super.onPause();
    com.tencent.mm.kernel.g.ajB().gAO.b(423, this);
    AppMethodBeat.o(109160);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(109159);
    super.onResume();
    com.tencent.mm.kernel.g.ajB().gAO.a(423, this);
    AppMethodBeat.o(109159);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, final n paramn)
  {
    AppMethodBeat.i(109168);
    switch (paramn.getType())
    {
    default: 
      ad.e("MicroMsg.emoji.EmojiStoreV2DesignerUI", "unknow scene type");
    case 423: 
    case 720: 
      do
      {
        do
        {
          AppMethodBeat.o(109168);
          return;
        } while (!(paramn instanceof com.tencent.mm.plugin.emoji.f.g));
        paramString = (com.tencent.mm.plugin.emoji.f.g)paramn;
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          cT(paramString.pFG, 0);
          AppMethodBeat.o(109168);
          return;
        }
        paramn = paramString.pFG;
        final String str1 = paramString.pFI;
        final String str2 = paramString.pFH;
        h.a(this, getString(2131758320, new Object[] { str2 }), "", new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(109145);
            EmojiStoreV2DesignerUI.this.R(paramn, str1, str2);
            EmojiStoreV2DesignerUI.this.chG();
            ad.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "Retry doScene ExchangeEmotionPackNetScene productId:%s", new Object[] { paramn });
            EmojiStoreV2DesignerUI.a(EmojiStoreV2DesignerUI.this, paramn);
            AppMethodBeat.o(109145);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        cS(paramString.pFG, -1);
        AppMethodBeat.o(109168);
        return;
      } while (!(paramn instanceof com.tencent.mm.plugin.emoji.f.p));
      this.llo = false;
      if ((paramInt1 == 0) || (paramInt1 == 4))
      {
        paramString = (com.tencent.mm.plugin.emoji.f.p)paramn;
        paramn = com.tencent.mm.plugin.emoji.f.p.a(paramString.chm());
        if (paramInt2 == 0)
        {
          this.pMP = paramString.chm();
          c(paramn);
        }
        for (;;)
        {
          if ((this.pHi == null) && (this.pMP != null))
          {
            com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().ILq.a(String.valueOf(this.pMp), paramString.chm());
            this.pMF = this.pMP.FCm;
            cR(this.pMF);
          }
          this.pHi = paramString.pGa;
          AppMethodBeat.o(109168);
          return;
          if (paramInt2 == 2)
          {
            this.pMP = paramString.chm();
            b(this.pHg, paramn);
            this.pHg = 2;
          }
          else if (paramInt2 == 3)
          {
            this.pMP = paramString.chm();
            b(this.pHg, paramn);
            this.pHg = 1;
            ad.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "get person designer failed errCode:%d", new Object[] { Integer.valueOf(paramInt2) });
          }
        }
      }
      ad.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "get person designer failed");
      AppMethodBeat.o(109168);
      return;
    }
    if ((this.pMR != null) && (this.pMR.isShowing())) {
      this.pMR.dismiss();
    }
    if ((paramInt2 == 0) && (paramInt1 == 0))
    {
      paramString = ((i)paramn).che();
      if ((paramString != null) && (paramString.Gxo != null))
      {
        this.pMp = paramString.Gxo.DesignerUin;
        this.pEQ = paramString.Gxo.Name;
        this.pMq = paramString.Gxo.HeadUrl;
        if (this.mHandler != null) {
          this.mHandler.sendEmptyMessage(10003);
        }
      }
      AppMethodBeat.o(109168);
      return;
    }
    showOptionMenu(0, false);
    h.c(getContext(), getString(2131758253), null, true);
    ad.e("MicroMsg.emoji.EmojiStoreV2DesignerUI", "open designer failed .");
    AppMethodBeat.o(109168);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(109173);
    if ((paramInt == 0) && (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1))
    {
      if ((this.pHg == 0) || (this.llo))
      {
        ad.d("MicroMsg.emoji.EmojiStoreV2DesignerUI", "No More List.");
        AppMethodBeat.o(109173);
        return;
      }
      bb(this.pHi);
      ad.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "[onScrollStateChanged] startLoadRemoteEmoji.");
    }
    AppMethodBeat.o(109173);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI
 * JD-Core Version:    0.7.0.1
 */