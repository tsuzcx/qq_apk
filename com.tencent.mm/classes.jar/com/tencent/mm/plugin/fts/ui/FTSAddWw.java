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
import com.tencent.mm.al.q;
import com.tencent.mm.g.b.a.bh;
import com.tencent.mm.plugin.fts.ui.widget.FTSLocalPageRelevantView;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.ac;
import com.tencent.mm.plugin.websearch.api.ak;
import com.tencent.mm.protocal.protobuf.bvn;
import com.tencent.mm.protocal.protobuf.cny;
import com.tencent.mm.sdk.platformtools.ad;
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
  private com.tencent.mm.al.g callback;
  private long lVv;
  private String mSessionId = "";
  private Dialog oWF;
  private String oiJ = "";
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
  private int rti = 1;
  private FTSLocalPageRelevantView rtj;
  private c rtk;
  private int rtl;
  private int rtm;
  int rto = -1;
  private cny rts;
  
  private void abt(final String paramString)
  {
    AppMethodBeat.i(111866);
    this.rtg = true;
    this.rth = false;
    this.rti = 1;
    if ((paramString == null) || (paramString.length() == 0) || (paramString.trim().length() == 0))
    {
      AppMethodBeat.o(111866);
      return;
    }
    if (Character.isDigit(paramString.charAt(0))) {}
    for (int i = 15;; i = 3)
    {
      this.rto = i;
      this.callback = new com.tencent.mm.al.g()
      {
        public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.n paramAnonymousn)
        {
          AppMethodBeat.i(111850);
          com.tencent.mm.kernel.g.aeS().b(372, this);
          FTSAddWw.d(FTSAddWw.this);
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
            switch (paramAnonymousInt2)
            {
            default: 
              FTSAddWw.e(FTSAddWw.this).setText(2131761619);
              label68:
              FTSAddWw.a(FTSAddWw.this, -1);
              FTSAddWw.f(FTSAddWw.this);
              paramAnonymousString = new bh();
              paramAnonymousString.ia(FTSAddWw.a(FTSAddWw.this));
              paramAnonymousString.dPt = 0L;
              paramAnonymousString.dPu = 2L;
              paramAnonymousString.aBj();
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
            paramAnonymousString = com.tencent.mm.h.a.oG(paramAnonymousString);
            if (paramAnonymousString != null)
            {
              FTSAddWw.e(FTSAddWw.this).setText(paramAnonymousString.desc);
              break label68;
            }
            FTSAddWw.e(FTSAddWw.this).setText(2131761619);
            break label68;
            FTSAddWw.a(FTSAddWw.this, ((com.tencent.mm.openim.b.n)paramAnonymousn).hNO);
            FTSAddWw.a(FTSAddWw.this, 1);
            paramAnonymousString = new bh();
            paramAnonymousString.ia(FTSAddWw.a(FTSAddWw.this));
            paramAnonymousString.dPt = 0L;
            paramAnonymousString.dPu = 1L;
            paramAnonymousString.aBj();
          }
        }
      };
      this.rtl = 0;
      this.rtm = 0;
      com.tencent.mm.kernel.g.aeS().a(372, this.callback);
      paramString = new com.tencent.mm.openim.b.n(paramString);
      com.tencent.mm.kernel.g.aeS().a(paramString, 0);
      getString(2131755906);
      this.oWF = com.tencent.mm.ui.base.h.b(this, getString(2131762915), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(111851);
          com.tencent.mm.kernel.g.aeS().a(paramString);
          com.tencent.mm.kernel.g.aeS().b(372, FTSAddWw.h(FTSAddWw.this));
          FTSAddWw.i(FTSAddWw.this);
          AppMethodBeat.o(111851);
        }
      });
      AppMethodBeat.o(111866);
      return;
    }
  }
  
  private void cxO()
  {
    AppMethodBeat.i(111864);
    String str = this.rts.mAQ;
    if (bt.nullAsNil(str).length() > 0)
    {
      if (2 != this.rts.EhQ) {
        break label254;
      }
      this.rto = 15;
    }
    for (;;)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("Contact_User", str);
      localIntent.putExtra(e.c.FHR, this.rts.Dqd);
      if ((this.rto == 15) && (2 == this.rts.EhQ)) {
        localIntent.putExtra("Contact_Search_Mobile", this.oiJ.trim());
      }
      localIntent.putExtra("key_add_contact_openim_appid", this.rts.hnC);
      localIntent.putExtra("Contact_Nick", this.rts.mBV);
      localIntent.putExtra("Contact_PyInitial", this.rts.Dal);
      localIntent.putExtra("Contact_QuanPin", this.rts.Dam);
      localIntent.putExtra("Contact_Sex", this.rts.ijM);
      localIntent.putExtra("key_add_contact_custom_detail_visible", this.rts.Eif.DSR);
      localIntent.putExtra("key_add_contact_custom_detail", this.rts.Eif.saB);
      localIntent.putExtra("Contact_Scene", this.rto);
      localIntent.putExtra("key_ww_add_session_id", this.mSessionId);
      localIntent.putExtra("add_more_friend_search_scene", 2);
      com.tencent.mm.bs.d.b(this, "profile", ".ui.ContactInfoUI", localIntent);
      AppMethodBeat.o(111864);
      return;
      label254:
      if (1 == this.rts.EhQ) {
        this.rto = 1;
      }
    }
  }
  
  private void cxP()
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
    if (this.rtk == null) {
      this.rtk = new c(parame);
    }
    parame = this.rtk;
    AppMethodBeat.o(111858);
    return parame;
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(111859);
    if ((parama instanceof com.tencent.mm.plugin.fts.ui.a.a))
    {
      if (System.currentTimeMillis() - this.lVv <= 1000L)
      {
        AppMethodBeat.o(111859);
        return;
      }
      this.lVv = System.currentTimeMillis();
      this.oiJ = parama.roS.rpq;
      abt(parama.roS.rpq);
      parama = new bh();
      parama.ia(this.mSessionId);
      parama.dPt = 1L;
      parama.aBj();
    }
    AppMethodBeat.o(111859);
  }
  
  public final void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.b paramb)
  {
    AppMethodBeat.i(168766);
    super.a(paramString1, paramString2, paramList, paramb);
    this.rtg = false;
    AppMethodBeat.o(168766);
  }
  
  public final boolean bow()
  {
    AppMethodBeat.i(111861);
    abt(this.query);
    hideVKB();
    AppMethodBeat.o(111861);
    return true;
  }
  
  protected final void cxN()
  {
    AppMethodBeat.i(111862);
    super.cxN();
    this.rsU.setVisibility(8);
    AppMethodBeat.o(111862);
  }
  
  protected final void cxQ()
  {
    AppMethodBeat.i(111855);
    super.cxQ();
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(111848);
        paramAnonymousMenuItem = new bh();
        paramAnonymousMenuItem.ia(FTSAddWw.a(FTSAddWw.this));
        paramAnonymousMenuItem.dPt = 2L;
        paramAnonymousMenuItem.aBj();
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
    bh localbh = new bh();
    localbh.ia(this.mSessionId);
    localbh.dPt = 2L;
    localbh.aBj();
    finish();
    AppMethodBeat.o(111857);
  }
  
  public void onClickBackBtn(View paramView)
  {
    AppMethodBeat.i(111854);
    super.onClickBackBtn(paramView);
    paramView = new bh();
    paramView.ia(this.mSessionId);
    paramView.dPt = 2L;
    paramView.aBj();
    AppMethodBeat.o(111854);
  }
  
  public void onClickClearTextBtn(View paramView)
  {
    AppMethodBeat.i(111868);
    super.onClickClearTextBtn(paramView);
    if (!this.rtD.getFtsEditText().sz.hasFocus())
    {
      this.rtD.getFtsEditText().fdj();
      showVKB();
    }
    AppMethodBeat.o(111868);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(111853);
    super.onCreate(paramBundle);
    this.mSessionId = com.tencent.xweb.util.d.getMessageDigest(System.currentTimeMillis().getBytes());
    com.tencent.mm.plugin.fts.a.e.rob = com.tencent.mm.plugin.fts.a.d.DB(16);
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
      label351:
      getContentView().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(111846);
          FTSAddWw.this.rtD.getFtsEditText().fdj();
          FTSAddWw.this.rtD.getFtsEditText().fdi();
          AppMethodBeat.o(111846);
        }
      }, 128L);
      this.rsT.setOnClickListener(new View.OnClickListener()
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
    if ((this.rtg) && (!this.rth)) {
      ak.p(this.query, this.rti, 3, 16);
    }
    if (this.callback != null) {
      com.tencent.mm.kernel.g.aeS().b(372, this.callback);
    }
    AppMethodBeat.o(111865);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(111856);
    super.onResume();
    aa.ehT();
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
    bh localbh = new bh();
    localbh.ia(this.mSessionId);
    localbh.dPt = 3L;
    localbh.aBj();
    this.rsU.setVisibility(8);
    AppMethodBeat.o(111863);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSAddWw
 * JD-Core Version:    0.7.0.1
 */