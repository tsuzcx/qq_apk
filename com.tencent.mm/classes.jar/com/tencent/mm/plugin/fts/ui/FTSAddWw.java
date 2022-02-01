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
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.b.a.dp;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.ui.widget.FTSLocalPageRelevantView;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.plugin.websearch.api.af;
import com.tencent.mm.plugin.websearch.api.am;
import com.tencent.mm.protocal.protobuf.cfq;
import com.tencent.mm.protocal.protobuf.czj;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.e.c;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.FTSEditTextView.b;
import com.tencent.mm.ui.search.a.c;
import java.util.List;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(3)
public class FTSAddWw
  extends FTSBaseUI
{
  private f callback;
  private String mSessionId = "";
  private long ndi;
  private String pwx = "";
  private Dialog qka;
  int tJA = -1;
  private czj tJE;
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
  private int tJu = 1;
  private FTSLocalPageRelevantView tJv;
  private c tJw;
  private int tJx;
  private int tJy;
  
  private void alH(final String paramString)
  {
    AppMethodBeat.i(111866);
    this.tJs = true;
    this.tJt = false;
    this.tJu = 1;
    if ((paramString == null) || (paramString.length() == 0) || (paramString.trim().length() == 0))
    {
      AppMethodBeat.o(111866);
      return;
    }
    if (Character.isDigit(paramString.charAt(0))) {}
    for (int i = 15;; i = 3)
    {
      this.tJA = i;
      this.callback = new f()
      {
        public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn)
        {
          AppMethodBeat.i(111850);
          g.ajj().b(372, this);
          FTSAddWw.d(FTSAddWw.this);
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
            switch (paramAnonymousInt2)
            {
            default: 
              FTSAddWw.e(FTSAddWw.this).setText(2131761619);
              label68:
              FTSAddWw.a(FTSAddWw.this, -1);
              FTSAddWw.f(FTSAddWw.this);
              paramAnonymousString = new dp();
              paramAnonymousString.nm(FTSAddWw.a(FTSAddWw.this));
              paramAnonymousString.eeJ = 0L;
              paramAnonymousString.eiq = 2L;
              paramAnonymousString.aLH();
            }
          }
          for (;;)
          {
            FTSAddWw.g(FTSAddWw.this);
            AppMethodBeat.o(111850);
            return;
            if (paramAnonymousInt1 == 4) {
              break;
            }
            FTSAddWw.e(FTSAddWw.this).setText(FTSAddWw.this.getString(2131762916));
            break label68;
            paramAnonymousString = com.tencent.mm.h.a.uU(paramAnonymousString);
            if (paramAnonymousString != null)
            {
              FTSAddWw.e(FTSAddWw.this).setText(paramAnonymousString.desc);
              break label68;
            }
            FTSAddWw.e(FTSAddWw.this).setText(2131761619);
            break label68;
            FTSAddWw.a(FTSAddWw.this, ((com.tencent.mm.openim.b.n)paramAnonymousn).iKA);
            FTSAddWw.a(FTSAddWw.this, 1);
            paramAnonymousString = new dp();
            paramAnonymousString.nm(FTSAddWw.a(FTSAddWw.this));
            paramAnonymousString.eeJ = 0L;
            paramAnonymousString.eiq = 1L;
            paramAnonymousString.aLH();
          }
        }
      };
      this.tJx = 0;
      this.tJy = 0;
      g.ajj().a(372, this.callback);
      paramString = new com.tencent.mm.openim.b.n(paramString);
      g.ajj().a(paramString, 0);
      getString(2131755906);
      this.qka = com.tencent.mm.ui.base.h.b(this, getString(2131762915), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(111851);
          g.ajj().a(paramString);
          g.ajj().b(372, FTSAddWw.h(FTSAddWw.this));
          FTSAddWw.i(FTSAddWw.this);
          AppMethodBeat.o(111851);
        }
      });
      AppMethodBeat.o(111866);
      return;
    }
  }
  
  private void cVU()
  {
    AppMethodBeat.i(111864);
    String str = this.tJE.nIJ;
    if (bu.nullAsNil(str).length() > 0)
    {
      if (2 != this.tJE.HIP) {
        break label254;
      }
      this.tJA = 15;
    }
    for (;;)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("Contact_User", str);
      localIntent.putExtra(e.c.JoX, this.tJE.GNI);
      if ((this.tJA == 15) && (2 == this.tJE.HIP)) {
        localIntent.putExtra("Contact_Search_Mobile", this.pwx.trim());
      }
      localIntent.putExtra("key_add_contact_openim_appid", this.tJE.ikm);
      localIntent.putExtra("Contact_Nick", this.tJE.nJO);
      localIntent.putExtra("Contact_PyInitial", this.tJE.Gtg);
      localIntent.putExtra("Contact_QuanPin", this.tJE.Gth);
      localIntent.putExtra("Contact_Sex", this.tJE.jfV);
      localIntent.putExtra("key_add_contact_custom_detail_visible", this.tJE.HJe.Hsz);
      localIntent.putExtra("key_add_contact_custom_detail", this.tJE.HJe.urL);
      localIntent.putExtra("Contact_Scene", this.tJA);
      localIntent.putExtra("key_ww_add_session_id", this.mSessionId);
      localIntent.putExtra("add_more_friend_search_scene", 2);
      com.tencent.mm.br.d.b(this, "profile", ".ui.ContactInfoUI", localIntent);
      AppMethodBeat.o(111864);
      return;
      label254:
      if (1 == this.tJE.HIP) {
        this.tJA = 1;
      }
    }
  }
  
  private void cVV()
  {
    AppMethodBeat.i(111867);
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(111852);
        if (FTSAddWw.j(FTSAddWw.this) != null)
        {
          FTSAddWw.j(FTSAddWw.this).dismiss();
          FTSAddWw.i(FTSAddWw.this);
        }
        AppMethodBeat.o(111852);
      }
    });
    AppMethodBeat.o(111867);
  }
  
  protected final d a(e parame)
  {
    AppMethodBeat.i(111858);
    if (this.tJw == null) {
      this.tJw = new c(parame);
    }
    parame = this.tJw;
    AppMethodBeat.o(111858);
    return parame;
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(111859);
    if ((parama instanceof com.tencent.mm.plugin.fts.ui.a.a))
    {
      if (System.currentTimeMillis() - this.ndi <= 1000L)
      {
        AppMethodBeat.o(111859);
        return;
      }
      this.ndi = System.currentTimeMillis();
      this.pwx = parama.tFe.tFC;
      alH(parama.tFe.tFC);
      parama = new dp();
      parama.nm(this.mSessionId);
      parama.eeJ = 1L;
      parama.aLH();
    }
    AppMethodBeat.o(111859);
  }
  
  public final void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.b paramb)
  {
    AppMethodBeat.i(168766);
    super.a(paramString1, paramString2, paramList, paramb);
    this.tJs = false;
    AppMethodBeat.o(168766);
  }
  
  public final boolean bAu()
  {
    AppMethodBeat.i(111861);
    alH(this.query);
    hideVKB();
    AppMethodBeat.o(111861);
    return true;
  }
  
  protected final void cVT()
  {
    AppMethodBeat.i(111862);
    super.cVT();
    this.tJg.setVisibility(8);
    AppMethodBeat.o(111862);
  }
  
  protected final void cVW()
  {
    AppMethodBeat.i(111855);
    super.cVW();
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(111848);
        paramAnonymousMenuItem = new dp();
        paramAnonymousMenuItem.nm(FTSAddWw.a(FTSAddWw.this));
        paramAnonymousMenuItem.eeJ = 2L;
        paramAnonymousMenuItem.aLH();
        FTSAddWw.this.finish();
        AppMethodBeat.o(111848);
        return true;
      }
    });
    AppMethodBeat.o(111855);
  }
  
  public int getLayoutId()
  {
    return 2131494185;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(111857);
    dp localdp = new dp();
    localdp.nm(this.mSessionId);
    localdp.eeJ = 2L;
    localdp.aLH();
    finish();
    AppMethodBeat.o(111857);
  }
  
  public void onClickBackBtn(View paramView)
  {
    AppMethodBeat.i(111854);
    super.onClickBackBtn(paramView);
    paramView = new dp();
    paramView.nm(this.mSessionId);
    paramView.eeJ = 2L;
    paramView.aLH();
    AppMethodBeat.o(111854);
  }
  
  public void onClickClearTextBtn(View paramView)
  {
    AppMethodBeat.i(111868);
    super.onClickClearTextBtn(paramView);
    if (!this.tJO.getFtsEditText().vr.hasFocus())
    {
      this.tJO.getFtsEditText().fOj();
      showVKB();
    }
    AppMethodBeat.o(111868);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(111853);
    super.onCreate(paramBundle);
    this.mSessionId = com.tencent.xweb.util.d.getMessageDigest(System.currentTimeMillis().getBytes());
    com.tencent.mm.plugin.fts.a.e.tEn = com.tencent.mm.plugin.fts.a.d.Hj(16);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle = TransitionInflater.from(this).inflateTransition(17760258);
      paramBundle.excludeTarget(getWindow().getDecorView().findViewById(2131296345), true);
      paramBundle.excludeTarget(16908335, true);
      getWindow().setEnterTransition(paramBundle);
    }
    setActionbarColor(getContext().getResources().getColor(2131100705));
    hideActionbarLine();
    setHint(getContext().getResources().getString(2131757925));
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
      label351:
      getContentView().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(111846);
          FTSAddWw.this.tJO.getFtsEditText().fOj();
          FTSAddWw.this.tJO.getFtsEditText().fOi();
          AppMethodBeat.o(111846);
        }
      }, 128L);
      this.tJf.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(111847);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fts/ui/FTSAddWw$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          FTSAddWw.this.finish();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/FTSAddWw$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(111847);
        }
      });
      AppMethodBeat.o(111853);
      return;
    }
    catch (Exception paramBundle)
    {
      break label351;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(111865);
    super.onDestroy();
    if ((this.tJs) && (!this.tJt)) {
      am.p(this.query, this.tJu, 3, 16);
    }
    if (this.callback != null) {
      g.ajj().b(372, this.callback);
    }
    AppMethodBeat.o(111865);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(111856);
    super.onResume();
    ad.ePN();
    AppMethodBeat.o(111856);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected final void stopSearch()
  {
    AppMethodBeat.i(111863);
    super.stopSearch();
    dp localdp = new dp();
    localdp.nm(this.mSessionId);
    localdp.eeJ = 3L;
    localdp.aLH();
    this.tJg.setVisibility(8);
    AppMethodBeat.o(111863);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSAddWw
 * JD-Core Version:    0.7.0.1
 */