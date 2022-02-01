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
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.b.a.gr;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.openim.b.n;
import com.tencent.mm.plugin.fts.ui.widget.FTSLocalPageRelevantView;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.ak;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.protocal.protobuf.cvx;
import com.tencent.mm.protocal.protobuf.dsk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.e.d;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.FTSEditTextView.b;
import com.tencent.mm.ui.search.a.c;
import java.util.List;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(3)
public class FTSAddWw
  extends FTSBaseUI
{
  private i callback;
  private long lastClickTime;
  private String mSessionId = "";
  private String qLO = "";
  private Dialog rAV;
  private dsk xaD;
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
  private int xat = 1;
  private FTSLocalPageRelevantView xau;
  private c xav;
  private int xaw;
  private int xax;
  int xaz = -1;
  
  private void ayL(final String paramString)
  {
    AppMethodBeat.i(111866);
    this.xar = true;
    this.xas = false;
    this.xat = 1;
    if ((paramString == null) || (paramString.length() == 0) || (paramString.trim().length() == 0))
    {
      AppMethodBeat.o(111866);
      return;
    }
    if (Character.isDigit(paramString.charAt(0))) {}
    for (int i = 15;; i = 3)
    {
      this.xaz = i;
      this.callback = new i()
      {
        public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
        {
          AppMethodBeat.i(111850);
          g.azz().b(372, this);
          FTSAddWw.d(FTSAddWw.this);
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
            switch (paramAnonymousInt2)
            {
            default: 
              FTSAddWw.e(FTSAddWw.this).setText(2131763587);
              label68:
              FTSAddWw.a(FTSAddWw.this, -1);
              FTSAddWw.f(FTSAddWw.this);
              paramAnonymousString = new gr();
              paramAnonymousString.ut(FTSAddWw.a(FTSAddWw.this));
              paramAnonymousString.eCt = 0L;
              paramAnonymousString.eKL = 2L;
              paramAnonymousString.bfK();
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
            FTSAddWw.e(FTSAddWw.this).setText(FTSAddWw.this.getString(2131765052));
            break label68;
            paramAnonymousString = com.tencent.mm.h.a.Dk(paramAnonymousString);
            if (paramAnonymousString != null)
            {
              FTSAddWw.e(FTSAddWw.this).setText(paramAnonymousString.desc);
              break label68;
            }
            FTSAddWw.e(FTSAddWw.this).setText(2131763587);
            break label68;
            FTSAddWw.a(FTSAddWw.this, ((n)paramAnonymousq).jHg);
            FTSAddWw.a(FTSAddWw.this, 1);
            paramAnonymousString = new gr();
            paramAnonymousString.ut(FTSAddWw.a(FTSAddWw.this));
            paramAnonymousString.eCt = 0L;
            paramAnonymousString.eKL = 1L;
            paramAnonymousString.bfK();
          }
        }
      };
      this.xaw = 0;
      this.xax = 0;
      g.azz().a(372, this.callback);
      paramString = new n(paramString);
      g.azz().a(paramString, 0);
      getString(2131755998);
      this.rAV = com.tencent.mm.ui.base.h.a(this, getString(2131765051), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(111851);
          g.azz().a(paramString);
          g.azz().b(372, FTSAddWw.h(FTSAddWw.this));
          FTSAddWw.i(FTSAddWw.this);
          AppMethodBeat.o(111851);
        }
      });
      AppMethodBeat.o(111866);
      return;
    }
  }
  
  private void dPd()
  {
    AppMethodBeat.i(111864);
    String str = this.xaD.UserName;
    if (Util.nullAsNil(str).length() > 0)
    {
      if (2 != this.xaD.MUk) {
        break label257;
      }
      this.xaz = 15;
    }
    for (;;)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("Contact_User", str);
      localIntent.putExtra(e.d.OyT, this.xaD.LRO);
      if ((this.xaz == 15) && (2 == this.xaD.MUk)) {
        localIntent.putExtra("Contact_Search_Mobile", this.qLO.trim());
      }
      localIntent.putExtra("key_add_contact_openim_appid", this.xaD.jfi);
      localIntent.putExtra("Contact_Nick", this.xaD.oUJ);
      localIntent.putExtra("Contact_PyInitial", this.xaD.LoE);
      localIntent.putExtra("Contact_QuanPin", this.xaD.LoF);
      localIntent.putExtra("Contact_Sex", this.xaD.kdY);
      localIntent.putExtra("key_add_contact_custom_detail_visible", this.xaD.MUN.MBw);
      localIntent.putExtra("key_add_contact_custom_detail", this.xaD.MUN.xKd);
      localIntent.putExtra("Contact_Scene", this.xaz);
      localIntent.putExtra("key_ww_add_session_id", this.mSessionId);
      localIntent.putExtra("add_more_friend_search_scene", 2);
      com.tencent.mm.br.c.b(this, "profile", ".ui.ContactInfoUI", localIntent);
      AppMethodBeat.o(111864);
      return;
      label257:
      if (1 == this.xaD.MUk) {
        this.xaz = 1;
      }
    }
  }
  
  private void dPe()
  {
    AppMethodBeat.i(111867);
    MMHandlerThread.postToMainThread(new Runnable()
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
    if (this.xav == null) {
      this.xav = new c(parame);
    }
    parame = this.xav;
    AppMethodBeat.o(111858);
    return parame;
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(111859);
    if ((parama instanceof com.tencent.mm.plugin.fts.ui.a.a))
    {
      if (System.currentTimeMillis() - this.lastClickTime <= 1000L)
      {
        AppMethodBeat.o(111859);
        return;
      }
      this.lastClickTime = System.currentTimeMillis();
      this.qLO = parama.wWd.wWB;
      ayL(parama.wWd.wWB);
      parama = new gr();
      parama.ut(this.mSessionId);
      parama.eCt = 1L;
      parama.bfK();
    }
    AppMethodBeat.o(111859);
  }
  
  public final void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.b paramb)
  {
    AppMethodBeat.i(168766);
    super.a(paramString1, paramString2, paramList, paramb);
    this.xar = false;
    AppMethodBeat.o(168766);
  }
  
  public final boolean awE()
  {
    AppMethodBeat.i(111861);
    ayL(this.query);
    hideVKB();
    AppMethodBeat.o(111861);
    return true;
  }
  
  protected final void dPc()
  {
    AppMethodBeat.i(111862);
    super.dPc();
    this.xaf.setVisibility(8);
    AppMethodBeat.o(111862);
  }
  
  protected final void dPf()
  {
    AppMethodBeat.i(111855);
    super.dPf();
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(111848);
        paramAnonymousMenuItem = new gr();
        paramAnonymousMenuItem.ut(FTSAddWw.a(FTSAddWw.this));
        paramAnonymousMenuItem.eCt = 2L;
        paramAnonymousMenuItem.bfK();
        FTSAddWw.this.finish();
        AppMethodBeat.o(111848);
        return true;
      }
    });
    AppMethodBeat.o(111855);
  }
  
  public int getLayoutId()
  {
    return 2131494739;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(111857);
    gr localgr = new gr();
    localgr.ut(this.mSessionId);
    localgr.eCt = 2L;
    localgr.bfK();
    finish();
    AppMethodBeat.o(111857);
  }
  
  public void onClickBackBtn(View paramView)
  {
    AppMethodBeat.i(111854);
    super.onClickBackBtn(paramView);
    paramView = new gr();
    paramView.ut(this.mSessionId);
    paramView.eCt = 2L;
    paramView.bfK();
    AppMethodBeat.o(111854);
  }
  
  public void onClickClearTextBtn(View paramView)
  {
    AppMethodBeat.i(111868);
    super.onClickClearTextBtn(paramView);
    if (!this.xaN.getFtsEditText().vy.hasFocus())
    {
      this.xaN.getFtsEditText().awD();
      showVKB();
    }
    AppMethodBeat.o(111868);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(111853);
    super.onCreate(paramBundle);
    this.mSessionId = com.tencent.xweb.util.d.getMessageDigest(System.currentTimeMillis().getBytes());
    com.tencent.mm.plugin.fts.a.e.wVm = com.tencent.mm.plugin.fts.a.d.Ni(16);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle = TransitionInflater.from(this).inflateTransition(17760258);
      paramBundle.excludeTarget(getWindow().getDecorView().findViewById(2131296366), true);
      paramBundle.excludeTarget(16908335, true);
      getWindow().setEnterTransition(paramBundle);
    }
    setActionbarColor(getContext().getResources().getColor(2131100898));
    hideActionbarLine();
    setHint(getContext().getResources().getString(2131758165));
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
      label351:
      getContentView().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(111846);
          FTSAddWw.this.xaN.getFtsEditText().awD();
          FTSAddWw.this.xaN.getFtsEditText().awC();
          AppMethodBeat.o(111846);
        }
      }, 128L);
      this.xae.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(111847);
          b localb = new b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fts/ui/FTSAddWw$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
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
    if ((this.xar) && (!this.xas)) {
      ar.q(this.query, this.xat, 3, 16);
    }
    if (this.callback != null) {
      g.azz().b(372, this.callback);
    }
    AppMethodBeat.o(111865);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(111856);
    super.onResume();
    ai.fXY();
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
    gr localgr = new gr();
    localgr.ut(this.mSessionId);
    localgr.eCt = 3L;
    localgr.bfK();
    this.xaf.setVisibility(8);
    AppMethodBeat.o(111863);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSAddWw
 * JD-Core Version:    0.7.0.1
 */