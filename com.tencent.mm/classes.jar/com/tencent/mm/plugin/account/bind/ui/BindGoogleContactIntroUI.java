package com.tencent.mm.plugin.account.bind.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.w;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public class BindGoogleContactIntroUI
  extends MMActivity
  implements f
{
  private ImageView gsk;
  private TextView gsl;
  private Button gsm;
  private Button gsn;
  private boolean gso;
  private boolean gsp;
  private String gsq;
  private ProgressDialog gsr;
  private w gss;
  private int gst;
  private View.OnClickListener gsu;
  private View.OnClickListener gsv;
  
  public BindGoogleContactIntroUI()
  {
    AppMethodBeat.i(13337);
    this.gso = false;
    this.gsp = false;
    this.gsu = new BindGoogleContactIntroUI.1(this);
    this.gsv = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(13334);
        h.a(BindGoogleContactIntroUI.this.getContext(), true, BindGoogleContactIntroUI.this.getString(2131304404), "", BindGoogleContactIntroUI.this.getString(2131304403), BindGoogleContactIntroUI.this.getString(2131296888), new BindGoogleContactIntroUI.2.1(this), new BindGoogleContactIntroUI.2.2(this));
        AppMethodBeat.o(13334);
      }
    };
    AppMethodBeat.o(13337);
  }
  
  private void apr()
  {
    AppMethodBeat.i(13343);
    this.gsn.setVisibility(8);
    this.gsm.setVisibility(0);
    this.gsk.setVisibility(0);
    this.gsl.setVisibility(0);
    this.gsl.setText(2131297549);
    this.gsm.setText(2131297547);
    this.gsm.setOnClickListener(this.gsu);
    AppMethodBeat.o(13343);
  }
  
  public int getLayoutId()
  {
    return 2130968845;
  }
  
  public void initView()
  {
    AppMethodBeat.i(13342);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(13335);
        BindGoogleContactIntroUI.this.finish();
        AppMethodBeat.o(13335);
        return true;
      }
    });
    this.gsk = ((ImageView)findViewById(2131821789));
    this.gsl = ((TextView)findViewById(2131821790));
    this.gsm = ((Button)findViewById(2131821791));
    this.gsn = ((Button)findViewById(2131821792));
    AppMethodBeat.o(13342);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(13344);
    ab.i("MicroMsg.GoogleContact.BindGoogleContactIntroUI", "requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt2 == -1)
    {
      if (paramInt1 == 2005)
      {
        this.gso = paramIntent.getBooleanExtra("gpservices", false);
        AppMethodBeat.o(13344);
      }
    }
    else if (paramInt1 == 2005) {
      this.gso = paramIntent.getBooleanExtra("gpservices", false);
    }
    AppMethodBeat.o(13344);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(13338);
    super.onCreate(paramBundle);
    setMMTitle(2131297550);
    this.gst = getIntent().getIntExtra("enter_scene", 0);
    this.gso = com.tencent.mm.plugin.account.friend.a.m.cD(this);
    if (this.gso) {
      startActivityForResult(new Intent("com.tencent.mm.gms.CHECK_GP_SERVICES"), 2005);
    }
    AppMethodBeat.o(13338);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(13341);
    super.onDestroy();
    AppMethodBeat.o(13341);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(13339);
    super.onResume();
    this.gsq = ((String)g.RL().Ru().get(208903, null));
    if (TextUtils.isEmpty(this.gsq))
    {
      this.gsp = false;
      initView();
      if (!this.gsp) {
        break label140;
      }
      this.gsn.setVisibility(0);
      this.gsm.setVisibility(8);
      this.gsl.setVisibility(0);
      this.gsl.setText(getString(2131297548, new Object[] { this.gsq }));
      this.gsn.setOnClickListener(this.gsv);
    }
    for (;;)
    {
      g.Rc().a(487, this);
      AppMethodBeat.o(13339);
      return;
      this.gsp = true;
      break;
      label140:
      apr();
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(13345);
    paramm = paramString;
    if (TextUtils.isEmpty(paramString)) {
      paramm = "";
    }
    ab.i("MicroMsg.GoogleContact.BindGoogleContactIntroUI", "[onSceneEnd] errType:%d,errCode:%d,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramm });
    if ((this.gsr != null) && (this.gsr.isShowing())) {
      this.gsr.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      g.RL().Ru().set(208903, "");
      g.RL().Ru().set(208901, "");
      g.RL().Ru().set(208902, "");
      g.RL().Ru().set(208905, Boolean.TRUE);
      g.RL().Ru().dww();
      apr();
      h.bO(this, getString(2131304405));
      AppMethodBeat.o(13345);
      return;
    }
    ab.i("MicroMsg.GoogleContact.BindGoogleContactIntroUI", "unbind failed");
    Toast.makeText(this, 2131300494, 0).show();
    AppMethodBeat.o(13345);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(13340);
    super.onStop();
    g.Rc().b(487, this);
    AppMethodBeat.o(13340);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindGoogleContactIntroUI
 * JD-Core Version:    0.7.0.1
 */