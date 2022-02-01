package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.ipcall.model.f.i;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.protobuf.blc;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;

public final class e
{
  ListView uPM;
  h uPN;
  View uPO;
  IPCallAddressUI uPP;
  boolean uPQ = false;
  TextView uPR = null;
  TextView uPS = null;
  LinearLayout uPT = null;
  TextView uPU = null;
  ImageView uPV = null;
  
  public e(IPCallAddressUI paramIPCallAddressUI, ListView paramListView, View paramView)
  {
    this.uPM = paramListView;
    this.uPP = paramIPCallAddressUI;
    this.uPO = paramView;
  }
  
  public final void dev()
  {
    AppMethodBeat.i(25658);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(25654);
        ba.aBQ();
        if (((Boolean)com.tencent.mm.model.c.ajl().get(al.a.IsI, Boolean.FALSE)).booleanValue()) {
          e.this.uPV.setVisibility(0);
        }
        String str2;
        for (;;)
        {
          ba.aBQ();
          String str1 = (String)com.tencent.mm.model.c.ajl().get(al.a.IsK, "");
          ba.aBQ();
          str2 = (String)com.tencent.mm.model.c.ajl().get(al.a.IsL, "");
          if (bt.isNullOrNil(str1)) {
            break;
          }
          e.this.uPU.setText(str1);
          e.this.uPT.setVisibility(0);
          AppMethodBeat.o(25654);
          return;
          e.this.uPV.setVisibility(8);
        }
        if (!bt.isNullOrNil(str2))
        {
          e.this.uPU.setText(str2);
          e.this.uPT.setVisibility(0);
          AppMethodBeat.o(25654);
          return;
        }
        e.this.uPU.setText("");
        e.this.uPT.setVisibility(8);
        AppMethodBeat.o(25654);
      }
    });
    AppMethodBeat.o(25658);
  }
  
  public final void dew()
  {
    AppMethodBeat.i(25659);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(25655);
        blc localblc = com.tencent.mm.plugin.ipcall.a.c.dfi();
        if (localblc != null)
        {
          e.this.uPR.setText(localblc.GFp);
          if (!bt.isNullOrNil(localblc.GFx))
          {
            e.this.uPS.setText(localblc.GFx);
            e.this.uPS.setVisibility(0);
            AppMethodBeat.o(25655);
            return;
          }
          e.this.uPS.setText("");
          e.this.uPS.setVisibility(8);
          AppMethodBeat.o(25655);
          return;
        }
        e.this.uPR.setText("");
        e.this.uPS.setText("");
        e.this.uPS.setVisibility(8);
        AppMethodBeat.o(25655);
      }
    });
    AppMethodBeat.o(25659);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.e
 * JD-Core Version:    0.7.0.1
 */