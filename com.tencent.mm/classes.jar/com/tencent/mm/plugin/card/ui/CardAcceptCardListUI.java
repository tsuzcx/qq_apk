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
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.card.d.d;
import com.tencent.mm.plugin.card.d.f;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.ab;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.protocal.protobuf.rl;
import com.tencent.mm.protocal.protobuf.ry;
import com.tencent.mm.sdk.platformtools.ac;
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
  implements com.tencent.mm.ak.g, MMActivity.a
{
  private View ES;
  int dvQ;
  private com.tencent.mm.ui.base.p fxw;
  private String hiK;
  protected ListView nSK;
  protected RelativeLayout nSM;
  private boolean nUB;
  private String nWG;
  private int nWH;
  private String nWI;
  private int nWJ;
  private String nWK;
  public ArrayList<String> nZA;
  public ArrayList<String> nZB;
  private Button nZq;
  public int nZx;
  private String nZy;
  private String nZz;
  HashMap<String, Integer> oaK;
  private View oaQ;
  private View oaR;
  protected a oaS;
  private View oaT;
  private View oaU;
  private TextView oaV;
  private Button oaW;
  LinkedList<rl> oaX;
  int oaY;
  String oaZ;
  String oba;
  private String obb;
  LinkedList<rl> obc;
  LinkedList<String> obd;
  
  public CardAcceptCardListUI()
  {
    AppMethodBeat.i(113155);
    this.nSK = null;
    this.oaS = null;
    this.nSM = null;
    this.fxw = null;
    this.oaX = new LinkedList();
    this.nWG = "";
    this.dvQ = 8;
    this.oaY = 7;
    this.oaZ = "";
    this.oba = "";
    this.obb = "";
    this.nUB = false;
    this.nZx = 0;
    this.nZy = "";
    this.nZz = "";
    this.nZA = new ArrayList();
    this.nZB = new ArrayList();
    this.obc = new LinkedList();
    this.obd = new LinkedList();
    this.oaK = new HashMap();
    this.hiK = "";
    AppMethodBeat.o(113155);
  }
  
  private String bQV()
  {
    AppMethodBeat.i(113164);
    String str;
    if ((!TextUtils.isEmpty(this.nZy)) && (!TextUtils.isEmpty(this.nZz)))
    {
      str = this.nZy + "," + l.VB(this.nZz);
      AppMethodBeat.o(113164);
      return str;
    }
    if (!TextUtils.isEmpty(this.nZy))
    {
      str = this.nZy;
      AppMethodBeat.o(113164);
      return str;
    }
    if (!TextUtils.isEmpty(this.nZz))
    {
      str = l.VB(this.nZz);
      AppMethodBeat.o(113164);
      return str;
    }
    AppMethodBeat.o(113164);
    return "";
  }
  
  private void bRp()
  {
    AppMethodBeat.i(113165);
    if (!TextUtils.isEmpty(this.nWK))
    {
      this.oaV.setText(this.nWK);
      AppMethodBeat.o(113165);
      return;
    }
    this.oaV.setText(2131756980);
    AppMethodBeat.o(113165);
  }
  
  private ArrayList<CardInfo> cA(List<CardInfo> paramList)
  {
    AppMethodBeat.i(113166);
    if ((paramList == null) || (paramList.size() == 0))
    {
      ac.e("MicroMsg.CardAcceptCardListUI", "geCardInfoListByTpId list is empty!");
      AppMethodBeat.o(113166);
      return null;
    }
    this.obc.clear();
    this.obd.clear();
    this.oaK.clear();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < paramList.size())
    {
      CardInfo localCardInfo = (CardInfo)paramList.get(i);
      if (this.obd.contains(localCardInfo.field_card_tp_id))
      {
        int j = ((Integer)this.oaK.get(localCardInfo.field_card_tp_id)).intValue();
        this.oaK.put(localCardInfo.field_card_tp_id, Integer.valueOf(j + 1));
      }
      for (;;)
      {
        i += 1;
        break;
        localArrayList.add(localCardInfo);
        this.oaK.put(localCardInfo.field_card_tp_id, Integer.valueOf(1));
        this.obd.add(localCardInfo.field_card_tp_id);
      }
    }
    AppMethodBeat.o(113166);
    return localArrayList;
  }
  
  private void zQ(int paramInt)
  {
    AppMethodBeat.i(113162);
    ac.i("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI finishUI() result_code:".concat(String.valueOf(paramInt)));
    Intent localIntent = new Intent();
    localIntent.putExtra("card_list", this.nWG);
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
      this.nZx = paramIntent.getIntExtra("Ktag_range_index", 0);
      ac.i("MicroMsg.CardAcceptCardListUI", "mPrivateSelelct : %d", new Object[] { Integer.valueOf(this.nZx) });
      if (this.nZx >= 2)
      {
        this.nZy = paramIntent.getStringExtra("Klabel_name_list");
        this.nZz = paramIntent.getStringExtra("Kother_user_name_list");
        ac.d("MicroMsg.CardAcceptCardListUI", "mPrivateSelect : %d, names : %s", new Object[] { Integer.valueOf(this.nZx), this.nZy });
        if ((TextUtils.isEmpty(this.nZy)) && (TextUtils.isEmpty(this.nZz)))
        {
          ac.e("MicroMsg.CardAcceptCardListUI", "mLabelNameList by getIntent is empty");
          bRp();
          AppMethodBeat.o(113163);
          return;
        }
        paramIntent = Arrays.asList(this.nZy.split(","));
        this.nZB = l.cG(paramIntent);
        this.nZA = l.cF(paramIntent);
        if ((this.nZz != null) && (this.nZz.length() > 0))
        {
          paramIntent = Arrays.asList(this.nZz.split(","));
          this.nZA.addAll(paramIntent);
        }
        if (this.nZB != null) {
          ac.i("MicroMsg.CardAcceptCardListUI", "mPrivateIdsList size is " + this.nZB.size());
        }
        if (this.nZA != null)
        {
          ac.i("MicroMsg.CardAcceptCardListUI", "mPrivateNamesList size is " + this.nZA.size());
          paramIntent = this.nZA.iterator();
          while (paramIntent.hasNext()) {
            ac.d("MicroMsg.CardAcceptCardListUI", "username : %s", new Object[] { (String)paramIntent.next() });
          }
        }
        if (!TextUtils.isEmpty(this.nZy))
        {
          if (this.nZx == 2)
          {
            this.oaV.setText(getString(2131756982, new Object[] { bQV() }));
            AppMethodBeat.o(113163);
            return;
          }
          if (this.nZx == 3)
          {
            this.oaV.setText(getString(2131756981, new Object[] { bQV() }));
            AppMethodBeat.o(113163);
          }
        }
        else
        {
          bRp();
        }
        AppMethodBeat.o(113163);
        return;
      }
      bRp();
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
        ac.v("MicroMsg.CardAcceptCardListUI", "setBackBtn cancel");
        CardAcceptCardListUI.a(CardAcceptCardListUI.this, 1);
        AppMethodBeat.o(113150);
        return true;
      }
    });
    this.oaQ = findViewById(2131297715);
    this.oaR = findViewById(2131306011);
    this.ES = findViewById(2131301449);
    this.oaR.setVisibility(4);
    this.nSK = ((ListView)findViewById(16908298));
    this.nSM = ((RelativeLayout)findViewById(2131298768));
    this.nSK.setEmptyView(this.nSM);
    this.oaS = new a(this);
    this.nSK.setAdapter(this.oaS);
    this.nSK.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong) {}
    });
    this.oaT = findViewById(2131297719);
    this.nZq = ((Button)findViewById(2131297710));
    this.nZq.setOnClickListener(new View.OnClickListener()
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
        paramAnonymousView.ji(true);
        paramAnonymousView = new com.tencent.mm.plugin.card.model.p(localLinkedList, paramAnonymousView.dvQ, paramAnonymousView.oaZ, paramAnonymousView.oba, paramAnonymousView.oaY);
        com.tencent.mm.kernel.g.agQ().ghe.a(paramAnonymousView, 0);
        AppMethodBeat.o(113151);
      }
    });
    this.nZq.setEnabled(false);
    this.oaU = findViewById(2131297879);
    this.oaV = ((TextView)findViewById(2131297880));
    this.oaW = ((Button)findViewById(2131297878));
    this.oaW.setOnClickListener(new View.OnClickListener()
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
      ac.e("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI initView () intent == null");
      zQ(2);
      AppMethodBeat.o(113156);
      return;
    }
    ac.i("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI handle data");
    Object localObject3 = ((Intent)localObject2).getStringExtra("key_in_card_list");
    this.dvQ = ((Intent)localObject2).getIntExtra("key_from_scene", 8);
    Object localObject1 = ((Intent)localObject2).getStringExtra("key_package_name");
    localObject2 = ((Intent)localObject2).getStringExtra("key_sign");
    this.oaY = getIntent().getIntExtra("key_stastic_scene", 7);
    this.oaZ = getIntent().getStringExtra("src_username");
    this.oba = getIntent().getStringExtra("js_url");
    this.obb = getIntent().getStringExtra("key_consumed_card_id");
    this.hiK = getIntent().getStringExtra("key_template_id");
    localObject3 = com.tencent.mm.plugin.card.d.h.cE((String)localObject3, this.dvQ);
    if ((localObject3 == null) || (((List)localObject3).size() == 0))
    {
      ac.e("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI initView () tempList == null || tempList.size() == 0");
      zQ(2);
      AppMethodBeat.o(113156);
      return;
    }
    this.oaX.clear();
    this.oaX.addAll((Collection)localObject3);
    this.obc.clear();
    this.obd.clear();
    this.oaK.clear();
    localObject3 = this.oaX;
    ji(true);
    localObject1 = new ab((LinkedList)localObject3, this.dvQ, (String)localObject1, (String)localObject2, this.oaZ, this.oba, this.obb, this.oaY);
    com.tencent.mm.kernel.g.agQ().ghe.a((com.tencent.mm.ak.n)localObject1, 0);
    AppMethodBeat.o(113156);
  }
  
  final void ji(boolean paramBoolean)
  {
    AppMethodBeat.i(113159);
    if (paramBoolean)
    {
      this.fxw = com.tencent.mm.ui.base.p.a(this, getString(2131760709), false, 0, null);
      AppMethodBeat.o(113159);
      return;
    }
    if ((this.fxw != null) && (this.fxw.isShowing()))
    {
      this.fxw.dismiss();
      this.fxw = null;
    }
    AppMethodBeat.o(113159);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(113157);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.agQ().ghe.a(1079, this);
    com.tencent.mm.kernel.g.agQ().ghe.a(1049, this);
    com.tencent.mm.kernel.g.agQ().ghe.a(902, this);
    initView();
    AppMethodBeat.o(113157);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113158);
    com.tencent.mm.kernel.g.agQ().ghe.b(1079, this);
    com.tencent.mm.kernel.g.agQ().ghe.b(1049, this);
    com.tencent.mm.kernel.g.agQ().ghe.b(902, this);
    this.oaX.clear();
    a locala = this.oaS;
    locala.nZP.clear();
    locala.mContext = null;
    super.onDestroy();
    AppMethodBeat.o(113158);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(113161);
    if (paramInt == 4)
    {
      ac.i("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI onKeyDown() back cancel");
      zQ(1);
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
        ji(false);
        paramString = (ab)paramn;
        paramn = paramString.nWw;
        this.nWH = paramString.nWH;
        this.nWI = paramString.nWI;
        this.nWJ = paramString.nWJ;
        this.nWK = paramString.nWK;
        ac.i("MicroMsg.CardAcceptCardListUI", "accept_button_status: " + this.nWH + "  accept_button_wording: " + this.nWI);
        ac.i("MicroMsg.CardAcceptCardListUI", "private_status: " + this.nWJ + "  private_wording: " + this.nWK);
        paramString = f.Vr(paramn);
        paramn = cA(paramString);
        Object localObject2;
        if ((paramString != null) && (paramString.size() > 0))
        {
          ac.i("MicroMsg.CardAcceptCardListUI", "The card info list size is " + paramString.size());
          if ((paramn != null) && (paramn.size() > 0))
          {
            localObject1 = this.oaS;
            localObject2 = this.oaK;
            if (paramn != null)
            {
              ((a)localObject1).nZP.clear();
              ((a)localObject1).nZP.addAll(paramn);
              ((a)localObject1).oaK.putAll((Map)localObject2);
            }
          }
          this.oaS.notifyDataSetChanged();
          if (((CardInfo)paramString.get(0)).bOO()) {
            this.nUB = true;
          }
          this.oaR.setVisibility(0);
          if (this.oaS.getCount() <= 0) {
            break label865;
          }
          paramString = this.oaS.zP(0);
          com.tencent.mm.plugin.card.d.n.a(this, paramString);
          this.oaQ.setBackgroundColor(l.Vy(paramString.bPi().hiu));
          this.oaT.setVisibility(0);
          paramn = new StateListDrawable();
          paramInt1 = getResources().getDimensionPixelOffset(2131165984);
          if (this.nWH != 1) {
            break label703;
          }
          this.nZq.setEnabled(true);
          localObject1 = l.eQ(l.Vy(paramString.bPi().hiu), paramInt1);
          localObject2 = l.eQ(l.cG(paramString.bPi().hiu, 175), paramInt1);
          paramn.addState(new int[] { 16842919 }, (Drawable)localObject2);
          paramn.addState(new int[0], (Drawable)localObject1);
        }
        for (;;)
        {
          this.nZq.setBackgroundDrawable(paramn);
          if (!TextUtils.isEmpty(this.nWI)) {
            this.nZq.setText(this.nWI);
          }
          if (this.nWJ != 1) {
            break label760;
          }
          paramInt1 = getResources().getDimensionPixelOffset(2131165516);
          paramn = l.f(this, getResources().getColor(2131101179), paramInt1);
          localObject1 = l.eQ(getResources().getColor(2131101179), paramInt1);
          localObject2 = new StateListDrawable();
          ((StateListDrawable)localObject2).addState(new int[] { 16842919 }, (Drawable)localObject1);
          ((StateListDrawable)localObject2).addState(new int[0], paramn);
          this.oaW.setBackgroundDrawable((Drawable)localObject2);
          paramInt1 = l.Vy(paramString.bPi().hiu);
          paramInt2 = getResources().getColor(2131101179);
          paramString = new int[0];
          paramString = new ColorStateList(new int[][] { { 16842919, 16842910 }, paramString }, new int[] { paramInt1, paramInt2 });
          this.oaW.setTextColor(paramString);
          this.oaU.setVisibility(0);
          if (TextUtils.isEmpty(this.nWK)) {
            break label743;
          }
          this.oaV.setText(this.nWK);
          AppMethodBeat.o(113160);
          return;
          ac.e("MicroMsg.CardAcceptCardListUI", "The card info list size is 0!");
          break;
          label703:
          this.nZq.setEnabled(false);
          localObject1 = l.eQ(l.cG(paramString.bPi().hiu, 175), paramInt1);
          paramn.addState(new int[0], (Drawable)localObject1);
        }
        label743:
        this.oaV.setText(2131756980);
        AppMethodBeat.o(113160);
        return;
        label760:
        this.oaU.setVisibility(8);
        paramString = (RelativeLayout.LayoutParams)this.oaR.getLayoutParams();
        paramString.topMargin = getResources().getDimensionPixelSize(2131165568);
        paramString.bottomMargin = getResources().getDimensionPixelSize(2131165484);
        this.oaR.setLayoutParams(paramString);
        this.oaR.invalidate();
        paramString = (RelativeLayout.LayoutParams)this.oaT.getLayoutParams();
        paramString.addRule(8, 2131301449);
        this.oaT.setLayoutParams(paramString);
        this.oaT.invalidate();
        AppMethodBeat.o(113160);
        return;
        label865:
        this.oaT.setVisibility(8);
        this.oaU.setVisibility(8);
        this.oaQ.setBackgroundColor(getResources().getColor(2131100084));
        AppMethodBeat.o(113160);
        return;
      }
      if ((paramn instanceof com.tencent.mm.plugin.card.model.p))
      {
        ji(false);
        localObject1 = (com.tencent.mm.plugin.card.model.p)paramn;
        if (((com.tencent.mm.plugin.card.model.p)localObject1).nWx != 0)
        {
          paramn = ((com.tencent.mm.plugin.card.model.p)localObject1).nWy;
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
          this.nWG = ((com.tencent.mm.plugin.card.model.p)localObject1).nWw;
          AppMethodBeat.o(113160);
          return;
        }
        com.tencent.mm.ui.base.h.cg(this, getResources().getString(2131756872));
        paramString = new Intent();
        paramString.putExtra("card_list", ((com.tencent.mm.plugin.card.model.p)localObject1).nWw);
        setResult(-1, paramString);
        ac.i("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI setResult RESULT_OK for card");
        l.bTV();
        finish();
        AppMethodBeat.o(113160);
        return;
      }
      if ((paramn instanceof com.tencent.mm.plugin.card.sharecard.model.g))
      {
        ji(false);
        paramString = ((com.tencent.mm.plugin.card.sharecard.model.g)paramn).nWw;
        paramInt1 = ((com.tencent.mm.plugin.card.sharecard.model.g)paramn).nWx;
        paramn = ((com.tencent.mm.plugin.card.sharecard.model.g)paramn).nWy;
        this.nWG = paramString;
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
        com.tencent.mm.ui.base.h.cg(this, getResources().getString(2131756794));
        paramn = new Intent();
        paramn.putExtra("card_list", this.nWG);
        setResult(-1, paramn);
        ac.i("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI setResult RESULT_OK for sharecard");
        l.bTX();
        paramn = new ShareCardInfo();
        f.a(paramn, paramString);
        l.a(paramn);
        am.bQp().onChange();
        finish();
        AppMethodBeat.o(113160);
      }
    }
    else
    {
      ac.e("MicroMsg.CardAcceptCardListUI", "CardAddEntranceUI onSceneEnd() netsene type" + paramn.getType() + "errType = " + paramInt1 + " errCode = " + paramInt2);
      ji(false);
      d.b(this, paramString, paramInt2);
      if ((paramn instanceof com.tencent.mm.plugin.card.model.p))
      {
        this.nWG = paramString;
        AppMethodBeat.o(113160);
        return;
      }
      if ((paramn instanceof com.tencent.mm.plugin.card.sharecard.model.g)) {
        this.nWG = "";
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