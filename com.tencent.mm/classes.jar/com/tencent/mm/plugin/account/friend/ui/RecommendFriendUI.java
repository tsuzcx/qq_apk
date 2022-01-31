package com.tencent.mm.plugin.account.friend.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.aa;
import com.tencent.mm.protocal.protobuf.aee;
import com.tencent.mm.protocal.protobuf.bfz;
import com.tencent.mm.protocal.protobuf.bgc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;
import junit.framework.Assert;

public class RecommendFriendUI
  extends MMActivity
  implements f
{
  private ProgressDialog eeN;
  private b gAa;
  private ListView gAb;
  private TextView gAc;
  private LinkedList<bgc> gAd;
  private int gAe;
  private boolean gAf;
  private LinkedList<aee> gzh;
  private boolean gzi;
  
  public RecommendFriendUI()
  {
    AppMethodBeat.i(108634);
    this.eeN = null;
    this.gAd = new LinkedList();
    this.gzh = new LinkedList();
    this.gAe = -1;
    this.gAf = false;
    AppMethodBeat.o(108634);
  }
  
  private void aqV()
  {
    AppMethodBeat.i(108642);
    this.gAc.setVisibility(0);
    this.gAb.setVisibility(8);
    AppMethodBeat.o(108642);
  }
  
  private void aqW()
  {
    AppMethodBeat.i(108644);
    if (this.gAe == 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("dealGetInviteFriendGroupSuccess just only qq", bool);
      ab.i("MicroMsg.RecommendFriendUI", "dealGetInviteFriendGroupSuccess  respList.size:" + this.gzh.size());
      this.gAa.gzh = this.gzh;
      this.gAb.setAdapter(this.gAa);
      showOptionMenu(false);
      this.gzi = true;
      setMMTitle(2131303279);
      this.gAa.gzi = this.gzi;
      this.gAa.notifyDataSetChanged();
      AppMethodBeat.o(108644);
      return;
    }
  }
  
  private void goBack()
  {
    AppMethodBeat.i(108637);
    if (this.gAe != 0)
    {
      finish();
      AppMethodBeat.o(108637);
      return;
    }
    if ((this.gzi) || (this.gAf))
    {
      finish();
      AppMethodBeat.o(108637);
      return;
    }
    aqW();
    AppMethodBeat.o(108637);
  }
  
  private void mX(int paramInt)
  {
    AppMethodBeat.i(108643);
    ab.i("MicroMsg.RecommendFriendUI", "dealGetInviteFriendSuccess  respList.size:" + this.gAd.size());
    this.gAa.a(this.gAd, paramInt);
    this.gAb.setAdapter(this.gAa);
    this.gzi = false;
    String str;
    int i;
    if (this.gAe == 0)
    {
      str = "";
      i = 0;
      if (i < this.gzh.size())
      {
        if (paramInt != ((aee)this.gzh.get(i)).wRe) {
          break label152;
        }
        str = ((aee)this.gzh.get(i)).wXb;
      }
    }
    label152:
    for (;;)
    {
      i += 1;
      break;
      setMMTitle(str);
      this.gAa.gzi = this.gzi;
      this.gAa.notifyDataSetChanged();
      AppMethodBeat.o(108643);
      return;
    }
  }
  
  public int getLayoutId()
  {
    return 2130969912;
  }
  
  public void initView()
  {
    AppMethodBeat.i(108640);
    this.gAc = ((TextView)findViewById(2131825157));
    if (this.gAe == 1)
    {
      setMMTitle(2131303394);
      this.gAc.setText(2131303398);
    }
    for (;;)
    {
      this.gAa = new b(getLayoutInflater());
      this.gAb = ((ListView)findViewById(2131825156));
      this.gAb.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          int i = 0;
          AppMethodBeat.i(108627);
          if (!RecommendFriendUI.a(RecommendFriendUI.this))
          {
            RecommendFriendUI.b(RecommendFriendUI.this).mW(paramAnonymousInt);
            if (RecommendFriendUI.b(RecommendFriendUI.this).aqU().length > 0)
            {
              RecommendFriendUI.this.showOptionMenu(true);
              AppMethodBeat.o(108627);
              return;
            }
            RecommendFriendUI.this.showOptionMenu(false);
            AppMethodBeat.o(108627);
            return;
          }
          paramAnonymousAdapterView = RecommendFriendUI.this;
          paramAnonymousView = RecommendFriendUI.b(RecommendFriendUI.this);
          if (!paramAnonymousView.gzi) {}
          for (paramAnonymousInt = i;; paramAnonymousInt = ((aee)paramAnonymousView.gzh.get(paramAnonymousInt)).wRe)
          {
            RecommendFriendUI.a(paramAnonymousAdapterView, paramAnonymousInt);
            AppMethodBeat.o(108627);
            return;
          }
        }
      });
      this.gAb.setAdapter(this.gAa);
      addTextOptionMenu(0, getString(2131300773), new RecommendFriendUI.2(this));
      showOptionMenu(false);
      this.gAf = true;
      aa localaa = new aa(this.gAe);
      g.Rc().a(localaa, 0);
      AppCompatActivity localAppCompatActivity = getContext();
      getString(2131297087);
      this.eeN = h.b(localAppCompatActivity, getString(2131300776), true, new RecommendFriendUI.5(this, localaa));
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(108630);
          RecommendFriendUI.d(RecommendFriendUI.this);
          AppMethodBeat.o(108630);
          return true;
        }
      });
      setToTop(new RecommendFriendUI.4(this));
      AppMethodBeat.o(108640);
      return;
      if (this.gAe == 2)
      {
        setMMTitle(2131303393);
        this.gAc.setText(2131303397);
      }
      else
      {
        setMMTitle(2131303279);
        this.gAc.setText(2131303399);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(108635);
    super.onCreate(paramBundle);
    this.gAe = bo.getInt(getIntent().getStringExtra("recommend_type"), 0);
    this.gzi = false;
    g.Rc().a(135, this);
    initView();
    AppMethodBeat.o(108635);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(108639);
    g.Rc().b(135, this);
    super.onDestroy();
    AppMethodBeat.o(108639);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(108638);
    if (paramInt == 4)
    {
      goBack();
      AppMethodBeat.o(108638);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(108638);
    return bool;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(108641);
    ab.i("MicroMsg.RecommendFriendUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.eeN != null)
    {
      this.eeN.dismiss();
      this.eeN = null;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0) || (paramm.getType() != 135))
    {
      aqV();
      AppMethodBeat.o(108641);
      return;
    }
    this.gAd = ((bfz)((aa)paramm).rr.fsW.fta).ntS;
    this.gzh = ((bfz)((aa)paramm).rr.fsW.fta).GroupList;
    this.gAf = false;
    if (this.gAd.size() <= 0)
    {
      aqV();
      AppMethodBeat.o(108641);
      return;
    }
    if ((this.gAe == 0) && (this.gzh.size() <= 0))
    {
      aqV();
      AppMethodBeat.o(108641);
      return;
    }
    if (this.gAe != 0)
    {
      mX(-1);
      AppMethodBeat.o(108641);
      return;
    }
    aqW();
    AppMethodBeat.o(108641);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.RecommendFriendUI
 * JD-Core Version:    0.7.0.1
 */