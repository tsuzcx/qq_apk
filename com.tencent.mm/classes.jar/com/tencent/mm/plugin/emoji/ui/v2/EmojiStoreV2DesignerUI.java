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
import com.tencent.mm.al.q;
import com.tencent.mm.aw.o;
import com.tencent.mm.g.a.dh;
import com.tencent.mm.g.b.a.s;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.model.ar.b.a;
import com.tencent.mm.plugin.emoji.e.j.2;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.j.a;
import com.tencent.mm.plugin.emoji.model.j.b;
import com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.emoji.BannerEmojiView;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.protocal.protobuf.PersonalDesigner;
import com.tencent.mm.protocal.protobuf.act;
import com.tencent.mm.protocal.protobuf.atb;
import com.tencent.mm.protocal.protobuf.ayh;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.r;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.c;
import com.tencent.mm.ui.base.MMPullDownView.e;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class EmojiStoreV2DesignerUI
  extends MMActivity
  implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener, com.tencent.mm.al.g, j.a, j.b, MMPullDownView.c, MMPullDownView.e
{
  private View adC;
  private boolean knt;
  private ap mHandler;
  private ListView mListView;
  private int mScene;
  com.tencent.mm.plugin.emoji.a.f oAD;
  private int oAe;
  private byte[] oAg;
  protected final int oAk;
  private final int oAl;
  private final int oAm;
  private final String oAn;
  private final String oAo;
  private final String oAp;
  private com.tencent.mm.plugin.emoji.model.f oAs;
  private com.tencent.mm.plugin.emoji.model.j oAt;
  private com.tencent.mm.sdk.b.c oAv;
  private com.tencent.mm.plugin.emoji.f.g oAw;
  private TextView oFA;
  private ImageView oFB;
  private TextView oFC;
  private TextView oFD;
  View oFE;
  private List<act> oFF;
  private View oFG;
  PreViewListGridView oFH;
  private a oFI;
  View oFJ;
  View oFK;
  View oFL;
  TextView oFM;
  View oFN;
  private MMPullDownView oFO;
  private ayh oFP;
  private com.tencent.mm.plugin.emoji.f.i oFQ;
  private com.tencent.mm.ui.base.p oFR;
  private ar.b.a oFS;
  private final int oFT;
  private final int oFU;
  private final int oFV;
  private com.tencent.mm.plugin.emoji.f.p oFW;
  private int oFp;
  private String oFq;
  private String oFr;
  private List<String> oFs;
  private af oFt;
  private View oFu;
  private BannerEmojiView oFv;
  private TextView oFw;
  private TextView oFx;
  private View oFy;
  private View oFz;
  private long oxB;
  private String oxC;
  private String oxG;
  private String oyK;
  
  public EmojiStoreV2DesignerUI()
  {
    AppMethodBeat.i(109157);
    this.oFF = new ArrayList();
    this.oAe = -1;
    this.oAk = 131074;
    this.oAl = 131075;
    this.oAm = 131076;
    this.oAn = "product_id";
    this.oAo = "progress";
    this.oAp = "status";
    this.oAv = new com.tencent.mm.sdk.b.c() {};
    this.oFS = new ar.b.a()
    {
      public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(109149);
        ad.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "getContactCallBack username:%s,succ:%b", new Object[] { paramAnonymousString, Boolean.valueOf(paramAnonymousBoolean) });
        if (paramAnonymousBoolean)
        {
          EmojiStoreV2DesignerUI.a(EmojiStoreV2DesignerUI.this, ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(paramAnonymousString));
          EmojiStoreV2DesignerUI.a(EmojiStoreV2DesignerUI.this);
        }
        AppMethodBeat.o(109149);
      }
    };
    this.oFT = 10001;
    this.oFU = 10002;
    this.oFV = 10003;
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
          EmojiStoreV2DesignerUI.this.jJ(false);
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
          EmojiStoreV2DesignerUI.d(EmojiStoreV2DesignerUI.this).cL(str, i);
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
          EmojiStoreV2DesignerUI.d(EmojiStoreV2DesignerUI.this).cK(str, i);
        }
      }
    };
    AppMethodBeat.o(109157);
  }
  
  private void VL()
  {
    AppMethodBeat.i(109163);
    setMMTitle(this.oxG);
    this.oAD = new com.tencent.mm.plugin.emoji.a.f(getContext());
    this.oAD.cK(this.oFs);
    this.mListView.addHeaderView(this.adC);
    this.mListView.setAdapter(this.oAD);
    this.oAD.ouA = this;
    this.oAD.otU = com.tencent.mm.emoji.a.l.abq();
    this.oAD.otV = false;
    this.oFw.setText(this.oxG);
    this.oFP = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().Fzb.aJH(String.valueOf(this.oFp));
    this.oAt = new com.tencent.mm.plugin.emoji.model.j();
    this.oAt.mfC = this;
    this.oAt.oxx = this.oAD;
    this.oAt.oxA = 6;
    this.oAt.oxD = this;
    this.oAt.oxG = this.oxG;
    this.oAt.oxB = this.oxB;
    this.oAt.oxC = this.oxC;
    if (this.oFP != null)
    {
      c(com.tencent.mm.plugin.emoji.f.p.a(this.oFP));
      cP(this.oFP.CEq);
    }
    updateData();
    ba(this.oAg);
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
      jK(bool);
      AppMethodBeat.o(109171);
      return;
      this.oAs = paramf;
      continue;
      this.oAs = paramf;
      continue;
      this.oAs = paramf;
      continue;
      if (this.oAs == null) {
        this.oAs = new com.tencent.mm.plugin.emoji.model.f();
      }
      this.oAs.AA(paramf.owY);
      this.oAs.cL(paramf.owZ);
    }
  }
  
  private void bWU()
  {
    AppMethodBeat.i(109166);
    if ((this.oFt != null) && ((int)this.oFt.fId != 0))
    {
      this.oFz.setVisibility(0);
      this.oFy.setVisibility(0);
      if (!bt.isNullOrNil(this.oFt.ZW())) {
        this.oFA.setText(this.oFt.ZW());
      }
      for (;;)
      {
        a.b.d(this.oFB, this.oFt.field_username);
        this.oFC.setEnabled(true);
        AppMethodBeat.o(109166);
        return;
        this.oFA.setText(this.oFt.field_username);
      }
    }
    this.oFz.setVisibility(8);
    this.oFy.setVisibility(8);
    AppMethodBeat.o(109166);
  }
  
  private void ba(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(109167);
    this.knt = true;
    this.oFW = new com.tencent.mm.plugin.emoji.f.p(this.oFp, paramArrayOfByte);
    com.tencent.mm.kernel.g.afA().gcy.a(this.oFW, 0);
    AppMethodBeat.o(109167);
  }
  
  private void c(com.tencent.mm.plugin.emoji.model.f paramf)
  {
    AppMethodBeat.i(109170);
    b(this.oAe, paramf);
    this.oAe = 0;
    AppMethodBeat.o(109170);
  }
  
  private void cP(final List<act> paramList)
  {
    int i = 1;
    AppMethodBeat.i(109169);
    String str = com.tencent.mm.m.g.Zd().getValue("ShowDesignerEmoji");
    ad.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "get dynamic Disgner_Emoji_Store_Show config value:%s", new Object[] { str });
    if ((!bt.isNullOrNil(str)) && (bt.aGh(str) == 1)) {}
    while ((paramList != null) && (paramList.size() > 0) && (i != 0))
    {
      this.oFE.setVisibility(0);
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
              if (localEmojiStoreV2DesignerUI.oFH != null) {
                localEmojiStoreV2DesignerUI.oFH.setVisibility(0);
              }
              if (localEmojiStoreV2DesignerUI.oFK != null) {
                localEmojiStoreV2DesignerUI.oFK.setVisibility(0);
              }
              if (localEmojiStoreV2DesignerUI.oFJ != null) {
                localEmojiStoreV2DesignerUI.oFJ.setVisibility(0);
              }
              if (localEmojiStoreV2DesignerUI.oFL != null)
              {
                localView = localEmojiStoreV2DesignerUI.oFL;
                if (i == 0) {
                  break label185;
                }
              }
            }
            label185:
            for (int j = 0;; j = 8)
            {
              localView.setVisibility(j);
              if (localEmojiStoreV2DesignerUI.oFM != null) {
                localEmojiStoreV2DesignerUI.oFM.setText(2131758347);
              }
              if (localEmojiStoreV2DesignerUI.oFN != null)
              {
                localView = localEmojiStoreV2DesignerUI.oFN;
                j = k;
                if (i != 0) {
                  j = 0;
                }
                localView.setVisibility(j);
              }
              if (localEmojiStoreV2DesignerUI.oFE != null) {
                localEmojiStoreV2DesignerUI.oFE.setPadding(0, 0, 0, 0);
              }
              AppMethodBeat.o(109144);
              return;
              i = 0;
              break;
            }
          }
        });
      }
      this.oFI.ad(paramList);
      AppMethodBeat.o(109169);
      return;
      i = 0;
    }
    this.oFE.setVisibility(8);
    AppMethodBeat.o(109169);
  }
  
  private void jK(boolean paramBoolean)
  {
    AppMethodBeat.i(109172);
    if ((this.oAs != null) && (paramBoolean))
    {
      if (this.oAD != null) {
        this.oAD.b(this.oAs);
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
    if (this.oFP == null)
    {
      ad.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "update data failed. data is null.");
      AppMethodBeat.o(109164);
      return;
    }
    jJ(true);
    if (!bt.isNullOrNil(this.oFP.CEP))
    {
      ad.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "biz name is :%s", new Object[] { this.oFP.CEP });
      this.oFt = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(this.oFP.CEP);
      if (((this.oFt == null) || ((int)this.oFt.fId == 0)) && (ar.a.gMW != null))
      {
        ad.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "getContact %s", new Object[] { this.oFP.CEP });
        ar.a.gMW.a(this.oFP.CEP, "", this.oFS);
      }
      this.oFC.setText(2131758390);
      if (bt.isNullOrNil(this.oFP.Desc)) {
        break label296;
      }
      this.oFx.setText(this.oFP.Desc);
      this.oFx.setVisibility(0);
    }
    for (;;)
    {
      bWU();
      if ((this.oAs != null) && (this.oAs.owZ != null) && (!this.oAs.owZ.isEmpty())) {
        break label308;
      }
      this.oFD.setVisibility(8);
      AppMethodBeat.o(109164);
      return;
      ad.w("MicroMsg.emoji.EmojiStoreV2DesignerUI", "mData.BizName is null");
      this.oFy.setVisibility(8);
      this.oFz.setVisibility(8);
      break;
      label296:
      this.oFx.setVisibility(8);
    }
    label308:
    this.oFD.setVisibility(0);
    AppMethodBeat.o(109164);
  }
  
  protected final com.tencent.mm.plugin.emoji.f.g Q(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(109177);
    this.oAw = new com.tencent.mm.plugin.emoji.f.g(paramString1, paramString2, paramString3);
    paramString1 = this.oAw;
    AppMethodBeat.o(109177);
    return paramString1;
  }
  
  public final void a(com.tencent.mm.plugin.emoji.a.a parama)
  {
    AppMethodBeat.i(109175);
    String str = parama.getProductId();
    if (TextUtils.isEmpty(parama.bUj())) {}
    for (Object localObject = "";; localObject = parama.bUj())
    {
      ad.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "[onProductClick] productId:%s, productPrice:%s, productStatus:%d", new Object[] { str, localObject, Integer.valueOf(parama.bUi()) });
      parama.bUi();
      localObject = com.tencent.mm.emoji.b.c.fRg;
      com.tencent.mm.emoji.b.c.acn().fY(parama.getProductId());
      localObject = com.tencent.mm.emoji.b.c.fRg;
      com.tencent.mm.emoji.b.c.lI(3);
      localObject = com.tencent.mm.emoji.b.c.fRg;
      com.tencent.mm.emoji.b.c.acn().fY("");
      this.oAt.a(parama);
      AppMethodBeat.o(109175);
      return;
    }
  }
  
  public final boolean bPh()
  {
    return true;
  }
  
  public final boolean bPj()
  {
    return false;
  }
  
  public final void bUV() {}
  
  protected final void bVQ()
  {
    AppMethodBeat.i(109178);
    com.tencent.mm.kernel.g.afA().gcy.a(this.oAw, 0);
    AppMethodBeat.o(109178);
  }
  
  final void cK(String paramString, int paramInt)
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
  
  final void cL(String paramString, int paramInt)
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
    if (!bt.isNullOrNil(this.oxG)) {
      setMMTitle(this.oxG);
    }
    this.adC = y.js(getContext()).inflate(2131493803, null);
    this.oFu = this.adC.findViewById(2131299021);
    this.oFv = ((BannerEmojiView)this.oFu.findViewById(2131299332));
    this.oFw = ((TextView)this.adC.findViewById(2131299023));
    this.oFx = ((TextView)this.adC.findViewById(2131299019));
    this.oFy = this.adC.findViewById(2131299017);
    this.oFz = this.adC.findViewById(2131299016);
    this.oFA = ((TextView)this.adC.findViewById(2131299032));
    this.oFB = ((ImageView)this.adC.findViewById(2131299022));
    this.oFC = ((TextView)this.adC.findViewById(2131299020));
    this.oFD = ((TextView)this.adC.findViewById(2131299033));
    this.oFE = this.adC.findViewById(2131299024);
    this.oFG = this.adC.findViewById(2131299028);
    this.oFG.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(109151);
        EmojiStoreV2DesignerUI.e(EmojiStoreV2DesignerUI.this);
        AppMethodBeat.o(109151);
      }
    });
    this.oFH = ((PreViewListGridView)this.adC.findViewById(2131299027));
    this.oFI = new a(getContext());
    this.oFI.oIE = new a.a()
    {
      public final void Au(int paramAnonymousInt)
      {
        AppMethodBeat.i(109152);
        if ((EmojiStoreV2DesignerUI.f(EmojiStoreV2DesignerUI.this) != null) && (EmojiStoreV2DesignerUI.g(EmojiStoreV2DesignerUI.this) != null))
        {
          act localact = EmojiStoreV2DesignerUI.g(EmojiStoreV2DesignerUI.this).AJ(paramAnonymousInt);
          if (localact != null)
          {
            com.tencent.mm.plugin.report.service.h.vKh.f(12787, new Object[] { Integer.valueOf(1), Integer.valueOf(0), localact.Md5, Long.valueOf(EmojiStoreV2DesignerUI.h(EmojiStoreV2DesignerUI.this)), localact.Ddp, localact.ProductID, Integer.valueOf(6) });
            try
            {
              Intent localIntent = new Intent();
              localIntent.putExtra("extra_object", localact.toByteArray());
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
    this.oFH.setAdapter(this.oFI);
    this.oFJ = this.adC.findViewById(2131299029);
    this.oFK = this.adC.findViewById(2131299030);
    this.oFL = this.adC.findViewById(2131299028);
    this.oFM = ((TextView)this.adC.findViewById(2131299031));
    this.oFN = this.adC.findViewById(2131299026);
    this.oFO = ((MMPullDownView)findViewById(2131301487));
    this.oFO.setOnBottomLoadDataListener(this);
    this.oFO.setAtBottomCallBack(this);
    this.oFO.setBottomViewVisible(false);
    this.oFO.setIsBottomShowAll(false);
    this.mListView = ((ListView)findViewById(16908298));
    this.mListView.setOnItemClickListener(this);
    this.mListView.setOnScrollListener(this);
    this.oFz.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(109153);
        EmojiStoreV2DesignerUI.i(EmojiStoreV2DesignerUI.this);
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
  
  public final void j(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(109176);
    Q(paramString1, paramString2, paramString3);
    bVQ();
    AppMethodBeat.o(109176);
  }
  
  protected final void jJ(boolean paramBoolean)
  {
    AppMethodBeat.i(109165);
    if (this.oFP == null)
    {
      ad.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "update header failed. data is null.");
      AppMethodBeat.o(109165);
      return;
    }
    if ((this.oFv != null) && (!bt.isNullOrNil(this.oFP.DwN)))
    {
      Object localObject = this.oFP.DwN;
      com.tencent.mm.cd.a.getDensity(this);
      localObject = EmojiLogic.x("Designer", 8, (String)localObject);
      if (localObject == null)
      {
        if (paramBoolean)
        {
          o.ayJ().a(this.oFP.DwN, null, com.tencent.mm.plugin.emoji.e.e.h("Designer", this.oFP.DwN, new Object[] { "Designer", "BANNER" }), new com.tencent.mm.aw.a.c.k()
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
      this.oFv.setImageFilePath(((EmojiInfo)localObject).gaa());
    }
    AppMethodBeat.o(109165);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(109181);
    this.oAt.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 2002) {
      if (paramInt2 == -1)
      {
        String str1 = paramIntent.getStringExtra("Select_Conv_User");
        if ((bt.isNullOrNil(str1)) || (this.oFP == null)) {
          break label224;
        }
        ad.d("MicroMsg.emoji.EmojiStoreV2DesignerUI", "..".concat(String.valueOf(str1)));
        String str2 = this.oxG;
        String str3 = this.oFP.Desc;
        int i = this.oFp;
        String str4 = this.oFr;
        String str5 = this.oxG;
        String str6 = this.oFP.HeadUrl;
        String str7 = getResources().getString(2131755710);
        str7 = str7 + str2;
        String str8 = getString(2131755884);
        String str9 = getString(2131757559);
        ((com.tencent.mm.pluginsdk.i)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.i.class)).a(this, str1, str7, str8, str9, str6, new j.2(str1, str5, str3, i, str4, str2, str6, this));
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
    this.oyK = getIntent().getStringExtra("id");
    this.oFp = getIntent().getIntExtra("uin", 0);
    this.oxG = getIntent().getStringExtra("name");
    this.oFq = getIntent().getStringExtra("headurl");
    this.oFr = getIntent().getStringExtra("rediret_url");
    this.mScene = getIntent().getIntExtra("extra_scence", 0);
    this.oxB = getIntent().getLongExtra("searchID", 0L);
    this.oxC = bt.by(getIntent().getStringExtra("docID"), "");
    paramBundle = getIntent().getStringExtra("sns_object_data");
    if (!TextUtils.isEmpty(paramBundle))
    {
      this.oFp = EmojiLogic.TI(paramBundle);
      this.oxG = EmojiLogic.TJ(paramBundle);
      this.oFr = EmojiLogic.TR(paramBundle);
    }
    initView();
    paramBundle = at.a.FyF;
    paramBundle = at.a.Wz(this.oFp);
    int i = (int)bt.aGK();
    paramBundle = (Iterable)paramBundle.FyC;
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
    this.oFs = ((List)localCollection);
    if (!bt.isNullOrNil(this.oyK))
    {
      paramBundle = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().Fze.aJC(this.oyK);
      if ((paramBundle != null) && (paramBundle.Dtg != null) && (paramBundle.Dtg.DesignerUin != 0) && (!bt.isNullOrNil(paramBundle.Dtg.Name)))
      {
        this.oFp = paramBundle.Dtg.DesignerUin;
        this.oxG = paramBundle.Dtg.Name;
        ad.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "uin:%s name:%s", new Object[] { Integer.valueOf(this.oFp), this.oxG });
      }
    }
    else
    {
      i = 0;
      if (i != 0) {
        break label579;
      }
      VL();
    }
    for (;;)
    {
      com.tencent.mm.kernel.g.afA().gcy.a(239, this);
      com.tencent.mm.kernel.g.afA().gcy.a(720, this);
      com.tencent.mm.sdk.b.a.ESL.c(this.oAv);
      com.tencent.mm.plugin.report.service.h.vKh.f(12067, new Object[] { Integer.valueOf(1), "", "", "", "" });
      com.tencent.mm.plugin.report.service.h.vKh.f(12740, new Object[] { Integer.valueOf(2), com.tencent.mm.b.p.getString(this.oFp), "", "", Integer.valueOf(this.mScene), Integer.valueOf(6) });
      paramBundle = at.a.FyF;
      at.a.Wz(this.oFp).eLw();
      AppMethodBeat.o(109158);
      return;
      i = 1;
      break;
      label579:
      this.oFQ = new com.tencent.mm.plugin.emoji.f.i(this.oyK);
      com.tencent.mm.kernel.g.afA().gcy.a(this.oFQ, 0);
      getString(2131755906);
      this.oFR = com.tencent.mm.ui.base.h.b(this, getString(2131755936), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(109148);
          if (EmojiStoreV2DesignerUI.p(EmojiStoreV2DesignerUI.this) != null) {
            com.tencent.mm.kernel.g.afA().gcy.a(EmojiStoreV2DesignerUI.p(EmojiStoreV2DesignerUI.this));
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
    com.tencent.mm.emoji.b.c localc = com.tencent.mm.emoji.b.c.fRg;
    com.tencent.mm.emoji.b.c.acn().fY("");
    localc = com.tencent.mm.emoji.b.c.fRg;
    com.tencent.mm.emoji.b.c.lI(5);
    if (this.oFW != null) {
      com.tencent.mm.kernel.g.afA().gcy.a(this.oFW);
    }
    com.tencent.mm.kernel.g.afA().gcy.b(239, this);
    com.tencent.mm.kernel.g.afA().gcy.b(720, this);
    com.tencent.mm.sdk.b.a.ESL.d(this.oAv);
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
    Object localObject;
    if (this.oAD != null)
    {
      int i = this.mListView.getHeaderViewsCount();
      paramAdapterView = this.oAD.As(paramInt - i);
      if (paramAdapterView != null)
      {
        paramView = new Intent();
        paramView.setClass(this, EmojiStoreDetailUI.class);
        localObject = paramAdapterView.ouL;
        if (localObject != null) {
          break label151;
        }
        paramAdapterView = null;
      }
    }
    for (;;)
    {
      if (paramAdapterView != null)
      {
        paramAdapterView = new com.tencent.mm.hellhoundlib.b.a().bd(paramAdapterView);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramAdapterView.adn(), "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2DesignerUI", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramAdapterView.lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2DesignerUI", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      AppMethodBeat.o(109174);
      return;
      label151:
      com.tencent.mm.emoji.b.c localc = com.tencent.mm.emoji.b.c.fRg;
      com.tencent.mm.emoji.b.c.acn().fY(((EmotionSummary)localObject).ProductID);
      localc = com.tencent.mm.emoji.b.c.fRg;
      com.tencent.mm.emoji.b.c.lI(4);
      localc = com.tencent.mm.emoji.b.c.fRg;
      com.tencent.mm.emoji.b.c.acn().fY("");
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
      paramView.putExtra("extra_progress", paramAdapterView.EI);
      paramView.putExtra("searchID", this.oxB);
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
    com.tencent.mm.kernel.g.afA().gcy.b(423, this);
    AppMethodBeat.o(109160);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(109159);
    super.onResume();
    com.tencent.mm.kernel.g.afA().gcy.a(423, this);
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
          cL(paramString.oyw, 0);
          AppMethodBeat.o(109168);
          return;
        }
        paramn = paramString.oyw;
        final String str1 = paramString.oyy;
        final String str2 = paramString.oyx;
        com.tencent.mm.ui.base.h.a(this, getString(2131758320, new Object[] { str2 }), "", new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(109145);
            EmojiStoreV2DesignerUI.this.Q(paramn, str1, str2);
            EmojiStoreV2DesignerUI.this.bVQ();
            ad.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "Retry doScene ExchangeEmotionPackNetScene productId:%s", new Object[] { paramn });
            EmojiStoreV2DesignerUI.a(EmojiStoreV2DesignerUI.this, paramn);
            AppMethodBeat.o(109145);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        cK(paramString.oyw, -1);
        AppMethodBeat.o(109168);
        return;
      } while (!(paramn instanceof com.tencent.mm.plugin.emoji.f.p));
      this.knt = false;
      if ((paramInt1 == 0) || (paramInt1 == 4))
      {
        paramString = (com.tencent.mm.plugin.emoji.f.p)paramn;
        paramn = com.tencent.mm.plugin.emoji.f.p.a(paramString.bVv());
        if (paramInt2 == 0)
        {
          this.oFP = paramString.bVv();
          c(paramn);
        }
        for (;;)
        {
          if ((this.oAg == null) && (this.oFP != null))
          {
            com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().Fzb.a(String.valueOf(this.oFp), paramString.bVv());
            this.oFF = this.oFP.CEq;
            cP(this.oFF);
          }
          this.oAg = paramString.oyQ;
          AppMethodBeat.o(109168);
          return;
          if (paramInt2 == 2)
          {
            this.oFP = paramString.bVv();
            b(this.oAe, paramn);
            this.oAe = 2;
          }
          else if (paramInt2 == 3)
          {
            this.oFP = paramString.bVv();
            b(this.oAe, paramn);
            this.oAe = 1;
            ad.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "get person designer failed errCode:%d", new Object[] { Integer.valueOf(paramInt2) });
          }
        }
      }
      ad.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "get person designer failed");
      AppMethodBeat.o(109168);
      return;
    }
    if ((this.oFR != null) && (this.oFR.isShowing())) {
      this.oFR.dismiss();
    }
    if ((paramInt2 == 0) && (paramInt1 == 0))
    {
      paramString = ((com.tencent.mm.plugin.emoji.f.i)paramn).bVn();
      if ((paramString != null) && (paramString.Dtg != null))
      {
        this.oFp = paramString.Dtg.DesignerUin;
        this.oxG = paramString.Dtg.Name;
        this.oFq = paramString.Dtg.HeadUrl;
        if (this.mHandler != null) {
          this.mHandler.sendEmptyMessage(10003);
        }
      }
      AppMethodBeat.o(109168);
      return;
    }
    showOptionMenu(0, false);
    com.tencent.mm.ui.base.h.c(getContext(), getString(2131758253), null, true);
    ad.e("MicroMsg.emoji.EmojiStoreV2DesignerUI", "open designer failed .");
    AppMethodBeat.o(109168);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(109173);
    if ((paramInt == 0) && (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1))
    {
      if ((this.oAe == 0) || (this.knt))
      {
        ad.d("MicroMsg.emoji.EmojiStoreV2DesignerUI", "No More List.");
        AppMethodBeat.o(109173);
        return;
      }
      ba(this.oAg);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI
 * JD-Core Version:    0.7.0.1
 */