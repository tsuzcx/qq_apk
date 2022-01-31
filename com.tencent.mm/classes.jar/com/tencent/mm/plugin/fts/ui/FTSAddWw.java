package com.tencent.mm.plugin.fts.ui;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ah.p;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView.b;
import com.tencent.mm.plugin.fts.ui.widget.FTSLocalPageRelevantView;
import com.tencent.mm.plugin.fts.ui.widget.a.b;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.ac;
import com.tencent.mm.plugin.websearch.api.ao;
import com.tencent.mm.protocal.c.bbe;
import com.tencent.mm.protocal.c.bob;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.e.a;
import com.tencent.mm.ui.s;
import java.util.List;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(3)
public class FTSAddWw
  extends FTSBaseUI
{
  private String fKV = "";
  private String iSX = "";
  private Dialog jwv;
  protected boolean kAA;
  private int kAB = 1;
  private FTSLocalPageRelevantView kAC;
  private c kAD;
  private long kAE;
  private int kAF;
  private int kAG;
  int kAH = -1;
  private bob kAL;
  private View kAm;
  private View kAn;
  private View kAo;
  private View kAp;
  private View kAq;
  private View kAr;
  private View kAs;
  private ImageView kAt;
  private TextView kAu;
  private TextView kAv;
  private TextView kAw;
  private TextView kAx;
  private TextView kAy;
  private boolean kAz;
  
  private void Ei(String paramString)
  {
    this.kAz = true;
    this.kAA = false;
    this.kAB = 1;
    if ((paramString == null) || (paramString.length() == 0) || (paramString.trim().length() == 0)) {
      return;
    }
    if (Character.isDigit(paramString.charAt(0))) {}
    for (int i = 15;; i = 3)
    {
      this.kAH = i;
      FTSAddWw.5 local5 = new FTSAddWw.5(this);
      this.kAF = 0;
      this.kAG = 0;
      com.tencent.mm.kernel.g.Dk().a(372, local5);
      paramString = new com.tencent.mm.openim.b.n(paramString);
      com.tencent.mm.kernel.g.Dk().a(paramString, 0);
      getString(n.g.app_tip);
      this.jwv = h.b(this, getString(n.g.search_contact_doing), true, new FTSAddWw.6(this, paramString, local5));
      return;
    }
  }
  
  private void aVX()
  {
    String str = this.kAL.hPY;
    if (bk.pm(str).length() > 0)
    {
      if (2 != this.kAL.tGq) {
        break label230;
      }
      this.kAH = 15;
    }
    for (;;)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("Contact_User", str);
      localIntent.putExtra(e.a.uHO, this.kAL.tac);
      if ((this.kAH == 15) && (2 == this.kAL.tGq)) {
        localIntent.putExtra("Contact_Search_Mobile", this.iSX.trim());
      }
      localIntent.putExtra("Contact_Nick", this.kAL.hRf);
      localIntent.putExtra("Contact_PyInitial", this.kAL.sPp);
      localIntent.putExtra("Contact_QuanPin", this.kAL.sPq);
      localIntent.putExtra("Contact_Sex", this.kAL.ffh);
      localIntent.putExtra("key_add_contact_custom_detail_visible", this.kAL.tGH.txn);
      localIntent.putExtra("key_add_contact_custom_detail", this.kAL.tGH.kSY);
      localIntent.putExtra("Contact_Scene", this.kAH);
      localIntent.putExtra("key_ww_add_session_id", this.fKV);
      localIntent.putExtra("add_more_friend_search_scene", 2);
      com.tencent.mm.br.d.b(this, "profile", ".ui.ContactInfoUI", localIntent);
      return;
      label230:
      if (1 == this.kAL.tGq) {
        this.kAH = 1;
      }
    }
  }
  
  private void aVY()
  {
    ai.d(new FTSAddWw.7(this));
  }
  
  protected final d a(e parame)
  {
    if (this.kAD == null) {
      this.kAD = new c(parame);
    }
    return this.kAD;
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.a.a parama)
  {
    if ((!(parama instanceof com.tencent.mm.plugin.fts.ui.a.a)) || (System.currentTimeMillis() - this.kAE <= 1000L)) {
      return;
    }
    this.kAE = System.currentTimeMillis();
    this.iSX = parama.kwi.kwG;
    Ei(parama.kwi.kwG);
    parama = new com.tencent.mm.h.b.a.n();
    parama.ciW = this.fKV;
    parama.ciX = 1L;
    parama.QX();
  }
  
  public final void a(String paramString1, String paramString2, List<a.b> paramList, FTSEditTextView.b paramb)
  {
    super.a(paramString1, paramString2, paramList, paramb);
    this.kAz = false;
  }
  
  protected final void aVW()
  {
    super.aVW();
    this.kAn.setVisibility(8);
  }
  
  protected final void aVZ()
  {
    super.aVZ();
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        paramAnonymousMenuItem = new com.tencent.mm.h.b.a.n();
        paramAnonymousMenuItem.ciW = FTSAddWw.a(FTSAddWw.this);
        paramAnonymousMenuItem.ciX = 2L;
        paramAnonymousMenuItem.QX();
        FTSAddWw.this.finish();
        return true;
      }
    });
  }
  
  public final boolean apb()
  {
    Ei(this.bVk);
    XM();
    return true;
  }
  
  protected final int getLayoutId()
  {
    return n.e.fts_add_friend_ui;
  }
  
  public void onBackPressed()
  {
    com.tencent.mm.h.b.a.n localn = new com.tencent.mm.h.b.a.n();
    localn.ciW = this.fKV;
    localn.ciX = 2L;
    localn.QX();
    finish();
  }
  
  public void onClickBackBtn(View paramView)
  {
    super.onClickBackBtn(paramView);
    paramView = new com.tencent.mm.h.b.a.n();
    paramView.ciW = this.fKV;
    paramView.ciX = 2L;
    paramView.QX();
  }
  
  public void onClickClearTextBtn(View paramView)
  {
    super.onClickClearTextBtn(paramView);
    if (!this.kAW.getFtsEditText().kEp.hasFocus())
    {
      this.kAW.getFtsEditText().aWy();
      showVKB();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.fKV = com.tencent.xweb.util.c.o(System.currentTimeMillis().getBytes());
    com.tencent.mm.plugin.fts.a.e.kvx = aa.Bm(16);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle = TransitionInflater.from(this).inflateTransition(17760258);
      paramBundle.excludeTarget(getWindow().getDecorView().findViewById(n.d.action_bar_container), true);
      paramBundle.excludeTarget(16908335, true);
      getWindow().setEnterTransition(paramBundle);
    }
    ta(this.mController.uMN.getResources().getColor(n.a.normal_actionbar_color));
    czo();
    setHint(this.mController.uMN.getResources().getString(n.g.contact_search_ww_account_hint));
    this.kAm = findViewById(n.d.bg_layout);
    this.kAn = findViewById(n.d.contact_biz_merge_layout);
    this.kAo = findViewById(n.d.has_contact_layout);
    this.kAs = findViewById(n.d.contact_click_layout);
    this.kAp = findViewById(n.d.no_contact_layout);
    this.kAq = findViewById(n.d.merge_layout_divider);
    this.kAr = findViewById(n.d.search_content_layout);
    this.kAC = ((FTSLocalPageRelevantView)findViewById(n.d.relevant_serach_query));
    this.kAt = ((ImageView)findViewById(n.d.contact_avatar_iv));
    this.kAu = ((TextView)findViewById(n.d.contact_title_tv));
    this.kAv = ((TextView)findViewById(n.d.contact_desc_tv));
    this.kAw = ((TextView)findViewById(n.d.search_title_tv));
    this.kAx = ((TextView)findViewById(n.d.contact_error_tv));
    this.kAy = ((TextView)findViewById(n.d.search_desc_tv));
    try
    {
      paramBundle = ac.Ru("webSearchBar").optString("wording");
      y.i("MicroMsg.FTS.FTSAddFriendUI", "set searchNetworkTips %s", new Object[] { paramBundle });
      this.kAy.setText(paramBundle);
      label351:
      this.mController.contentView.postDelayed(new Runnable()
      {
        public final void run()
        {
          FTSAddWw.this.kAW.getFtsEditText().aWy();
          FTSAddWw.this.kAW.getFtsEditText().aWx();
        }
      }, 128L);
      this.kAm.setOnClickListener(new FTSAddWw.2(this));
      return;
    }
    catch (Exception paramBundle)
    {
      break label351;
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if ((this.kAz) && (!this.kAA)) {
      ao.i(this.bVk, this.kAB, 3, 16);
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    aa.bZu();
  }
  
  protected final void stopSearch()
  {
    super.stopSearch();
    com.tencent.mm.h.b.a.n localn = new com.tencent.mm.h.b.a.n();
    localn.ciW = this.fKV;
    localn.ciX = 3L;
    localn.QX();
    this.kAn.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSAddWw
 * JD-Core Version:    0.7.0.1
 */