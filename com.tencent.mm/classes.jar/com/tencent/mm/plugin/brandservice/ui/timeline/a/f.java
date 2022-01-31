package com.tencent.mm.plugin.brandservice.ui.timeline.a;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.q;
import com.tencent.mm.plugin.brandservice.ui.timeline.a;
import java.util.ArrayList;
import java.util.List;

public final class f
  extends e
{
  public LinearLayout jXp;
  public LinearLayout jXq;
  public LinearLayout jYa;
  public LinearLayout jYb;
  public TextView jYc;
  public List<b> jYd;
  public l jYe;
  public n jYf;
  public j jYg;
  public k jYh;
  public o jYi;
  public i jYj;
  public m jYk;
  public View.OnClickListener jYl;
  
  public f()
  {
    AppMethodBeat.i(14259);
    this.jYd = new ArrayList();
    this.jYe = new l();
    this.jYf = new n();
    this.jYg = new j();
    this.jYh = new k();
    this.jYi = new o();
    this.jYj = new i();
    this.jYk = new m();
    this.jYl = new f.1(this);
    AppMethodBeat.o(14259);
  }
  
  public static void R(View paramView, int paramInt)
  {
    AppMethodBeat.i(14263);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    localLayoutParams.rightMargin = paramInt;
    paramView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(14263);
  }
  
  private void a(View paramView, c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(14260);
    if (paramBoolean)
    {
      if (paramc.jXr == null) {
        paramc.a(paramView, this.jXV);
      }
      if (paramc.jXr != null)
      {
        paramc.jXr.setVisibility(0);
        AppMethodBeat.o(14260);
      }
    }
    else if (paramc.jXr != null)
    {
      paramc.jXr.setVisibility(8);
    }
    AppMethodBeat.o(14260);
  }
  
  public static void c(q paramq)
  {
    if (paramq.type == 6) {
      paramq.type = 7;
    }
  }
  
  public static void s(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(14262);
    paramView.setPadding(0, paramInt1 - a.jVC, 0, paramInt2 - a.jVC);
    AppMethodBeat.o(14262);
  }
  
  public final void a(f paramf, int paramInt1, int paramInt2)
  {
    boolean bool2 = true;
    AppMethodBeat.i(14261);
    boolean bool1;
    if (paramInt1 == 5)
    {
      bool1 = true;
      a(paramf.jYa, paramf.jYf, bool1);
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
        a(paramf.jYa, paramf.jYh, bool1);
        if (bool1) {
          i = 1;
        }
        if (paramInt1 != 7) {
          break label220;
        }
        bool1 = true;
        a(paramf.jYa, paramf.jYi, bool1);
        if (bool1) {
          i = 1;
        }
        if (paramInt1 != 6) {
          break label226;
        }
        bool1 = true;
        a(paramf.jYa, paramf.jYj, bool1);
        if (bool1) {
          i = 1;
        }
        if (paramInt1 != 10) {
          break label232;
        }
        bool1 = true;
        a(paramf.jYa, paramf.jYk, bool1);
        if (!bool1) {
          break label244;
        }
        i = 1;
      }
      for (;;)
      {
        LinearLayout localLinearLayout = paramf.jYa;
        paramf = paramf.jYe;
        if ((i == 0) && (paramInt2 > 0) && (paramInt1 != -1)) {}
        for (bool1 = bool2;; bool1 = false)
        {
          a(localLinearLayout, paramf, bool1);
          AppMethodBeat.o(14261);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.f
 * JD-Core Version:    0.7.0.1
 */