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
import com.tencent.mm.api.o;
import com.tencent.mm.autogen.a.av;
import com.tencent.mm.autogen.a.av.b;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.ui.widget.FTSLocalPageRelevantView;
import com.tencent.mm.plugin.messenger.a.f;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.plugin.websearch.api.al;
import com.tencent.mm.plugin.websearch.api.as;
import com.tencent.mm.protocal.protobuf.evg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.FTSEditTextView.d;
import com.tencent.mm.ui.search.FTSSearchView;
import com.tencent.mm.ui.search.FTSSearchView.c;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(3)
public class FTSAddFriendUI
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
  private String Hxt;
  int Hxu;
  private final com.tencent.mm.am.h callback;
  private long lastClickTime;
  private long teM;
  private Dialog ysC;
  private evg zOD;
  
  public FTSAddFriendUI()
  {
    AppMethodBeat.i(111826);
    this.Hxo = 1;
    this.callback = new FTSAddFriendUI.5(this);
    this.Hxu = -1;
    AppMethodBeat.o(111826);
  }
  
  private void aEF(final String paramString)
  {
    AppMethodBeat.i(111838);
    this.Hxm = true;
    this.Hxn = false;
    this.Hxo = 1;
    if ((paramString == null) || (paramString.length() == 0) || (paramString.trim().length() == 0))
    {
      AppMethodBeat.o(111838);
      return;
    }
    if (Character.isDigit(paramString.charAt(0))) {}
    for (int i = 15;; i = 3)
    {
      this.Hxu = i;
      this.Hxr = 0;
      this.Hxs = 0;
      com.tencent.mm.kernel.h.aZW().a(106, this.callback);
      paramString = new f(paramString, 3);
      com.tencent.mm.kernel.h.aZW().a(paramString, 0);
      getString(p.g.app_tip);
      this.ysC = k.a(this, getString(p.g.search_contact_doing), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(111823);
          com.tencent.mm.kernel.h.aZW().a(paramString);
          com.tencent.mm.kernel.h.aZW().b(106, FTSAddFriendUI.i(FTSAddFriendUI.this));
          FTSAddFriendUI.j(FTSAddFriendUI.this);
          AppMethodBeat.o(111823);
        }
      });
      AppMethodBeat.o(111838);
      return;
    }
  }
  
  private void fyf()
  {
    AppMethodBeat.i(111836);
    if (Util.nullAsNil(w.a(this.zOD.ZqL)).length() > 0)
    {
      if (2 != this.zOD.abxU) {
        break label130;
      }
      this.Hxu = 15;
    }
    for (;;)
    {
      Intent localIntent = new Intent();
      ((o)com.tencent.mm.kernel.h.ax(o.class)).a(localIntent, this.zOD, this.Hxu);
      if ((this.Hxu == 15) && (2 == this.zOD.abxU)) {
        localIntent.putExtra("Contact_Search_Mobile", this.Hxt);
      }
      localIntent.putExtra("add_more_friend_search_scene", 2);
      com.tencent.mm.br.c.b(this, "profile", ".ui.ContactInfoUI", localIntent);
      AppMethodBeat.o(111836);
      return;
      label130:
      if (1 == this.zOD.abxU) {
        this.Hxu = 1;
      }
    }
  }
  
  private void fyg()
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
    if (this.Hxq == null) {
      this.Hxq = new c(parame);
    }
    parame = this.Hxq;
    AppMethodBeat.o(111830);
    return parame;
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(111831);
    if ((parama instanceof com.tencent.mm.plugin.fts.ui.b.a))
    {
      if (System.currentTimeMillis() - this.lastClickTime <= 1000L)
      {
        AppMethodBeat.o(111831);
        return;
      }
      this.lastClickTime = System.currentTimeMillis();
      aEF(parama.FWt.Hte);
    }
    AppMethodBeat.o(111831);
  }
  
  public final boolean aWU()
  {
    AppMethodBeat.i(111833);
    aEF(this.query);
    hideVKB();
    AppMethodBeat.o(111833);
    return true;
  }
  
  protected final void eui()
  {
    AppMethodBeat.i(111835);
    super.eui();
    this.Hxa.setVisibility(8);
    AppMethodBeat.o(111835);
  }
  
  protected final void fye()
  {
    AppMethodBeat.i(111834);
    super.fye();
    this.Hxa.setVisibility(8);
    AppMethodBeat.o(111834);
  }
  
  public int getLayoutId()
  {
    return p.e.fts_add_friend_ui;
  }
  
  public Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(265650);
    HashSet localHashSet = new HashSet(super.importUIComponents());
    localHashSet.add(com.tencent.mm.plugin.fts.ui.a.a.class);
    AppMethodBeat.o(265650);
    return localHashSet;
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
    if (!this.Hye.getFtsEditText().dzv.hasFocus())
    {
      this.Hye.getFtsEditText().aWT();
      showVKB();
    }
    AppMethodBeat.o(111840);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(111827);
    super.onCreate(paramBundle);
    com.tencent.mm.plugin.fts.a.e.HrM = com.tencent.mm.plugin.fts.a.d.Wd(16);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle = TransitionInflater.from(this).inflateTransition(17760258);
      paramBundle.excludeTarget(getWindow().getDecorView().findViewById(p.d.action_bar_container), true);
      paramBundle.excludeTarget(16908335, true);
      getWindow().setEnterTransition(paramBundle);
    }
    setActionbarColor(getContext().getResources().getColor(p.a.normal_actionbar_color));
    setHint(getContext().getResources().getString(p.g.contact_search_account_hint));
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
      label320:
      getContentView().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(111818);
          FTSAddFriendUI.this.Hye.getFtsEditText().aWT();
          FTSAddFriendUI.this.Hye.getFtsEditText().aWS();
          AppMethodBeat.o(111818);
        }
      }, 128L);
      this.HwZ.setOnClickListener(new FTSAddFriendUI.2(this));
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
    com.tencent.mm.kernel.h.aZW().b(106, this.callback);
    if ((this.Hxm) && (!this.Hxn)) {
      as.u(this.query, this.Hxo, 3, 16);
    }
    AppMethodBeat.o(111837);
  }
  
  public void onEditTextChange(String paramString1, String paramString2, List<FTSSearchView.c> paramList, FTSEditTextView.d paramd)
  {
    AppMethodBeat.i(168765);
    super.onEditTextChange(paramString1, paramString2, paramList, paramd);
    this.Hxm = false;
    AppMethodBeat.o(168765);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(111828);
    super.onResume();
    aj.ipT();
    AppMethodBeat.o(111828);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSAddFriendUI
 * JD-Core Version:    0.7.0.1
 */