package com.tencent.mm.plugin.appbrand.dynamic.ui;

import android.app.Activity;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.e;
import com.tencent.mm.modelappbrand.l;
import com.tencent.mm.plugin.appbrand.dynamic.html.CustomURLSpan;
import com.tencent.mm.plugin.appbrand.widget.n;
import com.tencent.mm.plugin.appbrand.widget.o;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMSwitchBtn;

public class WxaWidgetDebugUI
  extends MMActivity
{
  String appId;
  int cvs;
  int gXf;
  MMSwitchBtn hqU;
  n hqV;
  String id;
  
  public int getLayoutId()
  {
    return 2130971340;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(11015);
    super.onCreate(paramBundle);
    setBackBtn(new WxaWidgetDebugUI.1(this));
    if (((e)g.E(e.class)).acl().acr()) {}
    TextView localTextView;
    for (paramBundle = String.format("(%s)", new Object[] { com.tencent.mm.plugin.appbrand.dynamic.widget.b.aAl() });; paramBundle = "")
    {
      setMMTitle(getString(2131306058, new Object[] { paramBundle }));
      paramBundle = getIntent();
      this.id = paramBundle.getStringExtra("id");
      this.appId = paramBundle.getStringExtra("app_id");
      this.cvs = paramBundle.getIntExtra("pkg_type", 0);
      this.gXf = paramBundle.getIntExtra("pkg_version", 0);
      setMMSubTitle(String.format("(%s)", new Object[] { this.id }));
      this.hqU = ((MMSwitchBtn)findViewById(2131829607));
      this.hqV = ((com.tencent.mm.plugin.appbrand.widget.a.a)g.E(com.tencent.mm.plugin.appbrand.widget.a.a.class)).auI().FC(this.appId);
      if (this.hqV == null)
      {
        this.hqV = new n();
        this.hqV.field_appId = this.appId;
      }
      this.hqU.setCheck(this.hqV.field_openDebug);
      this.hqU.setSwitchListener(new WxaWidgetDebugUI.2(this));
      localTextView = (TextView)findViewById(2131829608);
      Spanned localSpanned = Html.fromHtml(getString(2131306064), new com.tencent.mm.plugin.appbrand.dynamic.html.a(), new com.tencent.mm.plugin.appbrand.dynamic.html.b());
      paramBundle = localSpanned;
      if (!(localSpanned instanceof Spannable)) {
        break;
      }
      int i = localSpanned.length();
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
    findViewById(2131827628).setOnClickListener(new WxaWidgetDebugUI.3(this));
    paramBundle = findViewById(2131829609);
    if (((e)g.E(e.class)).acl().acr())
    {
      paramBundle.setVisibility(0);
      paramBundle.setOnClickListener(new WxaWidgetDebugUI.4(this));
      AppMethodBeat.o(11015);
      return;
    }
    paramBundle.setVisibility(8);
    AppMethodBeat.o(11015);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.ui.WxaWidgetDebugUI
 * JD-Core Version:    0.7.0.1
 */