package com.tencent.mm.plugin.account.bind.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.bq.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.plugin.account.friend.a.y;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;

public class BindQQUI
  extends MMWizardActivity
  implements f
{
  private String gts = null;
  private String gtt = null;
  com.tencent.mm.ui.base.p tipDialog;
  private int type = 0;
  
  public int getLayoutId()
  {
    return 2130968853;
  }
  
  public void initView()
  {
    AppMethodBeat.i(13558);
    long l = new com.tencent.mm.a.p(bo.g((Integer)g.RL().Ru().get(9, null))).longValue();
    Object localObject;
    if (l == 0L)
    {
      setMMTitle(2131297641);
      localObject = (TextView)findViewById(2131821819);
      ((TextView)localObject).setVisibility(8);
      ((TextView)localObject).setText(2131297639);
      ((TextView)findViewById(2131821818)).setVisibility(8);
      localObject = (Button)findViewById(2131821820);
      ((Button)localObject).setVisibility(0);
      ((Button)localObject).setText(2131297638);
      ((Button)localObject).setOnClickListener(new BindQQUI.5(this));
      removeOptionMenu(1);
    }
    while (this.type == 1)
    {
      addTextOptionMenu(0, getString(2131296980), new BindQQUI.1(this));
      AppMethodBeat.o(13558);
      return;
      setMMTitle(2131297637);
      localObject = (TextView)findViewById(2131821819);
      ((TextView)localObject).setVisibility(8);
      ((TextView)localObject).setText(2131297635);
      localObject = (TextView)findViewById(2131821818);
      ((TextView)localObject).setVisibility(0);
      ((TextView)localObject).setText(getString(2131297636) + l);
      localObject = (Button)findViewById(2131821820);
      ((Button)localObject).setVisibility(8);
      ((Button)localObject).setText(2131300603);
      ((Button)localObject).setOnClickListener(new BindQQUI.6(this));
      addIconOptionMenu(1, 2130839668, new BindQQUI.7(this));
    }
    setBackBtn(new BindQQUI.4(this));
    AppMethodBeat.o(13558);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(13561);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ab.d("MicroMsg.BindQQUI", "summerunbind onAcvityResult requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(13561);
      return;
      if (paramInt2 == -1)
      {
        ab.i("MicroMsg.BindQQUI", "summerunbind REQUEST_CODE_SET_PSW ok and start NetSceneCheckUnBind again qq");
        paramIntent = new y(y.gxX);
        g.Rc().a(paramIntent, 0);
        getString(2131297087);
        this.tipDialog = h.b(this, getString(2131296987), true, new BindQQUI.3(this));
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(13554);
    super.onCreate(paramBundle);
    this.type = getIntent().getIntExtra("bindqq_regbymobile", 0);
    g.Rc().a(254, this);
    g.Rc().a(255, this);
    AppMethodBeat.o(13554);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(13555);
    g.Rc().b(254, this);
    g.Rc().b(255, this);
    super.onDestroy();
    AppMethodBeat.o(13555);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(13556);
    super.onResume();
    initView();
    AppMethodBeat.o(13556);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(13560);
    ab.d("MicroMsg.BindQQUI", "onSceneEnd " + paramInt1 + " errCode " + paramInt2 + " errMsg " + paramString + "  " + paramm.getType());
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    if (paramm.getType() == 254)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.gts = ((y)paramm).aqB();
        if ((this.gts != null) && (this.gts.length() > 0)) {
          g.RL().Ru().set(102407, this.gts);
        }
        if (!bo.isNullOrNil(this.gtt))
        {
          paramString = new Intent(this, StartUnbindQQ.class);
          paramString.putExtra("notice", this.gtt);
          J(this, paramString);
          AppMethodBeat.o(13560);
          return;
        }
        paramString = new t(2);
        g.Rc().a(paramString, 0);
        AppMethodBeat.o(13560);
        return;
      }
      if (this.tipDialog != null)
      {
        this.tipDialog.dismiss();
        this.tipDialog = null;
      }
      if (paramInt2 == -3)
      {
        ab.d("MicroMsg.BindQQUI", "summerunbind MMFunc_QueryHasPasswd err and set psw");
        h.a(getContext(), getString(2131303498), null, getString(2131303499), getString(2131303497), true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(13552);
            paramAnonymousDialogInterface = new Intent();
            paramAnonymousDialogInterface.putExtra("kintent_hint", BindQQUI.this.getString(2131303496));
            paramAnonymousDialogInterface.putExtra("from_unbind", true);
            d.b(BindQQUI.this, "account", "com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI", paramAnonymousDialogInterface, 1);
            AppMethodBeat.o(13552);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(13560);
        return;
      }
      if (paramInt2 == -81)
      {
        h.a(this, 2131303171, 2131297087, null);
        AppMethodBeat.o(13560);
        return;
      }
      if (paramInt2 == -82)
      {
        h.a(this, 2131303172, 2131297087, null);
        AppMethodBeat.o(13560);
        return;
      }
      if (paramInt2 == -83)
      {
        h.a(this, 2131303169, 2131297087, null);
        AppMethodBeat.o(13560);
        return;
      }
      if (paramInt2 == -84)
      {
        h.a(this, 2131303170, 2131297087, null);
        AppMethodBeat.o(13560);
        return;
      }
      if (paramInt2 == -85)
      {
        h.a(this, 2131303168, 2131297087, null);
        AppMethodBeat.o(13560);
        return;
      }
      if (paramInt2 == -86)
      {
        h.a(this, 2131303174, 2131297087, null);
        AppMethodBeat.o(13560);
      }
    }
    else if (paramm.getType() == 255)
    {
      if (paramInt2 == 0)
      {
        J(this, new Intent(this, StartUnbindQQ.class));
        AppMethodBeat.o(13560);
        return;
      }
      h.a(getContext(), getString(2131303498), null, getString(2131303499), getString(2131303497), true, new BindQQUI.10(this), new BindQQUI.11(this));
    }
    AppMethodBeat.o(13560);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindQQUI
 * JD-Core Version:    0.7.0.1
 */