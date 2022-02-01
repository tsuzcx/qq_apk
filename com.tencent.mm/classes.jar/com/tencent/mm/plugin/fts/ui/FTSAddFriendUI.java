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
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.api.m;
import com.tencent.mm.g.a.an;
import com.tencent.mm.g.a.an.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.fts.ui.widget.FTSLocalPageRelevantView;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.plugin.websearch.api.af;
import com.tencent.mm.plugin.websearch.api.am;
import com.tencent.mm.protocal.protobuf.cyu;
import com.tencent.mm.protocal.protobuf.cyv;
import com.tencent.mm.protocal.protobuf.cyw;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.FTSEditTextView.b;
import com.tencent.mm.ui.search.a.c;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(3)
public class FTSAddFriendUI
  extends FTSBaseUI
{
  private final com.tencent.mm.ak.f callback;
  private long lSe;
  private long ndi;
  private Dialog qka;
  private cyw rkX;
  int tJA;
  private View tJf;
  private View tJg;
  private View tJh;
  private View tJi;
  private View tJj;
  private View tJk;
  private View tJl;
  private ImageView tJm;
  private TextView tJn;
  private TextView tJo;
  private TextView tJp;
  private TextView tJq;
  private TextView tJr;
  private boolean tJs;
  protected boolean tJt;
  private int tJu;
  private FTSLocalPageRelevantView tJv;
  private c tJw;
  private int tJx;
  private int tJy;
  private String tJz;
  
  public FTSAddFriendUI()
  {
    AppMethodBeat.i(111826);
    this.tJu = 1;
    this.callback = new com.tencent.mm.ak.f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(111822);
        g.ajj().b(106, this);
        FTSAddFriendUI.d(FTSAddFriendUI.this);
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
          switch (paramAnonymousInt2)
          {
          default: 
            FTSAddFriendUI.e(FTSAddFriendUI.this).setText(2131761619);
            label68:
            FTSAddFriendUI.a(FTSAddFriendUI.this, -1);
            FTSAddFriendUI.b(FTSAddFriendUI.this, 1);
          }
        }
        for (;;)
        {
          FTSAddFriendUI.h(FTSAddFriendUI.this);
          AppMethodBeat.o(111822);
          return;
          if (paramAnonymousInt1 == 4) {
            break;
          }
          FTSAddFriendUI.e(FTSAddFriendUI.this).setText(FTSAddFriendUI.this.getString(2131762916));
          break label68;
          paramAnonymousString = com.tencent.mm.h.a.uU(paramAnonymousString);
          if (paramAnonymousString != null)
          {
            FTSAddFriendUI.e(FTSAddFriendUI.this).setText(paramAnonymousString.desc);
            break label68;
          }
          FTSAddFriendUI.e(FTSAddFriendUI.this).setText(2131761619);
          break label68;
          FTSAddFriendUI.a(FTSAddFriendUI.this, ((com.tencent.mm.plugin.messenger.a.f)paramAnonymousn).doB());
          FTSAddFriendUI localFTSAddFriendUI = FTSAddFriendUI.this;
          paramAnonymousString = (cyv)((com.tencent.mm.plugin.messenger.a.f)paramAnonymousn).rr.hQD.hQJ;
          if (paramAnonymousString != null) {}
          for (paramAnonymousString = z.a(paramAnonymousString.GuF);; paramAnonymousString = "")
          {
            FTSAddFriendUI.a(localFTSAddFriendUI, paramAnonymousString);
            if (FTSAddFriendUI.f(FTSAddFriendUI.this).GQu <= 0) {
              break label407;
            }
            if (!FTSAddFriendUI.f(FTSAddFriendUI.this).GQv.isEmpty()) {
              break;
            }
            com.tencent.mm.ui.base.h.a(FTSAddFriendUI.this, 2131762921, 0, true, null);
            AppMethodBeat.o(111822);
            return;
          }
          paramAnonymousString = new Intent();
          paramAnonymousString.putExtra("add_more_friend_search_scene", 3);
          if (FTSAddFriendUI.f(FTSAddFriendUI.this).GQv.size() > 1) {
            try
            {
              paramAnonymousString.putExtra("result", FTSAddFriendUI.f(FTSAddFriendUI.this).toByteArray());
              com.tencent.mm.br.d.b(FTSAddFriendUI.this.getContext(), "subapp", ".ui.pluginapp.ContactSearchResultUI", paramAnonymousString);
              AppMethodBeat.o(111822);
              return;
            }
            catch (IOException paramAnonymousString)
            {
              ae.printErrStackTrace("MicroMsg.FTS.FTSAddFriendUI", paramAnonymousString, "", new Object[0]);
              AppMethodBeat.o(111822);
              return;
            }
          }
          ((m)g.ab(m.class)).a(paramAnonymousString, (cyu)FTSAddFriendUI.f(FTSAddFriendUI.this).GQv.getFirst(), FTSAddFriendUI.this.tJA);
          label407:
          FTSAddFriendUI.a(FTSAddFriendUI.this, 1);
          FTSAddFriendUI.g(FTSAddFriendUI.this);
        }
      }
    };
    this.tJA = -1;
    AppMethodBeat.o(111826);
  }
  
  private void alH(final String paramString)
  {
    AppMethodBeat.i(111838);
    this.tJs = true;
    this.tJt = false;
    this.tJu = 1;
    if ((paramString == null) || (paramString.length() == 0) || (paramString.trim().length() == 0))
    {
      AppMethodBeat.o(111838);
      return;
    }
    if (Character.isDigit(paramString.charAt(0))) {}
    for (int i = 15;; i = 3)
    {
      this.tJA = i;
      this.tJx = 0;
      this.tJy = 0;
      g.ajj().a(106, this.callback);
      paramString = new com.tencent.mm.plugin.messenger.a.f(paramString, 3);
      g.ajj().a(paramString, 0);
      getString(2131755906);
      this.qka = com.tencent.mm.ui.base.h.b(this, getString(2131762915), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(111823);
          g.ajj().a(paramString);
          g.ajj().b(106, FTSAddFriendUI.i(FTSAddFriendUI.this));
          FTSAddFriendUI.j(FTSAddFriendUI.this);
          AppMethodBeat.o(111823);
        }
      });
      AppMethodBeat.o(111838);
      return;
    }
  }
  
  private void cVU()
  {
    AppMethodBeat.i(111836);
    if (bu.nullAsNil(z.a(this.rkX.GuF)).length() > 0)
    {
      if (2 != this.rkX.HIP) {
        break label129;
      }
      this.tJA = 15;
    }
    for (;;)
    {
      Intent localIntent = new Intent();
      ((m)g.ab(m.class)).a(localIntent, this.rkX, this.tJA);
      if ((this.tJA == 15) && (2 == this.rkX.HIP)) {
        localIntent.putExtra("Contact_Search_Mobile", this.tJz);
      }
      localIntent.putExtra("add_more_friend_search_scene", 2);
      com.tencent.mm.br.d.b(this, "profile", ".ui.ContactInfoUI", localIntent);
      AppMethodBeat.o(111836);
      return;
      label129:
      if (1 == this.rkX.HIP) {
        this.tJA = 1;
      }
    }
  }
  
  private void cVV()
  {
    AppMethodBeat.i(111839);
    ar.f(new Runnable()
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
    if (this.tJw == null) {
      this.tJw = new c(parame);
    }
    parame = this.tJw;
    AppMethodBeat.o(111830);
    return parame;
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(111831);
    if ((parama instanceof com.tencent.mm.plugin.fts.ui.a.a))
    {
      if (System.currentTimeMillis() - this.ndi <= 1000L)
      {
        AppMethodBeat.o(111831);
        return;
      }
      this.ndi = System.currentTimeMillis();
      alH(parama.tFe.tFC);
    }
    AppMethodBeat.o(111831);
  }
  
  public final void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.b paramb)
  {
    AppMethodBeat.i(168765);
    super.a(paramString1, paramString2, paramList, paramb);
    this.tJs = false;
    AppMethodBeat.o(168765);
  }
  
  public final boolean bAu()
  {
    AppMethodBeat.i(111833);
    alH(this.query);
    hideVKB();
    AppMethodBeat.o(111833);
    return true;
  }
  
  protected final void cVT()
  {
    AppMethodBeat.i(111834);
    super.cVT();
    this.tJg.setVisibility(8);
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
    if (!this.tJO.getFtsEditText().vr.hasFocus())
    {
      this.tJO.getFtsEditText().fOj();
      showVKB();
    }
    AppMethodBeat.o(111840);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(111827);
    super.onCreate(paramBundle);
    com.tencent.mm.plugin.fts.a.e.tEn = com.tencent.mm.plugin.fts.a.d.Hj(16);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle = TransitionInflater.from(this).inflateTransition(17760258);
      paramBundle.excludeTarget(getWindow().getDecorView().findViewById(2131296345), true);
      paramBundle.excludeTarget(16908335, true);
      getWindow().setEnterTransition(paramBundle);
    }
    setActionbarColor(getContext().getResources().getColor(2131100705));
    setHint(getContext().getResources().getString(2131757917));
    this.tJf = findViewById(2131297205);
    this.tJg = findViewById(2131298588);
    this.tJh = findViewById(2131300681);
    this.tJl = findViewById(2131298589);
    this.tJi = findViewById(2131302876);
    this.tJj = findViewById(2131302252);
    this.tJk = findViewById(2131304408);
    this.tJv = ((FTSLocalPageRelevantView)findViewById(2131303972));
    this.tJm = ((ImageView)findViewById(2131298585));
    this.tJn = ((TextView)findViewById(2131298716));
    this.tJo = ((TextView)findViewById(2131298593));
    this.tJp = ((TextView)findViewById(2131304451));
    this.tJq = ((TextView)findViewById(2131298594));
    this.tJr = ((TextView)findViewById(2131304410));
    try
    {
      paramBundle = af.aHj("webSearchBar").optString("wording");
      ae.i("MicroMsg.FTS.FTSAddFriendUI", "set searchNetworkTips %s", new Object[] { paramBundle });
      this.tJr.setText(paramBundle);
      label320:
      getContentView().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(111818);
          FTSAddFriendUI.this.tJO.getFtsEditText().fOj();
          FTSAddFriendUI.this.tJO.getFtsEditText().fOi();
          AppMethodBeat.o(111818);
        }
      }, 128L);
      this.tJf.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(111819);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fts/ui/FTSAddFriendUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          FTSAddFriendUI.this.finish();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/FTSAddFriendUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
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
    g.ajj().b(106, this.callback);
    if ((this.tJs) && (!this.tJt)) {
      am.p(this.query, this.tJu, 3, 16);
    }
    AppMethodBeat.o(111837);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(111828);
    super.onResume();
    ad.ePN();
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
    this.tJg.setVisibility(8);
    AppMethodBeat.o(111835);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSAddFriendUI
 * JD-Core Version:    0.7.0.1
 */