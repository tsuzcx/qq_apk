package com.tencent.mm.plugin.card.ui;

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
import com.tencent.mm.am.s;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.c;
import com.tencent.mm.plugin.card.a.a;
import com.tencent.mm.plugin.card.a.b;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.c.d;
import com.tencent.mm.plugin.card.c.f;
import com.tencent.mm.plugin.card.c.l;
import com.tencent.mm.plugin.card.c.n;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.ab;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.sharecard.model.g;
import com.tencent.mm.protocal.protobuf.wf;
import com.tencent.mm.protocal.protobuf.ws;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;
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
  implements com.tencent.mm.am.h, MMActivity.a
{
  private View bEA;
  int iaK;
  private w lKp;
  private String nSg;
  protected ListView wqQ;
  protected RelativeLayout wqS;
  private boolean wsH;
  private String wuI;
  private int wuJ;
  private String wuK;
  private int wuL;
  private String wuM;
  public int wxB;
  private String wxC;
  private String wxD;
  public ArrayList<String> wxE;
  public ArrayList<String> wxF;
  private Button wxu;
  HashMap<String, Integer> wyN;
  private View wyT;
  private View wyU;
  protected a wyV;
  private View wyW;
  private View wyX;
  private TextView wyY;
  private Button wyZ;
  LinkedList<wf> wza;
  int wzb;
  String wzc;
  String wzd;
  private String wze;
  LinkedList<wf> wzf;
  LinkedList<String> wzg;
  
  public CardAcceptCardListUI()
  {
    AppMethodBeat.i(113155);
    this.wqQ = null;
    this.wyV = null;
    this.wqS = null;
    this.lKp = null;
    this.wza = new LinkedList();
    this.wuI = "";
    this.iaK = 8;
    this.wzb = 7;
    this.wzc = "";
    this.wzd = "";
    this.wze = "";
    this.wsH = false;
    this.wxB = 0;
    this.wxC = "";
    this.wxD = "";
    this.wxE = new ArrayList();
    this.wxF = new ArrayList();
    this.wzf = new LinkedList();
    this.wzg = new LinkedList();
    this.wyN = new HashMap();
    this.nSg = "";
    AppMethodBeat.o(113155);
  }
  
  private void Is(int paramInt)
  {
    AppMethodBeat.i(113162);
    Log.i("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI finishUI() result_code:".concat(String.valueOf(paramInt)));
    Intent localIntent = new Intent();
    localIntent.putExtra("card_list", this.wuI);
    localIntent.putExtra("result_code", paramInt);
    setResult(0, localIntent);
    finish();
    AppMethodBeat.o(113162);
  }
  
  private void dlS()
  {
    AppMethodBeat.i(113165);
    if (!TextUtils.isEmpty(this.wuM))
    {
      this.wyY.setText(this.wuM);
      AppMethodBeat.o(113165);
      return;
    }
    this.wyY.setText(a.g.wpZ);
    AppMethodBeat.o(113165);
  }
  
  private String dlz()
  {
    AppMethodBeat.i(113164);
    String str;
    if ((!TextUtils.isEmpty(this.wxC)) && (!TextUtils.isEmpty(this.wxD)))
    {
      str = this.wxC + "," + l.aly(this.wxD);
      AppMethodBeat.o(113164);
      return str;
    }
    if (!TextUtils.isEmpty(this.wxC))
    {
      str = this.wxC;
      AppMethodBeat.o(113164);
      return str;
    }
    if (!TextUtils.isEmpty(this.wxD))
    {
      str = l.aly(this.wxD);
      AppMethodBeat.o(113164);
      return str;
    }
    AppMethodBeat.o(113164);
    return "";
  }
  
  private ArrayList<CardInfo> eK(List<CardInfo> paramList)
  {
    AppMethodBeat.i(113166);
    if ((paramList == null) || (paramList.size() == 0))
    {
      Log.e("MicroMsg.CardAcceptCardListUI", "geCardInfoListByTpId list is empty!");
      AppMethodBeat.o(113166);
      return null;
    }
    this.wzf.clear();
    this.wzg.clear();
    this.wyN.clear();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < paramList.size())
    {
      CardInfo localCardInfo = (CardInfo)paramList.get(i);
      if (this.wzg.contains(localCardInfo.field_card_tp_id))
      {
        int j = ((Integer)this.wyN.get(localCardInfo.field_card_tp_id)).intValue();
        this.wyN.put(localCardInfo.field_card_tp_id, Integer.valueOf(j + 1));
      }
      for (;;)
      {
        i += 1;
        break;
        localArrayList.add(localCardInfo);
        this.wyN.put(localCardInfo.field_card_tp_id, Integer.valueOf(1));
        this.wzg.add(localCardInfo.field_card_tp_id);
      }
    }
    AppMethodBeat.o(113166);
    return localArrayList;
  }
  
  public int getLayoutId()
  {
    return a.e.wfg;
  }
  
  public void initView()
  {
    AppMethodBeat.i(113156);
    setMMTitle(a.g.wnT);
    setBackBtn(new CardAcceptCardListUI.1(this));
    this.wyT = findViewById(a.d.wfg);
    this.wyU = findViewById(a.d.top_layout);
    this.bEA = findViewById(a.d.list_layout);
    this.wyU.setVisibility(4);
    this.wqQ = ((ListView)findViewById(16908298));
    this.wqS = ((RelativeLayout)findViewById(a.d.wjH));
    this.wqQ.setEmptyView(this.wqS);
    this.wyV = new a(this);
    this.wqQ.setAdapter(this.wyV);
    this.wqQ.setOnItemClickListener(new CardAcceptCardListUI.2(this));
    this.wyW = findViewById(a.d.wfj);
    this.wxu = ((Button)findViewById(a.d.fvn));
    this.wxu.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(113151);
        Object localObject = new b();
        ((b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/card/ui/CardAcceptCardListUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
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
          paramAnonymousView.na(true);
          paramAnonymousView = new com.tencent.mm.plugin.card.model.p((LinkedList)localObject, paramAnonymousView.iaK, paramAnonymousView.wzc, paramAnonymousView.wzd, paramAnonymousView.wzb);
          com.tencent.mm.kernel.h.baD().mCm.a(paramAnonymousView, 0);
        }
      }
    });
    this.wxu.setEnabled(false);
    this.wyX = findViewById(a.d.whw);
    this.wyY = ((TextView)findViewById(a.d.whx));
    this.wyZ = ((Button)findViewById(a.d.whv));
    this.wyZ.setOnClickListener(new CardAcceptCardListUI.4(this));
    Object localObject2 = getIntent();
    if (localObject2 == null)
    {
      Log.e("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI initView () intent == null");
      Is(2);
      AppMethodBeat.o(113156);
      return;
    }
    Log.i("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI handle data");
    Object localObject3 = ((Intent)localObject2).getStringExtra("key_in_card_list");
    this.iaK = ((Intent)localObject2).getIntExtra("key_from_scene", 8);
    Object localObject1 = ((Intent)localObject2).getStringExtra("key_package_name");
    localObject2 = ((Intent)localObject2).getStringExtra("key_sign");
    this.wzb = getIntent().getIntExtra("key_stastic_scene", 7);
    this.wzc = getIntent().getStringExtra("src_username");
    this.wzd = getIntent().getStringExtra("js_url");
    this.wze = getIntent().getStringExtra("key_consumed_card_id");
    this.nSg = getIntent().getStringExtra("key_template_id");
    localObject3 = com.tencent.mm.plugin.card.c.h.dM((String)localObject3, this.iaK);
    if ((localObject3 == null) || (((List)localObject3).size() == 0))
    {
      Log.e("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI initView () tempList == null || tempList.size() == 0");
      Is(2);
      AppMethodBeat.o(113156);
      return;
    }
    this.wza.clear();
    this.wza.addAll((Collection)localObject3);
    this.wzf.clear();
    this.wzg.clear();
    this.wyN.clear();
    localObject3 = this.wza;
    na(true);
    localObject1 = new ab((LinkedList)localObject3, this.iaK, (String)localObject1, (String)localObject2, this.wzc, this.wzd, this.wze, this.wzb);
    com.tencent.mm.kernel.h.baD().mCm.a((com.tencent.mm.am.p)localObject1, 0);
    AppMethodBeat.o(113156);
  }
  
  public void mmOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
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
      this.wxB = paramIntent.getIntExtra("Ktag_range_index", 0);
      Log.i("MicroMsg.CardAcceptCardListUI", "mPrivateSelelct : %d", new Object[] { Integer.valueOf(this.wxB) });
      if (this.wxB >= 2)
      {
        this.wxC = paramIntent.getStringExtra("Klabel_name_list");
        this.wxD = paramIntent.getStringExtra("Kother_user_name_list");
        Log.d("MicroMsg.CardAcceptCardListUI", "mPrivateSelect : %d, names : %s", new Object[] { Integer.valueOf(this.wxB), this.wxC });
        if ((TextUtils.isEmpty(this.wxC)) && (TextUtils.isEmpty(this.wxD)))
        {
          Log.e("MicroMsg.CardAcceptCardListUI", "mLabelNameList by getIntent is empty");
          dlS();
          AppMethodBeat.o(113163);
          return;
        }
        paramIntent = Arrays.asList(this.wxC.split(","));
        this.wxF = l.eR(paramIntent);
        this.wxE = l.eQ(paramIntent);
        if ((this.wxD != null) && (this.wxD.length() > 0))
        {
          paramIntent = Arrays.asList(this.wxD.split(","));
          this.wxE.addAll(paramIntent);
        }
        if (this.wxF != null) {
          Log.i("MicroMsg.CardAcceptCardListUI", "mPrivateIdsList size is " + this.wxF.size());
        }
        if (this.wxE != null)
        {
          Log.i("MicroMsg.CardAcceptCardListUI", "mPrivateNamesList size is " + this.wxE.size());
          paramIntent = this.wxE.iterator();
          while (paramIntent.hasNext()) {
            Log.d("MicroMsg.CardAcceptCardListUI", "username : %s", new Object[] { (String)paramIntent.next() });
          }
        }
        if (!TextUtils.isEmpty(this.wxC))
        {
          if (this.wxB == 2)
          {
            this.wyY.setText(getString(a.g.wqb, new Object[] { dlz() }));
            AppMethodBeat.o(113163);
            return;
          }
          if (this.wxB == 3)
          {
            this.wyY.setText(getString(a.g.wqa, new Object[] { dlz() }));
            AppMethodBeat.o(113163);
          }
        }
        else
        {
          dlS();
        }
        AppMethodBeat.o(113163);
        return;
      }
      dlS();
    }
  }
  
  final void na(boolean paramBoolean)
  {
    AppMethodBeat.i(113159);
    if (paramBoolean)
    {
      this.lKp = w.a(this, getString(a.g.loading_tips), false, 0, null);
      AppMethodBeat.o(113159);
      return;
    }
    if ((this.lKp != null) && (this.lKp.isShowing()))
    {
      this.lKp.dismiss();
      this.lKp = null;
    }
    AppMethodBeat.o(113159);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(113157);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.h.baD().mCm.a(1079, this);
    com.tencent.mm.kernel.h.baD().mCm.a(1049, this);
    com.tencent.mm.kernel.h.baD().mCm.a(902, this);
    initView();
    AppMethodBeat.o(113157);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113158);
    com.tencent.mm.kernel.h.baD().mCm.b(1079, this);
    com.tencent.mm.kernel.h.baD().mCm.b(1049, this);
    com.tencent.mm.kernel.h.baD().mCm.b(902, this);
    this.wza.clear();
    a locala = this.wyV;
    locala.wyM.clear();
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
      Is(1);
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(113161);
    return bool;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(113160);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      Object localObject1;
      if ((paramp instanceof ab))
      {
        na(false);
        paramString = (ab)paramp;
        paramp = paramString.wuy;
        this.wuJ = paramString.wuJ;
        this.wuK = paramString.wuK;
        this.wuL = paramString.wuL;
        this.wuM = paramString.wuM;
        Log.i("MicroMsg.CardAcceptCardListUI", "accept_button_status: " + this.wuJ + "  accept_button_wording: " + this.wuK);
        Log.i("MicroMsg.CardAcceptCardListUI", "private_status: " + this.wuL + "  private_wording: " + this.wuM);
        paramString = f.alo(paramp);
        paramp = eK(paramString);
        Object localObject2;
        if ((paramString != null) && (paramString.size() > 0))
        {
          Log.i("MicroMsg.CardAcceptCardListUI", "The card info list size is " + paramString.size());
          if ((paramp != null) && (paramp.size() > 0))
          {
            localObject1 = this.wyV;
            localObject2 = this.wyN;
            if (paramp != null)
            {
              ((a)localObject1).wyM.clear();
              ((a)localObject1).wyM.addAll(paramp);
              ((a)localObject1).wyN.putAll((Map)localObject2);
            }
          }
          this.wyV.notifyDataSetChanged();
          if (((CardInfo)paramString.get(0)).djp()) {
            this.wsH = true;
          }
          this.wyU.setVisibility(0);
          if (this.wyV.getCount() <= 0) {
            break label859;
          }
          paramString = this.wyV.Ir(0);
          n.a(this, paramString);
          this.wyT.setBackgroundColor(l.alv(paramString.djK().nRQ));
          this.wyW.setVisibility(0);
          paramp = new StateListDrawable();
          paramInt1 = getResources().getDimensionPixelOffset(a.b.wdZ);
          if (this.wuJ != 1) {
            break label697;
          }
          this.wxu.setEnabled(true);
          localObject1 = l.gx(l.alv(paramString.djK().nRQ), paramInt1);
          localObject2 = l.gx(l.convertStringToRGB(paramString.djK().nRQ, 175), paramInt1);
          paramp.addState(new int[] { 16842919 }, (Drawable)localObject2);
          paramp.addState(new int[0], (Drawable)localObject1);
        }
        for (;;)
        {
          this.wxu.setBackgroundDrawable(paramp);
          if (!TextUtils.isEmpty(this.wuK)) {
            this.wxu.setText(this.wuK);
          }
          if (this.wuL != 1) {
            break label754;
          }
          paramInt1 = getResources().getDimensionPixelOffset(a.b.NormalPadding);
          paramp = l.e(this, getResources().getColor(a.a.white), paramInt1);
          localObject1 = l.gx(getResources().getColor(a.a.white), paramInt1);
          localObject2 = new StateListDrawable();
          ((StateListDrawable)localObject2).addState(new int[] { 16842919 }, (Drawable)localObject1);
          ((StateListDrawable)localObject2).addState(new int[0], paramp);
          this.wyZ.setBackgroundDrawable((Drawable)localObject2);
          paramInt1 = l.alv(paramString.djK().nRQ);
          paramInt2 = getResources().getColor(a.a.white);
          paramString = new ColorStateList(new int[][] { { 16842919, 16842910 }, new int[0] }, new int[] { paramInt1, paramInt2 });
          this.wyZ.setTextColor(paramString);
          this.wyX.setVisibility(0);
          if (TextUtils.isEmpty(this.wuM)) {
            break label737;
          }
          this.wyY.setText(this.wuM);
          AppMethodBeat.o(113160);
          return;
          Log.e("MicroMsg.CardAcceptCardListUI", "The card info list size is 0!");
          break;
          label697:
          this.wxu.setEnabled(false);
          localObject1 = l.gx(l.convertStringToRGB(paramString.djK().nRQ, 175), paramInt1);
          paramp.addState(new int[0], (Drawable)localObject1);
        }
        label737:
        this.wyY.setText(a.g.wpZ);
        AppMethodBeat.o(113160);
        return;
        label754:
        this.wyX.setVisibility(8);
        paramString = (RelativeLayout.LayoutParams)this.wyU.getLayoutParams();
        paramString.topMargin = getResources().getDimensionPixelSize(a.b.SmallPadding);
        paramString.bottomMargin = getResources().getDimensionPixelSize(a.b.LargestPadding);
        this.wyU.setLayoutParams(paramString);
        this.wyU.invalidate();
        paramString = (RelativeLayout.LayoutParams)this.wyW.getLayoutParams();
        paramString.addRule(8, a.d.list_layout);
        this.wyW.setLayoutParams(paramString);
        this.wyW.invalidate();
        AppMethodBeat.o(113160);
        return;
        label859:
        this.wyW.setVisibility(8);
        this.wyX.setVisibility(8);
        this.wyT.setBackgroundColor(getResources().getColor(a.a.wdB));
        AppMethodBeat.o(113160);
        return;
      }
      if ((paramp instanceof com.tencent.mm.plugin.card.model.p))
      {
        na(false);
        localObject1 = (com.tencent.mm.plugin.card.model.p)paramp;
        if (((com.tencent.mm.plugin.card.model.p)localObject1).wuz != 0)
        {
          paramp = ((com.tencent.mm.plugin.card.model.p)localObject1).wuA;
          paramString = paramp;
          if (TextUtils.isEmpty(paramp)) {
            paramString = getString(a.g.wog);
          }
          k.a(this, paramString, null, false, new CardAcceptCardListUI.5(this));
          this.wuI = ((com.tencent.mm.plugin.card.model.p)localObject1).wuy;
          AppMethodBeat.o(113160);
          return;
        }
        k.cZ(this, getResources().getString(a.g.woM));
        paramString = new Intent();
        paramString.putExtra("card_list", ((com.tencent.mm.plugin.card.model.p)localObject1).wuy);
        setResult(-1, paramString);
        Log.i("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI setResult RESULT_OK for card");
        l.doO();
        finish();
        AppMethodBeat.o(113160);
        return;
      }
      if ((paramp instanceof g))
      {
        na(false);
        paramString = ((g)paramp).wuy;
        paramInt1 = ((g)paramp).wuz;
        paramp = ((g)paramp).wuA;
        this.wuI = paramString;
        if (paramInt1 != 0)
        {
          paramString = paramp;
          if (TextUtils.isEmpty(paramp)) {
            paramString = getString(a.g.wqi);
          }
          k.a(this, paramString, null, false, new CardAcceptCardListUI.6(this));
          AppMethodBeat.o(113160);
          return;
        }
        k.cZ(this, getResources().getString(a.g.wnY));
        paramp = new Intent();
        paramp.putExtra("card_list", this.wuI);
        setResult(-1, paramp);
        Log.i("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI setResult RESULT_OK for sharecard");
        l.doQ();
        paramp = new ShareCardInfo();
        f.a(paramp, paramString);
        l.a(paramp);
        am.dkQ().onChange();
        finish();
        AppMethodBeat.o(113160);
      }
    }
    else
    {
      Log.e("MicroMsg.CardAcceptCardListUI", "CardAddEntranceUI onSceneEnd() netsene type" + paramp.getType() + "errType = " + paramInt1 + " errCode = " + paramInt2);
      na(false);
      d.b(this, paramString, paramInt2);
      if ((paramp instanceof com.tencent.mm.plugin.card.model.p))
      {
        this.wuI = paramString;
        AppMethodBeat.o(113160);
        return;
      }
      if ((paramp instanceof g)) {
        this.wuI = "";
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardAcceptCardListUI
 * JD-Core Version:    0.7.0.1
 */