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
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.df;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.emoji.e.j;
import com.tencent.mm.plugin.emoji.f.i;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.protocal.protobuf.PersonalDesigner;
import com.tencent.mm.protocal.protobuf.ads;
import com.tencent.mm.protocal.protobuf.adv;
import com.tencent.mm.protocal.protobuf.awd;
import com.tencent.mm.protocal.protobuf.awf;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.c;
import com.tencent.mm.ui.base.MMPullDownView.e;
import com.tencent.mm.ui.base.MMTagPanel;
import com.tencent.mm.ui.base.MMTagPanel.a;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.contact.LabelContainerView;
import com.tencent.mm.ui.contact.LabelContainerView.a;
import com.tencent.mm.ui.z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class EmojiStoreV2SingleProductUI
  extends MMActivity
  implements AbsListView.OnScrollListener, com.tencent.mm.ak.g
{
  private View aew;
  private String foE;
  private ProgressDialog iFC;
  private boolean isLoading;
  private ao mHandler;
  private int mScene;
  private long pbb;
  private String pci;
  private String pck;
  private int piP;
  private MMPullDownView pjo;
  private i pjq;
  private int pkR;
  private String pkS;
  private int pkT;
  private String pkU;
  private String pkV;
  private String pkW;
  private String pkX;
  private String pkY;
  private int pkZ;
  private PreViewListGridView pla;
  private a plb;
  private View plc;
  private TextView pld;
  private View ple;
  private boolean plf;
  private awd plg;
  private byte[] plh;
  private int pli;
  private String plj;
  private LabelContainerView plk;
  private TextView pll;
  private MMTagPanel plm;
  private HashMap<String, Integer> pln;
  private ArrayList<String> plo;
  private boolean plp;
  private c plq;
  private MMPullDownView.e plr;
  private MMPullDownView.c pls;
  
  public EmojiStoreV2SingleProductUI()
  {
    AppMethodBeat.i(109334);
    this.piP = 0;
    this.pkT = -1;
    this.pkZ = 0;
    this.plf = true;
    this.pli = -1;
    this.isLoading = false;
    this.pln = new HashMap();
    this.plp = false;
    this.mHandler = new ao()
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
    this.plq = new c() {};
    this.plr = new MMPullDownView.e()
    {
      public final boolean bWx()
      {
        AppMethodBeat.i(109326);
        ac.i("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "onBottom");
        EmojiStoreV2SingleProductUI.e(EmojiStoreV2SingleProductUI.this);
        AppMethodBeat.o(109326);
        return true;
      }
    };
    this.pls = new MMPullDownView.c()
    {
      public final boolean bWz()
      {
        return false;
      }
    };
    AppMethodBeat.o(109334);
  }
  
  private void WJ()
  {
    AppMethodBeat.i(109342);
    if (this.plp)
    {
      ac.i("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "need jeep to update page.");
      AppMethodBeat.o(109342);
      return;
    }
    this.plh = null;
    switch (this.pkZ)
    {
    }
    for (;;)
    {
      ba(this.plh);
      AppMethodBeat.o(109342);
      return;
      this.plg = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().GYf.aPb("0");
      if ((this.plg != null) && (this.plg.EOi != null) && (this.plb != null))
      {
        a(this.plg);
        this.plb.U(this.plg.EOi);
      }
      for (;;)
      {
        this.plf = true;
        com.tencent.mm.plugin.report.service.h.wUl.f(12875, new Object[] { Integer.valueOf(0), "" });
        break;
        Yu(getString(2131755936));
      }
      showOptionMenu(1001, false);
      this.plf = false;
      com.tencent.mm.plugin.report.service.h.wUl.f(12875, new Object[] { Integer.valueOf(1), this.pck });
      continue;
      showOptionMenu(1001, false);
      this.plj = this.pkS;
      Yv(this.plj);
      this.plf = false;
      com.tencent.mm.plugin.report.service.h.wUl.f(12875, new Object[] { Integer.valueOf(1), "" });
      continue;
      this.plj = "";
      Yv(this.pci);
      this.plf = false;
      com.tencent.mm.plugin.report.service.h.wUl.f(12875, new Object[] { Integer.valueOf(2), "" });
      continue;
      this.plj = "";
      showOptionMenu(1001, false);
      showOptionMenu(1002, true);
      com.tencent.mm.plugin.report.service.h.wUl.f(12875, new Object[] { Integer.valueOf(3), "" });
    }
  }
  
  private void Y(LinkedList<ads> paramLinkedList)
  {
    AppMethodBeat.i(109349);
    if ((this.plb != null) && (paramLinkedList != null))
    {
      if (this.pli == -1)
      {
        this.plb.U(paramLinkedList);
        AppMethodBeat.o(109349);
        return;
      }
      a locala = this.plb;
      if (locala.oXp == null) {
        locala.oXp = new ArrayList();
      }
      locala.oXp.addAll(paramLinkedList);
      locala.notifyDataSetChanged();
    }
    AppMethodBeat.o(109349);
  }
  
  private void Yu(String paramString)
  {
    AppMethodBeat.i(109343);
    if (isFinishing())
    {
      ac.i("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "[showLoadingDialog] acitivity is finished.");
      AppMethodBeat.o(109343);
      return;
    }
    getString(2131755906);
    this.iFC = com.tencent.mm.ui.base.h.b(this, paramString, true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(109321);
        if (EmojiStoreV2SingleProductUI.p(EmojiStoreV2SingleProductUI.this) != null) {
          com.tencent.mm.kernel.g.agQ().ghe.a(EmojiStoreV2SingleProductUI.p(EmojiStoreV2SingleProductUI.this));
        }
        AppMethodBeat.o(109321);
      }
    });
    AppMethodBeat.o(109343);
  }
  
  private void Yv(String paramString)
  {
    AppMethodBeat.i(109347);
    if ((this.plc != null) && (this.pld != null)) {
      switch (this.pkZ)
      {
      }
    }
    for (;;)
    {
      if (bs.isNullOrNil(paramString))
      {
        this.pld.setText("");
        this.pld.setVisibility(8);
        this.plc.setVisibility(8);
      }
      AppMethodBeat.o(109347);
      return;
      if (!bs.isNullOrNil(paramString))
      {
        this.pld.setText(getString(2131758378, new Object[] { paramString }));
        this.pld.setVisibility(0);
        this.plc.setVisibility(0);
        continue;
        if (!bs.isNullOrNil(paramString))
        {
          this.pld.setText(getString(2131758373, new Object[] { paramString }));
          this.pld.setVisibility(0);
          this.plc.setVisibility(0);
        }
      }
    }
  }
  
  private void a(awd paramawd)
  {
    boolean bool = false;
    AppMethodBeat.i(109346);
    if ((paramawd != null) && (paramawd.EOj != null) && (paramawd.EOj.size() > 0))
    {
      if (this.plf) {
        bool = true;
      }
      showOptionMenu(1001, bool);
      if (this.plm != null)
      {
        if (this.plo == null) {
          this.plo = new ArrayList();
        }
        for (;;)
        {
          if (this.pln == null) {
            this.pln = new HashMap();
          }
          this.pln.clear();
          this.plo.add(getString(2131758377));
          paramawd = paramawd.EOj.iterator();
          while (paramawd.hasNext())
          {
            adv localadv = (adv)paramawd.next();
            if ((localadv != null) && (!bs.isNullOrNil(localadv.EwE)))
            {
              this.plo.add(localadv.EwE);
              this.pln.put(localadv.EwE, Integer.valueOf(localadv.EwD));
            }
          }
          this.plo.clear();
        }
        paramawd = new ArrayList();
        paramawd.add(this.plj);
        this.plm.a(paramawd, this.plo);
        AppMethodBeat.o(109346);
      }
    }
    else
    {
      showOptionMenu(1001, false);
    }
    AppMethodBeat.o(109346);
  }
  
  private void ba(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(109345);
    this.plh = null;
    switch (this.pkZ)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(109345);
      return;
      paramArrayOfByte = new com.tencent.mm.plugin.emoji.f.h(1, this.piP, this.pkR, this.pci, this.pkT, paramArrayOfByte);
      com.tencent.mm.kernel.g.agQ().ghe.a(paramArrayOfByte, 0);
      AppMethodBeat.o(109345);
      return;
      paramArrayOfByte = new com.tencent.mm.plugin.emoji.f.h(2, this.piP, this.pkR, this.pci, this.pkT, paramArrayOfByte);
      com.tencent.mm.kernel.g.agQ().ghe.a(paramArrayOfByte, 0);
      AppMethodBeat.o(109345);
      return;
      paramArrayOfByte = new com.tencent.mm.plugin.emoji.f.h(3, this.piP, this.pkR, this.pci, this.pkT, paramArrayOfByte);
      com.tencent.mm.kernel.g.agQ().ghe.a(paramArrayOfByte, 0);
      AppMethodBeat.o(109345);
      return;
      paramArrayOfByte = new com.tencent.mm.plugin.emoji.f.h(4, this.piP, this.pkR, this.pci, this.pkT, paramArrayOfByte);
      com.tencent.mm.kernel.g.agQ().ghe.a(paramArrayOfByte, 0);
      AppMethodBeat.o(109345);
      return;
      paramArrayOfByte = new com.tencent.mm.plugin.emoji.f.h(5, this.piP, this.pkR, this.pci, this.pkT, paramArrayOfByte);
      com.tencent.mm.kernel.g.agQ().ghe.a(paramArrayOfByte, 0);
    }
  }
  
  private void cdf()
  {
    AppMethodBeat.i(109344);
    if ((this.iFC != null) && (this.iFC.isShowing())) {
      this.iFC.dismiss();
    }
    AppMethodBeat.o(109344);
  }
  
  private void cel()
  {
    AppMethodBeat.i(109348);
    if (!this.isLoading)
    {
      ba(this.plh);
      this.isLoading = true;
      this.mHandler.sendEmptyMessageDelayed(1002, 200L);
    }
    AppMethodBeat.o(109348);
  }
  
  private void cem()
  {
    AppMethodBeat.i(109350);
    Toast.makeText(getContext(), getString(2131758412), 0).show();
    AppMethodBeat.o(109350);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131493826;
  }
  
  public void initView()
  {
    AppMethodBeat.i(109340);
    if ((this.pkZ == 6) && (!bs.isNullOrNil(this.pkU))) {
      setMMTitle(this.pkU);
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
              EmojiStoreV2SingleProductUI.this.setMMTitle(2131758348);
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
      this.plb = new a(getContext());
      this.plb.pme = new a.a()
      {
        public final void Bm(int paramAnonymousInt)
        {
          AppMethodBeat.i(109328);
          if ((EmojiStoreV2SingleProductUI.h(EmojiStoreV2SingleProductUI.this) != null) && (EmojiStoreV2SingleProductUI.c(EmojiStoreV2SingleProductUI.this) != null))
          {
            ads localads = EmojiStoreV2SingleProductUI.c(EmojiStoreV2SingleProductUI.this).BB(paramAnonymousInt);
            if (localads != null) {
              try
              {
                Intent localIntent = new Intent();
                localIntent.putExtra("Select_Conv_User", EmojiStoreV2SingleProductUI.i(EmojiStoreV2SingleProductUI.this));
                localIntent.putExtra("extra_object", localads.toByteArray());
                localIntent.putExtra("scene", EmojiStoreV2SingleProductUI.j(EmojiStoreV2SingleProductUI.this));
                localIntent.putExtra("searchID", EmojiStoreV2SingleProductUI.k(EmojiStoreV2SingleProductUI.this));
                localIntent.putExtra("add_source", 5);
                localIntent.putExtra("entrance_scene", 29);
                localIntent.setClass(EmojiStoreV2SingleProductUI.this.getContext(), EmojiStoreV2SingleProductDialogUI.class);
                EmojiStoreV2SingleProductUI.this.startActivityForResult(localIntent, 5001);
                EmojiStoreV2SingleProductUI.this.overridePendingTransition(2130772095, 2130772100);
                com.tencent.mm.plugin.report.service.h.wUl.f(12787, new Object[] { Integer.valueOf(EmojiStoreV2SingleProductUI.j(EmojiStoreV2SingleProductUI.this)), Integer.valueOf(0), localads.Md5, Long.valueOf(EmojiStoreV2SingleProductUI.k(EmojiStoreV2SingleProductUI.this)), localads.Ewv, localads.ProductID, Integer.valueOf(29) });
                AppMethodBeat.o(109328);
                return;
              }
              catch (Exception localException) {}
            }
          }
          AppMethodBeat.o(109328);
        }
      };
      this.pla = ((PreViewListGridView)findViewById(2131301443));
      this.aew = z.jD(getContext()).inflate(2131493812, null);
      this.plc = this.aew.findViewById(2131299387);
      this.pld = ((TextView)this.aew.findViewById(2131299450));
      this.pla.addHeaderView(this.aew);
      this.ple = z.jD(getContext()).inflate(2131493799, null);
      this.pla.addFooterView(this.ple);
      this.ple.setVisibility(8);
      this.pla.setAdapter(this.plb);
      this.pla.setOnScrollListener(this);
      this.pjo = ((MMPullDownView)findViewById(2131301488));
      this.pjo.setTopViewVisible(false);
      this.pjo.setOnBottomLoadDataListener(this.plr);
      this.pjo.setAtBottomCallBack(this.pls);
      this.pjo.setBottomViewVisible(false);
      this.pjo.setIsBottomShowAll(false);
      this.pjo.setIsReturnSuperDispatchWhenCancel(true);
      this.plk = ((LabelContainerView)findViewById(2131304507));
      this.pll = ((TextView)this.plk.findViewById(16908310));
      this.pll.setText(2131760617);
      this.plm = ((MMTagPanel)this.plk.findViewById(2131298672));
      this.plm.setTagSelectedBG(2131234292);
      this.plm.setTagSelectedTextColorRes(2131101171);
      this.plj = getString(2131758377);
      this.plk.setOnLabelContainerListener(new LabelContainerView.a()
      {
        public final void cen()
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
            EmojiStoreV2SingleProductUI.this.setMMTitle(2131758348);
            AppMethodBeat.o(109329);
            return;
          }
        }
        
        public final void ceo()
        {
          AppMethodBeat.i(109330);
          EmojiStoreV2SingleProductUI.this.hideVKB();
          AppMethodBeat.o(109330);
        }
      });
      this.plm.setCallBack(new MMTagPanel.a()
      {
        public final void C(boolean paramAnonymousBoolean, int paramAnonymousInt) {}
        
        public final void YA(String paramAnonymousString) {}
        
        public final void Yw(String paramAnonymousString)
        {
          AppMethodBeat.i(109331);
          if ((!bs.isNullOrNil(EmojiStoreV2SingleProductUI.l(EmojiStoreV2SingleProductUI.this))) && (!bs.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.equals(EmojiStoreV2SingleProductUI.l(EmojiStoreV2SingleProductUI.this)))) {
            EmojiStoreV2SingleProductUI.m(EmojiStoreV2SingleProductUI.this).cJ(EmojiStoreV2SingleProductUI.l(EmojiStoreV2SingleProductUI.this), true);
          }
          AppMethodBeat.o(109331);
        }
        
        public final void Yx(String paramAnonymousString)
        {
          AppMethodBeat.i(109332);
          EmojiStoreV2SingleProductUI.a(EmojiStoreV2SingleProductUI.this, paramAnonymousString);
          AppMethodBeat.o(109332);
        }
        
        public final void Yy(String paramAnonymousString) {}
        
        public final void Yz(String paramAnonymousString) {}
        
        public final void cep() {}
      });
      addIconOptionMenu(1001, 2131230839, new MenuItem.OnMenuItemClickListener()
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
            EmojiStoreV2SingleProductUI.this.setMMTitle(2131758372);
            EmojiStoreV2SingleProductUI.this.showOptionMenu(1001, false);
            com.tencent.mm.plugin.report.service.h.wUl.kvStat(12788, "1");
          }
          AppMethodBeat.o(109333);
          return false;
        }
      });
      addIconOptionMenu(1002, 2131690655, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(109320);
          ac.d("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "on shard click.");
          EmojiStoreV2SingleProductUI.o(EmojiStoreV2SingleProductUI.this);
          AppMethodBeat.o(109320);
          return true;
        }
      });
      showOptionMenu(1001, false);
      showOptionMenu(1002, false);
      AppMethodBeat.o(109340);
      return;
      setMMTitle(2131758348);
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
        com.tencent.mm.ui.widget.snackbar.b.n(this, getContext().getString(2131755887));
        continue;
        if (paramInt2 == -1)
        {
          String str1 = paramIntent.getStringExtra("Select_Conv_User");
          if (!bs.isNullOrNil(str1))
          {
            ac.d("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "..".concat(String.valueOf(str1)));
            int i = this.pkT;
            String str2 = this.pkU;
            String str3 = this.pkW;
            String str4 = this.pkV;
            String str5 = this.pkX;
            int j = this.pkZ;
            com.tencent.mm.plugin.emoji.model.k.ccm();
            j.a(this, str1, 27, i, str2, str3, str4, str5, j, "https://support.weixin.qq.com/cgi-bin/readtemplate?t=page/common_page__upgrade&text=text000&btn_text=btn_text_0&title=title_0");
          }
        }
      }
    }
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(109341);
    if ((this.plk != null) && (this.plk.getVisibility() == 0))
    {
      this.plk.setVisibility(8);
      if (this.plf) {}
      for (boolean bool = true;; bool = false)
      {
        showOptionMenu(1001, bool);
        setMMTitle(2131758348);
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
    this.piP = getIntent().getIntExtra("uin", 0);
    this.foE = getIntent().getStringExtra("Select_Conv_User");
    this.pbb = getIntent().getLongExtra("searchID", 0L);
    this.pck = getIntent().getStringExtra("id");
    paramBundle = getIntent().getStringExtra("tag_id");
    if (!bs.isNullOrNil(paramBundle)) {}
    try
    {
      this.pkR = Integer.valueOf(paramBundle).intValue();
      this.pkS = getIntent().getStringExtra("tag_desc");
      this.pci = getIntent().getStringExtra("keyword");
      this.pkT = getIntent().getIntExtra("set_id", 0);
      this.pkU = getIntent().getStringExtra("set_title");
      this.pkV = getIntent().getStringExtra("set_iconURL");
      this.pkW = getIntent().getStringExtra("set_desc");
      this.pkX = getIntent().getStringExtra("headurl");
      this.pkY = getIntent().getStringExtra("sns_object_data");
      this.pkZ = getIntent().getIntExtra("pageType", 0);
      if (!bs.isNullOrNil(this.pkY))
      {
        this.pkT = EmojiLogic.Ye(this.pkY);
        this.pkU = EmojiLogic.Yf(this.pkY);
        this.pkV = EmojiLogic.Yh(this.pkY);
        this.pkW = EmojiLogic.Yg(this.pkY);
        this.pkX = EmojiLogic.Yi(this.pkY);
        this.pkZ = EmojiLogic.Yj(this.pkY);
      }
      switch (this.pkZ)
      {
      default: 
        this.plp = true;
        if (this.plp)
        {
          paramBundle = new Intent();
          com.tencent.mm.plugin.emoji.model.k.ccm();
          paramBundle.putExtra("rawUrl", "https://support.weixin.qq.com/cgi-bin/readtemplate?t=page/common_page__upgrade&text=text000&btn_text=btn_text_0&title=title_0");
          paramBundle.putExtra("showShare", false);
          d.b(this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramBundle);
          finish();
        }
        initView();
        if ((this.piP == 0) && (this.pkZ == 2))
        {
          paramBundle = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().GYf.aPa(this.pck);
          if ((paramBundle != null) && (paramBundle.EOk != null) && (paramBundle.EOk.DesignerUin != 0) && (!bs.isNullOrNil(paramBundle.EOk.Name)))
          {
            this.piP = paramBundle.EOk.DesignerUin;
            ac.i("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "uin:%s ", new Object[] { Integer.valueOf(this.piP) });
          }
        }
        else
        {
          i = 0;
          if (i != 0) {
            break label772;
          }
          WJ();
          com.tencent.mm.kernel.g.agR().agA().set(ah.a.GEf, Boolean.FALSE);
          com.tencent.mm.kernel.g.agQ().ghe.a(821, this);
          com.tencent.mm.kernel.g.agQ().ghe.a(239, this);
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
        ac.e("MicroMsg.emoji.EmojiStoreV2SingleProductUI", bs.m(paramBundle));
        continue;
        if (!bs.isNullOrNil(this.pci))
        {
          this.pkZ = 5;
          this.plf = false;
          this.mScene = 2;
        }
        else if (!bs.isNullOrNil(this.pck))
        {
          this.pkZ = 2;
          this.mScene = 1;
        }
        else if (this.piP != 0)
        {
          this.pkZ = 3;
          this.mScene = 1;
        }
        else if (this.pkR != 0)
        {
          this.mScene = 3;
          this.pkZ = 4;
        }
        else if (this.pkT > 0)
        {
          this.pkZ = 6;
          this.mScene = 4;
        }
        else
        {
          this.pkZ = 1;
          this.mScene = 0;
          continue;
          this.mScene = 0;
          continue;
          if (bs.isNullOrNil(this.pck))
          {
            continue;
            if (this.piP == 0)
            {
              continue;
              if (this.pkR == 0)
              {
                continue;
                if (bs.isNullOrNil(this.pci))
                {
                  continue;
                  if (this.pkT == 0)
                  {
                    continue;
                    i = 1;
                    continue;
                    label772:
                    this.pjq = new i(this.pck);
                    com.tencent.mm.kernel.g.agQ().ghe.a(this.pjq, 0);
                    Yu(getString(2131755936));
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
    com.tencent.mm.kernel.g.agQ().ghe.b(239, this);
    com.tencent.mm.kernel.g.agQ().ghe.b(821, this);
    super.onDestroy();
    AppMethodBeat.o(109338);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(109337);
    super.onPause();
    com.tencent.mm.sdk.b.a.GpY.d(this.plq);
    AppMethodBeat.o(109337);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(109336);
    super.onResume();
    com.tencent.mm.sdk.b.a.GpY.c(this.plq);
    AppMethodBeat.o(109336);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(109351);
    int i = paramn.getType();
    if (i == 821)
    {
      cdf();
      paramString = (com.tencent.mm.plugin.emoji.f.h)paramn;
      paramn = paramString.ccz();
      this.isLoading = false;
      if (this.ple != null)
      {
        this.ple.setVisibility(8);
        this.mHandler.removeMessages(1002);
        this.mHandler.sendEmptyMessageDelayed(1001, 200L);
      }
      i = paramString.iKU;
      if (((paramInt1 == 0) && (paramInt2 == 0)) || ((paramInt1 == 4) && ((paramInt2 == 2) || (paramInt2 == 3)) && ((this.plh == null) || (this.plh.length <= 0)) && (i != 3))) {
        a(paramn);
      }
      if ((paramInt1 == 0) || (paramInt1 == 4))
      {
        this.plh = paramString.pcg;
        if (paramInt2 == 0)
        {
          Y(paramn.EOi);
          this.pli = 0;
          AppMethodBeat.o(109351);
          return;
        }
        if (paramInt2 == 2)
        {
          Y(paramn.EOi);
          this.pli = 2;
          AppMethodBeat.o(109351);
          return;
        }
        if (paramInt2 == 3)
        {
          this.pli = -1;
          Y(paramn.EOi);
          AppMethodBeat.o(109351);
          return;
        }
        cem();
        AppMethodBeat.o(109351);
        return;
      }
      cem();
      AppMethodBeat.o(109351);
      return;
    }
    if (i == 239)
    {
      cdf();
      if ((paramInt2 == 0) && (paramInt1 == 0))
      {
        paramString = ((i)paramn).ccA();
        if ((paramString != null) && (paramString.EOk != null))
        {
          this.piP = paramString.EOk.DesignerUin;
          if (this.mHandler != null) {
            this.mHandler.sendEmptyMessage(1004);
          }
        }
        AppMethodBeat.o(109351);
        return;
      }
      showOptionMenu(1001, false);
      com.tencent.mm.ui.base.h.c(getContext(), getString(2131758253), null, true);
      ac.e("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "open single product ui failed.");
    }
    AppMethodBeat.o(109351);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(109352);
    if ((paramInt == 0) && (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1) && (this.pli == 2) && (!this.isLoading))
    {
      ac.d("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "No More List.");
      cel();
      ac.i("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "[onScrollStateChanged] startLoadRemoteEmoji.");
    }
    if ((paramInt != 0) && (this.pla != null)) {
      this.pla.cev();
    }
    AppMethodBeat.o(109352);
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