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
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.g.a.dw;
import com.tencent.mm.g.c.di;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.x;
import com.tencent.mm.protocal.protobuf.bob;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
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
  private a qrf;
  
  public int getLayoutId()
  {
    return 2131493871;
  }
  
  public void initView()
  {
    AppMethodBeat.i(24068);
    this.mListView = ((ListView)findViewById(2131301457));
    this.qrf = new a(this);
    View.inflate(this, 2131493859, null);
    this.mListView.setAdapter(this.qrf);
    AppMethodBeat.o(24068);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(24069);
    this.qrf.V(ad.cmJ().cno());
    this.qrf.notifyDataSetChanged();
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
    paramBundle = new dw();
    paramBundle.dpQ.dpR = true;
    com.tencent.mm.sdk.b.a.IvT.l(paramBundle);
    initView();
    bc.ajj().a(537, this.qrf);
    AppMethodBeat.o(24067);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(24070);
    super.onDestroy();
    bc.ajj().b(537, this.qrf);
    AppMethodBeat.o(24070);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(24071);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0) && (this.qrf.qrh))
    {
      updateOptionMenuText(0, getString(2131755721));
      paramKeyEvent = this.qrf;
      if (paramKeyEvent.qrh)
      {
        paramKeyEvent.qrh = false;
        ar.f(new ExdeviceManageDeviceUI.a.5(paramKeyEvent));
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
    private n.e ofB;
    private WeakReference<Context> omE;
    private List<com.tencent.mm.plugin.exdevice.i.b> qnZ;
    private com.tencent.mm.av.a.a.c qon;
    boolean qrh;
    private View.OnClickListener qri;
    private l qrj;
    private volatile int qrk;
    private p tipDialog;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(24058);
      this.tipDialog = null;
      this.qrk = -1;
      this.omE = new WeakReference(paramContext);
      this.qnZ = new LinkedList();
      this.qrj = new l(paramContext);
      paramContext = new c.a();
      paramContext.igv = 2131232108;
      this.qon = paramContext.aJu();
      this.ofB = new n.e()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(24053);
          paramAnonymousInt = paramAnonymousMenuItem.getItemId();
          int i = ExdeviceManageDeviceUI.a.this.getCount();
          ae.d("MicroMsg.ExdeviceManageDeviceUI", "onMenuItemSelected, itemId(%d), count(%d).", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(i) });
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
      this.qri = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(24054);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceManageDeviceUI$DeviceAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
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
          paramAnonymousView = ExdeviceManageDeviceUI.a.this.CW(i);
          localObject = (Context)ExdeviceManageDeviceUI.a.c(ExdeviceManageDeviceUI.a.this).get();
          if (localObject == null)
          {
            ae.e("MicroMsg.ExdeviceManageDeviceUI", "Start activity failed, context is null.");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceManageDeviceUI$DeviceAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(24054);
            return;
          }
          ExdeviceManageDeviceUI.a.a((Context)localObject, paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceManageDeviceUI$DeviceAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(24054);
        }
      };
      V(ad.cmJ().cno());
      AppMethodBeat.o(24058);
    }
    
    public final com.tencent.mm.plugin.exdevice.i.b CW(int paramInt)
    {
      AppMethodBeat.i(24061);
      com.tencent.mm.plugin.exdevice.i.b localb = (com.tencent.mm.plugin.exdevice.i.b)this.qnZ.get(paramInt);
      AppMethodBeat.o(24061);
      return localb;
    }
    
    public final void V(List<com.tencent.mm.plugin.exdevice.i.b> paramList)
    {
      AppMethodBeat.i(24059);
      this.qnZ.clear();
      if ((paramList == null) || (paramList.size() == 0))
      {
        AppMethodBeat.o(24059);
        return;
      }
      this.qnZ.addAll(paramList);
      AppMethodBeat.o(24059);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(24060);
      int i = this.qnZ.size();
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
      com.tencent.mm.plugin.exdevice.i.b localb = CW(paramInt);
      View localView;
      if (paramView == null)
      {
        paramView = new a((byte)0);
        localView = View.inflate(paramViewGroup.getContext(), 2131493870, null);
        paramView.qrn = localView.findViewById(2131298736);
        paramView.jiC = ((TextView)localView.findViewById(2131302656));
        paramView.qro = localView.findViewById(2131298983);
        paramView.mdt = ((ImageView)localView.findViewById(2131300880));
        localView.setTag(paramView);
        paramViewGroup = paramView;
      }
      while (localb == null)
      {
        paramView = "";
        ae.d("MicroMsg.ExdeviceManageDeviceUI", "position(%s), name(%s), mac(%s).", new Object[] { Integer.valueOf(paramInt), paramView, Long.valueOf(localb.field_mac) });
        paramViewGroup.jiC.setText(paramView);
        com.tencent.mm.av.q.aJb().a(localb.iconUrl, paramViewGroup.mdt, this.qon);
        paramViewGroup.qro.setTag(Integer.valueOf(paramInt));
        if (!this.qrh) {
          break label329;
        }
        paramViewGroup.qro.setVisibility(0);
        label197:
        paramViewGroup.qrn.setTag(Integer.valueOf(paramInt));
        paramViewGroup.qrn.setOnClickListener(this.qri);
        AppMethodBeat.o(24062);
        return localView;
        paramViewGroup = (a)paramView.getTag();
        localView = paramView;
      }
      if (!bu.isNullOrNil(localb.fhy)) {
        paramView = localb.fhy;
      }
      for (;;)
      {
        paramView = bu.nullAsNil(paramView);
        break;
        if (!bu.isNullOrNil(localb.fhz))
        {
          paramView = localb.fhz;
        }
        else if (localb.field_mac != 0L)
        {
          paramView = com.tencent.mm.plugin.exdevice.k.b.vf(localb.field_mac);
        }
        else
        {
          if (!bu.isNullOrNil(localb.field_deviceID))
          {
            paramView = localb.field_deviceID;
            continue;
            label329:
            paramViewGroup.qro.setVisibility(8);
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
        ae.e("MicroMsg.ExdeviceManageDeviceUI", "scene is null.");
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
          if ((this.qrk < 0) || (this.qrk >= this.qnZ.size()))
          {
            AppMethodBeat.o(24063);
            return;
          }
          ar.f(new Runnable()
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
      TextView jiC;
      ImageView mdt;
      View qrn;
      View qro;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceManageDeviceUI
 * JD-Core Version:    0.7.0.1
 */