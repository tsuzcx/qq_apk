package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.v;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.g;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.c;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.storage.w;
import java.util.ArrayList;
import java.util.List;

public final class ab
  extends aa
{
  public LinearLayout okA;
  public LinearLayout okB;
  public View.OnClickListener olA;
  public LinearLayout olp;
  public LinearLayout olq;
  public TextView olr;
  public List<x> ols;
  public ah olt;
  public aj olu;
  public af olv;
  public ag olw;
  public ak olx;
  public ae oly;
  public ai olz;
  
  public ab()
  {
    AppMethodBeat.i(6030);
    this.ols = new ArrayList();
    this.olt = new ah();
    this.olu = new aj();
    this.olv = new af();
    this.olw = new ag();
    this.olx = new ak();
    this.oly = new ae();
    this.olz = new ai();
    this.olA = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(6028);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineItemHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramAnonymousView = (w)paramAnonymousView.getTag();
        paramAnonymousView.field_isExpand = true;
        paramAnonymousView.field_status = 4;
        paramAnonymousView.field_isRead = 1;
        paramAnonymousView.field_hasShow = 1;
        com.tencent.mm.al.ag.aGv().q(paramAnonymousView);
        com.tencent.mm.plugin.brandservice.ui.timeline.b.cn(ab.this.oll.mMj);
        ab.this.oll.ogr.d(paramAnonymousView, 0);
        a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineItemHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(6028);
      }
    };
    AppMethodBeat.o(6030);
  }
  
  public static void Y(View paramView, int paramInt)
  {
    AppMethodBeat.i(6034);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    localLayoutParams.rightMargin = paramInt;
    paramView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(6034);
  }
  
  private void a(View paramView, y paramy, boolean paramBoolean)
  {
    AppMethodBeat.i(6031);
    if (paramBoolean)
    {
      if (paramy.oiV == null) {
        paramy.a(paramView, this.oll);
      }
      if (paramy.oiV != null)
      {
        paramy.oiV.setVisibility(0);
        AppMethodBeat.o(6031);
      }
    }
    else if (paramy.oiV != null)
    {
      paramy.oiV.setVisibility(8);
    }
    AppMethodBeat.o(6031);
  }
  
  public static void c(v paramv)
  {
    if (paramv.type == 6) {
      paramv.type = 7;
    }
  }
  
  public static void s(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(6033);
    paramView.setPadding(0, paramInt1 - com.tencent.mm.plugin.brandservice.ui.timeline.b.ogc, 0, paramInt2 - com.tencent.mm.plugin.brandservice.ui.timeline.b.ogc);
    AppMethodBeat.o(6033);
  }
  
  public final void a(ab paramab, int paramInt1, int paramInt2)
  {
    boolean bool2 = true;
    AppMethodBeat.i(6032);
    boolean bool1;
    if (paramInt1 == 5)
    {
      bool1 = true;
      a(paramab.olp, paramab.olu, bool1);
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
        a(paramab.olp, paramab.olw, bool1);
        if (bool1) {
          i = 1;
        }
        if (paramInt1 != 7) {
          break label220;
        }
        bool1 = true;
        a(paramab.olp, paramab.olx, bool1);
        if (bool1) {
          i = 1;
        }
        if (paramInt1 != 6) {
          break label226;
        }
        bool1 = true;
        a(paramab.olp, paramab.oly, bool1);
        if (bool1) {
          i = 1;
        }
        if (paramInt1 != 10) {
          break label232;
        }
        bool1 = true;
        a(paramab.olp, paramab.olz, bool1);
        if (!bool1) {
          break label244;
        }
        i = 1;
      }
      for (;;)
      {
        LinearLayout localLinearLayout = paramab.olp;
        paramab = paramab.olt;
        if ((i == 0) && (paramInt2 > 0) && (paramInt1 != -1)) {}
        for (bool1 = bool2;; bool1 = false)
        {
          a(localLinearLayout, paramab, bool1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.ab
 * JD-Core Version:    0.7.0.1
 */