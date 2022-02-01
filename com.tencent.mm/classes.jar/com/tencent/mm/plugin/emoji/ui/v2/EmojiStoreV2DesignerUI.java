package com.tencent.mm.plugin.emoji.ui.v2;

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
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.ee;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.mmdata.rpt.bt;
import com.tencent.mm.emoji.c.o;
import com.tencent.mm.k.i;
import com.tencent.mm.kernel.c;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.az.b.a;
import com.tencent.mm.plugin.emoji.h.a;
import com.tencent.mm.plugin.emoji.h.e;
import com.tencent.mm.plugin.emoji.h.f;
import com.tencent.mm.plugin.emoji.h.g;
import com.tencent.mm.plugin.emoji.h.h;
import com.tencent.mm.plugin.emoji.mgr.e;
import com.tencent.mm.plugin.emoji.mgr.j.2;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.m;
import com.tencent.mm.plugin.emoji.model.r.a;
import com.tencent.mm.plugin.emoji.model.r.b;
import com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.emoji.BannerEmojiView;
import com.tencent.mm.protocal.protobuf.ajy;
import com.tencent.mm.protocal.protobuf.amn;
import com.tencent.mm.protocal.protobuf.cik;
import com.tencent.mm.protocal.protobuf.cjb;
import com.tencent.mm.protocal.protobuf.cps;
import com.tencent.mm.protocal.protobuf.gok;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bi.a;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.c;
import com.tencent.mm.ui.base.MMPullDownView.e;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.base.w;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class EmojiStoreV2DesignerUI
  extends MMActivity
  implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener, com.tencent.mm.am.h, r.a, r.b, MMPullDownView.c, MMPullDownView.e
{
  private MMHandler mHandler;
  private ListView mListView;
  private int mScene;
  private View nJ;
  private boolean szX;
  private long xNo;
  private String xNp;
  private String xNt;
  private String xOA;
  private int xPP;
  private byte[] xPR;
  protected final int xPV;
  private final int xPW;
  private final int xPX;
  private final String xPY;
  private final String xPZ;
  private final String xQa;
  private m xQd;
  private com.tencent.mm.plugin.emoji.model.r xQe;
  private IListener xQg;
  private com.tencent.mm.plugin.emoji.e.h xQj;
  com.tencent.mm.plugin.emoji.a.f xQr;
  private int xVO;
  private String xVP;
  private String xVQ;
  private List<String> xVR;
  private au xVS;
  private View xVT;
  private BannerEmojiView xVU;
  private TextView xVV;
  private TextView xVW;
  private View xVX;
  private TextView xVY;
  private View xVZ;
  private View xWa;
  private TextView xWb;
  private ImageView xWc;
  private TextView xWd;
  private TextView xWe;
  View xWf;
  private List<amn> xWg;
  private View xWh;
  PreViewListGridView xWi;
  private a xWj;
  View xWk;
  View xWl;
  View xWm;
  TextView xWn;
  View xWo;
  private MMPullDownView xWp;
  private cps xWq;
  private com.tencent.mm.plugin.emoji.e.j xWr;
  private w xWs;
  private az.b.a xWt;
  private final int xWu;
  private final int xWv;
  private final int xWw;
  private com.tencent.mm.plugin.emoji.e.r xWx;
  
  public EmojiStoreV2DesignerUI()
  {
    AppMethodBeat.i(109157);
    this.xWg = new ArrayList();
    this.xPP = -1;
    this.xPV = 131074;
    this.xPW = 131075;
    this.xPX = 131076;
    this.xPY = "product_id";
    this.xPZ = "progress";
    this.xQa = "status";
    this.xQg = new IListener(com.tencent.mm.app.f.hfK) {};
    this.xWt = new EmojiStoreV2DesignerUI.9(this);
    this.xWu = 10001;
    this.xWv = 10002;
    this.xWw = 10003;
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
          EmojiStoreV2DesignerUI.this.og(false);
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
          EmojiStoreV2DesignerUI.d(EmojiStoreV2DesignerUI.this).dY(str, i);
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
          EmojiStoreV2DesignerUI.d(EmojiStoreV2DesignerUI.this).dX(str, i);
        }
      }
    };
    AppMethodBeat.o(109157);
  }
  
  private void aNi()
  {
    AppMethodBeat.i(109163);
    setMMTitle(this.xNt);
    this.xQr = new com.tencent.mm.plugin.emoji.a.f(getContext());
    this.xQr.fa(this.xVR);
    this.mListView.addHeaderView(this.nJ);
    this.mListView.setAdapter(this.xQr);
    this.xQr.xHs = this;
    this.xQr.xGM = o.aUN();
    this.xQr.xGN = false;
    this.xVV.setText(this.xNt);
    this.xWq = com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adjx.bzm(String.valueOf(this.xVO));
    this.xQe = new com.tencent.mm.plugin.emoji.model.r();
    this.xQe.xNl = this;
    this.xQe.xNj = this.xQr;
    this.xQe.xNn = 6;
    this.xQe.xNq = this;
    this.xQe.xNt = this.xNt;
    this.xQe.xNo = this.xNo;
    this.xQe.xNp = this.xNp;
    if (this.xWq != null)
    {
      c(com.tencent.mm.plugin.emoji.e.r.a(this.xWq));
      fg(this.xWq.YMz);
    }
    dCn();
    bF(this.xPR);
    AppMethodBeat.o(109163);
  }
  
  private void b(int paramInt, m paramm)
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
      oh(bool);
      AppMethodBeat.o(109171);
      return;
      this.xQd = paramm;
      continue;
      this.xQd = paramm;
      continue;
      this.xQd = paramm;
      continue;
      if (this.xQd == null) {
        this.xQd = new m();
      }
      this.xQd.Kq(paramm.xMT);
      this.xQd.fb(paramm.xMU);
    }
  }
  
  private void bF(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(109167);
    this.szX = true;
    this.xWx = new com.tencent.mm.plugin.emoji.e.r(this.xVO, paramArrayOfByte);
    com.tencent.mm.kernel.h.baD().mCm.a(this.xWx, 0);
    AppMethodBeat.o(109167);
  }
  
  private void c(m paramm)
  {
    AppMethodBeat.i(109170);
    b(this.xPP, paramm);
    this.xPP = 0;
    AppMethodBeat.o(109170);
  }
  
  private void dCn()
  {
    AppMethodBeat.i(109164);
    if (this.xWq == null)
    {
      Log.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "update data failed. data is null.");
      AppMethodBeat.o(109164);
      return;
    }
    og(true);
    if (!Util.isNullOrNil(this.xWq.YNd))
    {
      Log.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "biz name is :%s", new Object[] { this.xWq.YNd });
      this.xVS = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(this.xWq.YNd);
      if (((this.xVS == null) || ((int)this.xVS.maN == 0)) && (az.a.okP != null))
      {
        Log.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "getContact %s", new Object[] { this.xWq.YNd });
        az.a.okP.a(this.xWq.YNd, "", this.xWt);
      }
      this.xWd.setText(h.h.emoji_store_weixin);
      if (Util.isNullOrNil(this.xWq.IGG)) {
        break label354;
      }
      this.xVW.setText(this.xWq.IGG);
      this.xVW.setVisibility(0);
      label211:
      if ((this.xWq.aawm == null) || (this.xWq.aawm.Zrd == null)) {
        break label366;
      }
      this.xVX.setVisibility(0);
      this.xVY.setText(getString(h.h.emoji_designer_detail_finder_name_prefix, new Object[] { this.xWq.aawm.Zrc }));
    }
    for (;;)
    {
      dCo();
      if ((this.xQd != null) && (this.xQd.xMU != null) && (!this.xQd.xMU.isEmpty())) {
        break label378;
      }
      this.xWe.setVisibility(8);
      AppMethodBeat.o(109164);
      return;
      Log.w("MicroMsg.emoji.EmojiStoreV2DesignerUI", "mData.BizName is null");
      this.xVZ.setVisibility(8);
      this.xWa.setVisibility(8);
      break;
      label354:
      this.xVW.setVisibility(8);
      break label211;
      label366:
      this.xVX.setVisibility(8);
    }
    label378:
    this.xWe.setVisibility(0);
    AppMethodBeat.o(109164);
  }
  
  private void dCo()
  {
    AppMethodBeat.i(109166);
    if ((this.xVS != null) && ((int)this.xVS.maN != 0))
    {
      this.xWa.setVisibility(0);
      this.xVZ.setVisibility(0);
      if (!Util.isNullOrNil(this.xVS.aSU())) {
        this.xWb.setText(this.xVS.aSU());
      }
      for (;;)
      {
        a.b.h(this.xWc, this.xVS.field_username);
        this.xWd.setEnabled(true);
        AppMethodBeat.o(109166);
        return;
        this.xWb.setText(this.xVS.field_username);
      }
    }
    this.xWa.setVisibility(8);
    this.xVZ.setVisibility(8);
    AppMethodBeat.o(109166);
  }
  
  private void fg(final List<amn> paramList)
  {
    int i = 1;
    AppMethodBeat.i(109169);
    String str = i.aRC().getValue("ShowDesignerEmoji");
    Log.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "get dynamic Disgner_Emoji_Store_Show config value:%s", new Object[] { str });
    if ((!Util.isNullOrNil(str)) && (Util.safeParseInt(str) == 1)) {}
    while ((paramList != null) && (paramList.size() > 0) && (i != 0))
    {
      this.xWf.setVisibility(0);
      if (this.mHandler != null) {
        this.mHandler.post(new Runnable()
        {
          public final void run()
          {
            int k = 8;
            AppMethodBeat.i(270800);
            EmojiStoreV2DesignerUI localEmojiStoreV2DesignerUI = EmojiStoreV2DesignerUI.this;
            int i;
            View localView;
            if (paramList.size() > 3)
            {
              i = 1;
              if (localEmojiStoreV2DesignerUI.xWi != null) {
                localEmojiStoreV2DesignerUI.xWi.setVisibility(0);
              }
              if (localEmojiStoreV2DesignerUI.xWl != null) {
                localEmojiStoreV2DesignerUI.xWl.setVisibility(0);
              }
              if (localEmojiStoreV2DesignerUI.xWk != null) {
                localEmojiStoreV2DesignerUI.xWk.setVisibility(0);
              }
              if (localEmojiStoreV2DesignerUI.xWm != null)
              {
                localView = localEmojiStoreV2DesignerUI.xWm;
                if (i == 0) {
                  break label186;
                }
              }
            }
            label186:
            for (int j = 0;; j = 8)
            {
              localView.setVisibility(j);
              if (localEmojiStoreV2DesignerUI.xWn != null) {
                localEmojiStoreV2DesignerUI.xWn.setText(h.h.emoji_store_product_more_title);
              }
              if (localEmojiStoreV2DesignerUI.xWo != null)
              {
                localView = localEmojiStoreV2DesignerUI.xWo;
                j = k;
                if (i != 0) {
                  j = 0;
                }
                localView.setVisibility(j);
              }
              if (localEmojiStoreV2DesignerUI.xWf != null) {
                localEmojiStoreV2DesignerUI.xWf.setPadding(0, 0, 0, 0);
              }
              AppMethodBeat.o(270800);
              return;
              i = 0;
              break;
            }
          }
        });
      }
      this.xWj.bz(paramList);
      AppMethodBeat.o(109169);
      return;
      i = 0;
    }
    this.xWf.setVisibility(8);
    AppMethodBeat.o(109169);
  }
  
  private void oh(boolean paramBoolean)
  {
    AppMethodBeat.i(109172);
    if ((this.xQd != null) && (paramBoolean))
    {
      if (this.xQr != null) {
        this.xQr.b(this.xQd);
      }
      if (this.mHandler != null) {
        this.mHandler.sendEmptyMessage(10002);
      }
    }
    AppMethodBeat.o(109172);
  }
  
  protected final com.tencent.mm.plugin.emoji.e.h X(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(270816);
    this.xQj = new com.tencent.mm.plugin.emoji.e.h(paramString1, paramString2, paramString3);
    paramString1 = this.xQj;
    AppMethodBeat.o(270816);
    return paramString1;
  }
  
  public final void a(com.tencent.mm.plugin.emoji.a.a parama)
  {
    AppMethodBeat.i(109175);
    String str = parama.getProductId();
    if (TextUtils.isEmpty(parama.dya())) {}
    for (Object localObject = "";; localObject = parama.dya())
    {
      Log.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "[onProductClick] productId:%s, productPrice:%s, productStatus:%d", new Object[] { str, localObject, Integer.valueOf(parama.dxZ()) });
      parama.dxZ();
      localObject = com.tencent.mm.emoji.d.d.mmr;
      com.tencent.mm.emoji.d.d.aWc().lc(parama.getProductId());
      localObject = com.tencent.mm.emoji.d.d.mmr;
      com.tencent.mm.emoji.d.d.rG(3);
      localObject = com.tencent.mm.emoji.d.d.mmr;
      com.tencent.mm.emoji.d.d.aWc().lc("");
      this.xQe.a(parama);
      AppMethodBeat.o(109175);
      return;
    }
  }
  
  public final void d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(270815);
    X(paramString1, paramString2, paramString3);
    dBe();
    AppMethodBeat.o(270815);
  }
  
  public final void dAg() {}
  
  protected final void dBe()
  {
    AppMethodBeat.i(109178);
    com.tencent.mm.kernel.h.baD().mCm.a(this.xQj, 0);
    AppMethodBeat.o(109178);
  }
  
  final void dX(String paramString, int paramInt)
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
  
  final void dY(String paramString, int paramInt)
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
  
  public final boolean dso()
  {
    return true;
  }
  
  public final boolean dsq()
  {
    return false;
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return h.f.emoji_store_v2_designer_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(109162);
    if (!Util.isNullOrNil(this.xNt)) {
      setMMTitle(this.xNt);
    }
    this.nJ = af.mU(getContext()).inflate(h.f.emoji_store_v2_designer_header, null);
    this.xVT = this.nJ.findViewById(h.e.designer_header);
    this.xVU = ((BannerEmojiView)this.xVT.findViewById(h.e.emoji_bar_view));
    this.xVV = ((TextView)this.nJ.findViewById(h.e.designer_name));
    this.xVW = ((TextView)this.nJ.findViewById(h.e.designer_desc));
    this.xVX = this.nJ.findViewById(h.e.emoji_designer_detail_finder_info);
    this.xVY = ((TextView)this.nJ.findViewById(h.e.emoji_designer_detail_finder_name));
    this.xVY.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(109151);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2DesignerUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        EmojiStoreV2DesignerUI.a(EmojiStoreV2DesignerUI.this, EmojiStoreV2DesignerUI.e(EmojiStoreV2DesignerUI.this).aawm.Zrd);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2DesignerUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(109151);
      }
    });
    this.xVZ = this.nJ.findViewById(h.e.designer_bar_line);
    this.xWa = this.nJ.findViewById(h.e.designer_bar_container);
    this.xWb = ((TextView)this.nJ.findViewById(h.e.designer_title));
    this.xWc = ((ImageView)this.nJ.findViewById(h.e.designer_icon));
    this.xWd = ((TextView)this.nJ.findViewById(h.e.designer_detail));
    this.xWe = ((TextView)this.nJ.findViewById(h.e.designer_works));
    this.xWf = this.nJ.findViewById(h.e.designer_product);
    this.xWh = this.nJ.findViewById(h.e.designer_product_more);
    this.xWh.setOnClickListener(new EmojiStoreV2DesignerUI.12(this));
    this.xWi = ((PreViewListGridView)this.nJ.findViewById(h.e.designer_product_list));
    this.xWj = new a(getContext());
    this.xWj.xZf = new a.a()
    {
      public final void Kf(int paramAnonymousInt)
      {
        AppMethodBeat.i(270771);
        if ((EmojiStoreV2DesignerUI.g(EmojiStoreV2DesignerUI.this) != null) && (EmojiStoreV2DesignerUI.h(EmojiStoreV2DesignerUI.this) != null))
        {
          amn localamn = EmojiStoreV2DesignerUI.h(EmojiStoreV2DesignerUI.this).Ky(paramAnonymousInt);
          if (localamn != null)
          {
            com.tencent.mm.plugin.report.service.h.OAn.b(12787, new Object[] { Integer.valueOf(1), Integer.valueOf(0), localamn.Md5, Long.valueOf(EmojiStoreV2DesignerUI.i(EmojiStoreV2DesignerUI.this)), localamn.DesignerID, localamn.ProductID, Integer.valueOf(6) });
            try
            {
              Intent localIntent = new Intent();
              localIntent.putExtra("extra_object", localamn.toByteArray());
              localIntent.putExtra("add_source", 5);
              localIntent.putExtra("entrance_scene", 6);
              localIntent.setClass(EmojiStoreV2DesignerUI.this.getContext(), EmojiStoreV2SingleProductDialogUI.class);
              EmojiStoreV2DesignerUI.this.startActivityForResult(localIntent, 2004);
              EmojiStoreV2DesignerUI.this.overridePendingTransition(h.a.pop_in, h.a.pop_out);
              AppMethodBeat.o(270771);
              return;
            }
            catch (Exception localException) {}
          }
        }
        AppMethodBeat.o(270771);
      }
    };
    this.xWi.setAdapter(this.xWj);
    this.xWk = this.nJ.findViewById(h.e.designer_product_title);
    this.xWl = this.nJ.findViewById(h.e.designer_product_title_tv);
    this.xWm = this.nJ.findViewById(h.e.designer_product_more);
    this.xWn = ((TextView)this.nJ.findViewById(h.e.designer_single_product));
    this.xWo = this.nJ.findViewById(h.e.designer_product_divider);
    this.xWp = ((MMPullDownView)findViewById(h.e.load_more_pull_view));
    this.xWp.setOnBottomLoadDataListener(this);
    this.xWp.setAtBottomCallBack(this);
    this.xWp.setBottomViewVisible(false);
    this.xWp.setIsBottomShowAll(false);
    this.mListView = ((ListView)findViewById(16908298));
    this.mListView.setOnItemClickListener(this);
    this.mListView.setOnScrollListener(this);
    this.xWa.setOnClickListener(new EmojiStoreV2DesignerUI.14(this));
    setBackBtn(new EmojiStoreV2DesignerUI.15(this));
    addIconOptionMenu(0, h.g.icons_outlined_share, new EmojiStoreV2DesignerUI.16(this));
    AppMethodBeat.o(109162);
  }
  
  protected final void og(boolean paramBoolean)
  {
    AppMethodBeat.i(109165);
    if (this.xWq == null)
    {
      Log.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "update header failed. data is null.");
      AppMethodBeat.o(109165);
      return;
    }
    if ((this.xVU != null) && (!Util.isNullOrNil(this.xWq.aawl)))
    {
      Object localObject = this.xWq.aawl;
      com.tencent.mm.cd.a.getDensity(this);
      localObject = EmojiLogic.K("Designer", 8, (String)localObject);
      if (localObject == null)
      {
        if (paramBoolean)
        {
          com.tencent.mm.modelimage.r.bKe().a(this.xWq.aawl, null, e.l("Designer", this.xWq.aawl, new Object[] { "Designer", "BANNER" }), new com.tencent.mm.modelimage.loader.b.k()
          {
            public final void onImageLoadComplete(String paramAnonymousString, View paramAnonymousView, Bitmap paramAnonymousBitmap, Object... paramAnonymousVarArgs)
            {
              AppMethodBeat.i(270798);
              if (EmojiStoreV2DesignerUI.l(EmojiStoreV2DesignerUI.this) != null) {
                EmojiStoreV2DesignerUI.l(EmojiStoreV2DesignerUI.this).sendEmptyMessage(10001);
              }
              AppMethodBeat.o(270798);
            }
          });
          AppMethodBeat.o(109165);
          return;
        }
        Log.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "updateDesignerHeader failed");
        AppMethodBeat.o(109165);
        return;
      }
      this.xVU.setImageFilePath(((EmojiInfo)localObject).kMn());
    }
    AppMethodBeat.o(109165);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(109181);
    this.xQe.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 2002) {
      if (paramInt2 == -1)
      {
        String str1 = paramIntent.getStringExtra("Select_Conv_User");
        if ((Util.isNullOrNil(str1)) || (this.xWq == null)) {
          break label223;
        }
        Log.d("MicroMsg.emoji.EmojiStoreV2DesignerUI", "..".concat(String.valueOf(str1)));
        String str2 = this.xNt;
        String str3 = this.xWq.IGG;
        int i = this.xVO;
        String str4 = this.xVQ;
        String str5 = this.xNt;
        String str6 = this.xWq.ZuK;
        String str7 = getResources().getString(h.h.app_designer_share);
        str7 = str7 + str2;
        String str8 = getString(h.h.app_send);
        String str9 = getString(h.h.confirm_dialog_edittext_hint);
        ((com.tencent.mm.pluginsdk.j)com.tencent.mm.kernel.h.ax(com.tencent.mm.pluginsdk.j.class)).a(this, str1, str7, str8, str9, str6, new j.2(str1, str5, str3, i, str4, str2, str6, this));
      }
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(109181);
      return;
      label223:
      Log.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "member or data is null.");
      continue;
      if ((paramInt1 == 2004) && (paramInt2 == -1)) {
        com.tencent.mm.ui.widget.snackbar.b.u(this, getContext().getString(h.h.app_sent));
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(109158);
    super.onCreate(paramBundle);
    if (((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu())
    {
      Log.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "exit in teen mode");
      ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).kg(this);
      finish();
      AppMethodBeat.o(109158);
      return;
    }
    this.xOA = getIntent().getStringExtra("id");
    this.xVO = getIntent().getIntExtra("uin", 0);
    this.xNt = getIntent().getStringExtra("name");
    this.xVP = getIntent().getStringExtra("headurl");
    this.xVQ = getIntent().getStringExtra("rediret_url");
    this.mScene = getIntent().getIntExtra("extra_scence", 0);
    this.xNo = getIntent().getLongExtra("searchID", 0L);
    this.xNp = Util.nullAs(getIntent().getStringExtra("docID"), "");
    paramBundle = getIntent().getStringExtra("sns_object_data");
    if (!TextUtils.isEmpty(paramBundle))
    {
      this.xVO = EmojiLogic.aon(paramBundle);
      this.xNt = EmojiLogic.aoo(paramBundle);
      this.xVQ = EmojiLogic.aoA(paramBundle);
    }
    initView();
    paramBundle = bi.a.adiZ;
    paramBundle = bi.a.ayV(this.xVO);
    int i = (int)Util.nowSecond();
    paramBundle = (Iterable)paramBundle.Eib;
    Collection localCollection = (Collection)new ArrayList();
    Iterator localIterator = paramBundle.iterator();
    label332:
    while (localIterator.hasNext())
    {
      paramBundle = (com.tencent.mm.storage.emotion.a)localIterator.next();
      if (paramBundle.field_syncTime > i - 2592000L) {}
      for (paramBundle = paramBundle.field_productId;; paramBundle = null)
      {
        if (paramBundle == null) {
          break label332;
        }
        localCollection.add(paramBundle);
        break;
      }
    }
    this.xVR = ((List)localCollection);
    if (!Util.isNullOrNil(this.xOA))
    {
      paramBundle = com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adjB.bzh(this.xOA);
      if ((paramBundle != null) && (paramBundle.aarb != null) && (paramBundle.aarb.ZtX != 0) && (!Util.isNullOrNil(paramBundle.aarb.IGU)))
      {
        this.xVO = paramBundle.aarb.ZtX;
        this.xNt = paramBundle.aarb.IGU;
        Log.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "uin:%s name:%s", new Object[] { Integer.valueOf(this.xVO), this.xNt });
      }
    }
    else
    {
      i = 0;
      if (i != 0) {
        break label625;
      }
      aNi();
    }
    for (;;)
    {
      com.tencent.mm.kernel.h.baD().mCm.a(239, this);
      com.tencent.mm.kernel.h.baD().mCm.a(720, this);
      this.xQg.alive();
      com.tencent.mm.plugin.report.service.h.OAn.b(12067, new Object[] { Integer.valueOf(1), "", "", "", "" });
      com.tencent.mm.plugin.report.service.h.OAn.b(12740, new Object[] { Integer.valueOf(2), com.tencent.mm.b.p.getString(this.xVO), "", "", Integer.valueOf(this.mScene), Integer.valueOf(6) });
      paramBundle = bi.a.adiZ;
      bi.a.ayV(this.xVO).hGD();
      AppMethodBeat.o(109158);
      return;
      i = 1;
      break;
      label625:
      this.xWr = new com.tencent.mm.plugin.emoji.e.j(this.xOA);
      com.tencent.mm.kernel.h.baD().mCm.a(this.xWr, 0);
      getString(h.h.app_tip);
      this.xWs = com.tencent.mm.ui.base.k.a(this, getString(h.h.app_waiting), true, new EmojiStoreV2DesignerUI.8(this));
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(109161);
    super.onDestroy();
    com.tencent.mm.emoji.d.d locald = com.tencent.mm.emoji.d.d.mmr;
    com.tencent.mm.emoji.d.d.aWc().lc("");
    locald = com.tencent.mm.emoji.d.d.mmr;
    com.tencent.mm.emoji.d.d.rG(5);
    if (this.xWx != null) {
      com.tencent.mm.kernel.h.baD().mCm.a(this.xWx);
    }
    com.tencent.mm.kernel.h.baD().mCm.b(239, this);
    com.tencent.mm.kernel.h.baD().mCm.b(720, this);
    this.xQg.dead();
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
    ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAdapterView);
    ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramView);
    ((com.tencent.mm.hellhoundlib.b.b)localObject).sc(paramInt);
    ((com.tencent.mm.hellhoundlib.b.b)localObject).hB(paramLong);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2DesignerUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
    if (this.xQr != null)
    {
      int i = this.mListView.getHeaderViewsCount();
      paramAdapterView = this.xQr.Kd(paramInt - i);
      if (paramAdapterView != null)
      {
        paramView = new Intent();
        paramView.setClass(this, EmojiStoreDetailUI.class);
        localObject = paramAdapterView.xHE;
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
        paramAdapterView = new com.tencent.mm.hellhoundlib.b.a().cG(paramAdapterView);
        com.tencent.mm.hellhoundlib.a.a.b(this, paramAdapterView.aYi(), "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2DesignerUI", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramAdapterView.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2DesignerUI", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2DesignerUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(109174);
      return;
      label222:
      com.tencent.mm.emoji.d.d locald = com.tencent.mm.emoji.d.d.mmr;
      com.tencent.mm.emoji.d.d.aWc().lc(((cjb)localObject).ProductID);
      locald = com.tencent.mm.emoji.d.d.mmr;
      com.tencent.mm.emoji.d.d.rG(4);
      locald = com.tencent.mm.emoji.d.d.mmr;
      com.tencent.mm.emoji.d.d.aWc().lc("");
      paramView.putExtra("extra_id", ((cjb)localObject).ProductID);
      paramView.putExtra("extra_name", ((cjb)localObject).Zul);
      paramView.putExtra("extra_copyright", ((cjb)localObject).akki);
      paramView.putExtra("extra_coverurl", ((cjb)localObject).ZtY);
      paramView.putExtra("extra_description", ((cjb)localObject).akka);
      paramView.putExtra("extra_price", ((cjb)localObject).akkc);
      paramView.putExtra("extra_type", ((cjb)localObject).akkd);
      paramView.putExtra("extra_flag", ((cjb)localObject).akke);
      paramView.putExtra("preceding_scence", 106);
      paramView.putExtra("download_entrance_scene", 6);
      paramView.putExtra("call_by", 1);
      paramView.putExtra("check_clickflag", false);
      paramView.putExtra("extra_status", paramAdapterView.mStatus);
      paramView.putExtra("extra_progress", paramAdapterView.boE);
      paramView.putExtra("searchID", this.xNo);
      paramView.putExtra("extra_pack_wecoin_price", ((cjb)localObject).akkv);
      paramView.putExtra("extra_wecoin_price", ((cjb)localObject).akkw);
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
    com.tencent.mm.kernel.h.baD().mCm.b(423, this);
    AppMethodBeat.o(109160);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(109159);
    super.onResume();
    com.tencent.mm.kernel.h.baD().mCm.a(423, this);
    AppMethodBeat.o(109159);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, final com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(109168);
    switch (paramp.getType())
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
        } while (!(paramp instanceof com.tencent.mm.plugin.emoji.e.h));
        paramString = (com.tencent.mm.plugin.emoji.e.h)paramp;
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          dY(paramString.xOk, 0);
          AppMethodBeat.o(109168);
          return;
        }
        paramp = paramString.xOk;
        final String str1 = paramString.xOm;
        final String str2 = paramString.xOl;
        final String str3 = paramString.xOo;
        com.tencent.mm.ui.base.k.a(this, getString(h.h.emoji_store_download_failed_msg, new Object[] { str2 }), "", new DialogInterface.OnClickListener()new EmojiStoreV2DesignerUI.5
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(270797);
            EmojiStoreV2DesignerUI.this.X(paramp, str1, str2);
            EmojiStoreV2DesignerUI.this.dBe();
            Log.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "Retry doScene ExchangeEmotionPackNetScene productId:%s", new Object[] { paramp });
            EmojiStoreV2DesignerUI.b(EmojiStoreV2DesignerUI.this, paramp);
            AppMethodBeat.o(270797);
          }
        }, new EmojiStoreV2DesignerUI.5(this));
        dX(paramString.xOk, -1);
        AppMethodBeat.o(109168);
        return;
      } while (!(paramp instanceof com.tencent.mm.plugin.emoji.e.r));
      this.szX = false;
      if ((paramInt1 == 0) || (paramInt1 == 4))
      {
        paramString = (com.tencent.mm.plugin.emoji.e.r)paramp;
        paramp = com.tencent.mm.plugin.emoji.e.r.a(paramString.dAJ());
        if (paramInt2 == 0)
        {
          this.xWq = paramString.dAJ();
          c(paramp);
        }
        for (;;)
        {
          if ((this.xPR == null) && (this.xWq != null))
          {
            com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adjx.a(String.valueOf(this.xVO), paramString.dAJ());
            this.xWg = this.xWq.YMz;
            fg(this.xWg);
          }
          this.xPR = paramString.xOH;
          AppMethodBeat.o(109168);
          return;
          if (paramInt2 == 2)
          {
            this.xWq = paramString.dAJ();
            b(this.xPP, paramp);
            this.xPP = 2;
          }
          else if (paramInt2 == 3)
          {
            this.xWq = paramString.dAJ();
            b(this.xPP, paramp);
            this.xPP = 1;
            Log.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "get person designer failed errCode:%d", new Object[] { Integer.valueOf(paramInt2) });
          }
        }
      }
      Log.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "get person designer failed");
      AppMethodBeat.o(109168);
      return;
    }
    if ((this.xWs != null) && (this.xWs.isShowing())) {
      this.xWs.dismiss();
    }
    if ((paramInt2 == 0) && (paramInt1 == 0))
    {
      paramString = ((com.tencent.mm.plugin.emoji.e.j)paramp).dAB();
      if ((paramString != null) && (paramString.aarb != null))
      {
        this.xVO = paramString.aarb.ZtX;
        this.xNt = paramString.aarb.IGU;
        this.xVP = paramString.aarb.ZuK;
        if (this.mHandler != null) {
          this.mHandler.sendEmptyMessage(10003);
        }
      }
      AppMethodBeat.o(109168);
      return;
    }
    showOptionMenu(0, false);
    com.tencent.mm.ui.base.k.c(getContext(), getString(h.h.emoji_designer_load_failed), null, true);
    Log.e("MicroMsg.emoji.EmojiStoreV2DesignerUI", "open designer failed .");
    AppMethodBeat.o(109168);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(109173);
    if ((paramInt == 0) && (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1))
    {
      if ((this.xPP == 0) || (this.szX))
      {
        Log.d("MicroMsg.emoji.EmojiStoreV2DesignerUI", "No More List.");
        AppMethodBeat.o(109173);
        return;
      }
      bF(this.xPR);
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