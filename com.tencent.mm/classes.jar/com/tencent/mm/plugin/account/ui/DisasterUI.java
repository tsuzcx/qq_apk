package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;

public class DisasterUI
  extends MMActivity
{
  protected final int getLayoutId()
  {
    return q.g.disaster_ui;
  }
  
  public final boolean needShowIdcError()
  {
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("key_disaster_content");
    String str = getIntent().getStringExtra("key_disaster_url");
    y.i("MicroMsg.DisasterUI", "summerdiz onCreate :%d, content[%s], url[%s]", new Object[] { Integer.valueOf(hashCode()), paramBundle, str });
    ((TextView)findViewById(q.f.notify_text)).setText(paramBundle);
    findViewById(q.f.notify_link).setOnClickListener(new DisasterUI.1(this, str));
    setMMTitle(getString(q.j.disaster_tips));
    setBackBtn(new DisasterUI.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.DisasterUI
 * JD-Core Version:    0.7.0.1
 */