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
import com.tencent.mm.plugin.card.d.d;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.ab;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.protocal.protobuf.tf;
import com.tencent.mm.protocal.protobuf.ts;
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
  implements com.tencent.mm.al.f, MMActivity.a
{
  private View GJ;
  int dHZ;
  private com.tencent.mm.ui.base.p fQJ;
  private String hAT;
  private String oAa;
  private int oAb;
  private String oAc;
  private int oAd;
  private String oAe;
  private Button oCK;
  public int oCR;
  private String oCS;
  private String oCT;
  public ArrayList<String> oCU;
  public ArrayList<String> oCV;
  HashMap<String, Integer> oEe;
  private View oEk;
  private View oEl;
  protected a oEm;
  private View oEn;
  private View oEo;
  private TextView oEp;
  private Button oEq;
  LinkedList<tf> oEr;
  int oEs;
  String oEt;
  String oEu;
  private String oEv;
  LinkedList<tf> oEw;
  LinkedList<String> oEx;
  protected ListView owf;
  protected RelativeLayout owh;
  private boolean oxW;
  
  public CardAcceptCardListUI()
  {
    AppMethodBeat.i(113155);
    this.owf = null;
    this.oEm = null;
    this.owh = null;
    this.fQJ = null;
    this.oEr = new LinkedList();
    this.oAa = "";
    this.dHZ = 8;
    this.oEs = 7;
    this.oEt = "";
    this.oEu = "";
    this.oEv = "";
    this.oxW = false;
    this.oCR = 0;
    this.oCS = "";
    this.oCT = "";
    this.oCU = new ArrayList();
    this.oCV = new ArrayList();
    this.oEw = new LinkedList();
    this.oEx = new LinkedList();
    this.oEe = new HashMap();
    this.hAT = "";
    AppMethodBeat.o(113155);
  }
  
  private void Az(int paramInt)
  {
    AppMethodBeat.i(113162);
    ad.i("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI finishUI() result_code:".concat(String.valueOf(paramInt)));
    Intent localIntent = new Intent();
    localIntent.putExtra("card_list", this.oAa);
    localIntent.putExtra("result_code", paramInt);
    setResult(0, localIntent);
    finish();
    AppMethodBeat.o(113162);
  }
  
  private String bVA()
  {
    AppMethodBeat.i(113164);
    String str;
    if ((!TextUtils.isEmpty(this.oCS)) && (!TextUtils.isEmpty(this.oCT)))
    {
      str = this.oCS + "," + l.Zk(this.oCT);
      AppMethodBeat.o(113164);
      return str;
    }
    if (!TextUtils.isEmpty(this.oCS))
    {
      str = this.oCS;
      AppMethodBeat.o(113164);
      return str;
    }
    if (!TextUtils.isEmpty(this.oCT))
    {
      str = l.Zk(this.oCT);
      AppMethodBeat.o(113164);
      return str;
    }
    AppMethodBeat.o(113164);
    return "";
  }
  
  private void bVU()
  {
    AppMethodBeat.i(113165);
    if (!TextUtils.isEmpty(this.oAe))
    {
      this.oEp.setText(this.oAe);
      AppMethodBeat.o(113165);
      return;
    }
    this.oEp.setText(2131756980);
    AppMethodBeat.o(113165);
  }
  
  private ArrayList<CardInfo> cB(List<CardInfo> paramList)
  {
    AppMethodBeat.i(113166);
    if ((paramList == null) || (paramList.size() == 0))
    {
      ad.e("MicroMsg.CardAcceptCardListUI", "geCardInfoListByTpId list is empty!");
      AppMethodBeat.o(113166);
      return null;
    }
    this.oEw.clear();
    this.oEx.clear();
    this.oEe.clear();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < paramList.size())
    {
      CardInfo localCardInfo = (CardInfo)paramList.get(i);
      if (this.oEx.contains(localCardInfo.field_card_tp_id))
      {
        int j = ((Integer)this.oEe.get(localCardInfo.field_card_tp_id)).intValue();
        this.oEe.put(localCardInfo.field_card_tp_id, Integer.valueOf(j + 1));
      }
      for (;;)
      {
        i += 1;
        break;
        localArrayList.add(localCardInfo);
        this.oEe.put(localCardInfo.field_card_tp_id, Integer.valueOf(1));
        this.oEx.add(localCardInfo.field_card_tp_id);
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
      this.oCR = paramIntent.getIntExtra("Ktag_range_index", 0);
      ad.i("MicroMsg.CardAcceptCardListUI", "mPrivateSelelct : %d", new Object[] { Integer.valueOf(this.oCR) });
      if (this.oCR >= 2)
      {
        this.oCS = paramIntent.getStringExtra("Klabel_name_list");
        this.oCT = paramIntent.getStringExtra("Kother_user_name_list");
        ad.d("MicroMsg.CardAcceptCardListUI", "mPrivateSelect : %d, names : %s", new Object[] { Integer.valueOf(this.oCR), this.oCS });
        if ((TextUtils.isEmpty(this.oCS)) && (TextUtils.isEmpty(this.oCT)))
        {
          ad.e("MicroMsg.CardAcceptCardListUI", "mLabelNameList by getIntent is empty");
          bVU();
          AppMethodBeat.o(113163);
          return;
        }
        paramIntent = Arrays.asList(this.oCS.split(","));
        this.oCV = l.cH(paramIntent);
        this.oCU = l.cG(paramIntent);
        if ((this.oCT != null) && (this.oCT.length() > 0))
        {
          paramIntent = Arrays.asList(this.oCT.split(","));
          this.oCU.addAll(paramIntent);
        }
        if (this.oCV != null) {
          ad.i("MicroMsg.CardAcceptCardListUI", "mPrivateIdsList size is " + this.oCV.size());
        }
        if (this.oCU != null)
        {
          ad.i("MicroMsg.CardAcceptCardListUI", "mPrivateNamesList size is " + this.oCU.size());
          paramIntent = this.oCU.iterator();
          while (paramIntent.hasNext()) {
            ad.d("MicroMsg.CardAcceptCardListUI", "username : %s", new Object[] { (String)paramIntent.next() });
          }
        }
        if (!TextUtils.isEmpty(this.oCS))
        {
          if (this.oCR == 2)
          {
            this.oEp.setText(getString(2131756982, new Object[] { bVA() }));
            AppMethodBeat.o(113163);
            return;
          }
          if (this.oCR == 3)
          {
            this.oEp.setText(getString(2131756981, new Object[] { bVA() }));
            AppMethodBeat.o(113163);
          }
        }
        else
        {
          bVU();
        }
        AppMethodBeat.o(113163);
        return;
      }
      bVU();
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
    this.oEk = findViewById(2131297715);
    this.oEl = findViewById(2131306011);
    this.GJ = findViewById(2131301449);
    this.oEl.setVisibility(4);
    this.owf = ((ListView)findViewById(16908298));
    this.owh = ((RelativeLayout)findViewById(2131298768));
    this.owf.setEmptyView(this.owh);
    this.oEm = new a(this);
    this.owf.setAdapter(this.oEm);
    this.owf.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(215395);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mr(paramAnonymousInt);
        localb.qY(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/CardAcceptCardListUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardAcceptCardListUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(215395);
      }
    });
    this.oEn = findViewById(2131297719);
    this.oCK = ((Button)findViewById(2131297710));
    this.oCK.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(113151);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/CardAcceptCardListUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
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
          paramAnonymousView.jt(true);
          paramAnonymousView = new com.tencent.mm.plugin.card.model.p((LinkedList)localObject, paramAnonymousView.dHZ, paramAnonymousView.oEt, paramAnonymousView.oEu, paramAnonymousView.oEs);
          com.tencent.mm.kernel.g.ajB().gAO.a(paramAnonymousView, 0);
        }
      }
    });
    this.oCK.setEnabled(false);
    this.oEo = findViewById(2131297879);
    this.oEp = ((TextView)findViewById(2131297880));
    this.oEq = ((Button)findViewById(2131297878));
    this.oEq.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(113152);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/CardAcceptCardListUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        CardAcceptCardListUI.c(CardAcceptCardListUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardAcceptCardListUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(113152);
      }
    });
    Object localObject2 = getIntent();
    if (localObject2 == null)
    {
      ad.e("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI initView () intent == null");
      Az(2);
      AppMethodBeat.o(113156);
      return;
    }
    ad.i("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI handle data");
    Object localObject3 = ((Intent)localObject2).getStringExtra("key_in_card_list");
    this.dHZ = ((Intent)localObject2).getIntExtra("key_from_scene", 8);
    Object localObject1 = ((Intent)localObject2).getStringExtra("key_package_name");
    localObject2 = ((Intent)localObject2).getStringExtra("key_sign");
    this.oEs = getIntent().getIntExtra("key_stastic_scene", 7);
    this.oEt = getIntent().getStringExtra("src_username");
    this.oEu = getIntent().getStringExtra("js_url");
    this.oEv = getIntent().getStringExtra("key_consumed_card_id");
    this.hAT = getIntent().getStringExtra("key_template_id");
    localObject3 = com.tencent.mm.plugin.card.d.h.cH((String)localObject3, this.dHZ);
    if ((localObject3 == null) || (((List)localObject3).size() == 0))
    {
      ad.e("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI initView () tempList == null || tempList.size() == 0");
      Az(2);
      AppMethodBeat.o(113156);
      return;
    }
    this.oEr.clear();
    this.oEr.addAll((Collection)localObject3);
    this.oEw.clear();
    this.oEx.clear();
    this.oEe.clear();
    localObject3 = this.oEr;
    jt(true);
    localObject1 = new ab((LinkedList)localObject3, this.dHZ, (String)localObject1, (String)localObject2, this.oEt, this.oEu, this.oEv, this.oEs);
    com.tencent.mm.kernel.g.ajB().gAO.a((com.tencent.mm.al.n)localObject1, 0);
    AppMethodBeat.o(113156);
  }
  
  final void jt(boolean paramBoolean)
  {
    AppMethodBeat.i(113159);
    if (paramBoolean)
    {
      this.fQJ = com.tencent.mm.ui.base.p.a(this, getString(2131760709), false, 0, null);
      AppMethodBeat.o(113159);
      return;
    }
    if ((this.fQJ != null) && (this.fQJ.isShowing()))
    {
      this.fQJ.dismiss();
      this.fQJ = null;
    }
    AppMethodBeat.o(113159);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(113157);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.ajB().gAO.a(1079, this);
    com.tencent.mm.kernel.g.ajB().gAO.a(1049, this);
    com.tencent.mm.kernel.g.ajB().gAO.a(902, this);
    initView();
    AppMethodBeat.o(113157);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113158);
    com.tencent.mm.kernel.g.ajB().gAO.b(1079, this);
    com.tencent.mm.kernel.g.ajB().gAO.b(1049, this);
    com.tencent.mm.kernel.g.ajB().gAO.b(902, this);
    this.oEr.clear();
    a locala = this.oEm;
    locala.oDj.clear();
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
      Az(1);
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
        jt(false);
        paramString = (ab)paramn;
        paramn = paramString.ozQ;
        this.oAb = paramString.oAb;
        this.oAc = paramString.oAc;
        this.oAd = paramString.oAd;
        this.oAe = paramString.oAe;
        ad.i("MicroMsg.CardAcceptCardListUI", "accept_button_status: " + this.oAb + "  accept_button_wording: " + this.oAc);
        ad.i("MicroMsg.CardAcceptCardListUI", "private_status: " + this.oAd + "  private_wording: " + this.oAe);
        paramString = com.tencent.mm.plugin.card.d.f.Za(paramn);
        paramn = cB(paramString);
        Object localObject2;
        if ((paramString != null) && (paramString.size() > 0))
        {
          ad.i("MicroMsg.CardAcceptCardListUI", "The card info list size is " + paramString.size());
          if ((paramn != null) && (paramn.size() > 0))
          {
            localObject1 = this.oEm;
            localObject2 = this.oEe;
            if (paramn != null)
            {
              ((a)localObject1).oDj.clear();
              ((a)localObject1).oDj.addAll(paramn);
              ((a)localObject1).oEe.putAll((Map)localObject2);
            }
          }
          this.oEm.notifyDataSetChanged();
          if (((CardInfo)paramString.get(0)).bTt()) {
            this.oxW = true;
          }
          this.oEl.setVisibility(0);
          if (this.oEm.getCount() <= 0) {
            break label861;
          }
          paramString = this.oEm.Ay(0);
          com.tencent.mm.plugin.card.d.n.a(this, paramString);
          this.oEk.setBackgroundColor(l.Zh(paramString.bTN().hAD));
          this.oEn.setVisibility(0);
          paramn = new StateListDrawable();
          paramInt1 = getResources().getDimensionPixelOffset(2131165984);
          if (this.oAb != 1) {
            break label699;
          }
          this.oCK.setEnabled(true);
          localObject1 = l.eU(l.Zh(paramString.bTN().hAD), paramInt1);
          localObject2 = l.eU(l.cJ(paramString.bTN().hAD, 175), paramInt1);
          paramn.addState(new int[] { 16842919 }, (Drawable)localObject2);
          paramn.addState(new int[0], (Drawable)localObject1);
        }
        for (;;)
        {
          this.oCK.setBackgroundDrawable(paramn);
          if (!TextUtils.isEmpty(this.oAc)) {
            this.oCK.setText(this.oAc);
          }
          if (this.oAd != 1) {
            break label756;
          }
          paramInt1 = getResources().getDimensionPixelOffset(2131165516);
          paramn = l.f(this, getResources().getColor(2131101179), paramInt1);
          localObject1 = l.eU(getResources().getColor(2131101179), paramInt1);
          localObject2 = new StateListDrawable();
          ((StateListDrawable)localObject2).addState(new int[] { 16842919 }, (Drawable)localObject1);
          ((StateListDrawable)localObject2).addState(new int[0], paramn);
          this.oEq.setBackgroundDrawable((Drawable)localObject2);
          paramInt1 = l.Zh(paramString.bTN().hAD);
          paramInt2 = getResources().getColor(2131101179);
          paramString = new int[0];
          paramString = new ColorStateList(new int[][] { { 16842919, 16842910 }, paramString }, new int[] { paramInt1, paramInt2 });
          this.oEq.setTextColor(paramString);
          this.oEo.setVisibility(0);
          if (TextUtils.isEmpty(this.oAe)) {
            break label739;
          }
          this.oEp.setText(this.oAe);
          AppMethodBeat.o(113160);
          return;
          ad.e("MicroMsg.CardAcceptCardListUI", "The card info list size is 0!");
          break;
          label699:
          this.oCK.setEnabled(false);
          localObject1 = l.eU(l.cJ(paramString.bTN().hAD, 175), paramInt1);
          paramn.addState(new int[0], (Drawable)localObject1);
        }
        label739:
        this.oEp.setText(2131756980);
        AppMethodBeat.o(113160);
        return;
        label756:
        this.oEo.setVisibility(8);
        paramString = (RelativeLayout.LayoutParams)this.oEl.getLayoutParams();
        paramString.topMargin = getResources().getDimensionPixelSize(2131165568);
        paramString.bottomMargin = getResources().getDimensionPixelSize(2131165484);
        this.oEl.setLayoutParams(paramString);
        this.oEl.invalidate();
        paramString = (RelativeLayout.LayoutParams)this.oEn.getLayoutParams();
        paramString.addRule(8, 2131301449);
        this.oEn.setLayoutParams(paramString);
        this.oEn.invalidate();
        AppMethodBeat.o(113160);
        return;
        label861:
        this.oEn.setVisibility(8);
        this.oEo.setVisibility(8);
        this.oEk.setBackgroundColor(getResources().getColor(2131100084));
        AppMethodBeat.o(113160);
        return;
      }
      if ((paramn instanceof com.tencent.mm.plugin.card.model.p))
      {
        jt(false);
        localObject1 = (com.tencent.mm.plugin.card.model.p)paramn;
        if (((com.tencent.mm.plugin.card.model.p)localObject1).ozR != 0)
        {
          paramn = ((com.tencent.mm.plugin.card.model.p)localObject1).ozS;
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
          this.oAa = ((com.tencent.mm.plugin.card.model.p)localObject1).ozQ;
          AppMethodBeat.o(113160);
          return;
        }
        com.tencent.mm.ui.base.h.cl(this, getResources().getString(2131756872));
        paramString = new Intent();
        paramString.putExtra("card_list", ((com.tencent.mm.plugin.card.model.p)localObject1).ozQ);
        setResult(-1, paramString);
        ad.i("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI setResult RESULT_OK for card");
        l.bYA();
        finish();
        AppMethodBeat.o(113160);
        return;
      }
      if ((paramn instanceof com.tencent.mm.plugin.card.sharecard.model.g))
      {
        jt(false);
        paramString = ((com.tencent.mm.plugin.card.sharecard.model.g)paramn).ozQ;
        paramInt1 = ((com.tencent.mm.plugin.card.sharecard.model.g)paramn).ozR;
        paramn = ((com.tencent.mm.plugin.card.sharecard.model.g)paramn).ozS;
        this.oAa = paramString;
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
        com.tencent.mm.ui.base.h.cl(this, getResources().getString(2131756794));
        paramn = new Intent();
        paramn.putExtra("card_list", this.oAa);
        setResult(-1, paramn);
        ad.i("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI setResult RESULT_OK for sharecard");
        l.bYC();
        paramn = new ShareCardInfo();
        com.tencent.mm.plugin.card.d.f.a(paramn, paramString);
        l.a(paramn);
        am.bUU().onChange();
        finish();
        AppMethodBeat.o(113160);
      }
    }
    else
    {
      ad.e("MicroMsg.CardAcceptCardListUI", "CardAddEntranceUI onSceneEnd() netsene type" + paramn.getType() + "errType = " + paramInt1 + " errCode = " + paramInt2);
      jt(false);
      d.b(this, paramString, paramInt2);
      if ((paramn instanceof com.tencent.mm.plugin.card.model.p))
      {
        this.oAa = paramString;
        AppMethodBeat.o(113160);
        return;
      }
      if ((paramn instanceof com.tencent.mm.plugin.card.sharecard.model.g)) {
        this.oAa = "";
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardAcceptCardListUI
 * JD-Core Version:    0.7.0.1
 */