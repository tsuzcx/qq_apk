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
import com.tencent.mm.g.a.an;
import com.tencent.mm.g.a.an.b;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.fts.ui.widget.FTSLocalPageRelevantView;
import com.tencent.mm.plugin.websearch.api.af;
import com.tencent.mm.plugin.websearch.api.am;
import com.tencent.mm.protocal.protobuf.cyc;
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
  private final com.tencent.mm.al.f callback;
  private long lND;
  private long mYb;
  private Dialog qdv;
  private cyc rcR;
  private TextView tyA;
  private boolean tyB;
  protected boolean tyC;
  private int tyD;
  private FTSLocalPageRelevantView tyE;
  private c tyF;
  private int tyG;
  private int tyH;
  private String tyI;
  int tyJ;
  private View tyo;
  private View typ;
  private View tyq;
  private View tyr;
  private View tys;
  private View tyt;
  private View tyu;
  private ImageView tyv;
  private TextView tyw;
  private TextView tyx;
  private TextView tyy;
  private TextView tyz;
  
  public FTSAddFriendUI()
  {
    AppMethodBeat.i(111826);
    this.tyD = 1;
    this.callback = new FTSAddFriendUI.5(this);
    this.tyJ = -1;
    AppMethodBeat.o(111826);
  }
  
  private void akJ(final String paramString)
  {
    AppMethodBeat.i(111838);
    this.tyB = true;
    this.tyC = false;
    this.tyD = 1;
    if ((paramString == null) || (paramString.length() == 0) || (paramString.trim().length() == 0))
    {
      AppMethodBeat.o(111838);
      return;
    }
    if (Character.isDigit(paramString.charAt(0))) {}
    for (int i = 15;; i = 3)
    {
      this.tyJ = i;
      this.tyG = 0;
      this.tyH = 0;
      g.aiU().a(106, this.callback);
      paramString = new com.tencent.mm.plugin.messenger.a.f(paramString, 3);
      g.aiU().a(paramString, 0);
      getString(2131755906);
      this.qdv = com.tencent.mm.ui.base.h.b(this, getString(2131762915), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(111823);
          g.aiU().a(paramString);
          g.aiU().b(106, FTSAddFriendUI.i(FTSAddFriendUI.this));
          FTSAddFriendUI.j(FTSAddFriendUI.this);
          AppMethodBeat.o(111823);
        }
      });
      AppMethodBeat.o(111838);
      return;
    }
  }
  
  private void cTp()
  {
    AppMethodBeat.i(111836);
    if (bt.nullAsNil(z.a(this.rcR.GbY)).length() > 0)
    {
      if (2 != this.rcR.Hpn) {
        break label128;
      }
      this.tyJ = 15;
    }
    for (;;)
    {
      Intent localIntent = new Intent();
      ((m)g.ab(m.class)).a(localIntent, this.rcR, this.tyJ);
      if ((this.tyJ == 15) && (2 == this.rcR.Hpn)) {
        localIntent.putExtra("Contact_Search_Mobile", this.tyI);
      }
      localIntent.putExtra("add_more_friend_search_scene", 2);
      com.tencent.mm.bs.d.b(this, "profile", ".ui.ContactInfoUI", localIntent);
      AppMethodBeat.o(111836);
      return;
      label128:
      if (1 == this.rcR.Hpn) {
        this.tyJ = 1;
      }
    }
  }
  
  private void cTq()
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
    if (this.tyF == null) {
      this.tyF = new c(parame);
    }
    parame = this.tyF;
    AppMethodBeat.o(111830);
    return parame;
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(111831);
    if ((parama instanceof com.tencent.mm.plugin.fts.ui.a.a))
    {
      if (System.currentTimeMillis() - this.mYb <= 1000L)
      {
        AppMethodBeat.o(111831);
        return;
      }
      this.mYb = System.currentTimeMillis();
      akJ(parama.tun.tuL);
    }
    AppMethodBeat.o(111831);
  }
  
  public final void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.b paramb)
  {
    AppMethodBeat.i(168765);
    super.a(paramString1, paramString2, paramList, paramb);
    this.tyB = false;
    AppMethodBeat.o(168765);
  }
  
  public final boolean bzz()
  {
    AppMethodBeat.i(111833);
    akJ(this.query);
    hideVKB();
    AppMethodBeat.o(111833);
    return true;
  }
  
  protected final void cTo()
  {
    AppMethodBeat.i(111834);
    super.cTo();
    this.typ.setVisibility(8);
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
    if (!this.tyX.getFtsEditText().vr.hasFocus())
    {
      this.tyX.getFtsEditText().fJS();
      showVKB();
    }
    AppMethodBeat.o(111840);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(111827);
    super.onCreate(paramBundle);
    com.tencent.mm.plugin.fts.a.e.ttw = com.tencent.mm.plugin.fts.a.d.GM(16);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle = TransitionInflater.from(this).inflateTransition(17760258);
      paramBundle.excludeTarget(getWindow().getDecorView().findViewById(2131296345), true);
      paramBundle.excludeTarget(16908335, true);
      getWindow().setEnterTransition(paramBundle);
    }
    setActionbarColor(getContext().getResources().getColor(2131100705));
    setHint(getContext().getResources().getString(2131757917));
    this.tyo = findViewById(2131297205);
    this.typ = findViewById(2131298588);
    this.tyq = findViewById(2131300681);
    this.tyu = findViewById(2131298589);
    this.tyr = findViewById(2131302876);
    this.tys = findViewById(2131302252);
    this.tyt = findViewById(2131304408);
    this.tyE = ((FTSLocalPageRelevantView)findViewById(2131303972));
    this.tyv = ((ImageView)findViewById(2131298585));
    this.tyw = ((TextView)findViewById(2131298716));
    this.tyx = ((TextView)findViewById(2131298593));
    this.tyy = ((TextView)findViewById(2131304451));
    this.tyz = ((TextView)findViewById(2131298594));
    this.tyA = ((TextView)findViewById(2131304410));
    try
    {
      paramBundle = af.aFP("webSearchBar").optString("wording");
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FTS.FTSAddFriendUI", "set searchNetworkTips %s", new Object[] { paramBundle });
      this.tyA.setText(paramBundle);
      label320:
      getContentView().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(111818);
          FTSAddFriendUI.this.tyX.getFtsEditText().fJS();
          FTSAddFriendUI.this.tyX.getFtsEditText().fJR();
          AppMethodBeat.o(111818);
        }
      }, 128L);
      this.tyo.setOnClickListener(new FTSAddFriendUI.2(this));
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
    g.aiU().b(106, this.callback);
    if ((this.tyB) && (!this.tyC)) {
      am.p(this.query, this.tyD, 3, 16);
    }
    AppMethodBeat.o(111837);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(111828);
    super.onResume();
    com.tencent.mm.plugin.websearch.api.ad.eMe();
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
    this.typ.setVisibility(8);
    AppMethodBeat.o(111835);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSAddFriendUI
 * JD-Core Version:    0.7.0.1
 */