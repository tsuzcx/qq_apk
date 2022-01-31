package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.as.a.a.c.a;
import com.tencent.mm.as.o;
import com.tencent.mm.h.a.di;
import com.tencent.mm.h.c.cc;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.x;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.j;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;

public class ExdeviceManageDeviceUI
  extends MMActivity
{
  private ListView Nn;
  private a jDA;
  
  protected final int getLayoutId()
  {
    return R.i.exdevice_manage_device_ui;
  }
  
  protected final void initView()
  {
    this.Nn = ((ListView)findViewById(R.h.listview));
    this.jDA = new a(this);
    View.inflate(this, R.i.exdevice_bind_device_ui_footer, null);
    this.Nn.setAdapter(this.jDA);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.jDA.bc(ad.aLL().aMq());
    this.jDA.notifyDataSetChanged();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setBackBtn(new ExdeviceManageDeviceUI.1(this));
    setMMTitle(R.l.exdevice_manage_device_title);
    paramBundle = new di();
    paramBundle.bJE.bJF = true;
    com.tencent.mm.sdk.b.a.udP.m(paramBundle);
    initView();
    au.Dk().a(537, this.jDA);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    au.Dk().b(537, this.jDA);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0) && (this.jDA.jDC))
    {
      updateOptionMenuText(0, getString(R.l.app_edit));
      paramKeyEvent = this.jDA;
      if (paramKeyEvent.jDC)
      {
        paramKeyEvent.jDC = false;
        ai.d(new ExdeviceManageDeviceUI.a.5(paramKeyEvent));
      }
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  private static final class a
    extends BaseAdapter
    implements f
  {
    private n.d iew;
    private com.tencent.mm.as.a.a.c jAJ;
    private List<com.tencent.mm.plugin.exdevice.h.b> jAv;
    boolean jDC;
    private WeakReference<Context> jDD;
    private View.OnClickListener jDE;
    private j jDF;
    private volatile int jDG = -1;
    private com.tencent.mm.ui.base.p tipDialog = null;
    
    public a(Context paramContext)
    {
      this.jDD = new WeakReference(paramContext);
      this.jAv = new LinkedList();
      this.jDF = new j(paramContext);
      paramContext = new c.a();
      paramContext.eru = R.g.exdevice_my_device_default_icon;
      this.jAJ = paramContext.OV();
      this.iew = new ExdeviceManageDeviceUI.a.1(this);
      this.jDE = new ExdeviceManageDeviceUI.a.2(this);
      bc(ad.aLL().aMq());
    }
    
    public final void bc(List<com.tencent.mm.plugin.exdevice.h.b> paramList)
    {
      this.jAv.clear();
      if ((paramList == null) || (paramList.size() == 0)) {
        return;
      }
      this.jAv.addAll(paramList);
    }
    
    public final int getCount()
    {
      return this.jAv.size();
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      com.tencent.mm.plugin.exdevice.h.b localb = qy(paramInt);
      View localView;
      if (paramView == null)
      {
        paramView = new ExdeviceManageDeviceUI.a.a((byte)0);
        localView = View.inflate(paramViewGroup.getContext(), R.i.exdevice_manage_device_item, null);
        paramView.jDJ = localView.findViewById(R.h.container);
        paramView.fhD = ((TextView)localView.findViewById(R.h.nameTV));
        paramView.jDK = localView.findViewById(R.h.deleteV);
        paramView.gSx = ((ImageView)localView.findViewById(R.h.iconIV));
        localView.setTag(paramView);
        paramViewGroup = paramView;
      }
      while (localb == null)
      {
        paramView = "";
        y.d("MicroMsg.ExdeviceManageDeviceUI", "position(%s), name(%s), mac(%s).", new Object[] { Integer.valueOf(paramInt), paramView, Long.valueOf(localb.field_mac) });
        paramViewGroup.fhD.setText(paramView);
        o.ON().a(localb.iconUrl, paramViewGroup.gSx, this.jAJ);
        paramViewGroup.jDK.setTag(Integer.valueOf(paramInt));
        if (!this.jDC) {
          break label317;
        }
        paramViewGroup.jDK.setVisibility(0);
        label191:
        paramViewGroup.jDJ.setTag(Integer.valueOf(paramInt));
        paramViewGroup.jDJ.setOnClickListener(this.jDE);
        return localView;
        paramViewGroup = (ExdeviceManageDeviceUI.a.a)paramView.getTag();
        localView = paramView;
      }
      if (!bk.bl(localb.cMT)) {
        paramView = localb.cMT;
      }
      for (;;)
      {
        paramView = bk.pm(paramView);
        break;
        if (!bk.bl(localb.cMU))
        {
          paramView = localb.cMU;
        }
        else if (localb.field_mac != 0L)
        {
          paramView = com.tencent.mm.plugin.exdevice.j.b.ee(localb.field_mac);
        }
        else
        {
          if (!bk.bl(localb.field_deviceID))
          {
            paramView = localb.field_deviceID;
            continue;
            label317:
            paramViewGroup.jDK.setVisibility(8);
            break label191;
          }
          paramView = null;
        }
      }
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
    {
      if (paramm == null) {
        y.e("MicroMsg.ExdeviceManageDeviceUI", "scene is null.");
      }
      do
      {
        do
        {
          return;
        } while (!(paramm instanceof x));
        if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
          this.tipDialog.dismiss();
        }
      } while ((paramInt1 != 0) || (paramInt2 != 0) || (this.jDG < 0) || (this.jDG >= this.jAv.size()));
      ai.d(new ExdeviceManageDeviceUI.a.6(this));
    }
    
    public final com.tencent.mm.plugin.exdevice.h.b qy(int paramInt)
    {
      return (com.tencent.mm.plugin.exdevice.h.b)this.jAv.get(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceManageDeviceUI
 * JD-Core Version:    0.7.0.1
 */