package com.tencent.mm.plugin.ipcall.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ipcall.a.a;
import com.tencent.mm.plugin.ipcall.model.h.d;
import com.tencent.mm.plugin.ipcall.model.h.k;
import com.tencent.mm.plugin.ipcall.model.h.l;
import com.tencent.mm.plugin.ipcall.model.i;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.r;

public class IPCallAllRecordUI
  extends MMActivity
{
  private String dJq;
  private String dLq;
  private ListView vbV;
  private boolean vbW = false;
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131494500;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25686);
    super.onCreate(paramBundle);
    this.dJq = getIntent().getStringExtra("IPCallAllRecordUI_phoneNumber");
    this.dLq = getIntent().getStringExtra("IPCallAllRecordUI_contactId");
    this.vbW = getIntent().getBooleanExtra("IPCallAllRecordUI_isSinglePhoneNumber", false);
    setMMTitle(2131760483);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(25680);
        IPCallAllRecordUI.this.finish();
        AppMethodBeat.o(25680);
        return true;
      }
    });
    this.vbV = ((ListView)findViewById(2131296645));
    this.vbV.setAdapter(new a(this));
    AppMethodBeat.o(25686);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends r<k>
  {
    public a(Context paramContext)
    {
      super(null);
      AppMethodBeat.i(25681);
      xs(true);
      AppMethodBeat.o(25681);
    }
    
    public final void ZD()
    {
      Object localObject2 = null;
      AppMethodBeat.i(25682);
      Object localObject1;
      if (!bu.isNullOrNil(IPCallAllRecordUI.a(IPCallAllRecordUI.this)))
      {
        Object localObject3 = IPCallAllRecordUI.a(IPCallAllRecordUI.this);
        localObject1 = localObject2;
        if (!bu.isNullOrNil((String)localObject3))
        {
          localObject3 = i.dgE().aoB((String)localObject3);
          localObject1 = localObject2;
          if (localObject3 != null)
          {
            localObject1 = localObject2;
            if (((com.tencent.mm.plugin.ipcall.model.h.c)localObject3).systemRowid != -1L)
            {
              long l = ((com.tencent.mm.plugin.ipcall.model.h.c)localObject3).systemRowid;
              localObject1 = i.dgF().yk(l);
            }
          }
        }
      }
      for (;;)
      {
        setCursor((Cursor)localObject1);
        AppMethodBeat.o(25682);
        return;
        localObject1 = localObject2;
        if (!bu.isNullOrNil(IPCallAllRecordUI.b(IPCallAllRecordUI.this))) {
          localObject1 = i.dgF().aoG(IPCallAllRecordUI.b(IPCallAllRecordUI.this));
        }
      }
    }
    
    public final void ZE()
    {
      AppMethodBeat.i(25683);
      dhl();
      ZD();
      AppMethodBeat.o(25683);
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(25684);
      View localView = paramView;
      if (paramView == null)
      {
        localView = IPCallAllRecordUI.this.getLayoutInflater().inflate(2131494513, paramViewGroup, false);
        paramView = new a();
        paramView.vbY = ((TextView)localView.findViewById(2131303486));
        paramView.vbZ = ((TextView)localView.findViewById(2131303488));
        paramView.fWX = ((TextView)localView.findViewById(2131303489));
        localView.setTag(paramView);
      }
      paramView = (k)getItem(paramInt);
      paramViewGroup = (a)localView.getTag();
      paramViewGroup.vbZ.setText(a.aph(paramView.field_phonenumber));
      if (paramView.field_duration > 0L) {
        paramViewGroup.fWX.setText(com.tencent.mm.plugin.ipcall.a.c.yp(paramView.field_duration));
      }
      for (;;)
      {
        paramViewGroup.vbY.setText(com.tencent.mm.plugin.ipcall.a.c.yl(paramView.field_calltime));
        AppMethodBeat.o(25684);
        return localView;
        paramViewGroup.fWX.setText(com.tencent.mm.plugin.ipcall.a.c.Jo(paramView.field_status));
      }
    }
    
    final class a
    {
      TextView fWX;
      TextView vbY;
      TextView vbZ;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallAllRecordUI
 * JD-Core Version:    0.7.0.1
 */