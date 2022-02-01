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
import com.tencent.mm.ak.q;
import com.tencent.mm.api.m;
import com.tencent.mm.g.a.an;
import com.tencent.mm.g.a.an.b;
import com.tencent.mm.plugin.fts.ui.widget.FTSLocalPageRelevantView;
import com.tencent.mm.plugin.websearch.api.ab;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.FTSEditTextView.b;
import com.tencent.mm.ui.search.a.c;
import java.util.List;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(3)
public class FTSAddFriendUI
  extends FTSBaseUI
{
  private final com.tencent.mm.ak.g callback;
  private long lqi;
  private long mxx;
  private Dialog pzQ;
  private css qtd;
  private View sBN;
  private View sBO;
  private View sBP;
  private View sBQ;
  private View sBR;
  private View sBS;
  private View sBT;
  private ImageView sBU;
  private TextView sBV;
  private TextView sBW;
  private TextView sBX;
  private TextView sBY;
  private TextView sBZ;
  private boolean sCa;
  protected boolean sCb;
  private int sCc;
  private FTSLocalPageRelevantView sCd;
  private c sCe;
  private int sCf;
  private int sCg;
  private String sCh;
  int sCi;
  
  public FTSAddFriendUI()
  {
    AppMethodBeat.i(111826);
    this.sCc = 1;
    this.callback = new FTSAddFriendUI.5(this);
    this.sCi = -1;
    AppMethodBeat.o(111826);
  }
  
  private void agl(final String paramString)
  {
    AppMethodBeat.i(111838);
    this.sCa = true;
    this.sCb = false;
    this.sCc = 1;
    if ((paramString == null) || (paramString.length() == 0) || (paramString.trim().length() == 0))
    {
      AppMethodBeat.o(111838);
      return;
    }
    if (Character.isDigit(paramString.charAt(0))) {}
    for (int i = 15;; i = 3)
    {
      this.sCi = i;
      this.sCf = 0;
      this.sCg = 0;
      com.tencent.mm.kernel.g.agi().a(106, this.callback);
      paramString = new com.tencent.mm.plugin.messenger.a.g(paramString, 3);
      com.tencent.mm.kernel.g.agi().a(paramString, 0);
      getString(2131755906);
      this.pzQ = com.tencent.mm.ui.base.h.b(this, getString(2131762915), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(111823);
          com.tencent.mm.kernel.g.agi().a(paramString);
          com.tencent.mm.kernel.g.agi().b(106, FTSAddFriendUI.i(FTSAddFriendUI.this));
          FTSAddFriendUI.j(FTSAddFriendUI.this);
          AppMethodBeat.o(111823);
        }
      });
      AppMethodBeat.o(111838);
      return;
    }
  }
  
  private void cLa()
  {
    AppMethodBeat.i(111836);
    if (bs.nullAsNil(com.tencent.mm.platformtools.z.a(this.qtd.EuE)).length() > 0)
    {
      if (2 != this.qtd.FEO) {
        break label129;
      }
      this.sCi = 15;
    }
    for (;;)
    {
      Intent localIntent = new Intent();
      ((m)com.tencent.mm.kernel.g.ab(m.class)).a(localIntent, this.qtd, this.sCi);
      if ((this.sCi == 15) && (2 == this.qtd.FEO)) {
        localIntent.putExtra("Contact_Search_Mobile", this.sCh);
      }
      localIntent.putExtra("add_more_friend_search_scene", 2);
      com.tencent.mm.br.d.b(this, "profile", ".ui.ContactInfoUI", localIntent);
      AppMethodBeat.o(111836);
      return;
      label129:
      if (1 == this.qtd.FEO) {
        this.sCi = 1;
      }
    }
  }
  
  private void cLb()
  {
    AppMethodBeat.i(111839);
    ap.f(new Runnable()
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
    if (this.sCe == null) {
      this.sCe = new c(parame);
    }
    parame = this.sCe;
    AppMethodBeat.o(111830);
    return parame;
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(111831);
    if ((parama instanceof com.tencent.mm.plugin.fts.ui.a.a))
    {
      if (System.currentTimeMillis() - this.mxx <= 1000L)
      {
        AppMethodBeat.o(111831);
        return;
      }
      this.mxx = System.currentTimeMillis();
      agl(parama.sxM.syk);
    }
    AppMethodBeat.o(111831);
  }
  
  public final void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.b paramb)
  {
    AppMethodBeat.i(168765);
    super.a(paramString1, paramString2, paramList, paramb);
    this.sCa = false;
    AppMethodBeat.o(168765);
  }
  
  public final boolean bvs()
  {
    AppMethodBeat.i(111833);
    agl(this.query);
    hideVKB();
    AppMethodBeat.o(111833);
    return true;
  }
  
  protected final void cKZ()
  {
    AppMethodBeat.i(111834);
    super.cKZ();
    this.sBO.setVisibility(8);
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
    if (!this.sCw.getFtsEditText().ty.hasFocus())
    {
      this.sCw.getFtsEditText().fte();
      showVKB();
    }
    AppMethodBeat.o(111840);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(111827);
    super.onCreate(paramBundle);
    com.tencent.mm.plugin.fts.a.e.swV = com.tencent.mm.plugin.fts.a.d.Fx(16);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle = TransitionInflater.from(this).inflateTransition(17760258);
      paramBundle.excludeTarget(getWindow().getDecorView().findViewById(2131296345), true);
      paramBundle.excludeTarget(16908335, true);
      getWindow().setEnterTransition(paramBundle);
    }
    setActionbarColor(getContext().getResources().getColor(2131100705));
    setHint(getContext().getResources().getString(2131757917));
    this.sBN = findViewById(2131297205);
    this.sBO = findViewById(2131298588);
    this.sBP = findViewById(2131300681);
    this.sBT = findViewById(2131298589);
    this.sBQ = findViewById(2131302876);
    this.sBR = findViewById(2131302252);
    this.sBS = findViewById(2131304408);
    this.sCd = ((FTSLocalPageRelevantView)findViewById(2131303972));
    this.sBU = ((ImageView)findViewById(2131298585));
    this.sBV = ((TextView)findViewById(2131298716));
    this.sBW = ((TextView)findViewById(2131298593));
    this.sBX = ((TextView)findViewById(2131304451));
    this.sBY = ((TextView)findViewById(2131298594));
    this.sBZ = ((TextView)findViewById(2131304410));
    try
    {
      paramBundle = ab.aAv("webSearchBar").optString("wording");
      ac.i("MicroMsg.FTS.FTSAddFriendUI", "set searchNetworkTips %s", new Object[] { paramBundle });
      this.sBZ.setText(paramBundle);
      label320:
      getContentView().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(111818);
          FTSAddFriendUI.this.sCw.getFtsEditText().fte();
          FTSAddFriendUI.this.sCw.getFtsEditText().ftd();
          AppMethodBeat.o(111818);
        }
      }, 128L);
      this.sBN.setOnClickListener(new View.OnClickListener()
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
    com.tencent.mm.kernel.g.agi().b(106, this.callback);
    if ((this.sCa) && (!this.sCb)) {
      ai.p(this.query, this.sCc, 3, 16);
    }
    AppMethodBeat.o(111837);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(111828);
    super.onResume();
    com.tencent.mm.plugin.websearch.api.z.exn();
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
    this.sBO.setVisibility(8);
    AppMethodBeat.o(111835);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSAddFriendUI
 * JD-Core Version:    0.7.0.1
 */