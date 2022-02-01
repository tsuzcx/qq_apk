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
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.plugin.card.d.d;
import com.tencent.mm.plugin.card.d.f;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.n;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.ab;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.p;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.protocal.protobuf.um;
import com.tencent.mm.protocal.protobuf.uz;
import com.tencent.mm.sdk.platformtools.Log;
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
  implements i, MMActivity.a
{
  private View GT;
  int eaQ;
  private com.tencent.mm.ui.base.q gxX;
  private String ixM;
  protected ListView pQq;
  protected RelativeLayout pQs;
  private boolean pSh;
  private String pUi;
  private int pUj;
  private String pUk;
  private int pUl;
  private String pUm;
  private Button pXa;
  public int pXh;
  private String pXi;
  private String pXj;
  public ArrayList<String> pXk;
  public ArrayList<String> pXl;
  private View pYA;
  private View pYB;
  protected a pYC;
  private View pYD;
  private View pYE;
  private TextView pYF;
  private Button pYG;
  LinkedList<um> pYH;
  int pYI;
  String pYJ;
  String pYK;
  private String pYL;
  LinkedList<um> pYM;
  LinkedList<String> pYN;
  HashMap<String, Integer> pYu;
  
  public CardAcceptCardListUI()
  {
    AppMethodBeat.i(113155);
    this.pQq = null;
    this.pYC = null;
    this.pQs = null;
    this.gxX = null;
    this.pYH = new LinkedList();
    this.pUi = "";
    this.eaQ = 8;
    this.pYI = 7;
    this.pYJ = "";
    this.pYK = "";
    this.pYL = "";
    this.pSh = false;
    this.pXh = 0;
    this.pXi = "";
    this.pXj = "";
    this.pXk = new ArrayList();
    this.pXl = new ArrayList();
    this.pYM = new LinkedList();
    this.pYN = new LinkedList();
    this.pYu = new HashMap();
    this.ixM = "";
    AppMethodBeat.o(113155);
  }
  
  private void Eq(int paramInt)
  {
    AppMethodBeat.i(113162);
    Log.i("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI finishUI() result_code:".concat(String.valueOf(paramInt)));
    Intent localIntent = new Intent();
    localIntent.putExtra("card_list", this.pUi);
    localIntent.putExtra("result_code", paramInt);
    setResult(0, localIntent);
    finish();
    AppMethodBeat.o(113162);
  }
  
  private ArrayList<CardInfo> cS(List<CardInfo> paramList)
  {
    AppMethodBeat.i(113166);
    if ((paramList == null) || (paramList.size() == 0))
    {
      Log.e("MicroMsg.CardAcceptCardListUI", "geCardInfoListByTpId list is empty!");
      AppMethodBeat.o(113166);
      return null;
    }
    this.pYM.clear();
    this.pYN.clear();
    this.pYu.clear();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < paramList.size())
    {
      CardInfo localCardInfo = (CardInfo)paramList.get(i);
      if (this.pYN.contains(localCardInfo.field_card_tp_id))
      {
        int j = ((Integer)this.pYu.get(localCardInfo.field_card_tp_id)).intValue();
        this.pYu.put(localCardInfo.field_card_tp_id, Integer.valueOf(j + 1));
      }
      for (;;)
      {
        i += 1;
        break;
        localArrayList.add(localCardInfo);
        this.pYu.put(localCardInfo.field_card_tp_id, Integer.valueOf(1));
        this.pYN.add(localCardInfo.field_card_tp_id);
      }
    }
    AppMethodBeat.o(113166);
    return localArrayList;
  }
  
  private String cuG()
  {
    AppMethodBeat.i(113164);
    String str;
    if ((!TextUtils.isEmpty(this.pXi)) && (!TextUtils.isEmpty(this.pXj)))
    {
      str = this.pXi + "," + l.akh(this.pXj);
      AppMethodBeat.o(113164);
      return str;
    }
    if (!TextUtils.isEmpty(this.pXi))
    {
      str = this.pXi;
      AppMethodBeat.o(113164);
      return str;
    }
    if (!TextUtils.isEmpty(this.pXj))
    {
      str = l.akh(this.pXj);
      AppMethodBeat.o(113164);
      return str;
    }
    AppMethodBeat.o(113164);
    return "";
  }
  
  private void cuZ()
  {
    AppMethodBeat.i(113165);
    if (!TextUtils.isEmpty(this.pUm))
    {
      this.pYF.setText(this.pUm);
      AppMethodBeat.o(113165);
      return;
    }
    this.pYF.setText(2131757150);
    AppMethodBeat.o(113165);
  }
  
  public final void d(int paramInt1, int paramInt2, Intent paramIntent)
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
      this.pXh = paramIntent.getIntExtra("Ktag_range_index", 0);
      Log.i("MicroMsg.CardAcceptCardListUI", "mPrivateSelelct : %d", new Object[] { Integer.valueOf(this.pXh) });
      if (this.pXh >= 2)
      {
        this.pXi = paramIntent.getStringExtra("Klabel_name_list");
        this.pXj = paramIntent.getStringExtra("Kother_user_name_list");
        Log.d("MicroMsg.CardAcceptCardListUI", "mPrivateSelect : %d, names : %s", new Object[] { Integer.valueOf(this.pXh), this.pXi });
        if ((TextUtils.isEmpty(this.pXi)) && (TextUtils.isEmpty(this.pXj)))
        {
          Log.e("MicroMsg.CardAcceptCardListUI", "mLabelNameList by getIntent is empty");
          cuZ();
          AppMethodBeat.o(113163);
          return;
        }
        paramIntent = Arrays.asList(this.pXi.split(","));
        this.pXl = l.cZ(paramIntent);
        this.pXk = l.cY(paramIntent);
        if ((this.pXj != null) && (this.pXj.length() > 0))
        {
          paramIntent = Arrays.asList(this.pXj.split(","));
          this.pXk.addAll(paramIntent);
        }
        if (this.pXl != null) {
          Log.i("MicroMsg.CardAcceptCardListUI", "mPrivateIdsList size is " + this.pXl.size());
        }
        if (this.pXk != null)
        {
          Log.i("MicroMsg.CardAcceptCardListUI", "mPrivateNamesList size is " + this.pXk.size());
          paramIntent = this.pXk.iterator();
          while (paramIntent.hasNext()) {
            Log.d("MicroMsg.CardAcceptCardListUI", "username : %s", new Object[] { (String)paramIntent.next() });
          }
        }
        if (!TextUtils.isEmpty(this.pXi))
        {
          if (this.pXh == 2)
          {
            this.pYF.setText(getString(2131757152, new Object[] { cuG() }));
            AppMethodBeat.o(113163);
            return;
          }
          if (this.pXh == 3)
          {
            this.pYF.setText(getString(2131757151, new Object[] { cuG() }));
            AppMethodBeat.o(113163);
          }
        }
        else
        {
          cuZ();
        }
        AppMethodBeat.o(113163);
        return;
      }
      cuZ();
    }
  }
  
  public int getLayoutId()
  {
    return 2131493335;
  }
  
  public void initView()
  {
    AppMethodBeat.i(113156);
    setMMTitle(2131756953);
    setBackBtn(new CardAcceptCardListUI.1(this));
    this.pYA = findViewById(2131298019);
    this.pYB = findViewById(2131309321);
    this.GT = findViewById(2131303234);
    this.pYB.setVisibility(4);
    this.pQq = ((ListView)findViewById(16908298));
    this.pQs = ((RelativeLayout)findViewById(2131299212));
    this.pQq.setEmptyView(this.pQs);
    this.pYC = new a(this);
    this.pQq.setAdapter(this.pYC);
    this.pQq.setOnItemClickListener(new CardAcceptCardListUI.2(this));
    this.pYD = findViewById(2131298023);
    this.pXa = ((Button)findViewById(2131298014));
    this.pXa.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(113151);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/CardAcceptCardListUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
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
          paramAnonymousView.ku(true);
          paramAnonymousView = new p((LinkedList)localObject, paramAnonymousView.eaQ, paramAnonymousView.pYJ, paramAnonymousView.pYK, paramAnonymousView.pYI);
          com.tencent.mm.kernel.g.aAg().hqi.a(paramAnonymousView, 0);
        }
      }
    });
    this.pXa.setEnabled(false);
    this.pYE = findViewById(2131298196);
    this.pYF = ((TextView)findViewById(2131298197));
    this.pYG = ((Button)findViewById(2131298195));
    this.pYG.setOnClickListener(new CardAcceptCardListUI.4(this));
    Object localObject2 = getIntent();
    if (localObject2 == null)
    {
      Log.e("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI initView () intent == null");
      Eq(2);
      AppMethodBeat.o(113156);
      return;
    }
    Log.i("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI handle data");
    Object localObject3 = ((Intent)localObject2).getStringExtra("key_in_card_list");
    this.eaQ = ((Intent)localObject2).getIntExtra("key_from_scene", 8);
    Object localObject1 = ((Intent)localObject2).getStringExtra("key_package_name");
    localObject2 = ((Intent)localObject2).getStringExtra("key_sign");
    this.pYI = getIntent().getIntExtra("key_stastic_scene", 7);
    this.pYJ = getIntent().getStringExtra("src_username");
    this.pYK = getIntent().getStringExtra("js_url");
    this.pYL = getIntent().getStringExtra("key_consumed_card_id");
    this.ixM = getIntent().getStringExtra("key_template_id");
    localObject3 = com.tencent.mm.plugin.card.d.h.cR((String)localObject3, this.eaQ);
    if ((localObject3 == null) || (((List)localObject3).size() == 0))
    {
      Log.e("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI initView () tempList == null || tempList.size() == 0");
      Eq(2);
      AppMethodBeat.o(113156);
      return;
    }
    this.pYH.clear();
    this.pYH.addAll((Collection)localObject3);
    this.pYM.clear();
    this.pYN.clear();
    this.pYu.clear();
    localObject3 = this.pYH;
    ku(true);
    localObject1 = new ab((LinkedList)localObject3, this.eaQ, (String)localObject1, (String)localObject2, this.pYJ, this.pYK, this.pYL, this.pYI);
    com.tencent.mm.kernel.g.aAg().hqi.a((com.tencent.mm.ak.q)localObject1, 0);
    AppMethodBeat.o(113156);
  }
  
  final void ku(boolean paramBoolean)
  {
    AppMethodBeat.i(113159);
    if (paramBoolean)
    {
      this.gxX = com.tencent.mm.ui.base.q.a(this, getString(2131762446), false, 0, null);
      AppMethodBeat.o(113159);
      return;
    }
    if ((this.gxX != null) && (this.gxX.isShowing()))
    {
      this.gxX.dismiss();
      this.gxX = null;
    }
    AppMethodBeat.o(113159);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(113157);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.aAg().hqi.a(1079, this);
    com.tencent.mm.kernel.g.aAg().hqi.a(1049, this);
    com.tencent.mm.kernel.g.aAg().hqi.a(902, this);
    initView();
    AppMethodBeat.o(113157);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113158);
    com.tencent.mm.kernel.g.aAg().hqi.b(1079, this);
    com.tencent.mm.kernel.g.aAg().hqi.b(1049, this);
    com.tencent.mm.kernel.g.aAg().hqi.b(902, this);
    this.pYH.clear();
    a locala = this.pYC;
    locala.pXz.clear();
    locala.mContext = null;
    super.onDestroy();
    AppMethodBeat.o(113158);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(113161);
    if (paramInt == 4)
    {
      Log.i("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI onKeyDown() back cancel");
      Eq(1);
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(113161);
    return bool;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(113160);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      Object localObject1;
      if ((paramq instanceof ab))
      {
        ku(false);
        paramString = (ab)paramq;
        paramq = paramString.pTY;
        this.pUj = paramString.pUj;
        this.pUk = paramString.pUk;
        this.pUl = paramString.pUl;
        this.pUm = paramString.pUm;
        Log.i("MicroMsg.CardAcceptCardListUI", "accept_button_status: " + this.pUj + "  accept_button_wording: " + this.pUk);
        Log.i("MicroMsg.CardAcceptCardListUI", "private_status: " + this.pUl + "  private_wording: " + this.pUm);
        paramString = f.ajX(paramq);
        paramq = cS(paramString);
        Object localObject2;
        if ((paramString != null) && (paramString.size() > 0))
        {
          Log.i("MicroMsg.CardAcceptCardListUI", "The card info list size is " + paramString.size());
          if ((paramq != null) && (paramq.size() > 0))
          {
            localObject1 = this.pYC;
            localObject2 = this.pYu;
            if (paramq != null)
            {
              ((a)localObject1).pXz.clear();
              ((a)localObject1).pXz.addAll(paramq);
              ((a)localObject1).pYu.putAll((Map)localObject2);
            }
          }
          this.pYC.notifyDataSetChanged();
          if (((CardInfo)paramString.get(0)).csw()) {
            this.pSh = true;
          }
          this.pYB.setVisibility(0);
          if (this.pYC.getCount() <= 0) {
            break label859;
          }
          paramString = this.pYC.Ep(0);
          n.a(this, paramString);
          this.pYA.setBackgroundColor(l.ake(paramString.csQ().ixw));
          this.pYD.setVisibility(0);
          paramq = new StateListDrawable();
          paramInt1 = getResources().getDimensionPixelOffset(2131166016);
          if (this.pUj != 1) {
            break label697;
          }
          this.pXa.setEnabled(true);
          localObject1 = l.fi(l.ake(paramString.csQ().ixw), paramInt1);
          localObject2 = l.fi(l.convertStringToRGB(paramString.csQ().ixw, 175), paramInt1);
          paramq.addState(new int[] { 16842919 }, (Drawable)localObject2);
          paramq.addState(new int[0], (Drawable)localObject1);
        }
        for (;;)
        {
          this.pXa.setBackgroundDrawable(paramq);
          if (!TextUtils.isEmpty(this.pUk)) {
            this.pXa.setText(this.pUk);
          }
          if (this.pUl != 1) {
            break label754;
          }
          paramInt1 = getResources().getDimensionPixelOffset(2131165534);
          paramq = l.e(this, getResources().getColor(2131101424), paramInt1);
          localObject1 = l.fi(getResources().getColor(2131101424), paramInt1);
          localObject2 = new StateListDrawable();
          ((StateListDrawable)localObject2).addState(new int[] { 16842919 }, (Drawable)localObject1);
          ((StateListDrawable)localObject2).addState(new int[0], paramq);
          this.pYG.setBackgroundDrawable((Drawable)localObject2);
          paramInt1 = l.ake(paramString.csQ().ixw);
          paramInt2 = getResources().getColor(2131101424);
          paramString = new ColorStateList(new int[][] { { 16842919, 16842910 }, new int[0] }, new int[] { paramInt1, paramInt2 });
          this.pYG.setTextColor(paramString);
          this.pYE.setVisibility(0);
          if (TextUtils.isEmpty(this.pUm)) {
            break label737;
          }
          this.pYF.setText(this.pUm);
          AppMethodBeat.o(113160);
          return;
          Log.e("MicroMsg.CardAcceptCardListUI", "The card info list size is 0!");
          break;
          label697:
          this.pXa.setEnabled(false);
          localObject1 = l.fi(l.convertStringToRGB(paramString.csQ().ixw, 175), paramInt1);
          paramq.addState(new int[0], (Drawable)localObject1);
        }
        label737:
        this.pYF.setText(2131757150);
        AppMethodBeat.o(113160);
        return;
        label754:
        this.pYE.setVisibility(8);
        paramString = (RelativeLayout.LayoutParams)this.pYB.getLayoutParams();
        paramString.topMargin = getResources().getDimensionPixelSize(2131165586);
        paramString.bottomMargin = getResources().getDimensionPixelSize(2131165502);
        this.pYB.setLayoutParams(paramString);
        this.pYB.invalidate();
        paramString = (RelativeLayout.LayoutParams)this.pYD.getLayoutParams();
        paramString.addRule(8, 2131303234);
        this.pYD.setLayoutParams(paramString);
        this.pYD.invalidate();
        AppMethodBeat.o(113160);
        return;
        label859:
        this.pYD.setVisibility(8);
        this.pYE.setVisibility(8);
        this.pYA.setBackgroundColor(getResources().getColor(2131100115));
        AppMethodBeat.o(113160);
        return;
      }
      if ((paramq instanceof p))
      {
        ku(false);
        localObject1 = (p)paramq;
        if (((p)localObject1).pTZ != 0)
        {
          paramq = ((p)localObject1).pUa;
          paramString = paramq;
          if (TextUtils.isEmpty(paramq)) {
            paramString = getString(2131756968);
          }
          com.tencent.mm.ui.base.h.a(this, paramString, null, false, new CardAcceptCardListUI.5(this));
          this.pUi = ((p)localObject1).pTY;
          AppMethodBeat.o(113160);
          return;
        }
        com.tencent.mm.ui.base.h.cD(this, getResources().getString(2131757037));
        paramString = new Intent();
        paramString.putExtra("card_list", ((p)localObject1).pTY);
        setResult(-1, paramString);
        Log.i("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI setResult RESULT_OK for card");
        l.cxE();
        finish();
        AppMethodBeat.o(113160);
        return;
      }
      if ((paramq instanceof com.tencent.mm.plugin.card.sharecard.model.g))
      {
        ku(false);
        paramString = ((com.tencent.mm.plugin.card.sharecard.model.g)paramq).pTY;
        paramInt1 = ((com.tencent.mm.plugin.card.sharecard.model.g)paramq).pTZ;
        paramq = ((com.tencent.mm.plugin.card.sharecard.model.g)paramq).pUa;
        this.pUi = paramString;
        if (paramInt1 != 0)
        {
          paramString = paramq;
          if (TextUtils.isEmpty(paramq)) {
            paramString = getString(2131757161);
          }
          com.tencent.mm.ui.base.h.a(this, paramString, null, false, new CardAcceptCardListUI.6(this));
          AppMethodBeat.o(113160);
          return;
        }
        com.tencent.mm.ui.base.h.cD(this, getResources().getString(2131756959));
        paramq = new Intent();
        paramq.putExtra("card_list", this.pUi);
        setResult(-1, paramq);
        Log.i("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI setResult RESULT_OK for sharecard");
        l.cxG();
        paramq = new ShareCardInfo();
        f.a(paramq, paramString);
        l.a(paramq);
        am.ctX().onChange();
        finish();
        AppMethodBeat.o(113160);
      }
    }
    else
    {
      Log.e("MicroMsg.CardAcceptCardListUI", "CardAddEntranceUI onSceneEnd() netsene type" + paramq.getType() + "errType = " + paramInt1 + " errCode = " + paramInt2);
      ku(false);
      d.b(this, paramString, paramInt2);
      if ((paramq instanceof p))
      {
        this.pUi = paramString;
        AppMethodBeat.o(113160);
        return;
      }
      if ((paramq instanceof com.tencent.mm.plugin.card.sharecard.model.g)) {
        this.pUi = "";
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardAcceptCardListUI
 * JD-Core Version:    0.7.0.1
 */