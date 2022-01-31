package com.tencent.mm.plugin.emoji.ui.v2;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.bq.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.e.l;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.protocal.protobuf.PersonalDesigner;
import com.tencent.mm.protocal.protobuf.ajp;
import com.tencent.mm.protocal.protobuf.ajr;
import com.tencent.mm.protocal.protobuf.zg;
import com.tencent.mm.protocal.protobuf.zi;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.c;
import com.tencent.mm.ui.base.MMPullDownView.e;
import com.tencent.mm.ui.base.MMTagPanel;
import com.tencent.mm.ui.contact.LabelContainerView;
import com.tencent.mm.ui.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class EmojiStoreV2SingleProductUI
  extends MMActivity
  implements AbsListView.OnScrollListener, f
{
  private View Ww;
  private String eaX;
  private ProgressDialog gsr;
  private boolean isLoading;
  private long lhz;
  private String liF;
  private String liH;
  private com.tencent.mm.plugin.emoji.f.i lpB;
  private int lpb;
  private MMPullDownView lpz;
  private int lqX;
  private String lqY;
  private int lqZ;
  private String lra;
  private String lrb;
  private String lrc;
  private String lrd;
  private String lre;
  private int lrf;
  private PreViewListGridView lrg;
  private a lrh;
  private View lri;
  private TextView lrj;
  private View lrk;
  private boolean lrl;
  private ajp lrm;
  private byte[] lrn;
  private int lro;
  private String lrp;
  private LabelContainerView lrq;
  private TextView lrr;
  private MMTagPanel lrs;
  private HashMap<String, Integer> lrt;
  private ArrayList<String> lru;
  private boolean lrv;
  private c lrw;
  private MMPullDownView.e lrx;
  private MMPullDownView.c lry;
  private ak mHandler;
  private int mScene;
  
  public EmojiStoreV2SingleProductUI()
  {
    AppMethodBeat.i(53760);
    this.lpb = 0;
    this.lqZ = -1;
    this.lrf = 0;
    this.lrl = true;
    this.lro = -1;
    this.isLoading = false;
    this.lrt = new HashMap();
    this.lrv = false;
    this.mHandler = new EmojiStoreV2SingleProductUI.1(this);
    this.lrw = new EmojiStoreV2SingleProductUI.6(this);
    this.lrx = new EmojiStoreV2SingleProductUI.7(this);
    this.lry = new MMPullDownView.c()
    {
      public final boolean bim()
      {
        return false;
      }
    };
    AppMethodBeat.o(53760);
  }
  
  private void Kc()
  {
    AppMethodBeat.i(53768);
    if (this.lrv)
    {
      ab.i("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "need jeep to update page.");
      AppMethodBeat.o(53768);
      return;
    }
    this.lrn = null;
    switch (this.lrf)
    {
    }
    for (;;)
    {
      aL(this.lrn);
      AppMethodBeat.o(53768);
      return;
      this.lrm = com.tencent.mm.plugin.emoji.model.i.getEmojiStorageMgr().yNt.asV("0");
      if ((this.lrm != null) && (this.lrm.xbd != null) && (this.lrh != null))
      {
        a(this.lrm);
        this.lrh.bt(this.lrm.xbd);
      }
      for (;;)
      {
        this.lrl = true;
        com.tencent.mm.plugin.report.service.h.qsU.e(12875, new Object[] { Integer.valueOf(0), "" });
        break;
        Lc(getString(2131297112));
      }
      showOptionMenu(1001, false);
      this.lrl = false;
      com.tencent.mm.plugin.report.service.h.qsU.e(12875, new Object[] { Integer.valueOf(1), this.liH });
      continue;
      showOptionMenu(1001, false);
      this.lrp = this.lqY;
      Ld(this.lrp);
      this.lrl = false;
      com.tencent.mm.plugin.report.service.h.qsU.e(12875, new Object[] { Integer.valueOf(1), "" });
      continue;
      this.lrp = "";
      Ld(this.liF);
      this.lrl = false;
      com.tencent.mm.plugin.report.service.h.qsU.e(12875, new Object[] { Integer.valueOf(2), "" });
      continue;
      this.lrp = "";
      showOptionMenu(1001, false);
      showOptionMenu(1002, true);
      com.tencent.mm.plugin.report.service.h.qsU.e(12875, new Object[] { Integer.valueOf(3), "" });
    }
  }
  
  private void Lc(String paramString)
  {
    AppMethodBeat.i(53769);
    if (isFinishing())
    {
      ab.i("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "[showLoadingDialog] acitivity is finished.");
      AppMethodBeat.o(53769);
      return;
    }
    getString(2131297087);
    this.gsr = com.tencent.mm.ui.base.h.b(this, paramString, true, new EmojiStoreV2SingleProductUI.3(this));
    AppMethodBeat.o(53769);
  }
  
  private void Ld(String paramString)
  {
    AppMethodBeat.i(53773);
    if ((this.lri != null) && (this.lrj != null)) {
      switch (this.lrf)
      {
      }
    }
    for (;;)
    {
      if (bo.isNullOrNil(paramString))
      {
        this.lrj.setText("");
        this.lrj.setVisibility(8);
        this.lri.setVisibility(8);
      }
      AppMethodBeat.o(53773);
      return;
      if (!bo.isNullOrNil(paramString))
      {
        this.lrj.setText(getString(2131299252, new Object[] { paramString }));
        this.lrj.setVisibility(0);
        this.lri.setVisibility(0);
        continue;
        if (!bo.isNullOrNil(paramString))
        {
          this.lrj.setText(getString(2131299247, new Object[] { paramString }));
          this.lrj.setVisibility(0);
          this.lri.setVisibility(0);
        }
      }
    }
  }
  
  private void R(LinkedList<zg> paramLinkedList)
  {
    AppMethodBeat.i(53775);
    if ((this.lrh != null) && (paramLinkedList != null))
    {
      if (this.lro == -1)
      {
        this.lrh.bt(paramLinkedList);
        AppMethodBeat.o(53775);
        return;
      }
      a locala = this.lrh;
      if (locala.lee == null) {
        locala.lee = new ArrayList();
      }
      locala.lee.addAll(paramLinkedList);
      locala.notifyDataSetChanged();
    }
    AppMethodBeat.o(53775);
  }
  
  private void a(ajp paramajp)
  {
    boolean bool = false;
    AppMethodBeat.i(53772);
    if ((paramajp != null) && (paramajp.xbe != null) && (paramajp.xbe.size() > 0))
    {
      if (this.lrl) {
        bool = true;
      }
      showOptionMenu(1001, bool);
      if (this.lrs != null)
      {
        if (this.lru == null) {
          this.lru = new ArrayList();
        }
        for (;;)
        {
          if (this.lrt == null) {
            this.lrt = new HashMap();
          }
          this.lrt.clear();
          this.lru.add(getString(2131299251));
          paramajp = paramajp.xbe.iterator();
          while (paramajp.hasNext())
          {
            zi localzi = (zi)paramajp.next();
            if ((localzi != null) && (!bo.isNullOrNil(localzi.wQn)))
            {
              this.lru.add(localzi.wQn);
              this.lrt.put(localzi.wQn, Integer.valueOf(localzi.wQm));
            }
          }
          this.lru.clear();
        }
        paramajp = new ArrayList();
        paramajp.add(this.lrp);
        this.lrs.a(paramajp, this.lru);
        AppMethodBeat.o(53772);
      }
    }
    else
    {
      showOptionMenu(1001, false);
    }
    AppMethodBeat.o(53772);
  }
  
  private void aL(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(53771);
    this.lrn = null;
    switch (this.lrf)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(53771);
      return;
      paramArrayOfByte = new com.tencent.mm.plugin.emoji.f.h(1, this.lpb, this.lqX, this.liF, this.lqZ, paramArrayOfByte);
      g.RK().eHt.a(paramArrayOfByte, 0);
      AppMethodBeat.o(53771);
      return;
      paramArrayOfByte = new com.tencent.mm.plugin.emoji.f.h(2, this.lpb, this.lqX, this.liF, this.lqZ, paramArrayOfByte);
      g.RK().eHt.a(paramArrayOfByte, 0);
      AppMethodBeat.o(53771);
      return;
      paramArrayOfByte = new com.tencent.mm.plugin.emoji.f.h(3, this.lpb, this.lqX, this.liF, this.lqZ, paramArrayOfByte);
      g.RK().eHt.a(paramArrayOfByte, 0);
      AppMethodBeat.o(53771);
      return;
      paramArrayOfByte = new com.tencent.mm.plugin.emoji.f.h(4, this.lpb, this.lqX, this.liF, this.lqZ, paramArrayOfByte);
      g.RK().eHt.a(paramArrayOfByte, 0);
      AppMethodBeat.o(53771);
      return;
      paramArrayOfByte = new com.tencent.mm.plugin.emoji.f.h(5, this.lpb, this.lqX, this.liF, this.lqZ, paramArrayOfByte);
      g.RK().eHt.a(paramArrayOfByte, 0);
    }
  }
  
  private void bmh()
  {
    AppMethodBeat.i(53770);
    if ((this.gsr != null) && (this.gsr.isShowing())) {
      this.gsr.dismiss();
    }
    AppMethodBeat.o(53770);
  }
  
  private void bnm()
  {
    AppMethodBeat.i(53774);
    if (!this.isLoading)
    {
      aL(this.lrn);
      this.isLoading = true;
      this.mHandler.sendEmptyMessageDelayed(1002, 200L);
    }
    AppMethodBeat.o(53774);
  }
  
  private void bnn()
  {
    AppMethodBeat.i(53776);
    Toast.makeText(getContext(), getString(2131299286), 0).show();
    AppMethodBeat.o(53776);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2130969414;
  }
  
  public void initView()
  {
    AppMethodBeat.i(53766);
    if ((this.lrf == 6) && (!bo.isNullOrNil(this.lra))) {
      setMMTitle(this.lra);
    }
    for (;;)
    {
      setBackBtn(new EmojiStoreV2SingleProductUI.9(this));
      this.lrh = new a(getContext());
      this.lrh.lsl = new EmojiStoreV2SingleProductUI.10(this);
      this.lrg = ((PreViewListGridView)findViewById(2131821002));
      this.Ww = w.hM(getContext()).inflate(2130969400, null);
      this.lri = this.Ww.findViewById(2131823678);
      this.lrj = ((TextView)this.Ww.findViewById(2131823679));
      this.lrg.addHeaderView(this.Ww);
      this.lrk = w.hM(getContext()).inflate(2130969387, null);
      this.lrg.addFooterView(this.lrk);
      this.lrk.setVisibility(8);
      this.lrg.setAdapter(this.lrh);
      this.lrg.setOnScrollListener(this);
      this.lpz = ((MMPullDownView)findViewById(2131823706));
      this.lpz.setTopViewVisible(false);
      this.lpz.setOnBottomLoadDataListener(this.lrx);
      this.lpz.setAtBottomCallBack(this.lry);
      this.lpz.setBottomViewVisible(false);
      this.lpz.setIsBottomShowAll(false);
      this.lpz.setIsReturnSuperDispatchWhenCancel(true);
      this.lrq = ((LabelContainerView)findViewById(2131820915));
      this.lrr = ((TextView)this.lrq.findViewById(16908310));
      this.lrr.setText(2131301014);
      this.lrs = ((MMTagPanel)this.lrq.findViewById(2131820916));
      this.lrs.setTagSelectedBG(2130840503);
      this.lrs.setTagSelectedTextColorRes(2131690701);
      this.lrp = getString(2131299251);
      this.lrq.setOnLabelContainerListener(new EmojiStoreV2SingleProductUI.11(this));
      this.lrs.setCallBack(new EmojiStoreV2SingleProductUI.12(this));
      addIconOptionMenu(1001, 2130837614, new EmojiStoreV2SingleProductUI.13(this));
      addIconOptionMenu(1002, 2131231823, new EmojiStoreV2SingleProductUI.2(this));
      showOptionMenu(1001, false);
      showOptionMenu(1002, false);
      AppMethodBeat.o(53766);
      return;
      setMMTitle(2131299222);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(53765);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(53765);
      return;
      if (paramInt2 == -1)
      {
        com.tencent.mm.ui.widget.snackbar.b.l(this, getContext().getString(2131297070));
        continue;
        if (paramInt2 == -1)
        {
          String str1 = paramIntent.getStringExtra("Select_Conv_User");
          if (!bo.isNullOrNil(str1))
          {
            ab.d("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "..".concat(String.valueOf(str1)));
            int i = this.lqZ;
            String str2 = this.lra;
            String str3 = this.lrc;
            String str4 = this.lrb;
            String str5 = this.lrd;
            int j = this.lrf;
            com.tencent.mm.plugin.emoji.model.i.blp();
            l.a(this, str1, 27, i, str2, str3, str4, str5, j, "https://support.weixin.qq.com/cgi-bin/readtemplate?t=page/common_page__upgrade&text=text000&btn_text=btn_text_0&title=title_0");
          }
        }
      }
    }
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(53767);
    if ((this.lrq != null) && (this.lrq.getVisibility() == 0))
    {
      this.lrq.setVisibility(8);
      if (this.lrl) {}
      for (boolean bool = true;; bool = false)
      {
        showOptionMenu(1001, bool);
        setMMTitle(2131299222);
        AppMethodBeat.o(53767);
        return;
      }
    }
    super.onBackPressed();
    AppMethodBeat.o(53767);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(53761);
    super.onCreate(paramBundle);
    this.lpb = getIntent().getIntExtra("uin", 0);
    this.eaX = getIntent().getStringExtra("Select_Conv_User");
    this.lhz = getIntent().getLongExtra("searchID", 0L);
    this.liH = getIntent().getStringExtra("id");
    paramBundle = getIntent().getStringExtra("tag_id");
    if (!bo.isNullOrNil(paramBundle)) {}
    try
    {
      this.lqX = Integer.valueOf(paramBundle).intValue();
      this.lqY = getIntent().getStringExtra("tag_desc");
      this.liF = getIntent().getStringExtra("keyword");
      this.lqZ = getIntent().getIntExtra("set_id", 0);
      this.lra = getIntent().getStringExtra("set_title");
      this.lrb = getIntent().getStringExtra("set_iconURL");
      this.lrc = getIntent().getStringExtra("set_desc");
      this.lrd = getIntent().getStringExtra("headurl");
      this.lre = getIntent().getStringExtra("sns_object_data");
      this.lrf = getIntent().getIntExtra("pageType", 0);
      if (!bo.isNullOrNil(this.lre))
      {
        this.lqZ = EmojiLogic.KL(this.lre);
        this.lra = EmojiLogic.KM(this.lre);
        this.lrb = EmojiLogic.KO(this.lre);
        this.lrc = EmojiLogic.KN(this.lre);
        this.lrd = EmojiLogic.KP(this.lre);
        this.lrf = EmojiLogic.KQ(this.lre);
      }
      switch (this.lrf)
      {
      default: 
        this.lrv = true;
        if (this.lrv)
        {
          paramBundle = new Intent();
          com.tencent.mm.plugin.emoji.model.i.blp();
          paramBundle.putExtra("rawUrl", "https://support.weixin.qq.com/cgi-bin/readtemplate?t=page/common_page__upgrade&text=text000&btn_text=btn_text_0&title=title_0");
          paramBundle.putExtra("showShare", false);
          d.b(this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramBundle);
          finish();
        }
        initView();
        if ((this.lpb == 0) && (this.lrf == 2))
        {
          paramBundle = com.tencent.mm.plugin.emoji.model.i.getEmojiStorageMgr().yNt.asU(this.liH);
          if ((paramBundle != null) && (paramBundle.xbf != null) && (paramBundle.xbf.DesignerUin != 0) && (!bo.isNullOrNil(paramBundle.xbf.Name)))
          {
            this.lpb = paramBundle.xbf.DesignerUin;
            ab.i("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "uin:%s ", new Object[] { Integer.valueOf(this.lpb) });
          }
        }
        else
        {
          i = 0;
          if (i != 0) {
            break label772;
          }
          Kc();
          g.RL().Ru().set(ac.a.yxX, Boolean.FALSE);
          g.RK().eHt.a(821, this);
          g.RK().eHt.a(239, this);
          AppMethodBeat.o(53761);
          return;
        }
        break;
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        int i;
        ab.e("MicroMsg.emoji.EmojiStoreV2SingleProductUI", bo.l(paramBundle));
        continue;
        if (!bo.isNullOrNil(this.liF))
        {
          this.lrf = 5;
          this.lrl = false;
          this.mScene = 2;
        }
        else if (!bo.isNullOrNil(this.liH))
        {
          this.lrf = 2;
          this.mScene = 1;
        }
        else if (this.lpb != 0)
        {
          this.lrf = 3;
          this.mScene = 1;
        }
        else if (this.lqX != 0)
        {
          this.mScene = 3;
          this.lrf = 4;
        }
        else if (this.lqZ > 0)
        {
          this.lrf = 6;
          this.mScene = 4;
        }
        else
        {
          this.lrf = 1;
          this.mScene = 0;
          continue;
          this.mScene = 0;
          continue;
          if (bo.isNullOrNil(this.liH))
          {
            continue;
            if (this.lpb == 0)
            {
              continue;
              if (this.lqX == 0)
              {
                continue;
                if (bo.isNullOrNil(this.liF))
                {
                  continue;
                  if (this.lqZ == 0)
                  {
                    continue;
                    i = 1;
                    continue;
                    label772:
                    this.lpB = new com.tencent.mm.plugin.emoji.f.i(this.liH);
                    g.RK().eHt.a(this.lpB, 0);
                    Lc(getString(2131297112));
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(53764);
    g.RK().eHt.b(239, this);
    g.RK().eHt.b(821, this);
    super.onDestroy();
    AppMethodBeat.o(53764);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(53763);
    super.onPause();
    com.tencent.mm.sdk.b.a.ymk.d(this.lrw);
    AppMethodBeat.o(53763);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(53762);
    super.onResume();
    com.tencent.mm.sdk.b.a.ymk.c(this.lrw);
    AppMethodBeat.o(53762);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(53777);
    int i = paramm.getType();
    if (i == 821)
    {
      bmh();
      paramString = (com.tencent.mm.plugin.emoji.f.h)paramm;
      paramm = paramString.blC();
      this.isLoading = false;
      if (this.lrk != null)
      {
        this.lrk.setVisibility(8);
        this.mHandler.removeMessages(1002);
        this.mHandler.sendEmptyMessageDelayed(1001, 200L);
      }
      i = paramString.gxQ;
      if (((paramInt1 == 0) && (paramInt2 == 0)) || ((paramInt1 == 4) && ((paramInt2 == 2) || (paramInt2 == 3)) && ((this.lrn == null) || (this.lrn.length <= 0)) && (i != 3))) {
        a(paramm);
      }
      if ((paramInt1 == 0) || (paramInt1 == 4))
      {
        this.lrn = paramString.liD;
        if (paramInt2 == 0)
        {
          R(paramm.xbd);
          this.lro = 0;
          AppMethodBeat.o(53777);
          return;
        }
        if (paramInt2 == 2)
        {
          R(paramm.xbd);
          this.lro = 2;
          AppMethodBeat.o(53777);
          return;
        }
        if (paramInt2 == 3)
        {
          this.lro = -1;
          R(paramm.xbd);
          AppMethodBeat.o(53777);
          return;
        }
        bnn();
        AppMethodBeat.o(53777);
        return;
      }
      bnn();
      AppMethodBeat.o(53777);
      return;
    }
    if (i == 239)
    {
      bmh();
      if ((paramInt2 == 0) && (paramInt1 == 0))
      {
        paramString = ((com.tencent.mm.plugin.emoji.f.i)paramm).blD();
        if ((paramString != null) && (paramString.xbf != null))
        {
          this.lpb = paramString.xbf.DesignerUin;
          if (this.mHandler != null) {
            this.mHandler.sendEmptyMessage(1004);
          }
        }
        AppMethodBeat.o(53777);
        return;
      }
      showOptionMenu(1001, false);
      com.tencent.mm.ui.base.h.b(getContext(), getString(2131299137), null, true);
      ab.e("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "open single product ui failed.");
    }
    AppMethodBeat.o(53777);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(53778);
    if ((paramInt == 0) && (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1) && (this.lro == 2) && (!this.isLoading))
    {
      ab.d("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "No More List.");
      bnm();
      ab.i("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "[onScrollStateChanged] startLoadRemoteEmoji.");
    }
    if ((paramInt != 0) && (this.lrg != null)) {
      this.lrg.bnw();
    }
    AppMethodBeat.o(53778);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductUI
 * JD-Core Version:    0.7.0.1
 */