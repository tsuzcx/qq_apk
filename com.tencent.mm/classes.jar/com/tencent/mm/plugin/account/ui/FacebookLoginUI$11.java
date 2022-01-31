package com.tencent.mm.plugin.account.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.modelsimple.s;

final class FacebookLoginUI$11
  extends b
{
  FacebookLoginUI$11(FacebookLoginUI paramFacebookLoginUI) {}
  
  public final m a(m paramm, String paramString)
  {
    AppMethodBeat.i(124844);
    paramm = new s("facebook@wechat_auth", FacebookLoginUI.g(this.gDq), ((s)paramm).getSecCodeType(), paramString, ((s)paramm).ajG(), ((s)paramm).ajI(), 0, "", true, false);
    AppMethodBeat.o(124844);
    return paramm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.FacebookLoginUI.11
 * JD-Core Version:    0.7.0.1
 */