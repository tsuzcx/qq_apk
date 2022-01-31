package com.tencent.mm.plugin.freewifi.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.br.d;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.ai;
import java.lang.ref.WeakReference;
import java.util.Date;

public final class a
  extends b
{
  private static Date kqV = null;
  private boolean hasInit = false;
  private Runnable kqW = new a.2(this);
  
  public a(Context paramContext)
  {
    super(paramContext);
    initialize();
  }
  
  private void initialize()
  {
    View localView;
    if (this.view != null)
    {
      localView = this.view.findViewById(R.h.free_wifi_tip_view);
      if (!this.hasInit) {}
    }
    else
    {
      return;
    }
    this.hasInit = true;
    localView.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        paramAnonymousView = new Date();
        if ((a.aUV() != null) && (paramAnonymousView.getTime() - a.aUV().getTime() < 1000L)) {
          return;
        }
        a.a(paramAnonymousView);
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("free_wifi_source", 2);
        paramAnonymousView.addFlags(67108864);
        d.b((Context)a.a(a.this).get(), "freewifi", ".ui.FreeWifiEntryUI", paramAnonymousView);
      }
    });
    localView.setVisibility(8);
  }
  
  public final boolean apu()
  {
    if (!this.hasInit)
    {
      initialize();
      return false;
    }
    ai.S(this.kqW);
    ai.l(this.kqW, 500L);
    return true;
  }
  
  public final void destroy() {}
  
  public final int getLayoutId()
  {
    return R.i.free_wifi_tips;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.a
 * JD-Core Version:    0.7.0.1
 */