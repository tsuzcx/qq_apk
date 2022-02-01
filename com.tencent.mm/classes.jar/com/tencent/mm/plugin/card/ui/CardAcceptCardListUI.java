package com.tencent.mm.plugin.card.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.card.d.d;
import com.tencent.mm.plugin.card.d.f;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.ab;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.protocal.protobuf.rb;
import com.tencent.mm.protocal.protobuf.ro;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CardAcceptCardListUI
  extends MMActivity
  implements com.tencent.mm.al.g, MMActivity.a
{
  private View DU;
  int dye;
  private com.tencent.mm.ui.base.p ftP;
  private String gIj;
  protected ListView npK;
  protected RelativeLayout npM;
  private boolean nrB;
  private String ntG;
  private int ntH;
  private String ntI;
  private int ntJ;
  private String ntK;
  public ArrayList<String> nwA;
  public ArrayList<String> nwB;
  private Button nwq;
  public int nwx;
  private String nwy;
  private String nwz;
  HashMap<String, Integer> nxK;
  private View nxQ;
  private View nxR;
  protected a nxS;
  private View nxT;
  private View nxU;
  private TextView nxV;
  private Button nxW;
  LinkedList<rb> nxX;
  int nxY;
  String nxZ;
  String nya;
  private String nyb;
  LinkedList<rb> nyc;
  LinkedList<String> nyd;
  
  public CardAcceptCardListUI()
  {
    AppMethodBeat.i(113155);
    this.npK = null;
    this.nxS = null;
    this.npM = null;
    this.ftP = null;
    this.nxX = new LinkedList();
    this.ntG = "";
    this.dye = 8;
    this.nxY = 7;
    this.nxZ = "";
    this.nya = "";
    this.nyb = "";
    this.nrB = false;
    this.nwx = 0;
    this.nwy = "";
    this.nwz = "";
    this.nwA = new ArrayList();
    this.nwB = new ArrayList();
    this.nyc = new LinkedList();
    this.nyd = new LinkedList();
    this.nxK = new HashMap();
    this.gIj = "";
    AppMethodBeat.o(113155);
  }
  
  private String bJI()
  {
    AppMethodBeat.i(113164);
    String str;
    if ((!TextUtils.isEmpty(this.nwy)) && (!TextUtils.isEmpty(this.nwz)))
    {
      str = this.nwy + "," + l.Rp(this.nwz);
      AppMethodBeat.o(113164);
      return str;
    }
    if (!TextUtils.isEmpty(this.nwy))
    {
      str = this.nwy;
      AppMethodBeat.o(113164);
      return str;
    }
    if (!TextUtils.isEmpty(this.nwz))
    {
      str = l.Rp(this.nwz);
      AppMethodBeat.o(113164);
      return str;
    }
    AppMethodBeat.o(113164);
    return "";
  }
  
  private void bKc()
  {
    AppMethodBeat.i(113165);
    if (!TextUtils.isEmpty(this.ntK))
    {
      this.nxV.setText(this.ntK);
      AppMethodBeat.o(113165);
      return;
    }
    this.nxV.setText(2131756980);
    AppMethodBeat.o(113165);
  }
  
  private ArrayList<CardInfo> cy(List<CardInfo> paramList)
  {
    AppMethodBeat.i(113166);
    if ((paramList == null) || (paramList.size() == 0))
    {
      ad.e("MicroMsg.CardAcceptCardListUI", "geCardInfoListByTpId list is empty!");
      AppMethodBeat.o(113166);
      return null;
    }
    this.nyc.clear();
    this.nyd.clear();
    this.nxK.clear();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < paramList.size())
    {
      CardInfo localCardInfo = (CardInfo)paramList.get(i);
      if (this.nyd.contains(localCardInfo.field_card_tp_id))
      {
        int j = ((Integer)this.nxK.get(localCardInfo.field_card_tp_id)).intValue();
        this.nxK.put(localCardInfo.field_card_tp_id, Integer.valueOf(j + 1));
      }
      for (;;)
      {
        i += 1;
        break;
        localArrayList.add(localCardInfo);
        this.nxK.put(localCardInfo.field_card_tp_id, Integer.valueOf(1));
        this.nyd.add(localCardInfo.field_card_tp_id);
      }
    }
    AppMethodBeat.o(113166);
    return localArrayList;
  }
  
  private void za(int paramInt)
  {
    AppMethodBeat.i(113162);
    ad.i("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI finishUI() result_code:".concat(String.valueOf(paramInt)));
    Intent localIntent = new Intent();
    localIntent.putExtra("card_list", this.ntG);
    localIntent.putExtra("result_code", paramInt);
    setResult(0, localIntent);
    finish();
    AppMethodBeat.o(113162);
  }
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(113163);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(113163);
      return;
      if (paramInt2 != -1)
      {
        AppMethodBeat.o(113163);
        return;
      }
      this.nwx = paramIntent.getIntExtra("Ktag_range_index", 0);
      ad.i("MicroMsg.CardAcceptCardListUI", "mPrivateSelelct : %d", new Object[] { Integer.valueOf(this.nwx) });
      if (this.nwx >= 2)
      {
        this.nwy = paramIntent.getStringExtra("Klabel_name_list");
        this.nwz = paramIntent.getStringExtra("Kother_user_name_list");
        ad.d("MicroMsg.CardAcceptCardListUI", "mPrivateSelect : %d, names : %s", new Object[] { Integer.valueOf(this.nwx), this.nwy });
        if ((TextUtils.isEmpty(this.nwy)) && (TextUtils.isEmpty(this.nwz)))
        {
          ad.e("MicroMsg.CardAcceptCardListUI", "mLabelNameList by getIntent is empty");
          bKc();
          AppMethodBeat.o(113163);
          return;
        }
        paramIntent = Arrays.asList(this.nwy.split(","));
        this.nwB = l.cE(paramIntent);
        this.nwA = l.cD(paramIntent);
        if ((this.nwz != null) && (this.nwz.length() > 0))
        {
          paramIntent = Arrays.asList(this.nwz.split(","));
          this.nwA.addAll(paramIntent);
        }
        if (this.nwB != null) {
          ad.i("MicroMsg.CardAcceptCardListUI", "mPrivateIdsList size is " + this.nwB.size());
        }
        if (this.nwA != null)
        {
          ad.i("MicroMsg.CardAcceptCardListUI", "mPrivateNamesList size is " + this.nwA.size());
          paramIntent = this.nwA.iterator();
          while (paramIntent.hasNext()) {
            ad.d("MicroMsg.CardAcceptCardListUI", "username : %s", new Object[] { (String)paramIntent.next() });
          }
        }
        if (!TextUtils.isEmpty(this.nwy))
        {
          if (this.nwx == 2)
          {
            this.nxV.setText(getString(2131756982, new Object[] { bJI() }));
            AppMethodBeat.o(113163);
            return;
          }
          if (this.nwx == 3)
          {
            this.nxV.setText(getString(2131756981, new Object[] { bJI() }));
            AppMethodBeat.o(113163);
          }
        }
        else
        {
          bKc();
        }
        AppMethodBeat.o(113163);
        return;
      }
      bKc();
    }
  }
  
  public int getLayoutId()
  {
    return 2131493248;
  }
  
  final void iF(boolean paramBoolean)
  {
    AppMethodBeat.i(113159);
    if (paramBoolean)
    {
      this.ftP = com.tencent.mm.ui.base.p.a(this, getString(2131760709), false, 0, null);
      AppMethodBeat.o(113159);
      return;
    }
    if ((this.ftP != null) && (this.ftP.isShowing()))
    {
      this.ftP.dismiss();
      this.ftP = null;
    }
    AppMethodBeat.o(113159);
  }
  
  public void initView()
  {
    AppMethodBeat.i(113156);
    setMMTitle(2131756788);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(113150);
        ad.v("MicroMsg.CardAcceptCardListUI", "setBackBtn cancel");
        CardAcceptCardListUI.a(CardAcceptCardListUI.this, 1);
        AppMethodBeat.o(113150);
        return true;
      }
    });
    this.nxQ = findViewById(2131297715);
    this.nxR = findViewById(2131306011);
    this.DU = findViewById(2131301449);
    this.nxR.setVisibility(4);
    this.npK = ((ListView)findViewById(16908298));
    this.npM = ((RelativeLayout)findViewById(2131298768));
    this.npK.setEmptyView(this.npM);
    this.nxS = new a(this);
    this.npK.setAdapter(this.nxS);
    this.npK.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong) {}
    });
    this.nxT = findViewById(2131297719);
    this.nwq = ((Button)findViewById(2131297710));
    this.nwq.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(113151);
        if (CardAcceptCardListUI.a(CardAcceptCardListUI.this))
        {
          CardAcceptCardListUI.a(CardAcceptCardListUI.this, CardAcceptCardListUI.b(CardAcceptCardListUI.this));
          AppMethodBeat.o(113151);
          return;
        }
        paramAnonymousView = CardAcceptCardListUI.this;
        LinkedList localLinkedList = CardAcceptCardListUI.b(CardAcceptCardListUI.this);
        paramAnonymousView.iF(true);
        paramAnonymousView = new com.tencent.mm.plugin.card.model.p(localLinkedList, paramAnonymousView.dye, paramAnonymousView.nxZ, paramAnonymousView.nya, paramAnonymousView.nxY);
        com.tencent.mm.kernel.g.afA().gcy.a(paramAnonymousView, 0);
        AppMethodBeat.o(113151);
      }
    });
    this.nwq.setEnabled(false);
    this.nxU = findViewById(2131297879);
    this.nxV = ((TextView)findViewById(2131297880));
    this.nxW = ((Button)findViewById(2131297878));
    this.nxW.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(113152);
        CardAcceptCardListUI.c(CardAcceptCardListUI.this);
        AppMethodBeat.o(113152);
      }
    });
    Object localObject2 = getIntent();
    if (localObject2 == null)
    {
      ad.e("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI initView () intent == null");
      za(2);
      AppMethodBeat.o(113156);
      return;
    }
    ad.i("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI handle data");
    Object localObject3 = ((Intent)localObject2).getStringExtra("key_in_card_list");
    this.dye = ((Intent)localObject2).getIntExtra("key_from_scene", 8);
    Object localObject1 = ((Intent)localObject2).getStringExtra("key_package_name");
    localObject2 = ((Intent)localObject2).getStringExtra("key_sign");
    this.nxY = getIntent().getIntExtra("key_stastic_scene", 7);
    this.nxZ = getIntent().getStringExtra("src_username");
    this.nya = getIntent().getStringExtra("js_url");
    this.nyb = getIntent().getStringExtra("key_consumed_card_id");
    this.gIj = getIntent().getStringExtra("key_template_id");
    localObject3 = com.tencent.mm.plugin.card.d.h.cz((String)localObject3, this.dye);
    if ((localObject3 == null) || (((List)localObject3).size() == 0))
    {
      ad.e("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI initView () tempList == null || tempList.size() == 0");
      za(2);
      AppMethodBeat.o(113156);
      return;
    }
    this.nxX.clear();
    this.nxX.addAll((Collection)localObject3);
    this.nyc.clear();
    this.nyd.clear();
    this.nxK.clear();
    localObject3 = this.nxX;
    iF(true);
    localObject1 = new ab((LinkedList)localObject3, this.dye, (String)localObject1, (String)localObject2, this.nxZ, this.nya, this.nyb, this.nxY);
    com.tencent.mm.kernel.g.afA().gcy.a((com.tencent.mm.al.n)localObject1, 0);
    AppMethodBeat.o(113156);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(113157);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.afA().gcy.a(1079, this);
    com.tencent.mm.kernel.g.afA().gcy.a(1049, this);
    com.tencent.mm.kernel.g.afA().gcy.a(902, this);
    initView();
    AppMethodBeat.o(113157);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113158);
    com.tencent.mm.kernel.g.afA().gcy.b(1079, this);
    com.tencent.mm.kernel.g.afA().gcy.b(1049, this);
    com.tencent.mm.kernel.g.afA().gcy.b(902, this);
    this.nxX.clear();
    a locala = this.nxS;
    locala.nwP.clear();
    locala.mContext = null;
    super.onDestroy();
    AppMethodBeat.o(113158);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(113161);
    if (paramInt == 4)
    {
      ad.i("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI onKeyDown() back cancel");
      za(1);
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(113161);
    return bool;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(113160);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      Object localObject1;
      if ((paramn instanceof ab))
      {
        iF(false);
        paramString = (ab)paramn;
        paramn = paramString.ntw;
        this.ntH = paramString.ntH;
        this.ntI = paramString.ntI;
        this.ntJ = paramString.ntJ;
        this.ntK = paramString.ntK;
        ad.i("MicroMsg.CardAcceptCardListUI", "accept_button_status: " + this.ntH + "  accept_button_wording: " + this.ntI);
        ad.i("MicroMsg.CardAcceptCardListUI", "private_status: " + this.ntJ + "  private_wording: " + this.ntK);
        paramString = f.Rf(paramn);
        paramn = cy(paramString);
        Object localObject2;
        if ((paramString != null) && (paramString.size() > 0))
        {
          ad.i("MicroMsg.CardAcceptCardListUI", "The card info list size is " + paramString.size());
          if ((paramn != null) && (paramn.size() > 0))
          {
            localObject1 = this.nxS;
            localObject2 = this.nxK;
            if (paramn != null)
            {
              ((a)localObject1).nwP.clear();
              ((a)localObject1).nwP.addAll(paramn);
              ((a)localObject1).nxK.putAll((Map)localObject2);
            }
          }
          this.nxS.notifyDataSetChanged();
          if (((CardInfo)paramString.get(0)).bHB()) {
            this.nrB = true;
          }
          this.nxR.setVisibility(0);
          if (this.nxS.getCount() <= 0) {
            break label863;
          }
          paramString = this.nxS.yZ(0);
          com.tencent.mm.plugin.card.d.n.a(this, paramString);
          this.nxQ.setBackgroundColor(l.Rm(paramString.bHV().gHT));
          this.nxT.setVisibility(0);
          paramn = new StateListDrawable();
          paramInt1 = getResources().getDimensionPixelOffset(2131165984);
          if (this.ntH != 1) {
            break label701;
          }
          this.nwq.setEnabled(true);
          localObject1 = l.eN(l.Rm(paramString.bHV().gHT), paramInt1);
          localObject2 = l.eN(l.cB(paramString.bHV().gHT, 175), paramInt1);
          paramn.addState(new int[] { 16842919 }, (Drawable)localObject2);
          paramn.addState(new int[0], (Drawable)localObject1);
        }
        for (;;)
        {
          this.nwq.setBackgroundDrawable(paramn);
          if (!TextUtils.isEmpty(this.ntI)) {
            this.nwq.setText(this.ntI);
          }
          if (this.ntJ != 1) {
            break label758;
          }
          paramInt1 = getResources().getDimensionPixelOffset(2131165516);
          paramn = l.d(this, getResources().getColor(2131101179), paramInt1);
          localObject1 = l.eN(getResources().getColor(2131101179), paramInt1);
          localObject2 = new StateListDrawable();
          ((StateListDrawable)localObject2).addState(new int[] { 16842919 }, (Drawable)localObject1);
          ((StateListDrawable)localObject2).addState(new int[0], paramn);
          this.nxW.setBackgroundDrawable((Drawable)localObject2);
          paramInt1 = l.Rm(paramString.bHV().gHT);
          paramInt2 = getResources().getColor(2131101179);
          paramString = new ColorStateList(new int[][] { { 16842919, 16842910 }, new int[0] }, new int[] { paramInt1, paramInt2 });
          this.nxW.setTextColor(paramString);
          this.nxU.setVisibility(0);
          if (TextUtils.isEmpty(this.ntK)) {
            break label741;
          }
          this.nxV.setText(this.ntK);
          AppMethodBeat.o(113160);
          return;
          ad.e("MicroMsg.CardAcceptCardListUI", "The card info list size is 0!");
          break;
          label701:
          this.nwq.setEnabled(false);
          localObject1 = l.eN(l.cB(paramString.bHV().gHT, 175), paramInt1);
          paramn.addState(new int[0], (Drawable)localObject1);
        }
        label741:
        this.nxV.setText(2131756980);
        AppMethodBeat.o(113160);
        return;
        label758:
        this.nxU.setVisibility(8);
        paramString = (RelativeLayout.LayoutParams)this.nxR.getLayoutParams();
        paramString.topMargin = getResources().getDimensionPixelSize(2131165568);
        paramString.bottomMargin = getResources().getDimensionPixelSize(2131165484);
        this.nxR.setLayoutParams(paramString);
        this.nxR.invalidate();
        paramString = (RelativeLayout.LayoutParams)this.nxT.getLayoutParams();
        paramString.addRule(8, 2131301449);
        this.nxT.setLayoutParams(paramString);
        this.nxT.invalidate();
        AppMethodBeat.o(113160);
        return;
        label863:
        this.nxT.setVisibility(8);
        this.nxU.setVisibility(8);
        this.nxQ.setBackgroundColor(getResources().getColor(2131100084));
        AppMethodBeat.o(113160);
        return;
      }
      if ((paramn instanceof com.tencent.mm.plugin.card.model.p))
      {
        iF(false);
        localObject1 = (com.tencent.mm.plugin.card.model.p)paramn;
        if (((com.tencent.mm.plugin.card.model.p)localObject1).ntx != 0)
        {
          paramn = ((com.tencent.mm.plugin.card.model.p)localObject1).nty;
          paramString = paramn;
          if (TextUtils.isEmpty(paramn)) {
            paramString = getString(2131756803);
          }
          com.tencent.mm.ui.base.h.a(this, paramString, null, false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(113153);
              paramAnonymousDialogInterface.dismiss();
              CardAcceptCardListUI.a(CardAcceptCardListUI.this, 2);
              AppMethodBeat.o(113153);
            }
          });
          this.ntG = ((com.tencent.mm.plugin.card.model.p)localObject1).ntw;
          AppMethodBeat.o(113160);
          return;
        }
        com.tencent.mm.ui.base.h.cf(this, getResources().getString(2131756872));
        paramString = new Intent();
        paramString.putExtra("card_list", ((com.tencent.mm.plugin.card.model.p)localObject1).ntw);
        setResult(-1, paramString);
        ad.i("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI setResult RESULT_OK for card");
        l.bMK();
        finish();
        AppMethodBeat.o(113160);
        return;
      }
      if ((paramn instanceof com.tencent.mm.plugin.card.sharecard.model.g))
      {
        iF(false);
        paramString = ((com.tencent.mm.plugin.card.sharecard.model.g)paramn).ntw;
        paramInt1 = ((com.tencent.mm.plugin.card.sharecard.model.g)paramn).ntx;
        paramn = ((com.tencent.mm.plugin.card.sharecard.model.g)paramn).nty;
        this.ntG = paramString;
        if (paramInt1 != 0)
        {
          paramString = paramn;
          if (TextUtils.isEmpty(paramn)) {
            paramString = getString(2131756991);
          }
          com.tencent.mm.ui.base.h.a(this, paramString, null, false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(113154);
              paramAnonymousDialogInterface.dismiss();
              CardAcceptCardListUI.a(CardAcceptCardListUI.this, 2);
              AppMethodBeat.o(113154);
            }
          });
          AppMethodBeat.o(113160);
          return;
        }
        com.tencent.mm.ui.base.h.cf(this, getResources().getString(2131756794));
        paramn = new Intent();
        paramn.putExtra("card_list", this.ntG);
        setResult(-1, paramn);
        ad.i("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI setResult RESULT_OK for sharecard");
        l.bMM();
        paramn = new ShareCardInfo();
        f.a(paramn, paramString);
        l.a(paramn);
        am.bJc().onChange();
        finish();
        AppMethodBeat.o(113160);
      }
    }
    else
    {
      ad.e("MicroMsg.CardAcceptCardListUI", "CardAddEntranceUI onSceneEnd() netsene type" + paramn.getType() + "errType = " + paramInt1 + " errCode = " + paramInt2);
      iF(false);
      d.b(this, paramString, paramInt2);
      if ((paramn instanceof com.tencent.mm.plugin.card.model.p))
      {
        this.ntG = paramString;
        AppMethodBeat.o(113160);
        return;
      }
      if ((paramn instanceof com.tencent.mm.plugin.card.sharecard.model.g)) {
        this.ntG = "";
      }
    }
    AppMethodBeat.o(113160);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardAcceptCardListUI
 * JD-Core Version:    0.7.0.1
 */