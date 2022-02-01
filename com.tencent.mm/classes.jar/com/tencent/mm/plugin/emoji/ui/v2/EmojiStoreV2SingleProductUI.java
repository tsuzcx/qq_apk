package com.tencent.mm.plugin.emoji.ui.v2;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.dm;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.protocal.protobuf.PersonalDesigner;
import com.tencent.mm.protocal.protobuf.ait;
import com.tencent.mm.protocal.protobuf.aiw;
import com.tencent.mm.protocal.protobuf.bmg;
import com.tencent.mm.protocal.protobuf.bmi;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.c;
import com.tencent.mm.ui.base.MMPullDownView.e;
import com.tencent.mm.ui.base.MMTagPanel;
import com.tencent.mm.ui.base.MMTagPanel.a;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.contact.LabelContainerView;
import com.tencent.mm.ui.contact.LabelContainerView.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class EmojiStoreV2SingleProductUI
  extends MMActivity
  implements AbsListView.OnScrollListener, com.tencent.mm.ak.i
{
  private View agA;
  private String goe;
  private boolean isLoading;
  private ProgressDialog jZH;
  private MMHandler mHandler;
  private int mScene;
  private long rbH;
  private String rcQ;
  private String rcS;
  private int rjT;
  private MMPullDownView rks;
  private com.tencent.mm.plugin.emoji.f.j rku;
  private int rlV;
  private String rlW;
  private int rlX;
  private String rlY;
  private String rlZ;
  private String rma;
  private String rmb;
  private String rmc;
  private int rmd;
  private PreViewListGridView rme;
  private a rmf;
  private View rmg;
  private TextView rmh;
  private View rmi;
  private boolean rmj;
  private bmg rmk;
  private byte[] rml;
  private int rmm;
  private String rmn;
  private LabelContainerView rmo;
  private TextView rmp;
  private MMTagPanel rmq;
  private HashMap<String, Integer> rmr;
  private ArrayList<String> rms;
  private boolean rmt;
  private IListener rmu;
  private MMPullDownView.e rmv;
  private MMPullDownView.c rmw;
  
  public EmojiStoreV2SingleProductUI()
  {
    AppMethodBeat.i(109334);
    this.rjT = 0;
    this.rlX = -1;
    this.rmd = 0;
    this.rmj = true;
    this.rmm = -1;
    this.isLoading = false;
    this.rmr = new HashMap();
    this.rmt = false;
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
    this.rmu = new IListener() {};
    this.rmv = new MMPullDownView.e()
    {
      public final boolean cAj()
      {
        AppMethodBeat.i(109326);
        Log.i("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "onBottom");
        EmojiStoreV2SingleProductUI.e(EmojiStoreV2SingleProductUI.this);
        AppMethodBeat.o(109326);
        return true;
      }
    };
    this.rmw = new MMPullDownView.c()
    {
      public final boolean cAl()
      {
        return false;
      }
    };
    AppMethodBeat.o(109334);
  }
  
  private void a(bmg parambmg)
  {
    boolean bool = false;
    AppMethodBeat.i(109346);
    if ((parambmg != null) && (parambmg.LVd != null) && (parambmg.LVd.size() > 0))
    {
      if (this.rmj) {
        bool = true;
      }
      showOptionMenu(1001, bool);
      if (this.rmq != null)
      {
        if (this.rms == null) {
          this.rms = new ArrayList();
        }
        for (;;)
        {
          if (this.rmr == null) {
            this.rmr = new HashMap();
          }
          this.rmr.clear();
          this.rms.add(getString(2131758671));
          parambmg = parambmg.LVd.iterator();
          while (parambmg.hasNext())
          {
            aiw localaiw = (aiw)parambmg.next();
            if ((localaiw != null) && (!Util.isNullOrNil(localaiw.Lsu)))
            {
              this.rms.add(localaiw.Lsu);
              this.rmr.put(localaiw.Lsu, Integer.valueOf(localaiw.Lst));
            }
          }
          this.rms.clear();
        }
        parambmg = new ArrayList();
        parambmg.add(this.rmn);
        this.rmq.a(parambmg, this.rms);
        AppMethodBeat.o(109346);
      }
    }
    else
    {
      showOptionMenu(1001, false);
    }
    AppMethodBeat.o(109346);
  }
  
  private void aa(LinkedList<ait> paramLinkedList)
  {
    AppMethodBeat.i(109349);
    if ((this.rmf != null) && (paramLinkedList != null))
    {
      if (this.rmm == -1)
      {
        this.rmf.ad(paramLinkedList);
        AppMethodBeat.o(109349);
        return;
      }
      a locala = this.rmf;
      if (locala.qXp == null) {
        locala.qXp = new ArrayList();
      }
      locala.qXp.addAll(paramLinkedList);
      locala.notifyDataSetChanged();
    }
    AppMethodBeat.o(109349);
  }
  
  private void amY(String paramString)
  {
    AppMethodBeat.i(109343);
    if (isFinishing())
    {
      Log.i("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "[showLoadingDialog] acitivity is finished.");
      AppMethodBeat.o(109343);
      return;
    }
    getString(2131755998);
    this.jZH = com.tencent.mm.ui.base.h.a(this, paramString, true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(109321);
        if (EmojiStoreV2SingleProductUI.p(EmojiStoreV2SingleProductUI.this) != null) {
          g.aAg().hqi.a(EmojiStoreV2SingleProductUI.p(EmojiStoreV2SingleProductUI.this));
        }
        AppMethodBeat.o(109321);
      }
    });
    AppMethodBeat.o(109343);
  }
  
  private void amZ()
  {
    AppMethodBeat.i(109342);
    if (this.rmt)
    {
      Log.i("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "need jeep to update page.");
      AppMethodBeat.o(109342);
      return;
    }
    this.rml = null;
    switch (this.rmd)
    {
    }
    for (;;)
    {
      bs(this.rml);
      AppMethodBeat.o(109342);
      return;
      this.rmk = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpT.bls("0");
      if ((this.rmk != null) && (this.rmk.LVc != null) && (this.rmf != null))
      {
        a(this.rmk);
        this.rmf.ad(this.rmk.LVc);
      }
      for (;;)
      {
        this.rmj = true;
        com.tencent.mm.plugin.report.service.h.CyF.a(12875, new Object[] { Integer.valueOf(0), "" });
        break;
        amY(getString(2131756029));
      }
      showOptionMenu(1001, false);
      this.rmj = false;
      com.tencent.mm.plugin.report.service.h.CyF.a(12875, new Object[] { Integer.valueOf(1), this.rcS });
      continue;
      showOptionMenu(1001, false);
      this.rmn = this.rlW;
      ana(this.rmn);
      this.rmj = false;
      com.tencent.mm.plugin.report.service.h.CyF.a(12875, new Object[] { Integer.valueOf(1), "" });
      continue;
      this.rmn = "";
      ana(this.rcQ);
      this.rmj = false;
      com.tencent.mm.plugin.report.service.h.CyF.a(12875, new Object[] { Integer.valueOf(2), "" });
      continue;
      this.rmn = "";
      showOptionMenu(1001, false);
      showOptionMenu(1002, true);
      com.tencent.mm.plugin.report.service.h.CyF.a(12875, new Object[] { Integer.valueOf(3), "" });
    }
  }
  
  private void ana(String paramString)
  {
    AppMethodBeat.i(109347);
    if ((this.rmg != null) && (this.rmh != null)) {
      switch (this.rmd)
      {
      }
    }
    for (;;)
    {
      if (Util.isNullOrNil(paramString))
      {
        this.rmh.setText("");
        this.rmh.setVisibility(8);
        this.rmg.setVisibility(8);
      }
      AppMethodBeat.o(109347);
      return;
      if (!Util.isNullOrNil(paramString))
      {
        this.rmh.setText(getString(2131758672, new Object[] { paramString }));
        this.rmh.setVisibility(0);
        this.rmg.setVisibility(0);
        continue;
        if (!Util.isNullOrNil(paramString))
        {
          this.rmh.setText(getString(2131758667, new Object[] { paramString }));
          this.rmh.setVisibility(0);
          this.rmg.setVisibility(0);
        }
      }
    }
  }
  
  private void bs(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(109345);
    this.rml = null;
    switch (this.rmd)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(109345);
      return;
      paramArrayOfByte = new com.tencent.mm.plugin.emoji.f.i(1, this.rjT, this.rlV, this.rcQ, this.rlX, paramArrayOfByte);
      g.aAg().hqi.a(paramArrayOfByte, 0);
      AppMethodBeat.o(109345);
      return;
      paramArrayOfByte = new com.tencent.mm.plugin.emoji.f.i(2, this.rjT, this.rlV, this.rcQ, this.rlX, paramArrayOfByte);
      g.aAg().hqi.a(paramArrayOfByte, 0);
      AppMethodBeat.o(109345);
      return;
      paramArrayOfByte = new com.tencent.mm.plugin.emoji.f.i(3, this.rjT, this.rlV, this.rcQ, this.rlX, paramArrayOfByte);
      g.aAg().hqi.a(paramArrayOfByte, 0);
      AppMethodBeat.o(109345);
      return;
      paramArrayOfByte = new com.tencent.mm.plugin.emoji.f.i(4, this.rjT, this.rlV, this.rcQ, this.rlX, paramArrayOfByte);
      g.aAg().hqi.a(paramArrayOfByte, 0);
      AppMethodBeat.o(109345);
      return;
      paramArrayOfByte = new com.tencent.mm.plugin.emoji.f.i(5, this.rjT, this.rlV, this.rcQ, this.rlX, paramArrayOfByte);
      g.aAg().hqi.a(paramArrayOfByte, 0);
    }
  }
  
  private void cGW()
  {
    AppMethodBeat.i(109344);
    if ((this.jZH != null) && (this.jZH.isShowing())) {
      this.jZH.dismiss();
    }
    AppMethodBeat.o(109344);
  }
  
  private void cIg()
  {
    AppMethodBeat.i(109348);
    if (!this.isLoading)
    {
      bs(this.rml);
      this.isLoading = true;
      this.mHandler.sendEmptyMessageDelayed(1002, 200L);
    }
    AppMethodBeat.o(109348);
  }
  
  private void cIh()
  {
    AppMethodBeat.i(109350);
    Toast.makeText(getContext(), getString(2131758706), 0).show();
    AppMethodBeat.o(109350);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131493980;
  }
  
  public void initView()
  {
    AppMethodBeat.i(109340);
    if ((this.rmd == 6) && (!Util.isNullOrNil(this.rlY))) {
      setMMTitle(this.rlY);
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
              EmojiStoreV2SingleProductUI.this.setMMTitle(2131758642);
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
      this.rmf = new a(getContext());
      this.rmf.rni = new a.a()
      {
        public final void FP(int paramAnonymousInt)
        {
          AppMethodBeat.i(109328);
          if ((EmojiStoreV2SingleProductUI.h(EmojiStoreV2SingleProductUI.this) != null) && (EmojiStoreV2SingleProductUI.c(EmojiStoreV2SingleProductUI.this) != null))
          {
            ait localait = EmojiStoreV2SingleProductUI.c(EmojiStoreV2SingleProductUI.this).Gg(paramAnonymousInt);
            if (localait != null) {
              try
              {
                Intent localIntent = new Intent();
                localIntent.putExtra("Select_Conv_User", EmojiStoreV2SingleProductUI.i(EmojiStoreV2SingleProductUI.this));
                localIntent.putExtra("extra_object", localait.toByteArray());
                localIntent.putExtra("scene", EmojiStoreV2SingleProductUI.j(EmojiStoreV2SingleProductUI.this));
                localIntent.putExtra("searchID", EmojiStoreV2SingleProductUI.k(EmojiStoreV2SingleProductUI.this));
                localIntent.putExtra("add_source", 5);
                localIntent.putExtra("entrance_scene", 29);
                localIntent.setClass(EmojiStoreV2SingleProductUI.this.getContext(), EmojiStoreV2SingleProductDialogUI.class);
                EmojiStoreV2SingleProductUI.this.startActivityForResult(localIntent, 5001);
                EmojiStoreV2SingleProductUI.this.overridePendingTransition(2130772119, 2130772124);
                com.tencent.mm.plugin.report.service.h.CyF.a(12787, new Object[] { Integer.valueOf(EmojiStoreV2SingleProductUI.j(EmojiStoreV2SingleProductUI.this)), Integer.valueOf(0), localait.Md5, Long.valueOf(EmojiStoreV2SingleProductUI.k(EmojiStoreV2SingleProductUI.this)), localait.Lsl, localait.ProductID, Integer.valueOf(29) });
                AppMethodBeat.o(109328);
                return;
              }
              catch (Exception localException) {}
            }
          }
          AppMethodBeat.o(109328);
        }
      };
      this.rme = ((PreViewListGridView)findViewById(2131303226));
      this.agA = aa.jQ(getContext()).inflate(2131493966, null);
      this.rmg = this.agA.findViewById(2131300000);
      this.rmh = ((TextView)this.agA.findViewById(2131300064));
      this.rme.addHeaderView(this.agA);
      this.rmi = aa.jQ(getContext()).inflate(2131493953, null);
      this.rme.addFooterView(this.rmi);
      this.rmi.setVisibility(8);
      this.rme.setAdapter(this.rmf);
      this.rme.setOnScrollListener(this);
      this.rks = ((MMPullDownView)findViewById(2131303687));
      this.rks.setTopViewVisible(false);
      this.rks.setOnBottomLoadDataListener(this.rmv);
      this.rks.setAtBottomCallBack(this.rmw);
      this.rks.setBottomViewVisible(false);
      this.rks.setIsBottomShowAll(false);
      this.rks.setIsReturnSuperDispatchWhenCancel(true);
      this.rmo = ((LabelContainerView)findViewById(2131307513));
      this.rmp = ((TextView)this.rmo.findViewById(16908310));
      this.rmp.setText(2131762129);
      this.rmq = ((MMTagPanel)this.rmo.findViewById(2131299109));
      this.rmq.setTagSelectedBG(2131235171);
      this.rmq.setTagSelectedTextColorRes(2131101414);
      this.rmn = getString(2131758671);
      this.rmo.setOnLabelContainerListener(new LabelContainerView.a()
      {
        public final void cIi()
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
            EmojiStoreV2SingleProductUI.this.setMMTitle(2131758642);
            AppMethodBeat.o(109329);
            return;
          }
        }
        
        public final void cIj()
        {
          AppMethodBeat.i(109330);
          EmojiStoreV2SingleProductUI.this.hideVKB();
          AppMethodBeat.o(109330);
        }
      });
      this.rmq.setCallBack(new MMTagPanel.a()
      {
        public final void E(boolean paramAnonymousBoolean, int paramAnonymousInt) {}
        
        public final void anb(String paramAnonymousString)
        {
          AppMethodBeat.i(109331);
          if ((!Util.isNullOrNil(EmojiStoreV2SingleProductUI.l(EmojiStoreV2SingleProductUI.this))) && (!Util.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.equals(EmojiStoreV2SingleProductUI.l(EmojiStoreV2SingleProductUI.this)))) {
            EmojiStoreV2SingleProductUI.m(EmojiStoreV2SingleProductUI.this).dn(EmojiStoreV2SingleProductUI.l(EmojiStoreV2SingleProductUI.this), true);
          }
          AppMethodBeat.o(109331);
        }
        
        public final void anc(String paramAnonymousString)
        {
          AppMethodBeat.i(109332);
          EmojiStoreV2SingleProductUI.a(EmojiStoreV2SingleProductUI.this, paramAnonymousString);
          AppMethodBeat.o(109332);
        }
        
        public final void and(String paramAnonymousString) {}
        
        public final void ane(String paramAnonymousString) {}
        
        public final void anf(String paramAnonymousString) {}
        
        public final void cIk() {}
      });
      addIconOptionMenu(1001, 2131230852, new MenuItem.OnMenuItemClickListener()
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
            EmojiStoreV2SingleProductUI.this.setMMTitle(2131758666);
            EmojiStoreV2SingleProductUI.this.showOptionMenu(1001, false);
            com.tencent.mm.plugin.report.service.h.CyF.kvStat(12788, "1");
          }
          AppMethodBeat.o(109333);
          return false;
        }
      });
      addIconOptionMenu(1002, 2131690907, new MenuItem.OnMenuItemClickListener()
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
      setMMTitle(2131758642);
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
        com.tencent.mm.ui.widget.snackbar.b.r(this, getContext().getString(2131755979));
        continue;
        if (paramInt2 == -1)
        {
          String str1 = paramIntent.getStringExtra("Select_Conv_User");
          if (!Util.isNullOrNil(str1))
          {
            Log.d("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "..".concat(String.valueOf(str1)));
            int i = this.rlX;
            String str2 = this.rlY;
            String str3 = this.rma;
            String str4 = this.rlZ;
            String str5 = this.rmb;
            int j = this.rmd;
            com.tencent.mm.plugin.emoji.model.k.cGf();
            com.tencent.mm.plugin.emoji.e.j.a(this, str1, 27, i, str2, str3, str4, str5, j, f.cFI());
          }
        }
      }
    }
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(109341);
    if ((this.rmo != null) && (this.rmo.getVisibility() == 0))
    {
      this.rmo.setVisibility(8);
      if (this.rmj) {}
      for (boolean bool = true;; bool = false)
      {
        showOptionMenu(1001, bool);
        setMMTitle(2131758642);
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
    this.rjT = getIntent().getIntExtra("uin", 0);
    this.goe = getIntent().getStringExtra("Select_Conv_User");
    this.rbH = getIntent().getLongExtra("searchID", 0L);
    this.rcS = getIntent().getStringExtra("id");
    paramBundle = getIntent().getStringExtra("tag_id");
    if (!Util.isNullOrNil(paramBundle)) {}
    try
    {
      this.rlV = Integer.valueOf(paramBundle).intValue();
      this.rlW = getIntent().getStringExtra("tag_desc");
      this.rcQ = getIntent().getStringExtra("keyword");
      this.rlX = getIntent().getIntExtra("set_id", 0);
      this.rlY = getIntent().getStringExtra("set_title");
      this.rlZ = getIntent().getStringExtra("set_iconURL");
      this.rma = getIntent().getStringExtra("set_desc");
      this.rmb = getIntent().getStringExtra("headurl");
      this.rmc = getIntent().getStringExtra("sns_object_data");
      this.rmd = getIntent().getIntExtra("pageType", 0);
      if (!Util.isNullOrNil(this.rmc))
      {
        this.rlX = EmojiLogic.amI(this.rmc);
        this.rlY = EmojiLogic.amJ(this.rmc);
        this.rlZ = EmojiLogic.amL(this.rmc);
        this.rma = EmojiLogic.amK(this.rmc);
        this.rmb = EmojiLogic.amM(this.rmc);
        this.rmd = EmojiLogic.amN(this.rmc);
      }
      switch (this.rmd)
      {
      default: 
        this.rmt = true;
        if (this.rmt)
        {
          paramBundle = new Intent();
          com.tencent.mm.plugin.emoji.model.k.cGf();
          paramBundle.putExtra("rawUrl", f.cFI());
          paramBundle.putExtra("showShare", false);
          c.b(this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramBundle);
          finish();
        }
        initView();
        if ((this.rjT == 0) && (this.rmd == 2))
        {
          paramBundle = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpT.blr(this.rcS);
          if ((paramBundle != null) && (paramBundle.LVe != null) && (paramBundle.LVe.DesignerUin != 0) && (!Util.isNullOrNil(paramBundle.LVe.Name)))
          {
            this.rjT = paramBundle.LVe.DesignerUin;
            Log.i("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "uin:%s ", new Object[] { Integer.valueOf(this.rjT) });
          }
        }
        else
        {
          i = 0;
          if (i != 0) {
            break label774;
          }
          amZ();
          g.aAh().azQ().set(ar.a.NSS, Boolean.FALSE);
          g.aAg().hqi.a(821, this);
          g.aAg().hqi.a(239, this);
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
        if (!Util.isNullOrNil(this.rcQ))
        {
          this.rmd = 5;
          this.rmj = false;
          this.mScene = 2;
        }
        else if (!Util.isNullOrNil(this.rcS))
        {
          this.rmd = 2;
          this.mScene = 1;
        }
        else if (this.rjT != 0)
        {
          this.rmd = 3;
          this.mScene = 1;
        }
        else if (this.rlV != 0)
        {
          this.mScene = 3;
          this.rmd = 4;
        }
        else if (this.rlX > 0)
        {
          this.rmd = 6;
          this.mScene = 4;
        }
        else
        {
          this.rmd = 1;
          this.mScene = 0;
          continue;
          this.mScene = 0;
          continue;
          if (Util.isNullOrNil(this.rcS))
          {
            continue;
            if (this.rjT == 0)
            {
              continue;
              if (this.rlV == 0)
              {
                continue;
                if (Util.isNullOrNil(this.rcQ))
                {
                  continue;
                  if (this.rlX == 0)
                  {
                    continue;
                    i = 1;
                    continue;
                    label774:
                    this.rku = new com.tencent.mm.plugin.emoji.f.j(this.rcS);
                    g.aAg().hqi.a(this.rku, 0);
                    amY(getString(2131756029));
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
    g.aAg().hqi.b(239, this);
    g.aAg().hqi.b(821, this);
    super.onDestroy();
    AppMethodBeat.o(109338);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(109337);
    super.onPause();
    EventCenter.instance.removeListener(this.rmu);
    AppMethodBeat.o(109337);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(109336);
    super.onResume();
    EventCenter.instance.addListener(this.rmu);
    AppMethodBeat.o(109336);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(109351);
    int i = paramq.getType();
    if (i == 821)
    {
      cGW();
      paramString = (com.tencent.mm.plugin.emoji.f.i)paramq;
      paramq = paramString.cGs();
      this.isLoading = false;
      if (this.rmi != null)
      {
        this.rmi.setVisibility(8);
        this.mHandler.removeMessages(1002);
        this.mHandler.sendEmptyMessageDelayed(1001, 200L);
      }
      i = paramString.kfa;
      if (((paramInt1 == 0) && (paramInt2 == 0)) || ((paramInt1 == 4) && ((paramInt2 == 2) || (paramInt2 == 3)) && ((this.rml == null) || (this.rml.length <= 0)) && (i != 3))) {
        a(paramq);
      }
      if ((paramInt1 == 0) || (paramInt1 == 4))
      {
        this.rml = paramString.rcO;
        if (paramInt2 == 0)
        {
          aa(paramq.LVc);
          this.rmm = 0;
          AppMethodBeat.o(109351);
          return;
        }
        if (paramInt2 == 2)
        {
          aa(paramq.LVc);
          this.rmm = 2;
          AppMethodBeat.o(109351);
          return;
        }
        if (paramInt2 == 3)
        {
          this.rmm = -1;
          aa(paramq.LVc);
          AppMethodBeat.o(109351);
          return;
        }
        cIh();
        AppMethodBeat.o(109351);
        return;
      }
      cIh();
      AppMethodBeat.o(109351);
      return;
    }
    if (i == 239)
    {
      cGW();
      if ((paramInt2 == 0) && (paramInt1 == 0))
      {
        paramString = ((com.tencent.mm.plugin.emoji.f.j)paramq).cGt();
        if ((paramString != null) && (paramString.LVe != null))
        {
          this.rjT = paramString.LVe.DesignerUin;
          if (this.mHandler != null) {
            this.mHandler.sendEmptyMessage(1004);
          }
        }
        AppMethodBeat.o(109351);
        return;
      }
      showOptionMenu(1001, false);
      com.tencent.mm.ui.base.h.c(getContext(), getString(2131758541), null, true);
      Log.e("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "open single product ui failed.");
    }
    AppMethodBeat.o(109351);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(109352);
    if ((paramInt == 0) && (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1) && (this.rmm == 2) && (!this.isLoading))
    {
      Log.d("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "No More List.");
      cIg();
      Log.i("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "[onScrollStateChanged] startLoadRemoteEmoji.");
    }
    if ((paramInt != 0) && (this.rme != null)) {
      this.rme.cIq();
    }
    AppMethodBeat.o(109352);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductUI
 * JD-Core Version:    0.7.0.1
 */