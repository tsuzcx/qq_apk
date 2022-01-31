package com.tencent.mm.plugin.emoji.ui.v2;

import android.app.Activity;
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
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.at.o;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.ao.b;
import com.tencent.mm.model.ao.b.a;
import com.tencent.mm.plugin.emoji.e.l;
import com.tencent.mm.plugin.emoji.e.l.2;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.h.a;
import com.tencent.mm.plugin.emoji.model.h.b;
import com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.emoji.BannerEmojiView;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.protocal.protobuf.PersonalDesigner;
import com.tencent.mm.protocal.protobuf.ajr;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.protocal.protobuf.zg;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.c;
import com.tencent.mm.ui.base.MMPullDownView.e;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.w;
import java.util.ArrayList;
import java.util.List;

public class EmojiStoreV2DesignerUI
  extends MMActivity
  implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener, com.tencent.mm.ai.f, h.a, h.b, MMPullDownView.c, MMPullDownView.e
{
  private View Ww;
  private boolean icT;
  private String lhA;
  private String lhE;
  private long lhz;
  private String liH;
  private int ljW;
  private byte[] ljY;
  protected final int lkc;
  private final int lkd;
  private final int lke;
  private final String lkf;
  private final String lkg;
  private final String lkh;
  private com.tencent.mm.plugin.emoji.model.e lkk;
  private com.tencent.mm.plugin.emoji.model.h lkl;
  private c lkn;
  private com.tencent.mm.plugin.emoji.f.g lko;
  com.tencent.mm.plugin.emoji.a.f lkv;
  private aoc lpA;
  private com.tencent.mm.plugin.emoji.f.i lpB;
  private com.tencent.mm.ui.base.p lpC;
  private ao.b.a lpD;
  private final int lpE;
  private final int lpF;
  private final int lpG;
  private com.tencent.mm.plugin.emoji.f.p lpH;
  private int lpb;
  private String lpc;
  private String lpd;
  private ad lpe;
  private View lpf;
  private BannerEmojiView lpg;
  private TextView lph;
  private TextView lpi;
  private View lpj;
  private View lpk;
  private TextView lpl;
  private ImageView lpm;
  private TextView lpn;
  private TextView lpo;
  View lpp;
  private List<zg> lpq;
  private View lpr;
  PreViewListGridView lps;
  private a lpt;
  View lpu;
  View lpv;
  View lpw;
  TextView lpx;
  View lpy;
  private MMPullDownView lpz;
  private ak mHandler;
  private ListView mListView;
  private int mScene;
  
  public EmojiStoreV2DesignerUI()
  {
    AppMethodBeat.i(53594);
    this.lpq = new ArrayList();
    this.ljW = -1;
    this.lkc = 131074;
    this.lkd = 131075;
    this.lke = 131076;
    this.lkf = "product_id";
    this.lkg = "progress";
    this.lkh = "status";
    this.lkn = new EmojiStoreV2DesignerUI.1(this);
    this.lpD = new EmojiStoreV2DesignerUI.8(this);
    this.lpE = 10001;
    this.lpF = 10002;
    this.lpG = 10003;
    this.mHandler = new EmojiStoreV2DesignerUI.9(this);
    AppMethodBeat.o(53594);
  }
  
  private void Kc()
  {
    AppMethodBeat.i(53600);
    setMMTitle(this.lhE);
    this.lkv = new com.tencent.mm.plugin.emoji.a.f(getContext());
    this.mListView.addHeaderView(this.Ww);
    this.mListView.setAdapter(this.lkv);
    this.lkv.leP = this;
    this.lkv.lek = com.tencent.mm.emoji.a.h.OH();
    this.lkv.lel = false;
    this.lph.setText(this.lhE);
    this.lpA = com.tencent.mm.plugin.emoji.model.i.getEmojiStorageMgr().yNq.asZ(String.valueOf(this.lpb));
    this.lkl = new com.tencent.mm.plugin.emoji.model.h();
    this.lkl.jpJ = this;
    this.lkl.lhv = this.lkv;
    this.lkl.lhy = 6;
    this.lkl.lhB = this;
    this.lkl.lhE = this.lhE;
    this.lkl.lhz = this.lhz;
    this.lkl.lhA = this.lhA;
    if (this.lpA != null)
    {
      c(com.tencent.mm.plugin.emoji.f.p.a(this.lpA));
      bs(this.lpA.wuz);
    }
    updateData();
    aK(this.ljY);
    AppMethodBeat.o(53600);
  }
  
  private void aK(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(53604);
    this.icT = true;
    this.lpH = new com.tencent.mm.plugin.emoji.f.p(this.lpb, paramArrayOfByte);
    com.tencent.mm.kernel.g.RK().eHt.a(this.lpH, 0);
    AppMethodBeat.o(53604);
  }
  
  private void b(int paramInt, com.tencent.mm.plugin.emoji.model.e parame)
  {
    boolean bool = true;
    AppMethodBeat.i(53608);
    switch (paramInt)
    {
    default: 
      bool = false;
    }
    for (;;)
    {
      gN(bool);
      AppMethodBeat.o(53608);
      return;
      this.lkk = parame;
      continue;
      this.lkk = parame;
      continue;
      this.lkk = parame;
      continue;
      if (this.lkk == null) {
        this.lkk = new com.tencent.mm.plugin.emoji.model.e();
      }
      this.lkk.uq(parame.lhk);
      this.lkk.bo(parame.lhl);
    }
  }
  
  private void bni()
  {
    AppMethodBeat.i(53603);
    if ((this.lpe != null) && ((int)this.lpe.euF != 0))
    {
      this.lpk.setVisibility(0);
      this.lpj.setVisibility(0);
      if (!bo.isNullOrNil(this.lpe.Oe())) {
        this.lpl.setText(this.lpe.Oe());
      }
      for (;;)
      {
        a.b.s(this.lpm, this.lpe.field_username);
        this.lpn.setEnabled(true);
        AppMethodBeat.o(53603);
        return;
        this.lpl.setText(this.lpe.field_username);
      }
    }
    this.lpk.setVisibility(8);
    this.lpj.setVisibility(8);
    AppMethodBeat.o(53603);
  }
  
  private void bs(List<zg> paramList)
  {
    int i = 1;
    AppMethodBeat.i(53606);
    String str = com.tencent.mm.m.g.Nq().getValue("ShowDesignerEmoji");
    ab.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "get dynamic Disgner_Emoji_Store_Show config value:%s", new Object[] { str });
    if ((!bo.isNullOrNil(str)) && (bo.apV(str) == 1)) {}
    while ((paramList != null) && (paramList.size() > 0) && (i != 0))
    {
      this.lpp.setVisibility(0);
      if (this.mHandler != null) {
        this.mHandler.post(new EmojiStoreV2DesignerUI.2(this, paramList));
      }
      this.lpt.bt(paramList);
      AppMethodBeat.o(53606);
      return;
      i = 0;
    }
    this.lpp.setVisibility(8);
    AppMethodBeat.o(53606);
  }
  
  private void c(com.tencent.mm.plugin.emoji.model.e parame)
  {
    AppMethodBeat.i(53607);
    b(this.ljW, parame);
    this.ljW = 0;
    AppMethodBeat.o(53607);
  }
  
  private void gN(boolean paramBoolean)
  {
    AppMethodBeat.i(53609);
    if ((this.lkk != null) && (paramBoolean))
    {
      if (this.lkv != null) {
        this.lkv.b(this.lkk);
      }
      if (this.mHandler != null) {
        this.mHandler.sendEmptyMessage(10002);
      }
    }
    AppMethodBeat.o(53609);
  }
  
  private void updateData()
  {
    AppMethodBeat.i(53601);
    if (this.lpA == null)
    {
      ab.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "update data failed. data is null.");
      AppMethodBeat.o(53601);
      return;
    }
    gM(true);
    if (!bo.isNullOrNil(this.lpA.wuS))
    {
      ab.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "biz name is :%s", new Object[] { this.lpA.wuS });
      this.lpe = ((j)com.tencent.mm.kernel.g.E(j.class)).YA().arw(this.lpA.wuS);
      if (((this.lpe == null) || ((int)this.lpe.euF == 0)) && (ao.a.flI != null))
      {
        ab.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "getContact %s", new Object[] { this.lpA.wuS });
        ao.a.flI.a(this.lpA.wuS, "", this.lpD);
      }
      this.lpn.setText(2131299264);
      if (bo.isNullOrNil(this.lpA.Desc)) {
        break label296;
      }
      this.lpi.setText(this.lpA.Desc);
      this.lpi.setVisibility(0);
    }
    for (;;)
    {
      bni();
      if ((this.lkk != null) && (this.lkk.lhl != null) && (!this.lkk.lhl.isEmpty())) {
        break label308;
      }
      this.lpo.setVisibility(8);
      AppMethodBeat.o(53601);
      return;
      ab.w("MicroMsg.emoji.EmojiStoreV2DesignerUI", "mData.BizName is null");
      this.lpj.setVisibility(8);
      this.lpk.setVisibility(8);
      break;
      label296:
      this.lpi.setVisibility(8);
    }
    label308:
    this.lpo.setVisibility(0);
    AppMethodBeat.o(53601);
  }
  
  protected final com.tencent.mm.plugin.emoji.f.g N(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(53614);
    this.lko = new com.tencent.mm.plugin.emoji.f.g(paramString1, paramString2, paramString3);
    paramString1 = this.lko;
    AppMethodBeat.o(53614);
    return paramString1;
  }
  
  public final void a(com.tencent.mm.plugin.emoji.a.a parama)
  {
    AppMethodBeat.i(53612);
    String str2 = parama.getProductId();
    if (TextUtils.isEmpty(parama.bku())) {}
    for (String str1 = "";; str1 = parama.bku())
    {
      ab.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "[onProductClick] productId:%s, productPrice:%s, productStatus:%d", new Object[] { str2, str1, Integer.valueOf(parama.bkt()) });
      parama.bkt();
      this.lkl.a(parama);
      AppMethodBeat.o(53612);
      return;
    }
  }
  
  final void bX(String paramString, int paramInt)
  {
    AppMethodBeat.i(53617);
    Message localMessage = Message.obtain();
    localMessage.getData().putString("product_id", paramString);
    localMessage.getData().putInt("status", paramInt);
    localMessage.what = 131076;
    if (this.mHandler != null) {
      this.mHandler.sendMessage(localMessage);
    }
    AppMethodBeat.o(53617);
  }
  
  final void bY(String paramString, int paramInt)
  {
    AppMethodBeat.i(53616);
    Message localMessage = Message.obtain();
    localMessage.getData().putString("product_id", paramString);
    localMessage.getData().putInt("progress", paramInt);
    localMessage.what = 131075;
    if (this.mHandler != null) {
      this.mHandler.sendMessage(localMessage);
    }
    AppMethodBeat.o(53616);
  }
  
  public final boolean bik()
  {
    return true;
  }
  
  public final boolean bim()
  {
    return false;
  }
  
  public final void blm() {}
  
  protected final void bmf()
  {
    AppMethodBeat.i(53615);
    com.tencent.mm.kernel.g.RK().eHt.a(this.lko, 0);
    AppMethodBeat.o(53615);
  }
  
  protected final void gM(boolean paramBoolean)
  {
    AppMethodBeat.i(53602);
    if (this.lpA == null)
    {
      ab.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "update header failed. data is null.");
      AppMethodBeat.o(53602);
      return;
    }
    if ((this.lpg != null) && (!bo.isNullOrNil(this.lpA.xeb)))
    {
      Object localObject = this.lpA.xeb;
      com.tencent.mm.cb.a.getDensity(this);
      localObject = EmojiLogic.s("Designer", 8, (String)localObject);
      if (localObject == null)
      {
        if (paramBoolean)
        {
          o.ahG().a(this.lpA.xeb, null, com.tencent.mm.plugin.emoji.e.g.h("Designer", this.lpA.xeb, new Object[] { "Designer", "BANNER" }), new com.tencent.mm.at.a.c.i()
          {
            public final void a(String paramAnonymousString, View paramAnonymousView, Bitmap paramAnonymousBitmap, Object... paramAnonymousVarArgs)
            {
              AppMethodBeat.i(53593);
              if (EmojiStoreV2DesignerUI.k(EmojiStoreV2DesignerUI.this) != null) {
                EmojiStoreV2DesignerUI.k(EmojiStoreV2DesignerUI.this).sendEmptyMessage(10001);
              }
              AppMethodBeat.o(53593);
            }
          });
          AppMethodBeat.o(53602);
          return;
        }
        ab.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "updateDesignerHeader failed");
        AppMethodBeat.o(53602);
        return;
      }
      this.lpg.setImageFilePath(((EmojiInfo)localObject).dQB());
    }
    AppMethodBeat.o(53602);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2130969395;
  }
  
  public final void i(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(53613);
    N(paramString1, paramString2, paramString3);
    bmf();
    AppMethodBeat.o(53613);
  }
  
  public void initView()
  {
    AppMethodBeat.i(53599);
    if (!bo.isNullOrNil(this.lhE)) {
      setMMTitle(this.lhE);
    }
    this.Ww = w.hM(getContext()).inflate(2130969391, null);
    this.lpf = this.Ww.findViewById(2131823658);
    this.lpg = ((BannerEmojiView)this.lpf.findViewById(2131823664));
    this.lph = ((TextView)this.Ww.findViewById(2131823659));
    this.lpi = ((TextView)this.Ww.findViewById(2131823660));
    this.lpj = this.Ww.findViewById(2131823661);
    this.lpk = this.Ww.findViewById(2131823653);
    this.lpl = ((TextView)this.Ww.findViewById(2131823655));
    this.lpm = ((ImageView)this.Ww.findViewById(2131823654));
    this.lpn = ((TextView)this.Ww.findViewById(2131823656));
    this.lpo = ((TextView)this.Ww.findViewById(2131823663));
    this.lpp = this.Ww.findViewById(2131823666);
    this.lpr = this.Ww.findViewById(2131823671);
    this.lpr.setOnClickListener(new EmojiStoreV2DesignerUI.10(this));
    this.lps = ((PreViewListGridView)this.Ww.findViewById(2131823669));
    this.lpt = new a(getContext());
    this.lpt.lsl = new EmojiStoreV2DesignerUI.11(this);
    this.lps.setAdapter(this.lpt);
    this.lpu = this.Ww.findViewById(2131823667);
    this.lpv = this.Ww.findViewById(2131823668);
    this.lpw = this.Ww.findViewById(2131823671);
    this.lpx = ((TextView)this.Ww.findViewById(2131823672));
    this.lpy = this.Ww.findViewById(2131823670);
    this.lpz = ((MMPullDownView)findViewById(2131823652));
    this.lpz.setOnBottomLoadDataListener(this);
    this.lpz.setAtBottomCallBack(this);
    this.lpz.setBottomViewVisible(false);
    this.lpz.setIsBottomShowAll(false);
    this.mListView = ((ListView)findViewById(16908298));
    this.mListView.setOnItemClickListener(this);
    this.mListView.setOnScrollListener(this);
    this.lpk.setOnClickListener(new EmojiStoreV2DesignerUI.12(this));
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(53591);
        EmojiStoreV2DesignerUI.this.finish();
        AppMethodBeat.o(53591);
        return false;
      }
    });
    addIconOptionMenu(0, 2131231823, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(53592);
        ab.d("MicroMsg.emoji.EmojiStoreV2DesignerUI", "on shard click.");
        EmojiStoreV2DesignerUI.j(EmojiStoreV2DesignerUI.this);
        AppMethodBeat.o(53592);
        return true;
      }
    });
    AppMethodBeat.o(53599);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(53618);
    this.lkl.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 2002) {
      if (paramInt2 == -1)
      {
        String str1 = paramIntent.getStringExtra("Select_Conv_User");
        if ((bo.isNullOrNil(str1)) || (this.lpA == null)) {
          break label224;
        }
        ab.d("MicroMsg.emoji.EmojiStoreV2DesignerUI", "..".concat(String.valueOf(str1)));
        String str2 = this.lhE;
        String str3 = this.lpA.Desc;
        int i = this.lpb;
        String str4 = this.lpd;
        String str5 = this.lhE;
        String str6 = this.lpA.HeadUrl;
        String str7 = getResources().getString(2131296903);
        str7 = str7 + str2;
        String str8 = getString(2131297067);
        String str9 = getString(2131298500);
        ((com.tencent.mm.pluginsdk.i)com.tencent.mm.kernel.g.E(com.tencent.mm.pluginsdk.i.class)).a(this, str1, str7, str8, str9, str6, new l.2(str1, str5, str3, i, str4, str2, str6, this));
      }
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(53618);
      return;
      label224:
      ab.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "member or data is null.");
      continue;
      if ((paramInt1 == 2004) && (paramInt2 == -1)) {
        com.tencent.mm.ui.widget.snackbar.b.l(this, getContext().getString(2131297070));
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(53595);
    super.onCreate(paramBundle);
    this.liH = getIntent().getStringExtra("id");
    this.lpb = getIntent().getIntExtra("uin", 0);
    this.lhE = getIntent().getStringExtra("name");
    this.lpc = getIntent().getStringExtra("headurl");
    this.lpd = getIntent().getStringExtra("rediret_url");
    this.mScene = getIntent().getIntExtra("extra_scence", 0);
    this.lhz = getIntent().getLongExtra("searchID", 0L);
    this.lhA = bo.bf(getIntent().getStringExtra("docID"), "");
    paramBundle = getIntent().getStringExtra("sns_object_data");
    if (!TextUtils.isEmpty(paramBundle))
    {
      this.lpb = EmojiLogic.KC(paramBundle);
      this.lhE = EmojiLogic.KD(paramBundle);
      this.lpd = EmojiLogic.KK(paramBundle);
    }
    initView();
    int i;
    if (!bo.isNullOrNil(this.liH))
    {
      paramBundle = com.tencent.mm.plugin.emoji.model.i.getEmojiStorageMgr().yNt.asU(this.liH);
      if ((paramBundle != null) && (paramBundle.xbf != null) && (paramBundle.xbf.DesignerUin != 0) && (!bo.isNullOrNil(paramBundle.xbf.Name)))
      {
        this.lpb = paramBundle.xbf.DesignerUin;
        this.lhE = paramBundle.xbf.Name;
        ab.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "uin:%s name:%s", new Object[] { Integer.valueOf(this.lpb), this.lhE });
      }
    }
    else
    {
      i = 0;
      if (i != 0) {
        break label452;
      }
      Kc();
    }
    for (;;)
    {
      com.tencent.mm.kernel.g.RK().eHt.a(239, this);
      com.tencent.mm.kernel.g.RK().eHt.a(720, this);
      com.tencent.mm.sdk.b.a.ymk.c(this.lkn);
      com.tencent.mm.plugin.report.service.h.qsU.e(12067, new Object[] { Integer.valueOf(1), "", "", "", "" });
      com.tencent.mm.plugin.report.service.h.qsU.e(12740, new Object[] { Integer.valueOf(2), com.tencent.mm.a.p.getString(this.lpb), "", "", Integer.valueOf(this.mScene), Integer.valueOf(6) });
      AppMethodBeat.o(53595);
      return;
      i = 1;
      break;
      label452:
      this.lpB = new com.tencent.mm.plugin.emoji.f.i(this.liH);
      com.tencent.mm.kernel.g.RK().eHt.a(this.lpB, 0);
      getString(2131297087);
      this.lpC = com.tencent.mm.ui.base.h.b(this, getString(2131297112), true, new EmojiStoreV2DesignerUI.7(this));
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(53598);
    super.onDestroy();
    if (this.lpH != null) {
      com.tencent.mm.kernel.g.RK().eHt.a(this.lpH);
    }
    com.tencent.mm.kernel.g.RK().eHt.b(239, this);
    com.tencent.mm.kernel.g.RK().eHt.b(720, this);
    com.tencent.mm.sdk.b.a.ymk.d(this.lkn);
    if (this.mHandler != null)
    {
      this.mHandler.removeMessages(10002);
      this.mHandler.removeMessages(10001);
      this.mHandler = null;
    }
    AppMethodBeat.o(53598);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(53611);
    Object localObject;
    if (this.lkv != null)
    {
      int i = this.mListView.getHeaderViewsCount();
      paramAdapterView = this.lkv.uj(paramInt - i);
      if (paramAdapterView != null)
      {
        paramView = new Intent();
        paramView.setClass(this, EmojiStoreDetailUI.class);
        localObject = paramAdapterView.lfa;
        if (localObject != null) {
          break label84;
        }
        paramAdapterView = null;
      }
    }
    for (;;)
    {
      if (paramAdapterView != null) {
        startActivity(paramAdapterView);
      }
      AppMethodBeat.o(53611);
      return;
      label84:
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
      paramView.putExtra("extra_progress", paramAdapterView.ym);
      paramView.putExtra("searchID", this.lhz);
      localObject = getIntent().getStringExtra("to_talker_name");
      paramAdapterView = paramView;
      if (!bo.isNullOrNil((String)localObject))
      {
        paramView.putExtra("to_talker_name", (String)localObject);
        paramAdapterView = paramView;
      }
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(53597);
    super.onPause();
    com.tencent.mm.kernel.g.RK().eHt.b(423, this);
    AppMethodBeat.o(53597);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(53596);
    super.onResume();
    com.tencent.mm.kernel.g.RK().eHt.a(423, this);
    AppMethodBeat.o(53596);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(53605);
    switch (paramm.getType())
    {
    default: 
      ab.e("MicroMsg.emoji.EmojiStoreV2DesignerUI", "unknow scene type");
    case 423: 
      do
      {
        AppMethodBeat.o(53605);
        return;
      } while (!(paramm instanceof com.tencent.mm.plugin.emoji.f.g));
      paramString = (com.tencent.mm.plugin.emoji.f.g)paramm;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        bY(paramString.liu, 0);
        AppMethodBeat.o(53605);
        return;
      }
      paramm = paramString.liu;
      String str1 = paramString.liw;
      String str2 = paramString.liv;
      com.tencent.mm.ui.base.h.a(this, getString(2131299194, new Object[] { str2 }), "", new EmojiStoreV2DesignerUI.3(this, paramm, str1, str2), new EmojiStoreV2DesignerUI.4(this));
      bX(paramString.liu, -1);
      AppMethodBeat.o(53605);
      return;
    case 720: 
      this.icT = false;
      if ((paramInt1 == 0) || (paramInt1 == 4))
      {
        paramString = (com.tencent.mm.plugin.emoji.f.p)paramm;
        paramm = com.tencent.mm.plugin.emoji.f.p.a(paramString.blK());
        if (paramInt2 == 0)
        {
          this.lpA = paramString.blK();
          c(paramm);
        }
        for (;;)
        {
          if ((this.ljY == null) && (this.lpA != null))
          {
            com.tencent.mm.plugin.emoji.model.i.getEmojiStorageMgr().yNq.a(String.valueOf(this.lpb), paramString.blK());
            this.lpq = this.lpA.wuz;
            bs(this.lpq);
          }
          this.ljY = paramString.liN;
          AppMethodBeat.o(53605);
          return;
          if (paramInt2 == 2)
          {
            this.lpA = paramString.blK();
            b(this.ljW, paramm);
            this.ljW = 2;
          }
          else if (paramInt2 == 3)
          {
            this.lpA = paramString.blK();
            b(this.ljW, paramm);
            this.ljW = 1;
            ab.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "get person designer failed errCode:%d", new Object[] { Integer.valueOf(paramInt2) });
          }
        }
      }
      ab.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "get person designer failed");
      AppMethodBeat.o(53605);
      return;
    }
    if ((this.lpC != null) && (this.lpC.isShowing())) {
      this.lpC.dismiss();
    }
    if ((paramInt2 == 0) && (paramInt1 == 0))
    {
      paramString = ((com.tencent.mm.plugin.emoji.f.i)paramm).blD();
      if ((paramString != null) && (paramString.xbf != null))
      {
        this.lpb = paramString.xbf.DesignerUin;
        this.lhE = paramString.xbf.Name;
        this.lpc = paramString.xbf.HeadUrl;
        if (this.mHandler != null) {
          this.mHandler.sendEmptyMessage(10003);
        }
      }
      AppMethodBeat.o(53605);
      return;
    }
    showOptionMenu(0, false);
    com.tencent.mm.ui.base.h.b(getContext(), getString(2131299137), null, true);
    ab.e("MicroMsg.emoji.EmojiStoreV2DesignerUI", "open designer failed .");
    AppMethodBeat.o(53605);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(53610);
    if ((paramInt == 0) && (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1))
    {
      if ((this.ljW == 0) || (this.icT))
      {
        ab.d("MicroMsg.emoji.EmojiStoreV2DesignerUI", "No More List.");
        AppMethodBeat.o(53610);
        return;
      }
      aK(this.ljY);
      ab.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "[onScrollStateChanged] startLoadRemoteEmoji.");
    }
    AppMethodBeat.o(53610);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI
 * JD-Core Version:    0.7.0.1
 */