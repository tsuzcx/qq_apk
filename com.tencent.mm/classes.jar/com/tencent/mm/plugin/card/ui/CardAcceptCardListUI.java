package com.tencent.mm.plugin.card.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.card.d.d;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.ab;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.protocal.protobuf.th;
import com.tencent.mm.protocal.protobuf.tu;
import com.tencent.mm.sdk.platformtools.ae;
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
  implements com.tencent.mm.ak.f, MMActivity.a
{
  private View GJ;
  int dJd;
  private com.tencent.mm.ui.base.p fSP;
  private String hDH;
  protected ListView oCH;
  protected RelativeLayout oCJ;
  private boolean oEy;
  private String oGC;
  private int oGD;
  private String oGE;
  private int oGF;
  private String oGG;
  private Button oJm;
  public int oJt;
  private String oJu;
  private String oJv;
  public ArrayList<String> oJw;
  public ArrayList<String> oJx;
  HashMap<String, Integer> oKG;
  private View oKM;
  private View oKN;
  protected a oKO;
  private View oKP;
  private View oKQ;
  private TextView oKR;
  private Button oKS;
  LinkedList<th> oKT;
  int oKU;
  String oKV;
  String oKW;
  private String oKX;
  LinkedList<th> oKY;
  LinkedList<String> oKZ;
  
  public CardAcceptCardListUI()
  {
    AppMethodBeat.i(113155);
    this.oCH = null;
    this.oKO = null;
    this.oCJ = null;
    this.fSP = null;
    this.oKT = new LinkedList();
    this.oGC = "";
    this.dJd = 8;
    this.oKU = 7;
    this.oKV = "";
    this.oKW = "";
    this.oKX = "";
    this.oEy = false;
    this.oJt = 0;
    this.oJu = "";
    this.oJv = "";
    this.oJw = new ArrayList();
    this.oJx = new ArrayList();
    this.oKY = new LinkedList();
    this.oKZ = new LinkedList();
    this.oKG = new HashMap();
    this.hDH = "";
    AppMethodBeat.o(113155);
  }
  
  private void AL(int paramInt)
  {
    AppMethodBeat.i(113162);
    ae.i("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI finishUI() result_code:".concat(String.valueOf(paramInt)));
    Intent localIntent = new Intent();
    localIntent.putExtra("card_list", this.oGC);
    localIntent.putExtra("result_code", paramInt);
    setResult(0, localIntent);
    finish();
    AppMethodBeat.o(113162);
  }
  
  private String bWP()
  {
    AppMethodBeat.i(113164);
    String str;
    if ((!TextUtils.isEmpty(this.oJu)) && (!TextUtils.isEmpty(this.oJv)))
    {
      str = this.oJu + "," + l.aab(this.oJv);
      AppMethodBeat.o(113164);
      return str;
    }
    if (!TextUtils.isEmpty(this.oJu))
    {
      str = this.oJu;
      AppMethodBeat.o(113164);
      return str;
    }
    if (!TextUtils.isEmpty(this.oJv))
    {
      str = l.aab(this.oJv);
      AppMethodBeat.o(113164);
      return str;
    }
    AppMethodBeat.o(113164);
    return "";
  }
  
  private void bXj()
  {
    AppMethodBeat.i(113165);
    if (!TextUtils.isEmpty(this.oGG))
    {
      this.oKR.setText(this.oGG);
      AppMethodBeat.o(113165);
      return;
    }
    this.oKR.setText(2131756980);
    AppMethodBeat.o(113165);
  }
  
  private ArrayList<CardInfo> cE(List<CardInfo> paramList)
  {
    AppMethodBeat.i(113166);
    if ((paramList == null) || (paramList.size() == 0))
    {
      ae.e("MicroMsg.CardAcceptCardListUI", "geCardInfoListByTpId list is empty!");
      AppMethodBeat.o(113166);
      return null;
    }
    this.oKY.clear();
    this.oKZ.clear();
    this.oKG.clear();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < paramList.size())
    {
      CardInfo localCardInfo = (CardInfo)paramList.get(i);
      if (this.oKZ.contains(localCardInfo.field_card_tp_id))
      {
        int j = ((Integer)this.oKG.get(localCardInfo.field_card_tp_id)).intValue();
        this.oKG.put(localCardInfo.field_card_tp_id, Integer.valueOf(j + 1));
      }
      for (;;)
      {
        i += 1;
        break;
        localArrayList.add(localCardInfo);
        this.oKG.put(localCardInfo.field_card_tp_id, Integer.valueOf(1));
        this.oKZ.add(localCardInfo.field_card_tp_id);
      }
    }
    AppMethodBeat.o(113166);
    return localArrayList;
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
      this.oJt = paramIntent.getIntExtra("Ktag_range_index", 0);
      ae.i("MicroMsg.CardAcceptCardListUI", "mPrivateSelelct : %d", new Object[] { Integer.valueOf(this.oJt) });
      if (this.oJt >= 2)
      {
        this.oJu = paramIntent.getStringExtra("Klabel_name_list");
        this.oJv = paramIntent.getStringExtra("Kother_user_name_list");
        ae.d("MicroMsg.CardAcceptCardListUI", "mPrivateSelect : %d, names : %s", new Object[] { Integer.valueOf(this.oJt), this.oJu });
        if ((TextUtils.isEmpty(this.oJu)) && (TextUtils.isEmpty(this.oJv)))
        {
          ae.e("MicroMsg.CardAcceptCardListUI", "mLabelNameList by getIntent is empty");
          bXj();
          AppMethodBeat.o(113163);
          return;
        }
        paramIntent = Arrays.asList(this.oJu.split(","));
        this.oJx = l.cK(paramIntent);
        this.oJw = l.cJ(paramIntent);
        if ((this.oJv != null) && (this.oJv.length() > 0))
        {
          paramIntent = Arrays.asList(this.oJv.split(","));
          this.oJw.addAll(paramIntent);
        }
        if (this.oJx != null) {
          ae.i("MicroMsg.CardAcceptCardListUI", "mPrivateIdsList size is " + this.oJx.size());
        }
        if (this.oJw != null)
        {
          ae.i("MicroMsg.CardAcceptCardListUI", "mPrivateNamesList size is " + this.oJw.size());
          paramIntent = this.oJw.iterator();
          while (paramIntent.hasNext()) {
            ae.d("MicroMsg.CardAcceptCardListUI", "username : %s", new Object[] { (String)paramIntent.next() });
          }
        }
        if (!TextUtils.isEmpty(this.oJu))
        {
          if (this.oJt == 2)
          {
            this.oKR.setText(getString(2131756982, new Object[] { bWP() }));
            AppMethodBeat.o(113163);
            return;
          }
          if (this.oJt == 3)
          {
            this.oKR.setText(getString(2131756981, new Object[] { bWP() }));
            AppMethodBeat.o(113163);
          }
        }
        else
        {
          bXj();
        }
        AppMethodBeat.o(113163);
        return;
      }
      bXj();
    }
  }
  
  public int getLayoutId()
  {
    return 2131493248;
  }
  
  public void initView()
  {
    AppMethodBeat.i(113156);
    setMMTitle(2131756788);
    setBackBtn(new CardAcceptCardListUI.1(this));
    this.oKM = findViewById(2131297715);
    this.oKN = findViewById(2131306011);
    this.GJ = findViewById(2131301449);
    this.oKN.setVisibility(4);
    this.oCH = ((ListView)findViewById(16908298));
    this.oCJ = ((RelativeLayout)findViewById(2131298768));
    this.oCH.setEmptyView(this.oCJ);
    this.oKO = new a(this);
    this.oCH.setAdapter(this.oKO);
    this.oCH.setOnItemClickListener(new CardAcceptCardListUI.2(this));
    this.oKP = findViewById(2131297719);
    this.oJm = ((Button)findViewById(2131297710));
    this.oJm.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(113151);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/CardAcceptCardListUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        if (CardAcceptCardListUI.a(CardAcceptCardListUI.this)) {
          CardAcceptCardListUI.a(CardAcceptCardListUI.this, CardAcceptCardListUI.b(CardAcceptCardListUI.this));
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardAcceptCardListUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(113151);
          return;
          paramAnonymousView = CardAcceptCardListUI.this;
          localObject = CardAcceptCardListUI.b(CardAcceptCardListUI.this);
          paramAnonymousView.js(true);
          paramAnonymousView = new com.tencent.mm.plugin.card.model.p((LinkedList)localObject, paramAnonymousView.dJd, paramAnonymousView.oKV, paramAnonymousView.oKW, paramAnonymousView.oKU);
          com.tencent.mm.kernel.g.ajQ().gDv.a(paramAnonymousView, 0);
        }
      }
    });
    this.oJm.setEnabled(false);
    this.oKQ = findViewById(2131297879);
    this.oKR = ((TextView)findViewById(2131297880));
    this.oKS = ((Button)findViewById(2131297878));
    this.oKS.setOnClickListener(new CardAcceptCardListUI.4(this));
    Object localObject2 = getIntent();
    if (localObject2 == null)
    {
      ae.e("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI initView () intent == null");
      AL(2);
      AppMethodBeat.o(113156);
      return;
    }
    ae.i("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI handle data");
    Object localObject3 = ((Intent)localObject2).getStringExtra("key_in_card_list");
    this.dJd = ((Intent)localObject2).getIntExtra("key_from_scene", 8);
    Object localObject1 = ((Intent)localObject2).getStringExtra("key_package_name");
    localObject2 = ((Intent)localObject2).getStringExtra("key_sign");
    this.oKU = getIntent().getIntExtra("key_stastic_scene", 7);
    this.oKV = getIntent().getStringExtra("src_username");
    this.oKW = getIntent().getStringExtra("js_url");
    this.oKX = getIntent().getStringExtra("key_consumed_card_id");
    this.hDH = getIntent().getStringExtra("key_template_id");
    localObject3 = com.tencent.mm.plugin.card.d.h.cL((String)localObject3, this.dJd);
    if ((localObject3 == null) || (((List)localObject3).size() == 0))
    {
      ae.e("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI initView () tempList == null || tempList.size() == 0");
      AL(2);
      AppMethodBeat.o(113156);
      return;
    }
    this.oKT.clear();
    this.oKT.addAll((Collection)localObject3);
    this.oKY.clear();
    this.oKZ.clear();
    this.oKG.clear();
    localObject3 = this.oKT;
    js(true);
    localObject1 = new ab((LinkedList)localObject3, this.dJd, (String)localObject1, (String)localObject2, this.oKV, this.oKW, this.oKX, this.oKU);
    com.tencent.mm.kernel.g.ajQ().gDv.a((com.tencent.mm.ak.n)localObject1, 0);
    AppMethodBeat.o(113156);
  }
  
  final void js(boolean paramBoolean)
  {
    AppMethodBeat.i(113159);
    if (paramBoolean)
    {
      this.fSP = com.tencent.mm.ui.base.p.a(this, getString(2131760709), false, 0, null);
      AppMethodBeat.o(113159);
      return;
    }
    if ((this.fSP != null) && (this.fSP.isShowing()))
    {
      this.fSP.dismiss();
      this.fSP = null;
    }
    AppMethodBeat.o(113159);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(113157);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.ajQ().gDv.a(1079, this);
    com.tencent.mm.kernel.g.ajQ().gDv.a(1049, this);
    com.tencent.mm.kernel.g.ajQ().gDv.a(902, this);
    initView();
    AppMethodBeat.o(113157);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113158);
    com.tencent.mm.kernel.g.ajQ().gDv.b(1079, this);
    com.tencent.mm.kernel.g.ajQ().gDv.b(1049, this);
    com.tencent.mm.kernel.g.ajQ().gDv.b(902, this);
    this.oKT.clear();
    a locala = this.oKO;
    locala.oJL.clear();
    locala.mContext = null;
    super.onDestroy();
    AppMethodBeat.o(113158);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(113161);
    if (paramInt == 4)
    {
      ae.i("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI onKeyDown() back cancel");
      AL(1);
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(113161);
    return bool;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(113160);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      Object localObject1;
      if ((paramn instanceof ab))
      {
        js(false);
        paramString = (ab)paramn;
        paramn = paramString.oGs;
        this.oGD = paramString.oGD;
        this.oGE = paramString.oGE;
        this.oGF = paramString.oGF;
        this.oGG = paramString.oGG;
        ae.i("MicroMsg.CardAcceptCardListUI", "accept_button_status: " + this.oGD + "  accept_button_wording: " + this.oGE);
        ae.i("MicroMsg.CardAcceptCardListUI", "private_status: " + this.oGF + "  private_wording: " + this.oGG);
        paramString = com.tencent.mm.plugin.card.d.f.ZR(paramn);
        paramn = cE(paramString);
        Object localObject2;
        if ((paramString != null) && (paramString.size() > 0))
        {
          ae.i("MicroMsg.CardAcceptCardListUI", "The card info list size is " + paramString.size());
          if ((paramn != null) && (paramn.size() > 0))
          {
            localObject1 = this.oKO;
            localObject2 = this.oKG;
            if (paramn != null)
            {
              ((a)localObject1).oJL.clear();
              ((a)localObject1).oJL.addAll(paramn);
              ((a)localObject1).oKG.putAll((Map)localObject2);
            }
          }
          this.oKO.notifyDataSetChanged();
          if (((CardInfo)paramString.get(0)).bUI()) {
            this.oEy = true;
          }
          this.oKN.setVisibility(0);
          if (this.oKO.getCount() <= 0) {
            break label859;
          }
          paramString = this.oKO.AK(0);
          com.tencent.mm.plugin.card.d.n.a(this, paramString);
          this.oKM.setBackgroundColor(l.ZY(paramString.bVc().hDr));
          this.oKP.setVisibility(0);
          paramn = new StateListDrawable();
          paramInt1 = getResources().getDimensionPixelOffset(2131165984);
          if (this.oGD != 1) {
            break label697;
          }
          this.oJm.setEnabled(true);
          localObject1 = l.eV(l.ZY(paramString.bVc().hDr), paramInt1);
          localObject2 = l.eV(l.cN(paramString.bVc().hDr, 175), paramInt1);
          paramn.addState(new int[] { 16842919 }, (Drawable)localObject2);
          paramn.addState(new int[0], (Drawable)localObject1);
        }
        for (;;)
        {
          this.oJm.setBackgroundDrawable(paramn);
          if (!TextUtils.isEmpty(this.oGE)) {
            this.oJm.setText(this.oGE);
          }
          if (this.oGF != 1) {
            break label754;
          }
          paramInt1 = getResources().getDimensionPixelOffset(2131165516);
          paramn = l.f(this, getResources().getColor(2131101179), paramInt1);
          localObject1 = l.eV(getResources().getColor(2131101179), paramInt1);
          localObject2 = new StateListDrawable();
          ((StateListDrawable)localObject2).addState(new int[] { 16842919 }, (Drawable)localObject1);
          ((StateListDrawable)localObject2).addState(new int[0], paramn);
          this.oKS.setBackgroundDrawable((Drawable)localObject2);
          paramInt1 = l.ZY(paramString.bVc().hDr);
          paramInt2 = getResources().getColor(2131101179);
          paramString = new ColorStateList(new int[][] { { 16842919, 16842910 }, new int[0] }, new int[] { paramInt1, paramInt2 });
          this.oKS.setTextColor(paramString);
          this.oKQ.setVisibility(0);
          if (TextUtils.isEmpty(this.oGG)) {
            break label737;
          }
          this.oKR.setText(this.oGG);
          AppMethodBeat.o(113160);
          return;
          ae.e("MicroMsg.CardAcceptCardListUI", "The card info list size is 0!");
          break;
          label697:
          this.oJm.setEnabled(false);
          localObject1 = l.eV(l.cN(paramString.bVc().hDr, 175), paramInt1);
          paramn.addState(new int[0], (Drawable)localObject1);
        }
        label737:
        this.oKR.setText(2131756980);
        AppMethodBeat.o(113160);
        return;
        label754:
        this.oKQ.setVisibility(8);
        paramString = (RelativeLayout.LayoutParams)this.oKN.getLayoutParams();
        paramString.topMargin = getResources().getDimensionPixelSize(2131165568);
        paramString.bottomMargin = getResources().getDimensionPixelSize(2131165484);
        this.oKN.setLayoutParams(paramString);
        this.oKN.invalidate();
        paramString = (RelativeLayout.LayoutParams)this.oKP.getLayoutParams();
        paramString.addRule(8, 2131301449);
        this.oKP.setLayoutParams(paramString);
        this.oKP.invalidate();
        AppMethodBeat.o(113160);
        return;
        label859:
        this.oKP.setVisibility(8);
        this.oKQ.setVisibility(8);
        this.oKM.setBackgroundColor(getResources().getColor(2131100084));
        AppMethodBeat.o(113160);
        return;
      }
      if ((paramn instanceof com.tencent.mm.plugin.card.model.p))
      {
        js(false);
        localObject1 = (com.tencent.mm.plugin.card.model.p)paramn;
        if (((com.tencent.mm.plugin.card.model.p)localObject1).oGt != 0)
        {
          paramn = ((com.tencent.mm.plugin.card.model.p)localObject1).oGu;
          paramString = paramn;
          if (TextUtils.isEmpty(paramn)) {
            paramString = getString(2131756803);
          }
          com.tencent.mm.ui.base.h.a(this, paramString, null, false, new CardAcceptCardListUI.5(this));
          this.oGC = ((com.tencent.mm.plugin.card.model.p)localObject1).oGs;
          AppMethodBeat.o(113160);
          return;
        }
        com.tencent.mm.ui.base.h.cm(this, getResources().getString(2131756872));
        paramString = new Intent();
        paramString.putExtra("card_list", ((com.tencent.mm.plugin.card.model.p)localObject1).oGs);
        setResult(-1, paramString);
        ae.i("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI setResult RESULT_OK for card");
        l.bZP();
        finish();
        AppMethodBeat.o(113160);
        return;
      }
      if ((paramn instanceof com.tencent.mm.plugin.card.sharecard.model.g))
      {
        js(false);
        paramString = ((com.tencent.mm.plugin.card.sharecard.model.g)paramn).oGs;
        paramInt1 = ((com.tencent.mm.plugin.card.sharecard.model.g)paramn).oGt;
        paramn = ((com.tencent.mm.plugin.card.sharecard.model.g)paramn).oGu;
        this.oGC = paramString;
        if (paramInt1 != 0)
        {
          paramString = paramn;
          if (TextUtils.isEmpty(paramn)) {
            paramString = getString(2131756991);
          }
          com.tencent.mm.ui.base.h.a(this, paramString, null, false, new CardAcceptCardListUI.6(this));
          AppMethodBeat.o(113160);
          return;
        }
        com.tencent.mm.ui.base.h.cm(this, getResources().getString(2131756794));
        paramn = new Intent();
        paramn.putExtra("card_list", this.oGC);
        setResult(-1, paramn);
        ae.i("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI setResult RESULT_OK for sharecard");
        l.bZR();
        paramn = new ShareCardInfo();
        com.tencent.mm.plugin.card.d.f.a(paramn, paramString);
        l.a(paramn);
        am.bWj().onChange();
        finish();
        AppMethodBeat.o(113160);
      }
    }
    else
    {
      ae.e("MicroMsg.CardAcceptCardListUI", "CardAddEntranceUI onSceneEnd() netsene type" + paramn.getType() + "errType = " + paramInt1 + " errCode = " + paramInt2);
      js(false);
      d.b(this, paramString, paramInt2);
      if ((paramn instanceof com.tencent.mm.plugin.card.model.p))
      {
        this.oGC = paramString;
        AppMethodBeat.o(113160);
        return;
      }
      if ((paramn instanceof com.tencent.mm.plugin.card.sharecard.model.g)) {
        this.oGC = "";
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardAcceptCardListUI
 * JD-Core Version:    0.7.0.1
 */