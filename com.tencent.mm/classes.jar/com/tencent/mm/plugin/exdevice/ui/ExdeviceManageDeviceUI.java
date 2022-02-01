package com.tencent.mm.plugin.exdevice.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.aw.o;
import com.tencent.mm.g.a.dr;
import com.tencent.mm.g.c.cw;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.exdevice.model.x;
import com.tencent.mm.protocal.protobuf.bfj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.tools.l;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;

public class ExdeviceManageDeviceUI
  extends MMActivity
{
  private ListView mListView;
  private a pdK;
  
  public int getLayoutId()
  {
    return 2131493871;
  }
  
  public void initView()
  {
    AppMethodBeat.i(24068);
    this.mListView = ((ListView)findViewById(2131301457));
    this.pdK = new a(this);
    View.inflate(this, 2131493859, null);
    this.mListView.setAdapter(this.pdK);
    AppMethodBeat.o(24068);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(24069);
    this.pdK.ad(com.tencent.mm.plugin.exdevice.model.ad.bZG().cal());
    this.pdK.notifyDataSetChanged();
    AppMethodBeat.o(24069);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(24067);
    super.onCreate(paramBundle);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(24052);
        ExdeviceManageDeviceUI.this.finish();
        AppMethodBeat.o(24052);
        return true;
      }
    });
    setMMTitle(2131758553);
    paramBundle = new dr();
    paramBundle.dfU.dfV = true;
    com.tencent.mm.sdk.b.a.ESL.l(paramBundle);
    initView();
    az.aeS().a(537, this.pdK);
    AppMethodBeat.o(24067);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(24070);
    super.onDestroy();
    az.aeS().b(537, this.pdK);
    AppMethodBeat.o(24070);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(24071);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0) && (this.pdK.pdM))
    {
      updateOptionMenuText(0, getString(2131755721));
      paramKeyEvent = this.pdK;
      if (paramKeyEvent.pdM)
      {
        paramKeyEvent.pdM = false;
        aq.f(new ExdeviceManageDeviceUI.a.5(paramKeyEvent));
      }
      AppMethodBeat.o(24071);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(24071);
    return bool;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
    extends BaseAdapter
    implements g
  {
    private n.d mVU;
    private WeakReference<Context> nbA;
    private List<com.tencent.mm.plugin.exdevice.i.b> paE;
    private com.tencent.mm.aw.a.a.c paS;
    boolean pdM;
    private View.OnClickListener pdN;
    private l pdO;
    private volatile int pdP;
    private p tipDialog;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(24058);
      this.tipDialog = null;
      this.pdP = -1;
      this.nbA = new WeakReference(paramContext);
      this.paE = new LinkedList();
      this.pdO = new l(paramContext);
      paramContext = new c.a();
      paramContext.hkf = 2131232108;
      this.paS = paramContext.azc();
      this.mVU = new n.d()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(24053);
          paramAnonymousInt = paramAnonymousMenuItem.getItemId();
          int i = ExdeviceManageDeviceUI.a.this.getCount();
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ExdeviceManageDeviceUI", "onMenuItemSelected, itemId(%d), count(%d).", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(i) });
          if ((paramAnonymousInt < 0) || (paramAnonymousInt >= i))
          {
            AppMethodBeat.o(24053);
            return;
          }
          ExdeviceManageDeviceUI.a.a(ExdeviceManageDeviceUI.a.this, paramAnonymousInt);
          ExdeviceManageDeviceUI.a.a(ExdeviceManageDeviceUI.a.this, (com.tencent.mm.plugin.exdevice.i.b)ExdeviceManageDeviceUI.a.a(ExdeviceManageDeviceUI.a.this).get(paramAnonymousInt));
          ExdeviceManageDeviceUI.a.this.notifyDataSetChanged();
          AppMethodBeat.o(24053);
        }
      };
      this.pdN = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(24054);
          if (ExdeviceManageDeviceUI.a.b(ExdeviceManageDeviceUI.a.this))
          {
            AppMethodBeat.o(24054);
            return;
          }
          paramAnonymousView = paramAnonymousView.getTag();
          if ((paramAnonymousView == null) || (!(paramAnonymousView instanceof Integer)))
          {
            AppMethodBeat.o(24054);
            return;
          }
          int i = ((Integer)paramAnonymousView).intValue();
          if ((i < 0) || (i >= ExdeviceManageDeviceUI.a.this.getCount()))
          {
            AppMethodBeat.o(24054);
            return;
          }
          paramAnonymousView = ExdeviceManageDeviceUI.a.this.Bj(i);
          Context localContext = (Context)ExdeviceManageDeviceUI.a.c(ExdeviceManageDeviceUI.a.this).get();
          if (localContext == null)
          {
            com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.ExdeviceManageDeviceUI", "Start activity failed, context is null.");
            AppMethodBeat.o(24054);
            return;
          }
          ExdeviceManageDeviceUI.a.a(localContext, paramAnonymousView);
          AppMethodBeat.o(24054);
        }
      };
      ad(com.tencent.mm.plugin.exdevice.model.ad.bZG().cal());
      AppMethodBeat.o(24058);
    }
    
    public final com.tencent.mm.plugin.exdevice.i.b Bj(int paramInt)
    {
      AppMethodBeat.i(24061);
      com.tencent.mm.plugin.exdevice.i.b localb = (com.tencent.mm.plugin.exdevice.i.b)this.paE.get(paramInt);
      AppMethodBeat.o(24061);
      return localb;
    }
    
    public final void ad(List<com.tencent.mm.plugin.exdevice.i.b> paramList)
    {
      AppMethodBeat.i(24059);
      this.paE.clear();
      if ((paramList == null) || (paramList.size() == 0))
      {
        AppMethodBeat.o(24059);
        return;
      }
      this.paE.addAll(paramList);
      AppMethodBeat.o(24059);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(24060);
      int i = this.paE.size();
      AppMethodBeat.o(24060);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(24062);
      com.tencent.mm.plugin.exdevice.i.b localb = Bj(paramInt);
      View localView;
      if (paramView == null)
      {
        paramView = new a((byte)0);
        localView = View.inflate(paramViewGroup.getContext(), 2131493870, null);
        paramView.pdS = localView.findViewById(2131298736);
        paramView.imt = ((TextView)localView.findViewById(2131302656));
        paramView.pdT = localView.findViewById(2131298983);
        paramView.kXS = ((ImageView)localView.findViewById(2131300880));
        localView.setTag(paramView);
        paramViewGroup = paramView;
      }
      while (localb == null)
      {
        paramView = "";
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ExdeviceManageDeviceUI", "position(%s), name(%s), mac(%s).", new Object[] { Integer.valueOf(paramInt), paramView, Long.valueOf(localb.field_mac) });
        paramViewGroup.imt.setText(paramView);
        o.ayJ().a(localb.iconUrl, paramViewGroup.kXS, this.paS);
        paramViewGroup.pdT.setTag(Integer.valueOf(paramInt));
        if (!this.pdM) {
          break label329;
        }
        paramViewGroup.pdT.setVisibility(0);
        label197:
        paramViewGroup.pdS.setTag(Integer.valueOf(paramInt));
        paramViewGroup.pdS.setOnClickListener(this.pdN);
        AppMethodBeat.o(24062);
        return localView;
        paramViewGroup = (a)paramView.getTag();
        localView = paramView;
      }
      if (!bt.isNullOrNil(localb.eKn)) {
        paramView = localb.eKn;
      }
      for (;;)
      {
        paramView = bt.nullAsNil(paramView);
        break;
        if (!bt.isNullOrNil(localb.eKo))
        {
          paramView = localb.eKo;
        }
        else if (localb.field_mac != 0L)
        {
          paramView = com.tencent.mm.plugin.exdevice.k.b.pe(localb.field_mac);
        }
        else
        {
          if (!bt.isNullOrNil(localb.field_deviceID))
          {
            paramView = localb.field_deviceID;
            continue;
            label329:
            paramViewGroup.pdT.setVisibility(8);
            break label197;
          }
          paramView = null;
        }
      }
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(24063);
      if (paramn == null)
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.ExdeviceManageDeviceUI", "scene is null.");
        AppMethodBeat.o(24063);
        return;
      }
      if ((paramn instanceof x))
      {
        if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
          this.tipDialog.dismiss();
        }
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          if ((this.pdP < 0) || (this.pdP >= this.paE.size()))
          {
            AppMethodBeat.o(24063);
            return;
          }
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(24057);
              ExdeviceManageDeviceUI.a.a(ExdeviceManageDeviceUI.a.this).remove(ExdeviceManageDeviceUI.a.d(ExdeviceManageDeviceUI.a.this));
              ExdeviceManageDeviceUI.a.this.notifyDataSetChanged();
              ExdeviceManageDeviceUI.a.a(ExdeviceManageDeviceUI.a.this, -1);
              AppMethodBeat.o(24057);
            }
          });
        }
      }
      AppMethodBeat.o(24063);
    }
    
    static final class a
    {
      TextView imt;
      ImageView kXS;
      View pdS;
      View pdT;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceManageDeviceUI
 * JD-Core Version:    0.7.0.1
 */