package com.tencent.mm.plugin.appbrand.dynamic.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.e;
import com.tencent.mm.plugin.appbrand.dynamic.html.CustomURLSpan;
import com.tencent.mm.plugin.appbrand.dynamic.html.b;
import com.tencent.mm.plugin.appbrand.dynamic.widget.c;
import com.tencent.mm.plugin.appbrand.widget.m;
import com.tencent.mm.plugin.appbrand.wxawidget.b.b;
import com.tencent.mm.plugin.appbrand.wxawidget.b.c;
import com.tencent.mm.plugin.appbrand.wxawidget.b.e;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMSwitchBtn;

public class WxaWidgetDebugUI
  extends MMActivity
{
  String appId;
  int bOa;
  int fEN;
  MMSwitchBtn fXu;
  com.tencent.mm.plugin.appbrand.widget.l fXv;
  String id;
  
  protected final int getLayoutId()
  {
    return b.c.wxa_widget_debug_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setBackBtn(new WxaWidgetDebugUI.1(this));
    int i = b.e.wxa_widget_debugger;
    if (((e)g.r(e.class)).Jn().Jt()) {}
    TextView localTextView;
    for (paramBundle = String.format("(%s)", new Object[] { c.afH() });; paramBundle = "")
    {
      setMMTitle(getString(i, new Object[] { paramBundle }));
      paramBundle = getIntent();
      this.id = paramBundle.getStringExtra("id");
      this.appId = paramBundle.getStringExtra("app_id");
      this.bOa = paramBundle.getIntExtra("pkg_type", 0);
      this.fEN = paramBundle.getIntExtra("pkg_version", 0);
      setMMSubTitle(String.format("(%s)", new Object[] { this.id }));
      this.fXu = ((MMSwitchBtn)findViewById(b.b.open_debug_btn));
      this.fXv = ((com.tencent.mm.plugin.appbrand.widget.a.a)g.r(com.tencent.mm.plugin.appbrand.widget.a.a.class)).aaW().wY(this.appId);
      if (this.fXv == null)
      {
        this.fXv = new com.tencent.mm.plugin.appbrand.widget.l();
        this.fXv.field_appId = this.appId;
      }
      this.fXu.setCheck(this.fXv.field_openDebug);
      this.fXu.setSwitchListener(new WxaWidgetDebugUI.2(this));
      localTextView = (TextView)findViewById(b.b.inspect_guide_tv);
      Spanned localSpanned = Html.fromHtml(getString(b.e.wxa_widget_open_inspect_guide), new com.tencent.mm.plugin.appbrand.dynamic.html.a(), new b());
      paramBundle = localSpanned;
      if (!(localSpanned instanceof Spannable)) {
        break;
      }
      i = localSpanned.length();
      Spannable localSpannable = (Spannable)localSpanned;
      URLSpan[] arrayOfURLSpan = (URLSpan[])localSpannable.getSpans(0, i, URLSpan.class);
      paramBundle = new SpannableStringBuilder(localSpanned);
      int j = arrayOfURLSpan.length;
      i = 0;
      while (i < j)
      {
        localSpanned = arrayOfURLSpan[i];
        paramBundle.removeSpan(localSpanned);
        paramBundle.setSpan(new CustomURLSpan(localSpanned.getURL()), localSpannable.getSpanStart(localSpanned), localSpannable.getSpanEnd(localSpanned), 34);
        i += 1;
      }
    }
    localTextView.setText(paramBundle);
    localTextView.setMovementMethod(LinkMovementMethod.getInstance());
    findViewById(b.b.restart_support_process_btn).setOnClickListener(new WxaWidgetDebugUI.3(this));
    paramBundle = findViewById(b.b.widget_settings_btn);
    if (((e)g.r(e.class)).Jn().Jt())
    {
      paramBundle.setVisibility(0);
      paramBundle.setOnClickListener(new WxaWidgetDebugUI.4(this));
      return;
    }
    paramBundle.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.ui.WxaWidgetDebugUI
 * JD-Core Version:    0.7.0.1
 */