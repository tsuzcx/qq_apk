package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.plugin.ipcall.a.g.d;
import com.tencent.mm.plugin.ipcall.a.g.k;
import com.tencent.mm.plugin.ipcall.a.g.l;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.ipcall.b.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.r;

final class IPCallAllRecordUI$a
  extends r<k>
{
  public IPCallAllRecordUI$a(IPCallAllRecordUI paramIPCallAllRecordUI, Context paramContext)
  {
    super(paramContext, null);
    mR(true);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null)
    {
      localView = this.luE.getLayoutInflater().inflate(R.i.ipcall_allrecord_item, paramViewGroup, false);
      paramView = new IPCallAllRecordUI.a.a(this);
      paramView.luF = ((TextView)localView.findViewById(R.h.profile_record_calltime_tv));
      paramView.luG = ((TextView)localView.findViewById(R.h.profile_record_phonenumber_tv));
      paramView.eXu = ((TextView)localView.findViewById(R.h.profile_record_status_duration_tv));
      localView.setTag(paramView);
    }
    paramView = (k)getItem(paramInt);
    paramViewGroup = (IPCallAllRecordUI.a.a)localView.getTag();
    paramViewGroup.luG.setText(a.Ge(paramView.field_phonenumber));
    if (paramView.field_duration > 0L) {
      paramViewGroup.eXu.setText(com.tencent.mm.plugin.ipcall.b.c.fa(paramView.field_duration));
    }
    for (;;)
    {
      paramViewGroup.luF.setText(com.tencent.mm.plugin.ipcall.b.c.eY(paramView.field_calltime));
      return localView;
      paramViewGroup.eXu.setText(com.tencent.mm.plugin.ipcall.b.c.sV(paramView.field_status));
    }
  }
  
  public final void yc()
  {
    Object localObject2 = null;
    Object localObject1;
    if (!bk.bl(IPCallAllRecordUI.a(this.luE)))
    {
      Object localObject3 = IPCallAllRecordUI.a(this.luE);
      localObject1 = localObject2;
      if (!bk.bl((String)localObject3))
      {
        localObject3 = i.bcm().FA((String)localObject3);
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          localObject1 = localObject2;
          if (((com.tencent.mm.plugin.ipcall.a.g.c)localObject3).ujK != -1L)
          {
            long l = ((com.tencent.mm.plugin.ipcall.a.g.c)localObject3).ujK;
            localObject1 = i.bcn().eX(l);
          }
        }
      }
    }
    for (;;)
    {
      setCursor((Cursor)localObject1);
      return;
      localObject1 = localObject2;
      if (!bk.bl(IPCallAllRecordUI.b(this.luE))) {
        localObject1 = i.bcn().FE(IPCallAllRecordUI.b(this.luE));
      }
    }
  }
  
  protected final void yd()
  {
    bcS();
    yc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallAllRecordUI.a
 * JD-Core Version:    0.7.0.1
 */