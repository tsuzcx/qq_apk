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
import com.tencent.mm.ak.n;
import com.tencent.mm.emoji.a.m;
import com.tencent.mm.g.a.dm;
import com.tencent.mm.g.b.a.x;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.au.a;
import com.tencent.mm.model.au.b;
import com.tencent.mm.model.au.b.a;
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
import com.tencent.mm.protocal.protobuf.agk;
import com.tencent.mm.protocal.protobuf.bat;
import com.tencent.mm.protocal.protobuf.bgt;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.bb.a;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bq;
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
  implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener, com.tencent.mm.ak.f, j.a, j.b, MMPullDownView.c, MMPullDownView.e
{
  private View agn;
  private boolean lpM;
  private aq mHandler;
  private ListView mListView;
  private int mScene;
  private long pLp;
  private String pLq;
  private String pLu;
  private String pMy;
  private int pNK;
  private byte[] pNM;
  protected final int pNQ;
  private final int pNR;
  private final int pNS;
  private final String pNT;
  private final String pNU;
  private final String pNV;
  private com.tencent.mm.plugin.emoji.model.f pNY;
  private com.tencent.mm.plugin.emoji.model.j pNZ;
  private com.tencent.mm.sdk.b.c pOb;
  private com.tencent.mm.plugin.emoji.f.g pOc;
  com.tencent.mm.plugin.emoji.a.f pOj;
  private int pSU;
  private String pSV;
  private String pSW;
  private List<String> pSX;
  private an pSY;
  private View pSZ;
  private final int pTA;
  private com.tencent.mm.plugin.emoji.f.p pTB;
  private BannerEmojiView pTa;
  private TextView pTb;
  private TextView pTc;
  private View pTd;
  private View pTe;
  private TextView pTf;
  private ImageView pTg;
  private TextView pTh;
  private TextView pTi;
  View pTj;
  private List<agk> pTk;
  private View pTl;
  PreViewListGridView pTm;
  private a pTn;
  View pTo;
  View pTp;
  View pTq;
  TextView pTr;
  View pTs;
  private MMPullDownView pTt;
  private bgt pTu;
  private i pTv;
  private com.tencent.mm.ui.base.p pTw;
  private au.b.a pTx;
  private final int pTy;
  private final int pTz;
  
  public EmojiStoreV2DesignerUI()
  {
    AppMethodBeat.i(109157);
    this.pTk = new ArrayList();
    this.pNK = -1;
    this.pNQ = 131074;
    this.pNR = 131075;
    this.pNS = 131076;
    this.pNT = "product_id";
    this.pNU = "progress";
    this.pNV = "status";
    this.pOb = new com.tencent.mm.sdk.b.c() {};
    this.pTx = new au.b.a()
    {
      public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(109149);
        ae.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "getContactCallBack username:%s,succ:%b", new Object[] { paramAnonymousString, Boolean.valueOf(paramAnonymousBoolean) });
        if (paramAnonymousBoolean)
        {
          EmojiStoreV2DesignerUI.a(EmojiStoreV2DesignerUI.this, ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(paramAnonymousString));
          EmojiStoreV2DesignerUI.a(EmojiStoreV2DesignerUI.this);
        }
        AppMethodBeat.o(109149);
      }
    };
    this.pTy = 10001;
    this.pTz = 10002;
    this.pTA = 10003;
    this.mHandler = new aq()
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
          EmojiStoreV2DesignerUI.this.kw(false);
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
          EmojiStoreV2DesignerUI.d(EmojiStoreV2DesignerUI.this).cX(str, i);
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
          EmojiStoreV2DesignerUI.d(EmojiStoreV2DesignerUI.this).cW(str, i);
        }
      }
    };
    AppMethodBeat.o(109157);
  }
  
  private void Zm()
  {
    AppMethodBeat.i(109163);
    setMMTitle(this.pLu);
    this.pOj = new com.tencent.mm.plugin.emoji.a.f(getContext());
    this.pOj.cQ(this.pSX);
    this.mListView.addHeaderView(this.agn);
    this.mListView.setAdapter(this.pOj);
    this.pOj.pIo = this;
    this.pOj.pHJ = m.afh();
    this.pOj.pHK = false;
    this.pTb.setText(this.pLu);
    this.pTu = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().JfX.aWx(String.valueOf(this.pSU));
    this.pNZ = new com.tencent.mm.plugin.emoji.model.j();
    this.pNZ.nnh = this;
    this.pNZ.pLl = this.pOj;
    this.pNZ.pLo = 6;
    this.pNZ.pLr = this;
    this.pNZ.pLu = this.pLu;
    this.pNZ.pLp = this.pLp;
    this.pNZ.pLq = this.pLq;
    if (this.pTu != null)
    {
      c(com.tencent.mm.plugin.emoji.f.p.a(this.pTu));
      cU(this.pTu.FUH);
    }
    updateData();
    ba(this.pNM);
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
      kx(bool);
      AppMethodBeat.o(109171);
      return;
      this.pNY = paramf;
      continue;
      this.pNY = paramf;
      continue;
      this.pNY = paramf;
      continue;
      if (this.pNY == null) {
        this.pNY = new com.tencent.mm.plugin.emoji.model.f();
      }
      this.pNY.Cm(paramf.pKM);
      this.pNY.cR(paramf.pKN);
    }
  }
  
  private void ba(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(109167);
    this.lpM = true;
    this.pTB = new com.tencent.mm.plugin.emoji.f.p(this.pSU, paramArrayOfByte);
    com.tencent.mm.kernel.g.ajQ().gDv.a(this.pTB, 0);
    AppMethodBeat.o(109167);
  }
  
  private void c(com.tencent.mm.plugin.emoji.model.f paramf)
  {
    AppMethodBeat.i(109170);
    b(this.pNK, paramf);
    this.pNK = 0;
    AppMethodBeat.o(109170);
  }
  
  private void cU(final List<agk> paramList)
  {
    int i = 1;
    AppMethodBeat.i(109169);
    String str = com.tencent.mm.n.g.acL().getValue("ShowDesignerEmoji");
    ae.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "get dynamic Disgner_Emoji_Store_Show config value:%s", new Object[] { str });
    if ((!bu.isNullOrNil(str)) && (bu.aSB(str) == 1)) {}
    while ((paramList != null) && (paramList.size() > 0) && (i != 0))
    {
      this.pTj.setVisibility(0);
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
              if (localEmojiStoreV2DesignerUI.pTm != null) {
                localEmojiStoreV2DesignerUI.pTm.setVisibility(0);
              }
              if (localEmojiStoreV2DesignerUI.pTp != null) {
                localEmojiStoreV2DesignerUI.pTp.setVisibility(0);
              }
              if (localEmojiStoreV2DesignerUI.pTo != null) {
                localEmojiStoreV2DesignerUI.pTo.setVisibility(0);
              }
              if (localEmojiStoreV2DesignerUI.pTq != null)
              {
                localView = localEmojiStoreV2DesignerUI.pTq;
                if (i == 0) {
                  break label185;
                }
              }
            }
            label185:
            for (int j = 0;; j = 8)
            {
              localView.setVisibility(j);
              if (localEmojiStoreV2DesignerUI.pTr != null) {
                localEmojiStoreV2DesignerUI.pTr.setText(2131758347);
              }
              if (localEmojiStoreV2DesignerUI.pTs != null)
              {
                localView = localEmojiStoreV2DesignerUI.pTs;
                j = k;
                if (i != 0) {
                  j = 0;
                }
                localView.setVisibility(j);
              }
              if (localEmojiStoreV2DesignerUI.pTj != null) {
                localEmojiStoreV2DesignerUI.pTj.setPadding(0, 0, 0, 0);
              }
              AppMethodBeat.o(109144);
              return;
              i = 0;
              break;
            }
          }
        });
      }
      this.pTn.V(paramList);
      AppMethodBeat.o(109169);
      return;
      i = 0;
    }
    this.pTj.setVisibility(8);
    AppMethodBeat.o(109169);
  }
  
  private void cka()
  {
    AppMethodBeat.i(109166);
    if ((this.pSY != null) && ((int)this.pSY.ght != 0))
    {
      this.pTe.setVisibility(0);
      this.pTd.setVisibility(0);
      if (!bu.isNullOrNil(this.pSY.adF())) {
        this.pTf.setText(this.pSY.adF());
      }
      for (;;)
      {
        a.b.d(this.pTg, this.pSY.field_username);
        this.pTh.setEnabled(true);
        AppMethodBeat.o(109166);
        return;
        this.pTf.setText(this.pSY.field_username);
      }
    }
    this.pTe.setVisibility(8);
    this.pTd.setVisibility(8);
    AppMethodBeat.o(109166);
  }
  
  private void kx(boolean paramBoolean)
  {
    AppMethodBeat.i(109172);
    if ((this.pNY != null) && (paramBoolean))
    {
      if (this.pOj != null) {
        this.pOj.b(this.pNY);
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
    if (this.pTu == null)
    {
      ae.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "update data failed. data is null.");
      AppMethodBeat.o(109164);
      return;
    }
    kw(true);
    if (!bu.isNullOrNil(this.pTu.FVg))
    {
      ae.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "biz name is :%s", new Object[] { this.pTu.FVg });
      this.pSY = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(this.pTu.FVg);
      if (((this.pSY == null) || ((int)this.pSY.ght == 0)) && (au.a.hIG != null))
      {
        ae.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "getContact %s", new Object[] { this.pTu.FVg });
        au.a.hIG.a(this.pTu.FVg, "", this.pTx);
      }
      this.pTh.setText(2131758390);
      if (bu.isNullOrNil(this.pTu.Desc)) {
        break label296;
      }
      this.pTc.setText(this.pTu.Desc);
      this.pTc.setVisibility(0);
    }
    for (;;)
    {
      cka();
      if ((this.pNY != null) && (this.pNY.pKN != null) && (!this.pNY.pKN.isEmpty())) {
        break label308;
      }
      this.pTi.setVisibility(8);
      AppMethodBeat.o(109164);
      return;
      ae.w("MicroMsg.emoji.EmojiStoreV2DesignerUI", "mData.BizName is null");
      this.pTd.setVisibility(8);
      this.pTe.setVisibility(8);
      break;
      label296:
      this.pTc.setVisibility(8);
    }
    label308:
    this.pTi.setVisibility(0);
    AppMethodBeat.o(109164);
  }
  
  protected final com.tencent.mm.plugin.emoji.f.g S(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(109177);
    this.pOc = new com.tencent.mm.plugin.emoji.f.g(paramString1, paramString2, paramString3);
    paramString1 = this.pOc;
    AppMethodBeat.o(109177);
    return paramString1;
  }
  
  public final void a(com.tencent.mm.plugin.emoji.a.a parama)
  {
    AppMethodBeat.i(109175);
    String str = parama.getProductId();
    if (TextUtils.isEmpty(parama.chr())) {}
    for (Object localObject = "";; localObject = parama.chr())
    {
      ae.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "[onProductClick] productId:%s, productPrice:%s, productStatus:%d", new Object[] { str, localObject, Integer.valueOf(parama.chq()) });
      parama.chq();
      localObject = com.tencent.mm.emoji.b.c.gqZ;
      com.tencent.mm.emoji.b.c.agn().gX(parama.getProductId());
      localObject = com.tencent.mm.emoji.b.c.gqZ;
      com.tencent.mm.emoji.b.c.md(3);
      localObject = com.tencent.mm.emoji.b.c.gqZ;
      com.tencent.mm.emoji.b.c.agn().gX("");
      this.pNZ.a(parama);
      AppMethodBeat.o(109175);
      return;
    }
  }
  
  final void cW(String paramString, int paramInt)
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
  
  final void cX(String paramString, int paramInt)
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
  
  public final boolean ccp()
  {
    return true;
  }
  
  public final boolean ccr()
  {
    return false;
  }
  
  protected final void ciW()
  {
    AppMethodBeat.i(109178);
    com.tencent.mm.kernel.g.ajQ().gDv.a(this.pOc, 0);
    AppMethodBeat.o(109178);
  }
  
  public final void cic() {}
  
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
    if (!bu.isNullOrNil(this.pLu)) {
      setMMTitle(this.pLu);
    }
    this.agn = z.jV(getContext()).inflate(2131493803, null);
    this.pSZ = this.agn.findViewById(2131299021);
    this.pTa = ((BannerEmojiView)this.pSZ.findViewById(2131299332));
    this.pTb = ((TextView)this.agn.findViewById(2131299023));
    this.pTc = ((TextView)this.agn.findViewById(2131299019));
    this.pTd = this.agn.findViewById(2131299017);
    this.pTe = this.agn.findViewById(2131299016);
    this.pTf = ((TextView)this.agn.findViewById(2131299032));
    this.pTg = ((ImageView)this.agn.findViewById(2131299022));
    this.pTh = ((TextView)this.agn.findViewById(2131299020));
    this.pTi = ((TextView)this.agn.findViewById(2131299033));
    this.pTj = this.agn.findViewById(2131299024);
    this.pTl = this.agn.findViewById(2131299028);
    this.pTl.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(109151);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2DesignerUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        EmojiStoreV2DesignerUI.e(EmojiStoreV2DesignerUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2DesignerUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(109151);
      }
    });
    this.pTm = ((PreViewListGridView)this.agn.findViewById(2131299027));
    this.pTn = new a(getContext());
    this.pTn.pWj = new a.a()
    {
      public final void Cg(int paramAnonymousInt)
      {
        AppMethodBeat.i(109152);
        if ((EmojiStoreV2DesignerUI.f(EmojiStoreV2DesignerUI.this) != null) && (EmojiStoreV2DesignerUI.g(EmojiStoreV2DesignerUI.this) != null))
        {
          agk localagk = EmojiStoreV2DesignerUI.g(EmojiStoreV2DesignerUI.this).Cv(paramAnonymousInt);
          if (localagk != null)
          {
            com.tencent.mm.plugin.report.service.g.yxI.f(12787, new Object[] { Integer.valueOf(1), Integer.valueOf(0), localagk.Md5, Long.valueOf(EmojiStoreV2DesignerUI.h(EmojiStoreV2DesignerUI.this)), localagk.GwF, localagk.ProductID, Integer.valueOf(6) });
            try
            {
              Intent localIntent = new Intent();
              localIntent.putExtra("extra_object", localagk.toByteArray());
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
    this.pTm.setAdapter(this.pTn);
    this.pTo = this.agn.findViewById(2131299029);
    this.pTp = this.agn.findViewById(2131299030);
    this.pTq = this.agn.findViewById(2131299028);
    this.pTr = ((TextView)this.agn.findViewById(2131299031));
    this.pTs = this.agn.findViewById(2131299026);
    this.pTt = ((MMPullDownView)findViewById(2131301487));
    this.pTt.setOnBottomLoadDataListener(this);
    this.pTt.setAtBottomCallBack(this);
    this.pTt.setBottomViewVisible(false);
    this.pTt.setIsBottomShowAll(false);
    this.mListView = ((ListView)findViewById(16908298));
    this.mListView.setOnItemClickListener(this);
    this.mListView.setOnScrollListener(this);
    this.pTe.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(109153);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2DesignerUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
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
        ae.d("MicroMsg.emoji.EmojiStoreV2DesignerUI", "on shard click.");
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
    S(paramString1, paramString2, paramString3);
    ciW();
    AppMethodBeat.o(109176);
  }
  
  protected final void kw(boolean paramBoolean)
  {
    AppMethodBeat.i(109165);
    if (this.pTu == null)
    {
      ae.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "update header failed. data is null.");
      AppMethodBeat.o(109165);
      return;
    }
    if ((this.pTa != null) && (!bu.isNullOrNil(this.pTu.GVa)))
    {
      Object localObject = this.pTu.GVa;
      com.tencent.mm.cb.a.getDensity(this);
      localObject = EmojiLogic.A("Designer", 8, (String)localObject);
      if (localObject == null)
      {
        if (paramBoolean)
        {
          com.tencent.mm.av.q.aJb().a(this.pTu.GVa, null, com.tencent.mm.plugin.emoji.e.e.h("Designer", this.pTu.GVa, new Object[] { "Designer", "BANNER" }), new com.tencent.mm.av.a.c.k()
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
        ae.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "updateDesignerHeader failed");
        AppMethodBeat.o(109165);
        return;
      }
      this.pTa.setImageFilePath(((EmojiInfo)localObject).fSQ());
    }
    AppMethodBeat.o(109165);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(109181);
    this.pNZ.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 2002) {
      if (paramInt2 == -1)
      {
        String str1 = paramIntent.getStringExtra("Select_Conv_User");
        if ((bu.isNullOrNil(str1)) || (this.pTu == null)) {
          break label224;
        }
        ae.d("MicroMsg.emoji.EmojiStoreV2DesignerUI", "..".concat(String.valueOf(str1)));
        String str2 = this.pLu;
        String str3 = this.pTu.Desc;
        int i = this.pSU;
        String str4 = this.pSW;
        String str5 = this.pLu;
        String str6 = this.pTu.HeadUrl;
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
      ae.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "member or data is null.");
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
    this.pMy = getIntent().getStringExtra("id");
    this.pSU = getIntent().getIntExtra("uin", 0);
    this.pLu = getIntent().getStringExtra("name");
    this.pSV = getIntent().getStringExtra("headurl");
    this.pSW = getIntent().getStringExtra("rediret_url");
    this.mScene = getIntent().getIntExtra("extra_scence", 0);
    this.pLp = getIntent().getLongExtra("searchID", 0L);
    this.pLq = bu.bI(getIntent().getStringExtra("docID"), "");
    paramBundle = getIntent().getStringExtra("sns_object_data");
    if (!TextUtils.isEmpty(paramBundle))
    {
      this.pSU = EmojiLogic.acr(paramBundle);
      this.pLu = EmojiLogic.acs(paramBundle);
      this.pSW = EmojiLogic.acA(paramBundle);
    }
    initView();
    paramBundle = bb.a.JfB;
    paramBundle = bb.a.abA(this.pSU);
    int i = (int)bu.aRi();
    paramBundle = (Iterable)paramBundle.Jfy;
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
    this.pSX = ((List)localCollection);
    if (!bu.isNullOrNil(this.pMy))
    {
      paramBundle = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().Jga.aWs(this.pMy);
      if ((paramBundle != null) && (paramBundle.GQO != null) && (paramBundle.GQO.DesignerUin != 0) && (!bu.isNullOrNil(paramBundle.GQO.Name)))
      {
        this.pSU = paramBundle.GQO.DesignerUin;
        this.pLu = paramBundle.GQO.Name;
        ae.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "uin:%s name:%s", new Object[] { Integer.valueOf(this.pSU), this.pLu });
      }
    }
    else
    {
      i = 0;
      if (i != 0) {
        break label579;
      }
      Zm();
    }
    for (;;)
    {
      com.tencent.mm.kernel.g.ajQ().gDv.a(239, this);
      com.tencent.mm.kernel.g.ajQ().gDv.a(720, this);
      com.tencent.mm.sdk.b.a.IvT.c(this.pOb);
      com.tencent.mm.plugin.report.service.g.yxI.f(12067, new Object[] { Integer.valueOf(1), "", "", "", "" });
      com.tencent.mm.plugin.report.service.g.yxI.f(12740, new Object[] { Integer.valueOf(2), com.tencent.mm.b.p.getString(this.pSU), "", "", Integer.valueOf(this.mScene), Integer.valueOf(6) });
      paramBundle = bb.a.JfB;
      bb.a.abA(this.pSU).fvb();
      AppMethodBeat.o(109158);
      return;
      i = 1;
      break;
      label579:
      this.pTv = new i(this.pMy);
      com.tencent.mm.kernel.g.ajQ().gDv.a(this.pTv, 0);
      getString(2131755906);
      this.pTw = h.b(this, getString(2131755936), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(109148);
          if (EmojiStoreV2DesignerUI.p(EmojiStoreV2DesignerUI.this) != null) {
            com.tencent.mm.kernel.g.ajQ().gDv.a(EmojiStoreV2DesignerUI.p(EmojiStoreV2DesignerUI.this));
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
    com.tencent.mm.emoji.b.c localc = com.tencent.mm.emoji.b.c.gqZ;
    com.tencent.mm.emoji.b.c.agn().gX("");
    localc = com.tencent.mm.emoji.b.c.gqZ;
    com.tencent.mm.emoji.b.c.md(5);
    if (this.pTB != null) {
      com.tencent.mm.kernel.g.ajQ().gDv.a(this.pTB);
    }
    com.tencent.mm.kernel.g.ajQ().gDv.b(239, this);
    com.tencent.mm.kernel.g.ajQ().gDv.b(720, this);
    com.tencent.mm.sdk.b.a.IvT.d(this.pOb);
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
    ((com.tencent.mm.hellhoundlib.b.b)localObject).mu(paramInt);
    ((com.tencent.mm.hellhoundlib.b.b)localObject).rl(paramLong);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2DesignerUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
    if (this.pOj != null)
    {
      int i = this.mListView.getHeaderViewsCount();
      paramAdapterView = this.pOj.Ce(paramInt - i);
      if (paramAdapterView != null)
      {
        paramView = new Intent();
        paramView.setClass(this, EmojiStoreDetailUI.class);
        localObject = paramAdapterView.pIz;
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
        com.tencent.mm.hellhoundlib.a.a.a(this, paramAdapterView.ahE(), "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2DesignerUI", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramAdapterView.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2DesignerUI", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2DesignerUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(109174);
      return;
      label222:
      com.tencent.mm.emoji.b.c localc = com.tencent.mm.emoji.b.c.gqZ;
      com.tencent.mm.emoji.b.c.agn().gX(((EmotionSummary)localObject).ProductID);
      localc = com.tencent.mm.emoji.b.c.gqZ;
      com.tencent.mm.emoji.b.c.md(4);
      localc = com.tencent.mm.emoji.b.c.gqZ;
      com.tencent.mm.emoji.b.c.agn().gX("");
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
      paramView.putExtra("searchID", this.pLp);
      localObject = getIntent().getStringExtra("to_talker_name");
      paramAdapterView = paramView;
      if (!bu.isNullOrNil((String)localObject))
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
    com.tencent.mm.kernel.g.ajQ().gDv.b(423, this);
    AppMethodBeat.o(109160);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(109159);
    super.onResume();
    com.tencent.mm.kernel.g.ajQ().gDv.a(423, this);
    AppMethodBeat.o(109159);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, final n paramn)
  {
    AppMethodBeat.i(109168);
    switch (paramn.getType())
    {
    default: 
      ae.e("MicroMsg.emoji.EmojiStoreV2DesignerUI", "unknow scene type");
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
          cX(paramString.pMk, 0);
          AppMethodBeat.o(109168);
          return;
        }
        paramn = paramString.pMk;
        final String str1 = paramString.pMm;
        final String str2 = paramString.pMl;
        h.a(this, getString(2131758320, new Object[] { str2 }), "", new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(109145);
            EmojiStoreV2DesignerUI.this.S(paramn, str1, str2);
            EmojiStoreV2DesignerUI.this.ciW();
            ae.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "Retry doScene ExchangeEmotionPackNetScene productId:%s", new Object[] { paramn });
            EmojiStoreV2DesignerUI.a(EmojiStoreV2DesignerUI.this, paramn);
            AppMethodBeat.o(109145);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        cW(paramString.pMk, -1);
        AppMethodBeat.o(109168);
        return;
      } while (!(paramn instanceof com.tencent.mm.plugin.emoji.f.p));
      this.lpM = false;
      if ((paramInt1 == 0) || (paramInt1 == 4))
      {
        paramString = (com.tencent.mm.plugin.emoji.f.p)paramn;
        paramn = com.tencent.mm.plugin.emoji.f.p.a(paramString.ciC());
        if (paramInt2 == 0)
        {
          this.pTu = paramString.ciC();
          c(paramn);
        }
        for (;;)
        {
          if ((this.pNM == null) && (this.pTu != null))
          {
            com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().JfX.a(String.valueOf(this.pSU), paramString.ciC());
            this.pTk = this.pTu.FUH;
            cU(this.pTk);
          }
          this.pNM = paramString.pME;
          AppMethodBeat.o(109168);
          return;
          if (paramInt2 == 2)
          {
            this.pTu = paramString.ciC();
            b(this.pNK, paramn);
            this.pNK = 2;
          }
          else if (paramInt2 == 3)
          {
            this.pTu = paramString.ciC();
            b(this.pNK, paramn);
            this.pNK = 1;
            ae.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "get person designer failed errCode:%d", new Object[] { Integer.valueOf(paramInt2) });
          }
        }
      }
      ae.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "get person designer failed");
      AppMethodBeat.o(109168);
      return;
    }
    if ((this.pTw != null) && (this.pTw.isShowing())) {
      this.pTw.dismiss();
    }
    if ((paramInt2 == 0) && (paramInt1 == 0))
    {
      paramString = ((i)paramn).ciu();
      if ((paramString != null) && (paramString.GQO != null))
      {
        this.pSU = paramString.GQO.DesignerUin;
        this.pLu = paramString.GQO.Name;
        this.pSV = paramString.GQO.HeadUrl;
        if (this.mHandler != null) {
          this.mHandler.sendEmptyMessage(10003);
        }
      }
      AppMethodBeat.o(109168);
      return;
    }
    showOptionMenu(0, false);
    h.c(getContext(), getString(2131758253), null, true);
    ae.e("MicroMsg.emoji.EmojiStoreV2DesignerUI", "open designer failed .");
    AppMethodBeat.o(109168);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(109173);
    if ((paramInt == 0) && (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1))
    {
      if ((this.pNK == 0) || (this.lpM))
      {
        ae.d("MicroMsg.emoji.EmojiStoreV2DesignerUI", "No More List.");
        AppMethodBeat.o(109173);
        return;
      }
      ba(this.pNM);
      ae.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "[onScrollStateChanged] startLoadRemoteEmoji.");
    }
    AppMethodBeat.o(109173);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI
 * JD-Core Version:    0.7.0.1
 */