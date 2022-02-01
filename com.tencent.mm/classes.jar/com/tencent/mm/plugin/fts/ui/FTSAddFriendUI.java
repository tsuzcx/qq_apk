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
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.api.n;
import com.tencent.mm.g.a.ap;
import com.tencent.mm.g.a.ap.b;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.fts.ui.widget.FTSLocalPageRelevantView;
import com.tencent.mm.plugin.messenger.a.f;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.ak;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.protocal.protobuf.drr;
import com.tencent.mm.protocal.protobuf.drs;
import com.tencent.mm.protocal.protobuf.drt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
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
  private final i callback;
  private long lastClickTime;
  private long mZq;
  private Dialog rAV;
  private drt sMC;
  private View xae;
  private View xaf;
  private View xag;
  private View xah;
  private View xai;
  private View xaj;
  private View xak;
  private ImageView xal;
  private TextView xam;
  private TextView xan;
  private TextView xao;
  private TextView xap;
  private TextView xaq;
  private boolean xar;
  protected boolean xas;
  private int xat;
  private FTSLocalPageRelevantView xau;
  private c xav;
  private int xaw;
  private int xax;
  private String xay;
  int xaz;
  
  public FTSAddFriendUI()
  {
    AppMethodBeat.i(111826);
    this.xat = 1;
    this.callback = new i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(111822);
        g.azz().b(106, this);
        FTSAddFriendUI.d(FTSAddFriendUI.this);
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
          switch (paramAnonymousInt2)
          {
          default: 
            FTSAddFriendUI.e(FTSAddFriendUI.this).setText(2131763587);
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
          FTSAddFriendUI.e(FTSAddFriendUI.this).setText(FTSAddFriendUI.this.getString(2131765052));
          break label68;
          paramAnonymousString = com.tencent.mm.h.a.Dk(paramAnonymousString);
          if (paramAnonymousString != null)
          {
            FTSAddFriendUI.e(FTSAddFriendUI.this).setText(paramAnonymousString.desc);
            break label68;
          }
          FTSAddFriendUI.e(FTSAddFriendUI.this).setText(2131763587);
          break label68;
          FTSAddFriendUI.a(FTSAddFriendUI.this, ((f)paramAnonymousq).eiq());
          FTSAddFriendUI localFTSAddFriendUI = FTSAddFriendUI.this;
          paramAnonymousString = (drs)((f)paramAnonymousq).rr.iLK.iLR;
          if (paramAnonymousString != null) {}
          for (paramAnonymousString = z.a(paramAnonymousString.Lqk);; paramAnonymousString = "")
          {
            FTSAddFriendUI.a(localFTSAddFriendUI, paramAnonymousString);
            if (FTSAddFriendUI.f(FTSAddFriendUI.this).LUB <= 0) {
              break label407;
            }
            if (!FTSAddFriendUI.f(FTSAddFriendUI.this).LUC.isEmpty()) {
              break;
            }
            com.tencent.mm.ui.base.h.a(FTSAddFriendUI.this, 2131765057, 0, true, null);
            AppMethodBeat.o(111822);
            return;
          }
          paramAnonymousString = new Intent();
          paramAnonymousString.putExtra("add_more_friend_search_scene", 3);
          if (FTSAddFriendUI.f(FTSAddFriendUI.this).LUC.size() > 1) {
            try
            {
              paramAnonymousString.putExtra("result", FTSAddFriendUI.f(FTSAddFriendUI.this).toByteArray());
              com.tencent.mm.br.c.b(FTSAddFriendUI.this.getContext(), "subapp", ".ui.pluginapp.ContactSearchResultUI", paramAnonymousString);
              AppMethodBeat.o(111822);
              return;
            }
            catch (IOException paramAnonymousString)
            {
              Log.printErrStackTrace("MicroMsg.FTS.FTSAddFriendUI", paramAnonymousString, "", new Object[0]);
              AppMethodBeat.o(111822);
              return;
            }
          }
          ((n)g.af(n.class)).a(paramAnonymousString, (drr)FTSAddFriendUI.f(FTSAddFriendUI.this).LUC.getFirst(), FTSAddFriendUI.this.xaz);
          label407:
          FTSAddFriendUI.a(FTSAddFriendUI.this, 1);
          FTSAddFriendUI.g(FTSAddFriendUI.this);
        }
      }
    };
    this.xaz = -1;
    AppMethodBeat.o(111826);
  }
  
  private void ayL(final String paramString)
  {
    AppMethodBeat.i(111838);
    this.xar = true;
    this.xas = false;
    this.xat = 1;
    if ((paramString == null) || (paramString.length() == 0) || (paramString.trim().length() == 0))
    {
      AppMethodBeat.o(111838);
      return;
    }
    if (Character.isDigit(paramString.charAt(0))) {}
    for (int i = 15;; i = 3)
    {
      this.xaz = i;
      this.xaw = 0;
      this.xax = 0;
      g.azz().a(106, this.callback);
      paramString = new f(paramString, 3);
      g.azz().a(paramString, 0);
      getString(2131755998);
      this.rAV = com.tencent.mm.ui.base.h.a(this, getString(2131765051), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(111823);
          g.azz().a(paramString);
          g.azz().b(106, FTSAddFriendUI.i(FTSAddFriendUI.this));
          FTSAddFriendUI.j(FTSAddFriendUI.this);
          AppMethodBeat.o(111823);
        }
      });
      AppMethodBeat.o(111838);
      return;
    }
  }
  
  private void dPd()
  {
    AppMethodBeat.i(111836);
    if (Util.nullAsNil(z.a(this.sMC.Lqk)).length() > 0)
    {
      if (2 != this.sMC.MUk) {
        break label129;
      }
      this.xaz = 15;
    }
    for (;;)
    {
      Intent localIntent = new Intent();
      ((n)g.af(n.class)).a(localIntent, this.sMC, this.xaz);
      if ((this.xaz == 15) && (2 == this.sMC.MUk)) {
        localIntent.putExtra("Contact_Search_Mobile", this.xay);
      }
      localIntent.putExtra("add_more_friend_search_scene", 2);
      com.tencent.mm.br.c.b(this, "profile", ".ui.ContactInfoUI", localIntent);
      AppMethodBeat.o(111836);
      return;
      label129:
      if (1 == this.sMC.MUk) {
        this.xaz = 1;
      }
    }
  }
  
  private void dPe()
  {
    AppMethodBeat.i(111839);
    MMHandlerThread.postToMainThread(new Runnable()
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
    if (this.xav == null) {
      this.xav = new c(parame);
    }
    parame = this.xav;
    AppMethodBeat.o(111830);
    return parame;
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(111831);
    if ((parama instanceof com.tencent.mm.plugin.fts.ui.a.a))
    {
      if (System.currentTimeMillis() - this.lastClickTime <= 1000L)
      {
        AppMethodBeat.o(111831);
        return;
      }
      this.lastClickTime = System.currentTimeMillis();
      ayL(parama.wWd.wWB);
    }
    AppMethodBeat.o(111831);
  }
  
  public final void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.b paramb)
  {
    AppMethodBeat.i(168765);
    super.a(paramString1, paramString2, paramList, paramb);
    this.xar = false;
    AppMethodBeat.o(168765);
  }
  
  public final boolean awE()
  {
    AppMethodBeat.i(111833);
    ayL(this.query);
    hideVKB();
    AppMethodBeat.o(111833);
    return true;
  }
  
  protected final void dPc()
  {
    AppMethodBeat.i(111834);
    super.dPc();
    this.xaf.setVisibility(8);
    AppMethodBeat.o(111834);
  }
  
  public int getLayoutId()
  {
    return 2131494739;
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
    if (!this.xaN.getFtsEditText().vy.hasFocus())
    {
      this.xaN.getFtsEditText().awD();
      showVKB();
    }
    AppMethodBeat.o(111840);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(111827);
    super.onCreate(paramBundle);
    com.tencent.mm.plugin.fts.a.e.wVm = com.tencent.mm.plugin.fts.a.d.Ni(16);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle = TransitionInflater.from(this).inflateTransition(17760258);
      paramBundle.excludeTarget(getWindow().getDecorView().findViewById(2131296366), true);
      paramBundle.excludeTarget(16908335, true);
      getWindow().setEnterTransition(paramBundle);
    }
    setActionbarColor(getContext().getResources().getColor(2131100898));
    setHint(getContext().getResources().getString(2131758157));
    this.xae = findViewById(2131297357);
    this.xaf = findViewById(2131299025);
    this.xag = findViewById(2131302249);
    this.xak = findViewById(2131299026);
    this.xah = findViewById(2131305449);
    this.xai = findViewById(2131304638);
    this.xaj = findViewById(2131307374);
    this.xau = ((FTSLocalPageRelevantView)findViewById(2131306826));
    this.xal = ((ImageView)findViewById(2131299022));
    this.xam = ((TextView)findViewById(2131299154));
    this.xan = ((TextView)findViewById(2131299030));
    this.xao = ((TextView)findViewById(2131307427));
    this.xap = ((TextView)findViewById(2131299031));
    this.xaq = ((TextView)findViewById(2131307376));
    try
    {
      paramBundle = ak.aXe("webSearchBar").optString("wording");
      Log.i("MicroMsg.FTS.FTSAddFriendUI", "set searchNetworkTips %s", new Object[] { paramBundle });
      this.xaq.setText(paramBundle);
      label320:
      getContentView().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(111818);
          FTSAddFriendUI.this.xaN.getFtsEditText().awD();
          FTSAddFriendUI.this.xaN.getFtsEditText().awC();
          AppMethodBeat.o(111818);
        }
      }, 128L);
      this.xae.setOnClickListener(new FTSAddFriendUI.2(this));
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
    g.azz().b(106, this.callback);
    if ((this.xar) && (!this.xas)) {
      ar.q(this.query, this.xat, 3, 16);
    }
    AppMethodBeat.o(111837);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(111828);
    super.onResume();
    ai.fXY();
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
    this.xaf.setVisibility(8);
    AppMethodBeat.o(111835);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSAddFriendUI
 * JD-Core Version:    0.7.0.1
 */