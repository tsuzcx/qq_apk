package com.tencent.mm.plugin.emoji.ui.v2;

import android.app.ProgressDialog;
import android.content.Context;
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
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.a.eb;
import com.tencent.mm.plugin.emoji.h.a;
import com.tencent.mm.plugin.emoji.h.b;
import com.tencent.mm.plugin.emoji.h.d;
import com.tencent.mm.plugin.emoji.h.e;
import com.tencent.mm.plugin.emoji.h.f;
import com.tencent.mm.plugin.emoji.h.g;
import com.tencent.mm.plugin.emoji.h.h;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.ui.v3.EmojiStoreV3SingleProductAlbumUI;
import com.tencent.mm.protocal.protobuf.amn;
import com.tencent.mm.protocal.protobuf.ams;
import com.tencent.mm.protocal.protobuf.cii;
import com.tencent.mm.protocal.protobuf.cik;
import com.tencent.mm.protocal.protobuf.gok;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.c;
import com.tencent.mm.ui.base.MMPullDownView.e;
import com.tencent.mm.ui.base.MMTagPanel;
import com.tencent.mm.ui.base.MMTagPanel.a;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
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
  implements AbsListView.OnScrollListener, com.tencent.mm.am.h
{
  private boolean isLoading;
  private String luk;
  private MMHandler mHandler;
  private int mScene;
  private View nJ;
  private ProgressDialog pNH;
  private long xNo;
  private String xOA;
  private String xOy;
  private int xVO;
  private MMPullDownView xWp;
  private com.tencent.mm.plugin.emoji.e.j xWr;
  private int xXR;
  private String xXS;
  private int xXT;
  private String xXU;
  private String xXV;
  private String xXW;
  private String xXX;
  private String xXY;
  private int xXZ;
  private PreViewListGridView xYa;
  private a xYb;
  private View xYc;
  private TextView xYd;
  private View xYe;
  private boolean xYf;
  private cii xYg;
  private byte[] xYh;
  private int xYi;
  private String xYj;
  private LabelContainerView xYk;
  private TextView xYl;
  private MMTagPanel xYm;
  private HashMap<String, Integer> xYn;
  private ArrayList<String> xYo;
  private boolean xYp;
  private boolean xYq;
  private IListener xYr;
  private MMPullDownView.e xYs;
  private MMPullDownView.c xYt;
  
  public EmojiStoreV2SingleProductUI()
  {
    AppMethodBeat.i(109334);
    this.xVO = 0;
    this.xXT = -1;
    this.xXZ = 0;
    this.xYf = true;
    this.xYi = -1;
    this.isLoading = false;
    this.xYn = new HashMap();
    this.xYp = false;
    this.xYq = false;
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
    this.xYr = new IListener(com.tencent.mm.app.f.hfK) {};
    this.xYs = new MMPullDownView.e()
    {
      public final boolean dso()
      {
        AppMethodBeat.i(109326);
        Log.i("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "onBottom");
        EmojiStoreV2SingleProductUI.e(EmojiStoreV2SingleProductUI.this);
        AppMethodBeat.o(109326);
        return true;
      }
    };
    this.xYt = new MMPullDownView.c()
    {
      public final boolean dsq()
      {
        return false;
      }
    };
    AppMethodBeat.o(109334);
  }
  
  private void a(cii paramcii)
  {
    boolean bool = false;
    AppMethodBeat.i(109346);
    if ((paramcii != null) && (paramcii.aara != null) && (paramcii.aara.size() > 0))
    {
      if (this.xYf) {
        bool = true;
      }
      showOptionMenu(1001, bool);
      if (this.xYm != null)
      {
        if (this.xYo == null) {
          this.xYo = new ArrayList();
        }
        for (;;)
        {
          if (this.xYn == null) {
            this.xYn = new HashMap();
          }
          this.xYn.clear();
          this.xYo.add(getString(h.h.emoji_store_tag_all));
          paramcii = paramcii.aara.iterator();
          while (paramcii.hasNext())
          {
            ams localams = (ams)paramcii.next();
            if ((localams != null) && (!Util.isNullOrNil(localams.ZtH)))
            {
              this.xYo.add(localams.ZtH);
              this.xYn.put(localams.ZtH, Integer.valueOf(localams.ZtG));
            }
          }
          this.xYo.clear();
        }
        paramcii = new ArrayList();
        paramcii.add(this.xYj);
        this.xYm.a(paramcii, this.xYo);
        AppMethodBeat.o(109346);
      }
    }
    else
    {
      showOptionMenu(1001, false);
    }
    AppMethodBeat.o(109346);
  }
  
  private void aNi()
  {
    AppMethodBeat.i(109342);
    if (this.xYp)
    {
      Log.i("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "need jeep to update page.");
      AppMethodBeat.o(109342);
      return;
    }
    if (this.xYq)
    {
      Log.i("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "need jeep to enter V3 SingleProductPage");
      AppMethodBeat.o(109342);
      return;
    }
    this.xYh = null;
    switch (this.xXZ)
    {
    }
    for (;;)
    {
      bG(this.xYh);
      AppMethodBeat.o(109342);
      return;
      this.xYg = com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adjB.bzi("0");
      if ((this.xYg != null) && (this.xYg.aaqZ != null) && (this.xYb != null))
      {
        a(this.xYg);
        this.xYb.bz(this.xYg.aaqZ);
      }
      for (;;)
      {
        this.xYf = true;
        com.tencent.mm.plugin.report.service.h.OAn.b(12875, new Object[] { Integer.valueOf(0), "" });
        break;
        aoR(getString(h.h.app_waiting));
      }
      showOptionMenu(1001, false);
      this.xYf = false;
      com.tencent.mm.plugin.report.service.h.OAn.b(12875, new Object[] { Integer.valueOf(1), this.xOA });
      continue;
      showOptionMenu(1001, false);
      this.xYj = this.xXS;
      aoS(this.xYj);
      this.xYf = false;
      com.tencent.mm.plugin.report.service.h.OAn.b(12875, new Object[] { Integer.valueOf(1), "" });
      continue;
      this.xYj = "";
      aoS(this.xOy);
      this.xYf = false;
      com.tencent.mm.plugin.report.service.h.OAn.b(12875, new Object[] { Integer.valueOf(2), "" });
      continue;
      this.xYj = "";
      showOptionMenu(1001, false);
      showOptionMenu(1002, true);
      com.tencent.mm.plugin.report.service.h.OAn.b(12875, new Object[] { Integer.valueOf(3), "" });
    }
  }
  
  private void ab(LinkedList<amn> paramLinkedList)
  {
    AppMethodBeat.i(109349);
    if ((this.xYb != null) && (paramLinkedList != null))
    {
      if (this.xYi == -1)
      {
        this.xYb.bz(paramLinkedList);
        AppMethodBeat.o(109349);
        return;
      }
      a locala = this.xYb;
      if (locala.xGG == null) {
        locala.xGG = new ArrayList();
      }
      locala.xGG.addAll(paramLinkedList);
      locala.notifyDataSetChanged();
    }
    AppMethodBeat.o(109349);
  }
  
  private void aoR(String paramString)
  {
    AppMethodBeat.i(109343);
    if (isFinishing())
    {
      Log.i("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "[showLoadingDialog] acitivity is finished.");
      AppMethodBeat.o(109343);
      return;
    }
    getString(h.h.app_tip);
    this.pNH = com.tencent.mm.ui.base.k.a(this, paramString, true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(109321);
        if (EmojiStoreV2SingleProductUI.p(EmojiStoreV2SingleProductUI.this) != null) {
          com.tencent.mm.kernel.h.baD().mCm.a(EmojiStoreV2SingleProductUI.p(EmojiStoreV2SingleProductUI.this));
        }
        AppMethodBeat.o(109321);
      }
    });
    AppMethodBeat.o(109343);
  }
  
  private void aoS(String paramString)
  {
    AppMethodBeat.i(109347);
    if ((this.xYc != null) && (this.xYd != null)) {
      switch (this.xXZ)
      {
      }
    }
    for (;;)
    {
      if (Util.isNullOrNil(paramString))
      {
        this.xYd.setText("");
        this.xYd.setVisibility(8);
        this.xYc.setVisibility(8);
      }
      AppMethodBeat.o(109347);
      return;
      if (!Util.isNullOrNil(paramString))
      {
        this.xYd.setText(getString(h.h.emoji_store_tag_tip, new Object[] { paramString }));
        this.xYd.setVisibility(0);
        this.xYc.setVisibility(0);
        continue;
        if (!Util.isNullOrNil(paramString))
        {
          this.xYd.setText(getString(h.h.emoji_store_search_tip, new Object[] { paramString }));
          this.xYd.setVisibility(0);
          this.xYc.setVisibility(0);
        }
      }
    }
  }
  
  private void bG(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(109345);
    this.xYh = null;
    switch (this.xXZ)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(109345);
      return;
      paramArrayOfByte = new com.tencent.mm.plugin.emoji.e.i(1, this.xVO, this.xXR, this.xOy, this.xXT, paramArrayOfByte);
      com.tencent.mm.kernel.h.baD().mCm.a(paramArrayOfByte, 0);
      AppMethodBeat.o(109345);
      return;
      paramArrayOfByte = new com.tencent.mm.plugin.emoji.e.i(2, this.xVO, this.xXR, this.xOy, this.xXT, paramArrayOfByte);
      com.tencent.mm.kernel.h.baD().mCm.a(paramArrayOfByte, 0);
      AppMethodBeat.o(109345);
      return;
      paramArrayOfByte = new com.tencent.mm.plugin.emoji.e.i(3, this.xVO, this.xXR, this.xOy, this.xXT, paramArrayOfByte);
      com.tencent.mm.kernel.h.baD().mCm.a(paramArrayOfByte, 0);
      AppMethodBeat.o(109345);
      return;
      paramArrayOfByte = new com.tencent.mm.plugin.emoji.e.i(4, this.xVO, this.xXR, this.xOy, this.xXT, paramArrayOfByte);
      com.tencent.mm.kernel.h.baD().mCm.a(paramArrayOfByte, 0);
      AppMethodBeat.o(109345);
      return;
      paramArrayOfByte = new com.tencent.mm.plugin.emoji.e.i(5, this.xVO, this.xXR, this.xOy, this.xXT, paramArrayOfByte);
      com.tencent.mm.kernel.h.baD().mCm.a(paramArrayOfByte, 0);
    }
  }
  
  private void dCt()
  {
    AppMethodBeat.i(109348);
    if (!this.isLoading)
    {
      bG(this.xYh);
      this.isLoading = true;
      this.mHandler.sendEmptyMessageDelayed(1002, 200L);
    }
    AppMethodBeat.o(109348);
  }
  
  private void dCu()
  {
    AppMethodBeat.i(109350);
    Toast.makeText(getContext(), getString(h.h.emoji_unknow), 0).show();
    AppMethodBeat.o(109350);
  }
  
  private void dismissLoadingDialog()
  {
    AppMethodBeat.i(109344);
    if ((this.pNH != null) && (this.pNH.isShowing())) {
      this.pNH.dismiss();
    }
    AppMethodBeat.o(109344);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return h.f.emoji_store_v2_single_product_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(109340);
    if ((this.xXZ == 6) && (!Util.isNullOrNil(this.xXU))) {
      setMMTitle(this.xXU);
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
              EmojiStoreV2SingleProductUI.this.setMMTitle(h.h.emoji_store_product_title);
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
      this.xYb = new a(getContext());
      this.xYb.xZf = new a.a()
      {
        public final void Kf(int paramAnonymousInt)
        {
          AppMethodBeat.i(109328);
          if ((EmojiStoreV2SingleProductUI.h(EmojiStoreV2SingleProductUI.this) != null) && (EmojiStoreV2SingleProductUI.c(EmojiStoreV2SingleProductUI.this) != null))
          {
            amn localamn = EmojiStoreV2SingleProductUI.c(EmojiStoreV2SingleProductUI.this).Ky(paramAnonymousInt);
            if (localamn != null) {
              try
              {
                Intent localIntent = new Intent();
                localIntent.putExtra("Select_Conv_User", EmojiStoreV2SingleProductUI.i(EmojiStoreV2SingleProductUI.this));
                localIntent.putExtra("extra_object", localamn.toByteArray());
                localIntent.putExtra("scene", EmojiStoreV2SingleProductUI.j(EmojiStoreV2SingleProductUI.this));
                localIntent.putExtra("searchID", EmojiStoreV2SingleProductUI.k(EmojiStoreV2SingleProductUI.this));
                localIntent.putExtra("add_source", 5);
                localIntent.putExtra("entrance_scene", 29);
                localIntent.setClass(EmojiStoreV2SingleProductUI.this.getContext(), EmojiStoreV2SingleProductDialogUI.class);
                EmojiStoreV2SingleProductUI.this.startActivityForResult(localIntent, 5001);
                EmojiStoreV2SingleProductUI.this.overridePendingTransition(h.a.pop_in, h.a.pop_out);
                com.tencent.mm.plugin.report.service.h.OAn.b(12787, new Object[] { Integer.valueOf(EmojiStoreV2SingleProductUI.j(EmojiStoreV2SingleProductUI.this)), Integer.valueOf(0), localamn.Md5, Long.valueOf(EmojiStoreV2SingleProductUI.k(EmojiStoreV2SingleProductUI.this)), localamn.DesignerID, localamn.ProductID, Integer.valueOf(29) });
                AppMethodBeat.o(109328);
                return;
              }
              catch (Exception localException) {}
            }
          }
          AppMethodBeat.o(109328);
        }
      };
      this.xYa = ((PreViewListGridView)findViewById(h.e.list));
      this.nJ = af.mU(getContext()).inflate(h.f.emoji_store_v2_mgr_header, null);
      this.xYc = this.nJ.findViewById(h.e.emoji_mgr);
      this.xYd = ((TextView)this.nJ.findViewById(h.e.emoji_tag));
      this.xYa.addHeaderView(this.nJ);
      this.xYe = af.mU(getContext()).inflate(h.f.emoji_store_load_more, null);
      this.xYa.addFooterView(this.xYe);
      this.xYe.setVisibility(8);
      this.xYa.setAdapter(this.xYb);
      this.xYa.setOnScrollListener(this);
      this.xWp = ((MMPullDownView)findViewById(h.e.load_more_view));
      this.xWp.setTopViewVisible(false);
      this.xWp.setOnBottomLoadDataListener(this.xYs);
      this.xWp.setAtBottomCallBack(this.xYt);
      this.xWp.setBottomViewVisible(false);
      this.xWp.setIsBottomShowAll(false);
      this.xWp.setIsReturnSuperDispatchWhenCancel(true);
      this.xYk = ((LabelContainerView)findViewById(h.e.select_contact_label_container));
      this.xYl = ((TextView)this.xYk.findViewById(16908310));
      this.xYl.setText(h.h.label_panel_search_by);
      this.xYm = ((MMTagPanel)this.xYk.findViewById(h.e.contact_label_panel));
      this.xYm.setTagSelectedBG(h.d.tag_green_tab_selector);
      this.xYm.setTagSelectedTextColorRes(h.b.wechat_green);
      this.xYj = getString(h.h.emoji_store_tag_all);
      this.xYk.setOnLabelContainerListener(new LabelContainerView.a()
      {
        public final void dCv()
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
            EmojiStoreV2SingleProductUI.this.setMMTitle(h.h.emoji_store_product_title);
            AppMethodBeat.o(109329);
            return;
          }
        }
        
        public final void dCw()
        {
          AppMethodBeat.i(109330);
          EmojiStoreV2SingleProductUI.this.hideVKB();
          AppMethodBeat.o(109330);
        }
      });
      this.xYm.setCallBack(new MMTagPanel.a()
      {
        public final void G(boolean paramAnonymousBoolean, int paramAnonymousInt) {}
        
        public final void aoT(String paramAnonymousString)
        {
          AppMethodBeat.i(109331);
          if ((!Util.isNullOrNil(EmojiStoreV2SingleProductUI.l(EmojiStoreV2SingleProductUI.this))) && (!Util.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.equals(EmojiStoreV2SingleProductUI.l(EmojiStoreV2SingleProductUI.this)))) {
            EmojiStoreV2SingleProductUI.m(EmojiStoreV2SingleProductUI.this).eg(EmojiStoreV2SingleProductUI.l(EmojiStoreV2SingleProductUI.this), true);
          }
          AppMethodBeat.o(109331);
        }
        
        public final void aoU(String paramAnonymousString)
        {
          AppMethodBeat.i(109332);
          EmojiStoreV2SingleProductUI.a(EmojiStoreV2SingleProductUI.this, paramAnonymousString);
          AppMethodBeat.o(109332);
        }
        
        public final void aoV(String paramAnonymousString) {}
        
        public final void aoW(String paramAnonymousString) {}
        
        public final void aoX(String paramAnonymousString) {}
        
        public final void dCx() {}
      });
      addIconOptionMenu(1001, h.d.actionbar_emotag_icon, new MenuItem.OnMenuItemClickListener()
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
            EmojiStoreV2SingleProductUI.this.setMMTitle(h.h.emoji_store_seach_by_tag);
            EmojiStoreV2SingleProductUI.this.showOptionMenu(1001, false);
            com.tencent.mm.plugin.report.service.h.OAn.kvStat(12788, "1");
          }
          AppMethodBeat.o(109333);
          return false;
        }
      });
      addIconOptionMenu(1002, h.g.icons_outlined_share, new MenuItem.OnMenuItemClickListener()
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
      setMMTitle(h.h.emoji_store_product_title);
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
        b.u(this, getContext().getString(h.h.app_sent));
        continue;
        if (paramInt2 == -1)
        {
          String str1 = paramIntent.getStringExtra("Select_Conv_User");
          if (!Util.isNullOrNil(str1))
          {
            Log.d("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "..".concat(String.valueOf(str1)));
            int i = this.xXT;
            String str2 = this.xXU;
            String str3 = this.xXW;
            String str4 = this.xXV;
            String str5 = this.xXX;
            int j = this.xXZ;
            com.tencent.mm.plugin.emoji.model.s.dAl();
            com.tencent.mm.plugin.emoji.mgr.j.a(this, str1, 27, i, str2, str3, str4, str5, j, com.tencent.mm.plugin.emoji.mgr.f.dzu());
          }
        }
      }
    }
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(109341);
    if ((this.xYk != null) && (this.xYk.getVisibility() == 0))
    {
      this.xYk.setVisibility(8);
      if (this.xYf) {}
      for (boolean bool = true;; bool = false)
      {
        showOptionMenu(1001, bool);
        setMMTitle(h.h.emoji_store_product_title);
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
    this.xVO = getIntent().getIntExtra("uin", 0);
    this.luk = getIntent().getStringExtra("Select_Conv_User");
    this.xNo = getIntent().getLongExtra("searchID", 0L);
    this.xOA = getIntent().getStringExtra("id");
    paramBundle = getIntent().getStringExtra("tag_id");
    if (!Util.isNullOrNil(paramBundle)) {}
    try
    {
      this.xXR = Integer.valueOf(paramBundle).intValue();
      this.xXS = getIntent().getStringExtra("tag_desc");
      this.xOy = getIntent().getStringExtra("keyword");
      this.xXT = getIntent().getIntExtra("set_id", 0);
      this.xXU = getIntent().getStringExtra("set_title");
      this.xXV = getIntent().getStringExtra("set_iconURL");
      this.xXW = getIntent().getStringExtra("set_desc");
      this.xXX = getIntent().getStringExtra("headurl");
      this.xXY = getIntent().getStringExtra("sns_object_data");
      this.xXZ = getIntent().getIntExtra("pageType", 0);
      if (!Util.isNullOrNil(this.xXY))
      {
        this.xXT = EmojiLogic.aoB(this.xXY);
        this.xXU = EmojiLogic.aoC(this.xXY);
        this.xXV = EmojiLogic.aoE(this.xXY);
        this.xXW = EmojiLogic.aoD(this.xXY);
        this.xXX = EmojiLogic.aoF(this.xXY);
        this.xXZ = EmojiLogic.aoG(this.xXY);
      }
      switch (this.xXZ)
      {
      default: 
        this.xYp = true;
        if (this.xYp)
        {
          paramBundle = new Intent();
          com.tencent.mm.plugin.emoji.model.s.dAl();
          paramBundle.putExtra("rawUrl", com.tencent.mm.plugin.emoji.mgr.f.dzu());
          paramBundle.putExtra("showShare", false);
          com.tencent.mm.br.c.b(this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramBundle);
          finish();
        }
        if (this.xYq)
        {
          i = this.xXT;
          paramBundle = this.xXU;
          String str1 = this.xXW;
          String str2 = this.xXV;
          String str3 = this.xXX;
          Intent localIntent = new Intent();
          localIntent.setClass(this, EmojiStoreV3SingleProductAlbumUI.class);
          localIntent.putExtra("set_id", i);
          localIntent.putExtra("set_title", paramBundle);
          localIntent.putExtra("set_desc", str1);
          localIntent.putExtra("set_iconURL", str2);
          localIntent.putExtra("headurl", str3);
          paramBundle = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
          com.tencent.mm.hellhoundlib.a.a.b(this, paramBundle.aYi(), "com/tencent/mm/plugin/emoji/mgr/EmojiUINavigatorMgr", "startV3SingleProductAlbumUI", "(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramBundle.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/emoji/mgr/EmojiUINavigatorMgr", "startV3SingleProductAlbumUI", "(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.threadpool.h.ahAA.bk(new EmojiStoreV2SingleProductUI..ExternalSyntheticLambda0(this));
        }
        initView();
        if ((this.xVO == 0) && (this.xXZ == 2))
        {
          paramBundle = com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adjB.bzh(this.xOA);
          if ((paramBundle != null) && (paramBundle.aarb != null) && (paramBundle.aarb.ZtX != 0) && (!Util.isNullOrNil(paramBundle.aarb.IGU)))
          {
            this.xVO = paramBundle.aarb.ZtX;
            Log.i("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "uin:%s ", new Object[] { Integer.valueOf(this.xVO) });
          }
        }
        else
        {
          i = 0;
          if (i != 0) {
            break label979;
          }
          aNi();
          com.tencent.mm.kernel.h.baE().ban().set(at.a.acIh, Boolean.FALSE);
          com.tencent.mm.kernel.h.baD().mCm.a(821, this);
          com.tencent.mm.kernel.h.baD().mCm.a(239, this);
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
        if (!Util.isNullOrNil(this.xOy))
        {
          this.xXZ = 5;
          this.xYf = false;
          this.mScene = 2;
        }
        else if (!Util.isNullOrNil(this.xOA))
        {
          this.xXZ = 2;
          this.mScene = 1;
        }
        else if (this.xVO != 0)
        {
          this.xXZ = 3;
          this.mScene = 1;
        }
        else if (this.xXR != 0)
        {
          this.mScene = 3;
          this.xXZ = 4;
        }
        else if (this.xXT > 0)
        {
          this.xXZ = 6;
          this.mScene = 4;
        }
        else
        {
          this.xXZ = 1;
          this.mScene = 0;
          continue;
          this.mScene = 0;
          continue;
          if (Util.isNullOrNil(this.xOA))
          {
            continue;
            if (this.xVO == 0)
            {
              continue;
              if (this.xXR == 0)
              {
                continue;
                if (Util.isNullOrNil(this.xOy))
                {
                  continue;
                  if (this.xXT == 0) {
                    this.xYp = true;
                  }
                  this.xYq = true;
                  continue;
                  i = 1;
                  continue;
                  label979:
                  this.xWr = new com.tencent.mm.plugin.emoji.e.j(this.xOA);
                  com.tencent.mm.kernel.h.baD().mCm.a(this.xWr, 0);
                  aoR(getString(h.h.app_waiting));
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
    com.tencent.mm.kernel.h.baD().mCm.b(239, this);
    com.tencent.mm.kernel.h.baD().mCm.b(821, this);
    super.onDestroy();
    AppMethodBeat.o(109338);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(109337);
    super.onPause();
    this.xYr.dead();
    AppMethodBeat.o(109337);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(109336);
    super.onResume();
    this.xYr.alive();
    AppMethodBeat.o(109336);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(109351);
    int i = paramp.getType();
    if (i == 821)
    {
      dismissLoadingDialog();
      paramString = (com.tencent.mm.plugin.emoji.e.i)paramp;
      paramp = paramString.dAA();
      this.isLoading = false;
      if (this.xYe != null)
      {
        this.xYe.setVisibility(8);
        this.mHandler.removeMessages(1002);
        this.mHandler.sendEmptyMessageDelayed(1001, 200L);
      }
      i = paramString.pTf;
      if (((paramInt1 == 0) && (paramInt2 == 0)) || ((paramInt1 == 4) && ((paramInt2 == 2) || (paramInt2 == 3)) && ((this.xYh == null) || (this.xYh.length <= 0)) && (i != 3))) {
        a(paramp);
      }
      if ((paramInt1 == 0) || (paramInt1 == 4))
      {
        this.xYh = paramString.xOw;
        if (paramInt2 == 0)
        {
          ab(paramp.aaqZ);
          this.xYi = 0;
          AppMethodBeat.o(109351);
          return;
        }
        if (paramInt2 == 2)
        {
          ab(paramp.aaqZ);
          this.xYi = 2;
          AppMethodBeat.o(109351);
          return;
        }
        if (paramInt2 == 3)
        {
          this.xYi = -1;
          ab(paramp.aaqZ);
          AppMethodBeat.o(109351);
          return;
        }
        dCu();
        AppMethodBeat.o(109351);
        return;
      }
      dCu();
      AppMethodBeat.o(109351);
      return;
    }
    if (i == 239)
    {
      dismissLoadingDialog();
      if ((paramInt2 == 0) && (paramInt1 == 0))
      {
        paramString = ((com.tencent.mm.plugin.emoji.e.j)paramp).dAB();
        if ((paramString != null) && (paramString.aarb != null))
        {
          this.xVO = paramString.aarb.ZtX;
          if (this.mHandler != null) {
            this.mHandler.sendEmptyMessage(1004);
          }
        }
        AppMethodBeat.o(109351);
        return;
      }
      showOptionMenu(1001, false);
      com.tencent.mm.ui.base.k.c(getContext(), getString(h.h.emoji_designer_load_failed), null, true);
      Log.e("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "open single product ui failed.");
    }
    AppMethodBeat.o(109351);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(109352);
    if ((paramInt == 0) && (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1) && (this.xYi == 2) && (!this.isLoading))
    {
      Log.d("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "No More List.");
      dCt();
      Log.i("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "[onScrollStateChanged] startLoadRemoteEmoji.");
    }
    if ((paramInt != 0) && (this.xYa != null)) {
      this.xYa.dCD();
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