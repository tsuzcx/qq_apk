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
import com.tencent.mm.ak.n;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelbiz.ChooseCardFromWXCardPackage.Resp;
import com.tencent.mm.plugin.card.b.j;
import com.tencent.mm.plugin.card.b.j.a;
import com.tencent.mm.plugin.card.b.j.b;
import com.tencent.mm.plugin.card.d.d;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.model.a;
import com.tencent.mm.plugin.card.model.aj;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public class CardListSelectedUI
  extends MMActivity
  implements com.tencent.mm.ak.g, j.a
{
  private View EP;
  private String app_id;
  LinkedList<a> fXm;
  private int fwc;
  private p fxw;
  boolean gNN;
  private ListView mListView;
  private String nUr;
  com.tencent.mm.bw.b nWX;
  private boolean nZZ;
  private BaseAdapter oao;
  private String obi;
  private String obk;
  private TextView oeQ;
  private RelativeLayout oeR;
  private TextView oeS;
  private TextView oeT;
  boolean oeU;
  HashMap<Integer, Boolean> oeV;
  private boolean oeW;
  private boolean oeX;
  private boolean oeY;
  private int oeZ;
  private String ofa;
  private String ofb;
  private String ofc;
  private String ofd;
  private int ofe;
  public String ofg;
  private boolean ofh;
  private a ofi;
  private int time_stamp;
  
  public CardListSelectedUI()
  {
    AppMethodBeat.i(113496);
    this.fxw = null;
    this.oeU = false;
    this.fXm = new LinkedList();
    this.oeV = new HashMap();
    this.gNN = true;
    this.nWX = null;
    this.nZZ = false;
    this.obi = "";
    this.ofh = false;
    this.fwc = 0;
    AppMethodBeat.o(113496);
  }
  
  private static String Ve(String paramString)
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
      ac.printErrStackTrace("MicroMsg.CardListSelectedUI", paramString, "", new Object[0]);
      AppMethodBeat.o(113501);
    }
    return null;
  }
  
  private void aG(int paramInt, String paramString)
  {
    AppMethodBeat.i(113509);
    if (this.fwc != 8)
    {
      ac.e("MicroMsg.CardListSelectedUI", "setResultToSDK need MM_CARD_ITEM_FROM_SCENE_OPENAPI scene, the fromscene is " + this.fwc);
      AppMethodBeat.o(113509);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("_wxapi_choose_card_from_wx_card_list", paramString);
    Object localObject = h.k(this.app_id, true, false);
    ChooseCardFromWXCardPackage.Resp localResp = new ChooseCardFromWXCardPackage.Resp(localBundle);
    if (localObject != null) {
      localResp.openId = ((com.tencent.mm.pluginsdk.model.app.g)localObject).field_openId;
    }
    localResp.transaction = this.obk;
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
      ac.i("MicroMsg.CardListSelectedUI", "setResultToSDK, appid : %s, appname : %s, openid : %s, transcation : %s", new Object[] { str2, str1, localObject, this.obk });
      localResp.toBundle(localBundle);
      ac.i("MicroMsg.CardListSelectedUI", "setResultToSDK result:".concat(String.valueOf(paramInt)));
      ac.d("MicroMsg.CardListSelectedUI", "setResultToSDK card_list:".concat(String.valueOf(paramString)));
      if (paramInt != -1) {
        break label273;
      }
    }
    label263:
    label273:
    for (localResp.errCode = 0;; localResp.errCode = -2)
    {
      paramString = new MMessageActV2.Args();
      paramString.targetPkgName = this.obi;
      paramString.bundle = localBundle;
      com.tencent.mm.pluginsdk.model.app.q.aW(localBundle);
      com.tencent.mm.pluginsdk.model.app.q.aX(localBundle);
      MMessageActV2.send(ai.getContext(), paramString);
      AppMethodBeat.o(113509);
      return;
      str1 = ((com.tencent.mm.pluginsdk.model.app.g)localObject).field_appName;
      break;
      localObject = ((com.tencent.mm.pluginsdk.model.app.g)localObject).field_openId;
      break label130;
    }
  }
  
  private void bRD()
  {
    AppMethodBeat.i(113506);
    Intent localIntent = new Intent();
    String str = bSu();
    if (this.ofh) {
      localIntent.putExtra("choose_invoice_info", str);
    }
    for (;;)
    {
      setResult(-1, localIntent);
      aG(-1, str);
      finish();
      AppMethodBeat.o(113506);
      return;
      localIntent.putExtra("choose_card_info", str);
    }
  }
  
  private void bSt()
  {
    AppMethodBeat.i(113498);
    if (this.nZZ)
    {
      ac.e("MicroMsg.CardListSelectedUI", "doNetSceneGetShareCardsLayout, isDoingGetData is true");
      AppMethodBeat.o(113498);
      return;
    }
    if (this.nWX == null)
    {
      this.oeW = false;
      this.oeX = false;
      this.oeY = false;
    }
    com.tencent.mm.kernel.g.agQ().ghe.a(1059, this);
    aj localaj = new aj(this.app_id, this.oeZ, this.ofa, this.ofb, this.time_stamp, this.ofc, this.nUr, this.ofd, this.nWX);
    com.tencent.mm.kernel.g.agQ().ghe.a(localaj, 0);
    ji(true);
    this.nZZ = true;
    if (this.ofe == 1) {
      this.oeU = true;
    }
    AppMethodBeat.o(113498);
  }
  
  private String bSu()
  {
    int j = 0;
    AppMethodBeat.i(113507);
    Object localObject1 = new ArrayList();
    int i = 0;
    while (i < this.fXm.size())
    {
      localObject2 = (Boolean)this.oeV.get(Integer.valueOf(i));
      if ((localObject2 != null) && (((Boolean)localObject2).booleanValue())) {
        ((ArrayList)localObject1).add(this.fXm.get(i));
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
      ((StringBuilder)localObject2).append("\"" + locala.nUr + "\"");
      ((StringBuilder)localObject2).append(",");
      ((StringBuilder)localObject2).append("\"encrypt_code\":");
      ((StringBuilder)localObject2).append("\"" + locala.nUu + "\"");
      if (this.ofh)
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
  
  public final void UA(String paramString) {}
  
  public final void b(String paramString, j.b paramb)
  {
    int j = 0;
    AppMethodBeat.i(113502);
    ji(false);
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals(this.ofi.nUw)))
    {
      ac.e("MicroMsg.CardListSelectedUI", "onMarkSuccess(), the mark card id is diff from current id!");
      AppMethodBeat.o(113502);
      return;
    }
    ac.i("MicroMsg.CardListSelectedUI", "onMarkSuccess()");
    ac.i("MicroMsg.CardListSelectedUI", "markSucc:" + paramb.nUf + " markCardId: " + paramb.nUg);
    if (paramb.nUf == 1)
    {
      int i;
      if ((!TextUtils.isEmpty(paramb.nUg)) && (!paramString.equals(paramb.nUg)))
      {
        ac.i("MicroMsg.CardListSelectedUI", "markCardId is diff as now id!");
        i = 0;
        if (i < this.fXm.size())
        {
          if (((a)this.fXm.get(i)).nUw != paramb.nUg) {
            break label230;
          }
          while (j < this.fXm.size())
          {
            this.oeV.put(Integer.valueOf(j), Boolean.FALSE);
            j += 1;
          }
          this.oeV.put(Integer.valueOf(i), Boolean.TRUE);
        }
      }
      for (;;)
      {
        bRD();
        AppMethodBeat.o(113502);
        return;
        label230:
        i += 1;
        break;
        ac.i("MicroMsg.CardListSelectedUI", "markCardId is same as now id!");
      }
    }
    d.c(this, getString(2131756927));
    AppMethodBeat.o(113502);
  }
  
  public final void eL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(113503);
    ji(false);
    if ((!TextUtils.isEmpty(paramString1)) && (!paramString1.equals(this.ofi.nUw)))
    {
      ac.e("MicroMsg.CardListSelectedUI", "onMarkFail(), the mark card id is diff from current id!");
      AppMethodBeat.o(113503);
      return;
    }
    ac.i("MicroMsg.CardListSelectedUI", "onMarkFail()");
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
    if (this.ofh)
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
      if (!this.ofh)
      {
        addTextOptionMenu(0, getString(2131755779), new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(113483);
            if ((!CardListSelectedUI.this.oeU) && (CardListSelectedUI.b(CardListSelectedUI.this).nUB))
            {
              CardListSelectedUI.this.ji(true);
              am.bQu().S(CardListSelectedUI.b(CardListSelectedUI.this).nUw, l.VE(CardListSelectedUI.b(CardListSelectedUI.this).userName), 3);
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
      if (!this.ofh) {
        break label288;
      }
    }
    label288:
    for (this.oao = new b();; this.oao = new a())
    {
      this.mListView.setAdapter(this.oao);
      this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          int i = 0;
          AppMethodBeat.i(113484);
          if (paramAnonymousView.getAlpha() != 1.0F)
          {
            ac.d("MicroMsg.CardListSelectedUI", "item view is gray, cannot click, do nothing return！");
            AppMethodBeat.o(113484);
            return;
          }
          boolean bool;
          if (CardListSelectedUI.this.oeU)
          {
            bool = ((Boolean)CardListSelectedUI.this.oeV.get(Integer.valueOf(paramAnonymousInt))).booleanValue();
            paramAnonymousAdapterView = CardListSelectedUI.this.oeV;
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
            while (i < CardListSelectedUI.this.fXm.size())
            {
              CardListSelectedUI.this.oeV.put(Integer.valueOf(i), Boolean.FALSE);
              i += 1;
            }
            CardListSelectedUI.this.oeV.put(Integer.valueOf(paramAnonymousInt), Boolean.TRUE);
            CardListSelectedUI.a(CardListSelectedUI.this, (a)CardListSelectedUI.this.fXm.get(paramAnonymousInt));
          }
        }
      });
      this.mListView.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(113485);
          if ((paramAnonymousAbsListView.getLastVisiblePosition() == paramAnonymousAbsListView.getCount() - 1) && (!CardListSelectedUI.this.gNN))
          {
            ac.d("MicroMsg.CardListSelectedUI", "onScroll() >> doGetCardList()");
            CardListSelectedUI.e(CardListSelectedUI.this);
          }
          AppMethodBeat.o(113485);
        }
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {}
      });
      this.EP = findViewById(2131298768);
      this.oeQ = ((TextView)findViewById(2131302872));
      if (this.ofh) {
        this.oeQ.setText(getString(2131756962));
      }
      this.oeR = ((RelativeLayout)findViewById(2131301082));
      this.oeS = ((TextView)findViewById(2131301099));
      this.oeT = ((TextView)findViewById(2131301094));
      if (!this.ofh) {
        break label303;
      }
      this.oeR.setVisibility(0);
      this.oeS.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(113486);
          if (!bs.isNullOrNil(CardListSelectedUI.this.ofg)) {
            com.tencent.mm.plugin.card.d.b.a(CardListSelectedUI.this, CardListSelectedUI.this.ofg, CardListSelectedUI.this.getString(2131756909));
          }
          AppMethodBeat.o(113486);
        }
      });
      this.oeT.setOnClickListener(new View.OnClickListener()
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
    this.oeR.setVisibility(8);
    AppMethodBeat.o(113499);
  }
  
  protected final void ji(boolean paramBoolean)
  {
    AppMethodBeat.i(113505);
    if (paramBoolean)
    {
      this.fxw = p.a(this, getString(2131760709), false, 0, null);
      AppMethodBeat.o(113505);
      return;
    }
    if ((this.fxw != null) && (this.fxw.isShowing()))
    {
      this.fxw.dismiss();
      this.fxw = null;
    }
    AppMethodBeat.o(113505);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(113497);
    super.onCreate(paramBundle);
    am.bQu().a(this);
    paramBundle = getIntent();
    ac.i("MicroMsg.CardListSelectedUI", "initData()");
    if (paramBundle == null)
    {
      ac.e("MicroMsg.CardListSelectedUI", "doGetCardList()  intent == null");
      setResult(1);
      aG(1, "");
      finish();
    }
    for (;;)
    {
      bSt();
      initView();
      AppMethodBeat.o(113497);
      return;
      this.fwc = paramBundle.getIntExtra("key_from_scene", 0);
      ac.i("MicroMsg.CardListSelectedUI", "mFromScene:" + this.fwc);
      this.app_id = paramBundle.getStringExtra("app_id");
      this.oeZ = paramBundle.getIntExtra("shop_id", 0);
      this.ofa = paramBundle.getStringExtra("sign_type");
      this.ofb = paramBundle.getStringExtra("card_sign");
      this.time_stamp = paramBundle.getIntExtra("time_stamp", 0);
      this.ofc = paramBundle.getStringExtra("nonce_str");
      this.nUr = paramBundle.getStringExtra("card_tp_id");
      this.ofd = paramBundle.getStringExtra("card_type");
      this.ofe = paramBundle.getIntExtra("can_multi_select", 0);
      this.obi = paramBundle.getStringExtra("key_package_name");
      this.obk = paramBundle.getStringExtra("key_transaction");
      ac.i("MicroMsg.CardListSelectedUI", "app_id:" + this.app_id + " shop_id:" + this.oeZ + " sign_type:" + this.ofa + " time_stamp:" + this.time_stamp);
      ac.i("MicroMsg.CardListSelectedUI", "nonce_str:" + this.ofc + " card_tp_id:" + this.nUr + " card_type:" + this.ofd + " canMultiSelect:" + this.ofe + " packateName:" + this.obi);
      if ("INVOICE".equalsIgnoreCase(this.ofd)) {
        this.ofh = true;
      }
      if (TextUtils.isEmpty(this.app_id))
      {
        ac.e("MicroMsg.CardListSelectedUI", "doGetCardList()  app_id is nulls");
        setResult(1);
        aG(1, "app_id  or card_sign is empty!");
        finish();
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113504);
    am.bQu().b(this);
    super.onDestroy();
    AppMethodBeat.o(113504);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(113508);
    if (paramInt == 4)
    {
      setResult(0);
      aG(0, "");
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
      com.tencent.mm.kernel.g.agQ().ghe.b(1059, this);
      ji(false);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label395;
      }
      paramString = ((aj)paramn).nWw;
      ac.d("MicroMsg.CardListSelectedUI", paramString);
      LinkedList localLinkedList1 = a.UD(paramString);
      LinkedList localLinkedList2 = a.UE(paramString);
      this.ofg = Ve(paramString);
      if ((this.nWX == null) && ((localLinkedList1 != null) || (localLinkedList2 != null)))
      {
        this.oeV.clear();
        this.fXm.clear();
      }
      if (localLinkedList1 != null)
      {
        if ((localLinkedList1.size() > 0) && (!this.oeW))
        {
          this.oeW = true;
          if (!this.ofh) {
            break label208;
          }
        }
        label208:
        for (((a)localLinkedList1.get(0)).nvS = getString(2131756973);; ((a)localLinkedList1.get(0)).nvS = getString(2131756972))
        {
          paramInt1 = this.fXm.size();
          this.fXm.addAll(localLinkedList1);
          while (paramInt1 < this.fXm.size())
          {
            this.oeV.put(Integer.valueOf(paramInt1), Boolean.FALSE);
            paramInt1 += 1;
          }
        }
      }
      if (localLinkedList2 != null)
      {
        if ((localLinkedList2.size() > 0) && (!this.oeX))
        {
          this.oeX = true;
          ((a)localLinkedList2.get(0)).nvS = getString(2131756824);
        }
        paramInt1 = this.fXm.size();
        this.fXm.addAll(localLinkedList2);
        while (paramInt1 < this.fXm.size())
        {
          this.oeV.put(Integer.valueOf(paramInt1), Boolean.FALSE);
          paramInt1 += 1;
        }
      }
      this.gNN = ((aj)paramn).gNN;
      this.nWX = ((aj)paramn).nWX;
      this.oao.notifyDataSetChanged();
      if (this.fXm.size() == 0) {
        break label404;
      }
      this.EP.setVisibility(8);
      this.mListView.setVisibility(0);
    }
    for (;;)
    {
      this.nZZ = false;
      AppMethodBeat.o(113500);
      return;
      label395:
      d.b(this, paramString, paramInt2);
      break;
      label404:
      this.EP.setVisibility(0);
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
    
    private a zU(int paramInt)
    {
      AppMethodBeat.i(113489);
      a locala = (a)CardListSelectedUI.this.fXm.get(paramInt);
      AppMethodBeat.o(113489);
      return locala;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(113488);
      int i = CardListSelectedUI.this.fXm.size();
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
      Object localObject = zU(paramInt);
      label186:
      label217:
      int i;
      if (paramView == null)
      {
        paramView = View.inflate(CardListSelectedUI.this, 2131493340, null);
        paramViewGroup = new CardListSelectedUI.d(CardListSelectedUI.this);
        paramViewGroup.ofq = ((ImageView)paramView.findViewById(2131301584));
        paramViewGroup.fUk = ((TextView)paramView.findViewById(2131305902));
        paramViewGroup.ofm = ((TextView)paramView.findViewById(2131305508));
        paramViewGroup.ofr = ((TextView)paramView.findViewById(2131296994));
        paramViewGroup.nvL = ((TextView)paramView.findViewById(2131297925));
        paramViewGroup.ofs = paramView.findViewById(2131297424);
        paramViewGroup.oft = ((ImageView)paramView.findViewById(2131297894));
        paramView.setTag(paramViewGroup);
        if (!l.zG(((a)localObject).lRv)) {
          break label389;
        }
        paramViewGroup.fUk.setText(((a)localObject).nUs);
        if (TextUtils.isEmpty(((a)localObject).title)) {
          break label347;
        }
        paramViewGroup.ofm.setVisibility(0);
        paramViewGroup.ofm.setText(((a)localObject).title);
        if (TextUtils.isEmpty(((a)localObject).nUt)) {
          break label359;
        }
        paramViewGroup.ofr.setVisibility(0);
        paramViewGroup.ofr.setText(((a)localObject).nUt);
        TextView localTextView = paramViewGroup.nvL;
        if (!bs.isNullOrNil(((a)localObject).nvS)) {
          break label371;
        }
        i = 8;
        label238:
        localTextView.setVisibility(i);
        paramViewGroup.nvL.setText(((a)localObject).nvS);
        i = CardListSelectedUI.this.getBaseContext().getResources().getDimensionPixelSize(2131165996);
        CardListSelectedUI.a(paramViewGroup.ofq, ((a)localObject).hhs, i);
        localObject = (Boolean)CardListSelectedUI.this.oeV.get(Integer.valueOf(paramInt));
        if ((localObject == null) || (!((Boolean)localObject).booleanValue())) {
          break label377;
        }
        paramViewGroup.oft.setImageResource(2131231424);
      }
      for (;;)
      {
        AppMethodBeat.o(113490);
        return paramView;
        paramViewGroup = (CardListSelectedUI.d)paramView.getTag();
        break;
        label347:
        paramViewGroup.ofm.setVisibility(8);
        break label186;
        label359:
        paramViewGroup.ofr.setVisibility(8);
        break label217;
        label371:
        i = 0;
        break label238;
        label377:
        paramViewGroup.oft.setImageResource(2131231425);
        continue;
        label389:
        ac.i("MicroMsg.CardListSelectedUI", "not support type");
      }
    }
  }
  
  final class b
    extends BaseAdapter
  {
    b() {}
    
    private a zU(int paramInt)
    {
      AppMethodBeat.i(113493);
      a locala = (a)CardListSelectedUI.this.fXm.get(paramInt);
      AppMethodBeat.o(113493);
      return locala;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(113492);
      int i = CardListSelectedUI.this.fXm.size();
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
      a locala = zU(paramInt);
      if (paramView == null)
      {
        paramView = View.inflate(CardListSelectedUI.this, 2131493339, null);
        paramViewGroup = new CardListSelectedUI.c(CardListSelectedUI.this);
        paramViewGroup.ofk = ((ImageView)paramView.findViewById(2131297894));
        paramViewGroup.ofl = ((TextView)paramView.findViewById(2131301093));
        paramViewGroup.fUk = ((TextView)paramView.findViewById(2131305902));
        paramViewGroup.ofm = ((TextView)paramView.findViewById(2131305508));
        paramViewGroup.ofn = paramView.findViewById(2131306261);
        paramViewGroup.ofo = ((TextView)paramView.findViewById(2131301097));
        paramViewGroup.ofp = ((TextView)paramView.findViewById(2131301085));
        paramView.setTag(paramViewGroup);
        if (!l.zG(locala.lRv)) {
          break label549;
        }
        if (TextUtils.isEmpty(locala.title)) {
          break label387;
        }
        paramViewGroup.fUk.setVisibility(0);
        paramViewGroup.fUk.setText(locala.title);
        label174:
        if (TextUtils.isEmpty(locala.nUs)) {
          break label399;
        }
        paramViewGroup.ofm.setVisibility(0);
        paramViewGroup.ofm.setText(locala.nUs);
        label205:
        if (locala.nUx != 0) {
          break label423;
        }
        paramView.setAlpha(1.0F);
        paramViewGroup.ofk.setVisibility(0);
        paramViewGroup.ofl.setVisibility(8);
        Boolean localBoolean = (Boolean)CardListSelectedUI.this.oeV.get(Integer.valueOf(paramInt));
        if ((localBoolean == null) || (!localBoolean.booleanValue())) {
          break label411;
        }
        paramViewGroup.ofk.setImageResource(2131231424);
        label276:
        if (bs.isNullOrNil(locala.nUy)) {
          break label514;
        }
        paramViewGroup.ofo.setVisibility(0);
        paramViewGroup.ofo.setText(locala.nUy);
        label307:
        if (bs.isNullOrNil(locala.nUz)) {
          break label526;
        }
        paramViewGroup.ofp.setVisibility(0);
        paramViewGroup.ofp.setText(locala.nUz);
        label338:
        if ((!bs.isNullOrNil(locala.nUy)) || (!bs.isNullOrNil(locala.nUz))) {
          break label538;
        }
        paramViewGroup.ofn.setVisibility(8);
      }
      for (;;)
      {
        AppMethodBeat.o(113494);
        return paramView;
        paramViewGroup = (CardListSelectedUI.c)paramView.getTag();
        break;
        label387:
        paramViewGroup.fUk.setVisibility(8);
        break label174;
        label399:
        paramViewGroup.ofm.setVisibility(8);
        break label205;
        label411:
        paramViewGroup.ofk.setImageResource(2131231425);
        break label276;
        label423:
        if (locala.nUx == 1)
        {
          paramView.setAlpha(0.2F);
          paramViewGroup.ofk.setVisibility(8);
          if (!bs.isNullOrNil(locala.nUA))
          {
            paramViewGroup.ofl.setVisibility(0);
            paramViewGroup.ofl.setText(locala.nUA);
            break label276;
          }
          paramViewGroup.ofl.setVisibility(8);
          break label276;
        }
        paramViewGroup.ofk.setVisibility(8);
        paramViewGroup.ofl.setVisibility(8);
        break label276;
        label514:
        paramViewGroup.ofo.setVisibility(8);
        break label307;
        label526:
        paramViewGroup.ofp.setVisibility(8);
        break label338;
        label538:
        paramViewGroup.ofn.setVisibility(0);
        continue;
        label549:
        ac.i("MicroMsg.CardListSelectedUI", "not support type");
      }
    }
  }
  
  final class c
  {
    public TextView fUk;
    public ImageView ofk;
    public TextView ofl;
    public TextView ofm;
    public View ofn;
    public TextView ofo;
    public TextView ofp;
    
    c() {}
  }
  
  final class d
  {
    public TextView fUk;
    public TextView nvL;
    public TextView ofm;
    public ImageView ofq;
    public TextView ofr;
    public View ofs;
    public ImageView oft;
    
    d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardListSelectedUI
 * JD-Core Version:    0.7.0.1
 */