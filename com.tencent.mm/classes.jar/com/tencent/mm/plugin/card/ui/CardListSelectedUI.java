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
import com.tencent.mm.al.n;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelbiz.ChooseCardFromWXCardPackage.Resp;
import com.tencent.mm.plugin.card.b.j;
import com.tencent.mm.plugin.card.b.j.a;
import com.tencent.mm.plugin.card.b.j.b;
import com.tencent.mm.plugin.card.d.d;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.model.a;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public class CardListSelectedUI
  extends MMActivity
  implements com.tencent.mm.al.g, j.a
{
  private View DR;
  private String app_id;
  LinkedList<a> fTs;
  private int fsv;
  private p ftP;
  boolean gna;
  private ListView mListView;
  private TextView nBQ;
  private RelativeLayout nBR;
  private TextView nBS;
  private TextView nBT;
  boolean nBU;
  HashMap<Integer, Boolean> nBV;
  private boolean nBW;
  private boolean nBX;
  private boolean nBY;
  private int nBZ;
  private String nCa;
  private String nCb;
  private String nCc;
  private String nCd;
  private int nCe;
  public String nCf;
  private boolean nCg;
  private a nCh;
  private String nrr;
  com.tencent.mm.bx.b ntX;
  private boolean nwZ;
  private BaseAdapter nxo;
  private String nyi;
  private String nyj;
  private int time_stamp;
  
  public CardListSelectedUI()
  {
    AppMethodBeat.i(113496);
    this.ftP = null;
    this.nBU = false;
    this.fTs = new LinkedList();
    this.nBV = new HashMap();
    this.gna = true;
    this.ntX = null;
    this.nwZ = false;
    this.nyi = "";
    this.nCg = false;
    this.fsv = 0;
    AppMethodBeat.o(113496);
  }
  
  private static String QS(String paramString)
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
      ad.printErrStackTrace("MicroMsg.CardListSelectedUI", paramString, "", new Object[0]);
      AppMethodBeat.o(113501);
    }
    return null;
  }
  
  private void aE(int paramInt, String paramString)
  {
    AppMethodBeat.i(113509);
    if (this.fsv != 8)
    {
      ad.e("MicroMsg.CardListSelectedUI", "setResultToSDK need MM_CARD_ITEM_FROM_SCENE_OPENAPI scene, the fromscene is " + this.fsv);
      AppMethodBeat.o(113509);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("_wxapi_choose_card_from_wx_card_list", paramString);
    Object localObject = h.j(this.app_id, true, false);
    ChooseCardFromWXCardPackage.Resp localResp = new ChooseCardFromWXCardPackage.Resp(localBundle);
    if (localObject != null) {
      localResp.openId = ((com.tencent.mm.pluginsdk.model.app.g)localObject).field_openId;
    }
    localResp.transaction = this.nyj;
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
      ad.i("MicroMsg.CardListSelectedUI", "setResultToSDK, appid : %s, appname : %s, openid : %s, transcation : %s", new Object[] { str2, str1, localObject, this.nyj });
      localResp.toBundle(localBundle);
      ad.i("MicroMsg.CardListSelectedUI", "setResultToSDK result:".concat(String.valueOf(paramInt)));
      ad.d("MicroMsg.CardListSelectedUI", "setResultToSDK card_list:".concat(String.valueOf(paramString)));
      if (paramInt != -1) {
        break label273;
      }
    }
    label263:
    label273:
    for (localResp.errCode = 0;; localResp.errCode = -2)
    {
      paramString = new MMessageActV2.Args();
      paramString.targetPkgName = this.nyi;
      paramString.bundle = localBundle;
      com.tencent.mm.pluginsdk.model.app.q.aS(localBundle);
      com.tencent.mm.pluginsdk.model.app.q.aT(localBundle);
      MMessageActV2.send(com.tencent.mm.sdk.platformtools.aj.getContext(), paramString);
      AppMethodBeat.o(113509);
      return;
      str1 = ((com.tencent.mm.pluginsdk.model.app.g)localObject).field_appName;
      break;
      localObject = ((com.tencent.mm.pluginsdk.model.app.g)localObject).field_openId;
      break label130;
    }
  }
  
  private void bKq()
  {
    AppMethodBeat.i(113506);
    Intent localIntent = new Intent();
    String str = bLh();
    if (this.nCg) {
      localIntent.putExtra("choose_invoice_info", str);
    }
    for (;;)
    {
      setResult(-1, localIntent);
      aE(-1, str);
      finish();
      AppMethodBeat.o(113506);
      return;
      localIntent.putExtra("choose_card_info", str);
    }
  }
  
  private void bLg()
  {
    AppMethodBeat.i(113498);
    if (this.nwZ)
    {
      ad.e("MicroMsg.CardListSelectedUI", "doNetSceneGetShareCardsLayout, isDoingGetData is true");
      AppMethodBeat.o(113498);
      return;
    }
    if (this.ntX == null)
    {
      this.nBW = false;
      this.nBX = false;
      this.nBY = false;
    }
    com.tencent.mm.kernel.g.afA().gcy.a(1059, this);
    com.tencent.mm.plugin.card.model.aj localaj = new com.tencent.mm.plugin.card.model.aj(this.app_id, this.nBZ, this.nCa, this.nCb, this.time_stamp, this.nCc, this.nrr, this.nCd, this.ntX);
    com.tencent.mm.kernel.g.afA().gcy.a(localaj, 0);
    iF(true);
    this.nwZ = true;
    if (this.nCe == 1) {
      this.nBU = true;
    }
    AppMethodBeat.o(113498);
  }
  
  private String bLh()
  {
    int j = 0;
    AppMethodBeat.i(113507);
    Object localObject1 = new ArrayList();
    int i = 0;
    while (i < this.fTs.size())
    {
      localObject2 = (Boolean)this.nBV.get(Integer.valueOf(i));
      if ((localObject2 != null) && (((Boolean)localObject2).booleanValue())) {
        ((ArrayList)localObject1).add(this.fTs.get(i));
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
      a locala = (a)((ArrayList)localObject1).get(i);
      ((StringBuilder)localObject2).append("{");
      ((StringBuilder)localObject2).append("\"card_id\":");
      ((StringBuilder)localObject2).append("\"" + locala.nrr + "\"");
      ((StringBuilder)localObject2).append(",");
      ((StringBuilder)localObject2).append("\"encrypt_code\":");
      ((StringBuilder)localObject2).append("\"" + locala.nru + "\"");
      if (this.nCg)
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
  
  public final void Qo(String paramString) {}
  
  public final void b(String paramString, j.b paramb)
  {
    int j = 0;
    AppMethodBeat.i(113502);
    iF(false);
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals(this.nCh.nrw)))
    {
      ad.e("MicroMsg.CardListSelectedUI", "onMarkSuccess(), the mark card id is diff from current id!");
      AppMethodBeat.o(113502);
      return;
    }
    ad.i("MicroMsg.CardListSelectedUI", "onMarkSuccess()");
    ad.i("MicroMsg.CardListSelectedUI", "markSucc:" + paramb.nrf + " markCardId: " + paramb.nrg);
    if (paramb.nrf == 1)
    {
      int i;
      if ((!TextUtils.isEmpty(paramb.nrg)) && (!paramString.equals(paramb.nrg)))
      {
        ad.i("MicroMsg.CardListSelectedUI", "markCardId is diff as now id!");
        i = 0;
        if (i < this.fTs.size())
        {
          if (((a)this.fTs.get(i)).nrw != paramb.nrg) {
            break label230;
          }
          while (j < this.fTs.size())
          {
            this.nBV.put(Integer.valueOf(j), Boolean.FALSE);
            j += 1;
          }
          this.nBV.put(Integer.valueOf(i), Boolean.TRUE);
        }
      }
      for (;;)
      {
        bKq();
        AppMethodBeat.o(113502);
        return;
        label230:
        i += 1;
        break;
        ad.i("MicroMsg.CardListSelectedUI", "markCardId is same as now id!");
      }
    }
    d.c(this, getString(2131756927));
    AppMethodBeat.o(113502);
  }
  
  public final void ey(String paramString1, String paramString2)
  {
    AppMethodBeat.i(113503);
    iF(false);
    if ((!TextUtils.isEmpty(paramString1)) && (!paramString1.equals(this.nCh.nrw)))
    {
      ad.e("MicroMsg.CardListSelectedUI", "onMarkFail(), the mark card id is diff from current id!");
      AppMethodBeat.o(113503);
      return;
    }
    ad.i("MicroMsg.CardListSelectedUI", "onMarkFail()");
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
  
  protected final void iF(boolean paramBoolean)
  {
    AppMethodBeat.i(113505);
    if (paramBoolean)
    {
      this.ftP = p.a(this, getString(2131760709), false, 0, null);
      AppMethodBeat.o(113505);
      return;
    }
    if ((this.ftP != null) && (this.ftP.isShowing()))
    {
      this.ftP.dismiss();
      this.ftP = null;
    }
    AppMethodBeat.o(113505);
  }
  
  public void initView()
  {
    AppMethodBeat.i(113499);
    if (this.nCg)
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
      if (!this.nCg)
      {
        addTextOptionMenu(0, getString(2131755779), new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(113483);
            if ((!CardListSelectedUI.this.nBU) && (CardListSelectedUI.b(CardListSelectedUI.this).nrB))
            {
              CardListSelectedUI.this.iF(true);
              am.bJh().T(CardListSelectedUI.b(CardListSelectedUI.this).nrw, l.Rs(CardListSelectedUI.b(CardListSelectedUI.this).userName), 3);
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
      if (!this.nCg) {
        break label288;
      }
    }
    label288:
    for (this.nxo = new b();; this.nxo = new a())
    {
      this.mListView.setAdapter(this.nxo);
      this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          int i = 0;
          AppMethodBeat.i(113484);
          if (paramAnonymousView.getAlpha() != 1.0F)
          {
            ad.d("MicroMsg.CardListSelectedUI", "item view is gray, cannot click, do nothing return！");
            AppMethodBeat.o(113484);
            return;
          }
          boolean bool;
          if (CardListSelectedUI.this.nBU)
          {
            bool = ((Boolean)CardListSelectedUI.this.nBV.get(Integer.valueOf(paramAnonymousInt))).booleanValue();
            paramAnonymousAdapterView = CardListSelectedUI.this.nBV;
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
            AppMethodBeat.o(113484);
            return;
            bool = false;
            break;
            while (i < CardListSelectedUI.this.fTs.size())
            {
              CardListSelectedUI.this.nBV.put(Integer.valueOf(i), Boolean.FALSE);
              i += 1;
            }
            CardListSelectedUI.this.nBV.put(Integer.valueOf(paramAnonymousInt), Boolean.TRUE);
            CardListSelectedUI.a(CardListSelectedUI.this, (a)CardListSelectedUI.this.fTs.get(paramAnonymousInt));
          }
        }
      });
      this.mListView.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(113485);
          if ((paramAnonymousAbsListView.getLastVisiblePosition() == paramAnonymousAbsListView.getCount() - 1) && (!CardListSelectedUI.this.gna))
          {
            ad.d("MicroMsg.CardListSelectedUI", "onScroll() >> doGetCardList()");
            CardListSelectedUI.e(CardListSelectedUI.this);
          }
          AppMethodBeat.o(113485);
        }
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {}
      });
      this.DR = findViewById(2131298768);
      this.nBQ = ((TextView)findViewById(2131302872));
      if (this.nCg) {
        this.nBQ.setText(getString(2131756962));
      }
      this.nBR = ((RelativeLayout)findViewById(2131301082));
      this.nBS = ((TextView)findViewById(2131301099));
      this.nBT = ((TextView)findViewById(2131301094));
      if (!this.nCg) {
        break label303;
      }
      this.nBR.setVisibility(0);
      this.nBS.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(113486);
          if (!bt.isNullOrNil(CardListSelectedUI.this.nCf)) {
            com.tencent.mm.plugin.card.d.b.a(CardListSelectedUI.this, CardListSelectedUI.this.nCf, CardListSelectedUI.this.getString(2131756909));
          }
          AppMethodBeat.o(113486);
        }
      });
      this.nBT.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(113487);
          CardListSelectedUI.a(CardListSelectedUI.this);
          AppMethodBeat.o(113487);
        }
      });
      AppMethodBeat.o(113499);
      return;
      setMMTitle(2131756920);
      break;
    }
    label303:
    this.nBR.setVisibility(8);
    AppMethodBeat.o(113499);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(113497);
    super.onCreate(paramBundle);
    am.bJh().a(this);
    paramBundle = getIntent();
    ad.i("MicroMsg.CardListSelectedUI", "initData()");
    if (paramBundle == null)
    {
      ad.e("MicroMsg.CardListSelectedUI", "doGetCardList()  intent == null");
      setResult(1);
      aE(1, "");
      finish();
    }
    for (;;)
    {
      bLg();
      initView();
      AppMethodBeat.o(113497);
      return;
      this.fsv = paramBundle.getIntExtra("key_from_scene", 0);
      ad.i("MicroMsg.CardListSelectedUI", "mFromScene:" + this.fsv);
      this.app_id = paramBundle.getStringExtra("app_id");
      this.nBZ = paramBundle.getIntExtra("shop_id", 0);
      this.nCa = paramBundle.getStringExtra("sign_type");
      this.nCb = paramBundle.getStringExtra("card_sign");
      this.time_stamp = paramBundle.getIntExtra("time_stamp", 0);
      this.nCc = paramBundle.getStringExtra("nonce_str");
      this.nrr = paramBundle.getStringExtra("card_tp_id");
      this.nCd = paramBundle.getStringExtra("card_type");
      this.nCe = paramBundle.getIntExtra("can_multi_select", 0);
      this.nyi = paramBundle.getStringExtra("key_package_name");
      this.nyj = paramBundle.getStringExtra("key_transaction");
      ad.i("MicroMsg.CardListSelectedUI", "app_id:" + this.app_id + " shop_id:" + this.nBZ + " sign_type:" + this.nCa + " time_stamp:" + this.time_stamp);
      ad.i("MicroMsg.CardListSelectedUI", "nonce_str:" + this.nCc + " card_tp_id:" + this.nrr + " card_type:" + this.nCd + " canMultiSelect:" + this.nCe + " packateName:" + this.nyi);
      if ("INVOICE".equalsIgnoreCase(this.nCd)) {
        this.nCg = true;
      }
      if (TextUtils.isEmpty(this.app_id))
      {
        ad.e("MicroMsg.CardListSelectedUI", "doGetCardList()  app_id is nulls");
        setResult(1);
        aE(1, "app_id  or card_sign is empty!");
        finish();
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113504);
    am.bJh().b(this);
    super.onDestroy();
    AppMethodBeat.o(113504);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(113508);
    if (paramInt == 4)
    {
      setResult(0);
      aE(0, "");
      finish();
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(113508);
    return bool;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(113500);
    if ((paramn instanceof com.tencent.mm.plugin.card.model.aj))
    {
      com.tencent.mm.kernel.g.afA().gcy.b(1059, this);
      iF(false);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label395;
      }
      paramString = ((com.tencent.mm.plugin.card.model.aj)paramn).ntw;
      ad.d("MicroMsg.CardListSelectedUI", paramString);
      LinkedList localLinkedList1 = a.Qr(paramString);
      LinkedList localLinkedList2 = a.Qs(paramString);
      this.nCf = QS(paramString);
      if ((this.ntX == null) && ((localLinkedList1 != null) || (localLinkedList2 != null)))
      {
        this.nBV.clear();
        this.fTs.clear();
      }
      if (localLinkedList1 != null)
      {
        if ((localLinkedList1.size() > 0) && (!this.nBW))
        {
          this.nBW = true;
          if (!this.nCg) {
            break label208;
          }
        }
        label208:
        for (((a)localLinkedList1.get(0)).mTA = getString(2131756973);; ((a)localLinkedList1.get(0)).mTA = getString(2131756972))
        {
          paramInt1 = this.fTs.size();
          this.fTs.addAll(localLinkedList1);
          while (paramInt1 < this.fTs.size())
          {
            this.nBV.put(Integer.valueOf(paramInt1), Boolean.FALSE);
            paramInt1 += 1;
          }
        }
      }
      if (localLinkedList2 != null)
      {
        if ((localLinkedList2.size() > 0) && (!this.nBX))
        {
          this.nBX = true;
          ((a)localLinkedList2.get(0)).mTA = getString(2131756824);
        }
        paramInt1 = this.fTs.size();
        this.fTs.addAll(localLinkedList2);
        while (paramInt1 < this.fTs.size())
        {
          this.nBV.put(Integer.valueOf(paramInt1), Boolean.FALSE);
          paramInt1 += 1;
        }
      }
      this.gna = ((com.tencent.mm.plugin.card.model.aj)paramn).gna;
      this.ntX = ((com.tencent.mm.plugin.card.model.aj)paramn).ntX;
      this.nxo.notifyDataSetChanged();
      if (this.fTs.size() == 0) {
        break label404;
      }
      this.DR.setVisibility(8);
      this.mListView.setVisibility(0);
    }
    for (;;)
    {
      this.nwZ = false;
      AppMethodBeat.o(113500);
      return;
      label395:
      d.b(this, paramString, paramInt2);
      break;
      label404:
      this.DR.setVisibility(0);
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
    
    private a ze(int paramInt)
    {
      AppMethodBeat.i(113489);
      a locala = (a)CardListSelectedUI.this.fTs.get(paramInt);
      AppMethodBeat.o(113489);
      return locala;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(113488);
      int i = CardListSelectedUI.this.fTs.size();
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
      Object localObject = ze(paramInt);
      label186:
      label217:
      int i;
      if (paramView == null)
      {
        paramView = View.inflate(CardListSelectedUI.this, 2131493340, null);
        paramViewGroup = new CardListSelectedUI.d(CardListSelectedUI.this);
        paramViewGroup.nCp = ((ImageView)paramView.findViewById(2131301584));
        paramViewGroup.fQp = ((TextView)paramView.findViewById(2131305902));
        paramViewGroup.nCl = ((TextView)paramView.findViewById(2131305508));
        paramViewGroup.nCq = ((TextView)paramView.findViewById(2131296994));
        paramViewGroup.mTt = ((TextView)paramView.findViewById(2131297925));
        paramViewGroup.nCr = paramView.findViewById(2131297424);
        paramViewGroup.nCs = ((ImageView)paramView.findViewById(2131297894));
        paramView.setTag(paramViewGroup);
        if (!l.yQ(((a)localObject).lpz)) {
          break label389;
        }
        paramViewGroup.fQp.setText(((a)localObject).nrs);
        if (TextUtils.isEmpty(((a)localObject).title)) {
          break label347;
        }
        paramViewGroup.nCl.setVisibility(0);
        paramViewGroup.nCl.setText(((a)localObject).title);
        if (TextUtils.isEmpty(((a)localObject).nrt)) {
          break label359;
        }
        paramViewGroup.nCq.setVisibility(0);
        paramViewGroup.nCq.setText(((a)localObject).nrt);
        TextView localTextView = paramViewGroup.mTt;
        if (!bt.isNullOrNil(((a)localObject).mTA)) {
          break label371;
        }
        i = 8;
        label238:
        localTextView.setVisibility(i);
        paramViewGroup.mTt.setText(((a)localObject).mTA);
        i = CardListSelectedUI.this.getBaseContext().getResources().getDimensionPixelSize(2131165996);
        CardListSelectedUI.a(paramViewGroup.nCp, ((a)localObject).gGR, i);
        localObject = (Boolean)CardListSelectedUI.this.nBV.get(Integer.valueOf(paramInt));
        if ((localObject == null) || (!((Boolean)localObject).booleanValue())) {
          break label377;
        }
        paramViewGroup.nCs.setImageResource(2131231424);
      }
      for (;;)
      {
        AppMethodBeat.o(113490);
        return paramView;
        paramViewGroup = (CardListSelectedUI.d)paramView.getTag();
        break;
        label347:
        paramViewGroup.nCl.setVisibility(8);
        break label186;
        label359:
        paramViewGroup.nCq.setVisibility(8);
        break label217;
        label371:
        i = 0;
        break label238;
        label377:
        paramViewGroup.nCs.setImageResource(2131231425);
        continue;
        label389:
        ad.i("MicroMsg.CardListSelectedUI", "not support type");
      }
    }
  }
  
  final class b
    extends BaseAdapter
  {
    b() {}
    
    private a ze(int paramInt)
    {
      AppMethodBeat.i(113493);
      a locala = (a)CardListSelectedUI.this.fTs.get(paramInt);
      AppMethodBeat.o(113493);
      return locala;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(113492);
      int i = CardListSelectedUI.this.fTs.size();
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
      a locala = ze(paramInt);
      if (paramView == null)
      {
        paramView = View.inflate(CardListSelectedUI.this, 2131493339, null);
        paramViewGroup = new CardListSelectedUI.c(CardListSelectedUI.this);
        paramViewGroup.nCj = ((ImageView)paramView.findViewById(2131297894));
        paramViewGroup.nCk = ((TextView)paramView.findViewById(2131301093));
        paramViewGroup.fQp = ((TextView)paramView.findViewById(2131305902));
        paramViewGroup.nCl = ((TextView)paramView.findViewById(2131305508));
        paramViewGroup.nCm = paramView.findViewById(2131306261);
        paramViewGroup.nCn = ((TextView)paramView.findViewById(2131301097));
        paramViewGroup.nCo = ((TextView)paramView.findViewById(2131301085));
        paramView.setTag(paramViewGroup);
        if (!l.yQ(locala.lpz)) {
          break label549;
        }
        if (TextUtils.isEmpty(locala.title)) {
          break label387;
        }
        paramViewGroup.fQp.setVisibility(0);
        paramViewGroup.fQp.setText(locala.title);
        label174:
        if (TextUtils.isEmpty(locala.nrs)) {
          break label399;
        }
        paramViewGroup.nCl.setVisibility(0);
        paramViewGroup.nCl.setText(locala.nrs);
        label205:
        if (locala.nrx != 0) {
          break label423;
        }
        paramView.setAlpha(1.0F);
        paramViewGroup.nCj.setVisibility(0);
        paramViewGroup.nCk.setVisibility(8);
        Boolean localBoolean = (Boolean)CardListSelectedUI.this.nBV.get(Integer.valueOf(paramInt));
        if ((localBoolean == null) || (!localBoolean.booleanValue())) {
          break label411;
        }
        paramViewGroup.nCj.setImageResource(2131231424);
        label276:
        if (bt.isNullOrNil(locala.nry)) {
          break label514;
        }
        paramViewGroup.nCn.setVisibility(0);
        paramViewGroup.nCn.setText(locala.nry);
        label307:
        if (bt.isNullOrNil(locala.nrz)) {
          break label526;
        }
        paramViewGroup.nCo.setVisibility(0);
        paramViewGroup.nCo.setText(locala.nrz);
        label338:
        if ((!bt.isNullOrNil(locala.nry)) || (!bt.isNullOrNil(locala.nrz))) {
          break label538;
        }
        paramViewGroup.nCm.setVisibility(8);
      }
      for (;;)
      {
        AppMethodBeat.o(113494);
        return paramView;
        paramViewGroup = (CardListSelectedUI.c)paramView.getTag();
        break;
        label387:
        paramViewGroup.fQp.setVisibility(8);
        break label174;
        label399:
        paramViewGroup.nCl.setVisibility(8);
        break label205;
        label411:
        paramViewGroup.nCj.setImageResource(2131231425);
        break label276;
        label423:
        if (locala.nrx == 1)
        {
          paramView.setAlpha(0.2F);
          paramViewGroup.nCj.setVisibility(8);
          if (!bt.isNullOrNil(locala.nrA))
          {
            paramViewGroup.nCk.setVisibility(0);
            paramViewGroup.nCk.setText(locala.nrA);
            break label276;
          }
          paramViewGroup.nCk.setVisibility(8);
          break label276;
        }
        paramViewGroup.nCj.setVisibility(8);
        paramViewGroup.nCk.setVisibility(8);
        break label276;
        label514:
        paramViewGroup.nCn.setVisibility(8);
        break label307;
        label526:
        paramViewGroup.nCo.setVisibility(8);
        break label338;
        label538:
        paramViewGroup.nCm.setVisibility(0);
        continue;
        label549:
        ad.i("MicroMsg.CardListSelectedUI", "not support type");
      }
    }
  }
  
  final class c
  {
    public TextView fQp;
    public ImageView nCj;
    public TextView nCk;
    public TextView nCl;
    public View nCm;
    public TextView nCn;
    public TextView nCo;
    
    c() {}
  }
  
  final class d
  {
    public TextView fQp;
    public TextView mTt;
    public TextView nCl;
    public ImageView nCp;
    public TextView nCq;
    public View nCr;
    public ImageView nCs;
    
    d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardListSelectedUI
 * JD-Core Version:    0.7.0.1
 */