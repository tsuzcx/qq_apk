package com.tencent.mobileqq.troop.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;
import java.net.URLEncoder;
import kii;

public class TroopTagViewActivity
  extends QQBrowserActivity
{
  public static final int a = 1;
  public static final String a = "troopuin";
  public static final int b = 2;
  public static final String b = "request_params";
  public static final int c = 3;
  public static final String c = "from";
  public static final String d = "tags";
  public static final String e = "subclass";
  public static final String f = "isAdmin";
  public static final String g = "act_type";
  private static final String j = "hide_operation_bar";
  private static final String k = "https://web.qun.qq.com/tag/index.html?_bid=146&t=%d#tags=%s&gc=%s&base=%s&modifyToSrv=%s";
  private static final String l = "https://web.qun.qq.com/tag/edit.html?_bid=146#tags=%s&gc=%s&base=%s&modifyToSrv=%s";
  protected QQProgressDialog a;
  protected boolean a = false;
  public int d = 1;
  private int e;
  protected String h;
  public String i;
  private String m;
  private String n;
  private String o;
  
  public void a(String paramString)
  {
    this.i = paramString;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    Intent localIntent = super.getIntent();
    if (localIntent == null)
    {
      super.finish();
      return true;
    }
    Bundle localBundle = localIntent.getExtras();
    if (localBundle == null)
    {
      super.finish();
      return true;
    }
    this.e = localBundle.getInt("act_type", 3);
    this.n = localBundle.getString("tags");
    if (localBundle.containsKey("subclass")) {}
    for (this.o = localBundle.getString("subclass");; this.o = "")
    {
      this.m = localBundle.getString("troopuin");
      if (!TextUtils.isEmpty(this.m)) {
        break;
      }
      super.finish();
      return true;
    }
    this.a = localBundle.getBoolean("isAdmin");
    localIntent.putExtra("act_type", 3);
    localIntent.putExtra("hide_operation_bar", true);
    String str;
    if (TextUtils.isEmpty(this.n))
    {
      str = "";
      this.d = localBundle.getInt("modifyToSrv", 1);
      if (this.e != 1) {
        break label319;
      }
      localIntent.putExtra("url", String.format("https://web.qun.qq.com/tag/index.html?_bid=146&t=%d#tags=%s&gc=%s&base=%s&modifyToSrv=%s", new Object[] { Long.valueOf(System.currentTimeMillis() / 1000L), str, this.m, this.o, Integer.valueOf(this.d) }));
    }
    for (;;)
    {
      localIntent.putExtra("isShowAd", false);
      super.doOnCreate(paramBundle);
      if ((this.e != 1) || (!this.a)) {
        break label391;
      }
      this.rightViewText.setText(2131367082);
      this.rightViewText.setVisibility(0);
      this.rightViewImg.setVisibility(8);
      this.rightViewText.setOnClickListener(new kii(this));
      return true;
      str = URLEncoder.encode(this.n).replace("+", "%20");
      break;
      label319:
      if (this.e == 2) {
        localIntent.putExtra("url", String.format("https://web.qun.qq.com/tag/edit.html?_bid=146#tags=%s&gc=%s&base=%s&modifyToSrv=%s", new Object[] { str, this.m, this.o, Integer.valueOf(this.d) }));
      } else {
        localIntent.putExtra("url", localBundle.getString("url"));
      }
    }
    label391:
    this.rightViewText.setVisibility(8);
    this.rightViewImg.setVisibility(8);
    return true;
  }
  
  public void finish()
  {
    if (!TextUtils.isEmpty(this.i))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("tags", this.i);
      setResult(-1, localIntent);
    }
    super.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopTagViewActivity
 * JD-Core Version:    0.7.0.1
 */