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
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.card.d.d;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.protocal.protobuf.ot;
import com.tencent.mm.protocal.protobuf.pg;
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
  implements com.tencent.mm.ai.f, MMActivity.a
{
  int cHp;
  private com.tencent.mm.ui.base.p ehb;
  private String fhC;
  protected ListView kkF;
  protected RelativeLayout kkH;
  private boolean kmw;
  private String kot;
  private int kou;
  private String kov;
  private int kow;
  private String kox;
  private Button kqX;
  public int kre;
  private String krf;
  private String krg;
  public ArrayList<String> krh;
  public ArrayList<String> kri;
  private View ksA;
  private View ksB;
  private TextView ksC;
  private Button ksD;
  LinkedList<ot> ksE;
  int ksF;
  String ksG;
  String ksH;
  private String ksI;
  LinkedList<ot> ksJ;
  LinkedList<String> ksK;
  HashMap<String, Integer> ksr;
  private View ksx;
  private View ksy;
  protected a ksz;
  private View xB;
  
  public CardAcceptCardListUI()
  {
    AppMethodBeat.i(88221);
    this.kkF = null;
    this.ksz = null;
    this.kkH = null;
    this.ehb = null;
    this.ksE = new LinkedList();
    this.kot = "";
    this.cHp = 8;
    this.ksF = 7;
    this.ksG = "";
    this.ksH = "";
    this.ksI = "";
    this.kmw = false;
    this.kre = 0;
    this.krf = "";
    this.krg = "";
    this.krh = new ArrayList();
    this.kri = new ArrayList();
    this.ksJ = new LinkedList();
    this.ksK = new LinkedList();
    this.ksr = new HashMap();
    this.fhC = "";
    AppMethodBeat.o(88221);
  }
  
  private ArrayList<CardInfo> bc(List<CardInfo> paramList)
  {
    AppMethodBeat.i(88232);
    if ((paramList == null) || (paramList.size() == 0))
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.CardAcceptCardListUI", "geCardInfoListByTpId list is empty!");
      AppMethodBeat.o(88232);
      return null;
    }
    this.ksJ.clear();
    this.ksK.clear();
    this.ksr.clear();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < paramList.size())
    {
      CardInfo localCardInfo = (CardInfo)paramList.get(i);
      if (this.ksK.contains(localCardInfo.field_card_tp_id))
      {
        int j = ((Integer)this.ksr.get(localCardInfo.field_card_tp_id)).intValue();
        this.ksr.put(localCardInfo.field_card_tp_id, Integer.valueOf(j + 1));
      }
      for (;;)
      {
        i += 1;
        break;
        localArrayList.add(localCardInfo);
        this.ksr.put(localCardInfo.field_card_tp_id, Integer.valueOf(1));
        this.ksK.add(localCardInfo.field_card_tp_id);
      }
    }
    AppMethodBeat.o(88232);
    return localArrayList;
  }
  
  private String bcK()
  {
    AppMethodBeat.i(88230);
    String str;
    if ((!TextUtils.isEmpty(this.krf)) && (!TextUtils.isEmpty(this.krg)))
    {
      str = this.krf + "," + l.IE(this.krg);
      AppMethodBeat.o(88230);
      return str;
    }
    if (!TextUtils.isEmpty(this.krf))
    {
      str = this.krf;
      AppMethodBeat.o(88230);
      return str;
    }
    if (!TextUtils.isEmpty(this.krg))
    {
      str = l.IE(this.krg);
      AppMethodBeat.o(88230);
      return str;
    }
    AppMethodBeat.o(88230);
    return "";
  }
  
  private void bde()
  {
    AppMethodBeat.i(88231);
    if (!TextUtils.isEmpty(this.kox))
    {
      this.ksC.setText(this.kox);
      AppMethodBeat.o(88231);
      return;
    }
    this.ksC.setText(2131298038);
    AppMethodBeat.o(88231);
  }
  
  private void th(int paramInt)
  {
    AppMethodBeat.i(88228);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI finishUI() result_code:".concat(String.valueOf(paramInt)));
    Intent localIntent = new Intent();
    localIntent.putExtra("card_list", this.kot);
    localIntent.putExtra("result_code", paramInt);
    setResult(0, localIntent);
    finish();
    AppMethodBeat.o(88228);
  }
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(88229);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(88229);
      return;
      if (paramInt2 != -1)
      {
        AppMethodBeat.o(88229);
        return;
      }
      this.kre = paramIntent.getIntExtra("Ktag_range_index", 0);
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.CardAcceptCardListUI", "mPrivateSelelct : %d", new Object[] { Integer.valueOf(this.kre) });
      if (this.kre >= 2)
      {
        this.krf = paramIntent.getStringExtra("Klabel_name_list");
        this.krg = paramIntent.getStringExtra("Kother_user_name_list");
        com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.CardAcceptCardListUI", "mPrivateSelect : %d, names : %s", new Object[] { Integer.valueOf(this.kre), this.krf });
        if ((TextUtils.isEmpty(this.krf)) && (TextUtils.isEmpty(this.krg)))
        {
          com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.CardAcceptCardListUI", "mLabelNameList by getIntent is empty");
          bde();
          AppMethodBeat.o(88229);
          return;
        }
        paramIntent = Arrays.asList(this.krf.split(","));
        this.kri = l.bi(paramIntent);
        this.krh = l.bh(paramIntent);
        if ((this.krg != null) && (this.krg.length() > 0))
        {
          paramIntent = Arrays.asList(this.krg.split(","));
          this.krh.addAll(paramIntent);
        }
        if (this.kri != null) {
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.CardAcceptCardListUI", "mPrivateIdsList size is " + this.kri.size());
        }
        if (this.krh != null)
        {
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.CardAcceptCardListUI", "mPrivateNamesList size is " + this.krh.size());
          paramIntent = this.krh.iterator();
          while (paramIntent.hasNext()) {
            com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.CardAcceptCardListUI", "username : %s", new Object[] { (String)paramIntent.next() });
          }
        }
        if (!TextUtils.isEmpty(this.krf))
        {
          if (this.kre == 2)
          {
            this.ksC.setText(getString(2131298040, new Object[] { bcK() }));
            AppMethodBeat.o(88229);
            return;
          }
          if (this.kre == 3)
          {
            this.ksC.setText(getString(2131298039, new Object[] { bcK() }));
            AppMethodBeat.o(88229);
          }
        }
        else
        {
          bde();
        }
        AppMethodBeat.o(88229);
        return;
      }
      bde();
    }
  }
  
  final void fV(boolean paramBoolean)
  {
    AppMethodBeat.i(88225);
    if (paramBoolean)
    {
      this.ehb = com.tencent.mm.ui.base.p.b(this, getString(2131301086), false, null);
      AppMethodBeat.o(88225);
      return;
    }
    if ((this.ehb != null) && (this.ehb.isShowing()))
    {
      this.ehb.dismiss();
      this.ehb = null;
    }
    AppMethodBeat.o(88225);
  }
  
  public int getLayoutId()
  {
    return 2130968906;
  }
  
  public void initView()
  {
    AppMethodBeat.i(88222);
    setMMTitle(2131297856);
    setBackBtn(new CardAcceptCardListUI.1(this));
    this.ksx = findViewById(2131821978);
    this.ksy = findViewById(2131821979);
    this.xB = findViewById(2131821980);
    this.ksy.setVisibility(4);
    this.kkF = ((ListView)findViewById(16908298));
    this.kkH = ((RelativeLayout)findViewById(2131821981));
    this.kkF.setEmptyView(this.kkH);
    this.ksz = new a(this);
    this.kkF.setAdapter(this.ksz);
    this.kkF.setOnItemClickListener(new CardAcceptCardListUI.2(this));
    this.ksA = findViewById(2131821983);
    this.kqX = ((Button)findViewById(2131821984));
    this.kqX.setOnClickListener(new CardAcceptCardListUI.3(this));
    this.kqX.setEnabled(false);
    this.ksB = findViewById(2131821985);
    this.ksC = ((TextView)findViewById(2131821986));
    this.ksD = ((Button)findViewById(2131821987));
    this.ksD.setOnClickListener(new CardAcceptCardListUI.4(this));
    Object localObject2 = getIntent();
    if (localObject2 == null)
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI initView () intent == null");
      th(2);
      AppMethodBeat.o(88222);
      return;
    }
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI handle data");
    Object localObject3 = ((Intent)localObject2).getStringExtra("key_in_card_list");
    this.cHp = ((Intent)localObject2).getIntExtra("key_from_scene", 8);
    Object localObject1 = ((Intent)localObject2).getStringExtra("key_package_name");
    localObject2 = ((Intent)localObject2).getStringExtra("key_sign");
    this.ksF = getIntent().getIntExtra("key_stastic_scene", 7);
    this.ksG = getIntent().getStringExtra("src_username");
    this.ksH = getIntent().getStringExtra("js_url");
    this.ksI = getIntent().getStringExtra("key_consumed_card_id");
    this.fhC = getIntent().getStringExtra("key_template_id");
    localObject3 = com.tencent.mm.plugin.card.d.h.bQ((String)localObject3, this.cHp);
    if ((localObject3 == null) || (((List)localObject3).size() == 0))
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI initView () tempList == null || tempList.size() == 0");
      th(2);
      AppMethodBeat.o(88222);
      return;
    }
    this.ksE.clear();
    this.ksE.addAll((Collection)localObject3);
    this.ksJ.clear();
    this.ksK.clear();
    this.ksr.clear();
    localObject3 = this.ksE;
    fV(true);
    localObject1 = new com.tencent.mm.plugin.card.model.ab((LinkedList)localObject3, this.cHp, (String)localObject1, (String)localObject2, this.ksG, this.ksH, this.ksI, this.ksF);
    com.tencent.mm.kernel.g.RK().eHt.a((com.tencent.mm.ai.m)localObject1, 0);
    AppMethodBeat.o(88222);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(88223);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.RK().eHt.a(690, this);
    com.tencent.mm.kernel.g.RK().eHt.a(687, this);
    com.tencent.mm.kernel.g.RK().eHt.a(902, this);
    initView();
    AppMethodBeat.o(88223);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(88224);
    com.tencent.mm.kernel.g.RK().eHt.b(690, this);
    com.tencent.mm.kernel.g.RK().eHt.b(687, this);
    com.tencent.mm.kernel.g.RK().eHt.b(902, this);
    this.ksE.clear();
    a locala = this.ksz;
    locala.krw.clear();
    locala.mContext = null;
    super.onDestroy();
    AppMethodBeat.o(88224);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(88227);
    if (paramInt == 4)
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI onKeyDown() back cancel");
      th(1);
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(88227);
    return bool;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(88226);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      Object localObject1;
      if ((paramm instanceof com.tencent.mm.plugin.card.model.ab))
      {
        fV(false);
        paramString = (com.tencent.mm.plugin.card.model.ab)paramm;
        paramm = paramString.koi;
        this.kou = paramString.kou;
        this.kov = paramString.kov;
        this.kow = paramString.kow;
        this.kox = paramString.kox;
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.CardAcceptCardListUI", "accept_button_status: " + this.kou + "  accept_button_wording: " + this.kov);
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.CardAcceptCardListUI", "private_status: " + this.kow + "  private_wording: " + this.kox);
        paramString = com.tencent.mm.plugin.card.d.f.Iu(paramm);
        paramm = bc(paramString);
        Object localObject2;
        if ((paramString != null) && (paramString.size() > 0))
        {
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.CardAcceptCardListUI", "The card info list size is " + paramString.size());
          if ((paramm != null) && (paramm.size() > 0))
          {
            localObject1 = this.ksz;
            localObject2 = this.ksr;
            if (paramm != null)
            {
              ((a)localObject1).krw.clear();
              ((a)localObject1).krw.addAll(paramm);
              ((a)localObject1).ksr.putAll((Map)localObject2);
            }
          }
          this.ksz.notifyDataSetChanged();
          if (((CardInfo)paramString.get(0)).baK()) {
            this.kmw = true;
          }
          this.ksy.setVisibility(0);
          if (this.ksz.getCount() <= 0) {
            break label859;
          }
          paramString = this.ksz.tg(0);
          com.tencent.mm.plugin.card.d.m.a(this, paramString);
          this.ksx.setBackgroundColor(l.IB(paramString.bbd().color));
          this.ksA.setVisibility(0);
          paramm = new StateListDrawable();
          paramInt1 = getResources().getDimensionPixelOffset(2131428185);
          if (this.kou != 1) {
            break label697;
          }
          this.kqX.setEnabled(true);
          localObject1 = l.dR(l.IB(paramString.bbd().color), paramInt1);
          localObject2 = l.dR(l.bS(paramString.bbd().color, 175), paramInt1);
          paramm.addState(new int[] { 16842919 }, (Drawable)localObject2);
          paramm.addState(new int[0], (Drawable)localObject1);
        }
        for (;;)
        {
          this.kqX.setBackgroundDrawable(paramm);
          if (!TextUtils.isEmpty(this.kov)) {
            this.kqX.setText(this.kov);
          }
          if (this.kow != 1) {
            break label754;
          }
          paramInt1 = getResources().getDimensionPixelOffset(2131427808);
          paramm = l.b(this, getResources().getColor(2131690709), paramInt1);
          localObject1 = l.dR(getResources().getColor(2131690709), paramInt1);
          localObject2 = new StateListDrawable();
          ((StateListDrawable)localObject2).addState(new int[] { 16842919 }, (Drawable)localObject1);
          ((StateListDrawable)localObject2).addState(new int[0], paramm);
          this.ksD.setBackgroundDrawable((Drawable)localObject2);
          paramInt1 = l.IB(paramString.bbd().color);
          paramInt2 = getResources().getColor(2131690709);
          paramString = new ColorStateList(new int[][] { { 16842919, 16842910 }, new int[0] }, new int[] { paramInt1, paramInt2 });
          this.ksD.setTextColor(paramString);
          this.ksB.setVisibility(0);
          if (TextUtils.isEmpty(this.kox)) {
            break label737;
          }
          this.ksC.setText(this.kox);
          AppMethodBeat.o(88226);
          return;
          com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.CardAcceptCardListUI", "The card info list size is 0!");
          break;
          label697:
          this.kqX.setEnabled(false);
          localObject1 = l.dR(l.bS(paramString.bbd().color, 175), paramInt1);
          paramm.addState(new int[0], (Drawable)localObject1);
        }
        label737:
        this.ksC.setText(2131298038);
        AppMethodBeat.o(88226);
        return;
        label754:
        this.ksB.setVisibility(8);
        paramString = (RelativeLayout.LayoutParams)this.ksy.getLayoutParams();
        paramString.topMargin = getResources().getDimensionPixelSize(2131427854);
        paramString.bottomMargin = getResources().getDimensionPixelSize(2131427776);
        this.ksy.setLayoutParams(paramString);
        this.ksy.invalidate();
        paramString = (RelativeLayout.LayoutParams)this.ksA.getLayoutParams();
        paramString.addRule(8, 2131821980);
        this.ksA.setLayoutParams(paramString);
        this.ksA.invalidate();
        AppMethodBeat.o(88226);
        return;
        label859:
        this.ksA.setVisibility(8);
        this.ksB.setVisibility(8);
        this.ksx.setBackgroundColor(getResources().getColor(2131689824));
        AppMethodBeat.o(88226);
        return;
      }
      if ((paramm instanceof com.tencent.mm.plugin.card.model.p))
      {
        fV(false);
        localObject1 = (com.tencent.mm.plugin.card.model.p)paramm;
        if (((com.tencent.mm.plugin.card.model.p)localObject1).koj != 0)
        {
          paramm = ((com.tencent.mm.plugin.card.model.p)localObject1).kok;
          paramString = paramm;
          if (TextUtils.isEmpty(paramm)) {
            paramString = getString(2131297871);
          }
          com.tencent.mm.ui.base.h.a(this, paramString, null, false, new CardAcceptCardListUI.5(this));
          this.kot = ((com.tencent.mm.plugin.card.model.p)localObject1).koi;
          AppMethodBeat.o(88226);
          return;
        }
        com.tencent.mm.ui.base.h.bO(this, getResources().getString(2131297940));
        paramString = new Intent();
        paramString.putExtra("card_list", ((com.tencent.mm.plugin.card.model.p)localObject1).koi);
        setResult(-1, paramString);
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI setResult RESULT_OK for card");
        l.bfz();
        finish();
        AppMethodBeat.o(88226);
        return;
      }
      if ((paramm instanceof com.tencent.mm.plugin.card.sharecard.model.g))
      {
        fV(false);
        paramString = ((com.tencent.mm.plugin.card.sharecard.model.g)paramm).koi;
        paramInt1 = ((com.tencent.mm.plugin.card.sharecard.model.g)paramm).koj;
        paramm = ((com.tencent.mm.plugin.card.sharecard.model.g)paramm).kok;
        this.kot = paramString;
        if (paramInt1 != 0)
        {
          paramString = paramm;
          if (TextUtils.isEmpty(paramm)) {
            paramString = getString(2131298049);
          }
          com.tencent.mm.ui.base.h.a(this, paramString, null, false, new CardAcceptCardListUI.6(this));
          AppMethodBeat.o(88226);
          return;
        }
        com.tencent.mm.ui.base.h.bO(this, getResources().getString(2131297862));
        paramm = new Intent();
        paramm.putExtra("card_list", this.kot);
        setResult(-1, paramm);
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI setResult RESULT_OK for sharecard");
        l.bfB();
        paramm = new ShareCardInfo();
        com.tencent.mm.plugin.card.d.f.a(paramm, paramString);
        l.a(paramm);
        am.bck().onChange();
        finish();
        AppMethodBeat.o(88226);
      }
    }
    else
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.CardAcceptCardListUI", "CardAddEntranceUI onSceneEnd() netsene type" + paramm.getType() + "errType = " + paramInt1 + " errCode = " + paramInt2);
      fV(false);
      d.b(this, paramString, paramInt2);
      if ((paramm instanceof com.tencent.mm.plugin.card.model.p))
      {
        this.kot = paramString;
        AppMethodBeat.o(88226);
        return;
      }
      if ((paramm instanceof com.tencent.mm.plugin.card.sharecard.model.g)) {
        this.kot = "";
      }
    }
    AppMethodBeat.o(88226);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardAcceptCardListUI
 * JD-Core Version:    0.7.0.1
 */