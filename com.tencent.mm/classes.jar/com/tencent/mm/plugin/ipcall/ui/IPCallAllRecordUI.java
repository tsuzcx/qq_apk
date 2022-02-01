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
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

public class IPCallAllRecordUI
  extends MMActivity
{
  private String ebd;
  private String edf;
  private ListView yuv;
  private boolean yuw = false;
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131495092;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25686);
    super.onCreate(paramBundle);
    this.ebd = getIntent().getStringExtra("IPCallAllRecordUI_phoneNumber");
    this.edf = getIntent().getStringExtra("IPCallAllRecordUI_contactId");
    this.yuw = getIntent().getBooleanExtra("IPCallAllRecordUI_isSinglePhoneNumber", false);
    setMMTitle(2131761928);
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
    this.yuv = ((ListView)findViewById(2131296722));
    this.yuv.setAdapter(new a(this));
    AppMethodBeat.o(25686);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends s<k>
  {
    public a(Context paramContext)
    {
      super(null);
      AppMethodBeat.i(25681);
      Bh(true);
      AppMethodBeat.o(25681);
    }
    
    public final void anp()
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
          localObject3 = i.eay().aBV((String)localObject3);
          localObject1 = localObject2;
          if (localObject3 != null)
          {
            localObject1 = localObject2;
            if (((com.tencent.mm.plugin.ipcall.model.h.c)localObject3).systemRowid != -1L)
            {
              long l = ((com.tencent.mm.plugin.ipcall.model.h.c)localObject3).systemRowid;
              localObject1 = i.eaz().GT(l);
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
        if (!Util.isNullOrNil(IPCallAllRecordUI.b(IPCallAllRecordUI.this))) {
          localObject1 = i.eaz().aCa(IPCallAllRecordUI.b(IPCallAllRecordUI.this));
        }
      }
    }
    
    public final void anq()
    {
      AppMethodBeat.i(25683);
      ebf();
      anp();
      AppMethodBeat.o(25683);
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(25684);
      View localView = paramView;
      if (paramView == null)
      {
        localView = IPCallAllRecordUI.this.getLayoutInflater().inflate(2131495105, paramViewGroup, false);
        paramView = new a();
        paramView.yuy = ((TextView)localView.findViewById(2131306244));
        paramView.yuz = ((TextView)localView.findViewById(2131306246));
        paramView.gCd = ((TextView)localView.findViewById(2131306247));
        localView.setTag(paramView);
      }
      paramView = (k)getItem(paramInt);
      paramViewGroup = (a)localView.getTag();
      paramViewGroup.yuz.setText(a.aCA(paramView.field_phonenumber));
      if (paramView.field_duration > 0L) {
        paramViewGroup.gCd.setText(com.tencent.mm.plugin.ipcall.a.c.GY(paramView.field_duration));
      }
      for (;;)
      {
        paramViewGroup.yuy.setText(com.tencent.mm.plugin.ipcall.a.c.GU(paramView.field_calltime));
        AppMethodBeat.o(25684);
        return localView;
        paramViewGroup.gCd.setText(com.tencent.mm.plugin.ipcall.a.c.Pr(paramView.field_status));
      }
    }
    
    final class a
    {
      TextView gCd;
      TextView yuy;
      TextView yuz;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallAllRecordUI
 * JD-Core Version:    0.7.0.1
 */