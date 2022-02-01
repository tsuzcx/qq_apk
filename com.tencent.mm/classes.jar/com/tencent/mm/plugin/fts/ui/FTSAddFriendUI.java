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
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.api.n;
import com.tencent.mm.f.a.ar.b;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.fts.ui.widget.FTSLocalPageRelevantView;
import com.tencent.mm.plugin.messenger.a.f;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.ak;
import com.tencent.mm.protocal.protobuf.ebn;
import com.tencent.mm.protocal.protobuf.ebo;
import com.tencent.mm.protocal.protobuf.ebp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.FTSEditTextView.c;
import com.tencent.mm.ui.search.a.c;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(3)
public class FTSAddFriendUI
  extends FTSBaseUI
{
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
  private String BMx;
  int BMy;
  private final i callback;
  private long lastClickTime;
  private long pZO;
  private Dialog vgC;
  private ebp wsx;
  
  public FTSAddFriendUI()
  {
    AppMethodBeat.i(111826);
    this.BMs = 1;
    this.callback = new i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(111822);
        com.tencent.mm.kernel.h.aGY().b(106, this);
        FTSAddFriendUI.d(FTSAddFriendUI.this);
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
          switch (paramAnonymousInt2)
          {
          default: 
            FTSAddFriendUI.e(FTSAddFriendUI.this).setText(o.g.no_contact_result);
            label69:
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
          FTSAddFriendUI.e(FTSAddFriendUI.this).setText(FTSAddFriendUI.this.getString(o.g.search_contact_err_no_code));
          break label69;
          paramAnonymousString = com.tencent.mm.h.a.Kb(paramAnonymousString);
          if (paramAnonymousString != null)
          {
            FTSAddFriendUI.e(FTSAddFriendUI.this).setText(paramAnonymousString.desc);
            break label69;
          }
          FTSAddFriendUI.e(FTSAddFriendUI.this).setText(o.g.no_contact_result);
          break label69;
          FTSAddFriendUI.a(FTSAddFriendUI.this, ((f)paramAnonymousq).eRV());
          FTSAddFriendUI localFTSAddFriendUI = FTSAddFriendUI.this;
          paramAnonymousString = (ebo)d.b.b(((f)paramAnonymousq).rr.lBR);
          if (paramAnonymousString != null) {}
          for (paramAnonymousString = z.a(paramAnonymousString.SrH);; paramAnonymousString = "")
          {
            FTSAddFriendUI.a(localFTSAddFriendUI, paramAnonymousString);
            if (FTSAddFriendUI.f(FTSAddFriendUI.this).Tdj <= 0) {
              break label411;
            }
            if (!FTSAddFriendUI.f(FTSAddFriendUI.this).Tdk.isEmpty()) {
              break;
            }
            com.tencent.mm.ui.base.h.a(FTSAddFriendUI.this, o.g.search_contact_not_found, 0, true, null);
            AppMethodBeat.o(111822);
            return;
          }
          paramAnonymousString = new Intent();
          paramAnonymousString.putExtra("add_more_friend_search_scene", 3);
          if (FTSAddFriendUI.f(FTSAddFriendUI.this).Tdk.size() > 1) {
            try
            {
              paramAnonymousString.putExtra("result", FTSAddFriendUI.f(FTSAddFriendUI.this).toByteArray());
              com.tencent.mm.by.c.b(FTSAddFriendUI.this.getContext(), "subapp", ".ui.pluginapp.ContactSearchResultUI", paramAnonymousString);
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
          ((n)com.tencent.mm.kernel.h.ae(n.class)).a(paramAnonymousString, (ebn)FTSAddFriendUI.f(FTSAddFriendUI.this).Tdk.getFirst(), FTSAddFriendUI.this.BMy);
          label411:
          FTSAddFriendUI.a(FTSAddFriendUI.this, 1);
          FTSAddFriendUI.g(FTSAddFriendUI.this);
        }
      }
    };
    this.BMy = -1;
    AppMethodBeat.o(111826);
  }
  
  private void aIg(final String paramString)
  {
    AppMethodBeat.i(111838);
    this.BMq = true;
    this.BMr = false;
    this.BMs = 1;
    if ((paramString == null) || (paramString.length() == 0) || (paramString.trim().length() == 0))
    {
      AppMethodBeat.o(111838);
      return;
    }
    if (Character.isDigit(paramString.charAt(0))) {}
    for (int i = 15;; i = 3)
    {
      this.BMy = i;
      this.BMv = 0;
      this.BMw = 0;
      com.tencent.mm.kernel.h.aGY().a(106, this.callback);
      paramString = new f(paramString, 3);
      com.tencent.mm.kernel.h.aGY().a(paramString, 0);
      getString(o.g.app_tip);
      this.vgC = com.tencent.mm.ui.base.h.a(this, getString(o.g.search_contact_doing), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(111823);
          com.tencent.mm.kernel.h.aGY().a(paramString);
          com.tencent.mm.kernel.h.aGY().b(106, FTSAddFriendUI.i(FTSAddFriendUI.this));
          FTSAddFriendUI.j(FTSAddFriendUI.this);
          AppMethodBeat.o(111823);
        }
      });
      AppMethodBeat.o(111838);
      return;
    }
  }
  
  private void ery()
  {
    AppMethodBeat.i(111836);
    if (Util.nullAsNil(z.a(this.wsx.SrH)).length() > 0)
    {
      if (2 != this.wsx.Ugt) {
        break label130;
      }
      this.BMy = 15;
    }
    for (;;)
    {
      Intent localIntent = new Intent();
      ((n)com.tencent.mm.kernel.h.ae(n.class)).a(localIntent, this.wsx, this.BMy);
      if ((this.BMy == 15) && (2 == this.wsx.Ugt)) {
        localIntent.putExtra("Contact_Search_Mobile", this.BMx);
      }
      localIntent.putExtra("add_more_friend_search_scene", 2);
      com.tencent.mm.by.c.b(this, "profile", ".ui.ContactInfoUI", localIntent);
      AppMethodBeat.o(111836);
      return;
      label130:
      if (1 == this.wsx.Ugt) {
        this.BMy = 1;
      }
    }
  }
  
  private void erz()
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
    if (this.BMu == null) {
      this.BMu = new c(parame);
    }
    parame = this.BMu;
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
      aIg(parama.BHY.BIw);
    }
    AppMethodBeat.o(111831);
  }
  
  public final void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.c paramc)
  {
    AppMethodBeat.i(168765);
    super.a(paramString1, paramString2, paramList, paramc);
    this.BMq = false;
    AppMethodBeat.o(168765);
  }
  
  public final boolean aDV()
  {
    AppMethodBeat.i(111833);
    aIg(this.query);
    hideVKB();
    AppMethodBeat.o(111833);
    return true;
  }
  
  protected final void erw()
  {
    AppMethodBeat.i(111834);
    super.erw();
    this.BMe.setVisibility(8);
    AppMethodBeat.o(111834);
  }
  
  protected final void erx()
  {
    AppMethodBeat.i(111835);
    super.erx();
    this.BMe.setVisibility(8);
    AppMethodBeat.o(111835);
  }
  
  public int getLayoutId()
  {
    return o.e.fts_add_friend_ui;
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
    if (!this.BMN.getFtsEditText().bGw.hasFocus())
    {
      this.BMN.getFtsEditText().aDU();
      showVKB();
    }
    AppMethodBeat.o(111840);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(111827);
    super.onCreate(paramBundle);
    com.tencent.mm.plugin.fts.a.e.BHi = com.tencent.mm.plugin.fts.a.d.Sw(16);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle = TransitionInflater.from(this).inflateTransition(17760258);
      paramBundle.excludeTarget(getWindow().getDecorView().findViewById(o.d.action_bar_container), true);
      paramBundle.excludeTarget(16908335, true);
      getWindow().setEnterTransition(paramBundle);
    }
    setActionbarColor(getContext().getResources().getColor(o.a.normal_actionbar_color));
    setHint(getContext().getResources().getString(o.g.contact_search_account_hint));
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
      label320:
      getContentView().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(111818);
          FTSAddFriendUI.this.BMN.getFtsEditText().aDU();
          FTSAddFriendUI.this.BMN.getFtsEditText().aDT();
          AppMethodBeat.o(111818);
        }
      }, 128L);
      this.BMd.setOnClickListener(new FTSAddFriendUI.2(this));
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
    com.tencent.mm.kernel.h.aGY().b(106, this.callback);
    if ((this.BMq) && (!this.BMr)) {
      com.tencent.mm.plugin.websearch.api.ar.u(this.query, this.BMs, 3, 16);
    }
    AppMethodBeat.o(111837);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(111828);
    super.onResume();
    ai.gQJ();
    AppMethodBeat.o(111828);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSAddFriendUI
 * JD-Core Version:    0.7.0.1
 */