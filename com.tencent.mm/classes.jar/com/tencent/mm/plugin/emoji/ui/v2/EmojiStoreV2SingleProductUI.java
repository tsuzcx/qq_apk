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
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.di;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.emoji.e.j;
import com.tencent.mm.plugin.emoji.f.i;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.protocal.protobuf.PersonalDesigner;
import com.tencent.mm.protocal.protobuf.agb;
import com.tencent.mm.protocal.protobuf.age;
import com.tencent.mm.protocal.protobuf.bab;
import com.tencent.mm.protocal.protobuf.bad;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.bd;
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
  private String fGM;
  private ProgressDialog iYL;
  private boolean isLoading;
  private ap mHandler;
  private int mScene;
  private long pEL;
  private String pFS;
  private String pFU;
  private MMPullDownView pMO;
  private i pMQ;
  private int pMp;
  private PreViewListGridView pOA;
  private a pOB;
  private View pOC;
  private TextView pOD;
  private View pOE;
  private boolean pOF;
  private bab pOG;
  private byte[] pOH;
  private int pOI;
  private String pOJ;
  private LabelContainerView pOK;
  private TextView pOL;
  private MMTagPanel pOM;
  private HashMap<String, Integer> pON;
  private ArrayList<String> pOO;
  private boolean pOP;
  private c pOQ;
  private MMPullDownView.e pOR;
  private MMPullDownView.c pOS;
  private int pOr;
  private String pOs;
  private int pOt;
  private String pOu;
  private String pOv;
  private String pOw;
  private String pOx;
  private String pOy;
  private int pOz;
  
  public EmojiStoreV2SingleProductUI()
  {
    AppMethodBeat.i(109334);
    this.pMp = 0;
    this.pOt = -1;
    this.pOz = 0;
    this.pOF = true;
    this.pOI = -1;
    this.isLoading = false;
    this.pON = new HashMap();
    this.pOP = false;
    this.mHandler = new ap()
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
    this.pOQ = new c() {};
    this.pOR = new MMPullDownView.e()
    {
      public final boolean cba()
      {
        AppMethodBeat.i(109326);
        ad.i("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "onBottom");
        EmojiStoreV2SingleProductUI.e(EmojiStoreV2SingleProductUI.this);
        AppMethodBeat.o(109326);
        return true;
      }
    };
    this.pOS = new MMPullDownView.c()
    {
      public final boolean cbc()
      {
        return false;
      }
    };
    AppMethodBeat.o(109334);
  }
  
  private void Z(LinkedList<agb> paramLinkedList)
  {
    AppMethodBeat.i(109349);
    if ((this.pOB != null) && (paramLinkedList != null))
    {
      if (this.pOI == -1)
      {
        this.pOB.V(paramLinkedList);
        AppMethodBeat.o(109349);
        return;
      }
      a locala = this.pOB;
      if (locala.pAZ == null) {
        locala.pAZ = new ArrayList();
      }
      locala.pAZ.addAll(paramLinkedList);
      locala.notifyDataSetChanged();
    }
    AppMethodBeat.o(109349);
  }
  
  private void Zd()
  {
    AppMethodBeat.i(109342);
    if (this.pOP)
    {
      ad.i("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "need jeep to update page.");
      AppMethodBeat.o(109342);
      return;
    }
    this.pOH = null;
    switch (this.pOz)
    {
    }
    for (;;)
    {
      bc(this.pOH);
      AppMethodBeat.o(109342);
      return;
      this.pOG = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().ILt.aUS("0");
      if ((this.pOG != null) && (this.pOG.Gxm != null) && (this.pOB != null))
      {
        a(this.pOG);
        this.pOB.V(this.pOG.Gxm);
      }
      for (;;)
      {
        this.pOF = true;
        com.tencent.mm.plugin.report.service.g.yhR.f(12875, new Object[] { Integer.valueOf(0), "" });
        break;
        aca(getString(2131755936));
      }
      showOptionMenu(1001, false);
      this.pOF = false;
      com.tencent.mm.plugin.report.service.g.yhR.f(12875, new Object[] { Integer.valueOf(1), this.pFU });
      continue;
      showOptionMenu(1001, false);
      this.pOJ = this.pOs;
      acb(this.pOJ);
      this.pOF = false;
      com.tencent.mm.plugin.report.service.g.yhR.f(12875, new Object[] { Integer.valueOf(1), "" });
      continue;
      this.pOJ = "";
      acb(this.pFS);
      this.pOF = false;
      com.tencent.mm.plugin.report.service.g.yhR.f(12875, new Object[] { Integer.valueOf(2), "" });
      continue;
      this.pOJ = "";
      showOptionMenu(1001, false);
      showOptionMenu(1002, true);
      com.tencent.mm.plugin.report.service.g.yhR.f(12875, new Object[] { Integer.valueOf(3), "" });
    }
  }
  
  private void a(bab parambab)
  {
    boolean bool = false;
    AppMethodBeat.i(109346);
    if ((parambab != null) && (parambab.Gxn != null) && (parambab.Gxn.size() > 0))
    {
      if (this.pOF) {
        bool = true;
      }
      showOptionMenu(1001, bool);
      if (this.pOM != null)
      {
        if (this.pOO == null) {
          this.pOO = new ArrayList();
        }
        for (;;)
        {
          if (this.pON == null) {
            this.pON = new HashMap();
          }
          this.pON.clear();
          this.pOO.add(getString(2131758377));
          parambab = parambab.Gxn.iterator();
          while (parambab.hasNext())
          {
            age localage = (age)parambab.next();
            if ((localage != null) && (!bt.isNullOrNil(localage.Geh)))
            {
              this.pOO.add(localage.Geh);
              this.pON.put(localage.Geh, Integer.valueOf(localage.Geg));
            }
          }
          this.pOO.clear();
        }
        parambab = new ArrayList();
        parambab.add(this.pOJ);
        this.pOM.a(parambab, this.pOO);
        AppMethodBeat.o(109346);
      }
    }
    else
    {
      showOptionMenu(1001, false);
    }
    AppMethodBeat.o(109346);
  }
  
  private void aca(String paramString)
  {
    AppMethodBeat.i(109343);
    if (isFinishing())
    {
      ad.i("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "[showLoadingDialog] acitivity is finished.");
      AppMethodBeat.o(109343);
      return;
    }
    getString(2131755906);
    this.iYL = com.tencent.mm.ui.base.h.b(this, paramString, true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(109321);
        if (EmojiStoreV2SingleProductUI.p(EmojiStoreV2SingleProductUI.this) != null) {
          com.tencent.mm.kernel.g.ajB().gAO.a(EmojiStoreV2SingleProductUI.p(EmojiStoreV2SingleProductUI.this));
        }
        AppMethodBeat.o(109321);
      }
    });
    AppMethodBeat.o(109343);
  }
  
  private void acb(String paramString)
  {
    AppMethodBeat.i(109347);
    if ((this.pOC != null) && (this.pOD != null)) {
      switch (this.pOz)
      {
      }
    }
    for (;;)
    {
      if (bt.isNullOrNil(paramString))
      {
        this.pOD.setText("");
        this.pOD.setVisibility(8);
        this.pOC.setVisibility(8);
      }
      AppMethodBeat.o(109347);
      return;
      if (!bt.isNullOrNil(paramString))
      {
        this.pOD.setText(getString(2131758378, new Object[] { paramString }));
        this.pOD.setVisibility(0);
        this.pOC.setVisibility(0);
        continue;
        if (!bt.isNullOrNil(paramString))
        {
          this.pOD.setText(getString(2131758373, new Object[] { paramString }));
          this.pOD.setVisibility(0);
          this.pOC.setVisibility(0);
        }
      }
    }
  }
  
  private void bc(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(109345);
    this.pOH = null;
    switch (this.pOz)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(109345);
      return;
      paramArrayOfByte = new com.tencent.mm.plugin.emoji.f.h(1, this.pMp, this.pOr, this.pFS, this.pOt, paramArrayOfByte);
      com.tencent.mm.kernel.g.ajB().gAO.a(paramArrayOfByte, 0);
      AppMethodBeat.o(109345);
      return;
      paramArrayOfByte = new com.tencent.mm.plugin.emoji.f.h(2, this.pMp, this.pOr, this.pFS, this.pOt, paramArrayOfByte);
      com.tencent.mm.kernel.g.ajB().gAO.a(paramArrayOfByte, 0);
      AppMethodBeat.o(109345);
      return;
      paramArrayOfByte = new com.tencent.mm.plugin.emoji.f.h(3, this.pMp, this.pOr, this.pFS, this.pOt, paramArrayOfByte);
      com.tencent.mm.kernel.g.ajB().gAO.a(paramArrayOfByte, 0);
      AppMethodBeat.o(109345);
      return;
      paramArrayOfByte = new com.tencent.mm.plugin.emoji.f.h(4, this.pMp, this.pOr, this.pFS, this.pOt, paramArrayOfByte);
      com.tencent.mm.kernel.g.ajB().gAO.a(paramArrayOfByte, 0);
      AppMethodBeat.o(109345);
      return;
      paramArrayOfByte = new com.tencent.mm.plugin.emoji.f.h(5, this.pMp, this.pOr, this.pFS, this.pOt, paramArrayOfByte);
      com.tencent.mm.kernel.g.ajB().gAO.a(paramArrayOfByte, 0);
    }
  }
  
  private void chI()
  {
    AppMethodBeat.i(109344);
    if ((this.iYL != null) && (this.iYL.isShowing())) {
      this.iYL.dismiss();
    }
    AppMethodBeat.o(109344);
  }
  
  private void ciO()
  {
    AppMethodBeat.i(109348);
    if (!this.isLoading)
    {
      bc(this.pOH);
      this.isLoading = true;
      this.mHandler.sendEmptyMessageDelayed(1002, 200L);
    }
    AppMethodBeat.o(109348);
  }
  
  private void ciP()
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
    if ((this.pOz == 6) && (!bt.isNullOrNil(this.pOu))) {
      setMMTitle(this.pOu);
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
      this.pOB = new a(getContext());
      this.pOB.pPE = new a.a()
      {
        public final void BU(int paramAnonymousInt)
        {
          AppMethodBeat.i(109328);
          if ((EmojiStoreV2SingleProductUI.h(EmojiStoreV2SingleProductUI.this) != null) && (EmojiStoreV2SingleProductUI.c(EmojiStoreV2SingleProductUI.this) != null))
          {
            agb localagb = EmojiStoreV2SingleProductUI.c(EmojiStoreV2SingleProductUI.this).Cj(paramAnonymousInt);
            if (localagb != null) {
              try
              {
                Intent localIntent = new Intent();
                localIntent.putExtra("Select_Conv_User", EmojiStoreV2SingleProductUI.i(EmojiStoreV2SingleProductUI.this));
                localIntent.putExtra("extra_object", localagb.toByteArray());
                localIntent.putExtra("scene", EmojiStoreV2SingleProductUI.j(EmojiStoreV2SingleProductUI.this));
                localIntent.putExtra("searchID", EmojiStoreV2SingleProductUI.k(EmojiStoreV2SingleProductUI.this));
                localIntent.putExtra("add_source", 5);
                localIntent.putExtra("entrance_scene", 29);
                localIntent.setClass(EmojiStoreV2SingleProductUI.this.getContext(), EmojiStoreV2SingleProductDialogUI.class);
                EmojiStoreV2SingleProductUI.this.startActivityForResult(localIntent, 5001);
                EmojiStoreV2SingleProductUI.this.overridePendingTransition(2130772095, 2130772100);
                com.tencent.mm.plugin.report.service.g.yhR.f(12787, new Object[] { Integer.valueOf(EmojiStoreV2SingleProductUI.j(EmojiStoreV2SingleProductUI.this)), Integer.valueOf(0), localagb.Md5, Long.valueOf(EmojiStoreV2SingleProductUI.k(EmojiStoreV2SingleProductUI.this)), localagb.GdY, localagb.ProductID, Integer.valueOf(29) });
                AppMethodBeat.o(109328);
                return;
              }
              catch (Exception localException) {}
            }
          }
          AppMethodBeat.o(109328);
        }
      };
      this.pOA = ((PreViewListGridView)findViewById(2131301443));
      this.agn = z.jO(getContext()).inflate(2131493812, null);
      this.pOC = this.agn.findViewById(2131299387);
      this.pOD = ((TextView)this.agn.findViewById(2131299450));
      this.pOA.addHeaderView(this.agn);
      this.pOE = z.jO(getContext()).inflate(2131493799, null);
      this.pOA.addFooterView(this.pOE);
      this.pOE.setVisibility(8);
      this.pOA.setAdapter(this.pOB);
      this.pOA.setOnScrollListener(this);
      this.pMO = ((MMPullDownView)findViewById(2131301488));
      this.pMO.setTopViewVisible(false);
      this.pMO.setOnBottomLoadDataListener(this.pOR);
      this.pMO.setAtBottomCallBack(this.pOS);
      this.pMO.setBottomViewVisible(false);
      this.pMO.setIsBottomShowAll(false);
      this.pMO.setIsReturnSuperDispatchWhenCancel(true);
      this.pOK = ((LabelContainerView)findViewById(2131304507));
      this.pOL = ((TextView)this.pOK.findViewById(16908310));
      this.pOL.setText(2131760617);
      this.pOM = ((MMTagPanel)this.pOK.findViewById(2131298672));
      this.pOM.setTagSelectedBG(2131234292);
      this.pOM.setTagSelectedTextColorRes(2131101171);
      this.pOJ = getString(2131758377);
      this.pOK.setOnLabelContainerListener(new LabelContainerView.a()
      {
        public final void ciQ()
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
        
        public final void ciR()
        {
          AppMethodBeat.i(109330);
          EmojiStoreV2SingleProductUI.this.hideVKB();
          AppMethodBeat.o(109330);
        }
      });
      this.pOM.setCallBack(new MMTagPanel.a()
      {
        public final void C(boolean paramAnonymousBoolean, int paramAnonymousInt) {}
        
        public final void acc(String paramAnonymousString)
        {
          AppMethodBeat.i(109331);
          if ((!bt.isNullOrNil(EmojiStoreV2SingleProductUI.l(EmojiStoreV2SingleProductUI.this))) && (!bt.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.equals(EmojiStoreV2SingleProductUI.l(EmojiStoreV2SingleProductUI.this)))) {
            EmojiStoreV2SingleProductUI.m(EmojiStoreV2SingleProductUI.this).cO(EmojiStoreV2SingleProductUI.l(EmojiStoreV2SingleProductUI.this), true);
          }
          AppMethodBeat.o(109331);
        }
        
        public final void acd(String paramAnonymousString)
        {
          AppMethodBeat.i(109332);
          EmojiStoreV2SingleProductUI.a(EmojiStoreV2SingleProductUI.this, paramAnonymousString);
          AppMethodBeat.o(109332);
        }
        
        public final void ace(String paramAnonymousString) {}
        
        public final void acf(String paramAnonymousString) {}
        
        public final void acg(String paramAnonymousString) {}
        
        public final void ciS() {}
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
            com.tencent.mm.plugin.report.service.g.yhR.kvStat(12788, "1");
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
          ad.d("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "on shard click.");
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
          if (!bt.isNullOrNil(str1))
          {
            ad.d("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "..".concat(String.valueOf(str1)));
            int i = this.pOt;
            String str2 = this.pOu;
            String str3 = this.pOw;
            String str4 = this.pOv;
            String str5 = this.pOx;
            int j = this.pOz;
            com.tencent.mm.plugin.emoji.model.k.cgQ();
            j.a(this, str1, 27, i, str2, str3, str4, str5, j, "https://support.weixin.qq.com/cgi-bin/readtemplate?t=page/common_page__upgrade&text=text000&btn_text=btn_text_0&title=title_0");
          }
        }
      }
    }
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(109341);
    if ((this.pOK != null) && (this.pOK.getVisibility() == 0))
    {
      this.pOK.setVisibility(8);
      if (this.pOF) {}
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
    this.pMp = getIntent().getIntExtra("uin", 0);
    this.fGM = getIntent().getStringExtra("Select_Conv_User");
    this.pEL = getIntent().getLongExtra("searchID", 0L);
    this.pFU = getIntent().getStringExtra("id");
    paramBundle = getIntent().getStringExtra("tag_id");
    if (!bt.isNullOrNil(paramBundle)) {}
    try
    {
      this.pOr = Integer.valueOf(paramBundle).intValue();
      this.pOs = getIntent().getStringExtra("tag_desc");
      this.pFS = getIntent().getStringExtra("keyword");
      this.pOt = getIntent().getIntExtra("set_id", 0);
      this.pOu = getIntent().getStringExtra("set_title");
      this.pOv = getIntent().getStringExtra("set_iconURL");
      this.pOw = getIntent().getStringExtra("set_desc");
      this.pOx = getIntent().getStringExtra("headurl");
      this.pOy = getIntent().getStringExtra("sns_object_data");
      this.pOz = getIntent().getIntExtra("pageType", 0);
      if (!bt.isNullOrNil(this.pOy))
      {
        this.pOt = EmojiLogic.abK(this.pOy);
        this.pOu = EmojiLogic.abL(this.pOy);
        this.pOv = EmojiLogic.abN(this.pOy);
        this.pOw = EmojiLogic.abM(this.pOy);
        this.pOx = EmojiLogic.abO(this.pOy);
        this.pOz = EmojiLogic.abP(this.pOy);
      }
      switch (this.pOz)
      {
      default: 
        this.pOP = true;
        if (this.pOP)
        {
          paramBundle = new Intent();
          com.tencent.mm.plugin.emoji.model.k.cgQ();
          paramBundle.putExtra("rawUrl", "https://support.weixin.qq.com/cgi-bin/readtemplate?t=page/common_page__upgrade&text=text000&btn_text=btn_text_0&title=title_0");
          paramBundle.putExtra("showShare", false);
          d.b(this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramBundle);
          finish();
        }
        initView();
        if ((this.pMp == 0) && (this.pOz == 2))
        {
          paramBundle = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().ILt.aUR(this.pFU);
          if ((paramBundle != null) && (paramBundle.Gxo != null) && (paramBundle.Gxo.DesignerUin != 0) && (!bt.isNullOrNil(paramBundle.Gxo.Name)))
          {
            this.pMp = paramBundle.Gxo.DesignerUin;
            ad.i("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "uin:%s ", new Object[] { Integer.valueOf(this.pMp) });
          }
        }
        else
        {
          i = 0;
          if (i != 0) {
            break label772;
          }
          Zd();
          com.tencent.mm.kernel.g.ajC().ajl().set(al.a.Iqy, Boolean.FALSE);
          com.tencent.mm.kernel.g.ajB().gAO.a(821, this);
          com.tencent.mm.kernel.g.ajB().gAO.a(239, this);
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
        ad.e("MicroMsg.emoji.EmojiStoreV2SingleProductUI", bt.n(paramBundle));
        continue;
        if (!bt.isNullOrNil(this.pFS))
        {
          this.pOz = 5;
          this.pOF = false;
          this.mScene = 2;
        }
        else if (!bt.isNullOrNil(this.pFU))
        {
          this.pOz = 2;
          this.mScene = 1;
        }
        else if (this.pMp != 0)
        {
          this.pOz = 3;
          this.mScene = 1;
        }
        else if (this.pOr != 0)
        {
          this.mScene = 3;
          this.pOz = 4;
        }
        else if (this.pOt > 0)
        {
          this.pOz = 6;
          this.mScene = 4;
        }
        else
        {
          this.pOz = 1;
          this.mScene = 0;
          continue;
          this.mScene = 0;
          continue;
          if (bt.isNullOrNil(this.pFU))
          {
            continue;
            if (this.pMp == 0)
            {
              continue;
              if (this.pOr == 0)
              {
                continue;
                if (bt.isNullOrNil(this.pFS))
                {
                  continue;
                  if (this.pOt == 0)
                  {
                    continue;
                    i = 1;
                    continue;
                    label772:
                    this.pMQ = new i(this.pFU);
                    com.tencent.mm.kernel.g.ajB().gAO.a(this.pMQ, 0);
                    aca(getString(2131755936));
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
    com.tencent.mm.kernel.g.ajB().gAO.b(239, this);
    com.tencent.mm.kernel.g.ajB().gAO.b(821, this);
    super.onDestroy();
    AppMethodBeat.o(109338);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(109337);
    super.onPause();
    com.tencent.mm.sdk.b.a.IbL.d(this.pOQ);
    AppMethodBeat.o(109337);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(109336);
    super.onResume();
    com.tencent.mm.sdk.b.a.IbL.c(this.pOQ);
    AppMethodBeat.o(109336);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(109351);
    int i = paramn.getType();
    if (i == 821)
    {
      chI();
      paramString = (com.tencent.mm.plugin.emoji.f.h)paramn;
      paramn = paramString.chd();
      this.isLoading = false;
      if (this.pOE != null)
      {
        this.pOE.setVisibility(8);
        this.mHandler.removeMessages(1002);
        this.mHandler.sendEmptyMessageDelayed(1001, 200L);
      }
      i = paramString.jed;
      if (((paramInt1 == 0) && (paramInt2 == 0)) || ((paramInt1 == 4) && ((paramInt2 == 2) || (paramInt2 == 3)) && ((this.pOH == null) || (this.pOH.length <= 0)) && (i != 3))) {
        a(paramn);
      }
      if ((paramInt1 == 0) || (paramInt1 == 4))
      {
        this.pOH = paramString.pFQ;
        if (paramInt2 == 0)
        {
          Z(paramn.Gxm);
          this.pOI = 0;
          AppMethodBeat.o(109351);
          return;
        }
        if (paramInt2 == 2)
        {
          Z(paramn.Gxm);
          this.pOI = 2;
          AppMethodBeat.o(109351);
          return;
        }
        if (paramInt2 == 3)
        {
          this.pOI = -1;
          Z(paramn.Gxm);
          AppMethodBeat.o(109351);
          return;
        }
        ciP();
        AppMethodBeat.o(109351);
        return;
      }
      ciP();
      AppMethodBeat.o(109351);
      return;
    }
    if (i == 239)
    {
      chI();
      if ((paramInt2 == 0) && (paramInt1 == 0))
      {
        paramString = ((i)paramn).che();
        if ((paramString != null) && (paramString.Gxo != null))
        {
          this.pMp = paramString.Gxo.DesignerUin;
          if (this.mHandler != null) {
            this.mHandler.sendEmptyMessage(1004);
          }
        }
        AppMethodBeat.o(109351);
        return;
      }
      showOptionMenu(1001, false);
      com.tencent.mm.ui.base.h.c(getContext(), getString(2131758253), null, true);
      ad.e("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "open single product ui failed.");
    }
    AppMethodBeat.o(109351);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(109352);
    if ((paramInt == 0) && (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1) && (this.pOI == 2) && (!this.isLoading))
    {
      ad.d("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "No More List.");
      ciO();
      ad.i("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "[onScrollStateChanged] startLoadRemoteEmoji.");
    }
    if ((paramInt != 0) && (this.pOA != null)) {
      this.pOA.ciY();
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