package com.tencent.mm.plugin.emoji.ui.v2;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.dr;
import com.tencent.mm.plugin.emoji.i.a;
import com.tencent.mm.plugin.emoji.i.b;
import com.tencent.mm.plugin.emoji.i.d;
import com.tencent.mm.plugin.emoji.i.e;
import com.tencent.mm.plugin.emoji.i.f;
import com.tencent.mm.plugin.emoji.i.g;
import com.tencent.mm.plugin.emoji.i.h;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.p;
import com.tencent.mm.protocal.protobuf.aji;
import com.tencent.mm.protocal.protobuf.ajl;
import com.tencent.mm.protocal.protobuf.btp;
import com.tencent.mm.protocal.protobuf.btr;
import com.tencent.mm.protocal.protobuf.dkv;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.k;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.c;
import com.tencent.mm.ui.base.MMPullDownView.e;
import com.tencent.mm.ui.base.MMTagPanel;
import com.tencent.mm.ui.base.MMTagPanel.a;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.contact.LabelContainerView;
import com.tencent.mm.ui.contact.LabelContainerView.a;
import com.tencent.mm.ui.widget.snackbar.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class EmojiStoreV2SingleProductUI
  extends MMActivity
  implements AbsListView.OnScrollListener, com.tencent.mm.an.i
{
  private String iSn;
  private boolean isLoading;
  private MMHandler mHandler;
  private View mL;
  private ProgressDialog mRa;
  private int mScene;
  private long uEM;
  private String uFV;
  private String uFX;
  private MMPullDownView uNF;
  private com.tencent.mm.plugin.emoji.f.j uNH;
  private int uNg;
  private LabelContainerView uPA;
  private TextView uPB;
  private MMTagPanel uPC;
  private HashMap<String, Integer> uPD;
  private ArrayList<String> uPE;
  private boolean uPF;
  private IListener uPG;
  private MMPullDownView.e uPH;
  private MMPullDownView.c uPI;
  private int uPh;
  private String uPi;
  private int uPj;
  private String uPk;
  private String uPl;
  private String uPm;
  private String uPn;
  private String uPo;
  private int uPp;
  private PreViewListGridView uPq;
  private a uPr;
  private View uPs;
  private TextView uPt;
  private View uPu;
  private boolean uPv;
  private btp uPw;
  private byte[] uPx;
  private int uPy;
  private String uPz;
  
  public EmojiStoreV2SingleProductUI()
  {
    AppMethodBeat.i(109334);
    this.uNg = 0;
    this.uPj = -1;
    this.uPp = 0;
    this.uPv = true;
    this.uPy = -1;
    this.isLoading = false;
    this.uPD = new HashMap();
    this.uPF = false;
    this.mHandler = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(109319);
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(109319);
          return;
          if (EmojiStoreV2SingleProductUI.a(EmojiStoreV2SingleProductUI.this) != null)
          {
            EmojiStoreV2SingleProductUI.a(EmojiStoreV2SingleProductUI.this).setVisibility(8);
            AppMethodBeat.o(109319);
            return;
            if (EmojiStoreV2SingleProductUI.a(EmojiStoreV2SingleProductUI.this) != null) {
              EmojiStoreV2SingleProductUI.a(EmojiStoreV2SingleProductUI.this).setVisibility(0);
            }
            sendEmptyMessage(1003);
            AppMethodBeat.o(109319);
            return;
            EmojiStoreV2SingleProductUI.b(EmojiStoreV2SingleProductUI.this);
          }
        }
      }
    };
    this.uPG = new IListener() {};
    this.uPH = new MMPullDownView.e()
    {
      public final boolean cOJ()
      {
        AppMethodBeat.i(109326);
        Log.i("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "onBottom");
        EmojiStoreV2SingleProductUI.e(EmojiStoreV2SingleProductUI.this);
        AppMethodBeat.o(109326);
        return true;
      }
    };
    this.uPI = new MMPullDownView.c()
    {
      public final boolean cOL()
      {
        return false;
      }
    };
    AppMethodBeat.o(109334);
  }
  
  private void Y(LinkedList<aji> paramLinkedList)
  {
    AppMethodBeat.i(109349);
    if ((this.uPr != null) && (paramLinkedList != null))
    {
      if (this.uPy == -1)
      {
        this.uPr.aa(paramLinkedList);
        AppMethodBeat.o(109349);
        return;
      }
      a locala = this.uPr;
      if (locala.uAd == null) {
        locala.uAd = new ArrayList();
      }
      locala.uAd.addAll(paramLinkedList);
      locala.notifyDataSetChanged();
    }
    AppMethodBeat.o(109349);
  }
  
  private void a(btp parambtp)
  {
    boolean bool = false;
    AppMethodBeat.i(109346);
    if ((parambtp != null) && (parambtp.TdM != null) && (parambtp.TdM.size() > 0))
    {
      if (this.uPv) {
        bool = true;
      }
      showOptionMenu(1001, bool);
      if (this.uPC != null)
      {
        if (this.uPE == null) {
          this.uPE = new ArrayList();
        }
        for (;;)
        {
          if (this.uPD == null) {
            this.uPD = new HashMap();
          }
          this.uPD.clear();
          this.uPE.add(getString(i.h.emoji_store_tag_all));
          parambtp = parambtp.TdM.iterator();
          while (parambtp.hasNext())
          {
            ajl localajl = (ajl)parambtp.next();
            if ((localajl != null) && (!Util.isNullOrNil(localajl.StT)))
            {
              this.uPE.add(localajl.StT);
              this.uPD.put(localajl.StT, Integer.valueOf(localajl.StS));
            }
          }
          this.uPE.clear();
        }
        parambtp = new ArrayList();
        parambtp.add(this.uPz);
        this.uPC.a(parambtp, this.uPE);
        AppMethodBeat.o(109346);
      }
    }
    else
    {
      showOptionMenu(1001, false);
    }
    AppMethodBeat.o(109346);
  }
  
  private void ata()
  {
    AppMethodBeat.i(109342);
    if (this.uPF)
    {
      Log.i("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "need jeep to update page.");
      AppMethodBeat.o(109342);
      return;
    }
    this.uPx = null;
    switch (this.uPp)
    {
    }
    for (;;)
    {
      bG(this.uPx);
      AppMethodBeat.o(109342);
      return;
      this.uPw = p.getEmojiStorageMgr().VFN.bxS("0");
      if ((this.uPw != null) && (this.uPw.TdL != null) && (this.uPr != null))
      {
        a(this.uPw);
        this.uPr.aa(this.uPw.TdL);
      }
      for (;;)
      {
        this.uPv = true;
        com.tencent.mm.plugin.report.service.h.IzE.a(12875, new Object[] { Integer.valueOf(0), "" });
        break;
        auS(getString(i.h.app_waiting));
      }
      showOptionMenu(1001, false);
      this.uPv = false;
      com.tencent.mm.plugin.report.service.h.IzE.a(12875, new Object[] { Integer.valueOf(1), this.uFX });
      continue;
      showOptionMenu(1001, false);
      this.uPz = this.uPi;
      auU(this.uPz);
      this.uPv = false;
      com.tencent.mm.plugin.report.service.h.IzE.a(12875, new Object[] { Integer.valueOf(1), "" });
      continue;
      this.uPz = "";
      auU(this.uFV);
      this.uPv = false;
      com.tencent.mm.plugin.report.service.h.IzE.a(12875, new Object[] { Integer.valueOf(2), "" });
      continue;
      this.uPz = "";
      showOptionMenu(1001, false);
      showOptionMenu(1002, true);
      com.tencent.mm.plugin.report.service.h.IzE.a(12875, new Object[] { Integer.valueOf(3), "" });
    }
  }
  
  private void auS(String paramString)
  {
    AppMethodBeat.i(109343);
    if (isFinishing())
    {
      Log.i("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "[showLoadingDialog] acitivity is finished.");
      AppMethodBeat.o(109343);
      return;
    }
    getString(i.h.app_tip);
    this.mRa = com.tencent.mm.ui.base.h.a(this, paramString, true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(109321);
        if (EmojiStoreV2SingleProductUI.p(EmojiStoreV2SingleProductUI.this) != null) {
          com.tencent.mm.kernel.h.aHF().kcd.a(EmojiStoreV2SingleProductUI.p(EmojiStoreV2SingleProductUI.this));
        }
        AppMethodBeat.o(109321);
      }
    });
    AppMethodBeat.o(109343);
  }
  
  private void auU(String paramString)
  {
    AppMethodBeat.i(109347);
    if ((this.uPs != null) && (this.uPt != null)) {
      switch (this.uPp)
      {
      }
    }
    for (;;)
    {
      if (Util.isNullOrNil(paramString))
      {
        this.uPt.setText("");
        this.uPt.setVisibility(8);
        this.uPs.setVisibility(8);
      }
      AppMethodBeat.o(109347);
      return;
      if (!Util.isNullOrNil(paramString))
      {
        this.uPt.setText(getString(i.h.emoji_store_tag_tip, new Object[] { paramString }));
        this.uPt.setVisibility(0);
        this.uPs.setVisibility(0);
        continue;
        if (!Util.isNullOrNil(paramString))
        {
          this.uPt.setText(getString(i.h.emoji_store_search_tip, new Object[] { paramString }));
          this.uPt.setVisibility(0);
          this.uPs.setVisibility(0);
        }
      }
    }
  }
  
  private void bG(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(109345);
    this.uPx = null;
    switch (this.uPp)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(109345);
      return;
      paramArrayOfByte = new com.tencent.mm.plugin.emoji.f.i(1, this.uNg, this.uPh, this.uFV, this.uPj, paramArrayOfByte);
      com.tencent.mm.kernel.h.aHF().kcd.a(paramArrayOfByte, 0);
      AppMethodBeat.o(109345);
      return;
      paramArrayOfByte = new com.tencent.mm.plugin.emoji.f.i(2, this.uNg, this.uPh, this.uFV, this.uPj, paramArrayOfByte);
      com.tencent.mm.kernel.h.aHF().kcd.a(paramArrayOfByte, 0);
      AppMethodBeat.o(109345);
      return;
      paramArrayOfByte = new com.tencent.mm.plugin.emoji.f.i(3, this.uNg, this.uPh, this.uFV, this.uPj, paramArrayOfByte);
      com.tencent.mm.kernel.h.aHF().kcd.a(paramArrayOfByte, 0);
      AppMethodBeat.o(109345);
      return;
      paramArrayOfByte = new com.tencent.mm.plugin.emoji.f.i(4, this.uNg, this.uPh, this.uFV, this.uPj, paramArrayOfByte);
      com.tencent.mm.kernel.h.aHF().kcd.a(paramArrayOfByte, 0);
      AppMethodBeat.o(109345);
      return;
      paramArrayOfByte = new com.tencent.mm.plugin.emoji.f.i(5, this.uNg, this.uPh, this.uFV, this.uPj, paramArrayOfByte);
      com.tencent.mm.kernel.h.aHF().kcd.a(paramArrayOfByte, 0);
    }
  }
  
  private void cVG()
  {
    AppMethodBeat.i(109344);
    if ((this.mRa != null) && (this.mRa.isShowing())) {
      this.mRa.dismiss();
    }
    AppMethodBeat.o(109344);
  }
  
  private void cWN()
  {
    AppMethodBeat.i(109348);
    if (!this.isLoading)
    {
      bG(this.uPx);
      this.isLoading = true;
      this.mHandler.sendEmptyMessageDelayed(1002, 200L);
    }
    AppMethodBeat.o(109348);
  }
  
  private void cWO()
  {
    AppMethodBeat.i(109350);
    Toast.makeText(getContext(), getString(i.h.emoji_unknow), 0).show();
    AppMethodBeat.o(109350);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return i.f.emoji_store_v2_single_product_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(109340);
    if ((this.uPp == 6) && (!Util.isNullOrNil(this.uPk))) {
      setMMTitle(this.uPk);
    }
    for (;;)
    {
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(109327);
          boolean bool;
          if ((EmojiStoreV2SingleProductUI.f(EmojiStoreV2SingleProductUI.this) != null) && (EmojiStoreV2SingleProductUI.f(EmojiStoreV2SingleProductUI.this).getVisibility() == 0))
          {
            EmojiStoreV2SingleProductUI.f(EmojiStoreV2SingleProductUI.this).setVisibility(8);
            paramAnonymousMenuItem = EmojiStoreV2SingleProductUI.this;
            if (EmojiStoreV2SingleProductUI.g(EmojiStoreV2SingleProductUI.this))
            {
              bool = true;
              paramAnonymousMenuItem.showOptionMenu(1001, bool);
              EmojiStoreV2SingleProductUI.this.setMMTitle(i.h.emoji_store_product_title);
            }
          }
          for (;;)
          {
            AppMethodBeat.o(109327);
            return false;
            bool = false;
            break;
            EmojiStoreV2SingleProductUI.this.finish();
          }
        }
      });
      this.uPr = new a(getContext());
      this.uPr.uQu = new a.a()
      {
        public final void Jx(int paramAnonymousInt)
        {
          AppMethodBeat.i(109328);
          if ((EmojiStoreV2SingleProductUI.h(EmojiStoreV2SingleProductUI.this) != null) && (EmojiStoreV2SingleProductUI.c(EmojiStoreV2SingleProductUI.this) != null))
          {
            aji localaji = EmojiStoreV2SingleProductUI.c(EmojiStoreV2SingleProductUI.this).JN(paramAnonymousInt);
            if (localaji != null) {
              try
              {
                Intent localIntent = new Intent();
                localIntent.putExtra("Select_Conv_User", EmojiStoreV2SingleProductUI.i(EmojiStoreV2SingleProductUI.this));
                localIntent.putExtra("extra_object", localaji.toByteArray());
                localIntent.putExtra("scene", EmojiStoreV2SingleProductUI.j(EmojiStoreV2SingleProductUI.this));
                localIntent.putExtra("searchID", EmojiStoreV2SingleProductUI.k(EmojiStoreV2SingleProductUI.this));
                localIntent.putExtra("add_source", 5);
                localIntent.putExtra("entrance_scene", 29);
                localIntent.setClass(EmojiStoreV2SingleProductUI.this.getContext(), EmojiStoreV2SingleProductDialogUI.class);
                EmojiStoreV2SingleProductUI.this.startActivityForResult(localIntent, 5001);
                EmojiStoreV2SingleProductUI.this.overridePendingTransition(i.a.pop_in, i.a.pop_out);
                com.tencent.mm.plugin.report.service.h.IzE.a(12787, new Object[] { Integer.valueOf(EmojiStoreV2SingleProductUI.j(EmojiStoreV2SingleProductUI.this)), Integer.valueOf(0), localaji.Md5, Long.valueOf(EmojiStoreV2SingleProductUI.k(EmojiStoreV2SingleProductUI.this)), localaji.DesignerID, localaji.ProductID, Integer.valueOf(29) });
                AppMethodBeat.o(109328);
                return;
              }
              catch (Exception localException) {}
            }
          }
          AppMethodBeat.o(109328);
        }
      };
      this.uPq = ((PreViewListGridView)findViewById(i.e.list));
      this.mL = ad.kS(getContext()).inflate(i.f.emoji_store_v2_mgr_header, null);
      this.uPs = this.mL.findViewById(i.e.emoji_mgr);
      this.uPt = ((TextView)this.mL.findViewById(i.e.emoji_tag));
      this.uPq.addHeaderView(this.mL);
      this.uPu = ad.kS(getContext()).inflate(i.f.emoji_store_load_more, null);
      this.uPq.addFooterView(this.uPu);
      this.uPu.setVisibility(8);
      this.uPq.setAdapter(this.uPr);
      this.uPq.setOnScrollListener(this);
      this.uNF = ((MMPullDownView)findViewById(i.e.load_more_view));
      this.uNF.setTopViewVisible(false);
      this.uNF.setOnBottomLoadDataListener(this.uPH);
      this.uNF.setAtBottomCallBack(this.uPI);
      this.uNF.setBottomViewVisible(false);
      this.uNF.setIsBottomShowAll(false);
      this.uNF.setIsReturnSuperDispatchWhenCancel(true);
      this.uPA = ((LabelContainerView)findViewById(i.e.select_contact_label_container));
      this.uPB = ((TextView)this.uPA.findViewById(16908310));
      this.uPB.setText(i.h.label_panel_search_by);
      this.uPC = ((MMTagPanel)this.uPA.findViewById(i.e.contact_label_panel));
      this.uPC.setTagSelectedBG(i.d.tag_green_tab_selector);
      this.uPC.setTagSelectedTextColorRes(i.b.wechat_green);
      this.uPz = getString(i.h.emoji_store_tag_all);
      this.uPA.setOnLabelContainerListener(new LabelContainerView.a()
      {
        public final void cWP()
        {
          AppMethodBeat.i(109329);
          if (EmojiStoreV2SingleProductUI.f(EmojiStoreV2SingleProductUI.this) != null) {
            EmojiStoreV2SingleProductUI.f(EmojiStoreV2SingleProductUI.this).clearFocus();
          }
          EmojiStoreV2SingleProductUI.f(EmojiStoreV2SingleProductUI.this).requestFocus();
          EmojiStoreV2SingleProductUI.f(EmojiStoreV2SingleProductUI.this).setVisibility(8);
          EmojiStoreV2SingleProductUI localEmojiStoreV2SingleProductUI = EmojiStoreV2SingleProductUI.this;
          if (EmojiStoreV2SingleProductUI.g(EmojiStoreV2SingleProductUI.this)) {}
          for (boolean bool = true;; bool = false)
          {
            localEmojiStoreV2SingleProductUI.showOptionMenu(1001, bool);
            EmojiStoreV2SingleProductUI.this.setMMTitle(i.h.emoji_store_product_title);
            AppMethodBeat.o(109329);
            return;
          }
        }
        
        public final void cWQ()
        {
          AppMethodBeat.i(109330);
          EmojiStoreV2SingleProductUI.this.hideVKB();
          AppMethodBeat.o(109330);
        }
      });
      this.uPC.setCallBack(new MMTagPanel.a()
      {
        public final void I(boolean paramAnonymousBoolean, int paramAnonymousInt) {}
        
        public final void auV(String paramAnonymousString)
        {
          AppMethodBeat.i(109331);
          if ((!Util.isNullOrNil(EmojiStoreV2SingleProductUI.l(EmojiStoreV2SingleProductUI.this))) && (!Util.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.equals(EmojiStoreV2SingleProductUI.l(EmojiStoreV2SingleProductUI.this)))) {
            EmojiStoreV2SingleProductUI.m(EmojiStoreV2SingleProductUI.this).dy(EmojiStoreV2SingleProductUI.l(EmojiStoreV2SingleProductUI.this), true);
          }
          AppMethodBeat.o(109331);
        }
        
        public final void auW(String paramAnonymousString)
        {
          AppMethodBeat.i(109332);
          EmojiStoreV2SingleProductUI.a(EmojiStoreV2SingleProductUI.this, paramAnonymousString);
          AppMethodBeat.o(109332);
        }
        
        public final void auX(String paramAnonymousString) {}
        
        public final void auY(String paramAnonymousString) {}
        
        public final void auZ(String paramAnonymousString) {}
        
        public final void cWR() {}
      });
      addIconOptionMenu(1001, i.d.actionbar_emotag_icon, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(109333);
          if (EmojiStoreV2SingleProductUI.f(EmojiStoreV2SingleProductUI.this) != null)
          {
            EmojiStoreV2SingleProductUI.f(EmojiStoreV2SingleProductUI.this).setVisibility(0);
            paramAnonymousMenuItem = new ArrayList();
            paramAnonymousMenuItem.add(EmojiStoreV2SingleProductUI.l(EmojiStoreV2SingleProductUI.this));
            EmojiStoreV2SingleProductUI.m(EmojiStoreV2SingleProductUI.this).a(paramAnonymousMenuItem, EmojiStoreV2SingleProductUI.n(EmojiStoreV2SingleProductUI.this));
            EmojiStoreV2SingleProductUI.this.setMMTitle(i.h.emoji_store_seach_by_tag);
            EmojiStoreV2SingleProductUI.this.showOptionMenu(1001, false);
            com.tencent.mm.plugin.report.service.h.IzE.kvStat(12788, "1");
          }
          AppMethodBeat.o(109333);
          return false;
        }
      });
      addIconOptionMenu(1002, i.g.icons_outlined_share, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(109320);
          Log.d("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "on shard click.");
          EmojiStoreV2SingleProductUI.o(EmojiStoreV2SingleProductUI.this);
          AppMethodBeat.o(109320);
          return true;
        }
      });
      showOptionMenu(1001, false);
      showOptionMenu(1002, false);
      AppMethodBeat.o(109340);
      return;
      setMMTitle(i.h.emoji_store_product_title);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(109339);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(109339);
      return;
      if (paramInt2 == -1)
      {
        b.r(this, getContext().getString(i.h.app_sent));
        continue;
        if (paramInt2 == -1)
        {
          String str1 = paramIntent.getStringExtra("Select_Conv_User");
          if (!Util.isNullOrNil(str1))
          {
            Log.d("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "..".concat(String.valueOf(str1)));
            int i = this.uPj;
            String str2 = this.uPk;
            String str3 = this.uPm;
            String str4 = this.uPl;
            String str5 = this.uPn;
            int j = this.uPp;
            p.cUO();
            com.tencent.mm.plugin.emoji.e.j.a(this, str1, 27, i, str2, str3, str4, str5, j, com.tencent.mm.plugin.emoji.e.f.cUn());
          }
        }
      }
    }
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(109341);
    if ((this.uPA != null) && (this.uPA.getVisibility() == 0))
    {
      this.uPA.setVisibility(8);
      if (this.uPv) {}
      for (boolean bool = true;; bool = false)
      {
        showOptionMenu(1001, bool);
        setMMTitle(i.h.emoji_store_product_title);
        AppMethodBeat.o(109341);
        return;
      }
    }
    super.onBackPressed();
    AppMethodBeat.o(109341);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(109335);
    super.onCreate(paramBundle);
    this.uNg = getIntent().getIntExtra("uin", 0);
    this.iSn = getIntent().getStringExtra("Select_Conv_User");
    this.uEM = getIntent().getLongExtra("searchID", 0L);
    this.uFX = getIntent().getStringExtra("id");
    paramBundle = getIntent().getStringExtra("tag_id");
    if (!Util.isNullOrNil(paramBundle)) {}
    try
    {
      this.uPh = Integer.valueOf(paramBundle).intValue();
      this.uPi = getIntent().getStringExtra("tag_desc");
      this.uFV = getIntent().getStringExtra("keyword");
      this.uPj = getIntent().getIntExtra("set_id", 0);
      this.uPk = getIntent().getStringExtra("set_title");
      this.uPl = getIntent().getStringExtra("set_iconURL");
      this.uPm = getIntent().getStringExtra("set_desc");
      this.uPn = getIntent().getStringExtra("headurl");
      this.uPo = getIntent().getStringExtra("sns_object_data");
      this.uPp = getIntent().getIntExtra("pageType", 0);
      if (!Util.isNullOrNil(this.uPo))
      {
        this.uPj = EmojiLogic.auC(this.uPo);
        this.uPk = EmojiLogic.auD(this.uPo);
        this.uPl = EmojiLogic.auF(this.uPo);
        this.uPm = EmojiLogic.auE(this.uPo);
        this.uPn = EmojiLogic.auG(this.uPo);
        this.uPp = EmojiLogic.auH(this.uPo);
      }
      switch (this.uPp)
      {
      default: 
        this.uPF = true;
        if (this.uPF)
        {
          paramBundle = new Intent();
          p.cUO();
          paramBundle.putExtra("rawUrl", com.tencent.mm.plugin.emoji.e.f.cUn());
          paramBundle.putExtra("showShare", false);
          com.tencent.mm.by.c.b(this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramBundle);
          finish();
        }
        initView();
        if ((this.uNg == 0) && (this.uPp == 2))
        {
          paramBundle = p.getEmojiStorageMgr().VFN.bxR(this.uFX);
          if ((paramBundle != null) && (paramBundle.TdN != null) && (paramBundle.TdN.TdG != 0) && (!Util.isNullOrNil(paramBundle.TdN.CMP)))
          {
            this.uNg = paramBundle.TdN.TdG;
            Log.i("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "uin:%s ", new Object[] { Integer.valueOf(this.uNg) });
          }
        }
        else
        {
          i = 0;
          if (i != 0) {
            break label774;
          }
          ata();
          com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VgQ, Boolean.FALSE);
          com.tencent.mm.kernel.h.aHF().kcd.a(821, this);
          com.tencent.mm.kernel.h.aHF().kcd.a(239, this);
          AppMethodBeat.o(109335);
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
        Log.e("MicroMsg.emoji.EmojiStoreV2SingleProductUI", Util.stackTraceToString(paramBundle));
        continue;
        if (!Util.isNullOrNil(this.uFV))
        {
          this.uPp = 5;
          this.uPv = false;
          this.mScene = 2;
        }
        else if (!Util.isNullOrNil(this.uFX))
        {
          this.uPp = 2;
          this.mScene = 1;
        }
        else if (this.uNg != 0)
        {
          this.uPp = 3;
          this.mScene = 1;
        }
        else if (this.uPh != 0)
        {
          this.mScene = 3;
          this.uPp = 4;
        }
        else if (this.uPj > 0)
        {
          this.uPp = 6;
          this.mScene = 4;
        }
        else
        {
          this.uPp = 1;
          this.mScene = 0;
          continue;
          this.mScene = 0;
          continue;
          if (Util.isNullOrNil(this.uFX))
          {
            continue;
            if (this.uNg == 0)
            {
              continue;
              if (this.uPh == 0)
              {
                continue;
                if (Util.isNullOrNil(this.uFV))
                {
                  continue;
                  if (this.uPj == 0)
                  {
                    continue;
                    i = 1;
                    continue;
                    label774:
                    this.uNH = new com.tencent.mm.plugin.emoji.f.j(this.uFX);
                    com.tencent.mm.kernel.h.aHF().kcd.a(this.uNH, 0);
                    auS(getString(i.h.app_waiting));
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
    AppMethodBeat.i(109338);
    com.tencent.mm.kernel.h.aHF().kcd.b(239, this);
    com.tencent.mm.kernel.h.aHF().kcd.b(821, this);
    super.onDestroy();
    AppMethodBeat.o(109338);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(109337);
    super.onPause();
    EventCenter.instance.removeListener(this.uPG);
    AppMethodBeat.o(109337);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(109336);
    super.onResume();
    EventCenter.instance.addListener(this.uPG);
    AppMethodBeat.o(109336);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(109351);
    int i = paramq.getType();
    if (i == 821)
    {
      cVG();
      paramString = (com.tencent.mm.plugin.emoji.f.i)paramq;
      paramq = paramString.cVb();
      this.isLoading = false;
      if (this.uPu != null)
      {
        this.uPu.setVisibility(8);
        this.mHandler.removeMessages(1002);
        this.mHandler.sendEmptyMessageDelayed(1001, 200L);
      }
      i = paramString.mWz;
      if (((paramInt1 == 0) && (paramInt2 == 0)) || ((paramInt1 == 4) && ((paramInt2 == 2) || (paramInt2 == 3)) && ((this.uPx == null) || (this.uPx.length <= 0)) && (i != 3))) {
        a(paramq);
      }
      if ((paramInt1 == 0) || (paramInt1 == 4))
      {
        this.uPx = paramString.uFT;
        if (paramInt2 == 0)
        {
          Y(paramq.TdL);
          this.uPy = 0;
          AppMethodBeat.o(109351);
          return;
        }
        if (paramInt2 == 2)
        {
          Y(paramq.TdL);
          this.uPy = 2;
          AppMethodBeat.o(109351);
          return;
        }
        if (paramInt2 == 3)
        {
          this.uPy = -1;
          Y(paramq.TdL);
          AppMethodBeat.o(109351);
          return;
        }
        cWO();
        AppMethodBeat.o(109351);
        return;
      }
      cWO();
      AppMethodBeat.o(109351);
      return;
    }
    if (i == 239)
    {
      cVG();
      if ((paramInt2 == 0) && (paramInt1 == 0))
      {
        paramString = ((com.tencent.mm.plugin.emoji.f.j)paramq).cVc();
        if ((paramString != null) && (paramString.TdN != null))
        {
          this.uNg = paramString.TdN.TdG;
          if (this.mHandler != null) {
            this.mHandler.sendEmptyMessage(1004);
          }
        }
        AppMethodBeat.o(109351);
        return;
      }
      showOptionMenu(1001, false);
      com.tencent.mm.ui.base.h.c(getContext(), getString(i.h.emoji_designer_load_failed), null, true);
      Log.e("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "open single product ui failed.");
    }
    AppMethodBeat.o(109351);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(109352);
    if ((paramInt == 0) && (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1) && (this.uPy == 2) && (!this.isLoading))
    {
      Log.d("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "No More List.");
      cWN();
      Log.i("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "[onScrollStateChanged] startLoadRemoteEmoji.");
    }
    if ((paramInt != 0) && (this.uPq != null)) {
      this.uPq.cWX();
    }
    AppMethodBeat.o(109352);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductUI
 * JD-Core Version:    0.7.0.1
 */