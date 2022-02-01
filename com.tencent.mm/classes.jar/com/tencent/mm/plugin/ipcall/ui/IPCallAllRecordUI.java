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
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.ipcall.a.a;
import com.tencent.mm.plugin.ipcall.model.h.d;
import com.tencent.mm.plugin.ipcall.model.h.k;
import com.tencent.mm.plugin.ipcall.model.h.l;
import com.tencent.mm.plugin.ipcall.model.i;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.v;

public class IPCallAllRecordUI
  extends MMActivity
{
  private boolean DUA = false;
  private ListView DUz;
  private String fVa;
  private String fXl;
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return R.i.ehL;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25686);
    super.onCreate(paramBundle);
    this.fVa = getIntent().getStringExtra("IPCallAllRecordUI_phoneNumber");
    this.fXl = getIntent().getStringExtra("IPCallAllRecordUI_contactId");
    this.DUA = getIntent().getBooleanExtra("IPCallAllRecordUI_isSinglePhoneNumber", false);
    setMMTitle(R.l.eJg);
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
    this.DUz = ((ListView)findViewById(R.h.dqQ));
    this.DUz.setAdapter(new a(this));
    AppMethodBeat.o(25686);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends v<k>
  {
    public a(Context paramContext)
    {
      super(null);
      AppMethodBeat.i(25681);
      Fx(true);
      AppMethodBeat.o(25681);
    }
    
    public final void atr()
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
          localObject3 = i.eJw().aMc((String)localObject3);
          localObject1 = localObject2;
          if (localObject3 != null)
          {
            localObject1 = localObject2;
            if (((com.tencent.mm.plugin.ipcall.model.h.c)localObject3).systemRowid != -1L)
            {
              long l = ((com.tencent.mm.plugin.ipcall.model.h.c)localObject3).systemRowid;
              localObject1 = i.eJx().Oi(l);
            }
          }
        }
      }
      for (;;)
      {
        v((Cursor)localObject1);
        AppMethodBeat.o(25682);
        return;
        localObject1 = localObject2;
        if (!Util.isNullOrNil(IPCallAllRecordUI.b(IPCallAllRecordUI.this))) {
          localObject1 = i.eJx().aMh(IPCallAllRecordUI.b(IPCallAllRecordUI.this));
        }
      }
    }
    
    public final void ats()
    {
      AppMethodBeat.i(25683);
      eKd();
      atr();
      AppMethodBeat.o(25683);
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(25684);
      View localView = paramView;
      if (paramView == null)
      {
        localView = IPCallAllRecordUI.this.getLayoutInflater().inflate(R.i.ehY, paramViewGroup, false);
        paramView = new a();
        paramView.DUC = ((TextView)localView.findViewById(R.h.dRx));
        paramView.DUD = ((TextView)localView.findViewById(R.h.dRz));
        paramView.jmj = ((TextView)localView.findViewById(R.h.dRA));
        localView.setTag(paramView);
      }
      paramView = (k)getItem(paramInt);
      paramViewGroup = (a)localView.getTag();
      paramViewGroup.DUD.setText(a.aMH(paramView.field_phonenumber));
      if (paramView.field_duration > 0L) {
        paramViewGroup.jmj.setText(com.tencent.mm.plugin.ipcall.a.c.On(paramView.field_duration));
      }
      for (;;)
      {
        paramViewGroup.DUC.setText(com.tencent.mm.plugin.ipcall.a.c.Oj(paramView.field_calltime));
        AppMethodBeat.o(25684);
        return localView;
        paramViewGroup.jmj.setText(com.tencent.mm.plugin.ipcall.a.c.VA(paramView.field_status));
      }
    }
    
    final class a
    {
      TextView DUC;
      TextView DUD;
      TextView jmj;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallAllRecordUI
 * JD-Core Version:    0.7.0.1
 */