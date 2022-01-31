package com.tencent.mm.plugin.card.ui;

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
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.card.a.a;
import com.tencent.mm.plugin.card.a.b;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.d.d;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.ab;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.protocal.c.lw;
import com.tencent.mm.protocal.c.mg;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.statusbar.DrawStatusBarActivity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CardAcceptCardListUI
  extends DrawStatusBarActivity
  implements com.tencent.mm.ah.f, MMActivity.a
{
  int bZe = 8;
  private String dRD = "";
  private com.tencent.mm.ui.base.p dpF = null;
  protected ListView ijF = null;
  protected RelativeLayout ijH = null;
  private boolean ily = false;
  private int inA;
  private String inB;
  private int inC;
  private String inD;
  private String inz = "";
  private Button ipP;
  public int ipW = 0;
  private String ipX = "";
  private String ipY = "";
  public ArrayList<String> ipZ = new ArrayList();
  public ArrayList<String> iqa = new ArrayList();
  String irA = "";
  private String irB = "";
  LinkedList<lw> irC = new LinkedList();
  LinkedList<String> irD = new LinkedList();
  HashMap<String, Integer> irj = new HashMap();
  private View irp;
  private View irq;
  private View irr;
  protected a irs = null;
  private View irt;
  private View iru;
  private TextView irv;
  private Button irw;
  LinkedList<lw> irx = new LinkedList();
  int iry = 7;
  String irz = "";
  
  private String aAY()
  {
    if ((!TextUtils.isEmpty(this.ipX)) && (!TextUtils.isEmpty(this.ipY))) {
      return this.ipX + "," + l.yV(this.ipY);
    }
    if (!TextUtils.isEmpty(this.ipX)) {
      return this.ipX;
    }
    if (!TextUtils.isEmpty(this.ipY)) {
      return l.yV(this.ipY);
    }
    return "";
  }
  
  private void aBm()
  {
    if (!TextUtils.isEmpty(this.inD))
    {
      this.irv.setText(this.inD);
      return;
    }
    this.irv.setText(a.g.card_share_card_private_setting);
  }
  
  private ArrayList<CardInfo> aP(List<CardInfo> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      y.e("MicroMsg.CardAcceptCardListUI", "geCardInfoListByTpId list is empty!");
      return null;
    }
    this.irC.clear();
    this.irD.clear();
    this.irj.clear();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < paramList.size())
    {
      CardInfo localCardInfo = (CardInfo)paramList.get(i);
      if (this.irD.contains(localCardInfo.field_card_tp_id))
      {
        int j = ((Integer)this.irj.get(localCardInfo.field_card_tp_id)).intValue();
        this.irj.put(localCardInfo.field_card_tp_id, Integer.valueOf(j + 1));
      }
      for (;;)
      {
        i += 1;
        break;
        localArrayList.add(localCardInfo);
        this.irj.put(localCardInfo.field_card_tp_id, Integer.valueOf(1));
        this.irD.add(localCardInfo.field_card_tp_id);
      }
    }
    return localArrayList;
  }
  
  private void oW(int paramInt)
  {
    y.i("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI finishUI() result_code:" + paramInt);
    Intent localIntent = new Intent();
    localIntent.putExtra("card_list", this.inz);
    localIntent.putExtra("result_code", paramInt);
    setResult(0, localIntent);
    finish();
  }
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        return;
      } while (paramInt2 != -1);
      this.ipW = paramIntent.getIntExtra("Ktag_range_index", 0);
      y.i("MicroMsg.CardAcceptCardListUI", "mPrivateSelelct : %d", new Object[] { Integer.valueOf(this.ipW) });
      if (this.ipW < 2) {
        break label417;
      }
      this.ipX = paramIntent.getStringExtra("Klabel_name_list");
      this.ipY = paramIntent.getStringExtra("Kother_user_name_list");
      y.d("MicroMsg.CardAcceptCardListUI", "mPrivateSelect : %d, names : %s", new Object[] { Integer.valueOf(this.ipW), this.ipX });
      if ((TextUtils.isEmpty(this.ipX)) && (TextUtils.isEmpty(this.ipY)))
      {
        y.e("MicroMsg.CardAcceptCardListUI", "mLabelNameList by getIntent is empty");
        aBm();
        return;
      }
      paramIntent = Arrays.asList(this.ipX.split(","));
      this.iqa = l.aT(paramIntent);
      this.ipZ = l.aS(paramIntent);
      if ((this.ipY != null) && (this.ipY.length() > 0))
      {
        paramIntent = Arrays.asList(this.ipY.split(","));
        this.ipZ.addAll(paramIntent);
      }
      if (this.iqa != null) {
        y.i("MicroMsg.CardAcceptCardListUI", "mPrivateIdsList size is " + this.iqa.size());
      }
      if (this.ipZ != null)
      {
        y.i("MicroMsg.CardAcceptCardListUI", "mPrivateNamesList size is " + this.ipZ.size());
        paramIntent = this.ipZ.iterator();
        while (paramIntent.hasNext()) {
          y.d("MicroMsg.CardAcceptCardListUI", "username : %s", new Object[] { (String)paramIntent.next() });
        }
      }
      if (TextUtils.isEmpty(this.ipX)) {
        break;
      }
      if (this.ipW == 2)
      {
        this.irv.setText(getString(a.g.card_share_card_private_setting_share, new Object[] { aAY() }));
        return;
      }
    } while (this.ipW != 3);
    this.irv.setText(getString(a.g.card_share_card_private_setting_not_share, new Object[] { aAY() }));
    return;
    aBm();
    return;
    label417:
    aBm();
  }
  
  final void ew(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.dpF = com.tencent.mm.ui.base.p.b(this, getString(a.g.loading_tips), false, 0, null);
    }
    while ((this.dpF == null) || (!this.dpF.isShowing())) {
      return;
    }
    this.dpF.dismiss();
    this.dpF = null;
  }
  
  protected final int getLayoutId()
  {
    return a.e.card_accept_card_list_ui;
  }
  
  protected final void initView()
  {
    setMMTitle(a.g.card_accept_card_list_ui_title);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        y.v("MicroMsg.CardAcceptCardListUI", "setBackBtn cancel");
        CardAcceptCardListUI.a(CardAcceptCardListUI.this, 1);
        return true;
      }
    });
    this.irp = findViewById(a.d.card_accept_card_list_ui);
    this.irq = findViewById(a.d.top_layout);
    this.irr = findViewById(a.d.list_layout);
    this.irq.setVisibility(4);
    this.ijF = ((ListView)findViewById(16908298));
    this.ijH = ((RelativeLayout)findViewById(a.d.content_no_data));
    this.ijF.setEmptyView(this.ijH);
    this.irs = new a(this);
    this.ijF.setAdapter(this.irs);
    this.ijF.setOnItemClickListener(new CardAcceptCardListUI.2(this));
    this.irt = findViewById(a.d.card_accept_layout);
    this.ipP = ((Button)findViewById(a.d.card_accept_btn));
    this.ipP.setOnClickListener(new CardAcceptCardListUI.3(this));
    this.ipP.setEnabled(false);
    this.iru = findViewById(a.d.card_private_setting_layout);
    this.irv = ((TextView)findViewById(a.d.card_private_setting_tv));
    this.irw = ((Button)findViewById(a.d.card_private_setting_btn));
    this.irw.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        CardAcceptCardListUI.c(CardAcceptCardListUI.this);
      }
    });
    Object localObject2 = getIntent();
    if (localObject2 == null)
    {
      y.e("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI initView () intent == null");
      oW(2);
      return;
    }
    y.i("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI handle data");
    Object localObject3 = ((Intent)localObject2).getStringExtra("key_in_card_list");
    this.bZe = ((Intent)localObject2).getIntExtra("key_from_scene", 8);
    Object localObject1 = ((Intent)localObject2).getStringExtra("key_package_name");
    localObject2 = ((Intent)localObject2).getStringExtra("key_sign");
    this.iry = getIntent().getIntExtra("key_stastic_scene", 7);
    this.irz = getIntent().getStringExtra("src_username");
    this.irA = getIntent().getStringExtra("js_url");
    this.irB = getIntent().getStringExtra("key_consumed_card_id");
    this.dRD = getIntent().getStringExtra("key_template_id");
    localObject3 = com.tencent.mm.plugin.card.d.h.bn((String)localObject3, this.bZe);
    if ((localObject3 == null) || (((List)localObject3).size() == 0))
    {
      y.e("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI initView () tempList == null || tempList.size() == 0");
      oW(2);
      return;
    }
    this.irx.clear();
    this.irx.addAll((Collection)localObject3);
    this.irC.clear();
    this.irD.clear();
    this.irj.clear();
    localObject3 = this.irx;
    ew(true);
    localObject1 = new ab((LinkedList)localObject3, this.bZe, (String)localObject1, (String)localObject2, this.irz, this.irA, this.irB, this.iry);
    com.tencent.mm.kernel.g.DO().dJT.a((com.tencent.mm.ah.m)localObject1, 0);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.DO().dJT.a(690, this);
    com.tencent.mm.kernel.g.DO().dJT.a(687, this);
    com.tencent.mm.kernel.g.DO().dJT.a(902, this);
    initView();
  }
  
  protected void onDestroy()
  {
    com.tencent.mm.kernel.g.DO().dJT.b(690, this);
    com.tencent.mm.kernel.g.DO().dJT.b(687, this);
    com.tencent.mm.kernel.g.DO().dJT.b(902, this);
    this.irx.clear();
    a locala = this.irs;
    locala.iqo.clear();
    locala.mContext = null;
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      y.i("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI onKeyDown() back cancel");
      oW(1);
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    Object localObject1;
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if ((paramm instanceof ab))
      {
        ew(false);
        paramString = (ab)paramm;
        paramm = paramString.inn;
        this.inA = paramString.inA;
        this.inB = paramString.inB;
        this.inC = paramString.inC;
        this.inD = paramString.inD;
        y.i("MicroMsg.CardAcceptCardListUI", "accept_button_status: " + this.inA + "  accept_button_wording: " + this.inB);
        y.i("MicroMsg.CardAcceptCardListUI", "private_status: " + this.inC + "  private_wording: " + this.inD);
        paramString = com.tencent.mm.plugin.card.d.f.yK(paramm);
        paramm = aP(paramString);
        if ((paramString != null) && (paramString.size() > 0))
        {
          y.i("MicroMsg.CardAcceptCardListUI", "The card info list size is " + paramString.size());
          if ((paramm != null) && (paramm.size() > 0))
          {
            localObject1 = this.irs;
            localObject2 = this.irj;
            if (paramm != null)
            {
              ((a)localObject1).iqo.clear();
              ((a)localObject1).iqo.addAll(paramm);
              ((a)localObject1).irj.putAll((Map)localObject2);
            }
          }
          this.irs.notifyDataSetChanged();
          if (((CardInfo)paramString.get(0)).aze()) {
            this.ily = true;
          }
          this.irq.setVisibility(0);
          if (this.irs.getCount() <= 0) {
            break label856;
          }
          paramString = this.irs.oV(0);
          com.tencent.mm.plugin.card.d.m.a(this, paramString);
          this.irp.setBackgroundColor(l.yR(paramString.azx().color));
          com.tencent.mm.ui.statusbar.a.d(this.mController.contentView, l.yR(paramString.azx().color), true);
          this.irt.setVisibility(0);
          paramm = new StateListDrawable();
          paramInt1 = getResources().getDimensionPixelOffset(a.b.card_member_widget_bg_round_radius);
          if (this.inA != 1) {
            break label706;
          }
          this.ipP.setEnabled(true);
          localObject1 = l.cx(l.yR(paramString.azx().color), paramInt1);
          Object localObject2 = l.cx(l.bq(paramString.azx().color, 175), paramInt1);
          paramm.addState(new int[] { 16842919 }, (Drawable)localObject2);
          paramm.addState(new int[0], (Drawable)localObject1);
          label462:
          this.ipP.setBackgroundDrawable(paramm);
          if (!TextUtils.isEmpty(this.inB)) {
            this.ipP.setText(this.inB);
          }
          if (this.inC != 1) {
            break label757;
          }
          paramInt1 = getResources().getDimensionPixelOffset(a.b.NormalPadding);
          paramm = l.b(this, getResources().getColor(a.a.white), paramInt1);
          localObject1 = l.cx(getResources().getColor(a.a.white), paramInt1);
          localObject2 = new StateListDrawable();
          ((StateListDrawable)localObject2).addState(new int[] { 16842919 }, (Drawable)localObject1);
          ((StateListDrawable)localObject2).addState(new int[0], paramm);
          this.irw.setBackgroundDrawable((Drawable)localObject2);
          paramInt1 = l.yR(paramString.azx().color);
          paramInt2 = getResources().getColor(a.a.white);
          paramString = new ColorStateList(new int[][] { { 16842919, 16842910 }, new int[0] }, new int[] { paramInt1, paramInt2 });
          this.irw.setTextColor(paramString);
          this.iru.setVisibility(0);
          if (TextUtils.isEmpty(this.inD)) {
            break label746;
          }
          this.irv.setText(this.inD);
        }
      }
    }
    label706:
    label746:
    label757:
    do
    {
      do
      {
        return;
        y.e("MicroMsg.CardAcceptCardListUI", "The card info list size is 0!");
        break;
        this.ipP.setEnabled(false);
        localObject1 = l.cx(l.bq(paramString.azx().color, 175), paramInt1);
        paramm.addState(new int[0], (Drawable)localObject1);
        break label462;
        this.irv.setText(a.g.card_share_card_private_setting);
        return;
        this.iru.setVisibility(8);
        paramString = (RelativeLayout.LayoutParams)this.irq.getLayoutParams();
        paramString.topMargin = getResources().getDimensionPixelSize(a.b.SmallPadding);
        paramString.bottomMargin = getResources().getDimensionPixelSize(a.b.LargestPadding);
        this.irq.setLayoutParams(paramString);
        this.irq.invalidate();
        paramString = (RelativeLayout.LayoutParams)this.irt.getLayoutParams();
        paramString.addRule(8, a.d.list_layout);
        this.irt.setLayoutParams(paramString);
        this.irt.invalidate();
        return;
        this.irt.setVisibility(8);
        this.iru.setVisibility(8);
        this.irp.setBackgroundColor(getResources().getColor(a.a.card_bg_color));
        return;
        if ((paramm instanceof com.tencent.mm.plugin.card.model.p))
        {
          ew(false);
          localObject1 = (com.tencent.mm.plugin.card.model.p)paramm;
          if (((com.tencent.mm.plugin.card.model.p)localObject1).ino != 0)
          {
            paramm = ((com.tencent.mm.plugin.card.model.p)localObject1).inp;
            paramString = paramm;
            if (TextUtils.isEmpty(paramm)) {
              paramString = getString(a.g.card_add_fail);
            }
            com.tencent.mm.ui.base.h.a(this, paramString, null, false, new CardAcceptCardListUI.5(this));
            this.inz = ((com.tencent.mm.plugin.card.model.p)localObject1).inn;
            return;
          }
          com.tencent.mm.ui.base.h.bC(this, getResources().getString(a.g.card_has_accept_tips));
          paramString = new Intent();
          paramString.putExtra("card_list", ((com.tencent.mm.plugin.card.model.p)localObject1).inn);
          setResult(-1, paramString);
          y.i("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI setResult RESULT_OK for card");
          l.aDc();
          finish();
          return;
        }
      } while (!(paramm instanceof com.tencent.mm.plugin.card.sharecard.model.g));
      ew(false);
      paramString = ((com.tencent.mm.plugin.card.sharecard.model.g)paramm).inn;
      paramInt1 = ((com.tencent.mm.plugin.card.sharecard.model.g)paramm).ino;
      paramm = ((com.tencent.mm.plugin.card.sharecard.model.g)paramm).inp;
      this.inz = paramString;
      if (paramInt1 != 0)
      {
        paramString = paramm;
        if (TextUtils.isEmpty(paramm)) {
          paramString = getString(a.g.card_share_fail);
        }
        com.tencent.mm.ui.base.h.a(this, paramString, null, false, new CardAcceptCardListUI.6(this));
        return;
      }
      com.tencent.mm.ui.base.h.bC(this, getResources().getString(a.g.card_accept_success_tips));
      paramm = new Intent();
      paramm.putExtra("card_list", this.inz);
      setResult(-1, paramm);
      y.i("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI setResult RESULT_OK for sharecard");
      l.aDe();
      paramm = new ShareCardInfo();
      com.tencent.mm.plugin.card.d.f.a(paramm, paramString);
      l.a(paramm);
      am.aAz().axs();
      finish();
      return;
      y.e("MicroMsg.CardAcceptCardListUI", "CardAddEntranceUI onSceneEnd() netsene type" + paramm.getType() + "errType = " + paramInt1 + " errCode = " + paramInt2);
      ew(false);
      d.b(this, paramString, paramInt2);
      if ((paramm instanceof com.tencent.mm.plugin.card.model.p))
      {
        this.inz = paramString;
        return;
      }
    } while (!(paramm instanceof com.tencent.mm.plugin.card.sharecard.model.g));
    label856:
    this.inz = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardAcceptCardListUI
 * JD-Core Version:    0.7.0.1
 */