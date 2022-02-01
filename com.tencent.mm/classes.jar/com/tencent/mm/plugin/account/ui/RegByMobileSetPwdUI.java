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
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.u;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.modelsimple.z;
import com.tencent.mm.plugin.account.a.b.a.a;
import com.tencent.mm.plugin.account.bind.ui.BindMContactUI;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.he;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import java.io.IOException;

public class RegByMobileSetPwdUI
  extends SetPwdUI
{
  private String ddJ = null;
  private String hint = null;
  private TextView iTy;
  private TextView iWp;
  private View iWq;
  private View iWr;
  private TextView iWs;
  public View iWt;
  public EditText iWu;
  private boolean iWv = false;
  public boolean iWw;
  private int iWx = 0;
  private SKBuiltinBuffer_t iWy = null;
  
  protected final void a(a.a parama)
  {
    AppMethodBeat.i(128613);
    switch (3.iOC[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(128613);
      return;
      h.l(this, 2131762344, 2131762346);
      AppMethodBeat.o(128613);
      return;
      h.l(this, 2131762345, 2131762346);
      AppMethodBeat.o(128613);
      return;
      h.l(this, 2131764656, 2131762346);
      AppMethodBeat.o(128613);
      return;
      h.l(this, 2131764660, 2131762346);
    }
  }
  
  protected final n aQZ()
  {
    AppMethodBeat.i(128610);
    if (bs.isNullOrNil(this.ddJ)) {
      this.ddJ = ((String)g.agR().agA().get(77830, null));
    }
    z localz = new z(this.iXK, this.ddJ, this.iWx, this.iWy);
    AppMethodBeat.o(128610);
    return localz;
  }
  
  protected final String aRa()
  {
    AppMethodBeat.i(128609);
    String str = ((EditText)findViewById(2131303957)).getText().toString();
    AppMethodBeat.o(128609);
    return str;
  }
  
  protected final String aRb()
  {
    AppMethodBeat.i(128611);
    String str = ((EditText)findViewById(2131303956)).getText().toString();
    AppMethodBeat.o(128611);
    return str;
  }
  
  protected final void aRj()
  {
    AppMethodBeat.i(128612);
    if ((bs.isNullOrNil(this.ddJ)) && (this.iWw))
    {
      com.tencent.mm.modelsimple.ac localac = new com.tencent.mm.modelsimple.ac(this.iWu.getText().toString(), "", "", "");
      g.agi().a(localac, 0);
      getString(2131755906);
      this.fts = h.b(this, getString(2131755886), false, null);
      AppMethodBeat.o(128612);
      return;
    }
    super.aRj();
    AppMethodBeat.o(128612);
  }
  
  public final boolean aRk()
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
    if (!this.mz) {
      showMMLogo();
    }
    setMMTitle(2131762361);
    this.iWp = ((TextView)findViewById(2131306253));
    this.iWr = findViewById(2131296331);
    this.iTy = ((TextView)findViewById(2131303951));
    this.iWs = ((TextView)findViewById(2131296339));
    if ((this.hint != null) && (this.hint.length() > 0)) {
      this.iTy.setText(this.hint);
    }
    this.iWt = findViewById(2131303949);
    this.iWu = ((EditText)this.iWt.findViewById(2131303955));
    this.iWq = findViewById(2131300225);
    this.iWq.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(128602);
        paramAnonymousView = (String)g.agR().agA().get(6, null);
        if (bs.isNullOrNil(paramAnonymousView))
        {
          com.tencent.mm.sdk.platformtools.ac.i("MicorMsg.RegByMobileSetPwdUI", "has not bind mobile");
          paramAnonymousView = new Intent(RegByMobileSetPwdUI.this, BindMContactUI.class);
          paramAnonymousView.putExtra("bind_scene", 4);
          h.a(RegByMobileSetPwdUI.this, RegByMobileSetPwdUI.this.getString(2131762354), "", RegByMobileSetPwdUI.this.getString(2131756550), RegByMobileSetPwdUI.this.getString(2131755691), true, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(128600);
              MMWizardActivity.aj(RegByMobileSetPwdUI.this, paramAnonymousView);
              AppMethodBeat.o(128600);
            }
          }, null);
          AppMethodBeat.o(128602);
          return;
        }
        com.tencent.mm.sdk.platformtools.ac.i("MicorMsg.RegByMobileSetPwdUI", "has bind mobile");
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
    if ((this.iWv) || (!g.agP().afY()))
    {
      this.iWr.setVisibility(8);
      localObject1 = (TextView)findViewById(2131303001);
      localObject2 = (TextView)findViewById(2131303146);
      TextView localTextView = (TextView)findViewById(2131298573);
      EditText localEditText1 = (EditText)findViewById(2131303957);
      EditText localEditText2 = (EditText)findViewById(2131303956);
      if (!ab.eUK())
      {
        ((TextView)localObject1).setTextSize(1, 14.0F);
        ((TextView)localObject2).setTextSize(1, 14.0F);
        localTextView.setTextSize(1, 14.0F);
        localEditText1.setTextSize(1, 14.0F);
        localEditText2.setTextSize(1, 14.0F);
      }
      float f1 = this.iWs.getPaint().measureText(this.iWs.getText().toString());
      float f2 = ((TextView)localObject1).getPaint().measureText(((TextView)localObject1).getText().toString());
      float f3 = ((TextView)localObject2).getPaint().measureText(((TextView)localObject2).getText().toString());
      float f4 = localTextView.getPaint().measureText(localTextView.getText().toString());
      f1 = Math.max(Math.max(Math.max(f1, f3), f4), f2);
      ((TextView)localObject1).setWidth((int)f1);
      this.iWs.setWidth((int)f1);
      ((TextView)localObject2).setWidth((int)f1);
      ((TextView)localObject2).setWidth((int)f1);
      AppMethodBeat.o(128608);
      return;
    }
    this.iWr.setVisibility(0);
    Object localObject2 = u.axx();
    Object localObject1 = localObject2;
    if (bs.isNullOrNil((String)localObject2))
    {
      localObject2 = u.axw();
      localObject1 = localObject2;
      if (ai.aNf((String)localObject2)) {
        localObject1 = null;
      }
    }
    if (bs.isNullOrNil((String)localObject1))
    {
      localObject2 = (String)g.agR().agA().get(6, null);
      localObject1 = (String)g.agR().agA().get(5, null);
      if (!bs.isNullOrNil((String)localObject2)) {
        if (bs.aLH((String)localObject2).booleanValue())
        {
          new az();
          localObject1 = "86";
          if (!((String)localObject2).startsWith("+")) {
            break label691;
          }
          localObject2 = ((String)localObject2).replace("+", "");
          localObject1 = az.ajo((String)localObject2);
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
      localObject1 = az.formatNumber((String)localObject1, (String)localObject2);
      this.iWs.setText(2131763280);
      this.iWp.setText((CharSequence)localObject1);
      this.iTy.setText(2131762363);
      break;
      if (!bs.isNullOrNil((String)localObject1))
      {
        this.iWp.setText((CharSequence)localObject1);
        this.iWs.setText(2131763209);
        this.iTy.setText(2131762362);
        break;
      }
      this.iWr.setVisibility(8);
      break;
      this.iWs.setText(2131763490);
      this.iWp.setText((CharSequence)localObject1);
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
      com.tencent.mm.sdk.platformtools.ac.i("MicorMsg.RegByMobileSetPwdUI", "get reset pwd ticket %s", new Object[] { paramIntent });
      if (!bs.isNullOrNil(paramIntent))
      {
        this.ddJ = paramIntent;
        this.iWx = 6;
        this.iWt.setVisibility(8);
        this.iWq.setVisibility(8);
      }
    }
    AppMethodBeat.o(128616);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128605);
    super.onCreate(paramBundle);
    this.hint = getIntent().getStringExtra("kintent_hint");
    this.mz = getIntent().getBooleanExtra("kintent_cancelable", true);
    this.iWv = getIntent().getBooleanExtra("from_unbind", false);
    g.agi().a(384, this);
    g.agi().a(255, this);
    initView();
    paramBundle = bs.aLu(ba.ayR().getString("_auth_key", ""));
    he localhe = new he();
    if (!bs.cv(paramBundle)) {}
    for (this.iWy = new SKBuiltinBuffer_t().setBuffer(paramBundle);; this.iWy = new SKBuiltinBuffer_t().setBuffer(new byte[0])) {
      try
      {
        localhe.parseFrom(paramBundle);
        paramBundle = new t(1);
        g.agi().a(paramBundle, 0);
        getString(2131755906);
        this.fts = h.b(this, getString(2131755804), false, null);
        AppMethodBeat.o(128605);
        return;
      }
      catch (IOException paramBundle)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicorMsg.RegByMobileSetPwdUI", paramBundle, "summersetpwd Failed parse autoauthkey buf", new Object[0]);
        }
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128606);
    super.onDestroy();
    g.agi().b(384, this);
    g.agi().b(255, this);
    AppMethodBeat.o(128606);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(128607);
    super.onNewIntent(paramIntent);
    paramIntent = paramIntent.getStringExtra("setpwd_ticket");
    com.tencent.mm.sdk.platformtools.ac.i("MicorMsg.RegByMobileSetPwdUI", "onNewIntent get reset pwd ticket %s", new Object[] { paramIntent });
    if (!bs.isNullOrNil(paramIntent))
    {
      this.ddJ = paramIntent;
      this.iWx = 4;
      this.iWt.setVisibility(8);
      this.iWq.setVisibility(8);
    }
    AppMethodBeat.o(128607);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(128615);
    com.tencent.mm.sdk.platformtools.ac.i("MicorMsg.RegByMobileSetPwdUI", "errorCode %d, errorMsg %s, scene %s", new Object[] { Integer.valueOf(paramInt2), paramString, paramn });
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramn);
    if (paramn.getType() == 255)
    {
      if (((t)paramn).hSP == 1)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          this.iWt.setVisibility(0);
          this.iWq.setVisibility(0);
          this.iWw = true;
          AppMethodBeat.o(128615);
          return;
        }
        if ((paramInt2 == -3) && (paramInt1 == 4))
        {
          this.iWw = false;
          AppMethodBeat.o(128615);
          return;
        }
        this.iWt.setVisibility(0);
        this.iWq.setVisibility(0);
        paramString = com.tencent.mm.h.a.rM(paramString);
        if (paramString != null)
        {
          com.tencent.mm.sdk.platformtools.ac.i("MicorMsg.RegByMobileSetPwdUI", "summertips errCode[%d], showType[%d], url[%s], desc[%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramString.cZX), paramString.url, paramString.desc });
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
        g.agR().agA().set(77830, ((com.tencent.mm.modelsimple.ac)paramn).aEr());
        aRy();
        AppMethodBeat.o(128615);
        return;
      }
      h.l(this, 2131762356, 2131755906);
    }
    AppMethodBeat.o(128615);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI
 * JD-Core Version:    0.7.0.1
 */