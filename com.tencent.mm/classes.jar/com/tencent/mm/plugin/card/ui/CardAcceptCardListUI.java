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
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.c;
import com.tencent.mm.plugin.card.a.a;
import com.tencent.mm.plugin.card.a.b;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.d.d;
import com.tencent.mm.plugin.card.d.f;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.n;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.ab;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.p;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.sharecard.model.g;
import com.tencent.mm.protocal.protobuf.uo;
import com.tencent.mm.protocal.protobuf.vb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.s;
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
  private View Xg;
  int fUN;
  private s jhZ;
  private String lnb;
  protected ListView tmq;
  protected RelativeLayout tms;
  private boolean tog;
  private String tqj;
  private int tqk;
  private String tql;
  private int tqm;
  private String tqn;
  private Button tsX;
  public int tte;
  private String ttf;
  private String ttg;
  public ArrayList<String> tth;
  public ArrayList<String> tti;
  private View tuA;
  private TextView tuB;
  private Button tuC;
  LinkedList<uo> tuD;
  int tuE;
  String tuF;
  String tuG;
  private String tuH;
  LinkedList<uo> tuI;
  LinkedList<String> tuJ;
  HashMap<String, Integer> tuq;
  private View tuw;
  private View tux;
  protected a tuy;
  private View tuz;
  
  public CardAcceptCardListUI()
  {
    AppMethodBeat.i(113155);
    this.tmq = null;
    this.tuy = null;
    this.tms = null;
    this.jhZ = null;
    this.tuD = new LinkedList();
    this.tqj = "";
    this.fUN = 8;
    this.tuE = 7;
    this.tuF = "";
    this.tuG = "";
    this.tuH = "";
    this.tog = false;
    this.tte = 0;
    this.ttf = "";
    this.ttg = "";
    this.tth = new ArrayList();
    this.tti = new ArrayList();
    this.tuI = new LinkedList();
    this.tuJ = new LinkedList();
    this.tuq = new HashMap();
    this.lnb = "";
    AppMethodBeat.o(113155);
  }
  
  private void HR(int paramInt)
  {
    AppMethodBeat.i(113162);
    Log.i("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI finishUI() result_code:".concat(String.valueOf(paramInt)));
    Intent localIntent = new Intent();
    localIntent.putExtra("card_list", this.tqj);
    localIntent.putExtra("result_code", paramInt);
    setResult(0, localIntent);
    finish();
    AppMethodBeat.o(113162);
  }
  
  private void cIB()
  {
    AppMethodBeat.i(113165);
    if (!TextUtils.isEmpty(this.tqn))
    {
      this.tuB.setText(this.tqn);
      AppMethodBeat.o(113165);
      return;
    }
    this.tuB.setText(a.g.tlA);
    AppMethodBeat.o(113165);
  }
  
  private String cIi()
  {
    AppMethodBeat.i(113164);
    String str;
    if ((!TextUtils.isEmpty(this.ttf)) && (!TextUtils.isEmpty(this.ttg)))
    {
      str = this.ttf + "," + l.arU(this.ttg);
      AppMethodBeat.o(113164);
      return str;
    }
    if (!TextUtils.isEmpty(this.ttf))
    {
      str = this.ttf;
      AppMethodBeat.o(113164);
      return str;
    }
    if (!TextUtils.isEmpty(this.ttg))
    {
      str = l.arU(this.ttg);
      AppMethodBeat.o(113164);
      return str;
    }
    AppMethodBeat.o(113164);
    return "";
  }
  
  private ArrayList<CardInfo> cP(List<CardInfo> paramList)
  {
    AppMethodBeat.i(113166);
    if ((paramList == null) || (paramList.size() == 0))
    {
      Log.e("MicroMsg.CardAcceptCardListUI", "geCardInfoListByTpId list is empty!");
      AppMethodBeat.o(113166);
      return null;
    }
    this.tuI.clear();
    this.tuJ.clear();
    this.tuq.clear();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < paramList.size())
    {
      CardInfo localCardInfo = (CardInfo)paramList.get(i);
      if (this.tuJ.contains(localCardInfo.field_card_tp_id))
      {
        int j = ((Integer)this.tuq.get(localCardInfo.field_card_tp_id)).intValue();
        this.tuq.put(localCardInfo.field_card_tp_id, Integer.valueOf(j + 1));
      }
      for (;;)
      {
        i += 1;
        break;
        localArrayList.add(localCardInfo);
        this.tuq.put(localCardInfo.field_card_tp_id, Integer.valueOf(1));
        this.tuJ.add(localCardInfo.field_card_tp_id);
      }
    }
    AppMethodBeat.o(113166);
    return localArrayList;
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
      this.tte = paramIntent.getIntExtra("Ktag_range_index", 0);
      Log.i("MicroMsg.CardAcceptCardListUI", "mPrivateSelelct : %d", new Object[] { Integer.valueOf(this.tte) });
      if (this.tte >= 2)
      {
        this.ttf = paramIntent.getStringExtra("Klabel_name_list");
        this.ttg = paramIntent.getStringExtra("Kother_user_name_list");
        Log.d("MicroMsg.CardAcceptCardListUI", "mPrivateSelect : %d, names : %s", new Object[] { Integer.valueOf(this.tte), this.ttf });
        if ((TextUtils.isEmpty(this.ttf)) && (TextUtils.isEmpty(this.ttg)))
        {
          Log.e("MicroMsg.CardAcceptCardListUI", "mLabelNameList by getIntent is empty");
          cIB();
          AppMethodBeat.o(113163);
          return;
        }
        paramIntent = Arrays.asList(this.ttf.split(","));
        this.tti = l.cW(paramIntent);
        this.tth = l.cV(paramIntent);
        if ((this.ttg != null) && (this.ttg.length() > 0))
        {
          paramIntent = Arrays.asList(this.ttg.split(","));
          this.tth.addAll(paramIntent);
        }
        if (this.tti != null) {
          Log.i("MicroMsg.CardAcceptCardListUI", "mPrivateIdsList size is " + this.tti.size());
        }
        if (this.tth != null)
        {
          Log.i("MicroMsg.CardAcceptCardListUI", "mPrivateNamesList size is " + this.tth.size());
          paramIntent = this.tth.iterator();
          while (paramIntent.hasNext()) {
            Log.d("MicroMsg.CardAcceptCardListUI", "username : %s", new Object[] { (String)paramIntent.next() });
          }
        }
        if (!TextUtils.isEmpty(this.ttf))
        {
          if (this.tte == 2)
          {
            this.tuB.setText(getString(a.g.tlC, new Object[] { cIi() }));
            AppMethodBeat.o(113163);
            return;
          }
          if (this.tte == 3)
          {
            this.tuB.setText(getString(a.g.tlB, new Object[] { cIi() }));
            AppMethodBeat.o(113163);
          }
        }
        else
        {
          cIB();
        }
        AppMethodBeat.o(113163);
        return;
      }
      cIB();
    }
  }
  
  public int getLayoutId()
  {
    return a.e.taW;
  }
  
  public void initView()
  {
    AppMethodBeat.i(113156);
    setMMTitle(a.g.tjw);
    setBackBtn(new CardAcceptCardListUI.1(this));
    this.tuw = findViewById(a.d.taW);
    this.tux = findViewById(a.d.top_layout);
    this.Xg = findViewById(a.d.list_layout);
    this.tux.setVisibility(4);
    this.tmq = ((ListView)findViewById(16908298));
    this.tms = ((RelativeLayout)findViewById(a.d.tfq));
    this.tmq.setEmptyView(this.tms);
    this.tuy = new a(this);
    this.tmq.setAdapter(this.tuy);
    this.tmq.setOnItemClickListener(new CardAcceptCardListUI.2(this));
    this.tuz = findViewById(a.d.taZ);
    this.tsX = ((Button)findViewById(a.d.duV));
    this.tsX.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(113151);
        Object localObject = new b();
        ((b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/card/ui/CardAcceptCardListUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
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
          paramAnonymousView.lG(true);
          paramAnonymousView = new p((LinkedList)localObject, paramAnonymousView.fUN, paramAnonymousView.tuF, paramAnonymousView.tuG, paramAnonymousView.tuE);
          com.tencent.mm.kernel.h.aHF().kcd.a(paramAnonymousView, 0);
        }
      }
    });
    this.tsX.setEnabled(false);
    this.tuA = findViewById(a.d.tdi);
    this.tuB = ((TextView)findViewById(a.d.tdj));
    this.tuC = ((Button)findViewById(a.d.tdh));
    this.tuC.setOnClickListener(new CardAcceptCardListUI.4(this));
    Object localObject2 = getIntent();
    if (localObject2 == null)
    {
      Log.e("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI initView () intent == null");
      HR(2);
      AppMethodBeat.o(113156);
      return;
    }
    Log.i("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI handle data");
    Object localObject3 = ((Intent)localObject2).getStringExtra("key_in_card_list");
    this.fUN = ((Intent)localObject2).getIntExtra("key_from_scene", 8);
    Object localObject1 = ((Intent)localObject2).getStringExtra("key_package_name");
    localObject2 = ((Intent)localObject2).getStringExtra("key_sign");
    this.tuE = getIntent().getIntExtra("key_stastic_scene", 7);
    this.tuF = getIntent().getStringExtra("src_username");
    this.tuG = getIntent().getStringExtra("js_url");
    this.tuH = getIntent().getStringExtra("key_consumed_card_id");
    this.lnb = getIntent().getStringExtra("key_template_id");
    localObject3 = com.tencent.mm.plugin.card.d.h.dl((String)localObject3, this.fUN);
    if ((localObject3 == null) || (((List)localObject3).size() == 0))
    {
      Log.e("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI initView () tempList == null || tempList.size() == 0");
      HR(2);
      AppMethodBeat.o(113156);
      return;
    }
    this.tuD.clear();
    this.tuD.addAll((Collection)localObject3);
    this.tuI.clear();
    this.tuJ.clear();
    this.tuq.clear();
    localObject3 = this.tuD;
    lG(true);
    localObject1 = new ab((LinkedList)localObject3, this.fUN, (String)localObject1, (String)localObject2, this.tuF, this.tuG, this.tuH, this.tuE);
    com.tencent.mm.kernel.h.aHF().kcd.a((q)localObject1, 0);
    AppMethodBeat.o(113156);
  }
  
  final void lG(boolean paramBoolean)
  {
    AppMethodBeat.i(113159);
    if (paramBoolean)
    {
      this.jhZ = s.a(this, getString(a.g.loading_tips), false, 0, null);
      AppMethodBeat.o(113159);
      return;
    }
    if ((this.jhZ != null) && (this.jhZ.isShowing()))
    {
      this.jhZ.dismiss();
      this.jhZ = null;
    }
    AppMethodBeat.o(113159);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(113157);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.h.aHF().kcd.a(1079, this);
    com.tencent.mm.kernel.h.aHF().kcd.a(1049, this);
    com.tencent.mm.kernel.h.aHF().kcd.a(902, this);
    initView();
    AppMethodBeat.o(113157);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113158);
    com.tencent.mm.kernel.h.aHF().kcd.b(1079, this);
    com.tencent.mm.kernel.h.aHF().kcd.b(1049, this);
    com.tencent.mm.kernel.h.aHF().kcd.b(902, this);
    this.tuD.clear();
    a locala = this.tuy;
    locala.tup.clear();
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
      HR(1);
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(113161);
    return bool;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(113160);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      Object localObject1;
      if ((paramq instanceof ab))
      {
        lG(false);
        paramString = (ab)paramq;
        paramq = paramString.tpZ;
        this.tqk = paramString.tqk;
        this.tql = paramString.tql;
        this.tqm = paramString.tqm;
        this.tqn = paramString.tqn;
        Log.i("MicroMsg.CardAcceptCardListUI", "accept_button_status: " + this.tqk + "  accept_button_wording: " + this.tql);
        Log.i("MicroMsg.CardAcceptCardListUI", "private_status: " + this.tqm + "  private_wording: " + this.tqn);
        paramString = f.arK(paramq);
        paramq = cP(paramString);
        Object localObject2;
        if ((paramString != null) && (paramString.size() > 0))
        {
          Log.i("MicroMsg.CardAcceptCardListUI", "The card info list size is " + paramString.size());
          if ((paramq != null) && (paramq.size() > 0))
          {
            localObject1 = this.tuy;
            localObject2 = this.tuq;
            if (paramq != null)
            {
              ((a)localObject1).tup.clear();
              ((a)localObject1).tup.addAll(paramq);
              ((a)localObject1).tuq.putAll((Map)localObject2);
            }
          }
          this.tuy.notifyDataSetChanged();
          if (((CardInfo)paramString.get(0)).cFX()) {
            this.tog = true;
          }
          this.tux.setVisibility(0);
          if (this.tuy.getCount() <= 0) {
            break label861;
          }
          paramString = this.tuy.HQ(0);
          n.a(this, paramString);
          this.tuw.setBackgroundColor(l.arR(paramString.cGs().lmL));
          this.tuz.setVisibility(0);
          paramq = new StateListDrawable();
          paramInt1 = getResources().getDimensionPixelOffset(a.b.sZS);
          if (this.tqk != 1) {
            break label699;
          }
          this.tsX.setEnabled(true);
          localObject1 = l.fF(l.arR(paramString.cGs().lmL), paramInt1);
          localObject2 = l.fF(l.convertStringToRGB(paramString.cGs().lmL, 175), paramInt1);
          paramq.addState(new int[] { 16842919 }, (Drawable)localObject2);
          paramq.addState(new int[0], (Drawable)localObject1);
        }
        for (;;)
        {
          this.tsX.setBackgroundDrawable(paramq);
          if (!TextUtils.isEmpty(this.tql)) {
            this.tsX.setText(this.tql);
          }
          if (this.tqm != 1) {
            break label756;
          }
          paramInt1 = getResources().getDimensionPixelOffset(a.b.NormalPadding);
          paramq = l.e(this, getResources().getColor(a.a.white), paramInt1);
          localObject1 = l.fF(getResources().getColor(a.a.white), paramInt1);
          localObject2 = new StateListDrawable();
          ((StateListDrawable)localObject2).addState(new int[] { 16842919 }, (Drawable)localObject1);
          ((StateListDrawable)localObject2).addState(new int[0], paramq);
          this.tuC.setBackgroundDrawable((Drawable)localObject2);
          paramInt1 = l.arR(paramString.cGs().lmL);
          paramInt2 = getResources().getColor(a.a.white);
          paramString = new int[0];
          paramString = new ColorStateList(new int[][] { { 16842919, 16842910 }, paramString }, new int[] { paramInt1, paramInt2 });
          this.tuC.setTextColor(paramString);
          this.tuA.setVisibility(0);
          if (TextUtils.isEmpty(this.tqn)) {
            break label739;
          }
          this.tuB.setText(this.tqn);
          AppMethodBeat.o(113160);
          return;
          Log.e("MicroMsg.CardAcceptCardListUI", "The card info list size is 0!");
          break;
          label699:
          this.tsX.setEnabled(false);
          localObject1 = l.fF(l.convertStringToRGB(paramString.cGs().lmL, 175), paramInt1);
          paramq.addState(new int[0], (Drawable)localObject1);
        }
        label739:
        this.tuB.setText(a.g.tlA);
        AppMethodBeat.o(113160);
        return;
        label756:
        this.tuA.setVisibility(8);
        paramString = (RelativeLayout.LayoutParams)this.tux.getLayoutParams();
        paramString.topMargin = getResources().getDimensionPixelSize(a.b.SmallPadding);
        paramString.bottomMargin = getResources().getDimensionPixelSize(a.b.LargestPadding);
        this.tux.setLayoutParams(paramString);
        this.tux.invalidate();
        paramString = (RelativeLayout.LayoutParams)this.tuz.getLayoutParams();
        paramString.addRule(8, a.d.list_layout);
        this.tuz.setLayoutParams(paramString);
        this.tuz.invalidate();
        AppMethodBeat.o(113160);
        return;
        label861:
        this.tuz.setVisibility(8);
        this.tuA.setVisibility(8);
        this.tuw.setBackgroundColor(getResources().getColor(a.a.sZs));
        AppMethodBeat.o(113160);
        return;
      }
      if ((paramq instanceof p))
      {
        lG(false);
        localObject1 = (p)paramq;
        if (((p)localObject1).tqa != 0)
        {
          paramq = ((p)localObject1).tqb;
          paramString = paramq;
          if (TextUtils.isEmpty(paramq)) {
            paramString = getString(a.g.tjJ);
          }
          com.tencent.mm.ui.base.h.a(this, paramString, null, false, new CardAcceptCardListUI.5(this));
          this.tqj = ((p)localObject1).tpZ;
          AppMethodBeat.o(113160);
          return;
        }
        com.tencent.mm.ui.base.h.cO(this, getResources().getString(a.g.tko));
        paramString = new Intent();
        paramString.putExtra("card_list", ((p)localObject1).tpZ);
        setResult(-1, paramString);
        Log.i("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI setResult RESULT_OK for card");
        l.cLg();
        finish();
        AppMethodBeat.o(113160);
        return;
      }
      if ((paramq instanceof g))
      {
        lG(false);
        paramString = ((g)paramq).tpZ;
        paramInt1 = ((g)paramq).tqa;
        paramq = ((g)paramq).tqb;
        this.tqj = paramString;
        if (paramInt1 != 0)
        {
          paramString = paramq;
          if (TextUtils.isEmpty(paramq)) {
            paramString = getString(a.g.tlJ);
          }
          com.tencent.mm.ui.base.h.a(this, paramString, null, false, new CardAcceptCardListUI.6(this));
          AppMethodBeat.o(113160);
          return;
        }
        com.tencent.mm.ui.base.h.cO(this, getResources().getString(a.g.tjB));
        paramq = new Intent();
        paramq.putExtra("card_list", this.tqj);
        setResult(-1, paramq);
        Log.i("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI setResult RESULT_OK for sharecard");
        l.cLi();
        paramq = new ShareCardInfo();
        f.a(paramq, paramString);
        l.a(paramq);
        am.cHz().onChange();
        finish();
        AppMethodBeat.o(113160);
      }
    }
    else
    {
      Log.e("MicroMsg.CardAcceptCardListUI", "CardAddEntranceUI onSceneEnd() netsene type" + paramq.getType() + "errType = " + paramInt1 + " errCode = " + paramInt2);
      lG(false);
      d.b(this, paramString, paramInt2);
      if ((paramq instanceof p))
      {
        this.tqj = paramString;
        AppMethodBeat.o(113160);
        return;
      }
      if ((paramq instanceof g)) {
        this.tqj = "";
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