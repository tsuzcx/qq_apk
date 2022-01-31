package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.R.e;
import com.tencent.mm.br.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;

final class IPCallShareCouponUI$5
  extends ClickableSpan
{
  IPCallShareCouponUI$5(IPCallShareCouponUI paramIPCallShareCouponUI) {}
  
  public final void onClick(View paramView)
  {
    ((TextView)paramView).setHighlightColor(this.lyX.getResources().getColor(R.e.transparent));
    paramView = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=weixin_phone/notice";
    Object localObject = x.fB(ae.getContext());
    if (!bk.bl((String)localObject)) {
      paramView = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=weixin_phone/notice" + "&wechat_real_lang=" + (String)localObject;
    }
    localObject = new Intent();
    ((Intent)localObject).putExtra("rawUrl", paramView);
    ((Intent)localObject).putExtra("showShare", false);
    d.b(this.lyX, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
  }
  
  public final void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(this.lyX.getResources().getColor(R.e.link_color));
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponUI.5
 * JD-Core Version:    0.7.0.1
 */