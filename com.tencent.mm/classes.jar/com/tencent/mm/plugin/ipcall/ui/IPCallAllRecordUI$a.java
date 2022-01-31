package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ipcall.a.g.d;
import com.tencent.mm.plugin.ipcall.a.g.k;
import com.tencent.mm.plugin.ipcall.a.g.l;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.ipcall.b.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.p;

final class IPCallAllRecordUI$a
  extends p<k>
{
  public IPCallAllRecordUI$a(IPCallAllRecordUI paramIPCallAllRecordUI, Context paramContext)
  {
    super(paramContext, null);
    AppMethodBeat.i(22065);
    qp(true);
    AppMethodBeat.o(22065);
  }
  
  public final void Ku()
  {
    Object localObject2 = null;
    AppMethodBeat.i(22066);
    Object localObject1;
    if (!bo.isNullOrNil(IPCallAllRecordUI.a(this.nRW)))
    {
      Object localObject3 = IPCallAllRecordUI.a(this.nRW);
      localObject1 = localObject2;
      if (!bo.isNullOrNil((String)localObject3))
      {
        localObject3 = i.bJt().Ra((String)localObject3);
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          localObject1 = localObject2;
          if (((com.tencent.mm.plugin.ipcall.a.g.c)localObject3).systemRowid != -1L)
          {
            long l = ((com.tencent.mm.plugin.ipcall.a.g.c)localObject3).systemRowid;
            localObject1 = i.bJu().kt(l);
          }
        }
      }
    }
    for (;;)
    {
      setCursor((Cursor)localObject1);
      AppMethodBeat.o(22066);
      return;
      localObject1 = localObject2;
      if (!bo.isNullOrNil(IPCallAllRecordUI.b(this.nRW))) {
        localObject1 = i.bJu().Rf(IPCallAllRecordUI.b(this.nRW));
      }
    }
  }
  
  public final void Kv()
  {
    AppMethodBeat.i(22067);
    bKb();
    Ku();
    AppMethodBeat.o(22067);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(22068);
    View localView = paramView;
    if (paramView == null)
    {
      localView = this.nRW.getLayoutInflater().inflate(2130969935, paramViewGroup, false);
      paramView = new IPCallAllRecordUI.a.a(this);
      paramView.nRX = ((TextView)localView.findViewById(2131825273));
      paramView.nRY = ((TextView)localView.findViewById(2131825274));
      paramView.gpr = ((TextView)localView.findViewById(2131825275));
      localView.setTag(paramView);
    }
    paramView = (k)getItem(paramInt);
    paramViewGroup = (IPCallAllRecordUI.a.a)localView.getTag();
    paramViewGroup.nRY.setText(a.RG(paramView.field_phonenumber));
    if (paramView.field_duration > 0L) {
      paramViewGroup.gpr.setText(com.tencent.mm.plugin.ipcall.b.c.ky(paramView.field_duration));
    }
    for (;;)
    {
      paramViewGroup.nRX.setText(com.tencent.mm.plugin.ipcall.b.c.ku(paramView.field_calltime));
      AppMethodBeat.o(22068);
      return localView;
      paramViewGroup.gpr.setText(com.tencent.mm.plugin.ipcall.b.c.xX(paramView.field_status));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallAllRecordUI.a
 * JD-Core Version:    0.7.0.1
 */