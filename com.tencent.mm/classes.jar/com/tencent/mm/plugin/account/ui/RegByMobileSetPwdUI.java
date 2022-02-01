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
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsimple.aa;
import com.tencent.mm.modelsimple.ad;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.plugin.account.a.b.a.a;
import com.tencent.mm.plugin.account.bind.ui.BindMContactUI;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.hy;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.PhoneFormater;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import java.io.IOException;

public class RegByMobileSetPwdUI
  extends SetPwdUI
{
  private String dHx = null;
  private String hint = null;
  private TextView knK;
  private TextView kqG;
  private View kqH;
  private View kqI;
  private TextView kqJ;
  public View kqK;
  public EditText kqL;
  private boolean kqM = false;
  public boolean kqN;
  private int kqO = 0;
  private SKBuiltinBuffer_t kqP = null;
  
  protected final void a(a.a parama)
  {
    AppMethodBeat.i(128613);
    switch (3.kiH[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(128613);
      return;
      h.n(this, 2131764410, 2131764412);
      AppMethodBeat.o(128613);
      return;
      h.n(this, 2131764411, 2131764412);
      AppMethodBeat.o(128613);
      return;
      h.n(this, 2131767027, 2131764412);
      AppMethodBeat.o(128613);
      return;
      h.n(this, 2131767031, 2131764412);
    }
  }
  
  protected final void bpG()
  {
    AppMethodBeat.i(128612);
    if ((Util.isNullOrNil(this.dHx)) && (this.kqN))
    {
      ad localad = new ad(this.kqL.getText().toString(), "", "", "");
      g.azz().a(localad, 0);
      getString(2131755998);
      this.gtM = h.a(this, getString(2131755978), false, null);
      AppMethodBeat.o(128612);
      return;
    }
    super.bpG();
    AppMethodBeat.o(128612);
  }
  
  public final boolean bpH()
  {
    return true;
  }
  
  protected final q bpx()
  {
    AppMethodBeat.i(128610);
    if (Util.isNullOrNil(this.dHx)) {
      this.dHx = ((String)g.aAh().azQ().get(77830, null));
    }
    aa localaa = new aa(this.ksb, this.dHx, this.kqO, this.kqP);
    AppMethodBeat.o(128610);
    return localaa;
  }
  
  protected final String bpy()
  {
    AppMethodBeat.i(128609);
    String str = ((EditText)findViewById(2131306811)).getText().toString();
    AppMethodBeat.o(128609);
    return str;
  }
  
  protected final String bpz()
  {
    AppMethodBeat.i(128611);
    String str = ((EditText)findViewById(2131306810)).getText().toString();
    AppMethodBeat.o(128611);
    return str;
  }
  
  public int getLayoutId()
  {
    return 2131496088;
  }
  
  public void initView()
  {
    AppMethodBeat.i(128608);
    if (!this.ox) {
      showMMLogo();
    }
    setMMTitle(2131764427);
    this.kqG = ((TextView)findViewById(2131309652));
    this.kqI = findViewById(2131296345);
    this.knK = ((TextView)findViewById(2131306805));
    this.kqJ = ((TextView)findViewById(2131296355));
    if ((this.hint != null) && (this.hint.length() > 0)) {
      this.knK.setText(this.hint);
    }
    this.kqK = findViewById(2131306803);
    this.kqL = ((EditText)this.kqK.findViewById(2131306809));
    this.kqH = findViewById(2131301699);
    this.kqH.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(128602);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/RegByMobileSetPwdUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = (String)g.aAh().azQ().get(6, null);
        if (Util.isNullOrNil(paramAnonymousView))
        {
          Log.i("MicorMsg.RegByMobileSetPwdUI", "has not bind mobile");
          paramAnonymousView = new Intent(RegByMobileSetPwdUI.this, BindMContactUI.class);
          paramAnonymousView.putExtra("bind_scene", 4);
          h.a(RegByMobileSetPwdUI.this, RegByMobileSetPwdUI.this.getString(2131764420), "", RegByMobileSetPwdUI.this.getString(2131756686), RegByMobileSetPwdUI.this.getString(2131755761), true, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(128600);
              MMWizardActivity.ay(RegByMobileSetPwdUI.this, paramAnonymousView);
              AppMethodBeat.o(128600);
            }
          }, null);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileSetPwdUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(128602);
          return;
          Log.i("MicorMsg.RegByMobileSetPwdUI", "has bind mobile");
          h.a(RegByMobileSetPwdUI.this, RegByMobileSetPwdUI.this.getString(2131764418, new Object[] { paramAnonymousView }), "", RegByMobileSetPwdUI.this.getString(2131755976), RegByMobileSetPwdUI.this.getString(2131755761), true, new DialogInterface.OnClickListener()
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
        }
      }
    });
    Object localObject3;
    if ((this.kqM) || (!g.aAf().azp()))
    {
      this.kqI.setVisibility(8);
      localObject1 = (TextView)findViewById(2131305594);
      localObject2 = (TextView)findViewById(2131305791);
      localObject3 = (TextView)findViewById(2131299010);
      EditText localEditText1 = (EditText)findViewById(2131306811);
      EditText localEditText2 = (EditText)findViewById(2131306810);
      if (!LocaleUtil.isChineseAppLang())
      {
        ((TextView)localObject1).setTextSize(1, 14.0F);
        ((TextView)localObject2).setTextSize(1, 14.0F);
        ((TextView)localObject3).setTextSize(1, 14.0F);
        localEditText1.setTextSize(1, 14.0F);
        localEditText2.setTextSize(1, 14.0F);
      }
      float f1 = this.kqJ.getPaint().measureText(this.kqJ.getText().toString());
      float f2 = ((TextView)localObject1).getPaint().measureText(((TextView)localObject1).getText().toString());
      float f3 = ((TextView)localObject2).getPaint().measureText(((TextView)localObject2).getText().toString());
      float f4 = ((TextView)localObject3).getPaint().measureText(((TextView)localObject3).getText().toString());
      f1 = Math.max(Math.max(Math.max(f1, f3), f4), f2);
      ((TextView)localObject1).setWidth((int)f1);
      this.kqJ.setWidth((int)f1);
      ((TextView)localObject2).setWidth((int)f1);
      ((TextView)localObject2).setWidth((int)f1);
      AppMethodBeat.o(128608);
      return;
    }
    this.kqI.setVisibility(0);
    Object localObject2 = z.aTZ();
    Object localObject1 = localObject2;
    if (Util.isNullOrNil((String)localObject2))
    {
      localObject2 = z.aTY();
      localObject1 = localObject2;
      if (as.bjx((String)localObject2)) {
        localObject1 = null;
      }
    }
    if (Util.isNullOrNil((String)localObject1))
    {
      localObject2 = (String)g.aAh().azQ().get(6, null);
      localObject1 = (String)g.aAh().azQ().get(5, null);
      if (!Util.isNullOrNil((String)localObject2)) {
        if (Util.isPhoneNumber((String)localObject2).booleanValue())
        {
          localObject3 = new PhoneFormater();
          localObject1 = "86";
          if (!((String)localObject2).startsWith("+")) {
            break label694;
          }
          localObject2 = ((String)localObject2).replace("+", "");
          localObject1 = PhoneFormater.extractCountryCode((String)localObject2);
          if (localObject1 == null) {
            break label691;
          }
          localObject2 = ((String)localObject2).substring(((String)localObject1).length());
        }
      }
    }
    label691:
    label694:
    for (;;)
    {
      localObject1 = ((PhoneFormater)localObject3).formatNumber((String)localObject1, (String)localObject2);
      this.kqJ.setText(2131765455);
      this.kqG.setText((CharSequence)localObject1);
      this.knK.setText(2131764429);
      break;
      if (!Util.isNullOrNil((String)localObject1))
      {
        this.kqG.setText((CharSequence)localObject1);
        this.kqJ.setText(2131765377);
        this.knK.setText(2131764428);
        break;
      }
      this.kqI.setVisibility(8);
      break;
      this.kqJ.setText(2131765675);
      this.kqG.setText((CharSequence)localObject1);
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
      Log.i("MicorMsg.RegByMobileSetPwdUI", "get reset pwd ticket %s", new Object[] { paramIntent });
      if (!Util.isNullOrNil(paramIntent))
      {
        this.dHx = paramIntent;
        this.kqO = 6;
        this.kqK.setVisibility(8);
        this.kqH.setVisibility(8);
      }
    }
    AppMethodBeat.o(128616);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128605);
    super.onCreate(paramBundle);
    this.hint = getIntent().getStringExtra("kintent_hint");
    this.ox = getIntent().getBooleanExtra("kintent_cancelable", true);
    this.kqM = getIntent().getBooleanExtra("from_unbind", false);
    g.azz().a(384, this);
    g.azz().a(255, this);
    initView();
    paramBundle = Util.decodeHexString(bh.aVK().getString("_auth_key", ""));
    hy localhy = new hy();
    if (!Util.isNullOrNil(paramBundle)) {}
    for (this.kqP = new SKBuiltinBuffer_t().setBuffer(paramBundle);; this.kqP = new SKBuiltinBuffer_t().setBuffer(new byte[0])) {
      try
      {
        localhy.parseFrom(paramBundle);
        paramBundle = new u(1);
        g.azz().a(paramBundle, 0);
        getString(2131755998);
        this.gtM = h.a(this, getString(2131755886), false, null);
        AppMethodBeat.o(128605);
        return;
      }
      catch (IOException paramBundle)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicorMsg.RegByMobileSetPwdUI", paramBundle, "summersetpwd Failed parse autoauthkey buf", new Object[0]);
        }
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128606);
    super.onDestroy();
    g.azz().b(384, this);
    g.azz().b(255, this);
    AppMethodBeat.o(128606);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(128607);
    super.onNewIntent(paramIntent);
    paramIntent = paramIntent.getStringExtra("setpwd_ticket");
    Log.i("MicorMsg.RegByMobileSetPwdUI", "onNewIntent get reset pwd ticket %s", new Object[] { paramIntent });
    if (!Util.isNullOrNil(paramIntent))
    {
      this.dHx = paramIntent;
      this.kqO = 4;
      this.kqK.setVisibility(8);
      this.kqH.setVisibility(8);
    }
    AppMethodBeat.o(128607);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(128615);
    Log.i("MicorMsg.RegByMobileSetPwdUI", "errorCode %d, errorMsg %s, scene %s", new Object[] { Integer.valueOf(paramInt2), paramString, paramq });
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramq);
    if (paramq.getType() == 255)
    {
      if (((u)paramq).jkh == 1)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          this.kqK.setVisibility(0);
          this.kqH.setVisibility(0);
          this.kqN = true;
          AppMethodBeat.o(128615);
          return;
        }
        if ((paramInt2 == -3) && (paramInt1 == 4))
        {
          this.kqN = false;
          AppMethodBeat.o(128615);
          return;
        }
        this.kqK.setVisibility(0);
        this.kqH.setVisibility(0);
        paramString = com.tencent.mm.h.a.Dk(paramString);
        if (paramString != null)
        {
          Log.i("MicorMsg.RegByMobileSetPwdUI", "summertips errCode[%d], showType[%d], url[%s], desc[%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramString.dDG), paramString.url, paramString.desc });
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
    else if (paramq.getType() == 384)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        g.aAh().azQ().set(77830, ((ad)paramq).bbG());
        bpV();
        AppMethodBeat.o(128615);
        return;
      }
      h.n(this, 2131764422, 2131755998);
    }
    AppMethodBeat.o(128615);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI
 * JD-Core Version:    0.7.0.1
 */