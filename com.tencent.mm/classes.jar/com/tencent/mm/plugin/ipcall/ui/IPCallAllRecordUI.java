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
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.q;

public class IPCallAllRecordUI
  extends MMActivity
{
  private String dAc;
  private String dyq;
  private ListView sFP;
  private boolean sFQ = false;
  
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
    this.dyq = getIntent().getStringExtra("IPCallAllRecordUI_phoneNumber");
    this.dAc = getIntent().getStringExtra("IPCallAllRecordUI_contactId");
    this.sFQ = getIntent().getBooleanExtra("IPCallAllRecordUI_isSinglePhoneNumber", false);
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
    this.sFP = ((ListView)findViewById(2131296645));
    this.sFP.setAdapter(new a(this));
    AppMethodBeat.o(25686);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends q<k>
  {
    public a(Context paramContext)
    {
      super(null);
      AppMethodBeat.i(25681);
      vw(true);
      AppMethodBeat.o(25681);
    }
    
    public final void Wd()
    {
      Object localObject2 = null;
      AppMethodBeat.i(25682);
      Object localObject1;
      if (!bt.isNullOrNil(IPCallAllRecordUI.a(IPCallAllRecordUI.this)))
      {
        Object localObject3 = IPCallAllRecordUI.a(IPCallAllRecordUI.this);
        localObject1 = localObject2;
        if (!bt.isNullOrNil((String)localObject3))
        {
          localObject3 = i.cHq().adU((String)localObject3);
          localObject1 = localObject2;
          if (localObject3 != null)
          {
            localObject1 = localObject2;
            if (((com.tencent.mm.plugin.ipcall.model.h.c)localObject3).systemRowid != -1L)
            {
              long l = ((com.tencent.mm.plugin.ipcall.model.h.c)localObject3).systemRowid;
              localObject1 = i.cHr().rd(l);
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
        if (!bt.isNullOrNil(IPCallAllRecordUI.b(IPCallAllRecordUI.this))) {
          localObject1 = i.cHr().adZ(IPCallAllRecordUI.b(IPCallAllRecordUI.this));
        }
      }
    }
    
    public final void We()
    {
      AppMethodBeat.i(25683);
      cHX();
      Wd();
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
        paramView.sFS = ((TextView)localView.findViewById(2131303486));
        paramView.sFT = ((TextView)localView.findViewById(2131303488));
        paramView.fxX = ((TextView)localView.findViewById(2131303489));
        localView.setTag(paramView);
      }
      paramView = (k)getItem(paramInt);
      paramViewGroup = (a)localView.getTag();
      paramViewGroup.sFT.setText(a.aeA(paramView.field_phonenumber));
      if (paramView.field_duration > 0L) {
        paramViewGroup.fxX.setText(com.tencent.mm.plugin.ipcall.a.c.ri(paramView.field_duration));
      }
      for (;;)
      {
        paramViewGroup.sFS.setText(com.tencent.mm.plugin.ipcall.a.c.re(paramView.field_calltime));
        AppMethodBeat.o(25684);
        return localView;
        paramViewGroup.fxX.setText(com.tencent.mm.plugin.ipcall.a.c.Fz(paramView.field_status));
      }
    }
    
    final class a
    {
      TextView fxX;
      TextView sFS;
      TextView sFT;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallAllRecordUI
 * JD-Core Version:    0.7.0.1
 */