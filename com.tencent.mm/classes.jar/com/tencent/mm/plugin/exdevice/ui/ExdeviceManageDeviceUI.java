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
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.g.a.dz;
import com.tencent.mm.g.c.do;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.x;
import com.tencent.mm.protocal.protobuf.cat;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.tools.l;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;

public class ExdeviceManageDeviceUI
  extends MMActivity
{
  private ListView mListView;
  private a rIA;
  
  public int getLayoutId()
  {
    return 2131494029;
  }
  
  public void initView()
  {
    AppMethodBeat.i(24068);
    this.mListView = ((ListView)findViewById(2131303242));
    this.rIA = new a(this);
    View.inflate(this, 2131494015, null);
    this.mListView.setAdapter(this.rIA);
    AppMethodBeat.o(24068);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(24069);
    this.rIA.ad(ad.cKL().cLB());
    this.rIA.notifyDataSetChanged();
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
    setMMTitle(2131758853);
    paramBundle = new dz();
    paramBundle.dHd.dHe = true;
    EventCenter.instance.publish(paramBundle);
    initView();
    bg.azz().a(537, this.rIA);
    AppMethodBeat.o(24067);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(24070);
    super.onDestroy();
    bg.azz().b(537, this.rIA);
    AppMethodBeat.o(24070);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(24071);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0) && (this.rIA.rIC))
    {
      updateOptionMenuText(0, getString(2131755792));
      paramKeyEvent = this.rIA;
      if (paramKeyEvent.rIC)
      {
        paramKeyEvent.rIC = false;
        MMHandlerThread.postToMainThread(new ExdeviceManageDeviceUI.a.5(paramKeyEvent));
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
    implements i
  {
    private o.g pqy;
    private WeakReference<Context> pzq;
    private List<com.tencent.mm.plugin.exdevice.i.b> rFg;
    private com.tencent.mm.av.a.a.c rFu;
    boolean rIC;
    private View.OnClickListener rID;
    private l rIE;
    private volatile int rIF;
    private com.tencent.mm.ui.base.q tipDialog;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(24058);
      this.tipDialog = null;
      this.rIF = -1;
      this.pzq = new WeakReference(paramContext);
      this.rFg = new LinkedList();
      this.rIE = new l(paramContext);
      paramContext = new c.a();
      paramContext.jbq = 2131232204;
      this.rFu = paramContext.bdv();
      this.pqy = new o.g()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(24053);
          paramAnonymousInt = paramAnonymousMenuItem.getItemId();
          int i = ExdeviceManageDeviceUI.a.this.getCount();
          Log.d("MicroMsg.ExdeviceManageDeviceUI", "onMenuItemSelected, itemId(%d), count(%d).", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(i) });
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
      this.rID = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(24054);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceManageDeviceUI$DeviceAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
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
          paramAnonymousView = ExdeviceManageDeviceUI.a.this.GH(i);
          localObject = (Context)ExdeviceManageDeviceUI.a.c(ExdeviceManageDeviceUI.a.this).get();
          if (localObject == null)
          {
            Log.e("MicroMsg.ExdeviceManageDeviceUI", "Start activity failed, context is null.");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceManageDeviceUI$DeviceAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(24054);
            return;
          }
          ExdeviceManageDeviceUI.a.a((Context)localObject, paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceManageDeviceUI$DeviceAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(24054);
        }
      };
      ad(ad.cKL().cLB());
      AppMethodBeat.o(24058);
    }
    
    public final com.tencent.mm.plugin.exdevice.i.b GH(int paramInt)
    {
      AppMethodBeat.i(24061);
      com.tencent.mm.plugin.exdevice.i.b localb = (com.tencent.mm.plugin.exdevice.i.b)this.rFg.get(paramInt);
      AppMethodBeat.o(24061);
      return localb;
    }
    
    public final void ad(List<com.tencent.mm.plugin.exdevice.i.b> paramList)
    {
      AppMethodBeat.i(24059);
      this.rFg.clear();
      if ((paramList == null) || (paramList.size() == 0))
      {
        AppMethodBeat.o(24059);
        return;
      }
      this.rFg.addAll(paramList);
      AppMethodBeat.o(24059);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(24060);
      int i = this.rFg.size();
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
      com.tencent.mm.plugin.exdevice.i.b localb = GH(paramInt);
      View localView;
      if (paramView == null)
      {
        paramView = new a((byte)0);
        localView = View.inflate(paramViewGroup.getContext(), 2131494028, null);
        paramView.rII = localView.findViewById(2131299174);
        paramView.kgE = ((TextView)localView.findViewById(2131305210));
        paramView.rIJ = localView.findViewById(2131299477);
        paramView.nnL = ((ImageView)localView.findViewById(2131302475));
        localView.setTag(paramView);
        paramViewGroup = paramView;
      }
      while (localb == null)
      {
        paramView = "";
        Log.d("MicroMsg.ExdeviceManageDeviceUI", "position(%s), name(%s), mac(%s).", new Object[] { Integer.valueOf(paramInt), paramView, Long.valueOf(localb.field_mac) });
        paramViewGroup.kgE.setText(paramView);
        com.tencent.mm.av.q.bcV().a(localb.iconUrl, paramViewGroup.nnL, this.rFu);
        paramViewGroup.rIJ.setTag(Integer.valueOf(paramInt));
        if (!this.rIC) {
          break label329;
        }
        paramViewGroup.rIJ.setVisibility(0);
        label197:
        paramViewGroup.rII.setTag(Integer.valueOf(paramInt));
        paramViewGroup.rII.setOnClickListener(this.rID);
        AppMethodBeat.o(24062);
        return localView;
        paramViewGroup = (a)paramView.getTag();
        localView = paramView;
      }
      if (!Util.isNullOrNil(localb.fMb)) {
        paramView = localb.fMb;
      }
      for (;;)
      {
        paramView = Util.nullAsNil(paramView);
        break;
        if (!Util.isNullOrNil(localb.fMc))
        {
          paramView = localb.fMc;
        }
        else if (localb.field_mac != 0L)
        {
          paramView = com.tencent.mm.plugin.exdevice.k.b.Dj(localb.field_mac);
        }
        else
        {
          if (!Util.isNullOrNil(localb.field_deviceID))
          {
            paramView = localb.field_deviceID;
            continue;
            label329:
            paramViewGroup.rIJ.setVisibility(8);
            break label197;
          }
          paramView = null;
        }
      }
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
    {
      AppMethodBeat.i(24063);
      if (paramq == null)
      {
        Log.e("MicroMsg.ExdeviceManageDeviceUI", "scene is null.");
        AppMethodBeat.o(24063);
        return;
      }
      if ((paramq instanceof x))
      {
        if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
          this.tipDialog.dismiss();
        }
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          if ((this.rIF < 0) || (this.rIF >= this.rFg.size()))
          {
            AppMethodBeat.o(24063);
            return;
          }
          MMHandlerThread.postToMainThread(new Runnable()
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
      TextView kgE;
      ImageView nnL;
      View rII;
      View rIJ;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceManageDeviceUI
 * JD-Core Version:    0.7.0.1
 */