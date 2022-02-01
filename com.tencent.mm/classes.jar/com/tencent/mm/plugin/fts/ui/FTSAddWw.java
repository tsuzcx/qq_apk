package com.tencent.mm.plugin.fts.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
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
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.f.b.a.iw;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.openim.b.n;
import com.tencent.mm.plugin.fts.ui.widget.FTSLocalPageRelevantView;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.ak;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.protocal.protobuf.dfh;
import com.tencent.mm.protocal.protobuf.ecg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.f.d;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.FTSEditTextView.c;
import com.tencent.mm.ui.search.a.c;
import java.util.List;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(3)
public class FTSAddWw
  extends FTSBaseUI
{
  private ecg BMC;
  private com.tencent.mm.an.b.a BMD;
  private View BMd;
  private View BMe;
  private View BMf;
  private View BMg;
  private View BMh;
  private View BMi;
  private View BMj;
  private ImageView BMk;
  private TextView BMl;
  private TextView BMm;
  private TextView BMn;
  private TextView BMo;
  private TextView BMp;
  private boolean BMq;
  protected boolean BMr;
  private int BMs;
  private FTSLocalPageRelevantView BMt;
  private c BMu;
  private int BMv;
  private int BMw;
  int BMy;
  private long lastClickTime;
  private String mSessionId;
  private String una;
  private Dialog vgC;
  
  public FTSAddWw()
  {
    AppMethodBeat.i(190694);
    this.una = "";
    this.BMs = 1;
    this.mSessionId = "";
    this.BMy = -1;
    this.BMD = new com.tencent.mm.an.b.a() {};
    AppMethodBeat.o(190694);
  }
  
  private void aIg(final String paramString)
  {
    AppMethodBeat.i(111866);
    this.BMq = true;
    this.BMr = false;
    this.BMs = 1;
    if ((paramString == null) || (paramString.length() == 0) || (paramString.trim().length() == 0))
    {
      AppMethodBeat.o(111866);
      return;
    }
    if (Character.isDigit(paramString.charAt(0))) {}
    for (int i = 15;; i = 3)
    {
      this.BMy = i;
      this.BMv = 0;
      this.BMw = 0;
      paramString = new n(paramString);
      com.tencent.mm.kernel.h.aGY().a(paramString, 0);
      getString(o.g.app_tip);
      this.vgC = com.tencent.mm.ui.base.h.a(this, getString(o.g.search_contact_doing), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(111851);
          com.tencent.mm.kernel.h.aGY().a(paramString);
          FTSAddWw.h(FTSAddWw.this);
          AppMethodBeat.o(111851);
        }
      });
      AppMethodBeat.o(111866);
      return;
    }
  }
  
  private void ery()
  {
    AppMethodBeat.i(111864);
    String str = this.BMC.UserName;
    if (Util.nullAsNil(str).length() > 0)
    {
      if (2 != this.BMC.Ugt) {
        break label259;
      }
      this.BMy = 15;
    }
    for (;;)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("Contact_User", str);
      localIntent.putExtra(f.d.VRW, this.BMC.Tav);
      if ((this.BMy == 15) && (2 == this.BMC.Ugt)) {
        localIntent.putExtra("Contact_Search_Mobile", this.una.trim());
      }
      localIntent.putExtra("key_add_contact_openim_appid", this.BMC.lVG);
      localIntent.putExtra("Contact_Nick", this.BMC.rWI);
      localIntent.putExtra("Contact_PyInitial", this.BMC.Sqa);
      localIntent.putExtra("Contact_QuanPin", this.BMC.Sqb);
      localIntent.putExtra("Contact_Sex", this.BMC.mVy);
      localIntent.putExtra("key_add_contact_custom_detail_visible", this.BMC.UgX.TNd);
      localIntent.putExtra("key_add_contact_custom_detail", this.BMC.UgX.COk);
      localIntent.putExtra("Contact_Scene", this.BMy);
      localIntent.putExtra("key_ww_add_session_id", this.mSessionId);
      localIntent.putExtra("add_more_friend_search_scene", 2);
      com.tencent.mm.by.c.b(this, "profile", ".ui.ContactInfoUI", localIntent);
      AppMethodBeat.o(111864);
      return;
      label259:
      if (1 == this.BMC.Ugt) {
        this.BMy = 1;
      }
    }
  }
  
  private void erz()
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
    if (this.BMu == null) {
      this.BMu = new c(parame);
    }
    parame = this.BMu;
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
      this.una = parama.BHY.BIw;
      aIg(parama.BHY.BIw);
      parama = new iw();
      parama.zS(this.mSessionId);
      parama.gzc = 1L;
      parama.bpa();
    }
    AppMethodBeat.o(111859);
  }
  
  public final void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.c paramc)
  {
    AppMethodBeat.i(168766);
    super.a(paramString1, paramString2, paramList, paramc);
    this.BMq = false;
    AppMethodBeat.o(168766);
  }
  
  public final boolean aDV()
  {
    AppMethodBeat.i(111861);
    aIg(this.query);
    hideVKB();
    AppMethodBeat.o(111861);
    return true;
  }
  
  protected final void erA()
  {
    AppMethodBeat.i(111855);
    super.erA();
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(111848);
        paramAnonymousMenuItem = new iw();
        paramAnonymousMenuItem.zS(FTSAddWw.a(FTSAddWw.this));
        paramAnonymousMenuItem.gzc = 2L;
        paramAnonymousMenuItem.bpa();
        FTSAddWw.this.finish();
        AppMethodBeat.o(111848);
        return true;
      }
    });
    AppMethodBeat.o(111855);
  }
  
  protected final void erw()
  {
    AppMethodBeat.i(111862);
    super.erw();
    this.BMe.setVisibility(8);
    AppMethodBeat.o(111862);
  }
  
  protected final void erx()
  {
    AppMethodBeat.i(111863);
    super.erx();
    iw localiw = new iw();
    localiw.zS(this.mSessionId);
    localiw.gzc = 3L;
    localiw.bpa();
    this.BMe.setVisibility(8);
    AppMethodBeat.o(111863);
  }
  
  public int getLayoutId()
  {
    return o.e.fts_add_friend_ui;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(111857);
    iw localiw = new iw();
    localiw.zS(this.mSessionId);
    localiw.gzc = 2L;
    localiw.bpa();
    finish();
    AppMethodBeat.o(111857);
  }
  
  public void onClickBackBtn(View paramView)
  {
    AppMethodBeat.i(111854);
    super.onClickBackBtn(paramView);
    paramView = new iw();
    paramView.zS(this.mSessionId);
    paramView.gzc = 2L;
    paramView.bpa();
    AppMethodBeat.o(111854);
  }
  
  public void onClickClearTextBtn(View paramView)
  {
    AppMethodBeat.i(111868);
    super.onClickClearTextBtn(paramView);
    if (!this.BMN.getFtsEditText().bGw.hasFocus())
    {
      this.BMN.getFtsEditText().aDU();
      showVKB();
    }
    AppMethodBeat.o(111868);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(111853);
    super.onCreate(paramBundle);
    this.mSessionId = com.tencent.xweb.util.d.getMessageDigest(System.currentTimeMillis().getBytes());
    com.tencent.mm.plugin.fts.a.e.BHi = com.tencent.mm.plugin.fts.a.d.Sw(16);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle = TransitionInflater.from(this).inflateTransition(17760258);
      paramBundle.excludeTarget(getWindow().getDecorView().findViewById(o.d.action_bar_container), true);
      paramBundle.excludeTarget(16908335, true);
      getWindow().setEnterTransition(paramBundle);
    }
    setActionbarColor(getContext().getResources().getColor(o.a.normal_actionbar_color));
    hideActionbarLine();
    setHint(getContext().getResources().getString(o.g.contact_search_ww_account_hint));
    this.BMd = findViewById(o.d.bg_layout);
    this.BMe = findViewById(o.d.contact_biz_merge_layout);
    this.BMf = findViewById(o.d.has_contact_layout);
    this.BMj = findViewById(o.d.contact_click_layout);
    this.BMg = findViewById(o.d.no_contact_layout);
    this.BMh = findViewById(o.d.merge_layout_divider);
    this.BMi = findViewById(o.d.search_content_layout);
    this.BMt = ((FTSLocalPageRelevantView)findViewById(o.d.relevant_serach_query));
    this.BMk = ((ImageView)findViewById(o.d.contact_avatar_iv));
    this.BMl = ((TextView)findViewById(o.d.contact_title_tv));
    this.BMm = ((TextView)findViewById(o.d.contact_desc_tv));
    this.BMn = ((TextView)findViewById(o.d.search_title_tv));
    this.BMo = ((TextView)findViewById(o.d.contact_error_tv));
    this.BMp = ((TextView)findViewById(o.d.search_desc_tv));
    try
    {
      paramBundle = ak.biP("webSearchBar").optString("wording");
      Log.i("MicroMsg.FTS.FTSAddFriendUI", "set searchNetworkTips %s", new Object[] { paramBundle });
      this.BMp.setText(paramBundle);
      label351:
      getContentView().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(111846);
          FTSAddWw.this.BMN.getFtsEditText().aDU();
          FTSAddWw.this.BMN.getFtsEditText().aDT();
          AppMethodBeat.o(111846);
        }
      }, 128L);
      this.BMd.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(111847);
          b localb = new b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fts/ui/FTSAddWw$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          FTSAddWw.this.finish();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/FTSAddWw$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(111847);
        }
      });
      paramBundle = com.tencent.mm.kernel.h.aGY();
      com.tencent.mm.an.b.a locala = this.BMD;
      paramBundle.lCJ.a(372, this, "%MainThread%", locala);
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
    if ((this.BMq) && (!this.BMr)) {
      ar.u(this.query, this.BMs, 3, 16);
    }
    AppMethodBeat.o(111865);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(111856);
    super.onResume();
    ai.gQJ();
    AppMethodBeat.o(111856);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSAddWw
 * JD-Core Version:    0.7.0.1
 */