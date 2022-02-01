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
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.ipcall.model.f.i;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.protobuf.blu;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;

public final class e
{
  View vbA;
  IPCallAddressUI vbB;
  boolean vbC = false;
  TextView vbD = null;
  TextView vbE = null;
  LinearLayout vbF = null;
  TextView vbG = null;
  ImageView vbH = null;
  ListView vby;
  h vbz;
  
  public e(IPCallAddressUI paramIPCallAddressUI, ListView paramListView, View paramView)
  {
    this.vby = paramListView;
    this.vbB = paramIPCallAddressUI;
    this.vbA = paramView;
  }
  
  public final void dhn()
  {
    AppMethodBeat.i(25658);
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(25654);
        bc.aCg();
        if (((Boolean)com.tencent.mm.model.c.ajA().get(am.a.INe, Boolean.FALSE)).booleanValue()) {
          e.this.vbH.setVisibility(0);
        }
        String str2;
        for (;;)
        {
          bc.aCg();
          String str1 = (String)com.tencent.mm.model.c.ajA().get(am.a.INg, "");
          bc.aCg();
          str2 = (String)com.tencent.mm.model.c.ajA().get(am.a.INh, "");
          if (bu.isNullOrNil(str1)) {
            break;
          }
          e.this.vbG.setText(str1);
          e.this.vbF.setVisibility(0);
          AppMethodBeat.o(25654);
          return;
          e.this.vbH.setVisibility(8);
        }
        if (!bu.isNullOrNil(str2))
        {
          e.this.vbG.setText(str2);
          e.this.vbF.setVisibility(0);
          AppMethodBeat.o(25654);
          return;
        }
        e.this.vbG.setText("");
        e.this.vbF.setVisibility(8);
        AppMethodBeat.o(25654);
      }
    });
    AppMethodBeat.o(25658);
  }
  
  public final void dho()
  {
    AppMethodBeat.i(25659);
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(25655);
        blu localblu = com.tencent.mm.plugin.ipcall.a.c.dia();
        if (localblu != null)
        {
          e.this.vbD.setText(localblu.GYR);
          if (!bu.isNullOrNil(localblu.GYZ))
          {
            e.this.vbE.setText(localblu.GYZ);
            e.this.vbE.setVisibility(0);
            AppMethodBeat.o(25655);
            return;
          }
          e.this.vbE.setText("");
          e.this.vbE.setVisibility(8);
          AppMethodBeat.o(25655);
          return;
        }
        e.this.vbD.setText("");
        e.this.vbE.setText("");
        e.this.vbE.setVisibility(8);
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