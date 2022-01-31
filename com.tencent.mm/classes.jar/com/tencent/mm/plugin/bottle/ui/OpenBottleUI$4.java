package com.tencent.mm.plugin.bottle.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bh.a;
import com.tencent.mm.br.d;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.ArrayList;

final class OpenBottleUI$4
  implements View.OnClickListener
{
  OpenBottleUI$4(OpenBottleUI paramOpenBottleUI) {}
  
  public final void onClick(View paramView)
  {
    Intent localIntent = new Intent();
    String str;
    if (bk.bl(OpenBottleUI.e(this.ias)))
    {
      str = "";
      if (!bk.bl(OpenBottleUI.e(this.ias))) {
        break label193;
      }
    }
    label193:
    for (paramView = "";; paramView = OpenBottleUI.e(this.ias).substring(OpenBottleUI.e(this.ias).indexOf(':') + 1))
    {
      localIntent.putExtra("k_username", str);
      ArrayList localArrayList = a.nE(OpenBottleUI.e(this.ias));
      str = "";
      if (localArrayList.size() > 0) {
        str = (String)localArrayList.get(0);
      }
      localArrayList.clear();
      localArrayList.add(String.format("<exposecontent><bottleid>%s</bottleid><hellomsg>%s</hellomsg></exposecontent>", new Object[] { paramView, str }));
      localIntent.putExtra("k_outside_expose_proof_item_list", localArrayList);
      localIntent.putExtra("showShare", false);
      localIntent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[] { Integer.valueOf(37) }));
      d.b(OpenBottleUI.b(this.ias), "webview", ".ui.tools.WebViewUI", localIntent);
      return;
      str = OpenBottleUI.e(this.ias).substring(0, OpenBottleUI.e(this.ias).indexOf(':'));
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.ui.OpenBottleUI.4
 * JD-Core Version:    0.7.0.1
 */