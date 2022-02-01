package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.l;
import com.tencent.mm.by.c;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;

final class IPCallShareCouponUI$5
  extends ClickableSpan
{
  IPCallShareCouponUI$5(IPCallShareCouponUI paramIPCallShareCouponUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(25940);
    ((TextView)paramView).setHighlightColor(this.DYL.getResources().getColor(R.e.transparent));
    Object localObject = "https://" + WeChatHosts.domainString(R.l.host_support_weixin_qq_com) + "/cgi-bin/mmsupport-bin/readtemplate?t=weixin_phone/notice";
    String str = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
    paramView = (View)localObject;
    if (!Util.isNullOrNil(str)) {
      paramView = (String)localObject + "&wechat_real_lang=" + str;
    }
    localObject = new Intent();
    ((Intent)localObject).putExtra("rawUrl", paramView);
    ((Intent)localObject).putExtra("showShare", false);
    c.b(this.DYL, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
    AppMethodBeat.o(25940);
  }
  
  public final void updateDrawState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(25941);
    paramTextPaint.setColor(this.DYL.getResources().getColor(R.e.link_color));
    paramTextPaint.setUnderlineText(false);
    AppMethodBeat.o(25941);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponUI.5
 * JD-Core Version:    0.7.0.1
 */