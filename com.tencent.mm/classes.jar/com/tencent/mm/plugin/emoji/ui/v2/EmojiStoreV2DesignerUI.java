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
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.b.p;
import com.tencent.mm.contact.c;
import com.tencent.mm.emoji.b.n;
import com.tencent.mm.emoji.c.d;
import com.tencent.mm.g.a.dp;
import com.tencent.mm.g.b.a.aq;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.ay.a;
import com.tencent.mm.model.ay.b;
import com.tencent.mm.model.ay.b.a;
import com.tencent.mm.plugin.emoji.e.e;
import com.tencent.mm.plugin.emoji.e.j.2;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.j.a;
import com.tencent.mm.plugin.emoji.model.j.b;
import com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.emoji.BannerEmojiView;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.protocal.protobuf.PersonalDesigner;
import com.tencent.mm.protocal.protobuf.ait;
import com.tencent.mm.protocal.protobuf.bmi;
import com.tencent.mm.protocal.protobuf.bsp;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bg.a;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.s;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.c;
import com.tencent.mm.ui.base.MMPullDownView.e;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class EmojiStoreV2DesignerUI
  extends MMActivity
  implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener, i, j.a, j.b, MMPullDownView.c, MMPullDownView.e
{
  private View agA;
  private MMHandler mHandler;
  private ListView mListView;
  private int mScene;
  private boolean mwr;
  private long rbH;
  private String rbI;
  private String rbM;
  private String rcS;
  com.tencent.mm.plugin.emoji.a.f reH;
  private int ree;
  private byte[] reh;
  protected final int rel;
  private final int rem;
  private final int ren;
  private final String reo;
  private final String rep;
  private final String rer;
  private com.tencent.mm.plugin.emoji.model.g rev;
  private com.tencent.mm.plugin.emoji.model.j rew;
  private IListener rey;
  private com.tencent.mm.plugin.emoji.f.h rez;
  private int rjT;
  private String rjU;
  private String rjV;
  private List<String> rjW;
  private as rjX;
  private View rjY;
  private BannerEmojiView rjZ;
  private com.tencent.mm.plugin.emoji.f.q rkA;
  private TextView rka;
  private TextView rkb;
  private View rkc;
  private View rkd;
  private TextView rke;
  private ImageView rkf;
  private TextView rkg;
  private TextView rkh;
  View rki;
  private List<ait> rkj;
  private View rkk;
  PreViewListGridView rkl;
  private a rkm;
  View rkn;
  View rko;
  View rkp;
  TextView rkq;
  View rkr;
  private MMPullDownView rks;
  private bsp rkt;
  private com.tencent.mm.plugin.emoji.f.j rku;
  private com.tencent.mm.ui.base.q rkv;
  private ay.b.a rkw;
  private final int rkx;
  private final int rky;
  private final int rkz;
  
  public EmojiStoreV2DesignerUI()
  {
    AppMethodBeat.i(109157);
    this.rkj = new ArrayList();
    this.ree = -1;
    this.rel = 131074;
    this.rem = 131075;
    this.ren = 131076;
    this.reo = "product_id";
    this.rep = "progress";
    this.rer = "status";
    this.rey = new IListener() {};
    this.rkw = new ay.b.a()
    {
      public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(109149);
        Log.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "getContactCallBack username:%s,succ:%b", new Object[] { paramAnonymousString, Boolean.valueOf(paramAnonymousBoolean) });
        if (paramAnonymousBoolean)
        {
          EmojiStoreV2DesignerUI.a(EmojiStoreV2DesignerUI.this, ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(paramAnonymousString));
          EmojiStoreV2DesignerUI.a(EmojiStoreV2DesignerUI.this);
        }
        AppMethodBeat.o(109149);
      }
    };
    this.rkx = 10001;
    this.rky = 10002;
    this.rkz = 10003;
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
          EmojiStoreV2DesignerUI.this.ly(false);
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
          EmojiStoreV2DesignerUI.d(EmojiStoreV2DesignerUI.this).dd(str, i);
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
          EmojiStoreV2DesignerUI.d(EmojiStoreV2DesignerUI.this).dc(str, i);
        }
      }
    };
    AppMethodBeat.o(109157);
  }
  
  private void amZ()
  {
    AppMethodBeat.i(109163);
    setMMTitle(this.rbM);
    this.reH = new com.tencent.mm.plugin.emoji.a.f(getContext());
    this.reH.df(this.rjW);
    this.mListView.addHeaderView(this.agA);
    this.mListView.setAdapter(this.reH);
    this.reH.qYa = this;
    this.reH.qXv = n.auV();
    this.reH.qXw = false;
    this.rka.setText(this.rbM);
    this.rkt = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpQ.blw(String.valueOf(this.rjT));
    this.rew = new com.tencent.mm.plugin.emoji.model.j();
    this.rew.owO = this;
    this.rew.rbD = this.reH;
    this.rew.rbG = 6;
    this.rew.rbJ = this;
    this.rew.rbM = this.rbM;
    this.rew.rbH = this.rbH;
    this.rew.rbI = this.rbI;
    if (this.rkt != null)
    {
      c(com.tencent.mm.plugin.emoji.f.q.a(this.rkt));
      dj(this.rkt.KOp);
    }
    updateData();
    br(this.reh);
    AppMethodBeat.o(109163);
  }
  
  private void b(int paramInt, com.tencent.mm.plugin.emoji.model.g paramg)
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
      lz(bool);
      AppMethodBeat.o(109171);
      return;
      this.rev = paramg;
      continue;
      this.rev = paramg;
      continue;
      this.rev = paramg;
      continue;
      if (this.rev == null) {
        this.rev = new com.tencent.mm.plugin.emoji.model.g();
      }
      this.rev.FX(paramg.rbs);
      this.rev.dg(paramg.rbt);
    }
  }
  
  private void br(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(109167);
    this.mwr = true;
    this.rkA = new com.tencent.mm.plugin.emoji.f.q(this.rjT, paramArrayOfByte);
    com.tencent.mm.kernel.g.aAg().hqi.a(this.rkA, 0);
    AppMethodBeat.o(109167);
  }
  
  private void c(com.tencent.mm.plugin.emoji.model.g paramg)
  {
    AppMethodBeat.i(109170);
    b(this.ree, paramg);
    this.ree = 0;
    AppMethodBeat.o(109170);
  }
  
  private void cIb()
  {
    AppMethodBeat.i(109166);
    if ((this.rjX != null) && ((int)this.rjX.gMZ != 0))
    {
      this.rkd.setVisibility(0);
      this.rkc.setVisibility(0);
      if (!Util.isNullOrNil(this.rjX.arI())) {
        this.rke.setText(this.rjX.arI());
      }
      for (;;)
      {
        a.b.d(this.rkf, this.rjX.field_username);
        this.rkg.setEnabled(true);
        AppMethodBeat.o(109166);
        return;
        this.rke.setText(this.rjX.field_username);
      }
    }
    this.rkd.setVisibility(8);
    this.rkc.setVisibility(8);
    AppMethodBeat.o(109166);
  }
  
  private void dj(final List<ait> paramList)
  {
    int i = 1;
    AppMethodBeat.i(109169);
    String str = com.tencent.mm.n.h.aqJ().getValue("ShowDesignerEmoji");
    Log.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "get dynamic Disgner_Emoji_Store_Show config value:%s", new Object[] { str });
    if ((!Util.isNullOrNil(str)) && (Util.safeParseInt(str) == 1)) {}
    while ((paramList != null) && (paramList.size() > 0) && (i != 0))
    {
      this.rki.setVisibility(0);
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
              if (localEmojiStoreV2DesignerUI.rkl != null) {
                localEmojiStoreV2DesignerUI.rkl.setVisibility(0);
              }
              if (localEmojiStoreV2DesignerUI.rko != null) {
                localEmojiStoreV2DesignerUI.rko.setVisibility(0);
              }
              if (localEmojiStoreV2DesignerUI.rkn != null) {
                localEmojiStoreV2DesignerUI.rkn.setVisibility(0);
              }
              if (localEmojiStoreV2DesignerUI.rkp != null)
              {
                localView = localEmojiStoreV2DesignerUI.rkp;
                if (i == 0) {
                  break label185;
                }
              }
            }
            label185:
            for (int j = 0;; j = 8)
            {
              localView.setVisibility(j);
              if (localEmojiStoreV2DesignerUI.rkq != null) {
                localEmojiStoreV2DesignerUI.rkq.setText(2131758641);
              }
              if (localEmojiStoreV2DesignerUI.rkr != null)
              {
                localView = localEmojiStoreV2DesignerUI.rkr;
                j = k;
                if (i != 0) {
                  j = 0;
                }
                localView.setVisibility(j);
              }
              if (localEmojiStoreV2DesignerUI.rki != null) {
                localEmojiStoreV2DesignerUI.rki.setPadding(0, 0, 0, 0);
              }
              AppMethodBeat.o(109144);
              return;
              i = 0;
              break;
            }
          }
        });
      }
      this.rkm.ad(paramList);
      AppMethodBeat.o(109169);
      return;
      i = 0;
    }
    this.rki.setVisibility(8);
    AppMethodBeat.o(109169);
  }
  
  private void lz(boolean paramBoolean)
  {
    AppMethodBeat.i(109172);
    if ((this.rev != null) && (paramBoolean))
    {
      if (this.reH != null) {
        this.reH.b(this.rev);
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
    if (this.rkt == null)
    {
      Log.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "update data failed. data is null.");
      AppMethodBeat.o(109164);
      return;
    }
    ly(true);
    if (!Util.isNullOrNil(this.rkt.KOR))
    {
      Log.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "biz name is :%s", new Object[] { this.rkt.KOR });
      this.rjX = ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(this.rkt.KOR);
      if (((this.rjX == null) || ((int)this.rjX.gMZ == 0)) && (ay.a.iDq != null))
      {
        Log.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "getContact %s", new Object[] { this.rkt.KOR });
        ay.a.iDq.a(this.rkt.KOR, "", this.rkw);
      }
      this.rkg.setText(2131758684);
      if (Util.isNullOrNil(this.rkt.Desc)) {
        break label296;
      }
      this.rkb.setText(this.rkt.Desc);
      this.rkb.setVisibility(0);
    }
    for (;;)
    {
      cIb();
      if ((this.rev != null) && (this.rev.rbt != null) && (!this.rev.rbt.isEmpty())) {
        break label308;
      }
      this.rkh.setVisibility(8);
      AppMethodBeat.o(109164);
      return;
      Log.w("MicroMsg.emoji.EmojiStoreV2DesignerUI", "mData.BizName is null");
      this.rkc.setVisibility(8);
      this.rkd.setVisibility(8);
      break;
      label296:
      this.rkb.setVisibility(8);
    }
    label308:
    this.rkh.setVisibility(0);
    AppMethodBeat.o(109164);
  }
  
  protected final com.tencent.mm.plugin.emoji.f.h X(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(240181);
    this.rez = new com.tencent.mm.plugin.emoji.f.h(paramString1, paramString2, paramString3);
    paramString1 = this.rez;
    AppMethodBeat.o(240181);
    return paramString1;
  }
  
  public final void a(com.tencent.mm.plugin.emoji.a.a parama)
  {
    AppMethodBeat.i(109175);
    String str = parama.getProductId();
    if (TextUtils.isEmpty(parama.cFd())) {}
    for (Object localObject = "";; localObject = parama.cFd())
    {
      Log.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "[onProductClick] productId:%s, productPrice:%s, productStatus:%d", new Object[] { str, localObject, Integer.valueOf(parama.cFc()) });
      parama.cFc();
      localObject = d.hcj;
      d.awd().iu(parama.getProductId());
      localObject = d.hcj;
      d.pl(3);
      localObject = d.hcj;
      d.awd().iu("");
      this.rew.a(parama);
      AppMethodBeat.o(109175);
      return;
    }
  }
  
  public final boolean cAj()
  {
    return true;
  }
  
  public final boolean cAl()
  {
    return false;
  }
  
  protected final void cGU()
  {
    AppMethodBeat.i(109178);
    com.tencent.mm.kernel.g.aAg().hqi.a(this.rez, 0);
    AppMethodBeat.o(109178);
  }
  
  public final void cGa() {}
  
  public final void d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(240180);
    X(paramString1, paramString2, paramString3);
    cGU();
    AppMethodBeat.o(240180);
  }
  
  final void dc(String paramString, int paramInt)
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
  
  final void dd(String paramString, int paramInt)
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
    return 2131493961;
  }
  
  public void initView()
  {
    AppMethodBeat.i(109162);
    if (!Util.isNullOrNil(this.rbM)) {
      setMMTitle(this.rbM);
    }
    this.agA = aa.jQ(getContext()).inflate(2131493957, null);
    this.rjY = this.agA.findViewById(2131299524);
    this.rjZ = ((BannerEmojiView)this.rjY.findViewById(2131299944));
    this.rka = ((TextView)this.agA.findViewById(2131299526));
    this.rkb = ((TextView)this.agA.findViewById(2131299522));
    this.rkc = this.agA.findViewById(2131299520);
    this.rkd = this.agA.findViewById(2131299519);
    this.rke = ((TextView)this.agA.findViewById(2131299535));
    this.rkf = ((ImageView)this.agA.findViewById(2131299525));
    this.rkg = ((TextView)this.agA.findViewById(2131299523));
    this.rkh = ((TextView)this.agA.findViewById(2131299536));
    this.rki = this.agA.findViewById(2131299527);
    this.rkk = this.agA.findViewById(2131299531);
    this.rkk.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(109151);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2DesignerUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        EmojiStoreV2DesignerUI.e(EmojiStoreV2DesignerUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2DesignerUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(109151);
      }
    });
    this.rkl = ((PreViewListGridView)this.agA.findViewById(2131299530));
    this.rkm = new a(getContext());
    this.rkm.rni = new a.a()
    {
      public final void FP(int paramAnonymousInt)
      {
        AppMethodBeat.i(109152);
        if ((EmojiStoreV2DesignerUI.f(EmojiStoreV2DesignerUI.this) != null) && (EmojiStoreV2DesignerUI.g(EmojiStoreV2DesignerUI.this) != null))
        {
          ait localait = EmojiStoreV2DesignerUI.g(EmojiStoreV2DesignerUI.this).Gg(paramAnonymousInt);
          if (localait != null)
          {
            com.tencent.mm.plugin.report.service.h.CyF.a(12787, new Object[] { Integer.valueOf(1), Integer.valueOf(0), localait.Md5, Long.valueOf(EmojiStoreV2DesignerUI.h(EmojiStoreV2DesignerUI.this)), localait.Lsl, localait.ProductID, Integer.valueOf(6) });
            try
            {
              Intent localIntent = new Intent();
              localIntent.putExtra("extra_object", localait.toByteArray());
              localIntent.putExtra("add_source", 5);
              localIntent.putExtra("entrance_scene", 6);
              localIntent.setClass(EmojiStoreV2DesignerUI.this.getContext(), EmojiStoreV2SingleProductDialogUI.class);
              EmojiStoreV2DesignerUI.this.startActivityForResult(localIntent, 2004);
              EmojiStoreV2DesignerUI.this.overridePendingTransition(2130772119, 2130772124);
              AppMethodBeat.o(109152);
              return;
            }
            catch (Exception localException) {}
          }
        }
        AppMethodBeat.o(109152);
      }
    };
    this.rkl.setAdapter(this.rkm);
    this.rkn = this.agA.findViewById(2131299532);
    this.rko = this.agA.findViewById(2131299533);
    this.rkp = this.agA.findViewById(2131299531);
    this.rkq = ((TextView)this.agA.findViewById(2131299534));
    this.rkr = this.agA.findViewById(2131299529);
    this.rks = ((MMPullDownView)findViewById(2131303686));
    this.rks.setOnBottomLoadDataListener(this);
    this.rks.setAtBottomCallBack(this);
    this.rks.setBottomViewVisible(false);
    this.rks.setIsBottomShowAll(false);
    this.mListView = ((ListView)findViewById(16908298));
    this.mListView.setOnItemClickListener(this);
    this.mListView.setOnScrollListener(this);
    this.rkd.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(109153);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2DesignerUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
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
    addIconOptionMenu(0, 2131690907, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(109155);
        Log.d("MicroMsg.emoji.EmojiStoreV2DesignerUI", "on shard click.");
        EmojiStoreV2DesignerUI.j(EmojiStoreV2DesignerUI.this);
        AppMethodBeat.o(109155);
        return true;
      }
    });
    AppMethodBeat.o(109162);
  }
  
  protected final void ly(boolean paramBoolean)
  {
    AppMethodBeat.i(109165);
    if (this.rkt == null)
    {
      Log.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "update header failed. data is null.");
      AppMethodBeat.o(109165);
      return;
    }
    if ((this.rjZ != null) && (!Util.isNullOrNil(this.rkt.LZs)))
    {
      Object localObject = this.rkt.LZs;
      com.tencent.mm.cb.a.getDensity(this);
      localObject = EmojiLogic.H("Designer", 8, (String)localObject);
      if (localObject == null)
      {
        if (paramBoolean)
        {
          com.tencent.mm.av.q.bcV().a(this.rkt.LZs, null, e.j("Designer", this.rkt.LZs, new Object[] { "Designer", "BANNER" }), new com.tencent.mm.av.a.c.k()
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
      this.rjZ.setImageFilePath(((EmojiInfo)localObject).hRM());
    }
    AppMethodBeat.o(109165);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(109181);
    this.rew.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 2002) {
      if (paramInt2 == -1)
      {
        String str1 = paramIntent.getStringExtra("Select_Conv_User");
        if ((Util.isNullOrNil(str1)) || (this.rkt == null)) {
          break label224;
        }
        Log.d("MicroMsg.emoji.EmojiStoreV2DesignerUI", "..".concat(String.valueOf(str1)));
        String str2 = this.rbM;
        String str3 = this.rkt.Desc;
        int i = this.rjT;
        String str4 = this.rjV;
        String str5 = this.rbM;
        String str6 = this.rkt.HeadUrl;
        String str7 = getResources().getString(2131755781);
        str7 = str7 + str2;
        String str8 = getString(2131755976);
        String str9 = getString(2131757786);
        ((com.tencent.mm.pluginsdk.j)com.tencent.mm.kernel.g.af(com.tencent.mm.pluginsdk.j.class)).a(this, str1, str7, str8, str9, str6, new j.2(str1, str5, str3, i, str4, str2, str6, this));
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
        com.tencent.mm.ui.widget.snackbar.b.r(this, getContext().getString(2131755979));
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(109158);
    super.onCreate(paramBundle);
    this.rcS = getIntent().getStringExtra("id");
    this.rjT = getIntent().getIntExtra("uin", 0);
    this.rbM = getIntent().getStringExtra("name");
    this.rjU = getIntent().getStringExtra("headurl");
    this.rjV = getIntent().getStringExtra("rediret_url");
    this.mScene = getIntent().getIntExtra("extra_scence", 0);
    this.rbH = getIntent().getLongExtra("searchID", 0L);
    this.rbI = Util.nullAs(getIntent().getStringExtra("docID"), "");
    paramBundle = getIntent().getStringExtra("sns_object_data");
    if (!TextUtils.isEmpty(paramBundle))
    {
      this.rjT = EmojiLogic.amu(paramBundle);
      this.rbM = EmojiLogic.amv(paramBundle);
      this.rjV = EmojiLogic.amH(paramBundle);
    }
    initView();
    paramBundle = bg.a.Opu;
    paramBundle = bg.a.aki(this.rjT);
    int i = (int)Util.nowSecond();
    paramBundle = (Iterable)paramBundle.LGy;
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
    this.rjW = ((List)localCollection);
    if (!Util.isNullOrNil(this.rcS))
    {
      paramBundle = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpT.blr(this.rcS);
      if ((paramBundle != null) && (paramBundle.LVe != null) && (paramBundle.LVe.DesignerUin != 0) && (!Util.isNullOrNil(paramBundle.LVe.Name)))
      {
        this.rjT = paramBundle.LVe.DesignerUin;
        this.rbM = paramBundle.LVe.Name;
        Log.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "uin:%s name:%s", new Object[] { Integer.valueOf(this.rjT), this.rbM });
      }
    }
    else
    {
      i = 0;
      if (i != 0) {
        break label579;
      }
      amZ();
    }
    for (;;)
    {
      com.tencent.mm.kernel.g.aAg().hqi.a(239, this);
      com.tencent.mm.kernel.g.aAg().hqi.a(720, this);
      EventCenter.instance.addListener(this.rey);
      com.tencent.mm.plugin.report.service.h.CyF.a(12067, new Object[] { Integer.valueOf(1), "", "", "", "" });
      com.tencent.mm.plugin.report.service.h.CyF.a(12740, new Object[] { Integer.valueOf(2), p.getString(this.rjT), "", "", Integer.valueOf(this.mScene), Integer.valueOf(6) });
      paramBundle = bg.a.Opu;
      bg.a.aki(this.rjT).gCI();
      AppMethodBeat.o(109158);
      return;
      i = 1;
      break;
      label579:
      this.rku = new com.tencent.mm.plugin.emoji.f.j(this.rcS);
      com.tencent.mm.kernel.g.aAg().hqi.a(this.rku, 0);
      getString(2131755998);
      this.rkv = com.tencent.mm.ui.base.h.a(this, getString(2131756029), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(109148);
          if (EmojiStoreV2DesignerUI.p(EmojiStoreV2DesignerUI.this) != null) {
            com.tencent.mm.kernel.g.aAg().hqi.a(EmojiStoreV2DesignerUI.p(EmojiStoreV2DesignerUI.this));
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
    d locald = d.hcj;
    d.awd().iu("");
    locald = d.hcj;
    d.pl(5);
    if (this.rkA != null) {
      com.tencent.mm.kernel.g.aAg().hqi.a(this.rkA);
    }
    com.tencent.mm.kernel.g.aAg().hqi.b(239, this);
    com.tencent.mm.kernel.g.aAg().hqi.b(720, this);
    EventCenter.instance.removeListener(this.rey);
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
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAdapterView);
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
    ((com.tencent.mm.hellhoundlib.b.b)localObject).pH(paramInt);
    ((com.tencent.mm.hellhoundlib.b.b)localObject).zo(paramLong);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2DesignerUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
    if (this.reH != null)
    {
      int i = this.mListView.getHeaderViewsCount();
      paramAdapterView = this.reH.FN(paramInt - i);
      if (paramAdapterView != null)
      {
        paramView = new Intent();
        paramView.setClass(this, EmojiStoreDetailUI.class);
        localObject = paramAdapterView.qYl;
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
        paramAdapterView = new com.tencent.mm.hellhoundlib.b.a().bl(paramAdapterView);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramAdapterView.axQ(), "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2DesignerUI", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramAdapterView.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2DesignerUI", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2DesignerUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(109174);
      return;
      label222:
      d locald = d.hcj;
      d.awd().iu(((EmotionSummary)localObject).ProductID);
      locald = d.hcj;
      d.pl(4);
      locald = d.hcj;
      d.awd().iu("");
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
      paramView.putExtra("extra_progress", paramAdapterView.HH);
      paramView.putExtra("searchID", this.rbH);
      localObject = getIntent().getStringExtra("to_talker_name");
      paramAdapterView = paramView;
      if (!Util.isNullOrNil((String)localObject))
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
    com.tencent.mm.kernel.g.aAg().hqi.b(423, this);
    AppMethodBeat.o(109160);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(109159);
    super.onResume();
    com.tencent.mm.kernel.g.aAg().hqi.a(423, this);
    AppMethodBeat.o(109159);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, final com.tencent.mm.ak.q paramq)
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
          dd(paramString.rcD, 0);
          AppMethodBeat.o(109168);
          return;
        }
        paramq = paramString.rcD;
        final String str1 = paramString.rcF;
        final String str2 = paramString.rcE;
        final String str3 = paramString.rcH;
        com.tencent.mm.ui.base.h.a(this, getString(2131758614, new Object[] { str2 }), "", new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(109145);
            EmojiStoreV2DesignerUI.this.X(paramq, str1, str2);
            EmojiStoreV2DesignerUI.this.cGU();
            Log.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "Retry doScene ExchangeEmotionPackNetScene productId:%s", new Object[] { paramq });
            EmojiStoreV2DesignerUI.a(EmojiStoreV2DesignerUI.this, paramq);
            AppMethodBeat.o(109145);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        dc(paramString.rcD, -1);
        AppMethodBeat.o(109168);
        return;
      } while (!(paramq instanceof com.tencent.mm.plugin.emoji.f.q));
      this.mwr = false;
      if ((paramInt1 == 0) || (paramInt1 == 4))
      {
        paramString = (com.tencent.mm.plugin.emoji.f.q)paramq;
        paramq = com.tencent.mm.plugin.emoji.f.q.a(paramString.cGA());
        if (paramInt2 == 0)
        {
          this.rkt = paramString.cGA();
          c(paramq);
        }
        for (;;)
        {
          if ((this.reh == null) && (this.rkt != null))
          {
            com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpQ.a(String.valueOf(this.rjT), paramString.cGA());
            this.rkj = this.rkt.KOp;
            dj(this.rkj);
          }
          this.reh = paramString.rcY;
          AppMethodBeat.o(109168);
          return;
          if (paramInt2 == 2)
          {
            this.rkt = paramString.cGA();
            b(this.ree, paramq);
            this.ree = 2;
          }
          else if (paramInt2 == 3)
          {
            this.rkt = paramString.cGA();
            b(this.ree, paramq);
            this.ree = 1;
            Log.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "get person designer failed errCode:%d", new Object[] { Integer.valueOf(paramInt2) });
          }
        }
      }
      Log.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "get person designer failed");
      AppMethodBeat.o(109168);
      return;
    }
    if ((this.rkv != null) && (this.rkv.isShowing())) {
      this.rkv.dismiss();
    }
    if ((paramInt2 == 0) && (paramInt1 == 0))
    {
      paramString = ((com.tencent.mm.plugin.emoji.f.j)paramq).cGt();
      if ((paramString != null) && (paramString.LVe != null))
      {
        this.rjT = paramString.LVe.DesignerUin;
        this.rbM = paramString.LVe.Name;
        this.rjU = paramString.LVe.HeadUrl;
        if (this.mHandler != null) {
          this.mHandler.sendEmptyMessage(10003);
        }
      }
      AppMethodBeat.o(109168);
      return;
    }
    showOptionMenu(0, false);
    com.tencent.mm.ui.base.h.c(getContext(), getString(2131758541), null, true);
    Log.e("MicroMsg.emoji.EmojiStoreV2DesignerUI", "open designer failed .");
    AppMethodBeat.o(109168);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(109173);
    if ((paramInt == 0) && (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1))
    {
      if ((this.ree == 0) || (this.mwr))
      {
        Log.d("MicroMsg.emoji.EmojiStoreV2DesignerUI", "No More List.");
        AppMethodBeat.o(109173);
        return;
      }
      br(this.reh);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI
 * JD-Core Version:    0.7.0.1
 */