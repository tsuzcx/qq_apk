package com.tencent.mm.plugin.brandservice.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.b.d;
import com.tencent.mm.plugin.brandservice.b.k;
import com.tencent.mm.protocal.protobuf.bbm;
import com.tencent.mm.protocal.protobuf.bbo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.Iterator;
import java.util.LinkedList;

public class ReceiveTemplateMsgMgrUI
  extends MMPreference
  implements com.tencent.mm.ai.f
{
  private static LinkedList<bbm> jUI;
  private ProgressDialog eeN;
  protected com.tencent.mm.ui.base.preference.f iLA;
  private String jUH;
  private boolean jUJ = false;
  
  private void eO(boolean paramBoolean)
  {
    AppMethodBeat.i(14030);
    View localView1 = findViewById(2131827075);
    View localView2 = findViewById(2131827074);
    if (localView1 != null) {
      if (paramBoolean)
      {
        ((TextView)localView1).setVisibility(0);
        if (localView2 != null)
        {
          localView2.setVisibility(8);
          AppMethodBeat.o(14030);
        }
      }
      else
      {
        ((TextView)localView1).setVisibility(8);
        if (localView2 != null) {
          localView2.setVisibility(0);
        }
      }
    }
    AppMethodBeat.o(14030);
  }
  
  public int getHeaderResourceId()
  {
    return 2130970524;
  }
  
  public int getLayoutId()
  {
    return 2130970525;
  }
  
  public int getResourceId()
  {
    return 2131165261;
  }
  
  public void initView()
  {
    AppMethodBeat.i(14027);
    setMMTitle(2131298721);
    this.iLA = getPreferenceScreen();
    this.jUH = getIntent().getStringExtra("enterprise_biz_name");
    if (bo.isNullOrNil(this.jUH))
    {
      ab.e("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "bizName is null");
      finish();
      AppMethodBeat.o(14027);
      return;
    }
    setBackBtn(new ReceiveTemplateMsgMgrUI.1(this));
    d locald = new d(this.jUH);
    g.Rc().a(locald, 0);
    getString(2131297087);
    this.eeN = h.b(this, getString(2131302332), true, new ReceiveTemplateMsgMgrUI.2(this, locald));
    AppMethodBeat.o(14027);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(14024);
    super.onCreate(paramBundle);
    g.Rc().a(1031, this);
    g.Rc().a(1030, this);
    initView();
    AppMethodBeat.o(14024);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(14026);
    g.Rc().b(1031, this);
    g.Rc().b(1030, this);
    super.onDestroy();
    AppMethodBeat.o(14026);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(14025);
    if (this.jUJ)
    {
      ab.d("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "onPause option change");
      this.jUJ = false;
      k localk = new k(this.jUH, jUI);
      g.Rc().a(localk, 0);
    }
    super.onPause();
    AppMethodBeat.o(14025);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(14028);
    if (jUI == null)
    {
      ab.w("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "mRecvOptions == null");
      AppMethodBeat.o(14028);
      return false;
    }
    paramf = paramPreference.mKey;
    if (bo.isNullOrNil(paramf))
    {
      ab.e("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "key is null");
      AppMethodBeat.o(14028);
      return false;
    }
    Iterator localIterator = jUI.iterator();
    bbm localbbm;
    while (localIterator.hasNext())
    {
      localbbm = (bbm)localIterator.next();
      if (paramf.equals(bo.nullAsNil(localbbm.xqI)))
      {
        this.jUJ = true;
        if (!((CheckBoxPreference)paramPreference).isChecked()) {
          break label153;
        }
      }
    }
    label153:
    for (localbbm.woE = 0;; localbbm.woE = 1)
    {
      if (this.jUJ)
      {
        ab.d("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "option change, do scene");
        al.p(new ReceiveTemplateMsgMgrUI.3(this), 4000L);
      }
      AppMethodBeat.o(14028);
      return false;
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(14029);
    if (paramm == null)
    {
      ab.e("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "onSceneEnd: [%d], [%d], [%s], scene is null", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      AppMethodBeat.o(14029);
      return;
    }
    ab.i("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "onSceneEnd: [%d], [%d], [%s], sceneType[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramm.getType()) });
    if (paramm.getType() == 1031)
    {
      if ((this.eeN != null) && (this.eeN.isShowing()))
      {
        this.eeN.dismiss();
        this.eeN = null;
      }
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Toast.makeText(ah.getContext(), ah.getContext().getString(2131302329), 1).show();
        eO(true);
        AppMethodBeat.o(14029);
        return;
      }
      paramString = (d)paramm;
      if ((paramString.rr != null) && (paramString.rr.fsW.fta != null)) {}
      for (paramString = (bbo)paramString.rr.fsW.fta;; paramString = null)
      {
        jUI = paramString.xqJ;
        paramString = jUI;
        this.iLA.removeAll();
        if ((paramString != null) && (paramString.size() > 0)) {
          break;
        }
        ab.e("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "recvOption is empty");
        eO(true);
        AppMethodBeat.o(14029);
        return;
      }
      eO(false);
      ab.d("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "initBody options.size = %d", new Object[] { Integer.valueOf(paramString.size()) });
      paramString = paramString.iterator();
      if (paramString.hasNext())
      {
        paramm = (bbm)paramString.next();
        CheckBoxPreference localCheckBoxPreference = new CheckBoxPreference(this);
        localCheckBoxPreference.zsk = false;
        localCheckBoxPreference.setKey(paramm.xqI);
        localCheckBoxPreference.setTitle(paramm.Title);
        if (paramm.woE == 0) {}
        for (boolean bool = true;; bool = false)
        {
          localCheckBoxPreference.vxW = bool;
          this.iLA.b(localCheckBoxPreference);
          break;
        }
      }
      this.iLA.notifyDataSetChanged();
      ab.d("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "initBodyView finish");
      AppMethodBeat.o(14029);
      return;
    }
    if ((paramm.getType() == 1030) && ((paramInt1 != 0) || (paramInt2 != 0)))
    {
      Toast.makeText(ah.getContext(), ah.getContext().getString(2131302330), 0).show();
      AppMethodBeat.o(14029);
      return;
    }
    AppMethodBeat.o(14029);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.ReceiveTemplateMsgMgrUI
 * JD-Core Version:    0.7.0.1
 */