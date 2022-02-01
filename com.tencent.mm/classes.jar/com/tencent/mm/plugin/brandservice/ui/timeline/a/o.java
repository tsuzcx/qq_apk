package com.tencent.mm.plugin.brandservice.ui.timeline.a;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.af;
import com.tencent.mm.plugin.brandservice.ui.timeline.h;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import java.util.ArrayList;
import java.util.List;

public final class o
  extends n
{
  public LinearLayout nBY;
  public LinearLayout nBZ;
  public LinearLayout nCR;
  public LinearLayout nCS;
  public TextView nCT;
  public List<k> nCU;
  public u nCV;
  public w nCW;
  public s nCX;
  public t nCY;
  public x nCZ;
  public r nDa;
  public v nDb;
  public View.OnClickListener nDc;
  
  public o()
  {
    AppMethodBeat.i(6030);
    this.nCU = new ArrayList();
    this.nCV = new u();
    this.nCW = new w();
    this.nCX = new s();
    this.nCY = new t();
    this.nCZ = new x();
    this.nDa = new r();
    this.nDb = new v();
    this.nDc = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(6028);
        paramAnonymousView = (com.tencent.mm.storage.t)paramAnonymousView.getTag();
        paramAnonymousView.field_isExpand = true;
        paramAnonymousView.field_status = 4;
        paramAnonymousView.field_isRead = 1;
        paramAnonymousView.field_hasShow = 1;
        af.aDc().k(paramAnonymousView);
        com.tencent.mm.plugin.brandservice.ui.timeline.c.cl(o.this.nCM.mgF);
        o.this.nCM.nzw.d(paramAnonymousView, 0);
        AppMethodBeat.o(6028);
      }
    };
    AppMethodBeat.o(6030);
  }
  
  public static void X(View paramView, int paramInt)
  {
    AppMethodBeat.i(6034);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    localLayoutParams.rightMargin = paramInt;
    paramView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(6034);
  }
  
  private void a(View paramView, l paraml, boolean paramBoolean)
  {
    AppMethodBeat.i(6031);
    if (paramBoolean)
    {
      if (paraml.nBh == null) {
        paraml.a(paramView, this.nCM);
      }
      if (paraml.nBh != null)
      {
        paraml.nBh.setVisibility(0);
        AppMethodBeat.o(6031);
      }
    }
    else if (paraml.nBh != null)
    {
      paraml.nBh.setVisibility(8);
    }
    AppMethodBeat.o(6031);
  }
  
  public static void c(com.tencent.mm.ah.v paramv)
  {
    if (paramv.type == 6) {
      paramv.type = 7;
    }
  }
  
  public static void t(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(6033);
    paramView.setPadding(0, paramInt1 - com.tencent.mm.plugin.brandservice.ui.timeline.c.nzh, 0, paramInt2 - com.tencent.mm.plugin.brandservice.ui.timeline.c.nzh);
    AppMethodBeat.o(6033);
  }
  
  public final void a(o paramo, int paramInt1, int paramInt2)
  {
    boolean bool2 = true;
    AppMethodBeat.i(6032);
    boolean bool1;
    if (paramInt1 == 5)
    {
      bool1 = true;
      a(paramo.nCR, paramo.nCW, bool1);
      if (!bool1) {
        break label247;
      }
    }
    label48:
    label79:
    label110:
    label244:
    label247:
    for (int i = 1;; i = 0)
    {
      if (paramInt1 == 8)
      {
        bool1 = true;
        a(paramo.nCR, paramo.nCY, bool1);
        if (bool1) {
          i = 1;
        }
        if (paramInt1 != 7) {
          break label220;
        }
        bool1 = true;
        a(paramo.nCR, paramo.nCZ, bool1);
        if (bool1) {
          i = 1;
        }
        if (paramInt1 != 6) {
          break label226;
        }
        bool1 = true;
        a(paramo.nCR, paramo.nDa, bool1);
        if (bool1) {
          i = 1;
        }
        if (paramInt1 != 10) {
          break label232;
        }
        bool1 = true;
        a(paramo.nCR, paramo.nDb, bool1);
        if (!bool1) {
          break label244;
        }
        i = 1;
      }
      for (;;)
      {
        LinearLayout localLinearLayout = paramo.nCR;
        paramo = paramo.nCV;
        if ((i == 0) && (paramInt2 > 0) && (paramInt1 != -1)) {}
        for (bool1 = bool2;; bool1 = false)
        {
          a(localLinearLayout, paramo, bool1);
          AppMethodBeat.o(6032);
          return;
          bool1 = false;
          break;
          bool1 = false;
          break label48;
          bool1 = false;
          break label79;
          bool1 = false;
          break label110;
          bool1 = false;
          break label141;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.o
 * JD-Core Version:    0.7.0.1
 */