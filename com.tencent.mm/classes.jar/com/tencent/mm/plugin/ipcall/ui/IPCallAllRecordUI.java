package com.tencent.mm.plugin.ipcall.ui;

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
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.ipcall.a.a;
import com.tencent.mm.plugin.ipcall.model.h;
import com.tencent.mm.plugin.ipcall.model.h.d;
import com.tencent.mm.plugin.ipcall.model.h.k;
import com.tencent.mm.plugin.ipcall.model.h.l;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.x;

public class IPCallAllRecordUI
  extends MMActivity
{
  private ListView JLJ;
  private boolean JLK = false;
  private String iaX;
  private String idl;
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return R.i.gkG;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25686);
    super.onCreate(paramBundle);
    this.iaX = getIntent().getStringExtra("IPCallAllRecordUI_phoneNumber");
    this.idl = getIntent().getStringExtra("IPCallAllRecordUI_contactId");
    this.JLK = getIntent().getBooleanExtra("IPCallAllRecordUI_isSinglePhoneNumber", false);
    setMMTitle(R.l.gKN);
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
    this.JLJ = ((ListView)findViewById(R.h.fre));
    this.JLJ.setAdapter(new a(this));
    AppMethodBeat.o(25686);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends x<k>
  {
    public a(Context paramContext)
    {
      super(null);
      AppMethodBeat.i(25681);
      Lh(true);
      AppMethodBeat.o(25681);
    }
    
    public final void aNy()
    {
      Object localObject2 = null;
      AppMethodBeat.i(25682);
      Object localObject1;
      if (!Util.isNullOrNil(IPCallAllRecordUI.a(IPCallAllRecordUI.this)))
      {
        Object localObject3 = IPCallAllRecordUI.a(IPCallAllRecordUI.this);
        localObject1 = localObject2;
        if (!Util.isNullOrNil((String)localObject3))
        {
          localObject3 = h.fRw().aIW((String)localObject3);
          localObject1 = localObject2;
          if (localObject3 != null)
          {
            localObject1 = localObject2;
            if (((com.tencent.mm.plugin.ipcall.model.h.c)localObject3).systemRowid != -1L)
            {
              long l = ((com.tencent.mm.plugin.ipcall.model.h.c)localObject3).systemRowid;
              localObject1 = h.fRx().sd(l);
            }
          }
        }
      }
      for (;;)
      {
        w((Cursor)localObject1);
        AppMethodBeat.o(25682);
        return;
        localObject1 = localObject2;
        if (!Util.isNullOrNil(IPCallAllRecordUI.b(IPCallAllRecordUI.this))) {
          localObject1 = h.fRx().aJb(IPCallAllRecordUI.b(IPCallAllRecordUI.this));
        }
      }
    }
    
    public final void aNz()
    {
      AppMethodBeat.i(25683);
      fSd();
      aNy();
      AppMethodBeat.o(25683);
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(25684);
      View localView = paramView;
      if (paramView == null)
      {
        localView = IPCallAllRecordUI.this.getLayoutInflater().inflate(R.i.gkT, paramViewGroup, false);
        paramView = new a();
        paramView.JLM = ((TextView)localView.findViewById(R.h.fTz));
        paramView.JLN = ((TextView)localView.findViewById(R.h.fTB));
        paramView.lPf = ((TextView)localView.findViewById(R.h.fTC));
        localView.setTag(paramView);
      }
      paramView = (k)getItem(paramInt);
      paramViewGroup = (a)localView.getTag();
      paramViewGroup.JLN.setText(a.aJB(paramView.field_phonenumber));
      if (paramView.field_duration > 0L) {
        paramViewGroup.lPf.setText(com.tencent.mm.plugin.ipcall.a.c.si(paramView.field_duration));
      }
      for (;;)
      {
        paramViewGroup.JLM.setText(com.tencent.mm.plugin.ipcall.a.c.se(paramView.field_calltime));
        AppMethodBeat.o(25684);
        return localView;
        paramViewGroup.lPf.setText(com.tencent.mm.plugin.ipcall.a.c.Zv(paramView.field_status));
      }
    }
    
    final class a
    {
      TextView JLM;
      TextView JLN;
      TextView lPf;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallAllRecordUI
 * JD-Core Version:    0.7.0.1
 */