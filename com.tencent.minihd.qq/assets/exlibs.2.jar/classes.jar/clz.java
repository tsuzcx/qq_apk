import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qrcode.activity.QRCardActivity;
import com.tencent.biz.qrcode.util.QRCard;
import com.tencent.mobileqq.activity.AddFriendActivity;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.HashMap;
import java.util.List;
import mqq.manager.AccountManager;

public class clz
  implements ActionSheet.OnButtonClickListener
{
  public clz(QRCardActivity paramQRCardActivity, boolean[] paramArrayOfBoolean, String paramString1, Context paramContext, String paramString2) {}
  
  @SuppressLint({"NewApi"})
  public void OnClick(View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizQrcodeActivityQRCardActivity.c) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentBizQrcodeActivityQRCardActivity.c = true;
      Object localObject;
      if (this.jdField_a_of_type_ArrayOfBoolean[0] == 1)
      {
        switch (paramInt)
        {
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentBizQrcodeActivityQRCardActivity.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
          return;
          paramView = this.jdField_a_of_type_ComTencentBizQrcodeActivityQRCardActivity.app.getAccount();
          localObject = (String)this.jdField_a_of_type_ComTencentBizQrcodeActivityQRCardActivity.jdField_a_of_type_ComTencentBizQrcodeUtilQRCard.f.get(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRCardActivity.m);
          String str = this.jdField_a_of_type_ComTencentBizQrcodeActivityQRCardActivity.app.getSid();
          if (TextUtils.isEmpty(str))
          {
            ((AccountManager)this.jdField_a_of_type_ComTencentBizQrcodeActivityQRCardActivity.app.getManager(0)).updateSid(new cma(this, paramView, (String)localObject));
          }
          else if (!TextUtils.isEmpty(paramView))
          {
            localObject = "https://w.mail.qq.com/cgi-bin/login?target=mobileqqwrite&fwd=mq&fun=from3g&uin=" + paramView + "&3g_sid=" + str + "&to=" + (String)localObject;
            str = ((String)localObject).toLowerCase();
            if (str.startsWith("www.")) {
              paramView = "http://" + (String)localObject;
            }
            for (;;)
            {
              localObject = new Intent(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRCardActivity, QQBrowserDelegationActivity.class);
              ((Intent)localObject).putExtra("url", paramView);
              ((Intent)localObject).putExtra("key_isReadModeEnabled", true);
              ((Intent)localObject).putExtra("injectrecommend", false);
              this.jdField_a_of_type_ComTencentBizQrcodeActivityQRCardActivity.startActivity((Intent)localObject);
              break;
              if (str.startsWith("https:"))
              {
                paramView = "https" + ((String)localObject).substring(5);
              }
              else
              {
                paramView = (View)localObject;
                if (str.startsWith("http:")) {
                  paramView = "http" + ((String)localObject).substring(4);
                }
              }
            }
            paramView = (String)this.jdField_a_of_type_ComTencentBizQrcodeActivityQRCardActivity.jdField_a_of_type_ComTencentBizQrcodeUtilQRCard.f.get(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRCardActivity.m);
            localObject = Uri.parse("mailto:" + paramView);
            if (this.jdField_a_of_type_ComTencentBizQrcodeActivityQRCardActivity.getPackageManager().queryIntentActivities(new Intent("android.intent.action.SENDTO", (Uri)localObject), 65536).size() > 0)
            {
              localObject = new Intent("android.intent.action.SENDTO");
              ((Intent)localObject).setData(Uri.parse("mailto:" + paramView));
              this.jdField_a_of_type_ComTencentBizQrcodeActivityQRCardActivity.startActivity((Intent)localObject);
            }
            else
            {
              localObject = new Intent("android.intent.action.SEND");
              ((Intent)localObject).putExtra("android.intent.extra.EMAIL", paramView);
              ((Intent)localObject).putExtra("android.intent.extra.TEXT", "The email body text");
              ((Intent)localObject).setType("text/plain");
              try
              {
                this.jdField_a_of_type_ComTencentBizQrcodeActivityQRCardActivity.startActivity(Intent.createChooser((Intent)localObject, "Choose Email Client"));
              }
              catch (ActivityNotFoundException paramView) {}
              if (QLog.isColorLevel()) {
                QLog.d("QrcodeScannerCard", 2, "Intent.ACTION_SEND do not exist");
              }
            }
          }
        }
      }
      if (this.jdField_a_of_type_ArrayOfBoolean[1] == 1)
      {
        switch (paramInt)
        {
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentBizQrcodeActivityQRCardActivity.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
          return;
          if (this.jdField_a_of_type_JavaLangString.contains("-")) {
            this.jdField_a_of_type_JavaLangString.replaceAll("-", "");
          }
          if (this.jdField_a_of_type_JavaLangString.contains(" ")) {
            this.jdField_a_of_type_JavaLangString.replaceAll(" ", "");
          }
          paramView = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + this.jdField_a_of_type_JavaLangString));
          try
          {
            this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
          }
          catch (ActivityNotFoundException paramView) {}
          if (QLog.isColorLevel()) {
            QLog.d("QrcodeScannerCard", 2, "Intent.ACTION_DIAL do not exist");
          }
        }
      }
      if (this.jdField_a_of_type_ArrayOfBoolean[2] == 1)
      {
        paramView = new HashMap();
        if (!this.jdField_a_of_type_ComTencentBizQrcodeActivityQRCardActivity.jdField_a_of_type_ComTencentBizQrcodeUtilQRCard.c.isEmpty()) {
          paramView.putAll(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRCardActivity.jdField_a_of_type_ComTencentBizQrcodeUtilQRCard.c);
        }
        if (!this.jdField_a_of_type_ComTencentBizQrcodeActivityQRCardActivity.jdField_a_of_type_ComTencentBizQrcodeUtilQRCard.f.isEmpty()) {
          paramView.putAll(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRCardActivity.jdField_a_of_type_ComTencentBizQrcodeUtilQRCard.f);
        }
        if (this.jdField_a_of_type_ComTencentBizQrcodeActivityQRCardActivity.jdField_a_of_type_ComTencentBizQrcodeUtilQRCard.e != null) {
          paramView.putAll(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRCardActivity.jdField_a_of_type_ComTencentBizQrcodeUtilQRCard.e);
        }
        if (!this.jdField_a_of_type_ComTencentBizQrcodeActivityQRCardActivity.jdField_a_of_type_ComTencentBizQrcodeUtilQRCard.d.isEmpty()) {
          paramView.putAll(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRCardActivity.jdField_a_of_type_ComTencentBizQrcodeUtilQRCard.d);
        }
        switch (paramInt)
        {
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentBizQrcodeActivityQRCardActivity.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
          return;
          localObject = new Intent("android.intent.action.INSERT");
          ((Intent)localObject).setType("vnd.android.cursor.dir/person");
          ((Intent)localObject).setType("vnd.android.cursor.dir/contact");
          ((Intent)localObject).setType("vnd.android.cursor.dir/raw_contact");
          this.jdField_a_of_type_ComTencentBizQrcodeActivityQRCardActivity.a((Intent)localObject, paramView);
          continue;
          localObject = new Intent("android.intent.action.INSERT_OR_EDIT");
          ((Intent)localObject).setType("vnd.android.cursor.item/person");
          ((Intent)localObject).setType("vnd.android.cursor.item/contact");
          ((Intent)localObject).setType("vnd.android.cursor.item/raw_contact");
          this.jdField_a_of_type_ComTencentBizQrcodeActivityQRCardActivity.a((Intent)localObject, paramView);
        }
      }
    } while (this.jdField_a_of_type_ArrayOfBoolean[3] != 1);
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQrcodeActivityQRCardActivity.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      if (this.b.contains("-")) {
        this.b.replaceAll("-", "");
      }
      if (this.b.contains(" ")) {
        this.b.replaceAll(" ", "");
      }
      paramView = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + this.b));
      try
      {
        this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
      }
      catch (ActivityNotFoundException paramView) {}
      if (QLog.isColorLevel())
      {
        QLog.d("QrcodeScannerCard", 2, "Intent.ACTION_DIAL do not exist");
        continue;
        if (!TextUtils.isEmpty(this.b)) {
          if (Build.VERSION.SDK_INT < 11)
          {
            ((android.text.ClipboardManager)this.jdField_a_of_type_ComTencentBizQrcodeActivityQRCardActivity.getSystemService("clipboard")).setText(this.b);
          }
          else
          {
            ((android.content.ClipboardManager)this.jdField_a_of_type_ComTencentBizQrcodeActivityQRCardActivity.getSystemService("clipboard")).setText(this.b);
            continue;
            AddFriendActivity.a(this.jdField_a_of_type_AndroidContentContext, false, this.b, true);
            continue;
            AddFriendActivity.a(this.jdField_a_of_type_AndroidContentContext, true, this.b, true);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     clz
 * JD-Core Version:    0.7.0.1
 */