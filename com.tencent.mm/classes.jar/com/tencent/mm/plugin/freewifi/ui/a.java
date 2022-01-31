package com.tencent.mm.plugin.freewifi.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.al;
import java.lang.ref.WeakReference;
import java.util.Date;

public final class a
  extends b
{
  private static Date mMI = null;
  private boolean hasInit;
  private View jGC;
  private View jGD;
  private Runnable mMJ;
  private TextView titleTv;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(20928);
    this.hasInit = false;
    this.mMJ = new a.2(this);
    initialize();
    AppMethodBeat.o(20928);
  }
  
  private void initialize()
  {
    AppMethodBeat.i(20929);
    if (this.view != null)
    {
      if (this.hasInit)
      {
        AppMethodBeat.o(20929);
        return;
      }
      this.jGC = this.view.findViewById(2131824295);
      this.jGD = this.view.findViewById(2131821667);
      this.titleTv = ((TextView)this.view.findViewById(2131824296));
      this.hasInit = true;
      this.jGC.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(20920);
          paramAnonymousView = new Date();
          if ((a.bBu() != null) && (paramAnonymousView.getTime() - a.bBu().getTime() < 1000L))
          {
            AppMethodBeat.o(20920);
            return;
          }
          a.a(paramAnonymousView);
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("free_wifi_source", 2);
          paramAnonymousView.addFlags(67108864);
          d.b((Context)a.a(a.this).get(), "freewifi", ".ui.FreeWifiEntryUI", paramAnonymousView);
          AppMethodBeat.o(20920);
        }
      });
      this.jGC.setVisibility(8);
    }
    AppMethodBeat.o(20929);
  }
  
  public final boolean aMK()
  {
    AppMethodBeat.i(20930);
    if ((this.nwf) && (this.eUx))
    {
      this.jGD.setBackgroundResource(2130840583);
      this.jGC.setBackground(null);
      this.titleTv.setBackground(null);
    }
    while (!this.hasInit)
    {
      initialize();
      AppMethodBeat.o(20930);
      return false;
      if (this.nwf)
      {
        this.jGD.setBackgroundResource(2130839279);
        this.jGC.setBackgroundResource(2130839278);
        this.titleTv.setBackgroundResource(2130839276);
      }
      else if (this.eUx)
      {
        this.jGD.setBackgroundResource(2130839279);
        this.jGC.setBackgroundResource(2130839276);
        this.titleTv.setBackground(null);
      }
      else
      {
        this.jGD.setBackgroundResource(2130839279);
        this.jGC.setBackground(null);
        this.titleTv.setBackgroundResource(2130839276);
      }
    }
    al.ae(this.mMJ);
    al.p(this.mMJ, 500L);
    AppMethodBeat.o(20930);
    return true;
  }
  
  public final void destroy() {}
  
  public final int getLayoutId()
  {
    return 2130969638;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.a
 * JD-Core Version:    0.7.0.1
 */