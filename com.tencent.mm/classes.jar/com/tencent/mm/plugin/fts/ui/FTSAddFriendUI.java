package com.tencent.mm.plugin.fts.ui;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ah.p;
import com.tencent.mm.api.i;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView.b;
import com.tencent.mm.plugin.fts.ui.widget.FTSLocalPageRelevantView;
import com.tencent.mm.plugin.fts.ui.widget.a.b;
import com.tencent.mm.plugin.messenger.a.f;
import com.tencent.mm.plugin.websearch.api.ac;
import com.tencent.mm.plugin.websearch.api.ao;
import com.tencent.mm.protocal.c.bnm;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;
import java.util.List;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(3)
public class FTSAddFriendUI
  extends FTSBaseUI
{
  private long gMG;
  private String iSX = "";
  private bnm jJM;
  private Dialog jwv;
  protected boolean kAA;
  private int kAB = 1;
  private FTSLocalPageRelevantView kAC;
  private c kAD;
  private long kAE;
  private int kAF;
  private int kAG;
  int kAH = -1;
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
      FTSAddFriendUI.5 local5 = new FTSAddFriendUI.5(this);
      this.kAF = 0;
      this.kAG = 0;
      com.tencent.mm.kernel.g.Dk().a(106, local5);
      paramString = new f(paramString, 3);
      com.tencent.mm.kernel.g.Dk().a(paramString, 0);
      getString(n.g.app_tip);
      this.jwv = h.b(this, getString(n.g.search_contact_doing), true, new FTSAddFriendUI.6(this, paramString, local5));
      return;
    }
  }
  
  private void aVX()
  {
    if (bk.pm(com.tencent.mm.platformtools.aa.a(this.jJM.sQs)).length() > 0)
    {
      if (2 != this.jJM.tGq) {
        break label118;
      }
      this.kAH = 15;
    }
    for (;;)
    {
      Intent localIntent = new Intent();
      ((i)com.tencent.mm.kernel.g.r(i.class)).a(localIntent, this.jJM, this.kAH);
      if ((this.kAH == 15) && (2 == this.jJM.tGq)) {
        localIntent.putExtra("Contact_Search_Mobile", this.iSX.trim());
      }
      localIntent.putExtra("add_more_friend_search_scene", 2);
      com.tencent.mm.br.d.b(this, "profile", ".ui.ContactInfoUI", localIntent);
      return;
      label118:
      if (1 == this.jJM.tGq) {
        this.kAH = 1;
      }
    }
  }
  
  private void aVY()
  {
    ai.d(new FTSAddFriendUI.8(this));
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
    finish();
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
    com.tencent.mm.plugin.fts.a.e.kvx = com.tencent.mm.plugin.websearch.api.aa.Bm(16);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle = TransitionInflater.from(this).inflateTransition(17760258);
      paramBundle.excludeTarget(getWindow().getDecorView().findViewById(n.d.action_bar_container), true);
      paramBundle.excludeTarget(16908335, true);
      getWindow().setEnterTransition(paramBundle);
    }
    ta(this.mController.uMN.getResources().getColor(n.a.normal_actionbar_color));
    czo();
    setHint(this.mController.uMN.getResources().getString(n.g.contact_search_account_hint));
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
      label324:
      this.mController.contentView.postDelayed(new FTSAddFriendUI.1(this), 128L);
      this.kAm.setOnClickListener(new FTSAddFriendUI.2(this));
      return;
    }
    catch (Exception paramBundle)
    {
      break label324;
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
    com.tencent.mm.plugin.websearch.api.aa.bZu();
  }
  
  protected final void stopSearch()
  {
    super.stopSearch();
    this.kAn.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSAddFriendUI
 * JD-Core Version:    0.7.0.1
 */