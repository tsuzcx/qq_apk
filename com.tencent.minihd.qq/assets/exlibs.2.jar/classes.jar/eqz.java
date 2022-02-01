import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.PublicAccountBrowser.ActionSheetItem;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class eqz
  implements View.OnClickListener
{
  public eqz(QQBrowserActivity paramQQBrowserActivity) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getTag() == null) {}
    int j;
    do
    {
      return;
      j = ((PublicAccountBrowser.ActionSheetItem)paramView.getTag()).m;
      paramView = this.a.g();
      if (j == 1)
      {
        ((ClipboardManager)this.a.getSystemService("clipboard")).setText(paramView);
        QRUtils.a(2, 2131363593);
        return;
      }
      if (j == 11)
      {
        Object localObject = null;
        try
        {
          paramView = URLEncoder.encode(paramView, "UTF-8");
          localObject = QQBrowserActivity.a(this.a).getAccount();
          paramView = "https://guanjia.qq.com/online_server/m_report.html?url=" + paramView + "&qq=" + (String)localObject + "&_wv=7";
          localObject = new Intent(this.a, QQBrowserActivity.class);
          ((Intent)localObject).putExtra("url", paramView);
          this.a.startActivity((Intent)localObject);
          ReportController.b(this.a.app, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_67", "jvbao_click", 0, 1, 0, "", "", "", "");
          return;
        }
        catch (UnsupportedEncodingException paramView)
        {
          for (;;)
          {
            paramView = (View)localObject;
            if (QLog.isColorLevel())
            {
              QLog.d("QQBrowser", 2, "encode url failed, because UTF-8 is unknown");
              paramView = (View)localObject;
            }
          }
        }
      }
      if (j == 2)
      {
        if (TextUtils.isEmpty(this.a.a.m)) {
          this.a.a.a(paramView, 1, false, this.a.getTextTitle());
        }
        for (;;)
        {
          ReportController.b(this.a.app, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_38", "qq_share", 0, 1, 0, "", "", "", "");
          return;
          this.a.a.a(paramView, 1, false);
        }
      }
      if (j == 4)
      {
        paramView = new Intent("android.intent.action.VIEW", Uri.parse(paramView));
        paramView.putExtra("normal", true);
        try
        {
          this.a.startActivity(paramView);
          ReportController.b(this.a.app, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_48", "browser_share", 0, 1, 0, "", "", "", "");
          return;
        }
        catch (ActivityNotFoundException paramView)
        {
          for (;;)
          {
            QRUtils.a(1, 2131363613);
          }
        }
      }
      if (j == 5)
      {
        this.a.a(paramView, true, "https://mdc.html5.qq.com/d/directdown.jsp?channel_id=10367");
        ReportController.b(this.a.app, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_46", "qqbrowser_share", 0, 1, 0, "", "", "", "");
        return;
      }
      if (j == 3)
      {
        if (TextUtils.isEmpty(this.a.a.m)) {
          this.a.a.a(paramView, 2, false, this.a.getTextTitle());
        }
        for (;;)
        {
          ReportController.b(this.a.app, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_44", "qzone_share", 0, 1, 0, "", "", "", "");
          return;
          this.a.a.a(paramView, 2, false);
        }
      }
      if (j == 6)
      {
        this.a.a(paramView, true);
        return;
      }
    } while ((j != 9) && (j != 10));
    int i = -1;
    if (!WXShareHelper.a().a()) {
      i = 2131367829;
    }
    while (i != -1)
    {
      QRUtils.a(0, i);
      return;
      if (!WXShareHelper.a().b()) {
        i = 2131367830;
      }
    }
    if (j == 9)
    {
      if (TextUtils.isEmpty(this.a.a.m)) {
        this.a.a.a(paramView, 3, true, this.a.getTextTitle());
      }
      for (;;)
      {
        ReportController.b(this.a.app, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_40", "weixin_share", 0, 1, 0, "", "", "", "");
        return;
        this.a.a.a(paramView, 3, true);
      }
    }
    if (TextUtils.isEmpty(this.a.a.m)) {
      this.a.a.a(paramView, 4, true, this.a.getTextTitle());
    }
    for (;;)
    {
      ReportController.b(this.a.app, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_42", "pengyouquan_share", 0, 1, 0, "", "", "", "");
      return;
      this.a.a.a(paramView, 4, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     eqz
 * JD-Core Version:    0.7.0.1
 */