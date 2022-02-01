package com.tencent.mm.plugin.fts.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.mmdata.rpt.lg;
import com.tencent.mm.b.g;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.openim.model.q;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.ui.widget.FTSLocalPageRelevantView;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.plugin.websearch.api.al;
import com.tencent.mm.plugin.websearch.api.as;
import com.tencent.mm.protocal.protobuf.dxj;
import com.tencent.mm.protocal.protobuf.evx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.f.e;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.FTSEditTextView.d;
import com.tencent.mm.ui.search.FTSSearchView;
import com.tencent.mm.ui.search.FTSSearchView.c;
import java.util.List;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(3)
public class FTSAddWw
  extends FTSBaseUI
{
  private View HwZ;
  private View Hxa;
  private View Hxb;
  private View Hxc;
  private View Hxd;
  private View Hxe;
  private View Hxf;
  private ImageView Hxg;
  private TextView Hxh;
  private TextView Hxi;
  private TextView Hxj;
  private TextView Hxk;
  private TextView Hxl;
  private boolean Hxm;
  protected boolean Hxn;
  private int Hxo;
  private FTSLocalPageRelevantView Hxp;
  private c Hxq;
  private int Hxr;
  private int Hxs;
  int Hxu;
  private evx Hxy;
  private com.tencent.mm.am.b.a Hxz;
  private long lastClickTime;
  private String mSessionId;
  private String xts;
  private Dialog ysC;
  
  public FTSAddWw()
  {
    AppMethodBeat.i(265676);
    this.xts = "";
    this.Hxo = 1;
    this.mSessionId = "";
    this.Hxu = -1;
    this.Hxz = new FTSAddWw.5(this);
    AppMethodBeat.o(265676);
  }
  
  private void aEF(final String paramString)
  {
    AppMethodBeat.i(111866);
    this.Hxm = true;
    this.Hxn = false;
    this.Hxo = 1;
    if ((paramString == null) || (paramString.length() == 0) || (paramString.trim().length() == 0))
    {
      AppMethodBeat.o(111866);
      return;
    }
    if (Character.isDigit(paramString.charAt(0))) {}
    for (int i = 15;; i = 3)
    {
      this.Hxu = i;
      this.Hxr = 0;
      this.Hxs = 0;
      paramString = new q(paramString);
      h.aZW().a(paramString, 0);
      getString(p.g.app_tip);
      this.ysC = k.a(this, getString(p.g.search_contact_doing), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(111851);
          h.aZW().a(paramString);
          FTSAddWw.h(FTSAddWw.this);
          AppMethodBeat.o(111851);
        }
      });
      AppMethodBeat.o(111866);
      return;
    }
  }
  
  private void fyf()
  {
    AppMethodBeat.i(111864);
    String str = this.Hxy.UserName;
    Intent localIntent;
    if (Util.nullAsNil(str).length() > 0)
    {
      if (2 != this.Hxy.abxU) {
        break label295;
      }
      this.Hxu = 15;
      localIntent = new Intent();
      localIntent.putExtra("Contact_User", str);
      localIntent.putExtra(f.e.adwe, this.Hxy.aant);
      if ((this.Hxu == 15) && (2 == this.Hxy.abxU)) {
        localIntent.putExtra("Contact_Search_Mobile", this.xts.trim());
      }
      if (!Util.isNullOrNil(this.Hxy.abyz)) {
        break label314;
      }
      Log.i("MicroMsg.FTS.FTSAddFriendUI", "FinderUsername is empty");
    }
    for (;;)
    {
      localIntent.putExtra("key_add_contact_openim_appid", this.Hxy.oOI);
      localIntent.putExtra("key_add_contact_openim_finder_username", this.Hxy.abyz);
      localIntent.putExtra("Contact_Nick", this.Hxy.vhX);
      localIntent.putExtra("Contact_PyInitial", this.Hxy.ZoW);
      localIntent.putExtra("Contact_QuanPin", this.Hxy.ZoX);
      localIntent.putExtra("Contact_Sex", this.Hxy.pSf);
      localIntent.putExtra("key_add_contact_custom_detail_visible", this.Hxy.abyy.abdu);
      localIntent.putExtra("key_add_contact_custom_detail", this.Hxy.abyy.IIu);
      localIntent.putExtra("Contact_Scene", this.Hxu);
      localIntent.putExtra("key_ww_add_session_id", this.mSessionId);
      localIntent.putExtra("add_more_friend_search_scene", 2);
      com.tencent.mm.br.c.b(this, "profile", ".ui.ContactInfoUI", localIntent);
      AppMethodBeat.o(111864);
      return;
      label295:
      if (1 != this.Hxy.abxU) {
        break;
      }
      this.Hxu = 1;
      break;
      label314:
      Log.i("MicroMsg.FTS.FTSAddFriendUI", "FinderUsername is " + this.Hxy.abyz);
    }
  }
  
  private void fyg()
  {
    AppMethodBeat.i(111867);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(111852);
        if (FTSAddWw.i(FTSAddWw.this) != null)
        {
          FTSAddWw.i(FTSAddWw.this).dismiss();
          FTSAddWw.h(FTSAddWw.this);
        }
        AppMethodBeat.o(111852);
      }
    });
    AppMethodBeat.o(111867);
  }
  
  protected final d a(e parame)
  {
    AppMethodBeat.i(111858);
    if (this.Hxq == null) {
      this.Hxq = new c(parame);
    }
    parame = this.Hxq;
    AppMethodBeat.o(111858);
    return parame;
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(111859);
    if ((parama instanceof com.tencent.mm.plugin.fts.ui.b.a))
    {
      if (System.currentTimeMillis() - this.lastClickTime <= 1000L)
      {
        AppMethodBeat.o(111859);
        return;
      }
      this.lastClickTime = System.currentTimeMillis();
      this.xts = parama.FWt.Hte;
      aEF(parama.FWt.Hte);
      parama = new lg();
      parama.ud(this.mSessionId);
      parama.isX = 1L;
      parama.bMH();
    }
    AppMethodBeat.o(111859);
  }
  
  public final boolean aWU()
  {
    AppMethodBeat.i(111861);
    aEF(this.query);
    hideVKB();
    AppMethodBeat.o(111861);
    return true;
  }
  
  protected final void eui()
  {
    AppMethodBeat.i(111863);
    super.eui();
    lg locallg = new lg();
    locallg.ud(this.mSessionId);
    locallg.isX = 3L;
    locallg.bMH();
    this.Hxa.setVisibility(8);
    AppMethodBeat.o(111863);
  }
  
  protected final void fye()
  {
    AppMethodBeat.i(111862);
    super.fye();
    this.Hxa.setVisibility(8);
    AppMethodBeat.o(111862);
  }
  
  protected final void fyh()
  {
    AppMethodBeat.i(111855);
    super.fyh();
    setBackBtn(new FTSAddWw.3(this));
    AppMethodBeat.o(111855);
  }
  
  public int getLayoutId()
  {
    return p.e.fts_add_friend_ui;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(111857);
    lg locallg = new lg();
    locallg.ud(this.mSessionId);
    locallg.isX = 2L;
    locallg.bMH();
    finish();
    AppMethodBeat.o(111857);
  }
  
  public void onClickBackBtn(View paramView)
  {
    AppMethodBeat.i(111854);
    super.onClickBackBtn(paramView);
    paramView = new lg();
    paramView.ud(this.mSessionId);
    paramView.isX = 2L;
    paramView.bMH();
    AppMethodBeat.o(111854);
  }
  
  public void onClickClearTextBtn(View paramView)
  {
    AppMethodBeat.i(111868);
    super.onClickClearTextBtn(paramView);
    if (!this.Hye.getFtsEditText().dzv.hasFocus())
    {
      this.Hye.getFtsEditText().aWT();
      showVKB();
    }
    AppMethodBeat.o(111868);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(111853);
    super.onCreate(paramBundle);
    this.mSessionId = g.getMessageDigest(System.currentTimeMillis().getBytes());
    com.tencent.mm.plugin.fts.a.e.HrM = com.tencent.mm.plugin.fts.a.d.Wd(16);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle = TransitionInflater.from(this).inflateTransition(17760258);
      paramBundle.excludeTarget(getWindow().getDecorView().findViewById(p.d.action_bar_container), true);
      paramBundle.excludeTarget(16908335, true);
      getWindow().setEnterTransition(paramBundle);
    }
    setActionbarColor(getContext().getResources().getColor(p.a.normal_actionbar_color));
    hideActionbarLine();
    setHint(getContext().getResources().getString(p.g.contact_search_ww_account_hint));
    this.HwZ = findViewById(p.d.bg_layout);
    this.Hxa = findViewById(p.d.contact_biz_merge_layout);
    this.Hxb = findViewById(p.d.has_contact_layout);
    this.Hxf = findViewById(p.d.contact_click_layout);
    this.Hxc = findViewById(p.d.no_contact_layout);
    this.Hxd = findViewById(p.d.merge_layout_divider);
    this.Hxe = findViewById(p.d.search_content_layout);
    this.Hxp = ((FTSLocalPageRelevantView)findViewById(p.d.relevant_serach_query));
    this.Hxg = ((ImageView)findViewById(p.d.contact_avatar_iv));
    this.Hxh = ((TextView)findViewById(p.d.contact_title_tv));
    this.Hxi = ((TextView)findViewById(p.d.contact_desc_tv));
    this.Hxj = ((TextView)findViewById(p.d.search_title_tv));
    this.Hxk = ((TextView)findViewById(p.d.contact_error_tv));
    this.Hxl = ((TextView)findViewById(p.d.search_desc_tv));
    try
    {
      paramBundle = al.bix("webSearchBar").optString("wording");
      Log.i("MicroMsg.FTS.FTSAddFriendUI", "set searchNetworkTips %s", new Object[] { paramBundle });
      this.Hxl.setText(paramBundle);
      label350:
      getContentView().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(111846);
          FTSAddWw.this.Hye.getFtsEditText().aWT();
          FTSAddWw.this.Hye.getFtsEditText().aWS();
          AppMethodBeat.o(111846);
        }
      }, 128L);
      this.HwZ.setOnClickListener(new FTSAddWw.2(this));
      h.aZW().a(372, this, this.Hxz);
      AppMethodBeat.o(111853);
      return;
    }
    catch (Exception paramBundle)
    {
      break label350;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(111865);
    super.onDestroy();
    if ((this.Hxm) && (!this.Hxn)) {
      as.u(this.query, this.Hxo, 3, 16);
    }
    AppMethodBeat.o(111865);
  }
  
  public void onEditTextChange(String paramString1, String paramString2, List<FTSSearchView.c> paramList, FTSEditTextView.d paramd)
  {
    AppMethodBeat.i(168766);
    super.onEditTextChange(paramString1, paramString2, paramList, paramd);
    this.Hxm = false;
    AppMethodBeat.o(168766);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(111856);
    super.onResume();
    aj.ipT();
    AppMethodBeat.o(111856);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSAddWw
 * JD-Core Version:    0.7.0.1
 */