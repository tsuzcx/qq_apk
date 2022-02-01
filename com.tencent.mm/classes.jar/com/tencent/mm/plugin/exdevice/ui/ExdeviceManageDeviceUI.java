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
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.g.a.dv;
import com.tencent.mm.g.c.di;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.exdevice.model.x;
import com.tencent.mm.protocal.protobuf.bnj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.tools.l;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;

public class ExdeviceManageDeviceUI
  extends MMActivity
{
  private ListView mListView;
  private a qkA;
  
  public int getLayoutId()
  {
    return 2131493871;
  }
  
  public void initView()
  {
    AppMethodBeat.i(24068);
    this.mListView = ((ListView)findViewById(2131301457));
    this.qkA = new a(this);
    View.inflate(this, 2131493859, null);
    this.mListView.setAdapter(this.qkA);
    AppMethodBeat.o(24068);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(24069);
    this.qkA.V(com.tencent.mm.plugin.exdevice.model.ad.clt().clY());
    this.qkA.notifyDataSetChanged();
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
    paramBundle = new dv();
    paramBundle.doL.doM = true;
    com.tencent.mm.sdk.b.a.IbL.l(paramBundle);
    initView();
    ba.aiU().a(537, this.qkA);
    AppMethodBeat.o(24067);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(24070);
    super.onDestroy();
    ba.aiU().b(537, this.qkA);
    AppMethodBeat.o(24070);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(24071);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0) && (this.qkA.qkC))
    {
      updateOptionMenuText(0, getString(2131755721));
      paramKeyEvent = this.qkA;
      if (paramKeyEvent.qkC)
      {
        paramKeyEvent.qkC = false;
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
    implements f
  {
    private n.e nZR;
    private WeakReference<Context> ogF;
    private com.tencent.mm.aw.a.a.c qhI;
    private List<com.tencent.mm.plugin.exdevice.i.b> qhu;
    boolean qkC;
    private View.OnClickListener qkD;
    private l qkE;
    private volatile int qkF;
    private p tipDialog;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(24058);
      this.tipDialog = null;
      this.qkF = -1;
      this.ogF = new WeakReference(paramContext);
      this.qhu = new LinkedList();
      this.qkE = new l(paramContext);
      paramContext = new c.a();
      paramContext.idD = 2131232108;
      this.qhI = paramContext.aJc();
      this.nZR = new n.e()
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
      this.qkD = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(24054);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceManageDeviceUI$DeviceAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          if (ExdeviceManageDeviceUI.a.b(ExdeviceManageDeviceUI.a.this))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceManageDeviceUI$DeviceAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(24054);
            return;
          }
          paramAnonymousView = paramAnonymousView.getTag();
          if ((paramAnonymousView == null) || (!(paramAnonymousView instanceof Integer)))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceManageDeviceUI$DeviceAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(24054);
            return;
          }
          int i = ((Integer)paramAnonymousView).intValue();
          if ((i < 0) || (i >= ExdeviceManageDeviceUI.a.this.getCount()))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceManageDeviceUI$DeviceAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(24054);
            return;
          }
          paramAnonymousView = ExdeviceManageDeviceUI.a.this.CK(i);
          localObject = (Context)ExdeviceManageDeviceUI.a.c(ExdeviceManageDeviceUI.a.this).get();
          if (localObject == null)
          {
            com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.ExdeviceManageDeviceUI", "Start activity failed, context is null.");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceManageDeviceUI$DeviceAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(24054);
            return;
          }
          ExdeviceManageDeviceUI.a.a((Context)localObject, paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceManageDeviceUI$DeviceAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(24054);
        }
      };
      V(com.tencent.mm.plugin.exdevice.model.ad.clt().clY());
      AppMethodBeat.o(24058);
    }
    
    public final com.tencent.mm.plugin.exdevice.i.b CK(int paramInt)
    {
      AppMethodBeat.i(24061);
      com.tencent.mm.plugin.exdevice.i.b localb = (com.tencent.mm.plugin.exdevice.i.b)this.qhu.get(paramInt);
      AppMethodBeat.o(24061);
      return localb;
    }
    
    public final void V(List<com.tencent.mm.plugin.exdevice.i.b> paramList)
    {
      AppMethodBeat.i(24059);
      this.qhu.clear();
      if ((paramList == null) || (paramList.size() == 0))
      {
        AppMethodBeat.o(24059);
        return;
      }
      this.qhu.addAll(paramList);
      AppMethodBeat.o(24059);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(24060);
      int i = this.qhu.size();
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
      com.tencent.mm.plugin.exdevice.i.b localb = CK(paramInt);
      View localView;
      if (paramView == null)
      {
        paramView = new a((byte)0);
        localView = View.inflate(paramViewGroup.getContext(), 2131493870, null);
        paramView.qkI = localView.findViewById(2131298736);
        paramView.jfJ = ((TextView)localView.findViewById(2131302656));
        paramView.qkJ = localView.findViewById(2131298983);
        paramView.lZa = ((ImageView)localView.findViewById(2131300880));
        localView.setTag(paramView);
        paramViewGroup = paramView;
      }
      while (localb == null)
      {
        paramView = "";
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ExdeviceManageDeviceUI", "position(%s), name(%s), mac(%s).", new Object[] { Integer.valueOf(paramInt), paramView, Long.valueOf(localb.field_mac) });
        paramViewGroup.jfJ.setText(paramView);
        com.tencent.mm.aw.q.aIJ().a(localb.iconUrl, paramViewGroup.lZa, this.qhI);
        paramViewGroup.qkJ.setTag(Integer.valueOf(paramInt));
        if (!this.qkC) {
          break label329;
        }
        paramViewGroup.qkJ.setVisibility(0);
        label197:
        paramViewGroup.qkI.setTag(Integer.valueOf(paramInt));
        paramViewGroup.qkI.setOnClickListener(this.qkD);
        AppMethodBeat.o(24062);
        return localView;
        paramViewGroup = (a)paramView.getTag();
        localView = paramView;
      }
      if (!bt.isNullOrNil(localb.ffB)) {
        paramView = localb.ffB;
      }
      for (;;)
      {
        paramView = bt.nullAsNil(paramView);
        break;
        if (!bt.isNullOrNil(localb.ffC))
        {
          paramView = localb.ffC;
        }
        else if (localb.field_mac != 0L)
        {
          paramView = com.tencent.mm.plugin.exdevice.k.b.uO(localb.field_mac);
        }
        else
        {
          if (!bt.isNullOrNil(localb.field_deviceID))
          {
            paramView = localb.field_deviceID;
            continue;
            label329:
            paramViewGroup.qkJ.setVisibility(8);
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
          if ((this.qkF < 0) || (this.qkF >= this.qhu.size()))
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
      TextView jfJ;
      ImageView lZa;
      View qkI;
      View qkJ;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceManageDeviceUI
 * JD-Core Version:    0.7.0.1
 */