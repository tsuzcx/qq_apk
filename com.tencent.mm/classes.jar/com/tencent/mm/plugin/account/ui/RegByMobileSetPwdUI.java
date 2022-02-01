package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.modelsimple.z;
import com.tencent.mm.plugin.account.a.b.a.a;
import com.tencent.mm.plugin.account.bind.ui.BindMContactUI;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ha;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.af;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import java.io.IOException;

public class RegByMobileSetPwdUI
  extends SetPwdUI
{
  private String dgo = null;
  private String hint = null;
  private TextView itt;
  private TextView iwl;
  private View iwm;
  private View iwn;
  private TextView iwo;
  public View iwp;
  public EditText iwq;
  private boolean iwr = false;
  public boolean iws;
  private int iwt = 0;
  private SKBuiltinBuffer_t iwu = null;
  
  protected final void a(a.a parama)
  {
    AppMethodBeat.i(128613);
    switch (3.iow[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(128613);
      return;
      h.j(this, 2131762344, 2131762346);
      AppMethodBeat.o(128613);
      return;
      h.j(this, 2131762345, 2131762346);
      AppMethodBeat.o(128613);
      return;
      h.j(this, 2131764656, 2131762346);
      AppMethodBeat.o(128613);
      return;
      h.j(this, 2131764660, 2131762346);
    }
  }
  
  protected final n aKi()
  {
    AppMethodBeat.i(128610);
    if (bt.isNullOrNil(this.dgo)) {
      this.dgo = ((String)g.afB().afk().get(77830, null));
    }
    z localz = new z(this.ixH, this.dgo, this.iwt, this.iwu);
    AppMethodBeat.o(128610);
    return localz;
  }
  
  protected final String aKj()
  {
    AppMethodBeat.i(128609);
    String str = ((EditText)findViewById(2131303957)).getText().toString();
    AppMethodBeat.o(128609);
    return str;
  }
  
  protected final String aKk()
  {
    AppMethodBeat.i(128611);
    String str = ((EditText)findViewById(2131303956)).getText().toString();
    AppMethodBeat.o(128611);
    return str;
  }
  
  protected final void aKs()
  {
    AppMethodBeat.i(128612);
    if ((bt.isNullOrNil(this.dgo)) && (this.iws))
    {
      com.tencent.mm.modelsimple.ac localac = new com.tencent.mm.modelsimple.ac(this.iwq.getText().toString(), "", "", "");
      g.aeS().a(localac, 0);
      getString(2131755906);
      this.fpP = h.b(this, getString(2131755886), false, null);
      AppMethodBeat.o(128612);
      return;
    }
    super.aKs();
    AppMethodBeat.o(128612);
  }
  
  public final boolean aKt()
  {
    return true;
  }
  
  public int getLayoutId()
  {
    return 2131495242;
  }
  
  public void initView()
  {
    AppMethodBeat.i(128608);
    if (!this.lA) {
      showMMLogo();
    }
    setMMTitle(2131762361);
    this.iwl = ((TextView)findViewById(2131306253));
    this.iwn = findViewById(2131296331);
    this.itt = ((TextView)findViewById(2131303951));
    this.iwo = ((TextView)findViewById(2131296339));
    if ((this.hint != null) && (this.hint.length() > 0)) {
      this.itt.setText(this.hint);
    }
    this.iwp = findViewById(2131303949);
    this.iwq = ((EditText)this.iwp.findViewById(2131303955));
    this.iwm = findViewById(2131300225);
    this.iwm.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(128602);
        paramAnonymousView = (String)g.afB().afk().get(6, null);
        if (bt.isNullOrNil(paramAnonymousView))
        {
          ad.i("MicorMsg.RegByMobileSetPwdUI", "has not bind mobile");
          paramAnonymousView = new Intent(RegByMobileSetPwdUI.this, BindMContactUI.class);
          paramAnonymousView.putExtra("bind_scene", 4);
          h.a(RegByMobileSetPwdUI.this, RegByMobileSetPwdUI.this.getString(2131762354), "", RegByMobileSetPwdUI.this.getString(2131756550), RegByMobileSetPwdUI.this.getString(2131755691), true, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(128600);
              MMWizardActivity.V(RegByMobileSetPwdUI.this, paramAnonymousView);
              AppMethodBeat.o(128600);
            }
          }, null);
          AppMethodBeat.o(128602);
          return;
        }
        ad.i("MicorMsg.RegByMobileSetPwdUI", "has bind mobile");
        h.a(RegByMobileSetPwdUI.this, RegByMobileSetPwdUI.this.getString(2131762352, new Object[] { paramAnonymousView }), "", RegByMobileSetPwdUI.this.getString(2131755884), RegByMobileSetPwdUI.this.getString(2131755691), true, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(128601);
            paramAnonymous2DialogInterface = new Intent(RegByMobileSetPwdUI.this, MobileVerifyUI.class);
            paramAnonymous2DialogInterface.putExtra("bindmcontact_mobile", paramAnonymousView);
            paramAnonymous2DialogInterface.putExtra("mobile_verify_purpose", 5);
            RegByMobileSetPwdUI.this.startActivityForResult(paramAnonymous2DialogInterface, 10001);
            AppMethodBeat.o(128601);
          }
        }, null);
        AppMethodBeat.o(128602);
      }
    });
    if ((this.iwr) || (!g.afz().aeI()))
    {
      this.iwn.setVisibility(8);
      localObject1 = (TextView)findViewById(2131303001);
      localObject2 = (TextView)findViewById(2131303146);
      TextView localTextView = (TextView)findViewById(2131298573);
      EditText localEditText1 = (EditText)findViewById(2131303957);
      EditText localEditText2 = (EditText)findViewById(2131303956);
      if (!com.tencent.mm.sdk.platformtools.ac.eFq())
      {
        ((TextView)localObject1).setTextSize(1, 14.0F);
        ((TextView)localObject2).setTextSize(1, 14.0F);
        localTextView.setTextSize(1, 14.0F);
        localEditText1.setTextSize(1, 14.0F);
        localEditText2.setTextSize(1, 14.0F);
      }
      float f1 = this.iwo.getPaint().measureText(this.iwo.getText().toString());
      float f2 = ((TextView)localObject1).getPaint().measureText(((TextView)localObject1).getText().toString());
      float f3 = ((TextView)localObject2).getPaint().measureText(((TextView)localObject2).getText().toString());
      float f4 = localTextView.getPaint().measureText(localTextView.getText().toString());
      f1 = Math.max(Math.max(Math.max(f1, f3), f4), f2);
      ((TextView)localObject1).setWidth((int)f1);
      this.iwo.setWidth((int)f1);
      ((TextView)localObject2).setWidth((int)f1);
      ((TextView)localObject2).setWidth((int)f1);
      AppMethodBeat.o(128608);
      return;
    }
    this.iwn.setVisibility(0);
    Object localObject2 = u.aqH();
    Object localObject1 = localObject2;
    if (bt.isNullOrNil((String)localObject2))
    {
      localObject2 = u.aqG();
      localObject1 = localObject2;
      if (af.aHK((String)localObject2)) {
        localObject1 = null;
      }
    }
    if (bt.isNullOrNil((String)localObject1))
    {
      localObject2 = (String)g.afB().afk().get(6, null);
      localObject1 = (String)g.afB().afk().get(5, null);
      if (!bt.isNullOrNil((String)localObject2)) {
        if (bt.aGq((String)localObject2).booleanValue())
        {
          new com.tencent.mm.sdk.platformtools.ba();
          localObject1 = "86";
          if (!((String)localObject2).startsWith("+")) {
            break label691;
          }
          localObject2 = ((String)localObject2).replace("+", "");
          localObject1 = com.tencent.mm.sdk.platformtools.ba.aew((String)localObject2);
          if (localObject1 == null) {
            break label688;
          }
          localObject2 = ((String)localObject2).substring(((String)localObject1).length());
        }
      }
    }
    label688:
    label691:
    for (;;)
    {
      localObject1 = com.tencent.mm.sdk.platformtools.ba.formatNumber((String)localObject1, (String)localObject2);
      this.iwo.setText(2131763280);
      this.iwl.setText((CharSequence)localObject1);
      this.itt.setText(2131762363);
      break;
      if (!bt.isNullOrNil((String)localObject1))
      {
        this.iwl.setText((CharSequence)localObject1);
        this.iwo.setText(2131763209);
        this.itt.setText(2131762362);
        break;
      }
      this.iwn.setVisibility(8);
      break;
      this.iwo.setText(2131763490);
      this.iwl.setText((CharSequence)localObject1);
      break;
    }
  }
  
  protected final boolean o(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(128614);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      finish();
      AppMethodBeat.o(128614);
      return true;
    }
    boolean bool = n(paramInt1, paramInt2, paramString);
    AppMethodBeat.o(128614);
    return bool;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(128616);
    if ((paramInt1 == 10001) && (paramInt2 == -1))
    {
      paramIntent = paramIntent.getStringExtra("setpwd_ticket");
      ad.i("MicorMsg.RegByMobileSetPwdUI", "get reset pwd ticket %s", new Object[] { paramIntent });
      if (!bt.isNullOrNil(paramIntent))
      {
        this.dgo = paramIntent;
        this.iwt = 6;
        this.iwp.setVisibility(8);
        this.iwm.setVisibility(8);
      }
    }
    AppMethodBeat.o(128616);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128605);
    super.onCreate(paramBundle);
    this.hint = getIntent().getStringExtra("kintent_hint");
    this.lA = getIntent().getBooleanExtra("kintent_cancelable", true);
    this.iwr = getIntent().getBooleanExtra("from_unbind", false);
    g.aeS().a(384, this);
    g.aeS().a(255, this);
    initView();
    paramBundle = bt.aGd(com.tencent.mm.model.ba.asa().getString("_auth_key", ""));
    ha localha = new ha();
    if (!bt.cw(paramBundle)) {}
    for (this.iwu = new SKBuiltinBuffer_t().setBuffer(paramBundle);; this.iwu = new SKBuiltinBuffer_t().setBuffer(new byte[0])) {
      try
      {
        localha.parseFrom(paramBundle);
        paramBundle = new t(1);
        g.aeS().a(paramBundle, 0);
        getString(2131755906);
        this.fpP = h.b(this, getString(2131755804), false, null);
        AppMethodBeat.o(128605);
        return;
      }
      catch (IOException paramBundle)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicorMsg.RegByMobileSetPwdUI", paramBundle, "summersetpwd Failed parse autoauthkey buf", new Object[0]);
        }
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128606);
    super.onDestroy();
    g.aeS().b(384, this);
    g.aeS().b(255, this);
    AppMethodBeat.o(128606);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(128607);
    super.onNewIntent(paramIntent);
    paramIntent = paramIntent.getStringExtra("setpwd_ticket");
    ad.i("MicorMsg.RegByMobileSetPwdUI", "onNewIntent get reset pwd ticket %s", new Object[] { paramIntent });
    if (!bt.isNullOrNil(paramIntent))
    {
      this.dgo = paramIntent;
      this.iwt = 4;
      this.iwp.setVisibility(8);
      this.iwm.setVisibility(8);
    }
    AppMethodBeat.o(128607);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(128615);
    ad.i("MicorMsg.RegByMobileSetPwdUI", "errorCode %d, errorMsg %s, scene %s", new Object[] { Integer.valueOf(paramInt2), paramString, paramn });
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramn);
    if (paramn.getType() == 255)
    {
      if (((t)paramn).hsn == 1)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          this.iwp.setVisibility(0);
          this.iwm.setVisibility(0);
          this.iws = true;
          AppMethodBeat.o(128615);
          return;
        }
        if ((paramInt2 == -3) && (paramInt1 == 4))
        {
          this.iws = false;
          AppMethodBeat.o(128615);
          return;
        }
        this.iwp.setVisibility(0);
        this.iwm.setVisibility(0);
        paramString = com.tencent.mm.h.a.oG(paramString);
        if (paramString != null)
        {
          ad.i("MicorMsg.RegByMobileSetPwdUI", "summertips errCode[%d], showType[%d], url[%s], desc[%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramString.dcz), paramString.url, paramString.desc });
          h.a(this, paramString.desc, paramString.Title, false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(128603);
              RegByMobileSetPwdUI.this.finish();
              AppMethodBeat.o(128603);
            }
          });
        }
        AppMethodBeat.o(128615);
      }
    }
    else if (paramn.getType() == 384)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        g.afB().afk().set(77830, ((com.tencent.mm.modelsimple.ac)paramn).axz());
        aKH();
        AppMethodBeat.o(128615);
        return;
      }
      h.j(this, 2131762356, 2131755906);
    }
    AppMethodBeat.o(128615);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI
 * JD-Core Version:    0.7.0.1
 */