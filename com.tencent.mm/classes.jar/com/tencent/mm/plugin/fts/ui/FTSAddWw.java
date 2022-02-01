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
import com.tencent.mm.al.f;
import com.tencent.mm.al.q;
import com.tencent.mm.g.b.a.dn;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.ui.widget.FTSLocalPageRelevantView;
import com.tencent.mm.plugin.websearch.api.af;
import com.tencent.mm.plugin.websearch.api.am;
import com.tencent.mm.protocal.protobuf.cew;
import com.tencent.mm.protocal.protobuf.cyp;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
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
  private long mYb;
  private String ppR = "";
  private Dialog qdv;
  private TextView tyA;
  private boolean tyB;
  protected boolean tyC;
  private int tyD = 1;
  private FTSLocalPageRelevantView tyE;
  private c tyF;
  private int tyG;
  private int tyH;
  int tyJ = -1;
  private cyp tyN;
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
  
  private void akJ(final String paramString)
  {
    AppMethodBeat.i(111866);
    this.tyB = true;
    this.tyC = false;
    this.tyD = 1;
    if ((paramString == null) || (paramString.length() == 0) || (paramString.trim().length() == 0))
    {
      AppMethodBeat.o(111866);
      return;
    }
    if (Character.isDigit(paramString.charAt(0))) {}
    for (int i = 15;; i = 3)
    {
      this.tyJ = i;
      this.callback = new f()
      {
        public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.n paramAnonymousn)
        {
          AppMethodBeat.i(111850);
          g.aiU().b(372, this);
          FTSAddWw.d(FTSAddWw.this);
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
            switch (paramAnonymousInt2)
            {
            default: 
              FTSAddWw.e(FTSAddWw.this).setText(2131761619);
              label68:
              FTSAddWw.a(FTSAddWw.this, -1);
              FTSAddWw.f(FTSAddWw.this);
              paramAnonymousString = new dn();
              paramAnonymousString.mT(FTSAddWw.a(FTSAddWw.this));
              paramAnonymousString.edo = 0L;
              paramAnonymousString.egG = 2L;
              paramAnonymousString.aLk();
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
            paramAnonymousString = com.tencent.mm.h.a.uz(paramAnonymousString);
            if (paramAnonymousString != null)
            {
              FTSAddWw.e(FTSAddWw.this).setText(paramAnonymousString.desc);
              break label68;
            }
            FTSAddWw.e(FTSAddWw.this).setText(2131761619);
            break label68;
            FTSAddWw.a(FTSAddWw.this, ((com.tencent.mm.openim.b.n)paramAnonymousn).iHH);
            FTSAddWw.a(FTSAddWw.this, 1);
            paramAnonymousString = new dn();
            paramAnonymousString.mT(FTSAddWw.a(FTSAddWw.this));
            paramAnonymousString.edo = 0L;
            paramAnonymousString.egG = 1L;
            paramAnonymousString.aLk();
          }
        }
      };
      this.tyG = 0;
      this.tyH = 0;
      g.aiU().a(372, this.callback);
      paramString = new com.tencent.mm.openim.b.n(paramString);
      g.aiU().a(paramString, 0);
      getString(2131755906);
      this.qdv = com.tencent.mm.ui.base.h.b(this, getString(2131762915), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(111851);
          g.aiU().a(paramString);
          g.aiU().b(372, FTSAddWw.h(FTSAddWw.this));
          FTSAddWw.i(FTSAddWw.this);
          AppMethodBeat.o(111851);
        }
      });
      AppMethodBeat.o(111866);
      return;
    }
  }
  
  private void cTp()
  {
    AppMethodBeat.i(111864);
    String str = this.tyN.nDo;
    if (bt.nullAsNil(str).length() > 0)
    {
      if (2 != this.tyN.Hpn) {
        break label254;
      }
      this.tyJ = 15;
    }
    for (;;)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("Contact_User", str);
      localIntent.putExtra(e.c.IUp, this.tyN.Guj);
      if ((this.tyJ == 15) && (2 == this.tyN.Hpn)) {
        localIntent.putExtra("Contact_Search_Mobile", this.ppR.trim());
      }
      localIntent.putExtra("key_add_contact_openim_appid", this.tyN.iht);
      localIntent.putExtra("Contact_Nick", this.tyN.nEt);
      localIntent.putExtra("Contact_PyInitial", this.tyN.Gaz);
      localIntent.putExtra("Contact_QuanPin", this.tyN.GaA);
      localIntent.putExtra("Contact_Sex", this.tyN.jdc);
      localIntent.putExtra("key_add_contact_custom_detail_visible", this.tyN.HpC.GYY);
      localIntent.putExtra("key_add_contact_custom_detail", this.tyN.HpC.ugo);
      localIntent.putExtra("Contact_Scene", this.tyJ);
      localIntent.putExtra("key_ww_add_session_id", this.mSessionId);
      localIntent.putExtra("add_more_friend_search_scene", 2);
      com.tencent.mm.bs.d.b(this, "profile", ".ui.ContactInfoUI", localIntent);
      AppMethodBeat.o(111864);
      return;
      label254:
      if (1 == this.tyN.Hpn) {
        this.tyJ = 1;
      }
    }
  }
  
  private void cTq()
  {
    AppMethodBeat.i(111867);
    aq.f(new Runnable()
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
    if (this.tyF == null) {
      this.tyF = new c(parame);
    }
    parame = this.tyF;
    AppMethodBeat.o(111858);
    return parame;
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(111859);
    if ((parama instanceof com.tencent.mm.plugin.fts.ui.a.a))
    {
      if (System.currentTimeMillis() - this.mYb <= 1000L)
      {
        AppMethodBeat.o(111859);
        return;
      }
      this.mYb = System.currentTimeMillis();
      this.ppR = parama.tun.tuL;
      akJ(parama.tun.tuL);
      parama = new dn();
      parama.mT(this.mSessionId);
      parama.edo = 1L;
      parama.aLk();
    }
    AppMethodBeat.o(111859);
  }
  
  public final void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.b paramb)
  {
    AppMethodBeat.i(168766);
    super.a(paramString1, paramString2, paramList, paramb);
    this.tyB = false;
    AppMethodBeat.o(168766);
  }
  
  public final boolean bzz()
  {
    AppMethodBeat.i(111861);
    akJ(this.query);
    hideVKB();
    AppMethodBeat.o(111861);
    return true;
  }
  
  protected final void cTo()
  {
    AppMethodBeat.i(111862);
    super.cTo();
    this.typ.setVisibility(8);
    AppMethodBeat.o(111862);
  }
  
  protected final void cTr()
  {
    AppMethodBeat.i(111855);
    super.cTr();
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(111848);
        paramAnonymousMenuItem = new dn();
        paramAnonymousMenuItem.mT(FTSAddWw.a(FTSAddWw.this));
        paramAnonymousMenuItem.edo = 2L;
        paramAnonymousMenuItem.aLk();
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
    dn localdn = new dn();
    localdn.mT(this.mSessionId);
    localdn.edo = 2L;
    localdn.aLk();
    finish();
    AppMethodBeat.o(111857);
  }
  
  public void onClickBackBtn(View paramView)
  {
    AppMethodBeat.i(111854);
    super.onClickBackBtn(paramView);
    paramView = new dn();
    paramView.mT(this.mSessionId);
    paramView.edo = 2L;
    paramView.aLk();
    AppMethodBeat.o(111854);
  }
  
  public void onClickClearTextBtn(View paramView)
  {
    AppMethodBeat.i(111868);
    super.onClickClearTextBtn(paramView);
    if (!this.tyX.getFtsEditText().vr.hasFocus())
    {
      this.tyX.getFtsEditText().fJS();
      showVKB();
    }
    AppMethodBeat.o(111868);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(111853);
    super.onCreate(paramBundle);
    this.mSessionId = com.tencent.xweb.util.d.getMessageDigest(System.currentTimeMillis().getBytes());
    com.tencent.mm.plugin.fts.a.e.ttw = com.tencent.mm.plugin.fts.a.d.GM(16);
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
      label351:
      getContentView().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(111846);
          FTSAddWw.this.tyX.getFtsEditText().fJS();
          FTSAddWw.this.tyX.getFtsEditText().fJR();
          AppMethodBeat.o(111846);
        }
      }, 128L);
      this.tyo.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(111847);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fts/ui/FTSAddWw$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
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
    if ((this.tyB) && (!this.tyC)) {
      am.p(this.query, this.tyD, 3, 16);
    }
    if (this.callback != null) {
      g.aiU().b(372, this.callback);
    }
    AppMethodBeat.o(111865);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(111856);
    super.onResume();
    com.tencent.mm.plugin.websearch.api.ad.eMe();
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
    dn localdn = new dn();
    localdn.mT(this.mSessionId);
    localdn.edo = 3L;
    localdn.aLk();
    this.typ.setVisibility(8);
    AppMethodBeat.o(111863);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSAddWw
 * JD-Core Version:    0.7.0.1
 */