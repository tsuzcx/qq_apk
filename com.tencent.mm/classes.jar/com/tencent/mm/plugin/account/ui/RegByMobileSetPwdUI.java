package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.r;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.plugin.account.a.b.a.a;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ge;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.h;
import java.io.IOException;

public class RegByMobileSetPwdUI
  extends SetPwdUI
{
  private String crs = null;
  private TextView gFS;
  private TextView gIE;
  private View gIF;
  private View gIG;
  private TextView gIH;
  public View gII;
  public EditText gIJ;
  private boolean gIK = false;
  public boolean gIL;
  private int gIM = 0;
  private SKBuiltinBuffer_t gIN = null;
  private String hint = null;
  
  protected final void a(a.a parama)
  {
    AppMethodBeat.i(125450);
    switch (RegByMobileSetPwdUI.3.gBc[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(125450);
      return;
      h.h(this, 2131302441, 2131302443);
      AppMethodBeat.o(125450);
      return;
      h.h(this, 2131302442, 2131302443);
      AppMethodBeat.o(125450);
      return;
      h.h(this, 2131304499, 2131302443);
      AppMethodBeat.o(125450);
      return;
      h.h(this, 2131304501, 2131302443);
    }
  }
  
  protected final m arI()
  {
    AppMethodBeat.i(125447);
    if (bo.isNullOrNil(this.crs)) {
      this.crs = ((String)g.RL().Ru().get(77830, null));
    }
    com.tencent.mm.modelsimple.z localz = new com.tencent.mm.modelsimple.z(this.gKa, this.crs, this.gIM, this.gIN);
    AppMethodBeat.o(125447);
    return localz;
  }
  
  protected final String arJ()
  {
    AppMethodBeat.i(125446);
    String str = ((EditText)findViewById(2131827164)).getText().toString();
    AppMethodBeat.o(125446);
    return str;
  }
  
  protected final String arK()
  {
    AppMethodBeat.i(125448);
    String str = ((EditText)findViewById(2131827166)).getText().toString();
    AppMethodBeat.o(125448);
    return str;
  }
  
  protected final void arP()
  {
    AppMethodBeat.i(125449);
    if ((bo.isNullOrNil(this.crs)) && (this.gIL))
    {
      ac localac = new ac(this.gIJ.getText().toString(), "", "", "");
      g.Rc().a(localac, 0);
      getString(2131297087);
      this.eeN = h.b(this, getString(2131297069), false, null);
      AppMethodBeat.o(125449);
      return;
    }
    super.arP();
    AppMethodBeat.o(125449);
  }
  
  public final boolean arQ()
  {
    return true;
  }
  
  public int getLayoutId()
  {
    return 2130970559;
  }
  
  public void initView()
  {
    AppMethodBeat.i(125444);
    if (!this.gKc) {
      showMMLogo();
    }
    setMMTitle(2131302458);
    this.gIE = ((TextView)findViewById(2131827077));
    this.gIG = findViewById(2131827158);
    this.gFS = ((TextView)findViewById(2131827157));
    this.gIH = ((TextView)findViewById(2131827159));
    if ((this.hint != null) && (this.hint.length() > 0)) {
      this.gFS.setText(this.hint);
    }
    this.gII = findViewById(2131827160);
    this.gIJ = ((EditText)this.gII.findViewById(2131827162));
    this.gIF = findViewById(2131827167);
    this.gIF.setOnClickListener(new RegByMobileSetPwdUI.1(this));
    if ((this.gIK) || (!g.RJ().QU()))
    {
      this.gIG.setVisibility(8);
      localObject1 = (TextView)findViewById(2131827161);
      localObject2 = (TextView)findViewById(2131827163);
      TextView localTextView = (TextView)findViewById(2131827165);
      EditText localEditText1 = (EditText)findViewById(2131827164);
      EditText localEditText2 = (EditText)findViewById(2131827166);
      if (!aa.dsC())
      {
        ((TextView)localObject1).setTextSize(1, 14.0F);
        ((TextView)localObject2).setTextSize(1, 14.0F);
        localTextView.setTextSize(1, 14.0F);
        localEditText1.setTextSize(1, 14.0F);
        localEditText2.setTextSize(1, 14.0F);
      }
      float f1 = this.gIH.getPaint().measureText(this.gIH.getText().toString());
      float f2 = ((TextView)localObject1).getPaint().measureText(((TextView)localObject1).getText().toString());
      float f3 = ((TextView)localObject2).getPaint().measureText(((TextView)localObject2).getText().toString());
      float f4 = localTextView.getPaint().measureText(localTextView.getText().toString());
      f1 = Math.max(Math.max(Math.max(f1, f3), f4), f2);
      ((TextView)localObject1).setWidth((int)f1);
      this.gIH.setWidth((int)f1);
      ((TextView)localObject2).setWidth((int)f1);
      ((TextView)localObject2).setWidth((int)f1);
      AppMethodBeat.o(125444);
      return;
    }
    this.gIG.setVisibility(0);
    Object localObject2 = r.Zo();
    Object localObject1 = localObject2;
    if (bo.isNullOrNil((String)localObject2))
    {
      localObject2 = r.Zn();
      localObject1 = localObject2;
      if (ad.ari((String)localObject2)) {
        localObject1 = null;
      }
    }
    if (bo.isNullOrNil((String)localObject1))
    {
      localObject2 = (String)g.RL().Ru().get(6, null);
      localObject1 = (String)g.RL().Ru().get(5, null);
      if (!bo.isNullOrNil((String)localObject2)) {
        if (bo.aqe((String)localObject2).booleanValue())
        {
          new av();
          localObject1 = "86";
          if (!((String)localObject2).startsWith("+")) {
            break label691;
          }
          localObject2 = ((String)localObject2).replace("+", "");
          localObject1 = av.RC((String)localObject2);
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
      localObject1 = av.formatNumber((String)localObject1, (String)localObject2);
      this.gIH.setText(2131303310);
      this.gIE.setText((CharSequence)localObject1);
      this.gFS.setText(2131302460);
      break;
      if (!bo.isNullOrNil((String)localObject1))
      {
        this.gIE.setText((CharSequence)localObject1);
        this.gIH.setText(2131303240);
        this.gFS.setText(2131302459);
        break;
      }
      this.gIG.setVisibility(8);
      break;
      this.gIH.setText(2131303508);
      this.gIE.setText((CharSequence)localObject1);
      break;
    }
  }
  
  protected final boolean m(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(125451);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      finish();
      AppMethodBeat.o(125451);
      return true;
    }
    boolean bool = l(paramInt1, paramInt2, paramString);
    AppMethodBeat.o(125451);
    return bool;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(125453);
    if ((paramInt1 == 10001) && (paramInt2 == -1))
    {
      paramIntent = paramIntent.getStringExtra("setpwd_ticket");
      ab.i("MicorMsg.RegByMobileSetPwdUI", "get reset pwd ticket %s", new Object[] { paramIntent });
      if (!bo.isNullOrNil(paramIntent))
      {
        this.crs = paramIntent;
        this.gIM = 6;
        this.gII.setVisibility(8);
        this.gIF.setVisibility(8);
      }
    }
    AppMethodBeat.o(125453);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(125441);
    super.onCreate(paramBundle);
    this.hint = getIntent().getStringExtra("kintent_hint");
    this.gKc = getIntent().getBooleanExtra("kintent_cancelable", true);
    this.gIK = getIntent().getBooleanExtra("from_unbind", false);
    g.Rc().a(384, this);
    g.Rc().a(255, this);
    initView();
    paramBundle = bo.apQ(ax.aaF().getString("_auth_key", ""));
    ge localge = new ge();
    if (!bo.ce(paramBundle)) {}
    for (this.gIN = new SKBuiltinBuffer_t().setBuffer(paramBundle);; this.gIN = new SKBuiltinBuffer_t().setBuffer(new byte[0])) {
      try
      {
        localge.parseFrom(paramBundle);
        paramBundle = new t(1);
        g.Rc().a(paramBundle, 0);
        getString(2131297087);
        this.eeN = h.b(this, getString(2131296987), false, null);
        AppMethodBeat.o(125441);
        return;
      }
      catch (IOException paramBundle)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicorMsg.RegByMobileSetPwdUI", paramBundle, "summersetpwd Failed parse autoauthkey buf", new Object[0]);
        }
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(125442);
    super.onDestroy();
    g.Rc().b(384, this);
    g.Rc().b(255, this);
    AppMethodBeat.o(125442);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(125443);
    super.onNewIntent(paramIntent);
    paramIntent = paramIntent.getStringExtra("setpwd_ticket");
    ab.i("MicorMsg.RegByMobileSetPwdUI", "onNewIntent get reset pwd ticket %s", new Object[] { paramIntent });
    if (!bo.isNullOrNil(paramIntent))
    {
      this.crs = paramIntent;
      this.gIM = 4;
      this.gII.setVisibility(8);
      this.gIF.setVisibility(8);
    }
    AppMethodBeat.o(125443);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(125452);
    ab.i("MicorMsg.RegByMobileSetPwdUI", "errorCode %d, errorMsg %s, scene %s", new Object[] { Integer.valueOf(paramInt2), paramString, paramm });
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramm);
    if (paramm.getType() == 255)
    {
      if (((t)paramm).fPI == 1)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          this.gII.setVisibility(0);
          this.gIF.setVisibility(0);
          this.gIL = true;
          AppMethodBeat.o(125452);
          return;
        }
        if ((paramInt2 == -3) && (paramInt1 == 4))
        {
          this.gIL = false;
          AppMethodBeat.o(125452);
          return;
        }
        this.gII.setVisibility(0);
        this.gIF.setVisibility(0);
        paramString = com.tencent.mm.h.a.kO(paramString);
        if (paramString != null)
        {
          ab.i("MicorMsg.RegByMobileSetPwdUI", "summertips errCode[%d], showType[%d], url[%s], desc[%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramString.showType), paramString.url, paramString.desc });
          h.a(this, paramString.desc, paramString.Title, false, new RegByMobileSetPwdUI.2(this));
        }
        AppMethodBeat.o(125452);
      }
    }
    else if (paramm.getType() == 384)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        g.RL().Ru().set(77830, ((ac)paramm).agx());
        ase();
        AppMethodBeat.o(125452);
        return;
      }
      h.h(this, 2131302453, 2131297087);
    }
    AppMethodBeat.o(125452);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI
 * JD-Core Version:    0.7.0.1
 */