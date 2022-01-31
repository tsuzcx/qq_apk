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
import com.tencent.mm.ai.p;
import com.tencent.mm.api.j;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView.b;
import com.tencent.mm.plugin.fts.ui.widget.FTSLocalPageRelevantView;
import com.tencent.mm.plugin.fts.ui.widget.a.c;
import com.tencent.mm.plugin.websearch.api.ac;
import com.tencent.mm.plugin.websearch.api.an;
import com.tencent.mm.protocal.protobuf.bxh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import java.util.List;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(3)
public class FTSAddFriendUI
  extends FTSBaseUI
{
  private final com.tencent.mm.ai.f callback;
  private long iod;
  private long jfp;
  private Dialog lFU;
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
  private int mWt;
  private FTSLocalPageRelevantView mWu;
  private c mWv;
  private int mWw;
  private int mWx;
  private String mWy;
  int mWz;
  private bxh mdQ;
  
  public FTSAddFriendUI()
  {
    AppMethodBeat.i(61733);
    this.mWt = 1;
    this.callback = new FTSAddFriendUI.5(this);
    this.mWz = -1;
    AppMethodBeat.o(61733);
  }
  
  private void Pt(String paramString)
  {
    AppMethodBeat.i(61745);
    this.mWr = true;
    this.mWs = false;
    this.mWt = 1;
    if ((paramString == null) || (paramString.length() == 0) || (paramString.trim().length() == 0))
    {
      AppMethodBeat.o(61745);
      return;
    }
    if (Character.isDigit(paramString.charAt(0))) {}
    for (int i = 15;; i = 3)
    {
      this.mWz = i;
      this.mWw = 0;
      this.mWx = 0;
      com.tencent.mm.kernel.g.Rc().a(106, this.callback);
      paramString = new com.tencent.mm.plugin.messenger.a.f(paramString, 3);
      com.tencent.mm.kernel.g.Rc().a(paramString, 0);
      getString(2131297087);
      this.lFU = h.b(this, getString(2131302977), true, new FTSAddFriendUI.6(this, paramString));
      AppMethodBeat.o(61745);
      return;
    }
  }
  
  private void bCA()
  {
    AppMethodBeat.i(61743);
    if (bo.nullAsNil(com.tencent.mm.platformtools.aa.a(this.mdQ.wOT)).length() > 0)
    {
      if (2 != this.mdQ.xKf) {
        break label126;
      }
      this.mWz = 15;
    }
    for (;;)
    {
      Intent localIntent = new Intent();
      ((j)com.tencent.mm.kernel.g.E(j.class)).a(localIntent, this.mdQ, this.mWz);
      if ((this.mWz == 15) && (2 == this.mdQ.xKf)) {
        localIntent.putExtra("Contact_Search_Mobile", this.mWy);
      }
      localIntent.putExtra("add_more_friend_search_scene", 2);
      com.tencent.mm.bq.d.b(this, "profile", ".ui.ContactInfoUI", localIntent);
      AppMethodBeat.o(61743);
      return;
      label126:
      if (1 == this.mdQ.xKf) {
        this.mWz = 1;
      }
    }
  }
  
  private void bCB()
  {
    AppMethodBeat.i(61746);
    al.d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(61732);
        if (FTSAddFriendUI.k(FTSAddFriendUI.this) != null)
        {
          FTSAddFriendUI.k(FTSAddFriendUI.this).dismiss();
          FTSAddFriendUI.j(FTSAddFriendUI.this);
        }
        AppMethodBeat.o(61732);
      }
    });
    AppMethodBeat.o(61746);
  }
  
  protected final d a(e parame)
  {
    AppMethodBeat.i(61737);
    if (this.mWv == null) {
      this.mWv = new c(parame);
    }
    parame = this.mWv;
    AppMethodBeat.o(61737);
    return parame;
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.a.a parama)
  {
    AppMethodBeat.i(61738);
    if ((parama instanceof com.tencent.mm.plugin.fts.ui.a.a))
    {
      if (System.currentTimeMillis() - this.jfp <= 1000L)
      {
        AppMethodBeat.o(61738);
        return;
      }
      this.jfp = System.currentTimeMillis();
      Pt(parama.mRX.mSw);
    }
    AppMethodBeat.o(61738);
  }
  
  public final void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.b paramb)
  {
    AppMethodBeat.i(61739);
    super.a(paramString1, paramString2, paramList, paramb);
    this.mWr = false;
    AppMethodBeat.o(61739);
  }
  
  public final boolean aMm()
  {
    AppMethodBeat.i(61740);
    Pt(this.query);
    hideVKB();
    AppMethodBeat.o(61740);
    return true;
  }
  
  protected final void bCz()
  {
    AppMethodBeat.i(61741);
    super.bCz();
    this.mWf.setVisibility(8);
    AppMethodBeat.o(61741);
  }
  
  public int getLayoutId()
  {
    return 2130969643;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(61736);
    finish();
    AppMethodBeat.o(61736);
  }
  
  public void onClickClearTextBtn(View paramView)
  {
    AppMethodBeat.i(61747);
    super.onClickClearTextBtn(paramView);
    if (!this.mWO.getFtsEditText().naN.hasFocus())
    {
      this.mWO.getFtsEditText().bDf();
      showVKB();
    }
    AppMethodBeat.o(61747);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(61734);
    super.onCreate(paramBundle);
    com.tencent.mm.plugin.fts.a.e.mRk = com.tencent.mm.plugin.fts.a.d.wp(16);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle = TransitionInflater.from(this).inflateTransition(17760258);
      paramBundle.excludeTarget(getWindow().getDecorView().findViewById(2131820956), true);
      paramBundle.excludeTarget(16908335, true);
      getWindow().setEnterTransition(paramBundle);
    }
    setActionbarColor(getContext().getResources().getColor(2131690316));
    setHint(getContext().getResources().getString(2131298839));
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
      label320:
      getContentView().postDelayed(new FTSAddFriendUI.1(this), 128L);
      this.mWe.setOnClickListener(new FTSAddFriendUI.2(this));
      AppMethodBeat.o(61734);
      return;
    }
    catch (Exception paramBundle)
    {
      break label320;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(61744);
    super.onDestroy();
    com.tencent.mm.kernel.g.Rc().b(106, this.callback);
    if ((this.mWr) && (!this.mWs)) {
      an.m(this.query, this.mWt, 3, 16);
    }
    AppMethodBeat.o(61744);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(61735);
    super.onResume();
    com.tencent.mm.plugin.websearch.api.aa.cZq();
    AppMethodBeat.o(61735);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected final void stopSearch()
  {
    AppMethodBeat.i(61742);
    super.stopSearch();
    this.mWf.setVisibility(8);
    AppMethodBeat.o(61742);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSAddFriendUI
 * JD-Core Version:    0.7.0.1
 */