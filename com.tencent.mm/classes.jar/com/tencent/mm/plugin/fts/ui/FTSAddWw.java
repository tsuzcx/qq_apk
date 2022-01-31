package com.tencent.mm.plugin.fts.ui;

import android.app.Activity;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.b.a.w;
import com.tencent.mm.openim.b.n;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView.b;
import com.tencent.mm.plugin.fts.ui.widget.FTSLocalPageRelevantView;
import com.tencent.mm.plugin.fts.ui.widget.a.c;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.ac;
import com.tencent.mm.plugin.websearch.api.an;
import com.tencent.mm.protocal.protobuf.bie;
import com.tencent.mm.protocal.protobuf.bxw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.e.b;
import java.util.List;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(3)
public class FTSAddWw
  extends FTSBaseUI
{
  private f callback;
  private long jfp;
  private Dialog lFU;
  private String lbI = "";
  private String mSessionId = "";
  private bxw mWD;
  private View mWe;
  private View mWf;
  private View mWg;
  private View mWh;
  private View mWi;
  private View mWj;
  private View mWk;
  private ImageView mWl;
  private TextView mWm;
  private TextView mWn;
  private TextView mWo;
  private TextView mWp;
  private TextView mWq;
  private boolean mWr;
  protected boolean mWs;
  private int mWt = 1;
  private FTSLocalPageRelevantView mWu;
  private c mWv;
  private int mWw;
  private int mWx;
  int mWz = -1;
  
  private void Pt(String paramString)
  {
    AppMethodBeat.i(61773);
    this.mWr = true;
    this.mWs = false;
    this.mWt = 1;
    if ((paramString == null) || (paramString.length() == 0) || (paramString.trim().length() == 0))
    {
      AppMethodBeat.o(61773);
      return;
    }
    if (Character.isDigit(paramString.charAt(0))) {}
    for (int i = 15;; i = 3)
    {
      this.mWz = i;
      this.callback = new FTSAddWw.5(this);
      this.mWw = 0;
      this.mWx = 0;
      com.tencent.mm.kernel.g.Rc().a(372, this.callback);
      paramString = new n(paramString);
      com.tencent.mm.kernel.g.Rc().a(paramString, 0);
      getString(2131297087);
      this.lFU = h.b(this, getString(2131302977), true, new FTSAddWw.6(this, paramString));
      AppMethodBeat.o(61773);
      return;
    }
  }
  
  private void bCA()
  {
    AppMethodBeat.i(61771);
    String str = this.mWD.jJA;
    if (bo.nullAsNil(str).length() > 0)
    {
      if (2 != this.mWD.xKf) {
        break label254;
      }
      this.mWz = 15;
    }
    for (;;)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("Contact_User", str);
      localIntent.putExtra(e.b.yUZ, this.mWD.wYu);
      if ((this.mWz == 15) && (2 == this.mWD.xKf)) {
        localIntent.putExtra("Contact_Search_Mobile", this.lbI.trim());
      }
      localIntent.putExtra("key_add_contact_openim_appid", this.mWD.fKw);
      localIntent.putExtra("Contact_Nick", this.mWD.jKG);
      localIntent.putExtra("Contact_PyInitial", this.mWD.wNI);
      localIntent.putExtra("Contact_QuanPin", this.mWD.wNJ);
      localIntent.putExtra("Contact_Sex", this.mWD.gwP);
      localIntent.putExtra("key_add_contact_custom_detail_visible", this.mWD.xKv.xxt);
      localIntent.putExtra("key_add_contact_custom_detail", this.mWD.xKv.nqY);
      localIntent.putExtra("Contact_Scene", this.mWz);
      localIntent.putExtra("key_ww_add_session_id", this.mSessionId);
      localIntent.putExtra("add_more_friend_search_scene", 2);
      com.tencent.mm.bq.d.b(this, "profile", ".ui.ContactInfoUI", localIntent);
      AppMethodBeat.o(61771);
      return;
      label254:
      if (1 == this.mWD.xKf) {
        this.mWz = 1;
      }
    }
  }
  
  private void bCB()
  {
    AppMethodBeat.i(61774);
    al.d(new FTSAddWw.7(this));
    AppMethodBeat.o(61774);
  }
  
  protected final d a(e parame)
  {
    AppMethodBeat.i(61765);
    if (this.mWv == null) {
      this.mWv = new c(parame);
    }
    parame = this.mWv;
    AppMethodBeat.o(61765);
    return parame;
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.a.a parama)
  {
    AppMethodBeat.i(61766);
    if ((parama instanceof com.tencent.mm.plugin.fts.ui.a.a))
    {
      if (System.currentTimeMillis() - this.jfp <= 1000L)
      {
        AppMethodBeat.o(61766);
        return;
      }
      this.jfp = System.currentTimeMillis();
      this.lbI = parama.mRX.mSw;
      Pt(parama.mRX.mSw);
      parama = new w();
      parama.fr(this.mSessionId);
      parama.cTG = 1L;
      parama.ake();
    }
    AppMethodBeat.o(61766);
  }
  
  public final void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.b paramb)
  {
    AppMethodBeat.i(61767);
    super.a(paramString1, paramString2, paramList, paramb);
    this.mWr = false;
    AppMethodBeat.o(61767);
  }
  
  public final boolean aMm()
  {
    AppMethodBeat.i(61768);
    Pt(this.query);
    hideVKB();
    AppMethodBeat.o(61768);
    return true;
  }
  
  protected final void bCC()
  {
    AppMethodBeat.i(61762);
    super.bCC();
    setBackBtn(new FTSAddWw.3(this));
    AppMethodBeat.o(61762);
  }
  
  protected final void bCz()
  {
    AppMethodBeat.i(61769);
    super.bCz();
    this.mWf.setVisibility(8);
    AppMethodBeat.o(61769);
  }
  
  public int getLayoutId()
  {
    return 2130969643;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(61764);
    w localw = new w();
    localw.fr(this.mSessionId);
    localw.cTG = 2L;
    localw.ake();
    finish();
    AppMethodBeat.o(61764);
  }
  
  public void onClickBackBtn(View paramView)
  {
    AppMethodBeat.i(61761);
    super.onClickBackBtn(paramView);
    paramView = new w();
    paramView.fr(this.mSessionId);
    paramView.cTG = 2L;
    paramView.ake();
    AppMethodBeat.o(61761);
  }
  
  public void onClickClearTextBtn(View paramView)
  {
    AppMethodBeat.i(61775);
    super.onClickClearTextBtn(paramView);
    if (!this.mWO.getFtsEditText().naN.hasFocus())
    {
      this.mWO.getFtsEditText().bDf();
      showVKB();
    }
    AppMethodBeat.o(61775);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(61760);
    super.onCreate(paramBundle);
    this.mSessionId = com.tencent.xweb.util.d.w(System.currentTimeMillis().getBytes());
    com.tencent.mm.plugin.fts.a.e.mRk = com.tencent.mm.plugin.fts.a.d.wp(16);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle = TransitionInflater.from(this).inflateTransition(17760258);
      paramBundle.excludeTarget(getWindow().getDecorView().findViewById(2131820956), true);
      paramBundle.excludeTarget(16908335, true);
      getWindow().setEnterTransition(paramBundle);
    }
    setActionbarColor(getContext().getResources().getColor(2131690316));
    hideActionbarLine();
    setHint(getContext().getResources().getString(2131298847));
    this.mWe = findViewById(2131824323);
    this.mWf = findViewById(2131824310);
    this.mWg = findViewById(2131824311);
    this.mWk = findViewById(2131824312);
    this.mWh = findViewById(2131824316);
    this.mWi = findViewById(2131824318);
    this.mWj = findViewById(2131824319);
    this.mWu = ((FTSLocalPageRelevantView)findViewById(2131824322));
    this.mWl = ((ImageView)findViewById(2131824313));
    this.mWm = ((TextView)findViewById(2131824314));
    this.mWn = ((TextView)findViewById(2131824315));
    this.mWo = ((TextView)findViewById(2131824320));
    this.mWp = ((TextView)findViewById(2131824317));
    this.mWq = ((TextView)findViewById(2131824321));
    try
    {
      paramBundle = ac.agv("webSearchBar").optString("wording");
      ab.i("MicroMsg.FTS.FTSAddFriendUI", "set searchNetworkTips %s", new Object[] { paramBundle });
      this.mWq.setText(paramBundle);
      label351:
      getContentView().postDelayed(new FTSAddWw.1(this), 128L);
      this.mWe.setOnClickListener(new FTSAddWw.2(this));
      AppMethodBeat.o(61760);
      return;
    }
    catch (Exception paramBundle)
    {
      break label351;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(61772);
    super.onDestroy();
    if ((this.mWr) && (!this.mWs)) {
      an.m(this.query, this.mWt, 3, 16);
    }
    if (this.callback != null) {
      com.tencent.mm.kernel.g.Rc().b(372, this.callback);
    }
    AppMethodBeat.o(61772);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(61763);
    super.onResume();
    aa.cZq();
    AppMethodBeat.o(61763);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected final void stopSearch()
  {
    AppMethodBeat.i(61770);
    super.stopSearch();
    w localw = new w();
    localw.fr(this.mSessionId);
    localw.cTG = 3L;
    localw.ake();
    this.mWf.setVisibility(8);
    AppMethodBeat.o(61770);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSAddWw
 * JD-Core Version:    0.7.0.1
 */