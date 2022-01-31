package com.tencent.mm.plugin.brandservice.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.b.d;
import com.tencent.mm.plugin.brandservice.b.e;
import com.tencent.mm.plugin.brandservice.b.h;
import com.tencent.mm.plugin.brandservice.b.i;
import com.tencent.mm.plugin.brandservice.b.d;
import com.tencent.mm.plugin.brandservice.b.k;
import com.tencent.mm.protocal.c.avc;
import com.tencent.mm.protocal.c.ave;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.Iterator;
import java.util.LinkedList;

public class ReceiveTemplateMsgMgrUI
  extends MMPreference
  implements com.tencent.mm.ah.f
{
  private static LinkedList<avc> idU;
  private ProgressDialog dnm;
  protected com.tencent.mm.ui.base.preference.f hcp;
  private String idT;
  private boolean idV = false;
  
  private void dB(boolean paramBoolean)
  {
    View localView1 = findViewById(b.d.receive_template_msg_empty_tips);
    View localView2 = findViewById(b.d.receive_template_msg_header_ll);
    if (localView1 != null)
    {
      if (!paramBoolean) {
        break label43;
      }
      ((TextView)localView1).setVisibility(0);
      if (localView2 != null) {
        localView2.setVisibility(8);
      }
    }
    label43:
    do
    {
      return;
      ((TextView)localView1).setVisibility(8);
    } while (localView2 == null);
    localView2.setVisibility(0);
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    if (idU == null) {
      y.w("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "mRecvOptions == null");
    }
    for (;;)
    {
      return false;
      paramf = paramPreference.mKey;
      if (bk.bl(paramf))
      {
        y.e("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "key is null");
        return false;
      }
      Iterator localIterator = idU.iterator();
      avc localavc;
      while (localIterator.hasNext())
      {
        localavc = (avc)localIterator.next();
        if (paramf.equals(bk.pm(localavc.tqI)))
        {
          this.idV = true;
          if (!((CheckBoxPreference)paramPreference).isChecked()) {
            break label129;
          }
        }
      }
      label129:
      for (localavc.svx = 0; this.idV; localavc.svx = 1)
      {
        y.d("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "option change, do scene");
        ai.l(new ReceiveTemplateMsgMgrUI.3(this), 4000L);
        return false;
      }
    }
  }
  
  public final int axE()
  {
    return b.e.receive_template_msg_header;
  }
  
  protected final int getLayoutId()
  {
    return b.e.receive_template_msg_mgr;
  }
  
  protected final void initView()
  {
    setMMTitle(b.h.contact_info_receive_tmp_msg_title);
    this.hcp = this.vdd;
    this.idT = getIntent().getStringExtra("enterprise_biz_name");
    if (bk.bl(this.idT))
    {
      y.e("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "bizName is null");
      finish();
      return;
    }
    setBackBtn(new ReceiveTemplateMsgMgrUI.1(this));
    d locald = new d(this.idT);
    g.Dk().a(locald, 0);
    getString(b.h.app_tip);
    this.dnm = h.b(this, getString(b.h.receive_template_msg_ui_waiting_get_options), true, new ReceiveTemplateMsgMgrUI.2(this, locald));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    g.Dk().a(1031, this);
    g.Dk().a(1030, this);
    initView();
  }
  
  protected void onDestroy()
  {
    g.Dk().b(1031, this);
    g.Dk().b(1030, this);
    super.onDestroy();
  }
  
  protected void onPause()
  {
    if (this.idV)
    {
      y.d("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "onPause option change");
      this.idV = false;
      k localk = new k(this.idT, idU);
      g.Dk().a(localk, 0);
    }
    super.onPause();
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    CheckBoxPreference localCheckBoxPreference = null;
    if (paramm == null) {
      y.e("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "onSceneEnd: [%d], [%d], [%s], scene is null", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    }
    do
    {
      return;
      y.i("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "onSceneEnd: [%d], [%d], [%s], sceneType[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramm.getType()) });
      if (paramm.getType() == 1031)
      {
        if ((this.dnm != null) && (this.dnm.isShowing()))
        {
          this.dnm.dismiss();
          this.dnm = null;
        }
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          Toast.makeText(ae.getContext(), ae.getContext().getString(b.h.receive_template_msg_ui_fail_get_options), 1).show();
          dB(true);
          return;
        }
        paramm = (d)paramm;
        paramString = localCheckBoxPreference;
        if (paramm.dmK != null)
        {
          paramString = localCheckBoxPreference;
          if (paramm.dmK.ecF.ecN != null) {
            paramString = (ave)paramm.dmK.ecF.ecN;
          }
        }
        idU = paramString.tqJ;
        paramString = idU;
        this.hcp.removeAll();
        if ((paramString == null) || (paramString.size() <= 0))
        {
          y.e("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "recvOption is empty");
          dB(true);
          return;
        }
        dB(false);
        y.d("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "initBody options.size = %d", new Object[] { Integer.valueOf(paramString.size()) });
        paramString = paramString.iterator();
        if (paramString.hasNext())
        {
          paramm = (avc)paramString.next();
          localCheckBoxPreference = new CheckBoxPreference(this);
          localCheckBoxPreference.vdK = false;
          localCheckBoxPreference.setKey(paramm.tqI);
          localCheckBoxPreference.setTitle(paramm.bGw);
          if (paramm.svx == 0) {}
          for (boolean bool = true;; bool = false)
          {
            localCheckBoxPreference.rHo = bool;
            this.hcp.a(localCheckBoxPreference);
            break;
          }
        }
        this.hcp.notifyDataSetChanged();
        y.d("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "initBodyView finish");
        return;
      }
    } while ((paramm.getType() != 1030) || ((paramInt1 == 0) && (paramInt2 == 0)));
    Toast.makeText(ae.getContext(), ae.getContext().getString(b.h.receive_template_msg_ui_fail_set_options), 0).show();
  }
  
  public final int xj()
  {
    return b.i.receive_template_msg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.ReceiveTemplateMsgMgrUI
 * JD-Core Version:    0.7.0.1
 */