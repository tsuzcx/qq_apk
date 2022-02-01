package com.tencent.mm.plugin.emoji.ui.v2;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.du;
import com.tencent.mm.f.b.a.ay;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.kernel.c;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.az.b.a;
import com.tencent.mm.plugin.emoji.e.e;
import com.tencent.mm.plugin.emoji.e.j.2;
import com.tencent.mm.plugin.emoji.i.a;
import com.tencent.mm.plugin.emoji.i.e;
import com.tencent.mm.plugin.emoji.i.f;
import com.tencent.mm.plugin.emoji.i.g;
import com.tencent.mm.plugin.emoji.i.h;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.l;
import com.tencent.mm.plugin.emoji.model.o.a;
import com.tencent.mm.plugin.emoji.model.o.b;
import com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.emoji.BannerEmojiView;
import com.tencent.mm.protocal.protobuf.aji;
import com.tencent.mm.protocal.protobuf.akh;
import com.tencent.mm.protocal.protobuf.btr;
import com.tencent.mm.protocal.protobuf.caj;
import com.tencent.mm.protocal.protobuf.dkv;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bg.a;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.c;
import com.tencent.mm.ui.base.MMPullDownView.e;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class EmojiStoreV2DesignerUI
  extends MMActivity
  implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener, i, o.a, o.b, MMPullDownView.c, MMPullDownView.e
{
  private MMHandler mHandler;
  private View mL;
  private ListView mListView;
  private int mScene;
  private boolean puR;
  private long uEM;
  private String uEN;
  private String uER;
  private String uFX;
  private IListener uHA;
  private com.tencent.mm.plugin.emoji.f.h uHB;
  com.tencent.mm.plugin.emoji.a.f uHJ;
  private int uHj;
  private byte[] uHl;
  protected final int uHp;
  private final int uHq;
  private final int uHr;
  private final String uHs;
  private final String uHt;
  private final String uHu;
  private l uHx;
  private com.tencent.mm.plugin.emoji.model.o uHy;
  View uNA;
  View uNB;
  View uNC;
  TextView uND;
  View uNE;
  private MMPullDownView uNF;
  private caj uNG;
  private com.tencent.mm.plugin.emoji.f.j uNH;
  private com.tencent.mm.ui.base.s uNI;
  private az.b.a uNJ;
  private final int uNK;
  private final int uNL;
  private final int uNM;
  private com.tencent.mm.plugin.emoji.f.q uNN;
  private int uNg;
  private String uNh;
  private String uNi;
  private List<String> uNj;
  private as uNk;
  private View uNl;
  private BannerEmojiView uNm;
  private TextView uNn;
  private TextView uNo;
  private View uNp;
  private View uNq;
  private TextView uNr;
  private ImageView uNs;
  private TextView uNt;
  private TextView uNu;
  View uNv;
  private List<aji> uNw;
  private View uNx;
  PreViewListGridView uNy;
  private a uNz;
  
  public EmojiStoreV2DesignerUI()
  {
    AppMethodBeat.i(109157);
    this.uNw = new ArrayList();
    this.uHj = -1;
    this.uHp = 131074;
    this.uHq = 131075;
    this.uHr = 131076;
    this.uHs = "product_id";
    this.uHt = "progress";
    this.uHu = "status";
    this.uHA = new IListener() {};
    this.uNJ = new EmojiStoreV2DesignerUI.8(this);
    this.uNK = 10001;
    this.uNL = 10002;
    this.uNM = 10003;
    this.mHandler = new MMHandler()
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
          EmojiStoreV2DesignerUI.this.mJ(false);
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
          EmojiStoreV2DesignerUI.d(EmojiStoreV2DesignerUI.this).dx(str, i);
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
          EmojiStoreV2DesignerUI.d(EmojiStoreV2DesignerUI.this).dw(str, i);
        }
      }
    };
    AppMethodBeat.o(109157);
  }
  
  private void ata()
  {
    AppMethodBeat.i(109163);
    setMMTitle(this.uER);
    this.uHJ = new com.tencent.mm.plugin.emoji.a.f(getContext());
    this.uHJ.de(this.uNj);
    this.mListView.addHeaderView(this.mL);
    this.mListView.setAdapter(this.uHJ);
    this.uHJ.uAP = this;
    this.uHJ.uAj = com.tencent.mm.emoji.b.o.aBQ();
    this.uHJ.uAk = false;
    this.uNn.setText(this.uER);
    this.uNG = com.tencent.mm.plugin.emoji.model.p.getEmojiStorageMgr().VFK.bxW(String.valueOf(this.uNg));
    this.uHy = new com.tencent.mm.plugin.emoji.model.o();
    this.uHy.uEJ = this;
    this.uHy.uEH = this.uHJ;
    this.uHy.uEL = 6;
    this.uHy.uEO = this;
    this.uHy.uER = this.uER;
    this.uHy.uEM = this.uEM;
    this.uHy.uEN = this.uEN;
    if (this.uNG != null)
    {
      c(com.tencent.mm.plugin.emoji.f.q.a(this.uNG));
      dk(this.uNG.RPm);
    }
    updateData();
    bF(this.uHl);
    AppMethodBeat.o(109163);
  }
  
  private void b(int paramInt, l paraml)
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
      mK(bool);
      AppMethodBeat.o(109171);
      return;
      this.uHx = paraml;
      continue;
      this.uHx = paraml;
      continue;
      this.uHx = paraml;
      continue;
      if (this.uHx == null) {
        this.uHx = new l();
      }
      this.uHx.JF(paraml.uEw);
      this.uHx.df(paraml.uEx);
    }
  }
  
  private void bF(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(109167);
    this.puR = true;
    this.uNN = new com.tencent.mm.plugin.emoji.f.q(this.uNg, paramArrayOfByte);
    com.tencent.mm.kernel.h.aHF().kcd.a(this.uNN, 0);
    AppMethodBeat.o(109167);
  }
  
  private void c(l paraml)
  {
    AppMethodBeat.i(109170);
    b(this.uHj, paraml);
    this.uHj = 0;
    AppMethodBeat.o(109170);
  }
  
  private void cWI()
  {
    AppMethodBeat.i(109166);
    if ((this.uNk != null) && ((int)this.uNk.jxt != 0))
    {
      this.uNq.setVisibility(0);
      this.uNp.setVisibility(0);
      if (!Util.isNullOrNil(this.uNk.ayr())) {
        this.uNr.setText(this.uNk.ayr());
      }
      for (;;)
      {
        a.b.d(this.uNs, this.uNk.field_username);
        this.uNt.setEnabled(true);
        AppMethodBeat.o(109166);
        return;
        this.uNr.setText(this.uNk.field_username);
      }
    }
    this.uNq.setVisibility(8);
    this.uNp.setVisibility(8);
    AppMethodBeat.o(109166);
  }
  
  private void dk(final List<aji> paramList)
  {
    int i = 1;
    AppMethodBeat.i(109169);
    String str = com.tencent.mm.n.h.axc().getValue("ShowDesignerEmoji");
    Log.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "get dynamic Disgner_Emoji_Store_Show config value:%s", new Object[] { str });
    if ((!Util.isNullOrNil(str)) && (Util.safeParseInt(str) == 1)) {}
    while ((paramList != null) && (paramList.size() > 0) && (i != 0))
    {
      this.uNv.setVisibility(0);
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
              if (localEmojiStoreV2DesignerUI.uNy != null) {
                localEmojiStoreV2DesignerUI.uNy.setVisibility(0);
              }
              if (localEmojiStoreV2DesignerUI.uNB != null) {
                localEmojiStoreV2DesignerUI.uNB.setVisibility(0);
              }
              if (localEmojiStoreV2DesignerUI.uNA != null) {
                localEmojiStoreV2DesignerUI.uNA.setVisibility(0);
              }
              if (localEmojiStoreV2DesignerUI.uNC != null)
              {
                localView = localEmojiStoreV2DesignerUI.uNC;
                if (i == 0) {
                  break label186;
                }
              }
            }
            label186:
            for (int j = 0;; j = 8)
            {
              localView.setVisibility(j);
              if (localEmojiStoreV2DesignerUI.uND != null) {
                localEmojiStoreV2DesignerUI.uND.setText(i.h.emoji_store_product_more_title);
              }
              if (localEmojiStoreV2DesignerUI.uNE != null)
              {
                localView = localEmojiStoreV2DesignerUI.uNE;
                j = k;
                if (i != 0) {
                  j = 0;
                }
                localView.setVisibility(j);
              }
              if (localEmojiStoreV2DesignerUI.uNv != null) {
                localEmojiStoreV2DesignerUI.uNv.setPadding(0, 0, 0, 0);
              }
              AppMethodBeat.o(109144);
              return;
              i = 0;
              break;
            }
          }
        });
      }
      this.uNz.aa(paramList);
      AppMethodBeat.o(109169);
      return;
      i = 0;
    }
    this.uNv.setVisibility(8);
    AppMethodBeat.o(109169);
  }
  
  private void mK(boolean paramBoolean)
  {
    AppMethodBeat.i(109172);
    if ((this.uHx != null) && (paramBoolean))
    {
      if (this.uHJ != null) {
        this.uHJ.b(this.uHx);
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
    if (this.uNG == null)
    {
      Log.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "update data failed. data is null.");
      AppMethodBeat.o(109164);
      return;
    }
    mJ(true);
    if (!Util.isNullOrNil(this.uNG.RPP))
    {
      Log.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "biz name is :%s", new Object[] { this.uNG.RPP });
      this.uNk = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(this.uNG.RPP);
      if (((this.uNk == null) || ((int)this.uNk.jxt == 0)) && (az.a.ltq != null))
      {
        Log.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "getContact %s", new Object[] { this.uNG.RPP });
        az.a.ltq.a(this.uNG.RPP, "", this.uNJ);
      }
      this.uNt.setText(i.h.emoji_store_weixin);
      if (Util.isNullOrNil(this.uNG.CMB)) {
        break label296;
      }
      this.uNo.setText(this.uNG.CMB);
      this.uNo.setVisibility(0);
    }
    for (;;)
    {
      cWI();
      if ((this.uHx != null) && (this.uHx.uEx != null) && (!this.uHx.uEx.isEmpty())) {
        break label308;
      }
      this.uNu.setVisibility(8);
      AppMethodBeat.o(109164);
      return;
      Log.w("MicroMsg.emoji.EmojiStoreV2DesignerUI", "mData.BizName is null");
      this.uNp.setVisibility(8);
      this.uNq.setVisibility(8);
      break;
      label296:
      this.uNo.setVisibility(8);
    }
    label308:
    this.uNu.setVisibility(0);
    AppMethodBeat.o(109164);
  }
  
  protected final com.tencent.mm.plugin.emoji.f.h U(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(258113);
    this.uHB = new com.tencent.mm.plugin.emoji.f.h(paramString1, paramString2, paramString3);
    paramString1 = this.uHB;
    AppMethodBeat.o(258113);
    return paramString1;
  }
  
  public final void a(com.tencent.mm.plugin.emoji.a.a parama)
  {
    AppMethodBeat.i(109175);
    String str = parama.getProductId();
    if (TextUtils.isEmpty(parama.cTF())) {}
    for (Object localObject = "";; localObject = parama.cTF())
    {
      Log.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "[onProductClick] productId:%s, productPrice:%s, productStatus:%d", new Object[] { str, localObject, Integer.valueOf(parama.cTE()) });
      parama.cTE();
      localObject = com.tencent.mm.emoji.c.d.jNt;
      com.tencent.mm.emoji.c.d.aDc().jv(parama.getProductId());
      localObject = com.tencent.mm.emoji.c.d.jNt;
      com.tencent.mm.emoji.c.d.rE(3);
      localObject = com.tencent.mm.emoji.c.d.jNt;
      com.tencent.mm.emoji.c.d.aDc().jv("");
      this.uHy.a(parama);
      AppMethodBeat.o(109175);
      return;
    }
  }
  
  public final boolean cOJ()
  {
    return true;
  }
  
  public final boolean cOL()
  {
    return false;
  }
  
  public final void cUJ() {}
  
  protected final void cVE()
  {
    AppMethodBeat.i(109178);
    com.tencent.mm.kernel.h.aHF().kcd.a(this.uHB, 0);
    AppMethodBeat.o(109178);
  }
  
  public final void d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(258112);
    U(paramString1, paramString2, paramString3);
    cVE();
    AppMethodBeat.o(258112);
  }
  
  final void dw(String paramString, int paramInt)
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
  
  final void dx(String paramString, int paramInt)
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
    return i.f.emoji_store_v2_designer_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(109162);
    if (!Util.isNullOrNil(this.uER)) {
      setMMTitle(this.uER);
    }
    this.mL = ad.kS(getContext()).inflate(i.f.emoji_store_v2_designer_header, null);
    this.uNl = this.mL.findViewById(i.e.designer_header);
    this.uNm = ((BannerEmojiView)this.uNl.findViewById(i.e.emoji_bar_view));
    this.uNn = ((TextView)this.mL.findViewById(i.e.designer_name));
    this.uNo = ((TextView)this.mL.findViewById(i.e.designer_desc));
    this.uNp = this.mL.findViewById(i.e.designer_bar_line);
    this.uNq = this.mL.findViewById(i.e.designer_bar_container);
    this.uNr = ((TextView)this.mL.findViewById(i.e.designer_title));
    this.uNs = ((ImageView)this.mL.findViewById(i.e.designer_icon));
    this.uNt = ((TextView)this.mL.findViewById(i.e.designer_detail));
    this.uNu = ((TextView)this.mL.findViewById(i.e.designer_works));
    this.uNv = this.mL.findViewById(i.e.designer_product);
    this.uNx = this.mL.findViewById(i.e.designer_product_more);
    this.uNx.setOnClickListener(new EmojiStoreV2DesignerUI.10(this));
    this.uNy = ((PreViewListGridView)this.mL.findViewById(i.e.designer_product_list));
    this.uNz = new a(getContext());
    this.uNz.uQu = new a.a()
    {
      public final void Jx(int paramAnonymousInt)
      {
        AppMethodBeat.i(109152);
        if ((EmojiStoreV2DesignerUI.f(EmojiStoreV2DesignerUI.this) != null) && (EmojiStoreV2DesignerUI.g(EmojiStoreV2DesignerUI.this) != null))
        {
          aji localaji = EmojiStoreV2DesignerUI.g(EmojiStoreV2DesignerUI.this).JN(paramAnonymousInt);
          if (localaji != null)
          {
            com.tencent.mm.plugin.report.service.h.IzE.a(12787, new Object[] { Integer.valueOf(1), Integer.valueOf(0), localaji.Md5, Long.valueOf(EmojiStoreV2DesignerUI.h(EmojiStoreV2DesignerUI.this)), localaji.DesignerID, localaji.ProductID, Integer.valueOf(6) });
            try
            {
              Intent localIntent = new Intent();
              localIntent.putExtra("extra_object", localaji.toByteArray());
              localIntent.putExtra("add_source", 5);
              localIntent.putExtra("entrance_scene", 6);
              localIntent.setClass(EmojiStoreV2DesignerUI.this.getContext(), EmojiStoreV2SingleProductDialogUI.class);
              EmojiStoreV2DesignerUI.this.startActivityForResult(localIntent, 2004);
              EmojiStoreV2DesignerUI.this.overridePendingTransition(i.a.pop_in, i.a.pop_out);
              AppMethodBeat.o(109152);
              return;
            }
            catch (Exception localException) {}
          }
        }
        AppMethodBeat.o(109152);
      }
    };
    this.uNy.setAdapter(this.uNz);
    this.uNA = this.mL.findViewById(i.e.designer_product_title);
    this.uNB = this.mL.findViewById(i.e.designer_product_title_tv);
    this.uNC = this.mL.findViewById(i.e.designer_product_more);
    this.uND = ((TextView)this.mL.findViewById(i.e.designer_single_product));
    this.uNE = this.mL.findViewById(i.e.designer_product_divider);
    this.uNF = ((MMPullDownView)findViewById(i.e.load_more_pull_view));
    this.uNF.setOnBottomLoadDataListener(this);
    this.uNF.setAtBottomCallBack(this);
    this.uNF.setBottomViewVisible(false);
    this.uNF.setIsBottomShowAll(false);
    this.mListView = ((ListView)findViewById(16908298));
    this.mListView.setOnItemClickListener(this);
    this.mListView.setOnScrollListener(this);
    this.uNq.setOnClickListener(new EmojiStoreV2DesignerUI.12(this));
    setBackBtn(new EmojiStoreV2DesignerUI.13(this));
    addIconOptionMenu(0, i.g.icons_outlined_share, new EmojiStoreV2DesignerUI.14(this));
    AppMethodBeat.o(109162);
  }
  
  protected final void mJ(boolean paramBoolean)
  {
    AppMethodBeat.i(109165);
    if (this.uNG == null)
    {
      Log.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "update header failed. data is null.");
      AppMethodBeat.o(109165);
      return;
    }
    if ((this.uNm != null) && (!Util.isNullOrNil(this.uNG.TiM)))
    {
      Object localObject = this.uNG.TiM;
      com.tencent.mm.ci.a.getDensity(this);
      localObject = EmojiLogic.I("Designer", 8, (String)localObject);
      if (localObject == null)
      {
        if (paramBoolean)
        {
          com.tencent.mm.ay.q.bml().a(this.uNG.TiM, null, e.k("Designer", this.uNG.TiM, new Object[] { "Designer", "BANNER" }), new com.tencent.mm.ay.a.c.k()
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
        Log.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "updateDesignerHeader failed");
        AppMethodBeat.o(109165);
        return;
      }
      this.uNm.setImageFilePath(((EmojiInfo)localObject).ifh());
    }
    AppMethodBeat.o(109165);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(109181);
    this.uHy.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 2002) {
      if (paramInt2 == -1)
      {
        String str1 = paramIntent.getStringExtra("Select_Conv_User");
        if ((Util.isNullOrNil(str1)) || (this.uNG == null)) {
          break label224;
        }
        Log.d("MicroMsg.emoji.EmojiStoreV2DesignerUI", "..".concat(String.valueOf(str1)));
        String str2 = this.uER;
        String str3 = this.uNG.CMB;
        int i = this.uNg;
        String str4 = this.uNi;
        String str5 = this.uER;
        String str6 = this.uNG.SuR;
        String str7 = getResources().getString(i.h.app_designer_share);
        str7 = str7 + str2;
        String str8 = getString(i.h.app_send);
        String str9 = getString(i.h.confirm_dialog_edittext_hint);
        ((com.tencent.mm.pluginsdk.j)com.tencent.mm.kernel.h.ae(com.tencent.mm.pluginsdk.j.class)).a(this, str1, str7, str8, str9, str6, new j.2(str1, str5, str3, i, str4, str2, str6, this));
      }
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(109181);
      return;
      label224:
      Log.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "member or data is null.");
      continue;
      if ((paramInt1 == 2004) && (paramInt2 == -1)) {
        com.tencent.mm.ui.widget.snackbar.b.r(this, getContext().getString(i.h.app_sent));
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(109158);
    super.onCreate(paramBundle);
    this.uFX = getIntent().getStringExtra("id");
    this.uNg = getIntent().getIntExtra("uin", 0);
    this.uER = getIntent().getStringExtra("name");
    this.uNh = getIntent().getStringExtra("headurl");
    this.uNi = getIntent().getStringExtra("rediret_url");
    this.mScene = getIntent().getIntExtra("extra_scence", 0);
    this.uEM = getIntent().getLongExtra("searchID", 0L);
    this.uEN = Util.nullAs(getIntent().getStringExtra("docID"), "");
    paramBundle = getIntent().getStringExtra("sns_object_data");
    if (!TextUtils.isEmpty(paramBundle))
    {
      this.uNg = EmojiLogic.aum(paramBundle);
      this.uER = EmojiLogic.aun(paramBundle);
      this.uNi = EmojiLogic.auB(paramBundle);
    }
    initView();
    paramBundle = bg.a.VFn;
    paramBundle = bg.a.asF(this.uNg);
    int i = (int)Util.nowSecond();
    paramBundle = (Iterable)paramBundle.ziJ;
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
    this.uNj = ((List)localCollection);
    if (!Util.isNullOrNil(this.uFX))
    {
      paramBundle = com.tencent.mm.plugin.emoji.model.p.getEmojiStorageMgr().VFN.bxR(this.uFX);
      if ((paramBundle != null) && (paramBundle.TdN != null) && (paramBundle.TdN.TdG != 0) && (!Util.isNullOrNil(paramBundle.TdN.CMP)))
      {
        this.uNg = paramBundle.TdN.TdG;
        this.uER = paramBundle.TdN.CMP;
        Log.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "uin:%s name:%s", new Object[] { Integer.valueOf(this.uNg), this.uER });
      }
    }
    else
    {
      i = 0;
      if (i != 0) {
        break label579;
      }
      ata();
    }
    for (;;)
    {
      com.tencent.mm.kernel.h.aHF().kcd.a(239, this);
      com.tencent.mm.kernel.h.aHF().kcd.a(720, this);
      EventCenter.instance.addListener(this.uHA);
      com.tencent.mm.plugin.report.service.h.IzE.a(12067, new Object[] { Integer.valueOf(1), "", "", "", "" });
      com.tencent.mm.plugin.report.service.h.IzE.a(12740, new Object[] { Integer.valueOf(2), com.tencent.mm.b.p.getString(this.uNg), "", "", Integer.valueOf(this.mScene), Integer.valueOf(6) });
      paramBundle = bg.a.VFn;
      bg.a.asF(this.uNg).hyU();
      AppMethodBeat.o(109158);
      return;
      i = 1;
      break;
      label579:
      this.uNH = new com.tencent.mm.plugin.emoji.f.j(this.uFX);
      com.tencent.mm.kernel.h.aHF().kcd.a(this.uNH, 0);
      getString(i.h.app_tip);
      this.uNI = com.tencent.mm.ui.base.h.a(this, getString(i.h.app_waiting), true, new EmojiStoreV2DesignerUI.7(this));
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(109161);
    super.onDestroy();
    com.tencent.mm.emoji.c.d locald = com.tencent.mm.emoji.c.d.jNt;
    com.tencent.mm.emoji.c.d.aDc().jv("");
    locald = com.tencent.mm.emoji.c.d.jNt;
    com.tencent.mm.emoji.c.d.rE(5);
    if (this.uNN != null) {
      com.tencent.mm.kernel.h.aHF().kcd.a(this.uNN);
    }
    com.tencent.mm.kernel.h.aHF().kcd.b(239, this);
    com.tencent.mm.kernel.h.aHF().kcd.b(720, this);
    EventCenter.instance.removeListener(this.uHA);
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
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAdapterView);
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
    ((com.tencent.mm.hellhoundlib.b.b)localObject).sg(paramInt);
    ((com.tencent.mm.hellhoundlib.b.b)localObject).Fs(paramLong);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2DesignerUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
    if (this.uHJ != null)
    {
      int i = this.mListView.getHeaderViewsCount();
      paramAdapterView = this.uHJ.Jv(paramInt - i);
      if (paramAdapterView != null)
      {
        paramView = new Intent();
        paramView.setClass(this, EmojiStoreDetailUI.class);
        localObject = paramAdapterView.uBa;
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
        paramAdapterView = new com.tencent.mm.hellhoundlib.b.a().bm(paramAdapterView);
        com.tencent.mm.hellhoundlib.a.a.b(this, paramAdapterView.aFh(), "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2DesignerUI", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramAdapterView.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2DesignerUI", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2DesignerUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(109174);
      return;
      label222:
      com.tencent.mm.emoji.c.d locald = com.tencent.mm.emoji.c.d.jNt;
      com.tencent.mm.emoji.c.d.aDc().jv(((akh)localObject).ProductID);
      locald = com.tencent.mm.emoji.c.d.jNt;
      com.tencent.mm.emoji.c.d.rE(4);
      locald = com.tencent.mm.emoji.c.d.jNt;
      com.tencent.mm.emoji.c.d.aDc().jv("");
      paramView.putExtra("extra_id", ((akh)localObject).ProductID);
      paramView.putExtra("extra_name", ((akh)localObject).Suv);
      paramView.putExtra("extra_copyright", ((akh)localObject).VHB);
      paramView.putExtra("extra_coverurl", ((akh)localObject).Ufx);
      paramView.putExtra("extra_description", ((akh)localObject).Tev);
      paramView.putExtra("extra_price", ((akh)localObject).Tex);
      paramView.putExtra("extra_type", ((akh)localObject).Tey);
      paramView.putExtra("extra_flag", ((akh)localObject).TOG);
      paramView.putExtra("preceding_scence", 106);
      paramView.putExtra("download_entrance_scene", 6);
      paramView.putExtra("call_by", 1);
      paramView.putExtra("check_clickflag", false);
      paramView.putExtra("extra_status", paramAdapterView.mStatus);
      paramView.putExtra("extra_progress", paramAdapterView.IB);
      paramView.putExtra("searchID", this.uEM);
      paramAdapterView = getIntent().getStringExtra("to_talker_name");
      if (!Util.isNullOrNil(paramAdapterView)) {
        paramView.putExtra("to_talker_name", paramAdapterView);
      }
      paramAdapterView = paramView;
      if (IntentUtil.getBooleanExtra(getIntent(), "from_appbrand_ui", false))
      {
        paramView.putExtra("from_appbrand_ui", true);
        paramAdapterView = paramView;
      }
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(109160);
    super.onPause();
    com.tencent.mm.kernel.h.aHF().kcd.b(423, this);
    AppMethodBeat.o(109160);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(109159);
    super.onResume();
    com.tencent.mm.kernel.h.aHF().kcd.a(423, this);
    AppMethodBeat.o(109159);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, final com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(109168);
    switch (paramq.getType())
    {
    default: 
      Log.e("MicroMsg.emoji.EmojiStoreV2DesignerUI", "unknow scene type");
    case 423: 
    case 720: 
      do
      {
        do
        {
          AppMethodBeat.o(109168);
          return;
        } while (!(paramq instanceof com.tencent.mm.plugin.emoji.f.h));
        paramString = (com.tencent.mm.plugin.emoji.f.h)paramq;
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          dx(paramString.uFI, 0);
          AppMethodBeat.o(109168);
          return;
        }
        paramq = paramString.uFI;
        final String str1 = paramString.uFK;
        final String str2 = paramString.uFJ;
        final String str3 = paramString.uFM;
        com.tencent.mm.ui.base.h.a(this, getString(i.h.emoji_store_download_failed_msg, new Object[] { str2 }), "", new DialogInterface.OnClickListener()new EmojiStoreV2DesignerUI.4
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(109145);
            EmojiStoreV2DesignerUI.this.U(paramq, str1, str2);
            EmojiStoreV2DesignerUI.this.cVE();
            Log.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "Retry doScene ExchangeEmotionPackNetScene productId:%s", new Object[] { paramq });
            EmojiStoreV2DesignerUI.a(EmojiStoreV2DesignerUI.this, paramq);
            AppMethodBeat.o(109145);
          }
        }, new EmojiStoreV2DesignerUI.4(this));
        dw(paramString.uFI, -1);
        AppMethodBeat.o(109168);
        return;
      } while (!(paramq instanceof com.tencent.mm.plugin.emoji.f.q));
      this.puR = false;
      if ((paramInt1 == 0) || (paramInt1 == 4))
      {
        paramString = (com.tencent.mm.plugin.emoji.f.q)paramq;
        paramq = com.tencent.mm.plugin.emoji.f.q.a(paramString.cVj());
        if (paramInt2 == 0)
        {
          this.uNG = paramString.cVj();
          c(paramq);
        }
        for (;;)
        {
          if ((this.uHl == null) && (this.uNG != null))
          {
            com.tencent.mm.plugin.emoji.model.p.getEmojiStorageMgr().VFK.a(String.valueOf(this.uNg), paramString.cVj());
            this.uNw = this.uNG.RPm;
            dk(this.uNw);
          }
          this.uHl = paramString.uGe;
          AppMethodBeat.o(109168);
          return;
          if (paramInt2 == 2)
          {
            this.uNG = paramString.cVj();
            b(this.uHj, paramq);
            this.uHj = 2;
          }
          else if (paramInt2 == 3)
          {
            this.uNG = paramString.cVj();
            b(this.uHj, paramq);
            this.uHj = 1;
            Log.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "get person designer failed errCode:%d", new Object[] { Integer.valueOf(paramInt2) });
          }
        }
      }
      Log.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "get person designer failed");
      AppMethodBeat.o(109168);
      return;
    }
    if ((this.uNI != null) && (this.uNI.isShowing())) {
      this.uNI.dismiss();
    }
    if ((paramInt2 == 0) && (paramInt1 == 0))
    {
      paramString = ((com.tencent.mm.plugin.emoji.f.j)paramq).cVc();
      if ((paramString != null) && (paramString.TdN != null))
      {
        this.uNg = paramString.TdN.TdG;
        this.uER = paramString.TdN.CMP;
        this.uNh = paramString.TdN.SuR;
        if (this.mHandler != null) {
          this.mHandler.sendEmptyMessage(10003);
        }
      }
      AppMethodBeat.o(109168);
      return;
    }
    showOptionMenu(0, false);
    com.tencent.mm.ui.base.h.c(getContext(), getString(i.h.emoji_designer_load_failed), null, true);
    Log.e("MicroMsg.emoji.EmojiStoreV2DesignerUI", "open designer failed .");
    AppMethodBeat.o(109168);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(109173);
    if ((paramInt == 0) && (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1))
    {
      if ((this.uHj == 0) || (this.puR))
      {
        Log.d("MicroMsg.emoji.EmojiStoreV2DesignerUI", "No More List.");
        AppMethodBeat.o(109173);
        return;
      }
      bF(this.uHl);
      Log.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "[onScrollStateChanged] startLoadRemoteEmoji.");
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