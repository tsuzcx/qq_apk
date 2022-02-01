package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.ipcall.model.h.d;
import com.tencent.mm.plugin.ipcall.model.h.k;
import com.tencent.mm.plugin.ipcall.model.h.m;
import com.tencent.mm.protocal.protobuf.bgu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import java.util.ArrayList;

public final class e
{
  ListView tMZ;
  h tNa;
  View tNb;
  IPCallAddressUI tNc;
  boolean tNd = false;
  TextView tNe = null;
  TextView tNf = null;
  LinearLayout tNg = null;
  TextView tNh = null;
  ImageView tNi = null;
  
  public e(IPCallAddressUI paramIPCallAddressUI, ListView paramListView, View paramView)
  {
    this.tMZ = paramListView;
    this.tNc = paramIPCallAddressUI;
    this.tNb = paramView;
  }
  
  public final void cVk()
  {
    AppMethodBeat.i(25658);
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(25654);
        az.ayM();
        if (((Boolean)com.tencent.mm.model.c.agA().get(ah.a.GGq, Boolean.FALSE)).booleanValue()) {
          e.this.tNi.setVisibility(0);
        }
        String str2;
        for (;;)
        {
          az.ayM();
          String str1 = (String)com.tencent.mm.model.c.agA().get(ah.a.GGs, "");
          az.ayM();
          str2 = (String)com.tencent.mm.model.c.agA().get(ah.a.GGt, "");
          if (bs.isNullOrNil(str1)) {
            break;
          }
          e.this.tNh.setText(str1);
          e.this.tNg.setVisibility(0);
          AppMethodBeat.o(25654);
          return;
          e.this.tNi.setVisibility(8);
        }
        if (!bs.isNullOrNil(str2))
        {
          e.this.tNh.setText(str2);
          e.this.tNg.setVisibility(0);
          AppMethodBeat.o(25654);
          return;
        }
        e.this.tNh.setText("");
        e.this.tNg.setVisibility(8);
        AppMethodBeat.o(25654);
      }
    });
    AppMethodBeat.o(25658);
  }
  
  public final void cVl()
  {
    AppMethodBeat.i(25659);
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(25655);
        bgu localbgu = com.tencent.mm.plugin.ipcall.a.c.cVX();
        if (localbgu != null)
        {
          e.this.tNe.setText(localbgu.EVS);
          if (!bs.isNullOrNil(localbgu.EWa))
          {
            e.this.tNf.setText(localbgu.EWa);
            e.this.tNf.setVisibility(0);
            AppMethodBeat.o(25655);
            return;
          }
          e.this.tNf.setText("");
          e.this.tNf.setVisibility(8);
          AppMethodBeat.o(25655);
          return;
        }
        e.this.tNe.setText("");
        e.this.tNf.setText("");
        e.this.tNf.setVisibility(8);
        AppMethodBeat.o(25655);
      }
    });
    AppMethodBeat.o(25659);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.e
 * JD-Core Version:    0.7.0.1
 */