package com.tencent.mm.plugin.fts.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.api.m;
import com.tencent.mm.g.a.am;
import com.tencent.mm.g.a.am.b;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.fts.ui.widget.FTSLocalPageRelevantView;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.ac;
import com.tencent.mm.plugin.websearch.api.ak;
import com.tencent.mm.protocal.protobuf.cnl;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.FTSEditTextView.b;
import com.tencent.mm.ui.search.a.c;
import java.util.List;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(3)
public class FTSAddFriendUI
  extends FTSBaseUI
{
  private final com.tencent.mm.al.g callback;
  private long kOJ;
  private long lVv;
  private Dialog oWF;
  private cnl pKw;
  private View rsT;
  private View rsU;
  private View rsV;
  private View rsW;
  private View rsX;
  private View rsY;
  private View rsZ;
  private ImageView rta;
  private TextView rtb;
  private TextView rtc;
  private TextView rtd;
  private TextView rte;
  private TextView rtf;
  private boolean rtg;
  protected boolean rth;
  private int rti;
  private FTSLocalPageRelevantView rtj;
  private c rtk;
  private int rtl;
  private int rtm;
  private String rtn;
  int rto;
  
  public FTSAddFriendUI()
  {
    AppMethodBeat.i(111826);
    this.rti = 1;
    this.callback = new FTSAddFriendUI.5(this);
    this.rto = -1;
    AppMethodBeat.o(111826);
  }
  
  private void abt(final String paramString)
  {
    AppMethodBeat.i(111838);
    this.rtg = true;
    this.rth = false;
    this.rti = 1;
    if ((paramString == null) || (paramString.length() == 0) || (paramString.trim().length() == 0))
    {
      AppMethodBeat.o(111838);
      return;
    }
    if (Character.isDigit(paramString.charAt(0))) {}
    for (int i = 15;; i = 3)
    {
      this.rto = i;
      this.rtl = 0;
      this.rtm = 0;
      com.tencent.mm.kernel.g.aeS().a(106, this.callback);
      paramString = new com.tencent.mm.plugin.messenger.a.g(paramString, 3);
      com.tencent.mm.kernel.g.aeS().a(paramString, 0);
      getString(2131755906);
      this.oWF = com.tencent.mm.ui.base.h.b(this, getString(2131762915), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(111823);
          com.tencent.mm.kernel.g.aeS().a(paramString);
          com.tencent.mm.kernel.g.aeS().b(106, FTSAddFriendUI.i(FTSAddFriendUI.this));
          FTSAddFriendUI.j(FTSAddFriendUI.this);
          AppMethodBeat.o(111823);
        }
      });
      AppMethodBeat.o(111838);
      return;
    }
  }
  
  private void cxO()
  {
    AppMethodBeat.i(111836);
    if (bt.nullAsNil(z.a(this.pKw.Dby)).length() > 0)
    {
      if (2 != this.pKw.EhQ) {
        break label129;
      }
      this.rto = 15;
    }
    for (;;)
    {
      Intent localIntent = new Intent();
      ((m)com.tencent.mm.kernel.g.ab(m.class)).a(localIntent, this.pKw, this.rto);
      if ((this.rto == 15) && (2 == this.pKw.EhQ)) {
        localIntent.putExtra("Contact_Search_Mobile", this.rtn);
      }
      localIntent.putExtra("add_more_friend_search_scene", 2);
      com.tencent.mm.bs.d.b(this, "profile", ".ui.ContactInfoUI", localIntent);
      AppMethodBeat.o(111836);
      return;
      label129:
      if (1 == this.pKw.EhQ) {
        this.rto = 1;
      }
    }
  }
  
  private void cxP()
  {
    AppMethodBeat.i(111839);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(111825);
        if (FTSAddFriendUI.k(FTSAddFriendUI.this) != null)
        {
          FTSAddFriendUI.k(FTSAddFriendUI.this).dismiss();
          FTSAddFriendUI.j(FTSAddFriendUI.this);
        }
        AppMethodBeat.o(111825);
      }
    });
    AppMethodBeat.o(111839);
  }
  
  protected final d a(e parame)
  {
    AppMethodBeat.i(111830);
    if (this.rtk == null) {
      this.rtk = new c(parame);
    }
    parame = this.rtk;
    AppMethodBeat.o(111830);
    return parame;
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(111831);
    if ((parama instanceof com.tencent.mm.plugin.fts.ui.a.a))
    {
      if (System.currentTimeMillis() - this.lVv <= 1000L)
      {
        AppMethodBeat.o(111831);
        return;
      }
      this.lVv = System.currentTimeMillis();
      abt(parama.roS.rpq);
    }
    AppMethodBeat.o(111831);
  }
  
  public final void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.b paramb)
  {
    AppMethodBeat.i(168765);
    super.a(paramString1, paramString2, paramList, paramb);
    this.rtg = false;
    AppMethodBeat.o(168765);
  }
  
  public final boolean bow()
  {
    AppMethodBeat.i(111833);
    abt(this.query);
    hideVKB();
    AppMethodBeat.o(111833);
    return true;
  }
  
  protected final void cxN()
  {
    AppMethodBeat.i(111834);
    super.cxN();
    this.rsU.setVisibility(8);
    AppMethodBeat.o(111834);
  }
  
  public int getLayoutId()
  {
    return 2131494185;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(111829);
    finish();
    AppMethodBeat.o(111829);
  }
  
  public void onClickClearTextBtn(View paramView)
  {
    AppMethodBeat.i(111840);
    super.onClickClearTextBtn(paramView);
    if (!this.rtD.getFtsEditText().sz.hasFocus())
    {
      this.rtD.getFtsEditText().fdj();
      showVKB();
    }
    AppMethodBeat.o(111840);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(111827);
    super.onCreate(paramBundle);
    com.tencent.mm.plugin.fts.a.e.rob = com.tencent.mm.plugin.fts.a.d.DB(16);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle = TransitionInflater.from(this).inflateTransition(17760258);
      paramBundle.excludeTarget(getWindow().getDecorView().findViewById(2131296345), true);
      paramBundle.excludeTarget(16908335, true);
      getWindow().setEnterTransition(paramBundle);
    }
    setActionbarColor(getContext().getResources().getColor(2131100705));
    setHint(getContext().getResources().getString(2131757917));
    this.rsT = findViewById(2131297205);
    this.rsU = findViewById(2131298588);
    this.rsV = findViewById(2131300681);
    this.rsZ = findViewById(2131298589);
    this.rsW = findViewById(2131302876);
    this.rsX = findViewById(2131302252);
    this.rsY = findViewById(2131304408);
    this.rtj = ((FTSLocalPageRelevantView)findViewById(2131303972));
    this.rta = ((ImageView)findViewById(2131298585));
    this.rtb = ((TextView)findViewById(2131298716));
    this.rtc = ((TextView)findViewById(2131298593));
    this.rtd = ((TextView)findViewById(2131304451));
    this.rte = ((TextView)findViewById(2131298594));
    this.rtf = ((TextView)findViewById(2131304410));
    try
    {
      paramBundle = ac.ave("webSearchBar").optString("wording");
      ad.i("MicroMsg.FTS.FTSAddFriendUI", "set searchNetworkTips %s", new Object[] { paramBundle });
      this.rtf.setText(paramBundle);
      label320:
      getContentView().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(111818);
          FTSAddFriendUI.this.rtD.getFtsEditText().fdj();
          FTSAddFriendUI.this.rtD.getFtsEditText().fdi();
          AppMethodBeat.o(111818);
        }
      }, 128L);
      this.rsT.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(111819);
          FTSAddFriendUI.this.finish();
          AppMethodBeat.o(111819);
        }
      });
      AppMethodBeat.o(111827);
      return;
    }
    catch (Exception paramBundle)
    {
      break label320;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(111837);
    super.onDestroy();
    com.tencent.mm.kernel.g.aeS().b(106, this.callback);
    if ((this.rtg) && (!this.rth)) {
      ak.p(this.query, this.rti, 3, 16);
    }
    AppMethodBeat.o(111837);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(111828);
    super.onResume();
    aa.ehT();
    AppMethodBeat.o(111828);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected final void stopSearch()
  {
    AppMethodBeat.i(111835);
    super.stopSearch();
    this.rsU.setVisibility(8);
    AppMethodBeat.o(111835);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSAddFriendUI
 * JD-Core Version:    0.7.0.1
 */