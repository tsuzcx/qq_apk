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
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.dj;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.emoji.e.j;
import com.tencent.mm.plugin.emoji.f.i;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.protocal.protobuf.PersonalDesigner;
import com.tencent.mm.protocal.protobuf.agk;
import com.tencent.mm.protocal.protobuf.agn;
import com.tencent.mm.protocal.protobuf.bar;
import com.tencent.mm.protocal.protobuf.bat;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.be;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.c;
import com.tencent.mm.ui.base.MMPullDownView.e;
import com.tencent.mm.ui.base.MMTagPanel;
import com.tencent.mm.ui.base.MMTagPanel.a;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
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
  implements AbsListView.OnScrollListener, f
{
  private View agn;
  private String fIQ;
  private boolean isLoading;
  private ProgressDialog jbE;
  private aq mHandler;
  private int mScene;
  private long pLp;
  private String pMw;
  private String pMy;
  private int pSU;
  private MMPullDownView pTt;
  private i pTv;
  private int pUW;
  private String pUX;
  private int pUY;
  private String pUZ;
  private String pVa;
  private String pVb;
  private String pVc;
  private String pVd;
  private int pVe;
  private PreViewListGridView pVf;
  private a pVg;
  private View pVh;
  private TextView pVi;
  private View pVj;
  private boolean pVk;
  private bar pVl;
  private byte[] pVm;
  private int pVn;
  private String pVo;
  private LabelContainerView pVp;
  private TextView pVq;
  private MMTagPanel pVr;
  private HashMap<String, Integer> pVs;
  private ArrayList<String> pVt;
  private boolean pVu;
  private c pVv;
  private MMPullDownView.e pVw;
  private MMPullDownView.c pVx;
  
  public EmojiStoreV2SingleProductUI()
  {
    AppMethodBeat.i(109334);
    this.pSU = 0;
    this.pUY = -1;
    this.pVe = 0;
    this.pVk = true;
    this.pVn = -1;
    this.isLoading = false;
    this.pVs = new HashMap();
    this.pVu = false;
    this.mHandler = new aq()
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
    this.pVv = new c() {};
    this.pVw = new MMPullDownView.e()
    {
      public final boolean ccp()
      {
        AppMethodBeat.i(109326);
        ae.i("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "onBottom");
        EmojiStoreV2SingleProductUI.e(EmojiStoreV2SingleProductUI.this);
        AppMethodBeat.o(109326);
        return true;
      }
    };
    this.pVx = new MMPullDownView.c()
    {
      public final boolean ccr()
      {
        return false;
      }
    };
    AppMethodBeat.o(109334);
  }
  
  private void Z(LinkedList<agk> paramLinkedList)
  {
    AppMethodBeat.i(109349);
    if ((this.pVg != null) && (paramLinkedList != null))
    {
      if (this.pVn == -1)
      {
        this.pVg.V(paramLinkedList);
        AppMethodBeat.o(109349);
        return;
      }
      a locala = this.pVg;
      if (locala.pHD == null) {
        locala.pHD = new ArrayList();
      }
      locala.pHD.addAll(paramLinkedList);
      locala.notifyDataSetChanged();
    }
    AppMethodBeat.o(109349);
  }
  
  private void Zm()
  {
    AppMethodBeat.i(109342);
    if (this.pVu)
    {
      ae.i("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "need jeep to update page.");
      AppMethodBeat.o(109342);
      return;
    }
    this.pVm = null;
    switch (this.pVe)
    {
    }
    for (;;)
    {
      bb(this.pVm);
      AppMethodBeat.o(109342);
      return;
      this.pVl = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().Jga.aWt("0");
      if ((this.pVl != null) && (this.pVl.GQM != null) && (this.pVg != null))
      {
        a(this.pVl);
        this.pVg.V(this.pVl.GQM);
      }
      for (;;)
      {
        this.pVk = true;
        com.tencent.mm.plugin.report.service.g.yxI.f(12875, new Object[] { Integer.valueOf(0), "" });
        break;
        acR(getString(2131755936));
      }
      showOptionMenu(1001, false);
      this.pVk = false;
      com.tencent.mm.plugin.report.service.g.yxI.f(12875, new Object[] { Integer.valueOf(1), this.pMy });
      continue;
      showOptionMenu(1001, false);
      this.pVo = this.pUX;
      acS(this.pVo);
      this.pVk = false;
      com.tencent.mm.plugin.report.service.g.yxI.f(12875, new Object[] { Integer.valueOf(1), "" });
      continue;
      this.pVo = "";
      acS(this.pMw);
      this.pVk = false;
      com.tencent.mm.plugin.report.service.g.yxI.f(12875, new Object[] { Integer.valueOf(2), "" });
      continue;
      this.pVo = "";
      showOptionMenu(1001, false);
      showOptionMenu(1002, true);
      com.tencent.mm.plugin.report.service.g.yxI.f(12875, new Object[] { Integer.valueOf(3), "" });
    }
  }
  
  private void a(bar parambar)
  {
    boolean bool = false;
    AppMethodBeat.i(109346);
    if ((parambar != null) && (parambar.GQN != null) && (parambar.GQN.size() > 0))
    {
      if (this.pVk) {
        bool = true;
      }
      showOptionMenu(1001, bool);
      if (this.pVr != null)
      {
        if (this.pVt == null) {
          this.pVt = new ArrayList();
        }
        for (;;)
        {
          if (this.pVs == null) {
            this.pVs = new HashMap();
          }
          this.pVs.clear();
          this.pVt.add(getString(2131758377));
          parambar = parambar.GQN.iterator();
          while (parambar.hasNext())
          {
            agn localagn = (agn)parambar.next();
            if ((localagn != null) && (!bu.isNullOrNil(localagn.GwO)))
            {
              this.pVt.add(localagn.GwO);
              this.pVs.put(localagn.GwO, Integer.valueOf(localagn.GwN));
            }
          }
          this.pVt.clear();
        }
        parambar = new ArrayList();
        parambar.add(this.pVo);
        this.pVr.a(parambar, this.pVt);
        AppMethodBeat.o(109346);
      }
    }
    else
    {
      showOptionMenu(1001, false);
    }
    AppMethodBeat.o(109346);
  }
  
  private void acR(String paramString)
  {
    AppMethodBeat.i(109343);
    if (isFinishing())
    {
      ae.i("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "[showLoadingDialog] acitivity is finished.");
      AppMethodBeat.o(109343);
      return;
    }
    getString(2131755906);
    this.jbE = com.tencent.mm.ui.base.h.b(this, paramString, true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(109321);
        if (EmojiStoreV2SingleProductUI.p(EmojiStoreV2SingleProductUI.this) != null) {
          com.tencent.mm.kernel.g.ajQ().gDv.a(EmojiStoreV2SingleProductUI.p(EmojiStoreV2SingleProductUI.this));
        }
        AppMethodBeat.o(109321);
      }
    });
    AppMethodBeat.o(109343);
  }
  
  private void acS(String paramString)
  {
    AppMethodBeat.i(109347);
    if ((this.pVh != null) && (this.pVi != null)) {
      switch (this.pVe)
      {
      }
    }
    for (;;)
    {
      if (bu.isNullOrNil(paramString))
      {
        this.pVi.setText("");
        this.pVi.setVisibility(8);
        this.pVh.setVisibility(8);
      }
      AppMethodBeat.o(109347);
      return;
      if (!bu.isNullOrNil(paramString))
      {
        this.pVi.setText(getString(2131758378, new Object[] { paramString }));
        this.pVi.setVisibility(0);
        this.pVh.setVisibility(0);
        continue;
        if (!bu.isNullOrNil(paramString))
        {
          this.pVi.setText(getString(2131758373, new Object[] { paramString }));
          this.pVi.setVisibility(0);
          this.pVh.setVisibility(0);
        }
      }
    }
  }
  
  private void bb(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(109345);
    this.pVm = null;
    switch (this.pVe)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(109345);
      return;
      paramArrayOfByte = new com.tencent.mm.plugin.emoji.f.h(1, this.pSU, this.pUW, this.pMw, this.pUY, paramArrayOfByte);
      com.tencent.mm.kernel.g.ajQ().gDv.a(paramArrayOfByte, 0);
      AppMethodBeat.o(109345);
      return;
      paramArrayOfByte = new com.tencent.mm.plugin.emoji.f.h(2, this.pSU, this.pUW, this.pMw, this.pUY, paramArrayOfByte);
      com.tencent.mm.kernel.g.ajQ().gDv.a(paramArrayOfByte, 0);
      AppMethodBeat.o(109345);
      return;
      paramArrayOfByte = new com.tencent.mm.plugin.emoji.f.h(3, this.pSU, this.pUW, this.pMw, this.pUY, paramArrayOfByte);
      com.tencent.mm.kernel.g.ajQ().gDv.a(paramArrayOfByte, 0);
      AppMethodBeat.o(109345);
      return;
      paramArrayOfByte = new com.tencent.mm.plugin.emoji.f.h(4, this.pSU, this.pUW, this.pMw, this.pUY, paramArrayOfByte);
      com.tencent.mm.kernel.g.ajQ().gDv.a(paramArrayOfByte, 0);
      AppMethodBeat.o(109345);
      return;
      paramArrayOfByte = new com.tencent.mm.plugin.emoji.f.h(5, this.pSU, this.pUW, this.pMw, this.pUY, paramArrayOfByte);
      com.tencent.mm.kernel.g.ajQ().gDv.a(paramArrayOfByte, 0);
    }
  }
  
  private void ciY()
  {
    AppMethodBeat.i(109344);
    if ((this.jbE != null) && (this.jbE.isShowing())) {
      this.jbE.dismiss();
    }
    AppMethodBeat.o(109344);
  }
  
  private void cke()
  {
    AppMethodBeat.i(109348);
    if (!this.isLoading)
    {
      bb(this.pVm);
      this.isLoading = true;
      this.mHandler.sendEmptyMessageDelayed(1002, 200L);
    }
    AppMethodBeat.o(109348);
  }
  
  private void ckf()
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
    if ((this.pVe == 6) && (!bu.isNullOrNil(this.pUZ))) {
      setMMTitle(this.pUZ);
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
      this.pVg = new a(getContext());
      this.pVg.pWj = new a.a()
      {
        public final void Cg(int paramAnonymousInt)
        {
          AppMethodBeat.i(109328);
          if ((EmojiStoreV2SingleProductUI.h(EmojiStoreV2SingleProductUI.this) != null) && (EmojiStoreV2SingleProductUI.c(EmojiStoreV2SingleProductUI.this) != null))
          {
            agk localagk = EmojiStoreV2SingleProductUI.c(EmojiStoreV2SingleProductUI.this).Cv(paramAnonymousInt);
            if (localagk != null) {
              try
              {
                Intent localIntent = new Intent();
                localIntent.putExtra("Select_Conv_User", EmojiStoreV2SingleProductUI.i(EmojiStoreV2SingleProductUI.this));
                localIntent.putExtra("extra_object", localagk.toByteArray());
                localIntent.putExtra("scene", EmojiStoreV2SingleProductUI.j(EmojiStoreV2SingleProductUI.this));
                localIntent.putExtra("searchID", EmojiStoreV2SingleProductUI.k(EmojiStoreV2SingleProductUI.this));
                localIntent.putExtra("add_source", 5);
                localIntent.putExtra("entrance_scene", 29);
                localIntent.setClass(EmojiStoreV2SingleProductUI.this.getContext(), EmojiStoreV2SingleProductDialogUI.class);
                EmojiStoreV2SingleProductUI.this.startActivityForResult(localIntent, 5001);
                EmojiStoreV2SingleProductUI.this.overridePendingTransition(2130772095, 2130772100);
                com.tencent.mm.plugin.report.service.g.yxI.f(12787, new Object[] { Integer.valueOf(EmojiStoreV2SingleProductUI.j(EmojiStoreV2SingleProductUI.this)), Integer.valueOf(0), localagk.Md5, Long.valueOf(EmojiStoreV2SingleProductUI.k(EmojiStoreV2SingleProductUI.this)), localagk.GwF, localagk.ProductID, Integer.valueOf(29) });
                AppMethodBeat.o(109328);
                return;
              }
              catch (Exception localException) {}
            }
          }
          AppMethodBeat.o(109328);
        }
      };
      this.pVf = ((PreViewListGridView)findViewById(2131301443));
      this.agn = z.jV(getContext()).inflate(2131493812, null);
      this.pVh = this.agn.findViewById(2131299387);
      this.pVi = ((TextView)this.agn.findViewById(2131299450));
      this.pVf.addHeaderView(this.agn);
      this.pVj = z.jV(getContext()).inflate(2131493799, null);
      this.pVf.addFooterView(this.pVj);
      this.pVj.setVisibility(8);
      this.pVf.setAdapter(this.pVg);
      this.pVf.setOnScrollListener(this);
      this.pTt = ((MMPullDownView)findViewById(2131301488));
      this.pTt.setTopViewVisible(false);
      this.pTt.setOnBottomLoadDataListener(this.pVw);
      this.pTt.setAtBottomCallBack(this.pVx);
      this.pTt.setBottomViewVisible(false);
      this.pTt.setIsBottomShowAll(false);
      this.pTt.setIsReturnSuperDispatchWhenCancel(true);
      this.pVp = ((LabelContainerView)findViewById(2131304507));
      this.pVq = ((TextView)this.pVp.findViewById(16908310));
      this.pVq.setText(2131760617);
      this.pVr = ((MMTagPanel)this.pVp.findViewById(2131298672));
      this.pVr.setTagSelectedBG(2131234292);
      this.pVr.setTagSelectedTextColorRes(2131101171);
      this.pVo = getString(2131758377);
      this.pVp.setOnLabelContainerListener(new LabelContainerView.a()
      {
        public final void ckg()
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
        
        public final void ckh()
        {
          AppMethodBeat.i(109330);
          EmojiStoreV2SingleProductUI.this.hideVKB();
          AppMethodBeat.o(109330);
        }
      });
      this.pVr.setCallBack(new MMTagPanel.a()
      {
        public final void D(boolean paramAnonymousBoolean, int paramAnonymousInt) {}
        
        public final void acT(String paramAnonymousString)
        {
          AppMethodBeat.i(109331);
          if ((!bu.isNullOrNil(EmojiStoreV2SingleProductUI.l(EmojiStoreV2SingleProductUI.this))) && (!bu.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.equals(EmojiStoreV2SingleProductUI.l(EmojiStoreV2SingleProductUI.this)))) {
            EmojiStoreV2SingleProductUI.m(EmojiStoreV2SingleProductUI.this).cS(EmojiStoreV2SingleProductUI.l(EmojiStoreV2SingleProductUI.this), true);
          }
          AppMethodBeat.o(109331);
        }
        
        public final void acU(String paramAnonymousString)
        {
          AppMethodBeat.i(109332);
          EmojiStoreV2SingleProductUI.a(EmojiStoreV2SingleProductUI.this, paramAnonymousString);
          AppMethodBeat.o(109332);
        }
        
        public final void acV(String paramAnonymousString) {}
        
        public final void acW(String paramAnonymousString) {}
        
        public final void acX(String paramAnonymousString) {}
        
        public final void cki() {}
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
            com.tencent.mm.plugin.report.service.g.yxI.kvStat(12788, "1");
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
          ae.d("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "on shard click.");
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
          if (!bu.isNullOrNil(str1))
          {
            ae.d("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "..".concat(String.valueOf(str1)));
            int i = this.pUY;
            String str2 = this.pUZ;
            String str3 = this.pVb;
            String str4 = this.pVa;
            String str5 = this.pVc;
            int j = this.pVe;
            com.tencent.mm.plugin.emoji.model.k.cig();
            j.a(this, str1, 27, i, str2, str3, str4, str5, j, "https://support.weixin.qq.com/cgi-bin/readtemplate?t=page/common_page__upgrade&text=text000&btn_text=btn_text_0&title=title_0");
          }
        }
      }
    }
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(109341);
    if ((this.pVp != null) && (this.pVp.getVisibility() == 0))
    {
      this.pVp.setVisibility(8);
      if (this.pVk) {}
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
    this.pSU = getIntent().getIntExtra("uin", 0);
    this.fIQ = getIntent().getStringExtra("Select_Conv_User");
    this.pLp = getIntent().getLongExtra("searchID", 0L);
    this.pMy = getIntent().getStringExtra("id");
    paramBundle = getIntent().getStringExtra("tag_id");
    if (!bu.isNullOrNil(paramBundle)) {}
    try
    {
      this.pUW = Integer.valueOf(paramBundle).intValue();
      this.pUX = getIntent().getStringExtra("tag_desc");
      this.pMw = getIntent().getStringExtra("keyword");
      this.pUY = getIntent().getIntExtra("set_id", 0);
      this.pUZ = getIntent().getStringExtra("set_title");
      this.pVa = getIntent().getStringExtra("set_iconURL");
      this.pVb = getIntent().getStringExtra("set_desc");
      this.pVc = getIntent().getStringExtra("headurl");
      this.pVd = getIntent().getStringExtra("sns_object_data");
      this.pVe = getIntent().getIntExtra("pageType", 0);
      if (!bu.isNullOrNil(this.pVd))
      {
        this.pUY = EmojiLogic.acB(this.pVd);
        this.pUZ = EmojiLogic.acC(this.pVd);
        this.pVa = EmojiLogic.acE(this.pVd);
        this.pVb = EmojiLogic.acD(this.pVd);
        this.pVc = EmojiLogic.acF(this.pVd);
        this.pVe = EmojiLogic.acG(this.pVd);
      }
      switch (this.pVe)
      {
      default: 
        this.pVu = true;
        if (this.pVu)
        {
          paramBundle = new Intent();
          com.tencent.mm.plugin.emoji.model.k.cig();
          paramBundle.putExtra("rawUrl", "https://support.weixin.qq.com/cgi-bin/readtemplate?t=page/common_page__upgrade&text=text000&btn_text=btn_text_0&title=title_0");
          paramBundle.putExtra("showShare", false);
          d.b(this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramBundle);
          finish();
        }
        initView();
        if ((this.pSU == 0) && (this.pVe == 2))
        {
          paramBundle = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().Jga.aWs(this.pMy);
          if ((paramBundle != null) && (paramBundle.GQO != null) && (paramBundle.GQO.DesignerUin != 0) && (!bu.isNullOrNil(paramBundle.GQO.Name)))
          {
            this.pSU = paramBundle.GQO.DesignerUin;
            ae.i("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "uin:%s ", new Object[] { Integer.valueOf(this.pSU) });
          }
        }
        else
        {
          i = 0;
          if (i != 0) {
            break label772;
          }
          Zm();
          com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IKU, Boolean.FALSE);
          com.tencent.mm.kernel.g.ajQ().gDv.a(821, this);
          com.tencent.mm.kernel.g.ajQ().gDv.a(239, this);
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
        ae.e("MicroMsg.emoji.EmojiStoreV2SingleProductUI", bu.o(paramBundle));
        continue;
        if (!bu.isNullOrNil(this.pMw))
        {
          this.pVe = 5;
          this.pVk = false;
          this.mScene = 2;
        }
        else if (!bu.isNullOrNil(this.pMy))
        {
          this.pVe = 2;
          this.mScene = 1;
        }
        else if (this.pSU != 0)
        {
          this.pVe = 3;
          this.mScene = 1;
        }
        else if (this.pUW != 0)
        {
          this.mScene = 3;
          this.pVe = 4;
        }
        else if (this.pUY > 0)
        {
          this.pVe = 6;
          this.mScene = 4;
        }
        else
        {
          this.pVe = 1;
          this.mScene = 0;
          continue;
          this.mScene = 0;
          continue;
          if (bu.isNullOrNil(this.pMy))
          {
            continue;
            if (this.pSU == 0)
            {
              continue;
              if (this.pUW == 0)
              {
                continue;
                if (bu.isNullOrNil(this.pMw))
                {
                  continue;
                  if (this.pUY == 0)
                  {
                    continue;
                    i = 1;
                    continue;
                    label772:
                    this.pTv = new i(this.pMy);
                    com.tencent.mm.kernel.g.ajQ().gDv.a(this.pTv, 0);
                    acR(getString(2131755936));
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
    com.tencent.mm.kernel.g.ajQ().gDv.b(239, this);
    com.tencent.mm.kernel.g.ajQ().gDv.b(821, this);
    super.onDestroy();
    AppMethodBeat.o(109338);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(109337);
    super.onPause();
    com.tencent.mm.sdk.b.a.IvT.d(this.pVv);
    AppMethodBeat.o(109337);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(109336);
    super.onResume();
    com.tencent.mm.sdk.b.a.IvT.c(this.pVv);
    AppMethodBeat.o(109336);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(109351);
    int i = paramn.getType();
    if (i == 821)
    {
      ciY();
      paramString = (com.tencent.mm.plugin.emoji.f.h)paramn;
      paramn = paramString.cit();
      this.isLoading = false;
      if (this.pVj != null)
      {
        this.pVj.setVisibility(8);
        this.mHandler.removeMessages(1002);
        this.mHandler.sendEmptyMessageDelayed(1001, 200L);
      }
      i = paramString.jgW;
      if (((paramInt1 == 0) && (paramInt2 == 0)) || ((paramInt1 == 4) && ((paramInt2 == 2) || (paramInt2 == 3)) && ((this.pVm == null) || (this.pVm.length <= 0)) && (i != 3))) {
        a(paramn);
      }
      if ((paramInt1 == 0) || (paramInt1 == 4))
      {
        this.pVm = paramString.pMu;
        if (paramInt2 == 0)
        {
          Z(paramn.GQM);
          this.pVn = 0;
          AppMethodBeat.o(109351);
          return;
        }
        if (paramInt2 == 2)
        {
          Z(paramn.GQM);
          this.pVn = 2;
          AppMethodBeat.o(109351);
          return;
        }
        if (paramInt2 == 3)
        {
          this.pVn = -1;
          Z(paramn.GQM);
          AppMethodBeat.o(109351);
          return;
        }
        ckf();
        AppMethodBeat.o(109351);
        return;
      }
      ckf();
      AppMethodBeat.o(109351);
      return;
    }
    if (i == 239)
    {
      ciY();
      if ((paramInt2 == 0) && (paramInt1 == 0))
      {
        paramString = ((i)paramn).ciu();
        if ((paramString != null) && (paramString.GQO != null))
        {
          this.pSU = paramString.GQO.DesignerUin;
          if (this.mHandler != null) {
            this.mHandler.sendEmptyMessage(1004);
          }
        }
        AppMethodBeat.o(109351);
        return;
      }
      showOptionMenu(1001, false);
      com.tencent.mm.ui.base.h.c(getContext(), getString(2131758253), null, true);
      ae.e("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "open single product ui failed.");
    }
    AppMethodBeat.o(109351);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(109352);
    if ((paramInt == 0) && (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1) && (this.pVn == 2) && (!this.isLoading))
    {
      ae.d("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "No More List.");
      cke();
      ae.i("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "[onScrollStateChanged] startLoadRemoteEmoji.");
    }
    if ((paramInt != 0) && (this.pVf != null)) {
      this.pVf.cko();
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