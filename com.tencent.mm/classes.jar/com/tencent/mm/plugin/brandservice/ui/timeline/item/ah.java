package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.message.u;
import com.tencent.mm.message.v;
import com.tencent.mm.plugin.brandservice.d.d;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.d.i;
import com.tencent.mm.plugin.brandservice.ui.b.d;
import com.tencent.mm.plugin.brandservice.ui.b.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.widget.MMNeat7extView;

public class ah
  extends ai
{
  public int mCount = 0;
  public ImageView vIM;
  public MMNeat7extView vIW;
  public ImageView vIX;
  public LinearLayout vIY;
  public LinearLayout vIZ;
  public MMNeat7extView vJa;
  public MMNeat7extView vJb;
  public View vJc;
  public TextView vJd;
  public int vMA = 0;
  public int vMB = 0;
  public View vMx;
  public TextView vMy;
  public boolean vMz = false;
  
  private void a(MMNeat7extView paramMMNeat7extView, v paramv, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(162406);
    paramMMNeat7extView.setMaxLines(2);
    int i;
    if (paramBoolean2)
    {
      i = 0;
      if (Util.isNullOrNil(paramv.title)) {
        break label92;
      }
      com.tencent.mm.plugin.brandservice.model.b.vBC.a(paramv.title, paramMMNeat7extView, paramv, i);
      label42:
      if ((paramv.type != 0) || (paramv.nQp != 1)) {
        break label115;
      }
      paramMMNeat7extView.setTag(d.e.biz_pay, Boolean.TRUE);
    }
    for (;;)
    {
      if (paramBoolean1)
      {
        paramv = e.vYK;
        e.e(paramMMNeat7extView);
      }
      AppMethodBeat.o(162406);
      return;
      i = 11;
      break;
      label92:
      com.tencent.mm.plugin.brandservice.model.b.vBC.a(this.mContext.getString(d.i.biz_time_line_item_default_title), paramMMNeat7extView, paramv, i);
      break label42;
      label115:
      paramMMNeat7extView.setTag(d.e.biz_pay, Boolean.FALSE);
    }
  }
  
  public static boolean a(int paramInt, v paramv)
  {
    AppMethodBeat.i(6013);
    if ((paramv.type == 0) || (paramv.type == 1))
    {
      if ((paramInt == 1) && (com.tencent.mm.plugin.brandservice.ui.b.b.dhQ()))
      {
        AppMethodBeat.o(6013);
        return true;
      }
      AppMethodBeat.o(6013);
      return false;
    }
    if (paramInt == 1)
    {
      AppMethodBeat.o(6013);
      return true;
    }
    AppMethodBeat.o(6013);
    return false;
  }
  
  public void a(int paramInt, v paramv, ab paramab)
  {
    AppMethodBeat.i(302531);
    if (a(paramInt, paramv))
    {
      this.vIW.setVisibility(8);
      this.vIW.aZ("");
      this.vIZ.setVisibility(0);
      a(this.vJa, paramv, false, true);
      MMNeat7extView localMMNeat7extView = this.vJb;
      localMMNeat7extView.setMaxLines(2);
      int i;
      if (!Util.isNullOrNil(paramv.nUO))
      {
        Object localObject = e.vYK;
        if (!e.dhU())
        {
          localObject = d.ake(paramv.nUO);
          localMMNeat7extView.setVisibility(0);
          localMMNeat7extView.aZ((CharSequence)localObject);
          this.vJc.setVisibility(8);
          a(this.vMx, this.vMy, paramab, paramv);
          i = com.tencent.mm.cd.a.ms(this.mContext) - com.tencent.mm.cd.a.fromDPToPix(this.mContext, 48);
          this.vJa.setMaxLines(2);
          paramv = this.vJa.pE(i, 2147483647);
          if (paramv == null) {
            break label243;
          }
        }
      }
      label243:
      for (paramInt = paramv.jQH();; paramInt = -1)
      {
        Log.v("MicroMsg.BizTimeLineItem", "alvinluo fillTitleLayout title line: %d, width: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
        if ((paramv == null) || (paramv.jQH() < 2)) {
          break label248;
        }
        this.vJb.setMaxLines(1);
        AppMethodBeat.o(302531);
        return;
        localMMNeat7extView.setVisibility(8);
        break;
      }
      label248:
      this.vJb.setMaxLines(2);
      AppMethodBeat.o(302531);
      return;
    }
    this.vIW.setVisibility(0);
    this.vIZ.setVisibility(8);
    this.vJa.aZ("");
    this.vJb.aZ("");
    a(this.vIW, paramv, true, false);
    AppMethodBeat.o(302531);
  }
  
  public void a(int paramInt1, v paramv, ab paramab, int paramInt2, u paramu, int paramInt3)
  {
    this.mCount = paramInt1;
    this.vMz = false;
    this.vMA = 0;
    this.vMB = paramInt3;
  }
  
  public void a(View paramView, com.tencent.mm.plugin.brandservice.ui.timeline.b paramb)
  {
    AppMethodBeat.i(6008);
    super.a(paramView, paramb);
    AppMethodBeat.o(6008);
  }
  
  public void a(ab paramab, v paramv, View paramView, TextView paramTextView, int paramInt)
  {
    AppMethodBeat.i(6010);
    super.a(paramab, paramv, paramView, paramTextView, paramInt);
    this.vMA = paramInt;
    if (this.vIY == null)
    {
      AppMethodBeat.o(6010);
      return;
    }
    if ((this.vMz) && ((this.vMA > 0) || (!a(this.mCount, paramv))))
    {
      paramab = this.vIY;
      if (b(paramv)) {}
      for (paramInt = d.d.biz_time_line_title_bottom_round_gradient_mask;; paramInt = d.d.biz_time_line_title_gradient_mask)
      {
        paramab.setBackgroundResource(paramInt);
        AppMethodBeat.o(6010);
        return;
      }
    }
    this.vIY.setBackgroundResource(d.d.mm_trans);
    AppMethodBeat.o(6010);
  }
  
  public final boolean b(v paramv)
  {
    AppMethodBeat.i(6011);
    if (this.mCount > 1)
    {
      AppMethodBeat.o(6011);
      return false;
    }
    if ((this.mCount == 1) && (!a(this.mCount, paramv)))
    {
      AppMethodBeat.o(6011);
      return true;
    }
    AppMethodBeat.o(6011);
    return false;
  }
  
  public final void ddp()
  {
    AppMethodBeat.i(6009);
    if (this.vJU == null)
    {
      AppMethodBeat.o(6009);
      return;
    }
    this.vJc = this.vJU.findViewById(d.e.stat_layout);
    this.vJd = ((TextView)this.vJU.findViewById(d.e.friends_read_tv));
    AppMethodBeat.o(6009);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.ah
 * JD-Core Version:    0.7.0.1
 */