package com.tencent.mm.plugin.emoji.ui.v2;

import android.app.Activity;
import android.content.DialogInterface;
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
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.av.o;
import com.tencent.mm.emoji.a.m;
import com.tencent.mm.g.a.di;
import com.tencent.mm.g.b.a.u;
import com.tencent.mm.g.c.av;
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
import com.tencent.mm.protocal.protobuf.ads;
import com.tencent.mm.protocal.protobuf.awf;
import com.tencent.mm.protocal.protobuf.bbz;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.aw.a;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.s;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.c;
import com.tencent.mm.ui.base.MMPullDownView.e;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class EmojiStoreV2DesignerUI
  extends MMActivity
  implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener, com.tencent.mm.ak.g, j.a, j.b, MMPullDownView.c, MMPullDownView.e
{
  private View aew;
  private boolean kOL;
  private ao mHandler;
  private ListView mListView;
  private int mScene;
  private long pbb;
  private String pbc;
  private String pbg;
  private String pck;
  private int pdE;
  private byte[] pdG;
  protected final int pdK;
  private final int pdL;
  private final int pdM;
  private final String pdN;
  private final String pdO;
  private final String pdP;
  private com.tencent.mm.plugin.emoji.model.f pdS;
  private com.tencent.mm.plugin.emoji.model.j pdT;
  private com.tencent.mm.sdk.b.c pdV;
  private com.tencent.mm.plugin.emoji.f.g pdW;
  com.tencent.mm.plugin.emoji.a.f ped;
  private int piP;
  private String piQ;
  private String piR;
  private List<String> piS;
  private ai piT;
  private View piU;
  private BannerEmojiView piV;
  private TextView piW;
  private TextView piX;
  private View piY;
  private View piZ;
  private TextView pja;
  private ImageView pjb;
  private TextView pjc;
  private TextView pjd;
  View pje;
  private List<ads> pjf;
  private View pjg;
  PreViewListGridView pjh;
  private a pji;
  View pjj;
  View pjk;
  View pjl;
  TextView pjm;
  View pjn;
  private MMPullDownView pjo;
  private bbz pjp;
  private com.tencent.mm.plugin.emoji.f.i pjq;
  private com.tencent.mm.ui.base.p pjr;
  private ar.b.a pjs;
  private final int pjt;
  private final int pju;
  private final int pjv;
  private com.tencent.mm.plugin.emoji.f.p pjw;
  
  public EmojiStoreV2DesignerUI()
  {
    AppMethodBeat.i(109157);
    this.pjf = new ArrayList();
    this.pdE = -1;
    this.pdK = 131074;
    this.pdL = 131075;
    this.pdM = 131076;
    this.pdN = "product_id";
    this.pdO = "progress";
    this.pdP = "status";
    this.pdV = new com.tencent.mm.sdk.b.c() {};
    this.pjs = new EmojiStoreV2DesignerUI.8(this);
    this.pjt = 10001;
    this.pju = 10002;
    this.pjv = 10003;
    this.mHandler = new ao()
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
          EmojiStoreV2DesignerUI.this.km(false);
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
          EmojiStoreV2DesignerUI.d(EmojiStoreV2DesignerUI.this).cQ(str, i);
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
          EmojiStoreV2DesignerUI.d(EmojiStoreV2DesignerUI.this).cP(str, i);
        }
      }
    };
    AppMethodBeat.o(109157);
  }
  
  private void WJ()
  {
    AppMethodBeat.i(109163);
    setMMTitle(this.pbg);
    this.ped = new com.tencent.mm.plugin.emoji.a.f(getContext());
    this.ped.cM(this.piS);
    this.mListView.addHeaderView(this.aew);
    this.mListView.setAdapter(this.ped);
    this.ped.oYa = this;
    this.ped.oXv = m.acp();
    this.ped.oXw = false;
    this.piW.setText(this.pbg);
    this.pjp = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().GYc.aPf(String.valueOf(this.piP));
    this.pdT = new com.tencent.mm.plugin.emoji.model.j();
    this.pdT.mHB = this;
    this.pdT.paX = this.ped;
    this.pdT.pba = 6;
    this.pdT.pbd = this;
    this.pdT.pbg = this.pbg;
    this.pdT.pbb = this.pbb;
    this.pdT.pbc = this.pbc;
    if (this.pjp != null)
    {
      c(com.tencent.mm.plugin.emoji.f.p.a(this.pjp));
      cR(this.pjp.DWQ);
    }
    updateData();
    aZ(this.pdG);
    AppMethodBeat.o(109163);
  }
  
  private void aZ(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(109167);
    this.kOL = true;
    this.pjw = new com.tencent.mm.plugin.emoji.f.p(this.piP, paramArrayOfByte);
    com.tencent.mm.kernel.g.agQ().ghe.a(this.pjw, 0);
    AppMethodBeat.o(109167);
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
      kn(bool);
      AppMethodBeat.o(109171);
      return;
      this.pdS = paramf;
      continue;
      this.pdS = paramf;
      continue;
      this.pdS = paramf;
      continue;
      if (this.pdS == null) {
        this.pdS = new com.tencent.mm.plugin.emoji.model.f();
      }
      this.pdS.Bs(paramf.pay);
      this.pdS.cN(paramf.paz);
    }
  }
  
  private void c(com.tencent.mm.plugin.emoji.model.f paramf)
  {
    AppMethodBeat.i(109170);
    b(this.pdE, paramf);
    this.pdE = 0;
    AppMethodBeat.o(109170);
  }
  
  private void cR(final List<ads> paramList)
  {
    int i = 1;
    AppMethodBeat.i(109169);
    String str = com.tencent.mm.m.g.ZY().getValue("ShowDesignerEmoji");
    ac.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "get dynamic Disgner_Emoji_Store_Show config value:%s", new Object[] { str });
    if ((!bs.isNullOrNil(str)) && (bs.aLy(str) == 1)) {}
    while ((paramList != null) && (paramList.size() > 0) && (i != 0))
    {
      this.pje.setVisibility(0);
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
              if (localEmojiStoreV2DesignerUI.pjh != null) {
                localEmojiStoreV2DesignerUI.pjh.setVisibility(0);
              }
              if (localEmojiStoreV2DesignerUI.pjk != null) {
                localEmojiStoreV2DesignerUI.pjk.setVisibility(0);
              }
              if (localEmojiStoreV2DesignerUI.pjj != null) {
                localEmojiStoreV2DesignerUI.pjj.setVisibility(0);
              }
              if (localEmojiStoreV2DesignerUI.pjl != null)
              {
                localView = localEmojiStoreV2DesignerUI.pjl;
                if (i == 0) {
                  break label185;
                }
              }
            }
            label185:
            for (int j = 0;; j = 8)
            {
              localView.setVisibility(j);
              if (localEmojiStoreV2DesignerUI.pjm != null) {
                localEmojiStoreV2DesignerUI.pjm.setText(2131758347);
              }
              if (localEmojiStoreV2DesignerUI.pjn != null)
              {
                localView = localEmojiStoreV2DesignerUI.pjn;
                j = k;
                if (i != 0) {
                  j = 0;
                }
                localView.setVisibility(j);
              }
              if (localEmojiStoreV2DesignerUI.pje != null) {
                localEmojiStoreV2DesignerUI.pje.setPadding(0, 0, 0, 0);
              }
              AppMethodBeat.o(109144);
              return;
              i = 0;
              break;
            }
          }
        });
      }
      this.pji.U(paramList);
      AppMethodBeat.o(109169);
      return;
      i = 0;
    }
    this.pje.setVisibility(8);
    AppMethodBeat.o(109169);
  }
  
  private void ceh()
  {
    AppMethodBeat.i(109166);
    if ((this.piT != null) && ((int)this.piT.fLJ != 0))
    {
      this.piZ.setVisibility(0);
      this.piY.setVisibility(0);
      if (!bs.isNullOrNil(this.piT.aaR())) {
        this.pja.setText(this.piT.aaR());
      }
      for (;;)
      {
        a.b.d(this.pjb, this.piT.field_username);
        this.pjc.setEnabled(true);
        AppMethodBeat.o(109166);
        return;
        this.pja.setText(this.piT.field_username);
      }
    }
    this.piZ.setVisibility(8);
    this.piY.setVisibility(8);
    AppMethodBeat.o(109166);
  }
  
  private void kn(boolean paramBoolean)
  {
    AppMethodBeat.i(109172);
    if ((this.pdS != null) && (paramBoolean))
    {
      if (this.ped != null) {
        this.ped.b(this.pdS);
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
    if (this.pjp == null)
    {
      ac.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "update data failed. data is null.");
      AppMethodBeat.o(109164);
      return;
    }
    km(true);
    if (!bs.isNullOrNil(this.pjp.DXp))
    {
      ac.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "biz name is :%s", new Object[] { this.pjp.DXp });
      this.piT = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(this.pjp.DXp);
      if (((this.piT == null) || ((int)this.piT.fLJ == 0)) && (ar.a.hnw != null))
      {
        ac.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "getContact %s", new Object[] { this.pjp.DXp });
        ar.a.hnw.a(this.pjp.DXp, "", this.pjs);
      }
      this.pjc.setText(2131758390);
      if (bs.isNullOrNil(this.pjp.Desc)) {
        break label296;
      }
      this.piX.setText(this.pjp.Desc);
      this.piX.setVisibility(0);
    }
    for (;;)
    {
      ceh();
      if ((this.pdS != null) && (this.pdS.paz != null) && (!this.pdS.paz.isEmpty())) {
        break label308;
      }
      this.pjd.setVisibility(8);
      AppMethodBeat.o(109164);
      return;
      ac.w("MicroMsg.emoji.EmojiStoreV2DesignerUI", "mData.BizName is null");
      this.piY.setVisibility(8);
      this.piZ.setVisibility(8);
      break;
      label296:
      this.piX.setVisibility(8);
    }
    label308:
    this.pjd.setVisibility(0);
    AppMethodBeat.o(109164);
  }
  
  protected final com.tencent.mm.plugin.emoji.f.g Q(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(109177);
    this.pdW = new com.tencent.mm.plugin.emoji.f.g(paramString1, paramString2, paramString3);
    paramString1 = this.pdW;
    AppMethodBeat.o(109177);
    return paramString1;
  }
  
  public final void a(com.tencent.mm.plugin.emoji.a.a parama)
  {
    AppMethodBeat.i(109175);
    String str = parama.getProductId();
    if (TextUtils.isEmpty(parama.cbx())) {}
    for (Object localObject = "";; localObject = parama.cbx())
    {
      ac.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "[onProductClick] productId:%s, productPrice:%s, productStatus:%d", new Object[] { str, localObject, Integer.valueOf(parama.cbw()) });
      parama.cbw();
      localObject = com.tencent.mm.emoji.b.c.fVb;
      com.tencent.mm.emoji.b.c.adt().fP(parama.getProductId());
      localObject = com.tencent.mm.emoji.b.c.fVb;
      com.tencent.mm.emoji.b.c.lA(3);
      localObject = com.tencent.mm.emoji.b.c.fVb;
      com.tencent.mm.emoji.b.c.adt().fP("");
      this.pdT.a(parama);
      AppMethodBeat.o(109175);
      return;
    }
  }
  
  public final boolean bWx()
  {
    return true;
  }
  
  public final boolean bWz()
  {
    return false;
  }
  
  final void cP(String paramString, int paramInt)
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
  
  final void cQ(String paramString, int paramInt)
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
  
  public final void cci() {}
  
  protected final void cdd()
  {
    AppMethodBeat.i(109178);
    com.tencent.mm.kernel.g.agQ().ghe.a(this.pdW, 0);
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
    if (!bs.isNullOrNil(this.pbg)) {
      setMMTitle(this.pbg);
    }
    this.aew = z.jD(getContext()).inflate(2131493803, null);
    this.piU = this.aew.findViewById(2131299021);
    this.piV = ((BannerEmojiView)this.piU.findViewById(2131299332));
    this.piW = ((TextView)this.aew.findViewById(2131299023));
    this.piX = ((TextView)this.aew.findViewById(2131299019));
    this.piY = this.aew.findViewById(2131299017);
    this.piZ = this.aew.findViewById(2131299016);
    this.pja = ((TextView)this.aew.findViewById(2131299032));
    this.pjb = ((ImageView)this.aew.findViewById(2131299022));
    this.pjc = ((TextView)this.aew.findViewById(2131299020));
    this.pjd = ((TextView)this.aew.findViewById(2131299033));
    this.pje = this.aew.findViewById(2131299024);
    this.pjg = this.aew.findViewById(2131299028);
    this.pjg.setOnClickListener(new EmojiStoreV2DesignerUI.10(this));
    this.pjh = ((PreViewListGridView)this.aew.findViewById(2131299027));
    this.pji = new a(getContext());
    this.pji.pme = new a.a()
    {
      public final void Bm(int paramAnonymousInt)
      {
        AppMethodBeat.i(109152);
        if ((EmojiStoreV2DesignerUI.f(EmojiStoreV2DesignerUI.this) != null) && (EmojiStoreV2DesignerUI.g(EmojiStoreV2DesignerUI.this) != null))
        {
          ads localads = EmojiStoreV2DesignerUI.g(EmojiStoreV2DesignerUI.this).BB(paramAnonymousInt);
          if (localads != null)
          {
            com.tencent.mm.plugin.report.service.h.wUl.f(12787, new Object[] { Integer.valueOf(1), Integer.valueOf(0), localads.Md5, Long.valueOf(EmojiStoreV2DesignerUI.h(EmojiStoreV2DesignerUI.this)), localads.Ewv, localads.ProductID, Integer.valueOf(6) });
            try
            {
              Intent localIntent = new Intent();
              localIntent.putExtra("extra_object", localads.toByteArray());
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
    this.pjh.setAdapter(this.pji);
    this.pjj = this.aew.findViewById(2131299029);
    this.pjk = this.aew.findViewById(2131299030);
    this.pjl = this.aew.findViewById(2131299028);
    this.pjm = ((TextView)this.aew.findViewById(2131299031));
    this.pjn = this.aew.findViewById(2131299026);
    this.pjo = ((MMPullDownView)findViewById(2131301487));
    this.pjo.setOnBottomLoadDataListener(this);
    this.pjo.setAtBottomCallBack(this);
    this.pjo.setBottomViewVisible(false);
    this.pjo.setIsBottomShowAll(false);
    this.mListView = ((ListView)findViewById(16908298));
    this.mListView.setOnItemClickListener(this);
    this.mListView.setOnScrollListener(this);
    this.piZ.setOnClickListener(new EmojiStoreV2DesignerUI.12(this));
    setBackBtn(new EmojiStoreV2DesignerUI.13(this));
    addIconOptionMenu(0, 2131690655, new EmojiStoreV2DesignerUI.14(this));
    AppMethodBeat.o(109162);
  }
  
  protected final void km(boolean paramBoolean)
  {
    AppMethodBeat.i(109165);
    if (this.pjp == null)
    {
      ac.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "update header failed. data is null.");
      AppMethodBeat.o(109165);
      return;
    }
    if ((this.piV != null) && (!bs.isNullOrNil(this.pjp.ESi)))
    {
      Object localObject = this.pjp.ESi;
      com.tencent.mm.cc.a.getDensity(this);
      localObject = EmojiLogic.x("Designer", 8, (String)localObject);
      if (localObject == null)
      {
        if (paramBoolean)
        {
          o.aFB().a(this.pjp.ESi, null, com.tencent.mm.plugin.emoji.e.e.h("Designer", this.pjp.ESi, new Object[] { "Designer", "BANNER" }), new com.tencent.mm.av.a.c.k()
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
        ac.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "updateDesignerHeader failed");
        AppMethodBeat.o(109165);
        return;
      }
      this.piV.setImageFilePath(((EmojiInfo)localObject).ghd());
    }
    AppMethodBeat.o(109165);
  }
  
  public final void l(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(109176);
    Q(paramString1, paramString2, paramString3);
    cdd();
    AppMethodBeat.o(109176);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(109181);
    this.pdT.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 2002) {
      if (paramInt2 == -1)
      {
        String str1 = paramIntent.getStringExtra("Select_Conv_User");
        if ((bs.isNullOrNil(str1)) || (this.pjp == null)) {
          break label224;
        }
        ac.d("MicroMsg.emoji.EmojiStoreV2DesignerUI", "..".concat(String.valueOf(str1)));
        String str2 = this.pbg;
        String str3 = this.pjp.Desc;
        int i = this.piP;
        String str4 = this.piR;
        String str5 = this.pbg;
        String str6 = this.pjp.HeadUrl;
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
      ac.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "member or data is null.");
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
    this.pck = getIntent().getStringExtra("id");
    this.piP = getIntent().getIntExtra("uin", 0);
    this.pbg = getIntent().getStringExtra("name");
    this.piQ = getIntent().getStringExtra("headurl");
    this.piR = getIntent().getStringExtra("rediret_url");
    this.mScene = getIntent().getIntExtra("extra_scence", 0);
    this.pbb = getIntent().getLongExtra("searchID", 0L);
    this.pbc = bs.bG(getIntent().getStringExtra("docID"), "");
    paramBundle = getIntent().getStringExtra("sns_object_data");
    if (!TextUtils.isEmpty(paramBundle))
    {
      this.piP = EmojiLogic.XU(paramBundle);
      this.pbg = EmojiLogic.XV(paramBundle);
      this.piR = EmojiLogic.Yd(paramBundle);
    }
    initView();
    paramBundle = aw.a.GXG;
    paramBundle = aw.a.YJ(this.piP);
    int i = (int)bs.aNx();
    paramBundle = (Iterable)paramBundle.GXD;
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
    this.piS = ((List)localCollection);
    if (!bs.isNullOrNil(this.pck))
    {
      paramBundle = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().GYf.aPa(this.pck);
      if ((paramBundle != null) && (paramBundle.EOk != null) && (paramBundle.EOk.DesignerUin != 0) && (!bs.isNullOrNil(paramBundle.EOk.Name)))
      {
        this.piP = paramBundle.EOk.DesignerUin;
        this.pbg = paramBundle.EOk.Name;
        ac.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "uin:%s name:%s", new Object[] { Integer.valueOf(this.piP), this.pbg });
      }
    }
    else
    {
      i = 0;
      if (i != 0) {
        break label579;
      }
      WJ();
    }
    for (;;)
    {
      com.tencent.mm.kernel.g.agQ().ghe.a(239, this);
      com.tencent.mm.kernel.g.agQ().ghe.a(720, this);
      com.tencent.mm.sdk.b.a.GpY.c(this.pdV);
      com.tencent.mm.plugin.report.service.h.wUl.f(12067, new Object[] { Integer.valueOf(1), "", "", "", "" });
      com.tencent.mm.plugin.report.service.h.wUl.f(12740, new Object[] { Integer.valueOf(2), com.tencent.mm.b.p.getString(this.piP), "", "", Integer.valueOf(this.mScene), Integer.valueOf(6) });
      paramBundle = aw.a.GXG;
      aw.a.YJ(this.piP).faY();
      AppMethodBeat.o(109158);
      return;
      i = 1;
      break;
      label579:
      this.pjq = new com.tencent.mm.plugin.emoji.f.i(this.pck);
      com.tencent.mm.kernel.g.agQ().ghe.a(this.pjq, 0);
      getString(2131755906);
      this.pjr = com.tencent.mm.ui.base.h.b(this, getString(2131755936), true, new EmojiStoreV2DesignerUI.7(this));
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(109161);
    super.onDestroy();
    com.tencent.mm.emoji.b.c localc = com.tencent.mm.emoji.b.c.fVb;
    com.tencent.mm.emoji.b.c.adt().fP("");
    localc = com.tencent.mm.emoji.b.c.fVb;
    com.tencent.mm.emoji.b.c.lA(5);
    if (this.pjw != null) {
      com.tencent.mm.kernel.g.agQ().ghe.a(this.pjw);
    }
    com.tencent.mm.kernel.g.agQ().ghe.b(239, this);
    com.tencent.mm.kernel.g.agQ().ghe.b(720, this);
    com.tencent.mm.sdk.b.a.GpY.d(this.pdV);
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
    if (this.ped != null)
    {
      int i = this.mListView.getHeaderViewsCount();
      paramAdapterView = this.ped.Bk(paramInt - i);
      if (paramAdapterView != null)
      {
        paramView = new Intent();
        paramView.setClass(this, EmojiStoreDetailUI.class);
        localObject = paramAdapterView.oYl;
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
        paramAdapterView = new com.tencent.mm.hellhoundlib.b.a().ba(paramAdapterView);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramAdapterView.aeD(), "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2DesignerUI", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramAdapterView.lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2DesignerUI", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      AppMethodBeat.o(109174);
      return;
      label151:
      com.tencent.mm.emoji.b.c localc = com.tencent.mm.emoji.b.c.fVb;
      com.tencent.mm.emoji.b.c.adt().fP(((EmotionSummary)localObject).ProductID);
      localc = com.tencent.mm.emoji.b.c.fVb;
      com.tencent.mm.emoji.b.c.lA(4);
      localc = com.tencent.mm.emoji.b.c.fVb;
      com.tencent.mm.emoji.b.c.adt().fP("");
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
      paramView.putExtra("extra_progress", paramAdapterView.FG);
      paramView.putExtra("searchID", this.pbb);
      localObject = getIntent().getStringExtra("to_talker_name");
      paramAdapterView = paramView;
      if (!bs.isNullOrNil((String)localObject))
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
    com.tencent.mm.kernel.g.agQ().ghe.b(423, this);
    AppMethodBeat.o(109160);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(109159);
    super.onResume();
    com.tencent.mm.kernel.g.agQ().ghe.a(423, this);
    AppMethodBeat.o(109159);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, final n paramn)
  {
    AppMethodBeat.i(109168);
    switch (paramn.getType())
    {
    default: 
      ac.e("MicroMsg.emoji.EmojiStoreV2DesignerUI", "unknow scene type");
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
          cQ(paramString.pbW, 0);
          AppMethodBeat.o(109168);
          return;
        }
        paramn = paramString.pbW;
        final String str1 = paramString.pbY;
        final String str2 = paramString.pbX;
        com.tencent.mm.ui.base.h.a(this, getString(2131758320, new Object[] { str2 }), "", new DialogInterface.OnClickListener()new EmojiStoreV2DesignerUI.4
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(109145);
            EmojiStoreV2DesignerUI.this.Q(paramn, str1, str2);
            EmojiStoreV2DesignerUI.this.cdd();
            ac.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "Retry doScene ExchangeEmotionPackNetScene productId:%s", new Object[] { paramn });
            EmojiStoreV2DesignerUI.a(EmojiStoreV2DesignerUI.this, paramn);
            AppMethodBeat.o(109145);
          }
        }, new EmojiStoreV2DesignerUI.4(this));
        cP(paramString.pbW, -1);
        AppMethodBeat.o(109168);
        return;
      } while (!(paramn instanceof com.tencent.mm.plugin.emoji.f.p));
      this.kOL = false;
      if ((paramInt1 == 0) || (paramInt1 == 4))
      {
        paramString = (com.tencent.mm.plugin.emoji.f.p)paramn;
        paramn = com.tencent.mm.plugin.emoji.f.p.a(paramString.ccI());
        if (paramInt2 == 0)
        {
          this.pjp = paramString.ccI();
          c(paramn);
        }
        for (;;)
        {
          if ((this.pdG == null) && (this.pjp != null))
          {
            com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().GYc.a(String.valueOf(this.piP), paramString.ccI());
            this.pjf = this.pjp.DWQ;
            cR(this.pjf);
          }
          this.pdG = paramString.pcq;
          AppMethodBeat.o(109168);
          return;
          if (paramInt2 == 2)
          {
            this.pjp = paramString.ccI();
            b(this.pdE, paramn);
            this.pdE = 2;
          }
          else if (paramInt2 == 3)
          {
            this.pjp = paramString.ccI();
            b(this.pdE, paramn);
            this.pdE = 1;
            ac.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "get person designer failed errCode:%d", new Object[] { Integer.valueOf(paramInt2) });
          }
        }
      }
      ac.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "get person designer failed");
      AppMethodBeat.o(109168);
      return;
    }
    if ((this.pjr != null) && (this.pjr.isShowing())) {
      this.pjr.dismiss();
    }
    if ((paramInt2 == 0) && (paramInt1 == 0))
    {
      paramString = ((com.tencent.mm.plugin.emoji.f.i)paramn).ccA();
      if ((paramString != null) && (paramString.EOk != null))
      {
        this.piP = paramString.EOk.DesignerUin;
        this.pbg = paramString.EOk.Name;
        this.piQ = paramString.EOk.HeadUrl;
        if (this.mHandler != null) {
          this.mHandler.sendEmptyMessage(10003);
        }
      }
      AppMethodBeat.o(109168);
      return;
    }
    showOptionMenu(0, false);
    com.tencent.mm.ui.base.h.c(getContext(), getString(2131758253), null, true);
    ac.e("MicroMsg.emoji.EmojiStoreV2DesignerUI", "open designer failed .");
    AppMethodBeat.o(109168);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(109173);
    if ((paramInt == 0) && (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1))
    {
      if ((this.pdE == 0) || (this.kOL))
      {
        ac.d("MicroMsg.emoji.EmojiStoreV2DesignerUI", "No More List.");
        AppMethodBeat.o(109173);
        return;
      }
      aZ(this.pdG);
      ac.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "[onScrollStateChanged] startLoadRemoteEmoji.");
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