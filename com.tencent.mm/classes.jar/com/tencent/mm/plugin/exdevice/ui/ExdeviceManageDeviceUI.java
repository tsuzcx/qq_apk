package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.eq;
import com.tencent.mm.autogen.b.ee;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.exdevice.model.ab;
import com.tencent.mm.plugin.exdevice.model.ah;
import com.tencent.mm.protocal.protobuf.cyx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.tools.l;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;

public class ExdeviceManageDeviceUI
  extends MMActivity
{
  private ListView mListView;
  private a yAE;
  
  public int getLayoutId()
  {
    return R.i.gjs;
  }
  
  public void initView()
  {
    AppMethodBeat.i(24068);
    this.mListView = ((ListView)findViewById(R.h.listview));
    this.yAE = new a(this);
    View.inflate(this, R.i.gjg, null);
    this.mListView.setAdapter(this.yAE);
    AppMethodBeat.o(24068);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(24069);
    this.yAE.bz(ah.dFO().dGH());
    this.yAE.notifyDataSetChanged();
    AppMethodBeat.o(24069);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(24067);
    super.onCreate(paramBundle);
    setBackBtn(new ExdeviceManageDeviceUI.1(this));
    setMMTitle(R.l.gGt);
    paramBundle = new eq();
    paramBundle.hEF.hEG = true;
    paramBundle.publish();
    initView();
    bh.aZW().a(537, this.yAE);
    AppMethodBeat.o(24067);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(24070);
    super.onDestroy();
    bh.aZW().b(537, this.yAE);
    AppMethodBeat.o(24070);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(24071);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0) && (this.yAE.yAG))
    {
      updateOptionMenuText(0, getString(R.l.app_edit));
      paramKeyEvent = this.yAE;
      if (paramKeyEvent.yAG)
      {
        paramKeyEvent.yAG = false;
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
    implements h
  {
    private w tipDialog;
    private u.i vFd;
    private WeakReference<Context> vPu;
    boolean yAG;
    private View.OnClickListener yAH;
    private l yAI;
    private volatile int yAJ;
    private com.tencent.mm.modelimage.loader.a.c yxG;
    private List<com.tencent.mm.plugin.exdevice.i.b> yxt;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(24058);
      this.tipDialog = null;
      this.yAJ = -1;
      this.vPu = new WeakReference(paramContext);
      this.yxt = new LinkedList();
      this.yAI = new l(paramContext);
      paramContext = new c.a();
      paramContext.oKB = R.g.fnH;
      this.yxG = paramContext.bKx();
      this.vFd = new u.i()
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
      this.yAH = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(24054);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/exdevice/ui/ExdeviceManageDeviceUI$DeviceAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
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
          paramAnonymousView = ExdeviceManageDeviceUI.a.this.Lo(i);
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
      bz(ah.dFO().dGH());
      AppMethodBeat.o(24058);
    }
    
    public final com.tencent.mm.plugin.exdevice.i.b Lo(int paramInt)
    {
      AppMethodBeat.i(24061);
      com.tencent.mm.plugin.exdevice.i.b localb = (com.tencent.mm.plugin.exdevice.i.b)this.yxt.get(paramInt);
      AppMethodBeat.o(24061);
      return localb;
    }
    
    public final void bz(List<com.tencent.mm.plugin.exdevice.i.b> paramList)
    {
      AppMethodBeat.i(24059);
      this.yxt.clear();
      if ((paramList == null) || (paramList.size() == 0))
      {
        AppMethodBeat.o(24059);
        return;
      }
      this.yxt.addAll(paramList);
      AppMethodBeat.o(24059);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(24060);
      int i = this.yxt.size();
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
      com.tencent.mm.plugin.exdevice.i.b localb = Lo(paramInt);
      View localView;
      if (paramView == null)
      {
        paramView = new a((byte)0);
        localView = View.inflate(paramViewGroup.getContext(), R.i.gjr, null);
        paramView.rIY = localView.findViewById(R.h.container);
        paramView.pUL = ((TextView)localView.findViewById(R.h.fOX));
        paramView.yAM = localView.findViewById(R.h.fEV);
        paramView.ttT = ((ImageView)localView.findViewById(R.h.iconIV));
        localView.setTag(paramView);
        paramViewGroup = paramView;
      }
      while (localb == null)
      {
        paramView = "";
        Log.d("MicroMsg.ExdeviceManageDeviceUI", "position(%s), name(%s), mac(%s).", new Object[] { Integer.valueOf(paramInt), paramView, Long.valueOf(localb.field_mac) });
        paramViewGroup.pUL.setText(paramView);
        r.bKe().a(localb.iconUrl, paramViewGroup.ttT, this.yxG);
        paramViewGroup.yAM.setTag(Integer.valueOf(paramInt));
        if (!this.yAG) {
          break label329;
        }
        paramViewGroup.yAM.setVisibility(0);
        label197:
        paramViewGroup.rIY.setTag(Integer.valueOf(paramInt));
        paramViewGroup.rIY.setOnClickListener(this.yAH);
        AppMethodBeat.o(24062);
        return localView;
        paramViewGroup = (a)paramView.getTag();
        localView = paramView;
      }
      if (!Util.isNullOrNil(localb.kDc)) {
        paramView = localb.kDc;
      }
      for (;;)
      {
        paramView = Util.nullAsNil(paramView);
        break;
        if (!Util.isNullOrNil(localb.kDd))
        {
          paramView = localb.kDd;
        }
        else if (localb.field_mac != 0L)
        {
          paramView = com.tencent.mm.plugin.exdevice.k.b.lO(localb.field_mac);
        }
        else
        {
          if (!Util.isNullOrNil(localb.field_deviceID))
          {
            paramView = localb.field_deviceID;
            continue;
            label329:
            paramViewGroup.yAM.setVisibility(8);
            break label197;
          }
          paramView = null;
        }
      }
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
    {
      AppMethodBeat.i(24063);
      if (paramp == null)
      {
        Log.e("MicroMsg.ExdeviceManageDeviceUI", "scene is null.");
        AppMethodBeat.o(24063);
        return;
      }
      if ((paramp instanceof ab))
      {
        if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
          this.tipDialog.dismiss();
        }
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          if ((this.yAJ < 0) || (this.yAJ >= this.yxt.size()))
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
      TextView pUL;
      View rIY;
      ImageView ttT;
      View yAM;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceManageDeviceUI
 * JD-Core Version:    0.7.0.1
 */