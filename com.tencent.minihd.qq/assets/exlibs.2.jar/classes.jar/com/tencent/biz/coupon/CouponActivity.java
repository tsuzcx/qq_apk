package com.tencent.biz.coupon;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import ceg;
import com.tencent.biz.ProtoServlet;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.protofile.coupon.CouponProto.MarkBusinessFavourUpdateReq;
import java.util.Iterator;
import mqq.app.NewIntent;
import org.json.JSONException;
import org.json.JSONObject;

public class CouponActivity
  extends PublicAccountBrowser
{
  static String jdField_a_of_type_JavaLangString = "https://web.p.qq.com/qqmpmobile/coupon/shop.html?_bid=108";
  public static final String b = "https://web.p.qq.com/qqmpmobile/coupon/mycoupons.html?_bid=108";
  public int a;
  Intent jdField_a_of_type_AndroidContentIntent;
  boolean jdField_a_of_type_Boolean = false;
  
  public CouponActivity()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  protected String a()
  {
    if (this.jdField_a_of_type_AndroidContentIntent.hasExtra("source")) {
      return "PA MyCoupon";
    }
    return "PA Coupon";
  }
  
  public void a()
  {
    NewIntent localNewIntent = new NewIntent(this, ProtoServlet.class);
    localNewIntent.putExtra("cmd", "CouponSvr.coup_markBizupdate");
    localNewIntent.putExtra("data", new CouponProto.MarkBusinessFavourUpdateReq().toByteArray());
    this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface.startServlet(localNewIntent);
  }
  
  protected void b()
  {
    super.b();
    this.jdField_a_of_type_AndroidContentIntent = super.getIntent();
    if (!this.jdField_a_of_type_AndroidContentIntent.hasExtra("source"))
    {
      this.rightViewImg.setVisibility(8);
      this.rightViewText.setVisibility(0);
      this.rightViewText.setText(2131363696);
      this.rightViewText.setClickable(false);
      return;
    }
    this.rightViewImg.setVisibility(8);
    this.rightViewText.setVisibility(8);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    paramInt2 = 0;
    paramInt1 = paramInt2;
    if (paramIntent != null)
    {
      paramInt1 = paramInt2;
      if (paramIntent.getExtras() != null) {
        paramInt1 = paramIntent.getExtras().getInt("toPage");
      }
    }
    if ((paramInt1 != 0) && ((this.jdField_a_of_type_Int & paramInt1) == 0))
    {
      paramIntent = new Intent();
      paramIntent.putExtra("toPage", paramInt1);
      super.setResult(-1, paramIntent);
      super.finish();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    Object localObject1 = super.getIntent().getExtras().getString("url");
    this.jdField_a_of_type_AndroidContentIntent = super.getIntent();
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("from", 10);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("webStyle", "noBottomBar");
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      this.jdField_a_of_type_AndroidContentIntent.putExtra("title", super.getResources().getString(2131363695));
      this.jdField_a_of_type_Boolean = true;
      super.doOnCreate(paramBundle);
      if (this.jdField_a_of_type_Boolean)
      {
        paramBundle = new StringBuffer();
        try
        {
          localObject1 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("jsonParams");
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject1 = new JSONObject((String)localObject1);
            Iterator localIterator = ((JSONObject)localObject1).keys();
            while (localIterator.hasNext())
            {
              String str = (String)localIterator.next();
              Object localObject2 = ((JSONObject)localObject1).get(str);
              paramBundle.append("&" + str + "=" + localObject2.toString());
            }
          }
          if ((this.jdField_a_of_type_Int & 0x5) != 0) {
            break label341;
          }
        }
        catch (JSONException localJSONException) {}
        paramBundle = jdField_a_of_type_JavaLangString + "&stype=2" + paramBundle.toString();
        label239:
        super.getIntent().putExtra("url", paramBundle);
      }
      this.jdField_a_of_type_AndroidContentIntent.putExtra("from", this.jdField_a_of_type_Int & 0x1C | 0x10);
      if (this.jdField_a_of_type_AndroidContentIntent.hasExtra("source")) {
        break label368;
      }
      this.rightViewImg.setVisibility(8);
      this.rightViewText.setVisibility(0);
      this.rightViewText.setText(2131363696);
      this.rightViewText.setOnClickListener(new ceg(this));
    }
    for (;;)
    {
      a();
      return true;
      this.jdField_a_of_type_AndroidContentIntent.removeExtra("title");
      break;
      label341:
      paramBundle = jdField_a_of_type_JavaLangString + paramBundle.toString();
      break label239;
      label368:
      this.jdField_a_of_type_AndroidContentIntent.removeExtra("source");
      this.rightViewImg.setVisibility(8);
      this.rightViewText.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.coupon.CouponActivity
 * JD-Core Version:    0.7.0.1
 */