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
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelbiz.ChooseCardFromWXCardPackage.Resp;
import com.tencent.mm.plugin.card.b.j;
import com.tencent.mm.plugin.card.b.j.a;
import com.tencent.mm.plugin.card.b.j.b;
import com.tencent.mm.plugin.card.d.d;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.model.aj;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public class CardListSelectedUI
  extends MMActivity
  implements f, j.a
{
  private View GG;
  private String app_id;
  private int fRv;
  private p fSP;
  LinkedList<com.tencent.mm.plugin.card.model.a> gti;
  boolean hkx;
  private ListView mListView;
  private String oEo;
  com.tencent.mm.bw.b oGT;
  private boolean oJV;
  private BaseAdapter oKk;
  private String oLe;
  private String oLf;
  private TextView oOM;
  private RelativeLayout oON;
  private TextView oOO;
  private TextView oOP;
  boolean oOQ;
  HashMap<Integer, Boolean> oOR;
  private boolean oOS;
  private boolean oOT;
  private boolean oOU;
  private int oOV;
  private String oOW;
  private String oOX;
  private String oOY;
  private String oOZ;
  private int oPa;
  public String oPb;
  private boolean oPc;
  private com.tencent.mm.plugin.card.model.a oPd;
  private int time_stamp;
  
  public CardListSelectedUI()
  {
    AppMethodBeat.i(113496);
    this.fSP = null;
    this.oOQ = false;
    this.gti = new LinkedList();
    this.oOR = new HashMap();
    this.hkx = true;
    this.oGT = null;
    this.oJV = false;
    this.oLe = "";
    this.oPc = false;
    this.fRv = 0;
    AppMethodBeat.o(113496);
  }
  
  private static String ZE(String paramString)
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
      ae.printErrStackTrace("MicroMsg.CardListSelectedUI", paramString, "", new Object[0]);
      AppMethodBeat.o(113501);
    }
    return null;
  }
  
  private void aI(int paramInt, String paramString)
  {
    AppMethodBeat.i(113509);
    if (this.fRv != 8)
    {
      ae.e("MicroMsg.CardListSelectedUI", "setResultToSDK need MM_CARD_ITEM_FROM_SCENE_OPENAPI scene, the fromscene is " + this.fRv);
      AppMethodBeat.o(113509);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("_wxapi_choose_card_from_wx_card_list", paramString);
    Object localObject = h.m(this.app_id, true, false);
    ChooseCardFromWXCardPackage.Resp localResp = new ChooseCardFromWXCardPackage.Resp(localBundle);
    if (localObject != null) {
      localResp.openId = ((com.tencent.mm.pluginsdk.model.app.g)localObject).field_openId;
    }
    localResp.transaction = this.oLf;
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
      ae.i("MicroMsg.CardListSelectedUI", "setResultToSDK, appid : %s, appname : %s, openid : %s, transcation : %s", new Object[] { str2, str1, localObject, this.oLf });
      localResp.toBundle(localBundle);
      ae.i("MicroMsg.CardListSelectedUI", "setResultToSDK result:".concat(String.valueOf(paramInt)));
      ae.d("MicroMsg.CardListSelectedUI", "setResultToSDK card_list:".concat(String.valueOf(paramString)));
      if (paramInt != -1) {
        break label273;
      }
    }
    label263:
    label273:
    for (localResp.errCode = 0;; localResp.errCode = -2)
    {
      paramString = new MMessageActV2.Args();
      paramString.targetPkgName = this.oLe;
      paramString.bundle = localBundle;
      com.tencent.mm.pluginsdk.model.app.q.bc(localBundle);
      com.tencent.mm.pluginsdk.model.app.q.bd(localBundle);
      MMessageActV2.send(ak.getContext(), paramString);
      AppMethodBeat.o(113509);
      return;
      str1 = ((com.tencent.mm.pluginsdk.model.app.g)localObject).field_appName;
      break;
      localObject = ((com.tencent.mm.pluginsdk.model.app.g)localObject).field_openId;
      break label130;
    }
  }
  
  private void bXx()
  {
    AppMethodBeat.i(113506);
    Intent localIntent = new Intent();
    String str = bYo();
    if (this.oPc) {
      localIntent.putExtra("choose_invoice_info", str);
    }
    for (;;)
    {
      setResult(-1, localIntent);
      aI(-1, str);
      finish();
      AppMethodBeat.o(113506);
      return;
      localIntent.putExtra("choose_card_info", str);
    }
  }
  
  private void bYn()
  {
    AppMethodBeat.i(113498);
    if (this.oJV)
    {
      ae.e("MicroMsg.CardListSelectedUI", "doNetSceneGetShareCardsLayout, isDoingGetData is true");
      AppMethodBeat.o(113498);
      return;
    }
    if (this.oGT == null)
    {
      this.oOS = false;
      this.oOT = false;
      this.oOU = false;
    }
    com.tencent.mm.kernel.g.ajQ().gDv.a(1059, this);
    aj localaj = new aj(this.app_id, this.oOV, this.oOW, this.oOX, this.time_stamp, this.oOY, this.oEo, this.oOZ, this.oGT);
    com.tencent.mm.kernel.g.ajQ().gDv.a(localaj, 0);
    js(true);
    this.oJV = true;
    if (this.oPa == 1) {
      this.oOQ = true;
    }
    AppMethodBeat.o(113498);
  }
  
  private String bYo()
  {
    int j = 0;
    AppMethodBeat.i(113507);
    Object localObject1 = new ArrayList();
    int i = 0;
    while (i < this.gti.size())
    {
      localObject2 = (Boolean)this.oOR.get(Integer.valueOf(i));
      if ((localObject2 != null) && (((Boolean)localObject2).booleanValue())) {
        ((ArrayList)localObject1).add(this.gti.get(i));
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
      ((StringBuilder)localObject2).append("\"" + locala.oEo + "\"");
      ((StringBuilder)localObject2).append(",");
      ((StringBuilder)localObject2).append("\"encrypt_code\":");
      ((StringBuilder)localObject2).append("\"" + locala.oEr + "\"");
      if (this.oPc)
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
  
  public final void Za(String paramString) {}
  
  public final void b(String paramString, j.b paramb)
  {
    int j = 0;
    AppMethodBeat.i(113502);
    js(false);
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals(this.oPd.oEt)))
    {
      ae.e("MicroMsg.CardListSelectedUI", "onMarkSuccess(), the mark card id is diff from current id!");
      AppMethodBeat.o(113502);
      return;
    }
    ae.i("MicroMsg.CardListSelectedUI", "onMarkSuccess()");
    ae.i("MicroMsg.CardListSelectedUI", "markSucc:" + paramb.oEc + " markCardId: " + paramb.oEd);
    if (paramb.oEc == 1)
    {
      int i;
      if ((!TextUtils.isEmpty(paramb.oEd)) && (!paramString.equals(paramb.oEd)))
      {
        ae.i("MicroMsg.CardListSelectedUI", "markCardId is diff as now id!");
        i = 0;
        if (i < this.gti.size())
        {
          if (((com.tencent.mm.plugin.card.model.a)this.gti.get(i)).oEt != paramb.oEd) {
            break label230;
          }
          while (j < this.gti.size())
          {
            this.oOR.put(Integer.valueOf(j), Boolean.FALSE);
            j += 1;
          }
          this.oOR.put(Integer.valueOf(i), Boolean.TRUE);
        }
      }
      for (;;)
      {
        bXx();
        AppMethodBeat.o(113502);
        return;
        label230:
        i += 1;
        break;
        ae.i("MicroMsg.CardListSelectedUI", "markCardId is same as now id!");
      }
    }
    d.c(this, getString(2131756927));
    AppMethodBeat.o(113502);
  }
  
  public final void eZ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(113503);
    js(false);
    if ((!TextUtils.isEmpty(paramString1)) && (!paramString1.equals(this.oPd.oEt)))
    {
      ae.e("MicroMsg.CardListSelectedUI", "onMarkFail(), the mark card id is diff from current id!");
      AppMethodBeat.o(113503);
      return;
    }
    ae.i("MicroMsg.CardListSelectedUI", "onMarkFail()");
    paramString1 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramString1 = getString(2131756926);
    }
    d.c(this, paramString1);
    AppMethodBeat.o(113503);
  }
  
  public int getLayoutId()
  {
    return 2131493319;
  }
  
  public void initView()
  {
    AppMethodBeat.i(113499);
    if (this.oPc)
    {
      setMMTitle(2131756921);
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
      if (!this.oPc)
      {
        addTextOptionMenu(0, getString(2131755779), new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(113483);
            if ((!CardListSelectedUI.this.oOQ) && (CardListSelectedUI.b(CardListSelectedUI.this).oEy))
            {
              CardListSelectedUI.this.js(true);
              am.bWo().U(CardListSelectedUI.b(CardListSelectedUI.this).oEt, l.aae(CardListSelectedUI.b(CardListSelectedUI.this).userName), 3);
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
      this.mListView = ((ListView)findViewById(2131297841));
      if (!this.oPc) {
        break label288;
      }
    }
    label288:
    for (this.oKk = new b();; this.oKk = new a())
    {
      this.mListView.setAdapter(this.oKk);
      this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          int i = 0;
          AppMethodBeat.i(113484);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousAdapterView);
          localb.bd(paramAnonymousView);
          localb.mu(paramAnonymousInt);
          localb.rl(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/CardListSelectedUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
          if (paramAnonymousView.getAlpha() != 1.0F)
          {
            ae.d("MicroMsg.CardListSelectedUI", "item view is gray, cannot click, do nothing return！");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardListSelectedUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(113484);
            return;
          }
          boolean bool;
          if (CardListSelectedUI.this.oOQ)
          {
            bool = ((Boolean)CardListSelectedUI.this.oOR.get(Integer.valueOf(paramAnonymousInt))).booleanValue();
            paramAnonymousAdapterView = CardListSelectedUI.this.oOR;
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
            while (i < CardListSelectedUI.this.gti.size())
            {
              CardListSelectedUI.this.oOR.put(Integer.valueOf(i), Boolean.FALSE);
              i += 1;
            }
            CardListSelectedUI.this.oOR.put(Integer.valueOf(paramAnonymousInt), Boolean.TRUE);
            CardListSelectedUI.a(CardListSelectedUI.this, (com.tencent.mm.plugin.card.model.a)CardListSelectedUI.this.gti.get(paramAnonymousInt));
          }
        }
      });
      this.mListView.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(113485);
          if ((paramAnonymousAbsListView.getLastVisiblePosition() == paramAnonymousAbsListView.getCount() - 1) && (!CardListSelectedUI.this.hkx))
          {
            ae.d("MicroMsg.CardListSelectedUI", "onScroll() >> doGetCardList()");
            CardListSelectedUI.e(CardListSelectedUI.this);
          }
          AppMethodBeat.o(113485);
        }
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {}
      });
      this.GG = findViewById(2131298768);
      this.oOM = ((TextView)findViewById(2131302872));
      if (this.oPc) {
        this.oOM.setText(getString(2131756962));
      }
      this.oON = ((RelativeLayout)findViewById(2131301082));
      this.oOO = ((TextView)findViewById(2131301099));
      this.oOP = ((TextView)findViewById(2131301094));
      if (!this.oPc) {
        break label303;
      }
      this.oON.setVisibility(0);
      this.oOO.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(113486);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/CardListSelectedUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if (!bu.isNullOrNil(CardListSelectedUI.this.oPb)) {
            com.tencent.mm.plugin.card.d.b.a(CardListSelectedUI.this, CardListSelectedUI.this.oPb, CardListSelectedUI.this.getString(2131756909));
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardListSelectedUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(113486);
        }
      });
      this.oOP.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(113487);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/CardListSelectedUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          CardListSelectedUI.a(CardListSelectedUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardListSelectedUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(113487);
        }
      });
      AppMethodBeat.o(113499);
      return;
      setMMTitle(2131756920);
      break;
    }
    label303:
    this.oON.setVisibility(8);
    AppMethodBeat.o(113499);
  }
  
  protected final void js(boolean paramBoolean)
  {
    AppMethodBeat.i(113505);
    if (paramBoolean)
    {
      this.fSP = p.a(this, getString(2131760709), false, 0, null);
      AppMethodBeat.o(113505);
      return;
    }
    if ((this.fSP != null) && (this.fSP.isShowing()))
    {
      this.fSP.dismiss();
      this.fSP = null;
    }
    AppMethodBeat.o(113505);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(113497);
    super.onCreate(paramBundle);
    am.bWo().a(this);
    paramBundle = getIntent();
    ae.i("MicroMsg.CardListSelectedUI", "initData()");
    if (paramBundle == null)
    {
      ae.e("MicroMsg.CardListSelectedUI", "doGetCardList()  intent == null");
      setResult(1);
      aI(1, "");
      finish();
    }
    for (;;)
    {
      bYn();
      initView();
      AppMethodBeat.o(113497);
      return;
      this.fRv = paramBundle.getIntExtra("key_from_scene", 0);
      ae.i("MicroMsg.CardListSelectedUI", "mFromScene:" + this.fRv);
      this.app_id = paramBundle.getStringExtra("app_id");
      this.oOV = paramBundle.getIntExtra("shop_id", 0);
      this.oOW = paramBundle.getStringExtra("sign_type");
      this.oOX = paramBundle.getStringExtra("card_sign");
      this.time_stamp = paramBundle.getIntExtra("time_stamp", 0);
      this.oOY = paramBundle.getStringExtra("nonce_str");
      this.oEo = paramBundle.getStringExtra("card_tp_id");
      this.oOZ = paramBundle.getStringExtra("card_type");
      this.oPa = paramBundle.getIntExtra("can_multi_select", 0);
      this.oLe = paramBundle.getStringExtra("key_package_name");
      this.oLf = paramBundle.getStringExtra("key_transaction");
      ae.i("MicroMsg.CardListSelectedUI", "app_id:" + this.app_id + " shop_id:" + this.oOV + " sign_type:" + this.oOW + " time_stamp:" + this.time_stamp);
      ae.i("MicroMsg.CardListSelectedUI", "nonce_str:" + this.oOY + " card_tp_id:" + this.oEo + " card_type:" + this.oOZ + " canMultiSelect:" + this.oPa + " packateName:" + this.oLe);
      if ("INVOICE".equalsIgnoreCase(this.oOZ)) {
        this.oPc = true;
      }
      if (TextUtils.isEmpty(this.app_id))
      {
        ae.e("MicroMsg.CardListSelectedUI", "doGetCardList()  app_id is nulls");
        setResult(1);
        aI(1, "app_id  or card_sign is empty!");
        finish();
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113504);
    am.bWo().b(this);
    super.onDestroy();
    AppMethodBeat.o(113504);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(113508);
    if (paramInt == 4)
    {
      setResult(0);
      aI(0, "");
      finish();
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(113508);
    return bool;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(113500);
    if ((paramn instanceof aj))
    {
      com.tencent.mm.kernel.g.ajQ().gDv.b(1059, this);
      js(false);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label395;
      }
      paramString = ((aj)paramn).oGs;
      ae.d("MicroMsg.CardListSelectedUI", paramString);
      LinkedList localLinkedList1 = com.tencent.mm.plugin.card.model.a.Zd(paramString);
      LinkedList localLinkedList2 = com.tencent.mm.plugin.card.model.a.Ze(paramString);
      this.oPb = ZE(paramString);
      if ((this.oGT == null) && ((localLinkedList1 != null) || (localLinkedList2 != null)))
      {
        this.oOR.clear();
        this.gti.clear();
      }
      if (localLinkedList1 != null)
      {
        if ((localLinkedList1.size() > 0) && (!this.oOS))
        {
          this.oOS = true;
          if (!this.oPc) {
            break label208;
          }
        }
        label208:
        for (((com.tencent.mm.plugin.card.model.a)localLinkedList1.get(0)).ocZ = getString(2131756973);; ((com.tencent.mm.plugin.card.model.a)localLinkedList1.get(0)).ocZ = getString(2131756972))
        {
          paramInt1 = this.gti.size();
          this.gti.addAll(localLinkedList1);
          while (paramInt1 < this.gti.size())
          {
            this.oOR.put(Integer.valueOf(paramInt1), Boolean.FALSE);
            paramInt1 += 1;
          }
        }
      }
      if (localLinkedList2 != null)
      {
        if ((localLinkedList2.size() > 0) && (!this.oOT))
        {
          this.oOT = true;
          ((com.tencent.mm.plugin.card.model.a)localLinkedList2.get(0)).ocZ = getString(2131756824);
        }
        paramInt1 = this.gti.size();
        this.gti.addAll(localLinkedList2);
        while (paramInt1 < this.gti.size())
        {
          this.oOR.put(Integer.valueOf(paramInt1), Boolean.FALSE);
          paramInt1 += 1;
        }
      }
      this.hkx = ((aj)paramn).hkx;
      this.oGT = ((aj)paramn).oGT;
      this.oKk.notifyDataSetChanged();
      if (this.gti.size() == 0) {
        break label404;
      }
      this.GG.setVisibility(8);
      this.mListView.setVisibility(0);
    }
    for (;;)
    {
      this.oJV = false;
      AppMethodBeat.o(113500);
      return;
      label395:
      d.b(this, paramString, paramInt2);
      break;
      label404:
      this.GG.setVisibility(0);
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
    
    private com.tencent.mm.plugin.card.model.a AP(int paramInt)
    {
      AppMethodBeat.i(113489);
      com.tencent.mm.plugin.card.model.a locala = (com.tencent.mm.plugin.card.model.a)CardListSelectedUI.this.gti.get(paramInt);
      AppMethodBeat.o(113489);
      return locala;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(113488);
      int i = CardListSelectedUI.this.gti.size();
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
      Object localObject = AP(paramInt);
      label186:
      label217:
      int i;
      if (paramView == null)
      {
        paramView = View.inflate(CardListSelectedUI.this, 2131493340, null);
        paramViewGroup = new CardListSelectedUI.d(CardListSelectedUI.this);
        paramViewGroup.oPl = ((ImageView)paramView.findViewById(2131301584));
        paramViewGroup.gqi = ((TextView)paramView.findViewById(2131305902));
        paramViewGroup.oPh = ((TextView)paramView.findViewById(2131305508));
        paramViewGroup.oPm = ((TextView)paramView.findViewById(2131296994));
        paramViewGroup.ocS = ((TextView)paramView.findViewById(2131297925));
        paramViewGroup.oPn = paramView.findViewById(2131297424);
        paramViewGroup.oPo = ((ImageView)paramView.findViewById(2131297894));
        paramView.setTag(paramViewGroup);
        if (!l.AB(((com.tencent.mm.plugin.card.model.a)localObject).mwj)) {
          break label389;
        }
        paramViewGroup.gqi.setText(((com.tencent.mm.plugin.card.model.a)localObject).oEp);
        if (TextUtils.isEmpty(((com.tencent.mm.plugin.card.model.a)localObject).title)) {
          break label347;
        }
        paramViewGroup.oPh.setVisibility(0);
        paramViewGroup.oPh.setText(((com.tencent.mm.plugin.card.model.a)localObject).title);
        if (TextUtils.isEmpty(((com.tencent.mm.plugin.card.model.a)localObject).oEq)) {
          break label359;
        }
        paramViewGroup.oPm.setVisibility(0);
        paramViewGroup.oPm.setText(((com.tencent.mm.plugin.card.model.a)localObject).oEq);
        TextView localTextView = paramViewGroup.ocS;
        if (!bu.isNullOrNil(((com.tencent.mm.plugin.card.model.a)localObject).ocZ)) {
          break label371;
        }
        i = 8;
        label238:
        localTextView.setVisibility(i);
        paramViewGroup.ocS.setText(((com.tencent.mm.plugin.card.model.a)localObject).ocZ);
        i = CardListSelectedUI.this.getBaseContext().getResources().getDimensionPixelSize(2131165996);
        CardListSelectedUI.a(paramViewGroup.oPl, ((com.tencent.mm.plugin.card.model.a)localObject).hCp, i);
        localObject = (Boolean)CardListSelectedUI.this.oOR.get(Integer.valueOf(paramInt));
        if ((localObject == null) || (!((Boolean)localObject).booleanValue())) {
          break label377;
        }
        paramViewGroup.oPo.setImageResource(2131231424);
      }
      for (;;)
      {
        AppMethodBeat.o(113490);
        return paramView;
        paramViewGroup = (CardListSelectedUI.d)paramView.getTag();
        break;
        label347:
        paramViewGroup.oPh.setVisibility(8);
        break label186;
        label359:
        paramViewGroup.oPm.setVisibility(8);
        break label217;
        label371:
        i = 0;
        break label238;
        label377:
        paramViewGroup.oPo.setImageResource(2131231425);
        continue;
        label389:
        ae.i("MicroMsg.CardListSelectedUI", "not support type");
      }
    }
  }
  
  final class b
    extends BaseAdapter
  {
    b() {}
    
    private com.tencent.mm.plugin.card.model.a AP(int paramInt)
    {
      AppMethodBeat.i(113493);
      com.tencent.mm.plugin.card.model.a locala = (com.tencent.mm.plugin.card.model.a)CardListSelectedUI.this.gti.get(paramInt);
      AppMethodBeat.o(113493);
      return locala;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(113492);
      int i = CardListSelectedUI.this.gti.size();
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
      com.tencent.mm.plugin.card.model.a locala = AP(paramInt);
      if (paramView == null)
      {
        paramView = View.inflate(CardListSelectedUI.this, 2131493339, null);
        paramViewGroup = new CardListSelectedUI.c(CardListSelectedUI.this);
        paramViewGroup.oPf = ((ImageView)paramView.findViewById(2131297894));
        paramViewGroup.oPg = ((TextView)paramView.findViewById(2131301093));
        paramViewGroup.gqi = ((TextView)paramView.findViewById(2131305902));
        paramViewGroup.oPh = ((TextView)paramView.findViewById(2131305508));
        paramViewGroup.oPi = paramView.findViewById(2131306261);
        paramViewGroup.oPj = ((TextView)paramView.findViewById(2131301097));
        paramViewGroup.oPk = ((TextView)paramView.findViewById(2131301085));
        paramView.setTag(paramViewGroup);
        if (!l.AB(locala.mwj)) {
          break label549;
        }
        if (TextUtils.isEmpty(locala.title)) {
          break label387;
        }
        paramViewGroup.gqi.setVisibility(0);
        paramViewGroup.gqi.setText(locala.title);
        label174:
        if (TextUtils.isEmpty(locala.oEp)) {
          break label399;
        }
        paramViewGroup.oPh.setVisibility(0);
        paramViewGroup.oPh.setText(locala.oEp);
        label205:
        if (locala.oEu != 0) {
          break label423;
        }
        paramView.setAlpha(1.0F);
        paramViewGroup.oPf.setVisibility(0);
        paramViewGroup.oPg.setVisibility(8);
        Boolean localBoolean = (Boolean)CardListSelectedUI.this.oOR.get(Integer.valueOf(paramInt));
        if ((localBoolean == null) || (!localBoolean.booleanValue())) {
          break label411;
        }
        paramViewGroup.oPf.setImageResource(2131231424);
        label276:
        if (bu.isNullOrNil(locala.oEv)) {
          break label514;
        }
        paramViewGroup.oPj.setVisibility(0);
        paramViewGroup.oPj.setText(locala.oEv);
        label307:
        if (bu.isNullOrNil(locala.oEw)) {
          break label526;
        }
        paramViewGroup.oPk.setVisibility(0);
        paramViewGroup.oPk.setText(locala.oEw);
        label338:
        if ((!bu.isNullOrNil(locala.oEv)) || (!bu.isNullOrNil(locala.oEw))) {
          break label538;
        }
        paramViewGroup.oPi.setVisibility(8);
      }
      for (;;)
      {
        AppMethodBeat.o(113494);
        return paramView;
        paramViewGroup = (CardListSelectedUI.c)paramView.getTag();
        break;
        label387:
        paramViewGroup.gqi.setVisibility(8);
        break label174;
        label399:
        paramViewGroup.oPh.setVisibility(8);
        break label205;
        label411:
        paramViewGroup.oPf.setImageResource(2131231425);
        break label276;
        label423:
        if (locala.oEu == 1)
        {
          paramView.setAlpha(0.2F);
          paramViewGroup.oPf.setVisibility(8);
          if (!bu.isNullOrNil(locala.oEx))
          {
            paramViewGroup.oPg.setVisibility(0);
            paramViewGroup.oPg.setText(locala.oEx);
            break label276;
          }
          paramViewGroup.oPg.setVisibility(8);
          break label276;
        }
        paramViewGroup.oPf.setVisibility(8);
        paramViewGroup.oPg.setVisibility(8);
        break label276;
        label514:
        paramViewGroup.oPj.setVisibility(8);
        break label307;
        label526:
        paramViewGroup.oPk.setVisibility(8);
        break label338;
        label538:
        paramViewGroup.oPi.setVisibility(0);
        continue;
        label549:
        ae.i("MicroMsg.CardListSelectedUI", "not support type");
      }
    }
  }
  
  final class c
  {
    public TextView gqi;
    public ImageView oPf;
    public TextView oPg;
    public TextView oPh;
    public View oPi;
    public TextView oPj;
    public TextView oPk;
    
    c() {}
  }
  
  final class d
  {
    public TextView gqi;
    public TextView oPh;
    public ImageView oPl;
    public TextView oPm;
    public View oPn;
    public ImageView oPo;
    public TextView ocS;
    
    d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardListSelectedUI
 * JD-Core Version:    0.7.0.1
 */