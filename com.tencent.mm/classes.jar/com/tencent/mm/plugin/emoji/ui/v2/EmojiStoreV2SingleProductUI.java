package com.tencent.mm.plugin.emoji.ui.v2;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.f.b;
import com.tencent.mm.plugin.emoji.f.d;
import com.tencent.mm.plugin.emoji.f.e;
import com.tencent.mm.plugin.emoji.f.f;
import com.tencent.mm.plugin.emoji.f.g;
import com.tencent.mm.plugin.emoji.f.h;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.protocal.c.aes;
import com.tencent.mm.protocal.c.aeu;
import com.tencent.mm.protocal.c.bel;
import com.tencent.mm.protocal.c.ut;
import com.tencent.mm.protocal.c.uu;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.c;
import com.tencent.mm.ui.base.MMPullDownView.e;
import com.tencent.mm.ui.base.MMTagPanel;
import com.tencent.mm.ui.contact.LabelContainerView;
import com.tencent.mm.ui.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class EmojiStoreV2SingleProductUI
  extends MMActivity
  implements AbsListView.OnScrollListener, f
{
  private View VH;
  private String djD;
  private ProgressDialog faz;
  private int fzn;
  private long iYu;
  private String iZO;
  private String iZQ;
  private boolean isLoading = false;
  private MMPullDownView jgG;
  private com.tencent.mm.plugin.emoji.f.j jgI;
  private int jgi = 0;
  private TextView jiA;
  private MMTagPanel jiB;
  private HashMap<String, Integer> jiC = new HashMap();
  private ArrayList<String> jiD;
  private boolean jiE = false;
  private c jiF = new EmojiStoreV2SingleProductUI.6(this);
  private MMPullDownView.e jiG = new EmojiStoreV2SingleProductUI.7(this);
  private MMPullDownView.c jiH = new MMPullDownView.c()
  {
    public final boolean aEW()
    {
      return false;
    }
  };
  private int jig;
  private String jih;
  private int jii = -1;
  private String jij;
  private String jik;
  private String jil;
  private String jim;
  private String jin;
  private int jio = 0;
  private PreViewListGridView jip;
  private d jiq;
  private View jir;
  private TextView jis;
  private View jit;
  private boolean jiu = true;
  private aes jiv;
  private byte[] jiw;
  private int jix = -1;
  private String jiy;
  private LabelContainerView jiz;
  private ah mHandler = new ah()
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      case 1003: 
      default: 
      case 1001: 
        do
        {
          return;
        } while (EmojiStoreV2SingleProductUI.a(EmojiStoreV2SingleProductUI.this) == null);
        EmojiStoreV2SingleProductUI.a(EmojiStoreV2SingleProductUI.this).setVisibility(8);
        return;
      case 1002: 
        if (EmojiStoreV2SingleProductUI.a(EmojiStoreV2SingleProductUI.this) != null) {
          EmojiStoreV2SingleProductUI.a(EmojiStoreV2SingleProductUI.this).setVisibility(0);
        }
        sendEmptyMessage(1003);
        return;
      }
      EmojiStoreV2SingleProductUI.b(EmojiStoreV2SingleProductUI.this);
    }
  };
  
  private void Ba(String paramString)
  {
    if (isFinishing())
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "[showLoadingDialog] acitivity is finished.");
      return;
    }
    getString(f.h.app_tip);
    this.faz = com.tencent.mm.ui.base.h.b(this, paramString, true, new EmojiStoreV2SingleProductUI.3(this));
  }
  
  private void Bb(String paramString)
  {
    if ((this.jir != null) && (this.jis != null)) {
      switch (this.jio)
      {
      }
    }
    for (;;)
    {
      if (bk.bl(paramString))
      {
        this.jis.setText("");
        this.jis.setVisibility(8);
        this.jir.setVisibility(8);
      }
      return;
      if (!bk.bl(paramString))
      {
        this.jis.setText(getString(f.h.emoji_store_tag_tip, new Object[] { paramString }));
        this.jis.setVisibility(0);
        this.jir.setVisibility(0);
        continue;
        if (!bk.bl(paramString))
        {
          this.jis.setText(getString(f.h.emoji_store_search_tip, new Object[] { paramString }));
          this.jis.setVisibility(0);
          this.jir.setVisibility(0);
        }
      }
    }
  }
  
  private void R(LinkedList<ut> paramLinkedList)
  {
    if ((this.jiq != null) && (paramLinkedList != null))
    {
      if (this.jix == -1) {
        this.jiq.bc(paramLinkedList);
      }
    }
    else {
      return;
    }
    d locald = this.jiq;
    if (locald.iVa == null) {
      locald.iVa = new ArrayList();
    }
    locald.iVa.addAll(paramLinkedList);
    locald.notifyDataSetChanged();
  }
  
  private void a(aes paramaes)
  {
    boolean bool = false;
    if ((paramaes != null) && (paramaes.tcN != null) && (paramaes.tcN.size() > 0))
    {
      if (this.jiu) {
        bool = true;
      }
      showOptionMenu(1001, bool);
      if (this.jiB != null)
      {
        if (this.jiD == null) {
          this.jiD = new ArrayList();
        }
        for (;;)
        {
          if (this.jiC == null) {
            this.jiC = new HashMap();
          }
          this.jiC.clear();
          this.jiD.add(getString(f.h.emoji_store_tag_all));
          paramaes = paramaes.tcN.iterator();
          while (paramaes.hasNext())
          {
            uu localuu = (uu)paramaes.next();
            if ((localuu != null) && (!bk.bl(localuu.sRz)))
            {
              this.jiD.add(localuu.sRz);
              this.jiC.put(localuu.sRz, Integer.valueOf(localuu.sRy));
            }
          }
          this.jiD.clear();
        }
        paramaes = new ArrayList();
        paramaes.add(this.jiy);
        this.jiB.a(paramaes, this.jiD);
      }
      return;
    }
    showOptionMenu(1001, false);
  }
  
  private void aIJ()
  {
    if ((this.faz != null) && (this.faz.isShowing())) {
      this.faz.dismiss();
    }
  }
  
  private void aJE()
  {
    if (!this.isLoading)
    {
      an(this.jiw);
      this.isLoading = true;
      this.mHandler.sendEmptyMessageDelayed(1002, 200L);
    }
  }
  
  private void aJF()
  {
    Toast.makeText(this.mController.uMN, getString(f.h.emoji_unknow), 0).show();
  }
  
  private void an(byte[] paramArrayOfByte)
  {
    this.jiw = null;
    switch (this.jio)
    {
    default: 
      return;
    case 1: 
      paramArrayOfByte = new com.tencent.mm.plugin.emoji.f.i(1, this.jgi, this.jig, this.iZO, this.jii, paramArrayOfByte);
      g.DO().dJT.a(paramArrayOfByte, 0);
      return;
    case 2: 
    case 3: 
      paramArrayOfByte = new com.tencent.mm.plugin.emoji.f.i(2, this.jgi, this.jig, this.iZO, this.jii, paramArrayOfByte);
      g.DO().dJT.a(paramArrayOfByte, 0);
      return;
    case 4: 
      paramArrayOfByte = new com.tencent.mm.plugin.emoji.f.i(3, this.jgi, this.jig, this.iZO, this.jii, paramArrayOfByte);
      g.DO().dJT.a(paramArrayOfByte, 0);
      return;
    case 5: 
      paramArrayOfByte = new com.tencent.mm.plugin.emoji.f.i(4, this.jgi, this.jig, this.iZO, this.jii, paramArrayOfByte);
      g.DO().dJT.a(paramArrayOfByte, 0);
      return;
    }
    paramArrayOfByte = new com.tencent.mm.plugin.emoji.f.i(5, this.jgi, this.jig, this.iZO, this.jii, paramArrayOfByte);
    g.DO().dJT.a(paramArrayOfByte, 0);
  }
  
  private void xK()
  {
    if (this.jiE)
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "need jeep to update page.");
      return;
    }
    this.jiw = null;
    switch (this.jio)
    {
    }
    for (;;)
    {
      an(this.jiw);
      return;
      this.jiv = com.tencent.mm.plugin.emoji.model.i.getEmojiStorageMgr().uBh.acH("0");
      if ((this.jiv != null) && (this.jiv.tcM != null) && (this.jiq != null))
      {
        a(this.jiv);
        this.jiq.bc(this.jiv.tcM);
      }
      for (;;)
      {
        this.jiu = true;
        com.tencent.mm.plugin.report.service.h.nFQ.f(12875, new Object[] { Integer.valueOf(0), "" });
        break;
        Ba(getString(f.h.app_waiting));
      }
      showOptionMenu(1001, false);
      this.jiu = false;
      com.tencent.mm.plugin.report.service.h.nFQ.f(12875, new Object[] { Integer.valueOf(1), this.iZQ });
      continue;
      showOptionMenu(1001, false);
      this.jiy = this.jih;
      Bb(this.jiy);
      this.jiu = false;
      com.tencent.mm.plugin.report.service.h.nFQ.f(12875, new Object[] { Integer.valueOf(1), "" });
      continue;
      this.jiy = "";
      Bb(this.iZO);
      this.jiu = false;
      com.tencent.mm.plugin.report.service.h.nFQ.f(12875, new Object[] { Integer.valueOf(2), "" });
      continue;
      this.jiy = "";
      showOptionMenu(1001, false);
      showOptionMenu(1002, true);
      com.tencent.mm.plugin.report.service.h.nFQ.f(12875, new Object[] { Integer.valueOf(3), "" });
    }
  }
  
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  protected final int getLayoutId()
  {
    return f.f.emoji_store_v2_single_product_ui;
  }
  
  protected final void initView()
  {
    if ((this.jio == 6) && (!bk.bl(this.jij))) {
      setMMTitle(this.jij);
    }
    for (;;)
    {
      setBackBtn(new EmojiStoreV2SingleProductUI.9(this));
      this.jiq = new d(this.mController.uMN);
      this.jiq.jjt = new EmojiStoreV2SingleProductUI.10(this);
      this.jip = ((PreViewListGridView)findViewById(f.e.list));
      this.VH = com.tencent.mm.ui.y.gt(this.mController.uMN).inflate(f.f.emoji_store_v2_mgr_header, null);
      this.jir = this.VH.findViewById(f.e.emoji_mgr);
      this.jis = ((TextView)this.VH.findViewById(f.e.emoji_tag));
      this.jip.addHeaderView(this.VH);
      this.jit = com.tencent.mm.ui.y.gt(this.mController.uMN).inflate(f.f.emoji_store_load_more, null);
      this.jip.addFooterView(this.jit);
      this.jit.setVisibility(8);
      this.jip.setAdapter(this.jiq);
      this.jip.setOnScrollListener(this);
      this.jgG = ((MMPullDownView)findViewById(f.e.load_more_view));
      this.jgG.setTopViewVisible(false);
      this.jgG.setOnBottomLoadDataListener(this.jiG);
      this.jgG.setAtBottomCallBack(this.jiH);
      this.jgG.setBottomViewVisible(false);
      this.jgG.setIsBottomShowAll(false);
      this.jgG.setIsReturnSuperDispatchWhenCancel(true);
      this.jiz = ((LabelContainerView)findViewById(f.e.select_contact_label_container));
      this.jiA = ((TextView)this.jiz.findViewById(16908310));
      this.jiA.setText(f.h.label_panel_search_by);
      this.jiB = ((MMTagPanel)this.jiz.findViewById(f.e.contact_label_panel));
      this.jiB.setTagSelectedBG(f.d.tag_green_tab_selector);
      this.jiB.setTagSelectedTextColorRes(f.b.wechat_green);
      this.jiy = getString(f.h.emoji_store_tag_all);
      this.jiz.setOnLabelContainerListener(new EmojiStoreV2SingleProductUI.11(this));
      this.jiB.setCallBack(new EmojiStoreV2SingleProductUI.12(this));
      addIconOptionMenu(1001, f.d.actionbar_emotag_icon, new EmojiStoreV2SingleProductUI.13(this));
      addIconOptionMenu(1002, f.g.ofm_send_icon, new EmojiStoreV2SingleProductUI.2(this));
      showOptionMenu(1001, false);
      showOptionMenu(1002, false);
      return;
      setMMTitle(f.h.emoji_store_product_title);
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      if (paramInt2 == -1)
      {
        com.tencent.mm.ui.widget.snackbar.b.h(this, this.mController.uMN.getString(f.h.app_sent));
        continue;
        if (paramInt2 == -1)
        {
          String str1 = paramIntent.getStringExtra("Select_Conv_User");
          if (!bk.bl(str1))
          {
            com.tencent.mm.sdk.platformtools.y.d("MicroMsg.emoji.EmojiStoreV2SingleProductUI", ".." + str1);
            int i = this.jii;
            String str2 = this.jij;
            String str3 = this.jil;
            String str4 = this.jik;
            String str5 = this.jim;
            int j = this.jio;
            com.tencent.mm.plugin.emoji.model.i.aHP();
            com.tencent.mm.plugin.emoji.e.j.a(this, str1, 27, i, str2, str3, str4, str5, j, "https://support.weixin.qq.com/cgi-bin/readtemplate?t=page/common_page__upgrade&text=text000&btn_text=btn_text_0&title=title_0");
          }
        }
      }
    }
  }
  
  public void onBackPressed()
  {
    if ((this.jiz != null) && (this.jiz.getVisibility() == 0))
    {
      this.jiz.setVisibility(8);
      if (this.jiu) {}
      for (boolean bool = true;; bool = false)
      {
        showOptionMenu(1001, bool);
        setMMTitle(f.h.emoji_store_product_title);
        return;
      }
    }
    super.onBackPressed();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jgi = getIntent().getIntExtra("uin", 0);
    this.djD = getIntent().getStringExtra("Select_Conv_User");
    this.iYu = getIntent().getLongExtra("searchID", 0L);
    this.iZQ = getIntent().getStringExtra("id");
    paramBundle = getIntent().getStringExtra("tag_id");
    if (!bk.bl(paramBundle)) {}
    try
    {
      this.jig = Integer.valueOf(paramBundle).intValue();
      this.jih = getIntent().getStringExtra("tag_desc");
      this.iZO = getIntent().getStringExtra("keyword");
      this.jii = getIntent().getIntExtra("set_id", 0);
      this.jij = getIntent().getStringExtra("set_title");
      this.jik = getIntent().getStringExtra("set_iconURL");
      this.jil = getIntent().getStringExtra("set_desc");
      this.jim = getIntent().getStringExtra("headurl");
      this.jin = getIntent().getStringExtra("sns_object_data");
      this.jio = getIntent().getIntExtra("pageType", 0);
      if (!bk.bl(this.jin))
      {
        this.jii = EmojiLogic.AJ(this.jin);
        this.jij = EmojiLogic.AK(this.jin);
        this.jik = EmojiLogic.AM(this.jin);
        this.jil = EmojiLogic.AL(this.jin);
        this.jim = EmojiLogic.AN(this.jin);
        this.jio = EmojiLogic.AO(this.jin);
      }
      switch (this.jio)
      {
      default: 
        this.jiE = true;
        if (this.jiE)
        {
          paramBundle = new Intent();
          com.tencent.mm.plugin.emoji.model.i.aHP();
          paramBundle.putExtra("rawUrl", "https://support.weixin.qq.com/cgi-bin/readtemplate?t=page/common_page__upgrade&text=text000&btn_text=btn_text_0&title=title_0");
          paramBundle.putExtra("showShare", false);
          com.tencent.mm.br.d.b(this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramBundle);
          finish();
        }
        initView();
        if ((this.jgi == 0) && (this.jio == 2))
        {
          paramBundle = com.tencent.mm.plugin.emoji.model.i.getEmojiStorageMgr().uBh.acG(this.iZQ);
          if ((paramBundle != null) && (paramBundle.tcO != null) && (paramBundle.tcO.tcH != 0) && (!bk.bl(paramBundle.tcO.kRZ)))
          {
            this.jgi = paramBundle.tcO.tcH;
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "uin:%s ", new Object[] { Integer.valueOf(this.jgi) });
          }
        }
        else
        {
          i = 0;
          if (i != 0) {
            break label763;
          }
          xK();
          g.DP().Dz().c(ac.a.uof, Boolean.valueOf(false));
          g.DO().dJT.a(821, this);
          g.DO().dJT.a(239, this);
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
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.emoji.EmojiStoreV2SingleProductUI", bk.j(paramBundle));
        continue;
        if (!bk.bl(this.iZO))
        {
          this.jio = 5;
          this.jiu = false;
          this.fzn = 2;
        }
        else if (!bk.bl(this.iZQ))
        {
          this.jio = 2;
          this.fzn = 1;
        }
        else if (this.jgi != 0)
        {
          this.jio = 3;
          this.fzn = 1;
        }
        else if (this.jig != 0)
        {
          this.fzn = 3;
          this.jio = 4;
        }
        else if (this.jii > 0)
        {
          this.jio = 6;
          this.fzn = 4;
        }
        else
        {
          this.jio = 1;
          this.fzn = 0;
          continue;
          this.fzn = 0;
          continue;
          if (bk.bl(this.iZQ))
          {
            continue;
            if (this.jgi == 0)
            {
              continue;
              if (this.jig == 0)
              {
                continue;
                if (bk.bl(this.iZO))
                {
                  continue;
                  if (this.jii == 0)
                  {
                    continue;
                    i = 1;
                    continue;
                    label763:
                    this.jgI = new com.tencent.mm.plugin.emoji.f.j(this.iZQ);
                    g.DO().dJT.a(this.jgI, 0);
                    Ba(getString(f.h.app_waiting));
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  protected void onDestroy()
  {
    g.DO().dJT.b(239, this);
    g.DO().dJT.b(821, this);
    super.onDestroy();
  }
  
  protected void onPause()
  {
    super.onPause();
    a.udP.d(this.jiF);
  }
  
  protected void onResume()
  {
    super.onResume();
    a.udP.c(this.jiF);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    int i = paramm.getType();
    if (i == 821)
    {
      aIJ();
      paramString = (com.tencent.mm.plugin.emoji.f.i)paramm;
      paramm = paramString.aId();
      this.isLoading = false;
      if (this.jit != null)
      {
        this.jit.setVisibility(8);
        this.mHandler.removeMessages(1002);
        this.mHandler.sendEmptyMessageDelayed(1001, 200L);
      }
      i = paramString.fgi;
      if (((paramInt1 == 0) && (paramInt2 == 0)) || ((paramInt1 == 4) && ((paramInt2 == 2) || (paramInt2 == 3)) && ((this.jiw == null) || (this.jiw.length <= 0)) && (i != 3))) {
        a(paramm);
      }
      if ((paramInt1 == 0) || (paramInt1 == 4))
      {
        this.jiw = paramString.iZM;
        if (paramInt2 == 0)
        {
          R(paramm.tcM);
          this.jix = 0;
        }
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if (paramInt2 == 2)
          {
            R(paramm.tcM);
            this.jix = 2;
            return;
          }
          if (paramInt2 == 3)
          {
            this.jix = -1;
            R(paramm.tcM);
            return;
          }
          aJF();
          return;
          aJF();
          return;
        } while (i != 239);
        aIJ();
        if ((paramInt2 != 0) || (paramInt1 != 0)) {
          break;
        }
        paramString = ((com.tencent.mm.plugin.emoji.f.j)paramm).aIe();
      } while ((paramString == null) || (paramString.tcO == null));
      this.jgi = paramString.tcO.tcH;
    } while (this.mHandler == null);
    this.mHandler.sendEmptyMessage(1004);
    return;
    showOptionMenu(1001, false);
    com.tencent.mm.ui.base.h.b(this.mController.uMN, getString(f.h.emoji_designer_load_failed), null, true);
    com.tencent.mm.sdk.platformtools.y.e("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "open single product ui failed.");
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1) && (this.jix == 2) && (!this.isLoading))
    {
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "No More List.");
      aJE();
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "[onScrollStateChanged] startLoadRemoteEmoji.");
    }
    if ((paramInt != 0) && (this.jip != null)) {
      this.jip.aJJ();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductUI
 * JD-Core Version:    0.7.0.1
 */