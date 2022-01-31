package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.at.a.a;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.at.o;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.x;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.tools.l;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;

final class ExdeviceManageDeviceUI$a
  extends BaseAdapter
  implements f
{
  private n.d jVk;
  private WeakReference<Context> jZe;
  private List<com.tencent.mm.plugin.exdevice.h.b> lJU;
  private com.tencent.mm.at.a.a.c lKi;
  boolean lNb;
  private View.OnClickListener lNc;
  private l lNd;
  private volatile int lNe;
  private p tipDialog;
  
  public ExdeviceManageDeviceUI$a(Context paramContext)
  {
    AppMethodBeat.i(19988);
    this.tipDialog = null;
    this.lNe = -1;
    this.jZe = new WeakReference(paramContext);
    this.lJU = new LinkedList();
    this.lNd = new l(paramContext);
    paramContext = new c.a();
    paramContext.eNY = 2130838667;
    this.lKi = paramContext.ahY();
    this.jVk = new ExdeviceManageDeviceUI.a.1(this);
    this.lNc = new ExdeviceManageDeviceUI.a.2(this);
    bt(ad.bpY().bqD());
    AppMethodBeat.o(19988);
  }
  
  public final void bt(List<com.tencent.mm.plugin.exdevice.h.b> paramList)
  {
    AppMethodBeat.i(19989);
    this.lJU.clear();
    if ((paramList == null) || (paramList.size() == 0))
    {
      AppMethodBeat.o(19989);
      return;
    }
    this.lJU.addAll(paramList);
    AppMethodBeat.o(19989);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(19990);
    int i = this.lJU.size();
    AppMethodBeat.o(19990);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(19992);
    com.tencent.mm.plugin.exdevice.h.b localb = vf(paramInt);
    View localView;
    if (paramView == null)
    {
      paramView = new ExdeviceManageDeviceUI.a.a((byte)0);
      localView = View.inflate(paramViewGroup.getContext(), 2130969458, null);
      paramView.lNh = localView.findViewById(2131821084);
      paramView.gzk = ((TextView)localView.findViewById(2131823741));
      paramView.lNi = localView.findViewById(2131823782);
      paramView.ivs = ((ImageView)localView.findViewById(2131823740));
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    while (localb == null)
    {
      paramView = "";
      ab.d("MicroMsg.ExdeviceManageDeviceUI", "position(%s), name(%s), mac(%s).", new Object[] { Integer.valueOf(paramInt), paramView, Long.valueOf(localb.field_mac) });
      paramViewGroup.gzk.setText(paramView);
      o.ahG().a(localb.iconUrl, paramViewGroup.ivs, this.lKi);
      paramViewGroup.lNi.setTag(Integer.valueOf(paramInt));
      if (!this.lNb) {
        break label329;
      }
      paramViewGroup.lNi.setVisibility(0);
      label197:
      paramViewGroup.lNh.setTag(Integer.valueOf(paramInt));
      paramViewGroup.lNh.setOnClickListener(this.lNc);
      AppMethodBeat.o(19992);
      return localView;
      paramViewGroup = (ExdeviceManageDeviceUI.a.a)paramView.getTag();
      localView = paramView;
    }
    if (!bo.isNullOrNil(localb.dCJ)) {
      paramView = localb.dCJ;
    }
    for (;;)
    {
      paramView = bo.nullAsNil(paramView);
      break;
      if (!bo.isNullOrNil(localb.dCK))
      {
        paramView = localb.dCK;
      }
      else if (localb.field_mac != 0L)
      {
        paramView = com.tencent.mm.plugin.exdevice.j.b.jw(localb.field_mac);
      }
      else
      {
        if (!bo.isNullOrNil(localb.field_deviceID))
        {
          paramView = localb.field_deviceID;
          continue;
          label329:
          paramViewGroup.lNi.setVisibility(8);
          break label197;
        }
        paramView = null;
      }
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(19993);
    if (paramm == null)
    {
      ab.e("MicroMsg.ExdeviceManageDeviceUI", "scene is null.");
      AppMethodBeat.o(19993);
      return;
    }
    if ((paramm instanceof x))
    {
      if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
        this.tipDialog.dismiss();
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if ((this.lNe < 0) || (this.lNe >= this.lJU.size()))
        {
          AppMethodBeat.o(19993);
          return;
        }
        al.d(new ExdeviceManageDeviceUI.a.6(this));
      }
    }
    AppMethodBeat.o(19993);
  }
  
  public final com.tencent.mm.plugin.exdevice.h.b vf(int paramInt)
  {
    AppMethodBeat.i(19991);
    com.tencent.mm.plugin.exdevice.h.b localb = (com.tencent.mm.plugin.exdevice.h.b)this.lJU.get(paramInt);
    AppMethodBeat.o(19991);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceManageDeviceUI.a
 * JD-Core Version:    0.7.0.1
 */