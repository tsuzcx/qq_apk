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
import com.tencent.mm.ak.q;
import com.tencent.mm.g.b.a.cu;
import com.tencent.mm.plugin.fts.ui.widget.FTSLocalPageRelevantView;
import com.tencent.mm.plugin.websearch.api.ab;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.protocal.protobuf.caf;
import com.tencent.mm.protocal.protobuf.ctf;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
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
  private com.tencent.mm.ak.g callback;
  private String mSessionId = "";
  private long mxx;
  private String oMj = "";
  private Dialog pzQ;
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
  private int sCc = 1;
  private FTSLocalPageRelevantView sCd;
  private c sCe;
  private int sCf;
  private int sCg;
  int sCi = -1;
  private ctf sCm;
  
  private void agl(final String paramString)
  {
    AppMethodBeat.i(111866);
    this.sCa = true;
    this.sCb = false;
    this.sCc = 1;
    if ((paramString == null) || (paramString.length() == 0) || (paramString.trim().length() == 0))
    {
      AppMethodBeat.o(111866);
      return;
    }
    if (Character.isDigit(paramString.charAt(0))) {}
    for (int i = 15;; i = 3)
    {
      this.sCi = i;
      this.callback = new com.tencent.mm.ak.g()
      {
        public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn)
        {
          AppMethodBeat.i(111850);
          com.tencent.mm.kernel.g.agi().b(372, this);
          FTSAddWw.d(FTSAddWw.this);
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
            switch (paramAnonymousInt2)
            {
            default: 
              FTSAddWw.e(FTSAddWw.this).setText(2131761619);
              label68:
              FTSAddWw.a(FTSAddWw.this, -1);
              FTSAddWw.f(FTSAddWw.this);
              paramAnonymousString = new cu();
              paramAnonymousString.kQ(FTSAddWw.a(FTSAddWw.this));
              paramAnonymousString.dNZ = 0L;
              paramAnonymousString.dRj = 2L;
              paramAnonymousString.aHZ();
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
            paramAnonymousString = com.tencent.mm.h.a.rM(paramAnonymousString);
            if (paramAnonymousString != null)
            {
              FTSAddWw.e(FTSAddWw.this).setText(paramAnonymousString.desc);
              break label68;
            }
            FTSAddWw.e(FTSAddWw.this).setText(2131761619);
            break label68;
            FTSAddWw.a(FTSAddWw.this, ((com.tencent.mm.openim.b.n)paramAnonymousn).iok);
            FTSAddWw.a(FTSAddWw.this, 1);
            paramAnonymousString = new cu();
            paramAnonymousString.kQ(FTSAddWw.a(FTSAddWw.this));
            paramAnonymousString.dNZ = 0L;
            paramAnonymousString.dRj = 1L;
            paramAnonymousString.aHZ();
          }
        }
      };
      this.sCf = 0;
      this.sCg = 0;
      com.tencent.mm.kernel.g.agi().a(372, this.callback);
      paramString = new com.tencent.mm.openim.b.n(paramString);
      com.tencent.mm.kernel.g.agi().a(paramString, 0);
      getString(2131755906);
      this.pzQ = com.tencent.mm.ui.base.h.b(this, getString(2131762915), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(111851);
          com.tencent.mm.kernel.g.agi().a(paramString);
          com.tencent.mm.kernel.g.agi().b(372, FTSAddWw.h(FTSAddWw.this));
          FTSAddWw.i(FTSAddWw.this);
          AppMethodBeat.o(111851);
        }
      });
      AppMethodBeat.o(111866);
      return;
    }
  }
  
  private void cLa()
  {
    AppMethodBeat.i(111864);
    String str = this.sCm.ncR;
    if (bs.nullAsNil(str).length() > 0)
    {
      if (2 != this.sCm.FEO) {
        break label254;
      }
      this.sCi = 15;
    }
    for (;;)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("Contact_User", str);
      localIntent.putExtra(e.c.HgZ, this.sCm.ELg);
      if ((this.sCi == 15) && (2 == this.sCm.FEO)) {
        localIntent.putExtra("Contact_Search_Mobile", this.oMj.trim());
      }
      localIntent.putExtra("key_add_contact_openim_appid", this.sCm.hOf);
      localIntent.putExtra("Contact_Nick", this.sCm.ndW);
      localIntent.putExtra("Contact_PyInitial", this.sCm.Eti);
      localIntent.putExtra("Contact_QuanPin", this.sCm.Etj);
      localIntent.putExtra("Contact_Sex", this.sCm.iJT);
      localIntent.putExtra("key_add_contact_custom_detail_visible", this.sCm.FFd.Fpn);
      localIntent.putExtra("key_add_contact_custom_detail", this.sCm.FFd.tiv);
      localIntent.putExtra("Contact_Scene", this.sCi);
      localIntent.putExtra("key_ww_add_session_id", this.mSessionId);
      localIntent.putExtra("add_more_friend_search_scene", 2);
      com.tencent.mm.br.d.b(this, "profile", ".ui.ContactInfoUI", localIntent);
      AppMethodBeat.o(111864);
      return;
      label254:
      if (1 == this.sCm.FEO) {
        this.sCi = 1;
      }
    }
  }
  
  private void cLb()
  {
    AppMethodBeat.i(111867);
    ap.f(new Runnable()
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
    if (this.sCe == null) {
      this.sCe = new c(parame);
    }
    parame = this.sCe;
    AppMethodBeat.o(111858);
    return parame;
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(111859);
    if ((parama instanceof com.tencent.mm.plugin.fts.ui.a.a))
    {
      if (System.currentTimeMillis() - this.mxx <= 1000L)
      {
        AppMethodBeat.o(111859);
        return;
      }
      this.mxx = System.currentTimeMillis();
      this.oMj = parama.sxM.syk;
      agl(parama.sxM.syk);
      parama = new cu();
      parama.kQ(this.mSessionId);
      parama.dNZ = 1L;
      parama.aHZ();
    }
    AppMethodBeat.o(111859);
  }
  
  public final void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.b paramb)
  {
    AppMethodBeat.i(168766);
    super.a(paramString1, paramString2, paramList, paramb);
    this.sCa = false;
    AppMethodBeat.o(168766);
  }
  
  public final boolean bvs()
  {
    AppMethodBeat.i(111861);
    agl(this.query);
    hideVKB();
    AppMethodBeat.o(111861);
    return true;
  }
  
  protected final void cKZ()
  {
    AppMethodBeat.i(111862);
    super.cKZ();
    this.sBO.setVisibility(8);
    AppMethodBeat.o(111862);
  }
  
  protected final void cLc()
  {
    AppMethodBeat.i(111855);
    super.cLc();
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(111848);
        paramAnonymousMenuItem = new cu();
        paramAnonymousMenuItem.kQ(FTSAddWw.a(FTSAddWw.this));
        paramAnonymousMenuItem.dNZ = 2L;
        paramAnonymousMenuItem.aHZ();
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
    cu localcu = new cu();
    localcu.kQ(this.mSessionId);
    localcu.dNZ = 2L;
    localcu.aHZ();
    finish();
    AppMethodBeat.o(111857);
  }
  
  public void onClickBackBtn(View paramView)
  {
    AppMethodBeat.i(111854);
    super.onClickBackBtn(paramView);
    paramView = new cu();
    paramView.kQ(this.mSessionId);
    paramView.dNZ = 2L;
    paramView.aHZ();
    AppMethodBeat.o(111854);
  }
  
  public void onClickClearTextBtn(View paramView)
  {
    AppMethodBeat.i(111868);
    super.onClickClearTextBtn(paramView);
    if (!this.sCw.getFtsEditText().ty.hasFocus())
    {
      this.sCw.getFtsEditText().fte();
      showVKB();
    }
    AppMethodBeat.o(111868);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(111853);
    super.onCreate(paramBundle);
    this.mSessionId = com.tencent.xweb.util.d.getMessageDigest(System.currentTimeMillis().getBytes());
    com.tencent.mm.plugin.fts.a.e.swV = com.tencent.mm.plugin.fts.a.d.Fx(16);
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
      label351:
      getContentView().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(111846);
          FTSAddWw.this.sCw.getFtsEditText().fte();
          FTSAddWw.this.sCw.getFtsEditText().ftd();
          AppMethodBeat.o(111846);
        }
      }, 128L);
      this.sBN.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(111847);
          FTSAddWw.this.finish();
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
    if ((this.sCa) && (!this.sCb)) {
      ai.p(this.query, this.sCc, 3, 16);
    }
    if (this.callback != null) {
      com.tencent.mm.kernel.g.agi().b(372, this.callback);
    }
    AppMethodBeat.o(111865);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(111856);
    super.onResume();
    z.exn();
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
    cu localcu = new cu();
    localcu.kQ(this.mSessionId);
    localcu.dNZ = 3L;
    localcu.aHZ();
    this.sBO.setVisibility(8);
    AppMethodBeat.o(111863);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSAddWw
 * JD-Core Version:    0.7.0.1
 */