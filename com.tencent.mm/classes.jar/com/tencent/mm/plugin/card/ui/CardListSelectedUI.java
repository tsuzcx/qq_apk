package com.tencent.mm.plugin.card.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.c;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelbiz.ChooseCardFromWXCardPackage.Resp;
import com.tencent.mm.plugin.card.a.b;
import com.tencent.mm.plugin.card.a.c;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.b.j;
import com.tencent.mm.plugin.card.b.j.a;
import com.tencent.mm.plugin.card.b.j.b;
import com.tencent.mm.plugin.card.d.d;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.model.aj;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public class CardListSelectedUI
  extends MMActivity
  implements i, j.a
{
  private View Xd;
  private String app_id;
  LinkedList<com.tencent.mm.plugin.card.model.a> jQK;
  private int jaR;
  private s jhZ;
  boolean kSa;
  private ListView mListView;
  private int time_stamp;
  private String tnX;
  com.tencent.mm.cd.b tqA;
  private boolean ttF;
  private BaseAdapter ttU;
  private String tuO;
  private String tuP;
  private TextView tyA;
  boolean tyB;
  HashMap<Integer, Boolean> tyC;
  private boolean tyD;
  private boolean tyE;
  private boolean tyF;
  private int tyG;
  private String tyH;
  private String tyI;
  private String tyJ;
  private String tyK;
  private int tyL;
  public String tyM;
  private boolean tyN;
  private com.tencent.mm.plugin.card.model.a tyO;
  private TextView tyx;
  private RelativeLayout tyy;
  private TextView tyz;
  
  public CardListSelectedUI()
  {
    AppMethodBeat.i(113496);
    this.jhZ = null;
    this.tyB = false;
    this.jQK = new LinkedList();
    this.tyC = new HashMap();
    this.kSa = true;
    this.tqA = null;
    this.ttF = false;
    this.tuO = "";
    this.tyN = false;
    this.jaR = 0;
    AppMethodBeat.o(113496);
  }
  
  private void aM(int paramInt, String paramString)
  {
    AppMethodBeat.i(113509);
    if (this.jaR != 8)
    {
      Log.e("MicroMsg.CardListSelectedUI", "setResultToSDK need MM_CARD_ITEM_FROM_SCENE_OPENAPI scene, the fromscene is " + this.jaR);
      AppMethodBeat.o(113509);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("_wxapi_choose_card_from_wx_card_list", paramString);
    Object localObject = com.tencent.mm.pluginsdk.model.app.h.o(this.app_id, true, false);
    ChooseCardFromWXCardPackage.Resp localResp = new ChooseCardFromWXCardPackage.Resp(localBundle);
    if (localObject != null) {
      localResp.openId = ((g)localObject).field_openId;
    }
    localResp.transaction = this.tuP;
    String str2 = this.app_id;
    String str1;
    if (localObject == null)
    {
      str1 = "null appinfo";
      if (localObject != null) {
        break label263;
      }
      localObject = "null appinfo";
      label130:
      Log.i("MicroMsg.CardListSelectedUI", "setResultToSDK, appid : %s, appname : %s, openid : %s, transcation : %s", new Object[] { str2, str1, localObject, this.tuP });
      localResp.toBundle(localBundle);
      Log.i("MicroMsg.CardListSelectedUI", "setResultToSDK result:".concat(String.valueOf(paramInt)));
      Log.d("MicroMsg.CardListSelectedUI", "setResultToSDK card_list:".concat(String.valueOf(paramString)));
      if (paramInt != -1) {
        break label273;
      }
    }
    label263:
    label273:
    for (localResp.errCode = 0;; localResp.errCode = -2)
    {
      paramString = new MMessageActV2.Args();
      paramString.targetPkgName = this.tuO;
      paramString.bundle = localBundle;
      com.tencent.mm.pluginsdk.model.app.q.bm(localBundle);
      com.tencent.mm.pluginsdk.model.app.q.bn(localBundle);
      MMessageActV2.send(MMApplicationContext.getContext(), paramString);
      AppMethodBeat.o(113509);
      return;
      str1 = ((g)localObject).field_appName;
      break;
      localObject = ((g)localObject).field_openId;
      break label130;
    }
  }
  
  private static String arw(String paramString)
  {
    AppMethodBeat.i(113501);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(113501);
      return null;
    }
    try
    {
      paramString = new JSONObject(paramString).optString("rule_url");
      AppMethodBeat.o(113501);
      return paramString;
    }
    catch (JSONException paramString)
    {
      Log.printErrStackTrace("MicroMsg.CardListSelectedUI", paramString, "", new Object[0]);
      AppMethodBeat.o(113501);
    }
    return null;
  }
  
  private void cIP()
  {
    AppMethodBeat.i(113506);
    Intent localIntent = new Intent();
    String str = cJG();
    if (this.tyN) {
      localIntent.putExtra("choose_invoice_info", str);
    }
    for (;;)
    {
      setResult(-1, localIntent);
      aM(-1, str);
      finish();
      AppMethodBeat.o(113506);
      return;
      localIntent.putExtra("choose_card_info", str);
    }
  }
  
  private void cJF()
  {
    AppMethodBeat.i(113498);
    if (this.ttF)
    {
      Log.e("MicroMsg.CardListSelectedUI", "doNetSceneGetShareCardsLayout, isDoingGetData is true");
      AppMethodBeat.o(113498);
      return;
    }
    if (this.tqA == null)
    {
      this.tyD = false;
      this.tyE = false;
      this.tyF = false;
    }
    com.tencent.mm.kernel.h.aHF().kcd.a(1059, this);
    aj localaj = new aj(this.app_id, this.tyG, this.tyH, this.tyI, this.time_stamp, this.tyJ, this.tnX, this.tyK, this.tqA);
    com.tencent.mm.kernel.h.aHF().kcd.a(localaj, 0);
    lG(true);
    this.ttF = true;
    if (this.tyL == 1) {
      this.tyB = true;
    }
    AppMethodBeat.o(113498);
  }
  
  private String cJG()
  {
    int j = 0;
    AppMethodBeat.i(113507);
    Object localObject1 = new ArrayList();
    int i = 0;
    while (i < this.jQK.size())
    {
      localObject2 = (Boolean)this.tyC.get(Integer.valueOf(i));
      if ((localObject2 != null) && (((Boolean)localObject2).booleanValue())) {
        ((ArrayList)localObject1).add(this.jQK.get(i));
      }
      i += 1;
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[");
    i = j;
    while (i < ((ArrayList)localObject1).size())
    {
      if (i != 0) {
        ((StringBuilder)localObject2).append(",");
      }
      com.tencent.mm.plugin.card.model.a locala = (com.tencent.mm.plugin.card.model.a)((ArrayList)localObject1).get(i);
      ((StringBuilder)localObject2).append("{");
      ((StringBuilder)localObject2).append("\"card_id\":");
      ((StringBuilder)localObject2).append("\"" + locala.tnX + "\"");
      ((StringBuilder)localObject2).append(",");
      ((StringBuilder)localObject2).append("\"encrypt_code\":");
      ((StringBuilder)localObject2).append("\"" + locala.toa + "\"");
      if (this.tyN)
      {
        ((StringBuilder)localObject2).append(",");
        ((StringBuilder)localObject2).append("\"app_id\":");
        ((StringBuilder)localObject2).append("\"" + locala.app_id + "\"");
      }
      ((StringBuilder)localObject2).append("}");
      i += 1;
    }
    ((StringBuilder)localObject2).append("]");
    localObject1 = ((StringBuilder)localObject2).toString();
    AppMethodBeat.o(113507);
    return localObject1;
  }
  
  public final void aqS(String paramString) {}
  
  public final void b(String paramString, j.b paramb)
  {
    int j = 0;
    AppMethodBeat.i(113502);
    lG(false);
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals(this.tyO.tob)))
    {
      Log.e("MicroMsg.CardListSelectedUI", "onMarkSuccess(), the mark card id is diff from current id!");
      AppMethodBeat.o(113502);
      return;
    }
    Log.i("MicroMsg.CardListSelectedUI", "onMarkSuccess()");
    Log.i("MicroMsg.CardListSelectedUI", "markSucc:" + paramb.tnL + " markCardId: " + paramb.tnM);
    if (paramb.tnL == 1)
    {
      int i;
      if ((!TextUtils.isEmpty(paramb.tnM)) && (!paramString.equals(paramb.tnM)))
      {
        Log.i("MicroMsg.CardListSelectedUI", "markCardId is diff as now id!");
        i = 0;
        if (i < this.jQK.size())
        {
          if (((com.tencent.mm.plugin.card.model.a)this.jQK.get(i)).tob != paramb.tnM) {
            break label230;
          }
          while (j < this.jQK.size())
          {
            this.tyC.put(Integer.valueOf(j), Boolean.FALSE);
            j += 1;
          }
          this.tyC.put(Integer.valueOf(i), Boolean.TRUE);
        }
      }
      for (;;)
      {
        cIP();
        AppMethodBeat.o(113502);
        return;
        label230:
        i += 1;
        break;
        Log.i("MicroMsg.CardListSelectedUI", "markCardId is same as now id!");
      }
    }
    d.c(this, getString(a.g.tkU));
    AppMethodBeat.o(113502);
  }
  
  public final void fE(String paramString1, String paramString2)
  {
    AppMethodBeat.i(113503);
    lG(false);
    if ((!TextUtils.isEmpty(paramString1)) && (!paramString1.equals(this.tyO.tob)))
    {
      Log.e("MicroMsg.CardListSelectedUI", "onMarkFail(), the mark card id is diff from current id!");
      AppMethodBeat.o(113503);
      return;
    }
    Log.i("MicroMsg.CardListSelectedUI", "onMarkFail()");
    paramString1 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramString1 = getString(a.g.tkT);
    }
    d.c(this, paramString1);
    AppMethodBeat.o(113503);
  }
  
  public int getLayoutId()
  {
    return a.e.tiS;
  }
  
  public void initView()
  {
    AppMethodBeat.i(113499);
    if (this.tyN)
    {
      setMMTitle(a.g.tkO);
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(113482);
          CardListSelectedUI.this.setResult(0);
          CardListSelectedUI.a(CardListSelectedUI.this, "");
          CardListSelectedUI.this.finish();
          AppMethodBeat.o(113482);
          return true;
        }
      });
      if (!this.tyN)
      {
        addTextOptionMenu(0, getString(a.g.app_finish), new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(113483);
            if ((!CardListSelectedUI.this.tyB) && (CardListSelectedUI.b(CardListSelectedUI.this).tog))
            {
              CardListSelectedUI.this.lG(true);
              am.cHE().X(CardListSelectedUI.b(CardListSelectedUI.this).tob, l.arX(CardListSelectedUI.b(CardListSelectedUI.this).userName), 3);
            }
            for (;;)
            {
              AppMethodBeat.o(113483);
              return true;
              CardListSelectedUI.a(CardListSelectedUI.this);
            }
          }
        });
        enableOptionMenu(false);
      }
      this.mListView = ((ListView)findViewById(a.d.tcE));
      if (!this.tyN) {
        break label288;
      }
    }
    label288:
    for (this.ttU = new b();; this.ttU = new a())
    {
      this.mListView.setAdapter(this.ttU);
      this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          int i = 0;
          AppMethodBeat.i(113484);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousAdapterView);
          localb.bn(paramAnonymousView);
          localb.sg(paramAnonymousInt);
          localb.Fs(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/card/ui/CardListSelectedUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
          if (paramAnonymousView.getAlpha() != 1.0F)
          {
            Log.d("MicroMsg.CardListSelectedUI", "item view is gray, cannot click, do nothing return！");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardListSelectedUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(113484);
            return;
          }
          boolean bool;
          if (CardListSelectedUI.this.tyB)
          {
            bool = ((Boolean)CardListSelectedUI.this.tyC.get(Integer.valueOf(paramAnonymousInt))).booleanValue();
            paramAnonymousAdapterView = CardListSelectedUI.this.tyC;
            if (!bool)
            {
              bool = true;
              paramAnonymousAdapterView.put(Integer.valueOf(paramAnonymousInt), Boolean.valueOf(bool));
            }
          }
          for (;;)
          {
            CardListSelectedUI.c(CardListSelectedUI.this).notifyDataSetChanged();
            CardListSelectedUI.d(CardListSelectedUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardListSelectedUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(113484);
            return;
            bool = false;
            break;
            while (i < CardListSelectedUI.this.jQK.size())
            {
              CardListSelectedUI.this.tyC.put(Integer.valueOf(i), Boolean.FALSE);
              i += 1;
            }
            CardListSelectedUI.this.tyC.put(Integer.valueOf(paramAnonymousInt), Boolean.TRUE);
            CardListSelectedUI.a(CardListSelectedUI.this, (com.tencent.mm.plugin.card.model.a)CardListSelectedUI.this.jQK.get(paramAnonymousInt));
          }
        }
      });
      this.mListView.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(113485);
          if ((paramAnonymousAbsListView.getLastVisiblePosition() == paramAnonymousAbsListView.getCount() - 1) && (!CardListSelectedUI.this.kSa))
          {
            Log.d("MicroMsg.CardListSelectedUI", "onScroll() >> doGetCardList()");
            CardListSelectedUI.e(CardListSelectedUI.this);
          }
          AppMethodBeat.o(113485);
        }
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {}
      });
      this.Xd = findViewById(a.d.tfq);
      this.tyx = ((TextView)findViewById(a.d.tgk));
      if (this.tyN) {
        this.tyx.setText(getString(a.g.tlq));
      }
      this.tyy = ((RelativeLayout)findViewById(a.d.tfQ));
      this.tyz = ((TextView)findViewById(a.d.tfU));
      this.tyA = ((TextView)findViewById(a.d.tfT));
      if (!this.tyN) {
        break label303;
      }
      this.tyy.setVisibility(0);
      this.tyz.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(113486);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/card/ui/CardListSelectedUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (!Util.isNullOrNil(CardListSelectedUI.this.tyM)) {
            com.tencent.mm.plugin.card.d.b.a(CardListSelectedUI.this, CardListSelectedUI.this.tyM, CardListSelectedUI.this.getString(a.g.tkI));
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardListSelectedUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(113486);
        }
      });
      this.tyA.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(113487);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/card/ui/CardListSelectedUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          CardListSelectedUI.a(CardListSelectedUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardListSelectedUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(113487);
        }
      });
      AppMethodBeat.o(113499);
      return;
      setMMTitle(a.g.tkN);
      break;
    }
    label303:
    this.tyy.setVisibility(8);
    AppMethodBeat.o(113499);
  }
  
  protected final void lG(boolean paramBoolean)
  {
    AppMethodBeat.i(113505);
    if (paramBoolean)
    {
      this.jhZ = s.a(this, getString(a.g.loading_tips), false, 0, null);
      AppMethodBeat.o(113505);
      return;
    }
    if ((this.jhZ != null) && (this.jhZ.isShowing()))
    {
      this.jhZ.dismiss();
      this.jhZ = null;
    }
    AppMethodBeat.o(113505);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(113497);
    super.onCreate(paramBundle);
    am.cHE().a(this);
    paramBundle = getIntent();
    Log.i("MicroMsg.CardListSelectedUI", "initData()");
    if (paramBundle == null)
    {
      Log.e("MicroMsg.CardListSelectedUI", "doGetCardList()  intent == null");
      setResult(1);
      aM(1, "");
      finish();
    }
    for (;;)
    {
      cJF();
      initView();
      AppMethodBeat.o(113497);
      return;
      this.jaR = paramBundle.getIntExtra("key_from_scene", 0);
      Log.i("MicroMsg.CardListSelectedUI", "mFromScene:" + this.jaR);
      this.app_id = paramBundle.getStringExtra("app_id");
      this.tyG = paramBundle.getIntExtra("shop_id", 0);
      this.tyH = paramBundle.getStringExtra("sign_type");
      this.tyI = paramBundle.getStringExtra("card_sign");
      this.time_stamp = paramBundle.getIntExtra("time_stamp", 0);
      this.tyJ = paramBundle.getStringExtra("nonce_str");
      this.tnX = paramBundle.getStringExtra("card_tp_id");
      this.tyK = paramBundle.getStringExtra("card_type");
      this.tyL = paramBundle.getIntExtra("can_multi_select", 0);
      this.tuO = paramBundle.getStringExtra("key_package_name");
      this.tuP = paramBundle.getStringExtra("key_transaction");
      Log.i("MicroMsg.CardListSelectedUI", "app_id:" + this.app_id + " shop_id:" + this.tyG + " sign_type:" + this.tyH + " time_stamp:" + this.time_stamp);
      Log.i("MicroMsg.CardListSelectedUI", "nonce_str:" + this.tyJ + " card_tp_id:" + this.tnX + " card_type:" + this.tyK + " canMultiSelect:" + this.tyL + " packateName:" + this.tuO);
      if ("INVOICE".equalsIgnoreCase(this.tyK)) {
        this.tyN = true;
      }
      if (TextUtils.isEmpty(this.app_id))
      {
        Log.e("MicroMsg.CardListSelectedUI", "doGetCardList()  app_id is nulls");
        setResult(1);
        aM(1, "app_id  or card_sign is empty!");
        finish();
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113504);
    am.cHE().b(this);
    super.onDestroy();
    AppMethodBeat.o(113504);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(113508);
    if (paramInt == 4)
    {
      setResult(0);
      aM(0, "");
      finish();
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(113508);
    return bool;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(113500);
    if ((paramq instanceof aj))
    {
      com.tencent.mm.kernel.h.aHF().kcd.b(1059, this);
      lG(false);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label395;
      }
      paramString = ((aj)paramq).tpZ;
      Log.d("MicroMsg.CardListSelectedUI", paramString);
      LinkedList localLinkedList1 = com.tencent.mm.plugin.card.model.a.aqV(paramString);
      LinkedList localLinkedList2 = com.tencent.mm.plugin.card.model.a.aqW(paramString);
      this.tyM = arw(paramString);
      if ((this.tqA == null) && ((localLinkedList1 != null) || (localLinkedList2 != null)))
      {
        this.tyC.clear();
        this.jQK.clear();
      }
      if (localLinkedList1 != null)
      {
        if ((localLinkedList1.size() > 0) && (!this.tyD))
        {
          this.tyD = true;
          if (!this.tyN) {
            break label208;
          }
        }
        label208:
        for (((com.tencent.mm.plugin.card.model.a)localLinkedList1.get(0)).swW = getString(a.g.tlw);; ((com.tencent.mm.plugin.card.model.a)localLinkedList1.get(0)).swW = getString(a.g.tlv))
        {
          paramInt1 = this.jQK.size();
          this.jQK.addAll(localLinkedList1);
          while (paramInt1 < this.jQK.size())
          {
            this.tyC.put(Integer.valueOf(paramInt1), Boolean.FALSE);
            paramInt1 += 1;
          }
        }
      }
      if (localLinkedList2 != null)
      {
        if ((localLinkedList2.size() > 0) && (!this.tyE))
        {
          this.tyE = true;
          ((com.tencent.mm.plugin.card.model.a)localLinkedList2.get(0)).swW = getString(a.g.thV);
        }
        paramInt1 = this.jQK.size();
        this.jQK.addAll(localLinkedList2);
        while (paramInt1 < this.jQK.size())
        {
          this.tyC.put(Integer.valueOf(paramInt1), Boolean.FALSE);
          paramInt1 += 1;
        }
      }
      this.kSa = ((aj)paramq).kSa;
      this.tqA = ((aj)paramq).tqA;
      this.ttU.notifyDataSetChanged();
      if (this.jQK.size() == 0) {
        break label404;
      }
      this.Xd.setVisibility(8);
      this.mListView.setVisibility(0);
    }
    for (;;)
    {
      this.ttF = false;
      AppMethodBeat.o(113500);
      return;
      label395:
      d.b(this, paramString, paramInt2);
      break;
      label404:
      this.Xd.setVisibility(0);
      this.mListView.setVisibility(8);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends BaseAdapter
  {
    a() {}
    
    private com.tencent.mm.plugin.card.model.a HW(int paramInt)
    {
      AppMethodBeat.i(113489);
      com.tencent.mm.plugin.card.model.a locala = (com.tencent.mm.plugin.card.model.a)CardListSelectedUI.this.jQK.get(paramInt);
      AppMethodBeat.o(113489);
      return locala;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(113488);
      int i = CardListSelectedUI.this.jQK.size();
      AppMethodBeat.o(113488);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(113490);
      Object localObject = HW(paramInt);
      label194:
      label225:
      int i;
      if (paramView == null)
      {
        paramView = View.inflate(CardListSelectedUI.this, a.e.tjd, null);
        paramViewGroup = new CardListSelectedUI.d(CardListSelectedUI.this);
        paramViewGroup.tyW = ((ImageView)paramView.findViewById(a.d.logo));
        paramViewGroup.jMg = ((TextView)paramView.findViewById(a.d.title));
        paramViewGroup.tyS = ((TextView)paramView.findViewById(a.d.sub_title));
        paramViewGroup.tyX = ((TextView)paramView.findViewById(a.d.taJ));
        paramViewGroup.swP = ((TextView)paramView.findViewById(a.d.catalogTV));
        paramViewGroup.tyY = paramView.findViewById(a.d.body_layout);
        paramViewGroup.tyZ = ((ImageView)paramView.findViewById(a.d.tdt));
        paramView.setTag(paramViewGroup);
        if (!l.HH(((com.tencent.mm.plugin.card.model.a)localObject).qJt)) {
          break label400;
        }
        paramViewGroup.jMg.setText(((com.tencent.mm.plugin.card.model.a)localObject).tnY);
        if (TextUtils.isEmpty(((com.tencent.mm.plugin.card.model.a)localObject).title)) {
          break label357;
        }
        paramViewGroup.tyS.setVisibility(0);
        paramViewGroup.tyS.setText(((com.tencent.mm.plugin.card.model.a)localObject).title);
        if (TextUtils.isEmpty(((com.tencent.mm.plugin.card.model.a)localObject).tnZ)) {
          break label369;
        }
        paramViewGroup.tyX.setVisibility(0);
        paramViewGroup.tyX.setText(((com.tencent.mm.plugin.card.model.a)localObject).tnZ);
        TextView localTextView = paramViewGroup.swP;
        if (!Util.isNullOrNil(((com.tencent.mm.plugin.card.model.a)localObject).swW)) {
          break label381;
        }
        i = 8;
        label246:
        localTextView.setVisibility(i);
        paramViewGroup.swP.setText(((com.tencent.mm.plugin.card.model.a)localObject).swW);
        i = CardListSelectedUI.this.getBaseContext().getResources().getDimensionPixelSize(a.b.sZZ);
        CardListSelectedUI.a(paramViewGroup.tyW, ((com.tencent.mm.plugin.card.model.a)localObject).llI, i);
        localObject = (Boolean)CardListSelectedUI.this.tyC.get(Integer.valueOf(paramInt));
        if ((localObject == null) || (!((Boolean)localObject).booleanValue())) {
          break label387;
        }
        paramViewGroup.tyZ.setImageResource(a.c.tab);
      }
      for (;;)
      {
        AppMethodBeat.o(113490);
        return paramView;
        paramViewGroup = (CardListSelectedUI.d)paramView.getTag();
        break;
        label357:
        paramViewGroup.tyS.setVisibility(8);
        break label194;
        label369:
        paramViewGroup.tyX.setVisibility(8);
        break label225;
        label381:
        i = 0;
        break label246;
        label387:
        paramViewGroup.tyZ.setImageResource(a.c.tac);
        continue;
        label400:
        Log.i("MicroMsg.CardListSelectedUI", "not support type");
      }
    }
  }
  
  final class b
    extends BaseAdapter
  {
    b() {}
    
    private com.tencent.mm.plugin.card.model.a HW(int paramInt)
    {
      AppMethodBeat.i(113493);
      com.tencent.mm.plugin.card.model.a locala = (com.tencent.mm.plugin.card.model.a)CardListSelectedUI.this.jQK.get(paramInt);
      AppMethodBeat.o(113493);
      return locala;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(113492);
      int i = CardListSelectedUI.this.jQK.size();
      AppMethodBeat.o(113492);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(113494);
      com.tencent.mm.plugin.card.model.a locala = HW(paramInt);
      if (paramView == null)
      {
        paramView = View.inflate(CardListSelectedUI.this, a.e.tjc, null);
        paramViewGroup = new CardListSelectedUI.c(CardListSelectedUI.this);
        paramViewGroup.tyQ = ((ImageView)paramView.findViewById(a.d.tdt));
        paramViewGroup.tyR = ((TextView)paramView.findViewById(a.d.tfS));
        paramViewGroup.jMg = ((TextView)paramView.findViewById(a.d.title));
        paramViewGroup.tyS = ((TextView)paramView.findViewById(a.d.sub_title));
        paramViewGroup.tyT = paramView.findViewById(a.d.thF);
        paramViewGroup.tyU = ((TextView)paramView.findViewById(a.d.dJD));
        paramViewGroup.tyV = ((TextView)paramView.findViewById(a.d.tfR));
        paramView.setTag(paramViewGroup);
        if (!l.HH(locala.qJt)) {
          break label559;
        }
        if (TextUtils.isEmpty(locala.title)) {
          break label396;
        }
        paramViewGroup.jMg.setVisibility(0);
        paramViewGroup.jMg.setText(locala.title);
        label182:
        if (TextUtils.isEmpty(locala.tnY)) {
          break label408;
        }
        paramViewGroup.tyS.setVisibility(0);
        paramViewGroup.tyS.setText(locala.tnY);
        label213:
        if (locala.toc != 0) {
          break label433;
        }
        paramView.setAlpha(1.0F);
        paramViewGroup.tyQ.setVisibility(0);
        paramViewGroup.tyR.setVisibility(8);
        Boolean localBoolean = (Boolean)CardListSelectedUI.this.tyC.get(Integer.valueOf(paramInt));
        if ((localBoolean == null) || (!localBoolean.booleanValue())) {
          break label420;
        }
        paramViewGroup.tyQ.setImageResource(a.c.tab);
        label285:
        if (Util.isNullOrNil(locala.tod)) {
          break label524;
        }
        paramViewGroup.tyU.setVisibility(0);
        paramViewGroup.tyU.setText(locala.tod);
        label316:
        if (Util.isNullOrNil(locala.toe)) {
          break label536;
        }
        paramViewGroup.tyV.setVisibility(0);
        paramViewGroup.tyV.setText(locala.toe);
        label347:
        if ((!Util.isNullOrNil(locala.tod)) || (!Util.isNullOrNil(locala.toe))) {
          break label548;
        }
        paramViewGroup.tyT.setVisibility(8);
      }
      for (;;)
      {
        AppMethodBeat.o(113494);
        return paramView;
        paramViewGroup = (CardListSelectedUI.c)paramView.getTag();
        break;
        label396:
        paramViewGroup.jMg.setVisibility(8);
        break label182;
        label408:
        paramViewGroup.tyS.setVisibility(8);
        break label213;
        label420:
        paramViewGroup.tyQ.setImageResource(a.c.tac);
        break label285;
        label433:
        if (locala.toc == 1)
        {
          paramView.setAlpha(0.2F);
          paramViewGroup.tyQ.setVisibility(8);
          if (!Util.isNullOrNil(locala.tof))
          {
            paramViewGroup.tyR.setVisibility(0);
            paramViewGroup.tyR.setText(locala.tof);
            break label285;
          }
          paramViewGroup.tyR.setVisibility(8);
          break label285;
        }
        paramViewGroup.tyQ.setVisibility(8);
        paramViewGroup.tyR.setVisibility(8);
        break label285;
        label524:
        paramViewGroup.tyU.setVisibility(8);
        break label316;
        label536:
        paramViewGroup.tyV.setVisibility(8);
        break label347;
        label548:
        paramViewGroup.tyT.setVisibility(0);
        continue;
        label559:
        Log.i("MicroMsg.CardListSelectedUI", "not support type");
      }
    }
  }
  
  final class c
  {
    public TextView jMg;
    public ImageView tyQ;
    public TextView tyR;
    public TextView tyS;
    public View tyT;
    public TextView tyU;
    public TextView tyV;
    
    c() {}
  }
  
  final class d
  {
    public TextView jMg;
    public TextView swP;
    public TextView tyS;
    public ImageView tyW;
    public TextView tyX;
    public View tyY;
    public ImageView tyZ;
    
    d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardListSelectedUI
 * JD-Core Version:    0.7.0.1
 */